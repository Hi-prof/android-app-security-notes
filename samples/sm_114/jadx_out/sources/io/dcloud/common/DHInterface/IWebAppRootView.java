package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IWebAppRootView {
    boolean didCloseSplash();

    io.dcloud.common.DHInterface.IFrameView findFrameViewB(io.dcloud.common.DHInterface.IFrameView iFrameView);

    void goHome(io.dcloud.common.DHInterface.IFrameView iFrameView);

    android.view.View obtainMainView();

    void onAppActive(io.dcloud.common.DHInterface.IApp iApp);

    void onAppStart(io.dcloud.common.DHInterface.IApp iApp);

    void onAppStop(io.dcloud.common.DHInterface.IApp iApp);

    void onAppUnActive(io.dcloud.common.DHInterface.IApp iApp);

    void onRootViewGlobalLayout(android.view.View view);
}
