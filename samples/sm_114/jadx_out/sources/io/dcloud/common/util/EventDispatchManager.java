package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class EventDispatchManager {
    private static io.dcloud.common.util.EventDispatchManager instance;
    private java.util.List<io.dcloud.common.util.EventDispatchManager.ActivityEventDispatchListener> dispatchListeners = new java.util.ArrayList();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface ActivityEventDispatchListener {
        boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj);
    }

    private EventDispatchManager() {
    }

    public static io.dcloud.common.util.EventDispatchManager getInstance() {
        if (instance == null) {
            synchronized (io.dcloud.common.util.EventDispatchManager.class) {
                if (instance == null) {
                    instance = new io.dcloud.common.util.EventDispatchManager();
                }
            }
        }
        return instance;
    }

    public void addListener(io.dcloud.common.util.EventDispatchManager.ActivityEventDispatchListener activityEventDispatchListener) {
        if (activityEventDispatchListener != null) {
            this.dispatchListeners.add(activityEventDispatchListener);
        }
    }

    public boolean dispatchEvent(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
        boolean zOnExecute = false;
        for (int size = this.dispatchListeners.size() - 1; size >= 0; size--) {
            zOnExecute = this.dispatchListeners.get(size).onExecute(sysEventType, obj);
            if (zOnExecute) {
                return zOnExecute;
            }
        }
        return zOnExecute;
    }

    public void removeListener(io.dcloud.common.util.EventDispatchManager.ActivityEventDispatchListener activityEventDispatchListener) {
        if (activityEventDispatchListener != null) {
            this.dispatchListeners.remove(activityEventDispatchListener);
        }
    }
}
