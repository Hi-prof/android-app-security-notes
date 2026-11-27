package io.dcloud.common.DHInterface.message;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class ActionBus {
    private static io.dcloud.common.DHInterface.message.ActionBus instance = new io.dcloud.common.DHInterface.message.ActionBus();
    java.util.Set<java.lang.Class<? extends io.dcloud.common.DHInterface.message.action.IAction>> supportMessageType = new java.util.concurrent.CopyOnWriteArraySet();
    java.util.Map<io.dcloud.common.DHInterface.message.EnumUniqueID, io.dcloud.common.DHInterface.message.AbsActionObserver> observers = new java.util.concurrent.ConcurrentHashMap();

    private ActionBus() {
        this.supportMessageType.add(io.dcloud.common.DHInterface.message.action.BadgeSyncAction.class);
        this.supportMessageType.add(io.dcloud.common.DHInterface.message.action.AppOnTrimMemoryAction.class);
        this.supportMessageType.add(io.dcloud.common.DHInterface.message.action.AppOnConfigChangedAction.class);
        this.supportMessageType.add(io.dcloud.common.DHInterface.message.action.AppOnCreateAction.class);
        this.supportMessageType.add(io.dcloud.common.DHInterface.message.action.WebActivityOnDestroyAction.class);
        this.supportMessageType.add(io.dcloud.common.DHInterface.message.action.PermissionRequestAction.class);
    }

    public static io.dcloud.common.DHInterface.message.ActionBus getInstance() {
        return instance;
    }

    public boolean observeAction(io.dcloud.common.DHInterface.message.AbsActionObserver absActionObserver) {
        if (absActionObserver == null || this.observers.containsKey(absActionObserver.getObserverUniqueID())) {
            return false;
        }
        this.observers.put(absActionObserver.getObserverUniqueID(), absActionObserver);
        return true;
    }

    public boolean sendToBus(io.dcloud.common.DHInterface.message.action.IAction iAction) {
        if (iAction == null || !this.supportMessageType.contains(iAction.getClass())) {
            return false;
        }
        for (io.dcloud.common.DHInterface.message.AbsActionObserver absActionObserver : this.observers.values()) {
            if (absActionObserver != null) {
                absActionObserver.handleMessage(iAction);
            }
        }
        return true;
    }

    public void stopObserve(io.dcloud.common.DHInterface.message.EnumUniqueID enumUniqueID) {
        this.observers.remove(enumUniqueID);
    }
}
