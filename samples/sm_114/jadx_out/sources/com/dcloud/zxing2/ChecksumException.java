package com.dcloud.zxing2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class ChecksumException extends com.dcloud.zxing2.ReaderException {
    private static final com.dcloud.zxing2.ChecksumException INSTANCE;

    static {
        com.dcloud.zxing2.ChecksumException checksumException = new com.dcloud.zxing2.ChecksumException();
        INSTANCE = checksumException;
        checksumException.setStackTrace(com.dcloud.zxing2.ReaderException.NO_TRACE);
    }

    private ChecksumException() {
    }

    public static com.dcloud.zxing2.ChecksumException getChecksumInstance() {
        return com.dcloud.zxing2.ReaderException.isStackTrace ? new com.dcloud.zxing2.ChecksumException() : INSTANCE;
    }

    private ChecksumException(java.lang.Throwable th) {
        super(th);
    }

    public static com.dcloud.zxing2.ChecksumException getChecksumInstance(java.lang.Throwable th) {
        return com.dcloud.zxing2.ReaderException.isStackTrace ? new com.dcloud.zxing2.ChecksumException(th) : INSTANCE;
    }
}
