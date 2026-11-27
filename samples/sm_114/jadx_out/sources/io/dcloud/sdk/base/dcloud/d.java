package io.dcloud.sdk.base.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    android.webkit.WebView a;
    android.view.ViewGroup b;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends android.webkit.WebViewClient {

        /* JADX INFO: renamed from: io.dcloud.sdk.base.dcloud.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class RunnableC0076a implements java.lang.Runnable {
            final /* synthetic */ java.lang.String a;

            RunnableC0076a(java.lang.String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (io.dcloud.sdk.base.dcloud.d.this.a == null) {
                    return;
                }
                io.dcloud.sdk.base.dcloud.ADHandler.a("adh", "onPageFinished-remove--url=" + this.a);
                io.dcloud.sdk.base.dcloud.d dVar = io.dcloud.sdk.base.dcloud.d.this;
                android.view.ViewGroup viewGroup = dVar.b;
                if (viewGroup != null) {
                    viewGroup.removeView(dVar.a);
                    io.dcloud.sdk.base.dcloud.d.this.a = null;
                }
            }
        }

        a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            io.dcloud.sdk.base.dcloud.ADHandler.a("adh", "onPageFinished---url=" + str);
            io.dcloud.sdk.base.dcloud.d.this.b.postDelayed(new io.dcloud.sdk.base.dcloud.d.a.RunnableC0076a(str), (long) io.dcloud.sdk.base.dcloud.c.a(com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT, 20000));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
            if (sslErrorHandler != null) {
                io.dcloud.sdk.core.util.ReflectUtil.invokeMethod(sslErrorHandler, "proceed", new java.lang.Class[0], new java.lang.Object[0]);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            return android.text.TextUtils.isEmpty(str) || !str.toLowerCase(java.util.Locale.ENGLISH).startsWith("http");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements android.webkit.DownloadListener {
        b() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j) {
        }
    }

    public d(android.content.Context context) {
        if (context instanceof android.app.Activity) {
            this.b = (android.view.ViewGroup) ((android.app.Activity) context).getWindow().getDecorView();
        }
        android.webkit.WebView webView = new android.webkit.WebView(context);
        this.a = webView;
        webView.setVisibility(4);
        this.b.addView(this.a, new android.widget.FrameLayout.LayoutParams(-1, -1));
        android.webkit.WebSettings settings = this.a.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        context.getApplicationContext().getCacheDir().getAbsolutePath();
        settings.setAllowFileAccess(false);
        io.dcloud.sdk.core.util.ReflectUtil.invokeMethod(settings, io.dcloud.p.s4.c("e218SWRkZ39OYWRtSWtrbXt7"), new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.TRUE);
        settings.setSavePassword(false);
        this.a.removeJavascriptInterface("searchBoxJavaBridge_");
        this.a.removeJavascriptInterface("accessibilityTraversal");
        this.a.removeJavascriptInterface("accessibility");
        this.a.setWebViewClient(new io.dcloud.sdk.base.dcloud.d.a());
        a();
        this.a.setDownloadListener(new io.dcloud.sdk.base.dcloud.d.b());
    }

    private void a() {
    }

    public void a(java.lang.String str) {
        android.webkit.WebView webView = this.a;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }
}
