package io.dcloud.feature.audio.aac;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AacEncode {
    private static io.dcloud.feature.audio.aac.AacEncode mInstance;
    android.media.MediaCodec.BufferInfo bufferInfo;
    java.nio.ByteBuffer[] inputBuffers;
    private int mChannelCount;
    private int mSampleRate;
    private android.media.MediaCodec mediaCodec;
    java.nio.ByteBuffer[] outputBuffers;
    long presentationTimeUs = 0;
    java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
    private java.util.HashMap<java.lang.Integer, java.lang.Integer> freqidxs = new java.util.HashMap<>();

    public AacEncode(int i, int i2) {
        this.inputBuffers = null;
        this.outputBuffers = null;
        try {
            this.mediaCodec = android.media.MediaCodec.createEncoderByType(androidtranscoder.format.MediaFormatExtraConstants.MIMETYPE_AUDIO_AAC);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        this.mSampleRate = i;
        this.mChannelCount = i2;
        initFreqidxs();
        android.media.MediaFormat mediaFormatCreateAudioFormat = android.media.MediaFormat.createAudioFormat(androidtranscoder.format.MediaFormatExtraConstants.MIMETYPE_AUDIO_AAC, i, i2);
        mediaFormatCreateAudioFormat.setString(tv.danmaku.ijk.media.player.misc.IMediaFormat.KEY_MIME, androidtranscoder.format.MediaFormatExtraConstants.MIMETYPE_AUDIO_AAC);
        mediaFormatCreateAudioFormat.setInteger("aac-profile", 2);
        mediaFormatCreateAudioFormat.setInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, new int[]{64000, 96000, 128000}[1]);
        mediaFormatCreateAudioFormat.setInteger("max-input-size", 1048576);
        this.mediaCodec.configure(mediaFormatCreateAudioFormat, (android.view.Surface) null, (android.media.MediaCrypto) null, 1);
        this.mediaCodec.start();
        this.inputBuffers = this.mediaCodec.getInputBuffers();
        this.outputBuffers = this.mediaCodec.getOutputBuffers();
        this.bufferInfo = new android.media.MediaCodec.BufferInfo();
    }

    private void addADTStoPacket(byte[] bArr, int i) {
        int iIntValue = this.freqidxs.get(java.lang.Integer.valueOf(this.mSampleRate)).intValue();
        int i2 = this.mChannelCount;
        bArr[0] = -1;
        bArr[1] = -7;
        bArr[2] = (byte) ((iIntValue << 2) + 64 + (i2 >> 2));
        bArr[3] = (byte) (((i2 & 3) << 6) + (i >> 11));
        bArr[4] = (byte) ((i & 2047) >> 3);
        bArr[5] = (byte) (((i & 7) << 5) + 31);
        bArr[6] = -4;
    }

    private long computePresentationTime(long j) {
        return (j * 92160000) / ((long) this.mSampleRate);
    }

    public static io.dcloud.feature.audio.aac.AacEncode getAacEncode(int i, int i2) {
        if (mInstance == null) {
            mInstance = new io.dcloud.feature.audio.aac.AacEncode(i, i2);
        }
        return mInstance;
    }

    public void close() {
        try {
            this.mediaCodec.stop();
            this.mediaCodec.release();
            this.outputStream.flush();
            this.outputStream.close();
            mInstance = null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void initFreqidxs() {
        this.freqidxs.put(96000, 0);
        this.freqidxs.put(88200, 1);
        this.freqidxs.put(64000, 2);
        this.freqidxs.put(48000, 3);
        this.freqidxs.put(44100, 4);
        this.freqidxs.put(32000, 5);
        this.freqidxs.put(24000, 6);
        this.freqidxs.put(22050, 7);
        this.freqidxs.put(16000, 8);
        this.freqidxs.put(12000, 9);
        this.freqidxs.put(11025, 10);
        this.freqidxs.put(8000, 11);
        this.freqidxs.put(7350, 12);
    }

    public byte[] offerEncoder(byte[] bArr) throws java.lang.Exception {
        int iDequeueInputBuffer = this.mediaCodec.dequeueInputBuffer(-1L);
        if (iDequeueInputBuffer >= 0) {
            java.nio.ByteBuffer byteBuffer = this.inputBuffers[iDequeueInputBuffer];
            byteBuffer.clear();
            byteBuffer.put(bArr);
            byteBuffer.limit(bArr.length);
            this.mediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, bArr.length, computePresentationTime(this.presentationTimeUs), 0);
            this.presentationTimeUs++;
        }
        int iDequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(this.bufferInfo, 0L);
        while (iDequeueOutputBuffer >= 0) {
            android.media.MediaCodec.BufferInfo bufferInfo = this.bufferInfo;
            int i = bufferInfo.size;
            int i2 = i + 7;
            java.nio.ByteBuffer byteBuffer2 = this.outputBuffers[iDequeueOutputBuffer];
            byteBuffer2.position(bufferInfo.offset);
            byteBuffer2.limit(this.bufferInfo.offset + i);
            byte[] bArr2 = new byte[i2];
            addADTStoPacket(bArr2, i2);
            byteBuffer2.get(bArr2, 7, i);
            byteBuffer2.position(this.bufferInfo.offset);
            this.outputStream.write(bArr2);
            this.mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, false);
            iDequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(this.bufferInfo, 0L);
        }
        byte[] byteArray = this.outputStream.toByteArray();
        this.outputStream.flush();
        this.outputStream.reset();
        return byteArray;
    }

    public static io.dcloud.feature.audio.aac.AacEncode getAacEncode() {
        return mInstance;
    }
}
