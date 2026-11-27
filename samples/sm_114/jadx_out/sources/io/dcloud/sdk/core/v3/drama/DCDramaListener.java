package io.dcloud.sdk.core.v3.drama;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public interface DCDramaListener {
    void onFullDisplay(int i);

    void onNextPlaylet();

    void onPause();

    void onPlayComplete();

    void onPlayEnd();

    void onPlayError(int i, java.lang.String str);

    void onPlayStart();

    void onProgress(long j);

    void onResume();

    void onSeek(long j, int i);
}
