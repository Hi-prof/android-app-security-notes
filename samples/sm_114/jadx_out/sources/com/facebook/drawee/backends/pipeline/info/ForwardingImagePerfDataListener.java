package com.facebook.drawee.backends.pipeline.info;

/* JADX INFO: loaded from: classes.dex */
public class ForwardingImagePerfDataListener implements com.facebook.fresco.ui.common.ImagePerfDataListener {
    private final java.util.Collection<com.facebook.fresco.ui.common.ImagePerfDataListener> mListeners;

    public ForwardingImagePerfDataListener(java.util.Collection<com.facebook.fresco.ui.common.ImagePerfDataListener> collection) {
        this.mListeners = collection;
    }

    @Override // com.facebook.fresco.ui.common.ImagePerfDataListener
    public void onImageLoadStatusUpdated(com.facebook.fresco.ui.common.ImagePerfData imagePerfData, com.facebook.fresco.ui.common.ImageLoadStatus imageLoadStatus) {
        java.util.Iterator<com.facebook.fresco.ui.common.ImagePerfDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onImageLoadStatusUpdated(imagePerfData, imageLoadStatus);
        }
    }

    @Override // com.facebook.fresco.ui.common.ImagePerfDataListener
    public void onImageVisibilityUpdated(com.facebook.fresco.ui.common.ImagePerfData imagePerfData, com.facebook.fresco.ui.common.VisibilityState visibilityState) {
        java.util.Iterator<com.facebook.fresco.ui.common.ImagePerfDataListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onImageVisibilityUpdated(imagePerfData, visibilityState);
        }
    }
}
