package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public class LogUtil {
    private LogUtil() {
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        android.util.Log.e(str, str2, th);
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        android.util.Log.e(str, str2);
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        android.util.Log.w(str, str2, th);
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        android.util.Log.w(str, str2);
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (isLoggable(str, 4)) {
            android.util.Log.i(str, str2, th);
        }
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        if (isLoggable(str, 4)) {
            android.util.Log.i(str, str2);
        }
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (isLoggable(str, 3)) {
            android.util.Log.d(str, str2, th);
        }
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        if (isLoggable(str, 3)) {
            android.util.Log.d(str, str2);
        }
    }

    public static void v(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (isLoggable(str, 2)) {
            android.util.Log.v(str, str2, th);
        }
    }

    public static void v(java.lang.String str, java.lang.String str2) {
        if (isLoggable(str, 2)) {
            android.util.Log.v(str, str2);
        }
    }

    private static boolean isLoggable(java.lang.String str, int i) {
        if (android.os.Build.VERSION.SDK_INT <= 25 && str.length() > 23) {
            return android.util.Log.isLoggable(str.substring(0, 23), i);
        }
        return android.util.Log.isLoggable(str, i);
    }
}
