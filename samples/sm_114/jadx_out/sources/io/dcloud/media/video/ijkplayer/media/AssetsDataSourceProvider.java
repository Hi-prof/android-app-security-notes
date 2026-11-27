package io.dcloud.media.video.ijkplayer.media;

/* JADX INFO: loaded from: classes2.dex */
public class AssetsDataSourceProvider implements tv.danmaku.ijk.media.player.misc.IMediaDataSource {
    private android.content.res.AssetFileDescriptor mDescriptor;
    private byte[] mMediaBytes;

    public AssetsDataSourceProvider(android.content.res.AssetFileDescriptor assetFileDescriptor) {
        this.mDescriptor = assetFileDescriptor;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) {
        long j2 = 1 + j;
        byte[] bArr2 = this.mMediaBytes;
        if (j2 >= bArr2.length) {
            return -1;
        }
        if (((long) i2) + j >= bArr2.length) {
            int length = (int) (((long) bArr2.length) - j);
            if (length > bArr.length) {
                length = bArr.length;
            }
            i2 = length - 1;
        }
        java.lang.System.arraycopy(bArr2, (int) j, bArr, i, i2);
        return i2;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public long getSize() throws java.io.IOException {
        long length = this.mDescriptor.getLength();
        if (this.mMediaBytes == null) {
            this.mMediaBytes = readBytes(this.mDescriptor.createInputStream());
        }
        return length;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public void close() throws java.io.IOException {
        android.content.res.AssetFileDescriptor assetFileDescriptor = this.mDescriptor;
        if (assetFileDescriptor != null) {
            assetFileDescriptor.close();
        }
        this.mDescriptor = null;
        this.mMediaBytes = null;
    }

    private byte[] readBytes(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
