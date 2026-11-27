package com.dcloud.android.v4.view.accessibility;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class AccessibilityNodeInfoCompatApi21 {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class CollectionItemInfo {
        CollectionItemInfo() {
        }

        public static boolean isSelected(java.lang.Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) obj).isSelected();
        }
    }

    AccessibilityNodeInfoCompatApi21() {
    }

    static void addAction(java.lang.Object obj, java.lang.Object obj2) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).addAction((android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction) obj2);
    }

    static int getAccessibilityActionId(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction) obj).getId();
    }

    static java.lang.CharSequence getAccessibilityActionLabel(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction) obj).getLabel();
    }

    static java.util.List<java.lang.Object> getActionList(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getActionList();
    }

    public static java.lang.CharSequence getError(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getError();
    }

    public static int getMaxTextLength(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getMaxTextLength();
    }

    public static java.lang.Object getWindow(java.lang.Object obj) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).getWindow();
    }

    static java.lang.Object newAccessibilityAction(int i, java.lang.CharSequence charSequence) {
        return new android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
    }

    public static java.lang.Object obtainCollectionInfo(int i, int i2, boolean z, int i3) {
        return android.view.accessibility.AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3);
    }

    public static java.lang.Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2);
    }

    public static boolean removeAction(java.lang.Object obj, java.lang.Object obj2) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).removeAction((android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction) obj2);
    }

    public static boolean removeChild(java.lang.Object obj, android.view.View view) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).removeChild(view);
    }

    public static void setError(java.lang.Object obj, java.lang.CharSequence charSequence) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setError(charSequence);
    }

    public static void setMaxTextLength(java.lang.Object obj, int i) {
        ((android.view.accessibility.AccessibilityNodeInfo) obj).setMaxTextLength(i);
    }

    public static boolean removeChild(java.lang.Object obj, android.view.View view, int i) {
        return ((android.view.accessibility.AccessibilityNodeInfo) obj).removeChild(view, i);
    }
}
