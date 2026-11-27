package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IFrameView extends io.dcloud.common.DHInterface.IFrameViewStatus, io.dcloud.common.DHInterface.IContainerView {
    public static final byte TRANS_CUSTOM = 2;
    public static final byte TRANS_FIRST = 0;
    public static final byte TRANS_SECOND = 1;
    public static final int WIN_DIRECT_PAGE = 5;
    public static final int WIN_HD_PAGE = 6;
    public static final int WIN_LAUNCH_PAGE = 2;
    public static final int WIN_SECOND_PAGE = 4;
    public static final int WIN_TAB_PAGE = 8;
    public static final int WIN_TYPE_COMMON = 0;
    public static final int WIN_TYPE_PAGE = 1;
    public static final int WIN_UNI_SERVICE = 7;
    public static final int WIN_WAP_PAGE = 3;

    void animate(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2);

    void captureSnapshot(java.lang.String str, io.dcloud.common.DHInterface.ICallBack iCallBack, io.dcloud.common.DHInterface.ICallBack iCallBack2);

    void clearSnapshot(java.lang.String str);

    void draw(android.view.View view, io.dcloud.common.DHInterface.INativeBitmap iNativeBitmap, boolean z, boolean z2, boolean z3, android.graphics.Rect rect, java.lang.String str, io.dcloud.common.DHInterface.ICallBack iCallBack, io.dcloud.common.DHInterface.ICallBack iCallBack2);

    io.dcloud.common.DHInterface.IFrameView findPageB();

    android.content.Context getContext();

    int getFrameType();

    void interceptTouchEvent(boolean z);

    boolean isWebviewCovered();

    io.dcloud.common.DHInterface.IApp obtainApp();

    android.view.View obtainMainView();

    io.dcloud.common.DHInterface.IWebAppRootView obtainWebAppRootView();

    io.dcloud.common.DHInterface.IWebview obtainWebView();

    io.dcloud.common.adapter.ui.AdaWebViewParent obtainWebviewParent();

    io.dcloud.common.DHInterface.AbsMgr obtainWindowMgr();

    void popFromViewStack();

    void pushToViewStack();

    void restore();

    void setAccelerationType(java.lang.String str);

    void setFrameOptions_Animate(io.dcloud.common.adapter.util.ViewOptions viewOptions);

    void setNeedRender(boolean z);

    void setSnapshot(android.graphics.Bitmap bitmap);

    void setSnapshotView(io.dcloud.common.DHInterface.INativeView iNativeView, java.lang.String str);

    void setVisible(boolean z, boolean z2);

    void transition(byte b);
}
