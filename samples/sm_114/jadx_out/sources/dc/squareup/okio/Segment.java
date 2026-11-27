package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class Segment {
    static final int SHARE_MINIMUM = 1024;
    static final int SIZE = 8192;
    final byte[] data;
    int limit;
    dc.squareup.okio.Segment next;
    boolean owner;
    int pos;
    dc.squareup.okio.Segment prev;
    boolean shared;

    Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        dc.squareup.okio.Segment segment = this.prev;
        if (segment == this) {
            throw new java.lang.IllegalStateException();
        }
        if (segment.owner) {
            int i = this.limit - this.pos;
            if (i > (8192 - segment.limit) + (segment.shared ? 0 : segment.pos)) {
                return;
            }
            writeTo(segment, i);
            pop();
            dc.squareup.okio.SegmentPool.recycle(this);
        }
    }

    public final dc.squareup.okio.Segment pop() {
        dc.squareup.okio.Segment segment = this.next;
        dc.squareup.okio.Segment segment2 = segment != this ? segment : null;
        dc.squareup.okio.Segment segment3 = this.prev;
        segment3.next = segment;
        this.next.prev = segment3;
        this.next = null;
        this.prev = null;
        return segment2;
    }

    public final dc.squareup.okio.Segment push(dc.squareup.okio.Segment segment) {
        segment.prev = this;
        segment.next = this.next;
        this.next.prev = segment;
        this.next = segment;
        return segment;
    }

    final dc.squareup.okio.Segment sharedCopy() {
        this.shared = true;
        return new dc.squareup.okio.Segment(this.data, this.pos, this.limit, true, false);
    }

    public final dc.squareup.okio.Segment split(int i) {
        dc.squareup.okio.Segment segmentTake;
        if (i <= 0 || i > this.limit - this.pos) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i >= 1024) {
            segmentTake = sharedCopy();
        } else {
            segmentTake = dc.squareup.okio.SegmentPool.take();
            java.lang.System.arraycopy(this.data, this.pos, segmentTake.data, 0, i);
        }
        segmentTake.limit = segmentTake.pos + i;
        this.pos += i;
        this.prev.push(segmentTake);
        return segmentTake;
    }

    final dc.squareup.okio.Segment unsharedCopy() {
        return new dc.squareup.okio.Segment((byte[]) this.data.clone(), this.pos, this.limit, false, true);
    }

    public final void writeTo(dc.squareup.okio.Segment segment, int i) {
        if (!segment.owner) {
            throw new java.lang.IllegalArgumentException();
        }
        int i2 = segment.limit;
        int i3 = i2 + i;
        if (i3 > 8192) {
            if (segment.shared) {
                throw new java.lang.IllegalArgumentException();
            }
            int i4 = segment.pos;
            if (i3 - i4 > 8192) {
                throw new java.lang.IllegalArgumentException();
            }
            byte[] bArr = segment.data;
            java.lang.System.arraycopy(bArr, i4, bArr, 0, i2 - i4);
            segment.limit -= segment.pos;
            segment.pos = 0;
        }
        java.lang.System.arraycopy(this.data, this.pos, segment.data, segment.limit, i);
        segment.limit += i;
        this.pos += i;
    }

    Segment(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.data = bArr;
        this.pos = i;
        this.limit = i2;
        this.shared = z;
        this.owner = z2;
    }
}
