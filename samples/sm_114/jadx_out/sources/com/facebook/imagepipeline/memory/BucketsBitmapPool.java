package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes.dex */
public class BucketsBitmapPool extends com.facebook.imagepipeline.memory.BasePool<android.graphics.Bitmap> implements com.facebook.imagepipeline.memory.BitmapPool {
    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int getBucketedSize(int i) {
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    protected int getSizeInBytes(int i) {
        return i;
    }

    public BucketsBitmapPool(com.facebook.common.memory.MemoryTrimmableRegistry memoryTrimmableRegistry, com.facebook.imagepipeline.memory.PoolParams poolParams, com.facebook.imagepipeline.memory.PoolStatsTracker poolStatsTracker, boolean z) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker, z);
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: alloc */
    public android.graphics.Bitmap alloc2(int i) {
        return android.graphics.Bitmap.createBitmap(1, (int) java.lang.Math.ceil(((double) i) / 2.0d), android.graphics.Bitmap.Config.RGB_565);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public void free(android.graphics.Bitmap bitmap) {
        com.facebook.common.internal.Preconditions.checkNotNull(bitmap);
        bitmap.recycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getBucketedSizeForValue(android.graphics.Bitmap bitmap) {
        com.facebook.common.internal.Preconditions.checkNotNull(bitmap);
        return bitmap.getAllocationByteCount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public boolean isReusable(android.graphics.Bitmap bitmap) {
        com.facebook.common.internal.Preconditions.checkNotNull(bitmap);
        return !bitmap.isRecycled() && bitmap.isMutable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.memory.BasePool
    @javax.annotation.Nullable
    public android.graphics.Bitmap getValue(com.facebook.imagepipeline.memory.Bucket<android.graphics.Bitmap> bucket) {
        android.graphics.Bitmap bitmap = (android.graphics.Bitmap) super.getValue((com.facebook.imagepipeline.memory.Bucket) bucket);
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
        return bitmap;
    }
}
