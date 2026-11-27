package net.lingala.zip4j.io.outputstream;

/* JADX INFO: loaded from: classes2.dex */
public class CountingOutputStream extends java.io.OutputStream implements net.lingala.zip4j.io.outputstream.OutputStreamWithSplitZipSupport {
    private long numberOfBytesWritten = 0;
    private java.io.OutputStream outputStream;

    public CountingOutputStream(java.io.OutputStream outputStream) {
        this.outputStream = outputStream;
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
        this.outputStream.write(bArr, i, i2);
        this.numberOfBytesWritten += (long) i2;
    }

    @Override // net.lingala.zip4j.io.outputstream.OutputStreamWithSplitZipSupport
    public int getCurrentSplitFileCounter() {
        if (isSplitZipFile()) {
            return ((net.lingala.zip4j.io.outputstream.SplitOutputStream) this.outputStream).getCurrentSplitFileCounter();
        }
        return 0;
    }

    public long getOffsetForNextEntry() throws java.io.IOException {
        java.io.OutputStream outputStream = this.outputStream;
        if (outputStream instanceof net.lingala.zip4j.io.outputstream.SplitOutputStream) {
            return ((net.lingala.zip4j.io.outputstream.SplitOutputStream) outputStream).getFilePointer();
        }
        return this.numberOfBytesWritten;
    }

    public long getSplitLength() {
        if (isSplitZipFile()) {
            return ((net.lingala.zip4j.io.outputstream.SplitOutputStream) this.outputStream).getSplitLength();
        }
        return 0L;
    }

    public boolean isSplitZipFile() {
        java.io.OutputStream outputStream = this.outputStream;
        return (outputStream instanceof net.lingala.zip4j.io.outputstream.SplitOutputStream) && ((net.lingala.zip4j.io.outputstream.SplitOutputStream) outputStream).isSplitZipFile();
    }

    public long getNumberOfBytesWritten() throws java.io.IOException {
        java.io.OutputStream outputStream = this.outputStream;
        if (outputStream instanceof net.lingala.zip4j.io.outputstream.SplitOutputStream) {
            return ((net.lingala.zip4j.io.outputstream.SplitOutputStream) outputStream).getFilePointer();
        }
        return this.numberOfBytesWritten;
    }

    public boolean checkBuffSizeAndStartNextSplitFile(int i) throws net.lingala.zip4j.exception.ZipException {
        if (isSplitZipFile()) {
            return ((net.lingala.zip4j.io.outputstream.SplitOutputStream) this.outputStream).checkBufferSizeAndStartNextSplitFile(i);
        }
        return false;
    }

    @Override // net.lingala.zip4j.io.outputstream.OutputStreamWithSplitZipSupport
    public long getFilePointer() throws java.io.IOException {
        java.io.OutputStream outputStream = this.outputStream;
        if (outputStream instanceof net.lingala.zip4j.io.outputstream.SplitOutputStream) {
            return ((net.lingala.zip4j.io.outputstream.SplitOutputStream) outputStream).getFilePointer();
        }
        return this.numberOfBytesWritten;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.outputStream.close();
    }
}
