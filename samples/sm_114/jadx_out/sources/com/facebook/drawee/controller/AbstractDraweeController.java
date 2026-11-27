package com.facebook.drawee.controller;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDraweeController<T, INFO> implements com.facebook.drawee.interfaces.DraweeController, com.facebook.drawee.components.DeferredReleaser.Releasable, com.facebook.drawee.gestures.GestureDetector.ClickListener {
    private static final java.util.Map<java.lang.String, java.lang.Object> COMPONENT_EXTRAS = com.facebook.common.internal.ImmutableMap.of("component_tag", "drawee");
    private static final java.util.Map<java.lang.String, java.lang.Object> SHORTCUT_EXTRAS = com.facebook.common.internal.ImmutableMap.of("origin", "memory_bitmap", "origin_sub", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_SHORTCUT);
    private static final java.lang.Class<?> TAG = com.facebook.drawee.controller.AbstractDraweeController.class;
    private java.lang.Object mCallerContext;

    @javax.annotation.Nullable
    private java.lang.String mContentDescription;

    @javax.annotation.Nullable
    protected com.facebook.drawee.controller.ControllerListener<INFO> mControllerListener;

    @javax.annotation.Nullable
    private android.graphics.drawable.Drawable mControllerOverlay;

    @javax.annotation.Nullable
    private com.facebook.drawee.controller.ControllerViewportVisibilityListener mControllerViewportVisibilityListener;

    @javax.annotation.Nullable
    private com.facebook.datasource.DataSource<T> mDataSource;
    private final com.facebook.drawee.components.DeferredReleaser mDeferredReleaser;

    @javax.annotation.Nullable
    protected android.graphics.drawable.Drawable mDrawable;

    @javax.annotation.Nullable
    private T mFetchedImage;

    @javax.annotation.Nullable
    private com.facebook.drawee.gestures.GestureDetector mGestureDetector;
    private boolean mHasFetchFailed;
    private java.lang.String mId;
    private boolean mIsAttached;
    private boolean mIsRequestSubmitted;
    private boolean mIsVisibleInViewportHint;

    @javax.annotation.Nullable
    protected com.facebook.fresco.ui.common.LegacyOnFadeListener mLegacyOnFadeListener;
    private boolean mRetainImageOnFailure;

    @javax.annotation.Nullable
    private com.facebook.drawee.components.RetryManager mRetryManager;

    @javax.annotation.Nullable
    private com.facebook.drawee.interfaces.SettableDraweeHierarchy mSettableDraweeHierarchy;
    private final java.util.concurrent.Executor mUiThreadImmediateExecutor;
    private final com.facebook.drawee.components.DraweeEventTracker mEventTracker = com.facebook.drawee.components.DraweeEventTracker.newInstance();
    protected com.facebook.fresco.ui.common.ForwardingControllerListener2<INFO> mControllerListener2 = new com.facebook.fresco.ui.common.ForwardingControllerListener2<>();
    private boolean mJustConstructed = true;
    private boolean mLogWithHighSamplingRate = false;

    protected abstract android.graphics.drawable.Drawable createDrawable(T t);

    @javax.annotation.Nullable
    protected T getCachedImage() {
        return null;
    }

    protected abstract com.facebook.datasource.DataSource<T> getDataSource();

    @javax.annotation.Nullable
    protected abstract INFO getImageInfo(T t);

    @javax.annotation.Nullable
    protected android.net.Uri getMainUri() {
        return null;
    }

    @javax.annotation.Nullable
    public abstract java.util.Map<java.lang.String, java.lang.Object> obtainExtrasFromImage(INFO info);

    protected void onImageLoadedFromCacheImmediately(java.lang.String str, T t) {
    }

    protected abstract void releaseDrawable(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable);

    protected abstract void releaseImage(@javax.annotation.Nullable T t);

    private static class InternalForwardingListener<INFO> extends com.facebook.drawee.controller.ForwardingControllerListener<INFO> {
        private InternalForwardingListener() {
        }

        public static <INFO> com.facebook.drawee.controller.AbstractDraweeController.InternalForwardingListener<INFO> createInternal(com.facebook.drawee.controller.ControllerListener<? super INFO> controllerListener, com.facebook.drawee.controller.ControllerListener<? super INFO> controllerListener2) {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("AbstractDraweeController#createInternal");
            }
            com.facebook.drawee.controller.AbstractDraweeController.InternalForwardingListener<INFO> internalForwardingListener = new com.facebook.drawee.controller.AbstractDraweeController.InternalForwardingListener<>();
            internalForwardingListener.addListener(controllerListener);
            internalForwardingListener.addListener(controllerListener2);
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
            return internalForwardingListener;
        }
    }

    public AbstractDraweeController(com.facebook.drawee.components.DeferredReleaser deferredReleaser, java.util.concurrent.Executor executor, java.lang.String str, java.lang.Object obj) {
        this.mDeferredReleaser = deferredReleaser;
        this.mUiThreadImmediateExecutor = executor;
        init(str, obj);
    }

    protected void initialize(java.lang.String str, java.lang.Object obj) {
        init(str, obj);
        this.mJustConstructed = false;
        this.mLogWithHighSamplingRate = false;
    }

    private synchronized void init(java.lang.String str, java.lang.Object obj) {
        com.facebook.drawee.components.DeferredReleaser deferredReleaser;
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("AbstractDraweeController#init");
        }
        this.mEventTracker.recordEvent(com.facebook.drawee.components.DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.mJustConstructed && (deferredReleaser = this.mDeferredReleaser) != null) {
            deferredReleaser.cancelDeferredRelease(this);
        }
        this.mIsAttached = false;
        this.mIsVisibleInViewportHint = false;
        releaseFetch();
        this.mRetainImageOnFailure = false;
        com.facebook.drawee.components.RetryManager retryManager = this.mRetryManager;
        if (retryManager != null) {
            retryManager.init();
        }
        com.facebook.drawee.gestures.GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
            gestureDetector.init();
            this.mGestureDetector.setClickListener(this);
        }
        com.facebook.drawee.controller.ControllerListener<INFO> controllerListener = this.mControllerListener;
        if (controllerListener instanceof com.facebook.drawee.controller.AbstractDraweeController.InternalForwardingListener) {
            ((com.facebook.drawee.controller.AbstractDraweeController.InternalForwardingListener) controllerListener).clearListeners();
        } else {
            this.mControllerListener = null;
        }
        this.mControllerViewportVisibilityListener = null;
        com.facebook.drawee.interfaces.SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.reset();
            this.mSettableDraweeHierarchy.setControllerOverlay(null);
            this.mSettableDraweeHierarchy = null;
        }
        this.mControllerOverlay = null;
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            com.facebook.common.logging.FLog.v(TAG, "controller %x %s -> %s: initialize", java.lang.Integer.valueOf(java.lang.System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.mCallerContext = obj;
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
        if (this.mLegacyOnFadeListener != null) {
            setUpLoggingListener();
        }
    }

    @Override // com.facebook.drawee.components.DeferredReleaser.Releasable
    public void release() {
        this.mEventTracker.recordEvent(com.facebook.drawee.components.DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        com.facebook.drawee.components.RetryManager retryManager = this.mRetryManager;
        if (retryManager != null) {
            retryManager.reset();
        }
        com.facebook.drawee.gestures.GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
            gestureDetector.reset();
        }
        com.facebook.drawee.interfaces.SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.reset();
        }
        releaseFetch();
    }

    private void releaseFetch() {
        java.util.Map<java.lang.String, java.lang.Object> extras;
        boolean z = this.mIsRequestSubmitted;
        this.mIsRequestSubmitted = false;
        this.mHasFetchFailed = false;
        com.facebook.datasource.DataSource<T> dataSource = this.mDataSource;
        java.util.Map<java.lang.String, java.lang.Object> map = null;
        if (dataSource != null) {
            extras = dataSource.getExtras();
            this.mDataSource.close();
            this.mDataSource = null;
        } else {
            extras = null;
        }
        android.graphics.drawable.Drawable drawable = this.mDrawable;
        if (drawable != null) {
            releaseDrawable(drawable);
        }
        if (this.mContentDescription != null) {
            this.mContentDescription = null;
        }
        this.mDrawable = null;
        T t = this.mFetchedImage;
        if (t != null) {
            java.util.Map<java.lang.String, java.lang.Object> mapObtainExtrasFromImage = obtainExtrasFromImage(getImageInfo(t));
            logMessageAndImage("release", this.mFetchedImage);
            releaseImage(this.mFetchedImage);
            this.mFetchedImage = null;
            map = mapObtainExtrasFromImage;
        }
        if (z) {
            reportRelease(extras, map);
        }
    }

    public java.lang.String getId() {
        return this.mId;
    }

    public java.lang.Object getCallerContext() {
        return this.mCallerContext;
    }

    protected com.facebook.drawee.components.RetryManager getRetryManager() {
        if (this.mRetryManager == null) {
            this.mRetryManager = new com.facebook.drawee.components.RetryManager();
        }
        return this.mRetryManager;
    }

    @javax.annotation.Nullable
    protected com.facebook.drawee.gestures.GestureDetector getGestureDetector() {
        return this.mGestureDetector;
    }

    protected void setGestureDetector(@javax.annotation.Nullable com.facebook.drawee.gestures.GestureDetector gestureDetector) {
        this.mGestureDetector = gestureDetector;
        if (gestureDetector != null) {
            gestureDetector.setClickListener(this);
        }
    }

    protected void setRetainImageOnFailure(boolean z) {
        this.mRetainImageOnFailure = z;
    }

    protected boolean isLogWithHighSamplingRate() {
        return this.mLogWithHighSamplingRate;
    }

    protected void setLogWithHighSamplingRate(boolean z) {
        this.mLogWithHighSamplingRate = z;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    @javax.annotation.Nullable
    public java.lang.String getContentDescription() {
        return this.mContentDescription;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void setContentDescription(@javax.annotation.Nullable java.lang.String str) {
        this.mContentDescription = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addControllerListener(com.facebook.drawee.controller.ControllerListener<? super INFO> controllerListener) {
        com.facebook.common.internal.Preconditions.checkNotNull(controllerListener);
        com.facebook.drawee.controller.ControllerListener<INFO> controllerListener2 = this.mControllerListener;
        if (controllerListener2 instanceof com.facebook.drawee.controller.AbstractDraweeController.InternalForwardingListener) {
            ((com.facebook.drawee.controller.AbstractDraweeController.InternalForwardingListener) controllerListener2).addListener(controllerListener);
        } else if (controllerListener2 != null) {
            this.mControllerListener = com.facebook.drawee.controller.AbstractDraweeController.InternalForwardingListener.createInternal(controllerListener2, controllerListener);
        } else {
            this.mControllerListener = controllerListener;
        }
    }

    public void addControllerListener2(com.facebook.fresco.ui.common.ControllerListener2<INFO> controllerListener2) {
        this.mControllerListener2.addListener(controllerListener2);
    }

    public void removeControllerListener2(com.facebook.fresco.ui.common.ControllerListener2<INFO> controllerListener2) {
        this.mControllerListener2.removeListener(controllerListener2);
    }

    public void setLoggingListener(com.facebook.fresco.ui.common.LegacyOnFadeListener legacyOnFadeListener) {
        this.mLegacyOnFadeListener = legacyOnFadeListener;
    }

    @javax.annotation.Nullable
    protected com.facebook.fresco.ui.common.LegacyOnFadeListener getLoggingListener() {
        return this.mLegacyOnFadeListener;
    }

    public void removeControllerListener(com.facebook.drawee.controller.ControllerListener<? super INFO> controllerListener) {
        com.facebook.common.internal.Preconditions.checkNotNull(controllerListener);
        com.facebook.drawee.controller.ControllerListener<INFO> controllerListener2 = this.mControllerListener;
        if (controllerListener2 instanceof com.facebook.drawee.controller.AbstractDraweeController.InternalForwardingListener) {
            ((com.facebook.drawee.controller.AbstractDraweeController.InternalForwardingListener) controllerListener2).removeListener(controllerListener);
        } else if (controllerListener2 == controllerListener) {
            this.mControllerListener = null;
        }
    }

    protected com.facebook.drawee.controller.ControllerListener<INFO> getControllerListener() {
        com.facebook.drawee.controller.ControllerListener<INFO> controllerListener = this.mControllerListener;
        return controllerListener == null ? com.facebook.drawee.controller.BaseControllerListener.getNoOpListener() : controllerListener;
    }

    protected com.facebook.fresco.ui.common.ControllerListener2<INFO> getControllerListener2() {
        return this.mControllerListener2;
    }

    public void setControllerViewportVisibilityListener(@javax.annotation.Nullable com.facebook.drawee.controller.ControllerViewportVisibilityListener controllerViewportVisibilityListener) {
        this.mControllerViewportVisibilityListener = controllerViewportVisibilityListener;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    @javax.annotation.Nullable
    public com.facebook.drawee.interfaces.DraweeHierarchy getHierarchy() {
        return this.mSettableDraweeHierarchy;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void setHierarchy(@javax.annotation.Nullable com.facebook.drawee.interfaces.DraweeHierarchy draweeHierarchy) {
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            com.facebook.common.logging.FLog.v(TAG, "controller %x %s: setHierarchy: %s", java.lang.Integer.valueOf(java.lang.System.identityHashCode(this)), this.mId, draweeHierarchy);
        }
        this.mEventTracker.recordEvent(draweeHierarchy != null ? com.facebook.drawee.components.DraweeEventTracker.Event.ON_SET_HIERARCHY : com.facebook.drawee.components.DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.mIsRequestSubmitted) {
            this.mDeferredReleaser.cancelDeferredRelease(this);
            release();
        }
        com.facebook.drawee.interfaces.SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.setControllerOverlay(null);
            this.mSettableDraweeHierarchy = null;
        }
        if (draweeHierarchy != null) {
            com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(draweeHierarchy instanceof com.facebook.drawee.interfaces.SettableDraweeHierarchy));
            com.facebook.drawee.interfaces.SettableDraweeHierarchy settableDraweeHierarchy2 = (com.facebook.drawee.interfaces.SettableDraweeHierarchy) draweeHierarchy;
            this.mSettableDraweeHierarchy = settableDraweeHierarchy2;
            settableDraweeHierarchy2.setControllerOverlay(this.mControllerOverlay);
        }
        if (this.mLegacyOnFadeListener != null) {
            setUpLoggingListener();
        }
    }

    private void setUpLoggingListener() {
        com.facebook.drawee.interfaces.SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy instanceof com.facebook.drawee.generic.GenericDraweeHierarchy) {
            ((com.facebook.drawee.generic.GenericDraweeHierarchy) settableDraweeHierarchy).setOnFadeListener(new com.facebook.fresco.ui.common.OnFadeListener() { // from class: com.facebook.drawee.controller.AbstractDraweeController.1
                @Override // com.facebook.fresco.ui.common.OnFadeListener
                public void onShownImmediately() {
                }

                @Override // com.facebook.fresco.ui.common.OnFadeListener
                public void onFadeFinished() {
                    if (com.facebook.drawee.controller.AbstractDraweeController.this.mLegacyOnFadeListener != null) {
                        com.facebook.drawee.controller.AbstractDraweeController.this.mLegacyOnFadeListener.onFadeFinished(com.facebook.drawee.controller.AbstractDraweeController.this.mId);
                    }
                }

                @Override // com.facebook.fresco.ui.common.OnFadeListener
                public void onFadeStarted() {
                    if (com.facebook.drawee.controller.AbstractDraweeController.this.mLegacyOnFadeListener != null) {
                        com.facebook.drawee.controller.AbstractDraweeController.this.mLegacyOnFadeListener.onFadeStarted(com.facebook.drawee.controller.AbstractDraweeController.this.mId);
                    }
                }
            });
        }
    }

    protected void setControllerOverlay(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.mControllerOverlay = drawable;
        com.facebook.drawee.interfaces.SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.setControllerOverlay(drawable);
        }
    }

    @javax.annotation.Nullable
    protected android.graphics.drawable.Drawable getControllerOverlay() {
        return this.mControllerOverlay;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void onAttach() {
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("AbstractDraweeController#onAttach");
        }
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            com.facebook.common.logging.FLog.v(TAG, "controller %x %s: onAttach: %s", java.lang.Integer.valueOf(java.lang.System.identityHashCode(this)), this.mId, this.mIsRequestSubmitted ? "request already submitted" : "request needs submit");
        }
        this.mEventTracker.recordEvent(com.facebook.drawee.components.DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        com.facebook.common.internal.Preconditions.checkNotNull(this.mSettableDraweeHierarchy);
        this.mDeferredReleaser.cancelDeferredRelease(this);
        this.mIsAttached = true;
        if (!this.mIsRequestSubmitted) {
            submitRequest();
        }
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void onDetach() {
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("AbstractDraweeController#onDetach");
        }
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            com.facebook.common.logging.FLog.v(TAG, "controller %x %s: onDetach", java.lang.Integer.valueOf(java.lang.System.identityHashCode(this)), this.mId);
        }
        this.mEventTracker.recordEvent(com.facebook.drawee.components.DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.mDeferredReleaser.scheduleDeferredRelease(this);
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void onViewportVisibilityHint(boolean z) {
        com.facebook.drawee.controller.ControllerViewportVisibilityListener controllerViewportVisibilityListener = this.mControllerViewportVisibilityListener;
        if (controllerViewportVisibilityListener != null) {
            if (z && !this.mIsVisibleInViewportHint) {
                controllerViewportVisibilityListener.onDraweeViewportEntry(this.mId);
            } else if (!z && this.mIsVisibleInViewportHint) {
                controllerViewportVisibilityListener.onDraweeViewportExit(this.mId);
            }
        }
        this.mIsVisibleInViewportHint = z;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            com.facebook.common.logging.FLog.v(TAG, "controller %x %s: onTouchEvent %s", java.lang.Integer.valueOf(java.lang.System.identityHashCode(this)), this.mId, motionEvent);
        }
        com.facebook.drawee.gestures.GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector == null) {
            return false;
        }
        if (!gestureDetector.isCapturingGesture() && !shouldHandleGesture()) {
            return false;
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    protected boolean shouldHandleGesture() {
        return shouldRetryOnTap();
    }

    private boolean shouldRetryOnTap() {
        com.facebook.drawee.components.RetryManager retryManager;
        return this.mHasFetchFailed && (retryManager = this.mRetryManager) != null && retryManager.shouldRetryOnTap();
    }

    @Override // com.facebook.drawee.gestures.GestureDetector.ClickListener
    public boolean onClick() {
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            com.facebook.common.logging.FLog.v(TAG, "controller %x %s: onClick", java.lang.Integer.valueOf(java.lang.System.identityHashCode(this)), this.mId);
        }
        if (!shouldRetryOnTap()) {
            return false;
        }
        this.mRetryManager.notifyTapToRetry();
        this.mSettableDraweeHierarchy.reset();
        submitRequest();
        return true;
    }

    protected void submitRequest() {
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("AbstractDraweeController#submitRequest");
        }
        T cachedImage = getCachedImage();
        if (cachedImage != null) {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("AbstractDraweeController#submitRequest->cache");
            }
            this.mDataSource = null;
            this.mIsRequestSubmitted = true;
            this.mHasFetchFailed = false;
            this.mEventTracker.recordEvent(com.facebook.drawee.components.DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            reportSubmit(this.mDataSource, getImageInfo(cachedImage));
            onImageLoadedFromCacheImmediately(this.mId, cachedImage);
            onNewResultInternal(this.mId, this.mDataSource, cachedImage, 1.0f, true, true, true);
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                return;
            }
            return;
        }
        this.mEventTracker.recordEvent(com.facebook.drawee.components.DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        this.mSettableDraweeHierarchy.setProgress(0.0f, true);
        this.mIsRequestSubmitted = true;
        this.mHasFetchFailed = false;
        com.facebook.datasource.DataSource<T> dataSource = getDataSource();
        this.mDataSource = dataSource;
        reportSubmit(dataSource, null);
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            com.facebook.common.logging.FLog.v(TAG, "controller %x %s: submitRequest: dataSource: %x", java.lang.Integer.valueOf(java.lang.System.identityHashCode(this)), this.mId, java.lang.Integer.valueOf(java.lang.System.identityHashCode(this.mDataSource)));
        }
        final java.lang.String str = this.mId;
        final boolean zHasResult = this.mDataSource.hasResult();
        this.mDataSource.subscribe(new com.facebook.datasource.BaseDataSubscriber<T>() { // from class: com.facebook.drawee.controller.AbstractDraweeController.2
            @Override // com.facebook.datasource.BaseDataSubscriber
            public void onNewResultImpl(com.facebook.datasource.DataSource<T> dataSource2) {
                boolean zIsFinished = dataSource2.isFinished();
                boolean zHasMultipleResults = dataSource2.hasMultipleResults();
                float progress = dataSource2.getProgress();
                T result = dataSource2.getResult();
                if (result != null) {
                    com.facebook.drawee.controller.AbstractDraweeController.this.onNewResultInternal(str, dataSource2, result, progress, zIsFinished, zHasResult, zHasMultipleResults);
                } else if (zIsFinished) {
                    com.facebook.drawee.controller.AbstractDraweeController.this.onFailureInternal(str, dataSource2, new java.lang.NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            public void onFailureImpl(com.facebook.datasource.DataSource<T> dataSource2) {
                com.facebook.drawee.controller.AbstractDraweeController.this.onFailureInternal(str, dataSource2, dataSource2.getFailureCause(), true);
            }

            @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(com.facebook.datasource.DataSource<T> dataSource2) {
                boolean zIsFinished = dataSource2.isFinished();
                com.facebook.drawee.controller.AbstractDraweeController.this.onProgressUpdateInternal(str, dataSource2, dataSource2.getProgress(), zIsFinished);
            }
        }, this.mUiThreadImmediateExecutor);
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNewResultInternal(java.lang.String str, com.facebook.datasource.DataSource<T> dataSource, @javax.annotation.Nullable T t, float f, boolean z, boolean z2, boolean z3) {
        try {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("AbstractDraweeController#onNewResultInternal");
            }
            if (!isExpectedDataSource(str, dataSource)) {
                logMessageAndImage("ignore_old_datasource @ onNewResult", t);
                releaseImage(t);
                dataSource.close();
                if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                    return;
                }
                return;
            }
            this.mEventTracker.recordEvent(z ? com.facebook.drawee.components.DraweeEventTracker.Event.ON_DATASOURCE_RESULT : com.facebook.drawee.components.DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
            try {
                android.graphics.drawable.Drawable drawableCreateDrawable = createDrawable(t);
                T t2 = this.mFetchedImage;
                android.graphics.drawable.Drawable drawable = this.mDrawable;
                this.mFetchedImage = t;
                this.mDrawable = drawableCreateDrawable;
                try {
                    if (z) {
                        logMessageAndImage("set_final_result @ onNewResult", t);
                        this.mDataSource = null;
                        getSettableDraweeHierarchy().setImage(drawableCreateDrawable, 1.0f, z2);
                        reportSuccess(str, t, dataSource);
                    } else if (z3) {
                        logMessageAndImage("set_temporary_result @ onNewResult", t);
                        getSettableDraweeHierarchy().setImage(drawableCreateDrawable, 1.0f, z2);
                        reportSuccess(str, t, dataSource);
                    } else {
                        logMessageAndImage("set_intermediate_result @ onNewResult", t);
                        getSettableDraweeHierarchy().setImage(drawableCreateDrawable, f, z2);
                        reportIntermediateSet(str, t);
                    }
                    if (drawable != null && drawable != drawableCreateDrawable) {
                        releaseDrawable(drawable);
                    }
                    if (t2 != null && t2 != t) {
                        logMessageAndImage("release_previous_result @ onNewResult", t2);
                        releaseImage(t2);
                    }
                    if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                        com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                    }
                } catch (java.lang.Throwable th) {
                    if (drawable != null && drawable != drawableCreateDrawable) {
                        releaseDrawable(drawable);
                    }
                    if (t2 != null && t2 != t) {
                        logMessageAndImage("release_previous_result @ onNewResult", t2);
                        releaseImage(t2);
                    }
                    throw th;
                }
            } catch (java.lang.Exception e) {
                logMessageAndImage("drawable_failed @ onNewResult", t);
                releaseImage(t);
                onFailureInternal(str, dataSource, e, z);
                if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                }
            }
        } catch (java.lang.Throwable th2) {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFailureInternal(java.lang.String str, com.facebook.datasource.DataSource<T> dataSource, java.lang.Throwable th, boolean z) {
        android.graphics.drawable.Drawable drawable;
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("AbstractDraweeController#onFailureInternal");
        }
        if (!isExpectedDataSource(str, dataSource)) {
            logMessageAndFailure("ignore_old_datasource @ onFailure", th);
            dataSource.close();
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                return;
            }
            return;
        }
        this.mEventTracker.recordEvent(z ? com.facebook.drawee.components.DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : com.facebook.drawee.components.DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            logMessageAndFailure("final_failed @ onFailure", th);
            this.mDataSource = null;
            this.mHasFetchFailed = true;
            com.facebook.drawee.interfaces.SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
            if (settableDraweeHierarchy != null) {
                if (this.mRetainImageOnFailure && (drawable = this.mDrawable) != null) {
                    settableDraweeHierarchy.setImage(drawable, 1.0f, true);
                } else if (shouldRetryOnTap()) {
                    settableDraweeHierarchy.setRetry(th);
                } else {
                    settableDraweeHierarchy.setFailure(th);
                }
            }
            reportFailure(th, dataSource);
        } else {
            logMessageAndFailure("intermediate_failed @ onFailure", th);
            reportIntermediateFailure(th);
        }
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProgressUpdateInternal(java.lang.String str, com.facebook.datasource.DataSource<T> dataSource, float f, boolean z) {
        if (!isExpectedDataSource(str, dataSource)) {
            logMessageAndFailure("ignore_old_datasource @ onProgress", null);
            dataSource.close();
        } else {
            if (z) {
                return;
            }
            this.mSettableDraweeHierarchy.setProgress(f, false);
        }
    }

    private boolean isExpectedDataSource(java.lang.String str, com.facebook.datasource.DataSource<T> dataSource) {
        if (dataSource == null && this.mDataSource == null) {
            return true;
        }
        return str.equals(this.mId) && dataSource == this.mDataSource && this.mIsRequestSubmitted;
    }

    private void logMessageAndImage(java.lang.String str, T t) {
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            com.facebook.common.logging.FLog.v(TAG, "controller %x %s: %s: image: %s %x", java.lang.Integer.valueOf(java.lang.System.identityHashCode(this)), this.mId, str, getImageClass(t), java.lang.Integer.valueOf(getImageHash(t)));
        }
    }

    private void logMessageAndFailure(java.lang.String str, java.lang.Throwable th) {
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            com.facebook.common.logging.FLog.v(TAG, "controller %x %s: %s: failure: %s", java.lang.Integer.valueOf(java.lang.System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    @javax.annotation.Nullable
    public android.graphics.drawable.Animatable getAnimatable() {
        java.lang.Object obj = this.mDrawable;
        if (obj instanceof android.graphics.drawable.Animatable) {
            return (android.graphics.drawable.Animatable) obj;
        }
        return null;
    }

    protected java.lang.String getImageClass(@javax.annotation.Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int getImageHash(@javax.annotation.Nullable T t) {
        return java.lang.System.identityHashCode(t);
    }

    public java.lang.String toString() {
        return com.facebook.common.internal.Objects.toStringHelper(this).add("isAttached", this.mIsAttached).add("isRequestSubmitted", this.mIsRequestSubmitted).add("hasFetchFailed", this.mHasFetchFailed).add("fetchedImage", getImageHash(this.mFetchedImage)).add("events", this.mEventTracker.toString()).toString();
    }

    protected void reportSubmit(com.facebook.datasource.DataSource<T> dataSource, @javax.annotation.Nullable INFO info) {
        getControllerListener().onSubmit(this.mId, this.mCallerContext);
        getControllerListener2().onSubmit(this.mId, this.mCallerContext, obtainExtras(dataSource, info, getMainUri()));
    }

    private void reportIntermediateSet(java.lang.String str, @javax.annotation.Nullable T t) {
        INFO imageInfo = getImageInfo(t);
        getControllerListener().onIntermediateImageSet(str, imageInfo);
        getControllerListener2().onIntermediateImageSet(str, imageInfo);
    }

    private void reportIntermediateFailure(java.lang.Throwable th) {
        getControllerListener().onIntermediateImageFailed(this.mId, th);
        getControllerListener2().onIntermediateImageFailed(this.mId);
    }

    private void reportSuccess(java.lang.String str, @javax.annotation.Nullable T t, @javax.annotation.Nullable com.facebook.datasource.DataSource<T> dataSource) {
        INFO imageInfo = getImageInfo(t);
        getControllerListener().onFinalImageSet(str, imageInfo, getAnimatable());
        getControllerListener2().onFinalImageSet(str, imageInfo, obtainExtras(dataSource, imageInfo, (android.net.Uri) null));
    }

    private void reportFailure(java.lang.Throwable th, @javax.annotation.Nullable com.facebook.datasource.DataSource<T> dataSource) {
        com.facebook.fresco.ui.common.ControllerListener2.Extras extrasObtainExtras = obtainExtras(dataSource, (java.lang.Object) null, (android.net.Uri) null);
        getControllerListener().onFailure(this.mId, th);
        getControllerListener2().onFailure(this.mId, th, extrasObtainExtras);
    }

    private void reportRelease(@javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.Object> map, @javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.Object> map2) {
        getControllerListener().onRelease(this.mId);
        getControllerListener2().onRelease(this.mId, obtainExtras(map, map2, (android.net.Uri) null));
    }

    private com.facebook.fresco.ui.common.ControllerListener2.Extras obtainExtras(@javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.Object> map, @javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.Object> map2, @javax.annotation.Nullable android.net.Uri uri) {
        java.lang.String str;
        android.graphics.PointF actualImageFocusPoint;
        com.facebook.drawee.interfaces.SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy instanceof com.facebook.drawee.generic.GenericDraweeHierarchy) {
            com.facebook.drawee.generic.GenericDraweeHierarchy genericDraweeHierarchy = (com.facebook.drawee.generic.GenericDraweeHierarchy) settableDraweeHierarchy;
            java.lang.String strValueOf = java.lang.String.valueOf(genericDraweeHierarchy.getActualImageScaleType());
            actualImageFocusPoint = genericDraweeHierarchy.getActualImageFocusPoint();
            str = strValueOf;
        } else {
            str = null;
            actualImageFocusPoint = null;
        }
        return com.facebook.fresco.middleware.MiddlewareUtils.obtainExtras(COMPONENT_EXTRAS, SHORTCUT_EXTRAS, map, null, getDimensions(), str, actualImageFocusPoint, map2, getCallerContext(), isLogWithHighSamplingRate(), uri);
    }

    private com.facebook.fresco.ui.common.ControllerListener2.Extras obtainExtras(@javax.annotation.Nullable com.facebook.datasource.DataSource<T> dataSource, @javax.annotation.Nullable INFO info, @javax.annotation.Nullable android.net.Uri uri) {
        return obtainExtras(dataSource == null ? null : dataSource.getExtras(), obtainExtrasFromImage(info), uri);
    }

    @javax.annotation.Nullable
    private android.graphics.Rect getDimensions() {
        com.facebook.drawee.interfaces.SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy == null) {
            return null;
        }
        return settableDraweeHierarchy.getBounds();
    }

    private com.facebook.drawee.interfaces.SettableDraweeHierarchy getSettableDraweeHierarchy() {
        com.facebook.drawee.interfaces.SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy != null) {
            return settableDraweeHierarchy;
        }
        throw new java.lang.IllegalStateException("mSettableDraweeHierarchy is null; Caller context: " + this.mCallerContext);
    }
}
