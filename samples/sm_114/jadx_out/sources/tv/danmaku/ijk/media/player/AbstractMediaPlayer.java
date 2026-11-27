package tv.danmaku.ijk.media.player;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractMediaPlayer implements tv.danmaku.ijk.media.player.IMediaPlayer {
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener mOnCompletionListener;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener mOnErrorListener;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener mOnInfoListener;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener mOnPreparedListener;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener mOnTimedTextListener;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public final void setOnPreparedListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public final void setOnCompletionListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public final void setOnBufferingUpdateListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public final void setOnSeekCompleteListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public final void setOnVideoSizeChangedListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public final void setOnErrorListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public final void setOnInfoListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public final void setOnTimedTextListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        this.mOnTimedTextListener = onTimedTextListener;
    }

    public void resetListeners() {
        this.mOnPreparedListener = null;
        this.mOnBufferingUpdateListener = null;
        this.mOnCompletionListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnVideoSizeChangedListener = null;
        this.mOnErrorListener = null;
        this.mOnInfoListener = null;
        this.mOnTimedTextListener = null;
    }

    protected final void notifyOnPrepared() {
        tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener onPreparedListener = this.mOnPreparedListener;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared(this);
        }
    }

    protected final void notifyOnCompletion() {
        tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener onCompletionListener = this.mOnCompletionListener;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion(this);
        }
    }

    protected final void notifyOnBufferingUpdate(int i) {
        tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = this.mOnBufferingUpdateListener;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(this, i);
        }
    }

    protected final void notifyOnSeekComplete() {
        tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = this.mOnSeekCompleteListener;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete(this);
        }
    }

    protected final void notifyOnVideoSizeChanged(int i, int i2, int i3, int i4) {
        tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(this, i, i2, i3, i4);
        }
    }

    protected final boolean notifyOnError(int i, int i2) {
        tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener onErrorListener = this.mOnErrorListener;
        return onErrorListener != null && onErrorListener.onError(this, i, i2);
    }

    protected final boolean notifyOnInfo(int i, int i2) {
        tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener onInfoListener = this.mOnInfoListener;
        return onInfoListener != null && onInfoListener.onInfo(this, i, i2);
    }

    protected final void notifyOnTimedText(tv.danmaku.ijk.media.player.IjkTimedText ijkTimedText) {
        tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener onTimedTextListener = this.mOnTimedTextListener;
        if (onTimedTextListener != null) {
            onTimedTextListener.onTimedText(this, ijkTimedText);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(tv.danmaku.ijk.media.player.misc.IMediaDataSource iMediaDataSource) {
        throw new java.lang.UnsupportedOperationException();
    }
}
