package io.dcloud.feature.weex.extend;

/* JADX INFO: loaded from: classes2.dex */
public class PlusModule extends com.taobao.weex.common.WXModule {
    private static final java.lang.String HELP_LOG_HASH = "HELP_LOG_HASH_";
    private java.lang.String EVENTS_DOCUMENT_EXECUTE = "javascript:!function(){(window.__html5plus__&&__html5plus__.isReady?__html5plus__:navigator.plus&&navigator.plus.isReady?navigator.plus:window.plus)||window.__load__plus__&&window.__load__plus__();var _=document.createEvent(\"HTMLEvents\");_.initEvent(\"%s\",!1,!0),_.targetId=\"%s\",_.originId=\"%s\",_.data=%s,document.dispatchEvent(_)}();";
    java.util.ArrayList<io.dcloud.feature.weex.extend.PlusModule.JsData> chs = new java.util.ArrayList<>();

    @com.taobao.weex.annotation.JSMethod
    public void postMessage(java.lang.String str, java.lang.String str2) {
        io.dcloud.feature.weex.WXServiceWrapper wXServiceWrapperFindWXServiceWrapper;
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(this.mWXSDKInstance);
        java.lang.String str3 = io.dcloud.common.util.StringUtil.format(this.EVENTS_DOCUMENT_EXECUTE, "uniNViewMessage", "", iWebviewFindWebview != null ? iWebviewFindWebview.obtainFrameId() : "", str);
        if (iWebviewFindWebview == null && (wXServiceWrapperFindWXServiceWrapper = io.dcloud.feature.weex.WeexInstanceMgr.self().findWXServiceWrapper(this.mWXSDKInstance)) != null && !io.dcloud.common.util.BaseInfo.isWeexUniJs(wXServiceWrapperFindWXServiceWrapper.obtanApp())) {
            wXServiceWrapperFindWXServiceWrapper.findWebViewToLoadUrL(str3, str2);
            return;
        }
        if (iWebviewFindWebview != null) {
            io.dcloud.common.DHInterface.IWebview iWebviewFindWebview2 = io.dcloud.common.util.PdrUtil.isEmpty(str2) ? iWebviewFindWebview : io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(iWebviewFindWebview, iWebviewFindWebview.obtainApp(), iWebviewFindWebview.obtainApp().obtainAppId(), str2);
            if (iWebviewFindWebview2 != null) {
                if (iWebviewFindWebview2 instanceof io.dcloud.common.adapter.ui.AdaUniWebView) {
                    java.util.HashMap map = new java.util.HashMap();
                    map.put("targetId", str2);
                    map.put("originId", iWebviewFindWebview != null ? iWebviewFindWebview.obtainFrameId() : "");
                    try {
                        map.put("data", com.alibaba.fastjson.JSONObject.parseObject(str));
                    } catch (java.lang.Exception unused) {
                        map.put("data", str);
                    }
                    ((io.dcloud.common.adapter.ui.AdaUniWebView) iWebviewFindWebview2).fireEvent(new io.dcloud.common.adapter.util.EventActionInfo("uniNViewMessage", map));
                    return;
                }
                iWebviewFindWebview2.loadUrl(str3);
            }
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void exec(java.lang.String str, java.lang.String str2) {
        if (this.mWXSDKInstance == null || !this.mWXSDKInstance.isDestroy()) {
            io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(this.mWXSDKInstance);
            if (iWebviewFindWebview instanceof io.dcloud.common.adapter.ui.AdaUniWebView) {
                ((io.dcloud.common.adapter.ui.AdaUniWebView) iWebviewFindWebview).prompt(str, str2);
            }
        }
    }

    class JsData {
        public java.lang.String data;
        public java.lang.String value;

        JsData(java.lang.String str, java.lang.String str2) {
            this.data = str;
            this.value = str2;
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public java.lang.String execSync(java.lang.String str, java.lang.String str2) {
        if (this.mWXSDKInstance != null && this.mWXSDKInstance.isDestroy()) {
            return "";
        }
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(this.mWXSDKInstance);
        return iWebviewFindWebview instanceof io.dcloud.common.adapter.ui.AdaUniWebView ? ((io.dcloud.common.adapter.ui.AdaUniWebView) iWebviewFindWebview).prompt(str, str2) : "";
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void uniReady() {
        io.dcloud.feature.weex.WXBaseWrapper wXBaseWrapperFindWXBaseWrapper = io.dcloud.feature.weex.WeexInstanceMgr.self().findWXBaseWrapper(this.mWXSDKInstance);
        if (wXBaseWrapperFindWXBaseWrapper != null) {
            wXBaseWrapperFindWXBaseWrapper.onReady();
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void setLanguage(java.lang.String str) {
        if (this.mWXSDKInstance == null || this.mWXSDKInstance.getContext() == null || io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() || this.mWXSDKInstance.isDestroy()) {
            return;
        }
        if ("auto".equalsIgnoreCase(str)) {
            str = "";
        }
        io.dcloud.common.util.language.LanguageUtil.updateLanguage(this.mWXSDKInstance.getContext(), str);
        androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(this.mWXSDKInstance.getContext()).sendBroadcast(new android.content.Intent(io.dcloud.common.util.language.LanguageUtil.LanguageBroadCastIntent));
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public java.lang.String getLanguage() {
        if (this.mWXSDKInstance == null || this.mWXSDKInstance.getContext() == null) {
            return "";
        }
        return io.dcloud.common.util.language.LanguageUtil.getCurrentLocaleLanguage(this.mWXSDKInstance.getContext());
    }

    private void runChData() {
        if (this.chs.isEmpty()) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (io.dcloud.feature.weex.extend.PlusModule.JsData jsData : this.chs) {
            exec(jsData.data, jsData.value);
            arrayList.add(jsData);
        }
        this.chs.removeAll(arrayList);
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public java.lang.Object getConfigInfo() {
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(this.mWXSDKInstance);
        if (iWebviewFindWebview instanceof io.dcloud.common.adapter.ui.AdaUniWebView) {
            return ((io.dcloud.common.adapter.ui.AdaUniWebView) iWebviewFindWebview).getConfigInfo();
        }
        return null;
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public java.lang.Object getRedirectInfo() {
        com.alibaba.fastjson.JSONObject object;
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(this.mWXSDKInstance);
        com.alibaba.fastjson.JSONObject jSONObject = null;
        if (iWebviewFindWebview != null) {
            if (java.lang.Boolean.valueOf(iWebviewFindWebview.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.UNI_RESTART_TO_DIRECT)).booleanValue() && (object = com.alibaba.fastjson.JSON.parseObject(iWebviewFindWebview.obtainApp().obtainConfigProperty(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_DEBUG_REFRESH))) != null && object.containsKey("arguments")) {
                try {
                    jSONObject = com.alibaba.fastjson.JSON.parseObject(object.getString("arguments"));
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                iWebviewFindWebview.obtainApp().setConfigProperty(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_DEBUG_REFRESH, "");
            }
            com.alibaba.fastjson.JSONObject object2 = com.alibaba.fastjson.JSON.parseObject(iWebviewFindWebview.obtainApp().obtainConfigProperty(io.dcloud.common.constant.IntentConst.UNIMP_RUN_EXTRA_INFO));
            if (object2 != null) {
                if (jSONObject == null) {
                    jSONObject = new com.alibaba.fastjson.JSONObject();
                }
                jSONObject.putAll(object2);
                iWebviewFindWebview.obtainApp().setConfigProperty(io.dcloud.common.constant.IntentConst.UNIMP_RUN_EXTRA_INFO, "");
            }
        }
        return jSONObject;
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void setDefaultFontSize(java.lang.String str) {
        int iIntValue = java.lang.Integer.valueOf(str).intValue();
        if (iIntValue > 0) {
            this.mWXSDKInstance.setDefaultFontSize(iIntValue);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void log(java.lang.String str) {
        io.dcloud.common.adapter.util.Logger.d("console", "[LOG] " + str);
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public java.lang.String getValue(java.lang.String str) {
        return ((com.taobao.weex.ui.component.DCWXInput) com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(this.mWXSDKInstance.getInstanceId(), str)).getValue();
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void sendNativeEvent(java.lang.String str, java.lang.Object obj, com.taobao.weex.bridge.JSCallback jSCallback) {
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(this.mWXSDKInstance);
        if (iWebviewFindWebview == null || iWebviewFindWebview.getActivity() == null || !(iWebviewFindWebview.getActivity() instanceof io.dcloud.common.DHInterface.IActivityHandler)) {
            return;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("event", str);
        bundle.putString("dataType", "String");
        if (obj instanceof java.lang.String) {
            bundle.putString("data", java.lang.String.valueOf(obj));
        } else if (obj instanceof com.alibaba.fastjson.JSON) {
            bundle.putString("data", ((com.alibaba.fastjson.JSON) obj).toJSONString());
            bundle.putString("dataType", "JSON");
        }
        if (jSCallback instanceof com.taobao.weex.bridge.SimpleJSCallback) {
            bundle.putString("instanceId", this.mWXSDKInstance.getInstanceId());
            bundle.putString(io.dcloud.feature.internal.sdk.SDK.UNIMP_EVENT_CALLBACKID, ((com.taobao.weex.bridge.SimpleJSCallback) jSCallback).getCallbackId());
        }
        ((io.dcloud.common.DHInterface.IActivityHandler) iWebviewFindWebview.getActivity()).callBack(io.dcloud.feature.internal.sdk.SDK.UNIMP_JS_TO_NATIVE, bundle);
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public com.alibaba.fastjson.JSONObject getDotData() {
        com.alibaba.fastjson.JSONObject deviceInfo = io.dcloud.weex.WXDotDataUtil.getDeviceInfo();
        if (io.dcloud.common.util.BaseInfo.SyncDebug) {
            deviceInfo.put("maxMemory", (java.lang.Object) ((java.lang.Runtime.getRuntime().maxMemory() / 1048576) + "M"));
            deviceInfo.put("totalMemory", (java.lang.Object) ((java.lang.Runtime.getRuntime().totalMemory() / 1048576) + "M"));
            deviceInfo.put("appRuningTitme", (java.lang.Object) java.lang.Long.valueOf(io.dcloud.common.util.BaseInfo.splashCloseTime - io.dcloud.common.util.BaseInfo.startTime));
        }
        return deviceInfo;
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public com.alibaba.fastjson.JSONObject pushDebugData(java.lang.Object obj) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("data", obj);
        return jSONObject;
    }

    @com.taobao.weex.annotation.JSMethod
    public void preloadReady(java.lang.String str) {
        io.dcloud.common.DHInterface.ICallBack preUniMPCallBack = io.dcloud.feature.weex.WeexInstanceMgr.self().getPreUniMPCallBack(str);
        if (preUniMPCallBack != null) {
            preUniMPCallBack.onCallBack(1, str);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void evalJSFiles(java.lang.String str, final com.taobao.weex.bridge.JSCallback jSCallback) {
        final java.util.HashMap map = new java.util.HashMap();
        if (str == null) {
            if (jSCallback != null) {
                map.put("type", -1);
                map.put(androidx.core.app.NotificationCompat.CATEGORY_MESSAGE, io.dcloud.application.DCLoudApplicationImpl.self().getContext().getString(com.taobao.weex.R.string.dcloud_feature_weex_msg_param_empty));
                jSCallback.invoke(map);
                return;
            }
            return;
        }
        final com.alibaba.fastjson.JSONArray array = com.alibaba.fastjson.JSON.parseArray(str);
        if (array != null) {
            io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.extend.PlusModule.1
                @Override // java.lang.Runnable
                public void run() {
                    java.io.InputStream fileInputStream;
                    io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(io.dcloud.feature.weex.extend.PlusModule.this.mWXSDKInstance);
                    if (iWebviewFindWebview == null) {
                        if (jSCallback != null) {
                            map.put("type", -1);
                            map.put(androidx.core.app.NotificationCompat.CATEGORY_MESSAGE, io.dcloud.application.DCLoudApplicationImpl.self().getContext().getString(com.taobao.weex.R.string.dcloud_feature_weex_msg_page_destroyed));
                            jSCallback.invoke(map);
                            return;
                        }
                        return;
                    }
                    byte bObtainRunningAppMode = iWebviewFindWebview.obtainApp().obtainRunningAppMode();
                    java.lang.String str2 = "";
                    for (int i = 0; i < array.size(); i++) {
                        java.lang.String string = array.getString(i);
                        java.io.File file = new java.io.File(string);
                        if (file.exists()) {
                            try {
                                fileInputStream = new java.io.FileInputStream(file);
                            } catch (java.io.FileNotFoundException e) {
                                e.printStackTrace();
                                fileInputStream = null;
                            }
                        } else {
                            if (!string.startsWith("/storage") && bObtainRunningAppMode == 1) {
                                string = iWebviewFindWebview.obtainApp().convert2AbsFullPath(iWebviewFindWebview.obtainFullUrl(), string);
                                if (string.startsWith("/")) {
                                    string = string.substring(1, string.length());
                                }
                            } else {
                                string = iWebviewFindWebview.obtainApp().convert2WebviewFullPath(iWebviewFindWebview.obtainFullUrl(), string);
                            }
                            fileInputStream = io.dcloud.common.adapter.ui.webview.WebResUtil.getEncryptionInputStream(string, iWebviewFindWebview.obtainApp());
                        }
                        if (fileInputStream != null) {
                            try {
                                java.lang.String str3 = new java.lang.String(io.dcloud.common.util.IOUtil.toString(fileInputStream));
                                if (!android.text.TextUtils.isEmpty(str3)) {
                                    str2 = str2 + str3;
                                }
                            } catch (java.lang.Exception unused) {
                            }
                        } else if (jSCallback != null) {
                            map.put("type", -1);
                            map.put(androidx.core.app.NotificationCompat.CATEGORY_MESSAGE, string + io.dcloud.application.DCLoudApplicationImpl.self().getContext().getString(com.taobao.weex.R.string.dcloud_feature_weex_msg_cannot_find_file_by_path));
                            jSCallback.invoke(map);
                        }
                    }
                    if (android.text.TextUtils.isEmpty(str2)) {
                        return;
                    }
                    com.taobao.weex.bridge.WXBridgeManager.getInstance().syncExecJsOnInstanceWithResult(io.dcloud.feature.weex.extend.PlusModule.this.mWXSDKInstance.getInstanceId(), str2, -1);
                    if (jSCallback != null) {
                        map.put("type", 1);
                        jSCallback.invoke(map);
                    }
                }
            }, true);
        } else if (jSCallback != null) {
            map.put("type", -1);
            map.put(androidx.core.app.NotificationCompat.CATEGORY_MESSAGE, io.dcloud.application.DCLoudApplicationImpl.self().getContext().getString(com.taobao.weex.R.string.dcloud_feature_weex_msg_param_invalid));
            jSCallback.invoke(map);
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void getHostInfo(com.taobao.weex.bridge.JSCallback jSCallback) {
        com.alibaba.fastjson.JSONObject object;
        if (jSCallback == null) {
            return;
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(this.mWXSDKInstance);
        if (iWebviewFindWebview == null || iWebviewFindWebview.obtainApp() == null) {
            jSCallback.invoke(jSONObject);
            return;
        }
        java.lang.String strObtainAppInfo = iWebviewFindWebview.obtainApp().obtainAppInfo();
        if (io.dcloud.common.util.PdrUtil.isEmpty(strObtainAppInfo)) {
            jSCallback.invoke(jSONObject);
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isUniMPHostForUniApp()) {
            if (io.dcloud.feature.internal.sdk.SDK.isUniMP) {
                if (!io.dcloud.common.util.PdrUtil.isEmpty(io.dcloud.feature.internal.sdk.SDK.mHostInfo) && (object = com.alibaba.fastjson.JSON.parseObject(io.dcloud.feature.internal.sdk.SDK.mHostInfo)) != null) {
                    jSONObject.putAll(object);
                }
            } else {
                com.alibaba.fastjson.JSONObject object2 = com.alibaba.fastjson.JSON.parseObject(strObtainAppInfo);
                if (object2 != null) {
                    jSONObject.putAll(object2);
                }
            }
        }
        jSONObject.put("nativeName", (java.lang.Object) io.dcloud.common.adapter.util.AndroidResources.appName);
        jSONObject.put("nativeAppid", (java.lang.Object) io.dcloud.common.adapter.util.AndroidResources.packageName);
        jSONObject.put("nativeVersionName", (java.lang.Object) io.dcloud.common.adapter.util.AndroidResources.versionName);
        jSONObject.put("nativeVersionCode", (java.lang.Object) java.lang.Integer.valueOf(io.dcloud.common.adapter.util.AndroidResources.versionCode));
        jSCallback.invoke(jSONObject);
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public int getAppState() {
        io.dcloud.common.DHInterface.IActivityHandler iActivityHandler;
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(this.mWXSDKInstance);
        if (iWebviewFindWebview == null || (iActivityHandler = io.src.dcloud.adapter.DCloudAdapterUtil.getIActivityHandler(iWebviewFindWebview.getActivity())) == null) {
            return 0;
        }
        return iActivityHandler.getActivityState();
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public com.alibaba.fastjson.JSONObject getSystemInfoSync() {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        try {
            io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(this.mWXSDKInstance);
            if (iWebviewFindWebview != null && iWebviewFindWebview.obtainApp() != null) {
                jSONObject = com.alibaba.fastjson.JSON.parseObject(iWebviewFindWebview.obtainApp().getSystemInfo());
                boolean zBooleanValue = io.dcloud.common.adapter.util.DeviceInfo.isSystemNightMode(iWebviewFindWebview.getActivity()).booleanValue();
                java.lang.String str = io.dcloud.common.ui.blur.DCBlurDraweeView.DARK;
                jSONObject.put("osTheme", zBooleanValue ? io.dcloud.common.ui.blur.DCBlurDraweeView.DARK : io.dcloud.common.ui.blur.DCBlurDraweeView.LIGHT);
                jSONObject.put("ua", (java.lang.Object) iWebviewFindWebview.getWebviewProperty(io.dcloud.common.DHInterface.IWebview.USER_AGENT));
                if (io.dcloud.common.adapter.util.DeviceInfo.oaids != null) {
                    java.lang.String[] strArrSplit = io.dcloud.common.adapter.util.DeviceInfo.oaids.split("\\|");
                    jSONObject.put("oaid", (java.lang.Object) (strArrSplit.length > 0 ? strArrSplit[0] : ""));
                } else {
                    jSONObject.put("oaid", (java.lang.Object) "");
                }
                jSONObject.put("browserVersion", (java.lang.Object) io.dcloud.common.adapter.ui.webview.WebViewFactory.getWebViewUserAgentVersion(iWebviewFindWebview.getContext()));
                java.lang.String str2 = "portrait";
                if (iWebviewFindWebview.getActivity().getResources().getConfiguration().orientation == 2) {
                    str2 = "landscape";
                }
                jSONObject.put("deviceOrientation", (java.lang.Object) str2);
                jSONObject.put("deviceId", (java.lang.Object) io.dcloud.common.util.TelephonyUtil.getDCloudDeviceID(iWebviewFindWebview.getActivity()));
                if (io.dcloud.feature.internal.sdk.SDK.isUniMP) {
                    jSONObject.put("hostPackageName", (java.lang.Object) iWebviewFindWebview.getContext().getPackageName());
                    jSONObject.put("hostVersion", (java.lang.Object) io.dcloud.common.adapter.util.AndroidResources.versionName);
                    jSONObject.put("hostName", (java.lang.Object) io.dcloud.common.adapter.util.AndroidResources.appName);
                    if (io.dcloud.common.util.PdrUtil.isEquals("auto", io.dcloud.feature.internal.sdk.SDK.hostAppThemeDark)) {
                        if (!io.dcloud.common.adapter.util.DeviceInfo.isSystemNightMode(iWebviewFindWebview.getContext()).booleanValue()) {
                            str = io.dcloud.common.ui.blur.DCBlurDraweeView.LIGHT;
                        }
                    } else {
                        str = io.dcloud.feature.internal.sdk.SDK.hostAppThemeDark;
                    }
                    jSONObject.put("hostTheme", (java.lang.Object) str);
                    if (io.dcloud.common.util.PdrUtil.isUniMPHostForUniApp()) {
                        jSONObject.put("hostLanguage", (java.lang.Object) io.dcloud.common.util.language.LanguageUtil.getDeviceDefLocalLanguage());
                        boolean z = io.dcloud.feature.internal.sdk.SDK.isUniMP;
                        return jSONObject;
                    }
                    jSONObject.put("hostLanguage", (java.lang.Object) io.dcloud.common.util.language.LanguageUtil.getDeviceDefLocalLanguage());
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return jSONObject;
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void getSystemInfo(io.dcloud.feature.uniapp.bridge.UniJSCallback uniJSCallback) {
        uniJSCallback.invoke(getSystemInfoSync());
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public com.alibaba.fastjson.JSONObject getSystemSetting() {
        android.content.Context context = this.mWXSDKInstance.getContext();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        try {
            jSONObject.put("bluetoothEnabled", (java.lang.Object) java.lang.Boolean.valueOf(io.dcloud.common.adapter.util.DeviceInfo.blueToothEnable(context)));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            jSONObject.put("bluetoothError", (java.lang.Object) "Missing permissions required by BluetoothAdapter.isEnabled: android.permission.BLUETOOTH");
        }
        jSONObject.put("locationEnabled", (java.lang.Object) java.lang.Boolean.valueOf(io.dcloud.common.adapter.util.DeviceInfo.locationEnable(context)));
        try {
            jSONObject.put("wifiEnabled", (java.lang.Object) java.lang.Boolean.valueOf(io.dcloud.common.adapter.util.DeviceInfo.wifiEnable(context)));
        } catch (java.lang.Exception unused) {
            jSONObject.put("wifiError", (java.lang.Object) "Missing permissions required by WifiManager.isWifiEnabled: android.permission.ACCESS_WIFI_STATE");
        }
        jSONObject.put("deviceOrientation", (java.lang.Object) io.dcloud.common.adapter.util.DeviceInfo.deviceOrientation(context));
        return jSONObject;
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public com.alibaba.fastjson.JSONObject getAppAuthorizeSetting() {
        android.content.Context context = this.mWXSDKInstance.getContext();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        boolean zCheckPermissions = io.dcloud.common.adapter.util.PermissionUtil.checkPermissions(context, new java.lang.String[]{com.hjq.permissions.Permission.CAMERA});
        java.lang.String str = io.dcloud.common.DHInterface.IApp.AUTHORITY_AUTHORIZED;
        java.lang.Object obj = zCheckPermissions ? io.dcloud.common.DHInterface.IApp.AUTHORITY_AUTHORIZED : io.dcloud.common.DHInterface.IApp.AUTHORITY_DENIED;
        if (!zCheckPermissions && !io.dcloud.common.adapter.util.PermissionUtil.hasDefinedInManifest(context, com.hjq.permissions.Permission.CAMERA)) {
            obj = "config error";
        }
        jSONObject.put("cameraAuthorized", obj);
        boolean zCheckPermissions2 = io.dcloud.common.adapter.util.PermissionUtil.checkPermissions(context, new java.lang.String[]{com.hjq.permissions.Permission.ACCESS_COARSE_LOCATION});
        java.lang.Object obj2 = zCheckPermissions2 ? io.dcloud.common.DHInterface.IApp.AUTHORITY_AUTHORIZED : io.dcloud.common.DHInterface.IApp.AUTHORITY_DENIED;
        if (!zCheckPermissions2 && !io.dcloud.common.adapter.util.PermissionUtil.hasDefinedInManifest(context, com.hjq.permissions.Permission.ACCESS_COARSE_LOCATION)) {
            obj2 = "config error";
        }
        jSONObject.put("locationAuthorized", obj2);
        boolean zCheckPermissions3 = io.dcloud.common.adapter.util.PermissionUtil.checkPermissions(context, new java.lang.String[]{com.hjq.permissions.Permission.ACCESS_FINE_LOCATION});
        java.lang.String str2 = zCheckPermissions2 ? "reduced" : "unsupported";
        if (zCheckPermissions2 && zCheckPermissions3) {
            str2 = "full";
        }
        jSONObject.put("locationAccuracy", (java.lang.Object) str2);
        boolean zCheckPermissions4 = io.dcloud.common.adapter.util.PermissionUtil.checkPermissions(context, new java.lang.String[]{com.hjq.permissions.Permission.RECORD_AUDIO});
        jSONObject.put("microphoneAuthorized", (java.lang.Object) ((zCheckPermissions4 || io.dcloud.common.adapter.util.PermissionUtil.hasDefinedInManifest(context, com.hjq.permissions.Permission.RECORD_AUDIO)) ? zCheckPermissions4 ? io.dcloud.common.DHInterface.IApp.AUTHORITY_AUTHORIZED : io.dcloud.common.DHInterface.IApp.AUTHORITY_DENIED : "config error"));
        if (!androidx.core.app.NotificationManagerCompat.from(context).areNotificationsEnabled()) {
            str = io.dcloud.common.DHInterface.IApp.AUTHORITY_DENIED;
        }
        jSONObject.put("notificationAuthorized", (java.lang.Object) str);
        jSONObject.put("albumAuthorized", (java.lang.Object) com.taobao.weex.common.Constants.Name.UNDEFINED);
        jSONObject.put("bluetoothAuthorized", (java.lang.Object) com.taobao.weex.common.Constants.Name.UNDEFINED);
        jSONObject.put("locationReducedAccuracy", (java.lang.Object) com.taobao.weex.common.Constants.Name.UNDEFINED);
        jSONObject.put("notificationAlertAuthorized", (java.lang.Object) com.taobao.weex.common.Constants.Name.UNDEFINED);
        jSONObject.put("notificationBadgeAuthorized", (java.lang.Object) com.taobao.weex.common.Constants.Name.UNDEFINED);
        jSONObject.put("notificationSoundAuthorized", (java.lang.Object) com.taobao.weex.common.Constants.Name.UNDEFINED);
        return jSONObject;
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void openAppAuthorizeSetting(com.taobao.weex.bridge.JSCallback jSCallback) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        try {
            android.content.Context context = this.mWXSDKInstance.getContext();
            android.content.Intent intent = new android.content.Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(android.net.Uri.fromParts("package", context.getPackageName(), null));
            context.startActivity(intent);
            jSONObject.put("type", (java.lang.Object) com.taobao.weex.ui.component.WXImage.SUCCEED);
            jSONObject.put("code", (java.lang.Object) 0);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            jSONObject.put("type", (java.lang.Object) com.taobao.weex.common.Constants.Event.FAIL);
        }
        jSCallback.invoke(jSONObject);
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void hasClientKey(com.alibaba.fastjson.JSONObject jSONObject, com.taobao.weex.bridge.JSCallback jSCallback) {
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() || io.dcloud.common.util.BaseInfo.isStandardBase(this.mWXSDKInstance.getContext())) {
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.NOT_SUPPORT_MP_OR_BASE));
            return;
        }
        java.lang.String str = (java.lang.String) jSONObject.get("spaceId");
        java.lang.String str2 = (java.lang.String) jSONObject.get("provider");
        if (io.dcloud.common.util.PdrUtil.isEmpty(str) || io.dcloud.common.util.PdrUtil.isEmpty(str2)) {
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.PARAMS_IS_NULL));
        } else {
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxSuccessResult(java.lang.Boolean.valueOf(!io.dcloud.common.util.PdrUtil.isEmpty(getClientKey(str, str2)))));
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void encryptGetClientKeyPayload(com.alibaba.fastjson.JSONObject jSONObject, com.taobao.weex.bridge.JSCallback jSCallback) {
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() || io.dcloud.common.util.BaseInfo.isStandardBase(this.mWXSDKInstance.getContext())) {
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.NOT_SUPPORT_MP_OR_BASE));
            return;
        }
        if (jSONObject == null || jSCallback == null) {
            if (jSCallback != null) {
                jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.PARAMS_IS_NULL));
                return;
            }
            return;
        }
        java.lang.String metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("dcloud_sn_appkey");
        java.lang.String jSONString = jSONObject.toJSONString();
        if (io.dcloud.common.util.PdrUtil.isEmpty(metaValue)) {
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.APP_KEY_IS_NULL));
            return;
        }
        if (!io.dcloud.common.util.PdrUtil.isEmpty(jSONString)) {
            java.lang.String strEncryptGetClientKeyPayload = com.taobao.weex.bridge.WXBridgeManager.getInstance().encryptGetClientKeyPayload(io.dcloud.common.util.BaseInfo.sDefaultBootApp, jSONString, metaValue);
            if (io.dcloud.common.util.PdrUtil.isEmpty(strEncryptGetClientKeyPayload)) {
                jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.ENCRYPT_CLIENT_KEY_PAYLOAD_ERROR));
                return;
            }
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(strEncryptGetClientKeyPayload);
            if (object != null) {
                jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxSuccessResult(object));
                return;
            } else {
                jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.NATIVE_JSON_FORMAT_ERROR));
                return;
            }
        }
        jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.JSON_FORMAT_ERROR));
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void setClientKey(com.alibaba.fastjson.JSONObject jSONObject, com.taobao.weex.bridge.JSCallback jSCallback) {
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() || io.dcloud.common.util.BaseInfo.isStandardBase(this.mWXSDKInstance.getContext())) {
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.NOT_SUPPORT_MP_OR_BASE));
            return;
        }
        if (jSONObject == null) {
            if (jSCallback != null) {
                jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.PARAMS_IS_NULL));
                return;
            }
            return;
        }
        java.lang.String metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("dcloud_sn_appkey");
        java.lang.String jSONString = jSONObject.toJSONString();
        java.lang.String str = (java.lang.String) jSONObject.get("spaceId");
        java.lang.String str2 = (java.lang.String) jSONObject.get("provider");
        if (io.dcloud.common.util.PdrUtil.isEmpty(str) || io.dcloud.common.util.PdrUtil.isEmpty(str2)) {
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.PARAMS_IS_NULL));
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(metaValue)) {
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.APP_KEY_IS_NULL));
            return;
        }
        if (com.taobao.weex.bridge.WXBridgeManager.getInstance().verifyClientKeyPayload(io.dcloud.common.util.BaseInfo.sDefaultBootApp, metaValue, jSONString)) {
            android.content.SharedPreferences.Editor editorEdit = this.mWXSDKInstance.getContext().getSharedPreferences(HELP_LOG_HASH + io.dcloud.common.util.BaseInfo.sDefaultBootApp + str2 + str, 0).edit();
            editorEdit.putString("HELP_LOG_HASH", jSONString);
            editorEdit.commit();
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxSuccessResult(true));
            return;
        }
        jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.CLIENT_KEY_ILLEGAL));
    }

