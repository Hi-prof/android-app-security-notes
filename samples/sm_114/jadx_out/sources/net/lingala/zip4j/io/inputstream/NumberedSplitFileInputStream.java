package net.lingala.zip4j.io.inputstream;

/* JADX INFO: loaded from: classes2.dex */
public class NumberedSplitFileInputStream extends net.lingala.zip4j.io.inputstream.SplitFileInputStream {
    private java.io.RandomAccessFile randomAccessFile;

    public NumberedSplitFileInputStream(java.io.File file) throws java.io.IOException {
        this.randomAccessFile = new net.lingala.zip4j.io.inputstream.NumberedSplitRandomAccessFile(file, net.lingala.zip4j.model.enums.RandomAccessFileMode.READ.getValue());
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        return this.randomAccessFile.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws java.io.IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        return this.randomAccessFile.read(bArr, i, i2);
    }

    @Override // net.lingala.zip4j.io.inputstream.SplitFileInputStream
    public void prepareExtractionForFileHeader(net.lingala.zip4j.model.FileHeader fileHeader) throws java.io.IOException {
        this.randomAccessFile.seek(fileHeader.getOffsetLocalHeader());
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = this.randomAccessFile;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }
}
