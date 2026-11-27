package okhttp3.internal.platform;

/* JADX INFO: loaded from: classes2.dex */
class Android10Platform extends okhttp3.internal.platform.AndroidPlatform {
    Android10Platform(java.lang.Class<?> cls) {
        super(cls, null, null, null, null);
    }

    @Override // okhttp3.internal.platform.AndroidPlatform, okhttp3.internal.platform.Platform
    public void configureTlsExtensions(javax.net.ssl.SSLSocket sSLSocket, java.lang.String str, java.util.List<okhttp3.Protocol> list) throws java.io.IOException {
        try {
            enableSessionTickets(sSLSocket);
            javax.net.ssl.SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            sSLParameters.setApplicationProtocols((java.lang.String[]) okhttp3.internal.platform.Platform.alpnProtocolNames(list).toArray(new java.lang.String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (java.lang.IllegalArgumentException e) {
            throw new java.io.IOException("Android internal error", e);
        }
    }

    private void enableSessionTickets(javax.net.ssl.SSLSocket sSLSocket) {
        if (android.net.ssl.SSLSockets.isSupportedSocket(sSLSocket)) {
            android.net.ssl.SSLSockets.setUseSessionTickets(sSLSocket, true);
        }
    }

    @Override // okhttp3.internal.platform.AndroidPlatform, okhttp3.internal.platform.Platform
    @javax.annotation.Nullable
    public java.lang.String getSelectedProtocol(javax.net.ssl.SSLSocket sSLSocket) {
        java.lang.String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || applicationProtocol.isEmpty()) {
            return null;
        }
        return applicationProtocol;
    }

    @javax.annotation.Nullable
    public static okhttp3.internal.platform.Platform buildIfSupported() {
        if (!okhttp3.internal.platform.Platform.isAndroid()) {
            return null;
        }
        try {
            if (getSdkInt() >= 29) {
                return new okhttp3.internal.platform.Android10Platform(java.lang.Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
            }
        } catch (java.lang.ClassNotFoundException unused) {
        }
        return null;
    }
}
