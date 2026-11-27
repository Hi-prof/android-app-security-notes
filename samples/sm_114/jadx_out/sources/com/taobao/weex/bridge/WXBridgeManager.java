package com.taobao.weex.bridge;

/* JADX INFO: loaded from: classes.dex */
public class WXBridgeManager implements android.os.Handler.Callback, com.taobao.weex.utils.batch.BactchExecutor {
    public static final java.lang.String ARGS = "args";
    private static final boolean BRIDGE_LOG_SWITCH = false;
    private static final java.lang.String BUNDLE_TYPE = "bundleType";
    public static final java.lang.String COMPONENT = "component";
    private static final int CRASHREINIT = 50;
    private static java.lang.String GLOBAL_CONFIG_KEY = "global_switch_config";
    public static final java.lang.String INITLOGFILE = "/jsserver_start.log";
    private static final int INIT_FRAMEWORK_OK = 1;
    public static final java.lang.String KEY_ARGS = "args";
    public static final java.lang.String KEY_METHOD = "method";
    public static final java.lang.String KEY_PARAMS = "params";
    private static long LOW_MEM_VALUE = 120;
    public static final java.lang.String METHD_COMPONENT_HOOK_SYNC = "componentHook";
    public static final java.lang.String METHD_FIRE_EVENT_SYNC = "fireEventSync";
    public static final java.lang.String METHOD = "method";
    public static final java.lang.String METHOD_CALLBACK = "callback";
    public static final java.lang.String METHOD_CALL_JS = "callJS";
    public static final java.lang.String METHOD_CHECK_APPKEY = "dc_checkappkey";
    public static final java.lang.String METHOD_CREATE_INSTANCE = "createInstance";
    public static final java.lang.String METHOD_CREATE_INSTANCE_CONTEXT = "createInstanceContext";
    public static final java.lang.String METHOD_CREATE_PAGE_WITH_CONTENT = "CreatePageWithContent";
    public static final java.lang.String METHOD_DESTROY_INSTANCE = "destroyInstance";
    public static final java.lang.String METHOD_FIRE_EVENT = "fireEvent";
    public static final java.lang.String METHOD_FIRE_EVENT_ON_DATA_RENDER_NODE = "fireEventOnDataRenderNode";
    private static final java.lang.String METHOD_JSFM_NOT_INIT_IN_EAGLE_MODE = "JsfmNotInitInEagleMode";
    public static final java.lang.String METHOD_NOTIFY_SERIALIZE_CODE_CACHE = "notifySerializeCodeCache";
    public static final java.lang.String METHOD_NOTIFY_TRIM_MEMORY = "notifyTrimMemory";
    private static final java.lang.String METHOD_POST_TASK_TO_MSG_LOOP = "PostTaskToMsgLoop";
    public static final java.lang.String METHOD_REFRESH_INSTANCE = "refreshInstance";
    public static final java.lang.String METHOD_REGISTER_COMPONENTS = "registerComponents";
    public static final java.lang.String METHOD_REGISTER_MODULES = "registerModules";
    public static final java.lang.String METHOD_SET_TIMEOUT = "setTimeoutCallback";
    public static final java.lang.String METHOD_UPDATE_COMPONENT_WITH_DATA = "UpdateComponentData";
    public static final java.lang.String MODULE = "module";
    private static final java.lang.String NON_CALLBACK = "-1";
    public static final java.lang.String OPTIONS = "options";
    public static final java.lang.String REF = "ref";
    private static final java.lang.String RENDER_STRATEGY = "renderStrategy";
    private static final java.lang.String UNDEFINED = "undefined";
    private static java.lang.Class clazz_debugProxy = null;
    private static java.lang.String crashUrl = null;
    private static java.lang.String globalConfig = "none";
    private static volatile boolean isJsEngineMultiThreadEnable = false;
    private static volatile boolean isSandBoxContext = true;
    private static boolean isUseSingleProcess = false;
    private static long lastCrashTime = 0;
    static volatile com.taobao.weex.bridge.WXBridgeManager mBridgeManager = null;
    private static volatile boolean mInit = false;
    private static java.lang.String mRaxApi = null;
    public static volatile int reInitCount = 1;
    public static long sInitFrameWorkTimeOrigin;
    private com.taobao.weex.bridge.WXParams mInitParams;
    private com.taobao.weex.utils.batch.Interceptor mInterceptor;
    android.os.Handler mJSHandler;
    private com.taobao.weex.common.WXThread mJSThread;
    private com.taobao.weex.common.IWXBridge mWXBridge;
    private java.lang.Object mWxDebugProxy;
    private static java.util.Map<java.lang.String, java.lang.String> mWeexCoreEnvOptions = new java.util.HashMap();
    public static java.lang.StringBuilder sInitFrameWorkMsg = new java.lang.StringBuilder();
    private com.taobao.weex.bridge.WXHashMap<java.lang.String, java.util.ArrayList<com.taobao.weex.bridge.WXHashMap<java.lang.String, java.lang.Object>>> mNextTickTasks = new com.taobao.weex.bridge.WXHashMap<>();
    private boolean mMock = false;
    private java.util.List<java.util.Map<java.lang.String, java.lang.Object>> mRegisterComponentFailList = new java.util.ArrayList(8);
    private java.util.List<java.util.Map<java.lang.String, java.lang.Object>> mRegisterModuleFailList = new java.util.ArrayList(8);
    private java.util.List<java.lang.String> mRegisterServiceFailList = new java.util.ArrayList(8);
    private java.util.HashSet<java.lang.String> mDestroyedInstanceId = new java.util.HashSet<>();
    private java.lang.StringBuilder mLodBuilder = new java.lang.StringBuilder(50);

    public enum BundType {
        Vue,
        Rax,
        Others
    }

    public static class TimerInfo {
        public java.lang.String callbackId;
        public java.lang.String instanceId;
        public long time;
    }

    private void mock(java.lang.String str) {
    }

    @java.lang.Deprecated
    public void notifyTrimMemory() {
    }

    private WXBridgeManager() {
        initWXBridge(com.taobao.weex.WXEnvironment.sRemoteDebugMode);
        com.taobao.weex.common.WXThread wXThread = new com.taobao.weex.common.WXThread("WeexJSBridgeThread", this);
        this.mJSThread = wXThread;
        this.mJSHandler = wXThread.getHandler();
    }

    public static com.taobao.weex.bridge.WXBridgeManager getInstance() {
        if (mBridgeManager == null) {
            synchronized (com.taobao.weex.bridge.WXBridgeManager.class) {
                if (mBridgeManager == null) {
                    mBridgeManager = new com.taobao.weex.bridge.WXBridgeManager();
                }
            }
        }
        return mBridgeManager;
    }

    public void setUseSingleProcess(boolean z) {
        if (z != isUseSingleProcess) {
            isUseSingleProcess = z;
        }
    }

