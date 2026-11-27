package dc.squareup.okhttp3.internal.proxy;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class NullProxySelector extends java.net.ProxySelector {
    @Override // java.net.ProxySelector
    public void connectFailed(java.net.URI uri, java.net.SocketAddress socketAddress, java.io.IOException iOException) {
    }

    @Override // java.net.ProxySelector
    public java.util.List<java.net.Proxy> select(java.net.URI uri) {
        if (uri != null) {
            return java.util.Collections.singletonList(java.net.Proxy.NO_PROXY);
        }
        throw new java.lang.IllegalArgumentException("uri must not be null");
    }
}
