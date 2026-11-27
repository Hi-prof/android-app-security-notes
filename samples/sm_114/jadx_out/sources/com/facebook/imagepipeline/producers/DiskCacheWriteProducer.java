package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class DiskCacheWriteProducer implements com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> {
    static final java.lang.String PRODUCER_NAME = "DiskCacheWriteProducer";
    private final com.facebook.imagepipeline.cache.CacheKeyFactory mCacheKeyFactory;
    private final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> mDiskCachesStoreSupplier;
    private final com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> mInputProducer;

    public DiskCacheWriteProducer(com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> supplier, com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory, com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer) {
        this.mDiskCachesStoreSupplier = supplier;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        maybeStartInputProducer(consumer, producerContext);
    }

    private void maybeStartInputProducer(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        com.facebook.imagepipeline.producers.ProducerContext producerContext2;
        if (producerContext.getLowestPermittedRequestLevel().getValue() >= com.facebook.imagepipeline.request.ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            producerContext.putOriginExtra("disk", "nil-result_write");
            consumer.onNewResult(null, 1);
            return;
        }
        if (producerContext.getImageRequest().isCacheEnabled(32)) {
            producerContext2 = producerContext;
            consumer = new com.facebook.imagepipeline.producers.DiskCacheWriteProducer.DiskCacheWriteConsumer(consumer, producerContext2, this.mDiskCachesStoreSupplier, this.mCacheKeyFactory);
        } else {
            producerContext2 = producerContext;
        }
        this.mInputProducer.produceResults(consumer, producerContext2);
    }

    private static class DiskCacheWriteConsumer extends com.facebook.imagepipeline.producers.DelegatingConsumer<com.facebook.imagepipeline.image.EncodedImage, com.facebook.imagepipeline.image.EncodedImage> {
        private final com.facebook.imagepipeline.cache.CacheKeyFactory mCacheKeyFactory;
        private final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> mDiskCachesStoreSupplier;
        private final com.facebook.imagepipeline.producers.ProducerContext mProducerContext;

        private DiskCacheWriteConsumer(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext, com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> supplier, com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory) {
            super(consumer);
            this.mProducerContext = producerContext;
            this.mDiskCachesStoreSupplier = supplier;
            this.mCacheKeyFactory = cacheKeyFactory;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage, int i) {
            this.mProducerContext.getProducerListener().onProducerStart(this.mProducerContext, com.facebook.imagepipeline.producers.DiskCacheWriteProducer.PRODUCER_NAME);
            if (isNotLast(i) || encodedImage == null || statusHasAnyFlag(i, 10) || encodedImage.getImageFormat() == com.facebook.imageformat.ImageFormat.UNKNOWN) {
                this.mProducerContext.getProducerListener().onProducerFinishWithSuccess(this.mProducerContext, com.facebook.imagepipeline.producers.DiskCacheWriteProducer.PRODUCER_NAME, null);
                getConsumer().onNewResult(encodedImage, i);
                return;
            }
            com.facebook.imagepipeline.request.ImageRequest imageRequest = this.mProducerContext.getImageRequest();
            com.facebook.cache.common.CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, this.mProducerContext.getCallerContext());
            com.facebook.imagepipeline.core.DiskCachesStore diskCachesStore = this.mDiskCachesStoreSupplier.get();
            com.facebook.imagepipeline.cache.BufferedDiskCache bufferedDiskCacheChooseDiskCacheForRequest = com.facebook.imagepipeline.producers.DiskCacheDecision.chooseDiskCacheForRequest(imageRequest, diskCachesStore.getSmallImageBufferedDiskCache(), diskCachesStore.getMainBufferedDiskCache(), diskCachesStore.getDynamicBufferedDiskCaches());
            if (bufferedDiskCacheChooseDiskCacheForRequest == null) {
                this.mProducerContext.getProducerListener().onProducerFinishWithFailure(this.mProducerContext, com.facebook.imagepipeline.producers.DiskCacheWriteProducer.PRODUCER_NAME, new com.facebook.imagepipeline.producers.DiskCacheDecision.DiskCacheDecisionNoDiskCacheChosenException("Got no disk cache for CacheChoice: " + java.lang.Integer.valueOf(imageRequest.getCacheChoice().ordinal()).toString()), null);
                getConsumer().onNewResult(encodedImage, i);
                return;
            }
            bufferedDiskCacheChooseDiskCacheForRequest.put(encodedCacheKey, encodedImage);
            this.mProducerContext.getProducerListener().onProducerFinishWithSuccess(this.mProducerContext, com.facebook.imagepipeline.producers.DiskCacheWriteProducer.PRODUCER_NAME, null);
            getConsumer().onNewResult(encodedImage, i);
        }
    }
}
