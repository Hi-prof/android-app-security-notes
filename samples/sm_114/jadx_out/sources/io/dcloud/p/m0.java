package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class m0 extends io.dcloud.sdk.core.module.DCBaseAOLLoader implements io.dcloud.p.w1, io.dcloud.p.w1.a {
    private org.json.JSONObject a;
    private io.dcloud.api.custom.UniAdCustomAdapter b;
    private io.dcloud.api.custom.type.UniAdCustomBaseLoader c;

    public m0(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, android.app.Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        io.dcloud.api.custom.type.UniAdCustomBaseLoader uniAdCustomBaseLoader = this.c;
        if (uniAdCustomBaseLoader != null) {
            uniAdCustomBaseLoader.onBidFail(i, i3);
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        io.dcloud.api.custom.type.UniAdCustomBaseLoader uniAdCustomBaseLoader = this.c;
        if (uniAdCustomBaseLoader != null) {
            uniAdCustomBaseLoader.onBidSuccess(i, i2);
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public void destroy() {
        io.dcloud.api.custom.type.UniAdCustomBaseLoader uniAdCustomBaseLoader = this.c;
        if (uniAdCustomBaseLoader != null) {
            uniAdCustomBaseLoader.destroy();
        }
    }

    @Override // io.dcloud.p.w1
    public int e() {
        return isSlotSupportBidding() ? 1 : 0;
    }

    @Override // io.dcloud.p.w1.a
    public void f() {
        if (getVideoAdCallback() instanceof io.dcloud.p.z3) {
            ((io.dcloud.p.z3) getVideoAdCallback()).onReward(new org.json.JSONObject());
        }
    }

    @Override // io.dcloud.p.w1
    public void g() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onVideoPlayEnd();
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public int getBiddingECPM() {
        return super.getBiddingECPM();
    }

    @Override // io.dcloud.p.w1
    public void i() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    protected void init(java.lang.String str, java.lang.String str2) {
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    public void initSDK(io.dcloud.sdk.core.adapter.IAdAdapter iAdAdapter, org.json.JSONObject jSONObject) {
        this.b = (io.dcloud.api.custom.UniAdCustomAdapter) iAdAdapter;
        this.a = jSONObject;
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public boolean isCustom() {
        return true;
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public boolean isValid() {
        io.dcloud.api.custom.type.UniAdCustomBaseLoader uniAdCustomBaseLoader = this.c;
        return uniAdCustomBaseLoader != null && uniAdCustomBaseLoader.isReady();
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    public void load(java.util.Map map) {
        io.dcloud.api.custom.base.UniAdSlot uniAdSlot = new io.dcloud.api.custom.base.UniAdSlot();
        uniAdSlot.setSlotId(getSlotId());
        uniAdSlot.setExtra(getSlot().getExtra());
        uniAdSlot.setUserId(getSlot().getUserId());
        int width = getSlot().getWidth();
        if (width <= 0) {
            width = io.dcloud.sdk.core.util.ScreenUtil.dw(getActivity());
        }
        uniAdSlot.setWidth(width);
        uniAdSlot.setHeight(getSlot().getHeight());
        uniAdSlot.setAdCount(getSlot().getCount());
        a(getActivity(), uniAdSlot);
    }

    @Override // io.dcloud.p.w1
    public void onAdClicked() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // io.dcloud.p.w1
    public void onAdShow() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // io.dcloud.p.w1
    public void onLoadFail(int i, java.lang.String str) {
        loadFail(i, str);
    }

    @Override // io.dcloud.p.w1
    public void onLoadSuccess() {
        loadSuccess();
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    public void show(android.app.Activity activity) {
        if (isValid()) {
            this.c.show(activity);
        } else if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5008, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5008));
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOLLoader
    public void showIn(android.view.ViewGroup viewGroup) {
        if (isValid()) {
            this.c.show(viewGroup);
        } else if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5008, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-5008));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements io.dcloud.api.custom.UniAdCustomAdapter.a {
        final /* synthetic */ android.app.Activity a;
        final /* synthetic */ io.dcloud.api.custom.base.UniAdSlot b;

        a(android.app.Activity activity, io.dcloud.api.custom.base.UniAdSlot uniAdSlot) {
            this.a = activity;
            this.b = uniAdSlot;
        }

        @Override // io.dcloud.api.custom.UniAdCustomAdapter.a
        public void a() {
            io.dcloud.p.m0.this.c.a(this.a, this.b, io.dcloud.p.m0.this);
            io.dcloud.p.m0.this.b.removeInitListener(this);
        }

        @Override // io.dcloud.api.custom.UniAdCustomAdapter.a
        public void a(int i, java.lang.String str) {
            io.dcloud.p.m0.this.loadFail(i, str);
            io.dcloud.p.m0.this.b.removeInitListener(this);
        }
    }

    public void a(io.dcloud.api.custom.type.UniAdCustomBaseLoader uniAdCustomBaseLoader) {
        this.c = uniAdCustomBaseLoader;
    }

    @Override // io.dcloud.p.w1
    public void b() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onSkip();
        }
    }

    @Override // io.dcloud.p.w1
    public void onLoadSuccess(java.util.List list) {
        if (list == null || list.isEmpty()) {
            loadFail(-5004, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(200000));
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            io.dcloud.api.custom.type.feed.UniAdCustomNativeAd uniAdCustomNativeAd = (io.dcloud.api.custom.type.feed.UniAdCustomNativeAd) it.next();
            io.dcloud.p.n0 n0Var = new io.dcloud.p.n0(getSlot(), getActivity());
            n0Var.a(uniAdCustomNativeAd);
            if (isSlotSupportBidding()) {
                n0Var.setBiddingECPM(uniAdCustomNativeAd.getBidPrice());
            }
            arrayList.add(n0Var);
        }
        loadSuccess(arrayList);
    }

    public void a(android.app.Activity activity, io.dcloud.api.custom.base.UniAdSlot uniAdSlot) {
        if (this.c != null) {
            io.dcloud.api.custom.UniAdCustomAdapter uniAdCustomAdapter = this.b;
            if (uniAdCustomAdapter != null) {
                if (uniAdCustomAdapter.isInitSuccess()) {
                    this.c.a(activity, uniAdSlot, this);
                    return;
                }
                this.b.addInitListener(new io.dcloud.p.m0.a(activity, uniAdSlot));
                try {
                    this.b.setPrivacyConfig(new io.dcloud.api.custom.base.UniAdPrivacyConfig(io.dcloud.sdk.core.util.AdUtil.getCustomPrivacyConfig()));
                    this.b.init(getActivity(), this.a);
                    return;
                } catch (java.lang.Exception unused) {
                    loadFail(-4001, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-4001));
                    return;
                }
            }
            loadFail(-4001, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-4001));
            return;
        }
        loadFail(-4001, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-4001));
    }

    @Override // io.dcloud.p.w1
    public void a(int i, java.lang.String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5100, "type:" + getType() + ";code:" + i + ";message:" + str);
        }
    }
}
