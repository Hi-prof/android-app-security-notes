package com.facebook.drawee.backends.pipeline;

/* JADX INFO: loaded from: classes.dex */
public class PipelineDraweeController extends com.facebook.drawee.controller.AbstractDraweeController<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>, com.facebook.imagepipeline.image.ImageInfo> {
    private static final java.lang.Class<?> TAG = com.facebook.drawee.backends.pipeline.PipelineDraweeController.class;
    private com.facebook.cache.common.CacheKey mCacheKey;

    @javax.annotation.Nullable
    private com.facebook.common.internal.ImmutableList<com.facebook.imagepipeline.drawable.DrawableFactory> mCustomDrawableFactories;
    private com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>> mDataSourceSupplier;
    private final com.facebook.imagepipeline.drawable.DrawableFactory mDefaultDrawableFactory;
    private boolean mDrawDebugOverlay;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.request.ImageRequest[] mFirstAvailableImageRequests;

    @javax.annotation.Nullable
    private final com.facebook.common.internal.ImmutableList<com.facebook.imagepipeline.drawable.DrawableFactory> mGlobalDrawableFactories;

    @javax.annotation.Nullable
    private com.facebook.drawee.backends.pipeline.info.ImageOriginListener mImageOriginListener;

    @javax.annotation.Nullable
    private com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor mImagePerfMonitor;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.request.ImageRequest mImageRequest;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.request.ImageRequest mLowResImageRequest;

    @javax.annotation.Nullable
    private final com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> mMemoryCache;

    @javax.annotation.Nullable
    private java.util.Set<com.facebook.imagepipeline.listener.RequestListener> mRequestListeners;
    private final android.content.res.Resources mResources;

    public PipelineDraweeController(android.content.res.Resources resources, com.facebook.drawee.components.DeferredReleaser deferredReleaser, com.facebook.imagepipeline.drawable.DrawableFactory drawableFactory, java.util.concurrent.Executor executor, @javax.annotation.Nullable com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> memoryCache, @javax.annotation.Nullable com.facebook.common.internal.ImmutableList<com.facebook.imagepipeline.drawable.DrawableFactory> immutableList) {
        super(deferredReleaser, executor, null, null);
        this.mResources = resources;
        this.mDefaultDrawableFactory = new com.facebook.drawee.backends.pipeline.DefaultDrawableFactory(resources, drawableFactory);
        this.mGlobalDrawableFactories = immutableList;
        this.mMemoryCache = memoryCache;
    }

    public void initialize(com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>> supplier, java.lang.String str, com.facebook.cache.common.CacheKey cacheKey, java.lang.Object obj, @javax.annotation.Nullable com.facebook.common.internal.ImmutableList<com.facebook.imagepipeline.drawable.DrawableFactory> immutableList) {
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("PipelineDraweeController#initialize");
        }
        super.initialize(str, obj);
        init(supplier);
        this.mCacheKey = cacheKey;
        setCustomDrawableFactories(immutableList);
        maybeUpdateDebugOverlay(null);
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    protected synchronized void initializePerformanceMonitoring(@javax.annotation.Nullable com.facebook.fresco.ui.common.ImagePerfDataListener imagePerfDataListener, com.facebook.drawee.controller.AbstractDraweeControllerBuilder<com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder, com.facebook.imagepipeline.request.ImageRequest, com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>, com.facebook.imagepipeline.image.ImageInfo> abstractDraweeControllerBuilder) {
        com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor imagePerfMonitor = this.mImagePerfMonitor;
        if (imagePerfMonitor != null) {
            imagePerfMonitor.reset();
        }
        if (imagePerfDataListener != null) {
            if (this.mImagePerfMonitor == null) {
                this.mImagePerfMonitor = new com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor(com.facebook.common.time.AwakeTimeSinceBootClock.get(), this);
            }
            this.mImagePerfMonitor.addImagePerfDataListener(imagePerfDataListener);
            this.mImagePerfMonitor.setEnabled(true);
        }
        this.mImageRequest = abstractDraweeControllerBuilder.getImageRequest();
        this.mFirstAvailableImageRequests = abstractDraweeControllerBuilder.getFirstAvailableImageRequests();
        this.mLowResImageRequest = abstractDraweeControllerBuilder.getLowResImageRequest();
    }

