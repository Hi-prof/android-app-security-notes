package com.facebook.imagepipeline.animated.factory;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedImageFactoryImpl implements com.facebook.imagepipeline.animated.factory.AnimatedImageFactory {

    @javax.annotation.Nullable
    static com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder sGifAnimatedImageDecoder = loadIfPresent("com.facebook.animated.gif.GifImage");

    @javax.annotation.Nullable
    static com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder sWebpAnimatedImageDecoder = loadIfPresent("com.facebook.animated.webp.WebPImage");
    private final com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    private final com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory mBitmapFactory;
    private final boolean mIsNewRenderImplementation;
    private final boolean mTreatAnimatedImagesAsStateful;

    @javax.annotation.Nullable
    private static com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder loadIfPresent(java.lang.String str) {
        try {
            return (com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder) java.lang.Class.forName(str).newInstance();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public AnimatedImageFactoryImpl(com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider animatedDrawableBackendProvider, com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory, boolean z) {
        this(animatedDrawableBackendProvider, platformBitmapFactory, z, true);
    }

    public AnimatedImageFactoryImpl(com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider animatedDrawableBackendProvider, com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory, boolean z, boolean z2) {
        this.mAnimatedDrawableBackendProvider = animatedDrawableBackendProvider;
        this.mBitmapFactory = platformBitmapFactory;
        this.mIsNewRenderImplementation = z;
        this.mTreatAnimatedImagesAsStateful = z2;
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageFactory
    public com.facebook.imagepipeline.image.CloseableImage decodeGif(com.facebook.imagepipeline.image.EncodedImage encodedImage, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions, android.graphics.Bitmap.Config config) {
        com.facebook.imagepipeline.animated.base.AnimatedImage animatedImageDecodeFromNativeMemory;
        if (sGifAnimatedImageDecoder == null) {
            throw new java.lang.UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
        }
        com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
        com.facebook.common.internal.Preconditions.checkNotNull(byteBufferRef);
        try {
            com.facebook.common.memory.PooledByteBuffer pooledByteBuffer = byteBufferRef.get();
            if (pooledByteBuffer.getByteBuffer() != null) {
                animatedImageDecodeFromNativeMemory = sGifAnimatedImageDecoder.decodeFromByteBuffer(pooledByteBuffer.getByteBuffer(), imageDecodeOptions);
            } else {
                animatedImageDecodeFromNativeMemory = sGifAnimatedImageDecoder.decodeFromNativeMemory(pooledByteBuffer.getNativePtr(), pooledByteBuffer.size(), imageDecodeOptions);
            }
            return getCloseableImage(encodedImage.getSource(), imageDecodeOptions, animatedImageDecodeFromNativeMemory, config);
        } finally {
            com.facebook.common.references.CloseableReference.closeSafely(byteBufferRef);
        }
    }

    @Override // com.facebook.imagepipeline.animated.factory.AnimatedImageFactory
    public com.facebook.imagepipeline.image.CloseableImage decodeWebP(com.facebook.imagepipeline.image.EncodedImage encodedImage, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions, android.graphics.Bitmap.Config config) {
        com.facebook.imagepipeline.animated.base.AnimatedImage animatedImageDecodeFromNativeMemory;
        if (sWebpAnimatedImageDecoder == null) {
            throw new java.lang.UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
        }
        com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
        com.facebook.common.internal.Preconditions.checkNotNull(byteBufferRef);
        try {
            com.facebook.common.memory.PooledByteBuffer pooledByteBuffer = byteBufferRef.get();
            if (pooledByteBuffer.getByteBuffer() != null) {
                animatedImageDecodeFromNativeMemory = sWebpAnimatedImageDecoder.decodeFromByteBuffer(pooledByteBuffer.getByteBuffer(), imageDecodeOptions);
            } else {
                animatedImageDecodeFromNativeMemory = sWebpAnimatedImageDecoder.decodeFromNativeMemory(pooledByteBuffer.getNativePtr(), pooledByteBuffer.size(), imageDecodeOptions);
            }
            return getCloseableImage(encodedImage.getSource(), imageDecodeOptions, animatedImageDecodeFromNativeMemory, config);
        } finally {
            com.facebook.common.references.CloseableReference.closeSafely(byteBufferRef);
        }
    }

    private com.facebook.imagepipeline.image.CloseableImage getCloseableImage(@javax.annotation.Nullable java.lang.String str, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions, com.facebook.imagepipeline.animated.base.AnimatedImage animatedImage, android.graphics.Bitmap.Config config) throws java.lang.Throwable {
        java.util.List<com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> listDecodeAllFrames;
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceCreatePreviewBitmap = null;
        try {
            int frameCount = imageDecodeOptions.useLastFrameForPreview ? animatedImage.getFrameCount() - 1 : 0;
            if (imageDecodeOptions.forceStaticImage) {
                com.facebook.imagepipeline.image.CloseableStaticBitmap closeableStaticBitmapOf = com.facebook.imagepipeline.image.CloseableStaticBitmap.CC.of(createPreviewBitmap(animatedImage, config, frameCount), com.facebook.imagepipeline.image.ImmutableQualityInfo.FULL_QUALITY, 0);
                com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) null);
                com.facebook.common.references.CloseableReference.closeSafely((java.lang.Iterable<? extends com.facebook.common.references.CloseableReference<?>>) null);
                return closeableStaticBitmapOf;
            }
            if (imageDecodeOptions.decodeAllFrames) {
                listDecodeAllFrames = decodeAllFrames(animatedImage, config);
                try {
                    closeableReferenceCreatePreviewBitmap = com.facebook.common.references.CloseableReference.cloneOrNull(listDecodeAllFrames.get(frameCount));
                } catch (java.lang.Throwable th) {
                    th = th;
                    com.facebook.common.references.CloseableReference.closeSafely(closeableReferenceCreatePreviewBitmap);
                    com.facebook.common.references.CloseableReference.closeSafely(listDecodeAllFrames);
                    throw th;
                }
            } else {
                listDecodeAllFrames = null;
            }
            if (imageDecodeOptions.decodePreviewFrame && closeableReferenceCreatePreviewBitmap == null) {
                closeableReferenceCreatePreviewBitmap = createPreviewBitmap(animatedImage, config, frameCount);
            }
            com.facebook.imagepipeline.image.CloseableAnimatedImage closeableAnimatedImage = new com.facebook.imagepipeline.image.CloseableAnimatedImage(com.facebook.imagepipeline.animated.base.AnimatedImageResult.newBuilder(animatedImage).setPreviewBitmap(closeableReferenceCreatePreviewBitmap).setFrameForPreview(frameCount).setDecodedFrames(listDecodeAllFrames).setBitmapTransformation(imageDecodeOptions.bitmapTransformation).setSource(str).build(), this.mTreatAnimatedImagesAsStateful);
            com.facebook.common.references.CloseableReference.closeSafely(closeableReferenceCreatePreviewBitmap);
            com.facebook.common.references.CloseableReference.closeSafely(listDecodeAllFrames);
            return closeableAnimatedImage;
        } catch (java.lang.Throwable th2) {
            th = th2;
            listDecodeAllFrames = null;
        }
    }

    private com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createPreviewBitmap(com.facebook.imagepipeline.animated.base.AnimatedImage animatedImage, android.graphics.Bitmap.Config config, int i) {
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceCreateBitmap = createBitmap(animatedImage.getWidth(), animatedImage.getHeight(), config);
        new com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor(this.mAnimatedDrawableBackendProvider.get(com.facebook.imagepipeline.animated.base.AnimatedImageResult.forAnimatedImage(animatedImage), null), this.mIsNewRenderImplementation, new com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback() { // from class: com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl.1
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            @javax.annotation.Nullable
            public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> getCachedBitmap(int i2) {
                return null;
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public void onIntermediateResult(int i2, android.graphics.Bitmap bitmap) {
            }
        }).renderFrame(i, closeableReferenceCreateBitmap.get());
        return closeableReferenceCreateBitmap;
    }

    private java.util.List<com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> decodeAllFrames(com.facebook.imagepipeline.animated.base.AnimatedImage animatedImage, android.graphics.Bitmap.Config config) {
        com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend animatedDrawableBackend = this.mAnimatedDrawableBackendProvider.get(com.facebook.imagepipeline.animated.base.AnimatedImageResult.forAnimatedImage(animatedImage), null);
        final java.util.ArrayList arrayList = new java.util.ArrayList(animatedDrawableBackend.getFrameCount());
        com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor animatedImageCompositor = new com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor(animatedDrawableBackend, this.mIsNewRenderImplementation, new com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback() { // from class: com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl.2
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public void onIntermediateResult(int i, android.graphics.Bitmap bitmap) {
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            @javax.annotation.Nullable
            public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> getCachedBitmap(int i) {
                return com.facebook.common.references.CloseableReference.cloneOrNull((com.facebook.common.references.CloseableReference) arrayList.get(i));
            }
        });
        for (int i = 0; i < animatedDrawableBackend.getFrameCount(); i++) {
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceCreateBitmap = createBitmap(animatedDrawableBackend.getWidth(), animatedDrawableBackend.getHeight(), config);
            animatedImageCompositor.renderFrame(i, closeableReferenceCreateBitmap.get());
            arrayList.add(closeableReferenceCreateBitmap);
        }
        return arrayList;
    }

    private com.facebook.common.references.CloseableReference<android.graphics.Bitmap> createBitmap(int i, int i2, android.graphics.Bitmap.Config config) {
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceCreateBitmapInternal = this.mBitmapFactory.createBitmapInternal(i, i2, config);
        closeableReferenceCreateBitmapInternal.get().eraseColor(0);
        closeableReferenceCreateBitmapInternal.get().setHasAlpha(true);
        return closeableReferenceCreateBitmapInternal;
    }
}
