package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class LocalExifThumbnailProducer implements com.facebook.imagepipeline.producers.ThumbnailProducer<com.facebook.imagepipeline.image.EncodedImage> {
    private static final int COMMON_EXIF_THUMBNAIL_MAX_DIMENSION = 512;
    static final java.lang.String CREATED_THUMBNAIL = "createdThumbnail";
    public static final java.lang.String PRODUCER_NAME = "LocalExifThumbnailProducer";
    private final android.content.ContentResolver mContentResolver;
    private final java.util.concurrent.Executor mExecutor;
    private final com.facebook.common.memory.PooledByteBufferFactory mPooledByteBufferFactory;

    public LocalExifThumbnailProducer(java.util.concurrent.Executor executor, com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory, android.content.ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.ThumbnailProducer
    public boolean canProvideImageForSize(@javax.annotation.Nullable com.facebook.imagepipeline.common.ResizeOptions resizeOptions) {
        return com.facebook.imagepipeline.producers.ThumbnailSizeChecker.isImageBigEnough(512, 512, resizeOptions);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        com.facebook.imagepipeline.producers.ProducerListener2 producerListener = producerContext.getProducerListener();
        final com.facebook.imagepipeline.request.ImageRequest imageRequest = producerContext.getImageRequest();
        producerContext.putOriginExtra(com.taobao.weex.common.Constants.Scheme.LOCAL, "exif");
        final com.facebook.imagepipeline.producers.StatefulProducerRunnable<com.facebook.imagepipeline.image.EncodedImage> statefulProducerRunnable = new com.facebook.imagepipeline.producers.StatefulProducerRunnable<com.facebook.imagepipeline.image.EncodedImage>(consumer, producerListener, producerContext, PRODUCER_NAME) { // from class: com.facebook.imagepipeline.producers.LocalExifThumbnailProducer.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.executors.StatefulRunnable
            @javax.annotation.Nullable
            public com.facebook.imagepipeline.image.EncodedImage getResult() throws java.lang.Exception {
                android.media.ExifInterface exifInterface = com.facebook.imagepipeline.producers.LocalExifThumbnailProducer.this.getExifInterface(imageRequest.getSourceUri());
                if (exifInterface == null || !exifInterface.hasThumbnail()) {
                    return null;
                }
                return com.facebook.imagepipeline.producers.LocalExifThumbnailProducer.this.buildEncodedImage(com.facebook.imagepipeline.producers.LocalExifThumbnailProducer.this.mPooledByteBufferFactory.newByteBuffer((byte[]) com.facebook.common.internal.Preconditions.checkNotNull(exifInterface.getThumbnail())), exifInterface);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void disposeResult(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage) {
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public java.util.Map<java.lang.String, java.lang.String> getExtraMapOnSuccess(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage) {
                return com.facebook.common.internal.ImmutableMap.of(com.facebook.imagepipeline.producers.LocalExifThumbnailProducer.CREATED_THUMBNAIL, java.lang.Boolean.toString(encodedImage != null));
            }
        };
        producerContext.addCallbacks(new com.facebook.imagepipeline.producers.BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.LocalExifThumbnailProducer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                statefulProducerRunnable.cancel();
            }
        });
        this.mExecutor.execute(statefulProducerRunnable);
    }

    @javax.annotation.Nullable
    android.media.ExifInterface getExifInterface(android.net.Uri uri) {
        java.lang.String realPathFromUri = com.facebook.common.util.UriUtil.getRealPathFromUri(this.mContentResolver, uri);
        if (realPathFromUri == null) {
            return null;
        }
        try {
            if (canReadAsFile(realPathFromUri)) {
                return new android.media.ExifInterface(realPathFromUri);
            }
            android.content.res.AssetFileDescriptor assetFileDescriptor = com.facebook.common.util.UriUtil.getAssetFileDescriptor(this.mContentResolver, uri);
            if (assetFileDescriptor != null && android.os.Build.VERSION.SDK_INT >= 24) {
                android.media.ExifInterface exifInterface = new com.facebook.imagepipeline.producers.LocalExifThumbnailProducer.Api24Utils().getExifInterface(assetFileDescriptor.getFileDescriptor());
                assetFileDescriptor.close();
                return exifInterface;
            }
            return null;
        } catch (java.io.IOException unused) {
        } catch (java.lang.StackOverflowError unused2) {
            com.facebook.common.logging.FLog.e((java.lang.Class<?>) com.facebook.imagepipeline.producers.LocalExifThumbnailProducer.class, "StackOverflowError in ExifInterface constructor");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.image.EncodedImage buildEncodedImage(com.facebook.common.memory.PooledByteBuffer pooledByteBuffer, android.media.ExifInterface exifInterface) {
        android.util.Pair<java.lang.Integer, java.lang.Integer> pairDecodeDimensions = com.facebook.imageutils.BitmapUtil.decodeDimensions(new com.facebook.common.memory.PooledByteBufferInputStream(pooledByteBuffer));
        int rotationAngle = getRotationAngle(exifInterface);
        int iIntValue = pairDecodeDimensions != null ? ((java.lang.Integer) pairDecodeDimensions.first).intValue() : -1;
        int iIntValue2 = pairDecodeDimensions != null ? ((java.lang.Integer) pairDecodeDimensions.second).intValue() : -1;
        com.facebook.common.references.CloseableReference closeableReferenceOf = com.facebook.common.references.CloseableReference.of(pooledByteBuffer);
        try {
            com.facebook.imagepipeline.image.EncodedImage encodedImage = new com.facebook.imagepipeline.image.EncodedImage((com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>) closeableReferenceOf);
            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReferenceOf);
            encodedImage.setImageFormat(com.facebook.imageformat.DefaultImageFormats.JPEG);
            encodedImage.setRotationAngle(rotationAngle);
            encodedImage.setWidth(iIntValue);
            encodedImage.setHeight(iIntValue2);
            return encodedImage;
        } catch (java.lang.Throwable th) {
            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReferenceOf);
            throw th;
        }
    }

    private int getRotationAngle(android.media.ExifInterface exifInterface) {
        return com.facebook.imageutils.JfifUtil.getAutoRotateAngleFromOrientation(java.lang.Integer.parseInt((java.lang.String) com.facebook.common.internal.Preconditions.checkNotNull(exifInterface.getAttribute("Orientation"))));
    }

    boolean canReadAsFile(java.lang.String str) throws java.io.IOException {
        if (str == null) {
            return false;
        }
        java.io.File file = new java.io.File(str);
        return file.exists() && file.canRead();
    }

    private class Api24Utils {
        private Api24Utils() {
        }

        @javax.annotation.Nullable
        android.media.ExifInterface getExifInterface(java.io.FileDescriptor fileDescriptor) throws java.io.IOException {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                return dc.squareup.okio.Okio$$ExternalSyntheticApiModelOutline0.m(fileDescriptor);
            }
            return null;
        }
    }
}