    public void setDrawDebugOverlay(boolean z) {
        this.mDrawDebugOverlay = z;
    }

    public void setCustomDrawableFactories(@javax.annotation.Nullable com.facebook.common.internal.ImmutableList<com.facebook.imagepipeline.drawable.DrawableFactory> immutableList) {
        this.mCustomDrawableFactories = immutableList;
    }

    public synchronized void addRequestListener(com.facebook.imagepipeline.listener.RequestListener requestListener) {
        if (this.mRequestListeners == null) {
            this.mRequestListeners = new java.util.HashSet();
        }
        this.mRequestListeners.add(requestListener);
    }

    public synchronized void removeRequestListener(com.facebook.imagepipeline.listener.RequestListener requestListener) {
        java.util.Set<com.facebook.imagepipeline.listener.RequestListener> set = this.mRequestListeners;
        if (set == null) {
            return;
        }
        set.remove(requestListener);
    }

    public synchronized void removeImageOriginListener(com.facebook.drawee.backends.pipeline.info.ImageOriginListener imageOriginListener) {
        com.facebook.drawee.backends.pipeline.info.ImageOriginListener imageOriginListener2 = this.mImageOriginListener;
        if (imageOriginListener2 instanceof com.facebook.drawee.backends.pipeline.info.ForwardingImageOriginListener) {
            ((com.facebook.drawee.backends.pipeline.info.ForwardingImageOriginListener) imageOriginListener2).removeImageOriginListener(imageOriginListener);
        } else {
            if (imageOriginListener2 == imageOriginListener) {
                this.mImageOriginListener = null;
            }
        }
    }

    private void init(com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>> supplier) {
        this.mDataSourceSupplier = supplier;
        maybeUpdateDebugOverlay(null);
    }

    protected android.content.res.Resources getResources() {
        return this.mResources;
    }

    protected com.facebook.cache.common.CacheKey getCacheKey() {
        return this.mCacheKey;
    }

