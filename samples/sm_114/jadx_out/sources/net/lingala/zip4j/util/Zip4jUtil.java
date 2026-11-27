package net.lingala.zip4j.util;

/* JADX INFO: loaded from: classes2.dex */
public class Zip4jUtil {
    private static final long DOSTIME_BEFORE_1980 = 2162688;
    private static final int MAX_RAW_READ_FULLY_RETRY_ATTEMPTS = 15;

    public static boolean isStringNullOrEmpty(java.lang.String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isStringNotNullAndNotEmpty(java.lang.String str) {
        return str != null && str.trim().length() > 0;
    }

    public static boolean createDirectoryIfNotExists(java.io.File file) throws net.lingala.zip4j.exception.ZipException {
        if (file == null) {
            throw new net.lingala.zip4j.exception.ZipException("output path is null");
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                return true;
            }
            throw new net.lingala.zip4j.exception.ZipException("output directory is not valid");
        }
        if (file.mkdirs()) {
            return true;
        }
        throw new net.lingala.zip4j.exception.ZipException("Cannot create output directories");
    }

    public static long epochToExtendedDosTime(long j) {
        if (j < 0) {
            return DOSTIME_BEFORE_1980;
        }
        long jEpochToDosTime = epochToDosTime(j);
        return jEpochToDosTime != DOSTIME_BEFORE_1980 ? jEpochToDosTime + ((j % 2000) << 32) : DOSTIME_BEFORE_1980;
    }

    private static long epochToDosTime(long j) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(1);
        if (i < 1980) {
            return DOSTIME_BEFORE_1980;
        }
        return (calendar.get(13) >> 1) | ((i - 1980) << 25) | ((calendar.get(2) + 1) << 21) | (calendar.get(5) << 16) | (calendar.get(11) << 11) | (calendar.get(12) << 5);
    }

    public static long dosToExtendedEpochTme(long j) {
        return dosToEpochTime(j) + (j >> 32);
    }

    private static long dosToEpochTime(long j) {
        int i = (int) ((j >> 5) & 63);
        int i2 = (int) ((j >> 11) & 31);
        int i3 = (int) ((j >> 16) & 31);
        int i4 = (int) (((j >> 21) & 15) - 1);
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set((int) (((j >> 25) & 127) + 1980), i4, i3, i2, i, (int) ((j << 1) & 62));
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    public static byte[] convertCharArrayToByteArray(char[] cArr, boolean z) {
        if (z) {
            return convertCharArrayToByteArrayUsingUtf8(cArr);
        }
        return convertCharArrayToByteArrayUsingDefaultCharset(cArr);
    }

    public static net.lingala.zip4j.model.enums.CompressionMethod getCompressionMethod(net.lingala.zip4j.model.AbstractFileHeader abstractFileHeader) throws net.lingala.zip4j.exception.ZipException {
        if (abstractFileHeader.getCompressionMethod() != net.lingala.zip4j.model.enums.CompressionMethod.AES_INTERNAL_ONLY) {
            return abstractFileHeader.getCompressionMethod();
        }
        if (abstractFileHeader.getAesExtraDataRecord() == null) {
            throw new net.lingala.zip4j.exception.ZipException("AesExtraDataRecord not present in local header for aes encrypted data");
        }
        return abstractFileHeader.getAesExtraDataRecord().getCompressionMethod();
    }

    public static int readFully(java.io.InputStream inputStream, byte[] bArr) throws java.io.IOException {
        int i = inputStream.read(bArr);
        if (i == -1) {
            throw new java.io.IOException("Unexpected EOF reached when trying to read stream");
        }
        if (i == bArr.length) {
            return i;
        }
        int untilBufferIsFull = readUntilBufferIsFull(inputStream, bArr, i);
        if (untilBufferIsFull == bArr.length) {
            return untilBufferIsFull;
        }
        throw new java.io.IOException("Cannot read fully into byte buffer");
    }

    public static int readFully(java.io.InputStream inputStream, byte[] bArr, int i, int i2) throws java.io.IOException {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("Negative offset");
        }
        if (i2 < 0) {
            throw new java.lang.IllegalArgumentException("Negative length");
        }
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        if (i + i2 > bArr.length) {
            throw new java.lang.IllegalArgumentException("Length greater than buffer size");
        }
        while (i3 != i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 != -1) {
                i3 += i4;
            } else if (i3 == 0) {
                return -1;
            }
        }
        return i3;
    }

    private static int readUntilBufferIsFull(java.io.InputStream inputStream, byte[] bArr, int i) throws java.io.IOException {
        if (i < 0) {
            throw new java.io.IOException("Invalid readLength");
        }
        int i2 = 0;
        if (i == 0) {
            return 0;
        }
        int length = bArr.length - i;
        for (int i3 = 1; i < bArr.length && i2 != -1 && i3 < 15; i3++) {
            i2 = inputStream.read(bArr, i, length);
            if (i2 > 0) {
                i += i2;
                length -= i2;
            }
        }
        return i;
    }

    private static byte[] convertCharArrayToByteArrayUsingUtf8(char[] cArr) {
        try {
            java.nio.ByteBuffer byteBufferEncode = net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF_8.encode(java.nio.CharBuffer.wrap(cArr));
            byte[] bArr = new byte[byteBufferEncode.limit()];
            byteBufferEncode.get(bArr);
            return bArr;
        } catch (java.lang.Exception unused) {
            return convertCharArrayToByteArrayUsingDefaultCharset(cArr);
        }
    }

    private static byte[] convertCharArrayToByteArrayUsingDefaultCharset(char[] cArr) {
        byte[] bArr = new byte[cArr.length];
        for (int i = 0; i < cArr.length; i++) {
            bArr[i] = (byte) cArr[i];
        }
        return bArr;
    }
}
