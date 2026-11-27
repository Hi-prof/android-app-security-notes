package dc.squareup.okhttp3.internal.http;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class CallServerInterceptor implements dc.squareup.okhttp3.Interceptor {
    private final boolean forWebSocket;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static final class CountingSink extends dc.squareup.okio.ForwardingSink {
        long successfulCount;

        CountingSink(dc.squareup.okio.Sink sink) {
            super(sink);
        }

        @Override // dc.squareup.okio.ForwardingSink, dc.squareup.okio.Sink
        public void write(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
            super.write(buffer, j);
            this.successfulCount += j;
        }
    }

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    @Override // dc.squareup.okhttp3.Interceptor
    public dc.squareup.okhttp3.Response intercept(dc.squareup.okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        dc.squareup.okhttp3.internal.http.RealInterceptorChain realInterceptorChain = (dc.squareup.okhttp3.internal.http.RealInterceptorChain) chain;
        dc.squareup.okhttp3.internal.http.HttpCodec httpCodecHttpStream = realInterceptorChain.httpStream();
        dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation = realInterceptorChain.streamAllocation();
        dc.squareup.okhttp3.internal.connection.RealConnection realConnection = (dc.squareup.okhttp3.internal.connection.RealConnection) realInterceptorChain.connection();
        dc.squareup.okhttp3.Request request = realInterceptorChain.request();
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        realInterceptorChain.eventListener().requestHeadersStart(realInterceptorChain.call());
        httpCodecHttpStream.writeRequestHeaders(request);
        realInterceptorChain.eventListener().requestHeadersEnd(realInterceptorChain.call(), request);
        dc.squareup.okhttp3.Response.Builder responseHeaders = null;
        if (dc.squareup.okhttp3.internal.http.HttpMethod.permitsRequestBody(request.method()) && request.body() != null) {
            if ("100-continue".equalsIgnoreCase(request.header("Expect"))) {
                httpCodecHttpStream.flushRequest();
                realInterceptorChain.eventListener().responseHeadersStart(realInterceptorChain.call());
                responseHeaders = httpCodecHttpStream.readResponseHeaders(true);
            }
            if (responseHeaders == null) {
                realInterceptorChain.eventListener().requestBodyStart(realInterceptorChain.call());
                dc.squareup.okhttp3.internal.http.CallServerInterceptor.CountingSink countingSink = new dc.squareup.okhttp3.internal.http.CallServerInterceptor.CountingSink(httpCodecHttpStream.createRequestBody(request, request.body().contentLength()));
                dc.squareup.okio.BufferedSink bufferedSinkBuffer = dc.squareup.okio.Okio.buffer(countingSink);
                request.body().writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
                realInterceptorChain.eventListener().requestBodyEnd(realInterceptorChain.call(), countingSink.successfulCount);
            } else if (!realConnection.isMultiplexed()) {
                streamAllocation.noNewStreams();
            }
        }
        httpCodecHttpStream.finishRequest();
        if (responseHeaders == null) {
            realInterceptorChain.eventListener().responseHeadersStart(realInterceptorChain.call());
            responseHeaders = httpCodecHttpStream.readResponseHeaders(false);
        }
        dc.squareup.okhttp3.Response responseBuild = responseHeaders.request(request).handshake(streamAllocation.connection().handshake()).sentRequestAtMillis(jCurrentTimeMillis).receivedResponseAtMillis(java.lang.System.currentTimeMillis()).build();
        int iCode = responseBuild.code();
        if (iCode == 100) {
            responseBuild = httpCodecHttpStream.readResponseHeaders(false).request(request).handshake(streamAllocation.connection().handshake()).sentRequestAtMillis(jCurrentTimeMillis).receivedResponseAtMillis(java.lang.System.currentTimeMillis()).build();
            iCode = responseBuild.code();
        }
        realInterceptorChain.eventListener().responseHeadersEnd(realInterceptorChain.call(), responseBuild);
        dc.squareup.okhttp3.Response responseBuild2 = (this.forWebSocket && iCode == 101) ? responseBuild.newBuilder().body(dc.squareup.okhttp3.internal.Util.EMPTY_RESPONSE).build() : responseBuild.newBuilder().body(httpCodecHttpStream.openResponseBody(responseBuild)).build();
        if (io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE.equalsIgnoreCase(responseBuild2.request().header("Connection")) || io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE.equalsIgnoreCase(responseBuild2.header("Connection"))) {
            streamAllocation.noNewStreams();
        }
        if ((iCode != 204 && iCode != 205) || responseBuild2.body().contentLength() <= 0) {
            return responseBuild2;
        }
        throw new java.net.ProtocolException("HTTP " + iCode + " had non-zero Content-Length: " + responseBuild2.body().contentLength());
    }
}
