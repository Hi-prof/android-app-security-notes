package com.zui.deviceidservice;

/* JADX INFO: loaded from: classes.dex */
public interface IDeviceidInterface extends android.os.IInterface {

    public static abstract class Stub extends android.os.Binder implements com.zui.deviceidservice.IDeviceidInterface {

        private static class Proxy implements com.zui.deviceidservice.IDeviceidInterface {
            private android.os.IBinder a;

            Proxy(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public native boolean a();

            @Override // android.os.IInterface
            public native android.os.IBinder asBinder();

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public native java.lang.String getAAID(java.lang.String str);

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public native java.lang.String getOAID();

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public native java.lang.String getUDID();

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public native java.lang.String getVAID(java.lang.String str);
        }

        public Stub() {
            attachInterface(this, "com.zui.deviceidservice.IDeviceidInterface");
        }

        public static native com.zui.deviceidservice.IDeviceidInterface a(android.os.IBinder iBinder);

        @Override // android.os.IInterface
        public native android.os.IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2);
    }

    boolean a();

    java.lang.String getAAID(java.lang.String str);

    java.lang.String getOAID();

    java.lang.String getUDID();

    java.lang.String getVAID(java.lang.String str);
}
