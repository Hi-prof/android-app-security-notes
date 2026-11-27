package net.lingala.zip4j.io.inputstream;

/* JADX INFO: loaded from: classes2.dex */
abstract class CipherInputStream<T extends net.lingala.zip4j.crypto.Decrypter> extends java.io.InputStream {
    private T decrypter;
    private byte[] lastReadRawDataCache;
    private net.lingala.zip4j.model.LocalFileHeader localFileHeader;
    private byte[] singleByteBuffer = new byte[1];
    private net.lingala.zip4j.io.inputstream.ZipEntryInputStream zipEntryInputStream;

    protected void endOfEntryReached(java.io.InputStream inputStream, int i) throws java.io.IOException {
    }

    protected abstract T initializeDecrypter(net.lingala.zip4j.model.LocalFileHeader localFileHeader, char[] cArr, boolean z) throws java.io.IOException;

    public CipherInputStream(net.lingala.zip4j.io.inputstream.ZipEntryInputStream zipEntryInputStream, net.lingala.zip4j.model.LocalFileHeader localFileHeader, char[] cArr, int i, boolean z) throws java.io.IOException {
        this.zipEntryInputStream = zipEntryInputStream;
        this.decrypter = (T) initializeDecrypter(localFileHeader, cArr, z);
        this.localFileHeader = localFileHeader;
        if (net.lingala.zip4j.util.Zip4jUtil.getCompressionMethod(localFileHeader).equals(net.lingala.zip4j.model.enums.CompressionMethod.DEFLATE)) {
            this.lastReadRawDataCache = new byte[i];
        }
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        if (read(this.singleByteBuffer) == -1) {
            return -1;
        }
        return this.singleByteBuffer[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws java.io.IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int fully = net.lingala.zip4j.util.Zip4jUtil.readFully(this.zipEntryInputStream, bArr, i, i2);
        if (fully > 0) {
            cacheRawData(bArr, fully);
            this.decrypter.decryptData(bArr, i, fully);
        }
        return fully;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.zipEntryInputStream.close();
    }

    public byte[] getLastReadRawDataCache() {
        return this.lastReadRawDataCache;
    }

    protected int readRaw(byte[] bArr) throws java.io.IOException {
        return this.zipEntryInputStream.readRawFully(bArr);
    }

    private void cacheRawData(byte[] bArr, int i) {
        byte[] bArr2 = this.lastReadRawDataCache;
        if (bArr2 != null) {
            java.lang.System.arraycopy(bArr, 0, bArr2, 0, i);
        }
    }

    public T getDecrypter() {
        return this.decrypter;
    }

    protected long getNumberOfBytesReadForThisEntry() {
        return this.zipEntryInputStream.getNumberOfBytesRead();
    }

    public net.lingala.zip4j.model.LocalFileHeader getLocalFileHeader() {
        return this.localFileHeader;
    }
}
