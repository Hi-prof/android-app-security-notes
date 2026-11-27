package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IDCloudWebviewClientListener extends io.dcloud.common.DHInterface.IReflectAble {
    void doUpdateVisitedHistory(android.webkit.WebView webView, java.lang.String str, boolean z);

    void onPageFinished(android.webkit.WebView webView, java.lang.String str);

    void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap);

    void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2);

    void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError);

    android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest);

    android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, java.lang.String str);

    boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str);
}
