package com.bun.miitmdid.supplier.msa;

/* JADX INFO: loaded from: classes.dex */
public class MsaClient {
    private static java.lang.String TAG = "MSA Client library";
    private static java.lang.String TARGET_PACKAGE = "com.mdid.msa";
    private com.bun.miitmdid.c.e.a _BindService;
    private android.content.ServiceConnection mConnection;
    private android.content.Context mContext;
    private com.bun.lib.c mDeviceidInterface;

    class a implements android.content.ServiceConnection {
        final /* synthetic */ com.bun.miitmdid.c.e.a a;

        a(com.bun.miitmdid.c.e.a aVar) {
            this.a = aVar;
        }

        @Override // android.content.ServiceConnection
        public native synchronized void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder);

        @Override // android.content.ServiceConnection
        public native void onServiceDisconnected(android.content.ComponentName componentName);
    }

    public MsaClient(android.content.Context context, com.bun.miitmdid.c.e.a aVar) {
        if (context == null) {
            throw new java.lang.NullPointerException("Context can not be null.");
        }
        this.mContext = context;
        this._BindService = aVar;
        this.mConnection = new com.bun.miitmdid.supplier.msa.MsaClient.a(aVar);
    }

    public static native boolean CheckService(android.content.Context context);

    public static native void StartMsaKlService(android.content.Context context, java.lang.String str);

    static native /* synthetic */ com.bun.lib.c access$000(com.bun.miitmdid.supplier.msa.MsaClient msaClient);

    static native /* synthetic */ com.bun.lib.c access$002(com.bun.miitmdid.supplier.msa.MsaClient msaClient, com.bun.lib.c cVar);

    static native /* synthetic */ java.lang.String access$100();

    public native void BindService(java.lang.String str);

    public native java.lang.String getAAID();

    public native java.lang.String getOAID();

    public native java.lang.String getUDID();

    public native java.lang.String getVAID();

    public native boolean isSupported();

    public native void shutdown();
}
