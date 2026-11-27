package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public class SoLoader {
    static final boolean DEBUG = false;
    public static final int SOLOADER_ALLOW_ASYNC_INIT = 2;
    public static final int SOLOADER_DISABLE_BACKUP_SOSOURCE = 8;
    public static final int SOLOADER_DISABLE_FS_SYNC_JOB = 256;

    @java.lang.Deprecated
    public static final int SOLOADER_DONT_TREAT_AS_SYSTEMAPP = 32;

    @java.lang.Deprecated
    public static final int SOLOADER_ENABLE_DIRECT_SOSOURCE = 64;
    public static final int SOLOADER_ENABLE_EXOPACKAGE = 1;
    public static final int SOLOADER_ENABLE_SYSTEMLOAD_WRAPPER_SOSOURCE = 512;
    public static final int SOLOADER_EXPLICITLY_ENABLE_BACKUP_SOSOURCE = 128;
    public static final int SOLOADER_LOOK_IN_ZIP = 4;
    public static final int SOLOADER_SKIP_MERGED_JNI_ONLOAD = 16;
    private static final java.lang.String SO_STORE_NAME_MAIN = "lib-main";
    private static final java.lang.String SO_STORE_NAME_SPLIT = "lib-";
    public static final java.lang.String TAG = "SoLoader";
    public static java.lang.String VERSION = "0.10.5";
    private static int sFlags;

    @javax.annotation.Nullable
    static com.facebook.soloader.SoFileLoader sSoFileLoader;
    private static final java.util.concurrent.locks.ReentrantReadWriteLock sSoSourcesLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
    static android.content.Context sApplicationContext = null;

    @javax.annotation.Nullable
    private static volatile com.facebook.soloader.SoSource[] sSoSources = null;
    private static final java.util.concurrent.atomic.AtomicInteger sSoSourcesVersion = new java.util.concurrent.atomic.AtomicInteger(0);

    @javax.annotation.Nullable
    private static com.facebook.soloader.recovery.RecoveryStrategyFactory sRecoveryStrategyFactory = null;
    private static final java.util.HashSet<java.lang.String> sLoadedLibraries = new java.util.HashSet<>();
    private static final java.util.Map<java.lang.String, java.lang.Object> sLoadingLibraries = new java.util.HashMap();
    private static final java.util.Set<java.lang.String> sLoadedAndMergedLibraries = java.util.Collections.newSetFromMap(new java.util.concurrent.ConcurrentHashMap());

    @javax.annotation.Nullable
    private static com.facebook.soloader.SystemLoadLibraryWrapper sSystemLoadLibraryWrapper = null;
    private static boolean isEnabled = true;
    private static int sAppType = 0;
    static final boolean SYSTRACE_LIBRARY_LOADING = true;

    interface AppType {
        public static final int SYSTEM_APP = 2;
        public static final int THIRD_PARTY_APP = 1;
        public static final int UNSET = 0;
        public static final int UPDATED_SYSTEM_APP = 3;
    }

    public static void init(android.content.Context context, int i) throws java.io.IOException {
        init(context, i, null);
    }

    public static void init(android.content.Context context, int i, @javax.annotation.Nullable com.facebook.soloader.SoFileLoader soFileLoader) throws java.io.IOException {
        if (isInitialized()) {
            com.facebook.soloader.LogUtil.w(TAG, "SoLoader already initialized");
            return;
        }
        com.facebook.soloader.LogUtil.w(TAG, "Initializing SoLoader: " + i);
        android.os.StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = android.os.StrictMode.allowThreadDiskWrites();
        try {
            boolean zInitEnableConfig = initEnableConfig(context);
            isEnabled = zInitEnableConfig;
            if (zInitEnableConfig) {
                int appType = getAppType(context);
                sAppType = appType;
                if ((i & 128) == 0 && com.facebook.soloader.SysUtil.isSupportedDirectLoad(context, appType)) {
                    i |= 8;
                }
                initSoLoader(context, soFileLoader);
                initSoSources(context, i);
                com.facebook.soloader.LogUtil.v(TAG, "Init SoLoader delegate");
                com.facebook.soloader.nativeloader.NativeLoader.initIfUninitialized(new com.facebook.soloader.NativeLoaderToSoLoaderDelegate());
            } else {
                initDummySoSource();
                com.facebook.soloader.LogUtil.v(TAG, "Init System Loader delegate");
                com.facebook.soloader.nativeloader.NativeLoader.initIfUninitialized(new com.facebook.soloader.nativeloader.SystemDelegate());
            }
            com.facebook.soloader.LogUtil.w(TAG, "SoLoader initialized: " + i);
        } finally {
            android.os.StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
        }
    }

    public static void init(android.content.Context context, boolean z) {
        try {
            init(context, z ? 1 : 0, null);
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    private static boolean initEnableConfig(android.content.Context context) {
        java.lang.String packageName;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return true;
        }
        android.os.Bundle bundle = null;
        try {
            packageName = context.getPackageName();
            try {
                bundle = context.getPackageManager().getApplicationInfo(packageName, 128).metaData;
            } catch (java.lang.Exception e) {
                e = e;
                com.facebook.soloader.LogUtil.w(TAG, "Unexpected issue with package manager (" + packageName + com.taobao.weex.el.parse.Operators.BRACKET_END_STR, e);
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            packageName = null;
        }
        return bundle == null || bundle.getBoolean("com.facebook.soloader.enabled", true);
    }

    private static void initSoSources(android.content.Context context, int i) throws java.io.IOException {
        java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock;
        if (sSoSources != null) {
            return;
        }
        java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            if (sSoSources == null) {
                sFlags = i;
                java.util.ArrayList arrayList = new java.util.ArrayList();
                if ((i & 512) != 0) {
                    addSystemLoadWrapperSoSource(context, arrayList);
                } else {
                    addSystemLibSoSource(arrayList);
                    if (context != null) {
                        if ((i & 1) != 0) {
                            addApplicationSoSource(arrayList, getApplicationSoSourceFlags());
                            com.facebook.soloader.LogUtil.d(TAG, "Adding exo package source: lib-main");
                            arrayList.add(0, new com.facebook.soloader.ExoSoSource(context, SO_STORE_NAME_MAIN));
                        } else {
                            if (com.facebook.soloader.SysUtil.isSupportedDirectLoad(context, sAppType)) {
                                addDirectApkSoSource(context, arrayList);
                            }
                            addApplicationSoSource(arrayList, getApplicationSoSourceFlags());
                            addBackupSoSource(context, arrayList, 1);
                        }
                    }
                }
                com.facebook.soloader.SoSource[] soSourceArr = (com.facebook.soloader.SoSource[]) arrayList.toArray(new com.facebook.soloader.SoSource[arrayList.size()]);
                int iMakePrepareFlags = makePrepareFlags();
                int length = soSourceArr.length;
                while (true) {
                    int i2 = length - 1;
                    if (length <= 0) {
                        break;
                    }
                    com.facebook.soloader.LogUtil.d(TAG, "Preparing SO source: " + soSourceArr[i2]);
                    boolean z = SYSTRACE_LIBRARY_LOADING;
                    if (z) {
                        com.facebook.soloader.Api18TraceUtils.beginTraceSection(TAG, "_", soSourceArr[i2].getClass().getSimpleName());
                    }
                    soSourceArr[i2].prepare(iMakePrepareFlags);
                    if (z) {
                        com.facebook.soloader.Api18TraceUtils.endSection();
                    }
                    length = i2;
                }
                sSoSources = soSourceArr;
                sSoSourcesVersion.getAndIncrement();
                com.facebook.soloader.LogUtil.d(TAG, "init finish: " + sSoSources.length + " SO sources prepared");
                writeLock = sSoSourcesLock.writeLock();
            } else {
                writeLock = reentrantReadWriteLock.writeLock();
            }
            writeLock.unlock();
        } catch (java.lang.Throwable th) {
            sSoSourcesLock.writeLock().unlock();
            throw th;
        }
    }

    private static void initDummySoSource() {
        if (sSoSources != null) {
            return;
        }
        sSoSourcesLock.writeLock().lock();
        try {
            if (sSoSources == null) {
                sSoSources = new com.facebook.soloader.SoSource[0];
            }
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    private static int getApplicationSoSourceFlags() {
        int i = sAppType;
        if (i == 1) {
            return 0;
        }
        if (i == 2 || i == 3) {
            return 1;
        }
        throw new java.lang.RuntimeException("Unsupported app type, we should not reach here");
    }

    private static void addDirectApkSoSource(android.content.Context context, java.util.ArrayList<com.facebook.soloader.SoSource> arrayList) {
        com.facebook.soloader.DirectApkSoSource directApkSoSource = new com.facebook.soloader.DirectApkSoSource(context);
        com.facebook.soloader.LogUtil.d(TAG, "validating/adding directApk source: " + directApkSoSource.toString());
        if (directApkSoSource.isValid()) {
            arrayList.add(0, directApkSoSource);
        }
    }

    private static void addApplicationSoSource(java.util.ArrayList<com.facebook.soloader.SoSource> arrayList, int i) {
        com.facebook.soloader.ApplicationSoSource applicationSoSource = new com.facebook.soloader.ApplicationSoSource(sApplicationContext, i);
        com.facebook.soloader.LogUtil.d(TAG, "Adding application source: " + applicationSoSource.toString());
        arrayList.add(0, applicationSoSource);
    }

    private static void addBackupSoSource(android.content.Context context, java.util.ArrayList<com.facebook.soloader.SoSource> arrayList, int i) throws java.io.IOException {
        if ((sFlags & 8) != 0) {
            java.io.File soStorePath = com.facebook.soloader.UnpackingSoSource.getSoStorePath(context, SO_STORE_NAME_MAIN);
            try {
                if (soStorePath.exists()) {
                    com.facebook.soloader.SysUtil.dumbDelete(soStorePath);
                    return;
                }
                return;
            } catch (java.lang.Throwable th) {
                com.facebook.soloader.LogUtil.w(TAG, "Failed to delete " + soStorePath.getCanonicalPath(), th);
                return;
            }
        }
        java.io.File file = new java.io.File(context.getApplicationInfo().sourceDir);
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        com.facebook.soloader.BackupSoSource backupSoSource = new com.facebook.soloader.BackupSoSource(context, file, SO_STORE_NAME_MAIN, i);
        arrayList2.add(backupSoSource);
        com.facebook.soloader.LogUtil.d(TAG, "adding backup source from : " + backupSoSource.toString());
        addBackupSoSourceFromSplitApk(context, i, arrayList2);
        arrayList.addAll(0, arrayList2);
    }

    private static void addBackupSoSourceFromSplitApk(android.content.Context context, int i, java.util.ArrayList<com.facebook.soloader.UnpackingSoSource> arrayList) throws java.io.IOException {
        if (context.getApplicationInfo().splitSourceDirs != null) {
            com.facebook.soloader.LogUtil.d(TAG, "adding backup sources from split apks");
            java.lang.String[] strArr = context.getApplicationInfo().splitSourceDirs;
            int length = strArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                java.io.File file = new java.io.File(strArr[i2]);
                java.lang.StringBuilder sb = new java.lang.StringBuilder(SO_STORE_NAME_SPLIT);
                int i4 = i3 + 1;
                sb.append(i3);
                com.facebook.soloader.BackupSoSource backupSoSource = new com.facebook.soloader.BackupSoSource(context, file, sb.toString(), i);
                com.facebook.soloader.LogUtil.d(TAG, "adding backup source: " + backupSoSource.toString());
                if (backupSoSource.hasZippedLibs()) {
                    arrayList.add(backupSoSource);
                }
                i2++;
                i3 = i4;
            }
        }
    }

    private static void addSystemLibSoSource(java.util.ArrayList<com.facebook.soloader.SoSource> arrayList) {
        java.lang.String str = com.facebook.soloader.SysUtil.is64Bit() ? "/system/lib64:/vendor/lib64" : "/system/lib:/vendor/lib";
        java.lang.String str2 = java.lang.System.getenv("LD_LIBRARY_PATH");
        if (str2 != null && !str2.equals("")) {
            str = str2 + ":" + str;
        }
        for (java.lang.String str3 : new java.util.HashSet(java.util.Arrays.asList(str.split(":")))) {
            com.facebook.soloader.LogUtil.d(TAG, "adding system library source: " + str3);
            arrayList.add(new com.facebook.soloader.DirectorySoSource(new java.io.File(str3), 2));
        }
    }

    private static void addSystemLoadWrapperSoSource(android.content.Context context, java.util.ArrayList<com.facebook.soloader.SoSource> arrayList) {
        com.facebook.soloader.SystemLoadWrapperSoSource systemLoadWrapperSoSource = new com.facebook.soloader.SystemLoadWrapperSoSource();
        com.facebook.soloader.LogUtil.d(TAG, "adding systemLoadWrapper source: " + systemLoadWrapperSoSource);
        arrayList.add(0, systemLoadWrapperSoSource);
    }

    private static int makePrepareFlags() {
        sSoSourcesLock.writeLock().lock();
        try {
            int i = sFlags;
            int i2 = (i & 2) != 0 ? 1 : 0;
            if ((i & 256) != 0) {
                i2 |= 4;
            }
            return i2;
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    private static synchronized void initSoLoader(@javax.annotation.Nullable android.content.Context context, @javax.annotation.Nullable com.facebook.soloader.SoFileLoader soFileLoader) {
        if (context != null) {
            try {
                android.content.Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    com.facebook.soloader.LogUtil.w(TAG, "context.getApplicationContext returned null, holding reference to original context.ApplicationSoSource fallbacks to: " + context.getApplicationInfo().nativeLibraryDir);
                } else {
                    context = applicationContext;
                }
                sApplicationContext = context;
                sRecoveryStrategyFactory = new com.facebook.soloader.recovery.DefaultRecoveryStrategyFactory(context);
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        if (soFileLoader != null || sSoFileLoader == null) {
            if (soFileLoader != null) {
                sSoFileLoader = soFileLoader;
            } else {
                sSoFileLoader = new com.facebook.soloader.SoFileLoaderImpl();
            }
        }
    }

    private static int getAppType(android.content.Context context) {
        int i = sAppType;
        if (i != 0) {
            return i;
        }
        int i2 = 1;
        if (context == null) {
            com.facebook.soloader.LogUtil.d(TAG, "context is null, fallback to THIRD_PARTY_APP appType");
            return 1;
        }
        android.content.pm.ApplicationInfo applicationInfo = context.getApplicationInfo();
        if ((applicationInfo.flags & 1) != 0) {
            i2 = (applicationInfo.flags & 128) != 0 ? 3 : 2;
        }
        com.facebook.soloader.LogUtil.d(TAG, "ApplicationInfo.flags is: " + applicationInfo.flags + " appType is: " + i2);
        return i2;
    }

    public static void setInTestMode() {
        com.facebook.soloader.SoLoader.TestOnlyUtils.setSoSources(new com.facebook.soloader.SoSource[]{new com.facebook.soloader.NoopSoSource()});
    }

    public static void deinitForTest() {
        com.facebook.soloader.SoLoader.TestOnlyUtils.setSoSources(null);
    }

    static class TestOnlyUtils {
        TestOnlyUtils() {
        }

        static void setSoSources(com.facebook.soloader.SoSource[] soSourceArr) {
            com.facebook.soloader.SoLoader.sSoSourcesLock.writeLock().lock();
            try {
                com.facebook.soloader.SoSource[] unused = com.facebook.soloader.SoLoader.sSoSources = soSourceArr;
                com.facebook.soloader.SoLoader.sSoSourcesVersion.getAndIncrement();
            } finally {
                com.facebook.soloader.SoLoader.sSoSourcesLock.writeLock().unlock();
            }
        }

        static void setSoFileLoader(com.facebook.soloader.SoFileLoader soFileLoader) {
            com.facebook.soloader.SoLoader.sSoFileLoader = soFileLoader;
        }

        static void resetStatus() {
            synchronized (com.facebook.soloader.SoLoader.class) {
                com.facebook.soloader.SoLoader.sLoadedLibraries.clear();
                com.facebook.soloader.SoLoader.sLoadingLibraries.clear();
                com.facebook.soloader.SoLoader.sSoFileLoader = null;
                com.facebook.soloader.SoLoader.sApplicationContext = null;
                com.facebook.soloader.recovery.RecoveryStrategyFactory unused = com.facebook.soloader.SoLoader.sRecoveryStrategyFactory = null;
            }
            setSoSources(null);
        }

        static void setContext(android.content.Context context) {
            com.facebook.soloader.SoLoader.sApplicationContext = context;
        }
    }

    public static void setSystemLoadLibraryWrapper(com.facebook.soloader.SystemLoadLibraryWrapper systemLoadLibraryWrapper) {
        sSystemLoadLibraryWrapper = systemLoadLibraryWrapper;
    }

    public static final class WrongAbiError extends java.lang.UnsatisfiedLinkError {
        WrongAbiError(java.lang.Throwable th, java.lang.String str) {
            super("APK was built for a different platform. Supported ABIs: " + java.util.Arrays.toString(com.facebook.soloader.SysUtil.getSupportedAbis()) + " error: " + str);
            initCause(th);
        }
    }

    @javax.annotation.Nullable
    public static java.lang.String getLibraryPath(java.lang.String str) throws java.io.IOException {
        sSoSourcesLock.readLock().lock();
        try {
            java.lang.String libraryPath = null;
            if (sSoSources != null) {
                for (int i = 0; libraryPath == null && i < sSoSources.length; i++) {
                    libraryPath = sSoSources[i].getLibraryPath(str);
                }
            }
            return libraryPath;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static com.facebook.soloader.SoSource[] cloneSoSources() {
        sSoSourcesLock.readLock().lock();
        try {
            return sSoSources == null ? new com.facebook.soloader.SoSource[0] : (com.facebook.soloader.SoSource[]) sSoSources.clone();
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    @javax.annotation.Nullable
    public static java.lang.String[] getLibraryDependencies(java.lang.String str) throws java.io.IOException {
        sSoSourcesLock.readLock().lock();
        try {
            java.lang.String[] libraryDependencies = null;
            if (sSoSources != null) {
                for (int i = 0; libraryDependencies == null && i < sSoSources.length; i++) {
                    libraryDependencies = sSoSources[i].getLibraryDependencies(str);
                }
            }
            return libraryDependencies;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    @javax.annotation.Nullable
    public static java.io.File getSoFile(java.lang.String str) {
        java.lang.String strMapLibName = com.facebook.soloader.MergedSoMapping.mapLibName(str);
        if (strMapLibName != null) {
            str = strMapLibName;
        }
        java.lang.String strMapLibraryName = java.lang.System.mapLibraryName(str);
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources != null) {
                for (int i = 0; i < sSoSources.length; i++) {
                    try {
                        java.io.File soFileByName = sSoSources[i].getSoFileByName(strMapLibraryName);
                        if (soFileByName != null) {
                            sSoSourcesLock.readLock().unlock();
                            return soFileByName;
                        }
                    } catch (java.io.IOException unused) {
                    }
                }
            }
            sSoSourcesLock.readLock().unlock();
            return null;
        } catch (java.lang.Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    public static boolean loadLibrary(java.lang.String str) {
        return isEnabled ? loadLibrary(str, 0) : com.facebook.soloader.nativeloader.NativeLoader.loadLibrary(str);
    }

    public static boolean loadLibrary(java.lang.String str, int i) throws java.lang.UnsatisfiedLinkError {
        com.facebook.soloader.SystemLoadLibraryWrapper systemLoadLibraryWrapper;
        java.lang.Boolean boolLoadLibraryOnNonAndroid = loadLibraryOnNonAndroid(str);
        if (boolLoadLibraryOnNonAndroid != null) {
            return boolLoadLibraryOnNonAndroid.booleanValue();
        }
        if (!isEnabled) {
            return com.facebook.soloader.nativeloader.NativeLoader.loadLibrary(str);
        }
        int i2 = sAppType;
        if ((i2 == 2 || i2 == 3) && (systemLoadLibraryWrapper = sSystemLoadLibraryWrapper) != null) {
            systemLoadLibraryWrapper.loadLibrary(str);
            return true;
        }
        java.lang.String strMapLibName = com.facebook.soloader.MergedSoMapping.mapLibName(str);
        return loadLibraryBySoName(java.lang.System.mapLibraryName(strMapLibName != null ? strMapLibName : str), str, strMapLibName, i, null);
    }

    @javax.annotation.Nullable
    private static java.lang.Boolean loadLibraryOnNonAndroid(java.lang.String str) {
        java.lang.Boolean boolValueOf;
        if (sSoSources != null) {
            return null;
        }
        java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (sSoSources == null) {
                if ("http://www.android.com/".equals(java.lang.System.getProperty("java.vendor.url"))) {
                    assertInitialized();
                } else {
                    synchronized (com.facebook.soloader.SoLoader.class) {
                        boolean zContains = sLoadedLibraries.contains(str);
                        boolean z = !zContains;
                        if (!zContains) {
                            com.facebook.soloader.SystemLoadLibraryWrapper systemLoadLibraryWrapper = sSystemLoadLibraryWrapper;
                            if (systemLoadLibraryWrapper != null) {
                                systemLoadLibraryWrapper.loadLibrary(str);
                            } else {
                                java.lang.System.loadLibrary(str);
                            }
                        }
                        boolValueOf = java.lang.Boolean.valueOf(z);
                    }
                    reentrantReadWriteLock.readLock().unlock();
                    return boolValueOf;
                }
            }
            reentrantReadWriteLock.readLock().unlock();
            return null;
        } catch (java.lang.Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    static void loadDependency(java.lang.String str, int i, android.os.StrictMode.ThreadPolicy threadPolicy) {
        loadLibraryBySoNameImpl(str, null, null, i | 1, threadPolicy);
    }

    private static boolean loadLibraryBySoName(java.lang.String str, @javax.annotation.Nullable java.lang.String str2, @javax.annotation.Nullable java.lang.String str3, int i, @javax.annotation.Nullable android.os.StrictMode.ThreadPolicy threadPolicy) {
        com.facebook.soloader.recovery.RecoveryStrategy recoveryStrategy = null;
        while (true) {
            try {
                return loadLibraryBySoNameImpl(str, str2, str3, i, threadPolicy);
            } catch (java.lang.UnsatisfiedLinkError e) {
                com.facebook.soloader.LogUtil.w(TAG, "Starting recovery for " + str, e);
                sSoSourcesLock.writeLock().lock();
                if (recoveryStrategy == null) {
                    try {
                        try {
                            recoveryStrategy = getRecoveryStrategy();
                        } catch (com.facebook.soloader.NoBaseApkException e2) {
                            com.facebook.soloader.LogUtil.e(TAG, "Base APK not found during recovery", e2);
                            throw e2;
                        } catch (java.lang.Exception e3) {
                            com.facebook.soloader.LogUtil.e(TAG, "Got an exception during recovery, will throw the initial error instead", e3);
                            throw e;
                        }
                    } catch (java.lang.Throwable th) {
                        sSoSourcesLock.writeLock().unlock();
                        throw th;
                    }
                }
                if (recoveryStrategy != null && recoveryStrategy.recover(e, sSoSources)) {
                    sSoSourcesVersion.getAndIncrement();
                    com.facebook.soloader.LogUtil.w(TAG, "Attempting to load library again");
                    sSoSourcesLock.writeLock().unlock();
                } else {
                    sSoSourcesLock.writeLock().unlock();
                    com.facebook.soloader.LogUtil.w(TAG, "Failed to recover");
                    throw e;
                }
            }
        }
    }

    @javax.annotation.Nullable
    private static synchronized com.facebook.soloader.recovery.RecoveryStrategy getRecoveryStrategy() {
        com.facebook.soloader.recovery.RecoveryStrategyFactory recoveryStrategyFactory;
        recoveryStrategyFactory = sRecoveryStrategyFactory;
        return recoveryStrategyFactory == null ? null : recoveryStrategyFactory.get();
    }

    static synchronized void setRecoveryStrategyFactory(com.facebook.soloader.recovery.RecoveryStrategyFactory recoveryStrategyFactory) {
        sRecoveryStrategyFactory = recoveryStrategyFactory;
    }

    private static boolean loadLibraryBySoNameImpl(java.lang.String str, @javax.annotation.Nullable java.lang.String str2, @javax.annotation.Nullable java.lang.String str3, int i, @javax.annotation.Nullable android.os.StrictMode.ThreadPolicy threadPolicy) {
        boolean z;
        java.lang.Object obj;
        boolean z2 = false;
        if (!android.text.TextUtils.isEmpty(str2) && sLoadedAndMergedLibraries.contains(str2)) {
            return false;
        }
        synchronized (com.facebook.soloader.SoLoader.class) {
            java.util.HashSet<java.lang.String> hashSet = sLoadedLibraries;
            if (!hashSet.contains(str)) {
                z = false;
            } else {
                if (str3 == null) {
                    return false;
                }
                z = true;
            }
            java.util.Map<java.lang.String, java.lang.Object> map = sLoadingLibraries;
            if (map.containsKey(str)) {
                obj = map.get(str);
            } else {
                java.lang.Object obj2 = new java.lang.Object();
                map.put(str, obj2);
                obj = obj2;
            }
            java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
            reentrantReadWriteLock.readLock().lock();
            try {
                synchronized (obj) {
                    if (!z) {
                        try {
                            synchronized (com.facebook.soloader.SoLoader.class) {
                                if (hashSet.contains(str)) {
                                    if (str3 == null) {
                                        reentrantReadWriteLock.readLock().unlock();
                                        return false;
                                    }
                                    z = true;
                                }
                                if (!z) {
                                    try {
                                        com.facebook.soloader.LogUtil.d(TAG, "About to load: " + str);
                                        doLoadLibraryBySoName(str, i, threadPolicy);
                                        com.facebook.soloader.LogUtil.d(TAG, "Loaded: " + str);
                                        synchronized (com.facebook.soloader.SoLoader.class) {
                                            hashSet.add(str);
                                        }
                                    } catch (java.lang.UnsatisfiedLinkError e) {
                                        java.lang.String message = e.getMessage();
                                        if (message != null && message.contains("unexpected e_machine:")) {
                                            throw new com.facebook.soloader.SoLoader.WrongAbiError(e, message.substring(message.lastIndexOf("unexpected e_machine:")));
                                        }
                                        throw e;
                                    }
                                }
                            }
                        } catch (java.lang.Throwable th) {
                            throw th;
                        }
                    }
                    if ((i & 16) == 0) {
                        if (!android.text.TextUtils.isEmpty(str2) && sLoadedAndMergedLibraries.contains(str2)) {
                            z2 = true;
                        }
                        if (str3 != null && !z2) {
                            boolean z3 = SYSTRACE_LIBRARY_LOADING;
                            if (z3) {
                                com.facebook.soloader.Api18TraceUtils.beginTraceSection("MergedSoMapping.invokeJniOnload[", str2, com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
                            }
                            try {
                                try {
                                    com.facebook.soloader.LogUtil.d(TAG, "About to merge: " + str2 + " / " + str);
                                    com.facebook.soloader.MergedSoMapping.invokeJniOnload(str2);
                                    sLoadedAndMergedLibraries.add(str2);
                                    if (z3) {
                                        com.facebook.soloader.Api18TraceUtils.endSection();
                                    }
                                } catch (java.lang.UnsatisfiedLinkError e2) {
                                    throw new java.lang.RuntimeException("Failed to call JNI_OnLoad from '" + str2 + "', which has been merged into '" + str + "'.  See comment for details.", e2);
                                }
                            } catch (java.lang.Throwable th2) {
                                if (SYSTRACE_LIBRARY_LOADING) {
                                    com.facebook.soloader.Api18TraceUtils.endSection();
                                    throw th2;
                                }
                                throw th2;
                            }
                        }
                    }
                    reentrantReadWriteLock.readLock().unlock();
                    return !z;
                }
            } catch (java.lang.Throwable th3) {
                sSoSourcesLock.readLock().unlock();
                throw th3;
            }
        }
    }

    public static java.io.File unpackLibraryAndDependencies(java.lang.String str) throws java.lang.UnsatisfiedLinkError {
        assertInitialized();
        try {
            return unpackLibraryBySoName(java.lang.System.mapLibraryName(str));
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    private static void doLoadLibraryBySoName(java.lang.String str, int i, @javax.annotation.Nullable android.os.StrictMode.ThreadPolicy threadPolicy) throws java.lang.UnsatisfiedLinkError {
        boolean z;
        java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (sSoSources == null) {
                com.facebook.soloader.LogUtil.e(TAG, "Could not load: " + str + " because SoLoader is not initialized");
                throw new java.lang.UnsatisfiedLinkError("SoLoader not initialized, couldn't find DSO to load: " + str);
            }
            reentrantReadWriteLock.readLock().unlock();
            if (threadPolicy == null) {
                threadPolicy = android.os.StrictMode.allowThreadDiskReads();
                z = true;
            } else {
                z = false;
            }
            if (SYSTRACE_LIBRARY_LOADING) {
                com.facebook.soloader.Api18TraceUtils.beginTraceSection("SoLoader.loadLibrary[", str, com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
            }
            try {
                reentrantReadWriteLock.readLock().lock();
                try {
                    try {
                        for (com.facebook.soloader.SoSource soSource : sSoSources) {
                            if (soSource.loadLibrary(str, i, threadPolicy) != 0) {
                                sSoSourcesLock.readLock().unlock();
                                if (SYSTRACE_LIBRARY_LOADING) {
                                    com.facebook.soloader.Api18TraceUtils.endSection();
                                }
                                if (z) {
                                    android.os.StrictMode.setThreadPolicy(threadPolicy);
                                    return;
                                }
                                return;
                            }
                        }
                        throw com.facebook.soloader.SoLoaderDSONotFoundError.create(str, sApplicationContext, sSoSources);
                    } catch (java.lang.Throwable th) {
                        sSoSourcesLock.readLock().unlock();
                        throw th;
                    }
                } catch (java.io.IOException e) {
                    com.facebook.soloader.SoLoaderULError soLoaderULError = new com.facebook.soloader.SoLoaderULError(str, e.toString());
                    soLoaderULError.initCause(e);
                    throw soLoaderULError;
                }
            } catch (java.lang.Throwable th2) {
                if (SYSTRACE_LIBRARY_LOADING) {
                    com.facebook.soloader.Api18TraceUtils.endSection();
                }
                if (z) {
                    android.os.StrictMode.setThreadPolicy(threadPolicy);
                }
                throw th2;
            }
        } catch (java.lang.Throwable th3) {
            sSoSourcesLock.readLock().unlock();
            throw th3;
        }
    }

    static java.io.File unpackLibraryBySoName(java.lang.String str) throws java.io.IOException {
        sSoSourcesLock.readLock().lock();
        try {
            for (com.facebook.soloader.SoSource soSource : sSoSources) {
                java.io.File fileUnpackLibrary = soSource.unpackLibrary(str);
                if (fileUnpackLibrary != null) {
                    return fileUnpackLibrary;
                }
            }
            throw new java.io.FileNotFoundException(str);
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    private static void assertInitialized() {
        if (!isInitialized()) {
            throw new java.lang.IllegalStateException("SoLoader.init() not yet called");
        }
    }

    public static boolean isInitialized() {
        if (sSoSources != null) {
            return true;
        }
        sSoSourcesLock.readLock().lock();
        try {
            return sSoSources != null;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static int getSoSourcesVersion() {
        return sSoSourcesVersion.get();
    }

    public static void prependSoSource(com.facebook.soloader.SoSource soSource) throws java.io.IOException {
        sSoSourcesLock.writeLock().lock();
        try {
            assertInitialized();
            soSource.prepare(makePrepareFlags());
            com.facebook.soloader.SoSource[] soSourceArr = new com.facebook.soloader.SoSource[sSoSources.length + 1];
            soSourceArr[0] = soSource;
            java.lang.System.arraycopy(sSoSources, 0, soSourceArr, 1, sSoSources.length);
            sSoSources = soSourceArr;
            sSoSourcesVersion.getAndIncrement();
            com.facebook.soloader.LogUtil.d(TAG, "Prepended to SO sources: " + soSource);
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    public static java.lang.String makeLdLibraryPath() {
        sSoSourcesLock.readLock().lock();
        try {
            assertInitialized();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            com.facebook.soloader.SoSource[] soSourceArr = sSoSources;
            if (soSourceArr != null) {
                for (com.facebook.soloader.SoSource soSource : soSourceArr) {
                    soSource.addToLdLibraryPath(arrayList);
                }
            }
            java.lang.String strJoin = android.text.TextUtils.join(":", arrayList);
            com.facebook.soloader.LogUtil.d(TAG, "makeLdLibraryPath final path: " + strJoin);
            return strJoin;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static boolean areSoSourcesAbisSupported() {
        java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (sSoSources != null) {
                java.lang.String[] supportedAbis = com.facebook.soloader.SysUtil.getSupportedAbis();
                for (com.facebook.soloader.SoSource soSource : sSoSources) {
                    for (java.lang.String str : soSource.getSoSourceAbis()) {
                        boolean zEquals = false;
                        for (int i = 0; i < supportedAbis.length && !zEquals; i++) {
                            zEquals = str.equals(supportedAbis[i]);
                        }
                        if (!zEquals) {
                            com.facebook.soloader.LogUtil.e(TAG, "abi not supported: " + str);
                            reentrantReadWriteLock = sSoSourcesLock;
                        }
                    }
                }
                sSoSourcesLock.readLock().unlock();
                return true;
            }
            reentrantReadWriteLock.readLock().unlock();
            return false;
        } catch (java.lang.Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    public static boolean useDepsFile(android.content.Context context, boolean z, boolean z2) {
        return com.facebook.soloader.NativeDeps.useDepsFile(context, z, z2);
    }

    public static int getLoadedLibrariesCount() {
        return sLoadedLibraries.size();
    }
}
