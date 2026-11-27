package com.nostra13.dcloudimageloader.core;

/* JADX INFO: loaded from: classes.dex */
public final class ImageLoaderConfiguration {
    final boolean customExecutor;
    final boolean customExecutorForCachedImages;
    final com.nostra13.dcloudimageloader.core.decode.ImageDecoder decoder;
    final com.nostra13.dcloudimageloader.core.DisplayImageOptions defaultDisplayImageOptions;
    final com.nostra13.dcloudimageloader.cache.disc.DiscCacheAware discCache;
    final com.nostra13.dcloudimageloader.core.download.ImageDownloader downloader;
    final android.graphics.Bitmap.CompressFormat imageCompressFormatForDiscCache;
    final int imageQualityForDiscCache;
    final int maxImageHeightForDiscCache;
    final int maxImageHeightForMemoryCache;
    final int maxImageWidthForDiscCache;
    final int maxImageWidthForMemoryCache;
    final com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware memoryCache;
    final com.nostra13.dcloudimageloader.core.download.ImageDownloader networkDeniedDownloader;
    final com.nostra13.dcloudimageloader.core.process.BitmapProcessor processorForDiscCache;
    final com.nostra13.dcloudimageloader.cache.disc.DiscCacheAware reserveDiscCache;
    final android.content.res.Resources resources;
    final com.nostra13.dcloudimageloader.core.download.ImageDownloader slowNetworkDownloader;
    final java.util.concurrent.Executor taskExecutor;
    final java.util.concurrent.Executor taskExecutorForCachedImages;
    final com.nostra13.dcloudimageloader.core.assist.QueueProcessingType tasksProcessingType;
    final int threadPoolSize;
    final int threadPriority;
    final boolean writeLogs;

    private ImageLoaderConfiguration(com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder builder) {
        this.resources = builder.context.getResources();
        this.maxImageWidthForMemoryCache = builder.maxImageWidthForMemoryCache;
        this.maxImageHeightForMemoryCache = builder.maxImageHeightForMemoryCache;
        this.maxImageWidthForDiscCache = builder.maxImageWidthForDiscCache;
        this.maxImageHeightForDiscCache = builder.maxImageHeightForDiscCache;
        this.imageCompressFormatForDiscCache = builder.imageCompressFormatForDiscCache;
        this.imageQualityForDiscCache = builder.imageQualityForDiscCache;
        this.processorForDiscCache = builder.processorForDiscCache;
        this.taskExecutor = builder.taskExecutor;
        this.taskExecutorForCachedImages = builder.taskExecutorForCachedImages;
        this.threadPoolSize = builder.threadPoolSize;
        this.threadPriority = builder.threadPriority;
        this.tasksProcessingType = builder.tasksProcessingType;
        this.discCache = builder.discCache;
        this.memoryCache = builder.memoryCache;
        this.defaultDisplayImageOptions = builder.defaultDisplayImageOptions;
        this.writeLogs = builder.writeLogs;
        com.nostra13.dcloudimageloader.core.download.ImageDownloader imageDownloader = builder.downloader;
        this.downloader = imageDownloader;
        this.decoder = builder.decoder;
        this.customExecutor = builder.customExecutor;
        this.customExecutorForCachedImages = builder.customExecutorForCachedImages;
        this.networkDeniedDownloader = new com.nostra13.dcloudimageloader.core.download.NetworkDeniedImageDownloader(imageDownloader);
        this.slowNetworkDownloader = new com.nostra13.dcloudimageloader.core.download.SlowNetworkImageDownloader(imageDownloader);
        this.reserveDiscCache = com.nostra13.dcloudimageloader.core.DefaultConfigurationFactory.createReserveDiscCache(com.nostra13.dcloudimageloader.utils.StorageUtils.getCacheDirectory(builder.context, false));
    }

    public static com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration createDefault(android.content.Context context) {
        return new com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder(context).build();
    }

