package com.alibaba.android.bindingx.plugin.weex;

/* JADX INFO: loaded from: classes.dex */
public class BindingXScrollHandler extends com.alibaba.android.bindingx.core.internal.AbstractScrollEventHandler {
    private static java.util.HashMap<java.lang.String, com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.ContentOffsetHolder> sOffsetHolderMap = new java.util.HashMap<>();
    private com.taobao.weex.ui.view.WXHorizontalScrollView.ScrollViewListener mHorizontalViewScrollListener;
    private androidx.recyclerview.widget.RecyclerView.OnScrollListener mListOnScrollListener;
    private com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener mOnOffsetChangedListener;
    private com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.OnRefreshOffsetChangedListener mRefreshOffsetChangedListener;
    private java.lang.String mSourceRef;
    private com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener mWxScrollViewListener;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSameDirection(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return i < 0 && i2 < 0;
        }
        return true;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityPause() {
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityResume() {
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onStart(java.lang.String str, java.lang.String str2) {
    }

    public BindingXScrollHandler(android.content.Context context, com.alibaba.android.bindingx.core.PlatformManager platformManager, java.lang.Object... objArr) {
        super(context, platformManager, objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onCreate(java.lang.String str, java.lang.String str2) {
        com.taobao.weex.ui.view.refresh.core.WXSwipeLayout swipeLayout;
        com.taobao.weex.ui.component.WXComponent wXComponentFindComponentByRef = com.alibaba.android.bindingx.plugin.weex.WXModuleUtils.findComponentByRef(android.text.TextUtils.isEmpty(this.mAnchorInstanceId) ? this.mInstanceId : this.mAnchorInstanceId, str);
        if (wXComponentFindComponentByRef == null) {
            com.alibaba.android.bindingx.core.LogProxy.e("[ExpressionScrollHandler]source component not found.");
            return false;
        }
        this.mSourceRef = str;
        if (wXComponentFindComponentByRef instanceof com.taobao.weex.ui.component.WXScroller) {
            com.taobao.weex.ui.component.WXScroller wXScroller = (com.taobao.weex.ui.component.WXScroller) wXComponentFindComponentByRef;
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) wXScroller.getHostView();
            if (viewGroup != null && (viewGroup instanceof com.taobao.weex.ui.view.refresh.wrapper.BounceScrollerView) && (swipeLayout = ((com.taobao.weex.ui.view.refresh.wrapper.BounceScrollerView) viewGroup).getSwipeLayout()) != null) {
                com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerSwipeOffsetListener innerSwipeOffsetListener = new com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerSwipeOffsetListener();
                this.mRefreshOffsetChangedListener = innerSwipeOffsetListener;
                swipeLayout.addOnRefreshOffsetChangedListener(innerSwipeOffsetListener);
            }
            android.view.ViewGroup innerView = wXScroller.getInnerView();
            if (innerView != null && (innerView instanceof com.taobao.weex.ui.view.WXScrollView)) {
                com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerScrollViewListener innerScrollViewListener = new com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerScrollViewListener();
                this.mWxScrollViewListener = innerScrollViewListener;
                ((com.taobao.weex.ui.view.WXScrollView) innerView).addScrollViewListener(innerScrollViewListener);
                return true;
            }
            if (innerView != null && (innerView instanceof com.taobao.weex.ui.view.WXHorizontalScrollView)) {
                com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerScrollViewListener innerScrollViewListener2 = new com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerScrollViewListener();
                this.mHorizontalViewScrollListener = innerScrollViewListener2;
                ((com.taobao.weex.ui.view.WXHorizontalScrollView) innerView).addScrollViewListener(innerScrollViewListener2);
                return true;
            }
        } else if (wXComponentFindComponentByRef instanceof com.taobao.weex.ui.component.list.WXListComponent) {
            com.taobao.weex.ui.component.list.WXListComponent wXListComponent = (com.taobao.weex.ui.component.list.WXListComponent) wXComponentFindComponentByRef;
            com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView bounceRecyclerView = (com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) wXListComponent.getHostView();
            if (bounceRecyclerView != null) {
                com.taobao.weex.ui.view.refresh.core.WXSwipeLayout swipeLayout2 = bounceRecyclerView.getSwipeLayout();
                if (swipeLayout2 != null) {
                    com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerSwipeOffsetListener innerSwipeOffsetListener2 = new com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerSwipeOffsetListener();
                    this.mRefreshOffsetChangedListener = innerSwipeOffsetListener2;
                    swipeLayout2.addOnRefreshOffsetChangedListener(innerSwipeOffsetListener2);
                }
                com.taobao.weex.ui.view.listview.WXRecyclerView wXRecyclerView = (com.taobao.weex.ui.view.listview.WXRecyclerView) bounceRecyclerView.getInnerView();
                boolean z = wXListComponent.getOrientation() == 1;
                if (wXRecyclerView != null) {
                    java.util.HashMap<java.lang.String, com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.ContentOffsetHolder> map = sOffsetHolderMap;
                    if (map != null && map.get(str) == null) {
                        sOffsetHolderMap.put(str, new com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.ContentOffsetHolder(0, 0));
                    }
                    com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerListScrollListener innerListScrollListener = new com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerListScrollListener(z, new java.lang.ref.WeakReference(wXListComponent));
                    this.mListOnScrollListener = innerListScrollListener;
                    wXRecyclerView.addOnScrollListener(innerListScrollListener);
                    return true;
                }
            }
        } else if (wXComponentFindComponentByRef.getHostView() != null && (wXComponentFindComponentByRef.getHostView() instanceof com.google.android.material.appbar.AppBarLayout)) {
            com.google.android.material.appbar.AppBarLayout hostView = wXComponentFindComponentByRef.getHostView();
            com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerAppBarOffsetChangedListener innerAppBarOffsetChangedListener = new com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerAppBarOffsetChangedListener();
            this.mOnOffsetChangedListener = innerAppBarOffsetChangedListener;
            hostView.addOnOffsetChangedListener(innerAppBarOffsetChangedListener);
            return true;
        }
        return false;
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void onBindExpression(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair, java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list, com.alibaba.android.bindingx.core.BindingXCore.JavaScriptCallback javaScriptCallback) {
        super.onBindExpression(str, map, expressionPair, list, javaScriptCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.android.bindingx.core.internal.AbstractScrollEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public boolean onDisable(java.lang.String str, java.lang.String str2) {
        com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView bounceRecyclerView;
        androidx.recyclerview.widget.RecyclerView.OnScrollListener onScrollListener;
        com.taobao.weex.ui.view.WXHorizontalScrollView.ScrollViewListener scrollViewListener;
        com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener wXScrollViewListener;
        com.taobao.weex.ui.view.refresh.core.WXSwipeLayout swipeLayout;
        com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.OnRefreshOffsetChangedListener onRefreshOffsetChangedListener;
        com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.ContentOffsetHolder contentOffsetHolder;
        super.onDisable(str, str2);
        if (sOffsetHolderMap != null && !android.text.TextUtils.isEmpty(this.mSourceRef) && (contentOffsetHolder = sOffsetHolderMap.get(this.mSourceRef)) != null) {
            contentOffsetHolder.x = this.mContentOffsetX;
            contentOffsetHolder.y = this.mContentOffsetY;
        }
        com.taobao.weex.ui.component.WXComponent wXComponentFindComponentByRef = com.alibaba.android.bindingx.plugin.weex.WXModuleUtils.findComponentByRef(android.text.TextUtils.isEmpty(this.mAnchorInstanceId) ? this.mInstanceId : this.mAnchorInstanceId, str);
        if (wXComponentFindComponentByRef == null) {
            com.alibaba.android.bindingx.core.LogProxy.e("[ExpressionScrollHandler]source component not found.");
            return false;
        }
        if (wXComponentFindComponentByRef instanceof com.taobao.weex.ui.component.WXScroller) {
            com.taobao.weex.ui.component.WXScroller wXScroller = (com.taobao.weex.ui.component.WXScroller) wXComponentFindComponentByRef;
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) wXScroller.getHostView();
            if (viewGroup != null && (viewGroup instanceof com.taobao.weex.ui.view.refresh.wrapper.BounceScrollerView) && (swipeLayout = ((com.taobao.weex.ui.view.refresh.wrapper.BounceScrollerView) viewGroup).getSwipeLayout()) != null && (onRefreshOffsetChangedListener = this.mRefreshOffsetChangedListener) != null) {
                swipeLayout.removeOnRefreshOffsetChangedListener(onRefreshOffsetChangedListener);
            }
            android.view.ViewGroup innerView = wXScroller.getInnerView();
            if (innerView != null && (innerView instanceof com.taobao.weex.ui.view.WXScrollView) && (wXScrollViewListener = this.mWxScrollViewListener) != null) {
                ((com.taobao.weex.ui.view.WXScrollView) innerView).removeScrollViewListener(wXScrollViewListener);
                return true;
            }
            if (innerView != null && (innerView instanceof com.taobao.weex.ui.view.WXHorizontalScrollView) && (scrollViewListener = this.mHorizontalViewScrollListener) != null) {
                ((com.taobao.weex.ui.view.WXHorizontalScrollView) innerView).removeScrollViewListener(scrollViewListener);
                return true;
            }
        } else if ((wXComponentFindComponentByRef instanceof com.taobao.weex.ui.component.list.WXListComponent) && (bounceRecyclerView = (com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) ((com.taobao.weex.ui.component.list.WXListComponent) wXComponentFindComponentByRef).getHostView()) != null) {
            if (bounceRecyclerView.getSwipeLayout() != null && this.mRefreshOffsetChangedListener != null) {
                bounceRecyclerView.getSwipeLayout().removeOnRefreshOffsetChangedListener(this.mRefreshOffsetChangedListener);
            }
            com.taobao.weex.ui.view.listview.WXRecyclerView wXRecyclerView = (com.taobao.weex.ui.view.listview.WXRecyclerView) bounceRecyclerView.getInnerView();
            if (wXRecyclerView != null && (onScrollListener = this.mListOnScrollListener) != null) {
                wXRecyclerView.removeOnScrollListener(onScrollListener);
                return true;
            }
        }
        return false;
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractScrollEventHandler, com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void onDestroy() {
        super.onDestroy();
        this.mListOnScrollListener = null;
        this.mWxScrollViewListener = null;
        this.mOnOffsetChangedListener = null;
        java.util.HashMap<java.lang.String, com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.ContentOffsetHolder> map = sOffsetHolderMap;
        if (map != null) {
            map.clear();
        }
    }

    private class InnerAppBarOffsetChangedListener implements com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener {
        private int mContentOffsetY;
        private int mLastDy;
        private int mTy;

        private InnerAppBarOffsetChangedListener() {
            this.mContentOffsetY = 0;
            this.mTy = 0;
            this.mLastDy = 0;
        }

        public void onOffsetChanged(com.google.android.material.appbar.AppBarLayout appBarLayout, int i) {
            boolean z;
            int i2 = -i;
            final int i3 = i2 - this.mContentOffsetY;
            this.mContentOffsetY = i2;
            if (i3 == 0) {
                return;
            }
            if (com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.this.isSameDirection(i3, this.mLastDy)) {
                z = false;
            } else {
                this.mTy = this.mContentOffsetY;
                z = true;
            }
            int i4 = this.mContentOffsetY;
            final int i5 = i4 - this.mTy;
            this.mLastDy = i3;
            if (z) {
                com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.super.fireEventByState(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_TURNING, 0.0d, i4, 0.0d, i3, 0.0d, i5, new java.lang.Object[0]);
            }
            com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerAppBarOffsetChangedListener.1
                @Override // java.lang.Runnable
                public void run() {
                    com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.super.handleScrollEvent(0, com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerAppBarOffsetChangedListener.this.mContentOffsetY, 0, i3, 0, i5);
                }
            }, com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.this.mInstanceId);
        }
    }

    private class InnerScrollViewListener implements com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener, com.taobao.weex.ui.view.WXHorizontalScrollView.ScrollViewListener {
        private int mContentOffsetX;
        private int mContentOffsetY;
        private int mLastDx;
        private int mLastDy;
        private int mTx;
        private int mTy;

        @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
        public void onScrollChanged(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2, int i3, int i4) {
        }

        @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
        public void onScrollStopped(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
        }

        @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
        public void onScrollToBottom(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
        }

        private InnerScrollViewListener() {
            this.mContentOffsetX = 0;
            this.mContentOffsetY = 0;
            this.mTx = 0;
            this.mTy = 0;
            this.mLastDx = 0;
            this.mLastDy = 0;
        }

        @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
        public void onScroll(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
            onScrollInternal(i, i2);
        }

        @Override // com.taobao.weex.ui.view.WXHorizontalScrollView.ScrollViewListener
        public void onScrollChanged(com.taobao.weex.ui.view.WXHorizontalScrollView wXHorizontalScrollView, int i, int i2, int i3, int i4) {
            onScrollInternal(i, i2);
        }

        private void onScrollInternal(int i, int i2) {
            boolean z;
            final int i3 = i - this.mContentOffsetX;
            final int i4 = i2 - this.mContentOffsetY;
            this.mContentOffsetX = i;
            this.mContentOffsetY = i2;
            if (i3 == 0 && i4 == 0) {
                return;
            }
            if (com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.this.isSameDirection(i4, this.mLastDy)) {
                z = false;
            } else {
                this.mTy = this.mContentOffsetY;
                z = true;
            }
            int i5 = this.mContentOffsetX;
            final int i6 = i5 - this.mTx;
            int i7 = this.mContentOffsetY;
            final int i8 = i7 - this.mTy;
            this.mLastDx = i3;
            this.mLastDy = i4;
            if (z) {
                com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.super.fireEventByState(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_TURNING, i5, i7, i3, i4, i6, i8, new java.lang.Object[0]);
            }
            com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerScrollViewListener.1
                @Override // java.lang.Runnable
                public void run() {
                    com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.super.handleScrollEvent(com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerScrollViewListener.this.mContentOffsetX, com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerScrollViewListener.this.mContentOffsetY, i3, i4, i6, i8);
                }
            }, com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.this.mInstanceId);
        }
    }

    private class InnerSwipeOffsetListener implements com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.OnRefreshOffsetChangedListener {
        private int mContentOffsetY;
        private int mLastDy;
        private int mTy;

        private InnerSwipeOffsetListener() {
            this.mContentOffsetY = 0;
            this.mTy = 0;
            this.mLastDy = 0;
        }

        @Override // com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.OnRefreshOffsetChangedListener
        public void onOffsetChanged(int i) {
            boolean z;
            int i2 = -i;
            final int i3 = i2 - this.mContentOffsetY;
            this.mContentOffsetY = i2;
            if (i3 == 0) {
                return;
            }
            if (com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.this.isSameDirection(i3, this.mLastDy)) {
                z = false;
            } else {
                this.mTy = this.mContentOffsetY;
                z = true;
            }
            final int i4 = this.mContentOffsetY - this.mTy;
            this.mLastDy = i3;
            if (z) {
                com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler bindingXScrollHandler = com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.this;
                com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.super.fireEventByState(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_TURNING, bindingXScrollHandler.mContentOffsetX, this.mContentOffsetY, 0.0d, i3, 0.0d, i4, new java.lang.Object[0]);
            }
            com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerSwipeOffsetListener.1
                @Override // java.lang.Runnable
                public void run() {
                    com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.super.handleScrollEvent(com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.this.mContentOffsetX, com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerSwipeOffsetListener.this.mContentOffsetY, 0, i3, 0, i4);
                }
            }, com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.this.mInstanceId);
        }
    }

