package androidtranscoder.engine;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class MediaFormatValidator {
    MediaFormatValidator() {
    }

    public static void validateAudioOutputFormat(android.media.MediaFormat mediaFormat) {
        java.lang.String string = mediaFormat.getString(tv.danmaku.ijk.media.player.misc.IMediaFormat.KEY_MIME);
        if (androidtranscoder.format.MediaFormatExtraConstants.MIMETYPE_AUDIO_AAC.equals(string)) {
            return;
        }
        throw new androidtranscoder.engine.InvalidOutputFormatException("Audio codecs other than AAC is not supported, actual mime type: " + string);
    }

    public static void validateVideoOutputFormat(android.media.MediaFormat mediaFormat) {
        java.lang.String string = mediaFormat.getString(tv.danmaku.ijk.media.player.misc.IMediaFormat.KEY_MIME);
        if (androidtranscoder.format.MediaFormatExtraConstants.MIMETYPE_VIDEO_AVC.equals(string)) {
            return;
        }
        throw new androidtranscoder.engine.InvalidOutputFormatException("Video codecs other than AVC is not supported, actual mime type: " + string);
    }
}
