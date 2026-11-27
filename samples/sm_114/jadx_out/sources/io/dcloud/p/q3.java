package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class q3 {
    android.content.Context a;
    io.dcloud.p.k0 b;
    private long c = 0;

    public q3(android.content.Context context, io.dcloud.common.DHInterface.ICore.ICoreStatusListener iCoreStatusListener) {
        this.b = null;
        this.a = context;
        this.b = io.dcloud.p.k0.a(context, iCoreStatusListener);
    }

    public void a(android.app.Activity activity, android.os.Bundle bundle, io.dcloud.feature.internal.sdk.SDK.IntegratedMode integratedMode, io.dcloud.common.DHInterface.IOnCreateSplashView iOnCreateSplashView) {
        android.os.Bundle extras;
        if (iOnCreateSplashView != null && integratedMode != io.dcloud.feature.internal.sdk.SDK.IntegratedMode.WEBAPP && integratedMode != io.dcloud.feature.internal.sdk.SDK.IntegratedMode.WEBVIEW) {
            iOnCreateSplashView.onCreateSplash(null);
        }
        this.b.a(activity, bundle, integratedMode);
        android.content.Intent intent = activity.getIntent();
        java.lang.String string = (intent == null || (extras = intent.getExtras()) == null) ? null : extras.getString("appid");
        if (io.dcloud.common.util.PdrUtil.isEmpty(string)) {
            string = io.dcloud.common.util.BaseInfo.sDefaultBootApp;
        }
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            a(activity, (android.content.Intent) null, (io.dcloud.common.DHInterface.IOnCreateSplashView) null, string);
        } else if (a(intent, string) && io.dcloud.common.util.BaseInfo.sRuntimeMode == null) {
            a(activity, activity.getIntent(), (io.dcloud.common.DHInterface.IOnCreateSplashView) null, string);
        }
    }

    public void b(android.app.Activity activity) {
        this.c = java.lang.System.currentTimeMillis();
        io.dcloud.common.adapter.util.Logger.i("onResume resumeTime=" + this.c);
        this.b.c(activity);
    }

    public boolean c(android.app.Activity activity) {
        io.dcloud.common.adapter.util.Logger.i("onStop");
        if (!this.b.d(activity)) {
            return false;
        }
        this.b = null;
        return true;
    }

    public android.content.Context b() {
        return this.a;
    }

    boolean a(android.content.Intent intent, java.lang.String str) {
        boolean booleanExtra = intent.getBooleanExtra(io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_HAS_STREAM_SPLASH, false);
        if (booleanExtra) {
            if (android.text.TextUtils.isEmpty(str)) {
                str = intent.getStringExtra("appid");
            }
            java.lang.String str2 = io.dcloud.common.util.BaseInfo.sCacheFsAppsPath + str + "/www/";
            if (new java.io.File(str2).exists()) {
                java.io.File file = new java.io.File(str2 + "/manifest.json");
                if (file.exists() && file.length() > 0) {
                    return true;
                }
            }
            if (intent.hasExtra(io.dcloud.common.constant.IntentConst.DIRECT_PAGE) && io.dcloud.common.util.BaseInfo.isWap2AppAppid(str)) {
                return true;
            }
        }
        return !booleanExtra;
    }

    public io.dcloud.common.DHInterface.IApp a(android.app.Activity activity, android.content.Intent intent, io.dcloud.common.DHInterface.IOnCreateSplashView iOnCreateSplashView, java.lang.String str) {
        java.lang.String strObtainArgs = io.dcloud.common.constant.IntentConst.obtainArgs(intent, str);
        io.dcloud.common.adapter.util.Logger.i("onStart appid=" + str + ";intentArgs=" + strObtainArgs);
        if (iOnCreateSplashView == null) {
            this.b.a(activity, str, strObtainArgs);
            return null;
        }
        return this.b.a(activity, str, strObtainArgs, iOnCreateSplashView);
    }

    public boolean a(android.app.Activity activity, io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
        if (!a(activity.getIntent(), (java.lang.String) null) && !"all".equalsIgnoreCase(io.dcloud.common.util.BaseInfo.sSplashExitCondition)) {
            return false;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        long j = this.c;
        if (jCurrentTimeMillis - j > 500) {
            return this.b.onActivityExecute(activity, sysEventType, obj);
        }
        return j > 0 && sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp;
    }

    public void a(android.app.Activity activity) {
        io.dcloud.common.adapter.util.Logger.i("onPause");
        this.b.b(activity);
        this.c = 0L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(android.app.Activity activity, android.content.Intent intent) {
        android.os.Bundle extras;
        java.lang.String string = (intent == null || (extras = intent.getExtras()) == null) ? null : extras.getString("appid");
        java.lang.String strObtainArgs = io.dcloud.common.constant.IntentConst.obtainArgs(intent, string);
        if (!io.dcloud.common.util.PdrUtil.isEmpty(string)) {
            this.b.a(activity, string, strObtainArgs, activity instanceof io.dcloud.common.DHInterface.IOnCreateSplashView ? (io.dcloud.common.DHInterface.IOnCreateSplashView) activity : null, intent.getBooleanExtra(io.dcloud.common.constant.IntentConst.EXE_NEW_INTENT, true));
        } else {
            this.b.onActivityExecute(activity, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onNewIntent, strObtainArgs);
        }
    }

    public void a(android.app.Activity activity, int i) {
        io.dcloud.common.adapter.util.Logger.i(io.dcloud.common.adapter.util.Logger.LAYOUT_TAG, "onConfigurationChanged pConfig=" + i);
        this.b.onActivityExecute(activity, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onConfigurationChanged, 1);
    }

    public io.dcloud.common.DHInterface.ICore a() {
        return this.b;
    }
}
