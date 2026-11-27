package com.facebook.imagepipeline.image;

/* JADX INFO: loaded from: classes.dex */
public class BaseCloseableStaticBitmap extends com.facebook.imagepipeline.image.BaseCloseableImage implements com.facebook.imagepipeline.image.CloseableStaticBitmap {
    private static boolean sUseSimpleCloseableStaticBitmap = false;

    @javax.annotation.Nullable
    private volatile android.graphics.Bitmap mBitmap;

    @javax.annotation.Nullable
    private com.facebook.common.references.CloseableReference<android.graphics.Bitmap> mBitmapReference;
    private final int mExifOrientation;
    private final com.facebook.imagepipeline.image.QualityInfo mQualityInfo;
    private final int mRotationAngle;

    protected BaseCloseableStaticBitmap(android.graphics.Bitmap bitmap, com.facebook.common.references.ResourceReleaser<android.graphics.Bitmap> resourceReleaser, com.facebook.imagepipeline.image.QualityInfo qualityInfo, int i, int i2) {
        this.mBitmap = (android.graphics.Bitmap) com.facebook.common.internal.Preconditions.checkNotNull(bitmap);
        this.mBitmapReference = com.facebook.common.references.CloseableReference.of(this.mBitmap, (com.facebook.common.references.ResourceReleaser<android.graphics.Bitmap>) com.facebook.common.internal.Preconditions.checkNotNull(resourceReleaser));
        this.mQualityInfo = qualityInfo;
        this.mRotationAngle = i;
        this.mExifOrientation = i2;
    }

    protected BaseCloseableStaticBitmap(com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReference, com.facebook.imagepipeline.image.QualityInfo qualityInfo, int i) {
        this(closeableReference, qualityInfo, i, 0);
    }

    protected BaseCloseableStaticBitmap(com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReference, com.facebook.imagepipeline.image.QualityInfo qualityInfo, int i, int i2) {
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReference2 = (com.facebook.common.references.CloseableReference) com.facebook.common.internal.Preconditions.checkNotNull(closeableReference.cloneOrNull());
        this.mBitmapReference = closeableReference2;
        this.mBitmap = closeableReference2.get();
        this.mQualityInfo = qualityInfo;
        this.mRotationAngle = i;
        this.mExifOrientation = i2;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceDetachBitmapReference = detachBitmapReference();
        if (closeableReferenceDetachBitmapReference != null) {
            closeableReferenceDetachBitmapReference.close();
        }
    }

    private synchronized com.facebook.common.references.CloseableReference<android.graphics.Bitmap> detachBitmapReference() {
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReference;
        closeableReference = this.mBitmapReference;
        this.mBitmapReference = null;
        this.mBitmap = null;
        return closeableReference;
    }

    @Override // com.facebook.imagepipeline.image.CloseableStaticBitmap
    public synchronized com.facebook.common.references.CloseableReference<android.graphics.Bitmap> convertToBitmapReference() {
        com.facebook.common.internal.Preconditions.checkNotNull(this.mBitmapReference, "Cannot convert a closed static bitmap");
        return detachBitmapReference();
    }

    @Override // com.facebook.imagepipeline.image.CloseableStaticBitmap
    @javax.annotation.Nullable
    public synchronized com.facebook.common.references.CloseableReference<android.graphics.Bitmap> cloneUnderlyingBitmapReference() {
        return com.facebook.common.references.CloseableReference.cloneOrNull(this.mBitmapReference);
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public synchronized boolean isClosed() {
        return this.mBitmapReference == null;
    }

    @Override // com.facebook.imagepipeline.image.CloseableBitmap
    public android.graphics.Bitmap getUnderlyingBitmap() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public int getSizeInBytes() {
        return com.facebook.imageutils.BitmapUtil.getSizeInBytes(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public int getWidth() {
        int i;
        if (this.mRotationAngle % 180 != 0 || (i = this.mExifOrientation) == 5 || i == 7) {
            return getBitmapHeight(this.mBitmap);
        }
        return getBitmapWidth(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public int getHeight() {
        int i;
        if (this.mRotationAngle % 180 != 0 || (i = this.mExifOrientation) == 5 || i == 7) {
            return getBitmapWidth(this.mBitmap);
        }
        return getBitmapHeight(this.mBitmap);
    }

    private static int getBitmapWidth(@javax.annotation.Nullable android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int getBitmapHeight(@javax.annotation.Nullable android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    @Override // com.facebook.imagepipeline.image.CloseableStaticBitmap
    public int getRotationAngle() {
        return this.mRotationAngle;
    }

    @Override // com.facebook.imagepipeline.image.CloseableStaticBitmap
    public int getExifOrientation() {
        return this.mExifOrientation;
    }

    @Override // com.facebook.imagepipeline.image.BaseCloseableImage, com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public com.facebook.imagepipeline.image.QualityInfo getQualityInfo() {
        return this.mQualityInfo;
    }

    public static void setUseSimpleCloseableStaticBitmap(boolean z) {
        sUseSimpleCloseableStaticBitmap = z;
    }

    public static boolean shouldUseSimpleCloseableStaticBitmap() {
        return sUseSimpleCloseableStaticBitmap;
    }
}
