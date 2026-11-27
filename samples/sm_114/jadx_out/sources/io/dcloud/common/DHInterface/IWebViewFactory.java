package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IWebViewFactory {
    java.lang.String getDefWebViewUA(android.content.Context context);

    io.dcloud.common.adapter.ui.webview.DCWebView getWebView(android.app.Activity activity, io.dcloud.common.adapter.ui.AdaWebview adaWebview);

    io.dcloud.common.adapter.ui.webview.DCWebView getWebView(android.app.Activity activity, io.dcloud.common.adapter.ui.AdaWebview adaWebview, io.dcloud.common.DHInterface.IDCloudWebviewClientListener iDCloudWebviewClientListener);

    io.dcloud.common.adapter.ui.webview.DCWebView getWebView(android.app.Activity activity, io.dcloud.common.adapter.ui.AdaWebview adaWebview, io.dcloud.common.adapter.ui.webview.OnPageFinishedCallack onPageFinishedCallack);
}
