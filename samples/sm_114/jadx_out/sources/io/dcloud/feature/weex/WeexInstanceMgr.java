package io.dcloud.feature.weex;

/* JADX INFO: loaded from: classes2.dex */
public class WeexInstanceMgr implements com.taobao.weex.IWXStatisticsListener, io.dcloud.common.DHInterface.IUniInstanceMgr {
    static final java.lang.String SERVICE_NAME = "weexPlus";
    private static io.dcloud.feature.weex.WeexInstanceMgr instance;
    private io.dcloud.common.DHInterface.AbsMgr featureMgr;
    private io.dcloud.common.DHInterface.IConfusionMgr mConfusionMgr;
    private android.os.Handler mHandler;
    private io.dcloud.common.DHInterface.ICallBack mRestartReadyCall;
    private java.lang.StringBuffer sb;
    java.lang.String TAG = "WeexInstanceMgr";
    private java.util.LinkedHashMap<java.lang.String, io.dcloud.feature.weex.WXViewWrapper> instanceHashMap = new java.util.LinkedHashMap<>(16);
    private java.util.HashMap<java.lang.String, io.dcloud.feature.weex.WXServiceWrapper> serviceWrapperMapsCache = new java.util.HashMap<>(3);
    private java.util.ArrayList<io.dcloud.feature.weex.WeexInstanceMgr.IWXStatisticsCallBack> callBacks = new java.util.ArrayList<>();
    private java.lang.String mUniNViewModules = null;
    private java.util.ArrayList<io.dcloud.common.DHInterface.ICallBack> mReladyCallBacks = new java.util.ArrayList<>();
    private java.lang.String complier = "weex";
    private java.lang.String render = "auto";
    private java.lang.String jsSACName = "uni-app-config";
    private java.lang.String control = io.dcloud.common.constant.AbsoluteConst.UNI_V3;
    private int mVueVersion = 2;
    private boolean isWeexInitEnd = false;
    private boolean isJsFrameworkReady = false;
    private android.app.Application mApplication = null;
    private boolean isAssetsRes = false;
    private boolean isJSFKFileNotFound = false;
    private boolean isUniServiceCreated = false;
    private java.lang.String mPreUniAppid = null;
    private java.lang.String mPreInstanceId = null;
    private java.util.Map<java.lang.String, io.dcloud.common.DHInterface.ICallBack> mPreUniMPCallBackMap = new java.util.HashMap();

    interface EachListener<T> {
        void onEach(T t);
    }

    public interface IWXStatisticsCallBack {
        void onJsFrameworkReady();
    }

    @Override // com.taobao.weex.IWXStatisticsListener
    public void onException(java.lang.String str, java.lang.String str2, java.lang.String str3) {
    }

    @Override // com.taobao.weex.IWXStatisticsListener
    public void onFirstScreen() {
    }

    @Override // com.taobao.weex.IWXStatisticsListener
    public void onFirstView() {
    }

    @Override // com.taobao.weex.IWXStatisticsListener
    public void onHeadersReceived() {
    }

    @Override // com.taobao.weex.IWXStatisticsListener
    public void onHttpFinish() {
    }

    @Override // com.taobao.weex.IWXStatisticsListener
    public void onHttpStart() {
    }

    @Override // com.taobao.weex.IWXStatisticsListener
    public void onJsFrameworkStart() {
    }

    @Override // com.taobao.weex.IWXStatisticsListener
    public void onSDKEngineInitialize() {
    }

    public static synchronized io.dcloud.feature.weex.WeexInstanceMgr self() {
        if (instance == null) {
            instance = new io.dcloud.feature.weex.WeexInstanceMgr();
        }
        return instance;
    }

    public void setUniNViewModules(java.lang.String str) {
        this.mUniNViewModules = str;
        if (this.mReladyCallBacks.size() > 0) {
            java.util.Iterator<io.dcloud.common.DHInterface.ICallBack> it = this.mReladyCallBacks.iterator();
            while (it.hasNext()) {
                it.next().onCallBack(0, str);
            }
            this.mReladyCallBacks.clear();
        }
    }

    public java.lang.String getUniNViewModules() {
        return this.mUniNViewModules;
    }

    public void setUniNViewModuleReladyCallBack(io.dcloud.common.DHInterface.ICallBack iCallBack) {
        if (this.mReladyCallBacks.contains(iCallBack)) {
            return;
        }
        this.mReladyCallBacks.add(iCallBack);
    }

    void init(io.dcloud.common.DHInterface.AbsMgr absMgr) {
        this.featureMgr = absMgr;
    }

    public java.lang.String getUniMPFeature() {
        return "UniMP".toLowerCase(java.util.Locale.ENGLISH);
    }

    @Override // io.dcloud.common.DHInterface.IUniInstanceMgr
    public void initWeexEnv(io.dcloud.common.DHInterface.INativeAppInfo iNativeAppInfo) {
        if (iNativeAppInfo != null) {
            this.mConfusionMgr = iNativeAppInfo.getCofusionMgr();
            initWeexEnv(iNativeAppInfo.getApplication());
        }
    }

