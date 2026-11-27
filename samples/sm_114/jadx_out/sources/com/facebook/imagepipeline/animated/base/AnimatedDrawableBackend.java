package com.facebook.imagepipeline.animated.base;

/* JADX INFO: loaded from: classes.dex */
public interface AnimatedDrawableBackend {
    void dropCaches();

    com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend forNewBounds(@javax.annotation.Nullable android.graphics.Rect rect);

    com.facebook.imagepipeline.animated.base.AnimatedImageResult getAnimatedImageResult();

    int getDurationMs();

    int getDurationMsForFrame(int i);

    int getFrameCount();

    int getFrameForPreview();

    int getFrameForTimestampMs(int i);

    com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo getFrameInfo(int i);

    int getHeight();

    int getLoopCount();

    int getMemoryUsage();

    @javax.annotation.Nullable
    com.facebook.common.references.CloseableReference<android.graphics.Bitmap> getPreDecodedFrame(int i);

    int getRenderedHeight();

    int getRenderedWidth();

    int getTimestampMsForFrame(int i);

    int getWidth();

    boolean hasPreDecodedFrame(int i);

    void renderDeltas(int i, android.graphics.Canvas canvas);

    void renderFrame(int i, android.graphics.Canvas canvas);
}
