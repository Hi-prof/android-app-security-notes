package com.facebook.animated.webp;

/* JADX INFO: loaded from: classes.dex */
public class WebPImage implements com.facebook.imagepipeline.animated.base.AnimatedImage, com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder {

    @javax.annotation.Nullable
    private android.graphics.Bitmap.Config mDecodeBitmapConfig = null;
    private long mNativeContext;

    private static native com.facebook.animated.webp.WebPImage nativeCreateFromDirectByteBuffer(java.nio.ByteBuffer byteBuffer);

    private static native com.facebook.animated.webp.WebPImage nativeCreateFromNativeMemory(long j, int i);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native com.facebook.animated.webp.WebPFrame nativeGetFrame(int i);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public boolean doesRenderSupportScaling() {
        return true;
    }

    public WebPImage() {
    }

    WebPImage(long j) {
        this.mNativeContext = j;
    }

    protected void finalize() {
        nativeFinalize();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public void dispose() {
        nativeDispose();
    }

    public static com.facebook.animated.webp.WebPImage createFromByteArray(byte[] bArr, @javax.annotation.Nullable com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader.ensure();
        com.facebook.common.internal.Preconditions.checkNotNull(bArr);
        java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(bArr.length);
        byteBufferAllocateDirect.put(bArr);
        byteBufferAllocateDirect.rewind();
        com.facebook.animated.webp.WebPImage webPImageNativeCreateFromDirectByteBuffer = nativeCreateFromDirectByteBuffer(byteBufferAllocateDirect);
        if (imageDecodeOptions != null) {
            webPImageNativeCreateFromDirectByteBuffer.mDecodeBitmapConfig = imageDecodeOptions.animatedBitmapConfig;
        }
        return webPImageNativeCreateFromDirectByteBuffer;
    }

    public static com.facebook.animated.webp.WebPImage createFromByteBuffer(java.nio.ByteBuffer byteBuffer, @javax.annotation.Nullable com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader.ensure();
        byteBuffer.rewind();
        com.facebook.animated.webp.WebPImage webPImageNativeCreateFromDirectByteBuffer = nativeCreateFromDirectByteBuffer(byteBuffer);
        if (imageDecodeOptions != null) {
            webPImageNativeCreateFromDirectByteBuffer.mDecodeBitmapConfig = imageDecodeOptions.animatedBitmapConfig;
        }
        return webPImageNativeCreateFromDirectByteBuffer;
    }

    public static com.facebook.animated.webp.WebPImage createFromNativeMemory(long j, int i, @javax.annotation.Nullable com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader.ensure();
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(j != 0));
        com.facebook.animated.webp.WebPImage webPImageNativeCreateFromNativeMemory = nativeCreateFromNativeMemory(j, i);
        if (imageDecodeOptions != null) {
            webPImageNativeCreateFromNativeMemory.mDecodeBitmapConfig = imageDecodeOptions.animatedBitmapConfig;
        }
        return webPImageNativeCreateFromNativeMemory;
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder
    public com.facebook.imagepipeline.animated.base.AnimatedImage decodeFromNativeMemory(long j, int i, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        return createFromNativeMemory(j, i, imageDecodeOptions);
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder
    public com.facebook.imagepipeline.animated.base.AnimatedImage decodeFromByteBuffer(java.nio.ByteBuffer byteBuffer, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        return createFromByteBuffer(byteBuffer, imageDecodeOptions);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getWidth() {
        return nativeGetWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getFrameCount() {
        return nativeGetFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getDuration() {
        return nativeGetDuration();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int[] getFrameDurations() {
        return nativeGetFrameDurations();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getLoopCount() {
        return nativeGetLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public com.facebook.animated.webp.WebPFrame getFrame(int i) {
        return nativeGetFrame(i);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo getFrameInfo(int i) {
        com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.BlendOperation blendOperation;
        com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod disposalMethod;
        com.facebook.animated.webp.WebPFrame frame = getFrame(i);
        try {
            int xOffset = frame.getXOffset();
            int yOffset = frame.getYOffset();
            int width = frame.getWidth();
            int height = frame.getHeight();
            if (frame.isBlendWithPreviousFrame()) {
                blendOperation = com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.BlendOperation.BLEND_WITH_PREVIOUS;
            } else {
                blendOperation = com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND;
            }
            com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.BlendOperation blendOperation2 = blendOperation;
            if (frame.shouldDisposeToBackgroundColor()) {
                disposalMethod = com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND;
            } else {
                disposalMethod = com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
            }
            return new com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo(i, xOffset, yOffset, width, height, blendOperation2, disposalMethod);
        } finally {
            frame.dispose();
        }
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    @javax.annotation.Nullable
    public android.graphics.Bitmap.Config getAnimatedBitmapConfig() {
        return this.mDecodeBitmapConfig;
    }
}
