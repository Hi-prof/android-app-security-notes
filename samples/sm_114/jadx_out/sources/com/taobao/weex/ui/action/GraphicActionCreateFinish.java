package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class GraphicActionCreateFinish extends com.taobao.weex.ui.action.BasicGraphicAction {
    private int mLayoutHeight;
    private int mLayoutWidth;

    public GraphicActionCreateFinish(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        super(wXSDKInstance, "");
        com.taobao.weex.ui.component.WXComponent rootComponent = wXSDKInstance.getRootComponent();
        if (rootComponent != null) {
            this.mLayoutWidth = (int) rootComponent.getLayoutWidth();
            this.mLayoutHeight = (int) rootComponent.getLayoutHeight();
        }
        wXSDKInstance.getApmForInstance().onStage(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_CREATE_FINISH);
        wXSDKInstance.getApmForInstance().extInfo.put(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_CREATE_FINISH, true);
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        com.taobao.weex.WXSDKInstance wXSDKIntance = getWXSDKIntance();
        if (wXSDKIntance == null || wXSDKIntance.getContext() == null || wXSDKIntance.mHasCreateFinish) {
            return;
        }
        wXSDKIntance.mHasCreateFinish = true;
        if (wXSDKIntance.getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.APPEND_ONCE || !com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE.equals(wXSDKIntance.getRenderType())) {
            wXSDKIntance.onCreateFinish();
        }
        if (wXSDKIntance.getWXPerformance() != null) {
            wXSDKIntance.getWXPerformance().callCreateFinishTime = java.lang.System.currentTimeMillis() - wXSDKIntance.getWXPerformance().renderTimeOrigin;
        }
        wXSDKIntance.onOldFsRenderTimeLogic();
    }
}
