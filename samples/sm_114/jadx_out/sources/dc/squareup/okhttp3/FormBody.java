package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class FormBody extends dc.squareup.okhttp3.RequestBody {
    private static final dc.squareup.okhttp3.MediaType CONTENT_TYPE = dc.squareup.okhttp3.MediaType.get("application/x-www-form-urlencoded");
    private final java.util.List<java.lang.String> encodedNames;
    private final java.util.List<java.lang.String> encodedValues;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static final class Builder {
        private final java.nio.charset.Charset charset;
        private final java.util.List<java.lang.String> names;
        private final java.util.List<java.lang.String> values;

        public Builder() {
            this(null);
        }

        public dc.squareup.okhttp3.FormBody.Builder add(java.lang.String str, java.lang.String str2) {
            if (str == null) {
                throw new java.lang.NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new java.lang.NullPointerException("value == null");
            }
            this.names.add(dc.squareup.okhttp3.HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
            this.values.add(dc.squareup.okhttp3.HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
            return this;
        }

        public dc.squareup.okhttp3.FormBody.Builder addEncoded(java.lang.String str, java.lang.String str2) {
            if (str == null) {
                throw new java.lang.NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new java.lang.NullPointerException("value == null");
            }
            this.names.add(dc.squareup.okhttp3.HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
            this.values.add(dc.squareup.okhttp3.HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
            return this;
        }

        public dc.squareup.okhttp3.FormBody build() {
            return new dc.squareup.okhttp3.FormBody(this.names, this.values);
        }

        public Builder(java.nio.charset.Charset charset) {
            this.names = new java.util.ArrayList();
            this.values = new java.util.ArrayList();
            this.charset = charset;
        }
    }

    FormBody(java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2) {
        this.encodedNames = dc.squareup.okhttp3.internal.Util.immutableList(list);
        this.encodedValues = dc.squareup.okhttp3.internal.Util.immutableList(list2);
    }

    private long writeOrCountBytes(dc.squareup.okio.BufferedSink bufferedSink, boolean z) {
        dc.squareup.okio.Buffer buffer = z ? new dc.squareup.okio.Buffer() : bufferedSink.buffer();
        int size = this.encodedNames.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.encodedNames.get(i));
            buffer.writeByte(61);
            buffer.writeUtf8(this.encodedValues.get(i));
        }
        if (!z) {
            return 0L;
        }
        long size2 = buffer.size();
        buffer.clear();
        return size2;
    }

    @Override // dc.squareup.okhttp3.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // dc.squareup.okhttp3.RequestBody
    public dc.squareup.okhttp3.MediaType contentType() {
        return CONTENT_TYPE;
    }

    public java.lang.String encodedName(int i) {
        return this.encodedNames.get(i);
    }

    public java.lang.String encodedValue(int i) {
        return this.encodedValues.get(i);
    }

    public java.lang.String name(int i) {
        return dc.squareup.okhttp3.HttpUrl.percentDecode(encodedName(i), true);
    }

    public int size() {
        return this.encodedNames.size();
    }

    public java.lang.String value(int i) {
        return dc.squareup.okhttp3.HttpUrl.percentDecode(encodedValue(i), true);
    }

    @Override // dc.squareup.okhttp3.RequestBody
    public void writeTo(dc.squareup.okio.BufferedSink bufferedSink) throws java.io.IOException {
        writeOrCountBytes(bufferedSink, false);
    }
}
