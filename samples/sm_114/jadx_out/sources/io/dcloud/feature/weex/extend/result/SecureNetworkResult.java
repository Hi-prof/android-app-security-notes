package io.dcloud.feature.weex.extend.result;

/* JADX INFO: loaded from: classes2.dex */
public class SecureNetworkResult extends io.dcloud.feature.weex.extend.result.Result {
    public static final io.dcloud.feature.weex.extend.result.Result NOT_SUPPORT_MP_OR_BASE = new io.dcloud.feature.weex.extend.result.SecureNetworkResult(10001, "unimpsdk or playground is not support");
    public static final io.dcloud.feature.weex.extend.result.Result PARAMS_IS_NULL = new io.dcloud.feature.weex.extend.result.SecureNetworkResult(10002, "params is null");
    public static final io.dcloud.feature.weex.extend.result.Result APP_KEY_IS_NULL = new io.dcloud.feature.weex.extend.result.SecureNetworkResult(10003, "app key is null");
    public static final io.dcloud.feature.weex.extend.result.Result ENCRYPT_CLIENT_KEY_PAYLOAD_ERROR = new io.dcloud.feature.weex.extend.result.SecureNetworkResult(tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_VIDEO_DECODED_START, "encrypt client key payload fail");
    public static final io.dcloud.feature.weex.extend.result.Result NATIVE_JSON_FORMAT_ERROR = new io.dcloud.feature.weex.extend.result.SecureNetworkResult(tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_OPEN_INPUT, "native json format error");
    public static final io.dcloud.feature.weex.extend.result.Result JSON_FORMAT_ERROR = new io.dcloud.feature.weex.extend.result.SecureNetworkResult(tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_FIND_STREAM_INFO, "json format error");
    public static final io.dcloud.feature.weex.extend.result.Result CLIENT_KEY_ILLEGAL = new io.dcloud.feature.weex.extend.result.SecureNetworkResult(10007, "client key data is illegal");
    public static final io.dcloud.feature.weex.extend.result.Result CLIENT_KEY_IS_NULL = new io.dcloud.feature.weex.extend.result.SecureNetworkResult(10008, "client key is null");
    public static final io.dcloud.feature.weex.extend.result.Result ENCRYPT_ERROR = new io.dcloud.feature.weex.extend.result.SecureNetworkResult(10009, "encrypt fail");
    public static final io.dcloud.feature.weex.extend.result.Result DECRYPT_ERROR = new io.dcloud.feature.weex.extend.result.SecureNetworkResult(10010, "decrypt fail");

    public SecureNetworkResult(int i, java.lang.String str) {
        super("uni-secure-network", i, str);
    }
}
