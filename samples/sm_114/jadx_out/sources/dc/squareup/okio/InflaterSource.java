package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class InflaterSource implements dc.squareup.okio.Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final java.util.zip.Inflater inflater;
    private final dc.squareup.okio.BufferedSource source;

    public InflaterSource(dc.squareup.okio.Source source, java.util.zip.Inflater inflater) {
        this(dc.squareup.okio.Okio.buffer(source), inflater);
    }

    private void releaseInflatedBytes() throws java.io.IOException {
        int i = this.bufferBytesHeldByInflater;
        if (i == 0) {
            return;
        }
        int remaining = i - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= remaining;
        this.source.skip(remaining);
    }

    @Override // dc.squareup.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // dc.squareup.okio.Source
    public long read(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
        boolean zRefill;
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            zRefill = refill();
            try {
                dc.squareup.okio.Segment segmentWritableSegment = buffer.writableSegment(1);
                int iInflate = this.inflater.inflate(segmentWritableSegment.data, segmentWritableSegment.limit, (int) java.lang.Math.min(j, 8192 - segmentWritableSegment.limit));
                if (iInflate > 0) {
                    segmentWritableSegment.limit += iInflate;
                    long j2 = iInflate;
                    buffer.size += j2;
                    return j2;
                }
                if (!this.inflater.finished() && !this.inflater.needsDictionary()) {
                }
                releaseInflatedBytes();
                if (segmentWritableSegment.pos != segmentWritableSegment.limit) {
                    return -1L;
                }
                buffer.head = segmentWritableSegment.pop();
                dc.squareup.okio.SegmentPool.recycle(segmentWritableSegment);
                return -1L;
            } catch (java.util.zip.DataFormatException e) {
                throw new java.io.IOException(e);
            }
        } while (!zRefill);
        throw new java.io.EOFException("source exhausted prematurely");
    }

    public final boolean refill() throws java.io.IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        releaseInflatedBytes();
        if (this.inflater.getRemaining() != 0) {
            throw new java.lang.IllegalStateException(com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING);
        }
        if (this.source.exhausted()) {
            return true;
        }
        dc.squareup.okio.Segment segment = this.source.buffer().head;
        int i = segment.limit;
        int i2 = segment.pos;
        int i3 = i - i2;
        this.bufferBytesHeldByInflater = i3;
        this.inflater.setInput(segment.data, i2, i3);
        return false;
    }

    @Override // dc.squareup.okio.Source
    public dc.squareup.okio.Timeout timeout() {
        return this.source.timeout();
    }

    InflaterSource(dc.squareup.okio.BufferedSource bufferedSource, java.util.zip.Inflater inflater) {
        if (bufferedSource == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new java.lang.IllegalArgumentException("inflater == null");
        }
        this.source = bufferedSource;
        this.inflater = inflater;
    }
}
