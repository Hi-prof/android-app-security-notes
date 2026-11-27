package com.taobao.weex;

/* JADX INFO: loaded from: classes.dex */
public class WXSDKEngine extends io.dcloud.feature.uniapp.AbsSDKEngine {
    public static final java.lang.String JS_FRAMEWORK_RELOAD = "js_framework_reload";
    private static final java.lang.String TAG = "WXSDKEngine";
    private static final java.lang.String V8_SO_NAME = "weexcore";
    private static volatile boolean mIsInit = false;
    private static volatile boolean mIsSoInit = false;
    private static final java.lang.Object mLock = new java.lang.Object();

    public static abstract class DestroyableModule extends com.taobao.weex.common.WXModule implements com.taobao.weex.common.Destroyable {
    }

    @java.lang.Deprecated
    public static void init(android.app.Application application) {
        init(application, null);
    }

    @java.lang.Deprecated
    public static void init(android.app.Application application, com.taobao.weex.adapter.IWXUserTrackAdapter iWXUserTrackAdapter) {
        init(application, iWXUserTrackAdapter, null);
    }

    @java.lang.Deprecated
    public static void init(android.app.Application application, com.taobao.weex.adapter.IWXUserTrackAdapter iWXUserTrackAdapter, java.lang.String str) {
        initialize(application, new com.taobao.weex.InitConfig.Builder().setUtAdapter(iWXUserTrackAdapter).build());
    }

    public static boolean isInitialized() {
        boolean z;
        synchronized (mLock) {
            z = mIsInit && com.taobao.weex.WXEnvironment.JsFrameworkInit;
        }
        return z;
    }

    public static boolean isSoInitialized() {
        boolean z;
        synchronized (mLock) {
            z = mIsSoInit;
        }
        return z;
    }

    public static void initialize(android.app.Application application, com.taobao.weex.InitConfig initConfig) {
        synchronized (mLock) {
            if (mIsInit) {
                return;
            }
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            com.taobao.weex.WXEnvironment.sSDKInitStart = jCurrentTimeMillis;
            if (com.taobao.weex.WXEnvironment.isApkDebugable(application)) {
                com.taobao.weex.WXEnvironment.sLogLevel = com.taobao.weex.utils.LogLevel.INFO;
            } else {
                com.taobao.weex.WXEnvironment.sLogLevel = com.taobao.weex.utils.LogLevel.WARN;
            }
            doInitInternal(application, initConfig);
            registerApplicationOptions(application);
            com.taobao.weex.WXEnvironment.sSDKInitInvokeTime = java.lang.System.currentTimeMillis() - jCurrentTimeMillis;
            com.taobao.weex.utils.WXLogUtils.renderPerformanceLog("SDKInitInvokeTime", com.taobao.weex.WXEnvironment.sSDKInitInvokeTime);
            mIsInit = true;
            if (!io.dcloud.common.util.AppRuntime.hasPrivacyForNotShown(application)) {
                io.dcloud.feature.uniapp.UniMoudlesLoader.getInstance().onCreate(application);
            }
        }
    }

