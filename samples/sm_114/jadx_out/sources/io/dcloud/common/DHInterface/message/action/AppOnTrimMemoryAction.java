package io.dcloud.common.DHInterface.message.action;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class AppOnTrimMemoryAction implements io.dcloud.common.DHInterface.message.action.IAction {
    private int level;

    public AppOnTrimMemoryAction(int i) {
        this.level = i;
    }

    public static io.dcloud.common.DHInterface.message.action.AppOnTrimMemoryAction obtain(int i) {
        return new io.dcloud.common.DHInterface.message.action.AppOnTrimMemoryAction(i);
    }

    public int getLevel() {
        return this.level;
    }
}
