package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.Pool<V> {
    private final java.lang.Class<?> TAG;
    private boolean mAllowNewBuckets;
    final android.util.SparseArray<com.facebook.imagepipeline.memory.Bucket<V>> mBuckets;
    final com.facebook.imagepipeline.memory.BasePool.Counter mFree;
    private boolean mIgnoreHardCap;
    final java.util.Set<V> mInUseValues;
    final com.facebook.common.memory.MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    final com.facebook.imagepipeline.memory.PoolParams mPoolParams;
    private final com.facebook.imagepipeline.memory.PoolStatsTracker mPoolStatsTracker;
    final com.facebook.imagepipeline.memory.BasePool.Counter mUsed;

    protected abstract V alloc(int i);

    protected abstract void free(V v);

    protected abstract int getBucketedSize(int i);

    protected abstract int getBucketedSizeForValue(V v);

    protected abstract int getSizeInBytes(int i);

    protected void onParamsChanged() {
    }

    public BasePool(com.facebook.common.memory.MemoryTrimmableRegistry memoryTrimmableRegistry, com.facebook.imagepipeline.memory.PoolParams poolParams, com.facebook.imagepipeline.memory.PoolStatsTracker poolStatsTracker) {
        this.TAG = getClass();
        this.mMemoryTrimmableRegistry = (com.facebook.common.memory.MemoryTrimmableRegistry) com.facebook.common.internal.Preconditions.checkNotNull(memoryTrimmableRegistry);
        com.facebook.imagepipeline.memory.PoolParams poolParams2 = (com.facebook.imagepipeline.memory.PoolParams) com.facebook.common.internal.Preconditions.checkNotNull(poolParams);
        this.mPoolParams = poolParams2;
        this.mPoolStatsTracker = (com.facebook.imagepipeline.memory.PoolStatsTracker) com.facebook.common.internal.Preconditions.checkNotNull(poolStatsTracker);
        this.mBuckets = new android.util.SparseArray<>();
        if (poolParams2.fixBucketsReinitialization) {
            initBuckets();
        } else {
            legacyInitBuckets(new android.util.SparseIntArray(0));
        }
        this.mInUseValues = com.facebook.common.internal.Sets.newIdentityHashSet();
        this.mFree = new com.facebook.imagepipeline.memory.BasePool.Counter();
        this.mUsed = new com.facebook.imagepipeline.memory.BasePool.Counter();
    }

    public BasePool(com.facebook.common.memory.MemoryTrimmableRegistry memoryTrimmableRegistry, com.facebook.imagepipeline.memory.PoolParams poolParams, com.facebook.imagepipeline.memory.PoolStatsTracker poolStatsTracker, boolean z) {
        this(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        this.mIgnoreHardCap = z;
    }

    protected void initialize() {
        this.mMemoryTrimmableRegistry.registerMemoryTrimmable(this);
        this.mPoolStatsTracker.setBasePool(this);
    }

    @javax.annotation.Nullable
    protected synchronized V getValue(com.facebook.imagepipeline.memory.Bucket<V> bucket) {
        return bucket.get();
    }

    @Override // com.facebook.common.memory.Pool
    public V get(int i) throws java.lang.Throwable {
        V vAlloc;
        V value;
        ensurePoolSizeInvariant();
        int bucketedSize = getBucketedSize(i);
        synchronized (this) {
            com.facebook.imagepipeline.memory.Bucket<V> bucket = getBucket(bucketedSize);
            if (bucket != null && (value = getValue(bucket)) != null) {
                com.facebook.common.internal.Preconditions.checkState(this.mInUseValues.add(value));
                int bucketedSizeForValue = getBucketedSizeForValue(value);
                int sizeInBytes = getSizeInBytes(bucketedSizeForValue);
                this.mUsed.increment(sizeInBytes);
                this.mFree.decrement(sizeInBytes);
                this.mPoolStatsTracker.onValueReuse(sizeInBytes);
                logStats();
                if (com.facebook.common.logging.FLog.isLoggable(2)) {
                    com.facebook.common.logging.FLog.v(this.TAG, "get (reuse) (object, size) = (%x, %s)", java.lang.Integer.valueOf(java.lang.System.identityHashCode(value)), java.lang.Integer.valueOf(bucketedSizeForValue));
                }
                return value;
            }
            int sizeInBytes2 = getSizeInBytes(bucketedSize);
            if (!canAllocate(sizeInBytes2)) {
                throw new com.facebook.imagepipeline.memory.BasePool.PoolSizeViolationException(this.mPoolParams.maxSizeHardCap, this.mUsed.mNumBytes, this.mFree.mNumBytes, sizeInBytes2);
            }
            this.mUsed.increment(sizeInBytes2);
            if (bucket != null) {
                bucket.incrementInUseCount();
            }
            try {
                vAlloc = alloc(bucketedSize);
            } catch (java.lang.Throwable th) {
                synchronized (this) {
                    this.mUsed.decrement(sizeInBytes2);
                    com.facebook.imagepipeline.memory.Bucket<V> bucket2 = getBucket(bucketedSize);
                    if (bucket2 != null) {
                        bucket2.decrementInUseCount();
                    }
                    com.facebook.common.internal.Throwables.propagateIfPossible(th);
                    vAlloc = null;
                }
            }
            synchronized (this) {
                com.facebook.common.internal.Preconditions.checkState(this.mInUseValues.add(vAlloc));
                trimToSoftCap();
                this.mPoolStatsTracker.onAlloc(sizeInBytes2);
                logStats();
                if (com.facebook.common.logging.FLog.isLoggable(2)) {
                    com.facebook.common.logging.FLog.v(this.TAG, "get (alloc) (object, size) = (%x, %s)", java.lang.Integer.valueOf(java.lang.System.identityHashCode(vAlloc)), java.lang.Integer.valueOf(bucketedSize));
                }
            }
            return vAlloc;
        }
    }

    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public void release(V v) {
        com.facebook.common.internal.Preconditions.checkNotNull(v);
        int bucketedSizeForValue = getBucketedSizeForValue(v);
        int sizeInBytes = getSizeInBytes(bucketedSizeForValue);
        synchronized (this) {
            com.facebook.imagepipeline.memory.Bucket<V> bucketIfPresent = getBucketIfPresent(bucketedSizeForValue);
            if (!this.mInUseValues.remove(v)) {
                com.facebook.common.logging.FLog.e(this.TAG, "release (free, value unrecognized) (object, size) = (%x, %s)", java.lang.Integer.valueOf(java.lang.System.identityHashCode(v)), java.lang.Integer.valueOf(bucketedSizeForValue));
                free(v);
                this.mPoolStatsTracker.onFree(sizeInBytes);
            } else if (bucketIfPresent == null || bucketIfPresent.isMaxLengthExceeded() || isMaxSizeSoftCapExceeded() || !isReusable(v)) {
                if (bucketIfPresent != null) {
                    bucketIfPresent.decrementInUseCount();
                }
                if (com.facebook.common.logging.FLog.isLoggable(2)) {
                    com.facebook.common.logging.FLog.v(this.TAG, "release (free) (object, size) = (%x, %s)", java.lang.Integer.valueOf(java.lang.System.identityHashCode(v)), java.lang.Integer.valueOf(bucketedSizeForValue));
                }
                free(v);
                this.mUsed.decrement(sizeInBytes);
                this.mPoolStatsTracker.onFree(sizeInBytes);
            } else {
                bucketIfPresent.release(v);
                this.mFree.increment(sizeInBytes);
                this.mUsed.decrement(sizeInBytes);
                this.mPoolStatsTracker.onValueRelease(sizeInBytes);
                if (com.facebook.common.logging.FLog.isLoggable(2)) {
                    com.facebook.common.logging.FLog.v(this.TAG, "release (reuse) (object, size) = (%x, %s)", java.lang.Integer.valueOf(java.lang.System.identityHashCode(v)), java.lang.Integer.valueOf(bucketedSizeForValue));
                }
            }
            logStats();
        }
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(com.facebook.common.memory.MemoryTrimType memoryTrimType) {
        trimToNothing();
    }

    protected boolean isReusable(V v) {
        com.facebook.common.internal.Preconditions.checkNotNull(v);
        return true;
    }

    private synchronized void ensurePoolSizeInvariant() {
        com.facebook.common.internal.Preconditions.checkState(!isMaxSizeSoftCapExceeded() || this.mFree.mNumBytes == 0);
    }

    private synchronized void legacyInitBuckets(android.util.SparseIntArray sparseIntArray) {
        com.facebook.common.internal.Preconditions.checkNotNull(sparseIntArray);
        this.mBuckets.clear();
        android.util.SparseIntArray sparseIntArray2 = this.mPoolParams.bucketSizes;
        if (sparseIntArray2 != null) {
            for (int i = 0; i < sparseIntArray2.size(); i++) {
                int iKeyAt = sparseIntArray2.keyAt(i);
                this.mBuckets.put(iKeyAt, new com.facebook.imagepipeline.memory.Bucket<>(getSizeInBytes(iKeyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(iKeyAt, 0), this.mPoolParams.fixBucketsReinitialization));
            }
            this.mAllowNewBuckets = false;
        } else {
            this.mAllowNewBuckets = true;
        }
    }

    private synchronized void initBuckets() {
        android.util.SparseIntArray sparseIntArray = this.mPoolParams.bucketSizes;
        if (sparseIntArray != null) {
            fillBuckets(sparseIntArray);
            this.mAllowNewBuckets = false;
        } else {
            this.mAllowNewBuckets = true;
        }
    }

    private void fillBuckets(android.util.SparseIntArray sparseIntArray) {
        this.mBuckets.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int iKeyAt = sparseIntArray.keyAt(i);
            this.mBuckets.put(iKeyAt, new com.facebook.imagepipeline.memory.Bucket<>(getSizeInBytes(iKeyAt), sparseIntArray.valueAt(i), 0, this.mPoolParams.fixBucketsReinitialization));
        }
    }

    private java.util.List<com.facebook.imagepipeline.memory.Bucket<V>> refillBuckets() {
        java.util.ArrayList arrayList = new java.util.ArrayList(this.mBuckets.size());
        int size = this.mBuckets.size();
        for (int i = 0; i < size; i++) {
            com.facebook.imagepipeline.memory.Bucket bucket = (com.facebook.imagepipeline.memory.Bucket) com.facebook.common.internal.Preconditions.checkNotNull(this.mBuckets.valueAt(i));
            int i2 = bucket.mItemSize;
            int i3 = bucket.mMaxLength;
            int inUseCount = bucket.getInUseCount();
            if (bucket.getFreeListSize() > 0) {
                arrayList.add(bucket);
            }
            this.mBuckets.setValueAt(i, new com.facebook.imagepipeline.memory.Bucket<>(getSizeInBytes(i2), i3, inUseCount, this.mPoolParams.fixBucketsReinitialization));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void trimToNothing() {
        int i;
        java.util.List arrayList;
        synchronized (this) {
            if (this.mPoolParams.fixBucketsReinitialization) {
                arrayList = refillBuckets();
            } else {
                arrayList = new java.util.ArrayList(this.mBuckets.size());
                android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
                for (int i2 = 0; i2 < this.mBuckets.size(); i2++) {
                    com.facebook.imagepipeline.memory.Bucket bucket = (com.facebook.imagepipeline.memory.Bucket) com.facebook.common.internal.Preconditions.checkNotNull(this.mBuckets.valueAt(i2));
                    if (bucket.getFreeListSize() > 0) {
                        arrayList.add(bucket);
                    }
                    sparseIntArray.put(this.mBuckets.keyAt(i2), bucket.getInUseCount());
                }
                legacyInitBuckets(sparseIntArray);
            }
            this.mFree.reset();
            logStats();
        }
        onParamsChanged();
        for (i = 0; i < arrayList.size(); i++) {
            com.facebook.imagepipeline.memory.Bucket bucket2 = (com.facebook.imagepipeline.memory.Bucket) arrayList.get(i);
            while (true) {
                java.lang.Object objPop = bucket2.pop();
                if (objPop == null) {
                    break;
                } else {
                    free(objPop);
                }
            }
        }
    }

    synchronized void trimToSoftCap() {
        if (isMaxSizeSoftCapExceeded()) {
            trimToSize(this.mPoolParams.maxSizeSoftCap);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    synchronized void trimToSize(int i) {
        int iMin = java.lang.Math.min((this.mUsed.mNumBytes + this.mFree.mNumBytes) - i, this.mFree.mNumBytes);
        if (iMin <= 0) {
            return;
        }
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            com.facebook.common.logging.FLog.v(this.TAG, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes), java.lang.Integer.valueOf(iMin));
        }
        logStats();
        for (int i2 = 0; i2 < this.mBuckets.size() && iMin > 0; i2++) {
            com.facebook.imagepipeline.memory.Bucket bucket = (com.facebook.imagepipeline.memory.Bucket) com.facebook.common.internal.Preconditions.checkNotNull(this.mBuckets.valueAt(i2));
            while (iMin > 0) {
                java.lang.Object objPop = bucket.pop();
                if (objPop == null) {
                    break;
                }
                free(objPop);
                iMin -= bucket.mItemSize;
                this.mFree.decrement(bucket.mItemSize);
            }
        }
        logStats();
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            com.facebook.common.logging.FLog.v(this.TAG, "trimToSize: TargetSize = %d; Final Size = %d", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes));
        }
    }

    @javax.annotation.Nullable
    private synchronized com.facebook.imagepipeline.memory.Bucket<V> getBucketIfPresent(int i) {
        return this.mBuckets.get(i);
    }

    @javax.annotation.Nullable
    synchronized com.facebook.imagepipeline.memory.Bucket<V> getBucket(int i) {
        com.facebook.imagepipeline.memory.Bucket<V> bucket = this.mBuckets.get(i);
        if (bucket == null && this.mAllowNewBuckets) {
            if (com.facebook.common.logging.FLog.isLoggable(2)) {
                com.facebook.common.logging.FLog.v(this.TAG, "creating new bucket %s", java.lang.Integer.valueOf(i));
            }
            com.facebook.imagepipeline.memory.Bucket<V> bucketNewBucket = newBucket(i);
            this.mBuckets.put(i, bucketNewBucket);
            return bucketNewBucket;
        }
        return bucket;
    }

    com.facebook.imagepipeline.memory.Bucket<V> newBucket(int i) {
        return new com.facebook.imagepipeline.memory.Bucket<>(getSizeInBytes(i), Integer.MAX_VALUE, 0, this.mPoolParams.fixBucketsReinitialization);
    }

    synchronized boolean isMaxSizeSoftCapExceeded() {
        boolean z;
        z = this.mUsed.mNumBytes + this.mFree.mNumBytes > this.mPoolParams.maxSizeSoftCap;
        if (z) {
            this.mPoolStatsTracker.onSoftCapReached();
        }
        return z;
    }

    synchronized boolean canAllocate(int i) {
        if (this.mIgnoreHardCap) {
            return true;
        }
        int i2 = this.mPoolParams.maxSizeHardCap;
        if (i > i2 - this.mUsed.mNumBytes) {
            this.mPoolStatsTracker.onHardCapReached();
            return false;
        }
        int i3 = this.mPoolParams.maxSizeSoftCap;
        if (i > i3 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
            trimToSize(i3 - i);
        }
        if (i <= i2 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
            return true;
        }
        this.mPoolStatsTracker.onHardCapReached();
        return false;
    }

    private void logStats() {
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            com.facebook.common.logging.FLog.v(this.TAG, "Used = (%d, %d); Free = (%d, %d)", java.lang.Integer.valueOf(this.mUsed.mCount), java.lang.Integer.valueOf(this.mUsed.mNumBytes), java.lang.Integer.valueOf(this.mFree.mCount), java.lang.Integer.valueOf(this.mFree.mNumBytes));
        }
    }

    public synchronized java.util.Map<java.lang.String, java.lang.Integer> getStats() {
        java.util.HashMap map;
        map = new java.util.HashMap();
        for (int i = 0; i < this.mBuckets.size(); i++) {
            map.put("buckets_used_" + getSizeInBytes(this.mBuckets.keyAt(i)), java.lang.Integer.valueOf(((com.facebook.imagepipeline.memory.Bucket) com.facebook.common.internal.Preconditions.checkNotNull(this.mBuckets.valueAt(i))).getInUseCount()));
        }
        map.put("soft_cap", java.lang.Integer.valueOf(this.mPoolParams.maxSizeSoftCap));
        map.put("hard_cap", java.lang.Integer.valueOf(this.mPoolParams.maxSizeHardCap));
        map.put("used_count", java.lang.Integer.valueOf(this.mUsed.mCount));
        map.put("used_bytes", java.lang.Integer.valueOf(this.mUsed.mNumBytes));
        map.put("free_count", java.lang.Integer.valueOf(this.mFree.mCount));
        map.put("free_bytes", java.lang.Integer.valueOf(this.mFree.mNumBytes));
        return map;
    }

    static class Counter {
        private static final java.lang.String TAG = "com.facebook.imagepipeline.memory.BasePool.Counter";
        int mCount;
        int mNumBytes;

        Counter() {
        }

        public void increment(int i) {
            this.mCount++;
            this.mNumBytes += i;
        }

        public void decrement(int i) {
            int i2;
            int i3 = this.mNumBytes;
            if (i3 >= i && (i2 = this.mCount) > 0) {
                this.mCount = i2 - 1;
                this.mNumBytes = i3 - i;
            } else {
                com.facebook.common.logging.FLog.wtf(TAG, "Unexpected decrement of %d. Current numBytes = %d, count = %d", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.mNumBytes), java.lang.Integer.valueOf(this.mCount));
            }
        }

        public void reset() {
            this.mCount = 0;
            this.mNumBytes = 0;
        }
    }

    public static class InvalidValueException extends java.lang.RuntimeException {
        public InvalidValueException(java.lang.Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    public static class InvalidSizeException extends java.lang.RuntimeException {
        public InvalidSizeException(java.lang.Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    public static class SizeTooLargeException extends com.facebook.imagepipeline.memory.BasePool.InvalidSizeException {
        public SizeTooLargeException(java.lang.Object obj) {
            super(obj);
        }
    }

    public static class PoolSizeViolationException extends java.lang.RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
        }
    }
}
