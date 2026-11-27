package io.dcloud.sdk.core.v3.dw;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCDrawAOLLoader extends io.dcloud.sdk.core.v3.base.DCBaseAOL {
    protected io.dcloud.p.c1 b;

    public DCDrawAOLLoader(android.app.Activity activity) {
        super(activity);
        this.b = new io.dcloud.p.c1(activity);
    }

    public void load(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, final io.dcloud.sdk.core.v3.dw.DCDrawAOLLoadListener dCDrawAOLLoadListener) {
        if (getContext() != null && dCloudAOLSlot != null) {
            this.b.a(dCloudAOLSlot, new io.dcloud.p.z1() { // from class: io.dcloud.sdk.core.v3.dw.DCDrawAOLLoader.1
                @Override // io.dcloud.p.z1
                public void onError(int i, java.lang.String str, org.json.JSONArray jSONArray) {
                    io.dcloud.sdk.core.v3.dw.DCDrawAOLLoadListener dCDrawAOLLoadListener2 = dCDrawAOLLoadListener;
                    if (dCDrawAOLLoadListener2 != null) {
                        dCDrawAOLLoadListener2.onError(i, str, jSONArray);
                    }
                }

                @Override // io.dcloud.p.z1
                public void onLoaded(java.util.List<io.dcloud.p.j1> list) {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    java.util.Iterator<io.dcloud.p.j1> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new io.dcloud.sdk.core.v3.dw.DCDrawAOL(it.next()));
                    }
                    io.dcloud.sdk.core.v3.dw.DCDrawAOLLoadListener dCDrawAOLLoadListener2 = dCDrawAOLLoadListener;
                    if (dCDrawAOLLoadListener2 != null) {
                        dCDrawAOLLoadListener2.onDrawAOLLoad(arrayList);
                    }
                }
            });
        } else if (dCDrawAOLLoadListener != null) {
            dCDrawAOLLoadListener.onError(-5014, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5014), null);
        }
    }
}
