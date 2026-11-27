package com.taobao.weex.ui.module;

/* JADX INFO: loaded from: classes.dex */
public class WXWebViewModule extends com.taobao.weex.common.WXModule {

    private enum Action {
        reload,
        goBack,
        goForward,
        postMessage
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void goBack(java.lang.String str) {
        action(com.taobao.weex.ui.module.WXWebViewModule.Action.goBack, str);
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void goForward(java.lang.String str) {
        action(com.taobao.weex.ui.module.WXWebViewModule.Action.goForward, str);
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void reload(java.lang.String str) {
        action(com.taobao.weex.ui.module.WXWebViewModule.Action.reload, str);
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void postMessage(java.lang.String str, java.lang.Object obj) {
        action(com.taobao.weex.ui.module.WXWebViewModule.Action.postMessage, str, obj);
    }

    private void action(com.taobao.weex.ui.module.WXWebViewModule.Action action, java.lang.String str, java.lang.Object obj) {
        com.taobao.weex.ui.component.WXComponent wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(this.mWXSDKInstance.getInstanceId(), str);
        if (wXComponent instanceof com.taobao.weex.ui.component.WXWeb) {
            ((com.taobao.weex.ui.component.WXWeb) wXComponent).setAction(action.name(), obj);
        }
    }

    private void action(com.taobao.weex.ui.module.WXWebViewModule.Action action, java.lang.String str) {
        action(action, str, null);
    }
}
