package tv.danmaku.ijk.media.player.misc;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidMediaFormat implements tv.danmaku.ijk.media.player.misc.IMediaFormat {
    private final android.media.MediaFormat mMediaFormat;

    public AndroidMediaFormat(android.media.MediaFormat mediaFormat) {
        this.mMediaFormat = mediaFormat;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaFormat
    public int getInteger(java.lang.String str) {
        android.media.MediaFormat mediaFormat = this.mMediaFormat;
        if (mediaFormat == null) {
            return 0;
        }
        return mediaFormat.getInteger(str);
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaFormat
    public java.lang.String getString(java.lang.String str) {
        android.media.MediaFormat mediaFormat = this.mMediaFormat;
        if (mediaFormat == null) {
            return null;
        }
        return mediaFormat.getString(str);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
        sb.append(getClass().getName());
        sb.append(com.taobao.weex.el.parse.Operators.BLOCK_START);
        android.media.MediaFormat mediaFormat = this.mMediaFormat;
        if (mediaFormat != null) {
            sb.append(mediaFormat.toString());
        } else {
            sb.append("null");
        }
        sb.append(com.taobao.weex.el.parse.Operators.BLOCK_END);
        return sb.toString();
    }
}
