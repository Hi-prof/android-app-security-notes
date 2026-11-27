package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class BranchOnSeparateImagesProducer implements com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> {
    private final com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> mInputProducer1;
    private final com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> mInputProducer2;

    public BranchOnSeparateImagesProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer, com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer2) {
        this.mInputProducer1 = producer;
        this.mInputProducer2 = producer2;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        this.mInputProducer1.produceResults(new com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer.OnFirstImageConsumer(consumer, producerContext), producerContext);
    }

    private class OnFirstImageConsumer extends com.facebook.imagepipeline.producers.DelegatingConsumer<com.facebook.imagepipeline.image.EncodedImage, com.facebook.imagepipeline.image.EncodedImage> {
        private com.facebook.imagepipeline.producers.ProducerContext mProducerContext;

        private OnFirstImageConsumer(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
            super(consumer);
            this.mProducerContext = producerContext;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage, int i) {
            com.facebook.imagepipeline.request.ImageRequest imageRequest = this.mProducerContext.getImageRequest();
            boolean zIsLast = isLast(i);
            boolean zIsImageBigEnough = com.facebook.imagepipeline.producers.ThumbnailSizeChecker.isImageBigEnough(encodedImage, imageRequest.getResizeOptions());
            if (encodedImage != null && (zIsImageBigEnough || imageRequest.getLocalThumbnailPreviewsEnabled())) {
                if (zIsLast && zIsImageBigEnough) {
                    getConsumer().onNewResult(encodedImage, i);
                } else {
                    getConsumer().onNewResult(encodedImage, turnOffStatusFlag(i, 1));
                }
            }
            if (!zIsLast || zIsImageBigEnough || imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ()) {
                return;
            }
            com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
            com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer.this.mInputProducer2.produceResults(getConsumer(), this.mProducerContext);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onFailureImpl(@javax.annotation.Nullable java.lang.Throwable th) {
            com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer.this.mInputProducer2.produceResults(getConsumer(), this.mProducerContext);
        }
    }
}
