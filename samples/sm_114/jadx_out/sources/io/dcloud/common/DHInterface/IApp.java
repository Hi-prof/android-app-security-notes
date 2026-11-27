package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IApp extends io.dcloud.common.DHInterface.IAppInfo {
    public static final byte ABS_PRIVATE_DOC_DIR = 1;
    public static final byte ABS_PRIVATE_WWW_DIR = 0;
    public static final byte ABS_PRIVATE_WWW_DIR_APP_MODE = -1;
    public static final byte ABS_PUBLIC_DOCUMENTS_DIR = 2;
    public static final byte ABS_PUBLIC_DOWNLOADS_DIR = 3;
    public static final byte APP_QUIT_DEF = 1;
    public static final byte APP_QUIT_IMMEDIATELY = 2;
    public static final byte APP_RUNNING_MODE = 1;
    public static final java.lang.String AUTHORITY_AUTHORIZED = "authorized";
    public static final java.lang.String AUTHORITY_DENIED = "denied";
    public static final java.lang.String AUTHORITY_UNDETERMINED = "undetermined";
    public static final byte FS_RUNNING_MODE = 0;
    public static final byte STATUS_ACTIVE = 3;
    public static final byte STATUS_UN_ACTIVIE = 2;
    public static final byte STATUS_UN_FAIL = 4;
    public static final byte STATUS_UN_RUNNING = 1;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface ConfigProperty {
        public static final java.lang.String CONFIG_ADAPTATION = "adaptation";
        public static final java.lang.String CONFIG_ADDITIONAL_HTTPHEADERS = "additionalHttpHeaders";
        public static final java.lang.String CONFIG_ALGORITHM = "algorithm";
        public static final java.lang.String CONFIG_AUTHORITY = "authority";
        public static final java.lang.String CONFIG_AUTOCLOSE = "autoclose";
        public static final java.lang.String CONFIG_AUTOCLOSE_W2A = "autoclose_w2a";
        public static final java.lang.String CONFIG_BACK_BUTTON_AUTO_CONTROL = "backButtonAutoControl";
        public static final java.lang.String CONFIG_BASEURL = "baseUrl";
        public static final java.lang.String CONFIG_CACHE = "cache";
        public static final java.lang.String CONFIG_CERS = "cers";
        public static final java.lang.String CONFIG_COMPETENT = "competent";
        public static final java.lang.String CONFIG_CONCATENATE = "concatenate";
        public static final java.lang.String CONFIG_CONFUSION = "confusion";
        public static final java.lang.String CONFIG_COVER = "cover";
        public static final java.lang.String CONFIG_CRASH = "crash";
        public static final java.lang.String CONFIG_DELAY = "delay";
        public static final java.lang.String CONFIG_DELAY_W2A = "delay_w2a";
        public static final java.lang.String CONFIG_DESCRIPTION = "description";
        public static final java.lang.String CONFIG_DEVELOPER = "developer";
        public static final java.lang.String CONFIG_DEVELOPER_EMAIL = "email";
        public static final java.lang.String CONFIG_DEVELOPER_NAME = "name";
        public static final java.lang.String CONFIG_DEVELOPER_URL = "url";
        public static final java.lang.String CONFIG_ERROR_PAGE = "error";
        public static final java.lang.String CONFIG_ERROR_PAGE_URL = "url";
        public static final java.lang.String CONFIG_EVENT = "event";
        public static final java.lang.String CONFIG_FEATURE = "feature";
        public static final java.lang.String CONFIG_FEATURES = "features";
        public static final java.lang.String CONFIG_FULLSCREEN = "fullscreen";
        public static final java.lang.String CONFIG_GEOLOCATION = "geolocation";
        public static final java.lang.String CONFIG_H5PLUS = "h5plus";
        public static final java.lang.String CONFIG_ID = "id";
        public static final java.lang.String CONFIG_INJECTION = "injection";
        public static final java.lang.String CONFIG_JSERROR = "jserror";
        public static final java.lang.String CONFIG_KEY = "key";
        public static final java.lang.String CONFIG_LANGUAGE = "language";
        public static final java.lang.String CONFIG_LAUNCHWEBVIEW = "launchwebview";
        public static final java.lang.String CONFIG_LAUNCH_PATH = "launch_path";
        public static final java.lang.String CONFIG_LAUNCH_PATH_W2A = "launch_path_w2a";
        public static final java.lang.String CONFIG_LGEOLOCATION = "L_geolocation";
        public static final java.lang.String CONFIG_LICENSE = "license";
        public static final java.lang.String CONFIG_LICENSE_DESCRIPTION = "description";
        public static final java.lang.String CONFIG_LICENSE_URL = "url";
        public static final java.lang.String CONFIG_LOADED_TIME = "loadedTime";
        public static final java.lang.String CONFIG_LPLUSERQUIRE = "L_plusrequire";
        public static final java.lang.String CONFIG_MODULE = "module";
        public static final java.lang.String CONFIG_NAME = "name";
        public static final java.lang.String CONFIG_NAVIGATIONBAR = "navigationbar";
        public static final java.lang.String CONFIG_OVERRIDEURL = "overrideurl";
        public static final java.lang.String CONFIG_OVERRIDE_RESOURCE = "overrideresource";
        public static final java.lang.String CONFIG_PERMISSIONS = "permissions";
        public static final java.lang.String CONFIG_PLUS = "plus";
        public static final java.lang.String CONFIG_PLUSREQUIRE = "plusrequire";
        public static final java.lang.String CONFIG_RAM_CACHE_MODE = "ramcachemode";
        public static final java.lang.String CONFIG_REPLACE_WEB_API = "replacewebapi";
        public static final java.lang.String CONFIG_RESOURCES = "resources";
        public static final java.lang.String CONFIG_RUNMODE = "runmode";
        public static final java.lang.String CONFIG_RUNMODE_LIBERATE = "liberate";
        public static final java.lang.String CONFIG_RUNMODE_NORMAL = "normal";
        public static final java.lang.String CONFIG_SECONDWEBVIEW = "secondwebview";
        public static final java.lang.String CONFIG_SECONDWEBVIEW_MODE = "mode";
        public static final java.lang.String CONFIG_SERVICE = "service";
        public static final java.lang.String CONFIG_SERVICES = "services";
        public static final java.lang.String CONFIG_SGEOLOCATION = "S_geolocation";
        public static final java.lang.String CONFIG_SHORTCUT = "shortcut";
        public static final java.lang.String CONFIG_SHORTCUTQUIT = "shortcutQuit";
        public static final java.lang.String CONFIG_SPLASHSCREEN = "splashscreen";
        public static final java.lang.String CONFIG_SPLUSERQUIRE = "S_pluserquire";
        public static final java.lang.String CONFIG_SRC = "src";
        public static final java.lang.String CONFIG_SSL = "ssl";
        public static final java.lang.String CONFIG_STREAM = "stream";
        public static final java.lang.String CONFIG_TARGET = "target";
        public static final java.lang.String CONFIG_TIMEOUT = "timeout";
        public static final java.lang.String CONFIG_TITLE_N_VIEW = "titleNView";
        public static final java.lang.String CONFIG_UNIAPP_CONTROL = "control";
        public static final java.lang.String CONFIG_UNISTATISTICS = "uniStatistics";
        public static final java.lang.String CONFIG_UNTRUSTEDCA = "untrustedca";
        public static final java.lang.String CONFIG_USER_AGENT = "useragent";
        public static final java.lang.String CONFIG_USER_AGENT_ANDROID = "useragent_android";
        public static final java.lang.String CONFIG_USE_ENCRYPTION = "use_encryption";
        public static final java.lang.String CONFIG_USE_V3_ENCRYPTION = "use_v3_encryption";
        public static final java.lang.String CONFIG_VALUE = "value";
        public static final java.lang.String CONFIG_VERSION = "version";
        public static final java.lang.String CONFIG_VERSION_CODE = "code";
        public static final java.lang.String CONFIG_VERSION_NAME = "name";
        public static final java.lang.String CONFIG_WAITING = "waiting";
        public static final java.lang.String CONFIG_funSetUA = "funSetUA";
        public static final java.lang.String UNI_NVUE_DATA = "uni_nvue_data";
        public static final java.lang.String UNI_RESTART_TO_DIRECT = "uni_restart_to_direct";

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        public enum ThridInfo {
            OverrideUrlJsonData,
            OverrideResourceJsonData,
            SecondWebviewJsonData,
            LaunchWebviewJsonData,
            TitleNViewJsonData,
            DirectPageJsonData,
            URDJsonData,
            SitemapJsonData,
            Tabbar
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface IAppStatusListener {
        void onPause(io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.DHInterface.IApp iApp2);

        void onStart();

        boolean onStop();

        java.lang.String onStoped(boolean z, java.lang.String str);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface Name {
        public static final int APP = 1;
        public static final int STORAGE = 2;
        public static final int STREAM = 3;
        public static final int UPDATE = 4;
    }

    void addAllFeaturePermission();

    void addFeaturePermission(java.lang.String str);

    void applyMani();

    void applySmartUpdate();

    boolean callSysEventListener(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj);

    boolean checkIsCustomPath();

    void checkOrLoadlaunchWebview();

    boolean checkPrivateDir(java.lang.String str);

    java.lang.String checkPrivateDirAndCopy2Temp(java.lang.String str);

    boolean checkSchemeWhite(java.lang.String str);

    int checkSelfPermission(java.lang.String str, java.lang.String str2);

    boolean checkWhiteUrl(java.lang.String str);

    void clearRuntimeArgs();

    java.lang.String convert2AbsFullPath(java.lang.String str);

    java.lang.String convert2AbsFullPath(java.lang.String str, java.lang.String str2);

    java.lang.String convert2LocalFullPath(java.lang.String str, java.lang.String str2);

    java.lang.String convert2RelPath(java.lang.String str);

    java.lang.String convert2WebviewFullPath(java.lang.String str, java.lang.String str2);

    void deleteAppTemp();

    void diyStatusBarState();

    java.lang.String forceShortCut();

    io.dcloud.common.DHInterface.IConfusionMgr getConfusionMgr();

    java.lang.String getDirectPage();

    io.dcloud.common.DHInterface.IApp.IAppStatusListener getIAppStatusListener();

    java.lang.String getOriginalDirectPage();

    java.lang.String getPathByType(byte b);

    java.lang.String getPopGesture();

    int getQuitModel();

    java.lang.String getSystemInfo();

    boolean isOnAppRunningMode();

    boolean isUniApp();

    boolean manifestBeParsed();

    boolean needRefreshApp();

    boolean needReload();

    java.lang.String obtainAdaptationJs();

    java.lang.String obtainAppDataPath();

    java.lang.String obtainAppDocPath();

    java.lang.String obtainAppId();

    java.lang.String obtainAppInfo();

    java.lang.String obtainAppLog();

    java.lang.String obtainAppName();

    byte obtainAppStatus();

    java.lang.String obtainAppTempPath();

    java.lang.String obtainAppVersionCode();

    java.lang.String obtainAppVersionName();

    java.lang.String obtainAppWebCachePath();

    java.lang.String obtainAuthority(java.lang.String str);

    java.lang.String obtainConfigProperty(java.lang.String str);

    io.dcloud.common.DHInterface.IWebviewStateListener obtainLaunchPageStateListener();

    java.lang.Object obtainMgrData(io.dcloud.common.DHInterface.IMgr.MgrType mgrType, int i, java.lang.Object[] objArr);

    java.lang.String obtainOriginalAppId();

    java.io.InputStream obtainResInStream(java.lang.String str);

    java.io.InputStream obtainResInStream(java.lang.String str, java.lang.String str2);

    byte obtainRunningAppMode();

    java.lang.String obtainRuntimeArgs(boolean z);

    io.dcloud.common.util.AppStatusBarManager obtainStatusBarMgr();

    org.json.JSONObject obtainThridInfo(io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo thridInfo);

    java.lang.String obtainVersionSitemap();

    android.content.Intent obtainWebAppIntent();

    java.lang.String obtainWebviewBaseUrl();

    void onSplashClosed();

    void registerSysEventListener(io.dcloud.common.DHInterface.ISysEventListener iSysEventListener, io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType);

    void requestPermissions(java.lang.String[] strArr, int i);

    void setAppDataPath(java.lang.String str);

    void setAppDocPath(java.lang.String str);

    void setConfigProperty(java.lang.String str, java.lang.String str2);

    void setDirectPage(java.lang.String str);

    void setHideNavBarState(boolean z);

    void setIAppStatusListener(io.dcloud.common.DHInterface.IApp.IAppStatusListener iAppStatusListener);

    void setLaunchPageStateListener(io.dcloud.common.DHInterface.IWebviewStateListener iWebviewStateListener);

    void setNeedRefreshApp(boolean z);

    void setQuitModel(int i);

    void setRuntimeArgs(java.lang.String str);

    void setStatus(byte b);

    void setWebAppActivity(android.app.Activity activity);

    void setWebAppIntent(android.content.Intent intent);

    java.lang.String shortcutQuit();

    void showSplash();

    boolean startFromShortCut();

    void unregisterSysEventListener(io.dcloud.common.DHInterface.ISysEventListener iSysEventListener, io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType);

    void updateDirectPage(java.lang.String str);
}
