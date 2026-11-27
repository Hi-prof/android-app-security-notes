package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class GraphicActionLayout extends com.taobao.weex.ui.action.BasicGraphicAction {
    private final boolean mIsLayoutRTL;
    private final com.taobao.weex.ui.action.GraphicPosition mLayoutPosition;
    private final com.taobao.weex.ui.action.GraphicSize mLayoutSize;

    public GraphicActionLayout(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, com.taobao.weex.ui.action.GraphicPosition graphicPosition, com.taobao.weex.ui.action.GraphicSize graphicSize, boolean z) {
        super(wXSDKInstance, str);
        this.mLayoutPosition = graphicPosition;
        this.mLayoutSize = graphicSize;
        this.mIsLayoutRTL = z;
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        com.taobao.weex.ui.component.WXComponent wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), getRef());
        if (wXComponent == null) {
            return;
        }
        wXComponent.setIsLayoutRTL(this.mIsLayoutRTL);
        wXComponent.setDemission(this.mLayoutSize, this.mLayoutPosition);
        wXComponent.setSafeLayout(wXComponent);
        wXComponent.setPadding(wXComponent.getPadding(), wXComponent.getBorder());
    }
}
