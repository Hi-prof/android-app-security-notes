package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class ViewParentCompat {
    static final com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl IMPL = new com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatLollipopImpl();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class ViewParentCompatICSImpl extends com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatStubImpl {
        ViewParentCompatICSImpl() {
        }

        @Override // com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatStubImpl, com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl
        public boolean requestSendAccessibilityEvent(android.view.ViewParent viewParent, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            return com.dcloud.android.v4.view.ViewParentCompatICS.requestSendAccessibilityEvent(viewParent, view, accessibilityEvent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    interface ViewParentCompatImpl {
        void notifySubtreeAccessibilityStateChanged(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i);

        boolean onNestedFling(android.view.ViewParent viewParent, android.view.View view, float f, float f2, boolean z);

        boolean onNestedPreFling(android.view.ViewParent viewParent, android.view.View view, float f, float f2);

        void onNestedPreScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int[] iArr);

        void onNestedScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int i3, int i4);

        void onNestedScrollAccepted(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i);

        boolean onStartNestedScroll(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i);

        void onStopNestedScroll(android.view.ViewParent viewParent, android.view.View view);

        boolean requestSendAccessibilityEvent(android.view.ViewParent viewParent, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class ViewParentCompatKitKatImpl extends com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatICSImpl {
        ViewParentCompatKitKatImpl() {
        }

        @Override // com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatStubImpl, com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void notifySubtreeAccessibilityStateChanged(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
            com.dcloud.android.v4.view.ViewParentCompatKitKat.notifySubtreeAccessibilityStateChanged(viewParent, view, view2, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class ViewParentCompatLollipopImpl extends com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatKitKatImpl {
        ViewParentCompatLollipopImpl() {
        }

        @Override // com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatStubImpl, com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl
        public boolean onNestedFling(android.view.ViewParent viewParent, android.view.View view, float f, float f2, boolean z) {
            return com.dcloud.android.v4.view.ViewParentCompatLollipop.onNestedFling(viewParent, view, f, f2, z);
        }

        @Override // com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatStubImpl, com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl
        public boolean onNestedPreFling(android.view.ViewParent viewParent, android.view.View view, float f, float f2) {
            return com.dcloud.android.v4.view.ViewParentCompatLollipop.onNestedPreFling(viewParent, view, f, f2);
        }

        @Override // com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatStubImpl, com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void onNestedPreScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int[] iArr) {
            com.dcloud.android.v4.view.ViewParentCompatLollipop.onNestedPreScroll(viewParent, view, i, i2, iArr);
        }

        @Override // com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatStubImpl, com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void onNestedScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int i3, int i4) {
            com.dcloud.android.v4.view.ViewParentCompatLollipop.onNestedScroll(viewParent, view, i, i2, i3, i4);
        }

        @Override // com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatStubImpl, com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void onNestedScrollAccepted(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
            com.dcloud.android.v4.view.ViewParentCompatLollipop.onNestedScrollAccepted(viewParent, view, view2, i);
        }

        @Override // com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatStubImpl, com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl
        public boolean onStartNestedScroll(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
            return com.dcloud.android.v4.view.ViewParentCompatLollipop.onStartNestedScroll(viewParent, view, view2, i);
        }

        @Override // com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatStubImpl, com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void onStopNestedScroll(android.view.ViewParent viewParent, android.view.View view) {
            com.dcloud.android.v4.view.ViewParentCompatLollipop.onStopNestedScroll(viewParent, view);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class ViewParentCompatStubImpl implements com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl {
        ViewParentCompatStubImpl() {
        }

        @Override // com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void notifySubtreeAccessibilityStateChanged(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
        }

        @Override // com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl
        public boolean onNestedFling(android.view.ViewParent viewParent, android.view.View view, float f, float f2, boolean z) {
            if (viewParent instanceof com.dcloud.android.v4.view.NestedScrollingParent) {
                return ((com.dcloud.android.v4.view.NestedScrollingParent) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }

        @Override // com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl
        public boolean onNestedPreFling(android.view.ViewParent viewParent, android.view.View view, float f, float f2) {
            if (viewParent instanceof com.dcloud.android.v4.view.NestedScrollingParent) {
                return ((com.dcloud.android.v4.view.NestedScrollingParent) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }

        @Override // com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void onNestedPreScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof com.dcloud.android.v4.view.NestedScrollingParent) {
                ((com.dcloud.android.v4.view.NestedScrollingParent) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        @Override // com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void onNestedScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof com.dcloud.android.v4.view.NestedScrollingParent) {
                ((com.dcloud.android.v4.view.NestedScrollingParent) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        @Override // com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void onNestedScrollAccepted(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
            if (viewParent instanceof com.dcloud.android.v4.view.NestedScrollingParent) {
                ((com.dcloud.android.v4.view.NestedScrollingParent) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        @Override // com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl
        public boolean onStartNestedScroll(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
            if (viewParent instanceof com.dcloud.android.v4.view.NestedScrollingParent) {
                return ((com.dcloud.android.v4.view.NestedScrollingParent) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        @Override // com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void onStopNestedScroll(android.view.ViewParent viewParent, android.view.View view) {
            if (viewParent instanceof com.dcloud.android.v4.view.NestedScrollingParent) {
                ((com.dcloud.android.v4.view.NestedScrollingParent) viewParent).onStopNestedScroll(view);
            }
        }

        @Override // com.dcloud.android.v4.view.ViewParentCompat.ViewParentCompatImpl
        public boolean requestSendAccessibilityEvent(android.view.ViewParent viewParent, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            if (view == null) {
                return false;
            }
            ((android.view.accessibility.AccessibilityManager) view.getContext().getSystemService("accessibility")).sendAccessibilityEvent(accessibilityEvent);
            return true;
        }
    }

    private ViewParentCompat() {
    }

    public static void notifySubtreeAccessibilityStateChanged(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
        IMPL.notifySubtreeAccessibilityStateChanged(viewParent, view, view2, i);
    }

    public static boolean onNestedFling(android.view.ViewParent viewParent, android.view.View view, float f, float f2, boolean z) {
        return IMPL.onNestedFling(viewParent, view, f, f2, z);
    }

    public static boolean onNestedPreFling(android.view.ViewParent viewParent, android.view.View view, float f, float f2) {
        return IMPL.onNestedPreFling(viewParent, view, f, f2);
    }

    public static void onNestedPreScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int[] iArr) {
        IMPL.onNestedPreScroll(viewParent, view, i, i2, iArr);
    }

    public static void onNestedScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int i3, int i4) {
        IMPL.onNestedScroll(viewParent, view, i, i2, i3, i4);
    }

    public static void onNestedScrollAccepted(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
        IMPL.onNestedScrollAccepted(viewParent, view, view2, i);
    }

    public static boolean onStartNestedScroll(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
        return IMPL.onStartNestedScroll(viewParent, view, view2, i);
    }

    public static void onStopNestedScroll(android.view.ViewParent viewParent, android.view.View view) {
        IMPL.onStopNestedScroll(viewParent, view);
    }

    public static boolean requestSendAccessibilityEvent(android.view.ViewParent viewParent, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return IMPL.requestSendAccessibilityEvent(viewParent, view, accessibilityEvent);
    }
}
