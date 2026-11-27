package io.dcloud.feature.audio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AudioFeatureImpl implements io.dcloud.common.DHInterface.IFeature, io.dcloud.common.adapter.util.MessageHandler.IMessages {
    static final java.lang.String TAG = "AudioFeatureImpl";
    java.util.HashMap<java.lang.String, java.util.ArrayList> mAppsAudioObj = null;

    private java.lang.Object findAppObj(java.lang.String str, java.lang.String str2) {
        java.util.ArrayList appObjList = getAppObjList(str);
        if (appObjList.isEmpty()) {
            return null;
        }
        int size = appObjList.size();
        int i = 0;
        while (i < size) {
            java.lang.Object obj = appObjList.get(i);
            i++;
            if ((obj instanceof io.dcloud.feature.audio.AbsAudio) && ((io.dcloud.feature.audio.AbsAudio) obj).mUuid.equals(str2)) {
                return obj;
            }
        }
        return null;
    }

    private java.util.ArrayList getAppObjList(java.lang.String str) {
        java.util.ArrayList arrayList = this.mAppsAudioObj.get(str);
        if (arrayList != null) {
            return arrayList;
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList(2);
        this.mAppsAudioObj.put(str, arrayList2);
        return arrayList2;
    }

    private void putAppObjList(java.lang.String str, java.lang.Object obj) {
        getAppObjList(str).add(obj);
    }

    private void removeAppObjFromList(java.lang.String str, java.lang.Object obj) {
        java.util.ArrayList appObjList = getAppObjList(str);
        if (appObjList != null) {
            appObjList.remove(obj);
        }
    }

    private void setCanPlay(java.lang.String str, java.lang.String str2, boolean z) {
        java.util.ArrayList appObjList = getAppObjList(str);
        int size = appObjList.size();
        int i = 0;
        while (i < size) {
            java.lang.Object obj = appObjList.get(i);
            i++;
            if (obj instanceof io.dcloud.feature.audio.AudioPlayer) {
                io.dcloud.feature.audio.AudioPlayer audioPlayer = (io.dcloud.feature.audio.AudioPlayer) obj;
                if (!audioPlayer.mUuid.equals(str2) && !z) {
                    audioPlayer.pause();
                }
                audioPlayer.setCanMix(z);
            }
        }
    }

    private void setSpeakerphoneOn(android.media.AudioManager audioManager, boolean z) {
        if (z) {
            audioManager.setSpeakerphoneOn(true);
            audioManager.setMode(1);
        } else {
            audioManager.setSpeakerphoneOn(false);
            audioManager.setRouting(0, 1, -1);
            audioManager.setMode(3);
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:6:0x0044  */
    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        java.lang.String strObtainAppId = iWebview.obtainFrameView().obtainApp().obtainAppId();
        io.dcloud.common.adapter.util.Logger.d(TAG, "execute pJsArgs[0]=" + strArr[0]);
        if (!"AudioSyncExecMethod".equals(str)) {
            io.dcloud.common.adapter.util.MessageHandler.sendMessage(this, new java.lang.Object[]{iWebview, str, strArr});
            return null;
        }
        java.lang.String str2 = strArr[0];
        org.json.JSONArray jSONArrayCreateJSONArray = io.dcloud.common.util.JSONUtil.createJSONArray(strArr[1]);
        str2.getClass();
        str2.hashCode();
        switch (str2) {
            case "getPosition":
                return java.lang.String.valueOf(((io.dcloud.feature.audio.AudioPlayer) findAppObj(strObtainAppId, io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 0))).getPosition());
            case "getDuration":
                return java.lang.String.valueOf(((io.dcloud.feature.audio.AudioPlayer) findAppObj(strObtainAppId, io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 0))).getDuration());
            case "getBuffered":
                return ((io.dcloud.feature.audio.AudioPlayer) findAppObj(strObtainAppId, io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 0))).getBuffer();
            case "getPaused":
                return ((io.dcloud.feature.audio.AudioPlayer) findAppObj(strObtainAppId, io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 0))).isPause();
            case "getStyles":
                return ((io.dcloud.feature.audio.AudioPlayer) findAppObj(strObtainAppId, io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 0))).getStyles(jSONArrayCreateJSONArray.length() > 1 ? io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 1) : null);
            case "CreatePlayer":
                java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 0);
                io.dcloud.feature.audio.AudioPlayer audioPlayerCreateAudioPlayer = io.dcloud.feature.audio.AudioPlayer.createAudioPlayer(io.dcloud.common.util.JSONUtil.getJSONObject(jSONArrayCreateJSONArray, 1), iWebview);
                audioPlayerCreateAudioPlayer.mUuid = string;
                putAppObjList(iWebview.obtainFrameView().obtainApp().obtainAppId(), audioPlayerCreateAudioPlayer);
                return null;
            default:
                return null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        this.mAppsAudioObj = new java.util.HashMap<>(2);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
    public void execute(java.lang.Object obj) {
        java.lang.Object[] objArr = (java.lang.Object[]) obj;
        io.dcloud.common.DHInterface.IWebview iWebview = (io.dcloud.common.DHInterface.IWebview) objArr[0];
        java.lang.String strValueOf = java.lang.String.valueOf(objArr[1]);
        java.lang.String[] strArr = (java.lang.String[]) objArr[2];
        io.dcloud.common.DHInterface.IApp iAppObtainApp = iWebview.obtainFrameView().obtainApp();
        java.lang.String strObtainAppId = iAppObtainApp.obtainAppId();
        java.lang.String str = strArr[0];
        org.json.JSONArray jSONArrayCreateJSONArray = io.dcloud.common.util.JSONUtil.createJSONArray(strArr[1]);
        java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 0);
        if ("RecorderExecMethod".equals(strValueOf)) {
            io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Audio-" + strValueOf);
            try {
                if ("record".equals(str)) {
                    java.lang.String string2 = io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 1);
                    io.dcloud.feature.audio.recorder.RecordOption recordOption = new io.dcloud.feature.audio.recorder.RecordOption(iWebview, io.dcloud.common.util.JSONUtil.getJSONObject(jSONArrayCreateJSONArray, 2));
                    if (io.dcloud.common.util.JSUtil.checkOperateDirErrorAndCallback(iWebview, string2, recordOption.mFileName)) {
                        return;
                    }
                    io.dcloud.feature.audio.AudioRecorderMgr audioRecorderMgrStartRecorder = io.dcloud.feature.audio.AudioRecorderMgr.startRecorder(recordOption, string2);
                    audioRecorderMgrStartRecorder.mUuid = string;
                    putAppObjList(strObtainAppId, audioRecorderMgrStartRecorder);
                    return;
                }
                if ("pause".equals(str)) {
                    ((io.dcloud.feature.audio.AudioRecorderMgr) findAppObj(strObtainAppId, string)).pause();
                    return;
                }
                if (com.taobao.weex.common.Constants.Value.STOP.equals(str)) {
                    io.dcloud.feature.audio.AudioRecorderMgr audioRecorderMgr = (io.dcloud.feature.audio.AudioRecorderMgr) findAppObj(strObtainAppId, string);
                    audioRecorderMgr.stop();
                    audioRecorderMgr.successCallback();
                    removeAppObjFromList(strObtainAppId, audioRecorderMgr);
                    return;
                }
                if (io.dcloud.common.constant.AbsoluteConst.EVENTS_RESUME.equals(str)) {
                    ((io.dcloud.feature.audio.AudioRecorderMgr) findAppObj(strObtainAppId, string)).resume();
                    return;
                }
                return;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                io.dcloud.common.adapter.util.Logger.e("RecorderExecMethod _methodName=" + str + "; e =" + e);
                return;
            }
        }
        if (!"AudioExecMethod".equals(strValueOf)) {
            return;
        }
        io.dcloud.feature.audio.AudioPlayer audioPlayer = null;
        try {
            io.dcloud.feature.audio.AudioPlayer audioPlayer2 = (io.dcloud.feature.audio.AudioPlayer) findAppObj(strObtainAppId, string);
            try {
                try {
                    switch (str.hashCode()) {
                        case -934426579:
                            if (str.equals(io.dcloud.common.constant.AbsoluteConst.EVENTS_RESUME)) {
                                setCanPlay(strObtainAppId, string, audioPlayer2.isCanMix());
                                if (io.dcloud.common.util.BaseInfo.isUniAppAppid(iAppObtainApp)) {
                                    audioPlayer2.mFunId = "";
                                    audioPlayer2.play();
                                    return;
                                } else {
                                    audioPlayer2.resume();
                                    return;
                                }
                            }
                            return;
                        case -906224877:
                            if (str.equals("seekTo")) {
                                try {
                                    int i = java.lang.Integer.parseInt(io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 1));
                                    if (i >= 0) {
                                        audioPlayer2.seekTo(i * 1000);
                                        return;
                                    }
                                    return;
                                } catch (java.lang.Exception unused) {
                                    int i2 = (int) (java.lang.Double.parseDouble(io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 1)) * 1000.0d);
                                    if (i2 >= 0) {
                                        audioPlayer2.seekTo(i2);
                                        return;
                                    }
                                    return;
                                }
                            }
                            return;
                        case -625809843:
                            if (str.equals("addEventListener")) {
                                audioPlayer2.addEventListener(jSONArrayCreateJSONArray.optString(1), jSONArrayCreateJSONArray.optString(2));
                                return;
                            }
                            return;
                        case -541487286:
                            if (str.equals("removeEventListener")) {
                                audioPlayer2.removeEventListener(jSONArrayCreateJSONArray.optString(1));
                                return;
                            }
                            return;
                        case -388163342:
                            if (str.equals("setSessionCategory")) {
                                audioPlayer2.setSessionCategory(jSONArrayCreateJSONArray.length() > 1 ? io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 1) : null);
                                return;
                            }
                            return;
                        case 3443508:
                            if (str.equals(com.taobao.weex.common.Constants.Value.PLAY)) {
                                setCanPlay(strObtainAppId, string, audioPlayer2.isCanMix());
                                audioPlayer2.mFunId = io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 1);
                                audioPlayer2.play();
                                return;
                            }
                            return;
                        case 3540994:
                            if (str.equals(com.taobao.weex.common.Constants.Value.STOP)) {
                                audioPlayer2.stop();
                                return;
                            }
                            return;
                        case 94756344:
                            if (str.equals(io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE)) {
                                audioPlayer2.destory();
                                removeAppObjFromList(strObtainAppId, audioPlayer2);
                                return;
                            }
                            return;
                        case 106440182:
                            if (str.equals("pause")) {
                                audioPlayer2.pause();
                                return;
                            }
                            return;
                        case 589623268:
                            if (str.equals("setStyles")) {
                                audioPlayer2.setStyle(jSONArrayCreateJSONArray.optJSONObject(1));
                                return;
                            }
                            return;
                        case 1355420059:
                            if (!str.equals("playbackRate") || jSONArrayCreateJSONArray.length() <= 1) {
                                return;
                            }
                            java.lang.String string3 = io.dcloud.common.util.JSONUtil.getString(jSONArrayCreateJSONArray, 1);
                            if (android.text.TextUtils.isEmpty(string3)) {
                                return;
                            }
                            float f = java.lang.Float.parseFloat(string3);
                            if (f > 0.0f) {
                                audioPlayer2.playbackRate(f);
                                return;
                            }
                            return;
                        case 1403417351:
                            if (str.equals("setRoute")) {
                                android.media.AudioManager audioManager = (android.media.AudioManager) iWebview.getContext().getSystemService("audio");
                                if (java.lang.Integer.parseInt(jSONArrayCreateJSONArray.optString(1)) == 1) {
                                    setSpeakerphoneOn(audioManager, false);
                                    return;
                                } else {
                                    setSpeakerphoneOn(audioManager, true);
                                    return;
                                }
                            }
                            return;
                        default:
                            return;
                    }
                } catch (java.lang.Exception unused2) {
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                audioPlayer = audioPlayer2;
                e.printStackTrace();
                if (audioPlayer != null) {
                    java.lang.String str2 = io.dcloud.common.constant.DOMException.MSG_PARAMETER_ERROR;
                    audioPlayer.failCallback(-1, str2);
                    audioPlayer.execEvents("onError", io.dcloud.common.constant.DOMException.toJSON(-1, str2));
                }
            }
        } catch (java.lang.Exception e3) {
            e = e3;
        }
    }
}
