package com.facebook.fresco.animation.factory;

/* JADX INFO: loaded from: classes.dex */
public class DefaultBitmapAnimationDrawableFactory implements com.facebook.imagepipeline.drawable.DrawableFactory, com.facebook.fresco.vito.options.ImageOptionsDrawableFactory {
    public static final int CACHING_STRATEGY_FRESCO_CACHE = 1;
    public static final int CACHING_STRATEGY_FRESCO_CACHE_NO_REUSING = 2;
    public static final int CACHING_STRATEGY_KEEP_LAST_CACHE = 3;
    public static final int CACHING_STRATEGY_NO_CACHE = 0;
    private final com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    private final com.facebook.common.internal.Supplier<java.lang.Integer> mAnimationFpsLimit;
    private final com.facebook.imagepipeline.cache.CountingMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> mBackingCache;
    private final com.facebook.common.internal.Supplier<java.lang.Integer> mBufferLengthMilliseconds;
    private final com.facebook.common.internal.Supplier<java.lang.Integer> mCachingStrategySupplier;
    private final com.facebook.common.internal.Supplier<java.lang.Boolean> mDownscaleFrameToDrawableDimensions;
    private final java.util.concurrent.ExecutorService mExecutorServiceForFramePreparing;
    private final com.facebook.common.time.MonotonicClock mMonotonicClock;
    private final com.facebook.common.internal.Supplier<java.lang.Integer> mNumberOfFramesToPrepareSupplier;
    private final com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory mPlatformBitmapFactory;
    private final java.util.concurrent.ScheduledExecutorService mScheduledExecutorServiceForUiThread;
    private final com.facebook.common.internal.Supplier<java.lang.Boolean> mUseDeepEqualsForCacheKey;
    private final com.facebook.common.internal.Supplier<java.lang.Boolean> mUseNewBitmapRender;
    private final com.facebook.common.internal.Supplier<java.lang.Boolean> useRendererAnimatedDrawable = com.facebook.common.internal.Suppliers.BOOLEAN_FALSE;

