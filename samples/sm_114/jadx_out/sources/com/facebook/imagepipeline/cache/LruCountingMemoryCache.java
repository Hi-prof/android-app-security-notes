package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes.dex */
public class LruCountingMemoryCache<K, V> implements com.facebook.imagepipeline.cache.CountingMemoryCache<K, V>, com.facebook.imagepipeline.cache.MemoryCache<K, V>, com.facebook.cache.common.HasDebugData {
    private final com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy mCacheTrimStrategy;
    final com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> mCachedEntries;

    @javax.annotation.Nullable
    private final com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver<K> mEntryStateObserver;
    final com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> mExclusiveEntries;
    private final boolean mIgnoreSizeMismatch;
    protected com.facebook.imagepipeline.cache.MemoryCacheParams mMemoryCacheParams;
    private final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams> mMemoryCacheParamsSupplier;
    private final boolean mStoreEntrySize;
    private final com.facebook.imagepipeline.cache.ValueDescriptor<V> mValueDescriptor;
    final java.util.Map<android.graphics.Bitmap, java.lang.Object> mOtherEntries = new java.util.WeakHashMap();
    private long mLastCacheParamsCheck = android.os.SystemClock.uptimeMillis();

    public LruCountingMemoryCache(com.facebook.imagepipeline.cache.ValueDescriptor<V> valueDescriptor, com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy cacheTrimStrategy, com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams> supplier, @javax.annotation.Nullable com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver<K> entryStateObserver, boolean z, boolean z2) {
        this.mValueDescriptor = valueDescriptor;
        this.mExclusiveEntries = new com.facebook.imagepipeline.cache.CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCachedEntries = new com.facebook.imagepipeline.cache.CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCacheTrimStrategy = cacheTrimStrategy;
        this.mMemoryCacheParamsSupplier = supplier;
        this.mMemoryCacheParams = (com.facebook.imagepipeline.cache.MemoryCacheParams) com.facebook.common.internal.Preconditions.checkNotNull(supplier.get(), "mMemoryCacheParamsSupplier returned null");
        this.mEntryStateObserver = entryStateObserver;
        this.mStoreEntrySize = z;
        this.mIgnoreSizeMismatch = z2;
    }

