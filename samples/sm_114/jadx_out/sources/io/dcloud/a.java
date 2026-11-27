package io.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
abstract class a extends io.dcloud.b implements io.dcloud.common.DHInterface.IOnCreateSplashView, io.dcloud.common.DHInterface.IKeyHandler {
    private java.lang.String g;
    private java.lang.String h;
    androidx.appcompat.app.AlertDialog i;
    private io.dcloud.common.util.DisplayManagerChangeListener m;
    java.lang.Runnable n;
    java.lang.String d = null;
    java.lang.String e = "Main_App";
    io.dcloud.EntryProxy f = null;
    int j = 20;
    private int k = 9101;
    private int l = 9102;

    /* JADX INFO: renamed from: io.dcloud.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class RunnableC0024a implements java.lang.Runnable {
        final /* synthetic */ android.os.Bundle a;

        /* JADX INFO: renamed from: io.dcloud.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class RunnableC0025a implements java.lang.Runnable {
            RunnableC0025a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.a.RunnableC0024a runnableC0024a = io.dcloud.a.RunnableC0024a.this;
                io.dcloud.a.this.onRuntimeCreate(runnableC0024a.a);
            }
        }

        RunnableC0024a(android.os.Bundle bundle) {
            this.a = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.common.adapter.util.DeviceInfo.initPath(io.dcloud.a.this.that);
            io.dcloud.common.util.ImageLoaderUtil.initImageLoader(io.dcloud.a.this.that);
            io.dcloud.common.util.ImageLoaderUtil.initImageLoaderL(io.dcloud.a.this.that);
            io.dcloud.p.l.a(io.dcloud.a.this, null, "ba_pull", null);
            io.dcloud.a aVar = io.dcloud.a.this;
            aVar.a(aVar.getIntent());
            io.dcloud.a.this.d = "Main_Path_" + io.dcloud.a.this.e;
            io.dcloud.p.i.a("Main_App");
            io.dcloud.common.adapter.util.Logger.d(io.dcloud.a.this.d, "onCreate appid=" + io.dcloud.a.this.e);
            io.dcloud.a.this.a(new io.dcloud.a.RunnableC0024a.RunnableC0025a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements io.dcloud.common.DHInterface.ICallBack {

        /* JADX INFO: renamed from: io.dcloud.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class ViewOnClickListenerC0026a implements android.view.View.OnClickListener {
            ViewOnClickListenerC0026a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        }

        b() {
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            io.dcloud.p.f4 f4Var = new io.dcloud.p.f4(io.dcloud.a.this.that);
            f4Var.b(io.dcloud.a.this.getContext().getString(io.dcloud.base.R.string.dcloud_common_tips));
            f4Var.a(io.dcloud.a.this.getContext().getString(io.dcloud.base.R.string.dcloud_ua_version_verify_fail_tips));
            f4Var.b(io.dcloud.a.this.that.getString(android.R.string.ok), new io.dcloud.a.b.ViewOnClickListenerC0026a());
            f4Var.show();
            f4Var.b((int) (((double) io.dcloud.a.this.getResources().getDisplayMetrics().widthPixels) * 0.9d));
            f4Var.a(17);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements io.dcloud.common.DHInterface.ICallBack {
        final /* synthetic */ io.dcloud.common.DHInterface.ICallBack a;
        final /* synthetic */ io.dcloud.common.DHInterface.ICallBack b;
        final /* synthetic */ java.lang.Runnable c;

