package dc.squareup.okhttp3.internal.connection;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionSpecSelector {
    private final java.util.List<dc.squareup.okhttp3.ConnectionSpec> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex = 0;

    public ConnectionSpecSelector(java.util.List<dc.squareup.okhttp3.ConnectionSpec> list) {
        this.connectionSpecs = list;
    }

    private boolean isFallbackPossible(javax.net.ssl.SSLSocket sSLSocket) {
        for (int i = this.nextModeIndex; i < this.connectionSpecs.size(); i++) {
            if (this.connectionSpecs.get(i).isCompatible(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public dc.squareup.okhttp3.ConnectionSpec configureSecureSocket(javax.net.ssl.SSLSocket sSLSocket) throws java.io.IOException {
        dc.squareup.okhttp3.ConnectionSpec connectionSpec;
        int i = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (true) {
            if (i >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.connectionSpecs.get(i);
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.nextModeIndex = i + 1;
                break;
            }
            i++;
        }
        if (connectionSpec != null) {
            this.isFallbackPossible = isFallbackPossible(sSLSocket);
            dc.squareup.okhttp3.internal.Internal.instance.apply(connectionSpec, sSLSocket, this.isFallback);
            return connectionSpec;
        }
        throw new java.net.UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.isFallback + ", modes=" + this.connectionSpecs + ", supported protocols=" + java.util.Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean connectionFailed(java.io.IOException iOException) {
        this.isFallback = true;
        if (!this.isFallbackPossible || (iOException instanceof java.net.ProtocolException) || (iOException instanceof java.io.InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof javax.net.ssl.SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof java.security.cert.CertificateException)) || (iOException instanceof javax.net.ssl.SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof javax.net.ssl.SSLProtocolException) || (iOException instanceof javax.net.ssl.SSLException);
    }
}
