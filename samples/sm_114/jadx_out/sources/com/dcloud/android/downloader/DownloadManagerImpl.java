package com.dcloud.android.downloader;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class DownloadManagerImpl implements com.dcloud.android.downloader.callback.DCDownloadManager, com.dcloud.android.downloader.core.DownloadTaskImpl.DownloadTaskListener {
    private static final int MIN_EXECUTE_INTERVAL = 500;
    private static com.dcloud.android.downloader.DownloadManagerImpl instance;
    private final java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.dcloud.android.downloader.core.task.DownloadTask> cacheDownloadTask;
    private final com.dcloud.android.downloader.config.Config config;
    private final android.content.Context context;
    private final com.dcloud.android.downloader.db.DownloadDBController downloadDBController;
    private final com.dcloud.android.downloader.core.DownloadResponse downloadResponse;
    private final java.util.List<com.dcloud.android.downloader.domain.DownloadInfo> downloadingCaches;
    private final java.util.concurrent.ExecutorService executorService;
    private long lastExecuteTime;

    private DownloadManagerImpl(android.content.Context context, com.dcloud.android.downloader.config.Config config) {
        this.context = context;
        config = config == null ? new com.dcloud.android.downloader.config.Config() : config;
        this.config = config;
        if (config.getDownloadDBController() == null) {
            this.downloadDBController = new com.dcloud.android.downloader.db.DefaultDownloadDBController(context, config);
        } else {
            this.downloadDBController = config.getDownloadDBController();
        }
        if (this.downloadDBController.findAllDownloading() == null) {
            this.downloadingCaches = new java.util.ArrayList();
        } else {
            this.downloadingCaches = this.downloadDBController.findAllDownloading();
        }
        this.cacheDownloadTask = new java.util.concurrent.ConcurrentHashMap<>();
        this.downloadDBController.pauseAllDownloading();
        this.executorService = java.util.concurrent.Executors.newFixedThreadPool(config.getDownloadThread());
        this.downloadResponse = new com.dcloud.android.downloader.core.DownloadResponseImpl(this.downloadDBController);
    }

    public static com.dcloud.android.downloader.callback.DCDownloadManager getInstance(android.content.Context context, com.dcloud.android.downloader.config.Config config) {
        synchronized (com.dcloud.android.downloader.DownloadManagerImpl.class) {
            if (instance == null) {
                instance = new com.dcloud.android.downloader.DownloadManagerImpl(context, config);
            }
        }
        return instance;
    }

    private void prepareDownload(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo) {
        if (this.cacheDownloadTask.size() >= this.config.getDownloadThread()) {
            downloadInfo.setStatus(3);
            this.downloadResponse.onStatusChanged(downloadInfo);
            return;
        }
        com.dcloud.android.downloader.core.DownloadTaskImpl downloadTaskImpl = new com.dcloud.android.downloader.core.DownloadTaskImpl(this.executorService, this.downloadResponse, downloadInfo, this.config, this);
        this.cacheDownloadTask.put(java.lang.Integer.valueOf(downloadInfo.getId()), downloadTaskImpl);
        downloadInfo.setStatus(1);
        this.downloadResponse.onStatusChanged(downloadInfo);
        downloadTaskImpl.start();
    }

    private void prepareDownloadNextTask() {
        for (com.dcloud.android.downloader.domain.DownloadInfo downloadInfo : this.downloadingCaches) {
            if (downloadInfo.getStatus() == 3) {
                prepareDownload(downloadInfo);
                return;
            }
        }
    }

    @Override // com.dcloud.android.downloader.callback.DCDownloadManager
    public void download(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo) {
        this.downloadingCaches.add(downloadInfo);
        prepareDownload(downloadInfo);
    }

    @Override // com.dcloud.android.downloader.callback.DCDownloadManager
    public java.util.List<com.dcloud.android.downloader.domain.DownloadInfo> findAllDownloaded() {
        return this.downloadDBController.findAllDownloaded();
    }

    @Override // com.dcloud.android.downloader.callback.DCDownloadManager
    public java.util.List<com.dcloud.android.downloader.domain.DownloadInfo> findAllDownloading() {
        return this.downloadingCaches;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001c  */
    /* JADX WARN: Code duplicated, block: B:12:0x0023 A[RETURN] */
    @Override // com.dcloud.android.downloader.callback.DCDownloadManager
    public com.dcloud.android.downloader.domain.DownloadInfo getDownloadById(int i) {
        for (com.dcloud.android.downloader.domain.DownloadInfo downloadInfo : this.downloadingCaches) {
            if (downloadInfo.getId() == i) {
                if (downloadInfo == null) {
                    return this.downloadDBController.findDownloadedInfoById(i);
                }
                return downloadInfo;
            }
        }
        downloadInfo = null;
        if (downloadInfo == null) {
            return this.downloadDBController.findDownloadedInfoById(i);
        }
        return downloadInfo;
    }

    @Override // com.dcloud.android.downloader.callback.DCDownloadManager
    public com.dcloud.android.downloader.db.DownloadDBController getDownloadDBController() {
        return this.downloadDBController;
    }

    public boolean isExecute() {
        if (java.lang.System.currentTimeMillis() - this.lastExecuteTime <= 500) {
            return false;
        }
        this.lastExecuteTime = java.lang.System.currentTimeMillis();
        return true;
    }

    @Override // com.dcloud.android.downloader.callback.DCDownloadManager
    public void onDestroy() {
    }

    @Override // com.dcloud.android.downloader.core.DownloadTaskImpl.DownloadTaskListener
    public void onDownloadSuccess(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo) {
        this.cacheDownloadTask.remove(java.lang.Integer.valueOf(downloadInfo.getId()));
        this.downloadingCaches.remove(downloadInfo);
        prepareDownloadNextTask();
    }

    @Override // com.dcloud.android.downloader.callback.DCDownloadManager
    public void pause(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo) {
        if (isExecute()) {
            downloadInfo.setStatus(4);
            this.cacheDownloadTask.remove(java.lang.Integer.valueOf(downloadInfo.getId()));
            this.downloadResponse.onStatusChanged(downloadInfo);
            prepareDownloadNextTask();
        }
    }

    @Override // com.dcloud.android.downloader.callback.DCDownloadManager
    public void remove(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo) {
        downloadInfo.setStatus(7);
        this.cacheDownloadTask.remove(java.lang.Integer.valueOf(downloadInfo.getId()));
        this.downloadingCaches.remove(downloadInfo);
        this.downloadDBController.delete(downloadInfo);
        this.downloadResponse.onStatusChanged(downloadInfo);
    }

    @Override // com.dcloud.android.downloader.callback.DCDownloadManager
    public void resume(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo) {
        if (isExecute()) {
            this.cacheDownloadTask.remove(java.lang.Integer.valueOf(downloadInfo.getId()));
            prepareDownload(downloadInfo);
        }
    }
}
