package dc.squareup.okhttp3.internal.http2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Header {
    public static final java.lang.String RESPONSE_STATUS_UTF8 = ":status";
    public static final java.lang.String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final java.lang.String TARGET_METHOD_UTF8 = ":method";
    public static final java.lang.String TARGET_PATH_UTF8 = ":path";
    public static final java.lang.String TARGET_SCHEME_UTF8 = ":scheme";
    final int hpackSize;
    public final dc.squareup.okio.ByteString name;
    public final dc.squareup.okio.ByteString value;
    public static final dc.squareup.okio.ByteString PSEUDO_PREFIX = dc.squareup.okio.ByteString.encodeUtf8(":");
    public static final dc.squareup.okio.ByteString RESPONSE_STATUS = dc.squareup.okio.ByteString.encodeUtf8(":status");
    public static final dc.squareup.okio.ByteString TARGET_METHOD = dc.squareup.okio.ByteString.encodeUtf8(":method");
    public static final dc.squareup.okio.ByteString TARGET_PATH = dc.squareup.okio.ByteString.encodeUtf8(":path");
    public static final dc.squareup.okio.ByteString TARGET_SCHEME = dc.squareup.okio.ByteString.encodeUtf8(":scheme");
    public static final dc.squareup.okio.ByteString TARGET_AUTHORITY = dc.squareup.okio.ByteString.encodeUtf8(":authority");

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    interface Listener {
        void onHeaders(dc.squareup.okhttp3.Headers headers);
    }

    public Header(java.lang.String str, java.lang.String str2) {
        this(dc.squareup.okio.ByteString.encodeUtf8(str), dc.squareup.okio.ByteString.encodeUtf8(str2));
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof dc.squareup.okhttp3.internal.http2.Header) {
            dc.squareup.okhttp3.internal.http2.Header header = (dc.squareup.okhttp3.internal.http2.Header) obj;
            if (this.name.equals(header.name) && this.value.equals(header.value)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.name.hashCode() + 527) * 31) + this.value.hashCode();
    }

    public java.lang.String toString() {
        return dc.squareup.okhttp3.internal.Util.format("%s: %s", this.name.utf8(), this.value.utf8());
    }

    public Header(dc.squareup.okio.ByteString byteString, java.lang.String str) {
        this(byteString, dc.squareup.okio.ByteString.encodeUtf8(str));
    }

    public Header(dc.squareup.okio.ByteString byteString, dc.squareup.okio.ByteString byteString2) {
        this.name = byteString;
        this.value = byteString2;
        this.hpackSize = byteString.size() + 32 + byteString2.size();
    }
}
