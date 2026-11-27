package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class SegmentPool {
    static final long MAX_SIZE = 65536;
    static long byteCount;
    static dc.squareup.okio.Segment next;

    private SegmentPool() {
    }

    static void recycle(dc.squareup.okio.Segment segment) {
        if (segment.next != null || segment.prev != null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (segment.shared) {
            return;
        }
        synchronized (dc.squareup.okio.SegmentPool.class) {
            long j = byteCount + tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_CENTER;
            if (j > 65536) {
                return;
            }
            byteCount = j;
            segment.next = next;
            segment.limit = 0;
            segment.pos = 0;
            next = segment;
        }
    }

    static dc.squareup.okio.Segment take() {
        synchronized (dc.squareup.okio.SegmentPool.class) {
            dc.squareup.okio.Segment segment = next;
            if (segment == null) {
                return new dc.squareup.okio.Segment();
            }
            next = segment.next;
            segment.next = null;
            byteCount -= tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_CENTER;
            return segment;
        }
    }
}
