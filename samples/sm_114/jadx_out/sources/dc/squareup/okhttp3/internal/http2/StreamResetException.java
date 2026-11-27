package dc.squareup.okhttp3.internal.http2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class StreamResetException extends java.io.IOException {
    public final dc.squareup.okhttp3.internal.http2.ErrorCode errorCode;

    public StreamResetException(dc.squareup.okhttp3.internal.http2.ErrorCode errorCode) {
        super("stream was reset: " + errorCode);
        this.errorCode = errorCode;
    }
}
