package io.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class EntryProxy {
    public static boolean d = false;
    private static io.dcloud.EntryProxy e;
    private java.util.ArrayList a = new java.util.ArrayList(1);
    boolean b = false;
    io.dcloud.p.q3 c = null;

    private EntryProxy() {
    }

    private void clearData() {
        io.dcloud.common.adapter.util.Logger.d("EntryProxy", " clearData");
        e = null;
        d = false;
        this.b = false;
        io.dcloud.common.adapter.util.AndroidResources.clearData();
        io.dcloud.common.util.BaseInfo.clearData();
        this.c = null;
    }

    public static io.dcloud.EntryProxy getInstnace() {
        return e;
    }

    public static io.dcloud.EntryProxy init(android.app.Activity activity, io.dcloud.common.DHInterface.ICore.ICoreStatusListener iCoreStatusListener) {
        d = true;
        android.content.Context applicationContext = activity.getApplicationContext();
        io.dcloud.application.DCLoudApplicationImpl.self().setContext(applicationContext);
        io.dcloud.common.adapter.util.AndroidResources.initAndroidResources(applicationContext);
        io.dcloud.EntryProxy entryProxy = e;
        if (entryProxy != null) {
            entryProxy.c.a().setmCoreListener(iCoreStatusListener);
            if (e.c.b() != applicationContext) {
                e.destroy(activity);
            }
        }
        if (e == null) {
            e = new io.dcloud.EntryProxy();
            android.webkit.CookieSyncManager.createInstance(applicationContext);
            e.c = new io.dcloud.p.q3(applicationContext, iCoreStatusListener);
        }
        e.a.add(activity);
        return e;
    }

    public void destroy(android.app.Activity activity) {
        onStop(activity);
    }

    public boolean didCreate() {
        return this.b;
    }

    public io.dcloud.common.DHInterface.ICore getCoreHandler() {
        io.dcloud.p.q3 q3Var = this.c;
        if (q3Var != null) {
            return q3Var.a();
        }
        return null;
    }

    public android.app.Activity getEntryActivity() {
        if (this.a.size() > 0) {
            return (android.app.Activity) this.a.get(0);
        }
        return null;
    }

    public boolean onActivityExecute(android.app.Activity activity, io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
        io.dcloud.p.q3 q3Var = this.c;
        if (q3Var != null) {
            return q3Var.a(activity, sysEventType, obj);
        }
        return false;
    }

    public void onConfigurationChanged(android.app.Activity activity, int i) {
        io.dcloud.p.q3 q3Var = this.c;
        if (q3Var != null) {
            q3Var.a(activity, i);
        }
    }

    @java.lang.Deprecated
    public boolean onCreate(android.os.Bundle bundle, android.widget.FrameLayout frameLayout, io.dcloud.feature.internal.sdk.SDK.IntegratedMode integratedMode, io.dcloud.common.DHInterface.IOnCreateSplashView iOnCreateSplashView) {
        return onCreate(bundle, integratedMode, iOnCreateSplashView);
    }

    public void onNewIntent(android.app.Activity activity, android.content.Intent intent) {
        io.dcloud.p.q3 q3Var = this.c;
        if (q3Var != null) {
            q3Var.a(activity, intent);
        }
    }

    public void onPause(android.app.Activity activity) {
        io.dcloud.p.q3 q3Var = this.c;
        if (q3Var != null) {
            q3Var.a(activity);
        }
        android.webkit.CookieSyncManager.getInstance().stopSync();
    }

    public void onResume(android.app.Activity activity) {
        io.dcloud.p.q3 q3Var = this.c;
        if (q3Var != null) {
            q3Var.b(activity);
        }
        android.webkit.CookieSyncManager.getInstance().startSync();
    }

    public void onStop(android.app.Activity activity) {
        try {
            io.dcloud.common.core.ui.DCKeyboardManager.getInstance().onStop();
            io.dcloud.common.util.RuningAcitvityUtil.isRuningActivity = false;
            io.dcloud.common.util.BaseInfo.isFirstRun = false;
            this.a.remove(activity);
            if (this.a.size() == 0) {
                io.dcloud.p.q3 q3Var = this.c;
                if (q3Var == null) {
                    clearData();
                } else if (q3Var.c(activity)) {
                    clearData();
                }
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    @java.lang.Deprecated
    public boolean onCreate(android.os.Bundle bundle, io.dcloud.feature.internal.sdk.SDK.IntegratedMode integratedMode, io.dcloud.common.DHInterface.IOnCreateSplashView iOnCreateSplashView) {
        java.util.ArrayList arrayList = this.a;
        return onCreate((android.app.Activity) arrayList.get(arrayList.size() - 1), bundle, integratedMode, iOnCreateSplashView);
    }

    public boolean onCreate(android.app.Activity activity, android.os.Bundle bundle, io.dcloud.feature.internal.sdk.SDK.IntegratedMode integratedMode, io.dcloud.common.DHInterface.IOnCreateSplashView iOnCreateSplashView) {
        io.dcloud.common.util.RuningAcitvityUtil.isRuningActivity = true;
        io.dcloud.common.core.ui.DCKeyboardManager.getInstance().onCreate(activity);
        io.dcloud.common.adapter.util.AndroidResources.initAndroidResources(activity.getBaseContext());
        this.c.a(activity, bundle, integratedMode, iOnCreateSplashView);
        if (io.dcloud.common.util.BaseInfo.SyncDebug && !activity.getPackageName().equals(activity.getResources().getString(io.dcloud.PdrR.DCLOUD_PACKAGE_NAME_BASE))) {
            com.dcloud.android.widget.toast.ToastCompat.makeText((android.content.Context) activity, io.dcloud.PdrR.DCLOUD_SYNC_DEBUD_MESSAGE, 0).show();
        }
        return true;
    }

    @java.lang.Deprecated
    public boolean onCreate(android.os.Bundle bundle) {
        return onCreate(bundle, (android.widget.FrameLayout) null, (io.dcloud.feature.internal.sdk.SDK.IntegratedMode) null, (io.dcloud.common.DHInterface.IOnCreateSplashView) null);
    }

    public static io.dcloud.EntryProxy init(android.app.Activity activity) {
        return init(activity, null);
    }
}
