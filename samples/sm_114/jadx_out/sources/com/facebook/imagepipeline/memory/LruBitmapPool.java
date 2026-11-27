package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes.dex */
public class LruBitmapPool implements com.facebook.imagepipeline.memory.BitmapPool {
    private int mCurrentSize;
    private int mMaxBitmapSize;
    private final int mMaxPoolSize;
    private final com.facebook.imagepipeline.memory.PoolStatsTracker mPoolStatsTracker;
    protected final com.facebook.imagepipeline.memory.PoolBackend<android.graphics.Bitmap> mStrategy = new com.facebook.imagepipeline.memory.BitmapPoolBackend();

    public LruBitmapPool(int i, int i2, com.facebook.imagepipeline.memory.PoolStatsTracker poolStatsTracker, @javax.annotation.Nullable com.facebook.common.memory.MemoryTrimmableRegistry memoryTrimmableRegistry) {
        this.mMaxPoolSize = i;
        this.mMaxBitmapSize = i2;
        this.mPoolStatsTracker = poolStatsTracker;
        if (memoryTrimmableRegistry != null) {
            memoryTrimmableRegistry.registerMemoryTrimmable(this);
        }
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(com.facebook.common.memory.MemoryTrimType memoryTrimType) {
        trimTo((int) (((double) this.mMaxPoolSize) * (1.0d - memoryTrimType.getSuggestedTrimRatio())));
    }

    private synchronized void trimTo(int i) {
        android.graphics.Bitmap bitmapPop;
        while (this.mCurrentSize > i && (bitmapPop = this.mStrategy.pop()) != null) {
            int size = this.mStrategy.getSize(bitmapPop);
            this.mCurrentSize -= size;
            this.mPoolStatsTracker.onFree(size);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.common.memory.Pool
    public synchronized android.graphics.Bitmap get(int i) {
        int i2 = this.mCurrentSize;
        int i3 = this.mMaxPoolSize;
        if (i2 > i3) {
            trimTo(i3);
        }
        android.graphics.Bitmap bitmap = this.mStrategy.get(i);
        if (bitmap != null) {
            int size = this.mStrategy.getSize(bitmap);
            this.mCurrentSize -= size;
            this.mPoolStatsTracker.onValueReuse(size);
            return bitmap;
        }
        return alloc(i);
    }

    private android.graphics.Bitmap alloc(int i) {
        this.mPoolStatsTracker.onAlloc(i);
        return android.graphics.Bitmap.createBitmap(1, i, android.graphics.Bitmap.Config.ALPHA_8);
    }

    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public void release(android.graphics.Bitmap bitmap) {
        int size = this.mStrategy.getSize(bitmap);
        if (size <= this.mMaxBitmapSize) {
            this.mPoolStatsTracker.onValueRelease(size);
            this.mStrategy.put(bitmap);
            synchronized (this) {
                this.mCurrentSize += size;
            }
        }
    }
}
