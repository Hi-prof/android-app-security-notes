package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public final class BaseInfo {
    public static final java.lang.String REL_PRIVATE_DOC_DIR = "_doc";
    public static final java.lang.String REL_PRIVATE_WWW_DIR = "_www";
    public static final java.lang.String REL_PUBLIC_DOCUMENTS_DIR = "_documents";
    public static final java.lang.String REL_PUBLIC_DOWNLOADS_DIR = "_downloads";
    public static boolean isDefense = false;
    public static final boolean isOnlinePackage = true;
    public static boolean isPostChcekShortCut = false;
    public static int mDeStatusBarBackground = -111111;
    public static boolean sAnimationCaptureB = true;
    public static boolean sAnimationCaptureC = true;
    public static final java.lang.String sBaseVersion = "1.9.9.82680";
    public static java.lang.String sChannel = "";
    public static java.lang.String sCurrentAppOriginalAppid = null;
    public static java.lang.String sDefWebViewUserAgent = "";
    public static java.lang.String sDefaultBootApp = null;
    public static boolean sDoingAnimation = false;
    public static java.lang.String sFontScale = "none";
    public static float sFontScaleFloat = 1.0f;
    public static boolean sFullScreenChanged = false;
    public static java.lang.String sGlobalAuthority = null;
    public static java.lang.String sGlobalUserAgent = null;
    public static java.lang.String sLastAppVersionName = null;
    public static java.lang.String sLastRunApp = null;
    public static int sOpenedCount = 0;
    public static long sProcessId = 0;
    public static int sTimeOutCount = 0;
    public static int sTimeOutMax = 3;
    public static int sTimeoutCapture = 350;
    public static java.lang.String sWap2AppTemplateVersion;
    public static long splashCloseTime;
    public static long splashCreateTime;
    public static long startTime;
    public static java.util.HashMap<java.lang.String, io.dcloud.common.util.BaseInfo.CmtInfo> mLaunchers = new java.util.HashMap<>();
    public static java.lang.String sSplashExitCondition = io.dcloud.common.constant.AbsoluteConst.EVENTS_LOADED;
    public static boolean sGlobalFullScreen = false;
    public static java.lang.String sBaseControlPath = io.dcloud.common.adapter.util.DeviceInfo.sBaseResRootPathName + "data/dcloud_control.xml";
    public static java.lang.String sBaseWap2AppTemplatePath = null;
    public static long sTemplateModifyTime = 0;
    public static java.util.ArrayList<java.lang.String> mWap2appTemplateFiles = new java.util.ArrayList<>();
    public static java.util.HashMap<java.lang.String, byte[]> mW2AE = new java.util.HashMap<>();
    public static java.lang.String sBaseConfigTemplatePath = io.dcloud.common.adapter.util.DeviceInfo.sBaseResRootPathName + "data/wap2app/__template.json";
    public static java.lang.String sBaseWap2AppFilePath = io.dcloud.common.adapter.util.DeviceInfo.sBaseResRootPathName + "data/wap2app/__wap2app.js";
    public static java.lang.String sRuntimeJsPath = "io/dcloud/all.js";
    public static java.lang.String sUniNViewServiceJsPath = io.dcloud.common.adapter.util.DeviceInfo.sBaseResRootPathName + "data/dcloud3.dat";
    public static java.lang.String sURDFilePath = null;
    public static boolean ISDEBUG = false;
    public static boolean SyncDebug = false;
    public static boolean AuxiliaryInput = false;
    public static boolean USE_ACTIVITY_HANDLE_KEYEVENT = true;
    public static boolean sSupportAddByHand = true;
    public static io.dcloud.feature.internal.sdk.SDK.IntegratedMode sRuntimeMode = null;
    public static java.lang.String PDR = "pdr";
    public static java.lang.String WGTU_UPDATE_XML = "update.xml";
    public static java.lang.String APP_WEB_CHACHE = "webcache/";
    public static java.lang.String APP_JSDATA = "jsdata/";
    public static java.lang.String APP_DB_DATA = "dbdata/";
    private static java.lang.String APPS_NAME = "apps/";
    private static java.lang.String SITMAP = "sitemap/";
    public static boolean ISAMU = false;
    public static boolean s_Is_DCloud_Packaged = false;
    public static java.lang.String uniVersionV3 = "";
    public static int s_Webview_Count = 0;
    public static int s_Runing_App_Count = 0;
    public static int s_Runing_App_Count_Max = 3;
    public static int s_Runing_App_Count_Trim = 0;
    public static java.util.ArrayList<java.lang.String> sRunningApp = null;
    public static java.lang.String sBaseResAppsFullPath = null;
    public static java.lang.String sBaseResAppsPath = null;
    public static java.lang.String sCacheFsAppsPath = null;
    public static java.lang.String sBaseFsAppsPath = null;
    public static java.lang.String sBaseFsSitMapPath = null;
    public static java.lang.String sDownloadFullPath = null;
    public static java.lang.String sDocumentFullPath = "";
    public static boolean sCoverApkRuning = false;
    public static java.lang.String s_properties = "/data/dcloud_properties.xml";
    public static java.lang.String sConfigXML = "manifest.json";
    public static java.lang.String APP_WWW_FS_DIR = "www/";
    public static java.lang.String sBaseNotificationPath = null;
    public static java.lang.String REAL_PRIVATE_WWW_DIR = "www/";
    public static java.lang.String REAL_PRIVATE_DOC_DIR = "doc/";
    public static java.lang.String REAL_PUBLIC_DOCUMENTS_DIR = "documents/";
    public static java.lang.String REAL_PUBLIC_DOWNLOADS_DIR = "downloads/";
    public static boolean isDefaultAim = true;
    public static long run5appEndTime = 0;
    public static boolean isUniStatistics = false;
    public static java.lang.String untrustedca = "accept";
    public static java.lang.String lia = "";
    public static java.lang.String renderer = "";
    public static java.lang.String minUserAgentVersion = "";
    public static int timeOut = androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat.MAX_NUM_POINTS;
    public static boolean showTipsWithoutWifi = false;
    public static boolean allowDownloadWithoutWiFi = false;
    private static boolean sParsedControl = false;
    public static java.lang.String STKEY = "2aSGNEUriKrg4cDH";
    public static java.util.HashMap<java.lang.String, io.dcloud.common.util.BaseInfo.BaseAppInfo> mUnInstalledAppInfoSet = new java.util.HashMap<>();
    public static java.util.HashMap<java.lang.String, io.dcloud.common.util.BaseInfo.BaseAppInfo> mInstalledAppInfoSet = new java.util.HashMap<>();
    public static java.util.HashMap<java.lang.String, io.dcloud.common.util.BaseInfo.BaseAppInfo> mBaseAppInfoSet = new java.util.HashMap<>();
    private static final javax.security.auth.x500.X500Principal DEBUG_DN = new javax.security.auth.x500.X500Principal("CN=Android Debug,O=Android,C=US");
    public static boolean isImmersive = false;
    public static boolean injectionGeolocationJS = false;
    public static boolean isFirstRun = false;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class AppIsTestWrapper {
        static final java.lang.String name = "test_app";
        android.content.Context mContext = null;

        public boolean containsKey(java.lang.String str) {
            return io.dcloud.common.adapter.util.SP.getOrCreateBundle(name, true).contains(str);
        }

        public void init(android.content.Context context) {
            this.mContext = context;
        }

        public void put(java.lang.String str, java.lang.String str2) {
            android.content.SharedPreferences.Editor editorEdit = io.dcloud.common.adapter.util.SP.getOrCreateBundle(name, true).edit();
            editorEdit.putString(str, str2);
            editorEdit.commit();
        }

        public void remove(java.lang.String str) {
            io.dcloud.common.adapter.util.SP.getOrCreateBundle(name, true).edit().remove(str).commit();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class BaseAppInfo {
        public java.lang.String mAppVer;
        java.lang.String mAppid;
        public boolean mMoreRecent = true;
        public boolean mDeleted = false;

        public BaseAppInfo(java.lang.String str, java.lang.String str2) {
            this.mAppid = str;
            this.mAppVer = str2;
        }

        public static final boolean compareVersion(java.lang.String str, java.lang.String str2) {
            int i;
            int i2;
            if (android.text.TextUtils.isEmpty(str2)) {
                return true;
            }
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                java.lang.String[] strArrSplit = str.split("\\.");
                java.lang.String[] strArrSplit2 = str2.split("\\.");
                int length = strArrSplit.length;
                int length2 = strArrSplit2.length;
                for (int i3 = 0; i3 < length; i3++) {
                    if (i3 >= length2 || (i = java.lang.Integer.parseInt(strArrSplit[i3])) > (i2 = java.lang.Integer.parseInt(strArrSplit2[i3]))) {
                        return true;
                    }
                    if (i < i2) {
                        return false;
                    }
                }
                return false;
            } catch (java.lang.NumberFormatException e) {
                e.printStackTrace();
                return false;
            }
        }

        public void clearBundleData() {
            io.dcloud.common.adapter.util.SP.removeBundleData(io.dcloud.common.util.BaseInfo.PDR, this.mAppid + "_appver");
        }

        boolean high(io.dcloud.common.util.BaseInfo.BaseAppInfo baseAppInfo) {
            return compareVersion(this.mAppVer, baseAppInfo.mAppVer);
        }

        public void saveToBundleData(android.content.Context context) {
            io.dcloud.common.adapter.util.SP.setBundleData(context, io.dcloud.common.util.BaseInfo.PDR, this.mAppid + "_appver", this.mAppVer);
            io.dcloud.common.adapter.util.SP.setBundleData(context, io.dcloud.common.util.BaseInfo.PDR, this.mAppid + "_deleted", java.lang.String.valueOf(this.mDeleted));
            java.lang.String strInstallAppMapToString = io.dcloud.common.util.BaseInfo.installAppMapToString();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            if (!io.dcloud.common.util.PdrUtil.isEmpty(strInstallAppMapToString)) {
                stringBuffer.append(strInstallAppMapToString).append("|");
            }
            stringBuffer.append(this.mAppid);
            io.dcloud.common.adapter.util.SP.setBundleData(context, io.dcloud.common.util.BaseInfo.PDR, io.dcloud.common.constant.AbsoluteConst.XML_APPS, stringBuffer.toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class CmtInfo {
        public java.lang.String plusLauncher;
        public java.lang.String sStartupTime;
        public java.lang.String sfd;
        public java.lang.String templateVersion;
        public boolean rptCrs = true;
        public boolean rptJse = true;
        public boolean needUpdate = true;
    }

    public static boolean checkAppIsTest(java.lang.String str) {
        return new java.io.File(sCacheFsAppsPath + str + "/.test").exists();
    }

    private static void checkOrResetTemplate(io.dcloud.common.DHInterface.IApp iApp) {
        org.json.JSONObject jSONObject;
        java.io.File file = new java.io.File(sBaseWap2AppTemplatePath + "wap2app__template/__template.json");
        long jLastModified = file.lastModified();
        if (sTemplateModifyTime != jLastModified) {
            try {
                mWap2appTemplateFiles.clear();
                mW2AE.clear();
                try {
                    jSONObject = new org.json.JSONObject(new java.lang.String(io.dcloud.common.util.IOUtil.getBytes(new io.dcloud.common.adapter.io.UnicodeInputStream(new java.io.FileInputStream(file), java.nio.charset.Charset.defaultCharset().name()))));
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    jSONObject = null;
                }
                int i = 0;
                if (jSONObject == null || !jSONObject.has("files")) {
                    java.lang.String[] list = new java.io.File(sBaseWap2AppTemplatePath + "wap2app__template/").list();
                    if (list != null) {
                        while (i < list.length) {
                            mWap2appTemplateFiles.add(list[i]);
                            i++;
                        }
                    }
                } else {
                    org.json.JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("files");
                    int length = jSONArrayOptJSONArray.length();
                    while (i < length) {
                        mWap2appTemplateFiles.add(jSONArrayOptJSONArray.optString(i));
                        i++;
                    }
                }
                if (jSONObject.has(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CONFUSION)) {
                    java.lang.String strHandleEncryption = iApp.getConfusionMgr().handleEncryption(iApp.getActivity(), io.dcloud.common.util.Base64.decode2bytes(jSONObject.optString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CONFUSION)));
                    if (io.dcloud.common.util.PdrUtil.isEmpty(strHandleEncryption)) {
                        strHandleEncryption = "{}";
                    }
                    iApp.getConfusionMgr().removeData("__w2a__template__");
                    iApp.getConfusionMgr().recordEncryptionResources("__w2a__template__", new org.json.JSONObject(strHandleEncryption));
                }
                sWap2AppTemplateVersion = jSONObject.optString("version");
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
            } catch (java.lang.Exception e3) {
                e3.printStackTrace();
            }
        }
        sTemplateModifyTime = jLastModified;
    }

    public static boolean checkTestOpenFile() {
        return new java.io.File(io.dcloud.common.adapter.util.DeviceInfo.sDeviceRootDir + "/.system/d85a37c6-afdc-11e6-80f5-76304dec7eb7").exists();
    }

    public static void clearData() {
        sParsedControl = false;
        sGlobalFullScreen = false;
        io.dcloud.common.adapter.util.UEH.sInited = false;
        sCurrentAppOriginalAppid = null;
        sLastRunApp = null;
        sRunningApp = null;
        s_Webview_Count = 0;
        s_Runing_App_Count = 0;
        io.dcloud.common.adapter.util.DeviceInfo.DEVICESTATUS_JS = null;
    }

    public static boolean containsInTemplate(io.dcloud.common.DHInterface.IApp iApp, java.lang.String str) {
        if ((iApp.getActivity() instanceof io.dcloud.common.DHInterface.IActivityHandler) && ((io.dcloud.common.DHInterface.IActivityHandler) iApp.getActivity()).isMultiProcessMode()) {
            checkOrResetTemplate(iApp);
        }
        return mWap2appTemplateFiles.contains(str);
    }

    public static void createAppTestFile(java.lang.String str) {
        java.io.File file = new java.io.File(sCacheFsAppsPath + str + "/.test");
        if (file.exists()) {
            return;
        }
        try {
            file.mkdirs();
            file.createNewFile();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean existsBase() {
        try {
            return new java.io.File(android.os.Environment.getExternalStorageDirectory() + "/Android/data/io.dcloud.HBuilder").exists();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean existsLibso() {
        try {
            java.lang.System.loadLibrary("so");
            return true;
        } catch (java.lang.UnsatisfiedLinkError unused) {
            return false;
        }
    }

    public static boolean existsStreamEnv() {
        try {
            java.lang.Class.forName("io.dcloud.appstream.StreamAppMainActivity");
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static java.lang.String getAnalysisChannel() {
        java.lang.String metaValue = sChannel;
        if (android.text.TextUtils.isEmpty(metaValue)) {
            metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_STREAMAPP_CHANNEL");
        }
        if (android.text.TextUtils.isEmpty(metaValue)) {
            return "";
        }
        if (metaValue.startsWith("_")) {
            return metaValue.substring(1);
        }
        if (!metaValue.contains("|")) {
            return metaValue;
        }
        java.lang.String[] strArrSplit = metaValue.split("\\|");
        return strArrSplit.length >= 4 ? strArrSplit[3] : "";
    }

    public static io.dcloud.common.util.BaseInfo.CmtInfo getCmitInfo(java.lang.String str) {
        io.dcloud.common.util.BaseInfo.CmtInfo cmtInfo = mLaunchers.get(str);
        if (cmtInfo != null) {
            return cmtInfo;
        }
        io.dcloud.common.util.BaseInfo.CmtInfo cmtInfo2 = new io.dcloud.common.util.BaseInfo.CmtInfo();
        mLaunchers.put(str, cmtInfo2);
        return cmtInfo2;
    }

    public static java.lang.String getCrashLogsPath(android.content.Context context) {
        return io.dcloud.common.adapter.util.DeviceInfo.sBaseFsRootPath + "logs/" + context.getPackageName() + "/";
    }

    public static java.lang.String getLastKey(java.util.LinkedHashMap<java.lang.String, android.content.Intent> linkedHashMap) {
        java.lang.String next = null;
        if (linkedHashMap != null) {
            java.util.Iterator<java.lang.String> it = linkedHashMap.keySet().iterator();
            while (it.hasNext()) {
                next = it.next();
            }
        }
        return next;
    }

    public static java.lang.String getLauncherData(java.lang.String str) {
        io.dcloud.common.util.BaseInfo.CmtInfo cmtInfo = mLaunchers.get(str);
        return (cmtInfo == null || android.text.TextUtils.isEmpty(cmtInfo.plusLauncher)) ? "default" : cmtInfo.plusLauncher;
    }

    public static java.lang.String getShortCutActivity(android.content.Context context) {
        return null;
    }

    public static java.lang.String getStackTrace() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (java.lang.StackTraceElement stackTraceElement : java.lang.Thread.currentThread().getStackTrace()) {
            stringBuffer.append(stackTraceElement).append("\n");
        }
        return stringBuffer.toString();
    }

    public static java.lang.String getStartupTimeData(java.lang.String str) {
        io.dcloud.common.util.BaseInfo.CmtInfo cmtInfo = mLaunchers.get(str);
        if (cmtInfo != null) {
            return cmtInfo.sStartupTime;
        }
        return null;
    }

    public static java.lang.String getUniNViewId(io.dcloud.common.DHInterface.IFrameView iFrameView) {
        return iFrameView.getFrameType() == 2 ? iFrameView.obtainApp().obtainAppId() : iFrameView.obtainWebView().getWebviewUUID();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String installAppMapToString() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.util.Set<java.lang.String> setKeySet = mInstalledAppInfoSet.keySet();
        int size = setKeySet.size();
        java.util.Iterator<java.lang.String> it = setKeySet.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next()).append("|");
        }
        if (size > 1) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    public static boolean isBase(android.content.Context context) {
        return SyncDebug || context.getPackageName().equals("io.dcloud.HBuilder");
    }

    public static boolean isChannelGooglePlay() {
        java.lang.String metaValue = sChannel;
        if (android.text.TextUtils.isEmpty(metaValue)) {
            metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_STREAMAPP_CHANNEL");
        }
        return !android.text.TextUtils.isEmpty(metaValue) && metaValue.endsWith("|google");
    }

    private static boolean isDebugSignature(android.content.Context context) {
        try {
            boolean zEquals = false;
            for (android.content.pm.Signature signature : context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures) {
                try {
                    zEquals = ((java.security.cert.X509Certificate) java.security.cert.CertificateFactory.getInstance("X.509").generateCertificate(new java.io.ByteArrayInputStream(signature.toByteArray()))).getSubjectX500Principal().equals(DEBUG_DN);
                    if (zEquals) {
                        return zEquals;
                    }
                } catch (android.content.pm.PackageManager.NameNotFoundException | java.security.cert.CertificateException | java.lang.Exception unused) {
                    return zEquals;
                }
            }
            return zEquals;
        } catch (android.content.pm.PackageManager.NameNotFoundException | java.security.cert.CertificateException | java.lang.Exception unused2) {
            return false;
        }
    }

    public static synchronized boolean isLoadingLaunchePage() {
        return false;
    }

    public static boolean isStandardBase(android.content.Context context) {
        return context.getPackageName().equals("io.dcloud.HBuilder");
    }

    public static boolean isTest(java.lang.String str) {
        return false;
    }

    public static boolean isUniAppAppid(io.dcloud.common.DHInterface.IApp iApp) {
        java.lang.String str;
        if (iApp != null) {
            java.lang.String strObtainConfigProperty = iApp.obtainConfigProperty(io.dcloud.common.constant.AbsoluteConst.APP_IS_UNIAPP);
            if (!io.dcloud.common.util.PdrUtil.isEmpty(strObtainConfigProperty)) {
                return java.lang.Boolean.valueOf(strObtainConfigProperty).booleanValue();
            }
            java.lang.String strObtainAppId = iApp.obtainAppId();
            if (!android.text.TextUtils.isEmpty(strObtainAppId)) {
                if ("HBuilder".equals(strObtainAppId) && (str = sCurrentAppOriginalAppid) != null) {
                    strObtainAppId = str;
                }
                return strObtainAppId.startsWith("__UNI__");
            }
        }
        return false;
    }

    public static boolean isUniNViewBackgroud() {
        return java.lang.Boolean.valueOf(io.dcloud.common.adapter.util.AndroidResources.getMetaValue(io.dcloud.common.constant.AbsoluteConst.DCLOUD_UNINVIEW_BACKGROUD)).booleanValue();
    }

    public static boolean isWap2AppAppid(java.lang.String str) {
        java.lang.String str2;
        if (str == null) {
            return false;
        }
        if ("HBuilder".equals(str) && (str2 = sCurrentAppOriginalAppid) != null) {
            str = str2;
        }
        java.lang.String lowerCase = str.toLowerCase(java.util.Locale.ENGLISH);
        return lowerCase.startsWith("__w2a__") || "H52588A9C".equalsIgnoreCase(lowerCase) || "H5B5EEFBB".equalsIgnoreCase(lowerCase) || "H5A0B1958".equalsIgnoreCase(lowerCase) || "H5EA885FD".equalsIgnoreCase(lowerCase) || "H592E7F63".equalsIgnoreCase(lowerCase) || "H5BCD03E4".equalsIgnoreCase(lowerCase);
    }

    public static boolean isWeexUniJs(io.dcloud.common.DHInterface.IApp iApp) {
        java.lang.String strObtainConfigProperty = iApp.obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_UNIAPP_CONTROL);
        if (android.text.TextUtils.isEmpty(strObtainConfigProperty)) {
            return false;
        }
        return (strObtainConfigProperty.equals(com.taobao.weex.common.Constants.CodeCache.SAVE_PATH) || strObtainConfigProperty.equals(io.dcloud.common.constant.AbsoluteConst.UNI_V3)) && isUniAppAppid(iApp);
    }

    public static boolean isWifi(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static void loadInstalledAppInfo(android.content.Context context) {
        java.lang.String[] strArrListFsAppsFiles;
        java.lang.String bundleData = io.dcloud.common.adapter.util.SP.getBundleData(context, PDR, io.dcloud.common.constant.AbsoluteConst.XML_APPS);
        if (bundleData != null) {
            for (java.lang.String str : bundleData.split("\\|")) {
                io.dcloud.common.util.BaseInfo.BaseAppInfo baseAppInfo = new io.dcloud.common.util.BaseInfo.BaseAppInfo(str, io.dcloud.common.adapter.util.SP.getBundleData(context, PDR, str + "_appver"));
                boolean z = java.lang.Boolean.parseBoolean(io.dcloud.common.adapter.util.SP.getBundleData(context, PDR, str + "_deleted"));
                baseAppInfo.mDeleted = z;
                if (z) {
                    mUnInstalledAppInfoSet.put(str, baseAppInfo);
                } else if (!io.dcloud.common.util.PdrUtil.isEmpty(str)) {
                    mInstalledAppInfoSet.put(str, baseAppInfo);
                }
            }
        }
        if (!sSupportAddByHand || (strArrListFsAppsFiles = io.dcloud.common.adapter.util.PlatformUtil.listFsAppsFiles(sBaseFsAppsPath)) == null) {
            return;
        }
        for (java.lang.String str2 : strArrListFsAppsFiles) {
            if (!mInstalledAppInfoSet.containsKey(str2)) {
                java.lang.String str3 = sDefaultBootApp;
                java.util.Locale locale = java.util.Locale.ENGLISH;
                if (android.text.TextUtils.equals(str3.toLowerCase(locale), str2.toLowerCase(locale))) {
                    mInstalledAppInfoSet.put(str2, new io.dcloud.common.util.BaseInfo.BaseAppInfo(str2, com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT));
                }
            }
        }
    }

    public static void parseControl() {
        io.dcloud.common.util.XmlUtil.DHNode dHNodeXML_Parser;
        java.io.InputStream resInputStream = io.dcloud.common.adapter.util.PlatformUtil.getResInputStream(sBaseControlPath);
        if (resInputStream == null || (dHNodeXML_Parser = io.dcloud.common.util.XmlUtil.XML_Parser(resInputStream)) == null) {
            return;
        }
        boolean z = java.lang.Boolean.parseBoolean(io.dcloud.common.util.XmlUtil.getAttributeValue(dHNodeXML_Parser, io.dcloud.common.constant.AbsoluteConst.XML_SyncDebug, io.dcloud.common.constant.AbsoluteConst.FALSE));
        SyncDebug = z;
        ISDEBUG = z || java.lang.Boolean.parseBoolean(io.dcloud.common.util.XmlUtil.getAttributeValue(dHNodeXML_Parser, "debug", io.dcloud.common.constant.AbsoluteConst.FALSE));
        io.dcloud.common.util.XmlUtil.DHNode element = io.dcloud.common.util.XmlUtil.getElement(dHNodeXML_Parser, io.dcloud.common.constant.AbsoluteConst.XML_APPS);
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            return;
        }
        java.util.ArrayList<io.dcloud.common.util.XmlUtil.DHNode> elements = io.dcloud.common.util.XmlUtil.getElements(element, io.dcloud.common.constant.AbsoluteConst.XML_APP);
        if (elements.size() > 0) {
            sDefaultBootApp = io.dcloud.common.util.XmlUtil.getAttributeValue(elements.get(0), "appid");
        }
        io.dcloud.common.util.XmlUtil.DHNode element2 = io.dcloud.common.util.XmlUtil.getElement(dHNodeXML_Parser, "lia");
        if (element2 != null) {
            lia = io.dcloud.common.util.XmlUtil.getText(element2);
        }
    }

    public static void putLauncherData(java.lang.String str, java.lang.String str2) {
        getCmitInfo(str).plusLauncher = str2;
    }

    public static void putStartupTimeData(java.lang.String str, java.lang.String str2) {
        getCmitInfo(str).sStartupTime = str2;
    }

    public static void removeTestFile(java.lang.String str) {
        java.io.File file = new java.io.File(sCacheFsAppsPath + str + "/.test");
        if (file.exists()) {
            file.delete();
        }
    }

    public static void saveInstalledAppInfo(android.content.Context context) {
        io.dcloud.common.adapter.util.SP.setBundleData(context, PDR, io.dcloud.common.constant.AbsoluteConst.XML_APPS, installAppMapToString());
    }

    public static synchronized void setLoadingLaunchePage(boolean z, java.lang.String str) {
    }

    public static void setUniVersionV3(java.lang.String str, android.content.Context context) {
        uniVersionV3 = str;
        io.dcloud.common.adapter.util.SP.setBundleData(context, "pdr", "F_V", str);
    }

    public static void updateBaseInfo(boolean z) {
        if (!APPS_NAME.equals("/")) {
            sBaseResAppsFullPath = io.dcloud.common.adapter.util.DeviceInfo.sBaseResRootFullPath + APPS_NAME;
            sBaseResAppsPath = io.dcloud.common.adapter.util.DeviceInfo.sBaseResRootPathName + APPS_NAME;
            sCacheFsAppsPath = io.dcloud.common.adapter.util.DeviceInfo.sBaseFsCachePath + APPS_NAME;
            sBaseFsAppsPath = io.dcloud.common.adapter.util.DeviceInfo.sBaseFsRootPath + APPS_NAME;
            sBaseFsSitMapPath = io.dcloud.common.adapter.util.DeviceInfo.sBaseFsRootPath + SITMAP;
            sBaseWap2AppTemplatePath = io.dcloud.common.adapter.util.DeviceInfo.sBaseFsCachePath + "cnc3ejE5/";
            sURDFilePath = io.dcloud.common.adapter.util.DeviceInfo.sBaseFsCachePath + "cnc3ejE6/eje3cnc";
            if (z) {
                io.dcloud.common.adapter.io.DHFile.createNewFile(sBaseFsAppsPath);
                io.dcloud.common.adapter.io.DHFile.createNewFile(sBaseFsSitMapPath);
            }
        }
        if (z) {
            java.lang.String str = sDownloadFullPath;
            if (str == null || str.indexOf("sdcard/") <= -1) {
                sDownloadFullPath = io.dcloud.common.adapter.util.DeviceInfo.sBaseFsRootPath + REAL_PUBLIC_DOWNLOADS_DIR;
            } else {
                sDownloadFullPath = io.dcloud.common.util.PdrUtil.appendByDeviceRootDir(sDownloadFullPath);
            }
            java.lang.String str2 = sDocumentFullPath;
            if (str2 != null && str2.indexOf("sdcard/") > -1) {
                sDocumentFullPath = io.dcloud.common.util.PdrUtil.appendByDeviceRootDir(sDocumentFullPath);
                return;
            }
            sDocumentFullPath = io.dcloud.common.adapter.util.DeviceInfo.sBaseFsRootPath + REAL_PUBLIC_DOCUMENTS_DIR;
        }
    }

    public static void updateBaseInfoByApp(java.lang.String str, java.lang.String str2) {
        if (str != null) {
            PDR = str;
        }
        if (str2 != null) {
            io.dcloud.common.adapter.util.DeviceInfo.sBaseFsRootPath = str2;
        }
        io.dcloud.common.adapter.util.DeviceInfo.initBaseFsRootPath();
    }

    public static boolean useStreamAppStatistic(android.content.Context context) {
        return true;
    }

    public static java.lang.String getLaunchType(android.content.Intent intent) {
        if (intent == null) {
            return "default";
        }
        android.net.Uri data = intent.getData();
        java.lang.String stringExtra = intent.hasExtra(io.dcloud.common.constant.IntentConst.RUNING_STREAPP_LAUNCHER) ? intent.getStringExtra(io.dcloud.common.constant.IntentConst.RUNING_STREAPP_LAUNCHER) : "default";
        if (data != null && !android.webkit.URLUtil.isNetworkUrl(data.toString())) {
            return intent.getBooleanExtra(io.dcloud.common.constant.IntentConst.FROM_BARCODE, false) ? "barcode" : "scheme";
        }
        if (intent.getExtras() != null) {
            if (!android.text.TextUtils.isEmpty(intent.getStringExtra(io.dcloud.common.constant.IntentConst.STREAM_LAUNCHER))) {
                return intent.getStringExtra(io.dcloud.common.constant.IntentConst.STREAM_LAUNCHER);
            }
            if (intent.getBooleanExtra(io.dcloud.common.constant.IntentConst.FROM_SHORT_CUT_STRAT, false)) {
                return io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_SHORTCUT;
            }
            if (intent.getBooleanExtra(io.dcloud.common.constant.IntentConst.FROM_BARCODE, false)) {
                return "barcode";
            }
            if (intent.getIntExtra(io.dcloud.common.constant.IntentConst.START_FROM, -1) == 3 || intent.hasExtra("UP-OL-SU")) {
                return "push";
            }
            if (intent.getIntExtra(io.dcloud.common.constant.IntentConst.START_FROM, -1) == 5) {
                return "myapp";
            }
            if (intent.getIntExtra(io.dcloud.common.constant.IntentConst.START_FROM, -1) == 7) {
                return "browser";
            }
            if (intent.getIntExtra(io.dcloud.common.constant.IntentConst.START_FROM, -1) == 8) {
                return "favorite";
            }
            if (intent.getIntExtra(io.dcloud.common.constant.IntentConst.START_FROM, -1) == 9) {
                return "engines";
            }
            if (intent.getIntExtra(io.dcloud.common.constant.IntentConst.START_FROM, -1) == 40) {
                return "apush";
            }
            if (intent.getIntExtra(io.dcloud.common.constant.IntentConst.START_FROM, -1) == 10) {
                return "speech";
            }
        }
        return stringExtra;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:103:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:107:0x022f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:17:0x0044  */
    /* JADX WARN: Code duplicated, block: B:20:0x0073 A[Catch: Exception -> 0x003f, TRY_ENTER, TryCatch #1 {Exception -> 0x003f, blocks: (B:11:0x0030, B:20:0x0073, B:22:0x007b, B:32:0x00bc, B:39:0x00f0, B:42:0x0102, B:23:0x0082, B:27:0x0091), top: B:113:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x007b A[Catch: Exception -> 0x003f, TryCatch #1 {Exception -> 0x003f, blocks: (B:11:0x0030, B:20:0x0073, B:22:0x007b, B:32:0x00bc, B:39:0x00f0, B:42:0x0102, B:23:0x0082, B:27:0x0091), top: B:113:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0082 A[Catch: Exception -> 0x003f, TRY_LEAVE, TryCatch #1 {Exception -> 0x003f, blocks: (B:11:0x0030, B:20:0x0073, B:22:0x007b, B:32:0x00bc, B:39:0x00f0, B:42:0x0102, B:23:0x0082, B:27:0x0091), top: B:113:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0085 A[Catch: Exception -> 0x01db, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x01db, blocks: (B:5:0x0011, B:7:0x0019, B:9:0x0022, B:18:0x0045, B:30:0x0098, B:36:0x00d2, B:40:0x00f2, B:43:0x0104, B:45:0x010c, B:47:0x0112, B:25:0x0085, B:29:0x0094), top: B:115:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0091 A[Catch: Exception -> 0x003f, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x003f, blocks: (B:11:0x0030, B:20:0x0073, B:22:0x007b, B:32:0x00bc, B:39:0x00f0, B:42:0x0102, B:23:0x0082, B:27:0x0091), top: B:113:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0094 A[Catch: Exception -> 0x01db, TRY_ENTER, TryCatch #2 {Exception -> 0x01db, blocks: (B:5:0x0011, B:7:0x0019, B:9:0x0022, B:18:0x0045, B:30:0x0098, B:36:0x00d2, B:40:0x00f2, B:43:0x0104, B:45:0x010c, B:47:0x0112, B:25:0x0085, B:29:0x0094), top: B:115:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00bc A[Catch: Exception -> 0x003f, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x003f, blocks: (B:11:0x0030, B:20:0x0073, B:22:0x007b, B:32:0x00bc, B:39:0x00f0, B:42:0x0102, B:23:0x0082, B:27:0x0091), top: B:113:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00c6 A[Catch: Exception -> 0x00d2, TRY_LEAVE, TryCatch #8 {Exception -> 0x00d2, blocks: (B:33:0x00be, B:35:0x00c6), top: B:127:0x00be }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:42:0x0102 A[Catch: Exception -> 0x003f, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x003f, blocks: (B:11:0x0030, B:20:0x0073, B:22:0x007b, B:32:0x00bc, B:39:0x00f0, B:42:0x0102, B:23:0x0082, B:27:0x0091), top: B:113:0x0030 }] */
    public static java.lang.String[] parseControl(android.content.Context context, io.dcloud.common.DHInterface.ICore iCore, io.dcloud.common.DHInterface.ICore.ICoreStatusListener iCoreStatusListener) {
        java.lang.String[] strArr;
        boolean z;
        java.lang.String[] strArr2;
        boolean z2;
        java.lang.String metaValue;
        java.lang.String attributeValue;
        java.lang.String attributeValue2;
        int i;
        int i2;
        java.util.ArrayList<io.dcloud.common.util.XmlUtil.DHNode> elements;
        java.lang.String[] strArr3 = null;
        java.lang.String str = null;
        if (sParsedControl) {
            strArr = null;
        } else {
            boolean z3 = true;
            boolean z4 = false;
            try {
                java.io.InputStream resInputStream = io.dcloud.common.adapter.util.PlatformUtil.getResInputStream(sBaseControlPath);
                if (resInputStream != null) {
                    io.dcloud.common.util.XmlUtil.DHNode dHNodeXML_Parser = io.dcloud.common.util.XmlUtil.XML_Parser(resInputStream);
                    io.dcloud.common.util.IOUtil.close(resInputStream);
                    if (dHNodeXML_Parser != null) {
                        boolean z5 = java.lang.Boolean.parseBoolean(io.dcloud.common.util.XmlUtil.getAttributeValue(dHNodeXML_Parser, io.dcloud.common.constant.AbsoluteConst.XML_SyncDebug, io.dcloud.common.constant.AbsoluteConst.FALSE));
                        SyncDebug = z5;
                        if (!z5) {
                            try {
                                if (java.lang.Boolean.parseBoolean(io.dcloud.common.util.XmlUtil.getAttributeValue(dHNodeXML_Parser, "debug", io.dcloud.common.constant.AbsoluteConst.FALSE))) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                ISDEBUG = z2;
                                AuxiliaryInput = java.lang.Boolean.parseBoolean(io.dcloud.common.util.XmlUtil.getAttributeValue(dHNodeXML_Parser, io.dcloud.common.constant.AbsoluteConst.XML_AUXILIARYINPUT, io.dcloud.common.constant.AbsoluteConst.FALSE));
                                ISAMU = java.lang.Boolean.parseBoolean(io.dcloud.common.util.XmlUtil.getAttributeValue(dHNodeXML_Parser, io.dcloud.common.constant.AbsoluteConst.XML_AMU, io.dcloud.common.constant.AbsoluteConst.FALSE));
                                sGlobalAuthority = io.dcloud.common.util.XmlUtil.getAttributeValue(dHNodeXML_Parser, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTHORITY, (java.lang.String) null);
                                metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_STREAMAPP_CHANNEL");
                                if (!io.dcloud.common.util.PdrUtil.isEmpty(metaValue)) {
                                    if (metaValue.startsWith("_")) {
                                        sChannel = metaValue.substring(1);
                                    } else {
                                        sChannel = metaValue;
                                    }
                                } else {
                                    attributeValue = io.dcloud.common.util.XmlUtil.getAttributeValue(dHNodeXML_Parser, io.dcloud.common.constant.AbsoluteConst.XML_CHANNEL, (java.lang.String) null);
                                    if (!io.dcloud.common.util.PdrUtil.isEmpty(attributeValue)) {
                                        sChannel = attributeValue;
                                    } else {
                                        sChannel = "";
                                    }
                                }
                                sSplashExitCondition = io.dcloud.common.util.XmlUtil.getAttributeValue(dHNodeXML_Parser, "back", sSplashExitCondition);
                                s_Is_DCloud_Packaged = java.lang.Boolean.parseBoolean(io.dcloud.common.util.XmlUtil.getAttributeValue(dHNodeXML_Parser, io.dcloud.common.constant.AbsoluteConst.XML_NS, io.dcloud.common.constant.AbsoluteConst.FALSE));
                                attributeValue2 = io.dcloud.common.util.XmlUtil.getAttributeValue(dHNodeXML_Parser, io.dcloud.common.constant.AbsoluteConst.XML_FONT_SCALE, sFontScale);
                                if (!android.text.TextUtils.isEmpty(attributeValue2)) {
                                    sFontScale = attributeValue2;
                                    try {
                                        if (!"none".equals(attributeValue2)) {
                                            sFontScaleFloat = java.lang.Float.valueOf(sFontScale).floatValue();
                                        }
                                    } catch (java.lang.Exception unused) {
                                    }
                                }
                                sSupportAddByHand &= ISDEBUG;
                                io.dcloud.common.util.XmlUtil.DHNode element = io.dcloud.common.util.XmlUtil.getElement(dHNodeXML_Parser, io.dcloud.common.constant.AbsoluteConst.XML_APPS);
                                i = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.XmlUtil.getAttributeValue(element, "max"), s_Runing_App_Count_Max);
                                s_Runing_App_Count_Max = i;
                                if (i <= 0) {
                                    s_Runing_App_Count_Max = Integer.MAX_VALUE;
                                }
                                i2 = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.XmlUtil.getAttributeValue(element, io.dcloud.common.constant.AbsoluteConst.XML_TRIM), s_Runing_App_Count_Trim);
                                s_Runing_App_Count_Trim = i2;
                                if (i2 <= 0) {
                                    s_Runing_App_Count_Trim = 0;
                                }
                                elements = io.dcloud.common.util.XmlUtil.getElements(element, io.dcloud.common.constant.AbsoluteConst.XML_APP);
                                if (elements == null && !io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
                                    int size = elements.size();
                                    strArr2 = null;
                                    java.util.HashMap<java.lang.String, io.dcloud.common.util.BaseInfo.BaseAppInfo> map = null;
                                    int i3 = 0;
                                    boolean z6 = false;
                                    boolean z7 = true;
                                    while (i3 < size) {
                                        try {
                                            io.dcloud.common.util.XmlUtil.DHNode dHNode = elements.get(i3);
                                            java.lang.String attributeValue3 = io.dcloud.common.util.XmlUtil.getAttributeValue(dHNode, "appid");
                                            if (i3 == 0) {
                                                try {
                                                    strArr2 = new java.lang.String[]{attributeValue3};
                                                    try {
                                                        if (!io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
                                                            sDefaultBootApp = attributeValue3;
                                                        }
                                                        updateBaseInfoByApp(attributeValue3, str);
                                                        boolean zCheckCoverLoadApp = io.dcloud.common.adapter.util.DeviceInfo.checkCoverLoadApp();
                                                        sCoverApkRuning = zCheckCoverLoadApp;
                                                        if (isBase(io.dcloud.application.DCLoudApplicationImpl.self().getContext())) {
                                                            zCheckCoverLoadApp &= ISDEBUG ^ z3;
                                                        }
                                                        z7 = zCheckCoverLoadApp;
                                                        loadInstalledAppInfo(context);
                                                        map = mInstalledAppInfoSet;
                                                    } catch (java.lang.Exception e) {
                                                        e = e;
                                                        z4 = z6;
                                                        z = true;
                                                        e.printStackTrace();
                                                        strArr = strArr2;
                                                        sParsedControl = z;
                                                        if (ISDEBUG) {
                                                            io.dcloud.common.adapter.util.Logger.setOpen(z);
                                                        }
                                                        if (z4) {
                                                            io.dcloud.common.adapter.util.SP.setBundleData(context, PDR, io.dcloud.common.constant.AbsoluteConst.XML_APPS, installAppMapToString());
                                                        }
                                                        io.dcloud.common.adapter.util.Logger.e("channel:" + sChannel + ";ver:1.9.9.82680;max:" + s_Runing_App_Count_Max + ";trim:" + s_Runing_App_Count_Trim + ";dg:" + ISDEBUG);
                                                        if (iCoreStatusListener != null) {
                                                            android.util.Log.i(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "will exc coreListener.onCoreReady");
                                                            iCoreStatusListener.onCoreReady(iCore);
                                                        }
                                                        return strArr;
                                                    }
                                                } catch (java.lang.Exception e2) {
                                                    e = e2;
                                                    strArr3 = strArr2;
                                                    z4 = z6;
                                                    z = true;
                                                    strArr2 = strArr3;
                                                    e.printStackTrace();
                                                    strArr = strArr2;
                                                    sParsedControl = z;
                                                    if (ISDEBUG) {
                                                        io.dcloud.common.adapter.util.Logger.setOpen(z);
                                                    }
                                                    if (z4) {
                                                        io.dcloud.common.adapter.util.SP.setBundleData(context, PDR, io.dcloud.common.constant.AbsoluteConst.XML_APPS, installAppMapToString());
                                                    }
                                                    io.dcloud.common.adapter.util.Logger.e("channel:" + sChannel + ";ver:1.9.9.82680;max:" + s_Runing_App_Count_Max + ";trim:" + s_Runing_App_Count_Trim + ";dg:" + ISDEBUG);
                                                    if (iCoreStatusListener != null) {
                                                        android.util.Log.i(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "will exc coreListener.onCoreReady");
                                                        iCoreStatusListener.onCoreReady(iCore);
                                                    }
                                                    return strArr;
                                                }
                                            }
                                            z = true;
                                            try {
                                                io.dcloud.common.util.BaseInfo.BaseAppInfo baseAppInfo = new io.dcloud.common.util.BaseInfo.BaseAppInfo(attributeValue3, io.dcloud.common.util.XmlUtil.getAttributeValue(dHNode, io.dcloud.common.constant.AbsoluteConst.XML_APPVER));
                                                mBaseAppInfoSet.put(attributeValue3, baseAppInfo);
                                                if (z7 && map.containsKey(attributeValue3)) {
                                                    io.dcloud.common.util.BaseInfo.BaseAppInfo baseAppInfo2 = map.get(attributeValue3);
                                                    if (!sCoverApkRuning && !baseAppInfo.high(baseAppInfo2)) {
                                                        baseAppInfo.mMoreRecent = false;
                                                        mBaseAppInfoSet.remove(attributeValue3);
                                                    } else {
                                                        android.util.Log.i(io.dcloud.common.adapter.util.Logger.MAIN_TAG, attributeValue3 + " App has new version! it is " + baseAppInfo.mAppVer);
                                                        try {
                                                            baseAppInfo.clearBundleData();
                                                            map.remove(attributeValue3);
                                                            z6 = true;
                                                        } catch (java.lang.Exception e3) {
                                                            e = e3;
                                                            strArr3 = strArr2;
                                                            z4 = true;
                                                            strArr2 = strArr3;
                                                            e.printStackTrace();
                                                            strArr = strArr2;
                                                            sParsedControl = z;
                                                            if (ISDEBUG) {
                                                                io.dcloud.common.adapter.util.Logger.setOpen(z);
                                                            }
                                                            if (z4) {
                                                                io.dcloud.common.adapter.util.SP.setBundleData(context, PDR, io.dcloud.common.constant.AbsoluteConst.XML_APPS, installAppMapToString());
                                                            }
                                                            io.dcloud.common.adapter.util.Logger.e("channel:" + sChannel + ";ver:1.9.9.82680;max:" + s_Runing_App_Count_Max + ";trim:" + s_Runing_App_Count_Trim + ";dg:" + ISDEBUG);
                                                            if (iCoreStatusListener != null) {
                                                                android.util.Log.i(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "will exc coreListener.onCoreReady");
                                                                iCoreStatusListener.onCoreReady(iCore);
                                                            }
                                                            return strArr;
                                                        }
                                                    }
                                                }
                                                i3++;
                                                z3 = true;
                                                str = null;
                                            } catch (java.lang.Exception e4) {
                                                e = e4;
                                                strArr3 = strArr2;
                                                z4 = z6;
                                                strArr2 = strArr3;
                                                e.printStackTrace();
                                                strArr = strArr2;
                                                sParsedControl = z;
                                                if (ISDEBUG) {
                                                    io.dcloud.common.adapter.util.Logger.setOpen(z);
                                                }
                                                if (z4) {
                                                    io.dcloud.common.adapter.util.SP.setBundleData(context, PDR, io.dcloud.common.constant.AbsoluteConst.XML_APPS, installAppMapToString());
                                                }
                                                io.dcloud.common.adapter.util.Logger.e("channel:" + sChannel + ";ver:1.9.9.82680;max:" + s_Runing_App_Count_Max + ";trim:" + s_Runing_App_Count_Trim + ";dg:" + ISDEBUG);
                                                if (iCoreStatusListener != null) {
                                                    android.util.Log.i(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "will exc coreListener.onCoreReady");
                                                    iCoreStatusListener.onCoreReady(iCore);
                                                }
                                                return strArr;
                                            }
                                        } catch (java.lang.Exception e5) {
                                            e = e5;
                                            z = true;
                                        }
                                    }
                                    z = true;
                                    strArr = strArr2;
                                    z4 = z6;
                                }
                            } catch (java.lang.Exception e6) {
                                e = e6;
                                z = true;
                                strArr2 = strArr3;
                                e.printStackTrace();
                                strArr = strArr2;
                                sParsedControl = z;
                                if (ISDEBUG) {
                                    io.dcloud.common.adapter.util.Logger.setOpen(z);
                                }
                                if (z4) {
                                    io.dcloud.common.adapter.util.SP.setBundleData(context, PDR, io.dcloud.common.constant.AbsoluteConst.XML_APPS, installAppMapToString());
                                }
                                io.dcloud.common.adapter.util.Logger.e("channel:" + sChannel + ";ver:1.9.9.82680;max:" + s_Runing_App_Count_Max + ";trim:" + s_Runing_App_Count_Trim + ";dg:" + ISDEBUG);
                                if (iCoreStatusListener != null) {
                                    android.util.Log.i(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "will exc coreListener.onCoreReady");
                                    iCoreStatusListener.onCoreReady(iCore);
                                }
                                return strArr;
                            }
                            sParsedControl = z;
                            if (ISDEBUG) {
                                io.dcloud.common.adapter.util.Logger.setOpen(z);
                            }
                            if (z4) {
                                io.dcloud.common.adapter.util.SP.setBundleData(context, PDR, io.dcloud.common.constant.AbsoluteConst.XML_APPS, installAppMapToString());
                            }
                        } else {
                            z2 = true;
                            ISDEBUG = z2;
                            AuxiliaryInput = java.lang.Boolean.parseBoolean(io.dcloud.common.util.XmlUtil.getAttributeValue(dHNodeXML_Parser, io.dcloud.common.constant.AbsoluteConst.XML_AUXILIARYINPUT, io.dcloud.common.constant.AbsoluteConst.FALSE));
                            ISAMU = java.lang.Boolean.parseBoolean(io.dcloud.common.util.XmlUtil.getAttributeValue(dHNodeXML_Parser, io.dcloud.common.constant.AbsoluteConst.XML_AMU, io.dcloud.common.constant.AbsoluteConst.FALSE));
                            sGlobalAuthority = io.dcloud.common.util.XmlUtil.getAttributeValue(dHNodeXML_Parser, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTHORITY, (java.lang.String) null);
                            metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_STREAMAPP_CHANNEL");
                            if (!io.dcloud.common.util.PdrUtil.isEmpty(metaValue)) {
                                if (metaValue.startsWith("_")) {
                                    sChannel = metaValue.substring(1);
                                } else {
                                    sChannel = metaValue;
                                }
                            } else {
                                attributeValue = io.dcloud.common.util.XmlUtil.getAttributeValue(dHNodeXML_Parser, io.dcloud.common.constant.AbsoluteConst.XML_CHANNEL, (java.lang.String) null);
                                if (!io.dcloud.common.util.PdrUtil.isEmpty(attributeValue)) {
                                    sChannel = attributeValue;
                                } else {
                                    sChannel = "";
                                }
                            }
                            sSplashExitCondition = io.dcloud.common.util.XmlUtil.getAttributeValue(dHNodeXML_Parser, "back", sSplashExitCondition);
                            s_Is_DCloud_Packaged = java.lang.Boolean.parseBoolean(io.dcloud.common.util.XmlUtil.getAttributeValue(dHNodeXML_Parser, io.dcloud.common.constant.AbsoluteConst.XML_NS, io.dcloud.common.constant.AbsoluteConst.FALSE));
                            attributeValue2 = io.dcloud.common.util.XmlUtil.getAttributeValue(dHNodeXML_Parser, io.dcloud.common.constant.AbsoluteConst.XML_FONT_SCALE, sFontScale);
                            if (!android.text.TextUtils.isEmpty(attributeValue2)) {
                                sFontScale = attributeValue2;
                                if (!"none".equals(attributeValue2)) {
                                    sFontScaleFloat = java.lang.Float.valueOf(sFontScale).floatValue();
                                }
                            }
                            sSupportAddByHand &= ISDEBUG;
                            io.dcloud.common.util.XmlUtil.DHNode element2 = io.dcloud.common.util.XmlUtil.getElement(dHNodeXML_Parser, io.dcloud.common.constant.AbsoluteConst.XML_APPS);
                            i = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.XmlUtil.getAttributeValue(element2, "max"), s_Runing_App_Count_Max);
                            s_Runing_App_Count_Max = i;
                            if (i <= 0) {
                                s_Runing_App_Count_Max = Integer.MAX_VALUE;
                            }
                            i2 = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.XmlUtil.getAttributeValue(element2, io.dcloud.common.constant.AbsoluteConst.XML_TRIM), s_Runing_App_Count_Trim);
                            s_Runing_App_Count_Trim = i2;
                            if (i2 <= 0) {
                                s_Runing_App_Count_Trim = 0;
                            }
                            elements = io.dcloud.common.util.XmlUtil.getElements(element2, io.dcloud.common.constant.AbsoluteConst.XML_APP);
                            if (elements == null) {
                            }
                        }
                    }
                    z = true;
                } else {
                    z = true;
                    try {
                        io.dcloud.common.adapter.util.DeviceInfo.initBaseFsRootPath();
                    } catch (java.lang.Exception e7) {
                        e = e7;
                        strArr3 = null;
                        strArr2 = strArr3;
                        e.printStackTrace();
                        strArr = strArr2;
                    }
                }
                strArr = null;
            } catch (java.lang.Exception e8) {
                e = e8;
                z = true;
            }
            sParsedControl = z;
            if (ISDEBUG) {
                io.dcloud.common.adapter.util.Logger.setOpen(z);
            }
            if (z4) {
                io.dcloud.common.adapter.util.SP.setBundleData(context, PDR, io.dcloud.common.constant.AbsoluteConst.XML_APPS, installAppMapToString());
            }
        }
        io.dcloud.common.adapter.util.Logger.e("channel:" + sChannel + ";ver:1.9.9.82680;max:" + s_Runing_App_Count_Max + ";trim:" + s_Runing_App_Count_Trim + ";dg:" + ISDEBUG);
        if (iCoreStatusListener != null && iCore != null) {
            android.util.Log.i(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "will exc coreListener.onCoreReady");
            iCoreStatusListener.onCoreReady(iCore);
        }
        return strArr;
    }
}
