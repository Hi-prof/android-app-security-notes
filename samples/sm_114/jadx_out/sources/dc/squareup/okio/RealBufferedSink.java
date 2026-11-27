package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class RealBufferedSink implements dc.squareup.okio.BufferedSink {
    public final dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
    boolean closed;
    public final dc.squareup.okio.Sink sink;

    RealBufferedSink(dc.squareup.okio.Sink sink) {
        if (sink == null) {
            throw new java.lang.NullPointerException("sink == null");
        }
        this.sink = sink;
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer buffer() {
        return this.buffer;
    }

    @Override // dc.squareup.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.lang.Throwable {
        if (this.closed) {
            return;
        }
        dc.squareup.okio.Buffer buffer = this.buffer;
        long j = buffer.size;
        if (j > 0) {
            this.sink.write(buffer, j);
        }
        th = null;
        try {
            this.sink.close();
        } catch (java.lang.Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.closed = true;
        if (th != null) {
            dc.squareup.okio.Util.sneakyRethrow(th);
        }
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink emit() throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        long size = this.buffer.size();
        if (size > 0) {
            this.sink.write(this.buffer, size);
        }
        return this;
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink emitCompleteSegments() throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        long jCompleteSegmentByteCount = this.buffer.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            this.sink.write(this.buffer, jCompleteSegmentByteCount);
        }
        return this;
    }

    @Override // dc.squareup.okio.BufferedSink, dc.squareup.okio.Sink, java.io.Flushable
    public void flush() throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        dc.squareup.okio.Buffer buffer = this.buffer;
        long j = buffer.size;
        if (j > 0) {
            this.sink.write(buffer, j);
        }
        this.sink.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // dc.squareup.okio.BufferedSink
    public java.io.OutputStream outputStream() {
        return new java.io.OutputStream() { // from class: dc.squareup.okio.RealBufferedSink.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.lang.Throwable {
                dc.squareup.okio.RealBufferedSink.this.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws java.io.IOException {
                dc.squareup.okio.RealBufferedSink realBufferedSink = dc.squareup.okio.RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    return;
                }
                realBufferedSink.flush();
            }

            public java.lang.String toString() {
                return dc.squareup.okio.RealBufferedSink.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i) throws java.io.IOException {
                dc.squareup.okio.RealBufferedSink realBufferedSink = dc.squareup.okio.RealBufferedSink.this;
                if (realBufferedSink.closed) {
                    throw new java.io.IOException("closed");
                }
                realBufferedSink.buffer.writeByte((int) ((byte) i));
                dc.squareup.okio.RealBufferedSink.this.emitCompleteSegments();
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
                dc.squareup.okio.RealBufferedSink realBufferedSink = dc.squareup.okio.RealBufferedSink.this;
                if (!realBufferedSink.closed) {
                    realBufferedSink.buffer.write(bArr, i, i2);
                    dc.squareup.okio.RealBufferedSink.this.emitCompleteSegments();
                    return;
                }
                throw new java.io.IOException("closed");
            }
        };
    }

    @Override // dc.squareup.okio.Sink
    public dc.squareup.okio.Timeout timeout() {
        return this.sink.timeout();
    }

    public java.lang.String toString() {
        return "buffer(" + this.sink + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
    }

    @Override // dc.squareup.okio.Sink
    public void write(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.write(buffer, j);
        emitCompleteSegments();
    }

    @Override // dc.squareup.okio.BufferedSink
    public long writeAll(dc.squareup.okio.Source source) throws java.io.IOException {
        if (source == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long j2 = source.read(this.buffer, tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_CENTER);
            if (j2 == -1) {
                return j;
            }
            j += j2;
            emitCompleteSegments();
        }
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink writeByte(int i) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeByte(i);
        return emitCompleteSegments();
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink writeDecimalLong(long j) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeDecimalLong(j);
        return emitCompleteSegments();
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink writeHexadecimalUnsignedLong(long j) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeHexadecimalUnsignedLong(j);
        return emitCompleteSegments();
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink writeInt(int i) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeInt(i);
        return emitCompleteSegments();
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink writeIntLe(int i) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeIntLe(i);
        return emitCompleteSegments();
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink writeLong(long j) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeLong(j);
        return emitCompleteSegments();
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink writeLongLe(long j) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeLongLe(j);
        return emitCompleteSegments();
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink writeShort(int i) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeShort(i);
        return emitCompleteSegments();
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink writeShortLe(int i) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeShortLe(i);
        return emitCompleteSegments();
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink writeString(java.lang.String str, java.nio.charset.Charset charset) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeString(str, charset);
        return emitCompleteSegments();
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink writeUtf8(java.lang.String str) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeUtf8(str);
        return emitCompleteSegments();
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink writeUtf8CodePoint(int i) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeUtf8CodePoint(i);
        return emitCompleteSegments();
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink write(dc.squareup.okio.ByteString byteString) throws java.io.IOException {
        if (!this.closed) {
            this.buffer.write(byteString);
            return emitCompleteSegments();
        }
        throw new java.lang.IllegalStateException("closed");
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink writeString(java.lang.String str, int i, int i2, java.nio.charset.Charset charset) throws java.io.IOException {
        if (!this.closed) {
            this.buffer.writeString(str, i, i2, charset);
            return emitCompleteSegments();
        }
        throw new java.lang.IllegalStateException("closed");
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink writeUtf8(java.lang.String str, int i, int i2) throws java.io.IOException {
        if (!this.closed) {
            this.buffer.writeUtf8(str, i, i2);
            return emitCompleteSegments();
        }
        throw new java.lang.IllegalStateException("closed");
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink write(byte[] bArr) throws java.io.IOException {
        if (!this.closed) {
            this.buffer.write(bArr);
            return emitCompleteSegments();
        }
        throw new java.lang.IllegalStateException("closed");
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink write(byte[] bArr, int i, int i2) throws java.io.IOException {
        if (!this.closed) {
            this.buffer.write(bArr, i, i2);
            return emitCompleteSegments();
        }
        throw new java.lang.IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        if (!this.closed) {
            int iWrite = this.buffer.write(byteBuffer);
            emitCompleteSegments();
            return iWrite;
        }
        throw new java.lang.IllegalStateException("closed");
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink write(dc.squareup.okio.Source source, long j) throws java.io.IOException {
        while (j > 0) {
            long j2 = source.read(this.buffer, j);
            if (j2 != -1) {
                j -= j2;
                emitCompleteSegments();
            } else {
                throw new java.io.EOFException();
            }
        }
        return this;
    }
}
