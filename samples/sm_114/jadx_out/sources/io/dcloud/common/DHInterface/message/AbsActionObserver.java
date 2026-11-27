package io.dcloud.common.DHInterface.message;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbsActionObserver {
    io.dcloud.common.DHInterface.message.IObserveAble observeAble;

    public AbsActionObserver(io.dcloud.common.DHInterface.message.IObserveAble iObserveAble) {
        this.observeAble = iObserveAble;
    }

    public io.dcloud.common.DHInterface.message.EnumUniqueID getObserverUniqueID() {
        return this.observeAble.getActionObserverID();
    }

    public abstract boolean handleMessage(io.dcloud.common.DHInterface.message.action.IAction iAction);
}
