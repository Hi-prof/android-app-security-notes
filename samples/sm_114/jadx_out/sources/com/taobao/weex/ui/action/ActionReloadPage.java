package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public class ActionReloadPage implements com.taobao.weex.ui.action.IExecutable {
    private final java.lang.String TAG = "ReloadPageAction";
    private java.lang.String mPageId;
    private boolean mReloadThis;

    public ActionReloadPage(java.lang.String str, boolean z) {
        this.mPageId = str;
        this.mReloadThis = z;
    }

    @Override // com.taobao.weex.ui.action.IExecutable
    public void executeAction() {
        com.taobao.weex.WXSDKInstance wXSDKInstance = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXSDKInstance(this.mPageId);
        if (wXSDKInstance != null) {
            wXSDKInstance.reloadPage(this.mReloadThis);
        } else {
            android.util.Log.e("ReloadPageAction", "ReloadPageAction executeDom reloadPage instance is null");
        }
    }
}
