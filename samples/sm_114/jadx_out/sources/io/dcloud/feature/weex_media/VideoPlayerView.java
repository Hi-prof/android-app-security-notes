package io.dcloud.feature.weex_media;

/* JADX INFO: loaded from: classes2.dex */
public class VideoPlayerView extends android.widget.FrameLayout implements tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener, io.dcloud.media.weex.weex_video.ijkplayer.OnPlayerChangedListener, tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener {
    private boolean autoplay;
    private float duration;
    private float initialTime;
    private boolean isCreate;
    private boolean isEnableDanmu;
    private boolean isEnableDanmuBtn;
    private boolean isFinishLayout;
    private boolean loop;
    private io.dcloud.feature.weex_media.VideoComponent mComponent;
    private android.content.Context mContext;
    private java.lang.String mHeader;
    public boolean mIsFullScreen;
    public io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView mPlayerView;
    private java.lang.String mSrc;
    private java.lang.String poster;
    private int seek;
    private android.widget.FrameLayout subViewContainer;

    public interface IOnPlayerViewChangeListener {
        void onChanged(boolean z);
    }

    public VideoPlayerView(android.content.Context context, io.dcloud.feature.weex_media.VideoComponent videoComponent) {
        super(context);
        this.mSrc = "";
        this.mHeader = "";
        this.autoplay = false;
        this.loop = false;
        this.poster = "";
        this.duration = -1.0f;
        this.initialTime = 0.0f;
        this.isFinishLayout = false;
        this.seek = 0;
        this.mIsFullScreen = false;
        this.isCreate = false;
        this.isEnableDanmu = false;
        this.isEnableDanmuBtn = false;
        this.mContext = context;
        this.mComponent = videoComponent;
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(context);
        this.subViewContainer = frameLayout;
        addView(frameLayout, new android.widget.FrameLayout.LayoutParams(-1, -1));
        createVideoView();
        this.subViewContainer.bringToFront();
        this.mPlayerView.setChangeListener(new io.dcloud.feature.weex_media.VideoPlayerView.IOnPlayerViewChangeListener() { // from class: io.dcloud.feature.weex_media.VideoPlayerView.1
            @Override // io.dcloud.feature.weex_media.VideoPlayerView.IOnPlayerViewChangeListener
            public void onChanged(boolean z) {
                io.dcloud.feature.weex_media.VideoPlayerView.this.mIsFullScreen = z;
            }
        });
        if (videoComponent.getInstance().isFrameViewShow()) {
            this.mPlayerView.setVideoVisibility();
        } else {
            videoComponent.getInstance().addFrameViewEventListener(new com.taobao.weex.WXSDKInstance.FrameViewEventListener() { // from class: io.dcloud.feature.weex_media.VideoPlayerView.2
                @Override // com.taobao.weex.WXSDKInstance.FrameViewEventListener
                public void onShowAnimationEnd() {
                    if (io.dcloud.feature.weex_media.VideoPlayerView.this.mPlayerView != null) {
                        io.dcloud.feature.weex_media.VideoPlayerView.this.mPlayerView.setVideoVisibility();
                    }
                    if (io.dcloud.feature.weex_media.VideoPlayerView.this.mComponent == null || io.dcloud.feature.weex_media.VideoPlayerView.this.mComponent.getInstance() == null) {
                        return;
                    }
                    io.dcloud.feature.weex_media.VideoPlayerView.this.mComponent.getInstance().removeFrameViewEventListener(this);
                }
            });
        }
    }

    public void createVideoView() {
        if (this.isCreate) {
            return;
        }
        this.isCreate = true;
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = new io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView(this.mContext, null, this);
        this.mPlayerView = ijkPlayerView;
        ijkPlayerView.setComponent(this.mComponent);
        addView(this.mPlayerView, new android.widget.FrameLayout.LayoutParams(-1, -1));
        this.mPlayerView.init().setPlayerRootView(this);
        this.mPlayerView.setOnInfoListener(this);
        this.mPlayerView.setOnPlayerChangedListener(this);
        this.mPlayerView.setOnBufferingUpdateListener(this);
    }

