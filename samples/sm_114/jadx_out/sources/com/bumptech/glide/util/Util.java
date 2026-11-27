package com.bumptech.glide.util;

/* JADX INFO: loaded from: classes.dex */
public final class Util {
    private static final int HASH_ACCUMULATOR = 17;
    private static final int HASH_MULTIPLIER = 31;
    private static final char[] HEX_CHAR_ARRAY = "0123456789abcdef".toCharArray();
    private static final char[] SHA_256_CHARS = new char[64];
    private static volatile android.os.Handler mainThreadHandler;

    public static int hashCode(int i, int i2) {
        return (i2 * 31) + i;
    }

    public static boolean isValidDimension(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    private Util() {
    }

    public static java.lang.String sha256BytesToHex(byte[] bArr) {
        java.lang.String strBytesToHex;
        char[] cArr = SHA_256_CHARS;
        synchronized (cArr) {
            strBytesToHex = bytesToHex(bArr, cArr);
        }
        return strBytesToHex;
    }

    private static java.lang.String bytesToHex(byte[] bArr, char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = HEX_CHAR_ARRAY;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new java.lang.String(cArr);
    }

    @java.lang.Deprecated
    public static int getSize(android.graphics.Bitmap bitmap) {
        return getBitmapByteSize(bitmap);
    }

    public static int getBitmapByteSize(android.graphics.Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            throw new java.lang.IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + com.taobao.weex.el.parse.Operators.ARRAY_START_STR + bitmap.getWidth() + com.taobao.weex.common.Constants.Name.X + bitmap.getHeight() + "] " + bitmap.getConfig());
        }
        try {
            return bitmap.getAllocationByteCount();
        } catch (java.lang.NullPointerException unused) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
    }

    public static int getBitmapByteSize(int i, int i2, android.graphics.Bitmap.Config config) {
        return i * i2 * getBytesPerPixel(config);
    }

    public static int getBytesPerPixel(android.graphics.Bitmap.Config config) {
        if (config == null) {
            config = android.graphics.Bitmap.Config.ARGB_8888;
        }
        int i = com.bumptech.glide.util.Util.AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2 && i != 3) {
                return i != 4 ? 4 : 8;
            }
        }
        return i2;
    }

    /* JADX INFO: renamed from: com.bumptech.glide.util.Util$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] iArr = new int[android.graphics.Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[android.graphics.Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public static boolean isValidDimensions(int i, int i2) {
        return isValidDimension(i) && isValidDimension(i2);
    }

    public static void postOnUiThread(java.lang.Runnable runnable) {
        getUiThreadHandler().post(runnable);
    }

    public static void removeCallbacksOnUiThread(java.lang.Runnable runnable) {
        getUiThreadHandler().removeCallbacks(runnable);
    }

    private static android.os.Handler getUiThreadHandler() {
        if (mainThreadHandler == null) {
            synchronized (com.bumptech.glide.util.Util.class) {
                if (mainThreadHandler == null) {
                    mainThreadHandler = new android.os.Handler(android.os.Looper.getMainLooper());
                }
            }
        }
        return mainThreadHandler;
    }

    public static void assertMainThread() {
        if (!isOnMainThread()) {
            throw new java.lang.IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static void assertBackgroundThread() {
        if (!isOnBackgroundThread()) {
            throw new java.lang.IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static boolean isOnMainThread() {
        return android.os.Looper.myLooper() == android.os.Looper.getMainLooper();
    }

    public static boolean isOnBackgroundThread() {
        return !isOnMainThread();
    }

    public static <T> java.util.Queue<T> createQueue(int i) {
        return new java.util.ArrayDeque(i);
    }

    public static <T> java.util.List<T> getSnapshot(java.util.Collection<T> collection) {
        java.util.ArrayList arrayList = new java.util.ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static boolean bothNullOrEqual(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean bothModelsNullEquivalentOrEquals(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj instanceof com.bumptech.glide.load.model.Model) {
            return ((com.bumptech.glide.load.model.Model) obj).isEquivalentTo(obj2);
        }
        return obj.equals(obj2);
    }

    public static boolean bothBaseRequestOptionsNullEquivalentOrEquals(com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions, com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions2) {
        if (baseRequestOptions == null) {
            return baseRequestOptions2 == null;
        }
        return baseRequestOptions.isEquivalentTo(baseRequestOptions2);
    }

    public static int hashCode(int i) {
        return hashCode(i, 17);
    }

    public static int hashCode(float f) {
        return hashCode(f, 17);
    }

    public static int hashCode(float f, int i) {
        return hashCode(java.lang.Float.floatToIntBits(f), i);
    }

    public static int hashCode(java.lang.Object obj, int i) {
        return hashCode(obj == null ? 0 : obj.hashCode(), i);
    }

    public static int hashCode(boolean z, int i) {
        return hashCode(z ? 1 : 0, i);
    }

    public static int hashCode(boolean z) {
        return hashCode(z, 17);
    }
}
