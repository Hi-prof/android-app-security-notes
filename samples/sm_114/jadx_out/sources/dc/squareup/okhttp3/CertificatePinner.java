package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class CertificatePinner {
    public static final dc.squareup.okhttp3.CertificatePinner DEFAULT = new dc.squareup.okhttp3.CertificatePinner.Builder().build();
    private final dc.squareup.okhttp3.internal.tls.CertificateChainCleaner certificateChainCleaner;
    private final java.util.Set<dc.squareup.okhttp3.CertificatePinner.Pin> pins;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static final class Builder {
        private final java.util.List<dc.squareup.okhttp3.CertificatePinner.Pin> pins = new java.util.ArrayList();

        public dc.squareup.okhttp3.CertificatePinner.Builder add(java.lang.String str, java.lang.String... strArr) {
            if (str == null) {
                throw new java.lang.NullPointerException("pattern == null");
            }
            for (java.lang.String str2 : strArr) {
                this.pins.add(new dc.squareup.okhttp3.CertificatePinner.Pin(str, str2));
            }
            return this;
        }

        public dc.squareup.okhttp3.CertificatePinner build() {
            return new dc.squareup.okhttp3.CertificatePinner(new java.util.LinkedHashSet(this.pins), null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static final class Pin {
        private static final java.lang.String WILDCARD = "*.";
        final java.lang.String canonicalHostname;
        final dc.squareup.okio.ByteString hash;
        final java.lang.String hashAlgorithm;
        final java.lang.String pattern;

        Pin(java.lang.String str, java.lang.String str2) {
            java.lang.String strHost;
            this.pattern = str;
            if (str.startsWith(WILDCARD)) {
                strHost = dc.squareup.okhttp3.HttpUrl.get(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL + str.substring(2)).host();
            } else {
                strHost = dc.squareup.okhttp3.HttpUrl.get(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL + str).host();
            }
            this.canonicalHostname = strHost;
            if (str2.startsWith("sha1/")) {
                this.hashAlgorithm = "sha1/";
                this.hash = dc.squareup.okio.ByteString.decodeBase64(str2.substring(5));
            } else {
                if (!str2.startsWith("sha256/")) {
                    throw new java.lang.IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
                }
                this.hashAlgorithm = "sha256/";
                this.hash = dc.squareup.okio.ByteString.decodeBase64(str2.substring(7));
            }
            if (this.hash != null) {
                return;
            }
            throw new java.lang.IllegalArgumentException("pins must be base64: " + str2);
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof dc.squareup.okhttp3.CertificatePinner.Pin)) {
                return false;
            }
            dc.squareup.okhttp3.CertificatePinner.Pin pin = (dc.squareup.okhttp3.CertificatePinner.Pin) obj;
            return this.pattern.equals(pin.pattern) && this.hashAlgorithm.equals(pin.hashAlgorithm) && this.hash.equals(pin.hash);
        }

        public int hashCode() {
            return ((((this.pattern.hashCode() + 527) * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        boolean matches(java.lang.String str) {
            if (!this.pattern.startsWith(WILDCARD)) {
                return str.equals(this.canonicalHostname);
            }
            int iIndexOf = str.indexOf(46);
            if ((str.length() - iIndexOf) - 1 != this.canonicalHostname.length()) {
                return false;
            }
            java.lang.String str2 = this.canonicalHostname;
            return str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length());
        }

        public java.lang.String toString() {
            return this.hashAlgorithm + this.hash.base64();
        }
    }

    CertificatePinner(java.util.Set<dc.squareup.okhttp3.CertificatePinner.Pin> set, dc.squareup.okhttp3.internal.tls.CertificateChainCleaner certificateChainCleaner) {
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public static java.lang.String pin(java.security.cert.Certificate certificate) {
        if (!(certificate instanceof java.security.cert.X509Certificate)) {
            throw new java.lang.IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + sha256((java.security.cert.X509Certificate) certificate).base64();
    }

    static dc.squareup.okio.ByteString sha1(java.security.cert.X509Certificate x509Certificate) {
        return dc.squareup.okio.ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    static dc.squareup.okio.ByteString sha256(java.security.cert.X509Certificate x509Certificate) {
        return dc.squareup.okio.ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    public void check(java.lang.String str, java.util.List<java.security.cert.Certificate> list) throws javax.net.ssl.SSLPeerUnverifiedException {
        java.util.List<dc.squareup.okhttp3.CertificatePinner.Pin> listFindMatchingPins = findMatchingPins(str);
        if (listFindMatchingPins.isEmpty()) {
            return;
        }
        dc.squareup.okhttp3.internal.tls.CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        if (certificateChainCleaner != null) {
            list = certificateChainCleaner.clean(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            java.security.cert.X509Certificate x509Certificate = (java.security.cert.X509Certificate) list.get(i);
            int size2 = listFindMatchingPins.size();
            dc.squareup.okio.ByteString byteStringSha256 = null;
            dc.squareup.okio.ByteString byteStringSha1 = null;
            for (int i2 = 0; i2 < size2; i2++) {
                dc.squareup.okhttp3.CertificatePinner.Pin pin = listFindMatchingPins.get(i2);
                if (pin.hashAlgorithm.equals("sha256/")) {
                    if (byteStringSha256 == null) {
                        byteStringSha256 = sha256(x509Certificate);
                    }
                    if (pin.hash.equals(byteStringSha256)) {
                        return;
                    }
                } else {
                    if (!pin.hashAlgorithm.equals("sha1/")) {
                        throw new java.lang.AssertionError("unsupported hashAlgorithm: " + pin.hashAlgorithm);
                    }
                    if (byteStringSha1 == null) {
                        byteStringSha1 = sha1(x509Certificate);
                    }
                    if (pin.hash.equals(byteStringSha1)) {
                        return;
                    }
                }
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            java.security.cert.X509Certificate x509Certificate2 = (java.security.cert.X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(pin(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = listFindMatchingPins.size();
        for (int i4 = 0; i4 < size4; i4++) {
            dc.squareup.okhttp3.CertificatePinner.Pin pin2 = listFindMatchingPins.get(i4);
            sb.append("\n    ");
            sb.append(pin2);
        }
        throw new javax.net.ssl.SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dc.squareup.okhttp3.CertificatePinner)) {
            return false;
        }
        dc.squareup.okhttp3.CertificatePinner certificatePinner = (dc.squareup.okhttp3.CertificatePinner) obj;
        return dc.squareup.okhttp3.internal.Util.equal(this.certificateChainCleaner, certificatePinner.certificateChainCleaner) && this.pins.equals(certificatePinner.pins);
    }

    java.util.List<dc.squareup.okhttp3.CertificatePinner.Pin> findMatchingPins(java.lang.String str) {
        java.util.List<dc.squareup.okhttp3.CertificatePinner.Pin> arrayList = java.util.Collections.EMPTY_LIST;
        for (dc.squareup.okhttp3.CertificatePinner.Pin pin : this.pins) {
            if (pin.matches(str)) {
                if (arrayList.isEmpty()) {
                    arrayList = new java.util.ArrayList<>();
                }
                arrayList.add(pin);
            }
        }
        return arrayList;
    }

    public int hashCode() {
        dc.squareup.okhttp3.internal.tls.CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return ((certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0) * 31) + this.pins.hashCode();
    }

    dc.squareup.okhttp3.CertificatePinner withCertificateChainCleaner(dc.squareup.okhttp3.internal.tls.CertificateChainCleaner certificateChainCleaner) {
        return dc.squareup.okhttp3.internal.Util.equal(this.certificateChainCleaner, certificateChainCleaner) ? this : new dc.squareup.okhttp3.CertificatePinner(this.pins, certificateChainCleaner);
    }

    public void check(java.lang.String str, java.security.cert.Certificate... certificateArr) throws javax.net.ssl.SSLPeerUnverifiedException {
        check(str, java.util.Arrays.asList(certificateArr));
    }
}
