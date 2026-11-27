package dc.squareup.okhttp3.internal.http;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class RealInterceptorChain implements dc.squareup.okhttp3.Interceptor.Chain {
    private final dc.squareup.okhttp3.Call call;
    private int calls;
    private final int connectTimeout;
    private final dc.squareup.okhttp3.internal.connection.RealConnection connection;
    private final dc.squareup.okhttp3.EventListener eventListener;
    private final dc.squareup.okhttp3.internal.http.HttpCodec httpCodec;
    private final int index;
    private final java.util.List<dc.squareup.okhttp3.Interceptor> interceptors;
    private final int readTimeout;
    private final dc.squareup.okhttp3.Request request;
    private final dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation;
    private final int writeTimeout;

    public RealInterceptorChain(java.util.List<dc.squareup.okhttp3.Interceptor> list, dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation, dc.squareup.okhttp3.internal.http.HttpCodec httpCodec, dc.squareup.okhttp3.internal.connection.RealConnection realConnection, int i, dc.squareup.okhttp3.Request request, dc.squareup.okhttp3.Call call, dc.squareup.okhttp3.EventListener eventListener, int i2, int i3, int i4) {
        this.interceptors = list;
        this.connection = realConnection;
        this.streamAllocation = streamAllocation;
        this.httpCodec = httpCodec;
        this.index = i;
        this.request = request;
        this.call = call;
        this.eventListener = eventListener;
        this.connectTimeout = i2;
        this.readTimeout = i3;
        this.writeTimeout = i4;
    }

    @Override // dc.squareup.okhttp3.Interceptor.Chain
    public dc.squareup.okhttp3.Call call() {
        return this.call;
    }

    @Override // dc.squareup.okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    @Override // dc.squareup.okhttp3.Interceptor.Chain
    public dc.squareup.okhttp3.Connection connection() {
        return this.connection;
    }

    public dc.squareup.okhttp3.EventListener eventListener() {
        return this.eventListener;
    }

    public dc.squareup.okhttp3.internal.http.HttpCodec httpStream() {
        return this.httpCodec;
    }

    @Override // dc.squareup.okhttp3.Interceptor.Chain
    public dc.squareup.okhttp3.Response proceed(dc.squareup.okhttp3.Request request) throws java.io.IOException {
        return proceed(request, this.streamAllocation, this.httpCodec, this.connection);
    }

    @Override // dc.squareup.okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    @Override // dc.squareup.okhttp3.Interceptor.Chain
    public dc.squareup.okhttp3.Request request() {
        return this.request;
    }

    public dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }

    @Override // dc.squareup.okhttp3.Interceptor.Chain
    public dc.squareup.okhttp3.Interceptor.Chain withConnectTimeout(int i, java.util.concurrent.TimeUnit timeUnit) {
        return new dc.squareup.okhttp3.internal.http.RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, dc.squareup.okhttp3.internal.Util.checkDuration("timeout", i, timeUnit), this.readTimeout, this.writeTimeout);
    }

    @Override // dc.squareup.okhttp3.Interceptor.Chain
    public dc.squareup.okhttp3.Interceptor.Chain withReadTimeout(int i, java.util.concurrent.TimeUnit timeUnit) {
        return new dc.squareup.okhttp3.internal.http.RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, dc.squareup.okhttp3.internal.Util.checkDuration("timeout", i, timeUnit), this.writeTimeout);
    }

    @Override // dc.squareup.okhttp3.Interceptor.Chain
    public dc.squareup.okhttp3.Interceptor.Chain withWriteTimeout(int i, java.util.concurrent.TimeUnit timeUnit) {
        return new dc.squareup.okhttp3.internal.http.RealInterceptorChain(this.interceptors, this.streamAllocation, this.httpCodec, this.connection, this.index, this.request, this.call, this.eventListener, this.connectTimeout, this.readTimeout, dc.squareup.okhttp3.internal.Util.checkDuration("timeout", i, timeUnit));
    }

    @Override // dc.squareup.okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    public dc.squareup.okhttp3.Response proceed(dc.squareup.okhttp3.Request request, dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation, dc.squareup.okhttp3.internal.http.HttpCodec httpCodec, dc.squareup.okhttp3.internal.connection.RealConnection realConnection) throws java.io.IOException {
        if (this.index >= this.interceptors.size()) {
            throw new java.lang.AssertionError();
        }
        this.calls++;
        if (this.httpCodec != null && !this.connection.supportsUrl(request.url())) {
            throw new java.lang.IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port");
        }
        if (this.httpCodec != null && this.calls > 1) {
            throw new java.lang.IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once");
        }
        dc.squareup.okhttp3.internal.http.RealInterceptorChain realInterceptorChain = new dc.squareup.okhttp3.internal.http.RealInterceptorChain(this.interceptors, streamAllocation, httpCodec, realConnection, this.index + 1, request, this.call, this.eventListener, this.connectTimeout, this.readTimeout, this.writeTimeout);
        dc.squareup.okhttp3.Interceptor interceptor = this.interceptors.get(this.index);
        dc.squareup.okhttp3.Response responseIntercept = interceptor.intercept(realInterceptorChain);
        if (httpCodec != null && this.index + 1 < this.interceptors.size() && realInterceptorChain.calls != 1) {
            throw new java.lang.IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
        }
        if (responseIntercept == null) {
            throw new java.lang.NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (responseIntercept.body() != null) {
            return responseIntercept;
        }
        throw new java.lang.IllegalStateException("interceptor " + interceptor + " returned a response with no body");
    }
}
