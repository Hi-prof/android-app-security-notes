package io.dcloud.common.adapter.ui.webview;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class WebViewFactory {
    public static boolean isAllowFileAccessFromFileURLs;
    private static io.dcloud.common.DHInterface.ICallBack otherCallBack;
    private static java.lang.Runnable otherDelyedRunnable;
    private static io.dcloud.common.DHInterface.IWebViewFactory sOtherWebViewFactory;
    private static io.dcloud.common.DHInterface.IWebViewInstallListener webViewInstallListener;
    public static java.util.ArrayList<io.dcloud.common.adapter.ui.webview.PerWrapper> sUsePermissionWebviews = new java.util.ArrayList<>();
    public static io.dcloud.common.adapter.util.PermissionUtil.StreamPermissionRequest sStreamPermissionRequest = null;
    private static boolean isOther = false;
    private static boolean isSysWebViewCreate = false;
    private static boolean isOtherInitSuccess = false;
    private static boolean isOtherInitialised = false;
    private static boolean isLoadOtherTimeOut = false;

    static {
        if (io.dcloud.common.util.BaseInfo.SyncDebug) {
            android.webkit.WebView.enableSlowWholeDocumentDraw();
        }
        otherDelyedRunnable = new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.webview.WebViewFactory.1
            @Override // java.lang.Runnable
            public void run() {
                boolean unused = io.dcloud.common.adapter.ui.webview.WebViewFactory.isLoadOtherTimeOut = true;
                if (io.dcloud.common.adapter.ui.webview.WebViewFactory.otherCallBack != null) {
                    io.dcloud.common.adapter.ui.webview.WebViewFactory.otherCallBack.onCallBack(0, null);
                    io.dcloud.common.DHInterface.ICallBack unused2 = io.dcloud.common.adapter.ui.webview.WebViewFactory.otherCallBack = null;
                }
            }
        };
        isAllowFileAccessFromFileURLs = true;
    }

    private static io.dcloud.common.DHInterface.IWebViewFactory getOtherWebViewFactory() {
        io.dcloud.common.DHInterface.IWebViewFactory iWebViewFactory;
        if (!isIsOtherInitSuccess() || (iWebViewFactory = sOtherWebViewFactory) == null || isSysWebViewCreate) {
            return null;
        }
        return iWebViewFactory;
    }

    public static io.dcloud.common.adapter.ui.webview.DCWebView getWebView(android.app.Activity activity, io.dcloud.common.adapter.ui.AdaWebview adaWebview) {
        io.dcloud.common.adapter.ui.webview.DCWebView webView = getOtherWebViewFactory() != null ? getOtherWebViewFactory().getWebView(activity, adaWebview) : null;
        if (webView != null) {
            return webView;
        }
        isSysWebViewCreate = true;
        return new io.dcloud.common.adapter.ui.webview.SysWebView(activity, adaWebview);
    }

    public static io.dcloud.common.DHInterface.IWebViewInstallListener getWebViewInstallListener() {
        return webViewInstallListener;
    }

    public static java.lang.String getWebViewUserAgentVersion(android.content.Context context) {
        return getWebViewUserAgentVersion(context, null);
    }

    public static void initOther(boolean z, long j) {
        isOther = z;
        if (j != 0) {
            io.dcloud.common.adapter.util.MessageHandler.postDelayed(otherDelyedRunnable, j);
        }
    }

    public static boolean isIsLoadOtherTimeOut() {
        return isLoadOtherTimeOut;
    }

    public static boolean isIsOtherInitSuccess() {
        return isOtherInitSuccess;
    }

    public static boolean isOther() {
        return isOther;
    }

    public static boolean isOtherInitialised() {
        return isOtherInitialised;
    }

    public static void openJSEnabled(java.lang.Object obj, io.dcloud.common.DHInterface.IApp iApp) {
        java.lang.Class[] clsArr = {java.lang.Boolean.TYPE};
        java.lang.Object[] objArr = {java.lang.Boolean.TRUE};
        java.lang.String strDecodeString = iApp != null ? iApp.getConfusionMgr().decodeString("e218Qml+aVtremF4fEtpZkd4bWZfYWZsZ397SX18Z2VpfGFraWRkcQ==") : io.dcloud.p.e1.a("e218Qml+aVtremF4fEtpZkd4bWZfYWZsZ397SX18Z2VpfGFraWRkcQ==");
        java.lang.String strDecodeString2 = iApp != null ? iApp.getConfusionMgr().decodeString("e218Qml+aVtremF4fE1maWpkbWw=") : io.dcloud.p.e1.a("e218Qml+aVtremF4fE1maWpkbWw=");
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(obj, strDecodeString, clsArr, objArr);
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(obj, strDecodeString2, clsArr, objArr);
    }

    public static void removeDelayRunnable() {
        if (io.dcloud.common.adapter.util.MessageHandler.hasCallbacks(otherDelyedRunnable)) {
            io.dcloud.common.adapter.util.MessageHandler.removeCallbacks(otherDelyedRunnable);
        }
    }

    public static void resetSysWebViewState() {
        isSysWebViewCreate = false;
    }

    public static void resetUA() {
        io.dcloud.common.util.BaseInfo.sDefWebViewUserAgent = "";
    }

    public static void setFileAccess(java.lang.Object obj, io.dcloud.common.DHInterface.IApp iApp, boolean z) {
        if (obj == null || io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer <= 16) {
            return;
        }
        try {
            java.lang.Class[] clsArr = {java.lang.Boolean.TYPE};
            java.lang.Object[] objArr = {java.lang.Boolean.valueOf(z)};
            java.lang.String strDecodeString = iApp != null ? iApp.getConfusionMgr().decodeString("eW9+S2ZmZX1fZGN8b3h5a2ZLaWlveXlMeGVnTGNmb19YRnkqNmEzZDg4ZmEtNGJhMC00NzlmLTk0MjItZTVhYWJlMTU4OTdiNzQ=", true, 10) : io.dcloud.p.e1.a("eW9+S2ZmZX1fZGN8b3h5a2ZLaWlveXlMeGVnTGNmb19YRnkqNmEzZDg4ZmEtNGJhMC00NzlmLTk0MjItZTVhYWJlMTU4OTdiNzQ=", true, 10);
            java.lang.String strDecodeString2 = iApp != null ? iApp.getConfusionMgr().decodeString("eG5/SmdnZHxNYmduSmhobnh4TXlkZk1iZ25eWUd4KjZhM2Q4OGZhLTRiYTAtNDc5Zi05NDIyLWU1YWFiZTE1ODk3Yjc1", true, 11) : io.dcloud.p.e1.a("eG5/SmdnZHxNYmduSmhobnh4TXlkZk1iZ25eWUd4KjZhM2Q4OGZhLTRiYTAtNDc5Zi05NDIyLWU1YWFiZTE1ODk3Yjc1", true, 11);
            java.lang.String strDecodeString3 = iApp != null ? iApp.getConfusionMgr().decodeString("f2l4TWBgY3tKZWBpTW9vaX9/KjZhM2Q4OGZhLTRiYTAtNDc5Zi05NDIyLWU1YWFiZTE1ODk3Yjc2", true, 12) : io.dcloud.p.e1.a("f2l4TWBgY3tKZWBpTW9vaX9/KjZhM2Q4OGZhLTRiYTAtNDc5Zi05NDIyLWU1YWFiZTE1ODk3Yjc2", true, 12);
            if (isAllowFileAccessFromFileURLs || !z) {
                io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(obj, strDecodeString, clsArr, objArr);
                io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(obj, strDecodeString2, clsArr, objArr);
            }
            io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(obj, strDecodeString3, clsArr, objArr);
        } catch (java.lang.Exception unused) {
        }
    }

    public static void setOtherCallBack(io.dcloud.common.DHInterface.ICallBack iCallBack) {
        isLoadOtherTimeOut = false;
        otherCallBack = iCallBack;
    }

    public static void setOtherState(boolean z, io.dcloud.common.DHInterface.IWebViewFactory iWebViewFactory) {
        isOtherInitSuccess = z;
        isOtherInitialised = true;
        if (otherCallBack == null) {
            if (z) {
                sOtherWebViewFactory = iWebViewFactory;
                return;
            }
            return;
        }
        io.dcloud.common.adapter.util.MessageHandler.removeCallbacks(otherDelyedRunnable);
        java.lang.Boolean bool = (java.lang.Boolean) otherCallBack.onCallBack(z ? 1 : 0, iWebViewFactory);
        if (bool != null && !bool.booleanValue()) {
            isOtherInitSuccess = false;
        } else if (isOtherInitSuccess) {
            sOtherWebViewFactory = iWebViewFactory;
        }
    }

    public static void setSslHandlerState(java.lang.Object obj, int i) {
        java.lang.String str;
        if (i != 1) {
            str = i != 2 ? "" : com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_CANCEL;
        } else {
            str = "proceed";
        }
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(obj, str, new java.lang.Class[0], new java.lang.Object[0]);
    }

    public static void setWebViewInstallListener(io.dcloud.common.DHInterface.IWebViewInstallListener iWebViewInstallListener) {
        webViewInstallListener = iWebViewInstallListener;
    }

    public static boolean verifyVersion(java.lang.String str, java.lang.String str2) {
        java.lang.String[] strArrSplit = str.split("\\.");
        java.lang.String[] strArrSplit2 = str2.split("\\.");
        int i = 0;
        while (true) {
            if (i >= strArrSplit.length && i >= strArrSplit2.length) {
                return true;
            }
            int i2 = i < strArrSplit.length ? java.lang.Integer.parseInt(strArrSplit[i]) : 0;
            int i3 = i < strArrSplit2.length ? java.lang.Integer.parseInt(strArrSplit2[i]) : 0;
            if (i2 > i3) {
                return true;
            }
            if (i2 < i3) {
                return false;
            }
            i++;
        }
    }

    public static java.lang.String getDefWebViewUA(android.content.Context context) {
        java.lang.String defWebViewUA = getOtherWebViewFactory() != null ? getOtherWebViewFactory().getDefWebViewUA(context) : "";
        return io.dcloud.common.util.PdrUtil.isEmpty(defWebViewUA) ? android.webkit.WebSettings.getDefaultUserAgent(context) : defWebViewUA;
    }

    public static java.lang.String getWebViewUserAgentVersion(android.content.Context context, java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            if (io.dcloud.common.util.PdrUtil.isEmpty(io.dcloud.common.util.BaseInfo.sDefWebViewUserAgent)) {
                io.dcloud.common.util.BaseInfo.sDefWebViewUserAgent = getDefWebViewUA(context);
            }
            str = io.dcloud.common.util.BaseInfo.sDefWebViewUserAgent;
        }
        java.lang.String[] strArrSplit = str.split(com.taobao.weex.el.parse.Operators.SPACE_STR);
        for (int length = strArrSplit.length - 1; length > 0; length--) {
            java.lang.String str2 = strArrSplit[length];
            if (io.dcloud.common.util.PdrUtil.isContains(str2.toLowerCase(), "chrome")) {
                java.lang.String[] strArrSplit2 = str2.split("/");
                return strArrSplit2.length > 1 ? strArrSplit2[1] : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT;
            }
        }
        return com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT;
    }

    public static io.dcloud.common.adapter.ui.webview.DCWebView getWebView(android.app.Activity activity, io.dcloud.common.adapter.ui.AdaWebview adaWebview, io.dcloud.common.DHInterface.IDCloudWebviewClientListener iDCloudWebviewClientListener) {
        io.dcloud.common.adapter.ui.webview.DCWebView webView = getOtherWebViewFactory() != null ? getOtherWebViewFactory().getWebView(activity, adaWebview, iDCloudWebviewClientListener) : null;
        if (webView != null) {
            return webView;
        }
        isSysWebViewCreate = true;
        return new io.dcloud.common.adapter.ui.webview.SysWebView(activity, adaWebview, iDCloudWebviewClientListener);
    }

    public static io.dcloud.common.adapter.ui.webview.DCWebView getWebView(android.app.Activity activity, io.dcloud.common.adapter.ui.AdaWebview adaWebview, io.dcloud.common.adapter.ui.webview.OnPageFinishedCallack onPageFinishedCallack) {
        io.dcloud.common.adapter.ui.webview.DCWebView webView = getOtherWebViewFactory() != null ? getOtherWebViewFactory().getWebView(activity, adaWebview, onPageFinishedCallack) : null;
        if (webView != null) {
            return webView;
        }
        isSysWebViewCreate = true;
        return new io.dcloud.common.adapter.ui.webview.SysWebView(activity, adaWebview, onPageFinishedCallack);
    }

    public static void setFileAccess(java.lang.Object obj, boolean z) {
        if (obj != null) {
            setFileAccess(obj, null, z);
        }
    }
}
