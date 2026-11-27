package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public final class s extends io.dcloud.common.DHInterface.AbsMgr implements io.dcloud.common.DHInterface.IMgr.AppEvent {
    private static java.lang.String j;
    io.dcloud.p.d4 a;
    java.util.ArrayList b;
    java.util.ArrayList c;
    io.dcloud.p.b4 d;
    java.lang.Class[] e;
    private android.app.AlertDialog f;
    org.json.JSONObject g;
    private android.app.AlertDialog h;
    private android.app.AlertDialog i;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements io.dcloud.common.DHInterface.ICallBack {
        a() {
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            java.lang.String unused = io.dcloud.p.s.j = java.lang.String.valueOf(obj);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.app.Activity a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ io.dcloud.p.d5 c;
        final /* synthetic */ android.widget.CheckBox d;
        final /* synthetic */ java.lang.String e;
        final /* synthetic */ io.dcloud.p.d5 f;
        final /* synthetic */ io.dcloud.p.d5 g;
        final /* synthetic */ boolean h;

        c(android.app.Activity activity, java.lang.String str, io.dcloud.p.d5 d5Var, android.widget.CheckBox checkBox, java.lang.String str2, io.dcloud.p.d5 d5Var2, io.dcloud.p.d5 d5Var3, boolean z) {
            this.a = activity;
            this.b = str;
            this.c = d5Var;
            this.d = checkBox;
            this.e = str2;
            this.f = d5Var2;
            this.g = d5Var3;
            this.h = z;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            if (i != -2) {
                if (i != -3 && i == -1) {
                    if (this.d.isChecked()) {
                        io.dcloud.common.adapter.util.SP.setBundleData(this.a, "pdr", io.dcloud.common.constant.AbsoluteConst.TEST_RUN + this.b, "__am=t");
                    }
                    io.dcloud.p.s.this.a(this.a, this.b, this.e, this.c, this.f, this.g, this.h);
                    io.dcloud.p.s.this.f.dismiss();
                    return;
                }
                return;
            }
            io.dcloud.p.s.this.f.dismiss();
            io.dcloud.common.DHInterface.IActivityHandler iActivityHandler = io.src.dcloud.adapter.DCloudAdapterUtil.getIActivityHandler(this.a);
            if (iActivityHandler != null) {
                iActivityHandler.closeAppStreamSplash(this.b);
                io.dcloud.common.util.BaseInfo.setLoadingLaunchePage(false, "closeSplashScreen0");
                if (io.dcloud.p.s.this.d.e() == 0) {
                    this.a.finish();
                    return;
                }
                io.dcloud.p.d5 d5Var = this.c;
                if (d5Var != null) {
                    d5Var.w();
                }
                android.content.Intent intent = new android.content.Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.HOME");
                this.a.startActivity(intent);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.app.Activity a;

        d(android.app.Activity activity) {
            this.a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(android.net.Uri.parse("https://ask.dcloud.net.cn/article/35627"));
            this.a.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class e implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.app.Activity a;

        e(android.app.Activity activity) {
            this.a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(android.net.Uri.parse("https://ask.dcloud.net.cn/article/35877"));
            this.a.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class f implements io.dcloud.common.DHInterface.ICallBack {
        final /* synthetic */ io.dcloud.p.d5 a;

        f(io.dcloud.p.d5 d5Var) {
            this.a = d5Var;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            if (io.dcloud.common.util.AppRuntime.hasPrivacyForNotShown(this.a.getActivity())) {
                return null;
            }
            ((io.dcloud.common.DHInterface.AbsMgr) io.dcloud.p.s.this).mCore.onRestart(this.a.getActivity());
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class g implements io.dcloud.common.DHInterface.ICallBack {
        final /* synthetic */ io.dcloud.p.d5 a;
        final /* synthetic */ boolean b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ io.dcloud.common.DHInterface.ICallBack d;

        g(io.dcloud.p.d5 d5Var, boolean z, java.lang.String str, io.dcloud.common.DHInterface.ICallBack iCallBack) {
            this.a = d5Var;
            this.b = z;
            this.c = str;
            this.d = iCallBack;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            if (this.a.a(this.b)) {
                this.d.onCallBack(0, null);
            } else {
                io.dcloud.common.adapter.util.Logger.e(io.dcloud.common.adapter.util.Logger.AppMgr_TAG, "reboot " + this.c + " app failed !!!");
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class h implements io.dcloud.common.DHInterface.ICallBack {
        final /* synthetic */ io.dcloud.p.d5 a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ boolean d;

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class a implements io.dcloud.common.DHInterface.ICallBack {
            a() {
            }

            @Override // io.dcloud.common.DHInterface.ICallBack
            public java.lang.Object onCallBack(int i, java.lang.Object obj) {
                io.dcloud.p.s.h hVar = io.dcloud.p.s.h.this;
                io.dcloud.p.s.this.a(hVar.a, hVar.b, hVar.c, hVar.d);
                return null;
            }
        }

        h(io.dcloud.p.d5 d5Var, java.lang.String str, java.lang.String str2, boolean z) {
            this.a = d5Var;
            this.b = str;
            this.c = str2;
            this.d = z;
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            if (!io.dcloud.common.adapter.ui.webview.WebViewFactory.isOther() || io.dcloud.common.adapter.ui.webview.WebViewFactory.isOtherInitialised() || io.dcloud.common.adapter.ui.webview.WebViewFactory.isIsLoadOtherTimeOut()) {
                io.dcloud.p.s.this.a(this.a, this.b, this.c, this.d);
                return null;
            }
            io.dcloud.common.adapter.ui.webview.WebViewFactory.setOtherCallBack(new io.dcloud.p.s.h.a());
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class i implements java.lang.Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                io.dcloud.common.adapter.io.DHFile.deleteFile(io.dcloud.common.constant.StringConst.STREAMAPP_KEY_ROOTPATH + "splash_temp/");
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public s(io.dcloud.common.DHInterface.ICore iCore) {
        super(iCore, io.dcloud.common.adapter.util.Logger.AppMgr_TAG, io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr);
        this.a = null;
        this.b = new java.util.ArrayList(1);
        this.c = new java.util.ArrayList(1);
        this.d = null;
        this.e = new java.lang.Class[0];
        this.g = null;
        if (iCore != null) {
            a(iCore.obtainContext());
        }
        c();
        b();
        d();
        a();
        this.d = new io.dcloud.p.b4(this);
    }

    private void d(io.dcloud.p.d5 d5Var) {
        java.lang.Object objNewInstance = io.dcloud.common.adapter.util.PlatformUtil.newInstance("android.app.ActivityManager$TaskDescription", new java.lang.Class[]{java.lang.String.class, android.graphics.Bitmap.class}, new java.lang.Object[]{d5Var.obtainAppName(), android.graphics.BitmapFactory.decodeResource(getContext().getResources(), getContext().getApplicationInfo().icon)});
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(d5Var.getActivity(), "setTaskDescription", new java.lang.Class[]{objNewInstance.getClass()}, objNewInstance);
    }

    io.dcloud.p.d5 c(java.lang.String str) {
        return a((android.app.Activity) null, str);
    }

    @Override // io.dcloud.common.DHInterface.AbsMgr
    public void dispose() {
        java.util.ArrayList arrayList = this.c;
        if (arrayList != null) {
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                java.lang.Object obj = arrayList.get(i2);
                i2++;
                ((io.dcloud.p.d5) obj).g();
            }
        }
        this.c.clear();
        this.b.clear();
        io.dcloud.p.b4 b4Var = this.d;
        if (b4Var != null) {
            b4Var.a();
        }
        this.d = null;
        io.dcloud.common.util.ThreadPool.self().addThreadTask(new io.dcloud.p.s.i());
    }

    void e(io.dcloud.p.d5 d5Var) {
        this.d.b(d5Var.o);
        b(d5Var);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:200:0x0429  */
    @Override // io.dcloud.common.DHInterface.IMgr
    public java.lang.Object processEvent(io.dcloud.common.DHInterface.IMgr.MgrType mgrType, int i2, java.lang.Object obj) {
        io.dcloud.p.d5 d5VarC;
        java.lang.String strSubstring;
        io.dcloud.p.d5 d5VarA;
        android.content.Intent intentObtainWebAppIntent;
        java.lang.String str;
        try {
            if (!checkMgrId(mgrType)) {
                return this.mCore.dispatchEvent(mgrType, i2, obj);
            }
            boolean z = true;
            switch (i2) {
                case 0:
                    java.lang.Object[] objArr = (java.lang.Object[]) obj;
                    android.app.Activity activity = (android.app.Activity) objArr[0];
                    java.lang.String strValueOf = java.lang.String.valueOf(objArr[1]);
                    java.lang.String strValueOf2 = java.lang.String.valueOf(objArr[2]);
                    android.util.Log.i("ylyl", " AppMGr START_APP " + strValueOf);
                    io.dcloud.common.adapter.util.Logger.e("appMgr", "START_APP" + strValueOf);
                    io.dcloud.p.d5 d5VarA2 = a(activity, strValueOf);
                    boolean zIsEmpty = android.text.TextUtils.isEmpty(d5VarA2.r0);
                    io.dcloud.p.d5 d5VarB = this.d.b();
                    io.dcloud.p.d5 d5VarA3 = this.d.a(activity, d5VarA2);
                    if (d5VarA3 != null && d5VarA3 == d5VarA2 && !d5VarA2.v) {
                        return d5VarA2;
                    }
                    if (!d5VarA2.q()) {
                        a(activity, strValueOf, strValueOf2, d5VarB, d5VarA2, d5VarA3, zIsEmpty);
                        if (d5VarA2.o()) {
                            android.app.AlertDialog alertDialog = this.h;
                            if (alertDialog != null && alertDialog.isShowing()) {
                                this.h.dismiss();
                            }
                            android.app.AlertDialog alertDialogCreate = new android.app.AlertDialog.Builder(activity, io.dcloud.PdrR.FEATURE_LOSS_STYLE).setTitle("HTML5+ Runtime").setIcon(android.R.drawable.ic_dialog_info).setMessage(io.dcloud.common.util.StringUtil.format(activity.getString(io.dcloud.base.R.string.dcloud_common_app_tips1), d5VarA2.obtainConfigProperty(io.dcloud.common.constant.AbsoluteConst.APP_UNIAPP_VERSION), io.dcloud.common.util.BaseInfo.uniVersionV3)).setPositiveButton(activity.getString(io.dcloud.base.R.string.dcloud_common_view_details), new io.dcloud.p.s.d(activity)).setNegativeButton(activity.getString(io.dcloud.base.R.string.dcloud_common_ignore), (android.content.DialogInterface.OnClickListener) null).create();
                            this.h = alertDialogCreate;
                            alertDialogCreate.setCanceledOnTouchOutside(false);
                            this.h.show();
                        }
                        if (io.dcloud.common.adapter.util.PlatformUtil.checkClass("io.dcloud.feature.weex.WeexFeature") || !io.dcloud.common.util.BaseInfo.isUniAppAppid(d5VarA2) || !io.dcloud.common.util.BaseInfo.isWeexUniJs(d5VarA2)) {
                            return d5VarA2;
                        }
                        android.app.AlertDialog alertDialog2 = this.i;
                        if (alertDialog2 != null && alertDialog2.isShowing()) {
                            this.i.dismiss();
                        }
                        android.app.AlertDialog alertDialogCreate2 = new android.app.AlertDialog.Builder(activity, io.dcloud.PdrR.FEATURE_LOSS_STYLE).setTitle("HTML5+ Runtime").setIcon(android.R.drawable.ic_dialog_info).setMessage(activity.getString(io.dcloud.base.R.string.dcloud_common_app_tips2)).setPositiveButton(activity.getString(io.dcloud.base.R.string.dcloud_common_view_details), new io.dcloud.p.s.e(activity)).setNegativeButton(activity.getString(io.dcloud.base.R.string.dcloud_common_ignore), (android.content.DialogInterface.OnClickListener) null).create();
                        this.i = alertDialogCreate2;
                        alertDialogCreate2.setCanceledOnTouchOutside(false);
                        this.i.show();
                        return d5VarA2;
                    }
                    boolean z2 = d5VarA3 == null;
                    try {
                        java.lang.String bundleData = io.dcloud.common.adapter.util.SP.getBundleData(activity, "pdr", io.dcloud.common.constant.AbsoluteConst.TEST_RUN + strValueOf);
                        if (!android.text.TextUtils.isEmpty(bundleData)) {
                            if (bundleData.equals("popped")) {
                                io.dcloud.common.adapter.util.SP.removeBundleData(activity, "pdr", io.dcloud.common.constant.AbsoluteConst.TEST_RUN + strValueOf);
                            }
                            z2 = false;
                        }
                        boolean booleanExtra = !d5VarA2.v ? activity.getIntent().getBooleanExtra(io.dcloud.common.constant.IntentConst.IS_START_FIRST_WEB, false) : false;
                        if (d5VarA2.n() || !z2 || booleanExtra || d5VarA2.u != 1) {
                            a(activity, strValueOf, strValueOf2, d5VarB, d5VarA2, d5VarA3, zIsEmpty);
                            return d5VarA2;
                        }
                        android.app.AlertDialog alertDialog3 = this.f;
                        if (alertDialog3 != null && alertDialog3.isShowing()) {
                            this.f.dismiss();
                        }
                        com.dcloud.android.widget.dialog.DCloudAlertDialog dCloudAlertDialogInitDialogTheme = io.dcloud.common.util.DialogUtil.initDialogTheme(activity, true);
                        this.f = dCloudAlertDialogInitDialogTheme;
                        dCloudAlertDialogInitDialogTheme.setCanceledOnTouchOutside(false);
                        java.lang.String string = activity.getString(io.dcloud.base.R.string.dcloud_common_app_test_tips);
                        android.widget.CheckBox checkBox = new android.widget.CheckBox(activity);
                        checkBox.setText(io.dcloud.base.R.string.dcloud_common_app_trust_tips);
                        checkBox.setTextColor(-65536);
                        this.f.setMessage(string);
                        this.f.setView(checkBox, io.dcloud.common.adapter.util.DeviceInfo.getDeivceSuitablePixel(activity, 20), 0, 0, 0);
                        io.dcloud.p.s.c cVar = new io.dcloud.p.s.c(activity, strValueOf, d5VarB, checkBox, strValueOf2, d5VarA2, d5VarA3, zIsEmpty);
                        this.f.setButton(-2, activity.getResources().getString(android.R.string.cancel), cVar);
                        this.f.setButton(-1, activity.getResources().getString(android.R.string.ok), cVar);
                        io.dcloud.common.adapter.util.Logger.e("yl", "test show ");
                        this.f.show();
                        return d5VarA2;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        d5VarC = null;
                        io.dcloud.common.adapter.util.Logger.w("AppMgr.processEvent", th);
                        return d5VarC;
                    }
                case 1:
                    java.lang.Object[] objArr2 = (java.lang.Object[]) obj;
                    java.lang.Object obj2 = objArr2[2];
                    io.dcloud.p.d5 d5VarA4 = obj2 instanceof io.dcloud.common.DHInterface.IApp ? (io.dcloud.p.d5) obj2 : a(java.lang.String.valueOf(obj2), false);
                    boolean zA = (io.dcloud.common.util.BaseInfo.sRuntimeMode == null && d5VarA4 == null && !io.dcloud.p.d5.a((io.dcloud.common.DHInterface.ISysEventListener.SysEventType) objArr2[0])) ? false : this.d.a(d5VarA4, (io.dcloud.common.DHInterface.ISysEventListener.SysEventType) objArr2[0], objArr2[1]);
                    if (zA || d5VarA4 == null || !((io.dcloud.common.DHInterface.ISysEventListener.SysEventType) objArr2[0]).equals(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp)) {
                        z = zA;
                    } else {
                        int iIntValue = ((java.lang.Integer) ((java.lang.Object[]) objArr2[1])[0]).intValue();
                        if (iIntValue == 4) {
                            processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 20, d5VarA4);
                        } else {
                            z = zA;
                        }
                    }
                    return java.lang.Boolean.valueOf(z);
                case 2:
                    java.lang.String strValueOf3 = java.lang.String.valueOf(obj);
                    if (io.dcloud.common.util.PdrUtil.isDeviceRootDir(strValueOf3)) {
                        int iIndexOf = strValueOf3.indexOf(io.dcloud.common.util.BaseInfo.sBaseFsAppsPath);
                        if (iIndexOf >= 0) {
                            java.lang.String strSubstring2 = strValueOf3.substring(iIndexOf + io.dcloud.common.util.BaseInfo.sBaseFsAppsPath.length());
                            strSubstring = strSubstring2.substring(0, strSubstring2.indexOf("/"));
                        } else {
                            strSubstring = null;
                        }
                        java.io.InputStream encryptionInputStream = android.text.TextUtils.isEmpty(strSubstring) ? null : io.dcloud.common.adapter.ui.webview.WebResUtil.getEncryptionInputStream(strValueOf3, c(strSubstring));
                        return encryptionInputStream == null ? io.dcloud.common.adapter.io.DHFile.getInputStream(io.dcloud.common.adapter.io.DHFile.createFileHandler(strValueOf3)) : encryptionInputStream;
                    }
                    io.dcloud.p.d5 d5VarC2 = c(this.d.b().o);
                    if (strValueOf3.startsWith(io.dcloud.common.constant.AbsoluteConst.MINI_SERVER_APP_WWW)) {
                        if (d5VarC2 != null) {
                            return d5VarC2.obtainResInStream(strValueOf3);
                        }
                    } else if (strValueOf3.startsWith(io.dcloud.common.constant.AbsoluteConst.MINI_SERVER_APP_DOC)) {
                        return io.dcloud.common.adapter.io.DHFile.getInputStream(io.dcloud.common.adapter.io.DHFile.createFileHandler(d5VarC2.obtainAppDocPath() + strValueOf3.substring(5)));
                    }
                    return null;
                case 3:
                    java.lang.String strValueOf4 = java.lang.String.valueOf(obj);
                    io.dcloud.p.d5 d5VarB2 = "snc:CID".equals(strValueOf4) ? this.d.b() : a(strValueOf4, true);
                    if (!(d5VarB2.getActivity() instanceof io.dcloud.WebAppActivity)) {
                        a(d5VarB2, strValueOf4, false);
                        return null;
                    }
                    io.dcloud.WebAppActivity webAppActivity = (io.dcloud.WebAppActivity) d5VarB2.getActivity();
                    if (webAppActivity == null || webAppActivity.isFinishing()) {
                        a(d5VarB2, strValueOf4, false);
                        return null;
                    }
                    if (!io.dcloud.common.ui.PrivacyManager.getInstance().isPrivacyVersionChange(webAppActivity.getContext())) {
                        a(d5VarB2, strValueOf4, false);
                        return null;
                    }
                    android.content.Intent launchIntentForPackage = webAppActivity.getApplication().getPackageManager().getLaunchIntentForPackage(webAppActivity.getApplication().getPackageName());
                    launchIntentForPackage.addFlags(androidx.core.view.accessibility.AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
                    webAppActivity.getApplication().startActivity(launchIntentForPackage);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    return null;
                case 4:
                    java.lang.Object[] objArr3 = (java.lang.Object[]) obj;
                    java.lang.String strValueOf5 = java.lang.String.valueOf(objArr3[0]);
                    org.json.JSONObject jSONObject = (org.json.JSONObject) objArr3[1];
                    io.dcloud.common.DHInterface.IWebview iWebview = (io.dcloud.common.DHInterface.IWebview) objArr3[2];
                    java.lang.String string2 = io.dcloud.common.util.JSONUtil.getString(jSONObject, "appid");
                    if (java.lang.Boolean.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.INSTALL_OPTIONS_RECOGNISE)) && !android.text.TextUtils.isEmpty(strValueOf5)) {
                        java.util.Locale locale = java.util.Locale.ENGLISH;
                        if (!strValueOf5.toLowerCase(locale).endsWith(".wgtu") && !strValueOf5.toLowerCase(locale).endsWith(".wgt") && !io.dcloud.common.util.CheckSignatureUtil.check(strValueOf5)) {
                            return new java.lang.Object[]{java.lang.Boolean.TRUE, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 10, iWebview.getContext().getString(io.dcloud.base.R.string.dcloud_common_app_check_failed))};
                        }
                    }
                    if (io.dcloud.common.util.PdrUtil.isEmpty(string2)) {
                        string2 = iWebview.obtainFrameView().obtainApp().obtainAppId();
                    }
                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                    io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.AppMgr_TAG, "install begin _filePath = " + strValueOf5 + ";_mayBeAppid = " + string2);
                    io.dcloud.p.d5 d5VarA5 = a(strValueOf5, string2, jSONObject);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("install end useTime=");
                    sb.append(java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
                    io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.AppMgr_TAG, sb.toString());
                    return new java.lang.Object[]{java.lang.Boolean.valueOf(d5VarA5.s.a), d5VarA5.s.b};
                case 5:
                    io.dcloud.p.d5 d5VarC3 = c(java.lang.String.valueOf(obj));
                    if (d5VarC3 != null) {
                        return d5VarC3.v();
                    }
                    return null;
                case 6:
                    return c(java.lang.String.valueOf(obj));
                case 7:
                    java.lang.String str2 = (java.lang.String) obj;
                    if (this.a == null) {
                        this.a = new io.dcloud.p.d4(this);
                    }
                    this.a.a(str2);
                    io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.AppMgr_TAG, "data=" + str2);
                    return null;
                case 8:
                    java.lang.String[] strArr = (java.lang.String[]) obj;
                    return a(strArr[0], strArr[1], strArr[2], java.lang.Byte.parseByte(strArr[3]));
                case 9:
                    java.lang.Object[] objArr4 = (java.lang.Object[]) obj;
                    io.dcloud.common.DHInterface.IApp iApp = (io.dcloud.common.DHInterface.IApp) objArr4[0];
                    io.dcloud.common.DHInterface.IWebviewStateListener iWebviewStateListener = (io.dcloud.common.DHInterface.IWebviewStateListener) objArr4[1];
                    if (objArr4.length <= 2) {
                        return ((io.dcloud.p.d5) iApp).a(iWebviewStateListener);
                    }
                    io.dcloud.common.DHInterface.IDCloudWebviewClientListener iDCloudWebviewClientListener = (io.dcloud.common.DHInterface.IDCloudWebviewClientListener) objArr4[2];
                    if (!io.dcloud.common.util.PdrUtil.isEmpty(iDCloudWebviewClientListener)) {
                        return ((io.dcloud.p.d5) iApp).a(iWebviewStateListener, iDCloudWebviewClientListener);
                    }
                    return null;
                case 10:
                    if (obj instanceof java.lang.String) {
                        d5VarA = a(java.lang.String.valueOf(obj), false);
                    } else if (obj instanceof io.dcloud.p.d5) {
                        d5VarA = (io.dcloud.p.d5) obj;
                    } else {
                        d5VarA = obj instanceof java.util.Map ? a((java.lang.String) ((java.util.Map) obj).get("appid"), false) : null;
                    }
                    if (d5VarA != null) {
                        d5VarA.u();
                        return null;
                    }
                    return null;
                case 11:
                    if (this.d.b() != null) {
                        return this.d.b().o;
                    }
                    return null;
                case 12:
                    io.dcloud.p.d5 d5VarA6 = a((java.lang.String) obj, false);
                    if (d5VarA6 == null) {
                        return (byte) 1;
                    }
                    byte b2 = d5VarA6.u;
                    if (b2 != 3) {
                        return java.lang.Byte.valueOf(b2);
                    }
                    byte b3 = d5VarA6.p() ? d5VarA6.u : (byte) 2;
                    d5VarA6.u = b3;
                    return java.lang.Byte.valueOf(b3);
                case 13:
                    io.dcloud.p.d5 d5Var = (io.dcloud.p.d5) obj;
                    return d5Var != null ? java.lang.Boolean.valueOf(d5Var.r()) : io.dcloud.common.constant.AbsoluteConst.FALSE;
                case 14:
                    java.lang.String strValueOf6 = java.lang.String.valueOf(obj);
                    if (strValueOf6.endsWith("/")) {
                        strValueOf6 = strValueOf6.substring(0, strValueOf6.length() - 1);
                    }
                    java.lang.String strSubstring3 = strValueOf6.substring(strValueOf6.lastIndexOf("/") + 1);
                    d5VarC = b(strSubstring3) ? c(strSubstring3) : b(strValueOf6, strSubstring3);
                    if (!d5VarC.s.a) {
                        try {
                            c(d5VarC);
                            return d5VarC;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            io.dcloud.common.adapter.util.Logger.w("AppMgr.processEvent", th);
                            return d5VarC;
                        }
                    }
                    return null;
                case 15:
                case 17:
                case 18:
                case 22:
                case 23:
                case 25:
                case 26:
                default:
                    return null;
                case 16:
                    java.lang.Object[] objArr5 = (java.lang.Object[]) obj;
                    ((io.dcloud.p.d5) ((io.dcloud.common.DHInterface.IApp) objArr5[0])).a((java.lang.String) objArr5[1], 1);
                    return null;
                case 19:
                    return this.d.c();
                case 20:
                case 21:
                    if (obj instanceof java.lang.String) {
                        str = (java.lang.String) obj;
                        intentObtainWebAppIntent = null;
                    } else {
                        java.lang.Object[] objArr6 = (java.lang.Object[]) obj;
                        intentObtainWebAppIntent = (android.content.Intent) objArr6[1];
                        str = (java.lang.String) objArr6[2];
                    }
                    io.dcloud.p.d5 d5VarA7 = this.d.a(str);
                    java.lang.Boolean bool = java.lang.Boolean.TRUE;
                    if (d5VarA7 == null) {
                        return java.lang.Boolean.FALSE;
                    }
                    io.dcloud.p.d5 d5VarB3 = this.d.b();
                    if (d5VarB3 != d5VarA7) {
                        if (d5VarB3 != null) {
                            d5VarB3.w();
                        }
                        if (intentObtainWebAppIntent != null) {
                            d5VarA7.setWebAppIntent(intentObtainWebAppIntent);
                        } else {
                            intentObtainWebAppIntent = d5VarA7.obtainWebAppIntent();
                        }
                        if (21 == i2) {
                            intentObtainWebAppIntent.putExtra(io.dcloud.common.constant.IntentConst.IS_WEBAPP_REPLY, true);
                        }
                        d5VarA7.getActivity().setIntent(intentObtainWebAppIntent);
                        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.AppMgr_TAG, str + " will unactive change to active STREAM_START_APP");
                        if (d5VarA7.u == 2) {
                            d5VarA7.c();
                        }
                    }
                    return bool;
                case 24:
                    return j;
                case 27:
                    io.dcloud.p.d5 d5VarB4 = this.d.b();
                    if (d5VarB4 != null) {
                        a(d5VarB4, (java.lang.String) null, true);
                        return null;
                    }
                    io.dcloud.common.adapter.util.Logger.e(io.dcloud.common.adapter.util.Logger.AppMgr_TAG, "not app!!!");
                    return null;
                case 28:
                    return this.d.b() != null ? this.d.b() : a((java.lang.String) obj, false);
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        b(android.content.Context context) {
            this.a = context;
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0013  */
        @Override // java.lang.Runnable
        public void run() {
            java.lang.String str;
            if (io.dcloud.common.util.BaseInfo.SyncDebug) {
                str = (io.dcloud.common.adapter.util.PlatformUtil.getResInputStream("uni-jsframework-dev.js") == null || io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) ? "uni-jsframework.js" : "uni-jsframework-dev.js";
            }
            try {
                io.dcloud.common.util.BaseInfo.setUniVersionV3(new org.json.JSONObject(new java.io.BufferedReader(new java.io.InputStreamReader(this.a.getAssets().open(str))).readLine().substring(2)).optString("version"), this.a);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    void b() {
        io.dcloud.p.f5 f5Var;
        java.util.HashMap<java.lang.String, io.dcloud.common.util.BaseInfo.BaseAppInfo> map = io.dcloud.common.util.BaseInfo.mBaseAppInfoSet;
        if (map == null || map.isEmpty()) {
            return;
        }
        java.util.Set<java.lang.String> setKeySet = io.dcloud.common.util.BaseInfo.mBaseAppInfoSet.keySet();
        int size = setKeySet.size();
        java.lang.String[] strArr = new java.lang.String[size];
        setKeySet.toArray(strArr);
        for (int i2 = 0; i2 < size; i2++) {
            java.lang.String str = strArr[i2];
            io.dcloud.common.util.BaseInfo.BaseAppInfo baseAppInfo = io.dcloud.common.util.BaseInfo.mBaseAppInfoSet.get(str);
            if (!io.dcloud.common.util.BaseInfo.mUnInstalledAppInfoSet.containsKey(str) && !b(str)) {
                io.dcloud.p.d5 d5VarB = b(io.dcloud.common.util.BaseInfo.sBaseResAppsPath + str, str);
                if (d5VarB != null && (f5Var = d5VarB.s) != null) {
                    if (f5Var.a) {
                        io.dcloud.common.adapter.util.Logger.e("AppMgr", str + "  app error," + d5VarB.s);
                    } else {
                        d5VarB.t = baseAppInfo;
                        c(d5VarB);
                    }
                }
            }
        }
    }

    void c(io.dcloud.p.d5 d5Var) {
        this.b.add(d5Var.obtainAppId());
        this.c.add(d5Var);
    }

    private void a() {
        if (io.dcloud.common.util.PdrUtil.isEmpty(j)) {
            io.dcloud.common.util.DataUtil.datToJsString(io.dcloud.common.util.BaseInfo.sUniNViewServiceJsPath, new io.dcloud.p.s.a());
        }
    }

    void c() {
        io.dcloud.p.f5 f5Var;
        java.util.HashMap<java.lang.String, io.dcloud.common.util.BaseInfo.BaseAppInfo> map = io.dcloud.common.util.BaseInfo.mInstalledAppInfoSet;
        if (map == null || map.isEmpty()) {
            return;
        }
        java.util.Set<java.lang.String> setKeySet = io.dcloud.common.util.BaseInfo.mInstalledAppInfoSet.keySet();
        int size = setKeySet.size();
        java.lang.String[] strArr = new java.lang.String[size];
        setKeySet.toArray(strArr);
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            java.lang.String str = strArr[i2];
            if (!io.dcloud.common.util.BaseInfo.mUnInstalledAppInfoSet.containsKey(str) && !b(str)) {
                io.dcloud.p.d5 d5VarB = b(io.dcloud.common.util.BaseInfo.sCacheFsAppsPath + str, str);
                if (d5VarB != null && (f5Var = d5VarB.s) != null && !f5Var.a) {
                    d5VarB.deleteAppTemp();
                    if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
                        d5VarB.j0 = true;
                    } else {
                        d5VarB.j0 = false;
                    }
                    c(d5VarB);
                } else {
                    io.dcloud.common.util.BaseInfo.mInstalledAppInfoSet.get(str).clearBundleData();
                    io.dcloud.common.util.BaseInfo.mInstalledAppInfoSet.remove(str);
                    z = true;
                }
            }
        }
        if (z) {
            io.dcloud.common.util.BaseInfo.saveInstalledAppInfo(getContext());
        }
    }

    private void a(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(io.dcloud.common.util.BaseInfo.uniVersionV3)) {
            io.dcloud.common.util.ThreadPool.self().addThreadTask(new io.dcloud.p.s.b(context), true);
        }
    }

    void d() {
        java.io.File file = new java.io.File(io.dcloud.common.util.BaseInfo.sURDFilePath);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            io.dcloud.common.adapter.io.DHFile.copyAssetsFile("data/dcloud_url.json", file.getAbsolutePath());
        }
        if (file.exists()) {
            try {
                this.g = new org.json.JSONObject(new java.lang.String(io.dcloud.common.adapter.io.DHFile.readAll(file)));
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void a(io.dcloud.p.d5 d5Var, java.lang.String str, boolean z) {
        if (d5Var != null) {
            java.lang.String strObtainConfigProperty = d5Var.obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_UNIAPP_CONTROL);
            io.dcloud.p.s.f fVar = new io.dcloud.p.s.f(d5Var);
            if (!android.text.TextUtils.isEmpty(strObtainConfigProperty) && strObtainConfigProperty.equals(io.dcloud.common.constant.AbsoluteConst.UNI_V3)) {
                if (d5Var.getActivity() != null) {
                    io.dcloud.common.util.BaseInfo.isFirstRun = false;
                    d5Var.showSplash();
                    io.dcloud.common.util.AppRuntime.restartWeex(d5Var.getActivity().getApplication(), new io.dcloud.p.s.g(d5Var, z, str, fVar), d5Var.o);
                    return;
                }
                return;
            }
            if (!d5Var.a(z)) {
                io.dcloud.common.adapter.util.Logger.e(io.dcloud.common.adapter.util.Logger.AppMgr_TAG, "reboot " + str + " app failed !!!");
                return;
            }
            fVar.onCallBack(0, null);
            return;
        }
        io.dcloud.common.adapter.util.Logger.e(io.dcloud.common.adapter.util.Logger.AppMgr_TAG, "not found " + str + " app!!!");
    }

    void b(io.dcloud.p.d5 d5Var) {
        this.b.remove(d5Var.o);
        this.c.remove(d5Var);
    }

    private boolean b(java.lang.String str) {
        return this.b.contains(str);
    }

    private io.dcloud.p.d5 b(java.lang.String str, java.lang.String str2) {
        return a(str, str2);
    }

    private void a(io.dcloud.p.d5 d5Var) {
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() && io.dcloud.feature.internal.sdk.SDK.isEnableBackground) {
            d(d5Var);
        }
    }

    public void a(android.app.Activity activity, java.lang.String str, java.lang.String str2, io.dcloud.p.d5 d5Var, io.dcloud.p.d5 d5Var2, io.dcloud.p.d5 d5Var3, boolean z) {
        android.util.Log.i("ylyl", "startOneApp " + str);
        io.dcloud.common.util.BaseInfo.sLastRunApp = str;
        io.dcloud.common.util.BaseInfo.CmtInfo cmitInfo = io.dcloud.common.util.BaseInfo.getCmitInfo(str);
        if (cmitInfo.needUpdate) {
            cmitInfo.templateVersion = d5Var2.D;
            cmitInfo.rptCrs = d5Var2.M;
            cmitInfo.rptJse = d5Var2.N;
            cmitInfo.plusLauncher = io.dcloud.common.util.BaseInfo.getLaunchType(d5Var2.obtainWebAppIntent());
            cmitInfo.sfd = io.dcloud.common.constant.DataInterface.getStreamappFrom(d5Var2.obtainWebAppIntent());
            cmitInfo.needUpdate = false;
        }
        if (!io.dcloud.p.c4.c()) {
            if (d5Var2.u == 4) {
                io.dcloud.common.util.ErrorDialogUtil.checkAppKeyErrorTips(activity);
                return;
            }
        } else if (!io.dcloud.common.util.PdrUtil.checkIntl()) {
            io.dcloud.p.r.a(activity, d5Var2);
            if (d5Var2.u == 4) {
                return;
            }
        }
        if (d5Var2.u == 3) {
            d5Var2.u = d5Var2.p() ? d5Var2.u : (byte) 2;
        }
        if (d5Var != null && d5Var != d5Var2 && d5Var != d5Var3) {
            d5Var.w();
        }
        byte b2 = d5Var2.u;
        if (b2 == 1 || ((z && !d5Var2.w) || ((d5Var2.x && d5Var2.v) || !z))) {
            io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.AppMgr_TAG, str + " will unrunning change to active");
            d5Var2.a(activity);
            processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 4, new java.lang.Object[]{d5Var2, str});
            d5Var2.a(new io.dcloud.p.s.h(d5Var2, str, str2, z));
        } else if (b2 == 2) {
            io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.AppMgr_TAG, str + " will unactive change to active");
            d5Var2.c();
        } else {
            io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.AppMgr_TAG, str + " is active");
        }
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            a(d5Var2);
        }
        if (d5Var3 == null || d5Var3 == d5Var2) {
            return;
        }
        d5Var3.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(io.dcloud.p.d5 d5Var, java.lang.String str, java.lang.String str2, boolean z) {
        if (this.d == null) {
            return;
        }
        boolean zF = z ? d5Var.f(str2) : d5Var.g(str2);
        if (!d5Var.w && d5Var.v) {
            d5Var.f(str2);
        }
        if (zF) {
            this.d.a(str, d5Var);
            return;
        }
        io.dcloud.common.adapter.util.Logger.e(io.dcloud.common.adapter.util.Logger.AppMgr_TAG, str + " run failed!!!");
    }

    io.dcloud.p.d5 a(android.app.Activity activity, java.lang.String str) {
        return a(activity, str, true);
    }

    private io.dcloud.p.d5 a(java.lang.String str, boolean z) {
        return a((android.app.Activity) null, str, z);
    }

    private io.dcloud.p.d5 a(android.app.Activity activity, java.lang.String str, boolean z) {
        int iIndexOf;
        io.dcloud.p.d5 d5Var = (!this.b.contains(str) || (iIndexOf = this.b.indexOf(str)) < 0) ? null : (io.dcloud.p.d5) this.c.get(iIndexOf);
        if (d5Var != null || !z) {
            if (d5Var != null && activity != null) {
                if (d5Var.a == null) {
                    d5Var.a = activity;
                }
                if (d5Var.a.getIntent() != null) {
                    if (d5Var.manifestBeParsed()) {
                        d5Var.setWebAppIntent(d5Var.a.getIntent());
                    }
                } else {
                    d5Var.a.setIntent(d5Var.obtainWebAppIntent());
                }
                if (!d5Var.v) {
                    d5Var.b(str, null);
                }
            }
            return d5Var;
        }
        io.dcloud.p.d5 d5Var2 = new io.dcloud.p.d5(this, str, (byte) 0);
        d5Var2.setAppDataPath(io.dcloud.common.util.BaseInfo.sCacheFsAppsPath + str + io.dcloud.common.adapter.util.DeviceInfo.sSeparatorChar + io.dcloud.common.util.BaseInfo.REAL_PRIVATE_WWW_DIR);
        if (d5Var2.a == null) {
            d5Var2.a = activity;
        }
        if (activity != null) {
            d5Var2.setWebAppIntent(activity.getIntent());
        }
        d5Var2.b(str, null);
        if (d5Var2.s.a) {
            d5Var2.o = str;
        }
        c(d5Var2);
        return d5Var2;
    }

    io.dcloud.p.d5 a(java.lang.String str, java.lang.String str2, java.lang.String str3, byte b2) {
        io.dcloud.p.d5 d5VarA = a(str, false);
        if (d5VarA == null) {
            d5VarA = new io.dcloud.p.d5(this, str, b2);
            d5VarA.u = (byte) 3;
            d5VarA.o = str;
            if (!io.dcloud.common.util.PdrUtil.isEmpty(str2)) {
                d5VarA.setAppDataPath(str2);
            }
            d5VarA.l0 = str3;
            c(d5VarA);
            this.d.a(str, d5VarA);
        }
        return d5VarA;
    }

    io.dcloud.p.d5 a(java.lang.String str, java.lang.String str2) {
        return a(str, str2, (org.json.JSONObject) null);
    }

    io.dcloud.p.d5 a(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
        java.lang.Exception e2;
        io.dcloud.p.d5 d5Var;
        android.content.pm.PackageInfo apkInfo;
        java.lang.Class<?> cls;
        io.dcloud.p.d5 d5VarA = a(str2, false);
        if (d5VarA != null) {
            try {
                d5VarA.s.a();
            } catch (java.lang.Exception e3) {
                e2 = e3;
                d5Var = d5VarA;
                e2.printStackTrace();
                io.dcloud.common.adapter.util.Logger.e(io.dcloud.common.adapter.util.Logger.AppMgr_TAG, "installWebApp " + str + " is Illegal path");
                return d5Var;
            }
        }
        java.io.InputStream resInputStream = null;
        if (!io.dcloud.common.adapter.io.DHFile.isExist(str) && !io.dcloud.common.util.PdrUtil.isDeviceRootDir(str)) {
            boolean zContains = str.substring(str.lastIndexOf(47)).contains(".wgt");
            resInputStream = zContains ? io.dcloud.common.adapter.util.PlatformUtil.getResInputStream(str) : null;
            if (d5VarA == null) {
                d5VarA = new io.dcloud.p.d5(this, str2, (byte) 1);
            }
            if (!zContains && resInputStream == null) {
                d5VarA.setAppDataPath(str + io.dcloud.common.adapter.util.DeviceInfo.sSeparatorChar + io.dcloud.common.util.BaseInfo.REAL_PRIVATE_WWW_DIR);
                d5VarA.b(str2, jSONObject);
            } else {
                d5VarA.b(resInputStream);
            }
        } else {
            boolean zIsFile = new java.io.File(str).isFile();
            if (zIsFile) {
                if (zIsFile && str.toLowerCase(java.util.Locale.ENGLISH).endsWith(".wgtu")) {
                    if (d5VarA == null) {
                        d5VarA = new io.dcloud.p.d5(this, str2, (byte) 0);
                    }
                    d5VarA.a(str, jSONObject);
                    io.dcloud.p.f5 f5Var = d5VarA.s;
                    f5Var.c = false;
                    f5Var.d = false;
                } else if (zIsFile && str.toLowerCase(java.util.Locale.ENGLISH).endsWith(".wgt")) {
                    boolean z = d5VarA == null;
                    d5VarA.s.d = true;
                    if (z) {
                        d5Var = new io.dcloud.p.d5(this, str2, (byte) 0);
                        try {
                            d5Var.o = str2;
                            d5Var.setAppDataPath(io.dcloud.common.util.BaseInfo.sCacheFsAppsPath + str2 + io.dcloud.common.adapter.util.DeviceInfo.sSeparatorChar + io.dcloud.common.util.BaseInfo.REAL_PRIVATE_WWW_DIR);
                            d5VarA = d5Var;
                        } catch (java.lang.Exception e4) {
                            e2 = e4;
                            e2.printStackTrace();
                            io.dcloud.common.adapter.util.Logger.e(io.dcloud.common.adapter.util.Logger.AppMgr_TAG, "installWebApp " + str + " is Illegal path");
                            return d5Var;
                        }
                    }
                    boolean zC = d5VarA.c(str, jSONObject);
                    d5VarA.s.d = false;
                    if (zC && z) {
                        c(d5VarA);
                    }
                } else if (zIsFile && str.toLowerCase(java.util.Locale.ENGLISH).endsWith(io.dcloud.common.constant.StringConst.POINT_APP_EN)) {
                    try {
                        apkInfo = io.dcloud.common.adapter.util.PlatformUtil.parseApkInfo(getContext(), str);
                    } catch (java.lang.Exception e5) {
                        e5.printStackTrace();
                        d5VarA.s.b = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 10, e5.getMessage());
                        apkInfo = null;
                    }
                    try {
                        cls = java.lang.Class.forName("io.dcloud.feature.pack.FileUtils");
                    } catch (java.lang.Exception unused) {
                        cls = null;
                    }
                    if (apkInfo != null && cls != null) {
                        d5VarA.s.a = false;
                        java.lang.String str3 = apkInfo.versionName;
                        java.lang.String str4 = apkInfo.packageName;
                        java.lang.String string = getContext().getPackageManager().getApplicationLabel(apkInfo.applicationInfo).toString();
                        if (string == null) {
                            string = "";
                        }
                        d5VarA.s.b = io.dcloud.common.util.StringUtil.format("{pname:'%s',version:'%s',name:'%s'}", str4, str3, string);
                        try {
                            cls.getDeclaredMethod("addFileToSystem", android.content.Context.class, java.lang.String.class, java.lang.String.class).invoke(null, getContext(), getContext().getPackageName() + ".dc.fileprovider", str);
                        } catch (java.lang.Exception unused2) {
                        }
                    } else {
                        d5VarA.s.a = true;
                    }
                } else {
                    io.dcloud.p.f5 f5Var2 = d5VarA.s;
                    f5Var2.a = true;
                    f5Var2.b = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, java.lang.Integer.valueOf(io.dcloud.common.constant.DOMException.CODE_RUNTIME_WGT_OR_WGTU_ERROR_MALFORMED), io.dcloud.common.constant.DOMException.MSG_RUNTIME_WGT_OR_WGTU_ERROR_MALFORMED);
                }
            } else {
                if (d5VarA != null) {
                    d5VarA.b((byte) 0);
                } else {
                    d5VarA = new io.dcloud.p.d5(this, str2, (byte) 0);
                }
                d5VarA.setAppDataPath(str + io.dcloud.common.adapter.util.DeviceInfo.sSeparatorChar + io.dcloud.common.util.BaseInfo.REAL_PRIVATE_WWW_DIR);
                d5VarA.b(str2, jSONObject);
            }
        }
        io.dcloud.common.util.IOUtil.close(resInputStream);
        return d5VarA;
    }
}
