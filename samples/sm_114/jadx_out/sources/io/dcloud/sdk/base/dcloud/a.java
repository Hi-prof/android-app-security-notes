package io.dcloud.sdk.base.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
abstract class a extends io.dcloud.sdk.base.dcloud.ADHandler {

    /* JADX INFO: renamed from: io.dcloud.sdk.base.dcloud.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class C0074a implements io.dcloud.p.v1 {
        final /* synthetic */ io.dcloud.sdk.base.dcloud.ADHandler.e a;
        final /* synthetic */ android.content.Context b;
        final /* synthetic */ java.lang.String c;

        C0074a(io.dcloud.sdk.base.dcloud.ADHandler.e eVar, android.content.Context context, java.lang.String str) {
            this.a = eVar;
            this.b = context;
            this.c = str;
        }

        @Override // io.dcloud.p.v1
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            org.json.JSONObject jSONObjectOptJSONObject = ((org.json.JSONObject) obj).optJSONObject("data");
            java.lang.String strOptString = jSONObjectOptJSONObject.optString("dstlink");
            java.lang.String strOptString2 = jSONObjectOptJSONObject.optString("clickid");
            java.lang.String strOptString3 = this.a.b().optString("tid");
            try {
                this.a.c().put("click_id", strOptString2);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            android.content.Context context = this.b;
            io.dcloud.sdk.base.dcloud.ADHandler.e eVar = this.a;
            io.dcloud.sdk.base.dcloud.a.b(context, eVar, strOptString, eVar.h, strOptString3, this.c, eVar.c());
            if (this.a.d()) {
                return null;
            }
            io.dcloud.p.c.a(this.b);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.sdk.base.dcloud.ADHandler.e a;
        final /* synthetic */ android.content.Context b;
        final /* synthetic */ java.lang.String c;

        b(io.dcloud.sdk.base.dcloud.ADHandler.e eVar, android.content.Context context, java.lang.String str) {
            this.a = eVar;
            this.b = context;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String strOptString = this.a.b().optString("url");
            java.lang.String strOptString2 = this.a.b().optString("tid");
            android.content.Context context = this.b;
            io.dcloud.sdk.base.dcloud.ADHandler.e eVar = this.a;
            io.dcloud.sdk.base.dcloud.a.b(context, eVar, strOptString, eVar.h, strOptString2, this.c, eVar.c());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONArray a;
        final /* synthetic */ io.dcloud.sdk.base.dcloud.ADHandler.e b;
        final /* synthetic */ android.content.Context c;

        c(org.json.JSONArray jSONArray, io.dcloud.sdk.base.dcloud.ADHandler.e eVar, android.content.Context context) {
            this.a = jSONArray;
            this.b = eVar;
            this.c = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a != null) {
                for (int i = 0; i < this.a.length(); i++) {
                    try {
                        org.json.JSONObject jSONObjectOptJSONObject = this.a.optJSONObject(i);
                        int iOptInt = jSONObjectOptJSONObject.optInt("template_type");
                        org.json.JSONObject jSONObjectC = this.b.c();
                        boolean z = jSONObjectC.has("ua") && jSONObjectC.optString("ua").equalsIgnoreCase("webview");
                        jSONObjectC.put("u-a", io.dcloud.sdk.base.dcloud.ADHandler.a("ua-webview"));
                        java.lang.String strA = io.dcloud.sdk.base.dcloud.ADHandler.a(jSONObjectOptJSONObject.optString("url"), jSONObjectC);
                        int iOptInt2 = jSONObjectOptJSONObject.optInt("http_method");
                        java.lang.String strOptString = jSONObjectOptJSONObject.optString(com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME);
                        if (iOptInt != 1) {
                            io.dcloud.sdk.base.dcloud.a.b(strA, strOptString, iOptInt2, 2, false, null, "clktrackers", z);
                        } else if (this.b.d()) {
                            io.dcloud.sdk.base.dcloud.c.a(this.c, strA);
                        } else {
                            io.dcloud.p.c.e(this.c, strA);
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements java.lang.Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ int b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ boolean e;
        final /* synthetic */ int f;
        final /* synthetic */ io.dcloud.p.v1 g;

        d(boolean z, int i, java.lang.String str, java.lang.String str2, boolean z2, int i2, io.dcloud.p.v1 v1Var) {
            this.a = z;
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = z2;
            this.f = i2;
            this.g = v1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.HashMap map;
            byte[] bArrA = null;
            if (this.a) {
                map = new java.util.HashMap();
                map.put(io.dcloud.common.DHInterface.IWebview.USER_AGENT, io.dcloud.sdk.base.dcloud.ADHandler.a("ua-webview"));
            } else {
                map = null;
            }
            int i = this.b;
            if (i == 0) {
                try {
                    bArrA = io.dcloud.p.l3.a(this.c, map, true);
                } catch (java.lang.Exception unused) {
                }
            } else if (i == 1) {
                bArrA = io.dcloud.p.l3.a(this.c, this.d, map);
            }
            if (!this.e || bArrA == null) {
                return;
            }
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(bArrA));
                if (jSONObject.optInt("ret") == 0) {
                    io.dcloud.p.v1 v1Var = this.g;
                    if (v1Var != null) {
                        v1Var.onCallBack(1, jSONObject);
                        return;
                    }
                    return;
                }
                java.lang.String strOptString = jSONObject.optString(androidx.core.app.NotificationCompat.CATEGORY_MESSAGE);
                io.dcloud.sdk.base.dcloud.a.b("handleTrackers_wanka Runnable Error url=" + this.c + ";msg=" + strOptString);
                int i2 = this.f;
                if (i2 > 0) {
                    io.dcloud.sdk.base.dcloud.a.b(this.c, strOptString, this.b, i2, this.e, this.g, null, this.a);
                }
                io.dcloud.p.l3.a(this.c, map, true);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(android.content.Context context, io.dcloud.sdk.base.dcloud.ADHandler.e eVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, org.json.JSONObject jSONObject) {
    }

    static void d(android.content.Context context, io.dcloud.sdk.base.dcloud.ADHandler.e eVar, java.lang.String str) {
        int iOptInt = eVar.b().optInt("template", 0);
        java.lang.String strOptString = eVar.b().optString("action");
        if (iOptInt == 1) {
            if (eVar.d()) {
                return;
            }
            org.json.JSONArray jSONArrayOptJSONArray = eVar.e().optJSONArray("clktrackers");
            if (io.dcloud.common.constant.AbsoluteConst.SPNAME_DOWNLOAD.equals(strOptString)) {
                a(jSONArrayOptJSONArray, eVar.c(), new io.dcloud.sdk.base.dcloud.a.C0074a(eVar, context, str), "clktrackers");
                return;
            } else {
                if ("url".equals(strOptString)) {
                    a(context, eVar, jSONArrayOptJSONArray, eVar.h, str);
                    return;
                }
                return;
            }
        }
        org.json.JSONArray jSONArrayOptJSONArray2 = eVar.e().optJSONArray("clktrackers");
        if (jSONArrayOptJSONArray2 != null) {
            a(jSONArrayOptJSONArray2, eVar.c(), "clktrackers");
        }
        if (!io.dcloud.common.constant.AbsoluteConst.SPNAME_DOWNLOAD.equals(strOptString)) {
            io.dcloud.sdk.base.dcloud.ADHandler.b(context, eVar, str);
            return;
        }
        java.lang.String strOptString2 = eVar.b().optString(io.dcloud.feature.uniapp.adapter.AbsURIAdapter.BUNDLE);
        if (android.text.TextUtils.isEmpty(strOptString2) || !io.dcloud.p.c.a(context, strOptString2)) {
            io.dcloud.p.x4.a().a(new io.dcloud.sdk.base.dcloud.a.b(eVar, context, str));
            if (eVar.d()) {
                return;
            }
            io.dcloud.p.c.a(context);
            return;
        }
        if (eVar.d()) {
            return;
        }
        try {
            android.content.Intent uri = android.content.Intent.parseUri(eVar.b().optString("dplk"), 1);
            uri.setFlags(268435456);
            uri.setSelector(null);
            uri.setComponent(null);
            uri.addCategory("android.intent.category.BROWSABLE");
            if (context.getPackageManager().resolveActivity(uri, 65536) != null) {
                context.startActivity(uri);
            }
        } catch (java.net.URISyntaxException e) {
            e.printStackTrace();
        }
    }

    static void e(android.content.Context context, io.dcloud.sdk.base.dcloud.ADHandler.e eVar, java.lang.String str) {
        org.json.JSONArray jSONArrayOptJSONArray = eVar.e().optJSONArray("dplktrackers");
        if (jSONArrayOptJSONArray != null) {
            a(jSONArrayOptJSONArray, eVar.c(), "dplktrackers");
        }
    }

    static void f(android.content.Context context, io.dcloud.sdk.base.dcloud.ADHandler.e eVar, java.lang.String str) {
        org.json.JSONObject jSONObjectE = eVar.e();
        if (jSONObjectE != null) {
            a(jSONObjectE.optJSONArray("imptrackers"), eVar.c(), "imptrackers");
        }
    }

    static void b(java.lang.String str) {
        io.dcloud.sdk.base.dcloud.ADHandler.a("wanka", str);
    }

    private static void a(android.content.Context context, io.dcloud.sdk.base.dcloud.ADHandler.e eVar, org.json.JSONArray jSONArray, java.lang.String str, java.lang.String str2) {
        io.dcloud.p.x4.a().a(new io.dcloud.sdk.base.dcloud.a.c(jSONArray, eVar, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(java.lang.String str, java.lang.String str2, int i, int i2, boolean z, io.dcloud.p.v1 v1Var, java.lang.String str3, boolean z2) {
        int i3 = i2 - 1;
        b("handleTrackers_wanka template = " + (z ? 1 : 0) + "; t_count=" + i3 + "; tagMsg " + str3 + ";  url=" + str);
        io.dcloud.p.x4.a().a(new io.dcloud.sdk.base.dcloud.a.d(z2, i, str, str2, z, i3, v1Var));
    }

    private static void a(org.json.JSONArray jSONArray, org.json.JSONObject jSONObject, java.lang.String str) {
        a(jSONArray, jSONObject, (io.dcloud.p.v1) null, str);
    }

    private static void a(org.json.JSONArray jSONArray, org.json.JSONObject jSONObject, io.dcloud.p.v1 v1Var, java.lang.String str) {
        for (int i = 0; i < jSONArray.length(); i++) {
            org.json.JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            int iOptInt = jSONObjectOptJSONObject.optInt("template_type");
            boolean z = jSONObject.has("ua") && jSONObject.optString("ua").equalsIgnoreCase("webview");
            try {
                jSONObject.put("u-a", io.dcloud.sdk.base.dcloud.ADHandler.a("ua-webview"));
            } catch (org.json.JSONException unused) {
            }
            b(io.dcloud.sdk.base.dcloud.ADHandler.a(jSONObjectOptJSONObject.optString("url"), jSONObject), jSONObjectOptJSONObject.optString(com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME), jSONObjectOptJSONObject.optInt("http_method"), 2, iOptInt == 1, v1Var, str, z);
        }
    }
}
