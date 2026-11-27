package io.dcloud.feature.weex.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class DCWXHttpAdapter implements com.taobao.weex.adapter.IWXHttpAdapter {
    private static dc.squareup.okhttp3.ConnectionPool mConnectPool;
    private static javax.net.ssl.SSLSocketFactory sslSocketFactory;
    private java.util.concurrent.ExecutorService mExecutorService;

    private void execute(java.lang.Runnable runnable) {
        if (this.mExecutorService == null) {
            this.mExecutorService = java.util.concurrent.Executors.newFixedThreadPool(10);
        }
        this.mExecutorService.execute(runnable);
    }

    @Override // com.taobao.weex.adapter.IWXHttpAdapter
    public void sendRequest(final com.taobao.weex.common.WXRequest wXRequest, final com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener onHttpListener) {
        if (onHttpListener != null) {
            onHttpListener.onHttpStart();
        }
        execute(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.adapter.DCWXHttpAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                com.taobao.weex.WXSDKInstance wXSDKInstance = com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().get(wXRequest.instanceId);
                if (wXSDKInstance != null && !wXSDKInstance.isDestroy()) {
                    wXSDKInstance.getApmForInstance().actionNetRequest();
                }
                com.taobao.weex.common.WXResponse wXResponse = new com.taobao.weex.common.WXResponse();
                boolean z2 = false;
                try {
                    dc.squareup.okhttp3.OkHttpClient.Builder builder = new dc.squareup.okhttp3.OkHttpClient.Builder();
                    dc.squareup.okhttp3.Response responseExecute = builder.build().newCall(io.dcloud.feature.weex.adapter.DCWXHttpAdapter.this.getOKRequest(builder, wXRequest, onHttpListener)).execute();
                    java.util.Map<java.lang.String, java.util.List<java.lang.String>> multimap = responseExecute.headers().toMultimap();
                    int iCode = responseExecute.code();
                    wXResponse.statusCode = java.lang.String.valueOf(iCode);
                    com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener onHttpListener2 = onHttpListener;
                    if (onHttpListener2 != null) {
                        onHttpListener2.onHeadersReceived(iCode, multimap);
                    }
                    if (!responseExecute.isSuccessful()) {
                        wXResponse.errorMsg = io.dcloud.feature.weex.adapter.DCWXHttpAdapter.this.readInputStream(responseExecute.body().byteStream(), onHttpListener);
                        z = false;
                    } else {
                        wXResponse.originalData = io.dcloud.feature.weex.adapter.DCWXHttpAdapter.this.readInputStreamAsBytes(responseExecute.body().byteStream(), onHttpListener);
                        z = true;
                    }
                    com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener onHttpListener3 = onHttpListener;
                    if (onHttpListener3 != null) {
                        onHttpListener3.onHttpFinish(wXResponse);
                    }
                    z2 = z;
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    wXResponse.statusCode = "-1";
                    wXResponse.errorCode = "-1";
                    wXResponse.errorMsg = e.getMessage();
                    com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener onHttpListener4 = onHttpListener;
                    if (onHttpListener4 != null) {
                        onHttpListener4.onHttpFinish(wXResponse);
                    }
                }
                if (wXSDKInstance == null || wXSDKInstance.isDestroy()) {
                    return;
                }
                wXSDKInstance.getApmForInstance().actionNetResult(z2, null);
            }
        });
    }

    public dc.squareup.okhttp3.Request getOKRequest(dc.squareup.okhttp3.OkHttpClient.Builder builder, com.taobao.weex.common.WXRequest wXRequest, com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener onHttpListener) {
        builder.connectTimeout(wXRequest.timeoutMs, java.util.concurrent.TimeUnit.MILLISECONDS).readTimeout(wXRequest.timeoutMs, java.util.concurrent.TimeUnit.MILLISECONDS).writeTimeout(wXRequest.timeoutMs, java.util.concurrent.TimeUnit.MILLISECONDS).callTimeout(wXRequest.timeoutMs, java.util.concurrent.TimeUnit.MILLISECONDS).protocols(java.util.Collections.singletonList(dc.squareup.okhttp3.Protocol.HTTP_1_1));
        if (wXRequest.isFirstIpv4) {
            builder.dns(new io.dcloud.common.adapter.util.DCOKDns());
        }
        java.lang.String host = android.net.Uri.parse(wXRequest.url).getHost();
        if (wXRequest.tls != null) {
            io.dcloud.feature.weex.config.AndroidTlsConfig androidTlsConfig = new io.dcloud.feature.weex.config.AndroidTlsConfig();
            androidTlsConfig.setKeystore(wXRequest.tls.getString("keystore"));
            androidTlsConfig.setStorePass(wXRequest.tls.getString("storePass"));
            com.alibaba.fastjson.JSONArray jSONArray = wXRequest.tls.getJSONArray("ca");
            androidTlsConfig.setCa(jSONArray != null ? (java.lang.String[]) jSONArray.toArray(new java.lang.String[0]) : null);
            builder.sslSocketFactory(io.dcloud.feature.weex.config.UserCustomTrustManager.getSSLSocketFactory(androidTlsConfig, com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().get(wXRequest.instanceId)));
            builder.hostnameVerifier(dc.squareup.okhttp3.internal.tls.OkHostnameVerifier.INSTANCE);
        } else if (com.taobao.weex.http.WXStreamModule.certMap != null && com.taobao.weex.http.WXStreamModule.certMap.containsKey(host)) {
            builder.sslSocketFactory(io.dcloud.feature.weex.config.UserCustomTrustManager.getSSLSocketFactory(com.taobao.weex.http.WXStreamModule.certMap.get(host), com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().get(wXRequest.instanceId)));
            builder.hostnameVerifier(dc.squareup.okhttp3.internal.tls.OkHostnameVerifier.INSTANCE);
        } else if (wXRequest.sslVerify) {
            try {
                if (sslSocketFactory == null) {
                    sslSocketFactory = io.dcloud.common.adapter.util.DCloudTrustManager.getSSLSocketFactory();
                }
                javax.net.ssl.SSLSocketFactory sSLSocketFactory = sslSocketFactory;
                if (sSLSocketFactory != null) {
                    builder.sslSocketFactory(sSLSocketFactory);
                }
            } catch (java.security.KeyManagementException e) {
                e.printStackTrace();
            } catch (java.security.NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
            builder.hostnameVerifier(getHostnameVerifier(wXRequest.sslVerify));
        }
        if (mConnectPool == null) {
            mConnectPool = new dc.squareup.okhttp3.ConnectionPool();
        }
        builder.connectionPool(mConnectPool);
        dc.squareup.okhttp3.Request.Builder builder2 = new dc.squareup.okhttp3.Request.Builder();
        builder2.url(wXRequest.url);
        java.lang.String str = "application/x-www-form-urlencoded";
        if (wXRequest.paramMap != null) {
            for (java.lang.String str2 : wXRequest.paramMap.keySet()) {
                if (str2.equalsIgnoreCase(io.dcloud.common.util.net.NetWork.CONTENT_TYPE)) {
                    str = wXRequest.paramMap.get(str2);
                }
                builder2.addHeader(str2, wXRequest.paramMap.get(str2));
            }
        }
        if ("POST".equals(wXRequest.method) || "PUT".equals(wXRequest.method) || "PATCH".equals(wXRequest.method) || "DELETE".equals(wXRequest.method)) {
            if (wXRequest.body != null && onHttpListener != null) {
                onHttpListener.onHttpUploadProgress(0);
            }
            if ("BASE64".equalsIgnoreCase(wXRequest.inputType)) {
                builder2.method(wXRequest.method, dc.squareup.okhttp3.RequestBody.createWithBytes(dc.squareup.okhttp3.MediaType.parse(str), android.util.Base64.decode(wXRequest.body, 2)));
                if (onHttpListener != null) {
                    onHttpListener.onHttpUploadProgress(100);
                }
            } else {
                builder2.method(wXRequest.method, dc.squareup.okhttp3.RequestBody.create(dc.squareup.okhttp3.MediaType.parse(str), wXRequest.body));
                if (onHttpListener != null) {
                    onHttpListener.onHttpUploadProgress(100);
                }
            }
        } else if ("HEAD".equals(wXRequest.method)) {
            builder2.head();
        }
        return builder2.build();
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

    public org.apache.http.conn.ssl.X509HostnameVerifier getHostnameVerifier(boolean z) {
        if (!z) {
            return org.apache.http.conn.ssl.SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
        }
        return org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
    }

    public dc.squareup.okhttp3.OkHttpClient getImageOkHttpClient() {
        dc.squareup.okhttp3.OkHttpClient.Builder builder = new dc.squareup.okhttp3.OkHttpClient.Builder();
        long j = com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT;
        builder.connectTimeout(j, java.util.concurrent.TimeUnit.MILLISECONDS).readTimeout(j, java.util.concurrent.TimeUnit.MILLISECONDS).writeTimeout(j, java.util.concurrent.TimeUnit.MILLISECONDS).callTimeout(j, java.util.concurrent.TimeUnit.MILLISECONDS).protocols(java.util.Collections.singletonList(dc.squareup.okhttp3.Protocol.HTTP_1_1));
        return builder.build();
    }
}
