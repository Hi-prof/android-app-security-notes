package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class GraphicActionUpdateAttr extends com.taobao.weex.ui.action.BasicGraphicAction {
    private com.taobao.weex.ui.component.WXComponent component;
    private java.util.Map<java.lang.String, java.lang.String> mAttrs;

    public GraphicActionUpdateAttr(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        java.util.Map<java.lang.String, java.lang.String> map2;
        super(wXSDKInstance, str);
        this.mAttrs = map;
        com.taobao.weex.ui.component.WXComponent wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), getRef());
        this.component = wXComponent;
        if (wXComponent == null || (map2 = this.mAttrs) == null) {
            return;
        }
        wXComponent.addAttr(map2);
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        com.taobao.weex.ui.component.WXComponent wXComponent = this.component;
        if (wXComponent != null) {
            wXComponent.getAttrs().mergeAttr();
            if (this.component.getHostView() != null) {
                this.component.updateAttrs(this.mAttrs);
            }
        }
    }
}
