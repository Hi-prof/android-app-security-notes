package com.facebook.imagepipeline.animated.factory;

/* JADX INFO: loaded from: classes.dex */
public interface AnimatedImageFactory {
    com.facebook.imagepipeline.image.CloseableImage decodeGif(com.facebook.imagepipeline.image.EncodedImage encodedImage, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions, android.graphics.Bitmap.Config config);

    com.facebook.imagepipeline.image.CloseableImage decodeWebP(com.facebook.imagepipeline.image.EncodedImage encodedImage, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions, android.graphics.Bitmap.Config config);
}
