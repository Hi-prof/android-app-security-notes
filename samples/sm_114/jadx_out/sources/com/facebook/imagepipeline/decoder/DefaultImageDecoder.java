package com.facebook.imagepipeline.decoder;

/* JADX INFO: loaded from: classes.dex */
public class DefaultImageDecoder implements com.facebook.imagepipeline.decoder.ImageDecoder {

    @javax.annotation.Nullable
    private final com.facebook.imagepipeline.decoder.ImageDecoder mAnimatedGifDecoder;

    @javax.annotation.Nullable
    private final com.facebook.imagepipeline.decoder.ImageDecoder mAnimatedWebPDecoder;

    @javax.annotation.Nullable
    private final java.util.Map<com.facebook.imageformat.ImageFormat, com.facebook.imagepipeline.decoder.ImageDecoder> mCustomDecoders;
    private final com.facebook.imagepipeline.decoder.ImageDecoder mDefaultDecoder;
    private final com.facebook.common.internal.Supplier<java.lang.Boolean> mEnableEncodedImageColorSpaceUsage;
    private final com.facebook.imagepipeline.platform.PlatformDecoder mPlatformDecoder;

    public DefaultImageDecoder(@javax.annotation.Nullable com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder, @javax.annotation.Nullable com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder2, com.facebook.imagepipeline.platform.PlatformDecoder platformDecoder) {
        this(imageDecoder, imageDecoder2, platformDecoder, null);
    }

