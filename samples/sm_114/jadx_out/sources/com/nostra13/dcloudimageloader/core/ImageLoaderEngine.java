package com.nostra13.dcloudimageloader.core;

/* JADX INFO: loaded from: classes.dex */
class ImageLoaderEngine {
    final com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration configuration;
    private java.util.concurrent.Executor taskExecutor;
    private java.util.concurrent.Executor taskExecutorForCachedImages;
    private final java.util.Map<java.lang.Integer, java.lang.String> cacheKeysForImageAwares = java.util.Collections.synchronizedMap(new java.util.HashMap());
    private final java.util.Map<java.lang.String, java.util.concurrent.locks.ReentrantLock> uriLocks = new java.util.WeakHashMap();
    private final java.util.concurrent.atomic.AtomicBoolean paused = new java.util.concurrent.atomic.AtomicBoolean(false);
    private final java.util.concurrent.atomic.AtomicBoolean networkDenied = new java.util.concurrent.atomic.AtomicBoolean(false);
    private final java.util.concurrent.atomic.AtomicBoolean slowNetwork = new java.util.concurrent.atomic.AtomicBoolean(false);
    private java.util.concurrent.ExecutorService taskDistributor = java.util.concurrent.Executors.newCachedThreadPool();

    ImageLoaderEngine(com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration imageLoaderConfiguration) {
        this.configuration = imageLoaderConfiguration;
        this.taskExecutor = imageLoaderConfiguration.taskExecutor;
        this.taskExecutorForCachedImages = imageLoaderConfiguration.taskExecutorForCachedImages;
    }

    void submit(final com.nostra13.dcloudimageloader.core.LoadAndDisplayImageTask loadAndDisplayImageTask) {
        this.taskDistributor.execute(new java.lang.Runnable() { // from class: com.nostra13.dcloudimageloader.core.ImageLoaderEngine.1
            @Override // java.lang.Runnable
            public void run() {
                boolean zExists = com.nostra13.dcloudimageloader.core.ImageLoaderEngine.this.configuration.discCache.get(loadAndDisplayImageTask.getLoadingUri()).exists();
                com.nostra13.dcloudimageloader.core.ImageLoaderEngine.this.initExecutorsIfNeed();
                if (zExists) {
                    com.nostra13.dcloudimageloader.core.ImageLoaderEngine.this.taskExecutorForCachedImages.execute(loadAndDisplayImageTask);
                } else {
                    com.nostra13.dcloudimageloader.core.ImageLoaderEngine.this.taskExecutor.execute(loadAndDisplayImageTask);
                }
            }
        });
    }

    void submit(com.nostra13.dcloudimageloader.core.ProcessAndDisplayImageTask processAndDisplayImageTask) {
        initExecutorsIfNeed();
        this.taskExecutorForCachedImages.execute(processAndDisplayImageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initExecutorsIfNeed() {
        if (!this.configuration.customExecutor && ((java.util.concurrent.ExecutorService) this.taskExecutor).isShutdown()) {
            this.taskExecutor = createTaskExecutor();
        }
        if (this.configuration.customExecutorForCachedImages || !((java.util.concurrent.ExecutorService) this.taskExecutorForCachedImages).isShutdown()) {
            return;
        }
        this.taskExecutorForCachedImages = createTaskExecutor();
    }

    private java.util.concurrent.Executor createTaskExecutor() {
        return com.nostra13.dcloudimageloader.core.DefaultConfigurationFactory.createExecutor(this.configuration.threadPoolSize, this.configuration.threadPriority, this.configuration.tasksProcessingType);
    }

    java.lang.String getLoadingUriForView(com.nostra13.dcloudimageloader.core.imageaware.ImageAware imageAware) {
        return this.cacheKeysForImageAwares.get(java.lang.Integer.valueOf(imageAware.getId()));
    }

    void prepareDisplayTaskFor(com.nostra13.dcloudimageloader.core.imageaware.ImageAware imageAware, java.lang.String str) {
        this.cacheKeysForImageAwares.put(java.lang.Integer.valueOf(imageAware.getId()), str);
    }

    void cancelDisplayTaskFor(com.nostra13.dcloudimageloader.core.imageaware.ImageAware imageAware) {
        this.cacheKeysForImageAwares.remove(java.lang.Integer.valueOf(imageAware.getId()));
    }

    void denyNetworkDownloads(boolean z) {
        this.networkDenied.set(z);
    }

    void handleSlowNetwork(boolean z) {
        this.slowNetwork.set(z);
    }

    void pause() {
        this.paused.set(true);
    }

    void resume() {
        synchronized (this.paused) {
            this.paused.set(false);
            this.paused.notifyAll();
        }
    }

    void stop() {
        if (!this.configuration.customExecutor) {
            ((java.util.concurrent.ExecutorService) this.taskExecutor).shutdownNow();
        }
        if (!this.configuration.customExecutorForCachedImages) {
            ((java.util.concurrent.ExecutorService) this.taskExecutorForCachedImages).shutdownNow();
        }
        this.cacheKeysForImageAwares.clear();
        this.uriLocks.clear();
    }

    java.util.concurrent.locks.ReentrantLock getLockForUri(java.lang.String str) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.uriLocks.get(str);
        if (reentrantLock != null) {
            return reentrantLock;
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock2 = new java.util.concurrent.locks.ReentrantLock();
        this.uriLocks.put(str, reentrantLock2);
        return reentrantLock2;
    }

    java.util.concurrent.atomic.AtomicBoolean getPause() {
        return this.paused;
    }

    boolean isNetworkDenied() {
        return this.networkDenied.get();
    }

    boolean isSlowNetwork() {
        return this.slowNetwork.get();
    }
}
