package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class r3 {
    private static io.dcloud.p.r3 b;
    private volatile java.util.concurrent.ConcurrentMap a = new java.util.concurrent.ConcurrentHashMap();

    private r3() {
    }

    public static io.dcloud.p.r3 a() {
        if (b == null) {
            b = new io.dcloud.p.r3();
        }
        return b;
    }

    public void b() {
        java.util.Iterator it = this.a.keySet().iterator();
        while (it.hasNext()) {
            io.dcloud.common.DHInterface.IPdrModule iPdrModule = (io.dcloud.common.DHInterface.IPdrModule) this.a.remove((java.lang.String) it.next());
            if (iPdrModule != null) {
                iPdrModule.onDestroy();
            }
        }
    }

    public void a(java.util.Map map) {
        if (map != null) {
            for (java.lang.String str : map.keySet()) {
                a(str, (java.lang.Class) map.get(str));
            }
        }
    }

    public void a(java.lang.String str, java.lang.Class cls) {
        if (cls != null) {
            try {
                this.a.put(str, (io.dcloud.common.DHInterface.IPdrModule) cls.newInstance());
            } catch (java.lang.IllegalAccessException | java.lang.InstantiationException unused) {
            }
        }
    }

    public io.dcloud.common.DHInterface.IPdrModule a(java.lang.String str) {
        if (this.a.containsKey(str)) {
            return (io.dcloud.common.DHInterface.IPdrModule) this.a.get(str);
        }
        return null;
    }
}
