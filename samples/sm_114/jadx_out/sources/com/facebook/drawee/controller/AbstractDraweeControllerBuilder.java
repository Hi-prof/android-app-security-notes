package com.facebook.drawee.controller;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends com.facebook.drawee.controller.AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder {
    private boolean mAutoPlayAnimations;

    @javax.annotation.Nullable
    private final java.util.Set<com.facebook.drawee.controller.ControllerListener> mBoundControllerListeners;

    @javax.annotation.Nullable
    private final java.util.Set<com.facebook.fresco.ui.common.ControllerListener2> mBoundControllerListeners2;

    @javax.annotation.Nullable
    private java.lang.Object mCallerContext;

    @javax.annotation.Nullable
    private java.lang.String mContentDescription;
    private final android.content.Context mContext;

    @javax.annotation.Nullable
    private com.facebook.drawee.controller.ControllerListener<? super INFO> mControllerListener;

    @javax.annotation.Nullable
    private com.facebook.drawee.controller.ControllerViewportVisibilityListener mControllerViewportVisibilityListener;

    @javax.annotation.Nullable
    private com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<IMAGE>> mDataSourceSupplier;

    @javax.annotation.Nullable
    private REQUEST mImageRequest;

    @javax.annotation.Nullable
    private com.facebook.fresco.ui.common.LegacyOnFadeListener mLegacyOnFadeListener;
    private boolean mLogWithHighSamplingRate = false;

    @javax.annotation.Nullable
    private REQUEST mLowResImageRequest;

    @javax.annotation.Nullable
    private REQUEST[] mMultiImageRequests;

    @javax.annotation.Nullable
    private com.facebook.drawee.interfaces.DraweeController mOldController;
    private boolean mRetainImageOnFailure;
    private boolean mTapToRetryEnabled;
    private boolean mTryCacheOnlyFirst;
    private static final com.facebook.drawee.controller.ControllerListener<java.lang.Object> sAutoPlayAnimationsListener = new com.facebook.drawee.controller.BaseControllerListener<java.lang.Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.1
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(java.lang.String str, @javax.annotation.Nullable java.lang.Object obj, @javax.annotation.Nullable android.graphics.drawable.Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final java.lang.NullPointerException NO_REQUEST_EXCEPTION = new java.lang.NullPointerException("No image request was specified!");
    private static final java.util.concurrent.atomic.AtomicLong sIdCounter = new java.util.concurrent.atomic.AtomicLong();

    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected abstract com.facebook.datasource.DataSource<IMAGE> getDataSourceForRequest(com.facebook.drawee.interfaces.DraweeController draweeController, java.lang.String str, REQUEST request, java.lang.Object obj, com.facebook.drawee.controller.AbstractDraweeControllerBuilder.CacheLevel cacheLevel);

    protected final BUILDER getThis() {
        return this;
    }

    protected abstract com.facebook.drawee.controller.AbstractDraweeController obtainController();

    protected AbstractDraweeControllerBuilder(android.content.Context context, java.util.Set<com.facebook.drawee.controller.ControllerListener> set, java.util.Set<com.facebook.fresco.ui.common.ControllerListener2> set2) {
        this.mContext = context;
        this.mBoundControllerListeners = set;
        this.mBoundControllerListeners2 = set2;
        init();
    }

    private void init() {
        this.mCallerContext = null;
        this.mImageRequest = null;
        this.mLowResImageRequest = null;
        this.mMultiImageRequests = null;
        this.mTryCacheOnlyFirst = true;
        this.mControllerListener = null;
        this.mLegacyOnFadeListener = null;
        this.mControllerViewportVisibilityListener = null;
        this.mTapToRetryEnabled = false;
        this.mAutoPlayAnimations = false;
        this.mLogWithHighSamplingRate = false;
        this.mOldController = null;
        this.mContentDescription = null;
    }

    public BUILDER reset() {
        init();
        return (BUILDER) getThis();
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public BUILDER setCallerContext(java.lang.Object obj) {
        this.mCallerContext = obj;
        return (BUILDER) getThis();
    }

    @javax.annotation.Nullable
    public java.lang.Object getCallerContext() {
        return this.mCallerContext;
    }

    public BUILDER setImageRequest(@javax.annotation.Nullable REQUEST request) {
        this.mImageRequest = request;
        return (BUILDER) getThis();
    }

    @javax.annotation.Nullable
    public REQUEST getImageRequest() {
        return this.mImageRequest;
    }

    public BUILDER setLowResImageRequest(@javax.annotation.Nullable REQUEST request) {
        this.mLowResImageRequest = request;
        return (BUILDER) getThis();
    }

    @javax.annotation.Nullable
    public REQUEST getLowResImageRequest() {
        return this.mLowResImageRequest;
    }

    public BUILDER setFirstAvailableImageRequests(REQUEST[] requestArr) {
        return (BUILDER) setFirstAvailableImageRequests(requestArr, true);
    }

    public BUILDER setFirstAvailableImageRequests(REQUEST[] requestArr, boolean z) {
        com.facebook.common.internal.Preconditions.checkArgument(requestArr == null || requestArr.length > 0, "No requests specified!");
        this.mMultiImageRequests = requestArr;
        this.mTryCacheOnlyFirst = z;
        return (BUILDER) getThis();
    }

    @javax.annotation.Nullable
    public REQUEST[] getFirstAvailableImageRequests() {
        return this.mMultiImageRequests;
    }

    public BUILDER setDataSourceSupplier(@javax.annotation.Nullable com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<IMAGE>> supplier) {
        this.mDataSourceSupplier = supplier;
        return (BUILDER) getThis();
    }

    @javax.annotation.Nullable
    public com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<IMAGE>> getDataSourceSupplier() {
        return this.mDataSourceSupplier;
    }

    public BUILDER setTapToRetryEnabled(boolean z) {
        this.mTapToRetryEnabled = z;
        return (BUILDER) getThis();
    }

    public boolean getTapToRetryEnabled() {
        return this.mTapToRetryEnabled;
    }

    public BUILDER setRetainImageOnFailure(boolean z) {
        this.mRetainImageOnFailure = z;
        return (BUILDER) getThis();
    }

    public boolean getRetainImageOnFailure() {
        return this.mRetainImageOnFailure;
    }

    public BUILDER setAutoPlayAnimations(boolean z) {
        this.mAutoPlayAnimations = z;
        return (BUILDER) getThis();
    }

    public boolean getAutoPlayAnimations() {
        return this.mAutoPlayAnimations;
    }

    public boolean isLogWithHighSamplingRate() {
        return this.mLogWithHighSamplingRate;
    }

    public BUILDER setLogWithHighSamplingRate(boolean z) {
        this.mLogWithHighSamplingRate = z;
        return (BUILDER) getThis();
    }

    public BUILDER setControllerListener(@javax.annotation.Nullable com.facebook.drawee.controller.ControllerListener<? super INFO> controllerListener) {
        this.mControllerListener = controllerListener;
        return (BUILDER) getThis();
    }

    public BUILDER setLoggingListener(@javax.annotation.Nullable com.facebook.fresco.ui.common.LegacyOnFadeListener legacyOnFadeListener) {
        this.mLegacyOnFadeListener = legacyOnFadeListener;
        return (BUILDER) getThis();
    }

    @javax.annotation.Nullable
    public com.facebook.fresco.ui.common.LegacyOnFadeListener getLoggingListener() {
        return this.mLegacyOnFadeListener;
    }

    @javax.annotation.Nullable
    public com.facebook.drawee.controller.ControllerListener<? super INFO> getControllerListener() {
        return this.mControllerListener;
    }

    public BUILDER setControllerViewportVisibilityListener(@javax.annotation.Nullable com.facebook.drawee.controller.ControllerViewportVisibilityListener controllerViewportVisibilityListener) {
        this.mControllerViewportVisibilityListener = controllerViewportVisibilityListener;
        return (BUILDER) getThis();
    }

    @javax.annotation.Nullable
    public com.facebook.drawee.controller.ControllerViewportVisibilityListener getControllerViewportVisibilityListener() {
        return this.mControllerViewportVisibilityListener;
    }

    public BUILDER setContentDescription(java.lang.String str) {
        this.mContentDescription = str;
        return (BUILDER) getThis();
    }

    @javax.annotation.Nullable
    public java.lang.String getContentDescription() {
        return this.mContentDescription;
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public BUILDER setOldController(@javax.annotation.Nullable com.facebook.drawee.interfaces.DraweeController draweeController) {
        this.mOldController = draweeController;
        return (BUILDER) getThis();
    }

    @javax.annotation.Nullable
    public com.facebook.drawee.interfaces.DraweeController getOldController() {
        return this.mOldController;
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    public com.facebook.drawee.controller.AbstractDraweeController build() {
        REQUEST request;
        validate();
        if (this.mImageRequest == null && this.mMultiImageRequests == null && (request = this.mLowResImageRequest) != null) {
            this.mImageRequest = request;
            this.mLowResImageRequest = null;
        }
        return buildController();
    }

    protected void validate() {
        boolean z = false;
        com.facebook.common.internal.Preconditions.checkState(this.mMultiImageRequests == null || this.mImageRequest == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.mDataSourceSupplier == null || (this.mMultiImageRequests == null && this.mImageRequest == null && this.mLowResImageRequest == null)) {
            z = true;
        }
        com.facebook.common.internal.Preconditions.checkState(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    protected com.facebook.drawee.controller.AbstractDraweeController buildController() {
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("AbstractDraweeControllerBuilder#buildController");
        }
        com.facebook.drawee.controller.AbstractDraweeController abstractDraweeControllerObtainController = obtainController();
        abstractDraweeControllerObtainController.setLogWithHighSamplingRate(isLogWithHighSamplingRate());
        abstractDraweeControllerObtainController.setRetainImageOnFailure(getRetainImageOnFailure());
        abstractDraweeControllerObtainController.setContentDescription(getContentDescription());
        abstractDraweeControllerObtainController.setControllerViewportVisibilityListener(getControllerViewportVisibilityListener());
        maybeBuildAndSetRetryManager(abstractDraweeControllerObtainController);
        maybeAttachListeners(abstractDraweeControllerObtainController);
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
        return abstractDraweeControllerObtainController;
    }

    protected static java.lang.String generateUniqueControllerId() {
        return java.lang.String.valueOf(sIdCounter.getAndIncrement());
    }

    protected com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<IMAGE>> obtainDataSourceSupplier(com.facebook.drawee.interfaces.DraweeController draweeController, java.lang.String str) {
        com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<IMAGE>> firstAvailableDataSourceSupplier;
        com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<IMAGE>> supplier = this.mDataSourceSupplier;
        if (supplier != null) {
            return supplier;
        }
        REQUEST request = this.mImageRequest;
        if (request != null) {
            firstAvailableDataSourceSupplier = getDataSourceSupplierForRequest(draweeController, str, request);
        } else {
            REQUEST[] requestArr = this.mMultiImageRequests;
            firstAvailableDataSourceSupplier = requestArr != null ? getFirstAvailableDataSourceSupplier(draweeController, str, requestArr, this.mTryCacheOnlyFirst) : null;
        }
        if (firstAvailableDataSourceSupplier != null && this.mLowResImageRequest != null) {
            java.util.ArrayList arrayList = new java.util.ArrayList(2);
            arrayList.add(firstAvailableDataSourceSupplier);
            arrayList.add(getDataSourceSupplierForRequest(draweeController, str, this.mLowResImageRequest));
            firstAvailableDataSourceSupplier = com.facebook.datasource.IncreasingQualityDataSourceSupplier.create(arrayList, false);
        }
        return firstAvailableDataSourceSupplier == null ? com.facebook.datasource.DataSources.getFailedDataSourceSupplier(NO_REQUEST_EXCEPTION) : firstAvailableDataSourceSupplier;
    }

    protected com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<IMAGE>> getFirstAvailableDataSourceSupplier(com.facebook.drawee.interfaces.DraweeController draweeController, java.lang.String str, REQUEST[] requestArr, boolean z) {
        java.util.ArrayList arrayList = new java.util.ArrayList(requestArr.length * 2);
        if (z) {
            for (REQUEST request : requestArr) {
                arrayList.add(getDataSourceSupplierForRequest(draweeController, str, request, com.facebook.drawee.controller.AbstractDraweeControllerBuilder.CacheLevel.BITMAP_MEMORY_CACHE));
            }
        }
        for (REQUEST request2 : requestArr) {
            arrayList.add(getDataSourceSupplierForRequest(draweeController, str, request2));
        }
        return com.facebook.datasource.FirstAvailableDataSourceSupplier.create(arrayList);
    }

    protected com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<IMAGE>> getDataSourceSupplierForRequest(com.facebook.drawee.interfaces.DraweeController draweeController, java.lang.String str, REQUEST request) {
        return getDataSourceSupplierForRequest(draweeController, str, request, com.facebook.drawee.controller.AbstractDraweeControllerBuilder.CacheLevel.FULL_FETCH);
    }

    protected com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<IMAGE>> getDataSourceSupplierForRequest(final com.facebook.drawee.interfaces.DraweeController draweeController, final java.lang.String str, final REQUEST request, final com.facebook.drawee.controller.AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        final java.lang.Object callerContext = getCallerContext();
        return new com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<IMAGE>>() { // from class: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.common.internal.Supplier
            public com.facebook.datasource.DataSource<IMAGE> get() {
                return com.facebook.drawee.controller.AbstractDraweeControllerBuilder.this.getDataSourceForRequest(draweeController, str, request, callerContext, cacheLevel);
            }

            public java.lang.String toString() {
                return com.facebook.common.internal.Objects.toStringHelper(this).add(io.dcloud.feature.uniapp.adapter.AbsURIAdapter.REQUEST, request.toString()).toString();
            }
        };
    }

    protected void maybeAttachListeners(com.facebook.drawee.controller.AbstractDraweeController abstractDraweeController) {
        java.util.Set<com.facebook.drawee.controller.ControllerListener> set = this.mBoundControllerListeners;
        if (set != null) {
            java.util.Iterator<com.facebook.drawee.controller.ControllerListener> it = set.iterator();
            while (it.hasNext()) {
                abstractDraweeController.addControllerListener(it.next());
            }
        }
        java.util.Set<com.facebook.fresco.ui.common.ControllerListener2> set2 = this.mBoundControllerListeners2;
        if (set2 != null) {
            java.util.Iterator<com.facebook.fresco.ui.common.ControllerListener2> it2 = set2.iterator();
            while (it2.hasNext()) {
                abstractDraweeController.addControllerListener2(it2.next());
            }
        }
        com.facebook.drawee.controller.ControllerListener<? super INFO> controllerListener = this.mControllerListener;
        if (controllerListener != null) {
            abstractDraweeController.addControllerListener(controllerListener);
        }
        if (this.mAutoPlayAnimations) {
            abstractDraweeController.addControllerListener(sAutoPlayAnimationsListener);
        }
    }

    protected void maybeBuildAndSetRetryManager(com.facebook.drawee.controller.AbstractDraweeController abstractDraweeController) {
        if (this.mTapToRetryEnabled) {
            abstractDraweeController.getRetryManager().setTapToRetryEnabled(this.mTapToRetryEnabled);
            maybeBuildAndSetGestureDetector(abstractDraweeController);
        }
    }

    protected void maybeBuildAndSetGestureDetector(com.facebook.drawee.controller.AbstractDraweeController abstractDraweeController) {
        if (abstractDraweeController.getGestureDetector() == null) {
            abstractDraweeController.setGestureDetector(com.facebook.drawee.gestures.GestureDetector.newInstance(this.mContext));
        }
    }

    protected android.content.Context getContext() {
        return this.mContext;
    }
}
