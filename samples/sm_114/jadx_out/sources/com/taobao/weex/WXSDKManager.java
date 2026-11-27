package com.taobao.weex;

/* JADX INFO: loaded from: classes.dex */
public class WXSDKManager {
    private static final int DEFAULT_VIEWPORT_WIDTH = 750;
    private static java.util.concurrent.atomic.AtomicInteger sInstanceId = new java.util.concurrent.atomic.AtomicInteger(0);
    private static volatile com.taobao.weex.WXSDKManager sManager;
    private com.taobao.weex.appfram.navigator.IActivityNavBarSetter mActivityNavBarSetter;
    private java.util.Map<java.lang.String, com.taobao.weex.WXSDKInstance> mAllInstanceMap;
    private com.taobao.weex.performance.IApmGenerator mApmGenerater;
    private com.taobao.weex.bridge.WXBridgeManager mBridgeManager;
    private com.taobao.weex.adapter.ClassLoaderAdapter mClassLoaderAdapter;
    private com.taobao.weex.adapter.IWXConfigAdapter mConfigAdapter;
    private com.taobao.weex.adapter.ICrashInfoReporter mCrashInfo;
    private com.taobao.weex.adapter.IDrawableLoader mDrawableLoader;
    private com.taobao.weex.font.FontAdapter mFontAdapter;
    private com.taobao.weex.adapter.IWXHttpAdapter mIWXHttpAdapter;
    private com.taobao.weex.adapter.IWXImgLoaderAdapter mIWXImgLoaderAdapter;
    private com.taobao.weex.adapter.IWXJSExceptionAdapter mIWXJSExceptionAdapter;
    private com.taobao.weex.adapter.IWXSoLoaderAdapter mIWXSoLoaderAdapter;
    private com.taobao.weex.appfram.storage.IWXStorageAdapter mIWXStorageAdapter;
    private com.taobao.weex.adapter.IWXUserTrackAdapter mIWXUserTrackAdapter;
    private com.taobao.weex.appfram.websocket.IWebSocketAdapterFactory mIWebSocketAdapterFactory;
    private java.util.List<com.taobao.weex.WXSDKManager.InstanceLifeCycleCallbacks> mLifeCycleCallbacks;
    private com.taobao.weex.appfram.navigator.INavigator mNavigator;
    private boolean mNeedInitV8;
    private com.taobao.weex.adapter.IWXAccessibilityRoleAdapter mRoleAdapter;
    private com.taobao.weex.IWXStatisticsListener mStatisticsListener;
    private com.taobao.weex.adapter.ITracingAdapter mTracingAdapter;
    private com.taobao.weex.adapter.URIAdapter mURIAdapter;
    private com.taobao.weex.bridge.IDCVueBridgeAdapter mVueBridgeAdapter;
    private java.util.List<com.taobao.weex.performance.IWXAnalyzer> mWXAnalyzerList;
    private com.taobao.weex.adapter.IWXJsFileLoaderAdapter mWXJsFileLoaderAdapter;
    private com.taobao.weex.adapter.IWXJscProcessManager mWXJscProcessManager;
    com.taobao.weex.ui.WXRenderManager mWXRenderManager;
    private com.taobao.weex.bridge.WXValidateProcessor mWXValidateProcessor;
    private final com.taobao.weex.common.WXWorkThreadManager mWXWorkThreadManager;

    public interface InstanceLifeCycleCallbacks {
        void onInstanceCreated(java.lang.String str);

        void onInstanceDestroyed(java.lang.String str);
    }

    private WXSDKManager() {
        this(new com.taobao.weex.ui.WXRenderManager());
    }

    private WXSDKManager(com.taobao.weex.ui.WXRenderManager wXRenderManager) {
        this.mNeedInitV8 = true;
        this.mWXRenderManager = wXRenderManager;
        this.mBridgeManager = com.taobao.weex.bridge.WXBridgeManager.getInstance();
        this.mWXWorkThreadManager = new com.taobao.weex.common.WXWorkThreadManager();
        this.mWXAnalyzerList = new java.util.concurrent.CopyOnWriteArrayList();
        this.mAllInstanceMap = new java.util.HashMap();
    }

