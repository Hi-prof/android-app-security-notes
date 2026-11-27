package io.dcloud.common.util;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class Deprecated_JSUtil {
    Deprecated_JSUtil() {
    }

    @java.lang.Deprecated
    public static void excCallbackError(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
        excCallbackError(iWebview, str, str2, false);
    }

    @java.lang.Deprecated
    public static void excCallbackSuccess(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
        excCallbackSuccess(iWebview, str, str2, false);
    }

    @java.lang.Deprecated
    public static void execCallback(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, int i, boolean z, boolean z2) {
        java.lang.String string;
        if (iWebview != null) {
            if (iWebview instanceof io.dcloud.common.adapter.ui.AdaUniWebView) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("var result= {};result.status = %d;result.message = ");
                sb.append(z ? "%s" : "'%s'");
                sb.append(";result.keepCallback = ");
                sb.append(z2);
                sb.append(";plus.bridge.callbackFromNative('%s', result);");
                string = sb.toString();
            } else {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("(function(w,n){try{var plus=((w.__html5plus__&&w.__html5plus__.isReady)?w.__html5plus__:(n.plus&&n.plus.isReady)?n.plus:window.plus);var result= {};result.status = %d;result.message = ");
                sb2.append(z ? "%s" : "'%s'");
                sb2.append(";result.keepCallback = ");
                sb2.append(z2);
                sb2.append(";plus && plus.bridge.callbackFromNative('%s', result);}catch(e){console.error(e.stack)};})(window,navigator);");
                string = sb2.toString();
            }
            iWebview.executeScript(io.dcloud.common.util.StringUtil.format(string, java.lang.Integer.valueOf(i), str2, str));
        }
    }

    @java.lang.Deprecated
    public static java.lang.String wrapJsVar(java.lang.String str, boolean z) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("(function(){return ");
        if (z) {
            stringBuffer.append("'").append(str).append("';");
        } else {
            stringBuffer.append(str).append(";");
        }
        stringBuffer.append("})()");
        return stringBuffer.toString();
    }

    @java.lang.Deprecated
    public static void excCallbackError(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, boolean z) {
        execCallback(iWebview, str, str2, io.dcloud.common.util.JSUtil.ERROR, z, false);
    }

    @java.lang.Deprecated
    public static void excCallbackSuccess(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, boolean z) {
        excCallbackSuccess(iWebview, str, str2, z, false);
    }

    @java.lang.Deprecated
    public static void excDownloadCallBack(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
        iWebview.executeScript(io.dcloud.common.util.StringUtil.format(iWebview instanceof io.dcloud.common.adapter.ui.AdaUniWebView ? "plus.downloader.__handlerEvt__('%s', %s);" : "((window.__html5plus__&&__html5plus__.isReady)?__html5plus__:(navigator.plus&&navigator.plus.isReady)?navigator.plus:window.plus).downloader.__handlerEvt__('%s', %s);", str2, str));
    }

    @java.lang.Deprecated
    public static void excUploadCallBack(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
        iWebview.executeScript(io.dcloud.common.util.StringUtil.format(iWebview instanceof io.dcloud.common.adapter.ui.AdaUniWebView ? "plus.uploader.__handlerEvt__('%s', %s);" : "((window.__html5plus__&&__html5plus__.isReady)?__html5plus__:(navigator.plus&&navigator.plus.isReady)?navigator.plus:window.plus).uploader.__handlerEvt__('%s', %s);", str2, str));
    }

    @java.lang.Deprecated
    public static void excCallbackSuccess(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, boolean z, boolean z2) {
        execCallback(iWebview, str, str2, 1, z, z2);
    }
}
