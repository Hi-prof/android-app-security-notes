package com.facebook.imagepipeline.animated.factory;

/* JADX INFO: loaded from: classes.dex */
public interface AnimatedImageDecoder {
    com.facebook.imagepipeline.animated.base.AnimatedImage decodeFromByteBuffer(java.nio.ByteBuffer byteBuffer, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions);

    com.facebook.imagepipeline.animated.base.AnimatedImage decodeFromNativeMemory(long j, int i, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions);
}
