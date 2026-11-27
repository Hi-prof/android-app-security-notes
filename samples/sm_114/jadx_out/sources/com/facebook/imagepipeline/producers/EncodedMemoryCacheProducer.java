package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class EncodedMemoryCacheProducer implements com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> {
    public static final java.lang.String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final java.lang.String PRODUCER_NAME = "EncodedMemoryCacheProducer";
    private final com.facebook.imagepipeline.cache.CacheKeyFactory mCacheKeyFactory;
    private final com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> mInputProducer;
    private final com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> mMemoryCache;

    public EncodedMemoryCacheProducer(com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> memoryCache, com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory, com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        try {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("EncodedMemoryCacheProducer#produceResults");
            }
            com.facebook.imagepipeline.producers.ProducerListener2 producerListener = producerContext.getProducerListener();
            producerListener.onProducerStart(producerContext, PRODUCER_NAME);
            com.facebook.cache.common.CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext());
            com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> closeableReference = producerContext.getImageRequest().isCacheEnabled(4) ? this.mMemoryCache.get(encodedCacheKey) : null;
            try {
                if (closeableReference != null) {
                    com.facebook.imagepipeline.image.EncodedImage encodedImage = new com.facebook.imagepipeline.image.EncodedImage(closeableReference);
                    try {
                        producerListener.onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, producerListener.requiresExtraMap(producerContext, PRODUCER_NAME) ? com.facebook.common.internal.ImmutableMap.of("cached_value_found", io.dcloud.common.constant.AbsoluteConst.TRUE) : null);
                        producerListener.onUltimateProducerReached(producerContext, PRODUCER_NAME, true);
                        producerContext.putOriginExtra("memory_encoded");
                        consumer.onProgressUpdate(1.0f);
                        consumer.onNewResult(encodedImage, 1);
                        com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
                        com.facebook.common.references.CloseableReference.closeSafely(closeableReference);
                        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                            return;
                        }
                        return;
                    } catch (java.lang.Throwable th) {
                        com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
                        throw th;
                    }
                }
                if (producerContext.getLowestPermittedRequestLevel().getValue() < com.facebook.imagepipeline.request.ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                    com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer.EncodedMemoryCacheConsumer encodedMemoryCacheConsumer = new com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer.EncodedMemoryCacheConsumer(consumer, this.mMemoryCache, encodedCacheKey, producerContext.getImageRequest().isCacheEnabled(8), producerContext.getImagePipelineConfig().getExperiments().getIsEncodedCacheEnabled());
                    producerListener.onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, producerListener.requiresExtraMap(producerContext, PRODUCER_NAME) ? com.facebook.common.internal.ImmutableMap.of("cached_value_found", io.dcloud.common.constant.AbsoluteConst.FALSE) : null);
                    this.mInputProducer.produceResults(encodedMemoryCacheConsumer, producerContext);
                    com.facebook.common.references.CloseableReference.closeSafely(closeableReference);
                    if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                        com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                        return;
                    }
                    return;
                }
                producerListener.onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, producerListener.requiresExtraMap(producerContext, PRODUCER_NAME) ? com.facebook.common.internal.ImmutableMap.of("cached_value_found", io.dcloud.common.constant.AbsoluteConst.FALSE) : null);
                producerListener.onUltimateProducerReached(producerContext, PRODUCER_NAME, false);
                producerContext.putOriginExtra("memory_encoded", "nil-result");
                consumer.onNewResult(null, 1);
                com.facebook.common.references.CloseableReference.closeSafely(closeableReference);
                if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                }
            } catch (java.lang.Throwable th2) {
                com.facebook.common.references.CloseableReference.closeSafely(closeableReference);
                throw th2;
            }
        } catch (java.lang.Throwable th3) {
            if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                throw th3;
            }
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            throw th3;
        }
    }

    private static class EncodedMemoryCacheConsumer extends com.facebook.imagepipeline.producers.DelegatingConsumer<com.facebook.imagepipeline.image.EncodedImage, com.facebook.imagepipeline.image.EncodedImage> {
        private final boolean mEncodedCacheEnabled;
        private final boolean mIsEncodedCacheEnabledForWrite;
        private final com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> mMemoryCache;
        private final com.facebook.cache.common.CacheKey mRequestedCacheKey;

        public EncodedMemoryCacheConsumer(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> memoryCache, com.facebook.cache.common.CacheKey cacheKey, boolean z, boolean z2) {
            super(consumer);
            this.mMemoryCache = memoryCache;
            this.mRequestedCacheKey = cacheKey;
            this.mIsEncodedCacheEnabledForWrite = z;
            this.mEncodedCacheEnabled = z2;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage, int i) {
            try {
                if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("EncodedMemoryCacheProducer#onNewResultImpl");
                }
                if (!isNotLast(i) && encodedImage != null && !statusHasAnyFlag(i, 10) && encodedImage.getImageFormat() != com.facebook.imageformat.ImageFormat.UNKNOWN) {
                    com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
                    if (byteBufferRef != null) {
                        try {
                            com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> closeableReferenceCache = (this.mEncodedCacheEnabled && this.mIsEncodedCacheEnabledForWrite) ? this.mMemoryCache.cache(this.mRequestedCacheKey, byteBufferRef) : null;
                            com.facebook.common.references.CloseableReference.closeSafely(byteBufferRef);
                            if (closeableReferenceCache != null) {
                                try {
                                    com.facebook.imagepipeline.image.EncodedImage encodedImage2 = new com.facebook.imagepipeline.image.EncodedImage(closeableReferenceCache);
                                    encodedImage2.copyMetaDataFrom(encodedImage);
                                    com.facebook.common.references.CloseableReference.closeSafely(closeableReferenceCache);
                                    try {
                                        getConsumer().onProgressUpdate(1.0f);
                                        getConsumer().onNewResult(encodedImage2, i);
                                        com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage2);
                                        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                                            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                                            return;
                                        }
                                        return;
                                    } catch (java.lang.Throwable th) {
                                        com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage2);
                                        throw th;
                                    }
                                } catch (java.lang.Throwable th2) {
                                    com.facebook.common.references.CloseableReference.closeSafely(closeableReferenceCache);
                                    throw th2;
                                }
                            }
                        } catch (java.lang.Throwable th3) {
                            com.facebook.common.references.CloseableReference.closeSafely(byteBufferRef);
                            throw th3;
                        }
                    }
                    getConsumer().onNewResult(encodedImage, i);
                    if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                        com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                        return;
                    }
                    return;
                }
                getConsumer().onNewResult(encodedImage, i);
                if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                }
            } catch (java.lang.Throwable th4) {
                if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                }
                throw th4;
            }
        }
    }
}
