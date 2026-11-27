package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IVideoPlayer {
    void addEventListener(java.lang.String str, java.lang.String str2, java.lang.String str3);

    void close();

    void exitFullScreen();

    boolean isFullScreen();

    boolean isPointInRect(float f, float f2);

    boolean isVideoHandleTouch();

    void pause();

    void play();

    void playbackRate(java.lang.String str);

    void release();

    void requestFullScreen(java.lang.String str);

    void resume();

    void seek(java.lang.String str);

    void sendDanmu(org.json.JSONObject jSONObject);

    void setOptions(org.json.JSONObject jSONObject);

    void stop();
}
