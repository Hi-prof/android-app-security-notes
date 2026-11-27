package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class n1 {
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private int f;
    private int g;
    private java.lang.String h;
    private org.json.JSONObject i;
    private int k;
    private java.lang.String m;
    private java.lang.String n;
    private java.lang.String o;
    private long a = 0;
    private boolean j = true;
    private boolean l = false;

    public io.dcloud.p.n1 a(long j) {
        this.a = j;
        return this;
    }

    public io.dcloud.p.n1 b(int i) {
        this.k = i;
        return this;
    }

    public io.dcloud.p.n1 c(java.lang.String str) {
        this.c = str;
        return this;
    }

    public io.dcloud.p.n1 d(java.lang.String str) {
        this.b = str;
        return this;
    }

    public io.dcloud.p.n1 e(java.lang.String str) {
        this.d = str;
        return this;
    }

    public io.dcloud.p.n1 f(java.lang.String str) {
        this.e = str;
        return this;
    }

    public org.json.JSONObject g() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.taobao.weex.common.Constants.Value.TIME, this.a);
            jSONObject.put("ret", this.f);
            if (this.f == 0) {
                jSONObject.put(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_MSG, this.i);
            }
            jSONObject.put("tid", this.e);
            jSONObject.put("mediaId", this.c);
            jSONObject.put("slotId", this.d);
            jSONObject.put("provider", this.b);
            jSONObject.put(androidtranscoder.format.MediaFormatExtraConstants.KEY_LEVEL, this.k);
            if (this.l) {
                jSONObject.put("use", 1);
            }
            if (!android.text.TextUtils.isEmpty(this.m)) {
                jSONObject.put("cav", this.m);
            }
            if (!android.text.TextUtils.isEmpty(this.n)) {
                jSONObject.put("csv", this.n);
            }
            java.lang.String str = this.o;
            if (str != null) {
                jSONObject.put("cpm", str);
            }
        } catch (org.json.JSONException unused) {
        }
        return jSONObject;
    }

    public java.lang.String toString() {
        return g().toString();
    }

    public io.dcloud.p.n1 a(java.lang.String str) {
        this.m = str;
        return this;
    }

    public io.dcloud.p.n1 b(java.lang.String str) {
        this.n = str;
        return this;
    }

    public io.dcloud.p.n1 c(int i) {
        this.f = i;
        return this;
    }

    public int d() {
        return this.f;
    }

    public boolean e() {
        return this.j;
    }

    public void f() {
        this.l = true;
    }

    public io.dcloud.p.n1 a(int i) {
        this.o = java.lang.String.valueOf(i);
        return this;
    }

    public org.json.JSONObject b() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.facebook.common.callercontext.ContextChain.TAG_PRODUCT, this.b);
            jSONObject.put("id", this.d);
            jSONObject.put("code", this.g);
            jSONObject.put(androidx.core.app.NotificationCompat.CATEGORY_MESSAGE, this.h);
        } catch (org.json.JSONException unused) {
        }
        return jSONObject;
    }

    public java.lang.String c() {
        return this.d;
    }

    public io.dcloud.p.n1 a(int i, java.lang.String str) {
        this.j = i != -9999;
        this.g = i;
        this.h = str;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        this.i = jSONObject;
        try {
            jSONObject.put("code", i);
            this.i.put(androidx.core.app.NotificationCompat.CATEGORY_MESSAGE, str);
        } catch (org.json.JSONException unused) {
        }
        return this;
    }

    public int a() {
        return this.g;
    }
}
