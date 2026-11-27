package com.dcloud.android.downloader.db;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface DownloadDBController {
    void createOrUpdate(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo);

    void createOrUpdate(com.dcloud.android.downloader.domain.DownloadThreadInfo downloadThreadInfo);

    void delete(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo);

    void delete(com.dcloud.android.downloader.domain.DownloadThreadInfo downloadThreadInfo);

    java.util.List<com.dcloud.android.downloader.domain.DownloadInfo> findAllDownloaded();

    java.util.List<com.dcloud.android.downloader.domain.DownloadInfo> findAllDownloading();

    com.dcloud.android.downloader.domain.DownloadInfo findDownloadedInfoById(int i);

    void pauseAllDownloading();
}
