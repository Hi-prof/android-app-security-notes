package com.taobao.weex.ui;

/* JADX INFO: loaded from: classes.dex */
public class WXComponentRegistry {
    private static java.util.Map<java.lang.String, com.taobao.weex.ui.IFComponentHolder> sTypeComponentMap = new java.util.concurrent.ConcurrentHashMap();
    private static java.util.ArrayList<java.util.Map<java.lang.String, java.lang.Object>> sComponentInfos = new java.util.ArrayList<>();

    public static synchronized boolean registerComponent(java.util.Map<java.lang.String, com.taobao.weex.utils.cache.RegisterCache.ComponentCache> map) {
        if (map.isEmpty()) {
            return true;
        }
        final java.util.Iterator<java.util.Map.Entry<java.lang.String, com.taobao.weex.utils.cache.RegisterCache.ComponentCache>> it = map.entrySet().iterator();
        com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.taobao.weex.ui.WXComponentRegistry.1
            @Override // java.lang.Runnable
            public void run() {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                while (it.hasNext()) {
                    try {
                        com.taobao.weex.utils.cache.RegisterCache.ComponentCache componentCache = (com.taobao.weex.utils.cache.RegisterCache.ComponentCache) ((java.util.Map.Entry) it.next()).getValue();
                        java.util.Map map2 = componentCache.componentInfo;
                        if (map2 == null) {
                            map2 = new java.util.HashMap();
                        }
                        map2.put("type", componentCache.type);
                        map2.put("methods", componentCache.holder.getMethods());
                        com.taobao.weex.ui.WXComponentRegistry.registerNativeComponent(componentCache.type, componentCache.holder);
                        com.taobao.weex.ui.WXComponentRegistry.sComponentInfos.add(map2);
                        arrayList.add(map2);
                    } catch (com.taobao.weex.common.WXException e) {
                        e.printStackTrace();
                    }
                }
                com.taobao.weex.WXSDKManager.getInstance().registerComponents(arrayList);
            }
        });
        return true;
    }

    public static synchronized boolean registerComponent(final java.lang.String str, final com.taobao.weex.ui.IFComponentHolder iFComponentHolder, final java.util.Map<java.lang.String, java.lang.Object> map) throws com.taobao.weex.common.WXException {
        if (iFComponentHolder != null) {
            if (!android.text.TextUtils.isEmpty(str)) {
                if (com.taobao.weex.utils.cache.RegisterCache.getInstance().cacheComponent(str, iFComponentHolder, map)) {
                    return true;
                }
                com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.taobao.weex.ui.WXComponentRegistry.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            java.util.Map map2 = map;
                            if (map2 == null) {
                                map2 = new java.util.HashMap();
                            }
                            map2.put("type", str);
                            map2.put("methods", iFComponentHolder.getMethods());
                            com.taobao.weex.ui.WXComponentRegistry.registerNativeComponent(str, iFComponentHolder);
                            com.taobao.weex.ui.WXComponentRegistry.registerJSComponent(map2);
                            com.taobao.weex.ui.WXComponentRegistry.sComponentInfos.add(map2);
                        } catch (com.taobao.weex.common.WXException e) {
                            com.taobao.weex.utils.WXLogUtils.e("register component error:", e);
                        }
                    }
                });
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean registerNativeComponent(java.lang.String str, com.taobao.weex.ui.IFComponentHolder iFComponentHolder) throws com.taobao.weex.common.WXException {
        try {
            iFComponentHolder.loadIfNonLazy();
            sTypeComponentMap.put(str, iFComponentHolder);
            return true;
        } catch (java.lang.ArrayStoreException e) {
            e.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean registerJSComponent(java.util.Map<java.lang.String, java.lang.Object> map) throws com.taobao.weex.common.WXException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(map);
        com.taobao.weex.WXSDKManager.getInstance().registerComponents(arrayList);
        return true;
    }

    public static com.taobao.weex.ui.IFComponentHolder getComponent(java.lang.String str) {
        return sTypeComponentMap.get(str);
    }

    public static void reload() {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.taobao.weex.ui.WXComponentRegistry.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    java.util.Iterator it = com.taobao.weex.ui.WXComponentRegistry.sComponentInfos.iterator();
                    while (it.hasNext()) {
                        com.taobao.weex.ui.WXComponentRegistry.registerJSComponent((java.util.Map) it.next());
                    }
                } catch (com.taobao.weex.common.WXException e) {
                    com.taobao.weex.utils.WXLogUtils.e("", e);
                }
            }
        });
    }
}
