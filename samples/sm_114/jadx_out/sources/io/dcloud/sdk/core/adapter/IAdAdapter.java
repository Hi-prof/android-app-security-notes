package io.dcloud.sdk.core.adapter;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public interface IAdAdapter {
    io.dcloud.sdk.core.module.DCBaseAOLLoader getAd(android.app.Activity activity, io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot);

    java.lang.String getAdapterSDKVersion();

    java.lang.String getSDKVersion();

    void init(android.content.Context context, org.json.JSONObject jSONObject);

    boolean isSupport();

    void setPersonalAd(boolean z);

    void updatePrivacyConfig(io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig);
}
