package io.dcloud.feature.audio.recorder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class HighGradeRecorder extends io.dcloud.feature.audio.recorder.AbsRecorder {
    public static final int ACTION_RESET = 1;
    public static final int ACTION_STOP = 2;
    private int mMaxDuration;
    private io.dcloud.feature.audio.recorder.RecordOption mOption;
    io.dcloud.feature.audio.recorder.HighGradeRecorder.Callback mStateListener;
    private java.lang.String outputFilePath;
    int stateBeforeFocusChange;
    private io.dcloud.feature.audio.recorder.RecorderTask audioRecorder = null;
    private int state = -1;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface Callback {
        void onMaxDurationReached();

        void onPause();

        void onRecording(double d, double d2);

        void onReset();

        void onResume();

        void onStart();

        void onStop(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public class State {
        public static final int INITIALIZED = 0;
        public static final int PAUSED = 3;
        public static final int PREPARED = 1;
        public static final int RECORDING = 2;
        public static final int STOPPED = 4;
        public static final int UNINITIALIZED = -1;

        public State() {
        }
    }

    public int getRecorderState() {
        return this.state;
    }

    public int getmMaxDuration() {
        return this.mMaxDuration;
    }

    void onstart() {
        if (this.state == 1) {
            this.state = 2;
            io.dcloud.feature.audio.recorder.HighGradeRecorder.Callback callback = this.mStateListener;
            if (callback != null) {
                callback.onStart();
            }
        }
    }

    @Override // io.dcloud.feature.audio.recorder.AbsRecorder
    public void pause() {
        io.dcloud.feature.audio.recorder.RecorderTask recorderTask = this.audioRecorder;
        if (recorderTask == null || this.state != 2) {
            return;
        }
        recorderTask.pauseRecord();
        this.state = 3;
        io.dcloud.feature.audio.recorder.HighGradeRecorder.Callback callback = this.mStateListener;
        if (callback != null) {
            callback.onPause();
        }
    }

    @Override // io.dcloud.feature.audio.recorder.AbsRecorder
    public void release() {
    }

    public void reset() {
        io.dcloud.feature.audio.recorder.RecorderTask recorderTask = this.audioRecorder;
        if (recorderTask == null) {
            return;
        }
        if (recorderTask != null && this.state != 4) {
            stop(1);
        }
        this.audioRecorder = null;
        io.dcloud.feature.audio.recorder.HighGradeRecorder.Callback callback = this.mStateListener;
        if (callback != null) {
            callback.onReset();
        }
    }

    @Override // io.dcloud.feature.audio.recorder.AbsRecorder
    public void resume() {
        io.dcloud.feature.audio.recorder.RecorderTask recorderTask = this.audioRecorder;
        if (recorderTask == null || this.state != 3) {
            return;
        }
        recorderTask.resumeRecord();
        this.state = 2;
        io.dcloud.feature.audio.recorder.HighGradeRecorder.Callback callback = this.mStateListener;
        if (callback != null) {
            callback.onResume();
        }
    }

    public io.dcloud.feature.audio.recorder.HighGradeRecorder setCallback(io.dcloud.feature.audio.recorder.HighGradeRecorder.Callback callback) {
        this.mStateListener = callback;
        return this;
    }

    public io.dcloud.feature.audio.recorder.HighGradeRecorder setMaxDuration(int i) {
        this.mMaxDuration = i * 1000;
        return this;
    }

    public io.dcloud.feature.audio.recorder.HighGradeRecorder setOutputFile(java.lang.String str) {
        this.outputFilePath = str;
        return this;
    }

    public io.dcloud.feature.audio.recorder.HighGradeRecorder setRecordOption(io.dcloud.feature.audio.recorder.RecordOption recordOption) {
        this.outputFilePath = recordOption.mFileName;
        this.mOption = recordOption;
        return this;
    }

    @Override // io.dcloud.feature.audio.recorder.AbsRecorder
    public void start() {
        int i = this.state;
        if (i != 0 && i != 4 && i != 1 && i != -1) {
            if (i == 3) {
                resume();
                return;
            }
            return;
        }
        io.dcloud.feature.audio.recorder.RecorderTask recorderTask = new io.dcloud.feature.audio.recorder.RecorderTask(new java.io.File(this.outputFilePath), this, this.mOption);
        this.audioRecorder = recorderTask;
        recorderTask.setCallback(this.mStateListener);
        this.audioRecorder.setMaxDuration(this.mMaxDuration);
        this.audioRecorder.start();
        this.state = 1;
        this.audioRecorder.startRecording();
    }

    @Override // io.dcloud.feature.audio.recorder.AbsRecorder
    public void stop() {
        stop(2);
    }

    public void stop(int i) {
        io.dcloud.feature.audio.recorder.RecorderTask recorderTask = this.audioRecorder;
        if (recorderTask == null || this.state != 2) {
            return;
        }
        recorderTask.stopRecord();
        this.state = 4;
        io.dcloud.feature.audio.recorder.HighGradeRecorder.Callback callback = this.mStateListener;
        if (callback != null) {
            callback.onStop(i);
        }
    }
}
