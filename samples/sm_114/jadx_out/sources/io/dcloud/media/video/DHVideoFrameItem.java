package io.dcloud.media.video;

/* JADX INFO: loaded from: classes2.dex */
public class DHVideoFrameItem extends io.dcloud.common.adapter.ui.AdaFrameItem implements io.dcloud.common.DHInterface.ISysEventListener {
    private android.view.ViewGroup.LayoutParams _vlps;
    private boolean isRegisterResize;
    private io.dcloud.common.DHInterface.IWebview mAppendWebview;
    private io.dcloud.common.DHInterface.IWebview mContenterView;
    private io.dcloud.common.DHInterface.IWebview mIWebview;
    private java.lang.String mId;
    private io.dcloud.media.video.ijkplayer.VideoPlayerView mPlayerView;
    public java.lang.String position;
    private org.json.JSONArray rect;
    private long resumeTime;
    private org.json.JSONObject styles;
    private java.lang.String userId;

    public void removeFrameItem() {
        if (this.position.equals(io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE)) {
            this.mContenterView.obtainFrameView().removeFrameItem(this);
        } else {
            this.mContenterView.removeFrameItem(this);
        }
    }

    protected DHVideoFrameItem(android.content.Context context, java.lang.String str, io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray, org.json.JSONObject jSONObject, java.lang.String str2) {
        super(context);
        this.resumeTime = 0L;
        this.mAppendWebview = null;
        this.position = "static";
        this.isRegisterResize = false;
        this.mIWebview = iWebview;
        this.mContenterView = iWebview;
        this.mId = str;
        this.userId = str2;
        this.rect = jSONArray;
        this.styles = jSONObject;
        io.dcloud.common.DHInterface.IApp iAppObtainApp = iWebview.obtainFrameView().obtainApp();
        iAppObtainApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onPause);
        iAppObtainApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onResume);
        iAppObtainApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onStop);
        iAppObtainApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp);
        io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView = new io.dcloud.media.video.ijkplayer.VideoPlayerView(this.mIWebview.getActivity(), iWebview, this.styles);
        this.mPlayerView = videoPlayerView;
        setMainView(videoPlayerView);
        initFrame(this.rect);
        this.position = this.styles.optString("position");
    }

    private void initFrame(org.json.JSONArray jSONArray) {
        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions = ((io.dcloud.common.adapter.ui.AdaFrameItem) this.mContenterView.obtainFrameView()).obtainFrameOptions();
        float scale = this.mContenterView.getScale();
        int iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONArray, 2), viewOptionsObtainFrameOptions.width, viewOptionsObtainFrameOptions.width, scale, true);
        int iConvertToScreenInt2 = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONArray, 3), viewOptionsObtainFrameOptions.height, viewOptionsObtainFrameOptions.height, scale, true);
        int iConvertToScreenInt3 = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONArray, 0), viewOptionsObtainFrameOptions.width, 0, scale, true);
        int iConvertToScreenInt4 = io.dcloud.common.util.PdrUtil.convertToScreenInt(io.dcloud.common.util.JSONUtil.getString(jSONArray, 1), viewOptionsObtainFrameOptions.height, 0, scale, true);
        updateViewRect((io.dcloud.common.adapter.ui.AdaFrameItem) this.mContenterView.obtainFrameView(), new int[]{iConvertToScreenInt3, iConvertToScreenInt4, iConvertToScreenInt, iConvertToScreenInt2}, new int[]{viewOptionsObtainFrameOptions.width, viewOptionsObtainFrameOptions.height});
        this._vlps = io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.createLayoutParams(iConvertToScreenInt3, iConvertToScreenInt4, iConvertToScreenInt, iConvertToScreenInt2);
        this.mPlayerView.setRect(new int[]{iConvertToScreenInt3, iConvertToScreenInt4, iConvertToScreenInt + iConvertToScreenInt3, iConvertToScreenInt2 + iConvertToScreenInt4});
    }

    public java.lang.String getUserId() {
        return this.userId;
    }

    public java.lang.String getmId() {
        return this.mId;
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameItem
    public void dispose() {
        super.dispose();
        release();
        io.dcloud.media.video.VideoPlayerMgr.getInstance().rmovePlayer(this.mId);
    }

    @Override // io.dcloud.common.DHInterface.ISysEventListener
    public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
        io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView;
        if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onPause) {
            if (java.lang.System.currentTimeMillis() - this.resumeTime > 100) {
                pause();
                this.resumeTime = 0L;
            }
            return true;
        }
        if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onResume) {
            if (this.resumeTime > 0) {
                resume();
            }
            this.resumeTime = java.lang.System.currentTimeMillis();
            return true;
        }
        if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onStop) {
            release();
            return true;
        }
        if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp && ((java.lang.Integer) ((java.lang.Object[]) obj)[0]).intValue() == 4 && isFullScreen() && (videoPlayerView = this.mPlayerView) != null) {
            return videoPlayerView.onBackPressed();
        }
        return false;
    }

    public void play() {
        io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView = this.mPlayerView;
        if (videoPlayerView != null) {
            videoPlayerView.play();
        }
    }

    public void pause() {
        io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView = this.mPlayerView;
        if (videoPlayerView != null) {
            videoPlayerView.pause();
        }
    }

    public void resume() {
        io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView = this.mPlayerView;
        if (videoPlayerView != null) {
            videoPlayerView.resume();
        }
    }

    public void seek(java.lang.String str) {
        io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView = this.mPlayerView;
        if (videoPlayerView != null) {
            videoPlayerView.seek(str);
        }
    }

    public void sendDanmu(org.json.JSONObject jSONObject) {
        io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView = this.mPlayerView;
        if (videoPlayerView != null) {
            videoPlayerView.sendDanmu(jSONObject);
        }
    }

    public void sendPlayBackRate(java.lang.String str) {
        io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView = this.mPlayerView;
        if (videoPlayerView != null) {
            videoPlayerView.playbackRate(str);
        }
    }

    public void playbackRate(java.lang.String str) {
        io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView = this.mPlayerView;
        if (videoPlayerView != null) {
            videoPlayerView.playbackRate(str);
        }
    }

    public void requestFullScreen(java.lang.String str) {
        io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView = this.mPlayerView;
        if (videoPlayerView != null) {
            videoPlayerView.requestFullScreen(str);
        }
    }

    public void exitFullScreen() {
        io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView = this.mPlayerView;
        if (videoPlayerView != null) {
            videoPlayerView.exitFullScreen();
        }
    }

    public void setOptions(org.json.JSONObject jSONObject) {
        if (this.mPlayerView != null) {
            this.styles = io.dcloud.common.util.JSONUtil.combinJSONObject(this.styles, jSONObject);
            if (this.mPlayerView.isFullScreen()) {
                try {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject(this.styles.toString());
                    jSONObject2.remove("top");
                    jSONObject2.remove("left");
                    jSONObject2.remove("width");
                    jSONObject2.remove("height");
                    jSONObject2.remove("position");
                    this.mPlayerView.setOptions(jSONObject2);
                    return;
                } catch (org.json.JSONException unused) {
                    return;
                }
            }
            if (jSONObject.has("top") || jSONObject.has("left") || jSONObject.has("width") || jSONObject.has("height") || jSONObject.has("position")) {
                try {
                    this.rect.put(0, io.dcloud.common.util.JSONUtil.getString(jSONObject, "left"));
                    this.rect.put(1, io.dcloud.common.util.JSONUtil.getString(jSONObject, "top"));
                    this.rect.put(2, io.dcloud.common.util.JSONUtil.getString(jSONObject, "width"));
                    this.rect.put(3, io.dcloud.common.util.JSONUtil.getString(jSONObject, "height"));
                } catch (org.json.JSONException unused2) {
                }
                java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONObject, "position");
                initFrame(this.rect);
                if (jSONObject.has("position")) {
                    if (!string.equals(this.position)) {
                        if (io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE.equals(this.position)) {
                            this.mContenterView.obtainFrameView().removeFrameItem(this);
                            this.mContenterView.addFrameItem(this, this._vlps);
                        } else if ("static".equals(this.position)) {
                            this.mContenterView.removeFrameItem(this);
                            this.mContenterView.obtainFrameView().addFrameItem(this, this._vlps);
                        }
                    } else {
                        obtainMainView().setLayoutParams(this._vlps);
                    }
                    this.position = string;
                } else {
                    obtainMainView().setLayoutParams(this._vlps);
                }
            }
            this.mPlayerView.setOptions(this.styles);
        }
    }

    public void addEventListener(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView = this.mPlayerView;
        if (videoPlayerView != null) {
            videoPlayerView.addEventListener(str, str2, str3);
        }
    }

    public void release() {
        io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView = this.mPlayerView;
        if (videoPlayerView != null) {
            videoPlayerView.release();
            this.mPlayerView = null;
        }
    }

    public boolean isFullScreen() {
        io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView = this.mPlayerView;
        if (videoPlayerView != null) {
            return videoPlayerView.isFullScreen();
        }
        return false;
    }

    public void stop() {
        io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView = this.mPlayerView;
        if (videoPlayerView != null) {
            videoPlayerView.stop();
        }
    }

    public void close() {
        io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView = this.mPlayerView;
        if (videoPlayerView != null) {
            videoPlayerView.close();
        }
    }

    public void hidden() {
        io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView = this.mPlayerView;
        if (videoPlayerView != null) {
            videoPlayerView.setVisibility(4);
        }
    }

    public void show() {
        io.dcloud.media.video.ijkplayer.VideoPlayerView videoPlayerView = this.mPlayerView;
        if (videoPlayerView != null) {
            videoPlayerView.setVisibility(0);
        }
    }

    public void appendToFrame(io.dcloud.common.DHInterface.IFrameView iFrameView) {
        android.view.View viewObtainMainView = obtainMainView();
        if (viewObtainMainView != null && viewObtainMainView.getParent() != null) {
            removeFrameItem();
        }
        this.mContenterView = iFrameView.obtainWebView();
        initFrame(this.rect);
        if (this.position.equals("static")) {
            this.mContenterView.addFrameItem(this, this._vlps);
        } else if (this.position.equals(io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_POSITION_ABSOLUTE)) {
            this.mContenterView.obtainFrameView().addFrameItem(this, this._vlps);
        } else {
            this.mContenterView.addFrameItem(this, this._vlps);
        }
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameItem
    protected void onResize() {
        if (this.isRegisterResize) {
            return;
        }
        super.onResize();
        initFrame(this.rect);
        obtainMainView().setLayoutParams(this._vlps);
    }

    public void resize(org.json.JSONArray jSONArray) {
        initFrame(jSONArray);
        obtainMainView().setLayoutParams(this._vlps);
        this.isRegisterResize = true;
    }
}
