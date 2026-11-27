package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class c1 extends io.dcloud.p.k1 {
    public c1(android.app.Activity activity) {
        super(activity, 10);
    }

    @Override // io.dcloud.p.k1
    protected java.util.List f(java.util.List list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (list != null && list.size() > 0) {
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new io.dcloud.p.b1((io.dcloud.sdk.core.module.DCBaseAOL) it.next(), a()));
            }
        }
        return arrayList;
    }
}
