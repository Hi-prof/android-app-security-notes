package com.nostra13.dcloudimageloader.core;

/* JADX INFO: loaded from: classes.dex */
public class ImageLoader {
    private static final java.lang.String ERROR_INIT_CONFIG_WITH_NULL = "ImageLoader configuration can not be initialized with null";
    private static final java.lang.String ERROR_NOT_INIT = "ImageLoader must be init with configuration before using";
    private static final java.lang.String ERROR_WRONG_ARGUMENTS = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";
    static final java.lang.String LOG_DESTROY = "Destroy ImageLoader";
    static final java.lang.String LOG_INIT_CONFIG = "Initialize ImageLoader with configuration";
    static final java.lang.String LOG_LOAD_IMAGE_FROM_MEMORY_CACHE = "Load image from memory cache [%s]";
    public static final java.lang.String TAG = "ImageLoader";
    private static final java.lang.String WARNING_RE_INIT_CONFIG = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";
    private static volatile com.nostra13.dcloudimageloader.core.ImageLoader instance;
    private com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration configuration;
    private final com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener emptyListener = new com.nostra13.dcloudimageloader.core.assist.SimpleImageLoadingListener();
    private com.nostra13.dcloudimageloader.core.ImageLoaderEngine engine;

    public static com.nostra13.dcloudimageloader.core.ImageLoader getInstance() {
        if (instance == null) {
            synchronized (com.nostra13.dcloudimageloader.core.ImageLoader.class) {
                if (instance == null) {
                    instance = new com.nostra13.dcloudimageloader.core.ImageLoader();
                }
            }
        }
        return instance;
    }

    protected ImageLoader() {
    }

