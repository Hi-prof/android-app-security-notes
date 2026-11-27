package com.facebook.imagepipeline.core;

/* JADX INFO: loaded from: classes.dex */
public class ImagePipelineFactory {
    private static final java.lang.Class<?> TAG = com.facebook.imagepipeline.core.ImagePipelineFactory.class;
    private static boolean sForceSingleInstance;
    private static com.facebook.imagepipeline.core.ImagePipeline sImagePipeline;

    @javax.annotation.Nullable
    private static com.facebook.imagepipeline.core.ImagePipelineFactory sInstance;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.animated.factory.AnimatedFactory mAnimatedFactory;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.cache.CountingMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> mBitmapCountingMemoryCache;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.cache.InstrumentedMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> mBitmapMemoryCache;
    private final com.facebook.imagepipeline.core.CloseableReferenceFactory mCloseableReferenceFactory;
    private final com.facebook.imagepipeline.core.ImagePipelineConfigInterface mConfig;
    private final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> mDiskCachesStoreSupplier;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.cache.CountingMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> mEncodedCountingMemoryCache;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.cache.InstrumentedMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> mEncodedMemoryCache;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.decoder.ImageDecoder mImageDecoder;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.transcoder.ImageTranscoderFactory mImageTranscoderFactory;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory mPlatformBitmapFactory;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.platform.PlatformDecoder mPlatformDecoder;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.core.ProducerFactory mProducerFactory;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.core.ProducerSequenceFactory mProducerSequenceFactory;
    private final com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    public static com.facebook.imagepipeline.core.ImagePipelineFactory getInstance() {
        return (com.facebook.imagepipeline.core.ImagePipelineFactory) com.facebook.common.internal.Preconditions.checkNotNull(sInstance, "ImagePipelineFactory was not initialized!");
    }

    public static void setInstance(com.facebook.imagepipeline.core.ImagePipelineFactory imagePipelineFactory) {
        sInstance = imagePipelineFactory;
    }

