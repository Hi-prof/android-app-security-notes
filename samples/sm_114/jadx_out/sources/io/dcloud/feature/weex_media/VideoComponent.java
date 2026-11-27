package io.dcloud.feature.weex_media;

/* JADX INFO: loaded from: classes2.dex */
public class VideoComponent extends com.taobao.weex.ui.component.WXVContainer<io.dcloud.feature.weex_media.VideoPlayerView> implements io.dcloud.common.DHInterface.ISysEventListener {
    private com.taobao.weex.dom.WXAttr attrs;
    private java.util.concurrent.atomic.AtomicBoolean isLoad;
    private io.dcloud.common.DHInterface.IApp mApp;
    private java.util.Map<java.lang.String, java.lang.Object> params;

    public VideoComponent(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.isLoad = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.attrs = basicComponentData.getAttrs();
        if (basicComponentData.getStyles().containsKey(com.taobao.weex.common.Constants.Name.FLEX)) {
            return;
        }
        setContentBoxMeasurement(new com.taobao.weex.layout.ContentBoxMeasurement() { // from class: io.dcloud.feature.weex_media.VideoComponent.1
            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutAfter(float f, float f2) {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutBefore() {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void measureInternal(float f, float f2, int i, int i2) {
                if (com.taobao.weex.dom.CSSConstants.isUndefined(f)) {
                    this.mMeasureWidth = com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(300.0f, io.dcloud.feature.weex_media.VideoComponent.this.getInstance().getInstanceViewPortWidthWithFloat());
                }
                if (com.taobao.weex.dom.CSSConstants.isUndefined(f2)) {
                    this.mMeasureHeight = com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(225.0f, io.dcloud.feature.weex_media.VideoComponent.this.getInstance().getInstanceViewPortWidthWithFloat());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public io.dcloud.feature.weex_media.VideoPlayerView initComponentHostView(android.content.Context context) {
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(getInstance());
        if (iWebviewFindWebview != null) {
            io.dcloud.common.DHInterface.IApp iAppObtainApp = iWebviewFindWebview.obtainApp();
            this.mApp = iAppObtainApp;
            iAppObtainApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp);
        }
        return new io.dcloud.feature.weex_media.VideoPlayerView(getContext(), this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent
    public android.view.ViewGroup getRealView() {
        if (getHostView() != 0) {
            return ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).getPlayerView();
        }
        return null;
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void addChild(com.taobao.weex.ui.component.WXComponent wXComponent, int i) {
        if (wXComponent instanceof io.dcloud.feature.weex.adapter.ScalableViewComponent) {
            ((io.dcloud.feature.weex.adapter.ScalableViewComponent) wXComponent).setScalable(true);
            super.addChild(wXComponent, i);
        }
    }

    public io.dcloud.common.DHInterface.IApp getIApp() {
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview;
        if (this.mApp == null && (iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(getInstance())) != null) {
            this.mApp = iWebviewFindWebview.obtainApp();
        }
        return this.mApp;
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void addSubView(android.view.View view, int i) {
        if (view == null || getRealView() == null || (view instanceof com.taobao.weex.ui.view.WXBaseRefreshLayout)) {
            return;
        }
        if (i >= getRealView().getChildCount()) {
            i = -1;
        }
        if (getRealView().indexOfChild(view) == -1) {
            if (i == -1) {
                getRealView().addView(view);
            } else {
                getRealView().addView(view, i);
            }
        }
        view.bringToFront();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = "src")
    public void setSrc(java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            return;
        }
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setSrc(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.ui.component.WXBasicComponentType.HEADER)
    public void setHeader(java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            return;
        }
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setHeader(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.AUTOPLAY)
    public void setAutoPlay(boolean z) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(java.lang.Boolean.valueOf(z))) {
            return;
        }
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setAutoplay(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = "initialTime")
    public void setInitTime(float f) {
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setInitialTime(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = "duration")
    public void setDuration(float f) {
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setDuration(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = "danmuList")
    public void setDanmuList(com.alibaba.fastjson.JSONArray jSONArray) {
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setDanmuList(jSONArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = "loop")
    public void setLoop(boolean z) {
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setLoop(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = "muted")
    public void setMute(boolean z) {
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setMuted(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = "direction")
    public void setDirection(int i) {
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setDirection(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = "playStrategy")
    public void setPlayStrategy(int i) {
        io.dcloud.feature.weex_media.option.EnumPlayStrategy enumPlayStrategy = io.dcloud.feature.weex_media.option.EnumPlayStrategy.DEFAULT;
        if (i == io.dcloud.feature.weex_media.option.EnumPlayStrategy.PLAY_SMOOTH.getFlagVal()) {
            enumPlayStrategy = io.dcloud.feature.weex_media.option.EnumPlayStrategy.PLAY_SMOOTH;
        } else if (i == io.dcloud.feature.weex_media.option.EnumPlayStrategy.START_QUICK.getFlagVal()) {
            enumPlayStrategy = io.dcloud.feature.weex_media.option.EnumPlayStrategy.START_QUICK;
        } else if (i == io.dcloud.feature.weex_media.option.EnumPlayStrategy.M3U8_SMOOTH.getFlagVal()) {
            enumPlayStrategy = io.dcloud.feature.weex_media.option.EnumPlayStrategy.M3U8_SMOOTH;
        } else if (i == io.dcloud.feature.weex_media.option.EnumPlayStrategy.DEFAULT.getFlagVal()) {
            enumPlayStrategy = io.dcloud.feature.weex_media.option.EnumPlayStrategy.DEFAULT;
        }
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setFlowStrategy(enumPlayStrategy);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = "objectFit")
    public void setFit(java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            return;
        }
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setObjectFit(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = "showMuteBtn")
    public void isShowMuteBtn(boolean z) {
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setMuteBtn(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = "playBtnPosition")
    public void setPlayBtnPosition(java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            return;
        }
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setPlayBtnPosition(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE)
    public void setTitle(java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            return;
        }
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setTitle(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = "httpCache")
    public void httpCache(boolean z) {
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setHttpCacheEnable(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = "codec")
    public void setCodeMode(java.lang.String str) {
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setCodec(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = "showLoading")
    public void showLoading(boolean z) {
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setShowLoading(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void updateProperties(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map.size() > 0 && getHostView() != 0) {
            this.params = combinMap(this.params, map);
            ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setProgress(!this.params.containsKey("showProgress") || java.lang.Boolean.parseBoolean(this.params.get("showProgress").toString()));
            ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setShowFullScreenBtn(!this.params.containsKey("showFullscreenBtn") || java.lang.Boolean.parseBoolean(this.params.get("showFullscreenBtn").toString()));
            ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setPlayBtnVisibility(!this.params.containsKey("showPlayBtn") || java.lang.Boolean.parseBoolean(this.params.get("showPlayBtn").toString()));
            ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setEnableProgressGesture(!this.params.containsKey("enableProgressGesture") || java.lang.Boolean.parseBoolean(this.params.get("enableProgressGesture").toString()));
            if (map.containsKey("src")) {
                ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setSrc((java.lang.String) map.get("src"));
            }
            ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setShowCenterPlayBtn(!this.params.containsKey("showCenterPlayBtn") || java.lang.Boolean.parseBoolean(this.params.get("showCenterPlayBtn").toString()));
            ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setControls(!this.params.containsKey(com.taobao.weex.common.Constants.Name.CONTROLS) || java.lang.Boolean.parseBoolean(this.params.get(com.taobao.weex.common.Constants.Name.CONTROLS).toString()));
            if (this.params.containsKey("vslideGestureInFullscreen")) {
                ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setFullScreenPageGesture(java.lang.Boolean.parseBoolean(this.params.get("vslideGestureInFullscreen").toString()));
            }
            if (this.params.containsKey("vslideGesture")) {
                ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setPageGesture(java.lang.Boolean.parseBoolean(this.params.get("vslideGesture").toString()));
            }
            if (this.params.containsKey("showScreenLockButton")) {
                ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setLockScreen(java.lang.Boolean.parseBoolean(this.params.get("showScreenLockButton").toString()));
            }
            if (this.params.containsKey("enablePlayGesture")) {
                ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setEnablePlayGesture(java.lang.Boolean.parseBoolean(this.params.get("enablePlayGesture").toString()));
            }
        }
        super.updateProperties(map);
        if (map.size() <= 0 || !map.containsKey("src")) {
            return;
        }
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).onLayoutFinished((java.lang.String) map.get("src"));
    }

    private java.util.Map<java.lang.String, java.lang.Object> combinMap(java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        if (map == null && map2 == null) {
            return new java.util.HashMap();
        }
        if (map == null) {
            return map2;
        }
        if (map2 == null) {
            return map;
        }
        map.putAll(map2);
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.ui.component.WXComponentProp(name = "poster")
    public void setPoster(java.lang.String str) {
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setPoster(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.annotation.JSMethod
    public void requestFullScreen(com.alibaba.fastjson.JSONObject jSONObject) {
        int iIntValue;
        try {
            iIntValue = jSONObject.getInteger("direction").intValue();
        } catch (java.lang.Exception unused) {
            iIntValue = -90;
        }
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).requestFullScreen(iIntValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.annotation.JSMethod
    public void play() {
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).play();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.annotation.JSMethod
    public void pause() {
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).pause();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.annotation.JSMethod
    public void stop() {
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).stop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.annotation.JSMethod
    public void seek(int i) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(java.lang.Integer.valueOf(i))) {
            return;
        }
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).seek(i * 1000);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.annotation.JSMethod
    public void sendDanmu(com.alibaba.fastjson.JSONObject jSONObject) {
        if (jSONObject != null) {
            ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).sendDanmu(jSONObject);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.annotation.JSMethod
    public void playbackRate(float f) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(java.lang.Float.valueOf(f))) {
            return;
        }
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).sendPlayBackRate(java.lang.String.valueOf(f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @com.taobao.weex.annotation.JSMethod
    public void exitFullScreen() {
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).exitFullScreen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(io.dcloud.feature.weex_media.VideoPlayerView videoPlayerView) {
        super.onHostViewInitialized(videoPlayerView);
        com.taobao.weex.dom.WXAttr wXAttr = this.attrs;
        if (wXAttr == null || wXAttr.size() <= 0) {
            return;
        }
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setEnableDanmu(this.attrs.containsKey("enableDanmu") && java.lang.Boolean.parseBoolean(this.attrs.get("enableDanmu").toString()));
        ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).setDanmuBtn(this.attrs.containsKey("danmuBtn") && java.lang.Boolean.parseBoolean(this.attrs.get("danmuBtn").toString()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityResume() {
        super.onActivityResume();
        if (getHostView() != 0) {
            ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).onActivityResume();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityPause() {
        super.onActivityPause();
        if (getHostView() != 0) {
            ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).pause();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
        if (getHostView() != 0) {
            ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).destory();
        }
        io.dcloud.common.DHInterface.IApp iApp = this.mApp;
        if (iApp != null) {
            iApp.unregisterSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.common.DHInterface.ISysEventListener
    public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
        if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp && ((java.lang.Integer) ((java.lang.Object[]) obj)[0]).intValue() == 4 && ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).isFullScreen() && getHostView() != 0) {
            return ((io.dcloud.feature.weex_media.VideoPlayerView) getHostView()).onBackPress();
        }
        return false;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void addEvent(java.lang.String str) {
        if (str.equals(com.taobao.weex.common.Constants.Event.CLICK)) {
            return;
        }
        super.addEvent(str);
    }
}
