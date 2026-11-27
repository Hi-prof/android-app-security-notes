package com.facebook.imagepipeline.animated.base;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedImageResult {

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.transformation.BitmapTransformation mBitmapTransformation;

    @javax.annotation.Nullable
    private java.util.List<com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> mDecodedFrames;
    private final int mFrameForPreview;
    private final com.facebook.imagepipeline.animated.base.AnimatedImage mImage;

    @javax.annotation.Nullable
    private com.facebook.common.references.CloseableReference<android.graphics.Bitmap> mPreviewBitmap;

    @javax.annotation.Nullable
    private java.lang.String mSource;

    AnimatedImageResult(com.facebook.imagepipeline.animated.base.AnimatedImageResultBuilder animatedImageResultBuilder) {
        this.mImage = (com.facebook.imagepipeline.animated.base.AnimatedImage) com.facebook.common.internal.Preconditions.checkNotNull(animatedImageResultBuilder.getImage());
        this.mFrameForPreview = animatedImageResultBuilder.getFrameForPreview();
        this.mPreviewBitmap = animatedImageResultBuilder.getPreviewBitmap();
        this.mDecodedFrames = animatedImageResultBuilder.getDecodedFrames();
        this.mBitmapTransformation = animatedImageResultBuilder.getBitmapTransformation();
        this.mSource = animatedImageResultBuilder.getSource();
    }

    private AnimatedImageResult(com.facebook.imagepipeline.animated.base.AnimatedImage animatedImage) {
        this.mImage = (com.facebook.imagepipeline.animated.base.AnimatedImage) com.facebook.common.internal.Preconditions.checkNotNull(animatedImage);
        this.mFrameForPreview = 0;
    }

    public static com.facebook.imagepipeline.animated.base.AnimatedImageResult forAnimatedImage(com.facebook.imagepipeline.animated.base.AnimatedImage animatedImage) {
        return new com.facebook.imagepipeline.animated.base.AnimatedImageResult(animatedImage);
    }

    public static com.facebook.imagepipeline.animated.base.AnimatedImageResultBuilder newBuilder(com.facebook.imagepipeline.animated.base.AnimatedImage animatedImage) {
        return new com.facebook.imagepipeline.animated.base.AnimatedImageResultBuilder(animatedImage);
    }

    public com.facebook.imagepipeline.animated.base.AnimatedImage getImage() {
        return this.mImage;
    }

    @javax.annotation.Nullable
    public java.lang.String getSource() {
        return this.mSource;
    }

    public int getFrameForPreview() {
        return this.mFrameForPreview;
    }

    @javax.annotation.Nullable
    public synchronized com.facebook.common.references.CloseableReference<android.graphics.Bitmap> getDecodedFrame(int i) {
        java.util.List<com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> list = this.mDecodedFrames;
        if (list == null) {
            return null;
        }
        return com.facebook.common.references.CloseableReference.cloneOrNull(list.get(i));
    }

    public synchronized boolean hasDecodedFrame(int i) {
        java.util.List<com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> list;
        list = this.mDecodedFrames;
        return (list == null || list.get(i) == null) ? false : true;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.transformation.BitmapTransformation getBitmapTransformation() {
        return this.mBitmapTransformation;
    }

    @javax.annotation.Nullable
    public synchronized com.facebook.common.references.CloseableReference<android.graphics.Bitmap> getPreviewBitmap() {
        return com.facebook.common.references.CloseableReference.cloneOrNull(this.mPreviewBitmap);
    }

    public synchronized void dispose() {
        com.facebook.common.references.CloseableReference.closeSafely(this.mPreviewBitmap);
        this.mPreviewBitmap = null;
        com.facebook.common.references.CloseableReference.closeSafely(this.mDecodedFrames);
        this.mDecodedFrames = null;
    }
}
