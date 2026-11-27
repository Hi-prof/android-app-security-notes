package com.asus.msa.sdid;

/* JADX INFO: loaded from: classes.dex */
public interface IDIDBinderStatusListener extends android.os.IInterface {

    public static abstract class Stub extends android.os.Binder implements com.asus.msa.sdid.IDIDBinderStatusListener {

        public static class Proxy implements com.asus.msa.sdid.IDIDBinderStatusListener {
            public android.os.IBinder a;

            @Override // com.asus.msa.sdid.IDIDBinderStatusListener
            public native void a(com.asus.msa.SupplementaryDID.IDidAidlInterface iDidAidlInterface);

            @Override // android.os.IInterface
            public native android.os.IBinder asBinder();

            @Override // com.asus.msa.sdid.IDIDBinderStatusListener
            public native void b();
        }

        public Stub() {
            attachInterface(this, "com.asus.msa.sdid.IDIDBinderStatusListener");
        }

        @Override // android.os.IInterface
        public native android.os.IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2);
    }

    void a(com.asus.msa.SupplementaryDID.IDidAidlInterface iDidAidlInterface);

    void b();
}
