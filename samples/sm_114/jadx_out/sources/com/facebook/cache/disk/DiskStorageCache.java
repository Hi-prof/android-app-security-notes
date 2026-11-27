package com.facebook.cache.disk;

/* JADX INFO: loaded from: classes.dex */
public class DiskStorageCache implements com.facebook.cache.disk.FileCache, com.facebook.common.disk.DiskTrimmable {
    public static final int START_OF_VERSIONING = 1;
    private static final double TRIMMING_LOWER_BOUND = 0.02d;
    private static final long UNINITIALIZED = -1;
    private final com.facebook.cache.common.CacheErrorLogger mCacheErrorLogger;

    @javax.annotation.Nullable
    private final com.facebook.cache.common.CacheEventListener mCacheEventListener;
    private long mCacheSizeLimit;
    private final long mCacheSizeLimitMinimum;
    private final java.util.concurrent.CountDownLatch mCountDownLatch;
    private final long mDefaultCacheSizeLimit;
    private final com.facebook.cache.disk.EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
    private final boolean mIndexPopulateAtStartupEnabled;
    private boolean mIndexReady;
    private final long mLowDiskSpaceCacheSizeLimit;
    private final com.facebook.cache.disk.DiskStorage mStorage;
    private static final java.lang.Class<?> TAG = com.facebook.cache.disk.DiskStorageCache.class;
    private static final long FUTURE_TIMESTAMP_THRESHOLD_MS = java.util.concurrent.TimeUnit.HOURS.toMillis(2);
    private static final long FILECACHE_SIZE_UPDATE_PERIOD_MS = java.util.concurrent.TimeUnit.MINUTES.toMillis(30);
    private final java.lang.Object mLock = new java.lang.Object();
    private final com.facebook.common.statfs.StatFsHelper mStatFsHelper = com.facebook.common.statfs.StatFsHelper.getInstance();
    private long mCacheSizeLastUpdateTime = -1;
    private final com.facebook.cache.disk.DiskStorageCache.CacheStats mCacheStats = new com.facebook.cache.disk.DiskStorageCache.CacheStats();
    private final com.facebook.common.time.Clock mClock = com.facebook.common.time.SystemClock.get();
    final java.util.Set<java.lang.String> mResourceIndex = new java.util.HashSet();

    static class CacheStats {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long mCount = -1;

        CacheStats() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.mCount = -1L;
            this.mSize = -1L;
        }

        public synchronized void set(long j, long j2) {
            this.mCount = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void increment(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.mCount += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.mCount;
        }
    }

    public static class Params {
        public final long mCacheSizeLimitMinimum;
        public final long mDefaultCacheSizeLimit;
        public final long mLowDiskSpaceCacheSizeLimit;

        public Params(long j, long j2, long j3) {
            this.mCacheSizeLimitMinimum = j;
            this.mLowDiskSpaceCacheSizeLimit = j2;
            this.mDefaultCacheSizeLimit = j3;
        }
    }

