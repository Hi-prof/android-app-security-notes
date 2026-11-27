package io.dcloud.feature.weex.adapter.webview;

/* JADX INFO: loaded from: classes2.dex */
public class DCWXWebView implements io.dcloud.feature.weex.adapter.webview.IDCWebView {
    private static final java.lang.String BRIDGE_NAME = "__dcloud_weex_";
    private static final int POST_MESSAGE = 1;
    private static final int POST_MESSAGE_TO_CONTROL = 2;
    private static final int SDK_VERSION = android.os.Build.VERSION.SDK_INT;
    io.dcloud.feature.weex.adapter.webview.DCWXWebView.DCWXChromeClient chromeClient;
    private android.view.View customView;
    private android.webkit.WebChromeClient.CustomViewCallback customViewCallback;
    private android.widget.FrameLayout fullscreenContainer;
    private android.content.Context mContext;
    private java.lang.ref.WeakReference<io.dcloud.feature.weex.adapter.webview.WXDCWeb> mDCWeb;
    private java.lang.String mDefUserAgent;
    private android.os.Handler mMessageHandler;
    private com.taobao.weex.ui.view.IWebView.OnErrorListener mOnErrorListener;
    private io.dcloud.feature.weex.adapter.webview.WXDCWeb.OnDCMessageListener mOnMessageListener;
    private com.taobao.weex.ui.view.IWebView.OnPageListener mOnPageListener;
    private java.lang.String mOrigin;
    private android.widget.FrameLayout mRootView;
    java.lang.String mSslType;
    private com.dcloud.android.widget.DCWebViewProgressBar mWebProgressView;
    private android.webkit.WebView mWebView;
    private boolean mShowLoading = true;
    public int mProgress = 0;
    private boolean isStart = false;
    private int defaultSystemUI = 0;

    @Override // com.taobao.weex.ui.view.IWebView
    public void setOnMessageListener(com.taobao.weex.ui.view.IWebView.OnMessageListener onMessageListener) {
    }

