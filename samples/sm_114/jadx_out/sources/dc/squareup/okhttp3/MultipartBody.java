package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class MultipartBody extends dc.squareup.okhttp3.RequestBody {
    private final dc.squareup.okio.ByteString boundary;
    private long contentLength = -1;
    private final dc.squareup.okhttp3.MediaType contentType;
    private final dc.squareup.okhttp3.MediaType originalType;
    private final java.util.List<dc.squareup.okhttp3.MultipartBody.Part> parts;
    public static final dc.squareup.okhttp3.MediaType MIXED = dc.squareup.okhttp3.MediaType.get("multipart/mixed");
    public static final dc.squareup.okhttp3.MediaType ALTERNATIVE = dc.squareup.okhttp3.MediaType.get("multipart/alternative");
    public static final dc.squareup.okhttp3.MediaType DIGEST = dc.squareup.okhttp3.MediaType.get("multipart/digest");
    public static final dc.squareup.okhttp3.MediaType PARALLEL = dc.squareup.okhttp3.MediaType.get("multipart/parallel");
    public static final dc.squareup.okhttp3.MediaType FORM = dc.squareup.okhttp3.MediaType.get("multipart/form-data");
    private static final byte[] COLONSPACE = {58, org.mozilla.universalchardet.prober.HebrewProber.SPACE};
    private static final byte[] CRLF = {13, 10};
    private static final byte[] DASHDASH = {45, 45};

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static final class Builder {
        private final dc.squareup.okio.ByteString boundary;
        private final java.util.List<dc.squareup.okhttp3.MultipartBody.Part> parts;
        private dc.squareup.okhttp3.MediaType type;

        public Builder() {
            this(java.util.UUID.randomUUID().toString());
        }

        public dc.squareup.okhttp3.MultipartBody.Builder addFormDataPart(java.lang.String str, java.lang.String str2) {
            return addPart(dc.squareup.okhttp3.MultipartBody.Part.createFormData(str, str2));
        }

        public dc.squareup.okhttp3.MultipartBody.Builder addPart(dc.squareup.okhttp3.RequestBody requestBody) {
            return addPart(dc.squareup.okhttp3.MultipartBody.Part.create(requestBody));
        }

        public dc.squareup.okhttp3.MultipartBody build() {
            if (this.parts.isEmpty()) {
                throw new java.lang.IllegalStateException("Multipart body must have at least one part.");
            }
            return new dc.squareup.okhttp3.MultipartBody(this.boundary, this.type, this.parts);
        }

        public dc.squareup.okhttp3.MultipartBody.Builder setType(dc.squareup.okhttp3.MediaType mediaType) {
            if (mediaType == null) {
                throw new java.lang.NullPointerException("type == null");
            }
            if (mediaType.type().equals("multipart")) {
                this.type = mediaType;
                return this;
            }
            throw new java.lang.IllegalArgumentException("multipart != " + mediaType);
        }

        public Builder(java.lang.String str) {
            this.type = dc.squareup.okhttp3.MultipartBody.MIXED;
            this.parts = new java.util.ArrayList();
            this.boundary = dc.squareup.okio.ByteString.encodeUtf8(str);
        }

        public dc.squareup.okhttp3.MultipartBody.Builder addFormDataPart(java.lang.String str, java.lang.String str2, dc.squareup.okhttp3.RequestBody requestBody) {
            return addPart(dc.squareup.okhttp3.MultipartBody.Part.createFormData(str, str2, requestBody));
        }

        public dc.squareup.okhttp3.MultipartBody.Builder addPart(dc.squareup.okhttp3.Headers headers, dc.squareup.okhttp3.RequestBody requestBody) {
            return addPart(dc.squareup.okhttp3.MultipartBody.Part.create(headers, requestBody));
        }

        public dc.squareup.okhttp3.MultipartBody.Builder addPart(dc.squareup.okhttp3.MultipartBody.Part part) {
            if (part != null) {
                this.parts.add(part);
                return this;
            }
            throw new java.lang.NullPointerException("part == null");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static final class Part {
        final dc.squareup.okhttp3.RequestBody body;
        final dc.squareup.okhttp3.Headers headers;

        private Part(dc.squareup.okhttp3.Headers headers, dc.squareup.okhttp3.RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        public static dc.squareup.okhttp3.MultipartBody.Part create(dc.squareup.okhttp3.RequestBody requestBody) {
            return create(null, requestBody);
        }

        public static dc.squareup.okhttp3.MultipartBody.Part createFormData(java.lang.String str, java.lang.String str2) {
            return createFormData(str, null, dc.squareup.okhttp3.RequestBody.create((dc.squareup.okhttp3.MediaType) null, str2));
        }

        public dc.squareup.okhttp3.RequestBody body() {
            return this.body;
        }

        public dc.squareup.okhttp3.Headers headers() {
            return this.headers;
        }

        public static dc.squareup.okhttp3.MultipartBody.Part create(dc.squareup.okhttp3.Headers headers, dc.squareup.okhttp3.RequestBody requestBody) {
            if (requestBody == null) {
                throw new java.lang.NullPointerException("body == null");
            }
            if (headers != null && headers.get(io.dcloud.common.util.net.NetWork.CONTENT_TYPE) != null) {
                throw new java.lang.IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (headers == null || headers.get("Content-Length") == null) {
                return new dc.squareup.okhttp3.MultipartBody.Part(headers, requestBody);
            }
            throw new java.lang.IllegalArgumentException("Unexpected header: Content-Length");
        }

        public static dc.squareup.okhttp3.MultipartBody.Part createFormData(java.lang.String str, java.lang.String str2, dc.squareup.okhttp3.RequestBody requestBody) {
            if (str == null) {
                throw new java.lang.NullPointerException("name == null");
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder("form-data; name=");
            dc.squareup.okhttp3.MultipartBody.appendQuotedString(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                dc.squareup.okhttp3.MultipartBody.appendQuotedString(sb, str2);
            }
            return create(new dc.squareup.okhttp3.Headers.Builder().addUnsafeNonAscii("Content-Disposition", sb.toString()).build(), requestBody);
        }
    }

    MultipartBody(dc.squareup.okio.ByteString byteString, dc.squareup.okhttp3.MediaType mediaType, java.util.List<dc.squareup.okhttp3.MultipartBody.Part> list) {
        this.boundary = byteString;
        this.originalType = mediaType;
        this.contentType = dc.squareup.okhttp3.MediaType.get(mediaType + "; boundary=" + byteString.utf8());
        this.parts = dc.squareup.okhttp3.internal.Util.immutableList(list);
    }

    static java.lang.StringBuilder appendQuotedString(java.lang.StringBuilder sb, java.lang.String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\n') {
                sb.append("%0A");
            } else if (cCharAt == '\r') {
                sb.append("%0D");
            } else if (cCharAt != '\"') {
                sb.append(cCharAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append('\"');
        return sb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long writeOrCountBytes(dc.squareup.okio.BufferedSink bufferedSink, boolean z) throws java.io.IOException {
        dc.squareup.okio.Buffer buffer;
        if (z) {
            bufferedSink = new dc.squareup.okio.Buffer();
            buffer = bufferedSink;
        } else {
            buffer = 0;
        }
        int size = this.parts.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            dc.squareup.okhttp3.MultipartBody.Part part = this.parts.get(i);
            dc.squareup.okhttp3.Headers headers = part.headers;
            dc.squareup.okhttp3.RequestBody requestBody = part.body;
            bufferedSink.write(DASHDASH);
            bufferedSink.write(this.boundary);
            bufferedSink.write(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    bufferedSink.writeUtf8(headers.name(i2)).write(COLONSPACE).writeUtf8(headers.value(i2)).write(CRLF);
                }
            }
            dc.squareup.okhttp3.MediaType mediaTypeContentType = requestBody.contentType();
            if (mediaTypeContentType != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(mediaTypeContentType.toString()).write(CRLF);
            }
            long jContentLength = requestBody.contentLength();
            if (jContentLength != -1) {
                bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(jContentLength).write(CRLF);
            } else if (z) {
                buffer.clear();
                return -1L;
            }
            byte[] bArr = CRLF;
            bufferedSink.write(bArr);
            if (z) {
                j += jContentLength;
            } else {
                requestBody.writeTo(bufferedSink);
            }
            bufferedSink.write(bArr);
        }
        byte[] bArr2 = DASHDASH;
        bufferedSink.write(bArr2);
        bufferedSink.write(this.boundary);
        bufferedSink.write(bArr2);
        bufferedSink.write(CRLF);
        if (!z) {
            return j;
        }
        long size3 = j + buffer.size();
        buffer.clear();
        return size3;
    }

    public java.lang.String boundary() {
        return this.boundary.utf8();
    }

    @Override // dc.squareup.okhttp3.RequestBody
    public long contentLength() throws java.io.IOException {
        long j = this.contentLength;
        if (j != -1) {
            return j;
        }
        long jWriteOrCountBytes = writeOrCountBytes(null, true);
        this.contentLength = jWriteOrCountBytes;
        return jWriteOrCountBytes;
    }

    @Override // dc.squareup.okhttp3.RequestBody
    public dc.squareup.okhttp3.MediaType contentType() {
        return this.contentType;
    }

    public dc.squareup.okhttp3.MultipartBody.Part part(int i) {
        return this.parts.get(i);
    }

    public java.util.List<dc.squareup.okhttp3.MultipartBody.Part> parts() {
        return this.parts;
    }

    public int size() {
        return this.parts.size();
    }

    public dc.squareup.okhttp3.MediaType type() {
        return this.originalType;
    }

    @Override // dc.squareup.okhttp3.RequestBody
    public void writeTo(dc.squareup.okio.BufferedSink bufferedSink) throws java.io.IOException {
        writeOrCountBytes(bufferedSink, false);
    }
}
