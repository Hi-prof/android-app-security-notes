package com.facebook.webpsupport;

/* JADX INFO: loaded from: classes.dex */
public class WebpBitmapFactoryImpl implements com.facebook.common.webp.WebpBitmapFactory {
    private static final int HEADER_SIZE = 20;
    private static final int IN_TEMP_BUFFER_SIZE = 8192;
    private static com.facebook.common.webp.BitmapCreator mBitmapCreator;
    private static com.facebook.common.webp.WebpBitmapFactory.WebpErrorLogger mWebpErrorLogger;

    @javax.annotation.Nullable
    private static native android.graphics.Bitmap nativeDecodeByteArray(byte[] bArr, int i, int i2, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options, float f, byte[] bArr2);

    @javax.annotation.Nullable
    private static native android.graphics.Bitmap nativeDecodeStream(java.io.InputStream inputStream, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options, float f, byte[] bArr);

    private static native long nativeSeek(java.io.FileDescriptor fileDescriptor, long j, boolean z);

    @Override // com.facebook.common.webp.WebpBitmapFactory
    public void setBitmapCreator(com.facebook.common.webp.BitmapCreator bitmapCreator) {
        mBitmapCreator = bitmapCreator;
    }

    private static java.io.InputStream wrapToMarkSupportedStream(java.io.InputStream inputStream) {
        return !inputStream.markSupported() ? new java.io.BufferedInputStream(inputStream, 20) : inputStream;
    }

    @javax.annotation.Nullable
    private static byte[] getWebpHeader(java.io.InputStream inputStream, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        byte[] bArr;
        inputStream.mark(20);
        if (options != null && options.inTempStorage != null && options.inTempStorage.length >= 20) {
            bArr = options.inTempStorage;
        } else {
            bArr = new byte[20];
        }
        try {
            inputStream.read(bArr, 0, 20);
            inputStream.reset();
            return bArr;
        } catch (java.io.IOException unused) {
            return null;
        }
    }

    private static void setDensityFromOptions(@javax.annotation.Nullable android.graphics.Bitmap bitmap, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        if (bitmap == null || options == null) {
            return;
        }
        int i = options.inDensity;
        if (i != 0) {
            bitmap.setDensity(i);
            int i2 = options.inTargetDensity;
            if (i2 == 0 || i == i2 || i == options.inScreenDensity || !options.inScaled) {
                return;
            }
            bitmap.setDensity(i2);
            return;
        }
        if (options.inBitmap != null) {
            bitmap.setDensity(com.alibaba.fastjson.asm.Opcodes.IF_ICMPNE);
        }
    }

    @Override // com.facebook.common.webp.WebpBitmapFactory
    public void setWebpErrorLogger(com.facebook.common.webp.WebpBitmapFactory.WebpErrorLogger webpErrorLogger) {
        mWebpErrorLogger = webpErrorLogger;
    }

    @Override // com.facebook.common.webp.WebpBitmapFactory
    @javax.annotation.Nullable
    public android.graphics.Bitmap decodeFileDescriptor(java.io.FileDescriptor fileDescriptor, @javax.annotation.Nullable android.graphics.Rect rect, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        return hookDecodeFileDescriptor(fileDescriptor, rect, options);
    }

    @Override // com.facebook.common.webp.WebpBitmapFactory
    @javax.annotation.Nullable
    public android.graphics.Bitmap decodeStream(java.io.InputStream inputStream, @javax.annotation.Nullable android.graphics.Rect rect, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        return hookDecodeStream(inputStream, rect, options);
    }

    @Override // com.facebook.common.webp.WebpBitmapFactory
    @javax.annotation.Nullable
    public android.graphics.Bitmap decodeFile(java.lang.String str, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        return hookDecodeFile(str, options);
    }

    @Override // com.facebook.common.webp.WebpBitmapFactory
    @javax.annotation.Nullable
    public android.graphics.Bitmap decodeByteArray(byte[] bArr, int i, int i2, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        return hookDecodeByteArray(bArr, i, i2, options);
    }

    @javax.annotation.Nullable
    public static android.graphics.Bitmap hookDecodeByteArray(byte[] bArr, int i, int i2, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader.ensure();
        android.graphics.Bitmap bitmapOriginalDecodeByteArray = originalDecodeByteArray(bArr, i, i2, options);
        if (bitmapOriginalDecodeByteArray == null) {
            sendWebpErrorLog("webp_direct_decode_array_failed_on_no_webp");
        }
        return bitmapOriginalDecodeByteArray;
    }

    @javax.annotation.Nullable
    private static android.graphics.Bitmap originalDecodeByteArray(byte[] bArr, int i, int i2, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        return android.graphics.BitmapFactory.decodeByteArray(bArr, i, i2, options);
    }

    @javax.annotation.Nullable
    public static android.graphics.Bitmap hookDecodeByteArray(byte[] bArr, int i, int i2) {
        return hookDecodeByteArray(bArr, i, i2, null);
    }

