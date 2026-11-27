package io.dcloud.common.DHInterface.message.action;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class PermissionRequestAction implements io.dcloud.common.DHInterface.message.action.IAction {
    public static java.lang.String TYPE_COMPLETE = "complete";
    public static java.lang.String TYPE_CONFIRM = "confirm";
    public static java.lang.String TYPE_REQUEST = "request";
    private java.lang.String[] permissions;
    private final java.lang.String type;

    private PermissionRequestAction(java.lang.String str, java.lang.String[] strArr) {
        this.type = str;
        this.permissions = strArr;
    }

    public static io.dcloud.common.DHInterface.message.action.PermissionRequestAction obtain(java.lang.String str, java.lang.String[] strArr) {
        return new io.dcloud.common.DHInterface.message.action.PermissionRequestAction(str, strArr);
    }

    public java.lang.String[] getPermissions() {
        return this.permissions;
    }

    public java.lang.String getType() {
        return this.type;
    }
}
