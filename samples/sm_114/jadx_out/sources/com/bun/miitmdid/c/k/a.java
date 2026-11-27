package com.bun.miitmdid.c.k;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static java.lang.Object a;
    private static java.lang.Class<?> b;
    private static java.lang.reflect.Method c;
    private static java.lang.reflect.Method d;
    private static java.lang.reflect.Method e;

    static {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            a = cls.newInstance();
        } catch (java.lang.Exception e2) {
            com.bun.lib.a.a("IdentifierManager", "reflect exception!", e2);
        }
        try {
            java.lang.Class<?> cls2 = b;
            if (cls2 != null) {
                c = cls2.getMethod("getOAID", android.content.Context.class);
            }
        } catch (java.lang.Exception e3) {
            com.bun.lib.a.a("IdentifierManager", "reflect exception!", e3);
        }
        try {
            java.lang.Class<?> cls3 = b;
            if (cls3 != null) {
                d = cls3.getMethod("getVAID", android.content.Context.class);
            }
        } catch (java.lang.Exception e4) {
            com.bun.lib.a.a("IdentifierManager", "reflect exception!", e4);
        }
        try {
            java.lang.Class<?> cls4 = b;
            if (cls4 != null) {
                e = cls4.getMethod("getAAID", android.content.Context.class);
            }
        } catch (java.lang.Exception e5) {
            com.bun.lib.a.a("IdentifierManager", "reflect exception!", e5);
        }
    }

    public static native java.lang.String a(android.content.Context context);

    private static native java.lang.String a(android.content.Context context, java.lang.reflect.Method method);

    public static native boolean a();

    public static native java.lang.String b(android.content.Context context);

    public static native java.lang.String c(android.content.Context context);
}
