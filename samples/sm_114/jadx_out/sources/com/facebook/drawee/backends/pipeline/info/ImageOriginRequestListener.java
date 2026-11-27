package com.facebook.drawee.backends.pipeline.info;

/* JADX INFO: loaded from: classes.dex */
public class ImageOriginRequestListener extends com.facebook.imagepipeline.listener.BaseRequestListener {
    private java.lang.String mControllerId;

    @javax.annotation.Nullable
    private final com.facebook.drawee.backends.pipeline.info.ImageOriginListener mImageOriginLister;

    public ImageOriginRequestListener(java.lang.String str, @javax.annotation.Nullable com.facebook.drawee.backends.pipeline.info.ImageOriginListener imageOriginListener) {
        this.mImageOriginLister = imageOriginListener;
        init(str);
    }

    public void init(java.lang.String str) {
        this.mControllerId = str;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onUltimateProducerReached(java.lang.String str, java.lang.String str2, boolean z) {
        com.facebook.drawee.backends.pipeline.info.ImageOriginListener imageOriginListener = this.mImageOriginLister;
        if (imageOriginListener != null) {
            imageOriginListener.onImageLoaded(this.mControllerId, com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.mapProducerNameToImageOrigin(str2), z, str2);
        }
    }
}
