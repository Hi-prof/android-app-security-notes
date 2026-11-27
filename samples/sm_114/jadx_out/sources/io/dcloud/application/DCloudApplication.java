package io.dcloud.application;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DCloudApplication extends android.app.Application {
    private final java.lang.String TAG = "DCloudApplication";

    public void addActivityStatusListener(io.dcloud.application.DCLoudApplicationImpl.ActivityStatusListener activityStatusListener) {
        io.dcloud.application.DCLoudApplicationImpl.self().addActivityStatusListener(activityStatusListener);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(android.content.Context context) {
        super.attachBaseContext(context);
        io.dcloud.application.DCLoudApplicationImpl.self().attachBaseContext(context);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        io.dcloud.common.DHInterface.message.ActionBus.getInstance().sendToBus(io.dcloud.common.DHInterface.message.action.AppOnConfigChangedAction.obtain(configuration));
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        io.dcloud.application.DCLoudApplicationImpl.self().onCreate(this);
        io.dcloud.common.DHInterface.message.ActionBus.getInstance().sendToBus(io.dcloud.common.DHInterface.message.action.AppOnCreateAction.obtain());
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        io.dcloud.common.adapter.util.Logger.e(this.TAG, "onLowMemory" + java.lang.Runtime.getRuntime().maxMemory());
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        io.dcloud.common.DHInterface.message.ActionBus.getInstance().sendToBus(io.dcloud.common.DHInterface.message.action.AppOnTrimMemoryAction.obtain(i));
    }

    public void removeActivityStatusListener(io.dcloud.application.DCLoudApplicationImpl.ActivityStatusListener activityStatusListener) {
        io.dcloud.application.DCLoudApplicationImpl.self().removeActivityStatusListener(activityStatusListener);
    }

    public void stopB2FOnce() {
        io.dcloud.application.DCLoudApplicationImpl.self().stopActivityStatusListener();
    }
}
