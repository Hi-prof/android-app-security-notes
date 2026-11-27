package com.samsung.android.deviceidservice;

/* JADX INFO: loaded from: classes.dex */
public interface IDeviceIdService extends android.os.IInterface {

    public static abstract class Stub extends android.os.Binder implements com.samsung.android.deviceidservice.IDeviceIdService {

        private static class Proxy implements com.samsung.android.deviceidservice.IDeviceIdService {
            private android.os.IBinder a;

            Proxy(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public native android.os.IBinder asBinder();

            @Override // com.samsung.android.deviceidservice.IDeviceIdService
            public native java.lang.String getAAID(java.lang.String str);

            @Override // com.samsung.android.deviceidservice.IDeviceIdService
            public native java.lang.String getOAID();

            @Override // com.samsung.android.deviceidservice.IDeviceIdService
            public native java.lang.String getVAID(java.lang.String str);
        }

        public Stub() {
            attachInterface(this, "com.samsung.android.deviceidservice.IDeviceIdService");
        }

        public static native com.samsung.android.deviceidservice.IDeviceIdService a(android.os.IBinder iBinder);

        @Override // android.os.IInterface
        public native android.os.IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2);
    }

    java.lang.String getAAID(java.lang.String str);

    java.lang.String getOAID();

    java.lang.String getVAID(java.lang.String str);
}
