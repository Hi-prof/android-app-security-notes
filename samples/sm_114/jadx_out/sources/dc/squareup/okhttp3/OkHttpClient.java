package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class OkHttpClient implements java.lang.Cloneable, dc.squareup.okhttp3.Call.Factory, dc.squareup.okhttp3.WebSocket.Factory {
    private static javax.net.ssl.SSLSocketFactory tempSSLFactory;
    final dc.squareup.okhttp3.Authenticator authenticator;
    final dc.squareup.okhttp3.Cache cache;
    final int callTimeout;
    final dc.squareup.okhttp3.internal.tls.CertificateChainCleaner certificateChainCleaner;
    final dc.squareup.okhttp3.CertificatePinner certificatePinner;
    final int connectTimeout;
    final dc.squareup.okhttp3.ConnectionPool connectionPool;
    final java.util.List<dc.squareup.okhttp3.ConnectionSpec> connectionSpecs;
    final dc.squareup.okhttp3.CookieJar cookieJar;
    final dc.squareup.okhttp3.Dispatcher dispatcher;
    final dc.squareup.okhttp3.Dns dns;
    final dc.squareup.okhttp3.EventListener.Factory eventListenerFactory;
    final boolean followRedirects;
    final boolean followSslRedirects;
    final javax.net.ssl.HostnameVerifier hostnameVerifier;
    final java.util.List<dc.squareup.okhttp3.Interceptor> interceptors;
    final dc.squareup.okhttp3.internal.cache.InternalCache internalCache;
    final java.util.List<dc.squareup.okhttp3.Interceptor> networkInterceptors;
    final int pingInterval;
    final java.util.List<dc.squareup.okhttp3.Protocol> protocols;
    final java.net.Proxy proxy;
    final dc.squareup.okhttp3.Authenticator proxyAuthenticator;
    final java.net.ProxySelector proxySelector;
    final int readTimeout;
    final boolean retryOnConnectionFailure;
    final javax.net.SocketFactory socketFactory;
    final javax.net.ssl.SSLSocketFactory sslSocketFactory;
    final int writeTimeout;
    static final java.util.List<dc.squareup.okhttp3.Protocol> DEFAULT_PROTOCOLS = dc.squareup.okhttp3.internal.Util.immutableList(dc.squareup.okhttp3.Protocol.HTTP_2, dc.squareup.okhttp3.Protocol.HTTP_1_1);
    static final java.util.List<dc.squareup.okhttp3.ConnectionSpec> DEFAULT_CONNECTION_SPECS = dc.squareup.okhttp3.internal.Util.immutableList(dc.squareup.okhttp3.ConnectionSpec.MODERN_TLS, dc.squareup.okhttp3.ConnectionSpec.CLEARTEXT);

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static final class Builder {
        dc.squareup.okhttp3.Authenticator authenticator;
        dc.squareup.okhttp3.Cache cache;
        int callTimeout;
        dc.squareup.okhttp3.internal.tls.CertificateChainCleaner certificateChainCleaner;
        dc.squareup.okhttp3.CertificatePinner certificatePinner;
        int connectTimeout;
        dc.squareup.okhttp3.ConnectionPool connectionPool;
        java.util.List<dc.squareup.okhttp3.ConnectionSpec> connectionSpecs;
        dc.squareup.okhttp3.CookieJar cookieJar;
        dc.squareup.okhttp3.Dispatcher dispatcher;
        dc.squareup.okhttp3.Dns dns;
        dc.squareup.okhttp3.EventListener.Factory eventListenerFactory;
        boolean followRedirects;
        boolean followSslRedirects;
        javax.net.ssl.HostnameVerifier hostnameVerifier;
        final java.util.List<dc.squareup.okhttp3.Interceptor> interceptors;
        dc.squareup.okhttp3.internal.cache.InternalCache internalCache;
        final java.util.List<dc.squareup.okhttp3.Interceptor> networkInterceptors;
        int pingInterval;
        java.util.List<dc.squareup.okhttp3.Protocol> protocols;
        java.net.Proxy proxy;
        dc.squareup.okhttp3.Authenticator proxyAuthenticator;
        java.net.ProxySelector proxySelector;
        int readTimeout;
        boolean retryOnConnectionFailure;
        javax.net.SocketFactory socketFactory;
        javax.net.ssl.SSLSocketFactory sslSocketFactory;
        int writeTimeout;

        public Builder() {
            this.interceptors = new java.util.ArrayList();
            this.networkInterceptors = new java.util.ArrayList();
            this.dispatcher = new dc.squareup.okhttp3.Dispatcher();
            this.protocols = dc.squareup.okhttp3.OkHttpClient.DEFAULT_PROTOCOLS;
            this.connectionSpecs = dc.squareup.okhttp3.OkHttpClient.DEFAULT_CONNECTION_SPECS;
            this.eventListenerFactory = dc.squareup.okhttp3.EventListener.factory(dc.squareup.okhttp3.EventListener.NONE);
            java.net.ProxySelector proxySelector = java.net.ProxySelector.getDefault();
            this.proxySelector = proxySelector;
            if (proxySelector == null) {
                this.proxySelector = new dc.squareup.okhttp3.internal.proxy.NullProxySelector();
            }
            this.cookieJar = dc.squareup.okhttp3.CookieJar.NO_COOKIES;
            this.socketFactory = javax.net.SocketFactory.getDefault();
            this.hostnameVerifier = dc.squareup.okhttp3.internal.tls.OkHostnameVerifier.INSTANCE;
            this.certificatePinner = dc.squareup.okhttp3.CertificatePinner.DEFAULT;
            dc.squareup.okhttp3.Authenticator authenticator = dc.squareup.okhttp3.Authenticator.NONE;
            this.proxyAuthenticator = authenticator;
            this.authenticator = authenticator;
            this.connectionPool = new dc.squareup.okhttp3.ConnectionPool();
            this.dns = dc.squareup.okhttp3.Dns.SYSTEM;
            this.followSslRedirects = true;
            this.followRedirects = true;
            this.retryOnConnectionFailure = true;
            this.callTimeout = 0;
            this.connectTimeout = io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH;
            this.readTimeout = io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH;
            this.writeTimeout = io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH;
            this.pingInterval = 0;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder addInterceptor(dc.squareup.okhttp3.Interceptor interceptor) {
            if (interceptor == null) {
                throw new java.lang.IllegalArgumentException("interceptor == null");
            }
            this.interceptors.add(interceptor);
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder addNetworkInterceptor(dc.squareup.okhttp3.Interceptor interceptor) {
            if (interceptor == null) {
                throw new java.lang.IllegalArgumentException("interceptor == null");
            }
            this.networkInterceptors.add(interceptor);
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder authenticator(dc.squareup.okhttp3.Authenticator authenticator) {
            if (authenticator == null) {
                throw new java.lang.NullPointerException("authenticator == null");
            }
            this.authenticator = authenticator;
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient build() {
            return new dc.squareup.okhttp3.OkHttpClient(this);
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder cache(dc.squareup.okhttp3.Cache cache) {
            this.cache = cache;
            this.internalCache = null;
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder callTimeout(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.callTimeout = dc.squareup.okhttp3.internal.Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder certificatePinner(dc.squareup.okhttp3.CertificatePinner certificatePinner) {
            if (certificatePinner == null) {
                throw new java.lang.NullPointerException("certificatePinner == null");
            }
            this.certificatePinner = certificatePinner;
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder connectTimeout(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.connectTimeout = dc.squareup.okhttp3.internal.Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder connectionPool(dc.squareup.okhttp3.ConnectionPool connectionPool) {
            if (connectionPool == null) {
                throw new java.lang.NullPointerException("connectionPool == null");
            }
            this.connectionPool = connectionPool;
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder connectionSpecs(java.util.List<dc.squareup.okhttp3.ConnectionSpec> list) {
            this.connectionSpecs = dc.squareup.okhttp3.internal.Util.immutableList(list);
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder cookieJar(dc.squareup.okhttp3.CookieJar cookieJar) {
            if (cookieJar == null) {
                throw new java.lang.NullPointerException("cookieJar == null");
            }
            this.cookieJar = cookieJar;
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder dispatcher(dc.squareup.okhttp3.Dispatcher dispatcher) {
            if (dispatcher == null) {
                throw new java.lang.IllegalArgumentException("dispatcher == null");
            }
            this.dispatcher = dispatcher;
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder dns(dc.squareup.okhttp3.Dns dns) {
            if (dns == null) {
                throw new java.lang.NullPointerException("dns == null");
            }
            this.dns = dns;
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder eventListener(dc.squareup.okhttp3.EventListener eventListener) {
            if (eventListener == null) {
                throw new java.lang.NullPointerException("eventListener == null");
            }
            this.eventListenerFactory = dc.squareup.okhttp3.EventListener.factory(eventListener);
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder eventListenerFactory(dc.squareup.okhttp3.EventListener.Factory factory) {
            if (factory == null) {
                throw new java.lang.NullPointerException("eventListenerFactory == null");
            }
            this.eventListenerFactory = factory;
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder followSslRedirects(boolean z) {
            this.followSslRedirects = z;
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder hostnameVerifier(javax.net.ssl.HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier == null) {
                throw new java.lang.NullPointerException("hostnameVerifier == null");
            }
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public java.util.List<dc.squareup.okhttp3.Interceptor> interceptors() {
            return this.interceptors;
        }

        public java.util.List<dc.squareup.okhttp3.Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder pingInterval(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.pingInterval = dc.squareup.okhttp3.internal.Util.checkDuration("interval", j, timeUnit);
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder protocols(java.util.List<dc.squareup.okhttp3.Protocol> list) {
            java.util.ArrayList arrayList = new java.util.ArrayList(list);
            dc.squareup.okhttp3.Protocol protocol = dc.squareup.okhttp3.Protocol.H2_PRIOR_KNOWLEDGE;
            if (!arrayList.contains(protocol) && !arrayList.contains(dc.squareup.okhttp3.Protocol.HTTP_1_1)) {
                throw new java.lang.IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            }
            if (arrayList.contains(protocol) && arrayList.size() > 1) {
                throw new java.lang.IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            }
            if (arrayList.contains(dc.squareup.okhttp3.Protocol.HTTP_1_0)) {
                throw new java.lang.IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            }
            if (arrayList.contains(null)) {
                throw new java.lang.IllegalArgumentException("protocols must not contain null");
            }
            arrayList.remove(dc.squareup.okhttp3.Protocol.SPDY_3);
            this.protocols = java.util.Collections.unmodifiableList(arrayList);
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder proxy(java.net.Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder proxyAuthenticator(dc.squareup.okhttp3.Authenticator authenticator) {
            if (authenticator == null) {
                throw new java.lang.NullPointerException("proxyAuthenticator == null");
            }
            this.proxyAuthenticator = authenticator;
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder proxySelector(java.net.ProxySelector proxySelector) {
            if (proxySelector == null) {
                throw new java.lang.NullPointerException("proxySelector == null");
            }
            this.proxySelector = proxySelector;
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder readTimeout(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.readTimeout = dc.squareup.okhttp3.internal.Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder retryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        void setInternalCache(dc.squareup.okhttp3.internal.cache.InternalCache internalCache) {
            this.internalCache = internalCache;
            this.cache = null;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder socketFactory(javax.net.SocketFactory socketFactory) {
            if (socketFactory == null) {
                throw new java.lang.NullPointerException("socketFactory == null");
            }
            this.socketFactory = socketFactory;
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder sslSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory == null) {
                throw new java.lang.NullPointerException("sslSocketFactory == null");
            }
            this.sslSocketFactory = sSLSocketFactory;
            this.certificateChainCleaner = dc.squareup.okhttp3.internal.platform.Platform.get().buildCertificateChainCleaner(sSLSocketFactory);
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder writeTimeout(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.writeTimeout = dc.squareup.okhttp3.internal.Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder callTimeout(java.time.Duration duration) {
            this.callTimeout = dc.squareup.okhttp3.internal.Util.checkDuration("timeout", duration.toMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder connectTimeout(java.time.Duration duration) {
            this.connectTimeout = dc.squareup.okhttp3.internal.Util.checkDuration("timeout", duration.toMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder pingInterval(java.time.Duration duration) {
            this.pingInterval = dc.squareup.okhttp3.internal.Util.checkDuration("timeout", duration.toMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder readTimeout(java.time.Duration duration) {
            this.readTimeout = dc.squareup.okhttp3.internal.Util.checkDuration("timeout", duration.toMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder writeTimeout(java.time.Duration duration) {
            this.writeTimeout = dc.squareup.okhttp3.internal.Util.checkDuration("timeout", duration.toMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
            return this;
        }

        public dc.squareup.okhttp3.OkHttpClient.Builder sslSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory, javax.net.ssl.X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new java.lang.NullPointerException("sslSocketFactory == null");
            }
            if (x509TrustManager != null) {
                this.sslSocketFactory = sSLSocketFactory;
                this.certificateChainCleaner = dc.squareup.okhttp3.internal.tls.CertificateChainCleaner.get(x509TrustManager);
                return this;
            }
            throw new java.lang.NullPointerException("trustManager == null");
        }

        Builder(dc.squareup.okhttp3.OkHttpClient okHttpClient) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            this.interceptors = arrayList;
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            this.networkInterceptors = arrayList2;
            this.dispatcher = okHttpClient.dispatcher;
            this.proxy = okHttpClient.proxy;
            this.protocols = okHttpClient.protocols;
            this.connectionSpecs = okHttpClient.connectionSpecs;
            arrayList.addAll(okHttpClient.interceptors);
            arrayList2.addAll(okHttpClient.networkInterceptors);
            this.eventListenerFactory = okHttpClient.eventListenerFactory;
            this.proxySelector = okHttpClient.proxySelector;
            this.cookieJar = okHttpClient.cookieJar;
            this.internalCache = okHttpClient.internalCache;
            this.cache = okHttpClient.cache;
            this.socketFactory = okHttpClient.socketFactory;
            this.sslSocketFactory = okHttpClient.sslSocketFactory;
            this.certificateChainCleaner = okHttpClient.certificateChainCleaner;
            this.hostnameVerifier = okHttpClient.hostnameVerifier;
            this.certificatePinner = okHttpClient.certificatePinner;
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator;
            this.authenticator = okHttpClient.authenticator;
            this.connectionPool = okHttpClient.connectionPool;
            this.dns = okHttpClient.dns;
            this.followSslRedirects = okHttpClient.followSslRedirects;
            this.followRedirects = okHttpClient.followRedirects;
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure;
            this.callTimeout = okHttpClient.callTimeout;
            this.connectTimeout = okHttpClient.connectTimeout;
            this.readTimeout = okHttpClient.readTimeout;
            this.writeTimeout = okHttpClient.writeTimeout;
            this.pingInterval = okHttpClient.pingInterval;
        }
    }

    static {
        dc.squareup.okhttp3.internal.Internal.instance = new dc.squareup.okhttp3.internal.Internal() { // from class: dc.squareup.okhttp3.OkHttpClient.1
            @Override // dc.squareup.okhttp3.internal.Internal
            public void addLenient(dc.squareup.okhttp3.Headers.Builder builder, java.lang.String str) {
                builder.addLenient(str);
            }

            @Override // dc.squareup.okhttp3.internal.Internal
            public void apply(dc.squareup.okhttp3.ConnectionSpec connectionSpec, javax.net.ssl.SSLSocket sSLSocket, boolean z) {
                connectionSpec.apply(sSLSocket, z);
            }

            @Override // dc.squareup.okhttp3.internal.Internal
            public int code(dc.squareup.okhttp3.Response.Builder builder) {
                return builder.code;
            }

            @Override // dc.squareup.okhttp3.internal.Internal
            public boolean connectionBecameIdle(dc.squareup.okhttp3.ConnectionPool connectionPool, dc.squareup.okhttp3.internal.connection.RealConnection realConnection) {
                return connectionPool.connectionBecameIdle(realConnection);
            }

            @Override // dc.squareup.okhttp3.internal.Internal
            public java.net.Socket deduplicate(dc.squareup.okhttp3.ConnectionPool connectionPool, dc.squareup.okhttp3.Address address, dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation) {
                return connectionPool.deduplicate(address, streamAllocation);
            }

            @Override // dc.squareup.okhttp3.internal.Internal
            public boolean equalsNonHost(dc.squareup.okhttp3.Address address, dc.squareup.okhttp3.Address address2) {
                return address.equalsNonHost(address2);
            }

            @Override // dc.squareup.okhttp3.internal.Internal
            public dc.squareup.okhttp3.internal.connection.RealConnection get(dc.squareup.okhttp3.ConnectionPool connectionPool, dc.squareup.okhttp3.Address address, dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation, dc.squareup.okhttp3.Route route) {
                return connectionPool.get(address, streamAllocation, route);
            }

            @Override // dc.squareup.okhttp3.internal.Internal
            public boolean isInvalidHttpUrlHost(java.lang.IllegalArgumentException illegalArgumentException) {
                return illegalArgumentException.getMessage().startsWith("Invalid URL host");
            }

            @Override // dc.squareup.okhttp3.internal.Internal
            public dc.squareup.okhttp3.Call newWebSocketCall(dc.squareup.okhttp3.OkHttpClient okHttpClient, dc.squareup.okhttp3.Request request) {
                return dc.squareup.okhttp3.RealCall.newRealCall(okHttpClient, request, true);
            }

            @Override // dc.squareup.okhttp3.internal.Internal
            public void put(dc.squareup.okhttp3.ConnectionPool connectionPool, dc.squareup.okhttp3.internal.connection.RealConnection realConnection) {
                connectionPool.put(realConnection);
            }

            @Override // dc.squareup.okhttp3.internal.Internal
            public dc.squareup.okhttp3.internal.connection.RouteDatabase routeDatabase(dc.squareup.okhttp3.ConnectionPool connectionPool) {
                return connectionPool.routeDatabase;
            }

            @Override // dc.squareup.okhttp3.internal.Internal
            public void setCache(dc.squareup.okhttp3.OkHttpClient.Builder builder, dc.squareup.okhttp3.internal.cache.InternalCache internalCache) {
                builder.setInternalCache(internalCache);
            }

            @Override // dc.squareup.okhttp3.internal.Internal
            public dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation(dc.squareup.okhttp3.Call call) {
                return ((dc.squareup.okhttp3.RealCall) call).streamAllocation();
            }

            @Override // dc.squareup.okhttp3.internal.Internal
            public java.io.IOException timeoutExit(dc.squareup.okhttp3.Call call, java.io.IOException iOException) {
                return ((dc.squareup.okhttp3.RealCall) call).timeoutExit(iOException);
            }

            @Override // dc.squareup.okhttp3.internal.Internal
            public void addLenient(dc.squareup.okhttp3.Headers.Builder builder, java.lang.String str, java.lang.String str2) {
                builder.addLenient(str, str2);
            }
        };
        tempSSLFactory = null;
    }

    public OkHttpClient() {
        this(new dc.squareup.okhttp3.OkHttpClient.Builder());
    }

    private static javax.net.ssl.SSLSocketFactory newSslSocketFactory(javax.net.ssl.X509TrustManager x509TrustManager) {
        try {
            javax.net.ssl.SSLContext sSLContext = dc.squareup.okhttp3.internal.platform.Platform.get().getSSLContext();
            sSLContext.init(null, new javax.net.ssl.TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (java.security.GeneralSecurityException e) {
            throw dc.squareup.okhttp3.internal.Util.assertionError("No System TLS", e);
        }
    }

    public dc.squareup.okhttp3.Authenticator authenticator() {
        return this.authenticator;
    }

    public dc.squareup.okhttp3.Cache cache() {
        return this.cache;
    }

    public int callTimeoutMillis() {
        return this.callTimeout;
    }

    public dc.squareup.okhttp3.CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    public dc.squareup.okhttp3.ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    public java.util.List<dc.squareup.okhttp3.ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public dc.squareup.okhttp3.CookieJar cookieJar() {
        return this.cookieJar;
    }

    public dc.squareup.okhttp3.Dispatcher dispatcher() {
        return this.dispatcher;
    }

    public dc.squareup.okhttp3.Dns dns() {
        return this.dns;
    }

    public dc.squareup.okhttp3.EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public boolean followRedirects() {
        return this.followRedirects;
    }

    public boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    public javax.net.ssl.HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public java.util.List<dc.squareup.okhttp3.Interceptor> interceptors() {
        return this.interceptors;
    }

    dc.squareup.okhttp3.internal.cache.InternalCache internalCache() {
        dc.squareup.okhttp3.Cache cache = this.cache;
        return cache != null ? cache.internalCache : this.internalCache;
    }

    public java.util.List<dc.squareup.okhttp3.Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public dc.squareup.okhttp3.OkHttpClient.Builder newBuilder() {
        return new dc.squareup.okhttp3.OkHttpClient.Builder(this);
    }

    @Override // dc.squareup.okhttp3.Call.Factory
    public dc.squareup.okhttp3.Call newCall(dc.squareup.okhttp3.Request request) {
        return dc.squareup.okhttp3.RealCall.newRealCall(this, request, false);
    }

    @Override // dc.squareup.okhttp3.WebSocket.Factory
    public dc.squareup.okhttp3.WebSocket newWebSocket(dc.squareup.okhttp3.Request request, dc.squareup.okhttp3.WebSocketListener webSocketListener) {
        dc.squareup.okhttp3.internal.ws.RealWebSocket realWebSocket = new dc.squareup.okhttp3.internal.ws.RealWebSocket(request, webSocketListener, new java.util.Random(), this.pingInterval);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public int pingIntervalMillis() {
        return this.pingInterval;
    }

    public java.util.List<dc.squareup.okhttp3.Protocol> protocols() {
        return this.protocols;
    }

    public java.net.Proxy proxy() {
        return this.proxy;
    }

    public dc.squareup.okhttp3.Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public java.net.ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    public boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public javax.net.SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public javax.net.ssl.SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    OkHttpClient(dc.squareup.okhttp3.OkHttpClient.Builder builder) {
        boolean z;
        this.dispatcher = builder.dispatcher;
        this.proxy = builder.proxy;
        this.protocols = builder.protocols;
        java.util.List<dc.squareup.okhttp3.ConnectionSpec> list = builder.connectionSpecs;
        this.connectionSpecs = list;
        this.interceptors = dc.squareup.okhttp3.internal.Util.immutableList(builder.interceptors);
        this.networkInterceptors = dc.squareup.okhttp3.internal.Util.immutableList(builder.networkInterceptors);
        this.eventListenerFactory = builder.eventListenerFactory;
        this.proxySelector = builder.proxySelector;
        this.cookieJar = builder.cookieJar;
        this.cache = builder.cache;
        this.internalCache = builder.internalCache;
        this.socketFactory = builder.socketFactory;
        java.util.Iterator<dc.squareup.okhttp3.ConnectionSpec> it = list.iterator();
        loop0: while (true) {
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                } else {
                    z = z || it.next().isTls();
                }
            }
        }
        javax.net.ssl.SSLSocketFactory sSLSocketFactory = builder.sslSocketFactory;
        if (sSLSocketFactory == null && z) {
            javax.net.ssl.X509TrustManager x509TrustManagerPlatformTrustManager = dc.squareup.okhttp3.internal.Util.platformTrustManager();
            if (tempSSLFactory == null) {
                tempSSLFactory = newSslSocketFactory(x509TrustManagerPlatformTrustManager);
            }
            this.sslSocketFactory = tempSSLFactory;
            this.certificateChainCleaner = dc.squareup.okhttp3.internal.tls.CertificateChainCleaner.get(x509TrustManagerPlatformTrustManager);
        } else {
            this.sslSocketFactory = sSLSocketFactory;
            this.certificateChainCleaner = builder.certificateChainCleaner;
        }
        if (this.sslSocketFactory != null) {
            dc.squareup.okhttp3.internal.platform.Platform.get().configureSslSocketFactory(this.sslSocketFactory);
        }
        this.hostnameVerifier = builder.hostnameVerifier;
        this.certificatePinner = builder.certificatePinner.withCertificateChainCleaner(this.certificateChainCleaner);
        this.proxyAuthenticator = builder.proxyAuthenticator;
        this.authenticator = builder.authenticator;
        this.connectionPool = builder.connectionPool;
        this.dns = builder.dns;
        this.followSslRedirects = builder.followSslRedirects;
        this.followRedirects = builder.followRedirects;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.callTimeout = builder.callTimeout;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.writeTimeout = builder.writeTimeout;
        this.pingInterval = builder.pingInterval;
        if (this.interceptors.contains(null)) {
            throw new java.lang.IllegalStateException("Null interceptor: " + this.interceptors);
        }
        if (this.networkInterceptors.contains(null)) {
            throw new java.lang.IllegalStateException("Null network interceptor: " + this.networkInterceptors);
        }
    }
}