    public void onInteractionTimeUpdate(final java.lang.String str) {
        post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.taobao.weex.bridge.WXBridgeManager.this.mWXBridge instanceof com.taobao.weex.bridge.WXBridge) {
                    ((com.taobao.weex.bridge.WXBridge) com.taobao.weex.bridge.WXBridgeManager.this.mWXBridge).nativeOnInteractionTimeUpdate(str);
                }
            }
        });
    }

    public boolean jsEngineMultiThreadEnable() {
        return isJsEngineMultiThreadEnable;
    }

    public void checkJsEngineMultiThread() {
        com.taobao.weex.adapter.IWXJscProcessManager wXJscProcessManager = com.taobao.weex.WXSDKManager.getInstance().getWXJscProcessManager();
        boolean zEnableBackupThread = wXJscProcessManager != null ? wXJscProcessManager.enableBackupThread() : false;
        if (zEnableBackupThread == isJsEngineMultiThreadEnable) {
            return;
        }
        isJsEngineMultiThreadEnable = zEnableBackupThread;
        if (isJSFrameworkInit()) {
            if (isJSThread()) {
                com.taobao.weex.WXSDKEngine.reload();
            } else {
                post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.taobao.weex.WXSDKEngine.reload();
                    }
                });
            }
        }
    }

    public void setSandBoxContext(boolean z) {
        java.lang.String strLoadAsset;
        if (z != isSandBoxContext) {
            isSandBoxContext = z;
            if (isJSThread()) {
                setJSFrameworkInit(false);
                com.taobao.weex.bridge.WXModuleManager.resetAllModuleState();
                if (!isSandBoxContext) {
                    strLoadAsset = com.taobao.weex.utils.WXFileUtils.loadAsset("main.js", com.taobao.weex.WXEnvironment.getApplication());
                } else {
                    strLoadAsset = com.taobao.weex.utils.WXFileUtils.loadAsset("weex-main-jsfm.js", com.taobao.weex.WXEnvironment.getApplication());
                }
                initFramework(strLoadAsset);
                com.taobao.weex.bridge.WXServiceManager.reload();
                com.taobao.weex.bridge.WXModuleManager.reload();
                com.taobao.weex.ui.WXComponentRegistry.reload();
                return;
            }
            post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.3
                @Override // java.lang.Runnable
                public void run() {
                    java.lang.String strLoadAsset2;
                    com.taobao.weex.bridge.WXBridgeManager.this.setJSFrameworkInit(false);
                    com.taobao.weex.bridge.WXModuleManager.resetAllModuleState();
                    if (!com.taobao.weex.bridge.WXBridgeManager.isSandBoxContext) {
                        strLoadAsset2 = com.taobao.weex.utils.WXFileUtils.loadAsset("main.js", com.taobao.weex.WXEnvironment.getApplication());
                    } else {
                        strLoadAsset2 = com.taobao.weex.utils.WXFileUtils.loadAsset("weex-main-jsfm.js", com.taobao.weex.WXEnvironment.getApplication());
                    }
                    com.taobao.weex.bridge.WXBridgeManager.this.initFramework(strLoadAsset2);
                    com.taobao.weex.bridge.WXServiceManager.reload();
                    com.taobao.weex.bridge.WXModuleManager.reload();
                    com.taobao.weex.ui.WXComponentRegistry.reload();
                }
            });
        }
    }

    public boolean isJSFrameworkInit() {
        return mInit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJSFrameworkInit(boolean z) {
        mInit = z;
        if (z) {
            onJsFrameWorkInitSuccees();
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0047 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:11:0x001b, B:13:0x001f, B:14:0x0025, B:16:0x0029, B:18:0x002e, B:20:0x0036, B:24:0x0047, B:26:0x005a, B:28:0x0071, B:30:0x007b), top: B:49:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:26:0x005a A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:11:0x001b, B:13:0x001f, B:14:0x0025, B:16:0x0029, B:18:0x002e, B:20:0x0036, B:24:0x0047, B:26:0x005a, B:28:0x0071, B:30:0x007b), top: B:49:0x001b }] */
    private void initWXBridge(boolean z) {
        java.lang.reflect.Method method;
        java.lang.reflect.Constructor constructor;
        java.lang.Object objNewInstance;
        java.lang.reflect.Method method2;
        if (z && com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.WXEnvironment.sDebugServerConnectable = true;
        }
        if (com.taobao.weex.WXEnvironment.sDebugServerConnectable) {
            com.taobao.weex.WXEnvironment.isApkDebugable();
            if (com.taobao.weex.WXEnvironment.getApplication() != null) {
                try {
                    if (clazz_debugProxy == null) {
                        clazz_debugProxy = java.lang.Class.forName("com.taobao.weex.devtools.debug.DebugServerProxy");
                    }
                    java.lang.Class cls = clazz_debugProxy;
                    if (cls != null) {
                        if (this.mWxDebugProxy != null) {
                            java.lang.reflect.Method method3 = cls.getMethod("isActive", null);
                            if (!(method3 != null ? ((java.lang.Boolean) method3.invoke(this.mWxDebugProxy, null)).booleanValue() : false)) {
                                constructor = clazz_debugProxy.getConstructor(android.content.Context.class, com.taobao.weex.common.IWXDebugConfig.class);
                                if (constructor != null) {
                                    objNewInstance = constructor.newInstance(com.taobao.weex.WXEnvironment.getApplication(), new com.taobao.weex.common.IWXDebugConfig() { // from class: com.taobao.weex.bridge.WXBridgeManager.4
                                        @Override // com.taobao.weex.common.IWXDebugConfig
                                        public com.taobao.weex.bridge.WXBridgeManager getWXJSManager() {
                                            return com.taobao.weex.bridge.WXBridgeManager.this;
                                        }

                                        @Override // com.taobao.weex.common.IWXDebugConfig
                                        public com.taobao.weex.bridge.WXDebugJsBridge getWXDebugJsBridge() {
                                            return new com.taobao.weex.bridge.WXDebugJsBridge();
                                        }
                                    });
                                    this.mWxDebugProxy = objNewInstance;
                                    if (objNewInstance != null) {
                                        method2.invoke(this.mWxDebugProxy, null);
                                    }
                                }
                            }
                        } else {
                            constructor = clazz_debugProxy.getConstructor(android.content.Context.class, com.taobao.weex.common.IWXDebugConfig.class);
                            if (constructor != null) {
                                objNewInstance = constructor.newInstance(com.taobao.weex.WXEnvironment.getApplication(), new com.taobao.weex.common.IWXDebugConfig() { // from class: com.taobao.weex.bridge.WXBridgeManager.4
                                    @Override // com.taobao.weex.common.IWXDebugConfig
                                    public com.taobao.weex.bridge.WXBridgeManager getWXJSManager() {
                                        return com.taobao.weex.bridge.WXBridgeManager.this;
                                    }

                                    @Override // com.taobao.weex.common.IWXDebugConfig
                                    public com.taobao.weex.bridge.WXDebugJsBridge getWXDebugJsBridge() {
                                        return new com.taobao.weex.bridge.WXDebugJsBridge();
                                    }
                                });
                                this.mWxDebugProxy = objNewInstance;
                                if (objNewInstance != null && (method2 = clazz_debugProxy.getMethod("start", null)) != null) {
                                    method2.invoke(this.mWxDebugProxy, null);
                                }
                            }
                        }
                    }
                } catch (java.lang.Throwable unused) {
                }
                com.taobao.weex.bridge.WXServiceManager.execAllCacheJsService();
            } else {
                com.taobao.weex.utils.WXLogUtils.e("WXBridgeManager", "WXEnvironment.sApplication is null, skip init Inspector");
            }
        }
        if (z && this.mWxDebugProxy != null) {
            try {
                if (clazz_debugProxy == null) {
                    clazz_debugProxy = java.lang.Class.forName("com.taobao.weex.devtools.debug.DebugServerProxy");
                }
                java.lang.Class cls2 = clazz_debugProxy;
                if (cls2 == null || (method = cls2.getMethod("getWXBridge", null)) == null) {
                    return;
                }
                this.mWXBridge = (com.taobao.weex.common.IWXBridge) method.invoke(this.mWxDebugProxy, null);
                return;
            } catch (java.lang.Throwable unused2) {
                return;
            }
        }
        this.mWXBridge = new com.taobao.weex.bridge.WXBridge();
    }

    public java.lang.String dumpIpcPageInfo() {
        com.taobao.weex.common.IWXBridge iWXBridge = this.mWXBridge;
        if (iWXBridge instanceof com.taobao.weex.bridge.WXBridge) {
            return ((com.taobao.weex.bridge.WXBridge) iWXBridge).nativeDumpIpcPageQueueInfo();
        }
        return "";
    }

    public void stopRemoteDebug() {
        java.lang.reflect.Method method;
        if (this.mWxDebugProxy != null) {
            try {
                if (clazz_debugProxy == null) {
                    clazz_debugProxy = java.lang.Class.forName("com.taobao.weex.devtools.debug.DebugServerProxy");
                }
                java.lang.Class cls = clazz_debugProxy;
                if (cls == null || (method = cls.getMethod(com.taobao.weex.common.Constants.Value.STOP, java.lang.Boolean.TYPE)) == null) {
                    return;
                }
                method.invoke(this.mWxDebugProxy, false);
                this.mWxDebugProxy = null;
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public java.lang.Object callModuleMethod(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.fastjson.JSONArray jSONArray) {
        return callModuleMethod(str, str2, str3, jSONArray, null);
    }

    public java.lang.Object callModuleMethod(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.fastjson.JSONArray jSONArray, com.alibaba.fastjson.JSONObject jSONObject) {
        com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
        if (sDKInstance == null) {
            return null;
        }
        if (sDKInstance.isNeedValidate() && com.taobao.weex.WXSDKManager.getInstance().getValidateProcessor() != null) {
            com.taobao.weex.bridge.WXValidateProcessor.WXModuleValidateResult wXModuleValidateResultOnModuleValidate = com.taobao.weex.WXSDKManager.getInstance().getValidateProcessor().onModuleValidate(sDKInstance, str2, str3, jSONArray, jSONObject);
            if (wXModuleValidateResultOnModuleValidate == null) {
                return null;
            }
            if (wXModuleValidateResultOnModuleValidate.isSuccess) {
                return com.taobao.weex.bridge.WXModuleManager.callModuleMethod(str, str2, str3, jSONArray);
            }
            com.alibaba.fastjson.JSONObject jSONObject2 = wXModuleValidateResultOnModuleValidate.validateInfo;
            if (jSONObject2 != null) {
                com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] module validate fail. >>> " + jSONObject2.toJSONString());
            }
            return jSONObject2;
        }
        try {
            return com.taobao.weex.bridge.WXModuleManager.callModuleMethod(str, str2, str3, jSONArray);
        } catch (java.lang.NumberFormatException unused) {
            androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap();
            arrayMap.put("moduleName", str2);
            arrayMap.put("methodName", str3);
            arrayMap.put("args", jSONArray.toJSONString());
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callNative : numberFormatException when parsing string to numbers in args", arrayMap.toString());
            return null;
        }
    }

    public void restart() {
        setJSFrameworkInit(false);
        com.taobao.weex.bridge.WXModuleManager.resetAllModuleState();
        initWXBridge(com.taobao.weex.WXEnvironment.sRemoteDebugMode);
        this.mWXBridge.resetWXBridge(com.taobao.weex.WXEnvironment.sRemoteDebugMode);
    }

    public synchronized void setStackTopInstance(final java.lang.String str) {
        post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.5
            @Override // java.lang.Runnable
            public void run() {
                com.taobao.weex.bridge.WXBridgeManager.this.mNextTickTasks.setStackTopInstance(str);
            }
        }, str, null, null);
    }

    @Override // com.taobao.weex.utils.batch.BactchExecutor
    public void post(java.lang.Runnable runnable) {
        postWithName(runnable, null, null);
    }

    public void postWithName(java.lang.Runnable runnable, com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str) {
        android.os.Handler handler;
        java.lang.Runnable runnableSecure = com.taobao.weex.common.WXThread.secure(runnable, wXSDKInstance, str);
        com.taobao.weex.utils.batch.Interceptor interceptor = this.mInterceptor;
        if ((interceptor == null || !interceptor.take(runnableSecure)) && (handler = this.mJSHandler) != null) {
            handler.post(runnableSecure);
        }
    }

    @Override // com.taobao.weex.utils.batch.BactchExecutor
    public void setInterceptor(com.taobao.weex.utils.batch.Interceptor interceptor) {
        this.mInterceptor = interceptor;
    }

    public void post(java.lang.Runnable runnable, java.lang.Object obj, com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str) {
        android.os.Handler handler = this.mJSHandler;
        if (handler == null) {
            return;
        }
        android.os.Message messageObtain = android.os.Message.obtain(handler, com.taobao.weex.common.WXThread.secure(runnable, wXSDKInstance, str));
        messageObtain.obj = obj;
        messageObtain.sendToTarget();
    }

    public void post(java.lang.Runnable runnable, java.lang.Object obj) {
        post(runnable, obj, null, null);
    }

    public void postDelay(java.lang.Runnable runnable, long j) {
        android.os.Handler handler = this.mJSHandler;
        if (handler == null) {
            return;
        }
        handler.postDelayed(com.taobao.weex.common.WXThread.secure(runnable), j);
    }

    public void setLogLevel(final int i, final boolean z) {
        post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.6
            @Override // java.lang.Runnable
            public void run() {
                if (com.taobao.weex.bridge.WXBridgeManager.this.mWXBridge != null) {
                    com.taobao.weex.bridge.WXBridgeManager.this.mWXBridge.setLogType(i, z);
                }
            }
        });
    }

    void setTimeout(java.lang.String str, java.lang.String str2) {
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 1;
        com.taobao.weex.bridge.WXBridgeManager.TimerInfo timerInfo = new com.taobao.weex.bridge.WXBridgeManager.TimerInfo();
        timerInfo.callbackId = str;
        timerInfo.time = (long) java.lang.Float.parseFloat(str2);
        messageObtain.obj = timerInfo;
        this.mJSHandler.sendMessageDelayed(messageObtain, timerInfo.time);
    }

    public void sendMessageDelayed(android.os.Message message, long j) {
        com.taobao.weex.common.WXThread wXThread;
        if (message == null || this.mJSHandler == null || (wXThread = this.mJSThread) == null || !wXThread.isWXThreadAlive() || this.mJSThread.getLooper() == null) {
            return;
        }
        this.mJSHandler.sendMessageDelayed(message, j);
    }

    public void removeMessage(int i, java.lang.Object obj) {
        com.taobao.weex.common.WXThread wXThread;
        if (this.mJSHandler == null || (wXThread = this.mJSThread) == null || !wXThread.isWXThreadAlive() || this.mJSThread.getLooper() == null) {
            return;
        }
        this.mJSHandler.removeMessages(i, obj);
    }

    public java.lang.Object callNativeModule(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.fastjson.JSONArray jSONArray, java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callNativeModule arguments is null");
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callNativeModule", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        try {
            if (com.taobao.weex.ui.module.WXDomModule.WXDOM.equals(str2)) {
                return com.taobao.weex.bridge.WXModuleManager.getDomModule(str).callDomMethod(str3, jSONArray, new long[0]);
            }
            return callModuleMethod(str, str2, str3, jSONArray);
        } catch (java.lang.Exception e) {
            java.lang.String str4 = "[WXBridgeManager] callNative exception: " + com.taobao.weex.utils.WXLogUtils.getStackTrace(e);
            com.taobao.weex.utils.WXLogUtils.e(str4);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callNativeModule", str4, null);
            return null;
        }
    }

    public java.lang.Object callNativeModule(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.fastjson.JSONArray jSONArray, com.alibaba.fastjson.JSONObject jSONObject) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callNativeModule arguments is null");
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callNativeModule", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.performance.WXStateRecord.getInstance().recordAction(str, "callNativeModule:" + str2 + com.taobao.weex.el.parse.Operators.DOT_STR + str3);
        com.taobao.weex.WXEnvironment.isApkDebugable();
        try {
            if (com.taobao.weex.ui.module.WXDomModule.WXDOM.equals(str2)) {
                com.taobao.weex.ui.module.WXDomModule domModule = com.taobao.weex.bridge.WXModuleManager.getDomModule(str);
                if (domModule != null) {
                    return domModule.callDomMethod(str3, jSONArray, new long[0]);
                }
                com.taobao.weex.bridge.WXModuleManager.createDomModule(com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str));
                return null;
            }
            return callModuleMethod(str, str2, str3, jSONArray, jSONObject);
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callNativeModule exception: " + com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
        }
    }

    public java.lang.Object callNativeComponent(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.fastjson.JSONArray jSONArray, java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callNativeComponent arguments is null");
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callNativeComponent", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        try {
            com.taobao.weex.ui.module.WXDomModule domModule = com.taobao.weex.bridge.WXModuleManager.getDomModule(str);
            if (domModule != null) {
                domModule.invokeMethod(str2, str3, jSONArray);
            } else {
                com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
                if (sDKInstance == null || !sDKInstance.isDestroy()) {
                    com.taobao.weex.utils.WXLogUtils.e("WXBridgeManager", "callNativeComponent exception :null == dom ,method:" + str3);
                }
            }
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callNativeComponent exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callNativeComponent", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
        }
        return null;
    }

    public int callNative(java.lang.String str, com.alibaba.fastjson.JSONArray jSONArray, java.lang.String str2) {
        int i;
        if (android.text.TextUtils.isEmpty(str) || jSONArray == null) {
            com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callNative arguments is null");
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callNative", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        long jNanoTime = java.lang.System.nanoTime() - java.lang.System.nanoTime();
        if (jSONArray == null || jSONArray.size() <= 0) {
            i = 0;
        } else {
            int size = jSONArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.JSONObject) jSONArray.get(i2);
                    if (jSONObject != null && com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str) != null) {
                        java.lang.Object obj = jSONObject.get("module");
                        if (obj != null) {
                            i = 0;
                            try {
                                if (com.taobao.weex.ui.module.WXDomModule.WXDOM.equals(obj)) {
                                    com.taobao.weex.bridge.WXModuleManager.getDomModule(str).callDomMethod(jSONObject, jNanoTime);
                                } else {
                                    callModuleMethod(str, (java.lang.String) obj, (java.lang.String) jSONObject.get("method"), (com.alibaba.fastjson.JSONArray) jSONObject.get("args"), jSONObject.getJSONObject("options"));
                                }
                            } catch (java.lang.Exception e) {
                                e = e;
                                com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callNative exception: ", e);
                                com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callNative", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
                                if ("undefined".equals(str2)) {
                                }
                                return i;
                            }
                        } else {
                            i = 0;
                            if (jSONObject.get(COMPONENT) != null) {
                                com.taobao.weex.bridge.WXModuleManager.getDomModule(str).invokeMethod((java.lang.String) jSONObject.get("ref"), (java.lang.String) jSONObject.get("method"), (com.alibaba.fastjson.JSONArray) jSONObject.get("args"));
                            } else {
                                throw new java.lang.IllegalArgumentException("unknown callNative");
                            }
                        }
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    i = 0;
                }
            }
            i = 0;
        }
        if (!"undefined".equals(str2) || NON_CALLBACK.equals(str2)) {
            return i;
        }
        getNextTick(str, str2);
        return 1;
    }

    public int callUpdateFinish(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callUpdateFinish arguments is null");
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callUpdateFinish", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callUpdateFinish exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callUpdateFinish", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
        }
        if (str2 == null || str2.isEmpty() || "undefined".equals(str2) || NON_CALLBACK.equals(str2)) {
            return 0;
        }
        getNextTick(str, str2);
        return 1;
    }

    public int callRefreshFinish(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callRefreshFinish arguments is null");
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callRefreshFinish", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance != null) {
                com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(str, new com.taobao.weex.ui.action.GraphicActionRefreshFinish(sDKInstance));
            }
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callRefreshFinish exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callRefreshFinish", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
        }
        if ("undefined".equals(str2) || NON_CALLBACK.equals(str2)) {
            return 0;
        }
        getNextTick(str, str2);
        return 1;
    }

    public int callReportCrashReloadPage(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String string;
        boolean zIsEmpty = android.text.TextUtils.isEmpty(str2);
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance != null) {
                java.lang.String bundleUrl = sDKInstance.getBundleUrl();
                sDKInstance.setHasException(true);
                str3 = bundleUrl;
            } else {
                str3 = null;
            }
            java.util.HashMap map = new java.util.HashMap(2);
            map.put("weexCoreThreadStackTrace:", getInstance().getWeexCoreThreadStackTrace());
            map.put("wxStateInfo", com.taobao.weex.performance.WXStateRecord.getInstance().getStateInfo().toString());
            java.lang.String str5 = "null";
            if (zIsEmpty) {
                com.taobao.weex.performance.WXStateRecord wXStateRecord = com.taobao.weex.performance.WXStateRecord.getInstance();
                if (!android.text.TextUtils.isEmpty(str)) {
                    str5 = str;
                }
                wXStateRecord.onJSEngineReload(str5);
                commitJscCrashAlarmMonitor(com.taobao.weex.adapter.IWXUserTrackAdapter.JS_BRIDGE, com.taobao.weex.common.WXErrorCode.WX_ERR_RELOAD_PAGE, "reboot jsc Engine", str, str3, map);
            } else {
                try {
                    if (com.taobao.weex.WXEnvironment.getApplication() != null) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(this.mInitParams.getCrashFilePath());
                        str4 = str2;
                        try {
                            sb.append(str4);
                            string = sb.toString();
                            try {
                                android.util.Log.d("jsengine", "callReportCrashReloadPage crashFile:" + string);
                            } catch (java.lang.Throwable th) {
                                th = th;
                                str4 = string;
                                com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
                                string = str4;
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                        }
                    } else {
                        str4 = str2;
                        string = str4;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    str4 = str2;
                }
                com.taobao.weex.performance.WXStateRecord wXStateRecord2 = com.taobao.weex.performance.WXStateRecord.getInstance();
                if (!android.text.TextUtils.isEmpty(str)) {
                    str5 = str;
                }
                wXStateRecord2.onJSCCrash(str5);
                callReportCrash(string, str, str3, map);
            }
            if (reInitCount > 50) {
                com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT("jsEngine", com.taobao.weex.common.WXErrorCode.WX_ERR_RELOAD_PAGE_EXCEED_LIMIT, "callReportCrashReloadPage", "reInitCount:" + reInitCount, map);
                return 0;
            }
            reInitCount++;
            setJSFrameworkInit(false);
            com.taobao.weex.bridge.WXModuleManager.resetAllModuleState();
            initScriptsFramework("");
            java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
            if (hashSet != null && hashSet.contains(str)) {
                return -1;
            }
            try {
                if (com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str) != null) {
                    new com.taobao.weex.ui.action.ActionReloadPage(str, shouldReloadCurrentInstance(com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str).getBundleUrl())).executeAction();
                }
            } catch (java.lang.Exception e) {
                com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callReloadPage exception: ", e);
                com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callReportCrashReloadPage", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
            }
            return 0;
        } catch (java.lang.Exception e2) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callReportCrashReloadPage exception: ", e2);
        }
    }

    public boolean shouldReloadCurrentInstance(java.lang.String str) {
        android.net.Uri uri;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.taobao.weex.adapter.IWXConfigAdapter wxConfigAdapter = com.taobao.weex.WXSDKManager.getInstance().getWxConfigAdapter();
        if (wxConfigAdapter != null) {
            boolean z = java.lang.Boolean.parseBoolean(wxConfigAdapter.getConfig("android_weex_ext_config", "check_biz_url", io.dcloud.common.constant.AbsoluteConst.TRUE));
            com.taobao.weex.utils.WXLogUtils.e("check_biz_url : " + z);
            if (z && !android.text.TextUtils.isEmpty(str) && (uri = android.net.Uri.parse(str)) != null) {
                str = uri.buildUpon().clearQuery().build().toString();
            }
        }
        java.lang.String str2 = crashUrl;
        if (str2 == null || ((str2 != null && !str2.equals(str)) || jCurrentTimeMillis - lastCrashTime > 15000)) {
            crashUrl = str;
            lastCrashTime = jCurrentTimeMillis;
            return true;
        }
        lastCrashTime = jCurrentTimeMillis;
        return false;
    }

    public void callReportCrash(java.lang.String str, final java.lang.String str2, final java.lang.String str3, final java.util.Map<java.lang.String, java.lang.String> map) {
        final java.lang.String str4 = str + com.taobao.weex.el.parse.Operators.DOT_STR + new java.text.SimpleDateFormat("yyyyMMddHHmmss", java.util.Locale.US).format(new java.util.Date());
        java.io.File file = new java.io.File(str);
        java.io.File file2 = new java.io.File(str4);
        if (file.exists()) {
            file.renameTo(file2);
        }
        new java.lang.Thread(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    java.io.File file3 = new java.io.File(str4);
                    if (file3.exists()) {
                        if (file3.length() > 0) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            try {
                                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader(str4));
                                while (true) {
                                    java.lang.String line = bufferedReader.readLine();
                                    if (line == null) {
                                        break;
                                    }
                                    if (!"".equals(line)) {
                                        sb.append(line + "\n");
                                    }
                                }
                                com.taobao.weex.bridge.WXBridgeManager.this.commitJscCrashAlarmMonitor(com.taobao.weex.adapter.IWXUserTrackAdapter.JS_BRIDGE, com.taobao.weex.common.WXErrorCode.WX_ERR_JSC_CRASH, sb.toString(), str2, str3, map);
                                bufferedReader.close();
                            } catch (java.lang.Exception e) {
                                com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
                            }
                        } else {
                            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callReportCrash crash file is empty");
                        }
                        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                            return;
                        }
                        file3.delete();
                    }
                } catch (java.lang.Throwable th) {
                    com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callReportCrash exception: ", th);
                }
            }
        }).start();
    }

    private void getNextTick(java.lang.String str, java.lang.String str2) {
        addJSTask(METHOD_CALLBACK, str, str2, "{}");
        sendMessage(str, 6);
    }

    private void getNextTick(java.lang.String str) {
        addJSTask(METHOD_CALLBACK, str, "", "{}");
        sendMessage(str, 6);
    }

    public java.lang.String syncExecJsOnInstanceWithResult(java.lang.String str, java.lang.String str2, int i) {
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        com.taobao.weex.bridge.EventResult eventResult = new com.taobao.weex.bridge.EventResult() { // from class: com.taobao.weex.bridge.WXBridgeManager.8
            @Override // com.taobao.weex.bridge.EventResult
            public void onCallback(java.lang.Object obj) {
                super.onCallback(obj);
                countDownLatch.countDown();
            }
        };
        try {
            execJSOnInstance(eventResult, str, str2, i);
            countDownLatch.await(100L, java.util.concurrent.TimeUnit.MILLISECONDS);
            if (eventResult.getResult() == null) {
                return "";
            }
            return eventResult.getResult().toString();
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXLogUtils.e("syncCallExecJsOnInstance", th);
            return "";
        }
    }

    public void loadJsBundleInPreInitMode(final java.lang.String str, final java.lang.String str2) {
        post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.9
            @Override // java.lang.Runnable
            public void run() {
                com.taobao.weex.bridge.WXBridgeManager.this.invokeExecJSOnInstance(str, str2, -1);
                com.taobao.weex.WXSDKInstance wXSDKInstance = com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().get(str);
                if (wXSDKInstance == null || !wXSDKInstance.isPreInitMode()) {
                    return;
                }
                wXSDKInstance.getApmForInstance().onStage(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_END);
                wXSDKInstance.getApmForInstance().onStageWithTime(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_END_EXCUTE_BUNDLE, com.taobao.weex.utils.WXUtils.getFixUnixTime() + 600);
            }
        });
    }

    public com.taobao.weex.bridge.EventResult syncCallJSEventWithResult(java.lang.String str, java.lang.String str2, java.util.List<java.lang.Object> list, java.lang.Object... objArr) {
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        com.taobao.weex.bridge.EventResult eventResult = new com.taobao.weex.bridge.EventResult() { // from class: com.taobao.weex.bridge.WXBridgeManager.10
            @Override // com.taobao.weex.bridge.EventResult
            public void onCallback(java.lang.Object obj) {
                super.onCallback(obj);
                countDownLatch.countDown();
            }
        };
        try {
            asyncCallJSEventWithResult(eventResult, str, str2, list, objArr);
            countDownLatch.await(100L, java.util.concurrent.TimeUnit.MILLISECONDS);
            return eventResult;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("syncCallJSEventWithResult", e);
            return eventResult;
        }
    }

    public void asyncCallJSEventVoidResult(final java.lang.String str, final java.lang.String str2, final java.util.List<java.lang.Object> list, final java.lang.Object... objArr) {
        post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    java.lang.Object[] objArr2 = objArr;
                    if (objArr2 != null && objArr2.length != 0) {
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        for (java.lang.Object obj : objArr) {
                            arrayList.add(obj);
                        }
                        if (list != null) {
                            androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap(4);
                            arrayMap.put("params", list);
                            arrayList.add(arrayMap);
                        }
                        com.taobao.weex.bridge.WXHashMap wXHashMap = new com.taobao.weex.bridge.WXHashMap();
                        wXHashMap.put("method", str);
                        wXHashMap.put("args", arrayList);
                        com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr = {new com.taobao.weex.bridge.WXJSObject(2, str2), com.taobao.weex.utils.WXWsonJSONSwitch.toWsonOrJsonWXJSObject(new java.lang.Object[]{wXHashMap})};
                        com.taobao.weex.bridge.WXBridgeManager.this.invokeExecJS(java.lang.String.valueOf(str2), null, com.taobao.weex.bridge.WXBridgeManager.METHOD_CALL_JS, wXJSObjectArr, true);
                        wXJSObjectArr[0] = null;
                    }
                } catch (java.lang.Exception e) {
                    com.taobao.weex.utils.WXLogUtils.e("asyncCallJSEventVoidResult", e);
                }
            }
        });
    }

    private void asyncCallJSEventWithResult(final com.taobao.weex.bridge.EventResult eventResult, final java.lang.String str, final java.lang.String str2, final java.util.List<java.lang.Object> list, final java.lang.Object... objArr) {
        post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    java.lang.Object[] objArr2 = objArr;
                    if (objArr2 != null && objArr2.length != 0) {
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        for (java.lang.Object obj : objArr) {
                            arrayList.add(obj);
                        }
                        if (list != null) {
                            androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap(4);
                            arrayMap.put("params", list);
                            arrayList.add(arrayMap);
                        }
                        com.taobao.weex.bridge.WXHashMap wXHashMap = new com.taobao.weex.bridge.WXHashMap();
                        wXHashMap.put("method", str);
                        wXHashMap.put("args", arrayList);
                        com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr = {new com.taobao.weex.bridge.WXJSObject(2, str2), com.taobao.weex.utils.WXWsonJSONSwitch.toWsonOrJsonWXJSObject(new java.lang.Object[]{wXHashMap})};
                        com.taobao.weex.bridge.WXBridgeManager.this.invokeExecJSWithCallback(java.lang.String.valueOf(str2), null, com.taobao.weex.bridge.WXBridgeManager.METHOD_CALL_JS, wXJSObjectArr, eventResult != null ? new com.taobao.weex.bridge.ResultCallback<byte[]>() { // from class: com.taobao.weex.bridge.WXBridgeManager.12.1
                            @Override // com.taobao.weex.bridge.ResultCallback
                            public void onReceiveResult(byte[] bArr) {
                                com.alibaba.fastjson.JSONArray jSONArray = (com.alibaba.fastjson.JSONArray) com.taobao.weex.utils.WXWsonJSONSwitch.parseWsonOrJSON(bArr);
                                if (jSONArray == null || jSONArray.size() <= 0) {
                                    return;
                                }
                                eventResult.onCallback(jSONArray.get(0));
                            }
                        } : null, true);
                        wXJSObjectArr[0] = null;
                    }
                } catch (java.lang.Exception e) {
                    com.taobao.weex.utils.WXLogUtils.e("asyncCallJSEventWithResult", e);
                }
            }
        });
    }

    private void addJSEventTask(final java.lang.String str, final java.lang.String str2, final java.util.List<java.lang.Object> list, final java.lang.Object... objArr) {
        post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.13
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                java.lang.Object[] objArr2 = objArr;
                if (objArr2 == null || objArr2.length == 0) {
                    return;
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (java.lang.Object obj : objArr) {
                    arrayList.add(obj);
                }
                if (list != null) {
                    androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap(4);
                    arrayMap.put("params", list);
                    arrayList.add(arrayMap);
                }
                com.taobao.weex.bridge.WXHashMap wXHashMap = new com.taobao.weex.bridge.WXHashMap();
                wXHashMap.put("method", str);
                wXHashMap.put("args", arrayList);
                if (com.taobao.weex.bridge.WXBridgeManager.this.mNextTickTasks.get(str2) != 0) {
                    ((java.util.ArrayList) com.taobao.weex.bridge.WXBridgeManager.this.mNextTickTasks.get(str2)).add(wXHashMap);
                    return;
                }
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                arrayList2.add(wXHashMap);
                com.taobao.weex.bridge.WXBridgeManager.this.mNextTickTasks.put(str2, arrayList2);
            }
        });
    }

    private void addJSTask(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        addJSEventTask(str, str2, null, objArr);
    }

    private void sendMessage(java.lang.String str, int i) {
        android.os.Message messageObtain = android.os.Message.obtain(this.mJSHandler);
        messageObtain.obj = str;
        messageObtain.what = i;
        messageObtain.sendToTarget();
    }

    public synchronized void initScriptsFramework(java.lang.String str) {
        android.os.Message messageObtainMessage = this.mJSHandler.obtainMessage();
        messageObtainMessage.obj = str;
        messageObtainMessage.what = 7;
        messageObtainMessage.setTarget(this.mJSHandler);
        messageObtainMessage.sendToTarget();
    }

    @java.lang.Deprecated
    public void fireEvent(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map) {
        fireEvent(str, str2, str3, map, null);
    }

    @java.lang.Deprecated
    public void fireEvent(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        fireEventOnNode(str, str2, str3, map, map2);
    }

    public void fireEventOnNode(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        fireEventOnNode(str, str2, str3, map, map2, null, null);
    }

    public void fireEventOnNode(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, java.util.List<java.lang.Object> list) {
        fireEventOnNode(str, str2, str3, map, map2, list, null);
    }

    public void fireEventOnNode(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, java.util.List<java.lang.Object> list, com.taobao.weex.bridge.EventResult eventResult) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3) || this.mJSHandler == null) {
            return;
        }
        if (!checkMainThread()) {
            throw new com.taobao.weex.common.WXRuntimeException("fireEvent must be called by main thread");
        }
        com.taobao.weex.WXSDKInstance wXSDKInstance = com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().get(str);
        if (wXSDKInstance != null && (wXSDKInstance.getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.DATA_RENDER || wXSDKInstance.getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.DATA_RENDER_BINARY)) {
            fireEventOnDataRenderNode(str, str2, str3, map, map2);
        } else if (eventResult == null) {
            addJSEventTask(METHOD_FIRE_EVENT, str, list, str2, str3, map, map2);
            sendMessage(str, 6);
        } else {
            asyncCallJSEventWithResult(eventResult, METHD_FIRE_EVENT_SYNC, str, list, str2, str3, map, map2);
        }
    }

    private void fireEventOnDataRenderNode(final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final java.util.Map<java.lang.String, java.lang.Object> map, final java.util.Map<java.lang.String, java.lang.Object> map2) {
        this.mJSHandler.postDelayed(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                    if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                        com.taobao.weex.utils.WXLogUtils.d("fireEventOnDataRenderNode >>>> instanceId:" + str + ", data:" + map);
                    }
                    if (com.taobao.weex.bridge.WXBridgeManager.this.mWXBridge instanceof com.taobao.weex.bridge.WXBridge) {
                        com.taobao.weex.bridge.WXBridge wXBridge = (com.taobao.weex.bridge.WXBridge) com.taobao.weex.bridge.WXBridgeManager.this.mWXBridge;
                        java.lang.String str4 = str;
                        java.lang.String str5 = str2;
                        java.lang.String str6 = str3;
                        java.util.Map map3 = map;
                        java.lang.String jSONString = "{}";
                        java.lang.String jSONString2 = (map3 == null || map3.isEmpty()) ? "{}" : com.alibaba.fastjson.JSON.toJSONString(map);
                        java.util.Map map4 = map2;
                        if (map4 != null && !map4.isEmpty()) {
                            jSONString = com.alibaba.fastjson.JSON.toJSONString(map2);
                        }
                        wXBridge.fireEventOnDataRenderNode(str4, str5, str6, jSONString2, jSONString);
                    }
                    com.taobao.weex.utils.WXLogUtils.renderPerformanceLog(com.taobao.weex.bridge.WXBridgeManager.METHOD_FIRE_EVENT_ON_DATA_RENDER_NODE, java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
                } catch (java.lang.Throwable th) {
                    java.lang.String str7 = "[WXBridgeManager] fireEventOnDataRenderNode " + com.taobao.weex.utils.WXLogUtils.getStackTrace(th);
                    com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, com.taobao.weex.bridge.WXBridgeManager.METHOD_FIRE_EVENT_ON_DATA_RENDER_NODE, str7, null);
                    com.taobao.weex.utils.WXLogUtils.e(str7);
                }
            }
        }), 0L);
    }

    private boolean checkMainThread() {
        return android.os.Looper.myLooper() == android.os.Looper.getMainLooper();
    }

    @java.lang.Deprecated
    public void callback(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        callback(str, str2, str3, false);
    }

    @java.lang.Deprecated
    public void callback(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map) {
        callback(str, str2, map, false);
    }

    @java.lang.Deprecated
    public void callback(java.lang.String str, java.lang.String str2, java.lang.Object obj, boolean z) {
        callbackJavascript(str, str2, obj, z);
    }

    void callbackJavascript(java.lang.String str, java.lang.String str2, java.lang.Object obj, boolean z) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || this.mJSHandler == null || !io.dcloud.common.util.RuningAcitvityUtil.isRuningActivity) {
            return;
        }
        com.taobao.weex.WXSDKInstance wXSDKInstance = com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().get(str);
        if (wXSDKInstance != null && wXSDKInstance.getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.DATA_RENDER_BINARY) {
            callbackJavascriptOnDataRender(str, str2, obj, z);
        } else {
            addJSTask(METHOD_CALLBACK, str, str2, obj, java.lang.Boolean.valueOf(z));
            sendMessage(str, 6);
        }
    }

    void callbackJavascriptOnDataRender(final java.lang.String str, final java.lang.String str2, final java.lang.Object obj, final boolean z) {
        this.mJSHandler.postDelayed(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                    java.lang.String jSONString = com.alibaba.fastjson.JSON.toJSONString(obj);
                    if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                        com.taobao.weex.utils.WXLogUtils.d("callbackJavascriptOnDataRender >>>> instanceId:" + str + ", data:" + jSONString);
                    }
                    if (com.taobao.weex.bridge.WXBridgeManager.this.mWXBridge instanceof com.taobao.weex.bridge.WXBridge) {
                        ((com.taobao.weex.bridge.WXBridge) com.taobao.weex.bridge.WXBridgeManager.this.mWXBridge).invokeCallbackOnDataRender(str, str2, jSONString, z);
                    }
                    com.taobao.weex.utils.WXLogUtils.renderPerformanceLog("callbackJavascriptOnDataRender", java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
                } catch (java.lang.Throwable th) {
                    java.lang.String str3 = "[WXBridgeManager] callbackJavascriptOnDataRender " + com.taobao.weex.utils.WXLogUtils.getStackTrace(th);
                    com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callbackJavascriptOnDataRender", str3, null);
                    com.taobao.weex.utils.WXLogUtils.e(str3);
                }
            }
        }), 0L);
    }

    public void refreshInstance(final java.lang.String str, final com.taobao.weex.common.WXRefreshData wXRefreshData) {
        if (android.text.TextUtils.isEmpty(str) || wXRefreshData == null) {
            return;
        }
        this.mJSHandler.postDelayed(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.16
            @Override // java.lang.Runnable
            public void run() {
                com.taobao.weex.bridge.WXBridgeManager.this.invokeRefreshInstance(str, wXRefreshData);
            }
        }), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeRefreshInstance(java.lang.String str, com.taobao.weex.common.WXRefreshData wXRefreshData) {
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (!isSkipFrameworkInit(str) && !isJSFrameworkInit()) {
                if (sDKInstance != null) {
                    sDKInstance.onRenderError(com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorCode(), com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorMsg() + "invokeRefreshInstance FAILED for JSFrameworkInit FAILED, intance will invoke instance.onRenderError");
                }
                com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] invokeRefreshInstance: framework.js uninitialized.");
                return;
            }
            java.lang.System.currentTimeMillis();
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d("refreshInstance >>>> instanceId:" + str + ", data:" + wXRefreshData.data + ", isDirty:" + wXRefreshData.isDirty);
            }
            if (wXRefreshData.isDirty) {
                return;
            }
            this.mWXBridge.refreshInstance(str, null, METHOD_REFRESH_INSTANCE, new com.taobao.weex.bridge.WXJSObject[]{new com.taobao.weex.bridge.WXJSObject(2, str), new com.taobao.weex.bridge.WXJSObject(3, wXRefreshData.data == null ? "{}" : wXRefreshData.data)});
        } catch (java.lang.Throwable th) {
            java.lang.String str2 = "[WXBridgeManager] invokeRefreshInstance " + com.taobao.weex.utils.WXLogUtils.getStackTrace(th);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "invokeRefreshInstance", str2, null);
            com.taobao.weex.utils.WXLogUtils.e(str2);
        }
    }

    public void commitJscCrashAlarmMonitor(java.lang.String str, com.taobao.weex.common.WXErrorCode wXErrorCode, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.util.Map<java.lang.String, java.lang.String> map) {
        if (android.text.TextUtils.isEmpty(str) || wXErrorCode == null) {
            return;
        }
        android.util.Log.d("ReportCrash", " commitJscCrashAlarmMonitor errMsg " + str2);
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put("jscCrashStack", str2);
        if (map != null) {
            map2.putAll(map);
        }
        com.taobao.weex.adapter.IWXJSExceptionAdapter iWXJSExceptionAdapter = com.taobao.weex.WXSDKManager.getInstance().getIWXJSExceptionAdapter();
        if (iWXJSExceptionAdapter != null) {
            com.taobao.weex.common.WXJSExceptionInfo wXJSExceptionInfo = new com.taobao.weex.common.WXJSExceptionInfo(str3, str4, wXErrorCode, "callReportCrash", "weex core process crash and restart exception", map2);
            iWXJSExceptionAdapter.onJSException(wXJSExceptionInfo);
            com.taobao.weex.utils.WXLogUtils.e(wXJSExceptionInfo.toString());
        }
    }

    private boolean isSkipFrameworkInit(java.lang.String str) {
        return isSkipFrameworkInit(com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str));
    }

    private boolean isSkipFrameworkInit(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        if (wXSDKInstance == null) {
            return false;
        }
        return wXSDKInstance.skipFrameworkInit();
    }

    public void createInstance(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str3) {
        createInstance(str, new com.taobao.weex.Script(str2), map, str3);
    }

    public void createInstance(final java.lang.String str, final com.taobao.weex.Script script, final java.util.Map<java.lang.String, java.lang.Object> map, final java.lang.String str2) {
        final com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
        if (sDKInstance == null) {
            com.taobao.weex.utils.WXLogUtils.e("WXBridgeManager", "createInstance failed, SDKInstance does not exist");
            return;
        }
        if (android.text.TextUtils.isEmpty(str) || script == null || script.isEmpty() || this.mJSHandler == null) {
            sDKInstance.onRenderError(com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorCode(), com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorMsg() + " instanceId==" + str + " template ==" + script + " mJSHandler== " + this.mJSHandler.toString());
            return;
        }
        if (!isSkipFrameworkInit(str) && !isJSFrameworkInit() && reInitCount == 1 && !com.taobao.weex.WXEnvironment.sDebugServerConnectable) {
            sDKInstance.onRenderError(com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorCode(), com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorMsg() + " isJSFrameworkInit==" + isJSFrameworkInit() + " reInitCount == 1");
            post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.17
                @Override // java.lang.Runnable
                public void run() {
                    com.taobao.weex.bridge.WXBridgeManager.this.initFramework("");
                }
            }, str, sDKInstance, "initFrameworkInCreateInstance");
            return;
        }
        com.taobao.weex.bridge.WXModuleManager.createDomModule(sDKInstance);
        sDKInstance.getApmForInstance().onStage(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_START);
        post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.18
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                com.taobao.weex.bridge.WXBridgeManager.this.mWXBridge.setPageArgument(str, "renderTimeOrigin", java.lang.String.valueOf(sDKInstance.getWXPerformance().renderTimeOrigin));
                com.taobao.weex.bridge.WXBridgeManager.this.mWXBridge.setInstanceRenderType(sDKInstance.getInstanceId(), sDKInstance.getRenderType());
                com.taobao.weex.bridge.WXBridgeManager.this.invokeCreateInstance(sDKInstance, script, map, str2);
                sDKInstance.getWXPerformance().callCreateInstanceTime = java.lang.System.currentTimeMillis() - jCurrentTimeMillis;
                sDKInstance.getWXPerformance().communicateTime = sDKInstance.getWXPerformance().callCreateInstanceTime;
            }
        }, str, sDKInstance, METHOD_CREATE_INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:113:0x0276 A[Catch: all -> 0x02c0, TRY_LEAVE, TryCatch #0 {all -> 0x02c0, blocks: (B:16:0x004c, B:52:0x00f2, B:54:0x010d, B:56:0x0113, B:58:0x011c, B:63:0x0129, B:67:0x0137, B:71:0x0147, B:73:0x014e, B:76:0x0157, B:86:0x0189, B:88:0x0191, B:95:0x01ca, B:98:0x01f4, B:99:0x0223, B:101:0x0228, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:111:0x025b, B:113:0x0276, B:89:0x019d, B:91:0x01a5, B:92:0x01b7, B:94:0x01bf, B:77:0x015d, B:79:0x0161, B:81:0x0167, B:82:0x016d, B:84:0x0175, B:85:0x0182, B:66:0x0133, B:62:0x0125, B:51:0x00eb, B:22:0x0086, B:17:0x004e, B:19:0x0064), top: B:118:0x004c, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x011b  */
    /* JADX WARN: Code duplicated, block: B:61:0x0123  */
    /* JADX WARN: Code duplicated, block: B:62:0x0125 A[Catch: all -> 0x02c0, TRY_ENTER, TryCatch #0 {all -> 0x02c0, blocks: (B:16:0x004c, B:52:0x00f2, B:54:0x010d, B:56:0x0113, B:58:0x011c, B:63:0x0129, B:67:0x0137, B:71:0x0147, B:73:0x014e, B:76:0x0157, B:86:0x0189, B:88:0x0191, B:95:0x01ca, B:98:0x01f4, B:99:0x0223, B:101:0x0228, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:111:0x025b, B:113:0x0276, B:89:0x019d, B:91:0x01a5, B:92:0x01b7, B:94:0x01bf, B:77:0x015d, B:79:0x0161, B:81:0x0167, B:82:0x016d, B:84:0x0175, B:85:0x0182, B:66:0x0133, B:62:0x0125, B:51:0x00eb, B:22:0x0086, B:17:0x004e, B:19:0x0064), top: B:118:0x004c, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0131  */
    /* JADX WARN: Code duplicated, block: B:66:0x0133 A[Catch: all -> 0x02c0, TryCatch #0 {all -> 0x02c0, blocks: (B:16:0x004c, B:52:0x00f2, B:54:0x010d, B:56:0x0113, B:58:0x011c, B:63:0x0129, B:67:0x0137, B:71:0x0147, B:73:0x014e, B:76:0x0157, B:86:0x0189, B:88:0x0191, B:95:0x01ca, B:98:0x01f4, B:99:0x0223, B:101:0x0228, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:111:0x025b, B:113:0x0276, B:89:0x019d, B:91:0x01a5, B:92:0x01b7, B:94:0x01bf, B:77:0x015d, B:79:0x0161, B:81:0x0167, B:82:0x016d, B:84:0x0175, B:85:0x0182, B:66:0x0133, B:62:0x0125, B:51:0x00eb, B:22:0x0086, B:17:0x004e, B:19:0x0064), top: B:118:0x004c, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0144  */
    /* JADX WARN: Code duplicated, block: B:70:0x0145  */
    /* JADX WARN: Code duplicated, block: B:77:0x015d A[Catch: all -> 0x02c0, TryCatch #0 {all -> 0x02c0, blocks: (B:16:0x004c, B:52:0x00f2, B:54:0x010d, B:56:0x0113, B:58:0x011c, B:63:0x0129, B:67:0x0137, B:71:0x0147, B:73:0x014e, B:76:0x0157, B:86:0x0189, B:88:0x0191, B:95:0x01ca, B:98:0x01f4, B:99:0x0223, B:101:0x0228, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:111:0x025b, B:113:0x0276, B:89:0x019d, B:91:0x01a5, B:92:0x01b7, B:94:0x01bf, B:77:0x015d, B:79:0x0161, B:81:0x0167, B:82:0x016d, B:84:0x0175, B:85:0x0182, B:66:0x0133, B:62:0x0125, B:51:0x00eb, B:22:0x0086, B:17:0x004e, B:19:0x0064), top: B:118:0x004c, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0161 A[Catch: all -> 0x02c0, TryCatch #0 {all -> 0x02c0, blocks: (B:16:0x004c, B:52:0x00f2, B:54:0x010d, B:56:0x0113, B:58:0x011c, B:63:0x0129, B:67:0x0137, B:71:0x0147, B:73:0x014e, B:76:0x0157, B:86:0x0189, B:88:0x0191, B:95:0x01ca, B:98:0x01f4, B:99:0x0223, B:101:0x0228, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:111:0x025b, B:113:0x0276, B:89:0x019d, B:91:0x01a5, B:92:0x01b7, B:94:0x01bf, B:77:0x015d, B:79:0x0161, B:81:0x0167, B:82:0x016d, B:84:0x0175, B:85:0x0182, B:66:0x0133, B:62:0x0125, B:51:0x00eb, B:22:0x0086, B:17:0x004e, B:19:0x0064), top: B:118:0x004c, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0167 A[Catch: all -> 0x02c0, TryCatch #0 {all -> 0x02c0, blocks: (B:16:0x004c, B:52:0x00f2, B:54:0x010d, B:56:0x0113, B:58:0x011c, B:63:0x0129, B:67:0x0137, B:71:0x0147, B:73:0x014e, B:76:0x0157, B:86:0x0189, B:88:0x0191, B:95:0x01ca, B:98:0x01f4, B:99:0x0223, B:101:0x0228, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:111:0x025b, B:113:0x0276, B:89:0x019d, B:91:0x01a5, B:92:0x01b7, B:94:0x01bf, B:77:0x015d, B:79:0x0161, B:81:0x0167, B:82:0x016d, B:84:0x0175, B:85:0x0182, B:66:0x0133, B:62:0x0125, B:51:0x00eb, B:22:0x0086, B:17:0x004e, B:19:0x0064), top: B:118:0x004c, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0175 A[Catch: all -> 0x02c0, TryCatch #0 {all -> 0x02c0, blocks: (B:16:0x004c, B:52:0x00f2, B:54:0x010d, B:56:0x0113, B:58:0x011c, B:63:0x0129, B:67:0x0137, B:71:0x0147, B:73:0x014e, B:76:0x0157, B:86:0x0189, B:88:0x0191, B:95:0x01ca, B:98:0x01f4, B:99:0x0223, B:101:0x0228, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:111:0x025b, B:113:0x0276, B:89:0x019d, B:91:0x01a5, B:92:0x01b7, B:94:0x01bf, B:77:0x015d, B:79:0x0161, B:81:0x0167, B:82:0x016d, B:84:0x0175, B:85:0x0182, B:66:0x0133, B:62:0x0125, B:51:0x00eb, B:22:0x0086, B:17:0x004e, B:19:0x0064), top: B:118:0x004c, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0191 A[Catch: all -> 0x02c0, TryCatch #0 {all -> 0x02c0, blocks: (B:16:0x004c, B:52:0x00f2, B:54:0x010d, B:56:0x0113, B:58:0x011c, B:63:0x0129, B:67:0x0137, B:71:0x0147, B:73:0x014e, B:76:0x0157, B:86:0x0189, B:88:0x0191, B:95:0x01ca, B:98:0x01f4, B:99:0x0223, B:101:0x0228, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:111:0x025b, B:113:0x0276, B:89:0x019d, B:91:0x01a5, B:92:0x01b7, B:94:0x01bf, B:77:0x015d, B:79:0x0161, B:81:0x0167, B:82:0x016d, B:84:0x0175, B:85:0x0182, B:66:0x0133, B:62:0x0125, B:51:0x00eb, B:22:0x0086, B:17:0x004e, B:19:0x0064), top: B:118:0x004c, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x019d A[Catch: all -> 0x02c0, TryCatch #0 {all -> 0x02c0, blocks: (B:16:0x004c, B:52:0x00f2, B:54:0x010d, B:56:0x0113, B:58:0x011c, B:63:0x0129, B:67:0x0137, B:71:0x0147, B:73:0x014e, B:76:0x0157, B:86:0x0189, B:88:0x0191, B:95:0x01ca, B:98:0x01f4, B:99:0x0223, B:101:0x0228, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:111:0x025b, B:113:0x0276, B:89:0x019d, B:91:0x01a5, B:92:0x01b7, B:94:0x01bf, B:77:0x015d, B:79:0x0161, B:81:0x0167, B:82:0x016d, B:84:0x0175, B:85:0x0182, B:66:0x0133, B:62:0x0125, B:51:0x00eb, B:22:0x0086, B:17:0x004e, B:19:0x0064), top: B:118:0x004c, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x01a5 A[Catch: all -> 0x02c0, TryCatch #0 {all -> 0x02c0, blocks: (B:16:0x004c, B:52:0x00f2, B:54:0x010d, B:56:0x0113, B:58:0x011c, B:63:0x0129, B:67:0x0137, B:71:0x0147, B:73:0x014e, B:76:0x0157, B:86:0x0189, B:88:0x0191, B:95:0x01ca, B:98:0x01f4, B:99:0x0223, B:101:0x0228, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:111:0x025b, B:113:0x0276, B:89:0x019d, B:91:0x01a5, B:92:0x01b7, B:94:0x01bf, B:77:0x015d, B:79:0x0161, B:81:0x0167, B:82:0x016d, B:84:0x0175, B:85:0x0182, B:66:0x0133, B:62:0x0125, B:51:0x00eb, B:22:0x0086, B:17:0x004e, B:19:0x0064), top: B:118:0x004c, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x01b7 A[Catch: all -> 0x02c0, TryCatch #0 {all -> 0x02c0, blocks: (B:16:0x004c, B:52:0x00f2, B:54:0x010d, B:56:0x0113, B:58:0x011c, B:63:0x0129, B:67:0x0137, B:71:0x0147, B:73:0x014e, B:76:0x0157, B:86:0x0189, B:88:0x0191, B:95:0x01ca, B:98:0x01f4, B:99:0x0223, B:101:0x0228, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:111:0x025b, B:113:0x0276, B:89:0x019d, B:91:0x01a5, B:92:0x01b7, B:94:0x01bf, B:77:0x015d, B:79:0x0161, B:81:0x0167, B:82:0x016d, B:84:0x0175, B:85:0x0182, B:66:0x0133, B:62:0x0125, B:51:0x00eb, B:22:0x0086, B:17:0x004e, B:19:0x0064), top: B:118:0x004c, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01bf A[Catch: all -> 0x02c0, TryCatch #0 {all -> 0x02c0, blocks: (B:16:0x004c, B:52:0x00f2, B:54:0x010d, B:56:0x0113, B:58:0x011c, B:63:0x0129, B:67:0x0137, B:71:0x0147, B:73:0x014e, B:76:0x0157, B:86:0x0189, B:88:0x0191, B:95:0x01ca, B:98:0x01f4, B:99:0x0223, B:101:0x0228, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:111:0x025b, B:113:0x0276, B:89:0x019d, B:91:0x01a5, B:92:0x01b7, B:94:0x01bf, B:77:0x015d, B:79:0x0161, B:81:0x0167, B:82:0x016d, B:84:0x0175, B:85:0x0182, B:66:0x0133, B:62:0x0125, B:51:0x00eb, B:22:0x0086, B:17:0x004e, B:19:0x0064), top: B:118:0x004c, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x01f4 A[Catch: all -> 0x02c0, TRY_ENTER, TryCatch #0 {all -> 0x02c0, blocks: (B:16:0x004c, B:52:0x00f2, B:54:0x010d, B:56:0x0113, B:58:0x011c, B:63:0x0129, B:67:0x0137, B:71:0x0147, B:73:0x014e, B:76:0x0157, B:86:0x0189, B:88:0x0191, B:95:0x01ca, B:98:0x01f4, B:99:0x0223, B:101:0x0228, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:111:0x025b, B:113:0x0276, B:89:0x019d, B:91:0x01a5, B:92:0x01b7, B:94:0x01bf, B:77:0x015d, B:79:0x0161, B:81:0x0167, B:82:0x016d, B:84:0x0175, B:85:0x0182, B:66:0x0133, B:62:0x0125, B:51:0x00eb, B:22:0x0086, B:17:0x004e, B:19:0x0064), top: B:118:0x004c, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0223 A[Catch: all -> 0x02c0, TryCatch #0 {all -> 0x02c0, blocks: (B:16:0x004c, B:52:0x00f2, B:54:0x010d, B:56:0x0113, B:58:0x011c, B:63:0x0129, B:67:0x0137, B:71:0x0147, B:73:0x014e, B:76:0x0157, B:86:0x0189, B:88:0x0191, B:95:0x01ca, B:98:0x01f4, B:99:0x0223, B:101:0x0228, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:111:0x025b, B:113:0x0276, B:89:0x019d, B:91:0x01a5, B:92:0x01b7, B:94:0x01bf, B:77:0x015d, B:79:0x0161, B:81:0x0167, B:82:0x016d, B:84:0x0175, B:85:0x0182, B:66:0x0133, B:62:0x0125, B:51:0x00eb, B:22:0x0086, B:17:0x004e, B:19:0x0064), top: B:118:0x004c, inners: #1 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:113:0x0276, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:98:0x01f4, please report this as an issue */
    public void invokeCreateInstance(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.Script script, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.Object> map2;
        com.taobao.weex.bridge.WXJSObject wXJSObject;
        com.taobao.weex.bridge.WXJSObject wXJSObject2;
        java.lang.Object obj;
        java.lang.String str2;
        java.lang.String strFromObjectToJSONString;
        java.lang.String strFromObjectToJSONString2;
        com.taobao.weex.bridge.WXJSObject wXJSObject3;
        com.taobao.weex.adapter.IWXJsFileLoaderAdapter iWXJsFileLoaderAdapter;
        com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr;
        int iInvokeCreateInstanceContext;
        if (!isSkipFrameworkInit(wXSDKInstance)) {
            initFramework("");
        }
        if (this.mMock) {
            mock(wXSDKInstance.getInstanceId());
            return;
        }
        if (!isSkipFrameworkInit(wXSDKInstance) && !isJSFrameworkInit()) {
            wXSDKInstance.onRenderError(com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorCode(), com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorMsg());
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] invokeCreateInstance: framework.js uninitialized.");
            return;
        }
        com.taobao.weex.bridge.WXModuleManager.registerWhenCreateInstance();
        try {
            com.taobao.weex.bridge.WXBridgeManager.BundType bundleType = com.taobao.weex.bridge.WXBridgeManager.BundType.Others;
            try {
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                bundleType = getBundleType(wXSDKInstance.getBundleUrl(), script.getContent());
                if (com.taobao.weex.WXEnvironment.isOpenDebugLog()) {
                    com.taobao.weex.utils.WXLogUtils.e("end getBundleType type:" + bundleType.toString() + " time:" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
                }
            } catch (java.lang.Throwable th) {
                com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            }
            if (map == null) {
                try {
                    map2 = new java.util.HashMap();
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    map2 = map;
                    com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
                    wXSDKInstance.bundleType = bundleType;
                    com.taobao.weex.WXEnvironment.isApkDebugable();
                    com.taobao.weex.bridge.WXJSObject wXJSObject4 = new com.taobao.weex.bridge.WXJSObject(2, wXSDKInstance.getInstanceId());
                    wXJSObject = new com.taobao.weex.bridge.WXJSObject(2, script.getContent());
                    wXJSObject2 = null;
                    if (map2 == null) {
                        obj = null;
                    } else {
                        obj = null;
                    }
                    str2 = "{}";
                    if (obj == null) {
                        strFromObjectToJSONString = "{}";
                    } else {
                        strFromObjectToJSONString = com.taobao.weex.utils.WXJsonUtils.fromObjectToJSONString(obj);
                    }
                    com.taobao.weex.bridge.WXJSObject wXJSObject5 = new com.taobao.weex.bridge.WXJSObject(3, strFromObjectToJSONString);
                    if (map2 == null) {
                        strFromObjectToJSONString2 = "{}";
                    } else {
                        strFromObjectToJSONString2 = com.taobao.weex.utils.WXJsonUtils.fromObjectToJSONString(map2);
                    }
                    com.taobao.weex.bridge.WXJSObject wXJSObjectOptionObjConvert = optionObjConvert(isSandBoxContext, bundleType, new com.taobao.weex.bridge.WXJSObject(3, strFromObjectToJSONString2));
                    if (str == null) {
                        str2 = str;
                    }
                    com.taobao.weex.bridge.WXJSObject wXJSObject6 = new com.taobao.weex.bridge.WXJSObject(3, str2);
                    if (bundleType != com.taobao.weex.bridge.WXBridgeManager.BundType.Rax) {
                        if (mRaxApi == null) {
                            iWXJsFileLoaderAdapter = com.taobao.weex.WXSDKEngine.getIWXJsFileLoaderAdapter();
                            if (iWXJsFileLoaderAdapter != null) {
                                mRaxApi = iWXJsFileLoaderAdapter.loadRaxApi();
                            }
                            if (android.text.TextUtils.isEmpty(mRaxApi)) {
                                mRaxApi = com.taobao.weex.utils.WXFileUtils.loadAsset("weex-rax-api.js", com.taobao.weex.WXEnvironment.getApplication());
                            }
                        }
                        wXJSObject3 = new com.taobao.weex.bridge.WXJSObject(2, mRaxApi);
                    } else {
                        if (mRaxApi == null) {
                            iWXJsFileLoaderAdapter = com.taobao.weex.WXSDKEngine.getIWXJsFileLoaderAdapter();
                            if (iWXJsFileLoaderAdapter != null) {
                                mRaxApi = iWXJsFileLoaderAdapter.loadRaxApi();
                            }
                            if (android.text.TextUtils.isEmpty(mRaxApi)) {
                                mRaxApi = com.taobao.weex.utils.WXFileUtils.loadAsset("weex-rax-api.js", com.taobao.weex.WXEnvironment.getApplication());
                            }
                        }
                        wXJSObject3 = new com.taobao.weex.bridge.WXJSObject(2, mRaxApi);
                    }
                    if (wXSDKInstance.getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.DATA_RENDER) {
                        wXJSObject2 = new com.taobao.weex.bridge.WXJSObject(2, com.taobao.weex.common.WXRenderStrategy.DATA_RENDER.getFlag());
                    } else if (wXSDKInstance.getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.DATA_RENDER_BINARY) {
                        wXJSObject2 = new com.taobao.weex.bridge.WXJSObject(2, com.taobao.weex.common.WXRenderStrategy.DATA_RENDER_BINARY.getFlag());
                        wXJSObject.data = script.getBinary();
                    } else if (wXSDKInstance.getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.JSON_RENDER) {
                        wXJSObject2 = new com.taobao.weex.bridge.WXJSObject(2, com.taobao.weex.common.WXRenderStrategy.JSON_RENDER.getFlag());
                    }
                    wXJSObjectArr = new com.taobao.weex.bridge.WXJSObject[]{wXJSObject4, wXJSObject, wXJSObjectOptionObjConvert, wXJSObject6, wXJSObject3, wXJSObject2, wXJSObject5};
                    wXSDKInstance.setTemplate(script.getContent());
                    wXSDKInstance.getApmForInstance().onStage(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_END);
                    if (!isSandBoxContext) {
                        wXSDKInstance.getApmForInstance().onStage("!isSandBoxContext,and excute");
                        com.taobao.weex.utils.WXLogUtils.e("Instance " + wXSDKInstance.getInstanceId() + " Did Not Render in SandBox Mode");
                        invokeExecJS(wXSDKInstance.getInstanceId(), null, METHOD_CREATE_INSTANCE, wXJSObjectArr, false);
                        return;
                    }
                    if (bundleType != com.taobao.weex.bridge.WXBridgeManager.BundType.Vue) {
                        invokeExecJS(wXSDKInstance.getInstanceId(), null, METHOD_CREATE_INSTANCE, wXJSObjectArr, false);
                        wXSDKInstance.getApmForInstance().onStage(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_END);
                        return;
                    }
                    iInvokeCreateInstanceContext = invokeCreateInstanceContext(wXSDKInstance.getInstanceId(), wXSDKInstance.getUniPagePath(), METHOD_CREATE_INSTANCE_CONTEXT, wXJSObjectArr, false);
                    wXSDKInstance.getApmForInstance().onStage(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_END);
                    if (iInvokeCreateInstanceContext == 0) {
                        java.lang.String str3 = "[WXBridgeManager] invokeCreateInstance : " + wXSDKInstance.getTemplateInfo();
                        com.taobao.weex.utils.WXLogUtils.e("Instance " + wXSDKInstance.getInstanceId() + "Render error : " + str3);
                        wXSDKInstance.onRenderError(com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorCode(), com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorMsg() + str3);
                    }
                }
            } else {
                map2 = map;
            }
            try {
                if (map2.get(BUNDLE_TYPE) == null) {
                    if (bundleType == com.taobao.weex.bridge.WXBridgeManager.BundType.Vue) {
                        map2.put(BUNDLE_TYPE, "Vue");
                    } else if (bundleType == com.taobao.weex.bridge.WXBridgeManager.BundType.Rax) {
                        map2.put(BUNDLE_TYPE, "Rax");
                    } else {
                        map2.put(BUNDLE_TYPE, "Others");
                    }
                    java.lang.Object obj2 = map2.get(BUNDLE_TYPE);
                    if ((obj2 instanceof java.lang.String) && "Others".equalsIgnoreCase((java.lang.String) obj2)) {
                        obj2 = "other";
                    }
                    if (obj2 != null) {
                        wXSDKInstance.getApmForInstance().addProperty(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_PROPERTIES_BUNDLE_TYPE, obj2);
                    }
                }
                if (map2.get("env") == null) {
                    map2.put("env", this.mInitParams.toMap());
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            }
            wXSDKInstance.bundleType = bundleType;
            com.taobao.weex.WXEnvironment.isApkDebugable();
            com.taobao.weex.bridge.WXJSObject wXJSObject7 = new com.taobao.weex.bridge.WXJSObject(2, wXSDKInstance.getInstanceId());
            wXJSObject = new com.taobao.weex.bridge.WXJSObject(2, script.getContent());
            wXJSObject2 = null;
            if (map2 == null && map2.containsKey("extraOption")) {
                obj = map2.get("extraOption");
                map2.remove("extraOption");
            } else {
                obj = null;
            }
            str2 = "{}";
            if (obj == null) {
                strFromObjectToJSONString = "{}";
            } else {
                strFromObjectToJSONString = com.taobao.weex.utils.WXJsonUtils.fromObjectToJSONString(obj);
            }
            com.taobao.weex.bridge.WXJSObject wXJSObject8 = new com.taobao.weex.bridge.WXJSObject(3, strFromObjectToJSONString);
            if (map2 == null) {
                strFromObjectToJSONString2 = "{}";
            } else {
                strFromObjectToJSONString2 = com.taobao.weex.utils.WXJsonUtils.fromObjectToJSONString(map2);
            }
            com.taobao.weex.bridge.WXJSObject wXJSObjectOptionObjConvert2 = optionObjConvert(isSandBoxContext, bundleType, new com.taobao.weex.bridge.WXJSObject(3, strFromObjectToJSONString2));
            if (str == null) {
                str2 = str;
            }
            com.taobao.weex.bridge.WXJSObject wXJSObject9 = new com.taobao.weex.bridge.WXJSObject(3, str2);
            if (bundleType != com.taobao.weex.bridge.WXBridgeManager.BundType.Rax || wXSDKInstance.getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.DATA_RENDER) {
                if (mRaxApi == null) {
                    iWXJsFileLoaderAdapter = com.taobao.weex.WXSDKEngine.getIWXJsFileLoaderAdapter();
                    if (iWXJsFileLoaderAdapter != null) {
                        mRaxApi = iWXJsFileLoaderAdapter.loadRaxApi();
                    }
                    if (android.text.TextUtils.isEmpty(mRaxApi)) {
                        mRaxApi = com.taobao.weex.utils.WXFileUtils.loadAsset("weex-rax-api.js", com.taobao.weex.WXEnvironment.getApplication());
                    }
                }
                wXJSObject3 = new com.taobao.weex.bridge.WXJSObject(2, mRaxApi);
            } else {
                wXJSObject3 = new com.taobao.weex.bridge.WXJSObject(2, "");
            }
            if (wXSDKInstance.getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.DATA_RENDER) {
                wXJSObject2 = new com.taobao.weex.bridge.WXJSObject(2, com.taobao.weex.common.WXRenderStrategy.DATA_RENDER.getFlag());
            } else if (wXSDKInstance.getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.DATA_RENDER_BINARY) {
                wXJSObject2 = new com.taobao.weex.bridge.WXJSObject(2, com.taobao.weex.common.WXRenderStrategy.DATA_RENDER_BINARY.getFlag());
                wXJSObject.data = script.getBinary();
            } else if (wXSDKInstance.getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.JSON_RENDER) {
                wXJSObject2 = new com.taobao.weex.bridge.WXJSObject(2, com.taobao.weex.common.WXRenderStrategy.JSON_RENDER.getFlag());
            }
            wXJSObjectArr = new com.taobao.weex.bridge.WXJSObject[]{wXJSObject7, wXJSObject, wXJSObjectOptionObjConvert2, wXJSObject9, wXJSObject3, wXJSObject2, wXJSObject8};
            wXSDKInstance.setTemplate(script.getContent());
            wXSDKInstance.getApmForInstance().onStage(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_END);
            if (!isSandBoxContext) {
                wXSDKInstance.getApmForInstance().onStage("!isSandBoxContext,and excute");
                com.taobao.weex.utils.WXLogUtils.e("Instance " + wXSDKInstance.getInstanceId() + " Did Not Render in SandBox Mode");
                invokeExecJS(wXSDKInstance.getInstanceId(), null, METHOD_CREATE_INSTANCE, wXJSObjectArr, false);
                return;
            }
            if (bundleType != com.taobao.weex.bridge.WXBridgeManager.BundType.Vue && bundleType != com.taobao.weex.bridge.WXBridgeManager.BundType.Rax && wXSDKInstance.getRenderStrategy() != com.taobao.weex.common.WXRenderStrategy.DATA_RENDER && wXSDKInstance.getRenderStrategy() != com.taobao.weex.common.WXRenderStrategy.DATA_RENDER_BINARY && wXSDKInstance.getRenderStrategy() != com.taobao.weex.common.WXRenderStrategy.JSON_RENDER) {
                invokeExecJS(wXSDKInstance.getInstanceId(), null, METHOD_CREATE_INSTANCE, wXJSObjectArr, false);
                wXSDKInstance.getApmForInstance().onStage(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_END);
                return;
            }
            iInvokeCreateInstanceContext = invokeCreateInstanceContext(wXSDKInstance.getInstanceId(), wXSDKInstance.getUniPagePath(), METHOD_CREATE_INSTANCE_CONTEXT, wXJSObjectArr, false);
            wXSDKInstance.getApmForInstance().onStage(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STAGES_LOAD_BUNDLE_END);
            if (iInvokeCreateInstanceContext == 0) {
                java.lang.String str4 = "[WXBridgeManager] invokeCreateInstance : " + wXSDKInstance.getTemplateInfo();
                com.taobao.weex.utils.WXLogUtils.e("Instance " + wXSDKInstance.getInstanceId() + "Render error : " + str4);
                wXSDKInstance.onRenderError(com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorCode(), com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorMsg() + str4);
            }
        } catch (java.lang.Throwable th4) {
            java.lang.String str5 = "[WXBridgeManager] invokeCreateInstance " + th4.getCause() + wXSDKInstance.getTemplateInfo();
            wXSDKInstance.onRenderError(com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorCode(), com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorMsg() + str5);
            com.taobao.weex.utils.WXLogUtils.e(str5);
        }
    }

    public com.taobao.weex.bridge.WXJSObject optionObjConvert(boolean z, com.taobao.weex.bridge.WXBridgeManager.BundType bundType, com.taobao.weex.bridge.WXJSObject wXJSObject) {
        com.alibaba.fastjson.JSONObject jSONObject;
        if (!z) {
            return wXJSObject;
        }
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(wXJSObject.data.toString());
            com.alibaba.fastjson.JSONObject jSONObject2 = object.getJSONObject("env");
            if (jSONObject2 != null && (jSONObject = jSONObject2.getJSONObject("options")) != null) {
                for (java.lang.String str : jSONObject.keySet()) {
                    jSONObject2.put(str, (java.lang.Object) jSONObject.getString(str));
                }
            }
            return new com.taobao.weex.bridge.WXJSObject(3, object.toString());
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
            return wXJSObject;
        }
    }

    public com.taobao.weex.bridge.WXBridgeManager.BundType getBundleType(java.lang.String str, java.lang.String str2) {
        if (str != null) {
            try {
                java.lang.String queryParameter = android.net.Uri.parse(str).getQueryParameter(BUNDLE_TYPE);
                if (!"Vue".equals(queryParameter) && !"vue".equals(queryParameter)) {
                    if ("Rax".equals(queryParameter) || "rax".equals(queryParameter)) {
                        return com.taobao.weex.bridge.WXBridgeManager.BundType.Rax;
                    }
                }
                return com.taobao.weex.bridge.WXBridgeManager.BundType.Vue;
            } catch (java.lang.Throwable th) {
                com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
                return com.taobao.weex.bridge.WXBridgeManager.BundType.Others;
            }
        }
        if (str2 != null) {
            return com.taobao.weex.bridge.WXBridgeManager.BundType.Vue;
        }
        return com.taobao.weex.bridge.WXBridgeManager.BundType.Others;
    }

    public void destroyInstance(final java.lang.String str) {
        if (this.mJSHandler == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null) {
            hashSet.add(str);
        }
        this.mJSHandler.removeCallbacksAndMessages(str);
        post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.19
            @Override // java.lang.Runnable
            public void run() {
                com.taobao.weex.bridge.WXBridgeManager.this.removeTaskByInstance(str);
                com.taobao.weex.bridge.WXBridgeManager.this.invokeDestroyInstance(str);
            }
        }, str, null, METHOD_DESTROY_INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTaskByInstance(java.lang.String str) {
        this.mNextTickTasks.removeFromMapAndStack(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeDestroyInstance(java.lang.String str) {
        java.lang.String str2;
        try {
            com.taobao.weex.WXEnvironment.isApkDebugable();
            com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr = {new com.taobao.weex.bridge.WXJSObject(2, str)};
            if (!isSkipFrameworkInit(str) && !isJSFrameworkInit()) {
                return;
            }
            str2 = str;
            try {
                invokeDestoryInstance(str2, null, METHOD_DESTROY_INSTANCE, wXJSObjectArr, true);
            } catch (java.lang.Throwable th) {
                th = th;
                java.lang.String str3 = "[WXBridgeManager] invokeDestroyInstance " + th.getCause();
                com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str2, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "invokeDestroyInstance", str3, null);
                com.taobao.weex.utils.WXLogUtils.e(str3);
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            str2 = str;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        if (message == null) {
            return false;
        }
        int i = message.what;
        if (i == 1) {
            com.taobao.weex.bridge.WXBridgeManager.TimerInfo timerInfo = (com.taobao.weex.bridge.WXBridgeManager.TimerInfo) message.obj;
            if (timerInfo != null) {
                invokeExecJS("", null, METHOD_SET_TIMEOUT, new com.taobao.weex.bridge.WXJSObject[]{new com.taobao.weex.bridge.WXJSObject(2, timerInfo.callbackId)});
            }
        } else if (i != 13) {
            if (i == 6) {
                invokeCallJSBatch(message);
            } else if (i == 7) {
                invokeInitFramework(message);
            }
        } else if (message.obj != null) {
            this.mWXBridge.takeHeapSnapshot((java.lang.String) message.obj);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeExecJS(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr) {
        invokeExecJS(str, str2, str3, wXJSObjectArr, true);
    }

    public void invokeExecJS(final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr, boolean z) {
        android.util.Pair<android.util.Pair<java.lang.String, java.lang.Object>, java.lang.Boolean> pairExtractCallbackArgs;
        com.taobao.weex.WXEnvironment.isOpenDebugLog();
        if (io.dcloud.common.util.RuningAcitvityUtil.isRuningActivity) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance != null && sDKInstance.getRenderStrategy() == com.taobao.weex.common.WXRenderStrategy.DATA_RENDER_BINARY) {
                if (wXJSObjectArr.length != 2 || !(wXJSObjectArr[0].data instanceof java.lang.String) || !(wXJSObjectArr[1].data instanceof java.lang.String) || (pairExtractCallbackArgs = extractCallbackArgs((java.lang.String) wXJSObjectArr[1].data)) == null) {
                    com.taobao.weex.utils.WXLogUtils.w("invokeExecJS on data render that is not a callback call");
                    return;
                }
                callbackJavascriptOnDataRender(str, (java.lang.String) ((android.util.Pair) pairExtractCallbackArgs.first).first, ((android.util.Pair) pairExtractCallbackArgs.first).second, ((java.lang.Boolean) pairExtractCallbackArgs.second).booleanValue());
            } else {
                com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.20
                    @Override // java.lang.Runnable
                    public void run() {
                        com.taobao.weex.bridge.WXBridgeManager.this.mWXBridge.execJS(str, str2, str3, wXJSObjectArr);
                    }
                }, sDKInstance, "ExecJs").run();
            }
            if (sDKInstance != null) {
                long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis() - jCurrentTimeMillis;
                sDKInstance.getApmForInstance().updateFSDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_FS_CALL_JS_NUM, 1.0d);
                sDKInstance.getApmForInstance().updateFSDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_FS_CALL_JS_TIME, jCurrentTimeMillis2);
                sDKInstance.callJsTime(jCurrentTimeMillis2);
            }
        }
    }

    private android.util.Pair<android.util.Pair<java.lang.String, java.lang.Object>, java.lang.Boolean> extractCallbackArgs(java.lang.String str) {
        try {
            com.alibaba.fastjson.JSONObject jSONObject = com.alibaba.fastjson.JSON.parseArray(str).getJSONObject(0);
            com.alibaba.fastjson.JSONArray jSONArray = jSONObject.getJSONArray("args");
            if (jSONArray.size() == 3 && METHOD_CALLBACK.equals(jSONObject.getString("method"))) {
                return new android.util.Pair<>(new android.util.Pair(jSONArray.getString(0), jSONArray.getJSONObject(1)), java.lang.Boolean.valueOf(jSONArray.getBooleanValue(2)));
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public int invokeCreateInstanceContext(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr, boolean z) {
        com.taobao.weex.utils.WXLogUtils.d("invokeCreateInstanceContext instanceId:" + str + " function:" + str3 + io.dcloud.common.util.StringUtil.format(" isJSFrameworkInit：%b", java.lang.Boolean.valueOf(isJSFrameworkInit())));
        java.lang.StringBuilder sb = this.mLodBuilder;
        sb.append("createInstanceContext >>>> instanceId:");
        sb.append(str);
        sb.append("function:");
        sb.append(str3);
        if (z) {
            java.lang.StringBuilder sb2 = this.mLodBuilder;
            sb2.append(" tasks:");
            sb2.append(com.taobao.weex.utils.WXJsonUtils.fromObjectToJSONString(wXJSObjectArr));
        }
        com.taobao.weex.utils.WXLogUtils.d(this.mLodBuilder.substring(0));
        this.mLodBuilder.setLength(0);
        return this.mWXBridge.createInstanceContext(str, str2, str3, wXJSObjectArr);
    }

    public void invokeDestoryInstance(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr, boolean z) {
        java.lang.StringBuilder sb = this.mLodBuilder;
        sb.append("callJS >>>> instanceId:");
        sb.append(str);
        sb.append("function:");
        sb.append(str3);
        if (z) {
            java.lang.StringBuilder sb2 = this.mLodBuilder;
            sb2.append(" tasks:");
            sb2.append(com.taobao.weex.utils.WXJsonUtils.fromObjectToJSONString(wXJSObjectArr));
        }
        com.taobao.weex.utils.WXLogUtils.d(this.mLodBuilder.substring(0));
        this.mLodBuilder.setLength(0);
        this.mWXBridge.removeInstanceRenderType(str);
        this.mWXBridge.destoryInstance(str, str2, str3, wXJSObjectArr);
    }

    private void execJSOnInstance(final com.taobao.weex.bridge.EventResult eventResult, final java.lang.String str, final java.lang.String str2, final int i) {
        post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.21
            @Override // java.lang.Runnable
            public void run() {
                eventResult.onCallback(com.taobao.weex.bridge.WXBridgeManager.this.invokeExecJSOnInstance(str, str2, i));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String invokeExecJSOnInstance(java.lang.String str, java.lang.String str2, int i) {
        java.lang.StringBuilder sb = this.mLodBuilder;
        sb.append("execJSOnInstance >>>> instanceId:");
        sb.append(str);
        com.taobao.weex.utils.WXLogUtils.d(this.mLodBuilder.substring(0));
        this.mLodBuilder.setLength(0);
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            return this.mWXBridge.execJSOnInstance(str, str2, i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeExecJSWithCallback(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr, com.taobao.weex.bridge.ResultCallback resultCallback, boolean z) {
        com.taobao.weex.WXEnvironment.isOpenDebugLog();
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.execJSWithCallback(str, str2, str3, wXJSObjectArr, resultCallback);
        }
    }

    public static java.lang.String argsToJSON(com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(com.taobao.weex.el.parse.Operators.ARRAY_START_STR);
        for (com.taobao.weex.bridge.WXJSObject wXJSObject : wXJSObjectArr) {
            sb.append(com.taobao.weex.utils.WXWsonJSONSwitch.fromObjectToJSONString(wXJSObject));
            sb.append(",");
        }
        sb.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        return sb.toString();
    }

    private void invokeInitFramework(android.os.Message message) {
        java.lang.String str;
        if (message.obj == null) {
            str = "";
        } else {
            str = (java.lang.String) message.obj;
        }
        if (com.taobao.weex.utils.WXUtils.getAvailMemory(com.taobao.weex.WXEnvironment.getApplication()) > LOW_MEM_VALUE) {
            initFramework(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initFramework(java.lang.String str) {
        com.taobao.weex.utils.tools.LogDetail logDetail = new com.taobao.weex.utils.tools.LogDetail();
        logDetail.name(com.taobao.weex.adapter.IWXUserTrackAdapter.INIT_FRAMEWORK);
        logDetail.taskStart();
        if (!com.taobao.weex.WXSDKEngine.isSoInitialized() || isJSFrameworkInit()) {
            return;
        }
        sInitFrameWorkTimeOrigin = java.lang.System.currentTimeMillis();
        if (android.text.TextUtils.isEmpty(str)) {
            com.taobao.weex.utils.WXLogUtils.d("weex JS framework from assets");
            com.taobao.weex.utils.tools.LogDetail logDetail2 = new com.taobao.weex.utils.tools.LogDetail();
            logDetail2.name("loadJSFramework");
            logDetail2.taskStart();
            com.taobao.weex.adapter.IWXJsFileLoaderAdapter iWXJsFileLoaderAdapter = com.taobao.weex.WXSDKEngine.getIWXJsFileLoaderAdapter();
            if (!isSandBoxContext) {
                if (iWXJsFileLoaderAdapter != null) {
                    str = iWXJsFileLoaderAdapter.loadJsFramework();
                }
                if (android.text.TextUtils.isEmpty(str)) {
                    str = com.taobao.weex.utils.WXFileUtils.loadAsset("main.js", com.taobao.weex.WXEnvironment.getApplication());
                }
            } else {
                if (iWXJsFileLoaderAdapter != null) {
                    str = iWXJsFileLoaderAdapter.loadJsFrameworkForSandBox();
                }
                if (android.text.TextUtils.isEmpty(str)) {
                    str = com.taobao.weex.utils.WXFileUtils.loadAsset("weex-main-jsfm.js", com.taobao.weex.WXEnvironment.getApplication());
                }
            }
            java.lang.StringBuilder sb = sInitFrameWorkMsg;
            sb.append("| weex JS framework from assets, isSandBoxContext: ");
            sb.append(isSandBoxContext);
            logDetail2.taskEnd();
            io.dcloud.weex.WXDotDataUtil.setValue(logDetail2.info.taskName, java.lang.Long.valueOf(logDetail2.time.execTime));
        }
        io.dcloud.weex.WXDotDataUtil.setValue("jsEngine", com.taobao.weex.common.Constants.CodeCache.SAVE_PATH);
        if (android.text.TextUtils.isEmpty(str)) {
            setJSFrameworkInit(false);
            sInitFrameWorkMsg.append("| framework isEmpty ");
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(null, com.taobao.weex.common.WXErrorCode.WX_ERR_JS_FRAMEWORK, com.taobao.weex.adapter.IWXUserTrackAdapter.INIT_FRAMEWORK, "framework is empty!! ", null);
            return;
        }
        try {
            if (com.taobao.weex.WXSDKManager.getInstance().getWXStatisticsListener() != null) {
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                com.taobao.weex.WXSDKManager.getInstance().getWXStatisticsListener().onJsFrameworkStart();
                com.taobao.weex.WXEnvironment.sJSFMStartListenerTime = java.lang.System.currentTimeMillis() - jCurrentTimeMillis;
                try {
                    com.taobao.weex.adapter.IWXUserTrackAdapter iWXUserTrackAdapter = com.taobao.weex.WXSDKManager.getInstance().getIWXUserTrackAdapter();
                    if (iWXUserTrackAdapter != null) {
                        java.util.HashMap map = new java.util.HashMap(1);
                        map.put(com.taobao.weex.common.Constants.Value.TIME, java.lang.String.valueOf(com.taobao.weex.WXEnvironment.sJSFMStartListenerTime));
                        iWXUserTrackAdapter.commit(com.taobao.weex.WXEnvironment.getApplication(), "sJSFMStartListener", com.taobao.weex.adapter.IWXUserTrackAdapter.COUNTER, null, map);
                    }
                } catch (java.lang.Exception e) {
                    com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
                }
            }
            long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
            java.lang.String path = "";
            try {
                path = com.taobao.weex.WXEnvironment.getApplication().getApplicationContext().getCacheDir().getPath();
            } catch (java.lang.Exception e2) {
                com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(e2));
            }
            java.lang.StringBuilder sb2 = sInitFrameWorkMsg;
            sb2.append(" | pieSupport:");
            sb2.append(true);
            com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] initFrameworkEnv crashFile:" + path + " pieSupport:true");
            com.taobao.weex.utils.tools.LogDetail logDetail3 = new com.taobao.weex.utils.tools.LogDetail();
            logDetail3.name("native initFrameworkEnv");
            logDetail3.taskStart();
            if (this.mWXBridge.initFrameworkEnv(str, assembleDefaultOptions(), path, true) == 1) {
                logDetail3.taskEnd();
                io.dcloud.weex.WXDotDataUtil.setValue(logDetail3.info.taskName, java.lang.Long.valueOf(logDetail3.time.execTime));
                com.taobao.weex.WXEnvironment.sJSLibInitTime = java.lang.System.currentTimeMillis() - jCurrentTimeMillis2;
                com.taobao.weex.WXEnvironment.sSDKInitTime = java.lang.System.currentTimeMillis() - com.taobao.weex.WXEnvironment.sSDKInitStart;
                setJSFrameworkInit(true);
                logDetail.taskEnd();
                io.dcloud.weex.WXDotDataUtil.setValue(logDetail.info.taskName, java.lang.Long.valueOf(logDetail.time.execTime));
                if (com.taobao.weex.WXSDKManager.getInstance().getWXStatisticsListener() != null) {
                    com.taobao.weex.WXSDKManager.getInstance().getWXStatisticsListener().onJsFrameworkReady();
                }
                execRegisterFailTask();
                com.taobao.weex.WXEnvironment.JsFrameworkInit = true;
                registerDomModule();
                trackComponentAndModulesTime();
                return;
            }
            java.lang.StringBuilder sb3 = sInitFrameWorkMsg;
            sb3.append(" | ExecuteJavaScript fail, reInitCount");
            sb3.append(reInitCount);
            if (reInitCount > 1) {
                com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] invokeReInitFramework  ExecuteJavaScript fail");
            } else {
                com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] invokeInitFramework  ExecuteJavaScript fail");
            }
        } catch (java.lang.Throwable th) {
            java.lang.StringBuilder sb4 = sInitFrameWorkMsg;
            sb4.append(" | invokeInitFramework exception ");
            sb4.append(th.toString());
            if (reInitCount > 1) {
                com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] invokeInitFramework ", th);
            } else {
                com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] invokeInitFramework ", th);
            }
        }
    }

    private void trackComponentAndModulesTime() {
        post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.22
            @Override // java.lang.Runnable
            public void run() {
                com.taobao.weex.WXEnvironment.sComponentsAndModulesReadyTime = java.lang.System.currentTimeMillis() - com.taobao.weex.WXEnvironment.sSDKInitStart;
            }
        });
    }

    private void invokeCallJSBatch(android.os.Message message) {
        if (this.mNextTickTasks.isEmpty() || !isJSFrameworkInit()) {
            if (isJSFrameworkInit()) {
                return;
            }
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] invokeCallJSBatch: framework.js uninitialized!!  message:" + message.toString());
            return;
        }
        try {
            java.lang.Object obj = message.obj;
            java.util.Stack<java.lang.String> instanceStack = this.mNextTickTasks.getInstanceStack();
            java.util.ArrayList<com.taobao.weex.bridge.WXHashMap<java.lang.String, java.lang.Object>> arrayListRemove = null;
            for (int size = instanceStack.size() - 1; size >= 0; size--) {
                obj = instanceStack.get(size);
                arrayListRemove = this.mNextTickTasks.remove(obj);
                if (arrayListRemove != null && !arrayListRemove.isEmpty()) {
                    break;
                }
            }
            if (arrayListRemove != null) {
                invokeExecJS(java.lang.String.valueOf(obj), null, METHOD_CALL_JS, new com.taobao.weex.bridge.WXJSObject[]{new com.taobao.weex.bridge.WXJSObject(2, obj), com.taobao.weex.utils.WXWsonJSONSwitch.toWsonOrJsonWXJSObject(arrayListRemove.toArray())});
            }
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXLogUtils.e("WXBridgeManager", th);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(null, com.taobao.weex.common.WXErrorCode.WX_ERR_JS_FRAMEWORK, "invokeCallJSBatch", "invokeCallJSBatch#" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th), null);
        }
        if (this.mNextTickTasks.isEmpty()) {
            return;
        }
        this.mJSHandler.sendEmptyMessage(6);
    }

    private com.taobao.weex.bridge.WXParams assembleDefaultOptions() {
        checkJsEngineMultiThread();
        java.util.Map<java.lang.String, java.lang.String> config = com.taobao.weex.WXEnvironment.getConfig();
        com.taobao.weex.bridge.WXParams wXParams = new com.taobao.weex.bridge.WXParams();
        wXParams.setPlatform(config.get(com.taobao.weex.common.WXConfig.os));
        wXParams.setCacheDir(config.get(com.taobao.weex.common.WXConfig.cacheDir));
        wXParams.setOsVersion(config.get(com.taobao.weex.common.WXConfig.sysVersion));
        wXParams.setAppVersion(config.get(com.taobao.weex.common.WXConfig.appVersion));
        wXParams.setWeexVersion(config.get(com.taobao.weex.common.WXConfig.weexVersion));
        wXParams.setDeviceModel(config.get(com.taobao.weex.common.WXConfig.sysModel));
        wXParams.setShouldInfoCollect(config.get("infoCollect"));
        wXParams.setLogLevel(config.get(com.taobao.weex.common.WXConfig.logLevel));
        wXParams.setLayoutDirection(config.get(com.taobao.weex.common.WXConfig.layoutDirection));
        wXParams.setUseSingleProcess(isUseSingleProcess ? io.dcloud.common.constant.AbsoluteConst.TRUE : io.dcloud.common.constant.AbsoluteConst.FALSE);
        wXParams.setCrashFilePath(com.taobao.weex.WXEnvironment.getCrashFilePath(com.taobao.weex.WXEnvironment.getApplication().getApplicationContext()));
        wXParams.setLibJsbPath(com.taobao.weex.WXEnvironment.CORE_JSB_SO_PATH);
        wXParams.setLibJssPath(com.taobao.weex.WXEnvironment.getLibJssRealPath());
        wXParams.setLibIcuPath(com.taobao.weex.WXEnvironment.getLibJssIcuPath());
        wXParams.setLibLdPath(com.taobao.weex.WXEnvironment.getLibLdPath());
        java.lang.String libJScRealPath = com.taobao.weex.WXEnvironment.getLibJScRealPath();
        wXParams.setLibJscPath(android.text.TextUtils.isEmpty(libJScRealPath) ? "" : new java.io.File(libJScRealPath).getParent());
        java.lang.String str = config.get(com.taobao.weex.common.WXConfig.appName);
        if (!android.text.TextUtils.isEmpty(str)) {
            wXParams.setAppName(str);
        }
        wXParams.setDeviceWidth(android.text.TextUtils.isEmpty(config.get(com.taobao.weex.common.WXConfig.deviceWidth)) ? java.lang.String.valueOf(com.taobao.weex.utils.WXViewUtils.getScreenWidth(com.taobao.weex.WXEnvironment.sApplication)) : config.get(com.taobao.weex.common.WXConfig.deviceWidth));
        wXParams.setDeviceHeight(android.text.TextUtils.isEmpty(config.get(com.taobao.weex.common.WXConfig.deviceHeight)) ? java.lang.String.valueOf(com.taobao.weex.utils.WXViewUtils.getScreenHeight(com.taobao.weex.WXEnvironment.sApplication)) : config.get(com.taobao.weex.common.WXConfig.deviceHeight));
        java.util.Map<java.lang.String, java.lang.String> customOptions = com.taobao.weex.WXEnvironment.getCustomOptions();
        customOptions.put("enableBackupThread", java.lang.String.valueOf(jsEngineMultiThreadEnable()));
        com.taobao.weex.adapter.IWXJscProcessManager wXJscProcessManager = com.taobao.weex.WXSDKManager.getInstance().getWXJscProcessManager();
        if (wXJscProcessManager != null) {
            customOptions.put("enableBackupThreadCache", java.lang.String.valueOf(wXJscProcessManager.enableBackUpThreadCache()));
        }
        if (!com.taobao.weex.WXEnvironment.sUseRunTimeApi) {
            customOptions.put("__enable_native_promise__", io.dcloud.common.constant.AbsoluteConst.TRUE);
        }
        wXParams.setOptions(customOptions);
        wXParams.setNeedInitV8(com.taobao.weex.WXSDKManager.getInstance().needInitV8());
        this.mInitParams = wXParams;
        return wXParams;
    }

    public com.taobao.weex.bridge.WXParams getInitParams() {
        return this.mInitParams;
    }

    private void execRegisterFailTask() {
        if (this.mRegisterModuleFailList.size() > 0) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int size = this.mRegisterModuleFailList.size();
            for (int i = 0; i < size; i++) {
                invokeRegisterModules(this.mRegisterModuleFailList.get(i), arrayList);
            }
            this.mRegisterModuleFailList.clear();
            if (arrayList.size() > 0) {
                this.mRegisterModuleFailList.addAll(arrayList);
            }
        }
        if (this.mRegisterComponentFailList.size() > 0) {
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            invokeRegisterComponents(this.mRegisterComponentFailList, arrayList2);
            this.mRegisterComponentFailList.clear();
            if (arrayList2.size() > 0) {
                this.mRegisterComponentFailList.addAll(arrayList2);
            }
        }
        if (this.mRegisterServiceFailList.size() > 0) {
            java.util.ArrayList arrayList3 = new java.util.ArrayList();
            java.util.Iterator<java.lang.String> it = this.mRegisterServiceFailList.iterator();
            while (it.hasNext()) {
                invokeExecJSService(it.next(), arrayList3);
            }
            this.mRegisterServiceFailList.clear();
            if (arrayList3.size() > 0) {
                this.mRegisterServiceFailList.addAll(arrayList3);
            }
        }
    }

    public void registerModules(final java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        if (isJSThread()) {
            invokeRegisterModules(map, this.mRegisterModuleFailList);
        } else {
            post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.23
                @Override // java.lang.Runnable
                public void run() {
                    com.taobao.weex.bridge.WXBridgeManager wXBridgeManager = com.taobao.weex.bridge.WXBridgeManager.this;
                    wXBridgeManager.invokeRegisterModules(map, wXBridgeManager.mRegisterModuleFailList);
                }
            }, null);
        }
    }

    public void registerComponents(final java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list) {
        if (this.mJSHandler == null || list == null || list.size() == 0) {
            return;
        }
        java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.24
            @Override // java.lang.Runnable
            public void run() {
                com.taobao.weex.bridge.WXBridgeManager wXBridgeManager = com.taobao.weex.bridge.WXBridgeManager.this;
                wXBridgeManager.invokeRegisterComponents(list, wXBridgeManager.mRegisterComponentFailList);
            }
        };
        if (isJSThread() && isJSFrameworkInit()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    public void execJSService(final java.lang.String str) {
        postWithName(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.25
            @Override // java.lang.Runnable
            public void run() {
                com.taobao.weex.bridge.WXBridgeManager wXBridgeManager = com.taobao.weex.bridge.WXBridgeManager.this;
                wXBridgeManager.invokeExecJSService(str, wXBridgeManager.mRegisterServiceFailList);
            }
        }, null, "execJSService");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeExecJSService(java.lang.String str, java.util.List<java.lang.String> list) {
        try {
            if (!isJSFrameworkInit()) {
                com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] invoke execJSService: framework.js uninitialized.");
                list.add(str);
            } else {
                this.mWXBridge.execJSService(str);
            }
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] invokeRegisterService:", th);
            java.util.HashMap map = new java.util.HashMap();
            map.put("inputParams", str + com.taobao.weex.el.parse.Operators.OR + list.toString());
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT("invokeExecJSService", com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_JSSERVICE_EXECUTE, "invokeExecJSService", com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_JSSERVICE_EXECUTE.getErrorMsg() + "[WXBridgeManager] invokeRegisterService:" + com.taobao.weex.utils.WXLogUtils.getStackTrace(th), map);
        }
    }

    public boolean isJSThread() {
        com.taobao.weex.common.WXThread wXThread = this.mJSThread;
        return wXThread != null && wXThread.getId() == java.lang.Thread.currentThread().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeRegisterModules(java.util.Map<java.lang.String, java.lang.Object> map, java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list) {
        java.lang.String str;
        if (map == null || !isJSFrameworkInit()) {
            if (!isJSFrameworkInit()) {
                com.taobao.weex.utils.WXLogUtils.d("[WXinvokeRegisterModulesBridgeManager] invokeRegisterModules: framework.js uninitialized.");
            }
            list.add(map);
            return;
        }
        com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr = {com.taobao.weex.utils.WXWsonJSONSwitch.toWsonOrJsonWXJSObject(map)};
        try {
            com.taobao.weex.common.IWXBridge iWXBridge = this.mWXBridge;
            if (iWXBridge instanceof com.taobao.weex.bridge.WXBridge) {
                ((com.taobao.weex.bridge.WXBridge) iWXBridge).registerModuleOnDataRenderNode(com.taobao.weex.utils.WXJsonUtils.fromObjectToJSONString(map));
            }
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXLogUtils.e("Weex [data_render register err]", th);
        }
        try {
            str = this.mWXBridge.execJS("", null, METHOD_REGISTER_MODULES, wXJSObjectArr) == 0 ? "execJS error" : null;
            try {
                for (java.lang.String str2 : map.keySet()) {
                    if (str2 != null) {
                        com.taobao.weex.bridge.WXModuleManager.resetModuleState(str2, true);
                    }
                }
            } catch (java.lang.Throwable th2) {
                com.taobao.weex.utils.WXLogUtils.e("Weex [invokeRegisterModules]", th2);
            }
        } catch (java.lang.Throwable th3) {
            str = com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_REGISTER_MODULES.getErrorMsg() + " \n " + th3.getMessage() + map.entrySet().toString();
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] invokeRegisterModules:", str);
        com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(null, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_REGISTER_MODULES, "invokeRegisterModules", str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeRegisterComponents(java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list, java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list2) {
        java.lang.String str;
        if (list == list2) {
            throw new java.lang.RuntimeException("Fail receiver should not use source.");
        }
        if (!isJSFrameworkInit()) {
            java.util.Iterator<java.util.Map<java.lang.String, java.lang.Object>> it = list.iterator();
            while (it.hasNext()) {
                list2.add(it.next());
            }
            return;
        }
        if (list == null) {
            return;
        }
        try {
            com.taobao.weex.common.IWXBridge iWXBridge = this.mWXBridge;
            if (iWXBridge instanceof com.taobao.weex.bridge.WXBridge) {
                ((com.taobao.weex.bridge.WXBridge) iWXBridge).registerComponentOnDataRenderNode(com.taobao.weex.utils.WXJsonUtils.fromObjectToJSONString(list));
            }
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXLogUtils.e("Weex [data_render register err]", th);
        }
        com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr = {com.taobao.weex.utils.WXWsonJSONSwitch.toWsonOrJsonWXJSObject(list)};
        try {
            str = this.mWXBridge.execJS("", null, METHOD_REGISTER_COMPONENTS, wXJSObjectArr) == 0 ? "execJS error" : null;
        } catch (java.lang.Throwable th2) {
            str = com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_REGISTER_COMPONENT + wXJSObjectArr.toString() + com.taobao.weex.utils.WXLogUtils.getStackTrace(th2);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] invokeRegisterComponents ", str);
        com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(null, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_REGISTER_COMPONENT, METHOD_REGISTER_COMPONENTS, str, null);
    }

    public void destroy() {
        com.taobao.weex.common.WXThread wXThread = this.mJSThread;
        if (wXThread != null) {
            wXThread.quit();
        }
        mBridgeManager = null;
        java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null) {
            hashSet.clear();
        }
    }

    public void reportJSException(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.taobao.weex.WXSDKInstance sDKInstance;
        com.taobao.weex.common.WXErrorCode wXErrorCode;
        if (str2.startsWith("jsscope::")) {
            android.content.Context applicationContext = com.taobao.weex.WXEnvironment.getApplication().getApplicationContext();
            if (applicationContext != null && !io.dcloud.common.util.BaseInfo.isBase(applicationContext)) {
                str.hashCode();
                int i = 4;
                java.lang.String str4 = "uni-jsframework.js";
                switch (str) {
                    case "jsframework":
                    case "uni-jsframework.js":
                    case "jsfm":
                    case "service":
                        break;
                    case "app-service.js":
                        str4 = str;
                        i = 5;
                        break;
                    default:
                        com.taobao.weex.WXSDKInstance sDKInstance2 = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
                        if (sDKInstance2 != null) {
                            java.lang.String uniPagePath = sDKInstance2.getUniPagePath();
                            str4 = uniPagePath;
                            if (uniPagePath == "app-service.js") {
                                i = 5;
                            }
                            break;
                        } else {
                            str4 = str;
                        }
                        i = 6;
                        break;
                }
                org.json.JSONObject jSONObjectCreateJSONObject = io.dcloud.common.util.JSONUtil.createJSONObject(io.dcloud.common.util.AppRuntime.getUniStatistics());
                if (jSONObjectCreateJSONObject != null) {
                    java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONObjectCreateJSONObject, "version");
                    boolean z = io.dcloud.common.util.JSONUtil.getBoolean(jSONObjectCreateJSONObject, io.dcloud.common.adapter.ui.webview.WebLoadEvent.ENABLE);
                    if (io.dcloud.common.util.PdrUtil.isEquals("2", string) && z) {
                        io.dcloud.common.adapter.util.UEH.commitUncatchException(applicationContext, str4, str3, i);
                    }
                }
            }
            str2 = str2.substring(9);
        }
        com.taobao.weex.utils.WXLogUtils.e("reportJSException >>>> instanceId:" + str + ", exception function:" + str2 + ", exception:" + str3);
        com.taobao.weex.common.WXErrorCode wXErrorCode2 = com.taobao.weex.common.WXErrorCode.WX_ERR_JS_EXECUTE;
        if (str != null && (sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str)) != null) {
            sDKInstance.setHasException(true);
            if (METHOD_CREATE_INSTANCE.equals(str2) || !sDKInstance.isContentMd5Match()) {
                try {
                    if (!isSkipFrameworkInit(str) && isJSFrameworkInit() && reInitCount > 1 && reInitCount < 10 && !sDKInstance.isNeedReLoad()) {
                        new com.taobao.weex.ui.action.ActionReloadPage(str, true).executeAction();
                        sDKInstance.setNeedLoad(true);
                        return;
                    }
                    sDKInstance.onRenderError(com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorCode(), com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorMsg() + ", reportJSException >>>> instanceId:" + str + ", exception function:" + str2 + ", exception:" + str3 + ", extInitTime:" + (java.lang.System.currentTimeMillis() - sInitFrameWorkTimeOrigin) + "ms, extInitErrorMsg:" + sInitFrameWorkMsg.toString());
                    if (com.taobao.weex.WXEnvironment.sInAliWeex) {
                        return;
                    }
                    com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_JS_CREATE_INSTANCE, str2, str3, null);
                    return;
                } catch (java.lang.Exception e) {
                    com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
                }
            }
            if (METHOD_CREATE_INSTANCE.equals(str2) && !sDKInstance.getApmForInstance().hasAddView) {
                wXErrorCode = com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_JS_CREATE_INSTANCE;
            } else if (METHOD_CREATE_INSTANCE_CONTEXT.equals(str2) && !sDKInstance.getApmForInstance().hasAddView) {
                wXErrorCode = com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_JS_CREATE_INSTANCE_CONTEXT;
            } else if ((METHOD_UPDATE_COMPONENT_WITH_DATA.equals(str2) || METHOD_CREATE_PAGE_WITH_CONTENT.equals(str2) || METHOD_POST_TASK_TO_MSG_LOOP.equals(str2) || METHOD_JSFM_NOT_INIT_IN_EAGLE_MODE.equals(str2)) && !sDKInstance.getApmForInstance().hasAddView) {
                wXErrorCode = com.taobao.weex.common.WXErrorCode.WX_DEGRAD_EAGLE_RENDER_ERROR;
            } else {
                if (METHOD_CHECK_APPKEY.equals(str2)) {
                    wXErrorCode = com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_VALIDAPPKEY;
                }
                sDKInstance.onJSException(wXErrorCode2.getErrorCode(), str2, str3);
            }
            wXErrorCode2 = wXErrorCode;
            sDKInstance.onJSException(wXErrorCode2.getErrorCode(), str2, str3);
        }
        doReportJSException(str, str2, wXErrorCode2, str3);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00bb  */
    private void doReportJSException(java.lang.String str, java.lang.String str2, com.taobao.weex.common.WXErrorCode wXErrorCode, java.lang.String str3) {
        java.lang.String str4;
        java.lang.String string;
        com.taobao.weex.WXSDKInstance wXSDKInstance = com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().get(str);
        if (com.taobao.weex.WXSDKManager.getInstance().getIWXJSExceptionAdapter() != null) {
            if (android.text.TextUtils.isEmpty(str)) {
                str = "instanceIdisNull";
            }
            if (wXSDKInstance == null && com.taobao.weex.adapter.IWXUserTrackAdapter.INIT_FRAMEWORK.equals(str2)) {
                try {
                    if (com.taobao.weex.WXEnvironment.getApplication() != null) {
                        try {
                            java.io.File file = new java.io.File(com.taobao.weex.WXEnvironment.getApplication().getApplicationContext().getCacheDir().getPath() + INITLOGFILE);
                            if (file.exists()) {
                                if (file.length() > 0) {
                                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                    try {
                                        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file), "UTF-8"));
                                        while (true) {
                                            java.lang.String line = bufferedReader.readLine();
                                            if (line == null) {
                                                break;
                                            }
                                            sb.append(line + "\n");
                                            try {
                                                com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
                                                string = str4;
                                            } catch (java.lang.Throwable th) {
                                                th = th;
                                                try {
                                                    com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
                                                } catch (java.lang.Throwable th2) {
                                                    th = th2;
                                                    com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
                                                    string = str4;
                                                    str3 = str3 + "\n" + string;
                                                    com.taobao.weex.utils.WXLogUtils.e("reportJSException:" + str3);
                                                    com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, wXErrorCode, str2, wXErrorCode.getErrorMsg() + str3, null);
                                                }
                                                string = str4;
                                            }
                                        }
                                        string = sb.toString();
                                        try {
                                            try {
                                                bufferedReader.close();
                                            } catch (java.lang.Exception e) {
                                                str4 = string;
                                                e = e;
                                                com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
                                                string = str4;
                                            }
                                        } catch (java.lang.Throwable th3) {
                                            str4 = string;
                                            th = th3;
                                            com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
                                            string = str4;
                                        }
                                    } catch (java.lang.Exception e2) {
                                        e = e2;
                                        str4 = null;
                                    }
                                } else {
                                    string = null;
                                }
                                file.delete();
                            } else {
                                string = null;
                            }
                        } catch (java.lang.Throwable th4) {
                            th = th4;
                            str4 = null;
                        }
                    } else {
                        string = null;
                    }
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    str4 = null;
                }
                str3 = str3 + "\n" + string;
                com.taobao.weex.utils.WXLogUtils.e("reportJSException:" + str3);
            }
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, wXErrorCode, str2, wXErrorCode.getErrorMsg() + str3, null);
        }
    }

    private void registerDomModule() throws com.taobao.weex.common.WXException {
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.taobao.weex.ui.module.WXDomModule.WXDOM, com.taobao.weex.ui.module.WXDomModule.METHODS);
        registerModules(map);
    }

    public static void updateGlobalConfig(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            str = "none";
        }
        if (android.text.TextUtils.equals(str, globalConfig)) {
            return;
        }
        globalConfig = str;
        com.taobao.weex.WXEnvironment.addCustomOptions(GLOBAL_CONFIG_KEY, str);
        java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.26
            @Override // java.lang.Runnable
            public void run() {
                if (com.taobao.weex.bridge.WXBridgeManager.mBridgeManager != null && com.taobao.weex.bridge.WXBridgeManager.mBridgeManager.isJSFrameworkInit() && (com.taobao.weex.bridge.WXBridgeManager.mBridgeManager.mWXBridge instanceof com.taobao.weex.bridge.WXBridge)) {
                    ((com.taobao.weex.bridge.WXBridge) com.taobao.weex.bridge.WXBridgeManager.mBridgeManager.mWXBridge).nativeUpdateGlobalConfig(com.taobao.weex.bridge.WXBridgeManager.globalConfig);
                }
                if (com.taobao.weex.bridge.WXBridgeManager.globalConfig.contains(com.taobao.weex.utils.WXWsonJSONSwitch.WSON_OFF)) {
                    com.taobao.weex.utils.WXWsonJSONSwitch.USE_WSON = false;
                } else {
                    com.taobao.weex.utils.WXWsonJSONSwitch.USE_WSON = true;
                }
            }
        };
        if (mBridgeManager != null && mBridgeManager.isJSFrameworkInit()) {
            mBridgeManager.post(runnable);
        } else {
            runnable.run();
        }
    }

    public android.os.Looper getJSLooper() {
        com.taobao.weex.common.WXThread wXThread = this.mJSThread;
        if (wXThread != null) {
            return wXThread.getLooper();
        }
        return null;
    }

    public void notifySerializeCodeCache() {
        post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.27
            @Override // java.lang.Runnable
            public void run() {
                if (com.taobao.weex.bridge.WXBridgeManager.this.isJSFrameworkInit()) {
                    com.taobao.weex.bridge.WXBridgeManager.this.invokeExecJS("", null, com.taobao.weex.bridge.WXBridgeManager.METHOD_NOTIFY_SERIALIZE_CODE_CACHE, new com.taobao.weex.bridge.WXJSObject[0]);
                }
            }
        });
    }

    public void takeJSHeapSnapshot(java.lang.String str) {
        android.os.Message messageObtainMessage = this.mJSHandler.obtainMessage();
        messageObtainMessage.obj = str;
        messageObtainMessage.what = 13;
        messageObtainMessage.setTarget(this.mJSHandler);
        messageObtainMessage.sendToTarget();
    }

    public int callCreateBody(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.HashMap<java.lang.String, java.lang.String> map, java.util.HashMap<java.lang.String, java.lang.String> map2, java.util.HashSet<java.lang.String> hashSet, float[] fArr, float[] fArr2, float[] fArr3) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callCreateBody arguments is null");
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callCreateBody", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        java.util.HashSet<java.lang.String> hashSet2 = this.mDestroyedInstanceId;
        if (hashSet2 != null && hashSet2.contains(str)) {
            return -1;
        }
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance == null) {
                return 1;
            }
            com.taobao.weex.ui.action.GraphicActionCreateBody graphicActionCreateBody = new com.taobao.weex.ui.action.GraphicActionCreateBody(sDKInstance, str3, str2, map, map2, hashSet, fArr, fArr2, fArr3);
            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(graphicActionCreateBody.getPageId(), graphicActionCreateBody);
            return 1;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callCreateBody exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callCreateBody", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callAddElement(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.String str4, java.util.HashMap<java.lang.String, java.lang.String> map, java.util.HashMap<java.lang.String, java.lang.String> map2, java.util.HashSet<java.lang.String> hashSet, float[] fArr, float[] fArr2, float[] fArr3, boolean z) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callAddElement arguments is null");
            }
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callAddElement", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        java.util.HashSet<java.lang.String> hashSet2 = this.mDestroyedInstanceId;
        if (hashSet2 != null && hashSet2.contains(str)) {
            return -1;
        }
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance == null) {
                return 1;
            }
            com.taobao.weex.ui.action.GraphicActionAddElement graphicActionAddElement = new com.taobao.weex.ui.action.GraphicActionAddElement(sDKInstance, str3, str2, str4, i, map, map2, hashSet, fArr, fArr2, fArr3);
            if (z) {
                sDKInstance.addInActiveAddElementAction(str3, graphicActionAddElement);
                return 1;
            }
            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(str, graphicActionAddElement);
            return 1;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callAddElement exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callAddElement", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callRemoveElement(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callRemoveElement arguments is null");
            }
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callRemoveElement", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance == null) {
                return 1;
            }
            com.taobao.weex.ui.action.GraphicActionRemoveElement graphicActionRemoveElement = new com.taobao.weex.ui.action.GraphicActionRemoveElement(sDKInstance, str2);
            if (sDKInstance.getInActiveAddElementAction(str2) != null) {
                sDKInstance.removeInActiveAddElmentAction(str2);
                return 1;
            }
            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(graphicActionRemoveElement.getPageId(), graphicActionRemoveElement);
            return 1;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callRemoveElement exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callRemoveElement", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callMoveElement(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callMoveElement arguments is null");
            }
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callMoveElement", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance == null) {
                return 1;
            }
            com.taobao.weex.ui.action.GraphicActionMoveElement graphicActionMoveElement = new com.taobao.weex.ui.action.GraphicActionMoveElement(sDKInstance, str2, str3, i);
            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(graphicActionMoveElement.getPageId(), graphicActionMoveElement);
            return 1;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callMoveElement exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callMoveElement", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callAddEvent(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callAddEvent arguments is null");
            }
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callAddEvent", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance != null) {
                new com.taobao.weex.ui.action.GraphicActionAddEvent(sDKInstance, str2, str3).executeActionOnRender();
            }
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callAddEvent exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callAddEvent", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
        }
        getNextTick(str);
        return 1;
    }

    public int callRemoveEvent(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callRemoveEvent arguments is null");
            }
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callRemoveEvent", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance != null) {
                new com.taobao.weex.ui.action.GraphicActionRemoveEvent(sDKInstance, str2, str3).executeActionOnRender();
            }
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callRemoveEvent exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callRemoveEvent", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
        }
        getNextTick(str);
        return 1;
    }

    public int callUpdateStyle(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.Object> map, java.util.HashMap<java.lang.String, java.lang.String> map2, java.util.HashMap<java.lang.String, java.lang.String> map3, java.util.HashMap<java.lang.String, java.lang.String> map4) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callUpdateStyle arguments is null");
            }
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callUpdateStyle", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance == null) {
                return 1;
            }
            com.taobao.weex.ui.action.GraphicActionUpdateStyle graphicActionUpdateStyle = new com.taobao.weex.ui.action.GraphicActionUpdateStyle(sDKInstance, str2, map, map2, map3, map4);
            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(graphicActionUpdateStyle.getPageId(), graphicActionUpdateStyle);
            return 1;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callUpdateStyle exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callUpdateStyle", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callUpdateAttrs(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callUpdateAttrs arguments is null");
            }
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callUpdateAttrs", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance == null) {
                return 1;
            }
            com.taobao.weex.ui.action.GraphicActionUpdateAttr graphicActionUpdateAttr = new com.taobao.weex.ui.action.GraphicActionUpdateAttr(sDKInstance, str2, map);
            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(graphicActionUpdateAttr.getPageId(), graphicActionUpdateAttr);
            return 1;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callUpdateAttrs exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callUpdateAttrs", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    private void setExceedGPULimitComponentsInfo(java.lang.String str, java.lang.String str2, com.taobao.weex.ui.action.GraphicSize graphicSize) {
        float openGLRenderLimitValue = com.taobao.weex.ui.WXRenderManager.getOpenGLRenderLimitValue();
        if (openGLRenderLimitValue > 0.0f) {
            if (graphicSize.getHeight() > openGLRenderLimitValue || graphicSize.getWidth() > openGLRenderLimitValue) {
                com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                com.taobao.weex.ui.component.WXComponent wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(str, str2);
                jSONObject.put("GPU limit", (java.lang.Object) java.lang.String.valueOf(openGLRenderLimitValue));
                jSONObject.put("component.width", (java.lang.Object) java.lang.String.valueOf(graphicSize.getWidth()));
                jSONObject.put("component.height", (java.lang.Object) java.lang.String.valueOf(graphicSize.getHeight()));
                if (wXComponent.getComponentType() != null && !wXComponent.getComponentType().isEmpty()) {
                    jSONObject.put("component.type", (java.lang.Object) wXComponent.getComponentType());
                }
                if (wXComponent.getStyles() != null && !wXComponent.getStyles().isEmpty()) {
                    jSONObject.put("component.style", (java.lang.Object) wXComponent.getStyles().toString());
                }
                if (wXComponent.getAttrs() != null && !wXComponent.getAttrs().isEmpty()) {
                    jSONObject.put("component.attr", (java.lang.Object) wXComponent.getAttrs().toString());
                }
                if (wXComponent.getEvents() != null && !wXComponent.getEvents().isEmpty()) {
                    jSONObject.put("component.event", (java.lang.Object) wXComponent.getEvents().toString());
                }
                if (wXComponent.getMargin() != null) {
                    jSONObject.put("component.margin", (java.lang.Object) wXComponent.getMargin().toString());
                }
                if (wXComponent.getPadding() != null) {
                    jSONObject.put("component.padding", (java.lang.Object) wXComponent.getPadding().toString());
                }
                if (wXComponent.getBorder() != null) {
                    jSONObject.put("component.border", (java.lang.Object) wXComponent.getBorder().toString());
                }
                com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str).setComponentsInfoExceedGPULimit(jSONObject);
            }
        }
    }

    public int callAddChildToRichtext(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.util.HashMap<java.lang.String, java.lang.String> map, java.util.HashMap<java.lang.String, java.lang.String> map2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str3)) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callAddChildToRichtext arguments is null");
            }
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callAddChildToRichtext", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance == null) {
                return 1;
            }
            com.taobao.weex.ui.action.GraphicActionAddChildToRichtext graphicActionAddChildToRichtext = new com.taobao.weex.ui.action.GraphicActionAddChildToRichtext(sDKInstance, str2, str3, str4, str5, map, map2);
            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(graphicActionAddChildToRichtext.getPageId(), graphicActionAddChildToRichtext);
            return 1;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callAddChildToRichtext exception: ", com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callAddChildToRichtext", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callRemoveChildFromRichtext(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callRemoveChildFromRichtext arguments is null");
            }
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callRemoveChildFromRichtext", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance == null) {
                return 1;
            }
            com.taobao.weex.ui.action.GraphicActionRemoveChildFromRichtext graphicActionRemoveChildFromRichtext = new com.taobao.weex.ui.action.GraphicActionRemoveChildFromRichtext(sDKInstance, str2, str3, str4);
            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(graphicActionRemoveChildFromRichtext.getPageId(), graphicActionRemoveChildFromRichtext);
            return 1;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callRemoveChildFromRichtext exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callRemoveChildFromRichtext", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public void callBacthStart(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callRemoveChildFromRichtext arguments is null");
            }
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callRemoveChildFromRichtext", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return;
        }
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance != null) {
                com.taobao.weex.ui.action.GraphicActionBatchBegin graphicActionBatchBegin = new com.taobao.weex.ui.action.GraphicActionBatchBegin(sDKInstance, "");
                com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(graphicActionBatchBegin.getPageId(), graphicActionBatchBegin);
            }
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callRemoveChildFromRichtext exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callRemoveChildFromRichtext", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
        }
    }

    public void callBacthEnd(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callRemoveChildFromRichtext arguments is null");
            }
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callRemoveChildFromRichtext", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return;
        }
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance != null) {
                com.taobao.weex.ui.action.GraphicActionBatchEnd graphicActionBatchEnd = new com.taobao.weex.ui.action.GraphicActionBatchEnd(sDKInstance, "");
                com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(graphicActionBatchEnd.getPageId(), graphicActionBatchEnd);
            }
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callRemoveChildFromRichtext exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callRemoveChildFromRichtext", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
        }
    }

    public int callUpdateRichtextStyle(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map, java.lang.String str3, java.lang.String str4) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callUpdateRichtextStyle arguments is null");
            }
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callUpdateRichtextStyle", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance == null) {
                return 1;
            }
            com.taobao.weex.ui.action.GraphicActionUpdateRichtextStyle graphicActionUpdateRichtextStyle = new com.taobao.weex.ui.action.GraphicActionUpdateRichtextStyle(sDKInstance, str2, map, str3, str4);
            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(graphicActionUpdateRichtextStyle.getPageId(), graphicActionUpdateRichtextStyle);
            return 1;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callUpdateRichtextStyle exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callUpdateRichtextStyle", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callUpdateRichtextChildAttr(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map, java.lang.String str3, java.lang.String str4) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callUpdateRichtextChildAttr arguments is null");
            }
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callUpdateRichtextChildAttr", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance == null) {
                return 1;
            }
            com.taobao.weex.ui.action.GraphicActionUpdateRichtextAttr graphicActionUpdateRichtextAttr = new com.taobao.weex.ui.action.GraphicActionUpdateRichtextAttr(sDKInstance, str2, map, str3, str4);
            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(graphicActionUpdateRichtextAttr.getPageId(), graphicActionUpdateRichtextAttr);
            return 1;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callUpdateRichtextChildAttr exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callUpdateRichtextChildAttr", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callLayout(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, int i6, boolean z, int i7) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callLayout arguments is null");
            }
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callLayout", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance == null) {
                return 1;
            }
            com.taobao.weex.ui.action.GraphicSize graphicSize = new com.taobao.weex.ui.action.GraphicSize(i6, i5);
            com.taobao.weex.ui.action.GraphicPosition graphicPosition = new com.taobao.weex.ui.action.GraphicPosition(i3, i, i4, i2);
            setExceedGPULimitComponentsInfo(str, str2, graphicSize);
            com.taobao.weex.ui.action.GraphicActionAddElement inActiveAddElementAction = sDKInstance.getInActiveAddElementAction(str2);
            if (inActiveAddElementAction != null) {
                inActiveAddElementAction.setRTL(z);
                inActiveAddElementAction.setSize(graphicSize);
                inActiveAddElementAction.setPosition(graphicPosition);
                if (!android.text.TextUtils.equals(str2, com.taobao.weex.ui.component.WXComponent.ROOT)) {
                    inActiveAddElementAction.setIndex(i7);
                }
                com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(str, inActiveAddElementAction);
                sDKInstance.removeInActiveAddElmentAction(str2);
                return 1;
            }
            com.taobao.weex.ui.action.GraphicActionLayout graphicActionLayout = new com.taobao.weex.ui.action.GraphicActionLayout(sDKInstance, str2, graphicPosition, graphicSize, z);
            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(graphicActionLayout.getPageId(), graphicActionLayout);
            return 1;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callLayout exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callLayout", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callAppendTreeCreateFinish(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callAppendTreeCreateFinish arguments is null");
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callAppendTreeCreateFinish", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(str, new com.taobao.weex.ui.action.GraphicActionAppendTreeCreateFinish(com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str), str2));
            return 1;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callAppendTreeCreateFinish exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callAppendTreeCreateFinish", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callCreateFinish(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callCreateFinish arguments is null");
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callCreateFinish", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance == null) {
                return 1;
            }
            sDKInstance.firstScreenCreateInstanceTime(jCurrentTimeMillis);
            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(str, new com.taobao.weex.ui.action.GraphicActionCreateFinish(sDKInstance));
            return 1;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callCreateFinish exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callCreateFinish", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public int callRenderSuccess(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.taobao.weex.utils.WXLogUtils.d("[WXBridgeManager] call callRenderSuccess arguments is null");
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_BRIDGE_ARG_NULL, "callRenderSuccess", "arguments is empty, INSTANCE_RENDERING_ERROR will be set", null);
            return 0;
        }
        com.taobao.weex.WXEnvironment.isApkDebugable();
        java.util.HashSet<java.lang.String> hashSet = this.mDestroyedInstanceId;
        if (hashSet != null && hashSet.contains(str)) {
            return -1;
        }
        try {
            com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
            if (sDKInstance == null) {
                return 1;
            }
            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(str, new com.taobao.weex.ui.action.GraphicActionRenderSuccess(sDKInstance));
            return 1;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("[WXBridgeManager] callRenderSuccess exception: ", e);
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(str, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_BRIDGE, "callRenderSuccess", com.taobao.weex.utils.WXLogUtils.getStackTrace(e), null);
            return 1;
        }
    }

    public com.taobao.weex.layout.ContentBoxMeasurement getMeasurementFunc(java.lang.String str, long j) {
        com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(str);
        if (sDKInstance != null) {
            return sDKInstance.getContentBoxMeasurement(j);
        }
        return null;
    }

    public void bindMeasurementToRenderObject(long j) {
        if (isJSFrameworkInit()) {
            this.mWXBridge.bindMeasurementToRenderObject(j);
        }
    }

    public boolean notifyLayout(java.lang.String str) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            return this.mWXBridge.notifyLayout(str);
        }
        return false;
    }

    public void forceLayout(java.lang.String str) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.forceLayout(str);
        }
    }

    public void onInstanceClose(java.lang.String str) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.onInstanceClose(str);
        }
    }

    public void setDefaultRootSize(java.lang.String str, float f, float f2, boolean z, boolean z2) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setDefaultHeightAndWidthIntoRootDom(str, f, f2, z, z2);
        }
    }

    public void setRenderContentWrapContentToCore(boolean z, java.lang.String str) {
        if (isJSFrameworkInit()) {
            this.mWXBridge.setRenderContainerWrapContent(z, str);
        }
    }

    public void setStyleWidth(java.lang.String str, java.lang.String str2, float f) {
        setStyleWidth(str, str2, f, false);
    }

    public void setStyleWidth(java.lang.String str, java.lang.String str2, float f, boolean z) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setStyleWidth(str, str2, f, z);
        }
    }

    public void setStyleHeight(java.lang.String str, java.lang.String str2, float f) {
        setStyleHeight(str, str2, f, false);
    }

    public void setStyleHeight(java.lang.String str, java.lang.String str2, float f, boolean z) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setStyleHeight(str, str2, f, z);
        }
    }

    public long[] getFirstScreenRenderTime(java.lang.String str) {
        if (isJSFrameworkInit()) {
            return this.mWXBridge.getFirstScreenRenderTime(str);
        }
        return new long[]{0, 0, 0};
    }

    public long[] getRenderFinishTime(java.lang.String str) {
        if (isJSFrameworkInit()) {
            return this.mWXBridge.getRenderFinishTime(str);
        }
        return new long[]{0, 0, 0};
    }

    public void setDeviceDisplay(final java.lang.String str, final float f, final float f2, final float f3) {
        post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.28
            @Override // java.lang.Runnable
            public void run() {
                com.taobao.weex.bridge.WXBridgeManager.this.mWXBridge.setDeviceDisplay(str, f, f2, f3);
            }
        });
    }

    public void updateInitDeviceParams(final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final java.lang.String str4) {
        if (isJSFrameworkInit()) {
            post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.29
                @Override // java.lang.Runnable
                public void run() {
                    com.taobao.weex.bridge.WXBridgeManager.this.mWXBridge.updateInitFrameworkParams(com.taobao.weex.common.WXConfig.deviceWidth, str, com.taobao.weex.common.WXConfig.deviceWidth);
                }
            });
            post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.30
                @Override // java.lang.Runnable
                public void run() {
                    com.taobao.weex.bridge.WXBridgeManager.this.mWXBridge.updateInitFrameworkParams(com.taobao.weex.common.WXConfig.deviceHeight, str2, com.taobao.weex.common.WXConfig.deviceHeight);
                }
            });
            post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.31
                @Override // java.lang.Runnable
                public void run() {
                    com.taobao.weex.bridge.WXBridgeManager.this.mWXBridge.updateInitFrameworkParams("scale", str3, "scale");
                }
            });
            if (str4 != null) {
                post(new java.lang.Runnable() { // from class: com.taobao.weex.bridge.WXBridgeManager.32
                    @Override // java.lang.Runnable
                    public void run() {
                        com.taobao.weex.bridge.WXBridgeManager.this.mWXBridge.updateInitFrameworkParams(com.taobao.weex.common.WXConfig.androidStatusBarHeight, str4, com.taobao.weex.common.WXConfig.androidStatusBarHeight);
                    }
                });
            }
        }
    }

    public void setMargin(java.lang.String str, java.lang.String str2, com.taobao.weex.dom.CSSShorthand.EDGE edge, float f) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setMargin(str, str2, edge, f);
        }
    }

    public void setPadding(java.lang.String str, java.lang.String str2, com.taobao.weex.dom.CSSShorthand.EDGE edge, float f) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setPadding(str, str2, edge, f);
        }
    }

    public void setPosition(java.lang.String str, java.lang.String str2, com.taobao.weex.dom.CSSShorthand.EDGE edge, float f) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setPosition(str, str2, edge, f);
        }
    }

    public void markDirty(java.lang.String str, java.lang.String str2, boolean z) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.markDirty(str, str2, z);
        }
    }

    public void setPageArgument(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setPageArgument(str, str2, str3);
        }
    }

    public void reloadPageLayout(java.lang.String str) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.reloadPageLayout(str);
        }
    }

    public void setDeviceDisplayOfPage(java.lang.String str, float f, float f2) {
        if (isSkipFrameworkInit(str) || isJSFrameworkInit()) {
            this.mWXBridge.setDeviceDisplayOfPage(str, f, f2);
        }
    }

    public int callHasTransitionPros(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map) {
        com.taobao.weex.ui.component.WXComponent wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(str, str2);
        if (wXComponent == null || wXComponent.getTransition() == null || wXComponent.getTransition().getProperties() == null) {
            return -1;
        }
        java.util.Iterator<java.lang.String> it = wXComponent.getTransition().getProperties().iterator();
        while (it.hasNext()) {
            if (map.containsKey(it.next())) {
                return 1;
            }
        }
        return 0;
    }

    public void registerCoreEnv(java.lang.String str, java.lang.String str2) {
        if (isJSFrameworkInit()) {
            this.mWXBridge.registerCoreEnv(str, str2);
        } else {
            mWeexCoreEnvOptions.put(str, str2);
        }
    }

    private void onJsFrameWorkInitSuccees() {
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : mWeexCoreEnvOptions.entrySet()) {
            this.mWXBridge.registerCoreEnv(entry.getKey(), entry.getValue());
        }
        mWeexCoreEnvOptions.clear();
    }

    public void setViewPortWidth(java.lang.String str, float f) {
        if (isJSFrameworkInit()) {
            this.mWXBridge.setViewPortWidth(str, f);
        }
    }

    public void setFlexDirectionDef(java.lang.String str) {
        if (isJSFrameworkInit()) {
            this.mWXBridge.setFlexDirectionDef(str);
        }
    }

    public java.lang.String getWeexCoreThreadStackTrace() {
        if (this.mJSThread == null) {
            return "null == mJSThread";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            sb.append(io.dcloud.common.util.StringUtil.format("Thread Name: '%s'\n", this.mJSThread.getName()));
            sb.append(java.lang.String.format(java.util.Locale.ENGLISH, "\"%s\" prio=%d tid=%d %s\n", this.mJSThread.getName(), java.lang.Integer.valueOf(this.mJSThread.getPriority()), java.lang.Long.valueOf(this.mJSThread.getId()), this.mJSThread.getState()));
            for (java.lang.StackTraceElement stackTraceElement : this.mJSThread.getStackTrace()) {
                sb.append(io.dcloud.common.util.StringUtil.format("\tat %s\n", stackTraceElement.toString()));
            }
        } catch (java.lang.Exception e) {
            android.util.Log.e("weex", "getJSThreadStackTrace error:", e);
        }
        return sb.toString();
    }

    public java.lang.String encryptGetClientKeyPayload(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.taobao.weex.common.IWXBridge iWXBridge = this.mWXBridge;
        if (iWXBridge instanceof com.taobao.weex.bridge.WXBridge) {
            return ((com.taobao.weex.bridge.WXBridge) iWXBridge).encryptGetClientKeyPayload(str, str2, str3);
        }
        return "";
    }

    public java.lang.String encrypt(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.taobao.weex.common.IWXBridge iWXBridge = this.mWXBridge;
        if (iWXBridge instanceof com.taobao.weex.bridge.WXBridge) {
            return ((com.taobao.weex.bridge.WXBridge) iWXBridge).encrypt(str, str2, str3, str4);
        }
        return "";
    }

    public java.lang.String decrypt(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.taobao.weex.common.IWXBridge iWXBridge = this.mWXBridge;
        if (iWXBridge instanceof com.taobao.weex.bridge.WXBridge) {
            return ((com.taobao.weex.bridge.WXBridge) iWXBridge).decrypt(str, str2, str3, str4);
        }
        return "";
    }

    public boolean verifyClientKeyPayload(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.taobao.weex.common.IWXBridge iWXBridge = this.mWXBridge;
        if (iWXBridge instanceof com.taobao.weex.bridge.WXBridge) {
            return ((com.taobao.weex.bridge.WXBridge) iWXBridge).verifyClientKeyPayload(str, str2, str3);
        }
        return false;
    }
}
