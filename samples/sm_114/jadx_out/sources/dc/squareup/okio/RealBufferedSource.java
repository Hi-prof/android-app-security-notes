package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class RealBufferedSource implements dc.squareup.okio.BufferedSource {
    public final dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
    boolean closed;
    public final dc.squareup.okio.Source source;

    RealBufferedSource(dc.squareup.okio.Source source) {
        if (source == null) {
            throw new java.lang.NullPointerException("source == null");
        }
        this.source = source;
    }

    @Override // dc.squareup.okio.BufferedSource, dc.squareup.okio.BufferedSink
    public dc.squareup.okio.Buffer buffer() {
        return this.buffer;
    }

    @Override // dc.squareup.okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.buffer.clear();
    }

    @Override // dc.squareup.okio.BufferedSource
    public boolean exhausted() throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        return this.buffer.exhausted() && this.source.read(this.buffer, tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1;
    }

    @Override // dc.squareup.okio.BufferedSource
    public dc.squareup.okio.Buffer getBuffer() {
        return this.buffer;
    }

    @Override // dc.squareup.okio.BufferedSource
    public long indexOf(byte b) throws java.io.IOException {
        return indexOf(b, 0L, Long.MAX_VALUE);
    }

    @Override // dc.squareup.okio.BufferedSource
    public long indexOfElement(dc.squareup.okio.ByteString byteString) throws java.io.IOException {
        return indexOfElement(byteString, 0L);
    }

    @Override // dc.squareup.okio.BufferedSource
    public java.io.InputStream inputStream() {
        return new java.io.InputStream() { // from class: dc.squareup.okio.RealBufferedSource.1
            @Override // java.io.InputStream
            public int available() throws java.io.IOException {
                dc.squareup.okio.RealBufferedSource realBufferedSource = dc.squareup.okio.RealBufferedSource.this;
                if (realBufferedSource.closed) {
                    throw new java.io.IOException("closed");
                }
                return (int) java.lang.Math.min(realBufferedSource.buffer.size, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws java.io.IOException {
                dc.squareup.okio.RealBufferedSource.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws java.io.IOException {
                dc.squareup.okio.RealBufferedSource realBufferedSource = dc.squareup.okio.RealBufferedSource.this;
                if (realBufferedSource.closed) {
                    throw new java.io.IOException("closed");
                }
                dc.squareup.okio.Buffer buffer = realBufferedSource.buffer;
                if (buffer.size == 0 && realBufferedSource.source.read(buffer, tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                    return -1;
                }
                return dc.squareup.okio.RealBufferedSource.this.buffer.readByte() & 255;
            }

            public java.lang.String toString() {
                return dc.squareup.okio.RealBufferedSource.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
                if (!dc.squareup.okio.RealBufferedSource.this.closed) {
                    dc.squareup.okio.Util.checkOffsetAndCount(bArr.length, i, i2);
                    dc.squareup.okio.RealBufferedSource realBufferedSource = dc.squareup.okio.RealBufferedSource.this;
                    dc.squareup.okio.Buffer buffer = realBufferedSource.buffer;
                    if (buffer.size == 0 && realBufferedSource.source.read(buffer, tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                        return -1;
                    }
                    return dc.squareup.okio.RealBufferedSource.this.buffer.read(bArr, i, i2);
                }
                throw new java.io.IOException("closed");
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // dc.squareup.okio.BufferedSource
    public dc.squareup.okio.BufferedSource peek() {
        return dc.squareup.okio.Okio.buffer(new dc.squareup.okio.PeekSource(this));
    }

    @Override // dc.squareup.okio.BufferedSource
    public boolean rangeEquals(long j, dc.squareup.okio.ByteString byteString) throws java.io.IOException {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    @Override // dc.squareup.okio.Source
    public long read(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
        if (buffer == null) {
            throw new java.lang.IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        dc.squareup.okio.Buffer buffer2 = this.buffer;
        if (buffer2.size == 0 && this.source.read(buffer2, tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
            return -1L;
        }
        return this.buffer.read(buffer, java.lang.Math.min(j, this.buffer.size));
    }

    @Override // dc.squareup.okio.BufferedSource
    public long readAll(dc.squareup.okio.Sink sink) throws java.io.IOException {
        if (sink == null) {
            throw new java.lang.IllegalArgumentException("sink == null");
        }
        long j = 0;
        while (this.source.read(this.buffer, tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) != -1) {
            long jCompleteSegmentByteCount = this.buffer.completeSegmentByteCount();
            if (jCompleteSegmentByteCount > 0) {
                j += jCompleteSegmentByteCount;
                sink.write(this.buffer, jCompleteSegmentByteCount);
            }
        }
        if (this.buffer.size() <= 0) {
            return j;
        }
        long size = j + this.buffer.size();
        dc.squareup.okio.Buffer buffer = this.buffer;
        sink.write(buffer, buffer.size());
        return size;
    }

    @Override // dc.squareup.okio.BufferedSource
    public byte readByte() throws java.io.IOException {
        require(1L);
        return this.buffer.readByte();
    }

    @Override // dc.squareup.okio.BufferedSource
    public byte[] readByteArray() throws java.io.IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteArray();
    }

    @Override // dc.squareup.okio.BufferedSource
    public dc.squareup.okio.ByteString readByteString() throws java.io.IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteString();
    }

    @Override // dc.squareup.okio.BufferedSource
    public long readDecimalLong() throws java.io.IOException {
        require(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!request(i2)) {
                break;
            }
            byte b = this.buffer.getByte(i);
            if ((b < 48 || b > 57) && !(i == 0 && b == 45)) {
                if (i != 0) {
                    break;
                }
                throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9] or '-' character but was %#x", java.lang.Byte.valueOf(b)));
            }
            i = i2;
        }
        return this.buffer.readDecimalLong();
    }

    @Override // dc.squareup.okio.BufferedSource
    public void readFully(byte[] bArr) throws java.io.IOException {
        try {
            require(bArr.length);
            this.buffer.readFully(bArr);
        } catch (java.io.EOFException e) {
            int i = 0;
            while (true) {
                dc.squareup.okio.Buffer buffer = this.buffer;
                long j = buffer.size;
                if (j <= 0) {
                    throw e;
                }
                int i2 = buffer.read(bArr, i, (int) j);
                if (i2 == -1) {
                    throw new java.lang.AssertionError();
                }
                i += i2;
            }
        }
    }

    @Override // dc.squareup.okio.BufferedSource
    public long readHexadecimalUnsignedLong() throws java.io.IOException {
        require(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!request(i2)) {
                break;
            }
            byte b = this.buffer.getByte(i);
            if ((b < 48 || b > 57) && ((b < 97 || b > 102) && (b < 65 || b > 70))) {
                if (i != 0) {
                    break;
                }
                throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(b)));
            }
            i = i2;
        }
        return this.buffer.readHexadecimalUnsignedLong();
    }

    @Override // dc.squareup.okio.BufferedSource
    public int readInt() throws java.io.IOException {
        require(4L);
        return this.buffer.readInt();
    }

    @Override // dc.squareup.okio.BufferedSource
    public int readIntLe() throws java.io.IOException {
        require(4L);
        return this.buffer.readIntLe();
    }

    @Override // dc.squareup.okio.BufferedSource
    public long readLong() throws java.io.IOException {
        require(8L);
        return this.buffer.readLong();
    }

    @Override // dc.squareup.okio.BufferedSource
    public long readLongLe() throws java.io.IOException {
        require(8L);
        return this.buffer.readLongLe();
    }

    @Override // dc.squareup.okio.BufferedSource
    public short readShort() throws java.io.IOException {
        require(2L);
        return this.buffer.readShort();
    }

    @Override // dc.squareup.okio.BufferedSource
    public short readShortLe() throws java.io.IOException {
        require(2L);
        return this.buffer.readShortLe();
    }

    @Override // dc.squareup.okio.BufferedSource
    public java.lang.String readString(java.nio.charset.Charset charset) throws java.io.IOException {
        if (charset == null) {
            throw new java.lang.IllegalArgumentException("charset == null");
        }
        this.buffer.writeAll(this.source);
        return this.buffer.readString(charset);
    }

    @Override // dc.squareup.okio.BufferedSource
    public java.lang.String readUtf8() throws java.io.IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readUtf8();
    }

    @Override // dc.squareup.okio.BufferedSource
    public int readUtf8CodePoint() throws java.io.IOException {
        require(1L);
        byte b = this.buffer.getByte(0L);
        if ((b & 224) == 192) {
            require(2L);
        } else if ((b & 240) == 224) {
            require(3L);
        } else if ((b & 248) == 240) {
            require(4L);
        }
        return this.buffer.readUtf8CodePoint();
    }

    @Override // dc.squareup.okio.BufferedSource
    public java.lang.String readUtf8Line() throws java.io.IOException {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return this.buffer.readUtf8Line(jIndexOf);
        }
        long j = this.buffer.size;
        if (j != 0) {
            return readUtf8(j);
        }
        return null;
    }

    @Override // dc.squareup.okio.BufferedSource
    public java.lang.String readUtf8LineStrict() throws java.io.IOException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // dc.squareup.okio.BufferedSource
    public boolean request(long j) throws java.io.IOException {
        dc.squareup.okio.Buffer buffer;
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        do {
            buffer = this.buffer;
            if (buffer.size >= j) {
                return true;
            }
        } while (this.source.read(buffer, tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) != -1);
        return false;
    }

    @Override // dc.squareup.okio.BufferedSource
    public void require(long j) throws java.io.IOException {
        if (!request(j)) {
            throw new java.io.EOFException();
        }
    }

    @Override // dc.squareup.okio.BufferedSource
    public int select(dc.squareup.okio.Options options) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        do {
            int iSelectPrefix = this.buffer.selectPrefix(options, true);
            if (iSelectPrefix == -1) {
                return -1;
            }
            if (iSelectPrefix != -2) {
                this.buffer.skip(options.byteStrings[iSelectPrefix].size());
                return iSelectPrefix;
            }
        } while (this.source.read(this.buffer, tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) != -1);
        return -1;
    }

    @Override // dc.squareup.okio.BufferedSource
    public void skip(long j) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        while (j > 0) {
            dc.squareup.okio.Buffer buffer = this.buffer;
            if (buffer.size == 0 && this.source.read(buffer, tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                throw new java.io.EOFException();
            }
            long jMin = java.lang.Math.min(j, this.buffer.size());
            this.buffer.skip(jMin);
            j -= jMin;
        }
    }

    @Override // dc.squareup.okio.Source
    public dc.squareup.okio.Timeout timeout() {
        return this.source.timeout();
    }

    public java.lang.String toString() {
        return "buffer(" + this.source + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
    }

    @Override // dc.squareup.okio.BufferedSource
    public long indexOf(byte b, long j) throws java.io.IOException {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    @Override // dc.squareup.okio.BufferedSource
    public long indexOfElement(dc.squareup.okio.ByteString byteString, long j) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        while (true) {
            long jIndexOfElement = this.buffer.indexOfElement(byteString, j);
            if (jIndexOfElement != -1) {
                return jIndexOfElement;
            }
            dc.squareup.okio.Buffer buffer = this.buffer;
            long j2 = buffer.size;
            if (this.source.read(buffer, tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                return -1L;
            }
            j = java.lang.Math.max(j, j2);
        }
    }

    @Override // dc.squareup.okio.BufferedSource
    public boolean rangeEquals(long j, dc.squareup.okio.ByteString byteString, int i, int i2) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        if (j < 0 || i < 0 || i2 < 0 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = ((long) i3) + j;
            if (!request(1 + j2) || this.buffer.getByte(j2) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // dc.squareup.okio.BufferedSource
    public java.lang.String readUtf8LineStrict(long j) throws java.io.IOException {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jIndexOf = indexOf((byte) 10, 0L, j2);
        if (jIndexOf != -1) {
            return this.buffer.readUtf8Line(jIndexOf);
        }
        if (j2 < Long.MAX_VALUE && request(j2) && this.buffer.getByte(j2 - 1) == 13 && request(1 + j2) && this.buffer.getByte(j2) == 10) {
            return this.buffer.readUtf8Line(j2);
        }
        dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
        dc.squareup.okio.Buffer buffer2 = this.buffer;
        buffer2.copyTo(buffer, 0L, java.lang.Math.min(32L, buffer2.size()));
        throw new java.io.EOFException("\\n not found: limit=" + java.lang.Math.min(this.buffer.size(), j) + " content=" + buffer.readByteString().hex() + kotlin.text.Typography.ellipsis);
    }

    @Override // dc.squareup.okio.BufferedSource
    public long indexOf(byte b, long j, long j2) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format("fromIndex=%s toIndex=%s", java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2)));
        }
        long jMax = j;
        while (jMax < j2) {
            byte b2 = b;
            long j3 = j2;
            long jIndexOf = this.buffer.indexOf(b2, jMax, j3);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            dc.squareup.okio.Buffer buffer = this.buffer;
            long j4 = buffer.size;
            if (j4 >= j3 || this.source.read(buffer, tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                break;
            }
            jMax = java.lang.Math.max(jMax, j4);
            b = b2;
            j2 = j3;
        }
        return -1L;
    }

    @Override // dc.squareup.okio.BufferedSource
    public byte[] readByteArray(long j) throws java.io.IOException {
        require(j);
        return this.buffer.readByteArray(j);
    }

    @Override // dc.squareup.okio.BufferedSource
    public dc.squareup.okio.ByteString readByteString(long j) throws java.io.IOException {
        require(j);
        return this.buffer.readByteString(j);
    }

    @Override // dc.squareup.okio.BufferedSource
    public java.lang.String readUtf8(long j) throws java.io.IOException {
        require(j);
        return this.buffer.readUtf8(j);
    }

    @Override // dc.squareup.okio.BufferedSource
    public java.lang.String readString(long j, java.nio.charset.Charset charset) throws java.io.IOException {
        require(j);
        if (charset != null) {
            return this.buffer.readString(j, charset);
        }
        throw new java.lang.IllegalArgumentException("charset == null");
    }

    @Override // dc.squareup.okio.BufferedSource
    public int read(byte[] bArr) throws java.io.IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // dc.squareup.okio.BufferedSource
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        long j = i2;
        dc.squareup.okio.Util.checkOffsetAndCount(bArr.length, i, j);
        dc.squareup.okio.Buffer buffer = this.buffer;
        if (buffer.size == 0 && this.source.read(buffer, tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
            return -1;
        }
        return this.buffer.read(bArr, i, (int) java.lang.Math.min(j, this.buffer.size));
    }

    @Override // dc.squareup.okio.BufferedSource
    public void readFully(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException {
        try {
            require(j);
            this.buffer.readFully(buffer, j);
        } catch (java.io.EOFException e) {
            buffer.writeAll(this.buffer);
            throw e;
        }
    }

    @Override // dc.squareup.okio.BufferedSource
    public long indexOf(dc.squareup.okio.ByteString byteString) throws java.io.IOException {
        return indexOf(byteString, 0L);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        dc.squareup.okio.Buffer buffer = this.buffer;
        if (buffer.size == 0 && this.source.read(buffer, tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
            return -1;
        }
        return this.buffer.read(byteBuffer);
    }

    @Override // dc.squareup.okio.BufferedSource
    public long indexOf(dc.squareup.okio.ByteString byteString, long j) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        while (true) {
            long jIndexOf = this.buffer.indexOf(byteString, j);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            dc.squareup.okio.Buffer buffer = this.buffer;
            long j2 = buffer.size;
            if (this.source.read(buffer, tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                return -1L;
            }
            j = java.lang.Math.max(j, (j2 - ((long) byteString.size())) + 1);
        }
    }
}
