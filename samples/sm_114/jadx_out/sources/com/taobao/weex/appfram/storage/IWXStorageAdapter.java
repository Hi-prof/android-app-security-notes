package com.taobao.weex.appfram.storage;

/* JADX INFO: loaded from: classes.dex */
public interface IWXStorageAdapter {

    public interface OnResultReceivedListener {
        void onReceived(java.util.Map<java.lang.String, java.lang.Object> map);
    }

    void close();

    void getAllKeys(com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener);

    void getItem(java.lang.String str, com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener);

    void length(com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener);

    void removeItem(java.lang.String str, com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener);

    void setItem(java.lang.String str, java.lang.String str2, com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener);

    void setItemPersistent(java.lang.String str, java.lang.String str2, com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener);
}
