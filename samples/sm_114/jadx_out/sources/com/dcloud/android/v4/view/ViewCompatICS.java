package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class ViewCompatICS {
    ViewCompatICS() {
    }

    public static boolean canScrollHorizontally(android.view.View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static boolean canScrollVertically(android.view.View view, int i) {
        return view.canScrollVertically(i);
    }

    public static void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(android.view.View view, java.lang.Object obj) {
        view.onInitializeAccessibilityNodeInfo((android.view.accessibility.AccessibilityNodeInfo) obj);
    }

    public static void onPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    public static void setAccessibilityDelegate(android.view.View view, java.lang.Object obj) {
        view.setAccessibilityDelegate((android.view.View.AccessibilityDelegate) obj);
    }

    public static void setFitsSystemWindows(android.view.View view, boolean z) {
        view.setFitsSystemWindows(z);
    }
}
