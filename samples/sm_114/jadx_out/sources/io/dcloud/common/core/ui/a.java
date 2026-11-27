package io.dcloud.common.core.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class a extends io.dcloud.common.adapter.ui.AdaContainerFrameItem implements io.dcloud.common.DHInterface.ISysEventListener, io.dcloud.common.DHInterface.IWebAppRootView {
    protected java.lang.String A;
    private io.dcloud.common.adapter.ui.DHImageView B;
    io.dcloud.common.DHInterface.ICallBack a;
    private java.util.Stack b;
    private java.util.ArrayList c;
    io.dcloud.common.core.ui.b d;
    io.dcloud.common.core.ui.b e;
    io.dcloud.common.core.ui.b f;
    io.dcloud.common.core.ui.b g;
    boolean h;
    java.lang.String i;
    io.dcloud.common.DHInterface.IApp j;
    public boolean k;
    private final int l;
    io.dcloud.common.DHInterface.IActivityHandler m;
    io.dcloud.common.core.ui.a.k n;
    io.dcloud.common.DHInterface.ICallBack o;
    long p;
    boolean q;
    boolean r;
    private boolean s;
    int t;
    private boolean u;
    private java.util.ArrayList v;
    private io.dcloud.common.core.ui.a.m w;
    private io.dcloud.common.core.ui.a.n x;
    protected byte y;
    protected java.lang.String z;

    /* JADX INFO: renamed from: io.dcloud.common.core.ui.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static /* synthetic */ class C0034a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.values().length];
            a = iArr;
            try {
                iArr[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onPause.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onResume.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onSimStateChanged.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onDeviceNetChanged.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onNewIntent.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onConfigurationChanged.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyboardShow.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                a[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyboardHide.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                a[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppBackground.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                a[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppForeground.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                a[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppTrimMemory.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                a[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onSplashclosed.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements io.dcloud.common.DHInterface.ICallBack {
        b() {
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            io.dcloud.common.core.ui.b bVarH;
            java.lang.String strValueOf = java.lang.String.valueOf(obj);
            if (android.text.TextUtils.isEmpty(strValueOf) || !strValueOf.equals("com.huawei.intent.action.CLICK_STATUSBAR") || io.dcloud.common.core.ui.a.this.obtainMainView().getParent() == null || (bVarH = io.dcloud.common.core.ui.a.this.h()) == null) {
                return null;
            }
            bVarH.b();
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements io.dcloud.common.adapter.util.MessageHandler.IMessages {
        final /* synthetic */ io.dcloud.common.core.ui.b a;

        c(io.dcloud.common.core.ui.b bVar) {
            this.a = bVar;
        }

        @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
        public void execute(java.lang.Object obj) {
            if (io.dcloud.common.core.ui.a.this.b == null || this.a == null) {
                return;
            }
            io.dcloud.common.adapter.util.Logger.d("DHAppRootView.popFrameView frame" + this.a);
            io.dcloud.common.core.ui.a.this.b.remove(this.a);
            io.dcloud.common.core.ui.a.this.a(this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements io.dcloud.common.adapter.util.MessageHandler.IMessages {
        final /* synthetic */ java.util.ArrayList a;

        d(java.util.ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
        public void execute(java.lang.Object obj) {
            try {
                if (io.dcloud.common.core.ui.a.this.b != null) {
                    for (int size = io.dcloud.common.core.ui.a.this.b.size() - 1; size >= 0; size--) {
                        io.dcloud.common.core.ui.b bVar = (io.dcloud.common.core.ui.b) io.dcloud.common.core.ui.a.this.b.get(size);
                        if (!this.a.contains(bVar)) {
                            io.dcloud.common.core.ui.l lVar = bVar.mWindowMgr;
                            if (lVar != null) {
                                lVar.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 22, bVar);
                            }
                            bVar.h = true;
                        }
                    }
                }
            } catch (java.lang.Exception e) {
                io.dcloud.common.adapter.util.Logger.w("DHAppRootView onConfigurationChanged", e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class e implements java.lang.Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.common.DHInterface.IActivityHandler iActivityHandler = io.dcloud.common.core.ui.a.this.m;
            if (iActivityHandler != null) {
                iActivityHandler.showSplashWaiting();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class f implements io.dcloud.common.adapter.util.MessageHandler.IMessages {
        final /* synthetic */ boolean a;
        final /* synthetic */ io.dcloud.common.core.ui.a b;
        final /* synthetic */ int c;

        f(boolean z, io.dcloud.common.core.ui.a aVar, int i) {
            this.a = z;
            this.b = aVar;
            this.c = i;
        }

        @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
        public void execute(java.lang.Object obj) {
            io.dcloud.common.adapter.util.Logger.d("approotview", "closeSplashScreen1;autoClose=" + this.a + ";mAppid" + io.dcloud.common.core.ui.a.this.i);
            io.dcloud.common.core.ui.a.this.a(this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class g implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.common.core.ui.a a;
        final /* synthetic */ int b;

        g(io.dcloud.common.core.ui.a aVar, int i) {
            this.a = aVar;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.common.core.ui.a.this.s = false;
            io.dcloud.common.core.ui.a.this.a(this.a, this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class h implements io.dcloud.common.DHInterface.ICallBack {
        h() {
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            io.dcloud.common.DHInterface.IApp iApp;
            io.dcloud.common.core.ui.a.this.j.onSplashClosed();
            io.dcloud.common.core.ui.a aVar = io.dcloud.common.core.ui.a.this;
            if (!aVar.q || (iApp = aVar.j) == null) {
                aVar.r = true;
                return null;
            }
            iApp.callSysEventListener(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onSplashclosed, this);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class i implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        i() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            android.view.View viewObtainMainView = io.dcloud.common.core.ui.a.this.obtainMainView();
            io.dcloud.common.core.ui.a.this.onRootViewGlobalLayout(viewObtainMainView);
            if (viewObtainMainView == null || io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer < 16 || viewObtainMainView.getViewTreeObserver() == null) {
                return;
            }
            viewObtainMainView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            viewObtainMainView.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class j implements io.dcloud.common.adapter.util.MessageHandler.IMessages {
        j() {
        }

        @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
        public void execute(java.lang.Object obj) {
            java.util.ArrayList arrayList = io.dcloud.common.core.ui.a.this.v;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                java.lang.Object obj2 = arrayList.get(i);
                i++;
                ((io.dcloud.common.DHInterface.ICallBack) obj2).onCallBack(-1, null);
            }
            io.dcloud.common.core.ui.a.this.v.clear();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class l extends io.dcloud.common.core.ui.k {
        android.graphics.Paint t;
        int u;
        int v;
        int w;
        int x;
        java.lang.String y;
        io.dcloud.common.core.ui.a.l.c z;

        /* JADX INFO: renamed from: io.dcloud.common.core.ui.a$l$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class C0035a implements io.dcloud.common.DHInterface.ICallBack {
            C0035a() {
            }

            @Override // io.dcloud.common.DHInterface.ICallBack
            public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                io.dcloud.common.core.ui.a.l.this.l.b();
                io.dcloud.common.core.ui.a.this.a = null;
                return null;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class b implements java.lang.Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (io.dcloud.common.core.ui.a.this.c != null) {
                    java.util.ArrayList arrayList = io.dcloud.common.core.ui.a.this.c;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        java.lang.Object obj = arrayList.get(i);
                        i++;
                        io.dcloud.common.core.ui.b bVar = (io.dcloud.common.core.ui.b) obj;
                        if (!bVar.isChildOfFrameView) {
                            bVar.resize();
                        }
                    }
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class c implements java.lang.Runnable {
            int a = 0;
            boolean b = false;

            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!this.b) {
                    this.a = 0;
                    return;
                }
                this.a++;
                io.dcloud.common.core.ui.a.l.this.invalidate();
                this.a %= 4;
                io.dcloud.common.core.ui.a.l.this.postDelayed(this, 500L);
            }
        }

        public l(android.content.Context context, io.dcloud.common.core.ui.a aVar) {
            super(context, aVar);
            this.t = new android.graphics.Paint();
            this.y = "";
            this.z = new io.dcloud.common.core.ui.a.l.c();
            int i = (int) (((double) (io.dcloud.common.adapter.util.DeviceInfo.DEFAULT_FONT_SIZE * io.dcloud.common.adapter.util.DeviceInfo.sDensity)) * 1.2d);
            this.t.setColor(-13421773);
            this.t.setTextSize(i);
            setTag("AppRootView");
            java.lang.String string = context.getString(io.dcloud.base.R.string.dcloud_common_in_the_buffer);
            this.y = string;
            this.u = (int) this.t.measureText(string);
            this.v = (int) this.t.measureText("...");
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchConfigurationChanged(android.content.res.Configuration configuration) {
            super.dispatchConfigurationChanged(configuration);
            if (!io.dcloud.common.util.BaseInfo.sDoingAnimation) {
                this.l.b();
            } else {
                io.dcloud.common.core.ui.a.this.a = new io.dcloud.common.core.ui.a.l.C0035a();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(android.graphics.Canvas canvas) {
            super.dispatchDraw(canvas);
            if (io.dcloud.common.core.ui.a.this.j.getMaskLayerCount() <= 0) {
                this.z.b = false;
                return;
            }
            io.dcloud.common.core.ui.a.l.c cVar = this.z;
            if (!cVar.b) {
                cVar.b = true;
                cVar.run();
            }
            canvas.drawColor(-2013265920);
            canvas.drawText(this.y, this.w, this.x, this.t);
            int i = this.z.a;
            if (i == 1) {
                canvas.drawText(com.taobao.weex.el.parse.Operators.DOT_STR, this.w + this.u, this.x, this.t);
            } else if (i == 2) {
                canvas.drawText(io.dcloud.common.util.PdrUtil.FILE_PATH_ENTRY_BACK, this.w + this.u, this.x, this.t);
            } else if (i == 3) {
                canvas.drawText("...", this.w + this.u, this.x, this.t);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
            if (io.dcloud.common.core.ui.a.this.j.getMaskLayerCount() > 0) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.View
        protected void onConfigurationChanged(android.content.res.Configuration configuration) {
            super.onConfigurationChanged(configuration);
            ((io.dcloud.common.adapter.ui.AdaFrameItem) io.dcloud.common.core.ui.a.this).mViewOptions.onScreenChanged();
            io.dcloud.common.adapter.util.PlatformUtil.RESET_H_W();
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            this.w = ((io.dcloud.common.core.ui.a.this.j.getInt(0) - this.u) - this.v) / 2;
            this.x = (int) (((double) io.dcloud.common.core.ui.a.this.j.getInt(2)) * 0.8d);
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection != null && i2 != 0 && i4 != 0) {
                int i5 = getResources().getDisplayMetrics().heightPixels;
                int i6 = getResources().getDisplayMetrics().heightPixels / 4;
                if (java.lang.Math.abs(i2 - i5) > i6 || java.lang.Math.abs(i2 - i4) > i6) {
                    if (i2 <= i4 || java.lang.Math.abs(i2 - i4) <= i6) {
                        io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection.showRecordView(i2, true);
                    } else {
                        io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection.closeRecordView();
                    }
                }
            }
            io.dcloud.common.core.ui.a.this.j.updateScreenInfo(6);
            io.dcloud.common.core.ui.a.this.j.callSysEventListener(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onSizeChanged, new int[]{i, i2, i3, i4});
            ((io.dcloud.common.adapter.ui.AdaFrameItem) io.dcloud.common.core.ui.a.this).mViewOptions.onScreenChanged(i, i2);
            post(new io.dcloud.common.core.ui.a.l.b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class m implements java.util.Comparator {
        m() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(io.dcloud.common.core.ui.b bVar, io.dcloud.common.core.ui.b bVar2) {
            if (bVar.getFrameType() == 3) {
                return 1;
            }
            if (bVar2.getFrameType() == 3) {
                return -1;
            }
            int i = bVar.mZIndex - bVar2.mZIndex;
            if (i == 0) {
                return bVar.lastShowTime > bVar2.lastShowTime ? 1 : -1;
            }
            return i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class n implements java.util.Comparator {
        n() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem, io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem2) {
            boolean z = adaFrameItem instanceof io.dcloud.common.DHInterface.IFrameView;
            if (z && ((io.dcloud.common.DHInterface.IFrameView) adaFrameItem).getFrameType() == 3) {
                return 1;
            }
            if (z && ((io.dcloud.common.DHInterface.IFrameView) adaFrameItem).getFrameType() == 3) {
                return -1;
            }
            int i = adaFrameItem.mZIndex - adaFrameItem2.mZIndex;
            if (i == 0) {
                return adaFrameItem.lastShowTime > adaFrameItem2.lastShowTime ? 1 : -1;
            }
            return i;
        }
    }

    public a(android.content.Context context, io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.core.ui.b bVar) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = true;
        this.i = null;
        this.j = null;
        this.k = false;
        this.l = 2;
        this.n = new io.dcloud.common.core.ui.a.k();
        this.o = new io.dcloud.common.core.ui.a.b();
        this.p = java.lang.System.currentTimeMillis();
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = 0;
        this.u = true;
        this.v = new java.util.ArrayList();
        this.w = new io.dcloud.common.core.ui.a.m();
        this.x = new io.dcloud.common.core.ui.a.n();
        this.B = null;
        this.q = io.dcloud.common.util.BaseInfo.sRuntimeMode != null;
        this.j = iApp;
        this.m = io.src.dcloud.adapter.DCloudAdapterUtil.getIActivityHandler(iApp.getActivity());
        this.i = iApp.obtainAppId();
        setMainView(new io.dcloud.common.core.ui.a.l(context, this));
        this.b = new java.util.Stack();
        this.c = new java.util.ArrayList();
        iApp.setWebAppRootView(this);
        iApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onPause);
        iApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onResume);
        iApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onDeviceNetChanged);
        iApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onNewIntent);
        iApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onConfigurationChanged);
        iApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onSimStateChanged);
        iApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyboardShow);
        iApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppBackground);
        iApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppForeground);
        iApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyboardHide);
        iApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppTrimMemory);
        iApp.registerSysEventListener(this, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onSplashclosed);
        if (io.dcloud.common.core.permission.PermissionControler.checkPermission(this.i, io.dcloud.common.DHInterface.IFeature.F_DEVICE.toLowerCase(java.util.Locale.ENGLISH))) {
            java.lang.String bundleData = io.dcloud.common.adapter.util.SP.getBundleData(context, io.dcloud.common.util.BaseInfo.PDR, "last_notify_net_type");
            java.lang.String netWorkType = io.dcloud.common.adapter.util.DeviceInfo.getNetWorkType(context);
            if (!io.dcloud.common.util.PdrUtil.isEquals(bundleData, netWorkType)) {
                io.dcloud.common.adapter.util.Logger.d("NetCheckReceiver", "netchange last_net_type:" + bundleData + ";cur_net_type:" + netWorkType);
                io.dcloud.common.adapter.util.SP.setBundleData(context, io.dcloud.common.util.BaseInfo.PDR, "last_notify_net_type", netWorkType);
            }
        }
        this.m.addClickStatusbarCallBack(this.o);
    }

    private void a(android.view.View view) {
    }

    @Override // io.dcloud.common.DHInterface.IWebAppRootView
    public boolean didCloseSplash() {
        return this.q;
    }

    @Override // io.dcloud.common.adapter.ui.AdaContainerFrameItem, io.dcloud.common.adapter.ui.AdaFrameItem
    public synchronized void dispose() {
        a();
        this.b = null;
        this.c = null;
        io.dcloud.common.adapter.ui.DHImageView dHImageView = this.B;
        if (dHImageView != null) {
            dHImageView.setImageBitmap(null);
            this.B = null;
        }
        super.dispose();
        this.m.removeClickStatusbarCallBack(this.o);
        io.dcloud.common.adapter.ui.RecordView recordView = io.dcloud.common.adapter.ui.AdaWebview.mRecordView;
        if (recordView != null) {
            recordView.dispose();
        }
        io.dcloud.common.adapter.ui.AdaWebview.mRecordView = null;
    }

    io.dcloud.common.core.ui.b f() {
        return a(4);
    }

    @Override // io.dcloud.common.DHInterface.IWebAppRootView
    public io.dcloud.common.DHInterface.IFrameView findFrameViewB(io.dcloud.common.DHInterface.IFrameView iFrameView) {
        if (!this.c.contains(iFrameView)) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        a(iFrameView, arrayList);
        a(arrayList);
        if (arrayList.size() <= 1 && arrayList.size() == 1) {
            return (io.dcloud.common.DHInterface.IFrameView) arrayList.get(0);
        }
        return null;
    }

    void g(io.dcloud.common.core.ui.b bVar) {
        io.dcloud.common.adapter.util.MessageHandler.sendMessage(new io.dcloud.common.core.ui.a.c(bVar), null);
    }

    @Override // io.dcloud.common.DHInterface.IWebAppRootView
    public void goHome(io.dcloud.common.DHInterface.IFrameView iFrameView) {
        if (iFrameView instanceof io.dcloud.common.core.ui.b) {
            io.dcloud.common.core.ui.b bVar = (io.dcloud.common.core.ui.b) iFrameView;
            bVar.getAnimOptions().mOption = (byte) 1;
            bVar.getAnimOptions().mAnimType = "none";
            bVar.mWindowMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 2, iFrameView);
        }
    }

    public io.dcloud.common.core.ui.b h() {
        java.util.Stack stack = this.b;
        io.dcloud.common.core.ui.b bVar = null;
        if (stack != null && !stack.isEmpty()) {
            for (int size = this.b.size() - 1; size >= 0; size--) {
                bVar = (io.dcloud.common.core.ui.b) this.b.get(size);
                if (bVar.obtainMainView().getVisibility() == 0 && !bVar.isChildOfFrameView) {
                    return bVar;
                }
            }
        }
        return bVar;
    }

    void i() {
        java.util.Stack stack = this.b;
        if (stack == null || stack.isEmpty()) {
            return;
        }
        java.lang.Boolean bool = java.lang.Boolean.FALSE;
        for (int size = this.b.size() - 1; size >= 0; size--) {
            io.dcloud.common.core.ui.b bVar = (io.dcloud.common.core.ui.b) this.b.get(size);
            android.view.View viewObtainMainView = bVar.obtainMainView();
            if (!bVar.isChildOfFrameView) {
                if (bool.booleanValue() || viewObtainMainView.getVisibility() != 0) {
                    viewObtainMainView.setImportantForAccessibility(4);
                } else {
                    viewObtainMainView.setImportantForAccessibility(0);
                    bool = java.lang.Boolean.TRUE;
                }
            }
        }
    }

    public void j() {
        if (obtainMainView() instanceof io.dcloud.common.core.ui.k) {
            ((io.dcloud.common.core.ui.k) obtainMainView()).c();
        }
    }

    void k() {
        java.util.Collections.sort(this.c, this.w);
    }

    void l() {
        java.util.Collections.sort(this.b, this.w);
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((io.dcloud.common.core.ui.b) this.b.get(i2)).obtainMainView().bringToFront();
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebAppRootView
    public void onAppActive(io.dcloud.common.DHInterface.IApp iApp) {
        b(iApp);
        io.dcloud.common.util.BaseInfo.sCurrentAppOriginalAppid = iApp.obtainOriginalAppId();
        iApp.getActivity();
        if (this.m != null) {
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            if (iApp.obtainStatusBarMgr().isTemporaryFullScreen && !iApp.obtainStatusBarMgr().isImmersive && !iApp.isFullScreen() && !this.q) {
                layoutParams.topMargin = io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
            }
            this.m.setViewAsContentView(obtainMainView(), layoutParams);
        }
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.MAIN_TAG, iApp.obtainAppId() + " onAppActive setContentView");
        a(obtainMainView());
        io.dcloud.common.DHInterface.FeatureMessageDispatcher.dispatchMessage("app_open", 1);
    }

    @Override // io.dcloud.common.DHInterface.IWebAppRootView
    public void onAppStart(io.dcloud.common.DHInterface.IApp iApp) {
        this.q = false;
        this.r = false;
        if (iApp != null) {
            a(iApp);
        }
        obtainMainView().getViewTreeObserver().addOnGlobalLayoutListener(new io.dcloud.common.core.ui.a.i());
        obtainMainView().setBackgroundColor(-1);
        onAppActive(iApp);
    }

    @Override // io.dcloud.common.DHInterface.IWebAppRootView
    public void onAppStop(io.dcloud.common.DHInterface.IApp iApp) {
        onAppUnActive(iApp);
    }

    @Override // io.dcloud.common.DHInterface.IWebAppRootView
    public void onAppUnActive(io.dcloud.common.DHInterface.IApp iApp) {
    }

    @Override // io.dcloud.common.DHInterface.IWebAppRootView
    public void onRootViewGlobalLayout(android.view.View view) {
        if (isDisposed()) {
            return;
        }
        if (io.dcloud.common.adapter.ui.AdaWebview.ScreemOrientationChangedNeedLayout) {
            io.dcloud.common.adapter.ui.AdaWebview.ScreemOrientationChangedNeedLayout = false;
            this.j.updateScreenInfo(3);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (java.lang.Math.abs(width - this.j.getInt(0)) > 100) {
            return;
        }
        int i2 = height - this.j.getInt(1);
        if (!this.j.isVerticalScreen()) {
            i2 = width - this.j.getInt(0);
        }
        if (i2 != 0) {
            this.j.updateScreenInfo(3);
        }
        if (view.getHeight() != this.t && view.getHeight() == this.j.getInt(1)) {
            io.dcloud.common.adapter.util.PlatformUtil.RESET_H_W();
            if (!this.u) {
                io.dcloud.common.util.BaseInfo.sFullScreenChanged = true;
            }
            this.u = false;
        }
        this.t = view.getHeight();
    }

    void reload(boolean z) {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView = ((io.dcloud.common.core.ui.b) this.c.get(size)).obtainWebView();
            if (iWebviewObtainWebView != null) {
                iWebviewObtainWebView.reload();
            }
            if (!z) {
                return;
            }
        }
    }

    public void b() {
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, "AppRootView dispatchConfigurationChanged(横竖屏切换、全屏非全屏切换、虚拟返回键栏隐藏显示) 引发调整栈窗口");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        a(arrayList2, arrayList);
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            java.lang.Object obj = arrayList2.get(i2);
            i2++;
            io.dcloud.common.core.ui.b bVar = (io.dcloud.common.core.ui.b) obj;
            boolean zContains = this.b.contains(bVar);
            io.dcloud.common.core.ui.l lVar = bVar.mWindowMgr;
            if (lVar != null) {
                lVar.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 8, bVar);
            }
            bVar.i = !zContains;
        }
        io.dcloud.common.adapter.util.MessageHandler.sendMessage(new io.dcloud.common.core.ui.a.d(arrayList2), null);
    }

    int c(io.dcloud.common.core.ui.b bVar) {
        return this.b.indexOf(bVar);
    }

    java.util.Stack d() {
        return this.b;
    }

    int e(io.dcloud.common.core.ui.b bVar) {
        int i2;
        int i3;
        int i4;
        int iIndexOf = this.c.indexOf(bVar);
        int size = this.b.size() - 1;
        while (true) {
            if (size < 0) {
                i3 = 0;
                break;
            }
            io.dcloud.common.core.ui.b bVar2 = (io.dcloud.common.core.ui.b) this.b.get(size);
            int iIndexOf2 = this.c.indexOf(bVar2);
            if (iIndexOf2 >= 0 && iIndexOf > iIndexOf2 && bVar2.getFrameType() != 3 && !bVar2.isTabItem()) {
                i3 = size + 1;
                break;
            }
            size--;
        }
        if (i3 != 0) {
            android.view.ViewGroup viewGroupObtainMainViewGroup = obtainMainViewGroup();
            int childCount = viewGroupObtainMainViewGroup.getChildCount();
            i4 = i3;
            int i5 = 0;
            for (i2 = 0; i2 < childCount; i2++) {
                android.view.View childAt = viewGroupObtainMainViewGroup.getChildAt(i2);
                if ((childAt instanceof com.dcloud.android.widget.AbsoluteLayout) || (childAt instanceof io.dcloud.p.t4)) {
                    i5++;
                } else {
                    i4++;
                }
                if (i5 >= i3) {
                    break;
                }
            }
        } else {
            i4 = i3;
        }
        a(bVar, i3, i4);
        if (io.dcloud.common.util.BaseInfo.isUniAppAppid(bVar.obtainApp())) {
            if (bVar.obtainWebView() != null) {
                bVar.obtainWebView().setIWebViewFocusable(true);
            }
            bVar.changeWebParentViewRect();
        }
        return i3;
    }

    public void f(io.dcloud.common.core.ui.b bVar) {
        io.dcloud.common.adapter.util.AnimOptions animOptions = bVar.getAnimOptions();
        animOptions.mOption = this.y;
        animOptions.mAnimType = this.z;
        animOptions.mAnimType_close = this.A;
    }

    public void g() {
        if (!io.dcloud.common.adapter.util.AndroidResources.sIMEAlive || this.v.size() <= 0) {
            return;
        }
        io.dcloud.common.adapter.util.MessageHandler.sendMessage(new io.dcloud.common.core.ui.a.j(), io.dcloud.common.util.BaseInfo.isUniAppAppid(this.j) ? 50 : 500, null);
    }

    java.util.ArrayList c() {
        return this.c;
    }

    boolean d(io.dcloud.common.core.ui.b bVar) {
        java.util.ArrayList arrayList = this.c;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            java.lang.Object obj = arrayList.get(i2);
            i2++;
            io.dcloud.common.core.ui.b bVar2 = (io.dcloud.common.core.ui.b) obj;
            if (bVar != bVar2 && !bVar2.isChildOfFrameView && bVar2.obtainMainView().getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:59:0x039f  */
    /* JADX WARN: Code duplicated, block: B:63:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:65:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:67:0x03c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:69:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:74:0x03cb A[SYNTHETIC] */
    @Override // io.dcloud.common.DHInterface.ISysEventListener
    public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
        int size;
        io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView;
        io.dcloud.common.adapter.ui.CustomeizedInputConnection customeizedInputConnection;
        java.lang.String bundleData;
        io.dcloud.common.adapter.util.EventActionInfo eventActionInfo;
        java.lang.String str = "";
        io.dcloud.common.adapter.util.EventActionInfo eventActionInfo2 = null;
        java.lang.String str2 = null;
        eventActionInfo2 = null;
        switch (io.dcloud.common.core.ui.a.C0034a.a[sysEventType.ordinal()]) {
            case 1:
                io.dcloud.common.util.AppStatus.setAppStatus(this.i, 2);
                str = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.EVENTS_DOCUMENT_EXECUTE_TEMPLATE, "pause");
                eventActionInfo2 = new io.dcloud.common.adapter.util.EventActionInfo("pause");
                if (this.c != null && !android.text.TextUtils.isEmpty(str)) {
                    for (size = this.c.size() - 1; size >= 0; size--) {
                        iWebviewObtainWebView = ((io.dcloud.common.core.ui.b) this.c.get(size)).obtainWebView();
                        if (iWebviewObtainWebView != null) {
                            if (!(iWebviewObtainWebView instanceof io.dcloud.common.adapter.ui.AdaUniWebView) && eventActionInfo2 != null) {
                                ((io.dcloud.common.adapter.ui.AdaUniWebView) iWebviewObtainWebView).fireEvent(eventActionInfo2);
                            } else {
                                iWebviewObtainWebView.loadUrl(str);
                            }
                        }
                    }
                }
                break;
            case 2:
                io.dcloud.common.util.AppStatus.setAppStatus(this.i, 1);
                str = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.EVENTS_DOCUMENT_EXECUTE_TEMPLATE, io.dcloud.common.constant.AbsoluteConst.EVENTS_RESUME);
                if (!io.dcloud.common.adapter.util.AndroidResources.sIMEAlive && (customeizedInputConnection = io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection) != null) {
                    customeizedInputConnection.closeRecordView();
                }
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                calendar.setTime(new java.util.Date(this.p));
                java.util.Calendar calendar2 = java.util.Calendar.getInstance();
                calendar2.setTime(new java.util.Date(java.lang.System.currentTimeMillis()));
                if (calendar.get(5) != calendar2.get(5)) {
                    io.dcloud.common.util.BaseInfo.run5appEndTime = 0L;
                    this.j.setConfigProperty("commit", java.lang.String.valueOf(this.p));
                    this.p = calendar2.getTimeInMillis();
                }
                eventActionInfo2 = new io.dcloud.common.adapter.util.EventActionInfo(io.dcloud.common.constant.AbsoluteConst.EVENTS_RESUME);
                if (this.c != null) {
                    while (size >= 0) {
                        iWebviewObtainWebView = ((io.dcloud.common.core.ui.b) this.c.get(size)).obtainWebView();
                        if (iWebviewObtainWebView != null) {
                            if (!(iWebviewObtainWebView instanceof io.dcloud.common.adapter.ui.AdaUniWebView)) {
                                iWebviewObtainWebView.loadUrl(str);
                            } else {
                                iWebviewObtainWebView.loadUrl(str);
                            }
                        }
                    }
                }
                break;
            case 3:
                if (io.dcloud.common.core.permission.PermissionControler.checkPermission(this.i, io.dcloud.common.DHInterface.IFeature.F_DEVICE.toLowerCase(java.util.Locale.ENGLISH))) {
                    java.lang.String str3 = io.dcloud.common.util.StringUtil.format("plus.device.imsi = ['%s'];", io.dcloud.common.adapter.util.DeviceInfo.getUpdateIMSI());
                    str = (io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT + str3) + io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.EVENTS_DOCUMENT_EXECUTE_TEMPLATE, io.dcloud.common.constant.AbsoluteConst.EVENTS_IMSI_CHANGE);
                    eventActionInfo2 = new io.dcloud.common.adapter.util.EventActionInfo(io.dcloud.common.constant.AbsoluteConst.EVENTS_IMSI_CHANGE, str3);
                }
                if (this.c != null) {
                    while (size >= 0) {
                        iWebviewObtainWebView = ((io.dcloud.common.core.ui.b) this.c.get(size)).obtainWebView();
                        if (iWebviewObtainWebView != null) {
                            if (!(iWebviewObtainWebView instanceof io.dcloud.common.adapter.ui.AdaUniWebView)) {
                                iWebviewObtainWebView.loadUrl(str);
                            } else {
                                iWebviewObtainWebView.loadUrl(str);
                            }
                        }
                    }
                }
                break;
            case 4:
                if (io.dcloud.common.core.permission.PermissionControler.checkPermission(this.i, io.dcloud.common.DHInterface.IFeature.F_DEVICE.toLowerCase(java.util.Locale.ENGLISH))) {
                    java.lang.String bundleData2 = io.dcloud.common.adapter.util.SP.getBundleData(getContext(), io.dcloud.common.util.BaseInfo.PDR, "last_notify_net_type");
                    java.lang.String netWorkType = io.dcloud.common.adapter.util.DeviceInfo.getNetWorkType(getContext());
                    if (!io.dcloud.common.util.PdrUtil.isEquals(bundleData2, netWorkType)) {
                        io.dcloud.common.adapter.util.Logger.d("NetCheckReceiver", "netchange last_net_type:" + bundleData2 + ";cur_net_type:" + netWorkType);
                        io.dcloud.common.adapter.util.SP.setBundleData(getContext(), io.dcloud.common.util.BaseInfo.PDR, "last_notify_net_type", netWorkType);
                        java.lang.String str4 = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.EVENTS_DOCUMENT_EXECUTE_TEMPLATE, io.dcloud.common.constant.AbsoluteConst.EVENTS_NETCHANGE);
                        java.lang.String str5 = io.dcloud.common.util.StringUtil.format("plus.device.imsi = ['%s'];", io.dcloud.common.adapter.util.DeviceInfo.getUpdateIMSI());
                        str = io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT + str5 + str4;
                        eventActionInfo2 = new io.dcloud.common.adapter.util.EventActionInfo(io.dcloud.common.constant.AbsoluteConst.EVENTS_NETCHANGE, str5);
                        if (this.c != null) {
                            while (size >= 0) {
                                iWebviewObtainWebView = ((io.dcloud.common.core.ui.b) this.c.get(size)).obtainWebView();
                                if (iWebviewObtainWebView != null) {
                                    if (!(iWebviewObtainWebView instanceof io.dcloud.common.adapter.ui.AdaUniWebView)) {
                                        iWebviewObtainWebView.loadUrl(str);
                                    } else {
                                        iWebviewObtainWebView.loadUrl(str);
                                    }
                                }
                            }
                        }
                    }
                    break;
                }
                break;
            case 5:
                this.j.setRuntimeArgs(java.lang.String.valueOf(obj));
                java.lang.String strObtainIntentStringExtra = io.dcloud.common.constant.IntentConst.obtainIntentStringExtra(getActivity().getIntent(), io.dcloud.common.constant.IntentConst.UNIMP_RUN_EXTRA_INFO, true);
                if (!io.dcloud.common.util.PdrUtil.isEmpty(strObtainIntentStringExtra)) {
                    this.j.setConfigProperty(io.dcloud.common.constant.IntentConst.UNIMP_RUN_EXTRA_INFO, strObtainIntentStringExtra);
                }
                java.lang.String launchType = io.dcloud.common.util.BaseInfo.getLaunchType(getActivity().getIntent());
                io.dcloud.common.util.BaseInfo.putLauncherData(this.j.obtainAppId(), launchType);
                java.lang.String bundleData3 = io.dcloud.common.adapter.util.SP.getBundleData(getContext(), "pdr", this.j.obtainAppId() + io.dcloud.common.constant.AbsoluteConst.LAUNCHTYPE);
                if (android.text.TextUtils.isEmpty(bundleData3)) {
                    bundleData3 = "default";
                }
                java.lang.String str6 = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_ARGUMENTS, this.j.obtainRuntimeArgs(true));
                java.lang.String str7 = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_LAUNCHER, launchType);
                java.lang.String str8 = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_ORIGIN, bundleData3);
                str = (io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT + io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_BASE, str6) + io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_BASE, str7) + io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_BASE, str8)) + io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.EVENTS_DOCUMENT_EXECUTE_TEMPLATE, io.dcloud.common.constant.AbsoluteConst.EVENTS_NEW_INTENT);
                eventActionInfo2 = new io.dcloud.common.adapter.util.EventActionInfo(io.dcloud.common.constant.AbsoluteConst.EVENTS_NEW_INTENT, io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_V8_BASE + str6 + str7 + str8);
                if (this.c != null) {
                    while (size >= 0) {
                        iWebviewObtainWebView = ((io.dcloud.common.core.ui.b) this.c.get(size)).obtainWebView();
                        if (iWebviewObtainWebView != null) {
                            if (!(iWebviewObtainWebView instanceof io.dcloud.common.adapter.ui.AdaUniWebView)) {
                                iWebviewObtainWebView.loadUrl(str);
                            } else {
                                iWebviewObtainWebView.loadUrl(str);
                            }
                        }
                    }
                }
                break;
            case 6:
                this.j.updateScreenInfo(1);
                if (io.dcloud.feature.internal.sdk.SDK.isUniMP) {
                    bundleData = io.dcloud.feature.internal.sdk.SDK.hostAppThemeDark;
                } else {
                    bundleData = io.dcloud.common.adapter.util.SP.getBundleData(getContext(), io.dcloud.common.adapter.util.SP.DARK_MODE_BUNDLE_FORMAT, io.dcloud.common.adapter.util.SP.DARK_MODE_KEY);
                    if (io.dcloud.common.util.PdrUtil.isEmpty(bundleData)) {
                        bundleData = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_DARK_MODE");
                    }
                }
                if (io.dcloud.common.util.PdrUtil.isEquals("auto", bundleData)) {
                    java.lang.String str9 = io.dcloud.common.adapter.util.DeviceInfo.isSystemNightMode(getContext()).booleanValue() ? io.dcloud.common.ui.blur.DCBlurDraweeView.DARK : io.dcloud.common.ui.blur.DCBlurDraweeView.LIGHT;
                    str = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.EVENTS_DOCUMENT_EXECUTE_TEMPLATE_PARAMETER_OF_UISTYLE, io.dcloud.common.constant.AbsoluteConst.EVENTS_UISTYLECHANGE, str9);
                    java.util.HashMap map = new java.util.HashMap();
                    map.put("uistyle", str9);
                    eventActionInfo2 = new io.dcloud.common.adapter.util.EventActionInfo(io.dcloud.common.constant.AbsoluteConst.EVENTS_UISTYLECHANGE, map);
                    io.dcloud.common.util.AppRuntime.switchAllWebViewDarkMode(c());
                    if (this.c != null) {
                        while (size >= 0) {
                            iWebviewObtainWebView = ((io.dcloud.common.core.ui.b) this.c.get(size)).obtainWebView();
                            if (iWebviewObtainWebView != null) {
                                if (!(iWebviewObtainWebView instanceof io.dcloud.common.adapter.ui.AdaUniWebView)) {
                                    iWebviewObtainWebView.loadUrl(str);
                                } else {
                                    iWebviewObtainWebView.loadUrl(str);
                                }
                            }
                        }
                    }
                }
                break;
            case 7:
                str = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.EVENTS_DOCUMENT_EXECUTE_TEMPLATE, io.dcloud.common.constant.AbsoluteConst.EVENTS_KEYBOARD_SHOW);
                eventActionInfo2 = new io.dcloud.common.adapter.util.EventActionInfo(io.dcloud.common.constant.AbsoluteConst.EVENTS_KEYBOARD_SHOW);
                if (this.c != null) {
                    while (size >= 0) {
                        iWebviewObtainWebView = ((io.dcloud.common.core.ui.b) this.c.get(size)).obtainWebView();
                        if (iWebviewObtainWebView != null) {
                            if (!(iWebviewObtainWebView instanceof io.dcloud.common.adapter.ui.AdaUniWebView)) {
                                iWebviewObtainWebView.loadUrl(str);
                            } else {
                                iWebviewObtainWebView.loadUrl(str);
                            }
                        }
                    }
                }
                break;
            case 8:
                str = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.EVENTS_DOCUMENT_EXECUTE_TEMPLATE, io.dcloud.common.constant.AbsoluteConst.EVENTS_KEYBOARD_HIDE);
                eventActionInfo2 = new io.dcloud.common.adapter.util.EventActionInfo(io.dcloud.common.constant.AbsoluteConst.EVENTS_KEYBOARD_HIDE);
                if (this.c != null) {
                    while (size >= 0) {
                        iWebviewObtainWebView = ((io.dcloud.common.core.ui.b) this.c.get(size)).obtainWebView();
                        if (iWebviewObtainWebView != null) {
                            if (!(iWebviewObtainWebView instanceof io.dcloud.common.adapter.ui.AdaUniWebView)) {
                                iWebviewObtainWebView.loadUrl(str);
                            } else {
                                iWebviewObtainWebView.loadUrl(str);
                            }
                        }
                    }
                }
                break;
            case 9:
                str = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.EVENTS_DOCUMENT_EXECUTE_TEMPLATE, "background");
                eventActionInfo2 = new io.dcloud.common.adapter.util.EventActionInfo("background");
                if (this.c != null) {
                    while (size >= 0) {
                        iWebviewObtainWebView = ((io.dcloud.common.core.ui.b) this.c.get(size)).obtainWebView();
                        if (iWebviewObtainWebView != null) {
                            if (!(iWebviewObtainWebView instanceof io.dcloud.common.adapter.ui.AdaUniWebView)) {
                                iWebviewObtainWebView.loadUrl(str);
                            } else {
                                iWebviewObtainWebView.loadUrl(str);
                            }
                        }
                    }
                }
                break;
            case 10:
                java.lang.String launcherData = io.dcloud.common.util.BaseInfo.getLauncherData(this.j.obtainAppId());
                if (this.j.obtainWebAppIntent().getBooleanExtra(io.dcloud.common.constant.IntentConst.IS_WEBAPP_REPLY, false)) {
                    launcherData = "default";
                } else {
                    this.j.setRuntimeArgs(java.lang.String.valueOf(obj));
                    java.lang.String str10 = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_ARGUMENTS, this.j.obtainRuntimeArgs(true));
                    java.lang.String str11 = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_LAUNCHER, launcherData);
                    str = io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT + io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_BASE, str10) + io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.JS_RUNTIME_BASE, str11);
                    str2 = str10 + str11;
                }
                str = str + io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.EVENTS_DOCUMENT_EXECUTE_TEMPLATE_PARAMETER, io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBAPP_FOREGROUND, launcherData);
                java.util.HashMap map2 = new java.util.HashMap();
                map2.put("active", launcherData);
                eventActionInfo = new io.dcloud.common.adapter.util.EventActionInfo(io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBAPP_FOREGROUND, str2, map2);
                eventActionInfo2 = eventActionInfo;
                if (this.c != null) {
                    while (size >= 0) {
                        iWebviewObtainWebView = ((io.dcloud.common.core.ui.b) this.c.get(size)).obtainWebView();
                        if (iWebviewObtainWebView != null) {
                            if (!(iWebviewObtainWebView instanceof io.dcloud.common.adapter.ui.AdaUniWebView)) {
                                iWebviewObtainWebView.loadUrl(str);
                            } else {
                                iWebviewObtainWebView.loadUrl(str);
                            }
                        }
                    }
                }
                break;
            case 11:
                str = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.EVENTS_DOCUMENT_EXECUTE_TEMPLATE, io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBAPP_TRIMMEMORY);
                eventActionInfo2 = new io.dcloud.common.adapter.util.EventActionInfo(io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBAPP_TRIMMEMORY);
                if (this.c != null) {
                    while (size >= 0) {
                        iWebviewObtainWebView = ((io.dcloud.common.core.ui.b) this.c.get(size)).obtainWebView();
                        if (iWebviewObtainWebView != null) {
                            if (!(iWebviewObtainWebView instanceof io.dcloud.common.adapter.ui.AdaUniWebView)) {
                                iWebviewObtainWebView.loadUrl(str);
                            } else {
                                iWebviewObtainWebView.loadUrl(str);
                            }
                        }
                    }
                }
                break;
            case 12:
                io.dcloud.common.ui.blur.AppEventForBlurManager.onSplashclosed();
                str = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.EVENTS_DOCUMENT_EXECUTE_TEMPLATE, io.dcloud.common.constant.AbsoluteConst.EVENTS_SPLASH_CLOSED);
                eventActionInfo = new io.dcloud.common.adapter.util.EventActionInfo(io.dcloud.common.constant.AbsoluteConst.EVENTS_SPLASH_CLOSED);
                io.dcloud.p.l.a(this.j.getActivity(), null, "onSplashclosed", null);
                eventActionInfo2 = eventActionInfo;
                if (this.c != null) {
                    while (size >= 0) {
                        iWebviewObtainWebView = ((io.dcloud.common.core.ui.b) this.c.get(size)).obtainWebView();
                        if (iWebviewObtainWebView != null) {
                            if (!(iWebviewObtainWebView instanceof io.dcloud.common.adapter.ui.AdaUniWebView)) {
                                iWebviewObtainWebView.loadUrl(str);
                            } else {
                                iWebviewObtainWebView.loadUrl(str);
                            }
                        }
                    }
                }
                break;
            default:
                if (this.c != null) {
                    while (size >= 0) {
                        iWebviewObtainWebView = ((io.dcloud.common.core.ui.b) this.c.get(size)).obtainWebView();
                        if (iWebviewObtainWebView != null) {
                            if (!(iWebviewObtainWebView instanceof io.dcloud.common.adapter.ui.AdaUniWebView)) {
                                iWebviewObtainWebView.loadUrl(str);
                            } else {
                                iWebviewObtainWebView.loadUrl(str);
                            }
                        }
                    }
                }
                break;
        }
        return false;
    }

    private void a(io.dcloud.common.core.ui.b bVar, int i2, int i3) {
        io.dcloud.common.adapter.util.Logger.d("DHAppRootView.pushFrameView" + bVar);
        this.b.insertElementAt(bVar, i2);
        addFrameItem(bVar, i3);
    }

    void h(io.dcloud.common.core.ui.b bVar) {
        java.util.ArrayList<io.dcloud.common.adapter.ui.AdaFrameItem> arrayList = bVar.getParentFrameItem().mChildArrayList;
        if (arrayList.size() > 1) {
            java.util.Collections.sort(arrayList, this.x);
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem = arrayList.get(i2);
                i2++;
                io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem2 = adaFrameItem;
                if (adaFrameItem2.obtainMainView() != null) {
                    if (!(adaFrameItem2.obtainMainView() instanceof io.dcloud.common.adapter.ui.WebParentView)) {
                        adaFrameItem2.obtainMainView().bringToFront();
                    }
                } else {
                    arrayList2.add(adaFrameItem2);
                }
            }
            if (arrayList2.size() > 0) {
                arrayList.removeAll(arrayList2);
            }
        }
        i(bVar);
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
    void reload(java.lang.String str) {
        java.lang.String[] strArrSplit = str.split("\\|");
        if (strArrSplit.length > 0 && io.dcloud.common.util.BaseInfo.isUniNViewBackgroud() && this.c.size() > 0) {
            io.dcloud.common.core.ui.b bVar = (io.dcloud.common.core.ui.b) this.c.get(0);
            bVar.mWindowMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{bVar.obtainApp(), "weex,io.dcloud.feature.weex.WeexFeature", "updateServiceReload", null});
        }
        for (int size = this.c.size() - 1; size >= 0; size--) {
            io.dcloud.common.core.ui.b bVar2 = (io.dcloud.common.core.ui.b) this.c.get(size);
            io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView = bVar2.obtainWebView();
            boolean z = bVar2.obtainFrameOptions().mUniNViewJson != null;
            if (iWebviewObtainWebView == null) {
                break;
                break;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= strArrSplit.length) {
                    break;
                }
                java.lang.String str2 = strArrSplit[i2];
                if (z) {
                    if (str2.endsWith(".js")) {
                        bVar2.mWindowMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{bVar2.obtainApp(), "weex,io.dcloud.feature.weex.WeexFeature", "updateReload", new java.lang.Object[]{str2}});
                    }
                } else if (iWebviewObtainWebView.obtainUrl().startsWith(str2)) {
                    iWebviewObtainWebView.reload();
                    break;
                } else if ((iWebviewObtainWebView instanceof io.dcloud.common.core.ui.TabBarWebview) && ((io.dcloud.common.core.ui.TabBarWebview) iWebviewObtainWebView).checkUrlToReload(str2)) {
                    break;
                }
                i2++;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class k {
        int a = 0;
        java.util.Vector b = new java.util.Vector();
        private boolean c = false;

        k() {
        }

        void a(io.dcloud.common.core.ui.b bVar) {
            this.b.add(bVar);
            int i = this.a + 1;
            this.a = i;
            if (i > 1) {
                this.c = true;
            } else {
                this.a = 1;
                this.c = false;
            }
        }

        void b(io.dcloud.common.core.ui.b bVar) {
            this.b.remove(bVar);
            this.a--;
        }

        int a() {
            return this.a;
        }
    }

    private void a(java.util.ArrayList arrayList, java.util.ArrayList arrayList2) {
        com.dcloud.android.graphics.Region region;
        com.dcloud.android.graphics.Region region2 = new com.dcloud.android.graphics.Region(2);
        for (int size = this.c.size() - 1; size >= 0; size--) {
            io.dcloud.common.core.ui.b bVar = (io.dcloud.common.core.ui.b) this.c.get(size);
            if (bVar.obtainMainView().getVisibility() == 0) {
                io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions = bVar.obtainFrameOptions();
                if (!bVar.isChildOfFrameView) {
                    if (bVar.a) {
                        a(region2, viewOptionsObtainFrameOptions.left, viewOptionsObtainFrameOptions.top, viewOptionsObtainFrameOptions.width, viewOptionsObtainFrameOptions.height);
                        region = region2;
                        b(arrayList, bVar);
                    } else {
                        region = region2;
                        bVar.h();
                        if (a(region)) {
                            if (a(arrayList2, bVar)) {
                                return;
                            }
                        } else {
                            if (viewOptionsObtainFrameOptions.hasTransparentValue()) {
                                region2 = region;
                            } else {
                                region2 = region;
                                if (a(region2, viewOptionsObtainFrameOptions.left, viewOptionsObtainFrameOptions.top, viewOptionsObtainFrameOptions.width, viewOptionsObtainFrameOptions.height)) {
                                    if (a(arrayList2, bVar)) {
                                        return;
                                    }
                                }
                            }
                            b(arrayList, bVar);
                        }
                    }
                    region2 = region;
                }
            } else if (a(arrayList2, bVar)) {
                return;
            }
        }
    }

    void b(io.dcloud.common.core.ui.b bVar) {
        byte b2 = bVar.getAnimOptions().mOption;
        if ((!bVar.d && !bVar.inStack && bVar.obtainFrameOptions().hasTransparentValue()) || bVar.obtainMainView().getVisibility() != 0) {
            if (b2 == 3 || b2 == 1) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                a(arrayList, bVar);
                bVar.c = arrayList;
                if (b2 != 1) {
                    return;
                }
            } else {
                if (b2 == 2) {
                    return;
                }
                if (b2 == 4 || b2 == 0) {
                    java.util.ArrayList arrayList2 = new java.util.ArrayList();
                    b(arrayList2, bVar);
                    bVar.b = arrayList2;
                    return;
                }
            }
        }
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        java.util.ArrayList arrayList4 = new java.util.ArrayList();
        com.dcloud.android.graphics.Region region = new com.dcloud.android.graphics.Region(2);
        for (int size = this.c.size() - 1; size >= 0; size--) {
            io.dcloud.common.core.ui.b bVar2 = (io.dcloud.common.core.ui.b) this.c.get(size);
            if (bVar2.obtainMainView().getVisibility() == 0) {
                if (bVar2.isChildOfFrameView) {
                    continue;
                } else {
                    bVar2.h();
                    io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions = bVar2.obtainFrameOptions();
                    if (b2 == 4 || b2 == 0) {
                        if ((a(region) || region.getFillScreenCounter() > 2) && bVar != bVar2) {
                            if (a(arrayList3, bVar2)) {
                                break;
                            }
                        } else if (!viewOptionsObtainFrameOptions.hasTransparentValue() && a(region, viewOptionsObtainFrameOptions.left, viewOptionsObtainFrameOptions.top, viewOptionsObtainFrameOptions.width, viewOptionsObtainFrameOptions.height)) {
                            if (a(arrayList3, bVar2)) {
                                break;
                            }
                        } else {
                            b(arrayList4, bVar2);
                        }
                    } else if (b2 == 2) {
                        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions_Animate = bVar2.obtainFrameOptions_Animate();
                        if (bVar2 == bVar && viewOptionsObtainFrameOptions_Animate != null) {
                            viewOptionsObtainFrameOptions = viewOptionsObtainFrameOptions_Animate;
                        }
                        if (a(region)) {
                            if (a(arrayList3, bVar2)) {
                                break;
                            }
                        } else if (!viewOptionsObtainFrameOptions.hasTransparentValue() && a(region, viewOptionsObtainFrameOptions.left, viewOptionsObtainFrameOptions.top, viewOptionsObtainFrameOptions.width, viewOptionsObtainFrameOptions.height)) {
                            if (a(arrayList3, bVar2)) {
                                break;
                            }
                        } else {
                            b(arrayList4, bVar2);
                        }
                    } else if (b2 == 3 || b2 == 1) {
                        if (bVar2 == bVar) {
                            a(arrayList3, bVar2);
                        } else if (a(region)) {
                            a(arrayList3, bVar2);
                        } else if (!viewOptionsObtainFrameOptions.hasTransparentValue() && a(region, viewOptionsObtainFrameOptions.left, viewOptionsObtainFrameOptions.top, viewOptionsObtainFrameOptions.width, viewOptionsObtainFrameOptions.height)) {
                            if (a(arrayList3, bVar2)) {
                                break;
                            }
                        } else {
                            b(arrayList4, bVar2);
                        }
                    }
                }
            } else {
                if (a(arrayList3, bVar2)) {
                    break;
                }
            }
        }
        bVar.c = arrayList3;
        bVar.b = arrayList4;
    }

    void i(io.dcloud.common.core.ui.b bVar) {
        if (bVar.getParentFrameItem() == null) {
            return;
        }
        bVar.getParentFrameItem().sortNativeViewBringToFront();
    }

    io.dcloud.common.core.ui.b e() {
        return a(2);
    }

    boolean a(com.dcloud.android.graphics.Region region) {
        boolean zQuickContains = region.quickContains(0, 0, this.j.getInt(0), this.j.getInt(1));
        if (region.fillWholeScreen() || !zQuickContains) {
            return zQuickContains;
        }
        region.setEmpty();
        region.count();
        return false;
    }

    boolean a(java.util.ArrayList arrayList, io.dcloud.common.core.ui.b bVar) {
        arrayList.add(bVar);
        return false;
    }

    boolean a(com.dcloud.android.graphics.Region region, int i2, int i3, int i4, int i5) {
        int i6 = i2 + i4;
        int i7 = i3 + i5;
        boolean zQuickContains = region.quickContains(i2, i3, i6, i7);
        if (!zQuickContains) {
            region.op(i2, i3, i6, i7, android.graphics.Region.Op.UNION);
        }
        return zQuickContains;
    }

    void a(io.dcloud.common.core.ui.b bVar) {
        io.dcloud.common.adapter.util.Logger.d("DHAppRootView.closeFrameView pFrameView=" + bVar);
        bVar.onDestroy();
        removeFrameItem(bVar);
        java.lang.System.gc();
    }

    public void a() {
        io.dcloud.common.adapter.util.Logger.d(this.i + " clearFrameView");
        java.util.ArrayList arrayList = this.c;
        if (arrayList != null) {
            int size = arrayList.size();
            io.dcloud.common.core.ui.b[] bVarArr = new io.dcloud.common.core.ui.b[size];
            this.c.toArray(bVarArr);
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    bVarArr[i2].onDestroy();
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.c.clear();
        }
        clearView();
        java.util.Stack stack = this.b;
        if (stack != null) {
            stack.clear();
        }
    }

    void a(io.dcloud.common.DHInterface.IApp iApp) {
        if (java.lang.Boolean.parseBoolean(iApp.obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_WAITING))) {
            obtainMainView().postDelayed(new io.dcloud.common.core.ui.a.e(), 100L);
        }
    }

    io.dcloud.common.core.ui.b a(int i2) {
        java.util.ArrayList arrayList = this.c;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            java.lang.Object obj = arrayList.get(i3);
            i3++;
            io.dcloud.common.core.ui.b bVar = (io.dcloud.common.core.ui.b) obj;
            if (bVar.getFrameType() == i2) {
                return bVar;
            }
        }
        return null;
    }

    void a(io.dcloud.common.core.ui.a aVar, io.dcloud.common.core.ui.b bVar, int i2, boolean z, int i3) {
        if (bVar != null) {
            io.dcloud.common.adapter.util.Logger.d("approotview", "closeSplashScreen0 delay=" + i2 + ";autoClose=" + z + ";mAppid" + this.i);
            if (bVar.obtainMainView() != null) {
                io.dcloud.common.adapter.util.MessageHandler.sendMessage(new io.dcloud.common.core.ui.a.f(z, aVar, i3), java.lang.Math.max(i2, 150), bVar);
                return;
            }
            io.dcloud.common.adapter.util.Logger.d("approotview", "closeSplashScreen2;autoClose;mAppid" + this.i);
            a(aVar, i3);
        }
    }

    void a(io.dcloud.common.core.ui.a aVar, int i2) {
        android.util.Log.e("Html5Plus-SplashClosed", java.lang.System.currentTimeMillis() + "");
        android.util.Log.e(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "closeSplashScreen0 appid=" + this.i + ";" + (i2 > 10) + ";closeSplashDid=" + this.q);
        if (aVar != null && !this.q) {
            if (this.s) {
                return;
            }
            io.dcloud.common.DHInterface.IActivityHandler iActivityHandler = this.m;
            boolean z = iActivityHandler != null ? !iActivityHandler.hasAdService() : true;
            io.dcloud.common.DHInterface.IActivityHandler iActivityHandler2 = this.m;
            if (iActivityHandler2 != null) {
                if (!iActivityHandler2.hasAdService()) {
                    java.lang.Object objInvokeMethod = io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.gg.dcloud.ADHandler", "SplashAdIsEnable", null, new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{aVar.getContext()});
                    if ((objInvokeMethod instanceof java.lang.Boolean) && ((java.lang.Boolean) objInvokeMethod).booleanValue()) {
                        long jAbs = java.lang.Math.abs(java.lang.System.currentTimeMillis() - io.dcloud.common.util.BaseInfo.splashCreateTime);
                        if (jAbs < 2500) {
                            this.s = true;
                            io.dcloud.common.adapter.util.MessageHandler.postDelayed(new io.dcloud.common.core.ui.a.g(aVar, i2), 2500 - jAbs);
                            return;
                        }
                    }
                }
                if (z) {
                    this.m.closeAppStreamSplash(this.i);
                }
                io.dcloud.common.util.BaseInfo.setLoadingLaunchePage(false, "closeSplashScreen0");
                try {
                    ((android.widget.FrameLayout.LayoutParams) obtainMainView().getLayoutParams()).topMargin = 0;
                } catch (java.lang.Exception e2) {
                    io.dcloud.common.adapter.util.Logger.e("Exception", "e.getMessage()==" + e2.getMessage());
                }
                if (z) {
                    this.j.onSplashClosed();
                } else {
                    this.m.setSplashCloseListener(this.i, new io.dcloud.common.core.ui.a.h());
                }
            } else {
                io.dcloud.common.DHInterface.IApp iApp = this.j;
                if (iApp != null) {
                    iApp.diyStatusBarState();
                }
            }
            io.dcloud.common.util.BaseInfo.run5appEndTime = io.dcloud.common.util.TestUtil.getUseTime(io.dcloud.common.constant.AbsoluteConst.RUN_5AP_TIME_KEY, "");
            io.dcloud.common.util.TestUtil.delete(io.dcloud.common.constant.AbsoluteConst.RUN_5AP_TIME_KEY);
            this.j.setConfigProperty("commit", java.lang.String.valueOf(this.p));
            io.dcloud.common.DHInterface.IOnCreateSplashView onCreateSplashView = this.j.getOnCreateSplashView();
            if (onCreateSplashView != null) {
                onCreateSplashView.onCloseSplash();
            }
            io.dcloud.common.core.ui.DCKeyboardManager.getInstance().dhAppRootIsReady(this);
            io.dcloud.common.util.BaseInfo.splashCloseTime = java.lang.System.currentTimeMillis();
            io.dcloud.common.DHInterface.IApp iApp2 = this.j;
            if ((iApp2 != null && z) || this.r) {
                iApp2.callSysEventListener(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onSplashclosed, this);
            }
        }
        this.q = true;
    }

    void b(java.util.ArrayList arrayList, io.dcloud.common.core.ui.b bVar) {
        arrayList.add(bVar);
    }

    private void b(io.dcloud.common.DHInterface.IApp iApp) {
        iApp.setFullScreen(io.dcloud.common.util.PdrUtil.parseBoolean(iApp.obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_FULLSCREEN), false, false));
    }

    public java.lang.Object a(android.view.View view, io.dcloud.common.DHInterface.ICallBack iCallBack) {
        if (!io.dcloud.common.adapter.util.AndroidResources.sIMEAlive) {
            return iCallBack.onCallBack(-1, null);
        }
        io.dcloud.common.adapter.util.DeviceInfo.hideIME(obtainMainView());
        this.v.add(iCallBack);
        return null;
    }

    private void a(java.util.ArrayList arrayList) {
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        int i2 = 0;
        int i3 = this.j.getInt(0);
        int size = arrayList.size();
        while (i2 < size) {
            java.lang.Object obj = arrayList.get(i2);
            i2++;
            io.dcloud.common.core.ui.b bVar = (io.dcloud.common.core.ui.b) obj;
            io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions = bVar.obtainFrameOptions();
            int i4 = viewOptionsObtainFrameOptions.width;
            if (i4 == -1) {
                i4 = i3;
            }
            int i5 = viewOptionsObtainFrameOptions.left;
            if (i5 + i4 <= 0 || i5 >= i3 || viewOptionsObtainFrameOptions.right + i4 <= 0) {
                arrayList2.add(bVar);
            }
        }
        arrayList.removeAll(arrayList2);
    }

    public void a(io.dcloud.common.DHInterface.IFrameView iFrameView, java.util.ArrayList arrayList) {
        if (this.c.contains(iFrameView)) {
            int iIndexOf = this.c.indexOf(iFrameView);
            if (this.c != null) {
                com.dcloud.android.graphics.Region region = new com.dcloud.android.graphics.Region();
                for (int i2 = iIndexOf - 1; i2 >= 0; i2--) {
                    io.dcloud.common.core.ui.b bVar = (io.dcloud.common.core.ui.b) this.c.get(i2);
                    if (!bVar.isChildOfFrameView && bVar.obtainMainView().getVisibility() == 0) {
                        arrayList.add(bVar);
                        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions = bVar.obtainFrameOptions();
                        a(region, viewOptionsObtainFrameOptions.left, viewOptionsObtainFrameOptions.top, viewOptionsObtainFrameOptions.width, viewOptionsObtainFrameOptions.height);
                    }
                    if (a(region)) {
                        return;
                    }
                }
            }
        }
    }

    public void a(io.dcloud.common.core.ui.b bVar, io.dcloud.common.core.ui.b bVar2) {
        io.dcloud.common.adapter.util.AnimOptions animOptions = bVar.getAnimOptions();
        this.y = animOptions.mOption;
        animOptions.mOption = bVar2.getAnimOptions().mOption;
        this.z = animOptions.mAnimType;
        animOptions.mAnimType = bVar2.getAnimOptions().mAnimType;
        this.A = animOptions.mAnimType_close;
        animOptions.mAnimType_close = bVar2.getAnimOptions().mAnimType_close;
    }

    public io.dcloud.common.adapter.ui.DHImageView a(io.dcloud.common.core.ui.b bVar, int i2, boolean z) {
        boolean z2;
        io.dcloud.common.adapter.ui.DHImageView dHImageView;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        io.dcloud.common.core.ui.a.l lVar = (io.dcloud.common.core.ui.a.l) obtainMainView();
        if (bVar.mNativeView != null) {
            if (this.B == null) {
                this.B = lVar.getLeftImageView();
            }
            if (bVar.mNativeView.isAnimate()) {
                this.B.removeNativeView();
                bVar.mNativeView = null;
            } else {
                if (this.B.getParent() != lVar) {
                    if (this.B.getParent() != null) {
                        ((android.view.ViewGroup) this.B.getParent()).removeView(this.B);
                    }
                    lVar.addView(this.B);
                }
                this.B.addNativeView(bVar, bVar.mNativeView);
                this.B.setImageBitmap(null);
                this.B.bringToFront();
                this.B.setVisibility(0);
                return this.B;
            }
        }
        if (a((android.view.ViewGroup) lVar)) {
            io.dcloud.common.adapter.ui.DHImageView dHImageView2 = this.B;
            if (dHImageView2 != null) {
                dHImageView2.clear();
                this.B = null;
            }
            return null;
        }
        android.graphics.Bitmap bitmapCaptureView = bVar.mSnapshot;
        if (bitmapCaptureView != null) {
            z2 = false;
        } else {
            if (1 == i2 && (dHImageView = this.B) != null && dHImageView.getBitmap() != null && this.B.getTag() != null && bVar.hashCode() == ((java.lang.Integer) this.B.getTag()).intValue()) {
                if (this.B.getParent() != lVar) {
                    if (this.B.getParent() != null) {
                        ((android.view.ViewGroup) this.B.getParent()).removeView(this.B);
                    }
                    lVar.addView(this.B);
                }
                this.B.removeNativeView();
                this.B.bringToFront();
                this.B.setVisibility(0);
                return this.B;
            }
            bitmapCaptureView = io.dcloud.common.adapter.util.PlatformUtil.captureView(bVar.obtainMainView());
            z2 = true;
        }
        if (bitmapCaptureView != null && !io.dcloud.common.adapter.util.PlatformUtil.isWhiteBitmap(bitmapCaptureView)) {
            if (this.B == null) {
                this.B = lVar.getLeftImageView();
            }
            if (this.B.getParent() != lVar) {
                if (this.B.getParent() != null) {
                    ((android.view.ViewGroup) this.B.getParent()).removeView(this.B);
                }
                lVar.addView(this.B);
            }
            this.B.bringToFront();
            this.B.setImageBitmap(bitmapCaptureView);
            this.B.removeNativeView();
            this.B.setVisibility(0);
        } else {
            io.dcloud.common.adapter.ui.DHImageView dHImageView3 = this.B;
            if (dHImageView3 != null) {
                dHImageView3.clear();
                this.B = null;
            }
        }
        io.dcloud.common.adapter.ui.DHImageView dHImageView4 = this.B;
        if (dHImageView4 != null) {
            if (dHImageView4.isSlipping()) {
                return null;
            }
            this.B.refreshImagerView();
        }
        long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
        java.lang.StringBuilder sb = new java.lang.StringBuilder("==============B截图耗时=");
        long j2 = jCurrentTimeMillis2 - jCurrentTimeMillis;
        sb.append(j2);
        io.dcloud.common.adapter.util.Logger.i("mabo", sb.toString());
        if (j2 >= io.dcloud.common.util.BaseInfo.sTimeoutCapture) {
            int i3 = io.dcloud.common.util.BaseInfo.sTimeOutCount + 1;
            io.dcloud.common.util.BaseInfo.sTimeOutCount = i3;
            if (i3 > io.dcloud.common.util.BaseInfo.sTimeOutMax) {
                io.dcloud.common.util.BaseInfo.sAnimationCaptureB = false;
            }
        } else if (z2) {
            io.dcloud.common.util.BaseInfo.sTimeOutCount = 0;
        }
        return this.B;
    }

    public boolean a(android.view.ViewGroup viewGroup) {
        io.dcloud.common.adapter.ui.DHImageView dHImageView = this.B;
        return (dHImageView == null || dHImageView.mBitmapHeight <= 0 || ((long) viewGroup.getHeight()) == this.B.mBitmapHeight) ? false : true;
    }
}
