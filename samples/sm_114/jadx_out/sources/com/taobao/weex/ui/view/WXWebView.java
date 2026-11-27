package com.taobao.weex.ui.view;

/* JADX INFO: loaded from: classes.dex */
public class WXWebView implements com.taobao.weex.ui.view.IWebView {
    private static final java.lang.String BRIDGE_NAME = "__WEEX_WEB_VIEW_BRIDGE";
    private static final int POST_MESSAGE = 1;
    private android.content.Context mContext;
    private android.os.Handler mMessageHandler;
    private com.taobao.weex.ui.view.IWebView.OnErrorListener mOnErrorListener;
    private com.taobao.weex.ui.view.IWebView.OnMessageListener mOnMessageListener;
    private com.taobao.weex.ui.view.IWebView.OnPageListener mOnPageListener;
    private java.lang.String mOrigin;
    private android.widget.ProgressBar mProgressBar;
    private boolean mShowLoading = true;
    private android.webkit.WebView mWebView;
    private static final int SDK_VERSION = android.os.Build.VERSION.SDK_INT;
    private static final boolean DOWNGRADE_JS_INTERFACE = false;

    @Override // com.taobao.weex.ui.view.IWebView
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
    }

    public WXWebView(android.content.Context context, java.lang.String str) {
        this.mContext = context;
        this.mOrigin = str;
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public android.view.View getView() {
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(this.mContext);
        frameLayout.setBackgroundColor(-1);
        this.mWebView = new android.webkit.WebView(this.mContext);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.mWebView.setLayoutParams(layoutParams);
        frameLayout.addView(this.mWebView);
        initWebView(this.mWebView);
        this.mProgressBar = new android.widget.ProgressBar(this.mContext);
        showProgressBar(false);
        android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(-2, -2);
        this.mProgressBar.setLayoutParams(layoutParams2);
        layoutParams2.gravity = 17;
        frameLayout.addView(this.mProgressBar);
        this.mMessageHandler = new com.taobao.weex.ui.view.WXWebView.MessageHandler();
        return frameLayout;
    }

    @Override // com.taobao.weex.ui.view.IWebView
    public void destroy() {
        if (getWebView() != null) {
            getWebView().setWebViewClient(null);
            getWebView().setWebChromeClient(null);
            getWebView().removeAllViews();
            getWebView().destroy();
            this.mWebView = null;
            this.mOnMessageListener = null;
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
            jSONObject.put("origin", (java.lang.Object) this.mOrigin);
            evaluateJS("javascript:(function () {var initData = " + jSONObject.toString() + ";try {var event = new MessageEvent('message', initData);window.dispatchEvent(event);} catch (e) {}})();");
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
    public void setOnMessageListener(com.taobao.weex.ui.view.IWebView.OnMessageListener onMessageListener) {
        this.mOnMessageListener = onMessageListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressBar(boolean z) {
        if (this.mShowLoading) {
            this.mProgressBar.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWebView(boolean z) {
        this.mWebView.setVisibility(z ? 0 : 4);
    }

    private android.webkit.WebView getWebView() {
        return this.mWebView;
    }

    private void initWebView(android.webkit.WebView webView) {
        android.webkit.WebSettings settings = webView.getSettings();
        io.dcloud.common.adapter.ui.webview.WebViewFactory.openJSEnabled(settings, null);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setAllowFileAccess(false);
        settings.setSavePassword(false);
        webView.setWebViewClient(new android.webkit.WebViewClient() { // from class: com.taobao.weex.ui.view.WXWebView.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(android.webkit.WebView webView2, java.lang.String str) {
                webView2.loadUrl(str);
                com.taobao.weex.utils.WXLogUtils.v("tag", "onPageOverride " + str);
                return true;
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(android.webkit.WebView webView2, java.lang.String str, android.graphics.Bitmap bitmap) {
                super.onPageStarted(webView2, str, bitmap);
                com.taobao.weex.utils.WXLogUtils.v("tag", "onPageStarted " + str);
                if (com.taobao.weex.ui.view.WXWebView.this.mOnPageListener != null) {
                    com.taobao.weex.ui.view.WXWebView.this.mOnPageListener.onPageStart(str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(android.webkit.WebView webView2, java.lang.String str) {
                java.lang.String str2;
                super.onPageFinished(webView2, str);
                com.taobao.weex.utils.WXLogUtils.v("tag", "onPageFinished " + str);
                if (com.taobao.weex.ui.view.WXWebView.this.mOnPageListener != null) {
                    com.taobao.weex.ui.view.WXWebView.this.mOnPageListener.onPageFinish(str, webView2.canGoBack(), webView2.canGoForward());
                }
                if (com.taobao.weex.ui.view.WXWebView.this.mOnMessageListener != null) {
                    com.taobao.weex.ui.view.WXWebView wXWebView = com.taobao.weex.ui.view.WXWebView.this;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("javascript:(window.postMessage = function(message, targetOrigin) {if (message == null || !targetOrigin) return;");
                    if (com.taobao.weex.ui.view.WXWebView.DOWNGRADE_JS_INTERFACE) {
                        str2 = "prompt('__WEEX_WEB_VIEW_BRIDGE://postMessage?message=' + JSON.stringify(message) + '&targetOrigin=' + targetOrigin)";
                    } else {
                        str2 = "__WEEX_WEB_VIEW_BRIDGE.postMessage(JSON.stringify(message), targetOrigin);";
                    }
                    sb.append(str2);
                    sb.append("})");
                    wXWebView.evaluateJS(sb.toString());
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(android.webkit.WebView webView2, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceError webResourceError) {
                super.onReceivedError(webView2, webResourceRequest, webResourceError);
                if (com.taobao.weex.ui.view.WXWebView.this.mOnErrorListener != null) {
                    com.taobao.weex.ui.view.WXWebView.this.mOnErrorListener.onError("error", "page error");
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(android.webkit.WebView webView2, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView2, webResourceRequest, webResourceResponse);
                if (com.taobao.weex.ui.view.WXWebView.this.mOnErrorListener != null) {
                    com.taobao.weex.ui.view.WXWebView.this.mOnErrorListener.onError("error", "http error");
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(android.webkit.WebView webView2, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
                super.onReceivedSslError(webView2, sslErrorHandler, sslError);
                if (com.taobao.weex.ui.view.WXWebView.this.mOnErrorListener != null) {
                    com.taobao.weex.ui.view.WXWebView.this.mOnErrorListener.onError("error", "ssl error");
                }
            }
        });
        webView.setWebChromeClient(new android.webkit.WebChromeClient() { // from class: com.taobao.weex.ui.view.WXWebView.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(android.webkit.WebView webView2, int i) {
                super.onProgressChanged(webView2, i);
                com.taobao.weex.ui.view.WXWebView.this.showWebView(i == 100);
                com.taobao.weex.ui.view.WXWebView.this.showProgressBar(i != 100);
                com.taobao.weex.utils.WXLogUtils.v("tag", "onPageProgressChanged " + i);
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(android.webkit.WebView webView2, java.lang.String str) {
                super.onReceivedTitle(webView2, str);
                if (com.taobao.weex.ui.view.WXWebView.this.mOnPageListener != null) {
                    com.taobao.weex.ui.view.WXWebView.this.mOnPageListener.onReceivedTitle(webView2.getTitle());
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(android.webkit.WebView webView2, java.lang.String str, java.lang.String str2, java.lang.String str3, android.webkit.JsPromptResult jsPromptResult) {
                android.net.Uri uri = android.net.Uri.parse(str2);
                if (android.text.TextUtils.equals(uri.getScheme(), com.taobao.weex.ui.view.WXWebView.BRIDGE_NAME)) {
                    if (android.text.TextUtils.equals(uri.getAuthority(), com.taobao.weex.ui.component.WXWeb.POST_MESSAGE)) {
                        com.taobao.weex.ui.view.WXWebView.this.onMessage(uri.getQueryParameter("message"), uri.getQueryParameter("targetOrigin"));
                        jsPromptResult.confirm(com.taobao.weex.ui.component.WXImage.SUCCEED);
                        return true;
                    }
                    jsPromptResult.confirm(com.taobao.weex.common.Constants.Event.FAIL);
                    return true;
                }
                return super.onJsPrompt(webView2, str, str2, str3, jsPromptResult);
            }
        });
        if (DOWNGRADE_JS_INTERFACE) {
            return;
        }
        webView.addJavascriptInterface(new java.lang.Object() { // from class: com.taobao.weex.ui.view.WXWebView.3
            @android.webkit.JavascriptInterface
            public void postMessage(java.lang.String str, java.lang.String str2) {
                com.taobao.weex.ui.view.WXWebView.this.onMessage(str, str2);
            }
        }, BRIDGE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMessage(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null || this.mOnMessageListener == null) {
            return;
        }
        try {
            java.util.HashMap map = new java.util.HashMap();
            map.put("data", com.alibaba.fastjson.JSON.parse(str));
            map.put("origin", str2);
            map.put("type", "message");
            android.os.Message message = new android.os.Message();
            message.what = 1;
            message.obj = map;
            this.mMessageHandler.sendMessage(message);
        } catch (com.alibaba.fastjson.JSONException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void evaluateJS(java.lang.String str) {
        if (SDK_VERSION < 19) {
            this.mWebView.loadUrl(str);
        } else {
            this.mWebView.evaluateJavascript(str, null);
        }
    }

    private static class MessageHandler extends android.os.Handler {
        private final java.lang.ref.WeakReference<com.taobao.weex.ui.view.WXWebView> mWv;

        private MessageHandler(com.taobao.weex.ui.view.WXWebView wXWebView) {
            this.mWv = new java.lang.ref.WeakReference<>(wXWebView);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            if (message.what != 1 || this.mWv.get() == null || this.mWv.get().mOnMessageListener == null) {
                return;
            }
            this.mWv.get().mOnMessageListener.onMessage((java.util.Map) message.obj);
        }
    }
}
