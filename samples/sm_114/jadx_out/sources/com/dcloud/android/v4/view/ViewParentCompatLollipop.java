package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class ViewParentCompatLollipop {
    private static final java.lang.String TAG = "ViewParentCompat";

    ViewParentCompatLollipop() {
    }

    public static boolean onNestedFling(android.view.ViewParent viewParent, android.view.View view, float f, float f2, boolean z) {
        try {
            return viewParent.onNestedFling(view, f, f2, z);
        } catch (java.lang.AbstractMethodError e) {
            android.util.Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedFling", e);
            return false;
        }
    }

    public static boolean onNestedPreFling(android.view.ViewParent viewParent, android.view.View view, float f, float f2) {
        try {
            return viewParent.onNestedPreFling(view, f, f2);
        } catch (java.lang.AbstractMethodError e) {
            android.util.Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e);
            return false;
        }
    }

    public static void onNestedPreScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int[] iArr) {
        try {
            viewParent.onNestedPreScroll(view, i, i2, iArr);
        } catch (java.lang.AbstractMethodError e) {
            android.util.Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e);
        }
    }

    public static void onNestedScroll(android.view.ViewParent viewParent, android.view.View view, int i, int i2, int i3, int i4) {
        try {
            viewParent.onNestedScroll(view, i, i2, i3, i4);
        } catch (java.lang.AbstractMethodError e) {
            android.util.Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e);
        }
    }

    public static void onNestedScrollAccepted(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
        try {
            viewParent.onNestedScrollAccepted(view, view2, i);
        } catch (java.lang.AbstractMethodError e) {
            android.util.Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e);
        }
    }

    public static boolean onStartNestedScroll(android.view.ViewParent viewParent, android.view.View view, android.view.View view2, int i) {
        try {
            return viewParent.onStartNestedScroll(view, view2, i);
        } catch (java.lang.AbstractMethodError e) {
            android.util.Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e);
            return false;
        }
    }

    public static void onStopNestedScroll(android.view.ViewParent viewParent, android.view.View view) {
        try {
            viewParent.onStopNestedScroll(view);
        } catch (java.lang.AbstractMethodError e) {
            android.util.Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e);
        }
    }
}
