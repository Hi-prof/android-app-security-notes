package com.taobao.weex.ui.view.refresh.core;

/* JADX INFO: loaded from: classes.dex */
public class WXSwipeLayout extends android.widget.FrameLayout implements androidx.core.view.NestedScrollingParent, androidx.core.view.NestedScrollingChild {
    private static final float DAMPING = 0.4f;
    private static final int INVALID = -1;
    private static final int LOAD_MORE = 1;
    private static final int PULL_REFRESH = 0;
    private static final float overFlow = 1.0f;
    private com.taobao.weex.ui.view.refresh.core.WXRefreshView footerView;
    private com.taobao.weex.ui.view.refresh.core.WXRefreshView headerView;
    private boolean isConfirm;
    private volatile float loadingViewFlowHeight;
    private volatile float loadingViewHeight;
    private int mCurrentAction;
    private android.view.ViewParent mNestedScrollAcceptedParent;
    private boolean mNestedScrollInProgress;
    private androidx.core.view.NestedScrollingChildHelper mNestedScrollingChildHelper;
    private androidx.core.view.NestedScrollingParentHelper mNestedScrollingParentHelper;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    private int mProgressBgColor;
    private int mProgressColor;
    private boolean mPullLoadEnable;
    private boolean mPullRefreshEnable;
    private final java.util.List<com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.OnRefreshOffsetChangedListener> mRefreshOffsetChangedListeners;
    private int mRefreshViewBgColor;
    private volatile boolean mRefreshing;
    private android.view.View mTargetView;
    private com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXOnLoadingListener onLoadingListener;
    private com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXOnRefreshListener onRefreshListener;
    private volatile float refreshViewFlowHeight;
    private volatile float refreshViewHeight;

    public interface OnRefreshOffsetChangedListener {
        void onOffsetChanged(int i);
    }

    public interface WXOnLoadingListener {
        void onLoading();

        void onPullingUp(float f, int i, float f2);
    }

    public interface WXOnRefreshListener {
        void onPullingDown(float f, int i, float f2);

        void onRefresh();
    }

