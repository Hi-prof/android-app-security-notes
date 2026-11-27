package dc.squareup.okhttp3.internal.ws;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class WebSocketWriter {
    boolean activeWriter;
    final dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
    final dc.squareup.okhttp3.internal.ws.WebSocketWriter.FrameSink frameSink = new dc.squareup.okhttp3.internal.ws.WebSocketWriter.FrameSink();
    final boolean isClient;
    private final dc.squareup.okio.Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    final java.util.Random random;
    final dc.squareup.okio.BufferedSink sink;
    final dc.squareup.okio.Buffer sinkBuffer;
    boolean writerClosed;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    final class FrameSink implements dc.squareup.okio.Sink {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;

        FrameSink() {
        }

        @Override // dc.squareup.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            if (this.closed) {
                throw new java.io.IOException("closed");
            }
            dc.squareup.okhttp3.internal.ws.WebSocketWriter webSocketWriter = dc.squareup.okhttp3.internal.ws.WebSocketWriter.this;
            webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.size(), this.isFirstFrame, true);
            this.closed = true;
            dc.squareup.okhttp3.internal.ws.WebSocketWriter.this.activeWriter = false;
        }

        @Override // dc.squareup.okio.Sink, java.io.Flushable
        public void flush() throws java.io.IOException {
            if (this.closed) {
                throw new java.io.IOException("closed");
            }
            dc.squareup.okhttp3.internal.ws.WebSocketWriter webSocketWriter = dc.squareup.okhttp3.internal.ws.WebSocketWriter.this;
            webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.size(), this.isFirstFrame, false);
            this.isFirstFrame = false;
        }

        @Override // dc.squareup.okio.Sink
        public dc.squareup.okio.Timeout timeout() {
            return dc.squareup.okhttp3.internal.ws.WebSocketWriter.this.sink.timeout();
        }

        @Override // dc.squareup.okio.Sink
        public void write(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
            if (this.closed) {
                throw new java.io.IOException("closed");
            }
            dc.squareup.okhttp3.internal.ws.WebSocketWriter.this.buffer.write(buffer, j);
            boolean z = this.isFirstFrame && this.contentLength != -1 && dc.squareup.okhttp3.internal.ws.WebSocketWriter.this.buffer.size() > this.contentLength - tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_CENTER;
            long jCompleteSegmentByteCount = dc.squareup.okhttp3.internal.ws.WebSocketWriter.this.buffer.completeSegmentByteCount();
            if (jCompleteSegmentByteCount <= 0 || z) {
                return;
            }
            dc.squareup.okhttp3.internal.ws.WebSocketWriter.this.writeMessageFrame(this.formatOpcode, jCompleteSegmentByteCount, this.isFirstFrame, false);
            this.isFirstFrame = false;
        }
    }

    WebSocketWriter(boolean z, dc.squareup.okio.BufferedSink bufferedSink, java.util.Random random) {
        if (bufferedSink == null) {
            throw new java.lang.NullPointerException("sink == null");
        }
        if (random == null) {
            throw new java.lang.NullPointerException("random == null");
        }
        this.isClient = z;
        this.sink = bufferedSink;
        this.sinkBuffer = bufferedSink.buffer();
        this.random = random;
        this.maskKey = z ? new byte[4] : null;
        this.maskCursor = z ? new dc.squareup.okio.Buffer.UnsafeCursor() : null;
    }

    private void writeControlFrame(int i, dc.squareup.okio.ByteString byteString) throws java.io.IOException {
        if (this.writerClosed) {
            throw new java.io.IOException("closed");
        }
        int size = byteString.size();
        if (size > 125) {
            throw new java.lang.IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.sinkBuffer.writeByte(i | 128);
        if (this.isClient) {
            this.sinkBuffer.writeByte(size | 128);
            this.random.nextBytes(this.maskKey);
            this.sinkBuffer.write(this.maskKey);
            if (size > 0) {
                long size2 = this.sinkBuffer.size();
                this.sinkBuffer.write(byteString);
                this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(size2);
                dc.squareup.okhttp3.internal.ws.WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.writeByte(size);
            this.sinkBuffer.write(byteString);
        }
        this.sink.flush();
    }

    dc.squareup.okio.Sink newMessageSink(int i, long j) {
        if (this.activeWriter) {
            throw new java.lang.IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.activeWriter = true;
        dc.squareup.okhttp3.internal.ws.WebSocketWriter.FrameSink frameSink = this.frameSink;
        frameSink.formatOpcode = i;
        frameSink.contentLength = j;
        frameSink.isFirstFrame = true;
        frameSink.closed = false;
        return frameSink;
    }

    void writeClose(int i, dc.squareup.okio.ByteString byteString) throws java.io.IOException {
        dc.squareup.okio.ByteString byteString2 = dc.squareup.okio.ByteString.EMPTY;
        if (i != 0 || byteString != null) {
            if (i != 0) {
                dc.squareup.okhttp3.internal.ws.WebSocketProtocol.validateCloseCode(i);
            }
            dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
            buffer.writeShort(i);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    void writeMessageFrame(int i, long j, boolean z, boolean z2) throws java.io.IOException {
        if (this.writerClosed) {
            throw new java.io.IOException("closed");
        }
        if (!z) {
            i = 0;
        }
        if (z2) {
            i |= 128;
        }
        this.sinkBuffer.writeByte(i);
        int i2 = this.isClient ? 128 : 0;
        if (j <= 125) {
            this.sinkBuffer.writeByte(((int) j) | i2);
        } else if (j <= 65535) {
            this.sinkBuffer.writeByte(i2 | 126);
            this.sinkBuffer.writeShort((int) j);
        } else {
            this.sinkBuffer.writeByte(i2 | kotlinx.coroutines.scheduling.WorkQueueKt.MASK);
            this.sinkBuffer.writeLong(j);
        }
        if (this.isClient) {
            this.random.nextBytes(this.maskKey);
            this.sinkBuffer.write(this.maskKey);
            if (j > 0) {
                long size = this.sinkBuffer.size();
                this.sinkBuffer.write(this.buffer, j);
                this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(size);
                dc.squareup.okhttp3.internal.ws.WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.write(this.buffer, j);
        }
        this.sink.emit();
    }

    void writePing(dc.squareup.okio.ByteString byteString) throws java.io.IOException {
        writeControlFrame(9, byteString);
    }

    void writePong(dc.squareup.okio.ByteString byteString) throws java.io.IOException {
        writeControlFrame(10, byteString);
    }
}
