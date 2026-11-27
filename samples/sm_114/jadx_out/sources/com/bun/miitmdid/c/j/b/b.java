package com.bun.miitmdid.c.j.b;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static android.content.Context a;
    private static boolean b;
    private static com.bun.miitmdid.c.j.b.b c;
    private static com.bun.miitmdid.c.j.b.a d;
    private static com.bun.miitmdid.c.j.b.c e;
    private static com.bun.miitmdid.c.j.b.c f;
    private static com.bun.miitmdid.c.j.b.c g;
    private static java.lang.Object h = new java.lang.Object();
    private static android.os.HandlerThread i;
    private static android.os.Handler j;
    private static java.lang.String k;
    private static java.lang.String l;
    private static java.lang.String m;
    private static java.lang.String n;

    static final class a extends android.os.Handler {
        a(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public native void handleMessage(android.os.Message message);
    }

    private b() {
    }

    public static native com.bun.miitmdid.c.j.b.b a(android.content.Context context);

    public static native java.lang.String a(java.lang.String str, java.lang.String str2);

    private static native void a(android.content.Context context, int i2, java.lang.String str);

    private native void b(int i2, java.lang.String str);

    static native /* synthetic */ com.bun.miitmdid.c.j.b.a c();

    static native /* synthetic */ java.lang.String c(java.lang.String str);

    static native /* synthetic */ java.lang.Object d();

    public static native void e();

    private static native void f();

    public native java.lang.String a();

    public native java.lang.String a(java.lang.String str);

    public native void a(int i2, java.lang.String str);

    public native java.lang.String b(java.lang.String str);

    public native boolean b();
}
