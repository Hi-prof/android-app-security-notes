package com.alibaba.android.bindingx.core;

/* JADX INFO: loaded from: classes.dex */
public final class LogProxy {
    private static final java.lang.String KEY_DEBUG = "debug";
    public static boolean sEnableLog = false;

    public static void enableLogIfNeeded(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.Object obj;
        boolean zEquals;
        if (map == null || (obj = map.get("debug")) == null) {
            return;
        }
        if (obj instanceof java.lang.Boolean) {
            zEquals = ((java.lang.Boolean) obj).booleanValue();
        } else {
            zEquals = obj instanceof java.lang.String ? io.dcloud.common.constant.AbsoluteConst.TRUE.equals((java.lang.String) obj) : false;
        }
        sEnableLog = zEquals;
    }

    public static void i(java.lang.String str) {
        if (sEnableLog) {
            android.util.Log.i(com.alibaba.android.bindingx.core.internal.BindingXConstants.TAG, str);
        }
    }

    public static void i(java.lang.String str, java.lang.Throwable th) {
        if (sEnableLog) {
            android.util.Log.i(com.alibaba.android.bindingx.core.internal.BindingXConstants.TAG, str, th);
        }
    }

    public static void v(java.lang.String str) {
        if (sEnableLog) {
            android.util.Log.v(com.alibaba.android.bindingx.core.internal.BindingXConstants.TAG, str);
        }
    }

    public static void v(java.lang.String str, java.lang.Throwable th) {
        if (sEnableLog) {
            android.util.Log.v(com.alibaba.android.bindingx.core.internal.BindingXConstants.TAG, str, th);
        }
    }

    public static void d(java.lang.String str) {
        if (sEnableLog) {
            android.util.Log.d(com.alibaba.android.bindingx.core.internal.BindingXConstants.TAG, str);
        }
    }

    public static void d(java.lang.String str, java.lang.Throwable th) {
        if (sEnableLog) {
            android.util.Log.d(com.alibaba.android.bindingx.core.internal.BindingXConstants.TAG, str, th);
        }
    }

    public static void w(java.lang.String str) {
        if (sEnableLog) {
            android.util.Log.w(com.alibaba.android.bindingx.core.internal.BindingXConstants.TAG, str);
        }
    }

    public static void w(java.lang.String str, java.lang.Throwable th) {
        if (sEnableLog) {
            android.util.Log.w(com.alibaba.android.bindingx.core.internal.BindingXConstants.TAG, str, th);
        }
    }

    public static void e(java.lang.String str) {
        if (sEnableLog) {
            android.util.Log.e(com.alibaba.android.bindingx.core.internal.BindingXConstants.TAG, str);
        }
    }

    public static void e(java.lang.String str, java.lang.Throwable th) {
        if (sEnableLog) {
            android.util.Log.e(com.alibaba.android.bindingx.core.internal.BindingXConstants.TAG, str, th);
        }
    }
}
