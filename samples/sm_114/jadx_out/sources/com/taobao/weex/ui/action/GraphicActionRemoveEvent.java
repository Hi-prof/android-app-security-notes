package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class GraphicActionRemoveEvent extends com.taobao.weex.ui.action.BasicGraphicAction {
    private final java.lang.String mEvent;

    public GraphicActionRemoveEvent(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.lang.Object obj) {
        super(wXSDKInstance, str);
        this.mEvent = com.taobao.weex.dom.WXEvent.getEventName(obj);
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        com.taobao.weex.ui.component.WXComponent wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), getRef());
        if (wXComponent == null) {
            return;
        }
        com.taobao.weex.tracing.Stopwatch.tick();
        wXComponent.removeEvent(this.mEvent);
        com.taobao.weex.tracing.Stopwatch.split("removeEventFromComponent");
    }
}
