package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
class k0 implements io.dcloud.common.DHInterface.ICore {
    private static io.dcloud.p.k0 o;
    boolean a = false;
    android.content.Context b = null;
    android.content.Context c = null;
    io.dcloud.common.DHInterface.AbsMgr d = null;
    io.dcloud.common.DHInterface.AbsMgr e = null;
    io.dcloud.common.DHInterface.AbsMgr f = null;
    io.dcloud.common.DHInterface.AbsMgr g = null;
    java.lang.String h = "CORE";
    private io.dcloud.common.DHInterface.ICore.ICoreStatusListener i = null;
    java.util.HashMap j = null;
    final int k = 0;
    final int l = 1;
    final int m = 2;
    final int n = 3;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements io.dcloud.common.adapter.util.MessageHandler.IMessages {
        final /* synthetic */ io.dcloud.common.DHInterface.IApp a;
        final /* synthetic */ android.app.Activity b;
        final /* synthetic */ java.lang.String c;

        a(io.dcloud.common.DHInterface.IApp iApp, android.app.Activity activity, java.lang.String str) {
            this.a = iApp;
            this.b = activity;
            this.c = str;
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
        @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
        public void execute(java.lang.Object obj) {
            io.dcloud.common.DHInterface.IApp iApp = this.a;
            if (iApp != null) {
                io.dcloud.p.k0.this.a(this.b, iApp);
            }
            java.lang.Object objDispatchEvent = io.dcloud.p.k0.this.dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 32, new java.lang.Object[]{this.b, this.c});
            if ((objDispatchEvent instanceof java.lang.Boolean ? ((java.lang.Boolean) objDispatchEvent).booleanValue() : false) || !android.text.TextUtils.equals(io.dcloud.common.util.BaseInfo.sLastRunApp, this.c)) {
                return;
            }
            io.dcloud.common.util.BaseInfo.sLastRunApp = null;
            this.b.finish();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ android.app.Activity b;
        final /* synthetic */ java.lang.String c;

        b(java.lang.String str, android.app.Activity activity, java.lang.String str2) {
            this.a = str;
            this.b = activity;
            this.c = str2;
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onCancel() {
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onExecuteBegin() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public void onExecuteEnd(java.lang.Object obj) {
            io.dcloud.p.k0 k0Var = io.dcloud.p.k0.this;
            android.app.Activity activity = this.b;
            k0Var.a(activity, this.a, this.c, activity instanceof io.dcloud.common.DHInterface.IOnCreateSplashView ? (io.dcloud.common.DHInterface.IOnCreateSplashView) activity : null);
            if (!io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() || obj == null) {
                return;
            }
            android.content.ComponentCallbacks2 componentCallbacks2 = this.b;
            if (componentCallbacks2 instanceof io.dcloud.common.DHInterface.IActivityHandler) {
                ((io.dcloud.common.DHInterface.IActivityHandler) componentCallbacks2).onAsyncStartAppEnd(this.a, obj);
            }
        }

        @Override // io.dcloud.common.adapter.util.AsyncTaskHandler.IAsyncTaskListener
        public java.lang.Object onExecuting() {
            try {
                java.lang.String str = android.text.TextUtils.isEmpty(this.a) ? io.dcloud.common.util.BaseInfo.sDefaultBootApp : this.a;
                io.dcloud.common.util.db.DCStorage dCStorage = io.dcloud.common.util.db.DCStorage.getDCStorage(this.b);
                if (dCStorage != null) {
                    dCStorage.checkSPstorageToDB(this.b, str);
                }
            } catch (java.lang.Exception unused) {
            }
            if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
                android.content.ComponentCallbacks2 componentCallbacks2 = this.b;
                if (componentCallbacks2 instanceof io.dcloud.common.DHInterface.IActivityHandler) {
                    return ((io.dcloud.common.DHInterface.IActivityHandler) componentCallbacks2).onAsyncStartAppStart(this.a);
                }
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[io.dcloud.common.DHInterface.IMgr.MgrType.values().length];
            b = iArr;
            try {
                iArr[io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                b[io.dcloud.common.DHInterface.IMgr.MgrType.NetMgr.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                b[io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                b[io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.values().length];
            a = iArr2;
            try {
                iArr2[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onStart.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onStop.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onPause.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                a[io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onResume.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
        }
    }

    private k0() {
    }

    public void b(android.app.Activity activity) {
        io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType = io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onPause;
        a(activity, sysEventType, (java.lang.Object) null);
        if (this.a) {
            io.dcloud.common.DHInterface.AbsMgr absMgr = this.f;
            if (absMgr != null) {
                absMgr.onExecute(sysEventType, null);
            }
            onActivityExecute(activity, sysEventType, null);
        }
        java.lang.System.gc();
    }

    public void c(android.app.Activity activity) {
        io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType = io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onResume;
        a(activity, sysEventType, (java.lang.Object) null);
        this.f.onExecute(sysEventType, null);
        onActivityExecute(activity, sysEventType, null);
    }

    public boolean d(android.app.Activity activity) {
        io.dcloud.common.adapter.util.DownloadUtil.getInstance(activity).stop();
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.apsqh.QHNotifactionReceiver", "doSaveNotifications", null, new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{activity.getBaseContext()});
        try {
            io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType = io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onStop;
            onActivityExecute(activity, sysEventType, null);
            this.a = false;
            io.dcloud.common.util.BaseInfo.setLoadingLaunchePage(false, "onStop");
            a(activity, sysEventType, (java.lang.Object) null);
            o = null;
            this.d.dispose();
            this.d = null;
            this.e.dispose();
            this.e = null;
            this.f.dispose();
            this.f = null;
            this.g.dispose();
            this.g = null;
            io.dcloud.common.adapter.util.Logger.e(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "core exit");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override // io.dcloud.common.DHInterface.ICore
    public java.lang.Object dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType mgrType, int i, java.lang.Object obj) {
        io.dcloud.common.DHInterface.AbsMgr absMgr;
        if (mgrType == null) {
            return a(i, obj);
        }
        try {
            if (o == null) {
                o = this;
            }
            int i2 = io.dcloud.p.k0.c.b[mgrType.ordinal()];
            if (i2 == 1) {
                io.dcloud.common.DHInterface.AbsMgr absMgr2 = o.e;
                if (absMgr2 != null) {
                    return absMgr2.processEvent(mgrType, i, obj);
                }
            } else if (i2 == 2) {
                io.dcloud.common.DHInterface.AbsMgr absMgr3 = o.f;
                if (absMgr3 != null) {
                    return absMgr3.processEvent(mgrType, i, obj);
                }
            } else if (i2 == 3) {
                io.dcloud.common.DHInterface.AbsMgr absMgr4 = o.g;
                if (absMgr4 != null) {
                    return absMgr4.processEvent(mgrType, i, obj);
                }
            } else if (i2 == 4 && (absMgr = o.d) != null) {
                return absMgr.processEvent(mgrType, i, obj);
            }
            return null;
        } catch (java.lang.Exception e) {
            io.dcloud.common.adapter.util.Logger.w("Core.dispatchEvent", e);
            return null;
        }
    }

    @Override // io.dcloud.common.DHInterface.ICore
    public android.content.Context obtainActivityContext() {
        return this.c;
    }

    @Override // io.dcloud.common.DHInterface.ICore
    public android.content.Context obtainContext() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.common.DHInterface.ICore
    public boolean onActivityExecute(android.app.Activity activity, io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
        java.lang.String string;
        android.os.Bundle extras;
        if (obj instanceof io.dcloud.common.DHInterface.IApp) {
            string = ((io.dcloud.common.DHInterface.IApp) obj).obtainAppId();
        } else {
            string = io.dcloud.common.util.BaseInfo.sRuntimeMode != null ? null : io.dcloud.common.util.BaseInfo.sDefaultBootApp;
            android.content.Intent intent = activity.getIntent();
            if (intent != null && (extras = intent.getExtras()) != null && extras.containsKey("appid")) {
                string = extras.getString("appid");
            }
        }
        java.lang.Object objDispatchEvent = dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 1, new java.lang.Object[]{sysEventType, obj, string});
        io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType2 = io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp;
        if (!sysEventType.equals(sysEventType2) || objDispatchEvent == null || ((java.lang.Boolean) objDispatchEvent).booleanValue() || ((java.lang.Integer) ((java.lang.Object[]) obj)[0]).intValue() != 4) {
            return java.lang.Boolean.parseBoolean(java.lang.String.valueOf(objDispatchEvent));
        }
        if (sysEventType.equals(sysEventType2)) {
            if (activity instanceof io.dcloud.common.DHInterface.IActivityHandler) {
                ((io.dcloud.common.DHInterface.IActivityHandler) activity).closeAppStreamSplash(string);
            }
            a(activity, activity.getIntent(), (io.dcloud.common.DHInterface.IApp) null, string);
        }
        return true;
    }

    @Override // io.dcloud.common.DHInterface.ICore
    public void onRestart(android.content.Context context) {
        java.util.Collection<io.dcloud.common.DHInterface.IBoot> collectionValues;
        java.util.HashMap map = this.j;
        if (map == null || (collectionValues = map.values()) == null) {
            return;
        }
        for (io.dcloud.common.DHInterface.IBoot iBoot : collectionValues) {
            if (iBoot != null) {
                iBoot.onRestart(context);
            }
        }
    }

    @Override // io.dcloud.common.DHInterface.ICore
    public void setmCoreListener(io.dcloud.common.DHInterface.ICore.ICoreStatusListener iCoreStatusListener) {
        this.i = iCoreStatusListener;
    }

    public static io.dcloud.p.k0 a(android.content.Context context, io.dcloud.common.DHInterface.ICore.ICoreStatusListener iCoreStatusListener) {
        if (o == null) {
            o = new io.dcloud.p.k0();
        }
        io.dcloud.p.k0 k0Var = o;
        k0Var.b = context;
        k0Var.i = iCoreStatusListener;
        io.dcloud.feature.internal.sdk.SDK.initSDK(k0Var);
        return o;
    }

    public void a(android.app.Activity activity, android.os.Bundle bundle, io.dcloud.feature.internal.sdk.SDK.IntegratedMode integratedMode) {
        this.c = activity;
        io.dcloud.common.adapter.util.DownloadUtil.getInstance(activity);
        io.dcloud.common.adapter.ui.webview.WebViewFactory.resetSysWebViewState();
        a();
        a(activity);
        io.dcloud.common.util.BaseInfo.sRuntimeMode = integratedMode;
        if (integratedMode != null) {
            io.dcloud.common.util.BaseInfo.USE_ACTIVITY_HANDLE_KEYEVENT = true;
        }
        if (this.a) {
            return;
        }
        io.src.dcloud.adapter.DCloudAdapterUtil.getIActivityHandler(activity);
        a(activity.getApplicationContext());
        io.dcloud.common.adapter.util.Logger.i("Core onInit mode=" + integratedMode);
        a(activity, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onStart, bundle);
        io.dcloud.common.adapter.util.Logger.i("Core onInit mCoreListener=" + this.i);
        try {
            io.dcloud.feature.internal.sdk.SDK.IntegratedMode integratedMode2 = io.dcloud.common.util.BaseInfo.sRuntimeMode;
            if (integratedMode2 != null && integratedMode2 != io.dcloud.feature.internal.sdk.SDK.IntegratedMode.RUNTIME) {
                io.dcloud.common.DHInterface.ICore.ICoreStatusListener iCoreStatusListener = this.i;
                if (iCoreStatusListener != null) {
                    iCoreStatusListener.onCoreInitEnd(this);
                    return;
                }
                return;
            }
            io.dcloud.common.DHInterface.ICore.ICoreStatusListener iCoreStatusListener2 = this.i;
            if (iCoreStatusListener2 != null) {
                iCoreStatusListener2.onCoreInitEnd(this);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void a(android.app.Activity activity) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            java.lang.String str = android.os.Build.MANUFACTURER;
            jSONObject.put("deviceBrand", str);
            jSONObject.put("deviceModel", android.os.Build.MODEL);
            jSONObject.put("deviceType", io.dcloud.common.adapter.util.DeviceInfo.getSystemUIModeType(activity));
            jSONObject.put("uniPlatform", io.dcloud.common.constant.AbsoluteConst.XML_APP);
            jSONObject.put(com.taobao.weex.common.WXConfig.osName, com.taobao.weex.WXEnvironment.OS);
            jSONObject.put("osAndroidAPILevel", android.os.Build.VERSION.SDK_INT);
            jSONObject.put("osVersion", android.os.Build.VERSION.RELEASE);
            jSONObject.put("osLanguage", io.dcloud.common.util.language.LanguageUtil.getDeviceDefLocalLanguage());
            jSONObject.put("romName", io.dcloud.p.o0.b(str));
            jSONObject.put("romVersion", io.dcloud.p.o0.c(android.os.Build.BRAND));
        } catch (java.lang.Exception unused) {
        }
        io.dcloud.common.adapter.util.DeviceInfo.sSystemInfo = jSONObject;
    }

    private void a(android.content.Context context) {
        io.dcloud.common.util.TestUtil.record("core", java.lang.Thread.currentThread());
        this.g = new io.dcloud.p.i1(this);
        this.j = (java.util.HashMap) dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 0, this.b);
        io.dcloud.common.util.BaseInfo.parseControl(context, this, this.i);
        io.dcloud.common.adapter.util.Logger.initLogger(context);
        io.dcloud.common.adapter.util.DeviceInfo.init(context);
        this.e = new io.dcloud.p.s(this);
        this.d = new io.dcloud.common.core.ui.l(this);
        this.f = new io.dcloud.common.util.net.NetMgr(this);
        this.a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.app.Activity activity, io.dcloud.common.DHInterface.IApp iApp) {
        onActivityExecute(activity, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppStop, iApp);
    }

    public void a(android.app.Activity activity, android.content.Intent intent, io.dcloud.common.DHInterface.IApp iApp, java.lang.String str) {
        io.dcloud.common.DHInterface.ICore.ICoreStatusListener iCoreStatusListener = this.i;
        boolean z = iCoreStatusListener != null ? !iCoreStatusListener.onCoreStop() : true;
        this.c = null;
        if (iApp != null) {
            dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 13, iApp);
        }
        if (z) {
            io.dcloud.common.DHInterface.IActivityHandler iActivityHandler = io.src.dcloud.adapter.DCloudAdapterUtil.getIActivityHandler(activity);
            android.text.TextUtils.equals(activity.getIntent().getStringExtra("appid"), str);
            if (iActivityHandler != null && iApp == null) {
                if (io.dcloud.common.adapter.util.MobilePhoneModel.HUAWEI.equalsIgnoreCase(android.os.Build.MANUFACTURER) && android.os.Build.VERSION.SDK_INT >= 24) {
                    if (iApp != null) {
                        a(activity, iApp);
                    }
                    java.lang.Object objDispatchEvent = dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 32, new java.lang.Object[]{activity, str});
                    if (!(objDispatchEvent instanceof java.lang.Boolean ? ((java.lang.Boolean) objDispatchEvent).booleanValue() : false)) {
                        activity.finish();
                    }
                } else {
                    io.dcloud.common.adapter.util.MessageHandler.sendMessage(new io.dcloud.p.k0.a(iApp, activity, str), 10, null);
                }
            } else {
                activity.finish();
            }
        }
        io.dcloud.common.util.BaseInfo.sGlobalFullScreen = false;
    }

    public io.dcloud.common.DHInterface.IApp a(android.app.Activity activity, java.lang.String str, java.lang.String str2, io.dcloud.common.DHInterface.IOnCreateSplashView iOnCreateSplashView) {
        return a(activity, str, str2, iOnCreateSplashView, false);
    }

    boolean a(android.content.Intent intent, java.lang.String str) {
        java.lang.String str2 = io.dcloud.common.util.BaseInfo.sCacheFsAppsPath + str + "/www/";
        if (new java.io.File(str2).exists()) {
            java.io.File file = new java.io.File(str2 + "/manifest.json");
            if (file.exists() && file.length() > 0) {
                return true;
            }
        }
        if (intent.hasExtra(io.dcloud.common.constant.IntentConst.DIRECT_PAGE) && io.dcloud.common.util.BaseInfo.isWap2AppAppid(str)) {
            return true;
        }
        return !intent.getBooleanExtra(io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_HAS_STREAM_SPLASH, false);
    }

    public io.dcloud.common.DHInterface.IApp a(android.app.Activity activity, java.lang.String str, java.lang.String str2, io.dcloud.common.DHInterface.IOnCreateSplashView iOnCreateSplashView, boolean z) {
        io.dcloud.common.util.TestUtil.record("GET_STATUS_BY_APPID");
        io.dcloud.common.adapter.util.Logger.d("syncStartApp " + str);
        io.dcloud.common.DHInterface.IMgr.MgrType mgrType = io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr;
        java.lang.Object objDispatchEvent = dispatchEvent(mgrType, 12, str);
        byte b2 = objDispatchEvent != null ? java.lang.Byte.parseByte(java.lang.String.valueOf(objDispatchEvent)) : (byte) 1;
        io.dcloud.common.util.TestUtil.print("GET_STATUS_BY_APPID");
        boolean zA = a(activity.getIntent(), str);
        if (1 == b2) {
            io.dcloud.common.adapter.util.Logger.d("syncStartApp " + str + " STATUS_UN_RUNNING");
            if (iOnCreateSplashView != null) {
                io.dcloud.common.adapter.util.Logger.d("syncStartApp " + str + " ShowSplash");
                iOnCreateSplashView.onCreateSplash(activity);
            }
        }
        if (!zA) {
            return null;
        }
        try {
            io.dcloud.common.util.TestUtil.record(io.dcloud.common.util.TestUtil.START_APP_SET_ROOTVIEW, "启动" + str);
            io.dcloud.common.DHInterface.IApp iApp = (io.dcloud.common.DHInterface.IApp) dispatchEvent(mgrType, 0, new java.lang.Object[]{activity, str, str2});
            iApp.setOnCreateSplashView(iOnCreateSplashView);
            if (z && (3 == b2 || 2 == b2)) {
                onActivityExecute(activity, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onNewIntent, str2);
            }
            return iApp;
        } catch (java.lang.Exception unused) {
            io.dcloud.common.adapter.util.Logger.d("syncStartApp appid=" + str);
            return null;
        }
    }

    public void a(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        io.dcloud.common.adapter.util.AsyncTaskHandler.executeThreadTask(new io.dcloud.p.k0.b(str, activity, str2));
    }

    private void a(android.content.Context context, io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
        java.util.Collection<io.dcloud.common.DHInterface.IBoot> collectionValues;
        java.util.HashMap map = this.j;
        if (map == null || (collectionValues = map.values()) == null) {
            return;
        }
        for (io.dcloud.common.DHInterface.IBoot iBoot : collectionValues) {
            if (iBoot != null) {
                try {
                    int i = io.dcloud.p.k0.c.a[sysEventType.ordinal()];
                    if (i == 1) {
                        iBoot.onStart(context, (android.os.Bundle) obj, new java.lang.String[]{io.dcloud.common.util.BaseInfo.sDefaultBootApp});
                    } else if (i == 2) {
                        iBoot.onStop();
                    } else if (i == 3) {
                        iBoot.onPause();
                    } else if (i == 4) {
                        iBoot.onResume();
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private java.lang.Object a(int i, java.lang.Object obj) {
        android.app.Activity activity;
        io.dcloud.common.DHInterface.IApp iApp;
        android.content.Intent intentObtainWebAppIntent;
        java.lang.String strObtainAppId;
        if (i == -1) {
            return io.dcloud.common.util.BaseInfo.sRuntimeMode;
        }
        if (i != 0) {
            if (i == 1) {
                return java.lang.Boolean.valueOf(this.j.containsValue((io.dcloud.common.DHInterface.IBoot) obj));
            }
            if (i != 2) {
                return null;
            }
            java.lang.Object[] objArr = (java.lang.Object[]) obj;
            a((android.app.Activity) objArr[0], (java.lang.String) objArr[1], (java.lang.String) objArr[2], (io.dcloud.common.DHInterface.IOnCreateSplashView) objArr[3]);
            return null;
        }
        if (obj instanceof io.dcloud.common.DHInterface.IApp) {
            iApp = (io.dcloud.common.DHInterface.IApp) obj;
            activity = iApp.getActivity();
            intentObtainWebAppIntent = iApp.obtainWebAppIntent();
            strObtainAppId = iApp.obtainAppId();
        } else if (obj instanceof java.lang.Object[]) {
            java.lang.Object[] objArr2 = (java.lang.Object[]) obj;
            activity = (android.app.Activity) objArr2[0];
            intentObtainWebAppIntent = (android.content.Intent) objArr2[1];
            strObtainAppId = (java.lang.String) objArr2[2];
            iApp = null;
        } else {
            activity = null;
            iApp = null;
            intentObtainWebAppIntent = null;
            strObtainAppId = null;
        }
        if (!io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            io.dcloud.p.b.o().p();
        }
        a(activity, intentObtainWebAppIntent, iApp, strObtainAppId);
        return null;
    }

    private void a() {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_LOCALE");
        if (io.dcloud.common.util.PdrUtil.isEmpty(metaValue) || metaValue.equalsIgnoreCase("default")) {
            return;
        }
        java.lang.String[] strArrSplit = metaValue.split("_");
        java.lang.String upperCase = "";
        java.lang.String lowerCase = (strArrSplit.length <= 0 || (str2 = strArrSplit[0]) == null) ? "" : str2.toLowerCase(java.util.Locale.ENGLISH);
        if (strArrSplit.length > 1 && (str = strArrSplit[1]) != null) {
            upperCase = str.toUpperCase();
        }
        java.util.Locale.setDefault(new java.util.Locale(lowerCase, upperCase));
    }
}
