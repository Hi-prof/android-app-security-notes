package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IActivityHandler extends io.dcloud.common.DHInterface.IActivityDelegate {
    void addClickStatusbarCallBack(io.dcloud.common.DHInterface.ICallBack iCallBack);

    void callBack(java.lang.String str, android.os.Bundle bundle);

    void closeAppStreamSplash(java.lang.String str);

    void closeSideBar();

    int getActivityState();

    android.content.Context getContext();

    android.content.Context getOriginalContext();

    java.lang.String getUrlByFilePath(java.lang.String str, java.lang.String str2);

    boolean hasAdService();

    boolean isMultiProcessMode();

    void onAsyncStartAppEnd(java.lang.String str, java.lang.Object obj);

    java.lang.Object onAsyncStartAppStart(java.lang.String str);

    void registerReceiver(io.dcloud.feature.internal.reflect.BroadcastReceiver broadcastReceiver, android.content.IntentFilter intentFilter);

    void removeClickStatusbarCallBack(io.dcloud.common.DHInterface.ICallBack iCallBack);

    void sendLocalBroadcast(android.content.Intent intent);

    void setSideBarVisibility(int i);

    void setSplashCloseListener(java.lang.String str, io.dcloud.common.DHInterface.ICallBack iCallBack);

    void setViewAsContentView(android.view.View view, android.widget.FrameLayout.LayoutParams layoutParams);

    void setWebViewIntoPreloadView(android.view.View view);

    void showSplashWaiting();

    void sideBarHideMenu();

    void sideBarShowMenu(java.lang.String str, java.lang.String str2, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str3);

    void unregisterReceiver(io.dcloud.feature.internal.reflect.BroadcastReceiver broadcastReceiver);

    void updateParam(java.lang.String str, java.lang.Object obj);

    void updateSplash(java.lang.String str);
}
