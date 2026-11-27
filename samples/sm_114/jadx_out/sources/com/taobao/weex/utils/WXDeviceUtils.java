package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class WXDeviceUtils {
    public static boolean isAutoResize(android.content.Context context) {
        if (context == null) {
            return false;
        }
        return isMateX(context) || isGalaxyFold(context);
    }

    public static boolean isMateX(android.content.Context context) {
        if ("HUAWEI".equalsIgnoreCase(android.os.Build.BRAND)) {
            return "unknownRLI".equalsIgnoreCase(android.os.Build.DEVICE) || "HWTAH".equalsIgnoreCase(android.os.Build.DEVICE);
        }
        return false;
    }

    public static boolean isGalaxyFold(android.content.Context context) {
        return "samsung".equalsIgnoreCase(android.os.Build.BRAND) && "SM-F9000".equalsIgnoreCase(android.os.Build.MODEL);
    }
}