        c(io.dcloud.common.DHInterface.ICallBack iCallBack, io.dcloud.common.DHInterface.ICallBack iCallBack2, java.lang.Runnable runnable) {
            this.a = iCallBack;
            this.b = iCallBack2;
            this.c = runnable;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            int iIntValue = ((java.lang.Integer) this.a.onCallBack(i, obj)).intValue();
            if (iIntValue == 1) {
                this.b.onCallBack(i, null);
                return java.lang.Boolean.FALSE;
            }
            if (iIntValue == 2) {
                java.lang.Runnable runnable = this.c;
                if (runnable != null) {
                    runnable.run();
                }
                return java.lang.Boolean.FALSE;
            }
            if (iIntValue != 3) {
                return java.lang.Boolean.FALSE;
            }
            java.lang.Runnable runnable2 = this.c;
            if (runnable2 != null) {
                runnable2.run();
            }
            return java.lang.Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements io.dcloud.common.DHInterface.ICallBack {
        final /* synthetic */ io.dcloud.common.DHInterface.ICallBack a;

        /* JADX INFO: renamed from: io.dcloud.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class C0027a implements io.dcloud.common.DHInterface.ICallBack {
            final /* synthetic */ android.widget.TextView[] a;

            C0027a(android.widget.TextView[] textViewArr) {
                this.a = textViewArr;
            }

            @Override // io.dcloud.common.DHInterface.ICallBack
            public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                if (obj == null) {
                    return null;
                }
                this.a[0] = (android.widget.TextView) obj;
                return null;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class b implements io.dcloud.common.DHInterface.ICallBack {
            final /* synthetic */ android.app.Dialog a;

            b(android.app.Dialog dialog) {
                this.a = dialog;
            }

            @Override // io.dcloud.common.DHInterface.ICallBack
            public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                this.a.dismiss();
                return io.dcloud.a.d.this.a.onCallBack(i, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class c implements io.dcloud.common.DHInterface.IWebViewInstallListener {
            final /* synthetic */ android.widget.TextView[] a;

            /* JADX INFO: renamed from: io.dcloud.a$d$c$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
            class RunnableC0028a implements java.lang.Runnable {
                final /* synthetic */ int a;

                RunnableC0028a(int i) {
                    this.a = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    io.dcloud.a.d.c cVar = io.dcloud.a.d.c.this;
                    cVar.a[0].setText(java.lang.String.format(io.dcloud.a.this.getContext().getString(io.dcloud.base.R.string.dcloud_x5_download_progress), java.lang.Integer.valueOf(this.a)));
                }
            }

            c(android.widget.TextView[] textViewArr) {
                this.a = textViewArr;
            }

            @Override // io.dcloud.common.DHInterface.IWebViewInstallListener
            public void onDownloadFinish(int i) {
            }

            @Override // io.dcloud.common.DHInterface.IWebViewInstallListener
            public void onDownloadProgress(int i) {
                if (this.a[0] != null) {
                    new android.os.Handler(android.os.Looper.getMainLooper()).post(new io.dcloud.a.d.c.RunnableC0028a(i));
                }
            }

            @Override // io.dcloud.common.DHInterface.IWebViewInstallListener
            public void onInstallFinish(int i) {
            }
        }

        d(io.dcloud.common.DHInterface.ICallBack iCallBack) {
            this.a = iCallBack;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            android.widget.TextView[] textViewArr = {null};
            io.dcloud.a aVar = io.dcloud.a.this;
            android.app.Dialog dialogA = aVar.a(aVar, new io.dcloud.a.d.C0027a(textViewArr));
            dialogA.show();
            io.dcloud.common.adapter.ui.webview.WebViewFactory.setOtherCallBack(new io.dcloud.a.d.b(dialogA));
            io.dcloud.common.adapter.ui.webview.WebViewFactory.setWebViewInstallListener(new io.dcloud.a.d.c(textViewArr));
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class e implements io.dcloud.common.DHInterface.ICallBack {
        final /* synthetic */ io.dcloud.common.DHInterface.ICallBack a;
        final /* synthetic */ boolean b;
        final /* synthetic */ io.dcloud.common.DHInterface.ICallBack c;

        /* JADX INFO: renamed from: io.dcloud.a$e$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class ViewOnClickListenerC0029a implements android.view.View.OnClickListener {
            ViewOnClickListenerC0029a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                io.dcloud.common.util.AppRuntime.initX5(io.dcloud.a.this.getApplication(), true, null);
                io.dcloud.a.e.this.a.onCallBack(1, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class b implements android.view.View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                io.dcloud.a.e.this.c.onCallBack(-1, null);
            }
        }

        e(io.dcloud.common.DHInterface.ICallBack iCallBack, boolean z, io.dcloud.common.DHInterface.ICallBack iCallBack2) {
            this.a = iCallBack;
            this.b = z;
            this.c = iCallBack2;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            if (i == 0) {
                this.a.onCallBack(0, null);
            } else if (i == 1) {
                if (this.b) {
                    io.dcloud.p.f4 f4Var = new io.dcloud.p.f4(io.dcloud.a.this.that);
                    f4Var.b(io.dcloud.a.this.getContext().getString(io.dcloud.base.R.string.dcloud_common_tips));
                    f4Var.a(io.dcloud.a.this.getContext().getString(io.dcloud.base.R.string.dcloud_x5_download_without_wifi));
                    f4Var.b(io.dcloud.a.this.that.getString(io.dcloud.base.R.string.dcloud_common_allow), new io.dcloud.a.e.ViewOnClickListenerC0029a());
                    f4Var.a(io.dcloud.a.this.that.getString(io.dcloud.base.R.string.dcloud_common_no_allow), new io.dcloud.a.e.b());
                    f4Var.show();
                } else {
                    this.c.onCallBack(-1, null);
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class f implements android.content.DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class h implements io.dcloud.p.f3.b {
        h() {
        }

        @Override // io.dcloud.p.f3.b
        public void a(java.lang.String str, boolean z) {
            io.dcloud.common.adapter.util.DeviceInfo.oaids = str;
            io.dcloud.common.adapter.util.SP.setBundleData(io.dcloud.a.this.getContext(), io.dcloud.common.util.BaseInfo.PDR, "android_ten_ids", str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class j extends io.dcloud.common.adapter.util.PermissionUtil.Request {
        j() {
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onDenied(java.lang.String str) {
            if (str.equals(com.hjq.permissions.Permission.READ_PHONE_STATE) && io.dcloud.a.this.g != null && io.dcloud.a.this.g.equalsIgnoreCase("ALWAYS")) {
                int i = io.dcloud.PdrR.getInt(io.dcloud.a.this, "string", "dcloud_permission_read_phone_state_message");
                androidx.appcompat.app.AlertDialog alertDialog = io.dcloud.a.this.i;
                if (alertDialog == null || !alertDialog.isShowing()) {
                    io.dcloud.a.this.a(str, i);
                    return;
                }
                return;
            }
            if (str.equals(io.dcloud.common.adapter.util.PermissionUtil.PMS_STORAGE)) {
                if (io.dcloud.a.this.h != null && io.dcloud.a.this.h.equals("once")) {
                    io.dcloud.a.this.checkAndRequestPhoneState();
                    android.os.Handler handler = new android.os.Handler();
                    io.dcloud.a aVar = io.dcloud.a.this;
                    handler.postDelayed(aVar.n, aVar.j);
                    return;
                }
                int i2 = io.dcloud.PdrR.getInt(io.dcloud.a.this, "string", "dcloud_permission_write_external_storage_message");
                androidx.appcompat.app.AlertDialog alertDialog2 = io.dcloud.a.this.i;
                if (alertDialog2 == null || !alertDialog2.isShowing()) {
                    io.dcloud.a.this.a(io.dcloud.common.adapter.util.PermissionUtil.convert2SystemPermission(str), i2);
                }
            }
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onGranted(java.lang.String str) {
            if (str.equals(io.dcloud.common.adapter.util.PermissionUtil.PMS_STORAGE)) {
                io.dcloud.common.adapter.util.DeviceInfo.initPath(io.dcloud.a.this.that);
                io.dcloud.a.this.checkAndRequestPhoneState();
                android.os.Handler handler = new android.os.Handler();
                io.dcloud.a aVar = io.dcloud.a.this;
                handler.postDelayed(aVar.n, aVar.j);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class k implements android.content.DialogInterface.OnClickListener {
        k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            io.dcloud.a.this.finish();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class l implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ java.lang.String a;

        l(java.lang.String str) {
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            if (androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale(io.dcloud.a.this, io.dcloud.common.adapter.util.PermissionUtil.convert2SystemPermission(this.a))) {
                io.dcloud.a.this.a(new java.lang.String[]{this.a});
                return;
            }
            try {
                android.content.Intent intent = new android.content.Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(android.net.Uri.fromParts("package", io.dcloud.a.this.getPackageName(), null));
                int i2 = io.dcloud.a.this.k;
                if (!this.a.equalsIgnoreCase(com.hjq.permissions.Permission.READ_PHONE_STATE)) {
                    i2 = io.dcloud.a.this.l;
                }
                io.dcloud.a.this.startActivityForResult(intent, i2);
            } catch (java.lang.Exception unused) {
                io.dcloud.a.this.finish();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class m implements io.dcloud.common.DHInterface.ICallBack {
        m() {
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            java.lang.String str = io.dcloud.common.util.BaseInfo.minUserAgentVersion;
            if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
                str = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT;
            }
            io.dcloud.common.adapter.ui.webview.WebViewFactory.resetSysWebViewState();
            io.dcloud.common.adapter.ui.webview.WebViewFactory.resetUA();
            int i2 = io.dcloud.common.adapter.ui.webview.WebViewFactory.verifyVersion(io.dcloud.common.adapter.ui.webview.WebViewFactory.getWebViewUserAgentVersion(io.dcloud.a.this.getContext()), str) ? 2 : 1;
            if (i == 1 && obj != null && io.dcloud.common.adapter.ui.webview.WebViewFactory.verifyVersion(io.dcloud.common.adapter.ui.webview.WebViewFactory.getWebViewUserAgentVersion(io.dcloud.a.this.getApplication(), ((io.dcloud.common.DHInterface.IWebViewFactory) obj).getDefWebViewUA(io.dcloud.a.this.getApplication())), str)) {
                i2 = 3;
            }
            return java.lang.Integer.valueOf(i2);
        }
    }

    a() {
    }

    private void h() {
        java.lang.String metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DClOUD_SECURITY_POLICY");
        if (android.text.TextUtils.isEmpty(metaValue) || !metaValue.equals("safe")) {
            io.dcloud.common.util.BaseInfo.isDefense = false;
        } else {
            io.dcloud.common.util.BaseInfo.isDefense = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if ((!io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() || android.text.TextUtils.isEmpty(io.dcloud.feature.internal.sdk.SDK.customOAID)) && io.dcloud.common.util.PdrUtil.isSupportOaid() && !io.dcloud.common.util.AppRuntime.hasPrivacyForNotShown(this)) {
            if (io.dcloud.common.util.PdrUtil.isEmpty(io.dcloud.common.adapter.util.DeviceInfo.oaids) || io.dcloud.common.adapter.util.DeviceInfo.oaids.equals(com.taobao.weex.el.parse.Operators.OR)) {
                io.dcloud.common.adapter.util.DeviceInfo.oaids = io.dcloud.common.adapter.util.SP.getBundleData(getContext(), io.dcloud.common.util.BaseInfo.PDR, "android_ten_ids");
                new io.dcloud.p.f3(new io.dcloud.a.h()).b(this);
            }
        }
    }

    private void j() {
        io.dcloud.p.r3.a().a(new io.dcloud.p.s3().getPdrModuleMap());
    }

    public void checkAndRequestPhoneState() {
        java.lang.String str = this.g;
        if (str != null) {
            if (!str.equalsIgnoreCase("once")) {
                if (this.g.equalsIgnoreCase("always")) {
                    a(new java.lang.String[]{com.hjq.permissions.Permission.READ_PHONE_STATE});
                }
            } else {
                if (io.dcloud.common.adapter.util.SP.getBundleData(getContext(), "dcloud_phone_read_state", "isshow").equals("1")) {
                    return;
                }
                io.dcloud.common.adapter.util.SP.setBundleData(getContext(), "dcloud_phone_read_state", "isshow", "1");
                a(new java.lang.String[]{com.hjq.permissions.Permission.READ_PHONE_STATE});
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0053  */
    public void checkAndRequestStoragePermission() {
        java.lang.String[] strArr;
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            new android.os.Handler().postDelayed(this.n, this.j);
            return;
        }
        java.lang.String str = this.h;
        if (str == null) {
            strArr = new java.lang.String[]{com.hjq.permissions.Permission.WRITE_EXTERNAL_STORAGE};
        } else if (str.equalsIgnoreCase("once")) {
            if (io.dcloud.common.adapter.util.SP.getBundleData(getContext(), "dcloud_phone_read_state", "isStorageRequest").equals("1")) {
                strArr = null;
            } else {
                strArr = new java.lang.String[]{com.hjq.permissions.Permission.WRITE_EXTERNAL_STORAGE};
                io.dcloud.common.adapter.util.SP.setBundleData(getContext(), "dcloud_phone_read_state", "isStorageRequest", "1");
            }
        } else if (this.h.equalsIgnoreCase("always")) {
            strArr = new java.lang.String[]{com.hjq.permissions.Permission.WRITE_EXTERNAL_STORAGE};
        } else {
            strArr = null;
        }
        if (strArr != null) {
            a(strArr);
        } else {
            checkAndRequestPhoneState();
            new android.os.Handler().postDelayed(this.n, this.j);
        }
    }

    protected void displayBriefMemory() {
        ((android.app.ActivityManager) getSystemService("activity")).getMemoryInfo(new android.app.ActivityManager.MemoryInfo());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public android.content.res.Resources getResources() {
        android.content.res.Resources resources = super.getResources();
        android.content.res.Configuration configuration = resources.getConfiguration();
        try {
            if (!"none".equals(io.dcloud.common.util.BaseInfo.sFontScale)) {
                float f2 = configuration.fontScale;
                float f3 = io.dcloud.common.util.BaseInfo.sFontScaleFloat;
                if (f2 != f3) {
                    configuration.fontScale = f3;
                }
            } else if (configuration.fontScale != 1.0f) {
                configuration.fontScale = 1.0f;
                return resources;
            }
        } catch (java.lang.Exception unused) {
        }
        return resources;
    }

    protected void handleNewIntent(android.content.Intent intent) {
        io.dcloud.EntryProxy entryProxy;
        setIntent(intent);
        a(intent);
        java.lang.StringBuilder sb = new java.lang.StringBuilder("BaseActivity handleNewIntent =");
        sb.append(this.e);
        sb.append(";");
        sb.append(intent.getFlags() != 274726912);
        io.dcloud.common.adapter.util.Logger.d("syncStartApp", sb.toString());
        if (intent.getFlags() != 274726912 && (entryProxy = this.f) != null) {
            entryProxy.onNewIntent(this.that, intent);
        }
        if (io.dcloud.common.util.BaseInfo.SyncDebug && intent.getBooleanExtra("debug_restart", false)) {
            io.dcloud.EntryProxy entryProxy2 = this.f;
            if (entryProxy2 == null || entryProxy2.getCoreHandler() == null) {
                intent.setFlags(335544320);
                startActivity(intent);
                java.lang.Runtime.getRuntime().exit(0);
            } else {
                java.lang.String stringExtra = intent.getStringExtra("appid");
                io.dcloud.common.DHInterface.ICore coreHandler = this.f.getCoreHandler();
                io.dcloud.common.DHInterface.IMgr.MgrType mgrType = io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr;
                if (io.dcloud.common.util.PdrUtil.isEmpty(stringExtra)) {
                    stringExtra = "snc:CID";
                }
                coreHandler.dispatchEvent(mgrType, 3, stringExtra);
            }
        }
    }

    public boolean hasAdService() {
        return true;
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
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, android.content.Intent intent) {
        java.lang.String str;
        androidx.appcompat.app.AlertDialog alertDialog;
        io.dcloud.common.adapter.util.Logger.d(this.d, "onActivityResult");
        io.dcloud.common.adapter.util.PermissionUtil.onActivityResult(this.that, i2, i3, intent);
        io.dcloud.EntryProxy entryProxy = this.f;
        if (entryProxy != null) {
            entryProxy.onActivityExecute(this.that, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult, new java.lang.Object[]{java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), intent});
        }
        if (i2 == this.k && (str = this.g) != null && str.equalsIgnoreCase("always") && (alertDialog = this.i) != null && !alertDialog.isShowing()) {
            a(new java.lang.String[]{com.hjq.permissions.Permission.READ_PHONE_STATE});
        }
        if (i2 == this.l) {
            java.lang.String str2 = this.h;
            if (str2 == null || !(str2.equalsIgnoreCase("once") || this.h.equalsIgnoreCase("none"))) {
                a(new java.lang.String[]{com.hjq.permissions.Permission.WRITE_EXTERNAL_STORAGE});
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        io.dcloud.EntryProxy entryProxy;
        if (!io.dcloud.common.util.BaseInfo.USE_ACTIVITY_HANDLE_KEYEVENT) {
            super.onBackPressed();
        } else {
            if (onKeyEventExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp, 4, null) || (entryProxy = this.f) == null) {
                return;
            }
            entryProxy.destroy(this.that);
            super.onBackPressed();
        }
    }

    public void onCloseSplash() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        try {
            io.dcloud.common.adapter.util.Logger.d(this.d, "onConfigurationChanged");
            int i2 = getResources().getConfiguration().orientation;
            io.dcloud.EntryProxy entryProxy = this.f;
            if (entryProxy != null) {
                entryProxy.onConfigurationChanged(this.that, i2);
            }
            super.onConfigurationChanged(configuration);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        io.dcloud.common.ui.PrivacyManager.getInstance().restartPrivacyDialogIfNeed(this);
    }

    @Override // io.dcloud.b, io.src.dcloud.adapter.DCloudBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            getWindow().setNavigationBarContrastEnforced(false);
        }
        if (io.dcloud.common.ui.PrivacyManager.isDebugMode()) {
            io.dcloud.common.ui.PrivacyManager.getInstance().reInit(getContext(), null);
        }
        j();
        h();
        java.lang.String metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_READ_PHONE_STATE");
        this.g = metaValue;
        if (metaValue == null) {
            this.g = "none";
        }
        this.n = new io.dcloud.a.RunnableC0024a(bundle);
        java.lang.String metaValue2 = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_UNISTATISTICS");
        io.dcloud.common.util.BaseInfo.isUniStatistics = false;
        if (!android.text.TextUtils.isEmpty(metaValue2) && java.lang.Boolean.parseBoolean(metaValue2)) {
            io.dcloud.common.util.BaseInfo.isUniStatistics = true;
        }
        if (!io.dcloud.application.DCLoudApplicationImpl.self().isInit()) {
            java.lang.String string = getString(io.dcloud.base.R.string.dcloud_Init_fail_tips);
            io.dcloud.common.util.BaseInfo.USE_ACTIVITY_HANDLE_KEYEVENT = true;
            io.dcloud.common.util.ErrorDialogUtil.showErrorTipsAlert(this, string, new io.dcloud.a.f());
            return;
        }
        java.lang.String metaValue3 = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_WRITE_EXTERNAL_STORAGE");
        this.h = metaValue3;
        if (metaValue3 == null) {
            this.h = "none";
        }
        io.dcloud.common.ui.PrivacyManager.getInstance().showPrivacyDialog(this, new io.dcloud.a.g(), false, false);
        io.dcloud.common.adapter.util.UEH.catchUncaughtException(this.that.getApplicationContext());
        android.util.Log.d("download_manager", "BaseActivity onCreate");
        io.dcloud.common.util.TestUtil.print(io.dcloud.common.util.TestUtil.START_STREAM_APP, "BaseActivity onCreate");
        onRuntimePreCreate(bundle);
        onCreateSplash(this.that);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        io.dcloud.common.adapter.util.Logger.d(this.d, "onCreateOptionsMenu appid=" + this.e);
        io.dcloud.EntryProxy entryProxy = this.f;
        return entryProxy != null ? entryProxy.onActivityExecute(this.that, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onCreateOptionMenu, menu) : super.onCreateOptionsMenu(menu);
    }

    public abstract java.lang.Object onCreateSplash(android.content.Context context);

    @Override // io.dcloud.b, io.src.dcloud.adapter.DCloudBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        io.dcloud.common.util.DisplayManagerChangeListener displayManagerChangeListener = this.m;
        if (displayManagerChangeListener != null) {
            displayManagerChangeListener.unregister();
        }
        io.dcloud.p.i.b("Main_App");
        io.dcloud.common.adapter.util.Logger.d(this.d, "onDestroy appid=" + this.e);
        io.dcloud.EntryProxy entryProxy = this.f;
        if (entryProxy != null) {
            entryProxy.onStop(this.that);
        }
        java.util.HashMap<java.lang.String, io.dcloud.common.util.BaseInfo.CmtInfo> map = io.dcloud.common.util.BaseInfo.mLaunchers;
        if (map != null) {
            map.clear();
        }
        io.dcloud.common.adapter.util.MessageHandler.removeCallbacksAndMessages();
        io.dcloud.common.core.permission.PermissionControler.clearCRequestPermissionsCache();
        io.dcloud.p.r3.a().b();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, android.view.KeyEvent keyEvent) {
        io.dcloud.common.adapter.util.Logger.e("back", "BaseActivity onKeyDown");
        if (!io.dcloud.common.util.BaseInfo.USE_ACTIVITY_HANDLE_KEYEVENT) {
            return super.onKeyDown(i2, keyEvent);
        }
        boolean zOnKeyEventExecute = keyEvent.getRepeatCount() == 0 ? onKeyEventExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyDown, i2, keyEvent) : onKeyEventExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyLongPress, i2, keyEvent);
        if (zOnKeyEventExecute && i2 == 4) {
            onBackPressed();
        }
        return zOnKeyEventExecute ? zOnKeyEventExecute : super.onKeyDown(i2, keyEvent);
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
    public boolean onKeyEventExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, int i2, android.view.KeyEvent keyEvent) {
        io.dcloud.EntryProxy entryProxy = this.f;
        if (entryProxy != null) {
            return entryProxy.onActivityExecute(this.that, sysEventType, new java.lang.Object[]{java.lang.Integer.valueOf(i2), keyEvent});
        }
        return false;
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
    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i2, android.view.KeyEvent keyEvent) {
        if (!io.dcloud.common.util.BaseInfo.USE_ACTIVITY_HANDLE_KEYEVENT) {
            return super.onKeyLongPress(i2, keyEvent);
        }
        io.dcloud.EntryProxy entryProxy = this.f;
        boolean zOnActivityExecute = entryProxy != null ? entryProxy.onActivityExecute(this.that, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyLongPress, new java.lang.Object[]{java.lang.Integer.valueOf(i2), keyEvent}) : false;
        return zOnActivityExecute ? zOnActivityExecute : super.onKeyLongPress(i2, keyEvent);
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
    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, android.view.KeyEvent keyEvent) {
        io.dcloud.EntryProxy entryProxy;
        if (!io.dcloud.common.util.BaseInfo.USE_ACTIVITY_HANDLE_KEYEVENT) {
            return super.onKeyUp(i2, keyEvent);
        }
        io.dcloud.common.adapter.util.Logger.d(this.d, "onKeyUp");
        boolean zOnActivityExecute = false;
        if (i2 != 4 && (entryProxy = this.f) != null) {
            zOnActivityExecute = entryProxy.onActivityExecute(this.that, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp, new java.lang.Object[]{java.lang.Integer.valueOf(i2), keyEvent});
        }
        return zOnActivityExecute ? zOnActivityExecute : super.onKeyUp(i2, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        io.dcloud.common.adapter.util.Logger.d(this.d, "onLowMemory");
        displayBriefMemory();
    }

    @Override // io.src.dcloud.adapter.DCloudBaseActivity
    public void onNewIntentImpl(android.content.Intent intent) {
        super.onNewIntentImpl(intent);
        io.dcloud.common.adapter.util.Logger.d("syncStartApp", "BaseActivity onNewIntent appid=" + this.e);
        handleNewIntent(intent);
    }

    @Override // io.dcloud.b, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        io.dcloud.common.adapter.util.Logger.d(this.d, "onPause appid=" + this.e);
        io.dcloud.EntryProxy entryProxy = this.f;
        if (entryProxy != null) {
            entryProxy.onPause(this.that);
        }
    }

