package dc.squareup.okhttp3.internal.http2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class Http2Writer implements java.io.Closeable {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(dc.squareup.okhttp3.internal.http2.Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final dc.squareup.okio.Buffer hpackBuffer;
    final dc.squareup.okhttp3.internal.http2.Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final dc.squareup.okio.BufferedSink sink;

    Http2Writer(dc.squareup.okio.BufferedSink bufferedSink, boolean z) {
        this.sink = bufferedSink;
        this.client = z;
        dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
        this.hpackBuffer = buffer;
        this.hpackWriter = new dc.squareup.okhttp3.internal.http2.Hpack.Writer(buffer);
        this.maxFrameSize = 16384;
    }

    private void writeContinuationFrames(int i, long j) throws java.io.IOException {
        while (j > 0) {
            int iMin = (int) java.lang.Math.min(this.maxFrameSize, j);
            long j2 = iMin;
            j -= j2;
            frameHeader(i, iMin, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.sink.write(this.hpackBuffer, j2);
        }
    }

    private static void writeMedium(dc.squareup.okio.BufferedSink bufferedSink, int i) throws java.io.IOException {
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    public synchronized void applyAndAckSettings(dc.squareup.okhttp3.internal.http2.Settings settings) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
        if (settings.getHeaderTableSize() != -1) {
            this.hpackWriter.setHeaderTableSizeSetting(settings.getHeaderTableSize());
        }
        frameHeader(0, 0, (byte) 4, (byte) 1);
        this.sink.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws java.io.IOException {
        this.closed = true;
        this.sink.close();
    }

    public synchronized void connectionPreface() throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        if (this.client) {
            java.util.logging.Logger logger2 = logger;
            if (logger2.isLoggable(java.util.logging.Level.FINE)) {
                logger2.fine(dc.squareup.okhttp3.internal.Util.format(">> CONNECTION %s", dc.squareup.okhttp3.internal.http2.Http2.CONNECTION_PREFACE.hex()));
            }
            this.sink.write(dc.squareup.okhttp3.internal.http2.Http2.CONNECTION_PREFACE.toByteArray());
            this.sink.flush();
        }
    }

    public synchronized void data(boolean z, int i, dc.squareup.okio.Buffer buffer, int i2) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        dataFrame(i, z ? (byte) 1 : (byte) 0, buffer, i2);
    }

    void dataFrame(int i, byte b, dc.squareup.okio.Buffer buffer, int i2) throws java.io.IOException {
        frameHeader(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.sink.write(buffer, i2);
        }
    }

    public synchronized void flush() throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        this.sink.flush();
    }

    public void frameHeader(int i, int i2, byte b, byte b2) throws java.io.IOException {
        java.util.logging.Logger logger2 = logger;
        if (logger2.isLoggable(java.util.logging.Level.FINE)) {
            logger2.fine(dc.squareup.okhttp3.internal.http2.Http2.frameLog(false, i, i2, b, b2));
        }
        int i3 = this.maxFrameSize;
        if (i2 > i3) {
            throw dc.squareup.okhttp3.internal.http2.Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw dc.squareup.okhttp3.internal.http2.Http2.illegalArgument("reserved bit set: %s", java.lang.Integer.valueOf(i));
        }
        writeMedium(this.sink, i2);
        this.sink.writeByte(b & 255);
        this.sink.writeByte(b2 & 255);
        this.sink.writeInt(i & Integer.MAX_VALUE);
    }

    public synchronized void goAway(int i, dc.squareup.okhttp3.internal.http2.ErrorCode errorCode, byte[] bArr) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw dc.squareup.okhttp3.internal.http2.Http2.illegalArgument("errorCode.httpCode == -1", new java.lang.Object[0]);
        }
        frameHeader(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.sink.writeInt(i);
        this.sink.writeInt(errorCode.httpCode);
        if (bArr.length > 0) {
            this.sink.write(bArr);
        }
        this.sink.flush();
    }

    public synchronized void headers(int i, java.util.List<dc.squareup.okhttp3.internal.http2.Header> list) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        headers(false, i, list);
    }

    public int maxDataLength() {
        return this.maxFrameSize;
    }

    public synchronized void ping(boolean z, int i, int i2) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        frameHeader(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.sink.writeInt(i);
        this.sink.writeInt(i2);
        this.sink.flush();
    }

    public synchronized void pushPromise(int i, int i2, java.util.List<dc.squareup.okhttp3.internal.http2.Header> list) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long size = this.hpackBuffer.size();
        int iMin = (int) java.lang.Math.min(this.maxFrameSize - 4, size);
        long j = iMin;
        frameHeader(i, iMin + 4, (byte) 5, size == j ? (byte) 4 : (byte) 0);
        this.sink.writeInt(i2 & Integer.MAX_VALUE);
        this.sink.write(this.hpackBuffer, j);
        if (size > j) {
            writeContinuationFrames(i, size - j);
        }
    }

    public synchronized void rstStream(int i, dc.squareup.okhttp3.internal.http2.ErrorCode errorCode) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw new java.lang.IllegalArgumentException();
        }
        frameHeader(i, 4, (byte) 3, (byte) 0);
        this.sink.writeInt(errorCode.httpCode);
        this.sink.flush();
    }

    public synchronized void settings(dc.squareup.okhttp3.internal.http2.Settings settings) throws java.io.IOException {
        int i;
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        int i2 = 0;
        frameHeader(0, settings.size() * 6, (byte) 4, (byte) 0);
        while (i2 < 10) {
            if (settings.isSet(i2)) {
                if (i2 == 4) {
                    i = 3;
                } else {
                    i = i2 == 7 ? 4 : i2;
                }
                this.sink.writeShort(i);
                this.sink.writeInt(settings.get(i2));
            }
            i2++;
        }
        this.sink.flush();
    }

    public synchronized void synReply(boolean z, int i, java.util.List<dc.squareup.okhttp3.internal.http2.Header> list) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        headers(z, i, list);
    }

    public synchronized void synStream(boolean z, int i, int i2, java.util.List<dc.squareup.okhttp3.internal.http2.Header> list) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        headers(z, i, list);
    }

    public synchronized void windowUpdate(int i, long j) throws java.io.IOException {
        if (this.closed) {
            throw new java.io.IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw dc.squareup.okhttp3.internal.http2.Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", java.lang.Long.valueOf(j));
        }
        frameHeader(i, 4, (byte) 8, (byte) 0);
        this.sink.writeInt((int) j);
        this.sink.flush();
    }

    void headers(boolean z, int i, java.util.List<dc.squareup.okhttp3.internal.http2.Header> list) throws java.io.IOException {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long size = this.hpackBuffer.size();
            int iMin = (int) java.lang.Math.min(this.maxFrameSize, size);
            long j = iMin;
            byte b = size == j ? (byte) 4 : (byte) 0;
            if (z) {
                b = (byte) (b | 1);
            }
            frameHeader(i, iMin, (byte) 1, b);
            this.sink.write(this.hpackBuffer, j);
            if (size > j) {
                writeContinuationFrames(i, size - j);
                return;
            }
            return;
        }
        throw new java.io.IOException("closed");
    }
}
