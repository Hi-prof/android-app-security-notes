package io.dcloud.api.custom.type.feed;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class UniAdCustomNativeAd {
    protected io.dcloud.p.x1 a;
    private int b = 0;

    public void a(io.dcloud.p.x1 x1Var) {
        this.a = x1Var;
        render();
    }

    public abstract void destroy();

    public final int getBidPrice() {
        return this.b;
    }

    public abstract android.view.View getNativeAd();

    public final void onAdClicked() {
        io.dcloud.p.x1 x1Var = this.a;
        if (x1Var != null) {
            x1Var.onAdClicked();
        }
    }

    public final void onAdClosed(java.lang.String str) {
        io.dcloud.p.x1 x1Var = this.a;
        if (x1Var != null) {
            x1Var.a(str);
        }
    }

    public final void onAdShow() {
        io.dcloud.p.x1 x1Var = this.a;
        if (x1Var != null) {
            x1Var.onAdShow();
        }
    }

    public void onBidFail(int i, int i2) {
    }

    public void onBidSuccess(int i, int i2) {
    }

    public void onRenderFail(int i, java.lang.String str) {
        io.dcloud.p.x1 x1Var = this.a;
        if (x1Var != null) {
            x1Var.onRenderFail();
        }
    }

    public void onRenderSuccess() {
        io.dcloud.p.x1 x1Var = this.a;
        if (x1Var != null) {
            x1Var.onRenderSuccess();
        }
    }

    public final void onShowError(int i, java.lang.String str) {
        io.dcloud.p.x1 x1Var = this.a;
        if (x1Var != null) {
            x1Var.onShowError(i, str);
        }
    }

    public abstract void render();

    public final void setBidPrice(int i) {
        this.b = i;
    }
}
