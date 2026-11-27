package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class k1 extends io.dcloud.p.y4 {
    protected io.dcloud.p.z1 C;

    public k1(android.app.Activity activity, int i) {
        super(activity, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(int i, java.lang.String str, org.json.JSONArray jSONArray) {
        io.dcloud.p.z1 z1Var = this.C;
        if (z1Var != null) {
            z1Var.onError(i, str, jSONArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(java.util.List list) {
        io.dcloud.p.z1 z1Var = this.C;
        if (z1Var != null) {
            z1Var.onLoaded(list);
        }
    }

    public void a(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, io.dcloud.p.z1 z1Var) {
        super.h();
        a(dCloudAOLSlot);
        this.C = z1Var;
        io.dcloud.p.a3.a().post(this);
        this.w = true;
    }

    @Override // io.dcloud.p.y4
    protected void d(final int i, final java.lang.String str, final org.json.JSONArray jSONArray) {
        io.dcloud.p.c3.b("uniAd-loadError", "code:" + i + ";message:" + str + ";detail:" + java.lang.String.valueOf(jSONArray));
        if (g()) {
            e();
        }
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.k1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e(i, str, jSONArray);
            }
        });
    }

    protected java.util.List f(java.util.List list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (list != null && list.size() > 0) {
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new io.dcloud.p.j1((io.dcloud.sdk.core.module.DCBaseAOL) it.next(), a()));
            }
        }
        return arrayList;
    }

    @Override // io.dcloud.p.y4
    protected void e(java.util.List list) {
        if (g()) {
            e();
        }
        final java.util.List listF = f(list);
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.k1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.g(listF);
            }
        });
    }
}
