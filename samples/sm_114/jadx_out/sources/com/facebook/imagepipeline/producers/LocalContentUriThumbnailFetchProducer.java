package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class LocalContentUriThumbnailFetchProducer extends com.facebook.imagepipeline.producers.LocalFetchProducer implements com.facebook.imagepipeline.producers.ThumbnailProducer<com.facebook.imagepipeline.image.EncodedImage> {
    private static final int NO_THUMBNAIL = 0;
    public static final java.lang.String PRODUCER_NAME = "LocalContentUriThumbnailFetchProducer";
    private final android.content.ContentResolver mContentResolver;
    private static final java.lang.Class<?> TAG = com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer.class;
    private static final java.lang.String[] PROJECTION = {"_id", "_data"};
    private static final java.lang.String[] THUMBNAIL_PROJECTION = {"_data"};
    private static final android.graphics.Rect MINI_THUMBNAIL_DIMENSIONS = new android.graphics.Rect(0, 0, 512, com.facebook.imagepipeline.memory.BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT);
    private static final android.graphics.Rect MICRO_THUMBNAIL_DIMENSIONS = new android.graphics.Rect(0, 0, 96, 96);

    public LocalContentUriThumbnailFetchProducer(java.util.concurrent.Executor executor, com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory, android.content.ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.ThumbnailProducer
    public boolean canProvideImageForSize(@javax.annotation.Nullable com.facebook.imagepipeline.common.ResizeOptions resizeOptions) {
        android.graphics.Rect rect = MINI_THUMBNAIL_DIMENSIONS;
        return com.facebook.imagepipeline.producers.ThumbnailSizeChecker.isImageBigEnough(rect.width(), rect.height(), resizeOptions);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    @javax.annotation.Nullable
    protected com.facebook.imagepipeline.image.EncodedImage getEncodedImage(com.facebook.imagepipeline.request.ImageRequest imageRequest) throws java.io.IOException {
        android.net.Uri sourceUri = imageRequest.getSourceUri();
        if (com.facebook.common.util.UriUtil.isLocalCameraUri(sourceUri)) {
            return getCameraImage(sourceUri, imageRequest.getResizeOptions());
        }
        return null;
    }

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.image.EncodedImage getCameraImage(android.net.Uri uri, @javax.annotation.Nullable com.facebook.imagepipeline.common.ResizeOptions resizeOptions) throws java.io.IOException {
        android.database.Cursor cursorQuery;
        com.facebook.imagepipeline.image.EncodedImage thumbnail;
        if (resizeOptions == null || (cursorQuery = this.mContentResolver.query(uri, PROJECTION, null, null, null)) == null) {
            return null;
        }
        try {
            if (!cursorQuery.moveToFirst() || (thumbnail = getThumbnail(resizeOptions, cursorQuery.getLong(cursorQuery.getColumnIndex("_id")))) == null) {
                return null;
            }
            int columnIndex = cursorQuery.getColumnIndex("_data");
            if (columnIndex >= 0) {
                thumbnail.setRotationAngle(getRotationAngle(cursorQuery.getString(columnIndex)));
            }
            return thumbnail;
        } finally {
            cursorQuery.close();
        }
    }

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.image.EncodedImage getThumbnail(com.facebook.imagepipeline.common.ResizeOptions resizeOptions, long j) throws java.io.IOException {
        android.database.Cursor cursorQueryMiniThumbnail;
        int columnIndex;
        int thumbnailKind = getThumbnailKind(resizeOptions);
        if (thumbnailKind == 0 || (cursorQueryMiniThumbnail = android.provider.MediaStore.Images.Thumbnails.queryMiniThumbnail(this.mContentResolver, j, thumbnailKind, THUMBNAIL_PROJECTION)) == null) {
            return null;
        }
        try {
            if (cursorQueryMiniThumbnail.moveToFirst() && (columnIndex = cursorQueryMiniThumbnail.getColumnIndex("_data")) >= 0) {
                java.lang.String str = (java.lang.String) com.facebook.common.internal.Preconditions.checkNotNull(cursorQueryMiniThumbnail.getString(columnIndex));
                if (new java.io.File(str).exists()) {
                    return getEncodedImage(new java.io.FileInputStream(str), getLength(str));
                }
            }
            return null;
        } finally {
            cursorQueryMiniThumbnail.close();
        }
    }

    private static int getThumbnailKind(com.facebook.imagepipeline.common.ResizeOptions resizeOptions) {
        android.graphics.Rect rect = MICRO_THUMBNAIL_DIMENSIONS;
        if (com.facebook.imagepipeline.producers.ThumbnailSizeChecker.isImageBigEnough(rect.width(), rect.height(), resizeOptions)) {
            return 3;
        }
        android.graphics.Rect rect2 = MINI_THUMBNAIL_DIMENSIONS;
        return com.facebook.imagepipeline.producers.ThumbnailSizeChecker.isImageBigEnough(rect2.width(), rect2.height(), resizeOptions) ? 1 : 0;
    }

    private static int getLength(java.lang.String str) {
        if (str == null) {
            return -1;
        }
        return (int) new java.io.File(str).length();
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected java.lang.String getProducerName() {
        return PRODUCER_NAME;
    }

    private static int getRotationAngle(@javax.annotation.Nullable java.lang.String str) {
        if (str != null) {
            try {
                return com.facebook.imageutils.JfifUtil.getAutoRotateAngleFromOrientation(new android.media.ExifInterface(str).getAttributeInt("Orientation", 1));
            } catch (java.io.IOException e) {
                com.facebook.common.logging.FLog.e(TAG, e, "Unable to retrieve thumbnail rotation for %s", str);
            }
        }
        return 0;
    }
}
