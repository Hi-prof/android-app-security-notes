package com.hjq.permissions;

/* JADX INFO: loaded from: classes.dex */
class PermissionDelegateImplV34 extends com.hjq.permissions.PermissionDelegateImplV33 {
    PermissionDelegateImplV34() {
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV33, com.hjq.permissions.PermissionDelegateImplV31, com.hjq.permissions.PermissionDelegateImplV30, com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(android.content.Context context, java.lang.String str) {
        if (com.hjq.permissions.PermissionUtils.equalsPermission(str, com.hjq.permissions.Permission.READ_MEDIA_VISUAL_USER_SELECTED)) {
            return com.hjq.permissions.PermissionUtils.checkSelfPermission(context, com.hjq.permissions.Permission.READ_MEDIA_VISUAL_USER_SELECTED);
        }
        if (com.hjq.permissions.PermissionUtils.equalsPermission(str, com.hjq.permissions.Permission.READ_MEDIA_IMAGES) && !com.hjq.permissions.PermissionUtils.checkSelfPermission(context, com.hjq.permissions.Permission.READ_MEDIA_IMAGES)) {
            return com.hjq.permissions.PermissionUtils.checkSelfPermission(context, com.hjq.permissions.Permission.READ_MEDIA_VISUAL_USER_SELECTED);
        }
        if (com.hjq.permissions.PermissionUtils.equalsPermission(str, com.hjq.permissions.Permission.READ_MEDIA_VIDEO) && !com.hjq.permissions.PermissionUtils.checkSelfPermission(context, com.hjq.permissions.Permission.READ_MEDIA_VIDEO)) {
            return com.hjq.permissions.PermissionUtils.checkSelfPermission(context, com.hjq.permissions.Permission.READ_MEDIA_VISUAL_USER_SELECTED);
        }
        return super.isGrantedPermission(context, str);
    }

    @Override // com.hjq.permissions.PermissionDelegateImplV33, com.hjq.permissions.PermissionDelegateImplV31, com.hjq.permissions.PermissionDelegateImplV30, com.hjq.permissions.PermissionDelegateImplV29, com.hjq.permissions.PermissionDelegateImplV28, com.hjq.permissions.PermissionDelegateImplV26, com.hjq.permissions.PermissionDelegateImplV23, com.hjq.permissions.PermissionDelegateImplV21, com.hjq.permissions.PermissionDelegateImplV19, com.hjq.permissions.PermissionDelegateImplV18, com.hjq.permissions.PermissionDelegateImplV14, com.hjq.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(android.app.Activity activity, java.lang.String str) {
        if (com.hjq.permissions.PermissionUtils.equalsPermission(str, com.hjq.permissions.Permission.READ_MEDIA_VISUAL_USER_SELECTED)) {
            return (com.hjq.permissions.PermissionUtils.checkSelfPermission(activity, str) || com.hjq.permissions.PermissionUtils.shouldShowRequestPermissionRationale(activity, str)) ? false : true;
        }
        return super.isDoNotAskAgainPermission(activity, str);
    }
}
