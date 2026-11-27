package com.facebook.imagepipeline.animated.base;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedDrawableOptionsBuilder {
    private boolean mEnableDebugging;
    private boolean mForceKeepAllFramesInMemory;
    private boolean mAllowPrefetching = true;
    private int mMaximumBytes = -1;

    public boolean getForceKeepAllFramesInMemory() {
        return this.mForceKeepAllFramesInMemory;
    }

    public com.facebook.imagepipeline.animated.base.AnimatedDrawableOptionsBuilder setForceKeepAllFramesInMemory(boolean z) {
        this.mForceKeepAllFramesInMemory = z;
        return this;
    }

    public boolean getAllowPrefetching() {
        return this.mAllowPrefetching;
    }

    public com.facebook.imagepipeline.animated.base.AnimatedDrawableOptionsBuilder setAllowPrefetching(boolean z) {
        this.mAllowPrefetching = z;
        return this;
    }

    public int getMaximumBytes() {
        return this.mMaximumBytes;
    }

    public com.facebook.imagepipeline.animated.base.AnimatedDrawableOptionsBuilder setMaximumBytes(int i) {
        this.mMaximumBytes = i;
        return this;
    }

    public boolean getEnableDebugging() {
        return this.mEnableDebugging;
    }

    public com.facebook.imagepipeline.animated.base.AnimatedDrawableOptionsBuilder setEnableDebugging(boolean z) {
        this.mEnableDebugging = z;
        return this;
    }

    public com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions build() {
        return new com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions(this);
    }
}
