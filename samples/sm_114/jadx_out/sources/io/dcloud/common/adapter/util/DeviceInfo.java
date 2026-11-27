package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DeviceInfo {
    private static final java.lang.String CDMA_DATA_NETWORK = "cdma";
    private static java.lang.String CONNECTION_CELL2G = null;
    private static java.lang.String CONNECTION_CELL3G = null;
    private static java.lang.String CONNECTION_CELL4G = null;
    private static java.lang.String CONNECTION_CELL5G = null;
    private static java.lang.String CONNECTION_ETHERNET = null;
    private static java.lang.String CONNECTION_UNKNOW = null;
    private static final java.lang.String DEFAULT_DATA_NETWORK = "default_data_network";
    public static float DEFAULT_FONT_SIZE = 0.0f;
    public static java.lang.String DEVICESTATUS_JS = null;
    public static final java.lang.String FILE_PROTOCOL = "file://";
    public static int HARDWAREACCELERATED_VIEW = 0;
    public static int HARDWAREACCELERATED_WINDOW = 0;
    public static final java.lang.String HTTPS_PROTOCOL = "https://";
    public static final java.lang.String HTTP_PROTOCOL = "http://";
    private static java.lang.String NETTYPE_NONE = null;
    private static java.lang.String NETTYPE_WIFI = null;
    private static final java.lang.String NONE_DATA_NETWORK = "none";
    public static final int OSTYPE_ANDROID = 0;
    public static final int OSTYPE_LEOS10 = 4;
    public static final int OSTYPE_OMS10 = 3;
    public static final int OSTYPE_OMS15 = 2;
    public static final int OSTYPE_OMS20 = 1;
    private static final java.lang.String SAVED_DATA_NETWORK = "saved_data_network";
    private static final java.lang.String TAG = "DeviceInfo";
    public static float dpiX;
    public static float dpiY;
    public static volatile boolean isIMEShow;
    public static boolean isPrivateDirectory;
    public static boolean isVolumeButtonEnabled;
    public static java.lang.String mAppAuthorities;
    public static java.lang.String oaids;
    public static int osType;
    private static final java.lang.String[] rootRelatedDirs;
    public static android.content.Context sApplicationContext;
    public static java.lang.String sBaseFsCachePath;
    public static java.lang.String sBaseFsRootFullPath;
    public static java.lang.String sBaseFsRootPath;
    public static java.lang.String sBaseResRootFullPath;
    public static java.lang.String sBaseResRootPathName;
    public static java.lang.String sCacheRootDir;
    static android.net.ConnectivityManager sConnectMgr;
    public static float sDensity;
    public static java.lang.String sDeviceRootDir;
    public static java.lang.String sIMEI;
    public static java.lang.String sIMSI;
    public static int sInputMethodHeight;
    public static java.lang.String sMAC;
    public static java.lang.String sPackageName;
    public static android.graphics.Paint sPaint;
    public static java.lang.String sPrivateDir;
    public static java.lang.String sPrivateExternalDir;
    public static java.lang.String sPublicDCIMDir;
    public static java.lang.String sPublicDocumentsDir;
    public static java.lang.String sPublicDownloadDir;
    public static java.lang.String sPublicMoviesDir;
    public static java.lang.String sPublicMusicDir;
    public static java.lang.String sPublicPicturesDir;
    public static java.lang.String sPublicRingtonesDir;
    public static char sSeparatorChar;
    public static int sStatusBarHeight;
    public static org.json.JSONObject sSystemInfo;
    public static int sDeviceSdkVer = android.os.Build.VERSION.SDK_INT;
    public static java.lang.String sModel = android.os.Build.MODEL;
    public static java.lang.String sBrand = android.os.Build.BRAND;
    public static long sTotalMem = -1;
    public static int sCoreNums = -1;
    public static java.lang.String sVendor = android.os.Build.MANUFACTURER;
    public static java.lang.String sVersion_release = android.os.Build.VERSION.RELEASE;
    public static java.lang.String sLanguage = io.dcloud.common.util.language.LanguageUtil.getDeviceDefLocalLanguage();
    public static boolean sNetWorkInited = false;
    private static final java.lang.String GSM_DATA_NETWORK = "gsm";
    public static java.lang.String sDeftDataNetwork = GSM_DATA_NETWORK;

    static {
        char c = java.io.File.separatorChar;
        sSeparatorChar = c;
        sBaseResRootPathName = java.lang.String.valueOf(c);
        sPackageName = null;
        DEVICESTATUS_JS = null;
        android.graphics.Paint paint = new android.graphics.Paint();
        sPaint = paint;
        DEFAULT_FONT_SIZE = paint.getTextSize();
        osType = 0;
        sApplicationContext = null;
        sConnectMgr = null;
        isPrivateDirectory = false;
        isVolumeButtonEnabled = true;
        sPrivateExternalDir = null;
        sPrivateDir = null;
        sPublicDocumentsDir = null;
        sPublicDCIMDir = null;
        sPublicDownloadDir = null;
        sPublicMoviesDir = null;
        sPublicMusicDir = null;
        sPublicPicturesDir = null;
        sPublicRingtonesDir = null;
        CONNECTION_UNKNOW = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT;
        NETTYPE_NONE = "1";
        CONNECTION_ETHERNET = "2";
        NETTYPE_WIFI = "3";
        CONNECTION_CELL2G = "4";
        CONNECTION_CELL3G = "5";
        CONNECTION_CELL4G = "6";
        CONNECTION_CELL5G = "7";
        sStatusBarHeight = 0;
        sInputMethodHeight = 0;
        HARDWAREACCELERATED_WINDOW = 0;
        HARDWAREACCELERATED_VIEW = 1;
        isIMEShow = false;
        rootRelatedDirs = new java.lang.String[]{"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};
    }

    public static boolean blueToothEnable(android.content.Context context) throws java.lang.Exception {
        if (android.os.Build.VERSION.SDK_INT < 23 || context.checkSelfPermission("android.permission.BLUETOOTH") != -1) {
            return ((android.bluetooth.BluetoothManager) context.getSystemService("bluetooth")).getAdapter().isEnabled();
        }
        throw new java.lang.Exception();
    }

    public static boolean checkCoverLoadApp() {
        boolean z;
        java.lang.String bundleData = io.dcloud.common.adapter.util.SP.getBundleData(io.dcloud.common.util.BaseInfo.PDR, "last_app_modify_date");
        long jLastModified = new java.io.File(sApplicationContext.getPackageCodePath()).lastModified();
        io.dcloud.common.adapter.util.Logger.d(TAG, "old_app_modify_date=" + bundleData);
        if (io.dcloud.common.util.PdrUtil.isEquals(bundleData, java.lang.String.valueOf(jLastModified))) {
            z = false;
        } else {
            io.dcloud.common.adapter.util.SP.setBundleData(sApplicationContext, io.dcloud.common.util.BaseInfo.PDR, "last_app_modify_date", java.lang.String.valueOf(jLastModified));
            bundleData = io.dcloud.common.adapter.util.Logger.generateTimeStamp(io.dcloud.common.adapter.util.Logger.TIMESTAMP_YYYY_MM_DD_HH_MM_SS_SSS, new java.util.Date(jLastModified));
            io.dcloud.common.adapter.util.Logger.d(TAG, "new_app_modify_date=" + jLastModified);
            z = true;
        }
        io.dcloud.common.adapter.util.Logger.d(TAG, "App Modify Date=" + bundleData + ";_ret=" + z);
        return z;
    }

    public static void closeHardwareAccelerated(android.app.Activity activity, int i, java.lang.Object obj) {
        android.view.Window window = null;
        if (i != HARDWAREACCELERATED_WINDOW) {
            if (i != HARDWAREACCELERATED_VIEW || sDeviceSdkVer < 11) {
                return;
            }
            ((android.view.View) obj).setLayerType(1, null);
            return;
        }
        android.view.Window window2 = (android.view.Window) obj;
        if (window2 != null) {
            window = window2;
        } else if (activity != null) {
            window = activity.getWindow();
        }
        if (window != null) {
            window.clearFlags(16777216);
        }
    }

    public static java.lang.String deviceOrientation(android.content.Context context) {
        int i = context.getResources().getConfiguration().orientation;
        if (i == 1) {
            return "portrait";
        }
        return i == 2 ? "landscape" : "";
    }

    public static long getAvailMemory() {
        android.content.Context context = sApplicationContext;
        if (context == null) {
            return 0L;
        }
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
        android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static java.lang.String getBuildValue(java.lang.String str) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            return (java.lang.String) cls.getDeclaredMethod("get", java.lang.String.class).invoke(cls, str);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String getCurrentAPN() {
        return io.dcloud.common.util.NetworkTypeUtil.getCurrentAPN(io.dcloud.application.DCLoudApplicationImpl.self().getContext().getApplicationContext());
    }

    public static int getDeivceSuitablePixel(android.app.Activity activity, int i) {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return (int) (i * displayMetrics.density);
    }

    public static java.lang.String getDevicestatus_js(io.dcloud.common.DHInterface.IApp iApp) {
        DEVICESTATUS_JS = "(function(p){p.device.imei='%s';p.device.uuid='%s';p.device.imsi=['%s'];p.device.model='%s';p.device.vendor='%s';p.os.language='%s';p.os.version='%s';p.os.name='%s';p.os.vendor='%s';})(((window.__html5plus__&&__html5plus__.isReady)?__html5plus__:(navigator.plus&&navigator.plus.isReady)?navigator.plus:window.plus));";
        java.lang.String str = io.dcloud.common.util.StringUtil.format(DEVICESTATUS_JS, io.dcloud.common.util.TelephonyUtil.updateIMEI(iApp.getActivity()), io.dcloud.common.util.TelephonyUtil.getIMEI(iApp.getActivity(), false), sIMSI, sModel, sVendor, sLanguage, sVersion_release, com.taobao.weex.utils.tools.TimeCalculator.PLATFORM_ANDROID, "Google");
        DEVICESTATUS_JS = str;
        return str;
    }

    @java.lang.Deprecated
    public static java.lang.String getMac(android.content.Context context) {
        try {
            sMAC = io.dcloud.common.util.TelephonyUtil.getWifiData(context);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return sMAC;
    }

    public static java.lang.String getNetWorkType(android.content.Context context) {
        java.lang.String str = NETTYPE_NONE;
        if (sConnectMgr == null || ((android.os.Build.VERSION.SDK_INT >= 23 && androidx.core.content.ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") != 0) || sConnectMgr.getActiveNetworkInfo() == null)) {
            return str;
        }
        java.lang.String str2 = CONNECTION_UNKNOW;
        if (sConnectMgr.getActiveNetworkInfo().getType() == 1) {
            return NETTYPE_WIFI;
        }
        if (sConnectMgr.getActiveNetworkInfo().getType() != 0) {
            return str2;
        }
        int subtype = sConnectMgr.getActiveNetworkInfo().getSubtype();
        switch (subtype) {
            case 1:
            case 2:
            case 4:
            case 7:
                return CONNECTION_CELL2G;
            case 3:
            case 8:
                return CONNECTION_CELL3G;
            case 5:
            case 6:
            case 12:
            case 14:
                return CONNECTION_CELL3G;
            case 9:
            case 10:
            case 11:
            case 13:
            case 15:
                return CONNECTION_CELL4G;
            case 16:
            case 19:
            default:
                return "" + subtype;
            case 17:
            case 18:
                return CONNECTION_CELL3G;
            case 20:
                return CONNECTION_CELL5G;
        }
    }

    public static int getNumCores() {
        int i = sCoreNums;
        if (i != -1) {
            return i;
        }
        try {
            java.io.File[] fileArrListFiles = new java.io.File("/sys/devices/system/cpu/").listFiles(new java.io.FileFilter() { // from class: io.dcloud.common.adapter.util.DeviceInfo.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(java.io.File file) {
                    return java.util.regex.Pattern.matches("cpu[0-9]", file.getName());
                }
            });
            sCoreNums = fileArrListFiles.length;
            return fileArrListFiles.length;
        } catch (java.lang.Exception unused) {
            return 1;
        }
    }

    public static java.lang.String getPlusCache() {
        return "window.plus.cache = navigator.plus.cache = (function(mkey){return {clear : function(clearCB){var callbackid = mkey.helper.callbackid( function(args){if ( clearCB ) {clearCB()};}, null);mkey.exec('Cache', 'clear', [callbackId]);},calculate : function(calculateCB){var callbackid = mkey.helper.callbackid( function(args){if ( calculateCB ) {calculateCB(args)};}, null);mkey.exec('Cache', 'calculate', [callbackid]);},setMaxSize : function (size) {mkey.exec('Cache', 'setMaxSize', [size]);}};})(window.__Mkey__);";
    }

    public static int getStatusHeight(android.content.Context context) {
        try {
            if (android.os.Build.VERSION.SDK_INT < 29) {
                java.lang.Class<?> cls = java.lang.Class.forName("com.android.internal.R$dimen");
                return context.getResources().getDimensionPixelSize(java.lang.Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            }
            android.content.res.Resources resources = context.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", com.taobao.weex.WXEnvironment.OS);
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return -1;
        } catch (java.lang.Exception e) {
            io.dcloud.common.adapter.util.Logger.e(TAG, "getStatusHeight --" + e.getMessage());
            return -1;
        }
    }

    public static java.lang.String getSystemUIModeType(android.app.Activity activity) {
        switch (((android.app.UiModeManager) activity.getSystemService("uimode")).getCurrentModeType()) {
            case 0:
                return com.taobao.weex.common.Constants.Name.UNDEFINED;
            case 1:
                return isTablet(activity) ? "pad" : "phone";
            case 2:
                return "pc";
            case 3:
                return "car";
            case 4:
                return "tv";
            case 5:
                return "appliance";
            case 6:
                return "watch";
            case 7:
                return "vr";
            default:
                return "unknown";
        }
    }

    public static long getTotalMemory() {
        long j = sTotalMem;
        if (j != -1) {
            return j;
        }
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader("/proc/meminfo"), 8192);
            long jIntValue = java.lang.Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue();
            try {
                bufferedReader.close();
                sTotalMem = jIntValue;
                return jIntValue;
            } catch (java.lang.Exception unused) {
                return jIntValue;
            }
        } catch (java.lang.Exception unused2) {
            return 0L;
        }
    }

    public static java.lang.String getUpdateIMSI() {
        java.lang.String imsi = io.dcloud.common.util.TelephonyUtil.getIMSI(sApplicationContext);
        sIMSI = imsi;
        if (imsi == null) {
            sIMSI = "";
        }
        return sIMSI;
    }

    public static boolean hasRootPrivilege() {
        boolean z;
        java.lang.String[] strArr = rootRelatedDirs;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (new java.io.File(strArr[i]).exists()) {
                z = true;
                break;
            }
            i++;
        }
        java.lang.String str = android.os.Build.TAGS;
        return (str != null && str.contains("test-keys")) || z;
    }

    public static void hideIME(android.view.View view) {
        android.os.IBinder windowToken;
        android.content.Context context = sApplicationContext;
        if (context != null) {
            android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) context.getSystemService("input_method");
            if (view == null || (windowToken = view.getWindowToken()) == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        }
    }

    public static void init(android.content.Context context) {
        sDeviceSdkVer = android.os.Build.VERSION.SDK_INT;
        java.lang.String str = android.os.Build.MODEL;
        sModel = str;
        if ("OMAP_SS".equals(str)) {
            osType = 1;
        } else if ("OMS1_5".equals(sModel)) {
            osType = 2;
        } else if ("generic".equals(sModel)) {
            osType = 3;
        }
        mAppAuthorities = context.getPackageName() + ".dc.fileprovider";
        sBrand = android.os.Build.BRAND;
        sVendor = android.os.Build.MANUFACTURER;
        sLanguage = io.dcloud.common.util.language.LanguageUtil.getDeviceDefLocalLanguage();
        android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        sDensity = displayMetrics.density;
        dpiX = displayMetrics.xdpi;
        dpiY = displayMetrics.ydpi;
        sConnectMgr = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        sStatusBarHeight = getStatusHeight(context);
    }

    public static void initAppDir(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(sPrivateExternalDir)) {
            try {
                java.io.File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null) {
                    sPrivateExternalDir = android.os.Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + context.getPackageName();
                } else {
                    sPrivateExternalDir = externalCacheDir.getParent();
                }
                sPrivateDir = context.getFilesDir().getParent();
            } catch (java.lang.Exception unused) {
            }
            sPublicDocumentsDir = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DOCUMENTS).getPath();
            sPublicDCIMDir = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DCIM).getPath();
            sPublicDownloadDir = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DOWNLOADS).getPath();
            sPublicMoviesDir = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_MOVIES).getPath();
            sPublicMusicDir = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_MUSIC).getPath();
            sPublicPicturesDir = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_PICTURES).getPath();
            sPublicRingtonesDir = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_RINGTONES).getPath();
        }
    }

    public static void initBaseFsRootPath() {
        initPath(sApplicationContext);
    }

    public static void initGsmCdmaCell() {
        if (sNetWorkInited || io.dcloud.common.util.AppRuntime.hasPrivacyForNotShown(sApplicationContext)) {
            return;
        }
        java.lang.String string = android.provider.Settings.System.getString(sApplicationContext.getContentResolver(), DEFAULT_DATA_NETWORK);
        sDeftDataNetwork = string;
        if (string == null) {
            sDeftDataNetwork = GSM_DATA_NETWORK;
        }
        sIMEI = io.dcloud.common.util.TelephonyUtil.updateIMEI(sApplicationContext);
        sIMSI = io.dcloud.common.util.TelephonyUtil.getIMSI(sApplicationContext);
        if ("none".equals(sDeftDataNetwork)) {
            sDeftDataNetwork = GSM_DATA_NETWORK;
        }
        if (sIMEI == null) {
            sIMEI = "";
        }
        if (sIMSI == null) {
            sIMSI = "";
        }
        sNetWorkInited = true;
    }

    public static void initPath(android.content.Context context) {
        initPath(context, true);
    }

    private static java.lang.String intToIp(int i) {
        return (i & 255) + com.taobao.weex.el.parse.Operators.DOT_STR + ((i >> 8) & 255) + com.taobao.weex.el.parse.Operators.DOT_STR + ((i >> 16) & 255) + com.taobao.weex.el.parse.Operators.DOT_STR + ((i >> 24) & 255);
    }

    public static java.lang.Boolean isAppNightMode(android.content.Context context) {
        if (androidx.appcompat.app.AppCompatDelegate.getDefaultNightMode() == 2) {
            return java.lang.Boolean.TRUE;
        }
        return androidx.appcompat.app.AppCompatDelegate.getDefaultNightMode() == 1 ? java.lang.Boolean.FALSE : isSystemNightMode(context);
    }

    public static boolean isOMS() {
        int i = osType;
        return i == 1 || i == 2 || i == 3;
    }

    public static boolean isSDcardExists() {
        return "mounted".equals(android.os.Environment.getExternalStorageState());
    }

    private static boolean isStreamMode() {
        try {
            java.lang.Class.forName("io.dcloud.appstream.StreamAppMainActivity");
            return true;
        } catch (java.lang.ClassNotFoundException e) {
            io.dcloud.common.adapter.util.Logger.i(TAG, "e.getMessage" + e.getMessage());
            return false;
        }
    }

    public static java.lang.Boolean isSystemNightMode(android.content.Context context) {
        return java.lang.Boolean.valueOf((context.getApplicationContext().getResources().getConfiguration().uiMode & 48) == 32);
    }

    public static boolean isTablet(android.content.Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    static /* synthetic */ void lambda$showSoftInput$0(android.view.View view) {
        if (view != null) {
            ((android.view.inputmethod.InputMethodManager) sApplicationContext.getSystemService("input_method")).showSoftInput(view, 0);
        }
    }

    static /* synthetic */ void lambda$showSoftInput$1(android.view.View view, boolean z) {
        android.content.Context context;
        if (view != null && z && !view.hasFocus()) {
            view.requestFocus();
        }
        if (isIMEShow || (context = sApplicationContext) == null) {
            return;
        }
        ((android.view.inputmethod.InputMethodManager) context.getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    public static boolean locationEnable(android.content.Context context) {
        android.location.LocationManager locationManager = (android.location.LocationManager) context.getSystemService("location");
        if (locationManager == null) {
            return false;
        }
        return locationManager.isLocationEnabled();
    }

    public static void openHardwareAccelerated(android.app.Activity activity, int i, java.lang.Object obj) {
        android.view.Window window = null;
        if (i != HARDWAREACCELERATED_WINDOW) {
            if (i != HARDWAREACCELERATED_VIEW || sDeviceSdkVer < 11) {
                return;
            }
            ((android.view.View) obj).setLayerType(2, null);
            return;
        }
        android.view.Window window2 = (android.view.Window) obj;
        if (window2 != null) {
            window = window2;
        } else if (activity != null) {
            window = activity.getWindow();
        }
        if (window != null) {
            window.setFlags(16777216, 16777216);
        }
    }

    public static void showIME(android.view.View view) {
        showIME(view, false);
    }

    private static void showSoftInput(final android.view.View view, final boolean z) {
        if (view == null || !(view instanceof android.widget.EditText)) {
            io.dcloud.common.adapter.util.MessageHandler.postDelayed(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.util.DeviceInfo$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    io.dcloud.common.adapter.util.DeviceInfo.lambda$showSoftInput$1(view, z);
                }
            }, 250L);
        } else {
            io.dcloud.common.adapter.util.MessageHandler.postDelayed(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.util.DeviceInfo$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    io.dcloud.common.adapter.util.DeviceInfo.lambda$showSoftInput$0(view);
                }
            }, 100L);
        }
    }

    public static boolean startsWithSdcard(java.lang.String str) {
        return str.startsWith(sDeviceRootDir) || str.startsWith("/sdcard/") || str.startsWith("mnt/sdcard/") || str.startsWith(sCacheRootDir);
    }

    public static void updateIMEI() {
        sIMEI = io.dcloud.common.util.TelephonyUtil.updateIMEI(sApplicationContext);
    }

    public static void updatePath(boolean z) {
        sBaseFsRootFullPath = FILE_PROTOCOL + sBaseFsRootPath;
        sBaseResRootFullPath = io.dcloud.feature.internal.sdk.SDK.ANDROID_ASSET;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("sPackageName=" + sPackageName).append(";\n");
        stringBuffer.append("sDeviceRootDir=" + sDeviceRootDir).append(";\n");
        stringBuffer.append("sBaseFsRootPath=" + sBaseFsRootPath).append(";\n");
        stringBuffer.append("sBaseFsRootFullPath=" + sBaseFsRootFullPath).append(";\n");
        stringBuffer.append("sBaseResRootFullPath=" + sBaseResRootFullPath).append(";\n");
        io.dcloud.common.adapter.util.Logger.d(TAG, stringBuffer.toString());
        io.dcloud.common.util.BaseInfo.updateBaseInfo(z);
    }

    public static void updateStatusBarHeight(android.app.Activity activity) {
        if (sStatusBarHeight == 0) {
            android.graphics.Rect rect = new android.graphics.Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int i = rect.top;
            sStatusBarHeight = i;
            if (i <= 0) {
                sStatusBarHeight = getStatusHeight(activity);
            }
        }
    }

    public static boolean wifiEnable(android.content.Context context) {
        return ((android.net.wifi.WifiManager) context.getApplicationContext().getSystemService("wifi")).getWifiState() == 3;
    }

    public static void initPath(android.content.Context context, boolean z) {
        io.dcloud.common.adapter.util.AndroidResources.initAndroidResources(context);
        sApplicationContext = context.getApplicationContext();
        java.lang.String packageName = context.getPackageName();
        sPackageName = packageName;
        if (sDeviceRootDir != null) {
            return;
        }
        boolean zEquals = packageName.equals("io.dcloud.HBuilder");
        boolean zIsSDcardExists = isSDcardExists();
        boolean z2 = io.dcloud.common.util.BaseInfo.ISDEBUG || io.dcloud.common.adapter.io.DHFile.hasFile();
        if (zEquals) {
            z2 = true;
        }
        if (z2 || io.dcloud.feature.internal.sdk.SDK.isUniMP) {
            z = true;
        }
        if (z) {
            initAppDir(context);
        }
        java.lang.String str = sBaseFsRootPath;
        if (zIsSDcardExists) {
            if (str == null) {
                try {
                    context.getExternalCacheDir();
                } catch (java.lang.Exception unused) {
                }
                if (z) {
                    sDeviceRootDir = android.os.Environment.getExternalStorageDirectory().getPath();
                    str = sDeviceRootDir + "/Android/data/" + sPackageName + sSeparatorChar + "";
                }
            }
            sBaseFsRootPath = str;
            if (z2) {
                sCacheRootDir = sDeviceRootDir;
                sBaseFsCachePath = str;
            } else {
                isPrivateDirectory = true;
                sCacheRootDir = context.getFilesDir().getParent() + sSeparatorChar;
                sBaseFsCachePath = context.getFilesDir().getAbsolutePath() + sSeparatorChar;
            }
        } else {
            io.dcloud.common.util.BaseInfo.ISDEBUG = false;
            isPrivateDirectory = true;
            java.lang.String str2 = context.getFilesDir().getParent() + sSeparatorChar;
            sDeviceRootDir = str2;
            sCacheRootDir = str2;
            java.lang.String str3 = sDeviceRootDir + "";
            sBaseFsRootPath = str3;
            sBaseFsCachePath = str3;
        }
        updatePath(z);
    }

    public static void showIME(android.view.View view, boolean z) {
        if (sApplicationContext != null) {
            showSoftInput(view, z);
        }
    }
}
