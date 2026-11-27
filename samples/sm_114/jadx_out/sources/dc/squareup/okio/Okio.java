package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Okio {
    static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(dc.squareup.okio.Okio.class.getName());

    private Okio() {
    }

    public static dc.squareup.okio.Sink appendingSink(java.io.File file) throws java.io.FileNotFoundException {
        if (file != null) {
            return sink(new java.io.FileOutputStream(file, true));
        }
        throw new java.lang.IllegalArgumentException("file == null");
    }

    public static dc.squareup.okio.Sink blackhole() {
        return new dc.squareup.okio.Sink() { // from class: dc.squareup.okio.Okio.3
            @Override // dc.squareup.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.io.IOException {
            }

            @Override // dc.squareup.okio.Sink, java.io.Flushable
            public void flush() throws java.io.IOException {
            }

            @Override // dc.squareup.okio.Sink
            public dc.squareup.okio.Timeout timeout() {
                return dc.squareup.okio.Timeout.NONE;
            }

            @Override // dc.squareup.okio.Sink
            public void write(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
                buffer.skip(j);
            }
        };
    }

    public static dc.squareup.okio.BufferedSource buffer(dc.squareup.okio.Source source) {
        return new dc.squareup.okio.RealBufferedSource(source);
    }

    static boolean isAndroidGetsocknameError(java.lang.AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static dc.squareup.okio.Sink sink(java.io.OutputStream outputStream) {
        return sink(outputStream, new dc.squareup.okio.Timeout());
    }

    public static dc.squareup.okio.Source source(java.io.InputStream inputStream) {
        return source(inputStream, new dc.squareup.okio.Timeout());
    }

    private static dc.squareup.okio.AsyncTimeout timeout(final java.net.Socket socket) {
        return new dc.squareup.okio.AsyncTimeout() { // from class: dc.squareup.okio.Okio.4
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
                try {
                    socket.close();
                } catch (java.lang.AssertionError e) {
                    if (!dc.squareup.okio.Okio.isAndroidGetsocknameError(e)) {
                        throw e;
                    }
                    dc.squareup.okio.Okio.logger.log(java.util.logging.Level.WARNING, "Failed to close timed out socket " + socket, (java.lang.Throwable) e);
                } catch (java.lang.Exception e2) {
                    dc.squareup.okio.Okio.logger.log(java.util.logging.Level.WARNING, "Failed to close timed out socket " + socket, (java.lang.Throwable) e2);
                }
            }
        };
    }

    public static dc.squareup.okio.BufferedSink buffer(dc.squareup.okio.Sink sink) {
        return new dc.squareup.okio.RealBufferedSink(sink);
    }

    private static dc.squareup.okio.Sink sink(final java.io.OutputStream outputStream, final dc.squareup.okio.Timeout timeout) {
        if (outputStream == null) {
            throw new java.lang.IllegalArgumentException("out == null");
        }
        if (timeout != null) {
            return new dc.squareup.okio.Sink() { // from class: dc.squareup.okio.Okio.1
                @Override // dc.squareup.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws java.io.IOException {
                    outputStream.close();
                }

                @Override // dc.squareup.okio.Sink, java.io.Flushable
                public void flush() throws java.io.IOException {
                    outputStream.flush();
                }

                @Override // dc.squareup.okio.Sink
                public dc.squareup.okio.Timeout timeout() {
                    return timeout;
                }

                public java.lang.String toString() {
                    return "sink(" + outputStream + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
                }

                @Override // dc.squareup.okio.Sink
                public void write(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
                    dc.squareup.okio.Util.checkOffsetAndCount(buffer.size, 0L, j);
                    while (j > 0) {
                        timeout.throwIfReached();
                        dc.squareup.okio.Segment segment = buffer.head;
                        int iMin = (int) java.lang.Math.min(j, segment.limit - segment.pos);
                        outputStream.write(segment.data, segment.pos, iMin);
                        int i = segment.pos + iMin;
                        segment.pos = i;
                        long j2 = iMin;
                        j -= j2;
                        buffer.size -= j2;
                        if (i == segment.limit) {
                            buffer.head = segment.pop();
                            dc.squareup.okio.SegmentPool.recycle(segment);
                        }
                    }
                }
            };
        }
        throw new java.lang.IllegalArgumentException("timeout == null");
    }

    private static dc.squareup.okio.Source source(final java.io.InputStream inputStream, final dc.squareup.okio.Timeout timeout) {
        if (inputStream == null) {
            throw new java.lang.IllegalArgumentException("in == null");
        }
        if (timeout != null) {
            return new dc.squareup.okio.Source() { // from class: dc.squareup.okio.Okio.2
                @Override // dc.squareup.okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws java.io.IOException {
                    inputStream.close();
                }

                @Override // dc.squareup.okio.Source
                public long read(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
                    if (j < 0) {
                        throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
                    }
                    if (j == 0) {
                        return 0L;
                    }
                    try {
                        timeout.throwIfReached();
                        dc.squareup.okio.Segment segmentWritableSegment = buffer.writableSegment(1);
                        int i = inputStream.read(segmentWritableSegment.data, segmentWritableSegment.limit, (int) java.lang.Math.min(j, 8192 - segmentWritableSegment.limit));
                        if (i != -1) {
                            segmentWritableSegment.limit += i;
                            long j2 = i;
                            buffer.size += j2;
                            return j2;
                        }
                        if (segmentWritableSegment.pos != segmentWritableSegment.limit) {
                            return -1L;
                        }
                        buffer.head = segmentWritableSegment.pop();
                        dc.squareup.okio.SegmentPool.recycle(segmentWritableSegment);
                        return -1L;
                    } catch (java.lang.AssertionError e) {
                        if (dc.squareup.okio.Okio.isAndroidGetsocknameError(e)) {
                            throw new java.io.IOException(e);
                        }
                        throw e;
                    }
                }

                @Override // dc.squareup.okio.Source
                public dc.squareup.okio.Timeout timeout() {
                    return timeout;
                }

                public java.lang.String toString() {
                    return "source(" + inputStream + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
                }
            };
        }
        throw new java.lang.IllegalArgumentException("timeout == null");
    }

    public static dc.squareup.okio.Sink sink(java.net.Socket socket) throws java.io.IOException {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                dc.squareup.okio.AsyncTimeout asyncTimeoutTimeout = timeout(socket);
                return asyncTimeoutTimeout.sink(sink(socket.getOutputStream(), asyncTimeoutTimeout));
            }
            throw new java.io.IOException("socket's output stream == null");
        }
        throw new java.lang.IllegalArgumentException("socket == null");
    }

    public static dc.squareup.okio.Source source(java.io.File file) throws java.io.FileNotFoundException {
        if (file != null) {
            return source(new java.io.FileInputStream(file));
        }
        throw new java.lang.IllegalArgumentException("file == null");
    }

    public static dc.squareup.okio.Source source(java.nio.file.Path path, java.nio.file.OpenOption... openOptionArr) throws java.io.IOException {
        if (path != null) {
            return source(java.nio.file.Files.newInputStream(path, openOptionArr));
        }
        throw new java.lang.IllegalArgumentException("path == null");
    }

    public static dc.squareup.okio.Source source(java.net.Socket socket) throws java.io.IOException {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                dc.squareup.okio.AsyncTimeout asyncTimeoutTimeout = timeout(socket);
                return asyncTimeoutTimeout.source(source(socket.getInputStream(), asyncTimeoutTimeout));
            }
            throw new java.io.IOException("socket's input stream == null");
        }
        throw new java.lang.IllegalArgumentException("socket == null");
    }

    public static dc.squareup.okio.Sink sink(java.io.File file) throws java.io.FileNotFoundException {
        if (file != null) {
            return sink(new java.io.FileOutputStream(file));
        }
        throw new java.lang.IllegalArgumentException("file == null");
    }

    public static dc.squareup.okio.Sink sink(java.nio.file.Path path, java.nio.file.OpenOption... openOptionArr) throws java.io.IOException {
        if (path != null) {
            return sink(java.nio.file.Files.newOutputStream(path, openOptionArr));
        }
        throw new java.lang.IllegalArgumentException("path == null");
    }
}
