package io.dcloud.common.adapter.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class FrameSwitchView implements io.dcloud.common.DHInterface.IReflectAble {
    private static final java.lang.String POP_IN = "pop-in";
    private static final java.lang.String POP_OUT = "pop-out";
    private static final java.lang.String SLIDE_IN_RIGHT = "slide-in-right";
    private static final java.lang.String SLIDE_OUT_RIGHT = "slide-out-right";
    static io.dcloud.common.adapter.ui.FrameSwitchView mInstance;
    private android.app.Activity mActivity;
    private int mAppScreenHeight;
    private int mAppScreenWidth;
    private io.dcloud.common.adapter.ui.FrameBitmapView mLeftFrameBpView;
    private android.view.View mLeftView;
    private io.dcloud.common.adapter.ui.FrameBitmapView mRightFrameBpView;
    private android.view.View mRightView;
    private io.dcloud.common.adapter.ui.FrameSwitchView.SwitchLayout mSwitchLayout;
    private boolean isInit = false;
    private int mDuration = 300;
    private boolean isVisibility = false;
    private java.lang.String mAniType = "pop-in";
    private io.dcloud.common.DHInterface.IWebview mWebViewImpl = null;
    private java.lang.String mCallbackId = null;
    private boolean isRuning = false;
    io.dcloud.common.adapter.ui.FrameBitmapView.ClearAnimationListener clearAnimationListener = new io.dcloud.common.adapter.ui.FrameBitmapView.ClearAnimationListener() { // from class: io.dcloud.common.adapter.ui.FrameSwitchView.7
        @Override // io.dcloud.common.adapter.ui.FrameBitmapView.ClearAnimationListener
        public void onAnimationEnd() {
            io.dcloud.common.adapter.ui.FrameSwitchView.this.endRefreshView();
        }
    };

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class SwitchLayout extends android.widget.RelativeLayout implements io.dcloud.common.DHInterface.IWaiter {
        public SwitchLayout(android.content.Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
            if (!android.text.TextUtils.isEmpty(io.dcloud.common.adapter.ui.FrameSwitchView.this.mAniType)) {
                if (io.dcloud.common.adapter.ui.FrameSwitchView.this.mAniType.equals("pop-in") && io.dcloud.common.adapter.ui.FrameSwitchView.this.mRightView != null && (io.dcloud.common.adapter.ui.FrameSwitchView.this.mRightView instanceof io.dcloud.common.DHInterface.IWaiter)) {
                    return ((java.lang.Boolean) ((io.dcloud.common.DHInterface.IWaiter) io.dcloud.common.adapter.ui.FrameSwitchView.this.mRightView).doForFeature("checkTouch", motionEvent)).booleanValue();
                }
                if ((io.dcloud.common.adapter.ui.FrameSwitchView.this.mAniType.equals("slide-in-right") || io.dcloud.common.adapter.ui.FrameSwitchView.this.mAniType.equals("slide-out-right") || io.dcloud.common.adapter.ui.FrameSwitchView.this.mAniType.equals("pop-out")) && io.dcloud.common.adapter.ui.FrameSwitchView.this.mLeftView != null && (io.dcloud.common.adapter.ui.FrameSwitchView.this.mLeftView instanceof io.dcloud.common.DHInterface.IWaiter)) {
                    return ((java.lang.Boolean) ((io.dcloud.common.DHInterface.IWaiter) io.dcloud.common.adapter.ui.FrameSwitchView.this.mLeftView).doForFeature("checkTouch", motionEvent)).booleanValue();
                }
                if ((io.dcloud.common.adapter.ui.FrameSwitchView.this.mLeftFrameBpView != null && io.dcloud.common.adapter.ui.FrameSwitchView.this.mLeftFrameBpView.isInit()) || (io.dcloud.common.adapter.ui.FrameSwitchView.this.mRightFrameBpView != null && io.dcloud.common.adapter.ui.FrameSwitchView.this.mRightFrameBpView.isInit())) {
                    return super.dispatchTouchEvent(motionEvent);
                }
            }
            return io.dcloud.common.adapter.ui.FrameSwitchView.this.isRuning;
        }

        @Override // io.dcloud.common.DHInterface.IWaiter
        public java.lang.Object doForFeature(java.lang.String str, java.lang.Object obj) {
            return null;
        }

        @Override // android.view.View
        protected void onConfigurationChanged(android.content.res.Configuration configuration) {
            super.onConfigurationChanged(configuration);
            if (io.dcloud.common.adapter.ui.FrameSwitchView.this.mWebViewImpl == null || !io.dcloud.common.adapter.ui.FrameSwitchView.this.isVisibility) {
                return;
            }
            io.dcloud.common.adapter.ui.FrameSwitchView.this.stopAnimation();
        }

        @Override // android.view.View
        public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
            if (getVisibility() != 0) {
                return super.onTouchEvent(motionEvent);
            }
            if (io.dcloud.common.adapter.ui.FrameSwitchView.this.mLeftFrameBpView != null && io.dcloud.common.adapter.ui.FrameSwitchView.this.mLeftFrameBpView.isInit()) {
                return true;
            }
            if (io.dcloud.common.adapter.ui.FrameSwitchView.this.mRightFrameBpView == null || !io.dcloud.common.adapter.ui.FrameSwitchView.this.mRightFrameBpView.isInit()) {
                return super.onTouchEvent(motionEvent);
            }
            return true;
        }
    }

    private FrameSwitchView() {
    }

    private void addView(android.view.View view) {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view.getParent();
        if (viewGroup instanceof io.dcloud.common.adapter.ui.FrameSwitchView.SwitchLayout) {
            return;
        }
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        this.mSwitchLayout.addView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endAnimationLayout(android.view.View view, int i) {
        int left = view.getLeft() + i;
        int top = view.getTop();
        int width = view.getWidth();
        int height = view.getHeight();
        view.clearAnimation();
        view.layout(left, top, width + left, height + top);
    }

    private android.view.animation.TranslateAnimation getAnimation(int i, int i2, int i3, android.view.animation.Animation.AnimationListener animationListener) {
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(i, i2, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new android.view.animation.AccelerateDecelerateInterpolator());
        translateAnimation.setDuration(i3);
        translateAnimation.setAnimationListener(animationListener);
        return translateAnimation;
    }

    public static io.dcloud.common.adapter.ui.FrameSwitchView getInstance(android.app.Activity activity) {
        if (mInstance == null) {
            synchronized (io.dcloud.common.adapter.ui.FrameSwitchView.class) {
                if (mInstance == null) {
                    mInstance = new io.dcloud.common.adapter.ui.FrameSwitchView(activity);
                }
            }
        }
        return mInstance;
    }

    private void initScreenData() {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        this.mActivity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        int navigationBarHeight = displayMetrics.heightPixels - ((!io.dcloud.common.util.PdrUtil.isNavigationBarShow(this.mActivity) || io.dcloud.common.util.PdrUtil.navigationGestureEnabled(this.mActivity)) ? 0 : io.dcloud.common.util.PdrUtil.getNavigationBarHeight(this.mActivity));
        int i = displayMetrics.widthPixels;
        int[] iArr = new int[2];
        this.mWebViewImpl.obtainFrameView().obtainWebAppRootView().obtainMainView().getLocationOnScreen(iArr);
        this.mAppScreenWidth = i - iArr[0];
        this.mAppScreenHeight = navigationBarHeight - iArr[1];
        try {
            android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.mSwitchLayout.getLayoutParams();
            layoutParams.height = this.mAppScreenHeight;
            layoutParams.topMargin = iArr[1];
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void runingAnimation(final io.dcloud.common.DHInterface.IWebview iWebview, final int i, int i2, java.lang.String str, final java.lang.String str2) {
        initScreenData();
        this.isRuning = true;
        if (this.mSwitchLayout.getVisibility() != 0) {
            this.mSwitchLayout.setVisibility(0);
        }
        android.view.View view = this.mLeftView;
        if (view == null) {
            view = this.mLeftFrameBpView;
        }
        final android.view.View view2 = view;
        final android.view.View view3 = this.mRightView;
        if (view3 == null) {
            view3 = this.mRightFrameBpView;
        }
        view2.setVisibility(0);
        if (str.equals("pop-in")) {
            view3.setVisibility(0);
            this.isVisibility = true;
            view2.startAnimation(getAnimation(0, -(i / 6), this.mDuration, new android.view.animation.Animation.AnimationListener() { // from class: io.dcloud.common.adapter.ui.FrameSwitchView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(android.view.animation.Animation animation) {
                    view2.setVisibility(8);
                    io.dcloud.common.adapter.ui.FrameSwitchView.this.isRuning = false;
                    io.dcloud.common.util.BaseInfo.sDoingAnimation = false;
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, null, io.dcloud.common.util.JSUtil.OK, false, false);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(android.view.animation.Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(android.view.animation.Animation animation) {
                    io.dcloud.common.util.BaseInfo.sDoingAnimation = true;
                }
            }));
            view3.startAnimation(getAnimation(i, 0, this.mDuration, new android.view.animation.Animation.AnimationListener() { // from class: io.dcloud.common.adapter.ui.FrameSwitchView.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(android.view.animation.Animation animation) {
                    io.dcloud.common.adapter.ui.FrameSwitchView.this.endAnimationLayout(view3, 0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(android.view.animation.Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(android.view.animation.Animation animation) {
                }
            }));
            return;
        }
        if (str.equals("pop-out")) {
            view3.setVisibility(0);
            this.isVisibility = true;
            view2.startAnimation(getAnimation(-(i / 2), 0, this.mDuration, new android.view.animation.Animation.AnimationListener() { // from class: io.dcloud.common.adapter.ui.FrameSwitchView.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(android.view.animation.Animation animation) {
                    io.dcloud.common.adapter.ui.FrameSwitchView.this.endAnimationLayout(view2, 0);
                    io.dcloud.common.adapter.ui.FrameSwitchView.this.isRuning = false;
                    io.dcloud.common.util.BaseInfo.sDoingAnimation = false;
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, null, io.dcloud.common.util.JSUtil.OK, false, false);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(android.view.animation.Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(android.view.animation.Animation animation) {
                    io.dcloud.common.util.BaseInfo.sDoingAnimation = true;
                }
            }));
            view3.startAnimation(getAnimation(0, i, this.mDuration, new android.view.animation.Animation.AnimationListener() { // from class: io.dcloud.common.adapter.ui.FrameSwitchView.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(android.view.animation.Animation animation) {
                    view3.setVisibility(8);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(android.view.animation.Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(android.view.animation.Animation animation) {
                }
            }));
            return;
        }
        if (str.equals("slide-in-right")) {
            if (view3 != null) {
                view3.setVisibility(8);
            }
            this.isVisibility = true;
            view2.startAnimation(getAnimation(i, 0, this.mDuration, new android.view.animation.Animation.AnimationListener() { // from class: io.dcloud.common.adapter.ui.FrameSwitchView.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(android.view.animation.Animation animation) {
                    io.dcloud.common.adapter.ui.FrameSwitchView.this.endAnimationLayout(view2, 0);
                    io.dcloud.common.adapter.ui.FrameSwitchView.this.isRuning = false;
                    io.dcloud.common.util.BaseInfo.sDoingAnimation = false;
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, null, io.dcloud.common.util.JSUtil.OK, false, false);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(android.view.animation.Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(android.view.animation.Animation animation) {
                    io.dcloud.common.util.BaseInfo.sDoingAnimation = true;
                }
            }));
            return;
        }
        if (!str.equals("slide-out-right")) {
            this.isRuning = false;
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, null, io.dcloud.common.util.JSUtil.OK, false, false);
        } else {
            if (view3 != null) {
                view3.setVisibility(8);
            }
            this.isVisibility = true;
            view2.startAnimation(getAnimation(0, i, this.mDuration, new android.view.animation.Animation.AnimationListener() { // from class: io.dcloud.common.adapter.ui.FrameSwitchView.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(android.view.animation.Animation animation) {
                    io.dcloud.common.adapter.ui.FrameSwitchView.this.endAnimationLayout(view2, i);
                    io.dcloud.common.adapter.ui.FrameSwitchView.this.isRuning = false;
                    io.dcloud.common.util.BaseInfo.sDoingAnimation = false;
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str2, null, io.dcloud.common.util.JSUtil.OK, false, false);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(android.view.animation.Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(android.view.animation.Animation animation) {
                    io.dcloud.common.util.BaseInfo.sDoingAnimation = true;
                }
            }));
        }
    }

    public void clearData() {
        mInstance = null;
        this.mSwitchLayout = null;
        this.isInit = false;
        this.mWebViewImpl = null;
        this.mLeftFrameBpView = null;
        this.mRightFrameBpView = null;
        this.mLeftView = null;
        this.mRightView = null;
        this.mActivity = null;
    }

    public void clearSwitchAnimation(java.lang.String str) {
        endRefreshView();
    }

    public void endRefreshView() {
        if (this.isVisibility) {
            this.mLeftFrameBpView.clearAnimation();
            this.mRightFrameBpView.clearAnimation();
            this.isVisibility = false;
        }
        if (this.mSwitchLayout.getVisibility() == 0) {
            this.mSwitchLayout.setVisibility(8);
            android.view.KeyEvent.Callback callback = this.mLeftView;
            if (callback != null) {
                ((io.dcloud.common.DHInterface.IWaiter) callback).doForFeature("clearAnimate", null);
                this.mSwitchLayout.removeView(this.mLeftView);
                this.mLeftView = null;
            }
            android.view.KeyEvent.Callback callback2 = this.mRightView;
            if (callback2 != null) {
                ((io.dcloud.common.DHInterface.IWaiter) callback2).doForFeature("clearAnimate", null);
                this.mSwitchLayout.removeView(this.mRightView);
                this.mRightView = null;
            }
            this.mLeftFrameBpView.clearData();
            this.mRightFrameBpView.clearData();
            this.mLeftFrameBpView.requestLayout();
            this.mRightFrameBpView.requestLayout();
        }
    }

    public void initView() {
        if (this.isInit) {
            return;
        }
        this.isInit = true;
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.mActivity.getWindow().getDecorView();
        this.mSwitchLayout = new io.dcloud.common.adapter.ui.FrameSwitchView.SwitchLayout(this.mActivity);
        this.mLeftFrameBpView = new io.dcloud.common.adapter.ui.FrameBitmapView(this.mActivity);
        this.mRightFrameBpView = new io.dcloud.common.adapter.ui.FrameBitmapView(this.mActivity);
        this.mSwitchLayout.addView(this.mLeftFrameBpView);
        this.mSwitchLayout.addView(this.mRightFrameBpView);
        this.mSwitchLayout.setVisibility(8);
        viewGroup.addView(this.mSwitchLayout);
    }

    public boolean isInit() {
        return this.isInit;
    }

    public void startAnimation(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.Object obj, java.lang.String str2, java.lang.Object obj2, java.lang.String str3, java.lang.String str4) {
        try {
            this.mWebViewImpl = iWebview;
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            this.mAniType = jSONObject.optString("type", "pop-in");
            this.mDuration = jSONObject.optInt("duration", this.mDuration);
            initScreenData();
            if (obj != null) {
                if (obj instanceof android.view.View) {
                    android.view.View view = (android.view.View) obj;
                    this.mLeftView = view;
                    addView(view);
                } else {
                    this.mLeftFrameBpView.injectionData(obj, str2, this.mAppScreenWidth, this.mAppScreenHeight, iWebview.getScale());
                }
                if (obj2 != null) {
                    if (obj2 instanceof android.view.View) {
                        this.mRightView = (android.view.View) obj2;
                        addView((android.view.View) obj2);
                    } else {
                        this.mRightFrameBpView.injectionData(obj2, str3, this.mAppScreenWidth, this.mAppScreenHeight, iWebview.getScale());
                    }
                } else if (this.mAniType.equals("pop-in")) {
                    this.mAniType = "slide-in-right";
                } else if (this.mAniType.equals("pop-out")) {
                    this.mAniType = "slide-out-right";
                }
                runingAnimation(iWebview, this.mAppScreenWidth, this.mAppScreenHeight, this.mAniType, str4);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public void stopAnimation() {
        initScreenData();
        io.dcloud.common.adapter.ui.FrameBitmapView frameBitmapView = this.mLeftFrameBpView;
        if (frameBitmapView != null && frameBitmapView.isInit()) {
            this.mLeftFrameBpView.setStopAnimation(true);
            this.mLeftFrameBpView.configurationChanged(this.mAppScreenWidth, this.mAppScreenHeight);
        }
        io.dcloud.common.adapter.ui.FrameBitmapView frameBitmapView2 = this.mRightFrameBpView;
        if (frameBitmapView2 != null && frameBitmapView2.isInit()) {
            this.mRightFrameBpView.setStopAnimation(true);
            this.mRightFrameBpView.configurationChanged(this.mAppScreenWidth, this.mAppScreenHeight);
        }
        if ("pop-in".equals(this.mAniType)) {
            android.view.View view = this.mRightView;
            if (view == null) {
                view = this.mRightFrameBpView;
            }
            endAnimationLayout(view, 0);
            android.view.View view2 = this.mLeftView;
            if (view2 == null) {
                view2 = this.mLeftFrameBpView;
            }
            view2.setVisibility(8);
            return;
        }
        if (!"pop-out".equals(this.mAniType)) {
            endRefreshView();
            return;
        }
        android.view.View view3 = this.mRightView;
        if (view3 == null) {
            view3 = this.mRightFrameBpView;
        }
        view3.setVisibility(8);
        android.view.View view4 = this.mLeftView;
        if (view4 == null) {
            view4 = this.mLeftFrameBpView;
        }
        endAnimationLayout(view4, 0);
    }

    public static io.dcloud.common.adapter.ui.FrameSwitchView getInstance() {
        return mInstance;
    }

    private FrameSwitchView(android.app.Activity activity) {
        this.mActivity = activity;
    }
}
