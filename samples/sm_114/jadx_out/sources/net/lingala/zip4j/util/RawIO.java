package net.lingala.zip4j.util;

/* JADX INFO: loaded from: classes2.dex */
public class RawIO {
    private final byte[] shortBuff = new byte[2];
    private final byte[] intBuff = new byte[4];
    private final byte[] longBuff = new byte[8];

    public long readLongLittleEndian(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
        randomAccessFile.readFully(this.longBuff);
        return readLongLittleEndian(this.longBuff, 0);
    }

    public long readLongLittleEndian(java.io.RandomAccessFile randomAccessFile, int i) throws java.io.IOException {
        resetBytes(this.longBuff);
        randomAccessFile.readFully(this.longBuff, 0, i);
        return readLongLittleEndian(this.longBuff, 0);
    }

    public long readLongLittleEndian(java.io.InputStream inputStream) throws java.io.IOException {
        byte[] bArr = this.longBuff;
        readFully(inputStream, bArr, bArr.length);
        return readLongLittleEndian(this.longBuff, 0);
    }

    public long readLongLittleEndian(java.io.InputStream inputStream, int i) throws java.io.IOException {
        resetBytes(this.longBuff);
        readFully(inputStream, this.longBuff, i);
        return readLongLittleEndian(this.longBuff, 0);
    }

    public long readLongLittleEndian(byte[] bArr, int i) {
        if (bArr.length - i < 8) {
            resetBytes(this.longBuff);
        }
        java.lang.System.arraycopy(bArr, i, this.longBuff, 0, java.lang.Math.min(bArr.length - i, 8));
        byte[] bArr2 = this.longBuff;
        return ((long) (bArr2[0] & 255)) | (((((((((((((((long) (bArr2[7] & 255)) << 8) | ((long) (bArr2[6] & 255))) << 8) | ((long) (bArr2[5] & 255))) << 8) | ((long) (bArr2[4] & 255))) << 8) | ((long) (bArr2[3] & 255))) << 8) | ((long) (bArr2[2] & 255))) << 8) | ((long) (bArr2[1] & 255))) << 8);
    }

    public int readIntLittleEndian(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
        randomAccessFile.readFully(this.intBuff);
        return readIntLittleEndian(this.intBuff);
    }

    public int readIntLittleEndian(java.io.InputStream inputStream) throws java.io.IOException {
        readFully(inputStream, this.intBuff, 4);
        return readIntLittleEndian(this.intBuff);
    }

    public int readIntLittleEndian(byte[] bArr) {
        return readIntLittleEndian(bArr, 0);
    }

    public int readIntLittleEndian(byte[] bArr, int i) {
        return ((((bArr[i + 3] & 255) << 8) | (bArr[i + 2] & 255)) << 16) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
    }

    public int readShortLittleEndian(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
        randomAccessFile.readFully(this.shortBuff);
        return readShortLittleEndian(this.shortBuff, 0);
    }

    public int readShortLittleEndian(java.io.InputStream inputStream) throws java.io.IOException {
        byte[] bArr = this.shortBuff;
        readFully(inputStream, bArr, bArr.length);
        return readShortLittleEndian(this.shortBuff, 0);
    }

    public int readShortLittleEndian(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    public void writeShortLittleEndian(java.io.OutputStream outputStream, int i) throws java.io.IOException {
        writeShortLittleEndian(this.shortBuff, 0, i);
        outputStream.write(this.shortBuff);
    }

    public void writeShortLittleEndian(byte[] bArr, int i, int i2) {
        bArr[i + 1] = (byte) (i2 >>> 8);
        bArr[i] = (byte) (i2 & 255);
    }

    public void writeIntLittleEndian(java.io.OutputStream outputStream, int i) throws java.io.IOException {
        writeIntLittleEndian(this.intBuff, 0, i);
        outputStream.write(this.intBuff);
    }

    public void writeIntLittleEndian(byte[] bArr, int i, int i2) {
        bArr[i + 3] = (byte) (i2 >>> 24);
        bArr[i + 2] = (byte) (i2 >>> 16);
        bArr[i + 1] = (byte) (i2 >>> 8);
        bArr[i] = (byte) (i2 & 255);
    }

    public void writeLongLittleEndian(java.io.OutputStream outputStream, long j) throws java.io.IOException {
        writeLongLittleEndian(this.longBuff, 0, j);
        outputStream.write(this.longBuff);
    }

    public void writeLongLittleEndian(byte[] bArr, int i, long j) {
        bArr[i + 7] = (byte) (j >>> 56);
        bArr[i + 6] = (byte) (j >>> 48);
        bArr[i + 5] = (byte) (j >>> 40);
        bArr[i + 4] = (byte) (j >>> 32);
        bArr[i + 3] = (byte) (j >>> 24);
        bArr[i + 2] = (byte) (j >>> 16);
        bArr[i + 1] = (byte) (j >>> 8);
        bArr[i] = (byte) (j & 255);
    }

    private void readFully(java.io.InputStream inputStream, byte[] bArr, int i) throws java.io.IOException {
        if (net.lingala.zip4j.util.Zip4jUtil.readFully(inputStream, bArr, 0, i) != i) {
            throw new net.lingala.zip4j.exception.ZipException("Could not fill buffer");
        }
    }

    private void resetBytes(byte[] bArr) {
        java.util.Arrays.fill(bArr, (byte) 0);
    }
}
