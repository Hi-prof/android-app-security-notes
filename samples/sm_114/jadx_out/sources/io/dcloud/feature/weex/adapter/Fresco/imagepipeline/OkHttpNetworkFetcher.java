package io.dcloud.feature.weex.adapter.Fresco.imagepipeline;

/* JADX INFO: loaded from: classes2.dex */
public class OkHttpNetworkFetcher extends com.facebook.imagepipeline.producers.BaseNetworkFetcher<io.dcloud.feature.weex.adapter.Fresco.imagepipeline.OkHttpNetworkFetcher.OkHttpNetworkFetchState> {
    private static final java.lang.String FETCH_TIME = "fetch_time";
    private static final java.lang.String IMAGE_SIZE = "image_size";
    private static final java.lang.String QUEUE_TIME = "queue_time";
    private static final java.lang.String TOTAL_TIME = "total_time";
    private final dc.squareup.okhttp3.CacheControl mCacheControl;
    private final dc.squareup.okhttp3.Call.Factory mCallFactory;
    private java.util.concurrent.Executor mCancellationExecutor;

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ com.facebook.imagepipeline.producers.FetchState createFetchState(com.facebook.imagepipeline.producers.Consumer consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        return createFetchState((com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage>) consumer, producerContext);
    }

    public static class OkHttpNetworkFetchState extends com.facebook.imagepipeline.producers.FetchState {
        public long fetchCompleteTime;
        public long responseTime;
        public long submitTime;

        public OkHttpNetworkFetchState(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
            super(consumer, producerContext);
        }
    }

    public OkHttpNetworkFetcher(dc.squareup.okhttp3.OkHttpClient okHttpClient) {
        this(okHttpClient, okHttpClient.dispatcher().executorService());
    }

    public OkHttpNetworkFetcher(dc.squareup.okhttp3.Call.Factory factory, java.util.concurrent.Executor executor) {
        this(factory, executor, true);
    }

