package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class GraphicActionMoveElement extends com.taobao.weex.ui.action.BasicGraphicAction {
    private int mIndex;
    private java.lang.String mParentref;

    public GraphicActionMoveElement(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.lang.String str2, int i) {
        super(wXSDKInstance, str);
        this.mParentref = str2;
        this.mIndex = i;
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        com.taobao.weex.ui.component.WXComponent wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), getRef());
        if (wXComponent == null) {
            return;
        }
        com.taobao.weex.ui.component.WXVContainer parent = wXComponent.getParent();
        com.taobao.weex.ui.component.WXComponent wXComponent2 = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), this.mParentref);
        if (parent == null || wXComponent2 == null || !(wXComponent2 instanceof com.taobao.weex.ui.component.WXVContainer)) {
            return;
        }
        if (wXComponent.getHostView() != null && !android.text.TextUtils.equals(wXComponent.getComponentType(), "video") && !android.text.TextUtils.equals(wXComponent.getComponentType(), "videoplus")) {
            wXComponent.getHostView().getLocationInWindow(new int[2]);
        }
        parent.remove(wXComponent, false);
        com.taobao.weex.ui.component.WXVContainer wXVContainer = (com.taobao.weex.ui.component.WXVContainer) wXComponent2;
        wXVContainer.addChild(wXComponent, this.mIndex);
        if (wXComponent.getHostView() != null && !android.text.TextUtils.equals(wXComponent.getComponentType(), "video") && !android.text.TextUtils.equals(wXComponent.getComponentType(), "videoplus")) {
            wXComponent.getHostView().getLocationInWindow(new int[2]);
        }
        if (wXComponent.isVirtualComponent()) {
            return;
        }
        wXVContainer.addSubView(wXComponent.getHostView(), this.mIndex);
    }
}
