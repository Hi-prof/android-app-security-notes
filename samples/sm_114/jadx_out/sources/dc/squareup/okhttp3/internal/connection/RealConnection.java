package dc.squareup.okhttp3.internal.connection;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class RealConnection extends dc.squareup.okhttp3.internal.http2.Http2Connection.Listener implements dc.squareup.okhttp3.Connection {
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final java.lang.String NPE_THROW_WITH_NULL = "throw with null exception";
    private final dc.squareup.okhttp3.ConnectionPool connectionPool;
    private dc.squareup.okhttp3.Handshake handshake;
    private dc.squareup.okhttp3.internal.http2.Http2Connection http2Connection;
    public boolean noNewStreams;
    private dc.squareup.okhttp3.Protocol protocol;
    private java.net.Socket rawSocket;
    private final dc.squareup.okhttp3.Route route;
    private dc.squareup.okio.BufferedSink sink;
    private java.net.Socket socket;
    private dc.squareup.okio.BufferedSource source;
    public int successCount;
    public int allocationLimit = 1;
    public final java.util.List<java.lang.ref.Reference<dc.squareup.okhttp3.internal.connection.StreamAllocation>> allocations = new java.util.ArrayList();
    public long idleAtNanos = Long.MAX_VALUE;

    public RealConnection(dc.squareup.okhttp3.ConnectionPool connectionPool, dc.squareup.okhttp3.Route route) {
        this.connectionPool = connectionPool;
        this.route = route;
    }

    private void connectSocket(int i, int i2, dc.squareup.okhttp3.Call call, dc.squareup.okhttp3.EventListener eventListener) throws java.io.IOException {
        java.net.Proxy proxy = this.route.proxy();
        this.rawSocket = (proxy.type() == java.net.Proxy.Type.DIRECT || proxy.type() == java.net.Proxy.Type.HTTP) ? this.route.address().socketFactory().createSocket() : new java.net.Socket(proxy);
        eventListener.connectStart(call, this.route.socketAddress(), proxy);
        this.rawSocket.setSoTimeout(i2);
        try {
            dc.squareup.okhttp3.internal.platform.Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), i);
            try {
                this.source = dc.squareup.okio.Okio.buffer(dc.squareup.okio.Okio.source(this.rawSocket));
                this.sink = dc.squareup.okio.Okio.buffer(dc.squareup.okio.Okio.sink(this.rawSocket));
            } catch (java.lang.NullPointerException e) {
                if (NPE_THROW_WITH_NULL.equals(e.getMessage())) {
                    throw new java.io.IOException(e);
                }
            }
        } catch (java.net.ConnectException e2) {
            java.net.ConnectException connectException = new java.net.ConnectException("Failed to connect to " + this.route.socketAddress());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void connectTls(dc.squareup.okhttp3.internal.connection.ConnectionSpecSelector connectionSpecSelector) throws java.lang.Throwable {
        dc.squareup.okhttp3.Address address = this.route.address();
        javax.net.ssl.SSLSocket sSLSocket = null;
        try {
            try {
                javax.net.ssl.SSLSocket sSLSocket2 = (javax.net.ssl.SSLSocket) address.sslSocketFactory().createSocket(this.rawSocket, address.url().host(), address.url().port(), true);
                try {
                    dc.squareup.okhttp3.ConnectionSpec connectionSpecConfigureSecureSocket = connectionSpecSelector.configureSecureSocket(sSLSocket2);
                    if (connectionSpecConfigureSecureSocket.supportsTlsExtensions()) {
                        dc.squareup.okhttp3.internal.platform.Platform.get().configureTlsExtensions(sSLSocket2, address.url().host(), address.protocols());
                    }
                    sSLSocket2.startHandshake();
                    javax.net.ssl.SSLSession session = sSLSocket2.getSession();
                    dc.squareup.okhttp3.Handshake handshake = dc.squareup.okhttp3.Handshake.get(session);
                    if (address.hostnameVerifier().verify(address.url().host(), session)) {
                        address.certificatePinner().check(address.url().host(), handshake.peerCertificates());
                        java.lang.String selectedProtocol = connectionSpecConfigureSecureSocket.supportsTlsExtensions() ? dc.squareup.okhttp3.internal.platform.Platform.get().getSelectedProtocol(sSLSocket2) : null;
                        this.socket = sSLSocket2;
                        this.source = dc.squareup.okio.Okio.buffer(dc.squareup.okio.Okio.source(sSLSocket2));
                        this.sink = dc.squareup.okio.Okio.buffer(dc.squareup.okio.Okio.sink(this.socket));
                        this.handshake = handshake;
                        this.protocol = selectedProtocol != null ? dc.squareup.okhttp3.Protocol.get(selectedProtocol) : dc.squareup.okhttp3.Protocol.HTTP_1_1;
                        dc.squareup.okhttp3.internal.platform.Platform.get().afterHandshake(sSLSocket2);
                        return;
                    }
                    java.util.List<java.security.cert.Certificate> listPeerCertificates = handshake.peerCertificates();
                    if (listPeerCertificates.isEmpty()) {
                        throw new javax.net.ssl.SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified (no certificates)");
                    }
                    java.security.cert.X509Certificate x509Certificate = (java.security.cert.X509Certificate) listPeerCertificates.get(0);
                    throw new javax.net.ssl.SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified:\n    certificate: " + dc.squareup.okhttp3.CertificatePinner.pin(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + dc.squareup.okhttp3.internal.tls.OkHostnameVerifier.allSubjectAltNames(x509Certificate));
                } catch (java.lang.AssertionError e) {
                    e = e;
                    if (!dc.squareup.okhttp3.internal.Util.isAndroidGetsocknameError(e)) {
                        throw e;
                    }
                    throw new java.io.IOException(e);
                } catch (java.lang.Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        dc.squareup.okhttp3.internal.platform.Platform.get().afterHandshake(sSLSocket);
                    }
                    dc.squareup.okhttp3.internal.Util.closeQuietly((java.net.Socket) sSLSocket);
                    throw th;
                }
            } catch (java.lang.AssertionError e2) {
                e = e2;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private void connectTunnel(int i, int i2, int i3, dc.squareup.okhttp3.Call call, dc.squareup.okhttp3.EventListener eventListener) throws java.io.IOException {
        dc.squareup.okhttp3.Request requestCreateTunnelRequest = createTunnelRequest();
        dc.squareup.okhttp3.HttpUrl httpUrlUrl = requestCreateTunnelRequest.url();
        for (int i4 = 0; i4 < 21; i4++) {
            connectSocket(i, i2, call, eventListener);
            requestCreateTunnelRequest = createTunnel(i2, i3, requestCreateTunnelRequest, httpUrlUrl);
            if (requestCreateTunnelRequest == null) {
                return;
            }
            dc.squareup.okhttp3.internal.Util.closeQuietly(this.rawSocket);
            this.rawSocket = null;
            this.sink = null;
            this.source = null;
            eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), null);
        }
    }

    private dc.squareup.okhttp3.Request createTunnel(int i, int i2, dc.squareup.okhttp3.Request request, dc.squareup.okhttp3.HttpUrl httpUrl) throws java.io.IOException {
        java.lang.String str = "CONNECT " + dc.squareup.okhttp3.internal.Util.hostHeader(httpUrl, true) + " HTTP/1.1";
        while (true) {
            dc.squareup.okhttp3.internal.http1.Http1Codec http1Codec = new dc.squareup.okhttp3.internal.http1.Http1Codec(null, null, this.source, this.sink);
            java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
            this.source.timeout().timeout(i, timeUnit);
            this.sink.timeout().timeout(i2, timeUnit);
            http1Codec.writeRequest(request.headers(), str);
            http1Codec.finishRequest();
            dc.squareup.okhttp3.Response responseBuild = http1Codec.readResponseHeaders(false).request(request).build();
            long jContentLength = dc.squareup.okhttp3.internal.http.HttpHeaders.contentLength(responseBuild);
            if (jContentLength == -1) {
                jContentLength = 0;
            }
            dc.squareup.okio.Source sourceNewFixedLengthSource = http1Codec.newFixedLengthSource(jContentLength);
            dc.squareup.okhttp3.internal.Util.skipAll(sourceNewFixedLengthSource, Integer.MAX_VALUE, timeUnit);
            sourceNewFixedLengthSource.close();
            int iCode = responseBuild.code();
            if (iCode == 200) {
                if (this.source.buffer().exhausted() && this.sink.buffer().exhausted()) {
                    return null;
                }
                throw new java.io.IOException("TLS tunnel buffered too many bytes!");
            }
            if (iCode != 407) {
                throw new java.io.IOException("Unexpected response code for CONNECT: " + responseBuild.code());
            }
            dc.squareup.okhttp3.Request requestAuthenticate = this.route.address().proxyAuthenticator().authenticate(this.route, responseBuild);
            if (requestAuthenticate == null) {
                throw new java.io.IOException("Failed to authenticate with proxy");
            }
            if (io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE.equalsIgnoreCase(responseBuild.header("Connection"))) {
                return requestAuthenticate;
            }
            request = requestAuthenticate;
        }
    }

    private dc.squareup.okhttp3.Request createTunnelRequest() throws java.io.IOException {
        dc.squareup.okhttp3.Request requestBuild = new dc.squareup.okhttp3.Request.Builder().url(this.route.address().url()).method("CONNECT", null).header("Host", dc.squareup.okhttp3.internal.Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header(io.dcloud.common.DHInterface.IWebview.USER_AGENT, dc.squareup.okhttp3.internal.Version.userAgent()).build();
        dc.squareup.okhttp3.Request requestAuthenticate = this.route.address().proxyAuthenticator().authenticate(this.route, new dc.squareup.okhttp3.Response.Builder().request(requestBuild).protocol(dc.squareup.okhttp3.Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(dc.squareup.okhttp3.internal.Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header("Proxy-Authenticate", "OkHttp-Preemptive").build());
        return requestAuthenticate != null ? requestAuthenticate : requestBuild;
    }

    private void establishProtocol(dc.squareup.okhttp3.internal.connection.ConnectionSpecSelector connectionSpecSelector, int i, dc.squareup.okhttp3.Call call, dc.squareup.okhttp3.EventListener eventListener) throws java.lang.Throwable {
        if (this.route.address().sslSocketFactory() != null) {
            eventListener.secureConnectStart(call);
            connectTls(connectionSpecSelector);
            eventListener.secureConnectEnd(call, this.handshake);
            if (this.protocol == dc.squareup.okhttp3.Protocol.HTTP_2) {
                startHttp2(i);
                return;
            }
            return;
        }
        java.util.List<dc.squareup.okhttp3.Protocol> listProtocols = this.route.address().protocols();
        dc.squareup.okhttp3.Protocol protocol = dc.squareup.okhttp3.Protocol.H2_PRIOR_KNOWLEDGE;
        if (!listProtocols.contains(protocol)) {
            this.socket = this.rawSocket;
            this.protocol = dc.squareup.okhttp3.Protocol.HTTP_1_1;
        } else {
            this.socket = this.rawSocket;
            this.protocol = protocol;
            startHttp2(i);
        }
    }

    private void startHttp2(int i) throws java.io.IOException {
        this.socket.setSoTimeout(0);
        dc.squareup.okhttp3.internal.http2.Http2Connection http2ConnectionBuild = new dc.squareup.okhttp3.internal.http2.Http2Connection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).listener(this).pingIntervalMillis(i).build();
        this.http2Connection = http2ConnectionBuild;
        http2ConnectionBuild.start();
    }

    public static dc.squareup.okhttp3.internal.connection.RealConnection testConnection(dc.squareup.okhttp3.ConnectionPool connectionPool, dc.squareup.okhttp3.Route route, java.net.Socket socket, long j) {
        dc.squareup.okhttp3.internal.connection.RealConnection realConnection = new dc.squareup.okhttp3.internal.connection.RealConnection(connectionPool, route);
        realConnection.socket = socket;
        realConnection.idleAtNanos = j;
        return realConnection;
    }

    public void cancel() {
        dc.squareup.okhttp3.internal.Util.closeQuietly(this.rawSocket);
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0126  */
    /* JADX WARN: Code duplicated, block: B:59:0x012c  */
    /* JADX WARN: Code duplicated, block: B:61:0x0131  */
    /* JADX WARN: Code duplicated, block: B:81:0x0139 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x0139 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:? A[LOOP:0: B:71:0x007f->B:83:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [dc.squareup.okhttp3.internal.connection.RealConnection] */
    /* JADX WARN: Type inference failed for: r1v11, types: [dc.squareup.okhttp3.EventListener] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [dc.squareup.okhttp3.EventListener] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public void connect(int i, int i2, int i3, int i4, boolean z, dc.squareup.okhttp3.Call call, dc.squareup.okhttp3.EventListener eventListener) throws java.lang.Throwable {
        dc.squareup.okhttp3.Protocol protocol;
        ?? r1;
        dc.squareup.okhttp3.Call call2;
        java.io.IOException iOException;
        boolean zIsCleartextTrafficPermitted;
        if (this.protocol != null) {
            throw new java.lang.IllegalStateException("already connected");
        }
        java.util.List<dc.squareup.okhttp3.ConnectionSpec> listConnectionSpecs = this.route.address().connectionSpecs();
        dc.squareup.okhttp3.internal.connection.ConnectionSpecSelector connectionSpecSelector = new dc.squareup.okhttp3.internal.connection.ConnectionSpecSelector(listConnectionSpecs);
        if (this.route.address().sslSocketFactory() != null) {
            java.util.List<dc.squareup.okhttp3.Protocol> listProtocols = this.route.address().protocols();
            protocol = dc.squareup.okhttp3.Protocol.H2_PRIOR_KNOWLEDGE;
            if (listProtocols.contains(protocol)) {
                r1 = protocol;
                throw new dc.squareup.okhttp3.internal.connection.RouteException(new java.net.UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
            }
        } else {
            if (!listConnectionSpecs.contains(dc.squareup.okhttp3.ConnectionSpec.CLEARTEXT)) {
                throw new dc.squareup.okhttp3.internal.connection.RouteException(new java.net.UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            java.lang.String strHost = this.route.address().url().host();
            zIsCleartextTrafficPermitted = dc.squareup.okhttp3.internal.platform.Platform.get().isCleartextTrafficPermitted(strHost);
            if (!zIsCleartextTrafficPermitted) {
                r1 = zIsCleartextTrafficPermitted;
                throw new dc.squareup.okhttp3.internal.connection.RouteException(new java.net.UnknownServiceException("CLEARTEXT communication to " + strHost + " not permitted by network security policy"));
            }
        }
        r1 = protocol;
        r1 = zIsCleartextTrafficPermitted;
        dc.squareup.okhttp3.internal.connection.RouteException routeException = null;
        while (true) {
            try {
                try {
                    if (this.route.requiresTunnel()) {
                        try {
                            connectTunnel(i, i2, i3, call, eventListener);
                            call2 = call;
                            r1 = eventListener;
                            if (this.rawSocket != null) {
                                break;
                            } else {
                                break;
                            }
                        } catch (java.io.IOException e) {
                            e = e;
                            call2 = call;
                            r1 = eventListener;
                            iOException = e;
                            dc.squareup.okhttp3.internal.Util.closeQuietly(this.socket);
                            dc.squareup.okhttp3.internal.Util.closeQuietly(this.rawSocket);
                            this.socket = null;
                            this.rawSocket = null;
                            this.source = null;
                            this.sink = null;
                            this.handshake = null;
                            this.protocol = null;
                            this.http2Connection = null;
                            r1.connectFailed(call2, this.route.socketAddress(), this.route.proxy(), null, iOException);
                            if (routeException == null) {
                                routeException = new dc.squareup.okhttp3.internal.connection.RouteException(iOException);
                            } else {
                                routeException.addConnectException(iOException);
                            }
                            if (z) {
                                throw routeException;
                            }
                            if (connectionSpecSelector.connectionFailed(iOException)) {
                                throw routeException;
                            }
                        }
                    } else {
                        call2 = call;
                        dc.squareup.okhttp3.EventListener eventListener2 = eventListener;
                        connectSocket(i, i2, call2, eventListener2);
                        r1 = eventListener2;
                    }
                    try {
                        establishProtocol(connectionSpecSelector, i4, call2, r1);
                        r1.connectEnd(call2, this.route.socketAddress(), this.route.proxy(), this.protocol);
                        break;
                    } catch (java.io.IOException e2) {
                        e = e2;
                        iOException = e;
                        dc.squareup.okhttp3.internal.Util.closeQuietly(this.socket);
                        dc.squareup.okhttp3.internal.Util.closeQuietly(this.rawSocket);
                        this.socket = null;
                        this.rawSocket = null;
                        this.source = null;
                        this.sink = null;
                        this.handshake = null;
                        this.protocol = null;
                        this.http2Connection = null;
                        r1.connectFailed(call2, this.route.socketAddress(), this.route.proxy(), null, iOException);
                        if (routeException == null) {
                            routeException = new dc.squareup.okhttp3.internal.connection.RouteException(iOException);
                        } else {
                            routeException.addConnectException(iOException);
                        }
                        if (z) {
                            throw routeException;
                        }
                        if (connectionSpecSelector.connectionFailed(iOException)) {
                            throw routeException;
                        }
                    }
                } catch (java.io.IOException e3) {
                    e = e3;
                }
            } catch (java.io.IOException e4) {
                e = e4;
                call2 = call;
                r1 = eventListener;
            }
        }
        if (this.route.requiresTunnel() && this.rawSocket == null) {
            throw new dc.squareup.okhttp3.internal.connection.RouteException(new java.net.ProtocolException("Too many tunnel connections attempted: 21"));
        }
        if (this.http2Connection != null) {
            synchronized (this.connectionPool) {
                this.allocationLimit = this.http2Connection.maxConcurrentStreams();
            }
        }
    }

    @Override // dc.squareup.okhttp3.Connection
    public dc.squareup.okhttp3.Handshake handshake() {
        return this.handshake;
    }

    public boolean isEligible(dc.squareup.okhttp3.Address address, dc.squareup.okhttp3.Route route) {
        if (this.allocations.size() >= this.allocationLimit || this.noNewStreams || !dc.squareup.okhttp3.internal.Internal.instance.equalsNonHost(this.route.address(), address)) {
            return false;
        }
        if (address.url().host().equals(route().address().url().host())) {
            return true;
        }
        if (this.http2Connection == null || route == null) {
            return false;
        }
        java.net.Proxy.Type type = route.proxy().type();
        java.net.Proxy.Type type2 = java.net.Proxy.Type.DIRECT;
        if (type != type2 || this.route.proxy().type() != type2 || !this.route.socketAddress().equals(route.socketAddress()) || route.address().hostnameVerifier() != dc.squareup.okhttp3.internal.tls.OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
            return false;
        }
        try {
            address.certificatePinner().check(address.url().host(), handshake().peerCertificates());
            return true;
        } catch (javax.net.ssl.SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean isHealthy(boolean z) {
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        dc.squareup.okhttp3.internal.http2.Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return http2Connection.isHealthy(java.lang.System.nanoTime());
        }
        if (z) {
            try {
                int soTimeout = this.socket.getSoTimeout();
                try {
                    this.socket.setSoTimeout(1);
                    return !this.source.exhausted();
                } finally {
                    this.socket.setSoTimeout(soTimeout);
                }
            } catch (java.net.SocketTimeoutException unused) {
            } catch (java.io.IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public boolean isMultiplexed() {
        return this.http2Connection != null;
    }

    public dc.squareup.okhttp3.internal.http.HttpCodec newCodec(dc.squareup.okhttp3.OkHttpClient okHttpClient, dc.squareup.okhttp3.Interceptor.Chain chain, dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation) throws java.net.SocketException {
        if (this.http2Connection != null) {
            return new dc.squareup.okhttp3.internal.http2.Http2Codec(okHttpClient, chain, streamAllocation, this.http2Connection);
        }
        this.socket.setSoTimeout(chain.readTimeoutMillis());
        dc.squareup.okio.Timeout timeout = this.source.timeout();
        long timeoutMillis = chain.readTimeoutMillis();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        timeout.timeout(timeoutMillis, timeUnit);
        this.sink.timeout().timeout(chain.writeTimeoutMillis(), timeUnit);
        return new dc.squareup.okhttp3.internal.http1.Http1Codec(okHttpClient, streamAllocation, this.source, this.sink);
    }

    public dc.squareup.okhttp3.internal.ws.RealWebSocket.Streams newWebSocketStreams(final dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation) {
        return new dc.squareup.okhttp3.internal.ws.RealWebSocket.Streams(true, this.source, this.sink) { // from class: dc.squareup.okhttp3.internal.connection.RealConnection.1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.io.IOException {
                dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation2 = streamAllocation;
                streamAllocation2.streamFinished(true, streamAllocation2.codec(), -1L, null);
            }
        };
    }

    @Override // dc.squareup.okhttp3.internal.http2.Http2Connection.Listener
    public void onSettings(dc.squareup.okhttp3.internal.http2.Http2Connection http2Connection) {
        synchronized (this.connectionPool) {
            this.allocationLimit = http2Connection.maxConcurrentStreams();
        }
    }

    @Override // dc.squareup.okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(dc.squareup.okhttp3.internal.http2.Http2Stream http2Stream) throws java.io.IOException {
        http2Stream.close(dc.squareup.okhttp3.internal.http2.ErrorCode.REFUSED_STREAM);
    }

    @Override // dc.squareup.okhttp3.Connection
    public dc.squareup.okhttp3.Protocol protocol() {
        return this.protocol;
    }

    @Override // dc.squareup.okhttp3.Connection
    public dc.squareup.okhttp3.Route route() {
        return this.route;
    }

    @Override // dc.squareup.okhttp3.Connection
    public java.net.Socket socket() {
        return this.socket;
    }

    public boolean supportsUrl(dc.squareup.okhttp3.HttpUrl httpUrl) {
        if (httpUrl.port() != this.route.address().url().port()) {
            return false;
        }
        if (httpUrl.host().equals(this.route.address().url().host())) {
            return true;
        }
        return this.handshake != null && dc.squareup.okhttp3.internal.tls.OkHostnameVerifier.INSTANCE.verify(httpUrl.host(), (java.security.cert.X509Certificate) this.handshake.peerCertificates().get(0));
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Connection{");
        sb.append(this.route.address().url().host());
        sb.append(":");
        sb.append(this.route.address().url().port());
        sb.append(", proxy=");
        sb.append(this.route.proxy());
        sb.append(" hostAddress=");
        sb.append(this.route.socketAddress());
        sb.append(" cipherSuite=");
        dc.squareup.okhttp3.Handshake handshake = this.handshake;
        sb.append(handshake != null ? handshake.cipherSuite() : "none");
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append(com.taobao.weex.el.parse.Operators.BLOCK_END);
        return sb.toString();
    }
}
