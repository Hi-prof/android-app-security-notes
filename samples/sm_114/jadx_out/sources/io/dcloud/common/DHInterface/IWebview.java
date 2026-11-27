package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IWebview extends io.dcloud.common.DHInterface.IContainerView {
    public static final java.lang.String COOKIE = "Cookie";
    public static final java.lang.String SET_COOKIE = "Set-Cookie";
    public static final java.lang.String USER_AGENT = "User-Agent";
    public static final int WEBVIEW_PROGRESS_TAP = 50;

    void addJsInterface(java.lang.String str, io.dcloud.common.DHInterface.IJsInterface iJsInterface);

    void addJsInterface(java.lang.String str, java.lang.String str2);

    void addStateListener(io.dcloud.common.DHInterface.IWebviewStateListener iWebviewStateListener);

    void appendPreloadJsFile(java.lang.String str);

    boolean canGoBack();

    boolean canGoForward();

    void checkIfNeedLoadOriginalUrl();

    boolean checkWhite(java.lang.String str);

    void clearHistory();

    void endWebViewEvent(java.lang.String str);

    void evalJS(java.lang.String str);

    void evalJS(java.lang.String str, io.dcloud.common.adapter.ui.ReceiveJSValue.ReceiveJSValueCallback receiveJSValueCallback);

    void evalJSSync(java.lang.String str, io.dcloud.common.DHInterface.ICallBack iCallBack);

    void executeScript(java.lang.String str);

    android.app.Activity getActivity();

    android.content.Context getContext();

    java.lang.String getCookie(java.lang.String str);

    int getFixBottom();

    java.lang.Object getFlag();

    io.dcloud.common.DHInterface.IWebview getOpener();

    java.lang.String getOriginalUrl();

    float getScale();

    float getScaleOfOpenerWebview();

    java.lang.String getTitle();

    java.lang.String getWebviewANID();

    java.lang.String getWebviewProperty(java.lang.String str);

    java.lang.String getWebviewUUID();

    void goBackOrForward(int i);

    boolean hasWebViewEvent(java.lang.String str);

    void initWebviewUUID(java.lang.String str);

    boolean isIWebViewFocusable();

    boolean isLoaded();

    boolean isPause();

    boolean isUniService();

    boolean isUniWebView();

    void loadContentData(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);

    void loadUrl(java.lang.String str);

    io.dcloud.common.DHInterface.IApp obtainApp();

    java.lang.String obtainFrameId();

    io.dcloud.common.DHInterface.IFrameView obtainFrameView();

    java.lang.String obtainFullUrl();

    java.lang.String obtainPageTitle();

    java.lang.String obtainUrl();

    @java.lang.Deprecated
    android.webkit.WebView obtainWebview();

    android.view.ViewGroup obtainWindowView();

    void onRootViewGlobalLayout(android.view.View view);

    void pause();

    void reload();

    void reload(java.lang.String str);

    void reload(boolean z);

    void removeAllCookie();

    void removeSessionCookie();

    void removeStateListener(io.dcloud.common.DHInterface.IWebviewStateListener iWebviewStateListener);

    void resume();

    void setAssistantType(java.lang.String str);

    void setCookie(java.lang.String str, java.lang.String str2);

    void setCssFile(java.lang.String str, java.lang.String str2);

    void setFixBottom(int i);

    void setFlag(java.lang.Object obj);

    void setFrameId(java.lang.String str);

    void setIWebViewFocusable(boolean z);

    void setListenResourceLoading(org.json.JSONObject jSONObject);

    void setLoadURLHeads(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map);

    void setOpener(io.dcloud.common.DHInterface.IWebview iWebview);

    void setOriginalUrl(java.lang.String str);

    void setOverrideResourceRequest(org.json.JSONArray jSONArray);

    void setOverrideUrlLoadingData(org.json.JSONObject jSONObject);

    void setPreloadJsFile(java.lang.String str, boolean z);

    void setProgressView(android.view.View view);

    void setScrollIndicator(java.lang.String str);

    void setWebViewCacheMode(java.lang.String str);

    void setWebViewEvent(java.lang.String str, java.lang.Object obj);

    void setWebviewProperty(java.lang.String str, java.lang.String str2);

    void setWebviewclientListener(io.dcloud.common.DHInterface.IDCloudWebviewClientListener iDCloudWebviewClientListener);

    void show(android.view.animation.Animation animation);

    void stopLoading();

    boolean unReceiveTitle();
}
