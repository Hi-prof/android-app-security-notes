package io.dcloud.feature.weex.adapter.webview;

/* JADX INFO: loaded from: classes2.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXDCWeb extends com.taobao.weex.ui.component.WXWeb {
    io.dcloud.feature.weex.adapter.webview.IDCWebView mDCWebView;
    private com.alibaba.fastjson.JSONObject mWebStyles;

    public interface OnDCMessageListener {
        void onMessage(java.util.Map<java.lang.String, java.lang.Object> map, int i);
    }

    public WXDCWeb(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    @Override // com.taobao.weex.ui.component.WXWeb
    protected void createWebView() {
        java.lang.Object objNewInstance;
        java.lang.String str = null;
        try {
            android.net.Uri uri = android.net.Uri.parse(com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(getInstanceId()).getBundleUrl());
            java.lang.String scheme = uri.getScheme();
            java.lang.String authority = uri.getAuthority();
            if (!android.text.TextUtils.isEmpty(scheme) && !android.text.TextUtils.isEmpty(authority)) {
                str = scheme + "://" + authority;
            }
        } catch (java.lang.Exception unused) {
        }
        if (io.dcloud.common.adapter.ui.webview.WebViewFactory.isIsOtherInitSuccess() && (objNewInstance = io.dcloud.common.adapter.util.PlatformUtil.newInstance("io.dcloud.feature.x5.DCWXX5WebView", new java.lang.Class[]{android.content.Context.class, java.lang.String.class, io.dcloud.feature.weex.adapter.webview.WXDCWeb.class}, new java.lang.Object[]{getInstance().getUIContext(), str, this})) != null && (objNewInstance instanceof com.taobao.weex.ui.view.IWebView)) {
            io.dcloud.feature.weex.adapter.webview.IDCWebView iDCWebView = (io.dcloud.feature.weex.adapter.webview.IDCWebView) objNewInstance;
            this.mDCWebView = iDCWebView;
            this.mWebView = iDCWebView;
        }
        if (this.mWebView == null) {
            io.dcloud.feature.weex.adapter.webview.DCWXWebView dCWXWebView = new io.dcloud.feature.weex.adapter.webview.DCWXWebView(getInstance().getUIContext(), str, this);
            this.mDCWebView = dCWXWebView;
            this.mWebView = dCWXWebView;
        }
    }

    @Override // com.taobao.weex.ui.component.WXWeb, com.taobao.weex.ui.component.WXComponent
    protected android.view.View initComponentHostView(android.content.Context context) {
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(this.mWebView, "setOnDCMessageListener", new java.lang.Class[]{io.dcloud.feature.weex.adapter.webview.WXDCWeb.OnDCMessageListener.class}, new io.dcloud.feature.weex.adapter.webview.WXDCWeb.OnDCMessageListener() { // from class: io.dcloud.feature.weex.adapter.webview.WXDCWeb.1
            @Override // io.dcloud.feature.weex.adapter.webview.WXDCWeb.OnDCMessageListener
            public void onMessage(java.util.Map<java.lang.String, java.lang.Object> map, int i) {
                com.taobao.weex.WXSDKInstance wXSDKInstanceFindWXSDKInstance;
                if (i == 1) {
                    io.dcloud.feature.weex.adapter.webview.WXDCWeb.this.fireEvent("onPostMessage", map);
                } else if (i == 2 && (wXSDKInstanceFindWXSDKInstance = io.dcloud.feature.weex.WeexInstanceMgr.self().findWXSDKInstance("__uniapp__service")) != null) {
                    map.put("ref", io.dcloud.feature.weex.adapter.webview.WXDCWeb.this.getRef());
                    map.put("id", io.dcloud.feature.weex.adapter.webview.WXDCWeb.this.getInstance().getInstanceId());
                    wXSDKInstanceFindWXSDKInstance.fireGlobalEventCallback("WebviewPostMessage", map);
                }
            }
        });
        this.mWebView.setOnErrorListener(new com.taobao.weex.ui.view.IWebView.OnErrorListener() { // from class: io.dcloud.feature.weex.adapter.webview.WXDCWeb.2
            @Override // com.taobao.weex.ui.view.IWebView.OnErrorListener
            public void onError(java.lang.String str, java.lang.Object obj) {
                io.dcloud.feature.weex.adapter.webview.WXDCWeb.this.fireEvent(str, obj);
            }
        });
        this.mWebView.setOnPageListener(new com.taobao.weex.ui.view.IWebView.OnPageListener() { // from class: io.dcloud.feature.weex.adapter.webview.WXDCWeb.3
            @Override // com.taobao.weex.ui.view.IWebView.OnPageListener
            public void onReceivedTitle(java.lang.String str) {
                if (io.dcloud.feature.weex.adapter.webview.WXDCWeb.this.getEvents().contains(com.taobao.weex.common.Constants.Event.RECEIVEDTITLE)) {
                    java.util.HashMap map = new java.util.HashMap();
                    map.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, str);
                    java.util.HashMap map2 = new java.util.HashMap();
                    map2.put("detail", map);
                    io.dcloud.feature.weex.adapter.webview.WXDCWeb.this.fireEvent(com.taobao.weex.common.Constants.Event.RECEIVEDTITLE, (java.util.Map<java.lang.String, java.lang.Object>) map2);
                }
            }

            @Override // com.taobao.weex.ui.view.IWebView.OnPageListener
            public void onPageStart(java.lang.String str) {
                if (io.dcloud.feature.weex.adapter.webview.WXDCWeb.this.getEvents().contains(com.taobao.weex.common.Constants.Event.PAGESTART)) {
                    java.util.HashMap map = new java.util.HashMap();
                    map.put("url", str);
                    java.util.HashMap map2 = new java.util.HashMap();
                    map2.put("detail", map);
                    io.dcloud.feature.weex.adapter.webview.WXDCWeb.this.fireEvent(com.taobao.weex.common.Constants.Event.PAGESTART, (java.util.Map<java.lang.String, java.lang.Object>) map2);
                }
            }

            @Override // com.taobao.weex.ui.view.IWebView.OnPageListener
            public void onPageFinish(java.lang.String str, boolean z, boolean z2) {
                if (io.dcloud.feature.weex.adapter.webview.WXDCWeb.this.getEvents().contains(com.taobao.weex.common.Constants.Event.PAGEFINISH)) {
                    java.util.HashMap map = new java.util.HashMap();
                    map.put("url", str);
                    map.put("canGoBack", java.lang.Boolean.valueOf(z));
                    map.put("canGoForward", java.lang.Boolean.valueOf(z2));
                    java.util.HashMap map2 = new java.util.HashMap();
                    map2.put("detail", map);
                    io.dcloud.feature.weex.adapter.webview.WXDCWeb.this.fireEvent(com.taobao.weex.common.Constants.Event.PAGEFINISH, (java.util.Map<java.lang.String, java.lang.Object>) map2);
                }
            }
        });
        this.mWebView.setOnMessageListener(new com.taobao.weex.ui.view.IWebView.OnMessageListener() { // from class: io.dcloud.feature.weex.adapter.webview.WXDCWeb.4
            @Override // com.taobao.weex.ui.view.IWebView.OnMessageListener
            public void onMessage(java.util.Map<java.lang.String, java.lang.Object> map) {
                java.util.HashMap map2 = new java.util.HashMap();
                map2.put("detail", map);
                io.dcloud.feature.weex.adapter.webview.WXDCWeb.this.fireEvent("message", (java.util.Map<java.lang.String, java.lang.Object>) map2);
            }
        });
        android.view.View view = this.mWebView.getView();
        if (!android.text.TextUtils.isEmpty(io.dcloud.common.adapter.ui.AdaWebview.sCustomUserAgent)) {
            this.mDCWebView.setUserAgent(io.dcloud.common.adapter.ui.AdaWebview.sCustomUserAgent, true);
            return view;
        }
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(getInstance());
        if (iWebviewFindWebview != null) {
            this.mDCWebView.setUserAgent(iWebviewFindWebview.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_USER_AGENT), !java.lang.Boolean.parseBoolean(iWebviewFindWebview.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CONCATENATE)));
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireEvent(java.lang.String str, java.lang.Object obj) {
        if (getEvents().contains("error")) {
            java.util.HashMap map = new java.util.HashMap();
            map.put("type", str);
            map.put("errorMsg", obj);
            java.util.Map<java.lang.String, java.lang.Object> map2 = new java.util.HashMap<>();
            map2.put("detail", map);
            fireEvent("error", map2);
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void evalJs(java.lang.String str) {
        if (this.mWebView != null) {
            if (!str.startsWith("javascript:(function(){")) {
                str = "javascript:(function(){" + str + ";})();";
            }
            this.mWebView.loadUrl(str);
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void evalJS(java.lang.String str) {
        evalJs(str);
    }

    @Override // com.taobao.weex.ui.component.WXWeb
    protected void loadUrl(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && str.startsWith("asset:///")) {
            str = str.replace("asset:///", io.dcloud.feature.internal.sdk.SDK.ANDROID_ASSET);
        }
        super.loadUrl(str);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        if (this.mWebView != null) {
            this.mWebView.onActivityResult(i, i2, intent);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "webviewStyles")
    public void webviewStyles(java.lang.String str) {
        if (this.mWebStyles == null) {
            this.mWebStyles = new com.alibaba.fastjson.JSONObject();
        }
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        if (object == null || !object.containsKey("progress")) {
            return;
        }
        java.lang.Object obj = object.get("progress");
        if (obj instanceof java.lang.Boolean) {
            com.alibaba.fastjson.JSONObject jSONObject = this.mWebStyles;
            java.lang.Boolean bool = (java.lang.Boolean) obj;
            bool.booleanValue();
            jSONObject.put("isProgress", (java.lang.Object) bool);
            return;
        }
        if (obj instanceof com.alibaba.fastjson.JSONObject) {
            com.alibaba.fastjson.JSONObject jSONObject2 = (com.alibaba.fastjson.JSONObject) obj;
            this.mWebStyles.put("isProgress", (java.lang.Object) true);
            if (jSONObject2.containsKey("color")) {
                this.mWebStyles.put("progressColor", (java.lang.Object) jSONObject2.getString("color"));
            }
        }
    }

    public com.alibaba.fastjson.JSONObject getWebStyles() {
        if (this.mWebStyles == null) {
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            this.mWebStyles = jSONObject;
            jSONObject.put("isProgress", (java.lang.Object) true);
        }
        return this.mWebStyles;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void setBackgroundColor(java.lang.String str) {
        super.setBackgroundColor(str);
        if (android.text.TextUtils.isEmpty(str) || this.mDCWebView == null) {
            return;
        }
        int color = com.taobao.weex.utils.WXResourceUtils.getColor(str);
        if (this.mDCWebView.getWebView() != null) {
            this.mDCWebView.getWebView().setBackgroundColor(color);
        }
    }

    @Override // com.taobao.weex.ui.component.WXWeb, com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
        this.mDCWebView = null;
    }
}