    static void initInstance(com.taobao.weex.ui.WXRenderManager wXRenderManager) {
        sManager = new com.taobao.weex.WXSDKManager(wXRenderManager);
    }

    public void registerStatisticsListener(com.taobao.weex.IWXStatisticsListener iWXStatisticsListener) {
        this.mStatisticsListener = iWXStatisticsListener;
    }

    public com.taobao.weex.IWXStatisticsListener getWXStatisticsListener() {
        return this.mStatisticsListener;
    }

    public void onSDKEngineInitialize() {
        com.taobao.weex.IWXStatisticsListener iWXStatisticsListener = this.mStatisticsListener;
        if (iWXStatisticsListener != null) {
            iWXStatisticsListener.onSDKEngineInitialize();
        }
    }

    public void setNeedInitV8(boolean z) {
        this.mNeedInitV8 = z;
    }

    public boolean needInitV8() {
        return this.mNeedInitV8;
    }

    public void takeJSHeapSnapshot(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        if (file.exists() || file.mkdir()) {
            java.lang.String strValueOf = java.lang.String.valueOf(sInstanceId.get());
            if (!str.endsWith(java.io.File.separator)) {
                str = str + java.io.File.separator;
            }
            this.mBridgeManager.takeJSHeapSnapshot((str + strValueOf) + ".heapsnapshot");
        }
    }

    public static com.taobao.weex.WXSDKManager getInstance() {
        if (sManager == null) {
            synchronized (com.taobao.weex.WXSDKManager.class) {
                if (sManager == null) {
                    sManager = new com.taobao.weex.WXSDKManager();
                }
            }
        }
        return sManager;
    }

    public static float getInstanceViewPortWidth(java.lang.String str) {
        com.taobao.weex.WXSDKInstance sDKInstance = getInstance().getSDKInstance(str);
        if (sDKInstance == null) {
            return 750.0f;
        }
        return sDKInstance.getInstanceViewPortWidthWithFloat();
    }

    static void setInstance(com.taobao.weex.WXSDKManager wXSDKManager) {
        sManager = wXSDKManager;
    }

    public com.taobao.weex.appfram.navigator.IActivityNavBarSetter getActivityNavBarSetter() {
        return this.mActivityNavBarSetter;
    }

    public void setActivityNavBarSetter(com.taobao.weex.appfram.navigator.IActivityNavBarSetter iActivityNavBarSetter) {
        this.mActivityNavBarSetter = iActivityNavBarSetter;
    }

    public void restartBridge() {
        this.mBridgeManager.restart();
    }

    public com.taobao.weex.bridge.WXBridgeManager getWXBridgeManager() {
        return this.mBridgeManager;
    }

    public com.taobao.weex.ui.WXRenderManager getWXRenderManager() {
        return this.mWXRenderManager;
    }

    public com.taobao.weex.adapter.IWXJscProcessManager getWXJscProcessManager() {
        return this.mWXJscProcessManager;
    }

    public com.taobao.weex.common.WXWorkThreadManager getWXWorkThreadManager() {
        return this.mWXWorkThreadManager;
    }

    public void setWxConfigAdapter(com.taobao.weex.adapter.IWXConfigAdapter iWXConfigAdapter) {
        this.mConfigAdapter = iWXConfigAdapter;
    }

    public com.taobao.weex.adapter.IWXConfigAdapter getWxConfigAdapter() {
        return this.mConfigAdapter;
    }

    public com.taobao.weex.WXSDKInstance getSDKInstance(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return this.mWXRenderManager.getWXSDKInstance(str);
    }

    public void postOnUiThread(java.lang.Runnable runnable, long j) {
        this.mWXRenderManager.postOnUiThread(com.taobao.weex.common.WXThread.secure(runnable), j);
    }

