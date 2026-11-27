package dc.squareup.okhttp3.internal.cache;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class CacheStrategy {
    public final dc.squareup.okhttp3.Response cacheResponse;
    public final dc.squareup.okhttp3.Request networkRequest;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class Factory {
        private int ageSeconds;
        final dc.squareup.okhttp3.Response cacheResponse;
        private java.lang.String etag;
        private java.util.Date expires;
        private java.util.Date lastModified;
        private java.lang.String lastModifiedString;
        final long nowMillis;
        private long receivedResponseMillis;
        final dc.squareup.okhttp3.Request request;
        private long sentRequestMillis;
        private java.util.Date servedDate;
        private java.lang.String servedDateString;

        public Factory(long j, dc.squareup.okhttp3.Request request, dc.squareup.okhttp3.Response response) {
            this.ageSeconds = -1;
            this.nowMillis = j;
            this.request = request;
            this.cacheResponse = response;
            if (response != null) {
                this.sentRequestMillis = response.sentRequestAtMillis();
                this.receivedResponseMillis = response.receivedResponseAtMillis();
                dc.squareup.okhttp3.Headers headers = response.headers();
                int size = headers.size();
                for (int i = 0; i < size; i++) {
                    java.lang.String strName = headers.name(i);
                    java.lang.String strValue = headers.value(i);
                    if ("Date".equalsIgnoreCase(strName)) {
                        this.servedDate = dc.squareup.okhttp3.internal.http.HttpDate.parse(strValue);
                        this.servedDateString = strValue;
                    } else if ("Expires".equalsIgnoreCase(strName)) {
                        this.expires = dc.squareup.okhttp3.internal.http.HttpDate.parse(strValue);
                    } else if ("Last-Modified".equalsIgnoreCase(strName)) {
                        this.lastModified = dc.squareup.okhttp3.internal.http.HttpDate.parse(strValue);
                        this.lastModifiedString = strValue;
                    } else if ("ETag".equalsIgnoreCase(strName)) {
                        this.etag = strValue;
                    } else if ("Age".equalsIgnoreCase(strName)) {
                        this.ageSeconds = dc.squareup.okhttp3.internal.http.HttpHeaders.parseSeconds(strValue, -1);
                    }
                }
            }
        }

        private long cacheResponseAge() {
            java.util.Date date = this.servedDate;
            long jMax = date != null ? java.lang.Math.max(0L, this.receivedResponseMillis - date.getTime()) : 0L;
            int i = this.ageSeconds;
            if (i != -1) {
                jMax = java.lang.Math.max(jMax, java.util.concurrent.TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.receivedResponseMillis;
            return jMax + (j - this.sentRequestMillis) + (this.nowMillis - j);
        }

        private long computeFreshnessLifetime() {
            dc.squareup.okhttp3.CacheControl cacheControl = this.cacheResponse.cacheControl();
            if (cacheControl.maxAgeSeconds() != -1) {
                return java.util.concurrent.TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds());
            }
            if (this.expires != null) {
                java.util.Date date = this.servedDate;
                long time = this.expires.getTime() - (date != null ? date.getTime() : this.receivedResponseMillis);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.lastModified != null && this.cacheResponse.request().url().query() == null) {
                java.util.Date date2 = this.servedDate;
                long time2 = (date2 != null ? date2.getTime() : this.sentRequestMillis) - this.lastModified.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0L;
        }

        private dc.squareup.okhttp3.internal.cache.CacheStrategy getCandidate() {
            java.lang.String str;
            if (this.cacheResponse == null) {
                return new dc.squareup.okhttp3.internal.cache.CacheStrategy(this.request, null);
            }
            if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
                return new dc.squareup.okhttp3.internal.cache.CacheStrategy(this.request, null);
            }
            if (!dc.squareup.okhttp3.internal.cache.CacheStrategy.isCacheable(this.cacheResponse, this.request)) {
                return new dc.squareup.okhttp3.internal.cache.CacheStrategy(this.request, null);
            }
            dc.squareup.okhttp3.CacheControl cacheControl = this.request.cacheControl();
            if (cacheControl.noCache() || hasConditions(this.request)) {
                return new dc.squareup.okhttp3.internal.cache.CacheStrategy(this.request, null);
            }
            dc.squareup.okhttp3.CacheControl cacheControl2 = this.cacheResponse.cacheControl();
            long jCacheResponseAge = cacheResponseAge();
            long jComputeFreshnessLifetime = computeFreshnessLifetime();
            if (cacheControl.maxAgeSeconds() != -1) {
                jComputeFreshnessLifetime = java.lang.Math.min(jComputeFreshnessLifetime, java.util.concurrent.TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()));
            }
            long millis = 0;
            long millis2 = cacheControl.minFreshSeconds() != -1 ? java.util.concurrent.TimeUnit.SECONDS.toMillis(cacheControl.minFreshSeconds()) : 0L;
            if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                millis = java.util.concurrent.TimeUnit.SECONDS.toMillis(cacheControl.maxStaleSeconds());
            }
            if (!cacheControl2.noCache()) {
                long j = millis2 + jCacheResponseAge;
                if (j < millis + jComputeFreshnessLifetime) {
                    dc.squareup.okhttp3.Response.Builder builderNewBuilder = this.cacheResponse.newBuilder();
                    if (j >= jComputeFreshnessLifetime) {
                        builderNewBuilder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jCacheResponseAge > 86400000 && isFreshnessLifetimeHeuristic()) {
                        builderNewBuilder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new dc.squareup.okhttp3.internal.cache.CacheStrategy(null, builderNewBuilder.build());
                }
            }
            java.lang.String str2 = this.etag;
            if (str2 != null) {
                str = "If-None-Match";
            } else {
                if (this.lastModified != null) {
                    str2 = this.lastModifiedString;
                } else {
                    if (this.servedDate == null) {
                        return new dc.squareup.okhttp3.internal.cache.CacheStrategy(this.request, null);
                    }
                    str2 = this.servedDateString;
                }
                str = "If-Modified-Since";
            }
            dc.squareup.okhttp3.Headers.Builder builderNewBuilder2 = this.request.headers().newBuilder();
            dc.squareup.okhttp3.internal.Internal.instance.addLenient(builderNewBuilder2, str, str2);
            return new dc.squareup.okhttp3.internal.cache.CacheStrategy(this.request.newBuilder().headers(builderNewBuilder2.build()).build(), this.cacheResponse);
        }

        private static boolean hasConditions(dc.squareup.okhttp3.Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }

        private boolean isFreshnessLifetimeHeuristic() {
            return this.cacheResponse.cacheControl().maxAgeSeconds() == -1 && this.expires == null;
        }

        public dc.squareup.okhttp3.internal.cache.CacheStrategy get() {
            dc.squareup.okhttp3.internal.cache.CacheStrategy candidate = getCandidate();
            return (candidate.networkRequest == null || !this.request.cacheControl().onlyIfCached()) ? candidate : new dc.squareup.okhttp3.internal.cache.CacheStrategy(null, null);
        }
    }

    CacheStrategy(dc.squareup.okhttp3.Request request, dc.squareup.okhttp3.Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.cacheControl().isPrivate() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isCacheable(dc.squareup.okhttp3.Response r3, dc.squareup.okhttp3.Request r4) {
        /*
            int r0 = r3.code()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.header(r0)
            if (r0 != 0) goto L5a
            dc.squareup.okhttp3.CacheControl r0 = r3.cacheControl()
            int r0 = r0.maxAgeSeconds()
            r1 = -1
            if (r0 != r1) goto L5a
            dc.squareup.okhttp3.CacheControl r0 = r3.cacheControl()
            boolean r0 = r0.isPublic()
            if (r0 != 0) goto L5a
            dc.squareup.okhttp3.CacheControl r0 = r3.cacheControl()
            boolean r0 = r0.isPrivate()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            dc.squareup.okhttp3.CacheControl r3 = r3.cacheControl()
            boolean r3 = r3.noStore()
            if (r3 != 0) goto L70
            dc.squareup.okhttp3.CacheControl r3 = r4.cacheControl()
            boolean r3 = r3.noStore()
            if (r3 != 0) goto L70
            r3 = 1
            return r3
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.squareup.okhttp3.internal.cache.CacheStrategy.isCacheable(dc.squareup.okhttp3.Response, dc.squareup.okhttp3.Request):boolean");
    }
}
