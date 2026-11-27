package io.dcloud.sdk.core.entry;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCRetryRewardEntry {
    private final java.lang.String a;
    private final java.lang.String b;
    private final java.lang.String c;
    private final java.lang.String d;
    private final int e;
    private final java.lang.String f;
    private final int g;

    public DCRetryRewardEntry(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i, java.lang.String str5, int i2) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = i;
        this.f = str5;
        this.g = i2;
    }

    public java.lang.String getAdSource() {
        return this.b;
    }

    public java.lang.String getAppIconUrl() {
        return this.c;
    }

    public java.lang.String getAppName() {
        return this.d;
    }

    public int getConvertType() {
        return this.e;
    }

    public java.lang.String getProductName() {
        return this.a;
    }

    public org.json.JSONObject toJson() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("productName", this.a);
            jSONObject.put("appIconUrl", this.c);
            jSONObject.put(com.taobao.weex.common.WXConfig.appName, this.d);
            jSONObject.put("convertType", this.e);
            jSONObject.put("adDescription", this.f);
            jSONObject.put("interactionType", this.g);
        } catch (java.lang.Exception unused) {
        }
        return jSONObject;
    }
}
