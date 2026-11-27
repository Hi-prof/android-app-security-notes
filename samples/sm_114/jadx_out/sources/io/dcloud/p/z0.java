package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class z0 {
    private static io.dcloud.p.z0 a;
    private static java.util.List b = new java.util.ArrayList();

    private z0() {
    }

    public static io.dcloud.p.z0 a(android.content.Context context) {
        if (a == null) {
            synchronized (io.dcloud.p.z0.class) {
                if (a == null) {
                    a = new io.dcloud.p.z0();
                }
            }
        }
        return a;
    }

    public void b(io.dcloud.p.y0 y0Var) {
        b.remove(y0Var);
    }

    public void a(io.dcloud.p.y0 y0Var) {
        b.add(y0Var);
        io.dcloud.p.x4.a().a(y0Var);
    }

    public java.util.List a() {
        return b;
    }
}
