package com.dcloud.android.v4.view.accessibility;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class AccessibilityNodeInfoCompatJellybeanMr2 {
    AccessibilityNodeInfoCompatJellybeanMr2() {
    }

    public static java.util.List<java.lang.Object> findAccessibilityNodeInfosByViewId(java.lang.Object obj, java.lang.String str) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).findAccessibilityNodeInfosByViewId(str);
    }

    public static int getTextSelectionEnd(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getTextSelectionEnd();
    }

    public static int getTextSelectionStart(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getTextSelectionStart();
    }

    public static java.lang.String getViewIdResourceName(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getViewIdResourceName();
    }

    public static boolean isEditable(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).isEditable();
    }

    public static boolean refresh(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).refresh();
    }

    public static void setEditable(java.lang.Object obj, boolean z) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setEditable(z);
    }

    public static void setTextSelection(java.lang.Object obj, int i, int i2) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setTextSelection(i, i2);
    }

    public static void setViewIdResourceName(java.lang.Object obj, java.lang.String str) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setViewIdResourceName(str);
    }
}
