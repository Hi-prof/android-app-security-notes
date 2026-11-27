package io.dcloud.sdk.core.v3.pv;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCPreVideoLoader extends io.dcloud.sdk.core.v3.fd.DCFeedAOLLoader {
    public DCPreVideoLoader(android.app.Activity activity) {
        super(activity);
    }

    @Override // io.dcloud.sdk.core.v3.fd.DCFeedAOLLoader
    public void initLoader() {
        if (this.b == null) {
            this.b = new io.dcloud.p.k1(getContext(), 5);
        }
    }
}
