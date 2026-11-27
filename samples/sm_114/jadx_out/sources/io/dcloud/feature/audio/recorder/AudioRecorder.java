package io.dcloud.feature.audio.recorder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AudioRecorder extends io.dcloud.feature.audio.recorder.AbsRecorder {
    private android.media.MediaRecorder mRecorder;

    public AudioRecorder(io.dcloud.feature.audio.recorder.RecordOption recordOption) {
        android.media.MediaRecorder mediaRecorder = new android.media.MediaRecorder();
        this.mRecorder = mediaRecorder;
        try {
            mediaRecorder.reset();
            this.mRecorder.setAudioSource(0);
            java.lang.String str = recordOption.mFileName;
            if (!io.dcloud.common.adapter.io.DHFile.isExist(str)) {
                io.dcloud.common.adapter.io.DHFile.createNewFile(io.dcloud.common.adapter.io.DHFile.createFileHandler(str));
            }
            this.mRecorder.setOutputFile(str);
            try {
                this.mRecorder.setAudioSamplingRate(recordOption.mSamplingRate);
                int i = recordOption.mSamplingRate;
                if (i == 44100) {
                    this.mRecorder.setOutputFormat(1);
                    this.mRecorder.setAudioEncoder(3);
                } else if (i == 16000) {
                    this.mRecorder.setOutputFormat(4);
                    this.mRecorder.setAudioEncoder(2);
                } else if (i == 8000) {
                    this.mRecorder.setOutputFormat(3);
                    this.mRecorder.setAudioEncoder(1);
                } else {
                    this.mRecorder.setOutputFormat(0);
                    this.mRecorder.setAudioEncoder(0);
                }
            } catch (java.lang.Exception e) {
                this.mRecorder.reset();
                this.mRecorder.setAudioSource(0);
                this.mRecorder.setOutputFile(str);
                io.dcloud.common.adapter.util.Logger.w("HighGradeRecorder.getRecorderInstence", e);
                if (io.dcloud.common.util.PdrUtil.isEquals(recordOption.mFormat, "3gp")) {
                    this.mRecorder.setOutputFormat(1);
                } else if (io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer >= 10) {
                    this.mRecorder.setOutputFormat(3);
                } else {
                    this.mRecorder.setOutputFormat(0);
                }
                this.mRecorder.setAudioEncoder(1);
            }
            this.mRecorder.prepare();
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // io.dcloud.feature.audio.recorder.AbsRecorder
    public void pause() {
    }

    @Override // io.dcloud.feature.audio.recorder.AbsRecorder
    public void release() {
        this.mRecorder.release();
    }

    @Override // io.dcloud.feature.audio.recorder.AbsRecorder
    public void resume() {
    }

    @Override // io.dcloud.feature.audio.recorder.AbsRecorder
    public void start() {
        this.mRecorder.start();
    }

    @Override // io.dcloud.feature.audio.recorder.AbsRecorder
    public void stop() {
        this.mRecorder.stop();
    }
}
