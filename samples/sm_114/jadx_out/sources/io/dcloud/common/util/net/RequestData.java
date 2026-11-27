package io.dcloud.common.util.net;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class RequestData {
    public static final java.lang.String URL_HTTP = "http";
    public static final java.lang.String URL_HTTPS = "https";
    public java.lang.String URL_METHOD;
    private java.lang.String mBody;
    public int mChunkSize;
    private long mContentLength;
    private java.util.HashMap<java.lang.String, java.lang.String> mHeads;
    private java.net.HttpURLConnection mHttpRequest;
    private java.lang.String mIp;
    private java.util.HashMap<java.lang.String, java.lang.String> mNameValue;
    private java.lang.String mPort;
    private java.lang.String mReqmethod;
    private java.lang.String mUrl;
    public java.lang.String unTrustedCAType = "accept";
    public boolean isRedirect = false;
    public int mTimeout = 120000;
    public java.lang.String mOverrideMimeType = null;

    /* JADX INFO: renamed from: io.dcloud.common.util.net.RequestData$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$dcloud$common$util$net$RequestData$HttpOption;

        static {
            int[] iArr = new int[io.dcloud.common.util.net.RequestData.HttpOption.values().length];
            $SwitchMap$io$dcloud$common$util$net$RequestData$HttpOption = iArr;
            try {
                iArr[io.dcloud.common.util.net.RequestData.HttpOption.POST.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$dcloud$common$util$net$RequestData$HttpOption[io.dcloud.common.util.net.RequestData.HttpOption.PUT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$dcloud$common$util$net$RequestData$HttpOption[io.dcloud.common.util.net.RequestData.HttpOption.DELETE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$dcloud$common$util$net$RequestData$HttpOption[io.dcloud.common.util.net.RequestData.HttpOption.HEAD.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$dcloud$common$util$net$RequestData$HttpOption[io.dcloud.common.util.net.RequestData.HttpOption.TRACE.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$dcloud$common$util$net$RequestData$HttpOption[io.dcloud.common.util.net.RequestData.HttpOption.OPTIONS.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$dcloud$common$util$net$RequestData$HttpOption[io.dcloud.common.util.net.RequestData.HttpOption.GET.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    enum HttpOption {
        GET,
        POST,
        PUT,
        DELETE,
        HEAD,
        TRACE,
        OPTIONS
    }

    public RequestData(java.lang.String str, java.lang.String str2) {
        this.URL_METHOD = "http";
        this.mUrl = str;
        this.mReqmethod = str2;
        if (str != null && str.startsWith("https")) {
            this.URL_METHOD = "https";
        }
        this.mNameValue = new java.util.HashMap<>();
        this.mHeads = new java.util.HashMap<>();
    }

    public boolean addBody(java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            return false;
        }
        this.mBody = str;
        return true;
    }

    public boolean addHeader(java.lang.String str, java.lang.String str2) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str) || io.dcloud.common.util.PdrUtil.isEmpty(str2) || this.mHeads.containsKey(str)) {
            return false;
        }
        this.mHeads.put(str, str2);
        return true;
    }

    public boolean addParemeter(java.lang.String str, java.lang.String str2) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str) || io.dcloud.common.util.PdrUtil.isEmpty(str2) || this.mNameValue.containsKey(str)) {
            return false;
        }
        this.mNameValue.put(str, str2);
        return true;
    }

    public void clearData() {
        this.mHttpRequest.disconnect();
        this.mHttpRequest = null;
    }

    public boolean containHeader(java.lang.String str) {
        if (str != null && this.mHeads != null && str.equals(io.dcloud.common.util.net.NetWork.CONTENT_TYPE)) {
            java.util.Iterator<java.lang.String> it = this.mHeads.keySet().iterator();
            while (it.hasNext()) {
                if (it.next().equalsIgnoreCase(io.dcloud.common.util.net.NetWork.CONTENT_TYPE)) {
                    return true;
                }
            }
        }
        java.util.HashMap<java.lang.String, java.lang.String> map = this.mHeads;
        if (map != null) {
            return map.containsKey(str);
        }
        return false;
    }

    public java.net.HttpURLConnection getHttpRequest() throws java.lang.IllegalArgumentException {
        if (this.mHttpRequest == null) {
            io.dcloud.common.util.net.RequestData.HttpOption httpOptionValueOf = io.dcloud.common.util.net.RequestData.HttpOption.valueOf(this.mReqmethod.toUpperCase());
            try {
                java.net.URLConnection uRLConnectionOpenConnection = new java.net.URL(this.mUrl).openConnection();
                if (!(uRLConnectionOpenConnection instanceof java.net.HttpURLConnection)) {
                    return null;
                }
                this.mHttpRequest = (java.net.HttpURLConnection) uRLConnectionOpenConnection;
                switch (io.dcloud.common.util.net.RequestData.AnonymousClass1.$SwitchMap$io$dcloud$common$util$net$RequestData$HttpOption[httpOptionValueOf.ordinal()]) {
                    case 1:
                        this.mHttpRequest.setRequestMethod("POST");
                        break;
                    case 2:
                        this.mHttpRequest.setRequestMethod("PUT");
                        break;
                    case 3:
                        this.mHttpRequest.setRequestMethod("DELETE");
                        break;
                    case 4:
                        this.mHttpRequest.setRequestMethod("HEAD");
                        break;
                    case 5:
                        this.mHttpRequest.setRequestMethod("TRACE");
                        break;
                    case 6:
                        this.mHttpRequest.setRequestMethod("OPTIONS");
                        break;
                    default:
                        this.mHttpRequest.setRequestMethod("GET");
                        break;
                }
            } catch (java.net.MalformedURLException e) {
                e.printStackTrace();
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
            } catch (java.lang.IllegalArgumentException e3) {
                throw e3;
            }
            addHeader(this.mHttpRequest);
        }
        return this.mHttpRequest;
    }

    public java.lang.String getIP() {
        return this.mIp;
    }

    public java.lang.String getPort() {
        return this.mPort;
    }

    public java.lang.String getReqmethod() {
        return this.mReqmethod;
    }

    public java.lang.String getUrl() {
        return this.mUrl;
    }

    public void setReqmethod(java.lang.String str) {
        this.mReqmethod = str;
    }

    public void setUrl(java.lang.String str) {
        this.mUrl = str;
    }

    public void addBody(java.net.HttpURLConnection httpURLConnection) {
        if (android.text.TextUtils.isEmpty(this.mBody)) {
            return;
        }
        try {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            java.io.OutputStream outputStream = httpURLConnection.getOutputStream();
            java.lang.String str = this.mBody;
            if (str == null || str.length() <= 0) {
                return;
            }
            outputStream.write(this.mBody.getBytes("UTF-8"));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void addHeader(java.net.HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        for (java.lang.String str : this.mHeads.keySet()) {
            httpURLConnection.addRequestProperty(str, this.mHeads.get(str));
        }
    }
}
