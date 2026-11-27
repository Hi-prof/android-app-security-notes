package io.dcloud.sdk.base.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ADHandler {
    private static java.util.LinkedList a;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class InstallReceiver extends android.content.BroadcastReceiver {
        io.dcloud.sdk.base.dcloud.ADHandler.e a;
        java.lang.String b;

        public InstallReceiver(io.dcloud.sdk.base.dcloud.ADHandler.e eVar, java.lang.String str) {
            this.a = eVar;
            this.b = str;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            if (this.b.equals(intent.getData().getSchemeSpecificPart())) {
                java.lang.String strOptString = this.a.b().optString("tid");
                java.lang.String strA = io.dcloud.sdk.base.dcloud.ADHandler.a(context, "adid");
                io.dcloud.sdk.base.dcloud.ADHandler.e eVar = this.a;
                io.dcloud.sdk.base.dcloud.ADHandler.b(31, context, strOptString, strA, eVar, eVar.h);
                context.unregisterReceiver(this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.sdk.base.dcloud.ADHandler.h a;

        a(io.dcloud.sdk.base.dcloud.ADHandler.h hVar) {
            this.a = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.execute();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.sdk.base.dcloud.ADHandler.e a;
        final /* synthetic */ android.content.Context b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;

        b(io.dcloud.sdk.base.dcloud.ADHandler.e eVar, android.content.Context context, java.lang.String str, java.lang.String str2) {
            this.a = eVar;
            this.b = context;
            this.c = str;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            org.json.JSONObject jSONObjectC = this.a.c();
            if (jSONObjectC != null && jSONObjectC.has("ua")) {
                jSONObjectC.optString("ua");
            }
            io.dcloud.sdk.base.dcloud.ADHandler.b(50, this.b, this.c, this.d, this.a, io.dcloud.p.r0.d().b().getAppId());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements io.dcloud.sdk.base.dcloud.ADHandler.f {
        final /* synthetic */ io.dcloud.sdk.base.dcloud.ADHandler.e a;
        final /* synthetic */ android.content.Context b;

        c(io.dcloud.sdk.base.dcloud.ADHandler.e eVar, android.content.Context context) {
            this.a = eVar;
            this.b = context;
        }

        @Override // io.dcloud.sdk.base.dcloud.ADHandler.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void operate(java.io.File file) {
            io.dcloud.sdk.base.dcloud.ADHandler.a.add(file);
            io.dcloud.sdk.base.dcloud.ADHandler.b(this.b, file, this.a);
        }

        @Override // io.dcloud.sdk.base.dcloud.ADHandler.f
        public boolean find() {
            return this.a.a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements io.dcloud.sdk.base.dcloud.ADHandler.h {
        final /* synthetic */ org.json.JSONObject a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ io.dcloud.sdk.base.dcloud.ADHandler.g d;

        d(org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2, io.dcloud.sdk.base.dcloud.ADHandler.g gVar) {
            this.a = jSONObject;
            this.b = str;
            this.c = str2;
            this.d = gVar;
        }

        @Override // io.dcloud.sdk.base.dcloud.ADHandler.h
        public void execute() {
            java.util.HashMap map;
            byte[] bArrA = null;
            if (this.a.has("ua") && this.a.optString("ua").equalsIgnoreCase("webview")) {
                map = new java.util.HashMap();
                map.put(io.dcloud.common.DHInterface.IWebview.USER_AGENT, io.dcloud.sdk.base.dcloud.ADHandler.a("ua-webview"));
            } else {
                map = null;
            }
            try {
                bArrA = io.dcloud.p.l3.a(this.b, map, true);
            } catch (java.lang.Exception unused) {
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder("download file is nulll");
            sb.append(bArrA == null);
            sb.append("src=");
            sb.append(this.b);
            io.dcloud.sdk.base.dcloud.ADHandler.a("adh", sb.toString());
            if (bArrA == null) {
                this.d.b();
            } else {
                io.dcloud.p.v0.a(bArrA, 0, this.c);
                this.d.a();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class e {
        android.view.MotionEvent a;
        android.view.MotionEvent b;
        java.lang.String c;
        org.json.JSONObject d;
        public java.lang.Object e;
        java.lang.String f;
        java.lang.String g;
        java.lang.String h;
        java.lang.String k;
        int i = 0;
        int j = 0;
        public java.lang.String l = "";

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class a extends android.content.BroadcastReceiver {
            final /* synthetic */ io.dcloud.p.s1 a;

            a(io.dcloud.p.s1 s1Var) {
                this.a = s1Var;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(android.content.Context context, android.content.Intent intent) {
                try {
                    long longExtra = intent.getLongExtra("end", 0L) - intent.getLongExtra("begin", 0L);
                    io.dcloud.sdk.base.dcloud.ADHandler.a("ADReceive", "useTime=" + longExtra);
                    if (longExtra <= 3000) {
                        this.a.onReceiver(null);
                    }
                    io.dcloud.sdk.base.dcloud.ADHandler.a("ADReceive", "unregisterReceiver");
                    context.unregisterReceiver(this);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class b implements io.dcloud.p.y0.a {
            final /* synthetic */ android.content.Context a;
            final /* synthetic */ java.lang.String b;
            final /* synthetic */ java.lang.String c;
            final /* synthetic */ java.lang.String d;

            b(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
                this.a = context;
                this.b = str;
                this.c = str2;
                this.d = str3;
            }

            @Override // io.dcloud.p.y0.a
            public void a(io.dcloud.p.y0 y0Var) {
                android.content.Context context = this.a;
                java.lang.String str = this.b;
                java.lang.String str2 = this.c;
                io.dcloud.sdk.base.dcloud.ADHandler.e eVar = io.dcloud.sdk.base.dcloud.ADHandler.e.this;
                io.dcloud.sdk.base.dcloud.ADHandler.b(30, context, str, str2, eVar, eVar.h);
                android.content.pm.PackageInfo packageInfoF = io.dcloud.p.c.f(this.a, this.d);
                if (packageInfoF != null) {
                    android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                    intentFilter.addDataScheme("package");
                    this.a.registerReceiver(new io.dcloud.sdk.base.dcloud.ADHandler.InstallReceiver(io.dcloud.sdk.base.dcloud.ADHandler.e.this, packageInfoF.packageName), intentFilter);
                }
                try {
                    java.lang.Class.forName("io.dcloud.feature.pack.FileUtils").getDeclaredMethod("addFileToSystem", android.content.Context.class, java.lang.String.class, java.lang.String.class).invoke(null, this.a, this.a.getPackageName() + ".dc.fileprovider", this.d);
                } catch (java.lang.Exception unused) {
                }
            }

            @Override // io.dcloud.p.y0.a
            public void b(io.dcloud.p.y0 y0Var) {
                android.content.Context context = this.a;
                java.lang.String str = this.b;
                java.lang.String str2 = this.c;
                io.dcloud.sdk.base.dcloud.ADHandler.e eVar = io.dcloud.sdk.base.dcloud.ADHandler.e.this;
                io.dcloud.sdk.base.dcloud.ADHandler.b(32, context, str, str2, eVar, eVar.h);
            }
        }

        public void a(java.lang.String str) {
            this.k = str;
        }

        org.json.JSONObject b() {
            return this.d.optJSONObject("data");
        }

        org.json.JSONObject c() {
            return this.d;
        }

        boolean d() {
            return this.j == 1;
        }

        org.json.JSONObject e() {
            return this.d.optJSONObject("report");
        }

        public boolean a() {
            return (this.d == null || this.e == null) ? false : true;
        }

        void a(android.content.Context context, io.dcloud.p.s1 s1Var) {
            if (s1Var != null) {
                io.dcloud.sdk.base.dcloud.ADHandler.e.a aVar = new io.dcloud.sdk.base.dcloud.ADHandler.e.a(s1Var);
                try {
                    android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                    intentFilter.addAction("ad_receive");
                    androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(context).registerReceiver(aVar, intentFilter);
                    io.dcloud.sdk.base.dcloud.ADHandler.a("ADReceive", "registerReceiver");
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
            java.lang.String str3;
            io.dcloud.p.c.a(context);
            io.dcloud.p.z0 z0VarA = io.dcloud.p.z0.a(context);
            java.util.List listA = z0VarA.a();
            org.json.JSONObject jSONObjectOptJSONObject = this.d.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                return;
            }
            java.lang.String strOptString = jSONObjectOptJSONObject.optString("url");
            java.lang.String strOptString2 = jSONObjectOptJSONObject.optString("downloadAppName");
            java.util.Iterator it = listA.iterator();
            while (it.hasNext()) {
                if (((io.dcloud.p.y0) it.next()).c().equals(strOptString)) {
                    return;
                }
            }
            java.lang.String str4 = io.dcloud.p.f.a;
            if (android.text.TextUtils.isEmpty(strOptString2)) {
                str3 = null;
            } else {
                str3 = strOptString2 + str4;
            }
            java.lang.String strA = io.dcloud.p.m.a(strOptString, str4, str3);
            java.lang.String absolutePath = context.getExternalFilesDir(null).getAbsolutePath();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(absolutePath);
            sb.append(absolutePath.endsWith("/") ? "" : "/");
            java.lang.String str5 = sb.toString() + "Download/" + strA;
            io.dcloud.sdk.base.dcloud.ADHandler.b(29, context, str, str2, this, this.h);
            io.dcloud.p.y0 y0Var = new io.dcloud.p.y0();
            y0Var.a(context, strOptString, str5);
            y0Var.a(new io.dcloud.sdk.base.dcloud.ADHandler.e.b(context, str, str2, str5));
            z0VarA.a(y0Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    interface f {
        boolean find();

        void operate(java.lang.Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface g {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    interface h {
        void execute();
    }

    static void a(java.lang.String str, java.lang.String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final int i, final android.content.Context context, final java.lang.String str, final java.lang.String str2, final io.dcloud.sdk.base.dcloud.ADHandler.e eVar, final java.lang.String str3) {
        io.dcloud.p.x4.a().a(new java.lang.Runnable() { // from class: io.dcloud.sdk.base.dcloud.ADHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                io.dcloud.sdk.base.dcloud.ADHandler.a(context, str3, str, str2, i, eVar);
            }
        });
    }

    static void c(android.content.Context context, io.dcloud.sdk.base.dcloud.ADHandler.e eVar, java.lang.String str) {
        if ("wanka".equals(eVar.c)) {
            io.dcloud.sdk.base.dcloud.a.f(context, eVar, str);
        } else if ("youdao".equals(eVar.c)) {
            io.dcloud.sdk.base.dcloud.b.f(context, eVar, str);
        } else if ("common".equals(eVar.c)) {
            io.dcloud.sdk.base.dcloud.e.a(context, eVar, str, "imptracker");
        }
    }

    static void b(android.content.Context context, io.dcloud.sdk.base.dcloud.ADHandler.e eVar, java.lang.String str) {
        org.json.JSONObject jSONObjectB = eVar.b();
        java.lang.String strOptString = eVar.b().optString("tid");
        if (jSONObjectB.has("dplk") && io.dcloud.p.c.d(context, jSONObjectB.optString("dplk"))) {
            if (eVar.d()) {
                return;
            }
            io.dcloud.p.x4.a().a(new io.dcloud.sdk.base.dcloud.ADHandler.b(eVar, context, strOptString, str));
            if ("wanka".equals(eVar.c)) {
                io.dcloud.sdk.base.dcloud.a.e(context, eVar, str);
                return;
            } else if ("youdao".equals(eVar.c)) {
                io.dcloud.sdk.base.dcloud.b.e(context, eVar, str);
                return;
            } else {
                if ("common".equals(eVar.c)) {
                    io.dcloud.sdk.base.dcloud.e.a(context, eVar, str, "dptracker");
                    return;
                }
                return;
            }
        }
        java.lang.String strOptString2 = jSONObjectB.optString("action");
        if (android.text.TextUtils.equals("url", strOptString2)) {
            if (eVar.d()) {
                io.dcloud.sdk.base.dcloud.c.a(context, jSONObjectB.optString("url"));
                return;
            } else {
                io.dcloud.p.c.e(context, jSONObjectB.optString("url"));
                return;
            }
        }
        if (!android.text.TextUtils.equals(io.dcloud.common.constant.AbsoluteConst.SPNAME_DOWNLOAD, strOptString2)) {
            if (!android.text.TextUtils.equals("browser", strOptString2) || eVar.d()) {
                return;
            }
            io.dcloud.p.c.c(context, jSONObjectB.optString("url"));
            return;
        }
        if (jSONObjectB.has("expires")) {
            try {
                new java.text.SimpleDateFormat("yy-MM-dd HH:mm:ss", java.util.Locale.ENGLISH).parse(jSONObjectB.optString("expires")).getTime();
            } catch (java.text.ParseException e2) {
                e2.printStackTrace();
            }
        }
        java.lang.String strOptString3 = eVar.c() != null ? eVar.c().optString("ua") : "";
        if (eVar.d()) {
            io.dcloud.sdk.base.dcloud.c.a(context, eVar.h, strOptString, str, jSONObjectB.optString("url"), jSONObjectB.optString(io.dcloud.feature.uniapp.adapter.AbsURIAdapter.BUNDLE), null, strOptString3, eVar.k);
        } else {
            eVar.a(context, strOptString, str);
        }
    }

    public static java.lang.String a(java.lang.String str) {
        str.getClass();
        str.hashCode();
        switch (str) {
            case "adid":
                return io.dcloud.p.r0.d().b().getAdId();
            case "appid":
                return io.dcloud.p.r0.d().b().getAppId();
            case "ua-webview":
                return io.dcloud.p.n4.e(io.dcloud.p.r0.d().c());
            default:
                return null;
        }
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        return a(str);
    }

    private static void a(io.dcloud.sdk.base.dcloud.ADHandler.h hVar) {
        if (hVar != null) {
            if (java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread()) {
                io.dcloud.p.x4.a().a(new io.dcloud.sdk.base.dcloud.ADHandler.a(hVar));
            } else {
                hVar.execute();
            }
        }
    }

    static java.lang.String a(java.lang.String str, org.json.JSONObject jSONObject) {
        try {
            return str.replace("${User-Agent}", java.net.URLEncoder.encode(jSONObject.optString("u-a"), "utf-8")).replace("${click_id}", jSONObject.optString("click_id")).replace("${down_x}", java.lang.String.valueOf(jSONObject.optInt("down_x", com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME))).replace("${down_y}", java.lang.String.valueOf(jSONObject.optInt("down_y", com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME))).replace("${up_x}", java.lang.String.valueOf(jSONObject.optInt("up_x", com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME))).replace("${up_y}", java.lang.String.valueOf(jSONObject.optInt("up_y", com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME))).replace("${relative_down_x}", java.lang.String.valueOf(jSONObject.optInt("relative_down_x", com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME))).replace("${relative_down_y}", java.lang.String.valueOf(jSONObject.optInt("relative_down_y", com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME))).replace("${relative_up_x}", java.lang.String.valueOf(jSONObject.optInt("relative_up_x", com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME))).replace("${relative_up_y}", java.lang.String.valueOf(jSONObject.optInt("relative_up_y", com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME)));
        } catch (java.io.UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, int i, io.dcloud.sdk.base.dcloud.ADHandler.e eVar) {
        io.dcloud.p.d0.a(context, str, str2, str3, i, eVar.k);
    }

    static void a(android.content.Context context, io.dcloud.sdk.base.dcloud.ADHandler.e eVar, java.lang.String str) {
        if ("wanka".equals(eVar.c)) {
            io.dcloud.sdk.base.dcloud.a.d(context, eVar, str);
            return;
        }
        if ("youdao".equals(eVar.c)) {
            io.dcloud.sdk.base.dcloud.b.d(context, eVar, str);
        } else if ("common".equals(eVar.c)) {
            io.dcloud.sdk.base.dcloud.e.d(context, eVar, str);
        } else {
            b(context, eVar, str);
        }
    }

    private static void a(java.io.File[] fileArr) {
        if (fileArr == null) {
            return;
        }
        for (int i = 0; i < fileArr.length - 1; i++) {
            int i2 = 0;
            while (i2 < (fileArr.length - 1) - i) {
                int i3 = i2 + 1;
                if (java.lang.Long.parseLong(fileArr[i2].getName()) < java.lang.Long.parseLong(fileArr[i3].getName())) {
                    java.io.File file = fileArr[i2];
                    fileArr[i2] = fileArr[i3];
                    fileArr[i3] = file;
                }
                i2 = i3;
            }
        }
    }

    private static void a(android.content.Context context, io.dcloud.sdk.base.dcloud.ADHandler.f fVar) {
        java.io.File file = new java.io.File(a(context));
        if (!file.exists()) {
            file.mkdirs();
        }
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        a(fileArrListFiles);
        for (java.io.File file2 : fileArrListFiles) {
            if (!fVar.find()) {
                for (java.io.File file3 : file2.listFiles()) {
                    if (java.lang.Long.parseLong(file3.getName()) > java.lang.System.currentTimeMillis()) {
                        if (!fVar.find()) {
                            for (java.io.File file4 : file3.listFiles()) {
                                fVar.operate(file4);
                                if (fVar.find()) {
                                    break;
                                }
                            }
                        }
                    } else {
                        io.dcloud.p.v0.a(file3);
                    }
                }
            } else {
                io.dcloud.p.v0.a(file2);
            }
        }
    }

    public static io.dcloud.sdk.base.dcloud.ADHandler.e b(android.content.Context context, java.lang.String str) {
        return a(context, str, new io.dcloud.sdk.base.dcloud.ADHandler.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(android.content.Context context, java.io.File file, io.dcloud.sdk.base.dcloud.ADHandler.e eVar) {
        org.json.JSONObject jSONObject;
        org.json.JSONObject jSONObjectOptJSONObject;
        try {
            java.lang.String str = new java.lang.String(io.dcloud.p.v0.e(file.getAbsolutePath() + "/data.json"));
            if (!android.text.TextUtils.isEmpty(str) && (jSONObjectOptJSONObject = (jSONObject = new org.json.JSONObject(str)).optJSONObject("data")) != null) {
                eVar.c = jSONObject.optString("provider");
                eVar.d = jSONObject;
                eVar.i = jSONObject.optInt("es", 0);
                eVar.j = jSONObject.optInt("ec", 0);
                java.lang.String strOptString = jSONObjectOptJSONObject.optString("src");
                eVar.g = strOptString;
                eVar.l = jSONObjectOptJSONObject.optString("tid", "");
                boolean zEndsWith = strOptString.toLowerCase(java.util.Locale.ENGLISH).endsWith(".gif");
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(file.getAbsolutePath());
                sb.append("/");
                sb.append(zEndsWith ? "img.gif" : "img.png");
                java.lang.String string = sb.toString();
                java.lang.String str2 = file.getAbsolutePath() + "/s.txt";
                if (!new java.io.File(string).exists() || new java.io.File(str2).exists()) {
                    return;
                }
                if (zEndsWith) {
                    eVar.e = io.dcloud.sdk.core.util.ReflectUtil.newInstance("pl.droidsonroids.gif.GifDrawable", new java.lang.Class[]{java.lang.String.class}, new java.lang.Object[]{jSONObject.optString("srcPath")});
                } else {
                    android.graphics.Bitmap bitmapDecodeFile = android.graphics.BitmapFactory.decodeFile(string);
                    if (bitmapDecodeFile != null) {
                        eVar.e = bitmapDecodeFile;
                    }
                }
                eVar.f = string;
                new java.io.File(str2).createNewFile();
                io.dcloud.p.v0.a((java.lang.Object) file.getAbsolutePath());
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    static io.dcloud.sdk.base.dcloud.ADHandler.e a(android.content.Context context, java.lang.String str, io.dcloud.sdk.base.dcloud.ADHandler.e eVar) {
        eVar.h = str;
        a = new java.util.LinkedList();
        a(context, new io.dcloud.sdk.base.dcloud.ADHandler.c(eVar, context));
        if (!eVar.a() && a.size() != 0) {
            for (int i = 0; i < a.size(); i++) {
                new java.io.File(((java.io.File) a.get(i)).getAbsolutePath() + "/s.txt").delete();
                if (i == 0) {
                    b(context, (java.io.File) a.get(i), eVar);
                }
            }
        }
        return eVar;
    }

    private static java.lang.String a(android.content.Context context) {
        java.io.File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            return "/sdcard/Android/data/" + context.getPackageName() + "/cache/ad/";
        }
        return externalCacheDir.getAbsolutePath() + "/ad/";
    }

    static void b(android.content.Context context, org.json.JSONObject jSONObject, long j, io.dcloud.sdk.base.dcloud.ADHandler.g gVar) throws org.json.JSONException, java.text.ParseException, java.io.UnsupportedEncodingException {
        java.lang.String strA = a(context);
        org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        java.util.Date date = new java.text.SimpleDateFormat("yy-MM-dd HH:mm:ss", java.util.Locale.ENGLISH).parse(jSONObjectOptJSONObject.optString("expires"));
        if (date.getTime() > java.lang.System.currentTimeMillis()) {
            java.lang.String strOptString = jSONObjectOptJSONObject.optString("src");
            a(context, jSONObject, jSONObjectOptJSONObject.optString("tid"), strOptString, strA + j + "/" + date.getTime() + "/" + java.net.URLEncoder.encode(strOptString, "utf-8").hashCode() + "/", gVar);
            return;
        }
        gVar.b();
    }

    private static void a(android.content.Context context, org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2, java.lang.String str3, io.dcloud.sdk.base.dcloud.ADHandler.g gVar) throws org.json.JSONException {
        if (jSONObject != null && jSONObject.has("es") && jSONObject.getInt("es") == 1) {
            new io.dcloud.sdk.base.dcloud.c(context, jSONObject).d();
            return;
        }
        java.lang.System.currentTimeMillis();
        io.dcloud.p.v0.a(str.getBytes(), 0, str3 + "tid.txt");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str3);
        sb.append(str2.endsWith(".gif") ? "img.gif" : "img.png");
        java.lang.String string = sb.toString();
        jSONObject.put("srcPath", string);
        io.dcloud.p.v0.a(jSONObject.toString().getBytes(), 0, str3 + "data.json");
        a(new io.dcloud.sdk.base.dcloud.ADHandler.d(jSONObject, str2, string, gVar));
    }

    public static void a(android.content.Context context, org.json.JSONObject jSONObject, long j, io.dcloud.sdk.base.dcloud.ADHandler.g gVar) {
        try {
            b(context, jSONObject, j, gVar);
        } catch (java.lang.Exception unused) {
            gVar.b();
        }
    }
}
