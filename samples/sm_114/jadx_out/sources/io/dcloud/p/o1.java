package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class o1 {
    private static volatile io.dcloud.p.o1 a;

    private o1() {
    }

    public static io.dcloud.p.o1 a() {
        if (a == null) {
            synchronized (io.dcloud.p.o1.class) {
                if (a == null) {
                    a = new io.dcloud.p.o1();
                }
            }
        }
        return a;
    }

    public java.lang.String a(android.content.Context context) {
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.containsKey("com.google.android.gms.ads.APPLICATION_ID")) {
                java.lang.reflect.Method declaredMethod = java.lang.Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getDeclaredMethod("getAdvertisingIdInfo", android.content.Context.class);
                declaredMethod.setAccessible(true);
                java.lang.Object objInvoke = declaredMethod.invoke(null, context);
                java.lang.reflect.Method declaredMethod2 = objInvoke.getClass().getDeclaredMethod("getId", null);
                declaredMethod2.setAccessible(true);
                return (java.lang.String) declaredMethod2.invoke(objInvoke, null);
            }
            return "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }
}
