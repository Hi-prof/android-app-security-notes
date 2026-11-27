package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class UEH {
    private static final java.lang.String CRASH_DIRECTORY = "crash/";
    private static final boolean SAVE_CRASH_LOG = true;
    private static java.text.DateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", java.util.Locale.CHINESE);
    public static boolean sInited = false;

    public static void catchUncaughtException(final android.content.Context context) {
        if (sInited) {
            return;
        }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(new java.lang.Thread.UncaughtExceptionHandler() { // from class: io.dcloud.common.adapter.util.UEH.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
                io.dcloud.common.adapter.util.UEH.handleUncaughtException(context, th);
                try {
                    if (io.dcloud.common.util.BaseInfo.getCmitInfo(io.dcloud.common.util.BaseInfo.sLastRunApp).rptCrs) {
                        io.dcloud.common.adapter.util.UEH.commitUncatchException(context, th);
                    }
                    java.lang.Thread.sleep(3000L);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    io.dcloud.common.adapter.util.Logger.e("UncaughtExceptionHandler", "commitUncatchException");
                }
                th.printStackTrace();
                io.dcloud.common.adapter.util.Logger.e("UncaughtExceptionHandler", th.toString());
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        sInited = true;
    }

    private static void commitBaseUncatchInfo(android.content.Context context, java.lang.StringBuffer stringBuffer) {
        java.lang.String strEncode;
        try {
            strEncode = java.net.URLEncoder.encode(android.os.Build.MODEL, "utf-8");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            strEncode = null;
        }
        int i = android.os.Build.VERSION.SDK_INT;
        stringBuffer.append("s=99");
        stringBuffer.append("&p=a");
        if (!io.dcloud.common.util.AppRuntime.hasPrivacyForNotShown(context)) {
            stringBuffer.append("&net=" + io.dcloud.common.util.NetworkTypeUtil.getNetworkType(context));
            stringBuffer.append("&dcid=" + io.dcloud.common.util.AppRuntime.getDCloudDeviceID(context));
            stringBuffer.append("&carrierid=" + io.dcloud.common.util.TelephonyUtil.getSimOperator(context));
            java.lang.String defWebViewUA = io.dcloud.common.util.BaseInfo.sDefWebViewUserAgent;
            if (io.dcloud.common.util.PdrUtil.isEmpty(defWebViewUA) && java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread()) {
                defWebViewUA = io.dcloud.common.adapter.ui.webview.WebViewFactory.getDefWebViewUA(context);
            }
            if (!io.dcloud.common.util.PdrUtil.isEmpty(defWebViewUA)) {
                stringBuffer.append("&ua=" + defWebViewUA);
            }
        }
        java.lang.String str = io.dcloud.common.util.BaseInfo.sLastRunApp;
        if (str == null) {
            str = io.dcloud.common.util.BaseInfo.sDefaultBootApp;
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(str) && !io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            io.dcloud.common.util.BaseInfo.parseControl();
            str = io.dcloud.common.util.BaseInfo.sDefaultBootApp;
        }
        io.dcloud.p.e3.a aVarA = io.dcloud.p.e3.a(context);
        int iRound = java.lang.Math.round((java.lang.System.currentTimeMillis() - io.dcloud.common.util.BaseInfo.startTime) / 1000.0f);
        stringBuffer.append("&pv=" + io.dcloud.common.adapter.util.AndroidResources.versionName);
        stringBuffer.append("&root=" + (io.dcloud.common.adapter.util.DeviceInfo.hasRootPrivilege() ? 1 : 0));
        stringBuffer.append("&t=" + java.lang.System.currentTimeMillis());
        stringBuffer.append("&duration=" + iRound);
        java.lang.StringBuilder sb = new java.lang.StringBuilder("&fore=");
        sb.append(io.dcloud.common.util.AppStatus.getAppStatus(io.dcloud.common.util.BaseInfo.sLastRunApp) == 2 ? 0 : 1);
        stringBuffer.append(sb.toString());
        stringBuffer.append("&osn=".concat(io.dcloud.common.util.HarmonyUtils.isHarmonyOs() ? "HarmonyOS" : com.taobao.weex.utils.tools.TimeCalculator.PLATFORM_ANDROID));
        stringBuffer.append("&batlevel=" + io.dcloud.common.util.AppRuntime.getBatteryLevel());
        stringBuffer.append("&battemp=" + io.dcloud.common.util.AppRuntime.getTemperature());
        stringBuffer.append("&channel=" + io.dcloud.common.util.BaseInfo.getAnalysisChannel());
        stringBuffer.append("&md=" + strEncode);
        stringBuffer.append("&os=" + i);
        stringBuffer.append("&osv=" + android.os.Build.VERSION.RELEASE);
        stringBuffer.append("&appid=" + str);
        stringBuffer.append("&vb=1.9.9.82680");
        stringBuffer.append("&appcount=" + io.dcloud.common.util.BaseInfo.s_Runing_App_Count);
        stringBuffer.append("&wvcount=" + io.dcloud.common.util.BaseInfo.s_Webview_Count);
        stringBuffer.append("&pn=" + context.getPackageName());
        stringBuffer.append("&memuse=" + (aVarA.a - aVarA.b));
        stringBuffer.append("&memtotal=" + aVarA.a);
        stringBuffer.append("&diskuse=" + (aVarA.d - aVarA.c));
        stringBuffer.append("&disktotal=" + aVarA.d);
        stringBuffer.append("&vd=" + io.dcloud.common.util.PdrUtil.encodeURL(android.os.Build.MANUFACTURER));
        stringBuffer.append("&abis=" + getAbis());
        stringBuffer.append("&psdk=0");
        stringBuffer.append("&it=" + (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() ? 1 : 0));
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("&fv=");
        sb2.append(android.text.TextUtils.isEmpty(io.dcloud.common.util.BaseInfo.uniVersionV3) ? io.dcloud.common.adapter.util.SP.getBundleData(context, "pdr", "F_V") : io.dcloud.common.util.BaseInfo.uniVersionV3);
        stringBuffer.append(sb2.toString());
        if (!android.text.TextUtils.isEmpty(io.dcloud.common.util.BaseInfo.sLastAppVersionName)) {
            stringBuffer.append("&v=" + io.dcloud.common.util.BaseInfo.sLastAppVersionName);
        }
        if (android.text.TextUtils.isEmpty(io.dcloud.common.util.AppRuntime.getUniStatistics())) {
            return;
        }
        stringBuffer.append("&us=" + io.dcloud.common.util.AppRuntime.getUniStatistics());
    }

    private static void commitErrorLog(final java.lang.String str) {
        io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.util.UEH.3
            @Override // java.lang.Runnable
            public void run() {
                java.util.HashMap map = new java.util.HashMap();
                map.put(io.dcloud.common.util.net.NetWork.CONTENT_TYPE, "application/x-www-form-urlencoded");
                io.dcloud.common.util.NetTool.httpPost(io.dcloud.p.e1.b(io.dcloud.common.util.Base64.decode2String("YHx8eHsyJydreiZsa2RnfWwmZm18JmtmJw==")) + "collect/crash", str, map);
            }
        });
    }

    public static void commitUncatchException(android.content.Context context, java.lang.String str, java.lang.String str2, int i) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        commitBaseUncatchInfo(context, stringBuffer);
        stringBuffer.append("&etype=" + i);
        stringBuffer.append("&log=" + io.dcloud.common.util.PdrUtil.encodeURL(str2));
        stringBuffer.append("&eurl=" + io.dcloud.common.util.PdrUtil.encodeURL(str));
        commitErrorLog(stringBuffer.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.io.File handleUncaughtException(android.content.Context context, java.lang.Throwable th) {
        java.io.File file = null;
        try {
            java.lang.reflect.Field[] declaredFields = android.os.Build.class.getDeclaredFields();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            for (java.lang.reflect.Field field : declaredFields) {
                try {
                    field.setAccessible(true);
                    stringBuffer.append(field.getName() + ":" + field.get(null) + "\n");
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            th.printStackTrace(new java.io.PrintWriter(stringWriter));
            java.lang.String string = stringWriter.toString();
            java.io.File file2 = "mounted".equalsIgnoreCase(android.os.Environment.getExternalStorageState()) ? new java.io.File(io.dcloud.common.util.BaseInfo.getCrashLogsPath(context) + CRASH_DIRECTORY) : new java.io.File(context.getCacheDir().getAbsolutePath() + CRASH_DIRECTORY);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            java.io.File file3 = new java.io.File(file2.getAbsolutePath(), "crash_" + java.lang.System.currentTimeMillis() + "_" + formatter.format(new java.util.Date()) + ".log");
            try {
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file3);
                stringBuffer.append(string);
                fileOutputStream.write(stringBuffer.toString().getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                return file3;
            } catch (java.lang.Exception e2) {
                e = e2;
                file = file3;
                e.printStackTrace();
                return file;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            e.printStackTrace();
            return file;
        }
    }

    public static void uploadNativeUncaughtException(final android.content.Context context) {
        final java.io.File[] fileArrListFiles;
        final java.io.File file = new java.io.File(context.getExternalCacheDir(), "dcCrashDump");
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.util.UEH.2
                @Override // java.lang.Runnable
                public void run() {
                    io.dcloud.common.DHInterface.ICallBack iCallBack = new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.common.adapter.util.UEH.2.1
                        @Override // io.dcloud.common.DHInterface.ICallBack
                        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                            java.io.File file2 = (java.io.File) obj;
                            io.dcloud.common.adapter.util.UEH.commitUncatchException(context, "", io.dcloud.common.util.Base64.encode(io.dcloud.common.adapter.io.DHFile.readAll(file2)), 3);
                            io.dcloud.common.adapter.io.DHFile.delete(file2);
                            return null;
                        }
                    };
                    for (java.io.File file2 : fileArrListFiles) {
                        java.lang.String[] strArrSplit = file2.getName().split("\\.");
                        if (strArrSplit.length >= 2 && strArrSplit[strArrSplit.length - 1].equals("zip")) {
                            iCallBack.onCallBack(0, file2);
                        }
                    }
                    for (java.io.File file3 : fileArrListFiles) {
                        java.lang.String[] strArrSplit2 = file3.getName().split("\\.");
                        if (strArrSplit2.length < 2) {
                            return;
                        }
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        for (int i = 0; i < strArrSplit2.length - 1; i++) {
                            sb.append(strArrSplit2[i]);
                        }
                        java.lang.String str = ((java.lang.Object) sb) + ".zip";
                        java.io.File[] fileArr = {file3};
                        java.io.File file4 = new java.io.File(file + java.io.File.separator + str);
                        try {
                            io.dcloud.common.util.ZipUtils.zipFiles(fileArr, file4);
                            io.dcloud.common.adapter.io.DHFile.delete(file3);
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }
                        iCallBack.onCallBack(0, file4);
                    }
                }
            });
        }
    }

    private static java.lang.String getAbis() {
        java.lang.String[] strArr = android.os.Build.SUPPORTED_ABIS;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);
            if (i < strArr.length - 1) {
                sb.append(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void commitUncatchException(android.content.Context context, java.lang.Throwable th) {
        if (io.dcloud.p.t.c(context)) {
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            th.printStackTrace(new java.io.PrintWriter(stringWriter));
            java.lang.String string = stringWriter.toString();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            commitBaseUncatchInfo(context, stringBuffer);
            stringBuffer.append("&etype=1");
            stringBuffer.append("&log=" + io.dcloud.common.util.PdrUtil.encodeURL(string));
            commitErrorLog(stringBuffer.toString());
        }
    }
}
