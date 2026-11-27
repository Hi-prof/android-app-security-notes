package com.facebook.imagepipeline.listener;

/* JADX INFO: loaded from: classes.dex */
public class ForwardingRequestListener implements com.facebook.imagepipeline.listener.RequestListener {
    private static final java.lang.String TAG = "ForwardingRequestListener";
    private final java.util.List<com.facebook.imagepipeline.listener.RequestListener> mRequestListeners;

    public ForwardingRequestListener(java.util.Set<com.facebook.imagepipeline.listener.RequestListener> set) {
        this.mRequestListeners = new java.util.ArrayList(set.size());
        for (com.facebook.imagepipeline.listener.RequestListener requestListener : set) {
            if (requestListener != null) {
                this.mRequestListeners.add(requestListener);
            }
        }
    }

    public ForwardingRequestListener(com.facebook.imagepipeline.listener.RequestListener... requestListenerArr) {
        this.mRequestListeners = new java.util.ArrayList(requestListenerArr.length);
        for (com.facebook.imagepipeline.listener.RequestListener requestListener : requestListenerArr) {
            if (requestListener != null) {
                this.mRequestListeners.add(requestListener);
            }
        }
    }

    public void addRequestListener(com.facebook.imagepipeline.listener.RequestListener requestListener) {
        this.mRequestListeners.add(requestListener);
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestStart(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object obj, java.lang.String str, boolean z) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onRequestStart(imageRequest, obj, str, z);
            } catch (java.lang.Exception e) {
                onException("InternalListener exception in onRequestStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerStart(java.lang.String str, java.lang.String str2) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onProducerStart(str, str2);
            } catch (java.lang.Exception e) {
                onException("InternalListener exception in onProducerStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithSuccess(java.lang.String str, java.lang.String str2, @javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> map) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onProducerFinishWithSuccess(str, str2, map);
            } catch (java.lang.Exception e) {
                onException("InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithFailure(java.lang.String str, java.lang.String str2, java.lang.Throwable th, @javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> map) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onProducerFinishWithFailure(str, str2, th, map);
            } catch (java.lang.Exception e) {
                onException("InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithCancellation(java.lang.String str, java.lang.String str2, @javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> map) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onProducerFinishWithCancellation(str, str2, map);
            } catch (java.lang.Exception e) {
                onException("InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerEvent(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onProducerEvent(str, str2, str3);
            } catch (java.lang.Exception e) {
                onException("InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onUltimateProducerReached(java.lang.String str, java.lang.String str2, boolean z) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onUltimateProducerReached(str, str2, z);
            } catch (java.lang.Exception e) {
                onException("InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestSuccess(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.String str, boolean z) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onRequestSuccess(imageRequest, str, z);
            } catch (java.lang.Exception e) {
                onException("InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestFailure(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.String str, java.lang.Throwable th, boolean z) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onRequestFailure(imageRequest, str, th, z);
            } catch (java.lang.Exception e) {
                onException("InternalListener exception in onRequestFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestCancellation(java.lang.String str) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                this.mRequestListeners.get(i).onRequestCancellation(str);
            } catch (java.lang.Exception e) {
                onException("InternalListener exception in onRequestCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public boolean requiresExtraMap(java.lang.String str) {
        int size = this.mRequestListeners.size();
        for (int i = 0; i < size; i++) {
            if (this.mRequestListeners.get(i).requiresExtraMap(str)) {
                return true;
            }
        }
        return false;
    }

    private void onException(java.lang.String str, java.lang.Throwable th) {
        com.facebook.common.logging.FLog.e(TAG, str, th);
    }
}
