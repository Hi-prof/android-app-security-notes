package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class ThumbnailBranchProducer implements com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> {
    private final com.facebook.imagepipeline.producers.ThumbnailProducer<com.facebook.imagepipeline.image.EncodedImage>[] mThumbnailProducers;

    public ThumbnailBranchProducer(com.facebook.imagepipeline.producers.ThumbnailProducer<com.facebook.imagepipeline.image.EncodedImage>... thumbnailProducerArr) {
        com.facebook.imagepipeline.producers.ThumbnailProducer<com.facebook.imagepipeline.image.EncodedImage>[] thumbnailProducerArr2 = (com.facebook.imagepipeline.producers.ThumbnailProducer[]) com.facebook.common.internal.Preconditions.checkNotNull(thumbnailProducerArr);
        this.mThumbnailProducers = thumbnailProducerArr2;
        com.facebook.common.internal.Preconditions.checkElementIndex(0, thumbnailProducerArr2.length);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        if (producerContext.getImageRequest().getResizeOptions() == null) {
            consumer.onNewResult(null, 1);
        } else {
            if (produceResultsFromThumbnailProducer(0, consumer, producerContext)) {
                return;
            }
            consumer.onNewResult(null, 1);
        }
    }

    private class ThumbnailConsumer extends com.facebook.imagepipeline.producers.DelegatingConsumer<com.facebook.imagepipeline.image.EncodedImage, com.facebook.imagepipeline.image.EncodedImage> {
        private final com.facebook.imagepipeline.producers.ProducerContext mProducerContext;
        private final int mProducerIndex;

        @javax.annotation.Nullable
        private final com.facebook.imagepipeline.common.ResizeOptions mResizeOptions;

        public ThumbnailConsumer(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext, int i) {
            super(consumer);
            this.mProducerContext = producerContext;
            this.mProducerIndex = i;
            this.mResizeOptions = producerContext.getImageRequest().getResizeOptions();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage, int i) {
            if (encodedImage != null && (isNotLast(i) || com.facebook.imagepipeline.producers.ThumbnailSizeChecker.isImageBigEnough(encodedImage, this.mResizeOptions))) {
                getConsumer().onNewResult(encodedImage, i);
            } else if (isLast(i)) {
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
                if (com.facebook.imagepipeline.producers.ThumbnailBranchProducer.this.produceResultsFromThumbnailProducer(this.mProducerIndex + 1, getConsumer(), this.mProducerContext)) {
                    return;
                }
                getConsumer().onNewResult(null, 1);
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onFailureImpl(java.lang.Throwable th) {
            if (com.facebook.imagepipeline.producers.ThumbnailBranchProducer.this.produceResultsFromThumbnailProducer(this.mProducerIndex + 1, getConsumer(), this.mProducerContext)) {
                return;
            }
            getConsumer().onFailure(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean produceResultsFromThumbnailProducer(int i, com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        int iFindFirstProducerForSize = findFirstProducerForSize(i, producerContext.getImageRequest().getResizeOptions());
        if (iFindFirstProducerForSize == -1) {
            return false;
        }
        this.mThumbnailProducers[iFindFirstProducerForSize].produceResults(new com.facebook.imagepipeline.producers.ThumbnailBranchProducer.ThumbnailConsumer(consumer, producerContext, iFindFirstProducerForSize), producerContext);
        return true;
    }

    private int findFirstProducerForSize(int i, @javax.annotation.Nullable com.facebook.imagepipeline.common.ResizeOptions resizeOptions) {
        while (true) {
            com.facebook.imagepipeline.producers.ThumbnailProducer<com.facebook.imagepipeline.image.EncodedImage>[] thumbnailProducerArr = this.mThumbnailProducers;
            if (i >= thumbnailProducerArr.length) {
                return -1;
            }
            if (thumbnailProducerArr[i].canProvideImageForSize(resizeOptions)) {
                return i;
            }
            i++;
        }
    }
}
