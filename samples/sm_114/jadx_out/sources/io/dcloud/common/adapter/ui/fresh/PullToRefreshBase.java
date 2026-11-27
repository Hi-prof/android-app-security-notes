package io.dcloud.common.adapter.ui.fresh;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class PullToRefreshBase<T extends android.view.View> extends android.widget.LinearLayout implements io.dcloud.common.adapter.ui.fresh.IPullToRefresh<T> {
    private static final float OFFSET_RADIO = 2.5f;
    private static final int SCROLL_DURATION = 150;
    final int DOWN;
    final int LEFT;
    final int RIGHT;
    final int UP;
    private java.lang.String mAppId;
    boolean mBeginPullRefresh;
    private boolean mCanDoPullDownEvent;
    private int mFooterHeight;
    private io.dcloud.common.adapter.ui.fresh.LoadingLayout mFooterLayout;
    private int mHeaderHeight;
    private io.dcloud.common.adapter.ui.fresh.LoadingLayout mHeaderLayout;
    private int mHeaderPullDownMaxHeight;
    private boolean mInterceptEventEnable;
    private boolean mIsHandledTouchEvent;
    private float mLastMotionX;
    private float mLastMotionY;
    float mLastMotionY_pullup;
    io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.OnPullUpListener mOnPullUpListener;
    io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.OnStateChangeListener mOnStateChangeListener;
    private io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State mPullDownState;
    private boolean mPullLoadEnabled;
    private boolean mPullRefreshEnabled;
    private io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State mPullUpState;
    private io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.OnRefreshListener<T> mRefreshListener;
    T mRefreshableView;
    private boolean mScrollLoadEnabled;
    private io.dcloud.common.adapter.ui.fresh.PullToRefreshBase<T>.SmoothScrollRunnable mSmoothScrollRunnable;
    private int mTouchSlop;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface OnPullUpListener {
        void onPlusScrollBottom();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface OnRefreshListener<V extends android.view.View> {
        void onPullDownToRefresh(io.dcloud.common.adapter.ui.fresh.PullToRefreshBase<V> pullToRefreshBase);

        void onPullUpToRefresh(io.dcloud.common.adapter.ui.fresh.PullToRefreshBase<V> pullToRefreshBase);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface OnStateChangeListener {
        void onStateChanged(io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State state, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    final class SmoothScrollRunnable implements java.lang.Runnable {
        private final long mDuration;
        private final int mScrollFromY;
        private final int mScrollToY;
        private boolean mContinueRunning = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;
        private final android.view.animation.Interpolator mInterpolator = new android.view.animation.DecelerateInterpolator();

        public SmoothScrollRunnable(int i, int i2, long j) {
            this.mScrollFromY = i;
            this.mScrollToY = i2;
            this.mDuration = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mDuration <= 0) {
                io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.setScrollTo(0, this.mScrollToY);
                return;
            }
            if (this.mStartTime == -1) {
                this.mStartTime = java.lang.System.currentTimeMillis();
            } else {
                int iRound = this.mScrollFromY - java.lang.Math.round((this.mScrollFromY - this.mScrollToY) * this.mInterpolator.getInterpolation(java.lang.Math.max(java.lang.Math.min(((java.lang.System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L) / 1000.0f));
                this.mCurrentY = iRound;
                io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.setScrollTo(0, iRound);
            }
            if (!this.mContinueRunning || this.mScrollToY == this.mCurrentY) {
                return;
            }
            io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.postDelayed(this, 16L);
        }

        public void stop() {
            this.mContinueRunning = false;
            io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.removeCallbacks(this);
        }
    }

    public PullToRefreshBase(android.content.Context context) {
        super(context);
        this.mLastMotionY = -1.0f;
        this.mLastMotionX = -1.0f;
        this.mCanDoPullDownEvent = false;
        this.mPullRefreshEnabled = true;
        this.mPullLoadEnabled = false;
        this.mScrollLoadEnabled = false;
        this.mInterceptEventEnable = true;
        this.mIsHandledTouchEvent = false;
        io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State state = io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.NONE;
        this.mPullDownState = state;
        this.mPullUpState = state;
        this.mLastMotionY_pullup = -1.0f;
        this.UP = 0;
        this.DOWN = 1;
        this.LEFT = 2;
        this.RIGHT = 3;
        this.mBeginPullRefresh = false;
    }

    private boolean canDoPullDownEvent(float f, float f2) {
        float f3 = this.mLastMotionY;
        if (f2 < f3) {
            return true;
        }
        if (!this.mCanDoPullDownEvent) {
            this.mCanDoPullDownEvent = 1 == getDirectionByAngle(getAngle(this.mLastMotionX, f3, f, f2));
        }
        return this.mCanDoPullDownEvent;
    }

    private double getAngle(float f, float f2, float f3, float f4) {
        return (java.lang.Math.atan2(f4 - f2, f3 - f) * 180.0d) / 3.141592653589793d;
    }

    private int getDirectionByAngle(double d) {
        if (d < -45.0d && d > -135.0d) {
            return 0;
        }
        if (d >= 45.0d && d < 135.0d) {
            return 1;
        }
        if (d >= 135.0d || d <= -135.0d) {
            return 2;
        }
        return (d < -45.0d || d > 45.0d) ? -1 : 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getScrollYValue() {
        return getScrollY();
    }

    private boolean handlePullUpEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1) {
            float y = motionEvent.getY() - this.mLastMotionY_pullup;
            this.mLastMotionY_pullup = y;
            if (y < -3.0f && isReadyForPullUp()) {
                this.mOnPullUpListener.onPlusScrollBottom();
                return false;
            }
        } else if (action == 0) {
            this.mLastMotionY_pullup = motionEvent.getY();
        }
        return false;
    }

    private void setScrollBy(int i, int i2) {
        scrollBy(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollTo(int i, int i2) {
        scrollTo(i, i2);
    }

    protected void addHeaderAndFooter(android.content.Context context) {
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -2);
        io.dcloud.common.adapter.ui.fresh.LoadingLayout loadingLayout = this.mHeaderLayout;
        io.dcloud.common.adapter.ui.fresh.LoadingLayout loadingLayout2 = this.mFooterLayout;
        if (loadingLayout != null) {
            if (this == loadingLayout.getParent()) {
                removeView(loadingLayout);
            }
            addView(loadingLayout, 0, layoutParams);
        }
        if (loadingLayout2 != null) {
            if (this == loadingLayout2.getParent()) {
                removeView(loadingLayout2);
            }
            addView(loadingLayout2, -1, layoutParams);
        }
    }

    public void addRefreshableView(T t) {
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -1);
        onAddRefreshableView(layoutParams);
        addView(t, layoutParams);
    }

    public void beginPullRefresh() {
        if (this.mBeginPullRefresh) {
            return;
        }
        postDelayed(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.3
            int deltaY = 0;

            @Override // java.lang.Runnable
            public void run() {
                int iAbs = java.lang.Math.abs(io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.getScrollYValue());
                if (io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.isPullRefreshEnabled() && io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.isReadyForPullDown()) {
                    if (iAbs >= io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.mHeaderHeight) {
                        io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.startRefreshing();
                        io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.mBeginPullRefresh = false;
                    } else {
                        io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.pullHeaderLayout(this.deltaY / io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.OFFSET_RADIO);
                        this.deltaY += 3;
                        io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.postDelayed(this, 5L);
                    }
                }
            }
        }, 5L);
        this.mBeginPullRefresh = true;
    }

    protected io.dcloud.common.adapter.ui.fresh.LoadingLayout createFooterLoadingLayout(android.content.Context context) {
        return null;
    }

    protected io.dcloud.common.adapter.ui.fresh.LoadingLayout createHeaderLoadingLayout(android.content.Context context) {
        io.dcloud.common.adapter.ui.fresh.LoadingLayout loadingLayout = this.mHeaderLayout;
        return loadingLayout == null ? new io.dcloud.common.adapter.ui.fresh.HeaderLoadingLayout(context) : loadingLayout;
    }

    public void doPullRefreshing(final boolean z, long j) {
        postDelayed(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.6
            @Override // java.lang.Runnable
            public void run() {
                int i = -io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.mHeaderHeight;
                int i2 = z ? io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.SCROLL_DURATION : 0;
                io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.startRefreshing();
                io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.smoothScrollTo(i, i2, 0L);
            }
        }, j);
    }

    public java.lang.String getAppId() {
        return this.mAppId;
    }

    @Override // io.dcloud.common.adapter.ui.fresh.IPullToRefresh
    public io.dcloud.common.adapter.ui.fresh.LoadingLayout getFooterLoadingLayout() {
        return this.mFooterLayout;
    }

    @Override // io.dcloud.common.adapter.ui.fresh.IPullToRefresh
    public io.dcloud.common.adapter.ui.fresh.LoadingLayout getHeaderLoadingLayout() {
        return this.mHeaderLayout;
    }

    @Override // io.dcloud.common.adapter.ui.fresh.IPullToRefresh
    public T getRefreshableView() {
        return this.mRefreshableView;
    }

    protected long getSmoothScrollDuration() {
        return 150L;
    }

    public void init(android.content.Context context) {
        setOrientation(1);
        this.mTouchSlop = android.view.ViewConfiguration.get(context).getScaledTouchSlop();
        this.mHeaderLayout = createHeaderLoadingLayout(context);
        this.mFooterLayout = createFooterLoadingLayout(context);
        addHeaderAndFooter(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.refreshLoadingViewsSize();
                io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
        smoothScrollTo(0);
    }

    public boolean isInterceptTouchEventEnabled() {
        return this.mInterceptEventEnable;
    }

    @Override // io.dcloud.common.adapter.ui.fresh.IPullToRefresh
    public boolean isPullLoadEnabled() {
        return this.mPullLoadEnabled && this.mFooterLayout != null;
    }

    protected boolean isPullLoading() {
        return this.mPullUpState == io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.REFRESHING;
    }

    @Override // io.dcloud.common.adapter.ui.fresh.IPullToRefresh
    public boolean isPullRefreshEnabled() {
        return this.mPullRefreshEnabled && this.mHeaderLayout != null;
    }

    protected boolean isPullRefreshing() {
        return this.mPullDownState == io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.REFRESHING;
    }

    protected abstract boolean isReadyForPullDown();

    protected abstract boolean isReadyForPullUp();

    @Override // io.dcloud.common.adapter.ui.fresh.IPullToRefresh
    public boolean isScrollLoadEnabled() {
        return this.mScrollLoadEnabled;
    }

    protected void onAddRefreshableView(android.widget.LinearLayout.LayoutParams layoutParams) {
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        boolean z;
        if (!isInterceptTouchEventEnabled()) {
            return false;
        }
        if (!isPullLoadEnabled() && !isPullRefreshEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mIsHandledTouchEvent = false;
            this.mCanDoPullDownEvent = false;
            return false;
        }
        if (action != 0 && this.mIsHandledTouchEvent) {
            return true;
        }
        if (action == 0) {
            this.mLastMotionY = motionEvent.getY();
            this.mLastMotionX = motionEvent.getX();
            this.mIsHandledTouchEvent = false;
            this.mCanDoPullDownEvent = false;
        } else if (action == 2 && canDoPullDownEvent(motionEvent.getX(), motionEvent.getY())) {
            float y = motionEvent.getY() - this.mLastMotionY;
            if (java.lang.Math.abs(y) > this.mTouchSlop || isPullRefreshing() || !isPullLoading()) {
                this.mLastMotionY = motionEvent.getY();
                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                    z = java.lang.Math.abs(getScrollYValue()) > 0 || y > 0.5f;
                    this.mIsHandledTouchEvent = z;
                    if (z) {
                        this.mRefreshableView.onTouchEvent(motionEvent);
                        requestDisallowInterceptTouchEvent(true);
                    }
                } else if (isPullLoadEnabled() && isReadyForPullUp()) {
                    z = java.lang.Math.abs(getScrollYValue()) > 0 || y < -0.5f;
                    this.mIsHandledTouchEvent = z;
                    if (z) {
                        requestDisallowInterceptTouchEvent(true);
                    }
                }
            }
        }
        boolean z2 = this.mIsHandledTouchEvent;
        return z2 ? z2 : super.onTouchEvent(motionEvent);
    }

    @Override // io.dcloud.common.adapter.ui.fresh.IPullToRefresh
    public void onPullDownRefreshComplete() {
        if (isPullRefreshing()) {
            io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State state = io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.RESET;
            this.mPullDownState = state;
            onStateChanged(state, true);
            postDelayed(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.4
                @Override // java.lang.Runnable
                public void run() {
                    io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                    io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.mHeaderLayout.setState(io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.RESET);
                }
            }, getSmoothScrollDuration());
            resetHeaderLayout();
            setInterceptTouchEventEnabled(false);
        }
    }

    @Override // io.dcloud.common.adapter.ui.fresh.IPullToRefresh
    public void onPullUpRefreshComplete() {
        if (isPullLoading()) {
            io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State state = io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.RESET;
            this.mPullUpState = state;
            onStateChanged(state, false);
            postDelayed(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.5
                @Override // java.lang.Runnable
                public void run() {
                    io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.setInterceptTouchEventEnabled(true);
                    io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.mFooterLayout.setState(io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.RESET);
                }
            }, getSmoothScrollDuration());
            resetFooterLayout();
            setInterceptTouchEventEnabled(false);
        }
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        refreshLoadingViewsSize();
        refreshRefreshableViewSize(i, i2);
        post(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.2
            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.requestLayout();
            }
        });
    }

    protected void onStateChanged(io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State state, boolean z) {
        io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.OnStateChangeListener onStateChangeListener = this.mOnStateChangeListener;
        if (onStateChangeListener != null) {
            onStateChangeListener.onStateChanged(state, z);
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (!isInterceptTouchEventEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastMotionY = motionEvent.getY();
            this.mIsHandledTouchEvent = false;
            return false;
        }
        boolean z = true;
        if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY() - this.mLastMotionY;
                this.mLastMotionY = motionEvent.getY();
                if (isPullRefreshEnabled() && isReadyForPullDown()) {
                    pullHeaderLayout(y / OFFSET_RADIO);
                    return true;
                }
                if (isPullLoadEnabled() && isReadyForPullUp()) {
                    pullFooterLayout(y / OFFSET_RADIO);
                    return true;
                }
                this.mIsHandledTouchEvent = false;
                return false;
            }
            if (action != 3) {
                return false;
            }
        }
        if (this.mIsHandledTouchEvent) {
            this.mIsHandledTouchEvent = false;
            if (isReadyForPullDown()) {
                if (this.mPullRefreshEnabled && this.mPullDownState == io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.RELEASE_TO_REFRESH) {
                    startRefreshing();
                } else {
                    z = false;
                }
                resetHeaderLayout();
            } else if (isReadyForPullUp()) {
                if (isPullLoadEnabled() && this.mPullUpState == io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.RELEASE_TO_REFRESH) {
                    startLoading();
                } else {
                    z = false;
                }
                resetFooterLayout();
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        requestDisallowInterceptTouchEvent(false);
        return z;
    }

    protected void pullFooterLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f > 0.0f && scrollYValue - f <= 0.0f) {
            setScrollTo(0, 0);
            return;
        }
        setScrollBy(0, -((int) f));
        if (this.mFooterLayout != null && this.mFooterHeight != 0) {
            this.mFooterLayout.onPull(java.lang.Math.abs(getScrollYValue()) / this.mFooterHeight);
        }
        int iAbs = java.lang.Math.abs(getScrollYValue());
        if (!isPullLoadEnabled() || isPullLoading()) {
            return;
        }
        if (iAbs >= this.mFooterHeight) {
            this.mPullUpState = io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.RELEASE_TO_REFRESH;
        } else {
            this.mPullUpState = io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.PULL_TO_REFRESH;
        }
        this.mFooterLayout.setState(this.mPullUpState);
        onStateChanged(this.mPullUpState, false);
    }

    protected void pullHeaderLayout(float f) {
        int scrollYValue = getScrollYValue();
        if (f <= 0.0f || java.lang.Math.abs(scrollYValue) < this.mHeaderPullDownMaxHeight) {
            if (f < 0.0f && scrollYValue - f >= 0.0f) {
                setScrollTo(0, 0);
                return;
            }
            setScrollBy(0, -((int) f));
            if (this.mHeaderLayout != null && this.mHeaderHeight != 0) {
                this.mHeaderLayout.onPull(java.lang.Math.abs(getScrollYValue()) / this.mHeaderHeight);
            }
            int iAbs = java.lang.Math.abs(getScrollYValue());
            if (!isPullRefreshEnabled() || isPullRefreshing()) {
                return;
            }
            if (iAbs >= this.mHeaderHeight) {
                this.mPullDownState = io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.RELEASE_TO_REFRESH;
            } else {
                this.mPullDownState = io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.PULL_TO_REFRESH;
            }
            this.mHeaderLayout.setState(this.mPullDownState);
            onStateChanged(this.mPullDownState, true);
        }
    }

    public void refreshLoadingViewsSize() {
        int i = this.mHeaderHeight;
        io.dcloud.common.adapter.ui.fresh.LoadingLayout loadingLayout = this.mFooterLayout;
        int contentSize = loadingLayout != null ? loadingLayout.getContentSize() : 0;
        if (i < 0) {
            i = 0;
        }
        if (contentSize < 0) {
            contentSize = 0;
        }
        this.mHeaderHeight = i;
        this.mFooterHeight = contentSize;
        io.dcloud.common.adapter.ui.fresh.LoadingLayout loadingLayout2 = this.mHeaderLayout;
        int measuredHeight = loadingLayout2 != null ? loadingLayout2.getMeasuredHeight() : 0;
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.VIEW_VISIBLE_TAG, "PullToRefreshBase.refreshLoadingViewsSize mHeaderHeight=" + this.mHeaderHeight + ";headerHeight=" + measuredHeight);
        io.dcloud.common.adapter.ui.fresh.LoadingLayout loadingLayout3 = this.mFooterLayout;
        int measuredHeight2 = loadingLayout3 != null ? loadingLayout3.getMeasuredHeight() : 0;
        if (measuredHeight2 == 0) {
            measuredHeight2 = this.mFooterHeight;
        }
        int paddingLeft = getPaddingLeft();
        getPaddingTop();
        int paddingRight = getPaddingRight();
        getPaddingBottom();
        setPadding(paddingLeft, -measuredHeight, paddingRight, -measuredHeight2);
    }

    protected void refreshRefreshableViewSize(int i, int i2) {
        T t = this.mRefreshableView;
        if (t != null) {
            android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) t.getLayoutParams();
            if (layoutParams.height != i2) {
                layoutParams.height = i2;
                this.mRefreshableView.requestLayout();
            }
        }
    }

    protected void resetFooterLayout() {
        int iAbs = java.lang.Math.abs(getScrollYValue());
        boolean zIsPullLoading = isPullLoading();
        if (zIsPullLoading && iAbs <= this.mFooterHeight) {
            smoothScrollTo(0);
        } else if (zIsPullLoading) {
            smoothScrollTo(this.mFooterHeight);
        } else {
            smoothScrollTo(0);
        }
    }

    protected void resetHeaderLayout() {
        int iAbs = java.lang.Math.abs(getScrollYValue());
        boolean zIsPullRefreshing = isPullRefreshing();
        if (!zIsPullRefreshing || iAbs > this.mHeaderHeight) {
            if (zIsPullRefreshing) {
                smoothScrollTo(-this.mHeaderHeight);
            } else {
                smoothScrollTo(0);
            }
        }
    }

    public void setAppId(java.lang.String str) {
        this.mAppId = str;
    }

    public void setHeaderHeight(int i) {
        this.mHeaderHeight = i;
    }

    public void setHeaderPullDownMaxHeight(int i) {
        this.mHeaderPullDownMaxHeight = i;
    }

    public void setInterceptTouchEventEnabled(boolean z) {
        this.mInterceptEventEnable = z;
    }

    @Override // io.dcloud.common.adapter.ui.fresh.IPullToRefresh
    public void setLastUpdatedLabel(java.lang.CharSequence charSequence) {
        io.dcloud.common.adapter.ui.fresh.LoadingLayout loadingLayout = this.mHeaderLayout;
        if (loadingLayout != null) {
            loadingLayout.setLastUpdatedLabel(charSequence);
        }
        io.dcloud.common.adapter.ui.fresh.LoadingLayout loadingLayout2 = this.mFooterLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.setLastUpdatedLabel(charSequence);
        }
    }

    public void setOnOnPullUpListener(io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.OnPullUpListener onPullUpListener) {
        this.mOnPullUpListener = onPullUpListener;
    }

    @Override // io.dcloud.common.adapter.ui.fresh.IPullToRefresh
    public void setOnRefreshListener(io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.OnRefreshListener<T> onRefreshListener) {
        this.mRefreshListener = onRefreshListener;
    }

    public void setOnStateChangeListener(io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.OnStateChangeListener onStateChangeListener) {
        this.mOnStateChangeListener = onStateChangeListener;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (1 != i) {
            throw new java.lang.IllegalArgumentException("This class only supports VERTICAL orientation.");
        }
        super.setOrientation(i);
    }

    @Override // io.dcloud.common.adapter.ui.fresh.IPullToRefresh
    public void setPullLoadEnabled(boolean z) {
        this.mPullLoadEnabled = z;
    }

    @Override // io.dcloud.common.adapter.ui.fresh.IPullToRefresh
    public void setPullRefreshEnabled(boolean z) {
        this.mPullRefreshEnabled = z;
    }

    public void setRefreshableView(T t) {
        this.mRefreshableView = t;
    }

    @Override // io.dcloud.common.adapter.ui.fresh.IPullToRefresh
    public void setScrollLoadEnabled(boolean z) {
        this.mScrollLoadEnabled = z;
    }

    public void smoothScrollTo(int i) {
        smoothScrollTo(i, getSmoothScrollDuration(), 0L);
    }

    protected void startLoading() {
        if (isPullLoading()) {
            return;
        }
        io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State state = io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.REFRESHING;
        this.mPullUpState = state;
        onStateChanged(state, false);
        io.dcloud.common.adapter.ui.fresh.LoadingLayout loadingLayout = this.mFooterLayout;
        if (loadingLayout != null) {
            loadingLayout.setState(state);
        }
        if (this.mRefreshListener != null) {
            postDelayed(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.8
                @Override // java.lang.Runnable
                public void run() {
                    io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.mRefreshListener.onPullUpToRefresh(io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this);
                }
            }, getSmoothScrollDuration());
        }
    }

    protected void startRefreshing() {
        if (isPullRefreshing()) {
            return;
        }
        io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State state = io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.REFRESHING;
        this.mPullDownState = state;
        onStateChanged(state, true);
        io.dcloud.common.adapter.ui.fresh.LoadingLayout loadingLayout = this.mHeaderLayout;
        if (loadingLayout != null) {
            loadingLayout.setState(state);
        }
        if (this.mRefreshListener != null) {
            postDelayed(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.7
                @Override // java.lang.Runnable
                public void run() {
                    io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this.mRefreshListener.onPullDownToRefresh(io.dcloud.common.adapter.ui.fresh.PullToRefreshBase.this);
                }
            }, getSmoothScrollDuration());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void smoothScrollTo(int i, long j, long j2) {
        io.dcloud.common.adapter.ui.fresh.PullToRefreshBase<T> pullToRefreshBase;
        io.dcloud.common.adapter.ui.fresh.PullToRefreshBase<T>.SmoothScrollRunnable smoothScrollRunnable = this.mSmoothScrollRunnable;
        if (smoothScrollRunnable != null) {
            smoothScrollRunnable.stop();
        }
        int scrollYValue = getScrollYValue();
        boolean z = scrollYValue != i;
        if (z) {
            pullToRefreshBase = this;
            pullToRefreshBase.mSmoothScrollRunnable = pullToRefreshBase.new SmoothScrollRunnable(scrollYValue, i, j);
        } else {
            pullToRefreshBase = this;
        }
        if (z) {
            if (j2 > 0) {
                postDelayed(pullToRefreshBase.mSmoothScrollRunnable, j2);
            } else {
                post(pullToRefreshBase.mSmoothScrollRunnable);
            }
        }
    }
}
