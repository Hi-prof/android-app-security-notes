package io.dcloud.feature.weex.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class PlusUriAdapter implements com.taobao.weex.adapter.URIAdapter {
    @Override // io.dcloud.feature.uniapp.adapter.AbsURIAdapter
    public android.net.Uri rewrite(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, android.net.Uri uri) {
        java.lang.String strStandardizedURL;
        if (!android.text.TextUtils.isEmpty(wXSDKInstance.getBundleUrl()) && !io.dcloud.common.util.PdrUtil.isEmpty(uri)) {
            java.lang.String bundleUrl = wXSDKInstance.getBundleUrl();
            java.lang.String string = uri.toString();
            if (uri.isRelative()) {
                if (uri.getEncodedPath().length() == 0) {
                    return android.net.Uri.parse(bundleUrl);
                }
                io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(wXSDKInstance);
                if (iWebviewFindWebview != null) {
                    byte bObtainRunningAppMode = iWebviewFindWebview.obtainApp().obtainRunningAppMode();
                    if (!string.startsWith("/storage") && bObtainRunningAppMode == 1) {
                        java.lang.String strConvert2AbsFullPath = iWebviewFindWebview.obtainApp().convert2AbsFullPath(bundleUrl, string);
                        if ("web".equals(str)) {
                            strConvert2AbsFullPath = iWebviewFindWebview.obtainApp().convert2WebviewFullPath(bundleUrl, string);
                        }
                        if (strConvert2AbsFullPath.startsWith("/storage/")) {
                            strStandardizedURL = iWebviewFindWebview.obtainApp().convert2WebviewFullPath(bundleUrl, string);
                        } else {
                            if (strConvert2AbsFullPath.startsWith("/")) {
                                strConvert2AbsFullPath = strConvert2AbsFullPath.substring(1, strConvert2AbsFullPath.length());
                            }
                            if (str.equals(io.dcloud.feature.uniapp.adapter.AbsURIAdapter.FONT)) {
                                strStandardizedURL = "local:///" + strConvert2AbsFullPath;
                            } else {
                                strStandardizedURL = "asset:///" + strConvert2AbsFullPath;
                            }
                        }
                    } else {
                        strStandardizedURL = iWebviewFindWebview.obtainApp().convert2WebviewFullPath(bundleUrl, string);
                    }
                } else {
                    strStandardizedURL = standardizedURL(bundleUrl, string);
                }
                if (bundleUrl.startsWith("/storage")) {
                    strStandardizedURL = io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + strStandardizedURL;
                } else if (bundleUrl.startsWith("storage")) {
                    strStandardizedURL = "file:///" + strStandardizedURL;
                }
                return android.net.Uri.parse(strStandardizedURL);
            }
        }
        return uri;
    }

    @Override // io.dcloud.feature.uniapp.adapter.AbsURIAdapter
    public android.net.Uri rewrite(java.lang.String str, java.lang.String str2, android.net.Uri uri) {
        java.lang.String string = uri.toString();
        if (!uri.isRelative()) {
            return uri;
        }
        if (uri.getEncodedPath().length() == 0) {
            return android.net.Uri.parse(str);
        }
        return android.net.Uri.parse(standardizedURL(str, string));
    }

    private java.lang.String standardizedURL(java.lang.String str, java.lang.String str2) {
        if (str2.startsWith("./")) {
            str2 = str2.substring(2);
            int iLastIndexOf = str.lastIndexOf(47);
            if (iLastIndexOf >= 0) {
                return str.substring(0, iLastIndexOf + 1) + str2;
            }
        }
        int iIndexOf = str2.indexOf("../");
        int iLastIndexOf2 = str.lastIndexOf(47);
        if (iLastIndexOf2 <= -1) {
            return str2;
        }
        java.lang.String strSubstring = str.substring(0, iLastIndexOf2);
        while (iIndexOf > -1) {
            str2 = str2.substring(3);
            strSubstring = strSubstring.substring(0, strSubstring.lastIndexOf(47));
            iIndexOf = str2.indexOf("../");
        }
        return strSubstring + '/' + str2;
    }
}
