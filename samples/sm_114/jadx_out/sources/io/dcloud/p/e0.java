package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e0 {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements io.dcloud.common.util.hostpicker.HostPicker.HostPickCallback {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.util.HashMap b;

        a(java.lang.String str, java.util.HashMap map) {
            this.a = str;
            this.b = map;
        }

        @Override // io.dcloud.common.util.hostpicker.HostPicker.HostPickCallback
        public boolean doRequest(io.dcloud.common.util.hostpicker.HostPicker.Host host) {
            org.json.JSONObject jSONObject;
            byte[] bArrHttpPost = io.dcloud.common.util.NetTool.httpPost(host.getRealHost(), this.a, (java.util.HashMap<java.lang.String, java.lang.String>) this.b, false);
            if (bArrHttpPost == null) {
                return false;
            }
            try {
                jSONObject = new org.json.JSONObject(new java.lang.String(bArrHttpPost, "utf-8"));
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
                jSONObject = null;
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
                jSONObject = null;
            }
            io.dcloud.common.adapter.util.Logger.d("commitTid", jSONObject);
            return true;
        }

        @Override // io.dcloud.common.util.hostpicker.HostPicker.HostPickCallback
        public void onNoOnePicked() {
        }

        @Override // io.dcloud.common.util.hostpicker.HostPicker.HostPickCallback
        public void onOneSelected(io.dcloud.common.util.hostpicker.HostPicker.Host host) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements io.dcloud.common.util.hostpicker.HostPicker.HostPickCallback {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.util.HashMap b;

        b(java.lang.String str, java.util.HashMap map) {
            this.a = str;
            this.b = map;
        }

        @Override // io.dcloud.common.util.hostpicker.HostPicker.HostPickCallback
        public boolean doRequest(io.dcloud.common.util.hostpicker.HostPicker.Host host) {
            org.json.JSONObject jSONObject;
            byte[] bArrHttpPost = io.dcloud.common.util.NetTool.httpPost(host.getRealHost(), this.a, (java.util.HashMap<java.lang.String, java.lang.String>) this.b, false);
            if (bArrHttpPost == null) {
                return false;
            }
            try {
                jSONObject = new org.json.JSONObject(new java.lang.String(bArrHttpPost, java.nio.charset.StandardCharsets.UTF_8));
            } catch (org.json.JSONException unused) {
                jSONObject = null;
            }
            io.dcloud.common.adapter.util.Logger.d("commitTid", jSONObject);
            return true;
        }

        @Override // io.dcloud.common.util.hostpicker.HostPicker.HostPickCallback
        public void onNoOnePicked() {
        }

        @Override // io.dcloud.common.util.hostpicker.HostPicker.HostPickCallback
        public void onOneSelected(io.dcloud.common.util.hostpicker.HostPicker.Host host) {
        }
    }

    public static java.util.HashMap a(io.dcloud.common.DHInterface.IApp iApp, android.content.SharedPreferences sharedPreferences) {
        io.dcloud.common.DHInterface.IApp iApp2;
        java.util.HashMap map = new java.util.HashMap();
        try {
            android.app.Activity activity = iApp.getActivity();
            boolean zHasPrivacyForNotShown = io.dcloud.common.util.AppRuntime.hasPrivacyForNotShown(activity);
            java.lang.String metaValue = null;
            map.putAll(io.dcloud.common.constant.DataInterface.getStartupUrlBaseData(activity, iApp.obtainAppId(), io.dcloud.common.util.BaseInfo.getLaunchType(activity.getIntent()), null, zHasPrivacyForNotShown));
            map.put("st", java.lang.Long.valueOf(io.dcloud.common.util.BaseInfo.run5appEndTime));
            map.put("pn", activity.getPackageName());
            map.put(io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME, iApp.obtainAppVersionName());
            map.put("pv", io.dcloud.common.adapter.util.AndroidResources.versionName);
            map.put("uat", java.lang.Integer.valueOf(io.dcloud.common.util.BaseInfo.isUniAppAppid(iApp) ? 1 : 0));
            if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
                try {
                    map.put("name", activity.getApplicationInfo().loadLabel(activity.getPackageManager()));
                } catch (java.lang.Exception unused) {
                    map.put("name", iApp.obtainAppName());
                }
            } else {
                map.put("name", iApp.obtainAppName());
            }
            try {
                map.put("pname", activity.getApplicationInfo().loadLabel(activity.getPackageManager()));
            } catch (java.lang.Exception unused2) {
            }
            map.put("it", java.lang.Integer.valueOf(io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() ? 1 : 0));
            if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
                boolean zCheckClass = io.dcloud.common.adapter.util.PlatformUtil.checkClass(iApp.getConfusionMgr().getGDTClassName());
                boolean zCheckClass2 = io.dcloud.common.adapter.util.PlatformUtil.checkClass(iApp.getConfusionMgr().getCSJClassName());
                boolean zCheckClass3 = io.dcloud.common.adapter.util.PlatformUtil.checkClass(iApp.getConfusionMgr().getKSClassName());
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                java.lang.String str = "1";
                jSONObject2.put("r", zCheckClass2 ? "1" : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
                jSONObject.put(io.dcloud.sdk.core.util.Const.TYPE_CSJ, jSONObject2);
                org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                jSONObject3.put("r", zCheckClass ? "1" : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
                jSONObject.put(io.dcloud.sdk.core.util.Const.TYPE_GDT, jSONObject3);
                org.json.JSONObject jSONObject4 = new org.json.JSONObject();
                if (!zCheckClass3) {
                    str = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT;
                }
                jSONObject4.put("r", str);
                jSONObject.put(io.dcloud.sdk.core.util.Const.TYPE_KS, jSONObject4);
                map.put("cad", jSONObject.toString());
            } else {
                map.put("psdk", 0);
            }
            java.lang.String bundleData = io.dcloud.common.adapter.util.SP.getBundleData(activity, "pdr", io.dcloud.common.adapter.util.SP.REPORT_UNI_VERIFY_GYUID);
            if (!android.text.TextUtils.isEmpty(bundleData)) {
                map.put("uvs", bundleData);
            }
            if (io.dcloud.common.util.PdrUtil.isSupportOaid()) {
                java.lang.String str2 = io.dcloud.common.adapter.util.DeviceInfo.oaids;
                if (str2 == null) {
                    str2 = com.taobao.weex.el.parse.Operators.OR;
                }
                map.put("oaid", str2);
            }
            if (io.dcloud.common.util.BaseInfo.isUniAppAppid(iApp)) {
                iApp2 = iApp;
                a(iApp2, map);
            } else {
                iApp2 = iApp;
            }
            map.put("dcid", io.dcloud.common.util.AppRuntime.getDCloudDeviceID(activity));
            if (android.text.TextUtils.isEmpty(io.dcloud.common.util.BaseInfo.sChannel)) {
                try {
                    metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_STREAMAPP_CHANNEL");
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                if (android.text.TextUtils.isEmpty(metaValue)) {
                    map.put("mc", "");
                } else {
                    map.put("mc", metaValue);
                }
            } else {
                map.put("mc", io.dcloud.common.util.BaseInfo.sChannel);
            }
            try {
                java.lang.String bundleData2 = io.dcloud.common.adapter.util.SP.getBundleData(iApp2.getActivity(), "pdr", "packdata");
                if (!android.text.TextUtils.isEmpty(bundleData2)) {
                    map.put("jg", bundleData2);
                    io.dcloud.common.adapter.util.SP.setBundleData(iApp2.getActivity(), "pdr", "packdata", "");
                }
                io.dcloud.p.p3.a(iApp2.getActivity());
            } catch (java.lang.Exception unused3) {
            }
            if (!zHasPrivacyForNotShown) {
                if ((java.lang.System.currentTimeMillis() - sharedPreferences.getLong(io.dcloud.common.constant.AbsoluteConst.COMMIT_APP_LIST_TIME, 0L)) / 100000 >= 26000 && !android.text.TextUtils.isEmpty(sharedPreferences.getString(io.dcloud.common.constant.AbsoluteConst.GEO_DATA, ""))) {
                    map.put("pos", sharedPreferences.getString(io.dcloud.common.constant.AbsoluteConst.GEO_DATA, ""));
                }
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        return map;
    }

    private static java.util.Map b(android.content.Context context, java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.util.HashMap map) {
        java.lang.String strEncode;
        java.lang.String str4;
        java.lang.String metaValue;
        try {
            strEncode = java.net.URLEncoder.encode(android.os.Build.MODEL, "utf-8");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            strEncode = "";
        }
        try {
            str4 = io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext.getPackageManager().getPackageInfo(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext.getPackageName(), 0).versionName;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            str4 = "";
        }
        java.lang.String imei = io.dcloud.common.util.TelephonyUtil.getIMEI(context, true, true);
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put(com.facebook.common.callercontext.ContextChain.TAG_PRODUCT, "a");
        map2.put("appid", str);
        map2.put(io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME, str4);
        map2.put("at", java.lang.Integer.valueOf(i));
        map2.put(com.taobao.weex.common.WXConfig.os, java.lang.Integer.valueOf(android.os.Build.VERSION.SDK_INT));
        map2.put("adpid", str3);
        if (imei.endsWith("&ie=1")) {
            imei = imei.replace("&ie=1", "");
            map2.put("ie", 1);
        } else if (imei.endsWith("&ie=0")) {
            imei = imei.replace("&ie=0", "");
            map2.put("ie", 0);
        }
        map2.put("imei", imei);
        map2.put("md", strEncode);
        map2.put("vd", android.os.Build.MANUFACTURER);
        map2.put("net", java.lang.Integer.valueOf(io.dcloud.common.util.NetworkTypeUtil.getNetworkType(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext)));
        map2.put("vb", "1.9.9.82680");
        map2.put("t", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        if (android.text.TextUtils.isEmpty(io.dcloud.common.util.BaseInfo.sChannel)) {
            try {
                metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_STREAMAPP_CHANNEL");
            } catch (java.lang.Exception e3) {
                e3.printStackTrace();
                metaValue = null;
            }
            if (android.text.TextUtils.isEmpty(metaValue)) {
                map2.put("mc", "");
            } else {
                map2.put("mc", metaValue);
            }
        } else {
            map2.put("mc", io.dcloud.common.util.BaseInfo.sChannel);
        }
        map2.put("paid", str2);
        if (map != null) {
            map2.putAll(map);
        }
        return map2;
    }

    private static void a(io.dcloud.common.DHInterface.IApp iApp, java.util.HashMap map) {
        java.lang.String string;
        com.alibaba.fastjson.JSONArray jSONArray;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            string = io.dcloud.common.util.IOUtil.toString(iApp.getActivity().getAssets().open("dcloud_uniplugins.json"));
        } catch (java.lang.Exception unused) {
            string = null;
        }
        if (!io.dcloud.common.util.PdrUtil.isEmpty(string)) {
            try {
                com.alibaba.fastjson.JSONArray jSONArray2 = com.alibaba.fastjson.JSON.parseObject(string).getJSONArray("nativePlugins");
                if (jSONArray2 != null && jSONArray2.size() > 0) {
                    for (int i = 0; i < jSONArray2.size(); i++) {
                        com.alibaba.fastjson.JSONObject jSONObject = jSONArray2.getJSONObject(i);
                        if (jSONObject != null && (jSONArray = jSONObject.getJSONArray("plugins")) != null && jSONArray.size() > 0) {
                            for (int i2 = 0; i2 < jSONArray.size(); i2++) {
                                com.alibaba.fastjson.JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                                if (jSONObject2 != null && jSONObject2.containsKey("name")) {
                                    sb.append(jSONObject2.getString("name"));
                                    sb.append(",");
                                }
                            }
                        }
                    }
                }
            } catch (java.lang.Exception unused2) {
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            map.put("ups", sb.toString());
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.String str4, java.lang.String str5, org.json.JSONObject jSONObject, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.util.HashMap map) {
        java.lang.String strEncode;
        try {
            java.net.URLEncoder.encode(android.os.Build.MODEL, "utf-8");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            java.lang.String str10 = io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext.getPackageManager().getPackageInfo(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext.getPackageName(), 0).versionName;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        io.dcloud.common.util.TelephonyUtil.getIMEI(context, true, true);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (i == 1) {
            arrayList.add(new io.dcloud.common.util.hostpicker.HostPicker.Host("YHx8eHsyJyd8OSZsa2RnfWwmZm18JmtmJ2tnZGRta3wneGR9e2l4eCdpa3xhZ2Y=", io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.FIRST));
            arrayList.add(new io.dcloud.common.util.hostpicker.HostPicker.Host("YHx8eHsyJyd8OiZsa2RnfWwmZm18JmtmJ2tnZGRta3wneGR9e2l4eCdpa3xhZ2Y=", io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.NORMAL));
            arrayList.add(new io.dcloud.common.util.hostpicker.HostPicker.Host("YHx8eHsyJydqfDkmbGtkZ31sJmZtfCZrZidgfHx4J2tpaQ==", io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.BACKUP));
        } else {
            arrayList.add(new io.dcloud.common.util.hostpicker.HostPicker.Host("YHx8eHsyJydpezkmbGtkZ31sJmZtfCZrZidrZ2RkbWt8J3hkfXtpeHgnaWt8YWdm", io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.FIRST));
            arrayList.add(new io.dcloud.common.util.hostpicker.HostPicker.Host("YHx8eHsyJydpezombGtkZ31sJmZtfCZrZidrZ2RkbWt8J3hkfXtpeHgnaWt8YWdm", io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.NORMAL));
            arrayList.add(new io.dcloud.common.util.hostpicker.HostPicker.Host("YHx8eHsyJydqaXs5JmxrZGd9bCZmbXwma2YnYHx8eCdraWk=", io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.BACKUP));
        }
        java.util.Map mapB = b(context, str, str3, i, str8, map);
        if (str6 != null) {
            mapB.put("mediaId", str6);
        }
        if (str7 != null) {
            mapB.put("slotId", str7);
        }
        mapB.put("tid", str2);
        if (i == 32) {
            mapB.put("dec", str4);
            mapB.put("dem", str5);
        }
        if (i == 41 && jSONObject != null && str6 == null) {
            if (jSONObject.has(com.taobao.weex.ui.component.WXBasicComponentType.IMG)) {
                mapB.put(com.taobao.weex.ui.component.WXBasicComponentType.IMG, io.dcloud.common.util.Md5Utils.md5(jSONObject.optString(com.taobao.weex.ui.component.WXBasicComponentType.IMG)).toLowerCase(java.util.Locale.ENGLISH));
            }
            if (jSONObject.has("dw")) {
                mapB.put("dw", jSONObject.optString("dw"));
            }
            if (jSONObject.has("dh")) {
                mapB.put("dh", jSONObject.optString("dh"));
            }
            if (jSONObject.has("click_coord")) {
                mapB.put("click_coord", jSONObject.optJSONObject("click_coord").toString());
            }
        }
        try {
            strEncode = java.net.URLEncoder.encode(android.util.Base64.encodeToString(io.dcloud.common.util.AESUtil.encrypt(io.dcloud.p.e1.c(), io.dcloud.p.e1.b(), io.dcloud.common.util.ZipUtils.zipString(new org.json.JSONObject(mapB).toString())), 2), "utf-8");
        } catch (java.io.UnsupportedEncodingException e3) {
            e3.printStackTrace();
            strEncode = null;
        }
        java.lang.String str11 = "edata=" + strEncode;
        try {
            java.util.HashMap map2 = new java.util.HashMap();
            try {
                if (!io.dcloud.common.util.PdrUtil.isEmpty(str9) && str9.equalsIgnoreCase("webview")) {
                    java.lang.Object objADHandlerMethod = io.dcloud.common.util.ADUtils.ADHandlerMethod("get", "ua-webview");
                    if (objADHandlerMethod instanceof java.lang.String) {
                        map2.put(io.dcloud.common.DHInterface.IWebview.USER_AGENT, (java.lang.String) objADHandlerMethod);
                    }
                }
            } catch (java.lang.Exception unused) {
            }
            io.dcloud.common.util.hostpicker.HostPicker.getInstance().pickSuitHost(context, arrayList, "CAA_" + i, new io.dcloud.p.e0.a(str11, map2));
        } catch (java.lang.Exception e4) {
            io.dcloud.common.adapter.util.Logger.p("CommitDataUtil", e4.getMessage());
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.util.HashMap map) {
        java.lang.String strEncode;
        java.util.Map mapB = b(context, str, str2, i, str3, map);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new io.dcloud.common.util.hostpicker.HostPicker.Host("YHx8eHsyJydpejkmbGtkZ31sJmZtfCZrZidrZ2RkbWt8J3hkfXtpeHgnent4", io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.FIRST));
        arrayList.add(new io.dcloud.common.util.hostpicker.HostPicker.Host("YHx8eHsyJydpejombGtkZ31sJmZtfCZrZidrZ2RkbWt8J3hkfXtpeHgnent4", io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.NORMAL));
        arrayList.add(new io.dcloud.common.util.hostpicker.HostPicker.Host("YHx8eHsyJydqaXo6JmxrZGd9bCZmbXwma2YnYHx8eCdraXo=", io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.BACKUP));
        try {
            strEncode = java.net.URLEncoder.encode(android.util.Base64.encodeToString(io.dcloud.common.util.AESUtil.encrypt(io.dcloud.p.e1.c(), io.dcloud.p.e1.b(), io.dcloud.common.util.ZipUtils.zipString(new org.json.JSONObject(mapB).toString())), 2), "utf-8");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            strEncode = null;
        }
        io.dcloud.common.util.hostpicker.HostPicker.getInstance().pickSuitHost(context, arrayList, "RSP", new io.dcloud.p.e0.b("edata=" + strEncode, new java.util.HashMap()));
    }

    public static void a(io.dcloud.common.DHInterface.IApp iApp, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, org.json.JSONArray jSONArray) {
        java.lang.String metaValue;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.facebook.common.callercontext.ContextChain.TAG_PRODUCT, "a");
            jSONObject.put("t", str4);
            jSONObject.put("a", str);
            jSONObject.put("c", str2);
            jSONObject.put(com.taobao.weex.ui.component.WXComponent.PROP_FS_MATCH_PARENT, str3);
            if (jSONArray != null) {
                jSONObject.put("d", jSONArray);
            }
            jSONObject.put("pn", iApp.getActivity().getPackageName());
            jSONObject.put(io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME, iApp.obtainAppVersionName());
            jSONObject.put("pv", io.dcloud.common.adapter.util.AndroidResources.versionName);
            jSONObject.put("appid", iApp.obtainAppId());
            jSONObject.put(com.taobao.weex.common.WXConfig.os, android.os.Build.VERSION.SDK_INT);
            jSONObject.put("md", android.os.Build.MODEL);
            jSONObject.put("vd", android.os.Build.MANUFACTURER);
            jSONObject.put("vb", "1.9.9.82680");
            if (android.text.TextUtils.isEmpty(io.dcloud.common.util.BaseInfo.sChannel)) {
                try {
                    metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_STREAMAPP_CHANNEL");
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    metaValue = null;
                }
                if (!android.text.TextUtils.isEmpty(metaValue)) {
                    jSONObject.put("mc", metaValue);
                } else {
                    jSONObject.put("mc", "");
                }
            } else {
                jSONObject.put("mc", io.dcloud.common.util.BaseInfo.sChannel);
            }
            io.dcloud.common.util.NetTool.httpPost(io.dcloud.common.util.PdrUtil.checkIntl() ? "https://er.dcloud.io/rv" : "https://er.dcloud.net.cn/rv", jSONObject.toString(), null);
        } catch (org.json.JSONException unused) {
        }
    }
}
