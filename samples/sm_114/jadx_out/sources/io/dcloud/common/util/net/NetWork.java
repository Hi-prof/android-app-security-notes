package io.dcloud.common.util.net;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class NetWork implements java.lang.Runnable {
    public static long AUTO_RECONNECTTIME = 30000;
    public static final java.lang.String CONTENT_TYPE = "Content-Type";
    private static final java.lang.String CONTENT_TYPE_COMMON = "text/plain;charset=utf-8";
    private static final java.lang.String CONTENT_TYPE_UPLOAD = "application/x-www-form-urlencoded";
    private static final java.lang.String DEFALUT_CHARSET = "utf-8";
    private static final java.lang.String PARAM_CHARSET = ";charset=";
    public static final int WORK_COMMON = 3;
    public static final int WORK_DOWNLOAD = 2;
    public static final int WORK_UPLOAD = 1;
    protected boolean isAbort;
    public int mPriority;
    protected io.dcloud.common.DHInterface.IReqListener mReqListener;
    protected java.net.HttpURLConnection mRequest;
    protected io.dcloud.common.util.net.RequestData mRequestData;
    protected java.io.InputStream mResponseInput;
    protected io.dcloud.common.DHInterface.IResponseListener mResponseListener;
    protected java.lang.String mResponseText;
    private int mWorkType;
    io.dcloud.common.util.net.NetWorkLoop mNetWorkLoop = null;
    public int mTimes = 1;
    public int MAX_TIMES = 3;
    protected long mRetryIntervalTime = AUTO_RECONNECTTIME;
    protected java.util.Map<java.lang.String, java.lang.String> mHeaderList = new java.util.HashMap();
    protected java.lang.String mMainBoundry = getBoundry();

    public NetWork(int i, io.dcloud.common.util.net.RequestData requestData, io.dcloud.common.DHInterface.IReqListener iReqListener, io.dcloud.common.DHInterface.IResponseListener iResponseListener) {
        this.mWorkType = i;
        this.mRequestData = requestData;
        this.mReqListener = iReqListener;
        this.mResponseListener = iResponseListener;
    }

    public static java.lang.String getBoundry() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("------");
        for (int i = 1; i < 7; i++) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis() + ((long) i);
            long j = jCurrentTimeMillis % 3;
            if (j == 0) {
                stringBuffer.append(((char) jCurrentTimeMillis) % '\t');
            } else if (j == 1) {
                stringBuffer.append((char) ((jCurrentTimeMillis % 26) + 65));
            } else {
                stringBuffer.append((char) ((jCurrentTimeMillis % 26) + 97));
            }
        }
        return stringBuffer.toString();
    }

    private java.lang.String getCharset(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.String strReplace = str.replace(com.taobao.weex.el.parse.Operators.SPACE_STR, "");
        if (strReplace.contains(PARAM_CHARSET)) {
            return strReplace.substring(strReplace.indexOf(PARAM_CHARSET) + 9);
        }
        return null;
    }

    private void setHeadersAndValues(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        if (map == null) {
            return;
        }
        for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : map.entrySet()) {
            if (!io.dcloud.common.util.PdrUtil.isEmpty(entry.getValue())) {
                java.lang.String str = "";
                for (int i = 0; i < entry.getValue().size(); i++) {
                    str = i == 0 ? entry.getValue().get(i) : str + "  " + entry.getValue().get(i);
                }
                if (!io.dcloud.common.util.PdrUtil.isEmpty(entry.getKey())) {
                    this.mHeaderList.put(entry.getKey(), str);
                }
            }
        }
    }

    public void cancelWork() {
        this.isAbort = true;
        java.net.HttpURLConnection httpURLConnection = this.mRequest;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.mRequest = null;
        }
    }

    public void dispose() {
        this.mReqListener = null;
        this.mResponseListener = null;
    }

    public java.util.Map<java.lang.String, java.lang.String> getHeadersAndValues() {
        return this.mHeaderList;
    }

    public java.io.InputStream getResponseInput() {
        return this.mResponseInput;
    }

    public java.lang.String getResponseText() {
        return this.mResponseText;
    }

    public void handleResponseText(java.io.InputStream inputStream) throws java.io.IOException {
        try {
            java.lang.String charset = getCharset(this.mRequestData.mOverrideMimeType);
            if (charset == null) {
                charset = getCharset(this.mRequest.getContentType());
            }
            if (charset == null) {
                charset = DEFALUT_CHARSET;
            }
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            int i = 10240;
            int iMin = java.lang.Math.min(10240, inputStream.available());
            if (iMin > 0) {
                i = iMin;
            }
            byte[] bArr = new byte[i];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 <= 0) {
                    inputStream.close();
                    this.mResponseText = new java.lang.String(byteArrayOutputStream.toByteArray(), charset);
                    return;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            this.mResponseText = "";
        }
    }

    public void initHttpsURLConnectionVel() {
        java.net.HttpURLConnection httpURLConnection = this.mRequest;
        if (httpURLConnection != null) {
            if (httpURLConnection instanceof javax.net.ssl.HttpsURLConnection) {
                try {
                    javax.net.ssl.SSLSocketFactory sSLSocketFactory = io.dcloud.common.adapter.util.DCloudTrustManager.getSSLSocketFactory();
                    if (sSLSocketFactory != null) {
                        ((javax.net.ssl.HttpsURLConnection) this.mRequest).setSSLSocketFactory(sSLSocketFactory);
                    }
                    ((javax.net.ssl.HttpsURLConnection) this.mRequest).setHostnameVerifier(io.dcloud.common.util.NetTool.getDefaultHostnameVerifier());
                } catch (java.lang.Exception e) {
                    throw new java.lang.RuntimeException(e);
                }
            }
            this.mRequest.setConnectTimeout(this.mRequestData.mTimeout);
            this.mRequest.setReadTimeout(this.mRequestData.mTimeout);
            this.mRequest.setInstanceFollowRedirects(true);
            this.mRequest.setDoInput(true);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            java.net.HttpURLConnection httpRequest = this.mRequestData.getHttpRequest();
            this.mRequest = httpRequest;
            if (httpRequest == null) {
                this.mResponseListener.onResponseState(-1, "url error");
                this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_ING, this.isAbort);
                this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_ERROR, this.isAbort);
                io.dcloud.common.util.net.NetWorkLoop netWorkLoop = this.mNetWorkLoop;
                if (netWorkLoop != null) {
                    netWorkLoop.removeNetWork(this);
                    return;
                }
                return;
            }
            if (!this.mRequestData.containHeader(CONTENT_TYPE)) {
                try {
                    int i = this.mWorkType;
                    if (i == 1) {
                        this.mRequest.setRequestProperty(CONTENT_TYPE, CONTENT_TYPE_UPLOAD);
                    } else if (i != 2) {
                        this.mRequest.setRequestProperty(CONTENT_TYPE, CONTENT_TYPE_COMMON);
                    }
                } catch (java.lang.Exception unused) {
                }
            }
            try {
                initHttpsURLConnectionVel();
                if (!this.mRequestData.isRedirect) {
                    this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_REQUEST_BEGIN, this.isAbort);
                }
                this.mRequestData.addBody(this.mRequest);
                if (!this.mRequestData.isRedirect) {
                    this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_BEGIN, this.isAbort);
                }
                int responseCode = this.mRequest.getResponseCode();
                java.lang.String responseMessage = this.mRequest.getResponseMessage();
                this.mResponseListener.onResponseState(responseCode, responseMessage);
                switch (responseCode) {
                    case 200:
                    case com.dmcbig.mediapicker.PickerConfig.CODE_PICKER_CROP /* 201 */:
                    case 202:
                    case 203:
                    case 204:
                    case 205:
                    case 206:
                        setHeadersAndValues(this.mRequest.getHeaderFields());
                        io.dcloud.common.DHInterface.IReqListener iReqListener = this.mReqListener;
                        io.dcloud.common.DHInterface.IReqListener.NetState netState = io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_ING;
                        iReqListener.onNetStateChanged(netState, this.isAbort);
                        if (this.mWorkType == 2) {
                            java.io.InputStream inputStream = this.mRequest.getInputStream();
                            this.mResponseInput = inputStream;
                            this.mReqListener.onResponsing(inputStream);
                        } else if (this.mRequest.getInputStream() != null) {
                            handleResponseText(this.mRequest.getInputStream());
                            if (io.dcloud.common.util.PdrUtil.isEmpty(this.mResponseText)) {
                                this.mResponseText = responseCode + com.taobao.weex.el.parse.Operators.SPACE_STR + responseMessage;
                            }
                        } else {
                            this.mResponseText = responseCode + com.taobao.weex.el.parse.Operators.SPACE_STR + responseMessage;
                        }
                        this.mReqListener.onNetStateChanged(netState, this.isAbort);
                        break;
                    default:
                        switch (responseCode) {
                            case 301:
                            case 302:
                            case 303:
                                java.lang.String headerField = this.mRequest.getHeaderField("Location");
                                if (!android.text.TextUtils.isEmpty(headerField)) {
                                    java.lang.System.out.println("重定向的URL:" + headerField);
                                    java.lang.String strReplace = headerField.replace(com.taobao.weex.el.parse.Operators.SPACE_STR, "%20");
                                    this.mRequestData.clearData();
                                    this.mRequestData.setUrl(strReplace);
                                    run();
                                    return;
                                }
                                break;
                            default:
                                setHeadersAndValues(this.mRequest.getHeaderFields());
                                io.dcloud.common.DHInterface.IReqListener iReqListener2 = this.mReqListener;
                                io.dcloud.common.DHInterface.IReqListener.NetState netState2 = io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_ING;
                                iReqListener2.onNetStateChanged(netState2, this.isAbort);
                                handleResponseText(this.mRequest.getErrorStream());
                                this.mReqListener.onNetStateChanged(netState2, this.isAbort);
                                break;
                        }
                        break;
                }
                this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_END, this.isAbort);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                this.mResponseListener.onResponseState(0, e.getMessage());
                this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_ING, this.isAbort);
                if (e instanceof java.net.SocketTimeoutException) {
                    this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_TIMEOUT, this.isAbort);
                } else {
                    this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_ERROR, this.isAbort);
                }
            }
            io.dcloud.common.util.net.NetWorkLoop netWorkLoop2 = this.mNetWorkLoop;
            if (netWorkLoop2 != null) {
                netWorkLoop2.removeNetWork(this);
            }
        } catch (java.lang.IllegalArgumentException e2) {
            this.mResponseListener.onResponseState(-1, e2.getMessage());
            this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_ING, this.isAbort);
            this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_ERROR, this.isAbort);
            io.dcloud.common.util.net.NetWorkLoop netWorkLoop3 = this.mNetWorkLoop;
            if (netWorkLoop3 != null) {
                netWorkLoop3.removeNetWork(this);
            }
        }
    }

    public void setRetryIntervalTime(long j) {
        if (j > 0) {
            this.mRetryIntervalTime = j;
        }
    }

    public void startWork() {
        java.lang.Thread thread = new java.lang.Thread(this);
        thread.setPriority(1);
        thread.start();
        this.mReqListener.onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState.NET_INIT, this.isAbort);
    }
}
