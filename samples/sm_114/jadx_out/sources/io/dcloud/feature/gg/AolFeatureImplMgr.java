package io.dcloud.feature.gg;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AolFeatureImplMgr implements io.dcloud.common.DHInterface.IReflectAble, io.dcloud.common.DHInterface.IWaiter {
    public static final /* synthetic */ int a = 0;
    static final io.dcloud.feature.gg.AolFeatureImplMgr mSingleInstance = new io.dcloud.feature.gg.AolFeatureImplMgr();
    java.lang.String mAdType = null;

    public static io.dcloud.common.DHInterface.IWaiter self() {
        return mSingleInstance;
    }

    public void clearAdType() {
        this.mAdType = null;
    }

    @Override // io.dcloud.common.DHInterface.IWaiter
    public java.lang.Object doForFeature(java.lang.String str, java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(this.mAdType)) {
            this.mAdType = io.dcloud.feature.gg.AolSplashUtil.getPlashType();
        }
        java.lang.Object objDoForFeature = io.dcloud.feature.gg.dcloud.AolFeatureImpl.doForFeature(str, obj);
        if (!str.equals("onWillCloseSplash") && !str.equals("onBack")) {
            return str.equals("adc") ? java.lang.Boolean.valueOf(io.dcloud.p.t3.a()) : objDoForFeature;
        }
        clearAdType();
        return objDoForFeature;
    }
}
