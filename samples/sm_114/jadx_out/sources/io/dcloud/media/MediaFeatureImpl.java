package io.dcloud.media;

/* JADX INFO: loaded from: classes2.dex */
public class MediaFeatureImpl extends io.dcloud.common.DHInterface.StandardFeature implements io.dcloud.common.DHInterface.IWaiter {
    @Override // io.dcloud.common.DHInterface.StandardFeature, io.dcloud.common.DHInterface.BaseFeature, io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        super.init(absMgr, str);
        io.dcloud.media.video.VideoPlayerMgr.getInstance().initFeature(absMgr);
    }

    public void VideoPlayer(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        boolean z;
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Video-VideoPlayer");
        java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONArray, 0);
        org.json.JSONArray jSONArray2 = io.dcloud.common.util.JSONUtil.getJSONArray(jSONArray, 1);
        org.json.JSONObject jSONObject = io.dcloud.common.util.JSONUtil.getJSONObject(jSONArray, 2);
        if (jSONArray2 == null || jSONArray2.length() <= 0) {
            jSONArray2 = new org.json.JSONArray();
            try {
                jSONArray2.put(0, io.dcloud.common.util.JSONUtil.getString(jSONObject, "left"));
                jSONArray2.put(1, io.dcloud.common.util.JSONUtil.getString(jSONObject, "top"));
                jSONArray2.put(2, io.dcloud.common.util.JSONUtil.getString(jSONObject, "width"));
                jSONArray2.put(3, io.dcloud.common.util.JSONUtil.getString(jSONObject, "height"));
            } catch (org.json.JSONException unused) {
            }
            z = true;
        } else {
            z = false;
        }
        org.json.JSONArray jSONArray3 = jSONArray2;
        io.dcloud.media.video.VideoPlayerMgr.getInstance().createVideoPlayer(iWebview, string, jSONArray3, jSONObject, io.dcloud.common.util.JSONUtil.getString(jSONArray, 3), z);
    }

    public java.lang.String getVideoPlayerById(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Video-getVideoPlayerById");
        return io.dcloud.common.util.JSUtil.wrapJsVar(io.dcloud.media.video.VideoPlayerMgr.getInstance().findVideoPlayer(io.dcloud.common.util.JSONUtil.getString(jSONArray, 0)));
    }

    public void resize(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Video-resize");
        io.dcloud.media.video.VideoPlayerMgr.getInstance().resize(iWebview, io.dcloud.common.util.JSONUtil.getString(jSONArray, 0), io.dcloud.common.util.JSONUtil.getJSONArray(jSONArray, 1));
    }

    public void VideoPlayer_play(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        io.dcloud.media.video.VideoPlayerMgr.getInstance().play(io.dcloud.common.util.JSONUtil.getString(jSONArray, 0));
    }

    public void VideoPlayer_pause(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        io.dcloud.media.video.VideoPlayerMgr.getInstance().pause(io.dcloud.common.util.JSONUtil.getString(jSONArray, 0));
    }

    public void VideoPlayer_stop(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        io.dcloud.media.video.VideoPlayerMgr.getInstance().stop(io.dcloud.common.util.JSONUtil.getString(jSONArray, 0));
    }

    public void VideoPlayer_close(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        io.dcloud.media.video.VideoPlayerMgr.getInstance().close(iWebview, io.dcloud.common.util.JSONUtil.getString(jSONArray, 0));
    }

    public void VideoPlayer_sendDanmu(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        io.dcloud.media.video.VideoPlayerMgr.getInstance().sendDanmu(io.dcloud.common.util.JSONUtil.getString(jSONArray, 0), io.dcloud.common.util.JSONUtil.getJSONObject(jSONArray, 1));
    }

    public void VideoPlayer_seek(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        io.dcloud.media.video.VideoPlayerMgr.getInstance().seekTo(io.dcloud.common.util.JSONUtil.getString(jSONArray, 0), io.dcloud.common.util.JSONUtil.getString(jSONArray, 1));
    }

    public void VideoPlayer_playbackRate(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        io.dcloud.media.video.VideoPlayerMgr.getInstance().setPlayBackRate(io.dcloud.common.util.JSONUtil.getString(jSONArray, 0), io.dcloud.common.util.JSONUtil.getString(jSONArray, 1));
    }

    public void VideoPlayer_requestFullScreen(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONArray, 0);
        java.lang.String string2 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 1);
        if (io.dcloud.common.util.PdrUtil.isEmpty(string2)) {
            string2 = "-90";
        }
        io.dcloud.media.video.VideoPlayerMgr.getInstance().requestFullScreen(string, string2);
    }

    public void VideoPlayer_exitFullScreen(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        io.dcloud.media.video.VideoPlayerMgr.getInstance().exitFullScreen(io.dcloud.common.util.JSONUtil.getString(jSONArray, 0));
    }

    public void VideoPlayer_show(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        io.dcloud.media.video.VideoPlayerMgr.getInstance().show(io.dcloud.common.util.JSONUtil.getString(jSONArray, 0));
    }

    public void VideoPlayer_hide(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        io.dcloud.media.video.VideoPlayerMgr.getInstance().hidden(io.dcloud.common.util.JSONUtil.getString(jSONArray, 0));
    }

    public void VideoPlayer_setOptions(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        io.dcloud.media.video.VideoPlayerMgr.getInstance().setOptions(io.dcloud.common.util.JSONUtil.getString(jSONArray, 0), io.dcloud.common.util.JSONUtil.getJSONObject(jSONArray, 1));
    }

    public void VideoPlayer_addEventListener(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        io.dcloud.media.video.VideoPlayerMgr.getInstance().addEventListener(iWebview, io.dcloud.common.util.JSONUtil.getString(jSONArray, 0), io.dcloud.common.util.JSONUtil.getString(jSONArray, 1), io.dcloud.common.util.JSONUtil.getString(jSONArray, 2), io.dcloud.common.util.JSONUtil.getString(jSONArray, 3));
    }

    @Override // io.dcloud.common.DHInterface.BaseFeature, io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
        super.dispose(str);
        io.dcloud.media.video.VideoPlayerMgr.getInstance().recovery();
    }

    @Override // io.dcloud.common.DHInterface.IWaiter
    public java.lang.Object doForFeature(java.lang.String str, java.lang.Object obj) {
        if (!"appendToFrameView".equals(str)) {
            return null;
        }
        java.lang.Object[] objArr = (java.lang.Object[]) obj;
        return io.dcloud.media.video.VideoPlayerMgr.getInstance().appendVideoPlayer((java.lang.String) objArr[1], (io.dcloud.common.adapter.ui.AdaFrameView) objArr[0]);
    }
}
