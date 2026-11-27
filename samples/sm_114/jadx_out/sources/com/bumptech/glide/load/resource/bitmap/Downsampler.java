package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
public final class Downsampler {
    static final java.lang.String TAG = "Downsampler";
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool byteArrayPool;
    private final android.util.DisplayMetrics displayMetrics;
    private final com.bumptech.glide.load.resource.bitmap.HardwareConfigState hardwareConfigState = com.bumptech.glide.load.resource.bitmap.HardwareConfigState.getInstance();
    private final java.util.List<com.bumptech.glide.load.ImageHeaderParser> parsers;
    public static final com.bumptech.glide.load.Option<com.bumptech.glide.load.DecodeFormat> DECODE_FORMAT = com.bumptech.glide.load.Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", com.bumptech.glide.load.DecodeFormat.DEFAULT);
    public static final com.bumptech.glide.load.Option<com.bumptech.glide.load.PreferredColorSpace> PREFERRED_COLOR_SPACE = com.bumptech.glide.load.Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");

    @java.lang.Deprecated
    public static final com.bumptech.glide.load.Option<com.bumptech.glide.load.resource.bitmap.DownsampleStrategy> DOWNSAMPLE_STRATEGY = com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.OPTION;
    public static final com.bumptech.glide.load.Option<java.lang.Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = com.bumptech.glide.load.Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);
    public static final com.bumptech.glide.load.Option<java.lang.Boolean> ALLOW_HARDWARE_CONFIG = com.bumptech.glide.load.Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", false);
    private static final java.lang.String WBMP_MIME_TYPE = "image/vnd.wap.wbmp";
    private static final java.lang.String ICO_MIME_TYPE = "image/x-ico";
    private static final java.util.Set<java.lang.String> NO_DOWNSAMPLE_PRE_N_MIME_TYPES = java.util.Collections.unmodifiableSet(new java.util.HashSet(java.util.Arrays.asList(WBMP_MIME_TYPE, ICO_MIME_TYPE)));
    private static final com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks EMPTY_CALLBACKS = new com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks() { // from class: com.bumptech.glide.load.resource.bitmap.Downsampler.1
        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onDecodeComplete(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, android.graphics.Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onObtainBounds() {
        }
    };
    private static final java.util.Set<com.bumptech.glide.load.ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL_PRE_KITKAT = java.util.Collections.unmodifiableSet(java.util.EnumSet.of(com.bumptech.glide.load.ImageHeaderParser.ImageType.JPEG, com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG_A, com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG));
    private static final java.util.Queue<android.graphics.BitmapFactory.Options> OPTIONS_QUEUE = com.bumptech.glide.util.Util.createQueue(0);

    public interface DecodeCallbacks {
        void onDecodeComplete(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, android.graphics.Bitmap bitmap) throws java.io.IOException;

        void onObtainBounds();
    }

    private static boolean isRotationRequired(int i) {
        return i == 90 || i == 270;
    }

    private static int round(double d) {
        return (int) (d + 0.5d);
    }

    private boolean shouldUsePool(com.bumptech.glide.load.ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public boolean handles(java.io.InputStream inputStream) {
        return true;
    }

    public boolean handles(java.nio.ByteBuffer byteBuffer) {
        return true;
    }

    public Downsampler(java.util.List<com.bumptech.glide.load.ImageHeaderParser> list, android.util.DisplayMetrics displayMetrics, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
        this.parsers = list;
        this.displayMetrics = (android.util.DisplayMetrics) com.bumptech.glide.util.Preconditions.checkNotNull(displayMetrics);
        this.bitmapPool = (com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool) com.bumptech.glide.util.Preconditions.checkNotNull(bitmapPool);
        this.byteArrayPool = (com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool) com.bumptech.glide.util.Preconditions.checkNotNull(arrayPool);
    }

    public boolean handles(android.os.ParcelFileDescriptor parcelFileDescriptor) {
        return com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.isSupported();
    }

    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(java.io.InputStream inputStream, int i, int i2, com.bumptech.glide.load.Options options) throws java.io.IOException {
        return decode(inputStream, i, i2, options, EMPTY_CALLBACKS);
    }

    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(java.nio.ByteBuffer byteBuffer, int i, int i2, com.bumptech.glide.load.Options options) throws java.io.IOException {
        return decode(new com.bumptech.glide.load.resource.bitmap.ImageReader.ByteBufferReader(byteBuffer, this.parsers, this.byteArrayPool), i, i2, options, EMPTY_CALLBACKS);
    }

    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(java.io.InputStream inputStream, int i, int i2, com.bumptech.glide.load.Options options, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks decodeCallbacks) throws java.io.IOException {
        return decode(new com.bumptech.glide.load.resource.bitmap.ImageReader.InputStreamImageReader(inputStream, this.parsers, this.byteArrayPool), i, i2, options, decodeCallbacks);
    }

    void decode(byte[] bArr, int i, int i2, com.bumptech.glide.load.Options options) throws java.io.IOException {
        decode(new com.bumptech.glide.load.resource.bitmap.ImageReader.ByteArrayReader(bArr, this.parsers, this.byteArrayPool), i, i2, options, EMPTY_CALLBACKS);
    }

    void decode(java.io.File file, int i, int i2, com.bumptech.glide.load.Options options) throws java.io.IOException {
        decode(new com.bumptech.glide.load.resource.bitmap.ImageReader.FileReader(file, this.parsers, this.byteArrayPool), i, i2, options, EMPTY_CALLBACKS);
    }

    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(android.os.ParcelFileDescriptor parcelFileDescriptor, int i, int i2, com.bumptech.glide.load.Options options) throws java.io.IOException {
        return decode(new com.bumptech.glide.load.resource.bitmap.ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, this.parsers, this.byteArrayPool), i, i2, options, EMPTY_CALLBACKS);
    }

    private com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(com.bumptech.glide.load.resource.bitmap.ImageReader imageReader, int i, int i2, com.bumptech.glide.load.Options options, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks decodeCallbacks) throws java.io.IOException {
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        android.graphics.BitmapFactory.Options defaultOptions = getDefaultOptions();
        defaultOptions.inTempStorage = bArr;
        com.bumptech.glide.load.DecodeFormat decodeFormat = (com.bumptech.glide.load.DecodeFormat) options.get(DECODE_FORMAT);
        com.bumptech.glide.load.PreferredColorSpace preferredColorSpace = (com.bumptech.glide.load.PreferredColorSpace) options.get(PREFERRED_COLOR_SPACE);
        com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy = (com.bumptech.glide.load.resource.bitmap.DownsampleStrategy) options.get(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.OPTION);
        boolean zBooleanValue = ((java.lang.Boolean) options.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        com.bumptech.glide.load.Option<java.lang.Boolean> option = ALLOW_HARDWARE_CONFIG;
        try {
            return com.bumptech.glide.load.resource.bitmap.BitmapResource.obtain(decodeFromWrappedStreams(imageReader, defaultOptions, downsampleStrategy, decodeFormat, preferredColorSpace, options.get(option) != null && ((java.lang.Boolean) options.get(option)).booleanValue(), i, i2, zBooleanValue, decodeCallbacks), this.bitmapPool);
        } finally {
            releaseOptions(defaultOptions);
            this.byteArrayPool.put(bArr);
        }
    }

    private android.graphics.Bitmap decodeFromWrappedStreams(com.bumptech.glide.load.resource.bitmap.ImageReader imageReader, android.graphics.BitmapFactory.Options options, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy, com.bumptech.glide.load.DecodeFormat decodeFormat, com.bumptech.glide.load.PreferredColorSpace preferredColorSpace, boolean z, int i, int i2, boolean z2, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks decodeCallbacks) throws java.io.IOException {
        java.lang.String str;
        int iRound;
        long logTime = com.bumptech.glide.util.LogTime.getLogTime();
        int[] dimensions = getDimensions(imageReader, options, decodeCallbacks, this.bitmapPool);
        int i3 = dimensions[0];
        int i4 = dimensions[1];
        java.lang.String str2 = options.outMimeType;
        boolean z3 = (i3 == -1 || i4 == -1) ? false : z;
        int imageOrientation = imageReader.getImageOrientation();
        int exifOrientationDegrees = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getExifOrientationDegrees(imageOrientation);
        boolean zIsExifOrientationRequired = com.bumptech.glide.load.resource.bitmap.TransformationUtils.isExifOrientationRequired(imageOrientation);
        int i5 = i;
        if (i5 == Integer.MIN_VALUE) {
            i5 = isRotationRequired(exifOrientationDegrees) ? i4 : i3;
        }
        if (i2 == -2147483648) {
            i2 = isRotationRequired(exifOrientationDegrees) ? i3 : i4;
        }
        com.bumptech.glide.load.ImageHeaderParser.ImageType imageType = imageReader.getImageType();
        calculateScaling(imageType, imageReader, decodeCallbacks, this.bitmapPool, downsampleStrategy, exifOrientationDegrees, i3, i4, i5, i2, options);
        int i6 = i5;
        int i7 = i2;
        calculateConfig(imageReader, decodeFormat, z3, zIsExifOrientationRequired, options, i6, i7);
        int i8 = options.inSampleSize;
        if (shouldUsePool(imageType)) {
            if (i3 < 0 || i4 < 0 || !z2) {
                float f = isScaling(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i9 = options.inSampleSize;
                float f2 = i3;
                float f3 = i9;
                int iCeil = (int) java.lang.Math.ceil(f2 / f3);
                int iCeil2 = (int) java.lang.Math.ceil(i4 / f3);
                int iRound2 = java.lang.Math.round(iCeil * f);
                iRound = java.lang.Math.round(iCeil2 * f);
                str = TAG;
                if (android.util.Log.isLoggable(str, 2)) {
                    android.util.Log.v(str, "Calculated target [" + iRound2 + com.taobao.weex.common.Constants.Name.X + iRound + "] for source [" + i3 + com.taobao.weex.common.Constants.Name.X + i4 + "], sampleSize: " + i9 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f);
                }
                i6 = iRound2;
            } else {
                str = TAG;
                iRound = i7;
            }
            if (i6 > 0 && iRound > 0) {
                setInBitmap(options, this.bitmapPool, i6, iRound);
            }
        } else {
            str = TAG;
        }
        if (preferredColorSpace != null) {
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                options.inPreferredColorSpace = android.graphics.ColorSpace.get((preferredColorSpace == com.bumptech.glide.load.PreferredColorSpace.DISPLAY_P3 && options.outColorSpace != null && options.outColorSpace.isWideGamut()) ? android.graphics.ColorSpace.Named.DISPLAY_P3 : android.graphics.ColorSpace.Named.SRGB);
            } else if (android.os.Build.VERSION.SDK_INT >= 26) {
                options.inPreferredColorSpace = android.graphics.ColorSpace.get(android.graphics.ColorSpace.Named.SRGB);
            }
        }
        android.graphics.Bitmap bitmapDecodeStream = decodeStream(imageReader, options, decodeCallbacks, this.bitmapPool);
        decodeCallbacks.onDecodeComplete(this.bitmapPool, bitmapDecodeStream);
        if (android.util.Log.isLoggable(str, 2)) {
            logDecode(i3, i4, str2, options, bitmapDecodeStream, i, i2, logTime);
        }
        if (bitmapDecodeStream == null) {
            return null;
        }
        bitmapDecodeStream.setDensity(this.displayMetrics.densityDpi);
        android.graphics.Bitmap bitmapRotateImageExif = com.bumptech.glide.load.resource.bitmap.TransformationUtils.rotateImageExif(this.bitmapPool, bitmapDecodeStream, imageOrientation);
        if (!bitmapDecodeStream.equals(bitmapRotateImageExif)) {
            this.bitmapPool.put(bitmapDecodeStream);
        }
        return bitmapRotateImageExif;
    }

    private static void calculateScaling(com.bumptech.glide.load.ImageHeaderParser.ImageType imageType, com.bumptech.glide.load.resource.bitmap.ImageReader imageReader, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks decodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, android.graphics.BitmapFactory.Options options) throws java.io.IOException {
        int i6;
        int i7;
        int iMin;
        int iMax;
        int iFloor;
        double dFloor;
        int iRound;
        if (i2 <= 0 || i3 <= 0) {
            if (android.util.Log.isLoggable(TAG, 3)) {
                android.util.Log.d(TAG, "Unable to determine dimensions for: " + imageType + " with target [" + i4 + com.taobao.weex.common.Constants.Name.X + i5 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
                return;
            }
            return;
        }
        if (isRotationRequired(i)) {
            i7 = i2;
            i6 = i3;
        } else {
            i6 = i2;
            i7 = i3;
        }
        float scaleFactor = downsampleStrategy.getScaleFactor(i6, i7, i4, i5);
        if (scaleFactor <= 0.0f) {
            throw new java.lang.IllegalArgumentException("Cannot scale with factor: " + scaleFactor + " from: " + downsampleStrategy + ", source: [" + i2 + com.taobao.weex.common.Constants.Name.X + i3 + "], target: [" + i4 + com.taobao.weex.common.Constants.Name.X + i5 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        }
        com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.SampleSizeRounding sampleSizeRounding = downsampleStrategy.getSampleSizeRounding(i6, i7, i4, i5);
        if (sampleSizeRounding == null) {
            throw new java.lang.IllegalArgumentException("Cannot round with null rounding");
        }
        float f = i6;
        float f2 = i7;
        int i8 = i6;
        int i9 = i7;
        int iRound2 = i8 / round(scaleFactor * f);
        int iRound3 = i9 / round(scaleFactor * f2);
        if (sampleSizeRounding == com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.SampleSizeRounding.MEMORY) {
            iMin = java.lang.Math.max(iRound2, iRound3);
        } else {
            iMin = java.lang.Math.min(iRound2, iRound3);
        }
        int i10 = iMin;
        if (android.os.Build.VERSION.SDK_INT > 23 || !NO_DOWNSAMPLE_PRE_N_MIME_TYPES.contains(options.outMimeType)) {
            iMax = java.lang.Math.max(1, java.lang.Integer.highestOneBit(i10));
            if (sampleSizeRounding == com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.SampleSizeRounding.MEMORY && iMax < 1.0f / scaleFactor) {
                iMax <<= 1;
            }
        } else {
            iMax = 1;
        }
        options.inSampleSize = iMax;
        if (imageType == com.bumptech.glide.load.ImageHeaderParser.ImageType.JPEG) {
            float fMin = java.lang.Math.min(iMax, 8);
            iFloor = (int) java.lang.Math.ceil(f / fMin);
            iRound = (int) java.lang.Math.ceil(f2 / fMin);
            int i11 = iMax / 8;
            if (i11 > 0) {
                iFloor /= i11;
                iRound /= i11;
            }
        } else {
            if (imageType == com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG || imageType == com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG_A) {
                float f3 = iMax;
                iFloor = (int) java.lang.Math.floor(f / f3);
                dFloor = java.lang.Math.floor(f2 / f3);
            } else if (imageType.isWebp()) {
                if (android.os.Build.VERSION.SDK_INT >= 24) {
                    float f4 = iMax;
                    iFloor = java.lang.Math.round(f / f4);
                    iRound = java.lang.Math.round(f2 / f4);
                } else {
                    float f5 = iMax;
                    iFloor = (int) java.lang.Math.floor(f / f5);
                    dFloor = java.lang.Math.floor(f2 / f5);
                }
            } else if (i8 % iMax != 0 || i9 % iMax != 0) {
                int[] dimensions = getDimensions(imageReader, options, decodeCallbacks, bitmapPool);
                iFloor = dimensions[0];
                iRound = dimensions[1];
            } else {
                iFloor = i8 / iMax;
                iRound = i9 / iMax;
            }
            iRound = (int) dFloor;
        }
        double scaleFactor2 = downsampleStrategy.getScaleFactor(iFloor, iRound, i4, i5);
        options.inTargetDensity = adjustTargetDensityForError(scaleFactor2);
        options.inDensity = getDensityMultiplier(scaleFactor2);
        if (isScaling(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (android.util.Log.isLoggable(TAG, 2)) {
            android.util.Log.v(TAG, "Calculate scaling, source: [" + i2 + com.taobao.weex.common.Constants.Name.X + i3 + "], degreesToRotate: " + i + ", target: [" + i4 + com.taobao.weex.common.Constants.Name.X + i5 + "], power of two scaled: [" + iFloor + com.taobao.weex.common.Constants.Name.X + iRound + "], exact scale factor: " + scaleFactor + ", power of 2 sample size: " + iMax + ", adjusted scale factor: " + scaleFactor2 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    private static int adjustTargetDensityForError(double d) {
        int densityMultiplier = getDensityMultiplier(d);
        int iRound = round(((double) densityMultiplier) * d);
        return round((d / ((double) (iRound / densityMultiplier))) * ((double) iRound));
    }

    private static int getDensityMultiplier(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) java.lang.Math.round(d * 2.147483647E9d);
    }

    private void calculateConfig(com.bumptech.glide.load.resource.bitmap.ImageReader imageReader, com.bumptech.glide.load.DecodeFormat decodeFormat, boolean z, boolean z2, android.graphics.BitmapFactory.Options options, int i, int i2) {
        boolean zHasAlpha;
        if (this.hardwareConfigState.setHardwareConfigIfAllowed(i, i2, options, z, z2)) {
            return;
        }
        if (decodeFormat == com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888) {
            options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            zHasAlpha = imageReader.getImageType().hasAlpha();
        } catch (java.io.IOException e) {
            if (android.util.Log.isLoggable(TAG, 3)) {
                android.util.Log.d(TAG, "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e);
            }
            zHasAlpha = false;
        }
        options.inPreferredConfig = zHasAlpha ? android.graphics.Bitmap.Config.ARGB_8888 : android.graphics.Bitmap.Config.RGB_565;
        if (options.inPreferredConfig == android.graphics.Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    private static int[] getDimensions(com.bumptech.glide.load.resource.bitmap.ImageReader imageReader, android.graphics.BitmapFactory.Options options, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks decodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) throws java.io.IOException {
        options.inJustDecodeBounds = true;
        decodeStream(imageReader, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Bitmap decodeStream(com.bumptech.glide.load.resource.bitmap.ImageReader r5, android.graphics.BitmapFactory.Options r6, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r7, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r6.inJustDecodeBounds
            if (r1 != 0) goto Lc
            r7.onObtainBounds()
            r5.stopGrowingBuffers()
        Lc:
            int r1 = r6.outWidth
            int r2 = r6.outHeight
            java.lang.String r3 = r6.outMimeType
            java.util.concurrent.locks.Lock r4 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r4.lock()
            android.graphics.Bitmap r5 = r5.decodeBitmap(r6)     // Catch: java.lang.IllegalArgumentException -> L25 java.lang.Throwable -> L49
        L1d:
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r6.unlock()
            return r5
        L25:
            r4 = move-exception
            java.io.IOException r1 = newIoExceptionForInBitmapAssertion(r4, r1, r2, r3, r6)     // Catch: java.lang.Throwable -> L49
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch: java.lang.Throwable -> L49
            if (r2 == 0) goto L36
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch: java.lang.Throwable -> L49
        L36:
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L48
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch: java.io.IOException -> L47 java.lang.Throwable -> L49
            r8.put(r0)     // Catch: java.io.IOException -> L47 java.lang.Throwable -> L49
            r0 = 0
            r6.inBitmap = r0     // Catch: java.io.IOException -> L47 java.lang.Throwable -> L49
            android.graphics.Bitmap r5 = decodeStream(r5, r6, r7, r8)     // Catch: java.io.IOException -> L47 java.lang.Throwable -> L49
            goto L1d
        L47:
            throw r1     // Catch: java.lang.Throwable -> L49
        L48:
            throw r1     // Catch: java.lang.Throwable -> L49
        L49:
            r5 = move-exception
            java.util.concurrent.locks.Lock r6 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.decodeStream(com.bumptech.glide.load.resource.bitmap.ImageReader, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    private static boolean isScaling(android.graphics.BitmapFactory.Options options) {
        return options.inTargetDensity > 0 && options.inDensity > 0 && options.inTargetDensity != options.inDensity;
    }

    private static void logDecode(int i, int i2, java.lang.String str, android.graphics.BitmapFactory.Options options, android.graphics.Bitmap bitmap, int i3, int i4, long j) {
        android.util.Log.v(TAG, "Decoded " + getBitmapString(bitmap) + " from [" + i + com.taobao.weex.common.Constants.Name.X + i2 + "] " + str + " with inBitmap " + getInBitmapString(options) + " for [" + i3 + com.taobao.weex.common.Constants.Name.X + i4 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + java.lang.Thread.currentThread().getName() + ", duration: " + com.bumptech.glide.util.LogTime.getElapsedMillis(j));
    }

    private static java.lang.String getInBitmapString(android.graphics.BitmapFactory.Options options) {
        return getBitmapString(options.inBitmap);
    }

    private static java.lang.String getBitmapString(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return com.taobao.weex.el.parse.Operators.ARRAY_START_STR + bitmap.getWidth() + com.taobao.weex.common.Constants.Name.X + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
    }

    private static java.io.IOException newIoExceptionForInBitmapAssertion(java.lang.IllegalArgumentException illegalArgumentException, int i, int i2, java.lang.String str, android.graphics.BitmapFactory.Options options) {
        return new java.io.IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + getInBitmapString(options), illegalArgumentException);
    }

    private static void setInBitmap(android.graphics.BitmapFactory.Options options, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, int i, int i2) {
        android.graphics.Bitmap.Config config;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == android.graphics.Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool.getDirty(i, i2, config);
    }

    private static synchronized android.graphics.BitmapFactory.Options getDefaultOptions() {
        android.graphics.BitmapFactory.Options optionsPoll;
        java.util.Queue<android.graphics.BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            optionsPoll = queue.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new android.graphics.BitmapFactory.Options();
            resetOptions(optionsPoll);
        }
        return optionsPoll;
    }

    private static void releaseOptions(android.graphics.BitmapFactory.Options options) {
        resetOptions(options);
        java.util.Queue<android.graphics.BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void resetOptions(android.graphics.BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }
}
