package com.taobao.weex.ui.view.listview;

/* JADX INFO: loaded from: classes.dex */
public class ExtendedLinearLayoutManager extends androidx.recyclerview.widget.LinearLayoutManager {
    private com.taobao.weex.ui.view.listview.ExtendedLinearLayoutManager.OnSmoothScrollEndListener onScrollEndListener;
    private androidx.recyclerview.widget.RecyclerView.SmoothScroller smoothScroller;

    public interface OnSmoothScrollEndListener {
        void onStop();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return false;
    }

    public ExtendedLinearLayoutManager(android.content.Context context) {
        super(context, 1, false);
    }

    public ExtendedLinearLayoutManager(android.content.Context context, int i, boolean z) {
        super(context, i, z);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler recycler, androidx.recyclerview.widget.RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (java.lang.IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, androidx.recyclerview.widget.RecyclerView.Recycler recycler, androidx.recyclerview.widget.RecyclerView.State state) {
        try {
            return super.scrollVerticallyBy(i, recycler, state);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state, int i) {
        if (this.smoothScroller == null) {
            this.smoothScroller = new com.taobao.weex.ui.view.listview.ExtendedLinearLayoutManager.TopSnappedSmoothScroller(recyclerView.getContext());
        }
        this.smoothScroller.setTargetPosition(i);
        startSmoothScroll(this.smoothScroller);
    }

    private class TopSnappedSmoothScroller extends androidx.recyclerview.widget.LinearSmoothScroller {
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected int getVerticalSnapPreference() {
            return -1;
        }

        public TopSnappedSmoothScroller(android.content.Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public android.graphics.PointF computeScrollVectorForPosition(int i) {
            return com.taobao.weex.ui.view.listview.ExtendedLinearLayoutManager.this.computeScrollVectorForPosition(i);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        protected void onStop() {
            super.onStop();
            if (com.taobao.weex.ui.view.listview.ExtendedLinearLayoutManager.this.onScrollEndListener != null) {
                com.taobao.weex.ui.view.listview.ExtendedLinearLayoutManager.this.onScrollEndListener.onStop();
                com.taobao.weex.ui.view.listview.ExtendedLinearLayoutManager.this.onScrollEndListener = null;
            }
        }
    }

    public void setOnScrollEndListener(com.taobao.weex.ui.view.listview.ExtendedLinearLayoutManager.OnSmoothScrollEndListener onSmoothScrollEndListener) {
        this.onScrollEndListener = onSmoothScrollEndListener;
    }
}
