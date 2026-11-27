package dc.squareup.okhttp3.internal.tls;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class CertificateChainCleaner {
    public static dc.squareup.okhttp3.internal.tls.CertificateChainCleaner get(javax.net.ssl.X509TrustManager x509TrustManager) {
        return dc.squareup.okhttp3.internal.platform.Platform.get().buildCertificateChainCleaner(x509TrustManager);
    }

    public abstract java.util.List<java.security.cert.Certificate> clean(java.util.List<java.security.cert.Certificate> list, java.lang.String str) throws javax.net.ssl.SSLPeerUnverifiedException;

    public static dc.squareup.okhttp3.internal.tls.CertificateChainCleaner get(java.security.cert.X509Certificate... x509CertificateArr) {
        return new dc.squareup.okhttp3.internal.tls.BasicCertificateChainCleaner(new dc.squareup.okhttp3.internal.tls.BasicTrustRootIndex(x509CertificateArr));
    }
}
