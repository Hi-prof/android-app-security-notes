package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class GraphicActionRefreshFinish extends com.taobao.weex.ui.action.BasicGraphicAction {
    private int mLayoutHeight;
    private int mLayoutWidth;

    public GraphicActionRefreshFinish(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        super(wXSDKInstance, "");
        com.taobao.weex.ui.component.WXComponent rootComponent = wXSDKInstance.getRootComponent();
        if (rootComponent != null) {
            this.mLayoutWidth = (int) rootComponent.getLayoutWidth();
            this.mLayoutHeight = (int) rootComponent.getLayoutHeight();
        }
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        com.taobao.weex.WXSDKInstance wXSDKIntance = getWXSDKIntance();
        if (wXSDKIntance == null || wXSDKIntance.getContext() == null) {
            return;
        }
        wXSDKIntance.onRefreshSuccess(this.mLayoutWidth, this.mLayoutHeight);
    }
}
