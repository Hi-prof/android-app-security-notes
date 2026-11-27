package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes.dex */
public class FlexByteArrayPool {
    final com.facebook.imagepipeline.memory.FlexByteArrayPool.SoftRefByteArrayPool mDelegatePool;
    private final com.facebook.common.references.ResourceReleaser<byte[]> mResourceReleaser;

    public FlexByteArrayPool(com.facebook.common.memory.MemoryTrimmableRegistry memoryTrimmableRegistry, com.facebook.imagepipeline.memory.PoolParams poolParams) {
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(poolParams.maxNumThreads > 0));
        this.mDelegatePool = new com.facebook.imagepipeline.memory.FlexByteArrayPool.SoftRefByteArrayPool(memoryTrimmableRegistry, poolParams, com.facebook.imagepipeline.memory.NoOpPoolStatsTracker.getInstance());
        this.mResourceReleaser = new com.facebook.common.references.ResourceReleaser<byte[]>() { // from class: com.facebook.imagepipeline.memory.FlexByteArrayPool.1
            @Override // com.facebook.common.references.ResourceReleaser
            public void release(byte[] bArr) {
                com.facebook.imagepipeline.memory.FlexByteArrayPool.this.release(bArr);
            }
        };
    }

    public com.facebook.common.references.CloseableReference<byte[]> get(int i) {
        return com.facebook.common.references.CloseableReference.of(this.mDelegatePool.get(i), this.mResourceReleaser);
    }

    public void release(byte[] bArr) {
        this.mDelegatePool.release(bArr);
    }

    public java.util.Map<java.lang.String, java.lang.Integer> getStats() {
        return this.mDelegatePool.getStats();
    }

    public int getMinBufferSize() {
        return this.mDelegatePool.getMinBufferSize();
    }

    static class SoftRefByteArrayPool extends com.facebook.imagepipeline.memory.GenericByteArrayPool {
        public SoftRefByteArrayPool(com.facebook.common.memory.MemoryTrimmableRegistry memoryTrimmableRegistry, com.facebook.imagepipeline.memory.PoolParams poolParams, com.facebook.imagepipeline.memory.PoolStatsTracker poolStatsTracker) {
            super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        com.facebook.imagepipeline.memory.Bucket<byte[]> newBucket(int i) {
            return new com.facebook.imagepipeline.memory.OOMSoftReferenceBucket(getSizeInBytes(i), this.mPoolParams.maxNumThreads, 0);
        }
    }
}
