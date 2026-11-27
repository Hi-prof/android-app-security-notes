package com.dcloud.android.v4.view.accessibility;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class AccessibilityNodeInfoCompatJellybeanMr1 {
    AccessibilityNodeInfoCompatJellybeanMr1() {
    }

    public static java.lang.Object getLabelFor(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getLabelFor();
    }

    public static java.lang.Object getLabeledBy(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getLabeledBy();
    }

    public static void setLabelFor(java.lang.Object obj, android.view.View view) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setLabelFor(view);
    }

    public static void setLabeledBy(java.lang.Object obj, android.view.View view) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setLabeledBy(view);
    }

    public static void setLabelFor(java.lang.Object obj, android.view.View view, int i) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setLabelFor(view, i);
    }

    public static void setLabeledBy(java.lang.Object obj, android.view.View view, int i) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setLabeledBy(view, i);
    }
}
