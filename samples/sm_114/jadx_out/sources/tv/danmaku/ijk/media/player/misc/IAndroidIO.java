package tv.danmaku.ijk.media.player.misc;

/* JADX INFO: loaded from: classes2.dex */
public interface IAndroidIO {
    int close() throws java.io.IOException;

    int open(java.lang.String str) throws java.io.IOException;

    int read(byte[] bArr, int i) throws java.io.IOException;

    long seek(long j, int i) throws java.io.IOException;
}
