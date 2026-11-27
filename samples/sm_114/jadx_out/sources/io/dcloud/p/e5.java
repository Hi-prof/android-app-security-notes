package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e5 implements io.dcloud.common.DHInterface.IAppInfo {
    io.dcloud.common.util.AppStatusBarManager m;
    protected android.app.Activity a = null;
    protected io.dcloud.common.DHInterface.IWebAppRootView b = null;
    private io.dcloud.common.DHInterface.IOnCreateSplashView c = null;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    protected boolean i = false;
    private boolean j = false;
    private int k = 0;
    io.dcloud.common.adapter.util.ViewRect l = new io.dcloud.common.adapter.util.ViewRect();
    public java.lang.String n = "none";
    public java.lang.String o = null;
    protected boolean p = false;
    protected boolean q = false;
    private android.widget.RelativeLayout r = null;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements io.dcloud.common.adapter.util.MessageHandler.IMessages {
        final /* synthetic */ java.lang.String a;

        a(java.lang.String str) {
            this.a = str;
        }

        @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
        public void execute(java.lang.Object obj) {
            if ("landscape".equals(this.a)) {
                io.dcloud.p.e5.this.a.setRequestedOrientation(6);
                return;
            }
            if ("landscape-primary".equals(this.a)) {
                io.dcloud.p.e5.this.a.setRequestedOrientation(0);
                return;
            }
            if ("landscape-secondary".equals(this.a)) {
                io.dcloud.p.e5.this.a.setRequestedOrientation(8);
                return;
            }
            if ("portrait".equals(this.a)) {
                io.dcloud.p.e5.this.a.setRequestedOrientation(7);
                return;
            }
            if ("portrait-primary".equals(this.a)) {
                io.dcloud.p.e5.this.a.setRequestedOrientation(1);
            } else if ("portrait-secondary".equals(this.a)) {
                io.dcloud.p.e5.this.a.setRequestedOrientation(9);
            } else {
                io.dcloud.p.e5.this.a.setRequestedOrientation(4);
            }
        }
    }

    void a(android.app.Activity activity) {
        if (this.m == null) {
            this.m = new io.dcloud.common.util.AppStatusBarManager(activity, this);
        }
        this.a = activity;
    }

    public int checkSelfPermission(java.lang.String str, java.lang.String str2) {
        return io.dcloud.common.adapter.util.PermissionUtil.checkSelfPermission(this.a, str, str2);
    }

    @Override // io.dcloud.common.DHInterface.IAppInfo
    public void clearMaskLayerCount() {
        this.k = 0;
    }

    @Override // io.dcloud.common.DHInterface.IAppInfo
    public android.app.Activity getActivity() {
        return this.a;
    }

    @Override // io.dcloud.common.DHInterface.IAppInfo
    public io.dcloud.common.adapter.util.ViewRect getAppViewRect() {
        return this.l;
    }

    @Override // io.dcloud.common.DHInterface.IAppInfo, io.dcloud.common.DHInterface.IType_IntValue
    public int getInt(int i) {
        if (i == 0) {
            return this.d;
        }
        if (i == 1) {
            return this.h;
        }
        if (i != 2) {
            return -1;
        }
        return this.e;
    }

    @Override // io.dcloud.common.DHInterface.IAppInfo
    public int getMaskLayerCount() {
        return this.k;
    }

    @Override // io.dcloud.common.DHInterface.IAppInfo
    public io.dcloud.common.DHInterface.IOnCreateSplashView getOnCreateSplashView() {
        return this.c;
    }

    @Override // io.dcloud.common.DHInterface.IAppInfo
    public int getRequestedOrientation() {
        return this.a.getRequestedOrientation();
    }

    @Override // io.dcloud.common.DHInterface.IAppInfo
    public boolean isFullScreen() {
        return this.i;
    }

    @Override // io.dcloud.common.DHInterface.IAppInfo
    public boolean isVerticalScreen() {
        return this.a.getResources().getConfiguration().orientation == 1;
    }

    @Override // io.dcloud.common.DHInterface.IAppInfo
    public io.dcloud.common.DHInterface.IWebAppRootView obtainWebAppRootView() {
        return this.b;
    }

    public void requestPermissions(java.lang.String[] strArr, int i) {
        io.dcloud.common.adapter.util.PermissionUtil.requestPermissions(this.a, strArr, i);
    }

    @Override // io.dcloud.common.DHInterface.IAppInfo
    public void setFullScreen(boolean z) {
        if (io.dcloud.common.util.BaseInfo.sGlobalFullScreen != z) {
            this.i = z;
            io.dcloud.common.util.AppStatusBarManager appStatusBarManager = this.m;
            if (appStatusBarManager != null) {
                appStatusBarManager.setFullScreen(getActivity(), z);
            }
            updateScreenInfo(this.i ? 2 : 3);
        }
        io.dcloud.common.util.BaseInfo.sGlobalFullScreen = z;
    }

    @Override // io.dcloud.common.DHInterface.IAppInfo
    public void setMaskLayer(boolean z) {
        this.j = z;
        if (z) {
            this.k++;
            return;
        }
        int i = this.k - 1;
        this.k = i;
        if (i < 0) {
            this.k = 0;
        }
    }

    @Override // io.dcloud.common.DHInterface.IAppInfo
    public void setOnCreateSplashView(io.dcloud.common.DHInterface.IOnCreateSplashView iOnCreateSplashView) {
        this.c = iOnCreateSplashView;
    }

    @Override // io.dcloud.common.DHInterface.IAppInfo
    public void setRequestedOrientation(java.lang.String str) {
        try {
            io.dcloud.common.adapter.util.MessageHandler.sendMessage(new io.dcloud.p.e5.a(str), 48L, str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // io.dcloud.common.DHInterface.IAppInfo
    public void setWebAppRootView(io.dcloud.common.DHInterface.IWebAppRootView iWebAppRootView) {
        this.b = iWebAppRootView;
    }

    @Override // io.dcloud.common.DHInterface.IAppInfo
    public void updateScreenInfo(int i) {
        if (android.os.Build.VERSION.SDK_INT >= 36 && io.dcloud.common.adapter.util.AndroidResources.sAppTargetSdkVersion >= 36) {
            android.view.View viewFindViewById = this.a.findViewById(android.R.id.content);
            android.view.View decorView = this.a.getWindow().getDecorView();
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -2, 80);
            if (viewFindViewById != null && (viewFindViewById.getLayoutParams() instanceof android.view.ViewGroup.MarginLayoutParams)) {
                android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) viewFindViewById.getLayoutParams();
                android.view.WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
                if (rootWindowInsets != null) {
                    android.graphics.Insets insets = rootWindowInsets.getInsets(android.view.WindowInsets.Type.navigationBars());
                    int i2 = insets.left;
                    marginLayoutParams.leftMargin = i2;
                    int i3 = insets.right;
                    marginLayoutParams.rightMargin = i3;
                    int i4 = insets.bottom;
                    marginLayoutParams.bottomMargin = i4;
                    layoutParams.leftMargin = i2;
                    layoutParams.rightMargin = i3;
                    layoutParams.height = i4 - insets.top;
                }
            }
            android.view.View viewFindViewById2 = this.a.findViewById(android.R.id.navigationBarBackground);
            if (viewFindViewById2 != null) {
                if (this.r == null) {
                    this.r = new android.widget.RelativeLayout(this.a);
                }
                if (this.r.getBackground() == null) {
                    this.r.setBackgroundColor(android.graphics.Color.parseColor("#FCFCFC"));
                }
                if (this.r.getParent() == null) {
                    ((android.view.ViewGroup) viewFindViewById2.getParent()).addView(this.r, viewFindViewById2.getLayoutParams());
                } else {
                    this.r.setLayoutParams(viewFindViewById2.getLayoutParams());
                }
            } else if (layoutParams.height > 0) {
                if (this.r == null) {
                    this.r = new android.widget.RelativeLayout(this.a);
                }
                if (this.r.getBackground() == null) {
                    this.r.setBackgroundColor(android.graphics.Color.parseColor("#FCFCFC"));
                }
                if (this.r.getParent() == null) {
                    ((android.view.ViewGroup) decorView).addView(this.r, layoutParams);
                } else if (this.r.getParent() == decorView) {
                    this.r.setLayoutParams(layoutParams);
                } else {
                    ((android.view.ViewGroup) this.r.getParent()).removeView(this.r);
                    ((android.view.ViewGroup) decorView).addView(this.r, layoutParams);
                }
            }
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
        }
        if (!this.i && this.f == 0) {
            android.graphics.Rect rect = new android.graphics.Rect();
            this.a.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int i5 = rect.top;
            this.f = i5;
            if (i5 > 0) {
                io.dcloud.common.adapter.util.SP.setBundleData(getActivity(), io.dcloud.common.util.BaseInfo.PDR, "StatusBarHeight", java.lang.String.valueOf(this.f));
            }
        }
        android.util.DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
        int i6 = displayMetrics.widthPixels;
        int i7 = displayMetrics.heightPixels;
        boolean z = i6 < i7;
        boolean zIsAllScreenDevice = io.dcloud.common.util.PdrUtil.isAllScreenDevice(this.a);
        if (zIsAllScreenDevice) {
            this.a.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            int i8 = displayMetrics.widthPixels;
            int i9 = displayMetrics.heightPixels;
            if (i8 <= i9 || !z) {
                io.dcloud.common.util.AppStatusBarManager appStatusBarManager = this.m;
                if (appStatusBarManager != null && !appStatusBarManager.isFullScreenOrImmersive()) {
                    i9 -= this.f;
                }
                i7 = i9;
                boolean z2 = io.dcloud.common.util.PdrUtil.isNavigationBarExist(this.a) && !this.p;
                int navigationBarHeight = io.dcloud.common.util.PdrUtil.getNavigationBarHeight(this.a);
                if (this.a.getResources().getConfiguration().orientation == 1) {
                    if (z2) {
                        i7 -= navigationBarHeight;
                    }
                } else if (z2) {
                    i6 = i8 - navigationBarHeight;
                }
                i6 = i8;
            }
        }
        this.e = i7;
        if (i == 2) {
            if (this.q) {
                android.view.View viewFindViewById3 = this.a.findViewById(android.R.id.content);
                this.d = viewFindViewById3.getMeasuredWidth();
                this.h = viewFindViewById3.getMeasuredHeight();
            } else {
                this.d = i6;
                this.h = i7;
            }
        } else if (i == 1) {
            this.d = i6;
            if (zIsAllScreenDevice) {
                this.h = i7;
            } else {
                this.h = i7 - (this.m.isFullScreenOrImmersive() ? 0 : this.f);
            }
        } else {
            io.dcloud.common.DHInterface.IWebAppRootView iWebAppRootView = this.b;
            if (iWebAppRootView != null) {
                this.d = iWebAppRootView.obtainMainView().getWidth();
                this.h = this.b.obtainMainView().getHeight();
            } else {
                this.d = i6;
                this.h = i7;
            }
        }
        int i10 = this.e;
        int i11 = this.h;
        if (i10 < i11) {
            this.e = i11;
        }
        this.l.onScreenChanged(this.d, i11);
    }

    public void a(int i) {
        if (android.os.Build.VERSION.SDK_INT >= 36 && io.dcloud.common.adapter.util.AndroidResources.sAppTargetSdkVersion >= 36) {
            try {
                if (this.r == null) {
                    this.r = new android.widget.RelativeLayout(this.a);
                }
                android.widget.RelativeLayout relativeLayout = this.r;
                if (relativeLayout != null) {
                    relativeLayout.setBackgroundColor(i);
                    return;
                }
                return;
            } catch (java.lang.Throwable unused) {
                return;
            }
        }
        this.a.getWindow().setNavigationBarColor(i);
    }

    @Override // io.dcloud.common.DHInterface.IAppInfo
    public void setRequestedOrientation(int i) {
        this.a.setRequestedOrientation(i);
    }
}
