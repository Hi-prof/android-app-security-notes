package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class LocalThumbnailBitmapSdk29Producer implements com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> {
    static final java.lang.String CREATED_THUMBNAIL = "createdThumbnail";
    public static final java.lang.String PRODUCER_NAME = "LocalThumbnailBitmapSdk29Producer";
    private final android.content.ContentResolver mContentResolver;
    private final java.util.concurrent.Executor mExecutor;

    public LocalThumbnailBitmapSdk29Producer(java.util.concurrent.Executor executor, android.content.ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumer, final com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        final com.facebook.imagepipeline.producers.ProducerListener2 producerListener = producerContext.getProducerListener();
        final com.facebook.imagepipeline.request.ImageRequest imageRequest = producerContext.getImageRequest();
        producerContext.putOriginExtra(com.taobao.weex.common.Constants.Scheme.LOCAL, "thumbnail_bitmap");
        final android.os.CancellationSignal cancellationSignal = new android.os.CancellationSignal();
        final com.facebook.imagepipeline.producers.StatefulProducerRunnable<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> statefulProducerRunnable = new com.facebook.imagepipeline.producers.StatefulProducerRunnable<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>(consumer, producerListener, producerContext, PRODUCER_NAME) { // from class: com.facebook.imagepipeline.producers.LocalThumbnailBitmapSdk29Producer.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void onSuccess(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference) {
                super.onSuccess(closeableReference);
                producerListener.onUltimateProducerReached(producerContext, com.facebook.imagepipeline.producers.LocalThumbnailBitmapSdk29Producer.PRODUCER_NAME, closeableReference != null);
                producerContext.putOriginExtra(com.taobao.weex.common.Constants.Scheme.LOCAL, "thumbnail_bitmap");
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            protected void onFailure(java.lang.Exception exc) {
                super.onFailure(exc);
                producerListener.onUltimateProducerReached(producerContext, com.facebook.imagepipeline.producers.LocalThumbnailBitmapSdk29Producer.PRODUCER_NAME, false);
                producerContext.putOriginExtra(com.taobao.weex.common.Constants.Scheme.LOCAL, "thumbnail_bitmap");
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.executors.StatefulRunnable
            @javax.annotation.Nullable
            public com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> getResult() throws java.io.IOException {
                java.lang.String localFilePath;
                android.graphics.Bitmap bitmapLoadThumbnail;
                android.util.Size size = new android.util.Size(imageRequest.getPreferredWidth(), imageRequest.getPreferredHeight());
                try {
                    localFilePath = com.facebook.imagepipeline.producers.LocalThumbnailBitmapSdk29Producer.this.getLocalFilePath(imageRequest);
                } catch (java.lang.IllegalArgumentException unused) {
                    localFilePath = null;
                }
                if (localFilePath == null) {
                    bitmapLoadThumbnail = null;
                } else if (com.facebook.common.media.MediaUtils.isVideo(com.facebook.common.media.MediaUtils.extractMime(localFilePath))) {
                    bitmapLoadThumbnail = android.media.ThumbnailUtils.createVideoThumbnail(new java.io.File(localFilePath), size, cancellationSignal);
                } else {
                    bitmapLoadThumbnail = android.media.ThumbnailUtils.createImageThumbnail(new java.io.File(localFilePath), size, cancellationSignal);
                }
                if (bitmapLoadThumbnail == null) {
                    bitmapLoadThumbnail = com.facebook.imagepipeline.producers.LocalThumbnailBitmapSdk29Producer.this.mContentResolver.loadThumbnail(imageRequest.getSourceUri(), size, cancellationSignal);
                }
                if (bitmapLoadThumbnail == null) {
                    return null;
                }
                com.facebook.imagepipeline.image.CloseableStaticBitmap closeableStaticBitmapOf = com.facebook.imagepipeline.image.CloseableStaticBitmap.CC.of(bitmapLoadThumbnail, com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser.getInstance(), com.facebook.imagepipeline.image.ImmutableQualityInfo.FULL_QUALITY, 0);
                producerContext.putExtra("image_format", "thumbnail");
                closeableStaticBitmapOf.putExtras(producerContext.getExtras());
                return com.facebook.common.references.CloseableReference.of(closeableStaticBitmapOf);
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            protected void onCancellation() {
                super.onCancellation();
                cancellationSignal.cancel();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public java.util.Map<java.lang.String, java.lang.String> getExtraMapOnSuccess(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference) {
                return com.facebook.common.internal.ImmutableMap.of(com.facebook.imagepipeline.producers.LocalThumbnailBitmapSdk29Producer.CREATED_THUMBNAIL, java.lang.String.valueOf(closeableReference != null));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void disposeResult(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference) {
                com.facebook.common.references.CloseableReference.closeSafely(closeableReference);
            }
        };
        producerContext.addCallbacks(new com.facebook.imagepipeline.producers.BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.LocalThumbnailBitmapSdk29Producer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                statefulProducerRunnable.cancel();
            }
        });
        this.mExecutor.execute(statefulProducerRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @javax.annotation.Nullable
    public java.lang.String getLocalFilePath(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
        return com.facebook.common.util.UriUtil.getRealPathFromUri(this.mContentResolver, imageRequest.getSourceUri());
    }
}
