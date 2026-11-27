package com.facebook.imagepipeline.nativecode;

/* JADX INFO: loaded from: classes.dex */
public class NativeJpegTranscoderFactory implements com.facebook.imagepipeline.transcoder.ImageTranscoderFactory {
    private final boolean mEnsureTranscoderLibraryLoaded;
    private final int mMaxBitmapSize;
    private final boolean mUseDownSamplingRatio;

    public NativeJpegTranscoderFactory(int i, boolean z, boolean z2) {
        this.mMaxBitmapSize = i;
        this.mUseDownSamplingRatio = z;
        this.mEnsureTranscoderLibraryLoaded = z2;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoderFactory
    @javax.annotation.Nullable
    public com.facebook.imagepipeline.transcoder.ImageTranscoder createImageTranscoder(com.facebook.imageformat.ImageFormat imageFormat, boolean z) {
        if (imageFormat != com.facebook.imageformat.DefaultImageFormats.JPEG) {
            return null;
        }
        return new com.facebook.imagepipeline.nativecode.NativeJpegTranscoder(z, this.mMaxBitmapSize, this.mUseDownSamplingRatio, this.mEnsureTranscoderLibraryLoaded);
    }
}
