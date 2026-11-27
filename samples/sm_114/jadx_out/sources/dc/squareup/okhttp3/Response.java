package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Response implements java.io.Closeable {
    final dc.squareup.okhttp3.ResponseBody body;
    private volatile dc.squareup.okhttp3.CacheControl cacheControl;
    final dc.squareup.okhttp3.Response cacheResponse;
    final int code;
    final dc.squareup.okhttp3.Handshake handshake;
    final dc.squareup.okhttp3.Headers headers;
    final java.lang.String message;
    final dc.squareup.okhttp3.Response networkResponse;
    final dc.squareup.okhttp3.Response priorResponse;
    final dc.squareup.okhttp3.Protocol protocol;
    final long receivedResponseAtMillis;
    final dc.squareup.okhttp3.Request request;
    final long sentRequestAtMillis;

    Response(dc.squareup.okhttp3.Response.Builder builder) {
        this.request = builder.request;
        this.protocol = builder.protocol;
        this.code = builder.code;
        this.message = builder.message;
        this.handshake = builder.handshake;
        this.headers = builder.headers.build();
        this.body = builder.body;
        this.networkResponse = builder.networkResponse;
        this.cacheResponse = builder.cacheResponse;
        this.priorResponse = builder.priorResponse;
        this.sentRequestAtMillis = builder.sentRequestAtMillis;
        this.receivedResponseAtMillis = builder.receivedResponseAtMillis;
    }

    public dc.squareup.okhttp3.ResponseBody body() {
        return this.body;
    }

    public dc.squareup.okhttp3.CacheControl cacheControl() {
        dc.squareup.okhttp3.CacheControl cacheControl = this.cacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        dc.squareup.okhttp3.CacheControl cacheControl2 = dc.squareup.okhttp3.CacheControl.parse(this.headers);
        this.cacheControl = cacheControl2;
        return cacheControl2;
    }

    public dc.squareup.okhttp3.Response cacheResponse() {
        return this.cacheResponse;
    }

    public java.util.List<dc.squareup.okhttp3.Challenge> challenges() {
        java.lang.String str;
        int i = this.code;
        if (i == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i != 407) {
                return java.util.Collections.EMPTY_LIST;
            }
            str = "Proxy-Authenticate";
        }
        return dc.squareup.okhttp3.internal.http.HttpHeaders.parseChallenges(headers(), str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        dc.squareup.okhttp3.ResponseBody responseBody = this.body;
        if (responseBody == null) {
            throw new java.lang.IllegalStateException("response is not eligible for a body and must not be closed");
        }
        responseBody.close();
    }

    public int code() {
        return this.code;
    }

    public dc.squareup.okhttp3.Handshake handshake() {
        return this.handshake;
    }

    public java.lang.String header(java.lang.String str) {
        return header(str, null);
    }

    public java.util.List<java.lang.String> headers(java.lang.String str) {
        return this.headers.values(str);
    }

    public boolean isRedirect() {
        int i = this.code;
        if (i == 307 || i == 308) {
            return true;
        }
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public boolean isSuccessful() {
        int i = this.code;
        return i >= 200 && i < 300;
    }

    public java.lang.String message() {
        return this.message;
    }

    public dc.squareup.okhttp3.Response networkResponse() {
        return this.networkResponse;
    }

    public dc.squareup.okhttp3.Response.Builder newBuilder() {
        return new dc.squareup.okhttp3.Response.Builder(this);
    }

    public dc.squareup.okhttp3.ResponseBody peekBody(long j) throws java.io.IOException {
        dc.squareup.okio.BufferedSource bufferedSourceSource = this.body.source();
        bufferedSourceSource.request(j);
        dc.squareup.okio.Buffer bufferM405clone = bufferedSourceSource.buffer().m405clone();
        if (bufferM405clone.size() > j) {
            dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
            buffer.write(bufferM405clone, j);
            bufferM405clone.clear();
            bufferM405clone = buffer;
        }
        return dc.squareup.okhttp3.ResponseBody.create(this.body.contentType(), bufferM405clone.size(), bufferM405clone);
    }

    public dc.squareup.okhttp3.Response priorResponse() {
        return this.priorResponse;
    }

    public dc.squareup.okhttp3.Protocol protocol() {
        return this.protocol;
    }

    public long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public dc.squareup.okhttp3.Request request() {
        return this.request;
    }

    public long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public java.lang.String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + com.taobao.weex.el.parse.Operators.BLOCK_END;
    }

    public java.lang.String header(java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = this.headers.get(str);
        return str3 != null ? str3 : str2;
    }

    public dc.squareup.okhttp3.Headers headers() {
        return this.headers;
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class Builder {
        dc.squareup.okhttp3.ResponseBody body;
        dc.squareup.okhttp3.Response cacheResponse;
        int code;
        dc.squareup.okhttp3.Handshake handshake;
        dc.squareup.okhttp3.Headers.Builder headers;
        java.lang.String message;
        dc.squareup.okhttp3.Response networkResponse;
        dc.squareup.okhttp3.Response priorResponse;
        dc.squareup.okhttp3.Protocol protocol;
        long receivedResponseAtMillis;
        dc.squareup.okhttp3.Request request;
        long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new dc.squareup.okhttp3.Headers.Builder();
        }

        private void checkPriorResponse(dc.squareup.okhttp3.Response response) {
            if (response.body != null) {
                throw new java.lang.IllegalArgumentException("priorResponse.body != null");
            }
        }

        private void checkSupportResponse(java.lang.String str, dc.squareup.okhttp3.Response response) {
            if (response.body != null) {
                throw new java.lang.IllegalArgumentException(str + ".body != null");
            }
            if (response.networkResponse != null) {
                throw new java.lang.IllegalArgumentException(str + ".networkResponse != null");
            }
            if (response.cacheResponse != null) {
                throw new java.lang.IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (response.priorResponse == null) {
                return;
            }
            throw new java.lang.IllegalArgumentException(str + ".priorResponse != null");
        }

        public dc.squareup.okhttp3.Response.Builder addHeader(java.lang.String str, java.lang.String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public dc.squareup.okhttp3.Response.Builder body(dc.squareup.okhttp3.ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public dc.squareup.okhttp3.Response build() {
            if (this.request == null) {
                throw new java.lang.IllegalStateException("request == null");
            }
            if (this.protocol == null) {
                throw new java.lang.IllegalStateException("protocol == null");
            }
            if (this.code >= 0) {
                if (this.message != null) {
                    return new dc.squareup.okhttp3.Response(this);
                }
                throw new java.lang.IllegalStateException("message == null");
            }
            throw new java.lang.IllegalStateException("code < 0: " + this.code);
        }

        public dc.squareup.okhttp3.Response.Builder cacheResponse(dc.squareup.okhttp3.Response response) {
            if (response != null) {
                checkSupportResponse("cacheResponse", response);
            }
            this.cacheResponse = response;
            return this;
        }

        public dc.squareup.okhttp3.Response.Builder code(int i) {
            this.code = i;
            return this;
        }

        public dc.squareup.okhttp3.Response.Builder handshake(dc.squareup.okhttp3.Handshake handshake) {
            this.handshake = handshake;
            return this;
        }

        public dc.squareup.okhttp3.Response.Builder header(java.lang.String str, java.lang.String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public dc.squareup.okhttp3.Response.Builder headers(dc.squareup.okhttp3.Headers headers) {
            this.headers = headers.newBuilder();
            return this;
        }

        public dc.squareup.okhttp3.Response.Builder message(java.lang.String str) {
            this.message = str;
            return this;
        }

        public dc.squareup.okhttp3.Response.Builder networkResponse(dc.squareup.okhttp3.Response response) {
            if (response != null) {
                checkSupportResponse("networkResponse", response);
            }
            this.networkResponse = response;
            return this;
        }

        public dc.squareup.okhttp3.Response.Builder priorResponse(dc.squareup.okhttp3.Response response) {
            if (response != null) {
                checkPriorResponse(response);
            }
            this.priorResponse = response;
            return this;
        }

        public dc.squareup.okhttp3.Response.Builder protocol(dc.squareup.okhttp3.Protocol protocol) {
            this.protocol = protocol;
            return this;
        }

        public dc.squareup.okhttp3.Response.Builder receivedResponseAtMillis(long j) {
            this.receivedResponseAtMillis = j;
            return this;
        }

        public dc.squareup.okhttp3.Response.Builder removeHeader(java.lang.String str) {
            this.headers.removeAll(str);
            return this;
        }

        public dc.squareup.okhttp3.Response.Builder request(dc.squareup.okhttp3.Request request) {
            this.request = request;
            return this;
        }

        public dc.squareup.okhttp3.Response.Builder sentRequestAtMillis(long j) {
            this.sentRequestAtMillis = j;
            return this;
        }

        Builder(dc.squareup.okhttp3.Response response) {
            this.code = -1;
            this.request = response.request;
            this.protocol = response.protocol;
            this.code = response.code;
            this.message = response.message;
            this.handshake = response.handshake;
            this.headers = response.headers.newBuilder();
            this.body = response.body;
            this.networkResponse = response.networkResponse;
            this.cacheResponse = response.cacheResponse;
            this.priorResponse = response.priorResponse;
            this.sentRequestAtMillis = response.sentRequestAtMillis;
            this.receivedResponseAtMillis = response.receivedResponseAtMillis;
        }
    }
}
