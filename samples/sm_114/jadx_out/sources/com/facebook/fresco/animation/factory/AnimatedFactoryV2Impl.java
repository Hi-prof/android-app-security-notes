package com.facebook.fresco.animation.factory;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedFactoryV2Impl implements com.facebook.imagepipeline.animated.factory.AnimatedFactory {
    private static final int NUMBER_OF_FRAMES_TO_PREPARE = 3;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.drawable.DrawableFactory mAnimatedDrawableFactory;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil mAnimatedDrawableUtil;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.animated.factory.AnimatedImageFactory mAnimatedImageFactory;
    private int mAnimationFpsLimit;
    private final com.facebook.imagepipeline.cache.CountingMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> mBackingCache;
    private int mBufferLengthMilliseconds;
    private final boolean mDownscaleFrameToDrawableDimensions;
    private final com.facebook.imagepipeline.core.ExecutorSupplier mExecutorSupplier;
    private final com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory mPlatformBitmapFactory;

    @javax.annotation.Nullable
    private com.facebook.common.executors.SerialExecutorService mSerialExecutorService;
    private final boolean mUseBufferLoaderStrategy;

    public AnimatedFactoryV2Impl(com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory, com.facebook.imagepipeline.core.ExecutorSupplier executorSupplier, com.facebook.imagepipeline.cache.CountingMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> countingMemoryCache, boolean z, boolean z2, int i, int i2, @javax.annotation.Nullable com.facebook.common.executors.SerialExecutorService serialExecutorService) {
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mExecutorSupplier = executorSupplier;
        this.mBackingCache = countingMemoryCache;
        this.mAnimationFpsLimit = i;
        this.mUseBufferLoaderStrategy = z2;
        this.mDownscaleFrameToDrawableDimensions = z;
        this.mSerialExecutorService = serialExecutorService;
        this.mBufferLengthMilliseconds = i2;
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedFactory
    @javax.annotation.Nullable
    public com.facebook.imagepipeline.drawable.DrawableFactory getAnimatedDrawableFactory(@javax.annotation.Nullable android.content.Context context) {
        if (this.mAnimatedDrawableFactory == null) {
            this.mAnimatedDrawableFactory = createDrawableFactory();
        }
        return this.mAnimatedDrawableFactory;
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedFactory
    public com.facebook.imagepipeline.decoder.ImageDecoder getGifDecoder() {
        return new com.facebook.imagepipeline.decoder.ImageDecoder() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.1
            @Override // com.facebook.imagepipeline.decoder.ImageDecoder
            @javax.annotation.Nullable
            public com.facebook.imagepipeline.image.CloseableImage decode(com.facebook.imagepipeline.image.EncodedImage encodedImage, int i, com.facebook.imagepipeline.image.QualityInfo qualityInfo, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
                return com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.this.getAnimatedImageFactory().decodeGif(encodedImage, imageDecodeOptions, imageDecodeOptions.animatedBitmapConfig);
            }
        };
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedFactory
    public com.facebook.imagepipeline.decoder.ImageDecoder getWebPDecoder() {
        return new com.facebook.imagepipeline.decoder.ImageDecoder() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl$$ExternalSyntheticLambda0
            @Override // com.facebook.imagepipeline.decoder.ImageDecoder
            public final com.facebook.imagepipeline.image.CloseableImage decode(com.facebook.imagepipeline.image.EncodedImage encodedImage, int i, com.facebook.imagepipeline.image.QualityInfo qualityInfo, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
                return this.f$0.m286xcd291ba2(encodedImage, i, qualityInfo, imageDecodeOptions);
            }
        };
    }

    /* JADX INFO: renamed from: lambda$getWebPDecoder$0$com-facebook-fresco-animation-factory-AnimatedFactoryV2Impl, reason: not valid java name */
    /* synthetic */ com.facebook.imagepipeline.image.CloseableImage m286xcd291ba2(com.facebook.imagepipeline.image.EncodedImage encodedImage, int i, com.facebook.imagepipeline.image.QualityInfo qualityInfo, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        return getAnimatedImageFactory().decodeWebP(encodedImage, imageDecodeOptions, imageDecodeOptions.animatedBitmapConfig);
    }

    private com.facebook.fresco.animation.factory.DefaultBitmapAnimationDrawableFactory createDrawableFactory() {
        com.facebook.common.internal.Supplier supplier = new com.facebook.common.internal.Supplier() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl$$ExternalSyntheticLambda1
            @Override // com.facebook.common.internal.Supplier
            public final java.lang.Object get() {
                return com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.lambda$createDrawableFactory$1();
            }
        };
        java.util.concurrent.ExecutorService defaultSerialExecutorService = this.mSerialExecutorService;
        if (defaultSerialExecutorService == null) {
            defaultSerialExecutorService = new com.facebook.common.executors.DefaultSerialExecutorService(this.mExecutorSupplier.getDecodeExecutor());
        }
        com.facebook.common.internal.Supplier supplier2 = new com.facebook.common.internal.Supplier() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl$$ExternalSyntheticLambda2
            @Override // com.facebook.common.internal.Supplier
            public final java.lang.Object get() {
                return com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.lambda$createDrawableFactory$2();
            }
        };
        com.facebook.common.internal.Supplier<java.lang.Boolean> supplier3 = com.facebook.common.internal.Suppliers.BOOLEAN_FALSE;
        return new com.facebook.fresco.animation.factory.DefaultBitmapAnimationDrawableFactory(getAnimatedDrawableBackendProvider(), com.facebook.common.executors.UiThreadImmediateExecutorService.getInstance(), defaultSerialExecutorService, com.facebook.common.time.RealtimeSinceBootClock.get(), this.mPlatformBitmapFactory, this.mBackingCache, supplier, supplier2, supplier3, com.facebook.common.internal.Suppliers.of(java.lang.Boolean.valueOf(this.mUseBufferLoaderStrategy)), com.facebook.common.internal.Suppliers.of(java.lang.Boolean.valueOf(this.mDownscaleFrameToDrawableDimensions)), com.facebook.common.internal.Suppliers.of(java.lang.Integer.valueOf(this.mAnimationFpsLimit)), com.facebook.common.internal.Suppliers.of(java.lang.Integer.valueOf(this.mBufferLengthMilliseconds)));
    }

    static /* synthetic */ java.lang.Integer lambda$createDrawableFactory$1() {
        return 2;
    }

    static /* synthetic */ java.lang.Integer lambda$createDrawableFactory$2() {
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil getAnimatedDrawableUtil() {
        if (this.mAnimatedDrawableUtil == null) {
            this.mAnimatedDrawableUtil = new com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil();
        }
        return this.mAnimatedDrawableUtil;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.animated.factory.AnimatedImageFactory getAnimatedImageFactory() {
        if (this.mAnimatedImageFactory == null) {
            this.mAnimatedImageFactory = buildAnimatedImageFactory();
        }
        return this.mAnimatedImageFactory;
    }

    private com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider getAnimatedDrawableBackendProvider() {
        if (this.mAnimatedDrawableBackendProvider == null) {
            this.mAnimatedDrawableBackendProvider = new com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.2
                @Override // com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider
                public com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend get(com.facebook.imagepipeline.animated.base.AnimatedImageResult animatedImageResult, @javax.annotation.Nullable android.graphics.Rect rect) {
                    return new com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl(com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.this.getAnimatedDrawableUtil(), animatedImageResult, rect, com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.this.mDownscaleFrameToDrawableDimensions);
                }
            };
        }
        return this.mAnimatedDrawableBackendProvider;
    }

    private com.facebook.imagepipeline.animated.factory.AnimatedImageFactory buildAnimatedImageFactory() {
        return new com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl(new com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider() { // from class: com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.3
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider
            public com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend get(com.facebook.imagepipeline.animated.base.AnimatedImageResult animatedImageResult, @javax.annotation.Nullable android.graphics.Rect rect) {
                return new com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl(com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.this.getAnimatedDrawableUtil(), animatedImageResult, rect, com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.this.mDownscaleFrameToDrawableDimensions);
            }
        }, this.mPlatformBitmapFactory, this.mUseBufferLoaderStrategy);
    }
}
