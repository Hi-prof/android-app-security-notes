package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes.dex */
public class NoOpPoolStatsTracker implements com.facebook.imagepipeline.memory.PoolStatsTracker {

    @javax.annotation.Nullable
    private static com.facebook.imagepipeline.memory.NoOpPoolStatsTracker sInstance;

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void onAlloc(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void onFree(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void onHardCapReached() {
    }

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void onSoftCapReached() {
    }

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void onValueRelease(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void onValueReuse(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void setBasePool(com.facebook.imagepipeline.memory.BasePool basePool) {
    }

    private NoOpPoolStatsTracker() {
    }

    public static synchronized com.facebook.imagepipeline.memory.NoOpPoolStatsTracker getInstance() {
        if (sInstance == null) {
            sInstance = new com.facebook.imagepipeline.memory.NoOpPoolStatsTracker();
        }
        return sInstance;
    }
}
