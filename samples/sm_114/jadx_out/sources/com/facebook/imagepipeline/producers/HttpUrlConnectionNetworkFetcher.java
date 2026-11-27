package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class HttpUrlConnectionNetworkFetcher extends com.facebook.imagepipeline.producers.BaseNetworkFetcher<com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.HttpUrlConnectionNetworkFetchState> {
    private static final java.lang.String FETCH_TIME = "fetch_time";
    public static final int HTTP_DEFAULT_TIMEOUT = 30000;
    public static final int HTTP_PERMANENT_REDIRECT = 308;
    public static final int HTTP_TEMPORARY_REDIRECT = 307;
    private static final java.lang.String IMAGE_SIZE = "image_size";
    private static final int MAX_REDIRECTS = 5;
    private static final int NUM_NETWORK_THREADS = 3;
    private static final java.lang.String QUEUE_TIME = "queue_time";
    private static final java.lang.String TOTAL_TIME = "total_time";
    private final java.util.concurrent.ExecutorService mExecutorService;
    private int mHttpConnectionTimeout;
    private final com.facebook.common.time.MonotonicClock mMonotonicClock;

    @javax.annotation.Nullable
    private final java.util.Map<java.lang.String, java.lang.String> mRequestHeaders;

    @javax.annotation.Nullable
    private java.lang.String mUserAgent;

    private static boolean isHttpRedirect(int i) {
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

    private static boolean isHttpSuccess(int i) {
        return i >= 200 && i < 300;
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ com.facebook.imagepipeline.producers.FetchState createFetchState(com.facebook.imagepipeline.producers.Consumer consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        return createFetchState((com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage>) consumer, producerContext);
    }

    public static class HttpUrlConnectionNetworkFetchState extends com.facebook.imagepipeline.producers.FetchState {
        private long fetchCompleteTime;
        private long responseTime;
        private long submitTime;

        public HttpUrlConnectionNetworkFetchState(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
            super(consumer, producerContext);
        }
    }

    public HttpUrlConnectionNetworkFetcher() {
        this((java.lang.String) null, (java.util.Map<java.lang.String, java.lang.String>) null, com.facebook.common.time.RealtimeSinceBootClock.get());
    }

    public HttpUrlConnectionNetworkFetcher(int i) {
        this((java.lang.String) null, (java.util.Map<java.lang.String, java.lang.String>) null, com.facebook.common.time.RealtimeSinceBootClock.get());
        this.mHttpConnectionTimeout = i;
    }

    public HttpUrlConnectionNetworkFetcher(java.lang.String str, int i) {
        this(str, (java.util.Map<java.lang.String, java.lang.String>) null, com.facebook.common.time.RealtimeSinceBootClock.get());
        this.mHttpConnectionTimeout = i;
    }

    public HttpUrlConnectionNetworkFetcher(java.lang.String str, @javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> map, int i) {
        this(str, map, com.facebook.common.time.RealtimeSinceBootClock.get());
        this.mHttpConnectionTimeout = i;
    }

    HttpUrlConnectionNetworkFetcher(@javax.annotation.Nullable java.lang.String str, @javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> map, com.facebook.common.time.MonotonicClock monotonicClock) {
        this.mExecutorService = java.util.concurrent.Executors.newFixedThreadPool(3);
        this.mMonotonicClock = monotonicClock;
        this.mRequestHeaders = map;
        this.mUserAgent = str;
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.HttpUrlConnectionNetworkFetchState createFetchState(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        return new com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.HttpUrlConnectionNetworkFetchState(consumer, producerContext);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public void fetch(final com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState, final com.facebook.imagepipeline.producers.NetworkFetcher.Callback callback) {
        httpUrlConnectionNetworkFetchState.submitTime = this.mMonotonicClock.now();
        final java.util.concurrent.Future<?> futureSubmit = this.mExecutorService.submit(new java.lang.Runnable() { // from class: com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.1
            @Override // java.lang.Runnable
            public void run() throws java.lang.Throwable {
                com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.this.fetchSync(httpUrlConnectionNetworkFetchState, callback);
            }
        });
        httpUrlConnectionNetworkFetchState.getContext().addCallbacks(new com.facebook.imagepipeline.producers.BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                if (futureSubmit.cancel(false)) {
                    callback.onCancellation();
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0048  */
    /* JADX WARN: Code duplicated, block: B:39:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:? A[SYNTHETIC] */
    void fetchSync(com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState, com.facebook.imagepipeline.producers.NetworkFetcher.Callback callback) throws java.lang.Throwable {
        java.net.HttpURLConnection httpURLConnectionDownloadFrom;
        java.io.InputStream inputStream = null;
        try {
            httpURLConnectionDownloadFrom = downloadFrom(httpUrlConnectionNetworkFetchState.getUri(), 5);
            try {
                try {
                    httpUrlConnectionNetworkFetchState.responseTime = this.mMonotonicClock.now();
                    if (httpURLConnectionDownloadFrom != null) {
                        inputStream = httpURLConnectionDownloadFrom.getInputStream();
                        callback.onResponse(inputStream, -1);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException unused) {
                        }
                    }
                    if (httpURLConnectionDownloadFrom == null) {
                        return;
                    }
                } catch (java.io.IOException e) {
                    e = e;
                    callback.onFailure(e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    if (httpURLConnectionDownloadFrom == null) {
                        return;
                    }
                }
            } catch (java.lang.Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                if (httpURLConnectionDownloadFrom != null) {
                    httpURLConnectionDownloadFrom.disconnect();
                    throw th;
                }
                throw th;
            }
        } catch (java.io.IOException e2) {
            e = e2;
            httpURLConnectionDownloadFrom = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            httpURLConnectionDownloadFrom = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnectionDownloadFrom != null) {
                httpURLConnectionDownloadFrom.disconnect();
                throw th;
            }
            throw th;
        }
        httpURLConnectionDownloadFrom.disconnect();
    }

    private java.net.HttpURLConnection downloadFrom(android.net.Uri uri, int i) throws java.io.IOException {
        java.net.HttpURLConnection httpURLConnectionOpenConnectionTo = openConnectionTo(uri);
        java.lang.String str = this.mUserAgent;
        if (str != null) {
            httpURLConnectionOpenConnectionTo.setRequestProperty(io.dcloud.common.DHInterface.IWebview.USER_AGENT, str);
        }
        java.util.Map<java.lang.String, java.lang.String> map = this.mRequestHeaders;
        if (map != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                httpURLConnectionOpenConnectionTo.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        httpURLConnectionOpenConnectionTo.setConnectTimeout(this.mHttpConnectionTimeout);
        int responseCode = httpURLConnectionOpenConnectionTo.getResponseCode();
        if (isHttpSuccess(responseCode)) {
            return httpURLConnectionOpenConnectionTo;
        }
        if (isHttpRedirect(responseCode)) {
            java.lang.String headerField = httpURLConnectionOpenConnectionTo.getHeaderField("Location");
            httpURLConnectionOpenConnectionTo.disconnect();
            android.net.Uri uri2 = headerField == null ? null : android.net.Uri.parse(headerField);
            java.lang.String scheme = uri.getScheme();
            if (i > 0 && uri2 != null && !com.facebook.common.internal.Objects.equal(uri2.getScheme(), scheme)) {
                return downloadFrom(uri2, i - 1);
            }
            throw new java.io.IOException(i == 0 ? error("URL %s follows too many redirects", uri.toString()) : error("URL %s returned %d without a valid redirect", uri.toString(), java.lang.Integer.valueOf(responseCode)));
        }
        httpURLConnectionOpenConnectionTo.disconnect();
        throw new java.io.IOException(java.lang.String.format("Image URL %s returned HTTP code %d", uri.toString(), java.lang.Integer.valueOf(responseCode)));
    }

    static java.net.HttpURLConnection openConnectionTo(android.net.Uri uri) throws java.io.IOException {
        return (java.net.HttpURLConnection) com.facebook.common.util.UriUtil.uriToUrl(uri).openConnection();
    }

    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public void onFetchCompletion(com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState, int i) {
        httpUrlConnectionNetworkFetchState.fetchCompleteTime = this.mMonotonicClock.now();
    }

    private static java.lang.String error(java.lang.String str, java.lang.Object... objArr) {
        return java.lang.String.format(java.util.Locale.getDefault(), str, objArr);
    }

    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public java.util.Map<java.lang.String, java.lang.String> getExtraMap(com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.HttpUrlConnectionNetworkFetchState httpUrlConnectionNetworkFetchState, int i) {
        java.util.HashMap map = new java.util.HashMap(4);
        map.put(QUEUE_TIME, java.lang.Long.toString(httpUrlConnectionNetworkFetchState.responseTime - httpUrlConnectionNetworkFetchState.submitTime));
        map.put(FETCH_TIME, java.lang.Long.toString(httpUrlConnectionNetworkFetchState.fetchCompleteTime - httpUrlConnectionNetworkFetchState.responseTime));
        map.put(TOTAL_TIME, java.lang.Long.toString(httpUrlConnectionNetworkFetchState.fetchCompleteTime - httpUrlConnectionNetworkFetchState.submitTime));
        map.put(IMAGE_SIZE, java.lang.Integer.toString(i));
        return map;
    }
}
