package io.dcloud.common.adapter.ui.webview;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface DCWebView {
    public static final java.lang.String UserAgentExtInfo = " Html5Plus/1.0";
    public static final java.lang.String UserAgentExtInfoForHBuilder = " StreamApp/1.0";
    public static final java.lang.String UserAgentStreamApp = " StreamApp/1.0%s";

    void addJavascriptInterface(java.lang.Object obj, java.lang.String str);

    void applyWebViewDarkMode();

    boolean canGoBack();

    boolean canGoBackOrForward(int i);

    boolean canGoForward();

    boolean checkOverrideUrl(org.json.JSONObject jSONObject, java.lang.String str);

    boolean checkWhite(java.lang.String str);

    void clearCache(boolean z);

    void clearHistory();

    void closeWap2AppBlockDialog(boolean z);

    java.lang.String convertRelPath(java.lang.String str);

    void destroy();

    void destroyWeb();

    void evalJSSync(java.lang.String str, io.dcloud.common.DHInterface.ICallBack iCallBack);

    java.lang.String getBaseUrl();

    int getCacheMode();

    java.lang.String getCookie(java.lang.String str);

    java.lang.String getPageTitle();

    com.dcloud.android.v4.widget.IRefreshAble.OnRefreshListener getRefreshListener();

    float getScale();

    java.lang.String getTitle();

    java.lang.String getUrl();

    java.lang.String getUrlStr();

    java.lang.String getUserAgentString();

    android.view.ViewGroup getWebView();

    int getWebViewScrollY();

    void goBackOrForward(int i);

    void init();

    void initScalable(boolean z);

    boolean isDidTouch();

    void listenPageFinishTimeout(java.lang.String str);

    void loadData(java.lang.String str, java.lang.String str2, java.lang.String str3);

    void loadDataWithBaseURL(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5);

    void loadUrl(java.lang.String str);

    void onPageStarted();

    void onPause();

    void onPreloadJSContent(java.lang.String str);

    void onRefresh(int i);

    void onResume();

    void onUpdatePlusData(java.lang.String str);

    void putHeads(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map);

    void reload();

    void removeAllCookie();

    void removeSessionCookie();

    void setBlockNetworkImage(boolean z);

    void setCookie(java.lang.String str, java.lang.String str2);

    void setDcloudwebviewclientListener(io.dcloud.common.DHInterface.IDCloudWebviewClientListener iDCloudWebviewClientListener);

    void setDidTouch(boolean z);

    void setHorizontalScrollBarEnabled(boolean z);

    void setPageTitle(java.lang.String str);

    void setUrlStr(java.lang.String str);

    void setUserAgentString(java.lang.String str);

    void setVerticalScrollBarEnabled(boolean z);

    void setWebViewCacheMode(java.lang.String str);

    void stopLoading();

    void webReload(boolean z);
}