    private java.lang.String getClientKey(java.lang.String str, java.lang.String str2) {
        return this.mWXSDKInstance.getContext().getSharedPreferences(HELP_LOG_HASH + io.dcloud.common.util.BaseInfo.sDefaultBootApp + str2 + str, 0).getString("HELP_LOG_HASH", "");
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void encrypt(com.alibaba.fastjson.JSONObject jSONObject, com.taobao.weex.bridge.JSCallback jSCallback) {
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() || io.dcloud.common.util.BaseInfo.isStandardBase(this.mWXSDKInstance.getContext())) {
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.NOT_SUPPORT_MP_OR_BASE));
            return;
        }
        if (jSONObject == null || jSCallback == null) {
            if (jSCallback != null) {
                jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.PARAMS_IS_NULL));
                return;
            }
            return;
        }
        java.lang.String metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("dcloud_sn_appkey");
        java.lang.String str = (java.lang.String) jSONObject.get("data");
        java.lang.String str2 = (java.lang.String) jSONObject.get("spaceId");
        java.lang.String str3 = (java.lang.String) jSONObject.get("provider");
        if (io.dcloud.common.util.PdrUtil.isEmpty(str) || io.dcloud.common.util.PdrUtil.isEmpty(str2) || io.dcloud.common.util.PdrUtil.isEmpty(str3)) {
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.PARAMS_IS_NULL));
            return;
        }
        java.lang.String clientKey = getClientKey(str2, str3);
        if (io.dcloud.common.util.PdrUtil.isEmpty(metaValue)) {
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.APP_KEY_IS_NULL));
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(clientKey)) {
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.CLIENT_KEY_IS_NULL));
            return;
        }
        java.lang.String strEncrypt = com.taobao.weex.bridge.WXBridgeManager.getInstance().encrypt(io.dcloud.common.util.BaseInfo.sDefaultBootApp, str, metaValue, clientKey);
        if (io.dcloud.common.util.PdrUtil.isEmpty(strEncrypt)) {
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.ENCRYPT_ERROR));
        } else {
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxSuccessResult(com.alibaba.fastjson.JSON.parse(strEncrypt)));
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void decrypt(com.alibaba.fastjson.JSONObject jSONObject, com.taobao.weex.bridge.JSCallback jSCallback) {
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() || io.dcloud.common.util.BaseInfo.isStandardBase(this.mWXSDKInstance.getContext())) {
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.NOT_SUPPORT_MP_OR_BASE));
            return;
        }
        if (jSONObject == null || jSCallback == null) {
            if (jSCallback != null) {
                jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.PARAMS_IS_NULL));
                return;
            }
            return;
        }
        java.lang.String metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("dcloud_sn_appkey");
        java.lang.String str = (java.lang.String) jSONObject.get("data");
        java.lang.String str2 = (java.lang.String) jSONObject.get(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY);
        java.lang.String str3 = (java.lang.String) jSONObject.get("spaceId");
        java.lang.String str4 = (java.lang.String) jSONObject.get("provider");
        if (io.dcloud.common.util.PdrUtil.isEmpty(str) || io.dcloud.common.util.PdrUtil.isEmpty(str2) || io.dcloud.common.util.PdrUtil.isEmpty(str3) || io.dcloud.common.util.PdrUtil.isEmpty(str4)) {
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.PARAMS_IS_NULL));
            return;
        }
        java.lang.String clientKey = getClientKey(str3, str4);
        if (io.dcloud.common.util.PdrUtil.isEmpty(metaValue)) {
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.APP_KEY_IS_NULL));
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(clientKey)) {
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.CLIENT_KEY_IS_NULL));
            return;
        }
        java.lang.String strDecrypt = com.taobao.weex.bridge.WXBridgeManager.getInstance().decrypt(io.dcloud.common.util.BaseInfo.sDefaultBootApp, jSONObject.toJSONString(), metaValue, clientKey);
        if (io.dcloud.common.util.PdrUtil.isEmpty(strDecrypt)) {
            jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxFailResult(io.dcloud.feature.weex.extend.result.SecureNetworkResult.DECRYPT_ERROR));
            return;
        }
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("data", (java.lang.Object) strDecrypt);
        jSCallback.invoke(io.dcloud.feature.weex.extend.result.Result.boxSuccessResult(jSONObject2));
    }
}
