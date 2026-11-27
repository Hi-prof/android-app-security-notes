package androidtranscoder.engine;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class QueuedMuxer {
    private static final int BUFFER_SIZE = 65536;
    private static final java.lang.String TAG = "QueuedMuxer";
    private android.media.MediaFormat mAudioFormat;
    private int mAudioTrackIndex;
    private java.nio.ByteBuffer mByteBuffer;
    private final androidtranscoder.engine.QueuedMuxer.Listener mListener;
    private final android.media.MediaMuxer mMuxer;
    private final java.util.List<androidtranscoder.engine.QueuedMuxer.SampleInfo> mSampleInfoList = new java.util.ArrayList();
    private boolean mStarted;
    private android.media.MediaFormat mVideoFormat;
    private int mVideoTrackIndex;

    /* JADX INFO: renamed from: androidtranscoder.engine.QueuedMuxer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidtranscoder$engine$QueuedMuxer$SampleType;

        static {
            int[] iArr = new int[androidtranscoder.engine.QueuedMuxer.SampleType.values().length];
            $SwitchMap$androidtranscoder$engine$QueuedMuxer$SampleType = iArr;
            try {
                iArr[androidtranscoder.engine.QueuedMuxer.SampleType.VIDEO.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidtranscoder$engine$QueuedMuxer$SampleType[androidtranscoder.engine.QueuedMuxer.SampleType.AUDIO.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface Listener {
        void onDetermineOutputFormat();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class SampleInfo {
        private final int mFlags;
        private final long mPresentationTimeUs;
        private final androidtranscoder.engine.QueuedMuxer.SampleType mSampleType;
        private final int mSize;

        /* synthetic */ SampleInfo(androidtranscoder.engine.QueuedMuxer.SampleType sampleType, int i, android.media.MediaCodec.BufferInfo bufferInfo, androidtranscoder.engine.QueuedMuxer.AnonymousClass1 anonymousClass1) {
            this(sampleType, i, bufferInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeToBufferInfo(android.media.MediaCodec.BufferInfo bufferInfo, int i) {
            bufferInfo.set(i, this.mSize, this.mPresentationTimeUs, this.mFlags);
        }

        private SampleInfo(androidtranscoder.engine.QueuedMuxer.SampleType sampleType, int i, android.media.MediaCodec.BufferInfo bufferInfo) {
            this.mSampleType = sampleType;
            this.mSize = i;
            this.mPresentationTimeUs = bufferInfo.presentationTimeUs;
            this.mFlags = bufferInfo.flags;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public enum SampleType {
        VIDEO,
        AUDIO
    }

    public QueuedMuxer(android.media.MediaMuxer mediaMuxer, androidtranscoder.engine.QueuedMuxer.Listener listener) {
        this.mMuxer = mediaMuxer;
        this.mListener = listener;
    }

    private int getTrackIndexForSampleType(androidtranscoder.engine.QueuedMuxer.SampleType sampleType) {
        int i = androidtranscoder.engine.QueuedMuxer.AnonymousClass1.$SwitchMap$androidtranscoder$engine$QueuedMuxer$SampleType[sampleType.ordinal()];
        if (i == 1) {
            return this.mVideoTrackIndex;
        }
        if (i == 2) {
            return this.mAudioTrackIndex;
        }
        throw new java.lang.AssertionError();
    }

    private void onSetOutputFormat() {
        if (this.mVideoFormat == null || this.mAudioFormat == null) {
            return;
        }
        this.mListener.onDetermineOutputFormat();
        this.mVideoTrackIndex = this.mMuxer.addTrack(this.mVideoFormat);
        android.util.Log.v(TAG, "Added track #" + this.mVideoTrackIndex + " with " + this.mVideoFormat.getString(tv.danmaku.ijk.media.player.misc.IMediaFormat.KEY_MIME) + " to muxer");
        this.mAudioTrackIndex = this.mMuxer.addTrack(this.mAudioFormat);
        android.util.Log.v(TAG, "Added track #" + this.mAudioTrackIndex + " with " + this.mAudioFormat.getString(tv.danmaku.ijk.media.player.misc.IMediaFormat.KEY_MIME) + " to muxer");
        this.mMuxer.start();
        this.mStarted = true;
        int i = 0;
        if (this.mByteBuffer == null) {
            this.mByteBuffer = java.nio.ByteBuffer.allocate(0);
        }
        this.mByteBuffer.flip();
        android.util.Log.v(TAG, "Output format determined, writing " + this.mSampleInfoList.size() + " samples / " + this.mByteBuffer.limit() + " bytes to muxer.");
        android.media.MediaCodec.BufferInfo bufferInfo = new android.media.MediaCodec.BufferInfo();
        for (androidtranscoder.engine.QueuedMuxer.SampleInfo sampleInfo : this.mSampleInfoList) {
            sampleInfo.writeToBufferInfo(bufferInfo, i);
            this.mMuxer.writeSampleData(getTrackIndexForSampleType(sampleInfo.mSampleType), this.mByteBuffer, bufferInfo);
            i += sampleInfo.mSize;
        }
        this.mSampleInfoList.clear();
        this.mByteBuffer = null;
    }

    public void setOutputFormat(androidtranscoder.engine.QueuedMuxer.SampleType sampleType, android.media.MediaFormat mediaFormat) {
        int i = androidtranscoder.engine.QueuedMuxer.AnonymousClass1.$SwitchMap$androidtranscoder$engine$QueuedMuxer$SampleType[sampleType.ordinal()];
        if (i == 1) {
            this.mVideoFormat = mediaFormat;
        } else {
            if (i != 2) {
                throw new java.lang.AssertionError();
            }
            this.mAudioFormat = mediaFormat;
        }
        onSetOutputFormat();
    }

    public void writeSampleData(androidtranscoder.engine.QueuedMuxer.SampleType sampleType, java.nio.ByteBuffer byteBuffer, android.media.MediaCodec.BufferInfo bufferInfo) {
        if (this.mStarted) {
            this.mMuxer.writeSampleData(getTrackIndexForSampleType(sampleType), byteBuffer, bufferInfo);
            return;
        }
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        byteBuffer.position(bufferInfo.offset);
        if (this.mByteBuffer == null) {
            this.mByteBuffer = java.nio.ByteBuffer.allocateDirect(65536).order(java.nio.ByteOrder.nativeOrder());
        }
        this.mByteBuffer.put(byteBuffer);
        this.mSampleInfoList.add(new androidtranscoder.engine.QueuedMuxer.SampleInfo(sampleType, bufferInfo.size, bufferInfo, null));
    }
}
