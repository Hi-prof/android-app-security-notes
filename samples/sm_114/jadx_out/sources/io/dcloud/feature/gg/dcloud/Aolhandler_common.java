package io.dcloud.feature.gg.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class Aolhandler_common extends io.dcloud.feature.gg.dcloud.ADHandler {
    static void click_common(android.content.Context context, io.dcloud.feature.gg.dcloud.ADHandler.AdData adData, java.lang.String str) {
        org.json.JSONObject jSONObjectReport = adData.report();
        if (jSONObjectReport != null) {
            handleTrackers_common(jSONObjectReport.optJSONArray("clktracker"), "clktracker", adData);
        }
        io.dcloud.feature.gg.dcloud.ADHandler.click_base(context, adData, str);
    }

    static void handleAdData_common(android.content.Context context, org.json.JSONObject jSONObject, long j) throws java.lang.Exception {
        io.dcloud.feature.gg.dcloud.ADHandler.handleAdData_dcloud(context, jSONObject, j);
    }

    static void handleTrackers_common(org.json.JSONArray jSONArray, java.lang.String str, io.dcloud.feature.gg.dcloud.ADHandler.AdData adData) {
        final java.util.HashMap map;
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                final java.lang.String strOptString = jSONArray.optJSONObject(i).optString("url");
                org.json.JSONObject jSONObjectFull = adData.full();
                if (jSONObjectFull != null && jSONObjectFull.has("ua") && jSONObjectFull.optString("ua").equalsIgnoreCase("webview")) {
                    map = new java.util.HashMap();
                    map.put(io.dcloud.common.DHInterface.IWebview.USER_AGENT, io.dcloud.feature.gg.dcloud.ADHandler.get("ua-webview"));
                } else {
                    map = null;
                }
                io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.feature.gg.dcloud.Aolhandler_common.1
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

    static void handletask_common(android.content.Context context, io.dcloud.feature.gg.dcloud.ADHandler.AdData adData, java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObjectReport = adData.report();
        if (jSONObjectReport != null) {
            handleTrackers_common(jSONObjectReport.optJSONArray(str2), str2, adData);
        }
    }
}
