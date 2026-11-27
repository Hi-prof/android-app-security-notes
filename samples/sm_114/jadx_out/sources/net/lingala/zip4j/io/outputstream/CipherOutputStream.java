package net.lingala.zip4j.io.outputstream;

/* JADX INFO: loaded from: classes2.dex */
abstract class CipherOutputStream<T extends net.lingala.zip4j.crypto.Encrypter> extends java.io.OutputStream {
    private T encrypter;
    private net.lingala.zip4j.io.outputstream.ZipEntryOutputStream zipEntryOutputStream;

    protected abstract T initializeEncrypter(java.io.OutputStream outputStream, net.lingala.zip4j.model.ZipParameters zipParameters, char[] cArr, boolean z) throws java.io.IOException;

    public CipherOutputStream(net.lingala.zip4j.io.outputstream.ZipEntryOutputStream zipEntryOutputStream, net.lingala.zip4j.model.ZipParameters zipParameters, char[] cArr, boolean z) throws java.io.IOException {
        this.zipEntryOutputStream = zipEntryOutputStream;
        this.encrypter = (T) initializeEncrypter(zipEntryOutputStream, zipParameters, cArr, z);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        this.zipEntryOutputStream.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws java.io.IOException {
        this.zipEntryOutputStream.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        this.encrypter.encryptData(bArr, i, i2);
        this.zipEntryOutputStream.write(bArr, i, i2);
    }

    public void writeHeaders(byte[] bArr) throws java.io.IOException {
        this.zipEntryOutputStream.write(bArr);
    }

    public void closeEntry() throws java.io.IOException {
        this.zipEntryOutputStream.closeEntry();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.zipEntryOutputStream.close();
    }

    public long getNumberOfBytesWrittenForThisEntry() {
        return this.zipEntryOutputStream.getNumberOfBytesWrittenForThisEntry();
    }

    protected T getEncrypter() {
        return this.encrypter;
    }
}
