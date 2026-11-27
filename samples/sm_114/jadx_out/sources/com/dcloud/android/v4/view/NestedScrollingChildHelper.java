package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private android.view.ViewParent mNestedScrollingParent;
    private int[] mTempNestedScrollConsumed;
    private final android.view.View mView;

    public NestedScrollingChildHelper(android.view.View view) {
        this.mView = view;
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        android.view.ViewParent viewParent;
        if (!isNestedScrollingEnabled() || (viewParent = this.mNestedScrollingParent) == null) {
            return false;
        }
        return com.dcloud.android.v4.view.ViewParentCompat.onNestedFling(viewParent, this.mView, f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        android.view.ViewParent viewParent;
        if (!isNestedScrollingEnabled() || (viewParent = this.mNestedScrollingParent) == null) {
            return false;
        }
        return com.dcloud.android.v4.view.ViewParentCompat.onNestedPreFling(viewParent, this.mView, f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        int i3;
        int i4;
        if (isNestedScrollingEnabled() && this.mNestedScrollingParent != null) {
            if (i != 0 || i2 != 0) {
                if (iArr2 != null) {
                    this.mView.getLocationInWindow(iArr2);
                    i3 = iArr2[0];
                    i4 = iArr2[1];
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                if (iArr == null) {
                    if (this.mTempNestedScrollConsumed == null) {
                        this.mTempNestedScrollConsumed = new int[2];
                    }
                    iArr = this.mTempNestedScrollConsumed;
                }
                iArr[0] = 0;
                iArr[1] = 0;
                com.dcloud.android.v4.view.ViewParentCompat.onNestedPreScroll(this.mNestedScrollingParent, this.mView, i, i2, iArr);
                if (iArr2 != null) {
                    this.mView.getLocationInWindow(iArr2);
                    iArr2[0] = iArr2[0] - i3;
                    iArr2[1] = iArr2[1] - i4;
                }
                return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
            }
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
        }
        return false;
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        int i5;
        int i6;
        if (isNestedScrollingEnabled() && this.mNestedScrollingParent != null) {
            if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
                if (iArr != null) {
                    this.mView.getLocationInWindow(iArr);
                    i5 = iArr[0];
                    i6 = iArr[1];
                } else {
                    i5 = 0;
                    i6 = 0;
                }
                com.dcloud.android.v4.view.ViewParentCompat.onNestedScroll(this.mNestedScrollingParent, this.mView, i, i2, i3, i4);
                if (iArr != null) {
                    this.mView.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - i5;
                    iArr[1] = iArr[1] - i6;
                }
                return true;
            }
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
        }
        return false;
    }

    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingParent != null;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public void onDetachedFromWindow() {
        com.dcloud.android.v4.view.ViewCompat.stopNestedScroll(this.mView);
    }

    public void onStopNestedScroll(android.view.View view) {
        com.dcloud.android.v4.view.ViewCompat.stopNestedScroll(this.mView);
    }

    public void setNestedScrollingEnabled(boolean z) {
        if (this.mIsNestedScrollingEnabled) {
            com.dcloud.android.v4.view.ViewCompat.stopNestedScroll(this.mView);
        }
        this.mIsNestedScrollingEnabled = z;
    }

    public boolean startNestedScroll(int i) {
        if (hasNestedScrollingParent()) {
            return true;
        }
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        android.view.View view = this.mView;
        for (android.view.ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
            if (com.dcloud.android.v4.view.ViewParentCompat.onStartNestedScroll(parent, view, this.mView, i)) {
                this.mNestedScrollingParent = parent;
                com.dcloud.android.v4.view.ViewParentCompat.onNestedScrollAccepted(parent, view, this.mView, i);
                return true;
            }
            if (parent instanceof android.view.View) {
                view = (android.view.View) parent;
            }
        }
        return false;
    }

    public void stopNestedScroll() {
        android.view.ViewParent viewParent = this.mNestedScrollingParent;
        if (viewParent != null) {
            com.dcloud.android.v4.view.ViewParentCompat.onStopNestedScroll(viewParent, this.mView);
            this.mNestedScrollingParent = null;
        }
    }
}
