package tv.cjump.jni;

/* JADX INFO: loaded from: classes2.dex */
public class NativeBitmapFactory {
    static java.lang.reflect.Field nativeIntField = null;
    static boolean nativeLibLoaded = false;
    static boolean notLoadAgain = false;

    private static native android.graphics.Bitmap createBitmap(int i, int i2, int i3, boolean z);

    private static native android.graphics.Bitmap createBitmap19(int i, int i2, int i3, boolean z);

    private static native boolean init();

    private static native boolean release();

    public static boolean isInNativeAlloc() {
        return nativeLibLoaded && nativeIntField != null;
    }

    public static void loadLibs() {
        if (notLoadAgain) {
            return;
        }
        if (!tv.cjump.jni.DeviceUtils.isRealARMArch() && !tv.cjump.jni.DeviceUtils.isRealX86Arch()) {
            notLoadAgain = true;
            nativeLibLoaded = false;
            return;
        }
        if (nativeLibLoaded) {
            return;
        }
        try {
            if (android.os.Build.VERSION.SDK_INT < 23) {
                java.lang.System.loadLibrary("ndkbitmap");
                nativeLibLoaded = true;
            } else {
                notLoadAgain = true;
                nativeLibLoaded = false;
            }
        } catch (java.lang.Error e) {
            e.printStackTrace();
            notLoadAgain = true;
            nativeLibLoaded = false;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            notLoadAgain = true;
            nativeLibLoaded = false;
        }
        if (nativeLibLoaded) {
            if (!init()) {
                release();
                notLoadAgain = true;
                nativeLibLoaded = false;
            } else {
                initField();
                if (!testLib()) {
                    release();
                    notLoadAgain = true;
                    nativeLibLoaded = false;
                }
            }
        }
        android.util.Log.e("NativeBitmapFactory", io.dcloud.common.constant.AbsoluteConst.EVENTS_LOADED + nativeLibLoaded);
    }

    public static void releaseLibs() {
        if (nativeLibLoaded) {
            release();
        }
        nativeIntField = null;
        nativeLibLoaded = false;
    }

    static void initField() {
        try {
            java.lang.reflect.Field declaredField = android.graphics.Bitmap.Config.class.getDeclaredField("nativeInt");
            nativeIntField = declaredField;
            declaredField.setAccessible(true);
        } catch (java.lang.NoSuchFieldException e) {
            nativeIntField = null;
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0069 A[ExcHandler: Exception -> 0x0069, PHI: r3
  0x0069: PHI (r3v1 android.graphics.Bitmap) = (r3v0 android.graphics.Bitmap), (r3v4 android.graphics.Bitmap) binds: [B:36:0x0009, B:37:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:31:0x0081 A[DONT_GENERATE] */
    private static boolean testLib() {
        if (nativeIntField == null) {
            return false;
        }
        android.graphics.Bitmap bitmapCreateNativeBitmap = null;
        try {
            bitmapCreateNativeBitmap = createNativeBitmap(2, 2, android.graphics.Bitmap.Config.ARGB_8888, true);
            boolean zIsPremultiplied = bitmapCreateNativeBitmap != null && bitmapCreateNativeBitmap.getWidth() == 2 && bitmapCreateNativeBitmap.getHeight() == 2;
            if (zIsPremultiplied) {
                if (!bitmapCreateNativeBitmap.isPremultiplied()) {
                    bitmapCreateNativeBitmap.setPremultiplied(true);
                }
                android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateNativeBitmap);
                android.graphics.Paint paint = new android.graphics.Paint();
                paint.setColor(-65536);
                paint.setTextSize(20.0f);
                canvas.drawRect(0.0f, 0.0f, bitmapCreateNativeBitmap.getWidth(), bitmapCreateNativeBitmap.getHeight(), paint);
                canvas.drawText("TestLib", 0.0f, 0.0f, paint);
                zIsPremultiplied = bitmapCreateNativeBitmap.isPremultiplied();
            }
            return zIsPremultiplied;
        } catch (java.lang.Exception e) {
            android.util.Log.e("NativeBitmapFactory", "exception:" + e.toString());
            return false;
        } catch (java.lang.Error unused) {
            return false;
        } finally {
            if (bitmapCreateNativeBitmap != null) {
                bitmapCreateNativeBitmap.recycle();
            }
        }
    }

    public static int getNativeConfig(android.graphics.Bitmap.Config config) {
        try {
            java.lang.reflect.Field field = nativeIntField;
            if (field == null) {
                return 0;
            }
            return field.getInt(config);
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        } catch (java.lang.IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static android.graphics.Bitmap createBitmap(int i, int i2, android.graphics.Bitmap.Config config) {
        return createBitmap(i, i2, config, config.equals(android.graphics.Bitmap.Config.ARGB_8888));
    }

    public static void recycle(android.graphics.Bitmap bitmap) {
        bitmap.recycle();
    }

    public static android.graphics.Bitmap createBitmap(int i, int i2, android.graphics.Bitmap.Config config, boolean z) {
        if (!nativeLibLoaded || nativeIntField == null) {
            return android.graphics.Bitmap.createBitmap(i, i2, config);
        }
        return createNativeBitmap(i, i2, config, z);
    }

    private static android.graphics.Bitmap createNativeBitmap(int i, int i2, android.graphics.Bitmap.Config config, boolean z) {
        return createBitmap(i, i2, getNativeConfig(config), z);
    }
}
