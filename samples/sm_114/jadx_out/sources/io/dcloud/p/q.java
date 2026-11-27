package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class q {
    private static final java.lang.String[] a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    public static boolean a(android.content.Context context) {
        try {
            return android.provider.Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled") == 1;
        } catch (java.lang.Exception unused) {
        }
    }

    public static boolean b(android.content.Context context) {
        return android.provider.Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) == 1;
    }

    public static boolean c(android.content.Context context) {
        java.lang.String property = java.lang.System.getProperty("http.proxyHost");
        java.lang.String property2 = java.lang.System.getProperty("http.proxyPort");
        if (property2 == null) {
            property2 = "-1";
        }
        return (android.text.TextUtils.isEmpty(property) || java.lang.Integer.parseInt(property2) == -1) ? false : true;
    }

    public static boolean a() {
        boolean z;
        java.lang.String[] strArr = a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (new java.io.File(strArr[i]).exists()) {
                z = true;
                break;
            }
            i++;
        }
        java.lang.String str = android.os.Build.TAGS;
        return (str != null && str.contains("test-keys")) || z;
    }
}
