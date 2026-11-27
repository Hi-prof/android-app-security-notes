package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class NestedScrollingParentHelper {
    private int mNestedScrollAxes;
    private final android.view.ViewGroup mViewGroup;

    public NestedScrollingParentHelper(android.view.ViewGroup viewGroup) {
        this.mViewGroup = viewGroup;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollAxes;
    }

    public void onNestedScrollAccepted(android.view.View view, android.view.View view2, int i) {
        this.mNestedScrollAxes = i;
    }

    public void onStopNestedScroll(android.view.View view) {
        this.mNestedScrollAxes = 0;
    }
}
