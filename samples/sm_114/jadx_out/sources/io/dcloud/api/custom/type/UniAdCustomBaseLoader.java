package io.dcloud.api.custom.type;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class UniAdCustomBaseLoader {
    protected io.dcloud.p.w1 a;

    public final void a(android.app.Activity activity, io.dcloud.api.custom.base.UniAdSlot uniAdSlot, io.dcloud.p.w1 w1Var) {
        this.a = w1Var;
        try {
            load(activity, uniAdSlot);
        } catch (java.lang.Throwable unused) {
            onLoadFail(-4002, io.dcloud.sdk.core.util.AOLErrorUtil.getErrorMsg(-4002));
        }
    }

    public abstract void destroy();

    public int getBidType() {
        io.dcloud.p.w1 w1Var = this.a;
        if (w1Var != null) {
            return w1Var.e();
        }
        return 0;
    }

    public abstract boolean isReady();

    public abstract void load(android.app.Activity activity, io.dcloud.api.custom.base.UniAdSlot uniAdSlot);

    public void onAdClicked() {
        io.dcloud.p.w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.onAdClicked();
        }
    }

    public void onAdClosed() {
        io.dcloud.p.w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.i();
        }
    }

    public void onAdPlayEnd() {
        io.dcloud.p.w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.g();
        }
    }

    public void onAdPlayError(int i, java.lang.String str) {
        io.dcloud.p.w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.a(i, str);
        }
    }

    public void onAdShow() {
        io.dcloud.p.w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.onAdShow();
        }
    }

    public void onAdSkip() {
        io.dcloud.p.w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.b();
        }
    }

    public void onBidFail(int i, int i2) {
    }

    public void onBidSuccess(int i, int i2) {
    }

    public void onLoadFail(int i, java.lang.String str) {
        io.dcloud.p.w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.onLoadFail(i, str);
        }
    }

    public void onLoadSuccess(java.util.List<? extends io.dcloud.api.custom.type.feed.UniAdCustomNativeAd> list) {
        io.dcloud.p.w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.onLoadSuccess(list);
        }
    }

    public void setBidPrice(int i) {
        java.lang.Object obj = this.a;
        if ((obj instanceof io.dcloud.sdk.core.module.DCBaseAOL) && ((io.dcloud.sdk.core.module.DCBaseAOL) obj).isSlotSupportBidding()) {
            ((io.dcloud.sdk.core.module.DCBaseAOL) this.a).setBiddingECPM(i);
        }
    }

    public abstract void show(java.lang.Object obj);

    public void onLoadSuccess() {
        io.dcloud.p.w1 w1Var = this.a;
        if (w1Var != null) {
            w1Var.onLoadSuccess();
        }
    }
}
