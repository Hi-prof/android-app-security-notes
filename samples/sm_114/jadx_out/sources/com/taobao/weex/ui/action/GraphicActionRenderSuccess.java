package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class GraphicActionRenderSuccess extends com.taobao.weex.ui.action.BasicGraphicAction {
    public GraphicActionRenderSuccess(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        super(wXSDKInstance, "");
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        int layoutWidth;
        int layoutHeight;
        com.taobao.weex.WXSDKInstance wXSDKIntance = getWXSDKIntance();
        if (wXSDKIntance == null || wXSDKIntance.getContext() == null) {
            return;
        }
        com.taobao.weex.ui.component.WXComponent rootComponent = wXSDKIntance.getRootComponent();
        if (rootComponent != null) {
            layoutWidth = (int) rootComponent.getLayoutWidth();
            layoutHeight = (int) rootComponent.getLayoutHeight();
        } else {
            layoutWidth = 0;
            layoutHeight = 0;
        }
        wXSDKIntance.onRenderSuccess(layoutWidth, layoutHeight);
    }
}
