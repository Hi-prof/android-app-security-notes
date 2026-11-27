package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class ViewCompatJB {
    ViewCompatJB() {
    }

    public static java.lang.Object getAccessibilityNodeProvider(android.view.View view) {
        return view.getAccessibilityNodeProvider();
    }

    public static boolean getFitsSystemWindows(android.view.View view) {
        return view.getFitsSystemWindows();
    }

    public static int getImportantForAccessibility(android.view.View view) {
        return view.getImportantForAccessibility();
    }

    public static int getMinimumHeight(android.view.View view) {
        return view.getMinimumHeight();
    }

    public static int getMinimumWidth(android.view.View view) {
        return view.getMinimumWidth();
    }

    public static android.view.ViewParent getParentForAccessibility(android.view.View view) {
        return view.getParentForAccessibility();
    }

    public static boolean hasOverlappingRendering(android.view.View view) {
        return view.hasOverlappingRendering();
    }

    public static boolean hasTransientState(android.view.View view) {
        return view.hasTransientState();
    }

    public static boolean performAccessibilityAction(android.view.View view, int i, android.os.Bundle bundle) {
        return view.performAccessibilityAction(i, bundle);
    }

    public static void postInvalidateOnAnimation(android.view.View view) {
        view.postInvalidateOnAnimation();
    }

    public static void postOnAnimation(android.view.View view, java.lang.Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void postOnAnimationDelayed(android.view.View view, java.lang.Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static void requestApplyInsets(android.view.View view) {
        view.requestFitSystemWindows();
    }

    public static void setHasTransientState(android.view.View view, boolean z) {
        view.setHasTransientState(z);
    }

    public static void setImportantForAccessibility(android.view.View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static void postInvalidateOnAnimation(android.view.View view, int i, int i2, int i3, int i4) {
        view.postInvalidate(i, i2, i3, i4);
    }
}
