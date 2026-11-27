package com.taobao.weex.ui.view.listview.adapter;

/* JADX INFO: loaded from: classes.dex */
public class WXRecyclerViewOnScrollListener extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
    protected com.taobao.weex.ui.view.listview.adapter.WXRecyclerViewOnScrollListener.LAYOUT_MANAGER_TYPE layoutManagerType;
    private java.lang.ref.WeakReference<com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener> listener;
    private int[] mFirstPositions;
    private int mFirstVisibleItemPosition;
    private int[] mLastPositions;
    private int mLastVisibleItemPosition;
    private int mCurrentScrollState = 0;
    private int mDy = 0;
    private boolean isLayoutRTL = false;

    public enum LAYOUT_MANAGER_TYPE {
        LINEAR,
        GRID,
        STAGGERED_GRID
    }

    public void setLayoutRTL(boolean z) {
        this.isLayoutRTL = z;
    }

    public WXRecyclerViewOnScrollListener(com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener iOnLoadMoreListener) {
        this.listener = new java.lang.ref.WeakReference<>(iOnLoadMoreListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i) {
        java.lang.ref.WeakReference<com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener> weakReference;
        java.lang.ref.WeakReference<com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener> weakReference2;
        super.onScrollStateChanged(recyclerView, i);
        this.mCurrentScrollState = i;
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        int itemCount = layoutManager.getItemCount();
        if (childCount != 0) {
            int height = (((itemCount - this.mLastVisibleItemPosition) - 1) * recyclerView.getHeight()) / childCount;
            if (childCount <= 0 || this.mCurrentScrollState != 0) {
                return;
            }
            if (recyclerView.isHorizontalScrollBarEnabled()) {
                android.view.View childAt = recyclerView.getLayoutManager().getChildAt(childCount - 1);
                int position = recyclerView.getLayoutManager().getPosition(childAt);
                if (childAt == null || position != itemCount - 1) {
                    return;
                }
                if (this.isLayoutRTL) {
                    if (layoutManager.getDecoratedLeft(childAt) < -50 || (weakReference2 = this.listener) == null || weakReference2.get() == null) {
                        return;
                    }
                    this.listener.get().onLoadMore(height);
                    return;
                }
                if (layoutManager.getDecoratedRight(childAt) > recyclerView.getWidth() || (weakReference = this.listener) == null || weakReference.get() == null) {
                    return;
                }
                this.listener.get().onLoadMore(height);
                return;
            }
            android.view.View childAt2 = layoutManager.getChildAt(this.mLastVisibleItemPosition);
            if (childAt2 != null) {
                int decoratedBottom = layoutManager.getDecoratedBottom(childAt2);
                int height2 = recyclerView.getHeight();
                if (decoratedBottom + 50 < height2 || decoratedBottom > height2) {
                    return;
                }
            } else {
                int i2 = this.mDy;
                if (i2 == 0 || i2 < 0) {
                    return;
                }
            }
            java.lang.ref.WeakReference<com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener> weakReference3 = this.listener;
            if (weakReference3 != null && weakReference3.get() != null) {
                this.listener.get().onLoadMore(height);
            }
            this.mDy = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
        com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener iOnLoadMoreListener;
        super.onScrolled(recyclerView, i, i2);
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        java.lang.ref.WeakReference<com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener> weakReference = this.listener;
        if (weakReference == null || (iOnLoadMoreListener = weakReference.get()) == null) {
            return;
        }
        iOnLoadMoreListener.onBeforeScroll(i, i2);
        this.mDy = i2;
        if (layoutManager instanceof androidx.recyclerview.widget.LinearLayoutManager) {
            this.layoutManagerType = com.taobao.weex.ui.view.listview.adapter.WXRecyclerViewOnScrollListener.LAYOUT_MANAGER_TYPE.LINEAR;
            androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = (androidx.recyclerview.widget.LinearLayoutManager) layoutManager;
            this.mLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            iOnLoadMoreListener.notifyAppearStateChange(linearLayoutManager.findFirstVisibleItemPosition(), this.mLastVisibleItemPosition, i, i2);
            return;
        }
        if (layoutManager instanceof androidx.recyclerview.widget.GridLayoutManager) {
            this.layoutManagerType = com.taobao.weex.ui.view.listview.adapter.WXRecyclerViewOnScrollListener.LAYOUT_MANAGER_TYPE.GRID;
            androidx.recyclerview.widget.GridLayoutManager gridLayoutManager = (androidx.recyclerview.widget.GridLayoutManager) layoutManager;
            this.mLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
            iOnLoadMoreListener.notifyAppearStateChange(gridLayoutManager.findFirstVisibleItemPosition(), this.mLastVisibleItemPosition, i, i2);
            return;
        }
        if (layoutManager instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager) {
            this.layoutManagerType = com.taobao.weex.ui.view.listview.adapter.WXRecyclerViewOnScrollListener.LAYOUT_MANAGER_TYPE.STAGGERED_GRID;
            androidx.recyclerview.widget.StaggeredGridLayoutManager staggeredGridLayoutManager = (androidx.recyclerview.widget.StaggeredGridLayoutManager) layoutManager;
            int spanCount = staggeredGridLayoutManager.getSpanCount();
            int[] iArr = this.mLastPositions;
            if (iArr == null || spanCount != iArr.length) {
                this.mLastPositions = new int[spanCount];
            }
            int[] iArr2 = this.mFirstPositions;
            if (iArr2 == null || spanCount != iArr2.length) {
                this.mFirstPositions = new int[spanCount];
            }
            try {
                staggeredGridLayoutManager.findFirstVisibleItemPositions(this.mFirstPositions);
                this.mFirstVisibleItemPosition = findMin(this.mFirstPositions);
                staggeredGridLayoutManager.findLastVisibleItemPositions(this.mLastPositions);
                int iFindMax = findMax(this.mLastPositions);
                this.mLastVisibleItemPosition = iFindMax;
                iOnLoadMoreListener.notifyAppearStateChange(this.mFirstVisibleItemPosition, iFindMax, i, i2);
                return;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.taobao.weex.utils.WXLogUtils.e(e.toString());
                return;
            }
        }
        throw new java.lang.RuntimeException("Unsupported LayoutManager used. Valid ones are LinearLayoutManager, GridLayoutManager and StaggeredGridLayoutManager");
    }

    private int findMax(int[] iArr) {
        int i = iArr[0];
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    private int findMin(int[] iArr) {
        int i = iArr[0];
        for (int i2 : iArr) {
            if (i2 < i) {
                i = i2;
            }
        }
        return i;
    }
}
