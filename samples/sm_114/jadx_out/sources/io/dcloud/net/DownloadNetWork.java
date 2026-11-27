package io.dcloud.net;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DownloadNetWork extends io.dcloud.common.util.net.NetWork {
    protected boolean isStop;
    public long mContentLength;
    private java.lang.Thread mExecSyncTask;
    public java.util.Map<java.lang.String, java.lang.String> mResponseHeaders;
    public int mRetry;
    public int mStatus;
    private java.lang.String mUrl;
    public java.net.HttpURLConnection mUrlConn;

    public DownloadNetWork(int i, io.dcloud.common.util.net.RequestData requestData, io.dcloud.common.DHInterface.IReqListener iReqListener, io.dcloud.common.DHInterface.IResponseListener iResponseListener) {
        super(i, requestData, iReqListener, iResponseListener);
        this.mStatus = 0;
        this.mRetry = 0;
        this.mUrlConn = null;
        this.isStop = false;
        this.mUrl = requestData.getUrl();
    }

    public static java.util.Map<java.lang.String, java.lang.String> getHttpResponseHeader(java.net.HttpURLConnection httpURLConnection) throws java.io.UnsupportedEncodingException {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        int i = 0;
        while (true) {
            java.lang.String headerField = httpURLConnection.getHeaderField(i);
            if (headerField == null) {
                return linkedHashMap;
            }
            linkedHashMap.put(httpURLConnection.getHeaderFieldKey(i), headerField);
            i++;
        }
    }

    private void initUploadData() {
        try {
            java.net.URL url = new java.net.URL(this.mUrl);
            io.dcloud.common.adapter.util.Logger.d("httpreq", "request mUrl=" + this.mUrl);
            onStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_INIT);
            connect(url);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            onStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_ERROR);
        }
    }

    private void response(java.io.InputStream inputStream) throws java.lang.Exception {
        onStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_BEGIN);
        onReceiveing(inputStream);
        if (this.isStop) {
            return;
        }
        onStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_ING);
        onStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_END);
    }

    private void setHeaders() {
        this.mRequestData.addHeader(this.mUrlConn);
    }

    @Override // io.dcloud.common.util.net.NetWork
    public void cancelWork() {
        java.net.HttpURLConnection httpURLConnection = this.mUrlConn;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            this.mUrlConn = null;
        }
    }

    public void connect(java.net.URL url) {
        try {
            this.mUrlConn = (java.net.HttpURLConnection) url.openConnection();
            setHeaders();
            if (!io.dcloud.common.util.PdrUtil.isEquals(this.mRequestData.unTrustedCAType, "refuse") && !io.dcloud.common.util.PdrUtil.isEquals(this.mRequestData.unTrustedCAType, "warning") && (this.mUrlConn instanceof javax.net.ssl.HttpsURLConnection)) {
                try {
                    javax.net.ssl.SSLSocketFactory sSLSocketFactory = io.dcloud.common.adapter.util.DCloudTrustManager.getSSLSocketFactory();
                    if (sSLSocketFactory != null) {
                        ((javax.net.ssl.HttpsURLConnection) this.mUrlConn).setSSLSocketFactory(sSLSocketFactory);
                    }
                    ((javax.net.ssl.HttpsURLConnection) this.mUrlConn).setHostnameVerifier(io.dcloud.common.adapter.util.DCloudTrustManager.getHostnameVerifier(false));
                } catch (java.lang.Exception e) {
                    throw new java.lang.RuntimeException(e);
                }
            }
            onStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_REQUEST_BEGIN);
            if (this.isStop) {
                return;
            }
            int responseCode = this.mUrlConn.getResponseCode();
            this.mStatus = responseCode;
            if (responseCode == 206) {
                this.mStatus = 200;
            }
            int i = this.mStatus;
            if (i == 302 || i == 301) {
                java.lang.String headerField = this.mUrlConn.getHeaderField("Location");
                if (!headerField.equals(url.toString())) {
                    connect(new java.net.URL(headerField));
                    return;
                }
            }
            onStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_CONNECTED);
            java.io.InputStream inputStream = this.mUrlConn.getInputStream();
            this.mResponseHeaders = getHttpResponseHeader(this.mUrlConn);
            response(inputStream);
        } catch (java.lang.Throwable th) {
            if (this.isStop) {
                return;
            }
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            long j = this.mRetryIntervalTime;
            int i2 = this.mTimes;
            long j2 = jCurrentTimeMillis + ((j * ((long) (1 << i2))) / 2);
            if (i2 <= this.MAX_TIMES) {
                while (java.lang.System.currentTimeMillis() <= j2) {
                }
                this.mTimes++;
                try {
                    this.mUrlConn.disconnect();
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
                connect(url);
                return;
            }
            if (th instanceof java.net.SocketTimeoutException) {
                onStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_TIMEOUT);
                return;
            }
            if (!this.isStop) {
                onStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_ERROR);
                return;
            }
            io.dcloud.common.DHInterface.IReqListener iReqListener = this.mReqListener;
            if (iReqListener instanceof io.dcloud.net.JsDownload) {
                ((io.dcloud.net.JsDownload) iReqListener).saveInDatabase();
            }
        }
    }

    @Override // io.dcloud.common.util.net.NetWork
    public void dispose() {
        this.mTimes = 4;
        this.isStop = true;
        this.mReqListener = null;
        try {
            java.net.HttpURLConnection httpURLConnection = this.mUrlConn;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public java.lang.String getResponseHeader(java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.String> map = this.mResponseHeaders;
        if (map == null) {
            return "''";
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            if (str.equalsIgnoreCase(entry.getKey().trim())) {
                return entry.getValue();
            }
        }
        return "''";
    }

    public java.lang.String getResponseHeaders() {
        java.util.Map<java.lang.String, java.lang.String> map = this.mResponseHeaders;
        if (map == null || map.size() <= 0) {
            return "{}";
        }
        try {
            return new org.json.JSONObject(this.mResponseHeaders).toString();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }

    public int onReceiveing(java.io.InputStream inputStream) throws java.lang.Exception {
        io.dcloud.common.DHInterface.IReqListener iReqListener = this.mReqListener;
        if (iReqListener != null) {
            return iReqListener.onReceiving(inputStream);
        }
        return 0;
    }

    public void onResponsing(java.io.OutputStream outputStream) {
    }

    public void onStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState netState) {
        io.dcloud.common.DHInterface.IReqListener iReqListener = this.mReqListener;
        if (iReqListener != null) {
            iReqListener.onNetStateChanged(netState, this.isAbort);
        }
    }

    @Override // io.dcloud.common.util.net.NetWork, java.lang.Runnable
    public void run() {
        initUploadData();
    }
}
