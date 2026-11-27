package io.dcloud.media.video.ijkplayer.media;

/* JADX INFO: loaded from: classes2.dex */
public class IjkVideoView extends android.widget.FrameLayout implements android.widget.MediaController.MediaPlayerControl {
    public static final int RENDER_NONE = 0;
    public static final int RENDER_SURFACE_VIEW = 1;
    public static final int RENDER_TEXTURE_VIEW = 2;
    private static final int[] s_allAspectRatio = {0, 1, 2, 4, 5};
    private java.lang.String TAG;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener bufferingUpdateListener;
    private android.widget.ImageView coverImage;
    private org.json.JSONArray customAdvanceJSON;
    private java.lang.String customUA;
    private io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy enumPlayStrategy;
    private io.dcloud.media.video.ijkplayer.media.AssetsDataSourceProvider fd;
    private boolean isHttpCacheOpen;
    private boolean isMediaReady;
    private boolean isSetSeekTo;
    private boolean isStoped;
    private android.content.Context mAppContext;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener;
    private boolean mCanPause;
    private boolean mCanSeekBack;
    private boolean mCanSeekForward;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener mCompletionListener;
    private int mCurrentAspectRatio;
    private int mCurrentBufferPercentage;
    private int mCurrentState;
    private boolean mEnableBackgroundPlay;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener mErrorListener;
    private java.util.Map<java.lang.String, java.lang.String> mHeaders;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener mInfoListener;
    private boolean mIsMediaCodecHandleResolutionChange;
    private boolean mIsNormalScreen;
    private boolean mIsUsingMediaCodec;
    private boolean mIsUsingMediaCodecAutoRotate;
    private boolean mIsUsingMediaDataSource;
    private boolean mIsUsingOpenSLES;
    private io.dcloud.media.video.ijkplayer.media.IMediaController mMediaController;
    private tv.danmaku.ijk.media.player.IMediaPlayer mMediaPlayer;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener mOnCompletionListener;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener mOnErrorListener;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener mOnInfoListener;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener mOnPreparedListener;
    private android.graphics.Matrix mOriginalMatrix;
    private java.lang.String mPixelFormat;
    private long mPrepareEndTime;
    private long mPrepareStartTime;
    tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener mPreparedListener;
    private io.dcloud.media.video.ijkplayer.media.IRenderView mRenderView;
    io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback mSHCallback;
    private android.graphics.Matrix mSaveMatrix;
    private int mScreenOrHeight;
    private int mScreenOrWidth;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener mSeekCompleteListener;
    private long mSeekEndTime;
    private long mSeekStartTime;
    private int mSeekWhenPrepared;
    tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener mSizeChangedListener;
    private int mSurfaceHeight;
    private io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder mSurfaceHolder;
    private int mSurfaceWidth;
    private int mTargetState;
    private android.net.Uri mUri;
    private int mVideoHeight;
    private int mVideoRotationDegree;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private float mVideoScale;
    private int mVideoTargetRotationDegree;
    private int mVideoWidth;
    private float volume;

    private void initBackground() {
    }

