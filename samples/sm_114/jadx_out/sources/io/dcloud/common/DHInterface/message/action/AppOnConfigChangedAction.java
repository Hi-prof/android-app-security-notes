package io.dcloud.common.DHInterface.message.action;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class AppOnConfigChangedAction implements io.dcloud.common.DHInterface.message.action.IAction {
    private android.content.res.Configuration newConfig;

    public AppOnConfigChangedAction(android.content.res.Configuration configuration) {
        this.newConfig = configuration;
    }

    public static io.dcloud.common.DHInterface.message.action.AppOnConfigChangedAction obtain(android.content.res.Configuration configuration) {
        return new io.dcloud.common.DHInterface.message.action.AppOnConfigChangedAction(configuration);
    }

    public android.content.res.Configuration getConfig() {
        return this.newConfig;
    }
}
