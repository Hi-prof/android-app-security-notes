package io.dcloud.media.weex.weex_video.ijkplayer.utils;

/* JADX INFO: loaded from: classes2.dex */
public final class NavUtils {
    private NavUtils() {
        throw new java.lang.RuntimeException("NavUtils cannot be initialized!");
    }

    public static int getNavigationBarHeight(android.content.Context context) {
        if (!checkDeviceHasNavigationBar(context)) {
            return 0;
        }
        android.content.res.Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", com.taobao.weex.WXEnvironment.OS));
    }

    public static boolean checkDeviceHasNavigationBar(android.content.Context context) {
        android.content.res.Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", com.taobao.weex.WXEnvironment.OS);
        boolean z = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            java.lang.String str = (java.lang.String) cls.getMethod("get", java.lang.String.class).invoke(cls, "qemu.hw.mainkeys");
            if ("1".equals(str)) {
                return false;
            }
            if (com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT.equals(str)) {
                return true;
            }
        } catch (java.lang.Exception unused) {
        }
        return z;
    }
}
