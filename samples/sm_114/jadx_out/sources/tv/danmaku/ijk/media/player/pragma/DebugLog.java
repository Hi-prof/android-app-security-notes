package tv.danmaku.ijk.media.player.pragma;

/* JADX INFO: loaded from: classes2.dex */
public class DebugLog {
    public static final boolean ENABLE_DEBUG = true;
    public static final boolean ENABLE_ERROR = true;
    public static final boolean ENABLE_INFO = true;
    public static final boolean ENABLE_VERBOSE = true;
    public static final boolean ENABLE_WARN = true;

    public static void e(java.lang.String str, java.lang.String str2) {
        android.util.Log.e(str, str2);
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        android.util.Log.e(str, str2, th);
    }

    public static void efmt(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        android.util.Log.e(str, java.lang.String.format(java.util.Locale.US, str2, objArr));
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        android.util.Log.i(str, str2);
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        android.util.Log.i(str, str2, th);
    }

    public static void ifmt(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        android.util.Log.i(str, java.lang.String.format(java.util.Locale.US, str2, objArr));
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        android.util.Log.w(str, str2);
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        android.util.Log.w(str, str2, th);
    }

    public static void wfmt(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        android.util.Log.w(str, java.lang.String.format(java.util.Locale.US, str2, objArr));
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        android.util.Log.d(str, str2);
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        android.util.Log.d(str, str2, th);
    }

    public static void dfmt(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        android.util.Log.d(str, java.lang.String.format(java.util.Locale.US, str2, objArr));
    }

    public static void v(java.lang.String str, java.lang.String str2) {
        android.util.Log.v(str, str2);
    }

    public static void v(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        android.util.Log.v(str, str2, th);
    }

    public static void vfmt(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        android.util.Log.v(str, java.lang.String.format(java.util.Locale.US, str2, objArr));
    }

    public static void printStackTrace(java.lang.Throwable th) {
        th.printStackTrace();
    }

    public static void printCause(java.lang.Throwable th) {
        java.lang.Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        printStackTrace(th);
    }
}
