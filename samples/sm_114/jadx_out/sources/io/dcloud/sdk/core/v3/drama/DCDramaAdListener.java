package io.dcloud.sdk.core.v3.drama;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public interface DCDramaAdListener {
    void onClick();

    void onClose();

    void onLoadFail(int i, java.lang.String str, org.json.JSONObject jSONObject);

    void onLoadSuccess();

    void onReward(org.json.JSONObject jSONObject);

    void onShow();

    void onShowError(int i, java.lang.String str);

    void onSkip();

    void onVideoPlayEnd();
}
