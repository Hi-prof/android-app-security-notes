package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class ActionGetLayoutDirection extends com.taobao.weex.ui.action.BasicGraphicAction {
    private final java.lang.String mCallback;

    public ActionGetLayoutDirection(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.lang.String str2) {
        super(wXSDKInstance, str);
        this.mCallback = str2;
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        com.taobao.weex.WXSDKInstance wXSDKIntance = getWXSDKIntance();
        if (wXSDKIntance == null || wXSDKIntance.isDestroy()) {
            return;
        }
        com.taobao.weex.bridge.JSCallback simpleJSCallback = new com.taobao.weex.bridge.SimpleJSCallback(wXSDKIntance.getInstanceId(), this.mCallback);
        if (android.text.TextUtils.isEmpty(getRef())) {
            java.util.HashMap map = new java.util.HashMap();
            map.put("result", false);
            map.put(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_MSG, "Illegal parameter");
            simpleJSCallback.invoke(map);
            return;
        }
        if ("viewport".equalsIgnoreCase(getRef())) {
            callbackViewport(wXSDKIntance, simpleJSCallback);
            return;
        }
        com.taobao.weex.ui.component.WXComponent wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), getRef());
        if (wXComponent == null) {
            return;
        }
        java.lang.Object obj = "ltr";
        if (wXComponent != null) {
            int iNativeRenderObjectGetLayoutDirectionFromPathNode = com.taobao.weex.ui.component.list.template.jni.NativeRenderObjectUtils.nativeRenderObjectGetLayoutDirectionFromPathNode(wXComponent.getRenderObjectPtr());
            if (iNativeRenderObjectGetLayoutDirectionFromPathNode == 0) {
                obj = "inherit";
            } else if (iNativeRenderObjectGetLayoutDirectionFromPathNode != 1 && iNativeRenderObjectGetLayoutDirectionFromPathNode == 2) {
                obj = com.taobao.weex.common.Constants.Name.RTL;
            }
        }
        simpleJSCallback.invoke(obj);
    }

    private void callbackViewport(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.bridge.JSCallback jSCallback) {
        if (wXSDKInstance.getContainerView() != null) {
            java.util.HashMap map = new java.util.HashMap();
            map.put("direction", "ltr");
            map.put("result", true);
            jSCallback.invoke(map);
            return;
        }
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put("result", false);
        map2.put(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_MSG, "Component does not exist");
        jSCallback.invoke(map2);
    }

    private float getWebPxValue(int i, int i2) {
        return com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(i, i2);
    }
}
