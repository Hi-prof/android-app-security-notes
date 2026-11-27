package com.dcloud.zxing2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class FormatException extends com.dcloud.zxing2.ReaderException {
    private static final com.dcloud.zxing2.FormatException INSTANCE;

    static {
        com.dcloud.zxing2.FormatException formatException = new com.dcloud.zxing2.FormatException();
        INSTANCE = formatException;
        formatException.setStackTrace(com.dcloud.zxing2.ReaderException.NO_TRACE);
    }

    private FormatException() {
    }

    public static com.dcloud.zxing2.FormatException getFormatInstance() {
        return com.dcloud.zxing2.ReaderException.isStackTrace ? new com.dcloud.zxing2.FormatException() : INSTANCE;
    }

    private FormatException(java.lang.Throwable th) {
        super(th);
    }

    public static com.dcloud.zxing2.FormatException getFormatInstance(java.lang.Throwable th) {
        return com.dcloud.zxing2.ReaderException.isStackTrace ? new com.dcloud.zxing2.FormatException(th) : INSTANCE;
    }
}
