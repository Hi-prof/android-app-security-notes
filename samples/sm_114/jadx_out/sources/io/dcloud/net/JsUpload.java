package io.dcloud.net;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class JsUpload implements io.dcloud.common.DHInterface.IReqListener, io.dcloud.common.DHInterface.IResponseListener {
    private static final int STATE_COMPLETED = 4;
    private static final int STATE_CONNECTED = 2;
    private static final int STATE_CONNECTING = 1;
    private static final int STATE_INIT = 0;
    private static final int STATE_PAUSE = 5;
    private static final int STATE_RECEIVING = 3;
    private static final int STATE_UNKOWN = -1;
    boolean isStart = false;
    io.dcloud.common.util.net.RequestData mRequestData;
    int mState;
    public java.lang.String mUUID;
    io.dcloud.net.UploadNetWork mUploadNetWork;
    java.lang.String mUrl;
    io.dcloud.common.DHInterface.IWebview mWebview;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class UploadFile implements io.dcloud.net.JsUpload.UploadItem {
        java.io.InputStream mFileInputS;
        long mFileSize;
        java.lang.String mFilename;
        java.lang.String mMimetype;
        java.lang.String mRange;

        UploadFile() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    interface UploadItem {
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class UploadString implements io.dcloud.net.JsUpload.UploadItem {
        java.lang.String mData;

        public UploadString(java.lang.String str) {
            this.mData = str;
        }
    }

    public JsUpload(io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONObject jSONObject) {
        this.mWebview = iWebview;
        this.mUrl = jSONObject.optString("url");
        this.mUUID = jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_UUID);
        io.dcloud.common.util.net.RequestData requestData = new io.dcloud.common.util.net.RequestData(this.mUrl, jSONObject.optString("method", "POST"));
        this.mRequestData = requestData;
        requestData.mChunkSize = jSONObject.optInt("chunkSize", 0);
        this.mRequestData.unTrustedCAType = iWebview.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_UNTRUSTEDCA);
        this.mRequestData.addHeader(io.dcloud.common.DHInterface.IWebview.USER_AGENT, iWebview.getWebviewProperty(io.dcloud.common.DHInterface.IWebview.USER_AGENT));
        io.dcloud.net.UploadNetWork uploadNetWork = new io.dcloud.net.UploadNetWork(1, this.mRequestData, this, this);
        this.mUploadNetWork = uploadNetWork;
        uploadNetWork.mPriority = jSONObject.optInt("priority");
        if (jSONObject.has("timeout")) {
            this.mRequestData.mTimeout = jSONObject.optInt("timeout") * 1000;
        }
        this.mUploadNetWork.MAX_TIMES = jSONObject.optInt(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_RETRY);
        this.mUploadNetWork.setRetryIntervalTime(jSONObject.optLong(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_RETRY_INTERVAL_TIME) * 1000);
    }

    public boolean addData(java.lang.String str, java.lang.String str2) {
        return this.mUploadNetWork.addParemeter(str, str2);
    }

    public boolean addFile(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONObject jSONObject) {
        io.dcloud.net.JsUpload.UploadFile uploadFile = new io.dcloud.net.JsUpload.UploadFile();
        try {
            if (!str.startsWith("content://")) {
                java.io.File file = new java.io.File(str);
                if (io.dcloud.common.util.FileUtil.needMediaStoreOpenFile(iWebview.getContext())) {
                    uploadFile.mFileInputS = io.dcloud.common.util.FileUtil.getFileInputStream(iWebview.getContext(), file);
                } else {
                    uploadFile.mFileInputS = new java.io.FileInputStream(file);
                }
                if (uploadFile.mFileInputS == null) {
                    return false;
                }
                uploadFile.mFileSize = file.length();
                java.lang.String strOptString = jSONObject.optString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, file.getName());
                uploadFile.mFilename = jSONObject.optString("name", file.getName());
                uploadFile.mMimetype = jSONObject.optString(tv.danmaku.ijk.media.player.misc.IMediaFormat.KEY_MIME, io.dcloud.common.util.PdrUtil.getMimeType(str));
                return this.mUploadNetWork.addFile(strOptString, uploadFile);
            }
            android.net.Uri uri = android.net.Uri.parse(str);
            android.database.Cursor cursorQuery = iWebview.getContext().getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery == null) {
                return false;
            }
            java.io.InputStream inputStreamOpenInputStream = iWebview.getContext().getContentResolver().openInputStream(uri);
            cursorQuery.moveToFirst();
            int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_size"));
            java.lang.String string = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
            java.lang.String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("mime_type"));
            uploadFile.mFileInputS = inputStreamOpenInputStream;
            uploadFile.mFileSize = i;
            java.lang.String strOptString2 = jSONObject.optString(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, string);
            uploadFile.mFilename = jSONObject.optString("name", string);
            uploadFile.mMimetype = jSONObject.optString(tv.danmaku.ijk.media.player.misc.IMediaFormat.KEY_MIME, string2);
            boolean zAddFile = this.mUploadNetWork.addFile(strOptString2, uploadFile);
            cursorQuery.close();
            return zAddFile;
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // io.dcloud.common.DHInterface.IReqListener
    public void onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState netState, boolean z) {
        if (netState == io.dcloud.common.DHInterface.IReqListener.NetState.NET_INIT) {
            this.mState = 0;
            io.dcloud.common.util.Deprecated_JSUtil.excUploadCallBack(this.mWebview, toJsonUpload(), this.mUUID);
            return;
        }
        if (netState == io.dcloud.common.DHInterface.IReqListener.NetState.NET_REQUEST_BEGIN) {
            this.mState = 1;
            io.dcloud.common.util.Deprecated_JSUtil.excUploadCallBack(this.mWebview, toJsonUpload(), this.mUUID);
            return;
        }
        if (netState == io.dcloud.common.DHInterface.IReqListener.NetState.NET_CONNECTED) {
            this.mState = 2;
            io.dcloud.common.util.Deprecated_JSUtil.excUploadCallBack(this.mWebview, toJsonUpload(), this.mUUID);
            return;
        }
        if (netState == io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_ING) {
            this.mState = 3;
            io.dcloud.common.util.Deprecated_JSUtil.excUploadCallBack(this.mWebview, toJsonUpload(), this.mUUID);
        } else if (netState == io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_END || netState == io.dcloud.common.DHInterface.IReqListener.NetState.NET_ERROR) {
            this.mState = 4;
            io.dcloud.common.util.net.UploadMgr.getUploadMgr().removeNetWork(this.mUploadNetWork);
            io.dcloud.common.util.Deprecated_JSUtil.excUploadCallBack(this.mWebview, io.dcloud.common.util.StringUtil.format("{state:%d,status:%d,filename:'%s',responseText:%s,headers:%s}", java.lang.Integer.valueOf(this.mState), java.lang.Integer.valueOf(this.mUploadNetWork.mStatus), this.mUploadNetWork.mUploadingFile.toString(), io.dcloud.common.util.JSONUtil.toJSONableString(this.mUploadNetWork.getResponseText()), this.mUploadNetWork.responseHeaders), this.mUUID);
        }
    }

    @Override // io.dcloud.common.DHInterface.IReqListener
    public int onReceiving(java.io.InputStream inputStream) {
        return 0;
    }

    @Override // io.dcloud.common.DHInterface.IResponseListener
    public void onResponseState(int i, java.lang.String str) {
    }

    @Override // io.dcloud.common.DHInterface.IReqListener
    public void onResponsing(java.io.InputStream inputStream) {
    }

    public void setRequestHeader(java.lang.String str, java.lang.String str2) {
        this.mRequestData.addHeader(str, str2);
    }

    public java.lang.String toJsonUpload() {
        return io.dcloud.common.util.StringUtil.format("{state:%d,status:%d,uploadedSize:%d,totalSize:%d,headers:%s}", java.lang.Integer.valueOf(this.mState), java.lang.Integer.valueOf(this.mUploadNetWork.mStatus), java.lang.Long.valueOf(this.mUploadNetWork.mUploadedSize), java.lang.Long.valueOf(this.mUploadNetWork.mTotalSize), this.mUploadNetWork.responseHeaders);
    }
}
