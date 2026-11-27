package com.dcloud.android.v4.view.accessibility;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class AccessibilityNodeProviderCompat {
    private static final com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl IMPL = new com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderKitKatImpl();
    private final java.lang.Object mProvider;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    interface AccessibilityNodeProviderImpl {
        java.lang.Object newAccessibilityNodeProviderBridge(com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat accessibilityNodeProviderCompat);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class AccessibilityNodeProviderJellyBeanImpl extends com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl {
        AccessibilityNodeProviderJellyBeanImpl() {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl
        public java.lang.Object newAccessibilityNodeProviderBridge(final com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.newAccessibilityNodeProviderBridge(new com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge() { // from class: com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderJellyBeanImpl.1
                @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge
                public java.lang.Object createAccessibilityNodeInfo(int i) {
                    com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompatCreateAccessibilityNodeInfo = accessibilityNodeProviderCompat.createAccessibilityNodeInfo(i);
                    if (accessibilityNodeInfoCompatCreateAccessibilityNodeInfo == null) {
                        return null;
                    }
                    return accessibilityNodeInfoCompatCreateAccessibilityNodeInfo.getInfo();
                }

                @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge
                public java.util.List<java.lang.Object> findAccessibilityNodeInfosByText(java.lang.String str, int i) {
                    java.util.List<com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat> listFindAccessibilityNodeInfosByText = accessibilityNodeProviderCompat.findAccessibilityNodeInfosByText(str, i);
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    int size = listFindAccessibilityNodeInfosByText.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(listFindAccessibilityNodeInfosByText.get(i2).getInfo());
                    }
                    return arrayList;
                }

                @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge
                public boolean performAction(int i, int i2, android.os.Bundle bundle) {
                    return accessibilityNodeProviderCompat.performAction(i, i2, bundle);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class AccessibilityNodeProviderKitKatImpl extends com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl {
        AccessibilityNodeProviderKitKatImpl() {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl, com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl
        public java.lang.Object newAccessibilityNodeProviderBridge(final com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.newAccessibilityNodeProviderBridge(new com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge() { // from class: com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderKitKatImpl.1
                @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge
                public java.lang.Object createAccessibilityNodeInfo(int i) {
                    com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompatCreateAccessibilityNodeInfo = accessibilityNodeProviderCompat.createAccessibilityNodeInfo(i);
                    if (accessibilityNodeInfoCompatCreateAccessibilityNodeInfo == null) {
                        return null;
                    }
                    return accessibilityNodeInfoCompatCreateAccessibilityNodeInfo.getInfo();
                }

                @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge
                public java.util.List<java.lang.Object> findAccessibilityNodeInfosByText(java.lang.String str, int i) {
                    java.util.List<com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat> listFindAccessibilityNodeInfosByText = accessibilityNodeProviderCompat.findAccessibilityNodeInfosByText(str, i);
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    int size = listFindAccessibilityNodeInfosByText.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(listFindAccessibilityNodeInfosByText.get(i2).getInfo());
                    }
                    return arrayList;
                }

                @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge
                public java.lang.Object findFocus(int i) {
                    com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompatFindFocus = accessibilityNodeProviderCompat.findFocus(i);
                    if (accessibilityNodeInfoCompatFindFocus == null) {
                        return null;
                    }
                    return accessibilityNodeInfoCompatFindFocus.getInfo();
                }

                @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge
                public boolean performAction(int i, int i2, android.os.Bundle bundle) {
                    return accessibilityNodeProviderCompat.performAction(i, i2, bundle);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class AccessibilityNodeProviderStubImpl implements com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl {
        AccessibilityNodeProviderStubImpl() {
        }

        @Override // com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl
        public java.lang.Object newAccessibilityNodeProviderBridge(com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return null;
        }
    }

    public AccessibilityNodeProviderCompat() {
        this.mProvider = IMPL.newAccessibilityNodeProviderBridge(this);
    }

    public com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
        return null;
    }

    public java.util.List<com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(java.lang.String str, int i) {
        return null;
    }

    public com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat findFocus(int i) {
        return null;
    }

    public java.lang.Object getProvider() {
        return this.mProvider;
    }

    public boolean performAction(int i, int i2, android.os.Bundle bundle) {
        return false;
    }

    public AccessibilityNodeProviderCompat(java.lang.Object obj) {
        this.mProvider = obj;
    }
}
