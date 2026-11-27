package io.dcloud.media.video.ijkplayer.media;

/* JADX INFO: loaded from: classes2.dex */
public class IjkPlayerView extends android.widget.FrameLayout implements android.view.View.OnClickListener {
    private static final int DANMAKU_TAG_ACFUN = 702;
    private static final int DANMAKU_TAG_BILI = 701;
    private static final int DANMAKU_TAG_CUSTOM = 703;
    private static final int DEFAULT_HIDE_TIMEOUT = 5000;
    private static final int INTERRUPT_WHEN_PAUSE = 503;
    private static final int INTERRUPT_WHEN_PLAY = 502;
    private static final int INTERVAL_TIME = 1000;
    private static final int INVALID_VALUE = -1;
    private static final int MAX_VIDEO_SEEK = 1000;
    private static final int MSG_ENABLE_ORIENTATION = 10087;
    private static final int MSG_TRY_RELOAD = 10088;
    private static final int MSG_UPDATE_SEEK = 10086;
    private static final int MSG_UPDATE_TIME = 10099;
    private static final int NORMAL_STATUS = 501;
    private boolean controlShowEnable;
    private int defaultDisplayCutoutMode;
    private float defaultScreenBrightness;
    private int defaultSystemUI;
    int duration;
    java.lang.String fullCallFormat;
    private boolean isFullScreenPageGesture;
    private boolean isLoadingVisibility;
    private boolean isMutePlayer;
    private boolean isPageGesture;
    private boolean isProgressGesture;
    private boolean isProgressVisibility;
    private boolean isRtmpUri;
    private boolean isShowScreenLockButton;
    private int mAspectOptionsHeight;
    private android.app.Activity mAttachActivity;
    private android.media.AudioManager mAudioManager;
    private int mBasicOptionsWidth;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener mCompletionListener;
    private float mCurBrightness;
    private int mCurPosition;
    private int mCurVolume;
    private master.flame.danmaku.danmaku.model.android.DanmakuContext mDanmakuContext;
    private io.dcloud.media.video.ijkplayer.danmaku.BaseDanmakuConverter mDanmakuConverter;
    private io.dcloud.media.video.ijkplayer.danmaku.OnDanmakuListener mDanmakuListener;
    private master.flame.danmaku.danmaku.loader.ILoader mDanmakuLoader;
    private master.flame.danmaku.danmaku.parser.BaseDanmakuParser mDanmakuParser;
    private int mDanmakuTag;
    private long mDanmakuTargetPosition;
    private int mDanmakuTextColor;
    private float mDanmakuTextSize;
    private int mDanmakuType;
    private master.flame.danmaku.controller.IDanmakuView mDanmakuView;
    private java.lang.String mDanmuList;
    private long mExitTime;
    private android.view.View mFlReload;
    private android.widget.FrameLayout mFlTouchLayout;
    private android.widget.FrameLayout mFlVideoBox;
    private android.widget.LinearLayout mFullscreenTopBar;
    private android.view.GestureDetector mGestureDetector;
    private android.os.Handler mHandler;
    private java.lang.Runnable mHideBarRunnable;
    private java.lang.Runnable mHideTouchViewRunnable;
    private android.widget.ImageView mIVMute;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener mInfoListener;
    private int mInitHeight;
    private int mInterruptPosition;
    private boolean mIsAlwaysFullScreen;
    private boolean mIsBufferingStart;
    private boolean mIsDoubleTapEnable;
    private boolean mIsEnableDanmaku;
    private boolean mIsForbidOrientation;
    private boolean mIsForbidTouch;
    private boolean mIsFullscreen;
    private boolean mIsNeedRecoverScreen;
    private boolean mIsNetConnected;
    private boolean mIsNeverPlay;
    private boolean mIsPlayComplete;
    private boolean mIsReady;
    private boolean mIsRenderingStart;
    private boolean mIsScreenLocked;
    private boolean mIsSeeking;
    private boolean mIsShowBar;
    private android.widget.ImageView mIvBack;
    private android.widget.TextView mIvDanmakuControl;
    private android.widget.ImageView mIvFullscreen;
    private android.widget.ImageView mIvPlay;
    private android.widget.ImageView mIvPlayCircle;
    private android.widget.ImageView mIvScreenLock;
    private android.widget.LinearLayout mLlBottomBar;
    private android.widget.ProgressBar mLoadingView;
    private int mMaxVolume;
    private int mMoreOptionsWidth;
    private io.dcloud.media.video.ijkplayer.media.IjkPlayerView.NetBroadcastReceiver mNetReceiver;
    private io.dcloud.media.video.ijkplayer.OnPlayerChangedListener mOnPlayerChangedListener;
    private int mOrientation;
    private android.view.OrientationEventListener mOrientationListener;
    private tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener mOutsideInfoListener;
    private android.view.GestureDetector.OnGestureListener mPlayerGestureListener;
    private android.widget.SeekBar mPlayerSeek;
    public android.widget.ImageView mPlayerThumb;
    private android.view.View.OnTouchListener mPlayerTouchListener;
    private android.view.ViewGroup.LayoutParams mRawParams;
    private android.view.ViewGroup mRootLayout;
    private android.graphics.Matrix mSaveMatrix;
    private io.dcloud.media.video.ijkplayer.media.IjkPlayerView.ScreenBroadcastReceiver mScreenReceiver;
    private int mScreenUiVisibility;
    private final android.widget.SeekBar.OnSeekBarChangeListener mSeekListener;
    private long mTargetPosition;
    private android.widget.TextView mTvBrightness;
    private android.widget.TextView mTvCurTime;
    private android.widget.TextView mTvEndTime;
    private android.widget.TextView mTvFastForward;
    private android.widget.TextView mTvRecoverScreen;
    private android.widget.ImageView mTvReload;
    private io.dcloud.media.video.ijkplayer.widgets.MarqueeTextView mTvTitle;
    private android.widget.TextView mTvVolume;
    private android.graphics.Matrix mVideoMatrix;
    private android.util.SparseArray<java.lang.String> mVideoSource;
    private int mVideoStatus;
    private io.dcloud.media.video.ijkplayer.media.IjkVideoView mVideoView;
    private int mWidthPixels;
    private int originOrientation;
    private io.dcloud.media.video.ijkplayer.VideoPlayerView parentView;
    java.lang.String[] rates;
    java.lang.Runnable screenLockHideRunnable;
    java.lang.String timeUpdateF;

