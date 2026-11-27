package io.dcloud.feature.audio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
class AudioPlayer extends io.dcloud.feature.audio.AbsAudio implements io.dcloud.common.DHInterface.ISysEventListener, io.dcloud.common.DHInterface.IEventCallback {
    private io.dcloud.common.DHInterface.IApp _app;
    private android.media.AudioManager mAudioMgr;
    java.lang.String mFunId;
    private io.dcloud.common.DHInterface.IWebview mWebview;
    private org.json.JSONObject params;
    private int bufferPercent = 0;
    private int startTime = Integer.MIN_VALUE;
    private java.lang.String mSrcPath = "";
    private float volume = 1.0f;
    private boolean autoplay = false;
    private boolean isCanMix = false;
    private boolean needPause = false;
    private android.media.AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = new android.media.AudioManager.OnAudioFocusChangeListener() { // from class: io.dcloud.feature.audio.AudioPlayer.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if ((i == -1 || i == -2 || i == -3) && !io.dcloud.feature.audio.AudioPlayer.this.needPause) {
                io.dcloud.feature.audio.AudioPlayer.this.pause();
            }
        }
    };
    private boolean isPrepared = false;
    private boolean isPlay = false;
    private boolean isCanplay = false;
    private boolean isStoped = false;
    private android.media.MediaPlayer mMediaPlayer = new android.media.MediaPlayer();
    private java.util.Map<java.lang.String, java.lang.String> events = new java.util.HashMap();

    private AudioPlayer(org.json.JSONObject jSONObject, io.dcloud.common.DHInterface.IWebview iWebview) {
        this.params = jSONObject;
        this.mWebview = iWebview;
        addListener();
        this._app = iWebview.obtainFrameView().obtainApp();
        iWebview.obtainFrameView().addFrameViewListener(this);
        this._app.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onStop);
        setStyle(this.params);
    }

    private void addListener() {
        this.mMediaPlayer.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() { // from class: io.dcloud.feature.audio.AudioPlayer.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(android.media.MediaPlayer mediaPlayer) {
                io.dcloud.feature.audio.AudioPlayer.this.execEvents("canplay", "");
            }
        });
        this.mMediaPlayer.setOnSeekCompleteListener(new android.media.MediaPlayer.OnSeekCompleteListener() { // from class: io.dcloud.feature.audio.AudioPlayer.3
            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(android.media.MediaPlayer mediaPlayer) {
                io.dcloud.feature.audio.AudioPlayer.this.execEvents("seeked", "");
            }
        });
        this.mMediaPlayer.setOnBufferingUpdateListener(new android.media.MediaPlayer.OnBufferingUpdateListener() { // from class: io.dcloud.feature.audio.AudioPlayer.4
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(android.media.MediaPlayer mediaPlayer, int i) {
                io.dcloud.feature.audio.AudioPlayer.this.bufferPercent = i;
            }
        });
        this.mMediaPlayer.setOnInfoListener(new android.media.MediaPlayer.OnInfoListener() { // from class: io.dcloud.feature.audio.AudioPlayer.5
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(android.media.MediaPlayer mediaPlayer, int i, int i2) {
                if (i == 701) {
                    io.dcloud.feature.audio.AudioPlayer.this.execEvents(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_WAITING, "");
                    return false;
                }
                if (i != 702 || !mediaPlayer.isPlaying()) {
                    return false;
                }
                io.dcloud.feature.audio.AudioPlayer.this.execEvents(com.taobao.weex.common.Constants.Value.PLAY, "");
                return false;
            }
        });
        this.mMediaPlayer.setOnErrorListener(new android.media.MediaPlayer.OnErrorListener() { // from class: io.dcloud.feature.audio.AudioPlayer.6
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(android.media.MediaPlayer mediaPlayer, int i, int i2) {
                java.lang.String string;
                int i3;
                if (i == 1) {
                    string = io.dcloud.common.constant.DOMException.MSG_UNKNOWN_ERROR;
                    i3 = -99;
                } else if (i != 100) {
                    i3 = 0;
                    string = null;
                } else {
                    string = io.dcloud.feature.audio.AudioPlayer.this.mWebview.getContext().getString(io.dcloud.base.R.string.dcloud_audio_abnormal_rebuild);
                    i3 = 1303;
                }
                if (i2 == -1010) {
                    string = io.dcloud.common.constant.DOMException.MSG_NOT_SUPPORT;
                    i3 = -3;
                } else if (i2 == -1007) {
                    string = io.dcloud.common.constant.DOMException.MSG_AUDIO_ERROR_MALFORMED;
                    i3 = io.dcloud.common.constant.DOMException.CODE_AUDIO_ERROR_MALFORMED;
                } else if (i2 == -1004) {
                    i3 = -5;
                    string = io.dcloud.common.constant.DOMException.MSG_IO_ERROR;
                } else if (i2 == -110) {
                    string = io.dcloud.common.constant.DOMException.MSG_AUDIO_ERROR_TIMED_OUT;
                    i3 = io.dcloud.common.constant.DOMException.CODE_AUDIO_ERROR_TIMED_OUT;
                }
                if (i3 != 0) {
                    io.dcloud.feature.audio.AudioPlayer.this.failCallback(i3, string);
                    io.dcloud.feature.audio.AudioPlayer.this.execEvents("error", io.dcloud.common.constant.DOMException.toJSON(i3, string));
                }
                return true;
            }
        });
        this.mMediaPlayer.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() { // from class: io.dcloud.feature.audio.AudioPlayer.7
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(android.media.MediaPlayer mediaPlayer) {
                io.dcloud.feature.audio.AudioPlayer.this.execEvents("ended", "");
            }
        });
    }

    static io.dcloud.feature.audio.AudioPlayer createAudioPlayer(org.json.JSONObject jSONObject, io.dcloud.common.DHInterface.IWebview iWebview) {
        return new io.dcloud.feature.audio.AudioPlayer(jSONObject, iWebview);
    }

    private void requestAudioFocus() {
        if (this.mAudioMgr == null) {
            this.mAudioMgr = (android.media.AudioManager) this.mWebview.getActivity().getSystemService("audio");
        }
        android.media.AudioManager audioManager = this.mAudioMgr;
        if (audioManager != null) {
            audioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 1);
        }
    }

    private void setSpeed() {
        android.media.MediaPlayer mediaPlayer;
        org.json.JSONObject jSONObject = this.params;
        if (jSONObject == null) {
            return;
        }
        try {
            float f = java.lang.Float.parseFloat(jSONObject.optString("playbackRate"));
            if (f <= 0.0f || (mediaPlayer = this.mMediaPlayer) == null || android.os.Build.VERSION.SDK_INT < 23) {
                return;
            }
            android.media.PlaybackParams playbackParams = mediaPlayer.getPlaybackParams();
            playbackParams.setSpeed(f);
            this.mMediaPlayer.setPlaybackParams(playbackParams);
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x006a  */
    private void setSrc(java.lang.String str) {
        java.lang.String strDecode;
        boolean z;
        android.net.Uri fileUri;
        try {
            if (str.startsWith("content://")) {
                this.mMediaPlayer.setDataSource(this.mWebview.getActivity(), android.net.Uri.parse(str));
            } else {
                if (io.dcloud.common.util.PdrUtil.isNetPath(str)) {
                    strDecode = java.net.URLDecoder.decode(str, "utf-8");
                    z = false;
                } else {
                    strDecode = this._app.convert2AbsFullPath(this.mWebview.obtainFullUrl(), this._app.checkPrivateDirAndCopy2Temp(str));
                    android.content.Context context = io.dcloud.application.DCLoudApplicationImpl.self().getContext();
                    if (!io.dcloud.common.util.FileUtil.needMediaStoreOpenFile(context) || io.dcloud.common.util.FileUtil.checkPrivatePath(context, strDecode)) {
                        z = false;
                    } else {
                        java.io.File file = new java.io.File(strDecode);
                        if (!file.exists() || (fileUri = io.dcloud.common.util.FileUtil.getFileUri(context, file, android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI)) == null) {
                            z = false;
                        } else {
                            this.mMediaPlayer.setDataSource(this.mWebview.getActivity(), fileUri);
                            z = true;
                        }
                    }
                    if (!z) {
                        if (strDecode.startsWith("/android_asset/")) {
                            strDecode = strDecode.replace("/android_asset/", "");
                        } else if (strDecode.startsWith("android_asset/")) {
                            strDecode = strDecode.replace("android_asset/", "");
                        }
                        if (!io.dcloud.common.util.PdrUtil.isDeviceRootDir(strDecode)) {
                            android.content.res.AssetFileDescriptor assetFileDescriptorOpenFd = this.mWebview.getActivity().getAssets().openFd(strDecode);
                            this.mMediaPlayer.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                            this.isCanplay = false;
                            this.mMediaPlayer.prepareAsync();
                            return;
                        }
                    }
                }
                if (!z) {
                    this.mMediaPlayer.reset();
                    this.mMediaPlayer.setDataSource(strDecode);
                }
            }
            this.isCanplay = false;
            this.mMediaPlayer.prepareAsync();
        } catch (java.lang.Exception e) {
            stop();
            failCallback(-5, e.getMessage());
            execEvents("error", io.dcloud.common.constant.DOMException.toJSON(-5, e.getMessage()));
        }
    }

    private void startPlay() {
        requestAudioFocus();
        this.isPrepared = true;
        this.mMediaPlayer.start();
        setSpeed();
        execEvents(com.taobao.weex.common.Constants.Value.PLAY, "");
        this.isPlay = false;
    }

    private void successCallback() {
        io.dcloud.common.util.Deprecated_JSUtil.excCallbackSuccess(this.mWebview, this.mFunId, "");
    }

    void addEventListener(java.lang.String str, java.lang.String str2) {
        this.events.put(str, str2);
    }

    void destory() {
        android.media.MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mWebview.obtainFrameView().removeFrameViewListener(this);
            this.mWebview.obtainFrameView().obtainApp().unregisterSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onStop);
            this.mMediaPlayer = null;
            android.media.AudioManager audioManager = this.mAudioMgr;
            if (audioManager != null) {
                audioManager.abandonAudioFocus(this.mAudioFocusChangeListener);
            }
            this.mAudioMgr = null;
        }
    }

    void execEvents(java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = this.events.get(str);
        if (!io.dcloud.common.util.PdrUtil.isEmpty(str3)) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.mWebview, str3, str2, io.dcloud.common.util.JSUtil.OK, !io.dcloud.common.util.PdrUtil.isEmpty(str2), true);
        }
        str.getClass();
        if (str.equals("ended")) {
            pause();
            successCallback();
            return;
        }
        if (str.equals("canplay")) {
            this.isCanplay = true;
            if (this.autoplay) {
                play();
            }
            if (this.isPlay) {
                startPlay();
            }
            int i = this.startTime;
            if (i != Integer.MIN_VALUE) {
                this.mMediaPlayer.seekTo(i);
            }
        }
    }

    void failCallback(int i, java.lang.String str) {
        io.dcloud.common.util.Deprecated_JSUtil.excCallbackError(this.mWebview, this.mFunId, io.dcloud.common.constant.DOMException.toJSON(i, str), true);
    }

    java.lang.String getBuffer() {
        android.media.MediaPlayer mediaPlayer = this.mMediaPlayer;
        return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(io.dcloud.common.util.PdrUtil.int2DecimalStr(mediaPlayer != null ? (this.bufferPercent * mediaPlayer.getDuration()) / 100 : -1, 1000), false);
    }

    java.lang.String getDuration() {
        int duration;
        android.media.MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && (duration = mediaPlayer.getDuration()) >= 0) {
            return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(io.dcloud.common.util.PdrUtil.int2DecimalStr(duration, 1000), false);
        }
        return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(com.taobao.weex.common.Constants.Name.UNDEFINED, false);
    }

    java.lang.String getPosition() {
        return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(io.dcloud.common.util.PdrUtil.int2DecimalStr(this.mMediaPlayer.getCurrentPosition(), 1000), false);
    }

    java.lang.String getStyles(java.lang.String str) {
        int iOptInt;
        java.lang.Object objValueOf;
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            return io.dcloud.common.util.JSUtil.wrapJsVar(this.params);
        }
        str.getClass();
        str.hashCode();
        switch (str) {
            case "startTime":
                int i = this.startTime;
                if (i < 0) {
                    iOptInt = this.params.has("startTime") ? this.params.optInt("startTime") : 0;
                } else {
                    iOptInt = i / 1000;
                }
                objValueOf = java.lang.Integer.valueOf(iOptInt);
                break;
            case "volume":
                objValueOf = java.lang.Float.valueOf(this.volume);
                break;
            case "src":
                objValueOf = this.mSrcPath;
                break;
            case "loop":
                objValueOf = java.lang.Boolean.valueOf(this.mMediaPlayer.isLooping());
                break;
            case "playbackRate":
                if (android.os.Build.VERSION.SDK_INT < 23) {
                    objValueOf = 1;
                    break;
                } else {
                    objValueOf = java.lang.Float.valueOf(this.mMediaPlayer.getPlaybackParams().getSpeed());
                    break;
                }
                break;
            case "autoplay":
                objValueOf = java.lang.Boolean.valueOf(this.params.optBoolean(com.taobao.weex.common.Constants.Name.AUTOPLAY, false));
                break;
            default:
                return this.params.has(str) ? io.dcloud.common.util.JSUtil.wrapJsVar(this.params.optString(str)) : io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(com.taobao.weex.common.Constants.Name.UNDEFINED, false);
        }
        return objValueOf != null ? io.dcloud.common.util.JSUtil.wrapJsVar(objValueOf.toString()) : io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(com.taobao.weex.common.Constants.Name.UNDEFINED, false);
    }

    java.lang.String getVolume() {
        return io.dcloud.common.util.JSUtil.wrapJsVar(this.volume);
    }

    public boolean isCanMix() {
        return this.isCanMix;
    }

    java.lang.String isPause() {
        android.media.MediaPlayer mediaPlayer = this.mMediaPlayer;
        return io.dcloud.common.util.JSUtil.wrapJsVar(mediaPlayer != null ? true ^ mediaPlayer.isPlaying() : true);
    }

    @Override // io.dcloud.common.DHInterface.IEventCallback
    public java.lang.Object onCallBack(java.lang.String str, java.lang.Object obj) {
        if ((!io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_WINDOW_CLOSE) && !io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE)) || !(obj instanceof io.dcloud.common.DHInterface.IWebview)) {
            return null;
        }
        destory();
        return null;
    }

    @Override // io.dcloud.common.DHInterface.ISysEventListener
    public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
        if (sysEventType != io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onStop) {
            return false;
        }
        destory();
        return false;
    }

    void pause() {
        this.autoplay = false;
        try {
            this.mMediaPlayer.pause();
        } catch (java.lang.Exception unused) {
        }
        execEvents("pause", "");
    }

    void play() {
        if (this.isStoped && !this.mMediaPlayer.isPlaying()) {
            try {
                this.mMediaPlayer.prepareAsync();
                this.isStoped = false;
            } catch (java.lang.Exception unused) {
                this.mSrcPath = "";
                setStyle(this.params);
                this.isStoped = false;
            }
        }
        try {
            this.isPrepared = false;
            this.isPlay = true;
            if (this.isCanplay) {
                startPlay();
            }
        } catch (java.lang.IllegalStateException e) {
            e.printStackTrace();
            destory();
            failCallback(-1, e.toString());
            execEvents("error", io.dcloud.common.constant.DOMException.toJSON(-1, e.getMessage()));
        } catch (java.lang.NumberFormatException unused2) {
        }
    }

    public void playbackRate(float f) {
        if (this.params == null) {
            this.params = new org.json.JSONObject();
        }
        try {
            this.params.put("playbackRate", f);
        } catch (org.json.JSONException unused) {
        }
        android.media.MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        setSpeed();
    }

    void removeEventListener(java.lang.String str) {
        this.events.remove(str);
    }

    void resume() {
        requestAudioFocus();
        this.mMediaPlayer.start();
        setSpeed();
    }

    void seekTo(int i) {
        this.mMediaPlayer.seekTo(i);
        execEvents("seeking", "");
    }

    public void setCanMix(boolean z) {
        this.needPause = z;
    }

    public void setParams(org.json.JSONObject jSONObject) {
        this.params = jSONObject;
    }

    void setSessionCategory(java.lang.String str) {
        android.media.MediaPlayer mediaPlayer;
        if (io.dcloud.common.util.PdrUtil.isEmpty(str) || (mediaPlayer = this.mMediaPlayer) == null || mediaPlayer.isPlaying()) {
            return;
        }
        this.isCanMix = str.equals("ambient");
    }

    void setStyle(org.json.JSONObject jSONObject) {
        java.lang.String strOptString = jSONObject.optString("src");
        if (!io.dcloud.common.util.PdrUtil.isEmpty(strOptString) && (io.dcloud.common.util.PdrUtil.isEmpty(this.mSrcPath) || !strOptString.equals(this.mSrcPath))) {
            this.mMediaPlayer.reset();
            setSrc(strOptString);
        }
        io.dcloud.common.util.JSONUtil.combinJSONObject(this.params, jSONObject);
        this.mSrcPath = jSONObject.optString("src");
        this.mMediaPlayer.setLooping(this.params.optBoolean("loop"));
        try {
            float f = java.lang.Float.parseFloat(this.params.optString("volume", "1"));
            this.volume = f;
            if (f < 0.0f) {
                this.volume = 0.0f;
            } else if (f > 1.0f) {
                this.volume = 1.0f;
            }
            android.media.MediaPlayer mediaPlayer = this.mMediaPlayer;
            float f2 = this.volume;
            mediaPlayer.setVolume(f2, f2);
            if (this.params.has("startTime")) {
                this.startTime = this.params.optInt("startTime") * 1000;
            }
            this.autoplay = this.params.optBoolean(com.taobao.weex.common.Constants.Name.AUTOPLAY, false);
        } catch (java.lang.Exception unused) {
        }
        try {
            float f3 = java.lang.Float.parseFloat(this.params.optString("playbackRate"));
            if (f3 > 0.0f) {
                playbackRate(f3);
            }
        } catch (java.lang.Exception unused2) {
        }
    }

    void stop() {
        android.media.MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.isStoped = true;
            this.isCanplay = false;
            execEvents(com.taobao.weex.common.Constants.Value.STOP, "");
        }
    }
}
