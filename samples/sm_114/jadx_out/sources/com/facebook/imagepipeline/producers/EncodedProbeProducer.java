package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class EncodedProbeProducer implements com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> {
    public static final java.lang.String PRODUCER_NAME = "EncodedProbeProducer";
    private final com.facebook.imagepipeline.cache.CacheKeyFactory mCacheKeyFactory;
    private final com.facebook.imagepipeline.cache.BoundedLinkedHashSet<com.facebook.cache.common.CacheKey> mDiskCacheHistory;
    private final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> mDiskCachesStoreSupplier;
    private final com.facebook.imagepipeline.cache.BoundedLinkedHashSet<com.facebook.cache.common.CacheKey> mEncodedMemoryCacheHistory;
    private final com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> mInputProducer;

    public EncodedProbeProducer(com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> supplier, com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory, com.facebook.imagepipeline.cache.BoundedLinkedHashSet boundedLinkedHashSet, com.facebook.imagepipeline.cache.BoundedLinkedHashSet boundedLinkedHashSet2, com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer) {
        this.mDiskCachesStoreSupplier = supplier;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mEncodedMemoryCacheHistory = boundedLinkedHashSet;
        this.mDiskCacheHistory = boundedLinkedHashSet2;
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        try {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("EncodedProbeProducer#produceResults");
            }
            com.facebook.imagepipeline.producers.ProducerListener2 producerListener = producerContext.getProducerListener();
            producerListener.onProducerStart(producerContext, getProducerName());
            com.facebook.imagepipeline.producers.EncodedProbeProducer.ProbeConsumer probeConsumer = new com.facebook.imagepipeline.producers.EncodedProbeProducer.ProbeConsumer(consumer, producerContext, this.mDiskCachesStoreSupplier, this.mCacheKeyFactory, this.mEncodedMemoryCacheHistory, this.mDiskCacheHistory);
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

    private static class ProbeConsumer extends com.facebook.imagepipeline.producers.DelegatingConsumer<com.facebook.imagepipeline.image.EncodedImage, com.facebook.imagepipeline.image.EncodedImage> {
        private final com.facebook.imagepipeline.cache.CacheKeyFactory mCacheKeyFactory;
        private final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> mDefaultBufferedDiskCache;
        private final com.facebook.imagepipeline.cache.BoundedLinkedHashSet<com.facebook.cache.common.CacheKey> mDiskCacheHistory;
        private final com.facebook.imagepipeline.cache.BoundedLinkedHashSet<com.facebook.cache.common.CacheKey> mEncodedMemoryCacheHistory;
        private final com.facebook.imagepipeline.producers.ProducerContext mProducerContext;

        public ProbeConsumer(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext, com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> supplier, com.facebook.imagepipeline.cache.CacheKeyFactory cacheKeyFactory, com.facebook.imagepipeline.cache.BoundedLinkedHashSet<com.facebook.cache.common.CacheKey> boundedLinkedHashSet, com.facebook.imagepipeline.cache.BoundedLinkedHashSet<com.facebook.cache.common.CacheKey> boundedLinkedHashSet2) {
            super(consumer);
            this.mProducerContext = producerContext;
            this.mDefaultBufferedDiskCache = supplier;
            this.mCacheKeyFactory = cacheKeyFactory;
            this.mEncodedMemoryCacheHistory = boundedLinkedHashSet;
            this.mDiskCacheHistory = boundedLinkedHashSet2;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage, int i) {
            boolean zIsTracing;
            com.facebook.imagepipeline.cache.BufferedDiskCache mainBufferedDiskCache;
            try {
                if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("EncodedProbeProducer#onNewResultImpl");
                }
                if (!isNotLast(i) && encodedImage != null && !statusHasAnyFlag(i, 10) && encodedImage.getImageFormat() != com.facebook.imageformat.ImageFormat.UNKNOWN) {
                    com.facebook.imagepipeline.request.ImageRequest imageRequest = this.mProducerContext.getImageRequest();
                    com.facebook.cache.common.CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, this.mProducerContext.getCallerContext());
                    this.mEncodedMemoryCacheHistory.add(encodedCacheKey);
                    if ("memory_encoded".equals(this.mProducerContext.getExtra("origin"))) {
                        if (!this.mDiskCacheHistory.contains(encodedCacheKey)) {
                            boolean z = imageRequest.getCacheChoice() == com.facebook.imagepipeline.request.ImageRequest.CacheChoice.SMALL;
                            com.facebook.imagepipeline.core.DiskCachesStore diskCachesStore = this.mDefaultBufferedDiskCache.get();
                            if (z) {
                                mainBufferedDiskCache = diskCachesStore.getSmallImageBufferedDiskCache();
                            } else {
                                mainBufferedDiskCache = diskCachesStore.getMainBufferedDiskCache();
                            }
                            mainBufferedDiskCache.addKeyForAsyncProbing(encodedCacheKey);
                            this.mDiskCacheHistory.add(encodedCacheKey);
                        }
                    } else if ("disk".equals(this.mProducerContext.getExtra("origin"))) {
                        this.mDiskCacheHistory.add(encodedCacheKey);
                    }
                    getConsumer().onNewResult(encodedImage, i);
                    if (zIsTracing) {
                        return;
                    } else {
                        return;
                    }
                }
                getConsumer().onNewResult(encodedImage, i);
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
