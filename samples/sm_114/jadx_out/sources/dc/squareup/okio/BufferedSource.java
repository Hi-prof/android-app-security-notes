package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface BufferedSource extends dc.squareup.okio.Source, java.nio.channels.ReadableByteChannel {
    @java.lang.Deprecated
    dc.squareup.okio.Buffer buffer();

    boolean exhausted() throws java.io.IOException;

    dc.squareup.okio.Buffer getBuffer();

    long indexOf(byte b) throws java.io.IOException;

    long indexOf(byte b, long j) throws java.io.IOException;

    long indexOf(byte b, long j, long j2) throws java.io.IOException;

    long indexOf(dc.squareup.okio.ByteString byteString) throws java.io.IOException;

    long indexOf(dc.squareup.okio.ByteString byteString, long j) throws java.io.IOException;

    long indexOfElement(dc.squareup.okio.ByteString byteString) throws java.io.IOException;

    long indexOfElement(dc.squareup.okio.ByteString byteString, long j) throws java.io.IOException;

    java.io.InputStream inputStream();

    dc.squareup.okio.BufferedSource peek();

    boolean rangeEquals(long j, dc.squareup.okio.ByteString byteString) throws java.io.IOException;

    boolean rangeEquals(long j, dc.squareup.okio.ByteString byteString, int i, int i2) throws java.io.IOException;

    int read(byte[] bArr) throws java.io.IOException;

    int read(byte[] bArr, int i, int i2) throws java.io.IOException;

    long readAll(dc.squareup.okio.Sink sink) throws java.io.IOException;

    byte readByte() throws java.io.IOException;

    byte[] readByteArray() throws java.io.IOException;

    byte[] readByteArray(long j) throws java.io.IOException;

    dc.squareup.okio.ByteString readByteString() throws java.io.IOException;

    dc.squareup.okio.ByteString readByteString(long j) throws java.io.IOException;

    long readDecimalLong() throws java.io.IOException;

    void readFully(dc.squareup.okio.Buffer buffer, long j) throws java.io.IOException;

    void readFully(byte[] bArr) throws java.io.IOException;

    long readHexadecimalUnsignedLong() throws java.io.IOException;

    int readInt() throws java.io.IOException;

    int readIntLe() throws java.io.IOException;

    long readLong() throws java.io.IOException;

    long readLongLe() throws java.io.IOException;

    short readShort() throws java.io.IOException;

    short readShortLe() throws java.io.IOException;

    java.lang.String readString(long j, java.nio.charset.Charset charset) throws java.io.IOException;

    java.lang.String readString(java.nio.charset.Charset charset) throws java.io.IOException;

    java.lang.String readUtf8() throws java.io.IOException;

    java.lang.String readUtf8(long j) throws java.io.IOException;

    int readUtf8CodePoint() throws java.io.IOException;

    java.lang.String readUtf8Line() throws java.io.IOException;

    java.lang.String readUtf8LineStrict() throws java.io.IOException;

    java.lang.String readUtf8LineStrict(long j) throws java.io.IOException;

    boolean request(long j) throws java.io.IOException;

    void require(long j) throws java.io.IOException;

    int select(dc.squareup.okio.Options options) throws java.io.IOException;

    void skip(long j) throws java.io.IOException;
}
