package com.taobao.weex.utils.cache;

/* JADX INFO: loaded from: classes.dex */
public class RegisterCache {
    private static com.taobao.weex.utils.cache.RegisterCache registerCache;
    private static java.util.Map<java.lang.String, com.taobao.weex.utils.cache.RegisterCache.ModuleCache> moduleCacheMap = new java.util.concurrent.ConcurrentHashMap();
    private static java.util.Map<java.lang.String, com.taobao.weex.utils.cache.RegisterCache.ComponentCache> componentCacheMap = new java.util.concurrent.ConcurrentHashMap();
    private boolean enable = false;
    private boolean enableAutoScan = true;
    private volatile boolean finished = false;
    private volatile int doNotCacheSize = Integer.MAX_VALUE;

    public static com.taobao.weex.utils.cache.RegisterCache getInstance() {
        if (registerCache == null) {
            synchronized (com.taobao.weex.utils.cache.RegisterCache.class) {
                if (registerCache == null) {
                    registerCache = new com.taobao.weex.utils.cache.RegisterCache();
                }
            }
        }
        return registerCache;
    }

    private RegisterCache() {
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    private boolean enableCache() {
        return this.enable;
    }

    private boolean canCache() {
        return enableCache() && !this.finished && getDoNotCacheSize() < 1;
    }

    public boolean enableAutoScan() {
        return this.enableAutoScan;
    }

    public void setEnableAutoScan(boolean z) {
        if (this.enableAutoScan != z) {
            if (z) {
                com.taobao.weex.ui.config.AutoScanConfigRegister.doScanConfig();
            }
            this.enableAutoScan = z;
        }
    }

    private int getDoNotCacheSize() {
        int i = this.doNotCacheSize;
        this.doNotCacheSize = i - 1;
        return i;
    }

    public void setDoNotCacheSize(int i) {
        this.doNotCacheSize = i;
    }

    public boolean idle(boolean z) {
        java.lang.String str;
        if (this.finished) {
            return true;
        }
        if (z) {
            str = "idle from create instance";
        } else {
            str = "idle from external";
        }
        com.taobao.weex.utils.WXLogUtils.e(str + " cache size is " + (moduleCacheMap.size() + componentCacheMap.size()));
        this.finished = true;
        CacheComponentRegister();
        CacheModuleRegister();
        return true;
    }

    public boolean cacheModule(java.lang.String str, com.taobao.weex.bridge.ModuleFactory moduleFactory, boolean z) {
        if (!canCache()) {
            return false;
        }
        try {
            moduleCacheMap.put(str, new com.taobao.weex.utils.cache.RegisterCache.ModuleCache(str, moduleFactory, z));
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public boolean cacheComponent(java.lang.String str, com.taobao.weex.ui.IFComponentHolder iFComponentHolder, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (!canCache()) {
            return false;
        }
        try {
            componentCacheMap.put(str, new com.taobao.weex.utils.cache.RegisterCache.ComponentCache(str, iFComponentHolder, map));
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private void CacheComponentRegister() {
        if (componentCacheMap.isEmpty()) {
            return;
        }
        com.taobao.weex.ui.WXComponentRegistry.registerComponent(componentCacheMap);
    }

    private void CacheModuleRegister() {
        if (moduleCacheMap.isEmpty()) {
            return;
        }
        com.taobao.weex.bridge.WXModuleManager.registerModule(moduleCacheMap);
    }

    public class ModuleCache {
        public final com.taobao.weex.bridge.ModuleFactory factory;
        public final boolean global;
        public final java.lang.String name;

        ModuleCache(java.lang.String str, com.taobao.weex.bridge.ModuleFactory moduleFactory, boolean z) {
            this.name = str;
            this.factory = moduleFactory;
            this.global = z;
        }
    }

    public class ComponentCache {
        public final java.util.Map<java.lang.String, java.lang.Object> componentInfo;
        public final com.taobao.weex.ui.IFComponentHolder holder;
        public final java.lang.String type;

        ComponentCache(java.lang.String str, com.taobao.weex.ui.IFComponentHolder iFComponentHolder, java.util.Map<java.lang.String, java.lang.Object> map) {
            this.type = str;
            this.componentInfo = map;
            this.holder = iFComponentHolder;
        }
    }
}
