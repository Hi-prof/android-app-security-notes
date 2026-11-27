package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Buffer implements dc.squareup.okio.BufferedSource, dc.squareup.okio.BufferedSink, java.lang.Cloneable, java.nio.channels.ByteChannel {
    private static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;
    dc.squareup.okio.Segment head;
    long size;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static final class UnsafeCursor implements java.io.Closeable {
        public dc.squareup.okio.Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        private dc.squareup.okio.Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) {
                throw new java.lang.IllegalStateException("not attached to a buffer");
            }
            this.buffer = null;
            this.segment = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int i) {
            if (i <= 0) {
                throw new java.lang.IllegalArgumentException("minByteCount <= 0: " + i);
            }
            if (i > 8192) {
                throw new java.lang.IllegalArgumentException("minByteCount > Segment.SIZE: " + i);
            }
            dc.squareup.okio.Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new java.lang.IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new java.lang.IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long j = buffer.size;
            dc.squareup.okio.Segment segmentWritableSegment = buffer.writableSegment(i);
            int i2 = 8192 - segmentWritableSegment.limit;
            segmentWritableSegment.limit = 8192;
            long j2 = i2;
            this.buffer.size = j + j2;
            this.segment = segmentWritableSegment;
            this.offset = j;
            this.data = segmentWritableSegment.data;
            this.start = 8192 - i2;
            this.end = 8192;
            return j2;
        }

        public final int next() {
            long j = this.offset;
            if (j != this.buffer.size) {
                return j == -1 ? seek(0L) : seek(j + ((long) (this.end - this.start)));
            }
            throw new java.lang.IllegalStateException();
        }

        public final long resizeBuffer(long j) {
            dc.squareup.okio.Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new java.lang.IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new java.lang.IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j2 = buffer.size;
            if (j <= j2) {
                if (j < 0) {
                    throw new java.lang.IllegalArgumentException("newSize < 0: " + j);
                }
                long j3 = j2 - j;
                while (j3 > 0) {
                    dc.squareup.okio.Buffer buffer2 = this.buffer;
                    dc.squareup.okio.Segment segment = buffer2.head.prev;
                    int i = segment.limit;
                    long j4 = i - segment.pos;
                    if (j4 > j3) {
                        segment.limit = (int) (((long) i) - j3);
                        break;
                    }
                    buffer2.head = segment.pop();
                    dc.squareup.okio.SegmentPool.recycle(segment);
                    j3 -= j4;
                }
                this.segment = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (j > j2) {
                long j5 = j - j2;
                boolean z = true;
                while (j5 > 0) {
                    dc.squareup.okio.Segment segmentWritableSegment = this.buffer.writableSegment(1);
                    int iMin = (int) java.lang.Math.min(j5, 8192 - segmentWritableSegment.limit);
                    int i2 = segmentWritableSegment.limit + iMin;
                    segmentWritableSegment.limit = i2;
                    j5 -= (long) iMin;
                    if (z) {
                        this.segment = segmentWritableSegment;
                        this.offset = j2;
                        this.data = segmentWritableSegment.data;
                        this.start = i2 - iMin;
                        this.end = i2;
                        z = false;
                    }
                }
            }
            this.buffer.size = j;
            return j2;
        }

        public final int seek(long j) {
            if (j >= -1) {
                dc.squareup.okio.Buffer buffer = this.buffer;
                long j2 = buffer.size;
                if (j <= j2) {
                    if (j == -1 || j == j2) {
                        this.segment = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                    dc.squareup.okio.Segment segment = buffer.head;
                    dc.squareup.okio.Segment segmentPush = this.segment;
                    long j3 = 0;
                    if (segmentPush != null) {
                        long j4 = this.offset - ((long) (this.start - segmentPush.pos));
                        if (j4 > j) {
                            segmentPush = segment;
                            segment = segmentPush;
                            j2 = j4;
                        } else {
                            j3 = j4;
                        }
                    } else {
                        segmentPush = segment;
                    }
                    if (j2 - j > j - j3) {
                        while (true) {
                            long j5 = ((long) (segmentPush.limit - segmentPush.pos)) + j3;
                            if (j < j5) {
                                break;
                            }
                            segmentPush = segmentPush.next;
                            j3 = j5;
                        }
                    } else {
                        while (j2 > j) {
                            segment = segment.prev;
                            j2 -= (long) (segment.limit - segment.pos);
                        }
                        segmentPush = segment;
                        j3 = j2;
                    }
                    if (this.readWrite && segmentPush.shared) {
                        dc.squareup.okio.Segment segmentUnsharedCopy = segmentPush.unsharedCopy();
                        dc.squareup.okio.Buffer buffer2 = this.buffer;
                        if (buffer2.head == segmentPush) {
                            buffer2.head = segmentUnsharedCopy;
                        }
                        segmentPush = segmentPush.push(segmentUnsharedCopy);
                        segmentPush.prev.pop();
                    }
                    this.segment = segmentPush;
                    this.offset = j;
                    this.data = segmentPush.data;
                    int i = segmentPush.pos + ((int) (j - j3));
                    this.start = i;
                    int i2 = segmentPush.limit;
                    this.end = i2;
                    return i2 - i;
                }
            }
            throw new java.lang.ArrayIndexOutOfBoundsException(java.lang.String.format("offset=%s > size=%s", java.lang.Long.valueOf(j), java.lang.Long.valueOf(this.buffer.size)));
        }
    }

    private dc.squareup.okio.ByteString digest(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str);
            dc.squareup.okio.Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i = segment.pos;
                messageDigest.update(bArr, i, segment.limit - i);
                dc.squareup.okio.Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i2 = segment2.pos;
                    messageDigest.update(bArr2, i2, segment2.limit - i2);
                }
            }
            return dc.squareup.okio.ByteString.of(messageDigest.digest());
        } catch (java.security.NoSuchAlgorithmException unused) {
            throw new java.lang.AssertionError();
        }
    }

    @Override // dc.squareup.okio.BufferedSource, dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer buffer() {
        return this;
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (java.io.EOFException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    @Override // dc.squareup.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long j = this.size;
        if (j == 0) {
            return 0L;
        }
        dc.squareup.okio.Segment segment = this.head.prev;
        int i = segment.limit;
        return (i >= 8192 || !segment.owner) ? j : j - ((long) (i - segment.pos));
    }

    public final dc.squareup.okio.Buffer copyTo(java.io.OutputStream outputStream) throws java.io.IOException {
        return copyTo(outputStream, 0L, this.size);
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink emit() {
        return this;
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dc.squareup.okio.Buffer)) {
            return false;
        }
        dc.squareup.okio.Buffer buffer = (dc.squareup.okio.Buffer) obj;
        long j = this.size;
        if (j != buffer.size) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        dc.squareup.okio.Segment segment = this.head;
        dc.squareup.okio.Segment segment2 = buffer.head;
        int i = segment.pos;
        int i2 = segment2.pos;
        while (j2 < this.size) {
            long jMin = java.lang.Math.min(segment.limit - i, segment2.limit - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (segment.data[i] != segment2.data[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == segment.limit) {
                segment = segment.next;
                i = segment.pos;
            }
            if (i2 == segment2.limit) {
                segment2 = segment2.next;
                i2 = segment2.pos;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // dc.squareup.okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // dc.squareup.okio.BufferedSink, dc.squareup.okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // dc.squareup.okio.BufferedSource
    public dc.squareup.okio.Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long j) {
        dc.squareup.okio.Util.checkOffsetAndCount(this.size, j, 1L);
        long j2 = this.size;
        if (j2 - j > j) {
            dc.squareup.okio.Segment segment = this.head;
            long j3 = j;
            while (true) {
                int i = segment.limit;
                int i2 = segment.pos;
                long j4 = i - i2;
                if (j3 < j4) {
                    return segment.data[i2 + ((int) j3)];
                }
                j3 -= j4;
                segment = segment.next;
            }
        } else {
            long j5 = j - j2;
            dc.squareup.okio.Segment segment2 = this.head.prev;
            while (true) {
                int i3 = segment2.limit;
                int i4 = segment2.pos;
                j5 += (long) (i3 - i4);
                if (j5 >= 0) {
                    return segment2.data[i4 + ((int) j5)];
                }
                segment2 = segment2.prev;
            }
        }
    }

    public int hashCode() {
        dc.squareup.okio.Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
        } while (segment != this.head);
        return i;
    }

    @Override // dc.squareup.okio.BufferedSource
    public long indexOf(byte b) {
        return indexOf(b, 0L, Long.MAX_VALUE);
    }

    @Override // dc.squareup.okio.BufferedSource
    public long indexOfElement(dc.squareup.okio.ByteString byteString) {
        return indexOfElement(byteString, 0L);
    }

    @Override // dc.squareup.okio.BufferedSource
    public java.io.InputStream inputStream() {
        return new java.io.InputStream() { // from class: dc.squareup.okio.Buffer.2
            @Override // java.io.InputStream
            public int available() {
                return (int) java.lang.Math.min(dc.squareup.okio.Buffer.this.size, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                dc.squareup.okio.Buffer buffer = dc.squareup.okio.Buffer.this;
                if (buffer.size > 0) {
                    return buffer.readByte() & 255;
                }
                return -1;
            }

            public java.lang.String toString() {
                return dc.squareup.okio.Buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return dc.squareup.okio.Buffer.this.read(bArr, i, i2);
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final dc.squareup.okio.ByteString md5() {
        return digest(io.dcloud.common.util.Md5Utils.ALGORITHM);
    }

    @Override // dc.squareup.okio.BufferedSink
    public java.io.OutputStream outputStream() {
        return new java.io.OutputStream() { // from class: dc.squareup.okio.Buffer.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            public java.lang.String toString() {
                return dc.squareup.okio.Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                dc.squareup.okio.Buffer.this.writeByte((int) ((byte) i));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                dc.squareup.okio.Buffer.this.write(bArr, i, i2);
            }
        };
    }

    @Override // dc.squareup.okio.BufferedSource
    public dc.squareup.okio.BufferedSource peek() {
        return dc.squareup.okio.Okio.buffer(new dc.squareup.okio.PeekSource(this));
    }

    @Override // dc.squareup.okio.BufferedSource
    public boolean rangeEquals(long j, dc.squareup.okio.ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    @Override // dc.squareup.okio.BufferedSource
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // dc.squareup.okio.BufferedSource
    public long readAll(dc.squareup.okio.Sink sink) throws java.io.IOException {
        long j = this.size;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public final dc.squareup.okio.Buffer.UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new dc.squareup.okio.Buffer.UnsafeCursor());
    }

    @Override // dc.squareup.okio.BufferedSource
    public byte readByte() {
        long j = this.size;
        if (j == 0) {
            throw new java.lang.IllegalStateException("size == 0");
        }
        dc.squareup.okio.Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        int i3 = i + 1;
        byte b = segment.data[i];
        this.size = j - 1;
        if (i3 != i2) {
            segment.pos = i3;
            return b;
        }
        this.head = segment.pop();
        dc.squareup.okio.SegmentPool.recycle(segment);
        return b;
    }

    @Override // dc.squareup.okio.BufferedSource
    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (java.io.EOFException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    @Override // dc.squareup.okio.BufferedSource
    public dc.squareup.okio.ByteString readByteString() {
        return new dc.squareup.okio.ByteString(readByteArray());
    }

    @Override // dc.squareup.okio.BufferedSource
    public long readDecimalLong() {
        if (this.size == 0) {
            throw new java.lang.IllegalStateException("size == 0");
        }
        int i = 0;
        long j = -7;
        boolean z = false;
        long j2 = 0;
        boolean z2 = false;
        do {
            dc.squareup.okio.Segment segment = this.head;
            byte[] bArr = segment.data;
            int i2 = segment.pos;
            int i3 = segment.limit;
            while (i2 < i3) {
                byte b = bArr[i2];
                if (b >= 48 && b <= 57) {
                    int i4 = 48 - b;
                    if (j2 < -922337203685477580L || (j2 == -922337203685477580L && i4 < j)) {
                        dc.squareup.okio.Buffer bufferWriteByte = new dc.squareup.okio.Buffer().writeDecimalLong(j2).writeByte((int) b);
                        if (!z) {
                            bufferWriteByte.readByte();
                        }
                        throw new java.lang.NumberFormatException("Number too large: " + bufferWriteByte.readUtf8());
                    }
                    j2 = (j2 * 10) + ((long) i4);
                } else {
                    if (b != 45 || i != 0) {
                        if (i != 0) {
                            z2 = true;
                            break;
                        }
                        throw new java.lang.NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + java.lang.Integer.toHexString(b));
                    }
                    j--;
                    z = true;
                }
                i2++;
                i++;
            }
            if (i2 == i3) {
                this.head = segment.pop();
                dc.squareup.okio.SegmentPool.recycle(segment);
            } else {
                segment.pos = i2;
            }
            if (z2) {
                break;
            }
        } while (this.head != null);
        this.size -= (long) i;
        return z ? j2 : -j2;
    }

    public final dc.squareup.okio.Buffer readFrom(java.io.InputStream inputStream) throws java.io.IOException {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    @Override // dc.squareup.okio.BufferedSource
    public void readFully(dc.squareup.okio.Buffer buffer, long j) throws java.io.EOFException {
        long j2 = this.size;
        if (j2 >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, j2);
            throw new java.io.EOFException();
        }
    }

    @Override // dc.squareup.okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        int i;
        if (this.size == 0) {
            throw new java.lang.IllegalStateException("size == 0");
        }
        int i2 = 0;
        long j = 0;
        boolean z = false;
        do {
            dc.squareup.okio.Segment segment = this.head;
            byte[] bArr = segment.data;
            int i3 = segment.pos;
            int i4 = segment.limit;
            while (i3 < i4) {
                byte b = bArr[i3];
                if (b >= 48 && b <= 57) {
                    i = b - 48;
                } else if (b >= 97 && b <= 102) {
                    i = b - 87;
                } else {
                    if (b < 65 || b > 70) {
                        if (i2 != 0) {
                            z = true;
                            break;
                        }
                        throw new java.lang.NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + java.lang.Integer.toHexString(b));
                    }
                    i = b - 55;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    throw new java.lang.NumberFormatException("Number too large: " + new dc.squareup.okio.Buffer().writeHexadecimalUnsignedLong(j).writeByte((int) b).readUtf8());
                }
                j = (j << 4) | ((long) i);
                i3++;
                i2++;
            }
            if (i3 == i4) {
                this.head = segment.pop();
                dc.squareup.okio.SegmentPool.recycle(segment);
            } else {
                segment.pos = i3;
            }
            if (z) {
                break;
            }
        } while (this.head != null);
        this.size -= (long) i2;
        return j;
    }

    @Override // dc.squareup.okio.BufferedSource
    public int readInt() {
        long j = this.size;
        if (j < 4) {
            throw new java.lang.IllegalStateException("size < 4: " + this.size);
        }
        dc.squareup.okio.Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment.data;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & 255) | i4;
        this.size = j - 4;
        if (i5 != i2) {
            segment.pos = i5;
            return i6;
        }
        this.head = segment.pop();
        dc.squareup.okio.SegmentPool.recycle(segment);
        return i6;
    }

    @Override // dc.squareup.okio.BufferedSource
    public int readIntLe() {
        return dc.squareup.okio.Util.reverseBytesInt(readInt());
    }

    @Override // dc.squareup.okio.BufferedSource
    public long readLong() {
        long j = this.size;
        if (j < 8) {
            throw new java.lang.IllegalStateException("size < 8: " + this.size);
        }
        dc.squareup.okio.Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 8) {
            return ((((long) readInt()) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT) << 32) | (net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) readInt()));
        }
        byte[] bArr = segment.data;
        int i3 = i + 7;
        long j2 = ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
        int i4 = i + 8;
        long j3 = j2 | (((long) bArr[i3]) & 255);
        this.size = j - 8;
        if (i4 != i2) {
            segment.pos = i4;
            return j3;
        }
        this.head = segment.pop();
        dc.squareup.okio.SegmentPool.recycle(segment);
        return j3;
    }

    @Override // dc.squareup.okio.BufferedSource
    public long readLongLe() {
        return dc.squareup.okio.Util.reverseBytesLong(readLong());
    }

    @Override // dc.squareup.okio.BufferedSource
    public short readShort() {
        long j = this.size;
        if (j < 2) {
            throw new java.lang.IllegalStateException("size < 2: " + this.size);
        }
        dc.squareup.okio.Segment segment = this.head;
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment.data;
        int i3 = i + 1;
        int i4 = (bArr[i] & 255) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & 255) | i4;
        this.size = j - 2;
        if (i5 == i2) {
            this.head = segment.pop();
            dc.squareup.okio.SegmentPool.recycle(segment);
        } else {
            segment.pos = i5;
        }
        return (short) i6;
    }

    @Override // dc.squareup.okio.BufferedSource
    public short readShortLe() {
        return dc.squareup.okio.Util.reverseBytesShort(readShort());
    }

    @Override // dc.squareup.okio.BufferedSource
    public java.lang.String readString(java.nio.charset.Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (java.io.EOFException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public final dc.squareup.okio.Buffer.UnsafeCursor readUnsafe() {
        return readUnsafe(new dc.squareup.okio.Buffer.UnsafeCursor());
    }

    @Override // dc.squareup.okio.BufferedSource
    public java.lang.String readUtf8() {
        try {
            return readString(this.size, dc.squareup.okio.Util.UTF_8);
        } catch (java.io.EOFException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    @Override // dc.squareup.okio.BufferedSource
    public int readUtf8CodePoint() throws java.io.EOFException {
        int i;
        int i2;
        int i3;
        if (this.size == 0) {
            throw new java.io.EOFException();
        }
        byte b = getByte(0L);
        if ((b & kotlin.jvm.internal.ByteCompanionObject.MIN_VALUE) == 0) {
            i = b & kotlin.jvm.internal.ByteCompanionObject.MAX_VALUE;
            i2 = 1;
            i3 = 0;
        } else if ((b & 224) == 192) {
            i = b & 31;
            i2 = 2;
            i3 = 128;
        } else if ((b & 240) == 224) {
            i = b & 15;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((b & 248) != 240) {
                skip(1L);
                return REPLACEMENT_CHARACTER;
            }
            i = b & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (this.size < j) {
            throw new java.io.EOFException("size < " + i2 + ": " + this.size + " (to read code point prefixed 0x" + java.lang.Integer.toHexString(b) + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte b2 = getByte(j2);
            if ((b2 & 192) != 128) {
                skip(j2);
                return REPLACEMENT_CHARACTER;
            }
            i = (i << 6) | (b2 & 63);
        }
        skip(j);
        if (i > 1114111) {
            return REPLACEMENT_CHARACTER;
        }
        return ((i < 55296 || i > 57343) && i >= i3) ? i : REPLACEMENT_CHARACTER;
    }

    @Override // dc.squareup.okio.BufferedSource
    public java.lang.String readUtf8Line() throws java.io.EOFException {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return readUtf8Line(jIndexOf);
        }
        long j = this.size;
        if (j != 0) {
            return readUtf8(j);
        }
        return null;
    }

    @Override // dc.squareup.okio.BufferedSource
    public java.lang.String readUtf8LineStrict() throws java.io.EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // dc.squareup.okio.BufferedSource
    public boolean request(long j) {
        return this.size >= j;
    }

    @Override // dc.squareup.okio.BufferedSource
    public void require(long j) throws java.io.EOFException {
        if (this.size < j) {
            throw new java.io.EOFException();
        }
    }

    java.util.List<java.lang.Integer> segmentSizes() {
        if (this.head == null) {
            return java.util.Collections.EMPTY_LIST;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        dc.squareup.okio.Segment segment = this.head;
        arrayList.add(java.lang.Integer.valueOf(segment.limit - segment.pos));
        for (dc.squareup.okio.Segment segment2 = this.head.next; segment2 != this.head; segment2 = segment2.next) {
            arrayList.add(java.lang.Integer.valueOf(segment2.limit - segment2.pos));
        }
        return arrayList;
    }

    @Override // dc.squareup.okio.BufferedSource
    public int select(dc.squareup.okio.Options options) {
        int iSelectPrefix = selectPrefix(options, false);
        if (iSelectPrefix == -1) {
            return -1;
        }
        try {
            skip(options.byteStrings[iSelectPrefix].size());
            return iSelectPrefix;
        } catch (java.io.EOFException unused) {
            throw new java.lang.AssertionError();
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0095 A[LOOP:0: B:9:0x0020->B:48:0x0095, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x0094 A[SYNTHETIC] */
    int selectPrefix(dc.squareup.okio.Options options, boolean z) {
        int i;
        int i2;
        dc.squareup.okio.Segment segment;
        int i3;
        int i4;
        dc.squareup.okio.Segment segment2 = this.head;
        int i5 = -2;
        if (segment2 == null) {
            if (z) {
                return -2;
            }
            return options.indexOf(dc.squareup.okio.ByteString.EMPTY);
        }
        byte[] bArr = segment2.data;
        int i6 = segment2.pos;
        int i7 = segment2.limit;
        int[] iArr = options.trie;
        dc.squareup.okio.Segment segment3 = segment2;
        int i8 = 0;
        int i9 = -1;
        loop0: while (true) {
            int i10 = i8 + 1;
            int i11 = iArr[i8];
            int i12 = i8 + 2;
            int i13 = iArr[i10];
            if (i13 != -1) {
                i9 = i13;
            }
            if (segment3 == null) {
                break;
            }
            if (i11 >= 0) {
                int i14 = i6 + 1;
                int i15 = bArr[i6] & 255;
                int i16 = i12 + i11;
                while (i12 != i16) {
                    if (i15 == iArr[i12]) {
                        i = iArr[i12 + i11];
                        if (i14 == i7) {
                            segment3 = segment3.next;
                            i2 = segment3.pos;
                            bArr = segment3.data;
                            i7 = segment3.limit;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        } else {
                            i2 = i14;
                        }
                        if (i >= 0) {
                            return i;
                        }
                        i8 = -i;
                        i6 = i2;
                        i5 = -2;
                    } else {
                        i12++;
                    }
                }
            }
            int i17 = i12 + (i11 * (-1));
            while (true) {
                int i18 = i6 + 1;
                int i19 = i12 + 1;
                if ((bArr[i6] & 255) == iArr[i12]) {
                    boolean z2 = i19 == i17;
                    if (i18 == i7) {
                        dc.squareup.okio.Segment segment4 = segment3.next;
                        i4 = segment4.pos;
                        byte[] bArr2 = segment4.data;
                        i3 = segment4.limit;
                        if (segment4 != segment2) {
                            segment = segment4;
                            bArr = bArr2;
                        } else {
                            if (!z2) {
                                break loop0;
                            }
                            bArr = bArr2;
                            segment = null;
                        }
                    } else {
                        segment = segment3;
                        i3 = i7;
                        i4 = i18;
                    }
                    if (z2) {
                        i = iArr[i19];
                        i2 = i4;
                        i7 = i3;
                        segment3 = segment;
                        break;
                    }
                    i6 = i4;
                    i7 = i3;
                    segment3 = segment;
                    i12 = i19;
                }
            }
            if (i >= 0) {
                return i;
            }
            i8 = -i;
            i6 = i2;
            i5 = -2;
        }
        return z ? i5 : i9;
    }

    public final dc.squareup.okio.ByteString sha1() {
        return digest("SHA-1");
    }

    public final dc.squareup.okio.ByteString sha256() {
        return digest("SHA-256");
    }

    public final dc.squareup.okio.ByteString sha512() {
        return digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    @Override // dc.squareup.okio.BufferedSource
    public void skip(long j) throws java.io.EOFException {
        while (j > 0) {
            dc.squareup.okio.Segment segment = this.head;
            if (segment == null) {
                throw new java.io.EOFException();
            }
            int iMin = (int) java.lang.Math.min(j, segment.limit - segment.pos);
            long j2 = iMin;
            this.size -= j2;
            j -= j2;
            dc.squareup.okio.Segment segment2 = this.head;
            int i = segment2.pos + iMin;
            segment2.pos = i;
            if (i == segment2.limit) {
                this.head = segment2.pop();
                dc.squareup.okio.SegmentPool.recycle(segment2);
            }
        }
    }

    public final dc.squareup.okio.ByteString snapshot() {
        long j = this.size;
        if (j <= 2147483647L) {
            return snapshot((int) j);
        }
        throw new java.lang.IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    @Override // dc.squareup.okio.Source
    public dc.squareup.okio.Timeout timeout() {
        return dc.squareup.okio.Timeout.NONE;
    }

    public java.lang.String toString() {
        return snapshot().toString();
    }

    dc.squareup.okio.Segment writableSegment(int i) {
        if (i < 1 || i > 8192) {
            throw new java.lang.IllegalArgumentException();
        }
        dc.squareup.okio.Segment segment = this.head;
        if (segment != null) {
            dc.squareup.okio.Segment segment2 = segment.prev;
            return (segment2.limit + i > 8192 || !segment2.owner) ? segment2.push(dc.squareup.okio.SegmentPool.take()) : segment2;
        }
        dc.squareup.okio.Segment segmentTake = dc.squareup.okio.SegmentPool.take();
        this.head = segmentTake;
        segmentTake.prev = segmentTake;
        segmentTake.next = segmentTake;
        return segmentTake;
    }

    @Override // dc.squareup.okio.BufferedSink
    public long writeAll(dc.squareup.okio.Source source) throws java.io.IOException {
        if (source == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long j2 = source.read(this, tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_CENTER);
            if (j2 == -1) {
                return j;
            }
            j += j2;
        }
    }

    public final dc.squareup.okio.Buffer writeTo(java.io.OutputStream outputStream) throws java.io.IOException {
        return writeTo(outputStream, this.size);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public dc.squareup.okio.Buffer m405clone() {
        dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
        if (this.size == 0) {
            return buffer;
        }
        dc.squareup.okio.Segment segmentSharedCopy = this.head.sharedCopy();
        buffer.head = segmentSharedCopy;
        segmentSharedCopy.prev = segmentSharedCopy;
        segmentSharedCopy.next = segmentSharedCopy;
        for (dc.squareup.okio.Segment segment = this.head.next; segment != this.head; segment = segment.next) {
            buffer.head.prev.push(segment.sharedCopy());
        }
        buffer.size = this.size;
        return buffer;
    }

    public final dc.squareup.okio.Buffer copyTo(java.io.OutputStream outputStream, long j, long j2) throws java.io.IOException {
        if (outputStream == null) {
            throw new java.lang.IllegalArgumentException("out == null");
        }
        long j3 = j;
        dc.squareup.okio.Util.checkOffsetAndCount(this.size, j3, j2);
        if (j2 != 0) {
            dc.squareup.okio.Segment segment = this.head;
            while (true) {
                long j4 = segment.limit - segment.pos;
                if (j3 < j4) {
                    break;
                }
                j3 -= j4;
                segment = segment.next;
            }
            dc.squareup.okio.Segment segment2 = segment;
            long j5 = j2;
            while (j5 > 0) {
                int i = (int) (((long) segment2.pos) + j3);
                int iMin = (int) java.lang.Math.min(segment2.limit - i, j5);
                outputStream.write(segment2.data, i, iMin);
                j5 -= (long) iMin;
                segment2 = segment2.next;
                j3 = 0;
            }
        }
        return this;
    }

    @Override // dc.squareup.okio.BufferedSource
    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    @Override // dc.squareup.okio.BufferedSource
    public long indexOfElement(dc.squareup.okio.ByteString byteString, long j) {
        int i;
        int i2;
        long j2 = 0;
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("fromIndex < 0");
        }
        dc.squareup.okio.Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        long j3 = this.size;
        if (j3 - j < j) {
            while (j3 > j) {
                segment = segment.prev;
                j3 -= (long) (segment.limit - segment.pos);
            }
        } else {
            while (true) {
                long j4 = ((long) (segment.limit - segment.pos)) + j2;
                if (j4 >= j) {
                    break;
                }
                segment = segment.next;
                j2 = j4;
            }
            j3 = j2;
        }
        if (byteString.size() == 2) {
            byte b = byteString.getByte(0);
            byte b2 = byteString.getByte(1);
            while (j3 < this.size) {
                byte[] bArr = segment.data;
                i = (int) ((((long) segment.pos) + j) - j3);
                int i3 = segment.limit;
                while (i < i3) {
                    byte b3 = bArr[i];
                    if (b3 == b || b3 == b2) {
                        i2 = segment.pos;
                        return ((long) (i - i2)) + j3;
                    }
                    i++;
                }
                j3 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                j = j3;
            }
            return -1L;
        }
        byte[] bArrInternalArray = byteString.internalArray();
        while (j3 < this.size) {
            byte[] bArr2 = segment.data;
            i = (int) ((((long) segment.pos) + j) - j3);
            int i4 = segment.limit;
            while (i < i4) {
                byte b4 = bArr2[i];
                for (byte b5 : bArrInternalArray) {
                    if (b4 == b5) {
                        i2 = segment.pos;
                        return ((long) (i - i2)) + j3;
                    }
                }
                i++;
            }
            j3 += (long) (segment.limit - segment.pos);
            segment = segment.next;
            j = j3;
        }
        return -1L;
    }

    @Override // dc.squareup.okio.BufferedSource
    public boolean rangeEquals(long j, dc.squareup.okio.ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.size - j < i2 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(((long) i3) + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // dc.squareup.okio.BufferedSource
    public int read(byte[] bArr, int i, int i2) {
        dc.squareup.okio.Util.checkOffsetAndCount(bArr.length, i, i2);
        dc.squareup.okio.Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = java.lang.Math.min(i2, segment.limit - segment.pos);
        java.lang.System.arraycopy(segment.data, segment.pos, bArr, i, iMin);
        int i3 = segment.pos + iMin;
        segment.pos = i3;
        this.size -= (long) iMin;
        if (i3 == segment.limit) {
            this.head = segment.pop();
            dc.squareup.okio.SegmentPool.recycle(segment);
        }
        return iMin;
    }

    public final dc.squareup.okio.Buffer.UnsafeCursor readAndWriteUnsafe(dc.squareup.okio.Buffer.UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new java.lang.IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    @Override // dc.squareup.okio.BufferedSource
    public dc.squareup.okio.ByteString readByteString(long j) throws java.io.EOFException {
        return new dc.squareup.okio.ByteString(readByteArray(j));
    }

    public final dc.squareup.okio.Buffer readFrom(java.io.InputStream inputStream, long j) throws java.io.IOException {
        if (j >= 0) {
            readFrom(inputStream, j, false);
            return this;
        }
        throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
    }

    public final dc.squareup.okio.Buffer.UnsafeCursor readUnsafe(dc.squareup.okio.Buffer.UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new java.lang.IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    @Override // dc.squareup.okio.BufferedSource
    public java.lang.String readUtf8LineStrict(long j) throws java.io.EOFException {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jIndexOf = indexOf((byte) 10, 0L, j2);
        if (jIndexOf != -1) {
            return readUtf8Line(jIndexOf);
        }
        if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
            return readUtf8Line(j2);
        }
        dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
        copyTo(buffer, 0L, java.lang.Math.min(32L, size()));
        throw new java.io.EOFException("\\n not found: limit=" + java.lang.Math.min(size(), j) + " content=" + buffer.readByteString().hex() + kotlin.text.Typography.ellipsis);
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer writeByte(int i) {
        dc.squareup.okio.Segment segmentWritableSegment = writableSegment(1);
        byte[] bArr = segmentWritableSegment.data;
        int i2 = segmentWritableSegment.limit;
        segmentWritableSegment.limit = i2 + 1;
        bArr[i2] = (byte) i;
        this.size++;
        return this;
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer writeDecimalLong(long j) {
        boolean z;
        if (j == 0) {
            return writeByte(48);
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j < 100000000) {
            if (j < 10000) {
                if (j >= 100) {
                    i = j < 1000 ? 3 : 4;
                } else if (j >= 10) {
                    i = 2;
                }
            } else if (j < 1000000) {
                i = j < 100000 ? 5 : 6;
            } else {
                i = j < 10000000 ? 7 : 8;
            }
        } else if (j < 1000000000000L) {
            if (j < 10000000000L) {
                i = j < 1000000000 ? 9 : 10;
            } else {
                i = j < 100000000000L ? 11 : 12;
            }
        } else if (j < 1000000000000000L) {
            if (j < 10000000000000L) {
                i = 13;
            } else {
                i = j < 100000000000000L ? 14 : 15;
            }
        } else if (j < 100000000000000000L) {
            i = j < 10000000000000000L ? 16 : 17;
        } else {
            i = j < 1000000000000000000L ? 18 : 19;
        }
        if (z) {
            i++;
        }
        dc.squareup.okio.Segment segmentWritableSegment = writableSegment(i);
        byte[] bArr = segmentWritableSegment.data;
        int i2 = segmentWritableSegment.limit + i;
        while (j != 0) {
            i2--;
            bArr[i2] = DIGITS[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        segmentWritableSegment.limit += i;
        this.size += (long) i;
        return this;
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int iNumberOfTrailingZeros = (java.lang.Long.numberOfTrailingZeros(java.lang.Long.highestOneBit(j)) / 4) + 1;
        dc.squareup.okio.Segment segmentWritableSegment = writableSegment(iNumberOfTrailingZeros);
        byte[] bArr = segmentWritableSegment.data;
        int i = segmentWritableSegment.limit;
        for (int i2 = (i + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = DIGITS[(int) (15 & j)];
            j >>>= 4;
        }
        segmentWritableSegment.limit += iNumberOfTrailingZeros;
        this.size += (long) iNumberOfTrailingZeros;
        return this;
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer writeInt(int i) {
        dc.squareup.okio.Segment segmentWritableSegment = writableSegment(4);
        byte[] bArr = segmentWritableSegment.data;
        int i2 = segmentWritableSegment.limit;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        segmentWritableSegment.limit = i2 + 4;
        this.size += 4;
        return this;
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer writeIntLe(int i) {
        return writeInt(dc.squareup.okio.Util.reverseBytesInt(i));
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer writeLong(long j) {
        dc.squareup.okio.Segment segmentWritableSegment = writableSegment(8);
        byte[] bArr = segmentWritableSegment.data;
        int i = segmentWritableSegment.limit;
        bArr[i] = (byte) ((j >>> 56) & 255);
        bArr[i + 1] = (byte) ((j >>> 48) & 255);
        bArr[i + 2] = (byte) ((j >>> 40) & 255);
        bArr[i + 3] = (byte) ((j >>> 32) & 255);
        bArr[i + 4] = (byte) ((j >>> 24) & 255);
        bArr[i + 5] = (byte) ((j >>> 16) & 255);
        bArr[i + 6] = (byte) ((j >>> 8) & 255);
        bArr[i + 7] = (byte) (j & 255);
        segmentWritableSegment.limit = i + 8;
        this.size += 8;
        return this;
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer writeLongLe(long j) {
        return writeLong(dc.squareup.okio.Util.reverseBytesLong(j));
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer writeShort(int i) {
        dc.squareup.okio.Segment segmentWritableSegment = writableSegment(2);
        byte[] bArr = segmentWritableSegment.data;
        int i2 = segmentWritableSegment.limit;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        segmentWritableSegment.limit = i2 + 2;
        this.size += 2;
        return this;
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer writeShortLe(int i) {
        return writeShort((int) dc.squareup.okio.Util.reverseBytesShort((short) i));
    }

    public final dc.squareup.okio.Buffer writeTo(java.io.OutputStream outputStream, long j) throws java.io.IOException {
        if (outputStream == null) {
            throw new java.lang.IllegalArgumentException("out == null");
        }
        dc.squareup.okio.Util.checkOffsetAndCount(this.size, 0L, j);
        dc.squareup.okio.Segment segment = this.head;
        long j2 = j;
        while (j2 > 0) {
            int iMin = (int) java.lang.Math.min(j2, segment.limit - segment.pos);
            outputStream.write(segment.data, segment.pos, iMin);
            int i = segment.pos + iMin;
            segment.pos = i;
            long j3 = iMin;
            this.size -= j3;
            j2 -= j3;
            if (i == segment.limit) {
                dc.squareup.okio.Segment segmentPop = segment.pop();
                this.head = segmentPop;
                dc.squareup.okio.SegmentPool.recycle(segment);
                segment = segmentPop;
            }
        }
        return this;
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer writeUtf8CodePoint(int i) {
        if (i < 128) {
            writeByte(i);
            return this;
        }
        if (i < 2048) {
            writeByte((i >> 6) | 192);
            writeByte((i & 63) | 128);
            return this;
        }
        if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                writeByte(63);
                return this;
            }
            writeByte((i >> 12) | 224);
            writeByte(((i >> 6) & 63) | 128);
            writeByte((i & 63) | 128);
            return this;
        }
        if (i > 1114111) {
            throw new java.lang.IllegalArgumentException("Unexpected code point: " + java.lang.Integer.toHexString(i));
        }
        writeByte((i >> 18) | org.mozilla.universalchardet.prober.HebrewProber.NORMAL_NUN);
        writeByte(((i >> 12) & 63) | 128);
        writeByte(((i >> 6) & 63) | 128);
        writeByte((i & 63) | 128);
        return this;
    }

    @Override // dc.squareup.okio.BufferedSource
    public long indexOf(byte b, long j, long j2) {
        dc.squareup.okio.Segment segment;
        long j3 = 0;
        if (j >= 0 && j2 >= j) {
            long j4 = this.size;
            long j5 = j2 > j4 ? j4 : j2;
            if (j == j5 || (segment = this.head) == null) {
                return -1L;
            }
            if (j4 - j < j) {
                while (j4 > j) {
                    segment = segment.prev;
                    j4 -= (long) (segment.limit - segment.pos);
                }
            } else {
                while (true) {
                    long j6 = ((long) (segment.limit - segment.pos)) + j3;
                    if (j6 >= j) {
                        break;
                    }
                    segment = segment.next;
                    j3 = j6;
                }
                j4 = j3;
            }
            long j7 = j;
            while (j4 < j5) {
                byte[] bArr = segment.data;
                int iMin = (int) java.lang.Math.min(segment.limit, (((long) segment.pos) + j5) - j4);
                for (int i = (int) ((((long) segment.pos) + j7) - j4); i < iMin; i++) {
                    if (bArr[i] == b) {
                        return ((long) (i - segment.pos)) + j4;
                    }
                }
                j4 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                j7 = j4;
            }
            return -1L;
        }
        throw new java.lang.IllegalArgumentException(java.lang.String.format("size=%s fromIndex=%s toIndex=%s", java.lang.Long.valueOf(this.size), java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2)));
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer writeString(java.lang.String str, java.nio.charset.Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer writeUtf8(java.lang.String str) {
        return writeUtf8(str, 0, str.length());
    }

    private void readFrom(java.io.InputStream inputStream, long j, boolean z) throws java.io.IOException {
        if (inputStream == null) {
            throw new java.lang.IllegalArgumentException("in == null");
        }
        while (true) {
            if (j <= 0 && !z) {
                return;
            }
            dc.squareup.okio.Segment segmentWritableSegment = writableSegment(1);
            int i = inputStream.read(segmentWritableSegment.data, segmentWritableSegment.limit, (int) java.lang.Math.min(j, 8192 - segmentWritableSegment.limit));
            if (i == -1) {
                if (segmentWritableSegment.pos == segmentWritableSegment.limit) {
                    this.head = segmentWritableSegment.pop();
                    dc.squareup.okio.SegmentPool.recycle(segmentWritableSegment);
                }
                if (!z) {
                    throw new java.io.EOFException();
                }
                return;
            }
            segmentWritableSegment.limit += i;
            long j2 = i;
            this.size += j2;
            j -= j2;
        }
    }

    @Override // dc.squareup.okio.BufferedSource
    public byte[] readByteArray(long j) throws java.io.EOFException {
        dc.squareup.okio.Util.checkOffsetAndCount(this.size, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new java.lang.IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // dc.squareup.okio.BufferedSource
    public java.lang.String readString(long j, java.nio.charset.Charset charset) throws java.io.EOFException {
        dc.squareup.okio.Util.checkOffsetAndCount(this.size, 0L, j);
        if (charset == null) {
            throw new java.lang.IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new java.lang.IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        dc.squareup.okio.Segment segment = this.head;
        int i = segment.pos;
        if (((long) i) + j > segment.limit) {
            return new java.lang.String(readByteArray(j), charset);
        }
        java.lang.String str = new java.lang.String(segment.data, i, (int) j, charset);
        int i2 = (int) (((long) segment.pos) + j);
        segment.pos = i2;
        this.size -= j;
        if (i2 == segment.limit) {
            this.head = segment.pop();
            dc.squareup.okio.SegmentPool.recycle(segment);
        }
        return str;
    }

    @Override // dc.squareup.okio.BufferedSource
    public java.lang.String readUtf8(long j) throws java.io.EOFException {
        return readString(j, dc.squareup.okio.Util.UTF_8);
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer write(dc.squareup.okio.ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new java.lang.IllegalArgumentException("byteString == null");
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer writeString(java.lang.String str, int i, int i2, java.nio.charset.Charset charset) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new java.lang.IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                throw new java.lang.IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
            if (charset != null) {
                if (charset.equals(dc.squareup.okio.Util.UTF_8)) {
                    return writeUtf8(str, i, i2);
                }
                byte[] bytes = str.substring(i, i2).getBytes(charset);
                return write(bytes, 0, bytes.length);
            }
            throw new java.lang.IllegalArgumentException("charset == null");
        }
        throw new java.lang.IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer writeUtf8(java.lang.String str, int i, int i2) {
        char cCharAt;
        if (str == null) {
            throw new java.lang.IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                throw new java.lang.IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
            while (i < i2) {
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 < 128) {
                    dc.squareup.okio.Segment segmentWritableSegment = writableSegment(1);
                    byte[] bArr = segmentWritableSegment.data;
                    int i3 = segmentWritableSegment.limit - i;
                    int iMin = java.lang.Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt2;
                    while (true) {
                        i = i4;
                        if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                            break;
                        }
                        i4 = i + 1;
                        bArr[i + i3] = (byte) cCharAt;
                    }
                    int i5 = segmentWritableSegment.limit;
                    int i6 = (i3 + i) - i5;
                    segmentWritableSegment.limit = i5 + i6;
                    this.size += (long) i6;
                } else {
                    if (cCharAt2 < 2048) {
                        writeByte((cCharAt2 >> 6) | 192);
                        writeByte((cCharAt2 & com.taobao.weex.el.parse.Operators.CONDITION_IF) | 128);
                    } else if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                        int i7 = i + 1;
                        char cCharAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                        if (cCharAt2 <= 56319 && cCharAt3 >= 56320 && cCharAt3 <= 57343) {
                            int i8 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                            writeByte((i8 >> 18) | org.mozilla.universalchardet.prober.HebrewProber.NORMAL_NUN);
                            writeByte(((i8 >> 12) & 63) | 128);
                            writeByte(((i8 >> 6) & 63) | 128);
                            writeByte((i8 & 63) | 128);
                            i += 2;
                        } else {
                            writeByte(63);
                            i = i7;
                        }
                    } else {
                        writeByte((cCharAt2 >> '\f') | 224);
                        writeByte(((cCharAt2 >> 6) & 63) | 128);
                        writeByte((cCharAt2 & com.taobao.weex.el.parse.Operators.CONDITION_IF) | 128);
                    }
                    i++;
                }
            }
            return this;
        }
        throw new java.lang.IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    public final dc.squareup.okio.ByteString snapshot(int i) {
        if (i == 0) {
            return dc.squareup.okio.ByteString.EMPTY;
        }
        return new dc.squareup.okio.SegmentedByteString(this, i);
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new java.lang.IllegalArgumentException("source == null");
    }

    @Override // dc.squareup.okio.BufferedSource
    public void readFully(byte[] bArr) throws java.io.EOFException {
        int i = 0;
        while (i < bArr.length) {
            int i2 = read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                throw new java.io.EOFException();
            }
            i += i2;
        }
    }

    java.lang.String readUtf8Line(long j) throws java.io.EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (getByte(j2) == 13) {
                java.lang.String utf8 = readUtf8(j2);
                skip(2L);
                return utf8;
            }
        }
        java.lang.String utf9 = readUtf8(j);
        skip(1L);
        return utf9;
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            dc.squareup.okio.Util.checkOffsetAndCount(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                dc.squareup.okio.Segment segmentWritableSegment = writableSegment(1);
                int iMin = java.lang.Math.min(i3 - i, 8192 - segmentWritableSegment.limit);
                java.lang.System.arraycopy(bArr, i, segmentWritableSegment.data, segmentWritableSegment.limit, iMin);
                i += iMin;
                segmentWritableSegment.limit += iMin;
            }
            this.size += j;
            return this;
        }
        throw new java.lang.IllegalArgumentException("source == null");
    }

    private boolean rangeEquals(dc.squareup.okio.Segment segment, int i, dc.squareup.okio.ByteString byteString, int i2, int i3) {
        int i4 = segment.limit;
        byte[] bArr = segment.data;
        while (i2 < i3) {
            if (i == i4) {
                segment = segment.next;
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i = segment.pos;
                i4 = segment.limit;
            }
            if (bArr[i] != byteString.getByte(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        dc.squareup.okio.Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = java.lang.Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, iMin);
        int i = segment.pos + iMin;
        segment.pos = i;
        this.size -= (long) iMin;
        if (i == segment.limit) {
            this.head = segment.pop();
            dc.squareup.okio.SegmentPool.recycle(segment);
        }
        return iMin;
    }

    public final dc.squareup.okio.Buffer copyTo(dc.squareup.okio.Buffer buffer, long j, long j2) {
        if (buffer != null) {
            long j3 = j;
            dc.squareup.okio.Util.checkOffsetAndCount(this.size, j3, j2);
            if (j2 != 0) {
                buffer.size += j2;
                dc.squareup.okio.Segment segment = this.head;
                while (true) {
                    long j4 = segment.limit - segment.pos;
                    if (j3 < j4) {
                        break;
                    }
                    j3 -= j4;
                    segment = segment.next;
                }
                dc.squareup.okio.Segment segment2 = segment;
                long j5 = j2;
                while (j5 > 0) {
                    dc.squareup.okio.Segment segmentSharedCopy = segment2.sharedCopy();
                    int i = (int) (((long) segmentSharedCopy.pos) + j3);
                    segmentSharedCopy.pos = i;
                    segmentSharedCopy.limit = java.lang.Math.min(i + ((int) j5), segmentSharedCopy.limit);
                    dc.squareup.okio.Segment segment3 = buffer.head;
                    if (segment3 == null) {
                        segmentSharedCopy.prev = segmentSharedCopy;
                        segmentSharedCopy.next = segmentSharedCopy;
                        buffer.head = segmentSharedCopy;
                    } else {
                        segment3.prev.push(segmentSharedCopy);
                    }
                    j5 -= (long) (segmentSharedCopy.limit - segmentSharedCopy.pos);
                    segment2 = segment2.next;
                    j3 = 0;
                }
            }
            return this;
        }
        throw new java.lang.IllegalArgumentException("out == null");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        if (byteBuffer != null) {
            int iRemaining = byteBuffer.remaining();
            int i = iRemaining;
            while (i > 0) {
                dc.squareup.okio.Segment segmentWritableSegment = writableSegment(1);
                int iMin = java.lang.Math.min(i, 8192 - segmentWritableSegment.limit);
                byteBuffer.get(segmentWritableSegment.data, segmentWritableSegment.limit, iMin);
                i -= iMin;
                segmentWritableSegment.limit += iMin;
            }
            this.size += (long) iRemaining;
            return iRemaining;
        }
        throw new java.lang.IllegalArgumentException("source == null");
    }

    @Override // dc.squareup.okio.Source
    public long read(dc.squareup.okio.Buffer buffer, long j) {
        if (buffer == null) {
            throw new java.lang.IllegalArgumentException("sink == null");
        }
        if (j >= 0) {
            long j2 = this.size;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            buffer.write(this, j);
            return j;
        }
        throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // dc.squareup.okio.BufferedSink
    public dc.squareup.okio.BufferedSink write(dc.squareup.okio.Source source, long j) throws java.io.IOException {
        while (j > 0) {
            long j2 = source.read(this, j);
            if (j2 == -1) {
                throw new java.io.EOFException();
            }
            j -= j2;
        }
        return this;
    }

    @Override // dc.squareup.okio.Sink
    public void write(dc.squareup.okio.Buffer buffer, long j) {
        if (buffer == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        if (buffer != this) {
            dc.squareup.okio.Util.checkOffsetAndCount(buffer.size, 0L, j);
            while (j > 0) {
                dc.squareup.okio.Segment segment = buffer.head;
                if (j < segment.limit - segment.pos) {
                    dc.squareup.okio.Segment segment2 = this.head;
                    dc.squareup.okio.Segment segment3 = segment2 != null ? segment2.prev : null;
                    if (segment3 != null && segment3.owner) {
                        if ((((long) segment3.limit) + j) - ((long) (segment3.shared ? 0 : segment3.pos)) <= tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) {
                            segment.writeTo(segment3, (int) j);
                            buffer.size -= j;
                            this.size += j;
                            return;
                        }
                    }
                    buffer.head = segment.split((int) j);
                }
                dc.squareup.okio.Segment segment4 = buffer.head;
                long j2 = segment4.limit - segment4.pos;
                buffer.head = segment4.pop();
                dc.squareup.okio.Segment segment5 = this.head;
                if (segment5 == null) {
                    this.head = segment4;
                    segment4.prev = segment4;
                    segment4.next = segment4;
                } else {
                    segment5.prev.push(segment4).compact();
                }
                buffer.size -= j2;
                this.size += j2;
                j -= j2;
            }
            return;
        }
        throw new java.lang.IllegalArgumentException("source == this");
    }

    @Override // dc.squareup.okio.BufferedSource
    public long indexOf(dc.squareup.okio.ByteString byteString) throws java.io.IOException {
        return indexOf(byteString, 0L);
    }

    @Override // dc.squareup.okio.BufferedSource
    public long indexOf(dc.squareup.okio.ByteString byteString, long j) throws java.io.IOException {
        dc.squareup.okio.Buffer buffer = this;
        if (byteString.size() == 0) {
            throw new java.lang.IllegalArgumentException("bytes is empty");
        }
        long j2 = 0;
        if (j >= 0) {
            dc.squareup.okio.Segment segment = buffer.head;
            long j3 = -1;
            if (segment == null) {
                return -1L;
            }
            long j4 = buffer.size;
            if (j4 - j < j) {
                while (j4 > j) {
                    segment = segment.prev;
                    j4 -= (long) (segment.limit - segment.pos);
                }
            } else {
                while (true) {
                    long j5 = ((long) (segment.limit - segment.pos)) + j2;
                    if (j5 >= j) {
                        break;
                    }
                    segment = segment.next;
                    j2 = j5;
                }
                j4 = j2;
            }
            byte b = byteString.getByte(0);
            long j6 = j4;
            int size = byteString.size();
            long j7 = (buffer.size - ((long) size)) + 1;
            dc.squareup.okio.Segment segment2 = segment;
            long j8 = j;
            while (j6 < j7) {
                byte[] bArr = segment2.data;
                long j9 = j3;
                int iMin = (int) java.lang.Math.min(segment2.limit, (((long) segment2.pos) + j7) - j6);
                int i = (int) ((((long) segment2.pos) + j8) - j6);
                while (i < iMin) {
                    if (bArr[i] == b && buffer.rangeEquals(segment2, i + 1, byteString, 1, size)) {
                        return ((long) (i - segment2.pos)) + j6;
                    }
                    i++;
                    buffer = this;
                }
                j6 += (long) (segment2.limit - segment2.pos);
                segment2 = segment2.next;
                buffer = this;
                j8 = j6;
                j3 = j9;
            }
            return j3;
        }
        throw new java.lang.IllegalArgumentException("fromIndex < 0");
    }
}
