package com.bumptech.glide.load.data;

/* JADX INFO: loaded from: classes.dex */
public class HttpUrlFetcher implements com.bumptech.glide.load.data.DataFetcher<java.io.InputStream> {
    static final com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY = new com.bumptech.glide.load.data.HttpUrlFetcher.DefaultHttpUrlConnectionFactory();
    static final int INVALID_STATUS_CODE = -1;
    private static final int MAXIMUM_REDIRECTS = 5;
    static final java.lang.String REDIRECT_HEADER_FIELD = "Location";
    private static final java.lang.String TAG = "HttpUrlFetcher";
    private final com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory connectionFactory;
    private final com.bumptech.glide.load.model.GlideUrl glideUrl;
    private volatile boolean isCancelled;
    private java.io.InputStream stream;
    private final int timeout;
    private java.net.HttpURLConnection urlConnection;

    interface HttpUrlConnectionFactory {
        java.net.HttpURLConnection build(java.net.URL url) throws java.io.IOException;
    }

    public HttpUrlFetcher(com.bumptech.glide.load.model.GlideUrl glideUrl, int i) {
        this(glideUrl, i, DEFAULT_CONNECTION_FACTORY);
    }

    HttpUrlFetcher(com.bumptech.glide.load.model.GlideUrl glideUrl, int i, com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.glideUrl = glideUrl;
        this.timeout = i;
        this.connectionFactory = httpUrlConnectionFactory;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(com.bumptech.glide.Priority priority, com.bumptech.glide.load.data.DataFetcher.DataCallback<? super java.io.InputStream> dataCallback) {
        long logTime = com.bumptech.glide.util.LogTime.getLogTime();
        try {
            dataCallback.onDataReady(loadDataWithRedirects(this.glideUrl.toURL(), 0, null, this.glideUrl.getHeaders()));
        } catch (java.io.IOException e) {
            if (android.util.Log.isLoggable(TAG, 3)) {
                android.util.Log.d(TAG, "Failed to load data for url", e);
            }
            dataCallback.onLoadFailed(e);
        } finally {
            if (android.util.Log.isLoggable(TAG, 2)) {
                android.util.Log.v(TAG, "Finished http url fetcher fetch in " + com.bumptech.glide.util.LogTime.getElapsedMillis(logTime));
            }
        }
    }

    private java.io.InputStream loadDataWithRedirects(java.net.URL url, int i, java.net.URL url2, java.util.Map<java.lang.String, java.lang.String> map) throws com.bumptech.glide.load.HttpException {
        if (i >= 5) {
            throw new com.bumptech.glide.load.HttpException("Too many (> 5) redirects!", -1);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new com.bumptech.glide.load.HttpException("In re-direct loop", -1);
                }
            } catch (java.net.URISyntaxException unused) {
            }
        }
        java.net.HttpURLConnection httpURLConnectionBuildAndConfigureConnection = buildAndConfigureConnection(url, map);
        this.urlConnection = httpURLConnectionBuildAndConfigureConnection;
        try {
            httpURLConnectionBuildAndConfigureConnection.connect();
            this.stream = this.urlConnection.getInputStream();
            if (this.isCancelled) {
                return null;
            }
            int httpStatusCodeOrInvalid = getHttpStatusCodeOrInvalid(this.urlConnection);
            if (isHttpOk(httpStatusCodeOrInvalid)) {
                return getStreamForSuccessfulRequest(this.urlConnection);
            }
            if (!isHttpRedirect(httpStatusCodeOrInvalid)) {
                if (httpStatusCodeOrInvalid == -1) {
                    throw new com.bumptech.glide.load.HttpException(httpStatusCodeOrInvalid);
                }
                try {
                    throw new com.bumptech.glide.load.HttpException(this.urlConnection.getResponseMessage(), httpStatusCodeOrInvalid);
                } catch (java.io.IOException e) {
                    throw new com.bumptech.glide.load.HttpException("Failed to get a response message", httpStatusCodeOrInvalid, e);
                }
            }
            java.lang.String headerField = this.urlConnection.getHeaderField(REDIRECT_HEADER_FIELD);
            if (android.text.TextUtils.isEmpty(headerField)) {
                throw new com.bumptech.glide.load.HttpException("Received empty or null redirect url", httpStatusCodeOrInvalid);
            }
            try {
                java.net.URL url3 = new java.net.URL(url, headerField);
                cleanup();
                return loadDataWithRedirects(url3, i + 1, url, map);
            } catch (java.net.MalformedURLException e2) {
                throw new com.bumptech.glide.load.HttpException("Bad redirect url: " + headerField, httpStatusCodeOrInvalid, e2);
            }
        } catch (java.io.IOException e3) {
            throw new com.bumptech.glide.load.HttpException("Failed to connect or obtain data", getHttpStatusCodeOrInvalid(this.urlConnection), e3);
        }
    }

    private static int getHttpStatusCodeOrInvalid(java.net.HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (java.io.IOException e) {
            if (!android.util.Log.isLoggable(TAG, 3)) {
                return -1;
            }
            android.util.Log.d(TAG, "Failed to get a response code", e);
            return -1;
        }
    }

    private java.net.HttpURLConnection buildAndConfigureConnection(java.net.URL url, java.util.Map<java.lang.String, java.lang.String> map) throws com.bumptech.glide.load.HttpException {
        try {
            java.net.HttpURLConnection httpURLConnectionBuild = this.connectionFactory.build(url);
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                httpURLConnectionBuild.addRequestProperty(entry.getKey(), entry.getValue());
            }
            httpURLConnectionBuild.setConnectTimeout(this.timeout);
            httpURLConnectionBuild.setReadTimeout(this.timeout);
            httpURLConnectionBuild.setUseCaches(false);
            httpURLConnectionBuild.setDoInput(true);
            httpURLConnectionBuild.setInstanceFollowRedirects(false);
            return httpURLConnectionBuild;
        } catch (java.io.IOException e) {
            throw new com.bumptech.glide.load.HttpException("URL.openConnection threw", 0, e);
        }
    }

    private static boolean isHttpOk(int i) {
        return i / 100 == 2;
    }

    private static boolean isHttpRedirect(int i) {
        return i / 100 == 3;
    }

    private java.io.InputStream getStreamForSuccessfulRequest(java.net.HttpURLConnection httpURLConnection) throws com.bumptech.glide.load.HttpException {
        try {
            if (android.text.TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.stream = com.bumptech.glide.util.ContentLengthInputStream.obtain(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (android.util.Log.isLoggable(TAG, 3)) {
                    android.util.Log.d(TAG, "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                this.stream = httpURLConnection.getInputStream();
            }
            return this.stream;
        } catch (java.io.IOException e) {
            throw new com.bumptech.glide.load.HttpException("Failed to obtain InputStream", getHttpStatusCodeOrInvalid(httpURLConnection), e);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        java.io.InputStream inputStream = this.stream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException unused) {
            }
        }
        java.net.HttpURLConnection httpURLConnection = this.urlConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.urlConnection = null;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        this.isCancelled = true;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public java.lang.Class<java.io.InputStream> getDataClass() {
        return java.io.InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public com.bumptech.glide.load.DataSource getDataSource() {
        return com.bumptech.glide.load.DataSource.REMOTE;
    }

    private static class DefaultHttpUrlConnectionFactory implements com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory {
        DefaultHttpUrlConnectionFactory() {
        }

        @Override // com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory
        public java.net.HttpURLConnection build(java.net.URL url) throws java.io.IOException {
            return (java.net.HttpURLConnection) url.openConnection();
        }
    }
}
