package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class g3 implements io.dcloud.p.u1, io.dcloud.p.k, io.dcloud.p.z {
    private io.dcloud.p.z4 a;
    private io.dcloud.p.y d;
    private int g;
    private io.dcloud.p.k h;
    private int i;
    protected final io.dcloud.sdk.core.entry.DCloudAOLSlot n;
    protected final android.app.Activity o;
    private boolean b = false;
    private boolean c = false;
    private boolean e = false;
    private boolean f = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private final java.util.List p = new java.util.ArrayList();

    public g3(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, android.app.Activity activity) {
        this.n = dCloudAOLSlot;
        this.o = activity;
    }

    private void m() {
        boolean z = this.e;
        if (z && this.b) {
            if (l()) {
                io.dcloud.p.n.a aVarA = io.dcloud.p.n.a(this.n.getCount(), this.d.e(), this.a.e());
                if (aVarA == null) {
                    n();
                    return;
                }
                this.k = true;
                for (io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL : aVarA.d) {
                    if (dCBaseAOL.isSlotSupportBidding()) {
                        dCBaseAOL.biddingSuccess(aVarA.b, aVarA.c);
                    }
                }
                this.p.addAll(aVarA.d);
            } else if (this.d.a() >= this.a.a()) {
                this.j = true;
            } else {
                this.k = true;
                this.d.b(this.a.a());
            }
            o();
            return;
        }
        if (z && this.c) {
            this.j = true;
            this.p.addAll(this.d.e());
            o();
            return;
        }
        boolean z2 = this.f;
        if (z2 && this.b) {
            this.k = true;
            this.p.addAll(this.a.e());
            o();
        } else if (z2 && this.c) {
            n();
        }
    }

    @Override // io.dcloud.p.u1
    public void a(io.dcloud.p.v4 v4Var) {
    }

    public void a(io.dcloud.p.z4 z4Var) {
        this.a = z4Var;
    }

    @Override // io.dcloud.p.u1
    public boolean b() {
        return this.j;
    }

    @Override // io.dcloud.p.u1
    public void c(int i) {
    }

    @Override // io.dcloud.p.u1
    public void d(int i) {
        this.g = i;
    }

    @Override // io.dcloud.p.u1
    public boolean e(int i) {
        return true;
    }

    @Override // io.dcloud.p.z
    public void f() {
        if (b()) {
            this.d.f();
        }
    }

    @Override // io.dcloud.p.u1
    public boolean g() {
        io.dcloud.p.z4 z4Var = this.a;
        return z4Var != null && this.d != null && z4Var.g() && this.d.g();
    }

    @Override // io.dcloud.p.u1
    public void h() {
        if (this.l) {
            n();
            return;
        }
        io.dcloud.p.y yVar = this.d;
        if (yVar != null) {
            yVar.a(this);
            this.d.h();
        }
        io.dcloud.p.z4 z4Var = this.a;
        if (z4Var != null) {
            z4Var.a(this);
            this.a.h();
        }
    }

    @Override // io.dcloud.p.k
    public io.dcloud.sdk.core.module.DCBaseAOLLoader i() {
        return null;
    }

    @Override // io.dcloud.p.u1
    public void j() {
        if (this.j) {
            this.d.j();
        }
        if (this.k) {
            this.a.j();
        }
    }

    @Override // io.dcloud.p.u1
    public void k() {
        this.l = true;
        io.dcloud.p.y yVar = this.d;
        if (yVar != null) {
            yVar.k();
        }
        io.dcloud.p.z4 z4Var = this.a;
        if (z4Var != null) {
            z4Var.k();
        }
    }

    boolean l() {
        int i = this.i;
        return i == 10 || i == 4 || i == 5;
    }

    protected void n() {
        if (this.m) {
            return;
        }
        this.m = true;
        io.dcloud.p.k kVar = this.h;
        if (kVar != null) {
            kVar.b(this);
        }
    }

    protected void o() {
        if (this.m) {
            return;
        }
        this.m = true;
        io.dcloud.p.k kVar = this.h;
        if (kVar != null) {
            kVar.a(this);
        }
    }

    public java.lang.String toString() {
        return "Bidding:" + this.d.toString() + ",Usual:" + this.a.toString();
    }

    public void a(io.dcloud.p.y yVar) {
        this.d = yVar;
    }

    @Override // io.dcloud.p.k
    public void b(io.dcloud.p.u1 u1Var) {
        if (u1Var == this.a) {
            this.c = true;
        } else if (u1Var == this.d) {
            this.f = true;
        }
        m();
    }

    @Override // io.dcloud.p.u1
    public int c() {
        return this.g;
    }

    @Override // io.dcloud.p.u1
    public java.util.List d() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        io.dcloud.p.y yVar = this.d;
        if (yVar != null) {
            arrayList.addAll(yVar.d());
        }
        io.dcloud.p.z4 z4Var = this.a;
        if (z4Var != null) {
            arrayList.addAll(z4Var.d());
        }
        return arrayList;
    }

    @Override // io.dcloud.p.u1
    public java.util.List e() {
        if (l()) {
            return this.p;
        }
        if (this.j) {
            return this.d.e();
        }
        if (this.k) {
            return this.a.e();
        }
        return null;
    }

    @Override // io.dcloud.p.u1
    public void a(io.dcloud.p.k kVar) {
        this.h = kVar;
    }

    @Override // io.dcloud.p.u1
    public int a() {
        if (l()) {
            if (this.p.isEmpty()) {
                return -1;
            }
            io.dcloud.p.n.a(this.p);
            java.util.List list = this.p;
            return ((io.dcloud.sdk.core.module.DCBaseAOL) list.get(list.size() - 1)).getBiddingECPM();
        }
        if (this.j) {
            return this.d.a();
        }
        if (this.k) {
            return this.a.a();
        }
        return -1;
    }

    @Override // io.dcloud.p.z
    public void b(int i) {
        if (b()) {
            this.d.b(i);
        }
    }

    @Override // io.dcloud.p.u1
    public void a(int i) {
        this.i = i;
        io.dcloud.p.y yVar = this.d;
        if (yVar != null) {
            yVar.a(i);
        }
        io.dcloud.p.z4 z4Var = this.a;
        if (z4Var != null) {
            z4Var.a(i);
        }
    }

    @Override // io.dcloud.p.u1
    public void a(java.lang.String str) {
        io.dcloud.p.y yVar = this.d;
        if (yVar != null) {
            yVar.a(str);
        }
        io.dcloud.p.z4 z4Var = this.a;
        if (z4Var != null) {
            z4Var.a(str);
        }
    }

    @Override // io.dcloud.p.k
    public void a(io.dcloud.p.u1 u1Var) {
        if (u1Var == this.a) {
            this.b = true;
        } else if (u1Var == this.d) {
            this.e = true;
        }
        m();
    }
}
