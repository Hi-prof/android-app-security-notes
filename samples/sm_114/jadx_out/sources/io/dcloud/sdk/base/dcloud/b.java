package io.dcloud.sdk.base.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
abstract class b extends io.dcloud.sdk.base.dcloud.ADHandler {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.util.HashMap b;

        a(java.lang.String str, java.util.HashMap map) {
            this.a = str;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                io.dcloud.p.l3.a(this.a, this.b, true);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    static void a(org.json.JSONArray jSONArray, java.lang.String str, io.dcloud.sdk.base.dcloud.ADHandler.e eVar) {
        java.util.HashMap map;
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                java.lang.String strOptString = jSONArray.optString(i);
                io.dcloud.sdk.base.dcloud.ADHandler.a("ADHandler_youdao", str + ";url=" + strOptString);
                org.json.JSONObject jSONObjectC = eVar.c();
                if (jSONObjectC != null && jSONObjectC.has("ua") && jSONObjectC.optString("ua").equalsIgnoreCase("webview")) {
                    map = new java.util.HashMap();
                    map.put(io.dcloud.common.DHInterface.IWebview.USER_AGENT, io.dcloud.sdk.base.dcloud.ADHandler.a("ua-webview"));
                } else {
                    map = null;
                }
                io.dcloud.p.x4.a().a(new io.dcloud.sdk.base.dcloud.b.a(strOptString, map));
            }
        }
    }

    static void d(android.content.Context context, io.dcloud.sdk.base.dcloud.ADHandler.e eVar, java.lang.String str) {
        org.json.JSONObject jSONObjectE = eVar.e();
        if (jSONObjectE != null) {
            a(jSONObjectE.optJSONArray("clktrackers"), "clktrackers", eVar);
        }
        io.dcloud.sdk.base.dcloud.ADHandler.b(context, eVar, str);
    }

    static void e(android.content.Context context, io.dcloud.sdk.base.dcloud.ADHandler.e eVar, java.lang.String str) {
        org.json.JSONObject jSONObjectE = eVar.e();
        if (jSONObjectE != null) {
            a(jSONObjectE.optJSONArray("dptrackers"), "dptrackers", eVar);
        }
    }

    static void f(android.content.Context context, io.dcloud.sdk.base.dcloud.ADHandler.e eVar, java.lang.String str) {
        org.json.JSONObject jSONObjectE = eVar.e();
        if (jSONObjectE != null) {
            a(jSONObjectE.optJSONArray("imptracker"), "imptracker", eVar);
        }
    }
}
