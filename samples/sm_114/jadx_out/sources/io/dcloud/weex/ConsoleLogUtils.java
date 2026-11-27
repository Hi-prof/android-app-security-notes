package io.dcloud.weex;

/* JADX INFO: loaded from: classes2.dex */
public class ConsoleLogUtils {
    public static void consoleLog(java.lang.String str, java.lang.String str2, io.dcloud.feature.uniapp.utils.AbsLogLevel absLogLevel) {
        java.lang.String strReplace;
        java.lang.String str3;
        if (!android.text.TextUtils.isEmpty(str) && "jsLog".equals(str) && checkLog(str2)) {
            if (str2.endsWith("__ERROR")) {
                strReplace = str2.replace("__ERROR", "");
                str3 = "ERROR";
            } else if (str2.endsWith("__LOG")) {
                strReplace = str2.replace("__LOG", "");
                str3 = "LOG";
            } else if (str2.endsWith("__INFO")) {
                strReplace = str2.replace("__INFO", "");
                str3 = "INFO";
            } else if (str2.endsWith("__WARN")) {
                strReplace = str2.replace("__WARN", "");
                str3 = "WARN";
            } else {
                strReplace = str2.replace("__DEBUG", "");
                str3 = "DEBUG";
            }
            strReplace.trim();
            if (strReplace.startsWith("v8performance")) {
                io.dcloud.weex.WXDotDataUtil.setValue("initJSEngineTime", strReplace.replace("v8performance:", ""));
            } else if (strReplace.startsWith("JSCPerformance")) {
                io.dcloud.weex.WXDotDataUtil.setValue("initJSEngineTime", strReplace.replace("JSCPerformance:", ""));
            } else {
                io.dcloud.common.util.AppConsoleLogUtil.DCLog(strReplace, str3);
            }
        }
    }

    private static boolean checkLog(java.lang.String str) {
        if (str.contains("Start windmill weex-vue-plugin")) {
            return false;
        }
        if (!str.contains("has been registered already!")) {
            return true;
        }
        io.dcloud.common.adapter.util.Logger.i(str);
        return false;
    }
}
