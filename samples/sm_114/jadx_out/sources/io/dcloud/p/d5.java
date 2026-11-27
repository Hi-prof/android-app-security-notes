package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
class d5 extends io.dcloud.p.e5 implements io.dcloud.common.DHInterface.IApp, io.dcloud.common.DHInterface.ISysEventListener {
    public static java.lang.String H1 = "webapp";
    java.util.ArrayList B0;
    private java.lang.String R0;
    private java.lang.String f0;
    private java.lang.String g0;
    private java.lang.String h0;
    private java.lang.String i0;
    io.dcloud.p.f5 s;
    private io.dcloud.common.DHInterface.IConfusionMgr t1;
    private java.lang.String u1;
    io.dcloud.p.s y;
    io.dcloud.common.util.BaseInfo.BaseAppInfo t = null;
    byte u = 1;
    boolean v = false;
    boolean w = false;
    boolean x = false;
    java.lang.String z = null;
    java.lang.String A = "";
    java.lang.String B = "";
    java.lang.String C = "";
    java.lang.String D = null;
    java.lang.String E = "";
    java.lang.String F = null;
    java.lang.String G = null;
    java.lang.String H = null;
    java.lang.String I = null;
    java.lang.String J = null;
    java.lang.String K = null;
    java.lang.String L = null;
    boolean M = true;
    boolean N = true;
    boolean O = true;
    boolean P = false;
    boolean Q = true;
    boolean R = true;
    boolean S = false;
    private java.lang.String T = null;
    boolean U = false;
    private byte V = 1;
    private boolean W = false;
    private boolean X = false;
    private boolean Y = true;
    private boolean Z = true;
    private int a0 = io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH;
    private int b0 = 0;
    private int c0 = 0;
    private java.lang.String d0 = null;
    private java.lang.String e0 = null;
    boolean j0 = false;
    private java.lang.String k0 = null;
    java.lang.String l0 = null;
    java.lang.String m0 = null;
    java.lang.String n0 = null;
    boolean o0 = false;
    java.lang.String p0 = "accept";
    java.lang.String q0 = "file:///android_asset/data/dcloud_error.html";
    java.lang.String r0 = null;
    private java.lang.String s0 = null;
    java.lang.String t0 = null;
    private java.lang.String u0 = "-1";
    private org.json.JSONObject v0 = null;
    private java.lang.String w0 = "";
    private boolean x0 = true;
    private boolean y0 = false;
    private java.lang.String z0 = io.dcloud.common.constant.AbsoluteConst.UNI_V3;
    private java.lang.String A0 = "fast";
    java.util.HashMap C0 = null;
    org.json.JSONObject D0 = null;
    org.json.JSONObject E0 = null;
    org.json.JSONObject F0 = null;
    org.json.JSONObject G0 = null;
    org.json.JSONObject H0 = null;
    org.json.JSONObject I0 = null;
    org.json.JSONObject J0 = null;
    org.json.JSONObject K0 = null;
    org.json.JSONObject L0 = null;
    java.lang.String M0 = null;
    java.lang.String N0 = null;
    android.content.Intent O0 = null;
    io.dcloud.common.DHInterface.IApp.IAppStatusListener P0 = null;
    java.lang.String Q0 = null;
    private java.lang.String S0 = "none";
    boolean T0 = false;
    private boolean U0 = false;
    private boolean V0 = false;
    private java.lang.String W0 = "default";
    private java.lang.String X0 = null;
    private java.lang.String Y0 = null;
    private java.lang.String Z0 = null;
    private java.lang.String a1 = "";
    protected boolean b1 = false;
    private boolean c1 = false;
    private boolean d1 = false;
    private java.lang.String e1 = null;
    private java.lang.String f1 = null;
    private boolean g1 = false;
    long h1 = 0;
    boolean i1 = true;
    boolean j1 = false;
    boolean k1 = false;
    java.util.ArrayList l1 = new java.util.ArrayList();
    java.util.ArrayList m1 = new java.util.ArrayList();
    java.lang.String n1 = null;
    java.lang.String o1 = null;
    private java.lang.String p1 = "";
    private boolean q1 = false;
    private java.lang.String r1 = null;
    private int s1 = 1;
    io.dcloud.common.DHInterface.IWebviewStateListener v1 = null;
    boolean w1 = false;
    org.json.JSONObject x1 = null;
    private boolean y1 = false;
    private java.lang.String z1 = "none";
    private java.lang.String A1 = io.dcloud.common.constant.AbsoluteConst.INSTALL_OPTIONS_FORCE;
    private java.lang.String B1 = null;
    private java.lang.String C1 = null;
    boolean D1 = true;
    java.util.HashMap E1 = null;
    java.lang.String F1 = null;
    boolean G1 = false;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements java.lang.Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                io.dcloud.common.adapter.io.DHFile.deleteFile(io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app_temp/");
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements java.lang.Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                io.dcloud.common.adapter.io.DHFile.deleteFile(io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app_temp/");
                io.dcloud.common.adapter.io.DHFile.deleteFile(io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template.zip");
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.common.DHInterface.ICallBack a;

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class a implements io.dcloud.common.adapter.util.MessageHandler.IMessages {
            a() {
            }

            @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
            public void execute(java.lang.Object obj) {
                io.dcloud.p.d5.c.this.a.onCallBack(0, null);
            }
        }

        c(io.dcloud.common.DHInterface.ICallBack iCallBack) {
            this.a = iCallBack;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String str = io.dcloud.common.util.BaseInfo.sCacheFsAppsPath + io.dcloud.p.d5.this.o + io.dcloud.common.adapter.util.DeviceInfo.sSeparatorChar + io.dcloud.common.util.BaseInfo.APP_WWW_FS_DIR;
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            io.dcloud.common.adapter.util.Logger.d(io.dcloud.p.d5.H1, io.dcloud.p.d5.this.o + " copy resoure begin!!!");
            io.dcloud.common.adapter.io.DHFile.delete(str);
            io.dcloud.common.adapter.io.DHFile.copyDir(io.dcloud.p.d5.this.k0, str);
            long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
            io.dcloud.common.adapter.util.Logger.d(io.dcloud.p.d5.H1, io.dcloud.p.d5.this.o + " copy resoure end!!! useTime=" + (jCurrentTimeMillis2 - jCurrentTimeMillis));
            io.dcloud.p.d5.this.V = (byte) 0;
            io.dcloud.p.d5.this.setAppDataPath(str);
            io.dcloud.p.d5 d5Var = io.dcloud.p.d5.this;
            io.dcloud.common.util.BaseInfo.BaseAppInfo baseAppInfo = d5Var.t;
            if (baseAppInfo != null) {
                baseAppInfo.saveToBundleData(d5Var.getActivity());
            }
            io.dcloud.common.adapter.util.MessageHandler.sendMessage(new io.dcloud.p.d5.c.a(), null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;

        d(java.lang.String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.common.util.TestUtil.PointTime.commitTid(io.dcloud.p.d5.this.getActivity(), this.a, null, io.dcloud.p.d5.this.N0, 1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class e implements java.lang.Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                io.dcloud.common.adapter.io.DHFile.deleteFile(io.dcloud.p.d5.this.obtainAppTempPath());
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static /* synthetic */ class f {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.values().length];
            a = iArr;
            try {
                iArr[io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.OverrideUrlJsonData.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.OverrideResourceJsonData.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.SecondWebviewJsonData.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.LaunchWebviewJsonData.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.TitleNViewJsonData.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.SitemapJsonData.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.URDJsonData.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                a[io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.DirectPageJsonData.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                a[io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.Tabbar.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
        }
    }

    d5(io.dcloud.p.s sVar, java.lang.String str, byte b2) {
        this.s = null;
        this.y = null;
        this.B0 = null;
        this.y = sVar;
        this.o = str;
        b(b2);
        this.t1 = io.dcloud.p.i0.c();
        this.s = new io.dcloud.p.f5();
        this.B0 = new java.util.ArrayList(2);
        this.q = io.dcloud.common.util.AppRuntime.isUniApp(str);
    }

    private void d() {
    }

    private void e() {
        org.json.JSONObject jSONObject = this.K0;
        if (jSONObject != null) {
            try {
                java.lang.String strOptString = jSONObject.optString("webviewid");
                if (android.text.TextUtils.isEmpty(strOptString)) {
                    this.K0.put("webviewid", io.dcloud.common.constant.IntentConst.DIRECT_PAGE);
                }
                if (this.o.equals(strOptString)) {
                    this.J0 = this.K0.optJSONObject("titleNView");
                    return;
                }
                org.json.JSONObject jSONObjectOptJSONObject = this.K0.has("titleNView") ? this.K0.optJSONObject("titleNView") : null;
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new org.json.JSONObject();
                    this.K0.put("titleNView", jSONObjectOptJSONObject);
                }
                jSONObjectOptJSONObject.put("autoBackButton", true);
                if (jSONObjectOptJSONObject.has("homeButton")) {
                    return;
                }
                jSONObjectOptJSONObject.put("homeButton", true);
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private boolean e(java.lang.String str) {
        return false;
    }

    private void f() {
        try {
            int iRename = io.dcloud.common.adapter.io.DHFile.rename(io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/", io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app_temp/");
            io.dcloud.common.adapter.io.DHFile.copyDir("data/wap2app", io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/");
            if (iRename == 1) {
                io.dcloud.common.util.ThreadPool.self().addThreadTask(new io.dcloud.p.d5.a());
            }
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
        }
    }

    private org.json.JSONObject h() {
        org.json.JSONObject jSONObjectA = null;
        try {
            java.io.InputStream inputStreamObtainResInStream = obtainResInStream("_www/__template.json");
            if (inputStreamObtainResInStream == null) {
                return null;
            }
            jSONObjectA = a(inputStreamObtainResInStream);
            io.dcloud.common.util.IOUtil.close(inputStreamObtainResInStream);
            return jSONObjectA;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return jSONObjectA;
        }
    }

    private org.json.JSONObject i() {
        io.dcloud.common.util.ThreadPool threadPoolSelf;
        io.dcloud.p.d5.b bVar;
        org.json.JSONObject jSONObject = null;
        try {
            boolean z = true;
            boolean z2 = false;
            if (io.dcloud.common.util.BaseInfo.sCoverApkRuning) {
                if (new java.io.File(io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__template.json").exists()) {
                    java.io.InputStream inputStream = io.dcloud.common.adapter.util.PlatformUtil.getInputStream(io.dcloud.common.util.BaseInfo.sBaseConfigTemplatePath);
                    org.json.JSONObject jSONObjectA = a(inputStream);
                    java.lang.String strOptString = jSONObjectA.optString("version");
                    io.dcloud.common.util.IOUtil.close(inputStream);
                    java.io.InputStream inputStream2 = io.dcloud.common.adapter.io.DHFile.getInputStream(io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__template.json");
                    org.json.JSONObject jSONObjectA2 = a(inputStream2);
                    java.lang.String strOptString2 = jSONObjectA2.optString("version");
                    io.dcloud.common.util.IOUtil.close(inputStream2);
                    io.dcloud.common.util.BaseInfo.mWap2appTemplateFiles.clear();
                    io.dcloud.common.util.BaseInfo.mW2AE.clear();
                    if (io.dcloud.common.util.BaseInfo.BaseAppInfo.compareVersion(strOptString, strOptString2)) {
                        f();
                        jSONObject = jSONObjectA;
                        z2 = true;
                    } else {
                        jSONObject = jSONObjectA2;
                    }
                }
            }
            if (io.dcloud.common.adapter.io.DHFile.isExist(io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template.zip")) {
                io.dcloud.common.adapter.io.DHFile.rename(io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/", io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app_temp/");
                try {
                    try {
                        io.dcloud.common.util.ZipUtils.upZipFile(new java.io.File(io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template.zip"), io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/");
                        threadPoolSelf = io.dcloud.common.util.ThreadPool.self();
                        bVar = new io.dcloud.p.d5.b();
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                        threadPoolSelf = io.dcloud.common.util.ThreadPool.self();
                        bVar = new io.dcloud.p.d5.b();
                        z = z2;
                    }
                    threadPoolSelf.addThreadTask(bVar);
                } catch (java.lang.Throwable th) {
                    io.dcloud.common.util.ThreadPool.self().addThreadTask(new io.dcloud.p.d5.b());
                    throw th;
                }
            } else {
                if (new java.io.File(io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__template.json").exists()) {
                    z = z2;
                } else {
                    f();
                }
            }
            if (!z && !android.text.TextUtils.isEmpty(io.dcloud.common.util.BaseInfo.sWap2AppTemplateVersion) && io.dcloud.common.util.BaseInfo.mWap2appTemplateFiles.size() != 0 && this.t1.getData("__w2a__template__") != null) {
                return jSONObject;
            }
            if (!io.dcloud.common.adapter.io.DHFile.isExist(io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__template.json")) {
                return jSONObject;
            }
            java.io.InputStream inputStream3 = io.dcloud.common.adapter.io.DHFile.getInputStream(io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__template.json");
            org.json.JSONObject jSONObjectA3 = a(inputStream3);
            io.dcloud.common.util.IOUtil.close(inputStream3);
            io.dcloud.common.util.BaseInfo.mWap2appTemplateFiles.clear();
            io.dcloud.common.util.BaseInfo.mW2AE.clear();
            this.t1.removeData("__w2a__template__");
            return jSONObjectA3;
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
            return jSONObject;
        }
    }

    private void l() {
        java.lang.String[] strArrSplit;
        this.E1 = new java.util.HashMap();
        java.lang.String string = io.dcloud.common.adapter.util.SP.getOrCreateBundle(getActivity(), this.o + "_1").getString("Authorize", null);
        this.F1 = string;
        if (string == null || (strArrSplit = string.split("&")) == null || strArrSplit.length <= 0) {
            return;
        }
        for (java.lang.String str : strArrSplit) {
            if (!android.text.TextUtils.isEmpty(str)) {
                java.lang.String[] strArrSplit2 = str.split("=");
                this.E1.put(strArrSplit2[0], java.lang.Integer.valueOf(java.lang.Integer.parseInt(strArrSplit2[1])));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x005b  */
    private void x() {
        boolean z;
        if (io.dcloud.common.util.BaseInfo.isWap2AppAppid(this.o)) {
            org.json.JSONObject jSONObjectI = i();
            java.lang.String strOptString = jSONObjectI == null ? io.dcloud.common.util.BaseInfo.sWap2AppTemplateVersion : jSONObjectI.optString("version");
            try {
                org.json.JSONObject jSONObjectH = h();
                if (jSONObjectH != null) {
                    java.lang.String strOptString2 = jSONObjectH.optString("version");
                    if (android.text.TextUtils.isEmpty(strOptString2) || !io.dcloud.common.util.BaseInfo.BaseAppInfo.compareVersion(strOptString2, strOptString)) {
                        z = false;
                    } else {
                        io.dcloud.common.adapter.io.DHFile.deleteFile(io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/");
                        io.dcloud.common.util.BaseInfo.mWap2appTemplateFiles.clear();
                        io.dcloud.common.util.BaseInfo.mW2AE.clear();
                        strOptString = strOptString2;
                        jSONObjectI = jSONObjectH;
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (io.dcloud.common.util.BaseInfo.mWap2appTemplateFiles.size() == 0) {
                    if (jSONObjectI == null || !jSONObjectI.has("files")) {
                        java.lang.String[] list = new java.io.File(io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/").list();
                        if (list != null) {
                            for (java.lang.String str : list) {
                                io.dcloud.common.util.BaseInfo.mWap2appTemplateFiles.add(str);
                            }
                        }
                    } else {
                        org.json.JSONArray jSONArrayOptJSONArray = jSONObjectI.optJSONArray("files");
                        int length = jSONArrayOptJSONArray.length();
                        boolean z2 = obtainRunningAppMode() == 1;
                        for (int i = 0; i < length; i++) {
                            java.lang.String strOptString3 = jSONArrayOptJSONArray.optString(i);
                            io.dcloud.common.util.BaseInfo.mWap2appTemplateFiles.add(strOptString3);
                            if (z) {
                                if (z2) {
                                    io.dcloud.common.adapter.io.DHFile.copyAssetsFile(io.dcloud.common.util.BaseInfo.sBaseResAppsPath + this.o + "/www/" + strOptString3, io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/" + strOptString3);
                                } else {
                                    io.dcloud.common.adapter.io.DHFile.copyFile(io.dcloud.common.util.BaseInfo.sCacheFsAppsPath + this.o + "/www/" + strOptString3, io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/" + strOptString3, true, false);
                                }
                            }
                        }
                        if (z && !io.dcloud.common.util.BaseInfo.mWap2appTemplateFiles.contains("__template.json")) {
                            if (z2) {
                                io.dcloud.common.adapter.io.DHFile.copyAssetsFile(io.dcloud.common.util.BaseInfo.sBaseResAppsPath + this.o + "/www/__template.json", io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__template.json");
                            } else {
                                io.dcloud.common.adapter.io.DHFile.copyFile(io.dcloud.common.util.BaseInfo.sCacheFsAppsPath + this.o + "/www/__template.json", io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__template.json", true, false);
                            }
                        }
                    }
                }
                if ((z || this.t1.getData("__w2a__template__") == null) && jSONObjectI != null && jSONObjectI.has(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CONFUSION)) {
                    byte[] bArrDecode2bytes = io.dcloud.common.util.Base64.decode2bytes(jSONObjectI.optString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CONFUSION));
                    android.content.Context activity = getActivity();
                    if (activity == null) {
                        activity = io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext;
                    }
                    java.lang.String strHandleEncryption = this.t1.handleEncryption(activity, bArrDecode2bytes);
                    if (io.dcloud.common.util.PdrUtil.isEmpty(strHandleEncryption)) {
                        strHandleEncryption = "{}";
                    }
                    this.t1.removeData("__w2a__template__");
                    this.t1.recordEncryptionResources("__w2a__template__", new org.json.JSONObject(strHandleEncryption));
                }
                io.dcloud.common.util.BaseInfo.sTemplateModifyTime = new java.io.File(io.dcloud.common.util.BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__template.json").lastModified();
                io.dcloud.common.util.BaseInfo.sWap2AppTemplateVersion = strOptString;
                this.D = strOptString;
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void addAllFeaturePermission() {
        io.dcloud.common.core.permission.PermissionControler.registerRootPermission(this.o);
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void addFeaturePermission(java.lang.String str) {
        this.B0.add(str.toLowerCase(java.util.Locale.ENGLISH));
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void applyMani() {
        try {
            a(io.dcloud.common.adapter.io.DHFile.getInputStream(io.dcloud.common.adapter.io.DHFile.createFileHandler(a(io.dcloud.common.util.BaseInfo.sConfigXML))), this.o, null);
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void applySmartUpdate() {
        a(false);
    }

    void b(java.io.InputStream inputStream) {
    }

    boolean b(java.lang.String str, org.json.JSONObject jSONObject) {
        boolean z;
        java.util.HashMap<java.lang.String, io.dcloud.common.util.BaseInfo.BaseAppInfo> map;
        java.io.InputStream inputStream = null;
        try {
            this.o = str;
            this.t1.removeData(str);
            k();
            if (this.V == 0 || !((map = io.dcloud.common.util.BaseInfo.mBaseAppInfoSet) == null || map.containsKey(this.o))) {
                inputStream = io.dcloud.common.adapter.io.DHFile.getInputStream(io.dcloud.common.adapter.io.DHFile.createFileHandler(a(io.dcloud.common.util.BaseInfo.sConfigXML)));
                if (inputStream == null && (inputStream = io.dcloud.common.adapter.util.PlatformUtil.getResInputStream(a(io.dcloud.common.util.BaseInfo.sConfigXML))) != null) {
                    this.V = (byte) 1;
                }
            } else if (this.V == 1) {
                inputStream = io.dcloud.common.adapter.util.PlatformUtil.getResInputStream(a(io.dcloud.common.util.BaseInfo.sConfigXML));
            }
            if (io.dcloud.common.util.BaseInfo.isWap2AppAppid(this.o)) {
                x();
                z = false;
            } else {
                z = true;
            }
            if (inputStream == null) {
                if (io.dcloud.common.util.BaseInfo.isWap2AppAppid(this.o) && !android.text.TextUtils.isEmpty(this.n1)) {
                    return true;
                }
                if (q() && !android.text.TextUtils.isEmpty(this.r0)) {
                    return true;
                }
                io.dcloud.p.f5 f5Var = this.s;
                f5Var.a = true;
                if (f5Var.c) {
                    f5Var.b = io.dcloud.common.constant.DOMException.toJSON(io.dcloud.common.constant.DOMException.CODE_RUNTIME_WGTU_WWW_MANIFEST_NOT_EXIST, io.dcloud.common.constant.DOMException.MSG_RUNTIME_WGTU_WWW_MANIFEST_NOT_EXIST);
                } else {
                    f5Var.b = io.dcloud.common.constant.DOMException.toJSON(io.dcloud.common.constant.DOMException.CODE_RUNTIME_WGT_MANIFEST_NOT_EXIST, io.dcloud.common.constant.DOMException.MSG_RUNTIME_WGT_MANIFEST_NOT_EXIST);
                }
                return false;
            }
            boolean zA = a(inputStream, str, jSONObject);
            if (z) {
                x();
            }
            io.dcloud.p.f5 f5Var2 = this.s;
            if (f5Var2 != null && f5Var2.a) {
                io.dcloud.common.adapter.util.Logger.i("WebApp", "InstallError---msg=" + this.s.b);
            }
            io.dcloud.common.DHInterface.IActivityHandler iActivityHandler = io.src.dcloud.adapter.DCloudAdapterUtil.getIActivityHandler(getActivity());
            if (iActivityHandler != null) {
                iActivityHandler.updateSplash(this.t0);
            }
            this.v = true;
            return zA;
        } catch (java.lang.Exception e2) {
            io.dcloud.common.adapter.util.Logger.w("parseConfig", e2);
            return false;
        } finally {
            io.dcloud.common.util.IOUtil.close((java.io.InputStream) null);
        }
    }

    void c() {
        android.app.Activity activity = this.a;
        if (activity != null && (activity instanceof io.dcloud.WebAppActivity)) {
            ((io.dcloud.WebAppActivity) activity).onAppActive(this.o);
            ((io.dcloud.WebAppActivity) this.a).onAppActive(this);
        }
        diyStatusBarState();
        setStatus((byte) 3);
        this.b.onAppActive(this);
        callSysEventListener(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppForeground, io.dcloud.common.constant.IntentConst.obtainArgs(obtainWebAppIntent(), this.o));
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean callSysEventListener(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
        java.util.HashMap map = this.C0;
        boolean zOnExecute = false;
        if (map == null) {
            return false;
        }
        java.util.ArrayList arrayList = (java.util.ArrayList) map.get(sysEventType);
        java.util.ArrayList arrayList2 = (java.util.ArrayList) this.C0.get(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.AllSystemEvent);
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        if (arrayList2 != null) {
            arrayList3.addAll(arrayList2);
        }
        for (int size = arrayList3.size() - 1; size >= 0; size--) {
            io.dcloud.common.DHInterface.ISysEventListener iSysEventListener = (io.dcloud.common.DHInterface.ISysEventListener) arrayList3.get(size);
            if (a(iSysEventListener, sysEventType) && (zOnExecute || iSysEventListener.onExecute(sysEventType, obj)) && !a(sysEventType)) {
                return zOnExecute;
            }
        }
        return zOnExecute;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean checkIsCustomPath() {
        return this.o0;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void checkOrLoadlaunchWebview() {
        io.dcloud.p.s sVar = this.y;
        if (sVar != null) {
            io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = (io.dcloud.common.adapter.ui.AdaFrameView) sVar.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 46, obtainAppId());
            io.dcloud.common.adapter.util.Logger.d("Direct_page", "checkOrLoadlaunchWebview " + manifestBeParsed() + ";adaFrameView=" + adaFrameView);
            this.w1 = manifestBeParsed() ^ true;
            if (adaFrameView == null || !manifestBeParsed()) {
                return;
            }
            adaFrameView.obtainWebView().checkIfNeedLoadOriginalUrl();
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean checkPrivateDir(java.lang.String str) {
        return str.startsWith(obtainAppDataPath()) || str.startsWith(io.dcloud.common.util.BaseInfo.REL_PRIVATE_WWW_DIR);
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String checkPrivateDirAndCopy2Temp(java.lang.String str) {
        if (obtainRunningAppMode() == 1 && checkPrivateDir(str)) {
            java.lang.String str2 = "/" + io.dcloud.common.util.BaseInfo.APP_WWW_FS_DIR;
            java.lang.String strSubstring = str.substring(str.indexOf(str2) + str2.length());
            java.lang.String str3 = this.k0 + strSubstring;
            str = obtainAppTempPath() + strSubstring;
            if (!io.dcloud.common.adapter.io.DHFile.exists(str)) {
                io.dcloud.common.adapter.io.DHFile.copyAssetsFile(str3, str);
            }
        }
        return str;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean checkSchemeWhite(java.lang.String str) {
        if (!q()) {
            return true;
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            java.util.ArrayList arrayList = this.m1;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                java.lang.Object obj = arrayList.get(i);
                i++;
                java.lang.String str2 = (java.lang.String) obj;
                if (!android.text.TextUtils.equals(str2, "*")) {
                    if (str.startsWith(str2 + ":")) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean checkWhiteUrl(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return this.l1.contains("*") || this.l1.contains(str);
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void clearRuntimeArgs() {
        this.E = "";
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String convert2AbsFullPath(java.lang.String str, java.lang.String str2) {
        boolean z = true;
        try {
            if (io.dcloud.common.util.PdrUtil.isEmpty(str2) || ((this.V != 1 || !io.dcloud.common.adapter.util.PlatformUtil.isResFileExists(str2)) && !io.dcloud.common.adapter.io.DHFile.isExist(str2))) {
                if (!io.dcloud.common.util.PdrUtil.isEmpty(str2)) {
                    int iIndexOf = str2.indexOf(com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING);
                    if (iIndexOf > 0) {
                        str2 = str2.substring(0, iIndexOf);
                    }
                    if (str2.startsWith("_documents/")) {
                        return io.dcloud.common.util.BaseInfo.sDocumentFullPath + str2.substring(11);
                    }
                    if (str2.startsWith(io.dcloud.common.util.BaseInfo.REL_PUBLIC_DOCUMENTS_DIR)) {
                        return io.dcloud.common.util.BaseInfo.sDocumentFullPath + str2.substring(10);
                    }
                    if (str2.startsWith(io.dcloud.common.constant.AbsoluteConst.MINI_SERVER_APP_DOC)) {
                        return obtainAppDocPath() + str2.substring(5);
                    }
                    if (str2.startsWith(io.dcloud.common.util.BaseInfo.REL_PRIVATE_DOC_DIR)) {
                        return obtainAppDocPath() + str2.substring(4);
                    }
                    if (str2.startsWith("_downloads/")) {
                        return io.dcloud.common.util.BaseInfo.sDownloadFullPath + str2.substring(11);
                    }
                    if (str2.startsWith(io.dcloud.common.util.BaseInfo.REL_PUBLIC_DOWNLOADS_DIR)) {
                        return io.dcloud.common.util.BaseInfo.sDownloadFullPath + str2.substring(10);
                    }
                    if (str2.startsWith(io.dcloud.common.constant.AbsoluteConst.MINI_SERVER_APP_WWW)) {
                        byte b2 = this.V;
                        if (b2 != 1) {
                            if (b2 != 0) {
                                return str2;
                            }
                            return this.k0 + str2.substring(5);
                        }
                        return io.dcloud.common.util.BaseInfo.sBaseResAppsPath + this.o + "/" + io.dcloud.common.util.BaseInfo.APP_WWW_FS_DIR + str2.substring(5);
                    }
                    if (str2.startsWith(io.dcloud.common.util.BaseInfo.REL_PRIVATE_WWW_DIR)) {
                        byte b3 = this.V;
                        if (b3 != 1) {
                            if (b3 != 0) {
                                return str2;
                            }
                            return this.k0 + str2.substring(4);
                        }
                        return io.dcloud.common.util.BaseInfo.sBaseResAppsPath + this.o + "/" + io.dcloud.common.util.BaseInfo.APP_WWW_FS_DIR + str2.substring(4);
                    }
                    if (str2.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
                        return str2.substring(7);
                    }
                    if (str2.startsWith("content://") || str2.startsWith(io.dcloud.common.adapter.util.DeviceInfo.sDeviceRootDir)) {
                        return str2;
                    }
                    if (str2.startsWith("http://localhost")) {
                        java.lang.String strSubstring = str2.substring(16);
                        return convert2AbsFullPath(null, strSubstring.substring(strSubstring.indexOf("/") + 1));
                    }
                    if (!str2.startsWith("/") && str != null) {
                        z = false;
                    } else if (str2.startsWith("/")) {
                        str2 = str2.substring(1);
                    }
                    if (str != null) {
                        if (str.startsWith(io.dcloud.feature.internal.sdk.SDK.ANDROID_ASSET)) {
                            str = str.substring(22);
                        } else if (str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
                            str = str.substring(7);
                        }
                    }
                    if (str != null && !z) {
                        return io.dcloud.common.util.PdrUtil.standardizedURL(str, str2);
                    }
                    if (!z) {
                        return str2;
                    }
                    java.lang.String strObtainAppDataPath = obtainAppDataPath();
                    if (str != null && !io.dcloud.common.util.PdrUtil.isEquals(str, strObtainAppDataPath) && str.contains("/www/")) {
                        strObtainAppDataPath = str.substring(0, str.indexOf("/www/") + 5);
                    }
                    return strObtainAppDataPath + b(str2);
                }
            }
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
        }
        return str2;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String convert2LocalFullPath(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.lang.String strConvert2AbsFullPath = convert2AbsFullPath(str, str2);
        byte b2 = this.V;
        if (b2 == 1 || io.dcloud.common.adapter.util.DeviceInfo.isPrivateDirectory) {
            java.io.InputStream resInputStream = b2 == 1 ? io.dcloud.common.adapter.util.PlatformUtil.getResInputStream(strConvert2AbsFullPath) : io.dcloud.common.adapter.util.PlatformUtil.getInputStream(strConvert2AbsFullPath);
            if (resInputStream != null) {
                strConvert2AbsFullPath = obtainAppTempPath() + java.lang.System.currentTimeMillis();
                try {
                    io.dcloud.common.adapter.io.DHFile.writeFile(resInputStream, strConvert2AbsFullPath);
                    resInputStream.close();
                    return strConvert2AbsFullPath;
                } catch (java.io.IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return strConvert2AbsFullPath;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String convert2RelPath(java.lang.String str) {
        try {
            int length = obtainAppDataPath().length();
            int length2 = obtainAppDocPath().length();
            int length3 = io.dcloud.common.util.BaseInfo.sDocumentFullPath.length();
            int length4 = io.dcloud.common.util.BaseInfo.sDownloadFullPath.length();
            if (str.startsWith(obtainAppDataPath())) {
                return io.dcloud.common.util.BaseInfo.REL_PRIVATE_WWW_DIR + str.substring(length - 1);
            }
            int i = length - 1;
            if (str.startsWith(obtainAppDataPath().substring(0, i))) {
                return io.dcloud.common.util.BaseInfo.REL_PRIVATE_WWW_DIR + str.substring(i, str.length());
            }
            if (str.startsWith(obtainAppDocPath())) {
                return io.dcloud.common.util.BaseInfo.REL_PRIVATE_DOC_DIR + str.substring(length2 - 1);
            }
            int i2 = length2 - 1;
            if (str.startsWith(obtainAppDocPath().substring(0, i2))) {
                return io.dcloud.common.util.BaseInfo.REL_PRIVATE_DOC_DIR + str.substring(i2);
            }
            if (str.startsWith(io.dcloud.common.util.BaseInfo.sDocumentFullPath)) {
                return io.dcloud.common.util.BaseInfo.REL_PUBLIC_DOCUMENTS_DIR + str.substring(length3 - 1);
            }
            int i3 = length3 - 1;
            if (str.startsWith(io.dcloud.common.util.BaseInfo.sDocumentFullPath.substring(0, i3))) {
                return io.dcloud.common.util.BaseInfo.REL_PUBLIC_DOCUMENTS_DIR + str.substring(i3);
            }
            if (str.startsWith(io.dcloud.common.util.BaseInfo.sDownloadFullPath)) {
                return io.dcloud.common.util.BaseInfo.REL_PUBLIC_DOWNLOADS_DIR + str.substring(length4 - 1);
            }
            int i4 = length4 - 1;
            if (!str.startsWith(io.dcloud.common.util.BaseInfo.sDownloadFullPath.substring(0, i4))) {
                return str;
            }
            return io.dcloud.common.util.BaseInfo.REL_PUBLIC_DOWNLOADS_DIR + str.substring(i4);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String convert2WebviewFullPath(java.lang.String str, java.lang.String str2) {
        boolean z;
        if (!io.dcloud.common.util.PdrUtil.isEmpty(str2)) {
            if (this.U) {
                if (!str2.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL)) {
                    return this.s0 + str2;
                }
            } else if (!str2.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL) && !str2.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL) && !str2.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTPS_PROTOCOL)) {
                try {
                    if (io.dcloud.common.adapter.io.DHFile.isExist(str2)) {
                        return "file:///" + b(str2);
                    }
                } catch (java.io.IOException e2) {
                    e2.printStackTrace();
                }
                if (str2.startsWith(io.dcloud.common.adapter.util.DeviceInfo.sDeviceRootDir)) {
                    return io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + str2;
                }
                if (str2.startsWith("/")) {
                    z = true;
                    str2 = str2.substring(1);
                } else {
                    z = false;
                }
                if (str2.startsWith(io.dcloud.common.util.BaseInfo.REL_PRIVATE_WWW_DIR)) {
                    return obtainWebviewBaseUrl() + b(str2.substring(4));
                }
                if (str2.startsWith(io.dcloud.common.util.BaseInfo.REL_PUBLIC_DOCUMENTS_DIR)) {
                    return io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + io.dcloud.common.util.BaseInfo.sDocumentFullPath + b(str2.substring(10));
                }
                if (str2.startsWith(io.dcloud.common.util.BaseInfo.REL_PRIVATE_DOC_DIR)) {
                    return io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + obtainAppDocPath() + b(str2.substring(4));
                }
                if (str2.startsWith(io.dcloud.common.util.BaseInfo.REL_PUBLIC_DOWNLOADS_DIR)) {
                    return io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + io.dcloud.common.util.BaseInfo.sDownloadFullPath + b(str2.substring(10));
                }
                if (str != null && !z) {
                    return io.dcloud.common.util.PdrUtil.standardizedURL(str, str2);
                }
                java.lang.String strObtainWebviewBaseUrl = obtainWebviewBaseUrl();
                if (str != null && !io.dcloud.common.util.PdrUtil.isEquals(str, strObtainWebviewBaseUrl) && str.contains("/www/")) {
                    strObtainWebviewBaseUrl = str.substring(0, str.indexOf("/www/") + 5);
                }
                return strObtainWebviewBaseUrl + b(str2);
            }
        }
        return str2;
    }

    org.json.JSONObject d(java.lang.String str) {
        if (this.x1 == null) {
            m();
        }
        if (this.x1 == null || android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return io.dcloud.common.util.PdrUtil.getSitemapParameters(this.x1, obtainAppId(), str);
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void deleteAppTemp() {
        io.dcloud.common.util.ThreadPool.self().addThreadTask(new io.dcloud.p.d5.e(), true);
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void diyStatusBarState() {
        io.dcloud.common.util.AppStatusBarManager appStatusBarManager = this.m;
        if (appStatusBarManager == null) {
            return;
        }
        if (this.i) {
            appStatusBarManager.setFullScreen(getActivity(), this.i);
        } else {
            if (appStatusBarManager.checkImmersedStatusBar(getActivity(), this.b1)) {
                io.dcloud.common.util.BaseInfo.isImmersive = true;
                this.m.setImmersive(getActivity(), true);
            } else {
                io.dcloud.common.util.BaseInfo.isImmersive = false;
                this.m.setImmersive(getActivity(), false);
            }
            if (getActivity() != null) {
                if (io.dcloud.common.util.PdrUtil.isEmpty(this.X0)) {
                    this.m.setStatusBarColor(getActivity(), io.dcloud.common.util.BaseInfo.mDeStatusBarBackground);
                } else {
                    this.m.setStatusBarColor(getActivity(), this.X0.startsWith("#") ? io.dcloud.common.util.PdrUtil.stringToColor(this.X0) : 0);
                }
            }
            this.m.setStatusBarMode(getActivity(), this.a1);
        }
        if (this.m.isFullScreenOrImmersive()) {
            updateScreenInfo(2);
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String forceShortCut() {
        return this.A1;
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
    boolean g(java.lang.String str) {
        setRuntimeArgs(str);
        setStatus((byte) 3);
        java.lang.Object objProcessEvent = this.y.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 41, new java.lang.Object[]{this, convert2WebviewFullPath(null, this.r0), java.lang.Boolean.valueOf(this.T0)});
        if (objProcessEvent == null) {
            return true;
        }
        return java.lang.Boolean.parseBoolean(java.lang.String.valueOf(objProcessEvent));
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public io.dcloud.common.DHInterface.IConfusionMgr getConfusionMgr() {
        return this.t1;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String getDirectPage() {
        return this.n1;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public io.dcloud.common.DHInterface.IApp.IAppStatusListener getIAppStatusListener() {
        return this.P0;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String getOriginalDirectPage() {
        return this.o1;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String getPathByType(byte b2) {
        if (b2 == 0) {
            return obtainAppDataPath();
        }
        if (b2 == 1) {
            return obtainAppDocPath();
        }
        if (b2 == 2) {
            return io.dcloud.common.util.BaseInfo.sDocumentFullPath;
        }
        if (b2 == 3) {
            return io.dcloud.common.util.BaseInfo.sDownloadFullPath;
        }
        if (b2 != -1) {
            return null;
        }
        return io.dcloud.common.util.BaseInfo.sBaseResAppsPath + this.o + "/" + io.dcloud.common.util.BaseInfo.APP_WWW_FS_DIR;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String getPopGesture() {
        return this.S0;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public int getQuitModel() {
        return this.s1;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String getSystemInfo() {
        try {
            if (io.dcloud.common.adapter.util.DeviceInfo.sSystemInfo == null) {
                return null;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(io.dcloud.common.adapter.util.DeviceInfo.sSystemInfo.toString());
            jSONObject.put("uniCompileVersion", this.u0);
            jSONObject.put("uniRuntimeVersion", io.dcloud.common.util.BaseInfo.uniVersionV3);
            jSONObject.put("browserName", io.dcloud.common.adapter.ui.webview.WebViewFactory.isOther() ? "x5webview" : "chrome");
            jSONObject.put("appId", io.dcloud.common.util.BaseInfo.sCurrentAppOriginalAppid);
            jSONObject.put(com.taobao.weex.common.WXConfig.appName, this.t0);
            if (io.dcloud.feature.internal.sdk.SDK.isUniMP) {
                jSONObject.put(com.taobao.weex.common.WXConfig.appVersion, this.A);
                jSONObject.put("appVersionCode", this.B);
            } else {
                jSONObject.put(com.taobao.weex.common.WXConfig.appVersion, b(getActivity()));
                jSONObject.put("appVersionCode", a((android.content.Context) getActivity()));
            }
            jSONObject.put("appWgtVersion", this.A);
            return jSONObject.toString();
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean isOnAppRunningMode() {
        return this.V == 1;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean isUniApp() {
        return this.q;
    }

    public float j() {
        return (io.dcloud.common.core.permission.PermissionControler.checkPermission(this.o, io.dcloud.common.DHInterface.IFeature.F_DEVICE.toLowerCase(java.util.Locale.ENGLISH)) && getActivity() != null && io.dcloud.common.util.NetworkTypeUtil.getNetworkType(getActivity()) == 4) ? 1000.0f : 0.0f;
    }

    void k() {
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.k0) || !io.dcloud.common.adapter.util.DeviceInfo.startsWithSdcard(this.k0)) {
            setAppDataPath(io.dcloud.common.util.BaseInfo.sCacheFsAppsPath + this.o + "/" + io.dcloud.common.util.BaseInfo.REAL_PRIVATE_WWW_DIR);
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.B1) || !io.dcloud.common.adapter.util.DeviceInfo.startsWithSdcard(this.B1)) {
            setAppDocPath(io.dcloud.common.util.BaseInfo.sBaseFsAppsPath + this.o + "/" + io.dcloud.common.util.BaseInfo.REAL_PRIVATE_DOC_DIR);
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.C1) || !io.dcloud.common.adapter.util.DeviceInfo.startsWithSdcard(this.C1)) {
            this.C1 = io.dcloud.common.util.BaseInfo.sCacheFsAppsPath + this.o + "/" + io.dcloud.common.util.BaseInfo.APP_WEB_CHACHE;
        }
    }

    void m() {
        java.io.File file = new java.io.File(c(this.o));
        if (file.exists()) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(io.dcloud.common.util.IOUtil.toString(new java.io.FileInputStream(file)));
                this.x1 = jSONObject;
                this.C = jSONObject.optString("version");
                return;
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        byte[] fileContent = io.dcloud.common.adapter.util.PlatformUtil.getFileContent("data/sitemap/" + this.o + ".json", 0);
        if (fileContent != null) {
            io.dcloud.common.adapter.io.DHFile.writeFile(fileContent, 0, c(this.o));
            m();
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean manifestBeParsed() {
        return this.v || io.dcloud.feature.internal.sdk.SDK.IntegratedMode.WEBVIEW == io.dcloud.common.util.BaseInfo.sRuntimeMode;
    }

    public boolean n() {
        if (q() && this.v) {
            return this.P;
        }
        return true;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean needRefreshApp() {
        return this.k1;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean needReload() {
        return this.j1;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001d  */
    public boolean o() {
        java.lang.String str;
        java.lang.String strOptString = "";
        if (io.dcloud.common.util.PdrUtil.isEmpty(io.dcloud.common.util.BaseInfo.uniVersionV3)) {
            if (io.dcloud.common.util.BaseInfo.SyncDebug) {
                str = (io.dcloud.common.adapter.util.PlatformUtil.getResInputStream("uni-jsframework-dev.js") == null || io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) ? "uni-jsframework.js" : "uni-jsframework-dev.js";
            }
            try {
                strOptString = new org.json.JSONObject(new java.io.BufferedReader(new java.io.InputStreamReader(getActivity().getAssets().open(str))).readLine().substring(2)).optString("version");
                io.dcloud.common.util.BaseInfo.setUniVersionV3(strOptString, getActivity());
            } catch (java.io.IOException | org.json.JSONException unused) {
            }
        } else {
            strOptString = io.dcloud.common.util.BaseInfo.uniVersionV3;
        }
        return ((!io.dcloud.common.util.PdrUtil.isEmpty(this.w0) && this.w0.contains(strOptString) && !this.x0) || this.y0 || !this.v || this.u0.equals("-1") || this.u0.trim().equals(strOptString) || io.dcloud.common.util.PdrUtil.isEmpty(strOptString) || !this.q) ? false : true;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String obtainAdaptationJs() {
        if (this.T == null && !io.dcloud.common.util.PdrUtil.isEmpty(this.K)) {
            byte[] fileContent = io.dcloud.common.adapter.util.PlatformUtil.getFileContent(a(this.K), obtainRunningAppMode() == 1 ? 0 : 2);
            if (fileContent != null) {
                this.T = new java.lang.String(fileContent);
            } else {
                this.T = "";
            }
        }
        return this.T;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String obtainAppDataPath() {
        java.lang.String str = this.k0;
        if (str != null) {
            return str;
        }
        return this.o + "/www/";
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String obtainAppDocPath() {
        return this.B1;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String obtainAppId() {
        return this.o;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String obtainAppInfo() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("appid", this.o);
            jSONObject.put("versionName", this.A);
            jSONObject.put("name", this.t0);
            jSONObject.put("versionCode", this.B);
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String obtainAppLog() {
        return io.dcloud.common.util.BaseInfo.sBaseFsAppsPath + this.o + "/log/";
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String obtainAppName() {
        return this.t0;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public byte obtainAppStatus() {
        return this.u;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String obtainAppTempPath() {
        return io.dcloud.common.util.BaseInfo.sBaseFsAppsPath + this.o + "/temp/";
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String obtainAppVersionCode() {
        return this.B;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String obtainAppVersionName() {
        return this.A;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String obtainAppWebCachePath() {
        return this.C1;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String obtainConfigProperty(java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "adid")) {
            return this.N0;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "launchError")) {
            return this.M0;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE)) {
            return java.lang.String.valueOf(this.Y);
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "timeout")) {
            return java.lang.String.valueOf(this.a0);
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY)) {
            return java.lang.String.valueOf(this.b0);
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_SPLASHSCREEN)) {
            return java.lang.String.valueOf(this.W);
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_WAITING)) {
            return java.lang.String.valueOf(this.X);
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_H5PLUS)) {
            return java.lang.String.valueOf(this.R);
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_funSetUA)) {
            return java.lang.String.valueOf(this.S);
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_USER_AGENT)) {
            return this.L;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "error")) {
            return this.q0;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_FULLSCREEN)) {
            return java.lang.String.valueOf(this.i);
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_UNTRUSTEDCA)) {
            return this.p0;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LOADED_TIME)) {
            return this.Q0;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_RAM_CACHE_MODE)) {
            return this.R0;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_JSERROR)) {
            return this.N + "";
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CRASH)) {
            return this.M + "";
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_USE_ENCRYPTION)) {
            return this.U0 + "";
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "w2a_delay")) {
            return java.lang.String.valueOf(this.c0);
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "w2a_autoclose")) {
            return java.lang.String.valueOf(this.Z);
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "wap2app_running_mode")) {
            return this.O + "";
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "injection")) {
            return this.i1 + "";
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "event")) {
            return this.d0;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_TARGET)) {
            return this.e0;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LPLUSERQUIRE)) {
            return this.f0;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_SPLUSERQUIRE)) {
            return this.g0;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LGEOLOCATION)) {
            return this.h0;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_SGEOLOCATION)) {
            return this.i0;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_BC)) {
            return this.X0 + "";
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_MODE)) {
            return this.a1;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED)) {
            return this.b1 + "";
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_LAUNCH_ISSTATUS)) {
            return java.lang.String.valueOf(this.c1);
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_LAUNCH_STATUSBAR_COLOR)) {
            return this.e1;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_SECOND_ISATATUS)) {
            return java.lang.String.valueOf(this.d1);
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_SECOND_STATUSBAR_COLOR)) {
            return this.f1;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.JSONKEY_MAP_COORD_TYPE)) {
            return this.p1;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.UNIAPP_WEEX_JS_SERVICE)) {
            return java.lang.String.valueOf(this.g1);
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.APP_UNIAPP_VERSION)) {
            return this.u0;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_UNIAPP_CONTROL)) {
            return this.q ? this.z0 : "h5+";
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.UNI_NVUE_DATA)) {
            org.json.JSONObject jSONObject = this.v0;
            if (jSONObject == null) {
                return null;
            }
            return jSONObject.toString();
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CONCATENATE)) {
            return this.Q + "";
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.NVUE_LAUNCH_MODE)) {
            return this.A0;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_DEBUG_REFRESH)) {
            return this.r1;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.UNI_RESTART_TO_DIRECT)) {
            return java.lang.String.valueOf(this.q1);
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.APP_IS_UNIAPP)) {
            return java.lang.String.valueOf(this.q);
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_USE_V3_ENCRYPTION)) {
            return java.lang.String.valueOf(this.V0);
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.IntentConst.UNIMP_RUN_EXTRA_INFO)) {
            return this.u1;
        }
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public io.dcloud.common.DHInterface.IWebviewStateListener obtainLaunchPageStateListener() {
        return this.v1;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.Object obtainMgrData(io.dcloud.common.DHInterface.IMgr.MgrType mgrType, int i, java.lang.Object[] objArr) {
        return this.y.processEvent(mgrType, i, objArr);
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String obtainOriginalAppId() {
        return this.z;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.io.InputStream obtainResInStream(java.lang.String str, java.lang.String str2) {
        java.lang.String strConvert2AbsFullPath = convert2AbsFullPath(str, str2);
        byte b2 = this.V;
        if (b2 == 1) {
            if (!io.dcloud.common.util.PdrUtil.isDeviceRootDir(strConvert2AbsFullPath)) {
                return io.dcloud.common.adapter.util.PlatformUtil.getResInputStream(strConvert2AbsFullPath);
            }
            try {
                return io.dcloud.common.adapter.io.DHFile.getInputStream(io.dcloud.common.adapter.io.DHFile.createFileHandler(strConvert2AbsFullPath));
            } catch (java.io.IOException e2) {
                io.dcloud.common.adapter.util.Logger.w("WebApp.obtainResInStream", e2);
                return null;
            }
        }
        if (b2 != 0) {
            return null;
        }
        try {
            return io.dcloud.common.adapter.io.DHFile.getInputStream(io.dcloud.common.adapter.io.DHFile.createFileHandler(strConvert2AbsFullPath));
        } catch (java.io.IOException e3) {
            io.dcloud.common.adapter.util.Logger.w("WebApp.obtainResInStream", e3);
            return null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public byte obtainRunningAppMode() {
        return this.V;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String obtainRuntimeArgs(boolean z) {
        return z ? org.json.JSONObject.quote(this.E) : this.E;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public io.dcloud.common.util.AppStatusBarManager obtainStatusBarMgr() {
        return this.m;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public org.json.JSONObject obtainThridInfo(io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo thridInfo) {
        switch (io.dcloud.p.d5.f.a[thridInfo.ordinal()]) {
            case 1:
                return this.D0;
            case 2:
                return this.F0;
            case 3:
                return this.G0;
            case 4:
                return this.H0;
            case 5:
                return this.J0;
            case 6:
                m();
                return this.x1;
            case 7:
                return this.y.g;
            case 8:
                return this.K0;
            case 9:
                return this.E0;
            default:
                return null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String obtainVersionSitemap() {
        return this.C;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public android.content.Intent obtainWebAppIntent() {
        return this.O0;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String obtainWebviewBaseUrl() {
        return a(this.V);
    }

    @Override // io.dcloud.common.DHInterface.ISysEventListener
    public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
        byte b2 = this.u;
        if (b2 == 3) {
            return callSysEventListener(sysEventType, obj);
        }
        if (b2 == 1 && (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppStop || sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onStop)) {
            s();
        }
        return false;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void onSplashClosed() {
        diyStatusBarState();
    }

    public boolean p() {
        return this.u == 3;
    }

    public boolean q() {
        android.content.Intent intentObtainWebAppIntent = obtainWebAppIntent();
        if (intentObtainWebAppIntent != null) {
            boolean z = this.G1;
            this.G1 = intentObtainWebAppIntent.getBooleanExtra(io.dcloud.common.constant.IntentConst.IS_STREAM_APP, z) | z;
        }
        return this.G1;
    }

    public boolean r() {
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.AppMgr_TAG, this.o + " onStop");
        io.dcloud.common.DHInterface.IApp.IAppStatusListener iAppStatusListener = this.P0;
        if (iAppStatusListener != null) {
            return iAppStatusListener.onStop();
        }
        return true;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void registerSysEventListener(io.dcloud.common.DHInterface.ISysEventListener iSysEventListener, io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType) {
        if (this.C0 == null) {
            this.C0 = new java.util.HashMap(1);
        }
        java.util.ArrayList arrayList = (java.util.ArrayList) this.C0.get(sysEventType);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList();
            this.C0.put(sysEventType, arrayList);
        }
        arrayList.add(iSysEventListener);
    }

    public void s() {
        this.l1.clear();
        this.m1.clear();
        android.app.Activity activity = this.a;
        if (activity != null && (activity instanceof io.dcloud.WebAppActivity)) {
            ((io.dcloud.WebAppActivity) activity).onAppStop(this.o);
        }
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.AppMgr_TAG, "webapp.onStoped");
        io.dcloud.common.util.BaseInfo.s_Runing_App_Count--;
        callSysEventListener(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppStop, this);
        d();
        io.dcloud.common.adapter.util.PermissionUtil.removeTempPermission(this.a, this.o);
        b();
        deleteAppTemp();
        io.dcloud.common.core.permission.PermissionControler.unregisterRootPermission(this.o);
        this.y.e(this);
        if (getIAppStatusListener() != null) {
            getIAppStatusListener().onStoped(false, null);
        }
        this.y.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 25, this);
        io.dcloud.common.ui.PrivacyManager.getInstance().unRegisterPrivacyAgreeAllListener();
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setAppDataPath(java.lang.String str) {
        if (this.V == 1) {
            if (str.startsWith(io.dcloud.common.util.BaseInfo.sBaseResAppsPath)) {
                this.k0 = str;
                return;
            }
            this.k0 = io.dcloud.common.util.BaseInfo.sBaseResAppsPath + this.o + "/" + io.dcloud.common.util.BaseInfo.APP_WWW_FS_DIR;
            return;
        }
        if (new java.io.File(str).exists()) {
            this.k0 = str;
            return;
        }
        if (str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.sCacheRootDir)) {
            this.k0 = str;
            return;
        }
        this.k0 = io.dcloud.common.adapter.util.DeviceInfo.sCacheRootDir + "/" + str;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setAppDocPath(java.lang.String str) {
        this.B1 = io.dcloud.common.util.PdrUtil.appendByDeviceRootDir(str);
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setConfigProperty(java.lang.String str, java.lang.String str2) {
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE)) {
            this.Y = io.dcloud.common.util.PdrUtil.parseBoolean(str2, this.Y, false);
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "commit")) {
            a();
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "timeout")) {
            this.a0 = io.dcloud.common.util.PdrUtil.parseInt(str2, this.a0);
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY)) {
            this.b0 = io.dcloud.common.util.PdrUtil.parseInt(str2, this.b0);
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_SPLASHSCREEN)) {
            this.W = io.dcloud.common.util.PdrUtil.parseBoolean(str2, this.W, false);
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_WAITING)) {
            this.X = io.dcloud.common.util.PdrUtil.parseBoolean(str2, this.X, false);
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "name")) {
            this.t0 = str2;
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "name")) {
            this.G = str2;
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "email")) {
            this.H = str2;
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "url")) {
            this.J = str2;
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "name")) {
            this.A = str2;
            io.dcloud.common.util.BaseInfo.sLastAppVersionName = str2;
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "code")) {
            this.B = str2;
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_RUNMODE_LIBERATE)) {
            this.j0 = io.dcloud.common.util.PdrUtil.parseBoolean(str2, this.W, false);
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_H5PLUS)) {
            this.R = io.dcloud.common.util.PdrUtil.parseBoolean(str2, true, false);
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_funSetUA)) {
            this.S = io.dcloud.common.util.PdrUtil.parseBoolean(str2, true, false);
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_USER_AGENT)) {
            this.L = str2;
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_FULLSCREEN)) {
            this.i = io.dcloud.common.util.PdrUtil.parseBoolean(str2, this.i, false);
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "webcache_path")) {
            this.C1 = str2;
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, "wap2app_running_mode")) {
            this.O = io.dcloud.common.util.PdrUtil.parseBoolean(str2, false, false);
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LOADED_TIME)) {
            this.Q0 = str2;
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_BC)) {
            this.X0 = str2;
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_MODE)) {
            this.a1 = str2;
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED)) {
            this.b1 = java.lang.Boolean.valueOf(str2).booleanValue();
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_LAUNCH_ISSTATUS)) {
            this.c1 = java.lang.Boolean.valueOf(str2).booleanValue();
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_LAUNCH_STATUSBAR_COLOR)) {
            this.e1 = str2;
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_SECOND_ISATATUS)) {
            this.d1 = java.lang.Boolean.valueOf(str2).booleanValue();
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_SECOND_STATUSBAR_COLOR)) {
            this.f1 = str2;
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.UNIAPP_WEEX_JS_SERVICE)) {
            this.g1 = java.lang.Boolean.valueOf(str2).booleanValue();
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_DEBUG_REFRESH)) {
            this.r1 = str2;
        } else if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.DHInterface.IApp.ConfigProperty.UNI_RESTART_TO_DIRECT)) {
            this.q1 = java.lang.Boolean.valueOf(str2).booleanValue();
        } else if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.IntentConst.UNIMP_RUN_EXTRA_INFO)) {
            this.u1 = str2;
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setDirectPage(java.lang.String str) {
        this.n1 = str;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setHideNavBarState(boolean z) {
        this.p = z;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setIAppStatusListener(io.dcloud.common.DHInterface.IApp.IAppStatusListener iAppStatusListener) {
        this.P0 = iAppStatusListener;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setLaunchPageStateListener(io.dcloud.common.DHInterface.IWebviewStateListener iWebviewStateListener) {
        this.v1 = iWebviewStateListener;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setNeedRefreshApp(boolean z) {
        this.k1 = z;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setQuitModel(int i) {
        this.s1 = i;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setRuntimeArgs(java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            return;
        }
        this.E = str;
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setStatus(byte b2) {
        this.u = b2;
        if (b2 == 3) {
            this.h1 = java.lang.System.currentTimeMillis();
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void setWebAppActivity(android.app.Activity activity) {
        this.a = activity;
        a(activity);
    }

    /* JADX WARN: Code duplicated, block: B:51:0x012a A[Catch: Exception -> 0x01cb, MalformedURLException -> 0x01cd, TryCatch #6 {MalformedURLException -> 0x01cd, Exception -> 0x01cb, blocks: (B:48:0x011e, B:47:0x011b, B:53:0x012f, B:55:0x0142, B:57:0x0148, B:58:0x0150, B:59:0x0157, B:61:0x0167, B:63:0x0178, B:65:0x0186, B:66:0x0188, B:67:0x018a, B:69:0x0192, B:71:0x019a, B:73:0x01a2, B:75:0x01aa, B:76:0x01b2, B:77:0x01c2, B:80:0x01c7, B:51:0x012a), top: B:110:0x0065, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0167 A[Catch: JSONException -> 0x01c6, Exception -> 0x01cb, MalformedURLException -> 0x01cd, TryCatch #2 {JSONException -> 0x01c6, blocks: (B:55:0x0142, B:57:0x0148, B:58:0x0150, B:59:0x0157, B:61:0x0167, B:63:0x0178, B:65:0x0186, B:66:0x0188, B:67:0x018a, B:69:0x0192, B:71:0x019a, B:73:0x01a2, B:75:0x01aa, B:76:0x01b2, B:77:0x01c2), top: B:105:0x0142, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0178 A[Catch: JSONException -> 0x01c6, Exception -> 0x01cb, MalformedURLException -> 0x01cd, TryCatch #2 {JSONException -> 0x01c6, blocks: (B:55:0x0142, B:57:0x0148, B:58:0x0150, B:59:0x0157, B:61:0x0167, B:63:0x0178, B:65:0x0186, B:66:0x0188, B:67:0x018a, B:69:0x0192, B:71:0x019a, B:73:0x01a2, B:75:0x01aa, B:76:0x01b2, B:77:0x01c2), top: B:105:0x0142, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0186 A[Catch: JSONException -> 0x01c6, Exception -> 0x01cb, MalformedURLException -> 0x01cd, TryCatch #2 {JSONException -> 0x01c6, blocks: (B:55:0x0142, B:57:0x0148, B:58:0x0150, B:59:0x0157, B:61:0x0167, B:63:0x0178, B:65:0x0186, B:66:0x0188, B:67:0x018a, B:69:0x0192, B:71:0x019a, B:73:0x01a2, B:75:0x01aa, B:76:0x01b2, B:77:0x01c2), top: B:105:0x0142, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x01aa A[Catch: JSONException -> 0x01c6, Exception -> 0x01cb, MalformedURLException -> 0x01cd, TryCatch #2 {JSONException -> 0x01c6, blocks: (B:55:0x0142, B:57:0x0148, B:58:0x0150, B:59:0x0157, B:61:0x0167, B:63:0x0178, B:65:0x0186, B:66:0x0188, B:67:0x018a, B:69:0x0192, B:71:0x019a, B:73:0x01a2, B:75:0x01aa, B:76:0x01b2, B:77:0x01c2), top: B:105:0x0142, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01c2 A[Catch: JSONException -> 0x01c6, Exception -> 0x01cb, MalformedURLException -> 0x01cd, TRY_LEAVE, TryCatch #2 {JSONException -> 0x01c6, blocks: (B:55:0x0142, B:57:0x0148, B:58:0x0150, B:59:0x0157, B:61:0x0167, B:63:0x0178, B:65:0x0186, B:66:0x0188, B:67:0x018a, B:69:0x0192, B:71:0x019a, B:73:0x01a2, B:75:0x01aa, B:76:0x01b2, B:77:0x01c2), top: B:105:0x0142, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    @Override // io.dcloud.common.DHInterface.IApp
    public void setWebAppIntent(android.content.Intent intent) {
        java.lang.String str;
        org.json.JSONObject jSONObjectOptJSONObject;
        java.lang.String strOptString;
        char c2;
        boolean booleanExtra = intent.getBooleanExtra(io.dcloud.common.constant.IntentConst.EXE_NEW_INTENT, true);
        char c3 = 0;
        if (booleanExtra || this.O0 == null) {
            this.O0 = new android.content.Intent(intent);
            if (android.text.TextUtils.isEmpty(this.t0)) {
                this.t0 = this.O0.getStringExtra(io.dcloud.common.constant.IntentConst.NAME);
            }
            java.lang.String stringExtra = this.O0.getStringExtra(io.dcloud.common.constant.IntentConst.FIRST_WEB_URL);
            if (!android.text.TextUtils.equals(this.r0, "__no__")) {
                this.r0 = stringExtra;
            }
            java.lang.String stringExtra2 = this.O0.getStringExtra(io.dcloud.common.constant.IntentConst.DIRECT_PAGE);
            if (!android.text.TextUtils.isEmpty(stringExtra2)) {
                try {
                    java.net.URL url = new java.net.URL(stringExtra2);
                    java.lang.String query = url.getQuery();
                    try {
                        if (query != null) {
                            if (query.contains("webviewParameter") || query.contains("__html5plusWebviewParameter")) {
                                java.lang.String str2 = query.contains("webviewParameter") ? "webviewParameter" : "__html5plusWebviewParameter";
                                this.n1 = url.getProtocol() + "://" + url.getHost() + url.getPath();
                                java.lang.String[] strArrSplit = query.split("&");
                                if (strArrSplit != null) {
                                    int i = 0;
                                    boolean z = true;
                                    java.lang.String strDecode = null;
                                    while (i < strArrSplit.length) {
                                        java.lang.String[] strArrSplit2 = strArrSplit[i].split("=");
                                        if (str2.equals(strArrSplit2[c3])) {
                                            strDecode = java.net.URLDecoder.decode(strArrSplit2[1]);
                                        } else {
                                            if (z) {
                                                try {
                                                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                                    c2 = 0;
                                                    try {
                                                        sb.append(this.n1);
                                                        sb.append(com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING);
                                                        this.n1 = sb.toString();
                                                        z = false;
                                                    } catch (java.lang.Exception e2) {
                                                        e = e2;
                                                        e.printStackTrace();
                                                    }
                                                } catch (java.lang.Exception e3) {
                                                    e = e3;
                                                }
                                            } else {
                                                c2 = 0;
                                                if (i < strArrSplit.length) {
                                                    this.n1 += "&";
                                                }
                                            }
                                            this.n1 += strArrSplit2[c2] + "=" + strArrSplit2[1];
                                        }
                                        i++;
                                        c3 = 0;
                                    }
                                    str = strDecode;
                                }
                            } else {
                                this.n1 = stringExtra2;
                            }
                            str = null;
                        } else {
                            this.n1 = stringExtra2;
                            str = null;
                        }
                        java.lang.String str3 = this.n1;
                        this.o1 = str3;
                        this.O0.putExtra(io.dcloud.common.constant.IntentConst.DIRECT_PAGE, str3);
                        org.json.JSONObject jSONObjectD = d(this.n1);
                        this.K0 = jSONObjectD;
                        if (jSONObjectD == null) {
                            try {
                                if (android.text.TextUtils.isEmpty(str)) {
                                    this.K0 = new org.json.JSONObject();
                                } else {
                                    this.K0 = new org.json.JSONObject(str);
                                }
                                if (this.o.equals(this.K0.optString("webviewid"))) {
                                    if (!new java.io.File(a(io.dcloud.common.util.BaseInfo.sConfigXML)).exists()) {
                                        strOptString = this.K0.optString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LAUNCH_PATH);
                                        if (android.text.TextUtils.isEmpty(strOptString)) {
                                            strOptString = this.n1;
                                        }
                                        this.m0 = strOptString;
                                    }
                                    if (this.K0.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR) && (jSONObjectOptJSONObject = this.K0.optJSONObject(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR)) != null && jSONObjectOptJSONObject.optBoolean(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED, true)) {
                                        this.c1 = true;
                                        if (jSONObjectOptJSONObject.has("background")) {
                                            this.e1 = jSONObjectOptJSONObject.optString("background", this.X0);
                                        }
                                    }
                                    this.O0.removeExtra(io.dcloud.common.constant.IntentConst.DIRECT_PAGE);
                                    this.J0 = this.K0.optJSONObject("titleNView");
                                } else {
                                    e();
                                }
                            } catch (org.json.JSONException e4) {
                                e4.printStackTrace();
                            }
                        } else if (this.o.equals(this.K0.optString("webviewid"))) {
                            if (!new java.io.File(a(io.dcloud.common.util.BaseInfo.sConfigXML)).exists()) {
                                strOptString = this.K0.optString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LAUNCH_PATH);
                                if (android.text.TextUtils.isEmpty(strOptString)) {
                                    strOptString = this.n1;
                                }
                                this.m0 = strOptString;
                            }
                            if (this.K0.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR)) {
                                this.c1 = true;
                                if (jSONObjectOptJSONObject.has("background")) {
                                    this.e1 = jSONObjectOptJSONObject.optString("background", this.X0);
                                }
                            }
                            this.O0.removeExtra(io.dcloud.common.constant.IntentConst.DIRECT_PAGE);
                            this.J0 = this.K0.optJSONObject("titleNView");
                        } else {
                            e();
                        }
                    } catch (java.net.MalformedURLException e5) {
                        e = e5;
                        e.printStackTrace();
                    } catch (java.lang.Exception e6) {
                        e = e6;
                        e.printStackTrace();
                    }
                } catch (java.net.MalformedURLException e7) {
                    e = e7;
                } catch (java.lang.Exception e8) {
                    e = e8;
                }
            }
        }
        if (q() && io.dcloud.common.util.BaseInfo.isWap2AppAppid(this.o) && !booleanExtra && intent.getBooleanExtra(io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_JUST_DOWNLOAD, false) && this.D1) {
            this.y.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 50, this);
            this.D1 = false;
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String shortcutQuit() {
        return this.z1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.common.DHInterface.IApp
    public void showSplash() {
        android.app.Activity activity = getActivity();
        if (activity instanceof io.dcloud.common.DHInterface.IOnCreateSplashView) {
            activity.setIntent(this.O0);
            ((io.dcloud.common.DHInterface.IOnCreateSplashView) activity).onCreateSplash(activity);
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public boolean startFromShortCut() {
        return this.y1;
    }

    void t() {
        io.dcloud.common.core.permission.PermissionControler.registerPermission(this.o, this.B0);
    }

    public java.lang.String toString() {
        return this.t0 + com.taobao.weex.el.parse.Operators.SUB + this.o + com.taobao.weex.el.parse.Operators.SUB + super.toString();
    }

    public void u() {
        b(false);
        setStatus((byte) 1);
        io.dcloud.common.util.AppStatus.setAppStatus(this.o, 0);
        this.y.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 3, this.o);
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.AppMgr_TAG, this.o + " will active change to unrunning");
        this.y.processEvent(null, 0, this);
        io.dcloud.common.adapter.ui.webview.WebViewFactory.sUsePermissionWebviews.clear();
        android.util.Log.e("打印日志", "应用退出");
        if (!io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() || io.dcloud.common.util.PdrUtil.isUniMPHostForUniApp()) {
            return;
        }
        io.dcloud.p.j.a();
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void unregisterSysEventListener(io.dcloud.common.DHInterface.ISysEventListener iSysEventListener, io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType) {
        java.util.ArrayList arrayList;
        java.util.HashMap map = this.C0;
        if (map == null || (arrayList = (java.util.ArrayList) map.get(sysEventType)) == null) {
            return;
        }
        arrayList.remove(iSysEventListener);
        if (arrayList.isEmpty()) {
            this.C0.remove(sysEventType);
        }
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public void updateDirectPage(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            str = this.n1;
        }
        org.json.JSONObject jSONObjectD = d(str);
        if (jSONObjectD != null) {
            this.K0 = jSONObjectD;
            e();
            this.y.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 48, this);
        }
    }

    public java.lang.String v() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("appid", this.o);
            jSONObject.put("version", this.A);
            jSONObject.put("name", this.t0);
            jSONObject.put("versionCode", this.B);
            jSONObject.put("description", this.F);
            jSONObject.put("author", this.G);
            jSONObject.put("email", this.H);
            jSONObject.put(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LICENSE, this.I);
            jSONObject.put("licensehref", this.J);
            jSONObject.put(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_FEATURES, new org.json.JSONArray((java.util.Collection) this.B0));
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    void w() {
        b(true);
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String obtainAuthority(java.lang.String str) {
        java.lang.String str2 = io.dcloud.common.util.BaseInfo.sGlobalAuthority;
        if ((str2 != null && android.text.TextUtils.equals("*", str2)) || !q() || android.text.TextUtils.isEmpty(str) || e(this.o)) {
            return io.dcloud.common.DHInterface.IApp.AUTHORITY_AUTHORIZED;
        }
        org.json.JSONObject jSONObject = this.I0;
        if (jSONObject != null) {
            java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                java.lang.String next = itKeys.next();
                if (str.equalsIgnoreCase(next)) {
                    return this.I0.optString(next, io.dcloud.common.DHInterface.IApp.AUTHORITY_UNDETERMINED);
                }
            }
        }
        return io.dcloud.common.DHInterface.IApp.AUTHORITY_UNDETERMINED;
    }

    /* JADX WARN: Code duplicated, block: B:165:0x0380 A[PHI: r38
  0x0380: PHI (r38v4 org.json.JSONObject) = (r38v3 org.json.JSONObject), (r38v7 org.json.JSONObject), (r38v7 org.json.JSONObject) binds: [B:162:0x0377, B:157:0x0364, B:159:0x036a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:287:0x0656  */
    /* JADX WARN: Code duplicated, block: B:289:0x0673  */
    /* JADX WARN: Code duplicated, block: B:291:0x068e  */
    /* JADX WARN: Code duplicated, block: B:293:0x0696  */
    /* JADX WARN: Code duplicated, block: B:294:0x06a3  */
    /* JADX WARN: Code duplicated, block: B:298:0x06c5  */
    /* JADX WARN: Code duplicated, block: B:299:0x06dd  */
    /* JADX WARN: Code duplicated, block: B:301:0x06e5  */
    /* JADX WARN: Code duplicated, block: B:303:0x06f5  */
    /* JADX WARN: Code duplicated, block: B:305:0x070e  */
    /* JADX WARN: Code duplicated, block: B:306:0x0726  */
    /* JADX WARN: Code duplicated, block: B:308:0x072e  */
    /* JADX WARN: Code duplicated, block: B:310:0x0742  */
    /* JADX WARN: Code duplicated, block: B:313:0x0768  */
    /* JADX WARN: Code duplicated, block: B:314:0x0784  */
    /* JADX WARN: Code duplicated, block: B:355:0x08ab  */
    /* JADX WARN: Instruction removed from duplicated block: B:289:0x0673, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:298:0x06c5, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:303:0x06f5, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:305:0x070e, please report this as an issue */
    boolean a(java.io.InputStream inputStream, java.lang.String str, org.json.JSONObject jSONObject) {
        java.lang.String strHandleEncryption;
        boolean z;
        boolean z2;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        java.lang.String str7;
        java.lang.String str8;
        java.lang.String str9;
        org.json.JSONObject jSONObject2;
        org.json.JSONObject jSONObject3;
        org.json.JSONObject jSONObject4;
        boolean z3;
        java.lang.String strOptString;
        org.json.JSONObject jSONObject5;
        java.lang.String str10;
        boolean zIsEquals;
        org.json.JSONObject jSONObject6;
        boolean z4;
        boolean z5;
        java.lang.String string;
        java.lang.String str11;
        java.lang.String str12;
        java.lang.String str13;
        boolean z6;
        boolean z7;
        boolean z8;
        int i;
        boolean z9;
        int i2;
        java.lang.String string2;
        org.json.JSONObject jSONObjectOptJSONObject;
        java.lang.String str14;
        java.lang.String str15;
        boolean z10;
        boolean z11;
        boolean z12;
        org.json.JSONArray jSONArrayNames;
        boolean z13;
        org.json.JSONArray jSONArray;
        org.json.JSONObject jSONObject7;
        boolean z14;
        boolean z15;
        boolean z16;
        int i3;
        int i4;
        java.lang.StringBuilder sb;
        int iJ;
        boolean z17;
        boolean z18;
        java.lang.String strOptString2;
        org.json.JSONObject jSONObject8;
        java.lang.StringBuilder sb2;
        org.json.JSONArray jSONArray2;
        int i5;
        org.json.JSONObject jSONObject9;
        org.json.JSONObject jSONObject10;
        java.lang.String strOptString3;
        java.lang.String str16;
        java.lang.String str17;
        android.content.Context context;
        java.io.InputStream unicodeInputStream = inputStream;
        java.lang.String str18 = str;
        this.j1 = false;
        io.dcloud.p.f5 f5Var = this.s;
        boolean z19 = f5Var != null && f5Var.d;
        this.m1.addAll(io.dcloud.common.util.AppStreamUtil.AppStreamSchemeWhiteDefaultList);
        android.content.Context activity = getActivity();
        if (activity == null) {
            activity = io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext;
        }
        if (unicodeInputStream != null) {
            try {
                if (!this.q) {
                    unicodeInputStream = new io.dcloud.common.adapter.io.UnicodeInputStream(unicodeInputStream, java.nio.charset.Charset.defaultCharset().name());
                }
                byte[] bytes = io.dcloud.common.util.IOUtil.getBytes(unicodeInputStream);
                strHandleEncryption = this.t1.handleEncryption(activity, bytes);
                if (strHandleEncryption != null) {
                    this.U0 = true;
                } else {
                    this.U0 = false;
                    strHandleEncryption = new java.lang.String(bytes);
                }
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
                io.dcloud.common.adapter.util.Logger.e("parseConfig error=" + e2.getMessage());
                strHandleEncryption = "";
            }
        } else {
            strHandleEncryption = "";
        }
        if (this.U0 && z19 && io.dcloud.common.util.BaseInfo.SyncDebug && !io.dcloud.common.util.BaseInfo.isBase(activity) && z19) {
            f5Var.a = true;
            f5Var.b = io.dcloud.common.constant.DOMException.toJSON(io.dcloud.common.constant.DOMException.CODE_BASE_DEBUG_WGT_INSTALL_ERROR_MALFORMED, io.dcloud.common.constant.DOMException.MSG_BASE_DEBUG_WGT_INSTALL_NOT_CONFUSION);
            return false;
        }
        try {
            org.json.JSONObject jSONObject11 = new org.json.JSONObject(strHandleEncryption);
            org.json.JSONObject jSONObject12 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject11, "version");
            java.lang.String string3 = io.dcloud.common.util.JSONUtil.getString(jSONObject12, "name");
            java.lang.String string4 = io.dcloud.common.util.JSONUtil.getString(jSONObject12, "code");
            io.dcloud.common.util.BaseInfo.sLastAppVersionName = string3;
            java.lang.String str19 = this.p0;
            java.lang.String appSignatureSHA1 = io.dcloud.common.util.LoadAppUtils.getAppSignatureSHA1(activity);
            if (z19) {
                z = jSONObject != null ? java.lang.Boolean.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.INSTALL_OPTIONS_FORCE)) : false;
                if (!z && !android.text.TextUtils.isEmpty(this.A) && !io.dcloud.common.util.BaseInfo.BaseAppInfo.compareVersion(string3, this.A)) {
                    if (f5Var.c) {
                        f5Var.b = io.dcloud.common.constant.DOMException.toJSON(io.dcloud.common.constant.DOMException.CODE_RUNTIME_WGTU_WWW_MANIFEST_VERSION_NOT_MATCH, io.dcloud.common.constant.DOMException.MSG_RUNTIME_WGTU_WWW_MANIFEST_VERSION_NOT_MATCH);
                    } else {
                        f5Var.b = io.dcloud.common.constant.DOMException.toJSON(io.dcloud.common.constant.DOMException.CODE_RUNTIME_WGT_MANIFEST_VERSION_NOT_MATCH, io.dcloud.common.constant.DOMException.MSG_RUNTIME_WGT_MANIFEST_VERSION_NOT_MATCH);
                    }
                    f5Var.a = true;
                    return false;
                }
            } else {
                z = false;
            }
            java.lang.String string5 = io.dcloud.common.util.JSONUtil.getString(jSONObject11, "id");
            io.dcloud.common.util.BaseInfo.sCurrentAppOriginalAppid = string5;
            if (io.dcloud.common.util.BaseInfo.ISDEBUG && (context = io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext) != null && io.dcloud.common.util.BaseInfo.isBase(context)) {
                z2 = true;
            } else {
                z2 = io.dcloud.common.util.PdrUtil.isEquals(str18, string5) && io.dcloud.common.util.PdrUtil.isEquals(this.o, string5);
                if (!z2) {
                    f5Var.a = true;
                    if (f5Var.c) {
                        f5Var.b = io.dcloud.common.constant.DOMException.toJSON(io.dcloud.common.constant.DOMException.CODE_RUNTIME_WGTU_WWW_MANIFEST_ERROR_MALFORMED, io.dcloud.common.constant.DOMException.MSG_RUNTIME_WGTU_WWW_MANIFEST_APPID_NOT_MATCH);
                    } else {
                        f5Var.b = io.dcloud.common.constant.DOMException.toJSON(io.dcloud.common.constant.DOMException.CODE_RUNTIME_WGT_MANIFEST_APPID_NOT_MATCH, io.dcloud.common.constant.DOMException.MSG_RUNTIME_WGT_MANIFEST_APPID_NOT_MATCH);
                    }
                    android.util.Log.e("Appmgr", "appid config is wrong pExpectAppid=" + str18 + ";appid=" + string5);
                    return false;
                }
                str18 = string5;
            }
            java.lang.String string6 = io.dcloud.common.util.JSONUtil.getString(jSONObject11, "name");
            boolean z20 = z;
            if (!io.dcloud.p.c4.c()) {
                appSignatureSHA1 = appSignatureSHA1 + getConfusionMgr().decodeString(getConfusionMgr().getS5DS(), true, 60);
            }
            java.lang.String str20 = appSignatureSHA1;
            java.lang.String string7 = io.dcloud.common.util.JSONUtil.getString(jSONObject11, "description");
            org.json.JSONObject jSONObject13 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject11, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DEVELOPER);
            java.lang.String string8 = io.dcloud.common.util.JSONUtil.getString(jSONObject13, "name");
            java.lang.String string9 = io.dcloud.common.util.JSONUtil.getString(jSONObject13, "email");
            io.dcloud.common.util.JSONUtil.getString(jSONObject13, "url");
            org.json.JSONObject jSONObject14 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject11, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LICENSE);
            java.lang.String string10 = io.dcloud.common.util.JSONUtil.getString(jSONObject14, "url");
            io.dcloud.common.util.JSONUtil.getString(jSONObject14, "description");
            java.lang.String string11 = io.dcloud.common.util.JSONUtil.getString(jSONObject11, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LAUNCH_PATH);
            java.lang.String string12 = io.dcloud.common.util.JSONUtil.getString(jSONObject11, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LAUNCH_PATH_W2A);
            boolean z21 = this.j1 || !(android.text.TextUtils.isEmpty(this.l0) || android.text.TextUtils.equals(string11, this.l0));
            this.j1 = z21;
            this.j1 = z21 || !(android.text.TextUtils.isEmpty(this.n0) || android.text.TextUtils.equals(string12, this.n0));
            java.lang.String string13 = io.dcloud.common.util.JSONUtil.getString(jSONObject11, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_BASEURL);
            boolean z22 = !io.dcloud.common.util.PdrUtil.isEmpty(this.s0);
            org.json.JSONObject jSONObject15 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject11, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_PLUS);
            if (jSONObject15.has(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CONFUSION)) {
                str3 = string11;
                org.json.JSONObject jSONObject16 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject15, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CONFUSION);
                if (jSONObject16 == null) {
                    str2 = string7;
                    if (jSONObject15.optString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CONFUSION).startsWith("BQ81KwABAA")) {
                        this.U0 = true;
                        this.V0 = true;
                    }
                    if (this.t1.recordEncryptionV3Resources(this.o, jSONObject15.optString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CONFUSION))) {
                        this.U0 = true;
                        this.V0 = true;
                    }
                } else {
                    str2 = string7;
                    if (this.U0) {
                        this.t1.recordEncryptionResources(this.o, jSONObject16);
                    }
                }
            } else {
                str2 = string7;
                str3 = string11;
            }
            io.dcloud.common.adapter.util.PermissionUtil.isCheckPermissionDisabled = io.dcloud.common.util.JSONUtil.getBoolean(jSONObject15, "checkPermissionDenied");
            org.json.JSONObject jSONObject17 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject15, io.dcloud.common.constant.AbsoluteConst.UNI_TABBAR_KEY);
            org.json.JSONObject jSONObject18 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject15, io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR);
            java.lang.String strOptString4 = "none";
            if (jSONObject18 != null) {
                if (jSONObject18.has("background")) {
                    str4 = string5;
                    java.lang.String strOptString5 = jSONObject18.optString("background");
                    if (!io.dcloud.common.util.PdrUtil.isEmpty(strOptString5)) {
                        this.X0 = strOptString5;
                    }
                } else {
                    str4 = string5;
                }
                if (jSONObject18.has("style")) {
                    this.a1 = jSONObject18.optString("style", this.a1);
                }
                if (jSONObject18.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED)) {
                    java.lang.String strOptString6 = jSONObject18.optString(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED);
                    this.n = strOptString6;
                    str5 = string3;
                    if (!strOptString6.equals("supportedDevice") && !this.n.equals("suggestedDevice")) {
                        if (!this.n.equals("none")) {
                            this.b1 = jSONObject18.optBoolean(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED, this.b1);
                        } else {
                            this.b1 = false;
                        }
                    } else {
                        this.b1 = true;
                    }
                } else {
                    str5 = string3;
                }
            } else {
                str4 = string5;
                str5 = string3;
                string4 = string4;
            }
            org.json.JSONObject jSONObject19 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject15, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LAUNCHWEBVIEW);
            java.lang.String strOptString7 = null;
            if (jSONObject19 != null) {
                org.json.JSONObject jSONObject20 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject19, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_OVERRIDEURL);
                org.json.JSONArray jSONArray3 = io.dcloud.common.util.JSONUtil.getJSONArray(jSONObject19, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_OVERRIDE_RESOURCE);
                if (jSONArray3 != null) {
                    str7 = str20;
                    jSONObject9 = new org.json.JSONObject();
                    str6 = str18;
                    try {
                        jSONObject9.put(com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT, jSONArray3);
                    } catch (org.json.JSONException e3) {
                        e3.printStackTrace();
                    }
                } else {
                    str6 = str18;
                    str7 = str20;
                    jSONObject9 = null;
                }
                boolean zOptBoolean = jSONObject19.optBoolean("injection", this.i1);
                java.lang.String strOptString8 = jSONObject19.optString("plusrequire", "normal");
                if (jSONObject19.has("titleNView")) {
                    jSONObject10 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject19, "titleNView");
                } else {
                    jSONObject10 = jSONObject19.has("navigationbar") ? io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject19, "navigationbar") : null;
                }
                if (jSONObject19.has("replacewebapi")) {
                    jSONObject4 = jSONObject10;
                    org.json.JSONObject jSONObjectOptJSONObject2 = jSONObject19.optJSONObject("replacewebapi");
                    if (jSONObjectOptJSONObject2 == null || !jSONObjectOptJSONObject2.has("geolocation")) {
                        str16 = "none";
                    } else {
                        strOptString3 = jSONObjectOptJSONObject2.optString("geolocation", "none");
                        str16 = strOptString3;
                    }
                } else {
                    jSONObject4 = jSONObject10;
                    if (jSONObject19.has("geolocation")) {
                        strOptString3 = jSONObject19.optString("geolocation", "none");
                        str16 = strOptString3;
                    } else {
                        str16 = "none";
                    }
                }
                if (this.b1 && jSONObject19.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR)) {
                    this.c1 = true;
                    org.json.JSONObject jSONObjectOptJSONObject3 = jSONObject19.optJSONObject(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR);
                    if (jSONObjectOptJSONObject3 == null || !jSONObjectOptJSONObject3.has("background")) {
                        str17 = strOptString8;
                    } else {
                        str17 = strOptString8;
                        this.e1 = jSONObjectOptJSONObject3.optString("background", this.X0);
                    }
                } else {
                    str17 = strOptString8;
                }
                jSONObject3 = jSONObject9;
                jSONObject2 = jSONObject20;
                z3 = zOptBoolean;
                str8 = str16;
                str9 = str17;
            } else {
                str6 = str18;
                str7 = str20;
                str8 = "none";
                str9 = "normal";
                jSONObject2 = null;
                jSONObject3 = null;
                jSONObject4 = null;
                z3 = true;
            }
            if (jSONObject15.has("appWhitelist")) {
                org.json.JSONArray jSONArrayOptJSONArray = jSONObject15.optJSONArray("appWhitelist");
                int i6 = 0;
                while (i6 < jSONArrayOptJSONArray.length()) {
                    java.lang.String strOptString9 = jSONArrayOptJSONArray.optString(i6);
                    if (android.text.TextUtils.isEmpty(strOptString9)) {
                        i5 = i6;
                    } else {
                        i5 = i6;
                        if (!this.l1.contains(strOptString9)) {
                            this.l1.add(strOptString9);
                        }
                    }
                    i6 = i5 + 1;
                }
            }
            if (jSONObject15.has("schemeWhitelist")) {
                org.json.JSONArray jSONArrayOptJSONArray2 = jSONObject15.optJSONArray("schemeWhitelist");
                int i7 = 0;
                while (i7 < jSONArrayOptJSONArray2.length()) {
                    java.lang.String strOptString10 = jSONArrayOptJSONArray2.optString(i7);
                    if (android.text.TextUtils.isEmpty(strOptString10)) {
                        jSONArray2 = jSONArrayOptJSONArray2;
                    } else {
                        jSONArray2 = jSONArrayOptJSONArray2;
                        if (!this.m1.contains(strOptString10)) {
                            this.m1.add(strOptString10);
                        }
                    }
                    i7++;
                    jSONArrayOptJSONArray2 = jSONArray2;
                }
            }
            org.json.JSONObject jSONObject21 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject15, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_SECONDWEBVIEW);
            if (jSONObject21 != null) {
                strOptString = jSONObject21.optString("plusrequire", "normal");
                if (jSONObject21.has("replacewebapi")) {
                    org.json.JSONObject jSONObjectOptJSONObject4 = jSONObject21.optJSONObject("replacewebapi");
                    if (jSONObjectOptJSONObject4 != null && jSONObjectOptJSONObject4.has("geolocation")) {
                        strOptString4 = jSONObjectOptJSONObject4.optString("geolocation", "none");
                    }
                } else if (jSONObject21.has("geolocation")) {
                    strOptString4 = jSONObject21.optString("geolocation", "none");
                }
                if (this.b1 && jSONObject21.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR)) {
                    this.d1 = true;
                    org.json.JSONObject jSONObjectOptJSONObject5 = jSONObject21.optJSONObject(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR);
                    if (jSONObjectOptJSONObject5 != null && jSONObjectOptJSONObject5.has("background")) {
                        this.f1 = jSONObjectOptJSONObject5.optString("background", this.X0);
                    }
                }
            } else {
                strOptString = "normal";
            }
            if (io.dcloud.common.util.BaseInfo.isBase(this.y.getContext())) {
                this.R0 = io.dcloud.common.util.JSONUtil.getString(jSONObject15, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_RAM_CACHE_MODE);
            }
            this.T0 = jSONObject15.optBoolean(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_HARDWARE_ACCELERATED, io.dcloud.common.adapter.util.MobilePhoneModel.checkPhoneBanAcceleration(android.os.Build.BRAND) || (io.dcloud.common.util.BaseInfo.isWap2AppAppid(this.o) && q()));
            this.S0 = jSONObject15.optString("popGesture", this.S0);
            org.json.JSONObject jSONObject22 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject15, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CACHE);
            if (jSONObject22 != null) {
                java.lang.String string14 = io.dcloud.common.util.JSONUtil.getString(jSONObject22, "mode");
                if (android.text.TextUtils.isEmpty(string14)) {
                    string14 = this.W0;
                }
                this.W0 = string14;
            }
            org.json.JSONObject jSONObject23 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject15, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CERS);
            boolean z23 = io.dcloud.common.util.PdrUtil.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObject23, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CRASH), this.M, false);
            boolean z24 = io.dcloud.common.util.PdrUtil.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObject23, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_JSERROR), this.N, false);
            org.json.JSONObject jSONObjectOptJSONObject6 = jSONObject15.optJSONObject("compatible");
            java.lang.String str21 = strOptString4;
            if (jSONObjectOptJSONObject6 != null && jSONObject15.has("uni-app")) {
                org.json.JSONObject jSONObjectOptJSONObject7 = jSONObject15.optJSONObject("uni-app");
                if (!a(jSONObjectOptJSONObject7, f5Var)) {
                    return false;
                }
                str10 = strOptString;
                this.q = true;
                this.z0 = io.dcloud.common.constant.AbsoluteConst.UNI_V3;
                jSONObject5 = jSONObject21;
                this.y0 = jSONObjectOptJSONObject6.optBoolean("ignoreVersion", false);
                java.lang.String strOptString11 = jSONObjectOptJSONObject6.optString("compilerVersion");
                this.w0 = jSONObjectOptJSONObject6.optString("runtimeVersion");
                this.u0 = jSONObjectOptJSONObject7.optString("compilerVersion");
                this.A0 = jSONObjectOptJSONObject7.optString(io.dcloud.common.constant.AbsoluteConst.NVUE_LAUNCH_MODE, "normal");
                if (!io.dcloud.common.util.PdrUtil.isEmpty(strOptString11) && strOptString11.trim().equals(this.u0)) {
                    this.x0 = false;
                }
            } else {
                jSONObject5 = jSONObject21;
                str10 = strOptString;
                if (jSONObject15.has("uni-app")) {
                    org.json.JSONObject jSONObjectOptJSONObject8 = jSONObject15.optJSONObject("uni-app");
                    if (!a(jSONObjectOptJSONObject8, f5Var)) {
                        return false;
                    }
                    this.q = true;
                    this.u0 = jSONObjectOptJSONObject8.optString("compilerVersion");
                    this.z0 = io.dcloud.common.constant.AbsoluteConst.UNI_V3;
                    this.v0 = jSONObjectOptJSONObject8.optJSONObject("nvue");
                    this.A0 = jSONObjectOptJSONObject8.optString(io.dcloud.common.constant.AbsoluteConst.NVUE_LAUNCH_MODE, "normal");
                } else {
                    this.q = false;
                }
            }
            if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
                zIsEquals = true;
            } else {
                java.lang.String string15 = io.dcloud.common.util.JSONUtil.getString(jSONObject15, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_RUNMODE);
                if (android.text.TextUtils.isEmpty(string15) && this.q) {
                    string15 = io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_RUNMODE_LIBERATE;
                }
                zIsEquals = io.dcloud.common.util.PdrUtil.isEquals(string15, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_RUNMODE_LIBERATE);
            }
            org.json.JSONObject jSONObject24 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject15, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_USER_AGENT);
            java.lang.String string16 = io.dcloud.common.util.JSONUtil.getString(jSONObject24, "value");
            boolean z25 = io.dcloud.common.util.PdrUtil.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObject24, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CONCATENATE), this.Q, false);
            org.json.JSONObject jSONObject25 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject15, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_USER_AGENT_ANDROID);
            java.lang.String string17 = io.dcloud.common.util.JSONUtil.getString(jSONObject25, "value");
            boolean z26 = io.dcloud.common.util.PdrUtil.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObject25, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CONCATENATE), z25, false);
            java.lang.String str22 = !android.text.TextUtils.isEmpty(string17) ? string17 : string16;
            org.json.JSONObject jSONObject26 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject15, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_SPLASHSCREEN);
            if (jSONObject26 != null) {
                android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(getActivity(), "pdr");
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                jSONObject6 = jSONObject2;
                sb3.append(this.o);
                sb3.append(io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_AUTOCLOSE);
                if (orCreateBundle.contains(sb3.toString())) {
                    z14 = orCreateBundle.getBoolean(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_AUTOCLOSE, true);
                } else {
                    if (io.dcloud.common.util.JSONUtil.isNull(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE)) {
                        z14 = false;
                        z15 = true;
                    } else {
                        z14 = java.lang.Boolean.parseBoolean(java.lang.String.valueOf(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE)));
                    }
                    if (z15) {
                        z16 = z15;
                        sb2 = new java.lang.StringBuilder();
                        z5 = z26;
                        sb2.append(this.o);
                        sb2.append(io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_DELAY);
                        if (orCreateBundle.contains(sb2.toString())) {
                            i3 = orCreateBundle.getInt(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_DELAY, 0);
                        } else {
                            if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY)) {
                                i3 = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY), this.b0);
                            }
                            sb = new java.lang.StringBuilder();
                            z4 = zIsEquals;
                            sb.append(this.o);
                            sb.append(io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_AUTOCLOSE_W2A);
                            if (orCreateBundle.contains(sb.toString())) {
                                z14 = orCreateBundle.getBoolean(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_AUTOCLOSE_W2A, z14);
                            } else if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)) {
                                z14 = java.lang.Boolean.parseBoolean(java.lang.String.valueOf(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)));
                            }
                            if (z14) {
                                if (orCreateBundle.contains(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_DELAY_W2A)) {
                                    i3 = orCreateBundle.getInt(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_DELAY_W2A, i3);
                                } else if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY_W2A)) {
                                    i3 = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY_W2A), this.c0);
                                }
                                iJ = (int) (i3 + j());
                            } else {
                                iJ = i3;
                            }
                            z17 = io.dcloud.common.util.PdrUtil.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_WAITING), this.X, false);
                            string = io.dcloud.common.util.JSONUtil.getString(jSONObject26, "event");
                            z18 = z14;
                            strOptString2 = jSONObject26.optString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_TARGET, "default");
                            jSONObject8 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject26, "ads");
                            if (jSONObject8 != null) {
                                java.lang.String strOptString12 = jSONObject8.optString("background", "#ffffff");
                                java.lang.String strOptString13 = jSONObject8.optString("image", "");
                                z9 = z17;
                                i2 = i4;
                                z7 = z18;
                                str13 = strOptString2;
                                str12 = strOptString12;
                                z8 = z16;
                                str11 = strOptString13;
                                i = iJ;
                                z6 = true;
                            } else {
                                i = iJ;
                                z9 = z17;
                                z8 = z16;
                                i2 = i4;
                                z7 = z18;
                                z6 = true;
                                str13 = strOptString2;
                                str11 = null;
                                str12 = null;
                            }
                        }
                        i4 = i3;
                        sb = new java.lang.StringBuilder();
                        z4 = zIsEquals;
                        sb.append(this.o);
                        sb.append(io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_AUTOCLOSE_W2A);
                        if (orCreateBundle.contains(sb.toString())) {
                            z14 = orCreateBundle.getBoolean(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_AUTOCLOSE_W2A, z14);
                        } else if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)) {
                            z14 = java.lang.Boolean.parseBoolean(java.lang.String.valueOf(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)));
                        }
                        if (z14) {
                            if (orCreateBundle.contains(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_DELAY_W2A)) {
                                i3 = orCreateBundle.getInt(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_DELAY_W2A, i3);
                            } else if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY_W2A)) {
                                i3 = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY_W2A), this.c0);
                            }
                            iJ = (int) (i3 + j());
                        } else {
                            iJ = i3;
                        }
                        z17 = io.dcloud.common.util.PdrUtil.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_WAITING), this.X, false);
                        string = io.dcloud.common.util.JSONUtil.getString(jSONObject26, "event");
                        z18 = z14;
                        strOptString2 = jSONObject26.optString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_TARGET, "default");
                        jSONObject8 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject26, "ads");
                        if (jSONObject8 != null) {
                            java.lang.String strOptString14 = jSONObject8.optString("background", "#ffffff");
                            java.lang.String strOptString15 = jSONObject8.optString("image", "");
                            z9 = z17;
                            i2 = i4;
                            z7 = z18;
                            str13 = strOptString2;
                            str12 = strOptString14;
                            z8 = z16;
                            str11 = strOptString15;
                            i = iJ;
                            z6 = true;
                        } else {
                            i = iJ;
                            z9 = z17;
                            z8 = z16;
                            i2 = i4;
                            z7 = z18;
                            z6 = true;
                            str13 = strOptString2;
                            str11 = null;
                            str12 = null;
                        }
                    } else {
                        z5 = z26;
                        z16 = z15;
                    }
                    i3 = 0;
                    i4 = 0;
                    sb = new java.lang.StringBuilder();
                    z4 = zIsEquals;
                    sb.append(this.o);
                    sb.append(io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_AUTOCLOSE_W2A);
                    if (orCreateBundle.contains(sb.toString())) {
                        z14 = orCreateBundle.getBoolean(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_AUTOCLOSE_W2A, z14);
                    } else if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)) {
                        z14 = java.lang.Boolean.parseBoolean(java.lang.String.valueOf(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)));
                    }
                    if (z14) {
                        if (orCreateBundle.contains(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_DELAY_W2A)) {
                            i3 = orCreateBundle.getInt(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_DELAY_W2A, i3);
                        } else if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY_W2A)) {
                            i3 = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY_W2A), this.c0);
                        }
                        iJ = (int) (i3 + j());
                    } else {
                        iJ = i3;
                    }
                    z17 = io.dcloud.common.util.PdrUtil.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_WAITING), this.X, false);
                    string = io.dcloud.common.util.JSONUtil.getString(jSONObject26, "event");
                    z18 = z14;
                    strOptString2 = jSONObject26.optString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_TARGET, "default");
                    jSONObject8 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject26, "ads");
                    if (jSONObject8 != null) {
                        java.lang.String strOptString16 = jSONObject8.optString("background", "#ffffff");
                        java.lang.String strOptString17 = jSONObject8.optString("image", "");
                        z9 = z17;
                        i2 = i4;
                        z7 = z18;
                        str13 = strOptString2;
                        str12 = strOptString16;
                        z8 = z16;
                        str11 = strOptString17;
                        i = iJ;
                        z6 = true;
                    } else {
                        i = iJ;
                        z9 = z17;
                        z8 = z16;
                        i2 = i4;
                        z7 = z18;
                        z6 = true;
                        str13 = strOptString2;
                        str11 = null;
                        str12 = null;
                    }
                }
                z15 = z14;
                if (z15) {
                    z16 = z15;
                    sb2 = new java.lang.StringBuilder();
                    z5 = z26;
                    sb2.append(this.o);
                    sb2.append(io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_DELAY);
                    if (orCreateBundle.contains(sb2.toString())) {
                        i3 = orCreateBundle.getInt(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_DELAY, 0);
                    } else {
                        if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY)) {
                            i3 = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY), this.b0);
                        }
                        sb = new java.lang.StringBuilder();
                        z4 = zIsEquals;
                        sb.append(this.o);
                        sb.append(io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_AUTOCLOSE_W2A);
                        if (orCreateBundle.contains(sb.toString())) {
                            z14 = orCreateBundle.getBoolean(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_AUTOCLOSE_W2A, z14);
                        } else if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)) {
                            z14 = java.lang.Boolean.parseBoolean(java.lang.String.valueOf(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)));
                        }
                        if (z14) {
                            if (orCreateBundle.contains(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_DELAY_W2A)) {
                                i3 = orCreateBundle.getInt(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_DELAY_W2A, i3);
                            } else if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY_W2A)) {
                                i3 = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY_W2A), this.c0);
                            }
                            iJ = (int) (i3 + j());
                        } else {
                            iJ = i3;
                        }
                        z17 = io.dcloud.common.util.PdrUtil.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_WAITING), this.X, false);
                        string = io.dcloud.common.util.JSONUtil.getString(jSONObject26, "event");
                        z18 = z14;
                        strOptString2 = jSONObject26.optString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_TARGET, "default");
                        jSONObject8 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject26, "ads");
                        if (jSONObject8 != null) {
                            java.lang.String strOptString18 = jSONObject8.optString("background", "#ffffff");
                            java.lang.String strOptString19 = jSONObject8.optString("image", "");
                            z9 = z17;
                            i2 = i4;
                            z7 = z18;
                            str13 = strOptString2;
                            str12 = strOptString18;
                            z8 = z16;
                            str11 = strOptString19;
                            i = iJ;
                            z6 = true;
                        } else {
                            i = iJ;
                            z9 = z17;
                            z8 = z16;
                            i2 = i4;
                            z7 = z18;
                            z6 = true;
                            str13 = strOptString2;
                            str11 = null;
                            str12 = null;
                        }
                    }
                    i4 = i3;
                    sb = new java.lang.StringBuilder();
                    z4 = zIsEquals;
                    sb.append(this.o);
                    sb.append(io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_AUTOCLOSE_W2A);
                    if (orCreateBundle.contains(sb.toString())) {
                        z14 = orCreateBundle.getBoolean(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_AUTOCLOSE_W2A, z14);
                    } else if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)) {
                        z14 = java.lang.Boolean.parseBoolean(java.lang.String.valueOf(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)));
                    }
                    if (z14) {
                        if (orCreateBundle.contains(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_DELAY_W2A)) {
                            i3 = orCreateBundle.getInt(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_DELAY_W2A, i3);
                        } else if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY_W2A)) {
                            i3 = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY_W2A), this.c0);
                        }
                        iJ = (int) (i3 + j());
                    } else {
                        iJ = i3;
                    }
                    z17 = io.dcloud.common.util.PdrUtil.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_WAITING), this.X, false);
                    string = io.dcloud.common.util.JSONUtil.getString(jSONObject26, "event");
                    z18 = z14;
                    strOptString2 = jSONObject26.optString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_TARGET, "default");
                    jSONObject8 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject26, "ads");
                    if (jSONObject8 != null) {
                        java.lang.String strOptString110 = jSONObject8.optString("background", "#ffffff");
                        java.lang.String strOptString111 = jSONObject8.optString("image", "");
                        z9 = z17;
                        i2 = i4;
                        z7 = z18;
                        str13 = strOptString2;
                        str12 = strOptString110;
                        z8 = z16;
                        str11 = strOptString111;
                        i = iJ;
                        z6 = true;
                    } else {
                        i = iJ;
                        z9 = z17;
                        z8 = z16;
                        i2 = i4;
                        z7 = z18;
                        z6 = true;
                        str13 = strOptString2;
                        str11 = null;
                        str12 = null;
                    }
                } else {
                    z5 = z26;
                    z16 = z15;
                }
                i3 = 0;
                i4 = 0;
                sb = new java.lang.StringBuilder();
                z4 = zIsEquals;
                sb.append(this.o);
                sb.append(io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_AUTOCLOSE_W2A);
                if (orCreateBundle.contains(sb.toString())) {
                    z14 = orCreateBundle.getBoolean(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_AUTOCLOSE_W2A, z14);
                } else if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)) {
                    z14 = java.lang.Boolean.parseBoolean(java.lang.String.valueOf(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)));
                }
                if (z14) {
                    if (orCreateBundle.contains(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_DELAY_W2A)) {
                        i3 = orCreateBundle.getInt(this.o + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_DELAY_W2A, i3);
                    } else if (!io.dcloud.common.util.JSONUtil.isNull(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY_W2A)) {
                        i3 = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY_W2A), this.c0);
                    }
                    iJ = (int) (i3 + j());
                } else {
                    iJ = i3;
                }
                z17 = io.dcloud.common.util.PdrUtil.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObject26, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_WAITING), this.X, false);
                string = io.dcloud.common.util.JSONUtil.getString(jSONObject26, "event");
                z18 = z14;
                strOptString2 = jSONObject26.optString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_TARGET, "default");
                jSONObject8 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject26, "ads");
                if (jSONObject8 != null) {
                    java.lang.String strOptString112 = jSONObject8.optString("background", "#ffffff");
                    java.lang.String strOptString113 = jSONObject8.optString("image", "");
                    z9 = z17;
                    i2 = i4;
                    z7 = z18;
                    str13 = strOptString2;
                    str12 = strOptString112;
                    z8 = z16;
                    str11 = strOptString113;
                    i = iJ;
                    z6 = true;
                } else {
                    i = iJ;
                    z9 = z17;
                    z8 = z16;
                    i2 = i4;
                    z7 = z18;
                    z6 = true;
                    str13 = strOptString2;
                    str11 = null;
                    str12 = null;
                }
            } else {
                jSONObject6 = jSONObject2;
                z4 = zIsEquals;
                z5 = z26;
                string = null;
                str11 = null;
                str12 = null;
                str13 = null;
                z6 = false;
                z7 = false;
                z8 = true;
                i = 0;
                z9 = false;
                i2 = 0;
            }
            org.json.JSONObject jSONObject27 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject15, "error");
            if (jSONObject27 != null && !io.dcloud.common.util.JSONUtil.isNull(jSONObject27, "url")) {
                string2 = io.dcloud.common.util.JSONUtil.getString(jSONObject27, "url");
            } else {
                string2 = "file:///android_asset/data/dcloud_error.html";
            }
            org.json.JSONObject jSONObject28 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject15, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_SSL);
            java.lang.String str23 = string;
            java.lang.String string18 = (jSONObject28 == null || io.dcloud.common.util.JSONUtil.isNull(jSONObject28, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_UNTRUSTEDCA)) ? str19 : io.dcloud.common.util.JSONUtil.getString(jSONObject28, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_UNTRUSTEDCA);
            org.json.JSONObject jSONObject29 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject15, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_STREAM);
            int i8 = i;
            boolean zIsWap2AppAppid = io.dcloud.common.util.BaseInfo.isWap2AppAppid(this.o);
            this.P = zIsWap2AppAppid;
            int i9 = i2;
            if (jSONObject29 != null) {
                this.P = jSONObject29.optBoolean(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_COMPETENT, zIsWap2AppAppid);
                this.A1 = jSONObject29.optString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_SHORTCUT);
                this.z1 = jSONObject29.optString("shortcutQuit");
                jSONObjectOptJSONObject = jSONObject29.optJSONObject(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTHORITY);
            } else {
                jSONObjectOptJSONObject = null;
            }
            if (!this.P) {
                io.dcloud.common.util.BaseInfo.createAppTestFile(str6);
            } else {
                io.dcloud.common.util.BaseInfo.removeTestFile(str6);
            }
            java.lang.String str24 = H1;
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
            org.json.JSONObject jSONObject30 = jSONObjectOptJSONObject;
            sb4.append(this.o);
            sb4.append(" app competent=");
            sb4.append(this.P);
            io.dcloud.common.adapter.util.Logger.i(str24, sb4.toString());
            if (this.q || io.dcloud.p.c4.c()) {
                str14 = str6;
                str15 = string18;
                z10 = z2;
            } else {
                java.lang.String metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue(getConfusionMgr().decryptStr("lkdg}lWixxcmq"));
                if (io.dcloud.p.c4.b()) {
                    str14 = str6;
                    if (io.dcloud.p.t.c(activity, str14)) {
                        str15 = string18;
                        z10 = true;
                        if (!z10) {
                            setStatus((byte) 4);
                            return false;
                        }
                    }
                    str15 = string18;
                    z10 = false;
                    if (!z10) {
                        setStatus((byte) 4);
                        return false;
                    }
                } else {
                    str14 = str6;
                    if (android.text.TextUtils.isEmpty(metaValue)) {
                        str15 = string18;
                    } else {
                        java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                        sb5.append(str14);
                        str15 = string18;
                        sb5.append(activity.getPackageName().toLowerCase(java.util.Locale.ENGLISH));
                        java.lang.String strMd5 = io.dcloud.common.util.Md5Utils.md5(sb5.toString() + str7);
                        if (!android.text.TextUtils.isEmpty(strMd5) && metaValue.equalsIgnoreCase(strMd5)) {
                            z10 = true;
                        }
                        if (!z10) {
                            setStatus((byte) 4);
                            return false;
                        }
                    }
                    z10 = false;
                    if (!z10) {
                        setStatus((byte) 4);
                        return false;
                    }
                }
            }
            org.json.JSONObject jSONObject31 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject15, "ads");
            java.lang.String string19 = io.dcloud.common.util.JSONUtil.getString(jSONObject15, "adid");
            org.json.JSONObject jSONObject32 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject15, "wap2app");
            boolean z27 = z10;
            if (jSONObject32 != null) {
                strOptString7 = jSONObject32.optString("launchError", "tip");
            }
            java.lang.String str25 = strOptString7;
            android.content.Intent intent = this.O0;
            if (intent != null && intent.hasExtra(io.dcloud.common.constant.IntentConst.UNIMP_DIRECT_DATA)) {
                this.q1 = true;
                this.r1 = this.O0.getStringExtra(io.dcloud.common.constant.IntentConst.UNIMP_DIRECT_DATA);
                this.O0.removeExtra(io.dcloud.common.constant.IntentConst.UNIMP_DIRECT_DATA);
            }
            this.u1 = io.dcloud.common.constant.IntentConst.obtainIntentStringExtra(this.O0, io.dcloud.common.constant.IntentConst.UNIMP_RUN_EXTRA_INFO, true);
            if (jSONObject15.has("arguments")) {
                setRuntimeArgs(io.dcloud.common.util.JSONUtil.getString(jSONObject15, "arguments"));
            } else {
                android.content.Intent intent2 = this.O0;
                if (intent2 != null && intent2.hasExtra(io.dcloud.common.constant.IntentConst.UNIMP_RUN_ARGUMENTS)) {
                    setRuntimeArgs(this.O0.getStringExtra(io.dcloud.common.constant.IntentConst.UNIMP_RUN_ARGUMENTS));
                }
            }
            boolean z28 = io.dcloud.common.util.PdrUtil.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObject11, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_FULLSCREEN), this.i, false);
            io.dcloud.common.adapter.util.Logger.i(H1, this.o + " app fullScreen=" + z28);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            boolean zQ = q();
            org.json.JSONObject jSONObject33 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject11, "permissions");
            if (jSONObject33 == null || (jSONArrayNames = jSONObject33.names()) == null) {
                z11 = z7;
                z12 = z27;
            } else {
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                boolean z29 = z27;
                int i10 = 0;
                while (i10 < jSONArrayNames.length()) {
                    int i11 = i10;
                    java.lang.String lowerCase = io.dcloud.common.util.JSONUtil.getString(jSONArrayNames, i10).toLowerCase(java.util.Locale.ENGLISH);
                    arrayList.add(lowerCase);
                    if (lowerCase.equals("push")) {
                        jSONArray = jSONArrayNames;
                        z13 = z7;
                        io.dcloud.common.adapter.util.PlatformUtil.APS_COVER = io.dcloud.common.util.PdrUtil.parseBoolean(io.dcloud.common.util.JSONUtil.getString(io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject33, lowerCase), io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_COVER), io.dcloud.common.adapter.util.PlatformUtil.APS_COVER, false);
                    } else {
                        z13 = z7;
                        jSONArray = jSONArrayNames;
                        if (lowerCase.equals("webview")) {
                            arrayList.add(io.dcloud.common.constant.AbsoluteConst.F_UI);
                        } else if (lowerCase.equals(io.dcloud.common.constant.AbsoluteConst.F_UI)) {
                            arrayList.add("webview");
                            arrayList.add("nativeui");
                            arrayList.add("navigator");
                        } else if (lowerCase.equals("maps") && (jSONObject7 = io.dcloud.common.util.JSONUtil.getJSONObject(jSONObject33, io.dcloud.common.DHInterface.IFeature.F_MAPS)) != null && jSONObject7.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_MAP_COORD_TYPE)) {
                            this.p1 = io.dcloud.common.util.JSONUtil.getString(jSONObject7, io.dcloud.common.constant.AbsoluteConst.JSONKEY_MAP_COORD_TYPE);
                        }
                    }
                    if (z19 && !z20 && !zQ && !io.dcloud.common.core.permission.PermissionControler.checkSafePermission(str14, lowerCase)) {
                        java.util.ArrayList arrayList2 = this.B0;
                        if (arrayList2 != null && arrayList2.size() > 0) {
                            if (!this.B0.contains(lowerCase)) {
                                if (stringBuffer.length() > 0) {
                                    stringBuffer.append(",");
                                }
                                stringBuffer.append(lowerCase);
                                z29 = false;
                            }
                        } else if (!((java.lang.Boolean) this.y.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 9, lowerCase)).booleanValue()) {
                            if (stringBuffer.length() > 0) {
                                stringBuffer.append(",");
                            }
                            stringBuffer.append(lowerCase);
                            z29 = false;
                        }
                    }
                    i10 = i11 + 1;
                    jSONArrayNames = jSONArray;
                    z7 = z13;
                }
                z11 = z7;
                if (!z29 && z19 != 0) {
                    f5Var.b = io.dcloud.common.constant.DOMException.toJSON(io.dcloud.common.constant.DOMException.CODE_RUNTIME_5PRUNTIME_LACK_MODULE, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.MSG_RUNTIME_5PRUNTIME_LACK_MODULE, stringBuffer));
                    f5Var.a = true;
                    return false;
                }
                z12 = z29;
            }
            if (z12) {
                io.dcloud.common.util.BaseInfo.BaseAppInfo baseAppInfo = this.t;
                if (baseAppInfo != null) {
                    baseAppInfo.mAppVer = this.A;
                }
                this.A = str5;
                this.B = string4;
                this.B0 = arrayList;
                this.o = str14;
                this.z = str4;
                this.t0 = string6;
                this.M = z23;
                this.N = z24;
                this.F = str2;
                this.G = string8;
                this.H = string9;
                this.J = string10;
                this.l0 = str3;
                this.n0 = string12;
                this.s0 = string13;
                this.L = str22;
                this.q0 = string2;
                this.W = z6;
                this.Y = z8;
                this.Z = z11;
                this.j0 = z4;
                this.X = z9;
                this.Q = z5;
                this.i = z28;
                this.U = z22;
                java.lang.String str26 = str15;
                this.p0 = str26;
                io.dcloud.common.util.BaseInfo.untrustedca = str26;
                this.b0 = i9;
                this.c0 = i8;
                this.d0 = str23;
                this.e0 = str13;
                this.D0 = jSONObject6;
                this.F0 = jSONObject3;
                this.i1 = z3;
                this.G0 = jSONObject5;
                this.H0 = jSONObject19;
                this.J0 = jSONObject4;
                this.I0 = jSONObject30;
                this.L0 = jSONObject31;
                this.N0 = string19;
                this.f0 = str9;
                this.g0 = str10;
                this.h0 = str8;
                this.i0 = str21;
                this.Y0 = str12;
                this.Z0 = str11;
                this.M0 = str25;
                this.E0 = jSONObject17;
                l();
                f5Var.b = v();
            }
            f5Var.a = !z12;
            return z12;
        } catch (java.lang.Exception e4) {
            e4.printStackTrace();
            f5Var.a = true;
            if (f5Var.c) {
                f5Var.b = io.dcloud.common.constant.DOMException.toJSON(io.dcloud.common.constant.DOMException.CODE_RUNTIME_WGTU_WWW_MANIFEST_ERROR_MALFORMED, io.dcloud.common.constant.DOMException.MSG_RUNTIME_WGTU_WWW_MANIFEST_ERROR_MALFORMED);
                return false;
            }
            f5Var.b = io.dcloud.common.constant.DOMException.toJSON(io.dcloud.common.constant.DOMException.CODE_RUNTIME_WGT_MANIFEST_ERROR_MALFORMED, io.dcloud.common.constant.DOMException.MSG_RUNTIME_WGT_MANIFEST_ERROR_MALFORMED);
            return false;
        }
    }

    public void g() {
        java.util.ArrayList arrayList = this.B0;
        if (arrayList != null) {
            arrayList.clear();
            this.B0 = null;
        }
        java.util.HashMap map = this.C0;
        if (map != null) {
            map.clear();
            this.C0 = null;
        }
        this.t1.removeData(this.o);
        this.y = null;
        this.t = null;
        this.g1 = false;
    }

    private static android.content.pm.PackageInfo c(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    boolean c(java.lang.String str, org.json.JSONObject jSONObject) {
        java.lang.String str2;
        java.lang.String strObtainAppDataPath = obtainAppDataPath();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean zB = false;
        sb.append(strObtainAppDataPath.substring(0, strObtainAppDataPath.length() - 1));
        sb.append("_backup");
        java.lang.String string = sb.toString();
        byte b2 = this.V;
        try {
            if (b2 == 1) {
                str2 = io.dcloud.common.util.BaseInfo.sCacheFsAppsPath + this.o + java.io.File.separatorChar + io.dcloud.common.util.BaseInfo.APP_WWW_FS_DIR;
                try {
                    io.dcloud.common.adapter.io.DHFile.deleteFile(str2);
                    string = str2.substring(0, str2.length() - 1) + "_backup";
                } catch (java.lang.Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    io.dcloud.p.f5 f5Var = this.s;
                    f5Var.a = true;
                    f5Var.b = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 10, e.getMessage());
                }
            } else {
                if (b2 == 0) {
                    new java.io.File(strObtainAppDataPath).renameTo(new java.io.File(string));
                }
                str2 = strObtainAppDataPath;
            }
            java.io.File file = new java.io.File(str);
            if (io.dcloud.common.util.Zip4JUtil.isEncryptedZip(file)) {
                io.dcloud.common.util.Zip4JUtil.upZipFileWithPassword(file, str2, jSONObject.getString(com.taobao.weex.common.Constants.Value.PASSWORD));
            } else {
                io.dcloud.common.util.ZipUtils.upZipFile(file, str2);
            }
            b((byte) 0);
            setAppDataPath(str2);
            zB = b(this.o, jSONObject);
        } catch (java.lang.Exception e3) {
            e = e3;
            str2 = strObtainAppDataPath;
        }
        if (!zB) {
            io.dcloud.common.adapter.util.Logger.e(io.dcloud.common.adapter.util.Logger.AppMgr_TAG, "unZipWebApp failed pFilePath=" + str);
            b(b2);
            setAppDataPath(strObtainAppDataPath);
            try {
                io.dcloud.common.adapter.io.DHFile.deleteFile(str2);
            } catch (java.io.IOException e4) {
                e4.printStackTrace();
            }
            if (b2 == 0) {
                new java.io.File(string).renameTo(new java.io.File(str2));
            }
        } else {
            if (b2 == 0) {
                try {
                    io.dcloud.common.adapter.io.DHFile.deleteFile(string);
                } catch (java.io.IOException e5) {
                    e5.printStackTrace();
                }
            }
            io.dcloud.common.util.BaseInfo.BaseAppInfo baseAppInfo = new io.dcloud.common.util.BaseInfo.BaseAppInfo(this.o, this.A);
            this.t = baseAppInfo;
            baseAppInfo.saveToBundleData(getActivity());
        }
        return zB;
    }

    boolean f(java.lang.String str) {
        if (!this.v && this.x) {
            return false;
        }
        io.dcloud.common.adapter.util.Logger.e("Webapp start " + this.o);
        android.app.Activity activity = this.a;
        if (activity != null && (activity instanceof io.dcloud.WebAppActivity)) {
            ((io.dcloud.WebAppActivity) activity).onAppStart(this.o);
            ((io.dcloud.WebAppActivity) this.a).onAppStart(this);
        }
        io.dcloud.common.util.BaseInfo.s_Runing_App_Count++;
        this.w = true;
        this.x = !this.v;
        setRuntimeArgs(str);
        return b(5);
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.io.InputStream obtainResInStream(java.lang.String str) {
        return obtainResInStream(null, str);
    }

    private java.lang.String c(java.lang.String str) {
        return io.dcloud.common.util.BaseInfo.sBaseFsSitMapPath + str + "/_sitemap.json";
    }

    @Override // io.dcloud.common.DHInterface.IApp
    public java.lang.String convert2AbsFullPath(java.lang.String str) {
        return convert2AbsFullPath(null, str);
    }

    void b(byte b2) {
        this.V = b2;
    }

    private static java.lang.String b(java.lang.String str) {
        return (str == null || str.length() <= 0 || str.charAt(0) != '/') ? str : b(str.substring(1));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private boolean b(int i) {
        io.dcloud.common.adapter.util.PermissionUtil.sUseStreamAppPermissionDialogCount = 0;
        io.dcloud.common.adapter.ui.webview.WebViewFactory.sUsePermissionWebviews.clear();
        io.dcloud.common.adapter.util.PermissionUtil.removeTempPermission(this.a, this.o);
        io.dcloud.common.adapter.util.Logger.e(H1, "start0 mAppid===" + this.o);
        io.dcloud.common.util.BaseInfo.sCurrentAppOriginalAppid = this.z;
        io.dcloud.common.util.BaseInfo.putStartupTimeData(this.o, java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        io.dcloud.common.util.BaseInfo.sProcessId = android.os.Process.myPid();
        java.lang.String str = H1;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.o);
        sb.append(this.V == 1 ? " APP_RUNNING_MODE" : " FS_RUNNING_MODE");
        io.dcloud.common.adapter.util.Logger.i(str, sb.toString());
        t();
        setStatus((byte) 3);
        io.dcloud.common.DHInterface.IApp.IAppStatusListener iAppStatusListener = this.P0;
        if (iAppStatusListener != null) {
            iAppStatusListener.onStart();
        }
        io.dcloud.common.adapter.util.Logger.i(H1, "mLaunchPath=" + this.l0);
        io.dcloud.common.adapter.util.Logger.i("download_manager", "webapp start task begin success appid=" + this.o + " mLaunchPath=" + this.l0);
        java.lang.String str2 = io.dcloud.common.util.TestUtil.START_STREAM_APP;
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("webapp start appid=");
        sb2.append(this.o);
        io.dcloud.common.util.TestUtil.print(str2, sb2.toString());
        io.dcloud.common.util.BaseInfo.setLoadingLaunchePage(true, "start0");
        java.lang.String stringExtra = getActivity().getIntent().getStringExtra(io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_LAUNCH_PATH);
        if (stringExtra != null && !"".equals(stringExtra.trim())) {
            getActivity().getIntent().removeExtra(io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_LAUNCH_PATH);
            if (!"about:blank".equals(stringExtra)) {
                stringExtra = convert2WebviewFullPath(null, stringExtra);
            }
            this.o0 = true;
        } else if (io.dcloud.common.util.BaseInfo.isWap2AppAppid(this.o) && !android.text.TextUtils.isEmpty(this.n0)) {
            stringExtra = convert2WebviewFullPath(null, this.n0);
        } else {
            stringExtra = convert2WebviewFullPath(null, this.l0);
        }
        if (a((io.dcloud.common.DHInterface.IApp) this) && !new java.io.File(a(io.dcloud.common.util.BaseInfo.sConfigXML)).exists()) {
            stringExtra = android.text.TextUtils.isEmpty(this.m0) ? this.o1 : this.m0;
        }
        android.net.Uri data = getActivity().getIntent().getData();
        if (data != null && data.toString().endsWith(".html")) {
            stringExtra = data.toString();
        }
        if (this.q1) {
            stringExtra = convert2WebviewFullPath(null, "__uniappview.html");
        }
        java.lang.Object objProcessEvent = this.y.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, i, new java.lang.Object[]{this, stringExtra, java.lang.Boolean.valueOf(this.T0), this.W0});
        if (objProcessEvent == null) {
            return true;
        }
        return java.lang.Boolean.parseBoolean(java.lang.String.valueOf(objProcessEvent));
    }

    void b(boolean z) {
        this.b.onAppUnActive(this);
        if (z) {
            callSysEventListener(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppPause, this);
            callSysEventListener(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppBackground, this);
        }
        io.dcloud.common.DHInterface.IApp.IAppStatusListener iAppStatusListener = this.P0;
        if (iAppStatusListener != null) {
            iAppStatusListener.onPause(this, null);
        }
        setStatus((byte) 2);
    }

    private void b() {
        if (q() || !io.dcloud.p.t.c(getActivity())) {
            return;
        }
        io.dcloud.common.util.ThreadPool.self().addThreadTask(new io.dcloud.p.d5.d(obtainAppId()));
    }

    public static java.lang.String b(android.content.Context context) {
        return c(context).versionName;
    }

    private org.json.JSONObject a(java.io.InputStream inputStream) {
        try {
            if (!this.q) {
                inputStream = new io.dcloud.common.adapter.io.UnicodeInputStream(inputStream, java.nio.charset.Charset.defaultCharset().name());
            }
            return new org.json.JSONObject(new java.lang.String(io.dcloud.common.util.IOUtil.getBytes(inputStream)));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // io.dcloud.p.e5
    void a(android.app.Activity activity) {
        super.a(activity);
        io.dcloud.common.util.AppStatusBarManager appStatusBarManager = this.m;
        if (appStatusBarManager != null) {
            appStatusBarManager.checkImmersedStatusBar(activity, this.b1);
            this.m.isFullScreen = isFullScreen();
        }
        this.l.mJsonViewOption = io.dcloud.common.util.JSONUtil.createJSONObject("{}");
        this.f = io.dcloud.common.util.PdrUtil.parseInt(io.dcloud.common.adapter.util.SP.getBundleData(getActivity(), io.dcloud.common.util.BaseInfo.PDR, "StatusBarHeight"), 0);
        updateScreenInfo(4);
        this.y1 = false;
        io.dcloud.common.DHInterface.IActivityHandler iActivityHandler = io.src.dcloud.adapter.DCloudAdapterUtil.getIActivityHandler(getActivity());
        if (!q() && iActivityHandler != null) {
            java.util.HashMap map = new java.util.HashMap();
            map.put(io.dcloud.common.util.CreateShortResultReceiver.KEY_VERSIONNAME, this.A);
            map.put("appid", this.o);
            map.put("name", this.t0);
            map.put("adid", this.N0);
            map.put("bg", this.Y0);
            map.put(com.taobao.weex.ui.component.WXBasicComponentType.IMG, convert2AbsFullPath(this.Z0));
            io.dcloud.p.l.a(getActivity(), this.o, "save", map);
        }
        android.content.Intent intent = activity.getIntent();
        if (intent != null) {
            android.os.Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey(io.dcloud.common.constant.IntentConst.FROM_SHORT_CUT_STRAT) && extras.getBoolean(io.dcloud.common.constant.IntentConst.FROM_SHORT_CUT_STRAT)) {
                this.y1 = true;
            }
            if (extras != null && extras.containsKey(io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_CREATE_SHORTCUT)) {
                this.A1 = extras.getString(io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_CREATE_SHORTCUT);
            }
            if (extras != null && extras.containsKey("shortcutQuit")) {
                this.z1 = extras.getString("shortcutQuit");
            }
            if (extras != null && extras.containsKey(io.dcloud.common.constant.IntentConst.START_FORCE_SHORT_QUIT)) {
                this.z1 = extras.getString(io.dcloud.common.constant.IntentConst.START_FORCE_SHORT_QUIT);
            }
            if (intent.hasExtra(io.dcloud.common.constant.IntentConst.START_FORCE_SHORT)) {
                this.A1 = intent.getStringExtra(io.dcloud.common.constant.IntentConst.START_FORCE_SHORT);
            }
            if (android.text.TextUtils.isEmpty(this.A1)) {
                java.lang.String launchType = io.dcloud.common.util.BaseInfo.getLaunchType(intent);
                this.A1 = io.dcloud.common.constant.AbsoluteConst.INSTALL_OPTIONS_FORCE;
                if (launchType.equals("scheme")) {
                    this.A1 = "query";
                    return;
                }
                if (this.P) {
                    this.A1 = io.dcloud.common.constant.AbsoluteConst.INSTALL_OPTIONS_FORCE;
                    return;
                }
                java.lang.String string = io.dcloud.common.adapter.util.SP.getOrCreateBundle(activity, "pdr").getString(io.dcloud.common.constant.AbsoluteConst.TEST_RUN + this.o, null);
                if (!android.text.TextUtils.isEmpty(string) && string.equals("__am=t")) {
                    this.A1 = io.dcloud.common.constant.AbsoluteConst.INSTALL_OPTIONS_FORCE;
                } else {
                    this.A1 = "none";
                }
            }
        }
    }

    java.lang.String a(java.lang.String str) {
        return this.k0 + str;
    }

    void a(io.dcloud.common.DHInterface.ICallBack iCallBack) {
        if ((io.dcloud.common.util.BaseInfo.ISDEBUG || this.j0) && this.V == 1) {
            io.dcloud.common.util.ThreadPool.self().addThreadTask(new io.dcloud.p.d5.c(iCallBack), true);
        } else {
            iCallBack.onCallBack(0, null);
        }
    }

    private boolean a(io.dcloud.common.DHInterface.IApp iApp) {
        return (android.text.TextUtils.isEmpty(iApp.getOriginalDirectPage()) || iApp.obtainWebAppIntent().hasExtra(io.dcloud.common.constant.IntentConst.DIRECT_PAGE)) ? false : true;
    }

    boolean a(boolean z) {
        if (z) {
            this.r1 = null;
            this.y.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 76, this);
        }
        setAppDataPath(io.dcloud.common.util.BaseInfo.sCacheFsAppsPath + this.o + io.dcloud.common.adapter.util.DeviceInfo.sSeparatorChar + io.dcloud.common.util.BaseInfo.REAL_PRIVATE_WWW_DIR);
        boolean zB = b(this.o, null);
        if (!zB) {
            return zB;
        }
        setConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_funSetUA, java.lang.String.valueOf(false));
        io.dcloud.common.adapter.util.PermissionUtil.clearUseRejectedCache();
        showSplash();
        this.y.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 3, this.o);
        callSysEventListener(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppReStart, null);
        this.g1 = false;
        io.dcloud.common.util.TestUtil.record(io.dcloud.common.constant.AbsoluteConst.RUN_5AP_TIME_KEY);
        return b(10);
    }

    private void a() {
        io.dcloud.common.DHInterface.IPdrModule iPdrModuleA;
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() && !io.dcloud.common.util.PdrUtil.isUniMPHostForUniApp()) {
            io.dcloud.p.j.a(this.a, this.N0);
        }
        if (this.q) {
            return;
        }
        if (!io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            io.dcloud.p.b.o().a(this.a);
        }
        if (q() || (iPdrModuleA = io.dcloud.p.r3.a().a("commit")) == null) {
            return;
        }
        java.lang.String str = this.N0;
        org.json.JSONObject jSONObject = this.y.g;
        iPdrModuleA.execute("start_up", new java.lang.Object[]{this, str, jSONObject != null ? jSONObject.optString("version") : "0.1"});
    }

    public static int a(android.content.Context context) {
        return c(context).versionCode;
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
    io.dcloud.common.DHInterface.IFrameView a(io.dcloud.common.DHInterface.IWebviewStateListener iWebviewStateListener) {
        t();
        return (io.dcloud.common.DHInterface.IFrameView) this.y.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 17, new java.lang.Object[]{this, convert2WebviewFullPath(null, this.l0), iWebviewStateListener});
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
    io.dcloud.common.DHInterface.IFrameView a(io.dcloud.common.DHInterface.IWebviewStateListener iWebviewStateListener, io.dcloud.common.DHInterface.IDCloudWebviewClientListener iDCloudWebviewClientListener) {
        t();
        return (io.dcloud.common.DHInterface.IFrameView) this.y.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 17, new java.lang.Object[]{this, convert2WebviewFullPath(null, this.l0), iWebviewStateListener, iDCloudWebviewClientListener});
    }

    private boolean a(io.dcloud.common.DHInterface.ISysEventListener iSysEventListener, io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType) {
        return !(iSysEventListener instanceof io.dcloud.common.DHInterface.IBoot) || io.dcloud.common.util.PdrUtil.parseBoolean(java.lang.String.valueOf(this.y.processEvent(null, 1, iSysEventListener)), false, false) || !(sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onStart || sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onStop || sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onPause || sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onResume) || (iSysEventListener instanceof io.dcloud.common.DHInterface.ReceiveSystemEventVoucher);
    }

    public static boolean a(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType) {
        return (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyDown || sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp || sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyLongPress) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0239 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x01d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x01df A[Catch: Exception -> 0x0289, TryCatch #1 {Exception -> 0x0289, blocks: (B:60:0x01d8, B:62:0x01df, B:66:0x01ed, B:68:0x01f5, B:70:0x01fb, B:72:0x0202, B:73:0x0223, B:75:0x0229, B:77:0x0239, B:79:0x023e, B:80:0x0255, B:82:0x025c, B:83:0x025f, B:85:0x0279, B:64:0x01e7), top: B:107:0x01d8, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01e5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x01e7 A[Catch: Exception -> 0x0289, TryCatch #1 {Exception -> 0x0289, blocks: (B:60:0x01d8, B:62:0x01df, B:66:0x01ed, B:68:0x01f5, B:70:0x01fb, B:72:0x0202, B:73:0x0223, B:75:0x0229, B:77:0x0239, B:79:0x023e, B:80:0x0255, B:82:0x025c, B:83:0x025f, B:85:0x0279, B:64:0x01e7), top: B:107:0x01d8, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x01f5 A[Catch: Exception -> 0x0289, TryCatch #1 {Exception -> 0x0289, blocks: (B:60:0x01d8, B:62:0x01df, B:66:0x01ed, B:68:0x01f5, B:70:0x01fb, B:72:0x0202, B:73:0x0223, B:75:0x0229, B:77:0x0239, B:79:0x023e, B:80:0x0255, B:82:0x025c, B:83:0x025f, B:85:0x0279, B:64:0x01e7), top: B:107:0x01d8, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0202 A[Catch: Exception -> 0x0289, LOOP:0: B:71:0x0200->B:72:0x0202, LOOP_END, TryCatch #1 {Exception -> 0x0289, blocks: (B:60:0x01d8, B:62:0x01df, B:66:0x01ed, B:68:0x01f5, B:70:0x01fb, B:72:0x0202, B:73:0x0223, B:75:0x0229, B:77:0x0239, B:79:0x023e, B:80:0x0255, B:82:0x025c, B:83:0x025f, B:85:0x0279, B:64:0x01e7), top: B:107:0x01d8, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0229 A[Catch: Exception -> 0x0289, TRY_LEAVE, TryCatch #1 {Exception -> 0x0289, blocks: (B:60:0x01d8, B:62:0x01df, B:66:0x01ed, B:68:0x01f5, B:70:0x01fb, B:72:0x0202, B:73:0x0223, B:75:0x0229, B:77:0x0239, B:79:0x023e, B:80:0x0255, B:82:0x025c, B:83:0x025f, B:85:0x0279, B:64:0x01e7), top: B:107:0x01d8, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x023e A[Catch: IOException -> 0x0278, Exception -> 0x0289, TryCatch #0 {IOException -> 0x0278, blocks: (B:77:0x0239, B:79:0x023e, B:80:0x0255, B:82:0x025c), top: B:105:0x0239, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x025c A[Catch: IOException -> 0x0278, Exception -> 0x0289, TRY_LEAVE, TryCatch #0 {IOException -> 0x0278, blocks: (B:77:0x0239, B:79:0x023e, B:80:0x0255, B:82:0x025c), top: B:105:0x0239, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x02a6  */
    /* JADX WARN: Instruction removed from duplicated block: B:72:0x0202, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v27, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v6 */
    boolean a(java.lang.String str, org.json.JSONObject jSONObject) {
        java.lang.String str2;
        boolean zA;
        byte b2;
        boolean z;
        java.util.ArrayList<io.dcloud.common.util.XmlUtil.DHNode> elements;
        int size;
        int i;
        io.dcloud.common.util.XmlUtil.DHNode element;
        io.dcloud.p.f5 f5Var = this.s;
        f5Var.c = true;
        f5Var.d = true;
        java.lang.String str3 = io.dcloud.common.util.BaseInfo.sCacheFsAppsPath + this.o + io.dcloud.common.adapter.util.DeviceInfo.sSeparatorChar + io.dcloud.common.util.BaseInfo.APP_WWW_FS_DIR;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str3.substring(0, str3.length() - 1));
        sb.append("_unzip");
        char c2 = java.io.File.separatorChar;
        sb.append(c2);
        java.lang.String string = sb.toString();
        java.lang.String str4 = str3.substring(0, str3.length() - 1) + "_backup" + c2;
        java.lang.String str5 = str3.substring(0, str3.length() - 1) + "_backup1" + c2;
        ?? file = new java.io.File(str);
        ?? r8 = 0;
        java.lang.String str6 = null;
        io.dcloud.common.util.XmlUtil.DHNode dHNode = null;
        try {
            try {
                try {
                    try {
                        try {
                            io.dcloud.common.adapter.io.DHFile.delete(string);
                            io.dcloud.common.util.ZipUtils.upZipFile(file, string);
                            try {
                                file = io.dcloud.common.adapter.io.DHFile.getInputStream(io.dcloud.common.adapter.io.DHFile.createFileHandler(string + io.dcloud.common.util.BaseInfo.WGTU_UPDATE_XML));
                                try {
                                    if (file == 0) {
                                        this.s.b = io.dcloud.common.constant.DOMException.toJSON(io.dcloud.common.constant.DOMException.CODE_RUNTIME_WGTU_UPDATE_NOT_EXIST, io.dcloud.common.constant.DOMException.MSG_RUNTIME_WGTU_UPDATE_NOT_EXIST);
                                        this.s.a = true;
                                        io.dcloud.common.util.IOUtil.close((java.io.InputStream) file);
                                        return false;
                                    }
                                    io.dcloud.common.util.XmlUtil.DHNode dHNodeXML_Parser = io.dcloud.common.util.XmlUtil.XML_Parser(file);
                                    if (dHNodeXML_Parser != null) {
                                        java.lang.String attributeValue = io.dcloud.common.util.XmlUtil.getAttributeValue(dHNodeXML_Parser, "appid");
                                        java.lang.String attributeValue2 = io.dcloud.common.util.XmlUtil.getAttributeValue(io.dcloud.common.util.XmlUtil.getElement(dHNodeXML_Parser, io.dcloud.common.constant.AbsoluteConst.XML_BASIS), "version");
                                        if (!io.dcloud.common.util.BaseInfo.ISDEBUG && !this.o.equalsIgnoreCase(attributeValue)) {
                                            this.s.b = io.dcloud.common.constant.DOMException.toJSON(io.dcloud.common.constant.DOMException.CODE_RUNTIME_WGTU_UPDATE_APPID_NOT_MATCH, io.dcloud.common.constant.DOMException.MSG_RUNTIME_WGTU_UPDATE_APPID_NOT_MATCH);
                                        } else {
                                            if (!this.A.equals(attributeValue2) && !jSONObject.optBoolean(io.dcloud.common.constant.AbsoluteConst.INSTALL_OPTIONS_FORCE)) {
                                                this.s.b = io.dcloud.common.constant.DOMException.toJSON(io.dcloud.common.constant.DOMException.CODE_RUNTIME_WGTU_UPDATE_VERSION_NOT_MATCH, io.dcloud.common.constant.DOMException.MSG_RUNTIME_WGTU_UPDATE_VERSION_NOT_MATCH);
                                            } else {
                                                str2 = string + io.dcloud.common.util.BaseInfo.APP_WWW_FS_DIR;
                                                try {
                                                    java.lang.String str7 = str2 + io.dcloud.common.util.BaseInfo.sConfigXML;
                                                    if (io.dcloud.common.adapter.io.DHFile.isExist(str7)) {
                                                        java.io.InputStream inputStream = io.dcloud.common.adapter.io.DHFile.getInputStream(io.dcloud.common.adapter.io.DHFile.createFileHandler(str7));
                                                        zA = a(inputStream, this.o, jSONObject);
                                                        io.dcloud.common.util.IOUtil.close(inputStream);
                                                        element = io.dcloud.common.util.XmlUtil.getElement(dHNodeXML_Parser, io.dcloud.common.constant.AbsoluteConst.XML_REMOVE);
                                                        str6 = str2;
                                                    } else {
                                                        this.s.b = io.dcloud.common.constant.DOMException.toJSON(io.dcloud.common.constant.DOMException.CODE_RUNTIME_WGTU_WWW_MANIFEST_NOT_EXIST, io.dcloud.common.constant.DOMException.MSG_RUNTIME_WGTU_WWW_MANIFEST_NOT_EXIST);
                                                        this.s.a = true;
                                                        io.dcloud.common.util.IOUtil.close((java.io.InputStream) file);
                                                        return false;
                                                    }
                                                } catch (java.io.IOException e2) {
                                                    e = e2;
                                                    e.printStackTrace();
                                                    this.s.b = io.dcloud.common.constant.DOMException.toJSON(-5, io.dcloud.common.constant.DOMException.MSG_IO_ERROR);
                                                    io.dcloud.common.util.IOUtil.close((java.io.InputStream) file);
                                                    zA = false;
                                                }
                                            }
                                            io.dcloud.common.util.IOUtil.close((java.io.InputStream) file);
                                            str2 = str6;
                                            dHNode = element;
                                            if (zA) {
                                                try {
                                                    io.dcloud.common.adapter.io.DHFile.deleteFile(str4);
                                                    b2 = this.V;
                                                    if (b2 == 1) {
                                                        io.dcloud.common.adapter.io.DHFile.copyDir(this.k0, str4);
                                                    } else {
                                                        if (b2 == 0) {
                                                            io.dcloud.common.adapter.io.DHFile.copyFile(str3, str4, true, false);
                                                            z = true;
                                                        }
                                                        elements = io.dcloud.common.util.XmlUtil.getElements(dHNode, io.dcloud.common.constant.AbsoluteConst.XML_ITEM);
                                                        if (elements != null && !elements.isEmpty()) {
                                                            size = elements.size();
                                                            for (i = 0; i < size; i++) {
                                                                io.dcloud.common.adapter.io.DHFile.deleteFile(str4 + io.dcloud.common.util.XmlUtil.getAttributeValue(elements.get(i), io.dcloud.common.constant.AbsoluteConst.XML_PATH));
                                                            }
                                                        }
                                                        if (1 != io.dcloud.common.adapter.io.DHFile.copyFile(str2, str4, true, false)) {
                                                            io.dcloud.common.adapter.io.DHFile.deleteFile(str4);
                                                            this.s.b = io.dcloud.common.constant.DOMException.toJSON(-5, io.dcloud.common.constant.DOMException.MSG_IO_ERROR);
                                                            this.s.a = true;
                                                            return false;
                                                        }
                                                        try {
                                                            io.dcloud.common.adapter.io.DHFile.deleteFile(string);
                                                            if (z) {
                                                                io.dcloud.common.adapter.io.DHFile.rename(str3, str5.substring(str5.substring(0, str5.length() - 1).lastIndexOf(47) + 1));
                                                            }
                                                            io.dcloud.common.adapter.io.DHFile.rename(str4, io.dcloud.common.util.BaseInfo.APP_WWW_FS_DIR);
                                                            if (z) {
                                                                io.dcloud.common.adapter.io.DHFile.deleteFile(str5);
                                                            }
                                                            b((byte) 0);
                                                            setAppDataPath(str3);
                                                            io.dcloud.common.util.BaseInfo.BaseAppInfo baseAppInfo = new io.dcloud.common.util.BaseInfo.BaseAppInfo(this.o, this.A);
                                                            this.t = baseAppInfo;
                                                            baseAppInfo.saveToBundleData(getActivity());
                                                        } catch (java.io.IOException e3) {
                                                            e3.printStackTrace();
                                                            this.s.b = io.dcloud.common.constant.DOMException.toJSON(-5, io.dcloud.common.constant.DOMException.MSG_IO_ERROR);
                                                            this.s.a = true;
                                                            return false;
                                                        }
                                                    }
                                                    z = false;
                                                    elements = io.dcloud.common.util.XmlUtil.getElements(dHNode, io.dcloud.common.constant.AbsoluteConst.XML_ITEM);
                                                    if (elements != null) {
                                                        size = elements.size();
                                                        while (i < size) {
                                                            io.dcloud.common.adapter.io.DHFile.deleteFile(str4 + io.dcloud.common.util.XmlUtil.getAttributeValue(elements.get(i), io.dcloud.common.constant.AbsoluteConst.XML_PATH));
                                                        }
                                                    }
                                                    if (1 != io.dcloud.common.adapter.io.DHFile.copyFile(str2, str4, true, false)) {
                                                        io.dcloud.common.adapter.io.DHFile.deleteFile(str4);
                                                        this.s.b = io.dcloud.common.constant.DOMException.toJSON(-5, io.dcloud.common.constant.DOMException.MSG_IO_ERROR);
                                                        this.s.a = true;
                                                        return false;
                                                    }
                                                    io.dcloud.common.adapter.io.DHFile.deleteFile(string);
                                                    if (z) {
                                                        io.dcloud.common.adapter.io.DHFile.rename(str3, str5.substring(str5.substring(0, str5.length() - 1).lastIndexOf(47) + 1));
                                                    }
                                                    io.dcloud.common.adapter.io.DHFile.rename(str4, io.dcloud.common.util.BaseInfo.APP_WWW_FS_DIR);
                                                    if (z) {
                                                        io.dcloud.common.adapter.io.DHFile.deleteFile(str5);
                                                    }
                                                    b((byte) 0);
                                                    setAppDataPath(str3);
                                                    io.dcloud.common.util.BaseInfo.BaseAppInfo baseAppInfo2 = new io.dcloud.common.util.BaseInfo.BaseAppInfo(this.o, this.A);
                                                    this.t = baseAppInfo2;
                                                    baseAppInfo2.saveToBundleData(getActivity());
                                                } catch (java.lang.Exception e4) {
                                                    e4.printStackTrace();
                                                    try {
                                                        io.dcloud.common.adapter.io.DHFile.deleteFile(string);
                                                    } catch (java.io.IOException e5) {
                                                        e5.printStackTrace();
                                                    }
                                                    this.s.b = io.dcloud.common.constant.DOMException.toJSON(-99, io.dcloud.common.constant.DOMException.MSG_UNKNOWN_ERROR);
                                                    this.s.a = true;
                                                    return false;
                                                }
                                            } else {
                                                this.s.a = true;
                                                try {
                                                    io.dcloud.common.adapter.io.DHFile.deleteFile(string);
                                                } catch (java.io.IOException e6) {
                                                    e6.printStackTrace();
                                                }
                                            }
                                            return false;
                                        }
                                        element = null;
                                        zA = false;
                                        io.dcloud.common.util.IOUtil.close((java.io.InputStream) file);
                                        str2 = str6;
                                        dHNode = element;
                                        if (zA) {
                                            io.dcloud.common.adapter.io.DHFile.deleteFile(str4);
                                            b2 = this.V;
                                            if (b2 == 1) {
                                                io.dcloud.common.adapter.io.DHFile.copyDir(this.k0, str4);
                                            } else {
                                                if (b2 == 0) {
                                                    io.dcloud.common.adapter.io.DHFile.copyFile(str3, str4, true, false);
                                                    z = true;
                                                }
                                                elements = io.dcloud.common.util.XmlUtil.getElements(dHNode, io.dcloud.common.constant.AbsoluteConst.XML_ITEM);
                                                if (elements != null) {
                                                    size = elements.size();
                                                    while (i < size) {
                                                        io.dcloud.common.adapter.io.DHFile.deleteFile(str4 + io.dcloud.common.util.XmlUtil.getAttributeValue(elements.get(i), io.dcloud.common.constant.AbsoluteConst.XML_PATH));
                                                    }
                                                }
                                                if (1 != io.dcloud.common.adapter.io.DHFile.copyFile(str2, str4, true, false)) {
                                                    io.dcloud.common.adapter.io.DHFile.deleteFile(str4);
                                                    this.s.b = io.dcloud.common.constant.DOMException.toJSON(-5, io.dcloud.common.constant.DOMException.MSG_IO_ERROR);
                                                    this.s.a = true;
                                                    return false;
                                                }
                                                io.dcloud.common.adapter.io.DHFile.deleteFile(string);
                                                if (z) {
                                                    io.dcloud.common.adapter.io.DHFile.rename(str3, str5.substring(str5.substring(0, str5.length() - 1).lastIndexOf(47) + 1));
                                                }
                                                io.dcloud.common.adapter.io.DHFile.rename(str4, io.dcloud.common.util.BaseInfo.APP_WWW_FS_DIR);
                                                if (z) {
                                                    io.dcloud.common.adapter.io.DHFile.deleteFile(str5);
                                                }
                                                b((byte) 0);
                                                setAppDataPath(str3);
                                                io.dcloud.common.util.BaseInfo.BaseAppInfo baseAppInfo3 = new io.dcloud.common.util.BaseInfo.BaseAppInfo(this.o, this.A);
                                                this.t = baseAppInfo3;
                                                baseAppInfo3.saveToBundleData(getActivity());
                                            }
                                            z = false;
                                            elements = io.dcloud.common.util.XmlUtil.getElements(dHNode, io.dcloud.common.constant.AbsoluteConst.XML_ITEM);
                                            if (elements != null) {
                                                size = elements.size();
                                                while (i < size) {
                                                    io.dcloud.common.adapter.io.DHFile.deleteFile(str4 + io.dcloud.common.util.XmlUtil.getAttributeValue(elements.get(i), io.dcloud.common.constant.AbsoluteConst.XML_PATH));
                                                }
                                            }
                                            if (1 != io.dcloud.common.adapter.io.DHFile.copyFile(str2, str4, true, false)) {
                                                io.dcloud.common.adapter.io.DHFile.deleteFile(str4);
                                                this.s.b = io.dcloud.common.constant.DOMException.toJSON(-5, io.dcloud.common.constant.DOMException.MSG_IO_ERROR);
                                                this.s.a = true;
                                                return false;
                                            }
                                            io.dcloud.common.adapter.io.DHFile.deleteFile(string);
                                            if (z) {
                                                io.dcloud.common.adapter.io.DHFile.rename(str3, str5.substring(str5.substring(0, str5.length() - 1).lastIndexOf(47) + 1));
                                            }
                                            io.dcloud.common.adapter.io.DHFile.rename(str4, io.dcloud.common.util.BaseInfo.APP_WWW_FS_DIR);
                                            if (z) {
                                                io.dcloud.common.adapter.io.DHFile.deleteFile(str5);
                                            }
                                            b((byte) 0);
                                            setAppDataPath(str3);
                                            io.dcloud.common.util.BaseInfo.BaseAppInfo baseAppInfo4 = new io.dcloud.common.util.BaseInfo.BaseAppInfo(this.o, this.A);
                                            this.t = baseAppInfo4;
                                            baseAppInfo4.saveToBundleData(getActivity());
                                        } else {
                                            this.s.a = true;
                                            io.dcloud.common.adapter.io.DHFile.deleteFile(string);
                                        }
                                        return false;
                                    }
                                    throw new java.lang.Exception();
                                } catch (java.lang.Exception e7) {
                                    e = e7;
                                    e.printStackTrace();
                                    this.s.b = io.dcloud.common.constant.DOMException.toJSON(io.dcloud.common.constant.DOMException.CODE_RUNTIME_WGTU_UPDATE_ERROR_MALFORMED, io.dcloud.common.constant.DOMException.MSG_RUNTIME_WGTU_UPDATE_ERROR_MALFORMED);
                                    this.s.a = true;
                                    io.dcloud.common.util.IOUtil.close((java.io.InputStream) file);
                                    return false;
                                }
                            } catch (java.lang.Exception e8) {
                                e = e8;
                                file = 0;
                            }
                        } catch (java.io.IOException e9) {
                            e = e9;
                            str2 = null;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        r8 = file;
                        io.dcloud.common.util.IOUtil.close((java.io.InputStream) r8);
                        throw th;
                    }
                } catch (java.io.IOException e10) {
                    e = e10;
                    file = 0;
                    str2 = null;
                }
            } catch (java.io.FileNotFoundException unused) {
                io.dcloud.common.adapter.io.DHFile.delete(string);
                this.s.b = io.dcloud.common.constant.DOMException.toJSON(-4, io.dcloud.common.constant.DOMException.MSG_FILE_NOT_EXIST);
                this.s.a = true;
                io.dcloud.common.util.IOUtil.close((java.io.InputStream) null);
                return false;
            } catch (java.lang.Exception e11) {
                io.dcloud.common.adapter.util.Logger.w(e11);
                io.dcloud.common.adapter.io.DHFile.delete(string);
                this.s.b = io.dcloud.common.constant.DOMException.toJSON(io.dcloud.common.constant.DOMException.CODE_RUNTIME_WGT_OR_WGTU_ERROR_MALFORMED, io.dcloud.common.constant.DOMException.MSG_RUNTIME_WGT_OR_WGTU_ERROR_MALFORMED);
                this.s.a = true;
                io.dcloud.common.util.IOUtil.close((java.io.InputStream) null);
                return false;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private java.lang.String a(byte b2) {
        byte b3 = this.V;
        if (b3 != 1) {
            if (b3 != 0) {
                return null;
            }
            return io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + this.k0;
        }
        return io.dcloud.common.util.BaseInfo.sBaseResAppsFullPath + this.o + "/" + io.dcloud.common.util.BaseInfo.APP_WWW_FS_DIR;
    }

    public void a(java.lang.String str, int i) {
        this.E1.put(str, java.lang.Integer.valueOf(i));
        if (android.text.TextUtils.isEmpty(this.F1)) {
            this.F1 = str + "=" + i;
        } else {
            this.F1 += "&" + str + "=" + i;
        }
        io.dcloud.common.adapter.util.SP.getOrCreateBundle(getActivity(), this.o + "_1").edit().putString("Authorize", this.F1).commit();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    private boolean a(org.json.JSONObject jSONObject, io.dcloud.p.f5 f5Var) {
        boolean z;
        if (jSONObject == null || !jSONObject.has(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_UNIAPP_CONTROL)) {
            z = true;
        } else {
            java.lang.String strOptString = jSONObject.optString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_UNIAPP_CONTROL);
            if (android.text.TextUtils.isEmpty(strOptString) || !strOptString.equals(io.dcloud.common.constant.AbsoluteConst.UNI_V3)) {
                z = false;
            } else {
                z = true;
            }
        }
        if (!z) {
            f5Var.a = true;
            f5Var.b = io.dcloud.common.constant.DOMException.toJSON(io.dcloud.common.constant.DOMException.CODE_RUNTIME_COMPONENTS_MODE_NOT_SUPPORT, io.dcloud.common.constant.DOMException.MSG_RUNTIME_COMPONENTS_MODE_NOT_SUPPORT);
        }
        return z;
    }
}
