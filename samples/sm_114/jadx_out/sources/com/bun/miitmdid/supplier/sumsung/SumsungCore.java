package com.bun.miitmdid.supplier.sumsung;

/* JADX INFO: loaded from: classes.dex */
public class SumsungCore {
    private static boolean DBG = false;
    private static java.lang.String SAMSUNGTAG = "Samsung_DeviceIdService";
    private static java.lang.String TAG = "SumsungCore library";
    private com.bun.miitmdid.c.e.a mCallerCallBack;
    private android.content.ServiceConnection mConnection;
    private android.content.Context mContext;
    private com.samsung.android.deviceidservice.IDeviceIdService mDeviceidInterface;

    class a implements android.content.ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public native synchronized void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder);

        @Override // android.content.ServiceConnection
        public native void onServiceDisconnected(android.content.ComponentName componentName);
    }

    public SumsungCore(android.content.Context context, com.bun.miitmdid.c.e.a aVar) {
        this.mContext = null;
        this.mCallerCallBack = null;
        if (context == null) {
            throw new java.lang.NullPointerException("Context can not be null.");
        }
        this.mContext = context;
        this.mCallerCallBack = aVar;
        this.mConnection = new com.bun.miitmdid.supplier.sumsung.SumsungCore.a();
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (this.mContext.bindService(intent, this.mConnection, 1)) {
            com.bun.lib.a.b(TAG, "bindService Successful!");
            return;
        }
        this.mContext.unbindService(this.mConnection);
        com.bun.lib.a.b(TAG, "bindService Failed!");
        com.bun.miitmdid.c.e.a aVar2 = this.mCallerCallBack;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    static native /* synthetic */ com.samsung.android.deviceidservice.IDeviceIdService access$002(com.bun.miitmdid.supplier.sumsung.SumsungCore sumsungCore, com.samsung.android.deviceidservice.IDeviceIdService iDeviceIdService);

    static native /* synthetic */ com.bun.miitmdid.c.e.a access$100(com.bun.miitmdid.supplier.sumsung.SumsungCore sumsungCore);

    static native /* synthetic */ java.lang.String access$200();

    public native java.lang.String getAAID();

    public native java.lang.String getOAID();

    public native java.lang.String getUDID();

    public native java.lang.String getVAID();

    public native boolean isSupported();

    public native void shutdown();
}
