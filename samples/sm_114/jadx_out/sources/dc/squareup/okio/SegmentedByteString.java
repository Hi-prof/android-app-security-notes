package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class SegmentedByteString extends dc.squareup.okio.ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    SegmentedByteString(dc.squareup.okio.Buffer buffer, int i) {
        super(null);
        dc.squareup.okio.Util.checkOffsetAndCount(buffer.size, 0L, i);
        dc.squareup.okio.Segment segment = buffer.head;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = segment.limit;
            int i6 = segment.pos;
            if (i5 == i6) {
                throw new java.lang.AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            segment = segment.next;
        }
        this.segments = new byte[i4][];
        this.directory = new int[i4 * 2];
        dc.squareup.okio.Segment segment2 = buffer.head;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.segments;
            bArr[i7] = segment2.data;
            int i8 = segment2.limit;
            int i9 = segment2.pos;
            i2 += i8 - i9;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.directory;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            segment2.shared = true;
            i7++;
            segment2 = segment2.next;
        }
    }

    private int segment(int i) {
        int iBinarySearch = java.util.Arrays.binarySearch(this.directory, 0, this.segments.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    private dc.squareup.okio.ByteString toByteString() {
        return new dc.squareup.okio.ByteString(toByteArray());
    }

    private java.lang.Object writeReplace() {
        return toByteString();
    }

    @Override // dc.squareup.okio.ByteString
    public java.nio.ByteBuffer asByteBuffer() {
        return java.nio.ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // dc.squareup.okio.ByteString
    public java.lang.String base64() {
        return toByteString().base64();
    }

    @Override // dc.squareup.okio.ByteString
    public java.lang.String base64Url() {
        return toByteString().base64Url();
    }

    @Override // dc.squareup.okio.ByteString
    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof dc.squareup.okio.ByteString) {
            dc.squareup.okio.ByteString byteString = (dc.squareup.okio.ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @Override // dc.squareup.okio.ByteString
    public byte getByte(int i) {
        dc.squareup.okio.Util.checkOffsetAndCount(this.directory[this.segments.length - 1], i, 1L);
        int iSegment = segment(i);
        int i2 = iSegment == 0 ? 0 : this.directory[iSegment - 1];
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[iSegment][(i - i2) + iArr[bArr.length + iSegment]];
    }

    @Override // dc.squareup.okio.ByteString
    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int length = this.segments.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.segments[i2];
            int[] iArr = this.directory;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.hashCode = i4;
        return i4;
    }

    @Override // dc.squareup.okio.ByteString
    public java.lang.String hex() {
        return toByteString().hex();
    }

    @Override // dc.squareup.okio.ByteString
    public int indexOf(byte[] bArr, int i) {
        return toByteString().indexOf(bArr, i);
    }

    @Override // dc.squareup.okio.ByteString
    byte[] internalArray() {
        return toByteArray();
    }

    @Override // dc.squareup.okio.ByteString
    public int lastIndexOf(byte[] bArr, int i) {
        return toByteString().lastIndexOf(bArr, i);
    }

    @Override // dc.squareup.okio.ByteString
    public dc.squareup.okio.ByteString md5() {
        return toByteString().md5();
    }

    @Override // dc.squareup.okio.ByteString
    public boolean rangeEquals(int i, dc.squareup.okio.ByteString byteString, int i2, int i3) {
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int iSegment = segment(i);
        while (i3 > 0) {
            int i4 = iSegment == 0 ? 0 : this.directory[iSegment - 1];
            int iMin = java.lang.Math.min(i3, ((this.directory[iSegment] - i4) + i4) - i);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!byteString.rangeEquals(i2, bArr[iSegment], (i - i4) + iArr[bArr.length + iSegment], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iSegment++;
        }
        return true;
    }

    @Override // dc.squareup.okio.ByteString
    public dc.squareup.okio.ByteString sha1() {
        return toByteString().sha1();
    }

    @Override // dc.squareup.okio.ByteString
    public dc.squareup.okio.ByteString sha256() {
        return toByteString().sha256();
    }

    @Override // dc.squareup.okio.ByteString
    public int size() {
        return this.directory[this.segments.length - 1];
    }

    @Override // dc.squareup.okio.ByteString
    public java.lang.String string(java.nio.charset.Charset charset) {
        return toByteString().string(charset);
    }

    @Override // dc.squareup.okio.ByteString
    public dc.squareup.okio.ByteString substring(int i) {
        return toByteString().substring(i);
    }

    @Override // dc.squareup.okio.ByteString
    public dc.squareup.okio.ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // dc.squareup.okio.ByteString
    public dc.squareup.okio.ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // dc.squareup.okio.ByteString
    public byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.directory;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            java.lang.System.arraycopy(this.segments[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // dc.squareup.okio.ByteString
    public java.lang.String toString() {
        return toByteString().toString();
    }

    @Override // dc.squareup.okio.ByteString
    public java.lang.String utf8() {
        return toByteString().utf8();
    }

    @Override // dc.squareup.okio.ByteString
    public void write(java.io.OutputStream outputStream) throws java.io.IOException {
        if (outputStream == null) {
            throw new java.lang.IllegalArgumentException("out == null");
        }
        int length = this.segments.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.directory;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            outputStream.write(this.segments[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    @Override // dc.squareup.okio.ByteString
    public dc.squareup.okio.ByteString substring(int i, int i2) {
        return toByteString().substring(i, i2);
    }

    @Override // dc.squareup.okio.ByteString
    void write(dc.squareup.okio.Buffer buffer) {
        int length = this.segments.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.directory;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            dc.squareup.okio.Segment segment = new dc.squareup.okio.Segment(this.segments[i], i3, (i3 + i4) - i2, true, false);
            dc.squareup.okio.Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                segment2.prev.push(segment);
            }
            i++;
            i2 = i4;
        }
        buffer.size += (long) i2;
    }

    @Override // dc.squareup.okio.ByteString
    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iSegment = segment(i);
        while (i3 > 0) {
            int i4 = iSegment == 0 ? 0 : this.directory[iSegment - 1];
            int iMin = java.lang.Math.min(i3, ((this.directory[iSegment] - i4) + i4) - i);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!dc.squareup.okio.Util.arrayRangeEquals(bArr2[iSegment], (i - i4) + iArr[bArr2.length + iSegment], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iSegment++;
        }
        return true;
    }
}
