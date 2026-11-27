package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class ATagUtil {
    public static void onClick(android.view.View view, java.lang.String str, java.lang.String str2) {
        com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
        if (sDKInstance == null) {
            return;
        }
        java.lang.String string = sDKInstance.rewriteUri(android.net.Uri.parse(str2), io.dcloud.feature.uniapp.adapter.AbsURIAdapter.LINK).toString();
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        jSONArray.add(string);
        com.taobao.weex.WXSDKManager.getInstance().getWXBridgeManager().callModuleMethod(str, "event", "openURL", jSONArray);
    }
}
