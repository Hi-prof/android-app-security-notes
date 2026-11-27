package com.dcloud.android.v4.view.accessibility;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class AccessibilityNodeInfoCompatJellyBean {
    AccessibilityNodeInfoCompatJellyBean() {
    }

    public static void addChild(java.lang.Object obj, android.view.View view, int i) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).addChild(view, i);
    }

    public static java.lang.Object findFocus(java.lang.Object obj, int i) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).findFocus(i);
    }

    public static java.lang.Object focusSearch(java.lang.Object obj, int i) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).focusSearch(i);
    }

    public static int getMovementGranularities(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getMovementGranularities();
    }

    public static boolean isAccessibilityFocused(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).isAccessibilityFocused();
    }

    public static boolean isVisibleToUser(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).isVisibleToUser();
    }

    public static java.lang.Object obtain(android.view.View view, int i) {
        return android.view.accessibility.AccessibilityNodeInfo.obtain(view, i);
    }

    public static boolean performAction(java.lang.Object obj, int i, android.os.Bundle bundle) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).performAction(i, bundle);
    }

    public static void setAccesibilityFocused(java.lang.Object obj, boolean z) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setAccessibilityFocused(z);
    }

    public static void setMovementGranularities(java.lang.Object obj, int i) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setMovementGranularities(i);
    }

    public static void setParent(java.lang.Object obj, android.view.View view, int i) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setParent(view, i);
    }

    public static void setSource(java.lang.Object obj, android.view.View view, int i) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setSource(view, i);
    }

    public static void setVisibleToUser(java.lang.Object obj, boolean z) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setVisibleToUser(z);
    }
}
