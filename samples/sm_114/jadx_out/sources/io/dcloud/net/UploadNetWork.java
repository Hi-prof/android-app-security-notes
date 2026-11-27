package io.dcloud.net;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class UploadNetWork extends io.dcloud.common.util.net.NetWork {
    public static java.lang.String REQMETHOD_GET = "GET";
    public static java.lang.String REQMETHOD_POST = "POST";
    public static final java.lang.String TAG = "UploadNetWork";
    long RANGE_BUF;
    long mContentLength;
    public int mStatus;
    private boolean mSupport;
    long mTotalSize;
    java.util.LinkedHashMap<java.lang.String, io.dcloud.net.JsUpload.UploadItem> mUploadItems;
    long mUploadedSize;
    java.lang.StringBuffer mUploadingFile;
    java.lang.String responseHeaders;

    public UploadNetWork(int i, io.dcloud.common.util.net.RequestData requestData, io.dcloud.common.DHInterface.IReqListener iReqListener, io.dcloud.common.DHInterface.IResponseListener iResponseListener) {
        super(i, requestData, iReqListener, iResponseListener);
        this.mSupport = false;
        this.mStatus = 0;
        this.mUploadingFile = new java.lang.StringBuffer();
        this.RANGE_BUF = 102400L;
        this.mUploadItems = new java.util.LinkedHashMap<>(4);
    }

    private void addCutoffLine(java.lang.String str) {
        this.mContentLength = appendPostParemeter("--" + str + "\r\n", this.mContentLength);
    }

    private void addFileInputStream(java.lang.String str, io.dcloud.net.JsUpload.UploadFile uploadFile) {
        if (this.mSupport) {
            this.mContentLength = appendPostParemeter("Content-Disposition: attachments; name=\"" + str + "\"; filename=\"" + uploadFile.mFilename + "\"; range=\"0-777/777\"\r\n", this.mContentLength);
        } else {
            this.mContentLength = appendPostParemeter("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + uploadFile.mFilename + "\"\r\n", this.mContentLength);
        }
        long jAppendPostParemeter = appendPostParemeter("Content-Type: " + uploadFile.mMimetype + "\r\n\r\n", this.mContentLength);
        this.mContentLength = jAppendPostParemeter;
        this.mContentLength = appendPostParemeter("\r\n", jAppendPostParemeter) + uploadFile.mFileSize;
    }

    private void addPropertyInputStream(java.lang.String str, java.lang.String str2) {
        this.mContentLength = appendPostParemeter("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n", this.mContentLength);
        this.mContentLength = appendPostParemeter(str2 + "\r\n", this.mContentLength);
    }

    private static boolean isRightRequest(int i) {
        return i >= 200 && i < 300;
    }

    private void uploadContent() {
        this.mTimes = 1;
        connet(true);
        dispose();
    }

    public boolean addFile(java.lang.String str, io.dcloud.net.JsUpload.UploadFile uploadFile) {
        if (this.mUploadItems.containsKey(uploadFile)) {
            return false;
        }
        this.mUploadItems.put(str, uploadFile);
        return true;
    }

    public boolean addParemeter(java.lang.String str, java.lang.String str2) {
        if (this.mUploadItems.containsKey(str)) {
            return false;
        }
        this.mUploadItems.put(str, new io.dcloud.net.JsUpload.UploadString(str2));
        return true;
    }

    public long appendPostParemeter(java.lang.String str, long j) {
        try {
            return ((long) new java.io.ByteArrayInputStream(str.getBytes("utf-8")).available()) + j;
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void connet(boolean z) {
        if (z) {
            try {
                this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_CONNECTED, this.isAbort);
            } catch (java.lang.Exception e) {
                io.dcloud.common.adapter.util.Logger.d("upload is ERROR:" + e.getLocalizedMessage());
                this.mResponseText = e.getMessage();
                this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_ERROR, this.isAbort);
                e.printStackTrace();
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                long j = this.mRetryIntervalTime;
                int i = this.mTimes;
                long j2 = jCurrentTimeMillis + ((j * ((long) (1 << i))) / 2);
                if (i < this.MAX_TIMES) {
                    this.mTimes = i + 1;
                    while (java.lang.System.currentTimeMillis() <= j2) {
                    }
                    connet(z);
                    return;
                }
                return;
            }
        }
        initUploadData();
        this.responseHeaders = getResponseHeaders();
    }

    @Override // io.dcloud.common.util.net.NetWork
    public void dispose() {
        this.mHeaderList = null;
        this.mRequest = null;
        this.mUploadedSize = 0L;
        this.mTotalSize = 0L;
        io.dcloud.common.util.net.UploadMgr.getUploadMgr().removeNetWork(this);
    }

    public java.lang.String getResponseHeaders() {
        try {
            java.net.HttpURLConnection httpURLConnection = this.mRequest;
            if (httpURLConnection == null) {
                return "";
            }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> headerFields = httpURLConnection.getHeaderFields();
            java.util.HashMap map = new java.util.HashMap();
            for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : headerFields.entrySet()) {
                java.util.Iterator<java.lang.String> it = entry.getValue().iterator();
                java.lang.String str = "";
                while (it.hasNext()) {
                    str = str + "  " + it.next();
                }
                if (!io.dcloud.common.util.PdrUtil.isEmpty(entry.getKey())) {
                    map.put(entry.getKey(), str);
                }
            }
            return new org.json.JSONObject(map).toString();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }

    public void initContentLength() {
        this.mContentLength = 0L;
        java.util.LinkedHashMap<java.lang.String, io.dcloud.net.JsUpload.UploadItem> linkedHashMap = this.mUploadItems;
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            for (java.lang.String str : this.mUploadItems.keySet()) {
                io.dcloud.net.JsUpload.UploadItem uploadItem = this.mUploadItems.get(str);
                if (uploadItem instanceof io.dcloud.net.JsUpload.UploadFile) {
                    this.mUploadingFile.append(str);
                    addCutoffLine(this.mMainBoundry);
                    addFileInputStream(str, (io.dcloud.net.JsUpload.UploadFile) uploadItem);
                } else if (uploadItem instanceof io.dcloud.net.JsUpload.UploadString) {
                    addCutoffLine(this.mMainBoundry);
                    addPropertyInputStream(str, ((io.dcloud.net.JsUpload.UploadString) uploadItem).mData);
                }
            }
        }
        this.mContentLength = appendPostParemeter("--" + this.mMainBoundry + "--\r\n", this.mContentLength);
    }

    public void responseUpload() {
        try {
            java.net.HttpURLConnection httpURLConnection = this.mRequest;
            if (httpURLConnection != null) {
                this.mStatus = httpURLConnection.getResponseCode();
            }
            java.lang.String headerField = this.mRequest.getHeaderField(io.dcloud.common.DHInterface.IWebview.SET_COOKIE);
            if (!android.text.TextUtils.isEmpty(headerField)) {
                android.webkit.CookieManager.getInstance().setCookie(this.mRequestData.getUrl(), headerField);
            }
            java.io.InputStream errorStream = this.mStatus > 400 ? this.mRequest.getErrorStream() : this.mRequest.getInputStream();
            byte[] bArr = new byte[1024];
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            while (true) {
                int i = errorStream.read(bArr);
                if (i <= 0) {
                    break;
                } else {
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            }
            java.lang.String str = new java.lang.String(byteArrayOutputStream.toByteArray(), "utf-8");
            this.mResponseText = str;
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                io.dcloud.common.util.JSONUtil.getString(jSONObject, "result");
                io.dcloud.common.util.JSONUtil.getString(jSONObject, "code");
                io.dcloud.common.util.JSONUtil.getString(jSONObject, "message");
            } catch (java.lang.Exception unused) {
                io.dcloud.common.adapter.util.Logger.e("uploadnetwork", "responseUpload JSONObject _data=" + str + ";url=" + this.mRequestData.getUrl());
            }
            if (isRightRequest(this.mStatus)) {
                this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_ING, this.isAbort);
                this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_END, this.isAbort);
            } else {
                this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_ERROR, this.isAbort);
            }
            byteArrayOutputStream.close();
            errorStream.close();
        } catch (java.lang.Exception e) {
            io.dcloud.common.adapter.util.Logger.e("uploadnetwork", "responseUpload " + e.getLocalizedMessage() + ";url=" + this.mRequestData.getUrl());
            this.mResponseText = e.getMessage();
            this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_ERROR, this.isAbort);
        }
    }

    @Override // io.dcloud.common.util.net.NetWork, java.lang.Runnable
    public void run() {
        uploadContent();
    }

    private void initUploadData() throws java.lang.Exception {
        int i;
        java.io.DataOutputStream dataOutputStream;
        java.lang.String str = this.mMainBoundry;
        java.net.HttpURLConnection httpRequest = this.mRequestData.getHttpRequest();
        this.mRequest = httpRequest;
        if (httpRequest == null) {
            new java.lang.Exception("url error");
        }
        initHttpsURLConnectionVel();
        this.mRequest.setDoOutput(true);
        this.mRequest.setDoInput(true);
        this.mRequest.setRequestProperty("Connection", "Keep-Alive");
        this.mRequest.setRequestProperty("Charset", "UTF-8");
        this.mRequest.setRequestProperty(io.dcloud.common.util.net.NetWork.CONTENT_TYPE, "multipart/form-data; boundary=" + str);
        int i2 = 0;
        this.mRequest.setUseCaches(false);
        initContentLength();
        int i3 = this.mRequestData.mChunkSize;
        if (i3 > 0) {
            i = i3 * 1024;
            this.mRequest.setChunkedStreamingMode(i);
        } else {
            this.mRequest.setFixedLengthStreamingMode(this.mContentLength);
            i = 10240;
        }
        java.io.DataOutputStream dataOutputStream2 = new java.io.DataOutputStream(this.mRequest.getOutputStream());
        this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_REQUEST_BEGIN, this.isAbort);
        java.util.LinkedHashMap<java.lang.String, io.dcloud.net.JsUpload.UploadItem> linkedHashMap = this.mUploadItems;
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            java.util.Set<java.lang.String> setKeySet = this.mUploadItems.keySet();
            this.mTotalSize = this.mContentLength;
            for (java.lang.String str2 : setKeySet) {
                io.dcloud.net.JsUpload.UploadItem uploadItem = this.mUploadItems.get(str2);
                dataOutputStream2.writeBytes("--" + str + "\r\n");
                if (uploadItem instanceof io.dcloud.net.JsUpload.UploadFile) {
                    io.dcloud.net.JsUpload.UploadFile uploadFile = (io.dcloud.net.JsUpload.UploadFile) uploadItem;
                    java.io.InputStream inputStream = uploadFile.mFileInputS;
                    if (inputStream != null) {
                        this.mUploadingFile.append(str2);
                        dataOutputStream2.write(("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + uploadFile.mFilename + "\"\r\n").getBytes());
                        java.lang.StringBuilder sb = new java.lang.StringBuilder("Content-Type: ");
                        sb.append(uploadFile.mMimetype);
                        sb.append("\r\n");
                        dataOutputStream2.write(sb.toString().getBytes());
                        dataOutputStream2.writeBytes("\r\n");
                        int iMin = java.lang.Math.min(inputStream.available(), i);
                        byte[] bArr = new byte[iMin];
                        int i4 = inputStream.read(bArr, i2, iMin);
                        long j = 0;
                        while (i4 > 0) {
                            j += (long) i4;
                            this.mUploadedSize = j;
                            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("initUploadData: mUploadedSize==");
                            java.io.DataOutputStream dataOutputStream3 = dataOutputStream2;
                            sb2.append(this.mUploadedSize);
                            sb2.append(" ===== length =");
                            sb2.append(i4);
                            sb2.append(" ====== buffer =");
                            sb2.append(iMin);
                            android.util.Log.e("UploadNetWort", sb2.toString());
                            dataOutputStream3.write(bArr, 0, i4);
                            this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_ING, this.isAbort);
                            i4 = inputStream.read(bArr, 0, java.lang.Math.min(inputStream.available(), i));
                            dataOutputStream2 = dataOutputStream3;
                        }
                        dataOutputStream = dataOutputStream2;
                        dataOutputStream.writeBytes("\r\n");
                        inputStream.close();
                    }
                } else {
                    dataOutputStream = dataOutputStream2;
                    if (uploadItem instanceof io.dcloud.net.JsUpload.UploadString) {
                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                        sb3.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n");
                        sb3.append("\r\n");
                        sb3.append(((io.dcloud.net.JsUpload.UploadString) uploadItem).mData);
                        sb3.append("\r\n");
                        dataOutputStream.write(sb3.toString().getBytes());
                        sb3.delete(0, sb3.length());
                    }
                    this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_ING, this.isAbort);
                    dataOutputStream2 = dataOutputStream;
                    i2 = 0;
                }
                this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_ING, this.isAbort);
                dataOutputStream2 = dataOutputStream;
                i2 = 0;
            }
        }
        java.io.DataOutputStream dataOutputStream4 = dataOutputStream2;
        dataOutputStream4.writeBytes("--" + str + "--\r\n");
        this.mUploadedSize = (long) dataOutputStream4.size();
        dataOutputStream4.flush();
        responseUpload();
        dataOutputStream4.close();
    }
}
