package com.dcloud.android.downloader.core.thread;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DownloadThread implements java.lang.Runnable {
    public static final java.lang.String TAG = "DownloadThread";
    private final com.dcloud.android.downloader.config.Config config;
    private final com.dcloud.android.downloader.domain.DownloadInfo downloadInfo;
    private final com.dcloud.android.downloader.core.thread.DownloadThread.DownloadProgressListener downloadProgressListener;
    private final com.dcloud.android.downloader.core.DownloadResponse downloadResponse;
    private final com.dcloud.android.downloader.domain.DownloadThreadInfo downloadThreadInfo;
    private java.io.InputStream inputStream;
    private long lastProgress;
    private int retryDownloadCount = 0;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface DownloadProgressListener {
        void onDownloadSuccess();

        void onProgress();
    }

    public DownloadThread(com.dcloud.android.downloader.domain.DownloadThreadInfo downloadThreadInfo, com.dcloud.android.downloader.core.DownloadResponse downloadResponse, com.dcloud.android.downloader.config.Config config, com.dcloud.android.downloader.domain.DownloadInfo downloadInfo, com.dcloud.android.downloader.core.thread.DownloadThread.DownloadProgressListener downloadProgressListener) {
        this.downloadThreadInfo = downloadThreadInfo;
        this.downloadResponse = downloadResponse;
        this.config = config;
        this.downloadInfo = downloadInfo;
        this.lastProgress = downloadThreadInfo.getProgress();
        this.downloadProgressListener = downloadProgressListener;
    }

    private void checkPause() {
        if (this.downloadInfo.isPause()) {
            throw new com.dcloud.android.downloader.exception.DownloadPauseException(7);
        }
    }

    private void executeDownload() throws java.lang.Throwable {
        java.net.HttpURLConnection httpURLConnection = null;
        try {
            try {
                java.net.HttpURLConnection httpURLConnection2 = (java.net.HttpURLConnection) new java.net.URL(this.downloadThreadInfo.getUri()).openConnection();
                try {
                    if (httpURLConnection2 instanceof javax.net.ssl.HttpsURLConnection) {
                        javax.net.ssl.SSLSocketFactory sSLSocketFactory = io.dcloud.common.adapter.util.DCloudTrustManager.getSSLSocketFactory();
                        if (sSLSocketFactory != null) {
                            ((javax.net.ssl.HttpsURLConnection) httpURLConnection2).setSSLSocketFactory(sSLSocketFactory);
                        }
                        ((javax.net.ssl.HttpsURLConnection) httpURLConnection2).setHostnameVerifier(io.dcloud.common.adapter.util.DCloudTrustManager.getHostnameVerifier(false));
                    }
                    httpURLConnection2.setConnectTimeout(this.config.getConnectTimeout());
                    httpURLConnection2.setReadTimeout(this.config.getReadTimeout());
                    httpURLConnection2.setRequestMethod(this.config.getMethod());
                    long start = this.downloadThreadInfo.getStart() + this.lastProgress;
                    if (this.downloadInfo.isSupportRanges()) {
                        if (start > this.downloadThreadInfo.getEnd()) {
                            start = 0;
                            this.lastProgress = 0L;
                        }
                        if (this.config.getEachDownloadThread() == 1) {
                            httpURLConnection2.setRequestProperty("Range", "bytes=" + start + com.taobao.weex.el.parse.Operators.SUB);
                        } else {
                            httpURLConnection2.setRequestProperty("Range", "bytes=" + start + com.taobao.weex.el.parse.Operators.SUB + this.downloadThreadInfo.getEnd());
                        }
                    }
                    int responseCode = httpURLConnection2.getResponseCode();
                    long j = ((long) java.lang.Integer.parseInt(httpURLConnection2.getHeaderField("Content-Length"))) + start;
                    if (this.config.getEachDownloadThread() == 1 && j != this.downloadThreadInfo.getEnd()) {
                        if (j - this.downloadThreadInfo.getEnd() != 1) {
                            throw new com.dcloud.android.downloader.exception.DownloadException(5, "IO error Data source change");
                        }
                        start--;
                        this.lastProgress--;
                    }
                    if (responseCode != 206 && responseCode != 200) {
                        throw new com.dcloud.android.downloader.exception.DownloadException(8, "UnSupported response code:" + responseCode);
                    }
                    this.inputStream = httpURLConnection2.getInputStream();
                    java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(this.downloadInfo.getPath(), "rwd");
                    if (this.config.getEachDownloadThread() == 1 && randomAccessFile.length() < this.lastProgress) {
                        throw new com.dcloud.android.downloader.exception.DownloadException(5, "IO error Have small download size");
                    }
                    randomAccessFile.seek(start);
                    byte[] bArr = new byte[4096];
                    int i = 0;
                    while (true) {
                        checkPause();
                        int i2 = this.inputStream.read(bArr);
                        if (i2 == -1) {
                            this.downloadProgressListener.onDownloadSuccess();
                            checkPause();
                            httpURLConnection2.disconnect();
                            return;
                        }
                        randomAccessFile.write(bArr, 0, i2);
                        i += i2;
                        this.downloadThreadInfo.setProgress(this.lastProgress + ((long) i));
                        this.downloadProgressListener.onProgress();
                        android.util.Log.d(TAG, "downloadInfo:" + this.downloadInfo.getId() + " thread:" + this.downloadThreadInfo.getThreadId() + " progress:" + this.downloadThreadInfo.getProgress() + ",start:" + this.downloadThreadInfo.getStart() + ",end:" + this.downloadThreadInfo.getEnd());
                    }
                } catch (com.dcloud.android.downloader.exception.DownloadPauseException unused) {
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (java.net.ProtocolException e) {
                    e = e;
                    throw new com.dcloud.android.downloader.exception.DownloadException(4, "Protocol error", e);
                } catch (java.io.IOException e2) {
                    e = e2;
                    throw new com.dcloud.android.downloader.exception.DownloadException(5, "IO error", e);
                } catch (java.security.KeyManagementException e3) {
                    e = e3;
                    throw new com.dcloud.android.downloader.exception.DownloadException(5, "Key management", e);
                } catch (java.security.NoSuchAlgorithmException e4) {
                    e = e4;
                    throw new com.dcloud.android.downloader.exception.DownloadException(5, "NO such", e);
                } catch (java.lang.Throwable th) {
                    th = th;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (com.dcloud.android.downloader.exception.DownloadPauseException unused2) {
        } catch (java.net.ProtocolException e5) {
            e = e5;
        } catch (java.io.IOException e6) {
            e = e6;
        } catch (java.security.KeyManagementException e7) {
            e = e7;
        } catch (java.security.NoSuchAlgorithmException e8) {
            e = e8;
        }
    }

    @Override // java.lang.Runnable
    public void run() throws java.lang.Throwable {
        android.os.Process.setThreadPriority(10);
        checkPause();
        try {
            executeDownload();
        } catch (com.dcloud.android.downloader.exception.DownloadException e) {
            this.downloadInfo.setStatus(6);
            this.downloadInfo.setException(e);
            this.downloadResponse.onStatusChanged(this.downloadInfo);
            this.downloadResponse.handleException(e);
        } catch (java.lang.Exception e2) {
            com.dcloud.android.downloader.exception.DownloadException downloadException = new com.dcloud.android.downloader.exception.DownloadException(9, "other error", e2);
            this.downloadInfo.setStatus(6);
            this.downloadInfo.setException(downloadException);
            this.downloadResponse.onStatusChanged(this.downloadInfo);
            this.downloadResponse.handleException(downloadException);
        }
    }
}
