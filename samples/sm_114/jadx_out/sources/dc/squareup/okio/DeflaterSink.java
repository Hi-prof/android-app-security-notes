package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class DeflaterSink implements dc.squareup.okio.Sink {
    private boolean closed;
    private final java.util.zip.Deflater deflater;
    private final dc.squareup.okio.BufferedSink sink;

    public DeflaterSink(dc.squareup.okio.Sink sink, java.util.zip.Deflater deflater) {
        this(dc.squareup.okio.Okio.buffer(sink), deflater);
    }

    private void deflate(boolean z) throws java.io.IOException {
        dc.squareup.okio.Segment segmentWritableSegment;
        int iDeflate;
        dc.squareup.okio.Buffer buffer = this.sink.buffer();
        while (true) {
            segmentWritableSegment = buffer.writableSegment(1);
            if (z) {
                java.util.zip.Deflater deflater = this.deflater;
                byte[] bArr = segmentWritableSegment.data;
                int i = segmentWritableSegment.limit;
                iDeflate = deflater.deflate(bArr, i, 8192 - i, 2);
            } else {
                java.util.zip.Deflater deflater2 = this.deflater;
                byte[] bArr2 = segmentWritableSegment.data;
                int i2 = segmentWritableSegment.limit;
                iDeflate = deflater2.deflate(bArr2, i2, 8192 - i2);
            }
            if (iDeflate > 0) {
                segmentWritableSegment.limit += iDeflate;
                buffer.size += (long) iDeflate;
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (segmentWritableSegment.pos == segmentWritableSegment.limit) {
            buffer.head = segmentWritableSegment.pop();
            dc.squareup.okio.SegmentPool.recycle(segmentWritableSegment);
        }
    }

    @Override // dc.squareup.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.lang.Throwable {
        if (this.closed) {
            return;
        }
        finishDeflate();
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

    void finishDeflate() throws java.io.IOException {
        this.deflater.finish();
        deflate(false);
    }

    @Override // dc.squareup.okio.Sink, java.io.Flushable
    public void flush() throws java.io.IOException {
        deflate(true);
        this.sink.flush();
    }

    @Override // dc.squareup.okio.Sink
    public dc.squareup.okio.Timeout timeout() {
        return this.sink.timeout();
    }

    public java.lang.String toString() {
        return "DeflaterSink(" + this.sink + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
    }

    @Override // dc.squareup.okio.Sink
    public void write(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
        dc.squareup.okio.Util.checkOffsetAndCount(buffer.size, 0L, j);
        while (j > 0) {
            dc.squareup.okio.Segment segment = buffer.head;
            int iMin = (int) java.lang.Math.min(j, segment.limit - segment.pos);
            this.deflater.setInput(segment.data, segment.pos, iMin);
            deflate(false);
            long j2 = iMin;
            buffer.size -= j2;
            int i = segment.pos + iMin;
            segment.pos = i;
            if (i == segment.limit) {
                buffer.head = segment.pop();
                dc.squareup.okio.SegmentPool.recycle(segment);
            }
            j -= j2;
        }
    }

    DeflaterSink(dc.squareup.okio.BufferedSink bufferedSink, java.util.zip.Deflater deflater) {
        if (bufferedSink == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        if (deflater == null) {
            throw new java.lang.IllegalArgumentException("inflater == null");
        }
        this.sink = bufferedSink;
        this.deflater = deflater;
    }
}
