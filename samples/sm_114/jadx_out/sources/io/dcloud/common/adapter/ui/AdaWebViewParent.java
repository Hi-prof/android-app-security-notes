package io.dcloud.common.adapter.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class AdaWebViewParent extends io.dcloud.common.adapter.ui.AdaContainerFrameItem {
    boolean isSetPull2Refresh;
    io.dcloud.common.adapter.ui.AdaWebview mAdaWebview;
    io.dcloud.common.adapter.ui.AdaWebViewParent.PullToRefreshWebViewExt mPullReFreshViewImpl;
    io.dcloud.common.adapter.ui.WebParentView webParentRootView;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class PullToRefreshWebViewExt extends io.dcloud.common.adapter.ui.fresh.PullToRefreshWebView {
        public PullToRefreshWebViewExt(android.content.Context context) {
            super(context);
        }

        private boolean directPageIsLaunchPage(io.dcloud.common.DHInterface.IApp iApp) {
            return (android.text.TextUtils.isEmpty(iApp.getOriginalDirectPage()) || iApp.obtainWebAppIntent().hasExtra(io.dcloud.common.constant.IntentConst.DIRECT_PAGE)) ? false : true;
        }

        @Override // io.dcloud.common.adapter.ui.fresh.PullToRefreshBase
        protected void onAddRefreshableView(android.widget.LinearLayout.LayoutParams layoutParams) {
            io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions;
            io.dcloud.common.adapter.ui.AdaWebview adaWebview = io.dcloud.common.adapter.ui.AdaWebViewParent.this.mAdaWebview;
            if (adaWebview != null) {
                boolean zIsFullScreenOrImmersive = adaWebview.obtainApp().obtainStatusBarMgr().isFullScreenOrImmersive();
                if (android.os.Build.VERSION.SDK_INT > 21 && zIsFullScreenOrImmersive && (viewOptionsObtainFrameOptions = io.dcloud.common.adapter.ui.AdaWebViewParent.this.mAdaWebview.mFrameView.obtainFrameOptions()) != null && viewOptionsObtainFrameOptions.titleNView == null && !viewOptionsObtainFrameOptions.isStatusbar) {
                    layoutParams.rightMargin = -1;
                }
            }
            super.onAddRefreshableView(layoutParams);
        }

        @Override // io.dcloud.common.adapter.ui.fresh.PullToRefreshBase, android.view.View
        public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
            return (io.dcloud.common.adapter.ui.AdaWebViewParent.this.mAdaWebview.obtainMainView() != null && io.dcloud.common.adapter.ui.AdaWebViewParent.this.mAdaWebview.obtainMainView().getVisibility() == io.dcloud.common.adapter.ui.AdaFrameItem.GONE) || super.onTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
        }
    }

    AdaWebViewParent(android.content.Context context) {
        super(context);
        this.mPullReFreshViewImpl = null;
        this.mAdaWebview = null;
        this.isSetPull2Refresh = false;
        initRootView(context, true);
    }

    private void initPullView(io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.OnStateChangeListener onStateChangeListener, int i, int i2) {
        if (this.mPullReFreshViewImpl == null) {
            return;
        }
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.VIEW_VISIBLE_TAG, "AdaWebViewParent.initPullView changeStateHeight=" + i2);
        this.mPullReFreshViewImpl.setInterceptTouchEventEnabled(true);
        this.mPullReFreshViewImpl.setOnStateChangeListener(onStateChangeListener);
        this.mPullReFreshViewImpl.init(getContext());
        this.mPullReFreshViewImpl.setHeaderHeight(i2 > i ? i : i2);
        io.dcloud.common.adapter.ui.AdaWebViewParent.PullToRefreshWebViewExt pullToRefreshWebViewExt = this.mPullReFreshViewImpl;
        if (i <= i2) {
            i = i2;
        }
        pullToRefreshWebViewExt.setHeaderPullDownMaxHeight(i);
        this.mAdaWebview.setWebviewProperty("bounce", "none");
    }

    private void initRootView(android.content.Context context, boolean z) {
        this.webParentRootView = new io.dcloud.common.adapter.ui.WebParentView(context);
        if (z) {
            io.dcloud.common.adapter.ui.AdaWebViewParent.PullToRefreshWebViewExt pullToRefreshWebViewExt = new io.dcloud.common.adapter.ui.AdaWebViewParent.PullToRefreshWebViewExt(context);
            this.mPullReFreshViewImpl = pullToRefreshWebViewExt;
            pullToRefreshWebViewExt.setPullLoadEnabled(false);
            this.mPullReFreshViewImpl.setInterceptTouchEventEnabled(false);
            this.webParentRootView.addView(this.mPullReFreshViewImpl);
        }
        setMainView(this.webParentRootView);
    }

    void beginPullRefresh() {
        if (((io.dcloud.common.adapter.ui.AdaFrameView) this.mAdaWebview.obtainFrameView()).getCircleRefreshView() != null && ((io.dcloud.common.adapter.ui.AdaFrameView) this.mAdaWebview.obtainFrameView()).getCircleRefreshView().isRefreshEnable()) {
            ((io.dcloud.common.adapter.ui.AdaFrameView) this.mAdaWebview.obtainFrameView()).getCircleRefreshView().beginRefresh();
            return;
        }
        io.dcloud.common.adapter.ui.AdaWebViewParent.PullToRefreshWebViewExt pullToRefreshWebViewExt = this.mPullReFreshViewImpl;
        if (pullToRefreshWebViewExt != null) {
            pullToRefreshWebViewExt.beginPullRefresh();
        }
    }

    @Override // io.dcloud.common.adapter.ui.AdaContainerFrameItem, io.dcloud.common.adapter.ui.AdaFrameItem
    public void dispose() {
        super.dispose();
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
        if (adaWebview != null) {
            adaWebview.dispose();
            this.mAdaWebview = null;
        }
        this.webParentRootView = null;
        setMainView(null);
        if (this.mPullReFreshViewImpl != null) {
            this.mPullReFreshViewImpl = null;
        }
    }

    void endPullRefresh() {
        if (((io.dcloud.common.adapter.ui.AdaFrameView) this.mAdaWebview.obtainFrameView()).getCircleRefreshView() != null && ((io.dcloud.common.adapter.ui.AdaFrameView) this.mAdaWebview.obtainFrameView()).getCircleRefreshView().isRefreshEnable()) {
            ((io.dcloud.common.adapter.ui.AdaFrameView) this.mAdaWebview.obtainFrameView()).getCircleRefreshView().endRefresh();
            return;
        }
        io.dcloud.common.adapter.ui.AdaWebViewParent.PullToRefreshWebViewExt pullToRefreshWebViewExt = this.mPullReFreshViewImpl;
        if (pullToRefreshWebViewExt != null) {
            pullToRefreshWebViewExt.onPullDownRefreshComplete();
        }
    }

    void fillsWithWebview(io.dcloud.common.adapter.ui.AdaWebview adaWebview) {
        this.webParentRootView.setWebView(adaWebview);
        this.mAdaWebview = adaWebview;
        io.dcloud.common.adapter.ui.AdaWebViewParent.PullToRefreshWebViewExt pullToRefreshWebViewExt = this.mPullReFreshViewImpl;
        if (pullToRefreshWebViewExt != null) {
            pullToRefreshWebViewExt.setRefreshableView(adaWebview.obtainMainView());
            this.mPullReFreshViewImpl.addRefreshableView(this.mAdaWebview.obtainMainView());
            this.mPullReFreshViewImpl.setAppId(this.mAdaWebview.obtainApp().obtainAppId());
            getChilds().add(adaWebview);
        }
    }

    @Override // io.dcloud.common.adapter.ui.AdaContainerFrameItem, io.dcloud.common.adapter.ui.AdaFrameItem
    protected void onResize() {
        int i;
        int i2;
        io.dcloud.common.adapter.ui.AdaWebViewParent.PullToRefreshWebViewExt pullToRefreshWebViewExt;
        super.onResize();
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
        if (adaWebview != null) {
            io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = (io.dcloud.common.adapter.ui.AdaFrameView) adaWebview.obtainFrameView();
            endPullRefresh();
            io.dcloud.common.adapter.ui.RefreshView refreshView = adaFrameView.mRefreshView;
            if (refreshView != null) {
                i = refreshView.maxPullHeight;
                i2 = refreshView.changeStateHeight;
            } else {
                io.dcloud.common.adapter.ui.BounceView bounceView = adaFrameView.mBounceView;
                if (bounceView != null) {
                    i = bounceView.maxPullHeights[0];
                    i2 = bounceView.changeStateHeights[0];
                } else {
                    if (adaFrameView.getCircleRefreshView() != null && adaFrameView.getCircleRefreshView().isRefreshEnable()) {
                        com.dcloud.android.v4.widget.IRefreshAble circleRefreshView = adaFrameView.getCircleRefreshView();
                        io.dcloud.common.adapter.util.ViewOptions viewOptions = adaFrameView.mViewOptions;
                        circleRefreshView.onResize(viewOptions.width, viewOptions.height, this.mAdaWebview.getScale());
                    }
                    i = 0;
                    i2 = 0;
                }
            }
            if (i2 == 0 || i == 0 || (pullToRefreshWebViewExt = this.mPullReFreshViewImpl) == null) {
                return;
            }
            pullToRefreshWebViewExt.setHeaderHeight(i2 > i ? i : i2);
            io.dcloud.common.adapter.ui.AdaWebViewParent.PullToRefreshWebViewExt pullToRefreshWebViewExt2 = this.mPullReFreshViewImpl;
            if (i <= i2) {
                i = i2;
            }
            pullToRefreshWebViewExt2.setHeaderPullDownMaxHeight(i);
            this.mPullReFreshViewImpl.refreshLoadingViewsSize();
        }
    }

    void parseBounce(org.json.JSONObject jSONObject) {
        int i;
        int i2;
        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = (io.dcloud.common.adapter.ui.AdaFrameView) this.mAdaWebview.obtainFrameView();
        if (adaFrameView.mRefreshView != null) {
            return;
        }
        if (adaFrameView.mBounceView == null) {
            adaFrameView.mBounceView = new io.dcloud.common.adapter.ui.BounceView(adaFrameView, this.mAdaWebview);
        }
        int i3 = this.mAdaWebview.mViewOptions.height;
        if (jSONObject == null) {
            io.dcloud.common.adapter.ui.BounceView bounceView = adaFrameView.mBounceView;
            bounceView.mSupports[0] = true;
            int i4 = i3 / 3;
            bounceView.maxPullHeights[0] = i4;
            i = i4 / 2;
            bounceView.changeStateHeights[0] = i;
            i2 = i4;
        } else {
            adaFrameView.mBounceView.parseJsonOption(jSONObject);
            io.dcloud.common.adapter.ui.BounceView bounceView2 = adaFrameView.mBounceView;
            int i5 = bounceView2.maxPullHeights[0];
            i = bounceView2.changeStateHeights[0];
            i2 = i5;
        }
        int i6 = i;
        io.dcloud.common.adapter.ui.BounceView bounceView3 = adaFrameView.mBounceView;
        if (bounceView3.mSupports[0]) {
            initPullView(bounceView3, i2, i6);
        } else {
            this.mPullReFreshViewImpl.setInterceptTouchEventEnabled(false);
        }
        adaFrameView.mBounceView.checkOffset(adaFrameView, this.mPullReFreshViewImpl, jSONObject, i6, i2);
        if (!(adaFrameView.obtainMainView() instanceof com.dcloud.android.widget.AbsoluteLayout) || jSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.BOUNCE_SLIDEO_OFFSET)) {
            return;
        }
        ((com.dcloud.android.widget.AbsoluteLayout) adaFrameView.obtainMainView()).initSlideInfo(jSONObject, this.mAdaWebview.getScale(), this.mAdaWebview.obtainWindowView().getWidth());
    }

    void parsePullToReFresh(org.json.JSONObject jSONObject) {
        if (this.mPullReFreshViewImpl == null) {
            return;
        }
        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = (io.dcloud.common.adapter.ui.AdaFrameView) this.mAdaWebview.obtainFrameView();
        if (adaFrameView.mBounceView != null) {
            return;
        }
        boolean z = java.lang.Boolean.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_SUPPORT));
        java.lang.String strOptString = jSONObject != null ? jSONObject.optString("style", "default") : "default";
        if (!z) {
            this.isSetPull2Refresh = false;
            if (adaFrameView.getCircleRefreshView() != null) {
                adaFrameView.getCircleRefreshView().setRefreshEnable(false);
            }
            this.mPullReFreshViewImpl.setInterceptTouchEventEnabled(false);
            return;
        }
        this.isSetPull2Refresh = true;
        try {
            if (!"circle".equals(strOptString)) {
                if (adaFrameView.mRefreshView == null) {
                    adaFrameView.mRefreshView = new io.dcloud.common.adapter.ui.RefreshView(adaFrameView, this.mAdaWebview);
                }
                if (adaFrameView.getCircleRefreshView() != null) {
                    adaFrameView.getCircleRefreshView().setRefreshEnable(false);
                }
                adaFrameView.mRefreshView.parseJsonOption(jSONObject);
                io.dcloud.common.adapter.ui.RefreshView refreshView = adaFrameView.mRefreshView;
                initPullView(refreshView, refreshView.maxPullHeight, refreshView.changeStateHeight);
                return;
            }
            if (adaFrameView.getCircleRefreshView() == null) {
                adaFrameView.setCircleRefreshView(new com.dcloud.android.v4.widget.SwipeRefreshLayout(this.mAdaWebview.getContext(), null, false));
                adaFrameView.getCircleRefreshView().onInit(adaFrameView.obtainWebView().obtainWindowView(), adaFrameView.obtainMainViewGroup(), this.mAdaWebview.mWebViewImpl.getRefreshListener());
            }
            com.dcloud.android.v4.widget.IRefreshAble circleRefreshView = adaFrameView.getCircleRefreshView();
            io.dcloud.common.adapter.util.ViewOptions viewOptions = adaFrameView.mViewOptions;
            circleRefreshView.parseData(jSONObject, viewOptions.width, viewOptions.height, this.mAdaWebview.getScale());
            adaFrameView.getCircleRefreshView().setRefreshEnable(true);
            if (adaFrameView.mRefreshView != null) {
                this.mPullReFreshViewImpl.setInterceptTouchEventEnabled(false);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void reInit() {
        io.dcloud.common.adapter.ui.AdaWebViewParent.PullToRefreshWebViewExt pullToRefreshWebViewExt = this.mPullReFreshViewImpl;
        if (pullToRefreshWebViewExt != null) {
            pullToRefreshWebViewExt.refreshLoadingViewsSize();
        }
    }

    void resetBounce() {
        endPullRefresh();
        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = (io.dcloud.common.adapter.ui.AdaFrameView) this.mAdaWebview.obtainFrameView();
        if (adaFrameView.obtainMainView() instanceof com.dcloud.android.widget.AbsoluteLayout) {
            ((com.dcloud.android.widget.AbsoluteLayout) adaFrameView.obtainMainView()).reset();
        }
    }

    public java.lang.String toString() {
        return this.mAdaWebview.toString();
    }

    AdaWebViewParent(android.content.Context context, boolean z) {
        super(context);
        this.mPullReFreshViewImpl = null;
        this.mAdaWebview = null;
        this.isSetPull2Refresh = false;
        initRootView(context, z);
    }
}
