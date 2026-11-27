package com.taobao.weex.ui.view.listview;

/* JADX INFO: loaded from: classes.dex */
public class WXRecyclerView extends androidx.recyclerview.widget.RecyclerView implements com.taobao.weex.ui.view.gesture.WXGestureObservable {
    public static final int TYPE_GRID_LAYOUT = 2;
    public static final int TYPE_LINEAR_LAYOUT = 1;
    public static final int TYPE_STAGGERED_GRID_LAYOUT = 3;
    private com.alibaba.fastjson.JSONObject NestInfo;
    private boolean hasTouch;
    private float headerHeight;
    public boolean isNestParent;
    boolean isStartFling;
    private java.lang.Float lastY;
    androidx.recyclerview.widget.RecyclerView.OnScrollListener mChildScrollListener;
    private int mCurrentDy;
    private io.dcloud.weex.FlingHelper mFlingHelper;
    private com.taobao.weex.ui.view.gesture.WXGesture mGesture;
    private java.lang.String mInstanceId;
    androidx.recyclerview.widget.RecyclerView.OnScrollListener mParentScrollListener;
    private boolean scrollable;
    private int totalDy;
    private int velocityY;

    static /* synthetic */ int access$212(com.taobao.weex.ui.view.listview.WXRecyclerView wXRecyclerView, int i) {
        int i2 = wXRecyclerView.totalDy + i;
        wXRecyclerView.totalDy = i2;
        return i2;
    }

