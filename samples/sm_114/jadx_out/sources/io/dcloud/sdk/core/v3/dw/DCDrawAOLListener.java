package io.dcloud.sdk.core.v3.dw;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public interface DCDrawAOLListener extends io.dcloud.sdk.core.v3.fd.DCFeedAOLListener {
    @Override // io.dcloud.sdk.core.v3.fd.DCFeedAOLListener
    void onClick();

    @Override // io.dcloud.sdk.core.v3.fd.DCFeedAOLListener
    void onClosed(java.lang.String str);

    void onEnd();

    void onPause();

    @Override // io.dcloud.sdk.core.v3.fd.DCFeedAOLListener
    void onRenderFail();

    @Override // io.dcloud.sdk.core.v3.fd.DCFeedAOLListener
    void onRenderSuccess();

    void onResume();

    @Override // io.dcloud.sdk.core.v3.fd.DCFeedAOLListener
    void onShow();

    @Override // io.dcloud.sdk.core.v3.fd.DCFeedAOLListener
    void onShowError();

    void onStart();
}
