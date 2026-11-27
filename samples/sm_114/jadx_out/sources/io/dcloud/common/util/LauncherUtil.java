package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class LauncherUtil {
    public static java.lang.String getAuthorityFromPermission(android.content.Context context, java.lang.String str) {
        android.text.TextUtils.isEmpty(str);
        return "";
    }

    public static java.lang.String getAuthorityFromPermissionDefault(android.content.Context context) {
        java.lang.String authorityFromPermission = getAuthorityFromPermission(context, "com.android.launcher.permission.READ_SETTINGS");
        return android.text.TextUtils.isEmpty(authorityFromPermission) ? getAuthorityFromPermission(context, "com.android.launcher3.permission.READ_SETTINGS") : authorityFromPermission;
    }

    public static java.lang.String getLauncherPackageName(android.content.Context context) {
        android.content.pm.ActivityInfo activityInfo;
        android.content.Context applicationContext = context.getApplicationContext();
        android.content.Intent intent = new android.content.Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        android.content.pm.ResolveInfo resolveInfoResolveActivity = applicationContext.getPackageManager().resolveActivity(intent, 0);
        return (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null || activityInfo.packageName.equals(com.taobao.weex.WXEnvironment.OS)) ? "" : resolveInfoResolveActivity.activityInfo.packageName;
    }
}
