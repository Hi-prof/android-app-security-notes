package com.dcloud.zxing2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class NotFoundException extends com.dcloud.zxing2.ReaderException {
    private static final com.dcloud.zxing2.NotFoundException INSTANCE;

    static {
        com.dcloud.zxing2.NotFoundException notFoundException = new com.dcloud.zxing2.NotFoundException();
        INSTANCE = notFoundException;
        notFoundException.setStackTrace(com.dcloud.zxing2.ReaderException.NO_TRACE);
    }

    private NotFoundException() {
    }

    public static com.dcloud.zxing2.NotFoundException getNotFoundInstance() {
        return INSTANCE;
    }
}
