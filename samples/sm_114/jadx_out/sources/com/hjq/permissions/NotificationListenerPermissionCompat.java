package com.hjq.permissions;

/* JADX INFO: loaded from: classes.dex */
final class NotificationListenerPermissionCompat {
    private static final java.lang.String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";

    NotificationListenerPermissionCompat() {
    }

    static boolean isGrantedPermission(android.content.Context context) {
        if (!com.hjq.permissions.AndroidVersion.isAndroid4_3()) {
            return true;
        }
        java.lang.String string = android.provider.Settings.Secure.getString(context.getContentResolver(), SETTING_ENABLED_NOTIFICATION_LISTENERS);
        if (android.text.TextUtils.isEmpty(string)) {
            return false;
        }
        for (java.lang.String str : string.split(":")) {
            android.content.ComponentName componentNameUnflattenFromString = android.content.ComponentName.unflattenFromString(str);
            if (componentNameUnflattenFromString != null && android.text.TextUtils.equals(componentNameUnflattenFromString.getPackageName(), context.getPackageName())) {
                try {
                    java.lang.Class.forName(componentNameUnflattenFromString.getClassName());
                    return true;
                } catch (java.lang.ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    static android.content.Intent getPermissionIntent(android.content.Context context) {
        android.content.Intent intent;
        com.hjq.permissions.AndroidManifestInfo.ServiceInfo serviceInfo;
        android.content.Intent intent2 = null;
        if (com.hjq.permissions.AndroidVersion.isAndroid11()) {
            com.hjq.permissions.AndroidManifestInfo androidManifestInfo = com.hjq.permissions.PermissionUtils.getAndroidManifestInfo(context);
            if (androidManifestInfo == null) {
                serviceInfo = null;
                break;
            }
            serviceInfo = null;
            for (com.hjq.permissions.AndroidManifestInfo.ServiceInfo serviceInfo2 : androidManifestInfo.serviceInfoList) {
                if (android.text.TextUtils.equals(serviceInfo2.permission, com.hjq.permissions.Permission.BIND_NOTIFICATION_LISTENER_SERVICE)) {
                    if (serviceInfo != null) {
                        serviceInfo = null;
                        break;
                    }
                    serviceInfo = serviceInfo2;
                }
            }
            if (serviceInfo != null) {
                android.content.Intent intent3 = new android.content.Intent("android.settings.NOTIFICATION_LISTENER_DETAIL_SETTINGS");
                intent3.putExtra("android.provider.extra.NOTIFICATION_LISTENER_COMPONENT_NAME", new android.content.ComponentName(context, serviceInfo.name).flattenToString());
                if (com.hjq.permissions.PermissionUtils.areActivityIntent(context, intent3)) {
                    intent2 = intent3;
                }
            }
        }
        if (intent2 == null) {
            if (com.hjq.permissions.AndroidVersion.isAndroid5_1()) {
                intent = new android.content.Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            } else {
                intent = new android.content.Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            }
            intent2 = intent;
        }
        return !com.hjq.permissions.PermissionUtils.areActivityIntent(context, intent2) ? com.hjq.permissions.PermissionIntentManager.getApplicationDetailsIntent(context) : intent2;
    }
}
