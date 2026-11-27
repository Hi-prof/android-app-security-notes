package io.dcloud.feature.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class c extends io.dcloud.feature.ui.b implements io.dcloud.common.DHInterface.IEventCallback {
    private static final java.util.HashMap d0;
    int A;
    java.lang.Object B;
    boolean C;
    boolean D;
    int E;
    boolean F;
    boolean G;
    boolean H;
    boolean I;
    boolean J;
    boolean K;
    boolean L;
    protected java.util.ArrayList M;
    java.lang.String N;
    java.lang.String O;
    io.dcloud.common.DHInterface.IWebview P;
    java.lang.String Q;
    io.dcloud.common.DHInterface.IWebview R;
    java.lang.String S;
    io.dcloud.common.DHInterface.IWebview T;
    java.lang.String U;
    private boolean V;
    io.dcloud.feature.ui.c W;
    private java.util.ArrayList X;
    private boolean Y;
    private java.lang.String Z;
    private int a0;
    private boolean b0;
    java.lang.Runnable c0;
    long u;
    org.json.JSONArray v;
    io.dcloud.common.DHInterface.IWebview w;
    org.json.JSONObject x;
    io.dcloud.common.DHInterface.IFrameView y;
    java.lang.String z;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements java.lang.Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (io.dcloud.feature.ui.c.this.y.obtainWebView().checkWhite(io.dcloud.feature.ui.c.this.Z)) {
                io.dcloud.feature.ui.c.this.l();
            } else {
                io.dcloud.feature.ui.c.this.a(io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBVIEW_RENDERED, "{}", false);
            }
            io.dcloud.feature.ui.c.this.c0 = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements io.dcloud.common.adapter.ui.ReceiveJSValue.ReceiveJSValueCallback {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String b;

        b(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // io.dcloud.common.adapter.ui.ReceiveJSValue.ReceiveJSValueCallback
        public java.lang.String callback(org.json.JSONArray jSONArray) {
            java.lang.Object obj;
            java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONArray, 0);
            try {
                obj = jSONArray.get(1);
            } catch (org.json.JSONException unused) {
                obj = null;
            }
            if ((obj instanceof java.lang.String) || "string".equals(string)) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.a, this.b, java.lang.String.valueOf(obj), io.dcloud.common.util.JSUtil.OK, false, false);
            } else if ((obj instanceof org.json.JSONArray) || (obj instanceof org.json.JSONObject) || "object".equals(string) || !com.taobao.weex.common.Constants.Name.UNDEFINED.equals(string)) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.a, this.b, obj.toString(), io.dcloud.common.util.JSUtil.OK, true, false);
            } else {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.a, this.b, com.taobao.weex.common.Constants.Name.UNDEFINED, io.dcloud.common.util.JSUtil.OK, true, false);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: io.dcloud.feature.ui.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class RunnableC0046c implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String b;

        RunnableC0046c(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.evalJSSync(this.b, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements io.dcloud.common.adapter.util.MessageHandler.UncheckedCallable {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String b;

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class a implements io.dcloud.common.DHInterface.ICallBack {
            final /* synthetic */ io.dcloud.common.adapter.util.MessageHandler.WaitableRunnable a;

            a(io.dcloud.common.adapter.util.MessageHandler.WaitableRunnable waitableRunnable) {
                this.a = waitableRunnable;
            }

            @Override // io.dcloud.common.DHInterface.ICallBack
            public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                io.dcloud.common.adapter.util.MessageHandler.WaitableRunnable waitableRunnable = this.a;
                if (waitableRunnable == null) {
                    return null;
                }
                waitableRunnable.callBack(obj);
                return null;
            }
        }

        d(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // io.dcloud.common.adapter.util.MessageHandler.UncheckedCallable
        public void run(io.dcloud.common.adapter.util.MessageHandler.WaitableRunnable waitableRunnable) {
            try {
                this.a.evalJSSync(this.b, new io.dcloud.feature.ui.c.d.a(waitableRunnable));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                if (waitableRunnable != null) {
                    waitableRunnable.callBack("");
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class e implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview c;
        final /* synthetic */ java.lang.String d;

        e(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, io.dcloud.common.DHInterface.IWebview iWebview2, java.lang.String str2) {
            this.a = iWebview;
            this.b = str;
            this.c = iWebview2;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                boolean zCheckWhite = this.a.checkWhite(this.b);
                io.dcloud.common.DHInterface.IWebview iWebview = this.c;
                java.lang.String str = this.d;
                java.lang.StringBuilder sb = new java.lang.StringBuilder("{\"code\":100,\"rendered\":");
                sb.append(!zCheckWhite);
                sb.append(com.taobao.weex.el.parse.Operators.BLOCK_END_STR);
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, sb.toString(), io.dcloud.common.util.JSUtil.OK, true, false);
            } catch (java.lang.Exception unused) {
                if (io.dcloud.feature.ui.c.this.a() != null) {
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.d, "{\"code\":-100,\"message\":\"" + io.dcloud.feature.ui.c.this.a().getString(io.dcloud.base.R.string.dcloud_common_screenshot_fail) + "\"}", io.dcloud.common.util.JSUtil.ERROR, true, false);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class f implements io.dcloud.common.DHInterface.ICallBack {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String b;

        f(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.a, this.b, null, io.dcloud.common.util.JSUtil.OK, false, false);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class g implements io.dcloud.common.DHInterface.ICallBack {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String b;

        g(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.a, this.b, "{\"code\":-100,\"message\":\"" + this.a.getContext().getString(io.dcloud.base.R.string.dcloud_common_screenshot_fail) + "\"}", io.dcloud.common.util.JSUtil.ERROR, true, false);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class h implements io.dcloud.common.DHInterface.ICallBack {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String b;

        h(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.a, this.b, null, io.dcloud.common.util.JSUtil.OK, false, false);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class i implements io.dcloud.common.DHInterface.ICallBack {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String b;

        i(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
            this.a = iWebview;
            this.b = str;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            io.dcloud.common.DHInterface.IWebview iWebview = this.a;
            java.lang.String str = this.b;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("{\"code\":");
            sb.append(i);
            sb.append(",\"message\":\"");
            sb.append(obj != null ? obj.toString() : io.dcloud.feature.ui.c.this.a().getString(io.dcloud.base.R.string.dcloud_common_screenshot_fail));
            sb.append("\"}");
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, sb.toString(), io.dcloud.common.util.JSUtil.ERROR, true, false);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class j implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;

        j(java.lang.String str, java.lang.String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.common.util.TestUtil.PointTime.commitTid(io.dcloud.feature.ui.c.this.a(), this.a, io.dcloud.feature.ui.c.this.g, this.b, 10);
        }
    }

    static {
        java.util.HashMap map = new java.util.HashMap();
        d0 = map;
        map.put(io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE, "onclose");
        map.put("loading", "onloading");
        map.put(io.dcloud.common.constant.AbsoluteConst.EVENTS_FAILED, "onerror");
        map.put(io.dcloud.common.constant.AbsoluteConst.EVENTS_LOADED, "onloaded");
    }

    c(io.dcloud.feature.ui.a aVar, java.lang.String str, java.lang.String str2, java.lang.String str3, org.json.JSONObject jSONObject) {
        this(aVar, null, str, str2, str3, jSONObject);
    }

    private io.dcloud.common.DHInterface.INativeBitmap g(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        return (io.dcloud.common.DHInterface.INativeBitmap) iWebview.obtainApp().obtainMgrData(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebview, "nativeobj", "getNativeBitmap", new java.lang.String[]{iWebview.obtainApp().obtainAppId(), str}});
    }

    private void i() {
        if (this.y.getFrameType() == 6) {
            io.dcloud.common.util.ThreadPool.self().addThreadTask(new io.dcloud.feature.ui.c.j(this.c.f.obtainAppId(), this.c.f.obtainConfigProperty("adid")));
        }
    }

    private void j() {
        android.view.View viewObtainMainView = this.y.obtainMainView();
        if (viewObtainMainView instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) viewObtainMainView;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                android.view.View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof io.dcloud.common.DHInterface.ITitleNView) {
                    childAt.bringToFront();
                    return;
                }
            }
        }
    }

    private boolean k() {
        io.dcloud.feature.ui.c cVar = this.a;
        if (cVar != null) {
            return cVar.F && cVar.k();
        }
        return true;
    }

    private void s() {
        this.c.b(this);
        if (!this.I) {
            d().onDispose();
            d().dispose();
        } else if (!this.J) {
            if (this.L) {
                io.dcloud.feature.ui.c cVar = this.a;
                if (cVar != null) {
                    cVar.c(this);
                }
                d().onDispose();
                d().dispose();
            } else {
                ((io.dcloud.common.adapter.ui.AdaFrameItem) this.y).getAnimOptions().mOption = (byte) 1;
            }
        }
        e();
    }

    private void t() {
        ((io.dcloud.common.adapter.ui.AdaFrameItem) this.y).getAnimOptions().mOption = (byte) 3;
        this.F = false;
        this.G = true;
    }

    @Override // io.dcloud.feature.ui.b
    public void a(int i2, int i3, int i4, int i5, int i6, int i7) {
    }

    public void b(boolean z) {
        this.Y = z;
    }

    protected io.dcloud.feature.ui.b c(java.lang.String str) {
        java.util.ArrayList arrayList = this.M;
        io.dcloud.feature.ui.b bVar = null;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int size = this.M.size() - 1; size >= 0; size--) {
                bVar = (io.dcloud.feature.ui.b) this.M.get(size);
                if (io.dcloud.common.util.PdrUtil.isEquals(str, bVar.f)) {
                    return bVar;
                }
            }
        }
        return bVar;
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
    protected void d(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebview, "maps", "appendToFrameView", new java.lang.Object[]{this.y, str}});
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
    protected void e(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebview, "nativeobj", "addNativeView", new java.lang.Object[]{this.y, str}});
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
    protected void f(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebview, "videoplayer", "appendToFrameView", new java.lang.Object[]{this.y, str}});
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
    protected void h(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebview, "nativeobj", "removeNativeView", new java.lang.Object[]{this.y, str}});
    }

    public void l() {
        java.util.HashMap map = this.m;
        if (map == null || !map.containsKey(io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBVIEW_RENDERED)) {
            return;
        }
        java.lang.Runnable runnable = this.c0;
        if (runnable != null) {
            io.dcloud.common.adapter.util.MessageHandler.removeCallbacks(runnable);
        }
        io.dcloud.feature.ui.c.a aVar = new io.dcloud.feature.ui.c.a();
        this.c0 = aVar;
        io.dcloud.common.adapter.util.MessageHandler.postDelayed(aVar, this.a0);
    }

    public java.lang.String m() {
        io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView = this.y.obtainWebView();
        if (iWebviewObtainWebView != null) {
            return iWebviewObtainWebView.obtainFrameId();
        }
        return null;
    }

    protected java.lang.String n() {
        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions = ((io.dcloud.common.adapter.ui.AdaFrameItem) this.y).obtainFrameOptions();
        return io.dcloud.common.util.StringUtil.format("{top:%d,left:%d,width:%d,height:%d}", java.lang.Integer.valueOf((int) (viewOptionsObtainFrameOptions.top / viewOptionsObtainFrameOptions.mWebviewScale)), java.lang.Integer.valueOf((int) (viewOptionsObtainFrameOptions.left / viewOptionsObtainFrameOptions.mWebviewScale)), java.lang.Integer.valueOf((int) (viewOptionsObtainFrameOptions.width / viewOptionsObtainFrameOptions.mWebviewScale)), java.lang.Integer.valueOf((int) (viewOptionsObtainFrameOptions.height / viewOptionsObtainFrameOptions.mWebviewScale)));
    }

    public boolean o() {
        return !this.y.isWebviewCovered();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0033  */
    /* JADX WARN: Code duplicated, block: B:88:0x0146  */
    @Override // io.dcloud.common.DHInterface.IEventCallback
    public java.lang.Object onCallBack(java.lang.String str, java.lang.Object obj) {
        io.dcloud.common.DHInterface.IWebview iWebview;
        byte b2 = 2;
        io.dcloud.common.adapter.util.Logger.d("yl", "NWindow.onCallBack pEventType=" + str, obj);
        str.getClass();
        str.hashCode();
        switch (str) {
            case "listenResourceLoading":
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.T, this.S, (java.lang.String) obj, io.dcloud.common.util.JSUtil.OK, true, true);
                return null;
            case "onresize":
                q();
                return null;
            case "dragBounce":
            case "slideBounce":
            case "titleNViewSearchInputFocusChanged":
            case "resize":
            case "titleNViewSearchInputConfirmed":
            case "titleNViewSearchInputChanged":
                a(str, io.dcloud.common.util.PdrUtil.isEmpty(obj) ? null : java.lang.String.valueOf(obj), false);
                return null;
            case "touchstart":
                java.util.HashMap map = this.m;
                if (map != null && map.containsKey(io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBVIEW_ONTOUCH_START)) {
                    a(str, io.dcloud.common.util.PdrUtil.isEmpty(obj) ? null : java.lang.String.valueOf(obj));
                }
                return null;
            case "hide_loading":
                this.c.d(this);
                return null;
            case "progressChanged":
                a(str, io.dcloud.common.util.StringUtil.format("{progress:%s,target:%s}", obj, "plus.webview._find__Window_By_UUID__('" + this.f + "','" + this.e + "')"), false);
                return null;
            case "show_animation_end":
                if (!io.dcloud.common.util.PdrUtil.isEmpty(this.O) && (iWebview = this.P) != null) {
                    io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, this.O, "", io.dcloud.common.util.JSUtil.OK, false, false);
                }
                a(io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBVIEW_SHOW, io.dcloud.common.util.PdrUtil.isEmpty(obj) ? null : java.lang.String.valueOf(obj));
                return null;
            case "popGesture":
                java.lang.Object[] objArr = (java.lang.Object[]) obj;
                java.lang.String str2 = (java.lang.String) objArr[0];
                java.lang.Object obj2 = objArr[1];
                io.dcloud.feature.ui.c cVarA = this.c.a((io.dcloud.common.DHInterface.IFrameView) objArr[2]);
                a(str, io.dcloud.common.util.StringUtil.format("{type:'%s', result:%s, private_args:{uuid:'%s',id:'%s',extras:'%s'}}", str2, obj2, cVarA.e, cVarA.f, cVarA.x), false);
                return null;
            case "overrideUrlLoading":
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.R, this.Q, (java.lang.String) obj, io.dcloud.common.util.JSUtil.OK, true, true);
                return null;
            case "slide_webview_hide":
                t();
                return null;
            case "titleUpdate":
                a(str, io.dcloud.common.util.StringUtil.format("{title:%s}", obj == null ? "''" : org.json.JSONObject.quote(obj.toString())), false);
                l();
                return null;
            case "slide_webview_close":
                s();
                return null;
            case "titleNViewSearchInputClicked":
                a(str, io.dcloud.common.util.PdrUtil.isEmpty(obj) ? null : java.lang.String.valueOf(obj));
                return null;
            case "show_loading":
                if (this.I) {
                    this.c.f(this);
                }
                return null;
            default:
                java.lang.String str3 = (java.lang.String) d0.get(str);
                if (!io.dcloud.common.util.PdrUtil.isEmpty(str3)) {
                    a(str3, obj, this.c.c, this);
                }
                str.hashCode();
                switch (str.hashCode()) {
                    case -1183076191:
                        if (!str.equals(io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBVIEW_RESUME)) {
                            b2 = -1;
                        } else {
                            b2 = 0;
                        }
                        break;
                    case -1097519099:
                        if (!str.equals(io.dcloud.common.constant.AbsoluteConst.EVENTS_LOADED)) {
                            b2 = -1;
                        } else {
                            b2 = 1;
                        }
                        break;
                    case -787126039:
                        if (!str.equals(io.dcloud.common.constant.AbsoluteConst.EVENTS_WINDOW_CLOSE)) {
                            b2 = -1;
                        }
                        break;
                    case -732864766:
                        if (!str.equals(io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBVIEW_PAUSE)) {
                            b2 = -1;
                        } else {
                            b2 = 3;
                        }
                        break;
                    case 3202370:
                        if (!str.equals("hide")) {
                            b2 = -1;
                        } else {
                            b2 = 4;
                        }
                        break;
                    case 94756344:
                        if (!str.equals(io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE)) {
                            b2 = -1;
                        } else {
                            b2 = 5;
                        }
                        break;
                    case 301767451:
                        if (!str.equals(io.dcloud.common.constant.AbsoluteConst.EVENTS_PULL_TO_REFRESH)) {
                            b2 = -1;
                        } else {
                            b2 = 6;
                        }
                        break;
                    case 336650556:
                        if (!str.equals("loading")) {
                            b2 = -1;
                        } else {
                            b2 = 7;
                        }
                        break;
                    case 1839654540:
                        if (!str.equals(io.dcloud.common.constant.AbsoluteConst.EVENTS_RENDERING)) {
                            b2 = -1;
                        } else {
                            b2 = 8;
                        }
                        break;
                    default:
                        b2 = -1;
                        break;
                }
                switch (b2) {
                    case 0:
                    case 3:
                    case 4:
                    case 6:
                    case 7:
                    case 8:
                        a(str, "{}", false);
                        return null;
                    case 1:
                        this.A = -1;
                        org.json.JSONArray jSONArray = this.v;
                        if (jSONArray != null) {
                            a(this.w, jSONArray, this, this.y.obtainApp().obtainAppId());
                        }
                        io.dcloud.common.util.TestUtil.print(io.dcloud.common.util.TestUtil.CREATE_WEBVIEW, this.z + " 从加载完成分发loaded事件到开始分发事件 " + str);
                        java.lang.StringBuilder sb = new java.lang.StringBuilder("EVENTS_LOADED mUrl=");
                        sb.append(this.z);
                        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.MAIN_TAG, sb.toString());
                        a(str, "{}", false);
                        return null;
                    case 2:
                        a(str, io.dcloud.common.util.PdrUtil.isEmpty(obj) ? null : java.lang.String.valueOf(obj));
                        g();
                        return null;
                    case 5:
                        this.c.b(this);
                        a(str, "{}", false);
                        return null;
                    default:
                        a(str, io.dcloud.common.util.PdrUtil.isEmpty(obj) ? null : java.lang.String.valueOf(obj));
                        return null;
                }
        }
    }

    public boolean p() {
        return this.b0;
    }

    protected void q() {
    }

    public io.dcloud.common.DHInterface.IWebview r() {
        return this.y.obtainWebView();
    }

    private c(io.dcloud.feature.ui.a aVar, io.dcloud.common.DHInterface.IFrameView iFrameView, java.lang.String str, java.lang.String str2, java.lang.String str3, org.json.JSONObject jSONObject) {
        super("NWindow");
        this.u = java.lang.System.currentTimeMillis();
        this.v = null;
        this.w = null;
        this.x = null;
        this.A = -1;
        this.B = null;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = false;
        this.G = false;
        this.H = true;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = true;
        this.W = null;
        this.X = null;
        this.Y = false;
        this.Z = "auto";
        this.a0 = 150;
        this.b0 = false;
        this.c0 = null;
        this.c = aVar;
        this.z = str;
        this.e = str3;
        this.h = jSONObject;
        a(iFrameView, str2);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0068  */
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
    private void e(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray, io.dcloud.feature.ui.c cVar) {
        boolean z;
        boolean z2;
        char c;
        org.json.JSONObject jSONObject;
        boolean z3;
        if (cVar.J) {
            return;
        }
        io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItemObtainWebviewParent = (io.dcloud.common.adapter.ui.AdaFrameItem) cVar.y;
        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions = adaFrameItemObtainWebviewParent.obtainFrameOptions();
        org.json.JSONObject jSONObject2 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONArray, 0);
        if (!viewOptionsObtainFrameOptions.isTabItem.booleanValue() || jSONObject2.isNull("background")) {
            z = false;
        } else {
            try {
                java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONObject2, "background");
                jSONObject2.remove("background");
                jSONObject2.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TABBG, string);
                z = true;
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
                z = false;
            }
        }
        boolean zA = a(jSONObject2, true);
        boolean zIsNull = jSONObject2.isNull("background");
        if (zIsNull) {
            z2 = false;
        } else {
            java.lang.String lowerCase = io.dcloud.common.util.JSONUtil.getString(jSONObject2, "background").toLowerCase(java.util.Locale.ENGLISH);
            if (android.text.TextUtils.isEmpty(lowerCase) || !lowerCase.equals("transparent")) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (!jSONObject2.isNull(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_WEBBG_TRANSPARENT) && io.dcloud.common.util.JSONUtil.getBoolean(jSONObject2, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_WEBBG_TRANSPARENT)) {
            ((io.dcloud.common.adapter.ui.AdaWebview) cVar.y.obtainWebView()).setBgcolor(0);
        }
        if (cVar.K || (!zIsNull && !z2)) {
            if (zIsNull) {
                c = 0;
            } else {
                try {
                    java.lang.String string2 = io.dcloud.common.util.JSONUtil.getString(jSONObject2, "background");
                    if (jSONObject2.isNull(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ANIMATION_ALPHA_BG)) {
                        c = 0;
                    } else {
                        c = 0;
                        try {
                            viewOptionsObtainFrameOptions.mJsonViewOption.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ANIMATION_ALPHA_BG, io.dcloud.common.util.JSONUtil.getString(jSONObject2, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ANIMATION_ALPHA_BG));
                        } catch (org.json.JSONException e3) {
                            e = e3;
                            e.printStackTrace();
                        }
                    }
                    viewOptionsObtainFrameOptions.mJsonViewOption.put("background", string2);
                    if (jSONObject2.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_DEBUG_REFRESH)) {
                        viewOptionsObtainFrameOptions.mJsonViewOption.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_DEBUG_REFRESH, io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject2, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_DEBUG_REFRESH));
                    }
                    if (jSONObject2.has("isUniH5")) {
                        viewOptionsObtainFrameOptions.mJsonViewOption.put("isUniH5", io.dcloud.common.util.JSONUtil.getBoolean(jSONObject2, "isUniH5"));
                    }
                    viewOptionsObtainFrameOptions.updateViewData(viewOptionsObtainFrameOptions.mJsonViewOption);
                } catch (org.json.JSONException e4) {
                    e = e4;
                    c = 0;
                }
            }
            org.json.JSONObject jSONObject3 = adaFrameItemObtainWebviewParent.obtainFrameOptions().titleNView != null ? adaFrameItemObtainWebviewParent.obtainFrameOptions().titleNView : null;
            adaFrameItemObtainWebviewParent = cVar.y.obtainWebviewParent();
            if (jSONObject3 != null && adaFrameItemObtainWebviewParent.obtainFrameOptions().titleNView == null) {
                adaFrameItemObtainWebviewParent.obtainFrameOptions().titleNView = jSONObject3;
            }
            if (adaFrameItemObtainWebviewParent.obtainFrameOptions().getParentViewRect() == null) {
                io.dcloud.common.DHInterface.AbsMgr absMgr = this.c.d;
                io.dcloud.common.DHInterface.IMgr.MgrType mgrType = io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr;
                java.lang.Object[] objArr = new java.lang.Object[1];
                objArr[c] = cVar.y;
                absMgr.processEvent(mgrType, 74, objArr);
            }
        }
        if (viewOptionsObtainFrameOptions.hasBackground()) {
            adaFrameItemObtainWebviewParent = cVar.y.obtainWebviewParent();
        }
        adaFrameItemObtainWebviewParent.obtainFrameOptions().allowUpdate = true;
        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions2 = adaFrameItemObtainWebviewParent.obtainFrameOptions();
        int i2 = viewOptionsObtainFrameOptions2.maskColor;
        try {
            jSONObject = viewOptionsObtainFrameOptions2.titleNView != null ? new org.json.JSONObject(viewOptionsObtainFrameOptions2.titleNView.toString()) : null;
        } catch (org.json.JSONException e5) {
            e5.printStackTrace();
        }
        io.dcloud.common.adapter.util.ViewOptions viewOptionsCreateViewOptionsData = io.dcloud.common.adapter.util.ViewOptions.createViewOptionsData(viewOptionsObtainFrameOptions2, viewOptionsObtainFrameOptions2.getParentViewRect());
        io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView = this.y.obtainWebView();
        iWebviewObtainWebView.setWebviewProperty(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SHAREABLE, jSONObject2.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SHAREABLE));
        if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject2, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_VIDEO_FULL_SCREEN)) {
            iWebviewObtainWebView.setWebviewProperty(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_VIDEO_FULL_SCREEN, jSONObject2.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_VIDEO_FULL_SCREEN));
        }
        if (jSONObject2.has(io.dcloud.common.constant.AbsoluteConst.EVENTS_PULL_TO_REFRESH)) {
            cVar.y.obtainWebView().setWebViewEvent(io.dcloud.common.constant.AbsoluteConst.PULL_DOWN_REFRESH, io.dcloud.common.util.JSONUtil.combinJSONObject(viewOptionsObtainFrameOptions2.mPullToRefresh, io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject2, io.dcloud.common.constant.AbsoluteConst.EVENTS_PULL_TO_REFRESH)));
        }
        if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject2, "bounce")) {
            iWebviewObtainWebView.setWebviewProperty("bounce", jSONObject2.optString("bounce"));
        }
        iWebview.setWebViewCacheMode(viewOptionsCreateViewOptionsData.mCacheMode);
        io.dcloud.common.util.JSONUtil.combinJSONObject(this.h, jSONObject2);
        f();
        if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject2, "titleNView")) {
            a(iWebview, cVar, jSONObject, jSONObject2.optJSONObject("titleNView"));
        } else if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject2, "navigationbar")) {
            a(iWebview, cVar, jSONObject, jSONObject2.optJSONObject("navigationbar"));
        }
        if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject2, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_UNINVIEW)) {
            a(cVar, jSONObject2.optJSONObject(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_UNINVIEW));
        }
        if (cVar.I) {
            int i3 = viewOptionsCreateViewOptionsData.background;
            float f2 = viewOptionsCreateViewOptionsData.opacity;
            boolean zUpdateViewData = viewOptionsCreateViewOptionsData.updateViewData(jSONObject2);
            z3 = z;
            boolean z4 = (io.dcloud.common.util.PdrUtil.checkAlphaTransparent(i3) != io.dcloud.common.util.PdrUtil.checkAlphaTransparent(viewOptionsCreateViewOptionsData.background)) | (f2 != viewOptionsCreateViewOptionsData.opacity);
            if (jSONObject2.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_RENDER)) {
                cVar.y.setNeedRender(io.dcloud.common.util.PdrUtil.isEquals(jSONObject2.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_RENDER, "onscreen"), "always"));
            }
            cVar.K = viewOptionsCreateViewOptionsData.hasBackground();
            if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject2, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SCROLLINDICATOR)) {
                iWebviewObtainWebView.setScrollIndicator(viewOptionsCreateViewOptionsData.getScrollIndicator());
            }
            if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject2, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SCALABLE)) {
                iWebviewObtainWebView.setWebviewProperty(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SCALABLE, java.lang.String.valueOf(viewOptionsCreateViewOptionsData.scalable));
            }
            iWebviewObtainWebView.setWebviewProperty("injection", viewOptionsCreateViewOptionsData.mInjection);
            iWebviewObtainWebView.setWebviewProperty("plusrequire", viewOptionsCreateViewOptionsData.mPlusrequire);
            iWebviewObtainWebView.setWebviewProperty("geolocation", viewOptionsCreateViewOptionsData.mGeoInject);
            io.dcloud.common.adapter.util.AnimOptions animOptions = adaFrameItemObtainWebviewParent.getAnimOptions();
            if (io.dcloud.common.util.JSONUtil.isNull(jSONObject2, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TRANSITION)) {
                animOptions.duration = 0;
            } else {
                animOptions.parseTransition(viewOptionsCreateViewOptionsData.transition);
                if (viewOptionsCreateViewOptionsData.transition.isNull("duration")) {
                    animOptions.duration = 0;
                }
            }
            if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject2, "transform")) {
                animOptions.parseTransform(viewOptionsCreateViewOptionsData.transform);
            }
            if (zUpdateViewData || zA || z4) {
                this.y.setFrameOptions_Animate(viewOptionsCreateViewOptionsData);
                adaFrameItemObtainWebviewParent.setFrameOptions_Animate(viewOptionsCreateViewOptionsData);
                ((io.dcloud.common.adapter.ui.AdaFrameItem) cVar.y).getAnimOptions().mOption = (byte) 2;
                io.dcloud.common.DHInterface.IFrameView iFrameView = cVar.y;
                java.lang.Boolean boolValueOf = java.lang.Boolean.valueOf(zUpdateViewData);
                if (zUpdateViewData) {
                    zA = false;
                }
                this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 7, new java.lang.Object[]{iFrameView, boolValueOf, java.lang.Boolean.valueOf(zA), java.lang.Boolean.valueOf(z4)});
            } else {
                viewOptionsObtainFrameOptions2.updateViewData(jSONObject2);
                if (i2 != viewOptionsCreateViewOptionsData.maskColor) {
                    adaFrameItemObtainWebviewParent.obtainFrameOptions().maskColor = viewOptionsCreateViewOptionsData.maskColor;
                    ((io.dcloud.common.adapter.ui.AdaFrameView) cVar.y).obtainFrameOptions().maskColor = viewOptionsCreateViewOptionsData.maskColor;
                    ((io.dcloud.common.adapter.ui.AdaFrameView) cVar.y).obtainMainView().invalidate();
                }
            }
        } else {
            z3 = z;
            boolean zUpdateViewData2 = adaFrameItemObtainWebviewParent.obtainFrameOptions().updateViewData(jSONObject2);
            adaFrameItemObtainWebviewParent.obtainFrameOptions_Birth().updateViewData(jSONObject2);
            io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions3 = adaFrameItemObtainWebviewParent.obtainFrameOptions();
            iWebviewObtainWebView.setScrollIndicator(viewOptionsObtainFrameOptions3.getScrollIndicator());
            iWebviewObtainWebView.setWebviewProperty(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SCALABLE, java.lang.String.valueOf(viewOptionsObtainFrameOptions3.scalable));
            iWebviewObtainWebView.setWebviewProperty("injection", viewOptionsCreateViewOptionsData.mInjection);
            iWebviewObtainWebView.setWebviewProperty("plusrequire", viewOptionsCreateViewOptionsData.mPlusrequire);
            iWebviewObtainWebView.setWebviewProperty("geolocation", viewOptionsCreateViewOptionsData.mGeoInject);
            if (zUpdateViewData2) {
                io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions4 = adaFrameItemObtainWebviewParent.obtainFrameOptions();
                int i4 = viewOptionsObtainFrameOptions4.left;
                io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.setViewLayoutParams(cVar.y.obtainMainView(), viewOptionsObtainFrameOptions4.left, viewOptionsObtainFrameOptions4.top, viewOptionsObtainFrameOptions4.width, viewOptionsObtainFrameOptions4.height);
            }
        }
        if (!zIsNull || z3) {
            this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 75, new java.lang.Object[]{cVar.y});
        }
    }

    public boolean b(io.dcloud.feature.ui.b bVar) {
        java.util.ArrayList arrayList = this.M;
        if (arrayList == null) {
            return false;
        }
        return arrayList.contains(bVar);
    }

    @Override // io.dcloud.feature.ui.b
    public io.dcloud.common.adapter.ui.AdaFrameItem d() {
        return (io.dcloud.common.adapter.ui.AdaFrameItem) this.y;
    }

    @Override // io.dcloud.feature.ui.b
    public java.lang.String h() {
        if (io.dcloud.common.util.PdrUtil.isEmpty(r().obtainFrameId())) {
            java.lang.String str = this.e;
            java.lang.String str2 = this.d;
            org.json.JSONObject jSONObject = this.x;
            return io.dcloud.common.util.StringUtil.format("(function(){return {'uuid':'%s','id':%s,'identity':'%s','extras':%s}})()", str, com.taobao.weex.common.Constants.Name.UNDEFINED, str2, jSONObject != null ? jSONObject.toString() : "{}");
        }
        java.lang.String str3 = this.e;
        java.lang.String strObtainFrameId = r().obtainFrameId();
        java.lang.String str4 = this.d;
        org.json.JSONObject jSONObject2 = this.x;
        return io.dcloud.common.util.StringUtil.format("(function(){return {'uuid':'%s','id':'%s','identity':'%s','extras':%s}})()", str3, strObtainFrameId, str4, jSONObject2 != null ? jSONObject2.toString() : "{}");
    }

    private void d(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray, io.dcloud.feature.ui.c cVar) {
        java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONArray, 0);
        java.lang.String string2 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 1);
        io.dcloud.common.adapter.util.AnimOptions animOptions = ((io.dcloud.common.adapter.ui.AdaFrameItem) cVar.y).getAnimOptions();
        if (!io.dcloud.common.util.PdrUtil.isEmpty(string2)) {
            animOptions.duration_close = io.dcloud.common.util.PdrUtil.parseInt(string2, animOptions.duration_close);
        } else {
            animOptions.duration_close = animOptions.duration_show;
        }
        animOptions.setCloseAnimType(string);
        animOptions.mOption = (byte) 3;
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.VIEW_VISIBLE_TAG, "NWindow.hide view=" + cVar.d());
        if (cVar.F) {
            if (cVar.k()) {
                a(iWebview, io.dcloud.common.util.JSONUtil.getJSONObject(jSONArray, 2), cVar, string);
                this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 23, cVar.y);
            } else {
                onCallBack("hide", null);
                cVar.y.setVisible(false, true);
            }
            cVar.F = false;
        } else {
            cVar.y.setVisible(false, true);
        }
        cVar.G = true;
    }

    public void a(boolean z) {
        this.b0 = z;
    }

    public void a(io.dcloud.common.DHInterface.IFrameView iFrameView, java.lang.String str) {
        if (iFrameView != null) {
            this.y = iFrameView;
            io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView = iFrameView.obtainWebView();
            if (iWebviewObtainWebView != null) {
                iWebviewObtainWebView.initWebviewUUID(this.e);
                iWebviewObtainWebView.setFrameId(str);
            }
        }
    }

    protected void b(io.dcloud.feature.ui.c cVar) {
        if (this.X == null) {
            this.X = new java.util.ArrayList();
        }
        this.X.add(cVar);
        cVar.W = this;
        if (cVar.r() != null) {
            cVar.r().setOpener(r());
        }
    }

    protected void c(io.dcloud.feature.ui.b bVar) {
        java.util.ArrayList arrayList = this.M;
        if (arrayList == null || !arrayList.contains(bVar)) {
            return;
        }
        this.M.remove(bVar);
        bVar.a = null;
        byte bC = bVar.c();
        boolean z = bVar instanceof io.dcloud.feature.ui.c;
        if (bC == io.dcloud.feature.ui.b.n) {
            this.y.obtainWebView().removeFrameItem(bVar.d());
            return;
        }
        if (bC == io.dcloud.feature.ui.b.o) {
            this.y.obtainWebviewParent().removeFrameItem(bVar.d());
        } else if (bC == io.dcloud.feature.ui.b.p) {
            this.y.removeFrameItem(bVar.d());
            if (z) {
                this.y.obtainWebviewParent().obtainFrameOptions().delRelViewRect(bVar.d().obtainFrameOptions());
            }
            d().resize();
        }
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
    protected void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebview, "ad", "addNativeView", new java.lang.Object[]{this.y, str}});
    }

    /* JADX WARN: Code duplicated, block: B:100:0x024d  */
    /* JADX WARN: Code duplicated, block: B:103:0x0273  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:43:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:50:0x0117  */
    /* JADX WARN: Code duplicated, block: B:52:0x0126  */
    /* JADX WARN: Code duplicated, block: B:53:0x012f  */
    /* JADX WARN: Code duplicated, block: B:56:0x013c  */
    /* JADX WARN: Code duplicated, block: B:62:0x0165  */
    /* JADX WARN: Code duplicated, block: B:67:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:74:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:90:0x0231  */
    /* JADX WARN: Code duplicated, block: B:98:0x0244  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0, types: [io.dcloud.common.DHInterface.IContainerView] */
    protected void a(io.dcloud.feature.ui.b bVar) {
        boolean z;
        org.json.JSONObject jSONObject;
        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions;
        io.dcloud.common.adapter.ui.AdaWebViewParent adaWebViewParentObtainWebviewParent;
        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions2;
        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions3;
        ?? r16;
        int i2;
        int i3;
        int i4;
        int i5;
        io.dcloud.common.adapter.ui.AdaContainerFrameItem adaContainerFrameItem;
        java.lang.String titleNViewId;
        java.lang.Object titleNView;
        int i6;
        int iConvertToScreenInt;
        org.json.JSONObject jSONObject2;
        int i7;
        int i8;
        int i9;
        if (this.M == null) {
            this.M = new java.util.ArrayList(2);
        }
        io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItemD = bVar.d();
        byte bC = bVar.c();
        if (bC == io.dcloud.common.adapter.util.ViewRect.POSITION_DOCK) {
            adaFrameItemD.setPosition(bVar.b());
        } else {
            adaFrameItemD.setPosition(bC);
        }
        if (this.M.contains(bVar)) {
            return;
        }
        java.lang.Object objObtainWebView = null;
        if (bVar instanceof io.dcloud.feature.ui.c) {
            io.dcloud.feature.ui.c cVar = (io.dcloud.feature.ui.c) bVar;
            a(bVar, cVar);
            if (this.c.a(cVar) && this.F) {
                cVar.A = 4;
                this.c.f(cVar);
            }
            if (bVar.d().obtainMainView().getVisibility() != 0 && !cVar.G) {
                cVar.F = true;
                cVar.y.setVisible(true, true);
                io.dcloud.common.DHInterface.IFrameView iFrameView = cVar.y;
                if (iFrameView instanceof io.dcloud.common.adapter.ui.AdaFrameView) {
                    ((io.dcloud.common.adapter.ui.AdaFrameView) iFrameView).dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_CHILD_INITIALIZE_SHOW, null);
                }
                io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.VIEW_VISIBLE_TAG, "NWindow.appendView childView set visible true");
            }
            this.c.c(cVar.y);
            io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.VIEW_VISIBLE_TAG, "append " + cVar.y);
            cVar.L = true;
            cVar.I = true;
            if (cVar.r() != null && io.dcloud.common.util.BaseInfo.isUniAppAppid(cVar.r().obtainApp())) {
                cVar.r().setIWebViewFocusable(true);
            }
        } else {
            if (bVar instanceof io.dcloud.feature.ui.d) {
                io.dcloud.feature.ui.d dVar = (io.dcloud.feature.ui.d) bVar;
                dVar.i();
                dVar.a(true);
            } else {
                z = false;
            }
            jSONObject = bVar.h;
            viewOptionsObtainFrameOptions = ((io.dcloud.common.adapter.ui.AdaFrameItem) this.y).obtainFrameOptions();
            adaWebViewParentObtainWebviewParent = this.y.obtainWebviewParent();
            viewOptionsObtainFrameOptions2 = adaWebViewParentObtainWebviewParent.obtainFrameOptions();
            viewOptionsObtainFrameOptions3 = adaFrameItemD.obtainFrameOptions();
            if (bC == io.dcloud.feature.ui.b.p) {
                objObtainWebView = this.y;
                viewOptionsObtainFrameOptions2.setParentViewRect(viewOptionsObtainFrameOptions.getParentViewRect());
                viewOptionsObtainFrameOptions2.updateViewData(viewOptionsObtainFrameOptions);
            } else {
                if (bC == io.dcloud.feature.ui.b.o) {
                    objObtainWebView = this.y;
                } else if (bC == io.dcloud.feature.ui.b.n) {
                    objObtainWebView = this.y.obtainWebView();
                }
                viewOptionsObtainFrameOptions3.setParentViewRect(((io.dcloud.common.adapter.ui.AdaFrameView) this.y).obtainFrameOptions());
            }
            r16 = objObtainWebView;
            if (viewOptionsObtainFrameOptions.hasBackground()) {
                viewOptionsObtainFrameOptions3.updateViewData(jSONObject, viewOptionsObtainFrameOptions2.width, viewOptionsObtainFrameOptions2.height, viewOptionsObtainFrameOptions2.mWebviewScale);
                if (viewOptionsObtainFrameOptions3.hasBackground()) {
                    viewOptionsObtainFrameOptions3.left = 0;
                    viewOptionsObtainFrameOptions3.top = 0;
                    viewOptionsObtainFrameOptions3.anim_top = 0;
                    viewOptionsObtainFrameOptions3.anim_left = 0;
                }
            } else {
                viewOptionsObtainFrameOptions3.updateViewData(jSONObject, viewOptionsObtainFrameOptions.width, viewOptionsObtainFrameOptions.height, viewOptionsObtainFrameOptions.mWebviewScale);
            }
            if (bC == io.dcloud.feature.ui.b.p) {
                viewOptionsObtainFrameOptions3.setParentViewRect(((io.dcloud.common.adapter.ui.AdaFrameItem) r16).obtainFrameOptions());
                io.dcloud.common.adapter.util.ViewRect.layoutDockViewRect(viewOptionsObtainFrameOptions2, viewOptionsObtainFrameOptions3);
                adaWebViewParentObtainWebviewParent.mNeedOrientationUpdate = true;
                viewOptionsObtainFrameOptions2.putRelViewRect(viewOptionsObtainFrameOptions3);
                int i10 = viewOptionsObtainFrameOptions2.left;
                i8 = viewOptionsObtainFrameOptions2.top;
                int i11 = viewOptionsObtainFrameOptions2.width;
                i9 = viewOptionsObtainFrameOptions2.height;
                if (io.dcloud.common.util.BaseInfo.isImmersive && viewOptionsObtainFrameOptions2.isStatusbar) {
                    if (!viewOptionsObtainFrameOptions.isHeightAbsolute()) {
                        i9 += io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
                    }
                    i8 += io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
                }
                io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.VIEW_VISIBLE_TAG, "NWindow.appendView ---> _webview left=" + i10 + ";top=" + i8 + ";width=" + i11 + ";height=" + i9);
                io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.setViewLayoutParams(adaWebViewParentObtainWebviewParent.obtainMainView(), i10, i8, i11, i9);
            }
            i2 = viewOptionsObtainFrameOptions3.width;
            i3 = viewOptionsObtainFrameOptions3.height;
            i4 = viewOptionsObtainFrameOptions3.left;
            i5 = viewOptionsObtainFrameOptions3.top;
            bVar.a(viewOptionsObtainFrameOptions2.left, viewOptionsObtainFrameOptions2.top, viewOptionsObtainFrameOptions2.width, viewOptionsObtainFrameOptions2.height, i2, i3);
            io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.VIEW_VISIBLE_TAG, "NWindow.appendView childView=" + bVar.d());
            adaContainerFrameItem = (io.dcloud.common.adapter.ui.AdaContainerFrameItem) r16;
            adaFrameItemD.setParentFrameItem(adaContainerFrameItem);
            if (z) {
                if (bC == io.dcloud.feature.ui.b.n || viewOptionsObtainFrameOptions3.hasHeightAbsolutevalue() || (i7 = viewOptionsObtainFrameOptions2.height) <= 0) {
                    i6 = i3;
                } else {
                    i6 = i7;
                }
                a(r16, adaFrameItemD, adaFrameItemD.obtainMainView().getLayoutParams(), i4, i5, i2, i6);
                iConvertToScreenInt = i5;
                if (bC == io.dcloud.feature.ui.b.p && bVar.b() == io.dcloud.feature.ui.b.s && (jSONObject2 = viewOptionsObtainFrameOptions.titleNView) != null && io.dcloud.common.util.TitleNViewUtil.isTitleTypeForDef(jSONObject2)) {
                    iConvertToScreenInt += io.dcloud.common.util.PdrUtil.convertToScreenInt("44px", 0, 0, this.y.obtainWebView().getScale());
                }
                if (!viewOptionsObtainFrameOptions3.isStatusbar && viewOptionsObtainFrameOptions.isStatusbar) {
                    iConvertToScreenInt += io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
                    if (viewOptionsObtainFrameOptions3.isBottomAbsolute()) {
                        i6 -= io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
                    }
                }
                if (viewOptionsObtainFrameOptions3.isStatusbar && !viewOptionsObtainFrameOptions3.isBottomAbsolute()) {
                    i6 += io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
                }
                if (i6 < -1) {
                    i6 = -1;
                }
                io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.setViewLayoutParams(adaFrameItemD.obtainMainView(), i4, iConvertToScreenInt, i2, i6);
            } else {
                r16.addFrameItem(bVar.d(), io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.createLayoutParams(i4, i5, i2, i3));
            }
            this.M.add(bVar);
            bVar.a = this;
            ((io.dcloud.common.adapter.ui.AdaFrameView) this.y).sortNativeViewBringToFront();
            if (adaContainerFrameItem.obtainFrameOptions().isStatusbar) {
                bVar.d().resize();
            }
            titleNViewId = io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(this.y);
            if (io.dcloud.common.util.PdrUtil.isEmpty(titleNViewId) && (titleNView = io.dcloud.common.util.TitleNViewUtil.getTitleNView(this.c.d, this.y.obtainWebView(), this.y, titleNViewId)) != null && (titleNView instanceof io.dcloud.common.DHInterface.ITitleNView)) {
                ((io.dcloud.common.DHInterface.ITitleNView) titleNView).reMeasure();
                return;
            }
            return;
        }
        z = true;
        jSONObject = bVar.h;
        viewOptionsObtainFrameOptions = ((io.dcloud.common.adapter.ui.AdaFrameItem) this.y).obtainFrameOptions();
        adaWebViewParentObtainWebviewParent = this.y.obtainWebviewParent();
        viewOptionsObtainFrameOptions2 = adaWebViewParentObtainWebviewParent.obtainFrameOptions();
        viewOptionsObtainFrameOptions3 = adaFrameItemD.obtainFrameOptions();
        if (bC == io.dcloud.feature.ui.b.p) {
            objObtainWebView = this.y;
            viewOptionsObtainFrameOptions2.setParentViewRect(viewOptionsObtainFrameOptions.getParentViewRect());
            viewOptionsObtainFrameOptions2.updateViewData(viewOptionsObtainFrameOptions);
        } else {
            if (bC == io.dcloud.feature.ui.b.o) {
                objObtainWebView = this.y;
            } else if (bC == io.dcloud.feature.ui.b.n) {
                objObtainWebView = this.y.obtainWebView();
            }
            viewOptionsObtainFrameOptions3.setParentViewRect(((io.dcloud.common.adapter.ui.AdaFrameView) this.y).obtainFrameOptions());
        }
        r16 = objObtainWebView;
        if (viewOptionsObtainFrameOptions.hasBackground()) {
            viewOptionsObtainFrameOptions3.updateViewData(jSONObject, viewOptionsObtainFrameOptions2.width, viewOptionsObtainFrameOptions2.height, viewOptionsObtainFrameOptions2.mWebviewScale);
            if (viewOptionsObtainFrameOptions3.hasBackground()) {
                viewOptionsObtainFrameOptions3.left = 0;
                viewOptionsObtainFrameOptions3.top = 0;
                viewOptionsObtainFrameOptions3.anim_top = 0;
                viewOptionsObtainFrameOptions3.anim_left = 0;
            }
        } else {
            viewOptionsObtainFrameOptions3.updateViewData(jSONObject, viewOptionsObtainFrameOptions.width, viewOptionsObtainFrameOptions.height, viewOptionsObtainFrameOptions.mWebviewScale);
        }
        if (bC == io.dcloud.feature.ui.b.p) {
            viewOptionsObtainFrameOptions3.setParentViewRect(((io.dcloud.common.adapter.ui.AdaFrameItem) r16).obtainFrameOptions());
            io.dcloud.common.adapter.util.ViewRect.layoutDockViewRect(viewOptionsObtainFrameOptions2, viewOptionsObtainFrameOptions3);
            adaWebViewParentObtainWebviewParent.mNeedOrientationUpdate = true;
            viewOptionsObtainFrameOptions2.putRelViewRect(viewOptionsObtainFrameOptions3);
            int i12 = viewOptionsObtainFrameOptions2.left;
            i8 = viewOptionsObtainFrameOptions2.top;
            int i13 = viewOptionsObtainFrameOptions2.width;
            i9 = viewOptionsObtainFrameOptions2.height;
            if (io.dcloud.common.util.BaseInfo.isImmersive) {
                if (!viewOptionsObtainFrameOptions.isHeightAbsolute()) {
                    i9 += io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
                }
                i8 += io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
            }
            io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.VIEW_VISIBLE_TAG, "NWindow.appendView ---> _webview left=" + i12 + ";top=" + i8 + ";width=" + i13 + ";height=" + i9);
            io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.setViewLayoutParams(adaWebViewParentObtainWebviewParent.obtainMainView(), i12, i8, i13, i9);
        }
        i2 = viewOptionsObtainFrameOptions3.width;
        i3 = viewOptionsObtainFrameOptions3.height;
        i4 = viewOptionsObtainFrameOptions3.left;
        i5 = viewOptionsObtainFrameOptions3.top;
        bVar.a(viewOptionsObtainFrameOptions2.left, viewOptionsObtainFrameOptions2.top, viewOptionsObtainFrameOptions2.width, viewOptionsObtainFrameOptions2.height, i2, i3);
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.VIEW_VISIBLE_TAG, "NWindow.appendView childView=" + bVar.d());
        adaContainerFrameItem = (io.dcloud.common.adapter.ui.AdaContainerFrameItem) r16;
        adaFrameItemD.setParentFrameItem(adaContainerFrameItem);
        if (z) {
            if (bC == io.dcloud.feature.ui.b.n) {
                i6 = i3;
            } else {
                i6 = i3;
            }
            a(r16, adaFrameItemD, adaFrameItemD.obtainMainView().getLayoutParams(), i4, i5, i2, i6);
            iConvertToScreenInt = i5;
            if (bC == io.dcloud.feature.ui.b.p) {
                iConvertToScreenInt += io.dcloud.common.util.PdrUtil.convertToScreenInt("44px", 0, 0, this.y.obtainWebView().getScale());
            }
            if (!viewOptionsObtainFrameOptions3.isStatusbar) {
                iConvertToScreenInt += io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
                if (viewOptionsObtainFrameOptions3.isBottomAbsolute()) {
                    i6 -= io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
                }
            }
            if (viewOptionsObtainFrameOptions3.isStatusbar) {
                i6 += io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight;
            }
            if (i6 < -1) {
                i6 = -1;
            }
            io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.setViewLayoutParams(adaFrameItemD.obtainMainView(), i4, iConvertToScreenInt, i2, i6);
        } else {
            r16.addFrameItem(bVar.d(), io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.createLayoutParams(i4, i5, i2, i3));
        }
        this.M.add(bVar);
        bVar.a = this;
        ((io.dcloud.common.adapter.ui.AdaFrameView) this.y).sortNativeViewBringToFront();
        if (adaContainerFrameItem.obtainFrameOptions().isStatusbar) {
            bVar.d().resize();
        }
        titleNViewId = io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(this.y);
        if (io.dcloud.common.util.PdrUtil.isEmpty(titleNViewId)) {
        }
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
    protected void b(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebview, "barcode", "appendToFrameView", new java.lang.Object[]{this.y, str}});
    }

    void b(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray, io.dcloud.feature.ui.c cVar) {
        if (cVar.I) {
            if (!cVar.J) {
                this.c.b(cVar);
                if (cVar.L) {
                    io.dcloud.feature.ui.c cVar2 = cVar.a;
                    if (cVar2 != null) {
                        cVar2.c(cVar);
                    }
                    cVar.d().onDispose();
                    cVar.d().dispose();
                } else {
                    java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONArray, 0);
                    java.lang.String string2 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 1);
                    io.dcloud.common.adapter.util.AnimOptions animOptions = ((io.dcloud.common.adapter.ui.AdaFrameItem) cVar.y).getAnimOptions();
                    if (io.dcloud.common.util.PdrUtil.isEmpty(string)) {
                        string = "auto";
                    }
                    if (!io.dcloud.common.util.PdrUtil.isEmpty(string2)) {
                        animOptions.duration_close = io.dcloud.common.util.PdrUtil.parseInt(string2, animOptions.duration_close);
                    } else if (string.equals(io.dcloud.common.adapter.util.AnimOptions.ANIM_POP_OUT)) {
                        animOptions.duration_close = 360;
                    } else {
                        animOptions.duration_close = animOptions.duration_show;
                    }
                    animOptions.setCloseAnimType(string);
                    animOptions.mOption = (byte) 1;
                    a(iWebview, io.dcloud.common.util.JSONUtil.getJSONObject(jSONArray, 2), cVar, string);
                    this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 2, cVar.y);
                }
            }
        } else {
            this.c.b(cVar);
            cVar.d().onDispose();
            cVar.d().dispose();
        }
        cVar.e();
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
    protected void c(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebview, "livepusher", "appendToFrameView", new java.lang.Object[]{this.y, str}});
    }

    private void c(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray, io.dcloud.feature.ui.c cVar) {
        java.lang.String str;
        boolean z;
        boolean z2;
        boolean z3;
        android.graphics.Rect rect;
        java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONArray, 0);
        java.lang.String string2 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 1);
        android.view.View viewObtainMainView = this.c.a(string2, string2, (java.lang.String) null).d().obtainMainView();
        java.lang.String string3 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 2);
        org.json.JSONObject jSONObject = io.dcloud.common.util.JSONUtil.getJSONObject(jSONArray, 3);
        if (jSONObject != null) {
            boolean zOptBoolean = jSONObject.optBoolean("check", false);
            boolean zOptBoolean2 = jSONObject.optBoolean("checkKeyboard", false);
            boolean zOptBoolean3 = jSONObject.optBoolean("wholeContent");
            java.lang.String strOptString = jSONObject.optString("bit", "RGB565");
            org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("clip");
            if (jSONObjectOptJSONObject != null) {
                int width = viewObtainMainView.getWidth();
                int height = viewObtainMainView.getHeight();
                float scale = iWebview.getScale();
                android.graphics.Rect rect2 = new android.graphics.Rect(io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObjectOptJSONObject.optString("left"), width, 0, scale), io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObjectOptJSONObject.optString("top"), height, 0, scale), io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObjectOptJSONObject.optString("width"), width, width, scale), io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObjectOptJSONObject.optString("height"), height, height, scale));
                str = strOptString;
                z3 = zOptBoolean3;
                rect = rect2;
                z = zOptBoolean;
                z2 = zOptBoolean2;
            } else {
                str = strOptString;
                z2 = zOptBoolean2;
                z3 = zOptBoolean3;
                rect = null;
                z = zOptBoolean;
            }
        } else {
            str = "RGB565";
            z = false;
            z2 = false;
            z3 = false;
            rect = null;
        }
        iWebview.obtainFrameView().draw(viewObtainMainView, g(iWebview, string), z, z2, z3, rect, str, android.text.TextUtils.isEmpty(string3) ? null : new io.dcloud.feature.ui.c.h(iWebview, string3), android.text.TextUtils.isEmpty(string3) ? null : new io.dcloud.feature.ui.c.i(iWebview, string3));
    }

    boolean b(java.lang.String str, java.lang.String str2, boolean z) {
        java.util.ArrayList arrayList = this.M;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                io.dcloud.feature.ui.b bVar = (io.dcloud.feature.ui.b) this.M.get(size);
                if (bVar instanceof io.dcloud.feature.ui.c) {
                    io.dcloud.feature.ui.c cVar = (io.dcloud.feature.ui.c) bVar;
                    if (cVar.F && cVar.b(str, str2, z)) {
                        return true;
                    }
                }
            }
        }
        return a(str) && a(str, str2, z);
    }

    boolean c(java.lang.String str, java.lang.String str2, boolean z) {
        java.util.ArrayList arrayList = this.M;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                io.dcloud.feature.ui.b bVar = (io.dcloud.feature.ui.b) this.M.get(size);
                if (bVar instanceof io.dcloud.feature.ui.c) {
                    io.dcloud.feature.ui.c cVar = (io.dcloud.feature.ui.c) bVar;
                    if (cVar.F && cVar.c(str, str2, z)) {
                        return true;
                    }
                }
            }
        }
        if (a(str)) {
            return a(str, str2, z);
        }
        io.dcloud.common.DHInterface.IFrameView iFrameView = this.y;
        if (iFrameView instanceof io.dcloud.common.adapter.ui.AdaFrameView) {
            java.lang.String str3 = ((io.dcloud.common.adapter.ui.AdaFrameView) iFrameView).obtainFrameOptions().historyBack;
            if ((str3.equals("backButton") || str3.equals("all")) && this.y.obtainWebView() != null && this.y.obtainWebView().canGoBack()) {
                this.y.obtainWebView().goBackOrForward(-1);
                return true;
            }
        }
        if ("hide".equals(d().obtainFrameOptions().backButtonAutoControl)) {
            d(this.y.obtainWebView(), io.dcloud.common.util.JSONUtil.createJSONArray("['auto',null]"), this);
            return true;
        }
        if ("quit".equals(d().obtainFrameOptions().backButtonAutoControl)) {
            this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 20, this.y.obtainApp());
            return false;
        }
        if (!io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE.equals(d().obtainFrameOptions().backButtonAutoControl)) {
            return false;
        }
        b(this.y.obtainWebView(), io.dcloud.common.util.JSONUtil.createJSONArray("['auto',null]"), this);
        return true;
    }

    boolean b(java.lang.String str) {
        java.util.ArrayList arrayList = this.M;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                io.dcloud.feature.ui.b bVar = (io.dcloud.feature.ui.b) this.M.get(size);
                if ((bVar instanceof io.dcloud.feature.ui.c) && ((io.dcloud.feature.ui.c) bVar).a(str)) {
                    return true;
                }
            }
        }
        return a(str);
    }

    private void a(io.dcloud.feature.ui.b bVar, io.dcloud.feature.ui.c cVar) {
        if (!io.dcloud.common.util.BaseInfo.isBase(bVar.a()) || this.z.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL) || this.z.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTPS_PROTOCOL) || cVar.z.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL) || cVar.z.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTPS_PROTOCOL) || android.text.TextUtils.isEmpty(this.z) || android.text.TextUtils.isEmpty(cVar.z)) {
            return;
        }
        android.util.Log.i(io.dcloud.common.constant.AbsoluteConst.HBUILDER_TAG, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.FILIATIONLOG, io.dcloud.feature.ui.e.c(io.dcloud.common.adapter.ui.webview.WebResUtil.getHBuilderPrintUrl(cVar.r().obtainApp().convert2RelPath(r().obtainUrl()))), io.dcloud.feature.ui.e.c(io.dcloud.common.adapter.ui.webview.WebResUtil.getHBuilderPrintUrl(cVar.r().obtainUrl()))));
    }

    private static void a(io.dcloud.common.DHInterface.IContainerView iContainerView, io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem, android.view.ViewGroup.LayoutParams layoutParams, int i2, int i3, int i4, int i5) {
        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions = adaFrameItem.obtainFrameOptions();
        viewOptionsObtainFrameOptions.left = i2;
        viewOptionsObtainFrameOptions.top = i3;
        viewOptionsObtainFrameOptions.width = i4;
        viewOptionsObtainFrameOptions.height = i5;
        viewOptionsObtainFrameOptions.commitUpdate2JSONObject();
        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = (io.dcloud.common.adapter.ui.AdaFrameView) adaFrameItem;
        adaFrameView.isChildOfFrameView = true;
        android.view.View viewObtainMainView = adaFrameItem.obtainMainView();
        if (adaFrameView.obtainWebView().isUniWebView()) {
            viewObtainMainView.layout(0, 0, i4, i5);
        } else {
            viewObtainMainView.setTop(0);
            viewObtainMainView.setLeft(0);
        }
        io.dcloud.nineoldandroids.view.ViewHelper.setX(viewObtainMainView, 0.0f);
        io.dcloud.nineoldandroids.view.ViewHelper.setY(viewObtainMainView, 0.0f);
        iContainerView.addFrameItem(adaFrameItem, io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.createLayoutParams(i2, i3, i4, i5));
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.VIEW_VISIBLE_TAG, "appendNWindow Y=" + io.dcloud.nineoldandroids.view.ViewHelper.getY(viewObtainMainView));
    }

    @Override // io.dcloud.feature.ui.b
    protected void e() {
        java.util.ArrayList arrayList;
        i();
        io.dcloud.feature.ui.c cVar = this.W;
        if (cVar != null && (arrayList = cVar.X) != null) {
            arrayList.remove(this);
        }
        this.W = null;
        this.a = null;
        java.util.ArrayList arrayList2 = this.M;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i2 = 0;
            while (i2 < size) {
                java.lang.Object obj = arrayList2.get(i2);
                i2++;
                ((io.dcloud.feature.ui.b) obj).e();
            }
            this.M.clear();
            this.M = null;
        }
        this.P = null;
        this.O = null;
        this.Q = null;
        this.R = null;
        this.a0 = 150;
        this.i = null;
        java.util.HashMap map = this.b;
        if (map != null) {
            map.clear();
        }
    }

    public static synchronized void a(java.lang.String str, java.lang.Object obj, java.util.List list, io.dcloud.feature.ui.c cVar) {
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            io.dcloud.common.util.JSUtil.broadcastWebviewEvent(((io.dcloud.feature.ui.c) it.next()).r(), cVar.e, str, io.dcloud.common.util.JSONUtil.toJSONableString(java.lang.String.valueOf(obj)));
        }
        if (list.contains(cVar)) {
            return;
        }
        io.dcloud.common.util.JSUtil.broadcastWebviewEvent(cVar.r(), cVar.e, str, io.dcloud.common.util.JSONUtil.toJSONableString(java.lang.String.valueOf(obj)));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
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
    @Override // io.dcloud.feature.ui.b
    public java.lang.String a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONArray jSONArray) {
        java.lang.String str2;
        java.lang.Object objProcessEvent;
        org.json.JSONObject json;
        io.dcloud.feature.ui.c cVar;
        io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView;
        java.lang.Object objProcessEvent2;
        io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView2;
        java.util.HashMap<java.lang.String, java.lang.String> map;
        io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView3;
        io.dcloud.common.DHInterface.IWebview iWebview2;
        io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView4;
        try {
            io.dcloud.common.DHInterface.IApp iAppObtainApp = iWebview.obtainFrameView().obtainApp();
            java.lang.String strObtainAppId = iAppObtainApp.obtainAppId();
            str2 = null;
            java.lang.String nonString = "";
            try {
                switch (str.hashCode()) {
                    case -2087705423:
                        if (str.equals("getTitleNView")) {
                            objProcessEvent = this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{this.y.obtainWebView(), "nativeobj", "getNativeView", new java.lang.Object[]{this.y, io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(this.y)}});
                            if (objProcessEvent != null && (objProcessEvent instanceof io.dcloud.common.DHInterface.INativeView) && (json = ((io.dcloud.common.DHInterface.INativeView) objProcessEvent).toJSON()) != null) {
                                return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(json.toString(), false);
                            }
                        }
                        return null;
                    case -2081275691:
                        if (str.equals("canForward")) {
                            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, io.dcloud.common.util.JSONUtil.getString(jSONArray, 0), java.lang.String.valueOf(this.y.obtainWebView().canGoForward()), io.dcloud.common.util.JSUtil.OK, true, false);
                            return null;
                        }
                        return null;
                    case -2051330937:
                        if (str.equals(io.dcloud.common.constant.AbsoluteConst.EVENTS_LISTEN_RESOURCE_LOADING)) {
                            org.json.JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(0);
                            this.S = jSONArray.optString(1);
                            this.T = iWebview;
                            this.y.obtainWebView().setListenResourceLoading(jSONObjectOptJSONObject);
                            return null;
                        }
                        return null;
                    case -2018969440:
                        if (str.equals("setFavoriteOptions")) {
                            this.y.obtainWebView().setWebviewProperty("setFavoriteOptions", jSONArray.getString(0));
                            return null;
                        }
                        return null;
                    case -1815848150:
                        if (str.equals("captureSnapshot")) {
                            a(iWebview, jSONArray, this);
                            return null;
                        }
                        return null;
                    case -1679210541:
                        if (str.equals("setTitleNViewSearchInputFocus")) {
                            java.lang.Object titleNView = io.dcloud.common.util.TitleNViewUtil.getTitleNView(this.c.d, r(), this.y, io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(this.y));
                            if (titleNView instanceof io.dcloud.common.DHInterface.ITitleNView) {
                                io.dcloud.common.util.TitleNViewUtil.setTitleNViewSearchInputFocus((io.dcloud.common.DHInterface.ITitleNView) titleNView, jSONArray.optString(0));
                                return null;
                            }
                        }
                        return null;
                    case -1525164844:
                        if (str.equals("appendPreloadJsFile")) {
                            this.y.obtainWebView().appendPreloadJsFile(this.y.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), io.dcloud.common.util.JSONUtil.getString(jSONArray, 0)));
                            return null;
                        }
                        return null;
                    case -1476587689:
                        if (str.equals("showSoftKeybord")) {
                            io.dcloud.common.DHInterface.IFrameView iFrameView = this.y;
                            if (iFrameView != null && iFrameView.obtainWebView().isUniService()) {
                                io.dcloud.common.adapter.util.DeviceInfo.showIME(this.y.obtainMainView());
                                return null;
                            }
                            io.dcloud.common.adapter.util.DeviceInfo.showIME(this.y.obtainMainView(), true);
                            return null;
                        }
                        return null;
                    case -1428651141:
                        if (str.equals("setRenderedEventOptions")) {
                            org.json.JSONObject jSONObject = io.dcloud.common.util.JSONUtil.getJSONObject(jSONArray, 0);
                            this.Z = jSONObject.optString("type", this.Z);
                            this.a0 = jSONObject.optInt("interval", this.a0);
                            return null;
                        }
                        return null;
                    case -1411068134:
                        if (str.equals("append")) {
                            java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONArray, 1);
                            io.dcloud.feature.ui.b bVarA = this.c.a(string);
                            if (bVarA == null) {
                                bVarA = this.c.a(string, string, (java.lang.String) null);
                            }
                            if (!b(bVarA) && bVarA != null) {
                                a(bVarA);
                                return null;
                            }
                        }
                        return null;
                    case -1389361719:
                        if (str.equals("getNavigationbar")) {
                            objProcessEvent = this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{this.y.obtainWebView(), "nativeobj", "getNativeView", new java.lang.Object[]{this.y, io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(this.y)}});
                            if (objProcessEvent != null) {
                                return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(json.toString(), false);
                            }
                        }
                        return null;
                    case -1295077293:
                        if (str.equals("setSoftinputTemporary")) {
                            io.dcloud.common.core.ui.DCKeyboardManager.getInstance().setHTMLInputRect(this.y.obtainWebView(), jSONArray.getString(0));
                            return null;
                        }
                        return null;
                    case -1291451675:
                        if (str.equals("evalJS")) {
                            java.lang.String string2 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 0);
                            io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView5 = this.y.obtainWebView();
                            java.lang.String string3 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 1);
                            if (!io.dcloud.common.util.PdrUtil.isEmpty(string3)) {
                                string2 = io.dcloud.common.adapter.ui.ReceiveJSValue.registerCallback(string2, new io.dcloud.feature.ui.c.b(iWebview, string3));
                            }
                            iWebviewObtainWebView5.evalJS(string2);
                            return null;
                        }
                        return null;
                    case -1278805514:
                        if (str.equals("setAssistantType")) {
                            r().setAssistantType(jSONArray.getString(0));
                            return null;
                        }
                        return null;
                    case -1263963897:
                        if (str.equals("hideTitleNViewButtonRedDot")) {
                            java.lang.Object titleNView2 = io.dcloud.common.util.TitleNViewUtil.getTitleNView(this.c.d, r(), this.y, io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(this.y));
                            if (titleNView2 instanceof io.dcloud.common.DHInterface.ITitleNView) {
                                io.dcloud.common.util.TitleNViewUtil.titleNViewButtonRedDot((io.dcloud.common.DHInterface.ITitleNView) titleNView2, jSONArray.optJSONObject(0), false);
                                return null;
                            }
                        }
                        return null;
                    case -1263826761:
                        if (str.equals("resetBounce")) {
                            this.y.obtainWebView().endWebViewEvent(io.dcloud.common.constant.AbsoluteConst.BOUNCE_REGISTER);
                            return null;
                        }
                        return null;
                    case -1249348039:
                        if (str.equals("getUrl")) {
                            return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(this.y.obtainWebView().obtainFullUrl(), true);
                        }
                        return null;
                    case -1205263208:
                        if (str.equals("removeFromParent") && (cVar = this.a) != null && cVar.b((io.dcloud.feature.ui.b) this)) {
                            cVar.c(this);
                            return null;
                        }
                        return null;
                    case -1199488876:
                        if (str.equals("setTitleNViewButtonBadge")) {
                            java.lang.Object titleNView3 = io.dcloud.common.util.TitleNViewUtil.getTitleNView(this.c.d, r(), this.y, io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(this.y));
                            if (titleNView3 instanceof io.dcloud.common.DHInterface.ITitleNView) {
                                io.dcloud.common.util.TitleNViewUtil.titleNViewButtonBadge((io.dcloud.common.DHInterface.ITitleNView) titleNView3, jSONArray.optJSONObject(0), true);
                                return null;
                            }
                        }
                        return null;
                    case -1199260532:
                        if (str.equals("setPreloadJsFile")) {
                            java.lang.String string4 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 0);
                            boolean zOptBoolean = jSONArray.optBoolean(1, false);
                            if (!io.dcloud.common.util.PdrUtil.isEmpty(string4)) {
                                this.y.obtainWebView().setPreloadJsFile(this.y.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), string4), zOptBoolean);
                                return null;
                            }
                        }
                        return null;
                    case -1183202654:
                        if (str.equals("setTitleNViewButtonStyle")) {
                            java.lang.Object titleNView4 = io.dcloud.common.util.TitleNViewUtil.getTitleNView(this.c.d, r(), this.y, io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(this.y));
                            if (titleNView4 instanceof io.dcloud.common.DHInterface.ITitleNView) {
                                io.dcloud.common.util.TitleNViewUtil.setTitleNViewButtonStyle((io.dcloud.common.DHInterface.ITitleNView) titleNView4, jSONArray.optString(0), jSONArray.optJSONObject(1), this.y);
                                return null;
                            }
                        }
                        return null;
                    case -1093745411:
                        if (str.equals("interceptTouchEvent")) {
                            this.y.interceptTouchEvent(java.lang.Boolean.valueOf(io.dcloud.common.util.JSONUtil.getString(jSONArray, 0)).booleanValue());
                            return null;
                        }
                        return null;
                    case -1068341284:
                        if (str.equals("checkRenderedContent")) {
                            a(iWebview, jSONArray);
                            return null;
                        }
                        return null;
                    case -1010579351:
                        if (str.equals("opened")) {
                            return a(this.X);
                        }
                        return null;
                    case -1010579337:
                        if (str.equals("opener")) {
                            io.dcloud.feature.ui.c cVar2 = this.W;
                            if (cVar2 == null) {
                                return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(io.dcloud.common.util.StringUtil.format("{'uuid':%s,'id':%s}", com.taobao.weex.common.Constants.Name.UNDEFINED, com.taobao.weex.common.Constants.Name.UNDEFINED), false);
                            }
                            return cVar2.h();
                        }
                        return null;
                    case -995424086:
                        if (str.equals("parent")) {
                            io.dcloud.feature.ui.c cVar3 = this.a;
                            if (cVar3 == null) {
                                return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(io.dcloud.common.util.StringUtil.format("{'uuid':%s,'id':%s}", com.taobao.weex.common.Constants.Name.UNDEFINED, com.taobao.weex.common.Constants.Name.UNDEFINED), false);
                            }
                            return cVar3.h();
                        }
                        return null;
                    case -934641255:
                        if (str.equals(com.taobao.weex.ui.component.WXWeb.RELOAD)) {
                            a(this, io.dcloud.common.util.PdrUtil.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONArray, 0), true, false));
                            return null;
                        }
                        return null;
                    case -934610812:
                        if (str.equals(io.dcloud.common.constant.AbsoluteConst.XML_REMOVE)) {
                            java.lang.String string5 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 0);
                            io.dcloud.feature.ui.b bVarA2 = this.c.a(string5);
                            if (bVarA2 == null) {
                                bVarA2 = this.c.a(string5, string5, (java.lang.String) null);
                            }
                            if (b(bVarA2)) {
                                c(bVarA2);
                                return null;
                            }
                        }
                        return null;
                    case -934426579:
                        if (str.equals(io.dcloud.common.constant.AbsoluteConst.EVENTS_RESUME) && (iWebviewObtainWebView = this.y.obtainWebView()) != null) {
                            iWebviewObtainWebView.resume();
                            return null;
                        }
                        return null;
                    case -898815851:
                        if (str.equals("isHardwareAccelerated")) {
                            return io.dcloud.common.util.JSUtil.wrapJsVar(((io.dcloud.common.adapter.ui.AdaFrameItem) this.y).obtainFrameOptions().mUseHardwave);
                        }
                        return null;
                    case -854558288:
                        if (str.equals("setVisible")) {
                            boolean z = jSONArray.getBoolean(0);
                            this.F = z;
                            this.y.setVisible(z, true);
                            return null;
                        }
                        return null;
                    case -677145915:
                        if (str.equals("forward")) {
                            io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView6 = this.y.obtainWebView();
                            iWebviewObtainWebView6.stopLoading();
                            iWebviewObtainWebView6.goBackOrForward(1);
                            return null;
                        }
                        return null;
                    case -625809843:
                        if (str.equals("addEventListener")) {
                            java.lang.String string6 = jSONArray.getString(0);
                            a(jSONArray.getString(1), string6, (java.lang.String) this.b.get(iWebview.getWebviewANID()));
                            if (!this.y.obtainWebView().unReceiveTitle() && io.dcloud.common.constant.AbsoluteConst.EVENTS_TITLE_UPDATE.equals(string6)) {
                                onCallBack(io.dcloud.common.constant.AbsoluteConst.EVENTS_TITLE_UPDATE, this.y.obtainWebView().getTitle());
                                return null;
                            }
                        }
                        return null;
                    case -566318518:
                        if (str.equals("getSubNViews")) {
                            io.dcloud.common.DHInterface.IFrameView iFrameView2 = this.y;
                            if (iFrameView2 instanceof io.dcloud.common.adapter.ui.AdaFrameView) {
                                io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = (io.dcloud.common.adapter.ui.AdaFrameView) iFrameView2;
                                java.util.ArrayList<io.dcloud.common.DHInterface.INativeView> arrayList = adaFrameView.mChildNativeViewList;
                                if (arrayList != null) {
                                    org.json.JSONArray jSONArray2 = new org.json.JSONArray();
                                    int size = arrayList.size();
                                    int i2 = 0;
                                    while (i2 < size) {
                                        io.dcloud.common.DHInterface.INativeView iNativeView = arrayList.get(i2);
                                        i2++;
                                        jSONArray2.put(iNativeView.toJSON());
                                    }
                                    return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(jSONArray2.toString(), false);
                                }
                                if (adaFrameView.obtainFrameOptions().mSubNViews != null) {
                                    return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(adaFrameView.obtainFrameOptions().mSubNViews.toString(), false);
                                }
                            }
                        }
                        return null;
                    case -541487286:
                        if (str.equals("removeEventListener")) {
                            b(jSONArray.getString(1), jSONArray.getString(0));
                            return null;
                        }
                        return null;
                    case -481402894:
                        if (str.equals("hideSoftKeybord")) {
                            io.dcloud.common.adapter.util.DeviceInfo.hideIME(this.y.obtainMainView());
                            return null;
                        }
                        return null;
                    case -453356751:
                        if (str.equals("clearSnapshot")) {
                            this.y.clearSnapshot(jSONArray.getString(0));
                            return null;
                        }
                        return null;
                    case -410173765:
                        if (str.equals("setContentVisible")) {
                            boolean z2 = jSONArray.getBoolean(0);
                            this.H = z2;
                            ((io.dcloud.common.adapter.ui.AdaFrameItem) this.y.obtainWebView()).setVisibility(z2 ? io.dcloud.common.adapter.ui.AdaFrameItem.VISIBLE : io.dcloud.common.adapter.ui.AdaFrameItem.GONE);
                            this.y.obtainWebviewParent().setBgcolor(-1);
                            return null;
                        }
                        return null;
                    case -400905144:
                        if (str.equals("webview_restore")) {
                            this.y.restore();
                            return null;
                        }
                        return null;
                    case -386427104:
                        if (str.equals("evalJSSync")) {
                            boolean z3 = android.os.Looper.getMainLooper().getThread().getId() == java.lang.Thread.currentThread().getId();
                            java.lang.String string7 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 0);
                            io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView7 = this.y.obtainWebView();
                            if (z3) {
                                io.dcloud.common.adapter.util.MessageHandler.post(new io.dcloud.feature.ui.c.RunnableC0046c(iWebviewObtainWebView7, string7));
                                return null;
                            }
                            java.lang.Object objPostAndWait = io.dcloud.common.adapter.util.MessageHandler.postAndWait(new io.dcloud.feature.ui.c.d(iWebviewObtainWebView7, string7));
                            if (objPostAndWait != null) {
                                return io.dcloud.common.util.JSUtil.wrapJsVar(java.lang.String.valueOf(objPostAndWait));
                            }
                        }
                        return null;
                    case -252003491:
                        if (str.equals("setCssFile")) {
                            java.lang.String string8 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 0);
                            if (!io.dcloud.common.util.PdrUtil.isEmpty(string8)) {
                                this.y.obtainWebView().setCssFile(iAppObtainApp.convert2LocalFullPath(iWebview.obtainFullUrl(), string8), null);
                                return null;
                            }
                        }
                        return null;
                    case -251589874:
                        if (str.equals("setCssText")) {
                            java.lang.String string9 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 0);
                            if (!io.dcloud.common.util.PdrUtil.isEmpty(string9)) {
                                this.y.obtainWebView().setCssFile(null, string9);
                                return null;
                            }
                        }
                        return null;
                    case -155575552:
                        if (str.equals("removeNativeView")) {
                            h(iWebview, io.dcloud.common.util.JSONUtil.getString(jSONArray, 1));
                            return null;
                        }
                        return null;
                    case -113035288:
                        if (str.equals("isVisible")) {
                            return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(java.lang.String.valueOf(this.F), false);
                        }
                        return null;
                    case -41183179:
                        if (str.equals("getShareOptions")) {
                            java.lang.String webviewProperty = this.y.obtainWebView().getWebviewProperty("getShareOptions");
                            if (!android.text.TextUtils.isEmpty(webviewProperty)) {
                                return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(webviewProperty, false);
                            }
                        }
                        return null;
                    case -25924366:
                        if (str.equals("beginPullToRefresh")) {
                            this.y.obtainWebView().setWebViewEvent(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_BEGIN, null);
                            return null;
                        }
                        return null;
                    case 3015911:
                        if (str.equals("back")) {
                            io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView8 = this.y.obtainWebView();
                            iWebviewObtainWebView8.stopLoading();
                            iWebviewObtainWebView8.goBackOrForward(-1);
                            return null;
                        }
                        return null;
                    case 3091764:
                        if (str.equals("drag")) {
                            org.json.JSONObject jSONObject2 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONArray, 0);
                            org.json.JSONObject jSONObject3 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONArray, 1);
                            java.lang.String string10 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 2);
                            java.lang.String string11 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 3);
                            if (jSONObject2 != null && !android.text.TextUtils.isEmpty(io.dcloud.common.util.JSONUtil.getString(jSONObject2, "direction")) && !android.text.TextUtils.isEmpty(io.dcloud.common.util.JSONUtil.getString(jSONObject2, "moveMode"))) {
                                io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions = d().obtainFrameOptions();
                                java.lang.String string12 = io.dcloud.common.util.JSONUtil.getString(jSONObject3, com.taobao.weex.ui.component.WXBasicComponentType.VIEW);
                                io.dcloud.feature.ui.c cVarA = !android.text.TextUtils.isEmpty(string12) ? this.c.a("", string12, string12) : null;
                                android.view.View view = (cVarA == null && (objProcessEvent2 = this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebview, "nativeobj", "getNativeView", new java.lang.Object[]{this.y, string12}})) != null && (objProcessEvent2 instanceof android.view.View)) ? (android.view.View) objProcessEvent2 : null;
                                io.dcloud.feature.ui.c cVarA2 = this.c.a(string10, string10, string10);
                                viewOptionsObtainFrameOptions.setDragData(jSONObject2, jSONObject3, cVarA == null ? null : cVarA.y, cVarA2 == null ? null : cVarA2.y, string11 != null ? string11 : null, view);
                                return null;
                            }
                        }
                        return null;
                    case 3091780:
                        if (str.equals("draw")) {
                            c(iWebview, jSONArray, this);
                            return null;
                        }
                        return null;
                    case 3202370:
                        if (str.equals("hide")) {
                            d(iWebview, jSONArray, this);
                            return null;
                        }
                        return null;
                    case 3327206:
                        if (str.equals("load") && (iWebviewObtainWebView2 = this.y.obtainWebView()) != null) {
                            java.lang.String strObtainUrl = iWebviewObtainWebView2.obtainUrl();
                            java.lang.String string13 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 0);
                            org.json.JSONObject jSONObject4 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONArray, 2);
                            java.lang.String strConvert2WebviewFullPath = iWebviewObtainWebView2.obtainFrameView().obtainApp().convert2WebviewFullPath(iWebviewObtainWebView2.obtainFullUrl(), string13);
                            io.dcloud.common.adapter.util.Logger.d("NWindow.load " + strConvert2WebviewFullPath);
                            if (jSONObject4 == null || jSONObject4.length() <= 0) {
                                map = null;
                            } else {
                                map = new java.util.HashMap<>(jSONObject4.length());
                                java.util.Iterator<java.lang.String> itKeys = jSONObject4.keys();
                                while (itKeys.hasNext()) {
                                    java.lang.String next = itKeys.next();
                                    map.put(next, jSONObject4.optString(next));
                                }
                            }
                            if ((iWebviewObtainWebView2 instanceof io.dcloud.common.adapter.ui.AdaWebview) && ((io.dcloud.common.adapter.ui.AdaWebview) iWebviewObtainWebView2).checkOverrideUrl(strConvert2WebviewFullPath)) {
                                ((io.dcloud.common.adapter.ui.AdaWebview) iWebviewObtainWebView2).mFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_OVERRIDE_URL_LOADING, "{url:'" + strConvert2WebviewFullPath + "'}");
                                return null;
                            }
                            iWebviewObtainWebView2.setLoadURLHeads(string13, map);
                            this.y.obtainWebView().setOriginalUrl(string13);
                            this.y.obtainWebView().reload(strConvert2WebviewFullPath);
                            a(this, strObtainUrl);
                            return null;
                        }
                        return null;
                    case 3529469:
                        if (str.equals(io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBVIEW_SHOW)) {
                            a(iWebview, jSONArray, this, strObtainAppId);
                            return null;
                        }
                        return null;
                    case 3540994:
                        if (str.equals(com.taobao.weex.common.Constants.Value.STOP)) {
                            this.y.obtainWebView().stopLoading();
                            return null;
                        }
                        return null;
                    case 18100665:
                        if (str.equals(io.dcloud.common.constant.AbsoluteConst.EVENTS_OVERRIDE_URL_LOADING)) {
                            org.json.JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(0);
                            this.Q = jSONArray.optString(1);
                            this.R = iWebview;
                            this.y.obtainWebView().setOverrideUrlLoadingData(jSONObjectOptJSONObject2);
                            return null;
                        }
                        return null;
                    case 94746189:
                        if (str.equals("clear")) {
                            this.y.obtainWebView().clearHistory();
                            return null;
                        }
                        return null;
                    case 94756344:
                        if (str.equals(io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE)) {
                            b(iWebview, jSONArray, this);
                            return null;
                        }
                        return null;
                    case 98192778:
                        if (str.equals("setBounce")) {
                            this.y.obtainWebView().setWebViewEvent(io.dcloud.common.constant.AbsoluteConst.BOUNCE_REGISTER, io.dcloud.common.util.JSONUtil.getJSONObject(jSONArray, 0));
                            return null;
                        }
                        return null;
                    case 106440182:
                        if (str.equals("pause") && (iWebviewObtainWebView3 = this.y.obtainWebView()) != null) {
                            iWebviewObtainWebView3.pause();
                            return null;
                        }
                        return null;
                    case 282257047:
                        if (str.equals("showBehind")) {
                            java.lang.String string14 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 1);
                            if (this.c.a(string14) == null) {
                                a(this.c.a(string14, string14, (java.lang.String) null), this, strObtainAppId);
                                return null;
                            }
                        }
                        return null;
                    case 387104256:
                        if (!str.equals("endPullToRefresh")) {
                            return null;
                        }
                        this.y.obtainWebView().endWebViewEvent(io.dcloud.common.constant.AbsoluteConst.PULL_DOWN_REFRESH);
                        return null;
                    case 471261047:
                        iWebview2 = iWebview;
                        if (!str.equals("setOption")) {
                            return null;
                        }
                        e(iWebview2, jSONArray, this);
                        return null;
                    case 509226590:
                        if (!str.equals("getTitleNViewSearchInputText")) {
                            return null;
                        }
                        java.lang.Object titleNView5 = io.dcloud.common.util.TitleNViewUtil.getTitleNView(this.c.d, r(), this.y, io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(this.y));
                        if (titleNView5 instanceof io.dcloud.common.DHInterface.ITitleNView) {
                            return io.dcloud.common.util.JSUtil.wrapJsVar(io.dcloud.common.util.TitleNViewUtil.getTitleNViewSearchInputText((io.dcloud.common.DHInterface.ITitleNView) titleNView5));
                        }
                        return null;
                    case 549228759:
                        if (!str.equals("canBack")) {
                            return null;
                        }
                        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, io.dcloud.common.util.JSONUtil.getString(jSONArray, 0), java.lang.String.valueOf(this.y.obtainWebView().canGoBack()), io.dcloud.common.util.JSUtil.OK, true, false);
                        return null;
                    case 648802871:
                        if (!str.equals("updateSubNViews")) {
                            return null;
                        }
                        io.dcloud.common.DHInterface.IFrameView iFrameView3 = this.y;
                        if (!(iFrameView3 instanceof io.dcloud.common.adapter.ui.AdaFrameView)) {
                            return null;
                        }
                        io.dcloud.common.util.SubNViewsUtil.updateSubNViews((io.dcloud.common.adapter.ui.AdaFrameView) iFrameView3, jSONArray.getJSONArray(0));
                        return null;
                    case 685878123:
                        if (!str.equals("getOption")) {
                            return null;
                        }
                        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions2 = ((io.dcloud.common.adapter.ui.AdaFrameItem) this.y).obtainFrameOptions();
                        if (viewOptionsObtainFrameOptions2.hasBackground()) {
                            viewOptionsObtainFrameOptions2 = this.y.obtainWebviewParent().obtainFrameOptions();
                        }
                        org.json.JSONObject jSONObject5 = new org.json.JSONObject(viewOptionsObtainFrameOptions2.mJsonViewOption.toString());
                        if (jSONObject5.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TABBG)) {
                            java.lang.String string15 = jSONObject5.getString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TABBG);
                            jSONObject5.remove(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TABBG);
                            jSONObject5.put("background", string15);
                        }
                        return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(jSONObject5.toString(), false);
                    case 770098485:
                        if (!str.equals("overrideResourceRequest")) {
                            return null;
                        }
                        this.y.obtainWebView().setOverrideResourceRequest(jSONArray.optJSONArray(0));
                        return null;
                    case 869569345:
                        if (!str.equals("setShareOptions")) {
                            return null;
                        }
                        this.y.obtainWebView().setWebviewProperty("setShareOptions", jSONArray.getString(0));
                        return null;
                    case 1081068728:
                        if (!str.equals("setBlockNetworkImage")) {
                            return null;
                        }
                        r().setWebviewProperty(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_BLOCK_NETWORK_IMAGE, io.dcloud.common.util.JSONUtil.getString(jSONArray, 0));
                        return null;
                    case 1192599283:
                        if (!str.equals("setVolumeButtonEnabled")) {
                            return null;
                        }
                        java.lang.String string16 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 0);
                        if (io.dcloud.common.util.PdrUtil.isEmpty(string16)) {
                            return null;
                        }
                        io.dcloud.common.adapter.util.DeviceInfo.isVolumeButtonEnabled = java.lang.Boolean.valueOf(string16).booleanValue();
                        return null;
                    case 1295982686:
                        if (!str.equals("setFixBottom")) {
                            return null;
                        }
                        io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView9 = this.y.obtainWebView();
                        iWebviewObtainWebView9.setFixBottom((int) (jSONArray.getInt(0) * iWebviewObtainWebView9.getScale()));
                        return null;
                    case 1341702384:
                        if (str.equals("findViewById")) {
                            return c(io.dcloud.common.util.JSONUtil.getString(jSONArray, 0)).h();
                        }
                        return null;
                    case 1348313218:
                        if (!str.equals("showTitleNViewButtonRedDot")) {
                            return null;
                        }
                        java.lang.Object titleNView6 = io.dcloud.common.util.TitleNViewUtil.getTitleNView(this.c.d, r(), this.y, io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(this.y));
                        if (!(titleNView6 instanceof io.dcloud.common.DHInterface.ITitleNView)) {
                            return null;
                        }
                        io.dcloud.common.util.TitleNViewUtil.titleNViewButtonRedDot((io.dcloud.common.DHInterface.ITitleNView) titleNView6, jSONArray.optJSONObject(0), true);
                        return null;
                    case 1355964204:
                        if (!str.equals("getFavoriteOptions")) {
                            return null;
                        }
                        java.lang.String webviewProperty2 = this.y.obtainWebView().getWebviewProperty("getFavoriteOptions");
                        if (android.text.TextUtils.isEmpty(webviewProperty2)) {
                            return null;
                        }
                        return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(webviewProperty2, false);
                    case 1404493423:
                        if (!str.equals("setStyle")) {
                            return null;
                        }
                        iWebview2 = iWebview;
                        e(iWebview2, jSONArray, this);
                        return null;
                    case 1518415382:
                        if (!str.equals("appendNativeView")) {
                            return null;
                        }
                        java.lang.String string17 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 1);
                        java.lang.String string18 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 0);
                        switch (string18.hashCode()) {
                            case -1677935844:
                                if (string18.equals("VideoPlayer")) {
                                    f(iWebview, string17);
                                    j();
                                    return null;
                                }
                                break;
                            case -1515621005:
                                if (string18.equals("LivePusher")) {
                                    c(iWebview, string17);
                                    j();
                                    return null;
                                }
                                break;
                            case -333584256:
                                if (string18.equals("barcode")) {
                                    b(iWebview, string17);
                                    j();
                                    return null;
                                }
                                break;
                            case 2115:
                                if (string18.equals("Ad")) {
                                    a(iWebview, string17);
                                    j();
                                    return null;
                                }
                                break;
                            case 2390711:
                                if (string18.equals(io.dcloud.common.DHInterface.IFeature.F_MAPS)) {
                                    d(iWebview, string17);
                                    j();
                                    return null;
                                }
                                break;
                        }
                        e(iWebview, string17);
                        return null;
                    case 1566068146:
                        if (!str.equals("removeTitleNViewButtonBadge")) {
                            return null;
                        }
                        java.lang.Object titleNView7 = io.dcloud.common.util.TitleNViewUtil.getTitleNView(this.c.d, r(), this.y, io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(this.y));
                        if (!(titleNView7 instanceof io.dcloud.common.DHInterface.ITitleNView)) {
                            return null;
                        }
                        io.dcloud.common.util.TitleNViewUtil.titleNViewButtonBadge((io.dcloud.common.DHInterface.ITitleNView) titleNView7, jSONArray.optJSONObject(0), false);
                        return null;
                    case 1647492569:
                        if (!str.equals("setPullToRefresh")) {
                            return null;
                        }
                        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.VIEW_VISIBLE_TAG, "refreshLoadingViewsSize setPullToRefresh args=" + jSONArray);
                        org.json.JSONObject jSONObject6 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONArray, 0);
                        java.lang.String string19 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 1);
                        if (!io.dcloud.common.util.PdrUtil.isEmpty(string19)) {
                            this.U = string19;
                        }
                        this.y.obtainWebView().setWebViewEvent(io.dcloud.common.constant.AbsoluteConst.PULL_DOWN_REFRESH, jSONObject6);
                        return null;
                    case 1659526655:
                        if (str.equals(com.taobao.weex.ui.component.richtext.node.RichTextNode.CHILDREN)) {
                            return a(this.M);
                        }
                        return null;
                    case 1747355346:
                        if (!str.equals("setTitleNViewSearchInputText")) {
                            return null;
                        }
                        java.lang.Object titleNView8 = io.dcloud.common.util.TitleNViewUtil.getTitleNView(this.c.d, r(), this.y, io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(this.y));
                        if (!(titleNView8 instanceof io.dcloud.common.DHInterface.ITitleNView)) {
                            return null;
                        }
                        io.dcloud.common.util.TitleNViewUtil.setTitleNViewSearchInputText((io.dcloud.common.DHInterface.ITitleNView) titleNView8, jSONArray.optString(0));
                        return null;
                    case 1845118384:
                        if (!str.equals("loadData")) {
                            return null;
                        }
                        java.lang.String string20 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 0);
                        org.json.JSONObject jSONObject7 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONArray, 1);
                        java.lang.String nonString2 = "text/html";
                        java.lang.String nonString3 = "utf-8";
                        if (jSONObject7 != null) {
                            nonString3 = io.dcloud.common.util.PdrUtil.getNonString(jSONObject7.optString("encoding"), "utf-8");
                            nonString2 = io.dcloud.common.util.PdrUtil.getNonString(jSONObject7.optString("mimeType"), "text/html");
                            nonString = io.dcloud.common.util.PdrUtil.getNonString(jSONObject7.optString("baseURL"), "");
                        }
                        this.y.obtainWebView().loadContentData(nonString, string20, nonString2, nonString3);
                        return null;
                    case 1872589777:
                        if (!str.equals("needTouchEvent")) {
                            return null;
                        }
                        this.y.obtainWebView().setWebviewProperty("needTouchEvent", io.dcloud.common.constant.AbsoluteConst.TRUE);
                        return io.dcloud.common.constant.AbsoluteConst.FALSE;
                    case 1939606683:
                        if (!str.equals("webview_animate")) {
                            return null;
                        }
                        this.y.animate(iWebview, io.dcloud.common.util.JSONUtil.getString(jSONArray, 0), io.dcloud.common.util.JSONUtil.getString(jSONArray, 1));
                        return null;
                    case 1966196898:
                        if (str.equals("getTitle")) {
                            return io.dcloud.common.util.Deprecated_JSUtil.wrapJsVar(this.y.obtainWebView().obtainPageTitle(), true);
                        }
                        return null;
                    case 1992686733:
                        if (!str.equals("getMetrics")) {
                            return null;
                        }
                        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, io.dcloud.common.util.JSONUtil.getString(jSONArray, 0), n(), io.dcloud.common.util.JSUtil.OK, true, false);
                        return null;
                    case 2067845868:
                        if (!str.equals("isPause") || (iWebviewObtainWebView4 = this.y.obtainWebView()) == null) {
                            return null;
                        }
                        return io.dcloud.common.util.JSUtil.wrapJsVar(iWebviewObtainWebView4.isPause());
                    default:
                        return null;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                e.printStackTrace();
                return str2;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            str2 = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0071  */
    /* JADX WARN: Code duplicated, block: B:26:0x0084  */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private void a(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        io.dcloud.common.DHInterface.IWebview iWebview2;
        io.dcloud.common.DHInterface.IWebview iWebviewR;
        org.json.JSONObject jSONObject;
        java.lang.String strOptString;
        java.lang.String str;
        android.view.ViewGroup viewGroupObtainWindowView;
        java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONArray, 0);
        java.lang.String string2 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 1);
        io.dcloud.feature.ui.c cVarA = this.c.a(string, string, (java.lang.String) null);
        if (cVarA != null) {
            try {
                if (cVarA.y.obtainMainView().getParent() != null && cVarA.y.obtainMainView().getVisibility() == 0) {
                    iWebview2 = iWebview;
                    iWebviewR = cVarA.r();
                    jSONObject = io.dcloud.common.util.JSONUtil.getJSONObject(jSONArray, 2);
                    strOptString = "auto";
                    if (jSONObject != null && jSONObject.has("type")) {
                        strOptString = jSONObject.optString("type", "auto");
                    }
                    str = strOptString;
                    viewGroupObtainWindowView = iWebviewR.obtainWindowView();
                    if (viewGroupObtainWindowView != null) {
                        viewGroupObtainWindowView.post(new io.dcloud.feature.ui.c.e(iWebviewR, str, iWebview2, string2));
                    }
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                iWebview2 = iWebview;
                e.printStackTrace();
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview2, string2, "{\"code\":-100,\"message\":\"\"+sWeb.getContext().getString(R.string.dcloud_ui_webview_not_finished)+\"\"}", io.dcloud.common.util.JSUtil.ERROR, true, false);
                iWebviewR = cVarA.r();
                jSONObject = io.dcloud.common.util.JSONUtil.getJSONObject(jSONArray, 2);
                strOptString = "auto";
                if (jSONObject != null) {
                    strOptString = jSONObject.optString("type", "auto");
                }
                str = strOptString;
                viewGroupObtainWindowView = iWebviewR.obtainWindowView();
                if (viewGroupObtainWindowView != null) {
                    viewGroupObtainWindowView.post(new io.dcloud.feature.ui.c.e(iWebviewR, str, iWebview2, string2));
                }
            }
        }
        iWebview2 = iWebview;
        try {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview2, string2, "{\"code\":-100,\"message\":\"" + iWebview.getContext().getString(io.dcloud.base.R.string.dcloud_ui_webview_not_finished) + "\"}", io.dcloud.common.util.JSUtil.ERROR, true, false);
        } catch (java.lang.Exception e3) {
            e = e3;
            e.printStackTrace();
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview2, string2, "{\"code\":-100,\"message\":\"\"+sWeb.getContext().getString(R.string.dcloud_ui_webview_not_finished)+\"\"}", io.dcloud.common.util.JSUtil.ERROR, true, false);
            iWebviewR = cVarA.r();
            jSONObject = io.dcloud.common.util.JSONUtil.getJSONObject(jSONArray, 2);
            strOptString = "auto";
            if (jSONObject != null) {
                strOptString = jSONObject.optString("type", "auto");
            }
            str = strOptString;
            viewGroupObtainWindowView = iWebviewR.obtainWindowView();
            if (viewGroupObtainWindowView != null) {
                viewGroupObtainWindowView.post(new io.dcloud.feature.ui.c.e(iWebviewR, str, iWebview2, string2));
            }
        }
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
    private void a(io.dcloud.feature.ui.b bVar, io.dcloud.feature.ui.c cVar, java.lang.String str) {
        io.dcloud.feature.ui.c cVar2 = (io.dcloud.feature.ui.c) bVar;
        if (cVar2.F) {
            cVar.u = cVar2.u - 1;
            cVar.F = true;
            cVar.I = true;
            cVar.G = false;
            this.c.a(str, cVar, this.c.c(this));
            this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 45, new java.lang.Object[]{cVar.y, cVar2.y});
        }
    }

    private void a(io.dcloud.feature.ui.c cVar, java.lang.String str) {
        io.dcloud.common.DHInterface.IApp iAppObtainApp;
        if (cVar == null || io.dcloud.common.util.PdrUtil.isEmpty(str) || (iAppObtainApp = cVar.r().obtainApp()) == null) {
            return;
        }
        io.dcloud.feature.ui.c cVar2 = cVar.W;
        if (cVar2 != null) {
            str = cVar2.r().obtainUrl();
        }
        java.lang.String strObtainUrl = cVar.r().obtainUrl();
        if (!io.dcloud.common.util.BaseInfo.isBase(cVar.a()) || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(strObtainUrl) || str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL) || strObtainUrl.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL)) {
            return;
        }
        android.util.Log.i(io.dcloud.common.constant.AbsoluteConst.HBUILDER_TAG, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.OPENLOG, io.dcloud.common.adapter.ui.webview.WebResUtil.getHBuilderPrintUrl(iAppObtainApp.convert2RelPath(io.dcloud.common.adapter.ui.webview.WebResUtil.getOriginalUrl(str))), io.dcloud.common.adapter.ui.webview.WebResUtil.getHBuilderPrintUrl(iAppObtainApp.convert2RelPath(io.dcloud.common.adapter.ui.webview.WebResUtil.getOriginalUrl(strObtainUrl)))));
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
    void a(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray, io.dcloud.feature.ui.c cVar, java.lang.String str) {
        java.lang.String str2;
        if (this.c.a(cVar)) {
            io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.StreamApp_TAG, "showWebview url=" + cVar.z);
            cVar.A = 1;
            this.c.f(cVar);
            cVar.B = new java.lang.Object[]{iWebview, jSONArray, cVar, str};
            return;
        }
        cVar.u = java.lang.System.currentTimeMillis();
        cVar.F = true;
        java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONArray, 0);
        java.lang.String string2 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 1);
        java.lang.String string3 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 3);
        this.O = string3;
        if (!io.dcloud.common.util.PdrUtil.isEmpty(string3)) {
            this.P = iWebview;
        }
        io.dcloud.common.adapter.util.AnimOptions animOptions = ((io.dcloud.common.adapter.ui.AdaFrameItem) cVar.y).getAnimOptions();
        if (io.dcloud.common.util.PdrUtil.isEquals("auto", string)) {
            str2 = animOptions.mAnimType;
        } else {
            str2 = io.dcloud.common.util.PdrUtil.isEmpty(string) ? "none" : string;
        }
        animOptions.mAnimType = str2;
        boolean z = !io.dcloud.common.util.PdrUtil.isEquals("none", str2);
        if (io.dcloud.common.util.PdrUtil.isEmpty(string2)) {
            if (animOptions.mAnimType.equals(io.dcloud.common.adapter.util.AnimOptions.ANIM_POP_IN)) {
                animOptions.duration_show = 300;
            }
        } else {
            animOptions.duration_show = io.dcloud.common.util.PdrUtil.parseInt(string2, animOptions.duration_show);
        }
        if (!cVar.G && cVar.I) {
            z = false;
        }
        this.c.a(str, cVar, this.c.c(this));
        a(iWebview, io.dcloud.common.util.JSONUtil.getJSONObject(jSONArray, 4), cVar, string);
        if (cVar.G) {
            animOptions.mOption = (byte) 4;
            this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 24, cVar.y);
        } else {
            animOptions.mOption = (byte) 0;
            cVar.I = true;
            this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 1, new java.lang.Object[]{cVar.y, java.lang.Boolean.valueOf(z)});
        }
        cVar.G = false;
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.VIEW_VISIBLE_TAG, "show " + cVar.y + ";webview_name=" + r().obtainFrameId());
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
    private void a(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONObject jSONObject, io.dcloud.feature.ui.c cVar, java.lang.String str) {
        java.lang.Object obj;
        org.json.JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null) {
            java.lang.String strOptString = jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.ACCELERATION);
            java.lang.String str2 = android.text.TextUtils.isEmpty(strOptString) ? "auto" : strOptString;
            java.lang.String strOptString2 = jSONObject.optString("action", "none");
            cVar.y.setAccelerationType(str2);
            if (jSONObject.has(io.dcloud.common.constant.AbsoluteConst.CAPTURE)) {
                org.json.JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(io.dcloud.common.constant.AbsoluteConst.CAPTURE);
                if (jSONObjectOptJSONObject2 == null) {
                    return;
                }
                java.lang.String strOptString3 = jSONObjectOptJSONObject2.optString("__id__");
                if (jSONObjectOptJSONObject2.has("type") && jSONObjectOptJSONObject2.optString("type").equals(io.dcloud.common.constant.AbsoluteConst.NATIVE_NVIEW)) {
                    obj = "getNativeView";
                    java.lang.Object objProcessEvent = this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebview, "nativeobj", obj, new java.lang.Object[]{this.y, strOptString3}});
                    if (objProcessEvent != null && (objProcessEvent instanceof io.dcloud.common.DHInterface.INativeView)) {
                        cVar.y.setSnapshotView((io.dcloud.common.DHInterface.INativeView) objProcessEvent, strOptString2);
                        cVar.y.setSnapshot(null);
                    }
                } else {
                    obj = "getNativeView";
                    io.dcloud.common.DHInterface.INativeBitmap iNativeBitmapG = g(cVar.y.obtainWebView(), strOptString3);
                    cVar.y.setSnapshot(iNativeBitmapG != null ? iNativeBitmapG.getBitmap() : null);
                    cVar.y.setSnapshotView(null, "none");
                }
            } else {
                obj = "getNativeView";
            }
            io.dcloud.common.DHInterface.IFrameView iFrameViewFindPageB = cVar.y.findPageB();
            if (iFrameViewFindPageB != null) {
                iFrameViewFindPageB.setAccelerationType(str2);
                if (!jSONObject.has("otherCapture") || (jSONObjectOptJSONObject = jSONObject.optJSONObject("otherCapture")) == null) {
                    return;
                }
                java.lang.String strOptString4 = jSONObjectOptJSONObject.optString("__id__");
                if (jSONObjectOptJSONObject.has("type") && jSONObjectOptJSONObject.optString("type").equals(io.dcloud.common.constant.AbsoluteConst.NATIVE_NVIEW)) {
                    java.lang.Object objProcessEvent2 = this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebview, "nativeobj", obj, new java.lang.Object[]{iFrameViewFindPageB, strOptString4}});
                    if (objProcessEvent2 == null || !(objProcessEvent2 instanceof io.dcloud.common.DHInterface.INativeView)) {
                        return;
                    }
                    iFrameViewFindPageB.setSnapshotView((io.dcloud.common.DHInterface.INativeView) objProcessEvent2, strOptString2);
                    iFrameViewFindPageB.setSnapshot(null);
                    return;
                }
                io.dcloud.common.DHInterface.INativeBitmap iNativeBitmapG2 = g(iFrameViewFindPageB.obtainWebView(), strOptString4);
                iFrameViewFindPageB.setSnapshot(iNativeBitmapG2 != null ? iNativeBitmapG2.getBitmap() : null);
                iFrameViewFindPageB.setSnapshotView(null, "none");
                return;
            }
            return;
        }
        cVar.y.setSnapshot(null);
        cVar.y.setAccelerationType("auto");
        io.dcloud.common.DHInterface.IFrameView iFrameViewFindPageB2 = cVar.y.findPageB();
        if (iFrameViewFindPageB2 != null) {
            iFrameViewFindPageB2.setSnapshot(null);
            iFrameViewFindPageB2.setAccelerationType("auto");
        }
    }

    void a(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray, io.dcloud.feature.ui.c cVar) {
        java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONArray, 0);
        java.lang.String string2 = io.dcloud.common.util.JSONUtil.getString(jSONArray, 1);
        cVar.y.captureSnapshot(string, android.text.TextUtils.isEmpty(string2) ? null : new io.dcloud.feature.ui.c.f(iWebview, string2), android.text.TextUtils.isEmpty(string2) ? null : new io.dcloud.feature.ui.c.g(iWebview, string2));
    }

    void a(io.dcloud.feature.ui.c cVar, boolean z) {
        cVar.y.obtainWebView().reload(z);
    }

    boolean a(org.json.JSONObject jSONObject, boolean z) {
        boolean z2 = false;
        if (!jSONObject.isNull(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ZINDEX)) {
            try {
                int i2 = java.lang.Integer.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ZINDEX));
                if (i2 != this.E) {
                    z2 = true;
                    this.E = i2;
                    ((io.dcloud.common.adapter.ui.AdaFrameView) this.y).mZIndex = i2;
                    if (z) {
                        this.c.g(this);
                    }
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return z2;
    }

    private static java.lang.String a(java.util.ArrayList arrayList) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(com.taobao.weex.el.parse.Operators.ARRAY_START_STR);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                io.dcloud.feature.ui.b bVar = (io.dcloud.feature.ui.b) arrayList.get(i2);
                if (bVar instanceof io.dcloud.feature.ui.c) {
                    stringBuffer.append(((io.dcloud.feature.ui.c) bVar).h());
                } else {
                    stringBuffer.append("'" + bVar.e + "'");
                }
                if (i2 != size - 1) {
                    stringBuffer.append(",");
                }
            }
        }
        stringBuffer.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        return stringBuffer.toString();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0145  */
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
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0145 -> B:34:0x0146). Please report as a decompilation issue!!! */
    private void a(io.dcloud.common.DHInterface.IWebview iWebview, io.dcloud.feature.ui.c cVar, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        java.lang.String string;
        java.lang.String strOptString;
        java.lang.String strOptString2;
        java.lang.String strOptString3;
        org.json.JSONObject jSONObject3;
        java.lang.String strChangeColorAlpha;
        java.lang.String str;
        java.lang.Object obj;
        if (jSONObject == null) {
            io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem = (io.dcloud.common.adapter.ui.AdaFrameItem) cVar.y;
            io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions = adaFrameItem.obtainFrameOptions();
            java.lang.String titleNViewId = io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(cVar.y);
            io.dcloud.common.DHInterface.AbsMgr absMgr = this.c.d;
            io.dcloud.common.DHInterface.IMgr.MgrType mgrType = io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr;
            absMgr.processEvent(mgrType, 72, new java.lang.Object[]{adaFrameItem, jSONObject2, titleNViewId});
            viewOptionsObtainFrameOptions.setTitleNView(jSONObject2, cVar.r());
            this.c.d.processEvent(mgrType, 73, new java.lang.Object[]{adaFrameItem, iWebview.obtainFrameView()});
            if (cVar.y.obtainWebView().isUniWebView()) {
                ((io.dcloud.common.adapter.ui.AdaUniWebView) cVar.y.obtainWebView()).titleNViewRefresh();
                return;
            }
            return;
        }
        if (jSONObject2 == null) {
            return;
        }
        boolean zPaddingIsChanged = io.dcloud.common.util.TitleNViewUtil.paddingIsChanged(jSONObject, jSONObject2);
        boolean zBackgroundIsChanged = io.dcloud.common.util.TitleNViewUtil.backgroundIsChanged(jSONObject, jSONObject2);
        boolean zBackgroundImageIsChanged = io.dcloud.common.util.TitleNViewUtil.backgroundImageIsChanged(jSONObject, jSONObject2);
        boolean zTitleAlignIsChanged = io.dcloud.common.util.TitleNViewUtil.titleAlignIsChanged(jSONObject, jSONObject2);
        boolean zRedDotChange = io.dcloud.common.util.TitleNViewUtil.redDotChange(jSONObject, jSONObject2);
        io.dcloud.common.util.TitleNViewUtil.titleNViewStyleNoTitle(jSONObject);
        boolean zTitleIsChanged = io.dcloud.common.util.TitleNViewUtil.titleIsChanged(jSONObject, jSONObject2);
        boolean zTitleColorIsChanged = io.dcloud.common.util.TitleNViewUtil.titleColorIsChanged(jSONObject, jSONObject2);
        boolean zTitleSizeIsChanged = io.dcloud.common.util.TitleNViewUtil.titleSizeIsChanged(jSONObject, jSONObject2);
        boolean zTitleOverflowIsChanged = io.dcloud.common.util.TitleNViewUtil.titleOverflowIsChanged(jSONObject, jSONObject2);
        boolean zSplitLineIsChanged = io.dcloud.common.util.TitleNViewUtil.splitLineIsChanged(jSONObject, jSONObject2);
        boolean zBackButtonIsChanged = io.dcloud.common.util.TitleNViewUtil.backButtonIsChanged(jSONObject, jSONObject2);
        boolean zProgressIsChanged = io.dcloud.common.util.TitleNViewUtil.progressIsChanged(jSONObject, jSONObject2);
        boolean zHas = jSONObject2.has("homeButton");
        boolean zIsButtonsIsChanged = io.dcloud.common.util.TitleNViewUtil.isButtonsIsChanged(jSONObject, jSONObject2);
        boolean zIsSearchInputChange = io.dcloud.common.util.TitleNViewUtil.isSearchInputChange(jSONObject, jSONObject2);
        boolean zSubTitleIconChanged = io.dcloud.common.util.TitleNViewUtil.subTitleIconChanged(jSONObject, jSONObject2);
        boolean zIsShadowChanged = io.dcloud.common.util.TitleNViewUtil.isShadowChanged(jSONObject, jSONObject2);
        java.lang.String titleNViewId2 = io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(cVar.y);
        org.json.JSONObject jSONObjectCreateJSONObject = io.dcloud.common.util.JSONUtil.createJSONObject(jSONObject.toString());
        org.json.JSONObject jSONObjectCreateJSONObject2 = io.dcloud.common.util.JSONUtil.createJSONObject(jSONObject2.toString());
        io.dcloud.common.util.JSONUtil.combinJSONObject(jSONObjectCreateJSONObject, jSONObjectCreateJSONObject2);
        int i2 = ((io.dcloud.common.adapter.ui.AdaFrameItem) cVar.y).obtainFrameOptions().coverage;
        if (jSONObjectCreateJSONObject != null && jSONObjectCreateJSONObject.has("coverage")) {
            ((io.dcloud.common.adapter.ui.AdaFrameItem) cVar.y).obtainFrameOptions().coverage = io.dcloud.common.util.PdrUtil.convertToScreenInt(jSONObjectCreateJSONObject.optString("coverage"), io.dcloud.common.adapter.util.PlatformUtil.SCREEN_WIDTH(cVar.a()), i2, cVar.r().getScale());
        }
        if (jSONObjectCreateJSONObject != null) {
            try {
                if (jSONObject2.has("titleText")) {
                    java.lang.Object obj2 = jSONObjectCreateJSONObject.get("titleText");
                    if (obj2 == null || !(obj2 instanceof java.lang.String)) {
                        string = null;
                    } else {
                        string = obj2.toString();
                    }
                } else if (jSONObject2.has("titletext") && (obj = jSONObjectCreateJSONObject.get("titletext")) != null && (obj instanceof java.lang.String)) {
                    string = obj.toString();
                } else {
                    string = null;
                }
            } catch (java.lang.Exception unused) {
            }
            if (jSONObject2.has("titleColor")) {
                strOptString = jSONObjectCreateJSONObject.optString("titleColor");
            } else {
                strOptString = jSONObject2.has("titlecolor") ? jSONObjectCreateJSONObject.optString("titlecolor") : null;
            }
            if (android.text.TextUtils.isEmpty(strOptString)) {
                strOptString = jSONObjectCreateJSONObject.optString("titleColor");
                if (android.text.TextUtils.isEmpty(strOptString)) {
                    strOptString = jSONObjectCreateJSONObject.optString("titlecolor");
                }
            }
            java.lang.String str2 = "type";
            if ("transparent".equals(jSONObject2.optString("type")) && !android.text.TextUtils.isEmpty(strOptString)) {
                strOptString = io.dcloud.common.util.TitleNViewUtil.changeColorAlpha(strOptString, 0.0f);
            }
            if (jSONObject2.has("titleSize")) {
                strOptString2 = jSONObjectCreateJSONObject.optString("titleSize");
            } else {
                strOptString2 = jSONObject2.has("titlesize") ? jSONObjectCreateJSONObject.optString("titlesize") : null;
            }
            if (android.text.TextUtils.isEmpty(strOptString2)) {
                strOptString2 = jSONObjectCreateJSONObject.optString("titleSize");
                if (android.text.TextUtils.isEmpty(strOptString2)) {
                    strOptString2 = jSONObjectCreateJSONObject.optString("titlesize");
                }
            }
            java.lang.String str3 = strOptString2;
            java.lang.String strOptString4 = jSONObjectCreateJSONObject.optString("titleOverflow");
            if (jSONObject2.has("backgroundColor")) {
                strOptString3 = jSONObjectCreateJSONObject.optString("backgroundColor");
            } else {
                strOptString3 = jSONObject2.has("backgroundcolor") ? jSONObjectCreateJSONObject.optString("backgroundcolor") : null;
            }
            if (android.text.TextUtils.isEmpty(strOptString3)) {
                strOptString3 = jSONObjectCreateJSONObject.optString("backgroundColor");
                if (android.text.TextUtils.isEmpty(strOptString3)) {
                    strOptString3 = jSONObjectCreateJSONObject.optString("backgroundcolor");
                }
            }
            java.lang.String str4 = strOptString3;
            java.lang.String strOptString5 = jSONObject2.has(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE) ? jSONObjectCreateJSONObject.optString(com.taobao.weex.common.Constants.Name.BACKGROUND_IMAGE) : null;
            if (!zBackgroundIsChanged || android.text.TextUtils.isEmpty(str4)) {
                str2 = "type";
            } else {
                if ("transparent".equals(jSONObjectCreateJSONObject.optString("type"))) {
                    strChangeColorAlpha = io.dcloud.common.util.TitleNViewUtil.changeColorAlpha(str4, 0.0f);
                } else {
                    strChangeColorAlpha = "float".equals(jSONObjectCreateJSONObject.optString("type")) ? str4 : io.dcloud.common.util.TitleNViewUtil.changeColorAlpha(str4, 1.0f);
                }
                if (!((io.dcloud.common.adapter.ui.AdaFrameItem) cVar.y).obtainFrameOptions().isStatusbar && cVar.y.obtainApp().obtainStatusBarMgr().isImmersive) {
                    str = ",'statusbar':{'background':'" + strChangeColorAlpha + "','backgroundnoalpha':'" + str4 + "'}";
                } else {
                    str = "";
                }
                this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 1, new java.lang.Object[]{cVar.r(), "nativeobj", "setStyle", io.dcloud.common.util.JSONUtil.createJSONArray("['" + titleNViewId2 + "','" + titleNViewId2 + "',{'backgroundColor':'" + strChangeColorAlpha + "'" + str + "}]")});
            }
            org.json.JSONArray jSONArrayOptJSONArray = jSONObjectCreateJSONObject2.optJSONArray("tags");
            if (jSONArrayOptJSONArray != null) {
                this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 1, new java.lang.Object[]{cVar.r(), "nativeobj", "view_draw", io.dcloud.common.util.JSONUtil.createJSONArray("['" + titleNViewId2 + "','" + titleNViewId2 + "'," + jSONArrayOptJSONArray.toString() + com.taobao.weex.el.parse.Operators.ARRAY_END_STR)});
            }
            java.lang.Object titleNView = io.dcloud.common.util.TitleNViewUtil.getTitleNView(this.c.d, cVar.r(), cVar.y, titleNViewId2);
            if (titleNView instanceof io.dcloud.common.DHInterface.ITitleNView) {
                io.dcloud.common.DHInterface.ITitleNView iTitleNView = (io.dcloud.common.DHInterface.ITitleNView) titleNView;
                if (zTitleIsChanged) {
                    iTitleNView.setTitleText(string);
                }
                if (zTitleColorIsChanged) {
                    iTitleNView.setTitleColor(strOptString);
                }
                if (zTitleSizeIsChanged) {
                    iTitleNView.setTitleSize(str3);
                }
                if (zTitleOverflowIsChanged) {
                    iTitleNView.setTitleOverflow(strOptString4);
                }
                if (zPaddingIsChanged) {
                    jSONObject3 = jSONObjectCreateJSONObject;
                    io.dcloud.common.util.TitleNViewUtil.setTitleNViewPadding(iTitleNView, cVar.r(), jSONObject3);
                } else {
                    jSONObject3 = jSONObjectCreateJSONObject;
                }
                if (zSplitLineIsChanged) {
                    io.dcloud.common.util.TitleNViewUtil.setSplitLine(iTitleNView, cVar.r(), jSONObject.optJSONObject("splitLine"), jSONObject2.optJSONObject("splitLine"), false, jSONObject3.optString(str2));
                }
                if (zBackButtonIsChanged) {
                    io.dcloud.common.util.TitleNViewUtil.setBackButton(iTitleNView, jSONObject3, cVar.y.getFrameType());
                }
                if (zProgressIsChanged) {
                    io.dcloud.common.util.TitleNViewUtil.setProgress(iTitleNView, jSONObject3);
                }
                if (zIsSearchInputChange) {
                    io.dcloud.common.util.TitleNViewUtil.setSearchInput(iTitleNView, jSONObject3, cVar.y.obtainWebView());
                }
                if (zIsButtonsIsChanged) {
                    iTitleNView.clearButtons();
                    io.dcloud.common.util.TitleNViewUtil.setButtons(iTitleNView, jSONObject3, cVar.y.obtainWebView());
                    io.dcloud.common.util.TitleNViewUtil.setBackButton(iTitleNView, jSONObject3, cVar.y.getFrameType());
                }
                if (zHas || zIsButtonsIsChanged) {
                    io.dcloud.common.util.TitleNViewUtil.setHomeButton(iTitleNView, jSONObject3, cVar.y.getFrameType());
                }
                if (zRedDotChange) {
                    io.dcloud.common.util.TitleNViewUtil.setRedDotColor(iTitleNView, jSONObject3);
                }
                if (zTitleAlignIsChanged) {
                    io.dcloud.common.util.TitleNViewUtil.setTitleAlign(iTitleNView, jSONObject3);
                }
                if (zBackgroundImageIsChanged && strOptString5 != null) {
                    this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 1, new java.lang.Object[]{cVar.r(), "nativeobj", "setStyle", io.dcloud.common.util.JSONUtil.createJSONArray("['" + titleNViewId2 + "','" + titleNViewId2 + "',{'backgroundImage':'" + strOptString5 + "'}]")});
                }
                if (jSONObject3.has("backgroundRepeat")) {
                    iTitleNView.setBackgroundRepeat(jSONObject3.optString("backgroundRepeat"));
                }
                if (zSubTitleIconChanged) {
                    io.dcloud.common.util.TitleNViewUtil.setSubTitleIcon(iTitleNView, jSONObject3);
                }
                if (zIsShadowChanged) {
                    io.dcloud.common.util.TitleNViewUtil.setShadow(iTitleNView, jSONObject3);
                }
            }
            if (cVar.y.obtainWebView().isUniWebView()) {
                ((io.dcloud.common.adapter.ui.AdaUniWebView) cVar.y.obtainWebView()).titleNViewRefresh();
            }
        }
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
    private void a(io.dcloud.feature.ui.c cVar, org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.c.d.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{cVar.r().obtainApp(), "weex,io.dcloud.feature.weex.WeexFeature", "weexViewUpdate", new java.lang.Object[]{cVar.r(), cVar.y.obtainMainView(), jSONObject, io.dcloud.common.util.BaseInfo.getUniNViewId(cVar.y)}});
    }
}
