package io.dcloud.feature.audio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AudioRecorderMgr extends io.dcloud.feature.audio.AbsAudio {
    private static io.dcloud.feature.audio.AudioRecorderMgr mInstance;
    java.lang.String mFunId;
    io.dcloud.feature.audio.recorder.AbsRecorder mNativeRecorder;
    io.dcloud.feature.audio.recorder.RecordOption mOption;

    private AudioRecorderMgr() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failCallback(java.lang.String str) {
        io.dcloud.common.util.Deprecated_JSUtil.excCallbackError(this.mOption.mWebview, this.mFunId, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 3, str), true);
    }

    public static boolean isPause(java.lang.String str) {
        return str.equalsIgnoreCase("mp3") || str.equalsIgnoreCase("aac");
    }

    static io.dcloud.feature.audio.AudioRecorderMgr startRecorder(io.dcloud.feature.audio.recorder.RecordOption recordOption, java.lang.String str) {
        if (mInstance == null) {
            mInstance = new io.dcloud.feature.audio.AudioRecorderMgr();
        }
        io.dcloud.feature.audio.AudioRecorderMgr audioRecorderMgr = mInstance;
        audioRecorderMgr.mOption = recordOption;
        audioRecorderMgr.mFunId = str;
        io.dcloud.common.adapter.util.PermissionUtil.usePermission(recordOption.mWebview.getActivity(), "audio", io.dcloud.common.adapter.util.PermissionUtil.PMS_RECORD, 2, new io.dcloud.common.adapter.util.PermissionUtil.StreamPermissionRequest(mInstance.mOption.mWebview.obtainApp()) { // from class: io.dcloud.feature.audio.AudioRecorderMgr.1
            @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
            public void onDenied(java.lang.String str2) {
                if (io.dcloud.feature.audio.AudioRecorderMgr.mInstance != null) {
                    io.dcloud.feature.audio.AudioRecorderMgr.mInstance.failCallback(io.dcloud.common.constant.DOMException.MSG_NO_PERMISSION);
                }
            }

            @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
            public void onGranted(java.lang.String str2) {
                if (io.dcloud.feature.audio.AudioRecorderMgr.mInstance == null) {
                    return;
                }
                if (!io.dcloud.feature.audio.AudioRecorderMgr.isPause(io.dcloud.feature.audio.AudioRecorderMgr.mInstance.mOption.mFormat)) {
                    io.dcloud.feature.audio.AudioRecorderMgr.mInstance.mNativeRecorder = new io.dcloud.feature.audio.recorder.AudioRecorder(io.dcloud.feature.audio.AudioRecorderMgr.mInstance.mOption);
                    try {
                        io.dcloud.feature.audio.AudioRecorderMgr.mInstance.mNativeRecorder.start();
                        return;
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                        io.dcloud.feature.audio.AudioRecorderMgr.mInstance.failCallback(e.getMessage());
                        io.dcloud.feature.audio.AudioRecorderMgr.mInstance.stop();
                        return;
                    }
                }
                io.dcloud.feature.audio.AudioRecorderMgr.mInstance.mNativeRecorder = new io.dcloud.feature.audio.recorder.HighGradeRecorder().setRecordOption(io.dcloud.feature.audio.AudioRecorderMgr.mInstance.mOption);
                io.dcloud.feature.audio.AudioRecorderMgr.mInstance.mOption.mFormat.equalsIgnoreCase("aac");
                if (!io.dcloud.feature.audio.AudioRecorderMgr.mInstance.mOption.mFormat.equalsIgnoreCase("mp3") || io.dcloud.feature.audio.recorder.RecorderUtil.isContainMp3()) {
                    try {
                        io.dcloud.feature.audio.AudioRecorderMgr.mInstance.mNativeRecorder.start();
                        return;
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                        io.dcloud.feature.audio.AudioRecorderMgr.mInstance.failCallback(e2.getMessage());
                        io.dcloud.feature.audio.AudioRecorderMgr.mInstance.stop();
                        return;
                    }
                }
                io.dcloud.feature.audio.AudioRecorderMgr.mInstance.failCallback(io.dcloud.feature.audio.AudioRecorderMgr.mInstance.mOption.mWebview.getContext().getString(io.dcloud.base.R.string.dcloud_audio_not_mp3_recording));
                android.app.Dialog lossDialog = io.dcloud.common.util.ErrorDialogUtil.getLossDialog(io.dcloud.feature.audio.AudioRecorderMgr.mInstance.mOption.mWebview, io.dcloud.feature.audio.AudioRecorderMgr.mInstance.mOption.mWebview.getContext().getString(io.dcloud.base.R.string.dcloud_audio_no_mp3_module_added) + " https://ask.dcloud.net.cn/article/35058", "https://ask.dcloud.net.cn/article/35058", "audio");
                if (lossDialog != null) {
                    lossDialog.show();
                }
            }
        });
        return mInstance;
    }

    public void pause() {
        io.dcloud.feature.audio.recorder.RecordOption recordOption;
        io.dcloud.feature.audio.AudioRecorderMgr audioRecorderMgr = mInstance;
        if (audioRecorderMgr == null || (recordOption = audioRecorderMgr.mOption) == null || !isPause(recordOption.mFormat)) {
            return;
        }
        mInstance.mNativeRecorder.pause();
    }

    public void resume() {
        io.dcloud.feature.audio.recorder.RecordOption recordOption;
        io.dcloud.feature.audio.AudioRecorderMgr audioRecorderMgr = mInstance;
        if (audioRecorderMgr == null || (recordOption = audioRecorderMgr.mOption) == null || !isPause(recordOption.mFormat)) {
            return;
        }
        mInstance.mNativeRecorder.resume();
    }

    public void stop() {
        io.dcloud.feature.audio.recorder.AbsRecorder absRecorder;
        io.dcloud.feature.audio.AudioRecorderMgr audioRecorderMgr = mInstance;
        if (audioRecorderMgr != null && (absRecorder = audioRecorderMgr.mNativeRecorder) != null) {
            absRecorder.stop();
            mInstance.mNativeRecorder.release();
            mInstance.mNativeRecorder = null;
        }
        mInstance = null;
    }

    void successCallback() {
        io.dcloud.feature.audio.recorder.RecordOption recordOption = this.mOption;
        io.dcloud.common.util.Deprecated_JSUtil.excCallbackSuccess(this.mOption.mWebview, this.mFunId, recordOption.mWebview.obtainFrameView().obtainApp().convert2RelPath(recordOption.mFileName));
    }
}
