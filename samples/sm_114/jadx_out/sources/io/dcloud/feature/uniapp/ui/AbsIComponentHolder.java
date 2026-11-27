package io.dcloud.feature.uniapp.ui;

/* JADX INFO: loaded from: classes2.dex */
public interface AbsIComponentHolder extends com.taobao.weex.ui.ComponentCreator, com.taobao.weex.bridge.JavascriptInvokable {
    com.taobao.weex.bridge.Invoker getPropertyInvoker(java.lang.String str);

    void loadIfNonLazy();
}
