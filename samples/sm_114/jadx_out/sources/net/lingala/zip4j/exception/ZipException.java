package net.lingala.zip4j.exception;

/* JADX INFO: loaded from: classes2.dex */
public class ZipException extends java.io.IOException {
    private static final long serialVersionUID = 1;
    private net.lingala.zip4j.exception.ZipException.Type type;

    public enum Type {
        WRONG_PASSWORD,
        TASK_CANCELLED_EXCEPTION,
        CHECKSUM_MISMATCH,
        UNKNOWN_COMPRESSION_METHOD,
        FILE_NOT_FOUND,
        UNSUPPORTED_ENCRYPTION,
        UNKNOWN
    }

    public ZipException(java.lang.String str) {
        super(str);
        this.type = net.lingala.zip4j.exception.ZipException.Type.UNKNOWN;
    }

    public ZipException(java.lang.Exception exc) {
        super(exc);
        this.type = net.lingala.zip4j.exception.ZipException.Type.UNKNOWN;
    }

    public ZipException(java.lang.String str, java.lang.Exception exc) {
        super(str, exc);
        this.type = net.lingala.zip4j.exception.ZipException.Type.UNKNOWN;
    }

    public ZipException(java.lang.String str, net.lingala.zip4j.exception.ZipException.Type type) {
        super(str);
        net.lingala.zip4j.exception.ZipException.Type type2 = net.lingala.zip4j.exception.ZipException.Type.UNKNOWN;
        this.type = type;
    }

    public ZipException(java.lang.String str, java.lang.Throwable th, net.lingala.zip4j.exception.ZipException.Type type) {
        super(str, th);
        net.lingala.zip4j.exception.ZipException.Type type2 = net.lingala.zip4j.exception.ZipException.Type.UNKNOWN;
        this.type = type;
    }

    public net.lingala.zip4j.exception.ZipException.Type getType() {
        return this.type;
    }
}
