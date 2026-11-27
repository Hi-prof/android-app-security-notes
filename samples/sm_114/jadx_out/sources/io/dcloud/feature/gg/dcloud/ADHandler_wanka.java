package io.dcloud.feature.gg.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
class ADHandler_wanka extends io.dcloud.feature.gg.dcloud.ADHandler {
    ADHandler_wanka() {
    }

    static void click_wanka(final android.content.Context context, final io.dcloud.feature.gg.dcloud.ADHandler.AdData adData, final java.lang.String str) {
        int iOptInt = adData.data().optInt("template", 0);
        java.lang.String strOptString = adData.data().optString("action");
        if (iOptInt == 1) {
            if (adData.isEClick()) {
                return;
            }
            org.json.JSONArray jSONArrayOptJSONArray = adData.report().optJSONArray("clktrackers");
            if (io.dcloud.common.constant.AbsoluteConst.SPNAME_DOWNLOAD.equals(strOptString)) {
                handleTrackers_wanka(jSONArrayOptJSONArray, adData.full(), new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.gg.dcloud.ADHandler_wanka.1
                    @Override // io.dcloud.common.DHInterface.ICallBack
                    public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                        org.json.JSONObject jSONObjectOptJSONObject = ((org.json.JSONObject) obj).optJSONObject("data");
                        java.lang.String strOptString2 = jSONObjectOptJSONObject.optString("dstlink");
                        java.lang.String strOptString3 = jSONObjectOptJSONObject.optString("clickid");
                        java.lang.String strOptString4 = adData.data().optString("tid");
                        try {
                            adData.full().put("click_id", strOptString3);
                        } catch (org.json.JSONException e) {
                            e.printStackTrace();
                        }
                        android.content.Context context2 = context;
                        io.dcloud.feature.gg.dcloud.ADHandler.AdData adData2 = adData;
                        io.dcloud.feature.gg.dcloud.ADHandler_wanka.click_wanka_other(context2, adData2, strOptString2, adData2.mOriginalAppid, strOptString4, str, adData2.full());
                        if (adData.isEClick()) {
                            return null;
                        }
                        io.dcloud.common.util.ADUtils.loadAppTip(context);
                        return null;
                    }
                }, "clktrackers");
                return;
            } else {
                if ("url".equals(strOptString)) {
                    click_wanka_url(context, adData, jSONArrayOptJSONArray, adData.mOriginalAppid, str);
                    return;
                }
                return;
            }
        }
        org.json.JSONArray jSONArrayOptJSONArray2 = adData.report().optJSONArray("clktrackers");
        if (jSONArrayOptJSONArray2 != null) {
            handleTrackers_wanka(jSONArrayOptJSONArray2, adData.full(), "clktrackers");
        }
        if (!io.dcloud.common.constant.AbsoluteConst.SPNAME_DOWNLOAD.equals(strOptString)) {
            io.dcloud.feature.gg.dcloud.ADHandler.click_base(context, adData, str);
            return;
        }
        java.lang.String strOptString2 = adData.data().optString(io.dcloud.feature.uniapp.adapter.AbsURIAdapter.BUNDLE);
        if (android.text.TextUtils.isEmpty(strOptString2) || !io.dcloud.common.util.LoadAppUtils.isAppLoad(context, strOptString2)) {
            io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.feature.gg.dcloud.ADHandler_wanka.2
                @Override // java.lang.Runnable
                public void run() {
                    java.lang.String strOptString3 = adData.data().optString("url");
                    java.lang.String strOptString4 = adData.data().optString("tid");
                    android.content.Context context2 = context;
                    io.dcloud.feature.gg.dcloud.ADHandler.AdData adData2 = adData;
                    io.dcloud.feature.gg.dcloud.ADHandler_wanka.click_wanka_other(context2, adData2, strOptString3, adData2.mOriginalAppid, strOptString4, str, adData2.full());
                }
            });
            if (adData.isEClick()) {
                return;
            }
            io.dcloud.common.util.ADUtils.loadAppTip(context);
            return;
        }
        if (adData.isEClick()) {
            return;
        }
        try {
            android.content.Intent uri = android.content.Intent.parseUri(adData.data().optString("dplk"), 1);
            uri.setFlags(268435456);
            if (io.dcloud.common.util.BaseInfo.isDefense) {
                uri.setSelector(null);
                uri.setComponent(null);
                uri.addCategory("android.intent.category.BROWSABLE");
            }
            if (context.getPackageManager().resolveActivity(uri, 65536) != null) {
                context.startActivity(uri);
            }
        } catch (java.net.URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void click_wanka_other(android.content.Context context, io.dcloud.feature.gg.dcloud.ADHandler.AdData adData, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, final org.json.JSONObject jSONObject) {
        java.lang.String str5;
        final org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("report");
        org.json.JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("dwnlsts");
        if (jSONArrayOptJSONArray != null) {
            handleTrackers_wanka(jSONArrayOptJSONArray, jSONObject, "dwnlsts");
        }
        java.lang.String strOptString = jSONObject.optJSONObject("data").optString(io.dcloud.feature.uniapp.adapter.AbsURIAdapter.BUNDLE);
        if (io.dcloud.common.util.ADUtils.getDdDataForUrl(str) != null) {
            return;
        }
        java.lang.String str6 = com.taobao.weex.el.parse.Operators.DOT_STR + context.getString(io.dcloud.base.R.string.in_package);
        if (android.text.TextUtils.isEmpty(strOptString)) {
            str5 = null;
        } else {
            str5 = strOptString + com.taobao.weex.el.parse.Operators.DOT_STR + context.getString(io.dcloud.base.R.string.in_package);
        }
        java.lang.String fileNameByUrl = io.dcloud.common.util.PdrUtil.getFileNameByUrl(str, str6, str5);
        java.lang.String strOptString2 = adData.full() != null ? adData.full().optString("ua") : "";
        if (adData.isEClick()) {
            io.dcloud.feature.gg.dcloud.ADSim.dwApp(context, str2, str3, str4, str, strOptString, new io.dcloud.common.DHInterface.ILoadCallBack() { // from class: io.dcloud.feature.gg.dcloud.ADHandler_wanka.5
                @Override // io.dcloud.common.DHInterface.ILoadCallBack
                public java.lang.Object onCallBack(int i, android.content.Context context2, java.lang.Object obj) {
                    if (i != 0) {
                        return null;
                    }
                    org.json.JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("dwnltrackers");
                    if (jSONArrayOptJSONArray2 != null) {
                        io.dcloud.feature.gg.dcloud.ADHandler_wanka.handleTrackers_wanka(jSONArrayOptJSONArray2, jSONObject, "dwnltrackers");
                    }
                    return java.lang.Boolean.TRUE;
                }
            }, strOptString2);
            return;
        }
        long jLoadADFile = io.dcloud.common.util.ADUtils.loadADFile(context, str2, str3, str4, fileNameByUrl, strOptString, str, "application/vnd.android", new io.dcloud.common.DHInterface.ILoadCallBack() { // from class: io.dcloud.feature.gg.dcloud.ADHandler_wanka.6
            @Override // io.dcloud.common.DHInterface.ILoadCallBack
            public java.lang.Object onCallBack(int i, android.content.Context context2, java.lang.Object obj) {
                if (i != 0) {
                    return null;
                }
                org.json.JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("dwnltrackers");
                if (jSONArrayOptJSONArray2 != null) {
                    io.dcloud.feature.gg.dcloud.ADHandler_wanka.handleTrackers_wanka(jSONArrayOptJSONArray2, jSONObject, "dwnltrackers");
                }
                io.dcloud.feature.gg.dcloud.ADHandler_wanka.runApp(context2, jSONObject, (android.content.Intent) obj);
                return java.lang.Boolean.TRUE;
            }
        }, true, strOptString2);
        io.dcloud.common.util.ADUtils.ADLoadData aDLoadData = new io.dcloud.common.util.ADUtils.ADLoadData();
        aDLoadData.name = io.dcloud.feature.gg.AolSplashUtil.getApplicationName(context);
        aDLoadData.pname = strOptString;
        aDLoadData.url = str;
        aDLoadData.appid = str2;
        aDLoadData.tid = str3;
        aDLoadData.adid = str4;
        aDLoadData.type = "wanka";
        aDLoadData.id = jLoadADFile;
        aDLoadData.ua = strOptString2;
        try {
            io.dcloud.common.util.ADUtils.saveLoadData(aDLoadData);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private static void click_wanka_url(final android.content.Context context, final io.dcloud.feature.gg.dcloud.ADHandler.AdData adData, final org.json.JSONArray jSONArray, java.lang.String str, java.lang.String str2) {
        io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.feature.gg.dcloud.ADHandler_wanka.3
            @Override // java.lang.Runnable
            public void run() {
                if (jSONArray != null) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            org.json.JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                            int iOptInt = jSONObjectOptJSONObject.optInt("template_type");
                            org.json.JSONObject jSONObjectFull = adData.full();
                            boolean z = jSONObjectFull.has("ua") && jSONObjectFull.optString("ua").equalsIgnoreCase("webview");
                            jSONObjectFull.put("u-a", io.dcloud.feature.gg.dcloud.ADHandler.get("ua-webview"));
                            java.lang.String url = io.dcloud.feature.gg.dcloud.ADHandler.formatUrl(jSONObjectOptJSONObject.optString("url"), jSONObjectFull);
                            int iOptInt2 = jSONObjectOptJSONObject.optInt("http_method");
                            java.lang.String strOptString = jSONObjectOptJSONObject.optString(com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME);
                            if (iOptInt != 1) {
                                io.dcloud.feature.gg.dcloud.ADHandler_wanka.handleTrackers_wanka(url, strOptString, iOptInt2, 2, false, null, "clktrackers", z);
                            } else if (adData.isEClick()) {
                                io.dcloud.feature.gg.dcloud.ADSim.openUrl(context, url);
                            } else {
                                io.dcloud.common.util.ADUtils.openUrl(context, url);
                            }
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    static void dplk_wanka(android.content.Context context, io.dcloud.feature.gg.dcloud.ADHandler.AdData adData, java.lang.String str) {
        org.json.JSONArray jSONArrayOptJSONArray = adData.report().optJSONArray("dplktrackers");
        if (jSONArrayOptJSONArray != null) {
            handleTrackers_wanka(jSONArrayOptJSONArray, adData.full(), "dplktrackers");
        }
    }

    static void handleAdData_wanka(android.content.Context context, org.json.JSONObject jSONObject, long j) throws java.lang.Exception {
        io.dcloud.feature.gg.dcloud.ADHandler.handleAdData_dcloud(context, jSONObject, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleTrackers_wanka(org.json.JSONArray jSONArray, org.json.JSONObject jSONObject, java.lang.String str) {
        handleTrackers_wanka(jSONArray, jSONObject, null, str);
    }

    static void log(java.lang.String str) {
        io.dcloud.feature.gg.dcloud.ADHandler.log("wanka", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void runApp(android.content.Context context, org.json.JSONObject jSONObject, android.content.Intent intent) {
        io.dcloud.common.util.RuningAcitvityUtil.StartActivity(context, intent);
    }

    static void view_wanka(android.content.Context context, io.dcloud.feature.gg.dcloud.ADHandler.AdData adData, java.lang.String str) {
        org.json.JSONObject jSONObjectReport = adData.report();
        if (jSONObjectReport != null) {
            handleTrackers_wanka(jSONObjectReport.optJSONArray("imptrackers"), adData.full(), "imptrackers");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleTrackers_wanka(final java.lang.String str, final java.lang.String str2, final int i, int i2, final boolean z, final io.dcloud.common.DHInterface.ICallBack iCallBack, java.lang.String str3, final boolean z2) {
        final int i3 = i2 - 1;
        log("handleTrackers_wanka template = " + (z ? 1 : 0) + "; t_count=" + i3 + "; tagMsg " + str3 + ";  url=" + str);
        io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.feature.gg.dcloud.ADHandler_wanka.4
            @Override // java.lang.Runnable
            public void run() {
                java.util.HashMap map;
                byte[] bArrHttpGet = null;
                if (z2) {
                    map = new java.util.HashMap();
                    map.put(io.dcloud.common.DHInterface.IWebview.USER_AGENT, io.dcloud.feature.gg.dcloud.ADHandler.get("ua-webview"));
                } else {
                    map = null;
                }
                int i4 = i;
                if (i4 == 0) {
                    try {
                        bArrHttpGet = io.dcloud.common.util.NetTool.httpGet(str, (java.util.HashMap<java.lang.String, java.lang.String>) map, true);
                    } catch (java.lang.Exception unused) {
                    }
                } else if (i4 == 1) {
                    bArrHttpGet = io.dcloud.common.util.NetTool.httpPost(str, str2, map);
                }
                if (!z || bArrHttpGet == null) {
                    return;
                }
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(bArrHttpGet));
                    if (jSONObject.optInt("ret") == 0) {
                        io.dcloud.common.DHInterface.ICallBack iCallBack2 = iCallBack;
                        if (iCallBack2 != null) {
                            iCallBack2.onCallBack(1, jSONObject);
                            return;
                        }
                        return;
                    }
                    java.lang.String strOptString = jSONObject.optString(androidx.core.app.NotificationCompat.CATEGORY_MESSAGE);
                    io.dcloud.feature.gg.dcloud.ADHandler_wanka.log("handleTrackers_wanka Runnable Error url=" + str + ";msg=" + strOptString);
                    int i5 = i3;
                    if (i5 > 0) {
                        io.dcloud.feature.gg.dcloud.ADHandler_wanka.handleTrackers_wanka(str, strOptString, i, i5, z, iCallBack, null, z2);
                    }
                    io.dcloud.common.util.NetTool.httpGet(str, (java.util.HashMap<java.lang.String, java.lang.String>) map, true);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void handleTrackers_wanka(org.json.JSONArray jSONArray, org.json.JSONObject jSONObject, io.dcloud.common.DHInterface.ICallBack iCallBack, java.lang.String str) {
        for (int i = 0; i < jSONArray.length(); i++) {
            org.json.JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            int iOptInt = jSONObjectOptJSONObject.optInt("template_type");
            boolean z = jSONObject.has("ua") && jSONObject.optString("ua").equalsIgnoreCase("webview");
            try {
                jSONObject.put("u-a", io.dcloud.feature.gg.dcloud.ADHandler.get("ua-webview"));
            } catch (org.json.JSONException unused) {
            }
            handleTrackers_wanka(io.dcloud.feature.gg.dcloud.ADHandler.formatUrl(jSONObjectOptJSONObject.optString("url"), jSONObject), jSONObjectOptJSONObject.optString(com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME), jSONObjectOptJSONObject.optInt("http_method"), 2, iOptInt == 1, iCallBack, str, z);
        }
    }
}
