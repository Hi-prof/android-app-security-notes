package com.facebook.imagepipeline.animated.base;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedDrawableOptions {
    public static com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions DEFAULTS = newBuilder().build();
    public final boolean allowPrefetching;
    public final boolean enableDebugging;
    public final boolean forceKeepAllFramesInMemory;
    public final int maximumBytes;

    public AnimatedDrawableOptions(com.facebook.imagepipeline.animated.base.AnimatedDrawableOptionsBuilder animatedDrawableOptionsBuilder) {
        this.forceKeepAllFramesInMemory = animatedDrawableOptionsBuilder.getForceKeepAllFramesInMemory();
        this.allowPrefetching = animatedDrawableOptionsBuilder.getAllowPrefetching();
        this.maximumBytes = animatedDrawableOptionsBuilder.getMaximumBytes();
        this.enableDebugging = animatedDrawableOptionsBuilder.getEnableDebugging();
    }

    public static com.facebook.imagepipeline.animated.base.AnimatedDrawableOptionsBuilder newBuilder() {
        return new com.facebook.imagepipeline.animated.base.AnimatedDrawableOptionsBuilder();
    }
}
