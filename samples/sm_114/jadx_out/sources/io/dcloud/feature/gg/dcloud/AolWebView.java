package io.dcloud.feature.gg.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AolWebView {
    android.view.ViewGroup mRootView;
    android.webkit.WebView mWebView;

    public AolWebView(android.content.Context context) {
        if (context instanceof android.app.Activity) {
            this.mRootView = (android.view.ViewGroup) ((android.app.Activity) context).getWindow().getDecorView();
        } else {
            this.mRootView = (android.view.ViewGroup) ((android.app.Activity) io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext).getWindow().getDecorView();
        }
        android.webkit.WebView webView = new android.webkit.WebView(context);
        this.mWebView = webView;
        webView.setVisibility(4);
        this.mRootView.addView(this.mWebView, new android.widget.FrameLayout.LayoutParams(-1, -1));
        android.webkit.WebSettings settings = this.mWebView.getSettings();
        io.dcloud.common.adapter.ui.webview.WebViewFactory.openJSEnabled(settings, null);
        settings.setDomStorageEnabled(true);
        context.getApplicationContext().getCacheDir().getAbsolutePath();
        settings.setAllowFileAccess(false);
        io.dcloud.common.adapter.ui.webview.WebViewFactory.setFileAccess(settings, true);
        settings.setSavePassword(false);
        this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.mWebView.removeJavascriptInterface("accessibilityTraversal");
        this.mWebView.removeJavascriptInterface("accessibility");
        this.mWebView.setWebViewClient(new android.webkit.WebViewClient() { // from class: io.dcloud.feature.gg.dcloud.AolWebView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(android.webkit.WebView webView2, final java.lang.String str) {
                super.onPageFinished(webView2, str);
                io.dcloud.feature.gg.dcloud.ADHandler.log("aol", "onPageFinished---url=" + str);
                io.dcloud.feature.gg.dcloud.AolWebView.this.mRootView.postDelayed(new java.lang.Runnable() { // from class: io.dcloud.feature.gg.dcloud.AolWebView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (io.dcloud.feature.gg.dcloud.AolWebView.this.mWebView == null) {
                            return;
                        }
                        io.dcloud.feature.gg.dcloud.ADHandler.log("aol", "onPageFinished-remove--url=" + str);
                        io.dcloud.feature.gg.dcloud.AolWebView aolWebView = io.dcloud.feature.gg.dcloud.AolWebView.this;
                        android.view.ViewGroup viewGroup = aolWebView.mRootView;
                        if (viewGroup != null) {
                            viewGroup.removeView(aolWebView.mWebView);
                            io.dcloud.feature.gg.dcloud.AolWebView.this.mWebView = null;
                        }
                    }
                }, (long) io.dcloud.feature.gg.dcloud.ADSim.getRandomInt(com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT, 20000));
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(android.webkit.WebView webView2, final android.webkit.SslErrorHandler sslErrorHandler, final android.net.http.SslError sslError) {
                java.lang.String str;
                if (sslErrorHandler != null) {
                    java.lang.String str2 = io.dcloud.common.util.BaseInfo.untrustedca;
                    if (io.dcloud.common.util.PdrUtil.isEquals(str2, "refuse")) {
                        sslErrorHandler.cancel();
                        return;
                    }
                    if (!io.dcloud.common.util.PdrUtil.isEquals(str2, "warning")) {
                        io.dcloud.common.adapter.ui.webview.WebViewFactory.setSslHandlerState(sslErrorHandler, 1);
                        return;
                    }
                    android.content.Context context2 = webView2.getContext();
                    final android.app.AlertDialog alertDialogCreate = new android.app.AlertDialog.Builder(context2).create();
                    alertDialogCreate.setIcon(android.R.drawable.ic_secure);
                    alertDialogCreate.setTitle("安全警告");
                    alertDialogCreate.setCanceledOnTouchOutside(false);
                    java.lang.String url = sslError.getUrl();
                    if (android.text.TextUtils.isEmpty(url)) {
                        str = "此站点安全证书存在问题,是否继续?";
                    } else {
                        str = url + "\n此站点安全证书存在问题,是否继续?";
                    }
                    alertDialogCreate.setMessage(str);
                    android.content.DialogInterface.OnClickListener onClickListener = new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.feature.gg.dcloud.AolWebView.1.2
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
                    alertDialogCreate.setButton(-2, context2.getResources().getString(android.R.string.cancel), onClickListener);
                    alertDialogCreate.setButton(-1, context2.getResources().getString(android.R.string.ok), onClickListener);
                    alertDialogCreate.show();
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(android.webkit.WebView webView2, java.lang.String str) {
                return android.text.TextUtils.isEmpty(str) || !str.toLowerCase(java.util.Locale.ENGLISH).startsWith("http");
            }
        });
        removeUnSafeJavascriptInterface();
        this.mWebView.setDownloadListener(new android.webkit.DownloadListener() { // from class: io.dcloud.feature.gg.dcloud.AolWebView.2
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j) {
            }
        });
    }

    private void removeUnSafeJavascriptInterface() {
    }

    public void loadUrl(java.lang.String str) {
        android.webkit.WebView webView = this.mWebView;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }
}
