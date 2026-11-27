package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface IReqListener {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public enum NetState {
        NET_INIT,
        NET_REQUEST_BEGIN,
        NET_TIMEOUT,
        NET_CONNECTED,
        NET_ERROR,
        NET_HANDLE_BEGIN,
        NET_HANDLE_ING,
        NET_HANDLE_END,
        NET_PAUSE
    }

    void onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState netState, boolean z);

    int onReceiving(java.io.InputStream inputStream) throws java.lang.Exception;

    void onResponsing(java.io.InputStream inputStream);
}
