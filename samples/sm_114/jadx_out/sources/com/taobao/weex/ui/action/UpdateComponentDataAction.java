package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class UpdateComponentDataAction extends com.taobao.weex.ui.action.BasicGraphicAction {
    private java.lang.String callback;
    private com.alibaba.fastjson.JSONObject data;
    private java.lang.String virtualComponentId;

    public UpdateComponentDataAction(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject, java.lang.String str2) {
        super(wXSDKInstance, com.taobao.weex.ui.component.list.template.CellDataManager.getListRef(str));
        this.virtualComponentId = str;
        this.data = jSONObject;
        this.callback = str2;
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        if (android.text.TextUtils.isEmpty(getRef())) {
            com.taobao.weex.utils.WXLogUtils.e("wrong virtualComponentId split error " + this.virtualComponentId);
            return;
        }
        com.taobao.weex.ui.component.WXComponent wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(getPageId(), getRef());
        if (wXComponent instanceof com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList) {
            com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList wXRecyclerTemplateList = (com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList) wXComponent;
            wXRecyclerTemplateList.getCellDataManager().updateVirtualComponentData(this.virtualComponentId, this.data);
            wXRecyclerTemplateList.notifyUpdateList();
            new com.taobao.weex.bridge.SimpleJSCallback(wXComponent.getInstanceId(), this.callback).invoke(true);
            return;
        }
        com.taobao.weex.utils.WXLogUtils.e("recycler-list wrong virtualComponentId " + this.virtualComponentId);
    }
}
