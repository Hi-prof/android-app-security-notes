package com.dcloud.android.downloader.core;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface DownloadResponse {
    void handleException(com.dcloud.android.downloader.exception.DownloadException downloadException);

    void onStatusChanged(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo);
}
