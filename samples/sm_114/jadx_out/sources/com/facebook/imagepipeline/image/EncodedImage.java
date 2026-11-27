package com.facebook.imagepipeline.image;

/* JADX INFO: loaded from: classes.dex */
public class EncodedImage implements java.io.Closeable {
    public static final int DEFAULT_SAMPLE_SIZE = 1;
    public static final int UNKNOWN_HEIGHT = -1;
    public static final int UNKNOWN_ROTATION_ANGLE = -1;
    public static final int UNKNOWN_STREAM_SIZE = -1;
    public static final int UNKNOWN_WIDTH = -1;
    private static boolean sUseCachedMetadata;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.common.BytesRange mBytesRange;

    @javax.annotation.Nullable
    private android.graphics.ColorSpace mColorSpace;
    private int mExifOrientation;
    private boolean mHasParsedMetadata;
    private int mHeight;
    private com.facebook.imageformat.ImageFormat mImageFormat;

    @javax.annotation.Nullable
    private final com.facebook.common.internal.Supplier<java.io.FileInputStream> mInputStreamSupplier;

    @javax.annotation.Nullable
    private final com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> mPooledByteBufferRef;
    private int mRotationAngle;
    private int mSampleSize;

    @javax.annotation.Nullable
    private java.lang.String mSource;
    private int mStreamSize;
    private int mWidth;

