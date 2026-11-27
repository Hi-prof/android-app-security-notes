package com.facebook.drawee.controller;

/* JADX INFO: loaded from: classes.dex */
public class ForwardingControllerListener<INFO> implements com.facebook.drawee.controller.ControllerListener<INFO>, com.facebook.fresco.ui.common.OnDrawControllerListener<INFO> {
    private static final java.lang.String TAG = "FdingControllerListener";
    private final java.util.List<com.facebook.drawee.controller.ControllerListener<? super INFO>> mListeners = new java.util.ArrayList(2);

    public static <INFO> com.facebook.drawee.controller.ForwardingControllerListener<INFO> create() {
        return new com.facebook.drawee.controller.ForwardingControllerListener<>();
    }

    public static <INFO> com.facebook.drawee.controller.ForwardingControllerListener<INFO> of(com.facebook.drawee.controller.ControllerListener<? super INFO> controllerListener) {
        com.facebook.drawee.controller.ForwardingControllerListener<INFO> forwardingControllerListenerCreate = create();
        forwardingControllerListenerCreate.addListener(controllerListener);
        return forwardingControllerListenerCreate;
    }

    public static <INFO> com.facebook.drawee.controller.ForwardingControllerListener<INFO> of(com.facebook.drawee.controller.ControllerListener<? super INFO> controllerListener, com.facebook.drawee.controller.ControllerListener<? super INFO> controllerListener2) {
        com.facebook.drawee.controller.ForwardingControllerListener<INFO> forwardingControllerListenerCreate = create();
        forwardingControllerListenerCreate.addListener(controllerListener);
        forwardingControllerListenerCreate.addListener(controllerListener2);
        return forwardingControllerListenerCreate;
    }

    public synchronized void addListener(com.facebook.drawee.controller.ControllerListener<? super INFO> controllerListener) {
        this.mListeners.add(controllerListener);
    }

    public synchronized void removeListener(com.facebook.drawee.controller.ControllerListener<? super INFO> controllerListener) {
        int iIndexOf = this.mListeners.indexOf(controllerListener);
        if (iIndexOf != -1) {
            this.mListeners.set(iIndexOf, null);
        }
    }

    public synchronized void clearListeners() {
        this.mListeners.clear();
    }

    private synchronized void onException(java.lang.String str, java.lang.Throwable th) {
        android.util.Log.e(TAG, str, th);
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onSubmit(java.lang.String str, java.lang.Object obj) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                com.facebook.drawee.controller.ControllerListener<? super INFO> controllerListener = this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onSubmit(str, obj);
                }
            } catch (java.lang.Exception e) {
                onException("InternalListener exception in onSubmit", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onFinalImageSet(java.lang.String str, @javax.annotation.Nullable INFO info, @javax.annotation.Nullable android.graphics.drawable.Animatable animatable) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                com.facebook.drawee.controller.ControllerListener<? super INFO> controllerListener = this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onFinalImageSet(str, info, animatable);
                }
            } catch (java.lang.Exception e) {
                onException("InternalListener exception in onFinalImageSet", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageSet(java.lang.String str, @javax.annotation.Nullable INFO info) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                com.facebook.drawee.controller.ControllerListener<? super INFO> controllerListener = this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onIntermediateImageSet(str, info);
                }
            } catch (java.lang.Exception e) {
                onException("InternalListener exception in onIntermediateImageSet", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageFailed(java.lang.String str, java.lang.Throwable th) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                com.facebook.drawee.controller.ControllerListener<? super INFO> controllerListener = this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onIntermediateImageFailed(str, th);
                }
            } catch (java.lang.Exception e) {
                onException("InternalListener exception in onIntermediateImageFailed", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onFailure(java.lang.String str, java.lang.Throwable th) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                com.facebook.drawee.controller.ControllerListener<? super INFO> controllerListener = this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onFailure(str, th);
                }
            } catch (java.lang.Exception e) {
                onException("InternalListener exception in onFailure", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onRelease(java.lang.String str) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                com.facebook.drawee.controller.ControllerListener<? super INFO> controllerListener = this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onRelease(str);
                }
            } catch (java.lang.Exception e) {
                onException("InternalListener exception in onRelease", e);
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.OnDrawControllerListener
    public void onImageDrawn(java.lang.String str, INFO info, com.facebook.fresco.ui.common.DimensionsInfo dimensionsInfo) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                com.facebook.drawee.controller.ControllerListener<? super INFO> controllerListener = this.mListeners.get(i);
                if (controllerListener instanceof com.facebook.fresco.ui.common.OnDrawControllerListener) {
                    ((com.facebook.fresco.ui.common.OnDrawControllerListener) controllerListener).onImageDrawn(str, info, dimensionsInfo);
                }
            } catch (java.lang.Exception e) {
                onException("InternalListener exception in onImageDrawn", e);
            }
        }
    }
}
