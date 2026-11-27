package com.taobao.weex.bridge;

/* JADX INFO: loaded from: classes.dex */
public class WXModuleManager {
    private static java.util.ArrayList<java.lang.String> mBlackModuleList;
    private static volatile java.util.concurrent.ConcurrentMap<java.lang.String, com.taobao.weex.bridge.ModuleFactoryImpl> sModuleFactoryMap = new java.util.concurrent.ConcurrentHashMap();
    private static java.util.Map<java.lang.String, com.taobao.weex.common.WXModule> sGlobalModuleMap = new java.util.HashMap();
    private static java.util.Map<java.lang.String, com.taobao.weex.ui.module.WXDomModule> sDomModuleMap = new java.util.HashMap();
    private static java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.taobao.weex.common.WXModule>> sInstanceModuleMap = new java.util.concurrent.ConcurrentHashMap();

    public static boolean registerModule(java.util.Map<java.lang.String, com.taobao.weex.utils.cache.RegisterCache.ModuleCache> map) {
        if (map.isEmpty()) {
            return true;
        }
        final java.util.Iterator<java.util.Map.Entry<java.lang.String, com.taobao.weex.utils.cache.RegisterCache.ModuleCache>> it = map.entrySet().iterator();
        com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXModuleManager.1
            @Override // java.lang.Runnable
            public void run() {
                java.util.HashMap map2 = new java.util.HashMap();
                while (it.hasNext()) {
                    com.taobao.weex.utils.cache.RegisterCache.ModuleCache moduleCache = (com.taobao.weex.utils.cache.RegisterCache.ModuleCache) ((java.util.Map.Entry) it.next()).getValue();
                    java.lang.String str = moduleCache.name;
                    if (!android.text.TextUtils.equals(str, com.taobao.weex.ui.module.WXDomModule.WXDOM)) {
                        if (com.taobao.weex.bridge.WXModuleManager.sModuleFactoryMap != null && com.taobao.weex.bridge.WXModuleManager.sModuleFactoryMap.containsKey(str)) {
                            com.taobao.weex.utils.WXLogUtils.w("WXComponentRegistry Duplicate the Module name: " + str);
                        }
                        com.taobao.weex.bridge.ModuleFactory moduleFactory = moduleCache.factory;
                        try {
                            com.taobao.weex.bridge.WXModuleManager.registerNativeModule(str, moduleFactory);
                        } catch (com.taobao.weex.common.WXException e) {
                            com.taobao.weex.utils.WXLogUtils.e("registerNativeModule" + e);
                        }
                        if (moduleCache.global) {
                            try {
                                com.taobao.weex.common.WXModule wXModuleBuildInstance = moduleFactory.buildInstance();
                                wXModuleBuildInstance.setModuleName(str);
                                com.taobao.weex.bridge.WXModuleManager.sGlobalModuleMap.put(str, wXModuleBuildInstance);
                            } catch (java.lang.Exception e2) {
                                com.taobao.weex.utils.WXLogUtils.e(str + " class must have a default constructor without params. ", e2);
                            }
                        }
                        try {
                            com.taobao.weex.bridge.WXModuleManager.sModuleFactoryMap.put(str, new com.taobao.weex.bridge.ModuleFactoryImpl(moduleFactory));
                        } catch (java.lang.Throwable unused) {
                        }
                        map2.put(str, moduleFactory.getMethods());
                    } else {
                        com.taobao.weex.utils.WXLogUtils.e("Cannot registered module with name 'dom'.");
                    }
                }
                com.taobao.weex.WXSDKManager.getInstance().registerModules(map2);
            }
        });
        return true;
    }

    public static boolean registerModule(final java.lang.String str, final com.taobao.weex.bridge.ModuleFactory moduleFactory, final boolean z) throws com.taobao.weex.common.WXException {
        if (str == null || moduleFactory == null) {
            return false;
        }
        if (android.text.TextUtils.equals(str, com.taobao.weex.ui.module.WXDomModule.WXDOM)) {
            com.taobao.weex.utils.WXLogUtils.e("Cannot registered module with name 'dom'.");
            return false;
        }
        if (com.taobao.weex.utils.cache.RegisterCache.getInstance().cacheModule(str, moduleFactory, z)) {
            return true;
        }
        com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXModuleManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (com.taobao.weex.bridge.WXModuleManager.sModuleFactoryMap != null && com.taobao.weex.bridge.WXModuleManager.sModuleFactoryMap.containsKey(str)) {
                    com.taobao.weex.utils.WXLogUtils.w("WXComponentRegistry Duplicate the Module name: " + str);
                }
                try {
                    com.taobao.weex.bridge.WXModuleManager.registerNativeModule(str, moduleFactory);
                } catch (com.taobao.weex.common.WXException e) {
                    com.taobao.weex.utils.WXLogUtils.e("registerNativeModule" + e);
                }
                if (z) {
                    try {
                        com.taobao.weex.common.WXModule wXModuleBuildInstance = moduleFactory.buildInstance();
                        wXModuleBuildInstance.setModuleName(str);
                        com.taobao.weex.bridge.WXModuleManager.sGlobalModuleMap.put(str, wXModuleBuildInstance);
                    } catch (java.lang.Exception e2) {
                        com.taobao.weex.utils.WXLogUtils.e(str + " class must have a default constructor without params. ", e2);
                    }
                }
                com.taobao.weex.bridge.WXModuleManager.registerJSModule(str, moduleFactory);
                try {
                    com.taobao.weex.bridge.WXModuleManager.sModuleFactoryMap.put(str, new com.taobao.weex.bridge.ModuleFactoryImpl(moduleFactory));
                } catch (java.lang.Throwable unused) {
                }
            }
        });
        return true;
    }

    static boolean registerNativeModule(java.lang.String str, com.taobao.weex.bridge.ModuleFactory moduleFactory) throws com.taobao.weex.common.WXException {
        if (moduleFactory == null) {
            return false;
        }
        try {
            if (sModuleFactoryMap.containsKey(str)) {
                return true;
            }
            sModuleFactoryMap.put(str, new com.taobao.weex.bridge.ModuleFactoryImpl(moduleFactory));
            return true;
        } catch (java.lang.ArrayStoreException e) {
            e.printStackTrace();
            com.taobao.weex.utils.WXLogUtils.e("[WXModuleManager] registerNativeModule Error moduleName:" + str + " Error:" + e.toString());
            return true;
        }
    }

    static boolean registerJSModule(java.lang.String str, com.taobao.weex.bridge.ModuleFactory moduleFactory) {
        java.util.HashMap map = new java.util.HashMap();
        map.put(str, moduleFactory.getMethods());
        com.taobao.weex.WXSDKManager.getInstance().registerModules(map);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00c1 A[DONT_GENERATE] */
    static java.lang.Object callModuleMethod(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.fastjson.JSONArray jSONArray) {
        com.taobao.weex.bridge.ModuleFactory moduleFactory = sModuleFactoryMap.get(str2).mFactory;
        if (moduleFactory == null) {
            com.taobao.weex.utils.WXLogUtils.e("[WXModuleManager] module factory not found.");
            return null;
        }
        com.taobao.weex.common.WXModule wXModuleFindModule = findModule(str, str2, moduleFactory);
        if (wXModuleFindModule == null) {
            return null;
        }
        com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
        wXModuleFindModule.mWXSDKInstance = sDKInstance;
        wXModuleFindModule.mUniSDKInstance = sDKInstance;
        com.taobao.weex.bridge.Invoker methodInvoker = moduleFactory.getMethodInvoker(str3);
        try {
            if (sDKInstance == null) {
                com.taobao.weex.utils.WXLogUtils.e("callModuleMethod >>> instance is null");
                if (!(wXModuleFindModule instanceof com.taobao.weex.ui.module.WXDomModule) && !(wXModuleFindModule instanceof com.taobao.weex.ui.module.WXTimerModule)) {
                    return null;
                }
                wXModuleFindModule.mWXSDKInstance = null;
                wXModuleFindModule.mUniSDKInstance = null;
                return null;
            }
            com.taobao.weex.adapter.IWXUserTrackAdapter iWXUserTrackAdapter = com.taobao.weex.WXSDKManager.getInstance().getIWXUserTrackAdapter();
            if (iWXUserTrackAdapter != null) {
                java.util.HashMap map = new java.util.HashMap();
                map.put(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_CODE, "101");
                map.put(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ARG, str2 + com.taobao.weex.el.parse.Operators.DOT_STR + str3);
                map.put(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_MSG, sDKInstance.getBundleUrl());
                iWXUserTrackAdapter.commit(sDKInstance.getContext(), null, com.taobao.weex.adapter.IWXUserTrackAdapter.INVOKE_MODULE, null, map);
            }
            java.lang.Object objDispatchCallModuleMethod = dispatchCallModuleMethod(sDKInstance, wXModuleFindModule, jSONArray, methodInvoker);
            if (!(wXModuleFindModule instanceof com.taobao.weex.ui.module.WXDomModule) && !(wXModuleFindModule instanceof com.taobao.weex.ui.module.WXTimerModule)) {
                return objDispatchCallModuleMethod;
            }
            wXModuleFindModule.mWXSDKInstance = null;
            wXModuleFindModule.mUniSDKInstance = null;
            return objDispatchCallModuleMethod;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("callModuleMethod >>> invoke module:" + str2 + ", method:" + str3 + " failed. ", e);
            return null;
        } finally {
            if ((wXModuleFindModule instanceof com.taobao.weex.ui.module.WXDomModule) || (wXModuleFindModule instanceof com.taobao.weex.ui.module.WXTimerModule)) {
                wXModuleFindModule.mWXSDKInstance = null;
                wXModuleFindModule.mUniSDKInstance = null;
            }
        }
    }

    private static java.lang.Object dispatchCallModuleMethod(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.common.WXModule wXModule, com.alibaba.fastjson.JSONArray jSONArray, com.taobao.weex.bridge.Invoker invoker) throws java.lang.Exception {
        if (!wXSDKInstance.isPreRenderMode()) {
            return wXSDKInstance.getNativeInvokeHelper().invoke(wXModule, invoker, jSONArray);
        }
        if (invoker.isRunOnUIThread()) {
            return null;
        }
        return wXSDKInstance.getNativeInvokeHelper().invoke(wXModule, invoker, jSONArray);
    }

    public static boolean hasModule(java.lang.String str) {
        return sGlobalModuleMap.containsKey(str) || sModuleFactoryMap.containsKey(str);
    }

    private static com.taobao.weex.common.WXModule findModule(java.lang.String str, java.lang.String str2, com.taobao.weex.bridge.ModuleFactory moduleFactory) {
        com.taobao.weex.common.WXModule wXModuleBuildInstance;
        com.taobao.weex.common.WXModule wXModule = sGlobalModuleMap.get(str2);
        if (wXModule != null) {
            return wXModule;
        }
        java.util.Map<java.lang.String, com.taobao.weex.common.WXModule> concurrentHashMap = sInstanceModuleMap.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<>();
            sInstanceModuleMap.put(str, concurrentHashMap);
        }
        com.taobao.weex.common.WXModule wXModule2 = concurrentHashMap.get(str2);
        if (wXModule2 != null) {
            return wXModule2;
        }
        try {
            if (moduleFactory instanceof com.taobao.weex.ui.config.ConfigModuleFactory) {
                wXModuleBuildInstance = ((com.taobao.weex.ui.config.ConfigModuleFactory) moduleFactory).buildInstance(com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str));
            } else {
                wXModuleBuildInstance = moduleFactory.buildInstance();
            }
            wXModuleBuildInstance.setModuleName(str2);
            concurrentHashMap.put(str2, wXModuleBuildInstance);
            return wXModuleBuildInstance;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e(str2 + " module build instace failed.", e);
            return null;
        }
    }

    public static void onActivityCreate(java.lang.String str) {
        java.util.Map<java.lang.String, com.taobao.weex.common.WXModule> map = sInstanceModuleMap.get(str);
        if (map != null) {
            for (java.lang.String str2 : map.keySet()) {
                com.taobao.weex.common.WXModule wXModule = map.get(str2);
                if (wXModule != null) {
                    wXModule.onActivityCreate();
                } else {
                    com.taobao.weex.utils.WXLogUtils.w("onActivityCreate can not find the " + str2 + " module");
                }
            }
        }
    }

    public static void onActivityStart(java.lang.String str) {
        java.util.Map<java.lang.String, com.taobao.weex.common.WXModule> map = sInstanceModuleMap.get(str);
        if (map != null) {
            for (java.lang.String str2 : map.keySet()) {
                com.taobao.weex.common.WXModule wXModule = map.get(str2);
                if (wXModule != null) {
                    wXModule.onActivityStart();
                } else {
                    com.taobao.weex.utils.WXLogUtils.w("onActivityStart can not find the " + str2 + " module");
                }
            }
        }
    }

    public static void onActivityPause(java.lang.String str) {
        java.util.Map<java.lang.String, com.taobao.weex.common.WXModule> map = sInstanceModuleMap.get(str);
        if (map != null) {
            for (java.lang.String str2 : map.keySet()) {
                com.taobao.weex.common.WXModule wXModule = map.get(str2);
                if (wXModule != null) {
                    wXModule.onActivityPause();
                } else {
                    com.taobao.weex.utils.WXLogUtils.w("onActivityPause can not find the " + str2 + " module");
                }
            }
        }
    }

    public static void onActivityResume(java.lang.String str) {
        java.util.Map<java.lang.String, com.taobao.weex.common.WXModule> map = sInstanceModuleMap.get(str);
        if (map != null) {
            for (java.lang.String str2 : map.keySet()) {
                com.taobao.weex.common.WXModule wXModule = map.get(str2);
                if (wXModule != null) {
                    wXModule.onActivityResume();
                } else {
                    com.taobao.weex.utils.WXLogUtils.w("onActivityResume can not find the " + str2 + " module");
                }
            }
        }
    }

    public static void onActivityStop(java.lang.String str) {
        java.util.Map<java.lang.String, com.taobao.weex.common.WXModule> map = sInstanceModuleMap.get(str);
        if (map != null) {
            for (java.lang.String str2 : map.keySet()) {
                com.taobao.weex.common.WXModule wXModule = map.get(str2);
                if (wXModule != null) {
                    wXModule.onActivityStop();
                } else {
                    com.taobao.weex.utils.WXLogUtils.w("onActivityStop can not find the " + str2 + " module");
                }
            }
        }
    }

    public static void onActivityDestroy(java.lang.String str) {
        java.util.Map<java.lang.String, com.taobao.weex.common.WXModule> map = sInstanceModuleMap.get(str);
        if (map != null) {
            for (java.lang.String str2 : map.keySet()) {
                com.taobao.weex.common.WXModule wXModule = map.get(str2);
                if (wXModule != null) {
                    wXModule.onActivityDestroy();
                } else {
                    com.taobao.weex.utils.WXLogUtils.w("onActivityDestroy can not find the " + str2 + " module");
                }
            }
        }
    }

    public static boolean onActivityBack(java.lang.String str) {
        java.util.Map<java.lang.String, com.taobao.weex.common.WXModule> map = sInstanceModuleMap.get(str);
        if (map == null) {
            return false;
        }
        for (java.lang.String str2 : map.keySet()) {
            com.taobao.weex.common.WXModule wXModule = map.get(str2);
            if (wXModule != null) {
                return wXModule.onActivityBack();
            }
            com.taobao.weex.utils.WXLogUtils.w("onActivityCreate can not find the " + str2 + " module");
        }
        return false;
    }

    public static void onActivityResult(java.lang.String str, int i, int i2, android.content.Intent intent) {
        java.util.Map<java.lang.String, com.taobao.weex.common.WXModule> map = sInstanceModuleMap.get(str);
        if (map != null) {
            for (java.lang.String str2 : map.keySet()) {
                com.taobao.weex.common.WXModule wXModule = map.get(str2);
                if (wXModule != null) {
                    wXModule.onActivityResult(i, i2, intent);
                } else {
                    com.taobao.weex.utils.WXLogUtils.w("onActivityResult can not find the " + str2 + " module");
                }
            }
        }
    }

    public static boolean onCreateOptionsMenu(java.lang.String str, android.view.Menu menu) {
        java.util.Map<java.lang.String, com.taobao.weex.common.WXModule> map = sInstanceModuleMap.get(str);
        if (map == null) {
            return false;
        }
        for (java.lang.String str2 : map.keySet()) {
            com.taobao.weex.common.WXModule wXModule = map.get(str2);
            if (wXModule != null) {
                wXModule.onCreateOptionsMenu(menu);
            } else {
                com.taobao.weex.utils.WXLogUtils.w("onActivityResult can not find the " + str2 + " module");
            }
        }
        return false;
    }

    public static void onRequestPermissionsResult(java.lang.String str, int i, java.lang.String[] strArr, int[] iArr) {
        java.util.Map<java.lang.String, com.taobao.weex.common.WXModule> map = sInstanceModuleMap.get(str);
        if (map != null) {
            for (java.lang.String str2 : map.keySet()) {
                com.taobao.weex.common.WXModule wXModule = map.get(str2);
                if (wXModule != null) {
                    wXModule.onRequestPermissionsResult(i, strArr, iArr);
                } else {
                    com.taobao.weex.utils.WXLogUtils.w("onActivityResult can not find the " + str2 + " module");
                }
            }
        }
    }

    public static void destroyInstanceModules(java.lang.String str) {
        sDomModuleMap.remove(str);
        java.util.Map<java.lang.String, com.taobao.weex.common.WXModule> mapRemove = sInstanceModuleMap.remove(str);
        if (mapRemove == null || mapRemove.size() < 1) {
            return;
        }
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.taobao.weex.common.WXModule>> it = mapRemove.entrySet().iterator();
        while (it.hasNext()) {
            com.taobao.weex.common.IWXObject iWXObject = (com.taobao.weex.common.WXModule) it.next().getValue();
            if (iWXObject instanceof com.taobao.weex.common.Destroyable) {
                ((com.taobao.weex.common.Destroyable) iWXObject).destroy();
            }
        }
    }

    public static void createDomModule(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        if (wXSDKInstance != null) {
            sDomModuleMap.put(wXSDKInstance.getInstanceId(), new com.taobao.weex.ui.module.WXDomModule(wXSDKInstance));
        }
    }

    public static void destoryDomModule(java.lang.String str) {
        sDomModuleMap.remove(str);
    }

    public static com.taobao.weex.ui.module.WXDomModule getDomModule(java.lang.String str) {
        return sDomModuleMap.get(str);
    }

    public static void reload() {
        if (sModuleFactoryMap == null || sModuleFactoryMap.size() <= 0) {
            return;
        }
        for (java.util.Map.Entry<java.lang.String, com.taobao.weex.bridge.ModuleFactoryImpl> entry : sModuleFactoryMap.entrySet()) {
            try {
                registerJSModule(entry.getKey(), entry.getValue().mFactory);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static void registerWhenCreateInstance() {
        if (sModuleFactoryMap == null || sModuleFactoryMap.size() <= 0) {
            return;
        }
        for (java.util.Map.Entry<java.lang.String, com.taobao.weex.bridge.ModuleFactoryImpl> entry : sModuleFactoryMap.entrySet()) {
            try {
                if (!entry.getValue().hasRigster) {
                    registerJSModule(entry.getKey(), entry.getValue().mFactory);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static void resetAllModuleState() {
        if (sModuleFactoryMap == null || sModuleFactoryMap.size() <= 0) {
            return;
        }
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.taobao.weex.bridge.ModuleFactoryImpl>> it = sModuleFactoryMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().hasRigster = false;
        }
    }

    public static void resetModuleState(java.lang.String str, boolean z) {
        if (sModuleFactoryMap == null || sModuleFactoryMap.size() <= 0) {
            return;
        }
        for (java.util.Map.Entry<java.lang.String, com.taobao.weex.bridge.ModuleFactoryImpl> entry : sModuleFactoryMap.entrySet()) {
            try {
                if (entry.getKey() != null && entry.getKey().equals(str)) {
                    entry.getValue().hasRigster = z;
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static com.alibaba.fastjson.JSONObject getRegisterJsModules() {
        if (sModuleFactoryMap == null || sModuleFactoryMap.size() <= 0) {
            return null;
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        for (java.util.Map.Entry<java.lang.String, com.taobao.weex.bridge.ModuleFactoryImpl> entry : sModuleFactoryMap.entrySet()) {
            try {
                if (!getBlackList().contains(entry.getKey()) && entry.getValue().mFactory != null) {
                    jSONObject.put(entry.getKey(), (java.lang.Object) modulesToJSONArray(entry.getValue().mFactory.getMethods(), entry.getValue().mFactory));
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return jSONObject;
    }

    private static java.util.ArrayList<java.lang.String> getBlackList() {
        if (mBlackModuleList == null) {
            java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
            mBlackModuleList = arrayList;
            arrayList.add("webview");
            mBlackModuleList.add("animation");
            mBlackModuleList.add("binding");
            mBlackModuleList.add("bindingx");
            mBlackModuleList.add("instanceWrap");
            mBlackModuleList.add("meta");
            mBlackModuleList.add("navigator");
            mBlackModuleList.add("expressionBinding");
        }
        return mBlackModuleList;
    }

    public static com.alibaba.fastjson.JSONArray modulesToJSONArray(java.lang.String[] strArr, com.taobao.weex.bridge.ModuleFactory moduleFactory) {
        com.alibaba.fastjson.JSONArray jSONArray = null;
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                if (jSONArray == null) {
                    jSONArray = new com.alibaba.fastjson.JSONArray();
                }
                if (!strArr[i].equals("addEventListener") && !strArr[i].equals("removeAllEventListeners")) {
                    boolean zIsRunOnUIThread = moduleFactory.getMethodInvoker(strArr[i]).isRunOnUIThread();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(strArr[i]);
                    sb.append(!zIsRunOnUIThread ? ":sync" : ":async");
                    jSONArray.add(sb.toString());
                }
            }
        }
        return jSONArray;
    }
}
