package com.taobao.weex.appfram.storage;

/* JADX INFO: loaded from: classes.dex */
public class WXStorageModule extends com.taobao.weex.WXSDKEngine.DestroyableModule implements com.taobao.weex.appfram.storage.IWXStorage {
    com.taobao.weex.appfram.storage.IWXStorageAdapter mStorageAdapter;

    private com.taobao.weex.appfram.storage.IWXStorageAdapter ability() {
        com.taobao.weex.appfram.storage.IWXStorageAdapter iWXStorageAdapter = this.mStorageAdapter;
        if (iWXStorageAdapter != null) {
            return iWXStorageAdapter;
        }
        com.taobao.weex.appfram.storage.IWXStorageAdapter iWXStorageAdapter2 = com.taobao.weex.WXSDKEngine.getIWXStorageAdapter();
        this.mStorageAdapter = iWXStorageAdapter2;
        return iWXStorageAdapter2;
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorage
    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void setItem(java.lang.String str, java.lang.String str2, final com.taobao.weex.bridge.JSCallback jSCallback) {
        if (android.text.TextUtils.isEmpty(str) || str2 == null) {
            com.taobao.weex.appfram.storage.StorageResultHandler.handleInvalidParam(jSCallback);
            return;
        }
        com.taobao.weex.appfram.storage.IWXStorageAdapter iWXStorageAdapterAbility = ability();
        if (iWXStorageAdapterAbility == null) {
            com.taobao.weex.appfram.storage.StorageResultHandler.handleNoHandlerError(jSCallback);
        } else {
            iWXStorageAdapterAbility.setItem(str, str2, new com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener() { // from class: com.taobao.weex.appfram.storage.WXStorageModule.1
                @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener
                public void onReceived(java.util.Map<java.lang.String, java.lang.Object> map) {
                    com.taobao.weex.bridge.JSCallback jSCallback2 = jSCallback;
                    if (jSCallback2 != null) {
                        jSCallback2.invoke(map);
                    }
                }
            });
        }
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorage
    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void getItem(java.lang.String str, final com.taobao.weex.bridge.JSCallback jSCallback) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.taobao.weex.appfram.storage.StorageResultHandler.handleInvalidParam(jSCallback);
            return;
        }
        com.taobao.weex.appfram.storage.IWXStorageAdapter iWXStorageAdapterAbility = ability();
        if (iWXStorageAdapterAbility == null) {
            com.taobao.weex.appfram.storage.StorageResultHandler.handleNoHandlerError(jSCallback);
        } else {
            iWXStorageAdapterAbility.getItem(str, new com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener() { // from class: com.taobao.weex.appfram.storage.WXStorageModule.2
                @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener
                public void onReceived(java.util.Map<java.lang.String, java.lang.Object> map) {
                    com.taobao.weex.bridge.JSCallback jSCallback2 = jSCallback;
                    if (jSCallback2 != null) {
                        jSCallback2.invoke(map);
                    }
                }
            });
        }
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorage
    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void removeItem(java.lang.String str, final com.taobao.weex.bridge.JSCallback jSCallback) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.taobao.weex.appfram.storage.StorageResultHandler.handleInvalidParam(jSCallback);
            return;
        }
        com.taobao.weex.appfram.storage.IWXStorageAdapter iWXStorageAdapterAbility = ability();
        if (iWXStorageAdapterAbility == null) {
            com.taobao.weex.appfram.storage.StorageResultHandler.handleNoHandlerError(jSCallback);
        } else {
            iWXStorageAdapterAbility.removeItem(str, new com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener() { // from class: com.taobao.weex.appfram.storage.WXStorageModule.3
                @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener
                public void onReceived(java.util.Map<java.lang.String, java.lang.Object> map) {
                    com.taobao.weex.bridge.JSCallback jSCallback2 = jSCallback;
                    if (jSCallback2 != null) {
                        jSCallback2.invoke(map);
                    }
                }
            });
        }
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorage
    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void length(final com.taobao.weex.bridge.JSCallback jSCallback) {
        com.taobao.weex.appfram.storage.IWXStorageAdapter iWXStorageAdapterAbility = ability();
        if (iWXStorageAdapterAbility == null) {
            com.taobao.weex.appfram.storage.StorageResultHandler.handleNoHandlerError(jSCallback);
        } else {
            iWXStorageAdapterAbility.length(new com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener() { // from class: com.taobao.weex.appfram.storage.WXStorageModule.4
                @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener
                public void onReceived(java.util.Map<java.lang.String, java.lang.Object> map) {
                    com.taobao.weex.bridge.JSCallback jSCallback2 = jSCallback;
                    if (jSCallback2 != null) {
                        jSCallback2.invoke(map);
                    }
                }
            });
        }
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorage
    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void getAllKeys(final com.taobao.weex.bridge.JSCallback jSCallback) {
        com.taobao.weex.appfram.storage.IWXStorageAdapter iWXStorageAdapterAbility = ability();
        if (iWXStorageAdapterAbility == null) {
            com.taobao.weex.appfram.storage.StorageResultHandler.handleNoHandlerError(jSCallback);
        } else {
            iWXStorageAdapterAbility.getAllKeys(new com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener() { // from class: com.taobao.weex.appfram.storage.WXStorageModule.5
                @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener
                public void onReceived(java.util.Map<java.lang.String, java.lang.Object> map) {
                    com.taobao.weex.bridge.JSCallback jSCallback2 = jSCallback;
                    if (jSCallback2 != null) {
                        jSCallback2.invoke(map);
                    }
                }
            });
        }
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorage
    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void setItemPersistent(java.lang.String str, java.lang.String str2, final com.taobao.weex.bridge.JSCallback jSCallback) {
        if (android.text.TextUtils.isEmpty(str) || str2 == null) {
            com.taobao.weex.appfram.storage.StorageResultHandler.handleInvalidParam(jSCallback);
            return;
        }
        com.taobao.weex.appfram.storage.IWXStorageAdapter iWXStorageAdapterAbility = ability();
        if (iWXStorageAdapterAbility == null) {
            com.taobao.weex.appfram.storage.StorageResultHandler.handleNoHandlerError(jSCallback);
        } else {
            iWXStorageAdapterAbility.setItemPersistent(str, str2, new com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener() { // from class: com.taobao.weex.appfram.storage.WXStorageModule.6
                @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener
                public void onReceived(java.util.Map<java.lang.String, java.lang.Object> map) {
                    com.taobao.weex.bridge.JSCallback jSCallback2 = jSCallback;
                    if (jSCallback2 != null) {
                        jSCallback2.invoke(map);
                    }
                }
            });
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        com.taobao.weex.appfram.storage.IWXStorageAdapter iWXStorageAdapterAbility = ability();
        if (iWXStorageAdapterAbility != null) {
            iWXStorageAdapterAbility.close();
        }
    }
}
