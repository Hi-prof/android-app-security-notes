package dc.squareup.okhttp3.internal.platform;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class Jdk9Platform extends dc.squareup.okhttp3.internal.platform.Platform {
    final java.lang.reflect.Method getProtocolMethod;
    final java.lang.reflect.Method setProtocolMethod;

    Jdk9Platform(java.lang.reflect.Method method, java.lang.reflect.Method method2) {
        this.setProtocolMethod = method;
        this.getProtocolMethod = method2;
    }

    public static dc.squareup.okhttp3.internal.platform.Jdk9Platform buildIfSupported() {
        try {
            return new dc.squareup.okhttp3.internal.platform.Jdk9Platform(javax.net.ssl.SSLParameters.class.getMethod("setApplicationProtocols", java.lang.String[].class), javax.net.ssl.SSLSocket.class.getMethod("getApplicationProtocol", null));
        } catch (java.lang.NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // dc.squareup.okhttp3.internal.platform.Platform
    public void configureTlsExtensions(javax.net.ssl.SSLSocket sSLSocket, java.lang.String str, java.util.List<dc.squareup.okhttp3.Protocol> list) {
        try {
            javax.net.ssl.SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            java.util.List<java.lang.String> listAlpnProtocolNames = dc.squareup.okhttp3.internal.platform.Platform.alpnProtocolNames(list);
            this.setProtocolMethod.invoke(sSLParameters, listAlpnProtocolNames.toArray(new java.lang.String[listAlpnProtocolNames.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            throw dc.squareup.okhttp3.internal.Util.assertionError("unable to set ssl parameters", e);
        }
    }

    @Override // dc.squareup.okhttp3.internal.platform.Platform
    public java.lang.String getSelectedProtocol(javax.net.ssl.SSLSocket sSLSocket) {
        try {
            java.lang.String str = (java.lang.String) this.getProtocolMethod.invoke(sSLSocket, null);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (java.lang.IllegalAccessException e) {
            throw dc.squareup.okhttp3.internal.Util.assertionError("failed to get ALPN selected protocol", e);
        } catch (java.lang.reflect.InvocationTargetException e2) {
            if (e2.getCause() instanceof java.lang.UnsupportedOperationException) {
                return null;
            }
            throw dc.squareup.okhttp3.internal.Util.assertionError("failed to get ALPN selected protocol", e2);
        }
    }

    @Override // dc.squareup.okhttp3.internal.platform.Platform
    public javax.net.ssl.X509TrustManager trustManager(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
        throw new java.lang.UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
