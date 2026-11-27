package com.taobao.weex.ui.component.list;

/* JADX INFO: loaded from: classes.dex */
public class WXPagerSnapHelper extends androidx.recyclerview.widget.PagerSnapHelper {
    private androidx.recyclerview.widget.OrientationHelper mHorizontalHelper;
    private androidx.recyclerview.widget.OrientationHelper mVerticalHelper;

    @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, android.view.View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = distanceToStart(layoutManager, view, getHorizontalHelper(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = distanceToStart(layoutManager, view, getVerticalHelper(layoutManager));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    private androidx.recyclerview.widget.OrientationHelper getVerticalHelper(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
        if (this.mVerticalHelper == null) {
            this.mVerticalHelper = androidx.recyclerview.widget.OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.mVerticalHelper;
    }

    private androidx.recyclerview.widget.OrientationHelper getHorizontalHelper(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager) {
        if (this.mHorizontalHelper == null) {
            this.mHorizontalHelper = androidx.recyclerview.widget.OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.mHorizontalHelper;
    }

    private int distanceToStart(androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, android.view.View view, androidx.recyclerview.widget.OrientationHelper orientationHelper) {
        return orientationHelper.getDecoratedStart(view) - orientationHelper.getStartAfterPadding();
    }
}
