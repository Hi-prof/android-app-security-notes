package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
public class AppearanceHelper {
    public static final int APPEAR = 0;
    public static final int DISAPPEAR = 1;
    public static final int RESULT_APPEAR = 1;
    public static final int RESULT_DISAPPEAR = -1;
    public static final int RESULT_NO_CHANGE = 0;
    private boolean mAppearStatus;
    private final com.taobao.weex.ui.component.WXComponent mAwareChild;
    private int mCellPositionInScrollable;
    private android.graphics.Rect mVisibleRect;
    private boolean[] mWatchFlags;

    public AppearanceHelper(com.taobao.weex.ui.component.WXComponent wXComponent) {
        this(wXComponent, 0);
    }

    public AppearanceHelper(com.taobao.weex.ui.component.WXComponent wXComponent, int i) {
        this.mAppearStatus = false;
        this.mWatchFlags = new boolean[]{false, false};
        this.mVisibleRect = new android.graphics.Rect();
        this.mAwareChild = wXComponent;
        this.mCellPositionInScrollable = i;
    }

    public void setCellPosition(int i) {
        this.mCellPositionInScrollable = i;
    }

    public int getCellPositionINScollable() {
        return this.mCellPositionInScrollable;
    }

    public void setWatchEvent(int i, boolean z) {
        this.mWatchFlags[i] = z;
    }

    public boolean isWatch() {
        boolean[] zArr = this.mWatchFlags;
        return zArr[0] || zArr[1];
    }

    public com.taobao.weex.ui.component.WXComponent getAwareChild() {
        return this.mAwareChild;
    }

    public boolean isAppear() {
        return this.mAppearStatus;
    }

    public int setAppearStatus(boolean z) {
        if (this.mAppearStatus == z) {
            return 0;
        }
        this.mAppearStatus = z;
        return z ? 1 : -1;
    }

    public boolean isViewVisible(boolean z) {
        android.view.View hostView = this.mAwareChild.getHostView();
        if (z && hostView.getVisibility() == 0 && hostView.getMeasuredHeight() == 0) {
            return true;
        }
        return hostView != null && hostView.getLocalVisibleRect(this.mVisibleRect);
    }

    public boolean isViewVisible(android.view.View view) {
        if (view.getVisibility() == 0 && view.getMeasuredHeight() == 0) {
            return true;
        }
        return view != null && view.getLocalVisibleRect(this.mVisibleRect);
    }
}