    private com.facebook.imagepipeline.cache.ValueDescriptor<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> wrapValueDescriptor(final com.facebook.imagepipeline.cache.ValueDescriptor<V> valueDescriptor) {
        return new com.facebook.imagepipeline.cache.ValueDescriptor<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>>() { // from class: com.facebook.imagepipeline.cache.LruCountingMemoryCache.1
            @Override // com.facebook.imagepipeline.cache.ValueDescriptor
            public int getSizeInBytes(com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
                if (com.facebook.imagepipeline.cache.LruCountingMemoryCache.this.mStoreEntrySize) {
                    return entry.size;
                }
                return valueDescriptor.getSizeInBytes(entry.valueRef.get());
            }
        };
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<V> cache(K k, com.facebook.common.references.CloseableReference<V> closeableReference) {
        return cache(k, closeableReference, this.mEntryStateObserver);
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<V> cache(K k, com.facebook.common.references.CloseableReference<V> closeableReference, @javax.annotation.Nullable com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver<K> entryStateObserver) {
        com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entryRemove;
        com.facebook.common.references.CloseableReference<V> closeableReferenceNewClientReference;
        com.facebook.common.references.CloseableReference<V> closeableReferenceReferenceToClose;
        com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entryOf;
        com.facebook.common.internal.Preconditions.checkNotNull(k);
        com.facebook.common.internal.Preconditions.checkNotNull(closeableReference);
        maybeUpdateCacheParams();
        synchronized (this) {
            entryRemove = this.mExclusiveEntries.remove(k);
            com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entryRemove2 = this.mCachedEntries.remove(k);
            closeableReferenceNewClientReference = null;
            if (entryRemove2 != null) {
                makeOrphan(entryRemove2);
                closeableReferenceReferenceToClose = referenceToClose(entryRemove2);
            } else {
                closeableReferenceReferenceToClose = null;
            }
            int sizeInBytes = this.mValueDescriptor.getSizeInBytes(closeableReference.get());
            if (canCacheNewValueOfSize(sizeInBytes)) {
                if (this.mStoreEntrySize) {
                    entryOf = com.facebook.imagepipeline.cache.CountingMemoryCache.Entry.of(k, closeableReference, sizeInBytes, entryStateObserver);
                } else {
                    entryOf = com.facebook.imagepipeline.cache.CountingMemoryCache.Entry.of(k, closeableReference, entryStateObserver);
                }
                this.mCachedEntries.put(k, entryOf);
                closeableReferenceNewClientReference = newClientReference(entryOf);
            }
        }
        com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReferenceReferenceToClose);
        maybeNotifyExclusiveEntryRemoval(entryRemove);
        maybeEvictEntries();
        return closeableReferenceNewClientReference;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001f  */
    private synchronized boolean canCacheNewValueOfSize(int i) {
        boolean z;
        if (i <= this.mMemoryCacheParams.maxCacheEntrySize) {
            z = getInUseCount() <= this.mMemoryCacheParams.maxCacheEntries - 1 && getInUseSizeInBytes() <= this.mMemoryCacheParams.maxCacheSize - i;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<V> get(K k) {
        com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entryRemove;
        com.facebook.common.references.CloseableReference<V> closeableReferenceNewClientReference;
        com.facebook.common.internal.Preconditions.checkNotNull(k);
        synchronized (this) {
            entryRemove = this.mExclusiveEntries.remove(k);
            com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry = this.mCachedEntries.get(k);
            closeableReferenceNewClientReference = entry != null ? newClientReference(entry) : null;
        }
        maybeNotifyExclusiveEntryRemoval(entryRemove);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return closeableReferenceNewClientReference;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @javax.annotation.Nullable
    public synchronized V inspect(K k) {
        com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry = this.mCachedEntries.get(k);
        if (entry == null) {
            return null;
        }
        return entry.valueRef.get();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public void probe(K k) {
        com.facebook.common.internal.Preconditions.checkNotNull(k);
        synchronized (this) {
            com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entryRemove = this.mExclusiveEntries.remove(k);
            if (entryRemove != null) {
                this.mExclusiveEntries.put(k, entryRemove);
            }
        }
    }

    private synchronized com.facebook.common.references.CloseableReference<V> newClientReference(final com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
        increaseClientCount(entry);
        return com.facebook.common.references.CloseableReference.of(entry.valueRef.get(), new com.facebook.common.references.ResourceReleaser<V>() { // from class: com.facebook.imagepipeline.cache.LruCountingMemoryCache.2
            @Override // com.facebook.common.references.ResourceReleaser
            public void release(V v) {
                com.facebook.imagepipeline.cache.LruCountingMemoryCache.this.releaseClientReference(entry);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseClientReference(com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
        boolean zMaybeAddToExclusives;
        com.facebook.common.references.CloseableReference<V> closeableReferenceReferenceToClose;
        com.facebook.common.internal.Preconditions.checkNotNull(entry);
        synchronized (this) {
            decreaseClientCount(entry);
            zMaybeAddToExclusives = maybeAddToExclusives(entry);
            closeableReferenceReferenceToClose = referenceToClose(entry);
        }
        com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReferenceReferenceToClose);
        if (!zMaybeAddToExclusives) {
            entry = null;
        }
        maybeNotifyExclusiveEntryInsertion(entry);
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    private synchronized boolean maybeAddToExclusives(com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
        if (entry.isOrphan || entry.clientCount != 0) {
            return false;
        }
        this.mExclusiveEntries.put(entry.key, entry);
        return true;
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<V> reuse(K k) {
        com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entryRemove;
        boolean z;
        com.facebook.common.references.CloseableReference<V> closeableReference;
        com.facebook.common.internal.Preconditions.checkNotNull(k);
        synchronized (this) {
            entryRemove = this.mExclusiveEntries.remove(k);
            z = false;
            if (entryRemove != null) {
                com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entryRemove2 = this.mCachedEntries.remove(k);
                com.facebook.common.internal.Preconditions.checkNotNull(entryRemove2);
                com.facebook.common.internal.Preconditions.checkState(entryRemove2.clientCount == 0);
                closeableReference = entryRemove2.valueRef;
                z = true;
            } else {
                closeableReference = null;
            }
        }
        if (z) {
            maybeNotifyExclusiveEntryRemoval(entryRemove);
        }
        return closeableReference;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int removeAll(com.facebook.common.internal.Predicate<K> predicate) {
        java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayListRemoveAll;
        java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayListRemoveAll2;
        synchronized (this) {
            arrayListRemoveAll = this.mExclusiveEntries.removeAll(predicate);
            arrayListRemoveAll2 = this.mCachedEntries.removeAll(predicate);
            makeOrphans(arrayListRemoveAll2);
        }
        maybeClose(arrayListRemoveAll2);
        maybeNotifyExclusiveEntryRemoval(arrayListRemoveAll);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return arrayListRemoveAll2.size();
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public void clear() {
        java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayListClear;
        java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayListClear2;
        synchronized (this) {
            arrayListClear = this.mExclusiveEntries.clear();
            arrayListClear2 = this.mCachedEntries.clear();
            makeOrphans(arrayListClear2);
        }
        maybeClose(arrayListClear2);
        maybeNotifyExclusiveEntryRemoval(arrayListClear);
        maybeUpdateCacheParams();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized boolean contains(com.facebook.common.internal.Predicate<K> predicate) {
        return !this.mCachedEntries.getMatchingEntries(predicate).isEmpty();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized boolean contains(K k) {
        return this.mCachedEntries.contains(k);
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(com.facebook.common.memory.MemoryTrimType memoryTrimType) {
        java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayListTrimExclusivelyOwnedEntries;
        double trimRatio = this.mCacheTrimStrategy.getTrimRatio(memoryTrimType);
        synchronized (this) {
            arrayListTrimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(Integer.MAX_VALUE, java.lang.Math.max(0, ((int) (((double) this.mCachedEntries.getSizeInBytes()) * (1.0d - trimRatio))) - getInUseSizeInBytes()));
            makeOrphans(arrayListTrimExclusivelyOwnedEntries);
        }
        maybeClose(arrayListTrimExclusivelyOwnedEntries);
        maybeNotifyExclusiveEntryRemoval(arrayListTrimExclusivelyOwnedEntries);
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    private synchronized void maybeUpdateCacheParams() {
        if (this.mLastCacheParamsCheck + this.mMemoryCacheParams.paramsCheckIntervalMs > android.os.SystemClock.uptimeMillis()) {
            return;
        }
        this.mLastCacheParamsCheck = android.os.SystemClock.uptimeMillis();
        this.mMemoryCacheParams = (com.facebook.imagepipeline.cache.MemoryCacheParams) com.facebook.common.internal.Preconditions.checkNotNull(this.mMemoryCacheParamsSupplier.get(), "mMemoryCacheParamsSupplier returned null");
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public com.facebook.imagepipeline.cache.MemoryCacheParams getMemoryCacheParams() {
        return this.mMemoryCacheParams;
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> getCachedEntries() {
        return this.mCachedEntries;
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public java.util.Map<android.graphics.Bitmap, java.lang.Object> getOtherEntries() {
        return this.mOtherEntries;
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public void maybeEvictEntries() {
        java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayListTrimExclusivelyOwnedEntries;
        synchronized (this) {
            arrayListTrimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(java.lang.Math.min(this.mMemoryCacheParams.maxEvictionQueueEntries, this.mMemoryCacheParams.maxCacheEntries - getInUseCount()), java.lang.Math.min(this.mMemoryCacheParams.maxEvictionQueueSize, this.mMemoryCacheParams.maxCacheSize - getInUseSizeInBytes()));
            makeOrphans(arrayListTrimExclusivelyOwnedEntries);
        }
        maybeClose(arrayListTrimExclusivelyOwnedEntries);
        maybeNotifyExclusiveEntryRemoval(arrayListTrimExclusivelyOwnedEntries);
    }

    @javax.annotation.Nullable
    private synchronized java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> trimExclusivelyOwnedEntries(int i, int i2) {
        int iMax = java.lang.Math.max(i, 0);
        int iMax2 = java.lang.Math.max(i2, 0);
        if (this.mExclusiveEntries.getCount() <= iMax && this.mExclusiveEntries.getSizeInBytes() <= iMax2) {
            return null;
        }
        java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayList = new java.util.ArrayList<>();
        while (true) {
            if (this.mExclusiveEntries.getCount() <= iMax && this.mExclusiveEntries.getSizeInBytes() <= iMax2) {
                break;
            }
            K firstKey = this.mExclusiveEntries.getFirstKey();
            if (firstKey == null) {
                if (this.mIgnoreSizeMismatch) {
                    this.mExclusiveEntries.resetSize();
                    break;
                }
                throw new java.lang.IllegalStateException(java.lang.String.format("key is null, but exclusiveEntries count: %d, size: %d", java.lang.Integer.valueOf(this.mExclusiveEntries.getCount()), java.lang.Integer.valueOf(this.mExclusiveEntries.getSizeInBytes())));
            }
            this.mExclusiveEntries.remove(firstKey);
            arrayList.add(this.mCachedEntries.remove(firstKey));
        }
        return arrayList;
    }

    private void maybeClose(@javax.annotation.Nullable java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayList) {
        if (arrayList != null) {
            java.util.Iterator<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) referenceToClose(it.next()));
            }
        }
    }

    private void maybeNotifyExclusiveEntryRemoval(@javax.annotation.Nullable java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayList) {
        if (arrayList != null) {
            java.util.Iterator<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                maybeNotifyExclusiveEntryRemoval(it.next());
            }
        }
    }

    private static <K, V> void maybeNotifyExclusiveEntryRemoval(@javax.annotation.Nullable com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
        if (entry == null || entry.observer == null) {
            return;
        }
        entry.observer.onExclusivityChanged(entry.key, false);
    }

    private static <K, V> void maybeNotifyExclusiveEntryInsertion(@javax.annotation.Nullable com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
        if (entry == null || entry.observer == null) {
            return;
        }
        entry.observer.onExclusivityChanged(entry.key, true);
    }

    private synchronized void makeOrphans(@javax.annotation.Nullable java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayList) {
        if (arrayList != null) {
            java.util.Iterator<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                makeOrphan(it.next());
            }
        }
    }

    private synchronized void makeOrphan(com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
        com.facebook.common.internal.Preconditions.checkNotNull(entry);
        com.facebook.common.internal.Preconditions.checkState(!entry.isOrphan);
        entry.isOrphan = true;
    }

    private synchronized void increaseClientCount(com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
        com.facebook.common.internal.Preconditions.checkNotNull(entry);
        com.facebook.common.internal.Preconditions.checkState(!entry.isOrphan);
        entry.clientCount++;
    }

    private synchronized void decreaseClientCount(com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
        com.facebook.common.internal.Preconditions.checkNotNull(entry);
        com.facebook.common.internal.Preconditions.checkState(entry.clientCount > 0);
        entry.clientCount--;
    }

    @javax.annotation.Nullable
    private synchronized com.facebook.common.references.CloseableReference<V> referenceToClose(com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
        com.facebook.common.internal.Preconditions.checkNotNull(entry);
        return (entry.isOrphan && entry.clientCount == 0) ? entry.valueRef : null;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized int getCount() {
        return this.mCachedEntries.getCount();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized int getSizeInBytes() {
        return this.mCachedEntries.getSizeInBytes();
    }

    public synchronized int getInUseCount() {
        return this.mCachedEntries.getCount() - this.mExclusiveEntries.getCount();
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public synchronized int getInUseSizeInBytes() {
        return this.mCachedEntries.getSizeInBytes() - this.mExclusiveEntries.getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public synchronized int getEvictionQueueCount() {
        return this.mExclusiveEntries.getCount();
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public synchronized int getEvictionQueueSizeInBytes() {
        return this.mExclusiveEntries.getSizeInBytes();
    }

    @Override // com.facebook.cache.common.HasDebugData
    @javax.annotation.Nullable
    public synchronized java.lang.String getDebugData() {
        return com.facebook.common.internal.Objects.toStringHelper("CountingMemoryCache").add("cached_entries_count", this.mCachedEntries.getCount()).add("cached_entries_size_bytes", this.mCachedEntries.getSizeInBytes()).add("exclusive_entries_count", this.mExclusiveEntries.getCount()).add("exclusive_entries_size_bytes", this.mExclusiveEntries.getSizeInBytes()).toString();
    }
}
