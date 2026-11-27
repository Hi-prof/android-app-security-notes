package net.lingala.zip4j.io.outputstream;

/* JADX INFO: loaded from: classes2.dex */
abstract class CompressedOutputStream extends java.io.OutputStream {
    private net.lingala.zip4j.io.outputstream.CipherOutputStream<?> cipherOutputStream;

    public CompressedOutputStream(net.lingala.zip4j.io.outputstream.CipherOutputStream<?> cipherOutputStream) {
        this.cipherOutputStream = cipherOutputStream;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        write(new byte[]{(byte) i});
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws java.io.IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        this.cipherOutputStream.write(bArr, i, i2);
    }

    protected void closeEntry() throws java.io.IOException {
        this.cipherOutputStream.closeEntry();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.cipherOutputStream.close();
    }

    public long getCompressedSize() {
        return this.cipherOutputStream.getNumberOfBytesWrittenForThisEntry();
    }
}