    public static synchronized void initialize(android.content.Context context) {
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ImagePipelineFactory#initialize");
        }
        initialize(com.facebook.imagepipeline.core.ImagePipelineConfig.newBuilder(context).build());
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    public static synchronized void initialize(com.facebook.imagepipeline.core.ImagePipelineConfigInterface imagePipelineConfigInterface) {
        if (sInstance != null) {
            com.facebook.common.logging.FLog.w(TAG, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            if (sForceSingleInstance) {
                return;
            }
        }
        sInstance = new com.facebook.imagepipeline.core.ImagePipelineFactory(imagePipelineConfigInterface);
    }

    public static synchronized void forceSingleInstance() {
        sForceSingleInstance = true;
    }

    public static synchronized boolean hasBeenInitialized() {
        return sInstance != null;
    }

    public static synchronized void shutDown() {
        com.facebook.imagepipeline.core.ImagePipelineFactory imagePipelineFactory = sInstance;
        if (imagePipelineFactory != null) {
            imagePipelineFactory.getBitmapMemoryCache().removeAll(com.facebook.common.internal.AndroidPredicates.True());
            sInstance.getEncodedMemoryCache().removeAll(com.facebook.common.internal.AndroidPredicates.True());
            sInstance = null;
        }
    }

    public ImagePipelineFactory(com.facebook.imagepipeline.core.ImagePipelineConfigInterface imagePipelineConfigInterface) {
        com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue threadHandoffProducerQueueImpl;
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ImagePipelineConfig()");
        }
        com.facebook.imagepipeline.core.ImagePipelineConfigInterface imagePipelineConfigInterface2 = (com.facebook.imagepipeline.core.ImagePipelineConfigInterface) com.facebook.common.internal.Preconditions.checkNotNull(imagePipelineConfigInterface);
        this.mConfig = imagePipelineConfigInterface2;
        if (imagePipelineConfigInterface2.getExperiments().getIsExperimentalThreadHandoffQueueEnabled()) {
            threadHandoffProducerQueueImpl = new com.facebook.imagepipeline.producers.ExperimentalThreadHandoffProducerQueueImpl(imagePipelineConfigInterface.getExecutorSupplier().getLightWeightBackgroundExecutor());
        } else {
            threadHandoffProducerQueueImpl = new com.facebook.imagepipeline.producers.ThreadHandoffProducerQueueImpl(imagePipelineConfigInterface.getExecutorSupplier().getLightWeightBackgroundExecutor());
        }
        this.mThreadHandoffProducerQueue = threadHandoffProducerQueueImpl;
        this.mCloseableReferenceFactory = new com.facebook.imagepipeline.core.CloseableReferenceFactory(imagePipelineConfigInterface.getCloseableReferenceLeakTracker());
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
        this.mDiskCachesStoreSupplier = imagePipelineConfigInterface2.getDiskCachesStoreSupplier();
    }

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.animated.factory.AnimatedFactory getAnimatedFactory() {
        if (this.mAnimatedFactory == null) {
            this.mAnimatedFactory = com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider.getAnimatedFactory(getPlatformBitmapFactory(), this.mConfig.getExecutorSupplier(), getBitmapCountingMemoryCache(), this.mConfig.getExperiments().getDownscaleFrameToDrawableDimensions(), this.mConfig.getExperiments().getUseBalancedAnimationStrategy(), this.mConfig.getExperiments().getAnimationRenderFpsLimit(), this.mConfig.getExperiments().getAnimationStrategyBufferLengthMilliseconds(), this.mConfig.getExecutorServiceForAnimatedImages());
        }
        return this.mAnimatedFactory;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.drawable.DrawableFactory getAnimatedDrawableFactory(@javax.annotation.Nullable android.content.Context context) {
        com.facebook.imagepipeline.animated.factory.AnimatedFactory animatedFactory = getAnimatedFactory();
        if (animatedFactory == null) {
            return null;
        }
        return animatedFactory.getAnimatedDrawableFactory(context);
    }

    public com.facebook.imagepipeline.cache.CountingMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> getBitmapCountingMemoryCache() {
        if (this.mBitmapCountingMemoryCache == null) {
            this.mBitmapCountingMemoryCache = this.mConfig.getBitmapMemoryCacheFactory().create(this.mConfig.getBitmapMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapMemoryCacheTrimStrategy(), this.mConfig.getExperiments().getShouldStoreCacheEntrySize(), this.mConfig.getExperiments().getShouldIgnoreCacheSizeMismatch(), this.mConfig.getBitmapMemoryCacheEntryStateObserver());
        }
        return this.mBitmapCountingMemoryCache;
    }

    public com.facebook.imagepipeline.cache.InstrumentedMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> getBitmapMemoryCache() {
        if (this.mBitmapMemoryCache == null) {
            this.mBitmapMemoryCache = com.facebook.imagepipeline.cache.InstrumentedMemoryCacheBitmapMemoryCacheFactory.get(getBitmapCountingMemoryCache(), this.mConfig.getImageCacheStatsTracker());
        }
        return this.mBitmapMemoryCache;
    }

    public com.facebook.imagepipeline.cache.CountingMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> getEncodedCountingMemoryCache() {
        if (this.mEncodedCountingMemoryCache == null) {
            this.mEncodedCountingMemoryCache = com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory.get(this.mConfig.getEncodedMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getEncodedMemoryCacheTrimStrategy());
        }
        return this.mEncodedCountingMemoryCache;
    }

    public com.facebook.imagepipeline.cache.InstrumentedMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> getEncodedMemoryCache() {
        com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> encodedCountingMemoryCache;
        if (this.mEncodedMemoryCache == null) {
            if (this.mConfig.getEncodedMemoryCacheOverride() != null) {
                encodedCountingMemoryCache = this.mConfig.getEncodedMemoryCacheOverride();
            } else {
                encodedCountingMemoryCache = getEncodedCountingMemoryCache();
            }
            this.mEncodedMemoryCache = com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory.get(encodedCountingMemoryCache, this.mConfig.getImageCacheStatsTracker());
        }
        return this.mEncodedMemoryCache;
    }

    private com.facebook.imagepipeline.decoder.ImageDecoder getImageDecoder() {
        com.facebook.imagepipeline.decoder.ImageDecoder gifDecoder;
        com.facebook.imagepipeline.decoder.ImageDecoder webPDecoder;
        if (this.mImageDecoder == null) {
            if (this.mConfig.getImageDecoder() != null) {
                this.mImageDecoder = this.mConfig.getImageDecoder();
            } else {
                com.facebook.imagepipeline.animated.factory.AnimatedFactory animatedFactory = getAnimatedFactory();
                if (animatedFactory != null) {
                    gifDecoder = animatedFactory.getGifDecoder();
                    webPDecoder = animatedFactory.getWebPDecoder();
                } else {
                    gifDecoder = null;
                    webPDecoder = null;
                }
                if (this.mConfig.getImageDecoderConfig() == null) {
                    this.mImageDecoder = new com.facebook.imagepipeline.decoder.DefaultImageDecoder(gifDecoder, webPDecoder, getPlatformDecoder());
                } else {
                    this.mImageDecoder = new com.facebook.imagepipeline.decoder.DefaultImageDecoder(gifDecoder, webPDecoder, getPlatformDecoder(), this.mConfig.getImageDecoderConfig().getCustomImageDecoders());
                    com.facebook.imageformat.ImageFormatChecker.getInstance().setCustomImageFormatCheckers(this.mConfig.getImageDecoderConfig().getCustomImageFormats());
                }
            }
        }
        return this.mImageDecoder;
    }

    public com.facebook.common.internal.Supplier<com.facebook.imagepipeline.core.DiskCachesStore> getDiskCachesStoreSupplier() {
        return this.mDiskCachesStoreSupplier;
    }

    public com.facebook.imagepipeline.core.ImagePipeline getImagePipeline() {
        if (sImagePipeline == null) {
            sImagePipeline = createImagePipeline();
        }
        return sImagePipeline;
    }

    private com.facebook.imagepipeline.core.ImagePipeline createImagePipeline() {
        return new com.facebook.imagepipeline.core.ImagePipeline(getProducerSequenceFactory(), this.mConfig.getRequestListeners(), this.mConfig.getRequestListener2s(), this.mConfig.isPrefetchEnabledSupplier(), getBitmapMemoryCache(), getEncodedMemoryCache(), this.mDiskCachesStoreSupplier, this.mConfig.getCacheKeyFactory(), this.mThreadHandoffProducerQueue, this.mConfig.getExperiments().getSuppressBitmapPrefetchingSupplier(), this.mConfig.getExperiments().isLazyDataSource(), this.mConfig.getCallerContextVerifier(), this.mConfig);
    }

    public com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory getPlatformBitmapFactory() {
        if (this.mPlatformBitmapFactory == null) {
            this.mPlatformBitmapFactory = com.facebook.imagepipeline.bitmaps.PlatformBitmapFactoryProvider.buildPlatformBitmapFactory(this.mConfig.getPoolFactory(), getPlatformDecoder(), getCloseableReferenceFactory());
        }
        return this.mPlatformBitmapFactory;
    }

    public com.facebook.imagepipeline.platform.PlatformDecoder getPlatformDecoder() {
        if (this.mPlatformDecoder == null) {
            this.mPlatformDecoder = com.facebook.imagepipeline.platform.PlatformDecoderFactory.buildPlatformDecoder(this.mConfig.getPoolFactory(), this.mConfig.getExperiments().getIsGingerbreadDecoderEnabled(), this.mConfig.getExperiments().getShouldUseDecodingBufferHelper(), this.mConfig.getExperiments().getPlatformDecoderOptions());
        }
        return this.mPlatformDecoder;
    }

    private com.facebook.imagepipeline.core.ProducerFactory getProducerFactory() {
        if (this.mProducerFactory == null) {
            this.mProducerFactory = this.mConfig.getExperiments().getProducerFactoryMethod().createProducerFactory(this.mConfig.getContext(), this.mConfig.getPoolFactory().getSmallByteArrayPool(), getImageDecoder(), this.mConfig.getProgressiveJpegConfig(), this.mConfig.getDownsampleMode(), this.mConfig.getIsResizeAndRotateEnabledForNetwork(), this.mConfig.getExperiments().getIsDecodeCancellationEnabled(), this.mConfig.getExecutorSupplier(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(this.mConfig.getMemoryChunkType()), this.mConfig.getPoolFactory().getPooledByteStreams(), getBitmapMemoryCache(), getEncodedMemoryCache(), this.mDiskCachesStoreSupplier, this.mConfig.getCacheKeyFactory(), getPlatformBitmapFactory(), this.mConfig.getExperiments().getBitmapPrepareToDrawMinSizeBytes(), this.mConfig.getExperiments().getBitmapPrepareToDrawMaxSizeBytes(), this.mConfig.getExperiments().getBitmapPrepareToDrawForPrefetch(), this.mConfig.getExperiments().getMaxBitmapDimension(), getCloseableReferenceFactory(), this.mConfig.getExperiments().getKeepCancelledFetchAsLowPriority(), this.mConfig.getExperiments().getTrackedKeysSize());
        }
        return this.mProducerFactory;
    }

    private com.facebook.imagepipeline.core.ProducerSequenceFactory getProducerSequenceFactory() {
        boolean z = android.os.Build.VERSION.SDK_INT >= 24 && this.mConfig.getExperiments().getUseBitmapPrepareToDraw();
        if (this.mProducerSequenceFactory == null) {
            this.mProducerSequenceFactory = new com.facebook.imagepipeline.core.ProducerSequenceFactory(this.mConfig.getContext().getApplicationContext().getContentResolver(), getProducerFactory(), this.mConfig.getNetworkFetcher(), this.mConfig.getIsResizeAndRotateEnabledForNetwork(), this.mConfig.getExperiments().getIsWebpSupportEnabled(), this.mThreadHandoffProducerQueue, this.mConfig.getDownsampleMode(), z, this.mConfig.getExperiments().getIsPartialImageCachingEnabled(), this.mConfig.getIsDiskCacheEnabled(), getImageTranscoderFactory(), this.mConfig.getExperiments().getIsEncodedMemoryCacheProbingEnabled(), this.mConfig.getExperiments().getIsDiskCacheProbingEnabled(), this.mConfig.getExperiments().getAllowDelay(), this.mConfig.getCustomProducerSequenceFactories());
        }
        return this.mProducerSequenceFactory;
    }

    public com.facebook.imagepipeline.core.CloseableReferenceFactory getCloseableReferenceFactory() {
        return this.mCloseableReferenceFactory;
    }

    private com.facebook.imagepipeline.transcoder.ImageTranscoderFactory getImageTranscoderFactory() {
        if (this.mImageTranscoderFactory == null) {
            if (this.mConfig.getImageTranscoderFactory() == null && this.mConfig.getImageTranscoderType() == null && this.mConfig.getExperiments().getIsNativeCodeDisabled()) {
                this.mImageTranscoderFactory = new com.facebook.imagepipeline.transcoder.SimpleImageTranscoderFactory(this.mConfig.getExperiments().getMaxBitmapDimension());
            } else {
                this.mImageTranscoderFactory = new com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory(this.mConfig.getExperiments().getMaxBitmapDimension(), this.mConfig.getExperiments().getUseDownsamplingRatioForResizing(), this.mConfig.getImageTranscoderFactory(), this.mConfig.getImageTranscoderType(), this.mConfig.getExperiments().getIsEnsureTranscoderLibraryLoaded());
            }
        }
        return this.mImageTranscoderFactory;
    }

    @javax.annotation.Nullable
    public java.lang.String reportData() {
        com.facebook.common.internal.Objects.ToStringHelper stringHelper = com.facebook.common.internal.Objects.toStringHelper("ImagePipelineFactory");
        com.facebook.imagepipeline.cache.CountingMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> countingMemoryCache = this.mBitmapCountingMemoryCache;
        if (countingMemoryCache != null) {
            stringHelper.add("bitmapCountingMemoryCache", countingMemoryCache.getDebugData());
        }
        com.facebook.imagepipeline.cache.CountingMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.common.memory.PooledByteBuffer> countingMemoryCache2 = this.mEncodedCountingMemoryCache;
        if (countingMemoryCache2 != null) {
            stringHelper.add("encodedCountingMemoryCache", countingMemoryCache2.getDebugData());
        }
        return stringHelper.toString();
    }
}
