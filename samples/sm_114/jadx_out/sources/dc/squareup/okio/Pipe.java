package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Pipe {
    private dc.squareup.okio.Sink foldedSink;
    final long maxBufferSize;
    boolean sinkClosed;
    boolean sourceClosed;
    final dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
    private final dc.squareup.okio.Sink sink = new dc.squareup.okio.Pipe.PipeSink();
    private final dc.squareup.okio.Source source = new dc.squareup.okio.Pipe.PipeSource();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    final class PipeSink implements dc.squareup.okio.Sink {
        final dc.squareup.okio.PushableTimeout timeout = new dc.squareup.okio.PushableTimeout();

        PipeSink() {
        }

        @Override // dc.squareup.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            dc.squareup.okio.Sink sink;
            synchronized (dc.squareup.okio.Pipe.this.buffer) {
                dc.squareup.okio.Pipe pipe = dc.squareup.okio.Pipe.this;
                if (pipe.sinkClosed) {
                    return;
                }
                if (pipe.foldedSink != null) {
                    sink = dc.squareup.okio.Pipe.this.foldedSink;
                } else {
                    dc.squareup.okio.Pipe pipe2 = dc.squareup.okio.Pipe.this;
                    if (pipe2.sourceClosed && pipe2.buffer.size() > 0) {
                        throw new java.io.IOException("source is closed");
                    }
                    dc.squareup.okio.Pipe pipe3 = dc.squareup.okio.Pipe.this;
                    pipe3.sinkClosed = true;
                    pipe3.buffer.notifyAll();
                    sink = null;
                }
                if (sink != null) {
                    this.timeout.push(sink.timeout());
                    try {
                        sink.close();
                    } finally {
                        this.timeout.pop();
                    }
                }
            }
        }

        @Override // dc.squareup.okio.Sink, java.io.Flushable
        public void flush() throws java.io.IOException {
            dc.squareup.okio.Sink sink;
            synchronized (dc.squareup.okio.Pipe.this.buffer) {
                dc.squareup.okio.Pipe pipe = dc.squareup.okio.Pipe.this;
                if (pipe.sinkClosed) {
                    throw new java.lang.IllegalStateException("closed");
                }
                if (pipe.foldedSink != null) {
                    sink = dc.squareup.okio.Pipe.this.foldedSink;
                } else {
                    dc.squareup.okio.Pipe pipe2 = dc.squareup.okio.Pipe.this;
                    if (pipe2.sourceClosed && pipe2.buffer.size() > 0) {
                        throw new java.io.IOException("source is closed");
                    }
                    sink = null;
                }
            }
            if (sink != null) {
                this.timeout.push(sink.timeout());
                try {
                    sink.flush();
                } finally {
                    this.timeout.pop();
                }
            }
        }

        @Override // dc.squareup.okio.Sink
        public dc.squareup.okio.Timeout timeout() {
            return this.timeout;
        }

        @Override // dc.squareup.okio.Sink
        public void write(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
            dc.squareup.okio.Sink sink;
            synchronized (dc.squareup.okio.Pipe.this.buffer) {
                if (!dc.squareup.okio.Pipe.this.sinkClosed) {
                    while (true) {
                        if (j <= 0) {
                            sink = null;
                            break;
                        }
                        if (dc.squareup.okio.Pipe.this.foldedSink != null) {
                            sink = dc.squareup.okio.Pipe.this.foldedSink;
                            break;
                        }
                        dc.squareup.okio.Pipe pipe = dc.squareup.okio.Pipe.this;
                        if (pipe.sourceClosed) {
                            throw new java.io.IOException("source is closed");
                        }
                        long size = pipe.maxBufferSize - pipe.buffer.size();
                        if (size == 0) {
                            this.timeout.waitUntilNotified(dc.squareup.okio.Pipe.this.buffer);
                        } else {
                            long jMin = java.lang.Math.min(size, j);
                            dc.squareup.okio.Pipe.this.buffer.write(buffer, jMin);
                            j -= jMin;
                            dc.squareup.okio.Pipe.this.buffer.notifyAll();
                        }
                    }
                } else {
                    throw new java.lang.IllegalStateException("closed");
                }
            }
            if (sink != null) {
                this.timeout.push(sink.timeout());
                try {
                    sink.write(buffer, j);
                } finally {
                    this.timeout.pop();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    final class PipeSource implements dc.squareup.okio.Source {
        final dc.squareup.okio.Timeout timeout = new dc.squareup.okio.Timeout();

        PipeSource() {
        }

        @Override // dc.squareup.okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            synchronized (dc.squareup.okio.Pipe.this.buffer) {
                dc.squareup.okio.Pipe pipe = dc.squareup.okio.Pipe.this;
                pipe.sourceClosed = true;
                pipe.buffer.notifyAll();
            }
        }

        @Override // dc.squareup.okio.Source
        public long read(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
            synchronized (dc.squareup.okio.Pipe.this.buffer) {
                if (dc.squareup.okio.Pipe.this.sourceClosed) {
                    throw new java.lang.IllegalStateException("closed");
                }
                while (dc.squareup.okio.Pipe.this.buffer.size() == 0) {
                    dc.squareup.okio.Pipe pipe = dc.squareup.okio.Pipe.this;
                    if (pipe.sinkClosed) {
                        return -1L;
                    }
                    this.timeout.waitUntilNotified(pipe.buffer);
                }
                long j2 = dc.squareup.okio.Pipe.this.buffer.read(buffer, j);
                dc.squareup.okio.Pipe.this.buffer.notifyAll();
                return j2;
            }
        }

        @Override // dc.squareup.okio.Source
        public dc.squareup.okio.Timeout timeout() {
            return this.timeout;
        }
    }

    public Pipe(long j) {
        if (j >= 1) {
            this.maxBufferSize = j;
        } else {
            throw new java.lang.IllegalArgumentException("maxBufferSize < 1: " + j);
        }
    }

    public void fold(dc.squareup.okio.Sink sink) throws java.io.IOException {
        boolean z;
        dc.squareup.okio.Buffer buffer;
        while (true) {
            synchronized (this.buffer) {
                if (this.foldedSink != null) {
                    throw new java.lang.IllegalStateException("sink already folded");
                }
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    return;
                } else {
                    z = this.sinkClosed;
                    buffer = new dc.squareup.okio.Buffer();
                    dc.squareup.okio.Buffer buffer2 = this.buffer;
                    buffer.write(buffer2, buffer2.size);
                    this.buffer.notifyAll();
                }
            }
            try {
                sink.write(buffer, buffer.size);
                if (z) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (java.lang.Throwable th) {
                synchronized (this.buffer) {
                    this.sourceClosed = true;
                    this.buffer.notifyAll();
                    throw th;
                }
            }
        }
    }

    public final dc.squareup.okio.Sink sink() {
        return this.sink;
    }

    public final dc.squareup.okio.Source source() {
        return this.source;
    }
}
