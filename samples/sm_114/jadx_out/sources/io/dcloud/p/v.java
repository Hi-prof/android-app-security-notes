package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class v extends io.dcloud.p.k4 {
    private boolean E;
    private int F;
    private java.lang.String G;
    private boolean H;
    io.dcloud.p.j4 I;
    private java.lang.String J;
    private java.lang.String K;
    private boolean L;
    private boolean M;
    io.dcloud.feature.gg.dcloud.GGSplashView N;
    long O;
    private long P;
    io.dcloud.sdk.core.v3.inters.DCIntAOL Q;
    private boolean R;
    private boolean S;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener {
        b() {
        }

        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
        public void onClick() {
        }

        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
        public void onClose() {
            io.dcloud.p.v.this.u();
        }

        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
        public void onPaidGet(long j, java.lang.String str, int i) {
        }

        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
        public void onShow() {
        }

        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
        public void onShowError(int i, java.lang.String str) {
            io.dcloud.p.v.this.u();
        }

        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
        public void onSkip() {
            io.dcloud.p.v.this.u();
        }

        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
        public void onVideoPlayEnd() {
            io.dcloud.p.v.this.u();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements io.dcloud.sdk.core.v3.inters.DCIntAOLListener {
        c() {
        }

        @Override // io.dcloud.sdk.core.v3.inters.DCIntAOLListener
        public void onClick() {
        }

        @Override // io.dcloud.sdk.core.v3.inters.DCIntAOLListener
        public void onClose() {
            io.dcloud.feature.gg.AolSplashUtil.setShowInterstitialAd(false);
        }

        @Override // io.dcloud.sdk.core.v3.inters.DCIntAOLListener
        public void onShow() {
            io.dcloud.feature.gg.AolSplashUtil.setShowInterstitialAd(true);
        }

        @Override // io.dcloud.sdk.core.v3.inters.DCIntAOLListener
        public void onShowError(int i, java.lang.String str) {
            io.dcloud.feature.gg.AolSplashUtil.setShowInterstitialAd(false);
        }

        @Override // io.dcloud.sdk.core.v3.inters.DCIntAOLListener
        public void onSkip() {
        }

        @Override // io.dcloud.sdk.core.v3.inters.DCIntAOLListener
        public void onVideoPlayEnd() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements io.dcloud.sdk.core.v3.inters.DCIntAOLLoadListener {
        d() {
        }

        @Override // io.dcloud.sdk.core.v3.base.DCBaseAOLLoadListener
        public void onError(int i, java.lang.String str, org.json.JSONArray jSONArray) {
            io.dcloud.p.v.this.R = true;
        }

        @Override // io.dcloud.sdk.core.v3.inters.DCIntAOLLoadListener
        public void onInterstitialAOLLoad() {
            io.dcloud.p.v.this.R = true;
            if (!io.dcloud.p.v.this.S || io.dcloud.p.v.this.P <= 0 || io.dcloud.p.v.this.P <= android.os.SystemClock.elapsedRealtime()) {
                return;
            }
            io.dcloud.p.v vVar = io.dcloud.p.v.this;
            vVar.Q.show(vVar.a());
        }
    }

    public v(android.app.Activity activity) {
        super(activity, 1);
        this.E = false;
        this.F = 0;
        this.G = "";
        this.H = false;
        this.J = "";
        this.K = "";
        this.L = false;
        this.M = false;
        this.O = 0L;
        this.P = 0L;
        this.R = false;
        this.S = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        io.dcloud.feature.gg.dcloud.GGSplashView gGSplashView = this.N;
        if (gGSplashView != null) {
            gGSplashView.onFinishShow();
        }
    }

    public void v() {
        this.R = false;
        if (android.text.TextUtils.isEmpty(this.G) || io.dcloud.feature.gg.AolSplashUtil.isShowingInterstitialAd()) {
            return;
        }
        io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlotBuild = new io.dcloud.sdk.core.entry.DCloudAOLSlot.Builder().adpid(this.G).build();
        io.dcloud.sdk.core.v3.inters.DCIntAOL dCIntAOL = new io.dcloud.sdk.core.v3.inters.DCIntAOL(a());
        this.Q = dCIntAOL;
        dCIntAOL.setInterstitialAOLListener(new io.dcloud.p.v.c());
        this.Q.load(dCloudAOLSlotBuild, new io.dcloud.p.v.d());
    }

    public void w() {
        if (this.R) {
            io.dcloud.sdk.core.v3.inters.DCIntAOL dCIntAOL = this.Q;
            if (dCIntAOL == null || !dCIntAOL.isValid()) {
                return;
            }
            this.Q.show(a());
            return;
        }
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        int i = this.F;
        if (i <= 0) {
            i = 2500;
        }
        this.P = jElapsedRealtime + ((long) i);
        this.S = true;
    }

    @Override // io.dcloud.p.k4
    protected void b(final android.widget.RelativeLayout relativeLayout, final android.widget.FrameLayout.LayoutParams layoutParams) {
        io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.v$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(relativeLayout, layoutParams);
            }
        });
    }

    @Override // io.dcloud.p.y4, io.dcloud.p.b5, io.dcloud.p.x
    protected void c(java.util.List list) {
        super.c(list);
    }

    @Override // io.dcloud.p.k4, io.dcloud.p.i4
    protected int c() {
        if (this.L) {
            return 3;
        }
        return super.c();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends io.dcloud.p.k4.b {
        final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z) {
            super();
            this.d = z;
        }

        @Override // io.dcloud.p.k4.b, io.dcloud.p.c0.d
        public void a(org.json.JSONArray jSONArray) {
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optString("action", "").equals("redPackage")) {
                    io.dcloud.p.v.this.b(jSONObjectOptJSONObject);
                }
            }
        }

        @Override // io.dcloud.p.k4.b, io.dcloud.p.c0.d, io.dcloud.p.c0.c
        public void a(org.json.JSONObject jSONObject) {
            if (jSONObject == null || jSONObject.length() == 0) {
                io.dcloud.p.v.this.a(-5001, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5001));
                return;
            }
            io.dcloud.sdk.core.entry.SplashAOLConfig splashAOLConfigT = io.dcloud.p.v.this.t();
            io.dcloud.p.j4 j4Var = io.dcloud.p.v.this.I;
            if (j4Var != null) {
                try {
                    j4Var.a(jSONObject);
                    splashAOLConfigT = io.dcloud.p.v.this.I.b();
                    if (!io.dcloud.p.v.this.I.a()) {
                        super.a(-5000, "");
                        return;
                    }
                } catch (java.lang.Exception unused) {
                }
                if (!io.dcloud.p.n.d(io.dcloud.p.v.this.a())) {
                    super.a(-5000, "");
                    return;
                }
            }
            if (splashAOLConfigT != null) {
                io.dcloud.p.v.this.a(new io.dcloud.sdk.core.entry.DCloudAOLSlot.Builder().height(splashAOLConfigT.getHeight()).width(splashAOLConfigT.getWidth()).build());
            }
            if (this.d && io.dcloud.p.e.b().c().contains(io.dcloud.sdk.core.util.Const.TYPE_HW)) {
                org.json.JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("cfgs");
                java.util.ArrayList arrayList = new java.util.ArrayList();
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    int i = 0;
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        org.json.JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optString(com.facebook.common.callercontext.ContextChain.TAG_PRODUCT).equals(io.dcloud.sdk.core.util.Const.TYPE_HW)) {
                            arrayList.add(java.lang.Integer.valueOf(i2));
                        }
                    }
                    if (arrayList.size() > 0) {
                        int size = arrayList.size();
                        while (i < size) {
                            java.lang.Object obj = arrayList.get(i);
                            i++;
                            jSONArrayOptJSONArray.remove(((java.lang.Integer) obj).intValue());
                        }
                        try {
                            jSONObject.put("cfgs", jSONArrayOptJSONArray);
                        } catch (org.json.JSONException unused2) {
                        }
                    }
                }
            }
            super.a(jSONObject);
        }

        @Override // io.dcloud.p.k4.b, io.dcloud.p.c0.d, io.dcloud.p.c0.c
        public void a(int i, java.lang.String str) {
            super.a(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(android.widget.RelativeLayout relativeLayout, android.widget.FrameLayout.LayoutParams layoutParams) {
        io.dcloud.p.w2 w2Var = this.s;
        if (w2Var instanceof io.dcloud.p.j4) {
            ((io.dcloud.p.j4) w2Var).redBag(relativeLayout, layoutParams);
        }
    }

    @Override // io.dcloud.p.y4, io.dcloud.p.b5, io.dcloud.p.x
    protected void a(int i, java.lang.String str, org.json.JSONArray jSONArray) {
        super.a(i, str, jSONArray);
    }

    public void a(io.dcloud.sdk.core.entry.SplashAOLConfig splashAOLConfig, io.dcloud.sdk.core.v3.sp.DCSplashAOLLoadListener dCSplashAOLLoadListener, boolean z) {
        this.N = null;
        this.L = z;
        a(new io.dcloud.p.v.a(z));
        a(dCSplashAOLLoadListener, z);
        this.O = android.os.SystemClock.elapsedRealtime();
        this.E = false;
        this.M = false;
        super.a(splashAOLConfig, this.I);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class e implements io.dcloud.p.j4 {
        final /* synthetic */ io.dcloud.sdk.core.v3.sp.DCSplashAOLLoadListener a;
        final /* synthetic */ boolean b;

        e(io.dcloud.sdk.core.v3.sp.DCSplashAOLLoadListener dCSplashAOLLoadListener, boolean z) {
            this.a = dCSplashAOLLoadListener;
            this.b = z;
        }

        @Override // io.dcloud.p.j4
        public void a(org.json.JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    io.dcloud.p.v.this.H = jSONObject.optInt("fs", 0) == 1;
                    io.dcloud.p.v.this.J = jSONObject.optString("fr");
                    io.dcloud.p.v.this.K = jSONObject.optString("frt");
                    if (jSONObject.has("cpadpid")) {
                        io.dcloud.p.v.this.G = jSONObject.optString("cpadpid");
                        io.dcloud.p.v.this.F = jSONObject.optInt("fwt");
                        io.dcloud.p.v vVar = io.dcloud.p.v.this;
                        vVar.F = vVar.F <= 0 ? 2500 : io.dcloud.p.v.this.F;
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // io.dcloud.p.j4
        public io.dcloud.sdk.core.entry.SplashAOLConfig b() {
            return new io.dcloud.sdk.core.entry.SplashAOLConfig.Builder().width(a((android.content.Context) io.dcloud.p.v.this.c)).height(io.dcloud.p.v.this.H ? a(io.dcloud.p.v.this.c) : (a(io.dcloud.p.v.this.c) / 20) * 17).build();
        }

        @Override // io.dcloud.p.w2
        public void onError(int i, java.lang.String str, org.json.JSONArray jSONArray) {
            io.dcloud.p.v.this.E = true;
            io.dcloud.p.v.this.M = false;
            io.dcloud.p.v.this.a(false);
            io.dcloud.sdk.core.v3.sp.DCSplashAOLLoadListener dCSplashAOLLoadListener = this.a;
            if (dCSplashAOLLoadListener != null) {
                dCSplashAOLLoadListener.onError(i, str, jSONArray);
            }
        }

        @Override // io.dcloud.p.w2
        public void onLoaded() {
            io.dcloud.p.v.this.E = true;
            io.dcloud.p.v.this.M = true;
            io.dcloud.p.v.this.a(false);
            io.dcloud.sdk.core.v3.sp.DCSplashAOLLoadListener dCSplashAOLLoadListener = this.a;
            if (dCSplashAOLLoadListener != null) {
                dCSplashAOLLoadListener.onSplashAOLLoad();
            }
        }

        @Override // io.dcloud.p.j4
        public void redBag(android.view.View view, android.widget.FrameLayout.LayoutParams layoutParams) {
            io.dcloud.sdk.core.v3.sp.DCSplashAOLLoadListener dCSplashAOLLoadListener = this.a;
            if (dCSplashAOLLoadListener != null) {
                dCSplashAOLLoadListener.redBag(view, layoutParams);
            }
        }

        private int a(android.app.Activity activity) {
            android.view.Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            int i = displayMetrics.heightPixels;
            return (io.dcloud.common.util.PdrUtil.hasNavBar(activity) && io.dcloud.common.util.PdrUtil.isNavigationBarShowing(activity)) ? i - io.dcloud.common.util.PdrUtil.getNavigationBarHeight(activity) : i;
        }

        private int a(android.content.Context context) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }

        @Override // io.dcloud.p.j4
        public boolean a() {
            if (!io.dcloud.feature.gg.dcloud.ADHandler.SplashAdIsEnable(io.dcloud.p.v.this.a()).booleanValue()) {
                return false;
            }
            boolean z = this.b;
            if (z) {
                return z && "1".equals(io.dcloud.p.v.this.J);
            }
            return true;
        }
    }

    @Override // io.dcloud.p.k4
    public void a(android.view.ViewGroup viewGroup) {
        a(new io.dcloud.p.v.b());
        super.a(viewGroup);
    }

    public void a(android.view.View view) {
        io.dcloud.feature.gg.dcloud.GGSplashView gGSplashView;
        if ((this.t == null || !io.dcloud.p.e.b().c(this.t.getType()).equals(io.dcloud.sdk.core.util.Const.PROVIDER_TYPE_GLOBAL)) && (gGSplashView = this.N) != null) {
            gGSplashView.onWillCloseSplash();
        }
    }

    public android.view.View a(android.app.Activity activity, java.lang.String str, io.dcloud.common.DHInterface.ICallBack iCallBack) {
        if (!this.E || !this.M) {
            return null;
        }
        if (this.N == null) {
            io.dcloud.feature.gg.dcloud.GGSplashView gGSplashView = new io.dcloud.feature.gg.dcloud.GGSplashView(activity);
            this.N = gGSplashView;
            gGSplashView.showAd(this);
        }
        if (this.H) {
            this.N.getBottomIcon().setVisibility(8);
        }
        this.N.setPullTime(this.O);
        this.N.setAppid(str);
        this.N.setCallBack(iCallBack);
        return this.N;
    }

    public void a(final android.app.Activity activity, java.lang.String str, final android.view.ViewGroup viewGroup) {
        v();
        if (this.E && this.M) {
            a(activity, str, new io.dcloud.common.DHInterface.ICallBack() { // from class: io.dcloud.p.v$$ExternalSyntheticLambda1
                @Override // io.dcloud.common.DHInterface.ICallBack
                public final java.lang.Object onCallBack(int i, java.lang.Object obj) {
                    return this.f$0.a(viewGroup, activity, i, obj);
                }
            });
            viewGroup.addView(this.N);
            if (io.dcloud.common.util.BaseInfo.sGlobalFullScreen) {
                return;
            }
            android.view.Window window = activity.getWindow();
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags |= 1024;
            if (io.dcloud.feature.ui.navigator.QueryNotchTool.hasNotchInScreen(activity) && android.os.Build.VERSION.SDK_INT >= 28) {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            window.setAttributes(attributes);
            return;
        }
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object a(android.view.ViewGroup viewGroup, android.app.Activity activity, int i, java.lang.Object obj) {
        viewGroup.removeView(this.N);
        if (!io.dcloud.common.util.BaseInfo.sGlobalFullScreen) {
            android.view.Window window = activity.getWindow();
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags &= -1025;
            if (io.dcloud.feature.ui.navigator.QueryNotchTool.hasNotchInScreen(activity) && android.os.Build.VERSION.SDK_INT >= 28) {
                attributes.layoutInDisplayCutoutMode = 0;
            }
            window.setAttributes(attributes);
        }
        w();
        return null;
    }

    public boolean a(long j) {
        long j2;
        try {
            j2 = java.lang.Long.parseLong(this.K);
        } catch (java.lang.Exception unused) {
            j2 = 0;
        }
        if (j2 <= 0) {
            j2 = 180000;
        }
        return j + j2 < android.os.SystemClock.elapsedRealtime() && ("1".equals(this.J) || !android.text.TextUtils.isEmpty(this.G));
    }

    private void a(io.dcloud.sdk.core.v3.sp.DCSplashAOLLoadListener dCSplashAOLLoadListener, boolean z) {
        this.I = new io.dcloud.p.v.e(dCSplashAOLLoadListener, z);
    }
}