    com.nostra13.dcloudimageloader.core.assist.ImageSize getMaxImageSize() {
        android.util.DisplayMetrics displayMetrics = this.resources.getDisplayMetrics();
        int i = this.maxImageWidthForMemoryCache;
        if (i <= 0) {
            i = displayMetrics.widthPixels;
        }
        int i2 = this.maxImageHeightForMemoryCache;
        if (i2 <= 0) {
            i2 = displayMetrics.heightPixels;
        }
        return new com.nostra13.dcloudimageloader.core.assist.ImageSize(i, i2);
    }

    public static class Builder {
        public static final com.nostra13.dcloudimageloader.core.assist.QueueProcessingType DEFAULT_TASK_PROCESSING_TYPE = com.nostra13.dcloudimageloader.core.assist.QueueProcessingType.FIFO;
        public static final int DEFAULT_THREAD_POOL_SIZE = 3;
        public static final int DEFAULT_THREAD_PRIORITY = 4;
        private static final java.lang.String WARNING_OVERLAP_DISC_CACHE_NAME_GENERATOR = "discCache() and discCacheFileNameGenerator() calls overlap each other";
        private static final java.lang.String WARNING_OVERLAP_DISC_CACHE_PARAMS = "discCache(), discCacheSize() and discCacheFileCount calls overlap each other";
        private static final java.lang.String WARNING_OVERLAP_EXECUTOR = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.";
        private static final java.lang.String WARNING_OVERLAP_MEMORY_CACHE = "memoryCache() and memoryCacheSize() calls overlap each other";
        private android.content.Context context;
        private com.nostra13.dcloudimageloader.core.decode.ImageDecoder decoder;
        private int maxImageWidthForMemoryCache = 0;
        private int maxImageHeightForMemoryCache = 0;
        private int maxImageWidthForDiscCache = 0;
        private int maxImageHeightForDiscCache = 0;
        private android.graphics.Bitmap.CompressFormat imageCompressFormatForDiscCache = null;
        private int imageQualityForDiscCache = 0;
        private com.nostra13.dcloudimageloader.core.process.BitmapProcessor processorForDiscCache = null;
        private java.util.concurrent.Executor taskExecutor = null;
        private java.util.concurrent.Executor taskExecutorForCachedImages = null;
        private boolean customExecutor = false;
        private boolean customExecutorForCachedImages = false;
        private int threadPoolSize = 3;
        private int threadPriority = 4;
        private boolean denyCacheImageMultipleSizesInMemory = false;
        private com.nostra13.dcloudimageloader.core.assist.QueueProcessingType tasksProcessingType = DEFAULT_TASK_PROCESSING_TYPE;
        private int memoryCacheSize = 0;
        private int discCacheSize = 0;
        private int discCacheFileCount = 0;
        private com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware memoryCache = null;
        private com.nostra13.dcloudimageloader.cache.disc.DiscCacheAware discCache = null;
        private com.nostra13.dcloudimageloader.cache.disc.naming.FileNameGenerator discCacheFileNameGenerator = null;
        private com.nostra13.dcloudimageloader.core.download.ImageDownloader downloader = null;
        private com.nostra13.dcloudimageloader.core.DisplayImageOptions defaultDisplayImageOptions = null;
        private boolean writeLogs = false;

