package com.facebook.imagepipeline.animated.base;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedImageResultBuilder {

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.transformation.BitmapTransformation mBitmapTransformation;

    @javax.annotation.Nullable
    private java.util.List<com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> mDecodedFrames;
    private int mFrameForPreview;
    private final com.facebook.imagepipeline.animated.base.AnimatedImage mImage;

    @javax.annotation.Nullable
    private com.facebook.common.references.CloseableReference<android.graphics.Bitmap> mPreviewBitmap;

    @javax.annotation.Nullable
    private java.lang.String mSource;

    AnimatedImageResultBuilder(com.facebook.imagepipeline.animated.base.AnimatedImage animatedImage) {
        this.mImage = animatedImage;
    }

    public com.facebook.imagepipeline.animated.base.AnimatedImage getImage() {
        return this.mImage;
    }

    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> getPreviewBitmap() {
        return com.facebook.common.references.CloseableReference.cloneOrNull(this.mPreviewBitmap);
    }

    public com.facebook.imagepipeline.animated.base.AnimatedImageResultBuilder setPreviewBitmap(@javax.annotation.Nullable com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReference) {
        this.mPreviewBitmap = com.facebook.common.references.CloseableReference.cloneOrNull(closeableReference);
        return this;
    }

    public int getFrameForPreview() {
        return this.mFrameForPreview;
    }

    public com.facebook.imagepipeline.animated.base.AnimatedImageResultBuilder setFrameForPreview(int i) {
        this.mFrameForPreview = i;
        return this;
    }

    @javax.annotation.Nullable
    public java.util.List<com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> getDecodedFrames() {
        return com.facebook.common.references.CloseableReference.cloneOrNull(this.mDecodedFrames);
    }

    @javax.annotation.Nullable
    public java.lang.String getSource() {
        return this.mSource;
    }

    public com.facebook.imagepipeline.animated.base.AnimatedImageResultBuilder setDecodedFrames(@javax.annotation.Nullable java.util.List<com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> list) {
        this.mDecodedFrames = com.facebook.common.references.CloseableReference.cloneOrNull(list);
        return this;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.transformation.BitmapTransformation getBitmapTransformation() {
        return this.mBitmapTransformation;
    }

    public com.facebook.imagepipeline.animated.base.AnimatedImageResultBuilder setBitmapTransformation(@javax.annotation.Nullable com.facebook.imagepipeline.transformation.BitmapTransformation bitmapTransformation) {
        this.mBitmapTransformation = bitmapTransformation;
        return this;
    }

    public com.facebook.imagepipeline.animated.base.AnimatedImageResultBuilder setSource(@javax.annotation.Nullable java.lang.String str) {
        this.mSource = str;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.facebook.imagepipeline.animated.base.AnimatedImageResult build() {
        try {
            return new com.facebook.imagepipeline.animated.base.AnimatedImageResult(this);
        } finally {
            com.facebook.common.references.CloseableReference.closeSafely(this.mPreviewBitmap);
            this.mPreviewBitmap = null;
            com.facebook.common.references.CloseableReference.closeSafely(this.mDecodedFrames);
            this.mDecodedFrames = null;
        }
    }
}
