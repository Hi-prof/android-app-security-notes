package com.dcloud.android.downloader.config;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class Config {
    private com.dcloud.android.downloader.db.DownloadDBController downloadDBController;
    private final java.lang.String method = "GET";
    private int connectTimeout = io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH;
    private int readTimeout = io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH;
    private int downloadThread = 2;
    private int eachDownloadThread = 1;
    private java.lang.String databaseName = "download_info.db";
    private int databaseVersion = 2;
    private int retryDownloadCount = 2;

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public java.lang.String getDatabaseName() {
        return this.databaseName;
    }

    public int getDatabaseVersion() {
        return this.databaseVersion;
    }

    public com.dcloud.android.downloader.db.DownloadDBController getDownloadDBController() {
        return this.downloadDBController;
    }

    public int getDownloadThread() {
        return this.downloadThread;
    }

    public int getEachDownloadThread() {
        return this.eachDownloadThread;
    }

    public java.lang.String getMethod() {
        return "GET";
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public int getRetryDownloadCount() {
        return this.retryDownloadCount;
    }

    public void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public void setDatabaseName(java.lang.String str) {
        this.databaseName = str;
    }

    public void setDatabaseVersion(int i) {
        this.databaseVersion = i;
    }

    public void setDownloadDBController(com.dcloud.android.downloader.db.DownloadDBController downloadDBController) {
        this.downloadDBController = downloadDBController;
    }

    public void setDownloadThread(int i) {
        this.downloadThread = i;
    }

    public void setEachDownloadThread(int i) {
        this.eachDownloadThread = i;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    public void setRetryDownloadCount(int i) {
        this.retryDownloadCount = i;
    }
}
