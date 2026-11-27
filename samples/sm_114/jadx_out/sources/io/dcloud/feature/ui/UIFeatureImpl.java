package io.dcloud.feature.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class UIFeatureImpl extends io.dcloud.common.DHInterface.BaseFeature implements io.dcloud.common.DHInterface.IWaiter {
    io.dcloud.feature.ui.e a = null;

    @Override // io.dcloud.common.DHInterface.BaseFeature, io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
        this.a.b(str);
    }

    @Override // io.dcloud.common.DHInterface.IWaiter
    public java.lang.Object doForFeature(java.lang.String str, java.lang.Object obj) {
        io.dcloud.feature.ui.c cVarA;
        if ("findWebview".equals(str)) {
            java.lang.String[] strArr = (java.lang.String[]) obj;
            java.lang.String str2 = strArr[0];
            java.lang.String str3 = strArr[1];
            io.dcloud.feature.ui.a aVar = (io.dcloud.feature.ui.a) this.a.b.get(str2);
            if (aVar == null || (cVarA = aVar.a(str3, str3, str3)) == null) {
                return null;
            }
            return cVarA.y.obtainWebView();
        }
        return null;
    }

    @Override // io.dcloud.common.DHInterface.BaseFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONArray jSONArray) {
        return io.dcloud.common.constant.AbsoluteConst.UNI_SYNC_EXEC_METHOD.equals(str) ? this.a.a(iWebview, str, jSONArray) : this.a.b(iWebview, str, jSONArray);
    }

    @Override // io.dcloud.common.DHInterface.BaseFeature, io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        this.a = new io.dcloud.feature.ui.e(absMgr, str);
    }
}
