package tv.danmaku.ijk.media.player.misc;

/* JADX INFO: loaded from: classes2.dex */
public class IjkMediaFormat implements tv.danmaku.ijk.media.player.misc.IMediaFormat {
    public static final java.lang.String CODEC_NAME_H264 = "h264";
    public static final java.lang.String KEY_IJK_BIT_RATE_UI = "ijk-bit-rate-ui";
    public static final java.lang.String KEY_IJK_CHANNEL_UI = "ijk-channel-ui";
    public static final java.lang.String KEY_IJK_CODEC_LONG_NAME_UI = "ijk-codec-long-name-ui";
    public static final java.lang.String KEY_IJK_CODEC_NAME_UI = "ijk-codec-name-ui";
    public static final java.lang.String KEY_IJK_CODEC_PIXEL_FORMAT_UI = "ijk-pixel-format-ui";
    public static final java.lang.String KEY_IJK_CODEC_PROFILE_LEVEL_UI = "ijk-profile-level-ui";
    public static final java.lang.String KEY_IJK_FRAME_RATE_UI = "ijk-frame-rate-ui";
    public static final java.lang.String KEY_IJK_RESOLUTION_UI = "ijk-resolution-ui";
    public static final java.lang.String KEY_IJK_SAMPLE_RATE_UI = "ijk-sample-rate-ui";
    private static final java.util.Map<java.lang.String, tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter> sFormatterMap = new java.util.HashMap();
    public final tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta mMediaFormat;

