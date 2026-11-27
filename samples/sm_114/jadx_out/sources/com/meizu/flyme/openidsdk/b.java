package com.meizu.flyme.openidsdk;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static volatile com.meizu.flyme.openidsdk.b g;
    public static boolean h;
    public java.lang.Boolean e;
    public android.content.BroadcastReceiver f;
    public com.meizu.flyme.openidsdk.OpenId a = new com.meizu.flyme.openidsdk.OpenId("udid");
    public com.meizu.flyme.openidsdk.OpenId b = new com.meizu.flyme.openidsdk.OpenId("oaid");
    public com.meizu.flyme.openidsdk.OpenId d = new com.meizu.flyme.openidsdk.OpenId("vaid");
    public com.meizu.flyme.openidsdk.OpenId c = new com.meizu.flyme.openidsdk.OpenId("aaid");

    public static native com.meizu.flyme.openidsdk.ValueData a(android.database.Cursor cursor);

    public static final native com.meizu.flyme.openidsdk.b a();

    public static native void b(java.lang.String str);

    public native com.meizu.flyme.openidsdk.OpenId a(java.lang.String str);

    public final native java.lang.String a(android.content.Context context, com.meizu.flyme.openidsdk.OpenId openId);

    public final native synchronized void a(android.content.Context context);

    public final native boolean a(android.content.Context context, boolean z);
}
