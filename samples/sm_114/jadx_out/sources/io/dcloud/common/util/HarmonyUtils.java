package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class HarmonyUtils {
    public static java.lang.String getHarmonyDisplayVersion() {
        return android.os.Build.DISPLAY;
    }

    public static java.lang.String getHarmonyVersion() {
        return getProp("hw_sc.build.platform.version", "");
    }

    private static java.lang.String getProp(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            java.lang.String str3 = (java.lang.String) cls.getDeclaredMethod("get", java.lang.String.class).invoke(cls, str);
            return android.text.TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    public static boolean isHarmonyOs() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.system.BuildEx");
            return "Harmony".equalsIgnoreCase(cls.getMethod("getOsBrand", null).invoke(cls, null).toString());
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }
}