    public synchronized void init(com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration imageLoaderConfiguration) {
        try {
            if (imageLoaderConfiguration == null) {
                throw new java.lang.IllegalArgumentException(ERROR_INIT_CONFIG_WITH_NULL);
            }
            if (this.configuration == null) {
                if (imageLoaderConfiguration.writeLogs) {
                    com.nostra13.dcloudimageloader.utils.L.d(LOG_INIT_CONFIG, new java.lang.Object[0]);
                }
                this.engine = new com.nostra13.dcloudimageloader.core.ImageLoaderEngine(imageLoaderConfiguration);
                this.configuration = imageLoaderConfiguration;
            } else {
                com.nostra13.dcloudimageloader.utils.L.w(WARNING_RE_INIT_CONFIG, new java.lang.Object[0]);
            }
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    public boolean isInited() {
        return this.configuration != null;
    }

    public void displayImage(java.lang.String str, com.nostra13.dcloudimageloader.core.imageaware.ImageAware imageAware) {
        displayImage(str, imageAware, (com.nostra13.dcloudimageloader.core.DisplayImageOptions) null, (com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener) null);
    }

    public void displayImage(java.lang.String str, com.nostra13.dcloudimageloader.core.imageaware.ImageAware imageAware, com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener imageLoadingListener) {
        displayImage(str, imageAware, (com.nostra13.dcloudimageloader.core.DisplayImageOptions) null, imageLoadingListener);
    }

    public void displayImage(java.lang.String str, com.nostra13.dcloudimageloader.core.imageaware.ImageAware imageAware, com.nostra13.dcloudimageloader.core.DisplayImageOptions displayImageOptions) {
        displayImage(str, imageAware, displayImageOptions, (com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener) null);
    }

    public void displayImage(java.lang.String str, com.nostra13.dcloudimageloader.core.imageaware.ImageAware imageAware, com.nostra13.dcloudimageloader.core.DisplayImageOptions displayImageOptions, com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener imageLoadingListener) {
        checkConfiguration();
        if (imageAware == null) {
            throw new java.lang.IllegalArgumentException(ERROR_WRONG_ARGUMENTS);
        }
        if (imageLoadingListener == null) {
            imageLoadingListener = this.emptyListener;
        }
        com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener imageLoadingListener2 = imageLoadingListener;
        if (displayImageOptions == null) {
            displayImageOptions = this.configuration.defaultDisplayImageOptions;
        }
        com.nostra13.dcloudimageloader.core.DisplayImageOptions displayImageOptions2 = displayImageOptions;
        if (android.text.TextUtils.isEmpty(str)) {
            this.engine.cancelDisplayTaskFor(imageAware);
            imageLoadingListener2.onLoadingStarted(str, imageAware.getWrappedView());
            if (displayImageOptions2.shouldShowImageForEmptyUri()) {
                imageAware.setImageDrawable(displayImageOptions2.getImageForEmptyUri(this.configuration.resources));
            } else {
                imageAware.setImageDrawable(null);
            }
            imageLoadingListener2.onLoadingComplete(str, imageAware.getWrappedView(), null);
            return;
        }
        com.nostra13.dcloudimageloader.core.assist.ImageSize imageSizeDefineTargetSizeForView = com.nostra13.dcloudimageloader.utils.ImageSizeUtils.defineTargetSizeForView(imageAware, this.configuration.getMaxImageSize());
        java.lang.String strGenerateKey = com.nostra13.dcloudimageloader.core.assist.MemoryCacheUtil.generateKey(str, imageSizeDefineTargetSizeForView);
        this.engine.prepareDisplayTaskFor(imageAware, strGenerateKey);
        imageLoadingListener2.onLoadingStarted(str, imageAware.getWrappedView());
        android.graphics.Bitmap bitmap = this.configuration.memoryCache.get(strGenerateKey);
        if (bitmap != null && !bitmap.isRecycled()) {
            if (this.configuration.writeLogs) {
                com.nostra13.dcloudimageloader.utils.L.d(LOG_LOAD_IMAGE_FROM_MEMORY_CACHE, strGenerateKey);
            }
            if (displayImageOptions2.shouldPostProcess()) {
                com.nostra13.dcloudimageloader.core.ProcessAndDisplayImageTask processAndDisplayImageTask = new com.nostra13.dcloudimageloader.core.ProcessAndDisplayImageTask(this.engine, bitmap, new com.nostra13.dcloudimageloader.core.ImageLoadingInfo(str, imageAware, imageSizeDefineTargetSizeForView, strGenerateKey, displayImageOptions2, imageLoadingListener2, this.engine.getLockForUri(str)), displayImageOptions2.getHandler());
                if (displayImageOptions2.isSyncLoading()) {
                    processAndDisplayImageTask.run();
                    return;
                } else {
                    this.engine.submit(processAndDisplayImageTask);
                    return;
                }
            }
            imageLoadingListener2.onLoadingComplete(str, imageAware.getWrappedView(), displayImageOptions2.getDisplayer().display(bitmap, imageAware, com.nostra13.dcloudimageloader.core.assist.LoadedFrom.MEMORY_CACHE));
            return;
        }
        if (displayImageOptions2.shouldShowImageOnLoading()) {
            imageAware.setImageDrawable(displayImageOptions2.getImageOnLoading(this.configuration.resources));
        } else if (displayImageOptions2.isResetViewBeforeLoading()) {
            imageAware.setImageDrawable(null);
        }
        com.nostra13.dcloudimageloader.core.LoadAndDisplayImageTask loadAndDisplayImageTask = new com.nostra13.dcloudimageloader.core.LoadAndDisplayImageTask(this.engine, new com.nostra13.dcloudimageloader.core.ImageLoadingInfo(str, imageAware, imageSizeDefineTargetSizeForView, strGenerateKey, displayImageOptions2, imageLoadingListener2, this.engine.getLockForUri(str)), displayImageOptions2.getHandler());
        if (displayImageOptions2.isSyncLoading()) {
            loadAndDisplayImageTask.run();
        } else {
            this.engine.submit(loadAndDisplayImageTask);
        }
    }

    public void displayImage(java.lang.String str, android.widget.ImageView imageView) {
        displayImage(str, new com.nostra13.dcloudimageloader.core.imageaware.ImageViewAware(imageView), (com.nostra13.dcloudimageloader.core.DisplayImageOptions) null, (com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener) null);
    }

    public void displayImage(java.lang.String str, android.widget.ImageView imageView, com.nostra13.dcloudimageloader.core.DisplayImageOptions displayImageOptions) {
        displayImage(str, new com.nostra13.dcloudimageloader.core.imageaware.ImageViewAware(imageView), displayImageOptions, (com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener) null);
    }

    public void displayImage(java.lang.String str, android.widget.ImageView imageView, com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener imageLoadingListener) {
        displayImage(str, new com.nostra13.dcloudimageloader.core.imageaware.ImageViewAware(imageView), (com.nostra13.dcloudimageloader.core.DisplayImageOptions) null, imageLoadingListener);
    }

    public void displayImage(java.lang.String str, android.widget.ImageView imageView, com.nostra13.dcloudimageloader.core.DisplayImageOptions displayImageOptions, com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener imageLoadingListener) {
        displayImage(str, new com.nostra13.dcloudimageloader.core.imageaware.ImageViewAware(imageView), displayImageOptions, imageLoadingListener);
    }

    public void loadImage(java.lang.String str, com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener imageLoadingListener) {
        loadImage(str, null, null, imageLoadingListener);
    }

    public void loadImage(java.lang.String str, com.nostra13.dcloudimageloader.core.assist.ImageSize imageSize, com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener imageLoadingListener) {
        loadImage(str, imageSize, null, imageLoadingListener);
    }

    public void loadImage(java.lang.String str, com.nostra13.dcloudimageloader.core.DisplayImageOptions displayImageOptions, com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener imageLoadingListener) {
        loadImage(str, null, displayImageOptions, imageLoadingListener);
    }

    public void loadImage(java.lang.String str, com.nostra13.dcloudimageloader.core.assist.ImageSize imageSize, com.nostra13.dcloudimageloader.core.DisplayImageOptions displayImageOptions, com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener imageLoadingListener) {
        checkConfiguration();
        if (imageSize == null) {
            imageSize = this.configuration.getMaxImageSize();
        }
        if (displayImageOptions == null) {
            displayImageOptions = this.configuration.defaultDisplayImageOptions;
        }
        displayImage(str, new com.nostra13.dcloudimageloader.core.imageaware.ImageNonViewAware(imageSize, com.nostra13.dcloudimageloader.core.assist.ViewScaleType.CROP), displayImageOptions, imageLoadingListener);
    }

    public android.graphics.Bitmap loadImageSync(java.lang.String str) {
        return loadImageSync(str, null, null);
    }

    public android.graphics.Bitmap loadImageSync(java.lang.String str, com.nostra13.dcloudimageloader.core.DisplayImageOptions displayImageOptions) {
        return loadImageSync(str, null, displayImageOptions);
    }

    public android.graphics.Bitmap loadImageSync(java.lang.String str, com.nostra13.dcloudimageloader.core.assist.ImageSize imageSize) {
        return loadImageSync(str, imageSize, null);
    }

    public android.graphics.Bitmap loadImageSync(java.lang.String str, com.nostra13.dcloudimageloader.core.assist.ImageSize imageSize, com.nostra13.dcloudimageloader.core.DisplayImageOptions displayImageOptions) {
        if (displayImageOptions == null) {
            displayImageOptions = this.configuration.defaultDisplayImageOptions;
        }
        com.nostra13.dcloudimageloader.core.DisplayImageOptions displayImageOptionsBuild = new com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder().cloneFrom(displayImageOptions).syncLoading(true).build();
        com.nostra13.dcloudimageloader.core.assist.SyncImageLoadingListener syncImageLoadingListener = new com.nostra13.dcloudimageloader.core.assist.SyncImageLoadingListener();
        loadImage(str, imageSize, displayImageOptionsBuild, syncImageLoadingListener);
        return syncImageLoadingListener.getLoadedBitmap();
    }

    private void checkConfiguration() {
        if (this.configuration == null) {
            throw new java.lang.IllegalStateException(ERROR_NOT_INIT);
        }
    }

    public com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware getMemoryCache() {
        checkConfiguration();
        return this.configuration.memoryCache;
    }

    public void clearMemoryCache() {
        checkConfiguration();
        this.configuration.memoryCache.clear();
    }

    public com.nostra13.dcloudimageloader.cache.disc.DiscCacheAware getDiscCache() {
        checkConfiguration();
        return this.configuration.discCache;
    }

    public void clearDiscCache() {
        checkConfiguration();
        this.configuration.discCache.clear();
    }

    public java.lang.String getLoadingUriForView(com.nostra13.dcloudimageloader.core.imageaware.ImageAware imageAware) {
        return this.engine.getLoadingUriForView(imageAware);
    }

    public java.lang.String getLoadingUriForView(android.widget.ImageView imageView) {
        return this.engine.getLoadingUriForView(new com.nostra13.dcloudimageloader.core.imageaware.ImageViewAware(imageView));
    }

    public void cancelDisplayTask(com.nostra13.dcloudimageloader.core.imageaware.ImageAware imageAware) {
        this.engine.cancelDisplayTaskFor(imageAware);
    }

    public void cancelDisplayTask(android.widget.ImageView imageView) {
        this.engine.cancelDisplayTaskFor(new com.nostra13.dcloudimageloader.core.imageaware.ImageViewAware(imageView));
    }

    public void denyNetworkDownloads(boolean z) {
        this.engine.denyNetworkDownloads(z);
    }

    public void handleSlowNetwork(boolean z) {
        this.engine.handleSlowNetwork(z);
    }

    public void pause() {
        this.engine.pause();
    }

    public void resume() {
        this.engine.resume();
    }

    public void stop() {
        this.engine.stop();
    }

    public void destroy() {
        com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration imageLoaderConfiguration = this.configuration;
        if (imageLoaderConfiguration != null && imageLoaderConfiguration.writeLogs) {
            com.nostra13.dcloudimageloader.utils.L.d(LOG_DESTROY, new java.lang.Object[0]);
        }
        stop();
        this.engine = null;
        this.configuration = null;
    }
}
