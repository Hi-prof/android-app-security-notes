package com.taobao.weex.common;

/* JADX INFO: loaded from: classes.dex */
public class WXInstanceWrap extends com.taobao.weex.common.WXModule {
    @com.taobao.weex.annotation.JSMethod
    public void error(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (this.mWXSDKInstance != null) {
            com.taobao.weex.WXSDKInstance parentInstance = this.mWXSDKInstance;
            if (str3 != null && str3.contains("downgrade_to_root")) {
                while (parentInstance.getParentInstance() != null) {
                    parentInstance = parentInstance.getParentInstance();
                }
            }
            parentInstance.onRenderError(str + "|" + str2, str3);
        }
    }
}
