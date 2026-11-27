package com.taobao.weex;

/* JADX INFO: loaded from: classes.dex */
public interface IWXRenderListener {
    void onException(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.lang.String str2);

    void onRefreshSuccess(com.taobao.weex.WXSDKInstance wXSDKInstance, int i, int i2);

    void onRenderSuccess(com.taobao.weex.WXSDKInstance wXSDKInstance, int i, int i2);

    void onViewCreated(com.taobao.weex.WXSDKInstance wXSDKInstance, android.view.View view);
}
