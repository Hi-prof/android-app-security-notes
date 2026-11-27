package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Address {
    final dc.squareup.okhttp3.CertificatePinner certificatePinner;
    final java.util.List<dc.squareup.okhttp3.ConnectionSpec> connectionSpecs;
    final dc.squareup.okhttp3.Dns dns;
    final javax.net.ssl.HostnameVerifier hostnameVerifier;
    final java.util.List<dc.squareup.okhttp3.Protocol> protocols;
    final java.net.Proxy proxy;
    final dc.squareup.okhttp3.Authenticator proxyAuthenticator;
    final java.net.ProxySelector proxySelector;
    final javax.net.SocketFactory socketFactory;
    final javax.net.ssl.SSLSocketFactory sslSocketFactory;
    final dc.squareup.okhttp3.HttpUrl url;

    public Address(java.lang.String str, int i, dc.squareup.okhttp3.Dns dns, javax.net.SocketFactory socketFactory, javax.net.ssl.SSLSocketFactory sSLSocketFactory, javax.net.ssl.HostnameVerifier hostnameVerifier, dc.squareup.okhttp3.CertificatePinner certificatePinner, dc.squareup.okhttp3.Authenticator authenticator, java.net.Proxy proxy, java.util.List<dc.squareup.okhttp3.Protocol> list, java.util.List<dc.squareup.okhttp3.ConnectionSpec> list2, java.net.ProxySelector proxySelector) {
        this.url = new dc.squareup.okhttp3.HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(str).port(i).build();
        if (dns == null) {
            throw new java.lang.NullPointerException("dns == null");
        }
        this.dns = dns;
        if (socketFactory == null) {
            throw new java.lang.NullPointerException("socketFactory == null");
        }
        this.socketFactory = socketFactory;
        if (authenticator == null) {
            throw new java.lang.NullPointerException("proxyAuthenticator == null");
        }
        this.proxyAuthenticator = authenticator;
        if (list == null) {
            throw new java.lang.NullPointerException("protocols == null");
        }
        this.protocols = dc.squareup.okhttp3.internal.Util.immutableList(list);
        if (list2 == null) {
            throw new java.lang.NullPointerException("connectionSpecs == null");
        }
        this.connectionSpecs = dc.squareup.okhttp3.internal.Util.immutableList(list2);
        if (proxySelector == null) {
            throw new java.lang.NullPointerException("proxySelector == null");
        }
        this.proxySelector = proxySelector;
        this.proxy = proxy;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
    }

    public dc.squareup.okhttp3.CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public java.util.List<dc.squareup.okhttp3.ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public dc.squareup.okhttp3.Dns dns() {
        return this.dns;
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof dc.squareup.okhttp3.Address)) {
            return false;
        }
        dc.squareup.okhttp3.Address address = (dc.squareup.okhttp3.Address) obj;
        return this.url.equals(address.url) && equalsNonHost(address);
    }

    boolean equalsNonHost(dc.squareup.okhttp3.Address address) {
        return this.dns.equals(address.dns) && this.proxyAuthenticator.equals(address.proxyAuthenticator) && this.protocols.equals(address.protocols) && this.connectionSpecs.equals(address.connectionSpecs) && this.proxySelector.equals(address.proxySelector) && dc.squareup.okhttp3.internal.Util.equal(this.proxy, address.proxy) && dc.squareup.okhttp3.internal.Util.equal(this.sslSocketFactory, address.sslSocketFactory) && dc.squareup.okhttp3.internal.Util.equal(this.hostnameVerifier, address.hostnameVerifier) && dc.squareup.okhttp3.internal.Util.equal(this.certificatePinner, address.certificatePinner) && url().port() == address.url().port();
    }

    public int hashCode() {
        int iHashCode = (((((((((((this.url.hashCode() + 527) * 31) + this.dns.hashCode()) * 31) + this.proxyAuthenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode()) * 31;
        java.net.Proxy proxy = this.proxy;
        int iHashCode2 = (iHashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        javax.net.ssl.SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
        int iHashCode3 = (iHashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        javax.net.ssl.HostnameVerifier hostnameVerifier = this.hostnameVerifier;
        int iHashCode4 = (iHashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        dc.squareup.okhttp3.CertificatePinner certificatePinner = this.certificatePinner;
        return iHashCode4 + (certificatePinner != null ? certificatePinner.hashCode() : 0);
    }

    public javax.net.ssl.HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public java.util.List<dc.squareup.okhttp3.Protocol> protocols() {
        return this.protocols;
    }

    public java.net.Proxy proxy() {
        return this.proxy;
    }

    public dc.squareup.okhttp3.Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public java.net.ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public javax.net.SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public javax.net.ssl.SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Address{");
        sb.append(this.url.host());
        sb.append(":");
        sb.append(this.url.port());
        if (this.proxy != null) {
            sb.append(", proxy=");
            sb.append(this.proxy);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.proxySelector);
        }
        sb.append(com.taobao.weex.el.parse.Operators.BLOCK_END_STR);
        return sb.toString();
    }

    public dc.squareup.okhttp3.HttpUrl url() {
        return this.url;
    }
}
