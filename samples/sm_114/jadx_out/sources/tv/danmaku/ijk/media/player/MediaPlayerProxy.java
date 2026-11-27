package tv.danmaku.ijk.media.player;

/* JADX INFO: loaded from: classes2.dex */
public class MediaPlayerProxy implements tv.danmaku.ijk.media.player.IMediaPlayer {
    protected final tv.danmaku.ijk.media.player.IMediaPlayer mBackEndMediaPlayer;

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return false;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean z) {
    }

    public MediaPlayerProxy(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
        this.mBackEndMediaPlayer = iMediaPlayer;
    }

    public tv.danmaku.ijk.media.player.IMediaPlayer getInternalMediaPlayer() {
        return this.mBackEndMediaPlayer;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(android.view.SurfaceHolder surfaceHolder) {
        this.mBackEndMediaPlayer.setDisplay(surfaceHolder);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(android.view.Surface surface) {
        this.mBackEndMediaPlayer.setSurface(surface);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(android.content.Context context, android.net.Uri uri) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        this.mBackEndMediaPlayer.setDataSource(context, uri);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(android.content.Context context, android.net.Uri uri, java.util.Map<java.lang.String, java.lang.String> map) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        this.mBackEndMediaPlayer.setDataSource(context, uri, map);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(java.io.FileDescriptor fileDescriptor) throws java.lang.IllegalStateException, java.io.IOException, java.lang.IllegalArgumentException {
        this.mBackEndMediaPlayer.setDataSource(fileDescriptor);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(java.lang.String str) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        this.mBackEndMediaPlayer.setDataSource(str);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(tv.danmaku.ijk.media.player.misc.IMediaDataSource iMediaDataSource) {
        this.mBackEndMediaPlayer.setDataSource(iMediaDataSource);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public java.lang.String getDataSource() {
        return this.mBackEndMediaPlayer.getDataSource();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() throws java.lang.IllegalStateException {
        this.mBackEndMediaPlayer.prepareAsync();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() throws java.lang.IllegalStateException {
        this.mBackEndMediaPlayer.start();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() throws java.lang.IllegalStateException {
        this.mBackEndMediaPlayer.stop();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() throws java.lang.IllegalStateException {
        this.mBackEndMediaPlayer.pause();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        this.mBackEndMediaPlayer.setScreenOnWhilePlaying(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.mBackEndMediaPlayer.getVideoWidth();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.mBackEndMediaPlayer.getVideoHeight();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlaying() {
        return this.mBackEndMediaPlayer.isPlaying();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void seekTo(long j) throws java.lang.IllegalStateException {
        this.mBackEndMediaPlayer.seekTo(j);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getCurrentPosition() {
        return this.mBackEndMediaPlayer.getCurrentPosition();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public long getDuration() {
        return this.mBackEndMediaPlayer.getDuration();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        this.mBackEndMediaPlayer.release();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        this.mBackEndMediaPlayer.reset();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setVolume(float f, float f2) {
        this.mBackEndMediaPlayer.setVolume(f, f2);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getAudioSessionId() {
        return this.mBackEndMediaPlayer.getAudioSessionId();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public tv.danmaku.ijk.media.player.MediaInfo getMediaInfo() {
        return this.mBackEndMediaPlayer.getMediaInfo();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnPreparedListener(final tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener onPreparedListener) {
        if (onPreparedListener != null) {
            this.mBackEndMediaPlayer.setOnPreparedListener(new tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener() { // from class: tv.danmaku.ijk.media.player.MediaPlayerProxy.1
                @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
                public void onPrepared(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
                    onPreparedListener.onPrepared(tv.danmaku.ijk.media.player.MediaPlayerProxy.this);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnPreparedListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnCompletionListener(final tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener onCompletionListener) {
        if (onCompletionListener != null) {
            this.mBackEndMediaPlayer.setOnCompletionListener(new tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener() { // from class: tv.danmaku.ijk.media.player.MediaPlayerProxy.2
                @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
                public void onCompletion(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
                    onCompletionListener.onCompletion(tv.danmaku.ijk.media.player.MediaPlayerProxy.this);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnCompletionListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnBufferingUpdateListener(final tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        if (onBufferingUpdateListener != null) {
            this.mBackEndMediaPlayer.setOnBufferingUpdateListener(new tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener() { // from class: tv.danmaku.ijk.media.player.MediaPlayerProxy.3
                @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
                public void onBufferingUpdate(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i) {
                    onBufferingUpdateListener.onBufferingUpdate(tv.danmaku.ijk.media.player.MediaPlayerProxy.this, i);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnBufferingUpdateListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnSeekCompleteListener(final tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        if (onSeekCompleteListener != null) {
            this.mBackEndMediaPlayer.setOnSeekCompleteListener(new tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener() { // from class: tv.danmaku.ijk.media.player.MediaPlayerProxy.4
                @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
                public void onSeekComplete(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
                    onSeekCompleteListener.onSeekComplete(tv.danmaku.ijk.media.player.MediaPlayerProxy.this);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnSeekCompleteListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnVideoSizeChangedListener(final tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener != null) {
            this.mBackEndMediaPlayer.setOnVideoSizeChangedListener(new tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener() { // from class: tv.danmaku.ijk.media.player.MediaPlayerProxy.5
                @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
                public void onVideoSizeChanged(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
                    onVideoSizeChangedListener.onVideoSizeChanged(tv.danmaku.ijk.media.player.MediaPlayerProxy.this, i, i2, i3, i4);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnVideoSizeChangedListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnErrorListener(final tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener onErrorListener) {
        if (onErrorListener != null) {
            this.mBackEndMediaPlayer.setOnErrorListener(new tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener() { // from class: tv.danmaku.ijk.media.player.MediaPlayerProxy.6
                @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
                public boolean onError(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2) {
                    return onErrorListener.onError(tv.danmaku.ijk.media.player.MediaPlayerProxy.this, i, i2);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnErrorListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnInfoListener(final tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener onInfoListener) {
        if (onInfoListener != null) {
            this.mBackEndMediaPlayer.setOnInfoListener(new tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener() { // from class: tv.danmaku.ijk.media.player.MediaPlayerProxy.7
                @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
                public boolean onInfo(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2) {
                    return onInfoListener.onInfo(tv.danmaku.ijk.media.player.MediaPlayerProxy.this, i, i2);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnInfoListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setOnTimedTextListener(final tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        if (onTimedTextListener != null) {
            this.mBackEndMediaPlayer.setOnTimedTextListener(new tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener() { // from class: tv.danmaku.ijk.media.player.MediaPlayerProxy.8
                @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener
                public void onTimedText(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, tv.danmaku.ijk.media.player.IjkTimedText ijkTimedText) {
                    onTimedTextListener.onTimedText(tv.danmaku.ijk.media.player.MediaPlayerProxy.this, ijkTimedText);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnTimedTextListener(null);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i) {
        this.mBackEndMediaPlayer.setAudioStreamType(i);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setKeepInBackground(boolean z) {
        this.mBackEndMediaPlayer.setKeepInBackground(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return this.mBackEndMediaPlayer.getVideoSarNum();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return this.mBackEndMediaPlayer.getVideoSarDen();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setWakeMode(android.content.Context context, int i) {
        this.mBackEndMediaPlayer.setWakeMode(context, i);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public tv.danmaku.ijk.media.player.misc.ITrackInfo[] getTrackInfo() {
        return this.mBackEndMediaPlayer.getTrackInfo();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z) {
        this.mBackEndMediaPlayer.setLooping(z);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        return this.mBackEndMediaPlayer.isLooping();
    }
}
