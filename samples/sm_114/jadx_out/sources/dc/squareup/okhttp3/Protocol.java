package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");

    private final java.lang.String protocol;

    Protocol(java.lang.String str) {
        this.protocol = str;
    }

    public static dc.squareup.okhttp3.Protocol get(java.lang.String str) throws java.io.IOException {
        dc.squareup.okhttp3.Protocol protocol = HTTP_1_0;
        if (str.equals(protocol.protocol)) {
            return protocol;
        }
        dc.squareup.okhttp3.Protocol protocol2 = HTTP_1_1;
        if (str.equals(protocol2.protocol)) {
            return protocol2;
        }
        dc.squareup.okhttp3.Protocol protocol3 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(protocol3.protocol)) {
            return protocol3;
        }
        dc.squareup.okhttp3.Protocol protocol4 = HTTP_2;
        if (str.equals(protocol4.protocol)) {
            return protocol4;
        }
        dc.squareup.okhttp3.Protocol protocol5 = SPDY_3;
        if (str.equals(protocol5.protocol)) {
            return protocol5;
        }
        dc.squareup.okhttp3.Protocol protocol6 = QUIC;
        if (str.equals(protocol6.protocol)) {
            return protocol6;
        }
        throw new java.io.IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public java.lang.String toString() {
        return this.protocol;
    }
}
