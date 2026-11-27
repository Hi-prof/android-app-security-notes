package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a3 {
    private static volatile android.os.HandlerThread a = new android.os.HandlerThread("dcloud_thread", -19);
    private static volatile android.os.Handler b;

    static {
        a.start();
        b = new android.os.Handler(a.getLooper());
    }

    public static android.os.Handler a() {
        if (a == null || !a.isAlive()) {
            synchronized (io.dcloud.p.a3.class) {
                if (a == null || !a.isAlive()) {
                    a = new android.os.HandlerThread("dcloud_thread", -19);
                    a.start();
                    b = new android.os.Handler(a.getLooper());
                }
            }
        }
        return b;
    }
}
