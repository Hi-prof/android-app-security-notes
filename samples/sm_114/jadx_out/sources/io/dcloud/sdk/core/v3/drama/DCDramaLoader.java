package io.dcloud.sdk.core.v3.drama;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCDramaLoader extends io.dcloud.sdk.core.v3.base.DCBaseAOL {
    private final io.dcloud.p.a1 b;
    private boolean c;
    private io.dcloud.sdk.core.v3.drama.DCDramaService d;

    public DCDramaLoader(android.app.Activity activity) {
        super(activity);
        this.b = new io.dcloud.p.a1(activity, 11);
    }

    public void destroy() {
        this.c = false;
        this.d = null;
        this.b.destroy();
    }

    public io.dcloud.sdk.core.v3.drama.DCDramaService getDramaService() {
        return this.d;
    }

    public java.lang.String getType() {
        return this.b.getType();
    }

    public boolean isLoaded() {
        return this.c;
    }

    public boolean isValid() {
        return this.b.l();
    }

    public void load(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, final io.dcloud.sdk.core.v3.drama.DCDramaPageLoadListener dCDramaPageLoadListener) {
        if (getContext() != null && dCloudAOLSlot != null) {
            this.c = false;
            this.d = null;
            this.b.a(dCloudAOLSlot, new io.dcloud.p.w2() { // from class: io.dcloud.sdk.core.v3.drama.DCDramaLoader.1
                @Override // io.dcloud.p.w2
                public void onError(int i, java.lang.String str, org.json.JSONArray jSONArray) {
                    io.dcloud.sdk.core.v3.drama.DCDramaLoader.this.c = false;
                    io.dcloud.sdk.core.v3.drama.DCDramaLoader.this.d = null;
                    io.dcloud.sdk.core.v3.drama.DCDramaPageLoadListener dCDramaPageLoadListener2 = dCDramaPageLoadListener;
                    if (dCDramaPageLoadListener2 != null) {
                        dCDramaPageLoadListener2.onError(i, str, jSONArray);
                    }
                }

                @Override // io.dcloud.p.w2
                public void onLoaded() {
                    io.dcloud.sdk.core.v3.drama.DCDramaLoader.this.c = true;
                    io.dcloud.sdk.core.v3.drama.DCDramaLoader dCDramaLoader = io.dcloud.sdk.core.v3.drama.DCDramaLoader.this;
                    dCDramaLoader.d = new io.dcloud.sdk.core.v3.drama.DCDramaService(dCDramaLoader, dCDramaLoader.b);
                    io.dcloud.sdk.core.v3.drama.DCDramaPageLoadListener dCDramaPageLoadListener2 = dCDramaPageLoadListener;
                    if (dCDramaPageLoadListener2 != null) {
                        dCDramaPageLoadListener2.onDramaPageLoad(io.dcloud.sdk.core.v3.drama.DCDramaLoader.this.d);
                    }
                }
            });
        } else {
            this.c = false;
            this.d = null;
            if (dCDramaPageLoadListener != null) {
                dCDramaPageLoadListener.onError(-5014, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5014), null);
            }
        }
    }
}
