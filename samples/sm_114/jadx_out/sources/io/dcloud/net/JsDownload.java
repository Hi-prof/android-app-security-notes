package io.dcloud.net;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class JsDownload implements io.dcloud.common.DHInterface.IReqListener, io.dcloud.common.DHInterface.IResponseListener {
    public static final java.lang.String DOWNLOAD_NAME = "_download_dcloud";
    static final int STATE_COMPLETED = 4;
    static final int STATE_CONNECTED = 2;
    static final int STATE_CONNECTING = 1;
    static final int STATE_INIT = 0;
    static final int STATE_PAUSE = 5;
    static final int STATE_RECEIVING = 3;
    static final int STATE_UNDEFINED = -1000;
    static final int STATE_UNKOWN = -1;
    public boolean mAbort;
    java.lang.String mData;
    private boolean mDownloadComplete;
    private io.dcloud.net.DownloadJSMgr mDownloadMgr;
    io.dcloud.net.DownloadNetWork mDownloadNetWork;
    java.lang.String mMethod;
    public boolean mPause;
    int mPriority;
    private java.util.ArrayList<io.dcloud.common.DHInterface.IWebview> mRelWebviews;
    io.dcloud.common.util.net.RequestData mRequestData;
    private long mRetryIntervalTime;
    public io.dcloud.common.DHInterface.IWebview mWebview;
    private java.lang.String sAppid;
    private java.lang.String sharedPreferenceName;
    int mState = -1000;
    java.lang.String mUUID = null;
    java.lang.String mUrl = null;
    java.lang.String mRealURL = null;
    boolean append = false;
    private long responseOffset = 0;
    org.json.JSONObject mOptions = null;
    java.lang.String mFileName = "";
    private java.lang.String mParentPath = null;
    private java.io.File mFile = null;
    java.io.RandomAccessFile mFileOs = null;
    long mFileSize = 0;
    long mTotalSize = 0;
    int mRetry = 3;
    java.lang.String mConfigFilePath = null;
    private long preTime = 0;

    JsDownload(io.dcloud.net.DownloadJSMgr downloadJSMgr, io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONObject jSONObject) {
        this.mDownloadNetWork = null;
        this.mRequestData = null;
        this.mRelWebviews = null;
        this.mDownloadMgr = downloadJSMgr;
        this.mWebview = iWebview;
        java.util.ArrayList<io.dcloud.common.DHInterface.IWebview> arrayList = new java.util.ArrayList<>();
        this.mRelWebviews = arrayList;
        arrayList.add(iWebview);
        parseJson(jSONObject);
        io.dcloud.common.util.net.RequestData requestData = new io.dcloud.common.util.net.RequestData(this.mUrl, this.mMethod);
        this.mRequestData = requestData;
        requestData.unTrustedCAType = iWebview.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_UNTRUSTEDCA);
        if (!jSONObject.isNull("timeout")) {
            this.mRequestData.mTimeout = jSONObject.optInt("timeout") * 1000;
        }
        this.mRequestData.addHeader(io.dcloud.common.DHInterface.IWebview.USER_AGENT, iWebview.getWebviewProperty(io.dcloud.common.DHInterface.IWebview.USER_AGENT));
        io.dcloud.net.DownloadNetWork downloadNetWork = new io.dcloud.net.DownloadNetWork(2, this.mRequestData, this, this);
        this.mDownloadNetWork = downloadNetWork;
        downloadNetWork.MAX_TIMES = this.mRetry;
        downloadNetWork.mPriority = this.mPriority;
        downloadNetWork.setRetryIntervalTime(this.mRetryIntervalTime);
        this.sAppid = this.mWebview.obtainFrameView().obtainApp().obtainAppId();
        this.sharedPreferenceName = this.sAppid + DOWNLOAD_NAME;
    }

    private void checkSpecialFile(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || !io.dcloud.common.util.BaseInfo.ISAMU) {
            return;
        }
        int length = str.length();
        java.lang.String str2 = io.dcloud.common.constant.StringConst.POINT_APP_EN;
        if (((length - str.indexOf(str2)) - str2.length() == 0 || (length - str.indexOf(".wgt")) - 4 == 0 || (length - str.indexOf(".wgtu")) - 5 == 0) && this.mWebview != null) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("type", io.dcloud.common.constant.AbsoluteConst.SPNAME_DOWNLOAD);
                jSONObject.put("file", this.mParentPath + this.mFileName);
                jSONObject.put("url", this.mUrl);
                jSONObject.put("appid", this.mWebview.obtainApp().obtainOriginalAppId());
                jSONObject.put("version", this.mWebview.obtainApp().obtainAppVersionName());
                android.util.Log.i(io.dcloud.common.constant.AbsoluteConst.HBUILDER_TAG, jSONObject.toString());
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private java.io.File createDownloadFile(boolean z) {
        try {
            java.lang.String realPath = getRealPath(this.mFileName);
            if (realPath == null) {
                return null;
            }
            java.io.File file = new java.io.File(realPath);
            if (z && file.exists()) {
                return file;
            }
            java.lang.String str = this.mFileName;
            int iLastIndexOf = str.lastIndexOf(com.taobao.weex.el.parse.Operators.DOT_STR);
            java.lang.String strSubstring = iLastIndexOf < 0 ? str : str.substring(0, iLastIndexOf);
            java.lang.String strSubstring2 = iLastIndexOf < 0 ? "" : str.substring(iLastIndexOf);
            int i = 1;
            while (file.exists()) {
                str = strSubstring + com.taobao.weex.el.parse.Operators.BRACKET_START_STR + i + com.taobao.weex.el.parse.Operators.BRACKET_END_STR + strSubstring2;
                i++;
                file = new java.io.File(getRealPath(str));
            }
            this.mFileName = str;
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            return file;
        } catch (java.lang.Exception e) {
            java.lang.String str2 = this.mFileName;
            if (str2 == null || !str2.toLowerCase(java.util.Locale.ENGLISH).startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
                e.printStackTrace();
                return null;
            }
            this.mFileName = this.mFileName.substring(7);
            java.io.File fileCreateDownloadFile = createDownloadFile(this.append);
            if (fileCreateDownloadFile != null) {
                this.mFileName = fileCreateDownloadFile.getAbsolutePath();
            }
            return fileCreateDownloadFile;
        }
    }

    private void initPath(java.lang.String str) {
        io.dcloud.common.DHInterface.IApp iAppObtainApp = this.mWebview.obtainFrameView().obtainApp();
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            this.mParentPath = new java.io.File(io.dcloud.common.util.BaseInfo.sDownloadFullPath).getParent() + "/";
            this.mFileName = "_downloads/";
            return;
        }
        this.mFileName = str;
        if (startsWith(str, io.dcloud.common.util.BaseInfo.REL_PRIVATE_DOC_DIR, true)) {
            this.mParentPath = new java.io.File(iAppObtainApp.obtainAppDocPath()).getParent() + "/";
            return;
        }
        if (startsWith(str, io.dcloud.common.util.BaseInfo.REL_PUBLIC_DOCUMENTS_DIR, true)) {
            this.mParentPath = new java.io.File(io.dcloud.common.util.BaseInfo.sDocumentFullPath).getParent() + "/";
            return;
        }
        if (startsWith(str, io.dcloud.common.util.BaseInfo.REL_PUBLIC_DOWNLOADS_DIR, true)) {
            this.mParentPath = new java.io.File(io.dcloud.common.util.BaseInfo.sDownloadFullPath).getParent() + "/";
            return;
        }
        this.mParentPath = new java.io.File(io.dcloud.common.util.BaseInfo.sDownloadFullPath).getParent() + "/";
    }

    private boolean justDirPath() {
        return android.text.TextUtils.isEmpty(this.mFileName) || this.mFileName.endsWith("/");
    }

    private void onStateChanged(int i) {
        if (i == 3 || i == 5) {
            this.mState = i;
        }
        boolean z = i == 3 && android.os.SystemClock.elapsedRealtime() - this.preTime >= 10;
        if (z || i != 3 || this.mTotalSize - this.mFileSize <= 5120 || this.mAbort) {
            if (z) {
                this.preTime = android.os.SystemClock.elapsedRealtime();
            }
            java.lang.String json = toJSON();
            int size = this.mRelWebviews.size();
            for (int i2 = 0; i2 < size; i2++) {
                io.dcloud.common.util.Deprecated_JSUtil.excDownloadCallBack(this.mRelWebviews.get(i2), json, this.mUUID);
            }
        }
        if (this.mAbort) {
            return;
        }
        saveDownloadState();
    }

    private void parseJson(org.json.JSONObject jSONObject) {
        this.mOptions = jSONObject.optJSONObject("options");
        this.mUrl = io.dcloud.common.util.JSONUtil.getString(jSONObject, "url");
        java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_REALURL);
        if (string != null && !string.equalsIgnoreCase("null") && !string.equalsIgnoreCase(this.mUrl)) {
            this.mUrl = string;
        }
        java.lang.String string2 = io.dcloud.common.util.JSONUtil.getString(jSONObject, "id");
        this.mUUID = string2;
        if (android.text.TextUtils.isEmpty(string2)) {
            this.mUUID = io.dcloud.common.util.JSONUtil.getString(jSONObject, "uuid");
        }
        this.mMethod = io.dcloud.common.util.JSONUtil.getString(jSONObject, "method");
        this.mPriority = io.dcloud.common.util.JSONUtil.getInt(jSONObject, "priority");
        this.mRetry = io.dcloud.common.util.JSONUtil.getInt(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_RETRY);
        this.mFileSize = io.dcloud.common.util.JSONUtil.getInt(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_DOWNLOADEDSIZE);
        this.mTotalSize = io.dcloud.common.util.JSONUtil.getInt(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TOTALSIZE);
        java.lang.String string3 = io.dcloud.common.util.JSONUtil.getString(jSONObject, "state");
        if (!io.dcloud.common.util.PdrUtil.isEmpty(string3)) {
            try {
                this.mState = java.lang.Integer.parseInt(string3);
            } catch (java.lang.NumberFormatException e) {
                e.printStackTrace();
            }
        }
        this.mConfigFilePath = io.dcloud.common.util.BaseInfo.sDownloadFullPath + this.mUUID + ".download";
        java.io.File file = new java.io.File(this.mConfigFilePath);
        try {
            if (file.exists()) {
                java.lang.String string4 = io.dcloud.common.util.IOUtil.toString(new java.io.FileInputStream(file));
                string4.replace("\n", "");
                java.lang.String[] strArrSplit = string4.split(com.taobao.weex.el.parse.Operators.SUB);
                this.mTotalSize = java.lang.Long.parseLong(strArrSplit[0]);
                this.mState = java.lang.Integer.parseInt(strArrSplit[2]);
                java.io.File file2 = new java.io.File(strArrSplit[3].replace("\n", ""));
                this.mFile = file2;
                if (file2.exists()) {
                    this.mFileSize = this.mFile.length();
                } else {
                    this.mFileSize = 0L;
                }
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        java.lang.String string5 = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_FILENAME);
        if (android.text.TextUtils.isEmpty(string5)) {
            string5 = io.dcloud.common.util.JSONUtil.getString(this.mOptions, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_FILENAME);
        }
        initPath(string5);
        this.mData = io.dcloud.common.util.JSONUtil.getString(jSONObject, "data");
        this.mRetryIntervalTime = io.dcloud.common.util.JSONUtil.getLong(jSONObject, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_RETRY_INTERVAL_TIME) * 1000;
    }

    private void saveDownloadState() {
        if (this.mFileSize < this.mTotalSize) {
            try {
                java.io.File file = new java.io.File(this.mConfigFilePath);
                if (file.exists()) {
                    java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file, false);
                    fileOutputStream.write((this.mTotalSize + com.taobao.weex.el.parse.Operators.SUB + this.mFileSize + com.taobao.weex.el.parse.Operators.SUB + this.mState + com.taobao.weex.el.parse.Operators.SUB + this.mFile.getAbsolutePath()).getBytes());
                    fileOutputStream.close();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean startsWith(java.lang.String str, java.lang.String str2, boolean z) {
        if (str == null || !str.startsWith(str2)) {
            return false;
        }
        if (z) {
            java.lang.String strSubstring = str.substring(str2.length());
            if (strSubstring.length() != 0 && (strSubstring.length() <= 1 || strSubstring.charAt(0) != '/')) {
                return false;
            }
        }
        return true;
    }

    public void abort() {
        try {
            this.mAbort = true;
            io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.net.JsDownload.1
                @Override // java.lang.Runnable
                public void run() {
                    io.dcloud.net.JsDownload.this.mDownloadNetWork.cancelWork();
                    io.dcloud.common.util.net.DownloadMgr.getDownloadMgr().removeTask(io.dcloud.net.JsDownload.this.mDownloadNetWork);
                    io.dcloud.net.JsDownload.this.deleteDownloadData();
                    if (!io.dcloud.common.util.PdrUtil.isEmpty(io.dcloud.net.JsDownload.this.mFileOs)) {
                        try {
                            io.dcloud.net.JsDownload.this.mFileOs.close();
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (io.dcloud.net.JsDownload.this.mFile != null) {
                        io.dcloud.net.JsDownload.this.mFile.delete();
                    }
                    io.dcloud.net.JsDownload jsDownload = io.dcloud.net.JsDownload.this;
                    jsDownload.mWebview = null;
                    jsDownload.mRelWebviews.clear();
                }
            });
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void addRelWebview(io.dcloud.common.DHInterface.IWebview iWebview) {
        if (this.mRelWebviews.contains(iWebview)) {
            return;
        }
        this.mRelWebviews.add(iWebview);
    }

    public void deleteDownloadData() {
        this.mDownloadMgr.deleteDownloadTaskInfo(this.sAppid, this.mUUID);
        new java.io.File(this.mConfigFilePath).delete();
    }

    public java.lang.String getRealPath(java.lang.String str) {
        if (str != null && str.startsWith("/") && !str.toLowerCase(java.util.Locale.ENGLISH).startsWith("/sdcard")) {
            java.lang.String strConvert2AbsFullPath = this.mWebview.obtainApp().convert2AbsFullPath(str.substring(1));
            if (strConvert2AbsFullPath == null || !strConvert2AbsFullPath.contains("/www/")) {
                return strConvert2AbsFullPath;
            }
            return strConvert2AbsFullPath.replace("/www/", "/" + io.dcloud.common.util.BaseInfo.REAL_PUBLIC_DOWNLOADS_DIR);
        }
        if (str != null && str.toLowerCase(java.util.Locale.ENGLISH).startsWith("/sdcard")) {
            return str;
        }
        java.lang.String strConvert2AbsFullPath2 = this.mWebview.obtainApp().convert2AbsFullPath(str);
        if (strConvert2AbsFullPath2 == null || !strConvert2AbsFullPath2.contains("/www/")) {
            return strConvert2AbsFullPath2;
        }
        return strConvert2AbsFullPath2.replace("/www/", "/" + io.dcloud.common.util.BaseInfo.REAL_PUBLIC_DOWNLOADS_DIR);
    }

    @Override // io.dcloud.common.DHInterface.IReqListener
    public void onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState netState, boolean z) {
        java.lang.String string;
        int iLastIndexOf;
        if (this.mPause) {
            return;
        }
        if (netState == io.dcloud.common.DHInterface.IReqListener.NetState.NET_INIT) {
            this.mState = 0;
            this.mDownloadComplete = false;
        } else if (netState == io.dcloud.common.DHInterface.IReqListener.NetState.NET_CONNECTED) {
            this.mState = 2;
        } else if (netState == io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_END) {
            this.mState = 4;
            io.dcloud.common.adapter.util.Logger.d("----NetState.NET_HANDLE_END-----");
            io.dcloud.common.util.net.DownloadMgr.getDownloadMgr().removeTask(this.mDownloadNetWork);
            deleteDownloadData();
            saveInDatabase();
            this.mDownloadComplete = true;
            checkSpecialFile(this.mFileName);
        } else if (netState == io.dcloud.common.DHInterface.IReqListener.NetState.NET_ERROR) {
            this.mState = 4;
            this.mDownloadNetWork.mStatus = com.facebook.common.statfs.StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB;
            io.dcloud.common.adapter.util.Logger.d("----NetState.NET_ERROR-----");
            io.dcloud.common.util.net.DownloadMgr.getDownloadMgr().removeTask(this.mDownloadNetWork);
            if (this.mDownloadComplete) {
                return;
            }
        } else if (netState == io.dcloud.common.DHInterface.IReqListener.NetState.NET_TIMEOUT) {
            this.mState = 4;
            this.mDownloadNetWork.mStatus = 0;
            io.dcloud.common.adapter.util.Logger.d("----NetState.NET_TIMEOUT-----");
            io.dcloud.common.util.net.DownloadMgr.getDownloadMgr().removeTask(this.mDownloadNetWork);
            if (this.mDownloadComplete) {
                return;
            }
        } else if (netState == io.dcloud.common.DHInterface.IReqListener.NetState.NET_REQUEST_BEGIN) {
            try {
                if (this.mFileSize > 0) {
                    this.mDownloadNetWork.mUrlConn.setRequestProperty("Range", "bytes=" + java.lang.String.valueOf(this.mFileSize) + com.taobao.weex.el.parse.Operators.SUB);
                }
                this.mDownloadNetWork.mUrlConn.setRequestMethod(this.mMethod);
                if (this.mMethod.equals("POST")) {
                    this.mDownloadNetWork.mUrlConn.setDoOutput(true);
                    this.mDownloadNetWork.mUrlConn.getOutputStream().write(this.mData.getBytes("utf8"));
                    this.mDownloadNetWork.mUrlConn.getOutputStream().flush();
                    this.mDownloadNetWork.mUrlConn.getOutputStream().close();
                    this.mDownloadNetWork.mUrlConn.setChunkedStreamingMode(0);
                }
                this.mDownloadNetWork.mUrlConn.setConnectTimeout(this.mRequestData.mTimeout);
                this.mDownloadNetWork.mUrlConn.setReadTimeout(this.mRequestData.mTimeout);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        } else if (netState == io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_BEGIN) {
            java.lang.String headerField = this.mDownloadNetWork.mUrlConn.getHeaderField("Content-Length");
            java.lang.String headerField2 = this.mDownloadNetWork.mUrlConn.getHeaderField("Content-Range");
            java.lang.String headerField3 = this.mDownloadNetWork.mUrlConn.getHeaderField(io.dcloud.common.util.net.NetWork.CONTENT_TYPE);
            java.lang.String headerField4 = this.mDownloadNetWork.mUrlConn.getHeaderField(io.dcloud.common.DHInterface.IWebview.SET_COOKIE);
            if (!io.dcloud.common.util.PdrUtil.isEmpty(headerField4)) {
                android.webkit.CookieManager.getInstance().setCookie(this.mRequestData.getUrl(), headerField4);
            }
            if (headerField2 == null) {
                this.mTotalSize = io.dcloud.common.util.PdrUtil.parseLong(headerField, 0L);
                this.mFileSize = 0L;
                this.responseOffset = 0L;
                java.io.File file = this.mFile;
                if (file != null && file.exists()) {
                    this.mFile.delete();
                    new java.io.File(this.mConfigFilePath).delete();
                }
            } else {
                this.append = true;
                try {
                    java.text.MessageFormat messageFormat = new java.text.MessageFormat("bytes {0,number}-{1,number}");
                    messageFormat.setLocale(java.util.Locale.US);
                    long jLongValue = ((java.lang.Number) messageFormat.parse(headerField2)[0]).longValue();
                    this.responseOffset = jLongValue;
                    if (jLongValue < 0) {
                        this.responseOffset = 0L;
                    }
                } catch (java.lang.Exception unused) {
                    this.responseOffset = 0L;
                }
            }
            if (justDirPath()) {
                java.lang.String headerField5 = this.mDownloadNetWork.mUrlConn.getHeaderField("content-disposition");
                try {
                    if (io.dcloud.common.util.PdrUtil.isEmpty(headerField5) && (iLastIndexOf = (string = this.mDownloadNetWork.mUrlConn.getURL().getFile().toString()).lastIndexOf(47)) >= 0) {
                        java.lang.String strSubstring = string.substring(iLastIndexOf + 1);
                        if (strSubstring.indexOf(46) >= 0) {
                            if (strSubstring.contains(com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING)) {
                                strSubstring = strSubstring.substring(0, strSubstring.indexOf(com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING));
                            }
                            this.mFileName += strSubstring;
                        }
                    }
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
                if (justDirPath()) {
                    this.mFileName += io.dcloud.common.util.PdrUtil.getDownloadFilename(headerField5, headerField3, this.mUrl);
                }
            }
            if (this.mDownloadNetWork.isStop) {
                return;
            }
            try {
                this.mFile = createDownloadFile(this.append);
                java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(this.mFile, "rw");
                this.mFileOs = randomAccessFile;
                randomAccessFile.seek(this.responseOffset);
                return;
            } catch (java.io.IOException e3) {
                e3.printStackTrace();
                saveInDatabase();
                return;
            }
        }
        onStateChanged(this.mState);
    }

    @Override // io.dcloud.common.DHInterface.IReqListener
    public int onReceiving(java.io.InputStream inputStream) throws java.lang.Exception {
        byte[] bArr = new byte[10240];
        if (inputStream != null) {
            this.mDownloadNetWork.mTimes = 1;
            boolean z = false;
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    this.mFileOs.close();
                    break;
                }
                if (this.mPause) {
                    onStateChanged(5);
                    return -1;
                }
                this.mFileOs.write(bArr, 0, i);
                this.mFileSize += (long) i;
                onStateChanged(3);
                if (!z) {
                    this.mRealURL = this.mDownloadNetWork.mUrlConn.getURL().toString();
                    saveInDatabase();
                    z = true;
                }
            }
        }
        if (this.mFileSize < this.mTotalSize) {
            throw new java.lang.RuntimeException();
        }
        new java.io.File(this.mConfigFilePath).delete();
        return -1;
    }

    @Override // io.dcloud.common.DHInterface.IResponseListener
    public void onResponseState(int i, java.lang.String str) {
    }

    @Override // io.dcloud.common.DHInterface.IReqListener
    public void onResponsing(java.io.InputStream inputStream) {
        java.lang.String json = toJSON();
        this.mState = 1;
        int size = this.mRelWebviews.size();
        for (int i = 0; i < size; i++) {
            io.dcloud.common.util.Deprecated_JSUtil.excDownloadCallBack(this.mRelWebviews.get(i), json, this.mUUID);
        }
    }

    public void saveInDatabase() {
        this.mDownloadMgr.saveDownloadTaskInfo(this.sAppid, this.mUUID, toSaveJSON());
    }

    public void setRequestHeader(java.lang.String str, java.lang.String str2) {
        this.mRequestData.addHeader(str, str2);
    }

    public void start() {
        this.mDownloadNetWork.mTimes = 1;
        this.mPause = false;
        io.dcloud.common.util.net.DownloadMgr.getDownloadMgr().addQuestTask(this.mDownloadNetWork);
        saveInDatabase();
    }

    java.lang.String toSaveJSON() {
        return io.dcloud.common.util.StringUtil.format("{url: '%s',uuid: '%s',method: '%s',priority: %d,timeout:%d,retry:%d,filename:'%s',downloadedSize:%d,totalSize:%d,state: %d,options:%s,RealURL:'%s'}", this.mUrl, this.mUUID, this.mMethod, java.lang.Integer.valueOf(this.mPriority), java.lang.Integer.valueOf(this.mRequestData.mTimeout), java.lang.Integer.valueOf(this.mRetry), this.mFileName, java.lang.Long.valueOf(this.mFileSize), java.lang.Long.valueOf(this.mTotalSize), java.lang.Integer.valueOf(this.mState), this.mOptions.toString(), this.mRealURL);
    }

    public java.lang.String toJSON() {
        return this.mState == -1000 ? io.dcloud.common.util.StringUtil.format("{status: %d,filename: '%s',uuid: '%s',downloadedSize:%d,totalSize:%d,headers:%s}", java.lang.Integer.valueOf(this.mDownloadNetWork.mStatus), this.mFileName, this.mUUID, java.lang.Long.valueOf(this.mFileSize), java.lang.Long.valueOf(this.mTotalSize), this.mDownloadNetWork.getResponseHeaders()) : io.dcloud.common.util.StringUtil.format("{status: %d,state: %d,filename: '%s',uuid: '%s',downloadedSize:%d,totalSize:%d,headers:%s}", java.lang.Integer.valueOf(this.mDownloadNetWork.mStatus), java.lang.Integer.valueOf(this.mState), this.mFileName, this.mUUID, java.lang.Long.valueOf(this.mFileSize), java.lang.Long.valueOf(this.mTotalSize), this.mDownloadNetWork.getResponseHeaders());
    }
}
