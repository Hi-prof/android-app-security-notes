package com.hjq.permissions;

/* JADX INFO: loaded from: classes.dex */
public interface PermissionDelegate {
    android.content.Intent getPermissionIntent(android.content.Context context, java.lang.String str);

    boolean isDoNotAskAgainPermission(android.app.Activity activity, java.lang.String str);

    boolean isGrantedPermission(android.content.Context context, java.lang.String str);
}