    private class InnerListScrollListener extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
        private boolean isVertical;
        private java.lang.ref.WeakReference<com.taobao.weex.ui.component.list.WXListComponent> mComponentRef;
        private int mContentOffsetX;
        private int mContentOffsetY;
        private int mTx = 0;
        private int mTy = 0;
        private int mLastDx = 0;
        private int mLastDy = 0;

        InnerListScrollListener(boolean z, java.lang.ref.WeakReference<com.taobao.weex.ui.component.list.WXListComponent> weakReference) {
            com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.ContentOffsetHolder contentOffsetHolder;
            this.mContentOffsetX = 0;
            this.mContentOffsetY = 0;
            this.isVertical = z;
            this.mComponentRef = weakReference;
            if (android.text.TextUtils.isEmpty(com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.this.mSourceRef) || com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.sOffsetHolderMap == null || (contentOffsetHolder = (com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.ContentOffsetHolder) com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.sOffsetHolderMap.get(com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.this.mSourceRef)) == null) {
                return;
            }
            this.mContentOffsetX = contentOffsetHolder.x;
            this.mContentOffsetY = contentOffsetHolder.y;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, final int i, final int i2) {
            boolean z;
            java.lang.ref.WeakReference<com.taobao.weex.ui.component.list.WXListComponent> weakReference;
            if (androidx.core.view.ViewCompat.isInLayout(recyclerView) && (weakReference = this.mComponentRef) != null && weakReference.get() != null) {
                this.mContentOffsetY = java.lang.Math.abs(this.mComponentRef.get().calcContentOffset(recyclerView));
            } else {
                this.mContentOffsetY += i2;
            }
            this.mContentOffsetX += i;
            boolean z2 = true;
            if (com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.this.isSameDirection(i, this.mLastDx) || this.isVertical) {
                z = false;
            } else {
                this.mTx = this.mContentOffsetX;
                z = true;
            }
            if (com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.this.isSameDirection(i2, this.mLastDy) || !this.isVertical) {
                z2 = z;
            } else {
                this.mTy = this.mContentOffsetY;
            }
            int i3 = this.mContentOffsetX;
            final int i4 = i3 - this.mTx;
            int i5 = this.mContentOffsetY;
            final int i6 = i5 - this.mTy;
            this.mLastDx = i;
            this.mLastDy = i2;
            if (z2) {
                com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.this.fireEventByState(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_TURNING, i3, i5, i, i2, i4, i6, new java.lang.Object[0]);
            }
            com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerListScrollListener.1
                @Override // java.lang.Runnable
                public void run() {
                    com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.super.handleScrollEvent(com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerListScrollListener.this.mContentOffsetX, com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.InnerListScrollListener.this.mContentOffsetY, i, i2, i4, i6);
                }
            }, com.alibaba.android.bindingx.plugin.weex.BindingXScrollHandler.this.mInstanceId);
        }
    }

    private static class ContentOffsetHolder {
        int x;
        int y;

        ContentOffsetHolder(int i, int i2) {
            this.x = i;
            this.y = i2;
        }
    }
}
