package io.dcloud.feature.nativeObj;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class NativeBitmapSaveOptions {
    public int height;
    public org.json.JSONObject mClip;
    public java.lang.String mFormat;
    private org.json.JSONObject mJson;
    public boolean mOverwrite;
    public int mQuality;
    public java.lang.String path;
    public long size;
    public int width;

    public NativeBitmapSaveOptions(java.lang.String str) {
        this.mOverwrite = false;
        this.mFormat = "jpg";
        this.mQuality = 50;
        this.mJson = null;
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            this.mJson = jSONObject;
            this.mOverwrite = jSONObject.optBoolean("overwrite", false);
            this.mFormat = this.mJson.optString("format", "jpg");
            this.mQuality = this.mJson.optInt(com.taobao.weex.common.Constants.Name.QUALITY, 50);
            this.mClip = this.mJson.optJSONObject("clip");
        } catch (org.json.JSONException unused) {
            this.mJson = new org.json.JSONObject();
        }
    }

    public java.lang.String toJsString() {
        return this.mJson.toString();
    }
}
