package io.dcloud.sdk.poly.api;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class Platform {
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;
    private org.json.JSONObject g;

    public java.lang.String getAppid() {
        return this.f;
    }

    public java.lang.String getEc() {
        return this.d;
    }

    public java.lang.String getEr() {
        return this.c;
    }

    public org.json.JSONObject getRewardJson() {
        return this.g;
    }

    public java.lang.String getSplash() {
        return this.b;
    }

    public java.lang.String getTid() {
        return this.e;
    }

    public java.lang.String getType() {
        return this.a;
    }

    public void setPlatJson(org.json.JSONObject jSONObject) {
        this.c = jSONObject.optString("er");
        this.d = jSONObject.optString("ec");
        org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("splash");
        if (jSONObjectOptJSONObject != null) {
            this.b = jSONObjectOptJSONObject.toString();
            this.e = jSONObjectOptJSONObject.optString("tid");
            org.json.JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(io.dcloud.common.constant.AbsoluteConst.XML_APP);
            if (jSONObjectOptJSONObject2 != null) {
                this.f = jSONObjectOptJSONObject2.optString("app_id");
            }
        }
        this.g = jSONObject.optJSONObject("reward");
    }

    public void setType(java.lang.String str) {
        this.a = str;
    }
}
