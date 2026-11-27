package androidtranscoder.format;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class MediaFormatPresets {
    private static final int LONGER_LENGTH_960x540 = 960;

    private MediaFormatPresets() {
    }

    @java.lang.Deprecated
    public static android.media.MediaFormat getExportPreset960x540() {
        android.media.MediaFormat mediaFormatCreateVideoFormat = android.media.MediaFormat.createVideoFormat(androidtranscoder.format.MediaFormatExtraConstants.MIMETYPE_VIDEO_AVC, LONGER_LENGTH_960x540, 540);
        mediaFormatCreateVideoFormat.setInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, 5500000);
        mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
        mediaFormatCreateVideoFormat.setInteger("frame-rate", 30);
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 1);
        return mediaFormatCreateVideoFormat;
    }

    public static android.media.MediaFormat getExportPreset960x540(int i, int i2) {
        int iMax = java.lang.Math.max(i, i2);
        int iMin = java.lang.Math.min(i, i2);
        int i3 = LONGER_LENGTH_960x540;
        if (iMax <= LONGER_LENGTH_960x540) {
            return null;
        }
        int i4 = iMin * LONGER_LENGTH_960x540;
        if (i4 % iMax == 0) {
            int i5 = i4 / iMax;
            if (i < i2) {
                i3 = i5;
                i5 = LONGER_LENGTH_960x540;
            }
            android.media.MediaFormat mediaFormatCreateVideoFormat = android.media.MediaFormat.createVideoFormat(androidtranscoder.format.MediaFormatExtraConstants.MIMETYPE_VIDEO_AVC, i3, i5);
            mediaFormatCreateVideoFormat.setInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, 5500000);
            mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
            mediaFormatCreateVideoFormat.setInteger("frame-rate", 30);
            mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 1);
            return mediaFormatCreateVideoFormat;
        }
        throw new androidtranscoder.format.OutputFormatUnavailableException(io.dcloud.common.util.StringUtil.format("Could not fit to integer, original: (%d, %d), scaled: (%d, %f)", java.lang.Integer.valueOf(iMax), java.lang.Integer.valueOf(iMin), java.lang.Integer.valueOf(LONGER_LENGTH_960x540), java.lang.Double.valueOf((((double) iMin) * 960.0d) / ((double) iMax))));
    }
}
