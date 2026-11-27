package net.lingala.zip4j.io.inputstream;

/* JADX INFO: loaded from: classes2.dex */
abstract class DecompressedInputStream extends java.io.InputStream {
    private net.lingala.zip4j.io.inputstream.CipherInputStream<?> cipherInputStream;
    protected byte[] oneByteBuffer = new byte[1];

    public int pushBackInputStreamIfNecessary(java.io.PushbackInputStream pushbackInputStream) throws java.io.IOException {
        return 0;
    }

    public DecompressedInputStream(net.lingala.zip4j.io.inputstream.CipherInputStream<?> cipherInputStream) {
        this.cipherInputStream = cipherInputStream;
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        if (read(this.oneByteBuffer) == -1) {
            return -1;
        }
        return this.oneByteBuffer[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws java.io.IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        return this.cipherInputStream.read(bArr, i, i2);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.cipherInputStream.close();
    }

    public void endOfEntryReached(java.io.InputStream inputStream, int i) throws java.io.IOException {
        this.cipherInputStream.endOfEntryReached(inputStream, i);
    }

    protected byte[] getLastReadRawDataCache() {
        return this.cipherInputStream.getLastReadRawDataCache();
    }
}
