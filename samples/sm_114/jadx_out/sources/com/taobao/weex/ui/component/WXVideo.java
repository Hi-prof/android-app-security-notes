package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXVideo extends com.taobao.weex.ui.component.WXComponent<android.widget.FrameLayout> {
    private boolean mAutoPlay;
    private boolean mError;
    boolean mPrepared;
    private boolean mStopped;
    private com.taobao.weex.ui.view.WXVideoView.Wrapper mWrapper;

    @java.lang.Deprecated
    public WXVideo(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    public WXVideo(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public android.widget.FrameLayout initComponentHostView(android.content.Context context) {
        final com.taobao.weex.ui.view.WXVideoView.Wrapper wrapper = new com.taobao.weex.ui.view.WXVideoView.Wrapper(context);
        wrapper.setOnErrorListener(new android.media.MediaPlayer.OnErrorListener() { // from class: com.taobao.weex.ui.component.WXVideo.1
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(android.media.MediaPlayer mediaPlayer, int i, int i2) {
                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    com.taobao.weex.utils.WXLogUtils.d("Video", "onError:" + i);
                }
                wrapper.getProgressBar().setVisibility(8);
                com.taobao.weex.ui.component.WXVideo.this.mPrepared = false;
                com.taobao.weex.ui.component.WXVideo.this.mError = true;
                if (com.taobao.weex.ui.component.WXVideo.this.getEvents().contains(com.taobao.weex.common.Constants.Event.FAIL)) {
                    com.taobao.weex.ui.component.WXVideo.this.notify(com.taobao.weex.common.Constants.Event.FAIL, com.taobao.weex.common.Constants.Value.STOP);
                }
                return true;
            }
        });
        wrapper.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() { // from class: com.taobao.weex.ui.component.WXVideo.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(android.media.MediaPlayer mediaPlayer) {
                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    com.taobao.weex.utils.WXLogUtils.d("Video", "onPrepared");
                }
                wrapper.getProgressBar().setVisibility(8);
                com.taobao.weex.ui.component.WXVideo.this.mPrepared = true;
                if (com.taobao.weex.ui.component.WXVideo.this.mAutoPlay) {
                    wrapper.start();
                }
                wrapper.getVideoView().seekTo(5);
                if (wrapper.getMediaController() != null) {
                    if (!com.taobao.weex.ui.component.WXVideo.this.mStopped) {
                        wrapper.getMediaController().show(3);
                    } else {
                        wrapper.getMediaController().hide();
                    }
                }
                com.taobao.weex.ui.component.WXVideo.this.mStopped = false;
            }
        });
        wrapper.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() { // from class: com.taobao.weex.ui.component.WXVideo.3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(android.media.MediaPlayer mediaPlayer) {
                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    com.taobao.weex.utils.WXLogUtils.d("Video", "onCompletion");
                }
                if (com.taobao.weex.ui.component.WXVideo.this.getEvents().contains(com.taobao.weex.common.Constants.Event.FINISH)) {
                    com.taobao.weex.ui.component.WXVideo.this.notify(com.taobao.weex.common.Constants.Event.FINISH, com.taobao.weex.common.Constants.Value.STOP);
                }
            }
        });
        wrapper.setOnVideoPauseListener(new com.taobao.weex.ui.view.WXVideoView.VideoPlayListener() { // from class: com.taobao.weex.ui.component.WXVideo.4
            @Override // com.taobao.weex.ui.view.WXVideoView.VideoPlayListener
            public void onPause() {
                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    com.taobao.weex.utils.WXLogUtils.d("Video", "onPause");
                }
                if (com.taobao.weex.ui.component.WXVideo.this.getEvents().contains("pause")) {
                    com.taobao.weex.ui.component.WXVideo.this.notify("pause", "pause");
                }
            }

            @Override // com.taobao.weex.ui.view.WXVideoView.VideoPlayListener
            public void onStart() {
                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    com.taobao.weex.utils.WXLogUtils.d("Video", "onStart");
                }
                if (com.taobao.weex.ui.component.WXVideo.this.getEvents().contains("start")) {
                    com.taobao.weex.ui.component.WXVideo.this.notify("start", com.taobao.weex.common.Constants.Value.PLAY);
                }
            }
        });
        this.mWrapper = wrapper;
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notify(java.lang.String str, java.lang.String str2) {
        java.util.HashMap map = new java.util.HashMap(2);
        map.put(com.taobao.weex.common.Constants.Name.PLAY_STATUS, str2);
        map.put("timeStamp", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        java.util.HashMap map2 = new java.util.HashMap();
        java.util.HashMap map3 = new java.util.HashMap();
        map3.put(com.taobao.weex.common.Constants.Name.PLAY_STATUS, str2);
        map2.put(com.taobao.weex.ui.component.list.template.TemplateDom.KEY_ATTRS, map3);
        com.taobao.weex.WXSDKManager.getInstance().fireEvent(getInstanceId(), getRef(), str, map, map2);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void bindData(com.taobao.weex.ui.component.WXComponent wXComponent) {
        super.bindData(wXComponent);
        addEvent(com.taobao.weex.common.Constants.Event.APPEAR);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void notifyAppearStateChange(java.lang.String str, java.lang.String str2) {
        super.notifyAppearStateChange(str, str2);
        this.mWrapper.createVideoViewIfVisible();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        switch (str) {
            case "zOrderTop":
                java.lang.Boolean bool = com.taobao.weex.utils.WXUtils.getBoolean(obj, null);
                if (bool != null) {
                    this.mWrapper.getVideoView().setZOrderOnTop(bool.booleanValue());
                }
                return true;
            case "src":
                java.lang.String string = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string != null) {
                    setSrc(string);
                }
                return true;
            case "autoPlay":
            case "autoplay":
                java.lang.Boolean bool2 = com.taobao.weex.utils.WXUtils.getBoolean(obj, null);
                if (bool2 != null) {
                    setAutoPlay(bool2.booleanValue());
                }
                return true;
            case "playStatus":
                java.lang.String string2 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string2 != null) {
                    setPlaystatus(string2);
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "src")
    public void setSrc(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || getHostView() == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.mWrapper.setVideoURI(getInstance().rewriteUri(android.net.Uri.parse(str), "video"));
        this.mWrapper.getProgressBar().setVisibility(0);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.AUTO_PLAY)
    public void setAutoPlay(boolean z) {
        this.mAutoPlay = z;
        if (z) {
            this.mWrapper.createIfNotExist();
            this.mWrapper.start();
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.CONTROLS)
    public void setControls(java.lang.String str) {
        if (android.text.TextUtils.equals(com.taobao.weex.common.Constants.Name.CONTROLS, str)) {
            this.mWrapper.setControls(true);
        } else if (android.text.TextUtils.equals("nocontrols", str)) {
            this.mWrapper.setControls(false);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.PLAY_STATUS)
    public void setPlaystatus(java.lang.String str) {
        if (this.mPrepared && !this.mError && !this.mStopped) {
            if (str.equals(com.taobao.weex.common.Constants.Value.PLAY)) {
                this.mWrapper.start();
                return;
            }
            if (str.equals("pause")) {
                this.mWrapper.pause();
                return;
            } else {
                if (str.equals(com.taobao.weex.common.Constants.Value.STOP)) {
                    this.mWrapper.stopPlayback();
                    this.mStopped = true;
                    return;
                }
                return;
            }
        }
        if ((this.mError || this.mStopped) && str.equals(com.taobao.weex.common.Constants.Value.PLAY)) {
            this.mError = false;
            this.mWrapper.resume();
            this.mWrapper.getProgressBar().setVisibility(0);
        }
    }
}
