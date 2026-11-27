package com.facebook.imagepipeline.transcoder;

/* JADX INFO: compiled from: SimpleImageTranscoder.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007JO\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017J$\u0010\u0018\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\"\u0010\u001f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001cX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/facebook/imagepipeline/transcoder/SimpleImageTranscoder;", "Lcom/facebook/imagepipeline/transcoder/ImageTranscoder;", "resizingEnabled", "", "maxBitmapSize", "", "<init>", "(ZI)V", "transcode", "Lcom/facebook/imagepipeline/transcoder/ImageTranscodeResult;", "encodedImage", "Lcom/facebook/imagepipeline/image/EncodedImage;", "outputStream", "Ljava/io/OutputStream;", "rotationOptions", "Lcom/facebook/imagepipeline/common/RotationOptions;", "resizeOptions", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "outputFormat", "Lcom/facebook/imageformat/ImageFormat;", com.taobao.weex.common.Constants.Name.QUALITY, "colorSpace", "Landroid/graphics/ColorSpace;", "(Lcom/facebook/imagepipeline/image/EncodedImage;Ljava/io/OutputStream;Lcom/facebook/imagepipeline/common/RotationOptions;Lcom/facebook/imagepipeline/common/ResizeOptions;Lcom/facebook/imageformat/ImageFormat;Ljava/lang/Integer;Landroid/graphics/ColorSpace;)Lcom/facebook/imagepipeline/transcoder/ImageTranscodeResult;", "canResize", "canTranscode", "imageFormat", com.taobao.weex.ui.view.gesture.WXGestureType.GestureInfo.POINTER_ID, "", "getIdentifier", "()Ljava/lang/String;", "getSampleSize", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SimpleImageTranscoder implements com.facebook.imagepipeline.transcoder.ImageTranscoder {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.facebook.imagepipeline.transcoder.SimpleImageTranscoder.Companion INSTANCE = new com.facebook.imagepipeline.transcoder.SimpleImageTranscoder.Companion(null);
    private static final java.lang.String TAG = "SimpleImageTranscoder";
    private final java.lang.String identifier = TAG;
    private final int maxBitmapSize;
    private final boolean resizingEnabled;

    public SimpleImageTranscoder(boolean z, int i) {
        this.resizingEnabled = z;
        this.maxBitmapSize = i;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public com.facebook.imagepipeline.transcoder.ImageTranscodeResult transcode(com.facebook.imagepipeline.image.EncodedImage encodedImage, java.io.OutputStream outputStream, com.facebook.imagepipeline.common.RotationOptions rotationOptions, com.facebook.imagepipeline.common.ResizeOptions resizeOptions, com.facebook.imageformat.ImageFormat outputFormat, java.lang.Integer quality, android.graphics.ColorSpace colorSpace) throws java.lang.Throwable {
        android.graphics.Bitmap bitmapCreateBitmap;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        java.lang.Integer num = quality == null ? 85 : quality;
        com.facebook.imagepipeline.common.RotationOptions rotationOptionsAutoRotate = rotationOptions == null ? com.facebook.imagepipeline.common.RotationOptions.INSTANCE.autoRotate() : rotationOptions;
        int sampleSize = getSampleSize(encodedImage, rotationOptionsAutoRotate, resizeOptions);
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inSampleSize = sampleSize;
        if (colorSpace != null && android.os.Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = colorSpace;
        }
        try {
            android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(encodedImage.getInputStream(), null, options);
            if (bitmapDecodeStream == null) {
                com.facebook.common.logging.FLog.e(TAG, "Couldn't decode the EncodedImage InputStream ! ");
                return new com.facebook.imagepipeline.transcoder.ImageTranscodeResult(2);
            }
            android.graphics.Matrix transformationMatrix = com.facebook.imagepipeline.transcoder.JpegTranscoderUtils.getTransformationMatrix(encodedImage, rotationOptionsAutoRotate);
            if (transformationMatrix != null) {
                try {
                    bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmapDecodeStream, 0, 0, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), transformationMatrix, false);
                } catch (java.lang.OutOfMemoryError e) {
                    e = e;
                    bitmapCreateBitmap = bitmapDecodeStream;
                    com.facebook.common.logging.FLog.e(TAG, "Out-Of-Memory during transcode", e);
                    com.facebook.imagepipeline.transcoder.ImageTranscodeResult imageTranscodeResult = new com.facebook.imagepipeline.transcoder.ImageTranscodeResult(2);
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    return imageTranscodeResult;
                } catch (java.lang.Throwable th) {
                    th = th;
                    bitmapCreateBitmap = bitmapDecodeStream;
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    throw th;
                }
            } else {
                bitmapCreateBitmap = bitmapDecodeStream;
            }
            try {
                try {
                    bitmapCreateBitmap.compress(INSTANCE.getOutputFormat(outputFormat), num.intValue(), outputStream);
                    com.facebook.imagepipeline.transcoder.ImageTranscodeResult imageTranscodeResult2 = new com.facebook.imagepipeline.transcoder.ImageTranscodeResult(sampleSize > 1 ? 0 : 1);
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    return imageTranscodeResult2;
                } catch (java.lang.OutOfMemoryError e2) {
                    e = e2;
                    com.facebook.common.logging.FLog.e(TAG, "Out-Of-Memory during transcode", e);
                    com.facebook.imagepipeline.transcoder.ImageTranscodeResult imageTranscodeResult3 = new com.facebook.imagepipeline.transcoder.ImageTranscodeResult(2);
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    return imageTranscodeResult3;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                bitmapCreateBitmap.recycle();
                bitmapDecodeStream.recycle();
                throw th;
            }
        } catch (java.lang.OutOfMemoryError e3) {
            com.facebook.common.logging.FLog.e(TAG, "Out-Of-Memory during transcode", e3);
            return new com.facebook.imagepipeline.transcoder.ImageTranscodeResult(2);
        }
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canResize(com.facebook.imagepipeline.image.EncodedImage encodedImage, com.facebook.imagepipeline.common.RotationOptions rotationOptions, com.facebook.imagepipeline.common.ResizeOptions resizeOptions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        if (rotationOptions == null) {
            rotationOptions = com.facebook.imagepipeline.common.RotationOptions.INSTANCE.autoRotate();
        }
        return this.resizingEnabled && com.facebook.imagepipeline.transcoder.DownsampleUtil.determineSampleSize(rotationOptions, resizeOptions, encodedImage, this.maxBitmapSize) > 1;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canTranscode(com.facebook.imageformat.ImageFormat imageFormat) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageFormat, "imageFormat");
        return imageFormat == com.facebook.imageformat.DefaultImageFormats.HEIF || imageFormat == com.facebook.imageformat.DefaultImageFormats.JPEG;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public java.lang.String getIdentifier() {
        return this.identifier;
    }

    private final int getSampleSize(com.facebook.imagepipeline.image.EncodedImage encodedImage, com.facebook.imagepipeline.common.RotationOptions rotationOptions, com.facebook.imagepipeline.common.ResizeOptions resizeOptions) {
        if (this.resizingEnabled) {
            return com.facebook.imagepipeline.transcoder.DownsampleUtil.determineSampleSize(rotationOptions, resizeOptions, encodedImage, this.maxBitmapSize);
        }
        return 1;
    }

    /* JADX INFO: compiled from: SimpleImageTranscoder.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/imagepipeline/transcoder/SimpleImageTranscoder$Companion;", "", "<init>", "()V", "TAG", "", "getOutputFormat", "Landroid/graphics/Bitmap$CompressFormat;", "format", "Lcom/facebook/imageformat/ImageFormat;", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final android.graphics.Bitmap.CompressFormat getOutputFormat(com.facebook.imageformat.ImageFormat format) {
            if (format == null) {
                return android.graphics.Bitmap.CompressFormat.JPEG;
            }
            if (format == com.facebook.imageformat.DefaultImageFormats.JPEG) {
                return android.graphics.Bitmap.CompressFormat.JPEG;
            }
            if (format == com.facebook.imageformat.DefaultImageFormats.PNG) {
                return android.graphics.Bitmap.CompressFormat.PNG;
            }
            if (com.facebook.imageformat.DefaultImageFormats.isStaticWebpFormat(format)) {
                return android.graphics.Bitmap.CompressFormat.WEBP;
            }
            return android.graphics.Bitmap.CompressFormat.JPEG;
        }
    }
}
