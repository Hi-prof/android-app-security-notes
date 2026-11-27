package io.dcloud.feature.weex.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class DCVueBridgeAdapter implements com.taobao.weex.bridge.IDCVueBridgeAdapter {
    @Override // com.taobao.weex.bridge.IDCVueBridgeAdapter
    public void exec(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.lang.String str2) {
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(wXSDKInstance);
        if (iWebviewFindWebview instanceof io.dcloud.common.adapter.ui.AdaUniWebView) {
            ((io.dcloud.common.adapter.ui.AdaUniWebView) iWebviewFindWebview).prompt(str, str2);
        }
    }

    @Override // com.taobao.weex.bridge.IDCVueBridgeAdapter
    public java.lang.String execSync(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.lang.String str2) {
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(wXSDKInstance);
        if (iWebviewFindWebview instanceof io.dcloud.common.adapter.ui.AdaUniWebView) {
            return ((io.dcloud.common.adapter.ui.AdaUniWebView) iWebviewFindWebview).prompt(str, str2);
        }
        return "";
    }
}
