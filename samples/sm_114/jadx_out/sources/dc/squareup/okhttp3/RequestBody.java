package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class RequestBody {
    public static dc.squareup.okhttp3.RequestBody create(dc.squareup.okhttp3.MediaType mediaType, java.lang.String str) {
        java.nio.charset.Charset charset;
        java.nio.charset.Charset charset2 = dc.squareup.okhttp3.internal.Util.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) != null) {
            charset2 = charset;
        }
        return create(mediaType, str.getBytes(charset2));
    }

    public static dc.squareup.okhttp3.RequestBody createWithBytes(dc.squareup.okhttp3.MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr);
    }

    public long contentLength() throws java.io.IOException {
        return -1L;
    }

    public abstract dc.squareup.okhttp3.MediaType contentType();

    public abstract void writeTo(dc.squareup.okio.BufferedSink bufferedSink) throws java.io.IOException;

    public static dc.squareup.okhttp3.RequestBody create(final dc.squareup.okhttp3.MediaType mediaType, final dc.squareup.okio.ByteString byteString) {
        return new dc.squareup.okhttp3.RequestBody() { // from class: dc.squareup.okhttp3.RequestBody.1
            @Override // dc.squareup.okhttp3.RequestBody
            public long contentLength() throws java.io.IOException {
                return byteString.size();
            }

            @Override // dc.squareup.okhttp3.RequestBody
            public dc.squareup.okhttp3.MediaType contentType() {
                return mediaType;
            }

            @Override // dc.squareup.okhttp3.RequestBody
            public void writeTo(dc.squareup.okio.BufferedSink bufferedSink) throws java.io.IOException {
                bufferedSink.write(byteString);
            }
        };
    }

    public static dc.squareup.okhttp3.RequestBody create(dc.squareup.okhttp3.MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static dc.squareup.okhttp3.RequestBody create(final dc.squareup.okhttp3.MediaType mediaType, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            dc.squareup.okhttp3.internal.Util.checkOffsetAndCount(bArr.length, i, i2);
            return new dc.squareup.okhttp3.RequestBody() { // from class: dc.squareup.okhttp3.RequestBody.2
                @Override // dc.squareup.okhttp3.RequestBody
                public long contentLength() {
                    return i2;
                }

                @Override // dc.squareup.okhttp3.RequestBody
                public dc.squareup.okhttp3.MediaType contentType() {
                    return mediaType;
                }

                @Override // dc.squareup.okhttp3.RequestBody
                public void writeTo(dc.squareup.okio.BufferedSink bufferedSink) throws java.io.IOException {
                    bufferedSink.write(bArr, i, i2);
                }
            };
        }
        throw new java.lang.NullPointerException("content == null");
    }

    public static dc.squareup.okhttp3.RequestBody create(final dc.squareup.okhttp3.MediaType mediaType, final java.io.File file) {
        if (file != null) {
            return new dc.squareup.okhttp3.RequestBody() { // from class: dc.squareup.okhttp3.RequestBody.3
                @Override // dc.squareup.okhttp3.RequestBody
                public long contentLength() {
                    return file.length();
                }

                @Override // dc.squareup.okhttp3.RequestBody
                public dc.squareup.okhttp3.MediaType contentType() {
                    return mediaType;
                }

                @Override // dc.squareup.okhttp3.RequestBody
                public void writeTo(dc.squareup.okio.BufferedSink bufferedSink) throws java.io.IOException {
                    dc.squareup.okio.Source source = null;
                    try {
                        source = dc.squareup.okio.Okio.source(file);
                        bufferedSink.writeAll(source);
                    } finally {
                        dc.squareup.okhttp3.internal.Util.closeQuietly(source);
                    }
                }
            };
        }
        throw new java.lang.NullPointerException("file == null");
    }
}
