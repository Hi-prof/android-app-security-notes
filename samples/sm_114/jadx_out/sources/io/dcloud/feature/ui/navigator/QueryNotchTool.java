package io.dcloud.feature.ui.navigator;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class QueryNotchTool {
    public static final int NOTCH_IN_SCREEN_VOIO = 32;
    public static final int ROUNDED_IN_SCREEN_VOIO = 8;

    public static boolean hasNotchInHuawei(android.content.Context context) {
        try {
            java.lang.Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            java.lang.reflect.Method method = clsLoadClass.getMethod("hasNotchInScreen", null);
            if (method != null) {
                return ((java.lang.Boolean) method.invoke(clsLoadClass, null)).booleanValue();
            }
            return false;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean hasNotchInOppo(android.content.Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean hasNotchInScreen(android.app.Activity activity) {
        if (io.dcloud.common.adapter.util.MobilePhoneModel.isAppointPhone(io.dcloud.common.adapter.util.MobilePhoneModel.XIAOMI)) {
            return hasNotchInXiaomi(activity);
        }
        if (io.dcloud.common.adapter.util.MobilePhoneModel.isAppointPhone(io.dcloud.common.adapter.util.MobilePhoneModel.VIVO)) {
            return hasNotchInVoio(activity);
        }
        if (io.dcloud.common.adapter.util.MobilePhoneModel.isAppointPhone(io.dcloud.common.adapter.util.MobilePhoneModel.OPPO)) {
            return hasNotchInOppo(activity);
        }
        if (io.dcloud.common.adapter.util.MobilePhoneModel.isAppointPhone(io.dcloud.common.adapter.util.MobilePhoneModel.HUAWEI) || io.dcloud.common.adapter.util.MobilePhoneModel.isAppointPhone(io.dcloud.common.adapter.util.MobilePhoneModel.HONOR)) {
            return hasNotchInHuawei(activity);
        }
        return isAndroidP(activity) != null;
    }

    public static boolean hasNotchInVoio(android.content.Context context) {
        try {
            java.lang.Class<?> clsLoadClass = context.getClassLoader().loadClass("com.util.FtFeature");
            return ((java.lang.Boolean) clsLoadClass.getMethod("isFeatureSupport", java.lang.Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean hasNotchInXiaomi(android.content.Context context) {
        try {
            return ((java.lang.Integer) java.lang.Class.forName("android.os.SystemProperties").getDeclaredMethod("getInt", java.lang.String.class, java.lang.Integer.TYPE).invoke(null, "ro.miui.notch", 0)).intValue() == 1;
        } catch (java.lang.Exception unused) {
        }
    }

    public static android.view.DisplayCutout isAndroidP(android.app.Activity activity) {
        android.view.WindowInsets rootWindowInsets;
        android.view.View decorView = activity.getWindow().getDecorView();
        if (decorView == null || android.os.Build.VERSION.SDK_INT < 28 || (rootWindowInsets = decorView.getRootWindowInsets()) == null) {
            return null;
        }
        return rootWindowInsets.getDisplayCutout();
    }
}
