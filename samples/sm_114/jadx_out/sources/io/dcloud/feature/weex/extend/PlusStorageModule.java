package io.dcloud.feature.weex.extend;

/* JADX INFO: loaded from: classes2.dex */
public class PlusStorageModule extends com.taobao.weex.common.WXModule {
    java.util.HashMap<java.lang.String, android.content.SharedPreferences> mAllAppNStorages = new java.util.HashMap<>(1);

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void setItem(java.lang.String str, java.lang.String str2, com.taobao.weex.bridge.JSCallback jSCallback) {
        java.util.Map<java.lang.String, java.lang.Object> itemResult;
        if (android.text.TextUtils.isEmpty(str) || str2 == null) {
            com.taobao.weex.appfram.storage.StorageResultHandler.handleInvalidParam(jSCallback);
            return;
        }
        android.content.SharedPreferences appNStorage = getAppNStorage();
        if (appNStorage != null) {
            io.dcloud.common.adapter.util.PlatformUtil.setBundleData(appNStorage, str, str2);
            itemResult = com.taobao.weex.appfram.storage.StorageResultHandler.setItemResult(true);
        } else {
            itemResult = com.taobao.weex.appfram.storage.StorageResultHandler.setItemResult(false);
        }
        if (jSCallback != null) {
            jSCallback.invoke(itemResult);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void getItem(java.lang.String str, com.taobao.weex.bridge.JSCallback jSCallback) {
        java.util.Map<java.lang.String, java.lang.Object> itemResult;
        if (android.text.TextUtils.isEmpty(str)) {
            com.taobao.weex.appfram.storage.StorageResultHandler.handleInvalidParam(jSCallback);
            return;
        }
        android.content.SharedPreferences appNStorage = getAppNStorage();
        if (appNStorage != null) {
            itemResult = com.taobao.weex.appfram.storage.StorageResultHandler.getItemResult(appNStorage.getString(str, null));
        } else {
            itemResult = com.taobao.weex.appfram.storage.StorageResultHandler.getItemResult(null);
        }
        if (jSCallback != null) {
            jSCallback.invoke(itemResult);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void removeItem(java.lang.String str, com.taobao.weex.bridge.JSCallback jSCallback) {
        java.util.Map<java.lang.String, java.lang.Object> mapRemoveItemResult;
        if (android.text.TextUtils.isEmpty(str)) {
            com.taobao.weex.appfram.storage.StorageResultHandler.handleInvalidParam(jSCallback);
            return;
        }
        android.content.SharedPreferences appNStorage = getAppNStorage();
        if (appNStorage != null) {
            io.dcloud.common.adapter.util.PlatformUtil.removeBundleData(appNStorage, str);
            mapRemoveItemResult = com.taobao.weex.appfram.storage.StorageResultHandler.removeItemResult(true);
        } else {
            mapRemoveItemResult = com.taobao.weex.appfram.storage.StorageResultHandler.removeItemResult(false);
        }
        if (jSCallback != null) {
            jSCallback.invoke(mapRemoveItemResult);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void length(com.taobao.weex.bridge.JSCallback jSCallback) {
        android.content.SharedPreferences appNStorage = getAppNStorage();
        if (appNStorage != null) {
            java.util.Map<java.lang.String, java.lang.Object> lengthResult = com.taobao.weex.appfram.storage.StorageResultHandler.getLengthResult(getBundleDataSize(appNStorage));
            if (jSCallback != null) {
                jSCallback.invoke(lengthResult);
                return;
            }
            return;
        }
        com.taobao.weex.appfram.storage.StorageResultHandler.handleNoHandlerError(jSCallback);
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void getAllKeys(com.taobao.weex.bridge.JSCallback jSCallback) {
        android.content.SharedPreferences appNStorage = getAppNStorage();
        if (appNStorage != null) {
            java.util.Map<java.lang.String, java.lang.Object> allkeysResult = com.taobao.weex.appfram.storage.StorageResultHandler.getAllkeysResult(getBundleKeys(appNStorage));
            if (jSCallback != null) {
                jSCallback.invoke(allkeysResult);
                return;
            }
            return;
        }
        com.taobao.weex.appfram.storage.StorageResultHandler.handleNoHandlerError(jSCallback);
    }

    private int getBundleDataSize(android.content.SharedPreferences sharedPreferences) {
        try {
            return sharedPreferences.getAll().size();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private java.util.List<java.lang.String> getBundleKeys(android.content.SharedPreferences sharedPreferences) {
        java.util.Map<java.lang.String, ?> all = sharedPreferences.getAll();
        if (all.size() > 0) {
            return new java.util.ArrayList(all.keySet());
        }
        return null;
    }

    private android.content.SharedPreferences initAppNStorages(java.lang.String str) {
        return io.dcloud.common.adapter.util.PlatformUtil.getOrCreateBundle(str + "_storages");
    }

    private android.content.SharedPreferences getAppNStorage() {
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = io.dcloud.feature.weex.WeexInstanceMgr.self().findWebview(this.mWXSDKInstance);
        if (iWebviewFindWebview == null) {
            return null;
        }
        java.lang.String strObtainAppId = iWebviewFindWebview.obtainFrameView().obtainApp().obtainAppId();
        android.content.SharedPreferences sharedPreferences = this.mAllAppNStorages.get(strObtainAppId);
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        android.content.SharedPreferences sharedPreferencesInitAppNStorages = initAppNStorages(strObtainAppId);
        this.mAllAppNStorages.put(strObtainAppId, sharedPreferencesInitAppNStorages);
        return sharedPreferencesInitAppNStorages;
    }
}