    static class WXRefreshAnimatorListener implements android.animation.Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
        }

        WXRefreshAnimatorListener() {
        }
    }

    public WXSwipeLayout(android.content.Context context) {
        super(context);
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mRefreshOffsetChangedListeners = new java.util.LinkedList();
        this.mPullRefreshEnable = false;
        this.mPullLoadEnable = false;
        this.mRefreshing = false;
        this.refreshViewHeight = 0.0f;
        this.loadingViewHeight = 0.0f;
        this.refreshViewFlowHeight = 0.0f;
        this.loadingViewFlowHeight = 0.0f;
        this.mCurrentAction = -1;
        this.isConfirm = false;
        initAttrs(context, null);
    }

    public WXSwipeLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mRefreshOffsetChangedListeners = new java.util.LinkedList();
        this.mPullRefreshEnable = false;
        this.mPullLoadEnable = false;
        this.mRefreshing = false;
        this.refreshViewHeight = 0.0f;
        this.loadingViewHeight = 0.0f;
        this.refreshViewFlowHeight = 0.0f;
        this.loadingViewFlowHeight = 0.0f;
        this.mCurrentAction = -1;
        this.isConfirm = false;
        initAttrs(context, attributeSet);
    }

    public WXSwipeLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mRefreshOffsetChangedListeners = new java.util.LinkedList();
        this.mPullRefreshEnable = false;
        this.mPullLoadEnable = false;
        this.mRefreshing = false;
        this.refreshViewHeight = 0.0f;
        this.loadingViewHeight = 0.0f;
        this.refreshViewFlowHeight = 0.0f;
        this.loadingViewFlowHeight = 0.0f;
        this.mCurrentAction = -1;
        this.isConfirm = false;
        initAttrs(context, attributeSet);
    }

    public WXSwipeLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mRefreshOffsetChangedListeners = new java.util.LinkedList();
        this.mPullRefreshEnable = false;
        this.mPullLoadEnable = false;
        this.mRefreshing = false;
        this.refreshViewHeight = 0.0f;
        this.loadingViewHeight = 0.0f;
        this.refreshViewFlowHeight = 0.0f;
        this.loadingViewFlowHeight = 0.0f;
        this.mCurrentAction = -1;
        this.isConfirm = false;
        initAttrs(context, attributeSet);
    }

    private void initAttrs(android.content.Context context, android.util.AttributeSet attributeSet) {
        if (getChildCount() > 1) {
            throw new java.lang.RuntimeException("WXSwipeLayout should not have more than one child");
        }
        this.mNestedScrollingParentHelper = new androidx.core.view.NestedScrollingParentHelper(this);
        this.mNestedScrollingChildHelper = new androidx.core.view.NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(false);
        if (isInEditMode() && attributeSet == null) {
            return;
        }
        this.mRefreshViewBgColor = 0;
        this.mProgressBgColor = 0;
        this.mProgressColor = -65536;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mTargetView == null && getChildCount() > 0) {
            this.mTargetView = getChildAt(0);
        }
        if (this.mTargetView != null) {
            if (this.headerView == null || this.footerView == null) {
                setRefreshView();
            }
        }
    }

    public void addTargetView(android.view.View view) {
        addView(view, new android.widget.FrameLayout.LayoutParams(-1, -1));
        setRefreshView();
    }

    private void setRefreshView() {
        android.view.ViewGroup.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, 0);
        com.taobao.weex.ui.view.refresh.core.WXRefreshView wXRefreshView = new com.taobao.weex.ui.view.refresh.core.WXRefreshView(getContext());
        this.headerView = wXRefreshView;
        wXRefreshView.setStartEndTrim(0.0f, 0.75f);
        this.headerView.setBackgroundColor(this.mRefreshViewBgColor);
        this.headerView.setProgressBgColor(this.mProgressBgColor);
        this.headerView.setProgressColor(this.mProgressColor);
        this.headerView.setContentGravity(80);
        addView(this.headerView, layoutParams);
        android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(-1, 0);
        layoutParams2.gravity = 80;
        com.taobao.weex.ui.view.refresh.core.WXRefreshView wXRefreshView2 = new com.taobao.weex.ui.view.refresh.core.WXRefreshView(getContext());
        this.footerView = wXRefreshView2;
        wXRefreshView2.setStartEndTrim(0.5f, 1.25f);
        this.footerView.setBackgroundColor(this.mRefreshViewBgColor);
        this.footerView.setProgressBgColor(this.mProgressBgColor);
        this.footerView.setProgressColor(this.mProgressColor);
        this.footerView.setContentGravity(48);
        addView(this.footerView, layoutParams2);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if ((!this.mPullRefreshEnable && !this.mPullLoadEnable) || !isEnabled() || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.mNestedScrollingChildHelper.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        boolean zStartNestedScroll = this.mNestedScrollingChildHelper.startNestedScroll(i);
        if (zStartNestedScroll && this.mNestedScrollAcceptedParent == null) {
            android.view.View view = this;
            for (android.view.ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                if (androidx.core.view.ViewParentCompat.onStartNestedScroll(parent, view, this, i)) {
                    this.mNestedScrollAcceptedParent = parent;
                    return zStartNestedScroll;
                }
                if (parent instanceof android.view.View) {
                    view = (android.view.View) parent;
                }
            }
        }
        return zStartNestedScroll;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.stopNestedScroll();
        if (this.mNestedScrollAcceptedParent != null) {
            this.mNestedScrollAcceptedParent = null;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(android.view.View view, float f, float f2) {
        if (isNestedScrollingEnabled()) {
            return dispatchNestedPreFling(f, f2);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(android.view.View view, float f, float f2, boolean z) {
        if (isNestedScrollingEnabled()) {
            return dispatchNestedFling(f, f2, z);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(android.view.View view, android.view.View view2, int i) {
        boolean z = (!isEnabled() || this.mRefreshing || (i & 2) == 0) ? false : true;
        if (view2 instanceof com.taobao.weex.ui.view.listview.WXRecyclerView) {
            com.taobao.weex.ui.view.listview.WXRecyclerView wXRecyclerView = (com.taobao.weex.ui.view.listview.WXRecyclerView) view2;
            if (wXRecyclerView.isNestScroll()) {
                return z && wXRecyclerView.isScrollTop();
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(android.view.View view, android.view.View view2, int i) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i);
        if (isNestedScrollingEnabled()) {
            startNestedScroll(i & 2);
            this.mNestedScrollInProgress = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(android.view.View view, int i, int i2, int[] iArr) {
        android.view.ViewParent viewParent;
        int[] iArr2 = this.mParentScrollConsumed;
        if (isNestedScrollingEnabled() && dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
            return;
        }
        if (this.mPullRefreshEnable || this.mPullLoadEnable) {
            if (!canChildScrollUp() && isNestedScrollingEnabled() && (viewParent = this.mNestedScrollAcceptedParent) != null && viewParent != this.mTargetView) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) viewParent;
                if (viewGroup.getChildCount() > 0) {
                    int childCount = viewGroup.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        android.view.View childAt = viewGroup.getChildAt(i3);
                        if (childAt.getVisibility() != 8 && childAt.getMeasuredHeight() > 0) {
                            if (childAt.getTop() >= 0) {
                                break;
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
            int iCalculateDistanceY = (int) calculateDistanceY(view, i2);
            this.mRefreshing = false;
            if (!this.isConfirm) {
                if (iCalculateDistanceY < 0 && !canChildScrollUp()) {
                    this.mCurrentAction = 0;
                    this.isConfirm = true;
                } else if (iCalculateDistanceY > 0 && !canChildScrollDown() && !this.mRefreshing) {
                    this.mCurrentAction = 1;
                    this.isConfirm = true;
                }
            }
            if (moveSpinner(-iCalculateDistanceY)) {
                if (!canChildScrollUp() && this.mPullRefreshEnable && this.mTargetView.getTranslationY() > 0.0f && i2 > 0) {
                    iArr[1] = iArr[1] + i2;
                    return;
                }
                if (!canChildScrollDown() && this.mPullLoadEnable && this.mTargetView.getTranslationY() < 0.0f && i2 < 0) {
                    iArr[1] = iArr[1] + i2;
                } else {
                    iArr[1] = iArr[1] + iCalculateDistanceY;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(android.view.View view) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view);
        handlerAction();
        if (isNestedScrollingEnabled()) {
            this.mNestedScrollInProgress = true;
            stopNestedScroll();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(android.view.View view, int i, int i2, int i3, int i4) {
        if (isNestedScrollingEnabled()) {
            dispatchNestedScroll(i, i2, i3, i4, this.mParentOffsetInWindow);
        }
    }

    private double calculateDistanceY(android.view.View view, int i) {
        int measuredHeight = view.getMeasuredHeight();
        double dAbs = ((((double) (measuredHeight - java.lang.Math.abs(view.getY()))) / 1.0d) / ((double) measuredHeight)) * 0.4000000059604645d;
        if (dAbs <= 0.01d) {
            dAbs = 0.01d;
        }
        return dAbs * ((double) i);
    }

    private boolean moveSpinner(float f) {
        if (this.mRefreshing) {
            return false;
        }
        if (!canChildScrollUp() && this.mPullRefreshEnable && this.mCurrentAction == 0) {
            android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.headerView.getLayoutParams();
            layoutParams.height = (int) (layoutParams.height + f);
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            if (layoutParams.height == 0) {
                this.isConfirm = false;
                this.mCurrentAction = -1;
            }
            this.headerView.setLayoutParams(layoutParams);
            this.onRefreshListener.onPullingDown(f, layoutParams.height, this.refreshViewFlowHeight);
            notifyOnRefreshOffsetChangedListener(layoutParams.height);
            this.headerView.setProgressRotation(layoutParams.height / this.refreshViewFlowHeight);
            moveTargetView(layoutParams.height);
            return true;
        }
        if (canChildScrollDown() || !this.mPullLoadEnable || this.mCurrentAction != 1) {
            return false;
        }
        android.widget.FrameLayout.LayoutParams layoutParams2 = (android.widget.FrameLayout.LayoutParams) this.footerView.getLayoutParams();
        layoutParams2.height = (int) (layoutParams2.height - f);
        if (layoutParams2.height < 0) {
            layoutParams2.height = 0;
        }
        if (layoutParams2.height == 0) {
            this.isConfirm = false;
            this.mCurrentAction = -1;
        }
        this.footerView.setLayoutParams(layoutParams2);
        this.onLoadingListener.onPullingUp(f, layoutParams2.height, this.loadingViewFlowHeight);
        this.footerView.setProgressRotation(layoutParams2.height / this.loadingViewFlowHeight);
        moveTargetView(-layoutParams2.height);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveTargetView(float f) {
        this.mTargetView.setTranslationY(f);
    }

    private void handlerAction() {
        if (isRefreshing()) {
            return;
        }
        this.isConfirm = false;
        if (this.mPullRefreshEnable && this.mCurrentAction == 0) {
            android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.headerView.getLayoutParams();
            if (layoutParams.height >= this.refreshViewHeight) {
                startRefresh(layoutParams.height);
            } else if (layoutParams.height > 0) {
                resetHeaderView(layoutParams.height);
            } else {
                resetRefreshState();
            }
        }
        if (this.mPullLoadEnable && this.mCurrentAction == 1) {
            android.widget.FrameLayout.LayoutParams layoutParams2 = (android.widget.FrameLayout.LayoutParams) this.footerView.getLayoutParams();
            if (layoutParams2.height >= this.loadingViewHeight) {
                startLoadmore(layoutParams2.height);
            } else if (layoutParams2.height > 0) {
                resetFootView(layoutParams2.height);
            } else {
                resetLoadmoreState();
            }
        }
    }

    private void startRefresh(int i) {
        this.mRefreshing = true;
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(i, this.refreshViewHeight);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.headerView.getLayoutParams();
                layoutParams.height = (int) ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.notifyOnRefreshOffsetChangedListener(layoutParams.height);
                com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.headerView.setLayoutParams(layoutParams);
                com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.moveTargetView(layoutParams.height);
            }
        });
        valueAnimatorOfFloat.addListener(new com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXRefreshAnimatorListener() { // from class: com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.2
            @Override // com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXRefreshAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.headerView.startAnimation();
                if (com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.onRefreshListener != null) {
                    com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.onRefreshListener.onRefresh();
                }
            }
        });
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.start();
    }

    private void resetHeaderView(int i) {
        this.headerView.stopAnimation();
        this.headerView.setStartEndTrim(0.0f, 0.75f);
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(i, 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.headerView.getLayoutParams();
                layoutParams.height = (int) ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.notifyOnRefreshOffsetChangedListener(layoutParams.height);
                com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.headerView.setLayoutParams(layoutParams);
                com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.moveTargetView(layoutParams.height);
            }
        });
        valueAnimatorOfFloat.addListener(new com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXRefreshAnimatorListener() { // from class: com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.4
            @Override // com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXRefreshAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.resetRefreshState();
            }
        });
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetRefreshState() {
        this.mRefreshing = false;
        this.isConfirm = false;
        this.mCurrentAction = -1;
    }

    private void startLoadmore(int i) {
        this.mRefreshing = true;
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(i, this.loadingViewHeight);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.footerView.getLayoutParams();
                layoutParams.height = (int) ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.footerView.setLayoutParams(layoutParams);
                com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.moveTargetView(-layoutParams.height);
            }
        });
        valueAnimatorOfFloat.addListener(new com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXRefreshAnimatorListener() { // from class: com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.6
            @Override // com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXRefreshAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.footerView.startAnimation();
                if (com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.onLoadingListener != null) {
                    com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.onLoadingListener.onLoading();
                }
            }
        });
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.start();
    }

    private void resetFootView(int i) {
        this.footerView.stopAnimation();
        this.footerView.setStartEndTrim(0.5f, 1.25f);
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(i, 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.footerView.getLayoutParams();
                layoutParams.height = (int) ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.footerView.setLayoutParams(layoutParams);
                com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.moveTargetView(-layoutParams.height);
            }
        });
        valueAnimatorOfFloat.addListener(new com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXRefreshAnimatorListener() { // from class: com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.8
            @Override // com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXRefreshAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.this.resetLoadmoreState();
            }
        });
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetLoadmoreState() {
        this.mRefreshing = false;
        this.isConfirm = false;
        this.mCurrentAction = -1;
    }

    public boolean canChildScrollUp() {
        if (this.mTargetView == null) {
            return false;
        }
        return androidx.core.view.ViewCompat.canScrollVertically(this.mTargetView, -1);
    }

    public boolean canChildScrollDown() {
        if (this.mTargetView == null) {
            return false;
        }
        return androidx.core.view.ViewCompat.canScrollVertically(this.mTargetView, 1);
    }

    public float dipToPx(android.content.Context context, float f) {
        return android.util.TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public void setOnLoadingListener(com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXOnLoadingListener wXOnLoadingListener) {
        this.onLoadingListener = wXOnLoadingListener;
    }

    public void setOnRefreshListener(com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXOnRefreshListener wXOnRefreshListener) {
        this.onRefreshListener = wXOnRefreshListener;
    }

    public void addOnRefreshOffsetChangedListener(com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.OnRefreshOffsetChangedListener onRefreshOffsetChangedListener) {
        if (onRefreshOffsetChangedListener == null || this.mRefreshOffsetChangedListeners.contains(onRefreshOffsetChangedListener)) {
            return;
        }
        this.mRefreshOffsetChangedListeners.add(onRefreshOffsetChangedListener);
    }

    public boolean removeOnRefreshOffsetChangedListener(com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.OnRefreshOffsetChangedListener onRefreshOffsetChangedListener) {
        if (onRefreshOffsetChangedListener != null) {
            return this.mRefreshOffsetChangedListeners.remove(onRefreshOffsetChangedListener);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnRefreshOffsetChangedListener(int i) {
        int size = this.mRefreshOffsetChangedListeners.size();
        for (int i2 = 0; i2 < size && i2 < this.mRefreshOffsetChangedListeners.size(); i2++) {
            com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.OnRefreshOffsetChangedListener onRefreshOffsetChangedListener = this.mRefreshOffsetChangedListeners.get(i2);
            if (onRefreshOffsetChangedListener != null) {
                onRefreshOffsetChangedListener.onOffsetChanged(i);
            }
        }
    }

    public void finishPullRefresh() {
        if (this.mCurrentAction == 0) {
            com.taobao.weex.ui.view.refresh.core.WXRefreshView wXRefreshView = this.headerView;
            resetHeaderView(wXRefreshView == null ? 0 : wXRefreshView.getMeasuredHeight());
        }
    }

    public void finishPullLoad() {
        if (this.mCurrentAction == 1) {
            com.taobao.weex.ui.view.refresh.core.WXRefreshView wXRefreshView = this.footerView;
            resetFootView(wXRefreshView == null ? 0 : wXRefreshView.getMeasuredHeight());
        }
    }

    public com.taobao.weex.ui.view.refresh.core.WXRefreshView getHeaderView() {
        return this.headerView;
    }

    public com.taobao.weex.ui.view.refresh.core.WXRefreshView getFooterView() {
        return this.footerView;
    }

    public boolean isPullLoadEnable() {
        return this.mPullLoadEnable;
    }

    public void setPullLoadEnable(boolean z) {
        this.mPullLoadEnable = z;
    }

    public boolean isPullRefreshEnable() {
        return this.mPullRefreshEnable;
    }

    public void setPullRefreshEnable(boolean z) {
        this.mPullRefreshEnable = z;
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    public void setRefreshHeight(int i) {
        this.refreshViewHeight = i;
        this.refreshViewFlowHeight = this.refreshViewHeight * overFlow;
    }

    public void setLoadingHeight(int i) {
        this.loadingViewHeight = i;
        this.loadingViewFlowHeight = this.loadingViewHeight * overFlow;
    }

    public void setRefreshBgColor(int i) {
        this.headerView.setBackgroundColor(i);
    }

    public void setLoadingBgColor(int i) {
        this.footerView.setBackgroundColor(i);
    }
}
