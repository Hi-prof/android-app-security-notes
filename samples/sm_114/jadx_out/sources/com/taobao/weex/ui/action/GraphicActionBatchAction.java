package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class GraphicActionBatchAction extends com.taobao.weex.ui.action.BasicGraphicAction {
    private java.util.List<com.taobao.weex.ui.action.BasicGraphicAction> mActions;

    public GraphicActionBatchAction(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.util.List<com.taobao.weex.ui.action.BasicGraphicAction> list) {
        super(wXSDKInstance, str);
        this.mActions = new java.util.ArrayList(list);
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        for (int i = 0; i < this.mActions.size(); i++) {
            this.mActions.get(i).executeAction();
        }
    }
}
