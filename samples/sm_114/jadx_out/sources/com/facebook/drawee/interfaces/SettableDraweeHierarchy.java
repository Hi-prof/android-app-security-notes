package com.facebook.drawee.interfaces;

/* JADX INFO: loaded from: classes.dex */
public interface SettableDraweeHierarchy extends com.facebook.drawee.interfaces.DraweeHierarchy {
    void reset();

    void setControllerOverlay(android.graphics.drawable.Drawable drawable);

    void setFailure(java.lang.Throwable th);

    void setImage(android.graphics.drawable.Drawable drawable, float f, boolean z);

    void setProgress(float f, boolean z);

    void setRetry(java.lang.Throwable th);
}
