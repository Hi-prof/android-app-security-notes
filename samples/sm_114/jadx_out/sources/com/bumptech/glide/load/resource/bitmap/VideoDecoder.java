package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
public class VideoDecoder<T> implements com.bumptech.glide.load.ResourceDecoder<T, android.graphics.Bitmap> {
    public static final long DEFAULT_FRAME = -1;
    static final int DEFAULT_FRAME_OPTION = 2;
    private static final java.lang.String TAG = "VideoDecoder";
    private static final java.lang.String WEBM_MIME_TYPE = "video/webm";
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private final com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverFactory factory;
    private final com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer<T> initializer;
    public static final com.bumptech.glide.load.Option<java.lang.Long> TARGET_FRAME = com.bumptech.glide.load.Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new com.bumptech.glide.load.Option.CacheKeyUpdater<java.lang.Long>() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.1
        private final java.nio.ByteBuffer buffer = java.nio.ByteBuffer.allocate(8);

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public void update(byte[] bArr, java.lang.Long l, java.security.MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.buffer) {
                this.buffer.position(0);
                messageDigest.update(this.buffer.putLong(l.longValue()).array());
            }
        }
    });
    public static final com.bumptech.glide.load.Option<java.lang.Integer> FRAME_OPTION = com.bumptech.glide.load.Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new com.bumptech.glide.load.Option.CacheKeyUpdater<java.lang.Integer>() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.2
        private final java.nio.ByteBuffer buffer = java.nio.ByteBuffer.allocate(4);

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public void update(byte[] bArr, java.lang.Integer num, java.security.MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.buffer) {
                this.buffer.position(0);
                messageDigest.update(this.buffer.putInt(num.intValue()).array());
            }
        }
    });
    private static final com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverFactory DEFAULT_FACTORY = new com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverFactory();
    private static final java.util.List<java.lang.String> PIXEL_T_BUILD_ID_PREFIXES_REQUIRING_HDR_180_ROTATION_FIX = java.util.Collections.unmodifiableList(java.util.Arrays.asList("TP1A", "TD1A.220804.031"));

    interface MediaInitializer<T> {
        void initializeExtractor(android.media.MediaExtractor mediaExtractor, T t) throws java.io.IOException;

        void initializeRetriever(android.media.MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(T t, com.bumptech.glide.load.Options options) {
        return true;
    }

    public static com.bumptech.glide.load.ResourceDecoder<android.content.res.AssetFileDescriptor, android.graphics.Bitmap> asset(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        return new com.bumptech.glide.load.resource.bitmap.VideoDecoder(bitmapPool, new com.bumptech.glide.load.resource.bitmap.VideoDecoder.AssetFileDescriptorInitializer());
    }

    public static com.bumptech.glide.load.ResourceDecoder<android.os.ParcelFileDescriptor, android.graphics.Bitmap> parcel(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        return new com.bumptech.glide.load.resource.bitmap.VideoDecoder(bitmapPool, new com.bumptech.glide.load.resource.bitmap.VideoDecoder.ParcelFileDescriptorInitializer());
    }

    public static com.bumptech.glide.load.ResourceDecoder<java.nio.ByteBuffer, android.graphics.Bitmap> byteBuffer(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        return new com.bumptech.glide.load.resource.bitmap.VideoDecoder(bitmapPool, new com.bumptech.glide.load.resource.bitmap.VideoDecoder.ByteBufferInitializer());
    }

    VideoDecoder(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer<T> mediaInitializer) {
        this(bitmapPool, mediaInitializer, DEFAULT_FACTORY);
    }

    VideoDecoder(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer<T> mediaInitializer, com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory) {
        this.bitmapPool = bitmapPool;
        this.initializer = mediaInitializer;
        this.factory = mediaMetadataRetrieverFactory;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(T t, int i, int i2, com.bumptech.glide.load.Options options) throws java.lang.Exception {
        long jLongValue = ((java.lang.Long) options.get(TARGET_FRAME)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new java.lang.IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        java.lang.Integer num = (java.lang.Integer) options.get(FRAME_OPTION);
        if (num == null) {
            num = 2;
        }
        com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy = (com.bumptech.glide.load.resource.bitmap.DownsampleStrategy) options.get(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.OPTION);
        if (downsampleStrategy == null) {
            downsampleStrategy = com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.DEFAULT;
        }
        com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        android.media.MediaMetadataRetriever mediaMetadataRetrieverBuild = this.factory.build();
        try {
            this.initializer.initializeRetriever(mediaMetadataRetrieverBuild, t);
            try {
                android.graphics.Bitmap bitmapDecodeFrame = decodeFrame(t, mediaMetadataRetrieverBuild, jLongValue, num.intValue(), i, i2, downsampleStrategy2);
                if (android.os.Build.VERSION.SDK_INT >= 29) {
                    kotlin.UByte$$ExternalSyntheticBackport0.m((java.lang.Object) mediaMetadataRetrieverBuild);
                } else {
                    mediaMetadataRetrieverBuild.release();
                }
                return com.bumptech.glide.load.resource.bitmap.BitmapResource.obtain(bitmapDecodeFrame, this.bitmapPool);
            } catch (java.lang.Throwable th) {
                th = th;
                java.lang.Throwable th2 = th;
                if (android.os.Build.VERSION.SDK_INT >= 29) {
                    kotlin.UByte$$ExternalSyntheticBackport0.m((java.lang.Object) mediaMetadataRetrieverBuild);
                    throw th2;
                }
                mediaMetadataRetrieverBuild.release();
                throw th2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    private android.graphics.Bitmap decodeFrame(T t, android.media.MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy) {
        if (isUnsupportedFormat(t, mediaMetadataRetriever)) {
            throw new java.lang.IllegalStateException("Cannot decode VP8 video on CrOS.");
        }
        android.graphics.Bitmap bitmapDecodeScaledFrame = (android.os.Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || downsampleStrategy == com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.NONE) ? null : decodeScaledFrame(mediaMetadataRetriever, j, i, i2, i3, downsampleStrategy);
        if (bitmapDecodeScaledFrame == null) {
            bitmapDecodeScaledFrame = decodeOriginalFrame(mediaMetadataRetriever, j, i);
        }
        android.graphics.Bitmap bitmapCorrectHdr180DegVideoFrameOrientation = correctHdr180DegVideoFrameOrientation(mediaMetadataRetriever, bitmapDecodeScaledFrame);
        if (bitmapCorrectHdr180DegVideoFrameOrientation != null) {
            return bitmapCorrectHdr180DegVideoFrameOrientation;
        }
        throw new com.bumptech.glide.load.resource.bitmap.VideoDecoder.VideoDecoderException();
    }

    private static android.graphics.Bitmap correctHdr180DegVideoFrameOrientation(android.media.MediaMetadataRetriever mediaMetadataRetriever, android.graphics.Bitmap bitmap) {
        if (isHdr180RotationFixRequired()) {
            try {
                if (isHDR(mediaMetadataRetriever)) {
                    if (java.lang.Math.abs(java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(24))) != 180) {
                        return bitmap;
                    }
                    if (android.util.Log.isLoggable(TAG, 3)) {
                        android.util.Log.d(TAG, "Applying HDR 180 deg thumbnail correction");
                    }
                    android.graphics.Matrix matrix = new android.graphics.Matrix();
                    matrix.postRotate(180.0f, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
                    return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                }
            } catch (java.lang.NumberFormatException unused) {
                if (!android.util.Log.isLoggable(TAG, 3)) {
                    return bitmap;
                }
                android.util.Log.d(TAG, "Exception trying to extract HDR transfer function or rotation");
                return bitmap;
            }
        }
        return bitmap;
    }

    private static boolean isHDR(android.media.MediaMetadataRetriever mediaMetadataRetriever) throws java.lang.NumberFormatException {
        java.lang.String strExtractMetadata = mediaMetadataRetriever.extractMetadata(36);
        java.lang.String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(35);
        int i = java.lang.Integer.parseInt(strExtractMetadata);
        return (i == 7 || i == 6) && java.lang.Integer.parseInt(strExtractMetadata2) == 6;
    }

    static boolean isHdr180RotationFixRequired() {
        if (android.os.Build.MODEL.startsWith("Pixel") && android.os.Build.VERSION.SDK_INT == 33) {
            return isTBuildRequiringRotationFix();
        }
        return android.os.Build.VERSION.SDK_INT >= 30 && android.os.Build.VERSION.SDK_INT < 33;
    }

    private static boolean isTBuildRequiringRotationFix() {
        java.util.Iterator<java.lang.String> it = PIXEL_T_BUILD_ID_PREFIXES_REQUIRING_HDR_180_ROTATION_FIX.iterator();
        while (it.hasNext()) {
            if (android.os.Build.ID.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static android.graphics.Bitmap decodeScaledFrame(android.media.MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy) {
        try {
            int i4 = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i5 = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i6 = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i6 == 90 || i6 == 270) {
                i5 = i4;
                i4 = i5;
            }
            float scaleFactor = downsampleStrategy.getScaleFactor(i4, i5, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, java.lang.Math.round(i4 * scaleFactor), java.lang.Math.round(scaleFactor * i5));
        } catch (java.lang.Throwable th) {
            if (!android.util.Log.isLoggable(TAG, 3)) {
                return null;
            }
            android.util.Log.d(TAG, "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
            return null;
        }
    }

    private static android.graphics.Bitmap decodeOriginalFrame(android.media.MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x005d A[Catch: all -> 0x0068, TRY_LEAVE, TryCatch #2 {all -> 0x0068, blocks: (B:23:0x0057, B:25:0x005d), top: B:38:0x0057 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0064 A[DONT_GENERATE] */
    private boolean isUnsupportedFormat(T t, android.media.MediaMetadataRetriever mediaMetadataRetriever) {
        if (android.os.Build.DEVICE == null || !android.os.Build.DEVICE.matches(".+_cheets|cheets_.+")) {
            return false;
        }
        android.media.MediaExtractor mediaExtractor = null;
        try {
            try {
                if (!WEBM_MIME_TYPE.equals(mediaMetadataRetriever.extractMetadata(12))) {
                    return false;
                }
                android.media.MediaExtractor mediaExtractor2 = new android.media.MediaExtractor();
                try {
                    this.initializer.initializeExtractor(mediaExtractor2, t);
                    int trackCount = mediaExtractor2.getTrackCount();
                    for (int i = 0; i < trackCount; i++) {
                        if (androidtranscoder.format.MediaFormatExtraConstants.MIMETYPE_VIDEO_VP8.equals(mediaExtractor2.getTrackFormat(i).getString(tv.danmaku.ijk.media.player.misc.IMediaFormat.KEY_MIME))) {
                            mediaExtractor2.release();
                            return true;
                        }
                    }
                    mediaExtractor2.release();
                } catch (java.lang.Throwable th) {
                    th = th;
                    mediaExtractor = mediaExtractor2;
                    if (android.util.Log.isLoggable(TAG, 3)) {
                        android.util.Log.d(TAG, "Exception trying to extract track info for a webm video on CrOS.", th);
                    }
                }
                return false;
                if (android.util.Log.isLoggable(TAG, 3)) {
                    android.util.Log.d(TAG, "Exception trying to extract track info for a webm video on CrOS.", th);
                }
                return false;
            } finally {
                if (mediaExtractor != null) {
                    mediaExtractor.release();
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    static class MediaMetadataRetrieverFactory {
        MediaMetadataRetrieverFactory() {
        }

        public android.media.MediaMetadataRetriever build() {
            return new android.media.MediaMetadataRetriever();
        }
    }

    private static final class AssetFileDescriptorInitializer implements com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer<android.content.res.AssetFileDescriptor> {
        private AssetFileDescriptorInitializer() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        public void initializeRetriever(android.media.MediaMetadataRetriever mediaMetadataRetriever, android.content.res.AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        public void initializeExtractor(android.media.MediaExtractor mediaExtractor, android.content.res.AssetFileDescriptor assetFileDescriptor) throws java.io.IOException {
            mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    static final class ParcelFileDescriptorInitializer implements com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer<android.os.ParcelFileDescriptor> {
        ParcelFileDescriptorInitializer() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        public void initializeRetriever(android.media.MediaMetadataRetriever mediaMetadataRetriever, android.os.ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        public void initializeExtractor(android.media.MediaExtractor mediaExtractor, android.os.ParcelFileDescriptor parcelFileDescriptor) throws java.io.IOException {
            mediaExtractor.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    static final class ByteBufferInitializer implements com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer<java.nio.ByteBuffer> {
        ByteBufferInitializer() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        public void initializeRetriever(android.media.MediaMetadataRetriever mediaMetadataRetriever, java.nio.ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(getMediaDataSource(byteBuffer));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaInitializer
        public void initializeExtractor(android.media.MediaExtractor mediaExtractor, java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            mediaExtractor.setDataSource(getMediaDataSource(byteBuffer));
        }

        private android.media.MediaDataSource getMediaDataSource(final java.nio.ByteBuffer byteBuffer) {
            return new android.media.MediaDataSource() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.ByteBufferInitializer.1
                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }

                @Override // android.media.MediaDataSource
                public int readAt(long j, byte[] bArr, int i, int i2) {
                    if (j >= byteBuffer.limit()) {
                        return -1;
                    }
                    byteBuffer.position((int) j);
                    int iMin = java.lang.Math.min(i2, byteBuffer.remaining());
                    byteBuffer.get(bArr, i, iMin);
                    return iMin;
                }

                @Override // android.media.MediaDataSource
                public long getSize() {
                    return byteBuffer.limit();
                }
            };
        }
    }

    private static final class VideoDecoderException extends java.lang.RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }
}
