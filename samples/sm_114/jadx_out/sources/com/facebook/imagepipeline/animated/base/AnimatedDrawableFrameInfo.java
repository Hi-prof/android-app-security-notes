package com.facebook.imagepipeline.animated.base;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedDrawableFrameInfo {
    public final com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.BlendOperation blendOperation;
    public final com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod disposalMethod;
    public final int frameNumber;
    public final int height;
    public final int width;
    public final int xOffset;
    public final int yOffset;

    public enum BlendOperation {
        BLEND_WITH_PREVIOUS,
        NO_BLEND
    }

    public enum DisposalMethod {
        DISPOSE_DO_NOT,
        DISPOSE_TO_BACKGROUND,
        DISPOSE_TO_PREVIOUS
    }

    public AnimatedDrawableFrameInfo(int i, int i2, int i3, int i4, int i5, com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.BlendOperation blendOperation, com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod disposalMethod) {
        this.frameNumber = i;
        this.xOffset = i2;
        this.yOffset = i3;
        this.width = i4;
        this.height = i5;
        this.blendOperation = blendOperation;
        this.disposalMethod = disposalMethod;
    }
}
