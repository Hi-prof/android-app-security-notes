package com.facebook.drawee.backends.pipeline.info.internal;

/* JADX INFO: loaded from: classes.dex */
public class ImagePerfStateManager extends com.facebook.fresco.ui.common.BaseControllerListener2<com.facebook.imagepipeline.image.ImageInfo> implements com.facebook.fresco.ui.common.ImagePerfNotifierHolder, com.facebook.fresco.ui.common.OnDrawControllerListener<com.facebook.imagepipeline.image.ImageInfo>, java.io.Closeable, com.facebook.fresco.ui.common.VisibilityAware, com.facebook.drawee.drawable.VisibilityCallback {
    private final com.facebook.common.time.MonotonicClock mClock;
    private final com.facebook.fresco.ui.common.ImagePerfNotifier mImagePerfNotifier;
    private final com.facebook.fresco.ui.common.ImagePerfState mImagePerfState;

    @javax.annotation.Nullable
    private com.facebook.fresco.ui.common.ImagePerfNotifier mLocalImagePerfNotifier;
    private final boolean mReportVisibleOnSubmitAndRelease;

    @Override // com.facebook.drawee.drawable.VisibilityCallback
    public void onDraw() {
    }

    public ImagePerfStateManager(com.facebook.common.time.MonotonicClock monotonicClock, com.facebook.fresco.ui.common.ImagePerfState imagePerfState, com.facebook.fresco.ui.common.ImagePerfNotifier imagePerfNotifier) {
        this(monotonicClock, imagePerfState, imagePerfNotifier, true);
    }

    public ImagePerfStateManager(com.facebook.common.time.MonotonicClock monotonicClock, com.facebook.fresco.ui.common.ImagePerfState imagePerfState, com.facebook.fresco.ui.common.ImagePerfNotifier imagePerfNotifier, boolean z) {
        this.mLocalImagePerfNotifier = null;
        this.mClock = monotonicClock;
        this.mImagePerfState = imagePerfState;
        this.mImagePerfNotifier = imagePerfNotifier;
        this.mReportVisibleOnSubmitAndRelease = z;
    }

