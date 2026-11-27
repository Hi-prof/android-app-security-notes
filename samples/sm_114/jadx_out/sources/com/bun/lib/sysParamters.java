package com.bun.lib;

/* JADX INFO: loaded from: classes.dex */
public class sysParamters {
    private static volatile com.bun.lib.sysParamters d;
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String sdk_version = "10012";
    private java.lang.String sdk_vname = "1.0.12";

    private sysParamters() {
    }

    private static native android.content.pm.PackageInfo a(android.content.Context context, java.lang.String str);

    public static native java.lang.String a(android.content.Context context);

    public static native java.lang.String a(java.lang.String str, java.lang.String str2);

    public static native java.lang.String e();

    public static native com.bun.lib.sysParamters f();

    public static native java.lang.String g();

    private static native java.lang.String h();

    public native java.lang.String a();

    public native java.lang.String b();

    public native java.lang.String c();

    public native java.lang.String d();
}
