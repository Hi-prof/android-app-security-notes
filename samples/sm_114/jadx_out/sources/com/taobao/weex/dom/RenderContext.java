package com.taobao.weex.dom;

/* JADX INFO: loaded from: classes.dex */
public interface RenderContext {
    com.taobao.weex.ui.component.WXComponent getComponent(java.lang.String str);

    com.taobao.weex.WXSDKInstance getInstance();

    com.taobao.weex.ui.component.WXComponent unregisterComponent(java.lang.String str);
}