    @javax.annotation.Nullable
    private static android.graphics.Bitmap originalDecodeByteArray(byte[] bArr, int i, int i2) {
        return android.graphics.BitmapFactory.decodeByteArray(bArr, i, i2);
    }

    @javax.annotation.Nullable
    public static android.graphics.Bitmap hookDecodeStream(java.io.InputStream inputStream, @javax.annotation.Nullable android.graphics.Rect rect, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader.ensure();
        android.graphics.Bitmap bitmapOriginalDecodeStream = originalDecodeStream(wrapToMarkSupportedStream(inputStream), rect, options);
        if (bitmapOriginalDecodeStream == null) {
            sendWebpErrorLog("webp_direct_decode_stream_failed_on_no_webp");
        }
        return bitmapOriginalDecodeStream;
    }

    @javax.annotation.Nullable
    private static android.graphics.Bitmap originalDecodeStream(java.io.InputStream inputStream, @javax.annotation.Nullable android.graphics.Rect rect, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        return android.graphics.BitmapFactory.decodeStream(inputStream, rect, options);
    }

    @javax.annotation.Nullable
    public static android.graphics.Bitmap hookDecodeStream(java.io.InputStream inputStream) {
        return hookDecodeStream(inputStream, null, null);
    }

    @javax.annotation.Nullable
    private static android.graphics.Bitmap originalDecodeStream(java.io.InputStream inputStream) {
        return android.graphics.BitmapFactory.decodeStream(inputStream);
    }

