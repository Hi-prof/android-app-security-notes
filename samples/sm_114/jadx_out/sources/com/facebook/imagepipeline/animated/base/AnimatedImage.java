package com.facebook.imagepipeline.animated.base;

/* JADX INFO: loaded from: classes.dex */
public interface AnimatedImage {
    public static final int LOOP_COUNT_INFINITE = 0;

    void dispose();

    boolean doesRenderSupportScaling();

    @javax.annotation.Nullable
    android.graphics.Bitmap.Config getAnimatedBitmapConfig();

    int getDuration();

    com.facebook.imagepipeline.animated.base.AnimatedImageFrame getFrame(int i);

    int getFrameCount();

    int[] getFrameDurations();

    com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo getFrameInfo(int i);

    int getHeight();

    int getLoopCount();

    int getSizeInBytes();

    int getWidth();
}
