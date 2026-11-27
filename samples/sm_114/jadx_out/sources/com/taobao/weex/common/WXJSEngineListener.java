package com.taobao.weex.common;

/* JADX INFO: loaded from: classes.dex */
public interface WXJSEngineListener {
    void callback(boolean z, java.lang.String str, java.lang.String str2, java.lang.String str3);

    void createInstanceFailed(java.lang.String str);

    void createInstanceSuccess(java.lang.String str);

    void destroyInstanceFailed(java.lang.String str);

    void destroyInstanceSuccess(java.lang.String str);

    void fireEvent(boolean z, java.lang.String str, java.lang.String str2, java.lang.String str3);

    void initFramework(boolean z, java.lang.String str, double d);
}