    public void onPrivacySureAction() {
        i();
        checkAndRequestStoragePermission();
        io.dcloud.common.util.AppRuntime.initUniappPlugin(getApplication());
        io.dcloud.common.util.AppRuntime.initUTS();
        io.dcloud.common.util.net.http.CookieManager.initCookieConfig(getApplication());
        io.dcloud.common.util.NativeCrashManager.initNativeCrash(this);
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
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, java.lang.String[] strArr, int[] iArr) {
        io.dcloud.common.adapter.util.PermissionUtil.onSystemPermissionsResult(this.that, i2, strArr, iArr);
        io.dcloud.EntryProxy entryProxy = this.f;
        if (entryProxy != null) {
            entryProxy.onActivityExecute(this.that, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onRequestPermissionsResult, new java.lang.Object[]{java.lang.Integer.valueOf(i2), strArr, iArr});
        }
        io.dcloud.common.core.permission.PermissionControler.runNextRequestPermission(this, i2);
    }

    @Override // io.dcloud.b, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a(getIntent());
        io.dcloud.common.adapter.util.PermissionUtil.onRequestSysPermissionResume(this.that);
        io.dcloud.common.adapter.util.Logger.d(this.d, "onResume appid=" + this.e);
        io.dcloud.EntryProxy entryProxy = this.f;
        if (entryProxy != null) {
            entryProxy.onResume(this.that);
        }
        if (io.dcloud.common.util.BaseInfo.mDeStatusBarBackground == -111111) {
            io.dcloud.common.util.BaseInfo.mDeStatusBarBackground = getWindow().getStatusBarColor();
        }
    }

    protected void onRuntimeCreate(android.os.Bundle bundle) {
        io.dcloud.common.adapter.util.Logger.d(this.d, "onRuntimeCreate appid=" + this.e);
        io.dcloud.EntryProxy entryProxyInit = io.dcloud.EntryProxy.init(this.that);
        this.f = entryProxyInit;
        entryProxyInit.onCreate(this.that, bundle, io.dcloud.common.util.BaseInfo.sRuntimeMode, (io.dcloud.common.DHInterface.IOnCreateSplashView) null);
        if (this.m == null) {
            this.m = new io.dcloud.common.util.DisplayManagerChangeListener((android.hardware.display.DisplayManager) getSystemService("display"), this.that, this.f);
        }
        this.m.register();
    }

    protected void onRuntimePreCreate(android.os.Bundle bundle) {
        android.util.Log.d(this.d, "onRuntimePreCreate appid=" + this.e);
        this.that.getWindow().setFormat(-3);
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
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(android.os.Bundle bundle) {
        if (bundle != null && getIntent() != null && getIntent().getExtras() != null) {
            bundle.putAll(getIntent().getExtras());
        }
        io.dcloud.common.adapter.util.Logger.d(this.d, "onSaveInstanceState");
        io.dcloud.EntryProxy entryProxy = this.f;
        if (entryProxy != null) {
            entryProxy.onActivityExecute(this.that, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onSaveInstanceState, new java.lang.Object[]{bundle});
        }
        super.onSaveInstanceState(bundle);
    }

    public void setSecondPrivacyAlert() {
        io.dcloud.common.ui.PrivacyManager.getInstance().showPrivacyDialog(this, new io.dcloud.a.i(), true, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateParam(java.lang.String str, java.lang.Object obj) {
        if ("tab_change".equals(str)) {
            io.dcloud.common.adapter.util.Logger.d("BaseActivity updateParam newintent value(appid)=" + obj);
            this.f.getCoreHandler().dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 21, obj);
            return;
        }
        if ("closewebapp".equals(str)) {
            io.dcloud.common.adapter.util.Logger.e("IAN", "updateParam closewebapp");
            android.app.Activity activity = (android.app.Activity) obj;
            android.os.Bundle extras = activity.getIntent().getExtras();
            java.lang.String string = (extras == null || !extras.containsKey("appid")) ? null : extras.getString("appid");
            if (android.text.TextUtils.isEmpty(string)) {
                string = io.dcloud.common.util.BaseInfo.sDefaultBootApp;
            }
            if (activity instanceof io.dcloud.common.DHInterface.IActivityHandler) {
                ((io.dcloud.common.DHInterface.IActivityHandler) activity).closeAppStreamSplash(string);
            }
            this.f.getCoreHandler().dispatchEvent(null, 0, new java.lang.Object[]{activity, activity.getIntent(), string});
            io.dcloud.common.adapter.util.Logger.e("IAN", "updateParam closewebapp WEBAPP_QUIT");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class i implements io.dcloud.common.ui.PrivacyManager.b {
        i() {
        }

        @Override // io.dcloud.common.ui.PrivacyManager.b
        public void a(java.lang.String str) {
            io.dcloud.a.this.i();
            io.dcloud.common.util.AppRuntime.initUTS();
            io.dcloud.common.util.net.http.CookieManager.initCookieConfig(io.dcloud.a.this.getApplication());
            io.dcloud.common.util.NativeCrashManager.initNativeCrash(io.dcloud.a.this);
        }

        @Override // io.dcloud.common.ui.PrivacyManager.b
        public void b(io.dcloud.common.ui.Info.AndroidPrivacyResponse androidPrivacyResponse) {
            android.os.Handler handler = new android.os.Handler();
            io.dcloud.a aVar = io.dcloud.a.this;
            handler.postDelayed(aVar.n, aVar.j);
            if (androidPrivacyResponse.disagreeMode.loadNativePlugins) {
                io.dcloud.common.util.AppRuntime.initUniappPlugin(io.dcloud.a.this.getApplication());
            }
            io.dcloud.common.util.net.http.CookieManager.initCookieConfig(io.dcloud.a.this.getApplication());
        }

        @Override // io.dcloud.common.ui.PrivacyManager.b
        public void a() {
            io.dcloud.a.this.i();
            io.dcloud.a.this.checkAndRequestStoragePermission();
            io.dcloud.common.util.AppRuntime.initUniappPlugin(io.dcloud.a.this.getApplication());
            io.dcloud.common.util.AppRuntime.initUTS();
            io.dcloud.common.util.net.http.CookieManager.initCookieConfig(io.dcloud.a.this.getApplication());
            io.dcloud.common.util.NativeCrashManager.initNativeCrash(io.dcloud.a.this);
        }

        @Override // io.dcloud.common.ui.PrivacyManager.b
        public void a(io.dcloud.common.ui.Info.AndroidPrivacyResponse androidPrivacyResponse) {
            if (!androidPrivacyResponse.disagreeMode.support) {
                io.dcloud.a.this.finish();
                android.os.Process.killProcess(android.os.Process.myPid());
                return;
            }
            android.os.Handler handler = new android.os.Handler();
            io.dcloud.a aVar = io.dcloud.a.this;
            handler.postDelayed(aVar.n, aVar.j);
            if (androidPrivacyResponse.disagreeMode.loadNativePlugins) {
                io.dcloud.common.util.AppRuntime.initUniappPlugin(io.dcloud.a.this.getApplication());
            }
            io.dcloud.common.util.net.http.CookieManager.initCookieConfig(io.dcloud.a.this.getApplication());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String[] strArr) {
        io.dcloud.common.adapter.util.PermissionUtil.useSystemPermissions(this.that, strArr, new io.dcloud.a.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, int i2) {
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this.that);
        if (i2 == 0) {
            i2 = io.dcloud.PdrR.getInt(this, "string", io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_APPNAME);
        }
        androidx.appcompat.app.AlertDialog alertDialogCreate = builder.setMessage(i2).setPositiveButton(android.R.string.ok, new io.dcloud.a.l(str)).setNegativeButton(android.R.string.cancel, new io.dcloud.a.k()).create();
        this.i = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(false);
        this.i.setCancelable(false);
        this.i.show();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class g implements io.dcloud.common.ui.PrivacyManager.b {
        g() {
        }

        @Override // io.dcloud.common.ui.PrivacyManager.b
        public void a(java.lang.String str) {
            io.dcloud.a.this.i();
            if (str.equalsIgnoreCase("custom")) {
                android.os.Handler handler = new android.os.Handler();
                io.dcloud.a aVar = io.dcloud.a.this;
                handler.postDelayed(aVar.n, aVar.j);
            } else {
                io.dcloud.a.this.checkAndRequestStoragePermission();
            }
            io.dcloud.common.util.net.http.CookieManager.initCookieConfig(io.dcloud.a.this.getApplication());
            io.dcloud.common.util.AppRuntime.initUTS();
            io.dcloud.common.util.NativeCrashManager.initNativeCrash(io.dcloud.a.this);
        }

        @Override // io.dcloud.common.ui.PrivacyManager.b
        public void b(io.dcloud.common.ui.Info.AndroidPrivacyResponse androidPrivacyResponse) {
            android.os.Handler handler = new android.os.Handler();
            io.dcloud.a aVar = io.dcloud.a.this;
            handler.postDelayed(aVar.n, aVar.j);
            if (androidPrivacyResponse.disagreeMode.loadNativePlugins) {
                io.dcloud.common.util.AppRuntime.initUniappPlugin(io.dcloud.a.this.getApplication());
            }
            io.dcloud.common.util.net.http.CookieManager.initCookieConfig(io.dcloud.a.this.getApplication());
        }

        @Override // io.dcloud.common.ui.PrivacyManager.b
        public void a() {
            io.dcloud.a.this.onPrivacySureAction();
        }

        @Override // io.dcloud.common.ui.PrivacyManager.b
        public void a(io.dcloud.common.ui.Info.AndroidPrivacyResponse androidPrivacyResponse) {
            if (android.text.TextUtils.isEmpty(androidPrivacyResponse.second.message)) {
                if (!androidPrivacyResponse.disagreeMode.support) {
                    io.dcloud.a.this.finish();
                    android.os.Process.killProcess(android.os.Process.myPid());
                    return;
                }
                android.os.Handler handler = new android.os.Handler();
                io.dcloud.a aVar = io.dcloud.a.this;
                handler.postDelayed(aVar.n, aVar.j);
                if (androidPrivacyResponse.disagreeMode.loadNativePlugins) {
                    io.dcloud.common.util.AppRuntime.initUniappPlugin(io.dcloud.a.this.getApplication());
                }
                io.dcloud.common.util.net.http.CookieManager.initCookieConfig(io.dcloud.a.this.getApplication());
                return;
            }
            io.dcloud.a.this.setSecondPrivacyAlert();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.content.Intent intent) {
        android.os.Bundle extras = intent.getExtras();
        if (extras == null || !extras.containsKey("appid")) {
            return;
        }
        this.e = extras.getString("appid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.Runnable runnable) {
        if (io.dcloud.common.util.PdrUtil.isEquals(io.dcloud.common.util.BaseInfo.renderer.toLowerCase(), "native")) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        io.dcloud.a.m mVar = new io.dcloud.a.m();
        io.dcloud.a.c cVar = new io.dcloud.a.c(mVar, new io.dcloud.a.b(), runnable);
        io.dcloud.a.d dVar = new io.dcloud.a.d(cVar);
        try {
            java.lang.Class.forName("io.dcloud.feature.x5.X5InitImpl");
            io.dcloud.common.util.AppRuntime.preInitX5(getApplication());
            if (!io.dcloud.common.adapter.ui.webview.WebViewFactory.isOtherInitialised() && !io.dcloud.common.adapter.ui.webview.WebViewFactory.isIsLoadOtherTimeOut()) {
                int iIntValue = ((java.lang.Integer) mVar.onCallBack(-1, null)).intValue();
                if (iIntValue == 1) {
                    boolean z = io.dcloud.common.util.BaseInfo.showTipsWithoutWifi;
                    boolean z2 = io.dcloud.common.util.BaseInfo.allowDownloadWithoutWiFi;
                    if (!io.dcloud.common.adapter.ui.webview.WebViewFactory.isOther()) {
                        io.dcloud.common.util.AppRuntime.initX5(getApplication(), z2, new io.dcloud.a.e(dVar, z, cVar));
                        return;
                    } else {
                        dVar.onCallBack(z ? 1 : 0, null);
                        return;
                    }
                }
                if (iIntValue == 2) {
                    io.dcloud.common.util.AppRuntime.initX5(getApplication(), io.dcloud.common.util.BaseInfo.allowDownloadWithoutWiFi, null);
                    if (runnable != null) {
                        runnable.run();
                        return;
                    }
                    return;
                }
                return;
            }
            cVar.onCallBack(-1, null);
        } catch (java.lang.ClassNotFoundException unused) {
            cVar.onCallBack(-1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.app.Dialog a(android.content.Context context, io.dcloud.common.DHInterface.ICallBack iCallBack) {
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(context, io.dcloud.base.R.style.dialog_transparent);
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) android.view.LayoutInflater.from(context).inflate(io.dcloud.base.R.layout.dcloud_dialog_loading, (android.view.ViewGroup) null);
        viewGroup.findViewById(io.dcloud.base.R.id.loading_background).setBackgroundColor(0);
        viewGroup.findViewById(io.dcloud.base.R.id.bg).setLayoutParams(new android.widget.LinearLayout.LayoutParams(io.dcloud.common.util.DensityUtils.dp2px(context, 150.0f), -2));
        float fDp2px = io.dcloud.common.util.DensityUtils.dp2px(context, 8.0f);
        android.graphics.drawable.ShapeDrawable shapeDrawable = new android.graphics.drawable.ShapeDrawable(new android.graphics.drawable.shapes.RoundRectShape(new float[]{fDp2px, fDp2px, fDp2px, fDp2px, fDp2px, fDp2px, fDp2px, fDp2px}, null, null));
        shapeDrawable.getPaint().setColor(-16777216);
        viewGroup.findViewById(io.dcloud.base.R.id.bg).setBackground(shapeDrawable);
        iCallBack.onCallBack(0, (android.widget.TextView) viewGroup.findViewById(io.dcloud.base.R.id.title));
        androidx.appcompat.app.AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setView(viewGroup, 0, 0, 0, 0);
        return alertDialogCreate;
    }
}
