package androidtranscoder.engine;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class VideoTrackTranscoder implements androidtranscoder.engine.TrackTranscoder {
    private static final int DRAIN_STATE_CONSUMED = 2;
    private static final int DRAIN_STATE_NONE = 0;
    private static final int DRAIN_STATE_SHOULD_RETRY_IMMEDIATELY = 1;
    private static final java.lang.String TAG = "VideoTrackTranscoder";
    private int frameRate;
    private android.media.MediaFormat mActualOutputFormat;
    private android.media.MediaCodec mDecoder;
    private java.nio.ByteBuffer[] mDecoderInputBuffers;
    private androidtranscoder.engine.OutputSurface mDecoderOutputSurfaceWrapper;
    private boolean mDecoderStarted;
    private android.media.MediaCodec mEncoder;
    private androidtranscoder.engine.InputSurface mEncoderInputSurfaceWrapper;
    private java.nio.ByteBuffer[] mEncoderOutputBuffers;
    private boolean mEncoderStarted;
    private final android.media.MediaExtractor mExtractor;
    private boolean mIsDecoderEOS;
    private boolean mIsEncoderEOS;
    private boolean mIsExtractorEOS;
    private final androidtranscoder.engine.QueuedMuxer mMuxer;
    private final android.media.MediaFormat mOutputFormat;
    private final int mTrackIndex;
    private long mWrittenPresentationTimeUs;
    private final android.media.MediaCodec.BufferInfo mBufferInfo = new android.media.MediaCodec.BufferInfo();
    int currentSecond = 0;
    int currentFrameCount = 0;

    public VideoTrackTranscoder(android.media.MediaExtractor mediaExtractor, int i, android.media.MediaFormat mediaFormat, androidtranscoder.engine.QueuedMuxer queuedMuxer) {
        this.mExtractor = mediaExtractor;
        this.mTrackIndex = i;
        this.mOutputFormat = mediaFormat;
        this.mMuxer = queuedMuxer;
    }

    private int drainDecoder(long j) {
        if (this.mIsDecoderEOS) {
            return 0;
        }
        int iDequeueOutputBuffer = this.mDecoder.dequeueOutputBuffer(this.mBufferInfo, j);
        if (iDequeueOutputBuffer == -3 || iDequeueOutputBuffer == -2) {
            return 1;
        }
        if (iDequeueOutputBuffer == -1) {
            return 0;
        }
        if ((this.mBufferInfo.flags & 4) != 0) {
            this.mEncoder.signalEndOfInputStream();
            this.mIsDecoderEOS = true;
            this.mBufferInfo.size = 0;
        }
        boolean z = this.mBufferInfo.size > 0;
        this.mDecoder.releaseOutputBuffer(iDequeueOutputBuffer, z);
        if (!z) {
            return 2;
        }
        this.mDecoderOutputSurfaceWrapper.awaitNewImage();
        int i = (int) (this.mBufferInfo.presentationTimeUs / 1000000);
        if (this.currentSecond == i) {
            this.currentFrameCount++;
        } else {
            this.currentSecond = i;
            this.currentFrameCount = 0;
        }
        int i2 = this.frameRate;
        if (i2 <= 30) {
            this.mDecoderOutputSurfaceWrapper.drawImage();
            this.mEncoderInputSurfaceWrapper.setPresentationTime(this.mBufferInfo.presentationTimeUs * 1000);
            this.mEncoderInputSurfaceWrapper.swapBuffers();
            return 2;
        }
        if (i2 <= 50) {
            if (this.currentFrameCount % 5 == 0) {
                return 2;
            }
            this.mDecoderOutputSurfaceWrapper.drawImage();
            this.mEncoderInputSurfaceWrapper.setPresentationTime(this.mBufferInfo.presentationTimeUs * 1000);
            this.mEncoderInputSurfaceWrapper.swapBuffers();
            return 2;
        }
        if (this.currentFrameCount % 3 == 0) {
            return 2;
        }
        this.mDecoderOutputSurfaceWrapper.drawImage();
        this.mEncoderInputSurfaceWrapper.setPresentationTime(this.mBufferInfo.presentationTimeUs * 1000);
        this.mEncoderInputSurfaceWrapper.swapBuffers();
        return 2;
    }

    private int drainEncoder(long j) {
        if (this.mIsEncoderEOS) {
            return 0;
        }
        int iDequeueOutputBuffer = this.mEncoder.dequeueOutputBuffer(this.mBufferInfo, j);
        if (iDequeueOutputBuffer == -3) {
            this.mEncoderOutputBuffers = this.mEncoder.getOutputBuffers();
            return 1;
        }
        if (iDequeueOutputBuffer == -2) {
            if (this.mActualOutputFormat != null) {
                throw new java.lang.RuntimeException("Video output format changed twice.");
            }
            android.media.MediaFormat outputFormat = this.mEncoder.getOutputFormat();
            this.mActualOutputFormat = outputFormat;
            this.mMuxer.setOutputFormat(androidtranscoder.engine.QueuedMuxer.SampleType.VIDEO, outputFormat);
            return 1;
        }
        if (iDequeueOutputBuffer == -1) {
            return 0;
        }
        if (this.mActualOutputFormat == null) {
            throw new java.lang.RuntimeException("Could not determine actual output format.");
        }
        android.media.MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
        int i = bufferInfo.flags;
        if ((i & 4) != 0) {
            this.mIsEncoderEOS = true;
            bufferInfo.set(0, 0, 0L, i);
        }
        android.media.MediaCodec.BufferInfo bufferInfo2 = this.mBufferInfo;
        if ((bufferInfo2.flags & 2) != 0) {
            this.mEncoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
            return 1;
        }
        this.mMuxer.writeSampleData(androidtranscoder.engine.QueuedMuxer.SampleType.VIDEO, this.mEncoderOutputBuffers[iDequeueOutputBuffer], bufferInfo2);
        this.mWrittenPresentationTimeUs = this.mBufferInfo.presentationTimeUs;
        this.mEncoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
        return 2;
    }

    private int drainExtractor(long j) {
        int iDequeueInputBuffer;
        if (this.mIsExtractorEOS) {
            return 0;
        }
        int sampleTrackIndex = this.mExtractor.getSampleTrackIndex();
        if ((sampleTrackIndex >= 0 && sampleTrackIndex != this.mTrackIndex) || (iDequeueInputBuffer = this.mDecoder.dequeueInputBuffer(j)) < 0) {
            return 0;
        }
        if (sampleTrackIndex < 0) {
            this.mIsExtractorEOS = true;
            this.mDecoder.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
            return 0;
        }
        this.mDecoder.queueInputBuffer(iDequeueInputBuffer, 0, this.mExtractor.readSampleData(this.mDecoderInputBuffers[iDequeueInputBuffer], 0), this.mExtractor.getSampleTime(), (this.mExtractor.getSampleFlags() & 1) != 0 ? 1 : 0);
        this.mExtractor.advance();
        return 2;
    }

    @Override // androidtranscoder.engine.TrackTranscoder
    public android.media.MediaFormat getDeterminedFormat() {
        return this.mActualOutputFormat;
    }

    @Override // androidtranscoder.engine.TrackTranscoder
    public long getWrittenPresentationTimeUs() {
        return this.mWrittenPresentationTimeUs;
    }

    @Override // androidtranscoder.engine.TrackTranscoder
    public boolean isFinished() {
        return this.mIsEncoderEOS;
    }

    @Override // androidtranscoder.engine.TrackTranscoder
    public void release() {
        androidtranscoder.engine.OutputSurface outputSurface = this.mDecoderOutputSurfaceWrapper;
        if (outputSurface != null) {
            outputSurface.release();
            this.mDecoderOutputSurfaceWrapper = null;
        }
        androidtranscoder.engine.InputSurface inputSurface = this.mEncoderInputSurfaceWrapper;
        if (inputSurface != null) {
            inputSurface.release();
            this.mEncoderInputSurfaceWrapper = null;
        }
        android.media.MediaCodec mediaCodec = this.mDecoder;
        if (mediaCodec != null) {
            if (this.mDecoderStarted) {
                mediaCodec.stop();
            }
            this.mDecoder.release();
            this.mDecoder = null;
        }
        android.media.MediaCodec mediaCodec2 = this.mEncoder;
        if (mediaCodec2 != null) {
            if (this.mEncoderStarted) {
                mediaCodec2.stop();
            }
            this.mEncoder.release();
            this.mEncoder = null;
        }
    }

    @Override // androidtranscoder.engine.TrackTranscoder
    public void setup() {
        this.mExtractor.selectTrack(this.mTrackIndex);
        try {
            android.media.MediaCodec mediaCodecCreateEncoderByType = android.media.MediaCodec.createEncoderByType(this.mOutputFormat.getString(tv.danmaku.ijk.media.player.misc.IMediaFormat.KEY_MIME));
            this.mEncoder = mediaCodecCreateEncoderByType;
            mediaCodecCreateEncoderByType.configure(this.mOutputFormat, (android.view.Surface) null, (android.media.MediaCrypto) null, 1);
            androidtranscoder.engine.InputSurface inputSurface = new androidtranscoder.engine.InputSurface(this.mEncoder.createInputSurface());
            this.mEncoderInputSurfaceWrapper = inputSurface;
            inputSurface.makeCurrent();
            this.mEncoder.start();
            this.mEncoderStarted = true;
            this.mEncoderOutputBuffers = this.mEncoder.getOutputBuffers();
            android.media.MediaFormat trackFormat = this.mExtractor.getTrackFormat(this.mTrackIndex);
            if (trackFormat.containsKey(androidtranscoder.format.MediaFormatExtraConstants.KEY_ROTATION_DEGREES)) {
                trackFormat.setInteger(androidtranscoder.format.MediaFormatExtraConstants.KEY_ROTATION_DEGREES, 0);
            }
            if (trackFormat.getString(tv.danmaku.ijk.media.player.misc.IMediaFormat.KEY_MIME).startsWith("video/") && trackFormat.containsKey("frame-rate")) {
                this.frameRate = trackFormat.getInteger("frame-rate");
            }
            this.mDecoderOutputSurfaceWrapper = new androidtranscoder.engine.OutputSurface();
            try {
                android.media.MediaCodec mediaCodecCreateDecoderByType = android.media.MediaCodec.createDecoderByType(trackFormat.getString(tv.danmaku.ijk.media.player.misc.IMediaFormat.KEY_MIME));
                this.mDecoder = mediaCodecCreateDecoderByType;
                mediaCodecCreateDecoderByType.configure(trackFormat, this.mDecoderOutputSurfaceWrapper.getSurface(), (android.media.MediaCrypto) null, 0);
                this.mDecoder.start();
                this.mDecoderStarted = true;
                this.mDecoderInputBuffers = this.mDecoder.getInputBuffers();
            } catch (java.io.IOException e) {
                throw new java.lang.IllegalStateException(e);
            }
        } catch (java.io.IOException e2) {
            throw new java.lang.IllegalStateException(e2);
        }
    }

    @Override // androidtranscoder.engine.TrackTranscoder
    public boolean stepPipeline() {
        int iDrainDecoder;
        boolean z = false;
        while (drainEncoder(0L) != 0) {
            z = true;
        }
        do {
            iDrainDecoder = drainDecoder(0L);
            if (iDrainDecoder != 0) {
                z = true;
            }
        } while (iDrainDecoder == 1);
        while (drainExtractor(0L) != 0) {
            z = true;
        }
        return z;
    }
}
