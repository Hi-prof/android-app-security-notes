package dc.squareup.okhttp3.internal.cache;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class CacheInterceptor implements dc.squareup.okhttp3.Interceptor {
    final dc.squareup.okhttp3.internal.cache.InternalCache cache;

    public CacheInterceptor(dc.squareup.okhttp3.internal.cache.InternalCache internalCache) {
        this.cache = internalCache;
    }

    private dc.squareup.okhttp3.Response cacheWritingResponse(final dc.squareup.okhttp3.internal.cache.CacheRequest cacheRequest, dc.squareup.okhttp3.Response response) throws java.io.IOException {
        dc.squareup.okio.Sink sinkBody;
        if (cacheRequest == null || (sinkBody = cacheRequest.body()) == null) {
            return response;
        }
        final dc.squareup.okio.BufferedSource bufferedSourceSource = response.body().source();
        final dc.squareup.okio.BufferedSink bufferedSinkBuffer = dc.squareup.okio.Okio.buffer(sinkBody);
        return response.newBuilder().body(new dc.squareup.okhttp3.internal.http.RealResponseBody(response.header(io.dcloud.common.util.net.NetWork.CONTENT_TYPE), response.body().contentLength(), dc.squareup.okio.Okio.buffer(new dc.squareup.okio.Source() { // from class: dc.squareup.okhttp3.internal.cache.CacheInterceptor.1
            boolean cacheRequestClosed;

            @Override // dc.squareup.okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.io.IOException {
                if (!this.cacheRequestClosed && !dc.squareup.okhttp3.internal.Util.discard(this, 100, java.util.concurrent.TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                bufferedSourceSource.close();
            }

            @Override // dc.squareup.okio.Source
            public long read(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
                try {
                    long j2 = bufferedSourceSource.read(buffer, j);
                    if (j2 != -1) {
                        buffer.copyTo(bufferedSinkBuffer.buffer(), buffer.size() - j2, j2);
                        bufferedSinkBuffer.emitCompleteSegments();
                        return j2;
                    }
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        bufferedSinkBuffer.close();
                    }
                    return -1L;
                } catch (java.io.IOException e) {
                    if (this.cacheRequestClosed) {
                        throw e;
                    }
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                    throw e;
                }
            }

            @Override // dc.squareup.okio.Source
            public dc.squareup.okio.Timeout timeout() {
                return bufferedSourceSource.timeout();
            }
        }))).build();
    }

    private static dc.squareup.okhttp3.Headers combine(dc.squareup.okhttp3.Headers headers, dc.squareup.okhttp3.Headers headers2) {
        dc.squareup.okhttp3.Headers.Builder builder = new dc.squareup.okhttp3.Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            java.lang.String strName = headers.name(i);
            java.lang.String strValue = headers.value(i);
            if ((!"Warning".equalsIgnoreCase(strName) || !strValue.startsWith("1")) && (isContentSpecificHeader(strName) || !isEndToEnd(strName) || headers2.get(strName) == null)) {
                dc.squareup.okhttp3.internal.Internal.instance.addLenient(builder, strName, strValue);
            }
        }
        int size2 = headers2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            java.lang.String strName2 = headers2.name(i2);
            if (!isContentSpecificHeader(strName2) && isEndToEnd(strName2)) {
                dc.squareup.okhttp3.internal.Internal.instance.addLenient(builder, strName2, headers2.value(i2));
            }
        }
        return builder.build();
    }

    static boolean isContentSpecificHeader(java.lang.String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || io.dcloud.common.util.net.NetWork.CONTENT_TYPE.equalsIgnoreCase(str);
    }

    static boolean isEndToEnd(java.lang.String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    private static dc.squareup.okhttp3.Response stripBody(dc.squareup.okhttp3.Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body(null).build();
    }

    @Override // dc.squareup.okhttp3.Interceptor
    public dc.squareup.okhttp3.Response intercept(dc.squareup.okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        dc.squareup.okhttp3.internal.cache.InternalCache internalCache = this.cache;
        dc.squareup.okhttp3.Response response = internalCache != null ? internalCache.get(chain.request()) : null;
        dc.squareup.okhttp3.internal.cache.CacheStrategy cacheStrategy = new dc.squareup.okhttp3.internal.cache.CacheStrategy.Factory(java.lang.System.currentTimeMillis(), chain.request(), response).get();
        dc.squareup.okhttp3.Request request = cacheStrategy.networkRequest;
        dc.squareup.okhttp3.Response response2 = cacheStrategy.cacheResponse;
        dc.squareup.okhttp3.internal.cache.InternalCache internalCache2 = this.cache;
        if (internalCache2 != null) {
            internalCache2.trackResponse(cacheStrategy);
        }
        if (response != null && response2 == null) {
            dc.squareup.okhttp3.internal.Util.closeQuietly(response.body());
        }
        if (request == null && response2 == null) {
            return new dc.squareup.okhttp3.Response.Builder().request(chain.request()).protocol(dc.squareup.okhttp3.Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(dc.squareup.okhttp3.internal.Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(java.lang.System.currentTimeMillis()).build();
        }
        if (request == null) {
            return response2.newBuilder().cacheResponse(stripBody(response2)).build();
        }
        try {
            dc.squareup.okhttp3.Response responseProceed = chain.proceed(request);
            if (responseProceed == null && response != null) {
                dc.squareup.okhttp3.internal.Util.closeQuietly(response.body());
            }
            if (response2 != null) {
                if (responseProceed.code() == 304) {
                    dc.squareup.okhttp3.Response responseBuild = response2.newBuilder().headers(combine(response2.headers(), responseProceed.headers())).sentRequestAtMillis(responseProceed.sentRequestAtMillis()).receivedResponseAtMillis(responseProceed.receivedResponseAtMillis()).cacheResponse(stripBody(response2)).networkResponse(stripBody(responseProceed)).build();
                    responseProceed.body().close();
                    this.cache.trackConditionalCacheHit();
                    this.cache.update(response2, responseBuild);
                    return responseBuild;
                }
                dc.squareup.okhttp3.internal.Util.closeQuietly(response2.body());
            }
            dc.squareup.okhttp3.Response responseBuild2 = responseProceed.newBuilder().cacheResponse(stripBody(response2)).networkResponse(stripBody(responseProceed)).build();
            if (this.cache != null) {
                if (dc.squareup.okhttp3.internal.http.HttpHeaders.hasBody(responseBuild2) && dc.squareup.okhttp3.internal.cache.CacheStrategy.isCacheable(responseBuild2, request)) {
                    return cacheWritingResponse(this.cache.put(responseBuild2), responseBuild2);
                }
                if (dc.squareup.okhttp3.internal.http.HttpMethod.invalidatesCache(request.method())) {
                    try {
                        this.cache.remove(request);
                    } catch (java.io.IOException unused) {
                    }
                }
            }
            return responseBuild2;
        } catch (java.lang.Throwable th) {
            if (response != null) {
                dc.squareup.okhttp3.internal.Util.closeQuietly(response.body());
            }
            throw th;
        }
    }
}
