package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class q0 implements io.dcloud.sdk.core.adapter.IAdAdapter {
    @Override // io.dcloud.sdk.core.adapter.IAdAdapter
    public io.dcloud.sdk.core.module.DCBaseAOLLoader getAd(android.app.Activity activity, io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot) {
        if (dCloudAOLSlot.getType() == 1) {
            return new io.dcloud.p.u0(dCloudAOLSlot, activity);
        }
        return null;
    }

    @Override // io.dcloud.sdk.core.adapter.IAdAdapter
    public java.lang.String getAdapterSDKVersion() {
        return "1.9.9.82680";
    }

    @Override // io.dcloud.sdk.core.adapter.IAdAdapter
    public java.lang.String getSDKVersion() {
        return "";
    }

    @Override // io.dcloud.sdk.core.adapter.IAdAdapter
    public void init(android.content.Context context, org.json.JSONObject jSONObject) {
    }

    @Override // io.dcloud.sdk.core.adapter.IAdAdapter
    public boolean isSupport() {
        return true;
    }

    @Override // io.dcloud.sdk.core.adapter.IAdAdapter
    public void setPersonalAd(boolean z) {
    }

    @Override // io.dcloud.sdk.core.adapter.IAdAdapter
    public void updatePrivacyConfig(io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig) {
    }
}
