package io.dcloud.common.adapter.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class ReceiveJSValue implements io.dcloud.common.DHInterface.IReflectAble {
    public static java.lang.String SYNC_HANDLER = "SYNC_HANDLER";
    private static java.util.HashMap<java.lang.String, io.dcloud.common.adapter.ui.ReceiveJSValue.ReceiveJSValueCallback> arrs = new java.util.HashMap<>();
    private java.lang.String android42Js = null;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface ReceiveJSValueCallback {
        java.lang.String callback(org.json.JSONArray jSONArray);
    }

    public static final java.lang.String registerCallback(java.lang.String str, io.dcloud.common.adapter.ui.ReceiveJSValue.ReceiveJSValueCallback receiveJSValueCallback) {
        return registerCallback(null, str, receiveJSValueCallback);
    }

    @android.webkit.JavascriptInterface
    public final java.lang.String __js__call__native__(java.lang.String str, java.lang.String str2) {
        io.dcloud.common.adapter.ui.ReceiveJSValue.ReceiveJSValueCallback receiveJSValueCallbackRemove = arrs.remove(str);
        io.dcloud.common.adapter.util.Logger.d("ReceiveJSValue", "__js__call__native__ js=" + str2);
        return receiveJSValueCallbackRemove != null ? receiveJSValueCallbackRemove.callback(io.dcloud.common.util.JSONUtil.createJSONArray(str2)) : "";
    }

    public static final void addJavascriptInterface(io.dcloud.common.adapter.ui.AdaWebview adaWebview) {
        adaWebview.mWebViewImpl.addJavascriptInterface(new io.dcloud.common.adapter.ui.ReceiveJSValue(), SYNC_HANDLER);
    }

    public static final java.lang.String registerCallback(io.dcloud.common.adapter.ui.AdaWebview adaWebview, java.lang.String str, io.dcloud.common.adapter.ui.ReceiveJSValue.ReceiveJSValueCallback receiveJSValueCallback) {
        io.dcloud.common.adapter.ui.ReceiveJSValue receiveJSValue;
        java.lang.String strValueOf = java.lang.String.valueOf(receiveJSValueCallback.hashCode());
        arrs.put(strValueOf, receiveJSValueCallback);
        return ((adaWebview == null || (receiveJSValue = adaWebview.mReceiveJSValue_android42) == null) ? "" : receiveJSValue.android42Js) + io.dcloud.common.util.StringUtil.format("window.SYNC_HANDLER && " + SYNC_HANDLER + ".__js__call__native__('" + strValueOf + "',(function(){var ret = %s;var type = (typeof ret );return JSON.stringify([type,ret]);})());", str);
    }
}