    public void initWeexEnv(android.app.Application application) {
        if (!io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex.WeexDevtoolImpl", "registerReloadReceiver", null, new java.lang.Class[]{android.app.Application.class}, new java.lang.Object[]{application});
        }
        self().setApplication(application);
        if (com.taobao.weex.WXSDKEngine.isInitialized()) {
            return;
        }
        com.taobao.weex.InitConfig.Builder builder = new com.taobao.weex.InitConfig.Builder();
        self().initAppForPath(application, null);
        self().initJSFramework(application, null);
        if (!io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex.WeexDevtoolImpl", "initDebugEnvironment", null, new java.lang.Class[]{android.app.Application.class}, new java.lang.Object[]{application});
        }
        io.dcloud.feature.weex.adapter.DCWXHttpAdapter dCWXHttpAdapter = new io.dcloud.feature.weex.adapter.DCWXHttpAdapter();
        builder.setHttpAdapter(dCWXHttpAdapter);
        com.facebook.drawee.backends.pipeline.Fresco.initialize(application, io.dcloud.feature.weex.adapter.Fresco.imagepipeline.OkHttpImagePipelineConfigFactory.newBuilder(application, dCWXHttpAdapter.getImageOkHttpClient()).build());
        com.alibaba.fastjson.JSON.setDefaultTypeKey("@type_ft");
        io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeView.initialize(com.facebook.drawee.backends.pipeline.Fresco.getDraweeControllerBuilderSupplier());
        builder.setImgAdapter(new io.dcloud.feature.weex.adapter.FrescoImageAdapter());
        builder.setDrawableLoader(new io.dcloud.feature.weex.adapter.FrescoDrawableLoader(application));
        builder.setURIAdapter(new io.dcloud.feature.weex.adapter.PlusUriAdapter());
        builder.setDCVueBridgeAdapter(new io.dcloud.feature.weex.adapter.DCVueBridgeAdapter());
        builder.setWebSocketAdapterFactory(new io.dcloud.feature.weex.adapter.DefaultWebSocketAdapterFactory());
        builder.setJSExceptionAdapter(new io.dcloud.feature.weex.adapter.JSExceptionAdapter());
        com.taobao.weex.InitConfig initConfigBuild = builder.build();
        com.taobao.weex.WXSDKManager.getInstance().setWxConfigAdapter(new io.dcloud.feature.weex.adapter.DCDefaultConfigAdapter());
        com.taobao.weex.WXSDKEngine.initialize(application, initConfigBuild);
        self().initStatisticsListener();
        try {
            java.lang.String str = new java.lang.String(io.dcloud.common.adapter.util.PlatformUtil.getFileContent("io/dcloud/weexUniJs.js", 1));
            this.sb = new java.lang.StringBuffer();
            java.lang.String configParam = self().getConfigParam();
            this.sb.append("var plusContext = {};plusContext.getLocationHerf = function(plus){\n    return plus.weex.config.bundleUrl;\n};var param = " + configParam + ";");
            this.sb.append(str);
            com.taobao.weex.WXSDKEngine.registerComponent("image", (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) io.dcloud.feature.weex.adapter.FrescoImageComponent.class);
            com.taobao.weex.WXSDKEngine.registerComponent("cover-view", (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) io.dcloud.feature.weex.extend.DCCoverViewComponent.class);
            com.taobao.weex.WXSDKEngine.registerComponent("u-image", (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) io.dcloud.feature.weex.adapter.FrescoImageComponentU.class);
            com.taobao.weex.WXSDKEngine.registerComponent("cover-image", (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) io.dcloud.feature.weex.extend.DCCoverImageComponent.class);
            com.taobao.weex.WXSDKEngine.registerComponent((com.taobao.weex.ui.IFComponentHolder) new com.taobao.weex.ui.SimpleComponentHolder(io.dcloud.feature.weex.adapter.ScalableViewComponent.class, new io.dcloud.feature.weex.adapter.ScalableViewComponent.Ceator()), false, "u-scalable");
            com.taobao.weex.WXSDKEngine.registerComponent((com.taobao.weex.ui.IFComponentHolder) new com.taobao.weex.ui.SimpleComponentHolder(io.dcloud.feature.weex.extend.DCWXSlider.class, new io.dcloud.feature.weex.extend.DCWXSlider.Creator()), true, com.taobao.weex.ui.component.WXBasicComponentType.SLIDER);
            com.taobao.weex.WXSDKEngine.registerComponent((com.taobao.weex.ui.IFComponentHolder) new com.taobao.weex.ui.SimpleComponentHolder(io.dcloud.feature.weex.extend.DCWXView.class, new io.dcloud.feature.weex.extend.DCWXView.Ceator()), false, com.taobao.weex.ui.component.WXBasicComponentType.VIEW);
            com.taobao.weex.WXSDKEngine.registerComponent("u-web-view", (java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent>) io.dcloud.feature.weex.adapter.webview.WXDCWeb.class);
            com.taobao.weex.WXSDKEngine.registerModule(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_PLUS, io.dcloud.feature.weex.extend.PlusModule.class);
            com.taobao.weex.WXSDKEngine.registerModule("DCloud-Crypto", io.dcloud.feature.weex.extend.RandomBytesModule.class);
            com.taobao.weex.WXSDKEngine.registerModule("plusstorage", io.dcloud.feature.weex.extend.PlusStorageModule.class);
            com.taobao.weex.WXSDKEngine.registerModule("uni-tabview", io.dcloud.feature.weex.extend.DCTabBarModule.class);
            addComponentByName(com.taobao.weex.ui.component.WXBasicComponentType.DIV, io.dcloud.feature.weex.adapter.ScalableViewComponent.class);
            if (io.dcloud.common.util.PdrUtil.isUniMPHostForUniApp() && !io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
                com.taobao.weex.WXSDKEngine.registerModule("uniMP", io.dcloud.feature.weex.extend.DCUniMPModule.class);
            }
            com.taobao.weex.WXSDKEngine.registerModule("event", io.dcloud.feature.weex.extend.WXEventModule.class);
            if (this.sb != null) {
                com.taobao.weex.WXSDKEngine.registerService(SERVICE_NAME, this.sb.toString(), new java.util.HashMap());
            }
            if (!io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
                self().registerUniappService(application, "");
            }
            com.taobao.weex.WXEnvironment.setGlobalFontFamily("unincomponents", android.graphics.Typeface.createFromAsset(application.getAssets(), "fonts/unincomponents.ttf"));
            com.taobao.weex.WXSDKEngine.registerModule("uni-webSocket", io.dcloud.feature.weex_websocket.UniWebSocketModule.class);
            com.alibaba.android.bindingx.plugin.weex.BindingX.register();
            registerReflexWeexPlugin(application);
            setWeexInitEnd(true);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void setApplication(android.app.Application application) {
        this.mApplication = application;
    }

    @Override // io.dcloud.common.DHInterface.IUniInstanceMgr
    public void restartWeex(final android.app.Application application, final io.dcloud.common.DHInterface.ICallBack iCallBack, final java.lang.String str) {
        if (((getControl().equals(io.dcloud.common.constant.AbsoluteConst.UNI_V3) && isWeexInitEnd() && !io.dcloud.common.util.BaseInfo.isFirstRun) || (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() && isWeexInitEnd())) && this.mPreInstanceId == null) {
            io.dcloud.common.adapter.util.Logger.e(this.TAG, "restartWeex-------");
            if (this.instanceHashMap.size() > 0) {
                onActivityDestroy(false);
            }
            getHandler().post(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.1
                @Override // java.lang.Runnable
                public void run() {
                    io.dcloud.feature.weex.WeexInstanceMgr.this.unRegisterUniappService();
                    io.dcloud.feature.weex.WeexInstanceMgr.this.mRestartReadyCall = iCallBack;
                    io.dcloud.feature.weex.WeexInstanceMgr.this.mApplication = application;
                    io.dcloud.feature.weex.WeexInstanceMgr weexInstanceMgr = io.dcloud.feature.weex.WeexInstanceMgr.this;
                    weexInstanceMgr.initAppForPath(weexInstanceMgr.mApplication, str);
                    io.dcloud.feature.weex.WeexInstanceMgr.this.setJsFrameworkReady(false);
                    io.dcloud.feature.weex.WeexInstanceMgr.this.initJSFramework(application, str);
                    io.dcloud.feature.weex.WeexInstanceMgr.this.registerUniappService(application, str);
                    com.taobao.weex.WXSDKEngine.restartWeex();
                }
            });
        }
    }

    @Override // io.dcloud.common.DHInterface.IUniInstanceMgr
    public void loadWeexToAppid(android.content.Context context, java.lang.String str, boolean z) {
        int vueVersion = getVueVersion();
        initAppForPath(context, str);
        initJSFramework(context, str);
        if (getVueVersion() != vueVersion) {
            z = true;
        }
        if (!com.taobao.weex.bridge.WXBridgeManager.getInstance().isJSFrameworkInit() || z) {
            setJsFrameworkReady(false);
            com.taobao.weex.WXSDKEngine.restartWeex();
        }
    }

    @Override // io.dcloud.common.DHInterface.IUniInstanceMgr
    public void onCreateProcess(android.app.Application application, java.lang.Boolean bool) {
        io.dcloud.weex.MoudlesLoader.getInstance().initHooksClass(application, bool);
    }

    public void initStatisticsListener() {
        com.taobao.weex.WXSDKManager.getInstance().registerStatisticsListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initJSFramework(android.content.Context context, java.lang.String str) {
        com.alibaba.fastjson.JSONObject jSONObject;
        com.alibaba.fastjson.JSONObject jSONObject2;
        java.io.InputStream appFileStream = getAppFileStream(context, str, io.dcloud.common.util.BaseInfo.sConfigXML);
        if (appFileStream != null) {
            try {
                com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(handleEncryptionInputStream(appFileStream, context, true));
                if (object == null || !object.containsKey(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_PLUS)) {
                    return;
                }
                com.alibaba.fastjson.JSONObject jSONObject3 = object.getJSONObject(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_PLUS);
                if (jSONObject3 != null && jSONObject3.containsKey("uni-app")) {
                    com.alibaba.fastjson.JSONObject jSONObject4 = jSONObject3.getJSONObject("uni-app");
                    self().control = io.dcloud.common.constant.AbsoluteConst.UNI_V3;
                    if (jSONObject4.containsKey("renderer")) {
                        self().render = jSONObject4.getString("renderer");
                    }
                    if (jSONObject4.containsKey("nvueCompiler")) {
                        self().complier = jSONObject4.getString("nvueCompiler");
                    }
                    if (jSONObject4.containsKey("vueVersion")) {
                        self().mVueVersion = jSONObject4.getIntValue("vueVersion");
                    } else {
                        self().mVueVersion = 2;
                    }
                    if (jSONObject4.containsKey("useJSProcess")) {
                        if (io.dcloud.common.constant.AbsoluteConst.FALSE.equals(jSONObject4.getString("useJSProcess"))) {
                            com.taobao.weex.bridge.WXBridgeManager.getInstance().setUseSingleProcess(true);
                        } else {
                            com.taobao.weex.bridge.WXBridgeManager.getInstance().setUseSingleProcess(false);
                        }
                    }
                    if (jSONObject4.containsKey("webView") && (jSONObject2 = jSONObject4.getJSONObject("webView")) != null) {
                        try {
                            if (jSONObject2.containsKey("minUserAgentVersion")) {
                                io.dcloud.common.util.BaseInfo.minUserAgentVersion = jSONObject2.getString("minUserAgentVersion");
                            }
                            if (jSONObject2.containsKey("x5")) {
                                com.alibaba.fastjson.JSONObject jSONObject5 = jSONObject2.getJSONObject("x5");
                                if (jSONObject5.containsKey("timeOut")) {
                                    io.dcloud.common.util.BaseInfo.timeOut = jSONObject5.getIntValue("timeOut");
                                }
                                if (jSONObject5.containsKey("showTipsWithoutWifi")) {
                                    io.dcloud.common.util.BaseInfo.showTipsWithoutWifi = jSONObject5.getBooleanValue("showTipsWithoutWifi");
                                }
                                if (jSONObject5.containsKey("allowDownloadWithoutWiFi")) {
                                    io.dcloud.common.util.BaseInfo.allowDownloadWithoutWiFi = jSONObject5.getBooleanValue("allowDownloadWithoutWiFi");
                                }
                            }
                        } catch (java.lang.Exception unused) {
                        }
                    }
                }
                if (jSONObject3 != null && jSONObject3.containsKey(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_UNISTATISTICS) && (jSONObject = jSONObject3.getJSONObject(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_UNISTATISTICS)) != null) {
                    com.alibaba.fastjson.JSONObject jSONObject6 = new com.alibaba.fastjson.JSONObject();
                    try {
                        if (jSONObject.containsKey(io.dcloud.common.adapter.ui.webview.WebLoadEvent.ENABLE)) {
                            jSONObject6.put(io.dcloud.common.adapter.ui.webview.WebLoadEvent.ENABLE, jSONObject.get(io.dcloud.common.adapter.ui.webview.WebLoadEvent.ENABLE));
                        }
                        if (jSONObject.containsKey("version")) {
                            jSONObject6.put("version", jSONObject.get("version"));
                        }
                        if (jSONObject.containsKey("uniCloud")) {
                            jSONObject6.put("uniCloud", (java.lang.Object) jSONObject.getJSONObject("uniCloud"));
                        }
                        io.dcloud.common.util.AppRuntime.setUniStatistics(jSONObject6.toJSONString());
                    } catch (java.lang.Exception unused2) {
                    }
                }
                if (jSONObject3 == null || !jSONObject3.containsKey("renderer")) {
                    return;
                }
                io.dcloud.common.util.BaseInfo.renderer = jSONObject3.getString("renderer");
            } catch (java.lang.Exception unused3) {
            }
        }
    }

    private java.io.InputStream getAppFileStream(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.io.InputStream inputStreamOpen;
        java.lang.String path;
        java.io.InputStream inputStreamOpen2 = null;
        try {
            io.dcloud.common.adapter.util.AndroidResources.initAndroidResources(context);
            if (android.text.TextUtils.isEmpty(str)) {
                io.dcloud.common.util.BaseInfo.parseControl();
            } else {
                io.dcloud.common.util.BaseInfo.sDefaultBootApp = str;
            }
            boolean z = io.dcloud.common.util.BaseInfo.ISDEBUG || io.dcloud.common.adapter.io.DHFile.hasFile();
            java.lang.String str3 = "apps/" + io.dcloud.common.util.BaseInfo.sDefaultBootApp + "/www/" + str2;
            if (!this.isAssetsRes || io.dcloud.common.util.BaseInfo.SyncDebug || io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
                inputStreamOpen = null;
            } else {
                try {
                    inputStreamOpen = context.getResources().getAssets().open(str3);
                } catch (java.lang.Exception unused) {
                    inputStreamOpen = null;
                }
            }
            if (inputStreamOpen != null) {
                return inputStreamOpen;
            }
            try {
                if (z) {
                    path = android.os.Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + context.getPackageName();
                } else {
                    path = context.getFilesDir().getPath();
                }
                java.io.File file = new java.io.File(path + "/" + str3);
                if (file.exists()) {
                    inputStreamOpen2 = new java.io.FileInputStream(file);
                } else {
                    try {
                        inputStreamOpen2 = context.getResources().getAssets().open(str3);
                    } catch (java.lang.Exception unused2) {
                    }
                }
                if (inputStreamOpen2 == null) {
                    return inputStreamOpen;
                }
            } catch (java.lang.Exception e) {
                e = e;
                inputStreamOpen2 = inputStreamOpen;
                e.printStackTrace();
            }
            return inputStreamOpen2;
        } catch (java.lang.Exception e2) {
            e = e2;
        }
    }

    public void initAppForPath(android.content.Context context, java.lang.String str) {
        this.isAssetsRes = io.dcloud.common.util.AppRuntime.isAppResourcesInAssetsPath(context, str);
    }

    private java.lang.String handleEncryptionInputStream(java.io.InputStream inputStream, android.content.Context context, boolean z) {
        java.lang.System.currentTimeMillis();
        if (z) {
            inputStream = new io.dcloud.common.adapter.io.UnicodeInputStream(inputStream, java.nio.charset.Charset.defaultCharset().name());
        }
        byte[] bytes = new byte[0];
        try {
            bytes = io.dcloud.common.util.IOUtil.getBytes(inputStream);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        io.dcloud.common.DHInterface.IConfusionMgr iConfusionMgr = this.mConfusionMgr;
        java.lang.String strHandleEncryption = iConfusionMgr != null ? iConfusionMgr.handleEncryption(context.getApplicationContext(), bytes) : null;
        return android.text.TextUtils.isEmpty(strHandleEncryption) ? new java.lang.String(bytes) : strHandleEncryption;
    }

    @Override // io.dcloud.common.DHInterface.IUniInstanceMgr
    public void registerUniappService(android.content.Context context, java.lang.String str) {
        java.io.InputStream appFileStream;
        if (!self().control.equals(io.dcloud.common.constant.AbsoluteConst.UNI_V3) || (appFileStream = self().getAppFileStream(context, str, "app-config-service.js")) == null) {
            return;
        }
        try {
            com.taobao.weex.WXSDKEngine.registerService(this.jsSACName, handleEncryptionInputStream(appFileStream, context, false), new java.util.HashMap());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // io.dcloud.common.DHInterface.IUniInstanceMgr
    public boolean isUniAppAssetsRes() {
        return this.isAssetsRes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegisterUniappService() {
        com.taobao.weex.WXSDKEngine.unRegisterService(this.jsSACName);
    }

    private void registerReflexWeexPlugin(android.content.Context context) {
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex_amap.AMapPluginImpl", "initPlugin", null, new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{context});
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex.map.google.GoogleMapPluginImpl", "initPlugin", null, new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{context});
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex_scroller.DCScrollerPluginImpl", "initPlugin", null, new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{context});
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex_barcode.BarcodePlugin", "initPlugin", null, new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{context});
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.utsplugin.UTSPlugin", "initPlugin", null, new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{context});
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex_livepusher.LivePusherPlugin", "initPlugin", null, new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{context});
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex_media.VideoPlayerPlugin", "initPlugin", null, new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{context});
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex_text.DCWXTextPlugin", "initPlugin", null, new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{context});
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex_input.DCWXInputRegister", "initPlugin", null, new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{context});
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.gcanvas.GCanvasRegister", "initPlugin", null, new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{context});
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex_switch.DCWXSwitchPlugin", "initPlugin", null, new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{context});
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex_ad.DCWXAdPlugin", "initPlugin", null, new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{context});
        java.lang.Object objInvokeFieldValue = io.dcloud.common.adapter.util.PlatformUtil.invokeFieldValue("com.taobao.weex.devtools.inspector.elements.android.WXComponentDescriptor", "sClassName", null);
        if (objInvokeFieldValue == null || !(objInvokeFieldValue instanceof java.util.HashMap)) {
            return;
        }
        java.util.HashMap map = (java.util.HashMap) objInvokeFieldValue;
        map.put(io.dcloud.feature.weex.adapter.FrescoImageComponent.class, "image");
        map.put(io.dcloud.feature.weex.adapter.FrescoImageComponentU.class, "image");
        map.put(io.dcloud.feature.weex.adapter.webview.WXDCWeb.class, "web-view");
        map.put(io.dcloud.feature.weex.extend.DCWXView.class, com.taobao.weex.ui.component.WXBasicComponentType.VIEW);
        map.put(io.dcloud.feature.weex.extend.DCCoverViewComponent.class, "cover-view");
        map.put(io.dcloud.feature.weex.extend.DCWXSlider.class, com.taobao.weex.ui.component.WXBasicComponentType.SLIDER);
    }

    public void addComponentByName(java.lang.String str, java.lang.Class cls) {
        try {
            java.lang.Object objInvokeFieldValue = io.dcloud.common.adapter.util.PlatformUtil.invokeFieldValue("com.taobao.weex.devtools.inspector.elements.android.WXComponentDescriptor", "sClassName", null);
            if (objInvokeFieldValue == null || !(objInvokeFieldValue instanceof java.util.HashMap)) {
                return;
            }
            ((java.util.HashMap) objInvokeFieldValue).put(cls, str);
        } catch (java.lang.Exception unused) {
        }
    }

    private java.lang.String getConfigParam() {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("__HtMl_Id__", (java.lang.Object) "__uniapp_webview");
        jSONObject.put(com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE, (java.lang.Object) 1);
        jSONObject.put("debug", (java.lang.Object) true);
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("language", (java.lang.Object) io.dcloud.common.util.language.LanguageUtil.getDeviceDefLocalLanguage());
        jSONObject2.put("version", (java.lang.Object) android.os.Build.VERSION.RELEASE);
        jSONObject2.put("name", (java.lang.Object) com.taobao.weex.utils.tools.TimeCalculator.PLATFORM_ANDROID);
        jSONObject2.put("vendor", (java.lang.Object) "Google");
        jSONObject.put(com.taobao.weex.common.WXConfig.os, (java.lang.Object) jSONObject2);
        com.alibaba.fastjson.JSONObject jSONObject3 = new com.alibaba.fastjson.JSONObject();
        jSONObject3.put("CONNECTION_TYPE", (java.lang.Object) 0);
        jSONObject.put("networkinfo", (java.lang.Object) jSONObject3);
        return jSONObject.toJSONString();
    }

    public io.dcloud.feature.weex.WXViewWrapper createWeexView(io.dcloud.common.DHInterface.IWebview iWebview, android.view.ViewGroup viewGroup, org.json.JSONObject jSONObject, java.lang.String str, int i) {
        io.dcloud.feature.weex.WXViewWrapper wXViewWrapperMakeWXViewWrapper = makeWXViewWrapper(iWebview, viewGroup, jSONObject, str, i);
        wXViewWrapperMakeWXViewWrapper.loadTemplate(jSONObject);
        return wXViewWrapperMakeWXViewWrapper;
    }

    private io.dcloud.feature.weex.WXViewWrapper makeWXViewWrapper(io.dcloud.common.DHInterface.IWebview iWebview, android.view.ViewGroup viewGroup, org.json.JSONObject jSONObject, java.lang.String str, int i) {
        io.dcloud.feature.weex.WXViewWrapper wXViewWrapperRemove;
        io.dcloud.feature.weex.WXViewWrapper wXViewWrapper = new io.dcloud.feature.weex.WXViewWrapper(iWebview, viewGroup, jSONObject, str, i, (!str.equals("__uniapp__service") || this.mPreUniAppid == null || com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(this.mPreInstanceId) == null) ? false : true);
        if (this.instanceHashMap.containsKey(str) && (wXViewWrapperRemove = this.instanceHashMap.remove(str)) != null && wXViewWrapperRemove.mWXSDKInstance != null) {
            wXViewWrapperRemove.mWXSDKInstance.destroy();
        }
        this.instanceHashMap.put(str, wXViewWrapper);
        return wXViewWrapper;
    }

    public io.dcloud.feature.weex.WXServiceWrapper createWeexService(io.dcloud.common.DHInterface.IApp iApp, android.view.ViewGroup viewGroup, java.lang.String str, org.json.JSONObject jSONObject) {
        io.dcloud.feature.weex.WXServiceWrapper wXServiceWrapper = new io.dcloud.feature.weex.WXServiceWrapper(iApp, viewGroup, str, jSONObject);
        this.serviceWrapperMapsCache.put(str, wXServiceWrapper);
        return wXServiceWrapper;
    }

    io.dcloud.feature.weex.WXViewWrapper findWXViewWrapper(java.lang.String str) {
        if (this.instanceHashMap.containsKey(str)) {
            return this.instanceHashMap.get(str);
        }
        return null;
    }

    public io.dcloud.feature.weex.WXServiceWrapper findWXServiceWrapper(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        if (this.serviceWrapperMapsCache.size() <= 0) {
            return null;
        }
        java.util.Iterator<java.lang.String> it = this.serviceWrapperMapsCache.keySet().iterator();
        while (it.hasNext()) {
            io.dcloud.feature.weex.WXServiceWrapper wXServiceWrapper = this.serviceWrapperMapsCache.get(it.next());
            if (wXServiceWrapper != null && wXServiceWrapper.mWXSDKInstance == wXSDKInstance) {
                return wXServiceWrapper;
            }
        }
        return null;
    }

    public void reloadWXServiceWrapper() {
        if (this.serviceWrapperMapsCache.size() > 0) {
            java.util.Iterator<java.lang.String> it = this.serviceWrapperMapsCache.keySet().iterator();
            while (it.hasNext()) {
                io.dcloud.feature.weex.WXServiceWrapper wXServiceWrapper = this.serviceWrapperMapsCache.get(it.next());
                if (wXServiceWrapper != null) {
                    wXServiceWrapper.reload();
                }
            }
        }
    }

    public com.taobao.weex.WXSDKInstance findWXSDKInstance(java.lang.String str) {
        if (this.serviceWrapperMapsCache.containsKey(str)) {
            return this.serviceWrapperMapsCache.get(str).mWXSDKInstance;
        }
        if (this.instanceHashMap.containsKey(str)) {
            return this.instanceHashMap.get(str).mWXSDKInstance;
        }
        return null;
    }

    io.dcloud.feature.weex.WXBaseWrapper findWXBaseWrapper(java.lang.String str) {
        if (this.serviceWrapperMapsCache.containsKey(str)) {
            return this.serviceWrapperMapsCache.get(str);
        }
        if (this.instanceHashMap.containsKey(str)) {
            return this.instanceHashMap.get(str);
        }
        return null;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public io.dcloud.common.DHInterface.IWebview findWebview(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.common.DHInterface.IApp iApp, java.lang.String str, java.lang.String str2) {
        io.dcloud.common.DHInterface.AbsMgr absMgr = this.featureMgr;
        io.dcloud.common.DHInterface.IMgr.MgrType mgrType = io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr;
        java.lang.Object obj = iWebview;
        if (iWebview == null) {
            obj = iApp;
        }
        java.lang.Object objProcessEvent = absMgr.processEvent(mgrType, 10, new java.lang.Object[]{obj, io.dcloud.common.constant.AbsoluteConst.F_UI, "findWebview", new java.lang.String[]{str, str2}});
        if (objProcessEvent instanceof io.dcloud.common.DHInterface.IWebview) {
            return (io.dcloud.common.DHInterface.IWebview) objProcessEvent;
        }
        return null;
    }

    public java.lang.Object doForFeature(io.dcloud.common.DHInterface.IMgr.MgrType mgrType, int i, java.lang.Object[] objArr) {
        io.dcloud.common.DHInterface.AbsMgr absMgr = this.featureMgr;
        if (absMgr != null) {
            return absMgr.processEvent(mgrType, i, objArr);
        }
        return null;
    }

    public io.dcloud.feature.weex.WXBaseWrapper findWXBaseWrapper(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        java.util.Iterator<java.lang.String> it = this.instanceHashMap.keySet().iterator();
        io.dcloud.feature.weex.WXViewWrapper wXViewWrapper = null;
        while (it.hasNext()) {
            io.dcloud.feature.weex.WXViewWrapper wXViewWrapper2 = this.instanceHashMap.get(it.next());
            if (wXViewWrapper2 != null && wXViewWrapper2.mWXSDKInstance == wXSDKInstance) {
                wXViewWrapper = wXViewWrapper2;
            }
        }
        return wXViewWrapper;
    }

    public io.dcloud.common.DHInterface.IWebview findWebview(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        java.util.Iterator<java.lang.String> it = this.instanceHashMap.keySet().iterator();
        while (it.hasNext()) {
            io.dcloud.feature.weex.WXViewWrapper wXViewWrapper = this.instanceHashMap.get(it.next());
            if (wXViewWrapper != null && wXViewWrapper.mWXSDKInstance == wXSDKInstance) {
                return wXViewWrapper.mWebview;
            }
        }
        return null;
    }

    public io.dcloud.common.DHInterface.IWebview findWebviewByInstanceId(java.lang.String str) {
        java.util.Iterator<java.lang.String> it = this.instanceHashMap.keySet().iterator();
        while (it.hasNext()) {
            io.dcloud.feature.weex.WXViewWrapper wXViewWrapper = this.instanceHashMap.get(it.next());
            if (wXViewWrapper != null && wXViewWrapper.mWXSDKInstance.getInstanceId().equals(str)) {
                return wXViewWrapper.mWebview;
            }
        }
        return null;
    }

    public io.dcloud.feature.weex.WXViewWrapper findPathByWrapper(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.util.Iterator<java.lang.String> it = this.instanceHashMap.keySet().iterator();
        while (it.hasNext()) {
            io.dcloud.feature.weex.WXViewWrapper wXViewWrapper = this.instanceHashMap.get(it.next());
            java.lang.String strInitSrcPath = wXViewWrapper.initSrcPath(str);
            java.lang.String srcPath = wXViewWrapper.getSrcPath();
            if (wXViewWrapper != null && !android.text.TextUtils.isEmpty(srcPath) && srcPath.equals(strInitSrcPath)) {
                return wXViewWrapper;
            }
        }
        return null;
    }

    public void removeWeexView(java.lang.String str) {
        if (this.instanceHashMap.containsKey(str)) {
            this.instanceHashMap.remove(str).onDestroy();
        }
    }

    void onActivityResume() {
        forEach(new io.dcloud.feature.weex.WeexInstanceMgr.EachListener<io.dcloud.feature.weex.WXBaseWrapper>() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.2
            @Override // io.dcloud.feature.weex.WeexInstanceMgr.EachListener
            public void onEach(io.dcloud.feature.weex.WXBaseWrapper wXBaseWrapper) {
                wXBaseWrapper.onActivityResume();
            }
        });
    }

    void onActivityPause() {
        forEach(new io.dcloud.feature.weex.WeexInstanceMgr.EachListener<io.dcloud.feature.weex.WXBaseWrapper>() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.3
            @Override // io.dcloud.feature.weex.WeexInstanceMgr.EachListener
            public void onEach(io.dcloud.feature.weex.WXBaseWrapper wXBaseWrapper) {
                wXBaseWrapper.onActivityPause();
            }
        });
    }

    void onActivityResult(final int i, final int i2, final android.content.Intent intent) {
        forEach(new io.dcloud.feature.weex.WeexInstanceMgr.EachListener<io.dcloud.feature.weex.WXBaseWrapper>() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.4
            @Override // io.dcloud.feature.weex.WeexInstanceMgr.EachListener
            public void onEach(io.dcloud.feature.weex.WXBaseWrapper wXBaseWrapper) {
                wXBaseWrapper.onActivityResult(i, i2, intent);
            }
        });
    }

    void onActivityDestroy() {
        onActivityDestroy(true);
    }

    void onActivityDestroy(boolean z) {
        this.mPreUniAppid = null;
        this.mPreInstanceId = null;
        if (this.instanceHashMap.size() > 0 || this.serviceWrapperMapsCache.size() > 0) {
            if (z) {
                getHandler().postDelayed(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.5
                    @Override // java.lang.Runnable
                    public void run() {
                        io.dcloud.feature.weex.WeexInstanceMgr.this.wrapperDestroy();
                    }
                }, 200L);
            } else {
                getHandler().post(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.6
                    @Override // java.lang.Runnable
                    public void run() {
                        io.dcloud.feature.weex.WeexInstanceMgr.this.wrapperDestroy();
                    }
                });
            }
        }
        this.mPreUniMPCallBackMap.clear();
        this.mApplication = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wrapperDestroy() {
        forEach(new io.dcloud.feature.weex.WeexInstanceMgr.EachListener<io.dcloud.feature.weex.WXBaseWrapper>() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.7
            @Override // io.dcloud.feature.weex.WeexInstanceMgr.EachListener
            public void onEach(io.dcloud.feature.weex.WXBaseWrapper wXBaseWrapper) {
                if (wXBaseWrapper != null) {
                    wXBaseWrapper.onDestroy();
                }
            }
        });
        this.instanceHashMap.clear();
        this.serviceWrapperMapsCache.clear();
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            reloadWeexEngine();
        }
    }

    private void reloadWeexEngine() {
        unRegisterUniappService();
        com.taobao.weex.WXSDKEngine.reload();
    }

    private void forEach(io.dcloud.feature.weex.WeexInstanceMgr.EachListener eachListener) {
        try {
            java.util.Collection<io.dcloud.feature.weex.WXViewWrapper> collectionValues = this.instanceHashMap.values();
            if (collectionValues != null) {
                for (io.dcloud.feature.weex.WXViewWrapper wXViewWrapper : collectionValues) {
                    if (wXViewWrapper != null) {
                        eachListener.onEach(wXViewWrapper);
                    }
                }
            }
            java.util.Collection<io.dcloud.feature.weex.WXServiceWrapper> collectionValues2 = this.serviceWrapperMapsCache.values();
            if (collectionValues2 != null) {
                for (io.dcloud.feature.weex.WXServiceWrapper wXServiceWrapper : collectionValues2) {
                    if (wXServiceWrapper != null) {
                        eachListener.onEach(wXServiceWrapper);
                    }
                }
            }
        } catch (java.lang.Exception e) {
            io.dcloud.common.adapter.util.Logger.e("forEach---" + e.getMessage());
        }
    }

    public void weexDebugReload() {
        java.util.LinkedHashMap<java.lang.String, io.dcloud.feature.weex.WXViewWrapper> linkedHashMap = this.instanceHashMap;
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            return;
        }
        java.util.Iterator<java.lang.String> it = this.instanceHashMap.keySet().iterator();
        if (it.hasNext()) {
            this.instanceHashMap.get(it.next()).mWebview.obtainFrameView().obtainWindowMgr().processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 3, "snc:CID");
        }
    }

    public void onRequestPermissionsResult(final int i, final java.lang.String[] strArr, final int[] iArr) {
        forEach(new io.dcloud.feature.weex.WeexInstanceMgr.EachListener<io.dcloud.feature.weex.WXBaseWrapper>() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.8
            @Override // io.dcloud.feature.weex.WeexInstanceMgr.EachListener
            public void onEach(io.dcloud.feature.weex.WXBaseWrapper wXBaseWrapper) {
                if (wXBaseWrapper != null) {
                    wXBaseWrapper.onRequestPermissionsResult(i, strArr, iArr);
                }
            }
        });
    }

    public java.lang.String getComplier() {
        return this.complier;
    }

    public java.lang.String getControl() {
        return this.control;
    }

    public int getVueVersion() {
        return this.mVueVersion;
    }

    public boolean isWeexInitEnd() {
        return this.isWeexInitEnd;
    }

    public void setWeexInitEnd(boolean z) {
        this.isWeexInitEnd = z;
    }

    public void setJsFrameworkReady(boolean z) {
        this.isJsFrameworkReady = z;
    }

    public boolean isJsFrameworkReady() {
        return this.isJsFrameworkReady;
    }

    @Override // com.taobao.weex.IWXStatisticsListener
    public void onJsFrameworkReady() {
        this.isJsFrameworkReady = true;
        if (this.mRestartReadyCall != null) {
            io.dcloud.common.adapter.util.MessageHandler.sendMessage(new io.dcloud.common.adapter.util.MessageHandler.IMessages() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.9
                @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
                public void execute(java.lang.Object obj) {
                    io.dcloud.feature.weex.WeexInstanceMgr.this.mRestartReadyCall.onCallBack(1, null);
                    io.dcloud.feature.weex.WeexInstanceMgr.this.mRestartReadyCall = null;
                }
            }, null);
        }
        java.util.ArrayList<io.dcloud.feature.weex.WeexInstanceMgr.IWXStatisticsCallBack> arrayList = this.callBacks;
        if (arrayList != null) {
            java.util.Iterator<io.dcloud.feature.weex.WeexInstanceMgr.IWXStatisticsCallBack> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onJsFrameworkReady();
            }
        }
    }

    public void setWXStatisticsCallBack(io.dcloud.feature.weex.WeexInstanceMgr.IWXStatisticsCallBack iWXStatisticsCallBack) {
        if (this.callBacks.contains(iWXStatisticsCallBack)) {
            return;
        }
        this.callBacks.add(iWXStatisticsCallBack);
    }

    public void unWXStatisticsCallBack(io.dcloud.feature.weex.WeexInstanceMgr.IWXStatisticsCallBack iWXStatisticsCallBack) {
        if (this.callBacks.contains(iWXStatisticsCallBack)) {
            this.callBacks.remove(iWXStatisticsCallBack);
        }
    }

    public boolean isUniServiceCreated(io.dcloud.common.DHInterface.IApp iApp) {
        java.lang.String strObtainConfigProperty = iApp.obtainConfigProperty(io.dcloud.common.constant.AbsoluteConst.NVUE_LAUNCH_MODE);
        if (!android.text.TextUtils.isEmpty(strObtainConfigProperty) && !strObtainConfigProperty.equals("fast") && getControl().equals(io.dcloud.common.constant.AbsoluteConst.UNI_V3)) {
            return this.isUniServiceCreated;
        }
        if (getControl().equals(com.taobao.weex.common.Constants.CodeCache.SAVE_PATH)) {
            return this.isUniServiceCreated;
        }
        return true;
    }

    public java.lang.String getPreInstanceId() {
        return this.mPreInstanceId;
    }

    public java.lang.String getPreUniAppid() {
        return this.mPreUniAppid;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public void setUniServiceCreated(boolean z, io.dcloud.common.DHInterface.IApp iApp) {
        java.lang.String strObtainConfigProperty;
        this.isUniServiceCreated = z;
        if (iApp == null) {
            strObtainConfigProperty = "fast";
        } else {
            strObtainConfigProperty = iApp.obtainConfigProperty(io.dcloud.common.constant.AbsoluteConst.NVUE_LAUNCH_MODE);
            if (android.text.TextUtils.isEmpty(strObtainConfigProperty)) {
                strObtainConfigProperty = "fast";
            }
        }
        if ((getControl().equals(com.taobao.weex.common.Constants.CodeCache.SAVE_PATH) || (!strObtainConfigProperty.equals("fast") && getControl().equals(io.dcloud.common.constant.AbsoluteConst.UNI_V3))) && this.isUniServiceCreated) {
            java.util.Iterator<java.lang.String> it = this.instanceHashMap.keySet().iterator();
            while (it.hasNext()) {
                io.dcloud.feature.weex.WXViewWrapper wXViewWrapper = this.instanceHashMap.get(it.next());
                if (wXViewWrapper != null && !wXViewWrapper.isService) {
                    wXViewWrapper.runDelayedRenderCaches(wXViewWrapper.getWaitServiceRenderList());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preUniControlService(android.app.Application application, java.lang.String str) {
        this.isUniServiceCreated = true;
        this.mPreUniAppid = str;
        io.dcloud.feature.uniapp.UniSDKInstance uniSDKInstance = new io.dcloud.feature.uniapp.UniSDKInstance(application);
        this.mPreInstanceId = uniSDKInstance.getInstanceId();
        java.lang.String uniFileStr = getUniFileStr(application, str, "app-service.js");
        java.lang.String uniFileStr2 = getUniFileStr(application, str, "app-config.js");
        java.util.HashMap map = new java.util.HashMap();
        map.put("plus_appid", str);
        map.put("preload", true);
        map.put("bundleUrl", "app-service.js");
        uniSDKInstance.render("__uniapp__service", (uniFileStr2 + uniFileStr + " plus.weexBridge.preloadReady('" + str + "');").replaceFirst(java.util.regex.Pattern.quote("\"use weex:vue\""), java.util.regex.Matcher.quoteReplacement("")), map, new org.json.JSONObject().toString(), com.taobao.weex.common.WXRenderStrategy.APPEND_ASYNC);
        java.lang.String str2 = this.TAG;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("preUniControlService------");
        sb.append(str);
        io.dcloud.common.adapter.util.Logger.e(str2, sb.toString());
    }

    private java.lang.String getUniFileStr(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            return io.dcloud.common.util.IOUtil.toString(getAppFileStream(context, str, str2));
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public io.dcloud.common.DHInterface.ICallBack getPreUniMPCallBack(java.lang.String str) {
        if (this.mPreUniMPCallBackMap.containsKey(str)) {
            return this.mPreUniMPCallBackMap.remove(str);
        }
        return null;
    }

    public void preUniMP(final android.app.Application application, final java.lang.String str, io.dcloud.common.DHInterface.ICallBack iCallBack) {
        if (!android.text.TextUtils.isEmpty(this.mPreUniAppid) && iCallBack != null) {
            iCallBack.onCallBack(-101, "");
            return;
        }
        if (iCallBack != null) {
            this.mPreUniMPCallBackMap.put(str, iCallBack);
        }
        if (isWeexInitEnd()) {
            restartWeex(application, new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.feature.weex.WeexInstanceMgr.10
                @Override // io.dcloud.common.DHInterface.ICallBack
                public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                    if (i != 1) {
                        return null;
                    }
                    io.dcloud.feature.weex.WeexInstanceMgr.this.preUniControlService(application, str);
                    return null;
                }
            }, str);
        } else {
            initWeexEnv(application);
            preUniControlService(application, str);
        }
    }

    private android.os.Handler getHandler() {
        if (this.mHandler == null) {
            this.mHandler = new android.os.Handler(android.os.Looper.getMainLooper());
        }
        return this.mHandler;
    }

    private void clearHandler() {
        if (this.mHandler != null) {
            this.mHandler = null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IUniInstanceMgr
    public void initUniappPlugin(android.app.Application application) {
        io.dcloud.feature.uniapp.UniMoudlesLoader.getInstance().onCreate(application);
    }

    public boolean isJSFKFileNotFound() {
        return this.isJSFKFileNotFound;
    }

    public void setJSFKFileNotFound(boolean z) {
        this.isJSFKFileNotFound = z;
    }
}
