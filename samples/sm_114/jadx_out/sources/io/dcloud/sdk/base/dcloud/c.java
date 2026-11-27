package io.dcloud.sdk.base.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    io.dcloud.sdk.base.dcloud.ADHandler.e a = null;
    private android.content.Context b;
    android.os.Handler c;
    org.json.JSONObject d;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends android.os.Handler {
        a(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            if (message.what != 10000) {
                return;
            }
            io.dcloud.sdk.base.dcloud.c.this.c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements java.lang.Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.sdk.base.dcloud.c cVar = io.dcloud.sdk.base.dcloud.c.this;
            cVar.a = cVar.a(cVar.d);
            io.dcloud.sdk.base.dcloud.ADHandler.e eVar = io.dcloud.sdk.base.dcloud.c.this.a;
            if (eVar != null) {
                java.lang.String strOptString = eVar.c() != null ? io.dcloud.sdk.base.dcloud.c.this.a.c().optString("ua") : "";
                io.dcloud.sdk.base.dcloud.c cVar2 = io.dcloud.sdk.base.dcloud.c.this;
                cVar2.a(cVar2.a.g, strOptString);
            }
        }
    }

    /* JADX INFO: renamed from: io.dcloud.sdk.base.dcloud.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class RunnableC0075c implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;

        RunnableC0075c(java.lang.String str, java.lang.String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.HashMap map = new java.util.HashMap();
            if (!android.text.TextUtils.isEmpty(this.a) && this.a.equalsIgnoreCase("webview")) {
                map.put(io.dcloud.common.DHInterface.IWebview.USER_AGENT, io.dcloud.sdk.base.dcloud.ADHandler.a("ua-webview"));
            }
            try {
                if (io.dcloud.p.l3.a(this.b, map, true) != null) {
                    io.dcloud.sdk.base.dcloud.c.this.c.sendEmptyMessage(io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH);
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements java.lang.Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.sdk.base.dcloud.c.this.a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class e implements io.dcloud.p.y0.a {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ java.lang.String e;
        final /* synthetic */ io.dcloud.p.z0 f;

        e(io.dcloud.p.a2 a2Var, android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, io.dcloud.p.z0 z0Var) {
            this.a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = z0Var;
        }

        @Override // io.dcloud.p.y0.a
        public void a(io.dcloud.p.y0 y0Var) {
            y0Var.a();
            throw null;
        }

        @Override // io.dcloud.p.y0.a
        public void b(io.dcloud.p.y0 y0Var) {
            io.dcloud.sdk.base.dcloud.c.b(this.a, this.b, this.c, this.d, this.e, 32);
            java.io.File file = new java.io.File(y0Var.b());
            if (file.exists()) {
                file.delete();
            }
            this.f.b(y0Var);
        }
    }

    public c(android.content.Context context, org.json.JSONObject jSONObject) {
        this.c = null;
        this.d = jSONObject;
        this.b = context;
        this.c = new io.dcloud.sdk.base.dcloud.c.a(context.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        io.dcloud.sdk.base.dcloud.ADHandler.a("adh", "ADSim---view");
        android.content.Context context = this.b;
        io.dcloud.sdk.base.dcloud.ADHandler.c(context, this.a, io.dcloud.sdk.base.dcloud.ADHandler.a(context, "adid"));
        b();
    }

    public void d() {
        this.c.postDelayed(new io.dcloud.sdk.base.dcloud.c.b(), a(250, 350));
    }

    private void b() {
        if (this.a.d()) {
            this.c.postDelayed(new io.dcloud.sdk.base.dcloud.c.d(), a(800, 2000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, java.lang.String str2) {
        io.dcloud.p.x4.a().a(new io.dcloud.sdk.base.dcloud.c.RunnableC0075c(str2, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final android.content.Context context, final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final java.lang.String str4, final int i) {
        io.dcloud.p.x4.a().a(new java.lang.Runnable() { // from class: io.dcloud.sdk.base.dcloud.c$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                io.dcloud.p.d0.a(context, str, str2, str3, i, str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.dcloud.sdk.base.dcloud.ADHandler.e a(org.json.JSONObject jSONObject) {
        io.dcloud.sdk.base.dcloud.ADHandler.e eVar = new io.dcloud.sdk.base.dcloud.ADHandler.e();
        org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        if (jSONObjectOptJSONObject != null) {
            eVar.c = jSONObject.optString("provider");
            eVar.d = jSONObject;
            eVar.i = jSONObject.optInt("es", 0);
            eVar.j = jSONObject.optInt("ec", 0);
            eVar.g = jSONObjectOptJSONObject.optString("src");
            eVar.e = "000";
            eVar.h = io.dcloud.sdk.base.dcloud.ADHandler.a("appid");
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        io.dcloud.sdk.base.dcloud.ADHandler.a("adh", "ADSim---click");
        android.content.Context context = this.b;
        io.dcloud.sdk.base.dcloud.ADHandler.a(context, this.a, io.dcloud.sdk.base.dcloud.ADHandler.a(context, "adid"));
    }

    public static int a(int i, int i2) {
        return (int) (((double) i) + (java.lang.Math.random() * ((double) ((i2 - i) + 1))));
    }

    public static void a(android.content.Context context, java.lang.String str) {
        new io.dcloud.sdk.base.dcloud.d(context).a(str);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, io.dcloud.p.a2 a2Var, java.lang.String str6, java.lang.String str7) {
        b(context, str, str2, str3, str7, 29);
        io.dcloud.p.z0 z0VarA = io.dcloud.p.z0.a(context.getApplicationContext());
        java.lang.String absolutePath = context.getExternalFilesDir(null).getAbsolutePath();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(absolutePath);
        sb.append(absolutePath.endsWith("/") ? "" : "/");
        java.lang.String str8 = sb.toString() + "/Download/ADSIM-INFO.io";
        java.io.File file = new java.io.File(str8);
        if (file.exists()) {
            file.delete();
        }
        for (io.dcloud.p.y0 y0Var : z0VarA.a()) {
            if (y0Var.c().equals(str4)) {
                z0VarA.b(y0Var);
            }
        }
        io.dcloud.p.y0 y0Var2 = new io.dcloud.p.y0();
        y0Var2.a(context, str4, str8);
        y0Var2.a(new io.dcloud.sdk.base.dcloud.c.e(a2Var, context, str, str2, str3, str7, z0VarA));
        z0VarA.a(y0Var2);
    }
}
