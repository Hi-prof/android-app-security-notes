package com.facebook.drawee.interfaces;

/* JADX INFO: loaded from: classes.dex */
public interface DraweeController {
    android.graphics.drawable.Animatable getAnimatable();

    java.lang.String getContentDescription();

    @javax.annotation.Nullable
    com.facebook.drawee.interfaces.DraweeHierarchy getHierarchy();

    boolean isSameImageRequest(com.facebook.drawee.interfaces.DraweeController draweeController);

    void onAttach();

    void onDetach();

    boolean onTouchEvent(android.view.MotionEvent motionEvent);

    void onViewportVisibilityHint(boolean z);

    void setContentDescription(java.lang.String str);

    void setHierarchy(@javax.annotation.Nullable com.facebook.drawee.interfaces.DraweeHierarchy draweeHierarchy);
}
