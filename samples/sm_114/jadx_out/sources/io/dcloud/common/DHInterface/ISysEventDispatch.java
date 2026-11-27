package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface ISysEventDispatch {
    boolean callSysEventListener(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj);

    void registerSysEventListener(io.dcloud.common.DHInterface.ISysEventListener iSysEventListener, io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType);

    void unRegisterSysEventListener(io.dcloud.common.DHInterface.ISysEventListener iSysEventListener, io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType);
}