        public Builder(android.content.Context context) {
            this.context = context.getApplicationContext();
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder memoryCacheExtraOptions(int i, int i2) {
            this.maxImageWidthForMemoryCache = i;
            this.maxImageHeightForMemoryCache = i2;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder discCacheExtraOptions(int i, int i2, android.graphics.Bitmap.CompressFormat compressFormat, int i3, com.nostra13.dcloudimageloader.core.process.BitmapProcessor bitmapProcessor) {
            this.maxImageWidthForDiscCache = i;
            this.maxImageHeightForDiscCache = i2;
            this.imageCompressFormatForDiscCache = compressFormat;
            this.imageQualityForDiscCache = i3;
            this.processorForDiscCache = bitmapProcessor;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder taskExecutor(java.util.concurrent.Executor executor) {
            if (this.threadPoolSize != 3 || this.threadPriority != 4 || this.tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE) {
                com.nostra13.dcloudimageloader.utils.L.w(WARNING_OVERLAP_EXECUTOR, new java.lang.Object[0]);
            }
            this.taskExecutor = executor;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder taskExecutorForCachedImages(java.util.concurrent.Executor executor) {
            if (this.threadPoolSize != 3 || this.threadPriority != 4 || this.tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE) {
                com.nostra13.dcloudimageloader.utils.L.w(WARNING_OVERLAP_EXECUTOR, new java.lang.Object[0]);
            }
            this.taskExecutorForCachedImages = executor;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder threadPoolSize(int i) {
            if (this.taskExecutor != null || this.taskExecutorForCachedImages != null) {
                com.nostra13.dcloudimageloader.utils.L.w(WARNING_OVERLAP_EXECUTOR, new java.lang.Object[0]);
            }
            this.threadPoolSize = i;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder threadPriority(int i) {
            if (this.taskExecutor != null || this.taskExecutorForCachedImages != null) {
                com.nostra13.dcloudimageloader.utils.L.w(WARNING_OVERLAP_EXECUTOR, new java.lang.Object[0]);
            }
            if (i < 1) {
                this.threadPriority = 1;
                return this;
            }
            if (i > 10) {
                this.threadPriority = 10;
                return this;
            }
            this.threadPriority = i;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder denyCacheImageMultipleSizesInMemory() {
            this.denyCacheImageMultipleSizesInMemory = true;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder tasksProcessingOrder(com.nostra13.dcloudimageloader.core.assist.QueueProcessingType queueProcessingType) {
            if (this.taskExecutor != null || this.taskExecutorForCachedImages != null) {
                com.nostra13.dcloudimageloader.utils.L.w(WARNING_OVERLAP_EXECUTOR, new java.lang.Object[0]);
            }
            this.tasksProcessingType = queueProcessingType;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder memoryCacheSize(int i) {
            if (i <= 0) {
                throw new java.lang.IllegalArgumentException("memoryCacheSize must be a positive number");
            }
            if (this.memoryCache != null) {
                com.nostra13.dcloudimageloader.utils.L.w(WARNING_OVERLAP_MEMORY_CACHE, new java.lang.Object[0]);
            }
            this.memoryCacheSize = i;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder memoryCacheSizePercentage(int i) {
            if (i > 0 && i < 100) {
                if (this.memoryCache != null) {
                    com.nostra13.dcloudimageloader.utils.L.w(WARNING_OVERLAP_MEMORY_CACHE, new java.lang.Object[0]);
                }
                this.memoryCacheSize = (int) (java.lang.Runtime.getRuntime().maxMemory() * (i / 100.0f));
                return this;
            }
            throw new java.lang.IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder memoryCache(com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware memoryCacheAware) {
            if (this.memoryCacheSize != 0) {
                com.nostra13.dcloudimageloader.utils.L.w(WARNING_OVERLAP_MEMORY_CACHE, new java.lang.Object[0]);
            }
            this.memoryCache = memoryCacheAware;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder discCacheSize(int i) {
            if (i <= 0) {
                throw new java.lang.IllegalArgumentException("maxCacheSize must be a positive number");
            }
            if (this.discCache != null || this.discCacheFileCount > 0) {
                com.nostra13.dcloudimageloader.utils.L.w(WARNING_OVERLAP_DISC_CACHE_PARAMS, new java.lang.Object[0]);
            }
            this.discCacheSize = i;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder discCacheFileCount(int i) {
            if (i <= 0) {
                throw new java.lang.IllegalArgumentException("maxFileCount must be a positive number");
            }
            if (this.discCache != null || this.discCacheSize > 0) {
                com.nostra13.dcloudimageloader.utils.L.w(WARNING_OVERLAP_DISC_CACHE_PARAMS, new java.lang.Object[0]);
            }
            this.discCacheSize = 0;
            this.discCacheFileCount = i;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder discCacheFileNameGenerator(com.nostra13.dcloudimageloader.cache.disc.naming.FileNameGenerator fileNameGenerator) {
            if (this.discCache != null) {
                com.nostra13.dcloudimageloader.utils.L.w(WARNING_OVERLAP_DISC_CACHE_NAME_GENERATOR, new java.lang.Object[0]);
            }
            this.discCacheFileNameGenerator = fileNameGenerator;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder imageDownloader(com.nostra13.dcloudimageloader.core.download.ImageDownloader imageDownloader) {
            this.downloader = imageDownloader;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder imageDecoder(com.nostra13.dcloudimageloader.core.decode.ImageDecoder imageDecoder) {
            this.decoder = imageDecoder;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder discCache(com.nostra13.dcloudimageloader.cache.disc.DiscCacheAware discCacheAware) {
            if (this.discCacheSize > 0 || this.discCacheFileCount > 0) {
                com.nostra13.dcloudimageloader.utils.L.w(WARNING_OVERLAP_DISC_CACHE_PARAMS, new java.lang.Object[0]);
            }
            if (this.discCacheFileNameGenerator != null) {
                com.nostra13.dcloudimageloader.utils.L.w(WARNING_OVERLAP_DISC_CACHE_NAME_GENERATOR, new java.lang.Object[0]);
            }
            this.discCache = discCacheAware;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder defaultDisplayImageOptions(com.nostra13.dcloudimageloader.core.DisplayImageOptions displayImageOptions) {
            this.defaultDisplayImageOptions = displayImageOptions;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration.Builder writeDebugLogs() {
            this.writeLogs = true;
            return this;
        }

        public com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration build() {
            initEmptyFieldsWithDefaultValues();
            return new com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration(this);
        }

        private void initEmptyFieldsWithDefaultValues() {
            if (this.taskExecutor == null) {
                this.taskExecutor = com.nostra13.dcloudimageloader.core.DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
            } else {
                this.customExecutor = true;
            }
            if (this.taskExecutorForCachedImages == null) {
                this.taskExecutorForCachedImages = com.nostra13.dcloudimageloader.core.DefaultConfigurationFactory.createExecutor(this.threadPoolSize, this.threadPriority, this.tasksProcessingType);
            } else {
                this.customExecutorForCachedImages = true;
            }
            if (this.discCache == null) {
                if (this.discCacheFileNameGenerator == null) {
                    this.discCacheFileNameGenerator = com.nostra13.dcloudimageloader.core.DefaultConfigurationFactory.createFileNameGenerator();
                }
                this.discCache = com.nostra13.dcloudimageloader.core.DefaultConfigurationFactory.createDiscCache(this.context, this.discCacheFileNameGenerator, this.discCacheSize, this.discCacheFileCount);
            }
            if (this.memoryCache == null) {
                this.memoryCache = com.nostra13.dcloudimageloader.core.DefaultConfigurationFactory.createMemoryCache(this.memoryCacheSize);
            }
            if (this.denyCacheImageMultipleSizesInMemory) {
                this.memoryCache = new com.nostra13.dcloudimageloader.cache.memory.impl.FuzzyKeyMemoryCache(this.memoryCache, com.nostra13.dcloudimageloader.core.assist.MemoryCacheUtil.createFuzzyKeyComparator());
            }
            if (this.downloader == null) {
                this.downloader = com.nostra13.dcloudimageloader.core.DefaultConfigurationFactory.createImageDownloader(this.context);
            }
            if (this.decoder == null) {
                this.decoder = com.nostra13.dcloudimageloader.core.DefaultConfigurationFactory.createImageDecoder(this.writeLogs);
            }
            if (this.defaultDisplayImageOptions == null) {
                this.defaultDisplayImageOptions = com.nostra13.dcloudimageloader.core.DisplayImageOptions.createSimple();
            }
        }
    }
}
