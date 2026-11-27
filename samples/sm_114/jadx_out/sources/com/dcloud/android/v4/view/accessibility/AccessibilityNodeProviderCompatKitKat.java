package com.dcloud.android.v4.view.accessibility;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class AccessibilityNodeProviderCompatKitKat {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    interface AccessibilityNodeInfoBridge {
        java.lang.Object createAccessibilityNodeInfo(int i);

        java.util.List<java.lang.Object> findAccessibilityNodeInfosByText(java.lang.String str, int i);

        java.lang.Object findFocus(int i);

        boolean performAction(int i, int i2, android.os.Bundle bundle);
    }

    AccessibilityNodeProviderCompatKitKat() {
    }

    public static java.lang.Object newAccessibilityNodeProviderBridge(final com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge accessibilityNodeInfoBridge) {
        return new android.view.accessibility.AccessibilityNodeProvider() { // from class: com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.1
            @Override // android.view.accessibility.AccessibilityNodeProvider
            public android.view.accessibility.AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (android.view.accessibility.AccessibilityNodeInfo) accessibilityNodeInfoBridge.createAccessibilityNodeInfo(i);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public java.util.List<android.view.accessibility.AccessibilityNodeInfo> findAccessibilityNodeInfosByText(java.lang.String str, int i) {
                return accessibilityNodeInfoBridge.findAccessibilityNodeInfosByText(str, i);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public android.view.accessibility.AccessibilityNodeInfo findFocus(int i) {
                return (android.view.accessibility.AccessibilityNodeInfo) accessibilityNodeInfoBridge.findFocus(i);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public boolean performAction(int i, int i2, android.os.Bundle bundle) {
                return accessibilityNodeInfoBridge.performAction(i, i2, bundle);
            }
        };
    }
}
