package com.facebook.imagepipeline.nativecode;

/* JADX INFO: loaded from: classes.dex */
public abstract class DalvikPurgeableDecoder implements com.facebook.imagepipeline.platform.PlatformDecoder {
    protected static final byte[] EOI;
    private final com.facebook.imagepipeline.memory.BitmapCounter mUnpooledBitmapsCounter = com.facebook.imagepipeline.memory.BitmapCounterProvider.get();

    private static native void nativePinBitmap(android.graphics.Bitmap bitmap);

    protected abstract android.graphics.Bitmap decodeByteArrayAsPurgeable(com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> closeableReference, android.graphics.BitmapFactory.Options options);

    protected abstract android.graphics.Bitmap decodeJPEGByteArrayAsPurgeable(com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> closeableReference, int i, android.graphics.BitmapFactory.Options options);

    static {
        com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader.load();
        EOI = new byte[]{-1, -39};
    }

    protected DalvikPurgeableDecoder() {
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> decodeFromEncodedImage(com.facebook.imagepipeline.image.EncodedImage encodedImage, android.graphics.Bitmap.Config config, @javax.annotation.Nullable android.graphics.Rect rect) {
        return decodeFromEncodedImageWithColorSpace(encodedImage, config, rect, null);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> decodeJPEGFromEncodedImage(com.facebook.imagepipeline.image.EncodedImage encodedImage, android.graphics.Bitmap.Config config, @javax.annotation.Nullable android.graphics.Rect rect, int i) {
        return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, config, rect, i, null);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> decodeFromEncodedImageWithColorSpace(com.facebook.imagepipeline.image.EncodedImage encodedImage, android.graphics.Bitmap.Config config, @javax.annotation.Nullable android.graphics.Rect rect, @javax.annotation.Nullable android.graphics.ColorSpace colorSpace) {
        android.graphics.BitmapFactory.Options bitmapFactoryOptions = getBitmapFactoryOptions(encodedImage.getSampleSize(), config);
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder.OreoUtils.setColorSpace(bitmapFactoryOptions, colorSpace);
        }
        com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
        com.facebook.common.internal.Preconditions.checkNotNull(byteBufferRef);
        try {
            return pinBitmap(decodeByteArrayAsPurgeable(byteBufferRef, bitmapFactoryOptions));
        } finally {
            com.facebook.common.references.CloseableReference.closeSafely(byteBufferRef);
        }
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> decodeJPEGFromEncodedImageWithColorSpace(com.facebook.imagepipeline.image.EncodedImage encodedImage, android.graphics.Bitmap.Config config, @javax.annotation.Nullable android.graphics.Rect rect, int i, @javax.annotation.Nullable android.graphics.ColorSpace colorSpace) {
        android.graphics.BitmapFactory.Options bitmapFactoryOptions = getBitmapFactoryOptions(encodedImage.getSampleSize(), config);
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder.OreoUtils.setColorSpace(bitmapFactoryOptions, colorSpace);
        }
        com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
        com.facebook.common.internal.Preconditions.checkNotNull(byteBufferRef);
        try {
            return pinBitmap(decodeJPEGByteArrayAsPurgeable(byteBufferRef, i, bitmapFactoryOptions));
        } finally {
            com.facebook.common.references.CloseableReference.closeSafely(byteBufferRef);
        }
    }

    public static android.graphics.BitmapFactory.Options getBitmapFactoryOptions(int i, android.graphics.Bitmap.Config config) {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i;
        options.inMutable = true;
        return options;
    }

    public static boolean endsWithEOI(com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> closeableReference, int i) {
        com.facebook.common.memory.PooledByteBuffer pooledByteBuffer = closeableReference.get();
        return i >= 2 && pooledByteBuffer.read(i + (-2)) == -1 && pooledByteBuffer.read(i - 1) == -39;
    }

    private static class OreoUtils {
        private OreoUtils() {
        }

        static void setColorSpace(android.graphics.BitmapFactory.Options options, @javax.annotation.Nullable android.graphics.ColorSpace colorSpace) {
            if (colorSpace == null) {
                colorSpace = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.SRGB);
            }
            options.inPreferredColorSpace = colorSpace;
        }
    }

    public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> pinBitmap(android.graphics.Bitmap bitmap) {
        com.facebook.common.internal.Preconditions.checkNotNull(bitmap);
        try {
            nativePinBitmap(bitmap);
            if (!this.mUnpooledBitmapsCounter.increase(bitmap)) {
                int sizeInBytes = com.facebook.imageutils.BitmapUtil.getSizeInBytes(bitmap);
                bitmap.recycle();
                throw new com.facebook.imagepipeline.common.TooManyBitmapsException(java.lang.String.format(java.util.Locale.US, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", java.lang.Integer.valueOf(sizeInBytes), java.lang.Integer.valueOf(this.mUnpooledBitmapsCounter.getCount()), java.lang.Long.valueOf(this.mUnpooledBitmapsCounter.getSize()), java.lang.Integer.valueOf(this.mUnpooledBitmapsCounter.getMaxCount()), java.lang.Integer.valueOf(this.mUnpooledBitmapsCounter.getMaxSize())));
            }
            return com.facebook.common.references.CloseableReference.of(bitmap, this.mUnpooledBitmapsCounter.getReleaser());
        } catch (java.lang.Exception e) {
            bitmap.recycle();
            throw com.facebook.common.internal.Throwables.propagate(e);
        }
    }
}
