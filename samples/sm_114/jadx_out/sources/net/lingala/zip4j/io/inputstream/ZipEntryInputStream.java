package net.lingala.zip4j.io.inputstream;

/* JADX INFO: loaded from: classes2.dex */
class ZipEntryInputStream extends java.io.InputStream {
    private static final int MAX_RAW_READ_FULLY_RETRY_ATTEMPTS = 15;
    private long compressedSize;
    private java.io.InputStream inputStream;
    private long numberOfBytesRead = 0;
    private byte[] singleByteArray = new byte[1];

    public ZipEntryInputStream(java.io.InputStream inputStream, long j) {
        this.inputStream = inputStream;
        this.compressedSize = j;
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        if (read(this.singleByteArray) == -1) {
            return -1;
        }
        return this.singleByteArray[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws java.io.IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        long j = this.compressedSize;
        if (j != -1) {
            long j2 = this.numberOfBytesRead;
            if (j2 >= j) {
                return -1;
            }
            if (i2 > j - j2) {
                i2 = (int) (j - j2);
            }
        }
        int i3 = this.inputStream.read(bArr, i, i2);
        if (i3 > 0) {
            this.numberOfBytesRead += (long) i3;
        }
        return i3;
    }

    public int readRawFully(byte[] bArr) throws java.io.IOException {
        int i = this.inputStream.read(bArr);
        if (i == -1) {
            throw new java.io.IOException("Unexpected EOF reached when trying to read stream");
        }
        if (i == bArr.length) {
            return i;
        }
        int untilBufferIsFull = readUntilBufferIsFull(bArr, i);
        if (untilBufferIsFull == bArr.length) {
            return untilBufferIsFull;
        }
        throw new java.io.IOException("Cannot read fully into byte buffer");
    }

    private int readUntilBufferIsFull(byte[] bArr, int i) throws java.io.IOException {
        int length = bArr.length - i;
        int i2 = 0;
        for (int i3 = 0; i < bArr.length && i2 != -1 && i3 < 15; i3++) {
            i2 += this.inputStream.read(bArr, i, length);
            if (i2 > 0) {
                i += i2;
                length -= i2;
            }
        }
        return i;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.inputStream.close();
    }

    public long getNumberOfBytesRead() {
        return this.numberOfBytesRead;
    }
}
