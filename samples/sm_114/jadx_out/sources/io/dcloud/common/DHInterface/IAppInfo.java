package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IAppInfo extends io.dcloud.common.DHInterface.IType_IntValue, io.dcloud.common.DHInterface.IType_Layout_Changed {
    void clearMaskLayerCount();

    android.app.Activity getActivity();

    io.dcloud.common.adapter.util.ViewRect getAppViewRect();

    @Override // io.dcloud.common.DHInterface.IType_IntValue
    /* synthetic */ int getInt(int i);

    int getMaskLayerCount();

    io.dcloud.common.DHInterface.IOnCreateSplashView getOnCreateSplashView();

    int getRequestedOrientation();

    boolean isFullScreen();

    boolean isVerticalScreen();

    io.dcloud.common.DHInterface.IWebAppRootView obtainWebAppRootView();

    void setFullScreen(boolean z);

    void setMaskLayer(boolean z);

    void setOnCreateSplashView(io.dcloud.common.DHInterface.IOnCreateSplashView iOnCreateSplashView);

    void setRequestedOrientation(int i);

    void setRequestedOrientation(java.lang.String str);

    void setWebAppRootView(io.dcloud.common.DHInterface.IWebAppRootView iWebAppRootView);

    void updateScreenInfo(int i);
}
