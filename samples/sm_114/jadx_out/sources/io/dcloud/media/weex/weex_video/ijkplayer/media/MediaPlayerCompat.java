package io.dcloud.media.weex.weex_video.ijkplayer.media;

/* JADX INFO: loaded from: classes2.dex */
public class MediaPlayerCompat {
    public static java.lang.String getName(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
        if (iMediaPlayer == null) {
            return "null";
        }
        if (iMediaPlayer instanceof tv.danmaku.ijk.media.player.TextureMediaPlayer) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("TextureMediaPlayer <");
            tv.danmaku.ijk.media.player.IMediaPlayer internalMediaPlayer = ((tv.danmaku.ijk.media.player.TextureMediaPlayer) iMediaPlayer).getInternalMediaPlayer();
            if (internalMediaPlayer == null) {
                sb.append("null>");
            } else {
                sb.append(internalMediaPlayer.getClass().getSimpleName());
                sb.append(com.taobao.weex.el.parse.Operators.G);
            }
            return sb.toString();
        }
        return iMediaPlayer.getClass().getSimpleName();
    }

    public static tv.danmaku.ijk.media.player.IjkMediaPlayer getIjkMediaPlayer(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
        if (iMediaPlayer == null) {
            return null;
        }
        if (iMediaPlayer instanceof tv.danmaku.ijk.media.player.IjkMediaPlayer) {
            return (tv.danmaku.ijk.media.player.IjkMediaPlayer) iMediaPlayer;
        }
        if (iMediaPlayer instanceof tv.danmaku.ijk.media.player.MediaPlayerProxy) {
            tv.danmaku.ijk.media.player.MediaPlayerProxy mediaPlayerProxy = (tv.danmaku.ijk.media.player.MediaPlayerProxy) iMediaPlayer;
            if (mediaPlayerProxy.getInternalMediaPlayer() instanceof tv.danmaku.ijk.media.player.IjkMediaPlayer) {
                return (tv.danmaku.ijk.media.player.IjkMediaPlayer) mediaPlayerProxy.getInternalMediaPlayer();
            }
        }
        return null;
    }

    public static void selectTrack(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i) {
        tv.danmaku.ijk.media.player.IjkMediaPlayer ijkMediaPlayer = getIjkMediaPlayer(iMediaPlayer);
        if (ijkMediaPlayer == null) {
            return;
        }
        ijkMediaPlayer.selectTrack(i);
    }

    public static void deselectTrack(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i) {
        tv.danmaku.ijk.media.player.IjkMediaPlayer ijkMediaPlayer = getIjkMediaPlayer(iMediaPlayer);
        if (ijkMediaPlayer == null) {
            return;
        }
        ijkMediaPlayer.deselectTrack(i);
    }

    public static int getSelectedTrack(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i) {
        tv.danmaku.ijk.media.player.IjkMediaPlayer ijkMediaPlayer = getIjkMediaPlayer(iMediaPlayer);
        if (ijkMediaPlayer == null) {
            return -1;
        }
        return ijkMediaPlayer.getSelectedTrack(i);
    }
}
