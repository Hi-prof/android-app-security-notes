package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class y4 extends io.dcloud.p.b5 implements io.dcloud.p.x.a, io.dcloud.sdk.core.interfaces.IToggle {
    private io.dcloud.sdk.core.interfaces.IToggle.CADLoadListener A;
    private boolean B;
    private io.dcloud.p.n1 x;
    protected boolean y;
    private java.util.List z;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends java.util.HashMap {
        a() {
            put(io.dcloud.sdk.core.util.Const.DC_ADN, io.dcloud.p.y4.this);
        }
    }

    public y4(android.app.Activity activity, int i) {
        super(activity, i);
        this.y = false;
        this.z = null;
        this.B = false;
    }

    private io.dcloud.p.v4 b(io.dcloud.p.t0 t0Var) {
        java.util.Iterator it = t0Var.d().iterator();
        while (it.hasNext()) {
            io.dcloud.p.v4 v4Var = (io.dcloud.p.v4) it.next();
            if (io.dcloud.sdk.core.util.Const.TYPE_GM.equals(v4Var.l()) && v4Var.u()) {
                it.remove();
                return v4Var;
            }
        }
        return null;
    }

    private void c(io.dcloud.p.t0 t0Var) {
        io.dcloud.p.v4 v4VarB;
        io.dcloud.sdk.core.adapter.IAdAdapter iAdAdapterB = io.dcloud.p.e.b().b(io.dcloud.sdk.core.util.Const.TYPE_GM);
        if (iAdAdapterB == null || !t0Var.b().contains(io.dcloud.sdk.core.util.Const.TYPE_GM) || (v4VarB = b(t0Var)) == null) {
            return;
        }
        a(iAdAdapterB, v4VarB);
    }

    @Override // io.dcloud.p.x, io.dcloud.p.i4
    protected void a(io.dcloud.p.t0 t0Var) {
        int i;
        if (io.dcloud.p.n.f(a()) && (i = this.d) != 14 && i != 5 && i != 7 && i != 11) {
            c(t0Var);
        }
        super.a(t0Var);
    }

    protected void d(int i, java.lang.String str, org.json.JSONArray jSONArray) {
        super.a(i, str, jSONArray);
        if (g()) {
            e();
        }
    }

    protected void e(java.util.List list) {
        super.c(list);
        if (g()) {
            e();
        }
    }

    @Override // io.dcloud.p.x
    public boolean g() {
        return this.y;
    }

    @Override // io.dcloud.sdk.core.interfaces.IToggle
    public java.util.List getSuccessAds() {
        return this.z;
    }

    protected void h() {
        this.B = false;
        this.x = null;
        this.y = false;
        this.z = null;
        this.A = null;
    }

    @Override // io.dcloud.sdk.core.interfaces.IToggle
    public void setCADLoadListener(io.dcloud.sdk.core.interfaces.IToggle.CADLoadListener cADLoadListener) {
        this.A = cADLoadListener;
    }

    private void a(io.dcloud.sdk.core.adapter.IAdAdapter iAdAdapter, io.dcloud.p.v4 v4Var) {
        this.y = true;
        io.dcloud.sdk.core.module.DCBaseAOLLoader ad = iAdAdapter.getAd(a(), this.b);
        io.dcloud.p.b0 b0VarA = io.dcloud.p.c0.a().a(io.dcloud.sdk.core.util.Const.TYPE_GM);
        if (b0VarA != null) {
            ad.initSDK(b0VarA.a(), b0VarA.b());
        }
        ad.setSlotAdInfo(v4Var);
        ad.setLoadListener(this);
        ad.setLoadId(this.n);
        this.b.setRID(this.n);
        ad.loadAd(new io.dcloud.p.y4.a());
    }

    @Override // io.dcloud.p.b5, io.dcloud.p.x
    protected void c(java.util.List list) {
        if (this.y) {
            this.z = list;
            if (this.A != null) {
                if (list != null && !list.isEmpty()) {
                    this.A.onLoadSuccess(this.z);
                    return;
                } else {
                    this.A.onLoadFail(-5005, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5005));
                    return;
                }
            }
            return;
        }
        this.w = false;
        e(list);
    }

    @Override // io.dcloud.p.x.a
    public void a(io.dcloud.sdk.core.module.DCBaseAOLLoader dCBaseAOLLoader, java.util.List list, io.dcloud.p.n1 n1Var) {
        if (this.y) {
            this.x = n1Var;
            n1Var.f();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (list == null) {
                arrayList.add(dCBaseAOLLoader);
            } else {
                arrayList.addAll(list);
            }
            this.w = false;
            e(arrayList);
        }
    }

    @Override // io.dcloud.p.x.a
    public void a(io.dcloud.sdk.core.module.DCBaseAOLLoader dCBaseAOLLoader, io.dcloud.p.n1 n1Var) {
        if (this.y) {
            this.x = n1Var;
            this.w = false;
            d(-5005, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5005), new org.json.JSONArray().put(n1Var.b()));
        }
    }

    @Override // io.dcloud.p.b5, io.dcloud.p.x
    protected void a(int i, java.lang.String str, org.json.JSONArray jSONArray) {
        if (this.y) {
            io.dcloud.sdk.core.interfaces.IToggle.CADLoadListener cADLoadListener = this.A;
            if (cADLoadListener != null) {
                cADLoadListener.onLoadFail(i, jSONArray.toString());
                return;
            }
            return;
        }
        this.w = false;
        d(i, str, jSONArray);
    }

    @Override // io.dcloud.p.y3
    protected void a(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, org.json.JSONArray jSONArray, long j) {
        if (this.y) {
            io.dcloud.p.n1 n1Var = this.x;
            if (n1Var == null) {
                return;
            } else {
                jSONArray.put(n1Var.g());
            }
        }
        if (this.B) {
            return;
        }
        this.B = true;
        super.a(i, str, str2, str3, jSONArray, j);
    }

    @Override // io.dcloud.p.b5
    public void a(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, io.dcloud.p.w2 w2Var) {
        h();
        super.a(dCloudAOLSlot, w2Var);
    }
}
