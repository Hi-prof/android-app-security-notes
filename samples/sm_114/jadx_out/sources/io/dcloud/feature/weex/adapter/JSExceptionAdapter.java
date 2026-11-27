package io.dcloud.feature.weex.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class JSExceptionAdapter implements com.taobao.weex.adapter.IWXJSExceptionAdapter {
    @Override // com.taobao.weex.adapter.IWXJSExceptionAdapter
    public void onJSException(com.taobao.weex.common.WXJSExceptionInfo wXJSExceptionInfo) {
        if (wXJSExceptionInfo == null || android.text.TextUtils.isEmpty(io.dcloud.common.util.BaseInfo.sCurrentAppOriginalAppid) || !io.dcloud.common.util.BaseInfo.sCurrentAppOriginalAppid.startsWith("__UNI__")) {
            return;
        }
        java.lang.String strReplace = "reportJSException >>>> exception function:" + wXJSExceptionInfo.getFunction() + ", exception:" + wXJSExceptionInfo.getException();
        if (strReplace.endsWith("__ERROR")) {
            strReplace = strReplace.replace("__ERROR", "");
        }
        io.dcloud.common.util.AppConsoleLogUtil.DCLog(strReplace, "ERROR");
    }
}
