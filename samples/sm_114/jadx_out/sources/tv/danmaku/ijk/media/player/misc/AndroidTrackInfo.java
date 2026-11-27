package tv.danmaku.ijk.media.player.misc;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidTrackInfo implements tv.danmaku.ijk.media.player.misc.ITrackInfo {
    private final android.media.MediaPlayer.TrackInfo mTrackInfo;

    public static tv.danmaku.ijk.media.player.misc.AndroidTrackInfo[] fromMediaPlayer(android.media.MediaPlayer mediaPlayer) {
        return fromTrackInfo(mediaPlayer.getTrackInfo());
    }

    private static tv.danmaku.ijk.media.player.misc.AndroidTrackInfo[] fromTrackInfo(android.media.MediaPlayer.TrackInfo[] trackInfoArr) {
        if (trackInfoArr == null) {
            return null;
        }
        tv.danmaku.ijk.media.player.misc.AndroidTrackInfo[] androidTrackInfoArr = new tv.danmaku.ijk.media.player.misc.AndroidTrackInfo[trackInfoArr.length];
        for (int i = 0; i < trackInfoArr.length; i++) {
            androidTrackInfoArr[i] = new tv.danmaku.ijk.media.player.misc.AndroidTrackInfo(trackInfoArr[i]);
        }
        return androidTrackInfoArr;
    }

    private AndroidTrackInfo(android.media.MediaPlayer.TrackInfo trackInfo) {
        this.mTrackInfo = trackInfo;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public tv.danmaku.ijk.media.player.misc.IMediaFormat getFormat() {
        android.media.MediaFormat format;
        if (this.mTrackInfo == null || (format = this.mTrackInfo.getFormat()) == null) {
            return null;
        }
        return new tv.danmaku.ijk.media.player.misc.AndroidMediaFormat(format);
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public java.lang.String getLanguage() {
        android.media.MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo == null) {
            return "und";
        }
        return trackInfo.getLanguage();
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public int getTrackType() {
        android.media.MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo == null) {
            return 0;
        }
        return trackInfo.getTrackType();
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append(com.taobao.weex.el.parse.Operators.BLOCK_START);
        android.media.MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo != null) {
            sb.append(trackInfo.toString());
        } else {
            sb.append("null");
        }
        sb.append(com.taobao.weex.el.parse.Operators.BLOCK_END);
        return sb.toString();
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public java.lang.String getInfoInline() {
        android.media.MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo != null) {
            return trackInfo.toString();
        }
        return "null";
    }
}
