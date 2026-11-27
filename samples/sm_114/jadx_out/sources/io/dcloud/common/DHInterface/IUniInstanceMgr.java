package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IUniInstanceMgr {
    void initUniappPlugin(android.app.Application application);

    void initWeexEnv(io.dcloud.common.DHInterface.INativeAppInfo iNativeAppInfo);

    boolean isUniAppAssetsRes();

    void loadWeexToAppid(android.content.Context context, java.lang.String str, boolean z);

    void onCreateProcess(android.app.Application application, java.lang.Boolean bool);

    void registerUniappService(android.content.Context context, java.lang.String str);

    void restartWeex(android.app.Application application, io.dcloud.common.DHInterface.ICallBack iCallBack, java.lang.String str);
}
