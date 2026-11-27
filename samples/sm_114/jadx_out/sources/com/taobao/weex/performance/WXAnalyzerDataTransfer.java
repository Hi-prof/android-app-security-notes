package com.taobao.weex.performance;

/* JADX INFO: loaded from: classes.dex */
public class WXAnalyzerDataTransfer {
    private static final java.lang.String GROUP = "WXAnalyzer";
    public static final java.lang.String INTERACTION_TAG = "wxInteractionAnalyzer";
    private static final java.lang.String MODULE_ERROR = "WXError";
    private static final java.lang.String MODULE_WX_APM = "wxapm";
    public static boolean isOpenPerformance = false;
    private static boolean sOpenInteractionLog;

    public static void transferPerformance(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.Object obj) {
        com.taobao.weex.WXSDKInstance wXSDKInstance;
        if (isOpenPerformance) {
            if (sOpenInteractionLog && "stage".equals(str2)) {
                android.util.Log.d(INTERACTION_TAG, "[client][stage]" + str + "," + str3 + "," + obj);
            }
            java.util.List<com.taobao.weex.performance.IWXAnalyzer> wXAnalyzerList = com.taobao.weex.WXSDKManager.getInstance().getWXAnalyzerList();
            if (wXAnalyzerList == null || wXAnalyzerList.size() == 0 || (wXSDKInstance = com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().get(str)) == null) {
                return;
            }
            try {
                java.lang.String string = new org.json.JSONObject().put(str3, obj).toString();
                java.util.Iterator<com.taobao.weex.performance.IWXAnalyzer> it = wXAnalyzerList.iterator();
                while (it.hasNext()) {
                    it.next().transfer(MODULE_WX_APM, wXSDKInstance.getInstanceId(), str2, string);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void transferInteractionInfo(com.taobao.weex.ui.component.WXComponent wXComponent) {
        java.util.List<com.taobao.weex.performance.IWXAnalyzer> wXAnalyzerList;
        if (!isOpenPerformance || (wXAnalyzerList = com.taobao.weex.WXSDKManager.getInstance().getWXAnalyzerList()) == null || wXAnalyzerList.size() == 0) {
            return;
        }
        try {
            java.lang.String string = new org.json.JSONObject().put("renderOriginDiffTime", com.taobao.weex.utils.WXUtils.getFixUnixTime() - wXComponent.getInstance().getWXPerformance().renderUnixTimeOrigin).put("type", wXComponent.getComponentType()).put("ref", wXComponent.getRef()).put("style", wXComponent.getStyles()).put(com.taobao.weex.ui.component.list.template.TemplateDom.KEY_ATTRS, wXComponent.getAttrs()).toString();
            java.util.Iterator<com.taobao.weex.performance.IWXAnalyzer> it = wXAnalyzerList.iterator();
            while (it.hasNext()) {
                it.next().transfer(MODULE_WX_APM, wXComponent.getInstanceId(), "wxinteraction", string);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void transferError(com.taobao.weex.common.WXJSExceptionInfo wXJSExceptionInfo, java.lang.String str) {
        java.util.List<com.taobao.weex.performance.IWXAnalyzer> wXAnalyzerList;
        com.taobao.weex.WXSDKInstance sDKInstance;
        java.lang.String string;
        if (!com.taobao.weex.WXEnvironment.isApkDebugable() || (wXAnalyzerList = com.taobao.weex.WXSDKManager.getInstance().getWXAnalyzerList()) == null || wXAnalyzerList.size() == 0 || (sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str)) == null) {
            return;
        }
        com.taobao.weex.common.WXErrorCode errCode = wXJSExceptionInfo.getErrCode();
        try {
            string = new org.json.JSONObject().put("instanceId", str).put("url", sDKInstance.getBundleUrl()).put("errorCode", errCode.getErrorCode()).put("errorMsg", errCode.getErrorMsg()).put("errorGroup", errCode.getErrorGroup()).toString();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            string = "";
        }
        java.util.Iterator<com.taobao.weex.performance.IWXAnalyzer> it = wXAnalyzerList.iterator();
        while (it.hasNext()) {
            it.next().transfer(GROUP, MODULE_ERROR, errCode.getErrorType().toString(), string);
        }
    }

    public static void switchInteractionLog(boolean z) {
        if (sOpenInteractionLog == z || !com.taobao.weex.WXEnvironment.JsFrameworkInit) {
            return;
        }
        sOpenInteractionLog = z;
        com.taobao.weex.bridge.WXBridgeManager.getInstance().registerCoreEnv("switchInteractionLog", java.lang.String.valueOf(z));
    }

    public static boolean isInteractionLogOpen() {
        return sOpenInteractionLog;
    }
}
