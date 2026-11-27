package io.dcloud.sdk.core.module;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DCBaseAOLLoader extends io.dcloud.sdk.core.module.a {
    private final int S_T_O;
    private boolean isLoadFinished;
    private io.dcloud.p.x.a listener;
    private final android.os.Handler timeoutHandler;
    private int timeoutTimeStamp;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class a implements java.lang.Runnable {
        private final io.dcloud.sdk.core.module.DCBaseAOLLoader a;
        private final int b;
        private final int c;
        private final java.lang.String d;
        private final java.util.List e;

        public a(io.dcloud.sdk.core.module.DCBaseAOLLoader dCBaseAOLLoader, java.util.List list, int i, int i2, java.lang.String str) {
            this.a = dCBaseAOLLoader;
            this.b = i;
            this.c = i2;
            this.d = str;
            this.e = list;
            if (list != null) {
                io.dcloud.p.c3.d("sub slot ads:" + list.size());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.p.n1 n1Var = new io.dcloud.p.n1();
            n1Var.c(this.a.getAppId()).e(this.a.getSlotId()).b(this.a.level).d(this.a.getType()).f(this.a.getTid()).a(this.a.getLoadTotalTime());
            if (this.a.isCustom()) {
                n1Var.a(io.dcloud.p.n.a(this.a)).b(io.dcloud.p.n.b(this.a));
            }
            int i = this.b;
            if (i == 1) {
                n1Var.c(i);
                if (this.a.isSlotSupportBidding()) {
                    n1Var.a(this.a.getBiddingECPM());
                }
                this.a.listener.a(this.a, this.e, n1Var);
                return;
            }
            if (i == 0) {
                n1Var.c(i);
                n1Var.a(this.c, this.d);
                this.a.listener.a(this.a, n1Var);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class b extends android.os.Handler {
        public b(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(android.os.Message message) {
            io.dcloud.sdk.core.module.DCBaseAOLLoader.this.loadFail(-5000, "timeout");
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
        }
    }

    public DCBaseAOLLoader(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, android.app.Activity activity) {
        super(dCloudAOLSlot, activity);
        this.isLoadFinished = false;
        this.S_T_O = 1;
        this.timeoutTimeStamp = com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
        setStatus(-1);
        this.timeoutHandler = new io.dcloud.sdk.core.module.DCBaseAOLLoader.b(io.dcloud.p.a3.a().getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(java.util.Map map) {
        try {
            load(map);
        } catch (java.lang.Throwable th) {
            loadFail(-4002, th.getMessage());
        }
    }

    private boolean m() {
        if (android.text.TextUtils.isEmpty(getAppId())) {
            return !io.dcloud.p.e.b().a(getType()) || getType().equalsIgnoreCase("dcloud") || getType().equalsIgnoreCase(io.dcloud.sdk.core.util.Const.TYPE_WM);
        }
        if (getType().equalsIgnoreCase(io.dcloud.sdk.core.util.Const.TYPE_SGM)) {
            return !android.text.TextUtils.isEmpty(getAppKey());
        }
        return true;
    }

    private boolean n() {
        return getSlot().getType() == 10 || getSlot().getType() == 4 || getSlot().getType() == 5;
    }

    protected abstract void init(java.lang.String str, java.lang.String str2);

    public void initSDK(io.dcloud.sdk.core.adapter.IAdAdapter iAdAdapter, org.json.JSONObject jSONObject) {
    }

    public abstract void load(java.util.Map<java.lang.String, java.lang.Object> map);

    public final void loadAd(final java.util.Map<java.lang.String, java.lang.Object> map) {
        setStatus(-1);
        if (!m()) {
            loadFail(-9999, "");
            return;
        }
        if (android.text.TextUtils.isEmpty(getSlotId())) {
            loadFail(-9999, "");
            return;
        }
        startLoadTime();
        if (runOnMain()) {
            io.dcloud.sdk.core.util.MainHandlerUtil.getMainHandler().post(new java.lang.Runnable() { // from class: io.dcloud.sdk.core.module.DCBaseAOLLoader$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(map);
                }
            });
        } else {
            try {
                load(map);
            } catch (java.lang.Throwable th) {
                loadFail(-4002, th.getMessage());
            }
        }
        this.timeoutHandler.sendEmptyMessageDelayed(1, this.timeoutTimeStamp);
    }

    public final void loadFail(int i, java.lang.String str) {
        if (this.isLoadFinished) {
            return;
        }
        setFail(i, str);
        this.isLoadFinished = true;
        this.timeoutHandler.removeMessages(1);
        io.dcloud.p.a3.a().post(new io.dcloud.sdk.core.module.DCBaseAOLLoader.a(this, null, 0, i, str));
    }

    public final void loadSuccess() {
        if (n()) {
            loadFail(-5001, "回调接口调用失败，应该使用loadSuccess(List obj)");
        } else {
            loadSuccess(null);
        }
    }

    public io.dcloud.p.n1 makeFillRate() {
        io.dcloud.p.n1 n1Var = new io.dcloud.p.n1();
        setSlotTimeout();
        n1Var.c(getAppId()).b(this.level).e(getSlotId()).d(getType()).f(getTid()).a(getLoadTotalTime());
        n1Var.c(getAdStatus());
        if (isSlotSupportBidding()) {
            n1Var.a(getBiddingECPM());
        }
        if (isCustom()) {
            n1Var.a(io.dcloud.p.n.a(this)).b(io.dcloud.p.n.b(this));
        }
        return n1Var;
    }

    protected boolean runOnMain() {
        return false;
    }

    public void setLoadListener(io.dcloud.p.x.a aVar) {
        this.listener = aVar;
    }

    public void setPlatform(io.dcloud.sdk.poly.api.Platform platform, java.lang.String str) {
    }

    public void setSlotAdInfo(io.dcloud.p.v4 v4Var) {
        setSlot(v4Var.o());
        this.plat = v4Var.l();
        setSlotSupportBidding(v4Var.u());
        if (!isSlotSupportBidding()) {
            setBiddingECPM(v4Var.c());
        }
        this.showSort = v4Var.n();
        this.timeoutTimeStamp = v4Var.p();
        this.level = v4Var.f();
        this.type = v4Var.b();
        setFeedType(v4Var.d());
        setMiniRequestType(v4Var.h());
        setEnd(v4Var.r());
        setPath(v4Var.k());
        setMiniType(v4Var.i());
        setParams(v4Var.j());
        setAcpt(v4Var.a());
        setIntersType(v4Var.e());
        setExpressAd(v4Var.s());
        getExtraData().put(2001, v4Var.m());
        io.dcloud.p.c3.d("load sub slot cfg:" + v4Var.toString());
    }

    public void show(android.app.Activity activity) {
    }

    public void showIn(android.view.ViewGroup viewGroup) {
    }

    public void initSDK(java.lang.String str, java.lang.String str2) {
        setAppId(str);
        setAppKey(str2);
        init(str, str2);
    }

    public final void initSDK(java.lang.String str, io.dcloud.sdk.core.adapter.IAdAdapter iAdAdapter, org.json.JSONObject jSONObject) {
        setAppId(str);
        initSDK(iAdAdapter, jSONObject);
    }

    public final void loadSuccess(java.util.List<? extends io.dcloud.sdk.core.module.DCBaseAOL> list) {
        if (!n()) {
            list = null;
        }
        java.util.List<? extends io.dcloud.sdk.core.module.DCBaseAOL> list2 = list;
        if (this.isLoadFinished) {
            return;
        }
        if (list2 != null) {
            for (io.dcloud.sdk.core.module.DCBaseAOL dCBaseAOL : list2) {
                dCBaseAOL.level = this.level;
                dCBaseAOL.setSlotSupportBidding(isSlotSupportBidding());
                dCBaseAOL.setBiddingECPM(getBiddingECPM());
                dCBaseAOL.showSort = this.showSort;
                dCBaseAOL.type = this.type;
                dCBaseAOL.setSlot(getSlotId());
                dCBaseAOL.setAppId(getAppId());
                dCBaseAOL.setFeedType(getFeedType());
                dCBaseAOL.setLoadId(getLoadId());
                dCBaseAOL.plat = this.plat;
            }
        }
        setSuccess();
        this.isLoadFinished = true;
        this.timeoutHandler.removeMessages(1);
        io.dcloud.p.a3.a().post(new io.dcloud.sdk.core.module.DCBaseAOLLoader.a(this, list2, 1, 0, null));
    }
}
