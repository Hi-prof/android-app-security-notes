package io.dcloud.feature.uniapp.utils;

/* JADX INFO: loaded from: classes2.dex */
public class UniLogUtils extends com.taobao.weex.utils.WXLogUtils {
    public static final java.lang.String UNI_PERF_TAG = "uni_perf";
    public static final java.lang.String UNI_TAG = "uni";

    public static void v(java.lang.String str) {
        v(UNI_TAG, str);
    }

    public static void d(java.lang.String str) {
        d(UNI_TAG, str);
    }

    public static void d(java.lang.String str, byte[] bArr) {
        d(str, new java.lang.String(bArr));
    }

    public static void i(java.lang.String str) {
        i(UNI_TAG, str);
    }

    public static void i(java.lang.String str, byte[] bArr) {
        i(str, new java.lang.String(bArr));
    }

    public static void info(java.lang.String str) {
        i(UNI_TAG, str);
    }

    public static void w(java.lang.String str) {
        w(UNI_TAG, str);
    }

    public static void w(java.lang.String str, byte[] bArr) {
        w(str, new java.lang.String(bArr));
    }

    public static void e(java.lang.String str) {
        e(UNI_TAG, str);
    }

    public static void e(java.lang.String str, byte[] bArr) {
        e(str, new java.lang.String(bArr));
    }
}
