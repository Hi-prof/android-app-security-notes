package dc.squareup.okhttp3.internal.http;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface HttpCodec {
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    void cancel();

    dc.squareup.okio.Sink createRequestBody(dc.squareup.okhttp3.Request request, long j);

    void finishRequest() throws java.io.IOException;

    void flushRequest() throws java.io.IOException;

    dc.squareup.okhttp3.ResponseBody openResponseBody(dc.squareup.okhttp3.Response response) throws java.io.IOException;

    dc.squareup.okhttp3.Response.Builder readResponseHeaders(boolean z) throws java.io.IOException;

    void writeRequestHeaders(dc.squareup.okhttp3.Request request) throws java.io.IOException;
}
