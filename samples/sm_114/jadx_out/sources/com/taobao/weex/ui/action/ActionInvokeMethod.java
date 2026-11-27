package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class ActionInvokeMethod implements com.taobao.weex.ui.action.IExecutable {
    private static final java.lang.String TAG = "ActionInvokeMethod";
    private final com.alibaba.fastjson.JSONArray mArgs;
    private final java.lang.String mMethod;
    private java.lang.String mPageId;
    private java.lang.String mRef;

    public ActionInvokeMethod(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.fastjson.JSONArray jSONArray) {
        this.mPageId = str;
        this.mRef = str2;
        this.mMethod = str3;
        this.mArgs = jSONArray;
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        com.taobao.weex.ui.component.WXComponent wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(this.mPageId, this.mRef);
        if (wXComponent == null) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, "target component not found.");
        } else {
            wXComponent.invoke(this.mMethod, this.mArgs);
        }
    }
}