    public DefaultBitmapAnimationDrawableFactory(com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider animatedDrawableBackendProvider, java.util.concurrent.ScheduledExecutorService scheduledExecutorService, java.util.concurrent.ExecutorService executorService, com.facebook.common.time.MonotonicClock monotonicClock, com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory, com.facebook.imagepipeline.cache.CountingMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> countingMemoryCache, com.facebook.common.internal.Supplier<java.lang.Integer> supplier, com.facebook.common.internal.Supplier<java.lang.Integer> supplier2, com.facebook.common.internal.Supplier<java.lang.Boolean> supplier3, com.facebook.common.internal.Supplier<java.lang.Boolean> supplier4, com.facebook.common.internal.Supplier<java.lang.Boolean> supplier5, com.facebook.common.internal.Supplier<java.lang.Integer> supplier6, com.facebook.common.internal.Supplier<java.lang.Integer> supplier7) {
        this.mAnimatedDrawableBackendProvider = animatedDrawableBackendProvider;
        this.mScheduledExecutorServiceForUiThread = scheduledExecutorService;
        this.mExecutorServiceForFramePreparing = executorService;
        this.mMonotonicClock = monotonicClock;
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBackingCache = countingMemoryCache;
        this.mCachingStrategySupplier = supplier;
        this.mNumberOfFramesToPrepareSupplier = supplier2;
        this.mUseDeepEqualsForCacheKey = supplier3;
        this.mUseNewBitmapRender = supplier4;
        this.mAnimationFpsLimit = supplier6;
        this.mDownscaleFrameToDrawableDimensions = supplier5;
        this.mBufferLengthMilliseconds = supplier7;
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public boolean supportsImageType(com.facebook.imagepipeline.image.CloseableImage closeableImage) {
        return closeableImage instanceof com.facebook.imagepipeline.image.CloseableAnimatedImage;
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public android.graphics.drawable.Drawable createDrawable(com.facebook.imagepipeline.image.CloseableImage closeableImage) {
        com.facebook.imagepipeline.image.CloseableAnimatedImage closeableAnimatedImage = (com.facebook.imagepipeline.image.CloseableAnimatedImage) closeableImage;
        com.facebook.imagepipeline.animated.base.AnimatedImage image = closeableAnimatedImage.getImage();
        com.facebook.fresco.animation.backend.AnimationBackend animationBackendCreateAnimationBackend = createAnimationBackend((com.facebook.imagepipeline.animated.base.AnimatedImageResult) com.facebook.common.internal.Preconditions.checkNotNull(closeableAnimatedImage.getImageResult()), image != null ? image.getAnimatedBitmapConfig() : null, null);
        if (this.useRendererAnimatedDrawable.get().booleanValue()) {
            return new com.facebook.fresco.animation.drawable.KAnimatedDrawable2(animationBackendCreateAnimationBackend);
        }
        return new com.facebook.fresco.animation.drawable.AnimatedDrawable2(animationBackendCreateAnimationBackend);
    }

    @Override // com.facebook.fresco.vito.options.ImageOptionsDrawableFactory
    public android.graphics.drawable.Drawable createDrawable(android.content.res.Resources resources, com.facebook.imagepipeline.image.CloseableImage closeableImage, com.facebook.fresco.vito.options.ImageOptions imageOptions) {
        com.facebook.imagepipeline.image.CloseableAnimatedImage closeableAnimatedImage = (com.facebook.imagepipeline.image.CloseableAnimatedImage) closeableImage;
        com.facebook.imagepipeline.animated.base.AnimatedImage image = closeableAnimatedImage.getImage();
        try {
            com.facebook.fresco.animation.backend.AnimationBackend animationBackendCreateAnimationBackend = createAnimationBackend((com.facebook.imagepipeline.animated.base.AnimatedImageResult) com.facebook.common.internal.Preconditions.checkNotNull(closeableAnimatedImage.getImageResult()), image != null ? image.getAnimatedBitmapConfig() : null, imageOptions);
            if (this.useRendererAnimatedDrawable.get().booleanValue()) {
                return new com.facebook.fresco.animation.drawable.KAnimatedDrawable2(animationBackendCreateAnimationBackend);
            }
            return new com.facebook.fresco.animation.drawable.AnimatedDrawable2(animationBackendCreateAnimationBackend);
        } catch (java.lang.NullPointerException e) {
            java.lang.Object extra = closeableImage.getExtra("uri_source");
            if (extra != null) {
                throw new java.lang.NullPointerException(e.getMessage() + " uri=" + extra.toString());
            }
            throw e;
        }
    }

    private com.facebook.fresco.animation.backend.AnimationBackend createAnimationBackend(com.facebook.imagepipeline.animated.base.AnimatedImageResult animatedImageResult, @javax.annotation.Nullable android.graphics.Bitmap.Config config, @javax.annotation.Nullable com.facebook.fresco.vito.options.ImageOptions imageOptions) {
        com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy frameLoaderStrategy;
        com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer bitmapFramePreparerCreateBitmapFramePreparer;
        com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend animatedDrawableBackendCreateAnimatedDrawableBackend = createAnimatedDrawableBackend(animatedImageResult);
        com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendAnimationInformation animatedDrawableBackendAnimationInformation = new com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendAnimationInformation(animatedDrawableBackendCreateAnimatedDrawableBackend);
        com.facebook.fresco.animation.bitmap.BitmapFrameCache bitmapFrameCacheCreateBitmapFrameCache = createBitmapFrameCache(animatedImageResult);
        com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer animatedDrawableBackendFrameRenderer = new com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer(bitmapFrameCacheCreateBitmapFrameCache, animatedDrawableBackendCreateAnimatedDrawableBackend, this.mUseNewBitmapRender.get().booleanValue());
        int iIntValue = this.mNumberOfFramesToPrepareSupplier.get().intValue();
        if (iIntValue > 0) {
            frameLoaderStrategy = new com.facebook.fresco.animation.bitmap.preparation.FixedNumberBitmapFramePreparationStrategy(iIntValue);
            bitmapFramePreparerCreateBitmapFramePreparer = createBitmapFramePreparer(animatedDrawableBackendFrameRenderer, config);
        } else {
            frameLoaderStrategy = null;
            bitmapFramePreparerCreateBitmapFramePreparer = null;
        }
        com.facebook.fresco.vito.options.RoundingOptions roundingOptions = imageOptions != null ? imageOptions.getRoundingOptions() : null;
        if (this.mUseNewBitmapRender.get().booleanValue()) {
            frameLoaderStrategy = new com.facebook.fresco.animation.bitmap.preparation.FrameLoaderStrategy(animatedImageResult.getSource(), animatedDrawableBackendAnimationInformation, animatedDrawableBackendFrameRenderer, new com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoaderFactory(this.mPlatformBitmapFactory, this.mAnimationFpsLimit.get().intValue(), this.mBufferLengthMilliseconds.get().intValue()), this.mDownscaleFrameToDrawableDimensions.get().booleanValue());
        }
        return com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.createForBackend(new com.facebook.fresco.animation.bitmap.BitmapAnimationBackend(this.mPlatformBitmapFactory, bitmapFrameCacheCreateBitmapFrameCache, animatedDrawableBackendAnimationInformation, animatedDrawableBackendFrameRenderer, this.mUseNewBitmapRender.get().booleanValue(), frameLoaderStrategy, bitmapFramePreparerCreateBitmapFramePreparer, roundingOptions), this.mMonotonicClock, this.mScheduledExecutorServiceForUiThread);
    }

    private com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer createBitmapFramePreparer(com.facebook.fresco.animation.bitmap.BitmapFrameRenderer bitmapFrameRenderer, @javax.annotation.Nullable android.graphics.Bitmap.Config config) {
        com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory = this.mPlatformBitmapFactory;
        if (config == null) {
            config = android.graphics.Bitmap.Config.ARGB_8888;
        }
        return new com.facebook.fresco.animation.bitmap.preparation.DefaultBitmapFramePreparer(platformBitmapFactory, bitmapFrameRenderer, config, this.mExecutorServiceForFramePreparing);
    }

    private com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend createAnimatedDrawableBackend(com.facebook.imagepipeline.animated.base.AnimatedImageResult animatedImageResult) {
        com.facebook.imagepipeline.animated.base.AnimatedImage image = animatedImageResult.getImage();
        return this.mAnimatedDrawableBackendProvider.get(animatedImageResult, new android.graphics.Rect(0, 0, image.getWidth(), image.getHeight()));
    }

    private com.facebook.fresco.animation.bitmap.BitmapFrameCache createBitmapFrameCache(com.facebook.imagepipeline.animated.base.AnimatedImageResult animatedImageResult) {
        int iIntValue = this.mCachingStrategySupplier.get().intValue();
        if (iIntValue == 1) {
            return new com.facebook.fresco.animation.bitmap.cache.FrescoFrameCache(createAnimatedFrameCache(animatedImageResult), true);
        }
        if (iIntValue == 2) {
            return new com.facebook.fresco.animation.bitmap.cache.FrescoFrameCache(createAnimatedFrameCache(animatedImageResult), false);
        }
        if (iIntValue == 3) {
            return new com.facebook.fresco.animation.bitmap.cache.KeepLastFrameCache();
        }
        return new com.facebook.fresco.animation.bitmap.cache.NoOpCache();
    }

    private com.facebook.imagepipeline.animated.impl.AnimatedFrameCache createAnimatedFrameCache(com.facebook.imagepipeline.animated.base.AnimatedImageResult animatedImageResult) {
        return new com.facebook.imagepipeline.animated.impl.AnimatedFrameCache(new com.facebook.fresco.animation.bitmap.cache.AnimationFrameCacheKey(animatedImageResult.hashCode(), this.mUseDeepEqualsForCacheKey.get().booleanValue()), this.mBackingCache);
    }
}
