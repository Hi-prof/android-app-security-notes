package dc.squareup.okhttp3.internal.http2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Http2Stream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesLeftInWriteWindow;
    final dc.squareup.okhttp3.internal.http2.Http2Connection connection;
    dc.squareup.okhttp3.internal.http2.ErrorCode errorCode;
    private boolean hasResponseHeaders;
    private dc.squareup.okhttp3.internal.http2.Header.Listener headersListener;
    private final java.util.Deque<dc.squareup.okhttp3.Headers> headersQueue;
    final int id;
    final dc.squareup.okhttp3.internal.http2.Http2Stream.StreamTimeout readTimeout;
    final dc.squareup.okhttp3.internal.http2.Http2Stream.FramingSink sink;
    private final dc.squareup.okhttp3.internal.http2.Http2Stream.FramingSource source;
    long unacknowledgedBytesRead = 0;
    final dc.squareup.okhttp3.internal.http2.Http2Stream.StreamTimeout writeTimeout;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    final class FramingSink implements dc.squareup.okio.Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        boolean closed;
        boolean finished;
        private final dc.squareup.okio.Buffer sendBuffer = new dc.squareup.okio.Buffer();

        FramingSink() {
        }

        private void emitFrame(boolean z) throws java.io.IOException {
            dc.squareup.okhttp3.internal.http2.Http2Stream http2Stream;
            long jMin;
            dc.squareup.okhttp3.internal.http2.Http2Stream http2Stream2;
            synchronized (dc.squareup.okhttp3.internal.http2.Http2Stream.this) {
                dc.squareup.okhttp3.internal.http2.Http2Stream.this.writeTimeout.enter();
                while (true) {
                    try {
                        http2Stream = dc.squareup.okhttp3.internal.http2.Http2Stream.this;
                        if (http2Stream.bytesLeftInWriteWindow > 0 || this.finished || this.closed || http2Stream.errorCode != null) {
                            break;
                        } else {
                            http2Stream.waitForIo();
                        }
                    } catch (java.lang.Throwable th) {
                        dc.squareup.okhttp3.internal.http2.Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
                http2Stream.writeTimeout.exitAndThrowIfTimedOut();
                dc.squareup.okhttp3.internal.http2.Http2Stream.this.checkOutNotClosed();
                jMin = java.lang.Math.min(dc.squareup.okhttp3.internal.http2.Http2Stream.this.bytesLeftInWriteWindow, this.sendBuffer.size());
                http2Stream2 = dc.squareup.okhttp3.internal.http2.Http2Stream.this;
                http2Stream2.bytesLeftInWriteWindow -= jMin;
            }
            http2Stream2.writeTimeout.enter();
            try {
                dc.squareup.okhttp3.internal.http2.Http2Stream http2Stream3 = dc.squareup.okhttp3.internal.http2.Http2Stream.this;
                http2Stream3.connection.writeData(http2Stream3.id, z && jMin == this.sendBuffer.size(), this.sendBuffer, jMin);
            } finally {
                dc.squareup.okhttp3.internal.http2.Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
            }
        }

        @Override // dc.squareup.okio.Sink
        public dc.squareup.okio.Timeout timeout() {
            return dc.squareup.okhttp3.internal.http2.Http2Stream.this.writeTimeout;
        }

        @Override // dc.squareup.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            synchronized (dc.squareup.okhttp3.internal.http2.Http2Stream.this) {
                if (this.closed) {
                    return;
                }
                if (!dc.squareup.okhttp3.internal.http2.Http2Stream.this.sink.finished) {
                    if (this.sendBuffer.size() > 0) {
                        while (this.sendBuffer.size() > 0) {
                            emitFrame(true);
                        }
                    } else {
                        dc.squareup.okhttp3.internal.http2.Http2Stream http2Stream = dc.squareup.okhttp3.internal.http2.Http2Stream.this;
                        http2Stream.connection.writeData(http2Stream.id, true, null, 0L);
                    }
                }
                synchronized (dc.squareup.okhttp3.internal.http2.Http2Stream.this) {
                    this.closed = true;
                }
                dc.squareup.okhttp3.internal.http2.Http2Stream.this.connection.flush();
                dc.squareup.okhttp3.internal.http2.Http2Stream.this.cancelStreamIfNecessary();
            }
        }

        @Override // dc.squareup.okio.Sink, java.io.Flushable
        public void flush() throws java.io.IOException {
            synchronized (dc.squareup.okhttp3.internal.http2.Http2Stream.this) {
                dc.squareup.okhttp3.internal.http2.Http2Stream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.size() > 0) {
                emitFrame(false);
                dc.squareup.okhttp3.internal.http2.Http2Stream.this.connection.flush();
            }
        }

        @Override // dc.squareup.okio.Sink
        public void write(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
            this.sendBuffer.write(buffer, j);
            while (this.sendBuffer.size() >= 16384) {
                emitFrame(false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private final class FramingSource implements dc.squareup.okio.Source {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        boolean closed;
        boolean finished;
        private final long maxByteCount;
        private final dc.squareup.okio.Buffer receiveBuffer = new dc.squareup.okio.Buffer();
        private final dc.squareup.okio.Buffer readBuffer = new dc.squareup.okio.Buffer();

        FramingSource(long j) {
            this.maxByteCount = j;
        }

        @Override // dc.squareup.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            long size;
            java.util.ArrayList arrayList;
            dc.squareup.okhttp3.internal.http2.Header.Listener listener;
            synchronized (dc.squareup.okhttp3.internal.http2.Http2Stream.this) {
                this.closed = true;
                size = this.readBuffer.size();
                this.readBuffer.clear();
                if (dc.squareup.okhttp3.internal.http2.Http2Stream.this.headersQueue.isEmpty() || dc.squareup.okhttp3.internal.http2.Http2Stream.this.headersListener == null) {
                    arrayList = null;
                    listener = null;
                } else {
                    arrayList = new java.util.ArrayList(dc.squareup.okhttp3.internal.http2.Http2Stream.this.headersQueue);
                    dc.squareup.okhttp3.internal.http2.Http2Stream.this.headersQueue.clear();
                    listener = dc.squareup.okhttp3.internal.http2.Http2Stream.this.headersListener;
                }
                dc.squareup.okhttp3.internal.http2.Http2Stream.this.notifyAll();
            }
            if (size > 0) {
                updateConnectionFlowControl(size);
            }
            dc.squareup.okhttp3.internal.http2.Http2Stream.this.cancelStreamIfNecessary();
            if (listener != null) {
                int size2 = arrayList.size();
                int i = 0;
                while (i < size2) {
                    java.lang.Object obj = arrayList.get(i);
                    i++;
                    listener.onHeaders((dc.squareup.okhttp3.Headers) obj);
                }
            }
        }

        @Override // dc.squareup.okio.Source
        public long read(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
            long j2;
            long j3;
            dc.squareup.okhttp3.internal.http2.Header.Listener listener;
            dc.squareup.okhttp3.Headers headers;
            if (j < 0) {
                throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
            }
            while (true) {
                synchronized (dc.squareup.okhttp3.internal.http2.Http2Stream.this) {
                    dc.squareup.okhttp3.internal.http2.Http2Stream.this.readTimeout.enter();
                    try {
                        dc.squareup.okhttp3.internal.http2.Http2Stream http2Stream = dc.squareup.okhttp3.internal.http2.Http2Stream.this;
                        dc.squareup.okhttp3.internal.http2.ErrorCode errorCode = http2Stream.errorCode;
                        if (errorCode == null) {
                            errorCode = null;
                        }
                        if (this.closed) {
                            throw new java.io.IOException("stream closed");
                        }
                        if (http2Stream.headersQueue.isEmpty() || dc.squareup.okhttp3.internal.http2.Http2Stream.this.headersListener == null) {
                            if (this.readBuffer.size() > 0) {
                                dc.squareup.okio.Buffer buffer2 = this.readBuffer;
                                j2 = buffer2.read(buffer, java.lang.Math.min(j, buffer2.size()));
                                dc.squareup.okhttp3.internal.http2.Http2Stream http2Stream2 = dc.squareup.okhttp3.internal.http2.Http2Stream.this;
                                long j4 = http2Stream2.unacknowledgedBytesRead + j2;
                                http2Stream2.unacknowledgedBytesRead = j4;
                                if (errorCode == null) {
                                    j3 = -1;
                                    if (j4 >= http2Stream2.connection.okHttpSettings.getInitialWindowSize() / 2) {
                                        dc.squareup.okhttp3.internal.http2.Http2Stream http2Stream3 = dc.squareup.okhttp3.internal.http2.Http2Stream.this;
                                        http2Stream3.connection.writeWindowUpdateLater(http2Stream3.id, http2Stream3.unacknowledgedBytesRead);
                                        dc.squareup.okhttp3.internal.http2.Http2Stream.this.unacknowledgedBytesRead = 0L;
                                    }
                                } else {
                                    j3 = -1;
                                }
                            } else {
                                j3 = -1;
                                if (this.finished || errorCode != null) {
                                    j2 = -1;
                                } else {
                                    dc.squareup.okhttp3.internal.http2.Http2Stream.this.waitForIo();
                                    dc.squareup.okhttp3.internal.http2.Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                                }
                            }
                            listener = null;
                            headers = null;
                        } else {
                            headers = (dc.squareup.okhttp3.Headers) dc.squareup.okhttp3.internal.http2.Http2Stream.this.headersQueue.removeFirst();
                            listener = dc.squareup.okhttp3.internal.http2.Http2Stream.this.headersListener;
                            j2 = -1;
                            j3 = -1;
                        }
                        dc.squareup.okhttp3.internal.http2.Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                        if (headers == null || listener == null) {
                            if (j2 != j3) {
                                updateConnectionFlowControl(j2);
                                return j2;
                            }
                            if (errorCode == null) {
                                return j3;
                            }
                            throw new dc.squareup.okhttp3.internal.http2.StreamResetException(errorCode);
                        }
                        listener.onHeaders(headers);
                    } catch (java.lang.Throwable th) {
                        dc.squareup.okhttp3.internal.http2.Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
            }
        }

        @Override // dc.squareup.okio.Source
        public dc.squareup.okio.Timeout timeout() {
            return dc.squareup.okhttp3.internal.http2.Http2Stream.this.readTimeout;
        }

        private void updateConnectionFlowControl(long j) {
            dc.squareup.okhttp3.internal.http2.Http2Stream.this.connection.updateConnectionFlowControl(j);
        }

        void receive(dc.squareup.okio.BufferedSource bufferedSource, long j) throws java.io.IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long size;
            while (j > 0) {
                synchronized (dc.squareup.okhttp3.internal.http2.Http2Stream.this) {
                    z = this.finished;
                    z2 = true;
                    z3 = this.readBuffer.size() + j > this.maxByteCount;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    dc.squareup.okhttp3.internal.http2.Http2Stream.this.closeLater(dc.squareup.okhttp3.internal.http2.ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    bufferedSource.skip(j);
                    return;
                }
                long j2 = bufferedSource.read(this.receiveBuffer, j);
                if (j2 != -1) {
                    j -= j2;
                    synchronized (dc.squareup.okhttp3.internal.http2.Http2Stream.this) {
                        if (this.closed) {
                            size = this.receiveBuffer.size();
                            this.receiveBuffer.clear();
                        } else {
                            if (this.readBuffer.size() != 0) {
                                z2 = false;
                            }
                            this.readBuffer.writeAll(this.receiveBuffer);
                            if (z2) {
                                dc.squareup.okhttp3.internal.http2.Http2Stream.this.notifyAll();
                            }
                            size = 0;
                        }
                    }
                    if (size > 0) {
                        updateConnectionFlowControl(size);
                    }
                } else {
                    throw new java.io.EOFException();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class StreamTimeout extends dc.squareup.okio.AsyncTimeout {
        StreamTimeout() {
        }

        public void exitAndThrowIfTimedOut() throws java.io.IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // dc.squareup.okio.AsyncTimeout
        protected java.io.IOException newTimeoutException(java.io.IOException iOException) {
            java.net.SocketTimeoutException socketTimeoutException = new java.net.SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // dc.squareup.okio.AsyncTimeout
        protected void timedOut() {
            dc.squareup.okhttp3.internal.http2.Http2Stream.this.closeLater(dc.squareup.okhttp3.internal.http2.ErrorCode.CANCEL);
            dc.squareup.okhttp3.internal.http2.Http2Stream.this.connection.sendDegradedPingLater();
        }
    }

    Http2Stream(int i, dc.squareup.okhttp3.internal.http2.Http2Connection http2Connection, boolean z, boolean z2, dc.squareup.okhttp3.Headers headers) {
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
        this.headersQueue = arrayDeque;
        this.readTimeout = new dc.squareup.okhttp3.internal.http2.Http2Stream.StreamTimeout();
        this.writeTimeout = new dc.squareup.okhttp3.internal.http2.Http2Stream.StreamTimeout();
        this.errorCode = null;
        if (http2Connection == null) {
            throw new java.lang.NullPointerException("connection == null");
        }
        this.id = i;
        this.connection = http2Connection;
        this.bytesLeftInWriteWindow = http2Connection.peerSettings.getInitialWindowSize();
        dc.squareup.okhttp3.internal.http2.Http2Stream.FramingSource framingSource = new dc.squareup.okhttp3.internal.http2.Http2Stream.FramingSource(http2Connection.okHttpSettings.getInitialWindowSize());
        this.source = framingSource;
        dc.squareup.okhttp3.internal.http2.Http2Stream.FramingSink framingSink = new dc.squareup.okhttp3.internal.http2.Http2Stream.FramingSink();
        this.sink = framingSink;
        framingSource.finished = z2;
        framingSink.finished = z;
        if (headers != null) {
            arrayDeque.add(headers);
        }
        if (isLocallyInitiated() && headers != null) {
            throw new java.lang.IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!isLocallyInitiated() && headers == null) {
            throw new java.lang.IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void checkOutNotClosed() throws java.io.IOException {
        dc.squareup.okhttp3.internal.http2.Http2Stream.FramingSink framingSink = this.sink;
        if (framingSink.closed) {
            throw new java.io.IOException("stream closed");
        }
        if (framingSink.finished) {
            throw new java.io.IOException("stream finished");
        }
        if (this.errorCode != null) {
            throw new dc.squareup.okhttp3.internal.http2.StreamResetException(this.errorCode);
        }
    }

    public void close(dc.squareup.okhttp3.internal.http2.ErrorCode errorCode) throws java.io.IOException {
        if (closeInternal(errorCode)) {
            this.connection.writeSynReset(this.id, errorCode);
        }
    }

    public void closeLater(dc.squareup.okhttp3.internal.http2.ErrorCode errorCode) {
        if (closeInternal(errorCode)) {
            this.connection.writeSynResetLater(this.id, errorCode);
        }
    }

    public dc.squareup.okhttp3.internal.http2.Http2Connection getConnection() {
        return this.connection;
    }

    public synchronized dc.squareup.okhttp3.internal.http2.ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public int getId() {
        return this.id;
    }

    public dc.squareup.okio.Sink getSink() {
        synchronized (this) {
            if (!this.hasResponseHeaders && !isLocallyInitiated()) {
                throw new java.lang.IllegalStateException("reply before requesting the sink");
            }
        }
        return this.sink;
    }

    public dc.squareup.okio.Source getSource() {
        return this.source;
    }

    public boolean isLocallyInitiated() {
        return this.connection.client == ((this.id & 1) == 1);
    }

    public synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        dc.squareup.okhttp3.internal.http2.Http2Stream.FramingSource framingSource = this.source;
        if (framingSource.finished || framingSource.closed) {
            dc.squareup.okhttp3.internal.http2.Http2Stream.FramingSink framingSink = this.sink;
            if ((framingSink.finished || framingSink.closed) && this.hasResponseHeaders) {
                return false;
            }
        }
        return true;
    }

    public dc.squareup.okio.Timeout readTimeout() {
        return this.readTimeout;
    }

    synchronized void receiveRstStream(dc.squareup.okhttp3.internal.http2.ErrorCode errorCode) {
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    public synchronized void setHeadersListener(dc.squareup.okhttp3.internal.http2.Header.Listener listener) {
        this.headersListener = listener;
        if (this.headersQueue.isEmpty() || listener == null) {
            return;
        }
        notifyAll();
    }

    public synchronized dc.squareup.okhttp3.Headers takeHeaders() throws java.io.IOException {
        this.readTimeout.enter();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            try {
                waitForIo();
            } catch (java.lang.Throwable th) {
                this.readTimeout.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (this.headersQueue.isEmpty()) {
            throw new dc.squareup.okhttp3.internal.http2.StreamResetException(this.errorCode);
        }
        return this.headersQueue.removeFirst();
    }

    void waitForIo() throws java.io.InterruptedIOException {
        try {
            wait();
        } catch (java.lang.InterruptedException unused) {
            java.lang.Thread.currentThread().interrupt();
            throw new java.io.InterruptedIOException();
        }
    }

    public dc.squareup.okio.Timeout writeTimeout() {
        return this.writeTimeout;
    }

    private boolean closeInternal(dc.squareup.okhttp3.internal.http2.ErrorCode errorCode) {
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.finished && this.sink.finished) {
                return false;
            }
            this.errorCode = errorCode;
            notifyAll();
            this.connection.removeStream(this.id);
            return true;
        }
    }

    void receiveData(dc.squareup.okio.BufferedSource bufferedSource, int i) throws java.io.IOException {
        this.source.receive(bufferedSource, i);
    }

    void receiveFin() {
        boolean zIsOpen;
        synchronized (this) {
            this.source.finished = true;
            zIsOpen = isOpen();
            notifyAll();
        }
        if (zIsOpen) {
            return;
        }
        this.connection.removeStream(this.id);
    }

    void receiveHeaders(java.util.List<dc.squareup.okhttp3.internal.http2.Header> list) {
        boolean zIsOpen;
        synchronized (this) {
            this.hasResponseHeaders = true;
            this.headersQueue.add(dc.squareup.okhttp3.internal.Util.toHeaders(list));
            zIsOpen = isOpen();
            notifyAll();
        }
        if (zIsOpen) {
            return;
        }
        this.connection.removeStream(this.id);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0017  */
    void cancelStreamIfNecessary() throws java.io.IOException {
        boolean z;
        boolean zIsOpen;
        synchronized (this) {
            dc.squareup.okhttp3.internal.http2.Http2Stream.FramingSource framingSource = this.source;
            if (framingSource.finished || !framingSource.closed) {
                z = false;
            } else {
                dc.squareup.okhttp3.internal.http2.Http2Stream.FramingSink framingSink = this.sink;
                if (framingSink.finished || framingSink.closed) {
                    z = true;
                } else {
                    z = false;
                }
            }
            zIsOpen = isOpen();
        }
        if (z) {
            close(dc.squareup.okhttp3.internal.http2.ErrorCode.CANCEL);
        } else {
            if (zIsOpen) {
                return;
            }
            this.connection.removeStream(this.id);
        }
    }

    public void writeHeaders(java.util.List<dc.squareup.okhttp3.internal.http2.Header> list, boolean z) throws java.io.IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        if (list != null) {
            synchronized (this) {
                z2 = true;
                this.hasResponseHeaders = true;
                if (z) {
                    z3 = false;
                    z4 = false;
                } else {
                    this.sink.finished = true;
                    z3 = true;
                    z4 = true;
                }
            }
            if (!z3) {
                synchronized (this.connection) {
                    if (this.connection.bytesLeftInWriteWindow != 0) {
                        z2 = false;
                    }
                }
                z3 = z2;
            }
            this.connection.writeSynReply(this.id, z4, list);
            if (z3) {
                this.connection.flush();
                return;
            }
            return;
        }
        throw new java.lang.NullPointerException("headers == null");
    }
}
