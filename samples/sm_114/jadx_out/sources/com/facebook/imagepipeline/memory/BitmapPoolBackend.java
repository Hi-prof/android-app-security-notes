package com.facebook.imagepipeline.memory;

/* JADX INFO: compiled from: BitmapPoolBackend.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0096\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0004¨\u0006\u000f"}, d2 = {"Lcom/facebook/imagepipeline/memory/BitmapPoolBackend;", "Lcom/facebook/imagepipeline/memory/LruBucketsPoolBackend;", "Landroid/graphics/Bitmap;", "<init>", "()V", "put", "", "bitmap", "get", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, "", "getSize", "isReusable", "", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class BitmapPoolBackend extends com.facebook.imagepipeline.memory.LruBucketsPoolBackend<android.graphics.Bitmap> {
    private static final java.lang.String TAG = "BitmapPoolBackend";

    @Override // com.facebook.imagepipeline.memory.LruBucketsPoolBackend, com.facebook.imagepipeline.memory.PoolBackend
    public void put(android.graphics.Bitmap bitmap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (isReusable(bitmap)) {
            super.put(bitmap);
        }
    }

    @Override // com.facebook.imagepipeline.memory.LruBucketsPoolBackend, com.facebook.imagepipeline.memory.PoolBackend
    public android.graphics.Bitmap get(int size) {
        android.graphics.Bitmap bitmap = (android.graphics.Bitmap) super.get(size);
        if (bitmap == null || !isReusable(bitmap)) {
            return null;
        }
        bitmap.eraseColor(0);
        return bitmap;
    }

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    public int getSize(android.graphics.Bitmap bitmap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return com.facebook.imageutils.BitmapUtil.getSizeInBytes(bitmap);
    }

    protected final boolean isReusable(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        if (bitmap.isRecycled()) {
            com.facebook.common.logging.FLog.wtf(TAG, "Cannot reuse a recycled bitmap: %s", bitmap);
            return false;
        }
        if (bitmap.isMutable()) {
            return true;
        }
        com.facebook.common.logging.FLog.wtf(TAG, "Cannot reuse an immutable bitmap: %s", bitmap);
        return false;
    }
}
