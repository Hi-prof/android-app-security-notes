package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXWeb extends com.taobao.weex.ui.component.WXComponent {
    public static final java.lang.String GO_BACK = "goBack";
    public static final java.lang.String GO_FORWARD = "goForward";
    public static final java.lang.String POST_MESSAGE = "postMessage";
    public static final java.lang.String RELOAD = "reload";
    protected com.taobao.weex.ui.view.IWebView mWebView;

    @java.lang.Deprecated
    public WXWeb(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    public WXWeb(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        createWebView();
    }

    protected void createWebView() {
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
        this.mWebView = new com.taobao.weex.ui.view.WXWebView(getContext(), str);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected android.view.View initComponentHostView(android.content.Context context) {
        this.mWebView.setOnErrorListener(new com.taobao.weex.ui.view.IWebView.OnErrorListener() { // from class: com.taobao.weex.ui.component.WXWeb.1
            @Override // com.taobao.weex.ui.view.IWebView.OnErrorListener
            public void onError(java.lang.String str, java.lang.Object obj) {
                com.taobao.weex.ui.component.WXWeb.this.fireEvent(str, obj);
            }
        });
        this.mWebView.setOnPageListener(new com.taobao.weex.ui.view.IWebView.OnPageListener() { // from class: com.taobao.weex.ui.component.WXWeb.2
            @Override // com.taobao.weex.ui.view.IWebView.OnPageListener
            public void onReceivedTitle(java.lang.String str) {
                if (com.taobao.weex.ui.component.WXWeb.this.getEvents().contains(com.taobao.weex.common.Constants.Event.RECEIVEDTITLE)) {
                    java.util.HashMap map = new java.util.HashMap();
                    map.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, str);
                    com.taobao.weex.ui.component.WXWeb.this.fireEvent(com.taobao.weex.common.Constants.Event.RECEIVEDTITLE, (java.util.Map<java.lang.String, java.lang.Object>) map);
                }
            }

            @Override // com.taobao.weex.ui.view.IWebView.OnPageListener
            public void onPageStart(java.lang.String str) {
                if (com.taobao.weex.ui.component.WXWeb.this.getEvents().contains(com.taobao.weex.common.Constants.Event.PAGESTART)) {
                    java.util.HashMap map = new java.util.HashMap();
                    map.put("url", str);
                    com.taobao.weex.ui.component.WXWeb.this.fireEvent(com.taobao.weex.common.Constants.Event.PAGESTART, (java.util.Map<java.lang.String, java.lang.Object>) map);
                }
            }

            @Override // com.taobao.weex.ui.view.IWebView.OnPageListener
            public void onPageFinish(java.lang.String str, boolean z, boolean z2) {
                if (com.taobao.weex.ui.component.WXWeb.this.getEvents().contains(com.taobao.weex.common.Constants.Event.PAGEFINISH)) {
                    java.util.HashMap map = new java.util.HashMap();
                    map.put("url", str);
                    map.put("canGoBack", java.lang.Boolean.valueOf(z));
                    map.put("canGoForward", java.lang.Boolean.valueOf(z2));
                    com.taobao.weex.ui.component.WXWeb.this.fireEvent(com.taobao.weex.common.Constants.Event.PAGEFINISH, (java.util.Map<java.lang.String, java.lang.Object>) map);
                }
            }
        });
        this.mWebView.setOnMessageListener(new com.taobao.weex.ui.view.IWebView.OnMessageListener() { // from class: com.taobao.weex.ui.component.WXWeb.3
            @Override // com.taobao.weex.ui.view.IWebView.OnMessageListener
            public void onMessage(java.util.Map<java.lang.String, java.lang.Object> map) {
                com.taobao.weex.ui.component.WXWeb.this.fireEvent("message", map);
            }
        });
        return this.mWebView.getView();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
        getWebView().destroy();
        this.mWebView = null;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        switch (str) {
            case "source":
                java.lang.String string = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string != null) {
                    setSource(string);
                }
                return true;
            case "src":
                java.lang.String string2 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string2 != null) {
                    setUrl(string2);
                }
                return true;
            case "show-loading":
                java.lang.Boolean bool = com.taobao.weex.utils.WXUtils.getBoolean(obj, null);
                if (bool != null) {
                    setShowLoading(bool.booleanValue());
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.SHOW_LOADING)
    public void setShowLoading(boolean z) {
        getWebView().setShowLoading(z);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "src")
    public void setUrl(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || getHostView() == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        loadUrl(getInstance().rewriteUri(android.net.Uri.parse(str), "web").toString());
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "source")
    public void setSource(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || getHostView() == null) {
            return;
        }
        loadDataWithBaseURL(str);
    }

    public void setAction(java.lang.String str, java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals(GO_BACK)) {
            goBack();
            return;
        }
        if (str.equals(GO_FORWARD)) {
            goForward();
        } else if (str.equals(RELOAD)) {
            reload();
        } else if (str.equals(POST_MESSAGE)) {
            postMessage(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireEvent(java.lang.String str, java.lang.Object obj) {
        if (getEvents().contains("error")) {
            java.util.HashMap map = new java.util.HashMap();
            map.put("type", str);
            map.put("errorMsg", obj);
            fireEvent("error", (java.util.Map<java.lang.String, java.lang.Object>) map);
        }
    }

    protected void loadUrl(java.lang.String str) {
        getWebView().loadUrl(str);
    }

    private void loadDataWithBaseURL(java.lang.String str) {
        getWebView().loadDataWithBaseURL(str);
    }

    @com.taobao.weex.annotation.JSMethod
    public void reload() {
        getWebView().reload();
    }

    @com.taobao.weex.annotation.JSMethod
    public void goForward() {
        getWebView().goForward();
    }

    @com.taobao.weex.annotation.JSMethod
    public void goBack() {
        getWebView().goBack();
    }

    @com.taobao.weex.annotation.JSMethod
    public void postMessage(java.lang.Object obj) {
        getWebView().postMessage(obj);
    }

    private com.taobao.weex.ui.view.IWebView getWebView() {
        return this.mWebView;
    }
}
