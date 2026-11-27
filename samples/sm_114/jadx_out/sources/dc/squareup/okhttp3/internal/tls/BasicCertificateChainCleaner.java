package dc.squareup.okhttp3.internal.tls;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class BasicCertificateChainCleaner extends dc.squareup.okhttp3.internal.tls.CertificateChainCleaner {
    private static final int MAX_SIGNERS = 9;
    private final dc.squareup.okhttp3.internal.tls.TrustRootIndex trustRootIndex;

    public BasicCertificateChainCleaner(dc.squareup.okhttp3.internal.tls.TrustRootIndex trustRootIndex) {
        this.trustRootIndex = trustRootIndex;
    }

    private boolean verifySignature(java.security.cert.X509Certificate x509Certificate, java.security.cert.X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (java.security.GeneralSecurityException unused) {
            return false;
        }
    }

    @Override // dc.squareup.okhttp3.internal.tls.CertificateChainCleaner
    public java.util.List<java.security.cert.Certificate> clean(java.util.List<java.security.cert.Certificate> list, java.lang.String str) throws javax.net.ssl.SSLPeerUnverifiedException {
        java.security.cert.X509Certificate x509Certificate;
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque(list);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add((java.security.cert.Certificate) arrayDeque.removeFirst());
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            java.security.cert.X509Certificate x509Certificate2 = (java.security.cert.X509Certificate) arrayList.get(arrayList.size() - 1);
            java.security.cert.X509Certificate x509CertificateFindByIssuerAndSignature = this.trustRootIndex.findByIssuerAndSignature(x509Certificate2);
            if (x509CertificateFindByIssuerAndSignature != null) {
                if (arrayList.size() > 1 || !x509Certificate2.equals(x509CertificateFindByIssuerAndSignature)) {
                    arrayList.add(x509CertificateFindByIssuerAndSignature);
                }
                if (verifySignature(x509CertificateFindByIssuerAndSignature, x509CertificateFindByIssuerAndSignature)) {
                    return arrayList;
                }
                z = true;
            } else {
                java.util.Iterator it = arrayDeque.iterator();
                do {
                    if (!it.hasNext()) {
                        if (!z) {
                            throw new javax.net.ssl.SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate2);
                        }
                        return arrayList;
                    }
                    x509Certificate = (java.security.cert.X509Certificate) it.next();
                } while (!verifySignature(x509Certificate2, x509Certificate));
                it.remove();
                arrayList.add(x509Certificate);
            }
        }
        throw new javax.net.ssl.SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof dc.squareup.okhttp3.internal.tls.BasicCertificateChainCleaner) && ((dc.squareup.okhttp3.internal.tls.BasicCertificateChainCleaner) obj).trustRootIndex.equals(this.trustRootIndex);
    }

    public int hashCode() {
        return this.trustRootIndex.hashCode();
    }
}
