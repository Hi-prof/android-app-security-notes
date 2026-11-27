package io.dcloud.feature.barcode2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class BarcodeFeatureImpl implements io.dcloud.common.DHInterface.IFeature, io.dcloud.common.DHInterface.IWaiter {
    io.dcloud.feature.barcode2.BarcodeProxyMgr mBProxyMgr;

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
        this.mBProxyMgr.onDestroy();
    }

    @Override // io.dcloud.common.DHInterface.IWaiter
    public java.lang.Object doForFeature(java.lang.String str, java.lang.Object obj) {
        return this.mBProxyMgr.doForFeature(str, obj);
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        return this.mBProxyMgr.execute(iWebview, str, strArr);
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        io.dcloud.feature.barcode2.BarcodeProxyMgr barcodeProxyMgr = io.dcloud.feature.barcode2.BarcodeProxyMgr.getBarcodeProxyMgr();
        this.mBProxyMgr = barcodeProxyMgr;
        barcodeProxyMgr.setFeatureMgr(absMgr);
    }
}
