package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class EventListener {
    public static final dc.squareup.okhttp3.EventListener NONE = new dc.squareup.okhttp3.EventListener() { // from class: dc.squareup.okhttp3.EventListener.1
    };

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface Factory {
        dc.squareup.okhttp3.EventListener create(dc.squareup.okhttp3.Call call);
    }

    static dc.squareup.okhttp3.EventListener.Factory factory(dc.squareup.okhttp3.EventListener eventListener) {
        return new dc.squareup.okhttp3.EventListener.Factory() { // from class: dc.squareup.okhttp3.EventListener.2
            @Override // dc.squareup.okhttp3.EventListener.Factory
            public dc.squareup.okhttp3.EventListener create(dc.squareup.okhttp3.Call call) {
                return dc.squareup.okhttp3.EventListener.this;
            }
        };
    }

    public void callEnd(dc.squareup.okhttp3.Call call) {
    }

    public void callFailed(dc.squareup.okhttp3.Call call, java.io.IOException iOException) {
    }

    public void callStart(dc.squareup.okhttp3.Call call) {
    }

    public void connectEnd(dc.squareup.okhttp3.Call call, java.net.InetSocketAddress inetSocketAddress, java.net.Proxy proxy, dc.squareup.okhttp3.Protocol protocol) {
    }

    public void connectFailed(dc.squareup.okhttp3.Call call, java.net.InetSocketAddress inetSocketAddress, java.net.Proxy proxy, dc.squareup.okhttp3.Protocol protocol, java.io.IOException iOException) {
    }

    public void connectStart(dc.squareup.okhttp3.Call call, java.net.InetSocketAddress inetSocketAddress, java.net.Proxy proxy) {
    }

    public void connectionAcquired(dc.squareup.okhttp3.Call call, dc.squareup.okhttp3.Connection connection) {
    }

    public void connectionReleased(dc.squareup.okhttp3.Call call, dc.squareup.okhttp3.Connection connection) {
    }

    public void dnsEnd(dc.squareup.okhttp3.Call call, java.lang.String str, java.util.List<java.net.InetAddress> list) {
    }

    public void dnsStart(dc.squareup.okhttp3.Call call, java.lang.String str) {
    }

    public void requestBodyEnd(dc.squareup.okhttp3.Call call, long j) {
    }

    public void requestBodyStart(dc.squareup.okhttp3.Call call) {
    }

    public void requestHeadersEnd(dc.squareup.okhttp3.Call call, dc.squareup.okhttp3.Request request) {
    }

    public void requestHeadersStart(dc.squareup.okhttp3.Call call) {
    }

    public void responseBodyEnd(dc.squareup.okhttp3.Call call, long j) {
    }

    public void responseBodyStart(dc.squareup.okhttp3.Call call) {
    }

    public void responseHeadersEnd(dc.squareup.okhttp3.Call call, dc.squareup.okhttp3.Response response) {
    }

    public void responseHeadersStart(dc.squareup.okhttp3.Call call) {
    }

    public void secureConnectEnd(dc.squareup.okhttp3.Call call, dc.squareup.okhttp3.Handshake handshake) {
    }

    public void secureConnectStart(dc.squareup.okhttp3.Call call) {
    }
}
