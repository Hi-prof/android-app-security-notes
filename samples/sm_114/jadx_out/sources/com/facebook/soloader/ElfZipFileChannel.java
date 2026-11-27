package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public class ElfZipFileChannel implements com.facebook.soloader.ElfByteChannel {

    @javax.annotation.Nullable
    private java.io.InputStream mIs;
    private final long mLength;
    private boolean mOpened = true;
    private long mPos = 0;
    private final java.util.zip.ZipEntry mZipEntry;
    private final java.util.zip.ZipFile mZipFile;

    public ElfZipFileChannel(java.util.zip.ZipFile zipFile, java.util.zip.ZipEntry zipEntry) throws java.io.IOException {
        this.mZipFile = zipFile;
        this.mZipEntry = zipEntry;
        this.mLength = zipEntry.getSize();
        java.io.InputStream inputStream = zipFile.getInputStream(zipEntry);
        this.mIs = inputStream;
        if (inputStream != null) {
            return;
        }
        throw new java.io.IOException(zipEntry.getName() + "'s InputStream is null");
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public long position() throws java.io.IOException {
        return this.mPos;
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public com.facebook.soloader.ElfByteChannel position(long j) throws java.io.IOException {
        java.io.InputStream inputStream = this.mIs;
        if (inputStream == null) {
            throw new java.io.IOException(this.mZipEntry.getName() + "'s InputStream is null");
        }
        long j2 = this.mPos;
        if (j == j2) {
            return this;
        }
        long j3 = this.mLength;
        if (j > j3) {
            j = j3;
        }
        if (j >= j2) {
            inputStream.skip(j - j2);
        } else {
            inputStream.close();
            java.io.InputStream inputStream2 = this.mZipFile.getInputStream(this.mZipEntry);
            this.mIs = inputStream2;
            if (inputStream2 == null) {
                throw new java.io.IOException(this.mZipEntry.getName() + "'s InputStream is null");
            }
            inputStream2.skip(j);
        }
        this.mPos = j;
        return this;
    }

    @Override // com.facebook.soloader.ElfByteChannel, java.nio.channels.ReadableByteChannel
    public int read(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        return read(byteBuffer, this.mPos);
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public int read(java.nio.ByteBuffer byteBuffer, long j) throws java.io.IOException {
        if (this.mIs == null) {
            throw new java.io.IOException("InputStream is null");
        }
        int iRemaining = byteBuffer.remaining();
        long j2 = this.mLength - j;
        if (j2 <= 0) {
            return -1;
        }
        int i = (int) j2;
        if (iRemaining > i) {
            iRemaining = i;
        }
        position(j);
        if (byteBuffer.hasArray()) {
            this.mIs.read(byteBuffer.array(), 0, iRemaining);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        } else {
            byte[] bArr = new byte[iRemaining];
            this.mIs.read(bArr, 0, iRemaining);
            byteBuffer.put(bArr, 0, iRemaining);
        }
        this.mPos += (long) iRemaining;
        return iRemaining;
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public long size() throws java.io.IOException {
        return this.mLength;
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public com.facebook.soloader.ElfByteChannel truncate(long j) throws java.io.IOException {
        throw new java.lang.UnsupportedOperationException("ElfZipFileChannel doesn't support truncate");
    }

    @Override // com.facebook.soloader.ElfByteChannel, java.nio.channels.WritableByteChannel
    public int write(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        throw new java.lang.UnsupportedOperationException("ElfZipFileChannel doesn't support write");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.mOpened;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        java.io.InputStream inputStream = this.mIs;
        if (inputStream != null) {
            inputStream.close();
            this.mOpened = false;
        }
    }
}
