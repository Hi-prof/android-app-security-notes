package com.facebook.drawee.controller;

/* JADX INFO: loaded from: classes.dex */
public class BaseControllerListener<INFO> implements com.facebook.drawee.controller.ControllerListener<INFO> {
    private static final com.facebook.drawee.controller.ControllerListener<java.lang.Object> NO_OP_LISTENER = new com.facebook.drawee.controller.BaseControllerListener();

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onFailure(java.lang.String str, java.lang.Throwable th) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(java.lang.String str, @javax.annotation.Nullable INFO info, @javax.annotation.Nullable android.graphics.drawable.Animatable animatable) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageFailed(java.lang.String str, java.lang.Throwable th) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageSet(java.lang.String str, @javax.annotation.Nullable INFO info) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onRelease(java.lang.String str) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onSubmit(java.lang.String str, java.lang.Object obj) {
    }

    public static <INFO> com.facebook.drawee.controller.ControllerListener<INFO> getNoOpListener() {
        return (com.facebook.drawee.controller.ControllerListener<INFO>) NO_OP_LISTENER;
    }
}
