package androidtranscoder.engine;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class MediaTranscoderEngine {
    private static final long PROGRESS_INTERVAL_STEPS = 10;
    private static final double PROGRESS_UNKNOWN = -1.0d;
    private static final long SLEEP_TO_WAIT_TRACK_TRANSCODERS = 10;
    private static final java.lang.String TAG = "MediaTranscoderEngine";
    private androidtranscoder.engine.TrackTranscoder mAudioTrackTranscoder;
    private long mDurationUs;
    private android.media.MediaExtractor mExtractor;
    private java.io.FileDescriptor mInputFileDescriptor;
    private android.media.MediaMuxer mMuxer;
    private volatile double mProgress;
    private androidtranscoder.engine.MediaTranscoderEngine.ProgressCallback mProgressCallback;
    private androidtranscoder.engine.TrackTranscoder mVideoTrackTranscoder;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface ProgressCallback {
        void onProgress(double d);
    }

    private void runPipelines() throws java.lang.InterruptedException {
        if (this.mDurationUs <= 0) {
            this.mProgress = PROGRESS_UNKNOWN;
            androidtranscoder.engine.MediaTranscoderEngine.ProgressCallback progressCallback = this.mProgressCallback;
            if (progressCallback != null) {
                progressCallback.onProgress(PROGRESS_UNKNOWN);
            }
        }
        long j = 0;
        while (true) {
            if (this.mVideoTrackTranscoder.isFinished() && this.mAudioTrackTranscoder.isFinished()) {
                return;
            }
            boolean z = this.mVideoTrackTranscoder.stepPipeline() || this.mAudioTrackTranscoder.stepPipeline();
            j++;
            if (this.mDurationUs > 0 && j % 10 == 0) {
                double dMin = ((this.mVideoTrackTranscoder.isFinished() ? 1.0d : java.lang.Math.min(1.0d, this.mVideoTrackTranscoder.getWrittenPresentationTimeUs() / this.mDurationUs)) + (this.mAudioTrackTranscoder.isFinished() ? 1.0d : java.lang.Math.min(1.0d, this.mAudioTrackTranscoder.getWrittenPresentationTimeUs() / this.mDurationUs))) / 2.0d;
                this.mProgress = dMin;
                androidtranscoder.engine.MediaTranscoderEngine.ProgressCallback progressCallback2 = this.mProgressCallback;
                if (progressCallback2 != null) {
                    progressCallback2.onProgress(dMin);
                }
            }
            if (!z) {
                java.lang.Thread.sleep(10L);
            }
        }
    }

    private void setupMetadata() throws java.io.IOException {
        android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(this.mInputFileDescriptor);
        try {
            this.mMuxer.setOrientationHint(java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(24)));
        } catch (java.lang.NumberFormatException unused) {
        }
        java.lang.String strExtractMetadata = mediaMetadataRetriever.extractMetadata(23);
        if (strExtractMetadata != null) {
            float[] fArr = new androidtranscoder.utils.ISO6709LocationParser().parse(strExtractMetadata);
            if (fArr != null) {
                this.mMuxer.setLocation(fArr[0], fArr[1]);
            } else {
                android.util.Log.d(TAG, "Failed to parse the location metadata: " + strExtractMetadata);
            }
        }
        try {
            this.mDurationUs = java.lang.Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) * 1000;
        } catch (java.lang.NumberFormatException unused2) {
            this.mDurationUs = -1L;
        }
        android.util.Log.d(TAG, "Duration (us): " + this.mDurationUs);
    }

    private void setupTrackTranscoders(androidtranscoder.format.MediaFormatStrategy mediaFormatStrategy) {
        androidtranscoder.utils.MediaExtractorUtils.TrackResult firstVideoAndAudioTrack = androidtranscoder.utils.MediaExtractorUtils.getFirstVideoAndAudioTrack(this.mExtractor);
        android.media.MediaFormat mediaFormatCreateVideoOutputFormat = mediaFormatStrategy.createVideoOutputFormat(firstVideoAndAudioTrack.mVideoTrackFormat);
        android.media.MediaFormat mediaFormatCreateAudioOutputFormat = mediaFormatStrategy.createAudioOutputFormat(firstVideoAndAudioTrack.mAudioTrackFormat);
        if (mediaFormatCreateVideoOutputFormat == null && mediaFormatCreateAudioOutputFormat == null) {
            throw new androidtranscoder.engine.InvalidOutputFormatException("MediaFormatStrategy returned pass-through for both video and audio. No transcoding is necessary.");
        }
        androidtranscoder.engine.QueuedMuxer queuedMuxer = new androidtranscoder.engine.QueuedMuxer(this.mMuxer, new androidtranscoder.engine.QueuedMuxer.Listener() { // from class: androidtranscoder.engine.MediaTranscoderEngine.1
            @Override // androidtranscoder.engine.QueuedMuxer.Listener
            public void onDetermineOutputFormat() {
                androidtranscoder.engine.MediaFormatValidator.validateVideoOutputFormat(androidtranscoder.engine.MediaTranscoderEngine.this.mVideoTrackTranscoder.getDeterminedFormat());
                androidtranscoder.engine.MediaFormatValidator.validateAudioOutputFormat(androidtranscoder.engine.MediaTranscoderEngine.this.mAudioTrackTranscoder.getDeterminedFormat());
            }
        });
        if (mediaFormatCreateVideoOutputFormat == null) {
            this.mVideoTrackTranscoder = new androidtranscoder.engine.PassThroughTrackTranscoder(this.mExtractor, firstVideoAndAudioTrack.mVideoTrackIndex, queuedMuxer, androidtranscoder.engine.QueuedMuxer.SampleType.VIDEO);
        } else {
            this.mVideoTrackTranscoder = new androidtranscoder.engine.VideoTrackTranscoder(this.mExtractor, firstVideoAndAudioTrack.mVideoTrackIndex, mediaFormatCreateVideoOutputFormat, queuedMuxer);
        }
        this.mVideoTrackTranscoder.setup();
        androidtranscoder.engine.PassThroughTrackTranscoder passThroughTrackTranscoder = new androidtranscoder.engine.PassThroughTrackTranscoder(this.mExtractor, firstVideoAndAudioTrack.mAudioTrackIndex, queuedMuxer, androidtranscoder.engine.QueuedMuxer.SampleType.AUDIO);
        this.mAudioTrackTranscoder = passThroughTrackTranscoder;
        passThroughTrackTranscoder.setup();
        this.mExtractor.selectTrack(firstVideoAndAudioTrack.mVideoTrackIndex);
        this.mExtractor.selectTrack(firstVideoAndAudioTrack.mAudioTrackIndex);
    }

    public double getProgress() {
        return this.mProgress;
    }

    public androidtranscoder.engine.MediaTranscoderEngine.ProgressCallback getProgressCallback() {
        return this.mProgressCallback;
    }

    public void setDataSource(java.io.FileDescriptor fileDescriptor) {
        this.mInputFileDescriptor = fileDescriptor;
    }

    public void setProgressCallback(androidtranscoder.engine.MediaTranscoderEngine.ProgressCallback progressCallback) {
        this.mProgressCallback = progressCallback;
    }

    public void transcodeVideo(java.lang.String str, androidtranscoder.format.MediaFormatStrategy mediaFormatStrategy) throws java.lang.InterruptedException, java.io.IOException {
        if (str == null) {
            throw new java.lang.NullPointerException("Output path cannot be null.");
        }
        if (this.mInputFileDescriptor == null) {
            throw new java.lang.IllegalStateException("Data source is not set.");
        }
        try {
            android.media.MediaExtractor mediaExtractor = new android.media.MediaExtractor();
            this.mExtractor = mediaExtractor;
            mediaExtractor.setDataSource(this.mInputFileDescriptor);
            this.mMuxer = new android.media.MediaMuxer(str, 0);
            setupMetadata();
            setupTrackTranscoders(mediaFormatStrategy);
            runPipelines();
            this.mMuxer.stop();
            try {
                androidtranscoder.engine.TrackTranscoder trackTranscoder = this.mVideoTrackTranscoder;
                if (trackTranscoder != null) {
                    trackTranscoder.release();
                    this.mVideoTrackTranscoder = null;
                }
                androidtranscoder.engine.TrackTranscoder trackTranscoder2 = this.mAudioTrackTranscoder;
                if (trackTranscoder2 != null) {
                    trackTranscoder2.release();
                    this.mAudioTrackTranscoder = null;
                }
                android.media.MediaExtractor mediaExtractor2 = this.mExtractor;
                if (mediaExtractor2 != null) {
                    mediaExtractor2.release();
                    this.mExtractor = null;
                }
                try {
                    android.media.MediaMuxer mediaMuxer = this.mMuxer;
                    if (mediaMuxer != null) {
                        mediaMuxer.release();
                        this.mMuxer = null;
                    }
                } catch (java.lang.RuntimeException e) {
                    android.util.Log.e(TAG, "Failed to release muxer.", e);
                }
            } catch (java.lang.RuntimeException e2) {
                throw new java.lang.Error("Could not shutdown extractor, codecs and muxer pipeline.", e2);
            }
        } catch (java.lang.Throwable th) {
            try {
                androidtranscoder.engine.TrackTranscoder trackTranscoder3 = this.mVideoTrackTranscoder;
                if (trackTranscoder3 != null) {
                    trackTranscoder3.release();
                    this.mVideoTrackTranscoder = null;
                }
                androidtranscoder.engine.TrackTranscoder trackTranscoder4 = this.mAudioTrackTranscoder;
                if (trackTranscoder4 != null) {
                    trackTranscoder4.release();
                    this.mAudioTrackTranscoder = null;
                }
                android.media.MediaExtractor mediaExtractor3 = this.mExtractor;
                if (mediaExtractor3 != null) {
                    mediaExtractor3.release();
                    this.mExtractor = null;
                }
                try {
                    android.media.MediaMuxer mediaMuxer2 = this.mMuxer;
                    if (mediaMuxer2 != null) {
                        mediaMuxer2.release();
                        this.mMuxer = null;
                    }
                } catch (java.lang.RuntimeException e3) {
                    android.util.Log.e(TAG, "Failed to release muxer.", e3);
                }
                throw th;
            } catch (java.lang.RuntimeException e4) {
                throw new java.lang.Error("Could not shutdown extractor, codecs and muxer pipeline.", e4);
            }
        }
    }
}
