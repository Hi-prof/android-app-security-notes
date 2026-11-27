package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class LocalVideoThumbnailProducer implements com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> {
    static final java.lang.String CREATED_THUMBNAIL = "createdThumbnail";
    public static final java.lang.String PRODUCER_NAME = "VideoThumbnailProducer";
    private final android.content.ContentResolver mContentResolver;
    private final java.util.concurrent.Executor mExecutor;

    public LocalVideoThumbnailProducer(java.util.concurrent.Executor executor, android.content.ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumer, final com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        final com.facebook.imagepipeline.producers.ProducerListener2 producerListener = producerContext.getProducerListener();
        final com.facebook.imagepipeline.request.ImageRequest imageRequest = producerContext.getImageRequest();
        producerContext.putOriginExtra(com.taobao.weex.common.Constants.Scheme.LOCAL, "video");
        final com.facebook.imagepipeline.producers.StatefulProducerRunnable<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> statefulProducerRunnable = new com.facebook.imagepipeline.producers.StatefulProducerRunnable<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>(consumer, producerListener, producerContext, PRODUCER_NAME) { // from class: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void onSuccess(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference) {
                super.onSuccess(closeableReference);
                producerListener.onUltimateProducerReached(producerContext, com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.PRODUCER_NAME, closeableReference != null);
                producerContext.putOriginExtra(com.taobao.weex.common.Constants.Scheme.LOCAL, "video");
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            protected void onFailure(java.lang.Exception exc) {
                super.onFailure(exc);
                producerListener.onUltimateProducerReached(producerContext, com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.PRODUCER_NAME, false);
                producerContext.putOriginExtra(com.taobao.weex.common.Constants.Scheme.LOCAL, "video");
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.executors.StatefulRunnable
            @javax.annotation.Nullable
            public com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> getResult() throws java.lang.Exception {
                java.lang.String localFilePath;
                try {
                    localFilePath = com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.this.getLocalFilePath(imageRequest);
                } catch (java.lang.IllegalArgumentException unused) {
                    localFilePath = null;
                }
                android.graphics.Bitmap bitmapCreateVideoThumbnail = localFilePath != null ? android.media.ThumbnailUtils.createVideoThumbnail(localFilePath, com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.calculateKind(imageRequest)) : null;
                if (bitmapCreateVideoThumbnail == null) {
                    bitmapCreateVideoThumbnail = com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.createThumbnailFromContentProvider(com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.this.mContentResolver, imageRequest.getSourceUri());
                }
                if (bitmapCreateVideoThumbnail == null) {
                    return null;
                }
                com.facebook.imagepipeline.image.CloseableStaticBitmap closeableStaticBitmapOf = com.facebook.imagepipeline.image.CloseableStaticBitmap.CC.of(bitmapCreateVideoThumbnail, com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser.getInstance(), com.facebook.imagepipeline.image.ImmutableQualityInfo.FULL_QUALITY, 0);
                producerContext.putExtra("image_format", "thumbnail");
                closeableStaticBitmapOf.putExtras(producerContext.getExtras());
                return com.facebook.common.references.CloseableReference.of(closeableStaticBitmapOf);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public java.util.Map<java.lang.String, java.lang.String> getExtraMapOnSuccess(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference) {
                return com.facebook.common.internal.ImmutableMap.of(com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.CREATED_THUMBNAIL, java.lang.String.valueOf(closeableReference != null));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void disposeResult(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference) {
                com.facebook.common.references.CloseableReference.closeSafely(closeableReference);
            }
        };
        producerContext.addCallbacks(new com.facebook.imagepipeline.producers.BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                statefulProducerRunnable.cancel();
            }
        });
        this.mExecutor.execute(statefulProducerRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int calculateKind(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
        return (imageRequest.getPreferredWidth() > 96 || imageRequest.getPreferredHeight() > 96) ? 1 : 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @javax.annotation.Nullable
    public java.lang.String getLocalFilePath(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
        return com.facebook.common.util.UriUtil.getRealPathFromUri(this.mContentResolver, imageRequest.getSourceUri());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @javax.annotation.Nullable
    public static android.graphics.Bitmap createThumbnailFromContentProvider(android.content.ContentResolver contentResolver, android.net.Uri uri) {
        try {
            android.os.ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
            com.facebook.common.internal.Preconditions.checkNotNull(parcelFileDescriptorOpenFileDescriptor);
            android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
            return mediaMetadataRetriever.getFrameAtTime(-1L);
        } catch (java.io.FileNotFoundException unused) {
            return null;
        }
    }
}
