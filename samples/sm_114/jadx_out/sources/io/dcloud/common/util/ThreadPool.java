package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ThreadPool {
    private static final int MAX_COUNT = 3;
    java.util.concurrent.ExecutorService newFixedThreadPool;
    java.util.concurrent.ExecutorService singleThreadPool;
    java.util.concurrent.ThreadPoolExecutor threadPool;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class ThreadPoolHolder {
        static io.dcloud.common.util.ThreadPool mInstance = new io.dcloud.common.util.ThreadPool();

        ThreadPoolHolder() {
        }
    }

    public static io.dcloud.common.util.ThreadPool self() {
        return io.dcloud.common.util.ThreadPool.ThreadPoolHolder.mInstance;
    }

    public synchronized void addSingleThreadTask(java.lang.Runnable runnable) {
        java.util.concurrent.ExecutorService executorService = this.singleThreadPool;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }

    public synchronized void addThreadTask(java.lang.Runnable runnable) {
        addThreadTask(runnable, false);
    }

    private ThreadPool() {
        this.threadPool = null;
        this.singleThreadPool = null;
        this.newFixedThreadPool = null;
        this.threadPool = new java.util.concurrent.ThreadPoolExecutor(3, 3, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());
        this.newFixedThreadPool = new java.util.concurrent.ThreadPoolExecutor(3, 50, 300L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.LinkedBlockingQueue());
        this.singleThreadPool = java.util.concurrent.Executors.newSingleThreadExecutor();
    }

    public synchronized void addThreadTask(java.lang.Runnable runnable, boolean z) {
        try {
            if (z) {
                this.newFixedThreadPool.execute(runnable);
            } else {
                this.threadPool.execute(runnable);
            }
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }
}
