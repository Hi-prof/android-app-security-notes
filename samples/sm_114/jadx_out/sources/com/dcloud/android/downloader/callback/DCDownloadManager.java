package com.dcloud.android.downloader.callback;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface DCDownloadManager {
    void download(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo);

    java.util.List<com.dcloud.android.downloader.domain.DownloadInfo> findAllDownloaded();

    java.util.List<com.dcloud.android.downloader.domain.DownloadInfo> findAllDownloading();

    com.dcloud.android.downloader.domain.DownloadInfo getDownloadById(int i);

    com.dcloud.android.downloader.db.DownloadDBController getDownloadDBController();

    void onDestroy();

    void pause(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo);

    void remove(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo);

    void resume(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo);
}
