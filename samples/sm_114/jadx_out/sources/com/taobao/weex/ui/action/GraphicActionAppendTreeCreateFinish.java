package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class GraphicActionAppendTreeCreateFinish extends com.taobao.weex.ui.action.BasicGraphicAction {
    com.taobao.weex.ui.component.WXComponent component;

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
    }

    public GraphicActionAppendTreeCreateFinish(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str) {
        super(wXSDKInstance, str);
        com.taobao.weex.ui.component.WXComponent wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), str);
        this.component = wXComponent;
        if (wXComponent == null || !(wXComponent instanceof com.taobao.weex.ui.component.WXVContainer)) {
            return;
        }
        ((com.taobao.weex.ui.component.WXVContainer) wXComponent).appendTreeCreateFinish();
    }
}
