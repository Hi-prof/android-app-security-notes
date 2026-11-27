package com.facebook.imagepipeline.bitmaps;

/* JADX INFO: compiled from: ArtBitmapFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/imagepipeline/bitmaps/ArtBitmapFactory;", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "bitmapPool", "Lcom/facebook/imagepipeline/memory/BitmapPool;", "closeableReferenceFactory", "Lcom/facebook/imagepipeline/core/CloseableReferenceFactory;", "<init>", "(Lcom/facebook/imagepipeline/memory/BitmapPool;Lcom/facebook/imagepipeline/core/CloseableReferenceFactory;)V", "createBitmapInternal", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "width", "", "height", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ArtBitmapFactory extends com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory {
    private final com.facebook.imagepipeline.memory.BitmapPool bitmapPool;
    private final com.facebook.imagepipeline.core.CloseableReferenceFactory closeableReferenceFactory;

    public ArtBitmapFactory(com.facebook.imagepipeline.memory.BitmapPool bitmapPool, com.facebook.imagepipeline.core.CloseableReferenceFactory closeableReferenceFactory) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmapPool, "bitmapPool");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closeableReferenceFactory, "closeableReferenceFactory");
        this.bitmapPool = bitmapPool;
        this.closeableReferenceFactory = closeableReferenceFactory;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmapInternal(int width, int height, android.graphics.Bitmap.Config bitmapConfig) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        android.graphics.Bitmap bitmap = this.bitmapPool.get(com.facebook.imageutils.BitmapUtil.getSizeInByteForBitmap(width, height, bitmapConfig));
        if (bitmap.getAllocationByteCount() < width * height * com.facebook.imageutils.BitmapUtil.getPixelSizeForBitmapConfig(bitmapConfig)) {
            throw new java.lang.IllegalStateException("Check failed.".toString());
        }
        bitmap.reconfigure(width, height, bitmapConfig);
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceCreate = this.closeableReferenceFactory.create(bitmap, this.bitmapPool);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(closeableReferenceCreate, "create(...)");
        return closeableReferenceCreate;
    }
}
