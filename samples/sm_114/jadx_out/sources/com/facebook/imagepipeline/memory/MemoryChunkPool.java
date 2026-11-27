package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes.dex */
public abstract class MemoryChunkPool extends com.facebook.imagepipeline.memory.BasePool<com.facebook.imagepipeline.memory.MemoryChunk> {
    private final int[] mBucketSizes;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public abstract com.facebook.imagepipeline.memory.MemoryChunk alloc(int i);

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int getSizeInBytes(int i) {
        return i;
    }

    MemoryChunkPool(com.facebook.common.memory.MemoryTrimmableRegistry memoryTrimmableRegistry, com.facebook.imagepipeline.memory.PoolParams poolParams, com.facebook.imagepipeline.memory.PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        android.util.SparseIntArray sparseIntArray = (android.util.SparseIntArray) com.facebook.common.internal.Preconditions.checkNotNull(poolParams.bucketSizes);
        this.mBucketSizes = new int[sparseIntArray.size()];
        int i = 0;
        while (true) {
            int[] iArr = this.mBucketSizes;
            if (i < iArr.length) {
                iArr[i] = sparseIntArray.keyAt(i);
                i++;
            } else {
                initialize();
                return;
            }
        }
    }

    int getMinBufferSize() {
        return this.mBucketSizes[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public void free(com.facebook.imagepipeline.memory.MemoryChunk memoryChunk) {
        com.facebook.common.internal.Preconditions.checkNotNull(memoryChunk);
        memoryChunk.close();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int getBucketedSize(int i) {
        if (i <= 0) {
            throw new com.facebook.imagepipeline.memory.BasePool.InvalidSizeException(java.lang.Integer.valueOf(i));
        }
        for (int i2 : this.mBucketSizes) {
            if (i2 >= i) {
                return i2;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getBucketedSizeForValue(com.facebook.imagepipeline.memory.MemoryChunk memoryChunk) {
        com.facebook.common.internal.Preconditions.checkNotNull(memoryChunk);
        return memoryChunk.getSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public boolean isReusable(com.facebook.imagepipeline.memory.MemoryChunk memoryChunk) {
        com.facebook.common.internal.Preconditions.checkNotNull(memoryChunk);
        return !memoryChunk.isClosed();
    }
}