    @java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.PARAMETER})
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface DanmakuTag {
    }

    private void _recoverScreen() {
    }

    public IjkPlayerView(android.content.Context context) {
        this(context, null);
    }

    public IjkPlayerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new android.os.Handler() { // from class: io.dcloud.media.video.ijkplayer.media.IjkPlayerView.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what == io.dcloud.media.video.ijkplayer.media.IjkPlayerView.MSG_UPDATE_SEEK) {
                    int i_setProgress = io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this._setProgress();
                    if (!io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mIsSeeking && io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mIsShowBar && io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mVideoView.isPlaying()) {
                        sendMessageDelayed(obtainMessage(io.dcloud.media.video.ijkplayer.media.IjkPlayerView.MSG_UPDATE_SEEK), 1000 - (i_setProgress % 1000));
                        return;
                    }
                    return;
                }
                if (message.what == io.dcloud.media.video.ijkplayer.media.IjkPlayerView.MSG_ENABLE_ORIENTATION) {
                    if (io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mOrientationListener != null) {
                        io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mOrientationListener.enable();
                    }
                } else if (message.what == io.dcloud.media.video.ijkplayer.media.IjkPlayerView.MSG_TRY_RELOAD) {
                    if (io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mIsNetConnected) {
                        io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.reload();
                    }
                    sendMessageDelayed(obtainMessage(io.dcloud.media.video.ijkplayer.media.IjkPlayerView.MSG_TRY_RELOAD), 3000L);
                } else if (message.what == io.dcloud.media.video.ijkplayer.media.IjkPlayerView.MSG_UPDATE_TIME) {
                    io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.progressCallBack();
                    sendMessageDelayed(obtainMessage(io.dcloud.media.video.ijkplayer.media.IjkPlayerView.MSG_UPDATE_TIME), 250L);
                }
            }
        };
        this.mIsForbidTouch = false;
        this.mIsDoubleTapEnable = false;
        this.mIsShowBar = true;
        this.mIsPlayComplete = false;
        this.mTargetPosition = -1L;
        this.mCurPosition = -1;
        this.mCurVolume = -1;
        this.mCurBrightness = -1.0f;
        this.mIsNeverPlay = true;
        this.mIsForbidOrientation = true;
        this.mIsAlwaysFullScreen = false;
        this.mExitTime = 0L;
        this.mVideoMatrix = new android.graphics.Matrix();
        this.mSaveMatrix = new android.graphics.Matrix();
        this.mIsNeedRecoverScreen = false;
        this.mIsReady = false;
        this.isRtmpUri = false;
        this.isPageGesture = false;
        this.isProgressGesture = true;
        this.isFullScreenPageGesture = true;
        this.isShowScreenLockButton = false;
        this.mSeekListener = new android.widget.SeekBar.OnSeekBarChangeListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkPlayerView.2
            private long curPosition;

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
                io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mIsSeeking = true;
                io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this._showControlBar(3600000);
                io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mHandler.removeMessages(io.dcloud.media.video.ijkplayer.media.IjkPlayerView.MSG_UPDATE_SEEK);
                this.curPosition = io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mVideoView.getCurrentPosition();
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
                java.lang.String str;
                if (z) {
                    long duration = io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.getDuration();
                    io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mTargetPosition = (((long) i) * duration) / 1000;
                    int i2 = (int) ((io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mTargetPosition - this.curPosition) / 1000);
                    if (io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mTargetPosition > this.curPosition) {
                        str = io.dcloud.media.video.ijkplayer.utils.StringUtils.generateTime(io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mTargetPosition) + "/" + io.dcloud.media.video.ijkplayer.utils.StringUtils.generateTime(duration) + "\n+" + i2 + io.dcloud.application.DCLoudApplicationImpl.self().getContext().getString(io.dcloud.feature.media.R.string.dcloud_feature_media_player_second_unit);
                    } else {
                        str = io.dcloud.media.video.ijkplayer.utils.StringUtils.generateTime(io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mTargetPosition) + "/" + io.dcloud.media.video.ijkplayer.utils.StringUtils.generateTime(duration) + "\n" + i2 + io.dcloud.application.DCLoudApplicationImpl.self().getContext().getString(io.dcloud.feature.media.R.string.dcloud_feature_media_player_second_unit);
                    }
                    io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this._setFastForward(str);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
                io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this._hideTouchView();
                io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mIsSeeking = false;
                io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView = io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this;
                ijkPlayerView.seekTo((int) ijkPlayerView.mTargetPosition);
                io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mTargetPosition = -1L;
                io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this._setProgress();
                io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this._showControlBar(5000);
            }
        };
        this.mHideBarRunnable = new java.lang.Runnable() { // from class: io.dcloud.media.video.ijkplayer.media.IjkPlayerView.3
            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this._hideAllView(false);
            }
        };
        this.screenLockHideRunnable = new java.lang.Runnable() { // from class: io.dcloud.media.video.ijkplayer.media.IjkPlayerView.4
            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mIvScreenLock.setVisibility(8);
            }
        };
        this.controlShowEnable = false;
        this.isProgressVisibility = true;
        this.fullCallFormat = "{detail:{fullScreen:%b, direction:'%s'}}";
        this.mOrientation = -90;
        this.defaultSystemUI = 0;
        this.defaultDisplayCutoutMode = 0;
        this.rates = new java.lang.String[]{"0.5", "0.8", "1.0", "1.25", "1.5", "2.0"};
        this.mPlayerGestureListener = new android.view.GestureDetector.SimpleOnGestureListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkPlayerView.7
            private boolean isDownTouch;
            private boolean isLandscape;
            private boolean isRecoverFromDanmaku;
            private boolean isVolume;

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(android.view.MotionEvent motionEvent) {
                this.isDownTouch = true;
                this.isRecoverFromDanmaku = io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.recoverFromEditVideo();
                return super.onDown(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
                if (!io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mIsForbidTouch && !io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mIsNeverPlay) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY() - motionEvent2.getY();
                    float x2 = x - motionEvent2.getX();
                    if (this.isDownTouch) {
                        this.isLandscape = java.lang.Math.abs(f) >= java.lang.Math.abs(f2);
                        this.isVolume = x > ((float) io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.getResources().getDisplayMetrics().widthPixels) * 0.5f;
                        this.isDownTouch = false;
                    }
                    if (!this.isLandscape) {
                        float height = y / io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mVideoView.getHeight();
                        if (this.isVolume) {
                            io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this._onVolumeSlide(height);
                        } else {
                            io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this._onBrightnessSlide(height);
                        }
                    } else {
                        io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView = io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this;
                        ijkPlayerView._onProgressSlide((-x2) / ijkPlayerView.mVideoView.getWidth());
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(android.view.MotionEvent motionEvent) {
                if (io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.isFullscreen()) {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    try {
                        float f = io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.getContext().getResources().getDisplayMetrics().density;
                        jSONObject.put(com.taobao.weex.ui.view.gesture.WXGestureType.GestureInfo.SCREEN_X, motionEvent.getX() / f);
                        jSONObject.put(com.taobao.weex.ui.view.gesture.WXGestureType.GestureInfo.SCREEN_Y, motionEvent.getY() / f);
                        jSONObject.put("screenWidth", io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.getWidth() / f);
                        jSONObject.put("screenHeight", io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.getHeight() / f);
                    } catch (java.lang.Exception unused) {
                    }
                    io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mOnPlayerChangedListener.onChanged("fullscreenclick", jSONObject.toString());
                }
                if (this.isRecoverFromDanmaku) {
                    return true;
                }
                io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this._toggleControlBar();
                if (io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mIsFullscreen) {
                    io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.showScreenLockView();
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(android.view.MotionEvent motionEvent) {
                if (!io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mIsNeverPlay && !this.isRecoverFromDanmaku && !io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mIsForbidTouch && io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mIsDoubleTapEnable) {
                    io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this._refreshHideRunnable();
                    io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this._togglePlayStatus();
                }
                return true;
            }
        };
        this.mHideTouchViewRunnable = new java.lang.Runnable() { // from class: io.dcloud.media.video.ijkplayer.media.IjkPlayerView.8
            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this._hideTouchView();
            }
        };
        this.mPlayerTouchListener = new android.view.View.OnTouchListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkPlayerView.9
            private static final int INVALID_POINTER = 2;
            private static final int NORMAL = 1;
            private static final int ZOOM_AND_ROTATE = 3;
            private float oldDist;
            private float scale;
            private int mode = 1;
            private android.graphics.PointF midPoint = new android.graphics.PointF(0.0f, 0.0f);
            private float degree = 0.0f;
            private int fingerFlag = -1;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                int actionMasked = androidx.core.view.MotionEventCompat.getActionMasked(motionEvent);
                if (actionMasked == 0) {
                    this.mode = 1;
                    io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mHandler.removeCallbacks(io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mHideBarRunnable);
                } else if (actionMasked != 2) {
                    if (actionMasked != 5) {
                        if (actionMasked == 6) {
                            if (this.mode == 3) {
                                io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView = io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this;
                                ijkPlayerView.mIsNeedRecoverScreen = ijkPlayerView.mVideoView.adjustVideoView(this.scale);
                                if (io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mIsNeedRecoverScreen && io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mIsShowBar) {
                                    io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mTvRecoverScreen.setVisibility(0);
                                }
                            }
                            this.mode = 2;
                        }
                    } else if (motionEvent.getPointerCount() == 3 && io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mIsFullscreen) {
                        io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this._hideTouchView();
                        this.mode = 3;
                        io.dcloud.media.video.ijkplayer.utils.MotionEventUtils.midPoint(this.midPoint, motionEvent);
                        int iCalcFingerFlag = io.dcloud.media.video.ijkplayer.utils.MotionEventUtils.calcFingerFlag(motionEvent);
                        this.fingerFlag = iCalcFingerFlag;
                        this.degree = io.dcloud.media.video.ijkplayer.utils.MotionEventUtils.rotation(motionEvent, iCalcFingerFlag);
                        this.oldDist = io.dcloud.media.video.ijkplayer.utils.MotionEventUtils.calcSpacing(motionEvent, this.fingerFlag);
                        io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView2 = io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this;
                        ijkPlayerView2.mSaveMatrix = ijkPlayerView2.mVideoView.getVideoTransform();
                    } else {
                        this.mode = 2;
                    }
                } else if (this.mode == 3) {
                    io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mVideoView.setVideoRotation((int) (io.dcloud.media.video.ijkplayer.utils.MotionEventUtils.rotation(motionEvent, this.fingerFlag) - this.degree));
                    io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mVideoMatrix.set(io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mSaveMatrix);
                    this.scale = io.dcloud.media.video.ijkplayer.utils.MotionEventUtils.calcSpacing(motionEvent, this.fingerFlag) / this.oldDist;
                    android.graphics.Matrix matrix = io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mVideoMatrix;
                    float f = this.scale;
                    matrix.postScale(f, f, this.midPoint.x, this.midPoint.y);
                    io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mVideoView.setVideoTransform(io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mVideoMatrix);
                }
                if (this.mode == 1 && !io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mGestureDetector.onTouchEvent(motionEvent) && androidx.core.view.MotionEventCompat.getActionMasked(motionEvent) == 1) {
                    io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this._endGesture();
                }
                return true;
            }
        };
        this.timeUpdateF = "{detail:{currentTime:%f,duration:%f}}";
        this.duration = -1;
        this.isMutePlayer = false;
        this.isLoadingVisibility = true;
        this.mIsRenderingStart = false;
        this.mIsBufferingStart = false;
        this.mInfoListener = new tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkPlayerView.10
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2) {
                io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this._switchStatus(i);
                if (io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mOutsideInfoListener == null) {
                    return true;
                }
                io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mOutsideInfoListener.onInfo(iMediaPlayer, i, i2);
                return true;
            }
        };
        this.mVideoSource = new android.util.SparseArray<>();
        this.mVideoStatus = NORMAL_STATUS;
        this.mDanmakuTag = 701;
        this.mIsEnableDanmaku = false;
        this.mDanmakuTextColor = -1;
        this.mDanmakuTextSize = -1.0f;
        this.mDanmakuType = 1;
        this.mBasicOptionsWidth = -1;
        this.mMoreOptionsWidth = -1;
        this.mDanmakuTargetPosition = -1L;
        this.mDanmuList = "";
        this.mIsScreenLocked = false;
        _initView(context);
    }

    public IjkPlayerView(android.content.Context context, android.util.AttributeSet attributeSet, io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView) {
        this(context, attributeSet);
        this.parentView = videoPlayerView;
    }

    private void _initView(android.content.Context context) {
        if (context instanceof android.app.Activity) {
            this.mAttachActivity = (android.app.Activity) context;
            android.view.View.inflate(context, io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_LAYOUT_PLAYER_VIEW, this);
            this.mVideoView = (io.dcloud.media.video.ijkplayer.media.IjkVideoView) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_VIDEO_VIEW);
            this.mPlayerThumb = (android.widget.ImageView) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_IV_THUMB);
            this.mLoadingView = (android.widget.ProgressBar) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_PD_LOADING);
            this.mTvVolume = (android.widget.TextView) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_TV_VOLUME);
            this.mTvBrightness = (android.widget.TextView) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_TV_BRIGHTNESS);
            this.mTvFastForward = (android.widget.TextView) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_TV_FAST_FORWARD);
            this.mFlTouchLayout = (android.widget.FrameLayout) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_FL_TOUCH_LAYOUT);
            this.mIvBack = (android.widget.ImageView) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_IV_BACK);
            this.mTvTitle = (io.dcloud.media.video.ijkplayer.widgets.MarqueeTextView) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_TV_TITLE);
            this.mFullscreenTopBar = (android.widget.LinearLayout) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_FULLSCREEN_TOP_BAR);
            this.mIvPlay = (android.widget.ImageView) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_IV_PLAY);
            this.mTvCurTime = (android.widget.TextView) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_TV_CUR_TIME);
            this.mPlayerSeek = (android.widget.SeekBar) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_PLAYER_SEEK);
            this.mTvEndTime = (android.widget.TextView) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_TV_END_TIME);
            this.mIvFullscreen = (android.widget.ImageView) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_IV_FULLSCREEN);
            this.mLlBottomBar = (android.widget.LinearLayout) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_LL_BOTTOM_BAR);
            this.mFlVideoBox = (android.widget.FrameLayout) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_FL_VIDEO_BOX);
            this.mIvPlayCircle = (android.widget.ImageView) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_IV_PLAY_CIRCLE);
            this.mIvScreenLock = (android.widget.ImageView) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_IV_SCREEN_LOCK);
            this.mTvRecoverScreen = (android.widget.TextView) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_TV_RECOVER_SCREEN);
            this.mTvReload = (android.widget.ImageView) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_TV_RELOAD);
            this.mFlReload = findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_FL_RELOAD_LAYOUT);
            this.mIvDanmakuControl = (android.widget.TextView) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_IV_DANMAKU_CONTROL);
            this.mIVMute = (android.widget.ImageView) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_IV_MUTE);
            this.mAspectOptionsHeight = getResources().getDimensionPixelSize(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_DIMEN_ASPECT_BNT_SIZE) * 4;
            _initReceiver();
            this.mIvPlay.setOnClickListener(this);
            this.mIvBack.setOnClickListener(this);
            this.mIvFullscreen.setOnClickListener(this);
            this.mIVMute.setOnClickListener(this);
            this.mIvPlayCircle.setOnClickListener(this);
            this.mTvRecoverScreen.setOnClickListener(this);
            this.mTvReload.setOnClickListener(this);
            this.mIvScreenLock.setOnClickListener(this);
            if (this.mIsForbidTouch) {
                this.mIvScreenLock.setImageResource(io.dcloud.feature.media.R.drawable.video_screen_lock);
                this.mIvScreenLock.setTag(1);
                return;
            } else {
                this.mIvScreenLock.setImageResource(io.dcloud.feature.media.R.drawable.video_screen_unlock);
                this.mIvScreenLock.setTag(0);
                return;
            }
        }
        throw new java.lang.IllegalArgumentException("Context must be Activity");
    }

    private void setSeekBarColor() {
        android.graphics.drawable.LayerDrawable layerDrawable = (android.graphics.drawable.LayerDrawable) this.mPlayerSeek.getProgressDrawable();
        layerDrawable.findDrawableByLayerId(android.R.id.background).setColorFilter(android.graphics.Color.parseColor("#ff00ff"), android.graphics.PorterDuff.Mode.SRC_ATOP);
        layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress).setColorFilter(android.graphics.Color.parseColor("#ffff00"), android.graphics.PorterDuff.Mode.SRC_ATOP);
        layerDrawable.findDrawableByLayerId(android.R.id.progress).setColorFilter(android.graphics.Color.parseColor("#00ffff"), android.graphics.PorterDuff.Mode.SRC_ATOP);
        this.mPlayerSeek.getThumb().setColorFilter(android.graphics.Color.parseColor("#0000ff"), android.graphics.PorterDuff.Mode.SRC_ATOP);
    }

    private void _initMediaPlayer() {
        tv.danmaku.ijk.media.player.IjkMediaPlayer.loadLibrariesOnce(null);
        tv.danmaku.ijk.media.player.IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        android.media.AudioManager audioManager = (android.media.AudioManager) this.mAttachActivity.getSystemService("audio");
        this.mAudioManager = audioManager;
        this.mMaxVolume = audioManager.getStreamMaxVolume(3);
        this.defaultScreenBrightness = this.mAttachActivity.getWindow().getAttributes().screenBrightness;
        this.mPlayerSeek.setMax(1000);
        this.mPlayerSeek.setOnSeekBarChangeListener(this.mSeekListener);
        this.mVideoView.setOnInfoListener(this.mInfoListener);
        this.mGestureDetector = new android.view.GestureDetector(this.mAttachActivity, this.mPlayerGestureListener);
        this.mFlVideoBox.setClickable(true);
        this.mFlVideoBox.setOnTouchListener(this.mPlayerTouchListener);
        if (this.mIsForbidOrientation) {
            return;
        }
        initOrientationEventListener();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mInitHeight == 0) {
            this.mInitHeight = getHeight();
            this.mWidthPixels = getResources().getDisplayMetrics().widthPixels;
        }
    }

    public void onResume() {
        if (this.mIsScreenLocked) {
            this.mIsScreenLocked = false;
        }
        this.mVideoView.setRender(2);
        this.mVideoView.resume();
        if (!this.mIsForbidTouch && !this.mIsForbidOrientation) {
            this.mOrientationListener.enable();
        }
        int i = this.mCurPosition;
        if (i != -1) {
            seekTo(i);
            this.mCurPosition = -1;
        }
    }

    public void onPause() {
        this.mCurPosition = this.mVideoView.getCurrentPosition();
        this.mVideoView.pause();
        this.mIvPlay.setSelected(false);
        android.view.OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        _pauseDanmaku();
    }

    public int onDestroy() {
        int currentPosition = this.mVideoView.getCurrentPosition();
        this.mVideoView.destroy();
        tv.danmaku.ijk.media.player.IjkMediaPlayer.native_profileEnd();
        master.flame.danmaku.controller.IDanmakuView iDanmakuView = this.mDanmakuView;
        if (iDanmakuView != null) {
            iDanmakuView.release();
            this.mDanmakuView = null;
        }
        io.dcloud.media.video.ijkplayer.widgets.MarqueeTextView marqueeTextView = this.mTvTitle;
        if (marqueeTextView != null) {
            marqueeTextView.stopMotion();
        }
        this.mHandler.removeMessages(MSG_TRY_RELOAD);
        this.mHandler.removeMessages(MSG_UPDATE_SEEK);
        this.mHandler.removeMessages(MSG_UPDATE_TIME);
        this.mAttachActivity.unregisterReceiver(this.mScreenReceiver);
        this.mAttachActivity.unregisterReceiver(this.mNetReceiver);
        this.mAttachActivity.getWindow().clearFlags(128);
        android.view.WindowManager.LayoutParams attributes = this.mAttachActivity.getWindow().getAttributes();
        attributes.screenBrightness = this.defaultScreenBrightness;
        this.mAttachActivity.getWindow().setAttributes(attributes);
        return currentPosition;
    }

    public boolean handleVolumeKey(int i) {
        if (i == 24) {
            _setVolume(true);
            return true;
        }
        if (i != 25) {
            return false;
        }
        _setVolume(false);
        return true;
    }

    public boolean onBackPressed() {
        if (recoverFromEditVideo() || this.mIsAlwaysFullScreen) {
            return true;
        }
        if (!this.mIsFullscreen) {
            return false;
        }
        exitFullScreen();
        if (this.mIsForbidTouch) {
            this.mIsForbidTouch = false;
            _setControlBarVisible(this.mIsShowBar);
        }
        return true;
    }

    public io.dcloud.media.video.ijkplayer.media.IjkPlayerView init() {
        _initMediaPlayer();
        return this;
    }

    public io.dcloud.media.video.ijkplayer.media.IjkPlayerView switchVideoPath(java.lang.String str, java.lang.String str2) {
        return switchVideoPath(android.net.Uri.parse(str), str2);
    }

    public io.dcloud.media.video.ijkplayer.media.IjkPlayerView switchVideoPath(android.net.Uri uri, java.lang.String str) {
        reset();
        _setControlBarVisible(true);
        this.duration = -1;
        return setVideoPath(uri, str);
    }

    public io.dcloud.media.video.ijkplayer.media.IjkPlayerView setVideoPath(java.lang.String str, java.lang.String str2) {
        return setVideoPath(android.net.Uri.parse(str), str2);
    }

    public io.dcloud.media.video.ijkplayer.media.IjkPlayerView setPlayerRootView(android.view.ViewGroup viewGroup) {
        this.mRootLayout = viewGroup;
        return this;
    }

    public io.dcloud.media.video.ijkplayer.media.IjkPlayerView setVideoPath(android.net.Uri uri, java.lang.String str) {
        this.mVideoView.setVideoURI(uri, str);
        if (uri.toString().startsWith("rtmp:")) {
            this.isRtmpUri = true;
            this.mPlayerSeek.setEnabled(false);
            this.mPlayerSeek.setVisibility(4);
            this.mTvEndTime.setVisibility(4);
            this.mTvCurTime.setVisibility(4);
        } else {
            this.isRtmpUri = false;
            this.mPlayerSeek.setEnabled(true);
            this.mPlayerSeek.setVisibility(this.isProgressVisibility ? 0 : 4);
            this.mTvEndTime.setVisibility(0);
            this.mTvCurTime.setVisibility(0);
        }
        int i = this.mCurPosition;
        if (i != -1) {
            seekTo(i);
            this.mCurPosition = -1;
            return this;
        }
        seekTo(0);
        return this;
    }

    public io.dcloud.media.video.ijkplayer.media.IjkPlayerView setVideoFileDescriptor(io.dcloud.media.video.ijkplayer.media.AssetsDataSourceProvider assetsDataSourceProvider) {
        this.mVideoView.setVideoFileDescriptor(assetsDataSourceProvider);
        int i = this.mCurPosition;
        if (i != -1) {
            seekTo(i);
            this.mCurPosition = -1;
            return this;
        }
        seekTo(0);
        return this;
    }

    public io.dcloud.media.video.ijkplayer.media.IjkPlayerView switchVideoFileDescriptor(io.dcloud.media.video.ijkplayer.media.AssetsDataSourceProvider assetsDataSourceProvider) {
        reset();
        _setControlBarVisible(true);
        this.duration = -1;
        return setVideoFileDescriptor(assetsDataSourceProvider);
    }

    public io.dcloud.media.video.ijkplayer.media.IjkPlayerView setTitle(java.lang.String str) {
        this.mTvTitle.setText(str);
        return this;
    }

    public io.dcloud.media.video.ijkplayer.media.IjkPlayerView alwaysFullScreen() {
        this.mIsAlwaysFullScreen = true;
        fullScreen(this.mOrientation);
        this.mIvFullscreen.setVisibility(8);
        return this;
    }

    public void start() {
        if (this.mIsPlayComplete) {
            master.flame.danmaku.controller.IDanmakuView iDanmakuView = this.mDanmakuView;
            if (iDanmakuView != null && iDanmakuView.isPrepared()) {
                this.mDanmakuView.seekTo(0L);
                this.mDanmakuView.pause();
            }
            this.mIsPlayComplete = false;
        }
        if (!this.mVideoView.isPlaying()) {
            this.mIvPlay.setSelected(true);
            this.mVideoView.start();
            this.mHandler.sendEmptyMessage(MSG_UPDATE_SEEK);
            this.mHandler.sendEmptyMessage(MSG_UPDATE_TIME);
        }
        this.mIvPlayCircle.setVisibility(8);
        if (this.mIsNeverPlay) {
            this.mIsNeverPlay = false;
            setLoadingVisibility(0);
            this.mIsShowBar = false;
            _loadDanmaku();
        }
        this.mAttachActivity.getWindow().addFlags(128);
    }

    public void hiddenLoaded(boolean z) {
        if (z) {
            this.mFlReload.setVisibility(8);
        } else {
            this.mFlReload.setVisibility(0);
        }
    }

    public void reload() {
        this.mFlReload.setVisibility(8);
        setLoadingVisibility(0);
        if (this.mIsReady) {
            if (io.dcloud.media.video.ijkplayer.utils.NetWorkUtils.isNetworkAvailable(this.mAttachActivity)) {
                this.mVideoView.reload();
                this.mVideoView.start();
                int i = this.mInterruptPosition;
                if (i > 0) {
                    seekTo(i);
                    this.mInterruptPosition = 0;
                }
            } else {
                io.dcloud.media.video.ijkplayer.OnPlayerChangedListener onPlayerChangedListener = this.mOnPlayerChangedListener;
                if (onPlayerChangedListener != null) {
                    onPlayerChangedListener.onChanged("error", "{message:'network error'}");
                    this.mFlReload.setVisibility(0);
                    setLoadingVisibility(8);
                    return;
                }
                return;
            }
        } else {
            this.mVideoView.release(false);
            this.mVideoView.setRender(2);
            start();
        }
        this.mHandler.removeMessages(MSG_UPDATE_SEEK);
        this.mHandler.sendEmptyMessage(MSG_UPDATE_SEEK);
        this.mHandler.removeMessages(MSG_UPDATE_TIME);
        this.mHandler.sendEmptyMessage(MSG_UPDATE_TIME);
    }

    public boolean isPlaying() {
        return this.mVideoView.isPlaying();
    }

    public void pause() {
        this.mCurPosition = this.mVideoView.getCurrentPosition();
        this.mIvPlay.setSelected(false);
        if (this.mVideoView.isPlaying()) {
            this.mVideoView.pause();
        }
        this.mHandler.removeMessages(MSG_UPDATE_TIME);
        _pauseDanmaku();
        this.mAttachActivity.getWindow().clearFlags(128);
    }

    public void seekTo(int i) {
        if (this.isRtmpUri) {
            return;
        }
        this.mVideoView.seekTo(i);
        this.mDanmakuTargetPosition = i;
    }

    public void stop() {
        pause();
        this.mVideoView.stopPlayback();
    }

    public void reset() {
        master.flame.danmaku.controller.IDanmakuView iDanmakuView;
        if (this.mIsEnableDanmaku && (iDanmakuView = this.mDanmakuView) != null) {
            iDanmakuView.release();
            this.mDanmakuView = null;
            this.mIsEnableDanmaku = false;
        }
        this.mIsNeverPlay = true;
        this.mCurPosition = 0;
        stop();
        this.mVideoView.setRender(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _hideAllView(boolean z) {
        this.mFlTouchLayout.setVisibility(8);
        this.mFullscreenTopBar.setVisibility(8);
        this.mTvTitle.stopMotion();
        if (this.mLlBottomBar.getVisibility() == 0) {
            this.mOnPlayerChangedListener.onChanged("controlstoggle", "{'show':false}");
        }
        this.mLlBottomBar.setVisibility(8);
        if (!z) {
            this.mIsShowBar = false;
        }
        if (this.mIsNeedRecoverScreen) {
            this.mTvRecoverScreen.setVisibility(8);
        }
        if (this.mIvScreenLock.getVisibility() == 0) {
            this.mIvScreenLock.setVisibility(8);
        }
    }

    private void _setControlBarVisible(boolean z) {
        if (!this.controlShowEnable) {
            this.mLlBottomBar.setVisibility(8);
            this.mFullscreenTopBar.setVisibility(8);
            this.mTvTitle.stopMotion();
            if (this.mIsNeedRecoverScreen) {
                this.mTvRecoverScreen.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mIsNeverPlay) {
            if (this.mIvPlayCircle.getVisibility() != 0) {
                this.mLlBottomBar.setVisibility(z ? 0 : 8);
                return;
            }
            return;
        }
        if (this.mIsForbidTouch) {
            return;
        }
        this.mLlBottomBar.setVisibility(z ? 0 : 8);
        if (this.mIsFullscreen) {
            this.mFullscreenTopBar.setVisibility(z ? 0 : 8);
            if (z) {
                this.mTvTitle.startMotion();
            } else {
                this.mTvTitle.stopMotion();
            }
            if (this.mIsNeedRecoverScreen) {
                this.mTvRecoverScreen.setVisibility(z ? 0 : 8);
                return;
            }
            return;
        }
        this.mFullscreenTopBar.setVisibility(8);
        this.mTvTitle.stopMotion();
        if (this.mIsNeedRecoverScreen) {
            this.mTvRecoverScreen.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _toggleControlBar() {
        this.mIsShowBar = !this.mIsShowBar;
        this.mOnPlayerChangedListener.onChanged("controlstoggle", "{'show':" + this.mIsShowBar + com.taobao.weex.el.parse.Operators.BLOCK_END_STR);
        _setControlBarVisible(this.mIsShowBar);
        if (this.mIsShowBar) {
            this.mHandler.postDelayed(this.mHideBarRunnable, io.dcloud.WebAppActivity.SPLASH_SECOND);
            this.mHandler.sendEmptyMessage(MSG_UPDATE_SEEK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _showControlBar(int i) {
        if (!this.mIsShowBar) {
            _setProgress();
            this.mIsShowBar = true;
        }
        _setControlBarVisible(true);
        this.mHandler.removeMessages(MSG_UPDATE_SEEK);
        this.mHandler.sendEmptyMessage(MSG_UPDATE_SEEK);
        this.mHandler.removeCallbacks(this.mHideBarRunnable);
        if (i != 0) {
            this.mHandler.postDelayed(this.mHideBarRunnable, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _togglePlayStatus() {
        if (this.mVideoView.isPlaying()) {
            pause();
        } else {
            start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _refreshHideRunnable() {
        this.mHandler.removeCallbacks(this.mHideBarRunnable);
        this.mHandler.postDelayed(this.mHideBarRunnable, io.dcloud.WebAppActivity.SPLASH_SECOND);
    }

    public void showScreenLockView() {
        if (this.isShowScreenLockButton) {
            this.mIvScreenLock.setVisibility(0);
            getHandler().removeCallbacks(this.screenLockHideRunnable);
            getHandler().postDelayed(this.screenLockHideRunnable, io.dcloud.WebAppActivity.SPLASH_SECOND);
            return;
        }
        this.mIvScreenLock.setVisibility(8);
    }

    public void setmIsDoubleTapEnable(boolean z) {
        this.mIsDoubleTapEnable = z;
    }

    private void _togglePlayerLock() {
        boolean z = this.mIsForbidTouch;
        this.mIsForbidTouch = !z;
        if (!z) {
            android.view.OrientationEventListener orientationEventListener = this.mOrientationListener;
            if (orientationEventListener != null) {
                orientationEventListener.disable();
            }
            _hideAllView(true);
            return;
        }
        if (!this.mIsForbidOrientation) {
            this.mOrientationListener.enable();
        }
        this.mFullscreenTopBar.setVisibility(0);
        if (this.controlShowEnable) {
            this.mLlBottomBar.setVisibility(0);
        }
        if (this.mIsNeedRecoverScreen) {
            this.mTvRecoverScreen.setVisibility(0);
        }
    }

    public void setControls(boolean z) {
        this.controlShowEnable = z;
        this.mIsShowBar = z;
        this.mOnPlayerChangedListener.onChanged("controlstoggle", "{'show':" + this.mIsShowBar + com.taobao.weex.el.parse.Operators.BLOCK_END_STR);
        _setControlBarVisible(this.mIsShowBar);
        if (this.mIsShowBar) {
            this.mHandler.sendEmptyMessage(MSG_UPDATE_SEEK);
        }
    }

    public void setPageGesture(boolean z) {
        this.isPageGesture = z;
    }

    public void setProgressVisibility(boolean z) {
        android.widget.SeekBar seekBar = this.mPlayerSeek;
        if (seekBar == null || this.isRtmpUri) {
            return;
        }
        this.isProgressVisibility = z;
        seekBar.setVisibility(z ? 0 : 4);
    }

    public void setFullscreenBntVisibility(boolean z) {
        android.widget.ImageView imageView = this.mIvFullscreen;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 4);
        }
    }

    public void setPlayBntVisibility(boolean z) {
        android.widget.ImageView imageView = this.mIvPlay;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 4);
        }
    }

    public void setCenterPlayBntVisibility(boolean z) {
        android.widget.ImageView imageView;
        if (!this.mIsNeverPlay || isPlaying() || (imageView = this.mIvPlayCircle) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void setIsEnableProgressGesture(boolean z) {
        this.isProgressGesture = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        _refreshHideRunnable();
        int id = view.getId();
        if (id == io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_IV_BACK) {
            onBackPressed();
            return;
        }
        if (id == io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_IV_PLAY || id == io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_IV_PLAY_CIRCLE) {
            _togglePlayStatus();
            return;
        }
        if (id == io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_IV_FULLSCREEN) {
            _toggleFullScreen();
            return;
        }
        if (id == io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_IV_DANMAKU_CONTROL) {
            _toggleDanmakuShow();
            return;
        }
        if (id == io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_TV_RECOVER_SCREEN) {
            this.mVideoView.resetVideoView(true);
            this.mIsNeedRecoverScreen = false;
            this.mTvRecoverScreen.setVisibility(8);
            return;
        }
        if (id == io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_TV_RELOAD) {
            reload();
            return;
        }
        if (id == io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_IV_MUTE) {
            boolean z = !this.isMutePlayer;
            this.isMutePlayer = z;
            setMutePlayer(z);
            this.mIVMute.setSelected(this.isMutePlayer);
            return;
        }
        if (id == io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_IV_SCREEN_LOCK && this.isShowScreenLockButton) {
            if (((java.lang.Integer) this.mIvScreenLock.getTag()).intValue() == 1) {
                this.mIvScreenLock.setTag(0);
                this.mIvScreenLock.setImageResource(io.dcloud.feature.media.R.drawable.video_screen_unlock);
                this.mIsForbidTouch = true;
            } else {
                this.mIvScreenLock.setTag(1);
                this.mIvScreenLock.setImageResource(io.dcloud.feature.media.R.drawable.video_screen_lock);
                this.mIsForbidTouch = false;
            }
            _togglePlayerLock();
            this.mIvScreenLock.setVisibility(0);
            getHandler().removeCallbacks(this.screenLockHideRunnable);
            getHandler().postDelayed(this.screenLockHideRunnable, io.dcloud.WebAppActivity.SPLASH_SECOND);
        }
    }

    public io.dcloud.media.video.ijkplayer.media.IjkPlayerView enableOrientation() {
        this.mIsForbidOrientation = false;
        if (this.mOrientationListener == null) {
            initOrientationEventListener();
        }
        this.mOrientationListener.enable();
        return this;
    }

    private void _toggleFullScreen() {
        io.dcloud.media.video.ijkplayer.media.IjkVideoView ijkVideoView;
        if (isFullscreen()) {
            exitFullScreen();
            return;
        }
        io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView = this.parentView;
        if (videoPlayerView != null) {
            int direction = videoPlayerView.getDirection();
            if (direction == Integer.MIN_VALUE && (ijkVideoView = this.mVideoView) != null) {
                direction = ijkVideoView.getVideoHeight() > this.mVideoView.getVideoWidth() ? 0 : -90;
            }
            this.mOrientation = direction;
        }
        fullScreen(this.mOrientation);
    }

    public void setCustomAdvanced(java.lang.String str) {
        io.dcloud.media.video.ijkplayer.media.IjkVideoView ijkVideoView = this.mVideoView;
        if (ijkVideoView != null) {
            ijkVideoView.setCustomAdvanced(str);
        }
    }

    private void _setFullScreen(boolean z) {
        java.lang.String str;
        this.mIsFullscreen = z;
        this.mIvFullscreen.setSelected(z);
        if (this.mOnPlayerChangedListener != null) {
            if (z) {
                str = io.dcloud.common.util.StringUtil.format(this.fullCallFormat, true, com.taobao.weex.common.Constants.Value.HORIZONTAL);
            } else {
                str = io.dcloud.common.util.StringUtil.format(this.fullCallFormat, false, "vertical");
            }
            this.mOnPlayerChangedListener.onChanged("fullscreenchange", str);
        }
        _showControlBar(5000);
        if (this.mIsNeedRecoverScreen) {
            if (z) {
                this.mVideoView.adjustVideoView(1.0f);
                this.mTvRecoverScreen.setVisibility(this.mIsShowBar ? 0 : 8);
            } else {
                this.mVideoView.resetVideoView(false);
                this.mTvRecoverScreen.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _handleOrientation(int i) {
        if (this.mIsNeverPlay) {
            return;
        }
        if (this.mIsFullscreen && !this.mIsAlwaysFullScreen) {
            if ((i < 0 || i > 30) && i < 330) {
                return;
            }
            this.mAttachActivity.setRequestedOrientation(1);
            return;
        }
        if (i >= 60 && i <= 120) {
            this.mAttachActivity.setRequestedOrientation(8);
        } else {
            if (i < 240 || i > 300) {
                return;
            }
            this.mAttachActivity.setRequestedOrientation(0);
        }
    }

    private void _refreshOrientationEnable() {
        if (this.mIsForbidOrientation) {
            return;
        }
        this.mOrientationListener.disable();
        this.mHandler.removeMessages(MSG_ENABLE_ORIENTATION);
        this.mHandler.sendEmptyMessageDelayed(MSG_ENABLE_ORIENTATION, 3000L);
    }

    private void initOrientationEventListener() {
        this.mOrientationListener = new android.view.OrientationEventListener(this.mAttachActivity) { // from class: io.dcloud.media.video.ijkplayer.media.IjkPlayerView.5
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i) {
                io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this._handleOrientation(i);
            }
        };
    }

    public boolean isFullscreen() {
        return this.mIsFullscreen;
    }

    public void fullScreen(int i) {
        android.view.ViewGroup.LayoutParams layoutParams;
        _refreshOrientationEnable();
        if (this.mIsFullscreen) {
            return;
        }
        this.originOrientation = this.mAttachActivity.getRequestedOrientation();
        if (i == 0) {
            if (this.mAttachActivity.getRequestedOrientation() != 1) {
                this.mAttachActivity.setRequestedOrientation(1);
            }
        } else if (i == 90) {
            if (this.mAttachActivity.getRequestedOrientation() != 8) {
                this.mAttachActivity.setRequestedOrientation(8);
            }
        } else if (i == -90 && this.mAttachActivity.getRequestedOrientation() != 0) {
            this.mAttachActivity.setRequestedOrientation(0);
        }
        setNavigationBar(true);
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        this.mAttachActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        android.view.ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        this.mRawParams = layoutParams2;
        if (layoutParams2 instanceof android.widget.RelativeLayout.LayoutParams) {
            layoutParams = new android.widget.RelativeLayout.LayoutParams(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else if (layoutParams2 instanceof android.widget.LinearLayout.LayoutParams) {
            layoutParams = new android.widget.LinearLayout.LayoutParams(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else if (layoutParams2 instanceof android.widget.FrameLayout.LayoutParams) {
            layoutParams = new android.widget.FrameLayout.LayoutParams(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            new android.app.AlertDialog.Builder(getContext()).setMessage("nonsupport parent layout, please do it by yourself").setPositiveButton(com.taobao.weex.ui.module.WXModalUIModule.OK, new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.media.video.ijkplayer.media.IjkPlayerView.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i2) {
                }
            }).setCancelable(false).show();
            return;
        }
        setLayoutParams(layoutParams);
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.mAttachActivity.getWindow().getDecorView().findViewById(android.R.id.content);
        if ((viewGroup instanceof android.widget.FrameLayout) && getParent() != viewGroup) {
            ((android.view.ViewGroup) getParent()).removeView(this);
            viewGroup.addView(this, new android.widget.FrameLayout.LayoutParams(-1, -1));
        }
        _setFullScreen(true);
        if (android.os.Build.VERSION.SDK_INT < 28 || !io.dcloud.feature.ui.navigator.QueryNotchTool.hasNotchInScreen(this.mAttachActivity)) {
            return;
        }
        int statusHeight = io.dcloud.common.adapter.util.DeviceInfo.getStatusHeight(getContext()) - io.dcloud.common.util.PdrUtil.pxFromDp(10.0f, getContext().getResources().getDisplayMetrics());
        if (i == 0) {
            this.mFullscreenTopBar.setPadding(0, statusHeight, 0, 0);
        } else {
            this.mLlBottomBar.setPadding(statusHeight, 0, statusHeight, 0);
            this.mFullscreenTopBar.setPadding(statusHeight, 0, statusHeight, 0);
        }
    }

    public void exitFullScreen() {
        _refreshOrientationEnable();
        if (this.mIsFullscreen) {
            int requestedOrientation = this.mAttachActivity.getRequestedOrientation();
            int i = this.originOrientation;
            if (requestedOrientation != i) {
                this.mAttachActivity.setRequestedOrientation(i);
            }
            setNavigationBar(false);
            setLayoutParams(this.mRawParams);
            _setFullScreen(false);
            if (getParent() != this.mRootLayout) {
                ((android.view.ViewGroup) getParent()).removeView(this);
                this.mRootLayout.addView(this, new android.widget.FrameLayout.LayoutParams(-1, -1));
            }
            if (android.os.Build.VERSION.SDK_INT < 28 || !io.dcloud.feature.ui.navigator.QueryNotchTool.hasNotchInScreen(this.mAttachActivity)) {
                return;
            }
            this.mLlBottomBar.setPadding(0, 0, 0, 0);
            this.mFullscreenTopBar.setPadding(0, 0, 0, 0);
        }
    }

    private void setNavigationBar(boolean z) {
        android.view.Window window = this.mAttachActivity.getWindow();
        android.view.View decorView = window.getDecorView();
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        if (!z) {
            decorView.setSystemUiVisibility(this.defaultSystemUI);
            if (io.dcloud.feature.ui.navigator.QueryNotchTool.hasNotchInScreen(this.mAttachActivity) && android.os.Build.VERSION.SDK_INT >= 28) {
                window.getAttributes().layoutInDisplayCutoutMode = this.defaultDisplayCutoutMode;
            }
        } else {
            this.defaultSystemUI = decorView.getSystemUiVisibility();
            this.mAttachActivity.getWindow().getDecorView().setSystemUiVisibility(5894);
            if (io.dcloud.feature.ui.navigator.QueryNotchTool.hasNotchInScreen(this.mAttachActivity) && android.os.Build.VERSION.SDK_INT >= 28) {
                this.defaultDisplayCutoutMode = attributes.layoutInDisplayCutoutMode;
                attributes.layoutInDisplayCutoutMode = 1;
            }
        }
        window.setAttributes(attributes);
    }

    public void setScaleType(java.lang.String str) {
        if (this.mVideoView != null) {
            str.hashCode();
            switch (str) {
                case "fill":
                    this.mVideoView.setAspectRatio(3);
                    this.mPlayerThumb.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                    break;
                case "cover":
                    this.mVideoView.setAspectRatio(1);
                    this.mPlayerThumb.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                    break;
                case "contain":
                    this.mVideoView.setAspectRatio(0);
                    this.mPlayerThumb.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
                    break;
            }
        }
    }

    public void playbackRate(java.lang.String str) {
        if (this.mVideoView != null) {
            if (java.util.Arrays.binarySearch(this.rates, str) >= 0) {
                this.mVideoView.setSpeed(java.lang.Float.parseFloat(str));
            } else {
                this.mVideoView.setSpeed(1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int _setProgress() {
        io.dcloud.media.video.ijkplayer.media.IjkVideoView ijkVideoView = this.mVideoView;
        if (ijkVideoView == null || this.mIsSeeking) {
            return 0;
        }
        int iMax = java.lang.Math.max(ijkVideoView.getCurrentPosition(), this.mInterruptPosition);
        int duration = getDuration();
        if (duration > 0) {
            this.mPlayerSeek.setProgress((int) ((((long) iMax) * 1000) / ((long) duration)));
        }
        this.mPlayerSeek.setSecondaryProgress(this.mVideoView.getBufferPercentage() * 10);
        this.mTvCurTime.setText(io.dcloud.media.video.ijkplayer.utils.StringUtils.generateTime(iMax));
        this.mTvEndTime.setText(io.dcloud.media.video.ijkplayer.utils.StringUtils.generateTime(duration));
        return iMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void progressCallBack() {
        io.dcloud.media.video.ijkplayer.media.IjkVideoView ijkVideoView = this.mVideoView;
        if (ijkVideoView == null || this.mIsSeeking || this.mIsBufferingStart || this.mOnPlayerChangedListener == null) {
            return;
        }
        this.mOnPlayerChangedListener.onChanged("timeupdate", io.dcloud.common.util.StringUtil.format(this.timeUpdateF, java.lang.Float.valueOf(java.lang.Math.max(ijkVideoView.getCurrentPosition(), this.mInterruptPosition) / 1000.0f), java.lang.Float.valueOf(getDuration() / 1000.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _setFastForward(java.lang.String str) {
        if (this.mFlTouchLayout.getVisibility() == 8) {
            this.mFlTouchLayout.setVisibility(0);
        }
        if (this.mTvFastForward.getVisibility() == 8) {
            this.mTvFastForward.setVisibility(0);
        }
        this.mTvFastForward.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _hideTouchView() {
        if (this.mFlTouchLayout.getVisibility() == 0) {
            this.mTvFastForward.setVisibility(8);
            this.mTvVolume.setVisibility(8);
            this.mTvBrightness.setVisibility(8);
            this.mFlTouchLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _onProgressSlide(float f) {
        java.lang.String str;
        if (!this.isRtmpUri && this.isProgressGesture) {
            int currentPosition = this.mVideoView.getCurrentPosition();
            long duration = getDuration();
            long j = currentPosition;
            long jMin = ((long) (java.lang.Math.min(100000L, duration / 2) * f)) + j;
            this.mTargetPosition = jMin;
            if (jMin > duration) {
                this.mTargetPosition = duration;
            } else if (jMin <= 0) {
                this.mTargetPosition = 0L;
            }
            long j2 = this.mTargetPosition;
            long j3 = (j2 - j) / 1000;
            if (j2 > j) {
                str = io.dcloud.media.video.ijkplayer.utils.StringUtils.generateTime(this.mTargetPosition) + "/" + io.dcloud.media.video.ijkplayer.utils.StringUtils.generateTime(duration);
            } else {
                str = io.dcloud.media.video.ijkplayer.utils.StringUtils.generateTime(this.mTargetPosition) + "/" + io.dcloud.media.video.ijkplayer.utils.StringUtils.generateTime(duration);
            }
            _setFastForward(str);
        }
    }

    private void _setVolumeInfo(int i) {
        if (this.mFlTouchLayout.getVisibility() == 8) {
            this.mFlTouchLayout.setVisibility(0);
        }
        if (this.mTvVolume.getVisibility() == 8) {
            this.mTvVolume.setVisibility(0);
        }
        this.mTvVolume.setText(((i * 100) / this.mMaxVolume) + "%");
    }

    public void setDuration(int i) {
        if (!this.mIsNeverPlay || isPlaying()) {
            return;
        }
        if (i > 0) {
            this.duration = i;
        } else {
            this.duration = -1;
        }
    }

    public int getDuration() {
        if (this.duration <= -1) {
            this.duration = this.mVideoView.getDuration();
        }
        return this.duration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _onVolumeSlide(float f) {
        if (this.isMutePlayer) {
            return;
        }
        boolean z = this.mIsFullscreen;
        if (z || this.isPageGesture) {
            if (!z || this.isFullScreenPageGesture) {
                if (this.mCurVolume == -1) {
                    int streamVolume = this.mAudioManager.getStreamVolume(3);
                    this.mCurVolume = streamVolume;
                    if (streamVolume < 0) {
                        this.mCurVolume = 0;
                    }
                }
                int i = this.mMaxVolume;
                int i2 = ((int) (f * i)) + this.mCurVolume;
                if (i2 <= i) {
                    i = i2 < 0 ? 0 : i2;
                }
                this.mAudioManager.setStreamVolume(3, i, 0);
                _setVolumeInfo(i);
            }
        }
    }

    public void isUseMediaCodec(boolean z) {
        io.dcloud.media.video.ijkplayer.media.IjkVideoView ijkVideoView = this.mVideoView;
        if (ijkVideoView != null) {
            ijkVideoView.setmIsUsingMediaCodec(z);
        }
    }

    public void setViewHttpCacheOpen(boolean z) {
        io.dcloud.media.video.ijkplayer.media.IjkVideoView ijkVideoView = this.mVideoView;
        if (ijkVideoView != null) {
            ijkVideoView.setIsHttpCacheOpen(z);
        }
    }

    public void setFlowStrategy(io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy enumPlayStrategy) {
        io.dcloud.media.video.ijkplayer.media.IjkVideoView ijkVideoView = this.mVideoView;
        if (ijkVideoView != null) {
            ijkVideoView.setFlowStrategy(enumPlayStrategy);
        }
    }

    public void setMutePlayer(boolean z) {
        this.isMutePlayer = z;
        this.mIVMute.setSelected(z);
        this.mVideoView.setvolume(z ? 0.0f : 1.0f);
    }

    public boolean isMutePlayer() {
        return this.isMutePlayer;
    }

    public void setIsFullScreenPageGesture(boolean z) {
        this.isFullScreenPageGesture = z;
    }

    public void setIsShowScreenLockButton(boolean z) {
        this.isShowScreenLockButton = z;
    }

    public void isMuteBtnShow(boolean z) {
        if (z) {
            this.mIVMute.setVisibility(0);
        } else {
            this.mIVMute.setVisibility(8);
        }
    }

    private void _setVolume(boolean z) {
        int i;
        if (this.isMutePlayer) {
            return;
        }
        int streamVolume = this.mAudioManager.getStreamVolume(3);
        if (z) {
            i = streamVolume + (this.mMaxVolume / 15);
        } else {
            i = streamVolume - (this.mMaxVolume / 15);
        }
        int i2 = this.mMaxVolume;
        if (i > i2) {
            i = i2;
        } else if (i < 0) {
            i = 0;
        }
        this.mAudioManager.setStreamVolume(3, i, 0);
        _setVolumeInfo(i);
        this.mHandler.removeCallbacks(this.mHideTouchViewRunnable);
        this.mHandler.postDelayed(this.mHideTouchViewRunnable, 1000L);
    }

    private void _setBrightnessInfo(float f) {
        if (this.mFlTouchLayout.getVisibility() == 8) {
            this.mFlTouchLayout.setVisibility(0);
        }
        if (this.mTvBrightness.getVisibility() == 8) {
            this.mTvBrightness.setVisibility(0);
        }
        this.mTvBrightness.setText(java.lang.Math.ceil(f * 100.0f) + "%");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _onBrightnessSlide(float f) {
        boolean z = this.mIsFullscreen;
        if (z || this.isPageGesture) {
            if (!z || this.isFullScreenPageGesture) {
                if (this.mCurBrightness < 0.0f) {
                    float f2 = this.mAttachActivity.getWindow().getAttributes().screenBrightness;
                    this.mCurBrightness = f2;
                    if (f2 < 0.0f) {
                        this.mCurBrightness = 0.5f;
                    } else if (f2 < 0.01f) {
                        this.mCurBrightness = 0.01f;
                    }
                }
                android.view.WindowManager.LayoutParams attributes = this.mAttachActivity.getWindow().getAttributes();
                attributes.screenBrightness = this.mCurBrightness + f;
                if (attributes.screenBrightness > 1.0f) {
                    attributes.screenBrightness = 1.0f;
                } else if (attributes.screenBrightness < 0.01f) {
                    attributes.screenBrightness = 0.01f;
                }
                _setBrightnessInfo(attributes.screenBrightness);
                this.mAttachActivity.getWindow().setAttributes(attributes);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _endGesture() {
        long j = this.mTargetPosition;
        if (j >= 0 && j != this.mVideoView.getCurrentPosition() && getDuration() > 0) {
            seekTo((int) this.mTargetPosition);
            this.mPlayerSeek.setProgress((int) ((this.mTargetPosition * 1000) / ((long) getDuration())));
            this.mTargetPosition = -1L;
        }
        _hideTouchView();
        _refreshHideRunnable();
        this.mCurVolume = -1;
        this.mCurBrightness = -1.0f;
    }

    public void setLoadingVisibility(boolean z) {
        this.isLoadingVisibility = z;
    }

    private synchronized void setLoadingVisibility(int i) {
        android.widget.ProgressBar progressBar = this.mLoadingView;
        if (!this.isLoadingVisibility) {
            i = 8;
        }
        progressBar.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _switchStatus(int i) {
        android.util.Log.i("IjkPlayerView", "status " + i);
        if (i != 3) {
            if (i != 336) {
                if (i != 701) {
                    if (i != 702) {
                        switch (i) {
                            case 331:
                                this.mInterruptPosition = java.lang.Math.max(this.mVideoView.getInterruptPosition(), this.mInterruptPosition);
                                pause();
                                if (this.mVideoView.getDuration() == -1 && !this.mIsReady) {
                                    setLoadingVisibility(8);
                                    this.mPlayerThumb.setVisibility(8);
                                    this.mIvPlayCircle.setVisibility(8);
                                    this.mFlReload.setVisibility(0);
                                } else {
                                    setLoadingVisibility(0);
                                    this.mHandler.sendEmptyMessage(MSG_TRY_RELOAD);
                                }
                                break;
                            case 333:
                                this.mIsReady = true;
                                break;
                            case 334:
                                this.mHandler.removeMessages(MSG_TRY_RELOAD);
                                if (this.mIsRenderingStart && !this.mIsBufferingStart && this.mVideoView.getCurrentPosition() > 0) {
                                    _resumeDanmaku();
                                }
                                setLoadingVisibility(8);
                                break;
                        }
                        return;
                    }
                }
                this.mIsBufferingStart = true;
                _pauseDanmaku();
                if (!this.mIsNeverPlay) {
                    setLoadingVisibility(0);
                }
                this.mHandler.removeMessages(MSG_TRY_RELOAD);
                return;
            }
            pause();
            if (this.mVideoView.getDuration() == -1 || this.mVideoView.getInterruptPosition() + 1000 < this.mVideoView.getDuration()) {
                this.mInterruptPosition = java.lang.Math.max(this.mVideoView.getInterruptPosition(), this.mInterruptPosition);
                io.dcloud.media.video.ijkplayer.OnPlayerChangedListener onPlayerChangedListener = this.mOnPlayerChangedListener;
                if (onPlayerChangedListener != null) {
                    onPlayerChangedListener.onChanged("error", "{message:'network error'}");
                    this.mFlReload.setVisibility(0);
                    return;
                }
                return;
            }
            this.mIsPlayComplete = true;
            tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener onCompletionListener = this.mCompletionListener;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(this.mVideoView.getMediaPlayer());
                return;
            }
            return;
        }
        this.mIsRenderingStart = true;
        this.mIsBufferingStart = false;
        setLoadingVisibility(8);
        this.mPlayerThumb.setVisibility(8);
        if (this.mLlBottomBar.getVisibility() == 0 && !this.mIsShowBar) {
            this.mIsShowBar = true;
        }
        this.mHandler.removeMessages(MSG_UPDATE_SEEK);
        this.mHandler.sendEmptyMessage(MSG_UPDATE_SEEK);
        if (this.mVideoView.isPlaying() && this.mIsNetConnected) {
            this.mInterruptPosition = 0;
            _resumeDanmaku();
            if (this.mIvPlay.isSelected()) {
                return;
            }
            this.mVideoView.start();
            this.mIvPlay.setSelected(true);
        }
    }

    public void setOnPreparedListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mVideoView.setOnPreparedListener(onPreparedListener);
    }

    public void setOnCompletionListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener onErrorListener) {
        this.mVideoView.setOnErrorListener(onErrorListener);
    }

    public void setOnInfoListener(tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener onInfoListener) {
        this.mOutsideInfoListener = onInfoListener;
    }

    public io.dcloud.media.video.ijkplayer.media.IjkPlayerView setDanmakuListener(io.dcloud.media.video.ijkplayer.danmaku.OnDanmakuListener onDanmakuListener) {
        this.mDanmakuListener = onDanmakuListener;
        return this;
    }

    public void setOnPlayerChangedListener(io.dcloud.media.video.ijkplayer.OnPlayerChangedListener onPlayerChangedListener) {
        this.mOnPlayerChangedListener = onPlayerChangedListener;
    }

    public int getCurPosition() {
        return this.mVideoView.getCurrentPosition();
    }

    public void setDirection(int i) {
        this.mOrientation = i;
    }

    public void setmDanmuList(java.lang.String str) {
        this.mDanmuList = str;
    }

    private void _initDanmaku() {
        this.mDanmakuView = (master.flame.danmaku.controller.IDanmakuView) findViewById(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_ID_SV_DANMAKU);
        io.dcloud.media.video.ijkplayer.utils.NavUtils.getNavigationBarHeight(this.mAttachActivity);
        this.mIvDanmakuControl.setOnClickListener(this);
        this.mMoreOptionsWidth = getResources().getDimensionPixelOffset(io.dcloud.media.video.ijkplayer.VideoR.VIDEO_IJK_DIMEN_DANMAKU_INPUT_BTN_SIZE) * 12;
    }

    private void _loadDanmaku() {
        if (this.mIsEnableDanmaku) {
            this.mDanmakuContext = master.flame.danmaku.danmaku.model.android.DanmakuContext.create();
            if (this.mDanmakuParser == null) {
                this.mDanmakuParser = new master.flame.danmaku.danmaku.parser.BaseDanmakuParser() { // from class: io.dcloud.media.video.ijkplayer.media.IjkPlayerView.11
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // master.flame.danmaku.danmaku.parser.BaseDanmakuParser
                    public master.flame.danmaku.danmaku.model.android.Danmakus parse() {
                        return new master.flame.danmaku.danmaku.model.android.Danmakus();
                    }
                };
            }
            try {
                setDanmakuSource(new java.io.ByteArrayInputStream(this.mDanmuList.getBytes("utf-8")));
                this.mDanmakuView.setCallback(new master.flame.danmaku.controller.DrawHandler.Callback() { // from class: io.dcloud.media.video.ijkplayer.media.IjkPlayerView.12
                    @Override // master.flame.danmaku.controller.DrawHandler.Callback
                    public void danmakuShown(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
                    }

                    @Override // master.flame.danmaku.controller.DrawHandler.Callback
                    public void drawingFinished() {
                    }

                    @Override // master.flame.danmaku.controller.DrawHandler.Callback
                    public void updateTimer(master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer) {
                    }

                    @Override // master.flame.danmaku.controller.DrawHandler.Callback
                    public void prepared() {
                        if (!io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mVideoView.isPlaying() || io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mIsBufferingStart) {
                            return;
                        }
                        io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mDanmakuView.start();
                    }
                });
                this.mDanmakuView.enableDanmakuDrawingCache(true);
                this.mDanmakuView.prepare(this.mDanmakuParser, this.mDanmakuContext);
            } catch (java.io.UnsupportedEncodingException unused) {
            }
        }
    }

    public io.dcloud.media.video.ijkplayer.media.IjkPlayerView enableDanmaku() {
        this.mIsEnableDanmaku = true;
        _initDanmaku();
        return this;
    }

    public io.dcloud.media.video.ijkplayer.media.IjkPlayerView enableDanmaku(boolean z) {
        this.mIsEnableDanmaku = z;
        if (z) {
            _initDanmaku();
            return this;
        }
        this.mIvDanmakuControl.setVisibility(8);
        return this;
    }

    public io.dcloud.media.video.ijkplayer.media.IjkPlayerView enableDanmuBtn(boolean z) {
        if (!this.mIsEnableDanmaku) {
            this.mIvDanmakuControl.setVisibility(8);
            return this;
        }
        if (z) {
            this.mIvDanmakuControl.setVisibility(0);
            return this;
        }
        this.mIvDanmakuControl.setVisibility(8);
        return this;
    }

    public io.dcloud.media.video.ijkplayer.media.IjkPlayerView setDanmakuSource(java.io.InputStream inputStream) {
        if (inputStream == null) {
            return this;
        }
        if (!this.mIsEnableDanmaku) {
            throw new java.lang.RuntimeException("Danmaku is disable, use enableDanmaku() first");
        }
        if (this.mDanmakuLoader == null) {
            this.mDanmakuLoader = master.flame.danmaku.danmaku.loader.android.DanmakuLoaderFactory.create(master.flame.danmaku.danmaku.loader.android.DanmakuLoaderFactory.TAG_ACFUN);
        }
        try {
            this.mDanmakuLoader.load(inputStream);
        } catch (master.flame.danmaku.danmaku.loader.IllegalDataException e) {
            e.printStackTrace();
        }
        master.flame.danmaku.danmaku.parser.IDataSource<?> dataSource = this.mDanmakuLoader.getDataSource();
        io.dcloud.media.video.ijkplayer.danmaku.StandardDanmaKuParser standardDanmaKuParser = new io.dcloud.media.video.ijkplayer.danmaku.StandardDanmaKuParser();
        this.mDanmakuParser = standardDanmaKuParser;
        standardDanmaKuParser.load(dataSource);
        return this;
    }

    public io.dcloud.media.video.ijkplayer.media.IjkPlayerView setDanmakuSource(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return this;
        }
        if (!this.mIsEnableDanmaku) {
            throw new java.lang.RuntimeException("Danmaku is disable, use enableDanmaku() first");
        }
        if (this.mDanmakuLoader == null) {
            this.mDanmakuLoader = master.flame.danmaku.danmaku.loader.android.DanmakuLoaderFactory.create(master.flame.danmaku.danmaku.loader.android.DanmakuLoaderFactory.TAG_BILI);
        }
        try {
            this.mDanmakuLoader.load(str);
        } catch (master.flame.danmaku.danmaku.loader.IllegalDataException e) {
            e.printStackTrace();
        }
        master.flame.danmaku.danmaku.parser.IDataSource<?> dataSource = this.mDanmakuLoader.getDataSource();
        io.dcloud.media.video.ijkplayer.danmaku.BiliDanmukuParser biliDanmukuParser = new io.dcloud.media.video.ijkplayer.danmaku.BiliDanmukuParser();
        this.mDanmakuParser = biliDanmukuParser;
        biliDanmukuParser.load(dataSource);
        return this;
    }

    public io.dcloud.media.video.ijkplayer.media.IjkPlayerView setDanmakuCustomParser(master.flame.danmaku.danmaku.parser.BaseDanmakuParser baseDanmakuParser, master.flame.danmaku.danmaku.loader.ILoader iLoader, io.dcloud.media.video.ijkplayer.danmaku.BaseDanmakuConverter baseDanmakuConverter) {
        this.mDanmakuParser = baseDanmakuParser;
        this.mDanmakuLoader = iLoader;
        this.mDanmakuConverter = baseDanmakuConverter;
        return this;
    }

    public io.dcloud.media.video.ijkplayer.media.IjkPlayerView showOrHideDanmaku(boolean z) {
        if (z) {
            this.mIvDanmakuControl.setSelected(false);
            this.mDanmakuView.show();
            return this;
        }
        this.mIvDanmakuControl.setSelected(true);
        this.mDanmakuView.hide();
        return this;
    }

    public void sendDanmaku(org.json.JSONObject jSONObject, boolean z) {
        if (!this.mIsEnableDanmaku) {
            throw new java.lang.RuntimeException("Danmaku is disable, use enableDanmaku() first");
        }
        if (android.text.TextUtils.isEmpty(jSONObject.optString("text"))) {
            com.dcloud.android.widget.toast.ToastCompat.makeText((android.content.Context) this.mAttachActivity, (java.lang.CharSequence) io.dcloud.application.DCLoudApplicationImpl.self().getContext().getString(io.dcloud.feature.media.R.string.dcloud_feature_media_player_toast_no_content), 0).show();
            return;
        }
        if (!this.mDanmakuView.isPrepared()) {
            com.dcloud.android.widget.toast.ToastCompat.makeText((android.content.Context) this.mAttachActivity, (java.lang.CharSequence) io.dcloud.application.DCLoudApplicationImpl.self().getContext().getString(io.dcloud.feature.media.R.string.dcloud_feature_media_player_toast_bullet_not_prepared), 0).show();
            return;
        }
        master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmakuCreateDanmaku = this.mDanmakuContext.mDanmakuFactory.createDanmaku(this.mDanmakuType);
        if (baseDanmakuCreateDanmaku == null || this.mDanmakuView == null) {
            return;
        }
        if (this.mDanmakuTextSize == -1.0f) {
            this.mDanmakuTextSize = (this.mDanmakuParser.getDisplayer().getDensity() - 0.6f) * 25.0f;
        }
        baseDanmakuCreateDanmaku.text = jSONObject.optString("text", "....");
        baseDanmakuCreateDanmaku.padding = 5;
        baseDanmakuCreateDanmaku.isLive = z;
        baseDanmakuCreateDanmaku.priority = (byte) 0;
        baseDanmakuCreateDanmaku.textSize = this.mDanmakuTextSize;
        baseDanmakuCreateDanmaku.textColor = android.graphics.Color.parseColor(jSONObject.optString("color", "#ffffff"));
        baseDanmakuCreateDanmaku.setTime(this.mDanmakuView.getCurrentTime() + 500);
        this.mDanmakuView.addDanmaku(baseDanmakuCreateDanmaku);
        io.dcloud.media.video.ijkplayer.danmaku.OnDanmakuListener onDanmakuListener = this.mDanmakuListener;
        if (onDanmakuListener != null) {
            io.dcloud.media.video.ijkplayer.danmaku.BaseDanmakuConverter baseDanmakuConverter = this.mDanmakuConverter;
            if (baseDanmakuConverter != null) {
                onDanmakuListener.onDataObtain(baseDanmakuConverter.convertDanmaku(baseDanmakuCreateDanmaku));
            } else {
                onDanmakuListener.onDataObtain(baseDanmakuCreateDanmaku);
            }
        }
    }

    public void editVideo() {
        if (this.mVideoView.isPlaying()) {
            pause();
            this.mVideoStatus = INTERRUPT_WHEN_PLAY;
        } else {
            this.mVideoStatus = INTERRUPT_WHEN_PAUSE;
        }
        _hideAllView(false);
    }

    public boolean recoverFromEditVideo() {
        if (this.mVideoStatus == NORMAL_STATUS) {
            return false;
        }
        if (this.mIsFullscreen) {
            _recoverScreen();
        }
        if (this.mVideoStatus == INTERRUPT_WHEN_PLAY) {
            start();
        }
        this.mVideoStatus = NORMAL_STATUS;
        return true;
    }

    public void clearDanma() {
        master.flame.danmaku.controller.IDanmakuView iDanmakuView = this.mDanmakuView;
        if (iDanmakuView == null || !iDanmakuView.isPrepared()) {
            return;
        }
        this.mDanmakuView.clearDanmakusOnScreen();
    }

    private void _resumeDanmaku() {
        master.flame.danmaku.controller.IDanmakuView iDanmakuView = this.mDanmakuView;
        if (iDanmakuView != null && iDanmakuView.isPrepared() && this.mDanmakuView.isPaused()) {
            long j = this.mDanmakuTargetPosition;
            if (j != -1) {
                this.mDanmakuView.seekTo(java.lang.Long.valueOf(j));
                this.mDanmakuTargetPosition = -1L;
            } else {
                this.mDanmakuView.resume();
            }
        }
    }

    private void _pauseDanmaku() {
        master.flame.danmaku.controller.IDanmakuView iDanmakuView = this.mDanmakuView;
        if (iDanmakuView == null || !iDanmakuView.isPrepared()) {
            return;
        }
        this.mDanmakuView.pause();
    }

    private void _toggleDanmakuShow() {
        if (this.mIvDanmakuControl.isSelected()) {
            showOrHideDanmaku(true);
        } else {
            showOrHideDanmaku(false);
        }
    }

    private void _initReceiver() {
        this.mScreenReceiver = new io.dcloud.media.video.ijkplayer.media.IjkPlayerView.ScreenBroadcastReceiver();
        this.mNetReceiver = new io.dcloud.media.video.ijkplayer.media.IjkPlayerView.NetBroadcastReceiver();
        this.mAttachActivity.registerReceiver(this.mScreenReceiver, new android.content.IntentFilter("android.intent.action.SCREEN_OFF"));
        this.mAttachActivity.registerReceiver(this.mNetReceiver, new android.content.IntentFilter(io.dcloud.common.util.net.NetCheckReceiver.netACTION));
    }

    private class ScreenBroadcastReceiver extends android.content.BroadcastReceiver {
        private ScreenBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this.mIsScreenLocked = true;
            }
        }
    }

    public class NetBroadcastReceiver extends android.content.BroadcastReceiver {
        public NetBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            if (io.dcloud.common.util.net.NetCheckReceiver.netACTION.equals(intent.getAction())) {
                io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView = io.dcloud.media.video.ijkplayer.media.IjkPlayerView.this;
                ijkPlayerView.mIsNetConnected = io.dcloud.media.video.ijkplayer.utils.NetWorkUtils.isNetworkAvailable(ijkPlayerView.mAttachActivity);
            }
        }
    }
}
