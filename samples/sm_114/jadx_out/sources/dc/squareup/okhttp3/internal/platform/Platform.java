package dc.squareup.okhttp3.internal.platform;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class Platform {
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final dc.squareup.okhttp3.internal.platform.Platform PLATFORM = findPlatform();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(dc.squareup.okhttp3.OkHttpClient.class.getName());

    public static java.util.List<java.lang.String> alpnProtocolNames(java.util.List<dc.squareup.okhttp3.Protocol> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            dc.squareup.okhttp3.Protocol protocol = list.get(i);
            if (protocol != dc.squareup.okhttp3.Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    static byte[] concatLengthPrefixed(java.util.List<dc.squareup.okhttp3.Protocol> list) {
        dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            dc.squareup.okhttp3.Protocol protocol = list.get(i);
            if (protocol != dc.squareup.okhttp3.Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.writeUtf8(protocol.toString());
            }
        }
        return buffer.readByteArray();
    }

    private static dc.squareup.okhttp3.internal.platform.Platform findPlatform() {
        dc.squareup.okhttp3.internal.platform.Platform platformBuildIfSupported = dc.squareup.okhttp3.internal.platform.Android10Platform.buildIfSupported();
        if (platformBuildIfSupported != null) {
            return platformBuildIfSupported;
        }
        dc.squareup.okhttp3.internal.platform.Platform platformBuildIfSupported2 = dc.squareup.okhttp3.internal.platform.AndroidPlatform.buildIfSupported();
        if (platformBuildIfSupported2 != null) {
            return platformBuildIfSupported2;
        }
        dc.squareup.okhttp3.internal.platform.Jdk9Platform jdk9PlatformBuildIfSupported = dc.squareup.okhttp3.internal.platform.Jdk9Platform.buildIfSupported();
        if (jdk9PlatformBuildIfSupported != null) {
            return jdk9PlatformBuildIfSupported;
        }
        dc.squareup.okhttp3.internal.platform.Platform platformBuildIfSupported3 = dc.squareup.okhttp3.internal.platform.JdkWithJettyBootPlatform.buildIfSupported();
        return platformBuildIfSupported3 != null ? platformBuildIfSupported3 : new dc.squareup.okhttp3.internal.platform.Platform();
    }

    public static dc.squareup.okhttp3.internal.platform.Platform get() {
        return PLATFORM;
    }

    public static boolean isConscrytpPreferred() {
        if ("conscrypt".equals(java.lang.System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(java.security.Security.getProviders()[0].getName());
    }

    static <T> T readFieldOrNull(java.lang.Object obj, java.lang.Class<T> cls, java.lang.String str) {
        java.lang.Object fieldOrNull;
        for (java.lang.Class<?> superclass = obj.getClass(); superclass != java.lang.Object.class; superclass = superclass.getSuperclass()) {
            try {
                java.lang.reflect.Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                java.lang.Object obj2 = declaredField.get(obj);
                if (obj2 != null && cls.isInstance(obj2)) {
                    return cls.cast(obj2);
                }
                return null;
            } catch (java.lang.IllegalAccessException unused) {
                throw new java.lang.AssertionError();
            } catch (java.lang.NoSuchFieldException unused2) {
            }
        }
        if (str.equals("delegate") || (fieldOrNull = readFieldOrNull(obj, java.lang.Object.class, "delegate")) == null) {
            return null;
        }
        return (T) readFieldOrNull(fieldOrNull, cls, str);
    }

    public void afterHandshake(javax.net.ssl.SSLSocket sSLSocket) {
    }

    public dc.squareup.okhttp3.internal.tls.CertificateChainCleaner buildCertificateChainCleaner(javax.net.ssl.X509TrustManager x509TrustManager) {
        return new dc.squareup.okhttp3.internal.tls.BasicCertificateChainCleaner(buildTrustRootIndex(x509TrustManager));
    }

    public dc.squareup.okhttp3.internal.tls.TrustRootIndex buildTrustRootIndex(javax.net.ssl.X509TrustManager x509TrustManager) {
        return new dc.squareup.okhttp3.internal.tls.BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }

    public void configureSslSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
    }

    public void configureTlsExtensions(javax.net.ssl.SSLSocket sSLSocket, java.lang.String str, java.util.List<dc.squareup.okhttp3.Protocol> list) throws java.io.IOException {
    }

    public void connectSocket(java.net.Socket socket, java.net.InetSocketAddress inetSocketAddress, int i) throws java.io.IOException {
        socket.connect(inetSocketAddress, i);
    }

    public java.lang.String getPrefix() {
        return "OkHttp";
    }

    public javax.net.ssl.SSLContext getSSLContext() {
        if ("1.7".equals(java.lang.System.getProperty("java.specification.version"))) {
            try {
                return javax.net.ssl.SSLContext.getInstance("TLSv1.2");
            } catch (java.security.NoSuchAlgorithmException unused) {
            }
        }
        try {
            return javax.net.ssl.SSLContext.getInstance("TLS");
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new java.lang.IllegalStateException("No TLS provider", e);
        }
    }

    public java.lang.String getSelectedProtocol(javax.net.ssl.SSLSocket sSLSocket) {
        return null;
    }

    public java.lang.Object getStackTraceForCloseable(java.lang.String str) {
        if (logger.isLoggable(java.util.logging.Level.FINE)) {
            return new java.lang.Throwable(str);
        }
        return null;
    }

    public boolean isCleartextTrafficPermitted(java.lang.String str) {
        return true;
    }

    public void log(int i, java.lang.String str, java.lang.Throwable th) {
        logger.log(i == 5 ? java.util.logging.Level.WARNING : java.util.logging.Level.INFO, str, th);
    }

    public void logCloseableLeak(java.lang.String str, java.lang.Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        log(5, str, (java.lang.Throwable) obj);
    }

    public java.lang.String toString() {
        return getClass().getSimpleName();
    }

    protected javax.net.ssl.X509TrustManager trustManager(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
        try {
            java.lang.Object fieldOrNull = readFieldOrNull(sSLSocketFactory, java.lang.Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (fieldOrNull == null) {
                return null;
            }
            return (javax.net.ssl.X509TrustManager) readFieldOrNull(fieldOrNull, javax.net.ssl.X509TrustManager.class, "trustManager");
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        }
    }

    public dc.squareup.okhttp3.internal.tls.CertificateChainCleaner buildCertificateChainCleaner(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
        javax.net.ssl.X509TrustManager x509TrustManagerTrustManager = trustManager(sSLSocketFactory);
        if (x509TrustManagerTrustManager != null) {
            return buildCertificateChainCleaner(x509TrustManagerTrustManager);
        }
        throw new java.lang.IllegalStateException("Unable to extract the trust manager on " + get() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
    }
}
