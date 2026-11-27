package com.taobao.weex;

/* JADX INFO: loaded from: classes.dex */
public class WXEnvironment {
    public static boolean AUTO_ADJUST_ENV_DEVICE_WIDTH = false;
    public static boolean AUTO_UPDATE_APPLICATION_SCREEN_SIZE = false;
    private static java.lang.String COPY_SO_DES_DIR = null;
    public static final java.lang.String CORE_JSB_SO_NAME = "weexjsb";
    public static java.lang.String CORE_JSB_SO_PATH = null;
    public static final java.lang.String CORE_JSC_SO_NAME = "jsc";
    private static java.lang.String CORE_JSC_SO_PATH = null;
    private static java.lang.String CORE_JSS_ICU_PATH = null;
    public static java.lang.String CORE_JSS_RUNTIME_SO_PATH = null;
    public static final java.lang.String CORE_JSS_SO_NAME = "weexjss";
    private static java.lang.String CORE_JSS_SO_PATH = null;
    public static final java.lang.String CORE_JST_SO_NAME = "weexjst";
    public static final java.lang.String CORE_SO_NAME = "weexcore";
    public static final java.lang.String DEV_Id;
    public static final java.lang.String EAGLE = "eagle";
    public static final java.lang.String ENVIRONMENT = "environment";
    public static java.lang.String JS_LIB_SDK_VERSION = null;
    public static volatile boolean JsFrameworkInit = false;
    private static java.lang.String LIB_LD_PATH = null;
    public static final java.lang.String OS = "android";
    public static final java.lang.String SETTING_EXCLUDE_X86SUPPORT = "env_exclude_x86";
    public static boolean SETTING_FORCE_VERTICAL_SCREEN = false;
    public static final java.lang.String SYS_MODEL;
    public static java.lang.String SYS_VERSION = null;
    public static final java.lang.String WEEX_CURRENT_KEY = "wx_current_url";
    public static java.lang.String WXSDK_VERSION = null;
    private static boolean isApkDebug = false;
    public static boolean isPerf = false;
    public static volatile boolean isWsFixMode = false;
    private static float mViewProt = 0.0f;
    private static com.taobao.weex.WXEnvironment.WXDefaultSettings mWXDefaultSettings = null;
    private static boolean openDebugLog = false;
    private static java.util.Map<java.lang.String, java.lang.String> options = null;
    public static android.app.Application sApplication = null;
    public static long sComponentsAndModulesReadyTime = 0;
    private static boolean sDebugFlagInit = false;
    public static boolean sDebugMode = false;
    public static boolean sDebugNetworkEventReporterEnable = false;
    public static boolean sDebugServerConnectable = false;
    public static java.lang.String sDebugWsUrl = null;

    @java.lang.Deprecated
    public static int sDefaultWidth = 0;
    public static boolean sDynamicMode = false;
    public static java.lang.String sDynamicUrl = null;
    public static final boolean sForceEnableDevTool = true;
    private static java.lang.String sGlobalFontFamily;
    public static boolean sInAliWeex;
    public static long sJSFMStartListenerTime;
    public static long sJSLibInitTime;
    public static io.dcloud.feature.uniapp.utils.AbsLogLevel sLogLevel;
    public static boolean sRemoteDebugMode;
    public static java.lang.String sRemoteDebugProxyUrl;
    public static long sSDKInitExecuteTime;
    public static long sSDKInitInvokeTime;
    public static long sSDKInitStart;
    public static long sSDKInitTime;
    public static volatile boolean sUseRunTimeApi;

    public void initMetrics() {
    }

