package com.zui.opendeviceidlibrary;

/* JADX INFO: loaded from: classes.dex */
public class OpenDeviceId {
    private static java.lang.String c = "OpenDeviceId library";
    private static boolean d;
    private com.zui.deviceidservice.IDeviceidInterface a;
    private com.zui.opendeviceidlibrary.OpenDeviceId.CallBack b;

    /* JADX INFO: renamed from: com.zui.opendeviceidlibrary.OpenDeviceId$1, reason: invalid class name */
    class AnonymousClass1 implements android.content.ServiceConnection {
        final /* synthetic */ com.zui.opendeviceidlibrary.OpenDeviceId a;

        @Override // android.content.ServiceConnection
        public native synchronized void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder);

        @Override // android.content.ServiceConnection
        public native void onServiceDisconnected(android.content.ComponentName componentName);
    }

    public interface CallBack {
        void a(com.zui.opendeviceidlibrary.OpenDeviceId openDeviceId);
    }

    static native /* synthetic */ com.zui.deviceidservice.IDeviceidInterface a(com.zui.opendeviceidlibrary.OpenDeviceId openDeviceId, com.zui.deviceidservice.IDeviceidInterface iDeviceidInterface);

    static native /* synthetic */ com.zui.opendeviceidlibrary.OpenDeviceId.CallBack a(com.zui.opendeviceidlibrary.OpenDeviceId openDeviceId);

    static native /* synthetic */ void a(com.zui.opendeviceidlibrary.OpenDeviceId openDeviceId, java.lang.String str);

    private native void a(java.lang.String str);
}
