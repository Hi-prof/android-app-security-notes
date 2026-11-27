package dc.squareup.okhttp3.internal.http2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public enum ErrorCode {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);

    public final int httpCode;

    ErrorCode(int i) {
        this.httpCode = i;
    }

    public static dc.squareup.okhttp3.internal.http2.ErrorCode fromHttp2(int i) {
        for (dc.squareup.okhttp3.internal.http2.ErrorCode errorCode : values()) {
            if (errorCode.httpCode == i) {
                return errorCode;
            }
        }
        return null;
    }
}
