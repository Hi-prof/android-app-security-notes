package dc.squareup.okhttp3.internal.http;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class BridgeInterceptor implements dc.squareup.okhttp3.Interceptor {
    private static final java.util.Comparator<java.lang.String> FIELD_NAME_COMPARATOR = new java.util.Comparator<java.lang.String>() { // from class: dc.squareup.okhttp3.internal.http.BridgeInterceptor.1
        @Override // java.util.Comparator
        public int compare(java.lang.String str, java.lang.String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return java.lang.String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    };
    private final dc.squareup.okhttp3.CookieJar cookieJar;

    public BridgeInterceptor(dc.squareup.okhttp3.CookieJar cookieJar) {
        this.cookieJar = cookieJar;
    }

    public static void addCookies(dc.squareup.okhttp3.Request.Builder builder, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : map.entrySet()) {
            java.lang.String key = entry.getKey();
            if (io.dcloud.common.DHInterface.IWebview.COOKIE.equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key)) {
                if (!entry.getValue().isEmpty()) {
                    builder.addHeader(key, buildCookieHeader(entry.getValue()));
                }
            }
        }
    }

    public static java.lang.String buildCookieHeader(java.util.List<java.lang.String> list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    private java.lang.String cookieHeader(java.util.List<dc.squareup.okhttp3.Cookie> list) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            dc.squareup.okhttp3.Cookie cookie = list.get(i);
            sb.append(cookie.name());
            sb.append('=');
            sb.append(cookie.value());
        }
        return sb.toString();
    }

    public static java.util.Map<java.lang.String, java.util.List<java.lang.String>> toMultimap(dc.squareup.okhttp3.Headers headers, java.lang.String str) {
        java.util.TreeMap treeMap = new java.util.TreeMap(FIELD_NAME_COMPARATOR);
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            java.lang.String strName = headers.name(i);
            java.lang.String strValue = headers.value(i);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.List list = (java.util.List) treeMap.get(strName);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(strValue);
            treeMap.put(strName, java.util.Collections.unmodifiableList(arrayList));
        }
        if (str != null) {
            treeMap.put(null, java.util.Collections.unmodifiableList(java.util.Collections.singletonList(str)));
        }
        return java.util.Collections.unmodifiableMap(treeMap);
    }

    @Override // dc.squareup.okhttp3.Interceptor
    public dc.squareup.okhttp3.Response intercept(dc.squareup.okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        dc.squareup.okhttp3.Request request = chain.request();
        dc.squareup.okhttp3.Request.Builder builderNewBuilder = request.newBuilder();
        dc.squareup.okhttp3.RequestBody requestBodyBody = request.body();
        if (requestBodyBody != null) {
            dc.squareup.okhttp3.MediaType mediaTypeContentType = requestBodyBody.contentType();
            if (mediaTypeContentType != null) {
                builderNewBuilder.header(io.dcloud.common.util.net.NetWork.CONTENT_TYPE, mediaTypeContentType.toString());
            }
            long jContentLength = requestBodyBody.contentLength();
            if (jContentLength != -1) {
                builderNewBuilder.header("Content-Length", java.lang.Long.toString(jContentLength));
                builderNewBuilder.removeHeader("Transfer-Encoding");
            } else {
                builderNewBuilder.header("Transfer-Encoding", "chunked");
                builderNewBuilder.removeHeader("Content-Length");
            }
        }
        boolean z = false;
        if (request.header("Host") == null) {
            builderNewBuilder.header("Host", dc.squareup.okhttp3.internal.Util.hostHeader(request.url(), false));
        }
        if (request.header("Connection") == null) {
            builderNewBuilder.header("Connection", "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null && request.header("Range") == null) {
            builderNewBuilder.header("Accept-Encoding", "gzip");
            z = true;
        }
        java.lang.String strHeader = request.header("cookie");
        if (strHeader == null) {
            java.net.CookieHandler cookieHandler = java.net.CookieHandler.getDefault();
            if (cookieHandler != null) {
                try {
                    addCookies(builderNewBuilder, cookieHandler.get(request.url().uri(), toMultimap(request.headers(), null)));
                } catch (java.lang.Exception unused) {
                }
            }
        } else {
            builderNewBuilder.header(io.dcloud.common.DHInterface.IWebview.COOKIE, strHeader);
        }
        if (request.header(io.dcloud.common.DHInterface.IWebview.USER_AGENT) == null) {
            builderNewBuilder.header(io.dcloud.common.DHInterface.IWebview.USER_AGENT, dc.squareup.okhttp3.internal.Version.userAgent());
        }
        dc.squareup.okhttp3.Response responseProceed = chain.proceed(builderNewBuilder.build());
        try {
            java.net.CookieHandler cookieHandler2 = java.net.CookieHandler.getDefault();
            if (cookieHandler2 != null) {
                cookieHandler2.put(request.url().uri(), toMultimap(responseProceed.headers(), null));
            }
        } catch (java.lang.Exception unused2) {
        }
        dc.squareup.okhttp3.internal.http.HttpHeaders.receiveHeaders(this.cookieJar, request.url(), responseProceed.headers());
        dc.squareup.okhttp3.Response.Builder builderRequest = responseProceed.newBuilder().request(request);
        if (z && "gzip".equalsIgnoreCase(responseProceed.header("Content-Encoding")) && dc.squareup.okhttp3.internal.http.HttpHeaders.hasBody(responseProceed)) {
            dc.squareup.okio.GzipSource gzipSource = new dc.squareup.okio.GzipSource(responseProceed.body().source());
            builderRequest.headers(responseProceed.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
            builderRequest.body(new dc.squareup.okhttp3.internal.http.RealResponseBody(responseProceed.header(io.dcloud.common.util.net.NetWork.CONTENT_TYPE), -1L, dc.squareup.okio.Okio.buffer(gzipSource)));
        }
        return builderRequest.build();
    }
}
