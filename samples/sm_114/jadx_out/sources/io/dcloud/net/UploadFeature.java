package io.dcloud.net;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class UploadFeature implements io.dcloud.common.DHInterface.IFeature {
    private io.dcloud.net.JsUploadMgr mJsUploadMgr;

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        this.mJsUploadMgr.execute(iWebview, str, strArr);
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        this.mJsUploadMgr = new io.dcloud.net.JsUploadMgr();
    }
}
