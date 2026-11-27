package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class y extends io.dcloud.p.z4 implements io.dcloud.p.z {
    private int v;
    private int w;

    public y(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, android.app.Activity activity) {
        super(dCloudAOLSlot, activity);
        this.v = 0;
        this.w = 0;
    }

    @Override // io.dcloud.p.z4, io.dcloud.p.u1
    public int a() {
        return super.a();
    }

    @Override // io.dcloud.p.z4, io.dcloud.p.u1
    public boolean b() {
        return true;
    }

    @Override // io.dcloud.p.z4, io.dcloud.p.u1
    public void c(int i) {
    }

    @Override // io.dcloud.p.z4, io.dcloud.p.u1
    public void d(int i) {
        int i2 = this.t;
        if (i < i2 || i2 < 0) {
            this.t = i;
        }
    }

    @Override // io.dcloud.p.z4, io.dcloud.p.u1
    public boolean e(int i) {
        return true;
    }

    @Override // io.dcloud.p.z
    public void f() {
        java.util.List list = this.k;
        if (list != null) {
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                ((io.dcloud.sdk.core.module.DCBaseAOL) it.next()).biddingSuccess(this.v, this.w);
            }
        }
        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = this.j;
        if (dCBaseAOL != null) {
            dCBaseAOL.biddingSuccess(this.v, this.w);
        }
    }

    @Override // io.dcloud.p.z4, io.dcloud.p.u1
    public void k() {
        this.p = true;
        if (this.b) {
            return;
        }
        l();
        if (this.f.isEmpty()) {
            p();
        } else {
            r();
        }
    }

    @Override // io.dcloud.p.z4
    protected void r() {
        if (g() || this.p) {
            if (!m()) {
                if (this.f.size() <= 0) {
                    p();
                    return;
                }
                io.dcloud.p.n.a(this.f);
                io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = (io.dcloud.sdk.core.module.DCBaseAOL) this.f.remove(0);
                this.j = dCBaseAOL;
                this.h.remove(dCBaseAOL);
                this.v = this.j.getBiddingECPM();
                if (this.f.size() >= 1) {
                    io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL2 = (io.dcloud.sdk.core.module.DCBaseAOL) this.f.remove(0);
                    this.h.remove(dCBaseAOL2);
                    int biddingECPM = dCBaseAOL2.getBiddingECPM();
                    this.w = biddingECPM;
                    dCBaseAOL2.biddingFail(this.v, biddingECPM, 2);
                    java.util.Iterator it = this.f.iterator();
                    while (it.hasNext()) {
                        ((io.dcloud.sdk.core.module.DCBaseAOL) it.next()).biddingFail(this.v, this.w, 2);
                    }
                }
                java.util.Iterator it2 = this.g.iterator();
                while (it2.hasNext()) {
                    ((io.dcloud.sdk.core.module.DCBaseAOLLoader) it2.next()).biddingFail(this.v, this.w, 3);
                }
                q();
                return;
            }
            if (this.i.size() <= 0) {
                p();
                return;
            }
            java.util.Iterator it3 = this.i.values().iterator();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            while (it3.hasNext()) {
                arrayList.addAll((java.util.Collection) it3.next());
            }
            io.dcloud.p.n.a(arrayList);
            io.dcloud.p.c3.a("level load success,total ads:" + arrayList.size());
            if (arrayList.size() > this.r.getCount()) {
                java.util.List listSubList = arrayList.subList(0, this.r.getCount());
                this.k = listSubList;
                this.v = ((io.dcloud.sdk.core.module.DCBaseAOL) listSubList.get(0)).getBiddingECPM();
                java.util.List listSubList2 = arrayList.subList(this.r.getCount(), arrayList.size());
                this.w = ((io.dcloud.sdk.core.module.DCBaseAOL) listSubList2.get(0)).getBiddingECPM();
                java.util.Iterator it4 = listSubList2.iterator();
                while (it4.hasNext()) {
                    ((io.dcloud.sdk.core.module.DCBaseAOL) it4.next()).biddingFail(this.v, this.w, 2);
                }
            } else {
                this.v = ((io.dcloud.sdk.core.module.DCBaseAOL) arrayList.get(0)).getBiddingECPM();
                this.k = arrayList;
            }
            q();
        }
    }

    @Override // io.dcloud.p.z4, io.dcloud.p.x.a
    public void a(io.dcloud.sdk.core.module.DCBaseAOLLoader dCBaseAOLLoader, java.util.List list, io.dcloud.p.n1 n1Var) {
        if (this.p || this.b) {
            dCBaseAOLLoader.biddingFail(this.v, this.w, 1);
        }
        super.a(dCBaseAOLLoader, list, n1Var);
    }

    @Override // io.dcloud.p.z
    public void b(int i) {
        io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL = this.j;
        if (dCBaseAOL != null) {
            dCBaseAOL.biddingFail(i, this.v, 2);
        }
    }

    @Override // io.dcloud.p.z4, io.dcloud.p.x.a
    public void a(io.dcloud.sdk.core.module.DCBaseAOLLoader dCBaseAOLLoader, io.dcloud.p.n1 n1Var) {
        if (this.p || this.b) {
            if (n1Var.a() == -5000) {
                dCBaseAOLLoader.biddingFail(this.v, this.w, 1);
            } else {
                dCBaseAOLLoader.biddingFail(this.v, this.w, 3);
            }
        }
        super.a(dCBaseAOLLoader, n1Var);
    }
}
