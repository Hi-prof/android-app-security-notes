package com.taobao.weex.ui.config;

/* JADX INFO: loaded from: classes.dex */
public class AutoScanConfigRegister {
    public static final java.lang.String TAG = "WeexScanConfigRegister";
    private static long scanDelay;

    public static void doScanConfig() {
        if (scanDelay > 0) {
            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postOnUiThread(new java.lang.Runnable() { // from class: com.taobao.weex.ui.config.AutoScanConfigRegister.1
                @Override // java.lang.Runnable
                public void run() {
                    com.taobao.weex.ui.config.AutoScanConfigRegister.doScanConfigAsync();
                }
            }, scanDelay);
        } else {
            doScanConfigAsync();
        }
    }

    public static void doScanConfigAsync() {
        java.lang.Thread thread = new java.lang.Thread(new java.lang.Runnable() { // from class: com.taobao.weex.ui.config.AutoScanConfigRegister.2
            @Override // java.lang.Runnable
            public void run() {
                com.taobao.weex.ui.config.AutoScanConfigRegister.doScanConfigSync();
            }
        });
        thread.setName("AutoScanConfigRegister");
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doScanConfigSync() {
        if (com.taobao.weex.WXEnvironment.sApplication == null) {
            return;
        }
        try {
            java.lang.String[] list = new java.lang.String[0];
            try {
                list = com.taobao.weex.WXEnvironment.sApplication.getApplicationContext().getAssets().list("");
            } catch (java.io.IOException e) {
                com.taobao.weex.utils.WXLogUtils.e("WeexScanConfigRegister", e);
            }
            if (list != null && list.length != 0) {
                for (java.lang.String str : list) {
                    if (!android.text.TextUtils.isEmpty(str) && str.startsWith("weex_config_") && str.endsWith(".json")) {
                        if (android.text.TextUtils.isEmpty(str)) {
                            return;
                        }
                        try {
                            java.lang.String strLoadAsset = com.taobao.weex.utils.WXFileUtils.loadAsset(str, com.taobao.weex.WXEnvironment.getApplication());
                            if (!android.text.TextUtils.isEmpty(strLoadAsset)) {
                                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                                    com.taobao.weex.utils.WXLogUtils.d("WeexScanConfigRegister", str + " find config " + strLoadAsset);
                                }
                                com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(strLoadAsset);
                                if (object.containsKey("modules")) {
                                    com.alibaba.fastjson.JSONArray jSONArray = object.getJSONArray("modules");
                                    for (int i = 0; i < jSONArray.size(); i++) {
                                        com.taobao.weex.ui.config.ConfigModuleFactory configModuleFactoryFromConfig = com.taobao.weex.ui.config.ConfigModuleFactory.fromConfig(jSONArray.getJSONObject(i));
                                        if (configModuleFactoryFromConfig != null) {
                                            com.taobao.weex.WXSDKEngine.registerModule(configModuleFactoryFromConfig.getName(), (com.taobao.weex.bridge.ModuleFactory) configModuleFactoryFromConfig, false);
                                        }
                                    }
                                }
                                if (object.containsKey("components")) {
                                    com.alibaba.fastjson.JSONArray jSONArray2 = object.getJSONArray("components");
                                    for (int i2 = 0; i2 < jSONArray2.size(); i2++) {
                                        com.taobao.weex.ui.config.ConfigComponentHolder configComponentHolderFromConfig = com.taobao.weex.ui.config.ConfigComponentHolder.fromConfig(jSONArray2.getJSONObject(i2));
                                        if (configComponentHolderFromConfig == null) {
                                            return;
                                        }
                                        com.taobao.weex.WXSDKEngine.registerComponent(configComponentHolderFromConfig, configComponentHolderFromConfig.isAppendTree(), configComponentHolderFromConfig.getType());
                                    }
                                } else {
                                    continue;
                                }
                            }
                        } catch (java.lang.Throwable th) {
                            com.taobao.weex.utils.WXLogUtils.e("WeexScanConfigRegister", th);
                        }
                    }
                }
            }
        } catch (java.lang.Exception e2) {
            com.taobao.weex.utils.WXLogUtils.e("WeexScanConfigRegister", e2);
        }
    }

    public static void setScanDelay(long j) {
        scanDelay = j;
    }
}
