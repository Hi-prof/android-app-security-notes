package com.nostra13.dcloudimageloader.core.download;

/* JADX INFO: loaded from: classes.dex */
public class BaseImageDownloader implements com.nostra13.dcloudimageloader.core.download.ImageDownloader {
    protected static final java.lang.String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    protected static final int BUFFER_SIZE = 32768;
    public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5000;
    public static final int DEFAULT_HTTP_READ_TIMEOUT = 20000;
    private static final java.lang.String ERROR_UNSUPPORTED_SCHEME = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";
    protected static final int MAX_REDIRECT_COUNT = 5;
    protected final int connectTimeout;
    protected final android.content.Context context;
    private javax.net.ssl.HostnameVerifier defHostnameVerifier;
    protected final int readTimeout;

    public BaseImageDownloader(android.content.Context context) {
        this.defHostnameVerifier = null;
        this.context = context.getApplicationContext();
        this.connectTimeout = DEFAULT_HTTP_CONNECT_TIMEOUT;
        this.readTimeout = 20000;
    }

    public BaseImageDownloader(android.content.Context context, int i, int i2) {
        this.defHostnameVerifier = null;
        this.context = context.getApplicationContext();
        this.connectTimeout = i;
        this.readTimeout = i2;
    }

    /* JADX INFO: renamed from: com.nostra13.dcloudimageloader.core.download.BaseImageDownloader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$nostra13$dcloudimageloader$core$download$ImageDownloader$Scheme;

        static {
            int[] iArr = new int[com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.values().length];
            $SwitchMap$com$nostra13$dcloudimageloader$core$download$ImageDownloader$Scheme = iArr;
            try {
                iArr[com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$nostra13$dcloudimageloader$core$download$ImageDownloader$Scheme[com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$nostra13$dcloudimageloader$core$download$ImageDownloader$Scheme[com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.FILE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$nostra13$dcloudimageloader$core$download$ImageDownloader$Scheme[com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.CONTENT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$nostra13$dcloudimageloader$core$download$ImageDownloader$Scheme[com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.ASSETS.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$nostra13$dcloudimageloader$core$download$ImageDownloader$Scheme[com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.DRAWABLE.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$nostra13$dcloudimageloader$core$download$ImageDownloader$Scheme[com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.UNKNOWN.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.nostra13.dcloudimageloader.core.download.ImageDownloader
    public java.io.InputStream getStream(java.lang.String str, java.lang.Object obj) throws java.io.IOException {
        switch (com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.AnonymousClass1.$SwitchMap$com$nostra13$dcloudimageloader$core$download$ImageDownloader$Scheme[com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.ofUri(str).ordinal()]) {
            case 1:
            case 2:
                return getStreamFromNetwork(str, obj);
            case 3:
                return getStreamFromFile(str, obj);
            case 4:
                return getStreamFromContent(str, obj);
            case 5:
                return getStreamFromAssets(str, obj);
            case 6:
                return getStreamFromDrawable(str, obj);
            default:
                return getStreamFromOtherSource(str, obj);
        }
    }

    protected java.io.InputStream getStreamFromNetwork(java.lang.String str, java.lang.Object obj) throws java.io.IOException {
        java.net.HttpURLConnection httpURLConnectionCreateConnection = createConnection(str, obj);
        for (int i = 0; httpURLConnectionCreateConnection.getResponseCode() / 100 == 3 && i < 5; i++) {
            httpURLConnectionCreateConnection = createConnection(httpURLConnectionCreateConnection.getHeaderField("Location"), obj);
        }
        return new java.io.BufferedInputStream(httpURLConnectionCreateConnection.getInputStream(), 1195);
    }

    protected java.net.HttpURLConnection createConnection(java.lang.String str, java.lang.Object obj) throws java.io.IOException {
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(android.net.Uri.encode(str, ALLOWED_URI_CHARS)).openConnection();
        if (str.startsWith("https")) {
            trustAllHosts((javax.net.ssl.HttpsURLConnection) httpURLConnection);
        }
        httpURLConnection.setConnectTimeout(this.connectTimeout);
        httpURLConnection.setReadTimeout(this.readTimeout);
        return httpURLConnection;
    }

    protected java.io.InputStream getStreamFromFile(java.lang.String str, java.lang.Object obj) throws java.io.IOException {
        return new java.io.BufferedInputStream(new java.io.FileInputStream(com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.FILE.crop(str)), 1195);
    }

    protected java.io.InputStream getStreamFromContent(java.lang.String str, java.lang.Object obj) throws java.io.FileNotFoundException {
        return this.context.getContentResolver().openInputStream(android.net.Uri.parse(str));
    }

    protected java.io.InputStream getStreamFromAssets(java.lang.String str, java.lang.Object obj) throws java.io.IOException {
        return this.context.getAssets().open(com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.ASSETS.crop(str));
    }

    protected java.io.InputStream getStreamFromDrawable(java.lang.String str, java.lang.Object obj) {
        android.graphics.Bitmap bitmap = ((android.graphics.drawable.BitmapDrawable) this.context.getResources().getDrawable(java.lang.Integer.parseInt(com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.DRAWABLE.crop(str)))).getBitmap();
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        return new java.io.ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    protected java.io.InputStream getStreamFromOtherSource(java.lang.String str, java.lang.Object obj) throws java.io.IOException {
        throw new java.lang.UnsupportedOperationException(java.lang.String.format(ERROR_UNSUPPORTED_SCHEME, str));
    }

    private void trustAllHosts(javax.net.ssl.HttpsURLConnection httpsURLConnection) {
        try {
            javax.net.ssl.SSLContext.getInstance("TLS");
            if (newInstance(this.context.getPackageName() + ".CustomTrustMgr", null, null) != null) {
                javax.net.ssl.SSLSocketFactory sSLSocketFactory = io.dcloud.common.adapter.util.DCloudTrustManager.getSSLSocketFactory();
                if (sSLSocketFactory != null) {
                    httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
                }
                httpsURLConnection.setHostnameVerifier(getDefaultHostnameVerifier());
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private java.lang.Object newInstance(java.lang.String str, java.lang.Class[] clsArr, java.lang.Object[] objArr) {
        try {
            return java.lang.Class.forName(str).getConstructor(clsArr).newInstance(objArr);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private javax.net.ssl.HostnameVerifier getDefaultHostnameVerifier() {
        javax.net.ssl.HostnameVerifier hostnameVerifier = this.defHostnameVerifier;
        return hostnameVerifier != null ? hostnameVerifier : io.dcloud.common.adapter.util.DCloudTrustManager.getHostnameVerifier(true);
    }
}
