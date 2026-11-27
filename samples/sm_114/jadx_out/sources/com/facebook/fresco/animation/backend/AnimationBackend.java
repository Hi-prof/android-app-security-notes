package com.facebook.fresco.animation.backend;

/* JADX INFO: loaded from: classes.dex */
public interface AnimationBackend extends com.facebook.fresco.animation.backend.AnimationInformation {
    public static final int INTRINSIC_DIMENSION_UNSET = -1;

    public interface Listener {
        void onAnimationLoaded();
    }

    void clear();

    boolean drawFrame(android.graphics.drawable.Drawable drawable, android.graphics.Canvas canvas, int i);

    int getIntrinsicHeight();

    int getIntrinsicWidth();

    int getSizeInBytes();

    void preloadAnimation();

    void setAlpha(int i);

    void setAnimationListener(@javax.annotation.Nullable com.facebook.fresco.animation.backend.AnimationBackend.Listener listener);

    void setBounds(android.graphics.Rect rect);

    void setColorFilter(@javax.annotation.Nullable android.graphics.ColorFilter colorFilter);
}
