package com.hjq.permissions;

/* JADX INFO: loaded from: classes.dex */
public interface OnPermissionCallback {

    /* JADX INFO: renamed from: com.hjq.permissions.OnPermissionCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onDenied(com.hjq.permissions.OnPermissionCallback _this, java.util.List list, boolean z) {
        }
    }

    void onDenied(java.util.List<java.lang.String> list, boolean z);

    void onGranted(java.util.List<java.lang.String> list, boolean z);
}