    public EncodedImage(com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> closeableReference) {
        this.mImageFormat = com.facebook.imageformat.ImageFormat.UNKNOWN;
        this.mRotationAngle = -1;
        this.mExifOrientation = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.mStreamSize = -1;
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(com.facebook.common.references.CloseableReference.isValid(closeableReference)));
        this.mPooledByteBufferRef = closeableReference.mo248clone();
        this.mInputStreamSupplier = null;
    }

    public EncodedImage(com.facebook.common.internal.Supplier<java.io.FileInputStream> supplier) {
        this.mImageFormat = com.facebook.imageformat.ImageFormat.UNKNOWN;
        this.mRotationAngle = -1;
        this.mExifOrientation = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.mStreamSize = -1;
        com.facebook.common.internal.Preconditions.checkNotNull(supplier);
        this.mPooledByteBufferRef = null;
        this.mInputStreamSupplier = supplier;
    }

    public EncodedImage(com.facebook.common.internal.Supplier<java.io.FileInputStream> supplier, int i) {
        this(supplier);
        this.mStreamSize = i;
    }

    @javax.annotation.Nullable
    public static com.facebook.imagepipeline.image.EncodedImage cloneOrNull(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage) {
        if (encodedImage != null) {
            return encodedImage.cloneOrNull();
        }
        return null;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.image.EncodedImage cloneOrNull() {
        com.facebook.imagepipeline.image.EncodedImage encodedImage;
        com.facebook.common.internal.Supplier<java.io.FileInputStream> supplier = this.mInputStreamSupplier;
        if (supplier != null) {
            encodedImage = new com.facebook.imagepipeline.image.EncodedImage(supplier, this.mStreamSize);
        } else {
            com.facebook.common.references.CloseableReference closeableReferenceCloneOrNull = com.facebook.common.references.CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
            if (closeableReferenceCloneOrNull == null) {
                encodedImage = null;
            } else {
                try {
                    encodedImage = new com.facebook.imagepipeline.image.EncodedImage((com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>) closeableReferenceCloneOrNull);
                } catch (java.lang.Throwable th) {
                    com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReferenceCloneOrNull);
                    throw th;
                }
            }
            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReferenceCloneOrNull);
        }
        if (encodedImage != null) {
            encodedImage.copyMetaDataFrom(this);
        }
        return encodedImage;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.CloseableReference.closeSafely(this.mPooledByteBufferRef);
    }

    public synchronized boolean isValid() {
        return com.facebook.common.references.CloseableReference.isValid(this.mPooledByteBufferRef) || this.mInputStreamSupplier != null;
    }

    public com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> getByteBufferRef() {
        return com.facebook.common.references.CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
    }

    @javax.annotation.Nullable
    public java.io.InputStream getInputStream() {
        com.facebook.common.internal.Supplier<java.io.FileInputStream> supplier = this.mInputStreamSupplier;
        if (supplier != null) {
            return supplier.get();
        }
        com.facebook.common.references.CloseableReference closeableReferenceCloneOrNull = com.facebook.common.references.CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
        if (closeableReferenceCloneOrNull == null) {
            return null;
        }
        try {
            return new com.facebook.common.memory.PooledByteBufferInputStream((com.facebook.common.memory.PooledByteBuffer) closeableReferenceCloneOrNull.get());
        } finally {
            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReferenceCloneOrNull);
        }
    }

    public java.io.InputStream getInputStreamOrThrow() {
        return (java.io.InputStream) com.facebook.common.internal.Preconditions.checkNotNull(getInputStream());
    }

    public void setImageFormat(com.facebook.imageformat.ImageFormat imageFormat) {
        this.mImageFormat = imageFormat;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void setRotationAngle(int i) {
        this.mRotationAngle = i;
    }

    public void setExifOrientation(int i) {
        this.mExifOrientation = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void setStreamSize(int i) {
        this.mStreamSize = i;
    }

    public void setBytesRange(@javax.annotation.Nullable com.facebook.imagepipeline.common.BytesRange bytesRange) {
        this.mBytesRange = bytesRange;
    }

    public void setSource(@javax.annotation.Nullable java.lang.String str) {
        this.mSource = str;
    }

    @javax.annotation.Nullable
    public java.lang.String getSource() {
        return this.mSource;
    }

    public com.facebook.imageformat.ImageFormat getImageFormat() {
        parseMetadataIfNeeded();
        return this.mImageFormat;
    }

    public int getRotationAngle() {
        parseMetadataIfNeeded();
        return this.mRotationAngle;
    }

    public int getExifOrientation() {
        parseMetadataIfNeeded();
        return this.mExifOrientation;
    }

    public int getWidth() {
        parseMetadataIfNeeded();
        return this.mWidth;
    }

    public int getHeight() {
        parseMetadataIfNeeded();
        return this.mHeight;
    }

    @javax.annotation.Nullable
    public android.graphics.ColorSpace getColorSpace() {
        parseMetadataIfNeeded();
        return this.mColorSpace;
    }

    public int getSampleSize() {
        return this.mSampleSize;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.common.BytesRange getBytesRange() {
        return this.mBytesRange;
    }

    public boolean isCompleteAt(int i) {
        if ((this.mImageFormat != com.facebook.imageformat.DefaultImageFormats.JPEG && this.mImageFormat != com.facebook.imageformat.DefaultImageFormats.DNG) || this.mInputStreamSupplier != null) {
            return true;
        }
        com.facebook.common.internal.Preconditions.checkNotNull(this.mPooledByteBufferRef);
        com.facebook.common.memory.PooledByteBuffer pooledByteBuffer = this.mPooledByteBufferRef.get();
        return i >= 2 && pooledByteBuffer.read(i + (-2)) == -1 && pooledByteBuffer.read(i - 1) == -39;
    }

    public int getSize() {
        com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> closeableReference = this.mPooledByteBufferRef;
        if (closeableReference != null && closeableReference.get() != null) {
            return this.mPooledByteBufferRef.get().size();
        }
        return this.mStreamSize;
    }

    public java.lang.String getFirstBytesAsHexString(int i) {
        com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> byteBufferRef = getByteBufferRef();
        if (byteBufferRef == null) {
            return "";
        }
        int iMin = java.lang.Math.min(getSize(), i);
        byte[] bArr = new byte[iMin];
        try {
            com.facebook.common.memory.PooledByteBuffer pooledByteBuffer = byteBufferRef.get();
            if (pooledByteBuffer != null) {
                pooledByteBuffer.read(0, bArr, 0, iMin);
                byteBufferRef.close();
                java.lang.StringBuilder sb = new java.lang.StringBuilder(iMin * 2);
                for (int i2 = 0; i2 < iMin; i2++) {
                    sb.append(java.lang.String.format("%02X", java.lang.Byte.valueOf(bArr[i2])));
                }
                return sb.toString();
            }
            byteBufferRef.close();
            return "";
        } catch (java.lang.Throwable th) {
            byteBufferRef.close();
            throw th;
        }
    }

    private void parseMetadataIfNeeded() {
        if (this.mWidth < 0 || this.mHeight < 0) {
            parseMetaData();
        }
    }

    public void parseMetaData() {
        if (!sUseCachedMetadata) {
            internalParseMetaData();
        } else {
            if (this.mHasParsedMetadata) {
                return;
            }
            internalParseMetaData();
            this.mHasParsedMetadata = true;
        }
    }

    private void internalParseMetaData() {
        kotlin.Pair<java.lang.Integer, java.lang.Integer> dimensions;
        com.facebook.imageformat.ImageFormat imageFormat_WrapIOException = com.facebook.imageformat.ImageFormatChecker.getImageFormat_WrapIOException(getInputStream());
        this.mImageFormat = imageFormat_WrapIOException;
        if (com.facebook.imageformat.DefaultImageFormats.isWebpFormat(imageFormat_WrapIOException)) {
            dimensions = readWebPImageSize();
        } else {
            dimensions = readImageMetaData().getDimensions();
        }
        if (imageFormat_WrapIOException == com.facebook.imageformat.DefaultImageFormats.JPEG && this.mRotationAngle == -1) {
            if (dimensions != null) {
                int orientation = com.facebook.imageutils.JfifUtil.getOrientation(getInputStream());
                this.mExifOrientation = orientation;
                this.mRotationAngle = com.facebook.imageutils.JfifUtil.getAutoRotateAngleFromOrientation(orientation);
                return;
            }
            return;
        }
        if (imageFormat_WrapIOException == com.facebook.imageformat.DefaultImageFormats.HEIF && this.mRotationAngle == -1) {
            int orientation2 = com.facebook.imageutils.HeifExifUtil.getOrientation(getInputStream());
            this.mExifOrientation = orientation2;
            this.mRotationAngle = com.facebook.imageutils.JfifUtil.getAutoRotateAngleFromOrientation(orientation2);
        } else if (this.mRotationAngle == -1) {
            this.mRotationAngle = 0;
        }
    }

    @javax.annotation.Nullable
    private kotlin.Pair<java.lang.Integer, java.lang.Integer> readWebPImageSize() {
        java.io.InputStream inputStream = getInputStream();
        if (inputStream == null) {
            return null;
        }
        kotlin.Pair<java.lang.Integer, java.lang.Integer> size = com.facebook.imageutils.WebpUtil.getSize(inputStream);
        if (size != null) {
            this.mWidth = size.component1().intValue();
            this.mHeight = size.component2().intValue();
        }
        return size;
    }

    private com.facebook.imageutils.ImageMetaData readImageMetaData() throws java.lang.Throwable {
        java.io.InputStream inputStream;
        try {
            inputStream = getInputStream();
            try {
                com.facebook.imageutils.ImageMetaData imageMetaDataDecodeDimensionsAndColorSpace = com.facebook.imageutils.BitmapUtil.decodeDimensionsAndColorSpace(inputStream);
                this.mColorSpace = imageMetaDataDecodeDimensionsAndColorSpace.getColorSpace();
                kotlin.Pair<java.lang.Integer, java.lang.Integer> dimensions = imageMetaDataDecodeDimensionsAndColorSpace.getDimensions();
                if (dimensions != null) {
                    this.mWidth = dimensions.component1().intValue();
                    this.mHeight = dimensions.component2().intValue();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException unused) {
                    }
                }
                return imageMetaDataDecodeDimensionsAndColorSpace;
            } catch (java.lang.Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public void copyMetaDataFrom(com.facebook.imagepipeline.image.EncodedImage encodedImage) {
        this.mImageFormat = encodedImage.getImageFormat();
        this.mWidth = encodedImage.getWidth();
        this.mHeight = encodedImage.getHeight();
        this.mRotationAngle = encodedImage.getRotationAngle();
        this.mExifOrientation = encodedImage.getExifOrientation();
        this.mSampleSize = encodedImage.getSampleSize();
        this.mStreamSize = encodedImage.getSize();
        this.mBytesRange = encodedImage.getBytesRange();
        this.mColorSpace = encodedImage.getColorSpace();
        this.mHasParsedMetadata = encodedImage.hasParsedMetaData();
    }

    public static boolean isMetaDataAvailable(com.facebook.imagepipeline.image.EncodedImage encodedImage) {
        return encodedImage.mRotationAngle >= 0 && encodedImage.mWidth >= 0 && encodedImage.mHeight >= 0;
    }

    public static void closeSafely(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage) {
        if (encodedImage != null) {
            encodedImage.close();
        }
    }

    public static boolean isValid(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage) {
        return encodedImage != null && encodedImage.isValid();
    }

    @javax.annotation.Nullable
    public synchronized com.facebook.common.references.SharedReference<com.facebook.common.memory.PooledByteBuffer> getUnderlyingReferenceTestOnly() {
        com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> closeableReference;
        closeableReference = this.mPooledByteBufferRef;
        return closeableReference != null ? closeableReference.getUnderlyingReferenceTestOnly() : null;
    }

    public static void setUseCachedMetadata(boolean z) {
        sUseCachedMetadata = z;
    }

    protected boolean hasParsedMetaData() {
        return this.mHasParsedMetadata;
    }
}
