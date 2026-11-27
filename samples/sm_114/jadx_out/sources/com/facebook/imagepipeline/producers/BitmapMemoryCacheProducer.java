package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class BitmapMemoryCacheProducer implements com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> {
    public static final java.lang.String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    private static final java.lang.String ORIGIN_SUBCATEGORY = "pipe_bg";
    public static final java.lang.String PRODUCER_NAME = "BitmapMemoryCacheProducer";
    private final com.facebook.imagepipeline.cache.CacheKeyFactory mCacheKeyFactory;
    private final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> mInputProducer;
    private final com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> mMemoryCache;

    public BitmapMemoryCacheProducer(com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> memoryCache, com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory, com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        boolean zIsTracing;
        try {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("BitmapMemoryCacheProducer#produceResults");
            }
            com.facebook.imagepipeline.producers.ProducerListener2 producerListener = producerContext.getProducerListener();
            producerListener.onProducerStart(producerContext, getProducerName());
            com.facebook.cache.common.CacheKey bitmapCacheKey = this.mCacheKeyFactory.getBitmapCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext());
            com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference = producerContext.getImageRequest().isCacheEnabled(1) ? this.mMemoryCache.get(bitmapCacheKey) : null;
            if (closeableReference != null) {
                maybeSetExtrasFromCloseableImage(closeableReference.get(), producerContext);
                boolean zIsOfFullQuality = closeableReference.get().getQualityInfo().isOfFullQuality();
                if (zIsOfFullQuality) {
                    producerListener.onProducerFinishWithSuccess(producerContext, getProducerName(), producerListener.requiresExtraMap(producerContext, getProducerName()) ? com.facebook.common.internal.ImmutableMap.of("cached_value_found", io.dcloud.common.constant.AbsoluteConst.TRUE) : null);
                    producerListener.onUltimateProducerReached(producerContext, getProducerName(), true);
                    producerContext.putOriginExtra("memory_bitmap", getOriginSubcategory());
                    consumer.onProgressUpdate(1.0f);
                }
                consumer.onNewResult(closeableReference, com.facebook.imagepipeline.producers.BaseConsumer.simpleStatusForIsLast(zIsOfFullQuality));
                closeableReference.close();
                if (zIsOfFullQuality) {
                    if (zIsTracing) {
                        return;
                    } else {
                        return;
                    }
                }
            }
            if (producerContext.getLowestPermittedRequestLevel().getValue() >= com.facebook.imagepipeline.request.ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
                producerListener.onProducerFinishWithSuccess(producerContext, getProducerName(), producerListener.requiresExtraMap(producerContext, getProducerName()) ? com.facebook.common.internal.ImmutableMap.of("cached_value_found", io.dcloud.common.constant.AbsoluteConst.FALSE) : null);
                producerListener.onUltimateProducerReached(producerContext, getProducerName(), false);
                producerContext.putOriginExtra("memory_bitmap", getOriginSubcategory());
                consumer.onNewResult(null, 1);
                if (zIsTracing) {
                    return;
                } else {
                    return;
                }
            }
            com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumerWrapConsumer = wrapConsumer(consumer, bitmapCacheKey, producerContext.getImageRequest().isCacheEnabled(2));
            producerListener.onProducerFinishWithSuccess(producerContext, getProducerName(), producerListener.requiresExtraMap(producerContext, getProducerName()) ? com.facebook.common.internal.ImmutableMap.of("cached_value_found", io.dcloud.common.constant.AbsoluteConst.FALSE) : null);
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("mInputProducer.produceResult");
            }
            this.mInputProducer.produceResults(consumerWrapConsumer, producerContext);
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
        } finally {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
        }
    }

    protected com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> wrapConsumer(com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumer, final com.facebook.cache.common.CacheKey cacheKey, final boolean z) {
        return new com.facebook.imagepipeline.producers.DelegatingConsumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>, com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>(consumer) { // from class: com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer.1
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onNewResultImpl(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference, int i) {
                com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference2;
                try {
                    if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("BitmapMemoryCacheProducer#onNewResultImpl");
                    }
                    boolean zIsLast = isLast(i);
                    if (closeableReference == null) {
                        if (zIsLast) {
                            getConsumer().onNewResult(null, i);
                        }
                        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                            return;
                        }
                        return;
                    }
                    if (!closeableReference.get().isStateful() && !statusHasFlag(i, 8)) {
                        if (!zIsLast && (closeableReference2 = com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer.this.mMemoryCache.get(cacheKey)) != null) {
                            try {
                                com.facebook.imagepipeline.image.QualityInfo qualityInfo = closeableReference.get().getQualityInfo();
                                com.facebook.imagepipeline.image.QualityInfo qualityInfo2 = closeableReference2.get().getQualityInfo();
                                if (qualityInfo2.isOfFullQuality() || qualityInfo2.getQuality() >= qualityInfo.getQuality()) {
                                    getConsumer().onNewResult(closeableReference2, i);
                                    com.facebook.common.references.CloseableReference.closeSafely(closeableReference2);
                                    if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                                        com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                                        return;
                                    }
                                    return;
                                }
                                com.facebook.common.references.CloseableReference.closeSafely(closeableReference2);
                            } catch (java.lang.Throwable th) {
                                com.facebook.common.references.CloseableReference.closeSafely(closeableReference2);
                                throw th;
                            }
                        }
                        com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReferenceCache = z ? com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer.this.mMemoryCache.cache(cacheKey, closeableReference) : null;
                        if (zIsLast) {
                            try {
                                getConsumer().onProgressUpdate(1.0f);
                            } catch (java.lang.Throwable th2) {
                                com.facebook.common.references.CloseableReference.closeSafely(closeableReferenceCache);
                                throw th2;
                            }
                        }
                        com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumer2 = getConsumer();
                        if (closeableReferenceCache != null) {
                            closeableReference = closeableReferenceCache;
                        }
                        consumer2.onNewResult(closeableReference, i);
                        com.facebook.common.references.CloseableReference.closeSafely(closeableReferenceCache);
                        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                            return;
                        }
                        return;
                    }
                    getConsumer().onNewResult(closeableReference, i);
                    if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                        com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                    }
                } catch (java.lang.Throwable th3) {
                    if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                        com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                    }
                    throw th3;
                }
            }
        };
    }

    protected java.lang.String getProducerName() {
        return PRODUCER_NAME;
    }

    private static void maybeSetExtrasFromCloseableImage(com.facebook.imagepipeline.image.HasImageMetadata hasImageMetadata, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        producerContext.putExtras(hasImageMetadata.getExtras());
    }

    protected java.lang.String getOriginSubcategory() {
        return ORIGIN_SUBCATEGORY;
    }
}
