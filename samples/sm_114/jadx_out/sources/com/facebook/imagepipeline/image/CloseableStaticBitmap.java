package com.facebook.imagepipeline.image;

/* JADX INFO: loaded from: classes.dex */
public interface CloseableStaticBitmap extends com.facebook.imagepipeline.image.CloseableBitmap {
    com.facebook.common.references.CloseableReference<android.graphics.Bitmap> cloneUnderlyingBitmapReference();

    com.facebook.common.references.CloseableReference<android.graphics.Bitmap> convertToBitmapReference();

    int getExifOrientation();

    int getRotationAngle();

    /* JADX INFO: renamed from: com.facebook.imagepipeline.image.CloseableStaticBitmap$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static com.facebook.imagepipeline.image.CloseableStaticBitmap of(android.graphics.Bitmap bitmap, com.facebook.common.references.ResourceReleaser<android.graphics.Bitmap> resourceReleaser, com.facebook.imagepipeline.image.QualityInfo qualityInfo, int i) {
            return of(bitmap, resourceReleaser, qualityInfo, i, 0);
        }

        public static com.facebook.imagepipeline.image.CloseableStaticBitmap of(com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReference, com.facebook.imagepipeline.image.QualityInfo qualityInfo, int i) {
            return of(closeableReference, qualityInfo, i, 0);
        }

        public static com.facebook.imagepipeline.image.CloseableStaticBitmap of(android.graphics.Bitmap bitmap, com.facebook.common.references.ResourceReleaser<android.graphics.Bitmap> resourceReleaser, com.facebook.imagepipeline.image.QualityInfo qualityInfo, int i, int i2) {
            if (com.facebook.imagepipeline.image.BaseCloseableStaticBitmap.shouldUseSimpleCloseableStaticBitmap()) {
                return new com.facebook.imagepipeline.image.BaseCloseableStaticBitmap(bitmap, resourceReleaser, qualityInfo, i, i2);
            }
            return new com.facebook.imagepipeline.image.DefaultCloseableStaticBitmap(bitmap, resourceReleaser, qualityInfo, i, i2);
        }

        public static com.facebook.imagepipeline.image.CloseableStaticBitmap of(com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReference, com.facebook.imagepipeline.image.QualityInfo qualityInfo, int i, int i2) {
            if (com.facebook.imagepipeline.image.BaseCloseableStaticBitmap.shouldUseSimpleCloseableStaticBitmap()) {
                return new com.facebook.imagepipeline.image.BaseCloseableStaticBitmap(closeableReference, qualityInfo, i, i2);
            }
            return new com.facebook.imagepipeline.image.DefaultCloseableStaticBitmap(closeableReference, qualityInfo, i, i2);
        }
    }
}