    @Override // com.facebook.fresco.ui.common.ImagePerfNotifierHolder
    public void setImagePerfNotifier(@javax.annotation.Nullable com.facebook.fresco.ui.common.ImagePerfNotifier imagePerfNotifier) {
        this.mLocalImagePerfNotifier = imagePerfNotifier;
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onSubmit(java.lang.String str, @javax.annotation.Nullable java.lang.Object obj, @javax.annotation.Nullable com.facebook.fresco.ui.common.ControllerListener2.Extras extras) {
        long jNow = this.mClock.now();
        com.facebook.fresco.ui.common.ImagePerfState imagePerfState = this.mImagePerfState;
        imagePerfState.resetPointsTimestamps();
        imagePerfState.setControllerSubmitTimeMs(jNow);
        imagePerfState.setControllerId(str);
        imagePerfState.setCallerContext(obj);
        imagePerfState.setExtraData(extras);
        updateStatus(imagePerfState, com.facebook.fresco.ui.common.ImageLoadStatus.REQUESTED);
        if (this.mReportVisibleOnSubmitAndRelease) {
            reportViewVisible(imagePerfState, jNow);
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageSet(java.lang.String str, @javax.annotation.Nullable com.facebook.imagepipeline.image.ImageInfo imageInfo) {
        long jNow = this.mClock.now();
        com.facebook.fresco.ui.common.ImagePerfState imagePerfState = this.mImagePerfState;
        imagePerfState.setControllerIntermediateImageSetTimeMs(jNow);
        imagePerfState.setControllerId(str);
        imagePerfState.setImageInfo(imageInfo);
        updateStatus(imagePerfState, com.facebook.fresco.ui.common.ImageLoadStatus.INTERMEDIATE_AVAILABLE);
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onFinalImageSet(java.lang.String str, @javax.annotation.Nullable com.facebook.imagepipeline.image.ImageInfo imageInfo, @javax.annotation.Nullable com.facebook.fresco.ui.common.ControllerListener2.Extras extras) {
        long jNow = this.mClock.now();
        com.facebook.fresco.ui.common.ImagePerfState imagePerfState = this.mImagePerfState;
        imagePerfState.setExtraData(extras);
        imagePerfState.setControllerFinalImageSetTimeMs(jNow);
        imagePerfState.setImageRequestEndTimeMs(jNow);
        imagePerfState.setControllerId(str);
        imagePerfState.setImageInfo(imageInfo);
        updateStatus(imagePerfState, com.facebook.fresco.ui.common.ImageLoadStatus.SUCCESS);
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onFailure(java.lang.String str, @javax.annotation.Nullable java.lang.Throwable th, @javax.annotation.Nullable com.facebook.fresco.ui.common.ControllerListener2.Extras extras) {
        long jNow = this.mClock.now();
        com.facebook.fresco.ui.common.ImagePerfState imagePerfState = this.mImagePerfState;
        imagePerfState.setExtraData(extras);
        imagePerfState.setControllerFailureTimeMs(jNow);
        imagePerfState.setControllerId(str);
        imagePerfState.setErrorThrowable(th);
        updateStatus(imagePerfState, com.facebook.fresco.ui.common.ImageLoadStatus.ERROR);
        reportViewInvisible(imagePerfState, jNow);
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onRelease(java.lang.String str, @javax.annotation.Nullable com.facebook.fresco.ui.common.ControllerListener2.Extras extras) {
        long jNow = this.mClock.now();
        com.facebook.fresco.ui.common.ImagePerfState imagePerfState = this.mImagePerfState;
        imagePerfState.setExtraData(extras);
        imagePerfState.setControllerId(str);
        updateStatus(imagePerfState, com.facebook.fresco.ui.common.ImageLoadStatus.RELEASED);
        if (this.mReportVisibleOnSubmitAndRelease) {
            reportViewInvisible(imagePerfState, jNow);
        }
    }

    @Override // com.facebook.fresco.ui.common.OnDrawControllerListener
    public void onImageDrawn(java.lang.String str, com.facebook.imagepipeline.image.ImageInfo imageInfo, com.facebook.fresco.ui.common.DimensionsInfo dimensionsInfo) {
        com.facebook.fresco.ui.common.ImagePerfState imagePerfState = this.mImagePerfState;
        imagePerfState.setControllerId(str);
        imagePerfState.setDimensionsInfo(dimensionsInfo);
    }

    public void reportViewVisible(com.facebook.fresco.ui.common.ImagePerfState imagePerfState, long j) {
        imagePerfState.setVisible(true);
        imagePerfState.setVisibilityEventTimeMs(j);
        updateVisibility(imagePerfState, com.facebook.fresco.ui.common.VisibilityState.VISIBLE);
    }

    public void resetState() {
        this.mImagePerfState.reset();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        resetState();
    }

    private void reportViewInvisible(com.facebook.fresco.ui.common.ImagePerfState imagePerfState, long j) {
        imagePerfState.setVisible(false);
        imagePerfState.setInvisibilityEventTimeMs(j);
        updateVisibility(imagePerfState, com.facebook.fresco.ui.common.VisibilityState.INVISIBLE);
    }

    private void updateStatus(com.facebook.fresco.ui.common.ImagePerfState imagePerfState, com.facebook.fresco.ui.common.ImageLoadStatus imageLoadStatus) {
        imagePerfState.setImageLoadStatus(imageLoadStatus);
        this.mImagePerfNotifier.notifyStatusUpdated(imagePerfState, imageLoadStatus);
        com.facebook.fresco.ui.common.ImagePerfNotifier imagePerfNotifier = this.mLocalImagePerfNotifier;
        if (imagePerfNotifier != null) {
            imagePerfNotifier.notifyStatusUpdated(imagePerfState, imageLoadStatus);
        }
    }

    private void updateVisibility(com.facebook.fresco.ui.common.ImagePerfState imagePerfState, com.facebook.fresco.ui.common.VisibilityState visibilityState) {
        this.mImagePerfNotifier.notifyVisibilityUpdated(imagePerfState, visibilityState);
        com.facebook.fresco.ui.common.ImagePerfNotifier imagePerfNotifier = this.mLocalImagePerfNotifier;
        if (imagePerfNotifier != null) {
            imagePerfNotifier.notifyVisibilityUpdated(imagePerfState, visibilityState);
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onEmptyEvent(@javax.annotation.Nullable java.lang.Object obj) {
        com.facebook.fresco.ui.common.ImagePerfState imagePerfState = this.mImagePerfState;
        imagePerfState.setImageLoadStatus(com.facebook.fresco.ui.common.ImageLoadStatus.EMPTY_EVENT);
        this.mImagePerfNotifier.notifyStatusUpdated(imagePerfState, com.facebook.fresco.ui.common.ImageLoadStatus.EMPTY_EVENT);
        com.facebook.fresco.ui.common.ImagePerfNotifier imagePerfNotifier = this.mLocalImagePerfNotifier;
        if (imagePerfNotifier != null) {
            imagePerfNotifier.notifyStatusUpdated(imagePerfState, com.facebook.fresco.ui.common.ImageLoadStatus.EMPTY_EVENT);
        }
    }

    @Override // com.facebook.fresco.ui.common.VisibilityAware
    public void reportVisible(boolean z) {
        onVisibilityChange(z);
    }

    @Override // com.facebook.drawee.drawable.VisibilityCallback
    public void onVisibilityChange(boolean z) {
        if (z) {
            reportViewVisible(this.mImagePerfState, this.mClock.now());
        } else {
            reportViewInvisible(this.mImagePerfState, this.mClock.now());
        }
    }
}
