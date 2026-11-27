package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class l0 {
    public static java.lang.Object a() {
        try {
            java.lang.String str = io.dcloud.common.util.BaseInfo.sGlobalUserAgent;
            java.lang.reflect.Field declaredField = io.dcloud.common.util.BaseInfo.class.getDeclaredField("sBaseVersion");
            declaredField.setAccessible(true);
            return declaredField.get(io.dcloud.common.util.BaseInfo.class);
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.NoSuchFieldException unused) {
            return io.dcloud.sdk.core.DCloudAOLManager.getVersion();
        }
    }

    public static int c() {
        return 0;
    }

    public static java.lang.String b() {
        try {
            return java.util.Locale.forLanguageTag((java.lang.String) java.lang.Class.forName("android.os.SystemProperties").getMethod("get", java.lang.String.class).invoke(null, "persist.sys.locale")).getCountry();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String a(android.content.Context context) {
        java.lang.String string;
        java.lang.String packageName = context.getPackageName();
        try {
            string = context.getPackageManager().getApplicationInfo(packageName, 128).metaData.getString("DCLOUD_STREAMAPP_CHANNEL");
        } catch (java.lang.Exception unused) {
            string = null;
        }
        if (!android.text.TextUtils.isEmpty(string)) {
            return string;
        }
        return packageName + "|" + io.dcloud.p.r0.d().b().getAppId() + "|" + io.dcloud.p.r0.d().b().getAdId();
    }
}
