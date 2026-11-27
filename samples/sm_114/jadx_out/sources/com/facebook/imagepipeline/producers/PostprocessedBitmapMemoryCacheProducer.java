package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class PostprocessedBitmapMemoryCacheProducer implements com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> {
    public static final java.lang.String PRODUCER_NAME = "PostprocessedBitmapMemoryCacheProducer";
    static final java.lang.String VALUE_FOUND = "cached_value_found";
    private final com.facebook.imagepipeline.cache.CacheKeyFactory mCacheKeyFactory;
    private final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> mInputProducer;
    private final com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> mMemoryCache;

    public PostprocessedBitmapMemoryCacheProducer(com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> memoryCache, com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory, com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        com.facebook.imagepipeline.producers.ProducerListener2 producerListener = producerContext.getProducerListener();
        com.facebook.imagepipeline.request.ImageRequest imageRequest = producerContext.getImageRequest();
        java.lang.Object callerContext = producerContext.getCallerContext();
        com.facebook.imagepipeline.request.Postprocessor postprocessor = imageRequest.getPostprocessor();
        if (postprocessor == null || postprocessor.getCacheKey() == null) {
            this.mInputProducer.produceResults(consumer, producerContext);
            return;
        }
        producerListener.onProducerStart(producerContext, getProducerName());
        com.facebook.cache.common.CacheKey postprocessedBitmapCacheKey = this.mCacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, callerContext);
        com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference = producerContext.getImageRequest().isCacheEnabled(1) ? this.mMemoryCache.get(postprocessedBitmapCacheKey) : null;
        if (closeableReference != null) {
            producerListener.onProducerFinishWithSuccess(producerContext, getProducerName(), producerListener.requiresExtraMap(producerContext, getProducerName()) ? com.facebook.common.internal.ImmutableMap.of("cached_value_found", io.dcloud.common.constant.AbsoluteConst.TRUE) : null);
            producerListener.onUltimateProducerReached(producerContext, PRODUCER_NAME, true);
            producerContext.putOriginExtra("memory_bitmap", "postprocessed");
            consumer.onProgressUpdate(1.0f);
            consumer.onNewResult(closeableReference, 1);
            closeableReference.close();
            return;
        }
        com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer.CachedPostprocessorConsumer cachedPostprocessorConsumer = new com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer.CachedPostprocessorConsumer(consumer, postprocessedBitmapCacheKey, postprocessor instanceof com.facebook.imagepipeline.request.RepeatedPostprocessor, this.mMemoryCache, producerContext.getImageRequest().isCacheEnabled(2));
        producerListener.onProducerFinishWithSuccess(producerContext, getProducerName(), producerListener.requiresExtraMap(producerContext, getProducerName()) ? com.facebook.common.internal.ImmutableMap.of("cached_value_found", io.dcloud.common.constant.AbsoluteConst.FALSE) : null);
        this.mInputProducer.produceResults(cachedPostprocessorConsumer, producerContext);
    }

    public static class CachedPostprocessorConsumer extends com.facebook.imagepipeline.producers.DelegatingConsumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>, com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> {
        private final com.facebook.cache.common.CacheKey mCacheKey;
        private final boolean mIsBitmapCacheEnabledForWrite;
        private final boolean mIsRepeatedProcessor;
        private final com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> mMemoryCache;

        public CachedPostprocessorConsumer(com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumer, com.facebook.cache.common.CacheKey cacheKey, boolean z, com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> memoryCache, boolean z2) {
            super(consumer);
            this.mCacheKey = cacheKey;
            this.mIsRepeatedProcessor = z;
            this.mMemoryCache = memoryCache;
            this.mIsBitmapCacheEnabledForWrite = z2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference, int i) {
            if (closeableReference == null) {
                if (isLast(i)) {
                    getConsumer().onNewResult(null, i);
                }
            } else if (!isNotLast(i) || this.mIsRepeatedProcessor) {
                com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReferenceCache = this.mIsBitmapCacheEnabledForWrite ? this.mMemoryCache.cache(this.mCacheKey, closeableReference) : null;
                try {
                    getConsumer().onProgressUpdate(1.0f);
                    com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumer = getConsumer();
                    if (closeableReferenceCache != null) {
                        closeableReference = closeableReferenceCache;
                    }
                    consumer.onNewResult(closeableReference, i);
                } finally {
                    com.facebook.common.references.CloseableReference.closeSafely(closeableReferenceCache);
                }
            }
        }
    }

    protected java.lang.String getProducerName() {
        return PRODUCER_NAME;
    }
}
