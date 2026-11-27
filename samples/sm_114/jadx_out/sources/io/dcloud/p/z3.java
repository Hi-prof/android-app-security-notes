package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class z3 extends io.dcloud.p.y4 implements io.dcloud.sdk.core.interfaces.AOLLoader.RewVAOLInteractionListener {
    public z3(android.app.Activity activity) {
        super(activity, 9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(org.json.JSONObject jSONObject) {
        io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener vAOLInteractionListener = this.r;
        if (vAOLInteractionListener instanceof io.dcloud.sdk.core.interfaces.AOLLoader.RewVAOLInteractionListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.RewVAOLInteractionListener) vAOLInteractionListener).onReward(jSONObject);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader.RewVAOLInteractionListener
    public void onReward(final org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new org.json.JSONObject();
        }
        if (!jSONObject.has("provider")) {
            try {
                jSONObject.put("provider", io.dcloud.p.e.b().c(this.t.getType()));
            } catch (java.lang.Exception unused) {
            }
        }
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.z3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(jSONObject);
            }
        });
    }
}
