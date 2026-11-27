package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/FileInformation;", "", "<init>", "()V", "inputStream", "Ljava/io/InputStream;", "getInputStream", "()Ljava/io/InputStream;", "setInputStream", "(Ljava/io/InputStream;)V", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, "", "getSize", "()J", "setSize", "(J)V", tv.danmaku.ijk.media.player.misc.IMediaFormat.KEY_MIME, "", "getMime", "()Ljava/lang/String;", "setMime", "(Ljava/lang/String;)V", "name", "getName", "setName", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class FileInformation {
    private java.io.InputStream inputStream;
    private java.lang.String mime;
    private java.lang.String name;
    private long size = -1;

    public java.io.InputStream getInputStream() {
        return this.inputStream;
    }

    public void setInputStream(java.io.InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public java.lang.String getMime() {
        return this.mime;
    }

    public void setMime(java.lang.String str) {
        this.mime = str;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }
}
