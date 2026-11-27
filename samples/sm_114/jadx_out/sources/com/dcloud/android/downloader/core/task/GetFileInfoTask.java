package com.dcloud.android.downloader.core.task;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class GetFileInfoTask implements java.lang.Runnable {
    private final com.dcloud.android.downloader.domain.DownloadInfo downloadInfo;
    private final com.dcloud.android.downloader.core.DownloadResponse downloadResponse;
    private final com.dcloud.android.downloader.core.task.GetFileInfoTask.OnGetFileInfoListener onGetFileInfoListener;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface OnGetFileInfoListener {
        void onFailed(com.dcloud.android.downloader.exception.DownloadException downloadException);

        void onSuccess(long j, boolean z);
    }

    public GetFileInfoTask(com.dcloud.android.downloader.core.DownloadResponse downloadResponse, com.dcloud.android.downloader.domain.DownloadInfo downloadInfo, com.dcloud.android.downloader.core.task.GetFileInfoTask.OnGetFileInfoListener onGetFileInfoListener) {
        this.downloadResponse = downloadResponse;
        this.downloadInfo = downloadInfo;
        this.onGetFileInfoListener = onGetFileInfoListener;
    }

    private void checkIfPause() {
        if (this.downloadInfo.isPause()) {
            throw new com.dcloud.android.downloader.exception.DownloadException(7);
        }
    }

    private void executeConnection() throws com.dcloud.android.downloader.exception.DownloadException {
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(this.downloadInfo.getDownloadUrl()).openConnection();
            if (httpURLConnection instanceof javax.net.ssl.HttpsURLConnection) {
                javax.net.ssl.SSLSocketFactory sSLSocketFactory = io.dcloud.common.adapter.util.DCloudTrustManager.getSSLSocketFactory();
                if (sSLSocketFactory != null) {
                    ((javax.net.ssl.HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                }
                ((javax.net.ssl.HttpsURLConnection) httpURLConnection).setHostnameVerifier(io.dcloud.common.adapter.util.DCloudTrustManager.getHostnameVerifier(false));
            }
            httpURLConnection.setConnectTimeout(io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH);
            httpURLConnection.setReadTimeout(io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Range", "bytes=0-");
            httpURLConnection.setInstanceFollowRedirects(false);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                parseHttpResponse(httpURLConnection, false);
                return;
            }
            if (responseCode == 206) {
                parseHttpResponse(httpURLConnection, true);
                return;
            }
            if (responseCode != 302 && 301 != responseCode) {
                throw new com.dcloud.android.downloader.exception.DownloadException(3, "UnSupported response code:" + responseCode);
            }
            this.downloadInfo.setLocation(httpURLConnection.getHeaderField("Location"));
            executeConnection();
        } catch (java.net.MalformedURLException e) {
            throw new com.dcloud.android.downloader.exception.DownloadException(2, "Bad url.", e);
        } catch (java.net.ProtocolException e2) {
            throw new com.dcloud.android.downloader.exception.DownloadException(4, "Protocol error", e2);
        } catch (java.io.IOException e3) {
            throw new com.dcloud.android.downloader.exception.DownloadException(5, "IO error", e3);
        } catch (java.lang.Exception e4) {
            throw new com.dcloud.android.downloader.exception.DownloadException(5, "Unknown error", e4);
        }
    }

    private void parseHttpResponse(java.net.HttpURLConnection httpURLConnection, boolean z) throws com.dcloud.android.downloader.exception.DownloadException {
        java.lang.String headerField = httpURLConnection.getHeaderField("Content-Length");
        long contentLength = (android.text.TextUtils.isEmpty(headerField) || headerField.equals(com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT) || headerField.equals("-1")) ? httpURLConnection.getContentLength() : java.lang.Long.parseLong(headerField);
        if (contentLength <= 0) {
            throw new com.dcloud.android.downloader.exception.DownloadException(6, "length <= 0");
        }
        checkIfPause();
        this.onGetFileInfoListener.onSuccess(contentLength, z);
    }

    @Override // java.lang.Runnable
    public void run() {
        android.os.Process.setThreadPriority(10);
        try {
            executeConnection();
        } catch (com.dcloud.android.downloader.exception.DownloadException e) {
            this.downloadResponse.handleException(e);
        } catch (java.lang.Exception e2) {
            this.downloadResponse.handleException(new com.dcloud.android.downloader.exception.DownloadException(9, e2));
        }
    }
}
