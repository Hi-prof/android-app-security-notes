package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface BufferedSink extends dc.squareup.okio.Sink, java.nio.channels.WritableByteChannel {
    dc.squareup.okio.Buffer buffer();

    dc.squareup.okio.BufferedSink emit() throws java.io.IOException;

    dc.squareup.okio.BufferedSink emitCompleteSegments() throws java.io.IOException;

    @Override // dc.squareup.okio.Sink, java.io.Flushable
    void flush() throws java.io.IOException;

    java.io.OutputStream outputStream();

    dc.squareup.okio.BufferedSink write(dc.squareup.okio.ByteString byteString) throws java.io.IOException;

    dc.squareup.okio.BufferedSink write(dc.squareup.okio.Source source, long j) throws java.io.IOException;

    dc.squareup.okio.BufferedSink write(byte[] bArr) throws java.io.IOException;

    dc.squareup.okio.BufferedSink write(byte[] bArr, int i, int i2) throws java.io.IOException;

    long writeAll(dc.squareup.okio.Source source) throws java.io.IOException;

    dc.squareup.okio.BufferedSink writeByte(int i) throws java.io.IOException;

    dc.squareup.okio.BufferedSink writeDecimalLong(long j) throws java.io.IOException;

    dc.squareup.okio.BufferedSink writeHexadecimalUnsignedLong(long j) throws java.io.IOException;

    dc.squareup.okio.BufferedSink writeInt(int i) throws java.io.IOException;

    dc.squareup.okio.BufferedSink writeIntLe(int i) throws java.io.IOException;

    dc.squareup.okio.BufferedSink writeLong(long j) throws java.io.IOException;

    dc.squareup.okio.BufferedSink writeLongLe(long j) throws java.io.IOException;

    dc.squareup.okio.BufferedSink writeShort(int i) throws java.io.IOException;

    dc.squareup.okio.BufferedSink writeShortLe(int i) throws java.io.IOException;

    dc.squareup.okio.BufferedSink writeString(java.lang.String str, int i, int i2, java.nio.charset.Charset charset) throws java.io.IOException;

    dc.squareup.okio.BufferedSink writeString(java.lang.String str, java.nio.charset.Charset charset) throws java.io.IOException;

    dc.squareup.okio.BufferedSink writeUtf8(java.lang.String str) throws java.io.IOException;

    dc.squareup.okio.BufferedSink writeUtf8(java.lang.String str, int i, int i2) throws java.io.IOException;

    dc.squareup.okio.BufferedSink writeUtf8CodePoint(int i) throws java.io.IOException;
}
