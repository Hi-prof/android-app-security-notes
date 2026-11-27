package dc.squareup.okhttp3.internal.platform;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class Android10Platform extends dc.squareup.okhttp3.internal.platform.AndroidPlatform {
    Android10Platform(java.lang.Class<?> cls) {
        super(cls, null, null, null, null);
    }

    public static dc.squareup.okhttp3.internal.platform.Platform buildIfSupported() {
        try {
            if (dc.squareup.okhttp3.internal.platform.AndroidPlatform.getSdkInt() >= 29) {
                return new dc.squareup.okhttp3.internal.platform.Android10Platform(java.lang.Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
            }
            return null;
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        }
    }

    private void enableSessionTickets(javax.net.ssl.SSLSocket sSLSocket) {
        if (android.net.ssl.SSLSockets.isSupportedSocket(sSLSocket)) {
            android.net.ssl.SSLSockets.setUseSessionTickets(sSLSocket, true);
        }
    }

    @Override // dc.squareup.okhttp3.internal.platform.AndroidPlatform, dc.squareup.okhttp3.internal.platform.Platform
    public void configureTlsExtensions(javax.net.ssl.SSLSocket sSLSocket, java.lang.String str, java.util.List<dc.squareup.okhttp3.Protocol> list) throws java.io.IOException {
        try {
            enableSessionTickets(sSLSocket);
            javax.net.ssl.SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            sSLParameters.setApplicationProtocols((java.lang.String[]) dc.squareup.okhttp3.internal.platform.Platform.alpnProtocolNames(list).toArray(new java.lang.String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (java.lang.IllegalArgumentException e) {
            throw new java.io.IOException("Android internal error", e);
        }
    }

    @Override // dc.squareup.okhttp3.internal.platform.AndroidPlatform, dc.squareup.okhttp3.internal.platform.Platform
    public java.lang.String getSelectedProtocol(javax.net.ssl.SSLSocket sSLSocket) {
        java.lang.String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || applicationProtocol.isEmpty()) {
            return null;
        }
        return applicationProtocol;
    }
}
