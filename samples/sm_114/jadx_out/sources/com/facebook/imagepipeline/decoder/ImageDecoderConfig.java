package com.facebook.imagepipeline.decoder;

/* JADX INFO: loaded from: classes.dex */
public class ImageDecoderConfig {

    @javax.annotation.Nullable
    private final java.util.Map<com.facebook.imageformat.ImageFormat, com.facebook.imagepipeline.decoder.ImageDecoder> mCustomImageDecoders;

    @javax.annotation.Nullable
    private final java.util.List<com.facebook.imageformat.ImageFormat.FormatChecker> mCustomImageFormats;

    private ImageDecoderConfig(com.facebook.imagepipeline.decoder.ImageDecoderConfig.Builder builder) {
        this.mCustomImageDecoders = builder.mCustomImageDecoders;
        this.mCustomImageFormats = builder.mCustomImageFormats;
    }

    @javax.annotation.Nullable
    public java.util.Map<com.facebook.imageformat.ImageFormat, com.facebook.imagepipeline.decoder.ImageDecoder> getCustomImageDecoders() {
        return this.mCustomImageDecoders;
    }

    @javax.annotation.Nullable
    public java.util.List<com.facebook.imageformat.ImageFormat.FormatChecker> getCustomImageFormats() {
        return this.mCustomImageFormats;
    }

    public static com.facebook.imagepipeline.decoder.ImageDecoderConfig.Builder newBuilder() {
        return new com.facebook.imagepipeline.decoder.ImageDecoderConfig.Builder();
    }

    public static final class Builder {

        @javax.annotation.Nullable
        private java.util.Map<com.facebook.imageformat.ImageFormat, com.facebook.imagepipeline.decoder.ImageDecoder> mCustomImageDecoders;

        @javax.annotation.Nullable
        private java.util.List<com.facebook.imageformat.ImageFormat.FormatChecker> mCustomImageFormats;

        public com.facebook.imagepipeline.decoder.ImageDecoderConfig.Builder addDecodingCapability(com.facebook.imageformat.ImageFormat imageFormat, com.facebook.imageformat.ImageFormat.FormatChecker formatChecker, @javax.annotation.Nullable com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder) {
            if (this.mCustomImageFormats == null) {
                this.mCustomImageFormats = new java.util.ArrayList();
            }
            this.mCustomImageFormats.add(formatChecker);
            if (imageDecoder != null) {
                overrideDecoder(imageFormat, imageDecoder);
            }
            return this;
        }

        public com.facebook.imagepipeline.decoder.ImageDecoderConfig.Builder overrideDecoder(com.facebook.imageformat.ImageFormat imageFormat, com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder) {
            if (this.mCustomImageDecoders == null) {
                this.mCustomImageDecoders = new java.util.HashMap();
            }
            this.mCustomImageDecoders.put(imageFormat, imageDecoder);
            return this;
        }

        public com.facebook.imagepipeline.decoder.ImageDecoderConfig build() {
            return new com.facebook.imagepipeline.decoder.ImageDecoderConfig(this);
        }
    }
}
