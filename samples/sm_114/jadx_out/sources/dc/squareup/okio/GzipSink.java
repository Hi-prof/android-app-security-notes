package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class GzipSink implements dc.squareup.okio.Sink {
    private boolean closed;
    private final java.util.zip.CRC32 crc = new java.util.zip.CRC32();
    private final java.util.zip.Deflater deflater;
    private final dc.squareup.okio.DeflaterSink deflaterSink;
    private final dc.squareup.okio.BufferedSink sink;

    public GzipSink(dc.squareup.okio.Sink sink) {
        if (sink == null) {
            throw new java.lang.IllegalArgumentException("sink == null");
        }
        java.util.zip.Deflater deflater = new java.util.zip.Deflater(-1, true);
        this.deflater = deflater;
        dc.squareup.okio.BufferedSink bufferedSinkBuffer = dc.squareup.okio.Okio.buffer(sink);
        this.sink = bufferedSinkBuffer;
        this.deflaterSink = new dc.squareup.okio.DeflaterSink(bufferedSinkBuffer, deflater);
        writeHeader();
    }

    private void updateCrc(dc.squareup.okio.Buffer buffer, long j) {
        dc.squareup.okio.Segment segment = buffer.head;
        while (j > 0) {
            int iMin = (int) java.lang.Math.min(j, segment.limit - segment.pos);
            this.crc.update(segment.data, segment.pos, iMin);
            j -= (long) iMin;
            segment = segment.next;
        }
    }

    private void writeFooter() throws java.io.IOException {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    private void writeHeader() {
        dc.squareup.okio.Buffer buffer = this.sink.buffer();
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    @Override // dc.squareup.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.lang.Throwable {
        if (this.closed) {
            return;
        }
        this.deflaterSink.finishDeflate();
        writeFooter();
        th = null;
        try {
            this.deflater.end();
        } catch (java.lang.Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        try {
            this.sink.close();
        } catch (java.lang.Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.closed = true;
        if (th != null) {
            dc.squareup.okio.Util.sneakyRethrow(th);
        }
    }

    public final java.util.zip.Deflater deflater() {
        return this.deflater;
    }

    @Override // dc.squareup.okio.Sink, java.io.Flushable
    public void flush() throws java.io.IOException {
        this.deflaterSink.flush();
    }

    @Override // dc.squareup.okio.Sink
    public dc.squareup.okio.Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // dc.squareup.okio.Sink
    public void write(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return;
        }
        updateCrc(buffer, j);
        this.deflaterSink.write(buffer, j);
    }
}
