package io.dcloud.api.custom;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class UniAdCustomAdapter implements io.dcloud.sdk.core.adapter.IAdAdapter {
    private boolean a = false;
    private final java.util.List b = new java.util.concurrent.CopyOnWriteArrayList();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface a {
        void a();

        void a(int i, java.lang.String str);
    }

    public final void addInitListener(io.dcloud.api.custom.UniAdCustomAdapter.a aVar) {
        if (this.b.contains(aVar)) {
            return;
        }
        this.b.add(aVar);
    }

    @Override // io.dcloud.sdk.core.adapter.IAdAdapter
    public final io.dcloud.sdk.core.module.DCBaseAOLLoader getAd(android.app.Activity activity, io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot) {
        io.dcloud.api.custom.type.UniAdCustomBaseLoader adsByType = getAdsByType(dCloudAOLSlot.getType());
        if (adsByType == null) {
            return null;
        }
        int type = dCloudAOLSlot.getType();
        if (type != 1) {
            if (type != 4) {
                if (type != 7) {
                    if (type != 15) {
                        if (type != 9) {
                            if (type != 10 || !(adsByType instanceof io.dcloud.api.custom.type.draw.UniAdCustomDrawAdLoader)) {
                                return null;
                            }
                        } else if (!(adsByType instanceof io.dcloud.api.custom.type.reward.UniAdCustomRewardLoader)) {
                            return null;
                        }
                    } else if (!(adsByType instanceof io.dcloud.api.custom.type.interstitial.UniAdCustomInterstitialLoader)) {
                        return null;
                    }
                } else if (!(adsByType instanceof io.dcloud.api.custom.type.full.UniAdCustomFullScreenVideoLoader)) {
                    return null;
                }
            } else if (!(adsByType instanceof io.dcloud.api.custom.type.feed.UniAdCustomNativeAdLoader)) {
                return null;
            }
        } else if (!(adsByType instanceof io.dcloud.api.custom.type.splash.UniAdCustomSplashLoader)) {
            return null;
        }
        io.dcloud.p.m0 m0Var = new io.dcloud.p.m0(dCloudAOLSlot, activity);
        m0Var.a(adsByType);
        return m0Var;
    }

    @Override // io.dcloud.sdk.core.adapter.IAdAdapter
    public final java.lang.String getAdapterSDKVersion() {
        return java.lang.String.valueOf(getAdapterVersion());
    }

    public abstract int getAdapterVersion();

    public abstract io.dcloud.api.custom.type.UniAdCustomBaseLoader getAdsByType(int i);

    @Override // io.dcloud.sdk.core.adapter.IAdAdapter
    public abstract java.lang.String getSDKVersion();

    public final boolean isInitSuccess() {
        return this.a;
    }

    @Override // io.dcloud.sdk.core.adapter.IAdAdapter
    public final boolean isSupport() {
        return true;
    }

    public final void onInitFail(int i, java.lang.String str) {
        this.a = false;
        java.util.Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((io.dcloud.api.custom.UniAdCustomAdapter.a) it.next()).a(i, str);
        }
    }

    public final void onInitSuccess() {
        this.a = true;
        java.util.Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((io.dcloud.api.custom.UniAdCustomAdapter.a) it.next()).a();
        }
    }

    public final void removeInitListener(io.dcloud.api.custom.UniAdCustomAdapter.a aVar) {
        this.b.remove(aVar);
    }

    public void setPrivacyConfig(io.dcloud.api.custom.base.UniAdPrivacyConfig uniAdPrivacyConfig) {
    }

    @Override // io.dcloud.sdk.core.adapter.IAdAdapter
    public final void updatePrivacyConfig(io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig) {
        setPrivacyConfig(new io.dcloud.api.custom.base.UniAdPrivacyConfig(privacyConfig));
    }
}
