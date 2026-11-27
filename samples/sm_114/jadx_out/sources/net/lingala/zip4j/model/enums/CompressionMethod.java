package net.lingala.zip4j.model.enums;

/* JADX INFO: loaded from: classes2.dex */
public enum CompressionMethod {
    STORE(0),
    DEFLATE(8),
    AES_INTERNAL_ONLY(99);

    private int code;

    CompressionMethod(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }

    public static net.lingala.zip4j.model.enums.CompressionMethod getCompressionMethodFromCode(int i) throws net.lingala.zip4j.exception.ZipException {
        for (net.lingala.zip4j.model.enums.CompressionMethod compressionMethod : values()) {
            if (compressionMethod.getCode() == i) {
                return compressionMethod;
            }
        }
        throw new net.lingala.zip4j.exception.ZipException("Unknown compression method", net.lingala.zip4j.exception.ZipException.Type.UNKNOWN_COMPRESSION_METHOD);
    }
}
