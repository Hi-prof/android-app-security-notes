package com.facebook.drawee.backends.pipeline.info;

/* JADX INFO: loaded from: classes.dex */
public class ImagePerfMonitor implements com.facebook.fresco.ui.common.ImagePerfNotifier {
    private boolean mEnabled;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.listener.ForwardingRequestListener mForwardingRequestListener;

    @javax.annotation.Nullable
    private java.util.List<com.facebook.fresco.ui.common.ImagePerfDataListener> mImagePerfDataListeners;

    @javax.annotation.Nullable
    private com.facebook.drawee.backends.pipeline.info.internal.ImagePerfRequestListener mImagePerfRequestListener;
    private final com.facebook.fresco.ui.common.ImagePerfState mImagePerfState = new com.facebook.fresco.ui.common.ImagePerfState(com.facebook.fresco.ui.common.ImageRenderingInfra.DRAWEE);

    @javax.annotation.Nullable
    private com.facebook.drawee.backends.pipeline.info.internal.ImagePerfStateManager mImagePerfStateManager;
    private final com.facebook.common.time.MonotonicClock mMonotonicClock;
    private final com.facebook.drawee.backends.pipeline.PipelineDraweeController mPipelineDraweeController;

    public ImagePerfMonitor(com.facebook.common.time.MonotonicClock monotonicClock, com.facebook.drawee.backends.pipeline.PipelineDraweeController pipelineDraweeController) {
        this.mMonotonicClock = monotonicClock;
        this.mPipelineDraweeController = pipelineDraweeController;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            setupListeners();
            com.facebook.drawee.backends.pipeline.info.internal.ImagePerfStateManager imagePerfStateManager = this.mImagePerfStateManager;
            if (imagePerfStateManager != null) {
                this.mPipelineDraweeController.addControllerListener2(imagePerfStateManager);
            }
            com.facebook.imagepipeline.listener.ForwardingRequestListener forwardingRequestListener = this.mForwardingRequestListener;
            if (forwardingRequestListener != null) {
                this.mPipelineDraweeController.addRequestListener(forwardingRequestListener);
                return;
            }
            return;
        }
        com.facebook.drawee.backends.pipeline.info.internal.ImagePerfStateManager imagePerfStateManager2 = this.mImagePerfStateManager;
        if (imagePerfStateManager2 != null) {
            this.mPipelineDraweeController.removeControllerListener2(imagePerfStateManager2);
        }
        com.facebook.imagepipeline.listener.ForwardingRequestListener forwardingRequestListener2 = this.mForwardingRequestListener;
        if (forwardingRequestListener2 != null) {
            this.mPipelineDraweeController.removeRequestListener(forwardingRequestListener2);
        }
    }

    public void addImagePerfDataListener(@javax.annotation.Nullable com.facebook.fresco.ui.common.ImagePerfDataListener imagePerfDataListener) {
        if (imagePerfDataListener == null) {
            return;
        }
        if (this.mImagePerfDataListeners == null) {
            this.mImagePerfDataListeners = new java.util.concurrent.CopyOnWriteArrayList();
        }
        this.mImagePerfDataListeners.add(imagePerfDataListener);
    }

    public void removeImagePerfDataListener(com.facebook.fresco.ui.common.ImagePerfDataListener imagePerfDataListener) {
        java.util.List<com.facebook.fresco.ui.common.ImagePerfDataListener> list = this.mImagePerfDataListeners;
        if (list == null) {
            return;
        }
        list.remove(imagePerfDataListener);
    }

    public void clearImagePerfDataListeners() {
        java.util.List<com.facebook.fresco.ui.common.ImagePerfDataListener> list = this.mImagePerfDataListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // com.facebook.fresco.ui.common.ImagePerfNotifier
    public void notifyStatusUpdated(com.facebook.fresco.ui.common.ImagePerfState imagePerfState, com.facebook.fresco.ui.common.ImageLoadStatus imageLoadStatus) {
        java.util.List<com.facebook.fresco.ui.common.ImagePerfDataListener> list;
        imagePerfState.setImageLoadStatus(imageLoadStatus);
        if (!this.mEnabled || (list = this.mImagePerfDataListeners) == null || list.isEmpty()) {
            return;
        }
        if (imageLoadStatus == com.facebook.fresco.ui.common.ImageLoadStatus.SUCCESS) {
            addViewportData();
        }
        com.facebook.fresco.ui.common.ImagePerfData imagePerfDataSnapshot = imagePerfState.snapshot();
        java.util.Iterator<com.facebook.fresco.ui.common.ImagePerfDataListener> it = this.mImagePerfDataListeners.iterator();
        while (it.hasNext()) {
            it.next().onImageLoadStatusUpdated(imagePerfDataSnapshot, imageLoadStatus);
        }
    }

    @Override // com.facebook.fresco.ui.common.ImagePerfNotifier
    public void notifyVisibilityUpdated(com.facebook.fresco.ui.common.ImagePerfState imagePerfState, com.facebook.fresco.ui.common.VisibilityState visibilityState) {
        java.util.List<com.facebook.fresco.ui.common.ImagePerfDataListener> list;
        if (!this.mEnabled || (list = this.mImagePerfDataListeners) == null || list.isEmpty()) {
            return;
        }
        com.facebook.fresco.ui.common.ImagePerfData imagePerfDataSnapshot = imagePerfState.snapshot();
        java.util.Iterator<com.facebook.fresco.ui.common.ImagePerfDataListener> it = this.mImagePerfDataListeners.iterator();
        while (it.hasNext()) {
            it.next().onImageVisibilityUpdated(imagePerfDataSnapshot, visibilityState);
        }
    }

    public void addViewportData() {
        com.facebook.drawee.interfaces.DraweeHierarchy hierarchy = this.mPipelineDraweeController.getHierarchy();
        if (hierarchy == null || hierarchy.getTopLevelDrawable() == null) {
            return;
        }
        android.graphics.Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
        this.mImagePerfState.setOnScreenWidth(bounds.width());
        this.mImagePerfState.setOnScreenHeight(bounds.height());
    }

    private void setupListeners() {
        if (this.mImagePerfStateManager == null) {
            this.mImagePerfStateManager = new com.facebook.drawee.backends.pipeline.info.internal.ImagePerfStateManager(this.mMonotonicClock, this.mImagePerfState, this);
        }
        if (this.mImagePerfRequestListener == null) {
            this.mImagePerfRequestListener = new com.facebook.drawee.backends.pipeline.info.internal.ImagePerfRequestListener(this.mMonotonicClock, this.mImagePerfState);
        }
        if (this.mForwardingRequestListener == null) {
            this.mForwardingRequestListener = new com.facebook.imagepipeline.listener.ForwardingRequestListener(this.mImagePerfRequestListener);
        }
    }

    public void reset() {
        clearImagePerfDataListeners();
        setEnabled(false);
        this.mImagePerfState.reset();
    }
}
