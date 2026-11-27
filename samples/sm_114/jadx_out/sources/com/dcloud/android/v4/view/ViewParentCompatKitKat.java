package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class ViewParentCompatKitKat {
    ViewParentCompatKitKat() {
    }

    public static void notifySubtreeAccessibilityStateChanged(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i);
    }
}
