package com.dcloud.android.v4.view.accessibility;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class AccessibilityWindowInfoCompatApi21 {
    AccessibilityWindowInfoCompatApi21() {
    }

    public static void getBoundsInScreen(java.lang.Object obj, android.graphics.Rect rect) {
        ((android.view.accessibility.AccessibilityWindowInfo) obj).getBoundsInScreen(rect);
    }

    public static java.lang.Object getChild(java.lang.Object obj, int i) {
        return ((android.view.accessibility.AccessibilityWindowInfo) obj).getChild(i);
    }

    public static int getChildCount(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityWindowInfo) obj).getChildCount();
    }

    public static int getId(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityWindowInfo) obj).getId();
    }

    public static int getLayer(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityWindowInfo) obj).getLayer();
    }

    public static java.lang.Object getParent(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityWindowInfo) obj).getParent();
    }

    public static java.lang.Object getRoot(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityWindowInfo) obj).getRoot();
    }

    public static int getType(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityWindowInfo) obj).getType();
    }

    public static boolean isAccessibilityFocused(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityWindowInfo) obj).isAccessibilityFocused();
    }

    public static boolean isActive(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityWindowInfo) obj).isActive();
    }

    public static boolean isFocused(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityWindowInfo) obj).isFocused();
    }

    public static java.lang.Object obtain() {
        return android.view.accessibility.AccessibilityWindowInfo.obtain();
    }

    public static void recycle(java.lang.Object obj) {
        ((android.view.accessibility.AccessibilityWindowInfo) obj).recycle();
    }

    public static java.lang.Object obtain(java.lang.Object obj) {
        return android.view.accessibility.AccessibilityWindowInfo.obtain((android.view.accessibility.AccessibilityWindowInfo) obj);
    }
}
