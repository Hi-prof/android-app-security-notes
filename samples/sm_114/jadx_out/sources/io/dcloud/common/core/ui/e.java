package io.dcloud.common.core.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class e extends io.dcloud.common.adapter.ui.AdaWebview {
    protected e(android.content.Context context, io.dcloud.common.DHInterface.AbsMgr absMgr, io.dcloud.common.core.ui.b bVar) {
        super(context, bVar);
        io.dcloud.common.adapter.util.Logger.d("dhwebview", "DHWebview0");
        bVar.l = this;
        bVar.m = getWebviewParent();
        if (!bVar.obtainFrameOptions().mDisablePlus) {
            addJsInterface("_bridge", (io.dcloud.common.DHInterface.IJsInterface) new io.dcloud.common.util.Birdge(new io.dcloud.common.core.ui.h(this)));
        }
        addJsInterface("_dlGeolocation", (io.dcloud.common.DHInterface.IJsInterface) new io.dcloud.common.util.DLGeolocation(this));
        io.dcloud.common.adapter.util.Logger.d("dhwebview", "DHWebview hashcode=" + bVar.hashCode());
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public io.dcloud.common.DHInterface.IApp obtainApp() {
        if (obtainFrameView() != null) {
            return obtainFrameView().obtainApp();
        }
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void show(android.view.animation.Animation animation) {
        io.dcloud.common.DHInterface.IFrameView iFrameViewObtainFrameView = obtainFrameView();
        ((io.dcloud.common.core.ui.b) iFrameViewObtainFrameView).setVisible(true, true);
        iFrameViewObtainFrameView.obtainWindowMgr().processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 1, new java.lang.Object[]{iFrameViewObtainFrameView, animation});
    }

    protected e(android.content.Context context, io.dcloud.common.DHInterface.AbsMgr absMgr, io.dcloud.common.core.ui.b bVar, io.dcloud.common.DHInterface.IDCloudWebviewClientListener iDCloudWebviewClientListener) {
        super(context, bVar, iDCloudWebviewClientListener);
        io.dcloud.common.adapter.util.Logger.d("dhwebview", "DHWebview0");
        bVar.l = this;
        bVar.m = getWebviewParent();
        if (!bVar.obtainFrameOptions().mDisablePlus) {
            addJsInterface("_bridge", (io.dcloud.common.DHInterface.IJsInterface) new io.dcloud.common.util.Birdge(new io.dcloud.common.core.ui.h(this)));
        }
        addJsInterface("_dlGeolocation", (io.dcloud.common.DHInterface.IJsInterface) new io.dcloud.common.util.DLGeolocation(this));
        io.dcloud.common.adapter.util.Logger.d("dhwebview", "DHWebview hashcode=" + bVar.hashCode());
    }
}
