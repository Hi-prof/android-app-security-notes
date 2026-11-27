package io.dcloud.common.adapter.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class AdaFrameView extends io.dcloud.common.adapter.ui.AdaContainerFrameItem implements io.dcloud.common.DHInterface.IFrameView {
    private static final int ERROR = 0;
    private static final int SUCCESS = 1;
    public boolean inStack;
    public boolean interceptTouchEvent;
    public boolean isChildOfFrameView;
    private boolean isTabItem;
    public boolean isTouchEvent;
    public java.lang.String mAccelerationType;
    public boolean mAnimationCapture;
    android.view.animation.Animation.AnimationListener mAnimationListener;
    protected boolean mAnimationStarted;
    io.dcloud.common.adapter.ui.BounceView mBounceView;
    private android.os.Handler mCaptureHandler;
    private com.dcloud.android.v4.widget.IRefreshAble mCircleRefreshView;
    private android.content.Context mContext;
    private io.dcloud.common.DHInterface.ICallBack mErrCallBack;
    protected byte mFrameStatus;
    private int mFrameType;
    private int mLastScreenHeight;
    private java.util.ArrayList<io.dcloud.common.DHInterface.IEventCallback> mListeners;
    public android.graphics.Bitmap mLoadingSnapshot;
    public java.lang.String mNativeViewAction;
    private io.dcloud.common.adapter.ui.DHImageView mPageCImageView;
    io.dcloud.common.adapter.ui.RefreshView mRefreshView;
    public android.graphics.Bitmap mSnapshot;
    private io.dcloud.common.DHInterface.ICallBack mSucCallBack;
    public io.dcloud.common.core.ui.l mWindowMgr;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface OnAnimationEnd {
        void onDone();
    }

    protected AdaFrameView(android.content.Context context, int i, java.lang.Object obj) {
        super(context);
        this.isChildOfFrameView = false;
        this.mLoadingSnapshot = null;
        this.mSnapshot = null;
        this.mNativeViewAction = "none";
        this.mAnimationStarted = false;
        this.mRefreshView = null;
        this.mBounceView = null;
        this.mCircleRefreshView = null;
        this.mListeners = null;
        this.mFrameType = 0;
        this.mAccelerationType = "auto";
        this.inStack = true;
        this.interceptTouchEvent = true;
        this.isTouchEvent = true;
        this.mPageCImageView = null;
        this.mLastScreenHeight = 0;
        this.mAnimationCapture = false;
        this.mSucCallBack = null;
        this.mErrCallBack = null;
        this.mCaptureHandler = new android.os.Handler() { // from class: io.dcloud.common.adapter.ui.AdaFrameView.4
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what != 1) {
                    if (io.dcloud.common.adapter.ui.AdaFrameView.this.mErrCallBack != null) {
                        io.dcloud.common.adapter.ui.AdaFrameView.this.mErrCallBack.onCallBack(message.arg1, message.obj);
                    }
                } else if (io.dcloud.common.adapter.ui.AdaFrameView.this.mSucCallBack != null) {
                    io.dcloud.common.adapter.ui.AdaFrameView.this.mSucCallBack.onCallBack(0, null);
                }
                super.handleMessage(message);
            }
        };
        this.mAnimationListener = new android.view.animation.Animation.AnimationListener() { // from class: io.dcloud.common.adapter.ui.AdaFrameView.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener = io.dcloud.common.adapter.ui.AdaFrameView.this.mAnimatorListener;
                if (animatorListener != null) {
                    animatorListener.onAnimationEnd(null);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation animation) {
                io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener = io.dcloud.common.adapter.ui.AdaFrameView.this.mAnimatorListener;
                if (animatorListener != null) {
                    animatorListener.onAnimationRepeat(null);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation animation) {
                io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener = io.dcloud.common.adapter.ui.AdaFrameView.this.mAnimatorListener;
                if (animatorListener != null) {
                    animatorListener.onAnimationStart(null);
                }
            }
        };
        this.isTabItem = false;
        this.mFrameType = i;
        initMainView(context, i, obj);
        this.mContext = context;
        this.mNeedOrientationUpdate = true;
        this.mLastScreenHeight = io.dcloud.common.adapter.util.PlatformUtil.SCREEN_HEIGHT(context);
    }

    private void addCaptureImageView(android.view.ViewGroup viewGroup, io.dcloud.common.adapter.ui.DHImageView dHImageView, android.graphics.Bitmap bitmap) {
        if (dHImageView.getParent() != viewGroup) {
            if (dHImageView.getParent() != null) {
                ((android.view.ViewGroup) dHImageView.getParent()).removeView(dHImageView);
            }
            viewGroup.addView(dHImageView);
        }
        dHImageView.bringToFront();
        dHImageView.setImageBitmap(bitmap);
        dHImageView.removeNativeView();
        dHImageView.setVisibility(io.dcloud.common.adapter.ui.AdaFrameItem.VISIBLE);
    }

    /* JADX WARN: Code duplicated, block: B:62:0x0102 A[PHI: r7
  0x0102: PHI (r7v1 android.graphics.Bitmap) = 
  (r7v0 android.graphics.Bitmap)
  (r7v10 android.graphics.Bitmap)
  (r7v13 android.graphics.Bitmap)
  (r7v14 android.graphics.Bitmap)
 binds: [B:40:0x00b9, B:58:0x00f9, B:43:0x00bf, B:46:0x00c4] A[DONT_GENERATE, DONT_INLINE]] */
    private boolean captureAnimation(final io.dcloud.nineoldandroids.animation.Animator animator, final int i) {
        boolean z;
        if (obtainFrameOptions().isAnimationOptimization && io.dcloud.common.util.SubNViewsUtil.startAnimation(this, animator, i)) {
            return true;
        }
        if (!this.mAnimationCapture || !io.dcloud.common.util.BaseInfo.sAnimationCaptureC) {
            return false;
        }
        final android.view.ViewGroup viewGroup = (android.view.ViewGroup) obtainMainView();
        if (checkITypeofAble()) {
            return false;
        }
        final io.dcloud.common.core.ui.k kVar = (io.dcloud.common.core.ui.k) obtainWebAppRootView().obtainMainView();
        android.graphics.Bitmap bitmapCaptureView = null;
        if (this.mPageCImageView != null && kVar.getHeight() != this.mPageCImageView.getHeight()) {
            this.mPageCImageView.clear();
            this.mPageCImageView = null;
            return false;
        }
        if (this.mPageCImageView == null) {
            io.dcloud.common.adapter.ui.DHImageView rightImageView = kVar.getRightImageView();
            this.mPageCImageView = rightImageView;
            rightImageView.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        }
        if (this.mPageCImageView.isSlipping()) {
            return false;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("C页面是否启用截图动画方案:");
        sb.append(this.mAnimationCapture && io.dcloud.common.util.BaseInfo.sAnimationCaptureC);
        sb.append(" | ");
        sb.append(this.mAnimOptions.mAnimType);
        io.dcloud.common.adapter.util.Logger.e("mabo", sb.toString());
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        io.dcloud.common.DHInterface.INativeView iNativeView = this.mNativeView;
        if (iNativeView != null) {
            if (iNativeView.isAnimate()) {
                this.mPageCImageView.removeNativeView();
                this.mNativeView = null;
            } else {
                this.mPageCImageView.setImageBitmap(null);
                this.mPageCImageView.addNativeView(this, this.mNativeView);
            }
        }
        if (this.mNativeView != null) {
            z = false;
        } else if (i == 0) {
            bitmapCaptureView = this.mLoadingSnapshot;
            if (bitmapCaptureView == null && (bitmapCaptureView = this.mSnapshot) == null) {
                bitmapCaptureView = (android.os.Build.VERSION.SDK_INT >= 22 || !this.isChildOfFrameView || viewGroup.getHeight() <= obtainFrameOptions().height) ? io.dcloud.common.adapter.util.PlatformUtil.captureView(viewGroup) : io.dcloud.common.adapter.util.PlatformUtil.captureView(viewGroup, true, true, new android.graphics.Rect(0, 0, viewGroup.getWidth(), obtainFrameOptions().height), "ARGB");
                z = true;
            } else {
                z = false;
            }
        } else {
            bitmapCaptureView = this.mSnapshot;
            if (bitmapCaptureView != null) {
                z = false;
            } else {
                bitmapCaptureView = io.dcloud.common.adapter.util.PlatformUtil.captureView(viewGroup);
                z = true;
            }
        }
        long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("==============C截图耗时=");
        long j = jCurrentTimeMillis2 - jCurrentTimeMillis;
        sb2.append(j);
        io.dcloud.common.adapter.util.Logger.i("mabo", sb2.toString());
        if (j >= io.dcloud.common.util.BaseInfo.sTimeoutCapture) {
            int i2 = io.dcloud.common.util.BaseInfo.sTimeOutCount + 1;
            io.dcloud.common.util.BaseInfo.sTimeOutCount = i2;
            if (i2 > io.dcloud.common.util.BaseInfo.sTimeOutMax) {
                io.dcloud.common.util.BaseInfo.sAnimationCaptureC = false;
            }
        } else if (z) {
            io.dcloud.common.util.BaseInfo.sTimeOutCount = 0;
        }
        this.mPageCImageView.refreshImagerView();
        if (this.mNativeView == null && (bitmapCaptureView == null || io.dcloud.common.adapter.util.PlatformUtil.isWhiteBitmap(bitmapCaptureView))) {
            return false;
        }
        if (viewGroup.getMeasuredWidth() != 0 && viewGroup.getMeasuredHeight() != 0) {
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(viewGroup.getMeasuredWidth(), viewGroup.getMeasuredHeight());
            if (android.os.Build.VERSION.SDK_INT < 22 && this.isChildOfFrameView) {
                layoutParams.height = (viewGroup.getMeasuredHeight() + obtainFrameOptions().top) - (getParentFrameItem().obtainFrameOptions().isStatusbar ? io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight : 0);
                this.mPageCImageView.setPadding(0, obtainFrameOptions().top, 0, 0);
            }
            this.mPageCImageView.setLayoutParams(layoutParams);
        }
        if (this.mNativeView == null) {
            addCaptureImageView(kVar, this.mPageCImageView, bitmapCaptureView);
        } else {
            this.mPageCImageView.bringToFront();
            this.mPageCImageView.setVisibility(0);
        }
        viewGroup.setVisibility(4);
        io.dcloud.nineoldandroids.view.ViewHelper.setX(this.mPageCImageView, this.mViewOptions.left);
        int i3 = this.mViewOptions.top;
        if (this.isChildOfFrameView) {
            i3 += getParentFrameItem().obtainFrameOptions().isStatusbar ? io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight : 0;
        }
        io.dcloud.nineoldandroids.view.ViewHelper.setY(this.mPageCImageView, i3);
        android.view.animation.Animation animation = this.mAnimOptions.mAnimator;
        if (animation == null) {
            animator.setTarget(this.mPageCImageView);
            animator.addListener(new io.dcloud.nineoldandroids.animation.Animator.AnimatorListener() { // from class: io.dcloud.common.adapter.ui.AdaFrameView.1
                @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
                public void onAnimationCancel(io.dcloud.nineoldandroids.animation.Animator animator2) {
                    io.dcloud.common.util.BaseInfo.sDoingAnimation = false;
                    if (io.dcloud.common.util.BaseInfo.sOpenedCount == 0) {
                        io.dcloud.common.util.BaseInfo.sFullScreenChanged = false;
                    }
                    io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener = io.dcloud.common.adapter.ui.AdaFrameView.this.mAnimatorListener;
                    if (animatorListener != null) {
                        animatorListener.onAnimationCancel(animator2);
                    }
                }

                @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
                public void onAnimationEnd(io.dcloud.nineoldandroids.animation.Animator animator2) {
                    if (io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView != null) {
                        io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView.setIntercept(false);
                        if (i != 0) {
                            io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView.setNativeAnimationRuning(false);
                        }
                    }
                    io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener = io.dcloud.common.adapter.ui.AdaFrameView.this.mAnimatorListener;
                    if (animatorListener != null) {
                        animatorListener.onAnimationEnd(animator2);
                    }
                    byte b = io.dcloud.common.adapter.ui.AdaFrameView.this.mAnimOptions.mOption;
                    if (b == 3 || b == 1) {
                        viewGroup.setVisibility(4);
                    } else {
                        viewGroup.setVisibility(0);
                    }
                    kVar.postDelayed(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.AdaFrameView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView != null) {
                                if (io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView.isNativeView()) {
                                    io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = io.dcloud.common.adapter.ui.AdaFrameView.this;
                                    adaFrameView.handleNativeViewByAction(adaFrameView.mPageCImageView, i);
                                } else {
                                    io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView.setVisibility(4);
                                    io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView.setImageBitmap(null);
                                    io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView.removeNativeView();
                                }
                            }
                            io.dcloud.common.util.BaseInfo.sDoingAnimation = false;
                            if (io.dcloud.common.util.BaseInfo.sOpenedCount == 0) {
                                io.dcloud.common.util.BaseInfo.sFullScreenChanged = false;
                            }
                        }
                    }, (io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView == null || !io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView.isNativeView()) ? org.mozilla.universalchardet.prober.HebrewProber.NORMAL_NUN : 0);
                    animator.removeListener(this);
                }

                @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
                public void onAnimationRepeat(io.dcloud.nineoldandroids.animation.Animator animator2) {
                    io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener = io.dcloud.common.adapter.ui.AdaFrameView.this.mAnimatorListener;
                    if (animatorListener != null) {
                        animatorListener.onAnimationRepeat(animator2);
                    }
                }

                @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
                public void onAnimationStart(io.dcloud.nineoldandroids.animation.Animator animator2) {
                    if (io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView != null) {
                        io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView.setIntercept(true);
                        if (i != 0) {
                            io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView.setNativeAnimationRuning(true);
                        }
                    }
                    io.dcloud.common.util.BaseInfo.sDoingAnimation = true;
                    io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener = io.dcloud.common.adapter.ui.AdaFrameView.this.mAnimatorListener;
                    if (animatorListener != null) {
                        animatorListener.onAnimationStart(animator2);
                    }
                }
            });
            animator.start();
        } else {
            animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: io.dcloud.common.adapter.ui.AdaFrameView.2
                /* JADX WARN: Code duplicated, block: B:20:0x0055  */
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(android.view.animation.Animation animation2) {
                    int i4;
                    if (io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView != null) {
                        io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView.setIntercept(false);
                    }
                    io.dcloud.common.util.BaseInfo.sDoingAnimation = false;
                    io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener = io.dcloud.common.adapter.ui.AdaFrameView.this.mAnimatorListener;
                    if (animatorListener != null) {
                        animatorListener.onAnimationEnd(null);
                    }
                    byte b = io.dcloud.common.adapter.ui.AdaFrameView.this.mAnimOptions.mOption;
                    if (b == 3 || b == 1) {
                        viewGroup.setVisibility(4);
                    } else {
                        viewGroup.setVisibility(0);
                    }
                    if (io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView != null) {
                        io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView.setVisibility(4);
                        i4 = io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView.isNativeView() ? 0 : org.mozilla.universalchardet.prober.HebrewProber.NORMAL_NUN;
                    }
                    viewGroup.postDelayed(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.AdaFrameView.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView != null && !io.dcloud.common.util.BaseInfo.sDoingAnimation) {
                                if (io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView.isNativeView()) {
                                    io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = io.dcloud.common.adapter.ui.AdaFrameView.this;
                                    adaFrameView.handleNativeViewByAction(adaFrameView.mPageCImageView, i);
                                } else {
                                    io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView.clearAnimation();
                                    io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView.removeNativeView();
                                    io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView.setVisibility(4);
                                    io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView.setImageBitmap(null);
                                }
                            }
                            if (io.dcloud.common.util.BaseInfo.sOpenedCount == 0) {
                                io.dcloud.common.util.BaseInfo.sFullScreenChanged = false;
                            }
                        }
                    }, i4);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(android.view.animation.Animation animation2) {
                    io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener = io.dcloud.common.adapter.ui.AdaFrameView.this.mAnimatorListener;
                    if (animatorListener != null) {
                        animatorListener.onAnimationRepeat(null);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(android.view.animation.Animation animation2) {
                    if (io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView != null) {
                        io.dcloud.common.adapter.ui.AdaFrameView.this.mPageCImageView.setIntercept(true);
                    }
                    io.dcloud.common.util.BaseInfo.sDoingAnimation = true;
                    io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener = io.dcloud.common.adapter.ui.AdaFrameView.this.mAnimatorListener;
                    if (animatorListener != null) {
                        animatorListener.onAnimationStart(null);
                    }
                }
            });
            io.dcloud.common.adapter.ui.DHImageView dHImageView = this.mPageCImageView;
            if (dHImageView != null) {
                dHImageView.startAnimation(this.mAnimOptions.mAnimator);
            }
        }
        return true;
    }

    private int getFrameHeight() {
        int height = obtainMainView().getHeight();
        if (obtainMainView().getParent() == null) {
            return height;
        }
        if (obtainFrameOptions().height == -1) {
            return obtainWebAppRootView().obtainMainView().getHeight();
        }
        return obtainFrameOptions().isStatusbarDodifyHeight ? obtainFrameOptions().height + io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight : obtainFrameOptions().height;
    }

    private int indexOfViewInParent(android.view.View view, android.view.ViewGroup viewGroup) {
        int i = 0;
        while (i < viewGroup.getChildCount() && viewGroup.getChildAt(i) != view) {
            i++;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendErrorMessage(int i, java.lang.String str) {
        android.os.Message message = new android.os.Message();
        message.what = 0;
        message.arg1 = i;
        message.obj = str;
        this.mCaptureHandler.sendMessage(message);
    }

    @Override // io.dcloud.common.DHInterface.IFrameViewStatus
    public final void addFrameViewListener(io.dcloud.common.DHInterface.IEventCallback iEventCallback) {
        if (this.mListeners == null) {
            this.mListeners = new java.util.ArrayList<>();
        }
        if (iEventCallback == null || this.mListeners.contains(iEventCallback)) {
            return;
        }
        this.mListeners.add(iEventCallback);
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public void animate(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
        if (obtainMainView() instanceof com.dcloud.android.widget.AbsoluteLayout) {
            ((com.dcloud.android.widget.AbsoluteLayout) obtainMainView()).animate(iWebview, str, str2);
        }
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public void captureSnapshot(final java.lang.String str, final io.dcloud.common.DHInterface.ICallBack iCallBack, final io.dcloud.common.DHInterface.ICallBack iCallBack2) {
        new java.lang.Thread(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.AdaFrameView.5
            @Override // java.lang.Runnable
            public void run() {
                if (io.dcloud.common.adapter.ui.AdaFrameView.this.getContext() == null) {
                    return;
                }
                if (android.text.TextUtils.isEmpty(str) || !"loading".equals(str.toLowerCase(java.util.Locale.ENGLISH))) {
                    try {
                        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = io.dcloud.common.adapter.ui.AdaFrameView.this;
                        adaFrameView.mSnapshot = io.dcloud.common.adapter.util.PlatformUtil.captureView(adaFrameView.obtainMainView());
                        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView2 = io.dcloud.common.adapter.ui.AdaFrameView.this;
                        if (adaFrameView2.mSnapshot != null) {
                            adaFrameView2.mSucCallBack = iCallBack;
                            io.dcloud.common.adapter.ui.AdaFrameView.this.mCaptureHandler.sendEmptyMessage(1);
                            return;
                        } else {
                            adaFrameView2.mErrCallBack = iCallBack2;
                            io.dcloud.common.adapter.ui.AdaFrameView adaFrameView3 = io.dcloud.common.adapter.ui.AdaFrameView.this;
                            adaFrameView3.sendErrorMessage(-100, adaFrameView3.getContext().getString(io.dcloud.base.R.string.dcloud_common_screenshot_fail));
                            return;
                        }
                    } catch (java.lang.Exception unused) {
                        io.dcloud.common.adapter.ui.AdaFrameView.this.mErrCallBack = iCallBack2;
                        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView4 = io.dcloud.common.adapter.ui.AdaFrameView.this;
                        adaFrameView4.sendErrorMessage(-100, adaFrameView4.getContext().getString(io.dcloud.base.R.string.dcloud_common_screenshot_fail));
                        return;
                    }
                }
                try {
                    io.dcloud.common.adapter.ui.AdaFrameView adaFrameView5 = io.dcloud.common.adapter.ui.AdaFrameView.this;
                    adaFrameView5.mLoadingSnapshot = io.dcloud.common.adapter.util.PlatformUtil.captureView(adaFrameView5.obtainMainView());
                    io.dcloud.common.adapter.ui.AdaFrameView adaFrameView6 = io.dcloud.common.adapter.ui.AdaFrameView.this;
                    if (adaFrameView6.mLoadingSnapshot != null) {
                        adaFrameView6.mSucCallBack = iCallBack;
                        io.dcloud.common.adapter.ui.AdaFrameView.this.mCaptureHandler.sendEmptyMessage(1);
                    } else {
                        adaFrameView6.mErrCallBack = iCallBack2;
                        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView7 = io.dcloud.common.adapter.ui.AdaFrameView.this;
                        adaFrameView7.sendErrorMessage(-100, adaFrameView7.getContext().getString(io.dcloud.base.R.string.dcloud_common_screenshot_fail));
                    }
                } catch (java.lang.Exception unused2) {
                    io.dcloud.common.adapter.ui.AdaFrameView.this.mErrCallBack = iCallBack2;
                    io.dcloud.common.adapter.ui.AdaFrameView adaFrameView8 = io.dcloud.common.adapter.ui.AdaFrameView.this;
                    adaFrameView8.sendErrorMessage(-100, adaFrameView8.getContext().getString(io.dcloud.base.R.string.dcloud_common_screenshot_fail));
                }
            }
        }).start();
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00ed A[PHI: r7
  0x00ed: PHI (r7v21 int) = (r7v0 int), (r7v8 int), (r7v0 int) binds: [B:57:0x00eb, B:54:0x00e6, B:36:0x0095] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    public void changeWebParentViewRect() {
        int i;
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) obtainMainView();
        if (obtainWebviewParent() == null) {
            return;
        }
        android.view.View viewObtainMainView = obtainWebviewParent().obtainMainView();
        if (viewGroup == null || viewObtainMainView == null) {
            return;
        }
        try {
            if (viewGroup.getHeight() == viewObtainMainView.getHeight()) {
                if (viewGroup.getHeight() != viewObtainMainView.getHeight()) {
                    return;
                }
                io.dcloud.common.adapter.util.ViewOptions viewOptions = this.mViewOptions;
                if (!viewOptions.isStatusbar && (viewOptions.titleNView == null || !obtainApp().obtainStatusBarMgr().isImmersive)) {
                    return;
                }
            }
            if (obtainFrameOptions().hasBackground() && viewObtainMainView.getHeight() == obtainWebviewParent().obtainFrameOptions().height && !this.mViewOptions.isStatusbar && obtainFrameOptions().titleNView == null) {
                return;
            }
            int frameHeight = getFrameHeight();
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                android.view.View childAt = viewGroup.getChildAt(i3);
                if (childAt != viewObtainMainView) {
                    int height = childAt.getHeight();
                    if (childAt instanceof com.dcloud.android.widget.AbsoluteLayout) {
                        if (((com.dcloud.android.widget.AbsoluteLayout) childAt).getFrameView().mPosition == io.dcloud.common.adapter.util.ViewRect.DOCK_TOP) {
                            i = height;
                            frameHeight -= height;
                            i2 += i;
                        }
                    } else if (childAt instanceof io.dcloud.common.DHInterface.INativeView) {
                        if (((io.dcloud.common.DHInterface.INativeView) childAt).isDock()) {
                            height = (childAt.getTag() == null || !((childAt.getTag().equals("NavigationBar") || childAt.getTag().equals("titleNView")) && ((io.dcloud.common.DHInterface.INativeView) childAt).isStatusBar())) ? ((io.dcloud.common.DHInterface.INativeView) childAt).getInnerHeight() : ((io.dcloud.common.DHInterface.INativeView) childAt).getInnerHeight() + io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
                            if (((io.dcloud.common.DHInterface.INativeView) childAt).isDockTop()) {
                                i = height;
                            } else {
                                i = 0;
                            }
                            frameHeight -= height;
                            i2 += i;
                        }
                    } else if (childAt instanceof com.dcloud.android.widget.StatusBarView) {
                        i = height;
                        frameHeight -= height;
                        i2 += i;
                    }
                }
            }
            viewObtainMainView.getLayoutParams().height = frameHeight;
            io.dcloud.nineoldandroids.view.ViewHelper.setY(viewObtainMainView, i2);
            viewObtainMainView.requestLayout();
            viewObtainMainView.invalidate();
            if (this.inStack) {
                return;
            }
            changeWebviewRect();
        } catch (java.lang.Exception e) {
            android.util.Log.e("AdaFrameItem", e.getMessage());
        }
    }

    protected void changeWebviewRect() {
        android.view.ViewGroup viewGroupObtainWindowView = obtainWebView().obtainWindowView();
        if (viewGroupObtainWindowView.getParent() instanceof android.widget.FrameLayout) {
            viewGroupObtainWindowView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        } else if (viewGroupObtainWindowView.getParent() instanceof android.widget.LinearLayout) {
            viewGroupObtainWindowView.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
        }
        viewGroupObtainWindowView.requestLayout();
    }

    public void chkUseCaptureAnimation(boolean z, int i, boolean z2) {
        java.lang.StringBuilder sb = z ? new java.lang.StringBuilder("B页面") : new java.lang.StringBuilder("C页面");
        sb.append(i);
        java.lang.String string = sb.toString();
        boolean z3 = false;
        if (this.mAccelerationType.equals("none") && !z2) {
            this.mAnimationCapture = false;
            return;
        }
        if (!this.mAccelerationType.equals(io.dcloud.common.constant.AbsoluteConst.ACCELERATION) && this.mSnapshot == null && this.mNativeView == null && android.os.Build.VERSION.SDK_INT >= 23) {
            this.mAnimationCapture = false;
            io.dcloud.common.adapter.util.Logger.e("mabo", string + "1是否启用截图动画方案:" + this.mAnimationCapture);
            return;
        }
        if (this.mViewOptions.mUniNViewJson != null) {
            this.mAnimationCapture = false;
            return;
        }
        byte b = this.mAnimOptions.mOption;
        boolean z4 = true;
        boolean z5 = b == 3 || b == 1;
        if (this.mSnapshot == null && this.mNativeView == null && (!obtainWebView().isLoaded() || io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer < 11)) {
            this.mAnimationCapture = false;
            io.dcloud.common.adapter.util.Logger.e("mabo", string + "1是否启用截图动画方案:" + this.mAnimationCapture);
            return;
        }
        if (this.isChildOfFrameView) {
            this.mAnimationCapture = false;
            io.dcloud.common.adapter.util.Logger.e("mabo", string + "2是否启用截图动画方案:" + this.mAnimationCapture);
            return;
        }
        io.dcloud.common.adapter.util.PlatformUtil.MESURE_SCREEN_STATUSBAR_HEIGHT(obtainWebView().getActivity());
        if (this.mLastScreenHeight != io.dcloud.common.adapter.util.PlatformUtil.SCREEN_HEIGHT(this.mContext)) {
            this.mLastScreenHeight = io.dcloud.common.adapter.util.PlatformUtil.SCREEN_HEIGHT(this.mContext);
            this.mAnimationCapture = false;
            io.dcloud.common.adapter.util.Logger.e("mabo", string + "3是否启用截图动画方案:" + this.mAnimationCapture);
            return;
        }
        boolean z6 = (this.mAccelerationType.equals("auto") && !io.dcloud.common.util.PdrUtil.isEquals(this.mAnimOptions.mAnimType, io.dcloud.common.adapter.util.AnimOptions.ANIM_FADE_IN) && z5 && !io.dcloud.common.util.PdrUtil.isContains(this.mAnimOptions.mAnimType, "slide")) || this.mAccelerationType.equals(io.dcloud.common.constant.AbsoluteConst.CAPTURE);
        if (!z5) {
            io.dcloud.common.adapter.util.AnimOptions animOptions = this.mAnimOptions;
            byte b2 = animOptions.mOption;
            z3 = (z6 || io.dcloud.common.util.PdrUtil.isEquals(animOptions.mAnimType, io.dcloud.common.adapter.util.AnimOptions.ANIM_POP_IN) || io.dcloud.common.util.PdrUtil.isEquals(this.mAnimOptions.mAnimType, io.dcloud.common.adapter.util.AnimOptions.ANIM_ZOOM_FADE_OUT)) & (b2 == 4 || b2 == 0);
        } else if (z6 || io.dcloud.common.util.PdrUtil.isEquals(this.mAnimOptions.mAnimType_close, io.dcloud.common.adapter.util.AnimOptions.ANIM_POP_OUT) || io.dcloud.common.util.PdrUtil.isEquals(this.mAnimOptions.mAnimType, io.dcloud.common.adapter.util.AnimOptions.ANIM_ZOOM_FADE_IN)) {
            z3 = true;
        }
        if (this.isChildOfFrameView && io.dcloud.common.util.PdrUtil.isEquals(this.mAnimOptions.mAnimType, io.dcloud.common.adapter.util.AnimOptions.ANIM_FADE_IN)) {
            z3 = true;
        }
        if (this.mSnapshot == null && this.mNativeView == null) {
            z4 = z3;
        }
        this.mAnimationCapture = z4;
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public void clearSnapshot(java.lang.String str) {
        io.dcloud.common.adapter.ui.DHImageView dHImageView = this.mPageCImageView;
        if (dHImageView != null) {
            dHImageView.setImageBitmap(null);
        }
        if (android.text.TextUtils.isEmpty(str) || !"loading".equals(str.toLowerCase(java.util.Locale.ENGLISH))) {
            android.graphics.Bitmap bitmap = this.mSnapshot;
            if (bitmap != null) {
                try {
                    if (!bitmap.isRecycled()) {
                        this.mSnapshot.recycle();
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            this.mSnapshot = null;
            return;
        }
        android.graphics.Bitmap bitmap2 = this.mLoadingSnapshot;
        if (bitmap2 != null) {
            try {
                if (!bitmap2.isRecycled()) {
                    this.mLoadingSnapshot.recycle();
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        this.mLoadingSnapshot = null;
    }

    public final void dispatchFrameViewEvents(java.lang.String str, java.lang.Object obj) {
        if (this.mListeners != null) {
            io.dcloud.common.adapter.util.Logger.d("AdaFrameView.dispatchFrameViewEvents type=" + str + ";args=" + obj);
            for (int size = this.mListeners.size() + (-1); size >= 0; size--) {
                io.dcloud.common.DHInterface.IEventCallback iEventCallback = this.mListeners.get(size);
                if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE)) {
                    this.mListeners.remove(size);
                }
                iEventCallback.onCallBack(str, obj);
            }
        }
    }

    @Override // io.dcloud.common.adapter.ui.AdaContainerFrameItem, io.dcloud.common.adapter.ui.AdaFrameItem
    public void dispose() {
        super.dispose();
        if (this.mRefreshView != null) {
            this.mRefreshView = null;
        }
        if (this.mBounceView != null) {
            this.mBounceView = null;
        }
        if (this.mCircleRefreshView != null) {
            this.mCircleRefreshView = null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public synchronized void draw(final android.view.View view, final io.dcloud.common.DHInterface.INativeBitmap iNativeBitmap, final boolean z, final boolean z2, final boolean z3, final android.graphics.Rect rect, final java.lang.String str, final io.dcloud.common.DHInterface.ICallBack iCallBack, final io.dcloud.common.DHInterface.ICallBack iCallBack2) {
        this.mCaptureHandler.post(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.AdaFrameView.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (io.dcloud.common.adapter.ui.AdaFrameView.this.getContext() == null) {
                        return;
                    }
                    android.graphics.Bitmap bitmapCaptureWebViewContent = z3 ? io.dcloud.common.adapter.util.PlatformUtil.captureWebViewContent(view, z, z2, rect, str) : io.dcloud.common.adapter.util.PlatformUtil.captureView(view, z, z2, rect, str);
                    if (bitmapCaptureWebViewContent != null) {
                        iNativeBitmap.setBitmap(bitmapCaptureWebViewContent);
                        io.dcloud.common.adapter.ui.AdaFrameView.this.mSucCallBack = iCallBack;
                        io.dcloud.common.adapter.ui.AdaFrameView.this.mCaptureHandler.sendEmptyMessage(1);
                    } else {
                        io.dcloud.common.adapter.ui.AdaFrameView.this.mErrCallBack = iCallBack2;
                        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = io.dcloud.common.adapter.ui.AdaFrameView.this;
                        adaFrameView.sendErrorMessage(-101, adaFrameView.getContext().getString(io.dcloud.base.R.string.dcloud_common_screenshot_blank));
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    io.dcloud.common.adapter.ui.AdaFrameView.this.mErrCallBack = iCallBack2;
                    io.dcloud.common.adapter.ui.AdaFrameView adaFrameView2 = io.dcloud.common.adapter.ui.AdaFrameView.this;
                    adaFrameView2.sendErrorMessage(-100, adaFrameView2.getContext().getString(io.dcloud.base.R.string.dcloud_common_screenshot_fail));
                }
            }
        });
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public io.dcloud.common.DHInterface.IFrameView findPageB() {
        return obtainWebAppRootView().findFrameViewB(this);
    }

    public com.dcloud.android.v4.widget.IRefreshAble getCircleRefreshView() {
        return this.mCircleRefreshView;
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public int getFrameType() {
        return this.mFrameType;
    }

    public void handleNativeViewByAction(io.dcloud.common.adapter.ui.DHImageView dHImageView, int i) {
        if ("none".equals(this.mNativeViewAction) || !("hide".equals(this.mNativeViewAction) || io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE.equals(this.mNativeViewAction))) {
            if (i != 1 || dHImageView == null) {
                return;
            }
            dHImageView.clearAnimation();
            dHImageView.setVisibility(4);
            dHImageView.setImageBitmap(null);
            dHImageView.removeNativeView();
            return;
        }
        java.lang.String viewUUId = this.mNativeView.getViewUUId();
        java.lang.String str = this.mNativeViewAction;
        if (str.equalsIgnoreCase("hide")) {
            if (dHImageView != null) {
                dHImageView.setVisibility(4);
            }
        } else if (this.mNativeViewAction.equalsIgnoreCase(io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE)) {
            if (dHImageView != null) {
                dHImageView.setVisibility(4);
                dHImageView.setImageBitmap(null);
                dHImageView.removeNativeView();
            }
            str = "view_close";
        }
        this.mNativeView = null;
        this.mNativeViewAction = "none";
        if (obtainWindowMgr() != null) {
            obtainWindowMgr().processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 1, new java.lang.Object[]{obtainWebView(), "nativeobj", str, io.dcloud.common.util.JSONUtil.createJSONArray("['" + viewUUId + "','" + viewUUId + "']")});
        }
    }

    protected abstract void initMainView(android.content.Context context, int i, java.lang.Object obj);

    @Override // io.dcloud.common.DHInterface.IFrameView
    public void interceptTouchEvent(boolean z) {
        this.interceptTouchEvent = z;
    }

    public boolean isSupportLongTouch() {
        return false;
    }

    public boolean isTabItem() {
        return this.isTabItem || obtainFrameOptions().isTabItem.booleanValue();
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public boolean isWebviewCovered() {
        android.view.ViewGroup viewGroupObtainWindowView;
        io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView = obtainWebView();
        if (iWebviewObtainWebView == null || (viewGroupObtainWindowView = iWebviewObtainWebView.obtainWindowView()) == null || viewGroupObtainWindowView.getVisibility() != 0 || viewGroupObtainWindowView.getParent() == null) {
            return true;
        }
        android.graphics.Rect rect = new android.graphics.Rect(0, 0, io.dcloud.common.adapter.util.PlatformUtil.SCREEN_WIDTH(viewGroupObtainWindowView.getContext()), io.dcloud.common.adapter.util.PlatformUtil.SCREEN_HEIGHT(viewGroupObtainWindowView.getContext()));
        android.graphics.Rect rect2 = new android.graphics.Rect();
        viewGroupObtainWindowView.getGlobalVisibleRect(rect2);
        if (!rect.contains(rect2)) {
            return true;
        }
        while (viewGroupObtainWindowView.getParent() instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) viewGroupObtainWindowView.getParent();
            if (viewGroup.getVisibility() != 0) {
                return true;
            }
            for (int iIndexOfViewInParent = indexOfViewInParent(viewGroupObtainWindowView, viewGroup) + 1; iIndexOfViewInParent < viewGroup.getChildCount(); iIndexOfViewInParent++) {
                android.view.View childAt = viewGroup.getChildAt(iIndexOfViewInParent);
                if (childAt.getVisibility() == 0 && !(childAt instanceof io.dcloud.common.DHInterface.IWaiter)) {
                    android.graphics.Rect rect3 = new android.graphics.Rect();
                    childAt.getGlobalVisibleRect(rect3);
                    if (rect3.contains(rect2)) {
                        return true;
                    }
                }
            }
            viewGroupObtainWindowView = viewGroup;
        }
        return viewGroupObtainWindowView.getParent() == null;
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public abstract io.dcloud.common.DHInterface.IApp obtainApp();

    public abstract java.lang.String obtainPrePlusreadyJs();

    @Override // io.dcloud.common.DHInterface.IFrameViewStatus
    public byte obtainStatus() {
        return this.mFrameStatus;
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public abstract io.dcloud.common.DHInterface.IWebview obtainWebView();

    @Override // io.dcloud.common.DHInterface.IFrameView
    public abstract io.dcloud.common.DHInterface.AbsMgr obtainWindowMgr();

    public void onConfigurationChanged() {
    }

    @Override // io.dcloud.common.DHInterface.IFrameViewStatus
    public void onDestroy() {
        this.mFrameStatus = (byte) 4;
        transition((byte) 4);
        dispose();
    }

    @Override // io.dcloud.common.adapter.ui.AdaContainerFrameItem, io.dcloud.common.adapter.ui.AdaFrameItem
    public boolean onDispose() {
        boolean zOnDispose = super.onDispose();
        dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE, obtainWebView());
        io.dcloud.common.adapter.ui.DHImageView dHImageView = this.mPageCImageView;
        if (dHImageView != null) {
            dHImageView.setImageBitmap(null);
        }
        return zOnDispose;
    }

    public void onDrawAfter(android.graphics.Canvas canvas) {
        com.dcloud.android.v4.widget.IRefreshAble iRefreshAble;
        if (obtainMainView() == null || obtainMainView().getVisibility() != 0 || (iRefreshAble = this.mCircleRefreshView) == null || !iRefreshAble.isRefreshEnable()) {
            return;
        }
        canvas.save();
        int left = obtainWebviewParent().obtainMainView().getLeft();
        int y = (int) io.dcloud.nineoldandroids.view.ViewHelper.getY(obtainWebviewParent().obtainMainView());
        io.dcloud.common.adapter.util.ViewOptions viewOptions = this.mViewOptions;
        if (viewOptions != null && viewOptions.isStatusbar && viewOptions.titleNView == null) {
            y += io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
        }
        canvas.translate(left, y);
        this.mCircleRefreshView.onSelfDraw(canvas);
        canvas.restore();
    }

    @Override // io.dcloud.common.DHInterface.IFrameViewStatus
    public void onInit() {
        this.mFrameStatus = (byte) 0;
    }

    @Override // io.dcloud.common.DHInterface.IFrameViewStatus
    public void onLoading() {
        this.mFrameStatus = (byte) 2;
    }

    @Override // io.dcloud.common.DHInterface.IFrameViewStatus
    public void onPreLoading() {
        this.mFrameStatus = (byte) 1;
    }

    @Override // io.dcloud.common.DHInterface.IFrameViewStatus
    public void onPreShow(io.dcloud.common.DHInterface.IFrameView iFrameView) {
        this.mFrameStatus = (byte) 3;
        transition((byte) 3);
    }

    @Override // io.dcloud.common.adapter.ui.AdaContainerFrameItem, io.dcloud.common.adapter.ui.AdaFrameItem
    protected void onResize() {
        if (obtainApp() == null || !obtainApp().manifestBeParsed()) {
            return;
        }
        super.onResize();
        io.dcloud.common.adapter.ui.RefreshView refreshView = this.mRefreshView;
        if (refreshView != null) {
            refreshView.onResize();
        }
        io.dcloud.common.adapter.ui.BounceView bounceView = this.mBounceView;
        if (bounceView != null) {
            bounceView.onResize();
        }
        dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_FRAME_ONRESIZE, null);
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameItem
    public void paint(android.graphics.Canvas canvas) {
        super.paint(canvas);
        if (obtainMainView() == null || obtainMainView().getVisibility() != 0 || this.mRefreshView == null || this.isSlipping) {
            return;
        }
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.VIEW_VISIBLE_TAG, "AdaFrameView.paint mRefreshView paint" + this);
        io.dcloud.common.adapter.util.ViewOptions viewOptions = obtainWebviewParent().mViewOptions_birth;
        io.dcloud.common.adapter.util.ViewOptions viewOptions2 = obtainWebviewParent().mViewOptions;
        if (viewOptions == null) {
            viewOptions = this.mViewOptions_birth;
        }
        if (viewOptions2 == null) {
            viewOptions2 = this.mViewOptions;
        }
        int i = viewOptions.left;
        int i2 = viewOptions2.left;
        if (i == i2) {
            i2 = 0;
        }
        int i3 = viewOptions.top;
        int i4 = viewOptions2.top;
        this.mRefreshView.paint(canvas, i2 + obtainWebviewParent().obtainMainView().getLeft(), (int) ((i3 != i4 ? i4 : 0) + io.dcloud.nineoldandroids.view.ViewHelper.getY(obtainWebviewParent().obtainMainView())));
    }

    @Override // io.dcloud.common.DHInterface.IFrameViewStatus
    public final void removeFrameViewListener(io.dcloud.common.DHInterface.IEventCallback iEventCallback) {
        java.util.ArrayList<io.dcloud.common.DHInterface.IEventCallback> arrayList = this.mListeners;
        if (arrayList != null) {
            arrayList.remove(iEventCallback);
        }
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public void restore() {
        if (obtainMainView() instanceof com.dcloud.android.widget.AbsoluteLayout) {
            ((com.dcloud.android.widget.AbsoluteLayout) obtainMainView()).restore();
        }
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public void setAccelerationType(java.lang.String str) {
        this.mAccelerationType = str;
    }

    public void setCircleRefreshView(com.dcloud.android.v4.widget.IRefreshAble iRefreshAble) {
        this.mCircleRefreshView = iRefreshAble;
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public void setSnapshot(android.graphics.Bitmap bitmap) {
        android.graphics.Bitmap bitmap2 = this.mSnapshot;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.mSnapshot.recycle();
        }
        this.mSnapshot = bitmap;
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public void setSnapshotView(io.dcloud.common.DHInterface.INativeView iNativeView, java.lang.String str) {
        this.mNativeView = iNativeView;
        this.mNativeViewAction = str;
    }

    public void setTabItem(boolean z) {
        this.isTabItem = z;
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public void setVisible(boolean z, boolean z2) {
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.VIEW_VISIBLE_TAG, "AdaFrameView.setVisible pVisible" + z + "       " + this);
        setVisibility(z ? io.dcloud.common.adapter.ui.AdaFrameItem.VISIBLE : io.dcloud.common.adapter.ui.AdaFrameItem.INVISIBLE);
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameItem
    public void startAnimator(int i) {
        startAnimator(null, i);
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public void transition(byte b) {
    }

    public void updateFrameRelViewRect(io.dcloud.common.adapter.util.ViewRect viewRect) {
        io.dcloud.common.adapter.util.ViewRect parentViewRect;
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) obtainMainView();
        if (!this.mViewOptions.hasBackground()) {
            this.mViewOptions.updateViewData(viewRect);
            if (viewGroup != null && viewGroup.getVisibility() == 0 && this.mRefreshView != null) {
                obtainWebviewParent().reInit();
            }
        } else if (obtainWebviewParent().obtainFrameOptions().allowUpdate) {
            obtainWebviewParent().obtainFrameOptions().updateViewData(viewRect);
        }
        io.dcloud.common.adapter.util.ViewOptions viewOptions = this.mViewOptions;
        int i = viewOptions.top;
        int i2 = viewOptions.height;
        if (this.isChildOfFrameView && (parentViewRect = viewOptions.getParentViewRect()) != null && parentViewRect.isStatusbar && !this.mViewOptions.isStatusbar) {
            if (obtainFrameOptions().isBottomAbsolute()) {
                i2 -= io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
            }
            i += io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
        }
        android.view.View view = this.mViewImpl;
        io.dcloud.common.adapter.util.ViewOptions viewOptions2 = this.mViewOptions;
        io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.setViewLayoutParams(view, viewOptions2.left, i, viewOptions2.width, i2);
        changeWebParentViewRect();
        if (viewGroup != null) {
            obtainMainView().invalidate();
        }
    }

    public void startAnimator(final io.dcloud.common.adapter.ui.AdaFrameView.OnAnimationEnd onAnimationEnd, int i) {
        io.dcloud.common.adapter.util.AnimOptions animOptions = this.mAnimOptions;
        if (animOptions != null) {
            animOptions.mUserFrameItem = this;
            animOptions.sScreenWidth = obtainApp().getInt(0);
            this.mAnimOptions.sScreenHeight = obtainApp().getInt(1);
            io.dcloud.nineoldandroids.animation.Animator animatorCreateAnimation = this.mAnimOptions.createAnimation();
            if (obtainFrameOptions().hasBackground() && this.mAnimOptions.mOption == 2) {
                io.dcloud.common.adapter.ui.AdaWebViewParent adaWebViewParentObtainWebviewParent = obtainWebviewParent();
                this.mAnimOptions.mUserFrameItem = adaWebViewParentObtainWebviewParent;
                animatorCreateAnimation.setTarget(adaWebViewParentObtainWebviewParent.obtainMainView());
                animatorCreateAnimation.addListener(this.mAnimatorListener);
                animatorCreateAnimation.start();
            } else if (!captureAnimation(animatorCreateAnimation, i)) {
                io.dcloud.common.adapter.ui.DHImageView dHImageView = this.mPageCImageView;
                if (dHImageView != null && !dHImageView.isSlipping()) {
                    this.mPageCImageView.clearAnimation();
                    this.mPageCImageView.setVisibility(4);
                    this.mPageCImageView.setImageBitmap(null);
                }
                this.mViewImpl.bringToFront();
                android.view.animation.Animation animation = this.mAnimOptions.mAnimator;
                if (animation == null) {
                    animatorCreateAnimation.setTarget(this.mViewImpl);
                    animatorCreateAnimation.addListener(this.mAnimatorListener);
                    animatorCreateAnimation.start();
                } else {
                    animation.setAnimationListener(this.mAnimationListener);
                    this.mViewImpl.startAnimation(this.mAnimOptions.mAnimator);
                }
            }
            animatorCreateAnimation.setInterpolator(new android.view.animation.DecelerateInterpolator());
            io.dcloud.common.adapter.util.AnimOptions animOptions2 = this.mAnimOptions;
            io.dcloud.common.adapter.util.MessageHandler.sendMessage(new io.dcloud.common.adapter.util.MessageHandler.IMessages() { // from class: io.dcloud.common.adapter.ui.AdaFrameView.3
                @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
                public void execute(java.lang.Object obj) {
                    io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener;
                    io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = io.dcloud.common.adapter.ui.AdaFrameView.this;
                    if (!adaFrameView.mAnimationStarted && (animatorListener = adaFrameView.mAnimatorListener) != null) {
                        animatorListener.onAnimationEnd(null);
                    }
                    io.dcloud.common.adapter.ui.AdaFrameView.OnAnimationEnd onAnimationEnd2 = onAnimationEnd;
                    if (onAnimationEnd2 != null) {
                        onAnimationEnd2.onDone();
                    }
                    if (io.dcloud.common.util.BaseInfo.sOpenedCount == 0) {
                        io.dcloud.common.util.BaseInfo.sFullScreenChanged = false;
                    }
                }
            }, java.lang.Math.max(animOptions2.duration_show, java.lang.Math.max(animOptions2.duration_close, animOptions2.duration)), null);
        }
    }
}
