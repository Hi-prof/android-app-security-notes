package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class b0 {
    private java.lang.String a;
    private java.lang.String b;
    private org.json.JSONObject c;
    private org.json.JSONArray d = new org.json.JSONArray();
    private io.dcloud.sdk.poly.api.Platform e;
    private java.lang.String f;
    private java.lang.String g;

    public java.lang.String a() {
        return this.a;
    }

    public java.lang.String b() {
        return this.b;
    }

    public void c(java.lang.String str) {
        this.f = str;
    }

    public java.lang.String d() {
        return this.g;
    }

    public org.json.JSONObject e() {
        if (h()) {
            return this.c;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("appid", this.a);
            jSONObject.put("appkey", this.b);
        } catch (java.lang.Exception unused) {
        }
        return jSONObject;
    }

    public org.json.JSONArray f() {
        return this.d;
    }

    public io.dcloud.sdk.poly.api.Platform g() {
        return this.e;
    }

    public boolean h() {
        return !android.text.TextUtils.isEmpty(this.g);
    }

    public void a(java.lang.String str) {
        this.a = str;
    }

    public void b(java.lang.String str) {
        this.b = str;
    }

    public java.lang.String c() {
        return this.f;
    }

    public boolean d(java.lang.String str) {
        if (str.equals(this.a)) {
            return true;
        }
        org.json.JSONArray jSONArray = this.d;
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < this.d.length(); i++) {
                if (str.equals(this.d.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void a(io.dcloud.sdk.poly.api.Platform platform) {
        this.e = platform;
    }

    public boolean a(org.json.JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return false;
        }
        this.a = jSONObject.optString("appid");
        this.d = jSONObject.optJSONArray("appidh");
        this.b = jSONObject.optString("appkey");
        this.c = jSONObject.optJSONObject("ext");
        this.g = jSONObject.optString("ada");
        try {
            if (this.c != null) {
                if (h()) {
                    this.c.put("appid", this.a);
                } else {
                    if (this.e == null) {
                        this.e = new io.dcloud.sdk.poly.api.Platform();
                    }
                    this.e.setType(this.f);
                    this.e.setPlatJson(this.c);
                    return true;
                }
            } else {
                if (!h()) {
                    return true;
                }
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                this.c = jSONObject2;
                jSONObject2.put("appid", this.a);
            }
            return true;
        } catch (org.json.JSONException unused) {
            return true;
        }
    }
}
