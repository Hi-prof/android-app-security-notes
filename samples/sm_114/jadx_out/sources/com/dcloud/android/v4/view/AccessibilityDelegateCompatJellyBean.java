package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class AccessibilityDelegateCompatJellyBean {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface AccessibilityDelegateBridgeJellyBean {
        boolean dispatchPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent);

        java.lang.Object getAccessibilityNodeProvider(android.view.View view);

        void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(android.view.View view, java.lang.Object obj);

        void onPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent);

        boolean onRequestSendAccessibilityEvent(android.view.ViewGroup viewGroup, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent);

        boolean performAccessibilityAction(android.view.View view, int i, android.os.Bundle bundle);

        void sendAccessibilityEvent(android.view.View view, int i);

        void sendAccessibilityEventUnchecked(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent);
    }

    AccessibilityDelegateCompatJellyBean() {
    }

    public static java.lang.Object getAccessibilityNodeProvider(java.lang.Object obj, android.view.View view) {
        return ((android.view.View.AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    public static java.lang.Object newAccessibilityDelegateBridge(final com.dcloud.android.v4.view.AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean accessibilityDelegateBridgeJellyBean) {
        return new android.view.View.AccessibilityDelegate() { // from class: com.dcloud.android.v4.view.AccessibilityDelegateCompatJellyBean.1
            @Override // android.view.View.AccessibilityDelegate
            public boolean dispatchPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                return accessibilityDelegateBridgeJellyBean.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public android.view.accessibility.AccessibilityNodeProvider getAccessibilityNodeProvider(android.view.View view) {
                return (android.view.accessibility.AccessibilityNodeProvider) accessibilityDelegateBridgeJellyBean.getAccessibilityNodeProvider(view);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                accessibilityDelegateBridgeJellyBean.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(android.view.View view, android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
                accessibilityDelegateBridgeJellyBean.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                accessibilityDelegateBridgeJellyBean.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public boolean onRequestSendAccessibilityEvent(android.view.ViewGroup viewGroup, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                return accessibilityDelegateBridgeJellyBean.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public boolean performAccessibilityAction(android.view.View view, int i, android.os.Bundle bundle) {
                return accessibilityDelegateBridgeJellyBean.performAccessibilityAction(view, i, bundle);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(android.view.View view, int i) {
                accessibilityDelegateBridgeJellyBean.sendAccessibilityEvent(view, i);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEventUnchecked(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                accessibilityDelegateBridgeJellyBean.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        };
    }

    public static boolean performAccessibilityAction(java.lang.Object obj, android.view.View view, int i, android.os.Bundle bundle) {
        return ((android.view.View.AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
