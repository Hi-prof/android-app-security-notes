package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class n0 extends io.dcloud.sdk.core.module.DCBaseAOL implements io.dcloud.p.x1, io.dcloud.p.x1.a {
    private io.dcloud.api.custom.type.feed.UniAdCustomNativeAd a;
    private int b;

    public n0(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, android.app.Activity activity) {
        super(dCloudAOLSlot, activity);
        this.b = 0;
    }

    public void a(io.dcloud.api.custom.type.feed.UniAdCustomNativeAd uniAdCustomNativeAd) {
        this.a = uniAdCustomNativeAd;
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        io.dcloud.api.custom.type.feed.UniAdCustomNativeAd uniAdCustomNativeAd = this.a;
        if (uniAdCustomNativeAd != null) {
            uniAdCustomNativeAd.onBidFail(i, i3);
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        io.dcloud.api.custom.type.feed.UniAdCustomNativeAd uniAdCustomNativeAd = this.a;
        if (uniAdCustomNativeAd != null) {
            uniAdCustomNativeAd.onBidSuccess(i, i2);
        }
    }

    @Override // io.dcloud.p.x1.a
    public void c() {
        if (getFeedAdCallback() instanceof io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onPause();
        }
    }

    @Override // io.dcloud.p.x1.a
    public void d() {
        if (getFeedAdCallback() instanceof io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onStart();
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public void destroy() {
        io.dcloud.api.custom.type.feed.UniAdCustomNativeAd uniAdCustomNativeAd = this.a;
        if (uniAdCustomNativeAd != null) {
            uniAdCustomNativeAd.destroy();
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public android.view.View getExpressAdView(android.app.Activity activity) {
        io.dcloud.api.custom.type.feed.UniAdCustomNativeAd uniAdCustomNativeAd = this.a;
        return uniAdCustomNativeAd != null ? uniAdCustomNativeAd.getNativeAd() : super.getExpressAdView(activity);
    }

    @Override // io.dcloud.p.x1.a
    public void h() {
        if (getFeedAdCallback() instanceof io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onResume();
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public boolean isCustom() {
        return true;
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public boolean isValid() {
        return true;
    }

    @Override // io.dcloud.p.x1
    public void onAdClicked() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onClicked();
        }
    }

    @Override // io.dcloud.p.x1
    public void onAdShow() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onShow();
        }
    }

    @Override // io.dcloud.p.x1
    public void onRenderFail() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onRenderFail();
        }
        this.b = -1;
    }

    @Override // io.dcloud.p.x1
    public void onRenderSuccess() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onRenderSuccess();
        }
        this.b = 1;
    }

    @Override // io.dcloud.p.x1
    public void onShowError(int i, java.lang.String str) {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onShowError();
        }
    }

    @Override // io.dcloud.p.x1.a
    public void onVideoPlayEnd() {
        if (getFeedAdCallback() instanceof io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onEnd();
        }
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public void render() {
        try {
            io.dcloud.api.custom.type.feed.UniAdCustomNativeAd uniAdCustomNativeAd = this.a;
            if (uniAdCustomNativeAd == null) {
                if (getFeedAdCallback() != null) {
                    getFeedAdCallback().onRenderFail();
                }
                this.b = -1;
                return;
            }
            int i = this.b;
            if (i == 1) {
                if (getFeedAdCallback() != null) {
                    getFeedAdCallback().onRenderSuccess();
                }
            } else if (i != -1) {
                uniAdCustomNativeAd.a(this);
            } else if (getFeedAdCallback() != null) {
                getFeedAdCallback().onRenderFail();
            }
        } catch (java.lang.Throwable unused) {
            if (getFeedAdCallback() != null) {
                getFeedAdCallback().onRenderFail();
            }
            this.b = -1;
        }
    }

    @Override // io.dcloud.p.x1
    public void a(java.lang.String str) {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onClosed(str);
        }
    }

    @Override // io.dcloud.p.x1.a
    public void a() {
        if (getFeedAdCallback() instanceof io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener) {
            ((io.dcloud.sdk.core.interfaces.AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onError();
        }
    }
}