    private static void registerApplicationOptions(android.app.Application application) {
        if (application == null) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, "RegisterApplicationOptions application is null");
            return;
        }
        android.content.res.Resources resources = application.getResources();
        registerCoreEnv("screen_width_pixels", java.lang.String.valueOf(resources.getDisplayMetrics().widthPixels));
        registerCoreEnv("screen_height_pixels", java.lang.String.valueOf(resources.getDisplayMetrics().heightPixels));
        int identifier = resources.getIdentifier("status_bar_height", "dimen", com.taobao.weex.WXEnvironment.OS);
        if (identifier > 0) {
            registerCoreEnv("status_bar_height", java.lang.String.valueOf(resources.getDimensionPixelSize(identifier)));
        }
    }

    private static void doInitInternal(final android.app.Application application, final com.taobao.weex.InitConfig initConfig) {
        com.taobao.weex.WXEnvironment.sApplication = application;
        if (application == null) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, " doInitInternal application is null");
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(null, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_SDK_INIT, "doInitInternal", com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_SDK_INIT.getErrorMsg() + "WXEnvironment sApplication is null", null);
        }
        com.taobao.weex.WXEnvironment.JsFrameworkInit = false;
        com.taobao.weex.bridge.WXBridgeManager.getInstance().postWithName(new java.lang.Runnable() { // from class: com.taobao.weex.WXSDKEngine.1
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                com.taobao.weex.WXSDKManager wXSDKManager = com.taobao.weex.WXSDKManager.getInstance();
                wXSDKManager.onSDKEngineInitialize();
                com.taobao.weex.InitConfig initConfig2 = initConfig;
                if (initConfig2 != null) {
                    wXSDKManager.setInitConfig(initConfig2);
                }
                com.taobao.weex.utils.WXSoInstallMgrSdk.init(application, wXSDKManager.getIWXSoLoaderAdapter(), wXSDKManager.getWXStatisticsListener());
                com.taobao.weex.InitConfig initConfig3 = initConfig;
                com.taobao.weex.adapter.IWXUserTrackAdapter utAdapter = initConfig3 != null ? initConfig3.getUtAdapter() : null;
                boolean unused = com.taobao.weex.WXSDKEngine.mIsSoInit = com.taobao.weex.utils.WXSoInstallMgrSdk.initSo("weexcore", 1, utAdapter);
                com.taobao.weex.utils.WXSoInstallMgrSdk.copyJssRuntimeSo();
                com.taobao.weex.InitConfig initConfig4 = initConfig;
                if (initConfig4 != null) {
                    java.util.Iterator<java.lang.String> it = initConfig4.getNativeLibraryList().iterator();
                    while (it.hasNext()) {
                        com.taobao.weex.utils.WXSoInstallMgrSdk.initSo(it.next(), 1, utAdapter);
                    }
                }
                if (!com.taobao.weex.WXSDKEngine.mIsSoInit) {
                    com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(null, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_SDK_INIT, "doInitInternal", com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_SDK_INIT.getErrorMsg() + "isSoInit false", null);
                    return;
                }
                com.taobao.weex.InitConfig initConfig5 = initConfig;
                wXSDKManager.initScriptsFramework(initConfig5 != null ? initConfig5.getFramework() : null);
                com.taobao.weex.WXEnvironment.sSDKInitExecuteTime = java.lang.System.currentTimeMillis() - jCurrentTimeMillis;
                com.taobao.weex.utils.WXLogUtils.renderPerformanceLog("SDKInitExecuteTime", com.taobao.weex.WXEnvironment.sSDKInitExecuteTime);
            }
        }, null, "doInitWeexSdkInternal");
        register();
    }

    @java.lang.Deprecated
    public static void init(android.app.Application application, java.lang.String str, com.taobao.weex.adapter.IWXUserTrackAdapter iWXUserTrackAdapter, com.taobao.weex.adapter.IWXImgLoaderAdapter iWXImgLoaderAdapter, com.taobao.weex.adapter.IWXHttpAdapter iWXHttpAdapter) {
        initialize(application, new com.taobao.weex.InitConfig.Builder().setUtAdapter(iWXUserTrackAdapter).setHttpAdapter(iWXHttpAdapter).setImgAdapter(iWXImgLoaderAdapter).build());
    }

    public static void setJSExcetptionAdapter(com.taobao.weex.adapter.IWXJSExceptionAdapter iWXJSExceptionAdapter) {
        com.taobao.weex.WXSDKManager.getInstance().setIWXJSExceptionAdapter(iWXJSExceptionAdapter);
    }

    private static void register() {
        com.taobao.weex.utils.batch.BatchOperationHelper batchOperationHelper = new com.taobao.weex.utils.batch.BatchOperationHelper(com.taobao.weex.bridge.WXBridgeManager.getInstance());
        try {
            registerComponent((com.taobao.weex.ui.IFComponentHolder) new com.taobao.weex.ui.SimpleComponentHolder(com.taobao.weex.ui.component.WXText.class, new com.taobao.weex.ui.component.WXText.Creator()), false, "text");
            registerComponent((com.taobao.weex.ui.IFComponentHolder) new com.taobao.weex.ui.SimpleComponentHolder(com.taobao.weex.ui.component.WXDiv.class, new com.taobao.weex.ui.component.WXDiv.Ceator()), false, com.taobao.weex.ui.component.WXBasicComponentType.CONTAINER, com.taobao.weex.ui.component.WXBasicComponentType.DIV, com.taobao.weex.ui.component.WXBasicComponentType.HEADER, com.taobao.weex.ui.component.WXBasicComponentType.FOOTER);
            registerComponent((com.taobao.weex.ui.IFComponentHolder) new com.taobao.weex.ui.SimpleComponentHolder(com.taobao.weex.ui.component.WXImage.class, new com.taobao.weex.ui.component.WXImage.Creator()), false, "image", com.taobao.weex.ui.component.WXBasicComponentType.IMG);
            registerComponent((com.taobao.weex.ui.IFComponentHolder) new com.taobao.weex.ui.SimpleComponentHolder(com.taobao.weex.ui.component.WXScroller.class, new com.taobao.weex.ui.component.WXScroller.Creator()), false, com.taobao.weex.ui.component.WXBasicComponentType.SCROLLER);
            registerComponent((com.taobao.weex.ui.IFComponentHolder) new com.taobao.weex.ui.SimpleComponentHolder(com.taobao.weex.ui.component.WXSlider.class, new com.taobao.weex.ui.component.WXSlider.Creator()), true, com.taobao.weex.ui.component.WXBasicComponentType.CYCLE_SLIDER);
            registerComponent((com.taobao.weex.ui.IFComponentHolder) new com.taobao.weex.ui.SimpleComponentHolder(com.taobao.weex.ui.component.WXSliderNeighbor.class, new com.taobao.weex.ui.component.WXSliderNeighbor.Creator()), true, com.taobao.weex.ui.component.WXBasicComponentType.SLIDER_NEIGHBOR);
            registerComponent((com.taobao.weex.ui.IFComponentHolder) new com.taobao.weex.ui.SimpleComponentHolder(com.taobao.weex.ui.component.list.WXCell.class, new com.taobao.weex.ui.component.list.WXCell.Creator()), true, com.taobao.weex.ui.component.WXBasicComponentType.CELL);
            registerComponent((com.taobao.weex.ui.IFComponentHolder) new com.taobao.weex.ui.SimpleComponentHolder(com.taobao.weex.ui.component.list.WXListComponent.class, new com.taobao.weex.ui.component.list.WXListComponent.Creator()), true, com.taobao.weex.ui.component.WXBasicComponentType.LIST, com.taobao.weex.ui.component.WXBasicComponentType.VLIST, com.taobao.weex.ui.component.WXBasicComponentType.RECYCLER, com.taobao.weex.ui.component.WXBasicComponentType.WATERFALL);
            registerComponent((com.taobao.weex.ui.IFComponentHolder) new com.taobao.weex.ui.SimpleComponentHolder(com.taobao.weex.ui.component.richtext.WXRichText.class, new com.taobao.weex.ui.component.richtext.WXRichText.Creator()), false, com.taobao.weex.ui.component.WXBasicComponentType.RICHTEXT);
            registerComponent((java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) com.taobao.weex.ui.component.list.SimpleListComponent.class, false, "simplelist");
            registerComponent((java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.class, false, com.taobao.weex.ui.component.WXBasicComponentType.RECYCLE_LIST);
            registerComponent((java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) com.taobao.weex.ui.component.list.HorizontalListComponent.class, false, com.taobao.weex.ui.component.WXBasicComponentType.HLIST);
            registerComponent(com.taobao.weex.ui.component.WXBasicComponentType.CELL_SLOT, (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) com.taobao.weex.ui.component.list.WXCell.class, true);
            registerComponent(com.taobao.weex.ui.component.WXBasicComponentType.INDICATOR, (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) com.taobao.weex.ui.component.WXIndicator.class, true);
            registerComponent("video", (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) com.taobao.weex.ui.component.WXVideo.class, false);
            registerComponent("input", (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) com.taobao.weex.ui.component.WXInput.class, false);
            registerComponent(com.taobao.weex.ui.component.WXBasicComponentType.TEXTAREA, (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) com.taobao.weex.ui.component.Textarea.class, false);
            registerComponent("a", (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) com.taobao.weex.ui.component.WXA.class, false);
            registerComponent(com.taobao.weex.ui.component.WXBasicComponentType.EMBED, (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) com.taobao.weex.ui.component.WXEmbed.class, true);
            registerComponent("web", (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) com.taobao.weex.ui.component.WXWeb.class);
            registerComponent("refresh", (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) com.taobao.weex.ui.component.WXRefresh.class);
            registerComponent("loading", (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) com.taobao.weex.ui.component.WXLoading.class);
            registerComponent(com.taobao.weex.ui.component.WXBasicComponentType.LOADING_INDICATOR, (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) com.taobao.weex.ui.component.WXLoadingIndicator.class);
            registerComponent(com.taobao.weex.ui.component.WXBasicComponentType.HEADER, (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) com.taobao.weex.ui.component.WXHeader.class);
            registerModule(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_MODAL, com.taobao.weex.ui.module.WXModalUIModule.class);
            registerModule("instanceWrap", com.taobao.weex.common.WXInstanceWrap.class);
            registerModule("animation", com.taobao.weex.ui.animation.WXAnimationModule.class);
            registerModule("webview", com.taobao.weex.ui.module.WXWebViewModule.class);
            registerModule("navigator", com.taobao.weex.appfram.navigator.WXNavigatorModule.class);
            registerModule(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_STREAM, com.taobao.weex.http.WXStreamModule.class);
            registerModule("timer", com.taobao.weex.ui.module.WXTimerModule.class);
            registerModule("storage", com.taobao.weex.appfram.storage.WXStorageModule.class);
            registerModule("clipboard", com.taobao.weex.appfram.clipboard.WXClipboardModule.class);
            registerModule("globalEvent", com.taobao.weex.WXGlobalEventModule.class);
            registerModule("picker", com.taobao.weex.appfram.pickers.WXPickersModule.class);
            registerModule("meta", com.taobao.weex.ui.module.WXMetaModule.class);
            registerModule("webSocket", com.taobao.weex.appfram.websocket.WebSocketModule.class);
            registerModule("locale", com.taobao.weex.ui.module.WXLocaleModule.class);
            registerModule("deviceInfo", com.taobao.weex.ui.module.WXDeviceInfoModule.class);
            registerModule("sdk-console-log", com.taobao.weex.ui.module.ConsoleLogModule.class);
        } catch (com.taobao.weex.common.WXException e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXSDKEngine] register:", e);
        }
        if (com.taobao.weex.utils.cache.RegisterCache.getInstance().enableAutoScan()) {
            com.taobao.weex.ui.config.AutoScanConfigRegister.doScanConfig();
        }
        batchOperationHelper.flush();
    }

    public static boolean registerComponent(java.lang.String str, java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent> cls, boolean z) throws com.taobao.weex.common.WXException {
        return registerComponent(cls, z, str);
    }

    public static boolean registerComponent(java.lang.String str, com.taobao.weex.ui.IExternalComponentGetter iExternalComponentGetter, boolean z) throws com.taobao.weex.common.WXException {
        return registerComponent(new com.taobao.weex.ui.ExternalLoaderComponentHolder(str, iExternalComponentGetter), z, str);
    }

    public static boolean registerComponent(java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent> cls, boolean z, java.lang.String... strArr) throws com.taobao.weex.common.WXException {
        if (cls == null) {
            return false;
        }
        return registerComponent(new com.taobao.weex.ui.SimpleComponentHolder(cls), z, strArr);
    }

    public static boolean registerComponent(com.taobao.weex.ui.IFComponentHolder iFComponentHolder, boolean z, java.lang.String... strArr) throws com.taobao.weex.common.WXException {
        boolean z2 = true;
        try {
            boolean z3 = true;
            for (java.lang.String str : strArr) {
                try {
                    java.util.HashMap map = new java.util.HashMap();
                    if (z) {
                        map.put("append", "tree");
                    }
                    z3 = z3 && com.taobao.weex.ui.WXComponentRegistry.registerComponent(str, iFComponentHolder, map);
                } catch (java.lang.Throwable th) {
                    th = th;
                    z2 = z3;
                    th.printStackTrace();
                    return z2;
                }
            }
            return z3;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static <T extends com.taobao.weex.common.WXModule> boolean registerModule(java.lang.String str, java.lang.Class<T> cls, boolean z) throws com.taobao.weex.common.WXException {
        return cls != null && registerModule(str, new com.taobao.weex.common.TypeModuleFactory(cls), z);
    }

    public static <T extends com.taobao.weex.common.WXModule> boolean registerModuleWithFactory(java.lang.String str, com.taobao.weex.WXSDKEngine.DestroyableModuleFactory destroyableModuleFactory, boolean z) throws com.taobao.weex.common.WXException {
        return registerModule(str, destroyableModuleFactory, z);
    }

    public static <T extends com.taobao.weex.common.WXModule> boolean registerModuleWithFactory(java.lang.String str, com.taobao.weex.ui.IExternalModuleGetter iExternalModuleGetter, boolean z) throws com.taobao.weex.common.WXException {
        return registerModule(str, iExternalModuleGetter.getExternalModuleClass(str, com.taobao.weex.WXEnvironment.getApplication()), z);
    }

    public static <T extends com.taobao.weex.common.WXModule> boolean registerModule(java.lang.String str, com.taobao.weex.bridge.ModuleFactory moduleFactory, boolean z) throws com.taobao.weex.common.WXException {
        return com.taobao.weex.bridge.WXModuleManager.registerModule(str, moduleFactory, z);
    }

    public static boolean registerModule(java.lang.String str, java.lang.Class<? extends com.taobao.weex.common.WXModule> cls) throws com.taobao.weex.common.WXException {
        return registerModule(str, (java.lang.Class) cls, false);
    }

    public static boolean registerService(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map) {
        return com.taobao.weex.bridge.WXServiceManager.registerService(str, str2, map);
    }

    public static boolean unRegisterService(java.lang.String str) {
        return com.taobao.weex.bridge.WXServiceManager.unRegisterService(str);
    }

    public static abstract class DestroyableModuleFactory<T extends com.taobao.weex.WXSDKEngine.DestroyableModule> extends com.taobao.weex.common.TypeModuleFactory<T> {
        public DestroyableModuleFactory(java.lang.Class<T> cls) {
            super(cls);
        }
    }

    public static void callback(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.taobao.weex.WXSDKManager.getInstance().callback(str, str2, map);
    }

    public static void restartBridge(boolean z) {
        com.taobao.weex.WXEnvironment.sDebugMode = z;
        com.taobao.weex.WXSDKManager.getInstance().restartBridge();
    }

    public static boolean registerComponent(java.lang.String str, java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent> cls) throws com.taobao.weex.common.WXException {
        return com.taobao.weex.ui.WXComponentRegistry.registerComponent(str, new com.taobao.weex.ui.SimpleComponentHolder(cls), new java.util.HashMap());
    }

    public static boolean registerComponent(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent> cls) throws com.taobao.weex.common.WXException {
        if (map == null) {
            return false;
        }
        java.lang.String str = (java.lang.String) map.get("type");
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return com.taobao.weex.ui.WXComponentRegistry.registerComponent(str, new com.taobao.weex.ui.SimpleComponentHolder(cls), map);
    }

    public static void addCustomOptions(java.lang.String str, java.lang.String str2) {
        com.taobao.weex.WXEnvironment.addCustomOptions(str, str2);
    }

    public static com.taobao.weex.adapter.IWXUserTrackAdapter getIWXUserTrackAdapter() {
        return com.taobao.weex.WXSDKManager.getInstance().getIWXUserTrackAdapter();
    }

    public static com.taobao.weex.adapter.IWXImgLoaderAdapter getIWXImgLoaderAdapter() {
        return com.taobao.weex.WXSDKManager.getInstance().getIWXImgLoaderAdapter();
    }

    public static com.taobao.weex.adapter.IDrawableLoader getDrawableLoader() {
        return com.taobao.weex.WXSDKManager.getInstance().getDrawableLoader();
    }

    public static com.taobao.weex.adapter.IWXHttpAdapter getIWXHttpAdapter() {
        return com.taobao.weex.WXSDKManager.getInstance().getIWXHttpAdapter();
    }

    public static com.taobao.weex.appfram.storage.IWXStorageAdapter getIWXStorageAdapter() {
        return com.taobao.weex.WXSDKManager.getInstance().getIWXStorageAdapter();
    }

    public static com.taobao.weex.adapter.IWXJsFileLoaderAdapter getIWXJsFileLoaderAdapter() {
        return com.taobao.weex.WXSDKManager.getInstance().getIWXJsFileLoaderAdapter();
    }

    public static com.taobao.weex.appfram.navigator.IActivityNavBarSetter getActivityNavBarSetter() {
        return com.taobao.weex.WXSDKManager.getInstance().getActivityNavBarSetter();
    }

    public static com.taobao.weex.appfram.navigator.INavigator getNavigator() {
        return com.taobao.weex.WXSDKManager.getInstance().getNavigator();
    }

    public static void setNavigator(com.taobao.weex.appfram.navigator.INavigator iNavigator) {
        com.taobao.weex.WXSDKManager.getInstance().setNavigator(iNavigator);
    }

    public static void setActivityNavBarSetter(com.taobao.weex.appfram.navigator.IActivityNavBarSetter iActivityNavBarSetter) {
        com.taobao.weex.WXSDKManager.getInstance().setActivityNavBarSetter(iActivityNavBarSetter);
    }

    public static void reload(final android.content.Context context, java.lang.String str, boolean z) {
        com.taobao.weex.WXEnvironment.sRemoteDebugMode = z;
        com.taobao.weex.bridge.WXBridgeManager.getInstance().restart();
        com.taobao.weex.bridge.WXBridgeManager.getInstance().initScriptsFramework(str);
        com.taobao.weex.bridge.WXServiceManager.reload();
        com.taobao.weex.bridge.WXModuleManager.reload();
        com.taobao.weex.ui.WXComponentRegistry.reload();
        com.taobao.weex.WXSDKManager.getInstance().postOnUiThread(new java.lang.Runnable() { // from class: com.taobao.weex.WXSDKEngine.2
            @Override // java.lang.Runnable
            public void run() {
                androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(context).sendBroadcast(new android.content.Intent(com.taobao.weex.WXSDKEngine.JS_FRAMEWORK_RELOAD));
            }
        }, 0L);
    }

    public static void reload(android.content.Context context, boolean z) {
        reload(context, null, z);
    }

    public static void reload() {
        reload(com.taobao.weex.WXEnvironment.getApplication(), com.taobao.weex.WXEnvironment.sRemoteDebugMode);
    }

    public static void restartWeex() {
        com.taobao.weex.WXEnvironment.sRemoteDebugMode = com.taobao.weex.WXEnvironment.sRemoteDebugMode;
        com.taobao.weex.bridge.WXBridgeManager.getInstance().restart();
        com.taobao.weex.bridge.WXBridgeManager.getInstance().initScriptsFramework(null);
        com.taobao.weex.bridge.WXServiceManager.reload();
        com.taobao.weex.bridge.WXModuleManager.reload();
        com.taobao.weex.ui.WXComponentRegistry.reload();
    }

    public static void registerCoreEnv(java.lang.String str, java.lang.String str2) {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().registerCoreEnv(str, str2);
    }
}
