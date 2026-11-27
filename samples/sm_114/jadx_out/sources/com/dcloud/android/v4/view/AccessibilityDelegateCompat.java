package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class AccessibilityDelegateCompat {
    private static final java.lang.Object DEFAULT_DELEGATE;
    private static final com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl IMPL;
    final java.lang.Object mBridge = IMPL.newAccessiblityDelegateBridge(this);

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class AccessibilityDelegateIcsImpl extends com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl {
        AccessibilityDelegateIcsImpl() {
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public boolean dispatchPopulateAccessibilityEvent(java.lang.Object obj, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            return com.dcloud.android.v4.view.AccessibilityDelegateCompatIcs.dispatchPopulateAccessibilityEvent(obj, view, accessibilityEvent);
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public java.lang.Object newAccessiblityDelegateBridge(final com.dcloud.android.v4.view.AccessibilityDelegateCompat accessibilityDelegateCompat) {
            return com.dcloud.android.v4.view.AccessibilityDelegateCompatIcs.newAccessibilityDelegateBridge(new com.dcloud.android.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge() { // from class: com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateIcsImpl.1
                @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public boolean dispatchPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.onInitializeAccessibilityEvent(view, accessibilityEvent);
                }

                @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public void onInitializeAccessibilityNodeInfo(android.view.View view, java.lang.Object obj) {
                    accessibilityDelegateCompat.onInitializeAccessibilityNodeInfo(view, new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat(obj));
                }

                @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public void onPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.onPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public boolean onRequestSendAccessibilityEvent(android.view.ViewGroup viewGroup, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }

                @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public void sendAccessibilityEvent(android.view.View view, int i) {
                    accessibilityDelegateCompat.sendAccessibilityEvent(view, i);
                }

                @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public void sendAccessibilityEventUnchecked(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.sendAccessibilityEventUnchecked(view, accessibilityEvent);
                }
            });
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public java.lang.Object newAccessiblityDelegateDefaultImpl() {
            return com.dcloud.android.v4.view.AccessibilityDelegateCompatIcs.newAccessibilityDelegateDefaultImpl();
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void onInitializeAccessibilityEvent(java.lang.Object obj, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            com.dcloud.android.v4.view.AccessibilityDelegateCompatIcs.onInitializeAccessibilityEvent(obj, view, accessibilityEvent);
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void onInitializeAccessibilityNodeInfo(java.lang.Object obj, android.view.View view, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            com.dcloud.android.v4.view.AccessibilityDelegateCompatIcs.onInitializeAccessibilityNodeInfo(obj, view, accessibilityNodeInfoCompat.getInfo());
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void onPopulateAccessibilityEvent(java.lang.Object obj, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            com.dcloud.android.v4.view.AccessibilityDelegateCompatIcs.onPopulateAccessibilityEvent(obj, view, accessibilityEvent);
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public boolean onRequestSendAccessibilityEvent(java.lang.Object obj, android.view.ViewGroup viewGroup, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            return com.dcloud.android.v4.view.AccessibilityDelegateCompatIcs.onRequestSendAccessibilityEvent(obj, viewGroup, view, accessibilityEvent);
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void sendAccessibilityEvent(java.lang.Object obj, android.view.View view, int i) {
            com.dcloud.android.v4.view.AccessibilityDelegateCompatIcs.sendAccessibilityEvent(obj, view, i);
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void sendAccessibilityEventUnchecked(java.lang.Object obj, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            com.dcloud.android.v4.view.AccessibilityDelegateCompatIcs.sendAccessibilityEventUnchecked(obj, view, accessibilityEvent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    interface AccessibilityDelegateImpl {
        boolean dispatchPopulateAccessibilityEvent(java.lang.Object obj, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent);

        com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat getAccessibilityNodeProvider(java.lang.Object obj, android.view.View view);

        java.lang.Object newAccessiblityDelegateBridge(com.dcloud.android.v4.view.AccessibilityDelegateCompat accessibilityDelegateCompat);

        java.lang.Object newAccessiblityDelegateDefaultImpl();

        void onInitializeAccessibilityEvent(java.lang.Object obj, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(java.lang.Object obj, android.view.View view, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

        void onPopulateAccessibilityEvent(java.lang.Object obj, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent);

        boolean onRequestSendAccessibilityEvent(java.lang.Object obj, android.view.ViewGroup viewGroup, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent);

        boolean performAccessibilityAction(java.lang.Object obj, android.view.View view, int i, android.os.Bundle bundle);

        void sendAccessibilityEvent(java.lang.Object obj, android.view.View view, int i);

        void sendAccessibilityEventUnchecked(java.lang.Object obj, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class AccessibilityDelegateJellyBeanImpl extends com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateIcsImpl {
        AccessibilityDelegateJellyBeanImpl() {
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat getAccessibilityNodeProvider(java.lang.Object obj, android.view.View view) {
            java.lang.Object accessibilityNodeProvider = com.dcloud.android.v4.view.AccessibilityDelegateCompatJellyBean.getAccessibilityNodeProvider(obj, view);
            if (accessibilityNodeProvider != null) {
                return new com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat(accessibilityNodeProvider);
            }
            return null;
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateIcsImpl, com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public java.lang.Object newAccessiblityDelegateBridge(final com.dcloud.android.v4.view.AccessibilityDelegateCompat accessibilityDelegateCompat) {
            return com.dcloud.android.v4.view.AccessibilityDelegateCompatJellyBean.newAccessibilityDelegateBridge(new com.dcloud.android.v4.view.AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean() { // from class: com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateJellyBeanImpl.1
                @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean
                public boolean dispatchPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean
                public java.lang.Object getAccessibilityNodeProvider(android.view.View view) {
                    com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat accessibilityNodeProvider = accessibilityDelegateCompat.getAccessibilityNodeProvider(view);
                    if (accessibilityNodeProvider != null) {
                        return accessibilityNodeProvider.getProvider();
                    }
                    return null;
                }

                @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean
                public void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.onInitializeAccessibilityEvent(view, accessibilityEvent);
                }

                @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean
                public void onInitializeAccessibilityNodeInfo(android.view.View view, java.lang.Object obj) {
                    accessibilityDelegateCompat.onInitializeAccessibilityNodeInfo(view, new com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat(obj));
                }

                @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean
                public void onPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.onPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean
                public boolean onRequestSendAccessibilityEvent(android.view.ViewGroup viewGroup, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }

                @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean
                public boolean performAccessibilityAction(android.view.View view, int i, android.os.Bundle bundle) {
                    return accessibilityDelegateCompat.performAccessibilityAction(view, i, bundle);
                }

                @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean
                public void sendAccessibilityEvent(android.view.View view, int i) {
                    accessibilityDelegateCompat.sendAccessibilityEvent(view, i);
                }

                @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean
                public void sendAccessibilityEventUnchecked(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.sendAccessibilityEventUnchecked(view, accessibilityEvent);
                }
            });
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public boolean performAccessibilityAction(java.lang.Object obj, android.view.View view, int i, android.os.Bundle bundle) {
            return com.dcloud.android.v4.view.AccessibilityDelegateCompatJellyBean.performAccessibilityAction(obj, view, i, bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class AccessibilityDelegateStubImpl implements com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl {
        AccessibilityDelegateStubImpl() {
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public boolean dispatchPopulateAccessibilityEvent(java.lang.Object obj, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat getAccessibilityNodeProvider(java.lang.Object obj, android.view.View view) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public java.lang.Object newAccessiblityDelegateBridge(com.dcloud.android.v4.view.AccessibilityDelegateCompat accessibilityDelegateCompat) {
            return null;
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public java.lang.Object newAccessiblityDelegateDefaultImpl() {
            return null;
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void onInitializeAccessibilityEvent(java.lang.Object obj, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void onInitializeAccessibilityNodeInfo(java.lang.Object obj, android.view.View view, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void onPopulateAccessibilityEvent(java.lang.Object obj, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public boolean onRequestSendAccessibilityEvent(java.lang.Object obj, android.view.ViewGroup viewGroup, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            return true;
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public boolean performAccessibilityAction(java.lang.Object obj, android.view.View view, int i, android.os.Bundle bundle) {
            return false;
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void sendAccessibilityEvent(java.lang.Object obj, android.view.View view, int i) {
        }

        @Override // com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void sendAccessibilityEventUnchecked(java.lang.Object obj, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return IMPL.dispatchPopulateAccessibilityEvent(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    public com.dcloud.android.v4.view.accessibility.AccessibilityNodeProviderCompat getAccessibilityNodeProvider(android.view.View view) {
        return IMPL.getAccessibilityNodeProvider(DEFAULT_DELEGATE, view);
    }

    java.lang.Object getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        IMPL.onInitializeAccessibilityEvent(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(android.view.View view, com.dcloud.android.v4.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        IMPL.onInitializeAccessibilityNodeInfo(DEFAULT_DELEGATE, view, accessibilityNodeInfoCompat);
    }

    public void onPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        IMPL.onPopulateAccessibilityEvent(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(android.view.ViewGroup viewGroup, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return IMPL.onRequestSendAccessibilityEvent(DEFAULT_DELEGATE, viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(android.view.View view, int i, android.os.Bundle bundle) {
        return IMPL.performAccessibilityAction(DEFAULT_DELEGATE, view, i, bundle);
    }

    public void sendAccessibilityEvent(android.view.View view, int i) {
        IMPL.sendAccessibilityEvent(DEFAULT_DELEGATE, view, i);
    }

    public void sendAccessibilityEventUnchecked(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        IMPL.sendAccessibilityEventUnchecked(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    static {
        com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateJellyBeanImpl accessibilityDelegateJellyBeanImpl = new com.dcloud.android.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateJellyBeanImpl();
        IMPL = accessibilityDelegateJellyBeanImpl;
        DEFAULT_DELEGATE = accessibilityDelegateJellyBeanImpl.newAccessiblityDelegateDefaultImpl();
    }
}
