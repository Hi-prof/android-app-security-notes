package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class BitmapProbeProducer implements com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> {
    public static final java.lang.String PRODUCER_NAME = "BitmapProbeProducer";
    private final com.facebook.imagepipeline.cache.CacheKeyFactory mCacheKeyFactory;
    private final com.facebook.imagepipeline.cache.BoundedLinkedHashSet<com.facebook.cache.common.CacheKey> mDiskCacheHistory;
    private final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> mDiskCachesStoreSupplier;
    private final com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> mEncodedMemoryCache;
    private final com.facebook.imagepipeline.cache.BoundedLinkedHashSet<com.facebook.cache.common.CacheKey> mEncodedMemoryCacheHistory;
    private final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> mInputProducer;

    public BitmapProbeProducer(com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> memoryCache, com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> supplier, com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory, com.facebook.imagepipeline.cache.BoundedLinkedHashSet<com.facebook.cache.common.CacheKey> boundedLinkedHashSet, com.facebook.imagepipeline.cache.BoundedLinkedHashSet<com.facebook.cache.common.CacheKey> boundedLinkedHashSet2, com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> producer) {
        this.mEncodedMemoryCache = memoryCache;
        this.mDiskCachesStoreSupplier = supplier;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mEncodedMemoryCacheHistory = boundedLinkedHashSet;
        this.mDiskCacheHistory = boundedLinkedHashSet2;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        try {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("BitmapProbeProducer#produceResults");
            }
            com.facebook.imagepipeline.producers.ProducerListener2 producerListener = producerContext.getProducerListener();
            producerListener.onProducerStart(producerContext, getProducerName());
            com.facebook.imagepipeline.producers.BitmapProbeProducer.ProbeConsumer probeConsumer = new com.facebook.imagepipeline.producers.BitmapProbeProducer.ProbeConsumer(consumer, producerContext, this.mEncodedMemoryCache, this.mDiskCachesStoreSupplier, this.mCacheKeyFactory, this.mEncodedMemoryCacheHistory, this.mDiskCacheHistory);
            producerListener.onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, null);
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("mInputProducer.produceResult");
            }
            this.mInputProducer.produceResults(probeConsumer, producerContext);
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
        } finally {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
        }
    }

    private static class ProbeConsumer extends com.facebook.imagepipeline.producers.DelegatingConsumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>, com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> {
        private final com.facebook.imagepipeline.cache.CacheKeyFactory mCacheKeyFactory;
        private final com.facebook.imagepipeline.cache.BoundedLinkedHashSet<com.facebook.cache.common.CacheKey> mDiskCacheHistory;
        private final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> mDiskCachesStoreSupplier;
        private final com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> mEncodedMemoryCache;
        private final com.facebook.imagepipeline.cache.BoundedLinkedHashSet<com.facebook.cache.common.CacheKey> mEncodedMemoryCacheHistory;
        private final com.facebook.imagepipeline.producers.ProducerContext mProducerContext;

        public ProbeConsumer(com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext, com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> memoryCache, com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> supplier, com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory, com.facebook.imagepipeline.cache.BoundedLinkedHashSet<com.facebook.cache.common.CacheKey> boundedLinkedHashSet, com.facebook.imagepipeline.cache.BoundedLinkedHashSet<com.facebook.cache.common.CacheKey> boundedLinkedHashSet2) {
            super(consumer);
            this.mProducerContext = producerContext;
            this.mEncodedMemoryCache = memoryCache;
            this.mDiskCachesStoreSupplier = supplier;
            this.mCacheKeyFactory = cacheKeyFactory;
            this.mEncodedMemoryCacheHistory = boundedLinkedHashSet;
            this.mDiskCacheHistory = boundedLinkedHashSet2;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference, int i) {
            boolean zIsTracing;
            com.facebook.imagepipeline.cache.BufferedDiskCache mainBufferedDiskCache;
            try {
                if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("BitmapProbeProducer#onNewResultImpl");
                }
                if (!isNotLast(i) && closeableReference != null && !statusHasAnyFlag(i, 8)) {
                    com.facebook.imagepipeline.request.ImageRequest imageRequest = this.mProducerContext.getImageRequest();
                    com.facebook.cache.common.CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, this.mProducerContext.getCallerContext());
                    java.lang.String str = (java.lang.String) this.mProducerContext.getExtra("origin");
                    if (str != null && str.equals("memory_bitmap")) {
                        if (this.mProducerContext.getImagePipelineConfig().getExperiments().getIsEncodedMemoryCacheProbingEnabled() && !this.mEncodedMemoryCacheHistory.contains(encodedCacheKey)) {
                            this.mEncodedMemoryCache.probe(encodedCacheKey);
                            this.mEncodedMemoryCacheHistory.add(encodedCacheKey);
                        }
                        if (this.mProducerContext.getImagePipelineConfig().getExperiments().getIsDiskCacheProbingEnabled() && !this.mDiskCacheHistory.contains(encodedCacheKey)) {
                            boolean z = imageRequest.getCacheChoice() == com.facebook.imagepipeline.request.ImageRequest.CacheChoice.SMALL;
                            com.facebook.imagepipeline.core.DiskCachesStore diskCachesStore = this.mDiskCachesStoreSupplier.get();
                            if (z) {
                                mainBufferedDiskCache = diskCachesStore.getSmallImageBufferedDiskCache();
                            } else {
                                mainBufferedDiskCache = diskCachesStore.getMainBufferedDiskCache();
                            }
                            mainBufferedDiskCache.addKeyForAsyncProbing(encodedCacheKey);
                            this.mDiskCacheHistory.add(encodedCacheKey);
                        }
                    }
                    getConsumer().onNewResult(closeableReference, i);
                    if (zIsTracing) {
                        return;
                    } else {
                        return;
                    }
                }
                getConsumer().onNewResult(closeableReference, i);
            } finally {
                if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                }
            }
        }
    }

    protected java.lang.String getProducerName() {
        return PRODUCER_NAME;
    }
}