    public java.util.Map<java.lang.String, com.taobao.weex.WXSDKInstance> getAllInstanceMap() {
        return this.mAllInstanceMap;
    }

    public void destroy() {
        com.taobao.weex.common.WXWorkThreadManager wXWorkThreadManager = this.mWXWorkThreadManager;
        if (wXWorkThreadManager != null) {
            wXWorkThreadManager.destroy();
        }
        this.mAllInstanceMap.clear();
    }

    @java.lang.Deprecated
    public void callback(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map) {
        this.mBridgeManager.callback(str, str2, map);
    }

    @java.lang.Deprecated
    public void callback(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map, boolean z) {
        this.mBridgeManager.callback(str, str2, map, z);
    }

    public void initScriptsFramework(java.lang.String str) {
        this.mBridgeManager.initScriptsFramework(str);
    }

    public void registerComponents(java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list) {
        this.mBridgeManager.registerComponents(list);
    }

    public void registerModules(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.mBridgeManager.registerModules(map);
    }

    @java.lang.Deprecated
    public void fireEvent(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        fireEvent(str, str2, str3, new java.util.HashMap());
    }

    @java.lang.Deprecated
    public void fireEvent(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map) {
        fireEvent(str, str2, str3, map, null);
    }

    @java.lang.Deprecated
    public void fireEvent(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        if (com.taobao.weex.WXEnvironment.isApkDebugable() && android.os.Looper.getMainLooper().getThread().getId() != java.lang.Thread.currentThread().getId()) {
            throw new com.taobao.weex.common.WXRuntimeException("[WXSDKManager]  fireEvent error");
        }
        this.mBridgeManager.fireEventOnNode(str, str2, str3, map, map2);
    }

    void createInstance(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.Script script, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str) {
        this.mWXRenderManager.registerInstance(wXSDKInstance);
        this.mBridgeManager.createInstance(wXSDKInstance.getInstanceId(), script, map, str);
        java.util.List<com.taobao.weex.WXSDKManager.InstanceLifeCycleCallbacks> list = this.mLifeCycleCallbacks;
        if (list != null) {
            java.util.Iterator<com.taobao.weex.WXSDKManager.InstanceLifeCycleCallbacks> it = list.iterator();
            while (it.hasNext()) {
                it.next().onInstanceCreated(wXSDKInstance.getInstanceId());
            }
        }
    }

    void refreshInstance(java.lang.String str, com.taobao.weex.common.WXRefreshData wXRefreshData) {
        this.mBridgeManager.refreshInstance(str, wXRefreshData);
    }

    void destroyInstance(java.lang.String str) {
        setCrashInfo(com.taobao.weex.WXEnvironment.WEEX_CURRENT_KEY, "");
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (!com.taobao.weex.utils.WXUtils.isUiThread()) {
            throw new com.taobao.weex.common.WXRuntimeException("[WXSDKManager] destroyInstance error");
        }
        java.util.List<com.taobao.weex.WXSDKManager.InstanceLifeCycleCallbacks> list = this.mLifeCycleCallbacks;
        if (list != null) {
            java.util.Iterator<com.taobao.weex.WXSDKManager.InstanceLifeCycleCallbacks> it = list.iterator();
            while (it.hasNext()) {
                it.next().onInstanceDestroyed(str);
            }
        }
        this.mWXRenderManager.removeRenderStatement(str);
        this.mBridgeManager.destroyInstance(str);
        com.taobao.weex.bridge.WXModuleManager.destroyInstanceModules(str);
    }

    java.lang.String generateInstanceId() {
        return java.lang.String.valueOf(sInstanceId.incrementAndGet());
    }

    public com.taobao.weex.adapter.IWXUserTrackAdapter getIWXUserTrackAdapter() {
        return this.mIWXUserTrackAdapter;
    }