    public OkHttpNetworkFetcher(dc.squareup.okhttp3.Call.Factory factory, java.util.concurrent.Executor executor, boolean z) {
        this.mCallFactory = factory;
        this.mCancellationExecutor = executor;
        this.mCacheControl = z ? new dc.squareup.okhttp3.CacheControl.Builder().noStore().build() : null;
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public io.dcloud.feature.weex.adapter.Fresco.imagepipeline.OkHttpNetworkFetcher.OkHttpNetworkFetchState createFetchState(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        return new io.dcloud.feature.weex.adapter.Fresco.imagepipeline.OkHttpNetworkFetcher.OkHttpNetworkFetchState(consumer, producerContext);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public void fetch(io.dcloud.feature.weex.adapter.Fresco.imagepipeline.OkHttpNetworkFetcher.OkHttpNetworkFetchState okHttpNetworkFetchState, com.facebook.imagepipeline.producers.NetworkFetcher.Callback callback) {
        okHttpNetworkFetchState.submitTime = android.os.SystemClock.elapsedRealtime();
        try {
            dc.squareup.okhttp3.Request.Builder builder = new dc.squareup.okhttp3.Request.Builder().url(okHttpNetworkFetchState.getUri().toString()).get();
            dc.squareup.okhttp3.CacheControl cacheControl = this.mCacheControl;
            if (cacheControl != null) {
                builder.cacheControl(cacheControl);
            }
            com.facebook.imagepipeline.common.BytesRange bytesRange = okHttpNetworkFetchState.getContext().getImageRequest().getBytesRange();
            if (bytesRange != null) {
                builder.addHeader("Range", bytesRange.toHttpRangeHeaderValue());
            }
            builder.addHeader(com.taobao.weex.http.WXHttpUtil.KEY_USER_AGENT, com.taobao.weex.http.WXHttpUtil.assembleUserAgent());
            fetchWithRequest(okHttpNetworkFetchState, callback, builder.build());
        } catch (java.lang.Exception e) {
            callback.onFailure(e);
        }
    }

    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public void onFetchCompletion(io.dcloud.feature.weex.adapter.Fresco.imagepipeline.OkHttpNetworkFetcher.OkHttpNetworkFetchState okHttpNetworkFetchState, int i) {
        okHttpNetworkFetchState.fetchCompleteTime = android.os.SystemClock.elapsedRealtime();
    }

    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public java.util.Map<java.lang.String, java.lang.String> getExtraMap(io.dcloud.feature.weex.adapter.Fresco.imagepipeline.OkHttpNetworkFetcher.OkHttpNetworkFetchState okHttpNetworkFetchState, int i) {
        java.util.HashMap map = new java.util.HashMap(4);
        map.put(QUEUE_TIME, java.lang.Long.toString(okHttpNetworkFetchState.responseTime - okHttpNetworkFetchState.submitTime));
        map.put(FETCH_TIME, java.lang.Long.toString(okHttpNetworkFetchState.fetchCompleteTime - okHttpNetworkFetchState.responseTime));
        map.put(TOTAL_TIME, java.lang.Long.toString(okHttpNetworkFetchState.fetchCompleteTime - okHttpNetworkFetchState.submitTime));
        map.put(IMAGE_SIZE, java.lang.Integer.toString(i));
        return map;
    }

    protected void fetchWithRequest(final io.dcloud.feature.weex.adapter.Fresco.imagepipeline.OkHttpNetworkFetcher.OkHttpNetworkFetchState okHttpNetworkFetchState, final com.facebook.imagepipeline.producers.NetworkFetcher.Callback callback, dc.squareup.okhttp3.Request request) {
        final dc.squareup.okhttp3.Call callNewCall = this.mCallFactory.newCall(request);
        okHttpNetworkFetchState.getContext().addCallbacks(new com.facebook.imagepipeline.producers.BaseProducerContextCallbacks() { // from class: io.dcloud.feature.weex.adapter.Fresco.imagepipeline.OkHttpNetworkFetcher.1
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                    io.dcloud.feature.weex.adapter.Fresco.imagepipeline.OkHttpNetworkFetcher.this.mCancellationExecutor.execute(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.adapter.Fresco.imagepipeline.OkHttpNetworkFetcher.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            callNewCall.cancel();
                        }
                    });
                } else {
                    callNewCall.cancel();
                }
            }
        });
        callNewCall.enqueue(new dc.squareup.okhttp3.Callback() { // from class: io.dcloud.feature.weex.adapter.Fresco.imagepipeline.OkHttpNetworkFetcher.2
            @Override // dc.squareup.okhttp3.Callback
            public void onFailure(dc.squareup.okhttp3.Call call, java.io.IOException iOException) {
                io.dcloud.feature.weex.adapter.Fresco.imagepipeline.OkHttpNetworkFetcher.this.handleException(call, iOException, callback);
            }

            @Override // dc.squareup.okhttp3.Callback
            public void onResponse(dc.squareup.okhttp3.Call call, dc.squareup.okhttp3.Response response) throws java.io.IOException {
                com.facebook.imagepipeline.common.BytesRange bytesRangeFromContentRangeHeader;
                okHttpNetworkFetchState.responseTime = android.os.SystemClock.elapsedRealtime();
                dc.squareup.okhttp3.ResponseBody responseBodyBody = response.body();
                try {
                    if (responseBodyBody == null) {
                        io.dcloud.feature.weex.adapter.Fresco.imagepipeline.OkHttpNetworkFetcher.this.handleException(call, new java.io.IOException("Response body null: " + response), callback);
                        return;
                    }
                    try {
                        if (!response.isSuccessful()) {
                            io.dcloud.feature.weex.adapter.Fresco.imagepipeline.OkHttpNetworkFetcher.this.handleException(call, new java.io.IOException("Unexpected HTTP code " + response), callback);
                            return;
                        }
                        try {
                            bytesRangeFromContentRangeHeader = com.facebook.imagepipeline.common.BytesRange.fromContentRangeHeader(response.header("Content-Range"));
                        } catch (java.lang.Exception e) {
                            io.dcloud.common.adapter.util.Logger.e("OkHttpNetworkFetcher", "Error parsing content range header" + e.getMessage());
                            bytesRangeFromContentRangeHeader = null;
                        }
                        if (bytesRangeFromContentRangeHeader != null && (bytesRangeFromContentRangeHeader.from != 0 || bytesRangeFromContentRangeHeader.to != Integer.MAX_VALUE)) {
                            okHttpNetworkFetchState.setResponseBytesRange(bytesRangeFromContentRangeHeader);
                            okHttpNetworkFetchState.setOnNewResultStatusFlags(8);
                        }
                        long jContentLength = responseBodyBody.contentLength();
                        if (jContentLength < 0) {
                            jContentLength = 0;
                        }
                        callback.onResponse(responseBodyBody.byteStream(), (int) jContentLength);
                    } catch (java.lang.Exception e2) {
                        io.dcloud.feature.weex.adapter.Fresco.imagepipeline.OkHttpNetworkFetcher.this.handleException(call, e2, callback);
                    }
                } finally {
                    responseBodyBody.close();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleException(dc.squareup.okhttp3.Call call, java.lang.Exception exc, com.facebook.imagepipeline.producers.NetworkFetcher.Callback callback) {
        if (call.isCanceled()) {
            callback.onCancellation();
        } else {
            callback.onFailure(exc);
        }
    }
}
