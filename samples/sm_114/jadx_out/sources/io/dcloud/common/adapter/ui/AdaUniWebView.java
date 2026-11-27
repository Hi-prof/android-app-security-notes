package io.dcloud.common.adapter.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class AdaUniWebView extends io.dcloud.common.adapter.ui.AdaWebview {
    io.dcloud.common.adapter.util.MessageHandler.IMessages iMessages;
    boolean isUniService;
    io.dcloud.common.DHInterface.IApp mApp;
    java.lang.String mFullUrl;
    float mScale;
    io.dcloud.common.DHInterface.IUniNView mUniNView;
    java.lang.String mUrl;
    private java.lang.String mUserAgent;
    android.view.ViewGroup mViewImpl;
    io.dcloud.common.DHInterface.AbsMgr mWinMgr;

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public AdaUniWebView(android.content.Context context, io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.adapter.ui.AdaFrameView adaFrameView, java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject, boolean z) {
        super(context);
        this.mWinMgr = null;
        this.mScale = 3.0f;
        this.mUserAgent = null;
        this.isUniService = false;
        this.iMessages = new io.dcloud.common.adapter.util.MessageHandler.IMessages() { // from class: io.dcloud.common.adapter.ui.AdaUniWebView.1
            @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
            public void execute(java.lang.Object obj) {
                java.lang.Object[] objArr = (java.lang.Object[]) obj;
                io.dcloud.common.adapter.ui.AdaUniWebView.this.exec(java.lang.String.valueOf(objArr[0]), java.lang.String.valueOf(objArr[1]), (org.json.JSONArray) objArr[2]);
            }
        };
        str = str == null ? "" : str;
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            jSONObject2.put("js", str);
            jSONObject2.put("data", jSONObject);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        this.isUniService = z;
        this.mApp = iApp;
        this.mFrameView = adaFrameView;
        this.mAppid = iApp.obtainAppId();
        initSitemapState();
        this.mUrl = str;
        this.mFullUrl = android.text.TextUtils.isEmpty(str) ? this.mUrl : this.mApp.convert2WebviewFullPath(null, this.mUrl);
        this.mWinMgr = adaFrameView.obtainWindowMgr();
        this.mScale = context.getResources().getDisplayMetrics().density;
        this.mWebViewParent = new io.dcloud.common.adapter.ui.AdaWebViewParent(context, false);
        initUserAgent(iApp);
        io.dcloud.common.DHInterface.IUniNView iUniNView = (io.dcloud.common.DHInterface.IUniNView) this.mWinMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iApp, "weex,io.dcloud.feature.weex.WeexFeature", "createUniNView", new java.lang.Object[]{this, this.mWebViewParent.obtainMainViewGroup(), jSONObject2, str2}});
        this.mUniNView = iUniNView;
        if (iUniNView != null) {
            android.view.ViewGroup viewGroupObtainMainView = iUniNView.obtainMainView();
            this.mViewImpl = viewGroupObtainMainView;
            setMainView(viewGroupObtainMainView);
        }
        this.mWebViewParent.fillsWithWebview(this);
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public void addJsInterface(java.lang.String str, io.dcloud.common.DHInterface.IJsInterface iJsInterface) {
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview
    public void addJsInterface(java.lang.String str, java.lang.Object obj) {
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public void addJsInterface(java.lang.String str, java.lang.String str2) {
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public boolean canGoBack() {
        return false;
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public boolean canGoForward() {
        return false;
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.adapter.ui.AdaContainerFrameItem, io.dcloud.common.adapter.ui.AdaFrameItem
    public void dispose() {
        super.dispose();
        this.mUniNView = null;
        this.mViewImpl = null;
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public void endWebViewEvent(java.lang.String str) {
        if (!io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.PULL_DOWN_REFRESH)) {
            super.endWebViewEvent(str);
            return;
        }
        io.dcloud.common.DHInterface.IUniNView iUniNView = this.mUniNView;
        if (iUniNView != null) {
            iUniNView.endPullToRefresh();
        }
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public void evalJS(java.lang.String str) {
        evalJSToUniNative(str);
    }

    public void evalJSToUniNative(java.lang.String str) {
        if (this.mUniNView == null || io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            return;
        }
        java.util.HashMap map = new java.util.HashMap();
        map.put("data", str);
        this.mUniNView.fireGlobalEvent("nativeToUniJs", map);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public java.lang.String exec(java.lang.String str, java.lang.String str2, org.json.JSONArray jSONArray) {
        if (getContext() == null) {
            return "";
        }
        try {
            if ("syncExecMethod".equalsIgnoreCase(str2)) {
                str2 = io.dcloud.common.constant.AbsoluteConst.UNI_SYNC_EXEC_METHOD;
            }
            return java.lang.String.valueOf(this.mWinMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 1, new java.lang.Object[]{this, str, str2, jSONArray}));
        } catch (java.lang.Exception e) {
            io.dcloud.common.adapter.util.Logger.w("JsInterfaceImpl.exec pApiFeatureName=" + str + ";pActionName=" + str2 + ";pArgs=" + java.lang.String.valueOf(jSONArray), e);
            return null;
        }
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public void executeScript(java.lang.String str) {
        evalJS(str);
    }

    public void fireEvent(io.dcloud.common.adapter.util.EventActionInfo eventActionInfo) {
        if (this.mUniNView == null || eventActionInfo == null) {
            return;
        }
        if (!android.text.TextUtils.isEmpty(eventActionInfo.getEvalJs())) {
            evalJSToUniNative(eventActionInfo.getEvalJs());
        }
        this.mUniNView.fireGlobalEvent(eventActionInfo.getEventAction(), eventActionInfo.getParams());
    }

    public java.lang.Object getConfigInfo() {
        if (io.dcloud.common.adapter.util.DeviceInfo.sNetWorkInited) {
            io.dcloud.common.adapter.util.DeviceInfo.initGsmCdmaCell();
        }
        java.util.HashMap map = new java.util.HashMap();
        map.put("__HtMl_Id__", getWebviewUUID());
        if (io.dcloud.common.core.permission.PermissionControler.checkPermission(this.mApp.obtainAppId(), io.dcloud.common.DHInterface.IFeature.F_DEVICE.toLowerCase(java.util.Locale.ENGLISH)) || !this.mApp.manifestBeParsed()) {
            java.util.HashMap map2 = new java.util.HashMap();
            map2.put("imei", io.dcloud.common.adapter.util.DeviceInfo.sIMEI);
            map2.put("imsi", io.dcloud.common.adapter.util.DeviceInfo.sIMSI);
            map2.put("model", io.dcloud.common.adapter.util.DeviceInfo.sModel);
            map2.put("vendor", io.dcloud.common.adapter.util.DeviceInfo.sVendor);
            map2.put("uuid", io.dcloud.common.util.TelephonyUtil.getIMEI(this.mApp.getActivity(), false));
            map.put("device", map2);
            java.util.HashMap map3 = new java.util.HashMap();
            map3.put("language", io.dcloud.common.util.language.LanguageUtil.getDeviceDefLocalLanguage());
            map3.put("version", android.os.Build.VERSION.RELEASE);
            map3.put("name", com.taobao.weex.utils.tools.TimeCalculator.PLATFORM_ANDROID);
            map3.put("vendor", "Google");
            map.put(com.taobao.weex.common.WXConfig.os, map3);
            int i = this.mApp.getInt(2);
            int i2 = this.mApp.getInt(0);
            int i3 = this.mApp.getInt(1);
            java.util.HashMap map4 = new java.util.HashMap();
            float scale = getScale();
            map4.put("resolutionHeight", java.lang.Integer.valueOf((int) (i / scale)));
            int i4 = (int) (i2 / scale);
            map4.put("resolutionWidth", java.lang.Integer.valueOf(i4));
            map4.put("scale", java.lang.Float.valueOf(scale));
            map4.put("dpiX", java.lang.Float.valueOf(io.dcloud.common.adapter.util.DeviceInfo.dpiX));
            map4.put("dpiY", java.lang.Float.valueOf(io.dcloud.common.adapter.util.DeviceInfo.dpiY));
            map4.put("height", java.lang.Integer.valueOf(i));
            map4.put("width", java.lang.Integer.valueOf(i2));
            map.put("screen", map4);
            java.util.HashMap map5 = new java.util.HashMap();
            map5.put("resolutionHeight", java.lang.Integer.valueOf((int) (i3 / scale)));
            map5.put("resolutionWidth", java.lang.Integer.valueOf(i4));
            map.put("display", map5);
        }
        if (io.dcloud.common.core.permission.PermissionControler.checkPermission(this.mApp.obtainAppId(), io.dcloud.common.DHInterface.IFeature.F_RUNTIME) || !this.mApp.manifestBeParsed()) {
            java.lang.String strObtainConfigProperty = this.mApp.obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LOADED_TIME);
            java.util.HashMap map6 = new java.util.HashMap();
            map6.put("innerVersion", "1.9.9.82680");
            map6.put("appid", this.mApp.obtainAppId());
            map6.put("launchLoadedTime", strObtainConfigProperty);
            if (io.dcloud.common.util.BaseInfo.ISAMU) {
                map6.put("version", this.mApp.obtainAppVersionName());
            } else {
                map6.put("version", io.dcloud.common.adapter.util.AndroidResources.mApplicationInfo.versionName);
            }
            map6.put("arguments", this.mApp.obtainRuntimeArgs(false));
            map6.put("launcher", io.dcloud.common.util.BaseInfo.getLauncherData(this.mApp.obtainAppId()));
            map6.put(io.dcloud.common.constant.AbsoluteConst.XML_CHANNEL, io.dcloud.common.util.BaseInfo.getAnalysisChannel());
            map6.put("startupTime", java.lang.String.valueOf(io.dcloud.common.util.BaseInfo.getStartupTimeData(this.mApp.obtainAppId())));
            map6.put("processId", java.lang.Long.valueOf(io.dcloud.common.util.BaseInfo.sProcessId));
            map6.put("uniVersion", io.dcloud.common.util.BaseInfo.uniVersionV3);
            map6.put("versionCode", java.lang.Integer.valueOf(io.dcloud.common.adapter.util.AndroidResources.versionCode));
            java.lang.String bundleData = io.dcloud.common.adapter.util.SP.getBundleData(this.mApp.getActivity(), "pdr", this.mApp.obtainAppId() + io.dcloud.common.constant.AbsoluteConst.LAUNCHTYPE);
            if (android.text.TextUtils.isEmpty(bundleData)) {
                bundleData = "default";
            }
            map6.put("origin", bundleData);
            map.put("runtime", map6);
        }
        java.util.HashMap map7 = new java.util.HashMap();
        map7.put("__isUniPush__", java.lang.Boolean.valueOf(io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_UNIPUSH")));
        map.put("push", map7);
        return map;
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public java.lang.String getCookie(java.lang.String str) {
        return io.dcloud.common.adapter.ui.webview.WebViewFactory.isIsOtherInitSuccess() ? dc.squareup.cookie.CookieCenter.getCookies(str) : android.webkit.CookieManager.getInstance().getCookie(str);
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public java.lang.String getOriginalUrl() {
        return this.mUrl;
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public float getScale() {
        return this.mScale;
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public float getScaleOfOpenerWebview() {
        return 0.0f;
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public java.lang.String getTitle() {
        return "";
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public java.lang.String getWebviewProperty(java.lang.String str) {
        return io.dcloud.common.DHInterface.IWebview.USER_AGENT.equals(str) ? this.mUserAgent : super.getWebviewProperty(str);
    }

    void initUserAgent(io.dcloud.common.DHInterface.IApp iApp) {
        java.lang.String str;
        if (!io.dcloud.common.util.PdrUtil.isEmpty(io.dcloud.common.adapter.ui.AdaWebview.sCustomUserAgent)) {
            this.mUserAgent = io.dcloud.common.adapter.ui.AdaWebview.sCustomUserAgent;
            return;
        }
        this.mUserAgent = io.dcloud.common.adapter.ui.webview.WebViewFactory.getDefWebViewUA(getContext());
        java.lang.String strObtainConfigProperty = iApp.obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_USER_AGENT);
        boolean z = java.lang.Boolean.parseBoolean(iApp.obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CONCATENATE));
        if (java.lang.Boolean.parseBoolean(iApp.obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_funSetUA))) {
            z = false;
        }
        if (!z && !io.dcloud.common.util.PdrUtil.isEmpty(strObtainConfigProperty)) {
            this.mUserAgent = strObtainConfigProperty;
        } else if (!io.dcloud.common.util.PdrUtil.isEmpty(strObtainConfigProperty)) {
            this.mUserAgent += com.taobao.weex.el.parse.Operators.SPACE_STR + strObtainConfigProperty.trim();
        }
        boolean z2 = java.lang.Boolean.parseBoolean(iApp.obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_H5PLUS));
        boolean zBooleanValue = java.lang.Boolean.valueOf(iApp.obtainConfigProperty(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED)).booleanValue();
        if (iApp.obtainStatusBarMgr() == null || !iApp.obtainStatusBarMgr().checkImmersedStatusBar(getActivity(), zBooleanValue)) {
            str = "";
        } else {
            str = " (Immersed/" + (io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight / this.mScale) + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
        }
        if (z2 && this.mUserAgent.indexOf(io.dcloud.common.adapter.ui.webview.DCWebView.UserAgentExtInfo) < 0) {
            if (io.dcloud.common.util.BaseInfo.ISAMU && io.dcloud.common.util.BaseInfo.isBase(getContext())) {
                this.mUserAgent += " Html5Plus/1.0 StreamApp/1.0" + str;
            } else {
                this.mUserAgent += io.dcloud.common.adapter.ui.webview.DCWebView.UserAgentExtInfo + str;
            }
        }
        dc.squareup.HttpConstants.setUA(this.mUserAgent);
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public boolean isUniService() {
        return this.isUniService;
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public boolean isUniWebView() {
        return true;
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public void loadContentData(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public void loadUrl(java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isNetPath(str) || io.dcloud.common.util.PdrUtil.isFilePath(str)) {
            return;
        }
        evalJS(str);
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public io.dcloud.common.DHInterface.IApp obtainApp() {
        return this.mApp;
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public io.dcloud.common.DHInterface.IFrameView obtainFrameView() {
        return this.mFrameView;
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public java.lang.String obtainFullUrl() {
        return this.mFullUrl;
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public java.lang.String obtainPageTitle() {
        return "";
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public java.lang.String obtainUrl() {
        return this.mUrl;
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public android.webkit.WebView obtainWebview() {
        return null;
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public android.view.ViewGroup obtainWindowView() {
        return this.mViewImpl;
    }

    public java.lang.String prompt(java.lang.String str, java.lang.String str2) {
        if (str2 != null && str2.length() > 3 && str2.substring(0, 4).equals("pdr:")) {
            try {
                org.json.JSONArray jSONArray = new org.json.JSONArray(str2.substring(4));
                java.lang.String string = jSONArray.getString(0);
                java.lang.String string2 = jSONArray.getString(1);
                boolean z = jSONArray.getBoolean(2);
                org.json.JSONArray jSONArrayCreateJSONArray = io.dcloud.common.util.JSONUtil.createJSONArray(str);
                if (!z) {
                    return exec(string, string2, jSONArrayCreateJSONArray);
                }
                io.dcloud.common.adapter.util.MessageHandler.sendMessage(this.iMessages, new java.lang.Object[]{string, string2, jSONArrayCreateJSONArray});
                return null;
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public void reload(java.lang.String str) {
    }

    public void setNVuePath(java.lang.String str) {
        this.mUrl = str;
        this.mFullUrl = android.text.TextUtils.isEmpty(str) ? this.mUrl : this.mApp.convert2WebviewFullPath(null, this.mUrl);
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public void setOriginalUrl(java.lang.String str) {
        this.mUrl = str;
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public void setWebViewEvent(java.lang.String str, java.lang.Object obj) {
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.PULL_DOWN_REFRESH)) {
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            io.dcloud.common.DHInterface.IUniNView iUniNView = this.mUniNView;
            if (iUniNView != null) {
                iUniNView.initRefresh(jSONObject);
                return;
            }
            return;
        }
        if (!io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_BEGIN)) {
            super.setWebViewEvent(str, obj);
            return;
        }
        io.dcloud.common.DHInterface.IUniNView iUniNView2 = this.mUniNView;
        if (iUniNView2 != null) {
            iUniNView2.beginPullRefresh();
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void show(android.view.animation.Animation animation) {
    }

    public void titleNViewRefresh() {
        io.dcloud.common.DHInterface.IUniNView iUniNView = this.mUniNView;
        if (iUniNView != null) {
            iUniNView.titleNViewRefresh();
        }
    }

    public void updateScreenAndDisplay() {
        if (obtainApp() == null || this.mUniNView == null) {
            return;
        }
        int i = obtainApp().getInt(2);
        int i2 = obtainApp().getInt(0);
        int i3 = obtainApp().getInt(1);
        java.util.HashMap map = new java.util.HashMap();
        float scale = getScale();
        map.put("resolutionHeight", java.lang.Double.valueOf(java.lang.Math.ceil(i / scale)));
        double d = i2 / scale;
        map.put("resolutionWidth", java.lang.Double.valueOf(java.lang.Math.ceil(d)));
        map.put("dpiX", java.lang.Float.valueOf(io.dcloud.common.adapter.util.DeviceInfo.dpiX));
        map.put("dpiY", java.lang.Float.valueOf(io.dcloud.common.adapter.util.DeviceInfo.dpiY));
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put("resolutionHeight", java.lang.Double.valueOf(java.lang.Math.ceil(i3 / scale)));
        map2.put("resolutionWidth", java.lang.Double.valueOf(java.lang.Math.ceil(d)));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str : map.keySet()) {
            sb.append("plus.screen.");
            sb.append(str);
            sb.append("=");
            sb.append(map.get(str));
            sb.append(";");
        }
        for (java.lang.String str2 : map2.keySet()) {
            sb.append("plus.display.");
            sb.append(str2);
            sb.append("=");
            sb.append(map2.get(str2));
            sb.append(";");
        }
        evalJSToUniNative(sb.toString());
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public void evalJS(java.lang.String str, io.dcloud.common.adapter.ui.ReceiveJSValue.ReceiveJSValueCallback receiveJSValueCallback) {
        evalJS(str);
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public void reload() {
        io.dcloud.common.DHInterface.IUniNView iUniNView = this.mUniNView;
        if (iUniNView != null) {
            iUniNView.reload();
        }
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public void reload(boolean z) {
        reload();
    }
}