    public com.taobao.weex.adapter.IWXImgLoaderAdapter getIWXImgLoaderAdapter() {
        return this.mIWXImgLoaderAdapter;
    }

    public com.taobao.weex.adapter.IWXJsFileLoaderAdapter getIWXJsFileLoaderAdapter() {
        return this.mWXJsFileLoaderAdapter;
    }

    public com.taobao.weex.adapter.IDrawableLoader getDrawableLoader() {
        return this.mDrawableLoader;
    }

    public com.taobao.weex.adapter.IWXJSExceptionAdapter getIWXJSExceptionAdapter() {
        return this.mIWXJSExceptionAdapter;
    }

    public void setIWXJSExceptionAdapter(com.taobao.weex.adapter.IWXJSExceptionAdapter iWXJSExceptionAdapter) {
        this.mIWXJSExceptionAdapter = iWXJSExceptionAdapter;
    }

    public com.taobao.weex.adapter.IWXHttpAdapter getIWXHttpAdapter() {
        if (this.mIWXHttpAdapter == null) {
            this.mIWXHttpAdapter = new com.taobao.weex.adapter.DefaultWXHttpAdapter();
        }
        return this.mIWXHttpAdapter;
    }

    public com.taobao.weex.performance.IApmGenerator getApmGenerater() {
        return this.mApmGenerater;
    }

    public com.taobao.weex.adapter.URIAdapter getURIAdapter() {
        if (this.mURIAdapter == null) {
            this.mURIAdapter = new com.taobao.weex.adapter.DefaultUriAdapter();
        }
        return this.mURIAdapter;
    }

    public com.taobao.weex.bridge.IDCVueBridgeAdapter getVueBridgeAdapter() {
        return this.mVueBridgeAdapter;
    }

    public com.taobao.weex.adapter.ClassLoaderAdapter getClassLoaderAdapter() {
        if (this.mClassLoaderAdapter == null) {
            this.mClassLoaderAdapter = new com.taobao.weex.adapter.ClassLoaderAdapter();
        }
        return this.mClassLoaderAdapter;
    }

    public com.taobao.weex.adapter.IWXSoLoaderAdapter getIWXSoLoaderAdapter() {
        return this.mIWXSoLoaderAdapter;
    }

    public java.util.List<com.taobao.weex.performance.IWXAnalyzer> getWXAnalyzerList() {
        return this.mWXAnalyzerList;
    }

    public void addWXAnalyzer(com.taobao.weex.performance.IWXAnalyzer iWXAnalyzer) {
        if (this.mWXAnalyzerList.contains(iWXAnalyzer)) {
            return;
        }
        this.mWXAnalyzerList.add(iWXAnalyzer);
    }

    public void rmWXAnalyzer(com.taobao.weex.performance.IWXAnalyzer iWXAnalyzer) {
        this.mWXAnalyzerList.remove(iWXAnalyzer);
    }

    void setInitConfig(com.taobao.weex.InitConfig initConfig) {
        this.mIWXHttpAdapter = initConfig.getHttpAdapter();
        this.mIWXImgLoaderAdapter = initConfig.getImgAdapter();
        this.mDrawableLoader = initConfig.getDrawableLoader();
        this.mIWXStorageAdapter = initConfig.getStorageAdapter();
        this.mVueBridgeAdapter = initConfig.getVueBridgeAdaper();
        this.mIWXUserTrackAdapter = initConfig.getUtAdapter();
        this.mURIAdapter = initConfig.getURIAdapter();
        this.mIWebSocketAdapterFactory = initConfig.getWebSocketAdapterFactory();
        this.mIWXJSExceptionAdapter = initConfig.getJSExceptionAdapter();
        this.mIWXSoLoaderAdapter = initConfig.getIWXSoLoaderAdapter();
        this.mClassLoaderAdapter = initConfig.getClassLoaderAdapter();
        this.mApmGenerater = initConfig.getApmGenerater();
        this.mWXJsFileLoaderAdapter = initConfig.getJsFileLoaderAdapter();
        this.mWXJscProcessManager = initConfig.getJscProcessManager();
    }

