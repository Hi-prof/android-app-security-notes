package io.dcloud.feature.sensor;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AccelerometerFeatureImpl implements io.dcloud.common.DHInterface.IFeature {
    private io.dcloud.feature.sensor.b a;

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
        this.a.a(str);
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        return this.a.a(iWebview, str, strArr);
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        this.a = new io.dcloud.feature.sensor.b(absMgr.getContext());
    }
}
