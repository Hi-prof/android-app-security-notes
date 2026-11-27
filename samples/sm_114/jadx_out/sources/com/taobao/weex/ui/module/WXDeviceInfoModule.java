package com.taobao.weex.ui.module;

/* JADX INFO: loaded from: classes.dex */
public class WXDeviceInfoModule extends com.taobao.weex.common.WXModule {
    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void enableFullScreenHeight(com.taobao.weex.bridge.JSCallback jSCallback, com.alibaba.fastjson.JSONObject jSONObject) {
        if (this.mWXSDKInstance != null) {
            this.mWXSDKInstance.setEnableFullScreenHeight(true);
            if (jSCallback != null) {
                long screenHeight = com.taobao.weex.utils.WXViewUtils.getScreenHeight(this.mWXSDKInstance.getInstanceId());
                java.util.HashMap map = new java.util.HashMap();
                map.put("fullScreenHeight", java.lang.String.valueOf(screenHeight));
                jSCallback.invoke(map);
            }
        }
    }
}
