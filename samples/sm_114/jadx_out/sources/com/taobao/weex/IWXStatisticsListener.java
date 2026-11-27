package com.taobao.weex;

/* JADX INFO: loaded from: classes.dex */
public interface IWXStatisticsListener {
    void onException(java.lang.String str, java.lang.String str2, java.lang.String str3);

    void onFirstScreen();

    void onFirstView();

    void onHeadersReceived();

    void onHttpFinish();

    void onHttpStart();

    void onJsFrameworkReady();

    void onJsFrameworkStart();

    void onSDKEngineInitialize();
}
