package com.facebook.drawee.backends.pipeline.info.internal;

/* JADX INFO: loaded from: classes.dex */
public class ImagePerfRequestListener extends com.facebook.imagepipeline.listener.BaseRequestListener {
    private final com.facebook.common.time.MonotonicClock mClock;
    private final com.facebook.fresco.ui.common.ImagePerfState mImagePerfState;

    public ImagePerfRequestListener(com.facebook.common.time.MonotonicClock monotonicClock, com.facebook.fresco.ui.common.ImagePerfState imagePerfState) {
        this.mClock = monotonicClock;
        this.mImagePerfState = imagePerfState;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestStart(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object obj, java.lang.String str, boolean z) {
        this.mImagePerfState.setImageRequestStartTimeMs(this.mClock.now());
        this.mImagePerfState.setImageRequest(imageRequest);
        this.mImagePerfState.setCallerContext(obj);
        this.mImagePerfState.setRequestId(str);
        this.mImagePerfState.setPrefetch(z);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestSuccess(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.String str, boolean z) {
        this.mImagePerfState.setImageRequestEndTimeMs(this.mClock.now());
        this.mImagePerfState.setImageRequest(imageRequest);
        this.mImagePerfState.setRequestId(str);
        this.mImagePerfState.setPrefetch(z);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestFailure(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.String str, java.lang.Throwable th, boolean z) {
        this.mImagePerfState.setImageRequestEndTimeMs(this.mClock.now());
        this.mImagePerfState.setImageRequest(imageRequest);
        this.mImagePerfState.setRequestId(str);
        this.mImagePerfState.setPrefetch(z);
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestCancellation(java.lang.String str) {
        this.mImagePerfState.setImageRequestEndTimeMs(this.mClock.now());
        this.mImagePerfState.setRequestId(str);
    }
}
