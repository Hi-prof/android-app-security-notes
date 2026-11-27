package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class RealCall implements dc.squareup.okhttp3.Call {
    private static final java.util.Comparator<java.lang.String> FIELD_NAME_COMPARATOR = new java.util.Comparator<java.lang.String>() { // from class: dc.squareup.okhttp3.RealCall.2
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
    final dc.squareup.okhttp3.OkHttpClient client;
    private dc.squareup.okhttp3.EventListener eventListener;
    private boolean executed;
    final boolean forWebSocket;
    final dc.squareup.okhttp3.Request originalRequest;
    final dc.squareup.okhttp3.internal.http.RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;
    final dc.squareup.okio.AsyncTimeout timeout;

    private RealCall(dc.squareup.okhttp3.OkHttpClient okHttpClient, dc.squareup.okhttp3.Request request, boolean z) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
        this.retryAndFollowUpInterceptor = new dc.squareup.okhttp3.internal.http.RetryAndFollowUpInterceptor(okHttpClient, z);
        dc.squareup.okio.AsyncTimeout asyncTimeout = new dc.squareup.okio.AsyncTimeout() { // from class: dc.squareup.okhttp3.RealCall.1
            @Override // dc.squareup.okio.AsyncTimeout
            protected void timedOut() {
                dc.squareup.okhttp3.RealCall.this.cancel();
            }
        };
        this.timeout = asyncTimeout;
        asyncTimeout.timeout(okHttpClient.callTimeoutMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    private void captureCallStackTrace() {
        this.retryAndFollowUpInterceptor.setCallStackTrace(dc.squareup.okhttp3.internal.platform.Platform.get().getStackTraceForCloseable("response.body().close()"));
    }

    static dc.squareup.okhttp3.RealCall newRealCall(dc.squareup.okhttp3.OkHttpClient okHttpClient, dc.squareup.okhttp3.Request request, boolean z) {
        dc.squareup.okhttp3.RealCall realCall = new dc.squareup.okhttp3.RealCall(okHttpClient, request, z);
        realCall.eventListener = okHttpClient.eventListenerFactory().create(realCall);
        return realCall;
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

    @Override // dc.squareup.okhttp3.Call
    public void cancel() {
        this.retryAndFollowUpInterceptor.cancel();
    }

    @Override // dc.squareup.okhttp3.Call
    public void enqueue(dc.squareup.okhttp3.Callback callback) {
        synchronized (this) {
            if (this.executed) {
                throw new java.lang.IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        captureCallStackTrace();
        this.eventListener.callStart(this);
        this.client.dispatcher().enqueue(new dc.squareup.okhttp3.RealCall.AsyncCall(callback));
    }

    @Override // dc.squareup.okhttp3.Call
    public dc.squareup.okhttp3.Response execute() throws java.io.IOException {
        synchronized (this) {
            if (this.executed) {
                throw new java.lang.IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        captureCallStackTrace();
        this.timeout.enter();
        this.eventListener.callStart(this);
        try {
            try {
                this.client.dispatcher().executed(this);
                dc.squareup.okhttp3.Response responseWithInterceptorChain = getResponseWithInterceptorChain();
                if (responseWithInterceptorChain == null) {
                    throw new java.io.IOException("Canceled");
                }
                this.client.dispatcher().finished(this);
                return responseWithInterceptorChain;
            } catch (java.io.IOException e) {
                java.io.IOException iOExceptionTimeoutExit = timeoutExit(e);
                this.eventListener.callFailed(this, iOExceptionTimeoutExit);
                throw iOExceptionTimeoutExit;
            }
        } catch (java.lang.Throwable th) {
            this.client.dispatcher().finished(this);
            throw th;
        }
        this.client.dispatcher().finished(this);
        throw th;
    }

    dc.squareup.okhttp3.Response getResponseWithInterceptorChain() throws java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(this.client.interceptors());
        arrayList.add(this.retryAndFollowUpInterceptor);
        arrayList.add(new dc.squareup.okhttp3.internal.http.BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new dc.squareup.okhttp3.internal.cache.CacheInterceptor(this.client.internalCache()));
        arrayList.add(new dc.squareup.okhttp3.internal.connection.ConnectInterceptor(this.client));
        if (!this.forWebSocket) {
            arrayList.addAll(this.client.networkInterceptors());
        }
        arrayList.add(new dc.squareup.okhttp3.internal.http.CallServerInterceptor(this.forWebSocket));
        dc.squareup.okhttp3.Response responseProceed = new dc.squareup.okhttp3.internal.http.RealInterceptorChain(arrayList, null, null, null, 0, this.originalRequest, this, this.eventListener, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
        if (!this.retryAndFollowUpInterceptor.isCanceled()) {
            return responseProceed;
        }
        dc.squareup.okhttp3.internal.Util.closeQuietly(responseProceed);
        throw new java.io.IOException("Canceled");
    }

    @Override // dc.squareup.okhttp3.Call
    public boolean isCanceled() {
        return this.retryAndFollowUpInterceptor.isCanceled();
    }

    @Override // dc.squareup.okhttp3.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    java.lang.String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    @Override // dc.squareup.okhttp3.Call
    public dc.squareup.okhttp3.Request request() {
        return this.originalRequest;
    }

    dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation() {
        return this.retryAndFollowUpInterceptor.streamAllocation();
    }

    @Override // dc.squareup.okhttp3.Call
    public dc.squareup.okio.Timeout timeout() {
        return this.timeout;
    }

    java.io.IOException timeoutExit(java.io.IOException iOException) {
        if (!this.timeout.exit()) {
            return iOException;
        }
        java.io.InterruptedIOException interruptedIOException = new java.io.InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    java.lang.String toLoggableString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : androidx.core.app.NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(redactedUrl());
        return sb.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    final class AsyncCall extends dc.squareup.okhttp3.internal.NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final dc.squareup.okhttp3.Callback responseCallback;

        AsyncCall(dc.squareup.okhttp3.Callback callback) {
            super("OkHttp %s", dc.squareup.okhttp3.RealCall.this.redactedUrl());
            this.responseCallback = callback;
        }

        @Override // dc.squareup.okhttp3.internal.NamedRunnable
        protected void execute() {
            dc.squareup.okhttp3.RealCall.this.timeout.enter();
            boolean z = false;
            try {
                try {
                    try {
                        this.responseCallback.onResponse(dc.squareup.okhttp3.RealCall.this, dc.squareup.okhttp3.RealCall.this.getResponseWithInterceptorChain());
                        dc.squareup.okhttp3.RealCall.this.client.dispatcher().finished(this);
                    } catch (java.io.IOException e) {
                        e = e;
                        z = true;
                        java.io.IOException iOExceptionTimeoutExit = dc.squareup.okhttp3.RealCall.this.timeoutExit(e);
                        if (z) {
                            dc.squareup.okhttp3.internal.platform.Platform.get().log(4, "Callback failure for " + dc.squareup.okhttp3.RealCall.this.toLoggableString(), iOExceptionTimeoutExit);
                        } else {
                            dc.squareup.okhttp3.RealCall.this.eventListener.callFailed(dc.squareup.okhttp3.RealCall.this, iOExceptionTimeoutExit);
                            this.responseCallback.onFailure(dc.squareup.okhttp3.RealCall.this, iOExceptionTimeoutExit);
                        }
                        dc.squareup.okhttp3.RealCall.this.client.dispatcher().finished(this);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        z = true;
                        dc.squareup.okhttp3.RealCall.this.cancel();
                        if (!z) {
                            this.responseCallback.onFailure(dc.squareup.okhttp3.RealCall.this, new java.io.IOException("canceled due to " + th));
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    dc.squareup.okhttp3.RealCall.this.client.dispatcher().finished(this);
                    throw th2;
                }
            } catch (java.io.IOException e2) {
                e = e2;
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        }

        dc.squareup.okhttp3.RealCall get() {
            return dc.squareup.okhttp3.RealCall.this;
        }

        java.lang.String host() {
            return dc.squareup.okhttp3.RealCall.this.originalRequest.url().host();
        }

        dc.squareup.okhttp3.Request request() {
            return dc.squareup.okhttp3.RealCall.this.originalRequest;
        }

        void executeOn(java.util.concurrent.ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (java.util.concurrent.RejectedExecutionException e) {
                    java.io.InterruptedIOException interruptedIOException = new java.io.InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    dc.squareup.okhttp3.RealCall.this.eventListener.callFailed(dc.squareup.okhttp3.RealCall.this, interruptedIOException);
                    this.responseCallback.onFailure(dc.squareup.okhttp3.RealCall.this, interruptedIOException);
                    dc.squareup.okhttp3.RealCall.this.client.dispatcher().finished(this);
                }
            } catch (java.lang.Throwable th) {
                dc.squareup.okhttp3.RealCall.this.client.dispatcher().finished(this);
                throw th;
            }
        }
    }

    @Override // dc.squareup.okhttp3.Call
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public dc.squareup.okhttp3.RealCall m404clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }
}
