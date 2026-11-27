package io.dcloud.common.core.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class b extends io.dcloud.common.adapter.ui.AdaFrameView {
    public static int A = 2;
    public static int B = 3;
    public static int x = 0;
    public static int y = 0;
    public static int z = 1;
    boolean a;
    java.util.ArrayList b;
    java.util.ArrayList c;
    boolean d;
    private boolean e;
    private boolean f;
    boolean g;
    boolean h;
    boolean i;
    io.dcloud.common.DHInterface.IApp j;
    io.dcloud.common.core.ui.a k;
    io.dcloud.common.adapter.ui.AdaWebview l;
    io.dcloud.common.adapter.ui.AdaWebViewParent m;
    byte n;
    private boolean o;
    io.dcloud.common.adapter.util.ViewOptions p;
    private java.lang.Boolean q;
    private int r;
    boolean s;
    io.dcloud.nineoldandroids.animation.Animator.AnimatorListener t;
    boolean u;
    boolean v;
    private boolean w;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements io.dcloud.nineoldandroids.animation.Animator.AnimatorListener {

        /* JADX INFO: renamed from: io.dcloud.common.core.ui.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class RunnableC0036a implements java.lang.Runnable {
            RunnableC0036a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.common.core.ui.b.a aVar = io.dcloud.common.core.ui.b.a.this;
                if (io.dcloud.common.core.ui.b.this.mWindowMgr != null) {
                    aVar.a();
                }
            }
        }

        a() {
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(io.dcloud.nineoldandroids.animation.Animator animator) {
            io.dcloud.common.util.BaseInfo.sDoingAnimation = false;
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(io.dcloud.nineoldandroids.animation.Animator animator) {
            io.dcloud.common.adapter.util.Logger.e("DHFrameView", "---------------------onAnimationEnd");
            io.dcloud.common.adapter.util.AnimOptions animOptions = io.dcloud.common.core.ui.b.this.getAnimOptions();
            io.dcloud.common.core.ui.b.this.q = java.lang.Boolean.FALSE;
            byte b = animOptions.mOption;
            if (b == 1) {
                io.dcloud.common.core.ui.b.this.setVisibility(io.dcloud.common.adapter.ui.AdaFrameItem.GONE);
            } else if (b == 3) {
                io.dcloud.common.core.ui.b.this.l();
            }
            io.dcloud.common.util.BaseInfo.sDoingAnimation = false;
            if (io.dcloud.common.core.ui.b.this.obtainMainView() == null) {
                return;
            }
            io.dcloud.common.core.ui.b.this.obtainMainView().post(new io.dcloud.common.core.ui.b.a.RunnableC0036a());
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationRepeat(io.dcloud.nineoldandroids.animation.Animator animator) {
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationStart(io.dcloud.nineoldandroids.animation.Animator animator) {
            io.dcloud.common.adapter.util.Logger.e("DHFrameView", "---------------------onAnimationStart");
            io.dcloud.common.util.BaseInfo.sDoingAnimation = true;
            ((io.dcloud.common.adapter.ui.AdaFrameView) io.dcloud.common.core.ui.b.this).mAnimationStarted = true;
            if (io.dcloud.common.core.ui.b.this.getAnimOptions().mOption == 2) {
                io.dcloud.common.core.ui.b.a(io.dcloud.common.core.ui.b.this.obtainMainView(), ((io.dcloud.common.adapter.ui.AdaFrameItem) io.dcloud.common.core.ui.b.this).mViewOptions.left, ((io.dcloud.common.adapter.ui.AdaFrameItem) io.dcloud.common.core.ui.b.this).mViewOptions.top, "onAnimationStart");
            } else if (io.dcloud.common.util.BaseInfo.isUniAppAppid(io.dcloud.common.core.ui.b.this.obtainApp())) {
                io.dcloud.common.core.ui.b.this.obtainWebView().setIWebViewFocusable(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            io.dcloud.common.core.ui.b bVar = io.dcloud.common.core.ui.b.this;
            if (bVar.mWindowMgr == null) {
                return;
            }
            byte b = bVar.getAnimOptions().mOption;
            if (b == 0) {
                android.view.View view = io.dcloud.common.core.ui.i.a;
                if (view != null) {
                    view.clearAnimation();
                }
                io.dcloud.common.core.ui.b.this.n();
            } else if (b == 1) {
                io.dcloud.common.core.ui.b.this.i();
            } else if (b == 2) {
                io.dcloud.common.core.ui.b.this.o();
            } else if (b == 3) {
                io.dcloud.common.core.ui.b.this.k();
            } else if (b == 4) {
                android.view.View view2 = io.dcloud.common.core.ui.i.a;
                if (view2 != null) {
                    view2.clearAnimation();
                }
                io.dcloud.common.core.ui.b.this.m();
            }
            io.dcloud.common.core.ui.b.this.mWindowMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 70, null);
        }
    }

    b(android.content.Context context, io.dcloud.common.core.ui.l lVar, io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.core.ui.a aVar, int i, java.lang.Object obj) {
        super(context, i, obj);
        this.a = false;
        this.d = false;
        this.e = true;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = (byte) 2;
        this.o = true;
        this.p = null;
        this.q = java.lang.Boolean.FALSE;
        this.r = y;
        this.s = false;
        this.t = new io.dcloud.common.core.ui.b.a();
        this.u = false;
        this.v = true;
        this.w = false;
        this.lastShowTime = java.lang.System.currentTimeMillis();
        x++;
        io.dcloud.common.adapter.util.Logger.i("dhframeview", "construction Count=" + x);
        this.mWindowMgr = lVar;
        this.j = iApp;
        this.k = aVar;
        aVar.c().add(this);
        this.e = iApp.isVerticalScreen();
        this.f = iApp.isFullScreen();
    }

    public int c() {
        return this.r;
    }

    boolean d() {
        java.util.ArrayList arrayList = this.c;
        return arrayList != null && arrayList.size() > 0;
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameView, io.dcloud.common.adapter.ui.AdaContainerFrameItem, io.dcloud.common.adapter.ui.AdaFrameItem
    public void dispose() {
        io.dcloud.common.adapter.util.Logger.e("DHFrameView", "dispose");
        super.dispose();
        if (this.k != null) {
            int frameType = getFrameType();
            if (frameType == 2) {
                this.k.f = null;
            } else if (frameType == 4) {
                this.k.g = null;
            } else if (frameType == 5) {
                this.k.e = null;
            }
            this.k.d().remove(this);
            r();
        }
        this.mWindowMgr = null;
        this.j = null;
        this.mParentFrameItem = null;
        this.k = null;
        this.l = null;
        this.t = null;
    }

    boolean e() {
        java.util.ArrayList arrayList = this.b;
        return arrayList != null && arrayList.size() > 0;
    }

    public boolean f() {
        return this.w;
    }

    boolean g() {
        io.dcloud.common.adapter.util.AnimOptions animOptions = getAnimOptions();
        return (animOptions == null || animOptions.mOption == 1) ? false : true;
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameItem
    public io.dcloud.common.adapter.ui.AdaFrameItem getParent() {
        return this.k;
    }

    void h() {
        if (this.e == this.j.isVerticalScreen() && this.f == this.j.isFullScreen()) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("onPushToStack frame ");
        sb.append(this.e ? "调整为横屏状态" : "调整为竖屏状态");
        sb.append(this);
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, sb.toString());
        resize();
        this.e = this.j.isVerticalScreen();
        this.f = this.j.isFullScreen();
    }

    void i() {
        setVisibility(io.dcloud.common.adapter.ui.AdaFrameItem.GONE);
        if (io.dcloud.common.util.BaseInfo.isUniAppAppid(obtainApp())) {
            obtainWebView().setIWebViewFocusable(false);
        }
        j();
        q();
        a();
        clearAnimInfo();
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, "onCloseAnimationEnd;" + this);
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameView
    protected void initMainView(android.content.Context context, int i, java.lang.Object obj) {
        if (i != 1) {
            setMainView(new com.dcloud.android.widget.AbsoluteLayout(context, this, this.j));
        }
    }

    public void j() {
        b(true);
    }

    void k() {
        if (io.dcloud.common.util.BaseInfo.isUniAppAppid(obtainApp())) {
            obtainWebView().setIWebViewFocusable(false);
        }
        dispatchFrameViewEvents("hide", null);
        if (!this.mViewOptions.hasBackground() && !this.isChildOfFrameView && obtainMainView() != null) {
            io.dcloud.nineoldandroids.view.ViewHelper.setX(obtainMainView(), this.mViewOptions.left);
            io.dcloud.nineoldandroids.view.ViewHelper.setY(obtainMainView(), this.mViewOptions.top);
            io.dcloud.nineoldandroids.view.ViewHelper.setScaleX(obtainMainView(), 1.0f);
            io.dcloud.nineoldandroids.view.ViewHelper.setScaleY(obtainMainView(), 1.0f);
            if (!this.mViewOptions.hasTransparentValue()) {
                io.dcloud.nineoldandroids.view.ViewHelper.setAlpha(obtainMainView(), 1.0f);
            }
        }
        io.dcloud.common.adapter.util.ViewOptions viewOptions = this.mViewOptions_animate;
        if (viewOptions != null) {
            updateFrameRelViewRect(viewOptions);
            this.mViewOptions_animate = null;
        }
        j();
        this.h = false;
        a();
        clearAnimInfo();
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, "onHideAnimationEnd;" + toString());
    }

    void l() {
        setVisible(false, true);
    }

    void m() {
        if (io.dcloud.common.util.BaseInfo.isUniAppAppid(obtainApp())) {
            obtainWebView().setIWebViewFocusable(true);
        }
        if (io.dcloud.common.util.BaseInfo.isUniAppAppid(obtainApp()) && !obtainWebView().isUniWebView()) {
            obtainWebView().obtainWindowView().requestFocus();
        }
        dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_SHOW_ANIMATION_END, null);
        io.dcloud.common.adapter.util.ViewOptions viewOptions = this.mViewOptions_animate;
        if (viewOptions != null) {
            updateFrameRelViewRect(viewOptions);
            this.mViewOptions_animate = null;
        }
        android.view.View viewObtainMainView = obtainMainView();
        io.dcloud.common.adapter.util.ViewOptions viewOptions2 = this.mViewOptions;
        a(viewObtainMainView, viewOptions2.left, viewOptions2.top, "onHideShowAnimationEnd");
        j();
        this.inStack = true;
        a();
        clearAnimInfo();
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, "onHideShowAnimationEnd;" + toString());
    }

    void n() {
        if (io.dcloud.common.util.BaseInfo.isUniAppAppid(obtainApp())) {
            obtainWebView().setIWebViewFocusable(true);
        }
        if (io.dcloud.common.util.BaseInfo.isUniAppAppid(obtainApp()) && !obtainWebView().isUniWebView()) {
            obtainWebView().obtainWindowView().requestFocus();
        }
        dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_SHOW_ANIMATION_END, null);
        io.dcloud.common.adapter.util.ViewOptions viewOptions = this.mViewOptions_animate;
        if (viewOptions != null) {
            updateFrameRelViewRect(viewOptions);
            this.mViewOptions_animate = null;
        }
        j();
        this.inStack = true;
        a();
        clearAnimInfo();
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, "onShowAnimationEnd;" + this);
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() || io.dcloud.common.util.BaseInfo.isUniAppAppid(this.j)) {
            return;
        }
        io.dcloud.p.b.o().a(this.j.getActivity());
    }

    void o() {
        io.dcloud.common.adapter.ui.AdaWebViewParent adaWebViewParentObtainWebviewParent = obtainFrameOptions().hasBackground() ? obtainWebviewParent() : this;
        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions_Animate = adaWebViewParentObtainWebviewParent.obtainFrameOptions_Animate();
        if (viewOptionsObtainFrameOptions_Animate != null) {
            updateFrameRelViewRect(viewOptionsObtainFrameOptions_Animate);
            adaWebViewParentObtainWebviewParent.setFrameOptions_Animate(null);
        }
        android.view.View viewObtainMainView = obtainMainView();
        io.dcloud.common.adapter.util.ViewOptions viewOptions = this.mViewOptions;
        a(viewObtainMainView, viewOptions.left, viewOptions.top, "onStyleChangedAnimationEnd");
        j();
        a();
        clearAnimInfo();
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, "onStyleChangedAnimationEnd;" + adaWebViewParentObtainWebviewParent.toString());
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameView, io.dcloud.common.DHInterface.IFrameView
    public io.dcloud.common.DHInterface.IApp obtainApp() {
        return this.j;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // io.dcloud.common.adapter.ui.AdaFrameView
    public java.lang.String obtainPrePlusreadyJs() {
        io.dcloud.common.core.ui.l lVar = this.mWindowMgr;
        return lVar != null ? (java.lang.String) lVar.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 2, new java.lang.Object[]{this.j, this}) : "";
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public io.dcloud.common.DHInterface.IWebAppRootView obtainWebAppRootView() {
        return this.k;
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameView, io.dcloud.common.DHInterface.IFrameView
    public io.dcloud.common.DHInterface.IWebview obtainWebView() {
        return this.l;
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public io.dcloud.common.adapter.ui.AdaWebViewParent obtainWebviewParent() {
        return this.m;
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameView, io.dcloud.common.DHInterface.IFrameView
    public io.dcloud.common.DHInterface.AbsMgr obtainWindowMgr() {
        return this.mWindowMgr;
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameView
    public void onConfigurationChanged() {
        super.onConfigurationChanged();
        resize();
        this.e = this.j.isVerticalScreen();
        this.f = this.j.isFullScreen();
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.Android_System_TAG, "onConfigurationChanged", this);
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameView, io.dcloud.common.DHInterface.IFrameViewStatus
    public void onDestroy() {
        super.onDestroy();
        x--;
        io.dcloud.common.adapter.util.Logger.i("dhframeview", "onDestroy Count=" + x);
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameView, io.dcloud.common.adapter.ui.AdaContainerFrameItem, io.dcloud.common.adapter.ui.AdaFrameItem
    public boolean onDispose() {
        if (getParentFrameItem() != null && (getParentFrameItem() instanceof io.dcloud.common.core.ui.c)) {
            ((io.dcloud.common.core.ui.c) getParentFrameItem()).removeFrameView(this);
        }
        return super.onDispose();
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameView, io.dcloud.common.DHInterface.IFrameViewStatus
    public void onInit() {
        super.onInit();
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameView, io.dcloud.common.DHInterface.IFrameViewStatus
    public void onLoading() {
        super.onLoading();
    }

    @Override // io.dcloud.common.adapter.ui.AdaContainerFrameItem, io.dcloud.common.adapter.ui.AdaFrameItem
    public void onPopFromStack(boolean z2) {
        super.onPopFromStack(z2);
        io.dcloud.common.DHInterface.IApp iApp = this.j;
        if (iApp == null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("已经提前出栈了 ");
            sb.append(this.e ? "竖屏出栈" : "横屏出栈");
            sb.append(this);
            io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, sb.toString());
            return;
        }
        this.e = iApp.isVerticalScreen();
        this.f = this.j.isFullScreen();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("onPopFromStack ");
        sb2.append(this.e ? "竖屏出栈" : "横屏出栈");
        sb2.append(this);
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, sb2.toString());
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameView, io.dcloud.common.DHInterface.IFrameViewStatus
    public void onPreLoading() {
        super.onPreLoading();
        if (this.n == 0) {
            t();
        }
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameView, io.dcloud.common.DHInterface.IFrameViewStatus
    public void onPreShow(io.dcloud.common.DHInterface.IFrameView iFrameView) {
        super.onPreShow(iFrameView);
    }

    public void p() {
        this.u = true;
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, "onWillDoAnimation " + this);
        io.dcloud.common.core.ui.a aVar = this.k;
        if (aVar != null) {
            aVar.n.a(this);
        }
        if (this.d) {
            io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions_Animate = obtainFrameOptions_Animate();
            io.dcloud.common.adapter.util.ViewOptions viewOptions = this.mViewOptions;
            viewOptions.opacity = viewOptionsObtainFrameOptions_Animate.opacity;
            viewOptions.background = viewOptionsObtainFrameOptions_Animate.background;
            viewOptions.strBackground = viewOptionsObtainFrameOptions_Animate.strBackground;
            b(viewOptions, this, obtainWebviewParent(), (io.dcloud.common.adapter.ui.AdaFrameItem) obtainWebView());
        }
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public void popFromViewStack() {
        if (this.isChildOfFrameView || !this.inStack) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(this);
        this.mWindowMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 27, arrayList);
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public void pushToViewStack() {
        if (this.isChildOfFrameView || this.inStack) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(this);
        this.mWindowMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 28, arrayList);
    }

    void q() {
        io.dcloud.common.core.ui.a aVar = this.k;
        if (aVar != null) {
            aVar.g(this);
        }
    }

    public void r() {
        io.dcloud.common.core.ui.a aVar = this.k;
        if (aVar != null) {
            aVar.c().remove(this);
        }
    }

    void s() {
        setAnimatorLinstener(this.t);
    }

    @Override // io.dcloud.common.DHInterface.IFrameView
    public void setNeedRender(boolean z2) {
        this.a = z2;
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameView, io.dcloud.common.DHInterface.IFrameView
    public void setVisible(boolean z2, boolean z3) {
        super.setVisible(z2, z3);
        if (z2 && (getParentFrameItem() instanceof io.dcloud.common.core.ui.c)) {
            ((io.dcloud.common.core.ui.c) getParentFrameItem()).d(this);
        }
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameView, io.dcloud.common.adapter.ui.AdaFrameItem
    public void startAnimator(int i) {
        chkUseCaptureAnimation(false, hashCode(), this.mSnapshot != null);
        super.startAnimator(i);
    }

    void t() {
        s();
    }

    public java.lang.String toString() {
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.l;
        return adaWebview != null ? adaWebview.toString() : super.toString();
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameView, io.dcloud.common.DHInterface.IFrameView
    public void transition(byte b) {
        if (this.n == b && b == 2) {
            t();
        }
    }

    void b(io.dcloud.common.adapter.util.ViewOptions viewOptions, io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem, io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem2, io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem3) {
        if (io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer >= 11 && viewOptions.opacity != -1.0f) {
            adaFrameItem.obtainMainView().setAlpha(viewOptions.opacity);
        }
        if (viewOptions.webviewBGTransparent) {
            adaFrameItem3.setBgcolor(0);
        }
        if (viewOptions.isTabItem.booleanValue() && !io.dcloud.common.util.PdrUtil.isEmpty(viewOptions.strTabBG)) {
            adaFrameItem.setBgcolor(io.dcloud.common.util.PdrUtil.stringToColor(viewOptions.strTabBG));
            return;
        }
        if (viewOptions.hasBackground()) {
            adaFrameItem.setBgcolor(viewOptions.background);
        } else if (viewOptions.isTransparent()) {
            adaFrameItem2.setBgcolor(0);
            adaFrameItem3.setBgcolor(0);
            adaFrameItem.setBgcolor(0);
        }
    }

    public void c(boolean z2) {
        this.k.k();
        if (!this.isChildOfFrameView) {
            this.k.b(this);
            onPushToStack(isAutoPop());
            io.dcloud.common.core.ui.a aVar = this.k;
            if (aVar != null) {
                if (aVar.d().contains(this)) {
                    aVar.l();
                } else {
                    aVar.e(this);
                }
            }
        } else if (getParentFrameItem() != null) {
            this.k.h(this);
        }
        a(z2);
    }

    public void d(boolean z2) {
        this.w = z2;
    }

    public void a(int i) {
        this.r = i;
    }

    public void a(boolean z2) {
        boolean z3 = true;
        boolean z4 = obtainMainView().getVisibility() == 0;
        setVisible(true, false);
        p();
        this.q = java.lang.Boolean.TRUE;
        this.s = false;
        int i = obtainApp().getInt(0);
        int i2 = obtainApp().getInt(1);
        if ((i != obtainFrameOptions().width || obtainFrameOptions().height + 1 < i2) && (obtainFrameOptions().width != -1 || obtainFrameOptions().height != -1)) {
            z3 = false;
        }
        if ((z2 || io.dcloud.common.util.BaseInfo.isDefaultAim) && !this.isChildOfFrameView && !z4) {
            if (z3 && io.dcloud.common.util.PdrUtil.isEquals(getAnimOptions().mAnimType, io.dcloud.common.adapter.util.AnimOptions.ANIM_POP_IN)) {
                io.dcloud.common.core.ui.i.a(this, 0);
            }
            if (z2) {
                s();
                startAnimator(0);
            } else {
                n();
            }
        } else if (z2 && io.dcloud.common.util.PdrUtil.isEquals(getAnimOptions().mAnimType, io.dcloud.common.adapter.util.AnimOptions.ANIM_FADE_IN)) {
            s();
            startAnimator(0);
        } else {
            n();
        }
        this.k.i(this);
    }

    public void b(boolean z2) {
        this.u = false;
        this.mAnimationStarted = true;
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, "onDoneAnimation " + this);
        io.dcloud.common.core.ui.a aVar = this.k;
        if (aVar != null) {
            this.b = null;
            if (aVar.n.a() >= 1) {
                if (this.v) {
                    this.k.b(this);
                }
                this.v = true;
                if (!this.isChildOfFrameView) {
                    if (e()) {
                        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, "on_Done_Animation 动画完后存在窗口入栈；" + this);
                        io.dcloud.common.core.ui.l lVar = this.mWindowMgr;
                        if (lVar != null) {
                            lVar.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 28, this.b);
                        }
                    }
                    if (d()) {
                        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, "on_Done_Animation 动画完后存在窗口出栈；" + this);
                        a(this.c);
                    } else {
                        io.dcloud.common.DHInterface.ICallBack iCallBack = this.k.a;
                        if (iCallBack != null) {
                            iCallBack.onCallBack(-1, null);
                        }
                    }
                }
            }
            this.k.n.b(this);
            this.c = null;
            if (z2) {
                this.k.i();
            }
        }
        if (obtainApp() == null || !obtainApp().needRefreshApp()) {
            return;
        }
        obtainApp().obtainMgrData(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 1, new java.lang.Object[]{obtainWebView(), "UI", "updateAppFrameViews", null});
    }

    /* JADX WARN: Multi-variable type inference failed */
    void a(io.dcloud.common.adapter.util.ViewOptions viewOptions, io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem, io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem2, io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem3) {
        this.p = viewOptions;
        ((io.dcloud.common.DHInterface.IWebview) adaFrameItem3).setScrollIndicator(viewOptions.getScrollIndicator());
        b(viewOptions, adaFrameItem, adaFrameItem2, adaFrameItem3);
    }

    static void a(android.view.View view, int i, int i2, java.lang.String str) {
        if (io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer <= 10) {
            view.layout(i, i2, view.getRight() + i, view.getBottom() + i2);
        }
    }

    private void a() {
        this.b = null;
        this.c = null;
        this.d = false;
    }

    private void a(java.util.ArrayList arrayList) {
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, "removeFrameViewFromViewStack DoAnimation Frame=" + this + ";Will PopFrames=" + arrayList);
        this.mWindowMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 27, arrayList);
        io.dcloud.common.DHInterface.ICallBack iCallBack = this.k.a;
        if (iCallBack != null) {
            iCallBack.onCallBack(-1, null);
        }
    }

    public void a(int i, int i2) {
        android.view.ViewGroup.LayoutParams layoutParams = obtainMainView().getLayoutParams();
        if (layoutParams == null) {
            obtainMainView().setLayoutParams(new android.view.ViewGroup.LayoutParams(i, i2));
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
    }

    protected void b() {
        android.view.View viewA;
        try {
            viewA = a(obtainMainView());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            viewA = null;
        }
        if (viewA != null) {
            if (viewA instanceof androidx.recyclerview.widget.RecyclerView) {
                ((androidx.recyclerview.widget.RecyclerView) viewA).scrollToPosition(0);
            } else {
                viewA.scrollTo(0, 0);
            }
        }
    }

    private android.view.View a(android.view.View view) {
        if (!(view instanceof android.view.ViewGroup)) {
            return null;
        }
        if (view.canScrollVertically(-1)) {
            return view;
        }
        int i = 0;
        while (true) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return null;
            }
            android.view.View viewA = a(viewGroup.getChildAt(i));
            if (viewA != null) {
                return viewA;
            }
            i++;
        }
    }
}
