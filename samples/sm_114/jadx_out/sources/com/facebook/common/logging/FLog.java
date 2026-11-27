package com.facebook.common.logging;

/* JADX INFO: loaded from: classes.dex */
public class FLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static com.facebook.common.logging.LoggingDelegate sHandler = com.facebook.common.logging.FLogDefaultLoggingDelegate.getInstance();

    public static void setLoggingDelegate(com.facebook.common.logging.LoggingDelegate loggingDelegate) {
        if (loggingDelegate == null) {
            throw new java.lang.IllegalArgumentException();
        }
        sHandler = loggingDelegate;
    }

    public static boolean isLoggable(int i) {
        return sHandler.isLoggable(i);
    }

    public static void setMinimumLoggingLevel(int i) {
        sHandler.setMinimumLoggingLevel(i);
    }

    public static int getMinimumLoggingLevel() {
        return sHandler.getMinimumLoggingLevel();
    }

    public static void v(java.lang.String str, java.lang.String str2) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(str, str2);
        }
    }

    public static void v(java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(str, formatString(str2, obj));
        }
    }

    public static void v(java.lang.String str, java.lang.String str2, java.lang.Object obj, java.lang.Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(str, formatString(str2, obj, obj2));
        }
    }

    public static void v(java.lang.String str, java.lang.String str2, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(str, formatString(str2, obj, obj2, obj3));
        }
    }

    public static void v(java.lang.String str, java.lang.String str2, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    public static void v(java.lang.Class<?> cls, java.lang.String str) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), str);
        }
    }

    public static void v(java.lang.Class<?> cls, java.lang.String str, java.lang.Object obj) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), formatString(str, obj));
        }
    }

    public static void v(java.lang.Class<?> cls, java.lang.String str, java.lang.Object obj, java.lang.Object obj2) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), formatString(str, obj, obj2));
        }
    }

    public static void v(java.lang.Class<?> cls, java.lang.String str, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        if (isLoggable(2)) {
            v(cls, formatString(str, obj, obj2, obj3));
        }
    }

    public static void v(java.lang.Class<?> cls, java.lang.String str, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    public static void v(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(str, formatString(str2, objArr));
        }
    }

    public static void v(java.lang.String str, java.lang.Throwable th, java.lang.String str2, java.lang.Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(str, formatString(str2, objArr), th);
        }
    }

    public static void v(java.lang.Class<?> cls, java.lang.String str, java.lang.Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), formatString(str, objArr));
        }
    }

    public static void v(java.lang.Class<?> cls, java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void v(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(str, str2, th);
        }
    }

    public static void v(java.lang.Class<?> cls, java.lang.String str, java.lang.Throwable th) {
        if (sHandler.isLoggable(2)) {
            sHandler.v(getTag(cls), str, th);
        }
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(str, str2);
        }
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(str, formatString(str2, obj));
        }
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Object obj, java.lang.Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(str, formatString(str2, obj, obj2));
        }
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(str, formatString(str2, obj, obj2, obj3));
        }
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    public static void d(java.lang.Class<?> cls, java.lang.String str) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), str);
        }
    }

    public static void d(java.lang.Class<?> cls, java.lang.String str, java.lang.Object obj) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), formatString(str, obj));
        }
    }

    public static void d(java.lang.Class<?> cls, java.lang.String str, java.lang.Object obj, java.lang.Object obj2) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), formatString(str, obj, obj2));
        }
    }

    public static void d(java.lang.Class<?> cls, java.lang.String str, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    public static void d(java.lang.Class<?> cls, java.lang.String str, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (sHandler.isLoggable(3)) {
            d(str, formatString(str2, objArr));
        }
    }

    public static void d(java.lang.String str, java.lang.Throwable th, java.lang.String str2, java.lang.Object... objArr) {
        if (sHandler.isLoggable(3)) {
            d(str, formatString(str2, objArr), th);
        }
    }

    public static void d(java.lang.Class<?> cls, java.lang.String str, java.lang.Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), formatString(str, objArr));
        }
    }

    public static void d(java.lang.Class<?> cls, java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(str, str2, th);
        }
    }

    public static void d(java.lang.Class<?> cls, java.lang.String str, java.lang.Throwable th) {
        if (sHandler.isLoggable(3)) {
            sHandler.d(getTag(cls), str, th);
        }
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(str, str2);
        }
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(str, formatString(str2, obj));
        }
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.Object obj, java.lang.Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(str, formatString(str2, obj, obj2));
        }
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(str, formatString(str2, obj, obj2, obj3));
        }
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(str, formatString(str2, obj, obj2, obj3, obj4));
        }
    }

    public static void i(java.lang.Class<?> cls, java.lang.String str) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), str);
        }
    }

    public static void i(java.lang.Class<?> cls, java.lang.String str, java.lang.Object obj) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), formatString(str, obj));
        }
    }

    public static void i(java.lang.Class<?> cls, java.lang.String str, java.lang.Object obj, java.lang.Object obj2) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), formatString(str, obj, obj2));
        }
    }

    public static void i(java.lang.Class<?> cls, java.lang.String str, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), formatString(str, obj, obj2, obj3));
        }
    }

    public static void i(java.lang.Class<?> cls, java.lang.String str, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, java.lang.Object obj4) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), formatString(str, obj, obj2, obj3, obj4));
        }
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(str, formatString(str2, objArr));
        }
    }

    public static void i(java.lang.String str, java.lang.Throwable th, java.lang.String str2, java.lang.Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(str, formatString(str2, objArr), th);
        }
    }

    public static void i(java.lang.Class<?> cls, java.lang.String str, java.lang.Object... objArr) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), formatString(str, objArr));
        }
    }

    public static void i(java.lang.Class<?> cls, java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        if (isLoggable(4)) {
            sHandler.i(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(str, str2, th);
        }
    }

    public static void i(java.lang.Class<?> cls, java.lang.String str, java.lang.Throwable th) {
        if (sHandler.isLoggable(4)) {
            sHandler.i(getTag(cls), str, th);
        }
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        if (sHandler.isLoggable(5)) {
            sHandler.w(str, str2);
        }
    }

    public static void w(java.lang.Class<?> cls, java.lang.String str) {
        if (sHandler.isLoggable(5)) {
            sHandler.w(getTag(cls), str);
        }
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.w(str, formatString(str2, objArr));
        }
    }

    public static void w(java.lang.String str, java.lang.Throwable th, java.lang.String str2, java.lang.Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.w(str, formatString(str2, objArr), th);
        }
    }

    public static void w(java.lang.Class<?> cls, java.lang.String str, java.lang.Object... objArr) {
        if (sHandler.isLoggable(5)) {
            sHandler.w(getTag(cls), formatString(str, objArr));
        }
    }

    public static void w(java.lang.Class<?> cls, java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        if (isLoggable(5)) {
            w(cls, formatString(str, objArr), th);
        }
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.w(str, str2, th);
        }
    }

    public static void w(java.lang.Class<?> cls, java.lang.String str, java.lang.Throwable th) {
        if (sHandler.isLoggable(5)) {
            sHandler.w(getTag(cls), str, th);
        }
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.e(str, str2);
        }
    }

    public static void e(java.lang.Class<?> cls, java.lang.String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.e(getTag(cls), str);
        }
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.e(str, formatString(str2, objArr));
        }
    }

    public static void e(java.lang.String str, java.lang.Throwable th, java.lang.String str2, java.lang.Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.e(str, formatString(str2, objArr), th);
        }
    }

    public static void e(java.lang.Class<?> cls, java.lang.String str, java.lang.Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.e(getTag(cls), formatString(str, objArr));
        }
    }

    public static void e(java.lang.Class<?> cls, java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.e(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.e(str, str2, th);
        }
    }

    public static void e(java.lang.Class<?> cls, java.lang.String str, java.lang.Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.e(getTag(cls), str, th);
        }
    }

    public static void wtf(java.lang.String str, java.lang.String str2) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2);
        }
    }

    public static void wtf(java.lang.Class<?> cls, java.lang.String str) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str);
        }
    }

    public static void wtf(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr));
        }
    }

    public static void wtf(java.lang.String str, java.lang.Throwable th, java.lang.String str2, java.lang.Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, formatString(str2, objArr), th);
        }
    }

    public static void wtf(java.lang.Class<?> cls, java.lang.String str, java.lang.Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr));
        }
    }

    public static void wtf(java.lang.Class<?> cls, java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), formatString(str, objArr), th);
        }
    }

    public static void wtf(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(str, str2, th);
        }
    }

    public static void wtf(java.lang.Class<?> cls, java.lang.String str, java.lang.Throwable th) {
        if (sHandler.isLoggable(6)) {
            sHandler.wtf(getTag(cls), str, th);
        }
    }

    private static java.lang.String formatString(java.lang.String str, java.lang.Object... objArr) {
        return java.lang.String.format(null, str, objArr);
    }

    private static java.lang.String getTag(java.lang.Class<?> cls) {
        return cls.getSimpleName();
    }
}
