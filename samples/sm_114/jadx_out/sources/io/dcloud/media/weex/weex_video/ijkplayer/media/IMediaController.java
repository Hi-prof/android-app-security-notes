package io.dcloud.media.weex.weex_video.ijkplayer.media;

/* JADX INFO: loaded from: classes2.dex */
public interface IMediaController {
    void hide();

    boolean isShowing();

    void setAnchorView(android.view.View view);

    void setEnabled(boolean z);

    void setMediaPlayer(android.widget.MediaController.MediaPlayerControl mediaPlayerControl);

    void show();

    void show(int i);

    void showOnce(android.view.View view);
}
