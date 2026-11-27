package com.facebook.imagepipeline.nativecode;

/* JADX INFO: loaded from: classes.dex */
public class NativeJpegTranscoder implements com.facebook.imagepipeline.transcoder.ImageTranscoder {
    public static final java.lang.String TAG = "NativeJpegTranscoder";
    private int mMaxBitmapSize;
    private boolean mResizingEnabled;
    private boolean mUseDownsamplingRatio;

    private static native void nativeTranscodeJpeg(java.io.InputStream inputStream, java.io.OutputStream outputStream, int i, int i2, int i3) throws java.io.IOException;

    private static native void nativeTranscodeJpegWithExifOrientation(java.io.InputStream inputStream, java.io.OutputStream outputStream, int i, int i2, int i3) throws java.io.IOException;

    public NativeJpegTranscoder(boolean z, int i, boolean z2, boolean z3) {
        this.mResizingEnabled = z;
        this.mMaxBitmapSize = i;
        this.mUseDownsamplingRatio = z2;
        if (z3) {
            com.facebook.imagepipeline.nativecode.NativeJpegTranscoderSoLoader.ensure();
        }
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canResize(com.facebook.imagepipeline.image.EncodedImage encodedImage, @javax.annotation.Nullable com.facebook.imagepipeline.common.RotationOptions rotationOptions, @javax.annotation.Nullable com.facebook.imagepipeline.common.ResizeOptions resizeOptions) {
        if (rotationOptions == null) {
            rotationOptions = com.facebook.imagepipeline.common.RotationOptions.autoRotate();
        }
        return com.facebook.imagepipeline.transcoder.JpegTranscoderUtils.getSoftwareNumerator(rotationOptions, resizeOptions, encodedImage, this.mResizingEnabled) < 8;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canTranscode(com.facebook.imageformat.ImageFormat imageFormat) {
        return imageFormat == com.facebook.imageformat.DefaultImageFormats.JPEG;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public java.lang.String getIdentifier() {
        return TAG;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public com.facebook.imagepipeline.transcoder.ImageTranscodeResult transcode(com.facebook.imagepipeline.image.EncodedImage encodedImage, java.io.OutputStream outputStream, @javax.annotation.Nullable com.facebook.imagepipeline.common.RotationOptions rotationOptions, @javax.annotation.Nullable com.facebook.imagepipeline.common.ResizeOptions resizeOptions, @javax.annotation.Nullable com.facebook.imageformat.ImageFormat imageFormat, @javax.annotation.Nullable java.lang.Integer num, @javax.annotation.Nullable android.graphics.ColorSpace colorSpace) throws java.io.IOException {
        if (num == null) {
            num = 85;
        }
        if (rotationOptions == null) {
            rotationOptions = com.facebook.imagepipeline.common.RotationOptions.autoRotate();
        }
        int iDetermineSampleSize = com.facebook.imagepipeline.transcoder.DownsampleUtil.determineSampleSize(rotationOptions, resizeOptions, encodedImage, this.mMaxBitmapSize);
        try {
            int softwareNumerator = com.facebook.imagepipeline.transcoder.JpegTranscoderUtils.getSoftwareNumerator(rotationOptions, resizeOptions, encodedImage, this.mResizingEnabled);
            int iCalculateDownsampleNumerator = com.facebook.imagepipeline.transcoder.JpegTranscoderUtils.calculateDownsampleNumerator(iDetermineSampleSize);
            if (this.mUseDownsamplingRatio) {
                softwareNumerator = iCalculateDownsampleNumerator;
            }
            java.io.InputStream inputStream = encodedImage.getInputStream();
            if (com.facebook.imagepipeline.transcoder.JpegTranscoderUtils.INVERTED_EXIF_ORIENTATIONS.contains(java.lang.Integer.valueOf(encodedImage.getExifOrientation()))) {
                transcodeJpegWithExifOrientation((java.io.InputStream) com.facebook.common.internal.Preconditions.checkNotNull(inputStream, "Cannot transcode from null input stream!"), outputStream, com.facebook.imagepipeline.transcoder.JpegTranscoderUtils.getForceRotatedInvertedExifOrientation(rotationOptions, encodedImage), softwareNumerator, num.intValue());
            } else {
                transcodeJpeg((java.io.InputStream) com.facebook.common.internal.Preconditions.checkNotNull(inputStream, "Cannot transcode from null input stream!"), outputStream, com.facebook.imagepipeline.transcoder.JpegTranscoderUtils.getRotationAngle(rotationOptions, encodedImage), softwareNumerator, num.intValue());
            }
            com.facebook.common.internal.Closeables.closeQuietly(inputStream);
            return new com.facebook.imagepipeline.transcoder.ImageTranscodeResult(iDetermineSampleSize != 1 ? 0 : 1);
        } catch (java.lang.Throwable th) {
            com.facebook.common.internal.Closeables.closeQuietly((java.io.InputStream) null);
            throw th;
        }
    }

    public static void transcodeJpeg(java.io.InputStream inputStream, java.io.OutputStream outputStream, int i, int i2, int i3) throws java.io.IOException {
        com.facebook.imagepipeline.nativecode.NativeJpegTranscoderSoLoader.ensure();
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i2 >= 1));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i2 <= 16));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i3 >= 0));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i3 <= 100));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(com.facebook.imagepipeline.transcoder.JpegTranscoderUtils.isRotationAngleAllowed(i)));
        com.facebook.common.internal.Preconditions.checkArgument((i2 == 8 && i == 0) ? false : true, "no transformation requested");
        nativeTranscodeJpeg((java.io.InputStream) com.facebook.common.internal.Preconditions.checkNotNull(inputStream), (java.io.OutputStream) com.facebook.common.internal.Preconditions.checkNotNull(outputStream), i, i2, i3);
    }

    public static void transcodeJpegWithExifOrientation(java.io.InputStream inputStream, java.io.OutputStream outputStream, int i, int i2, int i3) throws java.io.IOException {
        com.facebook.imagepipeline.nativecode.NativeJpegTranscoderSoLoader.ensure();
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i2 >= 1));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i2 <= 16));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i3 >= 0));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i3 <= 100));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(com.facebook.imagepipeline.transcoder.JpegTranscoderUtils.isExifOrientationAllowed(i)));
        com.facebook.common.internal.Preconditions.checkArgument((i2 == 8 && i == 1) ? false : true, "no transformation requested");
        nativeTranscodeJpegWithExifOrientation((java.io.InputStream) com.facebook.common.internal.Preconditions.checkNotNull(inputStream), (java.io.OutputStream) com.facebook.common.internal.Preconditions.checkNotNull(outputStream), i, i2, i3);
    }
}
