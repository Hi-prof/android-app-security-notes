package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class PeekSource implements dc.squareup.okio.Source {
    private final dc.squareup.okio.Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private dc.squareup.okio.Segment expectedSegment;
    private long pos;
    private final dc.squareup.okio.BufferedSource upstream;

    PeekSource(dc.squareup.okio.BufferedSource bufferedSource) {
        this.upstream = bufferedSource;
        dc.squareup.okio.Buffer buffer = bufferedSource.buffer();
        this.buffer = buffer;
        dc.squareup.okio.Segment segment = buffer.head;
        this.expectedSegment = segment;
        this.expectedPos = segment != null ? segment.pos : -1;
    }

    @Override // dc.squareup.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.closed = true;
    }

    @Override // dc.squareup.okio.Source
    public long read(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
        dc.squareup.okio.Segment segment;
        dc.squareup.okio.Segment segment2;
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        dc.squareup.okio.Segment segment3 = this.expectedSegment;
        if (segment3 != null && (segment3 != (segment2 = this.buffer.head) || this.expectedPos != segment2.pos)) {
            throw new java.lang.IllegalStateException("Peek source is invalid because upstream source was used");
        }
        if (j == 0) {
            return 0L;
        }
        if (!this.upstream.request(this.pos + 1)) {
            return -1L;
        }
        if (this.expectedSegment == null && (segment = this.buffer.head) != null) {
            this.expectedSegment = segment;
            this.expectedPos = segment.pos;
        }
        long jMin = java.lang.Math.min(j, this.buffer.size - this.pos);
        this.buffer.copyTo(buffer, this.pos, jMin);
        this.pos += jMin;
        return jMin;
    }

    @Override // dc.squareup.okio.Source
    public dc.squareup.okio.Timeout timeout() {
        return this.upstream.timeout();
    }
}
