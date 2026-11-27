package com.facebook.imagepipeline.transcoder;

/* JADX INFO: loaded from: classes.dex */
public class SimpleImageTranscoderFactory implements com.facebook.imagepipeline.transcoder.ImageTranscoderFactory {
    private final int mMaxBitmapSize;

    public SimpleImageTranscoderFactory(int i) {
        this.mMaxBitmapSize = i;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoderFactory
    public com.facebook.imagepipeline.transcoder.ImageTranscoder createImageTranscoder(com.facebook.imageformat.ImageFormat imageFormat, boolean z) {
        return new com.facebook.imagepipeline.transcoder.SimpleImageTranscoder(z, this.mMaxBitmapSize);
    }
}
