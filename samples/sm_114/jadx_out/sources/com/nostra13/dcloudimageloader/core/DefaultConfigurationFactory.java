package com.nostra13.dcloudimageloader.core;

/* JADX INFO: loaded from: classes.dex */
public class DefaultConfigurationFactory {
    public static java.util.concurrent.Executor createExecutor(int i, int i2, com.nostra13.dcloudimageloader.core.assist.QueueProcessingType queueProcessingType) {
        return new java.util.concurrent.ThreadPoolExecutor(i, i, 0L, java.util.concurrent.TimeUnit.MILLISECONDS, (java.util.concurrent.BlockingQueue<java.lang.Runnable>) (queueProcessingType == com.nostra13.dcloudimageloader.core.assist.QueueProcessingType.LIFO ? new com.nostra13.dcloudimageloader.core.assist.deque.LIFOLinkedBlockingDeque() : new java.util.concurrent.LinkedBlockingQueue()), createThreadFactory(i2));
    }

    public static com.nostra13.dcloudimageloader.cache.disc.naming.FileNameGenerator createFileNameGenerator() {
        return new com.nostra13.dcloudimageloader.cache.disc.naming.HashCodeFileNameGenerator();
    }

    public static com.nostra13.dcloudimageloader.cache.disc.DiscCacheAware createDiscCache(android.content.Context context, com.nostra13.dcloudimageloader.cache.disc.naming.FileNameGenerator fileNameGenerator, int i, int i2) {
        if (i > 0) {
            return new com.nostra13.dcloudimageloader.cache.disc.impl.TotalSizeLimitedDiscCache(com.nostra13.dcloudimageloader.utils.StorageUtils.getIndividualCacheDirectory(context), fileNameGenerator, i);
        }
        if (i2 > 0) {
            return new com.nostra13.dcloudimageloader.cache.disc.impl.FileCountLimitedDiscCache(com.nostra13.dcloudimageloader.utils.StorageUtils.getIndividualCacheDirectory(context), fileNameGenerator, i2);
        }
        return new com.nostra13.dcloudimageloader.cache.disc.impl.UnlimitedDiscCache(com.nostra13.dcloudimageloader.utils.StorageUtils.getCacheDirectory(context), fileNameGenerator);
    }

    public static com.nostra13.dcloudimageloader.cache.disc.DiscCacheAware createReserveDiscCache(java.io.File file) {
        java.io.File file2 = new java.io.File(file, "uil-images");
        if (file2.exists() || file2.mkdir()) {
            file = file2;
        }
        return new com.nostra13.dcloudimageloader.cache.disc.impl.TotalSizeLimitedDiscCache(file, 2097152);
    }

    public static com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware createMemoryCache(int i) {
        if (i == 0) {
            i = (int) (java.lang.Runtime.getRuntime().maxMemory() / 8);
        }
        return new com.nostra13.dcloudimageloader.cache.memory.impl.LruMemoryCache(i);
    }

    public static com.nostra13.dcloudimageloader.core.download.ImageDownloader createImageDownloader(android.content.Context context) {
        return new com.nostra13.dcloudimageloader.core.download.BaseImageDownloader(context);
    }

    public static com.nostra13.dcloudimageloader.core.decode.ImageDecoder createImageDecoder(boolean z) {
        return new com.nostra13.dcloudimageloader.core.decode.BaseImageDecoder(z);
    }

    public static com.nostra13.dcloudimageloader.core.display.BitmapDisplayer createBitmapDisplayer() {
        return new com.nostra13.dcloudimageloader.core.display.SimpleBitmapDisplayer();
    }

    private static java.util.concurrent.ThreadFactory createThreadFactory(int i) {
        return new com.nostra13.dcloudimageloader.core.DefaultConfigurationFactory.DefaultThreadFactory(i);
    }

    private static class DefaultThreadFactory implements java.util.concurrent.ThreadFactory {
        private static final java.util.concurrent.atomic.AtomicInteger poolNumber = new java.util.concurrent.atomic.AtomicInteger(1);
        private final java.lang.ThreadGroup group;
        private final java.lang.String namePrefix;
        private final java.util.concurrent.atomic.AtomicInteger threadNumber = new java.util.concurrent.atomic.AtomicInteger(1);
        private final int threadPriority;

        DefaultThreadFactory(int i) {
            this.threadPriority = i;
            java.lang.SecurityManager securityManager = java.lang.System.getSecurityManager();
            this.group = securityManager != null ? securityManager.getThreadGroup() : java.lang.Thread.currentThread().getThreadGroup();
            this.namePrefix = "uil-pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.threadPriority);
            return thread;
        }
    }
}
