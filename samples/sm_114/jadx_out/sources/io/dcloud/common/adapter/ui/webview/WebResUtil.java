package io.dcloud.common.adapter.ui.webview;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class WebResUtil {
    private static final java.lang.String F_WT = "wap2app__template/";

    public static java.io.InputStream getEncryptionInputStream(java.lang.String str, io.dcloud.common.DHInterface.IApp iApp) {
        return iApp.getConfusionMgr().getEncryptionInputStream(str, iApp);
    }

    public static java.lang.String getHBuilderPrintUrl(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        java.lang.String str2 = io.dcloud.common.util.BaseInfo.REL_PRIVATE_WWW_DIR + java.io.File.separator;
        return str.startsWith(str2) ? str.substring(str2.length()) : str;
    }

    public static java.lang.String getOriginalUrl(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        return str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL) ? str.substring(7) : str;
    }

    public static java.lang.String getRelPath(java.lang.String str, io.dcloud.common.DHInterface.IApp iApp) {
        java.lang.String originalUrl = getOriginalUrl(str);
        int iIndexOf = originalUrl.indexOf(F_WT);
        return iIndexOf >= 0 ? originalUrl.substring(iIndexOf + 18) : getHBuilderPrintUrl(iApp.convert2RelPath(originalUrl));
    }

    public static java.lang.String handleWap2appTemplateFilePath(java.lang.String str) {
        return io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + F_WT + str;
    }

    public static boolean isWap2appTemplateFile(io.dcloud.common.DHInterface.IApp iApp, java.lang.String str) {
        return io.dcloud.common.util.BaseInfo.containsInTemplate(iApp, str);
    }

    public static java.lang.Object opAdData(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        return io.dcloud.p.l.a(context, str, str2, obj);
    }
}
