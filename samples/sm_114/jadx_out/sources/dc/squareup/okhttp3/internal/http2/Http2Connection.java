package dc.squareup.okhttp3.internal.http2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Http2Connection implements java.io.Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int AWAIT_PING = 3;
    static final int DEGRADED_PING = 2;
    static final long DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    static final int INTERVAL_PING = 1;
    static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private static final java.util.concurrent.ExecutorService listenerExecutor = new java.util.concurrent.ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), dc.squareup.okhttp3.internal.Util.threadFactory("OkHttp Http2Connection", true));
    long bytesLeftInWriteWindow;
    final boolean client;
    final java.util.Set<java.lang.Integer> currentPushRequests;
    final java.lang.String hostname;
    int lastGoodStreamId;
    final dc.squareup.okhttp3.internal.http2.Http2Connection.Listener listener;
    int nextStreamId;
    final dc.squareup.okhttp3.internal.http2.Settings peerSettings;
    private final java.util.concurrent.ExecutorService pushExecutor;
    final dc.squareup.okhttp3.internal.http2.PushObserver pushObserver;
    final dc.squareup.okhttp3.internal.http2.Http2Connection.ReaderRunnable readerRunnable;
    private boolean shutdown;
    final java.net.Socket socket;
    final dc.squareup.okhttp3.internal.http2.Http2Writer writer;
    private final java.util.concurrent.ScheduledExecutorService writerExecutor;
    final java.util.Map<java.lang.Integer, dc.squareup.okhttp3.internal.http2.Http2Stream> streams = new java.util.LinkedHashMap();
    private long intervalPingsSent = 0;
    private long intervalPongsReceived = 0;
    private long degradedPingsSent = 0;
    private long degradedPongsReceived = 0;
    private long awaitPingsSent = 0;
    private long awaitPongsReceived = 0;
    private long degradedPongDeadlineNs = 0;
    long unacknowledgedBytesRead = 0;
    dc.squareup.okhttp3.internal.http2.Settings okHttpSettings = new dc.squareup.okhttp3.internal.http2.Settings();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    final class IntervalPingRunnable extends dc.squareup.okhttp3.internal.NamedRunnable {
        IntervalPingRunnable() {
            super("OkHttp %s ping", dc.squareup.okhttp3.internal.http2.Http2Connection.this.hostname);
        }

        @Override // dc.squareup.okhttp3.internal.NamedRunnable
        public void execute() {
            boolean z;
            synchronized (dc.squareup.okhttp3.internal.http2.Http2Connection.this) {
                if (dc.squareup.okhttp3.internal.http2.Http2Connection.this.intervalPongsReceived < dc.squareup.okhttp3.internal.http2.Http2Connection.this.intervalPingsSent) {
                    z = true;
                } else {
                    dc.squareup.okhttp3.internal.http2.Http2Connection.access$208(dc.squareup.okhttp3.internal.http2.Http2Connection.this);
                    z = false;
                }
            }
            if (z) {
                dc.squareup.okhttp3.internal.http2.Http2Connection.this.failConnection();
            } else {
                dc.squareup.okhttp3.internal.http2.Http2Connection.this.writePing(false, 1, 0);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static abstract class Listener {
        public static final dc.squareup.okhttp3.internal.http2.Http2Connection.Listener REFUSE_INCOMING_STREAMS = new dc.squareup.okhttp3.internal.http2.Http2Connection.Listener() { // from class: dc.squareup.okhttp3.internal.http2.Http2Connection.Listener.1
            @Override // dc.squareup.okhttp3.internal.http2.Http2Connection.Listener
            public void onStream(dc.squareup.okhttp3.internal.http2.Http2Stream http2Stream) throws java.io.IOException {
                http2Stream.close(dc.squareup.okhttp3.internal.http2.ErrorCode.REFUSED_STREAM);
            }
        };

        public void onSettings(dc.squareup.okhttp3.internal.http2.Http2Connection http2Connection) {
        }

        public abstract void onStream(dc.squareup.okhttp3.internal.http2.Http2Stream http2Stream) throws java.io.IOException;
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    final class PingRunnable extends dc.squareup.okhttp3.internal.NamedRunnable {
        final int payload1;
        final int payload2;
        final boolean reply;

        PingRunnable(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", dc.squareup.okhttp3.internal.http2.Http2Connection.this.hostname, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
            this.reply = z;
            this.payload1 = i;
            this.payload2 = i2;
        }

        @Override // dc.squareup.okhttp3.internal.NamedRunnable
        public void execute() {
            dc.squareup.okhttp3.internal.http2.Http2Connection.this.writePing(this.reply, this.payload1, this.payload2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class ReaderRunnable extends dc.squareup.okhttp3.internal.NamedRunnable implements dc.squareup.okhttp3.internal.http2.Http2Reader.Handler {
        final dc.squareup.okhttp3.internal.http2.Http2Reader reader;

        ReaderRunnable(dc.squareup.okhttp3.internal.http2.Http2Reader http2Reader) {
            super("OkHttp %s", dc.squareup.okhttp3.internal.http2.Http2Connection.this.hostname);
            this.reader = http2Reader;
        }

        @Override // dc.squareup.okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // dc.squareup.okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i, java.lang.String str, dc.squareup.okio.ByteString byteString, java.lang.String str2, int i2, long j) {
        }

        void applyAndAckSettings(boolean z, dc.squareup.okhttp3.internal.http2.Settings settings) {
            dc.squareup.okhttp3.internal.http2.Http2Stream[] http2StreamArr;
            long j;
            synchronized (dc.squareup.okhttp3.internal.http2.Http2Connection.this.writer) {
                synchronized (dc.squareup.okhttp3.internal.http2.Http2Connection.this) {
                    int initialWindowSize = dc.squareup.okhttp3.internal.http2.Http2Connection.this.peerSettings.getInitialWindowSize();
                    if (z) {
                        dc.squareup.okhttp3.internal.http2.Http2Connection.this.peerSettings.clear();
                    }
                    dc.squareup.okhttp3.internal.http2.Http2Connection.this.peerSettings.merge(settings);
                    int initialWindowSize2 = dc.squareup.okhttp3.internal.http2.Http2Connection.this.peerSettings.getInitialWindowSize();
                    http2StreamArr = null;
                    if (initialWindowSize2 == -1 || initialWindowSize2 == initialWindowSize) {
                        j = 0;
                    } else {
                        j = initialWindowSize2 - initialWindowSize;
                        if (!dc.squareup.okhttp3.internal.http2.Http2Connection.this.streams.isEmpty()) {
                            http2StreamArr = (dc.squareup.okhttp3.internal.http2.Http2Stream[]) dc.squareup.okhttp3.internal.http2.Http2Connection.this.streams.values().toArray(new dc.squareup.okhttp3.internal.http2.Http2Stream[dc.squareup.okhttp3.internal.http2.Http2Connection.this.streams.size()]);
                        }
                    }
                }
                try {
                    dc.squareup.okhttp3.internal.http2.Http2Connection http2Connection = dc.squareup.okhttp3.internal.http2.Http2Connection.this;
                    http2Connection.writer.applyAndAckSettings(http2Connection.peerSettings);
                } catch (java.io.IOException unused) {
                    dc.squareup.okhttp3.internal.http2.Http2Connection.this.failConnection();
                }
            }
            if (http2StreamArr != null) {
                for (dc.squareup.okhttp3.internal.http2.Http2Stream http2Stream : http2StreamArr) {
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(j);
                    }
                }
            }
            dc.squareup.okhttp3.internal.http2.Http2Connection.listenerExecutor.execute(new dc.squareup.okhttp3.internal.NamedRunnable("OkHttp %s settings", dc.squareup.okhttp3.internal.http2.Http2Connection.this.hostname) { // from class: dc.squareup.okhttp3.internal.http2.Http2Connection.ReaderRunnable.3
                @Override // dc.squareup.okhttp3.internal.NamedRunnable
                public void execute() {
                    dc.squareup.okhttp3.internal.http2.Http2Connection http2Connection2 = dc.squareup.okhttp3.internal.http2.Http2Connection.this;
                    http2Connection2.listener.onSettings(http2Connection2);
                }
            });
        }

        @Override // dc.squareup.okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z, int i, dc.squareup.okio.BufferedSource bufferedSource, int i2) throws java.io.IOException {
            if (dc.squareup.okhttp3.internal.http2.Http2Connection.this.pushedStream(i)) {
                dc.squareup.okhttp3.internal.http2.Http2Connection.this.pushDataLater(i, bufferedSource, i2, z);
                return;
            }
            dc.squareup.okhttp3.internal.http2.Http2Stream stream = dc.squareup.okhttp3.internal.http2.Http2Connection.this.getStream(i);
            if (stream == null) {
                dc.squareup.okhttp3.internal.http2.Http2Connection.this.writeSynResetLater(i, dc.squareup.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR);
                long j = i2;
                dc.squareup.okhttp3.internal.http2.Http2Connection.this.updateConnectionFlowControl(j);
                bufferedSource.skip(j);
                return;
            }
            stream.receiveData(bufferedSource, i2);
            if (z) {
                stream.receiveFin();
            }
        }

        @Override // dc.squareup.okhttp3.internal.NamedRunnable
        protected void execute() throws java.lang.Throwable {
            java.lang.Throwable th;
            dc.squareup.okhttp3.internal.http2.ErrorCode errorCode;
            dc.squareup.okhttp3.internal.http2.ErrorCode errorCode2 = dc.squareup.okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    this.reader.readConnectionPreface(this);
                    while (this.reader.nextFrame(false, this)) {
                    }
                    errorCode = dc.squareup.okhttp3.internal.http2.ErrorCode.NO_ERROR;
                    try {
                        try {
                            dc.squareup.okhttp3.internal.http2.Http2Connection.this.close(errorCode, dc.squareup.okhttp3.internal.http2.ErrorCode.CANCEL);
                        } catch (java.io.IOException unused) {
                            dc.squareup.okhttp3.internal.http2.ErrorCode errorCode3 = dc.squareup.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
                            dc.squareup.okhttp3.internal.http2.Http2Connection.this.close(errorCode3, errorCode3);
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        try {
                            dc.squareup.okhttp3.internal.http2.Http2Connection.this.close(errorCode, errorCode2);
                        } catch (java.io.IOException unused2) {
                        }
                        dc.squareup.okhttp3.internal.Util.closeQuietly(this.reader);
                        throw th;
                    }
                } catch (java.io.IOException unused3) {
                }
            } catch (java.io.IOException unused4) {
                errorCode = errorCode2;
            } catch (java.lang.Throwable th3) {
                th = th3;
                errorCode = errorCode2;
                dc.squareup.okhttp3.internal.http2.Http2Connection.this.close(errorCode, errorCode2);
                dc.squareup.okhttp3.internal.Util.closeQuietly(this.reader);
                throw th;
            }
            dc.squareup.okhttp3.internal.Util.closeQuietly(this.reader);
        }

        @Override // dc.squareup.okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i, dc.squareup.okhttp3.internal.http2.ErrorCode errorCode, dc.squareup.okio.ByteString byteString) {
            dc.squareup.okhttp3.internal.http2.Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (dc.squareup.okhttp3.internal.http2.Http2Connection.this) {
                http2StreamArr = (dc.squareup.okhttp3.internal.http2.Http2Stream[]) dc.squareup.okhttp3.internal.http2.Http2Connection.this.streams.values().toArray(new dc.squareup.okhttp3.internal.http2.Http2Stream[dc.squareup.okhttp3.internal.http2.Http2Connection.this.streams.size()]);
                dc.squareup.okhttp3.internal.http2.Http2Connection.this.shutdown = true;
            }
            for (dc.squareup.okhttp3.internal.http2.Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(dc.squareup.okhttp3.internal.http2.ErrorCode.REFUSED_STREAM);
                    dc.squareup.okhttp3.internal.http2.Http2Connection.this.removeStream(http2Stream.getId());
                }
            }
        }

        @Override // dc.squareup.okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean z, int i, int i2, java.util.List<dc.squareup.okhttp3.internal.http2.Header> list) {
            if (dc.squareup.okhttp3.internal.http2.Http2Connection.this.pushedStream(i)) {
                dc.squareup.okhttp3.internal.http2.Http2Connection.this.pushHeadersLater(i, list, z);
                return;
            }
            synchronized (dc.squareup.okhttp3.internal.http2.Http2Connection.this) {
                dc.squareup.okhttp3.internal.http2.Http2Stream stream = dc.squareup.okhttp3.internal.http2.Http2Connection.this.getStream(i);
                if (stream != null) {
                    stream.receiveHeaders(list);
                    if (z) {
                        stream.receiveFin();
                        return;
                    }
                    return;
                }
                if (dc.squareup.okhttp3.internal.http2.Http2Connection.this.shutdown) {
                    return;
                }
                dc.squareup.okhttp3.internal.http2.Http2Connection http2Connection = dc.squareup.okhttp3.internal.http2.Http2Connection.this;
                if (i <= http2Connection.lastGoodStreamId) {
                    return;
                }
                if (i % 2 == http2Connection.nextStreamId % 2) {
                    return;
                }
                final dc.squareup.okhttp3.internal.http2.Http2Stream http2Stream = new dc.squareup.okhttp3.internal.http2.Http2Stream(i, dc.squareup.okhttp3.internal.http2.Http2Connection.this, false, z, dc.squareup.okhttp3.internal.Util.toHeaders(list));
                dc.squareup.okhttp3.internal.http2.Http2Connection http2Connection2 = dc.squareup.okhttp3.internal.http2.Http2Connection.this;
                http2Connection2.lastGoodStreamId = i;
                http2Connection2.streams.put(java.lang.Integer.valueOf(i), http2Stream);
                dc.squareup.okhttp3.internal.http2.Http2Connection.listenerExecutor.execute(new dc.squareup.okhttp3.internal.NamedRunnable("OkHttp %s stream %d", new java.lang.Object[]{dc.squareup.okhttp3.internal.http2.Http2Connection.this.hostname, java.lang.Integer.valueOf(i)}) { // from class: dc.squareup.okhttp3.internal.http2.Http2Connection.ReaderRunnable.1
                    @Override // dc.squareup.okhttp3.internal.NamedRunnable
                    public void execute() {
                        try {
                            dc.squareup.okhttp3.internal.http2.Http2Connection.this.listener.onStream(http2Stream);
                        } catch (java.io.IOException e) {
                            dc.squareup.okhttp3.internal.platform.Platform.get().log(4, "Http2Connection.Listener failure for " + dc.squareup.okhttp3.internal.http2.Http2Connection.this.hostname, e);
                            try {
                                http2Stream.close(dc.squareup.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR);
                            } catch (java.io.IOException unused) {
                            }
                        }
                    }
                });
            }
        }

        @Override // dc.squareup.okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z, int i, int i2) {
            if (!z) {
                try {
                    dc.squareup.okhttp3.internal.http2.Http2Connection.this.writerExecutor.execute(dc.squareup.okhttp3.internal.http2.Http2Connection.this.new PingRunnable(true, i, i2));
                    return;
                } catch (java.util.concurrent.RejectedExecutionException unused) {
                    return;
                }
            }
            synchronized (dc.squareup.okhttp3.internal.http2.Http2Connection.this) {
                try {
                    if (i == 1) {
                        dc.squareup.okhttp3.internal.http2.Http2Connection.access$108(dc.squareup.okhttp3.internal.http2.Http2Connection.this);
                    } else if (i == 2) {
                        dc.squareup.okhttp3.internal.http2.Http2Connection.access$608(dc.squareup.okhttp3.internal.http2.Http2Connection.this);
                    } else if (i == 3) {
                        dc.squareup.okhttp3.internal.http2.Http2Connection.access$708(dc.squareup.okhttp3.internal.http2.Http2Connection.this);
                        dc.squareup.okhttp3.internal.http2.Http2Connection.this.notifyAll();
                    }
                } catch (java.lang.Throwable th) {
                    throw th;
                }
            }
        }

        @Override // dc.squareup.okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i, int i2, int i3, boolean z) {
        }

        @Override // dc.squareup.okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i, int i2, java.util.List<dc.squareup.okhttp3.internal.http2.Header> list) throws java.lang.Throwable {
            dc.squareup.okhttp3.internal.http2.Http2Connection.this.pushRequestLater(i2, list);
        }

        @Override // dc.squareup.okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i, dc.squareup.okhttp3.internal.http2.ErrorCode errorCode) {
            if (dc.squareup.okhttp3.internal.http2.Http2Connection.this.pushedStream(i)) {
                dc.squareup.okhttp3.internal.http2.Http2Connection.this.pushResetLater(i, errorCode);
                return;
            }
            dc.squareup.okhttp3.internal.http2.Http2Stream http2StreamRemoveStream = dc.squareup.okhttp3.internal.http2.Http2Connection.this.removeStream(i);
            if (http2StreamRemoveStream != null) {
                http2StreamRemoveStream.receiveRstStream(errorCode);
            }
        }

        @Override // dc.squareup.okhttp3.internal.http2.Http2Reader.Handler
        public void settings(final boolean z, final dc.squareup.okhttp3.internal.http2.Settings settings) {
            try {
                dc.squareup.okhttp3.internal.http2.Http2Connection.this.writerExecutor.execute(new dc.squareup.okhttp3.internal.NamedRunnable("OkHttp %s ACK Settings", new java.lang.Object[]{dc.squareup.okhttp3.internal.http2.Http2Connection.this.hostname}) { // from class: dc.squareup.okhttp3.internal.http2.Http2Connection.ReaderRunnable.2
                    @Override // dc.squareup.okhttp3.internal.NamedRunnable
                    public void execute() {
                        dc.squareup.okhttp3.internal.http2.Http2Connection.ReaderRunnable.this.applyAndAckSettings(z, settings);
                    }
                });
            } catch (java.util.concurrent.RejectedExecutionException unused) {
            }
        }

        @Override // dc.squareup.okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i, long j) {
            if (i == 0) {
                synchronized (dc.squareup.okhttp3.internal.http2.Http2Connection.this) {
                    dc.squareup.okhttp3.internal.http2.Http2Connection http2Connection = dc.squareup.okhttp3.internal.http2.Http2Connection.this;
                    http2Connection.bytesLeftInWriteWindow += j;
                    http2Connection.notifyAll();
                }
                return;
            }
            dc.squareup.okhttp3.internal.http2.Http2Stream stream = dc.squareup.okhttp3.internal.http2.Http2Connection.this.getStream(i);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j);
                }
            }
        }
    }

    Http2Connection(dc.squareup.okhttp3.internal.http2.Http2Connection.Builder builder) {
        dc.squareup.okhttp3.internal.http2.Settings settings = new dc.squareup.okhttp3.internal.http2.Settings();
        this.peerSettings = settings;
        this.currentPushRequests = new java.util.LinkedHashSet();
        this.pushObserver = builder.pushObserver;
        boolean z = builder.client;
        this.client = z;
        this.listener = builder.listener;
        int i = z ? 1 : 2;
        this.nextStreamId = i;
        if (z) {
            this.nextStreamId = i + 2;
        }
        if (z) {
            this.okHttpSettings.set(7, 16777216);
        }
        java.lang.String str = builder.hostname;
        this.hostname = str;
        java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new java.util.concurrent.ScheduledThreadPoolExecutor(1, dc.squareup.okhttp3.internal.Util.threadFactory(dc.squareup.okhttp3.internal.Util.format("OkHttp %s Writer", str), false));
        this.writerExecutor = scheduledThreadPoolExecutor;
        if (builder.pingIntervalMillis != 0) {
            dc.squareup.okhttp3.internal.http2.Http2Connection.IntervalPingRunnable intervalPingRunnable = new dc.squareup.okhttp3.internal.http2.Http2Connection.IntervalPingRunnable();
            long j = builder.pingIntervalMillis;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(intervalPingRunnable, j, j, java.util.concurrent.TimeUnit.MILLISECONDS);
        }
        this.pushExecutor = new java.util.concurrent.ThreadPoolExecutor(0, 1, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), dc.squareup.okhttp3.internal.Util.threadFactory(dc.squareup.okhttp3.internal.Util.format("OkHttp %s Push Observer", str), true));
        settings.set(7, 65535);
        settings.set(5, 16384);
        this.bytesLeftInWriteWindow = settings.getInitialWindowSize();
        this.socket = builder.socket;
        this.writer = new dc.squareup.okhttp3.internal.http2.Http2Writer(builder.sink, z);
        this.readerRunnable = new dc.squareup.okhttp3.internal.http2.Http2Connection.ReaderRunnable(new dc.squareup.okhttp3.internal.http2.Http2Reader(builder.source, z));
    }

    static /* synthetic */ long access$108(dc.squareup.okhttp3.internal.http2.Http2Connection http2Connection) {
        long j = http2Connection.intervalPongsReceived;
        http2Connection.intervalPongsReceived = 1 + j;
        return j;
    }

    static /* synthetic */ long access$208(dc.squareup.okhttp3.internal.http2.Http2Connection http2Connection) {
        long j = http2Connection.intervalPingsSent;
        http2Connection.intervalPingsSent = 1 + j;
        return j;
    }

    static /* synthetic */ long access$608(dc.squareup.okhttp3.internal.http2.Http2Connection http2Connection) {
        long j = http2Connection.degradedPongsReceived;
        http2Connection.degradedPongsReceived = 1 + j;
        return j;
    }

    static /* synthetic */ long access$708(dc.squareup.okhttp3.internal.http2.Http2Connection http2Connection) {
        long j = http2Connection.awaitPongsReceived;
        http2Connection.awaitPongsReceived = 1 + j;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failConnection() {
        try {
            dc.squareup.okhttp3.internal.http2.ErrorCode errorCode = dc.squareup.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;
            close(errorCode, errorCode);
        } catch (java.io.IOException unused) {
        }
    }

    private synchronized void pushExecutorExecute(dc.squareup.okhttp3.internal.NamedRunnable namedRunnable) {
        if (this.shutdown) {
            return;
        }
        this.pushExecutor.execute(namedRunnable);
    }

    synchronized void awaitPong() throws java.lang.InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            wait();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        close(dc.squareup.okhttp3.internal.http2.ErrorCode.NO_ERROR, dc.squareup.okhttp3.internal.http2.ErrorCode.CANCEL);
    }

    public void flush() throws java.io.IOException {
        this.writer.flush();
    }

    public dc.squareup.okhttp3.Protocol getProtocol() {
        return dc.squareup.okhttp3.Protocol.HTTP_2;
    }

    synchronized dc.squareup.okhttp3.internal.http2.Http2Stream getStream(int i) {
        return this.streams.get(java.lang.Integer.valueOf(i));
    }

    public synchronized boolean isHealthy(long j) {
        if (this.shutdown) {
            return false;
        }
        return this.degradedPongsReceived >= this.degradedPingsSent || j < this.degradedPongDeadlineNs;
    }

    public synchronized int maxConcurrentStreams() {
        return this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);
    }

    public dc.squareup.okhttp3.internal.http2.Http2Stream newStream(java.util.List<dc.squareup.okhttp3.internal.http2.Header> list, boolean z) throws java.io.IOException {
        return newStream(0, list, z);
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    void pushDataLater(final int i, dc.squareup.okio.BufferedSource bufferedSource, final int i2, final boolean z) throws java.io.IOException {
        final dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
        long j = i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() == j) {
            pushExecutorExecute(new dc.squareup.okhttp3.internal.NamedRunnable("OkHttp %s Push Data[%s]", new java.lang.Object[]{this.hostname, java.lang.Integer.valueOf(i)}) { // from class: dc.squareup.okhttp3.internal.http2.Http2Connection.6
                @Override // dc.squareup.okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        boolean zOnData = dc.squareup.okhttp3.internal.http2.Http2Connection.this.pushObserver.onData(i, buffer, i2, z);
                        if (zOnData) {
                            dc.squareup.okhttp3.internal.http2.Http2Connection.this.writer.rstStream(i, dc.squareup.okhttp3.internal.http2.ErrorCode.CANCEL);
                        }
                        if (zOnData || z) {
                            synchronized (dc.squareup.okhttp3.internal.http2.Http2Connection.this) {
                                dc.squareup.okhttp3.internal.http2.Http2Connection.this.currentPushRequests.remove(java.lang.Integer.valueOf(i));
                            }
                        }
                    } catch (java.io.IOException unused) {
                    }
                }
            });
            return;
        }
        throw new java.io.IOException(buffer.size() + " != " + i2);
    }

    void pushHeadersLater(final int i, final java.util.List<dc.squareup.okhttp3.internal.http2.Header> list, final boolean z) {
        try {
            try {
                pushExecutorExecute(new dc.squareup.okhttp3.internal.NamedRunnable("OkHttp %s Push Headers[%s]", new java.lang.Object[]{this.hostname, java.lang.Integer.valueOf(i)}) { // from class: dc.squareup.okhttp3.internal.http2.Http2Connection.5
                    @Override // dc.squareup.okhttp3.internal.NamedRunnable
                    public void execute() {
                        boolean zOnHeaders = dc.squareup.okhttp3.internal.http2.Http2Connection.this.pushObserver.onHeaders(i, list, z);
                        if (zOnHeaders) {
                            try {
                                dc.squareup.okhttp3.internal.http2.Http2Connection.this.writer.rstStream(i, dc.squareup.okhttp3.internal.http2.ErrorCode.CANCEL);
                            } catch (java.io.IOException unused) {
                                return;
                            }
                        }
                        if (zOnHeaders || z) {
                            synchronized (dc.squareup.okhttp3.internal.http2.Http2Connection.this) {
                                try {
                                    dc.squareup.okhttp3.internal.http2.Http2Connection.this.currentPushRequests.remove(java.lang.Integer.valueOf(i));
                                } catch (java.lang.Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    }
                });
            } catch (java.util.concurrent.RejectedExecutionException unused) {
            }
        } catch (java.util.concurrent.RejectedExecutionException unused2) {
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:23:0x0046
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    void pushRequestLater(final int r9, final java.util.List<dc.squareup.okhttp3.internal.http2.Header> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.Set<java.lang.Integer> r0 = r8.currentPushRequests     // Catch: java.lang.Throwable -> L41
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L41
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L18
            dc.squareup.okhttp3.internal.http2.ErrorCode r10 = dc.squareup.okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch: java.lang.Throwable -> L14
            r8.writeSynResetLater(r9, r10)     // Catch: java.lang.Throwable -> L14
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L14
            return
        L14:
            r0 = move-exception
            r9 = r0
            r3 = r8
            goto L44
        L18:
            java.util.Set<java.lang.Integer> r0 = r8.currentPushRequests     // Catch: java.lang.Throwable -> L41
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L41
            r0.add(r1)     // Catch: java.lang.Throwable -> L41
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L41
            dc.squareup.okhttp3.internal.http2.Http2Connection$4 r2 = new dc.squareup.okhttp3.internal.http2.Http2Connection$4     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            java.lang.String r4 = "OkHttp %s Push Request[%s]"
            java.lang.String r0 = r8.hostname     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            r3 = 2
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            r3 = 0
            r5[r3] = r0     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            r0 = 1
            r5[r0] = r1     // Catch: java.util.concurrent.RejectedExecutionException -> L3f
            r3 = r8
            r6 = r9
            r7 = r10
            r2.<init>(r4, r5)     // Catch: java.util.concurrent.RejectedExecutionException -> L40
            r8.pushExecutorExecute(r2)     // Catch: java.util.concurrent.RejectedExecutionException -> L40
            return
        L3f:
            r3 = r8
        L40:
            return
        L41:
            r0 = move-exception
            r3 = r8
        L43:
            r9 = r0
        L44:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L46
            throw r9
        L46:
            r0 = move-exception
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.squareup.okhttp3.internal.http2.Http2Connection.pushRequestLater(int, java.util.List):void");
    }

    void pushResetLater(final int i, final dc.squareup.okhttp3.internal.http2.ErrorCode errorCode) {
        pushExecutorExecute(new dc.squareup.okhttp3.internal.NamedRunnable("OkHttp %s Push Reset[%s]", new java.lang.Object[]{this.hostname, java.lang.Integer.valueOf(i)}) { // from class: dc.squareup.okhttp3.internal.http2.Http2Connection.7
            @Override // dc.squareup.okhttp3.internal.NamedRunnable
            public void execute() {
                dc.squareup.okhttp3.internal.http2.Http2Connection.this.pushObserver.onReset(i, errorCode);
                synchronized (dc.squareup.okhttp3.internal.http2.Http2Connection.this) {
                    dc.squareup.okhttp3.internal.http2.Http2Connection.this.currentPushRequests.remove(java.lang.Integer.valueOf(i));
                }
            }
        });
    }

    public dc.squareup.okhttp3.internal.http2.Http2Stream pushStream(int i, java.util.List<dc.squareup.okhttp3.internal.http2.Header> list, boolean z) throws java.io.IOException {
        if (this.client) {
            throw new java.lang.IllegalStateException("Client cannot push requests.");
        }
        return newStream(i, list, z);
    }

    boolean pushedStream(int i) {
        return i != 0 && (i & 1) == 0;
    }

    synchronized dc.squareup.okhttp3.internal.http2.Http2Stream removeStream(int i) {
        dc.squareup.okhttp3.internal.http2.Http2Stream http2StreamRemove;
        http2StreamRemove = this.streams.remove(java.lang.Integer.valueOf(i));
        notifyAll();
        return http2StreamRemove;
    }

    void sendDegradedPingLater() {
        synchronized (this) {
            long j = this.degradedPongsReceived;
            long j2 = this.degradedPingsSent;
            if (j < j2) {
                return;
            }
            this.degradedPingsSent = j2 + 1;
            this.degradedPongDeadlineNs = java.lang.System.nanoTime() + DEGRADED_PONG_TIMEOUT_NS;
            try {
                this.writerExecutor.execute(new dc.squareup.okhttp3.internal.NamedRunnable("OkHttp %s ping", this.hostname) { // from class: dc.squareup.okhttp3.internal.http2.Http2Connection.3
                    @Override // dc.squareup.okhttp3.internal.NamedRunnable
                    public void execute() {
                        dc.squareup.okhttp3.internal.http2.Http2Connection.this.writePing(false, 2, 0);
                    }
                });
            } catch (java.util.concurrent.RejectedExecutionException unused) {
            }
        }
    }

    public void setSettings(dc.squareup.okhttp3.internal.http2.Settings settings) throws java.io.IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (this.shutdown) {
                    throw new dc.squareup.okhttp3.internal.http2.ConnectionShutdownException();
                }
                this.okHttpSettings.merge(settings);
            }
            this.writer.settings(settings);
        }
    }

    public void shutdown(dc.squareup.okhttp3.internal.http2.ErrorCode errorCode) throws java.io.IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (this.shutdown) {
                    return;
                }
                this.shutdown = true;
                this.writer.goAway(this.lastGoodStreamId, errorCode, dc.squareup.okhttp3.internal.Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public void start() throws java.io.IOException {
        start(true);
    }

    synchronized void updateConnectionFlowControl(long j) {
        long j2 = this.unacknowledgedBytesRead + j;
        this.unacknowledgedBytesRead = j2;
        if (j2 >= this.okHttpSettings.getInitialWindowSize() / 2) {
            writeWindowUpdateLater(0, this.unacknowledgedBytesRead);
            this.unacknowledgedBytesRead = 0L;
        }
    }

    public void writeData(int i, boolean z, dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
        long j2;
        int iMin;
        long j3;
        if (j == 0) {
            this.writer.data(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        j2 = this.bytesLeftInWriteWindow;
                        if (j2 <= 0) {
                            if (!this.streams.containsKey(java.lang.Integer.valueOf(i))) {
                                throw new java.io.IOException("stream closed");
                            }
                            wait();
                        }
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                        throw new java.io.InterruptedIOException();
                    }
                }
                iMin = java.lang.Math.min((int) java.lang.Math.min(j, j2), this.writer.maxDataLength());
                j3 = iMin;
                this.bytesLeftInWriteWindow -= j3;
            }
            j -= j3;
            this.writer.data(z && j == 0, i, buffer, iMin);
        }
    }

    void writePing(boolean z, int i, int i2) {
        try {
            this.writer.ping(z, i, i2);
        } catch (java.io.IOException unused) {
            failConnection();
        }
    }

    void writePingAndAwaitPong() throws java.lang.InterruptedException {
        writePing();
        awaitPong();
    }

    void writeSynReply(int i, boolean z, java.util.List<dc.squareup.okhttp3.internal.http2.Header> list) throws java.io.IOException {
        this.writer.synReply(z, i, list);
    }

    void writeSynReset(int i, dc.squareup.okhttp3.internal.http2.ErrorCode errorCode) throws java.io.IOException {
        this.writer.rstStream(i, errorCode);
    }

    void writeSynResetLater(final int i, final dc.squareup.okhttp3.internal.http2.ErrorCode errorCode) {
        try {
            this.writerExecutor.execute(new dc.squareup.okhttp3.internal.NamedRunnable("OkHttp %s stream %d", new java.lang.Object[]{this.hostname, java.lang.Integer.valueOf(i)}) { // from class: dc.squareup.okhttp3.internal.http2.Http2Connection.1
                @Override // dc.squareup.okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        dc.squareup.okhttp3.internal.http2.Http2Connection.this.writeSynReset(i, errorCode);
                    } catch (java.io.IOException unused) {
                        dc.squareup.okhttp3.internal.http2.Http2Connection.this.failConnection();
                    }
                }
            });
        } catch (java.util.concurrent.RejectedExecutionException unused) {
        }
    }

    void writeWindowUpdateLater(final int i, final long j) {
        try {
            this.writerExecutor.execute(new dc.squareup.okhttp3.internal.NamedRunnable("OkHttp Window Update %s stream %d", new java.lang.Object[]{this.hostname, java.lang.Integer.valueOf(i)}) { // from class: dc.squareup.okhttp3.internal.http2.Http2Connection.2
                @Override // dc.squareup.okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        dc.squareup.okhttp3.internal.http2.Http2Connection.this.writer.windowUpdate(i, j);
                    } catch (java.io.IOException unused) {
                        dc.squareup.okhttp3.internal.http2.Http2Connection.this.failConnection();
                    }
                }
            });
        } catch (java.util.concurrent.RejectedExecutionException unused) {
        }
    }

    private dc.squareup.okhttp3.internal.http2.Http2Stream newStream(int i, java.util.List<dc.squareup.okhttp3.internal.http2.Header> list, boolean z) throws java.lang.Throwable {
        java.lang.Throwable th;
        boolean z2 = !z;
        synchronized (this.writer) {
            try {
                try {
                    try {
                        synchronized (this) {
                            try {
                                if (this.nextStreamId > 1073741823) {
                                    try {
                                        shutdown(dc.squareup.okhttp3.internal.http2.ErrorCode.REFUSED_STREAM);
                                    } catch (java.lang.Throwable th2) {
                                        th = th2;
                                    }
                                }
                                if (this.shutdown) {
                                    throw new dc.squareup.okhttp3.internal.http2.ConnectionShutdownException();
                                }
                                int i2 = this.nextStreamId;
                                this.nextStreamId = i2 + 2;
                                dc.squareup.okhttp3.internal.http2.Http2Stream http2Stream = new dc.squareup.okhttp3.internal.http2.Http2Stream(i2, this, z2, false, null);
                                boolean z3 = !z || this.bytesLeftInWriteWindow == 0 || http2Stream.bytesLeftInWriteWindow == 0;
                                if (http2Stream.isOpen()) {
                                    this.streams.put(java.lang.Integer.valueOf(i2), http2Stream);
                                }
                                if (i == 0) {
                                    this.writer.synStream(z2, i2, i, list);
                                } else {
                                    if (this.client) {
                                        throw new java.lang.IllegalArgumentException("client streams shouldn't have associated stream IDs");
                                    }
                                    this.writer.pushPromise(i, i2, list);
                                }
                                if (z3) {
                                    this.writer.flush();
                                }
                                return http2Stream;
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                th = th;
                            }
                            throw th;
                        }
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        throw th;
                    }
                } catch (java.lang.Throwable th5) {
                    th = th5;
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
                throw th;
            }
        }
    }

    void start(boolean z) throws java.io.IOException {
        if (z) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int initialWindowSize = this.okHttpSettings.getInitialWindowSize();
            if (initialWindowSize != 65535) {
                this.writer.windowUpdate(0, initialWindowSize - 65535);
            }
        }
        new java.lang.Thread(this.readerRunnable).start();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class Builder {
        boolean client;
        java.lang.String hostname;
        int pingIntervalMillis;
        dc.squareup.okio.BufferedSink sink;
        java.net.Socket socket;
        dc.squareup.okio.BufferedSource source;
        dc.squareup.okhttp3.internal.http2.Http2Connection.Listener listener = dc.squareup.okhttp3.internal.http2.Http2Connection.Listener.REFUSE_INCOMING_STREAMS;
        dc.squareup.okhttp3.internal.http2.PushObserver pushObserver = dc.squareup.okhttp3.internal.http2.PushObserver.CANCEL;

        public Builder(boolean z) {
            this.client = z;
        }

        public dc.squareup.okhttp3.internal.http2.Http2Connection build() {
            return new dc.squareup.okhttp3.internal.http2.Http2Connection(this);
        }

        public dc.squareup.okhttp3.internal.http2.Http2Connection.Builder listener(dc.squareup.okhttp3.internal.http2.Http2Connection.Listener listener) {
            this.listener = listener;
            return this;
        }

        public dc.squareup.okhttp3.internal.http2.Http2Connection.Builder pingIntervalMillis(int i) {
            this.pingIntervalMillis = i;
            return this;
        }

        public dc.squareup.okhttp3.internal.http2.Http2Connection.Builder pushObserver(dc.squareup.okhttp3.internal.http2.PushObserver pushObserver) {
            this.pushObserver = pushObserver;
            return this;
        }

        public dc.squareup.okhttp3.internal.http2.Http2Connection.Builder socket(java.net.Socket socket) throws java.io.IOException {
            return socket(socket, ((java.net.InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), dc.squareup.okio.Okio.buffer(dc.squareup.okio.Okio.source(socket)), dc.squareup.okio.Okio.buffer(dc.squareup.okio.Okio.sink(socket)));
        }

        public dc.squareup.okhttp3.internal.http2.Http2Connection.Builder socket(java.net.Socket socket, java.lang.String str, dc.squareup.okio.BufferedSource bufferedSource, dc.squareup.okio.BufferedSink bufferedSink) {
            this.socket = socket;
            this.hostname = str;
            this.source = bufferedSource;
            this.sink = bufferedSink;
            return this;
        }
    }

    void writePing() {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }

    void close(dc.squareup.okhttp3.internal.http2.ErrorCode errorCode, dc.squareup.okhttp3.internal.http2.ErrorCode errorCode2) throws java.io.IOException {
        dc.squareup.okhttp3.internal.http2.Http2Stream[] http2StreamArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (java.io.IOException e) {
            e = e;
        }
        synchronized (this) {
            if (!this.streams.isEmpty()) {
                http2StreamArr = (dc.squareup.okhttp3.internal.http2.Http2Stream[]) this.streams.values().toArray(new dc.squareup.okhttp3.internal.http2.Http2Stream[this.streams.size()]);
                this.streams.clear();
            }
        }
        if (http2StreamArr != null) {
            for (dc.squareup.okhttp3.internal.http2.Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(errorCode2);
                } catch (java.io.IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        try {
            this.writer.close();
        } catch (java.io.IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.socket.close();
        } catch (java.io.IOException e4) {
            e = e4;
        }
        this.writerExecutor.shutdown();
        this.pushExecutor.shutdown();
        if (e != null) {
            throw e;
        }
    }
}
