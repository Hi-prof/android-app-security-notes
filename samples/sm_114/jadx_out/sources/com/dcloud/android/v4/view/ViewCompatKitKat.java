package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class ViewCompatKitKat {
    ViewCompatKitKat() {
    }

    public static int getAccessibilityLiveRegion(android.view.View view) {
        return view.getAccessibilityLiveRegion();
    }

    public static boolean isAttachedToWindow(android.view.View view) {
        return view.isAttachedToWindow();
    }

    public static boolean isLaidOut(android.view.View view) {
        return view.isLaidOut();
    }

    public static void setAccessibilityLiveRegion(android.view.View view, int i) {
        view.setAccessibilityLiveRegion(i);
    }
}
