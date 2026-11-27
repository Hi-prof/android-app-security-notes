package net.lingala.zip4j.io.outputstream;

/* JADX INFO: loaded from: classes2.dex */
public class SplitOutputStream extends java.io.OutputStream implements net.lingala.zip4j.io.outputstream.OutputStreamWithSplitZipSupport {
    private long bytesWrittenForThisPart;
    private int currSplitFileCounter;
    private java.io.RandomAccessFile raf;
    private net.lingala.zip4j.util.RawIO rawIO;
    private long splitLength;
    private java.io.File zipFile;

    public SplitOutputStream(java.io.File file) throws net.lingala.zip4j.exception.ZipException, java.io.FileNotFoundException {
        this(file, -1L);
    }

    public SplitOutputStream(java.io.File file, long j) throws net.lingala.zip4j.exception.ZipException, java.io.FileNotFoundException {
        this.rawIO = new net.lingala.zip4j.util.RawIO();
        if (j >= 0 && j < tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
            throw new net.lingala.zip4j.exception.ZipException("split length less than minimum allowed split length of 65536 Bytes");
        }
        this.raf = new java.io.RandomAccessFile(file, net.lingala.zip4j.model.enums.RandomAccessFileMode.WRITE.getValue());
        this.splitLength = j;
        this.zipFile = file;
        this.currSplitFileCounter = 0;
        this.bytesWrittenForThisPart = 0L;
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
        if (i2 <= 0) {
            return;
        }
        long j = this.splitLength;
        if (j == -1) {
            this.raf.write(bArr, i, i2);
            this.bytesWrittenForThisPart += (long) i2;
            return;
        }
        long j2 = this.bytesWrittenForThisPart;
        if (j2 >= j) {
            startNextSplitFile();
            this.raf.write(bArr, i, i2);
            this.bytesWrittenForThisPart = i2;
            return;
        }
        long j3 = i2;
        if (j2 + j3 > j) {
            if (isHeaderData(bArr)) {
                startNextSplitFile();
                this.raf.write(bArr, i, i2);
                this.bytesWrittenForThisPart = j3;
                return;
            }
            this.raf.write(bArr, i, (int) (this.splitLength - this.bytesWrittenForThisPart));
            startNextSplitFile();
            java.io.RandomAccessFile randomAccessFile = this.raf;
            long j4 = this.splitLength;
            long j5 = this.bytesWrittenForThisPart;
            randomAccessFile.write(bArr, i + ((int) (j4 - j5)), (int) (j3 - (j4 - j5)));
            this.bytesWrittenForThisPart = j3 - (this.splitLength - this.bytesWrittenForThisPart);
            return;
        }
        this.raf.write(bArr, i, i2);
        this.bytesWrittenForThisPart += j3;
    }

    private void startNextSplitFile() throws java.io.IOException {
        java.lang.String str;
        java.lang.String zipFileNameWithoutExtension = net.lingala.zip4j.util.FileUtils.getZipFileNameWithoutExtension(this.zipFile.getName());
        java.lang.String absolutePath = this.zipFile.getAbsolutePath();
        if (this.zipFile.getParent() == null) {
            str = "";
        } else {
            str = this.zipFile.getParent() + java.lang.System.getProperty("file.separator");
        }
        java.lang.String str2 = ".z0" + (this.currSplitFileCounter + 1);
        if (this.currSplitFileCounter >= 9) {
            str2 = ".z" + (this.currSplitFileCounter + 1);
        }
        java.io.File file = new java.io.File(str + zipFileNameWithoutExtension + str2);
        this.raf.close();
        if (file.exists()) {
            throw new java.io.IOException("split file: " + file.getName() + " already exists in the current directory, cannot rename this file");
        }
        if (!this.zipFile.renameTo(file)) {
            throw new java.io.IOException("cannot rename newly created split file");
        }
        this.zipFile = new java.io.File(absolutePath);
        this.raf = new java.io.RandomAccessFile(this.zipFile, net.lingala.zip4j.model.enums.RandomAccessFileMode.WRITE.getValue());
        this.currSplitFileCounter++;
    }

    private boolean isHeaderData(byte[] bArr) {
        int intLittleEndian = this.rawIO.readIntLittleEndian(bArr);
        for (net.lingala.zip4j.headers.HeaderSignature headerSignature : net.lingala.zip4j.headers.HeaderSignature.values()) {
            if (headerSignature != net.lingala.zip4j.headers.HeaderSignature.SPLIT_ZIP && headerSignature.getValue() == intLittleEndian) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBufferSizeAndStartNextSplitFile(int i) throws net.lingala.zip4j.exception.ZipException {
        if (i < 0) {
            throw new net.lingala.zip4j.exception.ZipException("negative buffersize for checkBufferSizeAndStartNextSplitFile");
        }
        if (isBufferSizeFitForCurrSplitFile(i)) {
            return false;
        }
        try {
            startNextSplitFile();
            this.bytesWrittenForThisPart = 0L;
            return true;
        } catch (java.io.IOException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    private boolean isBufferSizeFitForCurrSplitFile(int i) {
        long j = this.splitLength;
        return j < tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_BACK_CENTER || this.bytesWrittenForThisPart + ((long) i) <= j;
    }

    public void seek(long j) throws java.io.IOException {
        this.raf.seek(j);
    }

    public int skipBytes(int i) throws java.io.IOException {
        return this.raf.skipBytes(i);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.raf.close();
    }

    @Override // net.lingala.zip4j.io.outputstream.OutputStreamWithSplitZipSupport
    public long getFilePointer() throws java.io.IOException {
        return this.raf.getFilePointer();
    }

    public boolean isSplitZipFile() {
        return this.splitLength != -1;
    }

    public long getSplitLength() {
        return this.splitLength;
    }

    @Override // net.lingala.zip4j.io.outputstream.OutputStreamWithSplitZipSupport
    public int getCurrentSplitFileCounter() {
        return this.currSplitFileCounter;
    }
}
