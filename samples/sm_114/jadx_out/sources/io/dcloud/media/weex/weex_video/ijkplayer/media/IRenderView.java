package io.dcloud.media.weex.weex_video.ijkplayer.media;

/* JADX INFO: loaded from: classes2.dex */
public interface IRenderView {
    public static final int AR_16_9_FIT_PARENT = 4;
    public static final int AR_4_3_FIT_PARENT = 5;
    public static final int AR_ASPECT_FILL_PARENT = 1;
    public static final int AR_ASPECT_FIT_PARENT = 0;
    public static final int AR_ASPECT_WRAP_CONTENT = 2;
    public static final int AR_MATCH_PARENT = 3;

    public interface IRenderCallback {
        void onSurfaceChanged(io.dcloud.media.weex.weex_video.ijkplayer.media.IRenderView.ISurfaceHolder iSurfaceHolder, int i, int i2, int i3);

        void onSurfaceCreated(io.dcloud.media.weex.weex_video.ijkplayer.media.IRenderView.ISurfaceHolder iSurfaceHolder, int i, int i2);

        void onSurfaceDestroyed(io.dcloud.media.weex.weex_video.ijkplayer.media.IRenderView.ISurfaceHolder iSurfaceHolder);
    }

    public interface ISurfaceHolder {
        void bindToMediaPlayer(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer);

        io.dcloud.media.weex.weex_video.ijkplayer.media.IRenderView getRenderView();

        android.view.SurfaceHolder getSurfaceHolder();

        android.graphics.SurfaceTexture getSurfaceTexture();

        android.view.Surface openSurface();
    }

    void addRenderCallback(io.dcloud.media.weex.weex_video.ijkplayer.media.IRenderView.IRenderCallback iRenderCallback);

    android.graphics.Matrix getTransform();

    android.graphics.Bitmap getVideoScreenshot();

    android.view.View getView();

    void removeRenderCallback(io.dcloud.media.weex.weex_video.ijkplayer.media.IRenderView.IRenderCallback iRenderCallback);

    void setAspectRatio(int i);

    void setTransform(android.graphics.Matrix matrix);

    void setVideoRotation(int i);

    void setVideoSampleAspectRatio(int i, int i2);

    void setVideoSize(int i, int i2);

    boolean shouldWaitForResize();
}