    public DefaultImageDecoder(@javax.annotation.Nullable com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder, @javax.annotation.Nullable com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder2, com.facebook.imagepipeline.platform.PlatformDecoder platformDecoder, @javax.annotation.Nullable java.util.Map<com.facebook.imageformat.ImageFormat, com.facebook.imagepipeline.decoder.ImageDecoder> map) {
        this.mDefaultDecoder = new com.facebook.imagepipeline.decoder.ImageDecoder() { // from class: com.facebook.imagepipeline.decoder.DefaultImageDecoder.1
            @Override // com.facebook.imagepipeline.decoder.ImageDecoder
            @javax.annotation.Nullable
            public com.facebook.imagepipeline.image.CloseableImage decode(com.facebook.imagepipeline.image.EncodedImage encodedImage, int i, com.facebook.imagepipeline.image.QualityInfo qualityInfo, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
                com.facebook.imageformat.ImageFormat imageFormat = encodedImage.getImageFormat();
                android.graphics.ColorSpace colorSpace = (((java.lang.Boolean) com.facebook.imagepipeline.decoder.DefaultImageDecoder.this.mEnableEncodedImageColorSpaceUsage.get()).booleanValue() && imageDecodeOptions.colorSpace == null) ? encodedImage.getColorSpace() : imageDecodeOptions.colorSpace;
                android.graphics.ColorSpace colorSpace2 = colorSpace;
                if (imageFormat == com.facebook.imageformat.DefaultImageFormats.JPEG) {
                    return com.facebook.imagepipeline.decoder.DefaultImageDecoder.this.decodeJpeg(encodedImage, i, qualityInfo, imageDecodeOptions, colorSpace2);
                }
                if (imageFormat == com.facebook.imageformat.DefaultImageFormats.GIF) {
                    return com.facebook.imagepipeline.decoder.DefaultImageDecoder.this.decodeGif(encodedImage, i, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat == com.facebook.imageformat.DefaultImageFormats.WEBP_ANIMATED) {
                    return com.facebook.imagepipeline.decoder.DefaultImageDecoder.this.decodeAnimatedWebp(encodedImage, i, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat == com.facebook.imageformat.ImageFormat.UNKNOWN) {
                    throw new com.facebook.imagepipeline.decoder.DecodeException("unknown image format", encodedImage);
                }
                return com.facebook.imagepipeline.decoder.DefaultImageDecoder.this.decodeStaticImage(encodedImage, imageDecodeOptions);
            }
        };
        this.mAnimatedGifDecoder = imageDecoder;
        this.mAnimatedWebPDecoder = imageDecoder2;
        this.mPlatformDecoder = platformDecoder;
        this.mCustomDecoders = map;
        this.mEnableEncodedImageColorSpaceUsage = com.facebook.common.internal.Suppliers.BOOLEAN_FALSE;
    }

    public DefaultImageDecoder(@javax.annotation.Nullable com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder, @javax.annotation.Nullable com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder2, com.facebook.imagepipeline.platform.PlatformDecoder platformDecoder, @javax.annotation.Nullable java.util.Map<com.facebook.imageformat.ImageFormat, com.facebook.imagepipeline.decoder.ImageDecoder> map, com.facebook.common.internal.Supplier<java.lang.Boolean> supplier) {
        this.mDefaultDecoder = new com.facebook.imagepipeline.decoder.ImageDecoder() { // from class: com.facebook.imagepipeline.decoder.DefaultImageDecoder.1
            @Override // com.facebook.imagepipeline.decoder.ImageDecoder
            @javax.annotation.Nullable
            public com.facebook.imagepipeline.image.CloseableImage decode(com.facebook.imagepipeline.image.EncodedImage encodedImage, int i, com.facebook.imagepipeline.image.QualityInfo qualityInfo, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
                com.facebook.imageformat.ImageFormat imageFormat = encodedImage.getImageFormat();
                android.graphics.ColorSpace colorSpace = (((java.lang.Boolean) com.facebook.imagepipeline.decoder.DefaultImageDecoder.this.mEnableEncodedImageColorSpaceUsage.get()).booleanValue() && imageDecodeOptions.colorSpace == null) ? encodedImage.getColorSpace() : imageDecodeOptions.colorSpace;
                android.graphics.ColorSpace colorSpace2 = colorSpace;
                if (imageFormat == com.facebook.imageformat.DefaultImageFormats.JPEG) {
                    return com.facebook.imagepipeline.decoder.DefaultImageDecoder.this.decodeJpeg(encodedImage, i, qualityInfo, imageDecodeOptions, colorSpace2);
                }
                if (imageFormat == com.facebook.imageformat.DefaultImageFormats.GIF) {
                    return com.facebook.imagepipeline.decoder.DefaultImageDecoder.this.decodeGif(encodedImage, i, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat == com.facebook.imageformat.DefaultImageFormats.WEBP_ANIMATED) {
                    return com.facebook.imagepipeline.decoder.DefaultImageDecoder.this.decodeAnimatedWebp(encodedImage, i, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat == com.facebook.imageformat.ImageFormat.UNKNOWN) {
                    throw new com.facebook.imagepipeline.decoder.DecodeException("unknown image format", encodedImage);
                }
                return com.facebook.imagepipeline.decoder.DefaultImageDecoder.this.decodeStaticImage(encodedImage, imageDecodeOptions);
            }
        };
        this.mAnimatedGifDecoder = imageDecoder;
        this.mAnimatedWebPDecoder = imageDecoder2;
        this.mPlatformDecoder = platformDecoder;
        this.mCustomDecoders = map;
        this.mEnableEncodedImageColorSpaceUsage = supplier;
    }

    @Override // com.facebook.imagepipeline.decoder.ImageDecoder
    @javax.annotation.Nullable
    public com.facebook.imagepipeline.image.CloseableImage decode(com.facebook.imagepipeline.image.EncodedImage encodedImage, int i, com.facebook.imagepipeline.image.QualityInfo qualityInfo, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        java.io.InputStream inputStream;
        com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder;
        if (imageDecodeOptions.customImageDecoder != null) {
            return imageDecodeOptions.customImageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        com.facebook.imageformat.ImageFormat imageFormat = encodedImage.getImageFormat();
        if ((imageFormat == null || imageFormat == com.facebook.imageformat.ImageFormat.UNKNOWN) && (inputStream = encodedImage.getInputStream()) != null) {
            imageFormat = com.facebook.imageformat.ImageFormatChecker.getImageFormat_WrapIOException(inputStream);
            encodedImage.setImageFormat(imageFormat);
        }
        java.util.Map<com.facebook.imageformat.ImageFormat, com.facebook.imagepipeline.decoder.ImageDecoder> map = this.mCustomDecoders;
        if (map != null && (imageDecoder = map.get(imageFormat)) != null) {
            return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        return this.mDefaultDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.image.CloseableImage decodeGif(com.facebook.imagepipeline.image.EncodedImage encodedImage, int i, com.facebook.imagepipeline.image.QualityInfo qualityInfo, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder;
        if (encodedImage.getWidth() == -1 || encodedImage.getHeight() == -1) {
            throw new com.facebook.imagepipeline.decoder.DecodeException("image width or height is incorrect", encodedImage);
        }
        if (!imageDecodeOptions.forceStaticImage && (imageDecoder = this.mAnimatedGifDecoder) != null) {
            return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        return decodeStaticImage(encodedImage, imageDecodeOptions);
    }

    public com.facebook.imagepipeline.image.CloseableStaticBitmap decodeStaticImage(com.facebook.imagepipeline.image.EncodedImage encodedImage, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceDecodeFromEncodedImageWithColorSpace = this.mPlatformDecoder.decodeFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, null, imageDecodeOptions.colorSpace);
        try {
            boolean zMaybeApplyTransformation = com.facebook.imagepipeline.transformation.TransformationUtils.maybeApplyTransformation(imageDecodeOptions.bitmapTransformation, closeableReferenceDecodeFromEncodedImageWithColorSpace);
            com.facebook.common.internal.Preconditions.checkNotNull(closeableReferenceDecodeFromEncodedImageWithColorSpace);
            com.facebook.imagepipeline.image.CloseableStaticBitmap closeableStaticBitmapOf = com.facebook.imagepipeline.image.CloseableStaticBitmap.CC.of(closeableReferenceDecodeFromEncodedImageWithColorSpace, com.facebook.imagepipeline.image.ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
            closeableStaticBitmapOf.putExtra("is_rounded", java.lang.Boolean.valueOf(zMaybeApplyTransformation && (imageDecodeOptions.bitmapTransformation instanceof com.facebook.imagepipeline.transformation.CircularTransformation)));
            return closeableStaticBitmapOf;
        } finally {
            com.facebook.common.references.CloseableReference.closeSafely(closeableReferenceDecodeFromEncodedImageWithColorSpace);
        }
    }

    public com.facebook.imagepipeline.image.CloseableStaticBitmap decodeJpeg(com.facebook.imagepipeline.image.EncodedImage encodedImage, int i, com.facebook.imagepipeline.image.QualityInfo qualityInfo, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions, @javax.annotation.Nullable android.graphics.ColorSpace colorSpace) {
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace = this.mPlatformDecoder.decodeJPEGFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, null, i, colorSpace);
        try {
            boolean zMaybeApplyTransformation = com.facebook.imagepipeline.transformation.TransformationUtils.maybeApplyTransformation(imageDecodeOptions.bitmapTransformation, closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace);
            com.facebook.common.internal.Preconditions.checkNotNull(closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace);
            com.facebook.imagepipeline.image.CloseableStaticBitmap closeableStaticBitmapOf = com.facebook.imagepipeline.image.CloseableStaticBitmap.CC.of(closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace, qualityInfo, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
            closeableStaticBitmapOf.putExtra("is_rounded", java.lang.Boolean.valueOf(zMaybeApplyTransformation && (imageDecodeOptions.bitmapTransformation instanceof com.facebook.imagepipeline.transformation.CircularTransformation)));
            return closeableStaticBitmapOf;
        } finally {
            com.facebook.common.references.CloseableReference.closeSafely(closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace);
        }
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.image.CloseableImage decodeAnimatedWebp(com.facebook.imagepipeline.image.EncodedImage encodedImage, int i, com.facebook.imagepipeline.image.QualityInfo qualityInfo, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder;
        if (!imageDecodeOptions.forceStaticImage && (imageDecoder = this.mAnimatedWebPDecoder) != null) {
            return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        return decodeStaticImage(encodedImage, imageDecodeOptions);
    }
}
