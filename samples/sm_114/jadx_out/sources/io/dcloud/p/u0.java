package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class u0 extends io.dcloud.sdk.core.module.DCBaseAOLLoader implements io.dcloud.p.v2.c {
    private io.dcloud.p.w4 a;
    private io.dcloud.sdk.poly.api.Platform b;
    private java.lang.String c;
    private io.dcloud.sdk.base.dcloud.ADHandler.e d;
    private android.os.Handler e;
    private int f;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends android.os.Handler {
        a(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            io.dcloud.p.u0.this.loadFail(-9999, "");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements io.dcloud.p.o {
        b() {
        }

        @Override // io.dcloud.p.o
        public void onClicked() {
            if (io.dcloud.p.u0.this.getVideoAdCallback() != null) {
                io.dcloud.p.u0.this.getVideoAdCallback().onClick();
            }
        }

        @Override // io.dcloud.p.o
        public void onFinishShow() {
            if (io.dcloud.p.u0.this.getVideoAdCallback() != null) {
                io.dcloud.p.u0.this.getVideoAdCallback().onClose();
            }
        }

        @Override // io.dcloud.p.o
        public void onShow() {
            if (io.dcloud.p.u0.this.getVideoAdCallback() != null) {
                io.dcloud.p.u0.this.getVideoAdCallback().onShow();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements io.dcloud.sdk.base.dcloud.ADHandler.g {
        c() {
        }

        @Override // io.dcloud.sdk.base.dcloud.ADHandler.g
        public void a() {
            if (io.dcloud.p.u0.this.getAdStatus() != -1) {
                return;
            }
            io.dcloud.sdk.base.dcloud.ADHandler.e eVarB = io.dcloud.sdk.base.dcloud.ADHandler.b(io.dcloud.p.u0.this.getActivity(), io.dcloud.p.r0.d().b().getAppId());
            if (!eVarB.a()) {
                io.dcloud.p.u0.this.loadFail(-9999, "");
                return;
            }
            io.dcloud.p.u0.this.d = eVarB;
            io.dcloud.p.u0.this.d.a(io.dcloud.p.u0.this.getDCloudId());
            io.dcloud.p.u0.this.loadSuccess();
        }

        @Override // io.dcloud.sdk.base.dcloud.ADHandler.g
        public void b() {
            if (io.dcloud.p.u0.this.getAdStatus() != -1) {
                return;
            }
            io.dcloud.sdk.base.dcloud.ADHandler.e eVarB = io.dcloud.sdk.base.dcloud.ADHandler.b(io.dcloud.p.u0.this.getActivity(), io.dcloud.p.r0.d().b().getAppId());
            if (!eVarB.a()) {
                io.dcloud.p.u0.this.loadFail(-9999, "");
                return;
            }
            io.dcloud.p.u0.this.d = eVarB;
            io.dcloud.p.u0.this.d.a(io.dcloud.p.u0.this.getDCloudId());
            io.dcloud.p.u0.this.loadSuccess();
        }
    }

    public u0(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, android.app.Activity activity) {
        super(dCloudAOLSlot, activity);
        this.c = "";
        this.e = new io.dcloud.p.u0.a(android.os.Looper.getMainLooper());
        this.f = com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(android.view.ViewGroup viewGroup) {
        this.a.a(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(android.view.ViewGroup viewGroup) {
        new io.dcloud.sdk.base.dcloud.g(getActivity(), this.d, viewGroup, new io.dcloud.p.u0.b()).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        io.dcloud.p.w4 w4VarA = io.dcloud.p.s0.a(this, getActivity(), this.b.getSplash(), getSlotId(), this.b.getEr(), this.b.getEc());
        this.a = w4VarA;
        w4VarA.c();
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public void destroy() {
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public java.lang.String getAppId() {
        io.dcloud.sdk.poly.api.Platform platform = this.b;
        return platform == null ? "" : platform.getAppid();
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public java.lang.String getTid() {
        io.dcloud.sdk.poly.api.Platform platform = this.b;
        if (platform != null) {
            return platform.getTid();
        }
        io.dcloud.sdk.base.dcloud.ADHandler.e eVar = this.d;
        return eVar != null ? eVar.l : "";
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public java.lang.String getType() {
        io.dcloud.sdk.poly.api.Platform platform = this.b;
        return platform == null ? this.c : platform.getType();
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    public void init(java.lang.String str, java.lang.String str2) {
    }

    @Override // io.dcloud.sdk.core.module.a
    public boolean isNeedReport() {
        if (android.text.TextUtils.isEmpty(this.c) || this.c.equals("dcloud")) {
            return false;
        }
        return super.isNeedReport();
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public boolean isValid() {
        return true;
    }

    @Override // io.dcloud.p.v2.c
    public void j() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // io.dcloud.p.v2.c
    public void k() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onSkip();
        }
    }

    @Override // io.dcloud.p.v2.c
    public void l() {
        loadSuccess();
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    public void load(java.util.Map map) {
        if (android.text.TextUtils.isEmpty(this.c)) {
            loadFail(-9999, "");
            return;
        }
        if (this.c.equals("dcloud")) {
            io.dcloud.p.c3.a("uniAd", "load base");
            this.e.sendEmptyMessageDelayed(this.f, io.dcloud.WebAppActivity.SPLASH_SECOND);
        } else if (this.b == null) {
            loadFail(-9999, "");
        } else {
            io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.u0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.o();
                }
            });
        }
    }

    @Override // io.dcloud.p.v2.c
    public void onAdClicked() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // io.dcloud.p.v2.c
    public void onAdShow() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // io.dcloud.p.v2.c
    public void onError(int i, java.lang.String str) {
        loadFail(i, str);
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    public boolean runOnMain() {
        return false;
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    public void setPlatform(io.dcloud.sdk.poly.api.Platform platform, java.lang.String str) {
        this.b = platform;
        this.c = str;
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    public void showIn(final android.view.ViewGroup viewGroup) {
        if ((this.a == null && this.d == null) || android.text.TextUtils.isEmpty(this.c)) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5008, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5008));
                return;
            }
            return;
        }
        if (viewGroup == null) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5014, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5014));
            }
        } else {
            if (this.c.equals("dcloud")) {
                if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                    a(viewGroup);
                    return;
                } else {
                    io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.u0$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.a(viewGroup);
                        }
                    });
                    return;
                }
            }
            if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                this.a.a(viewGroup);
            } else {
                io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.p.u0$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.b(viewGroup);
                    }
                });
            }
        }
    }

    @Override // io.dcloud.p.v2.c
    public void a(int i, java.lang.String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5100, "code" + i + ";message:" + str);
        }
    }

    public void a(org.json.JSONArray jSONArray, boolean z) {
        io.dcloud.p.c3.a("uniAd-finish", java.lang.String.valueOf(jSONArray) + "::::::" + z);
        if (this.e.hasMessages(this.f)) {
            this.e.removeMessages(this.f);
            if (z) {
                if (jSONArray != null && jSONArray.length() != 0) {
                    io.dcloud.p.u0.c cVar = new io.dcloud.p.u0.c();
                    boolean z2 = true;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        org.json.JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null) {
                            io.dcloud.sdk.base.dcloud.ADHandler.a(getActivity(), jSONObjectOptJSONObject, java.lang.System.currentTimeMillis(), cVar);
                            z2 = false;
                        }
                    }
                    if (z2) {
                        loadFail(-9999, "");
                        return;
                    }
                    return;
                }
                io.dcloud.sdk.base.dcloud.ADHandler.e eVarB = io.dcloud.sdk.base.dcloud.ADHandler.b(getActivity(), io.dcloud.p.r0.d().b().getAppId());
                if (eVarB.a()) {
                    this.d = eVarB;
                    eVarB.a(getDCloudId());
                    loadSuccess();
                    return;
                }
                loadFail(-9999, "");
                return;
            }
            loadFail(-9999, "");
        }
    }
}
