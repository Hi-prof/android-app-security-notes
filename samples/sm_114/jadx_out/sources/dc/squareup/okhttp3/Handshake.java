package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Handshake {
    private final dc.squareup.okhttp3.CipherSuite cipherSuite;
    private final java.util.List<java.security.cert.Certificate> localCertificates;
    private final java.util.List<java.security.cert.Certificate> peerCertificates;
    private final dc.squareup.okhttp3.TlsVersion tlsVersion;

    private Handshake(dc.squareup.okhttp3.TlsVersion tlsVersion, dc.squareup.okhttp3.CipherSuite cipherSuite, java.util.List<java.security.cert.Certificate> list, java.util.List<java.security.cert.Certificate> list2) {
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.peerCertificates = list;
        this.localCertificates = list2;
    }

    public static dc.squareup.okhttp3.Handshake get(javax.net.ssl.SSLSession sSLSession) throws java.io.IOException {
        java.security.cert.Certificate[] peerCertificates;
        java.lang.String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new java.lang.IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new java.io.IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        dc.squareup.okhttp3.CipherSuite cipherSuiteForJavaName = dc.squareup.okhttp3.CipherSuite.forJavaName(cipherSuite);
        java.lang.String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new java.lang.IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new java.io.IOException("tlsVersion == NONE");
        }
        dc.squareup.okhttp3.TlsVersion tlsVersionForJavaName = dc.squareup.okhttp3.TlsVersion.forJavaName(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (javax.net.ssl.SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        java.util.List listImmutableList = peerCertificates != null ? dc.squareup.okhttp3.internal.Util.immutableList(peerCertificates) : java.util.Collections.EMPTY_LIST;
        java.security.cert.Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new dc.squareup.okhttp3.Handshake(tlsVersionForJavaName, cipherSuiteForJavaName, listImmutableList, localCertificates != null ? dc.squareup.okhttp3.internal.Util.immutableList(localCertificates) : java.util.Collections.EMPTY_LIST);
    }

    public dc.squareup.okhttp3.CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof dc.squareup.okhttp3.Handshake)) {
            return false;
        }
        dc.squareup.okhttp3.Handshake handshake = (dc.squareup.okhttp3.Handshake) obj;
        return this.tlsVersion.equals(handshake.tlsVersion) && this.cipherSuite.equals(handshake.cipherSuite) && this.peerCertificates.equals(handshake.peerCertificates) && this.localCertificates.equals(handshake.localCertificates);
    }

    public int hashCode() {
        return ((((((this.tlsVersion.hashCode() + 527) * 31) + this.cipherSuite.hashCode()) * 31) + this.peerCertificates.hashCode()) * 31) + this.localCertificates.hashCode();
    }

    public java.util.List<java.security.cert.Certificate> localCertificates() {
        return this.localCertificates;
    }

    public java.security.Principal localPrincipal() {
        if (this.localCertificates.isEmpty()) {
            return null;
        }
        return ((java.security.cert.X509Certificate) this.localCertificates.get(0)).getSubjectX500Principal();
    }

    public java.util.List<java.security.cert.Certificate> peerCertificates() {
        return this.peerCertificates;
    }

    public java.security.Principal peerPrincipal() {
        if (this.peerCertificates.isEmpty()) {
            return null;
        }
        return ((java.security.cert.X509Certificate) this.peerCertificates.get(0)).getSubjectX500Principal();
    }

    public dc.squareup.okhttp3.TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    public static dc.squareup.okhttp3.Handshake get(dc.squareup.okhttp3.TlsVersion tlsVersion, dc.squareup.okhttp3.CipherSuite cipherSuite, java.util.List<java.security.cert.Certificate> list, java.util.List<java.security.cert.Certificate> list2) {
        if (tlsVersion == null) {
            throw new java.lang.NullPointerException("tlsVersion == null");
        }
        if (cipherSuite != null) {
            return new dc.squareup.okhttp3.Handshake(tlsVersion, cipherSuite, dc.squareup.okhttp3.internal.Util.immutableList(list), dc.squareup.okhttp3.internal.Util.immutableList(list2));
        }
        throw new java.lang.NullPointerException("cipherSuite == null");
    }
}
