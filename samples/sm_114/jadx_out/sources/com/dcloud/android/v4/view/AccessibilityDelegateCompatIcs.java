package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class AccessibilityDelegateCompatIcs {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface AccessibilityDelegateBridge {
        boolean dispatchPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(android.view.View view, java.lang.Object obj);

        void onPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent);

        boolean onRequestSendAccessibilityEvent(android.view.ViewGroup viewGroup, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent);

        void sendAccessibilityEvent(android.view.View view, int i);

        void sendAccessibilityEventUnchecked(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent);
    }

    AccessibilityDelegateCompatIcs() {
    }

    public static boolean dispatchPopulateAccessibilityEvent(java.lang.Object obj, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return ((android.view.View.AccessibilityDelegate) obj).dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static java.lang.Object newAccessibilityDelegateBridge(final com.dcloud.android.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge accessibilityDelegateBridge) {
        return new android.view.View.AccessibilityDelegate() { // from class: com.dcloud.android.v4.view.AccessibilityDelegateCompatIcs.1
            @Override // android.view.View.AccessibilityDelegate
            public boolean dispatchPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                return accessibilityDelegateBridge.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                accessibilityDelegateBridge.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(android.view.View view, android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
                accessibilityDelegateBridge.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                accessibilityDelegateBridge.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public boolean onRequestSendAccessibilityEvent(android.view.ViewGroup viewGroup, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                return accessibilityDelegateBridge.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(android.view.View view, int i) {
                accessibilityDelegateBridge.sendAccessibilityEvent(view, i);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEventUnchecked(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                accessibilityDelegateBridge.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        };
    }

    public static java.lang.Object newAccessibilityDelegateDefaultImpl() {
        return new android.view.View.AccessibilityDelegate();
    }

    public static void onInitializeAccessibilityEvent(java.lang.Object obj, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        ((android.view.View.AccessibilityDelegate) obj).onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(java.lang.Object obj, android.view.View view, java.lang.Object obj2) {
        ((android.view.View.AccessibilityDelegate) obj).onInitializeAccessibilityNodeInfo(view, (android.view.accessibility.AccessibilityNodeInfo) obj2);
    }

    public static void onPopulateAccessibilityEvent(java.lang.Object obj, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        ((android.view.View.AccessibilityDelegate) obj).onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static boolean onRequestSendAccessibilityEvent(java.lang.Object obj, android.view.ViewGroup viewGroup, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return ((android.view.View.AccessibilityDelegate) obj).onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public static void sendAccessibilityEvent(java.lang.Object obj, android.view.View view, int i) {
        ((android.view.View.AccessibilityDelegate) obj).sendAccessibilityEvent(view, i);
    }

    public static void sendAccessibilityEventUnchecked(java.lang.Object obj, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        ((android.view.View.AccessibilityDelegate) obj).sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
