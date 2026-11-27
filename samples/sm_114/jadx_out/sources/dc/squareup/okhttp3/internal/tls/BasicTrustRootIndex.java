package dc.squareup.okhttp3.internal.tls;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class BasicTrustRootIndex implements dc.squareup.okhttp3.internal.tls.TrustRootIndex {
    private final java.util.Map<javax.security.auth.x500.X500Principal, java.util.Set<java.security.cert.X509Certificate>> subjectToCaCerts = new java.util.LinkedHashMap();

    public BasicTrustRootIndex(java.security.cert.X509Certificate... x509CertificateArr) {
        for (java.security.cert.X509Certificate x509Certificate : x509CertificateArr) {
            javax.security.auth.x500.X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            java.util.Set<java.security.cert.X509Certificate> linkedHashSet = this.subjectToCaCerts.get(subjectX500Principal);
            if (linkedHashSet == null) {
                linkedHashSet = new java.util.LinkedHashSet<>(1);
                this.subjectToCaCerts.put(subjectX500Principal, linkedHashSet);
            }
            linkedHashSet.add(x509Certificate);
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof dc.squareup.okhttp3.internal.tls.BasicTrustRootIndex) && ((dc.squareup.okhttp3.internal.tls.BasicTrustRootIndex) obj).subjectToCaCerts.equals(this.subjectToCaCerts);
    }

    @Override // dc.squareup.okhttp3.internal.tls.TrustRootIndex
    public java.security.cert.X509Certificate findByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate) {
        java.util.Set<java.security.cert.X509Certificate> set = this.subjectToCaCerts.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (java.security.cert.X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    public int hashCode() {
        return this.subjectToCaCerts.hashCode();
    }
}
