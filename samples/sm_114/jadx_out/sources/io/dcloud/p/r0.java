package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class r0 implements io.dcloud.sdk.core.interfaces.AOLLoader {
    private static volatile io.dcloud.p.r0 g;
    private io.dcloud.sdk.core.DCloudAOLManager.InitConfig a;
    private io.dcloud.p.t1 b;
    private android.content.Context c;
    private boolean e = false;
    private volatile boolean f = false;
    private io.dcloud.p.h d = new io.dcloud.p.h();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b extends io.dcloud.p.c0.c {
        b(java.lang.String str) {
            super(str);
        }

        @Override // io.dcloud.p.c0.c
        public void a(int i, java.lang.String str) {
        }

        @Override // io.dcloud.p.c0.c
        public void a(org.json.JSONObject jSONObject) {
        }
    }

    private r0() {
    }

    public static io.dcloud.p.r0 d() {
        if (g == null) {
            synchronized (io.dcloud.p.r0.class) {
                if (g == null) {
                    g = new io.dcloud.p.r0();
                    g.b = new io.dcloud.p.h3();
                }
            }
        }
        return g;
    }

    public io.dcloud.sdk.core.DCloudAOLManager.InitConfig b() {
        return this.a;
    }

    public android.content.Context c() {
        return this.c;
    }

    public void e() {
        android.content.Context context = this.c;
        if (context != null) {
            try {
                boolean z = true;
                if (1 != context.getPackageManager().getApplicationInfo(this.c.getPackageName(), 128).metaData.getInt("UNIAD_ENV_TYPE")) {
                    z = false;
                }
                this.e = z;
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public boolean f() {
        return this.f;
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader
    public boolean getPersonalAOL(android.content.Context context) {
        return io.dcloud.sdk.core.util.AdUtil.getPersonalAd(context);
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader
    public void setPersonalAOL(android.content.Context context, boolean z) {
        io.dcloud.sdk.core.util.AdUtil.setPersonalAd(context, z);
        java.util.Map mapA = io.dcloud.p.e.b().a();
        java.util.Iterator it = mapA.keySet().iterator();
        while (it.hasNext()) {
            ((io.dcloud.sdk.core.adapter.IAdAdapter) mapA.get((java.lang.String) it.next())).setPersonalAd(z);
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader
    public void setPrivacyConfig(io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig) {
        io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().updateConfig(privacyConfig);
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader
    public void start(io.dcloud.sdk.core.interfaces.AOLLoader.AOLStartCallback aOLStartCallback) {
        if (!this.f) {
            io.dcloud.p.c0.a().a(this.c, 1, new io.dcloud.p.r0.a("", new java.util.concurrent.atomic.AtomicBoolean(false), aOLStartCallback));
        } else if (aOLStartCallback != null) {
            aOLStartCallback.onSuccess();
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader
    public void updatePrivacyConfig(android.content.Context context, org.json.JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        io.dcloud.sdk.core.util.AdUtil.setCustomPrivacyConfig(context, jSONObject.toString());
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = io.dcloud.sdk.core.util.AdUtil.getPrivacyConfig(jSONObject);
        java.util.Iterator it = io.dcloud.p.e.b().c().iterator();
        while (it.hasNext()) {
            io.dcloud.sdk.core.adapter.IAdAdapter iAdAdapterB = io.dcloud.p.e.b().b((java.lang.String) it.next());
            if (iAdAdapterB != null) {
                iAdAdapterB.updatePrivacyConfig(privacyConfig);
            }
        }
    }

    @Override // io.dcloud.sdk.core.interfaces.AOLLoader
    public java.util.Map verify(java.util.Map map) {
        return io.dcloud.p.c0.a().a(map);
    }

    public void b(android.content.Context context) {
        this.c = context;
        if (context instanceof android.app.Application) {
            io.dcloud.p.g4.a((android.app.Application) context);
        } else if (context != null) {
            io.dcloud.p.g4.a((android.app.Application) context.getApplicationContext());
        }
    }

    public void a(io.dcloud.sdk.core.DCloudAOLManager.InitConfig initConfig) {
        this.a = initConfig;
    }

    public io.dcloud.p.t1 a() {
        return this.b;
    }

    public void a(io.dcloud.p.t1 t1Var) {
        this.b = t1Var;
    }

    public void a(android.content.Context context) {
        io.dcloud.p.c0.a().a(context, 1, new io.dcloud.p.r0.b(""));
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends io.dcloud.p.c0.c {
        final /* synthetic */ java.util.concurrent.atomic.AtomicBoolean b;
        final /* synthetic */ io.dcloud.sdk.core.interfaces.AOLLoader.AOLStartCallback c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(java.lang.String str, java.util.concurrent.atomic.AtomicBoolean atomicBoolean, io.dcloud.sdk.core.interfaces.AOLLoader.AOLStartCallback aOLStartCallback) {
            super(str);
            this.b = atomicBoolean;
            this.c = aOLStartCallback;
        }

        @Override // io.dcloud.p.c0.c
        public void a(org.json.JSONObject jSONObject) {
            if (this.b.compareAndSet(false, true)) {
                android.content.Context applicationContext = io.dcloud.p.r0.this.c.getApplicationContext();
                io.dcloud.p.c0 c0VarA = io.dcloud.p.c0.a();
                if (applicationContext == null) {
                    applicationContext = io.dcloud.p.r0.this.c;
                }
                c0VarA.c(applicationContext);
                io.dcloud.p.r0.this.f = true;
                io.dcloud.sdk.core.interfaces.AOLLoader.AOLStartCallback aOLStartCallback = this.c;
                if (aOLStartCallback != null) {
                    aOLStartCallback.onSuccess();
                }
            }
        }

        @Override // io.dcloud.p.c0.c
        public void a(int i, java.lang.String str) {
            io.dcloud.sdk.core.interfaces.AOLLoader.AOLStartCallback aOLStartCallback;
            if (this.b.compareAndSet(false, true) && (aOLStartCallback = this.c) != null) {
                aOLStartCallback.onError(i, str);
            }
        }
    }
}
