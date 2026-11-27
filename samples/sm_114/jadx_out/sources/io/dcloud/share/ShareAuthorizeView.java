package io.dcloud.share;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ShareAuthorizeView extends io.dcloud.common.adapter.ui.AdaFrameItem implements io.dcloud.common.DHInterface.IReflectAble {
    private java.lang.String a;
    private android.webkit.WebView b;
    private io.dcloud.common.DHInterface.IWebview c;

    public ShareAuthorizeView(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        super(iWebview.getContext());
        this.c = iWebview;
        this.a = str;
        android.webkit.WebView webView = new android.webkit.WebView(iWebview.getContext());
        this.b = webView;
        a(webView);
        setMainView(this.b);
    }

    private void a(android.webkit.WebView webView) {
    }

    public void load(io.dcloud.share.a aVar, java.lang.String str) {
        io.dcloud.share.AbsWebviewClient absWebviewClient = (io.dcloud.share.AbsWebviewClient) io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(aVar.a(str), "getWebviewClient", null, new java.lang.Class[]{io.dcloud.share.ShareAuthorizeView.class}, new java.lang.Object[]{this});
        this.b.setWebViewClient(absWebviewClient);
        this.b.loadUrl(absWebviewClient.getInitUrl());
    }

    public void onauthenticated(java.lang.String str) {
        io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.a, "{type:'" + str + "'}", 1, true, true);
    }

    public void onerror(java.lang.String str) {
        io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.a, str, 9, false, true);
    }

    public void onloaded() {
        io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.a, "{evt:'load'}", 1, true, true);
    }
}