    @javax.annotation.Nullable
    public synchronized com.facebook.imagepipeline.listener.RequestListener getRequestListener() {
        com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener imageOriginRequestListener = this.mImageOriginListener != null ? new com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener(getId(), this.mImageOriginListener) : null;
        if (this.mRequestListeners == null) {
            return imageOriginRequestListener;
        }
        com.facebook.imagepipeline.listener.ForwardingRequestListener forwardingRequestListener = new com.facebook.imagepipeline.listener.ForwardingRequestListener(this.mRequestListeners);
        if (imageOriginRequestListener != null) {
            forwardingRequestListener.addRequestListener(imageOriginRequestListener);
        }
        return forwardingRequestListener;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    protected com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getDataSource() {
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("PipelineDraweeController#getDataSource");
        }
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            com.facebook.common.logging.FLog.v(TAG, "controller %x: getDataSource", java.lang.Integer.valueOf(java.lang.System.identityHashCode(this)));
        }
        com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> dataSource = this.mDataSourceSupplier.get();
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
        return dataSource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public android.graphics.drawable.Drawable createDrawable(com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference) {
        try {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("PipelineDraweeController#createDrawable");
            }
            com.facebook.common.internal.Preconditions.checkState(com.facebook.common.references.CloseableReference.isValid(closeableReference));
            com.facebook.imagepipeline.image.CloseableImage closeableImage = closeableReference.get();
            maybeUpdateDebugOverlay(closeableImage);
            android.graphics.drawable.Drawable drawableMaybeCreateDrawableFromFactories = maybeCreateDrawableFromFactories(this.mCustomDrawableFactories, closeableImage);
            if (drawableMaybeCreateDrawableFromFactories != null) {
                if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                }
                return drawableMaybeCreateDrawableFromFactories;
            }
            android.graphics.drawable.Drawable drawableMaybeCreateDrawableFromFactories2 = maybeCreateDrawableFromFactories(this.mGlobalDrawableFactories, closeableImage);
            if (drawableMaybeCreateDrawableFromFactories2 != null) {
                if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                }
                return drawableMaybeCreateDrawableFromFactories2;
            }
            android.graphics.drawable.Drawable drawableCreateDrawable = this.mDefaultDrawableFactory.createDrawable(closeableImage);
            if (drawableCreateDrawable != null) {
                if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                }
                return drawableCreateDrawable;
            }
            throw new java.lang.UnsupportedOperationException("Unrecognized image class: " + closeableImage);
        } catch (java.lang.Throwable th) {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
            throw th;
        }
    }

    @javax.annotation.Nullable
    private android.graphics.drawable.Drawable maybeCreateDrawableFromFactories(@javax.annotation.Nullable com.facebook.common.internal.ImmutableList<com.facebook.imagepipeline.drawable.DrawableFactory> immutableList, com.facebook.imagepipeline.image.CloseableImage closeableImage) {
        android.graphics.drawable.Drawable drawableCreateDrawable;
        if (immutableList == null) {
            return null;
        }
        for (com.facebook.imagepipeline.drawable.DrawableFactory drawableFactory : immutableList) {
            if (drawableFactory.supportsImageType(closeableImage) && (drawableCreateDrawable = drawableFactory.createDrawable(closeableImage)) != null) {
                return drawableCreateDrawable;
            }
        }
        return null;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController, com.facebook.drawee.interfaces.DraweeController
    public void setHierarchy(@javax.annotation.Nullable com.facebook.drawee.interfaces.DraweeHierarchy draweeHierarchy) {
        super.setHierarchy(draweeHierarchy);
        maybeUpdateDebugOverlay(null);
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public boolean isSameImageRequest(@javax.annotation.Nullable com.facebook.drawee.interfaces.DraweeController draweeController) {
        com.facebook.cache.common.CacheKey cacheKey = this.mCacheKey;
        if (cacheKey == null || !(draweeController instanceof com.facebook.drawee.backends.pipeline.PipelineDraweeController)) {
            return false;
        }
        return com.facebook.common.internal.Objects.equal(cacheKey, ((com.facebook.drawee.backends.pipeline.PipelineDraweeController) draweeController).getCacheKey());
    }

    private void maybeUpdateDebugOverlay(@javax.annotation.Nullable com.facebook.imagepipeline.image.CloseableImage closeableImage) {
        if (this.mDrawDebugOverlay) {
            if (getControllerOverlay() == null) {
                com.facebook.drawee.debug.DebugControllerOverlayDrawable debugControllerOverlayDrawable = new com.facebook.drawee.debug.DebugControllerOverlayDrawable();
                addControllerListener(new com.facebook.drawee.debug.listener.ImageLoadingTimeControllerListener(debugControllerOverlayDrawable));
                setControllerOverlay(debugControllerOverlayDrawable);
            }
            if (getControllerOverlay() instanceof com.facebook.drawee.debug.DebugControllerOverlayDrawable) {
                updateDebugOverlay(closeableImage, (com.facebook.drawee.debug.DebugControllerOverlayDrawable) getControllerOverlay());
            }
        }
    }

    protected void updateDebugOverlay(@javax.annotation.Nullable com.facebook.imagepipeline.image.CloseableImage closeableImage, com.facebook.drawee.debug.DebugControllerOverlayDrawable debugControllerOverlayDrawable) {
        com.facebook.drawee.drawable.ScaleTypeDrawable activeScaleTypeDrawable;
        debugControllerOverlayDrawable.setControllerId(getId());
        com.facebook.drawee.interfaces.DraweeHierarchy hierarchy = getHierarchy();
        com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType = null;
        if (hierarchy != null && (activeScaleTypeDrawable = getActiveScaleTypeDrawable(hierarchy.getTopLevelDrawable())) != null) {
            scaleType = activeScaleTypeDrawable.getScaleType();
        }
        debugControllerOverlayDrawable.setScaleType(scaleType);
        java.lang.String callerContextString = getCallerContextString();
        if (callerContextString != null) {
            debugControllerOverlayDrawable.addAdditionalData("cc", callerContextString);
        }
        if (closeableImage != null) {
            debugControllerOverlayDrawable.setDimensions(closeableImage.getWidth(), closeableImage.getHeight());
            debugControllerOverlayDrawable.setImageSize(closeableImage.getSizeInBytes());
        } else {
            debugControllerOverlayDrawable.reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public com.facebook.imagepipeline.image.ImageInfo getImageInfo(com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference) {
        com.facebook.common.internal.Preconditions.checkState(com.facebook.common.references.CloseableReference.isValid(closeableReference));
        return closeableReference.get().getImageInfo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public int getImageHash(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference) {
        if (closeableReference != null) {
            return closeableReference.getValueHash();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public void releaseImage(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference) {
        com.facebook.common.references.CloseableReference.closeSafely(closeableReference);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    protected void releaseDrawable(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (drawable instanceof com.facebook.drawable.base.DrawableWithCaches) {
            ((com.facebook.drawable.base.DrawableWithCaches) drawable).dropCaches();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> getCachedImage() {
        com.facebook.cache.common.CacheKey cacheKey;
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("PipelineDraweeController#getCachedImage");
        }
        try {
            com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> memoryCache = this.mMemoryCache;
            if (memoryCache != null && (cacheKey = this.mCacheKey) != null) {
                com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference = memoryCache.get(cacheKey);
                if (closeableReference == null || closeableReference.get().getQualityInfo().isOfFullQuality()) {
                    return closeableReference;
                }
                closeableReference.close();
                return null;
            }
            return null;
        } finally {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public void onImageLoadedFromCacheImmediately(java.lang.String str, com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference) {
        super.onImageLoadedFromCacheImmediately(str, closeableReference);
        synchronized (this) {
            com.facebook.drawee.backends.pipeline.info.ImageOriginListener imageOriginListener = this.mImageOriginListener;
            if (imageOriginListener != null) {
                imageOriginListener.onImageLoaded(str, 6, true, "PipelineDraweeController");
            }
        }
    }

    protected com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>> getDataSourceSupplier() {
        return this.mDataSourceSupplier;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public java.lang.String toString() {
        return com.facebook.common.internal.Objects.toStringHelper(this).add("super", super.toString()).add("dataSourceSupplier", this.mDataSourceSupplier).toString();
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    @javax.annotation.Nullable
    public java.util.Map<java.lang.String, java.lang.Object> obtainExtrasFromImage(com.facebook.imagepipeline.image.ImageInfo imageInfo) {
        if (imageInfo == null) {
            return null;
        }
        return imageInfo.getExtras();
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    @javax.annotation.Nullable
    protected android.net.Uri getMainUri() {
        return com.facebook.fresco.ui.common.MultiUriHelper.getMainUri(this.mImageRequest, this.mLowResImageRequest, this.mFirstAvailableImageRequests, com.facebook.imagepipeline.request.ImageRequest.REQUEST_TO_URI_FN);
    }

    @javax.annotation.Nullable
    protected java.lang.String getCallerContextString() {
        java.lang.Object callerContext = getCallerContext();
        if (callerContext == null) {
            return null;
        }
        return callerContext.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @javax.annotation.Nullable
    public static com.facebook.drawee.drawable.ScaleTypeDrawable getActiveScaleTypeDrawable(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (drawable == 0) {
            return null;
        }
        if (drawable instanceof com.facebook.drawee.drawable.ScaleTypeDrawable) {
            return (com.facebook.drawee.drawable.ScaleTypeDrawable) drawable;
        }
        if (drawable instanceof com.facebook.drawee.drawable.DrawableParent) {
            return getActiveScaleTypeDrawable(((com.facebook.drawee.drawable.DrawableParent) drawable).getDrawable());
        }
        if (drawable instanceof com.facebook.drawee.drawable.ArrayDrawable) {
            com.facebook.drawee.drawable.ArrayDrawable arrayDrawable = (com.facebook.drawee.drawable.ArrayDrawable) drawable;
            int numberOfLayers = arrayDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                com.facebook.drawee.drawable.ScaleTypeDrawable activeScaleTypeDrawable = getActiveScaleTypeDrawable(arrayDrawable.getDrawable(i));
                if (activeScaleTypeDrawable != null) {
                    return activeScaleTypeDrawable;
                }
            }
        }
        return null;
    }
}
