package net.lingala.zip4j.io.inputstream;

/* JADX INFO: loaded from: classes2.dex */
public class ZipStandardSplitFileInputStream extends net.lingala.zip4j.io.inputstream.SplitFileInputStream {
    private int currentSplitFileCounter;
    private boolean isSplitZipArchive;
    private int lastSplitZipFileNumber;
    protected java.io.RandomAccessFile randomAccessFile;
    private byte[] singleByteArray = new byte[1];
    protected java.io.File zipFile;

    public ZipStandardSplitFileInputStream(java.io.File file, boolean z, int i) throws java.io.FileNotFoundException {
        this.currentSplitFileCounter = 0;
        this.randomAccessFile = new java.io.RandomAccessFile(file, net.lingala.zip4j.model.enums.RandomAccessFileMode.READ.getValue());
        this.zipFile = file;
        this.isSplitZipArchive = z;
        this.lastSplitZipFileNumber = i;
        if (z) {
            this.currentSplitFileCounter = i;
        }
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
        int i3 = this.randomAccessFile.read(bArr, i, i2);
        if ((i3 == i2 && i3 != -1) || !this.isSplitZipArchive) {
            return i3;
        }
        openRandomAccessFileForIndex(this.currentSplitFileCounter + 1);
        this.currentSplitFileCounter++;
        if (i3 < 0) {
            i3 = 0;
        }
        int i4 = this.randomAccessFile.read(bArr, i3, i2 - i3);
        return i4 > 0 ? i3 + i4 : i3;
    }

    @Override // net.lingala.zip4j.io.inputstream.SplitFileInputStream
    public void prepareExtractionForFileHeader(net.lingala.zip4j.model.FileHeader fileHeader) throws java.io.IOException {
        if (this.isSplitZipArchive && this.currentSplitFileCounter != fileHeader.getDiskNumberStart()) {
            openRandomAccessFileForIndex(fileHeader.getDiskNumberStart());
            this.currentSplitFileCounter = fileHeader.getDiskNumberStart();
        }
        this.randomAccessFile.seek(fileHeader.getOffsetLocalHeader());
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = this.randomAccessFile;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }

    protected void openRandomAccessFileForIndex(int i) throws java.io.IOException {
        java.io.File nextSplitFile = getNextSplitFile(i);
        if (!nextSplitFile.exists()) {
            throw new java.io.FileNotFoundException("zip split file does not exist: " + nextSplitFile);
        }
        this.randomAccessFile.close();
        this.randomAccessFile = new java.io.RandomAccessFile(nextSplitFile, net.lingala.zip4j.model.enums.RandomAccessFileMode.READ.getValue());
    }

    protected java.io.File getNextSplitFile(int i) throws java.io.IOException {
        java.lang.String str;
        if (i == this.lastSplitZipFileNumber) {
            return this.zipFile;
        }
        java.lang.String canonicalPath = this.zipFile.getCanonicalPath();
        if (i < 9) {
            str = ".z0";
        } else {
            str = ".z";
        }
        return new java.io.File(canonicalPath.substring(0, canonicalPath.lastIndexOf(com.taobao.weex.el.parse.Operators.DOT_STR)) + str + (i + 1));
    }
}