    public IjkMediaFormat(tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        java.util.Map<java.lang.String, tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter> map = sFormatterMap;
        map.put(KEY_IJK_CODEC_LONG_NAME_UI, new tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter() { // from class: tv.danmaku.ijk.media.player.misc.IjkMediaFormat.1
            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            public java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
                return tv.danmaku.ijk.media.player.misc.IjkMediaFormat.this.mMediaFormat.getString(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_CODEC_LONG_NAME);
            }
        });
        map.put(KEY_IJK_CODEC_NAME_UI, new tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter() { // from class: tv.danmaku.ijk.media.player.misc.IjkMediaFormat.2
            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            public java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
                return tv.danmaku.ijk.media.player.misc.IjkMediaFormat.this.mMediaFormat.getString(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_CODEC_NAME);
            }
        });
        map.put(KEY_IJK_BIT_RATE_UI, new tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter() { // from class: tv.danmaku.ijk.media.player.misc.IjkMediaFormat.3
            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE);
                if (integer <= 0) {
                    return null;
                }
                return integer < 1000 ? java.lang.String.format(java.util.Locale.US, "%d bit/s", java.lang.Integer.valueOf(integer)) : java.lang.String.format(java.util.Locale.US, "%d kb/s", java.lang.Integer.valueOf(integer / 1000));
            }
        });
        map.put(KEY_IJK_CODEC_PROFILE_LEVEL_UI, new tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter() { // from class: tv.danmaku.ijk.media.player.misc.IjkMediaFormat.4
            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
                java.lang.String str;
                switch (ijkMediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_CODEC_PROFILE_ID)) {
                    case 44:
                        str = "CAVLC 4:4:4";
                        break;
                    case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
                        str = "Baseline";
                        break;
                    case 77:
                        str = "Main";
                        break;
                    case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_EXTENDED /* 88 */:
                        str = "Extended";
                        break;
                    case 100:
                        str = "High";
                        break;
                    case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_10 /* 110 */:
                        str = "High 10";
                        break;
                    case 122:
                        str = "High 4:2:2";
                        break;
                    case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444 /* 144 */:
                        str = "High 4:4:4";
                        break;
                    case 244:
                        str = "High 4:4:4 Predictive";
                        break;
                    case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED_BASELINE /* 578 */:
                        str = "Constrained Baseline";
                        break;
                    case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_10_INTRA /* 2158 */:
                        str = "High 10 Intra";
                        break;
                    case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_422_INTRA /* 2170 */:
                        str = "High 4:2:2 Intra";
                        break;
                    case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444_INTRA /* 2292 */:
                        str = "High 4:4:4 Intra";
                        break;
                    default:
                        return null;
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(str);
                java.lang.String string = ijkMediaFormat.getString(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_CODEC_NAME);
                if (!android.text.TextUtils.isEmpty(string) && string.equalsIgnoreCase(tv.danmaku.ijk.media.player.misc.IjkMediaFormat.CODEC_NAME_H264)) {
                    int integer = ijkMediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_CODEC_LEVEL);
                    if (integer < 10) {
                        return sb.toString();
                    }
                    sb.append(" Profile Level ");
                    sb.append((integer / 10) % 10);
                    int i = integer % 10;
                    if (i != 0) {
                        sb.append(com.taobao.weex.el.parse.Operators.DOT_STR);
                        sb.append(i);
                    }
                }
                return sb.toString();
            }
        });
        map.put(KEY_IJK_CODEC_PIXEL_FORMAT_UI, new tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter() { // from class: tv.danmaku.ijk.media.player.misc.IjkMediaFormat.5
            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
                return ijkMediaFormat.getString(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_CODEC_PIXEL_FORMAT);
            }
        });
        map.put(KEY_IJK_RESOLUTION_UI, new tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter() { // from class: tv.danmaku.ijk.media.player.misc.IjkMediaFormat.6
            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger("width");
                int integer2 = ijkMediaFormat.getInteger("height");
                int integer3 = ijkMediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_SAR_NUM);
                int integer4 = ijkMediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_SAR_DEN);
                if (integer <= 0 || integer2 <= 0) {
                    return null;
                }
                return (integer3 <= 0 || integer4 <= 0) ? java.lang.String.format(java.util.Locale.US, "%d x %d", java.lang.Integer.valueOf(integer), java.lang.Integer.valueOf(integer2)) : java.lang.String.format(java.util.Locale.US, "%d x %d [SAR %d:%d]", java.lang.Integer.valueOf(integer), java.lang.Integer.valueOf(integer2), java.lang.Integer.valueOf(integer3), java.lang.Integer.valueOf(integer4));
            }
        });
        map.put(KEY_IJK_FRAME_RATE_UI, new tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter() { // from class: tv.danmaku.ijk.media.player.misc.IjkMediaFormat.7
            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_FPS_NUM);
                int integer2 = ijkMediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_FPS_DEN);
                if (integer <= 0 || integer2 <= 0) {
                    return null;
                }
                return java.lang.String.valueOf(integer / integer2);
            }
        });
        map.put(KEY_IJK_SAMPLE_RATE_UI, new tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter() { // from class: tv.danmaku.ijk.media.player.misc.IjkMediaFormat.8
            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_SAMPLE_RATE);
                if (integer <= 0) {
                    return null;
                }
                return java.lang.String.format(java.util.Locale.US, "%d Hz", java.lang.Integer.valueOf(integer));
            }
        });
        map.put(KEY_IJK_CHANNEL_UI, new tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter() { // from class: tv.danmaku.ijk.media.player.misc.IjkMediaFormat.9
            @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
            protected java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
                int integer = ijkMediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_CHANNEL_LAYOUT);
                if (integer <= 0) {
                    return null;
                }
                long j = integer;
                if (j == 4) {
                    return "mono";
                }
                return j == 3 ? "stereo" : java.lang.String.format(java.util.Locale.US, "%x", java.lang.Integer.valueOf(integer));
            }
        });
        this.mMediaFormat = ijkStreamMeta;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaFormat
    public int getInteger(java.lang.String str) {
        tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta ijkStreamMeta = this.mMediaFormat;
        if (ijkStreamMeta == null) {
            return 0;
        }
        return ijkStreamMeta.getInt(str);
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaFormat
    public java.lang.String getString(java.lang.String str) {
        if (this.mMediaFormat == null) {
            return null;
        }
        java.util.Map<java.lang.String, tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter> map = sFormatterMap;
        if (map.containsKey(str)) {
            return map.get(str).format(this);
        }
        return this.mMediaFormat.getString(str);
    }

    private static abstract class Formatter {
        protected abstract java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat);

        private Formatter() {
        }

        public java.lang.String format(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
            java.lang.String strDoFormat = doFormat(ijkMediaFormat);
            return android.text.TextUtils.isEmpty(strDoFormat) ? getDefaultString() : strDoFormat;
        }

        protected java.lang.String getDefaultString() {
            return "N/A";
        }
    }
}
