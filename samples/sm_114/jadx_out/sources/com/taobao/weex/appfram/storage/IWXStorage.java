package com.taobao.weex.appfram.storage;

/* JADX INFO: loaded from: classes.dex */
interface IWXStorage {
    void getAllKeys(com.taobao.weex.bridge.JSCallback jSCallback);

    void getItem(java.lang.String str, com.taobao.weex.bridge.JSCallback jSCallback);

    void length(com.taobao.weex.bridge.JSCallback jSCallback);

    void removeItem(java.lang.String str, com.taobao.weex.bridge.JSCallback jSCallback);

    void setItem(java.lang.String str, java.lang.String str2, com.taobao.weex.bridge.JSCallback jSCallback);

    void setItemPersistent(java.lang.String str, java.lang.String str2, com.taobao.weex.bridge.JSCallback jSCallback);
}
