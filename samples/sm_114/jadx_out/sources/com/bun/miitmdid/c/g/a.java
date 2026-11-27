package com.bun.miitmdid.c.g;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static java.lang.String e = "OpenDeviceId library";
    private static boolean f;
    private android.content.Context a;
    private com.zui.deviceidservice.IDeviceidInterface b;
    private android.content.ServiceConnection c;
    private com.bun.miitmdid.c.e.a d;

    /* JADX INFO: renamed from: com.bun.miitmdid.c.g.a$a, reason: collision with other inner class name */
    class ServiceConnectionC0012a implements android.content.ServiceConnection {
        ServiceConnectionC0012a() {
        }

        @Override // android.content.ServiceConnection
        public native synchronized void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder);

        @Override // android.content.ServiceConnection
        public native void onServiceDisconnected(android.content.ComponentName componentName);
    }

    public a(android.content.Context context, com.bun.miitmdid.c.e.a aVar) {
        this.a = null;
        if (context == null) {
            throw new java.lang.NullPointerException("Context can not be null.");
        }
        this.a = context;
        this.d = aVar;
        this.c = new com.bun.miitmdid.c.g.a.ServiceConnectionC0012a();
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.a.bindService(intent, this.c, 1)) {
            b("bindService Successful!");
            return;
        }
        b("bindService Failed!");
        com.bun.miitmdid.c.e.a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    static native /* synthetic */ com.bun.miitmdid.c.e.a a(com.bun.miitmdid.c.g.a aVar);

    static native /* synthetic */ com.zui.deviceidservice.IDeviceidInterface a(com.bun.miitmdid.c.g.a aVar, com.zui.deviceidservice.IDeviceidInterface iDeviceidInterface);

    static native /* synthetic */ void a(com.bun.miitmdid.c.g.a aVar, java.lang.String str);

    private native void a(java.lang.String str);

    private native void b(java.lang.String str);

    public native java.lang.String a();

    public native java.lang.String b();

    public native java.lang.String c();

    public native java.lang.String d();

    public native boolean e();

    public native void f();
}
