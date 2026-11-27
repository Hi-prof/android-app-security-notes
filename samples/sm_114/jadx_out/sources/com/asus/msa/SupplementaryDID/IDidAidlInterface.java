package com.asus.msa.SupplementaryDID;

/* JADX INFO: loaded from: classes.dex */
public interface IDidAidlInterface extends android.os.IInterface {

    public static abstract class Stub extends android.os.Binder implements com.asus.msa.SupplementaryDID.IDidAidlInterface {

        public static class Proxy implements com.asus.msa.SupplementaryDID.IDidAidlInterface {
            public android.os.IBinder a;

            public Proxy(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            public native boolean a();

            @Override // android.os.IInterface
            public native android.os.IBinder asBinder();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            public native java.lang.String getAAID();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            public native java.lang.String getOAID();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            public native java.lang.String getUDID();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            public native java.lang.String getVAID();
        }

        public Stub() {
            attachInterface(this, "com.asus.msa.SupplementaryDID.IDidAidlInterface");
        }

        public static native com.asus.msa.SupplementaryDID.IDidAidlInterface a(android.os.IBinder iBinder);

        @Override // android.os.IInterface
        public native android.os.IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2);
    }

    boolean a();

    java.lang.String getAAID();

    java.lang.String getOAID();

    java.lang.String getUDID();

    java.lang.String getVAID();
}
