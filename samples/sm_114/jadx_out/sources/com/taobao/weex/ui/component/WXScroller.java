package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXScroller extends com.taobao.weex.ui.component.WXBaseScroller {
    public static final java.lang.String DIRECTION = "direction";
    private static final int SWIPE_MIN_DISTANCE = 5;
    private static final int SWIPE_THRESHOLD_VELOCITY = 300;
    private android.os.Handler handler;
    private boolean isScrollable;
    private int mActiveFeature;
    private java.util.Map<java.lang.String, com.taobao.weex.ui.component.AppearanceHelper> mAppearanceComponents;
    private int mChildrenLayoutOffset;
    private int mContentHeight;
    private int mContentWidth;
    private boolean mForceLoadmoreNextTime;
    private android.view.GestureDetector mGestureDetector;
    private boolean mHasAddScrollEvent;
    private boolean mIsHostAttachedToWindow;
    private java.lang.Boolean mIslastDirectionRTL;
    private android.graphics.Point mLastReport;
    private int mOffsetAccuracy;
    private android.view.View.OnAttachStateChangeListener mOnAttachStateChangeListener;
    protected int mOrientation;
    private android.widget.FrameLayout mRealView;
    private java.util.List<com.taobao.weex.ui.component.WXComponent> mRefreshs;
    private com.taobao.weex.ui.component.helper.ScrollStartEndHelper mScrollStartEndHelper;
    private android.widget.FrameLayout mScrollerView;
    private java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.taobao.weex.ui.component.WXComponent>> mStickyMap;
    private boolean mlastDirectionRTL;
    private boolean pageEnable;
    private int pageSize;
    private com.taobao.weex.ui.component.helper.WXStickyHelper stickyHelper;

    @Override // com.taobao.weex.ui.component.WXBaseScroller, com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
    public void onScrollStopped(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
    }

    @Override // com.taobao.weex.ui.component.WXBaseScroller, com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
    public void onScrollToBottom(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
    }

    public static class Creator implements com.taobao.weex.ui.ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public com.taobao.weex.ui.component.WXComponent createInstance(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
            wXSDKInstance.setUseScroller(true);
            return new com.taobao.weex.ui.component.WXScroller(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    @java.lang.Deprecated
    public WXScroller(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, basicComponentData);
    }

    public WXScroller(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mOrientation = 1;
        this.mRefreshs = new java.util.ArrayList();
        this.mChildrenLayoutOffset = 0;
        this.mForceLoadmoreNextTime = false;
        this.mOffsetAccuracy = 10;
        this.mLastReport = new android.graphics.Point(-1, -1);
        this.mHasAddScrollEvent = false;
        this.mActiveFeature = 0;
        this.pageSize = 0;
        this.pageEnable = false;
        this.mIsHostAttachedToWindow = false;
        this.mlastDirectionRTL = false;
        this.mAppearanceComponents = new java.util.HashMap();
        this.mStickyMap = new java.util.HashMap();
        this.mContentHeight = 0;
        this.mContentWidth = 0;
        this.handler = new android.os.Handler(android.os.Looper.getMainLooper());
        this.isScrollable = true;
        this.stickyHelper = new com.taobao.weex.ui.component.helper.WXStickyHelper(this);
        wXSDKInstance.getApmForInstance().updateDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_SCROLLER_NUM, 1.0d);
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent
    public android.view.ViewGroup getRealView() {
        return this.mScrollerView;
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent
    public void createViewImpl() {
        super.createViewImpl();
        for (int i = 0; i < this.mRefreshs.size(); i++) {
            com.taobao.weex.ui.component.WXComponent wXComponent = this.mRefreshs.get(i);
            wXComponent.createViewImpl();
            checkRefreshOrLoading(wXComponent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.component.WXBaseScroller
    public android.view.ViewGroup getInnerView() {
        if (getHostView() == 0) {
            return null;
        }
        if (getHostView() instanceof com.taobao.weex.ui.view.refresh.wrapper.BounceScrollerView) {
            return ((com.taobao.weex.ui.view.refresh.wrapper.BounceScrollerView) getHostView()).getInnerView();
        }
        return (android.view.ViewGroup) getHostView();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void addEvent(java.lang.String str) {
        super.addEvent(str);
        if (!com.taobao.weex.ui.component.helper.ScrollStartEndHelper.isScrollEvent(str) || getInnerView() == null || this.mHasAddScrollEvent) {
            return;
        }
        this.mHasAddScrollEvent = true;
        if (getInnerView() instanceof com.taobao.weex.ui.view.WXScrollView) {
            ((com.taobao.weex.ui.view.WXScrollView) getInnerView()).addScrollViewListener(new com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener() { // from class: com.taobao.weex.ui.component.WXScroller.1
                @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                public void onScroll(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
                }

                @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                public void onScrollStopped(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
                }

                @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                public void onScrollToBottom(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
                }

                @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                public void onScrollChanged(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2, int i3, int i4) {
                    com.taobao.weex.ui.component.WXScroller.this.getScrollStartEndHelper().onScrolled(i, i2);
                    if (com.taobao.weex.ui.component.WXScroller.this.getEvents().contains("scroll") && com.taobao.weex.ui.component.WXScroller.this.shouldReport(i, i2)) {
                        com.taobao.weex.ui.component.WXScroller.this.fireScrollEvent(wXScrollView.getContentFrame(), i, i2, i3, i4);
                    }
                }
            });
        } else if (getInnerView() instanceof com.taobao.weex.ui.view.WXHorizontalScrollView) {
            ((com.taobao.weex.ui.view.WXHorizontalScrollView) getInnerView()).addScrollViewListener(new com.taobao.weex.ui.view.WXHorizontalScrollView.ScrollViewListener() { // from class: com.taobao.weex.ui.component.WXScroller.2
                @Override // com.taobao.weex.ui.view.WXHorizontalScrollView.ScrollViewListener
                public void onScrollChanged(com.taobao.weex.ui.view.WXHorizontalScrollView wXHorizontalScrollView, int i, int i2, int i3, int i4) {
                    com.taobao.weex.ui.component.WXScroller.this.getScrollStartEndHelper().onScrolled(i, i2);
                    if (com.taobao.weex.ui.component.WXScroller.this.getEvents().contains("scroll") && com.taobao.weex.ui.component.WXScroller.this.shouldReport(i, i2)) {
                        com.taobao.weex.ui.component.WXScroller.this.fireScrollEvent(wXHorizontalScrollView.getContentFrame(), i, i2, i3, i4);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireScrollEvent(android.graphics.Rect rect, int i, int i2, int i3, int i4) {
        fireEvent("scroll", getScrollEvent(i, i2));
    }

    @Override // com.taobao.weex.ui.component.WXBaseScroller
    public java.util.Map<java.lang.String, java.lang.Object> getScrollEvent(int i, int i2) {
        android.graphics.Rect rect = new android.graphics.Rect();
        if (getInnerView() instanceof com.taobao.weex.ui.view.WXScrollView) {
            rect = ((com.taobao.weex.ui.view.WXScrollView) getInnerView()).getContentFrame();
        } else if (getInnerView() instanceof com.taobao.weex.ui.view.WXHorizontalScrollView) {
            rect = ((com.taobao.weex.ui.view.WXHorizontalScrollView) getInnerView()).getContentFrame();
        }
        java.util.HashMap map = new java.util.HashMap(2);
        java.util.HashMap map2 = new java.util.HashMap(2);
        java.util.HashMap map3 = new java.util.HashMap(2);
        float instanceViewPortWidthWithFloat = getInstance().getInstanceViewPortWidthWithFloat();
        map2.put("width", java.lang.Float.valueOf(com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(rect.width(), instanceViewPortWidthWithFloat)));
        map2.put("height", java.lang.Float.valueOf(com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(rect.height(), instanceViewPortWidthWithFloat)));
        map3.put(com.taobao.weex.common.Constants.Name.X, java.lang.Float.valueOf(-com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(i, instanceViewPortWidthWithFloat)));
        map3.put(com.taobao.weex.common.Constants.Name.Y, java.lang.Float.valueOf(-com.taobao.weex.utils.WXViewUtils.getWebPxByWidth(i2, instanceViewPortWidthWithFloat)));
        map.put(com.taobao.weex.common.Constants.Name.CONTENT_SIZE, map2);
        map.put(com.taobao.weex.common.Constants.Name.CONTENT_OFFSET, map3);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldReport(int i, int i2) {
        if (this.mLastReport.x == -1 && this.mLastReport.y == -1) {
            this.mLastReport.x = i;
            this.mLastReport.y = i2;
            return true;
        }
        if (this.mOrientation == 0 && java.lang.Math.abs(i - this.mLastReport.x) >= this.mOffsetAccuracy) {
            this.mLastReport.x = i;
            this.mLastReport.y = i2;
            return true;
        }
        if (this.mOrientation != 1 || java.lang.Math.abs(i2 - this.mLastReport.y) < this.mOffsetAccuracy) {
            return false;
        }
        this.mLastReport.x = i;
        this.mLastReport.y = i2;
        return true;
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void addSubView(android.view.View view, int i) {
        android.widget.FrameLayout frameLayout;
        if (view == null || (frameLayout = this.mRealView) == null || (view instanceof com.taobao.weex.ui.view.WXBaseRefreshLayout)) {
            return;
        }
        if (i >= frameLayout.getChildCount()) {
            i = -1;
        }
        if (i == -1) {
            this.mRealView.addView(view);
        } else {
            this.mRealView.addView(view, i);
        }
    }

    @Override // com.taobao.weex.ui.component.WXVContainer, io.dcloud.feature.uniapp.ui.component.AbsVContainer
    protected int getChildrenLayoutTopOffset() {
        int size;
        if (this.mChildrenLayoutOffset == 0 && (size = this.mRefreshs.size()) > 0) {
            for (int i = 0; i < size; i++) {
                this.mChildrenLayoutOffset += this.mRefreshs.get(i).getLayoutTopOffsetForSibling();
            }
        }
        return this.mChildrenLayoutOffset;
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void addChild(com.taobao.weex.ui.component.WXComponent wXComponent, int i) {
        if ((wXComponent instanceof com.taobao.weex.ui.component.WXBaseRefresh) && checkRefreshOrLoading(wXComponent)) {
            this.mRefreshs.add(wXComponent);
        }
        super.addChild(wXComponent, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean checkRefreshOrLoading(final com.taobao.weex.ui.component.WXComponent wXComponent) {
        boolean z;
        if (!(wXComponent instanceof com.taobao.weex.ui.component.WXRefresh) || getHostView() == 0) {
            z = false;
        } else {
            ((com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView) getHostView()).setOnRefreshListener((com.taobao.weex.ui.component.WXRefresh) wXComponent);
            this.handler.postDelayed(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.WXScroller.3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    ((com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView) com.taobao.weex.ui.component.WXScroller.this.getHostView()).setHeaderView(wXComponent);
                }
            }), 100L);
            z = true;
        }
        if (!(wXComponent instanceof com.taobao.weex.ui.component.WXLoading) || getHostView() == 0) {
            return z;
        }
        ((com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView) getHostView()).setOnLoadingListener((com.taobao.weex.ui.component.WXLoading) wXComponent);
        this.handler.postDelayed(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.WXScroller.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                ((com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView) com.taobao.weex.ui.component.WXScroller.this.getHostView()).setFooterView(wXComponent);
            }
        }), 100L);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void remove(com.taobao.weex.ui.component.WXComponent wXComponent, boolean z) {
        super.remove(wXComponent, z);
        if (wXComponent instanceof com.taobao.weex.ui.component.WXLoading) {
            ((com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView) getHostView()).removeFooterView(wXComponent);
        } else if (wXComponent instanceof com.taobao.weex.ui.component.WXRefresh) {
            ((com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView) getHostView()).removeHeaderView(wXComponent);
        }
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
        java.util.Map<java.lang.String, com.taobao.weex.ui.component.AppearanceHelper> map = this.mAppearanceComponents;
        if (map != null) {
            map.clear();
        }
        java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.taobao.weex.ui.component.WXComponent>> map2 = this.mStickyMap;
        if (map2 != null) {
            map2.clear();
        }
        if (this.mOnAttachStateChangeListener != null && getInnerView() != null) {
            getInnerView().removeOnAttachStateChangeListener(this.mOnAttachStateChangeListener);
        }
        if (getInnerView() == null || !(getInnerView() instanceof com.taobao.weex.ui.view.IWXScroller)) {
            return;
        }
        ((com.taobao.weex.ui.view.IWXScroller) getInnerView()).destroy();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void setMarginsSupportRTL(android.view.ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        marginLayoutParams.setMargins(i, i2, i3, i4);
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.setMarginEnd(i3);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void setLayout(com.taobao.weex.ui.component.WXComponent wXComponent) {
        if (android.text.TextUtils.isEmpty(wXComponent.getComponentType()) || android.text.TextUtils.isEmpty(wXComponent.getRef()) || wXComponent.getLayoutPosition() == null || wXComponent.getLayoutSize() == null) {
            return;
        }
        if (wXComponent.getHostView() != null) {
            androidx.core.view.ViewCompat.setLayoutDirection(wXComponent.getHostView(), wXComponent.isLayoutRTL() ? 1 : 0);
        }
        super.setLayout(wXComponent);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected com.taobao.weex.ui.component.WXComponent.MeasureOutput measure(int i, int i2) {
        com.taobao.weex.ui.component.WXComponent.MeasureOutput measureOutput = new com.taobao.weex.ui.component.WXComponent.MeasureOutput();
        if (this.mOrientation == 0) {
            int screenWidth = com.taobao.weex.utils.WXViewUtils.getScreenWidth(com.taobao.weex.WXEnvironment.sApplication);
            int weexWidth = com.taobao.weex.utils.WXViewUtils.getWeexWidth(getInstanceId());
            if (weexWidth < screenWidth) {
                screenWidth = weexWidth;
            }
            if (i > screenWidth) {
                i = -1;
            }
            measureOutput.width = i;
            measureOutput.height = i2;
            return measureOutput;
        }
        int screenHeight = com.taobao.weex.utils.WXViewUtils.getScreenHeight(com.taobao.weex.WXEnvironment.sApplication);
        int weexHeight = com.taobao.weex.utils.WXViewUtils.getWeexHeight(getInstanceId());
        if (weexHeight < screenHeight) {
            screenHeight = weexHeight;
        }
        if (i2 > screenHeight) {
            i2 = -1;
        }
        measureOutput.height = i2;
        measureOutput.width = i;
        return measureOutput;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public android.view.ViewGroup initComponentHostView(android.content.Context context) {
        java.lang.String scrollDirection;
        android.view.ViewGroup viewGroup;
        final com.taobao.weex.ui.view.WXHorizontalScrollView wXHorizontalScrollView;
        if (getAttrs().isEmpty()) {
            scrollDirection = "vertical";
        } else {
            scrollDirection = getAttrs().getScrollDirection();
            java.lang.Object obj = getAttrs().get(com.taobao.weex.common.Constants.Name.PAGE_ENABLED);
            this.pageEnable = obj != null && java.lang.Boolean.parseBoolean(obj.toString());
            java.lang.Object obj2 = getAttrs().get(com.taobao.weex.common.Constants.Name.PAGE_SIZE);
            if (obj2 != null) {
                float realPxByWidth = com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(com.taobao.weex.utils.WXUtils.getFloat(obj2), getInstance().getInstanceViewPortWidthWithFloat());
                if (realPxByWidth != 0.0f) {
                    this.pageSize = (int) realPxByWidth;
                }
            }
        }
        if (com.taobao.weex.common.Constants.Value.HORIZONTAL.equals(scrollDirection)) {
            this.mOrientation = 0;
            wXHorizontalScrollView = new com.taobao.weex.ui.view.WXHorizontalScrollView(context);
            this.mRealView = new android.widget.FrameLayout(context);
            wXHorizontalScrollView.setScrollViewListener(new com.taobao.weex.ui.view.WXHorizontalScrollView.ScrollViewListener() { // from class: com.taobao.weex.ui.component.WXScroller.5
                @Override // com.taobao.weex.ui.view.WXHorizontalScrollView.ScrollViewListener
                public void onScrollChanged(com.taobao.weex.ui.view.WXHorizontalScrollView wXHorizontalScrollView2, int i, int i2, int i3, int i4) {
                    com.taobao.weex.ui.component.WXScroller.this.procAppear(i, i2, i3, i4);
                    com.taobao.weex.ui.component.WXScroller.this.onLoadMore(wXHorizontalScrollView2, i, i2);
                }
            });
            wXHorizontalScrollView.addView(this.mRealView, new android.widget.FrameLayout.LayoutParams(-1, -1));
            wXHorizontalScrollView.setHorizontalScrollBarEnabled(false);
            this.mScrollerView = wXHorizontalScrollView;
            final android.view.View.OnLayoutChangeListener onLayoutChangeListener = new android.view.View.OnLayoutChangeListener() { // from class: com.taobao.weex.ui.component.WXScroller.6
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(android.view.View view, final int i, int i2, final int i3, int i4, final int i5, int i6, final int i7, int i8) {
                    wXHorizontalScrollView.post(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.WXScroller.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (com.taobao.weex.ui.component.WXScroller.this.mIslastDirectionRTL != null && com.taobao.weex.ui.component.WXScroller.this.isLayoutRTL() != com.taobao.weex.ui.component.WXScroller.this.mIslastDirectionRTL.booleanValue()) {
                                int scrollX = com.taobao.weex.ui.component.WXScroller.this.getScrollX();
                                int width = com.taobao.weex.ui.component.WXScroller.this.getInnerView().getChildAt(0).getWidth();
                                wXHorizontalScrollView.scrollTo((width - scrollX) - com.taobao.weex.ui.component.WXScroller.this.getInnerView().getMeasuredWidth(), this.getScrollY());
                            } else if (com.taobao.weex.ui.component.WXScroller.this.isLayoutRTL()) {
                                int i9 = (i3 - i) - (i7 - i5);
                                if (i9 != 0) {
                                    wXHorizontalScrollView.scrollBy(i9, this.getScrollY());
                                }
                            }
                            com.taobao.weex.ui.component.WXScroller.this.mIslastDirectionRTL = new java.lang.Boolean(com.taobao.weex.ui.component.WXScroller.this.isLayoutRTL());
                        }
                    });
                }
            };
            this.mRealView.addOnAttachStateChangeListener(new android.view.View.OnAttachStateChangeListener() { // from class: com.taobao.weex.ui.component.WXScroller.7
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(android.view.View view) {
                    view.addOnLayoutChangeListener(onLayoutChangeListener);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(android.view.View view) {
                    view.removeOnLayoutChangeListener(onLayoutChangeListener);
                }
            });
            if (this.pageEnable) {
                viewGroup = wXHorizontalScrollView;
                this.mGestureDetector = new android.view.GestureDetector(new com.taobao.weex.ui.component.WXScroller.MyGestureDetector(wXHorizontalScrollView));
                wXHorizontalScrollView.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.taobao.weex.ui.component.WXScroller.8
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                        if (com.taobao.weex.ui.component.WXScroller.this.pageSize == 0) {
                            com.taobao.weex.ui.component.WXScroller.this.pageSize = view.getMeasuredWidth();
                        }
                        if (com.taobao.weex.ui.component.WXScroller.this.mGestureDetector.onTouchEvent(motionEvent)) {
                            return true;
                        }
                        if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                            return false;
                        }
                        int scrollX = com.taobao.weex.ui.component.WXScroller.this.getScrollX();
                        int i = com.taobao.weex.ui.component.WXScroller.this.pageSize;
                        com.taobao.weex.ui.component.WXScroller.this.mActiveFeature = (scrollX + (i / 2)) / i;
                        wXHorizontalScrollView.smoothScrollTo(com.taobao.weex.ui.component.WXScroller.this.mActiveFeature * i, 0);
                        return true;
                    }
                });
                viewGroup = wXHorizontalScrollView;
            }
        } else {
            this.mOrientation = 1;
            com.taobao.weex.ui.view.refresh.wrapper.BounceScrollerView bounceScrollerView = new com.taobao.weex.ui.view.refresh.wrapper.BounceScrollerView(context, this.mOrientation, this);
            this.mRealView = new android.widget.FrameLayout(context);
            com.taobao.weex.ui.view.WXScrollView innerView = bounceScrollerView.getInnerView();
            innerView.addScrollViewListener(this);
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            this.mScrollerView = innerView;
            innerView.addView(this.mRealView, layoutParams);
            innerView.setVerticalScrollBarEnabled(true);
            innerView.setNestedScrollingEnabled(com.taobao.weex.utils.WXUtils.getBoolean(getAttrs().get(com.taobao.weex.common.Constants.Name.NEST_SCROLLING_ENABLED), true).booleanValue());
            innerView.addScrollViewListener(new com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener() { // from class: com.taobao.weex.ui.component.WXScroller.9
                @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                public void onScrollChanged(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2, int i3, int i4) {
                }

                @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                public void onScrollToBottom(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
                }

                @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                public void onScrollStopped(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
                    java.util.List<com.taobao.weex.common.OnWXScrollListener> wXScrollListeners = com.taobao.weex.ui.component.WXScroller.this.getInstance().getWXScrollListeners();
                    if (wXScrollListeners != null && wXScrollListeners.size() > 0) {
                        for (com.taobao.weex.common.OnWXScrollListener onWXScrollListener : wXScrollListeners) {
                            if (onWXScrollListener != null) {
                                onWXScrollListener.onScrollStateChanged(wXScrollView, i, i2, 0);
                            }
                        }
                    }
                    com.taobao.weex.ui.component.WXScroller.this.getScrollStartEndHelper().onScrollStateChanged(0);
                }

                @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                public void onScroll(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
                    java.util.List<com.taobao.weex.common.OnWXScrollListener> wXScrollListeners = com.taobao.weex.ui.component.WXScroller.this.getInstance().getWXScrollListeners();
                    if (wXScrollListeners == null || wXScrollListeners.size() <= 0) {
                        return;
                    }
                    for (com.taobao.weex.common.OnWXScrollListener onWXScrollListener : wXScrollListeners) {
                        if (onWXScrollListener != null) {
                            if (onWXScrollListener instanceof com.taobao.weex.common.ICheckBindingScroller) {
                                if (((com.taobao.weex.common.ICheckBindingScroller) onWXScrollListener).isNeedScroller(com.taobao.weex.ui.component.WXScroller.this.getRef(), null)) {
                                    onWXScrollListener.onScrolled(wXScrollView, i, i2);
                                }
                            } else {
                                onWXScrollListener.onScrolled(wXScrollView, i, i2);
                            }
                        }
                    }
                }
            });
            viewGroup = bounceScrollerView;
        }
        viewGroup = wXHorizontalScrollView;
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.taobao.weex.ui.component.WXScroller.10
            /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View] */
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                com.taobao.weex.ui.component.WXScroller.this.procAppear(0, 0, 0, 0);
                ?? hostView = com.taobao.weex.ui.component.WXScroller.this.getHostView();
                if (hostView == 0) {
                    return;
                }
                hostView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        android.view.View.OnAttachStateChangeListener onAttachStateChangeListener = new android.view.View.OnAttachStateChangeListener() { // from class: com.taobao.weex.ui.component.WXScroller.11
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(android.view.View view) {
                com.taobao.weex.ui.component.WXScroller.this.mIsHostAttachedToWindow = true;
                com.taobao.weex.ui.component.WXScroller wXScroller = com.taobao.weex.ui.component.WXScroller.this;
                wXScroller.procAppear(wXScroller.getScrollX(), com.taobao.weex.ui.component.WXScroller.this.getScrollY(), com.taobao.weex.ui.component.WXScroller.this.getScrollX(), com.taobao.weex.ui.component.WXScroller.this.getScrollY());
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(android.view.View view) {
                com.taobao.weex.ui.component.WXScroller.this.mIsHostAttachedToWindow = false;
                com.taobao.weex.ui.component.WXScroller.this.dispatchDisappearEvent();
            }
        };
        this.mOnAttachStateChangeListener = onAttachStateChangeListener;
        viewGroup.addOnAttachStateChangeListener(onAttachStateChangeListener);
        return viewGroup;
    }

    @Override // com.taobao.weex.ui.component.WXBaseScroller, com.taobao.weex.ui.component.Scrollable
    public int getScrollY() {
        if (getInnerView() == null) {
            return 0;
        }
        return getInnerView().getScrollY();
    }

    @Override // com.taobao.weex.ui.component.WXBaseScroller, com.taobao.weex.ui.component.Scrollable
    public int getScrollX() {
        if (getInnerView() == null) {
            return 0;
        }
        return getInnerView().getScrollX();
    }

    @Override // com.taobao.weex.ui.component.WXBaseScroller, com.taobao.weex.ui.component.Scrollable
    public int getOrientation() {
        return this.mOrientation;
    }

    @Override // com.taobao.weex.ui.component.WXBaseScroller
    public java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.taobao.weex.ui.component.WXComponent>> getStickMap() {
        return this.mStickyMap;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        switch (str) {
            case "showScrollbar":
                java.lang.Boolean bool = com.taobao.weex.utils.WXUtils.getBoolean(obj, null);
                if (bool != null) {
                    setShowScrollbar(bool.booleanValue());
                }
                return true;
            case "offsetAccuracy":
                setOffsetAccuracy(com.taobao.weex.utils.WXUtils.getInteger(obj, 10).intValue());
                return true;
            case "scrollable":
                setScrollable(com.taobao.weex.utils.WXUtils.getBoolean(obj, true).booleanValue());
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.SHOW_SCROLLBAR)
    public void setShowScrollbar(boolean z) {
        if (getInnerView() == null) {
            return;
        }
        if (this.mOrientation == 1) {
            getInnerView().setVerticalScrollBarEnabled(z);
        } else {
            getInnerView().setHorizontalScrollBarEnabled(z);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.SCROLLABLE)
    public void setScrollable(boolean z) {
        this.isScrollable = z;
        android.view.ViewGroup innerView = getInnerView();
        if (innerView instanceof com.taobao.weex.ui.view.WXHorizontalScrollView) {
            ((com.taobao.weex.ui.view.WXHorizontalScrollView) innerView).setScrollable(z);
        } else if (innerView instanceof com.taobao.weex.ui.view.WXScrollView) {
            ((com.taobao.weex.ui.view.WXScrollView) innerView).setScrollable(z);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.OFFSET_ACCURACY)
    public void setOffsetAccuracy(int i) {
        this.mOffsetAccuracy = (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(i, getInstance().getInstanceViewPortWidthWithFloat());
    }

    @Override // com.taobao.weex.ui.component.WXBaseScroller, com.taobao.weex.ui.component.Scrollable
    public boolean isScrollable() {
        return this.isScrollable;
    }

    @Override // com.taobao.weex.ui.component.WXBaseScroller, com.taobao.weex.ui.component.Scrollable
    public void bindStickStyle(com.taobao.weex.ui.component.WXComponent wXComponent) {
        this.stickyHelper.bindStickStyle(wXComponent, this.mStickyMap);
    }

    @Override // com.taobao.weex.ui.component.WXBaseScroller, com.taobao.weex.ui.component.Scrollable
    public void unbindStickStyle(com.taobao.weex.ui.component.WXComponent wXComponent) {
        this.stickyHelper.unbindStickStyle(wXComponent, this.mStickyMap);
    }

    @Override // com.taobao.weex.ui.component.WXBaseScroller, com.taobao.weex.ui.component.Scrollable
    public void bindAppearEvent(com.taobao.weex.ui.component.WXComponent wXComponent) {
        setWatch(0, wXComponent, true);
    }

    private void setWatch(int i, com.taobao.weex.ui.component.WXComponent wXComponent, boolean z) {
        com.taobao.weex.ui.component.AppearanceHelper appearanceHelper = this.mAppearanceComponents.get(wXComponent.getRef());
        if (appearanceHelper == null) {
            appearanceHelper = new com.taobao.weex.ui.component.AppearanceHelper(wXComponent);
            this.mAppearanceComponents.put(wXComponent.getRef(), appearanceHelper);
        }
        appearanceHelper.setWatchEvent(i, z);
        procAppear(0, 0, 0, 0);
    }

    @Override // com.taobao.weex.ui.component.WXBaseScroller, com.taobao.weex.ui.component.Scrollable
    public void bindDisappearEvent(com.taobao.weex.ui.component.WXComponent wXComponent) {
        setWatch(1, wXComponent, true);
    }

    @Override // com.taobao.weex.ui.component.WXBaseScroller, com.taobao.weex.ui.component.Scrollable
    public void unbindAppearEvent(com.taobao.weex.ui.component.WXComponent wXComponent) {
        setWatch(0, wXComponent, false);
    }

    @Override // com.taobao.weex.ui.component.WXBaseScroller, com.taobao.weex.ui.component.Scrollable
    public void unbindDisappearEvent(com.taobao.weex.ui.component.WXComponent wXComponent) {
        setWatch(1, wXComponent, false);
    }

    @Override // com.taobao.weex.ui.component.WXBaseScroller, com.taobao.weex.ui.component.Scrollable
    public void scrollTo(com.taobao.weex.ui.component.WXComponent wXComponent, java.util.Map<java.lang.String, java.lang.Object> map) {
        int absoluteX;
        float realPxByWidth = 0.0f;
        boolean zBooleanValue = true;
        if (map != null) {
            java.lang.String string = map.get("offset") == null ? com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT : map.get("offset").toString();
            zBooleanValue = com.taobao.weex.utils.WXUtils.getBoolean(map.get(com.taobao.weex.common.Constants.Name.ANIMATED), true).booleanValue();
            if (string != null) {
                try {
                    realPxByWidth = com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(java.lang.Float.parseFloat(string), getInstance().getInstanceViewPortWidthWithFloat());
                } catch (java.lang.Exception e) {
                    com.taobao.weex.utils.WXLogUtils.e("Float parseFloat error :" + e.getMessage());
                }
            }
        }
        if (this.pageEnable) {
            this.mActiveFeature = this.mChildren.indexOf(wXComponent);
        }
        int absoluteY = wXComponent.getAbsoluteY() - getAbsoluteY();
        if (isLayoutRTL()) {
            if (wXComponent.getParent() != null && wXComponent.getParent() == this) {
                if (getInnerView().getChildCount() > 0) {
                    absoluteX = (getInnerView().getChildAt(0).getWidth() - (wXComponent.getAbsoluteX() - getAbsoluteX())) - getInnerView().getMeasuredWidth();
                } else {
                    absoluteX = wXComponent.getAbsoluteX() - getAbsoluteX();
                }
            } else {
                absoluteX = ((wXComponent.getAbsoluteX() - getAbsoluteX()) - getInnerView().getMeasuredWidth()) + ((int) wXComponent.getLayoutWidth());
            }
            realPxByWidth = -realPxByWidth;
        } else {
            absoluteX = wXComponent.getAbsoluteX() - getAbsoluteX();
        }
        int i = (int) realPxByWidth;
        scrollBy((absoluteX - getScrollX()) + i, (absoluteY - getScrollY()) + i, zBooleanValue);
    }

    public void scrollBy(int i, int i2) {
        scrollBy(i, i2, false);
    }

    public void scrollBy(final int i, final int i2, final boolean z) {
        if (getInnerView() == null) {
            return;
        }
        getInnerView().postDelayed(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.WXScroller.12
            @Override // java.lang.Runnable
            public void run() {
                if (com.taobao.weex.ui.component.WXScroller.this.mOrientation == 1) {
                    if (z) {
                        ((com.taobao.weex.ui.view.WXScrollView) com.taobao.weex.ui.component.WXScroller.this.getInnerView()).smoothScrollBy(0, i2);
                    } else {
                        ((com.taobao.weex.ui.view.WXScrollView) com.taobao.weex.ui.component.WXScroller.this.getInnerView()).scrollBy(0, i2);
                    }
                } else if (z) {
                    ((com.taobao.weex.ui.view.WXHorizontalScrollView) com.taobao.weex.ui.component.WXScroller.this.getInnerView()).smoothScrollBy(i, 0);
                } else {
                    ((com.taobao.weex.ui.view.WXHorizontalScrollView) com.taobao.weex.ui.component.WXScroller.this.getInnerView()).scrollBy(i, 0);
                }
                com.taobao.weex.ui.component.WXScroller.this.getInnerView().invalidate();
            }
        }, 16L);
    }

    @Override // com.taobao.weex.ui.component.WXBaseScroller, com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
    public void onScrollChanged(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2, int i3, int i4) {
        procAppear(i, i2, i3, i4);
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent
    public void notifyAppearStateChange(java.lang.String str, java.lang.String str2) {
        if (containsEvent(com.taobao.weex.common.Constants.Event.APPEAR) || containsEvent(com.taobao.weex.common.Constants.Event.DISAPPEAR)) {
            java.util.HashMap map = new java.util.HashMap();
            map.put("direction", str2);
            fireEvent(str, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void procAppear(int i, int i2, int i3, int i4) {
        java.lang.String str;
        int appearStatus;
        if (this.mIsHostAttachedToWindow) {
            int i5 = i2 - i4;
            int i6 = i - i3;
            if (i5 > 0) {
                str = "up";
            } else {
                str = i5 < 0 ? "down" : null;
            }
            if (this.mOrientation == 0 && i6 != 0) {
                str = i6 > 0 ? "right" : "left";
            }
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.taobao.weex.ui.component.AppearanceHelper>> it = this.mAppearanceComponents.entrySet().iterator();
            while (it.hasNext()) {
                com.taobao.weex.ui.component.AppearanceHelper value = it.next().getValue();
                if (value.isWatch() && (appearStatus = value.setAppearStatus(checkItemVisibleInScroller(value.getAwareChild()))) != 0) {
                    value.getAwareChild().notifyAppearStateChange(appearStatus == 1 ? com.taobao.weex.common.Constants.Event.APPEAR : com.taobao.weex.common.Constants.Event.DISAPPEAR, str);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0036  */
    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    private boolean checkItemVisibleInScroller(com.taobao.weex.ui.component.WXComponent wXComponent) {
        boolean z = false;
        while (wXComponent != null && !(wXComponent instanceof com.taobao.weex.ui.component.WXScroller)) {
            if (wXComponent.getParent() instanceof com.taobao.weex.ui.component.WXScroller) {
                if (this.mOrientation == 0) {
                    float left = ((int) wXComponent.getLayoutPosition().getLeft()) - getScrollX();
                    if (left <= 0.0f - wXComponent.getLayoutWidth() || left >= getLayoutWidth()) {
                        z = false;
                    } else {
                        z = true;
                    }
                } else {
                    float top = ((int) wXComponent.getLayoutPosition().getTop()) - getScrollY();
                    if (top <= 0.0f - wXComponent.getLayoutHeight() || top >= getLayoutHeight()) {
                        z = false;
                    } else {
                        z = true;
                    }
                }
            }
            wXComponent = wXComponent.getParent();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchDisappearEvent() {
        int appearStatus;
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.taobao.weex.ui.component.AppearanceHelper>> it = this.mAppearanceComponents.entrySet().iterator();
        while (it.hasNext()) {
            com.taobao.weex.ui.component.AppearanceHelper value = it.next().getValue();
            if (value.isWatch() && (appearStatus = value.setAppearStatus(false)) != 0) {
                value.getAwareChild().notifyAppearStateChange(appearStatus == 1 ? com.taobao.weex.common.Constants.Event.APPEAR : com.taobao.weex.common.Constants.Event.DISAPPEAR, "");
            }
        }
    }

    @Override // com.taobao.weex.ui.component.WXBaseScroller, com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
    public void onScroll(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
        onLoadMore(wXScrollView, i, i2);
    }

    protected void onLoadMore(android.widget.FrameLayout frameLayout, int i, int i2) {
        try {
            java.lang.String loadMoreOffset = getAttrs().getLoadMoreOffset();
            if (android.text.TextUtils.isEmpty(loadMoreOffset)) {
                loadMoreOffset = java.lang.String.valueOf(1);
            }
            int realPxByWidth = (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(java.lang.Float.parseFloat(loadMoreOffset), getInstance().getInstanceViewPortWidthWithFloat());
            if (frameLayout instanceof com.taobao.weex.ui.view.WXHorizontalScrollView) {
                int width = frameLayout.getChildAt(0).getWidth();
                if ((width - i) - frameLayout.getWidth() < realPxByWidth) {
                    if (this.mContentWidth != width || this.mForceLoadmoreNextTime) {
                        fireEvent(com.taobao.weex.common.Constants.Event.LOADMORE);
                        this.mContentWidth = width;
                        this.mForceLoadmoreNextTime = false;
                        return;
                    }
                    return;
                }
                return;
            }
            int height = frameLayout.getChildAt(0).getHeight();
            int height2 = (height - i2) - frameLayout.getHeight();
            if (height2 < realPxByWidth) {
                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    com.taobao.weex.utils.WXLogUtils.d("[WXScroller-onScroll] offScreenY :" + height2);
                }
                if (this.mContentHeight != height || this.mForceLoadmoreNextTime) {
                    fireEvent(com.taobao.weex.common.Constants.Event.LOADMORE);
                    this.mContentHeight = height;
                    this.mForceLoadmoreNextTime = false;
                }
            }
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.d("[WXScroller-onScroll] ", e);
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void resetLoadmore() {
        this.mForceLoadmoreNextTime = true;
    }

    public com.taobao.weex.ui.component.helper.ScrollStartEndHelper getScrollStartEndHelper() {
        if (this.mScrollStartEndHelper == null) {
            this.mScrollStartEndHelper = new com.taobao.weex.ui.component.helper.ScrollStartEndHelper(this);
        }
        return this.mScrollStartEndHelper;
    }

    class MyGestureDetector extends android.view.GestureDetector.SimpleOnGestureListener {
        private final com.taobao.weex.ui.view.WXHorizontalScrollView scrollView;

        public com.taobao.weex.ui.view.WXHorizontalScrollView getScrollView() {
            return this.scrollView;
        }

        MyGestureDetector(com.taobao.weex.ui.view.WXHorizontalScrollView wXHorizontalScrollView) {
            this.scrollView = wXHorizontalScrollView;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
            int size = com.taobao.weex.ui.component.WXScroller.this.mChildren.size();
            try {
                if (motionEvent.getX() - motionEvent2.getX() <= 5.0f || java.lang.Math.abs(f) <= 300.0f) {
                    if (motionEvent2.getX() - motionEvent.getX() > 5.0f && java.lang.Math.abs(f) > 300.0f) {
                        int i = com.taobao.weex.ui.component.WXScroller.this.pageSize;
                        com.taobao.weex.ui.component.WXScroller wXScroller = com.taobao.weex.ui.component.WXScroller.this;
                        wXScroller.mActiveFeature = wXScroller.mActiveFeature > 0 ? com.taobao.weex.ui.component.WXScroller.this.mActiveFeature - 1 : 0;
                        this.scrollView.smoothScrollTo(com.taobao.weex.ui.component.WXScroller.this.mActiveFeature * i, 0);
                        return true;
                    }
                    return false;
                }
                int i2 = com.taobao.weex.ui.component.WXScroller.this.pageSize;
                com.taobao.weex.ui.component.WXScroller wXScroller2 = com.taobao.weex.ui.component.WXScroller.this;
                int i3 = size - 1;
                if (wXScroller2.mActiveFeature < i3) {
                    i3 = com.taobao.weex.ui.component.WXScroller.this.mActiveFeature + 1;
                }
                wXScroller2.mActiveFeature = i3;
                this.scrollView.smoothScrollTo(com.taobao.weex.ui.component.WXScroller.this.mActiveFeature * i2, 0);
                return true;
            } catch (java.lang.Exception e) {
                com.taobao.weex.utils.WXLogUtils.e("There was an error processing the Fling event:" + e.getMessage());
            }
        }
    }
}
