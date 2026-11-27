package dc.squareup.okhttp3.internal.ws;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class RealWebSocket implements dc.squareup.okhttp3.WebSocket, dc.squareup.okhttp3.internal.ws.WebSocketReader.FrameCallback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final java.util.List<dc.squareup.okhttp3.Protocol> ONLY_HTTP1 = java.util.Collections.singletonList(dc.squareup.okhttp3.Protocol.HTTP_1_1);
    private boolean awaitingPong;
    private dc.squareup.okhttp3.Call call;
    private java.util.concurrent.ScheduledFuture<?> cancelFuture;
    private boolean enqueuedClose;
    private java.util.concurrent.ScheduledExecutorService executor;
    private boolean failed;
    private final java.lang.String key;
    final dc.squareup.okhttp3.WebSocketListener listener;
    private final dc.squareup.okhttp3.Request originalRequest;
    private final long pingIntervalMillis;
    private long queueSize;
    private final java.util.Random random;
    private dc.squareup.okhttp3.internal.ws.WebSocketReader reader;
    private java.lang.String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private dc.squareup.okhttp3.internal.ws.RealWebSocket.Streams streams;
    private dc.squareup.okhttp3.internal.ws.WebSocketWriter writer;
    private final java.lang.Runnable writerRunnable;
    private final java.util.ArrayDeque<dc.squareup.okio.ByteString> pongQueue = new java.util.ArrayDeque<>();
    private final java.util.ArrayDeque<java.lang.Object> messageAndCloseQueue = new java.util.ArrayDeque<>();
    private int receivedCloseCode = -1;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    final class CancelRunnable implements java.lang.Runnable {
        CancelRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            dc.squareup.okhttp3.internal.ws.RealWebSocket.this.cancel();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static final class Close {
        final long cancelAfterCloseMillis;
        final int code;
        final dc.squareup.okio.ByteString reason;

        Close(int i, dc.squareup.okio.ByteString byteString, long j) {
            this.code = i;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static final class Message {
        final dc.squareup.okio.ByteString data;
        final int formatOpcode;

        Message(int i, dc.squareup.okio.ByteString byteString) {
            this.formatOpcode = i;
            this.data = byteString;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private final class PingRunnable implements java.lang.Runnable {
        PingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            dc.squareup.okhttp3.internal.ws.RealWebSocket.this.writePingFrame();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static abstract class Streams implements java.io.Closeable {
        public final boolean client;
        public final dc.squareup.okio.BufferedSink sink;
        public final dc.squareup.okio.BufferedSource source;

        public Streams(boolean z, dc.squareup.okio.BufferedSource bufferedSource, dc.squareup.okio.BufferedSink bufferedSink) {
            this.client = z;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }
    }

    public RealWebSocket(dc.squareup.okhttp3.Request request, dc.squareup.okhttp3.WebSocketListener webSocketListener, java.util.Random random, long j) {
        if (!"GET".equals(request.method())) {
            throw new java.lang.IllegalArgumentException("Request must be GET: " + request.method());
        }
        this.originalRequest = request;
        this.listener = webSocketListener;
        this.random = random;
        this.pingIntervalMillis = j;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.key = dc.squareup.okio.ByteString.of(bArr).base64();
        this.writerRunnable = new java.lang.Runnable() { // from class: dc.squareup.okhttp3.internal.ws.RealWebSocket.1
            @Override // java.lang.Runnable
            public void run() {
                do {
                    try {
                    } catch (java.io.IOException e) {
                        dc.squareup.okhttp3.internal.ws.RealWebSocket.this.failWebSocket(e, null);
                        return;
                    }
                } while (dc.squareup.okhttp3.internal.ws.RealWebSocket.this.writeOneFrame());
            }
        };
    }

    void awaitTermination(int i, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        this.executor.awaitTermination(i, timeUnit);
    }

    @Override // dc.squareup.okhttp3.WebSocket
    public void cancel() {
        this.call.cancel();
    }

    void checkResponse(dc.squareup.okhttp3.Response response) throws java.net.ProtocolException {
        if (response.code() != 101) {
            throw new java.net.ProtocolException("Expected HTTP 101 response but was '" + response.code() + com.taobao.weex.el.parse.Operators.SPACE_STR + response.message() + "'");
        }
        java.lang.String strHeader = response.header("Connection");
        if (!"Upgrade".equalsIgnoreCase(strHeader)) {
            throw new java.net.ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strHeader + "'");
        }
        java.lang.String strHeader2 = response.header("Upgrade");
        if (!"websocket".equalsIgnoreCase(strHeader2)) {
            throw new java.net.ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strHeader2 + "'");
        }
        java.lang.String strHeader3 = response.header("Sec-WebSocket-Accept");
        java.lang.String strBase64 = dc.squareup.okio.ByteString.encodeUtf8(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
        if (strBase64.equals(strHeader3)) {
            return;
        }
        throw new java.net.ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strBase64 + "' but was '" + strHeader3 + "'");
    }

    @Override // dc.squareup.okhttp3.WebSocket
    public boolean close(int i, java.lang.String str) {
        return close(i, str, CANCEL_AFTER_CLOSE_MILLIS);
    }

    public void connect(dc.squareup.okhttp3.OkHttpClient okHttpClient) {
        dc.squareup.okhttp3.OkHttpClient okHttpClientBuild = okHttpClient.newBuilder().eventListener(dc.squareup.okhttp3.EventListener.NONE).protocols(ONLY_HTTP1).build();
        final dc.squareup.okhttp3.Request requestBuild = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
        dc.squareup.okhttp3.Call callNewWebSocketCall = dc.squareup.okhttp3.internal.Internal.instance.newWebSocketCall(okHttpClientBuild, requestBuild);
        this.call = callNewWebSocketCall;
        callNewWebSocketCall.timeout().clearTimeout();
        this.call.enqueue(new dc.squareup.okhttp3.Callback() { // from class: dc.squareup.okhttp3.internal.ws.RealWebSocket.2
            @Override // dc.squareup.okhttp3.Callback
            public void onFailure(dc.squareup.okhttp3.Call call, java.io.IOException iOException) {
                dc.squareup.okhttp3.internal.ws.RealWebSocket.this.failWebSocket(iOException, null);
            }

            @Override // dc.squareup.okhttp3.Callback
            public void onResponse(dc.squareup.okhttp3.Call call, dc.squareup.okhttp3.Response response) {
                try {
                    dc.squareup.okhttp3.internal.ws.RealWebSocket.this.checkResponse(response);
                    dc.squareup.okhttp3.internal.connection.StreamAllocation streamAllocation = dc.squareup.okhttp3.internal.Internal.instance.streamAllocation(call);
                    streamAllocation.noNewStreams();
                    dc.squareup.okhttp3.internal.ws.RealWebSocket.Streams streamsNewWebSocketStreams = streamAllocation.connection().newWebSocketStreams(streamAllocation);
                    try {
                        dc.squareup.okhttp3.internal.ws.RealWebSocket realWebSocket = dc.squareup.okhttp3.internal.ws.RealWebSocket.this;
                        realWebSocket.listener.onOpen(realWebSocket, response);
                        dc.squareup.okhttp3.internal.ws.RealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + requestBuild.url().redact(), streamsNewWebSocketStreams);
                        streamAllocation.connection().socket().setSoTimeout(0);
                        dc.squareup.okhttp3.internal.ws.RealWebSocket.this.loopReader();
                    } catch (java.lang.Exception e) {
                        dc.squareup.okhttp3.internal.ws.RealWebSocket.this.failWebSocket(e, null);
                    }
                } catch (java.net.ProtocolException e2) {
                    dc.squareup.okhttp3.internal.ws.RealWebSocket.this.failWebSocket(e2, response);
                    dc.squareup.okhttp3.internal.Util.closeQuietly(response);
                }
            }
        });
    }

    public void failWebSocket(java.lang.Exception exc, dc.squareup.okhttp3.Response response) {
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            dc.squareup.okhttp3.internal.ws.RealWebSocket.Streams streams = this.streams;
            this.streams = null;
            java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.cancelFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            java.util.concurrent.ScheduledExecutorService scheduledExecutorService = this.executor;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            try {
                this.listener.onFailure(this, exc, response);
            } finally {
                dc.squareup.okhttp3.internal.Util.closeQuietly(streams);
            }
        }
    }

    public void initReaderAndWriter(java.lang.String str, dc.squareup.okhttp3.internal.ws.RealWebSocket.Streams streams) throws java.io.IOException {
        synchronized (this) {
            this.streams = streams;
            this.writer = new dc.squareup.okhttp3.internal.ws.WebSocketWriter(streams.client, streams.sink, this.random);
            java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new java.util.concurrent.ScheduledThreadPoolExecutor(1, dc.squareup.okhttp3.internal.Util.threadFactory(str, false));
            this.executor = scheduledThreadPoolExecutor;
            if (this.pingIntervalMillis != 0) {
                dc.squareup.okhttp3.internal.ws.RealWebSocket.PingRunnable pingRunnable = new dc.squareup.okhttp3.internal.ws.RealWebSocket.PingRunnable();
                long j = this.pingIntervalMillis;
                scheduledThreadPoolExecutor.scheduleAtFixedRate(pingRunnable, j, j, java.util.concurrent.TimeUnit.MILLISECONDS);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
        }
        this.reader = new dc.squareup.okhttp3.internal.ws.WebSocketReader(streams.client, streams.source, this);
    }

    public void loopReader() throws java.io.IOException {
        while (this.receivedCloseCode == -1) {
            this.reader.processNextFrame();
        }
    }

    @Override // dc.squareup.okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i, java.lang.String str) {
        dc.squareup.okhttp3.internal.ws.RealWebSocket.Streams streams;
        if (i == -1) {
            throw new java.lang.IllegalArgumentException();
        }
        synchronized (this) {
            if (this.receivedCloseCode != -1) {
                throw new java.lang.IllegalStateException("already closed");
            }
            this.receivedCloseCode = i;
            this.receivedCloseReason = str;
            streams = null;
            if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                dc.squareup.okhttp3.internal.ws.RealWebSocket.Streams streams2 = this.streams;
                this.streams = null;
                java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.cancelFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.executor.shutdown();
                streams = streams2;
            }
        }
        try {
            this.listener.onClosing(this, i, str);
            if (streams != null) {
                this.listener.onClosed(this, i, str);
            }
        } finally {
            dc.squareup.okhttp3.internal.Util.closeQuietly(streams);
        }
    }

    @Override // dc.squareup.okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(java.lang.String str) throws java.io.IOException {
        this.listener.onMessage(this, str);
    }

    @Override // dc.squareup.okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(dc.squareup.okio.ByteString byteString) {
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(byteString);
            runWriter();
            this.receivedPingCount++;
        }
    }

    @Override // dc.squareup.okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(dc.squareup.okio.ByteString byteString) {
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    synchronized boolean pong(dc.squareup.okio.ByteString byteString) {
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(byteString);
            runWriter();
            return true;
        }
        return false;
    }

    boolean processNextFrame() throws java.io.IOException {
        try {
            this.reader.processNextFrame();
            return this.receivedCloseCode == -1;
        } catch (java.lang.Exception e) {
            failWebSocket(e, null);
            return false;
        }
    }

    @Override // dc.squareup.okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.queueSize;
    }

    synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @Override // dc.squareup.okhttp3.WebSocket
    public dc.squareup.okhttp3.Request request() {
        return this.originalRequest;
    }

    @Override // dc.squareup.okhttp3.WebSocket
    public boolean send(java.lang.String str) {
        if (str != null) {
            return send(dc.squareup.okio.ByteString.encodeUtf8(str), 1);
        }
        throw new java.lang.NullPointerException("text == null");
    }

    synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    void tearDown() throws java.lang.InterruptedException {
        java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.cancelFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.executor.shutdown();
        this.executor.awaitTermination(10L, java.util.concurrent.TimeUnit.SECONDS);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0055 A[Catch: all -> 0x00a8, TRY_ENTER, TryCatch #1 {all -> 0x00a8, blocks: (B:24:0x0055, B:25:0x0059, B:27:0x005d, B:28:0x0079, B:34:0x0088, B:35:0x0089, B:37:0x008d, B:39:0x0098, B:42:0x00a2, B:43:0x00a7, B:29:0x007a, B:30:0x0084), top: B:52:0x0053, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0059 A[Catch: all -> 0x00a8, TryCatch #1 {all -> 0x00a8, blocks: (B:24:0x0055, B:25:0x0059, B:27:0x005d, B:28:0x0079, B:34:0x0088, B:35:0x0089, B:37:0x008d, B:39:0x0098, B:42:0x00a2, B:43:0x00a7, B:29:0x007a, B:30:0x0084), top: B:52:0x0053, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x005d A[Catch: all -> 0x00a8, TryCatch #1 {all -> 0x00a8, blocks: (B:24:0x0055, B:25:0x0059, B:27:0x005d, B:28:0x0079, B:34:0x0088, B:35:0x0089, B:37:0x008d, B:39:0x0098, B:42:0x00a2, B:43:0x00a7, B:29:0x007a, B:30:0x0084), top: B:52:0x0053, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0089 A[Catch: all -> 0x00a8, TryCatch #1 {all -> 0x00a8, blocks: (B:24:0x0055, B:25:0x0059, B:27:0x005d, B:28:0x0079, B:34:0x0088, B:35:0x0089, B:37:0x008d, B:39:0x0098, B:42:0x00a2, B:43:0x00a7, B:29:0x007a, B:30:0x0084), top: B:52:0x0053, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x008d A[Catch: all -> 0x00a8, TryCatch #1 {all -> 0x00a8, blocks: (B:24:0x0055, B:25:0x0059, B:27:0x005d, B:28:0x0079, B:34:0x0088, B:35:0x0089, B:37:0x008d, B:39:0x0098, B:42:0x00a2, B:43:0x00a7, B:29:0x007a, B:30:0x0084), top: B:52:0x0053, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0098 A[Catch: all -> 0x00a8, TRY_LEAVE, TryCatch #1 {all -> 0x00a8, blocks: (B:24:0x0055, B:25:0x0059, B:27:0x005d, B:28:0x0079, B:34:0x0088, B:35:0x0089, B:37:0x008d, B:39:0x0098, B:42:0x00a2, B:43:0x00a7, B:29:0x007a, B:30:0x0084), top: B:52:0x0053, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00a2 A[Catch: all -> 0x00a8, TRY_ENTER, TryCatch #1 {all -> 0x00a8, blocks: (B:24:0x0055, B:25:0x0059, B:27:0x005d, B:28:0x0079, B:34:0x0088, B:35:0x0089, B:37:0x008d, B:39:0x0098, B:42:0x00a2, B:43:0x00a7, B:29:0x007a, B:30:0x0084), top: B:52:0x0053, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    boolean writeOneFrame() throws java.io.IOException {
        dc.squareup.okhttp3.internal.ws.RealWebSocket.Streams streams;
        java.lang.String str;
        int i;
        dc.squareup.okio.ByteString byteString;
        synchronized (this) {
            if (this.failed) {
                return false;
            }
            dc.squareup.okhttp3.internal.ws.WebSocketWriter webSocketWriter = this.writer;
            dc.squareup.okio.ByteString byteStringPoll = this.pongQueue.poll();
            java.lang.Object obj = null;
            try {
                if (byteStringPoll == null) {
                    java.lang.Object objPoll = this.messageAndCloseQueue.poll();
                    if (objPoll instanceof dc.squareup.okhttp3.internal.ws.RealWebSocket.Close) {
                        i = this.receivedCloseCode;
                        str = this.receivedCloseReason;
                        if (i != -1) {
                            streams = this.streams;
                            this.streams = null;
                            this.executor.shutdown();
                        } else {
                            this.cancelFuture = this.executor.schedule(new dc.squareup.okhttp3.internal.ws.RealWebSocket.CancelRunnable(), ((dc.squareup.okhttp3.internal.ws.RealWebSocket.Close) objPoll).cancelAfterCloseMillis, java.util.concurrent.TimeUnit.MILLISECONDS);
                            streams = null;
                        }
                        obj = objPoll;
                    } else {
                        if (objPoll == null) {
                            return false;
                        }
                        streams = null;
                        str = null;
                        obj = objPoll;
                    }
                    if (byteStringPoll != null) {
                        webSocketWriter.writePong(byteStringPoll);
                    } else if (obj instanceof dc.squareup.okhttp3.internal.ws.RealWebSocket.Message) {
                        byteString = ((dc.squareup.okhttp3.internal.ws.RealWebSocket.Message) obj).data;
                        dc.squareup.okio.BufferedSink bufferedSinkBuffer = dc.squareup.okio.Okio.buffer(webSocketWriter.newMessageSink(((dc.squareup.okhttp3.internal.ws.RealWebSocket.Message) obj).formatOpcode, byteString.size()));
                        bufferedSinkBuffer.write(byteString);
                        bufferedSinkBuffer.close();
                        synchronized (this) {
                            this.queueSize -= (long) byteString.size();
                        }
                    } else {
                        if (obj instanceof dc.squareup.okhttp3.internal.ws.RealWebSocket.Close) {
                            throw new java.lang.AssertionError();
                        }
                        dc.squareup.okhttp3.internal.ws.RealWebSocket.Close close = (dc.squareup.okhttp3.internal.ws.RealWebSocket.Close) obj;
                        webSocketWriter.writeClose(close.code, close.reason);
                        if (streams != null) {
                            this.listener.onClosed(this, i, str);
                        }
                    }
                    dc.squareup.okhttp3.internal.Util.closeQuietly(streams);
                    return true;
                }
                streams = null;
                str = null;
                if (byteStringPoll != null) {
                    webSocketWriter.writePong(byteStringPoll);
                } else if (obj instanceof dc.squareup.okhttp3.internal.ws.RealWebSocket.Message) {
                    byteString = ((dc.squareup.okhttp3.internal.ws.RealWebSocket.Message) obj).data;
                    dc.squareup.okio.BufferedSink bufferedSinkBuffer2 = dc.squareup.okio.Okio.buffer(webSocketWriter.newMessageSink(((dc.squareup.okhttp3.internal.ws.RealWebSocket.Message) obj).formatOpcode, byteString.size()));
                    bufferedSinkBuffer2.write(byteString);
                    bufferedSinkBuffer2.close();
                    synchronized (this) {
                        this.queueSize -= (long) byteString.size();
                    }
                } else {
                    if (obj instanceof dc.squareup.okhttp3.internal.ws.RealWebSocket.Close) {
                        throw new java.lang.AssertionError();
                    }
                    dc.squareup.okhttp3.internal.ws.RealWebSocket.Close close2 = (dc.squareup.okhttp3.internal.ws.RealWebSocket.Close) obj;
                    webSocketWriter.writeClose(close2.code, close2.reason);
                    if (streams != null) {
                        this.listener.onClosed(this, i, str);
                    }
                }
                dc.squareup.okhttp3.internal.Util.closeQuietly(streams);
                return true;
            } catch (java.lang.Throwable th) {
                dc.squareup.okhttp3.internal.Util.closeQuietly(streams);
                throw th;
            }
            i = -1;
        }
    }

    void writePingFrame() {
        synchronized (this) {
            if (this.failed) {
                return;
            }
            dc.squareup.okhttp3.internal.ws.WebSocketWriter webSocketWriter = this.writer;
            int i = this.awaitingPong ? this.sentPingCount : -1;
            this.sentPingCount++;
            this.awaitingPong = true;
            if (i == -1) {
                try {
                    webSocketWriter.writePing(dc.squareup.okio.ByteString.EMPTY);
                    return;
                } catch (java.io.IOException e) {
                    failWebSocket(e, null);
                    return;
                }
            }
            failWebSocket(new java.net.SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
        }
    }

    synchronized boolean close(int i, java.lang.String str, long j) {
        dc.squareup.okio.ByteString byteStringEncodeUtf8;
        dc.squareup.okhttp3.internal.ws.WebSocketProtocol.validateCloseCode(i);
        if (str != null) {
            byteStringEncodeUtf8 = dc.squareup.okio.ByteString.encodeUtf8(str);
            if (byteStringEncodeUtf8.size() > 123) {
                throw new java.lang.IllegalArgumentException("reason.size() > 123: " + str);
            }
        } else {
            byteStringEncodeUtf8 = null;
        }
        if (!this.failed && !this.enqueuedClose) {
            this.enqueuedClose = true;
            this.messageAndCloseQueue.add(new dc.squareup.okhttp3.internal.ws.RealWebSocket.Close(i, byteStringEncodeUtf8, j));
            runWriter();
            return true;
        }
        return false;
    }

    @Override // dc.squareup.okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(dc.squareup.okio.ByteString byteString) throws java.io.IOException {
        this.listener.onMessage(this, byteString);
    }

    private void runWriter() {
        java.util.concurrent.ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.writerRunnable);
        }
    }

    @Override // dc.squareup.okhttp3.WebSocket
    public boolean send(dc.squareup.okio.ByteString byteString) {
        if (byteString != null) {
            return send(byteString, 2);
        }
        throw new java.lang.NullPointerException("bytes == null");
    }

    private synchronized boolean send(dc.squareup.okio.ByteString byteString, int i) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + ((long) byteString.size()) > MAX_QUEUE_SIZE) {
                close(1001, null);
                return false;
            }
            this.queueSize += (long) byteString.size();
            this.messageAndCloseQueue.add(new dc.squareup.okhttp3.internal.ws.RealWebSocket.Message(i, byteString));
            runWriter();
            return true;
        }
        return false;
    }
}
