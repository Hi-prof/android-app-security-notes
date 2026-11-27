package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(android.view.View view, float f, float f2, boolean z);

    boolean onNestedPreFling(android.view.View view, float f, float f2);

    void onNestedPreScroll(android.view.View view, int i, int i2, int[] iArr);

    void onNestedScroll(android.view.View view, int i, int i2, int i3, int i4);

    void onNestedScrollAccepted(android.view.View view, android.view.View view2, int i);

    boolean onStartNestedScroll(android.view.View view, android.view.View view2, int i);

    void onStopNestedScroll(android.view.View view);
}
