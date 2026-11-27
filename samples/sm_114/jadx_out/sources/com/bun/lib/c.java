package com.bun.lib;

/* JADX INFO: loaded from: classes.dex */
public interface c extends android.os.IInterface {

    public static abstract class a extends android.os.Binder implements com.bun.lib.c {

        /* JADX INFO: renamed from: com.bun.lib.c$a$a, reason: collision with other inner class name */
        private static class C0008a implements com.bun.lib.c {
            private android.os.IBinder a;

            C0008a(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public native android.os.IBinder asBinder();

            @Override // com.bun.lib.c
            public native boolean c();

            @Override // com.bun.lib.c
            public native java.lang.String getAAID();

            @Override // com.bun.lib.c
            public native java.lang.String getOAID();

            @Override // com.bun.lib.c
            public native java.lang.String getVAID();

            @Override // com.bun.lib.c
            public native boolean isSupported();

            @Override // com.bun.lib.c
            public native void shutDown();
        }

        public static native com.bun.lib.c a(android.os.IBinder iBinder);
    }

    boolean c();

    java.lang.String getAAID();

    java.lang.String getOAID();

    java.lang.String getVAID();

    boolean isSupported();

    void shutDown();
}
