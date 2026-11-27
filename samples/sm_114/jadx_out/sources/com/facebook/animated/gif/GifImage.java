package com.facebook.animated.gif;

/* JADX INFO: loaded from: classes.dex */
public class GifImage implements com.facebook.imagepipeline.animated.base.AnimatedImage, com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder {
    private static final int LOOP_COUNT_FOREVER = 0;
    private static final int LOOP_COUNT_MISSING = -1;
    private static volatile boolean sInitialized;

    @javax.annotation.Nullable
    private android.graphics.Bitmap.Config mDecodeBitmapConfig = null;
    private long mNativeContext;

    private static native com.facebook.animated.gif.GifImage nativeCreateFromDirectByteBuffer(java.nio.ByteBuffer byteBuffer, int i, boolean z);

    private static native com.facebook.animated.gif.GifImage nativeCreateFromFileDescriptor(int i, int i2, boolean z);

    private static native com.facebook.animated.gif.GifImage nativeCreateFromNativeMemory(long j, int i, int i2, boolean z);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native com.facebook.animated.gif.GifFrame nativeGetFrame(int i);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    private native boolean nativeIsAnimated();

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public boolean doesRenderSupportScaling() {
        return false;
    }

    private static synchronized void ensure() {
        if (!sInitialized) {
            sInitialized = true;
            com.facebook.soloader.nativeloader.NativeLoader.loadLibrary("gifimage");
        }
    }

    public static com.facebook.animated.gif.GifImage createFromByteArray(byte[] bArr) {
        com.facebook.common.internal.Preconditions.checkNotNull(bArr);
        java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(bArr.length);
        byteBufferAllocateDirect.put(bArr);
        byteBufferAllocateDirect.rewind();
        return createFromByteBuffer(byteBufferAllocateDirect, com.facebook.imagepipeline.common.ImageDecodeOptions.defaults());
    }

    public static com.facebook.animated.gif.GifImage createFromByteBuffer(java.nio.ByteBuffer byteBuffer) {
        return createFromByteBuffer(byteBuffer, com.facebook.imagepipeline.common.ImageDecodeOptions.defaults());
    }

    public static com.facebook.animated.gif.GifImage createFromByteBuffer(java.nio.ByteBuffer byteBuffer, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        ensure();
        byteBuffer.rewind();
        com.facebook.animated.gif.GifImage gifImageNativeCreateFromDirectByteBuffer = nativeCreateFromDirectByteBuffer(byteBuffer, imageDecodeOptions.maxDimensionPx, imageDecodeOptions.forceStaticImage);
        gifImageNativeCreateFromDirectByteBuffer.mDecodeBitmapConfig = imageDecodeOptions.animatedBitmapConfig;
        return gifImageNativeCreateFromDirectByteBuffer;
    }

    public static com.facebook.animated.gif.GifImage createFromNativeMemory(long j, int i, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        ensure();
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(j != 0));
        com.facebook.animated.gif.GifImage gifImageNativeCreateFromNativeMemory = nativeCreateFromNativeMemory(j, i, imageDecodeOptions.maxDimensionPx, imageDecodeOptions.forceStaticImage);
        gifImageNativeCreateFromNativeMemory.mDecodeBitmapConfig = imageDecodeOptions.animatedBitmapConfig;
        return gifImageNativeCreateFromNativeMemory;
    }

    public static com.facebook.animated.gif.GifImage createFromFileDescriptor(int i, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        ensure();
        return nativeCreateFromFileDescriptor(i, imageDecodeOptions.maxDimensionPx, imageDecodeOptions.forceStaticImage);
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder
    public com.facebook.imagepipeline.animated.base.AnimatedImage decodeFromNativeMemory(long j, int i, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        return createFromNativeMemory(j, i, imageDecodeOptions);
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder
    public com.facebook.imagepipeline.animated.base.AnimatedImage decodeFromByteBuffer(java.nio.ByteBuffer byteBuffer, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        return createFromByteBuffer(byteBuffer, imageDecodeOptions);
    }

    public GifImage() {
    }

    GifImage(long j) {
        this.mNativeContext = j;
    }

    protected void finalize() {
        nativeFinalize();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public void dispose() {
        nativeDispose();
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
        int iNativeGetLoopCount = nativeGetLoopCount();
        if (iNativeGetLoopCount == -1) {
            return 1;
        }
        if (iNativeGetLoopCount != 0) {
            return iNativeGetLoopCount + 1;
        }
        return 0;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public com.facebook.animated.gif.GifFrame getFrame(int i) {
        return nativeGetFrame(i);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }

    public boolean isAnimated() {
        return nativeIsAnimated();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    public com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo getFrameInfo(int i) {
        com.facebook.animated.gif.GifFrame frame = getFrame(i);
        try {
            return new com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo(i, frame.getXOffset(), frame.getYOffset(), frame.getWidth(), frame.getHeight(), com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.BlendOperation.BLEND_WITH_PREVIOUS, fromGifDisposalMethod(frame.getDisposalMode()));
        } finally {
            frame.dispose();
        }
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedImage
    @javax.annotation.Nullable
    public android.graphics.Bitmap.Config getAnimatedBitmapConfig() {
        return this.mDecodeBitmapConfig;
    }

    private static com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod fromGifDisposalMethod(int i) {
        if (i == 0) {
            return com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
        }
        if (i == 1) {
            return com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
        }
        if (i == 2) {
            return com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND;
        }
        if (i == 3) {
            return com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS;
        }
        return com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
    }
}
