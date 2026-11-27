package com.taobao.weex.bridge;

/* JADX INFO: loaded from: classes.dex */
public class WXServiceManager {
    private static volatile java.util.concurrent.ConcurrentHashMap<java.lang.String, com.taobao.weex.common.WXJSService> sInstanceJSServiceMap = new java.util.concurrent.ConcurrentHashMap<>();

    public static boolean registerService(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return false;
        }
        java.lang.String str3 = "serviceName: \"" + str + io.dcloud.common.util.JSUtil.QUOTE;
        for (java.lang.String str4 : map.keySet()) {
            java.lang.Object obj = map.get(str4);
            str3 = obj instanceof java.lang.String ? str3 + ", '" + str4 + "': '" + obj + "'" : str3 + ", '" + str4 + "': " + obj;
        }
        java.lang.String str5 = io.dcloud.common.util.StringUtil.format(";(function(service, options){ ;%s; })({ %s }, { %s });", str2, "register: global.registerService, unregister: global.unregisterService", str3);
        com.taobao.weex.common.WXJSService wXJSService = new com.taobao.weex.common.WXJSService();
        wXJSService.setName(str);
        wXJSService.setScript(str2);
        wXJSService.setOptions(map);
        sInstanceJSServiceMap.put(str, wXJSService);
        com.taobao.weex.bridge.WXBridgeManager.getInstance().execJSService(str5);
        return true;
    }

    public static boolean unRegisterService(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        sInstanceJSServiceMap.remove(str);
        com.taobao.weex.bridge.WXBridgeManager.getInstance().execJSService(io.dcloud.common.util.StringUtil.format("global.unregisterService( \"%s\" );", str));
        return true;
    }

    public static void execAllCacheJsService() {
        java.util.Iterator<java.lang.String> it = sInstanceJSServiceMap.keySet().iterator();
        while (it.hasNext()) {
            com.taobao.weex.common.WXJSService wXJSService = sInstanceJSServiceMap.get(it.next());
            registerService(wXJSService.getName(), wXJSService.getScript(), wXJSService.getOptions());
        }
    }

    public static com.taobao.weex.common.WXJSService getService(java.lang.String str) {
        if (sInstanceJSServiceMap != null) {
            return sInstanceJSServiceMap.get(str);
        }
        return null;
    }

    public static void reload() {
        if (sInstanceJSServiceMap == null || sInstanceJSServiceMap.size() <= 0) {
            return;
        }
        com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXServiceManager.1
            @Override // java.lang.Runnable
            public void run() {
                java.util.Iterator it = com.taobao.weex.bridge.WXServiceManager.sInstanceJSServiceMap.entrySet().iterator();
                while (it.hasNext()) {
                    com.taobao.weex.common.WXJSService wXJSService = (com.taobao.weex.common.WXJSService) ((java.util.Map.Entry) it.next()).getValue();
                    com.taobao.weex.bridge.WXServiceManager.registerService(wXJSService.getName(), wXJSService.getScript(), wXJSService.getOptions());
                }
            }
        });
    }
}
