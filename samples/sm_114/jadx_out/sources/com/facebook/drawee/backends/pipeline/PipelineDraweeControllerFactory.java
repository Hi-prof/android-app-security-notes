package com.facebook.drawee.backends.pipeline;

/* JADX INFO: loaded from: classes.dex */
public class PipelineDraweeControllerFactory {
    private com.facebook.imagepipeline.drawable.DrawableFactory mAnimatedDrawableFactory;

    @javax.annotation.Nullable
    private com.facebook.common.internal.Supplier<java.lang.Boolean> mDebugOverlayEnabledSupplier;
    private com.facebook.drawee.components.DeferredReleaser mDeferredReleaser;

    @javax.annotation.Nullable
    private com.facebook.common.internal.ImmutableList<com.facebook.imagepipeline.drawable.DrawableFactory> mDrawableFactories;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> mMemoryCache;
    private android.content.res.Resources mResources;
    private java.util.concurrent.Executor mUiThreadExecutor;

    public void init(android.content.res.Resources resources, com.facebook.drawee.components.DeferredReleaser deferredReleaser, com.facebook.imagepipeline.drawable.DrawableFactory drawableFactory, java.util.concurrent.Executor executor, com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> memoryCache, @javax.annotation.Nullable com.facebook.common.internal.ImmutableList<com.facebook.imagepipeline.drawable.DrawableFactory> immutableList, @javax.annotation.Nullable com.facebook.common.internal.Supplier<java.lang.Boolean> supplier) {
        this.mResources = resources;
        this.mDeferredReleaser = deferredReleaser;
        this.mAnimatedDrawableFactory = drawableFactory;
        this.mUiThreadExecutor = executor;
        this.mMemoryCache = memoryCache;
        this.mDrawableFactories = immutableList;
        this.mDebugOverlayEnabledSupplier = supplier;
    }

    public com.facebook.drawee.backends.pipeline.PipelineDraweeController newController() {
        com.facebook.drawee.backends.pipeline.PipelineDraweeController pipelineDraweeControllerInternalCreateController = internalCreateController(this.mResources, this.mDeferredReleaser, this.mAnimatedDrawableFactory, this.mUiThreadExecutor, this.mMemoryCache, this.mDrawableFactories);
        com.facebook.common.internal.Supplier<java.lang.Boolean> supplier = this.mDebugOverlayEnabledSupplier;
        if (supplier != null) {
            pipelineDraweeControllerInternalCreateController.setDrawDebugOverlay(supplier.get().booleanValue());
        }
        return pipelineDraweeControllerInternalCreateController;
    }

    protected com.facebook.drawee.backends.pipeline.PipelineDraweeController internalCreateController(android.content.res.Resources resources, com.facebook.drawee.components.DeferredReleaser deferredReleaser, com.facebook.imagepipeline.drawable.DrawableFactory drawableFactory, java.util.concurrent.Executor executor, @javax.annotation.Nullable com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> memoryCache, @javax.annotation.Nullable com.facebook.common.internal.ImmutableList<com.facebook.imagepipeline.drawable.DrawableFactory> immutableList) {
        return new com.facebook.drawee.backends.pipeline.PipelineDraweeController(resources, deferredReleaser, drawableFactory, executor, memoryCache, immutableList);
    }
}
