package dc.squareup.okhttp3.internal.http2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Http2Codec implements dc.squareup.okhttp3.internal.http.HttpCodec {
    private final dc.squareup.okhttp3.Interceptor.Chain chain;
    private final dc.squareup.okhttp3.internal.http2.Http2Connection connection;
    private final dc.squareup.okhttp3.Protocol protocol;
    private dc.squareup.okhttp3.internal.http2.Http2Stream stream;
    final dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation;
    private static final java.lang.String CONNECTION = "connection";
    private static final java.lang.String HOST = "host";
    private static final java.lang.String KEEP_ALIVE = "keep-alive";
    private static final java.lang.String PROXY_CONNECTION = "proxy-connection";
    private static final java.lang.String TE = "te";
    private static final java.lang.String TRANSFER_ENCODING = "transfer-encoding";
    private static final java.lang.String ENCODING = "encoding";
    private static final java.lang.String UPGRADE = "upgrade";
    private static final java.util.List<java.lang.String> HTTP_2_SKIPPED_REQUEST_HEADERS = dc.squareup.okhttp3.internal.Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, ":method", ":path", ":scheme", ":authority");
    private static final java.util.List<java.lang.String> HTTP_2_SKIPPED_RESPONSE_HEADERS = dc.squareup.okhttp3.internal.Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE);

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class StreamFinishingSource extends dc.squareup.okio.ForwardingSource {
        long bytesRead;
        boolean completed;

        StreamFinishingSource(dc.squareup.okio.Source source) {
            super(source);
            this.completed = false;
            this.bytesRead = 0L;
        }

        private void endOfInput(java.io.IOException iOException) {
            if (this.completed) {
                return;
            }
            this.completed = true;
            dc.squareup.okhttp3.internal.http2.Http2Codec http2Codec = dc.squareup.okhttp3.internal.http2.Http2Codec.this;
            http2Codec.streamAllocation.streamFinished(false, http2Codec, this.bytesRead, iOException);
        }

        @Override // dc.squareup.okio.ForwardingSource, dc.squareup.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            super.close();
            endOfInput(null);
        }

        @Override // dc.squareup.okio.ForwardingSource, dc.squareup.okio.Source
        public long read(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
            try {
                long j2 = delegate().read(buffer, j);
                if (j2 > 0) {
                    this.bytesRead += j2;
                }
                return j2;
            } catch (java.io.IOException e) {
                endOfInput(e);
                throw e;
            }
        }
    }

    public Http2Codec(dc.squareup.okhttp3.OkHttpClient okHttpClient, dc.squareup.okhttp3.Interceptor.Chain chain, dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation, dc.squareup.okhttp3.internal.http2.Http2Connection http2Connection) {
        this.chain = chain;
        this.streamAllocation = streamAllocation;
        this.connection = http2Connection;
        java.util.List<dc.squareup.okhttp3.Protocol> listProtocols = okHttpClient.protocols();
        dc.squareup.okhttp3.Protocol protocol = dc.squareup.okhttp3.Protocol.H2_PRIOR_KNOWLEDGE;
        this.protocol = listProtocols.contains(protocol) ? protocol : dc.squareup.okhttp3.Protocol.HTTP_2;
    }

    public static java.util.List<dc.squareup.okhttp3.internal.http2.Header> http2HeadersList(dc.squareup.okhttp3.Request request) {
        dc.squareup.okhttp3.Headers headers = request.headers();
        java.util.ArrayList arrayList = new java.util.ArrayList(headers.size() + 4);
        arrayList.add(new dc.squareup.okhttp3.internal.http2.Header(dc.squareup.okhttp3.internal.http2.Header.TARGET_METHOD, request.method()));
        arrayList.add(new dc.squareup.okhttp3.internal.http2.Header(dc.squareup.okhttp3.internal.http2.Header.TARGET_PATH, dc.squareup.okhttp3.internal.http.RequestLine.requestPath(request.url())));
        java.lang.String strHeader = request.header("Host");
        if (strHeader != null) {
            arrayList.add(new dc.squareup.okhttp3.internal.http2.Header(dc.squareup.okhttp3.internal.http2.Header.TARGET_AUTHORITY, strHeader));
        }
        arrayList.add(new dc.squareup.okhttp3.internal.http2.Header(dc.squareup.okhttp3.internal.http2.Header.TARGET_SCHEME, request.url().scheme()));
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            dc.squareup.okio.ByteString byteStringEncodeUtf8 = dc.squareup.okio.ByteString.encodeUtf8(headers.name(i).toLowerCase(java.util.Locale.US));
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(byteStringEncodeUtf8.utf8())) {
                arrayList.add(new dc.squareup.okhttp3.internal.http2.Header(byteStringEncodeUtf8, headers.value(i)));
            }
        }
        return arrayList;
    }

    public static dc.squareup.okhttp3.Response.Builder readHttp2HeadersList(dc.squareup.okhttp3.Headers headers, dc.squareup.okhttp3.Protocol protocol) throws java.io.IOException {
        dc.squareup.okhttp3.Headers.Builder builder = new dc.squareup.okhttp3.Headers.Builder();
        int size = headers.size();
        dc.squareup.okhttp3.internal.http.StatusLine statusLine = null;
        for (int i = 0; i < size; i++) {
            java.lang.String strName = headers.name(i);
            java.lang.String strValue = headers.value(i);
            if (strName.equals(":status")) {
                statusLine = dc.squareup.okhttp3.internal.http.StatusLine.parse("HTTP/1.1 " + strValue);
            } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(strName)) {
                dc.squareup.okhttp3.internal.Internal.instance.addLenient(builder, strName, strValue);
            }
        }
        if (statusLine != null) {
            return new dc.squareup.okhttp3.Response.Builder().protocol(protocol).code(statusLine.code).message(statusLine.message).headers(builder.build());
        }
        throw new java.net.ProtocolException("Expected ':status' header not present");
    }

    @Override // dc.squareup.okhttp3.internal.http.HttpCodec
    public void cancel() {
        dc.squareup.okhttp3.internal.http2.Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(dc.squareup.okhttp3.internal.http2.ErrorCode.CANCEL);
        }
    }

    @Override // dc.squareup.okhttp3.internal.http.HttpCodec
    public dc.squareup.okio.Sink createRequestBody(dc.squareup.okhttp3.Request request, long j) {
        return this.stream.getSink();
    }

    @Override // dc.squareup.okhttp3.internal.http.HttpCodec
    public void finishRequest() throws java.io.IOException {
        this.stream.getSink().close();
    }

    @Override // dc.squareup.okhttp3.internal.http.HttpCodec
    public void flushRequest() throws java.io.IOException {
        this.connection.flush();
    }

    @Override // dc.squareup.okhttp3.internal.http.HttpCodec
    public dc.squareup.okhttp3.ResponseBody openResponseBody(dc.squareup.okhttp3.Response response) throws java.io.IOException {
        dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation = this.streamAllocation;
        streamAllocation.eventListener.responseBodyStart(streamAllocation.call);
        return new dc.squareup.okhttp3.internal.http.RealResponseBody(response.header(io.dcloud.common.util.net.NetWork.CONTENT_TYPE), dc.squareup.okhttp3.internal.http.HttpHeaders.contentLength(response), dc.squareup.okio.Okio.buffer(new dc.squareup.okhttp3.internal.http2.Http2Codec.StreamFinishingSource(this.stream.getSource())));
    }

    @Override // dc.squareup.okhttp3.internal.http.HttpCodec
    public dc.squareup.okhttp3.Response.Builder readResponseHeaders(boolean z) throws java.io.IOException {
        dc.squareup.okhttp3.Response.Builder http2HeadersList = readHttp2HeadersList(this.stream.takeHeaders(), this.protocol);
        if (z && dc.squareup.okhttp3.internal.Internal.instance.code(http2HeadersList) == 100) {
            return null;
        }
        return http2HeadersList;
    }

    @Override // dc.squareup.okhttp3.internal.http.HttpCodec
    public void writeRequestHeaders(dc.squareup.okhttp3.Request request) throws java.io.IOException {
        if (this.stream != null) {
            return;
        }
        dc.squareup.okhttp3.internal.http2.Http2Stream http2StreamNewStream = this.connection.newStream(http2HeadersList(request), request.body() != null);
        this.stream = http2StreamNewStream;
        dc.squareup.okio.Timeout timeout = http2StreamNewStream.readTimeout();
        long timeoutMillis = this.chain.readTimeoutMillis();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        timeout.timeout(timeoutMillis, timeUnit);
        this.stream.writeTimeout().timeout(this.chain.writeTimeoutMillis(), timeUnit);
    }
}
