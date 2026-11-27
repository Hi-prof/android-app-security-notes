package io.dcloud.feature.gg.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
class ADHandler_youdao extends io.dcloud.feature.gg.dcloud.ADHandler {
    ADHandler_youdao() {
    }

    static void click_youdao(android.content.Context context, io.dcloud.feature.gg.dcloud.ADHandler.AdData adData, java.lang.String str) {
        org.json.JSONObject jSONObjectReport = adData.report();
        if (jSONObjectReport != null) {
            handleTrackers_youdao(jSONObjectReport.optJSONArray("clktrackers"), "clktrackers", adData);
        }
        io.dcloud.feature.gg.dcloud.ADHandler.click_base(context, adData, str);
    }

    static void dplk_youdao(android.content.Context context, io.dcloud.feature.gg.dcloud.ADHandler.AdData adData, java.lang.String str) {
        org.json.JSONObject jSONObjectReport = adData.report();
        if (jSONObjectReport != null) {
            handleTrackers_youdao(jSONObjectReport.optJSONArray("dptrackers"), "dptrackers", adData);
        }
    }

    static void handleAdData_youdao(android.content.Context context, org.json.JSONObject jSONObject, long j) throws java.lang.Exception {
        io.dcloud.feature.gg.dcloud.ADHandler.handleAdData_dcloud(context, jSONObject, j);
    }

    static void handleTrackers_youdao(org.json.JSONArray jSONArray, java.lang.String str, io.dcloud.feature.gg.dcloud.ADHandler.AdData adData) {
        final java.util.HashMap map;
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                final java.lang.String strOptString = jSONArray.optString(i);
                io.dcloud.feature.gg.dcloud.ADHandler.log("ADHandler_youdao", str + ";url=" + strOptString);
                org.json.JSONObject jSONObjectFull = adData.full();
                if (jSONObjectFull != null && jSONObjectFull.has("ua") && jSONObjectFull.optString("ua").equalsIgnoreCase("webview")) {
                    map = new java.util.HashMap();
                    map.put(io.dcloud.common.DHInterface.IWebview.USER_AGENT, io.dcloud.feature.gg.dcloud.ADHandler.get("ua-webview"));
                } else {
                    map = null;
                }
                io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.feature.gg.dcloud.ADHandler_youdao.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            io.dcloud.common.util.NetTool.httpGet(strOptString, (java.util.HashMap<java.lang.String, java.lang.String>) map, true);
                        } catch (java.lang.Exception unused) {
                        }
                    }
                });
            }
        }
    }

    static void view_youdao(android.content.Context context, io.dcloud.feature.gg.dcloud.ADHandler.AdData adData, java.lang.String str) {
        org.json.JSONObject jSONObjectReport = adData.report();
        if (jSONObjectReport != null) {
            handleTrackers_youdao(jSONObjectReport.optJSONArray("imptracker"), "imptracker", adData);
        }
    }
}
