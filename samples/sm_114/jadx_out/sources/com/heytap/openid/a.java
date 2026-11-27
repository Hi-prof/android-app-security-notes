package com.heytap.openid;

/* JADX INFO: loaded from: classes.dex */
public interface a extends android.os.IInterface {

    /* JADX INFO: renamed from: com.heytap.openid.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0016a extends android.os.Binder implements com.heytap.openid.a {

        /* JADX INFO: renamed from: com.heytap.openid.a$a$a, reason: collision with other inner class name */
        private static class C0017a implements com.heytap.openid.a {
            public android.os.IBinder a;

            public C0017a(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            public native java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3);

            @Override // android.os.IInterface
            public native android.os.IBinder asBinder();
        }

        public static native com.heytap.openid.a a(android.os.IBinder iBinder);
    }
}
