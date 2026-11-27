package com.dcloud.android.downloader.core;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DownloadTaskImpl implements com.dcloud.android.downloader.core.task.DownloadTask, com.dcloud.android.downloader.core.task.GetFileInfoTask.OnGetFileInfoListener, com.dcloud.android.downloader.core.thread.DownloadThread.DownloadProgressListener {
    private final com.dcloud.android.downloader.config.Config config;
    private final com.dcloud.android.downloader.domain.DownloadInfo downloadInfo;
    private final com.dcloud.android.downloader.core.DownloadResponse downloadResponse;
    private final com.dcloud.android.downloader.core.DownloadTaskImpl.DownloadTaskListener downloadTaskListener;
    private final java.util.concurrent.ExecutorService executorService;
    private long progress;
    private long lastRefreshTime = java.lang.System.currentTimeMillis();
    private volatile java.util.concurrent.atomic.AtomicBoolean isComputerDownload = new java.util.concurrent.atomic.AtomicBoolean(false);
    private final java.util.List<com.dcloud.android.downloader.core.thread.DownloadThread> downloadThreads = new java.util.ArrayList();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface DownloadTaskListener {
        void onDownloadSuccess(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo);
    }

    public DownloadTaskImpl(java.util.concurrent.ExecutorService executorService, com.dcloud.android.downloader.core.DownloadResponse downloadResponse, com.dcloud.android.downloader.domain.DownloadInfo downloadInfo, com.dcloud.android.downloader.config.Config config, com.dcloud.android.downloader.core.DownloadTaskImpl.DownloadTaskListener downloadTaskListener) {
        this.executorService = executorService;
        this.downloadResponse = downloadResponse;
        this.downloadInfo = downloadInfo;
        this.config = config;
        this.downloadTaskListener = downloadTaskListener;
    }

    private void computerDownloadProgress() {
        this.progress = 0L;
        java.util.Iterator<com.dcloud.android.downloader.domain.DownloadThreadInfo> it = this.downloadInfo.getDownloadThreadInfos().iterator();
        while (it.hasNext()) {
            this.progress += it.next().getProgress();
        }
        this.downloadInfo.setProgress(this.progress);
    }

    private void getFileInfo() {
        this.executorService.submit(new com.dcloud.android.downloader.core.task.GetFileInfoTask(this.downloadResponse, this.downloadInfo, this));
    }

    private void removeDownlaodFile() {
        java.io.File file = new java.io.File(this.downloadInfo.getPath());
        if (file.exists()) {
            file.delete();
        }
    }

    @Override // com.dcloud.android.downloader.core.thread.DownloadThread.DownloadProgressListener
    public void onDownloadSuccess() {
        computerDownloadProgress();
        if (this.downloadInfo.getProgress() == this.downloadInfo.getSize()) {
            this.downloadInfo.setStatus(5);
            this.downloadResponse.onStatusChanged(this.downloadInfo);
            com.dcloud.android.downloader.core.DownloadTaskImpl.DownloadTaskListener downloadTaskListener = this.downloadTaskListener;
            if (downloadTaskListener != null) {
                downloadTaskListener.onDownloadSuccess(this.downloadInfo);
            }
        }
    }

    @Override // com.dcloud.android.downloader.core.task.GetFileInfoTask.OnGetFileInfoListener
    public void onFailed(com.dcloud.android.downloader.exception.DownloadException downloadException) {
    }

    @Override // com.dcloud.android.downloader.core.thread.DownloadThread.DownloadProgressListener
    public void onProgress() {
        if (this.isComputerDownload.get()) {
            return;
        }
        synchronized (this) {
            if (!this.isComputerDownload.get()) {
                this.isComputerDownload.set(true);
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                if (jCurrentTimeMillis - this.lastRefreshTime > 1000) {
                    computerDownloadProgress();
                    this.downloadResponse.onStatusChanged(this.downloadInfo);
                    this.lastRefreshTime = jCurrentTimeMillis;
                }
                this.isComputerDownload.set(false);
            }
        }
    }

    @Override // com.dcloud.android.downloader.core.task.GetFileInfoTask.OnGetFileInfoListener
    public void onSuccess(long j, boolean z) {
        this.downloadInfo.setSupportRanges(z);
        this.downloadInfo.setSize(j);
        removeDownlaodFile();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (z) {
            long size = this.downloadInfo.getSize();
            int eachDownloadThread = this.config.getEachDownloadThread();
            long j2 = size / ((long) eachDownloadThread);
            int i = 0;
            while (i < eachDownloadThread) {
                long j3 = j2 * ((long) i);
                com.dcloud.android.downloader.domain.DownloadThreadInfo downloadThreadInfo = new com.dcloud.android.downloader.domain.DownloadThreadInfo(i, this.downloadInfo.getId(), this.downloadInfo.getDownloadUrl(), j3, i == eachDownloadThread + (-1) ? size : (j3 + j2) - 1);
                arrayList.add(downloadThreadInfo);
                com.dcloud.android.downloader.core.thread.DownloadThread downloadThread = new com.dcloud.android.downloader.core.thread.DownloadThread(downloadThreadInfo, this.downloadResponse, this.config, this.downloadInfo, this);
                this.executorService.submit(downloadThread);
                this.downloadThreads.add(downloadThread);
                i++;
            }
        } else {
            com.dcloud.android.downloader.domain.DownloadThreadInfo downloadThreadInfo2 = new com.dcloud.android.downloader.domain.DownloadThreadInfo(0, this.downloadInfo.getId(), this.downloadInfo.getDownloadUrl(), 0L, this.downloadInfo.getSize());
            arrayList.add(downloadThreadInfo2);
            com.dcloud.android.downloader.core.thread.DownloadThread downloadThread2 = new com.dcloud.android.downloader.core.thread.DownloadThread(downloadThreadInfo2, this.downloadResponse, this.config, this.downloadInfo, this);
            this.executorService.submit(downloadThread2);
            this.downloadThreads.add(downloadThread2);
        }
        this.downloadInfo.setDownloadThreadInfos(arrayList);
        this.downloadInfo.setStatus(2);
        this.downloadResponse.onStatusChanged(this.downloadInfo);
    }

    @Override // com.dcloud.android.downloader.core.task.DownloadTask
    public void start() {
        if (this.downloadInfo.getSize() <= 0) {
            getFileInfo();
            return;
        }
        java.util.Iterator<com.dcloud.android.downloader.domain.DownloadThreadInfo> it = this.downloadInfo.getDownloadThreadInfos().iterator();
        while (it.hasNext()) {
            com.dcloud.android.downloader.core.thread.DownloadThread downloadThread = new com.dcloud.android.downloader.core.thread.DownloadThread(it.next(), this.downloadResponse, this.config, this.downloadInfo, this);
            this.executorService.submit(downloadThread);
            this.downloadThreads.add(downloadThread);
        }
        this.downloadInfo.setStatus(2);
        this.downloadResponse.onStatusChanged(this.downloadInfo);
    }
}
