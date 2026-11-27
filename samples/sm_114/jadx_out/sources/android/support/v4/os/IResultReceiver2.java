package android.support.v4.os;

/* JADX INFO: loaded from: classes.dex */
public interface IResultReceiver2 extends android.os.IInterface {
    public static final java.lang.String DESCRIPTOR = "android$support$v4$os$IResultReceiver2".replace('$', com.taobao.weex.el.parse.Operators.DOT);

    public static class Default implements android.support.v4.os.IResultReceiver2 {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.os.IResultReceiver2
        public void send(int i, android.os.Bundle bundle) throws android.os.RemoteException {
        }
    }

    void send(int i, android.os.Bundle bundle) throws android.os.RemoteException;

    public static abstract class Stub extends android.os.Binder implements android.support.v4.os.IResultReceiver2 {
        static final int TRANSACTION_send = 1;

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static android.support.v4.os.IResultReceiver2 asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof android.support.v4.os.IResultReceiver2)) {
                return (android.support.v4.os.IResultReceiver2) iInterfaceQueryLocalInterface;
            }
            return new android.support.v4.os.IResultReceiver2.Stub.Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            java.lang.String str = DESCRIPTOR;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i == 1) {
                send(parcel.readInt(), (android.os.Bundle) android.support.v4.os.IResultReceiver2._Parcel.readTypedObject(parcel, android.os.Bundle.CREATOR));
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements android.support.v4.os.IResultReceiver2 {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override // android.support.v4.os.IResultReceiver2
            public void send(int i, android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    android.support.v4.os.IResultReceiver2._Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(android.os.Parcel parcel, android.os.Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends android.os.Parcelable> void writeTypedObject(android.os.Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