    static {
        java.lang.String str = android.os.Build.VERSION.RELEASE;
        SYS_VERSION = str;
        if (str != null && str.toUpperCase(java.util.Locale.ROOT).equals("P")) {
            SYS_VERSION = "9.0.0";
        }
        java.lang.String str2 = SYS_VERSION;
        if (str2 != null && str2.toUpperCase(java.util.Locale.ROOT).equals("Q")) {
            SYS_VERSION = "10.0.0";
        }
        SYS_MODEL = android.os.Build.MODEL;
        JS_LIB_SDK_VERSION = com.taobao.weex.BuildConfig.buildJavascriptFrameworkVersion;
        WXSDK_VERSION = com.taobao.weex.BuildConfig.buildVersion;
        DEV_Id = getDevId();
        sDefaultWidth = 750;
        JsFrameworkInit = false;
        SETTING_FORCE_VERTICAL_SCREEN = false;
        AUTO_ADJUST_ENV_DEVICE_WIDTH = true;
        AUTO_UPDATE_APPLICATION_SCREEN_SIZE = true;
        sUseRunTimeApi = false;
        sDebugMode = false;
        sDebugWsUrl = "";
        sDebugServerConnectable = false;
        sRemoteDebugMode = false;
        sRemoteDebugProxyUrl = "";
        sDebugNetworkEventReporterEnable = false;
        sJSLibInitTime = 0L;
        sSDKInitStart = 0L;
        sSDKInitInvokeTime = 0L;
        sSDKInitExecuteTime = 0L;
        sSDKInitTime = 0L;
        sJSFMStartListenerTime = 0L;
        isWsFixMode = true;
        sComponentsAndModulesReadyTime = 0L;
        sInAliWeex = false;
        sLogLevel = com.taobao.weex.utils.LogLevel.DEBUG;
        isApkDebug = true;
        isPerf = false;
        sDebugFlagInit = false;
        openDebugLog = true;
        CORE_JSS_SO_PATH = null;
        CORE_JSS_RUNTIME_SO_PATH = null;
        CORE_JSS_ICU_PATH = null;
        CORE_JSC_SO_PATH = null;
        CORE_JSB_SO_PATH = null;
        COPY_SO_DES_DIR = null;
        LIB_LD_PATH = null;
        mViewProt = 750.0f;
        java.util.concurrent.ConcurrentHashMap concurrentHashMap = new java.util.concurrent.ConcurrentHashMap();
        options = concurrentHashMap;
        concurrentHashMap.put(com.taobao.weex.common.WXConfig.os, OS);
        options.put(com.taobao.weex.common.WXConfig.osName, OS);
        sDynamicMode = false;
        sDynamicUrl = "";
    }

    public static float getViewProt() {
        return mViewProt;
    }

    public static void setViewProt(float f) {
        mViewProt = f;
    }

    public static synchronized com.taobao.weex.WXEnvironment.WXDefaultSettings getWXDefaultSettings() {
        if (mWXDefaultSettings == null && getApplication() != null) {
            mWXDefaultSettings = new com.taobao.weex.WXEnvironment.WXDefaultSettings(getApplication());
        }
        return mWXDefaultSettings;
    }

    public static synchronized java.lang.String getDefaultSettingValue(java.lang.String str, java.lang.String str2) {
        com.taobao.weex.WXEnvironment.WXDefaultSettings wXDefaultSettings = getWXDefaultSettings();
        if (wXDefaultSettings != null && !android.text.TextUtils.isEmpty(str)) {
            return wXDefaultSettings.getValue(str, str2);
        }
        return str2;
    }

    public static synchronized void writeDefaultSettingsValue(java.lang.String str, java.lang.String str2) {
        com.taobao.weex.WXEnvironment.WXDefaultSettings wXDefaultSettings = getWXDefaultSettings();
        if (wXDefaultSettings != null && !android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
            wXDefaultSettings.saveValue(str, str2);
        }
    }

