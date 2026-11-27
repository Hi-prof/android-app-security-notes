package io.dcloud.sdk.core.v3.cp;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public interface DCContentPageVideoListener {
    void onComplete(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem);

    void onError(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem);

    void onPause(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem);

    void onResume(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem);

    void onStart(io.dcloud.sdk.core.v3.cp.DCContentPage.ContentPageItem contentPageItem);
}
