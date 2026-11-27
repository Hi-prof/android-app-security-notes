package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface ICore {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface ICoreEvent {
        public static final int CHECK_IS_IBOOT_SERVICES = 1;
        public static final int GET_SDK_MODE = -1;
        public static final int WEBAPP_QUIT = 0;
        public static final int WEBAPP_START = 2;
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface ICoreStatusListener {
        void onCoreInitEnd(io.dcloud.common.DHInterface.ICore iCore);

        void onCoreReady(io.dcloud.common.DHInterface.ICore iCore);

        boolean onCoreStop();
    }

    java.lang.Object dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType mgrType, int i, java.lang.Object obj);

    android.content.Context obtainActivityContext();

    android.content.Context obtainContext();

    boolean onActivityExecute(android.app.Activity activity, io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj);

    void onRestart(android.content.Context context);

    void setmCoreListener(io.dcloud.common.DHInterface.ICore.ICoreStatusListener iCoreStatusListener);
}
