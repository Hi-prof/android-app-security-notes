package com.facebook.drawee.controller;

/* JADX INFO: loaded from: classes.dex */
public interface ControllerListener<INFO> {
    void onFailure(java.lang.String str, java.lang.Throwable th);

    void onFinalImageSet(java.lang.String str, @javax.annotation.Nullable INFO info, @javax.annotation.Nullable android.graphics.drawable.Animatable animatable);

    void onIntermediateImageFailed(java.lang.String str, java.lang.Throwable th);

    void onIntermediateImageSet(java.lang.String str, @javax.annotation.Nullable INFO info);

    void onRelease(java.lang.String str);

    void onSubmit(java.lang.String str, java.lang.Object obj);
}
