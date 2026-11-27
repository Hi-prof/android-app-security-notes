package com.taobao.weex.ui.module;

/* JADX INFO: loaded from: classes.dex */
public class WXMetaModule extends com.taobao.weex.common.WXModule {
    public static final java.lang.String DEVICE_WIDTH = "device-width";
    public static final java.lang.String WIDTH = "width";

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void setViewport(java.lang.String str) {
        if (io.dcloud.feature.weex.WeexInstanceMgr.self().getComplier().equalsIgnoreCase("weex") && !android.text.TextUtils.isEmpty(str)) {
            try {
                com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(java.net.URLDecoder.decode(str, "utf-8"));
                android.content.Context context = this.mWXSDKInstance.getContext();
                if (DEVICE_WIDTH.endsWith(object.getString("width"))) {
                    int screenWidth = (int) (com.taobao.weex.utils.WXViewUtils.getScreenWidth(context) / com.taobao.weex.utils.WXViewUtils.getScreenDensity(context));
                    this.mWXSDKInstance.setInstanceViewPortWidth(screenWidth);
                    com.taobao.weex.utils.WXLogUtils.d("[WXMetaModule] setViewport success[device-width]=" + screenWidth);
                    return;
                }
                int iIntValue = object.getInteger("width").intValue();
                if (iIntValue > 0) {
                    this.mWXSDKInstance.setInstanceViewPortWidth(iIntValue);
                }
                com.taobao.weex.utils.WXLogUtils.d("[WXMetaModule] setViewport success[width]=" + iIntValue);
            } catch (java.lang.Exception e) {
                com.taobao.weex.utils.WXLogUtils.e("[WXMetaModule] alert param parse error ", e);
            }
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public float getViewPort() {
        return this.mWXSDKInstance.getInstanceViewPortWidthWithFloat();
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void openLog(java.lang.String str) {
        android.app.Application application = com.taobao.weex.WXEnvironment.getApplication();
        if (application == null || (application.getApplicationInfo().flags & 2) == 0) {
            return;
        }
        if (com.taobao.weex.utils.WXUtils.getBoolean(str, true).booleanValue()) {
            com.taobao.weex.WXEnvironment.setApkDebugable(true);
            if (this.mWXSDKInstance != null) {
                com.dcloud.android.widget.toast.ToastCompat.makeText(this.mWXSDKInstance.getContext(), (java.lang.CharSequence) "log open success", 0).show();
                return;
            }
            return;
        }
        com.taobao.weex.WXEnvironment.setApkDebugable(false);
        if (this.mWXSDKInstance != null) {
            com.dcloud.android.widget.toast.ToastCompat.makeText(this.mWXSDKInstance.getContext(), (java.lang.CharSequence) "log close success", 0).show();
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void getPageInfo(com.taobao.weex.bridge.JSCallback jSCallback) {
        if (jSCallback == null) {
            return;
        }
        java.util.List<com.taobao.weex.WXSDKInstance> allInstances = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getAllInstances();
        java.util.HashMap map = new java.util.HashMap(4);
        for (com.taobao.weex.WXSDKInstance wXSDKInstance : allInstances) {
            if (!android.text.TextUtils.isEmpty(wXSDKInstance.getBundleUrl())) {
                map.put(wXSDKInstance.getBundleUrl(), wXSDKInstance.getTemplateInfo());
            }
        }
        jSCallback.invoke(map);
    }
}
