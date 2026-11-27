package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class JSUtil extends io.dcloud.common.util.Deprecated_JSUtil {
    public static int CLASS_NOT_FOUND_EXCEPTION = 2;
    public static final java.lang.String COMMA = ",";
    public static int ERROR = 9;
    public static int ILLEGAL_ACCESS_EXCEPTION = 3;
    public static int INSTANTIATION_EXCEPTION = 4;
    public static int INVALID_ACTION = 7;
    public static int IO_EXCEPTION = 6;
    public static int JSON_EXCEPTION = 8;
    public static int MALFORMED_URL_EXCEPTION = 5;
    public static int NO_RESULT = 0;
    public static int OK = 1;
    public static final java.lang.String QUOTE = "\"";

    public static java.lang.String arrayList2JsStringArray(java.util.ArrayList<java.lang.String> arrayList) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(com.taobao.weex.el.parse.Operators.ARRAY_START_STR);
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                stringBuffer.append("'").append(arrayList.get(i)).append("'");
                if (i != size - 1) {
                    stringBuffer.append(",");
                }
            }
        }
        stringBuffer.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        return stringBuffer.toString();
    }

    public static boolean checkOperateDirErrorAndCallback(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
        if (!iWebview.obtainFrameView().obtainApp().checkPrivateDir(str2)) {
            return false;
        }
        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 9, io.dcloud.common.constant.DOMException.MSG_OPERATE_DIR_ERROR), ERROR, true, false);
        return true;
    }

    public static java.lang.String consoleTest(java.lang.String str) {
        return "console.error('" + str + "');";
    }

    public static void execGEOCallback(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, int i, boolean z, boolean z2) {
        if (iWebview != null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("(function(){try{var result= {};result.status = %d;result.message = ");
            sb.append(z ? "%s" : "'%s'");
            sb.append(";result.keepCallback = ");
            sb.append(z2);
            sb.append(";__geo__.callbackFromNative('%s', result);}catch(e){console.error(e.stack)};})(window,navigator);");
            iWebview.executeScript(io.dcloud.common.util.StringUtil.format(sb.toString(), java.lang.Integer.valueOf(i), str2, str));
        }
    }

    public static java.lang.String[] jsonArrayToStringArr(org.json.JSONArray jSONArray) throws org.json.JSONException {
        java.lang.String[] strArr = new java.lang.String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = jSONArray.getString(i);
        }
        return strArr;
    }

    public static java.lang.String toJsResponseText(java.lang.String str) {
        return !io.dcloud.common.util.PdrUtil.isEmpty(str) ? str.replace("'", "'").replace(QUOTE, "\\\"").replace("\n", "\\n").replace("\r", "\\r") : str;
    }

    public static void broadcastWebviewEvent(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String str4 = io.dcloud.common.util.StringUtil.format(iWebview instanceof io.dcloud.common.adapter.ui.AdaUniWebView ? "if(plus.webview.__Webview_LoadEvent_CallBack_) {plus.webview.__Webview_LoadEvent_CallBack_(%s);}" : "(function(w,n){var p = ((w.__html5plus__&&w.__html5plus__.isReady)?w.__html5plus__:(n.plus&&n.plus.isReady)?n.plus:window.plus);p && p.webview && p.webview.__Webview_LoadEvent_CallBack_ && p.webview.__Webview_LoadEvent_CallBack_(%s);})(window,navigator)", io.dcloud.common.util.StringUtil.format("{WebviewID:'%s',Event:'%s',Msg:%s}", str, str2, str3));
        if (iWebview != null) {
            iWebview.executeScript(str4);
        }
    }

    public static void execCallback(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, int i, boolean z) {
        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, str2, i, false, z);
    }

    public static java.lang.String wrapJsVar(double d) {
        return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(java.lang.String.valueOf(d), false);
    }

    public static void execCallback(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, double d, int i, boolean z) {
        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, java.lang.String.valueOf(d), i, true, z);
    }

    public static java.lang.String wrapJsVar(float f) {
        return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(java.lang.String.valueOf(f), false);
    }

    public static void execCallback(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONArray jSONArray, int i, boolean z) {
        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, jSONArray.toString(), i, true, z);
    }

    public static java.lang.String wrapJsVar(org.json.JSONArray jSONArray) {
        return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(jSONArray.toString(), false);
    }

    public static void execCallback(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONObject jSONObject, int i, boolean z) {
        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, jSONObject.toString(), i, true, z);
    }

    public static java.lang.String wrapJsVar(org.json.JSONObject jSONObject) {
        return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(jSONObject.toString(), false);
    }

    public static java.lang.String wrapJsVar(java.lang.String str) {
        return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(str, true);
    }

    public static java.lang.String wrapJsVar(boolean z) {
        return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(java.lang.String.valueOf(z), false);
    }
}
