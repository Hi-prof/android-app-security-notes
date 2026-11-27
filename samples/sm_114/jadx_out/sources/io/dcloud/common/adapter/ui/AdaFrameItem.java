package io.dcloud.common.adapter.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class AdaFrameItem {
    public static int GONE = 8;
    public static int INVISIBLE = 4;
    static final java.lang.String TAG = "AdaFrameItem";
    public static int VISIBLE;
    private android.content.Context mContextWrapper;
    private boolean mAutoPop = false;
    private boolean mAutoPush = false;
    public boolean mNeedOrientationUpdate = false;
    protected boolean mLongPressed = false;
    protected boolean mPressed = false;
    protected io.dcloud.common.adapter.util.ViewOptions mViewOptions = null;
    protected io.dcloud.common.adapter.util.ViewOptions mViewOptions_animate = null;
    protected io.dcloud.common.adapter.util.ViewOptions mViewOptions_birth = null;
    protected android.view.View mViewImpl = null;
    public io.dcloud.nineoldandroids.animation.Animator.AnimatorListener mAnimatorListener = null;
    protected io.dcloud.common.adapter.util.AnimOptions mAnimOptions = null;
    private android.view.animation.Animation mAnimation = null;
    public boolean mStranslate = false;
    public int mZIndex = 0;
    public io.dcloud.common.adapter.ui.AdaContainerFrameItem mParentFrameItem = null;
    public long lastShowTime = 0;
    public int mPosition = io.dcloud.common.adapter.util.ViewRect.POSITION_ABSOLUTE;
    public io.dcloud.common.DHInterface.INativeView mNativeView = null;
    public boolean isSlipping = false;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class DefaultView extends android.view.View {
        public DefaultView(android.content.Context context) {
            super(context);
        }

        @Override // android.view.View
        protected void onConfigurationChanged(android.content.res.Configuration configuration) {
            super.onConfigurationChanged(configuration);
            io.dcloud.common.adapter.ui.AdaFrameItem.this.onResize();
        }

        @Override // android.view.View
        protected void onDraw(android.graphics.Canvas canvas) {
            io.dcloud.common.adapter.ui.AdaFrameItem.this.paint(canvas);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class LayoutParamsUtil {
        public static android.view.ViewGroup.LayoutParams createLayoutParams(int i, int i2, int i3, int i4) {
            return new android.widget.AbsoluteLayout.LayoutParams(i3, i4, i, i2);
        }

        private static void preAndroid30SetViewLayoutParams(final android.view.View view, final int i, final int i2) {
            if (!(i == 0 && i2 == 0) && io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer <= 10) {
                io.dcloud.nineoldandroids.animation.AnimatorSet animatorSet = new io.dcloud.nineoldandroids.animation.AnimatorSet();
                io.dcloud.nineoldandroids.animation.ObjectAnimator objectAnimator = new io.dcloud.nineoldandroids.animation.ObjectAnimator();
                objectAnimator.setPropertyName(com.taobao.weex.common.Constants.Name.X);
                objectAnimator.setFloatValues(i - 1, i);
                animatorSet.playTogether(objectAnimator);
                io.dcloud.nineoldandroids.animation.ObjectAnimator objectAnimator2 = new io.dcloud.nineoldandroids.animation.ObjectAnimator();
                objectAnimator2.setPropertyName(com.taobao.weex.common.Constants.Name.Y);
                objectAnimator2.setFloatValues(i2 - 1, i2);
                animatorSet.playTogether(objectAnimator2);
                animatorSet.setDuration(5L);
                animatorSet.setTarget(view);
                animatorSet.addListener(new io.dcloud.nineoldandroids.animation.Animator.AnimatorListener() { // from class: io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.1
                    @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
                    public void onAnimationCancel(io.dcloud.nineoldandroids.animation.Animator animator) {
                        view.postDelayed(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.AnonymousClass1 anonymousClass1 = io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.AnonymousClass1.this;
                                io.dcloud.nineoldandroids.view.ViewHelper.setX(view, i);
                                io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.AnonymousClass1 anonymousClass2 = io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.AnonymousClass1.this;
                                io.dcloud.nineoldandroids.view.ViewHelper.setY(view, i2);
                            }
                        }, 10L);
                    }

                    @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
                    public void onAnimationEnd(io.dcloud.nineoldandroids.animation.Animator animator) {
                    }

                    @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(io.dcloud.nineoldandroids.animation.Animator animator) {
                    }

                    @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
                    public void onAnimationStart(io.dcloud.nineoldandroids.animation.Animator animator) {
                    }
                });
                animatorSet.start();
            }
        }

        public static void setViewLayoutParams(android.view.View view, int i, int i2, int i3, int i4) {
            if (view.getLayoutParams() instanceof android.widget.AbsoluteLayout.LayoutParams) {
                ((android.widget.AbsoluteLayout.LayoutParams) view.getLayoutParams()).x = 0;
                ((android.widget.AbsoluteLayout.LayoutParams) view.getLayoutParams()).y = 0;
            }
            view.setTop(0);
            view.setLeft(0);
            io.dcloud.nineoldandroids.view.ViewHelper.setX(view, i);
            io.dcloud.nineoldandroids.view.ViewHelper.setY(view, i2);
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new android.view.ViewGroup.LayoutParams(i3, i4);
            } else {
                layoutParams.width = i3;
                layoutParams.height = i4;
            }
            view.setLayoutParams(layoutParams);
        }
    }

    protected AdaFrameItem(android.content.Context context) {
        this.mContextWrapper = null;
        this.mContextWrapper = context;
        setFrameOptions(new io.dcloud.common.adapter.util.ViewOptions());
        this.mViewOptions.mTag = this;
    }

    private void addStatusBar(io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem) {
        boolean z;
        int statusHeight;
        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions = adaFrameItem.obtainFrameOptions();
        if (viewOptionsObtainFrameOptions.isStatusbar && ((z = adaFrameItem instanceof io.dcloud.common.adapter.ui.AdaFrameView)) && -1 != (statusHeight = io.dcloud.common.adapter.util.DeviceInfo.getStatusHeight(adaFrameItem.getContext()))) {
            int iHashCode = adaFrameItem.hashCode();
            int statusBarDefaultColor = z ? ((io.dcloud.common.adapter.ui.AdaFrameView) adaFrameItem).obtainApp().obtainStatusBarMgr().getStatusBarDefaultColor() : 0;
            if (!io.dcloud.common.util.PdrUtil.isEmpty(viewOptionsObtainFrameOptions.mStatusbarColor)) {
                int iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(viewOptionsObtainFrameOptions.mStatusbarColor);
                if (io.dcloud.common.util.PdrUtil.checkStatusbarColor(iStringToColor)) {
                    statusBarDefaultColor = iStringToColor;
                }
            }
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) adaFrameItem.obtainMainView();
            if (viewGroup.findViewById(iHashCode) == null && viewOptionsObtainFrameOptions.titleNView == null) {
                com.dcloud.android.widget.StatusBarView statusBarView = new com.dcloud.android.widget.StatusBarView(adaFrameItem.getContext());
                if (adaFrameItem.obtainFrameOptions() != null && adaFrameItem.obtainFrameOptions().titleNView != null && "transparent".equals(adaFrameItem.obtainFrameOptions().titleNView.optString("type"))) {
                    statusBarDefaultColor = android.graphics.Color.argb(0, android.graphics.Color.red(statusBarDefaultColor), android.graphics.Color.green(statusBarDefaultColor), android.graphics.Color.blue(statusBarDefaultColor));
                }
                statusBarView.setStatusBarHeight(statusHeight);
                statusBarView.setBackgroundColor(statusBarDefaultColor);
                statusBarView.setId(iHashCode);
                viewGroup.addView(statusBarView);
            }
        }
    }

    public final void clearAnimInfo() {
        if (this.isSlipping) {
            return;
        }
        this.mAnimation = null;
        this.mAnimatorListener = null;
        android.view.View view = this.mViewImpl;
        if (view != null) {
            view.clearAnimation();
        }
    }

    public void dispose() {
        onDispose();
        clearAnimInfo();
        android.view.View view = this.mViewImpl;
        if (view != null) {
            view.setVisibility(GONE);
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.mViewImpl.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.mViewImpl);
            }
            this.mViewImpl = null;
        }
    }

    public io.dcloud.common.adapter.ui.AdaFrameItem findLastFrameItem(io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem) {
        return null;
    }

    public android.app.Activity getActivity() {
        return (android.app.Activity) this.mContextWrapper;
    }

    public io.dcloud.common.adapter.util.AnimOptions getAnimOptions() {
        if (this.mAnimOptions == null) {
            this.mAnimOptions = new io.dcloud.common.adapter.util.AnimOptions();
        }
        return this.mAnimOptions;
    }

    public android.content.Context getContext() {
        return this.mContextWrapper;
    }

    public io.dcloud.common.adapter.ui.AdaFrameItem getParent() {
        return null;
    }

    public io.dcloud.common.adapter.ui.AdaContainerFrameItem getParentFrameItem() {
        return this.mParentFrameItem;
    }

    public boolean isAutoPop() {
        return this.mAutoPop;
    }

    public boolean isAutoPush() {
        return this.mAutoPush;
    }

    public boolean isDisposed() {
        return this.mViewImpl == null;
    }

    public void makeViewOptions_animate() {
        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions = obtainFrameOptions();
        io.dcloud.common.adapter.util.ViewOptions viewOptionsCreateViewOptionsData = this.mViewOptions_animate;
        if (viewOptionsCreateViewOptionsData == null) {
            io.dcloud.common.adapter.util.ViewOptions viewOptions = this.mViewOptions;
            viewOptionsCreateViewOptionsData = io.dcloud.common.adapter.util.ViewOptions.createViewOptionsData(viewOptions, viewOptions.getParentViewRect());
            this.mViewOptions_animate = viewOptionsCreateViewOptionsData;
        }
        if (viewOptionsCreateViewOptionsData.hasBackground()) {
            viewOptionsCreateViewOptionsData.anim_top = 0;
            viewOptionsCreateViewOptionsData.anim_left = 0;
            viewOptionsObtainFrameOptions.anim_top = 0;
            viewOptionsObtainFrameOptions.anim_left = 0;
        }
        io.dcloud.common.adapter.util.AnimOptions animOptions = this.mAnimOptions;
        byte b = animOptions.mOption;
        if (b != 0 && b != 4) {
            if (b == 1 || 3 == b) {
                java.lang.String str = animOptions.mAnimType_close;
                java.util.HashMap<java.lang.String, java.lang.String> map = io.dcloud.common.adapter.util.AnimOptions.mAnimTypes;
                if (!map.containsValue(str)) {
                    str = map.get(this.mAnimOptions.mAnimType);
                }
                if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.adapter.util.AnimOptions.ANIM_SLIDE_OUT_RIGHT) || io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.adapter.util.AnimOptions.ANIM_POP_OUT)) {
                    viewOptionsCreateViewOptionsData.anim_left = this.mAnimOptions.sScreenWidth;
                    return;
                }
                if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.adapter.util.AnimOptions.ANIM_SLIDE_OUT_LEFT)) {
                    viewOptionsCreateViewOptionsData.anim_left = -(viewOptionsCreateViewOptionsData.hasBackground() ? this.mAnimOptions.sScreenWidth : viewOptionsCreateViewOptionsData.width);
                    return;
                } else if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.adapter.util.AnimOptions.ANIM_SLIDE_OUT_TOP)) {
                    viewOptionsCreateViewOptionsData.anim_top = -(viewOptionsCreateViewOptionsData.hasBackground() ? this.mAnimOptions.sScreenHeight : viewOptionsCreateViewOptionsData.height);
                    return;
                } else {
                    if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.adapter.util.AnimOptions.ANIM_SLIDE_OUT_BOTTOM)) {
                        viewOptionsCreateViewOptionsData.anim_top = this.mAnimOptions.sScreenHeight;
                        return;
                    }
                    return;
                }
            }
            return;
        }
        java.lang.String str2 = animOptions.mAnimType;
        if (io.dcloud.common.util.PdrUtil.isEmpty(str2)) {
            str2 = "none";
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str2, io.dcloud.common.adapter.util.AnimOptions.ANIM_SLIDE_IN_RIGHT) || io.dcloud.common.util.PdrUtil.isEquals(str2, io.dcloud.common.adapter.util.AnimOptions.ANIM_POP_IN)) {
            viewOptionsObtainFrameOptions.anim_left = this.mAnimOptions.sScreenWidth;
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str2, io.dcloud.common.adapter.util.AnimOptions.ANIM_SLIDE_IN_LEFT)) {
            int i = viewOptionsObtainFrameOptions.width;
            if (i == -1) {
                i = this.mAnimOptions.sScreenWidth;
            }
            viewOptionsObtainFrameOptions.anim_left = -i;
            return;
        }
        if (!io.dcloud.common.util.PdrUtil.isEquals(str2, io.dcloud.common.adapter.util.AnimOptions.ANIM_SLIDE_IN_TOP)) {
            if (io.dcloud.common.util.PdrUtil.isEquals(str2, io.dcloud.common.adapter.util.AnimOptions.ANIM_SLIDE_IN_BOTTOM)) {
                viewOptionsObtainFrameOptions.anim_top = this.mAnimOptions.sScreenHeight;
            }
        } else {
            int i2 = viewOptionsObtainFrameOptions.height;
            if (i2 == -1) {
                i2 = this.mAnimOptions.sScreenHeight;
            }
            viewOptionsObtainFrameOptions.anim_top = -i2;
        }
    }

    public io.dcloud.common.adapter.util.ViewOptions obtainFrameOptions() {
        return this.mViewOptions;
    }

    public io.dcloud.common.adapter.util.ViewOptions obtainFrameOptions_Animate() {
        return this.mViewOptions_animate;
    }

    public io.dcloud.common.adapter.util.ViewOptions obtainFrameOptions_Birth() {
        return this.mViewOptions_birth;
    }

    public android.view.View obtainMainView() {
        return this.mViewImpl;
    }

    public boolean onDispose() {
        return true;
    }

    public void onPopFromStack(boolean z) {
        this.mAutoPop = z;
    }

    public void onPushToStack(boolean z) {
        this.mAutoPush = z;
    }

    protected void onResize() {
        if (!this.mNeedOrientationUpdate || isDisposed()) {
            return;
        }
        addStatusBar(this);
        io.dcloud.common.adapter.util.ViewOptions viewOptions = this.mViewOptions;
        boolean z = this instanceof io.dcloud.common.adapter.ui.AdaFrameView;
        boolean z2 = z && ((io.dcloud.common.adapter.ui.AdaFrameView) this).isChildOfFrameView;
        viewOptions.onScreenChanged();
        android.view.View viewObtainMainView = obtainMainView();
        android.view.ViewGroup.LayoutParams layoutParams = viewObtainMainView.getLayoutParams();
        if (z && !z2) {
            if (layoutParams == null || !z) {
                return;
            }
            layoutParams.height = layoutParams.height == -1 ? -1 : viewOptions.height;
            if (viewOptions.isStatusbarDodifyHeight && (viewObtainMainView instanceof com.dcloud.android.widget.AbsoluteLayout)) {
                layoutParams.height = viewOptions.height + io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
            }
            layoutParams.width = layoutParams.width != -1 ? viewOptions.width : -1;
            if (!viewOptions.hasBackground()) {
                io.dcloud.nineoldandroids.view.ViewHelper.setX(viewObtainMainView, viewOptions.left);
                io.dcloud.nineoldandroids.view.ViewHelper.setY(viewObtainMainView, viewOptions.top);
            }
            ((io.dcloud.common.adapter.ui.AdaFrameView) this).changeWebParentViewRect();
            viewObtainMainView.requestLayout();
            viewObtainMainView.postInvalidate();
            return;
        }
        if (z) {
            int i = viewOptions.height;
            if (i > 0 || i == -1) {
                layoutParams.height = i;
            }
            int i2 = viewOptions.width;
            if (i2 > 0 || i2 == -1) {
                layoutParams.width = i2;
            }
            viewObtainMainView.setLayoutParams(layoutParams);
        }
        if (z2 && z) {
            int iConvertToScreenInt = viewOptions.top;
            int i3 = viewOptions.left;
            int height = layoutParams.height;
            int width = layoutParams.width;
            io.dcloud.common.adapter.ui.AdaContainerFrameItem parentFrameItem = getParentFrameItem();
            if (parentFrameItem != null) {
                if (this.mPosition == io.dcloud.common.adapter.util.ViewRect.DOCK_TOP && parentFrameItem.obtainFrameOptions().titleNView != null && io.dcloud.common.util.TitleNViewUtil.isTitleTypeForDef(parentFrameItem.obtainFrameOptions().titleNView)) {
                    iConvertToScreenInt += io.dcloud.common.util.PdrUtil.convertToScreenInt("44px", 0, 0, ((io.dcloud.common.adapter.ui.AdaFrameView) this).obtainWebView().getScale());
                }
                if (!viewOptions.isStatusbar && parentFrameItem.obtainFrameOptions().isStatusbar) {
                    iConvertToScreenInt += io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
                    if (viewOptions.isBottomAbsolute()) {
                        height -= io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
                    }
                }
            }
            if (viewOptions.isStatusbar && !viewOptions.isBottomAbsolute()) {
                height += io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
            }
            if (width <= 0 && width != -1) {
                width = viewObtainMainView.getWidth();
            }
            if (height <= 0 && height != -1) {
                height = viewObtainMainView.getHeight();
            }
            io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.setViewLayoutParams(obtainMainView(), i3, iConvertToScreenInt, width, height);
        }
        if (z) {
            ((io.dcloud.common.adapter.ui.AdaFrameView) this).changeWebParentViewRect();
        }
    }

    protected void paint(android.graphics.Canvas canvas) {
    }

    public void resize() {
        onResize();
    }

    public void scrollBy(int i, int i2) {
        this.mViewImpl.scrollBy(i, i2);
    }

    public void scrollTo(int i, int i2) {
        this.mViewImpl.scrollTo(i, i2);
    }

    public void setAnimOptions(io.dcloud.common.adapter.util.AnimOptions animOptions) {
        this.mAnimOptions = animOptions;
    }

    public void setAnimatorLinstener(io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener) {
        this.mAnimatorListener = animatorListener;
    }

    public void setBgcolor(int i) {
        this.mViewImpl.setBackgroundColor(i);
    }

    public void setFrameOptions(io.dcloud.common.adapter.util.ViewOptions viewOptions) {
        this.mViewOptions = viewOptions;
    }

    public void setFrameOptions_Animate(io.dcloud.common.adapter.util.ViewOptions viewOptions) {
        this.mViewOptions_animate = viewOptions;
    }

    public void setFrameOptions_Birth(io.dcloud.common.adapter.util.ViewOptions viewOptions) {
        this.mViewOptions_birth = viewOptions;
    }

    public void setMainView(android.view.View view) {
        this.mViewImpl = view;
    }

    public void setParentFrameItem(io.dcloud.common.adapter.ui.AdaContainerFrameItem adaContainerFrameItem) {
        this.mParentFrameItem = adaContainerFrameItem;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setSlipping(boolean z) {
        this.isSlipping = z;
    }

    public void setVisibility(int i) {
        android.view.View view = this.mViewImpl;
        if (view == null || view.getVisibility() == i) {
            return;
        }
        this.mViewImpl.setVisibility(i);
    }

    public void startAnimator(int i) {
    }

    public void updateViewRect(io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem, int[] iArr, int[] iArr2) {
        updateViewRect(adaFrameItem, iArr, iArr2, new boolean[]{true, true, true, true}, new boolean[]{true, true, true, false});
    }

    protected void useDefaultMainView() {
        setMainView(new io.dcloud.common.adapter.ui.AdaFrameItem.DefaultView(this.mContextWrapper));
    }

    public void updateViewRect(io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem, int[] iArr, int[] iArr2, boolean[] zArr, boolean[] zArr2) {
        io.dcloud.common.adapter.util.ViewOptions viewOptions = this.mViewOptions;
        int i = iArr[0];
        viewOptions.left = i;
        viewOptions.checkValueIsPercentage("left", i, iArr2[0], zArr[0], zArr2[0]);
        io.dcloud.common.adapter.util.ViewOptions viewOptions2 = this.mViewOptions;
        int i2 = iArr[1];
        viewOptions2.top = i2;
        viewOptions2.checkValueIsPercentage("top", i2, iArr2[1], zArr[1], zArr2[1]);
        io.dcloud.common.adapter.util.ViewOptions viewOptions3 = this.mViewOptions;
        int i3 = iArr[2];
        viewOptions3.width = i3;
        viewOptions3.checkValueIsPercentage("width", i3, iArr2[0], zArr[2], zArr2[2]);
        io.dcloud.common.adapter.util.ViewOptions viewOptions4 = this.mViewOptions;
        int i4 = iArr[3];
        viewOptions4.height = i4;
        viewOptions4.checkValueIsPercentage("height", i4, iArr2[1], zArr[3], zArr2[3]);
        this.mViewOptions.setParentViewRect(adaFrameItem.mViewOptions);
    }
}
