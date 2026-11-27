package com.dcloud.android.downloader.core;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DownloadResponseImpl implements com.dcloud.android.downloader.core.DownloadResponse {
    private static final java.lang.String TAG = "DownloadResponseImpl";
    private final com.dcloud.android.downloader.db.DownloadDBController downloadDBController;
    private final android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.dcloud.android.downloader.core.DownloadResponseImpl.1
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            com.dcloud.android.downloader.domain.DownloadInfo downloadInfo = (com.dcloud.android.downloader.domain.DownloadInfo) message.obj;
            switch (downloadInfo.getStatus()) {
                case 1:
                    if (downloadInfo.getDownloadListener() != null) {
                        downloadInfo.getDownloadListener().onStart();
                    }
                    break;
                case 2:
                    if (downloadInfo.getDownloadListener() != null) {
                        downloadInfo.getDownloadListener().onDownloading(downloadInfo.getProgress(), downloadInfo.getSize());
                    }
                    break;
                case 3:
                    if (downloadInfo.getDownloadListener() != null) {
                        downloadInfo.getDownloadListener().onWaited();
                    }
                    break;
                case 4:
                    if (downloadInfo.getDownloadListener() != null) {
                        downloadInfo.getDownloadListener().onPaused();
                    }
                    break;
                case 5:
                    if (downloadInfo.getDownloadListener() != null) {
                        downloadInfo.getDownloadListener().onDownloadSuccess(downloadInfo);
                    }
                    break;
                case 6:
                    if (downloadInfo.getDownloadListener() != null) {
                        downloadInfo.getDownloadListener().onDownloadFailed(downloadInfo, downloadInfo.getException());
                    }
                    break;
                case 7:
                    if (downloadInfo.getDownloadListener() != null) {
                        downloadInfo.getDownloadListener().onRemoved();
                    }
                    break;
            }
        }
    };

    public DownloadResponseImpl(com.dcloud.android.downloader.db.DownloadDBController downloadDBController) {
        this.downloadDBController = downloadDBController;
    }

    @Override // com.dcloud.android.downloader.core.DownloadResponse
    public void handleException(com.dcloud.android.downloader.exception.DownloadException downloadException) {
    }

    @Override // com.dcloud.android.downloader.core.DownloadResponse
    public void onStatusChanged(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo) {
        if (downloadInfo.getStatus() != 7) {
            this.downloadDBController.createOrUpdate(downloadInfo);
            if (downloadInfo.getDownloadThreadInfos() != null) {
                java.util.Iterator<com.dcloud.android.downloader.domain.DownloadThreadInfo> it = downloadInfo.getDownloadThreadInfos().iterator();
                while (it.hasNext()) {
                    this.downloadDBController.createOrUpdate(it.next());
                }
            }
        }
        android.os.Message messageObtainMessage = this.handler.obtainMessage(downloadInfo.getId());
        messageObtainMessage.obj = downloadInfo;
        messageObtainMessage.sendToTarget();
        android.util.Log.d(TAG, "progress:" + downloadInfo.getProgress() + ",size:" + downloadInfo.getSize());
    }
}
