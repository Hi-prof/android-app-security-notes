package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class x4 {
    private static io.dcloud.p.x4 b;
    java.util.concurrent.ThreadPoolExecutor a = new java.util.concurrent.ThreadPoolExecutor(3, 6, 1, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());

    private x4() {
    }

    public static io.dcloud.p.x4 a() {
        if (b == null) {
            synchronized (io.dcloud.p.x4.class) {
                if (b == null) {
                    b = new io.dcloud.p.x4();
                }
            }
        }
        return b;
    }

    public void a(java.lang.Runnable runnable) {
        this.a.execute(runnable);
    }
}
