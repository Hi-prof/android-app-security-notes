package com.dcloud.android.downloader.callback;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface DownloadListener {
    void onDownloadFailed(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo, com.dcloud.android.downloader.exception.DownloadException downloadException);

    void onDownloadSuccess(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo);

    void onDownloading(long j, long j2);

    void onPaused();

    void onRemoved();

    void onStart();

    void onWaited();
}