    public DCWXWebView(android.content.Context context, java.lang.String str, io.dcloud.feature.weex.adapter.webview.WXDCWeb wXDCWeb) {
        this.mSslType = "refuse";
        this.mContext = context;
        this.mOrigin = str;
        this.mDCWeb = new java.lang.ref.WeakReference<>(wXDCWeb);
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(wXDCWeb.getInstance());
        if (iWebviewFindWebview == null || iWebviewFindWebview.obtainApp() == null) {
            return;
        }
        this.mSslType = iWebviewFindWebview.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_UNTRUSTEDCA);
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public android.view.View getView() {
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(this.mContext);
        this.mRootView = frameLayout;
        frameLayout.setBackgroundColor(-1);
        this.mWebView = new android.webkit.WebView(this.mContext) { // from class: io.dcloud.feature.weex.adapter.webview.DCWXWebView.1
            @Override // android.webkit.WebView, android.view.View
            protected void onScrollChanged(int i, int i2, int i3, int i4) {
                super.onScrollChanged(i, i2, i3, i4);
                io.dcloud.common.ui.blur.AppEventForBlurManager.onScrollChanged(i, i2);
            }
        };
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.mWebView.setLayoutParams(layoutParams);
        this.mRootView.addView(this.mWebView);
        this.mWebView.setBackgroundColor(0);
        initWebView(this.mWebView);
        this.mMessageHandler = new io.dcloud.feature.weex.adapter.webview.DCWXWebView.MessageHandler();
        return this.mRootView;
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void destroy() {
        if (getWebView() != null) {
            hideCustomView();
            getWebView().setWebViewClient(null);
            getWebView().setWebChromeClient(null);
            getWebView().removeAllViews();
            getWebView().destroy();
            this.mWebView = null;
            this.mDCWeb.clear();
            this.mOnMessageListener = null;
            this.mWebProgressView = null;
            this.mOnPageListener = null;
            this.mOnErrorListener = null;
        }
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void loadUrl(java.lang.String str) {
        if (getWebView() == null) {
            return;
        }
        getWebView().loadUrl(str);
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void loadDataWithBaseURL(java.lang.String str) {
        if (getWebView() == null) {
            return;
        }
        getWebView().loadDataWithBaseURL(this.mOrigin, str, "text/html", "utf-8", null);
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void reload() {
        if (getWebView() == null) {
            return;
        }
        getWebView().reload();
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void goBack() {
        if (getWebView() == null) {
            return;
        }
        getWebView().goBack();
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void goForward() {
        if (getWebView() == null) {
            return;
        }
        getWebView().goForward();
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void postMessage(java.lang.Object obj) {
        if (getWebView() == null) {
            return;
        }
        try {
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("type", (java.lang.Object) "message");
            jSONObject.put("data", obj);
            evaluateJS("javascript:(function () {var initData = " + jSONObject.toString() + ";try {var event = new MessageEvent('onPostMessage', initData);window.dispatchEvent(event);} catch (e) {}})();");
        } catch (com.alibaba.fastjson.JSONException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void setShowLoading(boolean z) {
        this.mShowLoading = z;
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void setOnErrorListener(com.taobao.weex.ui.view.IWebView.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void setOnPageListener(com.taobao.weex.ui.view.IWebView.OnPageListener onPageListener) {
        this.mOnPageListener = onPageListener;
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        io.dcloud.feature.weex.adapter.webview.DCWXWebView.DCWXChromeClient dCWXChromeClient = this.chromeClient;
        if (dCWXChromeClient != null) {
            dCWXChromeClient.onResult(i, i2, intent);
        }
    }

    public void setOnDCMessageListener(io.dcloud.feature.weex.adapter.webview.WXDCWeb.OnDCMessageListener onDCMessageListener) {
        this.mOnMessageListener = onDCMessageListener;
    }

    private void showWebView(boolean z) {
        this.mWebView.setVisibility(z ? 0 : 4);
    }

    @Override // io.dcloud.feature.weex.adapter.webview.IDCWebView
    public android.webkit.WebView getWebView() {
        return this.mWebView;
    }

    @Override // io.dcloud.feature.weex.adapter.webview.IDCWebView
    public void setUserAgent(java.lang.String str, boolean z) {
        android.webkit.WebView webView = this.mWebView;
        if (webView != null) {
            android.webkit.WebSettings settings = webView.getSettings();
            if (!z) {
                if (android.text.TextUtils.isEmpty(this.mDefUserAgent)) {
                    this.mDefUserAgent = settings.getUserAgentString();
                }
                str = str + this.mDefUserAgent + com.taobao.weex.el.parse.Operators.SPACE_STR + str;
            }
            settings.setUserAgentString(str);
        }
    }

    private void initWebView(android.webkit.WebView webView) {
        android.webkit.WebSettings settings = webView.getSettings();
        io.dcloud.common.adapter.ui.webview.WebViewFactory.openJSEnabled(settings, null);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(false);
        settings.setAllowFileAccess(false);
        settings.setBuiltInZoomControls(false);
        settings.setAllowContentAccess(true);
        settings.setSavePassword(false);
        settings.setMixedContentMode(0);
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibilityTraversal");
        webView.removeJavascriptInterface("accessibility");
        io.dcloud.common.adapter.ui.webview.WebViewFactory.setFileAccess(settings, true);
        settings.setDefaultTextEncodingName(com.dcloud.zxing2.common.StringUtils.GB2312);
        webView.setWebViewClient(new android.webkit.WebViewClient() { // from class: io.dcloud.feature.weex.adapter.webview.DCWXWebView.2
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(android.webkit.WebView webView2, java.lang.String str) {
                if (io.dcloud.common.util.PdrUtil.isDeviceRootDir(str) || io.dcloud.common.util.PdrUtil.isNetPath(str) || str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
                    return false;
                }
                try {
                    if (str.startsWith("intent://")) {
                        android.content.Intent uri = android.content.Intent.parseUri(str, 1);
                        uri.addCategory("android.intent.category.BROWSABLE");
                        uri.setComponent(null);
                        uri.setSelector(null);
                        if (io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mContext.getPackageManager().queryIntentActivities(uri, 0).size() > 0) {
                            ((android.app.Activity) io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mContext).startActivityIfNeeded(uri, -1);
                        }
                    } else {
                        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str));
                        intent.setFlags(268435456);
                        io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mContext.startActivity(intent);
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(android.webkit.WebView webView2, java.lang.String str, android.graphics.Bitmap bitmap) {
                super.onPageStarted(webView2, str, bitmap);
                com.taobao.weex.utils.WXLogUtils.v("tag", "onPageStarted " + str);
                if (io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mOnPageListener != null) {
                    io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mOnPageListener.onPageStart(str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(android.webkit.WebView webView2, java.lang.String str) {
                super.onPageFinished(webView2, str);
                com.taobao.weex.utils.WXLogUtils.v("tag", "onPageFinished " + str);
                if (io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.isStart) {
                    io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.isStart = false;
                    if (io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mWebProgressView != null) {
                        io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mWebProgressView.finishProgress();
                    }
                }
                if (io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mOnPageListener != null) {
                    io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mOnPageListener.onPageFinish(str, webView2.canGoBack(), webView2.canGoForward());
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(android.webkit.WebView webView2, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceError webResourceError) {
                super.onReceivedError(webView2, webResourceRequest, webResourceError);
                if (io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mOnErrorListener != null) {
                    io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mOnErrorListener.onError("error", "page error");
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(android.webkit.WebView webView2, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView2, webResourceRequest, webResourceResponse);
                if (io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mOnErrorListener != null) {
                    io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mOnErrorListener.onError("error", "http error");
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(android.webkit.WebView webView2, final android.webkit.SslErrorHandler sslErrorHandler, final android.net.http.SslError sslError) {
                if (io.dcloud.common.util.PdrUtil.isEquals(io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mSslType, "refuse")) {
                    sslErrorHandler.cancel();
                } else if (io.dcloud.common.util.PdrUtil.isEquals(io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mSslType, "warning")) {
                    android.content.Context context = webView2.getContext();
                    final android.app.AlertDialog alertDialogCreate = new android.app.AlertDialog.Builder(context).create();
                    alertDialogCreate.setIcon(android.R.drawable.ic_secure);
                    alertDialogCreate.setTitle(io.dcloud.base.R.string.dcloud_common_safety_warning);
                    alertDialogCreate.setCanceledOnTouchOutside(false);
                    java.lang.String url = sslError.getUrl();
                    java.lang.String string = context.getString(io.dcloud.base.R.string.dcloud_common_certificate_continue);
                    if (!android.text.TextUtils.isEmpty(url)) {
                        string = url + "\n" + string;
                    }
                    alertDialogCreate.setMessage(string);
                    android.content.DialogInterface.OnClickListener onClickListener = new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.feature.weex.adapter.webview.DCWXWebView.2.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(android.content.DialogInterface dialogInterface, int i) {
                            if (i == -2) {
                                alertDialogCreate.cancel();
                                alertDialogCreate.dismiss();
                            } else if (i == -3) {
                                sslError.getCertificate().getIssuedBy();
                            } else if (i == -1) {
                                io.dcloud.common.adapter.ui.webview.WebViewFactory.setSslHandlerState(sslErrorHandler, 1);
                                alertDialogCreate.dismiss();
                            }
                        }
                    };
                    alertDialogCreate.setButton(-2, context.getResources().getString(android.R.string.cancel), onClickListener);
                    alertDialogCreate.setButton(-1, context.getResources().getString(android.R.string.ok), onClickListener);
                    alertDialogCreate.show();
                } else {
                    io.dcloud.common.adapter.ui.webview.WebViewFactory.setSslHandlerState(sslErrorHandler, 1);
                }
                if (io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mOnErrorListener != null) {
                    io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mOnErrorListener.onError("error", "ssl error");
                }
            }
        });
        io.dcloud.feature.weex.adapter.webview.DCWXWebView.DCWXChromeClient dCWXChromeClient = new io.dcloud.feature.weex.adapter.webview.DCWXWebView.DCWXChromeClient();
        this.chromeClient = dCWXChromeClient;
        webView.setWebChromeClient(dCWXChromeClient);
        webView.addJavascriptInterface(new java.lang.Object() { // from class: io.dcloud.feature.weex.adapter.webview.DCWXWebView.3
            @android.webkit.JavascriptInterface
            public void postMessage(java.lang.String str) {
                io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.onMessage(str, 1);
            }

            @android.webkit.JavascriptInterface
            public void postMessageToService(java.lang.String str) {
                io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.onMessage(str, 2);
            }
        }, BRIDGE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startWebProgress() {
        java.lang.String string;
        if (this.mDCWeb.get() == null || this.mDCWeb.get().getHostView() == null) {
            return;
        }
        if (this.mDCWeb.get() == null || this.mDCWeb.get().getWebStyles() == null || this.mDCWeb.get().getWebStyles().getBooleanValue("isProgress")) {
            java.lang.String url = getWebView().getUrl();
            if (android.text.TextUtils.isEmpty(url) || url.startsWith("file")) {
                return;
            }
            if (this.mWebProgressView == null) {
                this.mWebProgressView = new com.dcloud.android.widget.DCWebViewProgressBar(this.mWebView.getContext());
            }
            if (!this.mDCWeb.get().getWebStyles().containsKey("progressColor")) {
                string = "#00FF00";
            } else {
                string = this.mDCWeb.get().getWebStyles().getString("progressColor");
            }
            int iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(string);
            int iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt("2px", this.mWebView.getMeasuredWidth(), 0, this.mWebView.getScale());
            this.mWebProgressView.setColorInt(iStringToColor);
            this.mWebProgressView.setVisibility(0);
            this.mWebProgressView.setAlphaInt(255);
            if (this.mWebProgressView.getParent() == null) {
                this.mRootView.addView(this.mWebProgressView, new android.view.ViewGroup.LayoutParams(-1, iConvertToScreenInt));
            }
            this.mWebProgressView.startProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    public void onMessage(java.lang.String str, int i) {
        if (str == 0 || this.mOnMessageListener == null) {
            return;
        }
        try {
            str = com.alibaba.fastjson.JSON.parse(str);
        } catch (java.lang.Exception unused) {
        }
        android.os.Message message = new android.os.Message();
        message.what = i;
        message.obj = str;
        this.mMessageHandler.sendMessage(message);
    }

    private void evaluateJS(java.lang.String str) {
        if (SDK_VERSION < 19) {
            this.mWebView.loadUrl(str);
        } else {
            this.mWebView.evaluateJavascript(str, null);
        }
    }

    private static class MessageHandler extends android.os.Handler {
        private final java.lang.ref.WeakReference<io.dcloud.feature.weex.adapter.webview.DCWXWebView> mWv;

        private MessageHandler(io.dcloud.feature.weex.adapter.webview.DCWXWebView dCWXWebView) {
            this.mWv = new java.lang.ref.WeakReference<>(dCWXWebView);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                if (this.mWv.get() == null || this.mWv.get().mOnMessageListener == null) {
                    return;
                }
                java.util.HashMap map = new java.util.HashMap();
                map.put("detail", message.obj);
                this.mWv.get().mOnMessageListener.onMessage(map, 1);
                return;
            }
            if (i != 2 || this.mWv.get() == null || this.mWv.get().mOnMessageListener == null) {
                return;
            }
            java.util.HashMap map2 = new java.util.HashMap();
            map2.put("data", message.obj);
            this.mWv.get().mOnMessageListener.onMessage(map2, 2);
        }
    }

    private class DCWXChromeClient extends android.webkit.WebChromeClient {
        io.dcloud.common.adapter.ui.FileChooseDialog dialog;
        android.webkit.ValueCallback<android.net.Uri> mUploadMessage;
        android.webkit.ValueCallback<android.net.Uri[]> mUploadMessage21Level;

        private DCWXChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(android.webkit.PermissionRequest permissionRequest) {
            permissionRequest.grant(permissionRequest.getResources());
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(android.webkit.WebView webView, int i) {
            super.onProgressChanged(webView, i);
            io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mProgress = i;
            if (!io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.isStart && io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mProgress < 100) {
                io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.startWebProgress();
                io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.isStart = true;
            }
            if (io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mProgress >= 100 && io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.isStart) {
                io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.isStart = false;
                if (io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mWebProgressView != null) {
                    io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mWebProgressView.finishProgress();
                }
            }
            com.taobao.weex.utils.WXLogUtils.v("tag", "onPageProgressChanged " + i);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(android.webkit.WebView webView, java.lang.String str) {
            super.onReceivedTitle(webView, str);
            if (io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mOnPageListener != null) {
                io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mOnPageListener.onReceivedTitle(webView.getTitle());
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, java.lang.String str3, android.webkit.JsPromptResult jsPromptResult) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(final java.lang.String str, final android.webkit.GeolocationPermissions.Callback callback) {
            if (io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mContext instanceof android.app.Activity) {
                io.dcloud.common.adapter.util.PermissionUtil.usePermission((android.app.Activity) io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mContext, "dc_weexsdk", io.dcloud.common.adapter.util.PermissionUtil.PMS_LOCATION, 2, new io.dcloud.common.adapter.util.PermissionUtil.Request() { // from class: io.dcloud.feature.weex.adapter.webview.DCWXWebView.DCWXChromeClient.1
                    @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
                    public void onGranted(java.lang.String str2) {
                        callback.invoke(str, true, false);
                    }

                    @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
                    public void onDenied(java.lang.String str2) {
                        callback.invoke(str, false, false);
                    }
                });
            } else {
                super.onGeolocationPermissionsShowPrompt(str, callback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(android.webkit.WebView webView, android.webkit.ValueCallback<android.net.Uri[]> valueCallback, android.webkit.WebChromeClient.FileChooserParams fileChooserParams) {
            openFileChooserLogic(webView, null, valueCallback, fileChooserParams.getAcceptTypes() != null ? fileChooserParams.getAcceptTypes()[0] : null, "");
            return true;
        }

        private void openFileChooserLogic(final android.webkit.WebView webView, final android.webkit.ValueCallback<android.net.Uri> valueCallback, final android.webkit.ValueCallback<android.net.Uri[]> valueCallback2, final java.lang.String str, final java.lang.String str2) {
            if (io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mContext == null) {
                return;
            }
            io.dcloud.common.adapter.util.PermissionUtil.usePermission((android.app.Activity) io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mContext, "dc_weexsdk", io.dcloud.common.adapter.util.PermissionUtil.PMS_STORAGE, 2, new io.dcloud.common.adapter.util.PermissionUtil.Request() { // from class: io.dcloud.feature.weex.adapter.webview.DCWXWebView.DCWXChromeClient.2
                @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
                public void onDenied(java.lang.String str3) {
                }

                @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
                public void onGranted(java.lang.String str3) {
                    io.dcloud.feature.weex.adapter.webview.DCWXWebView.DCWXChromeClient.this.showOpenFileChooser(webView, valueCallback, valueCallback2, str, str2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showOpenFileChooser(android.webkit.WebView webView, android.webkit.ValueCallback<android.net.Uri> valueCallback, android.webkit.ValueCallback<android.net.Uri[]> valueCallback2, java.lang.String str, java.lang.String str2) {
            this.mUploadMessage = valueCallback;
            this.mUploadMessage21Level = valueCallback2;
            android.content.Intent intent = new android.content.Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            if (!io.dcloud.common.util.PdrUtil.isEmpty(str)) {
                intent.setType(str);
            } else {
                intent.setType("*/*");
            }
            io.dcloud.common.adapter.ui.FileChooseDialog fileChooseDialog = new io.dcloud.common.adapter.ui.FileChooseDialog(webView.getContext(), (android.app.Activity) webView.getContext(), intent);
            this.dialog = fileChooseDialog;
            try {
                fileChooseDialog.show();
                this.dialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() { // from class: io.dcloud.feature.weex.adapter.webview.DCWXWebView.DCWXChromeClient.3
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(android.content.DialogInterface dialogInterface) {
                        try {
                            if (io.dcloud.feature.weex.adapter.webview.DCWXWebView.DCWXChromeClient.this.mUploadMessage21Level != null) {
                                io.dcloud.feature.weex.adapter.webview.DCWXWebView.DCWXChromeClient.this.mUploadMessage21Level.onReceiveValue(null);
                            } else if (io.dcloud.feature.weex.adapter.webview.DCWXWebView.DCWXChromeClient.this.mUploadMessage != null) {
                                io.dcloud.feature.weex.adapter.webview.DCWXWebView.DCWXChromeClient.this.mUploadMessage.onReceiveValue(null);
                            }
                        } catch (java.lang.Exception unused) {
                        }
                    }
                });
            } catch (java.lang.Exception unused) {
            }
        }

        public void onResult(int i, int i2, android.content.Intent intent) {
            android.net.Uri uriForFile;
            io.dcloud.common.adapter.ui.FileChooseDialog fileChooseDialog;
            android.database.Cursor cursorQuery;
            io.dcloud.common.adapter.ui.FileChooseDialog fileChooseDialog2 = this.dialog;
            if (fileChooseDialog2 != null) {
                fileChooseDialog2.dismiss();
                if (i2 != 0) {
                    if (i != 1) {
                        if (i == 2 && (fileChooseDialog = this.dialog) != null && fileChooseDialog.uris != null) {
                            java.util.Iterator<java.io.File> it = this.dialog.uris.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    uriForFile = null;
                                    break;
                                }
                                java.io.File next = it.next();
                                if (next.exists()) {
                                    uriForFile = androidx.core.content.FileProvider.getUriForFile(io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mContext, io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mContext.getPackageName() + ".dc.fileprovider", next);
                                    break;
                                }
                            }
                        } else {
                            uriForFile = null;
                            break;
                        }
                    } else {
                        if (intent == null) {
                            android.webkit.ValueCallback<android.net.Uri[]> valueCallback = this.mUploadMessage21Level;
                            if (valueCallback != null) {
                                valueCallback.onReceiveValue(null);
                            } else {
                                android.webkit.ValueCallback<android.net.Uri> valueCallback2 = this.mUploadMessage;
                                if (valueCallback2 != null) {
                                    valueCallback2.onReceiveValue(null);
                                }
                            }
                            this.dialog = null;
                            return;
                        }
                        uriForFile = intent.getData();
                        if (uriForFile != null && android.os.Build.VERSION.SDK_INT < 29 && com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME.equals(uriForFile.getScheme()) && (cursorQuery = io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.mContext.getContentResolver().query(uriForFile, new java.lang.String[]{"_data"}, null, null, null)) != null) {
                            if (cursorQuery.moveToFirst()) {
                                try {
                                    int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
                                    if (columnIndexOrThrow > -1) {
                                        java.lang.String string = cursorQuery.getString(columnIndexOrThrow);
                                        android.net.Uri uri = android.net.Uri.parse(string);
                                        try {
                                            if (io.dcloud.common.util.PdrUtil.isEmpty(uri.getScheme())) {
                                                uriForFile = android.net.Uri.parse((string.startsWith("/") ? io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL : "file:///") + string);
                                            } else {
                                                uriForFile = uri;
                                            }
                                        } catch (java.lang.Exception unused) {
                                        }
                                    }
                                } catch (java.lang.Exception unused2) {
                                }
                            }
                            cursorQuery.close();
                        }
                    }
                    android.net.Uri[] uriArr = uriForFile != null ? new android.net.Uri[]{uriForFile} : null;
                    android.webkit.ValueCallback<android.net.Uri[]> valueCallback3 = this.mUploadMessage21Level;
                    if (valueCallback3 != null) {
                        valueCallback3.onReceiveValue(uriArr);
                    } else {
                        android.webkit.ValueCallback<android.net.Uri> valueCallback4 = this.mUploadMessage;
                        if (valueCallback4 != null) {
                            valueCallback4.onReceiveValue(uriForFile);
                        }
                    }
                } else {
                    android.webkit.ValueCallback<android.net.Uri[]> valueCallback5 = this.mUploadMessage21Level;
                    if (valueCallback5 != null) {
                        valueCallback5.onReceiveValue(null);
                    } else {
                        android.webkit.ValueCallback<android.net.Uri> valueCallback6 = this.mUploadMessage;
                        if (valueCallback6 != null) {
                            valueCallback6.onReceiveValue(null);
                        }
                    }
                }
                this.dialog = null;
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(android.view.View view, android.webkit.WebChromeClient.CustomViewCallback customViewCallback) {
            io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.showCustomView(view, customViewCallback);
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            io.dcloud.feature.weex.adapter.webview.DCWXWebView.this.hideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showCustomView(android.view.View view, android.webkit.WebChromeClient.CustomViewCallback customViewCallback) {
        android.widget.FrameLayout frameLayoutObtainActivityContentView;
        if (this.customView != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        android.content.Context context = this.mContext;
        if (context == null || !(context instanceof android.app.Activity)) {
            return;
        }
        android.app.Activity activity = (android.app.Activity) context;
        io.dcloud.common.DHInterface.IActivityHandler iActivityHandler = io.src.dcloud.adapter.DCloudAdapterUtil.getIActivityHandler(activity);
        if (iActivityHandler != null) {
            frameLayoutObtainActivityContentView = iActivityHandler.obtainActivityContentView();
            iActivityHandler.closeSideBar();
            iActivityHandler.setSideBarVisibility(8);
        } else {
            frameLayoutObtainActivityContentView = activity instanceof io.dcloud.common.DHInterface.IActivityDelegate ? ((io.dcloud.common.DHInterface.IActivityDelegate) activity).obtainActivityContentView() : null;
        }
        this.mWebView.setVisibility(8);
        this.fullscreenContainer = new io.dcloud.feature.weex.adapter.webview.video.FullscreenHolder(this.mContext);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        this.fullscreenContainer.addView(view, layoutParams);
        frameLayoutObtainActivityContentView.addView(this.fullscreenContainer, layoutParams);
        this.customView = view;
        setStatusBarVisibility(activity, false);
        this.customViewCallback = customViewCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        android.content.Context context;
        if (this.customView == null || (context = this.mContext) == null || !(context instanceof android.app.Activity)) {
            return;
        }
        setStatusBarVisibility((android.app.Activity) context, true);
        if (this.fullscreenContainer.getParent() != null) {
            ((android.view.ViewGroup) this.fullscreenContainer.getParent()).removeView(this.fullscreenContainer);
            this.fullscreenContainer.removeAllViews();
        }
        this.fullscreenContainer = null;
        this.customView = null;
        android.webkit.WebChromeClient.CustomViewCallback customViewCallback = this.customViewCallback;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.customViewCallback = null;
        }
        this.mWebView.setVisibility(0);
    }

    private void setStatusBarVisibility(android.app.Activity activity, boolean z) {
        if (z) {
            activity.getWindow().getDecorView().setSystemUiVisibility(this.defaultSystemUI);
        } else {
            this.defaultSystemUI = activity.getWindow().getDecorView().getSystemUiVisibility();
            activity.getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }
}
