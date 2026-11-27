package io.dcloud.common.core.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class d extends io.dcloud.common.adapter.ui.AdaUniWebView {
    protected d(android.content.Context context, io.dcloud.common.core.ui.b bVar, java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject, boolean z) {
        super(context, bVar.obtainApp(), bVar, str, str2, jSONObject, z);
        bVar.l = this;
        bVar.m = getWebviewParent();
    }

    @Override // io.dcloud.common.adapter.ui.AdaUniWebView, io.dcloud.common.DHInterface.IWebview
    public io.dcloud.common.DHInterface.IApp obtainApp() {
        if (obtainFrameView() != null) {
            return obtainFrameView().obtainApp();
        }
        return null;
    }
}
