package com.dcloud.android.v4.accessibilityservice;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class AccessibilityServiceInfoCompatIcs {
    AccessibilityServiceInfoCompatIcs() {
    }

    public static boolean getCanRetrieveWindowContent(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
        return accessibilityServiceInfo.getCanRetrieveWindowContent();
    }

    public static java.lang.String getDescription(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
        return accessibilityServiceInfo.getDescription();
    }

    public static java.lang.String getId(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
        return accessibilityServiceInfo.getId();
    }

    public static android.content.pm.ResolveInfo getResolveInfo(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
        return accessibilityServiceInfo.getResolveInfo();
    }

    public static java.lang.String getSettingsActivityName(android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo) {
        return accessibilityServiceInfo.getSettingsActivityName();
    }
}
