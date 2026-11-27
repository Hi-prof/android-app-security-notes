package com.dcloud.android.v4.widget;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class ScrollerCompatGingerbread {
    ScrollerCompatGingerbread() {
    }

    public static void abortAnimation(java.lang.Object obj) {
        ((android.widget.OverScroller) obj).abortAnimation();
    }

    public static boolean computeScrollOffset(java.lang.Object obj) {
        return ((android.widget.OverScroller) obj).computeScrollOffset();
    }

    public static java.lang.Object createScroller(android.content.Context context, android.view.animation.Interpolator interpolator) {
        return interpolator != null ? new android.widget.OverScroller(context, interpolator) : new android.widget.OverScroller(context);
    }

    public static void fling(java.lang.Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((android.widget.OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public static int getCurrX(java.lang.Object obj) {
        return ((android.widget.OverScroller) obj).getCurrX();
    }

    public static int getCurrY(java.lang.Object obj) {
        return ((android.widget.OverScroller) obj).getCurrY();
    }

    public static int getFinalX(java.lang.Object obj) {
        return ((android.widget.OverScroller) obj).getFinalX();
    }

    public static int getFinalY(java.lang.Object obj) {
        return ((android.widget.OverScroller) obj).getFinalY();
    }

    public static boolean isFinished(java.lang.Object obj) {
        return ((android.widget.OverScroller) obj).isFinished();
    }

    public static boolean isOverScrolled(java.lang.Object obj) {
        return ((android.widget.OverScroller) obj).isOverScrolled();
    }

    public static void notifyHorizontalEdgeReached(java.lang.Object obj, int i, int i2, int i3) {
        ((android.widget.OverScroller) obj).notifyHorizontalEdgeReached(i, i2, i3);
    }

    public static void notifyVerticalEdgeReached(java.lang.Object obj, int i, int i2, int i3) {
        ((android.widget.OverScroller) obj).notifyVerticalEdgeReached(i, i2, i3);
    }

    public static void startScroll(java.lang.Object obj, int i, int i2, int i3, int i4) {
        ((android.widget.OverScroller) obj).startScroll(i, i2, i3, i4);
    }

    public static void fling(java.lang.Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        ((android.widget.OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public static void startScroll(java.lang.Object obj, int i, int i2, int i3, int i4, int i5) {
        ((android.widget.OverScroller) obj).startScroll(i, i2, i3, i4, i5);
    }
}
