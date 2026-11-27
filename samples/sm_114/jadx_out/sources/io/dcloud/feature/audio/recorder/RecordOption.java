package io.dcloud.feature.audio.recorder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class RecordOption {
    public boolean isRateDeft;
    public java.lang.String mFileName;
    public java.lang.String mFormat;
    public int mSamplingRate;
    public io.dcloud.common.DHInterface.IWebview mWebview;

    public RecordOption(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONObject jSONObject) {
        this.isRateDeft = false;
        this.mWebview = iWebview;
        java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SAMPLERATE);
        java.lang.String string2 = io.dcloud.common.util.JSONUtil.getString(jSONObject, "format");
        this.mFormat = string2;
        if (io.dcloud.common.util.PdrUtil.isEmpty(string2)) {
            this.mFormat = "amr";
        }
        int i = io.dcloud.feature.audio.AudioRecorderMgr.isPause(this.mFormat) ? 44100 : 8000;
        if (io.dcloud.common.util.PdrUtil.isEmpty(string)) {
            this.isRateDeft = true;
            this.mSamplingRate = i;
        } else {
            this.isRateDeft = false;
            this.mSamplingRate = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SAMPLERATE), i);
        }
        this.mFileName = this.mWebview.obtainFrameView().obtainApp().convert2AbsFullPath(this.mWebview.obtainFullUrl(), io.dcloud.common.util.PdrUtil.getDefaultPrivateDocPath(io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_FILENAME), this.mFormat));
    }
}