    public static java.util.Map<java.lang.String, java.lang.String> getConfig() {
        android.app.Application application;
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.taobao.weex.common.WXConfig.os, OS);
        map.put(com.taobao.weex.common.WXConfig.appVersion, getAppVersionName());
        map.put(com.taobao.weex.common.WXConfig.cacheDir, getAppCacheFile());
        map.put(com.taobao.weex.common.WXConfig.devId, DEV_Id);
        map.put(com.taobao.weex.common.WXConfig.sysVersion, SYS_VERSION);
        map.put(com.taobao.weex.common.WXConfig.sysModel, SYS_MODEL);
        map.put(com.taobao.weex.common.WXConfig.weexVersion, java.lang.String.valueOf(WXSDK_VERSION));
        if (sRemoteDebugMode) {
            map.put(com.taobao.weex.common.WXConfig.logLevel, "log");
        } else {
            map.put(com.taobao.weex.common.WXConfig.logLevel, sLogLevel.getName());
        }
        try {
            map.put(com.taobao.weex.common.WXConfig.layoutDirection, isLayoutDirectionRTL() ? com.taobao.weex.common.Constants.Name.RTL : "ltr");
        } catch (java.lang.Exception unused) {
            map.put(com.taobao.weex.common.WXConfig.layoutDirection, "ltr");
        }
        try {
            if (isApkDebugable()) {
                addCustomOptions(com.taobao.weex.common.WXConfig.debugMode, io.dcloud.common.constant.AbsoluteConst.TRUE);
            }
            addCustomOptions("scale", java.lang.Float.toString(sApplication.getResources().getDisplayMetrics().density));
            addCustomOptions(com.taobao.weex.common.WXConfig.androidStatusBarHeight, java.lang.Float.toString(com.taobao.weex.utils.WXViewUtils.getStatusBarHeight(sApplication)));
        } catch (java.lang.NullPointerException e) {
            com.taobao.weex.utils.WXLogUtils.e("WXEnvironment scale Exception: ", e);
        }
        map.putAll(getCustomOptions());
        if (map.get(com.taobao.weex.common.WXConfig.appName) == null && (application = sApplication) != null) {
            map.put(com.taobao.weex.common.WXConfig.appName, application.getPackageName());
        }
        return map;
    }

    public static java.lang.String getAppVersionName() {
        try {
            return sApplication.getPackageManager().getPackageInfo(sApplication.getPackageName(), 0).versionName;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("WXEnvironment getAppVersionName Exception: ", e);
            return "";
        }
    }

    private static java.lang.String getAppCacheFile() {
        try {
            return sApplication.getApplicationContext().getCacheDir().getPath();
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("WXEnvironment getAppCacheFile Exception: ", e);
            return "";
        }
    }

    @java.lang.Deprecated
    public static java.util.Map<java.lang.String, java.lang.String> getCustomOptions() {
        return options;
    }

    public static void addCustomOptions(java.lang.String str, java.lang.String str2) {
        options.put(str, str2);
    }

    public static java.lang.String getCustomOptions(java.lang.String str) {
        return options.get(str);
    }

    public static java.lang.String copySoDesDir() {
        java.io.File file;
        try {
            if (android.text.TextUtils.isEmpty(COPY_SO_DES_DIR)) {
                if (sApplication == null) {
                    com.taobao.weex.utils.WXLogUtils.e("sApplication is null, so copy path will be null");
                    return null;
                }
                java.lang.String path = getApplication().getApplicationContext().getCacheDir().getPath();
                if (!android.text.TextUtils.isEmpty(path)) {
                    file = new java.io.File(path, "/cache/weex/libs");
                } else {
                    file = new java.io.File("/data/data/" + sApplication.getPackageName() + "/cache/weex/libs");
                }
                if (!file.exists()) {
                    file.mkdirs();
                }
                COPY_SO_DES_DIR = file.getAbsolutePath();
            }
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
        }
        return COPY_SO_DES_DIR;
    }

    @java.lang.Deprecated
    public static boolean isSupport() {
        boolean zIsInitialized = com.taobao.weex.WXSDKEngine.isInitialized();
        if (!zIsInitialized) {
            com.taobao.weex.utils.WXLogUtils.e("WXSDKEngine.isInitialized():" + zIsInitialized);
        }
        return isHardwareSupport() && zIsInitialized;
    }

    public static boolean isLayoutDirectionRTL() {
        return sApplication.getApplicationContext().getResources().getBoolean(com.taobao.weex.R.bool.weex_is_right_to_left);
    }

    @java.lang.Deprecated
    public static boolean isHardwareSupport() {
        if (isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d("isTableDevice:" + com.taobao.weex.utils.WXUtils.isTabletDevice());
        }
        return isCPUSupport();
    }

    public static boolean isCPUSupport() {
        boolean z = com.taobao.weex.utils.WXSoInstallMgrSdk.isX86() && io.dcloud.common.constant.AbsoluteConst.TRUE.equals(getCustomOptions().get(SETTING_EXCLUDE_X86SUPPORT));
        boolean z2 = com.taobao.weex.utils.WXSoInstallMgrSdk.isCPUSupport() && !z;
        if (isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d("WXEnvironment.sSupport:" + z2 + "isX86AndExclueded: " + z);
        }
        return z2;
    }

    public static boolean isApkDebugable() {
        return isApkDebugable(sApplication);
    }

    public static boolean isApkDebugable(android.app.Application application) {
        if (application == null || isPerf) {
            return false;
        }
        if (sDebugFlagInit) {
            return isApkDebug;
        }
        if (!isApkDebug && io.dcloud.common.util.BaseInfo.SyncDebug) {
            isApkDebug = true;
        } else if (isApkDebug && !io.dcloud.common.util.BaseInfo.SyncDebug) {
            isApkDebug = false;
        }
        sDebugFlagInit = true;
        return isApkDebug;
    }

    public static boolean isPerf() {
        return isPerf;
    }

    private static java.lang.String getDevId() {
        return "";
    }

    public static android.app.Application getApplication() {
        return sApplication;
    }

    public static java.lang.String getDiskCacheDir(android.content.Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!"mounted".equals(android.os.Environment.getExternalStorageState()) && android.os.Environment.isExternalStorageRemovable()) {
                return context.getCacheDir().getPath();
            }
            return context.getExternalCacheDir().getPath();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String getFilesDir(android.content.Context context) {
        if (context == null) {
            return "";
        }
        java.io.File filesDir = context.getFilesDir();
        if (filesDir != null) {
            return filesDir.getPath();
        }
        return (getApplication().getApplicationInfo().dataDir + java.io.File.separator) + "files";
    }

    public static java.lang.String getCrashFilePath(android.content.Context context) {
        java.io.File dir;
        if (context == null || (dir = context.getDir(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CRASH, 0)) == null) {
            return "";
        }
        return dir.getAbsolutePath();
    }

    public static java.lang.String getGlobalFontFamilyName() {
        return sGlobalFontFamily;
    }

    public static void setGlobalFontFamily(java.lang.String str, android.graphics.Typeface typeface) {
        com.taobao.weex.utils.WXLogUtils.d("GlobalFontFamily", "Set global font family: " + str);
        sGlobalFontFamily = str;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (typeface == null) {
            com.taobao.weex.utils.TypefaceUtil.removeFontDO(str);
            return;
        }
        com.taobao.weex.utils.TypefaceUtil.putFontDO(new com.taobao.weex.utils.FontDO(str, typeface));
        com.taobao.weex.utils.WXLogUtils.d("TypefaceUtil", "Add new font: " + str);
    }

    public static boolean isOpenDebugLog() {
        return openDebugLog;
    }

    public static void setOpenDebugLog(boolean z) {
        openDebugLog = z;
    }

    public static void setApkDebugable(boolean z) {
        isApkDebug = z;
        if (z) {
            return;
        }
        openDebugLog = false;
    }

    public static java.lang.String getCacheDir() {
        android.app.Application application = getApplication();
        if (application == null || application.getApplicationContext() == null) {
            return null;
        }
        return application.getApplicationContext().getCacheDir().getPath();
    }

    public static boolean extractSo() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String[] strArr = getApplication().getApplicationContext().getApplicationInfo().splitSourceDirs;
        if (strArr != null) {
            for (java.lang.String str : strArr) {
                if (str.contains(android.os.Build.CPU_ABI)) {
                    arrayList.add(0, str);
                } else {
                    arrayList.add(str);
                }
            }
        }
        java.io.File file = new java.io.File(getApplication().getApplicationContext().getApplicationInfo().sourceDir);
        if (file.exists()) {
            arrayList.add(file.getAbsolutePath());
        }
        java.lang.String strCopySoDesDir = copySoDesDir();
        if (arrayList.size() > 0 && !android.text.TextUtils.isEmpty(strCopySoDesDir)) {
            try {
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext() && !com.taobao.weex.utils.WXFileUtils.extractSo((java.lang.String) it.next(), strCopySoDesDir)) {
                }
                return true;
            } catch (java.io.IOException e) {
                com.taobao.weex.utils.WXLogUtils.e("extractSo error " + e.getMessage());
            }
        }
        return false;
    }

    private static java.lang.String findIcuPath() throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.FileReader(new java.io.File("/proc/self/maps")));
            while (true) {
                try {
                    try {
                        java.lang.String line = bufferedReader.readLine();
                        if (line != null) {
                            if (line.contains("icudt")) {
                                java.lang.String strTrim = line.substring(line.indexOf(47)).trim();
                                try {
                                    bufferedReader.close();
                                } catch (java.io.IOException unused) {
                                }
                                return strTrim;
                            }
                        } else {
                            bufferedReader.close();
                            break;
                        }
                    } catch (java.io.IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            break;
                        }
                        return null;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    throw th;
                }
            }
        } catch (java.io.IOException e2) {
            e = e2;
            bufferedReader = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        try {
            bufferedReader.close();
        } catch (java.io.IOException unused3) {
        }
        return null;
    }

    public static java.lang.String findSoPath(java.lang.String str) {
        java.lang.String strFindLibrary = ((dalvik.system.PathClassLoader) com.taobao.weex.WXEnvironment.class.getClassLoader()).findLibrary(str);
        if (!android.text.TextUtils.isEmpty(strFindLibrary)) {
            java.io.File file = new java.io.File(strFindLibrary);
            if (file.exists()) {
                com.taobao.weex.utils.WXLogUtils.e(str + "'s Path is" + strFindLibrary);
                return file.getAbsolutePath();
            }
            com.taobao.weex.utils.WXLogUtils.e(str + "'s Path is " + strFindLibrary + " but file does not exist");
        }
        java.lang.String str2 = "lib" + str + ".so";
        java.lang.String cacheDir = getCacheDir();
        if (android.text.TextUtils.isEmpty(cacheDir)) {
            com.taobao.weex.utils.WXLogUtils.e("cache dir is null");
            return "";
        }
        if (cacheDir.indexOf("/cache") > 0) {
            strFindLibrary = new java.io.File(cacheDir.replace("/cache", "/lib"), str2).getAbsolutePath();
        }
        if (new java.io.File(strFindLibrary).exists()) {
            com.taobao.weex.utils.WXLogUtils.e(str + "use lib so");
            return strFindLibrary;
        }
        java.io.File file2 = new java.io.File(copySoDesDir(), str2);
        if (file2.exists()) {
            return file2.getAbsolutePath();
        }
        return extractSo() ? new java.io.File(getCacheDir(), str2).getAbsolutePath() : strFindLibrary;
    }

    public static java.lang.String getLibJScRealPath() {
        return "";
    }

    public static java.lang.String getLibJssRealPath() {
        if (sUseRunTimeApi && !android.text.TextUtils.isEmpty(CORE_JSS_RUNTIME_SO_PATH)) {
            com.taobao.weex.utils.WXLogUtils.d("test-> findLibJssRuntimeRealPath " + CORE_JSS_RUNTIME_SO_PATH);
            return CORE_JSS_RUNTIME_SO_PATH;
        }
        if (android.text.TextUtils.isEmpty(CORE_JSS_SO_PATH)) {
            CORE_JSS_SO_PATH = findSoPath(CORE_JSS_SO_NAME);
            com.taobao.weex.utils.WXLogUtils.d("test-> findLibJssRealPath " + CORE_JSS_SO_PATH);
        }
        return CORE_JSS_SO_PATH;
    }

    public static java.lang.String getLibJssIcuPath() {
        if (android.text.TextUtils.isEmpty(CORE_JSS_ICU_PATH)) {
            CORE_JSS_ICU_PATH = findIcuPath();
        }
        return CORE_JSS_ICU_PATH;
    }

    public static java.lang.String getLibLdPath() {
        if (android.text.TextUtils.isEmpty(LIB_LD_PATH)) {
            java.lang.ClassLoader classLoader = com.taobao.weex.WXEnvironment.class.getClassLoader();
            try {
                LIB_LD_PATH = (java.lang.String) classLoader.getClass().getMethod("getLdLibraryPath", null).invoke(classLoader, null);
            } catch (java.lang.IllegalAccessException e) {
                e.printStackTrace();
            } catch (java.lang.NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (java.lang.reflect.InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
        if (android.text.TextUtils.isEmpty(LIB_LD_PATH)) {
            try {
                java.lang.String property = java.lang.System.getProperty("java.library.path");
                java.lang.String libJScRealPath = getLibJScRealPath();
                if (!android.text.TextUtils.isEmpty(libJScRealPath)) {
                    LIB_LD_PATH = new java.io.File(libJScRealPath).getParent() + ":" + property;
                }
            } catch (java.lang.Exception e4) {
                e4.printStackTrace();
            }
        }
        com.taobao.weex.utils.WXLogUtils.d("getLibLdPath is " + LIB_LD_PATH);
        return LIB_LD_PATH;
    }

    public static class WXDefaultSettings {
        private java.lang.String configName = "weex_default_settings";
        private android.content.SharedPreferences sharedPreferences;

        public WXDefaultSettings(android.app.Application application) {
            this.sharedPreferences = null;
            if (application != null) {
                this.sharedPreferences = application.getSharedPreferences("weex_default_settings", 0);
            }
        }

        public synchronized java.lang.String getValue(java.lang.String str, java.lang.String str2) {
            if (this.sharedPreferences != null && !android.text.TextUtils.isEmpty(str)) {
                java.lang.String string = this.sharedPreferences.getString(str, str2);
                com.taobao.weex.utils.WXLogUtils.i("get default settings " + str + " : " + string);
                return string;
            }
            com.taobao.weex.utils.WXLogUtils.i("get default settings " + str + " return default value :" + str2);
            return str2;
        }

        public synchronized void saveValue(java.lang.String str, java.lang.String str2) {
            if (this.sharedPreferences != null && !android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
                com.taobao.weex.utils.WXLogUtils.i("save default settings " + str + ":" + str2);
                android.content.SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
                editorEdit.putString(str, str2);
                editorEdit.apply();
            }
        }
    }
}
