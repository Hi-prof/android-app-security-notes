package io.dcloud.feature.internal.sdk;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class SDK {
    public static final java.lang.String ANDROID_ASSET = "file:///android_asset/";
    public static final java.lang.String DEFAULT_APPID = "Default_Appid";
    public static final java.lang.String UNIMP_CAPSULE_BUTTON_CLICK = "unimp_capsule_button_click";
    public static final java.lang.String UNIMP_ERROR_KEY = "UniMP_Error";
    public static final java.lang.String UNIMP_EVENT_CALLBACKID = "callbackId";
    public static final java.lang.String UNIMP_EVENT_CALL_INSTANCEID = "instanceId";
    public static final java.lang.String UNIMP_JS_TO_NATIVE = "unimp_js_to_native";
    public static final java.lang.String UNIMP_OPEN = "open_unimp";
    public static final int UNI_CODE_ERROR_APPID = -1003;
    public static final int UNI_CODE_ERROR_NOT_RES = -1001;
    public static final int UNI_CODE_ERROR_NO_V3 = -1002;
    public static java.lang.String customOAID = "";
    public static java.lang.String hostAppThemeDark = "";
    public static boolean isCapsule = false;
    public static boolean isEnableBackground = false;
    public static boolean isNJS = true;
    public static boolean isUniMP = false;
    public static java.lang.String mHostInfo = null;
    static io.dcloud.common.DHInterface.ICore sCore = null;
    public static java.lang.String sDefaultMenuButton = null;
    public static boolean uniMPSilentMode = false;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public enum IntegratedMode {
        WEBVIEW,
        WEBAPP,
        RUNTIME
    }

    private SDK() {
    }

    public static void closeWebView(io.dcloud.common.DHInterface.IWebview iWebview) {
        if (isUniMPSDK()) {
            return;
        }
        ((io.dcloud.common.adapter.ui.AdaFrameItem) iWebview.obtainFrameView()).getAnimOptions().mOption = (byte) 1;
        sCore.dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 2, iWebview.obtainFrameView());
    }

    private static io.dcloud.common.DHInterface.IWebview createWebView(io.dcloud.common.DHInterface.IApp iApp, java.lang.String str, org.json.JSONObject jSONObject, io.dcloud.common.DHInterface.IFrameView iFrameView, io.dcloud.common.DHInterface.IEventCallback iEventCallback) {
        if (isUniMPSDK()) {
            return null;
        }
        io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView = ((io.dcloud.common.DHInterface.IFrameView) sCore.dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 3, new java.lang.Object[]{0, iApp, new java.lang.Object[]{str, jSONObject}, iFrameView, iEventCallback})).obtainWebView();
        iWebviewObtainWebView.loadUrl(str);
        return iWebviewObtainWebView;
    }

    public static void initSDK(io.dcloud.common.DHInterface.ICore iCore) {
        sCore = iCore;
    }

    public static boolean isAgreePrivacy(android.content.Context context) {
        if (context == null) {
            return false;
        }
        return !io.dcloud.common.ui.PrivacyManager.getInstance().isNotPrivacyAllRight(context);
    }

    public static boolean isUniMPSDK() {
        if (io.dcloud.common.util.PdrUtil.isUniMPHostForUniApp()) {
            return isUniMP;
        }
        return false;
    }

    public static java.util.ArrayList<io.dcloud.common.DHInterface.IWebview> obtainAllIWebview(java.lang.String str) {
        java.util.ArrayList arrayList = (java.util.ArrayList) sCore.dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 6, str);
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        java.util.ArrayList<io.dcloud.common.DHInterface.IWebview> arrayList2 = new java.util.ArrayList<>();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            java.lang.Object obj = arrayList.get(i);
            i++;
            arrayList2.add(((io.dcloud.common.DHInterface.IFrameView) obj).obtainWebView());
        }
        return arrayList2;
    }

    public static io.dcloud.common.DHInterface.IApp obtainCurrentApp() {
        if (isUniMPSDK()) {
            return null;
        }
        return (io.dcloud.common.DHInterface.IApp) sCore.dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 6, obtainCurrentRunnbingAppId());
    }

    public static java.lang.String obtainCurrentRunnbingAppId() {
        if (isUniMPSDK()) {
            return null;
        }
        return java.lang.String.valueOf(sCore.dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 11, null));
    }

    public static io.dcloud.common.DHInterface.IWebview obtainWebview(java.lang.String str, java.lang.String str2) {
        java.util.ArrayList<io.dcloud.common.DHInterface.IWebview> arrayListObtainAllIWebview = obtainAllIWebview(str);
        int size = arrayListObtainAllIWebview.size();
        int i = 0;
        while (i < size) {
            io.dcloud.common.DHInterface.IWebview iWebview = arrayListObtainAllIWebview.get(i);
            i++;
            io.dcloud.common.DHInterface.IWebview iWebview2 = iWebview;
            if (io.dcloud.common.util.PdrUtil.isEquals(str2, iWebview2.getWebviewUUID())) {
                return iWebview2;
            }
        }
        return null;
    }

    public static void popWebView(io.dcloud.common.DHInterface.IWebview iWebview) {
        if (isUniMPSDK()) {
            return;
        }
        ((io.dcloud.common.adapter.ui.AdaFrameItem) iWebview.obtainFrameView()).getAnimOptions().mOption = (byte) 1;
        sCore.dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 21, iWebview.obtainFrameView());
    }

    public static void registerJsApi(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (isUniMPSDK()) {
            return;
        }
        sCore.dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 5, new java.lang.String[]{str, str2, str3});
    }

    public static void requestAllFeature() {
        if (isUniMPSDK()) {
            return;
        }
        sCore.dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 7, null);
    }

    public static void requestFeature(java.lang.String str, java.lang.String str2, boolean z) {
        if (isUniMPSDK()) {
            return;
        }
        sCore.dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 6, new java.lang.String[]{str, str2, java.lang.String.valueOf(z)});
    }

    public static void setAgreePrivacy(android.content.Context context, boolean z) {
        if (context == null) {
            return;
        }
        io.dcloud.common.ui.PrivacyManager.getInstance().setAgreePrivacy(context, z);
    }

    public static void setUniMPSilentMode(boolean z) {
        uniMPSilentMode = z;
    }

    public static java.util.ArrayList<io.dcloud.common.DHInterface.IWebview> obtainAllIWebview() {
        if (isUniMPSDK()) {
            return null;
        }
        return obtainAllIWebview(obtainCurrentRunnbingAppId());
    }
}
