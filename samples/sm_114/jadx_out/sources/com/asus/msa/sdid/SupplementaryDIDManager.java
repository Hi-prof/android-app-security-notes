package com.asus.msa.sdid;

/* JADX INFO: loaded from: classes.dex */
public class SupplementaryDIDManager {
    public static boolean DEBUG = false;
    public static final java.lang.String TAG = "SupplementaryDIDManager";
    public android.content.Context mContext;
    public com.asus.msa.SupplementaryDID.IDidAidlInterface mDidService;
    public com.asus.msa.sdid.IDIDBinderStatusListener mListener;
    public boolean isBinded = false;
    public android.content.ServiceConnection mServiceConnection = new android.content.ServiceConnection() { // from class: com.asus.msa.sdid.SupplementaryDIDManager.1
        @Override // android.content.ServiceConnection
        public native void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder);

        @Override // android.content.ServiceConnection
        public native void onServiceDisconnected(android.content.ComponentName componentName);
    };

    public SupplementaryDIDManager(android.content.Context context) {
        this.mContext = context;
    }

    public static native /* synthetic */ boolean access$000();

    public static native /* synthetic */ com.asus.msa.SupplementaryDID.IDidAidlInterface access$102(com.asus.msa.sdid.SupplementaryDIDManager supplementaryDIDManager, com.asus.msa.SupplementaryDID.IDidAidlInterface iDidAidlInterface);

    public static native /* synthetic */ void access$200(com.asus.msa.sdid.SupplementaryDIDManager supplementaryDIDManager, boolean z);

    private native void notifyAllListeners(boolean z);

    public native void deInit();

    public native void init(com.asus.msa.sdid.IDIDBinderStatusListener iDIDBinderStatusListener);

    public native void showLog(boolean z);
}
