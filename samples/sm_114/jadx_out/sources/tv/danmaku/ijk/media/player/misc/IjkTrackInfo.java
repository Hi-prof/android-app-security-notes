package tv.danmaku.ijk.media.player.misc;

/* JADX INFO: loaded from: classes2.dex */
public class IjkTrackInfo implements tv.danmaku.ijk.media.player.misc.ITrackInfo {
    private tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta mStreamMeta;
    private int mTrackType = 0;

    public IjkTrackInfo(tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        this.mStreamMeta = ijkStreamMeta;
    }

    public void setMediaMeta(tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        this.mStreamMeta = ijkStreamMeta;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public tv.danmaku.ijk.media.player.misc.IMediaFormat getFormat() {
        return new tv.danmaku.ijk.media.player.misc.IjkMediaFormat(this.mStreamMeta);
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public java.lang.String getLanguage() {
        tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta ijkStreamMeta = this.mStreamMeta;
        if (ijkStreamMeta == null || android.text.TextUtils.isEmpty(ijkStreamMeta.mLanguage)) {
            return "und";
        }
        return this.mStreamMeta.mLanguage;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public int getTrackType() {
        return this.mTrackType;
    }

    public void setTrackType(int i) {
        this.mTrackType = i;
    }

    public java.lang.String toString() {
        return getClass().getSimpleName() + com.taobao.weex.el.parse.Operators.BLOCK_START + getInfoInline() + com.taobao.weex.el.parse.Operators.BLOCK_END_STR;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public java.lang.String getInfoInline() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
        int i = this.mTrackType;
        if (i == 1) {
            sb.append("VIDEO, ");
            sb.append(this.mStreamMeta.getCodecShortNameInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getBitrateInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getResolutionInline());
        } else if (i == 2) {
            sb.append("AUDIO, ");
            sb.append(this.mStreamMeta.getCodecShortNameInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getBitrateInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getSampleRateInline());
        } else if (i == 3) {
            sb.append("TIMEDTEXT, ");
            sb.append(this.mStreamMeta.mLanguage);
        } else if (i == 4) {
            sb.append("SUBTITLE");
        } else {
            sb.append("UNKNOWN");
        }
        return sb.toString();
    }
}
