package androidtranscoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class VideoCompressor {
    private static androidtranscoder.VideoCompressor instance;

    private VideoCompressor() {
    }

    public static void callBackError(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, int i) {
        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, io.dcloud.common.constant.DOMException.toJSON(i, str2), io.dcloud.common.util.JSUtil.ERROR, true, false);
    }

    public static void callBackSuccess(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str, str2, io.dcloud.common.util.JSUtil.OK, true, false);
    }

    public static androidtranscoder.VideoCompressor getInstance() {
        if (instance == null) {
            synchronized (androidtranscoder.VideoCompressor.class) {
                if (instance == null) {
                    instance = new androidtranscoder.VideoCompressor();
                }
            }
        }
        return instance;
    }

    public void compressVideo(final io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String[] strArr) {
        final java.lang.String path;
        int i = 1;
        final java.lang.String str = strArr[1];
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(strArr[0]);
            java.lang.String strOptString = jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_FILENAME);
            if (android.text.TextUtils.isEmpty(strOptString)) {
                java.lang.String strObtainAppTempPath = iWebview.obtainApp().obtainAppTempPath();
                java.io.File file = new java.io.File(strObtainAppTempPath);
                if (!file.exists()) {
                    file.mkdir();
                }
                path = strObtainAppTempPath + "/compress_video_" + android.os.SystemClock.elapsedRealtime() + ".mp4";
            } else if (strOptString.endsWith("/")) {
                java.lang.String strConvert2WebviewFullPath = iWebview.obtainFrameView().obtainApp().convert2WebviewFullPath(iWebview.obtainFullUrl(), strOptString);
                if (strConvert2WebviewFullPath.startsWith("file:")) {
                    strConvert2WebviewFullPath = android.net.Uri.parse(strConvert2WebviewFullPath).getPath();
                }
                java.io.File file2 = new java.io.File(strConvert2WebviewFullPath);
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (file2.exists() && !file2.isDirectory()) {
                    file2.delete();
                    file2.mkdirs();
                }
                path = file2.getPath() + "/compress_video_" + android.os.SystemClock.elapsedRealtime() + ".mp4";
            } else {
                java.lang.String strConvert2WebviewFullPath2 = iWebview.obtainFrameView().obtainApp().convert2WebviewFullPath(iWebview.obtainFullUrl(), strOptString);
                if (strConvert2WebviewFullPath2.startsWith("file:")) {
                    strConvert2WebviewFullPath2 = android.net.Uri.parse(strConvert2WebviewFullPath2).getPath();
                }
                java.io.File file3 = new java.io.File(strConvert2WebviewFullPath2);
                if (!file3.getParentFile().exists()) {
                    file3.getParentFile().mkdirs();
                }
                path = file3.getPath();
            }
            java.lang.String strConvert2AbsFullPath = iWebview.obtainApp().convert2AbsFullPath(jSONObject.optString("src"));
            java.lang.String strOptString2 = jSONObject.optString(com.taobao.weex.common.Constants.Name.QUALITY);
            double d = 1.0d;
            double dOptDouble = jSONObject.optDouble("resolution", 1.0d);
            if (dOptDouble > 0.0d && dOptDouble < 1.0d) {
                d = dOptDouble;
            }
            if ("low".equalsIgnoreCase(strOptString2)) {
                i = 3;
            } else if ("medium".equalsIgnoreCase(strOptString2)) {
                i = 2;
            } else {
                "high".equalsIgnoreCase(strOptString2);
            }
            try {
                androidtranscoder.MediaTranscoder.Listener listener = new androidtranscoder.MediaTranscoder.Listener() { // from class: androidtranscoder.VideoCompressor.1
                    @Override // androidtranscoder.MediaTranscoder.Listener
                    public void onTranscodeCanceled() {
                        androidtranscoder.VideoCompressor.callBackError(iWebview, str, io.dcloud.common.constant.DOMException.MSG_USER_CANCEL, -2);
                    }

                    @Override // androidtranscoder.MediaTranscoder.Listener
                    public void onTranscodeCompleted() {
                        java.io.File file4 = new java.io.File(path);
                        if (!file4.exists()) {
                            androidtranscoder.VideoCompressor.callBackError(iWebview, str, io.dcloud.common.constant.DOMException.MSG_IO_ERROR, -5);
                            return;
                        }
                        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
                        jSONObject2.put("tempFilePath", (java.lang.Object) android.net.Uri.fromFile(file4).toString());
                        jSONObject2.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, (java.lang.Object) java.lang.Long.valueOf(file4.length()));
                        androidtranscoder.VideoCompressor.callBackSuccess(iWebview, str, jSONObject2.toJSONString());
                    }

                    @Override // androidtranscoder.MediaTranscoder.Listener
                    public void onTranscodeFailed(java.lang.Exception exc) {
                        androidtranscoder.VideoCompressor.callBackError(iWebview, str, exc.getMessage(), -99);
                    }

                    @Override // androidtranscoder.MediaTranscoder.Listener
                    public void onTranscodeProgress(double d2) {
                    }
                };
                if (!strConvert2AbsFullPath.startsWith("content://")) {
                    androidtranscoder.MediaTranscoder.getInstance().transcodeVideo(strConvert2AbsFullPath, path, androidtranscoder.format.MediaFormatStrategyPresets.createAndroid720pStrategy(i, d), listener);
                    return;
                }
                try {
                    androidtranscoder.MediaTranscoder.getInstance().transcodeVideo(((java.io.FileInputStream) iWebview.getContext().getContentResolver().openInputStream(android.net.Uri.parse(strConvert2AbsFullPath))).getFD(), path, androidtranscoder.format.MediaFormatStrategyPresets.createAndroid720pStrategy(i, d), listener);
                } catch (java.lang.Throwable unused) {
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
                callBackError(iWebview, str, e.getMessage(), -99);
            }
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
            callBackError(iWebview, str, io.dcloud.common.constant.DOMException.MSG_PARAMETER_ERROR, -1);
        }
    }
}
