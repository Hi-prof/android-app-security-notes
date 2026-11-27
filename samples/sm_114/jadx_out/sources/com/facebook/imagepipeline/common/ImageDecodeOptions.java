package com.facebook.imagepipeline.common;

/* JADX INFO: loaded from: classes.dex */
public class ImageDecodeOptions {
    private static final com.facebook.imagepipeline.common.ImageDecodeOptions DEFAULTS = newBuilder().build();
    public final android.graphics.Bitmap.Config animatedBitmapConfig;
    public final android.graphics.Bitmap.Config bitmapConfig;

    @javax.annotation.Nullable
    public final com.facebook.imagepipeline.transformation.BitmapTransformation bitmapTransformation;

    @javax.annotation.Nullable
    public final android.graphics.ColorSpace colorSpace;

    @javax.annotation.Nullable
    public final com.facebook.imagepipeline.decoder.ImageDecoder customImageDecoder;
    public final boolean decodeAllFrames;
    public final boolean decodePreviewFrame;
    private final boolean excludeBitmapConfigFromComparison;
    public final boolean forceStaticImage;
    public final int maxDimensionPx;
    public final int minDecodeIntervalMs;
    public final boolean useEncodedImageForPreview;
    public final boolean useLastFrameForPreview;

    public ImageDecodeOptions(com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder imageDecodeOptionsBuilder) {
        this.minDecodeIntervalMs = imageDecodeOptionsBuilder.getMinDecodeIntervalMs();
        this.maxDimensionPx = imageDecodeOptionsBuilder.getMaxDimensionPx();
        this.decodePreviewFrame = imageDecodeOptionsBuilder.getDecodePreviewFrame();
        this.useLastFrameForPreview = imageDecodeOptionsBuilder.getUseLastFrameForPreview();
        this.useEncodedImageForPreview = imageDecodeOptionsBuilder.getUseEncodedImageForPreview();
        this.decodeAllFrames = imageDecodeOptionsBuilder.getDecodeAllFrames();
        this.forceStaticImage = imageDecodeOptionsBuilder.getForceStaticImage();
        this.bitmapConfig = imageDecodeOptionsBuilder.getBitmapConfig();
        this.animatedBitmapConfig = imageDecodeOptionsBuilder.getAnimatedBitmapConfig();
        this.customImageDecoder = imageDecodeOptionsBuilder.getCustomImageDecoder();
        this.bitmapTransformation = imageDecodeOptionsBuilder.getBitmapTransformation();
        this.colorSpace = imageDecodeOptionsBuilder.getColorSpace();
        this.excludeBitmapConfigFromComparison = imageDecodeOptionsBuilder.getExcludeBitmapConfigFromComparison();
    }

    public static com.facebook.imagepipeline.common.ImageDecodeOptions defaults() {
        return DEFAULTS;
    }

    public static com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder newBuilder() {
        return new com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder();
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions = (com.facebook.imagepipeline.common.ImageDecodeOptions) obj;
        if (this.minDecodeIntervalMs != imageDecodeOptions.minDecodeIntervalMs || this.maxDimensionPx != imageDecodeOptions.maxDimensionPx || this.decodePreviewFrame != imageDecodeOptions.decodePreviewFrame || this.useLastFrameForPreview != imageDecodeOptions.useLastFrameForPreview || this.useEncodedImageForPreview != imageDecodeOptions.useEncodedImageForPreview || this.decodeAllFrames != imageDecodeOptions.decodeAllFrames || this.forceStaticImage != imageDecodeOptions.forceStaticImage) {
            return false;
        }
        boolean z = this.excludeBitmapConfigFromComparison;
        if (z || this.bitmapConfig == imageDecodeOptions.bitmapConfig) {
            return (z || this.animatedBitmapConfig == imageDecodeOptions.animatedBitmapConfig) && this.customImageDecoder == imageDecodeOptions.customImageDecoder && this.bitmapTransformation == imageDecodeOptions.bitmapTransformation && this.colorSpace == imageDecodeOptions.colorSpace;
        }
        return false;
    }

    public int hashCode() {
        int iOrdinal = (((((((((((this.minDecodeIntervalMs * 31) + this.maxDimensionPx) * 31) + (this.decodePreviewFrame ? 1 : 0)) * 31) + (this.useLastFrameForPreview ? 1 : 0)) * 31) + (this.useEncodedImageForPreview ? 1 : 0)) * 31) + (this.decodeAllFrames ? 1 : 0)) * 31) + (this.forceStaticImage ? 1 : 0);
        if (!this.excludeBitmapConfigFromComparison) {
            iOrdinal = (iOrdinal * 31) + this.bitmapConfig.ordinal();
        }
        if (!this.excludeBitmapConfigFromComparison) {
            int i = iOrdinal * 31;
            android.graphics.Bitmap.Config config = this.animatedBitmapConfig;
            iOrdinal = i + (config != null ? config.ordinal() : 0);
        }
        int i2 = iOrdinal * 31;
        com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder = this.customImageDecoder;
        int iHashCode = (i2 + (imageDecoder != null ? imageDecoder.hashCode() : 0)) * 31;
        com.facebook.imagepipeline.transformation.BitmapTransformation bitmapTransformation = this.bitmapTransformation;
        int iHashCode2 = (iHashCode + (bitmapTransformation != null ? bitmapTransformation.hashCode() : 0)) * 31;
        android.graphics.ColorSpace colorSpace = this.colorSpace;
        return iHashCode2 + (colorSpace != null ? colorSpace.hashCode() : 0);
    }

    public java.lang.String toString() {
        return "ImageDecodeOptions{" + toStringHelper().toString() + com.taobao.weex.el.parse.Operators.BLOCK_END_STR;
    }

    protected com.facebook.common.internal.Objects.ToStringHelper toStringHelper() {
        return com.facebook.common.internal.Objects.toStringHelper(this).add("minDecodeIntervalMs", this.minDecodeIntervalMs).add("maxDimensionPx", this.maxDimensionPx).add("decodePreviewFrame", this.decodePreviewFrame).add("useLastFrameForPreview", this.useLastFrameForPreview).add("useEncodedImageForPreview", this.useEncodedImageForPreview).add("decodeAllFrames", this.decodeAllFrames).add("forceStaticImage", this.forceStaticImage).add("bitmapConfigName", this.bitmapConfig.name()).add("animatedBitmapConfigName", this.animatedBitmapConfig.name()).add("customImageDecoder", this.customImageDecoder).add("bitmapTransformation", this.bitmapTransformation).add("colorSpace", this.colorSpace);
    }
}
