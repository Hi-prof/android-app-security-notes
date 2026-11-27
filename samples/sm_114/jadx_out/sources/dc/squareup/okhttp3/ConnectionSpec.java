package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionSpec {
    private static final dc.squareup.okhttp3.CipherSuite[] APPROVED_CIPHER_SUITES;
    public static final dc.squareup.okhttp3.ConnectionSpec CLEARTEXT;
    public static final dc.squareup.okhttp3.ConnectionSpec COMPATIBLE_TLS;
    public static final dc.squareup.okhttp3.ConnectionSpec MODERN_TLS;
    private static final dc.squareup.okhttp3.CipherSuite[] RESTRICTED_CIPHER_SUITES;
    public static final dc.squareup.okhttp3.ConnectionSpec RESTRICTED_TLS;
    final java.lang.String[] cipherSuites;
    final boolean supportsTlsExtensions;
    final boolean tls;
    final java.lang.String[] tlsVersions;

    static {
        dc.squareup.okhttp3.CipherSuite cipherSuite = dc.squareup.okhttp3.CipherSuite.TLS_AES_128_GCM_SHA256;
        dc.squareup.okhttp3.CipherSuite cipherSuite2 = dc.squareup.okhttp3.CipherSuite.TLS_AES_256_GCM_SHA384;
        dc.squareup.okhttp3.CipherSuite cipherSuite3 = dc.squareup.okhttp3.CipherSuite.TLS_CHACHA20_POLY1305_SHA256;
        dc.squareup.okhttp3.CipherSuite cipherSuite4 = dc.squareup.okhttp3.CipherSuite.TLS_AES_128_CCM_SHA256;
        dc.squareup.okhttp3.CipherSuite cipherSuite5 = dc.squareup.okhttp3.CipherSuite.TLS_AES_256_CCM_8_SHA256;
        dc.squareup.okhttp3.CipherSuite cipherSuite6 = dc.squareup.okhttp3.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        dc.squareup.okhttp3.CipherSuite cipherSuite7 = dc.squareup.okhttp3.CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        dc.squareup.okhttp3.CipherSuite cipherSuite8 = dc.squareup.okhttp3.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
        dc.squareup.okhttp3.CipherSuite cipherSuite9 = dc.squareup.okhttp3.CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
        dc.squareup.okhttp3.CipherSuite cipherSuite10 = dc.squareup.okhttp3.CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
        dc.squareup.okhttp3.CipherSuite cipherSuite11 = dc.squareup.okhttp3.CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
        dc.squareup.okhttp3.CipherSuite[] cipherSuiteArr = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, cipherSuite10, cipherSuite11};
        RESTRICTED_CIPHER_SUITES = cipherSuiteArr;
        dc.squareup.okhttp3.CipherSuite[] cipherSuiteArr2 = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, cipherSuite10, cipherSuite11, dc.squareup.okhttp3.CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, dc.squareup.okhttp3.CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, dc.squareup.okhttp3.CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, dc.squareup.okhttp3.CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, dc.squareup.okhttp3.CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, dc.squareup.okhttp3.CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, dc.squareup.okhttp3.CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        APPROVED_CIPHER_SUITES = cipherSuiteArr2;
        dc.squareup.okhttp3.ConnectionSpec.Builder builderCipherSuites = new dc.squareup.okhttp3.ConnectionSpec.Builder(true).cipherSuites(cipherSuiteArr);
        dc.squareup.okhttp3.TlsVersion tlsVersion = dc.squareup.okhttp3.TlsVersion.TLS_1_3;
        dc.squareup.okhttp3.TlsVersion tlsVersion2 = dc.squareup.okhttp3.TlsVersion.TLS_1_2;
        RESTRICTED_TLS = builderCipherSuites.tlsVersions(tlsVersion, tlsVersion2).supportsTlsExtensions(true).build();
        dc.squareup.okhttp3.ConnectionSpec.Builder builderCipherSuites2 = new dc.squareup.okhttp3.ConnectionSpec.Builder(true).cipherSuites(cipherSuiteArr2);
        dc.squareup.okhttp3.TlsVersion tlsVersion3 = dc.squareup.okhttp3.TlsVersion.TLS_1_0;
        MODERN_TLS = builderCipherSuites2.tlsVersions(tlsVersion, tlsVersion2, dc.squareup.okhttp3.TlsVersion.TLS_1_1, tlsVersion3).supportsTlsExtensions(true).build();
        COMPATIBLE_TLS = new dc.squareup.okhttp3.ConnectionSpec.Builder(true).cipherSuites(cipherSuiteArr2).tlsVersions(tlsVersion3).supportsTlsExtensions(true).build();
        CLEARTEXT = new dc.squareup.okhttp3.ConnectionSpec.Builder(false).build();
    }

    ConnectionSpec(dc.squareup.okhttp3.ConnectionSpec.Builder builder) {
        this.tls = builder.tls;
        this.cipherSuites = builder.cipherSuites;
        this.tlsVersions = builder.tlsVersions;
        this.supportsTlsExtensions = builder.supportsTlsExtensions;
    }

    private dc.squareup.okhttp3.ConnectionSpec supportedSpec(javax.net.ssl.SSLSocket sSLSocket, boolean z) {
        java.lang.String[] strArrIntersect = this.cipherSuites != null ? dc.squareup.okhttp3.internal.Util.intersect(dc.squareup.okhttp3.CipherSuite.ORDER_BY_NAME, sSLSocket.getEnabledCipherSuites(), this.cipherSuites) : sSLSocket.getEnabledCipherSuites();
        java.lang.String[] strArrIntersect2 = this.tlsVersions != null ? dc.squareup.okhttp3.internal.Util.intersect(dc.squareup.okhttp3.internal.Util.NATURAL_ORDER, sSLSocket.getEnabledProtocols(), this.tlsVersions) : sSLSocket.getEnabledProtocols();
        java.lang.String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iIndexOf = dc.squareup.okhttp3.internal.Util.indexOf(dc.squareup.okhttp3.CipherSuite.ORDER_BY_NAME, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && iIndexOf != -1) {
            strArrIntersect = dc.squareup.okhttp3.internal.Util.concat(strArrIntersect, supportedCipherSuites[iIndexOf]);
        }
        return new dc.squareup.okhttp3.ConnectionSpec.Builder(this).cipherSuites(strArrIntersect).tlsVersions(strArrIntersect2).build();
    }

    void apply(javax.net.ssl.SSLSocket sSLSocket, boolean z) {
        dc.squareup.okhttp3.ConnectionSpec connectionSpecSupportedSpec = supportedSpec(sSLSocket, z);
        java.lang.String[] strArr = connectionSpecSupportedSpec.tlsVersions;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        java.lang.String[] strArr2 = connectionSpecSupportedSpec.cipherSuites;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public java.util.List<dc.squareup.okhttp3.CipherSuite> cipherSuites() {
        java.lang.String[] strArr = this.cipherSuites;
        if (strArr != null) {
            return dc.squareup.okhttp3.CipherSuite.forJavaNames(strArr);
        }
        return null;
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof dc.squareup.okhttp3.ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        dc.squareup.okhttp3.ConnectionSpec connectionSpec = (dc.squareup.okhttp3.ConnectionSpec) obj;
        boolean z = this.tls;
        if (z != connectionSpec.tls) {
            return false;
        }
        return !z || (java.util.Arrays.equals(this.cipherSuites, connectionSpec.cipherSuites) && java.util.Arrays.equals(this.tlsVersions, connectionSpec.tlsVersions) && this.supportsTlsExtensions == connectionSpec.supportsTlsExtensions);
    }

    public int hashCode() {
        if (this.tls) {
            return ((((java.util.Arrays.hashCode(this.cipherSuites) + 527) * 31) + java.util.Arrays.hashCode(this.tlsVersions)) * 31) + (!this.supportsTlsExtensions ? 1 : 0);
        }
        return 17;
    }

    public boolean isCompatible(javax.net.ssl.SSLSocket sSLSocket) {
        if (!this.tls) {
            return false;
        }
        java.lang.String[] strArr = this.tlsVersions;
        if (strArr != null && !dc.squareup.okhttp3.internal.Util.nonEmptyIntersection(dc.squareup.okhttp3.internal.Util.NATURAL_ORDER, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        java.lang.String[] strArr2 = this.cipherSuites;
        return strArr2 == null || dc.squareup.okhttp3.internal.Util.nonEmptyIntersection(dc.squareup.okhttp3.CipherSuite.ORDER_BY_NAME, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public boolean isTls() {
        return this.tls;
    }

    public boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    public java.util.List<dc.squareup.okhttp3.TlsVersion> tlsVersions() {
        java.lang.String[] strArr = this.tlsVersions;
        if (strArr != null) {
            return dc.squareup.okhttp3.TlsVersion.forJavaNames(strArr);
        }
        return null;
    }

    public java.lang.String toString() {
        if (!this.tls) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.cipherSuites != null ? cipherSuites().toString() : "[all enabled]") + ", tlsVersions=" + (this.tlsVersions != null ? tlsVersions().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.supportsTlsExtensions + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static final class Builder {
        java.lang.String[] cipherSuites;
        boolean supportsTlsExtensions;
        boolean tls;
        java.lang.String[] tlsVersions;

        Builder(boolean z) {
            this.tls = z;
        }

        public dc.squareup.okhttp3.ConnectionSpec.Builder allEnabledCipherSuites() {
            if (!this.tls) {
                throw new java.lang.IllegalStateException("no cipher suites for cleartext connections");
            }
            this.cipherSuites = null;
            return this;
        }

        public dc.squareup.okhttp3.ConnectionSpec.Builder allEnabledTlsVersions() {
            if (!this.tls) {
                throw new java.lang.IllegalStateException("no TLS versions for cleartext connections");
            }
            this.tlsVersions = null;
            return this;
        }

        public dc.squareup.okhttp3.ConnectionSpec build() {
            return new dc.squareup.okhttp3.ConnectionSpec(this);
        }

        public dc.squareup.okhttp3.ConnectionSpec.Builder cipherSuites(dc.squareup.okhttp3.CipherSuite... cipherSuiteArr) {
            if (!this.tls) {
                throw new java.lang.IllegalStateException("no cipher suites for cleartext connections");
            }
            java.lang.String[] strArr = new java.lang.String[cipherSuiteArr.length];
            for (int i = 0; i < cipherSuiteArr.length; i++) {
                strArr[i] = cipherSuiteArr[i].javaName;
            }
            return cipherSuites(strArr);
        }

        public dc.squareup.okhttp3.ConnectionSpec.Builder supportsTlsExtensions(boolean z) {
            if (!this.tls) {
                throw new java.lang.IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.supportsTlsExtensions = z;
            return this;
        }

        public dc.squareup.okhttp3.ConnectionSpec.Builder tlsVersions(dc.squareup.okhttp3.TlsVersion... tlsVersionArr) {
            if (!this.tls) {
                throw new java.lang.IllegalStateException("no TLS versions for cleartext connections");
            }
            java.lang.String[] strArr = new java.lang.String[tlsVersionArr.length];
            for (int i = 0; i < tlsVersionArr.length; i++) {
                strArr[i] = tlsVersionArr[i].javaName;
            }
            return tlsVersions(strArr);
        }

        public Builder(dc.squareup.okhttp3.ConnectionSpec connectionSpec) {
            this.tls = connectionSpec.tls;
            this.cipherSuites = connectionSpec.cipherSuites;
            this.tlsVersions = connectionSpec.tlsVersions;
            this.supportsTlsExtensions = connectionSpec.supportsTlsExtensions;
        }

        public dc.squareup.okhttp3.ConnectionSpec.Builder cipherSuites(java.lang.String... strArr) {
            if (this.tls) {
                if (strArr.length != 0) {
                    this.cipherSuites = (java.lang.String[]) strArr.clone();
                    return this;
                }
                throw new java.lang.IllegalArgumentException("At least one cipher suite is required");
            }
            throw new java.lang.IllegalStateException("no cipher suites for cleartext connections");
        }

        public dc.squareup.okhttp3.ConnectionSpec.Builder tlsVersions(java.lang.String... strArr) {
            if (this.tls) {
                if (strArr.length != 0) {
                    this.tlsVersions = (java.lang.String[]) strArr.clone();
                    return this;
                }
                throw new java.lang.IllegalArgumentException("At least one TLS version is required");
            }
            throw new java.lang.IllegalStateException("no TLS versions for cleartext connections");
        }
    }
}
