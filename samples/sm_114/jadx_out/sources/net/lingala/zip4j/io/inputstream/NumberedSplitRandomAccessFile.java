package net.lingala.zip4j.io.inputstream;

/* JADX INFO: loaded from: classes2.dex */
public class NumberedSplitRandomAccessFile extends java.io.RandomAccessFile {
    private java.io.File[] allSortedSplitFiles;
    private int currentOpenSplitFileCounter;
    private java.io.RandomAccessFile randomAccessFile;
    private java.lang.String rwMode;
    private byte[] singleByteBuffer;
    private long splitLength;

    public NumberedSplitRandomAccessFile(java.lang.String str, java.lang.String str2) throws java.io.IOException {
        this(new java.io.File(str), str2);
    }

    public NumberedSplitRandomAccessFile(java.io.File file, java.lang.String str) throws java.io.IOException {
        this(file, str, net.lingala.zip4j.util.FileUtils.getAllSortedNumberedSplitFiles(file));
    }

    public NumberedSplitRandomAccessFile(java.io.File file, java.lang.String str, java.io.File[] fileArr) throws java.io.IOException {
        super(file, str);
        this.singleByteBuffer = new byte[1];
        this.currentOpenSplitFileCounter = 0;
        super.close();
        if (net.lingala.zip4j.model.enums.RandomAccessFileMode.WRITE.getValue().equals(str)) {
            throw new java.lang.IllegalArgumentException("write mode is not allowed for NumberedSplitRandomAccessFile");
        }
        assertAllSplitFilesExist(fileArr);
        this.randomAccessFile = new java.io.RandomAccessFile(file, str);
        this.allSortedSplitFiles = fileArr;
        this.splitLength = file.length();
        this.rwMode = str;
    }

    @Override // java.io.RandomAccessFile
    public int read() throws java.io.IOException {
        if (read(this.singleByteBuffer) == -1) {
            return -1;
        }
        return this.singleByteBuffer[0] & 255;
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr) throws java.io.IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int i3 = this.randomAccessFile.read(bArr, i, i2);
        if (i3 != -1) {
            return i3;
        }
        int i4 = this.currentOpenSplitFileCounter;
        if (i4 == this.allSortedSplitFiles.length - 1) {
            return -1;
        }
        openRandomAccessFileForIndex(i4 + 1);
        return read(bArr, i, i2);
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(int i) throws java.io.IOException {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(byte[] bArr) throws java.io.IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.io.RandomAccessFile
    public void seek(long j) throws java.io.IOException {
        int i = (int) (j / this.splitLength);
        if (i != this.currentOpenSplitFileCounter) {
            openRandomAccessFileForIndex(i);
        }
        this.randomAccessFile.seek(j - (((long) i) * this.splitLength));
    }

    @Override // java.io.RandomAccessFile
    public long getFilePointer() throws java.io.IOException {
        return this.randomAccessFile.getFilePointer();
    }

    @Override // java.io.RandomAccessFile
    public long length() throws java.io.IOException {
        return this.randomAccessFile.length();
    }

    @Override // java.io.RandomAccessFile, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = this.randomAccessFile;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        super.close();
    }

    public void seekInCurrentPart(long j) throws java.io.IOException {
        this.randomAccessFile.seek(j);
    }

    public void openLastSplitFileForReading() throws java.io.IOException {
        openRandomAccessFileForIndex(this.allSortedSplitFiles.length - 1);
    }

    private void openRandomAccessFileForIndex(int i) throws java.io.IOException {
        if (this.currentOpenSplitFileCounter == i) {
            return;
        }
        if (i > this.allSortedSplitFiles.length - 1) {
            throw new java.io.IOException("split counter greater than number of split files");
        }
        java.io.RandomAccessFile randomAccessFile = this.randomAccessFile;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        this.randomAccessFile = new java.io.RandomAccessFile(this.allSortedSplitFiles[i], this.rwMode);
        this.currentOpenSplitFileCounter = i;
    }

    private void assertAllSplitFilesExist(java.io.File[] fileArr) throws java.io.IOException {
        int i = 1;
        for (java.io.File file : fileArr) {
            java.lang.String fileExtension = net.lingala.zip4j.util.FileUtils.getFileExtension(file);
            try {
                if (i != java.lang.Integer.parseInt(fileExtension)) {
                    throw new java.io.IOException("Split file number " + i + " does not exist");
                }
                i++;
            } catch (java.lang.NumberFormatException unused) {
                throw new java.io.IOException("Split file extension not in expected format. Found: " + fileExtension + " expected of format: .001, .002, etc");
            }
        }
    }
}
