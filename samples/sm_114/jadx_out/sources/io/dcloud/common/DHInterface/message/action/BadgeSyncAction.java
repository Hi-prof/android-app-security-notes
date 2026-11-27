package io.dcloud.common.DHInterface.message.action;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class BadgeSyncAction implements io.dcloud.common.DHInterface.message.action.IAction {
    private io.dcloud.common.DHInterface.message.action.BadgeSyncAction.ENUM_ACTION_TYPE mActionType;
    public int syncNumVal;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public enum ENUM_ACTION_TYPE {
        SYNC_NUM
    }

    private BadgeSyncAction(io.dcloud.common.DHInterface.message.action.BadgeSyncAction.ENUM_ACTION_TYPE enum_action_type) {
        this.mActionType = enum_action_type;
    }

    public static io.dcloud.common.DHInterface.message.action.BadgeSyncAction obtain(io.dcloud.common.DHInterface.message.action.BadgeSyncAction.ENUM_ACTION_TYPE enum_action_type) {
        return new io.dcloud.common.DHInterface.message.action.BadgeSyncAction(enum_action_type);
    }

    public io.dcloud.common.DHInterface.message.action.BadgeSyncAction.ENUM_ACTION_TYPE getActionType() {
        return this.mActionType;
    }

    public int getSyncNumVal() {
        return this.syncNumVal;
    }

    public io.dcloud.common.DHInterface.message.action.BadgeSyncAction setSyncNum(int i) {
        this.syncNumVal = i;
        return this;
    }
}
