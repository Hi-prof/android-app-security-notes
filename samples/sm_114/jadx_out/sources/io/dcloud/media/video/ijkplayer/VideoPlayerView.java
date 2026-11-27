package io.dcloud.media.video.ijkplayer;

/* JADX INFO: loaded from: classes2.dex */
public class VideoPlayerView extends android.widget.FrameLayout implements io.dcloud.common.DHInterface.IVideoPlayer {
    public org.json.JSONObject fullScreenOptions;
    private boolean isAutoPlay;
    private boolean isLoopPlay;
    private java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String>> mCallbacks;
    private java.lang.String mHeaderInfo;
    private io.dcloud.common.DHInterface.IWebview mIWebview;
    private org.json.JSONObject mOptions;
    private io.dcloud.media.video.ijkplayer.media.IjkPlayerView mPlayerView;
    private java.lang.String mPosterUrl;
    private java.lang.String mUrl;
    private int[] rect;
    public boolean videoHandleTouch;

    public void setFullScreenOptions(org.json.JSONObject jSONObject) {
        this.fullScreenOptions = jSONObject;
    }

    public VideoPlayerView(android.app.Activity activity, io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONObject jSONObject) {
        super(activity);
        this.isAutoPlay = false;
        this.isLoopPlay = false;
        this.fullScreenOptions = null;
        this.videoHandleTouch = false;
        this.mIWebview = iWebview;
        io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView = new io.dcloud.media.video.ijkplayer.media.IjkPlayerView(activity, null, this);
        this.mPlayerView = ijkPlayerView;
        addView(ijkPlayerView, new android.widget.FrameLayout.LayoutParams(-1, -1));
        this.mCallbacks = new java.util.HashMap<>();
        this.mPlayerView.init().setPlayerRootView(this);
        this.mPlayerView.setOnInfoListener(new tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener() { // from class: io.dcloud.media.video.ijkplayer.VideoPlayerView.1
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i2) {
                if (io.dcloud.media.video.ijkplayer.VideoPlayerView.this.mIWebview.obtainApp() == null) {
                    return false;
                }
                if (i == 336) {
                    io.dcloud.media.video.ijkplayer.VideoPlayerView.this.statusChanged("ended", "");
                    if (io.dcloud.media.video.ijkplayer.VideoPlayerView.this.isLoopPlay) {
                        int iOptInt = io.dcloud.media.video.ijkplayer.VideoPlayerView.this.mOptions.optInt("initial-time");
                        if (iOptInt > 0) {
                            io.dcloud.media.video.ijkplayer.VideoPlayerView.this.mPlayerView.seekTo(iOptInt * 1000);
                        }
                        io.dcloud.media.video.ijkplayer.VideoPlayerView.this.play();
                    }
                } else if (i == 334) {
                    io.dcloud.media.video.ijkplayer.VideoPlayerView.this.statusChanged(com.taobao.weex.common.Constants.Value.PLAY, "");
                } else if (i == 335) {
                    io.dcloud.media.video.ijkplayer.VideoPlayerView.this.statusChanged("pause", "");
                } else if (i == 331) {
                    io.dcloud.media.video.ijkplayer.VideoPlayerView.this.statusChanged("error", "");
                } else if (i == 332 || i == 701) {
                    io.dcloud.media.video.ijkplayer.VideoPlayerView.this.statusChanged(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_WAITING, "");
                } else if (i == 337) {
                    io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView = io.dcloud.media.video.ijkplayer.VideoPlayerView.this;
                    videoPlayerView.statusChanged("seekcomplete", io.dcloud.common.util.StringUtil.format("{'position':%d}", java.lang.Integer.valueOf(videoPlayerView.mPlayerView != null ? io.dcloud.media.video.ijkplayer.VideoPlayerView.this.mPlayerView.getCurPosition() : 0)));
                }
                return false;
            }
        });
        this.mPlayerView.setOnPlayerChangedListener(new io.dcloud.media.video.ijkplayer.OnPlayerChangedListener() { // from class: io.dcloud.media.video.ijkplayer.VideoPlayerView.2
            @Override // io.dcloud.media.video.ijkplayer.OnPlayerChangedListener
            public void onChanged(java.lang.String str, java.lang.String str2) {
                io.dcloud.media.video.ijkplayer.VideoPlayerView.this.statusChanged(str, str2);
            }
        });
        initOptionsPlayerView(this.mPlayerView, jSONObject);
    }

    @Override // io.dcloud.common.DHInterface.IVideoPlayer
    public boolean isVideoHandleTouch() {
        return this.videoHandleTouch;
    }

    public void initOptionsPlayerView(io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView, org.json.JSONObject jSONObject) {
        boolean z;
        android.net.Uri videoFileUri;
        this.mOptions = jSONObject;
        java.lang.String strOptString = jSONObject.optString("src");
        if (android.text.TextUtils.isEmpty(strOptString)) {
            return;
        }
        if (!io.dcloud.common.util.PdrUtil.isNetPath(strOptString)) {
            strOptString = this.mIWebview.obtainApp().convert2AbsFullPath(this.mIWebview.obtainFullUrl(), strOptString);
            if (strOptString.startsWith("/android_asset")) {
                strOptString = strOptString.replace("/android_asset", "");
            } else if (strOptString.startsWith("android_asset")) {
                strOptString = strOptString.replace("android_asset", "");
            }
            if (!io.dcloud.common.util.PdrUtil.isDeviceRootDir(strOptString) && !android.text.TextUtils.isEmpty(strOptString)) {
                strOptString = this.mIWebview.obtainApp().convert2AbsFullPath(this.mIWebview.obtainFullUrl(), this.mIWebview.obtainApp().checkPrivateDirAndCopy2Temp(strOptString));
            }
            if (!io.dcloud.common.util.FileUtil.checkPrivatePath(getContext(), strOptString) && (videoFileUri = io.dcloud.common.util.FileUtil.getVideoFileUri(getContext(), strOptString)) != null) {
                strOptString = videoFileUri.toString();
            }
        }
        this.isAutoPlay = this.mOptions.optBoolean(com.taobao.weex.common.Constants.Name.AUTOPLAY, this.isAutoPlay);
        this.isLoopPlay = this.mOptions.optBoolean("loop", this.isLoopPlay);
        setPoster(this.mOptions.optString("poster"));
        if (!this.mOptions.isNull("muted")) {
            ijkPlayerView.setMutePlayer(this.mOptions.optBoolean("muted", false));
        }
        if (this.mOptions.optBoolean("page-gesture", false) || this.mOptions.optBoolean("vslide-gesture", false)) {
            this.videoHandleTouch = true;
            z = true;
        } else {
            z = false;
        }
        ijkPlayerView.setPageGesture(z);
        ijkPlayerView.setIsFullScreenPageGesture(this.mOptions.optBoolean("vslide-gesture-in-fullscreen", true));
        ijkPlayerView.setIsShowScreenLockButton(this.mOptions.optBoolean("show-screen-lock-button", false));
        ijkPlayerView.setProgressVisibility(this.mOptions.optBoolean("show-progress", true));
        ijkPlayerView.setFullscreenBntVisibility(this.mOptions.optBoolean("show-fullscreen-btn", true));
        ijkPlayerView.setPlayBntVisibility(this.mOptions.optBoolean("show-play-btn", true));
        ijkPlayerView.setIsEnableProgressGesture(this.mOptions.optBoolean("enable-progress-gesture", true));
        ijkPlayerView.setmIsDoubleTapEnable(this.mOptions.optBoolean("enable-play-gesture", false));
        ijkPlayerView.setLoadingVisibility(this.mOptions.optBoolean(com.taobao.weex.common.Constants.Name.SHOW_LOADING, true));
        ijkPlayerView.setDirection(this.mOptions.optInt("direction", -90));
        ijkPlayerView.setmDanmuList(this.mOptions.optString("danmu-list"));
        if (this.mOptions.has("objectFit")) {
            ijkPlayerView.setScaleType(this.mOptions.optString("objectFit", "contain"));
        } else if (this.mOptions.has("object-fit")) {
            ijkPlayerView.setScaleType(this.mOptions.optString("object-fit", "contain"));
        }
        ijkPlayerView.isMuteBtnShow(this.mOptions.optBoolean("show-mute-btn", false));
        if (this.mOptions.has("codec")) {
            ijkPlayerView.isUseMediaCodec(this.mOptions.optString("codec").equals("hardware"));
        }
        if (this.mOptions.has("advanced")) {
            ijkPlayerView.setCustomAdvanced(this.mOptions.optString("advanced"));
        }
        if (this.mOptions.has("httpCache")) {
            ijkPlayerView.setViewHttpCacheOpen(this.mOptions.optBoolean("httpCache", false));
        }
        if (this.mOptions.has("playStrategy")) {
            int iOptInt = this.mOptions.optInt("playStrategy", io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy.DEFAULT.getFlagVal());
            io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy enumPlayStrategy = io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy.PLAY_SMOOTH;
            if (iOptInt == io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy.PLAY_SMOOTH.getFlagVal()) {
                enumPlayStrategy = io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy.PLAY_SMOOTH;
            } else if (iOptInt == io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy.START_QUICK.getFlagVal()) {
                enumPlayStrategy = io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy.START_QUICK;
            } else if (iOptInt == io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy.M3U8_SMOOTH.getFlagVal()) {
                enumPlayStrategy = io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy.M3U8_SMOOTH;
            } else if (iOptInt == io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy.DEFAULT.getFlagVal()) {
                enumPlayStrategy = io.dcloud.media.video.ijkplayer.option.EnumPlayStrategy.DEFAULT;
            }
            ijkPlayerView.setFlowStrategy(enumPlayStrategy);
        }
        java.lang.String strOptString2 = jSONObject.optString(com.taobao.weex.ui.component.WXBasicComponentType.HEADER);
        if (android.text.TextUtils.isEmpty(this.mUrl)) {
            this.mPlayerView.setVideoPath(strOptString, strOptString2);
            resetSeek(ijkPlayerView);
        } else if (!this.mUrl.equalsIgnoreCase(strOptString) || !this.mHeaderInfo.equalsIgnoreCase(strOptString2)) {
            this.mPlayerView.switchVideoPath(strOptString, strOptString2);
            resetSeek(ijkPlayerView);
            io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView2 = this.mPlayerView;
            ijkPlayerView2.setMutePlayer(ijkPlayerView2.isMutePlayer());
        }
        ijkPlayerView.setCenterPlayBntVisibility(this.mOptions.optBoolean("show-center-play-btn", true));
        ijkPlayerView.setControls(this.mOptions.optBoolean(com.taobao.weex.common.Constants.Name.CONTROLS, true));
        ijkPlayerView.setDuration(this.mOptions.optInt("duration", -1) * 1000);
        if (jSONObject.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE)) {
            ijkPlayerView.setTitle(jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE));
        }
        this.mUrl = strOptString;
        this.mHeaderInfo = strOptString2;
    }

    public int getDirection() {
        org.json.JSONObject jSONObject = this.mOptions;
        if (jSONObject != null && jSONObject.has("direction")) {
            try {
                return java.lang.Integer.parseInt(this.mOptions.optString("direction"));
            } catch (java.lang.Exception unused) {
            }
        }
        return Integer.MIN_VALUE;
    }

    private void resetSeek(io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView) {
        ijkPlayerView.seekTo(this.mOptions.optInt("initial-time") * 1000);
        this.mPlayerView.clearDanma();
        ijkPlayerView.enableDanmaku(this.mOptions.optBoolean("enable-danmu", false));
        ijkPlayerView.enableDanmuBtn(this.mOptions.optBoolean("danmu-btn", false));
        if (this.isAutoPlay) {
            play();
        }
    }

    @Override // io.dcloud.common.DHInterface.IVideoPlayer
    public void play() {
        io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.start();
        }
    }

    @Override // io.dcloud.common.DHInterface.IVideoPlayer
    public void pause() {
        io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.pause();
        }
    }

    @Override // io.dcloud.common.DHInterface.IVideoPlayer
    public void resume() {
        io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.onResume();
        }
    }

    @Override // io.dcloud.common.DHInterface.IVideoPlayer
    public void stop() {
        statusChanged(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_WAITING, "");
        if (this.mPlayerView == null || android.text.TextUtils.isEmpty(this.mUrl)) {
            return;
        }
        this.mPlayerView.clearDanma();
        this.mPlayerView.switchVideoPath(this.mUrl, this.mHeaderInfo);
    }

    @Override // io.dcloud.common.DHInterface.IVideoPlayer
    public void close() {
        statusChanged(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_WAITING, "");
        io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.stop();
            this.mPlayerView.onDestroy();
            this.mPlayerView = null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IVideoPlayer
    public void seek(java.lang.String str) {
        int i = java.lang.Integer.parseInt(str);
        io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.seekTo(i * 1000);
        }
    }

    @Override // io.dcloud.common.DHInterface.IVideoPlayer
    public void sendDanmu(org.json.JSONObject jSONObject) {
        io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.sendDanmaku(jSONObject, true);
        }
    }

    @Override // io.dcloud.common.DHInterface.IVideoPlayer
    public void playbackRate(java.lang.String str) {
        io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.playbackRate(str);
        }
    }

    public boolean onBackPressed() {
        return this.mPlayerView.onBackPressed();
    }

    @Override // io.dcloud.common.DHInterface.IVideoPlayer
    public void requestFullScreen(java.lang.String str) {
        int i = java.lang.Integer.parseInt(str);
        io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.fullScreen(i);
        }
    }

    @Override // io.dcloud.common.DHInterface.IVideoPlayer
    public void exitFullScreen() {
        io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.exitFullScreen();
        }
    }

    @Override // io.dcloud.common.DHInterface.IVideoPlayer
    public void setOptions(org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mPlayerView.hiddenLoaded(true);
            initOptionsPlayerView(this.mPlayerView, jSONObject);
        }
    }

    private void setPoster(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (android.text.TextUtils.isEmpty(this.mPosterUrl) || !this.mPosterUrl.equalsIgnoreCase(str)) {
            com.bumptech.glide.Glide.with(this).load(str).into(this.mPlayerView.mPlayerThumb);
        }
        this.mPosterUrl = str;
    }

    @Override // io.dcloud.common.DHInterface.IVideoPlayer
    public void addEventListener(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.HashMap<java.lang.String, java.lang.String> map = this.mCallbacks.get(str);
        if (map == null) {
            map = new java.util.HashMap<>();
        }
        map.put(str2, str3);
        this.mCallbacks.put(str, map);
    }

    @Override // io.dcloud.common.DHInterface.IVideoPlayer
    public boolean isFullScreen() {
        io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            return ijkPlayerView.isFullscreen();
        }
        return false;
    }

    public boolean isPlaying() {
        io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            return ijkPlayerView.isPlaying();
        }
        return false;
    }

    @Override // io.dcloud.common.DHInterface.IVideoPlayer
    public void release() {
        io.dcloud.media.video.ijkplayer.media.IjkPlayerView ijkPlayerView = this.mPlayerView;
        if (ijkPlayerView != null) {
            ijkPlayerView.onDestroy();
            this.mPlayerView = null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IVideoPlayer
    public boolean isPointInRect(float f, float f2) {
        int[] iArr = this.rect;
        return iArr != null && f > ((float) iArr[0]) && f < ((float) iArr[2]) && f2 > ((float) iArr[1]) && f2 < ((float) iArr[3]);
    }

    public void setRect(int[] iArr) {
        this.rect = iArr;
    }

    public void statusChanged(java.lang.String str, java.lang.String str2) {
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview;
        if (this.mCallbacks.containsKey(str)) {
            java.util.HashMap<java.lang.String, java.lang.String> map = this.mCallbacks.get(str);
            for (java.lang.String str3 : map.keySet()) {
                if (io.dcloud.common.util.PdrUtil.isEmpty(map.get(str3))) {
                    iWebviewFindWebview = this.mIWebview;
                } else {
                    iWebviewFindWebview = io.dcloud.media.video.VideoPlayerMgr.getInstance().findWebview(this.mIWebview, map.get(str3));
                }
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebviewFindWebview, str3, str2, io.dcloud.common.util.JSUtil.OK, !android.text.TextUtils.isEmpty(str2), true);
            }
        }
    }
}
