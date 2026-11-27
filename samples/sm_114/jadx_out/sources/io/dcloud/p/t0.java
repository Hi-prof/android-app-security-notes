package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class t0 {
    private java.lang.String a;
    private int b;
    private int c;
    private int d;
    private java.util.List e;
    private int f = 0;
    private boolean g = false;
    private int h = 1;
    private final java.util.List i = new java.util.ArrayList();

    public io.dcloud.p.t0 a(org.json.JSONObject jSONObject, int i) {
        this.a = jSONObject.optString("adpid");
        this.b = jSONObject.optInt("type", -1);
        int iOptInt = jSONObject.optInt("tto", 18000);
        this.c = iOptInt;
        if (iOptInt < 1000) {
            this.c = 18000;
        }
        int iOptInt2 = jSONObject.optInt("dsto", com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
        this.d = iOptInt2;
        if (iOptInt2 < 1000) {
            this.d = com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
        }
        this.f = jSONObject.optInt("sr", 0);
        this.g = jSONObject.optInt("ord", 0) == 1;
        int iOptInt3 = jSONObject.optInt("ft", 1);
        this.h = jSONObject.optInt("mt", 1);
        java.lang.String strOptString = jSONObject.optString("vadpid", "");
        org.json.JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("cfgs");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            if (this.e == null) {
                this.e = new java.util.ArrayList();
            }
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                org.json.JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null) {
                    int iOptInt4 = jSONObjectOptJSONObject.has("sto") ? jSONObjectOptJSONObject.optInt("sto", com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT) : this.d;
                    if (iOptInt4 < 1000) {
                        iOptInt4 = com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
                    }
                    io.dcloud.p.v4 v4VarA = new io.dcloud.p.v4.b().e(jSONObjectOptJSONObject.optString("sid")).c(jSONObjectOptJSONObject.optInt("cpm", -1)).c(jSONObjectOptJSONObject.optInt("bdt", 0) == 1).f(jSONObjectOptJSONObject.optInt(androidtranscoder.format.MediaFormatExtraConstants.KEY_LEVEL, -1)).g(jSONObjectOptJSONObject.optInt(com.taobao.weex.ui.component.WXComponent.PROP_FS_MATCH_PARENT, -1)).c(jSONObjectOptJSONObject.optString(com.facebook.common.callercontext.ContextChain.TAG_PRODUCT)).i(jSONObjectOptJSONObject.optInt("ss", -1)).j(iOptInt4).k(jSONObjectOptJSONObject.optInt(com.taobao.weex.ui.component.WXComponent.PROP_FS_WRAP_CONTENT, -1)).d(iOptInt3).b(this.b).a(jSONObjectOptJSONObject.optString("mrt")).b(jSONObjectOptJSONObject.optString(io.dcloud.common.constant.AbsoluteConst.XML_PATH)).h(jSONObjectOptJSONObject.optInt("mt", -1)).a(jSONObjectOptJSONObject.optInt("end", 0) == 1).a(jSONObjectOptJSONObject.optJSONObject("params")).a(jSONObjectOptJSONObject.optInt("acpt", 0)).e(this.h).d(strOptString).b(this.b != 5).a();
                    if (!v4VarA.l().equals(io.dcloud.sdk.core.util.Const.TYPE_HW) || i != 3) {
                        this.i.add(v4VarA.l());
                        this.e.add(v4VarA);
                    }
                }
            }
        }
        return this;
    }

    public java.util.List b() {
        return this.i;
    }

    public int c() {
        return this.f;
    }

    public java.util.List d() {
        return this.e;
    }

    public int e() {
        return this.c;
    }

    public int f() {
        return this.b;
    }

    public boolean g() {
        return this.g;
    }

    public java.lang.String a() {
        return this.a;
    }
}
