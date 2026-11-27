package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes.dex */
public class AshmemMemoryChunkPool extends com.facebook.imagepipeline.memory.MemoryChunkPool {
    public AshmemMemoryChunkPool(com.facebook.common.memory.MemoryTrimmableRegistry memoryTrimmableRegistry, com.facebook.imagepipeline.memory.PoolParams poolParams, com.facebook.imagepipeline.memory.PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.memory.MemoryChunkPool, com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: alloc */
    public com.facebook.imagepipeline.memory.MemoryChunk alloc2(int i) {
        return new com.facebook.imagepipeline.memory.AshmemMemoryChunk(i);
    }
}
