package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class DiskCacheReadProducer implements com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> {
    public static final java.lang.String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final java.lang.String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final java.lang.String PRODUCER_NAME = "DiskCacheProducer";
    private final com.facebook.imagepipeline.cache.CacheKeyFactory mCacheKeyFactory;
    private final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> mDiskCachesStoreSupplier;
    private final com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> mInputProducer;

    public DiskCacheReadProducer(com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> supplier, com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory, com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer) {
        this.mDiskCachesStoreSupplier = supplier;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        com.facebook.imagepipeline.request.ImageRequest imageRequest = producerContext.getImageRequest();
        if (!producerContext.getImageRequest().isCacheEnabled(16)) {
            maybeStartInputProducer(consumer, producerContext);
            return;
        }
        producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
        com.facebook.cache.common.CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, producerContext.getCallerContext());
        com.facebook.imagepipeline.core.DiskCachesStore diskCachesStore = this.mDiskCachesStoreSupplier.get();
        com.facebook.imagepipeline.cache.BufferedDiskCache bufferedDiskCacheChooseDiskCacheForRequest = com.facebook.imagepipeline.producers.DiskCacheDecision.chooseDiskCacheForRequest(imageRequest, diskCachesStore.getSmallImageBufferedDiskCache(), diskCachesStore.getMainBufferedDiskCache(), diskCachesStore.getDynamicBufferedDiskCaches());
        if (bufferedDiskCacheChooseDiskCacheForRequest == null) {
            producerContext.getProducerListener().onProducerFinishWithFailure(producerContext, PRODUCER_NAME, new com.facebook.imagepipeline.producers.DiskCacheDecision.DiskCacheDecisionNoDiskCacheChosenException("Got no disk cache for CacheChoice: " + java.lang.Integer.valueOf(imageRequest.getCacheChoice().ordinal()).toString()), null);
            maybeStartInputProducer(consumer, producerContext);
            return;
        }
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(false);
        bufferedDiskCacheChooseDiskCacheForRequest.get(encodedCacheKey, atomicBoolean).continueWith(onFinishDiskReads(consumer, producerContext));
        subscribeTaskForRequestCancellation(atomicBoolean, producerContext);
    }

    private bolts.Continuation<com.facebook.imagepipeline.image.EncodedImage, java.lang.Void> onFinishDiskReads(final com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, final com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        final com.facebook.imagepipeline.producers.ProducerListener2 producerListener = producerContext.getProducerListener();
        return new bolts.Continuation<com.facebook.imagepipeline.image.EncodedImage, java.lang.Void>() { // from class: com.facebook.imagepipeline.producers.DiskCacheReadProducer.1
            @Override // bolts.Continuation
            @javax.annotation.Nullable
            public java.lang.Void then(bolts.Task<com.facebook.imagepipeline.image.EncodedImage> task) throws java.lang.Exception {
                if (com.facebook.imagepipeline.producers.DiskCacheReadProducer.isTaskCancelled(task)) {
                    producerListener.onProducerFinishWithCancellation(producerContext, com.facebook.imagepipeline.producers.DiskCacheReadProducer.PRODUCER_NAME, null);
                    consumer.onCancellation();
                } else if (task.isFaulted()) {
                    producerListener.onProducerFinishWithFailure(producerContext, com.facebook.imagepipeline.producers.DiskCacheReadProducer.PRODUCER_NAME, task.getError(), null);
                    com.facebook.imagepipeline.producers.DiskCacheReadProducer.this.mInputProducer.produceResults(consumer, producerContext);
                } else {
                    com.facebook.imagepipeline.image.EncodedImage result = task.getResult();
                    if (result != null) {
                        com.facebook.imagepipeline.producers.ProducerListener2 producerListener2 = producerListener;
                        com.facebook.imagepipeline.producers.ProducerContext producerContext2 = producerContext;
                        producerListener2.onProducerFinishWithSuccess(producerContext2, com.facebook.imagepipeline.producers.DiskCacheReadProducer.PRODUCER_NAME, com.facebook.imagepipeline.producers.DiskCacheReadProducer.getExtraMap(producerListener2, producerContext2, true, result.getSize()));
                        producerListener.onUltimateProducerReached(producerContext, com.facebook.imagepipeline.producers.DiskCacheReadProducer.PRODUCER_NAME, true);
                        producerContext.putOriginExtra("disk");
                        consumer.onProgressUpdate(1.0f);
                        consumer.onNewResult(result, 1);
                        result.close();
                    } else {
                        com.facebook.imagepipeline.producers.ProducerListener2 producerListener3 = producerListener;
                        com.facebook.imagepipeline.producers.ProducerContext producerContext3 = producerContext;
                        producerListener3.onProducerFinishWithSuccess(producerContext3, com.facebook.imagepipeline.producers.DiskCacheReadProducer.PRODUCER_NAME, com.facebook.imagepipeline.producers.DiskCacheReadProducer.getExtraMap(producerListener3, producerContext3, false, 0));
                        com.facebook.imagepipeline.producers.DiskCacheReadProducer.this.mInputProducer.produceResults(consumer, producerContext);
                    }
                }
                return null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isTaskCancelled(bolts.Task<?> task) {
        if (task.isCancelled()) {
            return true;
        }
        return task.isFaulted() && (task.getError() instanceof java.util.concurrent.CancellationException);
    }

    private void maybeStartInputProducer(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        if (producerContext.getLowestPermittedRequestLevel().getValue() >= com.facebook.imagepipeline.request.ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            producerContext.putOriginExtra("disk", "nil-result_read");
            consumer.onNewResult(null, 1);
        } else {
            this.mInputProducer.produceResults(consumer, producerContext);
        }
    }

    @javax.annotation.Nullable
    static java.util.Map<java.lang.String, java.lang.String> getExtraMap(com.facebook.imagepipeline.producers.ProducerListener2 producerListener2, com.facebook.imagepipeline.producers.ProducerContext producerContext, boolean z, int i) {
        if (!producerListener2.requiresExtraMap(producerContext, PRODUCER_NAME)) {
            return null;
        }
        if (!z) {
            return com.facebook.common.internal.ImmutableMap.of("cached_value_found", java.lang.String.valueOf(z));
        }
        return com.facebook.common.internal.ImmutableMap.of("cached_value_found", java.lang.String.valueOf(z), "encodedImageSize", java.lang.String.valueOf(i));
    }

    private void subscribeTaskForRequestCancellation(final java.util.concurrent.atomic.AtomicBoolean atomicBoolean, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        producerContext.addCallbacks(new com.facebook.imagepipeline.producers.BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.DiskCacheReadProducer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                atomicBoolean.set(true);
            }
        });
    }
}
