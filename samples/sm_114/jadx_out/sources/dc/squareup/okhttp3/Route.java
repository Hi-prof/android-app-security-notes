package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Route {
    final dc.squareup.okhttp3.Address address;
    final java.net.InetSocketAddress inetSocketAddress;
    final java.net.Proxy proxy;

    public Route(dc.squareup.okhttp3.Address address, java.net.Proxy proxy, java.net.InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new java.lang.NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new java.lang.NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new java.lang.NullPointerException("inetSocketAddress == null");
        }
        this.address = address;
        this.proxy = proxy;
        this.inetSocketAddress = inetSocketAddress;
    }

    public dc.squareup.okhttp3.Address address() {
        return this.address;
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof dc.squareup.okhttp3.Route)) {
            return false;
        }
        dc.squareup.okhttp3.Route route = (dc.squareup.okhttp3.Route) obj;
        return route.address.equals(this.address) && route.proxy.equals(this.proxy) && route.inetSocketAddress.equals(this.inetSocketAddress);
    }

    public int hashCode() {
        return ((((this.address.hashCode() + 527) * 31) + this.proxy.hashCode()) * 31) + this.inetSocketAddress.hashCode();
    }

    public java.net.Proxy proxy() {
        return this.proxy;
    }

    public boolean requiresTunnel() {
        return this.address.sslSocketFactory != null && this.proxy.type() == java.net.Proxy.Type.HTTP;
    }

    public java.net.InetSocketAddress socketAddress() {
        return this.inetSocketAddress;
    }

    public java.lang.String toString() {
        return "Route{" + this.inetSocketAddress + com.taobao.weex.el.parse.Operators.BLOCK_END_STR;
    }
}
