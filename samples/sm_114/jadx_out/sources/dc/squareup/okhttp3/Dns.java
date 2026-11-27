package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface Dns {
    public static final dc.squareup.okhttp3.Dns SYSTEM = new dc.squareup.okhttp3.Dns() { // from class: dc.squareup.okhttp3.Dns.1
        @Override // dc.squareup.okhttp3.Dns
        public java.util.List<java.net.InetAddress> lookup(java.lang.String str) throws java.net.UnknownHostException {
            if (str == null) {
                throw new java.net.UnknownHostException("hostname == null");
            }
            try {
                return java.util.Arrays.asList(java.net.InetAddress.getAllByName(str));
            } catch (java.lang.NullPointerException e) {
                java.net.UnknownHostException unknownHostException = new java.net.UnknownHostException("Broken system behaviour for dns lookup of " + str);
                unknownHostException.initCause(e);
                throw unknownHostException;
            }
        }
    };

    java.util.List<java.net.InetAddress> lookup(java.lang.String str) throws java.net.UnknownHostException;
}
