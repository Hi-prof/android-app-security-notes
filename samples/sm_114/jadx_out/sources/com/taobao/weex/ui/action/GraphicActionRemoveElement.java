package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class GraphicActionRemoveElement extends com.taobao.weex.ui.action.BasicGraphicAction {
    public GraphicActionRemoveElement(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str) {
        super(wXSDKInstance, str);
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        com.taobao.weex.ui.component.WXComponent wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), getRef());
        if (wXComponent == null || wXComponent.getParent() == null || wXComponent.getInstance() == null) {
            return;
        }
        clearRegistryForComponent(wXComponent);
        com.taobao.weex.ui.component.WXVContainer parent = wXComponent.getParent();
        if (wXComponent.getHostView() != null && !android.text.TextUtils.equals(wXComponent.getComponentType(), "video") && !android.text.TextUtils.equals(wXComponent.getComponentType(), "videoplus")) {
            wXComponent.getHostView().getLocationInWindow(new int[2]);
        }
        parent.remove(wXComponent, true);
    }

    private void clearRegistryForComponent(com.taobao.weex.ui.component.WXComponent wXComponent) {
        com.taobao.weex.ui.component.WXComponent wXComponentUnregisterComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().unregisterComponent(getPageId(), getRef());
        if (wXComponentUnregisterComponent != null) {
            wXComponentUnregisterComponent.removeAllEvent();
            wXComponentUnregisterComponent.removeStickyStyle();
        }
        if (wXComponent instanceof com.taobao.weex.ui.component.WXVContainer) {
            com.taobao.weex.ui.component.WXVContainer wXVContainer = (com.taobao.weex.ui.component.WXVContainer) wXComponent;
            for (int iChildCount = wXVContainer.childCount() - 1; iChildCount >= 0; iChildCount--) {
                clearRegistryForComponent(wXVContainer.getChild(iChildCount));
            }
        }
    }
}
