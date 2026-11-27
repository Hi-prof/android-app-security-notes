package com.facebook.imagepipeline.animated.factory;

/* JADX INFO: compiled from: AnimatedFactoryProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0018\u0010\r\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/imagepipeline/animated/factory/AnimatedFactoryProvider;", "", "<init>", "()V", "implLoaded", "", "impl", "Lcom/facebook/imagepipeline/animated/factory/AnimatedFactory;", "getAnimatedFactory", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "executorSupplier", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "backingCache", "Lcom/facebook/imagepipeline/cache/CountingMemoryCache;", "Lcom/facebook/cache/common/CacheKey;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "downscaleFrameToDrawableDimensions", "useBalancedAnimationStrategy", "animationFpsLimit", "", "bufferLengthMilliseconds", "serialExecutorService", "Ljava/util/concurrent/ExecutorService;", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnimatedFactoryProvider {
    public static final com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider INSTANCE = new com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider();
    private static com.facebook.imagepipeline.animated.factory.AnimatedFactory impl;
    private static boolean implLoaded;

    private AnimatedFactoryProvider() {
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imagepipeline.animated.factory.AnimatedFactory getAnimatedFactory(com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory, com.facebook.imagepipeline.core.ExecutorSupplier executorSupplier, com.facebook.imagepipeline.cache.CountingMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> backingCache, boolean downscaleFrameToDrawableDimensions, boolean useBalancedAnimationStrategy, int animationFpsLimit, int bufferLengthMilliseconds, java.util.concurrent.ExecutorService serialExecutorService) {
        if (!implLoaded) {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl");
                java.lang.Class<?> cls2 = java.lang.Boolean.TYPE;
                java.lang.Class<?> cls3 = java.lang.Integer.TYPE;
                java.lang.Object objNewInstance = cls.getConstructor(com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory.class, com.facebook.imagepipeline.core.ExecutorSupplier.class, com.facebook.imagepipeline.cache.CountingMemoryCache.class, cls2, cls2, cls3, cls3, com.facebook.common.executors.SerialExecutorService.class).newInstance(platformBitmapFactory, executorSupplier, backingCache, java.lang.Boolean.valueOf(downscaleFrameToDrawableDimensions), java.lang.Boolean.valueOf(useBalancedAnimationStrategy), java.lang.Integer.valueOf(animationFpsLimit), java.lang.Integer.valueOf(bufferLengthMilliseconds), serialExecutorService);
                kotlin.jvm.internal.Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.facebook.imagepipeline.animated.factory.AnimatedFactory");
                impl = (com.facebook.imagepipeline.animated.factory.AnimatedFactory) objNewInstance;
            } catch (java.lang.Throwable unused) {
            }
            if (impl != null) {
                implLoaded = true;
            }
        }
        return impl;
    }
}
