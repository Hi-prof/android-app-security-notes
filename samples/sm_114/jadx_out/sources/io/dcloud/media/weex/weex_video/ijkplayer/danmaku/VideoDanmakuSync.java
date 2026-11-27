package io.dcloud.media.weex.weex_video.ijkplayer.danmaku;

/* JADX INFO: loaded from: classes2.dex */
@java.lang.Deprecated
public class VideoDanmakuSync extends master.flame.danmaku.danmaku.model.AbsDanmakuSync {
    private final io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView mPlayerView;

    @Override // master.flame.danmaku.danmaku.model.AbsDanmakuSync
    public boolean isSyncPlayingState() {
        return true;
    }

    public VideoDanmakuSync(io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView) {
        this.mPlayerView = ijkPlayerView;
    }

    @Override // master.flame.danmaku.danmaku.model.AbsDanmakuSync
    public long getUptimeMillis() {
        if (this.mPlayerView == null) {
            return -1L;
        }
        android.util.Log.i("VideoDanmakuSync", "" + this.mPlayerView.getCurPosition());
        return this.mPlayerView.getCurPosition();
    }

    @Override // master.flame.danmaku.danmaku.model.AbsDanmakuSync
    public int getSyncState() {
        if (this.mPlayerView.isPlaying()) {
            android.util.Log.e("VideoDanmakuSync", "SYNC_STATE_PLAYING");
            return 2;
        }
        android.util.Log.e("VideoDanmakuSync", "SYNC_STATE_HALT");
        return 1;
    }
}
