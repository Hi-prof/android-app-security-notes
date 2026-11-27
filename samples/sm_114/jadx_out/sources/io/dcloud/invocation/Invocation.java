package io.dcloud.invocation;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class Invocation implements io.dcloud.common.DHInterface.IFeature {
    io.dcloud.p.x2 a;

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
        this.a.a(str);
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        return (!io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() || io.dcloud.feature.internal.sdk.SDK.isNJS) ? this.a.a(iWebview, str, strArr) : "";
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        this.a = new io.dcloud.p.x2(absMgr);
    }
}
