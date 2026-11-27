package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public enum TlsVersion {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");

    final java.lang.String javaName;

    TlsVersion(java.lang.String str) {
        this.javaName = str;
    }

    public static dc.squareup.okhttp3.TlsVersion forJavaName(java.lang.String str) {
        str.getClass();
        str.hashCode();
        switch (str) {
            case "TLSv1.1":
                return TLS_1_1;
            case "TLSv1.2":
                return TLS_1_2;
            case "TLSv1.3":
                return TLS_1_3;
            case "SSLv3":
                return SSL_3_0;
            case "TLSv1":
                return TLS_1_0;
            default:
                throw new java.lang.IllegalArgumentException("Unexpected TLS version: " + str);
        }
    }

    static java.util.List<dc.squareup.okhttp3.TlsVersion> forJavaNames(java.lang.String... strArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList(strArr.length);
        for (java.lang.String str : strArr) {
            arrayList.add(forJavaName(str));
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    public java.lang.String javaName() {
        return this.javaName;
    }
}
