package com.facebook.imageutils;

/* JADX INFO: compiled from: BitmapUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J \u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007J\u001e\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0007J \u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0012\u0010#\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0007J&\u0010%\u001a\u0004\u0018\u00010\u001a2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)J\u0012\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010,H\u0007J\"\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010,H\u0007J\n\u00100\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\bH\u0002J\u0010\u00104\u001a\u0002022\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u00105\u001a\u0002022\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\b\u00106\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/facebook/imageutils/BitmapUtil;", "", "<init>", "()V", "POOL_SIZE", "", "DECODE_BUFFERS", "Landroidx/core/util/Pools$SynchronizedPool;", "Ljava/nio/ByteBuffer;", "getDECODE_BUFFERS", "()Landroidx/core/util/Pools$SynchronizedPool;", "DECODE_BUFFERS$delegate", "Lkotlin/Lazy;", "ALPHA_8_BYTES_PER_PIXEL", "ARGB_4444_BYTES_PER_PIXEL", "ARGB_8888_BYTES_PER_PIXEL", "RGB_565_BYTES_PER_PIXEL", "RGBA_F16_BYTES_PER_PIXEL", "RGBA_1010102_BYTES_PER_PIXEL", "MAX_BITMAP_DIMENSION", "", "useDecodeBufferHelper", "", "fixDecodeDrmImageCrash", "getSizeInBytes", "bitmap", "Landroid/graphics/Bitmap;", "decodeDimensions", "Landroid/util/Pair;", "bytes", "", "uri", "Landroid/net/Uri;", "inputStream", "Ljava/io/InputStream;", "decodeDimensionsAndColorSpace", "Lcom/facebook/imageutils/ImageMetaData;", "decodeStreamInternal", "outPadding", "Landroid/graphics/Rect;", "options", "Landroid/graphics/BitmapFactory$Options;", "getPixelSizeForBitmapConfig", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "getSizeInByteForBitmap", "width", "height", "acquireByteBuffer", "releaseByteBuffer", "", "byteBuffer", "setUseDecodeBufferHelper", "setFixDecodeDrmImageCrash", "obtainByteBuffer", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BitmapUtil {
    public static final int ALPHA_8_BYTES_PER_PIXEL = 1;
    public static final int ARGB_4444_BYTES_PER_PIXEL = 2;
    public static final int ARGB_8888_BYTES_PER_PIXEL = 4;
    public static final float MAX_BITMAP_DIMENSION = 2048.0f;
    private static final int POOL_SIZE = 12;
    public static final int RGBA_1010102_BYTES_PER_PIXEL = 4;
    public static final int RGBA_F16_BYTES_PER_PIXEL = 8;
    public static final int RGB_565_BYTES_PER_PIXEL = 2;
    private static boolean fixDecodeDrmImageCrash;
    private static boolean useDecodeBufferHelper;
    public static final com.facebook.imageutils.BitmapUtil INSTANCE = new com.facebook.imageutils.BitmapUtil();

    /* JADX INFO: renamed from: DECODE_BUFFERS$delegate, reason: from kotlin metadata */
    private static final kotlin.Lazy DECODE_BUFFERS = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imageutils.BitmapUtil$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final java.lang.Object invoke() {
            return com.facebook.imageutils.BitmapUtil.DECODE_BUFFERS_delegate$lambda$0();
        }
    });

    /* JADX INFO: compiled from: BitmapUtil.kt */
    @kotlin.Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[android.graphics.Bitmap.Config.values().length];
            try {
                iArr[android.graphics.Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[android.graphics.Bitmap.Config.ALPHA_8.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[android.graphics.Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                iArr[android.graphics.Bitmap.Config.RGB_565.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                iArr[android.graphics.Bitmap.Config.RGBA_F16.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                iArr[android.graphics.Bitmap.Config.RGBA_1010102.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                iArr[android.graphics.Bitmap.Config.HARDWARE.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private BitmapUtil() {
    }

    private final androidx.core.util.Pools.SynchronizedPool<java.nio.ByteBuffer> getDECODE_BUFFERS() {
        return (androidx.core.util.Pools.SynchronizedPool) DECODE_BUFFERS.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.core.util.Pools.SynchronizedPool DECODE_BUFFERS_delegate$lambda$0() {
        return new androidx.core.util.Pools.SynchronizedPool(12);
    }

    @kotlin.jvm.JvmStatic
    public static final int getSizeInBytes(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        try {
            return bitmap.getAllocationByteCount();
        } catch (java.lang.NullPointerException unused) {
            return bitmap.getByteCount();
        }
    }

    @kotlin.jvm.JvmStatic
    public static final android.util.Pair<java.lang.Integer, java.lang.Integer> decodeDimensions(byte[] bytes) {
        return decodeDimensions(new java.io.ByteArrayInputStream(bytes));
    }

    @kotlin.jvm.JvmStatic
    public static final android.util.Pair<java.lang.Integer, java.lang.Integer> decodeDimensions(android.net.Uri uri) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uri, "uri");
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeFile(uri.getPath(), options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            return null;
        }
        return new android.util.Pair<>(java.lang.Integer.valueOf(options.outWidth), java.lang.Integer.valueOf(options.outHeight));
    }

    @kotlin.jvm.JvmStatic
    public static final android.util.Pair<java.lang.Integer, java.lang.Integer> decodeDimensions(java.io.InputStream inputStream) {
        if (inputStream == null) {
            throw new java.lang.IllegalStateException("Required value was null.".toString());
        }
        com.facebook.imageutils.BitmapUtil bitmapUtil = INSTANCE;
        java.nio.ByteBuffer byteBufferObtainByteBuffer = bitmapUtil.obtainByteBuffer();
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            options.inTempStorage = byteBufferObtainByteBuffer.array();
            android.util.Pair<java.lang.Integer, java.lang.Integer> pair = null;
            bitmapUtil.decodeStreamInternal(inputStream, null, options);
            if (options.outWidth != -1 && options.outHeight != -1) {
                pair = new android.util.Pair<>(java.lang.Integer.valueOf(options.outWidth), java.lang.Integer.valueOf(options.outHeight));
            }
            return pair;
        } finally {
            INSTANCE.releaseByteBuffer(byteBufferObtainByteBuffer);
        }
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imageutils.ImageMetaData decodeDimensionsAndColorSpace(java.io.InputStream inputStream) {
        if (inputStream == null) {
            throw new java.lang.IllegalStateException("Required value was null.".toString());
        }
        com.facebook.imageutils.BitmapUtil bitmapUtil = INSTANCE;
        java.nio.ByteBuffer byteBufferObtainByteBuffer = bitmapUtil.obtainByteBuffer();
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            options.inTempStorage = byteBufferObtainByteBuffer.array();
            bitmapUtil.decodeStreamInternal(inputStream, null, options);
            return new com.facebook.imageutils.ImageMetaData(options.outWidth, options.outHeight, android.os.Build.VERSION.SDK_INT >= 26 ? options.outColorSpace : null);
        } finally {
            INSTANCE.releaseByteBuffer(byteBufferObtainByteBuffer);
        }
    }

    public final android.graphics.Bitmap decodeStreamInternal(java.io.InputStream inputStream, android.graphics.Rect outPadding, android.graphics.BitmapFactory.Options options) {
        if (fixDecodeDrmImageCrash) {
            try {
                return android.graphics.BitmapFactory.decodeStream(inputStream, outPadding, options);
            } catch (java.lang.IllegalArgumentException unused) {
                return null;
            }
        }
        return android.graphics.BitmapFactory.decodeStream(inputStream, outPadding, options);
    }

    @kotlin.jvm.JvmStatic
    public static final int getPixelSizeForBitmapConfig(android.graphics.Bitmap.Config bitmapConfig) {
        switch (bitmapConfig == null ? -1 : com.facebook.imageutils.BitmapUtil.WhenMappings.$EnumSwitchMapping$0[bitmapConfig.ordinal()]) {
            case 1:
                return 4;
            case 2:
                return 1;
            case 3:
            case 4:
                return 2;
            case 5:
                return 8;
            case 6:
            case 7:
                return 4;
            default:
                throw new java.lang.UnsupportedOperationException("The provided Bitmap.Config is not supported");
        }
    }

    @kotlin.jvm.JvmStatic
    public static final int getSizeInByteForBitmap(int width, int height, android.graphics.Bitmap.Config bitmapConfig) {
        if (width <= 0) {
            throw new java.lang.IllegalArgumentException(("width must be > 0, width is: " + width).toString());
        }
        if (height <= 0) {
            throw new java.lang.IllegalArgumentException(("height must be > 0, height is: " + height).toString());
        }
        int pixelSizeForBitmapConfig = getPixelSizeForBitmapConfig(bitmapConfig);
        int i = width * height * pixelSizeForBitmapConfig;
        if (i > 0) {
            return i;
        }
        throw new java.lang.IllegalStateException(("size must be > 0: size: " + i + ", width: " + width + ", height: " + height + ", pixelSize: " + pixelSizeForBitmapConfig).toString());
    }

    private final java.nio.ByteBuffer acquireByteBuffer() {
        if (useDecodeBufferHelper) {
            return com.facebook.common.memory.DecodeBufferHelper.INSTANCE.acquire();
        }
        return getDECODE_BUFFERS().acquire();
    }

    private final void releaseByteBuffer(java.nio.ByteBuffer byteBuffer) {
        if (useDecodeBufferHelper) {
            return;
        }
        getDECODE_BUFFERS().release(byteBuffer);
    }

    @kotlin.jvm.JvmStatic
    public static final void setUseDecodeBufferHelper(boolean useDecodeBufferHelper2) {
        useDecodeBufferHelper = useDecodeBufferHelper2;
    }

    @kotlin.jvm.JvmStatic
    public static final void setFixDecodeDrmImageCrash(boolean fixDecodeDrmImageCrash2) {
        fixDecodeDrmImageCrash = fixDecodeDrmImageCrash2;
    }

    private final java.nio.ByteBuffer obtainByteBuffer() {
        java.nio.ByteBuffer byteBufferAcquireByteBuffer = acquireByteBuffer();
        if (byteBufferAcquireByteBuffer != null) {
            return byteBufferAcquireByteBuffer;
        }
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(com.facebook.common.memory.DecodeBufferHelper.getRecommendedDecodeBufferSize());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
        return byteBufferAllocate;
    }
}
