package com.taobao.weex.bridge;

/* JADX INFO: loaded from: classes.dex */
public class SimpleJSCallback implements io.dcloud.feature.uniapp.bridge.UniJSCallback {
    java.lang.String mCallbackId;
    java.lang.String mInstanceId;
    private com.taobao.weex.bridge.SimpleJSCallback.InvokerCallback mInvokerCallback;

    interface InvokerCallback {
        void onInvokeSuccess();
    }

    public void setInvokerCallback(com.taobao.weex.bridge.SimpleJSCallback.InvokerCallback invokerCallback) {
        this.mInvokerCallback = invokerCallback;
    }

    public java.lang.String getCallbackId() {
        return this.mCallbackId;
    }

    public SimpleJSCallback(java.lang.String str, java.lang.String str2) {
        this.mCallbackId = str2;
        this.mInstanceId = str;
    }

    @Override // com.taobao.weex.bridge.JSCallback
    public void invoke(java.lang.Object obj) {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().callbackJavascript(this.mInstanceId, this.mCallbackId, obj, false);
        com.taobao.weex.bridge.SimpleJSCallback.InvokerCallback invokerCallback = this.mInvokerCallback;
        if (invokerCallback != null) {
            invokerCallback.onInvokeSuccess();
        }
    }

    @Override // com.taobao.weex.bridge.JSCallback
    public void invokeAndKeepAlive(java.lang.Object obj) {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().callbackJavascript(this.mInstanceId, this.mCallbackId, obj, true);
    }
}
