package com.facebook.imagepipeline.image;

/* JADX INFO: loaded from: classes.dex */
class DefaultCloseableStaticBitmap extends com.facebook.imagepipeline.image.BaseCloseableStaticBitmap {
    private static final java.lang.String TAG = "DefaultCloseableStaticBitmap";

    protected DefaultCloseableStaticBitmap(com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReference, com.facebook.imagepipeline.image.QualityInfo qualityInfo, int i, int i2) {
        super(closeableReference, qualityInfo, i, i2);
    }

    protected DefaultCloseableStaticBitmap(android.graphics.Bitmap bitmap, com.facebook.common.references.ResourceReleaser<android.graphics.Bitmap> resourceReleaser, com.facebook.imagepipeline.image.QualityInfo qualityInfo, int i, int i2) {
        super(bitmap, resourceReleaser, qualityInfo, i, i2);
    }

    protected void finalize() throws java.lang.Throwable {
        if (isClosed()) {
            return;
        }
        com.facebook.common.logging.FLog.w(TAG, "finalize: %s %x still open.", getClass().getSimpleName(), java.lang.Integer.valueOf(java.lang.System.identityHashCode(this)));
        try {
            close();
        } finally {
            super.finalize();
        }
    }
}
