package com.facebook.drawee.backends.pipeline.info;

/* JADX INFO: loaded from: classes.dex */
public class ForwardingImageOriginListener implements com.facebook.drawee.backends.pipeline.info.ImageOriginListener {
    private static final java.lang.String TAG = "ForwardingImageOriginListener";
    private final java.util.List<com.facebook.drawee.backends.pipeline.info.ImageOriginListener> mImageOriginListeners;

    public ForwardingImageOriginListener(java.util.Set<com.facebook.drawee.backends.pipeline.info.ImageOriginListener> set) {
        this.mImageOriginListeners = new java.util.ArrayList(set);
    }

    public ForwardingImageOriginListener(com.facebook.drawee.backends.pipeline.info.ImageOriginListener... imageOriginListenerArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList(imageOriginListenerArr.length);
        this.mImageOriginListeners = arrayList;
        java.util.Collections.addAll(arrayList, imageOriginListenerArr);
    }

    public synchronized void addImageOriginListener(com.facebook.drawee.backends.pipeline.info.ImageOriginListener imageOriginListener) {
        this.mImageOriginListeners.add(imageOriginListener);
    }

    public synchronized void removeImageOriginListener(com.facebook.drawee.backends.pipeline.info.ImageOriginListener imageOriginListener) {
        this.mImageOriginListeners.remove(imageOriginListener);
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImageOriginListener
    public synchronized void onImageLoaded(java.lang.String str, int i, boolean z, @javax.annotation.Nullable java.lang.String str2) {
        int size = this.mImageOriginListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.facebook.drawee.backends.pipeline.info.ImageOriginListener imageOriginListener = this.mImageOriginListeners.get(i2);
            if (imageOriginListener != null) {
                try {
                    imageOriginListener.onImageLoaded(str, i, z, str2);
                } catch (java.lang.Exception e) {
                    com.facebook.common.logging.FLog.e(TAG, "InternalListener exception in onImageLoaded", e);
                }
            }
        }
    }
}
