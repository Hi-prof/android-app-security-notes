package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class ActionGetComponentRect extends com.taobao.weex.ui.action.BasicGraphicAction {
    private final java.lang.String mCallback;

    public ActionGetComponentRect(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.lang.String str2) {
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
        java.util.HashMap map2 = new java.util.HashMap();
        if (wXComponent != null) {
            float instanceViewPortWidthWithFloat = wXSDKIntance.getInstanceViewPortWidthWithFloat();
            java.util.HashMap map3 = new java.util.HashMap();
            android.graphics.Rect componentSize = wXComponent.getComponentSize();
            map3.put("width", java.lang.Float.valueOf(getWebPxValue(componentSize.width(), instanceViewPortWidthWithFloat)));
            map3.put("height", java.lang.Float.valueOf(getWebPxValue(componentSize.height(), instanceViewPortWidthWithFloat)));
            map3.put("bottom", java.lang.Float.valueOf(getWebPxValue(componentSize.bottom, instanceViewPortWidthWithFloat)));
            map3.put("left", java.lang.Float.valueOf(getWebPxValue(componentSize.left, instanceViewPortWidthWithFloat)));
            map3.put("right", java.lang.Float.valueOf(getWebPxValue(componentSize.right, instanceViewPortWidthWithFloat)));
            map3.put("top", java.lang.Float.valueOf(getWebPxValue(componentSize.top, instanceViewPortWidthWithFloat)));
            map2.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, map3);
            map2.put("result", true);
        } else {
            map2.put(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_MSG, "Component does not exist");
        }
        simpleJSCallback.invoke(map2);
    }

    private void callbackViewport(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.bridge.JSCallback jSCallback) {
        android.view.View containerView = wXSDKInstance.getContainerView();
        if (containerView != null) {
            java.util.HashMap map = new java.util.HashMap();
            java.util.HashMap map2 = new java.util.HashMap();
            wXSDKInstance.getContainerView().getLocationOnScreen(new int[2]);
            float instanceViewPortWidthWithFloat = wXSDKInstance.getInstanceViewPortWidthWithFloat();
            map2.put("left", java.lang.Float.valueOf(0.0f));
            map2.put("top", java.lang.Float.valueOf(0.0f));
            map2.put("right", java.lang.Float.valueOf(getWebPxValue(containerView.getWidth(), instanceViewPortWidthWithFloat)));
            map2.put("bottom", java.lang.Float.valueOf(getWebPxValue(containerView.getHeight(), instanceViewPortWidthWithFloat)));
            map2.put("width", java.lang.Float.valueOf(getWebPxValue(containerView.getWidth(), instanceViewPortWidthWithFloat)));
            map2.put("height", java.lang.Float.valueOf(getWebPxValue(containerView.getHeight(), instanceViewPortWidthWithFloat)));
            map.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, map2);
            map.put("result", true);
            jSCallback.invoke(map);
            return;
        }
        java.util.HashMap map3 = new java.util.HashMap();
        map3.put("result", false);
        map3.put(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_MSG, "Component does not exist");
        jSCallback.invoke(map3);
    }

    private float getWebPxValue(int i, float f) {
        return com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(i, f);
    }
}
