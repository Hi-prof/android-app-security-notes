package io.dcloud.application;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DCLoudApplicationImpl {
    private static io.dcloud.application.DCLoudApplicationImpl mInstance;
    private io.dcloud.application.DCLoudApplicationImpl.ActivityCallbacks activityCallbacks;
    private android.content.Context mApplication;
    private io.dcloud.p.i3 nativeAppInfo;
    private java.lang.String Tag = "DCLoudApplicationImpl";
    boolean isUniMP = false;
    private boolean isInit = false;
    public java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.ref.WeakReference<android.app.Activity>> topActiveMap = new java.util.concurrent.ConcurrentHashMap<>();
    public android.app.Activity topActivity = null;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class ActivityCallbacks implements android.app.Application.ActivityLifecycleCallbacks {
        private int activityStartCount;
        private volatile boolean isBack;
        private boolean isStop;
        private java.util.List<io.dcloud.application.DCLoudApplicationImpl.ActivityStatusListener> listeners;

        private ActivityCallbacks() {
            this.activityStartCount = 0;
            this.isBack = false;
            this.isStop = false;
        }

        public void addListener(io.dcloud.application.DCLoudApplicationImpl.ActivityStatusListener activityStatusListener) {
            if (this.listeners == null) {
                this.listeners = new java.util.ArrayList();
            }
            this.listeners.add(activityStatusListener);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(android.app.Activity activity) {
            io.dcloud.application.DCLoudApplicationImpl dCLoudApplicationImpl = io.dcloud.application.DCLoudApplicationImpl.this;
            if (dCLoudApplicationImpl.topActivity == activity) {
                dCLoudApplicationImpl.topActivity = null;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(android.app.Activity activity) {
            try {
                io.dcloud.application.DCLoudApplicationImpl.this.topActiveMap.remove(activity.getComponentName().getClassName());
            } catch (java.lang.Exception unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(android.app.Activity activity) {
            try {
                io.dcloud.application.DCLoudApplicationImpl.this.topActiveMap.put(activity.getComponentName().getClassName(), new java.lang.ref.WeakReference<>(activity));
                io.dcloud.application.DCLoudApplicationImpl.this.topActivity = activity;
            } catch (java.lang.Exception unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(android.app.Activity activity) {
            if (this.isStop) {
                this.isStop = false;
            } else if (this.activityStartCount == 0 && this.isBack) {
                this.isBack = false;
                java.util.List<io.dcloud.application.DCLoudApplicationImpl.ActivityStatusListener> list = this.listeners;
                if (list != null && !list.isEmpty()) {
                    for (io.dcloud.application.DCLoudApplicationImpl.ActivityStatusListener activityStatusListener : this.listeners) {
                        if (activityStatusListener != null) {
                            activityStatusListener.onFront();
                        }
                    }
                }
            }
            this.activityStartCount++;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(android.app.Activity activity) {
            this.activityStartCount--;
        }

        public void onApp2Back() {
            if (this.isStop) {
                return;
            }
            if (!this.isBack) {
                io.dcloud.common.adapter.util.Logger.d("DCloud_uniAd", "app is in back");
                java.util.List<io.dcloud.application.DCLoudApplicationImpl.ActivityStatusListener> list = this.listeners;
                if (list != null && !list.isEmpty()) {
                    for (io.dcloud.application.DCLoudApplicationImpl.ActivityStatusListener activityStatusListener : this.listeners) {
                        if (activityStatusListener != null) {
                            activityStatusListener.onBack();
                        }
                    }
                }
            }
            this.isBack = true;
        }

        public void removeListener(io.dcloud.application.DCLoudApplicationImpl.ActivityStatusListener activityStatusListener) {
            java.util.List<io.dcloud.application.DCLoudApplicationImpl.ActivityStatusListener> list = this.listeners;
            if (list != null) {
                list.remove(activityStatusListener);
            }
        }

        public void stopListener() {
            this.isStop = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface ActivityStatusListener {
        void onBack();

        void onFront();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public class DynamicLanguageReceiver extends android.content.BroadcastReceiver {
        public DynamicLanguageReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            if (context == null) {
                return;
            }
            android.content.Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            launchIntentForPackage.setFlags(268468224);
            context.startActivity(launchIntentForPackage);
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    private void initLanguageConfig(android.content.Context context) {
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction(io.dcloud.common.util.language.LanguageUtil.LanguageBroadCastIntent);
        androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(self().getContext()).registerReceiver(new io.dcloud.application.DCLoudApplicationImpl.DynamicLanguageReceiver(), intentFilter);
        if (android.os.Build.VERSION.SDK_INT < 26) {
            io.dcloud.common.util.language.LanguageUtil.initAppLanguageForAppBeforeO(context);
        }
    }

    private void initX5(android.app.Application application, boolean z) {
        if (z) {
            io.dcloud.common.util.AppRuntime.initX5(application, io.dcloud.common.util.BaseInfo.allowDownloadWithoutWiFi, null);
        }
    }

    public static io.dcloud.application.DCLoudApplicationImpl self() {
        if (mInstance == null) {
            mInstance = new io.dcloud.application.DCLoudApplicationImpl();
        }
        return mInstance;
    }

    public void addActivityStatusListener(io.dcloud.application.DCLoudApplicationImpl.ActivityStatusListener activityStatusListener) {
        io.dcloud.application.DCLoudApplicationImpl.ActivityCallbacks activityCallbacks = this.activityCallbacks;
        if (activityCallbacks != null) {
            activityCallbacks.addListener(activityStatusListener);
        }
    }

    protected android.content.Context attachBaseContext(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            context = io.dcloud.common.util.language.LanguageUtil.updateContextLanguageAfterO(context, true, false);
        }
        if (!io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            io.dcloud.p.l.a(context);
        }
        return context;
    }

    public android.content.Context getContext() {
        return this.mApplication;
    }

    public io.dcloud.common.DHInterface.INativeAppInfo getNativeInfo(android.app.Application application) {
        if (this.nativeAppInfo == null) {
            this.nativeAppInfo = new io.dcloud.p.i3(application);
        }
        return this.nativeAppInfo;
    }

    public void init(android.app.Application application, boolean z) {
        this.isUniMP = z;
        if (z && android.os.Build.VERSION.SDK_INT >= 26) {
            io.dcloud.common.util.language.LanguageUtil.updateContextLanguageAfterO(application, true);
        }
        io.dcloud.feature.internal.sdk.SDK.isUniMP = this.isUniMP;
        onCreate(application);
        if (io.dcloud.common.util.BaseInfo.isBase(application) && this.isInit) {
            webviewSetPath(application, true);
        }
        if (z) {
            io.dcloud.common.adapter.util.DeviceInfo.initGsmCdmaCell();
            io.dcloud.common.util.TelephonyUtil.updateIMEI(application);
        }
    }

    public boolean isInit() {
        return this.isInit;
    }

    public boolean isMainProcess(android.content.Context context, boolean z) {
        if (!z) {
            return true;
        }
        boolean zEquals = context.getPackageName().equals(io.dcloud.common.util.RuningAcitvityUtil.getAppName(context));
        if (!zEquals && !this.isUniMP) {
            if (io.dcloud.common.util.RuningAcitvityUtil.getAppName(context).startsWith(context.getPackageName() + ":unimp")) {
                this.isUniMP = true;
                io.dcloud.feature.internal.sdk.SDK.isUniMP = true;
            }
        }
        return zEquals;
    }

    public void onApp2Back() {
        io.dcloud.application.DCLoudApplicationImpl.ActivityCallbacks activityCallbacks = this.activityCallbacks;
        if (activityCallbacks != null) {
            activityCallbacks.onApp2Back();
        }
    }

    public void onCreate(android.app.Application application) {
        if (this.isInit) {
            return;
        }
        io.dcloud.common.adapter.util.AndroidResources.initAndroidResources(application.getBaseContext());
        io.dcloud.common.util.BaseInfo.parseControl();
        io.dcloud.common.adapter.util.DeviceInfo.initPath(application, false);
        boolean zHasPrivacyForNotShown = io.dcloud.common.util.AppRuntime.hasPrivacyForNotShown(application);
        boolean z = !zHasPrivacyForNotShown;
        if (!zHasPrivacyForNotShown) {
            io.dcloud.common.adapter.util.DeviceInfo.init(application);
            io.dcloud.common.adapter.util.DeviceInfo.initPath(application);
            io.dcloud.common.util.NativeCrashManager.initNativeCrash(application);
        }
        boolean zIsMainProcess = isMainProcess(application, z);
        webviewSetPath(application, z);
        this.isInit = true;
        io.dcloud.common.util.PdrUtil.closeAndroidPDialog();
        io.dcloud.common.DHInterface.INativeAppInfo nativeInfo = getNativeInfo(application);
        io.dcloud.p.e1.a(nativeInfo);
        io.dcloud.common.util.BaseInfo.isFirstRun = true;
        io.dcloud.common.util.AppRuntime.onCreateProcess(application, java.lang.Boolean.valueOf(zIsMainProcess), java.lang.Boolean.valueOf(z));
        if ((!io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() && zIsMainProcess) || (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() && this.isUniMP)) {
            if (!io.dcloud.common.util.BaseInfo.SyncDebug || (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() && this.isUniMP)) {
                io.dcloud.common.util.AppRuntime.initWeex(nativeInfo);
            }
            initX5(application, z);
        }
        if (!io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            io.dcloud.p.l.a(application);
        }
        this.mApplication = application;
        setContext(application);
        io.dcloud.common.adapter.util.UEH.catchUncaughtException(application);
        io.dcloud.common.adapter.util.UEH.uploadNativeUncaughtException(application);
        if (io.dcloud.common.util.PdrUtil.isSupportOaid()) {
            try {
                java.lang.reflect.Method declaredMethod = java.lang.Class.forName("com.bun.miitmdid.core.JLibrary").getDeclaredMethod("InitEntry", android.content.Context.class);
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(null, application);
                }
            } catch (java.lang.Exception unused) {
            }
        }
        io.dcloud.application.DCLoudApplicationImpl.ActivityCallbacks activityCallbacks = new io.dcloud.application.DCLoudApplicationImpl.ActivityCallbacks();
        this.activityCallbacks = activityCallbacks;
        application.registerActivityLifecycleCallbacks(activityCallbacks);
        initLanguageConfig(getContext());
        io.dcloud.common.ui.PrivacyManager.getInstance().init(self().getContext());
    }

    public void removeActivityStatusListener(io.dcloud.application.DCLoudApplicationImpl.ActivityStatusListener activityStatusListener) {
        io.dcloud.application.DCLoudApplicationImpl.ActivityCallbacks activityCallbacks = this.activityCallbacks;
        if (activityCallbacks != null) {
            activityCallbacks.removeListener(activityStatusListener);
        }
    }

    public void setContext(android.content.Context context) {
        if (this.mApplication == null) {
            this.mApplication = context;
        }
    }

    public void stopActivityStatusListener() {
        io.dcloud.application.DCLoudApplicationImpl.ActivityCallbacks activityCallbacks = this.activityCallbacks;
        if (activityCallbacks != null) {
            activityCallbacks.stopListener();
        }
    }

    protected void supportMultiDex(android.content.Context context) {
        try {
            java.lang.Class.forName("androidx.multidex.MultiDex").getMethod("install", android.content.Context.class).invoke(null, context);
        } catch (java.lang.Exception unused) {
        }
    }

    public void webviewSetPath(android.content.Context context, boolean z) {
        try {
            if (android.os.Build.VERSION.SDK_INT < 28 || !io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() || isMainProcess(context, z)) {
                return;
            }
            android.webkit.WebView.setDataDirectorySuffix(io.dcloud.common.util.RuningAcitvityUtil.getAppName(context));
        } catch (java.lang.Exception unused) {
        }
    }
}
