package com.taobao.weex.appfram.websocket;

/* JADX INFO: loaded from: classes.dex */
public enum WebSocketCloseCodes {
    CLOSE_NORMAL(1000),
    CLOSE_GOING_AWAY(1001),
    CLOSE_PROTOCOL_ERROR(1002),
    CLOSE_UNSUPPORTED(1003),
    CLOSE_NO_STATUS(io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.CODE_DECODE_portrait),
    CLOSE_ABNORMAL(1006),
    UNSUPPORTED_DATA(androidx.core.view.PointerIconCompat.TYPE_CROSSHAIR),
    POLICY_VIOLATION(androidx.core.view.PointerIconCompat.TYPE_TEXT),
    CLOSE_TOO_LARGE(androidx.core.view.PointerIconCompat.TYPE_VERTICAL_TEXT),
    MISSING_EXTENSION(1010),
    INTERNAL_ERROR(androidx.core.view.PointerIconCompat.TYPE_COPY),
    SERVICE_RESTART(androidx.core.view.PointerIconCompat.TYPE_NO_DROP),
    TRY_AGAIN_LATER(androidx.core.view.PointerIconCompat.TYPE_ALL_SCROLL),
    TLS_HANDSHAKE(androidx.core.view.PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW);

    private int code;

    WebSocketCloseCodes(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
