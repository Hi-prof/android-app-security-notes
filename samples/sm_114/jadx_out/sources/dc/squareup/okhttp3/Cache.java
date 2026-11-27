package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Cache implements java.io.Closeable, java.io.Flushable {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    final dc.squareup.okhttp3.internal.cache.DiskLruCache cache;
    private int hitCount;
    final dc.squareup.okhttp3.internal.cache.InternalCache internalCache;
    private int networkCount;
    private int requestCount;
    int writeAbortCount;
    int writeSuccessCount;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private final class CacheRequestImpl implements dc.squareup.okhttp3.internal.cache.CacheRequest {
        private dc.squareup.okio.Sink body;
        private dc.squareup.okio.Sink cacheOut;
        boolean done;
        private final dc.squareup.okhttp3.internal.cache.DiskLruCache.Editor editor;

        CacheRequestImpl(final dc.squareup.okhttp3.internal.cache.DiskLruCache.Editor editor) {
            this.editor = editor;
            dc.squareup.okio.Sink sinkNewSink = editor.newSink(1);
            this.cacheOut = sinkNewSink;
            this.body = new dc.squareup.okio.ForwardingSink(sinkNewSink) { // from class: dc.squareup.okhttp3.Cache.CacheRequestImpl.1
                @Override // dc.squareup.okio.ForwardingSink, dc.squareup.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws java.io.IOException {
                    synchronized (dc.squareup.okhttp3.Cache.this) {
                        dc.squareup.okhttp3.Cache.CacheRequestImpl cacheRequestImpl = dc.squareup.okhttp3.Cache.CacheRequestImpl.this;
                        if (cacheRequestImpl.done) {
                            return;
                        }
                        cacheRequestImpl.done = true;
                        dc.squareup.okhttp3.Cache.this.writeSuccessCount++;
                        super.close();
                        editor.commit();
                    }
                }
            };
        }

        @Override // dc.squareup.okhttp3.internal.cache.CacheRequest
        public void abort() {
            synchronized (dc.squareup.okhttp3.Cache.this) {
                if (this.done) {
                    return;
                }
                this.done = true;
                dc.squareup.okhttp3.Cache.this.writeAbortCount++;
                dc.squareup.okhttp3.internal.Util.closeQuietly(this.cacheOut);
                try {
                    this.editor.abort();
                } catch (java.io.IOException unused) {
                }
            }
        }

        @Override // dc.squareup.okhttp3.internal.cache.CacheRequest
        public dc.squareup.okio.Sink body() {
            return this.body;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class CacheResponseBody extends dc.squareup.okhttp3.ResponseBody {
        private final dc.squareup.okio.BufferedSource bodySource;
        private final java.lang.String contentLength;
        private final java.lang.String contentType;
        final dc.squareup.okhttp3.internal.cache.DiskLruCache.Snapshot snapshot;

        CacheResponseBody(final dc.squareup.okhttp3.internal.cache.DiskLruCache.Snapshot snapshot, java.lang.String str, java.lang.String str2) {
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = dc.squareup.okio.Okio.buffer(new dc.squareup.okio.ForwardingSource(snapshot.getSource(1)) { // from class: dc.squareup.okhttp3.Cache.CacheResponseBody.1
                @Override // dc.squareup.okio.ForwardingSource, dc.squareup.okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws java.io.IOException {
                    snapshot.close();
                    super.close();
                }
            });
        }

        @Override // dc.squareup.okhttp3.ResponseBody
        public long contentLength() {
            try {
                java.lang.String str = this.contentLength;
                if (str != null) {
                    return java.lang.Long.parseLong(str);
                }
                return -1L;
            } catch (java.lang.NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // dc.squareup.okhttp3.ResponseBody
        public dc.squareup.okhttp3.MediaType contentType() {
            java.lang.String str = this.contentType;
            if (str != null) {
                return dc.squareup.okhttp3.MediaType.parse(str);
            }
            return null;
        }

        @Override // dc.squareup.okhttp3.ResponseBody
        public dc.squareup.okio.BufferedSource source() {
            return this.bodySource;
        }
    }

    public Cache(java.io.File file, long j) {
        this(file, j, dc.squareup.okhttp3.internal.io.FileSystem.SYSTEM);
    }

    private void abortQuietly(dc.squareup.okhttp3.internal.cache.DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static java.lang.String key(dc.squareup.okhttp3.HttpUrl httpUrl) {
        return dc.squareup.okio.ByteString.encodeUtf8(httpUrl.toString()).md5().hex();
    }

    static int readInt(dc.squareup.okio.BufferedSource bufferedSource) throws java.io.IOException {
        try {
            long decimalLong = bufferedSource.readDecimalLong();
            java.lang.String utf8LineStrict = bufferedSource.readUtf8LineStrict();
            if (decimalLong >= 0 && decimalLong <= 2147483647L && utf8LineStrict.isEmpty()) {
                return (int) decimalLong;
            }
            throw new java.io.IOException("expected an int but was \"" + decimalLong + utf8LineStrict + io.dcloud.common.util.JSUtil.QUOTE);
        } catch (java.lang.NumberFormatException e) {
            throw new java.io.IOException(e.getMessage());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.cache.close();
    }

    public void delete() throws java.io.IOException {
        this.cache.delete();
    }

    public java.io.File directory() {
        return this.cache.getDirectory();
    }

    public void evictAll() throws java.io.IOException {
        this.cache.evictAll();
    }

    @Override // java.io.Flushable
    public void flush() throws java.io.IOException {
        this.cache.flush();
    }

    dc.squareup.okhttp3.Response get(dc.squareup.okhttp3.Request request) {
        try {
            dc.squareup.okhttp3.internal.cache.DiskLruCache.Snapshot snapshot = this.cache.get(key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                dc.squareup.okhttp3.Cache.Entry entry = new dc.squareup.okhttp3.Cache.Entry(snapshot.getSource(0));
                dc.squareup.okhttp3.Response response = entry.response(snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                dc.squareup.okhttp3.internal.Util.closeQuietly(response.body());
                return null;
            } catch (java.io.IOException unused) {
                dc.squareup.okhttp3.internal.Util.closeQuietly(snapshot);
                return null;
            }
        } catch (java.io.IOException unused2) {
        }
    }

    public synchronized int hitCount() {
        return this.hitCount;
    }

    public void initialize() throws java.io.IOException {
        this.cache.initialize();
    }

    public boolean isClosed() {
        return this.cache.isClosed();
    }

    public long maxSize() {
        return this.cache.getMaxSize();
    }

    public synchronized int networkCount() {
        return this.networkCount;
    }

    dc.squareup.okhttp3.internal.cache.CacheRequest put(dc.squareup.okhttp3.Response response) {
        dc.squareup.okhttp3.internal.cache.DiskLruCache.Editor editorEdit;
        java.lang.String strMethod = response.request().method();
        if (dc.squareup.okhttp3.internal.http.HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove(response.request());
            } catch (java.io.IOException unused) {
            }
            return null;
        }
        if (!strMethod.equals("GET") || dc.squareup.okhttp3.internal.http.HttpHeaders.hasVaryAll(response)) {
            return null;
        }
        dc.squareup.okhttp3.Cache.Entry entry = new dc.squareup.okhttp3.Cache.Entry(response);
        try {
            editorEdit = this.cache.edit(key(response.request().url()));
            if (editorEdit == null) {
                return null;
            }
            try {
                entry.writeTo(editorEdit);
                return new dc.squareup.okhttp3.Cache.CacheRequestImpl(editorEdit);
            } catch (java.io.IOException unused2) {
                abortQuietly(editorEdit);
                return null;
            }
        } catch (java.io.IOException unused3) {
            editorEdit = null;
        }
    }

    void remove(dc.squareup.okhttp3.Request request) throws java.io.IOException {
        this.cache.remove(key(request.url()));
    }

    public synchronized int requestCount() {
        return this.requestCount;
    }

    public long size() throws java.io.IOException {
        return this.cache.size();
    }

    synchronized void trackConditionalCacheHit() {
        this.hitCount++;
    }

    synchronized void trackResponse(dc.squareup.okhttp3.internal.cache.CacheStrategy cacheStrategy) {
        this.requestCount++;
        if (cacheStrategy.networkRequest != null) {
            this.networkCount++;
        } else if (cacheStrategy.cacheResponse != null) {
            this.hitCount++;
        }
    }

    void update(dc.squareup.okhttp3.Response response, dc.squareup.okhttp3.Response response2) {
        dc.squareup.okhttp3.internal.cache.DiskLruCache.Editor editorEdit;
        dc.squareup.okhttp3.Cache.Entry entry = new dc.squareup.okhttp3.Cache.Entry(response2);
        try {
            editorEdit = ((dc.squareup.okhttp3.Cache.CacheResponseBody) response.body()).snapshot.edit();
            if (editorEdit != null) {
                try {
                    entry.writeTo(editorEdit);
                    editorEdit.commit();
                } catch (java.io.IOException unused) {
                    abortQuietly(editorEdit);
                }
            }
        } catch (java.io.IOException unused2) {
            editorEdit = null;
        }
    }

    public java.util.Iterator<java.lang.String> urls() throws java.io.IOException {
        return new java.util.Iterator<java.lang.String>() { // from class: dc.squareup.okhttp3.Cache.2
            boolean canRemove;
            final java.util.Iterator<dc.squareup.okhttp3.internal.cache.DiskLruCache.Snapshot> delegate;
            java.lang.String nextUrl;

            {
                this.delegate = dc.squareup.okhttp3.Cache.this.cache.snapshots();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.nextUrl != null) {
                    return true;
                }
                this.canRemove = false;
                while (this.delegate.hasNext()) {
                    dc.squareup.okhttp3.internal.cache.DiskLruCache.Snapshot next = this.delegate.next();
                    try {
                        this.nextUrl = dc.squareup.okio.Okio.buffer(next.getSource(0)).readUtf8LineStrict();
                        next.close();
                        return true;
                    } catch (java.io.IOException unused) {
                        next.close();
                    } catch (java.lang.Throwable th) {
                        next.close();
                        throw th;
                    }
                }
                return false;
            }

            @Override // java.util.Iterator
            public void remove() {
                if (!this.canRemove) {
                    throw new java.lang.IllegalStateException("remove() before next()");
                }
                this.delegate.remove();
            }

            @Override // java.util.Iterator
            public java.lang.String next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                java.lang.String str = this.nextUrl;
                this.nextUrl = null;
                this.canRemove = true;
                return str;
            }
        };
    }

    public synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    Cache(java.io.File file, long j, dc.squareup.okhttp3.internal.io.FileSystem fileSystem) {
        this.internalCache = new dc.squareup.okhttp3.internal.cache.InternalCache() { // from class: dc.squareup.okhttp3.Cache.1
            @Override // dc.squareup.okhttp3.internal.cache.InternalCache
            public dc.squareup.okhttp3.Response get(dc.squareup.okhttp3.Request request) throws java.io.IOException {
                return dc.squareup.okhttp3.Cache.this.get(request);
            }

            @Override // dc.squareup.okhttp3.internal.cache.InternalCache
            public dc.squareup.okhttp3.internal.cache.CacheRequest put(dc.squareup.okhttp3.Response response) throws java.io.IOException {
                return dc.squareup.okhttp3.Cache.this.put(response);
            }

            @Override // dc.squareup.okhttp3.internal.cache.InternalCache
            public void remove(dc.squareup.okhttp3.Request request) throws java.io.IOException {
                dc.squareup.okhttp3.Cache.this.remove(request);
            }

            @Override // dc.squareup.okhttp3.internal.cache.InternalCache
            public void trackConditionalCacheHit() {
                dc.squareup.okhttp3.Cache.this.trackConditionalCacheHit();
            }

            @Override // dc.squareup.okhttp3.internal.cache.InternalCache
            public void trackResponse(dc.squareup.okhttp3.internal.cache.CacheStrategy cacheStrategy) {
                dc.squareup.okhttp3.Cache.this.trackResponse(cacheStrategy);
            }

            @Override // dc.squareup.okhttp3.internal.cache.InternalCache
            public void update(dc.squareup.okhttp3.Response response, dc.squareup.okhttp3.Response response2) {
                dc.squareup.okhttp3.Cache.this.update(response, response2);
            }
        };
        this.cache = dc.squareup.okhttp3.internal.cache.DiskLruCache.create(fileSystem, file, VERSION, 2, j);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static final class Entry {
        private final int code;
        private final dc.squareup.okhttp3.Handshake handshake;
        private final java.lang.String message;
        private final dc.squareup.okhttp3.Protocol protocol;
        private final long receivedResponseMillis;
        private final java.lang.String requestMethod;
        private final dc.squareup.okhttp3.Headers responseHeaders;
        private final long sentRequestMillis;
        private final java.lang.String url;
        private final dc.squareup.okhttp3.Headers varyHeaders;
        private static final java.lang.String SENT_MILLIS = dc.squareup.okhttp3.internal.platform.Platform.get().getPrefix() + "-Sent-Millis";
        private static final java.lang.String RECEIVED_MILLIS = dc.squareup.okhttp3.internal.platform.Platform.get().getPrefix() + "-Received-Millis";

        Entry(dc.squareup.okio.Source source) throws java.io.IOException {
            try {
                dc.squareup.okio.BufferedSource bufferedSourceBuffer = dc.squareup.okio.Okio.buffer(source);
                this.url = bufferedSourceBuffer.readUtf8LineStrict();
                this.requestMethod = bufferedSourceBuffer.readUtf8LineStrict();
                dc.squareup.okhttp3.Headers.Builder builder = new dc.squareup.okhttp3.Headers.Builder();
                int i = dc.squareup.okhttp3.Cache.readInt(bufferedSourceBuffer);
                for (int i2 = 0; i2 < i; i2++) {
                    builder.addLenient(bufferedSourceBuffer.readUtf8LineStrict());
                }
                this.varyHeaders = builder.build();
                dc.squareup.okhttp3.internal.http.StatusLine statusLine = dc.squareup.okhttp3.internal.http.StatusLine.parse(bufferedSourceBuffer.readUtf8LineStrict());
                this.protocol = statusLine.protocol;
                this.code = statusLine.code;
                this.message = statusLine.message;
                dc.squareup.okhttp3.Headers.Builder builder2 = new dc.squareup.okhttp3.Headers.Builder();
                int i3 = dc.squareup.okhttp3.Cache.readInt(bufferedSourceBuffer);
                for (int i4 = 0; i4 < i3; i4++) {
                    builder2.addLenient(bufferedSourceBuffer.readUtf8LineStrict());
                }
                java.lang.String str = SENT_MILLIS;
                java.lang.String str2 = builder2.get(str);
                java.lang.String str3 = RECEIVED_MILLIS;
                java.lang.String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                this.sentRequestMillis = str2 != null ? java.lang.Long.parseLong(str2) : 0L;
                this.receivedResponseMillis = str4 != null ? java.lang.Long.parseLong(str4) : 0L;
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    java.lang.String utf8LineStrict = bufferedSourceBuffer.readUtf8LineStrict();
                    if (utf8LineStrict.length() > 0) {
                        throw new java.io.IOException("expected \"\" but was \"" + utf8LineStrict + io.dcloud.common.util.JSUtil.QUOTE);
                    }
                    this.handshake = dc.squareup.okhttp3.Handshake.get(!bufferedSourceBuffer.exhausted() ? dc.squareup.okhttp3.TlsVersion.forJavaName(bufferedSourceBuffer.readUtf8LineStrict()) : dc.squareup.okhttp3.TlsVersion.SSL_3_0, dc.squareup.okhttp3.CipherSuite.forJavaName(bufferedSourceBuffer.readUtf8LineStrict()), readCertificateList(bufferedSourceBuffer), readCertificateList(bufferedSourceBuffer));
                } else {
                    this.handshake = null;
                }
                source.close();
            } catch (java.lang.Throwable th) {
                source.close();
                throw th;
            }
        }

        private boolean isHttps() {
            return this.url.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTPS_PROTOCOL);
        }

        private java.util.List<java.security.cert.Certificate> readCertificateList(dc.squareup.okio.BufferedSource bufferedSource) throws java.io.IOException {
            int i = dc.squareup.okhttp3.Cache.readInt(bufferedSource);
            if (i == -1) {
                return java.util.Collections.EMPTY_LIST;
            }
            try {
                java.security.cert.CertificateFactory certificateFactory = java.security.cert.CertificateFactory.getInstance("X.509");
                java.util.ArrayList arrayList = new java.util.ArrayList(i);
                for (int i2 = 0; i2 < i; i2++) {
                    java.lang.String utf8LineStrict = bufferedSource.readUtf8LineStrict();
                    dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
                    buffer.write(dc.squareup.okio.ByteString.decodeBase64(utf8LineStrict));
                    arrayList.add(certificateFactory.generateCertificate(buffer.inputStream()));
                }
                return arrayList;
            } catch (java.security.cert.CertificateException e) {
                throw new java.io.IOException(e.getMessage());
            }
        }

        private void writeCertList(dc.squareup.okio.BufferedSink bufferedSink, java.util.List<java.security.cert.Certificate> list) throws java.io.IOException {
            try {
                bufferedSink.writeDecimalLong(list.size()).writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bufferedSink.writeUtf8(dc.squareup.okio.ByteString.of(list.get(i).getEncoded()).base64()).writeByte(10);
                }
            } catch (java.security.cert.CertificateEncodingException e) {
                throw new java.io.IOException(e.getMessage());
            }
        }

        public boolean matches(dc.squareup.okhttp3.Request request, dc.squareup.okhttp3.Response response) {
            return this.url.equals(request.url().toString()) && this.requestMethod.equals(request.method()) && dc.squareup.okhttp3.internal.http.HttpHeaders.varyMatches(response, this.varyHeaders, request);
        }

        public dc.squareup.okhttp3.Response response(dc.squareup.okhttp3.internal.cache.DiskLruCache.Snapshot snapshot) {
            java.lang.String str = this.responseHeaders.get(io.dcloud.common.util.net.NetWork.CONTENT_TYPE);
            java.lang.String str2 = this.responseHeaders.get("Content-Length");
            return new dc.squareup.okhttp3.Response.Builder().request(new dc.squareup.okhttp3.Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new dc.squareup.okhttp3.Cache.CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        public void writeTo(dc.squareup.okhttp3.internal.cache.DiskLruCache.Editor editor) throws java.io.IOException {
            dc.squareup.okio.BufferedSink bufferedSinkBuffer = dc.squareup.okio.Okio.buffer(editor.newSink(0));
            bufferedSinkBuffer.writeUtf8(this.url).writeByte(10);
            bufferedSinkBuffer.writeUtf8(this.requestMethod).writeByte(10);
            bufferedSinkBuffer.writeDecimalLong(this.varyHeaders.size()).writeByte(10);
            int size = this.varyHeaders.size();
            for (int i = 0; i < size; i++) {
                bufferedSinkBuffer.writeUtf8(this.varyHeaders.name(i)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(i)).writeByte(10);
            }
            bufferedSinkBuffer.writeUtf8(new dc.squareup.okhttp3.internal.http.StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);
            bufferedSinkBuffer.writeDecimalLong(this.responseHeaders.size() + 2).writeByte(10);
            int size2 = this.responseHeaders.size();
            for (int i2 = 0; i2 < size2; i2++) {
                bufferedSinkBuffer.writeUtf8(this.responseHeaders.name(i2)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(i2)).writeByte(10);
            }
            bufferedSinkBuffer.writeUtf8(SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);
            bufferedSinkBuffer.writeUtf8(RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);
            if (isHttps()) {
                bufferedSinkBuffer.writeByte(10);
                bufferedSinkBuffer.writeUtf8(this.handshake.cipherSuite().javaName()).writeByte(10);
                writeCertList(bufferedSinkBuffer, this.handshake.peerCertificates());
                writeCertList(bufferedSinkBuffer, this.handshake.localCertificates());
                bufferedSinkBuffer.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);
            }
            bufferedSinkBuffer.close();
        }

        Entry(dc.squareup.okhttp3.Response response) {
            this.url = response.request().url().toString();
            this.varyHeaders = dc.squareup.okhttp3.internal.http.HttpHeaders.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }
    }
}
