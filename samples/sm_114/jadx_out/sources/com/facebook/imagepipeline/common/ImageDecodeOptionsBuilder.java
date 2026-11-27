package com.facebook.imagepipeline.common;

/* JADX INFO: loaded from: classes.dex */
public class ImageDecodeOptionsBuilder<T extends com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder> {

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.transformation.BitmapTransformation mBitmapTransformation;

    @javax.annotation.Nullable
    private android.graphics.ColorSpace mColorSpace;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.decoder.ImageDecoder mCustomImageDecoder;
    private boolean mDecodeAllFrames;
    private boolean mDecodePreviewFrame;
    private boolean mExcludeBitmapConfigFromComparison;
    private boolean mForceStaticImage;
    private boolean mUseEncodedImageForPreivew;
    private boolean mUseLastFrameForPreview;
    private int mMinDecodeIntervalMs = 100;
    private int mMaxDimensionPx = Integer.MAX_VALUE;
    private android.graphics.Bitmap.Config mBitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;
    private android.graphics.Bitmap.Config mAnimatedBitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;

    protected T getThis() {
        return this;
    }

    public com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder setFrom(com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        this.mMinDecodeIntervalMs = imageDecodeOptions.minDecodeIntervalMs;
        this.mMaxDimensionPx = imageDecodeOptions.maxDimensionPx;
        this.mDecodePreviewFrame = imageDecodeOptions.decodePreviewFrame;
        this.mUseLastFrameForPreview = imageDecodeOptions.useLastFrameForPreview;
        this.mDecodeAllFrames = imageDecodeOptions.decodeAllFrames;
        this.mForceStaticImage = imageDecodeOptions.forceStaticImage;
        this.mBitmapConfig = imageDecodeOptions.bitmapConfig;
        this.mAnimatedBitmapConfig = imageDecodeOptions.animatedBitmapConfig;
        this.mCustomImageDecoder = imageDecodeOptions.customImageDecoder;
        this.mBitmapTransformation = imageDecodeOptions.bitmapTransformation;
        this.mColorSpace = imageDecodeOptions.colorSpace;
        return getThis();
    }

    public T setMinDecodeIntervalMs(int i) {
        this.mMinDecodeIntervalMs = i;
        return (T) getThis();
    }

    public int getMinDecodeIntervalMs() {
        return this.mMinDecodeIntervalMs;
    }

    public T setMaxDimensionPx(int i) {
        this.mMaxDimensionPx = i;
        return (T) getThis();
    }

    public int getMaxDimensionPx() {
        return this.mMaxDimensionPx;
    }

    public T setDecodePreviewFrame(boolean z) {
        this.mDecodePreviewFrame = z;
        return (T) getThis();
    }

    public boolean getDecodePreviewFrame() {
        return this.mDecodePreviewFrame;
    }

    public boolean getUseLastFrameForPreview() {
        return this.mUseLastFrameForPreview;
    }

    public T setUseLastFrameForPreview(boolean z) {
        this.mUseLastFrameForPreview = z;
        return (T) getThis();
    }

    public boolean getUseEncodedImageForPreview() {
        return this.mUseEncodedImageForPreivew;
    }

    public T setUseEncodedImageForPreview(boolean z) {
        this.mUseEncodedImageForPreivew = z;
        return (T) getThis();
    }

    public boolean getDecodeAllFrames() {
        return this.mDecodeAllFrames;
    }

    public T setDecodeAllFrames(boolean z) {
        this.mDecodeAllFrames = z;
        return (T) getThis();
    }

    public T setForceStaticImage(boolean z) {
        this.mForceStaticImage = z;
        return (T) getThis();
    }

    public T setCustomImageDecoder(@javax.annotation.Nullable com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder) {
        this.mCustomImageDecoder = imageDecoder;
        return (T) getThis();
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.decoder.ImageDecoder getCustomImageDecoder() {
        return this.mCustomImageDecoder;
    }

    public boolean getForceStaticImage() {
        return this.mForceStaticImage;
    }

    public android.graphics.Bitmap.Config getBitmapConfig() {
        return this.mBitmapConfig;
    }

    public T setBitmapConfig(android.graphics.Bitmap.Config config) {
        this.mBitmapConfig = config;
        return (T) getThis();
    }

    public android.graphics.Bitmap.Config getAnimatedBitmapConfig() {
        return this.mAnimatedBitmapConfig;
    }

    public T setAnimatedBitmapConfig(android.graphics.Bitmap.Config config) {
        this.mAnimatedBitmapConfig = config;
        return (T) getThis();
    }

    public T setBitmapTransformation(@javax.annotation.Nullable com.facebook.imagepipeline.transformation.BitmapTransformation bitmapTransformation) {
        this.mBitmapTransformation = bitmapTransformation;
        return (T) getThis();
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.transformation.BitmapTransformation getBitmapTransformation() {
        return this.mBitmapTransformation;
    }

    public T setColorSpace(android.graphics.ColorSpace colorSpace) {
        this.mColorSpace = colorSpace;
        return (T) getThis();
    }

    @javax.annotation.Nullable
    public android.graphics.ColorSpace getColorSpace() {
        return this.mColorSpace;
    }

    public T setExcludeBitmapConfigFromComparison(boolean z) {
        this.mExcludeBitmapConfigFromComparison = z;
        return (T) getThis();
    }

    public boolean getExcludeBitmapConfigFromComparison() {
        return this.mExcludeBitmapConfigFromComparison;
    }

    public com.facebook.imagepipeline.common.ImageDecodeOptions build() {
        return new com.facebook.imagepipeline.common.ImageDecodeOptions(this);
    }
}
