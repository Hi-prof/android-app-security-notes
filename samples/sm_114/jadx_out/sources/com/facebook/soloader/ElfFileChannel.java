package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public class ElfFileChannel implements com.facebook.soloader.ElfByteChannel {
    private java.nio.channels.FileChannel mFc;
    private java.io.File mFile;
    private java.io.FileInputStream mIs;

    public ElfFileChannel(java.io.File file) throws java.io.IOException {
        this.mFile = file;
        openChannel();
    }

    public void openChannel() throws java.io.IOException {
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(this.mFile);
        this.mIs = fileInputStream;
        this.mFc = fileInputStream.getChannel();
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public long position() throws java.io.IOException {
        return this.mFc.position();
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public com.facebook.soloader.ElfByteChannel position(long j) throws java.io.IOException {
        this.mFc.position(j);
        return this;
    }

    @Override // com.facebook.soloader.ElfByteChannel, java.nio.channels.ReadableByteChannel
    public int read(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        return this.mFc.read(byteBuffer);
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public int read(java.nio.ByteBuffer byteBuffer, long j) throws java.io.IOException {
        return this.mFc.read(byteBuffer, j);
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public long size() throws java.io.IOException {
        return this.mFc.size();
    }

    @Override // com.facebook.soloader.ElfByteChannel
    public com.facebook.soloader.ElfByteChannel truncate(long j) throws java.io.IOException {
        this.mFc.truncate(j);
        return this;
    }

    @Override // com.facebook.soloader.ElfByteChannel, java.nio.channels.WritableByteChannel
    public int write(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        return this.mFc.write(byteBuffer);
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.mIs.close();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.mFc.isOpen();
    }
}
