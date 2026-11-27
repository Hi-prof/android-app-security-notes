package dc.squareup.okhttp3.internal.platform;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class AndroidPlatform extends dc.squareup.okhttp3.internal.platform.Platform {
    private static final int MAX_LOG_LENGTH = 4000;
    private final dc.squareup.okhttp3.internal.platform.AndroidPlatform.CloseGuard closeGuard = dc.squareup.okhttp3.internal.platform.AndroidPlatform.CloseGuard.get();
    private final dc.squareup.okhttp3.internal.platform.OptionalMethod<java.net.Socket> getAlpnSelectedProtocol;
    private final dc.squareup.okhttp3.internal.platform.OptionalMethod<java.net.Socket> setAlpnProtocols;
    private final dc.squareup.okhttp3.internal.platform.OptionalMethod<java.net.Socket> setHostname;
    private final dc.squareup.okhttp3.internal.platform.OptionalMethod<java.net.Socket> setUseSessionTickets;
    private final java.lang.Class<?> sslParametersClass;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static final class AndroidCertificateChainCleaner extends dc.squareup.okhttp3.internal.tls.CertificateChainCleaner {
        private final java.lang.reflect.Method checkServerTrusted;
        private final java.lang.Object x509TrustManagerExtensions;

        AndroidCertificateChainCleaner(java.lang.Object obj, java.lang.reflect.Method method) {
            this.x509TrustManagerExtensions = obj;
            this.checkServerTrusted = method;
        }

        @Override // dc.squareup.okhttp3.internal.tls.CertificateChainCleaner
        public java.util.List<java.security.cert.Certificate> clean(java.util.List<java.security.cert.Certificate> list, java.lang.String str) throws javax.net.ssl.SSLPeerUnverifiedException {
            try {
                return (java.util.List) this.checkServerTrusted.invoke(this.x509TrustManagerExtensions, (java.security.cert.X509Certificate[]) list.toArray(new java.security.cert.X509Certificate[list.size()]), "RSA", str);
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.AssertionError(e);
            } catch (java.lang.reflect.InvocationTargetException e2) {
                javax.net.ssl.SSLPeerUnverifiedException sSLPeerUnverifiedException = new javax.net.ssl.SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(java.lang.Object obj) {
            return obj instanceof dc.squareup.okhttp3.internal.platform.AndroidPlatform.AndroidCertificateChainCleaner;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static final class AndroidTrustRootIndex implements dc.squareup.okhttp3.internal.tls.TrustRootIndex {
        private final java.lang.reflect.Method findByIssuerAndSignatureMethod;
        private final javax.net.ssl.X509TrustManager trustManager;

        AndroidTrustRootIndex(javax.net.ssl.X509TrustManager x509TrustManager, java.lang.reflect.Method method) {
            this.findByIssuerAndSignatureMethod = method;
            this.trustManager = x509TrustManager;
        }

        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof dc.squareup.okhttp3.internal.platform.AndroidPlatform.AndroidTrustRootIndex)) {
                return false;
            }
            dc.squareup.okhttp3.internal.platform.AndroidPlatform.AndroidTrustRootIndex androidTrustRootIndex = (dc.squareup.okhttp3.internal.platform.AndroidPlatform.AndroidTrustRootIndex) obj;
            return this.trustManager.equals(androidTrustRootIndex.trustManager) && this.findByIssuerAndSignatureMethod.equals(androidTrustRootIndex.findByIssuerAndSignatureMethod);
        }

        @Override // dc.squareup.okhttp3.internal.tls.TrustRootIndex
        public java.security.cert.X509Certificate findByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate) {
            try {
                java.security.cert.TrustAnchor trustAnchor = (java.security.cert.TrustAnchor) this.findByIssuerAndSignatureMethod.invoke(this.trustManager, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (java.lang.IllegalAccessException e) {
                throw dc.squareup.okhttp3.internal.Util.assertionError("unable to get issues and signature", e);
            } catch (java.lang.reflect.InvocationTargetException unused) {
            }
            return null;
        }

        public int hashCode() {
            return this.trustManager.hashCode() + (this.findByIssuerAndSignatureMethod.hashCode() * 31);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static final class CloseGuard {
        private final java.lang.reflect.Method getMethod;
        private final java.lang.reflect.Method openMethod;
        private final java.lang.reflect.Method warnIfOpenMethod;

        CloseGuard(java.lang.reflect.Method method, java.lang.reflect.Method method2, java.lang.reflect.Method method3) {
            this.getMethod = method;
            this.openMethod = method2;
            this.warnIfOpenMethod = method3;
        }

        static dc.squareup.okhttp3.internal.platform.AndroidPlatform.CloseGuard get() throws java.lang.NoSuchMethodException {
            java.lang.reflect.Method method;
            java.lang.reflect.Method method2;
            java.lang.reflect.Method method3 = null;
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("dalvik.system.CloseGuard");
                java.lang.reflect.Method method4 = cls.getMethod("get", null);
                method2 = cls.getMethod("open", java.lang.String.class);
                method = cls.getMethod("warnIfOpen", null);
                method3 = method4;
            } catch (java.lang.Exception unused) {
                method = null;
                method2 = null;
            }
            return new dc.squareup.okhttp3.internal.platform.AndroidPlatform.CloseGuard(method3, method2, method);
        }

        java.lang.Object createAndOpen(java.lang.String str) {
            java.lang.reflect.Method method = this.getMethod;
            if (method != null) {
                try {
                    java.lang.Object objInvoke = method.invoke(null, null);
                    this.openMethod.invoke(objInvoke, str);
                    return objInvoke;
                } catch (java.lang.Exception unused) {
                }
            }
            return null;
        }

        boolean warnIfOpen(java.lang.Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.warnIfOpenMethod.invoke(obj, null);
                return true;
            } catch (java.lang.Exception unused) {
                return false;
            }
        }
    }

    AndroidPlatform(java.lang.Class<?> cls, dc.squareup.okhttp3.internal.platform.OptionalMethod<java.net.Socket> optionalMethod, dc.squareup.okhttp3.internal.platform.OptionalMethod<java.net.Socket> optionalMethod2, dc.squareup.okhttp3.internal.platform.OptionalMethod<java.net.Socket> optionalMethod3, dc.squareup.okhttp3.internal.platform.OptionalMethod<java.net.Socket> optionalMethod4) {
        this.sslParametersClass = cls;
        this.setUseSessionTickets = optionalMethod;
        this.setHostname = optionalMethod2;
        this.getAlpnSelectedProtocol = optionalMethod3;
        this.setAlpnProtocols = optionalMethod4;
    }

    private boolean api23IsCleartextTrafficPermitted(java.lang.String str, java.lang.Class<?> cls, java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        try {
            return ((java.lang.Boolean) cls.getMethod("isCleartextTrafficPermitted", null).invoke(obj, null)).booleanValue();
        } catch (java.lang.NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        }
    }

    private boolean api24IsCleartextTrafficPermitted(java.lang.String str, java.lang.Class<?> cls, java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        try {
            return ((java.lang.Boolean) cls.getMethod("isCleartextTrafficPermitted", java.lang.String.class).invoke(obj, str)).booleanValue();
        } catch (java.lang.NoSuchMethodException unused) {
            return api23IsCleartextTrafficPermitted(str, cls, obj);
        }
    }

    public static dc.squareup.okhttp3.internal.platform.Platform buildIfSupported() {
        java.lang.Class<?> cls;
        dc.squareup.okhttp3.internal.platform.OptionalMethod optionalMethod;
        dc.squareup.okhttp3.internal.platform.OptionalMethod optionalMethod2;
        if (getSdkInt() == 0) {
            return null;
        }
        try {
            try {
                cls = java.lang.Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (java.lang.ClassNotFoundException unused) {
                cls = java.lang.Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            java.lang.Class<?> cls2 = cls;
            dc.squareup.okhttp3.internal.platform.OptionalMethod optionalMethod3 = new dc.squareup.okhttp3.internal.platform.OptionalMethod(null, "setUseSessionTickets", java.lang.Boolean.TYPE);
            dc.squareup.okhttp3.internal.platform.OptionalMethod optionalMethod4 = new dc.squareup.okhttp3.internal.platform.OptionalMethod(null, "setHostname", java.lang.String.class);
            if (supportsAlpn()) {
                dc.squareup.okhttp3.internal.platform.OptionalMethod optionalMethod5 = new dc.squareup.okhttp3.internal.platform.OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new java.lang.Class[0]);
                optionalMethod2 = new dc.squareup.okhttp3.internal.platform.OptionalMethod(null, "setAlpnProtocols", byte[].class);
                optionalMethod = optionalMethod5;
            } else {
                optionalMethod = null;
                optionalMethod2 = null;
            }
            return new dc.squareup.okhttp3.internal.platform.AndroidPlatform(cls2, optionalMethod3, optionalMethod4, optionalMethod, optionalMethod2);
        } catch (java.lang.ClassNotFoundException unused2) {
            return null;
        }
    }

    static int getSdkInt() {
        try {
            return android.os.Build.VERSION.SDK_INT;
        } catch (java.lang.NoClassDefFoundError unused) {
            return 0;
        }
    }

    private static boolean supportsAlpn() {
        if (java.security.Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            java.lang.Class.forName("android.net.Network");
            return true;
        } catch (java.lang.ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // dc.squareup.okhttp3.internal.platform.Platform
    public dc.squareup.okhttp3.internal.tls.CertificateChainCleaner buildCertificateChainCleaner(javax.net.ssl.X509TrustManager x509TrustManager) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.net.http.X509TrustManagerExtensions");
            return new dc.squareup.okhttp3.internal.platform.AndroidPlatform.AndroidCertificateChainCleaner(cls.getConstructor(javax.net.ssl.X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", java.security.cert.X509Certificate[].class, java.lang.String.class, java.lang.String.class));
        } catch (java.lang.Exception unused) {
            return super.buildCertificateChainCleaner(x509TrustManager);
        }
    }

    @Override // dc.squareup.okhttp3.internal.platform.Platform
    public dc.squareup.okhttp3.internal.tls.TrustRootIndex buildTrustRootIndex(javax.net.ssl.X509TrustManager x509TrustManager) {
        try {
            java.lang.reflect.Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", java.security.cert.X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new dc.squareup.okhttp3.internal.platform.AndroidPlatform.AndroidTrustRootIndex(x509TrustManager, declaredMethod);
        } catch (java.lang.NoSuchMethodException unused) {
            return super.buildTrustRootIndex(x509TrustManager);
        }
    }

    @Override // dc.squareup.okhttp3.internal.platform.Platform
    public void configureTlsExtensions(javax.net.ssl.SSLSocket sSLSocket, java.lang.String str, java.util.List<dc.squareup.okhttp3.Protocol> list) throws java.io.IOException {
        if (str != null) {
            this.setUseSessionTickets.invokeOptionalWithoutCheckedException(sSLSocket, java.lang.Boolean.TRUE);
            this.setHostname.invokeOptionalWithoutCheckedException(sSLSocket, str);
        }
        dc.squareup.okhttp3.internal.platform.OptionalMethod<java.net.Socket> optionalMethod = this.setAlpnProtocols;
        if (optionalMethod == null || !optionalMethod.isSupported(sSLSocket)) {
            return;
        }
        this.setAlpnProtocols.invokeWithoutCheckedException(sSLSocket, dc.squareup.okhttp3.internal.platform.Platform.concatLengthPrefixed(list));
    }

    @Override // dc.squareup.okhttp3.internal.platform.Platform
    public void connectSocket(java.net.Socket socket, java.net.InetSocketAddress inetSocketAddress, int i) throws java.io.IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (java.lang.AssertionError e) {
            if (!dc.squareup.okhttp3.internal.Util.isAndroidGetsocknameError(e)) {
                throw e;
            }
            throw new java.io.IOException(e);
        } catch (java.lang.ClassCastException e2) {
            if (android.os.Build.VERSION.SDK_INT != 26) {
                throw e2;
            }
            java.io.IOException iOException = new java.io.IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        } catch (java.lang.SecurityException e3) {
            java.io.IOException iOException2 = new java.io.IOException("Exception in connect");
            iOException2.initCause(e3);
            throw iOException2;
        }
    }

    @Override // dc.squareup.okhttp3.internal.platform.Platform
    public javax.net.ssl.SSLContext getSSLContext() {
        try {
            if (android.os.Build.VERSION.SDK_INT < 22) {
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
        } catch (java.lang.NoClassDefFoundError unused2) {
        }
    }

    @Override // dc.squareup.okhttp3.internal.platform.Platform
    public java.lang.String getSelectedProtocol(javax.net.ssl.SSLSocket sSLSocket) {
        byte[] bArr;
        dc.squareup.okhttp3.internal.platform.OptionalMethod<java.net.Socket> optionalMethod = this.getAlpnSelectedProtocol;
        if (optionalMethod == null || !optionalMethod.isSupported(sSLSocket) || (bArr = (byte[]) this.getAlpnSelectedProtocol.invokeWithoutCheckedException(sSLSocket, new java.lang.Object[0])) == null) {
            return null;
        }
        return new java.lang.String(bArr, dc.squareup.okhttp3.internal.Util.UTF_8);
    }

    @Override // dc.squareup.okhttp3.internal.platform.Platform
    public java.lang.Object getStackTraceForCloseable(java.lang.String str) {
        return this.closeGuard.createAndOpen(str);
    }

    @Override // dc.squareup.okhttp3.internal.platform.Platform
    public boolean isCleartextTrafficPermitted(java.lang.String str) {
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return super.isCleartextTrafficPermitted(str);
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.security.NetworkSecurityPolicy");
            return api24IsCleartextTrafficPermitted(str, cls, cls.getMethod("getInstance", null).invoke(null, null));
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        } catch (java.lang.IllegalAccessException e) {
            e = e;
            throw dc.squareup.okhttp3.internal.Util.assertionError("unable to determine cleartext support", e);
        } catch (java.lang.IllegalArgumentException e2) {
            e = e2;
            throw dc.squareup.okhttp3.internal.Util.assertionError("unable to determine cleartext support", e);
        } catch (java.lang.reflect.InvocationTargetException e3) {
            e = e3;
            throw dc.squareup.okhttp3.internal.Util.assertionError("unable to determine cleartext support", e);
        }
    }

    @Override // dc.squareup.okhttp3.internal.platform.Platform
    public void log(int i, java.lang.String str, java.lang.Throwable th) {
        int iMin;
        int i2 = i != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + android.util.Log.getStackTraceString(th);
        }
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int iIndexOf = str.indexOf(10, i3);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = java.lang.Math.min(iIndexOf, i3 + MAX_LOG_LENGTH);
                android.util.Log.println(i2, "OkHttp", str.substring(i3, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i3 = iMin;
                }
            }
            i3 = iMin + 1;
        }
    }

    @Override // dc.squareup.okhttp3.internal.platform.Platform
    public void logCloseableLeak(java.lang.String str, java.lang.Object obj) {
        if (this.closeGuard.warnIfOpen(obj)) {
            return;
        }
        log(5, str, null);
    }

    @Override // dc.squareup.okhttp3.internal.platform.Platform
    protected javax.net.ssl.X509TrustManager trustManager(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
        java.lang.Object fieldOrNull = dc.squareup.okhttp3.internal.platform.Platform.readFieldOrNull(sSLSocketFactory, this.sslParametersClass, "sslParameters");
        if (fieldOrNull == null) {
            try {
                fieldOrNull = dc.squareup.okhttp3.internal.platform.Platform.readFieldOrNull(sSLSocketFactory, java.lang.Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (java.lang.ClassNotFoundException unused) {
                return super.trustManager(sSLSocketFactory);
            }
        }
        javax.net.ssl.X509TrustManager x509TrustManager = (javax.net.ssl.X509TrustManager) dc.squareup.okhttp3.internal.platform.Platform.readFieldOrNull(fieldOrNull, javax.net.ssl.X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (javax.net.ssl.X509TrustManager) dc.squareup.okhttp3.internal.platform.Platform.readFieldOrNull(fieldOrNull, javax.net.ssl.X509TrustManager.class, "trustManager");
    }
}
