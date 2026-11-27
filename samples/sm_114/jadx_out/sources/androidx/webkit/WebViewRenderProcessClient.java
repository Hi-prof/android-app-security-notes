package androidx.webkit;

/* JADX INFO: loaded from: classes.dex */
public abstract class WebViewRenderProcessClient {
    public abstract void onRenderProcessResponsive(android.webkit.WebView webView, androidx.webkit.WebViewRenderProcess webViewRenderProcess);

    public abstract void onRenderProcessUnresponsive(android.webkit.WebView webView, androidx.webkit.WebViewRenderProcess webViewRenderProcess);
}
