package com.hjq.permissions;

/* JADX INFO: loaded from: classes.dex */
class PermissionDelegateImplV30 extends com.hjq.permissions.PermissionDelegateImplV29 {
    PermissionDelegateImplV30() {
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(android.content.Context context, java.lang.String str) {
        if (com.hjq.permissions.PermissionUtils.equalsPermission(str, com.hjq.permissions.Permission.MANAGE_EXTERNAL_STORAGE)) {
            return isGrantedManageStoragePermission();
        }
        return super.isGrantedPermission(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(android.app.Activity activity, java.lang.String str) {
        if (com.hjq.permissions.PermissionUtils.equalsPermission(str, com.hjq.permissions.Permission.MANAGE_EXTERNAL_STORAGE)) {
            return false;
        }
        return super.isDoNotAskAgainPermission(activity, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public android.content.Intent getPermissionIntent(android.content.Context context, java.lang.String str) {
        if (com.hjq.permissions.PermissionUtils.equalsPermission(str, com.hjq.permissions.Permission.MANAGE_EXTERNAL_STORAGE)) {
            return getManageStoragePermissionIntent(context);
        }
        return super.getPermissionIntent(context, str);
    }

    private static boolean isGrantedManageStoragePermission() {
        return android.os.Environment.isExternalStorageManager();
    }

    private static android.content.Intent getManageStoragePermissionIntent(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
        intent.setData(com.hjq.permissions.PermissionUtils.getPackageNameUri(context));
        if (!com.hjq.permissions.PermissionUtils.areActivityIntent(context, intent)) {
            intent = new android.content.Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
        }
        return !com.hjq.permissions.PermissionUtils.areActivityIntent(context, intent) ? com.hjq.permissions.PermissionIntentManager.getApplicationDetailsIntent(context) : intent;
    }
}
