package com.taobao.weex.bridge;

/* JADX INFO: loaded from: classes.dex */
public interface ModuleFactory<T extends com.taobao.weex.common.WXModule> extends com.taobao.weex.bridge.JavascriptInvokable {
    T buildInstance() throws java.lang.IllegalAccessException, java.lang.InstantiationException;
}
