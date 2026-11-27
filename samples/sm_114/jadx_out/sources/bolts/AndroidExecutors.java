package bolts;

/* JADX INFO: loaded from: classes.dex */
final class AndroidExecutors {
    static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final bolts.AndroidExecutors INSTANCE = new bolts.AndroidExecutors();
    static final long KEEP_ALIVE_TIME = 1;
    static final int MAX_POOL_SIZE;
    private final java.util.concurrent.Executor uiThread = new bolts.AndroidExecutors.UIThreadExecutor();

    static {
        int iAvailableProcessors = java.lang.Runtime.getRuntime().availableProcessors();
        CPU_COUNT = iAvailableProcessors;
        CORE_POOL_SIZE = iAvailableProcessors + 1;
        MAX_POOL_SIZE = (iAvailableProcessors * 2) + 1;
    }

    private AndroidExecutors() {
    }

    public static java.util.concurrent.ExecutorService newCachedThreadPool() {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 1L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());
        allowCoreThreadTimeout(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    public static java.util.concurrent.ExecutorService newCachedThreadPool(java.util.concurrent.ThreadFactory threadFactory) {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 1L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), threadFactory);
        allowCoreThreadTimeout(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    public static void allowCoreThreadTimeout(java.util.concurrent.ThreadPoolExecutor threadPoolExecutor, boolean z) {
        threadPoolExecutor.allowCoreThreadTimeOut(z);
    }

    public static java.util.concurrent.Executor uiThread() {
        return INSTANCE.uiThread;
    }

    private static class UIThreadExecutor implements java.util.concurrent.Executor {
        private UIThreadExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(java.lang.Runnable runnable) {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(runnable);
        }
    }
}
