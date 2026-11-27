package com.taobao.weex;

/* JADX INFO: loaded from: classes.dex */
public class WXGlobalEventModule extends com.taobao.weex.common.WXModule {
    @com.taobao.weex.annotation.JSMethod
    public void addEventListener(java.lang.String str, java.lang.String str2) {
        this.mWXSDKInstance.addEventListener(str, str2);
    }

    public void removeEventListener(java.lang.String str, java.lang.String str2) {
        this.mWXSDKInstance.removeEventListener(str, str2);
    }

    @com.taobao.weex.annotation.JSMethod
    public void removeEventListener(java.lang.String str) {
        this.mWXSDKInstance.removeEventListener(str);
    }

    @Override // com.taobao.weex.common.WXModule
    public void addEventListener(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map) {
        super.addEventListener(str, str2, map);
        addEventListener(str, str2);
    }
}
