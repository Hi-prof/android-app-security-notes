package com.dcloud.android.v4.widget;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout extends android.view.ViewGroup implements com.dcloud.android.v4.view.NestedScrollingParent, com.dcloud.android.v4.view.NestedScrollingChild, com.dcloud.android.v4.widget.IRefreshAble {
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    private static final int CIRCLE_BG_LIGHT = -328966;
    private static final int CIRCLE_DIAMETER = 40;
    private static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = -1;
    public static final int LARGE = 0;
    private static final int[] LAYOUT_ATTRS = {android.R.attr.enabled};
    private static final java.lang.String LOG_TAG = "SwipeRefreshLayout";
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    static final int PULL_BOTTOM = -1;
    static final int PULL_DEGREE_GAP = 40;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int F_OriginalOffsetTop;
    private float F_SpinnerFinalOffset;
    private float F_TotalDragDistance;
    private boolean isSetOffset;
    private android.view.animation.Animation mAlphaMaxAnimation;
    private android.view.animation.Animation mAlphaStartAnimation;
    private final android.view.animation.Animation mAnimateToCorrectPosition;
    private final android.view.animation.Animation mAnimateToStartPosition;
    boolean mBeginRefresh;
    private int mCircleHeight;
    private com.dcloud.android.v4.widget.CircleImageView mCircleView;
    private int mCircleViewIndex;
    private int mCircleWidth;
    private int mCurrentTargetOffsetTop;
    private final android.view.animation.DecelerateInterpolator mDecelerateInterpolator;
    android.view.View mDrawParentView;
    protected int mFrom;
    boolean mHandledDown;
    private float mInitialDownX;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    org.json.JSONObject mJsonData;
    private com.dcloud.android.v4.widget.IRefreshAble.OnRefreshListener mListener;
    private int mMediumAnimationDuration;
    private final com.dcloud.android.v4.view.NestedScrollingChildHelper mNestedScrollingChildHelper;
    private final com.dcloud.android.v4.view.NestedScrollingParentHelper mNestedScrollingParentHelper;
    private boolean mNotify;
    private boolean mOriginalOffsetCalculated;
    protected int mOriginalOffsetTop;
    private final int[] mParentScrollConsumed;
    android.view.View mParentView;
    private final android.view.animation.Animation mPeek;
    private boolean mPlusRefreshing;
    private com.dcloud.android.v4.widget.MaterialProgressDrawable mProgress;
    int mPullDirect;
    private boolean mRefreshEnable;
    private android.view.animation.Animation.AnimationListener mRefreshListener;
    private boolean mRefreshing;
    private boolean mReturningToStart;
    private boolean mScale;
    private android.view.animation.Animation mScaleAnimation;
    private android.view.animation.Animation mScaleDownAnimation;
    private android.view.animation.Animation mScaleDownToStartAnimation;
    private float mSpinnerFinalOffset;
    private float mStartingScale;
    private android.view.View mTarget;
    private float mTotalDragDistance;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    boolean mUseSys;
    private boolean mUsingCustomStart;

    public SwipeRefreshLayout(android.content.Context context, android.util.AttributeSet attributeSet, boolean z) {
        super(context);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mOriginalOffsetCalculated = false;
        this.mIsBeingDragged = false;
        this.mCircleViewIndex = -1;
        this.mPlusRefreshing = false;
        this.mRefreshListener = new android.view.animation.Animation.AnimationListener() { // from class: com.dcloud.android.v4.widget.SwipeRefreshLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                if (com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mRefreshing) {
                    com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mProgress.setAlpha(255);
                    com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mProgress.start();
                    com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mPlusRefreshing = true;
                    if (com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mNotify && com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mListener != null) {
                        com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mListener.onRefresh(3);
                    }
                } else {
                    com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mProgress.stop();
                    com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mPlusRefreshing = false;
                    com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mCircleView.setVisibility(8);
                    com.dcloud.android.v4.widget.SwipeRefreshLayout.this.setColorViewAlpha(255);
                    if (com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mScale) {
                        com.dcloud.android.v4.widget.SwipeRefreshLayout.this.setAnimationProgress(0.0f);
                    } else {
                        com.dcloud.android.v4.widget.SwipeRefreshLayout swipeRefreshLayout = com.dcloud.android.v4.widget.SwipeRefreshLayout.this;
                        swipeRefreshLayout.setTargetOffsetTopAndBottom(swipeRefreshLayout.mOriginalOffsetTop - swipeRefreshLayout.mCurrentTargetOffsetTop, true);
                    }
                }
                com.dcloud.android.v4.widget.SwipeRefreshLayout swipeRefreshLayout2 = com.dcloud.android.v4.widget.SwipeRefreshLayout.this;
                swipeRefreshLayout2.mCurrentTargetOffsetTop = swipeRefreshLayout2.mCircleView.getTop();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
                com.dcloud.android.v4.widget.SwipeRefreshLayout.this.parentInvalidate();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
            }
        };
        this.mUseSys = false;
        this.mBeginRefresh = false;
        this.isSetOffset = false;
        this.mJsonData = null;
        this.mDrawParentView = null;
        this.mParentView = null;
        this.mPullDirect = -1;
        this.mRefreshEnable = true;
        this.mHandledDown = false;
        this.mAnimateToCorrectPosition = new android.view.animation.Animation() { // from class: com.dcloud.android.v4.widget.SwipeRefreshLayout.7
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, android.view.animation.Transformation transformation) {
                float fAbs = !com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mUsingCustomStart ? com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mSpinnerFinalOffset - java.lang.Math.abs(com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mOriginalOffsetTop) : com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mSpinnerFinalOffset;
                com.dcloud.android.v4.widget.SwipeRefreshLayout swipeRefreshLayout = com.dcloud.android.v4.widget.SwipeRefreshLayout.this;
                int i = swipeRefreshLayout.mFrom;
                com.dcloud.android.v4.widget.SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((i + ((int) ((((int) fAbs) - i) * f))) - swipeRefreshLayout.mCircleView.getTop(), false);
                com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mProgress.setArrowScale(1.0f - f);
            }
        };
        this.mPeek = new android.view.animation.Animation() { // from class: com.dcloud.android.v4.widget.SwipeRefreshLayout.8
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, android.view.animation.Transformation transformation) {
                float fAbs = !com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mUsingCustomStart ? com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mSpinnerFinalOffset - java.lang.Math.abs(com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mOriginalOffsetTop) : com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mSpinnerFinalOffset;
                com.dcloud.android.v4.widget.SwipeRefreshLayout swipeRefreshLayout = com.dcloud.android.v4.widget.SwipeRefreshLayout.this;
                int i = swipeRefreshLayout.mFrom;
                com.dcloud.android.v4.widget.SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((i + ((int) ((((int) fAbs) - i) * f))) - swipeRefreshLayout.mCircleView.getTop(), false);
                com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mProgress.setArrowScale(1.0f - f);
            }
        };
        this.mAnimateToStartPosition = new android.view.animation.Animation() { // from class: com.dcloud.android.v4.widget.SwipeRefreshLayout.9
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, android.view.animation.Transformation transformation) {
                com.dcloud.android.v4.widget.SwipeRefreshLayout.this.moveToStart(f);
            }
        };
        this.mTouchSlop = android.view.ViewConfiguration.get(context).getScaledTouchSlop();
        this.mUseSys = z;
        this.mMediumAnimationDuration = getResources().getInteger(android.R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new android.view.animation.DecelerateInterpolator(DECELERATE_INTERPOLATION_FACTOR);
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
            setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
            typedArrayObtainStyledAttributes.recycle();
        }
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i = (int) (displayMetrics.density * 40.0f);
        this.mCircleWidth = i;
        this.mCircleHeight = i;
        createProgressView();
        com.dcloud.android.v4.view.ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        float f = displayMetrics.density * 64.0f;
        this.mSpinnerFinalOffset = f;
        this.mTotalDragDistance = f;
        this.F_SpinnerFinalOffset = f;
        this.F_TotalDragDistance = f;
        this.mNestedScrollingParentHelper = new com.dcloud.android.v4.view.NestedScrollingParentHelper(this);
        this.mNestedScrollingChildHelper = new com.dcloud.android.v4.view.NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
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

    private void cancelRefresh() {
        this.mRefreshing = false;
        this.mProgress.setStartEndTrim(0.0f, 0.0f);
        animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, !this.mScale ? new android.view.animation.Animation.AnimationListener() { // from class: com.dcloud.android.v4.widget.SwipeRefreshLayout.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                if (com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mCircleView != null) {
                    com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mCircleView.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
            }
        } : null);
        this.mProgress.showArrow(false);
    }

    private void createProgressView() {
        this.mCircleView = new com.dcloud.android.v4.widget.CircleImageView(getContext(), -328966, 20.0f, false);
        com.dcloud.android.v4.widget.MaterialProgressDrawable materialProgressDrawable = new com.dcloud.android.v4.widget.MaterialProgressDrawable(getContext(), this);
        this.mProgress = materialProgressDrawable;
        materialProgressDrawable.setBackgroundColor(-328966);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            for (int i = 0; i < getChildCount(); i++) {
                android.view.View childAt = getChildAt(i);
                if (!childAt.equals(this.mCircleView)) {
                    this.mTarget = childAt;
                    return;
                }
            }
        }
    }

    private void finishSpinner(float f) {
        if (f > this.mTotalDragDistance) {
            setRefreshing(true, true);
        } else {
            cancelRefresh();
        }
    }

    private boolean handleTouchEvent(android.view.MotionEvent motionEvent) {
        if (isRefreshing()) {
            return false;
        }
        return motionEvent.getAction() == 0 || this.mHandledDown;
    }

    private boolean isAlphaUsedForScale() {
        return false;
    }

    private boolean isAnimationRunning(android.view.animation.Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private boolean isDrawAble() {
        if (this.mCircleView.getVisibility() != 0 || this.mCircleView.getTop() <= this.mOriginalOffsetTop - this.mCircleView.getMeasuredHeight()) {
            return false;
        }
        return this.mParentView.getScrollY() <= 0 || this.mPlusRefreshing;
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
        float f3 = this.mTotalDragDistance;
        if (f < f3) {
            if (this.mScale) {
                setAnimationProgress(f / f3);
            }
            if (this.mProgress.getAlpha() > 76 && !isAnimationRunning(this.mAlphaStartAnimation)) {
                startProgressAlphaStartAnimation();
            }
            this.mProgress.setStartEndTrim(0.0f, java.lang.Math.min(MAX_PROGRESS_ANGLE, fMax * MAX_PROGRESS_ANGLE));
            this.mProgress.setArrowScale(java.lang.Math.min(1.0f, fMax));
        } else if (this.mProgress.getAlpha() < 255 && !isAnimationRunning(this.mAlphaMaxAnimation)) {
            startProgressAlphaMaxAnimation();
            this.mProgress.setStartEndTrim(0.0f, MAX_PROGRESS_ANGLE);
            this.mProgress.setArrowScale(1.0f);
        }
        this.mProgress.setProgressRotation((((fMax * 0.4f) - 0.25f) + (fPow * DECELERATE_INTERPOLATION_FACTOR)) * 0.5f);
        setTargetOffsetTopAndBottom(i - this.mCurrentTargetOffsetTop, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToStart(float f) {
        int i = this.mFrom;
        setTargetOffsetTopAndBottom((i + ((int) ((this.mOriginalOffsetTop - i) * f))) - this.mCircleView.getTop(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parentInvalidate() {
        if (!isDrawAble() || this.mParentView == null) {
            return;
        }
        android.util.Log.d("parentInvalidate", "parentInvalidate");
        int width = ((this.mParentView.getWidth() - this.mCircleWidth) / 2) + this.mParentView.getScrollX();
        int scrollY = this.mOriginalOffsetTop + this.mCircleHeight + this.mParentView.getScrollY();
        this.mDrawParentView.invalidate(width, scrollY, this.mCircleWidth + width, this.mCircleView.getTop() + scrollY + this.mCircleHeight);
    }

    private void peek(int i, android.view.animation.Animation.AnimationListener animationListener) {
        this.mFrom = i;
        this.mPeek.reset();
        this.mPeek.setDuration(500L);
        this.mPeek.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mPeek);
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
    public void setColorViewAlpha(int i) {
        this.mCircleView.getBackground().setAlpha(i);
        this.mProgress.setAlpha(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetOffsetTopAndBottom(int i, boolean z) {
        this.mCircleView.bringToFront();
        this.mCircleView.offsetTopAndBottom(i);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    private android.view.animation.Animation startAlphaAnimation(final int i, final int i2) {
        if (this.mScale && isAlphaUsedForScale()) {
            return null;
        }
        android.view.animation.Animation animation = new android.view.animation.Animation() { // from class: com.dcloud.android.v4.widget.SwipeRefreshLayout.4
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, android.view.animation.Transformation transformation) {
                com.dcloud.android.v4.widget.MaterialProgressDrawable materialProgressDrawable = com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mProgress;
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

    private void startProgressAlphaMaxAnimation() {
        this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 255);
    }

    private void startProgressAlphaStartAnimation() {
        this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 76);
    }

    private void startScaleDownAnimation(android.view.animation.Animation.AnimationListener animationListener) {
        android.view.animation.Animation animation = new android.view.animation.Animation() { // from class: com.dcloud.android.v4.widget.SwipeRefreshLayout.3
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, android.view.animation.Transformation transformation) {
                com.dcloud.android.v4.widget.SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.mScaleDownAnimation = animation;
        animation.setDuration(150L);
        this.mCircleView.setAnimationListener(animationListener);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    private void startScaleDownReturnToStartAnimation(int i, android.view.animation.Animation.AnimationListener animationListener) {
        this.mFrom = i;
        if (isAlphaUsedForScale()) {
            this.mStartingScale = this.mProgress.getAlpha();
        } else {
            this.mStartingScale = com.dcloud.android.v4.view.ViewCompat.getScaleX(this.mCircleView);
        }
        android.view.animation.Animation animation = new android.view.animation.Animation() { // from class: com.dcloud.android.v4.widget.SwipeRefreshLayout.10
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, android.view.animation.Transformation transformation) {
                com.dcloud.android.v4.widget.SwipeRefreshLayout.this.setAnimationProgress(com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mStartingScale + ((-com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mStartingScale) * f));
                com.dcloud.android.v4.widget.SwipeRefreshLayout.this.moveToStart(f);
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

    private void startScaleUpAnimation(android.view.animation.Animation.AnimationListener animationListener) {
        this.mCircleView.setVisibility(0);
        this.mProgress.setAlpha(255);
        android.view.animation.Animation animation = new android.view.animation.Animation() { // from class: com.dcloud.android.v4.widget.SwipeRefreshLayout.2
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, android.view.animation.Transformation transformation) {
                com.dcloud.android.v4.widget.SwipeRefreshLayout.this.setAnimationProgress(f);
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

    @Override // com.dcloud.android.v4.widget.IRefreshAble
    public void beginRefresh() {
        if (this.mBeginRefresh || this.mCircleView.getVisibility() == 0) {
            return;
        }
        post(new java.lang.Runnable() { // from class: com.dcloud.android.v4.widget.SwipeRefreshLayout.5
            int offset = 0;

            @Override // java.lang.Runnable
            public void run() {
                if (this.offset >= com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mTotalDragDistance) {
                    com.dcloud.android.v4.widget.SwipeRefreshLayout.this.setRefreshing(true, true);
                    com.dcloud.android.v4.widget.SwipeRefreshLayout.this.mBeginRefresh = false;
                } else {
                    com.dcloud.android.v4.widget.SwipeRefreshLayout.this.moveSpinner(this.offset);
                    com.dcloud.android.v4.widget.SwipeRefreshLayout.this.postDelayed(this, 1L);
                    this.offset += 15;
                }
            }
        });
        this.mBeginRefresh = true;
    }

    public boolean canChildScrollUp() {
        android.view.View view = this.mTarget;
        if (view != null) {
            return com.dcloud.android.v4.view.ViewCompat.canScrollVertically(view, -1);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        if (this.mUseSys) {
            super.dispatchDraw(canvas);
        } else {
            parentInvalidate();
        }
    }

    @Override // android.view.View, com.dcloud.android.v4.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, com.dcloud.android.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, com.dcloud.android.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, com.dcloud.android.v4.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // com.dcloud.android.v4.widget.IRefreshAble
    public void endRefresh() {
        setRefreshing(false);
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

    @Override // android.view.ViewGroup, com.dcloud.android.v4.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        com.dcloud.android.v4.widget.CircleImageView circleImageView = this.mCircleView;
        if (circleImageView != null) {
            return circleImageView.getMeasuredHeight();
        }
        return 0;
    }

    @Override // android.view.View, com.dcloud.android.v4.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
    }

    @Override // com.dcloud.android.v4.widget.IRefreshAble
    public boolean hasRefreshOperator() {
        return this.mIsBeingDragged || isRefreshing();
    }

    @Override // android.view.View, com.dcloud.android.v4.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }

    @Override // com.dcloud.android.v4.widget.IRefreshAble
    public boolean isRefreshEnable() {
        return this.mRefreshEnable;
    }

    @Override // com.dcloud.android.v4.widget.IRefreshAble
    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    @Override // com.dcloud.android.v4.widget.IRefreshAble
    public void onInit(android.view.ViewGroup viewGroup, android.view.View view, com.dcloud.android.v4.widget.IRefreshAble.OnRefreshListener onRefreshListener) {
        this.mParentView = view;
        this.mDrawParentView = view;
        setOnRefreshListener(onRefreshListener);
        viewGroup.addView(this, -1, -1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.mTarget == null) {
            ensureTarget();
        }
        int measuredWidth2 = this.mCircleView.getMeasuredWidth();
        int measuredHeight = this.mCircleView.getMeasuredHeight();
        int i5 = measuredWidth / 2;
        int i6 = measuredWidth2 / 2;
        int i7 = this.mCurrentTargetOffsetTop;
        this.mCircleView.layout(i5 - i6, i7, i5 + i6, measuredHeight + i7);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mTarget == null) {
            ensureTarget();
        }
        this.mCircleView.measure(android.view.View.MeasureSpec.makeMeasureSpec(this.mCircleWidth, 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(this.mCircleHeight, 1073741824));
        if (!this.mUsingCustomStart && !this.mOriginalOffsetCalculated) {
            this.mOriginalOffsetCalculated = true;
            int i3 = -this.mCircleView.getMeasuredHeight();
            this.mOriginalOffsetTop = i3;
            this.mCurrentTargetOffsetTop = i3;
            this.F_OriginalOffsetTop = i3;
        }
        this.mCircleViewIndex = -1;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == this.mCircleView) {
                this.mCircleViewIndex = i4;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.dcloud.android.v4.view.NestedScrollingParent
    public boolean onNestedFling(android.view.View view, float f, float f2, boolean z) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.dcloud.android.v4.view.NestedScrollingParent
    public boolean onNestedPreFling(android.view.View view, float f, float f2) {
        return false;
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
        int[] iArr2 = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.dcloud.android.v4.view.NestedScrollingParent
    public void onNestedScroll(android.view.View view, int i, int i2, int i3, int i4) {
        if (i4 < 0) {
            float fAbs = this.mTotalUnconsumed + java.lang.Math.abs(i4);
            this.mTotalUnconsumed = fAbs;
            moveSpinner(fAbs);
        }
        dispatchNestedScroll(i, i2, i3, i, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.dcloud.android.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(android.view.View view, android.view.View view2, int i) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i);
        this.mTotalUnconsumed = 0.0f;
    }

    @Override // com.dcloud.android.v4.widget.IRefreshAble
    public void onResize(int i, int i2, float f) {
        parseData(this.mJsonData, i, i2, f);
    }

    @Override // com.dcloud.android.v4.widget.IRefreshAble
    public void onSelfDraw(android.graphics.Canvas canvas) {
        if (isDrawAble()) {
            canvas.save();
            int measuredWidth = this.mCircleView.getMeasuredWidth();
            int measuredHeight = this.mCircleView.getMeasuredHeight();
            int width = ((this.mParentView.getWidth() - measuredWidth) / 2) + this.mParentView.getScrollX();
            int iMax = java.lang.Math.max((this.mParentView.getScrollY() - measuredHeight) + this.mCircleView.getTop(), this.mOriginalOffsetTop);
            canvas.clipRect(width, iMax, measuredWidth + width, iMax + measuredHeight);
            canvas.translate(this.mParentView.getScrollX(), this.mParentView.getScrollY() - measuredHeight);
            super.dispatchDraw(canvas);
            canvas.restore();
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0098  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:40:0x00aa  */
    @Override // com.dcloud.android.v4.widget.IRefreshAble
    public boolean onSelfTouchEvent(android.view.MotionEvent motionEvent) {
        boolean z;
        float y;
        if (!handleTouchEvent(motionEvent)) {
            return false;
        }
        int actionMasked = com.dcloud.android.v4.view.MotionEventCompat.getActionMasked(motionEvent);
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp()) {
            z = false;
        } else {
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    y = motionEvent.getY();
                    if (this.mIsBeingDragged) {
                        finishSpinner((y - this.mInitialMotionY) * 0.5f);
                        z = true;
                    } else {
                        z = false;
                    }
                    this.mInitialDownY = 0.0f;
                    this.mIsBeingDragged = false;
                    this.mHandledDown = false;
                } else if (actionMasked == 2) {
                    float y2 = motionEvent.getY();
                    float f = y2 - this.mInitialDownY;
                    float x = motionEvent.getX();
                    if (f > this.mTouchSlop && !this.mIsBeingDragged && (java.lang.Math.atan(java.lang.Math.abs(x - this.mInitialDownX) / java.lang.Math.abs(y2 - this.mInitialDownY)) * 180.0d) / 3.141592653589793d < 40.0d) {
                        this.mInitialMotionY = this.mInitialDownY + this.mTouchSlop;
                        this.mIsBeingDragged = true;
                        this.mProgress.setAlpha(76);
                    }
                    if (this.mIsBeingDragged) {
                        float f2 = (y2 - this.mInitialMotionY) * 0.5f;
                        if (f2 > 0.0f) {
                            moveSpinner(f2);
                        }
                        z = true;
                    }
                } else if (actionMasked == 3) {
                    y = motionEvent.getY();
                    if (this.mIsBeingDragged) {
                        finishSpinner((y - this.mInitialMotionY) * 0.5f);
                        z = true;
                    } else {
                        z = false;
                    }
                    this.mInitialDownY = 0.0f;
                    this.mIsBeingDragged = false;
                    this.mHandledDown = false;
                }
            } else if (this.mIsBeingDragged) {
                moveSpinner(this.mOriginalOffsetTop);
                this.mIsBeingDragged = false;
            } else {
                this.mHandledDown = true;
                setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop(), true);
                float y3 = motionEvent.getY();
                if (y3 != -1.0f) {
                    this.mInitialDownY = y3;
                    this.mInitialDownX = motionEvent.getX();
                }
            }
            z = false;
        }
        if (z) {
            parentInvalidate();
        }
        return z || this.mUseSys;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.dcloud.android.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(android.view.View view, android.view.View view2, int i) {
        int i2;
        if (!isEnabled() || (i2 = i & 2) == 0) {
            return false;
        }
        startNestedScroll(i2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.dcloud.android.v4.view.NestedScrollingParent
    public void onStopNestedScroll(android.view.View view) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view);
        float f = this.mTotalUnconsumed;
        if (f > 0.0f) {
            finishSpinner(f);
            this.mTotalUnconsumed = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.mUseSys) {
            return onSelfTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.dcloud.android.v4.widget.IRefreshAble
    public void parseData(org.json.JSONObject jSONObject, int i, int i2, float f) {
        if (f == 0.0f || f == 1.0f) {
            try {
                f = this.mParentView.getContext().getResources().getDisplayMetrics().density;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.mOriginalOffsetTop = this.F_OriginalOffsetTop;
        this.mSpinnerFinalOffset = this.F_SpinnerFinalOffset;
        this.mTotalDragDistance = this.F_TotalDragDistance;
        this.mJsonData = jSONObject;
        java.lang.String strOptString = jSONObject.optString("offset");
        int iConvertToScreenInt = this.mOriginalOffsetTop;
        if (!android.text.TextUtils.isEmpty(strOptString)) {
            iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString, i2, iConvertToScreenInt, f);
        }
        java.lang.String strOptString2 = jSONObject.optString("height");
        int iConvertToScreenInt2 = (int) this.mTotalDragDistance;
        if (!android.text.TextUtils.isEmpty(strOptString2)) {
            iConvertToScreenInt2 = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString2, i2, iConvertToScreenInt2, f);
        }
        java.lang.String strOptString3 = jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_RANGE);
        int iConvertToScreenInt3 = (int) this.mSpinnerFinalOffset;
        if (!android.text.TextUtils.isEmpty(strOptString3)) {
            iConvertToScreenInt3 = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString3, i2, iConvertToScreenInt3, f);
        }
        int i3 = iConvertToScreenInt3 + iConvertToScreenInt;
        java.lang.String strOptString4 = jSONObject.optString("color");
        int color = android.graphics.Color.parseColor("#2BD009");
        if (!android.text.TextUtils.isEmpty(strOptString4) && strOptString4.startsWith("#")) {
            try {
                color = android.graphics.Color.parseColor(strOptString4);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        setColorSchemeColors(color);
        if (this.mOriginalOffsetTop != iConvertToScreenInt) {
            this.isSetOffset = false;
        }
        if (this.isSetOffset) {
            return;
        }
        this.isSetOffset = true;
        setProgressViewOffset(false, iConvertToScreenInt, i3, iConvertToScreenInt2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        android.view.View view = this.mTarget;
        if (view == null || com.dcloud.android.v4.view.ViewCompat.isNestedScrollingEnabled(view)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    @java.lang.Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        ensureTarget();
        this.mProgress.setColorSchemeColors(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        android.content.res.Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = resources.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i) {
        this.mTotalDragDistance = i;
    }

    @Override // android.view.View, com.dcloud.android.v4.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.mNestedScrollingChildHelper.setNestedScrollingEnabled(z);
    }

    public void setOnRefreshListener(com.dcloud.android.v4.widget.IRefreshAble.OnRefreshListener onRefreshListener) {
        this.mListener = onRefreshListener;
    }

    @java.lang.Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.mCircleView.setBackgroundColor(i);
        this.mProgress.setBackgroundColor(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(getResources().getColor(i));
    }

    public void setProgressViewEndTarget(boolean z, int i) {
        this.mSpinnerFinalOffset = i;
        this.mScale = z;
        this.mCircleView.invalidate();
    }

    public void setProgressViewOffset(boolean z, int i, int i2, int i3) {
        this.mScale = z;
        this.mCircleView.setVisibility(8);
        this.mCurrentTargetOffsetTop = i;
        this.mOriginalOffsetTop = i;
        this.mSpinnerFinalOffset = i2;
        this.mTotalDragDistance = i3;
        this.mUsingCustomStart = true;
        this.mCircleView.invalidate();
    }

    @Override // com.dcloud.android.v4.widget.IRefreshAble
    public void setRefreshEnable(boolean z) {
        this.mRefreshEnable = z;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.mRefreshing == z) {
            setRefreshing(z, true);
            return;
        }
        this.mRefreshing = z;
        setTargetOffsetTopAndBottom(((int) (!this.mUsingCustomStart ? this.mSpinnerFinalOffset + this.mOriginalOffsetTop : this.mSpinnerFinalOffset)) - this.mCurrentTargetOffsetTop, true);
        this.mNotify = false;
        startScaleUpAnimation(this.mRefreshListener);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                int i2 = (int) (displayMetrics.density * 56.0f);
                this.mCircleWidth = i2;
                this.mCircleHeight = i2;
            } else {
                int i3 = (int) (displayMetrics.density * 40.0f);
                this.mCircleWidth = i3;
                this.mCircleHeight = i3;
            }
            this.mCircleView.setImageDrawable(null);
            this.mProgress.updateSizes(i);
            this.mCircleView.setImageDrawable(this.mProgress);
        }
    }

    @Override // android.view.View, com.dcloud.android.v4.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.mNestedScrollingChildHelper.startNestedScroll(i);
    }

    @Override // android.view.View, com.dcloud.android.v4.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.stopNestedScroll();
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

    public SwipeRefreshLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, true);
    }
}
