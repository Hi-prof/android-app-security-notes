package dc.squareup.okhttp3.internal.http;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class RealResponseBody extends dc.squareup.okhttp3.ResponseBody {
    private final long contentLength;
    private final java.lang.String contentTypeString;
    private final dc.squareup.okio.BufferedSource source;

    public RealResponseBody(java.lang.String str, long j, dc.squareup.okio.BufferedSource bufferedSource) {
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = bufferedSource;
    }

    @Override // dc.squareup.okhttp3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // dc.squareup.okhttp3.ResponseBody
    public dc.squareup.okhttp3.MediaType contentType() {
        java.lang.String str = this.contentTypeString;
        if (str != null) {
            return dc.squareup.okhttp3.MediaType.parse(str);
        }
        return null;
    }

    @Override // dc.squareup.okhttp3.ResponseBody
    public dc.squareup.okio.BufferedSource source() {
        return this.source;
    }
}