    @javax.annotation.Nullable
    public static android.graphics.Bitmap hookDecodeFile(java.lang.String str, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        android.graphics.Bitmap bitmapHookDecodeStream = null;
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(str);
            try {
                bitmapHookDecodeStream = hookDecodeStream(fileInputStream, null, options);
                fileInputStream.close();
                return bitmapHookDecodeStream;
            } catch (java.lang.Throwable th) {
                try {
                    fileInputStream.close();
                } catch (java.lang.Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (java.lang.Exception unused) {
            return bitmapHookDecodeStream;
        }
    }

    @javax.annotation.Nullable
    public static android.graphics.Bitmap hookDecodeFile(java.lang.String str) {
        return hookDecodeFile(str, null);
    }

    @javax.annotation.Nullable
    public static android.graphics.Bitmap hookDecodeResourceStream(@javax.annotation.Nullable android.content.res.Resources resources, @javax.annotation.Nullable android.util.TypedValue typedValue, java.io.InputStream inputStream, @javax.annotation.Nullable android.graphics.Rect rect, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        if (options == null) {
            options = new android.graphics.BitmapFactory.Options();
        }
        if (options.inDensity == 0 && typedValue != null) {
            int i = typedValue.density;
            if (i == 0) {
                options.inDensity = com.alibaba.fastjson.asm.Opcodes.IF_ICMPNE;
            } else if (i != 65535) {
                options.inDensity = i;
            }
        }
        if (options.inTargetDensity == 0 && resources != null) {
            options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        return hookDecodeStream(inputStream, rect, options);
    }

    @javax.annotation.Nullable
    private static android.graphics.Bitmap originalDecodeResourceStream(android.content.res.Resources resources, android.util.TypedValue typedValue, java.io.InputStream inputStream, android.graphics.Rect rect, android.graphics.BitmapFactory.Options options) {
        return android.graphics.BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
    }

    @javax.annotation.Nullable
    public static android.graphics.Bitmap hookDecodeResource(android.content.res.Resources resources, int i, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        android.graphics.Bitmap bitmapHookDecodeResourceStream = null;
        try {
            java.io.InputStream inputStreamOpenRawResource = resources.openRawResource(i, typedValue);
            try {
                bitmapHookDecodeResourceStream = hookDecodeResourceStream(resources, typedValue, inputStreamOpenRawResource, null, options);
                if (inputStreamOpenRawResource != null) {
                    inputStreamOpenRawResource.close();
                }
            } catch (java.lang.Throwable th) {
                if (inputStreamOpenRawResource != null) {
                    try {
                        inputStreamOpenRawResource.close();
                    } catch (java.lang.Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused) {
        }
        if (bitmapHookDecodeResourceStream != null || options == null || options.inBitmap == null) {
            return bitmapHookDecodeResourceStream;
        }
        throw new java.lang.IllegalArgumentException("Problem decoding into existing bitmap");
    }

    @javax.annotation.Nullable
    private static android.graphics.Bitmap originalDecodeResource(android.content.res.Resources resources, int i, android.graphics.BitmapFactory.Options options) {
        return android.graphics.BitmapFactory.decodeResource(resources, i, options);
    }

    @javax.annotation.Nullable
    public static android.graphics.Bitmap hookDecodeResource(android.content.res.Resources resources, int i) {
        return hookDecodeResource(resources, i, null);
    }

    @javax.annotation.Nullable
    private static android.graphics.Bitmap originalDecodeResource(android.content.res.Resources resources, int i) {
        return android.graphics.BitmapFactory.decodeResource(resources, i);
    }

    private static boolean setOutDimensions(@javax.annotation.Nullable android.graphics.BitmapFactory.Options options, int i, int i2) {
        if (options == null || !options.inJustDecodeBounds) {
            return false;
        }
        options.outWidth = i;
        options.outHeight = i2;
        return true;
    }

    private static void setPaddingDefaultValues(@javax.annotation.Nullable android.graphics.Rect rect) {
        if (rect != null) {
            rect.top = -1;
            rect.left = -1;
            rect.bottom = -1;
            rect.right = -1;
        }
    }

    private static void setBitmapSize(@javax.annotation.Nullable android.graphics.BitmapFactory.Options options, int i, int i2) {
        if (options != null) {
            options.outWidth = i;
            options.outHeight = i2;
        }
    }

    @javax.annotation.Nullable
    private static android.graphics.Bitmap originalDecodeFile(java.lang.String str, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        return android.graphics.BitmapFactory.decodeFile(str, options);
    }

    @javax.annotation.Nullable
    private static android.graphics.Bitmap originalDecodeFile(java.lang.String str) {
        return android.graphics.BitmapFactory.decodeFile(str);
    }

    @javax.annotation.Nullable
    public static android.graphics.Bitmap hookDecodeFileDescriptor(java.io.FileDescriptor fileDescriptor, @javax.annotation.Nullable android.graphics.Rect rect, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader.ensure();
        long jNativeSeek = nativeSeek(fileDescriptor, 0L, false);
        if (jNativeSeek != -1) {
            java.io.InputStream inputStreamWrapToMarkSupportedStream = wrapToMarkSupportedStream(new java.io.FileInputStream(fileDescriptor));
            try {
                getWebpHeader(inputStreamWrapToMarkSupportedStream, options);
                nativeSeek(fileDescriptor, jNativeSeek, true);
                android.graphics.Bitmap bitmapOriginalDecodeFileDescriptor = originalDecodeFileDescriptor(fileDescriptor, rect, options);
                if (bitmapOriginalDecodeFileDescriptor == null) {
                    sendWebpErrorLog("webp_direct_decode_fd_failed_on_no_webp");
                }
                return bitmapOriginalDecodeFileDescriptor;
            } finally {
                try {
                    inputStreamWrapToMarkSupportedStream.close();
                } catch (java.lang.Throwable unused) {
                }
            }
        }
        android.graphics.Bitmap bitmapHookDecodeStream = hookDecodeStream(new java.io.FileInputStream(fileDescriptor), rect, options);
        setPaddingDefaultValues(rect);
        return bitmapHookDecodeStream;
    }

    @javax.annotation.Nullable
    private static android.graphics.Bitmap originalDecodeFileDescriptor(java.io.FileDescriptor fileDescriptor, @javax.annotation.Nullable android.graphics.Rect rect, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        return android.graphics.BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
    }

    @javax.annotation.Nullable
    public static android.graphics.Bitmap hookDecodeFileDescriptor(java.io.FileDescriptor fileDescriptor) {
        return hookDecodeFileDescriptor(fileDescriptor, null, null);
    }

    @javax.annotation.Nullable
    private static android.graphics.Bitmap originalDecodeFileDescriptor(java.io.FileDescriptor fileDescriptor) {
        return android.graphics.BitmapFactory.decodeFileDescriptor(fileDescriptor);
    }

    private static void setWebpBitmapOptions(@javax.annotation.Nullable android.graphics.Bitmap bitmap, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        setDensityFromOptions(bitmap, options);
        if (options != null) {
            options.outMimeType = "image/webp";
        }
    }

    private static boolean shouldPremultiply(@javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        if (options != null) {
            return options.inPremultiplied;
        }
        return true;
    }

    @javax.annotation.Nullable
    private static android.graphics.Bitmap createBitmap(int i, int i2, @javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        if (options != null && options.inBitmap != null && options.inBitmap.isMutable()) {
            return options.inBitmap;
        }
        return mBitmapCreator.createNakedBitmap(i, i2, android.graphics.Bitmap.Config.ARGB_8888);
    }

    private static byte[] getInTempStorageFromOptions(@javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        if (options != null && options.inTempStorage != null) {
            return options.inTempStorage;
        }
        return new byte[8192];
    }

    private static float getScaleFromOptions(@javax.annotation.Nullable android.graphics.BitmapFactory.Options options) {
        float f = 1.0f;
        if (options != null) {
            int i = options.inSampleSize;
            f = i > 1 ? 1.0f / i : 1.0f;
            if (options.inScaled) {
                int i2 = options.inDensity;
                int i3 = options.inTargetDensity;
                int i4 = options.inScreenDensity;
                if (i2 != 0 && i3 != 0 && i2 != i4) {
                    return i3 / i2;
                }
            }
        }
        return f;
    }

    private static void sendWebpErrorLog(java.lang.String str) {
        com.facebook.common.webp.WebpBitmapFactory.WebpErrorLogger webpErrorLogger = mWebpErrorLogger;
        if (webpErrorLogger != null) {
            webpErrorLogger.onWebpErrorLog(str, "decoding_failure");
        }
    }
}
