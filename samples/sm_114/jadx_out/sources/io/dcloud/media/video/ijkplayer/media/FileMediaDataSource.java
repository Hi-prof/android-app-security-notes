package io.dcloud.media.video.ijkplayer.media;

/* JADX INFO: loaded from: classes2.dex */
public class FileMediaDataSource implements tv.danmaku.ijk.media.player.misc.IMediaDataSource {
    private java.io.RandomAccessFile mFile;
    private long mFileSize;

    public FileMediaDataSource(java.io.File file) throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "r");
        this.mFile = randomAccessFile;
        this.mFileSize = randomAccessFile.length();
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws java.io.IOException {
        if (this.mFile.getFilePointer() != j) {
            this.mFile.seek(j);
        }
        if (i2 == 0) {
            return 0;
        }
        return this.mFile.read(bArr, 0, i2);
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public long getSize() throws java.io.IOException {
        return this.mFileSize;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public void close() throws java.io.IOException {
        this.mFileSize = 0L;
        this.mFile.close();
        this.mFile = null;
    }
}
