package io.dcloud.sdk.core.v3.fd;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCFeedAOLLoader extends io.dcloud.sdk.core.v3.base.DCBaseAOL {
    protected io.dcloud.p.k1 b;

    public DCFeedAOLLoader(android.app.Activity activity) {
        super(activity);
    }

    public void initLoader() {
        if (this.b == null) {
            this.b = new io.dcloud.p.k1(getContext(), 4);
        }
    }

    public void load(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, final io.dcloud.sdk.core.v3.fd.DCFeedAOLLoadListener dCFeedAOLLoadListener) {
        if (getContext() != null && dCloudAOLSlot != null) {
            initLoader();
            this.b.a(dCloudAOLSlot, new io.dcloud.p.z1() { // from class: io.dcloud.sdk.core.v3.fd.DCFeedAOLLoader.1
                @Override // io.dcloud.p.z1
                public void onError(int i, java.lang.String str, org.json.JSONArray jSONArray) {
                    io.dcloud.sdk.core.v3.fd.DCFeedAOLLoadListener dCFeedAOLLoadListener2 = dCFeedAOLLoadListener;
                    if (dCFeedAOLLoadListener2 != null) {
                        dCFeedAOLLoadListener2.onError(i, str, jSONArray);
                    }
                }

                @Override // io.dcloud.p.z1
                public void onLoaded(java.util.List<io.dcloud.p.j1> list) {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    java.util.Iterator<io.dcloud.p.j1> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new io.dcloud.sdk.core.v3.fd.DCFeedAOL(it.next()));
                    }
                    io.dcloud.sdk.core.v3.fd.DCFeedAOLLoadListener dCFeedAOLLoadListener2 = dCFeedAOLLoadListener;
                    if (dCFeedAOLLoadListener2 != null) {
                        dCFeedAOLLoadListener2.onFeedAOLLoad(arrayList);
                    }
                }
            });
        } else if (dCFeedAOLLoadListener != null) {
            dCFeedAOLLoadListener.onError(-5014, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5014), null);
        }
    }
}
