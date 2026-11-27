package dc.squareup.okhttp3.internal.tls;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface TrustRootIndex {
    java.security.cert.X509Certificate findByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate);
}