    public void setNestInfo(com.alibaba.fastjson.JSONObject jSONObject) {
        this.NestInfo = jSONObject;
        if (jSONObject != null) {
            this.isNestParent = jSONObject.getBooleanValue("isNestParent");
            this.mInstanceId = jSONObject.getString("instanceId");
            if (this.mFlingHelper == null) {
                this.mFlingHelper = new io.dcloud.weex.FlingHelper(getContext());
            }
            if (this.isNestParent) {
                setDescendantFocusability(131072);
                if (this.mParentScrollListener == null) {
                    this.headerHeight = jSONObject.getFloat("headerHeight").floatValue();
                    androidx.recyclerview.widget.RecyclerView.OnScrollListener onScrollListener = new androidx.recyclerview.widget.RecyclerView.OnScrollListener() { // from class: com.taobao.weex.ui.view.listview.WXRecyclerView.1
                        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                        public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i) {
                            super.onScrollStateChanged(recyclerView, i);
                            if (i == 0) {
                                com.taobao.weex.ui.view.listview.WXRecyclerView.this.mCurrentDy = 0;
                                com.taobao.weex.ui.view.listview.WXRecyclerView.this.dispatchChildFling();
                            }
                        }

                        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                        public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
                            super.onScrolled(recyclerView, i, i2);
                            com.taobao.weex.ui.view.listview.WXRecyclerView.this.mCurrentDy = i2;
                            if (com.taobao.weex.ui.view.listview.WXRecyclerView.this.isStartFling) {
                                com.taobao.weex.ui.view.listview.WXRecyclerView.this.totalDy = 0;
                                com.taobao.weex.ui.view.listview.WXRecyclerView.this.isStartFling = false;
                            }
                            com.taobao.weex.ui.view.listview.WXRecyclerView.access$212(com.taobao.weex.ui.view.listview.WXRecyclerView.this, i2);
                        }
                    };
                    this.mParentScrollListener = onScrollListener;
                    addOnScrollListener(onScrollListener);
                    return;
                }
                return;
            }
            if (this.mChildScrollListener == null) {
                androidx.recyclerview.widget.RecyclerView.OnScrollListener onScrollListener2 = new androidx.recyclerview.widget.RecyclerView.OnScrollListener() { // from class: com.taobao.weex.ui.view.listview.WXRecyclerView.2
                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i) {
                        if (i == 0) {
                            com.taobao.weex.ui.view.listview.WXRecyclerView.this.mCurrentDy = 0;
                            com.taobao.weex.ui.view.listview.WXRecyclerView.this.dispatchParentFling();
                        }
                        super.onScrollStateChanged(recyclerView, i);
                    }

                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
                        super.onScrolled(recyclerView, i, i2);
                        com.taobao.weex.ui.view.listview.WXRecyclerView.this.mCurrentDy = i2;
                        if (com.taobao.weex.ui.view.listview.WXRecyclerView.this.isStartFling) {
                            com.taobao.weex.ui.view.listview.WXRecyclerView.this.totalDy = 0;
                            com.taobao.weex.ui.view.listview.WXRecyclerView.this.isStartFling = false;
                        }
                        com.taobao.weex.ui.view.listview.WXRecyclerView.access$212(com.taobao.weex.ui.view.listview.WXRecyclerView.this, i2);
                    }
                };
                this.mChildScrollListener = onScrollListener2;
                addOnScrollListener(onScrollListener2);
            }
        }
    }

    public int getCurrentDy() {
        return this.mCurrentDy;
    }

    public void callBackNestParent(java.lang.String str, java.lang.String str2, float f) {
        com.taobao.weex.ui.view.listview.WXRecyclerView parentRecyclerView = getParentRecyclerView();
        if (parentRecyclerView != null) {
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("isNestParent", (java.lang.Object) true);
            jSONObject.put("instanceId", (java.lang.Object) str2);
            jSONObject.put("nestChildRef", (java.lang.Object) str);
            jSONObject.put("headerHeight", (java.lang.Object) java.lang.Float.valueOf(f));
            parentRecyclerView.setNestInfo(jSONObject);
        }
    }

    public WXRecyclerView(android.content.Context context) {
        super(context);
        this.scrollable = true;
        this.hasTouch = false;
        this.NestInfo = null;
        this.isNestParent = false;
        this.mCurrentDy = 0;
        this.lastY = java.lang.Float.valueOf(0.0f);
        this.totalDy = 0;
        this.velocityY = 0;
        this.headerHeight = 0.0f;
        this.isStartFling = false;
    }

    public WXRecyclerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scrollable = true;
        this.hasTouch = false;
        this.NestInfo = null;
        this.isNestParent = false;
        this.mCurrentDy = 0;
        this.lastY = java.lang.Float.valueOf(0.0f);
        this.totalDy = 0;
        this.velocityY = 0;
        this.headerHeight = 0.0f;
        this.isStartFling = false;
    }

    public boolean isScrollable() {
        return this.scrollable;
    }

    public void setScrollable(boolean z) {
        this.scrollable = z;
    }

    public void initView(android.content.Context context, int i, int i2) {
        initView(context, i, 1, 32.0f, i2);
    }

    public void initView(android.content.Context context, int i, int i2, float f, final int i3) {
        if (i == 2) {
            setLayoutManager(new androidx.recyclerview.widget.GridLayoutManager(context, i2, i3, false) { // from class: com.taobao.weex.ui.view.listview.WXRecyclerView.3
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public boolean canScrollVertically() {
                    try {
                        return com.taobao.weex.ui.view.listview.WXRecyclerView.this.canParentScrollVertically(i3, super.canScrollVertically());
                    } catch (java.lang.Exception unused) {
                        return true;
                    }
                }

                @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler recycler, androidx.recyclerview.widget.RecyclerView.State state) {
                    try {
                        super.onLayoutChildren(recycler, state);
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } else if (i == 3) {
            setLayoutManager(new com.taobao.weex.ui.view.listview.ExtendedStaggeredGridLayoutManager(i2, i3) { // from class: com.taobao.weex.ui.view.listview.WXRecyclerView.4
                @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public boolean canScrollVertically() {
                    try {
                        return com.taobao.weex.ui.view.listview.WXRecyclerView.this.canParentScrollVertically(i3, super.canScrollVertically());
                    } catch (java.lang.Exception unused) {
                        return true;
                    }
                }

                @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler recycler, androidx.recyclerview.widget.RecyclerView.State state) {
                    try {
                        super.onLayoutChildren(recycler, state);
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } else if (i == 1) {
            setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(context, i3, false) { // from class: com.taobao.weex.ui.view.listview.WXRecyclerView.5
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public boolean canScrollVertically() {
                    try {
                        return com.taobao.weex.ui.view.listview.WXRecyclerView.this.canParentScrollVertically(i3, super.canScrollVertically());
                    } catch (java.lang.Exception unused) {
                        return true;
                    }
                }

                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler recycler, androidx.recyclerview.widget.RecyclerView.State state) {
                    try {
                        super.onLayoutChildren(recycler, state);
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canParentScrollVertically(int i, boolean z) {
        if (i == 1 && i == 1) {
            try {
                if (this.NestInfo != null && this.isNestParent) {
                    com.taobao.weex.ui.view.listview.WXRecyclerView childRecylerView = getChildRecylerView();
                    if (childRecylerView == null) {
                        return true;
                    }
                    android.graphics.Rect rect = new android.graphics.Rect();
                    childRecylerView.getLocalVisibleRect(rect);
                    return childRecylerView.getHeight() - rect.bottom != 0 || childRecylerView.isScrollTop();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(com.taobao.weex.ui.view.gesture.WXGesture wXGesture) {
        this.mGesture = wXGesture;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public com.taobao.weex.ui.view.gesture.WXGesture getGestureListener() {
        return this.mGesture;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        android.view.View view;
        com.taobao.weex.ui.view.listview.WXRecyclerView childRecylerView;
        int iFloatValue;
        if (!this.scrollable) {
            return true;
        }
        if (this.NestInfo != null && this.isNestParent) {
            if (this.lastY.floatValue() == 0.0f) {
                this.lastY = java.lang.Float.valueOf(motionEvent.getY());
            }
            if (isScrollEnd() && (childRecylerView = getChildRecylerView()) != null && (iFloatValue = (int) (this.lastY.floatValue() - motionEvent.getY())) != 0) {
                childRecylerView.scrollBy(0, iFloatValue);
            }
            this.lastY = java.lang.Float.valueOf(motionEvent.getY());
        }
        if (motionEvent.getAction() == 1 && (view = (android.view.View) getParent().getParent()) != null && view.hasOnClickListeners() && (view instanceof com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) && pointInView(motionEvent.getX(), motionEvent.getY(), 0.0f) && getScrollState() == 0) {
            view.performClick();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        this.hasTouch = true;
        if (this.NestInfo != null) {
            if (this.isNestParent) {
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    this.velocityY = 0;
                    stopScroll();
                }
                if (motionEvent != null && motionEvent.getAction() != 2) {
                    this.lastY = java.lang.Float.valueOf(0.0f);
                }
            } else if (motionEvent != null && motionEvent.getAction() == 0) {
                this.velocityY = 0;
            }
        }
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        com.taobao.weex.ui.view.gesture.WXGesture wXGesture = this.mGesture;
        return wXGesture != null ? wXGesture.onTouch(this, motionEvent) | zDispatchTouchEvent : zDispatchTouchEvent;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void scrollTo(boolean z, int i, final int i2, final int i3) {
        try {
            androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = getLayoutManager();
            stopScroll();
            if (!z) {
                if (layoutManager instanceof androidx.recyclerview.widget.LinearLayoutManager) {
                    ((androidx.recyclerview.widget.LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, -i2);
                    return;
                } else {
                    if (layoutManager instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager) {
                        ((androidx.recyclerview.widget.StaggeredGridLayoutManager) layoutManager).scrollToPositionWithOffset(i, -i2);
                        return;
                    }
                    return;
                }
            }
            if (i3 == 1) {
                if (layoutManager instanceof androidx.recyclerview.widget.LinearLayoutManager) {
                    int iFindFirstVisibleItemPosition = ((androidx.recyclerview.widget.LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                    int iFindLastVisibleItemPosition = ((androidx.recyclerview.widget.LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    if (i >= iFindFirstVisibleItemPosition && i <= iFindLastVisibleItemPosition) {
                        smoothScrollBy(0, getChildAt(i - iFindFirstVisibleItemPosition).getTop() + i2);
                        return;
                    }
                } else if (layoutManager instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager) {
                    int[] iArrFindFirstVisibleItemPositions = ((androidx.recyclerview.widget.StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null);
                    int[] iArrFindLastCompletelyVisibleItemPositions = ((androidx.recyclerview.widget.StaggeredGridLayoutManager) layoutManager).findLastCompletelyVisibleItemPositions(null);
                    int i4 = iArrFindFirstVisibleItemPositions[0];
                    if (i >= i4 && i <= iArrFindLastCompletelyVisibleItemPositions[0]) {
                        smoothScrollBy(0, getChildAt(i - i4).getTop() + i2);
                        return;
                    }
                }
            }
            smoothScrollToPosition(i);
            if (i2 != 0) {
                setOnSmoothScrollEndListener(new com.taobao.weex.ui.view.listview.ExtendedLinearLayoutManager.OnSmoothScrollEndListener() { // from class: com.taobao.weex.ui.view.listview.WXRecyclerView.6
                    @Override // com.taobao.weex.ui.view.listview.ExtendedLinearLayoutManager.OnSmoothScrollEndListener
                    public void onStop() {
                        com.taobao.weex.ui.view.listview.WXRecyclerView.this.post(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.ui.view.listview.WXRecyclerView.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (i3 == 1) {
                                    com.taobao.weex.ui.view.listview.WXRecyclerView.this.smoothScrollBy(0, i2);
                                } else {
                                    com.taobao.weex.ui.view.listview.WXRecyclerView.this.smoothScrollBy(i2, 0);
                                }
                            }
                        }));
                    }
                });
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public void scrollTo(final int i, final int i2, final int i3) {
        postDelayed(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.ui.view.listview.WXRecyclerView.7
            @Override // java.lang.Runnable
            public void run() {
                int i4;
                androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = com.taobao.weex.ui.view.listview.WXRecyclerView.this.getLayoutManager();
                if (i3 == 1) {
                    i4 = i2;
                } else {
                    i4 = i;
                }
                if (layoutManager instanceof androidx.recyclerview.widget.LinearLayoutManager) {
                    ((androidx.recyclerview.widget.LinearLayoutManager) layoutManager).scrollToPositionWithOffset(0, -i4);
                } else if (layoutManager instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager) {
                    ((androidx.recyclerview.widget.StaggeredGridLayoutManager) layoutManager).scrollToPositionWithOffset(0, -i4);
                }
            }
        }), 100L);
    }

    public void setOnSmoothScrollEndListener(final com.taobao.weex.ui.view.listview.ExtendedLinearLayoutManager.OnSmoothScrollEndListener onSmoothScrollEndListener) {
        addOnScrollListener(new androidx.recyclerview.widget.RecyclerView.OnScrollListener() { // from class: com.taobao.weex.ui.view.listview.WXRecyclerView.8
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i) {
                if (i == 0) {
                    recyclerView.removeOnScrollListener(this);
                    com.taobao.weex.ui.view.listview.ExtendedLinearLayoutManager.OnSmoothScrollEndListener onSmoothScrollEndListener2 = onSmoothScrollEndListener;
                    if (onSmoothScrollEndListener2 != null) {
                        onSmoothScrollEndListener2.onStop();
                    }
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.taobao.weex.ui.view.listview.WXRecyclerView getParentRecyclerView() {
        com.taobao.weex.ui.component.list.WXListComponent listComponent;
        com.alibaba.fastjson.JSONObject jSONObject = this.NestInfo;
        if (jSONObject == null || this.isNestParent) {
            return null;
        }
        com.taobao.weex.ui.component.WXComponent wXComponentById = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponentById(this.mInstanceId, jSONObject.getString("listParentId"));
        if (wXComponentById == null || (listComponent = getListComponent(wXComponentById)) == null || listComponent.getHostView() == 0) {
            return null;
        }
        return (com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) listComponent.getHostView()).getInnerView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.taobao.weex.ui.view.listview.WXRecyclerView getChildRecylerView() {
        com.taobao.weex.ui.component.WXComponent wXComponent;
        com.taobao.weex.ui.component.list.WXListComponent listComponent;
        com.taobao.weex.ui.component.WXComponent wXComponentById;
        io.dcloud.feature.weex.extend.DCWXSlider dCWXSliderComponent;
        com.alibaba.fastjson.JSONObject jSONObject = this.NestInfo;
        if (jSONObject == null || !this.isNestParent) {
            return null;
        }
        if (jSONObject.getBooleanValue("isSwipelist")) {
            wXComponentById = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponentById(this.mInstanceId, this.NestInfo.getString("swipeId"));
            if (wXComponentById != null && (dCWXSliderComponent = getDCWXSliderComponent(wXComponentById)) != null && (dCWXSliderComponent instanceof io.dcloud.feature.weex.extend.DCWXSlider)) {
                wXComponent = wXComponentById;
                wXComponent = dCWXSliderComponent;
                wXComponent = dCWXSliderComponent;
                wXComponent = dCWXSliderComponent.getChild(dCWXSliderComponent.getCurrentIndex());
            }
        } else {
            wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(this.mInstanceId, this.NestInfo.getString("nestChildRef"));
        }
        if (wXComponent == null || (listComponent = getListComponent(wXComponent)) == null || listComponent.getHostView() == 0) {
            return null;
        }
        return (com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) listComponent.getHostView()).getInnerView();
    }

    public com.taobao.weex.ui.component.list.WXListComponent getListComponent(com.taobao.weex.ui.component.WXComponent wXComponent) {
        if (wXComponent instanceof com.taobao.weex.ui.component.list.WXListComponent) {
            return (com.taobao.weex.ui.component.list.WXListComponent) wXComponent;
        }
        if (!(wXComponent instanceof com.taobao.weex.ui.component.WXVContainer)) {
            return null;
        }
        com.taobao.weex.ui.component.WXVContainer wXVContainer = (com.taobao.weex.ui.component.WXVContainer) wXComponent;
        if (wXVContainer.getChildCount() <= 0) {
            return null;
        }
        for (int i = 0; i < wXVContainer.getChildCount(); i++) {
            com.taobao.weex.ui.component.list.WXListComponent listComponent = getListComponent(wXVContainer.getChild(i));
            if (listComponent != null) {
                return listComponent;
            }
        }
        return null;
    }

    public io.dcloud.feature.weex.extend.DCWXSlider getDCWXSliderComponent(com.taobao.weex.ui.component.WXComponent wXComponent) {
        if (wXComponent instanceof io.dcloud.feature.weex.extend.DCWXSlider) {
            return (io.dcloud.feature.weex.extend.DCWXSlider) wXComponent;
        }
        if (!(wXComponent instanceof com.taobao.weex.ui.component.WXVContainer)) {
            return null;
        }
        com.taobao.weex.ui.component.WXVContainer wXVContainer = (com.taobao.weex.ui.component.WXVContainer) wXComponent;
        if (wXVContainer.getChildCount() <= 0) {
            return null;
        }
        for (int i = 0; i < wXVContainer.getChildCount(); i++) {
            io.dcloud.feature.weex.extend.DCWXSlider dCWXSliderComponent = getDCWXSliderComponent(wXVContainer.getChild(i));
            if (dCWXSliderComponent != null) {
                return dCWXSliderComponent;
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i, int i2) {
        if (!isAttachedToWindow()) {
            return false;
        }
        boolean zFling = super.fling(i, i2);
        if (this.NestInfo != null) {
            if (this.isNestParent) {
                if (!zFling || i2 <= 0) {
                    this.velocityY = 0;
                    return zFling;
                }
                this.isStartFling = true;
                this.velocityY = i2;
                return zFling;
            }
            if (!zFling || i2 >= 0) {
                this.velocityY = 0;
            } else {
                this.isStartFling = true;
                this.velocityY = i2;
                return zFling;
            }
        }
        return zFling;
    }

    public boolean isNestScroll() {
        return this.NestInfo != null;
    }

    public boolean isScrollTop() {
        return !canScrollVertically(-1);
    }

    private boolean isScrollEnd() {
        return true ^ canScrollVertically(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchChildFling() {
        int i;
        if (isScrollEnd() && (i = this.velocityY) != 0) {
            double splineFlingDistance = this.mFlingHelper.getSplineFlingDistance(i);
            int i2 = this.totalDy;
            if (splineFlingDistance > i2) {
                childFling(this.mFlingHelper.getVelocityByDistance(splineFlingDistance - ((double) i2)));
            }
        }
        this.totalDy = 0;
        this.velocityY = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchParentFling() {
        int i;
        com.taobao.weex.ui.view.listview.WXRecyclerView parentRecyclerView = getParentRecyclerView();
        if (parentRecyclerView == null || !isScrollTop() || (i = this.velocityY) == 0) {
            return;
        }
        double splineFlingDistance = this.mFlingHelper.getSplineFlingDistance(i);
        if (splineFlingDistance > java.lang.Math.abs(this.totalDy)) {
            parentRecyclerView.fling(0, -this.mFlingHelper.getVelocityByDistance(splineFlingDistance + ((double) this.totalDy)));
        }
        this.totalDy = 0;
        this.velocityY = 0;
    }

    private void childFling(int i) {
        com.taobao.weex.ui.view.listview.WXRecyclerView childRecylerView = getChildRecylerView();
        if (childRecylerView != null) {
            childRecylerView.fling(0, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(final int i) {
        if (this.isNestParent && this.NestInfo != null) {
            com.taobao.weex.ui.view.listview.WXRecyclerView childRecylerView = getChildRecylerView();
            if (childRecylerView != null) {
                childRecylerView.scrollToPosition(i);
            }
            postDelayed(new java.lang.Runnable() { // from class: com.taobao.weex.ui.view.listview.WXRecyclerView.9
                @Override // java.lang.Runnable
                public void run() {
                    com.taobao.weex.ui.view.listview.WXRecyclerView.super.scrollToPosition(i);
                }
            }, 50L);
            return;
        }
        super.scrollToPosition(i);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(android.view.View view, android.view.View view2, int i) {
        if (!this.isNestParent || this.NestInfo == null || view2 == null || !(view2 instanceof com.taobao.weex.ui.view.listview.WXRecyclerView) || ((com.taobao.weex.ui.view.listview.WXRecyclerView) view2).isNestParent) {
            return super.onStartNestedScroll(view, view2, i);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(android.view.View view, int i, int i2, int[] iArr) {
        if (!this.isNestParent || this.NestInfo == null) {
            return;
        }
        com.taobao.weex.ui.view.listview.WXRecyclerView childRecylerView = getChildRecylerView();
        boolean z = i2 > 0 && !isScrollEnd();
        boolean z2 = i2 < 0 && childRecylerView != null && childRecylerView.isScrollTop();
        if (z || z2) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(android.view.View view, float f, float f2, boolean z) {
        if (!this.isNestParent || this.NestInfo == null) {
            return super.onNestedFling(view, f, f2, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(android.view.View view, float f, float f2) {
        if (this.isNestParent && this.NestInfo != null) {
            com.taobao.weex.ui.view.listview.WXRecyclerView childRecylerView = getChildRecylerView();
            boolean z = f2 > 0.0f && !isScrollEnd();
            boolean z2 = f2 < 0.0f && childRecylerView != null && childRecylerView.isScrollTop();
            if (!z && !z2) {
                return false;
            }
            fling(0, (int) f2);
            return true;
        }
        return super.onNestedPreFling(view, f, f2);
    }

    public boolean pointInView(float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (getRight() - getLeft())) + f3 && f2 < ((float) (getBottom() - getTop())) + f3;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        io.dcloud.common.ui.blur.AppEventForBlurManager.onScrollChanged(i, i2);
    }
}