    public DiskStorageCache(com.facebook.cache.disk.DiskStorage diskStorage, com.facebook.cache.disk.EntryEvictionComparatorSupplier entryEvictionComparatorSupplier, com.facebook.cache.disk.DiskStorageCache.Params params, @javax.annotation.Nullable com.facebook.cache.common.CacheEventListener cacheEventListener, com.facebook.cache.common.CacheErrorLogger cacheErrorLogger, @javax.annotation.Nullable com.facebook.common.disk.DiskTrimmableRegistry diskTrimmableRegistry, java.util.concurrent.Executor executor, boolean z) {
        this.mLowDiskSpaceCacheSizeLimit = params.mLowDiskSpaceCacheSizeLimit;
        this.mDefaultCacheSizeLimit = params.mDefaultCacheSizeLimit;
        this.mCacheSizeLimit = params.mDefaultCacheSizeLimit;
        this.mStorage = diskStorage;
        this.mEntryEvictionComparatorSupplier = entryEvictionComparatorSupplier;
        this.mCacheEventListener = cacheEventListener;
        this.mCacheSizeLimitMinimum = params.mCacheSizeLimitMinimum;
        this.mCacheErrorLogger = cacheErrorLogger;
        this.mIndexPopulateAtStartupEnabled = z;
        if (diskTrimmableRegistry != null) {
            diskTrimmableRegistry.registerDiskTrimmable(this);
        }
        if (z) {
            this.mCountDownLatch = new java.util.concurrent.CountDownLatch(1);
            executor.execute(new java.lang.Runnable() { // from class: com.facebook.cache.disk.DiskStorageCache.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (com.facebook.cache.disk.DiskStorageCache.this.mLock) {
                        com.facebook.cache.disk.DiskStorageCache.this.maybeUpdateFileCacheSize();
                    }
                    com.facebook.cache.disk.DiskStorageCache.this.mIndexReady = true;
                    com.facebook.cache.disk.DiskStorageCache.this.mCountDownLatch.countDown();
                }
            });
        } else {
            this.mCountDownLatch = new java.util.concurrent.CountDownLatch(0);
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public com.facebook.cache.disk.DiskStorage.DiskDumpInfo getDumpInfo() throws java.io.IOException {
        return this.mStorage.getDumpInfo();
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean isEnabled() {
        return this.mStorage.isEnabled();
    }

    protected void awaitIndex() {
        try {
            this.mCountDownLatch.await();
        } catch (java.lang.InterruptedException unused) {
            com.facebook.common.logging.FLog.e(TAG, "Memory Index is not ready yet. ");
        }
    }

    public boolean isIndexReady() {
        return this.mIndexReady || !this.mIndexPopulateAtStartupEnabled;
    }

    @Override // com.facebook.cache.disk.FileCache
    @javax.annotation.Nullable
    public com.facebook.binaryresource.BinaryResource getResource(com.facebook.cache.common.CacheKey cacheKey) {
        com.facebook.binaryresource.BinaryResource resource;
        com.facebook.cache.disk.SettableCacheEvent cacheKey2 = com.facebook.cache.disk.SettableCacheEvent.obtain().setCacheKey(cacheKey);
        try {
            try {
                synchronized (this.mLock) {
                    java.util.List<java.lang.String> resourceIds = com.facebook.cache.common.CacheKeyUtil.getResourceIds(cacheKey);
                    java.lang.String str = null;
                    resource = null;
                    for (int i = 0; i < resourceIds.size(); i++) {
                        str = resourceIds.get(i);
                        cacheKey2.setResourceId(str);
                        resource = this.mStorage.getResource(str, cacheKey);
                        if (resource != null) {
                            break;
                        }
                    }
                    if (resource == null) {
                        com.facebook.cache.common.CacheEventListener cacheEventListener = this.mCacheEventListener;
                        if (cacheEventListener != null) {
                            cacheEventListener.onMiss(cacheKey2);
                        }
                        this.mResourceIndex.remove(str);
                    } else {
                        com.facebook.common.internal.Preconditions.checkNotNull(str);
                        com.facebook.cache.common.CacheEventListener cacheEventListener2 = this.mCacheEventListener;
                        if (cacheEventListener2 != null) {
                            cacheEventListener2.onHit(cacheKey2);
                        }
                        this.mResourceIndex.add(str);
                    }
                }
                cacheKey2.recycle();
                return resource;
            } catch (java.io.IOException e) {
                this.mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "getResource", e);
                cacheKey2.setException(e);
                com.facebook.cache.common.CacheEventListener cacheEventListener3 = this.mCacheEventListener;
                if (cacheEventListener3 != null) {
                    cacheEventListener3.onReadException(cacheKey2);
                }
                cacheKey2.recycle();
                return null;
            }
        } catch (java.lang.Throwable th) {
            cacheKey2.recycle();
            throw th;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean probe(com.facebook.cache.common.CacheKey cacheKey) throws java.lang.Throwable {
        java.lang.String str;
        java.io.IOException e;
        java.lang.String str2 = null;
        try {
            try {
                synchronized (this.mLock) {
                    try {
                        java.util.List<java.lang.String> resourceIds = com.facebook.cache.common.CacheKeyUtil.getResourceIds(cacheKey);
                        int i = 0;
                        while (i < resourceIds.size()) {
                            java.lang.String str3 = resourceIds.get(i);
                            if (this.mStorage.touch(str3, cacheKey)) {
                                this.mResourceIndex.add(str3);
                                return true;
                            }
                            i++;
                            str2 = str3;
                        }
                        return false;
                    } catch (java.lang.Throwable th) {
                        str = str2;
                        th = th;
                        try {
                            throw th;
                        } catch (java.io.IOException e2) {
                            e = e2;
                            com.facebook.cache.disk.SettableCacheEvent exception = com.facebook.cache.disk.SettableCacheEvent.obtain().setCacheKey(cacheKey).setResourceId(str).setException(e);
                            com.facebook.cache.common.CacheEventListener cacheEventListener = this.mCacheEventListener;
                            if (cacheEventListener != null) {
                                cacheEventListener.onReadException(exception);
                            }
                            exception.recycle();
                            return false;
                        }
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.IOException e3) {
            str = null;
            e = e3;
        }
    }

    private com.facebook.cache.disk.DiskStorage.Inserter startInsert(java.lang.String str, com.facebook.cache.common.CacheKey cacheKey) throws java.io.IOException {
        maybeEvictFilesInCacheDir();
        return this.mStorage.insert(str, cacheKey);
    }

    private com.facebook.binaryresource.BinaryResource endInsert(com.facebook.cache.disk.DiskStorage.Inserter inserter, com.facebook.cache.common.CacheKey cacheKey, java.lang.String str) throws java.io.IOException {
        com.facebook.binaryresource.BinaryResource binaryResourceCommit;
        synchronized (this.mLock) {
            binaryResourceCommit = inserter.commit(cacheKey);
            this.mResourceIndex.add(str);
            this.mCacheStats.increment(binaryResourceCommit.size(), 1L);
        }
        return binaryResourceCommit;
    }

    @Override // com.facebook.cache.disk.FileCache
    public com.facebook.binaryresource.BinaryResource insert(com.facebook.cache.common.CacheKey cacheKey, com.facebook.cache.common.WriterCallback writerCallback) throws java.io.IOException {
        java.lang.String firstResourceId;
        com.facebook.cache.disk.SettableCacheEvent cacheKey2 = com.facebook.cache.disk.SettableCacheEvent.obtain().setCacheKey(cacheKey);
        com.facebook.cache.common.CacheEventListener cacheEventListener = this.mCacheEventListener;
        if (cacheEventListener != null) {
            cacheEventListener.onWriteAttempt(cacheKey2);
        }
        synchronized (this.mLock) {
            firstResourceId = com.facebook.cache.common.CacheKeyUtil.getFirstResourceId(cacheKey);
        }
        cacheKey2.setResourceId(firstResourceId);
        try {
            try {
                com.facebook.cache.disk.DiskStorage.Inserter inserterStartInsert = startInsert(firstResourceId, cacheKey);
                try {
                    inserterStartInsert.writeData(writerCallback, cacheKey);
                    com.facebook.binaryresource.BinaryResource binaryResourceEndInsert = endInsert(inserterStartInsert, cacheKey, firstResourceId);
                    cacheKey2.setItemSize(binaryResourceEndInsert.size()).setCacheSize(this.mCacheStats.getSize());
                    com.facebook.cache.common.CacheEventListener cacheEventListener2 = this.mCacheEventListener;
                    if (cacheEventListener2 != null) {
                        cacheEventListener2.onWriteSuccess(cacheKey2);
                    }
                    if (!inserterStartInsert.cleanUp()) {
                        com.facebook.common.logging.FLog.e(TAG, "Failed to delete temp file");
                    }
                    cacheKey2.recycle();
                    return binaryResourceEndInsert;
                } catch (java.lang.Throwable th) {
                    if (!inserterStartInsert.cleanUp()) {
                        com.facebook.common.logging.FLog.e(TAG, "Failed to delete temp file");
                    }
                    throw th;
                }
            } catch (java.io.IOException e) {
                cacheKey2.setException(e);
                com.facebook.cache.common.CacheEventListener cacheEventListener3 = this.mCacheEventListener;
                if (cacheEventListener3 != null) {
                    cacheEventListener3.onWriteException(cacheKey2);
                }
                com.facebook.common.logging.FLog.e(TAG, "Failed inserting a file into the cache", e);
                throw e;
            }
        } catch (java.lang.Throwable th2) {
            cacheKey2.recycle();
            throw th2;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public void remove(com.facebook.cache.common.CacheKey cacheKey) {
        synchronized (this.mLock) {
            try {
                java.util.List<java.lang.String> resourceIds = com.facebook.cache.common.CacheKeyUtil.getResourceIds(cacheKey);
                for (int i = 0; i < resourceIds.size(); i++) {
                    java.lang.String str = resourceIds.get(i);
                    this.mStorage.remove(str);
                    this.mResourceIndex.remove(str);
                }
            } catch (java.io.IOException e) {
                this.mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.DELETE_FILE, TAG, "delete: " + e.getMessage(), e);
            }
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public long clearOldEntries(long j) {
        long j2;
        long jMax;
        synchronized (this.mLock) {
            try {
                long jNow = this.mClock.now();
                java.util.Collection<com.facebook.cache.disk.DiskStorage.Entry> entries = this.mStorage.getEntries();
                long size = this.mCacheStats.getSize();
                int i = 0;
                long j3 = 0;
                jMax = 0;
                for (com.facebook.cache.disk.DiskStorage.Entry entry : entries) {
                    try {
                        long j4 = jNow;
                        long jMax2 = java.lang.Math.max(1L, java.lang.Math.abs(jNow - entry.getTimestamp()));
                        if (jMax2 >= j) {
                            long jRemove = this.mStorage.remove(entry);
                            this.mResourceIndex.remove(entry.getId());
                            if (jRemove > 0) {
                                i++;
                                j3 += jRemove;
                                com.facebook.cache.disk.SettableCacheEvent cacheSize = com.facebook.cache.disk.SettableCacheEvent.obtain().setResourceId(entry.getId()).setEvictionReason(com.facebook.cache.common.CacheEventListener.EvictionReason.CONTENT_STALE).setItemSize(jRemove).setCacheSize(size - j3);
                                com.facebook.cache.common.CacheEventListener cacheEventListener = this.mCacheEventListener;
                                if (cacheEventListener != null) {
                                    cacheEventListener.onEviction(cacheSize);
                                }
                                cacheSize.recycle();
                            }
                        } else {
                            jMax = java.lang.Math.max(jMax, jMax2);
                        }
                        jNow = j4;
                    } catch (java.io.IOException e) {
                        e = e;
                        j2 = jMax;
                        this.mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearOldEntries: " + e.getMessage(), e);
                        jMax = j2;
                    }
                }
                this.mStorage.purgeUnexpectedResources();
                if (i > 0) {
                    maybeUpdateFileCacheSize();
                    this.mCacheStats.increment(-j3, -i);
                }
            } catch (java.io.IOException e2) {
                e = e2;
                j2 = 0;
            }
        }
        return jMax;
    }

    private void maybeEvictFilesInCacheDir() throws java.io.IOException {
        synchronized (this.mLock) {
            boolean zMaybeUpdateFileCacheSize = maybeUpdateFileCacheSize();
            updateFileCacheSizeLimit();
            long size = this.mCacheStats.getSize();
            if (size > this.mCacheSizeLimit && !zMaybeUpdateFileCacheSize) {
                this.mCacheStats.reset();
                maybeUpdateFileCacheSize();
            }
            long j = this.mCacheSizeLimit;
            if (size > j) {
                evictAboveSize((j * 9) / 10, com.facebook.cache.common.CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    private void evictAboveSize(long j, com.facebook.cache.common.CacheEventListener.EvictionReason evictionReason) throws java.io.IOException {
        try {
            java.util.Collection<com.facebook.cache.disk.DiskStorage.Entry> sortedEntries = getSortedEntries(this.mStorage.getEntries());
            long size = this.mCacheStats.getSize();
            long j2 = size - j;
            int i = 0;
            long j3 = 0;
            for (com.facebook.cache.disk.DiskStorage.Entry entry : sortedEntries) {
                if (j3 > j2) {
                    break;
                }
                long jRemove = this.mStorage.remove(entry);
                this.mResourceIndex.remove(entry.getId());
                if (jRemove > 0) {
                    i++;
                    j3 += jRemove;
                    com.facebook.cache.disk.SettableCacheEvent cacheLimit = com.facebook.cache.disk.SettableCacheEvent.obtain().setResourceId(entry.getId()).setEvictionReason(evictionReason).setItemSize(jRemove).setCacheSize(size - j3).setCacheLimit(j);
                    com.facebook.cache.common.CacheEventListener cacheEventListener = this.mCacheEventListener;
                    if (cacheEventListener != null) {
                        cacheEventListener.onEviction(cacheLimit);
                    }
                    cacheLimit.recycle();
                }
            }
            this.mCacheStats.increment(-j3, -i);
            this.mStorage.purgeUnexpectedResources();
        } catch (java.io.IOException e) {
            this.mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private java.util.Collection<com.facebook.cache.disk.DiskStorage.Entry> getSortedEntries(java.util.Collection<com.facebook.cache.disk.DiskStorage.Entry> collection) {
        long jNow = this.mClock.now() + FUTURE_TIMESTAMP_THRESHOLD_MS;
        java.util.ArrayList arrayList = new java.util.ArrayList(collection.size());
        java.util.ArrayList arrayList2 = new java.util.ArrayList(collection.size());
        for (com.facebook.cache.disk.DiskStorage.Entry entry : collection) {
            if (entry.getTimestamp() > jNow) {
                arrayList.add(entry);
            } else {
                arrayList2.add(entry);
            }
        }
        java.util.Collections.sort(arrayList2, this.mEntryEvictionComparatorSupplier.get());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    private void updateFileCacheSizeLimit() {
        com.facebook.common.statfs.StatFsHelper.StorageType storageType;
        if (this.mStorage.isExternal()) {
            storageType = com.facebook.common.statfs.StatFsHelper.StorageType.EXTERNAL;
        } else {
            storageType = com.facebook.common.statfs.StatFsHelper.StorageType.INTERNAL;
        }
        if (this.mStatFsHelper.testLowDiskSpace(storageType, this.mDefaultCacheSizeLimit - this.mCacheStats.getSize())) {
            this.mCacheSizeLimit = this.mLowDiskSpaceCacheSizeLimit;
        } else {
            this.mCacheSizeLimit = this.mDefaultCacheSizeLimit;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public long getSize() {
        return this.mCacheStats.getSize();
    }

    @Override // com.facebook.cache.disk.FileCache
    public long getCount() {
        return this.mCacheStats.getCount();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.facebook.cache.disk.FileCache
    public void clearAll() {
        synchronized (this.mLock) {
            try {
                this.mStorage.clearAll();
                this.mResourceIndex.clear();
                com.facebook.cache.common.CacheEventListener cacheEventListener = this.mCacheEventListener;
                if (cacheEventListener != null) {
                    cacheEventListener.onCleared();
                }
            } catch (java.io.IOException | java.lang.NullPointerException e) {
                this.mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearAll: " + e.getMessage(), e);
            }
            this.mCacheStats.reset();
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean hasKeySync(com.facebook.cache.common.CacheKey cacheKey) {
        synchronized (this.mLock) {
            java.util.List<java.lang.String> resourceIds = com.facebook.cache.common.CacheKeyUtil.getResourceIds(cacheKey);
            for (int i = 0; i < resourceIds.size(); i++) {
                if (this.mResourceIndex.contains(resourceIds.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.facebook.cache.disk.FileCache
    public boolean hasKey(com.facebook.cache.common.CacheKey cacheKey) {
        synchronized (this.mLock) {
            if (hasKeySync(cacheKey)) {
                return true;
            }
            try {
                java.util.List<java.lang.String> resourceIds = com.facebook.cache.common.CacheKeyUtil.getResourceIds(cacheKey);
                for (int i = 0; i < resourceIds.size(); i++) {
                    java.lang.String str = resourceIds.get(i);
                    if (this.mStorage.contains(str, cacheKey)) {
                        this.mResourceIndex.add(str);
                        return true;
                    }
                }
                return false;
            } catch (java.io.IOException unused) {
                return false;
            }
        }
    }

    @Override // com.facebook.common.disk.DiskTrimmable
    public void trimToMinimum() {
        synchronized (this.mLock) {
            maybeUpdateFileCacheSize();
            long size = this.mCacheStats.getSize();
            long j = this.mCacheSizeLimitMinimum;
            if (j > 0 && size > 0 && size >= j) {
                double d = 1.0d - (j / size);
                if (d > TRIMMING_LOWER_BOUND) {
                    trimBy(d);
                }
            }
        }
    }

    @Override // com.facebook.common.disk.DiskTrimmable
    public void trimToNothing() {
        clearAll();
    }

    private void trimBy(double d) {
        synchronized (this.mLock) {
            try {
                this.mCacheStats.reset();
                maybeUpdateFileCacheSize();
                long size = this.mCacheStats.getSize();
                evictAboveSize(size - ((long) (d * size)), com.facebook.cache.common.CacheEventListener.EvictionReason.CACHE_MANAGER_TRIMMED);
            } catch (java.io.IOException e) {
                this.mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "trimBy: " + e.getMessage(), e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean maybeUpdateFileCacheSize() {
        long jNow = this.mClock.now();
        if (this.mCacheStats.isInitialized()) {
            long j = this.mCacheSizeLastUpdateTime;
            if (j != -1 && jNow - j <= FILECACHE_SIZE_UPDATE_PERIOD_MS) {
                return false;
            }
        }
        return maybeUpdateFileCacheSizeAndIndex();
    }

    private boolean maybeUpdateFileCacheSizeAndIndex() {
        java.util.Set<java.lang.String> hashSet;
        boolean z;
        long j;
        long jNow = this.mClock.now();
        long j2 = FUTURE_TIMESTAMP_THRESHOLD_MS + jNow;
        if (this.mIndexPopulateAtStartupEnabled && this.mResourceIndex.isEmpty()) {
            hashSet = this.mResourceIndex;
        } else {
            hashSet = this.mIndexPopulateAtStartupEnabled ? new java.util.HashSet<>() : null;
        }
        try {
            long size = 0;
            long jMax = -1;
            int size2 = 0;
            boolean z2 = false;
            int i = 0;
            int i2 = 0;
            z = false;
            for (com.facebook.cache.disk.DiskStorage.Entry entry : this.mStorage.getEntries()) {
                try {
                    i++;
                    size += entry.getSize();
                    if (entry.getTimestamp() > j2) {
                        i2++;
                        size2 = (int) (((long) size2) + entry.getSize());
                        j = j2;
                        jMax = java.lang.Math.max(entry.getTimestamp() - jNow, jMax);
                        z2 = true;
                    } else {
                        j = j2;
                        if (this.mIndexPopulateAtStartupEnabled) {
                            com.facebook.common.internal.Preconditions.checkNotNull(hashSet);
                            hashSet.add(entry.getId());
                        }
                    }
                    j2 = j;
                } catch (java.io.IOException e) {
                    e = e;
                    this.mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "calcFileCacheSize: " + e.getMessage(), e);
                    return z;
                }
            }
            if (z2) {
                this.mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, TAG, "Future timestamp found in " + i2 + " files , with a total size of " + size2 + " bytes, and a maximum time delta of " + jMax + "ms", null);
            }
            long j3 = i;
            if (this.mCacheStats.getCount() != j3 || this.mCacheStats.getSize() != size) {
                if (this.mIndexPopulateAtStartupEnabled && this.mResourceIndex != hashSet) {
                    com.facebook.common.internal.Preconditions.checkNotNull(hashSet);
                    this.mResourceIndex.clear();
                    this.mResourceIndex.addAll(hashSet);
                }
                this.mCacheStats.set(size, j3);
            }
            this.mCacheSizeLastUpdateTime = jNow;
            return true;
        } catch (java.io.IOException e2) {
            e = e2;
            z = false;
        }
    }
}
