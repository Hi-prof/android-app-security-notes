package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Request {
    final dc.squareup.okhttp3.RequestBody body;
    private volatile dc.squareup.okhttp3.CacheControl cacheControl;
    final dc.squareup.okhttp3.Headers headers;
    final java.lang.String method;
    final java.util.Map<java.lang.Class<?>, java.lang.Object> tags;
    final dc.squareup.okhttp3.HttpUrl url;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class Builder {
        dc.squareup.okhttp3.RequestBody body;
        dc.squareup.okhttp3.Headers.Builder headers;
        java.lang.String method;
        java.util.Map<java.lang.Class<?>, java.lang.Object> tags;
        dc.squareup.okhttp3.HttpUrl url;

        public Builder() {
            this.tags = java.util.Collections.EMPTY_MAP;
            this.method = "GET";
            this.headers = new dc.squareup.okhttp3.Headers.Builder();
        }

        public dc.squareup.okhttp3.Request.Builder addHeader(java.lang.String str, java.lang.String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public dc.squareup.okhttp3.Request build() {
            if (this.url != null) {
                return new dc.squareup.okhttp3.Request(this);
            }
            throw new java.lang.IllegalStateException("url == null");
        }

        public dc.squareup.okhttp3.Request.Builder cacheControl(dc.squareup.okhttp3.CacheControl cacheControl) {
            java.lang.String string = cacheControl.toString();
            return string.isEmpty() ? removeHeader("Cache-Control") : header("Cache-Control", string);
        }

        public dc.squareup.okhttp3.Request.Builder delete(dc.squareup.okhttp3.RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public dc.squareup.okhttp3.Request.Builder get() {
            return method("GET", null);
        }

        public dc.squareup.okhttp3.Request.Builder head() {
            return method("HEAD", null);
        }

        public dc.squareup.okhttp3.Request.Builder header(java.lang.String str, java.lang.String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public dc.squareup.okhttp3.Request.Builder headers(dc.squareup.okhttp3.Headers headers) {
            this.headers = headers.newBuilder();
            return this;
        }

        public dc.squareup.okhttp3.Request.Builder method(java.lang.String str, dc.squareup.okhttp3.RequestBody requestBody) {
            if (str == null) {
                throw new java.lang.NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new java.lang.IllegalArgumentException("method.length() == 0");
            }
            if (requestBody != null && !dc.squareup.okhttp3.internal.http.HttpMethod.permitsRequestBody(str)) {
                throw new java.lang.IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (requestBody != null || !dc.squareup.okhttp3.internal.http.HttpMethod.requiresRequestBody(str)) {
                this.method = str;
                this.body = requestBody;
                return this;
            }
            throw new java.lang.IllegalArgumentException("method " + str + " must have a request body.");
        }

        public dc.squareup.okhttp3.Request.Builder patch(dc.squareup.okhttp3.RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public dc.squareup.okhttp3.Request.Builder post(dc.squareup.okhttp3.RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public dc.squareup.okhttp3.Request.Builder put(dc.squareup.okhttp3.RequestBody requestBody) {
            return method("PUT", requestBody);
        }

        public dc.squareup.okhttp3.Request.Builder removeHeader(java.lang.String str) {
            this.headers.removeAll(str);
            return this;
        }

        public dc.squareup.okhttp3.Request.Builder tag(java.lang.Object obj) {
            return tag(java.lang.Object.class, obj);
        }

        public dc.squareup.okhttp3.Request.Builder url(dc.squareup.okhttp3.HttpUrl httpUrl) {
            if (httpUrl == null) {
                throw new java.lang.NullPointerException("url == null");
            }
            this.url = httpUrl;
            return this;
        }

        public dc.squareup.okhttp3.Request.Builder delete() {
            return delete(dc.squareup.okhttp3.internal.Util.EMPTY_REQUEST);
        }

        public <T> dc.squareup.okhttp3.Request.Builder tag(java.lang.Class<? super T> cls, T t) {
            if (cls == null) {
                throw new java.lang.NullPointerException("type == null");
            }
            if (t == null) {
                this.tags.remove(cls);
                return this;
            }
            if (this.tags.isEmpty()) {
                this.tags = new java.util.LinkedHashMap();
            }
            this.tags.put(cls, cls.cast(t));
            return this;
        }

        public dc.squareup.okhttp3.Request.Builder url(java.lang.String str) {
            java.lang.String str2;
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str2 = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str2 = "https:" + str.substring(4);
                } else {
                    str2 = str;
                }
                return url(dc.squareup.okhttp3.HttpUrl.get(str2));
            }
            throw new java.lang.NullPointerException("url == null");
        }

        Builder(dc.squareup.okhttp3.Request request) {
            java.util.Map<java.lang.Class<?>, java.lang.Object> map = java.util.Collections.EMPTY_MAP;
            this.tags = map;
            this.url = request.url;
            this.method = request.method;
            this.body = request.body;
            this.tags = request.tags.isEmpty() ? map : new java.util.LinkedHashMap<>(request.tags);
            this.headers = request.headers.newBuilder();
        }

        public dc.squareup.okhttp3.Request.Builder url(java.net.URL url) {
            if (url != null) {
                return url(dc.squareup.okhttp3.HttpUrl.get(url.toString()));
            }
            throw new java.lang.NullPointerException("url == null");
        }
    }

    Request(dc.squareup.okhttp3.Request.Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers.build();
        this.body = builder.body;
        this.tags = dc.squareup.okhttp3.internal.Util.immutableMap(builder.tags);
    }

    public dc.squareup.okhttp3.RequestBody body() {
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

    public java.lang.String header(java.lang.String str) {
        return this.headers.get(str);
    }

    public dc.squareup.okhttp3.Headers headers() {
        return this.headers;
    }

    public boolean isHttps() {
        return this.url.isHttps();
    }

    public java.lang.String method() {
        return this.method;
    }

    public dc.squareup.okhttp3.Request.Builder newBuilder() {
        return new dc.squareup.okhttp3.Request.Builder(this);
    }

    public java.lang.Object tag() {
        return tag(java.lang.Object.class);
    }

    public java.lang.String toString() {
        return "Request{method=" + this.method + ", url=" + this.url + ", tags=" + this.tags + com.taobao.weex.el.parse.Operators.BLOCK_END;
    }

    public dc.squareup.okhttp3.HttpUrl url() {
        return this.url;
    }

    public java.util.List<java.lang.String> headers(java.lang.String str) {
        return this.headers.values(str);
    }

    public <T> T tag(java.lang.Class<? extends T> cls) {
        return cls.cast(this.tags.get(cls));
    }
}
