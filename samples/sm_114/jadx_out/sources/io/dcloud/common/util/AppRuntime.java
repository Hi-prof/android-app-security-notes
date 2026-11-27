package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AppRuntime {
    private static int sBatteryLevel = 100;
    private static int sTemperature = 20;
    private static java.lang.String sUniStatistics;

    public static void applyWebViewDarkMode(final android.content.Context context, final android.webkit.WebView webView) {
        java.lang.Runnable runnable = new java.lang.Runnable() { // from class: io.dcloud.common.util.AppRuntime.1
            @Override // java.lang.Runnable
            public void run() {
                int i = android.os.Build.VERSION.SDK_INT;
                if (i >= 29) {
                    try {
                        boolean appDarkMode = io.dcloud.common.util.AppRuntime.getAppDarkMode(context);
                        int i2 = context.getApplicationInfo().targetSdkVersion;
                        if (i2 < 33 || !androidx.webkit.WebViewFeature.isFeatureSupported("ALGORITHMIC_DARKENING")) {
                            if (androidx.webkit.WebViewFeature.isFeatureSupported("FORCE_DARK")) {
                                if (appDarkMode) {
                                    androidx.webkit.WebSettingsCompat.setForceDark(webView.getSettings(), 2);
                                } else {
                                    androidx.webkit.WebSettingsCompat.setForceDark(webView.getSettings(), 0);
                                }
                            }
                        } else if (appDarkMode) {
                            androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode(2);
                            androidx.webkit.WebSettingsCompat.setAlgorithmicDarkeningAllowed(webView.getSettings(), false);
                        } else {
                            androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode(1);
                            androidx.webkit.WebSettingsCompat.setAlgorithmicDarkeningAllowed(webView.getSettings(), false);
                        }
                        if (i2 >= 33 || i >= 32 || !androidx.webkit.WebViewFeature.isFeatureSupported(androidx.webkit.WebViewFeature.FORCE_DARK_STRATEGY)) {
                            return;
                        }
                        androidx.webkit.WebSettingsCompat.setForceDarkStrategy(webView.getSettings(), 1);
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        if (java.lang.Thread.currentThread() != android.os.Looper.getMainLooper().getThread()) {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void checkPrivacyComplianceAndPrompt(android.content.Context context, java.lang.String str) {
        java.lang.String str2 = io.dcloud.common.util.BaseInfo.sGlobalUserAgent;
    }

    private static java.util.List<android.view.View> findAllWebView(android.view.View view) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (view instanceof io.dcloud.common.adapter.ui.webview.DCWebView) {
            arrayList.add(view);
            return arrayList;
        }
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                arrayList.addAll(findAllWebView(viewGroup.getChildAt(i)));
            }
        }
        return arrayList;
    }

    public static boolean getAppDarkMode(android.content.Context context) {
        java.lang.String bundleData;
        if (android.os.Build.VERSION.SDK_INT < 29) {
            return false;
        }
        if (io.dcloud.feature.internal.sdk.SDK.isUniMP) {
            bundleData = io.dcloud.feature.internal.sdk.SDK.hostAppThemeDark;
        } else {
            bundleData = io.dcloud.common.adapter.util.SP.getBundleData(context, io.dcloud.common.adapter.util.SP.DARK_MODE_BUNDLE_FORMAT, io.dcloud.common.adapter.util.SP.DARK_MODE_KEY);
            java.lang.String metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_DARK_MODE");
            if (io.dcloud.common.util.PdrUtil.isEmpty(metaValue)) {
                metaValue = io.dcloud.common.ui.blur.DCBlurDraweeView.LIGHT;
            }
            if (io.dcloud.common.util.PdrUtil.isEmpty(bundleData)) {
                bundleData = metaValue;
            }
        }
        bundleData.getClass();
        if (bundleData.equals("auto")) {
            return io.dcloud.common.adapter.util.DeviceInfo.isSystemNightMode(context).booleanValue();
        }
        return bundleData.equals(io.dcloud.common.ui.blur.DCBlurDraweeView.DARK);
    }

    public static java.lang.String getAppTheme(android.content.Context context) {
        java.lang.String bundleData = io.dcloud.common.adapter.util.SP.getBundleData(context, io.dcloud.common.adapter.util.SP.DARK_MODE_BUNDLE_FORMAT, io.dcloud.common.adapter.util.SP.DARK_MODE_KEY);
        return io.dcloud.common.util.PdrUtil.isEmpty(bundleData) ? io.dcloud.common.ui.blur.DCBlurDraweeView.LIGHT : bundleData;
    }

    public static int getBatteryLevel() {
        return sBatteryLevel;
    }

    public static java.lang.String getDCloudDeviceID(android.content.Context context) {
        return io.dcloud.common.util.TelephonyUtil.getDCloudDeviceID(context);
    }

    public static io.dcloud.common.DHInterface.IUniInstanceMgr getInstanceMgr() {
        return (io.dcloud.common.DHInterface.IUniInstanceMgr) io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex.WeexInstanceMgr", "self");
    }

    public static int getTemperature() {
        return sTemperature;
    }

    public static java.lang.String getUniStatistics() {
        return sUniStatistics;
    }

    public static boolean hasPrivacyForNotShown(android.content.Context context) {
        return io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() ? io.dcloud.feature.internal.sdk.SDK.uniMPSilentMode : io.dcloud.common.ui.PrivacyManager.getInstance().isNotPrivacyAllRight(context);
    }

    public static void initAppDarkMode(android.content.Context context) {
        if (context.getApplicationInfo().targetSdkVersion < 33 || android.os.Build.VERSION.SDK_INT < 32) {
            return;
        }
        if (getAppDarkMode(context)) {
            androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode(2);
        } else {
            androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode(1);
        }
    }

    public static void initUTS() {
        java.lang.Class<?> cls;
        java.lang.Object obj;
        java.lang.reflect.Method method;
        try {
            cls = java.lang.Class.forName("io.dcloud.uts.android.AndroidUTSContext");
        } catch (java.lang.ClassNotFoundException unused) {
            cls = null;
        }
        try {
            obj = cls.getField("INSTANCE").get(null);
        } catch (java.lang.Exception e) {
            io.dcloud.common.adapter.util.Logger.e("AppRuntime", "initUTS error " + e.toString());
            obj = null;
        }
        if (cls == null || obj == null) {
            return;
        }
        try {
            method = cls.getMethod("initApp", null);
        } catch (java.lang.NoSuchMethodException unused2) {
            method = null;
        }
        if (method != null) {
            try {
                method.invoke(obj, null);
            } catch (java.lang.IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (java.lang.reflect.InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static void initUTSHooksClassArray(android.app.Application application) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("io.dcloud.uts.UTSAndroid");
            java.lang.reflect.Method method = null;
            java.lang.Object obj = cls.getField("INSTANCE").get(null);
            if (obj != null) {
                try {
                    java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("initUTSHooksClassArray", android.app.Application.class);
                    declaredMethod.setAccessible(true);
                    method = declaredMethod;
                } catch (java.lang.NoSuchMethodException unused) {
                }
                if (method != null) {
                    try {
                        method.invoke(obj, application);
                    } catch (java.lang.IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (java.lang.reflect.InvocationTargetException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (java.lang.Exception unused2) {
        }
    }

    public static void initUniappPlugin(android.app.Application application) {
        io.dcloud.common.DHInterface.IUniInstanceMgr instanceMgr = getInstanceMgr();
        if (instanceMgr != null) {
            instanceMgr.initUniappPlugin(application);
        }
    }

    public static void initWeex(io.dcloud.common.DHInterface.INativeAppInfo iNativeAppInfo) {
        io.dcloud.common.DHInterface.IUniInstanceMgr iUniInstanceMgr = (io.dcloud.common.DHInterface.IUniInstanceMgr) io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex.WeexInstanceMgr", "self");
        if (iUniInstanceMgr != null) {
            iUniInstanceMgr.initWeexEnv(iNativeAppInfo);
        }
    }

    public static void initX5(android.app.Application application, boolean z, io.dcloud.common.DHInterface.ICallBack iCallBack) {
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.x5.X5InitImpl", "init", null, new java.lang.Class[]{android.app.Application.class, java.lang.Boolean.class, io.dcloud.common.DHInterface.ICallBack.class}, new java.lang.Object[]{application, java.lang.Boolean.valueOf(z), iCallBack});
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001b A[PHI: r7
  0x001b: PHI (r7v1 java.lang.String) = (r7v0 java.lang.String), (r7v4 java.lang.String) binds: [B:3:0x0005, B:8:0x0018] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:13:0x0022  */
    /* JADX WARN: Code duplicated, block: B:19:0x0030  */
    /* JADX WARN: Code duplicated, block: B:22:0x004b  */
    /* JADX WARN: Code duplicated, block: B:23:0x006c  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:34:0x00aa A[Catch: Exception -> 0x00bb, TryCatch #0 {Exception -> 0x00bb, blocks: (B:25:0x0088, B:28:0x0094, B:30:0x009e, B:32:0x00a4, B:34:0x00aa, B:35:0x00b6), top: B:40:0x0088 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:22:0x004b, please report this as an issue */
    public static boolean isAppResourcesInAssetsPath(android.content.Context context, java.lang.String str) {
        boolean z;
        java.lang.String path;
        org.json.JSONObject configData;
        java.lang.String string;
        org.json.JSONObject jSONObjectCreateJSONObject;
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            if (io.dcloud.common.util.PdrUtil.isEmpty(io.dcloud.common.util.BaseInfo.sDefaultBootApp)) {
                io.dcloud.common.util.BaseInfo.parseControl();
            }
            str = io.dcloud.common.util.BaseInfo.sDefaultBootApp;
            if (!io.dcloud.common.util.PdrUtil.isEmpty(str)) {
                if (!io.dcloud.common.util.BaseInfo.isBase(context)) {
                    if (io.dcloud.common.util.BaseInfo.ISDEBUG) {
                        z = true;
                    } else {
                        z = true;
                    }
                    java.lang.String str2 = "apps/" + str + "/www/" + io.dcloud.common.util.BaseInfo.sConfigXML;
                    if (z) {
                        path = android.os.Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + context.getPackageName();
                    } else {
                        path = context.getFilesDir().getPath();
                    }
                    java.lang.String str3 = path + "/" + str2;
                    configData = io.dcloud.common.util.PdrUtil.getConfigData(context, str, str2, true);
                    if (configData != null) {
                        string = "";
                    } else {
                        string = "";
                    }
                    org.json.JSONObject configData2 = io.dcloud.common.util.PdrUtil.getConfigData(context, str, str3, false);
                    return io.dcloud.common.util.BaseInfo.BaseAppInfo.compareVersion(string, configData2 != null ? io.dcloud.common.util.JSONUtil.createJSONObject(configData2.getString("version")).getString("name") : "");
                }
            }
        } else if (!io.dcloud.common.util.BaseInfo.isBase(context)) {
            if (io.dcloud.common.util.BaseInfo.ISDEBUG || io.dcloud.common.adapter.io.DHFile.hasFile()) {
                z = true;
            } else {
                z = false;
            }
            java.lang.String str4 = "apps/" + str + "/www/" + io.dcloud.common.util.BaseInfo.sConfigXML;
            if (z) {
                path = android.os.Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + context.getPackageName();
            } else {
                path = context.getFilesDir().getPath();
            }
            java.lang.String str5 = path + "/" + str4;
            try {
                configData = io.dcloud.common.util.PdrUtil.getConfigData(context, str, str4, true);
                if (configData != null || (jSONObjectCreateJSONObject = io.dcloud.common.util.JSONUtil.createJSONObject(configData.getString("version"))) == null) {
                    string = "";
                } else {
                    string = jSONObjectCreateJSONObject.getString("name");
                }
                org.json.JSONObject configData3 = io.dcloud.common.util.PdrUtil.getConfigData(context, str, str5, false);
                return io.dcloud.common.util.BaseInfo.BaseAppInfo.compareVersion(string, configData3 != null ? io.dcloud.common.util.JSONUtil.createJSONObject(configData3.getString("version")).getString("name") : "");
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean isUniApp(java.lang.String str) {
        return !android.text.TextUtils.isEmpty(str) && str.startsWith("__UNI__");
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$switchAllWebViewDarkMode$0(android.view.View view) {
        if (view instanceof io.dcloud.common.adapter.ui.webview.DCWebView) {
            ((io.dcloud.common.adapter.ui.webview.DCWebView) view).applyWebViewDarkMode();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$switchAllWebViewDarkMode$1(io.dcloud.common.DHInterface.IWebview iWebview) {
        android.view.ViewGroup viewGroupObtainWindowView = iWebview.obtainWindowView();
        if (iWebview instanceof io.dcloud.common.core.ui.TabBarWebview) {
            findAllWebView(viewGroupObtainWindowView).forEach(new java.util.function.Consumer() { // from class: io.dcloud.common.util.AppRuntime$$ExternalSyntheticLambda2
                @Override // java.util.function.Consumer
                public final void accept(java.lang.Object obj) {
                    io.dcloud.common.util.AppRuntime.lambda$switchAllWebViewDarkMode$0((android.view.View) obj);
                }
            });
        }
        if (viewGroupObtainWindowView instanceof io.dcloud.common.adapter.ui.webview.DCWebView) {
            ((io.dcloud.common.adapter.ui.webview.DCWebView) viewGroupObtainWindowView).applyWebViewDarkMode();
        }
    }

    public static void loadDex(android.app.Application application) {
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.debug.DexSwap", "loadDex", null, new java.lang.Class[]{android.app.Application.class}, new java.lang.Object[]{application});
    }

    public static java.io.InputStream loadWeexAsset(java.lang.String str, android.content.Context context) {
        if ((str.startsWith("weex-main-jsfm") || str.startsWith("uni-jsframework")) && str.endsWith(".js") && context.getPackageName().equals("io.dcloud.HBuilder") && context.getExternalCacheDir() != null) {
            java.io.File file = new java.io.File(context.getExternalCacheDir().getPath() + java.io.File.separator + str);
            if (file.exists()) {
                try {
                    return new java.io.FileInputStream(file);
                } catch (java.io.FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void onCreateProcess(android.app.Application application, java.lang.Boolean bool, java.lang.Boolean bool2) {
        io.dcloud.common.DHInterface.IUniInstanceMgr instanceMgr = getInstanceMgr();
        if (instanceMgr != null) {
            if (!bool.booleanValue() || bool2.booleanValue()) {
                instanceMgr.onCreateProcess(application, bool);
            }
        }
    }

    public static void preInitX5(android.app.Application application) {
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.x5.X5InitImpl", "preInit", null, new java.lang.Class[]{android.app.Application.class}, new java.lang.Object[]{application});
    }

    public static void restartWeex(android.app.Application application, io.dcloud.common.DHInterface.ICallBack iCallBack, java.lang.String str) {
        io.dcloud.common.DHInterface.IUniInstanceMgr instanceMgr = getInstanceMgr();
        if (instanceMgr != null) {
            instanceMgr.restartWeex(application, iCallBack, str);
        }
    }

    public static void setAppDarkMode(android.app.Activity activity, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        if (android.os.Build.VERSION.SDK_INT < 29 || io.dcloud.feature.internal.sdk.SDK.isUniMP || activity == null || io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            return;
        }
        if (!io.dcloud.common.util.PdrUtil.isEquals(io.dcloud.common.adapter.util.SP.getBundleData(activity, io.dcloud.common.adapter.util.SP.DARK_MODE_BUNDLE_FORMAT, io.dcloud.common.adapter.util.SP.DARK_MODE_KEY), str)) {
            if (iWebview instanceof io.dcloud.common.adapter.ui.AdaUniWebView) {
                java.util.HashMap map = new java.util.HashMap();
                map.put("uistyle", str);
                ((io.dcloud.common.adapter.ui.AdaUniWebView) iWebview).fireEvent(new io.dcloud.common.adapter.util.EventActionInfo(io.dcloud.common.constant.AbsoluteConst.EVENTS_UISTYLECHANGE, map));
            } else {
                iWebview.loadUrl(io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.EVENTS_DOCUMENT_EXECUTE_TEMPLATE_PARAMETER_OF_UISTYLE, io.dcloud.common.constant.AbsoluteConst.EVENTS_UISTYLECHANGE, str));
            }
        }
        io.dcloud.common.adapter.util.SP.setBundleData(activity, io.dcloud.common.adapter.util.SP.DARK_MODE_BUNDLE_FORMAT, io.dcloud.common.adapter.util.SP.DARK_MODE_KEY, str);
        switchAllWebViewDarkMode(null);
    }

    public static void setBatteryLevel(int i) {
        sBatteryLevel = i;
    }

    public static void setTemperature(int i) {
        sTemperature = i;
    }

    public static void setUniStatistics(java.lang.String str) {
        sUniStatistics = str;
    }

    public static void switchAllWebViewDarkMode(java.util.ArrayList<? extends io.dcloud.common.DHInterface.IFrameView> arrayList) {
        java.util.ArrayList<io.dcloud.common.DHInterface.IWebview> arrayList2 = new java.util.ArrayList<>();
        if (arrayList == null || arrayList.isEmpty()) {
            arrayList2 = io.dcloud.feature.internal.sdk.SDK.obtainAllIWebview();
        } else {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                io.dcloud.common.DHInterface.IFrameView iFrameView = arrayList.get(i);
                i++;
                arrayList2.add(iFrameView.obtainWebView());
            }
        }
        if (arrayList2 == null || arrayList2.isEmpty()) {
            return;
        }
        arrayList2.forEach(new java.util.function.Consumer() { // from class: io.dcloud.common.util.AppRuntime$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(java.lang.Object obj) {
                io.dcloud.common.util.AppRuntime.lambda$switchAllWebViewDarkMode$1((io.dcloud.common.DHInterface.IWebview) obj);
            }
        });
    }

    public static void initWeex(android.app.Application application) {
        io.dcloud.common.DHInterface.IUniInstanceMgr iUniInstanceMgr = (io.dcloud.common.DHInterface.IUniInstanceMgr) io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex.WeexInstanceMgr", "self");
        if (iUniInstanceMgr != null) {
            iUniInstanceMgr.initWeexEnv(io.dcloud.application.DCLoudApplicationImpl.self().getNativeInfo(application));
        }
    }
}
