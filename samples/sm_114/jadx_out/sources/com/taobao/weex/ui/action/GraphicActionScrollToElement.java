package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class GraphicActionScrollToElement extends com.taobao.weex.ui.action.BasicGraphicAction {
    private final com.alibaba.fastjson.JSONObject mOptions;

    public GraphicActionScrollToElement(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject) {
        super(wXSDKInstance, str);
        this.mOptions = jSONObject;
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        com.taobao.weex.ui.component.Scrollable parentScroller;
        com.taobao.weex.ui.component.WXComponent wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), getRef());
        if (wXComponent == null || (parentScroller = wXComponent.getParentScroller()) == null) {
            return;
        }
        parentScroller.scrollTo(wXComponent, this.mOptions);
    }
}