    public android.view.ViewGroup getPlayerView() {
        return this.subViewContainer;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.mComponent.getStyles().getBackgroundColor())) {
            setBackgroundColor(-16777216);
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00c6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x00c8 A[Catch: all -> 0x012d, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x0009, B:10:0x0011, B:14:0x0019, B:16:0x0020, B:18:0x0026, B:20:0x003c, B:22:0x0042, B:24:0x004a, B:26:0x0052, B:27:0x005e, B:28:0x007d, B:30:0x0085, B:31:0x008d, B:34:0x00a3, B:35:0x00a6, B:37:0x00b0, B:39:0x00ba, B:40:0x00be, B:43:0x00c8, B:45:0x00d3, B:52:0x00fc, B:54:0x010d, B:55:0x0113, B:57:0x0128, B:44:0x00ce, B:46:0x00d9, B:49:0x00e3, B:51:0x00ee, B:50:0x00e9), top: B:63:0x0003, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ce A[Catch: all -> 0x012d, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x0009, B:10:0x0011, B:14:0x0019, B:16:0x0020, B:18:0x0026, B:20:0x003c, B:22:0x0042, B:24:0x004a, B:26:0x0052, B:27:0x005e, B:28:0x007d, B:30:0x0085, B:31:0x008d, B:34:0x00a3, B:35:0x00a6, B:37:0x00b0, B:39:0x00ba, B:40:0x00be, B:43:0x00c8, B:45:0x00d3, B:52:0x00fc, B:54:0x010d, B:55:0x0113, B:57:0x0128, B:44:0x00ce, B:46:0x00d9, B:49:0x00e3, B:51:0x00ee, B:50:0x00e9), top: B:63:0x0003, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00d9 A[Catch: all -> 0x012d, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x0009, B:10:0x0011, B:14:0x0019, B:16:0x0020, B:18:0x0026, B:20:0x003c, B:22:0x0042, B:24:0x004a, B:26:0x0052, B:27:0x005e, B:28:0x007d, B:30:0x0085, B:31:0x008d, B:34:0x00a3, B:35:0x00a6, B:37:0x00b0, B:39:0x00ba, B:40:0x00be, B:43:0x00c8, B:45:0x00d3, B:52:0x00fc, B:54:0x010d, B:55:0x0113, B:57:0x0128, B:44:0x00ce, B:46:0x00d9, B:49:0x00e3, B:51:0x00ee, B:50:0x00e9), top: B:63:0x0003, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00e1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x00e3 A[Catch: all -> 0x012d, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x0009, B:10:0x0011, B:14:0x0019, B:16:0x0020, B:18:0x0026, B:20:0x003c, B:22:0x0042, B:24:0x004a, B:26:0x0052, B:27:0x005e, B:28:0x007d, B:30:0x0085, B:31:0x008d, B:34:0x00a3, B:35:0x00a6, B:37:0x00b0, B:39:0x00ba, B:40:0x00be, B:43:0x00c8, B:45:0x00d3, B:52:0x00fc, B:54:0x010d, B:55:0x0113, B:57:0x0128, B:44:0x00ce, B:46:0x00d9, B:49:0x00e3, B:51:0x00ee, B:50:0x00e9), top: B:63:0x0003, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00e9 A[Catch: all -> 0x012d, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x0009, B:10:0x0011, B:14:0x0019, B:16:0x0020, B:18:0x0026, B:20:0x003c, B:22:0x0042, B:24:0x004a, B:26:0x0052, B:27:0x005e, B:28:0x007d, B:30:0x0085, B:31:0x008d, B:34:0x00a3, B:35:0x00a6, B:37:0x00b0, B:39:0x00ba, B:40:0x00be, B:43:0x00c8, B:45:0x00d3, B:52:0x00fc, B:54:0x010d, B:55:0x0113, B:57:0x0128, B:44:0x00ce, B:46:0x00d9, B:49:0x00e3, B:51:0x00ee, B:50:0x00e9), top: B:63:0x0003, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x010d A[Catch: all -> 0x012d, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x0009, B:10:0x0011, B:14:0x0019, B:16:0x0020, B:18:0x0026, B:20:0x003c, B:22:0x0042, B:24:0x004a, B:26:0x0052, B:27:0x005e, B:28:0x007d, B:30:0x0085, B:31:0x008d, B:34:0x00a3, B:35:0x00a6, B:37:0x00b0, B:39:0x00ba, B:40:0x00be, B:43:0x00c8, B:45:0x00d3, B:52:0x00fc, B:54:0x010d, B:55:0x0113, B:57:0x0128, B:44:0x00ce, B:46:0x00d9, B:49:0x00e3, B:51:0x00ee, B:50:0x00e9), top: B:63:0x0003, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0128 A[Catch: all -> 0x012d, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x0009, B:10:0x0011, B:14:0x0019, B:16:0x0020, B:18:0x0026, B:20:0x003c, B:22:0x0042, B:24:0x004a, B:26:0x0052, B:27:0x005e, B:28:0x007d, B:30:0x0085, B:31:0x008d, B:34:0x00a3, B:35:0x00a6, B:37:0x00b0, B:39:0x00ba, B:40:0x00be, B:43:0x00c8, B:45:0x00d3, B:52:0x00fc, B:54:0x010d, B:55:0x0113, B:57:0x0128, B:44:0x00ce, B:46:0x00d9, B:49:0x00e3, B:51:0x00ee, B:50:0x00e9), top: B:63:0x0003, inners: #1 }] */
    public synchronized void onLayoutFinished(java.lang.String str) {
        float f;
        android.net.Uri videoFileUri;
        if (this.mPlayerView == null) {
            return;
        }
        if (android.text.TextUtils.isEmpty(this.mSrc) && android.text.TextUtils.isEmpty(str)) {
            return;
        }
        io.dcloud.media.weex.weex_video.ijkplayer.media.AssetsDataSourceProvider assetsDataSourceProvider = null;
        if (!android.text.TextUtils.isEmpty(str) && !io.dcloud.common.util.PdrUtil.isNetPath(str)) {
            str = this.mComponent.getInstance().rewriteUri(android.net.Uri.parse(str), "video").getPath();
            if (str != null && !io.dcloud.common.util.PdrUtil.isDeviceRootDir(str)) {
                try {
                    if (this.mComponent.getIApp() != null) {
                        if (!str.startsWith("/")) {
                            str = "/" + str;
                        }
                        str = this.mComponent.getInstance().rewriteUri(android.net.Uri.parse(this.mComponent.getIApp().checkPrivateDirAndCopy2Temp(str)), "video").getPath();
                    } else {
                        if (str.startsWith("/")) {
                            str = str.replaceFirst("/", "");
                        }
                        assetsDataSourceProvider = new io.dcloud.media.weex.weex_video.ijkplayer.media.AssetsDataSourceProvider(this.mComponent.getContext().getAssets().openFd(str));
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            if (!io.dcloud.common.util.FileUtil.checkPrivatePath(getContext(), str) && (videoFileUri = io.dcloud.common.util.FileUtil.getVideoFileUri(getContext(), str)) != null) {
                str = videoFileUri.toString();
            }
            if (android.text.TextUtils.isEmpty(this.mSrc)) {
                if (assetsDataSourceProvider == null) {
                    this.mPlayerView.setVideoPath(str);
                } else {
                    this.mPlayerView.setVideoFileDescriptor(assetsDataSourceProvider);
                }
                this.mPlayerView.clearDanma();
            } else if (!this.mSrc.equalsIgnoreCase(str)) {
                if (assetsDataSourceProvider == null) {
                    this.mPlayerView.switchVideoPath(str);
                } else {
                    this.mPlayerView.switchVideoFileDescriptor(assetsDataSourceProvider);
                }
                this.mPlayerView.clearDanma();
                io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
                ijkPlayerView.setMutePlayer(ijkPlayerView.isMutePlayer());
            }
            this.mSrc = str;
            this.mPlayerView.setDuration((int) this.duration);
            f = this.initialTime;
            if (f > 0.0f) {
                this.mPlayerView.seekTo((int) f);
            }
            this.mPlayerView.enableDanmaku(this.isEnableDanmu);
            this.mPlayerView.enableDanmuBtn(this.isEnableDanmuBtn);
            this.isFinishLayout = true;
            if (this.autoplay) {
                play();
            }
            return;
        }
        if (android.text.TextUtils.isEmpty(this.mSrc)) {
            if (assetsDataSourceProvider == null) {
                this.mPlayerView.setVideoPath(str);
            } else {
                this.mPlayerView.setVideoFileDescriptor(assetsDataSourceProvider);
            }
            this.mPlayerView.clearDanma();
        } else if (!this.mSrc.equalsIgnoreCase(str)) {
            if (assetsDataSourceProvider == null) {
                this.mPlayerView.switchVideoPath(str);
            } else {
                this.mPlayerView.switchVideoFileDescriptor(assetsDataSourceProvider);
            }
            this.mPlayerView.clearDanma();
            io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView2 = this.mPlayerView;
            ijkPlayerView2.setMutePlayer(ijkPlayerView2.isMutePlayer());
        }
        this.mSrc = str;
        this.mPlayerView.setDuration((int) this.duration);
        f = this.initialTime;
        if (f > 0.0f) {
            this.mPlayerView.seekTo((int) f);
        }
        this.mPlayerView.enableDanmaku(this.isEnableDanmu);
        this.mPlayerView.enableDanmuBtn(this.isEnableDanmuBtn);
        this.isFinishLayout = true;
        if (this.autoplay) {
            play();
        }
        return;
        throw th;
    }

    public void requestFullScreen(int i) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(java.lang.Integer.valueOf(i))) {
            i = 90;
        }
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.fullScreen(i);
        }
    }

    public void exitFullScreen() {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.exitFullScreen();
        }
    }

    public void play() {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.start();
        }
    }

    public void pause() {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.pause();
        }
    }

    public void resume() {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.onResume();
        }
    }

    public void stop() {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.stop();
        }
    }

    public void seek(int i) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            this.seek = i;
            ijkPlayerView.seekTo(i);
        }
    }

    public void sendDanmu(com.alibaba.fastjson.JSONObject jSONObject) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.sendDanmaku(new org.json.JSONObject(jSONObject), true);
        }
    }

    public void sendPlayBackRate(java.lang.String str) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.playbackRate(str);
        }
    }

    public void destory() {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.onDestroy();
            this.mPlayerView = null;
        }
    }

    public void setSrc(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && this.isFinishLayout) {
            onLayoutFinished(str);
        }
    }

    public void setHeader(java.lang.String str) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.setHeader(str);
            if (this.isFinishLayout) {
                onLayoutFinished("");
            }
        }
    }

    public void onActivityResume() {
        if (android.text.TextUtils.isEmpty(this.poster)) {
            return;
        }
        com.bumptech.glide.Glide.with(this).load(this.poster).into(this.mPlayerView.mPlayerThumb);
    }

    public void setAutoplay(boolean z) {
        this.autoplay = z;
    }

    public void setLoop(boolean z) {
        this.loop = z;
    }

    public void setPoster(java.lang.String str) {
        if (this.mPlayerView == null || android.text.TextUtils.isEmpty(str) || this.poster.equalsIgnoreCase(str)) {
            return;
        }
        com.bumptech.glide.Glide.with(this).load(str).into(this.mPlayerView.mPlayerThumb);
        this.poster = str;
    }

    public void setProgress(boolean z) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.setProgressVisibility(z);
        }
    }

    public void setPlayBtnVisibility(boolean z) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.setPlayBntVisibility(z);
        }
    }

    public void setMuted(boolean z) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.setMutePlayer(z);
        }
    }

    public void setControls(boolean z) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.setControls(z);
        }
    }

    public void setPageGesture(boolean z) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.setPageGesture(z);
        }
    }

    public void setLockScreen(boolean z) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.setIsShowScreenLockButton(z);
        }
    }

    public void setEnablePlayGesture(boolean z) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.setmIsDoubleTapEnable(z);
        }
    }

    public void setFullScreenPageGesture(boolean z) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.setFullScreenPageGesture(z);
        }
    }

    public void setShowFullScreenBtn(boolean z) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.setFullscreenBntVisibility(z);
        }
    }

    public void setEnableProgressGesture(boolean z) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.setIsEnableProgressGesture(z);
        }
    }

    public void setDirection(int i) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.setDirection(i);
        }
    }

    public void setEnableDanmu(boolean z) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            this.isEnableDanmu = z;
            ijkPlayerView.enableDanmaku(z);
        }
    }

    public void setDanmuBtn(boolean z) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            this.isEnableDanmuBtn = z;
            ijkPlayerView.enableDanmuBtn(z);
        }
    }

    public void setDanmuList(com.alibaba.fastjson.JSONArray jSONArray) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.setmDanmuList(jSONArray.toString());
        }
    }

    public void setObjectFit(java.lang.String str) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView;
        if (android.text.TextUtils.isEmpty(str) || (ijkPlayerView = this.mPlayerView) == null) {
            return;
        }
        ijkPlayerView.setScaleType(str);
    }

    public void setMuteBtn(boolean z) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.isMuteBtnShow(z);
        }
    }

    public void setTitle(java.lang.String str) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView;
        if (io.dcloud.common.util.PdrUtil.isEmpty(str) || (ijkPlayerView = this.mPlayerView) == null) {
            return;
        }
        ijkPlayerView.setTitle(str);
    }

    public void setHttpCacheEnable(boolean z) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.setHttpCacheEnable(z);
        }
    }

    public void setFlowStrategy(io.dcloud.feature.weex_media.option.EnumPlayStrategy enumPlayStrategy) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.setFlowStrategy(enumPlayStrategy);
        }
    }

    public void setShowLoading(boolean z) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.setLoadingVisibility(z);
        }
    }

    public void setPlayBtnPosition(java.lang.String str) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.setPlayBtnPosition(str);
        }
    }

    public void setShowCenterPlayBtn(boolean z) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.setCenterPlayBtnVisibility(z);
        }
    }

    public void setCodec(java.lang.String str) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.isUseMediaCodec(str.equals("hardware"));
        }
    }

    public void setDuration(float f) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            float f2 = f * 1000.0f;
            this.duration = f2;
            if (this.isFinishLayout) {
                ijkPlayerView.setDuration((int) f2);
            }
        }
    }

    public void setInitialTime(float f) {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView == null || f <= 0.0f) {
            return;
        }
        float f2 = f * 1000.0f;
        this.initialTime = f2;
        if (this.isFinishLayout) {
            ijkPlayerView.seekTo((int) f2);
        }
    }

    @Override // io.dcloud.media.weex.weex_video.ijkplayer.OnPlayerChangedListener
    public void onChanged(java.lang.String str, java.lang.String str2) {
        java.util.HashMap map = new java.util.HashMap();
        if (!android.text.TextUtils.isEmpty(str2)) {
            try {
                map.put("detail", com.alibaba.fastjson.JSON.parse(str2));
            } catch (java.lang.Exception unused) {
                map.put("detail", str2);
            }
        }
        execCallBack(str, map);
        if (this.mPlayerView != null && (this.mComponent.getChild(0) instanceof io.dcloud.feature.weex.adapter.ScalableViewComponent) && str.equals("fullscreenchange")) {
            if (isFullScreen()) {
                removeView(this.subViewContainer);
                this.mPlayerView.addView(this.subViewContainer);
                this.subViewContainer.bringToFront();
            } else {
                this.mPlayerView.removeView(this.subViewContainer);
                removeView(this.subViewContainer);
                addView(this.subViewContainer);
                this.subViewContainer.bringToFront();
            }
        }
    }

    public boolean isFullScreen() {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        return ijkPlayerView != null && ijkPlayerView.isFullscreen();
    }

    public boolean onBackPress() {
        io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        return ijkPlayerView != null && ijkPlayerView.onBackPressed();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
    public boolean onInfo(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2) {
        if (i == 331) {
            execCallBack("error", new java.util.HashMap<>());
        } else if (i != 332 && i != 701) {
            switch (i) {
                case 334:
                    execCallBack(com.taobao.weex.common.Constants.Value.PLAY, new java.util.HashMap<>());
                    break;
                case 335:
                    execCallBack("pause", new java.util.HashMap<>());
                    break;
                case 336:
                    if (this.loop) {
                        float f = this.initialTime;
                        if (f > 0.0f) {
                            this.mPlayerView.seekTo((int) f);
                        }
                        play();
                    }
                    execCallBack("ended", new java.util.HashMap<>());
                    break;
                case 337:
                    io.dcloud.media.weex.weex_video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
                    java.lang.String str = io.dcloud.common.util.StringUtil.format("{'position':%d}", java.lang.Integer.valueOf(ijkPlayerView != null ? ijkPlayerView.getCurPosition() : 0));
                    java.util.HashMap map = new java.util.HashMap();
                    map.put("detail", str);
                    execCallBack("seekcomplete", map);
                    break;
            }
        } else {
            execCallBack(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_WAITING, new java.util.HashMap<>());
        }
        return false;
    }

    private void execCallBack(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (this.mComponent.getEvents().contains(str)) {
            this.mComponent.fireEvent(str, map);
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i) {
        java.util.Map<java.lang.String, java.lang.Object> map = new java.util.HashMap<>();
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put("buffered", java.lang.Integer.valueOf(i));
        map.put("detail", map2);
        execCallBack("progress", map);
    }

    public int getDirection() {
        io.dcloud.feature.weex_media.VideoComponent videoComponent = this.mComponent;
        if (videoComponent != null && videoComponent.getAttrs().containsKey("direction")) {
            try {
                return java.lang.Integer.parseInt(java.lang.String.valueOf(this.mComponent.getAttrs().get("direction")));
            } catch (java.lang.Exception unused) {
            }
        }
        return Integer.MIN_VALUE;
    }
}