    public void enterBackground() {
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    public void stopBackgroundPlay() {
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public IjkVideoView(android.content.Context context) {
        super(context);
        this.TAG = "TTAG";
        this.mCurrentState = 330;
        this.mTargetState = 330;
        this.mSurfaceHolder = null;
        this.mMediaPlayer = null;
        this.mCanPause = true;
        this.mCanSeekBack = true;
        this.mCanSeekForward = true;
        this.mIsUsingMediaCodec = false;
        this.mIsUsingMediaCodecAutoRotate = false;
        this.mIsMediaCodecHandleResolutionChange = false;
        this.mIsUsingOpenSLES = false;
        this.enumPlayStrategy = io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy.DEFAULT;
        this.isHttpCacheOpen = false;
        this.mPixelFormat = "";
        this.mVideoScale = 1.0f;
        this.mIsNormalScreen = true;
        this.isStoped = false;
        this.mPrepareStartTime = 0L;
        this.mPrepareEndTime = 0L;
        this.mSeekStartTime = 0L;
        this.mSeekEndTime = 0L;
        this.customUA = "";
        this.customAdvanceJSON = new org.json.JSONArray();
        this.mSizeChangedListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.2
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarNum = iMediaPlayer.getVideoSarNum();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarDen = iMediaPlayer.getVideoSarDen();
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth == 0 || io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight == 0) {
                    return;
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoSize(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth, io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight);
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarNum, io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarDen);
                }
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.requestLayout();
            }
        };
        this.mPreparedListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.3
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mPrepareEndTime = java.lang.System.currentTimeMillis();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mCurrentState = 333;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this._notifyMediaStatus();
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnPreparedListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnPreparedListener.onPrepared(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer);
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.setEnabled(true);
                }
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
                int i = io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSeekWhenPrepared;
                if (i != 0) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.seekTo(i);
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth == 0 || io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight == 0) {
                    if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState == 334) {
                        io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.start();
                        return;
                    }
                    return;
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoSize(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth, io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight);
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarNum, io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarDen);
                    if (!io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.shouldWaitForResize() || (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceWidth == io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth && io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceHeight == io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight)) {
                        if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState == 334) {
                            io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.start();
                            if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.show();
                                return;
                            }
                            return;
                        }
                        if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.isPlaying()) {
                            return;
                        }
                        if ((i != 0 || io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.getCurrentPosition() > 0) && io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                            io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.show(0);
                        }
                    }
                }
            }
        };
        this.mCompletionListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.4
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public void onCompletion(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
                android.util.Log.w(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "OnCompletionListener:");
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mCurrentState = 336;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState = 336;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this._notifyMediaStatus();
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.hide();
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnCompletionListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnCompletionListener.onCompletion(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer);
                }
            }
        };
        this.mInfoListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.5
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2) {
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnInfoListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnInfoListener.onInfo(iMediaPlayer, i, i2);
                }
                if (i == 3) {
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_VIDEO_RENDERING_START:");
                    return true;
                }
                if (i == 901) {
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
                    return true;
                }
                if (i == 902) {
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
                    return true;
                }
                if (i == 10001) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoRotationDegree = i2;
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                    if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView == null) {
                        return true;
                    }
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoRotation(i2);
                    return true;
                }
                if (i != 10002) {
                    switch (i) {
                        case 700:
                            android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                            break;
                        case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                            android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_BUFFERING_START:");
                            break;
                        case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                            android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_BUFFERING_END:");
                            break;
                        case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                            android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2);
                            break;
                        default:
                            switch (i) {
                                case 800:
                                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_BAD_INTERLEAVING:");
                                    break;
                                case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_NOT_SEEKABLE:");
                                    break;
                                case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_METADATA_UPDATE:");
                                    break;
                            }
                            break;
                    }
                    return true;
                }
                android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_AUDIO_RENDERING_START:");
                return true;
            }
        };
        this.mErrorListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.6
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public boolean onError(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2) {
                android.util.Log.d("TTAG", "Error: " + i + "," + i2);
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mCurrentState = 331;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState = 331;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this._notifyMediaStatus();
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.hide();
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnErrorListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnErrorListener.onError(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer, i, i2);
                }
                return true;
            }
        };
        this.mBufferingUpdateListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.7
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i) {
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mCurrentBufferPercentage = i;
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.bufferingUpdateListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.bufferingUpdateListener.onBufferingUpdate(iMediaPlayer, i);
                }
            }
        };
        this.mSeekCompleteListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.8
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSeekEndTime = java.lang.System.currentTimeMillis();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnInfoListener.onInfo(iMediaPlayer, 337, -1);
            }
        };
        this.mSHCallback = new io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.9
            @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback
            public void onSurfaceChanged(io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder iSurfaceHolder, int i, int i2, int i3) {
                if (iSurfaceHolder.getRenderView() != io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView) {
                    android.util.Log.e(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceWidth = i2;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceHeight = i3;
                boolean z = true;
                boolean z2 = io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState == 334;
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.shouldWaitForResize() && (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth != i2 || io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight != i3)) {
                    z = false;
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer != null && z2 && z) {
                    if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSeekWhenPrepared != 0) {
                        io.dcloud.media.video.ijkplayer.media.IjkVideoView ijkVideoView = io.dcloud.media.video.ijkplayer.media.IjkVideoView.this;
                        ijkVideoView.seekTo(ijkVideoView.mSeekWhenPrepared);
                    }
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.start();
                }
            }

            @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback
            public void onSurfaceCreated(io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder iSurfaceHolder, int i, int i2) {
                if (iSurfaceHolder.getRenderView() != io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView) {
                    android.util.Log.e(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceHolder = iSurfaceHolder;
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer == null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.openVideo();
                } else {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView ijkVideoView = io.dcloud.media.video.ijkplayer.media.IjkVideoView.this;
                    ijkVideoView.bindSurfaceHolder(ijkVideoView.mMediaPlayer, iSurfaceHolder);
                }
            }

            @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback
            public void onSurfaceDestroyed(io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder iSurfaceHolder) {
                if (iSurfaceHolder.getRenderView() != io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView) {
                    android.util.Log.e(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "onSurfaceDestroyed: unmatched render callback\n");
                } else {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceHolder = null;
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.releaseWithoutStop();
                }
            }
        };
        this.isMediaReady = true;
        this.volume = 0.0f;
        this.isSetSeekTo = false;
        this.mCurrentAspectRatio = s_allAspectRatio[0];
        this.mEnableBackgroundPlay = false;
        initVideoView(context);
    }

    public IjkVideoView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "TTAG";
        this.mCurrentState = 330;
        this.mTargetState = 330;
        this.mSurfaceHolder = null;
        this.mMediaPlayer = null;
        this.mCanPause = true;
        this.mCanSeekBack = true;
        this.mCanSeekForward = true;
        this.mIsUsingMediaCodec = false;
        this.mIsUsingMediaCodecAutoRotate = false;
        this.mIsMediaCodecHandleResolutionChange = false;
        this.mIsUsingOpenSLES = false;
        this.enumPlayStrategy = io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy.DEFAULT;
        this.isHttpCacheOpen = false;
        this.mPixelFormat = "";
        this.mVideoScale = 1.0f;
        this.mIsNormalScreen = true;
        this.isStoped = false;
        this.mPrepareStartTime = 0L;
        this.mPrepareEndTime = 0L;
        this.mSeekStartTime = 0L;
        this.mSeekEndTime = 0L;
        this.customUA = "";
        this.customAdvanceJSON = new org.json.JSONArray();
        this.mSizeChangedListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.2
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarNum = iMediaPlayer.getVideoSarNum();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarDen = iMediaPlayer.getVideoSarDen();
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth == 0 || io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight == 0) {
                    return;
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoSize(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth, io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight);
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarNum, io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarDen);
                }
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.requestLayout();
            }
        };
        this.mPreparedListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.3
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mPrepareEndTime = java.lang.System.currentTimeMillis();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mCurrentState = 333;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this._notifyMediaStatus();
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnPreparedListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnPreparedListener.onPrepared(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer);
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.setEnabled(true);
                }
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
                int i = io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSeekWhenPrepared;
                if (i != 0) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.seekTo(i);
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth == 0 || io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight == 0) {
                    if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState == 334) {
                        io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.start();
                        return;
                    }
                    return;
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoSize(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth, io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight);
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarNum, io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarDen);
                    if (!io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.shouldWaitForResize() || (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceWidth == io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth && io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceHeight == io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight)) {
                        if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState == 334) {
                            io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.start();
                            if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.show();
                                return;
                            }
                            return;
                        }
                        if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.isPlaying()) {
                            return;
                        }
                        if ((i != 0 || io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.getCurrentPosition() > 0) && io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                            io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.show(0);
                        }
                    }
                }
            }
        };
        this.mCompletionListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.4
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public void onCompletion(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
                android.util.Log.w(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "OnCompletionListener:");
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mCurrentState = 336;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState = 336;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this._notifyMediaStatus();
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.hide();
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnCompletionListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnCompletionListener.onCompletion(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer);
                }
            }
        };
        this.mInfoListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.5
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2) {
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnInfoListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnInfoListener.onInfo(iMediaPlayer, i, i2);
                }
                if (i == 3) {
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_VIDEO_RENDERING_START:");
                    return true;
                }
                if (i == 901) {
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
                    return true;
                }
                if (i == 902) {
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
                    return true;
                }
                if (i == 10001) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoRotationDegree = i2;
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                    if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView == null) {
                        return true;
                    }
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoRotation(i2);
                    return true;
                }
                if (i != 10002) {
                    switch (i) {
                        case 700:
                            android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                            break;
                        case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                            android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_BUFFERING_START:");
                            break;
                        case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                            android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_BUFFERING_END:");
                            break;
                        case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                            android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2);
                            break;
                        default:
                            switch (i) {
                                case 800:
                                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_BAD_INTERLEAVING:");
                                    break;
                                case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_NOT_SEEKABLE:");
                                    break;
                                case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_METADATA_UPDATE:");
                                    break;
                            }
                            break;
                    }
                    return true;
                }
                android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_AUDIO_RENDERING_START:");
                return true;
            }
        };
        this.mErrorListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.6
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public boolean onError(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2) {
                android.util.Log.d("TTAG", "Error: " + i + "," + i2);
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mCurrentState = 331;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState = 331;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this._notifyMediaStatus();
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.hide();
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnErrorListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnErrorListener.onError(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer, i, i2);
                }
                return true;
            }
        };
        this.mBufferingUpdateListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.7
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i) {
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mCurrentBufferPercentage = i;
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.bufferingUpdateListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.bufferingUpdateListener.onBufferingUpdate(iMediaPlayer, i);
                }
            }
        };
        this.mSeekCompleteListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.8
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSeekEndTime = java.lang.System.currentTimeMillis();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnInfoListener.onInfo(iMediaPlayer, 337, -1);
            }
        };
        this.mSHCallback = new io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.9
            @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback
            public void onSurfaceChanged(io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder iSurfaceHolder, int i, int i2, int i3) {
                if (iSurfaceHolder.getRenderView() != io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView) {
                    android.util.Log.e(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceWidth = i2;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceHeight = i3;
                boolean z = true;
                boolean z2 = io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState == 334;
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.shouldWaitForResize() && (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth != i2 || io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight != i3)) {
                    z = false;
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer != null && z2 && z) {
                    if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSeekWhenPrepared != 0) {
                        io.dcloud.media.video.ijkplayer.media.IjkVideoView ijkVideoView = io.dcloud.media.video.ijkplayer.media.IjkVideoView.this;
                        ijkVideoView.seekTo(ijkVideoView.mSeekWhenPrepared);
                    }
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.start();
                }
            }

            @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback
            public void onSurfaceCreated(io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder iSurfaceHolder, int i, int i2) {
                if (iSurfaceHolder.getRenderView() != io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView) {
                    android.util.Log.e(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceHolder = iSurfaceHolder;
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer == null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.openVideo();
                } else {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView ijkVideoView = io.dcloud.media.video.ijkplayer.media.IjkVideoView.this;
                    ijkVideoView.bindSurfaceHolder(ijkVideoView.mMediaPlayer, iSurfaceHolder);
                }
            }

            @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback
            public void onSurfaceDestroyed(io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder iSurfaceHolder) {
                if (iSurfaceHolder.getRenderView() != io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView) {
                    android.util.Log.e(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "onSurfaceDestroyed: unmatched render callback\n");
                } else {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceHolder = null;
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.releaseWithoutStop();
                }
            }
        };
        this.isMediaReady = true;
        this.volume = 0.0f;
        this.isSetSeekTo = false;
        this.mCurrentAspectRatio = s_allAspectRatio[0];
        this.mEnableBackgroundPlay = false;
        initVideoView(context);
    }

    public IjkVideoView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "TTAG";
        this.mCurrentState = 330;
        this.mTargetState = 330;
        this.mSurfaceHolder = null;
        this.mMediaPlayer = null;
        this.mCanPause = true;
        this.mCanSeekBack = true;
        this.mCanSeekForward = true;
        this.mIsUsingMediaCodec = false;
        this.mIsUsingMediaCodecAutoRotate = false;
        this.mIsMediaCodecHandleResolutionChange = false;
        this.mIsUsingOpenSLES = false;
        this.enumPlayStrategy = io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy.DEFAULT;
        this.isHttpCacheOpen = false;
        this.mPixelFormat = "";
        this.mVideoScale = 1.0f;
        this.mIsNormalScreen = true;
        this.isStoped = false;
        this.mPrepareStartTime = 0L;
        this.mPrepareEndTime = 0L;
        this.mSeekStartTime = 0L;
        this.mSeekEndTime = 0L;
        this.customUA = "";
        this.customAdvanceJSON = new org.json.JSONArray();
        this.mSizeChangedListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.2
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i2, int i3, int i4, int i5) {
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarNum = iMediaPlayer.getVideoSarNum();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarDen = iMediaPlayer.getVideoSarDen();
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth == 0 || io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight == 0) {
                    return;
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoSize(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth, io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight);
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarNum, io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarDen);
                }
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.requestLayout();
            }
        };
        this.mPreparedListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.3
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mPrepareEndTime = java.lang.System.currentTimeMillis();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mCurrentState = 333;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this._notifyMediaStatus();
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnPreparedListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnPreparedListener.onPrepared(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer);
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.setEnabled(true);
                }
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
                int i2 = io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSeekWhenPrepared;
                if (i2 != 0) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.seekTo(i2);
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth == 0 || io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight == 0) {
                    if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState == 334) {
                        io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.start();
                        return;
                    }
                    return;
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoSize(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth, io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight);
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarNum, io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarDen);
                    if (!io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.shouldWaitForResize() || (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceWidth == io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth && io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceHeight == io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight)) {
                        if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState == 334) {
                            io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.start();
                            if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.show();
                                return;
                            }
                            return;
                        }
                        if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.isPlaying()) {
                            return;
                        }
                        if ((i2 != 0 || io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.getCurrentPosition() > 0) && io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                            io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.show(0);
                        }
                    }
                }
            }
        };
        this.mCompletionListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.4
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public void onCompletion(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
                android.util.Log.w(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "OnCompletionListener:");
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mCurrentState = 336;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState = 336;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this._notifyMediaStatus();
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.hide();
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnCompletionListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnCompletionListener.onCompletion(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer);
                }
            }
        };
        this.mInfoListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.5
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i2, int i3) {
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnInfoListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnInfoListener.onInfo(iMediaPlayer, i2, i3);
                }
                if (i2 == 3) {
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_VIDEO_RENDERING_START:");
                    return true;
                }
                if (i2 == 901) {
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
                    return true;
                }
                if (i2 == 902) {
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
                    return true;
                }
                if (i2 == 10001) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoRotationDegree = i3;
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i3);
                    if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView == null) {
                        return true;
                    }
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoRotation(i3);
                    return true;
                }
                if (i2 != 10002) {
                    switch (i2) {
                        case 700:
                            android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                            break;
                        case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                            android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_BUFFERING_START:");
                            break;
                        case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                            android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_BUFFERING_END:");
                            break;
                        case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                            android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_NETWORK_BANDWIDTH: " + i3);
                            break;
                        default:
                            switch (i2) {
                                case 800:
                                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_BAD_INTERLEAVING:");
                                    break;
                                case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_NOT_SEEKABLE:");
                                    break;
                                case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_METADATA_UPDATE:");
                                    break;
                            }
                            break;
                    }
                    return true;
                }
                android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_AUDIO_RENDERING_START:");
                return true;
            }
        };
        this.mErrorListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.6
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public boolean onError(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i2, int i3) {
                android.util.Log.d("TTAG", "Error: " + i2 + "," + i3);
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mCurrentState = 331;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState = 331;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this._notifyMediaStatus();
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.hide();
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnErrorListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnErrorListener.onError(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer, i2, i3);
                }
                return true;
            }
        };
        this.mBufferingUpdateListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.7
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i2) {
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mCurrentBufferPercentage = i2;
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.bufferingUpdateListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.bufferingUpdateListener.onBufferingUpdate(iMediaPlayer, i2);
                }
            }
        };
        this.mSeekCompleteListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.8
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSeekEndTime = java.lang.System.currentTimeMillis();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnInfoListener.onInfo(iMediaPlayer, 337, -1);
            }
        };
        this.mSHCallback = new io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.9
            @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback
            public void onSurfaceChanged(io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i3, int i4) {
                if (iSurfaceHolder.getRenderView() != io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView) {
                    android.util.Log.e(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceWidth = i3;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceHeight = i4;
                boolean z = true;
                boolean z2 = io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState == 334;
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.shouldWaitForResize() && (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth != i3 || io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight != i4)) {
                    z = false;
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer != null && z2 && z) {
                    if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSeekWhenPrepared != 0) {
                        io.dcloud.media.video.ijkplayer.media.IjkVideoView ijkVideoView = io.dcloud.media.video.ijkplayer.media.IjkVideoView.this;
                        ijkVideoView.seekTo(ijkVideoView.mSeekWhenPrepared);
                    }
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.start();
                }
            }

            @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback
            public void onSurfaceCreated(io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder iSurfaceHolder, int i2, int i3) {
                if (iSurfaceHolder.getRenderView() != io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView) {
                    android.util.Log.e(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceHolder = iSurfaceHolder;
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer == null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.openVideo();
                } else {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView ijkVideoView = io.dcloud.media.video.ijkplayer.media.IjkVideoView.this;
                    ijkVideoView.bindSurfaceHolder(ijkVideoView.mMediaPlayer, iSurfaceHolder);
                }
            }

            @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback
            public void onSurfaceDestroyed(io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder iSurfaceHolder) {
                if (iSurfaceHolder.getRenderView() != io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView) {
                    android.util.Log.e(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "onSurfaceDestroyed: unmatched render callback\n");
                } else {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceHolder = null;
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.releaseWithoutStop();
                }
            }
        };
        this.isMediaReady = true;
        this.volume = 0.0f;
        this.isSetSeekTo = false;
        this.mCurrentAspectRatio = s_allAspectRatio[0];
        this.mEnableBackgroundPlay = false;
        initVideoView(context);
    }

    public IjkVideoView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.TAG = "TTAG";
        this.mCurrentState = 330;
        this.mTargetState = 330;
        this.mSurfaceHolder = null;
        this.mMediaPlayer = null;
        this.mCanPause = true;
        this.mCanSeekBack = true;
        this.mCanSeekForward = true;
        this.mIsUsingMediaCodec = false;
        this.mIsUsingMediaCodecAutoRotate = false;
        this.mIsMediaCodecHandleResolutionChange = false;
        this.mIsUsingOpenSLES = false;
        this.enumPlayStrategy = io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy.DEFAULT;
        this.isHttpCacheOpen = false;
        this.mPixelFormat = "";
        this.mVideoScale = 1.0f;
        this.mIsNormalScreen = true;
        this.isStoped = false;
        this.mPrepareStartTime = 0L;
        this.mPrepareEndTime = 0L;
        this.mSeekStartTime = 0L;
        this.mSeekEndTime = 0L;
        this.customUA = "";
        this.customAdvanceJSON = new org.json.JSONArray();
        this.mSizeChangedListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.2
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i3, int i4, int i5, int i6) {
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarNum = iMediaPlayer.getVideoSarNum();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarDen = iMediaPlayer.getVideoSarDen();
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth == 0 || io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight == 0) {
                    return;
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoSize(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth, io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight);
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarNum, io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarDen);
                }
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.requestLayout();
            }
        };
        this.mPreparedListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.3
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mPrepareEndTime = java.lang.System.currentTimeMillis();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mCurrentState = 333;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this._notifyMediaStatus();
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnPreparedListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnPreparedListener.onPrepared(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer);
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.setEnabled(true);
                }
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
                int i3 = io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSeekWhenPrepared;
                if (i3 != 0) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.seekTo(i3);
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth == 0 || io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight == 0) {
                    if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState == 334) {
                        io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.start();
                        return;
                    }
                    return;
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoSize(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth, io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight);
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarNum, io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoSarDen);
                    if (!io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.shouldWaitForResize() || (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceWidth == io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth && io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceHeight == io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight)) {
                        if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState == 334) {
                            io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.start();
                            if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.show();
                                return;
                            }
                            return;
                        }
                        if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.isPlaying()) {
                            return;
                        }
                        if ((i3 != 0 || io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.getCurrentPosition() > 0) && io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                            io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.show(0);
                        }
                    }
                }
            }
        };
        this.mCompletionListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.4
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public void onCompletion(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
                android.util.Log.w(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "OnCompletionListener:");
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mCurrentState = 336;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState = 336;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this._notifyMediaStatus();
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.hide();
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnCompletionListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnCompletionListener.onCompletion(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer);
                }
            }
        };
        this.mInfoListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.5
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i3, int i4) {
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnInfoListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnInfoListener.onInfo(iMediaPlayer, i3, i4);
                }
                if (i3 == 3) {
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_VIDEO_RENDERING_START:");
                    return true;
                }
                if (i3 == 901) {
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
                    return true;
                }
                if (i3 == 902) {
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
                    return true;
                }
                if (i3 == 10001) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoRotationDegree = i4;
                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i4);
                    if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView == null) {
                        return true;
                    }
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoRotation(i4);
                    return true;
                }
                if (i3 != 10002) {
                    switch (i3) {
                        case 700:
                            android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                            break;
                        case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                            android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_BUFFERING_START:");
                            break;
                        case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                            android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_BUFFERING_END:");
                            break;
                        case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                            android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_NETWORK_BANDWIDTH: " + i4);
                            break;
                        default:
                            switch (i3) {
                                case 800:
                                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_BAD_INTERLEAVING:");
                                    break;
                                case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_NOT_SEEKABLE:");
                                    break;
                                case tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                                    android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_METADATA_UPDATE:");
                                    break;
                            }
                            break;
                    }
                    return true;
                }
                android.util.Log.d(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "MEDIA_INFO_AUDIO_RENDERING_START:");
                return true;
            }
        };
        this.mErrorListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.6
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public boolean onError(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i3, int i4) {
                android.util.Log.d("TTAG", "Error: " + i3 + "," + i4);
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mCurrentState = 331;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState = 331;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this._notifyMediaStatus();
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaController.hide();
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnErrorListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnErrorListener.onError(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer, i3, i4);
                }
                return true;
            }
        };
        this.mBufferingUpdateListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.7
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i3) {
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mCurrentBufferPercentage = i3;
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.bufferingUpdateListener != null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.bufferingUpdateListener.onBufferingUpdate(iMediaPlayer, i3);
                }
            }
        };
        this.mSeekCompleteListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.8
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSeekEndTime = java.lang.System.currentTimeMillis();
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mOnInfoListener.onInfo(iMediaPlayer, 337, -1);
            }
        };
        this.mSHCallback = new io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.9
            @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback
            public void onSurfaceChanged(io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder iSurfaceHolder, int i3, int i4, int i5) {
                if (iSurfaceHolder.getRenderView() != io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView) {
                    android.util.Log.e(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "onSurfaceChanged: unmatched render callback\n");
                    return;
                }
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceWidth = i4;
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceHeight = i5;
                boolean z = true;
                boolean z2 = io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mTargetState == 334;
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.shouldWaitForResize() && (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoWidth != i4 || io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoHeight != i5)) {
                    z = false;
                }
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer != null && z2 && z) {
                    if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSeekWhenPrepared != 0) {
                        io.dcloud.media.video.ijkplayer.media.IjkVideoView ijkVideoView = io.dcloud.media.video.ijkplayer.media.IjkVideoView.this;
                        ijkVideoView.seekTo(ijkVideoView.mSeekWhenPrepared);
                    }
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.start();
                }
            }

            @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback
            public void onSurfaceCreated(io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder iSurfaceHolder, int i3, int i4) {
                if (iSurfaceHolder.getRenderView() != io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView) {
                    android.util.Log.e(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "onSurfaceCreated: unmatched render callback\n");
                    return;
                }
                io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceHolder = iSurfaceHolder;
                if (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer == null) {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.openVideo();
                } else {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView ijkVideoView = io.dcloud.media.video.ijkplayer.media.IjkVideoView.this;
                    ijkVideoView.bindSurfaceHolder(ijkVideoView.mMediaPlayer, iSurfaceHolder);
                }
            }

            @Override // io.dcloud.media.video.ijkplayer.media.IRenderView.IRenderCallback
            public void onSurfaceDestroyed(io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder iSurfaceHolder) {
                if (iSurfaceHolder.getRenderView() != io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView) {
                    android.util.Log.e(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.TAG, "onSurfaceDestroyed: unmatched render callback\n");
                } else {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSurfaceHolder = null;
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.releaseWithoutStop();
                }
            }
        };
        this.isMediaReady = true;
        this.volume = 0.0f;
        this.isSetSeekTo = false;
        this.mCurrentAspectRatio = s_allAspectRatio[0];
        this.mEnableBackgroundPlay = false;
        initVideoView(context);
    }

    private void initVideoView(android.content.Context context) {
        this.mAppContext = context.getApplicationContext();
        initBackground();
        initRenders();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.mCurrentState = 330;
        this.mTargetState = 330;
        _notifyMediaStatus();
        android.widget.ImageView imageView = new android.widget.ImageView(getContext());
        this.coverImage = imageView;
        imageView.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        this.coverImage.setBackgroundColor(-16777216);
        this.coverImage.setVisibility(8);
        addView(this.coverImage, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    public void setmIsUsingMediaCodec(boolean z) {
        this.mIsUsingMediaCodec = z;
    }

    public void setIsHttpCacheOpen(boolean z) {
        this.isHttpCacheOpen = z;
    }

    public void setFlowStrategy(io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy enumPlayStrategy) {
        this.enumPlayStrategy = enumPlayStrategy;
    }

    public void setRenderView(io.dcloud.media.video.ijkplayer.media.IRenderView iRenderView) {
        int i;
        int i2;
        if (this.mRenderView != null) {
            tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer = this.mMediaPlayer;
            if (iMediaPlayer != null) {
                iMediaPlayer.setDisplay(null);
            }
            android.view.View view = this.mRenderView.getView();
            this.mRenderView.removeRenderCallback(this.mSHCallback);
            this.mRenderView = null;
            removeView(view);
        }
        if (iRenderView == null) {
            return;
        }
        this.mRenderView = iRenderView;
        iRenderView.setAspectRatio(this.mCurrentAspectRatio);
        int i3 = this.mVideoWidth;
        if (i3 > 0 && (i2 = this.mVideoHeight) > 0) {
            iRenderView.setVideoSize(i3, i2);
        }
        int i4 = this.mVideoSarNum;
        if (i4 > 0 && (i = this.mVideoSarDen) > 0) {
            iRenderView.setVideoSampleAspectRatio(i4, i);
        }
        android.view.View view2 = this.mRenderView.getView();
        view2.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -2, 17));
        addView(view2);
        this.mRenderView.addRenderCallback(this.mSHCallback);
        this.mRenderView.setVideoRotation(this.mVideoRotationDegree);
    }

    public void setVideoRotation(int i) {
        int i2 = this.mVideoRotationDegree + i;
        this.mVideoTargetRotationDegree = i2;
        this.mRenderView.setVideoRotation(i2);
    }

    public android.graphics.Matrix getVideoTransform() {
        if (this.mOriginalMatrix == null) {
            this.mOriginalMatrix = this.mRenderView.getTransform();
        }
        return this.mRenderView.getTransform();
    }

    public void setVideoTransform(android.graphics.Matrix matrix) {
        this.mRenderView.setTransform(matrix);
    }

    public boolean adjustVideoView(float f) {
        float f2 = this.mVideoScale * f;
        this.mVideoScale = f2;
        int i = this.mVideoTargetRotationDegree;
        int i2 = (i + 360) % 360;
        if (f2 == 1.0f && i2 == 0) {
            return false;
        }
        if (i2 > 315 || i2 <= 45) {
            this.mVideoRotationDegree = 0;
        } else if (i2 > 45 && i2 <= 135) {
            this.mVideoRotationDegree = 90;
        } else if (i2 > 135 && i2 <= 225) {
            this.mVideoRotationDegree = 180;
        } else if (i2 > 225 && i2 <= 315) {
            this.mVideoRotationDegree = 270;
        } else {
            this.mVideoRotationDegree = 0;
        }
        int i3 = this.mVideoRotationDegree;
        final int i4 = i3 - i;
        this.mVideoTargetRotationDegree = i3;
        final android.graphics.Matrix videoTransform = getVideoTransform();
        if (this.mScreenOrWidth == 0 || this.mScreenOrHeight == 0) {
            this.mScreenOrWidth = this.mRenderView.getView().getWidth();
            this.mScreenOrHeight = this.mRenderView.getView().getHeight();
        }
        if (!this.mIsNormalScreen) {
            float f3 = this.mVideoScale;
            videoTransform.preScale(f3, f3);
            float f4 = this.mScreenOrWidth;
            float f5 = this.mVideoScale;
            videoTransform.postTranslate((f4 * (1.0f - f5)) / 2.0f, (this.mScreenOrHeight * (1.0f - f5)) / 2.0f);
            this.mRenderView.setTransform(videoTransform);
            this.mIsNormalScreen = true;
        } else {
            float[] fArr = new float[2];
            videoTransform.mapPoints(fArr);
            float f6 = this.mScreenOrWidth;
            float f7 = this.mVideoScale;
            final float f8 = ((f6 * (1.0f - f7)) / 2.0f) - fArr[0];
            final float f9 = ((this.mScreenOrHeight * (1.0f - f7)) / 2.0f) - fArr[1];
            if (this.mSaveMatrix == null) {
                this.mSaveMatrix = new android.graphics.Matrix();
            }
            android.animation.ValueAnimator duration = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
            duration.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSaveMatrix.set(videoTransform);
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSaveMatrix.postTranslate(f8 * fFloatValue, f9 * fFloatValue);
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setTransform(io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mSaveMatrix);
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mRenderView.setVideoRotation((int) (io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mVideoRotationDegree - (i4 * (1.0f - fFloatValue))));
                }
            });
            duration.start();
        }
        return true;
    }

    public void resetVideoView(boolean z) {
        this.mIsNormalScreen = z;
        this.mVideoRotationDegree = 0;
        if (z) {
            this.mVideoTargetRotationDegree = 0;
            this.mVideoScale = 1.0f;
        }
        this.mRenderView.setTransform(this.mOriginalMatrix);
        this.mRenderView.setVideoRotation(this.mVideoRotationDegree);
    }

    public void setRender(int i) {
        if (i == 0) {
            setRenderView(null);
            return;
        }
        if (i == 1) {
            setRenderView(new io.dcloud.media.video.ijkplayer.media.SurfaceRenderView(getContext()));
            return;
        }
        if (i == 2) {
            io.dcloud.media.video.ijkplayer.media.TextureRenderView textureRenderView = new io.dcloud.media.video.ijkplayer.media.TextureRenderView(getContext());
            if (this.mMediaPlayer != null) {
                textureRenderView.getSurfaceHolder().bindToMediaPlayer(this.mMediaPlayer);
                textureRenderView.setVideoSize(this.mMediaPlayer.getVideoWidth(), this.mMediaPlayer.getVideoHeight());
                textureRenderView.setVideoSampleAspectRatio(this.mMediaPlayer.getVideoSarNum(), this.mMediaPlayer.getVideoSarDen());
                textureRenderView.setAspectRatio(this.mCurrentAspectRatio);
            }
            setRenderView(textureRenderView);
            return;
        }
        android.util.Log.e(this.TAG, java.lang.String.format(java.util.Locale.US, "invalid render %d\n", java.lang.Integer.valueOf(i)));
    }

    public void setCustomAdvanced(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.customAdvanceJSON = new org.json.JSONArray(str);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public void setVideoURI(android.net.Uri uri, java.lang.String str) {
        this.customUA = "";
        new java.util.HashMap();
        java.util.HashMap map = new java.util.HashMap();
        java.util.HashMap map2 = new java.util.HashMap();
        try {
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> map3 = java.net.CookieHandler.getDefault().get(java.net.URI.create(uri.toString()), map);
            if (map3 != null) {
                for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : map3.entrySet()) {
                    java.lang.String key = entry.getKey();
                    java.util.List<java.lang.String> value = entry.getValue();
                    if (key.equalsIgnoreCase(io.dcloud.common.DHInterface.IWebview.COOKIE) || key.equalsIgnoreCase("Cookie2")) {
                        map2.put(key, dc.squareup.okhttp3.internal.http.BridgeInterceptor.buildCookieHeader(value));
                    }
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            map2 = new java.util.HashMap();
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                java.lang.String next = itKeys.next();
                java.lang.String strOptString = jSONObject.optString(next);
                if (!android.text.TextUtils.isEmpty(next)) {
                    if (io.dcloud.common.DHInterface.IWebview.USER_AGENT.equalsIgnoreCase(next)) {
                        this.customUA = strOptString;
                    } else {
                        map2.put(next, strOptString);
                    }
                }
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        setVideoURI(uri, map2);
    }

    public void setVideoFileDescriptor(io.dcloud.media.video.ijkplayer.media.AssetsDataSourceProvider assetsDataSourceProvider) {
        this.fd = assetsDataSourceProvider;
        this.mSeekWhenPrepared = 0;
        this.isSetSeekTo = false;
        openVideo();
        requestLayout();
        invalidate();
    }

    private void setVideoURI(android.net.Uri uri, java.util.Map<java.lang.String, java.lang.String> map) {
        this.mUri = uri;
        this.mHeaders = map;
        this.mSeekWhenPrepared = 0;
        this.isSetSeekTo = false;
        openVideo();
        requestLayout();
        invalidate();
    }

    public android.net.Uri getUri() {
        return this.mUri;
    }

    public void setSpeed(float f) {
        tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer instanceof tv.danmaku.ijk.media.player.IjkMediaPlayer) {
            ((tv.danmaku.ijk.media.player.IjkMediaPlayer) iMediaPlayer).setSpeed(f);
        } else if (iMediaPlayer instanceof tv.danmaku.ijk.media.player.TextureMediaPlayer) {
            tv.danmaku.ijk.media.player.IjkMediaPlayer ijkMediaPlayer = (tv.danmaku.ijk.media.player.IjkMediaPlayer) ((tv.danmaku.ijk.media.player.TextureMediaPlayer) iMediaPlayer).getInternalMediaPlayer();
            if (ijkMediaPlayer instanceof tv.danmaku.ijk.media.player.IjkMediaPlayer) {
                ijkMediaPlayer.setSpeed(f);
            }
        }
    }

    public android.graphics.Bitmap getScreenshot() {
        io.dcloud.media.video.ijkplayer.media.IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            return iRenderView.getVideoScreenshot();
        }
        return null;
    }

    public void stopPlayback() {
        tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = 330;
            this.mTargetState = 330;
            _notifyMediaStatus();
            ((android.media.AudioManager) this.mAppContext.getSystemService("audio")).abandonAudioFocus(null);
            this.isStoped = true;
            showCoverImage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openVideo() {
        android.net.Uri uri = this.mUri;
        if ((uri == null && this.fd == null) || this.mSurfaceHolder == null) {
            if (uri == null && this.fd == null) {
                this.mCurrentState = 331;
                this.mTargetState = 331;
                this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
                return;
            }
            return;
        }
        release(false);
        try {
            this.mMediaPlayer = createPlayer(2);
            if (!this.isMediaReady) {
                setvolume(this.volume);
                this.isMediaReady = true;
            }
            getContext();
            this.mMediaPlayer.setOnPreparedListener(this.mPreparedListener);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.mSizeChangedListener);
            this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
            this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
            this.mMediaPlayer.setOnInfoListener(this.mInfoListener);
            this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
            this.mMediaPlayer.setOnSeekCompleteListener(this.mSeekCompleteListener);
            this.mCurrentBufferPercentage = 0;
            android.net.Uri uri2 = this.mUri;
            if (uri2 != null) {
                java.lang.String scheme = uri2.getScheme();
                if (android.os.Build.VERSION.SDK_INT >= 23 && this.mIsUsingMediaDataSource && (android.text.TextUtils.isEmpty(scheme) || scheme.equalsIgnoreCase("file"))) {
                    this.mMediaPlayer.setDataSource(new io.dcloud.media.video.ijkplayer.media.FileMediaDataSource(new java.io.File(this.mUri.toString())));
                } else {
                    this.mMediaPlayer.setDataSource(this.mAppContext, this.mUri, this.mHeaders);
                }
            } else {
                io.dcloud.media.video.ijkplayer.media.AssetsDataSourceProvider assetsDataSourceProvider = this.fd;
                if (assetsDataSourceProvider != null) {
                    this.mMediaPlayer.setDataSource(assetsDataSourceProvider);
                }
            }
            bindSurfaceHolder(this.mMediaPlayer, this.mSurfaceHolder);
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
            this.mPrepareStartTime = java.lang.System.currentTimeMillis();
            this.mMediaPlayer.prepareAsync();
            this.mCurrentState = 332;
            attachMediaController();
        } catch (java.io.IOException unused) {
            this.mCurrentState = 331;
            this.mTargetState = 331;
            this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
        } catch (java.lang.IllegalArgumentException unused2) {
            this.mCurrentState = 331;
            this.mTargetState = 331;
            this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
        } finally {
            _notifyMediaStatus();
        }
    }

    public void setMediaController(io.dcloud.media.video.ijkplayer.media.IMediaController iMediaController) {
        io.dcloud.media.video.ijkplayer.media.IMediaController iMediaController2 = this.mMediaController;
        if (iMediaController2 != null) {
            iMediaController2.hide();
        }
        this.mMediaController = iMediaController;
        attachMediaController();
    }

    private void attachMediaController() {
        io.dcloud.media.video.ijkplayer.media.IMediaController iMediaController;
        if (this.mMediaPlayer == null || (iMediaController = this.mMediaController) == null) {
            return;
        }
        iMediaController.setMediaPlayer(this);
        this.mMediaController.setAnchorView(getParent() instanceof android.view.View ? (android.view.View) getParent() : this);
        this.mMediaController.setEnabled(isInPlaybackState());
    }

    public tv.danmaku.ijk.media.player.IMediaPlayer getMediaPlayer() {
        return this.mMediaPlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _notifyMediaStatus() {
        tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener onInfoListener = this.mOnInfoListener;
        if (onInfoListener != null) {
            onInfoListener.onInfo(this.mMediaPlayer, this.mCurrentState, -1);
        }
    }

    private void showCoverImage() {
        if (this.mRenderView != null) {
            if (this.mCurrentAspectRatio == 1) {
                this.coverImage.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
            } else {
                this.coverImage.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            }
            android.graphics.Bitmap videoScreenshot = this.mRenderView.getVideoScreenshot();
            int i = this.mVideoRotationDegree;
            if (i > 0) {
                videoScreenshot = adjustPhotoRotation(videoScreenshot, i);
            }
            if (videoScreenshot != null) {
                this.coverImage.setImageBitmap(videoScreenshot);
            } else {
                this.coverImage.setBackgroundColor(-16777216);
            }
            this.coverImage.bringToFront();
            this.coverImage.setVisibility(0);
        }
    }

    private android.graphics.Bitmap adjustPhotoRotation(android.graphics.Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setRotate(i, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        try {
            return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (java.lang.OutOfMemoryError unused) {
            return null;
        }
    }

    public void setOnBufferingUpdateListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.bufferingUpdateListener = onBufferingUpdateListener;
    }

    public void setOnPreparedListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setOnCompletionListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnInfoListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindSurfaceHolder(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, io.dcloud.media.video.ijkplayer.media.IRenderView.ISurfaceHolder iSurfaceHolder) {
        if (iMediaPlayer == null) {
            return;
        }
        if (iSurfaceHolder == null) {
            iMediaPlayer.setDisplay(null);
        } else {
            iSurfaceHolder.bindToMediaPlayer(iMediaPlayer);
        }
    }

    public void releaseWithoutStop() {
        tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDisplay(null);
        }
    }

    public void release(boolean z) {
        tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = 330;
            _notifyMediaStatus();
            if (z) {
                this.mTargetState = 330;
            }
            ((android.media.AudioManager) this.mAppContext.getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    public void releaseOnWorkerThread(boolean z) {
        if (this.mMediaPlayer != null) {
            io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.media.video.ijkplayer.media.IjkVideoView.10
                @Override // java.lang.Runnable
                public void run() {
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer.reset();
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer.release();
                    io.dcloud.media.video.ijkplayer.media.IjkVideoView.this.mMediaPlayer = null;
                }
            });
            this.mCurrentState = 330;
            _notifyMediaStatus();
            if (z) {
                this.mTargetState = 330;
            }
            ((android.media.AudioManager) this.mAppContext.getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    public void destroy() {
        releaseOnWorkerThread(true);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (!isInPlaybackState() || this.mMediaController == null) {
            return false;
        }
        toggleMediaControlsVisibility();
        return false;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(android.view.MotionEvent motionEvent) {
        if (!isInPlaybackState() || this.mMediaController == null) {
            return false;
        }
        toggleMediaControlsVisibility();
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6) ? false : true;
        if (isInPlaybackState() && z && this.mMediaController != null) {
            if (i == 79 || i == 85) {
                if (this.mMediaPlayer.isPlaying()) {
                    pause();
                    this.mMediaController.show();
                } else {
                    start();
                    this.mMediaController.hide();
                }
                return true;
            }
            if (i == 126) {
                if (!this.mMediaPlayer.isPlaying()) {
                    start();
                    this.mMediaController.hide();
                }
                return true;
            }
            if (i == 86 || i == 127) {
                if (this.mMediaPlayer.isPlaying()) {
                    pause();
                    this.mMediaController.show();
                }
                return true;
            }
            toggleMediaControlsVisibility();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void toggleMediaControlsVisibility() {
        if (this.mMediaController.isShowing()) {
            this.mMediaController.hide();
        } else {
            this.mMediaController.show();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        android.util.Log.e("TTAG", "start " + isInPlaybackState());
        ((android.media.AudioManager) this.mAppContext.getSystemService("audio")).requestAudioFocus(null, 3, 4);
        if (this.isStoped && this.mMediaPlayer == null && this.mCurrentState == 330) {
            this.isStoped = false;
            setRender(2);
            openVideo();
            requestLayout();
            invalidate();
        }
        if (isInPlaybackState()) {
            this.mMediaPlayer.start();
            this.mCurrentState = 334;
            _notifyMediaStatus();
            this.isSetSeekTo = false;
        }
        this.mTargetState = 334;
        if (this.mCurrentState == 331) {
            this.mTargetState = 331;
            this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
        }
        this.coverImage.setVisibility(8);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            this.mCurrentState = 335;
            _notifyMediaStatus();
        }
        this.mTargetState = 335;
        showCoverImage();
    }

    public void suspend() {
        release(false);
    }

    public void resume() {
        openVideo();
    }

    public void reload() {
        this.mCurrentState = 334;
        this.mTargetState = 334;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (isInPlaybackState()) {
            return (int) this.mMediaPlayer.getDuration();
        }
        return -1;
    }

    public void setvolume(float f) {
        tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.setVolume(f, f);
        } else {
            this.isMediaReady = false;
            this.volume = f;
        }
    }

    public int getInterruptPosition() {
        tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer != null) {
            return (int) iMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        long currentPosition;
        if (!isInPlaybackState()) {
            return 0;
        }
        if (this.mCurrentState == 336 && !this.isSetSeekTo) {
            currentPosition = this.mMediaPlayer.getDuration();
        } else {
            currentPosition = this.mMediaPlayer.getCurrentPosition();
        }
        return (int) currentPosition;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (isInPlaybackState()) {
            this.mSeekStartTime = java.lang.System.currentTimeMillis();
            this.mMediaPlayer.seekTo(i);
            this.mSeekWhenPrepared = 0;
            if (isPlaying()) {
                this.isSetSeekTo = false;
                return;
            } else {
                this.isSetSeekTo = true;
                return;
            }
        }
        this.mSeekWhenPrepared = i;
        this.isSetSeekTo = false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.mCurrentBufferPercentage;
        }
        return 0;
    }

    private boolean isInPlaybackState() {
        int i;
        return (this.mMediaPlayer == null || (i = this.mCurrentState) == 331 || i == 330 || i == 332) ? false : true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.mCanPause;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.mCanSeekBack;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.mCanSeekForward;
    }

    public void setAspectRatio(int i) {
        this.mCurrentAspectRatio = i;
        io.dcloud.media.video.ijkplayer.media.IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            iRenderView.setAspectRatio(i);
        }
    }

    private void initRenders() {
        setRender(2);
    }

    int getVideoWidth() {
        tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer == null) {
            return 0;
        }
        return iMediaPlayer.getVideoWidth();
    }

    int getVideoHeight() {
        tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer == null) {
            return 0;
        }
        return iMediaPlayer.getVideoHeight();
    }

    public tv.danmaku.ijk.media.player.IMediaPlayer createPlayer(int i) {
        tv.danmaku.ijk.media.player.IjkMediaPlayer ijkMediaPlayer;
        int i2;
        if (i == 1) {
            return new tv.danmaku.ijk.media.player.AndroidMediaPlayer();
        }
        if (this.mUri == null && this.fd == null) {
            ijkMediaPlayer = null;
        } else {
            ijkMediaPlayer = new tv.danmaku.ijk.media.player.IjkMediaPlayer();
            if (android.text.TextUtils.isEmpty(this.customUA)) {
                ijkMediaPlayer.setOption(1, "user_agent", dc.squareup.HttpConstants.getDefaultUA());
            } else {
                ijkMediaPlayer.setOption(1, "user_agent", this.customUA);
            }
            if (this.mIsUsingMediaCodec) {
                ijkMediaPlayer.setOption(4, "mediacodec", 1L);
                if (this.mIsUsingMediaCodecAutoRotate) {
                    ijkMediaPlayer.setOption(4, "mediacodec-auto-rotate", 1L);
                } else {
                    ijkMediaPlayer.setOption(4, "mediacodec-auto-rotate", 0L);
                }
                if (this.mIsMediaCodecHandleResolutionChange) {
                    ijkMediaPlayer.setOption(4, "mediacodec-handle-resolution-change", 1L);
                } else {
                    ijkMediaPlayer.setOption(4, "mediacodec-handle-resolution-change", 0L);
                }
            } else {
                ijkMediaPlayer.setOption(4, "mediacodec", 0L);
            }
            if (this.mIsUsingOpenSLES) {
                ijkMediaPlayer.setOption(4, "opensles", 1L);
            } else {
                ijkMediaPlayer.setOption(4, "opensles", 0L);
            }
            if (android.text.TextUtils.isEmpty(this.mPixelFormat)) {
                ijkMediaPlayer.setOption(4, "overlay-format", 842225234L);
            } else {
                ijkMediaPlayer.setOption(4, "overlay-format", this.mPixelFormat);
            }
            ijkMediaPlayer.setOption(4, "start-on-prepared", 0L);
            ijkMediaPlayer.setOption(1, "http-detect-range-support", 0L);
            if (this.enumPlayStrategy == io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy.PLAY_SMOOTH) {
                ijkMediaPlayer.setOption(4, "infbuf", 1L);
                ijkMediaPlayer.setOption(4, "max-fps", 25L);
                ijkMediaPlayer.setOption(4, "opensles", 1L);
                ijkMediaPlayer.setOption(4, "mediacodec-mpeg4", 1L);
                ijkMediaPlayer.setOption(4, "mediacodec-hevc", 1L);
            } else if (this.enumPlayStrategy == io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy.M3U8_SMOOTH) {
                ijkMediaPlayer.setOption(4, "infbuf", 1L);
                ijkMediaPlayer.setOption(4, "max-fps", 25L);
            } else {
                io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy enumPlayStrategy = io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy.START_QUICK;
            }
            ijkMediaPlayer.setOption(2, "skip_loop_filter", 0L);
            ijkMediaPlayer.setOption(4, "framedrop", 1L);
            ijkMediaPlayer.setOption(4, "soundtouch", 1L);
            ijkMediaPlayer.setOption(1, "dns_cache_clear", 1L);
            android.net.Uri uri = this.mUri;
            if (uri != null && (uri.toString().startsWith("rtmp://") || this.mUri.toString().startsWith("rtsp://"))) {
                if (this.mUri.toString().startsWith("rtsp://")) {
                    ijkMediaPlayer.setOption(1, "rtsp_transport", "tcp");
                }
                ijkMediaPlayer.setOption(1, "flush_packets", 1L);
                ijkMediaPlayer.setOption(4, "packet-buffering", 0L);
                ijkMediaPlayer.setOption(4, "framedrop", 1L);
            } else {
                android.net.Uri uri2 = this.mUri;
                if (uri2 != null && (uri2.toString().startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL) || this.mUri.toString().startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTPS_PROTOCOL))) {
                    if (this.mUri.toString().endsWith(".m3u8") || this.mUri.toString().endsWith(".M3U8")) {
                        this.isHttpCacheOpen = false;
                        ijkMediaPlayer.setOption(1, "probesize", 10485760L);
                        ijkMediaPlayer.setOption(1, "analyzeduration", 10000000L);
                    } else {
                        ijkMediaPlayer.setOption(4, "enable-accurate-seek", 1L);
                    }
                    if (this.isHttpCacheOpen) {
                        io.dcloud.media.video.ijkplayer.utils.VideoCacheUtil.cleanCacheIfNesscessary(this.mAppContext);
                        android.net.Uri uriCacheHttpUriWrap = io.dcloud.media.video.ijkplayer.utils.VideoCacheUtil.cacheHttpUriWrap(this.mUri);
                        this.mUri = uriCacheHttpUriWrap;
                        java.lang.String cacheFilePath = io.dcloud.media.video.ijkplayer.utils.VideoCacheUtil.getCacheFilePath(this.mAppContext, uriCacheHttpUriWrap);
                        java.lang.String cacheMapFilePath = io.dcloud.media.video.ijkplayer.utils.VideoCacheUtil.getCacheMapFilePath(this.mAppContext, this.mUri);
                        if (!android.text.TextUtils.isEmpty(cacheFilePath) && !android.text.TextUtils.isEmpty(cacheMapFilePath)) {
                            ijkMediaPlayer.setOption(1, "cache_file_path", cacheFilePath);
                            ijkMediaPlayer.setOption(1, "cache_map_path", cacheMapFilePath);
                            ijkMediaPlayer.setOption(1, "auto_save_map", 1L);
                            ijkMediaPlayer.setOption(1, "parse_cache_map", 1L);
                        }
                    }
                }
            }
            for (int i3 = 0; i3 < this.customAdvanceJSON.length(); i3++) {
                try {
                    org.json.JSONObject jSONObject = this.customAdvanceJSON.getJSONObject(i3);
                    if (jSONObject != null) {
                        java.lang.String string = jSONObject.getString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY);
                        java.lang.String strOptString = jSONObject.optString("value");
                        java.lang.String string2 = jSONObject.getString("type");
                        if ("format".equalsIgnoreCase(string2)) {
                            i2 = 1;
                        } else if ("codec".equalsIgnoreCase(string2)) {
                            i2 = 2;
                        } else if ("sws".equalsIgnoreCase(string2)) {
                            i2 = 3;
                        } else {
                            i2 = "player".equalsIgnoreCase(string2) ? 4 : -10086;
                        }
                        if (i2 != -10086) {
                            if (isNumeric(strOptString)) {
                                ijkMediaPlayer.setOption(i2, string, java.lang.Integer.parseInt(strOptString));
                            } else {
                                ijkMediaPlayer.setOption(i2, string, strOptString);
                            }
                        }
                    }
                } catch (java.lang.Exception unused) {
                }
            }
        }
        return this.mIsUsingMediaCodec ? new tv.danmaku.ijk.media.player.TextureMediaPlayer(ijkMediaPlayer) : ijkMediaPlayer;
    }

    public static boolean isNumeric(java.lang.String str) {
        for (int i = 0; i < str.length(); i++) {
            java.lang.System.out.println(str.charAt(i));
            if (!java.lang.Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isBackgroundPlayEnabled() {
        return this.mEnableBackgroundPlay;
    }

    private java.lang.String buildTimeMilli(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 3600;
        long j4 = (j2 % 3600) / 60;
        long j5 = j2 % 60;
        if (j <= 0) {
            return "--:--";
        }
        if (j3 >= 100) {
            return java.lang.String.format(java.util.Locale.US, "%d:%02d:%02d", java.lang.Long.valueOf(j3), java.lang.Long.valueOf(j4), java.lang.Long.valueOf(j5));
        }
        return j3 > 0 ? java.lang.String.format(java.util.Locale.US, "%02d:%02d:%02d", java.lang.Long.valueOf(j3), java.lang.Long.valueOf(j4), java.lang.Long.valueOf(j5)) : java.lang.String.format(java.util.Locale.US, "%02d:%02d", java.lang.Long.valueOf(j4), java.lang.Long.valueOf(j5));
    }

    public tv.danmaku.ijk.media.player.misc.ITrackInfo[] getTrackInfo() {
        tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer == null) {
            return null;
        }
        return iMediaPlayer.getTrackInfo();
    }

    public void selectTrack(int i) {
        io.dcloud.media.video.ijkplayer.media.MediaPlayerCompat.selectTrack(this.mMediaPlayer, i);
    }

    public void deselectTrack(int i) {
        io.dcloud.media.video.ijkplayer.media.MediaPlayerCompat.deselectTrack(this.mMediaPlayer, i);
    }

    public int getSelectedTrack(int i) {
        return io.dcloud.media.video.ijkplayer.media.MediaPlayerCompat.getSelectedTrack(this.mMediaPlayer, i);
    }
}
