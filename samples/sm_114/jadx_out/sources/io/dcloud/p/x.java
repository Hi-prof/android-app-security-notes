package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class x extends io.dcloud.p.i4 implements io.dcloud.p.k {
    private final java.util.List f;
    private final java.util.List g;
    private io.dcloud.p.u1 h;
    private boolean i;
    private final android.os.Handler j;
    private final int k;
    private final int l;
    private long m;
    protected java.lang.String n;
    private boolean o;
    private io.dcloud.p.t0 p;
    private java.util.Set q;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface a {
        void a(io.dcloud.sdk.core.module.DCBaseAOLLoader dCBaseAOLLoader, io.dcloud.p.n1 n1Var);

        void a(io.dcloud.sdk.core.module.DCBaseAOLLoader dCBaseAOLLoader, java.util.List list, io.dcloud.p.n1 n1Var);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class b extends android.os.Handler {
        public b(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            io.dcloud.p.x.this.k();
        }
    }

    public x(android.app.Activity activity) {
        super(activity);
        this.f = new java.util.ArrayList();
        this.g = new java.util.ArrayList();
        this.i = false;
        this.k = 3;
        this.l = 18000;
        this.m = 0L;
        this.n = "";
        this.o = false;
        this.q = new java.util.HashSet();
        this.j = new io.dcloud.p.x.b(io.dcloud.p.a3.a().getLooper());
    }

    private void c(int i, java.lang.String str) {
        b(i, str, null);
    }

    private void h() {
        this.b.setRID(this.n);
        long jE = ((long) this.p.e()) - (android.os.SystemClock.elapsedRealtime() - this.m);
        if (jE <= 0) {
            c(-5005, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5018));
            return;
        }
        this.j.removeMessages(3);
        this.j.sendEmptyMessageDelayed(3, jE);
        if (this.d != this.p.f() && (this.d != 4 || this.p.f() != 5)) {
            c(-5011, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5011));
            return;
        }
        java.util.List listD = this.p.d();
        if (listD == null || listD.isEmpty()) {
            c(-5019, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5019));
            return;
        }
        if (a(this.p, listD)) {
            return;
        }
        io.dcloud.p.c3.a("level load finish.total:" + this.f.size());
        java.util.Iterator it = this.f.iterator();
        while (it.hasNext()) {
            io.dcloud.p.c3.a(((io.dcloud.p.u1) it.next()).toString());
        }
        j();
    }

    private void j() {
        if (this.f.size() <= 0 || this.i) {
            if (this.h != null) {
                if (!g()) {
                    ((io.dcloud.p.z) this.h).f();
                }
                b(this.h.e());
            }
            e();
            return;
        }
        io.dcloud.p.u1 u1Var = (io.dcloud.p.u1) this.f.remove(0);
        io.dcloud.p.u1 u1Var2 = this.h;
        if (u1Var2 == null || u1Var2.a() <= 0) {
            this.g.add(u1Var);
            u1Var.a(this.n);
            u1Var.h();
            return;
        }
        io.dcloud.p.c3.a("is necessary to load next:" + u1Var.e(this.h.a()) + ",next level:" + u1Var.c());
        if (!u1Var.e(this.h.a())) {
            j();
            return;
        }
        u1Var.c(this.h.a());
        this.g.add(u1Var);
        u1Var.a(this.n);
        u1Var.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.i = true;
        io.dcloud.p.c3.b("this slot:time out");
        if (this.g.isEmpty()) {
            a(new org.json.JSONArray());
            return;
        }
        for (io.dcloud.p.u1 u1Var : this.g) {
            if (!u1Var.g()) {
                u1Var.k();
            }
        }
    }

    protected abstract void a(int i, java.lang.String str, org.json.JSONArray jSONArray);

    @Override // io.dcloud.p.y3
    protected boolean b() {
        return 1 == this.p.c();
    }

    protected abstract void c(java.util.List list);

    protected void e() {
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime() - this.m;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = this.g.iterator();
        while (it.hasNext()) {
            arrayList.addAll(((io.dcloud.p.u1) it.next()).d());
        }
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        a(arrayList, jSONArray, jElapsedRealtime);
        a(jSONArray);
    }

    boolean f() {
        int i = this.d;
        return i == 10 || i == 4 || i == 5;
    }

    public boolean g() {
        return false;
    }

    public io.dcloud.sdk.core.module.DCBaseAOLLoader i() {
        return null;
    }

    @Override // io.dcloud.p.i4, java.lang.Runnable
    public void run() {
        this.n = java.util.UUID.randomUUID().toString();
        this.g.clear();
        this.f.clear();
        this.q.clear();
        this.h = null;
        this.i = false;
        this.o = false;
        this.j.sendEmptyMessageDelayed(3, 18000L);
        this.m = android.os.SystemClock.elapsedRealtime();
        super.run();
    }

    @Override // io.dcloud.p.i4
    protected void a(io.dcloud.p.t0 t0Var) {
        this.p = t0Var;
        this.b.setAdpid(t0Var.a());
        h();
    }

    @Override // io.dcloud.p.k
    public void b(io.dcloud.p.u1 u1Var) {
        j();
    }

    private void b(int i, java.lang.String str, org.json.JSONArray jSONArray) {
        if (this.o) {
            return;
        }
        this.o = true;
        io.dcloud.p.c3.b("this slot:all fail");
        this.j.removeMessages(3);
        a(i, str, jSONArray);
    }

    @Override // io.dcloud.p.i4
    protected void a(int i, java.lang.String str) {
        b(i, str, null);
    }

    private boolean a(io.dcloud.p.t0 t0Var, java.util.List list) {
        java.util.HashMap map = new java.util.HashMap();
        java.util.Iterator it = list.iterator();
        io.dcloud.p.y yVar = null;
        while (it.hasNext()) {
            io.dcloud.p.v4 v4Var = (io.dcloud.p.v4) it.next();
            int iF = v4Var.f();
            if (v4Var.u()) {
                if (yVar == null) {
                    yVar = new io.dcloud.p.y(this.b, this.c);
                    yVar.a(t0Var.f());
                    if (t0Var.g()) {
                        yVar.j();
                    }
                }
                yVar.d(iF);
                yVar.a(v4Var);
            } else {
                io.dcloud.p.u1 u1Var = (io.dcloud.p.u1) map.get(java.lang.Integer.valueOf(iF));
                if (u1Var != null) {
                    u1Var.a(v4Var);
                } else {
                    io.dcloud.p.z4 z4Var = new io.dcloud.p.z4(this.b, this.c);
                    if (t0Var.g()) {
                        z4Var.j();
                    }
                    z4Var.a(t0Var.f());
                    z4Var.a(this);
                    z4Var.d(v4Var.f());
                    z4Var.a(v4Var);
                    map.put(java.lang.Integer.valueOf(v4Var.f()), z4Var);
                }
            }
        }
        if (yVar != null) {
            if (map.containsKey(java.lang.Integer.valueOf(yVar.c()))) {
                io.dcloud.p.g3 g3Var = new io.dcloud.p.g3(this.b, this.c);
                g3Var.a(yVar);
                g3Var.a((io.dcloud.p.z4) map.get(java.lang.Integer.valueOf(yVar.c())));
                g3Var.d(yVar.c());
                g3Var.a(this);
                g3Var.a(t0Var.f());
                if (t0Var.g()) {
                    g3Var.j();
                }
                map.put(java.lang.Integer.valueOf(yVar.c()), g3Var);
            } else {
                yVar.a(this);
                map.put(java.lang.Integer.valueOf(yVar.c()), yVar);
            }
        }
        this.f.addAll(map.values());
        if (this.f.size() > 1) {
            java.util.Collections.sort(this.f, new java.util.Comparator() { // from class: io.dcloud.p.x$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                    return io.dcloud.p.x.a((io.dcloud.p.u1) obj, (io.dcloud.p.u1) obj2);
                }
            });
            return false;
        }
        if (map.size() == 1) {
            return false;
        }
        c(-5020, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5020));
        return true;
    }

    private void b(java.util.List list) {
        if (this.o) {
            return;
        }
        this.o = true;
        if (io.dcloud.p.w0.a) {
            java.util.Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = (io.dcloud.sdk.core.module.DCBaseAOL) it.next();
                io.dcloud.p.c3.a("success!index:" + i + ";ad:" + dCBaseAOL.toString() + ";type:" + dCBaseAOL.getType() + ",id:" + dCBaseAOL.getSlotId() + ",isbid:" + dCBaseAOL.isSlotSupportBidding() + ",bidPrice:" + dCBaseAOL.getBiddingECPM());
                i++;
            }
        }
        this.j.removeMessages(3);
        a(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(io.dcloud.p.u1 u1Var, io.dcloud.p.u1 u1Var2) {
        return java.lang.Integer.compare(u1Var.c(), u1Var2.c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.dcloud.p.y3
    public android.app.Activity a() {
        return this.c;
    }

    @Override // io.dcloud.p.k
    public void a(io.dcloud.p.u1 u1Var) {
        io.dcloud.p.c3.a("level load success.current:" + u1Var.c() + ",is bid:" + u1Var.b());
        if (u1Var.b()) {
            this.h = u1Var;
            j();
            return;
        }
        io.dcloud.p.u1 u1Var2 = this.h;
        if (u1Var2 != null && (u1Var2 instanceof io.dcloud.p.z)) {
            if (f()) {
                io.dcloud.p.n.a aVarA = io.dcloud.p.n.a(this.b.getCount(), this.h.e(), u1Var.e());
                if (aVarA == null) {
                    this.h = null;
                    j();
                    return;
                }
                if (!g()) {
                    for (io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL : aVarA.d) {
                        if (dCBaseAOL.isSlotSupportBidding()) {
                            dCBaseAOL.biddingSuccess(aVarA.b, aVarA.c);
                        }
                    }
                }
                b(aVarA.d);
            } else if (u1Var.a() > this.h.a()) {
                ((io.dcloud.p.z) this.h).b(u1Var.a());
                b(u1Var.e());
            } else {
                if (!g()) {
                    ((io.dcloud.p.z) this.h).f();
                }
                b(this.h.e());
            }
        } else {
            b(u1Var.e());
        }
        e();
    }

    private void a(java.util.List list, org.json.JSONArray jSONArray, long j) {
        if (list.isEmpty()) {
            return;
        }
        org.json.JSONArray jSONArray2 = new org.json.JSONArray();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            io.dcloud.p.n1 n1Var = (io.dcloud.p.n1) it.next();
            if (n1Var.e()) {
                if (this.q.contains(n1Var.c())) {
                    n1Var.f();
                }
                if (n1Var.d() == 0) {
                    jSONArray.put(n1Var.b());
                }
                jSONArray2.put(n1Var.g());
            }
        }
        io.dcloud.p.c3.b("collection data:load time:" + j);
        a(this.p.f(), this.b.getAdpid(), this.p.g() ? "1" : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT, this.b.getEI(), jSONArray2, j);
    }

    private void a(org.json.JSONArray jSONArray) {
        if (this.i) {
            b(-5005, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5018), jSONArray);
        } else {
            b(-5005, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5005), jSONArray);
        }
    }

    private void a(java.util.List list) {
        if (list.size() > 0) {
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                this.q.add(((io.dcloud.sdk.core.module.DCBaseAOL) it.next()).getSlotId());
            }
        }
        c(list);
    }
}
