package com.facebook.imagepipeline.image;

/* JADX INFO: loaded from: classes.dex */
public class CloseableAnimatedImage extends com.facebook.imagepipeline.image.DefaultCloseableImage {

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.animated.base.AnimatedImageResult mImageResult;
    private boolean mIsStateful;

    public CloseableAnimatedImage(com.facebook.imagepipeline.animated.base.AnimatedImageResult animatedImageResult) {
        this(animatedImageResult, true);
    }

    public CloseableAnimatedImage(com.facebook.imagepipeline.animated.base.AnimatedImageResult animatedImageResult, boolean z) {
        this.mImageResult = animatedImageResult;
        this.mIsStateful = z;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getWidth() {
        com.facebook.imagepipeline.animated.base.AnimatedImageResult animatedImageResult;
        animatedImageResult = this.mImageResult;
        return animatedImageResult == null ? 0 : animatedImageResult.getImage().getWidth();
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getHeight() {
        com.facebook.imagepipeline.animated.base.AnimatedImageResult animatedImageResult;
        animatedImageResult = this.mImageResult;
        return animatedImageResult == null ? 0 : animatedImageResult.getImage().getHeight();
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            com.facebook.imagepipeline.animated.base.AnimatedImageResult animatedImageResult = this.mImageResult;
            if (animatedImageResult == null) {
                return;
            }
            this.mImageResult = null;
            animatedImageResult.dispose();
        }
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public synchronized boolean isClosed() {
        return this.mImageResult == null;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, com.facebook.imagepipeline.image.ImageInfo
    public synchronized int getSizeInBytes() {
        com.facebook.imagepipeline.animated.base.AnimatedImageResult animatedImageResult;
        animatedImageResult = this.mImageResult;
        return animatedImageResult == null ? 0 : animatedImageResult.getImage().getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.image.BaseCloseableImage, com.facebook.imagepipeline.image.CloseableImage
    public boolean isStateful() {
        return this.mIsStateful;
    }

    @javax.annotation.Nullable
    public synchronized com.facebook.imagepipeline.animated.base.AnimatedImageResult getImageResult() {
        return this.mImageResult;
    }

    @javax.annotation.Nullable
    public synchronized com.facebook.imagepipeline.animated.base.AnimatedImage getImage() {
        com.facebook.imagepipeline.animated.base.AnimatedImageResult animatedImageResult;
        animatedImageResult = this.mImageResult;
        return animatedImageResult == null ? null : animatedImageResult.getImage();
    }
}
