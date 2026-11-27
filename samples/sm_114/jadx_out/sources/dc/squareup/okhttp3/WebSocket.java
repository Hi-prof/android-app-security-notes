package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface WebSocket {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface Factory {
        dc.squareup.okhttp3.WebSocket newWebSocket(dc.squareup.okhttp3.Request request, dc.squareup.okhttp3.WebSocketListener webSocketListener);
    }

    void cancel();

    boolean close(int i, java.lang.String str);

    long queueSize();

    dc.squareup.okhttp3.Request request();

    boolean send(dc.squareup.okio.ByteString byteString);

    boolean send(java.lang.String str);
}
