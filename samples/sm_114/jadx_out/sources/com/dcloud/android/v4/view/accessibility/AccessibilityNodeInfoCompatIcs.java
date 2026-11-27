package com.dcloud.android.v4.view.accessibility;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class AccessibilityNodeInfoCompatIcs {
    AccessibilityNodeInfoCompatIcs() {
    }

    public static void addAction(java.lang.Object obj, int i) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).addAction(i);
    }

    public static void addChild(java.lang.Object obj, android.view.View view) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).addChild(view);
    }

    public static java.util.List<java.lang.Object> findAccessibilityNodeInfosByText(java.lang.Object obj, java.lang.String str) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).findAccessibilityNodeInfosByText(str);
    }

    public static int getActions(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getActions();
    }

    public static void getBoundsInParent(java.lang.Object obj, android.graphics.Rect rect) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).getBoundsInParent(rect);
    }

    public static void getBoundsInScreen(java.lang.Object obj, android.graphics.Rect rect) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).getBoundsInScreen(rect);
    }

    public static java.lang.Object getChild(java.lang.Object obj, int i) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getChild(i);
    }

    public static int getChildCount(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getChildCount();
    }

    public static java.lang.CharSequence getClassName(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getClassName();
    }

    public static java.lang.CharSequence getContentDescription(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getContentDescription();
    }

    public static java.lang.CharSequence getPackageName(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getPackageName();
    }

    public static java.lang.Object getParent(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getParent();
    }

    public static java.lang.CharSequence getText(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getText();
    }

    public static int getWindowId(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getWindowId();
    }

    public static boolean isCheckable(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).isCheckable();
    }

    public static boolean isChecked(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).isChecked();
    }

    public static boolean isClickable(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).isClickable();
    }

    public static boolean isEnabled(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).isEnabled();
    }

    public static boolean isFocusable(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).isFocusable();
    }

    public static boolean isFocused(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).isFocused();
    }

    public static boolean isLongClickable(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).isLongClickable();
    }

    public static boolean isPassword(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).isPassword();
    }

    public static boolean isScrollable(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).isScrollable();
    }

    public static boolean isSelected(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).isSelected();
    }

    public static java.lang.Object obtain() {
        return android.view.accessibility.AccessibilityNodeInfo.obtain();
    }

    public static boolean performAction(java.lang.Object obj, int i) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).performAction(i);
    }

    public static void recycle(java.lang.Object obj) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).recycle();
    }

    public static void setBoundsInParent(java.lang.Object obj, android.graphics.Rect rect) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setBoundsInParent(rect);
    }

    public static void setBoundsInScreen(java.lang.Object obj, android.graphics.Rect rect) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setBoundsInScreen(rect);
    }

    public static void setCheckable(java.lang.Object obj, boolean z) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setCheckable(z);
    }

    public static void setChecked(java.lang.Object obj, boolean z) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setChecked(z);
    }

    public static void setClassName(java.lang.Object obj, java.lang.CharSequence charSequence) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setClassName(charSequence);
    }

    public static void setClickable(java.lang.Object obj, boolean z) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setClickable(z);
    }

    public static void setContentDescription(java.lang.Object obj, java.lang.CharSequence charSequence) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setContentDescription(charSequence);
    }

    public static void setEnabled(java.lang.Object obj, boolean z) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setEnabled(z);
    }

    public static void setFocusable(java.lang.Object obj, boolean z) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setFocusable(z);
    }

    public static void setFocused(java.lang.Object obj, boolean z) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setFocused(z);
    }

    public static void setLongClickable(java.lang.Object obj, boolean z) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setLongClickable(z);
    }

    public static void setPackageName(java.lang.Object obj, java.lang.CharSequence charSequence) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setPackageName(charSequence);
    }

    public static void setParent(java.lang.Object obj, android.view.View view) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setParent(view);
    }

    public static void setPassword(java.lang.Object obj, boolean z) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setPassword(z);
    }

    public static void setScrollable(java.lang.Object obj, boolean z) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setScrollable(z);
    }

    public static void setSelected(java.lang.Object obj, boolean z) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setSelected(z);
    }

    public static void setSource(java.lang.Object obj, android.view.View view) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setSource(view);
    }

    public static void setText(java.lang.Object obj, java.lang.CharSequence charSequence) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setText(charSequence);
    }

    public static java.lang.Object obtain(android.view.View view) {
        return android.view.accessibility.AccessibilityNodeInfo.obtain(view);
    }

    public static java.lang.Object obtain(java.lang.Object obj) {
        return android.view.accessibility.AccessibilityNodeInfo.obtain((android.view.accessibility.AccessibilityNodeInfo) obj);
    }
}
