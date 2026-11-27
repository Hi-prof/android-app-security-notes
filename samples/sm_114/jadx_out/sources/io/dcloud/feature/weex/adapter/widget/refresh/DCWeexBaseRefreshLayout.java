package io.dcloud.feature.weex.adapter.widget.refresh;

/* JADX INFO: loaded from: classes2.dex */
public class DCWeexBaseRefreshLayout extends android.view.ViewGroup implements com.dcloud.android.v4.view.NestedScrollingParent, com.dcloud.android.v4.view.NestedScrollingChild {
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    private static final int CIRCLE_BG_LIGHT = -328966;
    static final int CIRCLE_DIAMETER = 40;
    static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = -1;
    public static final int LARGE = 0;
    private static final int[] LAYOUT_ATTRS = {android.R.attr.enabled};
    private static final java.lang.String LOG_TAG = "DCWeexBaseRefreshLayout";
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int mActivePointerId;
    private android.view.animation.Animation mAlphaMaxAnimation;
    private android.view.animation.Animation mAlphaStartAnimation;
    private final android.view.animation.Animation mAnimateToCorrectPosition;
    private final android.view.animation.Animation mAnimateToStartPosition;
    boolean mBeginRefresh;
    private io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.OnChildScrollUpCallback mChildScrollUpCallback;
    private int mCircleDiameter;
    private int mCircleLatyouOffsetTop;
    private io.dcloud.feature.weex.adapter.widget.refresh.CircleLayout mCircleLayout;
    private io.dcloud.feature.weex.adapter.widget.refresh.DCWeexCircleImageView mCircleView;
    private int mCircleViewIndex;
    private int mCurrentTargetOffsetTop;
    private final android.view.animation.DecelerateInterpolator mDecelerateInterpolator;
    protected int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.OnRefreshListener mListener;
    private int mMediumAnimationDuration;
    private boolean mNestedScrollInProgress;
    private final com.dcloud.android.v4.view.NestedScrollingChildHelper mNestedScrollingChildHelper;
    private final com.dcloud.android.v4.view.NestedScrollingParentHelper mNestedScrollingParentHelper;
    private boolean mNotify;
    protected int mOriginalOffsetTop;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    private com.dcloud.android.v4.widget.MaterialProgressDrawable mProgress;
    private android.view.animation.Animation.AnimationListener mRefreshListener;
    private boolean mRefreshing;
    private boolean mReturningToStart;
    private boolean mScale;
    private android.view.animation.Animation mScaleAnimation;
    private android.view.animation.Animation mScaleDownAnimation;
    private android.view.animation.Animation mScaleDownToStartAnimation;
    protected float mSpinnerFinalOffset;
    private float mStartingScale;
    private android.view.View mTarget;
    protected float mTotalDragDistance;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    private boolean mUsingCustomStart;

    public interface OnChildScrollUpCallback {
        boolean canChildScrollUp(io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout dCWeexBaseRefreshLayout, android.view.View view);
    }

    public interface OnRefreshListener {
        void onRefresh();
    }

