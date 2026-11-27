package com.facebook.imagepipeline.animated.base;

/* JADX INFO: loaded from: classes.dex */
public interface AnimatedImageFrame {
    void dispose();

    int getDurationMs();

    int getHeight();

    int getWidth();

    int getXOffset();

    int getYOffset();

    void renderFrame(int i, int i2, android.graphics.Bitmap bitmap);
}
