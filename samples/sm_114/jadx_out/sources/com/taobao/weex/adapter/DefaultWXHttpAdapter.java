package com.taobao.weex.adapter;

/* JADX INFO: loaded from: classes.dex */
public class DefaultWXHttpAdapter implements com.taobao.weex.adapter.IWXHttpAdapter {
    private static final com.taobao.weex.adapter.DefaultWXHttpAdapter.IEventReporterDelegate DEFAULT_DELEGATE = new com.taobao.weex.adapter.DefaultWXHttpAdapter.NOPEventReportDelegate();
    private java.util.concurrent.ExecutorService mExecutorService;

    public interface IEventReporterDelegate {
        void httpExchangeFailed(java.io.IOException iOException);

        java.io.InputStream interpretResponseStream(java.io.InputStream inputStream);

        void postConnect();

        void preConnect(java.net.HttpURLConnection httpURLConnection, java.lang.String str);
    }

    private void execute(java.lang.Runnable runnable) {
        if (this.mExecutorService == null) {
            this.mExecutorService = java.util.concurrent.Executors.newFixedThreadPool(3);
        }
        this.mExecutorService.execute(runnable);
    }

    @Override // com.taobao.weex.adapter.IWXHttpAdapter
    public void sendRequest(final com.taobao.weex.common.WXRequest wXRequest, final com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener onHttpListener) {
        if (onHttpListener != null) {
            onHttpListener.onHttpStart();
        }
        execute(new java.lang.Runnable() { // from class: com.taobao.weex.adapter.DefaultWXHttpAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                com.taobao.weex.WXSDKInstance wXSDKInstance = com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().get(wXRequest.instanceId);
                if (wXSDKInstance != null && !wXSDKInstance.isDestroy()) {
                    wXSDKInstance.getApmForInstance().actionNetRequest();
                }
                com.taobao.weex.common.WXResponse wXResponse = new com.taobao.weex.common.WXResponse();
                com.taobao.weex.adapter.DefaultWXHttpAdapter.IEventReporterDelegate eventReporterDelegate = com.taobao.weex.adapter.DefaultWXHttpAdapter.this.getEventReporterDelegate();
                boolean z2 = false;
                try {
                    java.net.HttpURLConnection httpURLConnectionOpenConnection = com.taobao.weex.adapter.DefaultWXHttpAdapter.this.openConnection(wXRequest, onHttpListener);
                    eventReporterDelegate.preConnect(httpURLConnectionOpenConnection, wXRequest.body);
                    java.util.Map<java.lang.String, java.util.List<java.lang.String>> headerFields = httpURLConnectionOpenConnection.getHeaderFields();
                    int responseCode = httpURLConnectionOpenConnection.getResponseCode();
                    com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener onHttpListener2 = onHttpListener;
                    if (onHttpListener2 != null) {
                        onHttpListener2.onHeadersReceived(responseCode, headerFields);
                    }
                    eventReporterDelegate.postConnect();
                    wXResponse.statusCode = java.lang.String.valueOf(responseCode);
                    if (responseCode < 200 || responseCode > 299) {
                        wXResponse.errorMsg = com.taobao.weex.adapter.DefaultWXHttpAdapter.this.readInputStream(httpURLConnectionOpenConnection.getErrorStream(), onHttpListener);
                        z = false;
                    } else {
                        wXResponse.originalData = com.taobao.weex.adapter.DefaultWXHttpAdapter.this.readInputStreamAsBytes(eventReporterDelegate.interpretResponseStream(httpURLConnectionOpenConnection.getInputStream()), onHttpListener);
                        z = true;
                    }
                    com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener onHttpListener3 = onHttpListener;
                    if (onHttpListener3 != null) {
                        onHttpListener3.onHttpFinish(wXResponse);
                    }
                    z2 = z;
                } catch (java.io.IOException | java.lang.IllegalArgumentException e) {
                    e.printStackTrace();
                    wXResponse.statusCode = "-1";
                    wXResponse.errorCode = "-1";
                    wXResponse.errorMsg = e.getMessage();
                    com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener onHttpListener4 = onHttpListener;
                    if (onHttpListener4 != null) {
                        onHttpListener4.onHttpFinish(wXResponse);
                    }
                    if (e instanceof java.io.IOException) {
                        try {
                            eventReporterDelegate.httpExchangeFailed((java.io.IOException) e);
                        } catch (java.lang.Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
                if (wXSDKInstance == null || wXSDKInstance.isDestroy()) {
                    return;
                }
                wXSDKInstance.getApmForInstance().actionNetResult(z2, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.net.HttpURLConnection openConnection(com.taobao.weex.common.WXRequest wXRequest, com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener onHttpListener) throws java.io.IOException {
        java.net.HttpURLConnection httpURLConnectionCreateConnection = createConnection(new java.net.URL(wXRequest.url));
        httpURLConnectionCreateConnection.setConnectTimeout(wXRequest.timeoutMs);
        httpURLConnectionCreateConnection.setReadTimeout(wXRequest.timeoutMs);
        httpURLConnectionCreateConnection.setUseCaches(false);
        httpURLConnectionCreateConnection.setDoInput(true);
        if (wXRequest.paramMap != null) {
            for (java.lang.String str : wXRequest.paramMap.keySet()) {
                httpURLConnectionCreateConnection.addRequestProperty(str, wXRequest.paramMap.get(str));
            }
        }
        if ("POST".equals(wXRequest.method) || "PUT".equals(wXRequest.method) || "PATCH".equals(wXRequest.method)) {
            httpURLConnectionCreateConnection.setRequestMethod(wXRequest.method);
            if (wXRequest.body != null) {
                if (onHttpListener != null) {
                    onHttpListener.onHttpUploadProgress(0);
                }
                httpURLConnectionCreateConnection.setDoOutput(true);
                java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(httpURLConnectionCreateConnection.getOutputStream());
                dataOutputStream.write(wXRequest.body.getBytes());
                dataOutputStream.close();
                if (onHttpListener != null) {
                    onHttpListener.onHttpUploadProgress(100);
                }
            }
            return httpURLConnectionCreateConnection;
        }
        if (!android.text.TextUtils.isEmpty(wXRequest.method)) {
            httpURLConnectionCreateConnection.setRequestMethod(wXRequest.method);
            return httpURLConnectionCreateConnection;
        }
        httpURLConnectionCreateConnection.setRequestMethod("GET");
        return httpURLConnectionCreateConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] readInputStreamAsBytes(java.io.InputStream inputStream, com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener onHttpListener) throws java.io.IOException {
        if (inputStream == null) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        int i = 0;
        while (true) {
            int i2 = inputStream.read(bArr, 0, 2048);
            if (i2 != -1) {
                byteArrayOutputStream.write(bArr, 0, i2);
                i += i2;
                if (onHttpListener != null) {
                    onHttpListener.onHttpResponseProgress(i);
                }
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String readInputStream(java.io.InputStream inputStream, com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener onHttpListener) throws java.io.IOException {
        if (inputStream == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
        char[] cArr = new char[2048];
        while (true) {
            int i = bufferedReader.read(cArr);
            if (i != -1) {
                sb.append(cArr, 0, i);
                if (onHttpListener != null) {
                    onHttpListener.onHttpResponseProgress(sb.length());
                }
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }

    protected java.net.HttpURLConnection createConnection(java.net.URL url) throws java.io.IOException {
        return (java.net.HttpURLConnection) url.openConnection();
    }

    public com.taobao.weex.adapter.DefaultWXHttpAdapter.IEventReporterDelegate getEventReporterDelegate() {
        return DEFAULT_DELEGATE;
    }

    private static class NOPEventReportDelegate implements com.taobao.weex.adapter.DefaultWXHttpAdapter.IEventReporterDelegate {
        @Override // com.taobao.weex.adapter.DefaultWXHttpAdapter.IEventReporterDelegate
        public void httpExchangeFailed(java.io.IOException iOException) {
        }

        @Override // com.taobao.weex.adapter.DefaultWXHttpAdapter.IEventReporterDelegate
        public java.io.InputStream interpretResponseStream(java.io.InputStream inputStream) {
            return inputStream;
        }

        @Override // com.taobao.weex.adapter.DefaultWXHttpAdapter.IEventReporterDelegate
        public void postConnect() {
        }

        @Override // com.taobao.weex.adapter.DefaultWXHttpAdapter.IEventReporterDelegate
        public void preConnect(java.net.HttpURLConnection httpURLConnection, java.lang.String str) {
        }

        private NOPEventReportDelegate() {
        }
    }
}
