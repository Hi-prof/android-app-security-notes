package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class ResponseBody implements java.io.Closeable {
    private java.io.Reader reader;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static final class BomAwareReader extends java.io.Reader {
        private final java.nio.charset.Charset charset;
        private boolean closed;
        private java.io.Reader delegate;
        private final dc.squareup.okio.BufferedSource source;

        BomAwareReader(dc.squareup.okio.BufferedSource bufferedSource, java.nio.charset.Charset charset) {
            this.source = bufferedSource;
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            this.closed = true;
            java.io.Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws java.io.IOException {
            if (this.closed) {
                throw new java.io.IOException("Stream closed");
            }
            java.io.Reader reader = this.delegate;
            if (reader == null) {
                java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader(this.source.inputStream(), dc.squareup.okhttp3.internal.Util.bomAwareCharset(this.source, this.charset));
                this.delegate = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i, i2);
        }
    }

    private java.nio.charset.Charset charset() {
        dc.squareup.okhttp3.MediaType mediaTypeContentType = contentType();
        return mediaTypeContentType != null ? mediaTypeContentType.charset(dc.squareup.okhttp3.internal.Util.UTF_8) : dc.squareup.okhttp3.internal.Util.UTF_8;
    }

    public static dc.squareup.okhttp3.ResponseBody create(dc.squareup.okhttp3.MediaType mediaType, java.lang.String str) {
        java.nio.charset.Charset charset;
        java.nio.charset.Charset charset2 = dc.squareup.okhttp3.internal.Util.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) != null) {
            charset2 = charset;
        }
        dc.squareup.okio.Buffer bufferWriteString = new dc.squareup.okio.Buffer().writeString(str, charset2);
        return create(mediaType, bufferWriteString.size(), bufferWriteString);
    }

    public final java.io.InputStream byteStream() {
        return source().inputStream();
    }

    public final byte[] bytes() throws java.io.IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new java.io.IOException("Cannot buffer entire body for content length: " + jContentLength);
        }
        dc.squareup.okio.BufferedSource bufferedSourceSource = source();
        try {
            byte[] byteArray = bufferedSourceSource.readByteArray();
            dc.squareup.okhttp3.internal.Util.closeQuietly(bufferedSourceSource);
            if (jContentLength == -1 || jContentLength == byteArray.length) {
                return byteArray;
            }
            throw new java.io.IOException("Content-Length (" + jContentLength + ") and stream length (" + byteArray.length + ") disagree");
        } catch (java.lang.Throwable th) {
            dc.squareup.okhttp3.internal.Util.closeQuietly(bufferedSourceSource);
            throw th;
        }
    }

    public final java.io.Reader charStream() {
        java.io.Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        dc.squareup.okhttp3.ResponseBody.BomAwareReader bomAwareReader = new dc.squareup.okhttp3.ResponseBody.BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        dc.squareup.okhttp3.internal.Util.closeQuietly(source());
    }

    public abstract long contentLength();

    public abstract dc.squareup.okhttp3.MediaType contentType();

    public abstract dc.squareup.okio.BufferedSource source();

    public final java.lang.String string() throws java.io.IOException {
        dc.squareup.okio.BufferedSource bufferedSourceSource = source();
        try {
            return bufferedSourceSource.readString(dc.squareup.okhttp3.internal.Util.bomAwareCharset(bufferedSourceSource, charset()));
        } finally {
            dc.squareup.okhttp3.internal.Util.closeQuietly(bufferedSourceSource);
        }
    }

    public static dc.squareup.okhttp3.ResponseBody create(dc.squareup.okhttp3.MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr.length, new dc.squareup.okio.Buffer().write(bArr));
    }

    public static dc.squareup.okhttp3.ResponseBody create(dc.squareup.okhttp3.MediaType mediaType, dc.squareup.okio.ByteString byteString) {
        return create(mediaType, byteString.size(), new dc.squareup.okio.Buffer().write(byteString));
    }

    public static dc.squareup.okhttp3.ResponseBody create(final dc.squareup.okhttp3.MediaType mediaType, final long j, final dc.squareup.okio.BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            return new dc.squareup.okhttp3.ResponseBody() { // from class: dc.squareup.okhttp3.ResponseBody.1
                @Override // dc.squareup.okhttp3.ResponseBody
                public long contentLength() {
                    return j;
                }

                @Override // dc.squareup.okhttp3.ResponseBody
                public dc.squareup.okhttp3.MediaType contentType() {
                    return mediaType;
                }

                @Override // dc.squareup.okhttp3.ResponseBody
                public dc.squareup.okio.BufferedSource source() {
                    return bufferedSource;
                }
            };
        }
        throw new java.lang.NullPointerException("source == null");
    }
}
