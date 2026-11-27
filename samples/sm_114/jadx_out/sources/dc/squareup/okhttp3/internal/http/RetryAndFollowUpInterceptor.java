package dc.squareup.okhttp3.internal.http;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class RetryAndFollowUpInterceptor implements dc.squareup.okhttp3.Interceptor {
    private static final int MAX_FOLLOW_UPS = 20;
    private java.lang.Object callStackTrace;
    private volatile boolean canceled;
    private final dc.squareup.okhttp3.OkHttpClient client;
    private final boolean forWebSocket;
    private volatile dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation;

    public RetryAndFollowUpInterceptor(dc.squareup.okhttp3.OkHttpClient okHttpClient, boolean z) {
        this.client = okHttpClient;
        this.forWebSocket = z;
    }

    private dc.squareup.okhttp3.Address createAddress(dc.squareup.okhttp3.HttpUrl httpUrl) {
        javax.net.ssl.SSLSocketFactory sslSocketFactory;
        javax.net.ssl.HostnameVerifier hostnameVerifier;
        dc.squareup.okhttp3.CertificatePinner certificatePinner;
        if (httpUrl.isHttps()) {
            sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            certificatePinner = this.client.certificatePinner();
        } else {
            sslSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new dc.squareup.okhttp3.Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sslSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private dc.squareup.okhttp3.Request followUpRequest(dc.squareup.okhttp3.Response response, dc.squareup.okhttp3.Route route) throws java.io.IOException {
        java.lang.String strHeader;
        dc.squareup.okhttp3.HttpUrl httpUrlResolve;
        if (response == null) {
            throw new java.lang.IllegalStateException();
        }
        int iCode = response.code();
        java.lang.String strMethod = response.request().method();
        if (iCode == 307 || iCode == 308) {
            if (!strMethod.equals("GET") && !strMethod.equals("HEAD")) {
                return null;
            }
        } else {
            if (iCode == 401) {
                return this.client.authenticator().authenticate(route, response);
            }
            if (iCode == 503) {
                if ((response.priorResponse() == null || response.priorResponse().code() != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                }
                return null;
            }
            if (iCode == 407) {
                if (route.proxy().type() == java.net.Proxy.Type.HTTP) {
                    return this.client.proxyAuthenticator().authenticate(route, response);
                }
                throw new java.net.ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (iCode == 408) {
                if (!this.client.retryOnConnectionFailure() || (response.request().body() instanceof dc.squareup.okhttp3.internal.http.UnrepeatableRequestBody)) {
                    return null;
                }
                if ((response.priorResponse() == null || response.priorResponse().code() != 408) && retryAfter(response, 0) <= 0) {
                    return response.request();
                }
                return null;
            }
            switch (iCode) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.client.followRedirects() || (strHeader = response.header("Location")) == null || (httpUrlResolve = response.request().url().resolve(strHeader)) == null) {
            return null;
        }
        if (!httpUrlResolve.scheme().equals(response.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        dc.squareup.okhttp3.Request.Builder builderNewBuilder = response.request().newBuilder();
        if (dc.squareup.okhttp3.internal.http.HttpMethod.permitsRequestBody(strMethod)) {
            boolean zRedirectsWithBody = dc.squareup.okhttp3.internal.http.HttpMethod.redirectsWithBody(strMethod);
            if (dc.squareup.okhttp3.internal.http.HttpMethod.redirectsToGet(strMethod)) {
                builderNewBuilder.method("GET", null);
            } else {
                builderNewBuilder.method(strMethod, zRedirectsWithBody ? response.request().body() : null);
            }
            if (!zRedirectsWithBody) {
                builderNewBuilder.removeHeader("Transfer-Encoding");
                builderNewBuilder.removeHeader("Content-Length");
                builderNewBuilder.removeHeader(io.dcloud.common.util.net.NetWork.CONTENT_TYPE);
            }
        }
        if (!sameConnection(response, httpUrlResolve)) {
            builderNewBuilder.removeHeader("Authorization");
        }
        return builderNewBuilder.url(httpUrlResolve).build();
    }

    private boolean isRecoverable(java.io.IOException iOException, boolean z) {
        if (iOException instanceof java.net.ProtocolException) {
            return false;
        }
        if (iOException instanceof java.io.InterruptedIOException) {
            return (iOException instanceof java.net.SocketTimeoutException) && !z;
        }
        return (((iOException instanceof javax.net.ssl.SSLHandshakeException) && (iOException.getCause() instanceof java.security.cert.CertificateException)) || (iOException instanceof javax.net.ssl.SSLPeerUnverifiedException)) ? false : true;
    }

    private boolean recover(java.io.IOException iOException, dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation, boolean z, dc.squareup.okhttp3.Request request) {
        streamAllocation.streamFailed(iOException);
        if (this.client.retryOnConnectionFailure()) {
            return !(z && requestIsUnrepeatable(iOException, request)) && isRecoverable(iOException, z) && streamAllocation.hasMoreRoutes();
        }
        return false;
    }

    private boolean requestIsUnrepeatable(java.io.IOException iOException, dc.squareup.okhttp3.Request request) {
        return (request.body() instanceof dc.squareup.okhttp3.internal.http.UnrepeatableRequestBody) || (iOException instanceof java.io.FileNotFoundException);
    }

    private int retryAfter(dc.squareup.okhttp3.Response response, int i) {
        java.lang.String strHeader = response.header("Retry-After");
        if (strHeader == null) {
            return i;
        }
        if (strHeader.matches("\\d+")) {
            return java.lang.Integer.valueOf(strHeader).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean sameConnection(dc.squareup.okhttp3.Response response, dc.squareup.okhttp3.HttpUrl httpUrl) {
        dc.squareup.okhttp3.HttpUrl httpUrlUrl = response.request().url();
        return httpUrlUrl.host().equals(httpUrl.host()) && httpUrlUrl.port() == httpUrl.port() && httpUrlUrl.scheme().equals(httpUrl.scheme());
    }

    public void cancel() {
        this.canceled = true;
        dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation = this.streamAllocation;
        if (streamAllocation != null) {
            streamAllocation.cancel();
        }
    }

    @Override // dc.squareup.okhttp3.Interceptor
    public dc.squareup.okhttp3.Response intercept(dc.squareup.okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        dc.squareup.okhttp3.Request request = chain.request();
        dc.squareup.okhttp3.internal.http.RealInterceptorChain realInterceptorChain = (dc.squareup.okhttp3.internal.http.RealInterceptorChain) chain;
        dc.squareup.okhttp3.Call call = realInterceptorChain.call();
        dc.squareup.okhttp3.EventListener eventListener = realInterceptorChain.eventListener();
        dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation = new dc.squareup.okhttp3.internal.connection.StreamAllocation(this.client.connectionPool(), createAddress(request.url()), call, eventListener, this.callStackTrace);
        this.streamAllocation = streamAllocation;
        dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation2 = streamAllocation;
        dc.squareup.okhttp3.Response responseProceed = null;
        int i = 0;
        dc.squareup.okhttp3.Request request2 = request;
        while (!this.canceled) {
            try {
                try {
                    responseProceed = realInterceptorChain.proceed(request2, streamAllocation2, null, null);
                    if (responseProceed != null) {
                        responseProceed = responseProceed.newBuilder().priorResponse(responseProceed.newBuilder().body(null).build()).build();
                    }
                    try {
                        dc.squareup.okhttp3.Request requestFollowUpRequest = followUpRequest(responseProceed, streamAllocation2.route());
                        if (requestFollowUpRequest == null) {
                            streamAllocation2.release();
                            return responseProceed;
                        }
                        dc.squareup.okhttp3.internal.Util.closeQuietly(responseProceed.body());
                        int i2 = i + 1;
                        if (i2 > 20) {
                            streamAllocation2.release();
                            throw new java.net.ProtocolException("Too many follow-up requests: " + i2);
                        }
                        if (requestFollowUpRequest.body() instanceof dc.squareup.okhttp3.internal.http.UnrepeatableRequestBody) {
                            streamAllocation2.release();
                            throw new java.net.HttpRetryException("Cannot retry streamed HTTP body", responseProceed.code());
                        }
                        if (!sameConnection(responseProceed, requestFollowUpRequest.url())) {
                            streamAllocation2.release();
                            dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation3 = new dc.squareup.okhttp3.internal.connection.StreamAllocation(this.client.connectionPool(), createAddress(requestFollowUpRequest.url()), call, eventListener, this.callStackTrace);
                            this.streamAllocation = streamAllocation3;
                            streamAllocation2 = streamAllocation3;
                        } else if (streamAllocation2.codec() != null) {
                            throw new java.lang.IllegalStateException("Closing the body of " + responseProceed + " didn't close its backing stream. Bad interceptor?");
                        }
                        request2 = requestFollowUpRequest;
                        i = i2;
                    } catch (java.io.IOException e) {
                        streamAllocation2.release();
                        throw e;
                    }
                } catch (java.lang.Throwable th) {
                    streamAllocation2.streamFailed(null);
                    streamAllocation2.release();
                    throw th;
                }
            } catch (dc.squareup.okhttp3.internal.connection.RouteException e2) {
                if (!recover(e2.getLastConnectException(), streamAllocation2, false, request2)) {
                    throw e2.getFirstConnectException();
                }
            } catch (java.io.IOException e3) {
                if (!recover(e3, streamAllocation2, !(e3 instanceof dc.squareup.okhttp3.internal.http2.ConnectionShutdownException), request2)) {
                    throw e3;
                }
            }
        }
        streamAllocation2.release();
        throw new java.io.IOException("Canceled");
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public void setCallStackTrace(java.lang.Object obj) {
        this.callStackTrace = obj;
    }

    public dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }
}