    public com.taobao.weex.appfram.storage.IWXStorageAdapter getIWXStorageAdapter() {
        if (this.mIWXStorageAdapter == null) {
            if (com.taobao.weex.WXEnvironment.sApplication != null) {
                this.mIWXStorageAdapter = new com.taobao.weex.appfram.storage.DefaultWXStorage(com.taobao.weex.WXEnvironment.sApplication);
            } else {
                com.taobao.weex.utils.WXLogUtils.e("WXStorageModule", "No Application context found,you should call WXSDKEngine#initialize() method in your application");
            }
        }
        return this.mIWXStorageAdapter;
    }

    public void notifyTrimMemory() {
        this.mBridgeManager.notifyTrimMemory();
    }

    public void notifySerializeCodeCache() {
        this.mBridgeManager.notifySerializeCodeCache();
    }

    public com.taobao.weex.appfram.websocket.IWebSocketAdapter getIWXWebSocketAdapter() {
        com.taobao.weex.appfram.websocket.IWebSocketAdapterFactory iWebSocketAdapterFactory = this.mIWebSocketAdapterFactory;
        if (iWebSocketAdapterFactory != null) {
            return iWebSocketAdapterFactory.createWebSocketAdapter();
        }
        return null;
    }

    public void registerValidateProcessor(com.taobao.weex.bridge.WXValidateProcessor wXValidateProcessor) {
        this.mWXValidateProcessor = wXValidateProcessor;
    }

    public com.taobao.weex.bridge.WXValidateProcessor getValidateProcessor() {
        return this.mWXValidateProcessor;
    }

    public void setCrashInfoReporter(com.taobao.weex.adapter.ICrashInfoReporter iCrashInfoReporter) {
        this.mCrashInfo = iCrashInfoReporter;
    }

    public void setCrashInfo(java.lang.String str, java.lang.String str2) {
        com.taobao.weex.adapter.ICrashInfoReporter iCrashInfoReporter = this.mCrashInfo;
        if (iCrashInfoReporter != null) {
            iCrashInfoReporter.addCrashInfo(str, str2);
        }
    }

    public void setTracingAdapter(com.taobao.weex.adapter.ITracingAdapter iTracingAdapter) {
        this.mTracingAdapter = iTracingAdapter;
    }

    public com.taobao.weex.adapter.ITracingAdapter getTracingAdapter() {
        return this.mTracingAdapter;
    }

    public void registerInstanceLifeCycleCallbacks(com.taobao.weex.WXSDKManager.InstanceLifeCycleCallbacks instanceLifeCycleCallbacks) {
        if (this.mLifeCycleCallbacks == null) {
            this.mLifeCycleCallbacks = new java.util.ArrayList();
        }
        this.mLifeCycleCallbacks.add(instanceLifeCycleCallbacks);
    }

    public void setAccessibilityRoleAdapter(com.taobao.weex.adapter.IWXAccessibilityRoleAdapter iWXAccessibilityRoleAdapter) {
        this.mRoleAdapter = iWXAccessibilityRoleAdapter;
    }

    public com.taobao.weex.adapter.IWXAccessibilityRoleAdapter getAccessibilityRoleAdapter() {
        return this.mRoleAdapter;
    }

    public com.taobao.weex.appfram.navigator.INavigator getNavigator() {
        return this.mNavigator;
    }

    public void setNavigator(com.taobao.weex.appfram.navigator.INavigator iNavigator) {
        this.mNavigator = iNavigator;
    }

    public com.taobao.weex.font.FontAdapter getFontAdapter() {
        if (this.mFontAdapter == null) {
            synchronized (this) {
                if (this.mFontAdapter == null) {
                    this.mFontAdapter = new com.taobao.weex.font.FontAdapter();
                }
            }
        }
        return this.mFontAdapter;
    }
}
