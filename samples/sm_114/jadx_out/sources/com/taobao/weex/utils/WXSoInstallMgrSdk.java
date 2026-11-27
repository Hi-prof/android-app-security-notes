package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class WXSoInstallMgrSdk {
    private static final java.lang.String ARMEABI = "armeabi";
    static final java.lang.String LOGTAG = "INIT_SO";
    private static final java.lang.String MIPS = "mips";
    private static final java.lang.String STARTUPSO = "/libweexjsb.so";
    private static final java.lang.String STARTUPSOANDROID15 = "/libweexjst.so";
    private static final java.lang.String X86 = "x86";
    private static java.lang.String mAbi;
    static android.app.Application mContext;
    private static com.taobao.weex.adapter.IWXSoLoaderAdapter mSoLoader;
    private static com.taobao.weex.IWXStatisticsListener mStatisticsListener;

    public static void init(android.app.Application application, com.taobao.weex.adapter.IWXSoLoaderAdapter iWXSoLoaderAdapter, com.taobao.weex.IWXStatisticsListener iWXStatisticsListener) {
        mContext = application;
        mSoLoader = iWXSoLoaderAdapter;
        mStatisticsListener = iWXStatisticsListener;
    }

    public static boolean isX86() {
        return _cpuType().equalsIgnoreCase("x86");
    }

    public static boolean isCPUSupport() {
        return !_cpuType().equalsIgnoreCase("mips");
    }

    public static boolean initSo(java.lang.String str, int i, com.taobao.weex.adapter.IWXUserTrackAdapter iWXUserTrackAdapter) {
        java.lang.String str_cpuType = _cpuType();
        if (str_cpuType.equalsIgnoreCase("mips")) {
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(null, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_SDK_INIT, "initSo", "[WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT] for android cpuType is MIPS", null);
            return false;
        }
        if (com.taobao.weex.WXEnvironment.CORE_SO_NAME.equals(str)) {
            copyStartUpSo();
        }
        try {
            com.taobao.weex.adapter.IWXSoLoaderAdapter iWXSoLoaderAdapter = mSoLoader;
            if (iWXSoLoaderAdapter != null) {
                iWXSoLoaderAdapter.doLoadLibrary(str);
                return true;
            }
            java.lang.System.loadLibrary(str);
            return true;
        } catch (java.lang.Error | java.lang.Exception e) {
            if (str_cpuType.contains(ARMEABI) || str_cpuType.contains("x86")) {
                com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(null, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_SDK_INIT, "initSo", str + "[WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT] for android cpuType is " + str_cpuType + "\n Detail Error is: " + e.getMessage(), null);
            }
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                throw e;
            }
            return false;
        }
    }

    private static java.io.File _desSoCopyFile(java.lang.String str) {
        java.lang.String str_cpuType = _cpuType();
        java.lang.String strCopySoDesDir = com.taobao.weex.WXEnvironment.copySoDesDir();
        if (android.text.TextUtils.isEmpty(strCopySoDesDir)) {
            return null;
        }
        return new java.io.File(strCopySoDesDir, str + "/" + str_cpuType);
    }

    public static void copyStartUpSo() {
        try {
            java.lang.String packageName = com.taobao.weex.WXEnvironment.getApplication().getPackageName();
            java.lang.String path = com.taobao.weex.WXEnvironment.getApplication().getApplicationContext().getCacheDir().getPath();
            java.io.File file_desSoCopyFile = _desSoCopyFile(com.taobao.weex.WXEnvironment.CORE_JSB_SO_NAME);
            if (!file_desSoCopyFile.exists()) {
                file_desSoCopyFile.mkdirs();
            }
            java.io.File file = new java.io.File(file_desSoCopyFile, STARTUPSO);
            com.taobao.weex.WXEnvironment.CORE_JSB_SO_PATH = file.getAbsolutePath();
            java.lang.String defaultSettingValue = com.taobao.weex.WXEnvironment.getDefaultSettingValue(com.taobao.weex.WXEnvironment.CORE_JSB_SO_NAME, "-1");
            if (file.exists() && android.text.TextUtils.equals(com.taobao.weex.WXEnvironment.getAppVersionName(), defaultSettingValue)) {
                return;
            }
            java.lang.String strReplace = "/data/data/" + packageName + "/lib";
            if (path != null && path.indexOf("/cache") > 0) {
                strReplace = path.replace("/cache", "/lib");
            }
            java.io.File file2 = new java.io.File(strReplace, STARTUPSO);
            if (!file2.exists()) {
                try {
                    file2 = new java.io.File(((dalvik.system.PathClassLoader) com.taobao.weex.utils.WXSoInstallMgrSdk.class.getClassLoader()).findLibrary(com.taobao.weex.WXEnvironment.CORE_JSB_SO_NAME));
                } catch (java.lang.Throwable unused) {
                }
            }
            if (!file2.exists()) {
                com.taobao.weex.WXEnvironment.extractSo();
                file2 = new java.io.File(com.taobao.weex.WXEnvironment.copySoDesDir(), STARTUPSO);
            }
            if (file2.exists()) {
                com.taobao.weex.utils.WXFileUtils.copyFile(file2, file);
            }
            com.taobao.weex.WXEnvironment.writeDefaultSettingsValue(com.taobao.weex.WXEnvironment.CORE_JSB_SO_NAME, com.taobao.weex.WXEnvironment.getAppVersionName());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void copyJssRuntimeSo() {
        boolean zCheckGreyConfig = com.taobao.weex.utils.WXUtils.checkGreyConfig("wxapm", "use_runtime_api", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        com.taobao.weex.utils.WXLogUtils.e("weex", "tryUseRunTimeApi ? " + zCheckGreyConfig);
        if (zCheckGreyConfig) {
            try {
                com.taobao.weex.utils.WXLogUtils.e("weex", "copyJssRuntimeSo: ");
                java.io.File file_desSoCopyFile = _desSoCopyFile(com.taobao.weex.WXEnvironment.CORE_JSS_SO_NAME);
                if (!file_desSoCopyFile.exists()) {
                    file_desSoCopyFile.mkdirs();
                }
                java.io.File file = new java.io.File(file_desSoCopyFile, "libweexjss.so");
                java.lang.String defaultSettingValue = com.taobao.weex.WXEnvironment.getDefaultSettingValue("app_version_code_weex", "-1");
                if (file.exists()) {
                    if (!android.text.TextUtils.equals(com.taobao.weex.WXEnvironment.getAppVersionName(), defaultSettingValue)) {
                        file.delete();
                    } else {
                        com.taobao.weex.WXEnvironment.CORE_JSS_RUNTIME_SO_PATH = file.getAbsolutePath();
                        com.taobao.weex.WXEnvironment.sUseRunTimeApi = true;
                        com.taobao.weex.utils.WXLogUtils.e("weex", "copyJssRuntimeSo exist:  return");
                        return;
                    }
                }
                java.lang.String strFindLibrary = ((dalvik.system.PathClassLoader) com.taobao.weex.utils.WXSoInstallMgrSdk.class.getClassLoader()).findLibrary("weexjssr");
                if (android.text.TextUtils.isEmpty(strFindLibrary)) {
                    return;
                }
                file.createNewFile();
                com.taobao.weex.utils.WXFileUtils.copyFileWithException(new java.io.File(strFindLibrary), file);
                com.taobao.weex.WXEnvironment.CORE_JSS_RUNTIME_SO_PATH = file.getAbsolutePath();
                com.taobao.weex.WXEnvironment.writeDefaultSettingsValue("app_version_code_weex", com.taobao.weex.WXEnvironment.getAppVersionName());
                com.taobao.weex.WXEnvironment.sUseRunTimeApi = true;
                com.taobao.weex.utils.WXLogUtils.e("weex", "copyJssRuntimeSo: cp end and return ");
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                com.taobao.weex.WXEnvironment.sUseRunTimeApi = false;
                com.taobao.weex.utils.WXLogUtils.e("weex", "copyJssRuntimeSo:  exception" + th);
            }
        }
    }

    private static java.lang.String _getFieldReflectively(android.os.Build build, java.lang.String str) {
        try {
            return android.os.Build.class.getField(str).get(build).toString();
        } catch (java.lang.Exception unused) {
            return "Unknown";
        }
    }

    private static java.lang.String _cpuType() {
        if (android.text.TextUtils.isEmpty(mAbi)) {
            try {
                mAbi = android.os.Build.CPU_ABI;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                mAbi = ARMEABI;
            }
            if (android.text.TextUtils.isEmpty(mAbi)) {
                mAbi = ARMEABI;
            }
            mAbi = mAbi.toLowerCase(java.util.Locale.ROOT);
        }
        return mAbi;
    }

    static boolean checkSoIsValid(java.lang.String str, long j) {
        if (mContext == null) {
            return false;
        }
        try {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (com.taobao.weex.utils.WXSoInstallMgrSdk.class.getClassLoader() instanceof dalvik.system.PathClassLoader) {
                java.lang.String strFindLibrary = ((dalvik.system.PathClassLoader) com.taobao.weex.utils.WXSoInstallMgrSdk.class.getClassLoader()).findLibrary(str);
                if (android.text.TextUtils.isEmpty(strFindLibrary)) {
                    return false;
                }
                java.io.File file = new java.io.File(strFindLibrary);
                if (file.exists() && j != file.length()) {
                    return false;
                }
                com.taobao.weex.utils.WXLogUtils.w("weex so size check path :" + strFindLibrary + "   " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
                return true;
            }
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(null, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_SDK_INIT, "checkSoIsValid", "[WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT] for weex so size check fail exception :" + th.getMessage(), null);
            com.taobao.weex.utils.WXLogUtils.e("weex so size check fail exception :" + th.getMessage());
        }
        return true;
    }

    static java.lang.String _targetSoFile(java.lang.String str, int i) {
        android.app.Application application = mContext;
        if (application == null) {
            return "";
        }
        java.lang.String path = "/data/data/" + application.getPackageName() + "/files";
        java.io.File filesDir = application.getFilesDir();
        if (filesDir != null) {
            path = filesDir.getPath();
        }
        return path + "/lib" + str + "bk" + i + ".so";
    }

    static void removeSoIfExit(java.lang.String str, int i) {
        java.io.File file = new java.io.File(_targetSoFile(str, i));
        if (file.exists()) {
            file.delete();
        }
    }

    static boolean isExist(java.lang.String str, int i) {
        return new java.io.File(_targetSoFile(str, i)).exists();
    }

    static boolean _loadUnzipSo(java.lang.String str, int i, com.taobao.weex.adapter.IWXUserTrackAdapter iWXUserTrackAdapter) {
        try {
            if (!isExist(str, i)) {
                return true;
            }
            com.taobao.weex.adapter.IWXSoLoaderAdapter iWXSoLoaderAdapter = mSoLoader;
            if (iWXSoLoaderAdapter != null) {
                iWXSoLoaderAdapter.doLoad(_targetSoFile(str, i));
                return true;
            }
            java.lang.System.load(_targetSoFile(str, i));
            return true;
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(null, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT, "_loadUnzipSo", "[WX_KEY_EXCEPTION_SDK_INIT_WX_ERR_COPY_FROM_APK] \n Detail Msg is : " + th.getMessage(), null);
            com.taobao.weex.utils.WXLogUtils.e("", th);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static boolean unZipSelectedFiles(java.lang.String str, int i, com.taobao.weex.adapter.IWXUserTrackAdapter iWXUserTrackAdapter) throws java.lang.Throwable {
        android.app.Application application;
        java.lang.String str2;
        java.io.InputStream inputStream;
        java.io.FileOutputStream fileOutputStreamOpenFileOutput;
        java.nio.channels.FileChannel channel;
        java.lang.String str3 = "lib/armeabi/lib" + str + ".so";
        if (!io.dcloud.common.util.PdrUtil.isSafeEntryName(str3) || (application = mContext) == null) {
            return false;
        }
        android.content.pm.ApplicationInfo applicationInfo = application.getApplicationInfo();
        if (applicationInfo == null) {
            str2 = "";
        } else {
            str2 = applicationInfo.sourceDir;
        }
        java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(str2);
        try {
            try {
                java.util.Enumeration<? extends java.util.zip.ZipEntry> enumerationEntries = zipFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    java.util.zip.ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    try {
                        if (zipEntryNextElement.getName().startsWith(str3)) {
                            try {
                                removeSoIfExit(str, i);
                                inputStream = zipFile.getInputStream(zipEntryNextElement);
                                try {
                                    fileOutputStreamOpenFileOutput = application.openFileOutput("lib" + str + "bk" + i + ".so", 0);
                                    try {
                                        channel = fileOutputStreamOpenFileOutput.getChannel();
                                        try {
                                            byte[] bArr = new byte[1024];
                                            int i2 = 0;
                                            while (true) {
                                                int i3 = inputStream.read(bArr);
                                                if (i3 <= 0) {
                                                    break;
                                                }
                                                channel.write(java.nio.ByteBuffer.wrap(bArr, 0, i3));
                                                i2 += i3;
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (java.lang.Exception e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                            if (channel != null) {
                                                try {
                                                    channel.close();
                                                } catch (java.lang.Exception e2) {
                                                    e2.printStackTrace();
                                                }
                                            }
                                            if (fileOutputStreamOpenFileOutput != null) {
                                                try {
                                                    fileOutputStreamOpenFileOutput.close();
                                                } catch (java.lang.Exception e3) {
                                                    e3.printStackTrace();
                                                }
                                            }
                                            zipFile.close();
                                            if (i2 > 0) {
                                                return _loadUnzipSo(str, i, iWXUserTrackAdapter);
                                            }
                                            return false;
                                        } catch (java.lang.Throwable th) {
                                            th = th;
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (java.lang.Exception e4) {
                                                    e4.printStackTrace();
                                                }
                                            }
                                            if (channel != null) {
                                                try {
                                                    channel.close();
                                                } catch (java.lang.Exception e5) {
                                                    e5.printStackTrace();
                                                }
                                            }
                                            if (fileOutputStreamOpenFileOutput != null) {
                                                try {
                                                    fileOutputStreamOpenFileOutput.close();
                                                } catch (java.lang.Exception e6) {
                                                    e6.printStackTrace();
                                                }
                                            }
                                            zipFile.close();
                                            throw th;
                                        }
                                    } catch (java.lang.Throwable th2) {
                                        th = th2;
                                        channel = null;
                                    }
                                } catch (java.lang.Throwable th3) {
                                    th = th3;
                                    fileOutputStreamOpenFileOutput = null;
                                    channel = fileOutputStreamOpenFileOutput;
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (channel != null) {
                                        channel.close();
                                    }
                                    if (fileOutputStreamOpenFileOutput != null) {
                                        fileOutputStreamOpenFileOutput.close();
                                    }
                                    zipFile.close();
                                    throw th;
                                }
                            } catch (java.lang.Throwable th4) {
                                th = th4;
                                inputStream = null;
                                fileOutputStreamOpenFileOutput = null;
                            }
                        }
                    } catch (java.io.IOException e7) {
                        e = e7;
                        zipFile = null;
                        e.printStackTrace();
                        com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(null, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_SDK_INIT_CPU_NOT_SUPPORT, "unZipSelectedFiles", "[WX_KEY_EXCEPTION_SDK_INIT_unZipSelectedFiles] \n Detail msg is: " + e.getMessage(), null);
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        return false;
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        zipFile = null;
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
            }
        } catch (java.io.IOException e8) {
            e = e8;
        }
        zipFile.close();
        return false;
    }
}
