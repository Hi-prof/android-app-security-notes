package io.dcloud.media.video.ijkplayer.utils;

/* JADX INFO: loaded from: classes2.dex */
public final class StringUtils {
    private StringUtils() {
        throw new java.lang.AssertionError();
    }

    public static java.lang.String generateTime(long j) {
        int i = (int) (j / 1000);
        int i2 = i % 60;
        int i3 = i / 60;
        return i3 > 99 ? io.dcloud.common.util.StringUtil.format("%d:%02d", java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i2)) : io.dcloud.common.util.StringUtil.format("%02d:%02d", java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i2));
    }

    public static java.lang.String getFormatSize(int i) {
        long j = i;
        if (j >= 0 && j < tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_SIDE_RIGHT) {
            return j + "Kb/s";
        }
        if (j >= tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_SIDE_RIGHT && j < 1048576) {
            return java.lang.Long.toString(j / tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_SIDE_RIGHT) + "KB/s";
        }
        if (j >= 1048576 && j < tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_STEREO_RIGHT) {
            return java.lang.Long.toString(j / 1048576) + "MB/s";
        }
        return "";
    }

    public static java.lang.String getCurFormatTime() {
        return new java.text.SimpleDateFormat("HH:mm").format(new java.util.Date(java.lang.System.currentTimeMillis()));
    }
}
