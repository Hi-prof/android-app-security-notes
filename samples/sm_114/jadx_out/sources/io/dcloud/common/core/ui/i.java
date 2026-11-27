package io.dcloud.common.core.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static android.view.View a = null;
    public static io.dcloud.common.adapter.ui.DHImageView b = null;
    private static boolean c = false;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements android.view.animation.Animation.AnimationListener {
        final /* synthetic */ io.dcloud.common.core.ui.b a;

        a(io.dcloud.common.core.ui.b bVar) {
            this.a = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
            io.dcloud.common.util.BaseInfo.sDoingAnimation = false;
            io.dcloud.common.adapter.ui.DHImageView dHImageView = io.dcloud.common.core.ui.i.b;
            if (dHImageView == null || dHImageView.isNativeView()) {
                io.dcloud.common.adapter.ui.DHImageView dHImageView2 = io.dcloud.common.core.ui.i.b;
                if (dHImageView2 == null || !dHImageView2.isNativeView()) {
                    return;
                }
                this.a.handleNativeViewByAction(io.dcloud.common.core.ui.i.b, 0);
                io.dcloud.common.core.ui.i.b = null;
                return;
            }
            io.dcloud.common.adapter.ui.DHImageView dHImageView3 = io.dcloud.common.core.ui.i.b;
            if (dHImageView3 != null) {
                dHImageView3.setIntercept(false);
                io.dcloud.common.core.ui.i.b.clearAnimation();
                io.dcloud.common.core.ui.i.b.setVisibility(4);
                io.dcloud.common.core.ui.i.b.setImageBitmap(null);
                io.dcloud.common.core.ui.i.b = null;
            }
            android.view.View view = io.dcloud.common.core.ui.i.a;
            if (view != null) {
                view.clearAnimation();
                io.dcloud.common.core.ui.i.a = null;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(android.view.animation.Animation animation) {
            io.dcloud.common.adapter.ui.DHImageView dHImageView = io.dcloud.common.core.ui.i.b;
            if (dHImageView != null) {
                dHImageView.setIntercept(true);
            }
            io.dcloud.common.util.BaseInfo.sDoingAnimation = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements android.view.animation.Animation.AnimationListener {
        final /* synthetic */ io.dcloud.common.core.ui.b a;

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class a implements java.lang.Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.common.adapter.ui.DHImageView dHImageView = io.dcloud.common.core.ui.i.b;
                if (dHImageView != null) {
                    dHImageView.clearAnimation();
                    io.dcloud.common.core.ui.i.b.setVisibility(4);
                    if (io.dcloud.common.core.ui.i.b.isNativeView()) {
                        io.dcloud.common.core.ui.i.b.this.a.handleNativeViewByAction(io.dcloud.common.core.ui.i.b, 1);
                    }
                    io.dcloud.common.core.ui.i.b.removeNativeView();
                    io.dcloud.common.core.ui.i.b.setImageBitmap(null);
                    io.dcloud.common.core.ui.i.b.setTag(0);
                    io.dcloud.common.core.ui.i.b = null;
                }
                android.view.View view = io.dcloud.common.core.ui.i.a;
                if (view != null) {
                    view.clearAnimation();
                    io.dcloud.common.core.ui.i.a = null;
                }
            }
        }

        b(io.dcloud.common.core.ui.b bVar) {
            this.a = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
            io.dcloud.common.adapter.ui.DHImageView dHImageView = io.dcloud.common.core.ui.i.b;
            if (dHImageView != null) {
                dHImageView.setIntercept(false);
                io.dcloud.common.core.ui.i.b.setNativeAnimationRuning(false);
            }
            io.dcloud.common.util.BaseInfo.sDoingAnimation = false;
            io.dcloud.common.adapter.ui.DHImageView dHImageView2 = io.dcloud.common.core.ui.i.b;
            int i = (dHImageView2 == null || !dHImageView2.isNativeView()) ? 320 : 0;
            android.view.View viewObtainMainView = io.dcloud.common.core.ui.i.a;
            if (viewObtainMainView == null) {
                viewObtainMainView = this.a.obtainMainView();
            }
            viewObtainMainView.postDelayed(new io.dcloud.common.core.ui.i.b.a(), i);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(android.view.animation.Animation animation) {
            io.dcloud.common.adapter.ui.DHImageView dHImageView = io.dcloud.common.core.ui.i.b;
            if (dHImageView != null) {
                dHImageView.setIntercept(true);
                io.dcloud.common.core.ui.i.b.setNativeAnimationRuning(true);
            }
            io.dcloud.common.util.BaseInfo.sDoingAnimation = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements android.view.animation.Animation.AnimationListener {
        final /* synthetic */ io.dcloud.common.core.ui.b a;

        c(io.dcloud.common.core.ui.b bVar) {
            this.a = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
            io.dcloud.common.core.ui.i.c(this.a);
            android.view.View view = io.dcloud.common.core.ui.i.a;
            if (view != null) {
                io.dcloud.nineoldandroids.view.ViewHelper.setX(view, this.a.obtainFrameOptions().left);
                io.dcloud.nineoldandroids.view.ViewHelper.setY(io.dcloud.common.core.ui.i.a, this.a.obtainFrameOptions().top);
                io.dcloud.common.core.ui.i.a.clearAnimation();
                io.dcloud.common.core.ui.i.a = null;
            }
            io.dcloud.common.util.BaseInfo.sDoingAnimation = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(android.view.animation.Animation animation) {
            io.dcloud.common.util.BaseInfo.sDoingAnimation = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements android.view.animation.Animation.AnimationListener {
        final /* synthetic */ io.dcloud.common.core.ui.b a;

        d(io.dcloud.common.core.ui.b bVar) {
            this.a = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
            io.dcloud.common.core.ui.i.c(this.a);
            android.view.View view = io.dcloud.common.core.ui.i.a;
            if (view != null) {
                io.dcloud.nineoldandroids.view.ViewHelper.setX(view, this.a.obtainFrameOptions().left);
                io.dcloud.nineoldandroids.view.ViewHelper.setY(io.dcloud.common.core.ui.i.a, this.a.obtainFrameOptions().top);
                io.dcloud.common.core.ui.i.a.clearAnimation();
                io.dcloud.common.core.ui.i.a = null;
            }
            io.dcloud.common.util.BaseInfo.sDoingAnimation = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(android.view.animation.Animation animation) {
            io.dcloud.common.util.BaseInfo.sDoingAnimation = true;
        }
    }

    public static boolean b(io.dcloud.common.core.ui.b bVar) {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) bVar.obtainMainView();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i) instanceof io.dcloud.common.DHInterface.ITypeofAble) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(io.dcloud.common.core.ui.b bVar) {
        if (bVar == null || bVar.k == null) {
            return;
        }
        bVar.mWindowMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 70, null);
        bVar.k.obtainMainView().setBackgroundColor(-1);
        for (io.dcloud.common.core.ui.b bVar2 : bVar.k.d()) {
            if (bVar2.f()) {
                bVar2.d(false);
                bVar2.obtainMainView().setVisibility(0);
            }
        }
    }

    public static void a(io.dcloud.common.core.ui.b bVar, int i) {
        java.lang.String str = bVar.getAnimOptions().mAnimType;
        java.lang.String str2 = bVar.getAnimOptions().mAnimType_close;
        io.dcloud.common.core.ui.b bVar2 = (io.dcloud.common.core.ui.b) bVar.k.findFrameViewB(bVar);
        if (bVar2 == null) {
            return;
        }
        if (i == 1) {
            java.lang.String closeAnimType = io.dcloud.common.adapter.util.AnimOptions.getCloseAnimType(str2);
            if (bVar.mAccelerationType.equals("auto") && io.dcloud.common.util.PdrUtil.isContains(closeAnimType, "slide")) {
                return;
            }
            if (bVar.mAccelerationType.equals("auto") && !io.dcloud.common.util.PdrUtil.isEquals(closeAnimType, io.dcloud.common.adapter.util.AnimOptions.ANIM_POP_OUT) && !io.dcloud.common.util.BaseInfo.isDefaultAim && bVar2.mSnapshot == null) {
                return;
            }
            if (bVar.mAccelerationType.equals("none") && !io.dcloud.common.util.PdrUtil.isEquals(closeAnimType, io.dcloud.common.adapter.util.AnimOptions.ANIM_POP_OUT) && bVar2.mSnapshot == null) {
                return;
            }
            if (!bVar.mAccelerationType.equals("none") && bVar2.mSnapshot == null) {
                io.dcloud.common.util.BaseInfo.sOpenedCount--;
            }
        } else {
            if (bVar.mAccelerationType.equals("auto") && io.dcloud.common.util.PdrUtil.isContains(str2, "slide")) {
                return;
            }
            if (bVar.mAccelerationType.equals("auto") && !io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.adapter.util.AnimOptions.ANIM_POP_IN) && !io.dcloud.common.util.BaseInfo.isDefaultAim && bVar2.mSnapshot == null) {
                return;
            }
            if (bVar.mAccelerationType.equals("none") && !io.dcloud.common.util.PdrUtil.isEquals(str2, io.dcloud.common.adapter.util.AnimOptions.ANIM_POP_IN) && bVar2.mSnapshot == null) {
                return;
            }
            if (!bVar.mAccelerationType.equals("none") && bVar2.mSnapshot == null) {
                int i2 = io.dcloud.common.util.BaseInfo.sOpenedCount + 1;
                io.dcloud.common.util.BaseInfo.sOpenedCount = i2;
                c = i2 > 1;
            }
        }
        a = bVar2.obtainMainView();
        bVar2.k.a(bVar2, bVar);
        bVar2.chkUseCaptureAnimation(true, bVar2.hashCode(), bVar2.mSnapshot != null);
        if (bVar2.mAnimationCapture && io.dcloud.common.util.BaseInfo.sAnimationCaptureB && !b(bVar2)) {
            io.dcloud.common.adapter.util.Logger.e("mabo", "B页面是否启用截图动画方案:true | " + bVar2.getAnimOptions().mAnimType);
            a(i, bVar2, bVar);
        } else {
            io.dcloud.common.adapter.util.Logger.e("mabo", "B页面是否启用截图动画方案:false | " + bVar2.getAnimOptions().mAnimType);
            b(i, bVar2, bVar);
        }
        if (io.dcloud.common.util.BaseInfo.sOpenedCount == 0) {
            c = false;
        }
    }

    private static void b(int i, io.dcloud.common.core.ui.b bVar, io.dcloud.common.core.ui.b bVar2) {
        android.view.animation.Animation translateAnimation;
        int i2 = bVar2.obtainApp().getInt(0);
        if (i == 0) {
            if (io.dcloud.common.util.PdrUtil.isEquals(bVar2.getAnimOptions().mAnimType, io.dcloud.common.adapter.util.AnimOptions.ANIM_POP_IN)) {
                if (android.os.Build.VERSION.SDK_INT >= 23) {
                    translateAnimation = android.view.animation.AnimationUtils.loadAnimation(bVar.getContext(), io.dcloud.base.R.anim.dcloud_page_open_exit);
                    a(bVar, bVar2);
                } else {
                    translateAnimation = new android.view.animation.TranslateAnimation(bVar.obtainFrameOptions().left, (-i2) / 4, 0.0f, 0.0f);
                    translateAnimation.setDuration(bVar2.getAnimOptions().duration_show);
                    translateAnimation.setInterpolator(new android.view.animation.DecelerateInterpolator());
                }
            } else {
                translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f);
                translateAnimation.setDuration(bVar2.getAnimOptions().duration_show);
            }
            translateAnimation.setAnimationListener(new io.dcloud.common.core.ui.i.c(bVar));
        } else {
            if (io.dcloud.common.util.PdrUtil.isEquals(io.dcloud.common.adapter.util.AnimOptions.getCloseAnimType(bVar2.getAnimOptions().mAnimType_close), io.dcloud.common.adapter.util.AnimOptions.ANIM_POP_OUT)) {
                if (android.os.Build.VERSION.SDK_INT >= 23) {
                    translateAnimation = android.view.animation.AnimationUtils.loadAnimation(bVar.getContext(), io.dcloud.base.R.anim.dcloud_page_close_enter);
                    a(bVar, bVar2);
                } else {
                    translateAnimation = new android.view.animation.TranslateAnimation((-i2) / 4, bVar2.obtainFrameOptions().left, 0.0f, 0.0f);
                    translateAnimation.setDuration(bVar2.getAnimOptions().duration_close);
                    translateAnimation.setInterpolator(new android.view.animation.DecelerateInterpolator());
                }
            } else {
                translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f);
                translateAnimation.setDuration(bVar2.getAnimOptions().duration_close);
            }
            translateAnimation.setAnimationListener(new io.dcloud.common.core.ui.i.d(bVar));
        }
        android.view.View view = b;
        if (view == null) {
            view = a;
        }
        view.startAnimation(translateAnimation);
        bVar.k.f(bVar);
    }

    private static void a(int i, io.dcloud.common.core.ui.b bVar, io.dcloud.common.core.ui.b bVar2) {
        android.view.animation.TranslateAnimation translateAnimation;
        int i2 = bVar2.obtainApp().getInt(0);
        io.dcloud.common.adapter.ui.DHImageView dHImageViewA = bVar2.k.a(bVar, i, c);
        b = dHImageViewA;
        if (dHImageViewA == null) {
            b(i, bVar, bVar2);
            return;
        }
        if (i == 0) {
            dHImageViewA.setTag(java.lang.Integer.valueOf(bVar.hashCode()));
            if (io.dcloud.common.util.PdrUtil.isEquals(bVar2.getAnimOptions().mAnimType, io.dcloud.common.adapter.util.AnimOptions.ANIM_POP_IN)) {
                translateAnimation = new android.view.animation.TranslateAnimation(bVar.obtainFrameOptions().left, (-i2) / 4, 0.0f, 0.0f);
                translateAnimation.setFillAfter(true);
                translateAnimation.setDuration(300L);
            } else {
                translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f);
                translateAnimation.setDuration(bVar2.getAnimOptions().duration_show);
            }
            translateAnimation.setInterpolator(new android.view.animation.DecelerateInterpolator());
            translateAnimation.setAnimationListener(new io.dcloud.common.core.ui.i.a(bVar));
        } else {
            if (io.dcloud.common.util.PdrUtil.isEquals(io.dcloud.common.adapter.util.AnimOptions.getCloseAnimType(bVar2.getAnimOptions().mAnimType_close), io.dcloud.common.adapter.util.AnimOptions.ANIM_POP_OUT)) {
                translateAnimation = new android.view.animation.TranslateAnimation((-i2) / 4, bVar.obtainFrameOptions().left, 0.0f, 0.0f);
                translateAnimation.setFillAfter(true);
                translateAnimation.setDuration(360L);
            } else {
                translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f);
                translateAnimation.setDuration(bVar2.getAnimOptions().duration_close);
            }
            translateAnimation.setInterpolator(new android.view.animation.DecelerateInterpolator());
            translateAnimation.setAnimationListener(new io.dcloud.common.core.ui.i.b(bVar));
        }
        android.view.View view = b;
        if (view == null) {
            view = a;
        }
        view.startAnimation(translateAnimation);
        bVar.k.f(bVar);
    }

    private static void a(io.dcloud.common.core.ui.b bVar, io.dcloud.common.core.ui.b bVar2) {
        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions;
        if (bVar == null || bVar.k == null) {
            return;
        }
        if (bVar instanceof io.dcloud.common.core.ui.c) {
            io.dcloud.common.core.ui.c cVar = (io.dcloud.common.core.ui.c) bVar;
            if (cVar.u() != null && (viewOptionsObtainFrameOptions = cVar.u().obtainFrameOptions()) != null && !io.dcloud.common.util.PdrUtil.isEmpty(viewOptionsObtainFrameOptions.animationAlphaBackground)) {
                bVar.k.obtainMainView().setBackgroundColor(io.dcloud.common.util.PdrUtil.stringToColor(viewOptionsObtainFrameOptions.animationAlphaBackground));
            }
        } else if (bVar.obtainFrameOptions() != null && !io.dcloud.common.util.PdrUtil.isEmpty(bVar.obtainFrameOptions().animationAlphaBackground)) {
            bVar.k.obtainMainView().setBackgroundColor(io.dcloud.common.util.PdrUtil.stringToColor(bVar.obtainFrameOptions().animationAlphaBackground));
        }
        for (io.dcloud.common.core.ui.b bVar3 : bVar.k.d()) {
            if (bVar3 != bVar && bVar2 != bVar3 && bVar3.obtainMainView().getVisibility() == 0) {
                bVar3.d(true);
                bVar3.obtainMainView().setVisibility(4);
            }
        }
    }
}
