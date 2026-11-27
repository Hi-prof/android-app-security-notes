package io.dcloud.common.core.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class k extends android.widget.FrameLayout {
    private int a;
    private float b;
    private boolean c;
    private android.view.View d;
    private io.dcloud.common.core.ui.j e;
    private float f;
    private android.graphics.drawable.Drawable g;
    private float h;
    private android.graphics.Rect i;
    io.dcloud.common.adapter.ui.DHImageView j;
    io.dcloud.common.adapter.ui.DHImageView k;
    io.dcloud.common.core.ui.a l;
    private io.dcloud.common.core.ui.b m;
    private io.dcloud.common.core.ui.b n;
    private final int o;
    private final int p;
    private int q;
    private int r;
    private boolean s;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface b {
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class c extends io.dcloud.common.core.ui.j.c {
        private boolean a;

        private c() {
        }

        @Override // io.dcloud.common.core.ui.j.c
        public int a(android.view.View view) {
            return 1;
        }

        @Override // io.dcloud.common.core.ui.j.c
        public int b(android.view.View view) {
            return 1;
        }

        @Override // io.dcloud.common.core.ui.j.c
        public void c(int i) {
            super.c(i);
            io.dcloud.common.core.ui.k.j(io.dcloud.common.core.ui.k.this);
            if (i == 0) {
                io.dcloud.common.core.ui.k kVar = io.dcloud.common.core.ui.k.this;
                kVar.a(kVar.m, "end", java.lang.Boolean.valueOf(io.dcloud.common.core.ui.k.this.f >= 1.0f));
                io.dcloud.common.core.ui.k.this.requestLayout();
                io.dcloud.common.core.ui.k.this.b();
                if (io.dcloud.common.core.ui.k.this.f >= 1.0f) {
                    if (io.dcloud.common.core.ui.k.this.n != null) {
                        io.dcloud.common.core.ui.k.this.n.setSlipping(false);
                    }
                    if (io.dcloud.common.core.ui.k.this.m != null) {
                        io.dcloud.common.core.ui.k.this.m.setSlipping(false);
                    }
                    io.dcloud.common.core.ui.k.this.a();
                } else if (io.dcloud.common.core.ui.k.this.q == 1 && io.dcloud.common.core.ui.k.this.f == 0.0f && io.dcloud.common.core.ui.k.this.m != null && io.dcloud.common.core.ui.k.this.m.obtainWebView().canGoBack()) {
                    io.dcloud.common.core.ui.k.this.m.obtainWebView().goBackOrForward(-1);
                }
                io.dcloud.common.core.ui.k.this.m = null;
                io.dcloud.common.core.ui.k.this.n = null;
            }
        }

        @Override // io.dcloud.common.core.ui.j.c
        public void a(android.view.View view, int i, int i2, int i3, int i4) {
            super.a(view, i, i2, i3, i4);
            if (io.dcloud.common.core.ui.k.this.q == 1) {
                return;
            }
            if ((io.dcloud.common.core.ui.k.this.r & 1) != 0) {
                io.dcloud.common.core.ui.k kVar = io.dcloud.common.core.ui.k.this;
                kVar.f = java.lang.Math.abs(i / (kVar.d.getWidth() + io.dcloud.common.core.ui.k.this.g.getIntrinsicWidth()));
            }
            io.dcloud.common.core.ui.k.this.invalidate();
            if (io.dcloud.common.core.ui.k.this.f < io.dcloud.common.core.ui.k.this.b && !this.a) {
                this.a = true;
            }
            io.dcloud.common.core.ui.k.j(io.dcloud.common.core.ui.k.this);
            io.dcloud.common.core.ui.k kVar2 = io.dcloud.common.core.ui.k.this;
            kVar2.a(kVar2.n);
        }

        @Override // io.dcloud.common.core.ui.j.c
        public boolean b(android.view.View view, int i) {
            io.dcloud.common.core.ui.k.this.d = view;
            if (io.dcloud.common.core.ui.k.this.e.d(io.dcloud.common.core.ui.k.this.a, i)) {
                if (io.dcloud.common.core.ui.k.this.e.d(1, i)) {
                    io.dcloud.common.core.ui.k.this.r = 1;
                }
                io.dcloud.common.core.ui.k.j(io.dcloud.common.core.ui.k.this);
                this.a = true;
            }
            return true;
        }

        @Override // io.dcloud.common.core.ui.j.c
        public void a(android.view.View view, float f, float f2) {
            if (io.dcloud.common.core.ui.k.this.q == 1) {
                return;
            }
            io.dcloud.common.core.ui.k.this.e.e(((io.dcloud.common.core.ui.k.this.r & 1) == 0 || (f <= 0.0f && (f != 0.0f || io.dcloud.common.core.ui.k.this.f <= io.dcloud.common.core.ui.k.this.b))) ? 0 : view.getWidth() + io.dcloud.common.core.ui.k.this.g.getIntrinsicWidth() + 10, 0);
            io.dcloud.common.core.ui.k.this.invalidate();
        }

        @Override // io.dcloud.common.core.ui.j.c
        public int a(android.view.View view, int i, int i2) {
            if (io.dcloud.common.core.ui.k.this.q == 1) {
                return 0;
            }
            return java.lang.Math.min(view.getWidth(), java.lang.Math.max(i, 0));
        }

        @Override // io.dcloud.common.core.ui.j.c
        public boolean a(io.dcloud.common.core.ui.b bVar) {
            int i;
            int i2;
            if (bVar == null || 2 == bVar.getFrameType() || io.dcloud.common.util.BaseInfo.sDoingAnimation || !io.dcloud.common.core.ui.k.this.s) {
                return false;
            }
            android.graphics.Rect rect = new android.graphics.Rect();
            bVar.obtainWebView().obtainWindowView().getGlobalVisibleRect(rect);
            io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions = bVar.obtainFrameOptions();
            io.dcloud.common.core.ui.k.this.m = bVar;
            int height = io.dcloud.common.core.ui.k.this.getHeight();
            if (bVar.obtainApp() != null && bVar.obtainApp().obtainStatusBarMgr() != null && bVar.obtainApp().obtainStatusBarMgr().isHandledWhiteScreen) {
                height--;
            }
            if (rect.left != 0 || (((i = viewOptionsObtainFrameOptions.width) != -1 && i < io.dcloud.common.core.ui.k.this.getWidth()) || (((i2 = viewOptionsObtainFrameOptions.height) != -1 && i2 < height) || bVar.obtainFrameOptions().popGesture.equals("none")))) {
                return false;
            }
            if ((bVar.obtainFrameOptions().historyBack.equals("all") || bVar.obtainFrameOptions().historyBack.equals("popGesture")) && bVar.obtainWebView() != null && bVar.obtainWebView().canGoBack()) {
                io.dcloud.common.core.ui.k.this.q = 1;
                return true;
            }
            io.dcloud.common.core.ui.k.this.c();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            io.dcloud.common.core.ui.k.this.l.a(bVar, arrayList);
            bVar.mWindowMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 28, arrayList);
            io.dcloud.common.core.ui.k.this.n = null;
            if (arrayList.size() == 1) {
                io.dcloud.common.core.ui.k.this.n = (io.dcloud.common.core.ui.b) arrayList.get(0);
            }
            if (arrayList.size() > 0) {
                if (io.dcloud.common.core.ui.k.this.n != null) {
                    io.dcloud.common.core.ui.k.this.n.setSlipping(true);
                    io.dcloud.common.core.ui.k.this.n.obtainMainView().setVisibility(0);
                    io.dcloud.common.core.ui.k.this.n.obtainMainView().bringToFront();
                }
                bVar.setSlipping(true);
                bVar.obtainMainView().setVisibility(0);
                bVar.obtainMainView().bringToFront();
                io.dcloud.common.core.ui.k.this.q = 2;
                io.dcloud.common.adapter.ui.FrameSwitchView frameSwitchView = io.dcloud.common.adapter.ui.FrameSwitchView.getInstance();
                if (frameSwitchView != null) {
                    frameSwitchView.endRefreshView();
                }
                io.dcloud.common.core.ui.k.this.a(bVar, "start", com.taobao.weex.common.Constants.Name.UNDEFINED);
                return true;
            }
            return false;
        }
    }

    public k(android.content.Context context, io.dcloud.common.core.ui.a aVar) {
        super(context);
        this.b = 0.3f;
        this.c = true;
        this.i = new android.graphics.Rect();
        this.l = null;
        this.o = 1;
        this.p = 2;
        this.q = 1;
        this.s = false;
        float f = getResources().getDisplayMetrics().density * 400.0f;
        this.l = aVar;
        io.dcloud.common.core.ui.j jVar = new io.dcloud.common.core.ui.j(this, new io.dcloud.common.core.ui.k.c(), aVar);
        this.e = jVar;
        jVar.b(f);
        setEdgeTrackingEnabled(1);
        this.j = new io.dcloud.common.adapter.ui.DHImageView(context);
        this.k = new io.dcloud.common.adapter.ui.DHImageView(context);
        addView(this.j, new android.widget.FrameLayout.LayoutParams(-1, -1));
        addView(this.k, new android.widget.FrameLayout.LayoutParams(-1, -1));
        a(io.dcloud.PdrR.DRAWEBL_SHADOW_LEFT, 1);
        this.k.setVisibility(8);
        this.j.setVisibility(8);
    }

    static /* synthetic */ io.dcloud.common.core.ui.k.b j(io.dcloud.common.core.ui.k kVar) {
        kVar.getClass();
        return null;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.h = 1.0f - this.f;
        if (this.e.a(true)) {
            com.dcloud.android.v4.view.ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(android.graphics.Canvas canvas, android.view.View view, long j) {
        boolean z = view == this.d;
        boolean zDrawChild = super.drawChild(canvas, view, j);
        if (this.h > 0.0f && z && this.e.c() != 0) {
            a(canvas, view);
        }
        return zDrawChild;
    }

    public io.dcloud.common.adapter.ui.DHImageView getLeftImageView() {
        return this.j;
    }

    public io.dcloud.common.adapter.ui.DHImageView getRightImageView() {
        return this.k;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (!this.c) {
            return false;
        }
        try {
            return this.e.c(motionEvent);
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (!this.c) {
            return false;
        }
        io.dcloud.common.core.ui.b bVar = this.m;
        if (bVar == null || bVar.obtainMainView() == null) {
            return true;
        }
        try {
            this.e.a(motionEvent);
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        io.dcloud.common.core.ui.j jVar = this.e;
        if (jVar == null) {
            super.requestLayout();
        } else if (jVar.c() == 0) {
            super.requestLayout();
        }
    }

    public void setEdgeSize(int i) {
        this.e.e(i);
    }

    public void setEdgeTrackingEnabled(int i) {
        this.a = i;
        this.e.f(i);
    }

    public void setEnableGesture(boolean z) {
        this.c = z;
    }

    public void setScrollThresHold(float f) {
        if (f >= 1.0f || f <= 0.0f) {
            throw new java.lang.IllegalArgumentException("Threshold value should be between 0 and 1.0");
        }
        this.b = f;
    }

    public void setSwipeListener(io.dcloud.common.core.ui.k.b bVar) {
    }

    public void c() {
        io.dcloud.common.adapter.ui.DHImageView dHImageView = this.j;
        if (dHImageView != null && dHImageView.getParent() == null) {
            addView(this.j, new android.widget.FrameLayout.LayoutParams(-1, -1));
        }
        io.dcloud.common.adapter.ui.DHImageView dHImageView2 = this.k;
        if (dHImageView2 == null || dHImageView2.getParent() != null) {
            return;
        }
        addView(this.k, new android.widget.FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        io.dcloud.common.core.ui.b bVar = this.n;
        if (bVar != null) {
            bVar.obtainMainView().setTranslationX(0.0f);
        }
        io.dcloud.common.core.ui.b bVar2 = this.m;
        if (bVar2 != null) {
            bVar2.obtainMainView().setLeft(0);
            this.m.obtainMainView().setTranslationX(0.0f);
        }
    }

    public void a(android.graphics.drawable.Drawable drawable, int i) {
        if ((i & 1) != 0) {
            this.g = drawable;
        }
        invalidate();
    }

    public void a(int i, int i2) {
        a(getResources().getDrawable(i), i2);
    }

    private void a(android.graphics.Canvas canvas, android.view.View view) {
        android.graphics.Rect rect = this.i;
        view.getHitRect(rect);
        if ((this.a & 1) != 0) {
            android.graphics.drawable.Drawable drawable = this.g;
            drawable.setBounds((int) (((double) rect.left) - (((double) drawable.getIntrinsicWidth()) * 0.6d)), rect.top, rect.left, rect.bottom);
            this.g.setAlpha((int) (this.h * 190.0f));
            this.g.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(io.dcloud.common.core.ui.b bVar) {
        if (bVar != null) {
            android.view.View viewObtainMainView = bVar.obtainMainView();
            float width = (float) ((((double) this.f) - 0.95d) * 0.4210526315789474d * ((double) viewObtainMainView.getWidth()));
            if (width > 0.0f) {
                width = 0.0f;
            }
            viewObtainMainView.setTranslationX(width);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        io.dcloud.common.core.ui.b bVar = this.m;
        if (bVar != null) {
            java.lang.String str = bVar.obtainFrameOptions().popGesture;
            if (str.equals("hide")) {
                this.m.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBAPP_SLIDE_HIDE, null);
                io.dcloud.common.core.ui.b bVar2 = this.m;
                bVar2.mWindowMgr.c(bVar2);
            } else if (str.equals(io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE)) {
                this.m.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBAPP_SLIDE_CLOSE, null);
                io.dcloud.common.core.ui.b bVar3 = this.m;
                bVar3.mWindowMgr.a(bVar3);
            }
        }
    }

    public void a(io.dcloud.common.adapter.ui.AdaFrameView adaFrameView, java.lang.String str, java.lang.Object obj) {
        adaFrameView.dispatchFrameViewEvents("popGesture", new java.lang.Object[]{str, obj, this.m});
    }
}
