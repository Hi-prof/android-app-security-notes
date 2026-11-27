package com.facebook.imagepipeline.bitmaps;

/* JADX INFO: compiled from: HoneycombBitmapFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory;", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "jpegGenerator", "Lcom/facebook/imagepipeline/bitmaps/EmptyJpegGenerator;", "purgeableDecoder", "Lcom/facebook/imagepipeline/platform/PlatformDecoder;", "closeableReferenceFactory", "Lcom/facebook/imagepipeline/core/CloseableReferenceFactory;", "<init>", "(Lcom/facebook/imagepipeline/bitmaps/EmptyJpegGenerator;Lcom/facebook/imagepipeline/platform/PlatformDecoder;Lcom/facebook/imagepipeline/core/CloseableReferenceFactory;)V", "immutableBitmapFallback", "", "createBitmapInternal", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "width", "", "height", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "createFallbackBitmap", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HoneycombBitmapFactory extends com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory {
    private static final java.lang.String TAG = "HoneycombBitmapFactory";
    private final com.facebook.imagepipeline.core.CloseableReferenceFactory closeableReferenceFactory;
    private boolean immutableBitmapFallback;
    private final com.facebook.imagepipeline.bitmaps.EmptyJpegGenerator jpegGenerator;
    private final com.facebook.imagepipeline.platform.PlatformDecoder purgeableDecoder;

    public HoneycombBitmapFactory(com.facebook.imagepipeline.bitmaps.EmptyJpegGenerator jpegGenerator, com.facebook.imagepipeline.platform.PlatformDecoder purgeableDecoder, com.facebook.imagepipeline.core.CloseableReferenceFactory closeableReferenceFactory) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jpegGenerator, "jpegGenerator");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(purgeableDecoder, "purgeableDecoder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closeableReferenceFactory, "closeableReferenceFactory");
        this.jpegGenerator = jpegGenerator;
        this.purgeableDecoder = purgeableDecoder;
        this.closeableReferenceFactory = closeableReferenceFactory;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmapInternal(int width, int height, android.graphics.Bitmap.Config bitmapConfig) throws java.lang.Throwable {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        if (this.immutableBitmapFallback) {
            return createFallbackBitmap(width, height, bitmapConfig);
        }
        com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> closeableReferenceGenerate = this.jpegGenerator.generate((short) width, (short) height);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(closeableReferenceGenerate, "generate(...)");
        try {
            com.facebook.imagepipeline.image.EncodedImage encodedImage = new com.facebook.imagepipeline.image.EncodedImage(closeableReferenceGenerate);
            encodedImage.setImageFormat(com.facebook.imageformat.DefaultImageFormats.JPEG);
            try {
                com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceDecodeJPEGFromEncodedImage = this.purgeableDecoder.decodeJPEGFromEncodedImage(encodedImage, bitmapConfig, null, closeableReferenceGenerate.get().size());
                if (closeableReferenceDecodeJPEGFromEncodedImage == null) {
                    throw new java.lang.IllegalStateException("Required value was null.".toString());
                }
                if (!closeableReferenceDecodeJPEGFromEncodedImage.get().isMutable()) {
                    com.facebook.common.references.CloseableReference.closeSafely(closeableReferenceDecodeJPEGFromEncodedImage);
                    this.immutableBitmapFallback = true;
                    com.facebook.common.logging.FLog.wtf(TAG, "Immutable bitmap returned by decoder");
                    com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceCreateFallbackBitmap = createFallbackBitmap(width, height, bitmapConfig);
                    com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
                    closeableReferenceGenerate.close();
                    return closeableReferenceCreateFallbackBitmap;
                }
                closeableReferenceDecodeJPEGFromEncodedImage.get().setHasAlpha(true);
                closeableReferenceDecodeJPEGFromEncodedImage.get().eraseColor(0);
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
                closeableReferenceGenerate.close();
                return closeableReferenceDecodeJPEGFromEncodedImage;
            } catch (java.lang.Throwable th) {
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            closeableReferenceGenerate.close();
            throw th2;
        }
    }

    private final com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createFallbackBitmap(int width, int height, android.graphics.Bitmap.Config bitmapConfig) {
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceCreate = this.closeableReferenceFactory.create(android.graphics.Bitmap.createBitmap(width, height, bitmapConfig), com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser.getInstance());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(closeableReferenceCreate, "create(...)");
        return closeableReferenceCreate;
    }
}