    private boolean isAlphaUsedForScale() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.mCircleView.clearAnimation();
        this.mProgress.stop();
        this.mCircleView.setVisibility(8);
        setColorViewAlpha(255);
        if (this.mScale) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop, true);
        }
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        reset();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void setColorViewAlpha(int i) {
        this.mCircleView.getBackground().setAlpha(i);
        this.mProgress.setAlpha(i);
    }

    public void setProgressViewOffset(boolean z, int i, int i2, int i3, int i4) {
        this.mScale = z;
        this.mOriginalOffsetTop = i;
        this.mCircleLatyouOffsetTop = i4;
        this.mSpinnerFinalOffset = i2;
        this.mTotalDragDistance = i3;
        this.mUsingCustomStart = true;
        reset();
        this.mRefreshing = false;
    }

    public void setProgressViewEndTarget(boolean z, int i) {
        this.mSpinnerFinalOffset = i;
        this.mScale = z;
        this.mCircleView.invalidate();
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.mCircleDiameter = (int) (displayMetrics.density * 56.0f);
            } else {
                this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
            }
            this.mCircleView.setImageDrawable(null);
            this.mProgress.updateSizes(i);
            this.mCircleView.setImageDrawable(this.mProgress);
        }
    }

    public DCWeexBaseRefreshLayout(android.content.Context context) {
        this(context, null);
    }

    public DCWeexBaseRefreshLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mActivePointerId = -1;
        this.mCircleLatyouOffsetTop = 0;
        this.mCircleViewIndex = -1;
        this.mRefreshListener = new android.view.animation.Animation.AnimationListener() { // from class: io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                if (io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mRefreshing) {
                    io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mProgress.setAlpha(255);
                    io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mProgress.start();
                    if (io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mNotify && io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mListener != null) {
                        io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mListener.onRefresh();
                    }
                    io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout dCWeexBaseRefreshLayout = io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this;
                    dCWeexBaseRefreshLayout.mCurrentTargetOffsetTop = dCWeexBaseRefreshLayout.mCircleView.getTop();
                    return;
                }
                io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.reset();
            }
        };
        this.mBeginRefresh = false;
        this.mAnimateToCorrectPosition = new android.view.animation.Animation() { // from class: io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.7
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, android.view.animation.Transformation transformation) {
                float fAbs;
                if (!io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mUsingCustomStart) {
                    fAbs = io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mSpinnerFinalOffset - java.lang.Math.abs(io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mOriginalOffsetTop);
                } else {
                    fAbs = io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mSpinnerFinalOffset;
                }
                io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.setTargetOffsetTopAndBottom((io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mFrom + ((int) ((((int) fAbs) - io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mFrom) * f))) - io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mCircleView.getTop(), false);
                io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mProgress.setArrowScale(1.0f - f);
            }
        };
        this.mAnimateToStartPosition = new android.view.animation.Animation() { // from class: io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.8
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, android.view.animation.Transformation transformation) {
                io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.moveToStart(f);
            }
        };
        this.mTouchSlop = android.view.ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(android.R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new android.view.animation.DecelerateInterpolator(DECELERATE_INTERPOLATION_FACTOR);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
        createProgressView();
        com.dcloud.android.v4.view.ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        float f = displayMetrics.density * 64.0f;
        this.mSpinnerFinalOffset = f;
        this.mTotalDragDistance = f;
        this.mNestedScrollingParentHelper = new com.dcloud.android.v4.view.NestedScrollingParentHelper(this);
        this.mNestedScrollingChildHelper = new com.dcloud.android.v4.view.NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i = -this.mCircleDiameter;
        this.mCurrentTargetOffsetTop = i;
        this.mOriginalOffsetTop = i;
        moveToStart(1.0f);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        int i3 = this.mCircleViewIndex;
        if (i3 < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return i3;
        }
        return i2 >= i3 ? i2 + 1 : i2;
    }

    private void createProgressView() {
        this.mCircleView = new io.dcloud.feature.weex.adapter.widget.refresh.DCWeexCircleImageView(getContext(), -328966, 20.0f);
        com.dcloud.android.v4.widget.MaterialProgressDrawable materialProgressDrawable = new com.dcloud.android.v4.widget.MaterialProgressDrawable(getContext(), this);
        this.mProgress = materialProgressDrawable;
        materialProgressDrawable.setBackgroundColor(-328966);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        io.dcloud.feature.weex.adapter.widget.refresh.CircleLayout circleLayout = new io.dcloud.feature.weex.adapter.widget.refresh.CircleLayout(getContext());
        this.mCircleLayout = circleLayout;
        circleLayout.addView(this.mCircleView);
        this.mCircleLayout.setVisibility(0);
        addView(this.mCircleLayout, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    public void setOnRefreshListener(io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.OnRefreshListener onRefreshListener) {
        this.mListener = onRefreshListener;
    }

    public void setRefreshing(boolean z) {
        float f;
        if (z && this.mRefreshing != z) {
            this.mRefreshing = z;
            if (!this.mUsingCustomStart) {
                f = this.mSpinnerFinalOffset + this.mOriginalOffsetTop;
            } else {
                f = this.mSpinnerFinalOffset;
            }
            setTargetOffsetTopAndBottom(((int) f) - this.mCurrentTargetOffsetTop, true);
            this.mNotify = false;
            startScaleUpAnimation(this.mRefreshListener);
            return;
        }
        setRefreshing(z, false);
    }

    public void beginRefresh() {
        if (this.mBeginRefresh || this.mCircleView.getVisibility() == 0) {
            return;
        }
        post(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.2
            int offset = 0;

            @Override // java.lang.Runnable
            public void run() {
                if (this.offset < io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mTotalDragDistance) {
                    io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.moveSpinner(this.offset);
                    io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.postDelayed(this, 1L);
                    this.offset += 15;
                } else {
                    io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.setRefreshing(true, true);
                    io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mBeginRefresh = false;
                }
            }
        });
        this.mBeginRefresh = true;
    }

    private void startScaleUpAnimation(android.view.animation.Animation.AnimationListener animationListener) {
        this.mCircleView.setVisibility(0);
        this.mProgress.setAlpha(255);
        android.view.animation.Animation animation = new android.view.animation.Animation() { // from class: io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.3
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, android.view.animation.Transformation transformation) {
                io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.setAnimationProgress(f);
            }
        };
        this.mScaleAnimation = animation;
        animation.setDuration(this.mMediumAnimationDuration);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnimationProgress(float f) {
        if (isAlphaUsedForScale()) {
            setColorViewAlpha((int) (f * 255.0f));
        } else {
            com.dcloud.android.v4.view.ViewCompat.setScaleX(this.mCircleView, f);
            com.dcloud.android.v4.view.ViewCompat.setScaleY(this.mCircleView, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRefreshing(boolean z, boolean z2) {
        if (this.mRefreshing != z) {
            this.mNotify = z2;
            ensureTarget();
            this.mRefreshing = z;
            if (z) {
                animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
            } else {
                startScaleDownAnimation(this.mRefreshListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startScaleDownAnimation(android.view.animation.Animation.AnimationListener animationListener) {
        android.view.animation.Animation animation = new android.view.animation.Animation() { // from class: io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.4
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, android.view.animation.Transformation transformation) {
                io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.mScaleDownAnimation = animation;
        animation.setDuration(150L);
        this.mCircleView.setAnimationListener(animationListener);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    private void startProgressAlphaStartAnimation() {
        this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 76);
    }

    private void startProgressAlphaMaxAnimation() {
        this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 255);
    }

    private android.view.animation.Animation startAlphaAnimation(final int i, final int i2) {
        if (this.mScale && isAlphaUsedForScale()) {
            return null;
        }
        android.view.animation.Animation animation = new android.view.animation.Animation() { // from class: io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.5
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, android.view.animation.Transformation transformation) {
                com.dcloud.android.v4.widget.MaterialProgressDrawable materialProgressDrawable = io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mProgress;
                int i3 = i;
                materialProgressDrawable.setAlpha((int) (i3 + ((i2 - i3) * f)));
            }
        };
        animation.setDuration(300L);
        this.mCircleView.setAnimationListener(null);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(animation);
        return animation;
    }

    @java.lang.Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(getResources().getColor(i));
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.mCircleView.setBackgroundColor(i);
        this.mProgress.setBackgroundColor(i);
    }

    @java.lang.Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        android.content.res.Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = resources.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        ensureTarget();
        this.mProgress.setColorSchemeColors(iArr);
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            for (int i = 0; i < getChildCount(); i++) {
                android.view.View childAt = getChildAt(i);
                if (!childAt.equals(this.mCircleLayout)) {
                    this.mTarget = childAt;
                    return;
                }
            }
        }
    }

    public void clearTarget() {
        this.mTarget = null;
    }

    public void setDistanceToTriggerSync(int i) {
        this.mTotalDragDistance = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.mTarget == null) {
            ensureTarget();
        }
        android.view.View view = this.mTarget;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingLeft2 = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int i5 = paddingLeft2 + paddingLeft;
        int paddingTop2 = ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop;
        this.mCircleLayout.layout(paddingLeft, this.mCircleLatyouOffsetTop + paddingTop, i5, paddingTop2);
        view.layout(paddingLeft, paddingTop, i5, paddingTop2);
        int measuredWidth2 = this.mCircleView.getMeasuredWidth();
        int measuredHeight2 = this.mCircleView.getMeasuredHeight();
        int i6 = measuredWidth / 2;
        int i7 = measuredWidth2 / 2;
        int i8 = this.mCurrentTargetOffsetTop;
        this.mCircleView.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mTarget == null) {
            ensureTarget();
        }
        android.view.View view = this.mTarget;
        if (view == null) {
            return;
        }
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), android.view.View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.mCircleView.measure(android.view.View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824));
        this.mCircleViewIndex = -1;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) == this.mCircleLayout) {
                this.mCircleViewIndex = i3;
                return;
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.mCircleDiameter;
    }

    public boolean canChildScrollUp() {
        if (this.mTarget == null) {
            ensureTarget();
        }
        android.view.View view = this.mTarget;
        if (view == null) {
            return false;
        }
        io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.OnChildScrollUpCallback onChildScrollUpCallback = this.mChildScrollUpCallback;
        if (onChildScrollUpCallback != null) {
            return onChildScrollUpCallback.canChildScrollUp(this, view);
        }
        return com.dcloud.android.v4.view.ViewCompat.canScrollVertically(this.mTarget, -1);
    }

    public void setOnChildScrollUpCallback(io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.OnChildScrollUpCallback onChildScrollUpCallback) {
        this.mChildScrollUpCallback = onChildScrollUpCallback;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0058  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        ensureTarget();
        int actionMasked = com.dcloud.android.v4.view.MotionEventCompat.getActionMasked(motionEvent);
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        if (actionMasked == 0) {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop(), true);
            int pointerId = motionEvent.getPointerId(0);
            this.mActivePointerId = pointerId;
            this.mIsBeingDragged = false;
            int iFindPointerIndex = motionEvent.findPointerIndex(pointerId);
            if (iFindPointerIndex < 0) {
                return false;
            }
            this.mInitialDownY = motionEvent.getY(iFindPointerIndex);
        } else if (actionMasked == 1) {
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
        } else if (actionMasked == 2) {
            int i = this.mActivePointerId;
            if (i == -1) {
                android.util.Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
                return false;
            }
            int iFindPointerIndex2 = motionEvent.findPointerIndex(i);
            if (iFindPointerIndex2 < 0) {
                return false;
            }
            startDragging(motionEvent.getY(iFindPointerIndex2));
        } else if (actionMasked == 3) {
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
        } else if (actionMasked == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        return this.mIsBeingDragged;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        android.view.View view = this.mTarget;
        if (view == null || com.dcloud.android.v4.view.ViewCompat.isNestedScrollingEnabled(view)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.dcloud.android.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(android.view.View view, android.view.View view2, int i) {
        return (!isEnabled() || this.mReturningToStart || this.mRefreshing || (i & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.dcloud.android.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(android.view.View view, android.view.View view2, int i) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(i & 2);
        this.mTotalUnconsumed = 0.0f;
        this.mNestedScrollInProgress = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.dcloud.android.v4.view.NestedScrollingParent
    public void onNestedPreScroll(android.view.View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            float f = this.mTotalUnconsumed;
            if (f > 0.0f) {
                float f2 = i2;
                if (f2 > f) {
                    iArr[1] = i2 - ((int) f);
                    this.mTotalUnconsumed = 0.0f;
                } else {
                    this.mTotalUnconsumed = f - f2;
                    iArr[1] = i2;
                }
                moveSpinner(this.mTotalUnconsumed);
            }
        }
        if (this.mUsingCustomStart && i2 > 0 && this.mTotalUnconsumed == 0.0f && java.lang.Math.abs(i2 - iArr[1]) > 0) {
            this.mCircleView.setVisibility(8);
        }
        int[] iArr2 = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, com.dcloud.android.v4.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.dcloud.android.v4.view.NestedScrollingParent
    public void onStopNestedScroll(android.view.View view) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view);
        this.mNestedScrollInProgress = false;
        float f = this.mTotalUnconsumed;
        if (f > 0.0f) {
            finishSpinner(f);
            this.mTotalUnconsumed = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.dcloud.android.v4.view.NestedScrollingParent
    public void onNestedScroll(android.view.View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.mParentOffsetInWindow);
        int i5 = i4 + this.mParentOffsetInWindow[1];
        if (i5 >= 0 || canChildScrollUp()) {
            return;
        }
        float fAbs = this.mTotalUnconsumed + java.lang.Math.abs(i5);
        this.mTotalUnconsumed = fAbs;
        moveSpinner(fAbs);
    }

    @Override // android.view.View, com.dcloud.android.v4.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.mNestedScrollingChildHelper.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, com.dcloud.android.v4.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }

    @Override // android.view.View, com.dcloud.android.v4.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.mNestedScrollingChildHelper.startNestedScroll(i);
    }

    @Override // android.view.View, com.dcloud.android.v4.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.stopNestedScroll();
    }

    @Override // android.view.View, com.dcloud.android.v4.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
    }

    @Override // android.view.View, com.dcloud.android.v4.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, com.dcloud.android.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.dcloud.android.v4.view.NestedScrollingParent
    public boolean onNestedPreFling(android.view.View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.dcloud.android.v4.view.NestedScrollingParent
    public boolean onNestedFling(android.view.View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, com.dcloud.android.v4.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, com.dcloud.android.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(f, f2);
    }

    private boolean isAnimationRunning(android.view.animation.Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveSpinner(float f) {
        this.mProgress.showArrow(true);
        float fMin = java.lang.Math.min(1.0f, java.lang.Math.abs(f / this.mTotalDragDistance));
        float fMax = (((float) java.lang.Math.max(((double) fMin) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = java.lang.Math.abs(f) - this.mTotalDragDistance;
        float f2 = this.mUsingCustomStart ? this.mSpinnerFinalOffset - this.mOriginalOffsetTop : this.mSpinnerFinalOffset;
        double dMax = java.lang.Math.max(0.0f, java.lang.Math.min(fAbs, f2 * DECELERATE_INTERPOLATION_FACTOR) / f2) / 4.0f;
        float fPow = ((float) (dMax - java.lang.Math.pow(dMax, 2.0d))) * DECELERATE_INTERPOLATION_FACTOR;
        int i = this.mOriginalOffsetTop + ((int) ((f2 * fMin) + (f2 * fPow * DECELERATE_INTERPOLATION_FACTOR)));
        if (this.mCircleView.getVisibility() != 0) {
            this.mCircleView.setVisibility(0);
        }
        if (!this.mScale) {
            com.dcloud.android.v4.view.ViewCompat.setScaleX(this.mCircleView, 1.0f);
            com.dcloud.android.v4.view.ViewCompat.setScaleY(this.mCircleView, 1.0f);
        }
        if (this.mScale) {
            setAnimationProgress(java.lang.Math.min(1.0f, f / this.mTotalDragDistance));
        }
        if (f < this.mTotalDragDistance) {
            if (this.mProgress.getAlpha() > 76 && !isAnimationRunning(this.mAlphaStartAnimation)) {
                startProgressAlphaStartAnimation();
            }
        } else if (this.mProgress.getAlpha() < 255 && !isAnimationRunning(this.mAlphaMaxAnimation)) {
            startProgressAlphaMaxAnimation();
        }
        this.mProgress.setStartEndTrim(0.0f, java.lang.Math.min(MAX_PROGRESS_ANGLE, fMax * MAX_PROGRESS_ANGLE));
        this.mProgress.setArrowScale(java.lang.Math.min(1.0f, fMax));
        this.mProgress.setProgressRotation((((fMax * 0.4f) - 0.25f) + (fPow * DECELERATE_INTERPOLATION_FACTOR)) * 0.5f);
        setTargetOffsetTopAndBottom(i - this.mCurrentTargetOffsetTop, true);
    }

    private void finishSpinner(float f) {
        if (f > this.mTotalDragDistance) {
            setRefreshing(true, true);
            return;
        }
        this.mRefreshing = false;
        this.mProgress.setStartEndTrim(0.0f, 0.0f);
        animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, !this.mScale ? new android.view.animation.Animation.AnimationListener() { // from class: io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                if (io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mScale) {
                    return;
                }
                io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.startScaleDownAnimation(null);
            }
        } : null);
        this.mProgress.showArrow(false);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int actionMasked = com.dcloud.android.v4.view.MotionEventCompat.getActionMasked(motionEvent);
        java.lang.Boolean bool = false;
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        if (actionMasked == 0) {
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsBeingDragged = false;
        } else {
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (iFindPointerIndex < 0) {
                    android.util.Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
                } else {
                    if (this.mIsBeingDragged) {
                        float y = (motionEvent.getY(iFindPointerIndex) - this.mInitialMotionY) * 0.5f;
                        this.mIsBeingDragged = false;
                        finishSpinner(y);
                    }
                    this.mActivePointerId = -1;
                }
            } else if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                if (iFindPointerIndex2 < 0) {
                    android.util.Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                } else {
                    float y2 = motionEvent.getY(iFindPointerIndex2);
                    startDragging(y2);
                    if (this.mIsBeingDragged) {
                        float f = (y2 - this.mInitialMotionY) * 0.5f;
                        if (f > 0.0f) {
                            moveSpinner(f);
                        }
                    }
                }
            } else if (actionMasked != 3) {
                if (actionMasked == 5) {
                    int actionIndex = com.dcloud.android.v4.view.MotionEventCompat.getActionIndex(motionEvent);
                    if (actionIndex < 0) {
                        android.util.Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    onSecondaryPointerUp(motionEvent);
                }
            }
            return bool.booleanValue();
        }
        bool = true;
        return bool.booleanValue();
    }

    private void startDragging(float f) {
        float f2 = this.mInitialDownY;
        float f3 = f - f2;
        int i = this.mTouchSlop;
        if (f3 <= i || this.mIsBeingDragged) {
            return;
        }
        this.mInitialMotionY = f2 + i;
        this.mIsBeingDragged = true;
        this.mProgress.setAlpha(76);
    }

    private void animateOffsetToCorrectPosition(int i, android.view.animation.Animation.AnimationListener animationListener) {
        this.mFrom = i;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200L);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int i, android.view.animation.Animation.AnimationListener animationListener) {
        if (this.mScale) {
            startScaleDownReturnToStartAnimation(i, animationListener);
            return;
        }
        this.mFrom = i;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(200L);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToStartPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToStart(float f) {
        int i = this.mFrom;
        setTargetOffsetTopAndBottom((i + ((int) ((this.mOriginalOffsetTop - i) * f))) - this.mCircleView.getTop(), false);
    }

    private void startScaleDownReturnToStartAnimation(int i, android.view.animation.Animation.AnimationListener animationListener) {
        this.mFrom = i;
        if (isAlphaUsedForScale()) {
            this.mStartingScale = this.mProgress.getAlpha();
        } else {
            this.mStartingScale = com.dcloud.android.v4.view.ViewCompat.getScaleX(this.mCircleView);
        }
        android.view.animation.Animation animation = new android.view.animation.Animation() { // from class: io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.9
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, android.view.animation.Transformation transformation) {
                io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.setAnimationProgress(io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mStartingScale + ((-io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.mStartingScale) * f));
                io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.this.moveToStart(f);
            }
        };
        this.mScaleDownToStartAnimation = animation;
        animation.setDuration(150L);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetOffsetTopAndBottom(int i, boolean z) {
        this.mCircleLayout.bringToFront();
        com.dcloud.android.v4.view.ViewCompat.offsetTopAndBottom(this.mCircleView, i);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    private void onSecondaryPointerUp(android.view.MotionEvent motionEvent) {
        int actionIndex = com.dcloud.android.v4.view.MotionEventCompat.getActionIndex(motionEvent);
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}
