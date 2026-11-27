package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes.dex */
public class SharedByteArray implements com.facebook.common.memory.MemoryTrimmable {
    final com.facebook.common.references.OOMSoftReference<byte[]> mByteArraySoftRef;
    final int mMaxByteArraySize;
    final int mMinByteArraySize;
    private final com.facebook.common.references.ResourceReleaser<byte[]> mResourceReleaser;
    final java.util.concurrent.Semaphore mSemaphore;

    public SharedByteArray(com.facebook.common.memory.MemoryTrimmableRegistry memoryTrimmableRegistry, com.facebook.imagepipeline.memory.PoolParams poolParams) {
        com.facebook.common.internal.Preconditions.checkNotNull(memoryTrimmableRegistry);
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(poolParams.minBucketSize > 0));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(poolParams.maxBucketSize >= poolParams.minBucketSize));
        this.mMaxByteArraySize = poolParams.maxBucketSize;
        this.mMinByteArraySize = poolParams.minBucketSize;
        this.mByteArraySoftRef = new com.facebook.common.references.OOMSoftReference<>();
        this.mSemaphore = new java.util.concurrent.Semaphore(1);
        this.mResourceReleaser = new com.facebook.common.references.ResourceReleaser<byte[]>() { // from class: com.facebook.imagepipeline.memory.SharedByteArray.1
            @Override // com.facebook.common.references.ResourceReleaser
            public void release(byte[] bArr) {
                com.facebook.imagepipeline.memory.SharedByteArray.this.mSemaphore.release();
            }
        };
        memoryTrimmableRegistry.registerMemoryTrimmable(this);
    }

    public com.facebook.common.references.CloseableReference<byte[]> get(int i) {
        com.facebook.common.internal.Preconditions.checkArgument(i > 0, "Size must be greater than zero");
        com.facebook.common.internal.Preconditions.checkArgument(i <= this.mMaxByteArraySize, "Requested size is too big");
        this.mSemaphore.acquireUninterruptibly();
        try {
            return com.facebook.common.references.CloseableReference.of(getByteArray(i), this.mResourceReleaser);
        } catch (java.lang.Throwable th) {
            this.mSemaphore.release();
            throw com.facebook.common.internal.Throwables.propagate(th);
        }
    }

    private byte[] getByteArray(int i) {
        int bucketedSize = getBucketedSize(i);
        byte[] bArr = this.mByteArraySoftRef.get();
        return (bArr == null || bArr.length < bucketedSize) ? allocateByteArray(bucketedSize) : bArr;
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(com.facebook.common.memory.MemoryTrimType memoryTrimType) {
        if (this.mSemaphore.tryAcquire()) {
            try {
                this.mByteArraySoftRef.clear();
            } finally {
                this.mSemaphore.release();
            }
        }
    }

    int getBucketedSize(int i) {
        return java.lang.Integer.highestOneBit(java.lang.Math.max(i, this.mMinByteArraySize) - 1) * 2;
    }

    private synchronized byte[] allocateByteArray(int i) {
        byte[] bArr;
        this.mByteArraySoftRef.clear();
        bArr = new byte[i];
        this.mByteArraySoftRef.set(bArr);
        return bArr;
    }
}
