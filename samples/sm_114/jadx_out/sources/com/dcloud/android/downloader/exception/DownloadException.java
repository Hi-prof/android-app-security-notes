package com.dcloud.android.downloader.exception;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DownloadException extends java.lang.RuntimeException {
    public static final int EXCEPTION_FILE_SIZE_ZERO = 6;
    public static final int EXCEPTION_IO_EXCEPTION = 5;
    public static final int EXCEPTION_OTHER = 9;
    public static final int EXCEPTION_PATH_NULL = 1;
    public static final int EXCEPTION_PAUSE = 7;
    public static final int EXCEPTION_PROTOCOL = 4;
    public static final int EXCEPTION_SERVER_ERROR = 3;
    public static final int EXCEPTION_SERVER_SUPPORT_CODE = 8;
    public static final int EXCEPTION_URL_ERROR = 2;
    public static final int EXCEPTION_URL_NULL = 0;
    private int code;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ExceptionType {
    }

    public DownloadException(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public DownloadException(int i, java.lang.String str) {
        super(str);
        this.code = i;
    }

    public DownloadException(int i, java.lang.String str, java.lang.Throwable th) {
        super(str, th);
        this.code = i;
    }

    public DownloadException(int i, java.lang.Throwable th) {
        super(th);
        this.code = i;
    }
}
