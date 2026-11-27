package androidtranscoder.engine;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class PassThroughTrackTranscoder implements androidtranscoder.engine.TrackTranscoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private android.media.MediaFormat mActualOutputFormat;
    private java.nio.ByteBuffer mBuffer;
    private final android.media.MediaCodec.BufferInfo mBufferInfo = new android.media.MediaCodec.BufferInfo();
    private int mBufferSize;
    private final android.media.MediaExtractor mExtractor;
    private boolean mIsEOS;
    private final androidtranscoder.engine.QueuedMuxer mMuxer;
    private final androidtranscoder.engine.QueuedMuxer.SampleType mSampleType;
    private final int mTrackIndex;
    private long mWrittenPresentationTimeUs;

    public PassThroughTrackTranscoder(android.media.MediaExtractor mediaExtractor, int i, androidtranscoder.engine.QueuedMuxer queuedMuxer, androidtranscoder.engine.QueuedMuxer.SampleType sampleType) {
        this.mExtractor = mediaExtractor;
        this.mTrackIndex = i;
        this.mMuxer = queuedMuxer;
        this.mSampleType = sampleType;
        android.media.MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
        this.mActualOutputFormat = trackFormat;
        queuedMuxer.setOutputFormat(sampleType, trackFormat);
        int integer = this.mActualOutputFormat.getInteger("max-input-size");
        this.mBufferSize = integer;
        this.mBuffer = java.nio.ByteBuffer.allocateDirect(integer).order(java.nio.ByteOrder.nativeOrder());
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
        return this.mIsEOS;
    }

    @Override // androidtranscoder.engine.TrackTranscoder
    public void release() {
    }

    @Override // androidtranscoder.engine.TrackTranscoder
    public void setup() {
    }

    @Override // androidtranscoder.engine.TrackTranscoder
    public boolean stepPipeline() {
        if (this.mIsEOS) {
            return false;
        }
        int sampleTrackIndex = this.mExtractor.getSampleTrackIndex();
        if (sampleTrackIndex < 0) {
            this.mBuffer.clear();
            this.mBufferInfo.set(0, 0, 0L, 4);
            this.mMuxer.writeSampleData(this.mSampleType, this.mBuffer, this.mBufferInfo);
            this.mIsEOS = true;
            return true;
        }
        if (sampleTrackIndex != this.mTrackIndex) {
            return false;
        }
        this.mBuffer.clear();
        this.mBufferInfo.set(0, this.mExtractor.readSampleData(this.mBuffer, 0), this.mExtractor.getSampleTime(), (this.mExtractor.getSampleFlags() & 1) != 0 ? 1 : 0);
        this.mMuxer.writeSampleData(this.mSampleType, this.mBuffer, this.mBufferInfo);
        this.mWrittenPresentationTimeUs = this.mBufferInfo.presentationTimeUs;
        this.mExtractor.advance();
        return true;
    }
}
