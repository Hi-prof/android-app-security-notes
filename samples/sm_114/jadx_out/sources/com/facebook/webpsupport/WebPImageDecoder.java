package com.facebook.webpsupport;

/* JADX INFO: loaded from: classes.dex */
public class WebPImageDecoder implements com.facebook.imagepipeline.decoder.ImageDecoder {
    @Override // com.facebook.imagepipeline.decoder.ImageDecoder
    @javax.annotation.Nullable
    public com.facebook.imagepipeline.image.CloseableImage decode(com.facebook.imagepipeline.image.EncodedImage encodedImage, int i, com.facebook.imagepipeline.image.QualityInfo qualityInfo, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
        com.facebook.common.internal.Preconditions.checkNotNull(byteBufferRef);
        try {
            java.nio.ByteBuffer byteBuffer = byteBufferRef.get().getByteBuffer();
            if (byteBuffer != null) {
                return decodeByteBuffer(byteBuffer, encodedImage, i, qualityInfo, imageDecodeOptions);
            }
            return decodeInputStream(encodedImage, i, qualityInfo, imageDecodeOptions);
        } finally {
            com.facebook.common.references.CloseableReference.closeSafely(byteBufferRef);
        }
    }

    @javax.annotation.Nullable
    private static com.facebook.imagepipeline.image.CloseableImage decodeByteBuffer(java.nio.ByteBuffer byteBuffer, com.facebook.imagepipeline.image.EncodedImage encodedImage, int i, com.facebook.imagepipeline.image.QualityInfo qualityInfo, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        return bitmapToCloseableImage(com.facebook.webpsupport.WebpBitmapFactoryImpl.hookDecodeByteArray(byteBuffer.array(), 0, i), encodedImage, qualityInfo);
    }

    @javax.annotation.Nullable
    private static com.facebook.imagepipeline.image.CloseableImage decodeInputStream(com.facebook.imagepipeline.image.EncodedImage encodedImage, int i, com.facebook.imagepipeline.image.QualityInfo qualityInfo, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        try {
            java.io.InputStream inputStreamOrThrow = encodedImage.getInputStreamOrThrow();
            try {
                com.facebook.imagepipeline.image.CloseableImage closeableImageBitmapToCloseableImage = bitmapToCloseableImage(com.facebook.webpsupport.WebpBitmapFactoryImpl.hookDecodeStream(inputStreamOrThrow, null, null), encodedImage, qualityInfo);
                if (inputStreamOrThrow != null) {
                    inputStreamOrThrow.close();
                }
                return closeableImageBitmapToCloseableImage;
            } catch (java.lang.Throwable th) {
                if (inputStreamOrThrow != null) {
                    try {
                        inputStreamOrThrow.close();
                    } catch (java.lang.Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException("Error while decoding WebP", e);
        }
    }

    @javax.annotation.Nullable
    private static com.facebook.imagepipeline.image.CloseableImage bitmapToCloseableImage(@javax.annotation.Nullable android.graphics.Bitmap bitmap, com.facebook.imagepipeline.image.EncodedImage encodedImage, com.facebook.imagepipeline.image.QualityInfo qualityInfo) {
        if (bitmap == null) {
            return null;
        }
        return com.facebook.imagepipeline.image.CloseableStaticBitmap.CC.of(com.facebook.common.references.CloseableReference.of(bitmap, com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser.getInstance()), qualityInfo, encodedImage.getRotationAngle());
    }
}
