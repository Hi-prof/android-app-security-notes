package androidtranscoder.utils;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class MediaExtractorUtils {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class TrackResult {
        public android.media.MediaFormat mAudioTrackFormat;
        public int mAudioTrackIndex;
        public java.lang.String mAudioTrackMime;
        public android.media.MediaFormat mVideoTrackFormat;
        public int mVideoTrackIndex;
        public java.lang.String mVideoTrackMime;

        private TrackResult() {
        }
    }

    private MediaExtractorUtils() {
    }

    public static androidtranscoder.utils.MediaExtractorUtils.TrackResult getFirstVideoAndAudioTrack(android.media.MediaExtractor mediaExtractor) {
        androidtranscoder.utils.MediaExtractorUtils.TrackResult trackResult = new androidtranscoder.utils.MediaExtractorUtils.TrackResult();
        trackResult.mVideoTrackIndex = -1;
        trackResult.mAudioTrackIndex = -1;
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            android.media.MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            java.lang.String string = trackFormat.getString(tv.danmaku.ijk.media.player.misc.IMediaFormat.KEY_MIME);
            if (trackResult.mVideoTrackIndex < 0 && string.startsWith("video/")) {
                trackResult.mVideoTrackIndex = i;
                trackResult.mVideoTrackMime = string;
                trackResult.mVideoTrackFormat = trackFormat;
            } else if (trackResult.mAudioTrackIndex < 0 && string.startsWith("audio/")) {
                trackResult.mAudioTrackIndex = i;
                trackResult.mAudioTrackMime = string;
                trackResult.mAudioTrackFormat = trackFormat;
            }
            if (trackResult.mVideoTrackIndex >= 0 && trackResult.mAudioTrackIndex >= 0) {
                break;
            }
        }
        if (trackResult.mVideoTrackIndex < 0 || trackResult.mAudioTrackIndex < 0) {
            throw new java.lang.IllegalArgumentException("extractor does not contain video and/or audio tracks.");
        }
        return trackResult;
    }
}
