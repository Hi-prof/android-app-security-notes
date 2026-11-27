package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class w4 extends io.dcloud.p.v2 {
    java.util.concurrent.ExecutorService e;
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private java.lang.String i;
    private java.lang.String j;
    private org.json.JSONObject k;
    private java.util.HashMap l;
    private java.lang.String m;
    private java.lang.String n;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;

        a(java.lang.String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String[] strArr = new java.lang.String[1];
            byte[] bArrA = io.dcloud.p.l3.a(io.dcloud.p.w4.this.g, this.a, io.dcloud.p.w4.this.l, strArr);
            if (bArrA == null) {
                io.dcloud.p.w4 w4Var = io.dcloud.p.w4.this;
                java.lang.StringBuilder sb = new java.lang.StringBuilder("网络请求失败：");
                java.lang.String str = strArr[0];
                if (str == null) {
                    str = "data null";
                }
                sb.append(str);
                w4Var.a(60003, sb.toString());
                return;
            }
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(bArrA));
                io.dcloud.sdk.base.entry.AdData adData = new io.dcloud.sdk.base.entry.AdData();
                adData.c(io.dcloud.p.w4.this.b());
                jSONObject.put("appid", io.dcloud.p.w4.this.f);
                jSONObject.put("adpid", io.dcloud.p.w4.this.c);
                jSONObject.put("tid", io.dcloud.p.w4.this.h);
                jSONObject.put("did", io.dcloud.p.w4.this.m);
                jSONObject.put("adid", io.dcloud.p.w4.this.n);
                adData.a(jSONObject, new io.dcloud.p.w4.a.C0073a(adData), true);
            } catch (org.json.JSONException e) {
                io.dcloud.p.w4.this.a(60006, e.getMessage());
            }
        }

        /* JADX INFO: renamed from: io.dcloud.p.w4$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class C0073a implements io.dcloud.sdk.base.entry.AdData.e {
            final /* synthetic */ io.dcloud.sdk.base.entry.AdData a;

            C0073a(io.dcloud.sdk.base.entry.AdData adData) {
                this.a = adData;
            }

            @Override // io.dcloud.sdk.base.entry.AdData.e
            public void a() {
                io.dcloud.p.w4.this.d = this.a;
                io.dcloud.p.w4.this.a();
            }

            @Override // io.dcloud.sdk.base.entry.AdData.e
            public void a(int i, java.lang.String str) {
                try {
                    for (io.dcloud.sdk.base.entry.a aVar : io.dcloud.p.l4.a().b(io.dcloud.p.w4.this.b()).values()) {
                        if (!aVar.b()) {
                            io.dcloud.sdk.base.entry.AdData adData = new io.dcloud.sdk.base.entry.AdData();
                            aVar.a(io.dcloud.p.w4.this.b(), adData);
                            if (adData.n() && adData.m() && adData.c().equals(io.dcloud.p.w4.this.f) && adData.j().equals(io.dcloud.p.w4.this.h) && io.dcloud.p.w4.this.d == null) {
                                io.dcloud.p.w4.this.d = adData;
                                io.dcloud.p.w4.this.a();
                                return;
                            }
                        } else {
                            io.dcloud.p.l4.a().b(io.dcloud.p.w4.this.b(), aVar.a());
                        }
                    }
                } catch (java.lang.Exception unused) {
                }
                io.dcloud.p.w4.this.a(i, str);
            }
        }
    }

    public w4(io.dcloud.p.v2.c cVar, android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this(cVar, context, str2);
        this.i = str3;
        this.j = str4;
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            this.m = jSONObject.optString("did");
            this.n = jSONObject.optString("adid");
            this.g = jSONObject.optString("url");
            org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(io.dcloud.common.constant.AbsoluteConst.XML_APP);
            this.k = jSONObjectOptJSONObject;
            this.f = jSONObjectOptJSONObject.optString("app_id");
            this.h = jSONObject.optString("tid");
            org.json.JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(com.taobao.weex.ui.component.WXBasicComponentType.HEADER);
            if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject2.length() <= 0) {
                return;
            }
            this.l = new java.util.HashMap();
            java.util.Iterator<java.lang.String> itKeys = jSONObjectOptJSONObject2.keys();
            while (itKeys.hasNext()) {
                java.lang.String next = itKeys.next();
                this.l.put(next, jSONObjectOptJSONObject2.optString(next));
            }
        } catch (org.json.JSONException unused) {
        }
    }

    public void c() {
        if (android.text.TextUtils.isEmpty(this.g)) {
            a(60001, "广告请求地址出错");
            return;
        }
        org.json.JSONObject jSONObject = this.k;
        if (jSONObject != null && jSONObject.length() > 0) {
            if (!android.text.TextUtils.isEmpty(this.c)) {
                try {
                    this.k.put("adp_id", this.c);
                } catch (org.json.JSONException unused) {
                }
            }
            org.json.JSONObject jSONObjectA = io.dcloud.p.n4.a(b());
            try {
                jSONObjectA.put(io.dcloud.common.constant.AbsoluteConst.XML_APP, this.k);
            } catch (org.json.JSONException unused2) {
            }
            java.lang.String string = jSONObjectA.toString();
            if ("1".equals(this.i)) {
                try {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject(this.j);
                    jSONObject2.optString("method");
                    java.lang.String strEncodeToString = android.util.Base64.encodeToString(io.dcloud.p.d.b(io.dcloud.p.g5.a(string), jSONObject2.optString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY), jSONObject2.optString("iv")), 2);
                    try {
                        strEncodeToString = java.net.URLEncoder.encode(strEncodeToString, "utf-8");
                    } catch (java.io.UnsupportedEncodingException unused3) {
                    }
                    string = "edata=" + strEncodeToString;
                } catch (java.lang.Exception unused4) {
                }
            } else {
                if (this.l == null) {
                    this.l = new java.util.HashMap();
                }
                if (!this.l.containsKey(io.dcloud.common.util.net.NetWork.CONTENT_TYPE)) {
                    this.l.put(io.dcloud.common.util.net.NetWork.CONTENT_TYPE, "application/json");
                }
            }
            this.e.execute(new io.dcloud.p.w4.a(string));
            return;
        }
        a(60002, "广告配置异常");
    }

    private w4(io.dcloud.p.v2.c cVar, android.content.Context context, java.lang.String str) {
        super(cVar, context, str);
        this.e = java.util.concurrent.Executors.newSingleThreadExecutor();
        this.f = "";
        this.g = "";
        this.i = "";
        this.j = "";
    }
}
