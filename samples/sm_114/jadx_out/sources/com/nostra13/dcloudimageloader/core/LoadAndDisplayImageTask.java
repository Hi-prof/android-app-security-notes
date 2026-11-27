package com.nostra13.dcloudimageloader.core;

/* JADX INFO: loaded from: classes.dex */
final class LoadAndDisplayImageTask implements java.lang.Runnable {
    private static final int BUFFER_SIZE = 32768;
    private static final java.lang.String ERROR_POST_PROCESSOR_NULL = "Pre-processor returned null [%s]";
    private static final java.lang.String ERROR_PRE_PROCESSOR_NULL = "Pre-processor returned null [%s]";
    private static final java.lang.String ERROR_PROCESSOR_FOR_DISC_CACHE_NULL = "Bitmap processor for disc cache returned null [%s]";
    private static final java.lang.String LOG_CACHE_IMAGE_IN_MEMORY = "Cache image in memory [%s]";
    private static final java.lang.String LOG_CACHE_IMAGE_ON_DISC = "Cache image on disc [%s]";
    private static final java.lang.String LOG_DELAY_BEFORE_LOADING = "Delay %d ms before loading...  [%s]";
    private static final java.lang.String LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING = "...Get cached bitmap from memory after waiting. [%s]";
    private static final java.lang.String LOG_LOAD_IMAGE_FROM_DISC_CACHE = "Load image from disc cache [%s]";
    private static final java.lang.String LOG_LOAD_IMAGE_FROM_NETWORK = "Load image from network [%s]";
    private static final java.lang.String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    private static final java.lang.String LOG_PREPROCESS_IMAGE = "PreProcess image before caching in memory [%s]";
    private static final java.lang.String LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISC = "Process image before cache on disc [%s]";
    private static final java.lang.String LOG_RESUME_AFTER_PAUSE = ".. Resume loading [%s]";
    private static final java.lang.String LOG_START_DISPLAY_IMAGE_TASK = "Start display image task [%s]";
    private static final java.lang.String LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED = "ImageAware was collected by GC. Task is cancelled. [%s]";
    private static final java.lang.String LOG_TASK_CANCELLED_IMAGEAWARE_REUSED = "ImageAware is reused for another image. Task is cancelled. [%s]";
    private static final java.lang.String LOG_TASK_INTERRUPTED = "Task was interrupted [%s]";
    private static final java.lang.String LOG_WAITING_FOR_IMAGE_LOADED = "Image already is loading. Waiting... [%s]";
    private static final java.lang.String LOG_WAITING_FOR_RESUME = "ImageLoader is paused. Waiting...  [%s]";
    private final com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration configuration;
    private final com.nostra13.dcloudimageloader.core.decode.ImageDecoder decoder;
    private final com.nostra13.dcloudimageloader.core.download.ImageDownloader downloader;
    private final com.nostra13.dcloudimageloader.core.ImageLoaderEngine engine;
    private final android.os.Handler handler;
    final com.nostra13.dcloudimageloader.core.imageaware.ImageAware imageAware;
    private final com.nostra13.dcloudimageloader.core.ImageLoadingInfo imageLoadingInfo;
    final com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener listener;
    private final java.lang.String memoryCacheKey;
    private final com.nostra13.dcloudimageloader.core.download.ImageDownloader networkDeniedDownloader;
    final com.nostra13.dcloudimageloader.core.DisplayImageOptions options;
    private final com.nostra13.dcloudimageloader.core.download.ImageDownloader slowNetworkDownloader;
    private final com.nostra13.dcloudimageloader.core.assist.ImageSize targetSize;
    final java.lang.String uri;
    private final boolean writeLogs;
    private com.nostra13.dcloudimageloader.core.assist.LoadedFrom loadedFrom = com.nostra13.dcloudimageloader.core.assist.LoadedFrom.NETWORK;
    private boolean imageAwareCollected = false;

    public LoadAndDisplayImageTask(com.nostra13.dcloudimageloader.core.ImageLoaderEngine imageLoaderEngine, com.nostra13.dcloudimageloader.core.ImageLoadingInfo imageLoadingInfo, android.os.Handler handler) {
        this.engine = imageLoaderEngine;
        this.imageLoadingInfo = imageLoadingInfo;
        this.handler = handler;
        com.nostra13.dcloudimageloader.core.ImageLoaderConfiguration imageLoaderConfiguration = imageLoaderEngine.configuration;
        this.configuration = imageLoaderConfiguration;
        this.downloader = imageLoaderConfiguration.downloader;
        this.networkDeniedDownloader = imageLoaderConfiguration.networkDeniedDownloader;
        this.slowNetworkDownloader = imageLoaderConfiguration.slowNetworkDownloader;
        this.decoder = imageLoaderConfiguration.decoder;
        this.writeLogs = imageLoaderConfiguration.writeLogs;
        this.uri = imageLoadingInfo.uri;
        this.memoryCacheKey = imageLoadingInfo.memoryCacheKey;
        this.imageAware = imageLoadingInfo.imageAware;
        this.targetSize = imageLoadingInfo.targetSize;
        this.options = imageLoadingInfo.options;
        this.listener = imageLoadingInfo.listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (waitIfPaused() || delayIfNeed()) {
            return;
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.imageLoadingInfo.loadFromUriLock;
        log(LOG_START_DISPLAY_IMAGE_TASK);
        if (reentrantLock.isLocked()) {
            log(LOG_WAITING_FOR_IMAGE_LOADED);
        }
        reentrantLock.lock();
        try {
            if (checkTaskIsNotActual()) {
                reentrantLock.unlock();
                return;
            }
            android.graphics.Bitmap bitmapProcess = this.configuration.memoryCache.get(this.memoryCacheKey);
            if (bitmapProcess == null) {
                bitmapProcess = tryLoadBitmap();
                if (this.imageAwareCollected) {
                    reentrantLock.unlock();
                    return;
                }
                if (bitmapProcess == null) {
                    reentrantLock.unlock();
                    return;
                }
                if (!checkTaskIsNotActual() && !checkTaskIsInterrupted()) {
                    if (this.options.shouldPreProcess()) {
                        log(LOG_PREPROCESS_IMAGE);
                        bitmapProcess = this.options.getPreProcessor().process(bitmapProcess);
                        if (bitmapProcess == null) {
                            com.nostra13.dcloudimageloader.utils.L.e("Pre-processor returned null [%s]", new java.lang.Object[0]);
                        }
                    }
                    if (bitmapProcess != null && this.options.isCacheInMemory()) {
                        log(LOG_CACHE_IMAGE_IN_MEMORY);
                        this.configuration.memoryCache.put(this.memoryCacheKey, bitmapProcess);
                    }
                }
                reentrantLock.unlock();
                return;
            }
            this.loadedFrom = com.nostra13.dcloudimageloader.core.assist.LoadedFrom.MEMORY_CACHE;
            log(LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING);
            if (bitmapProcess != null && this.options.shouldPostProcess()) {
                log(LOG_POSTPROCESS_IMAGE);
                bitmapProcess = this.options.getPostProcessor().process(bitmapProcess);
                if (bitmapProcess == null) {
                    com.nostra13.dcloudimageloader.utils.L.e("Pre-processor returned null [%s]", this.memoryCacheKey);
                }
            }
            reentrantLock.unlock();
            if (checkTaskIsNotActual() || checkTaskIsInterrupted()) {
                return;
            }
            com.nostra13.dcloudimageloader.core.DisplayBitmapTask displayBitmapTask = new com.nostra13.dcloudimageloader.core.DisplayBitmapTask(bitmapProcess, this.imageLoadingInfo, this.engine, this.loadedFrom);
            displayBitmapTask.setLoggingEnabled(this.writeLogs);
            if (this.options.isSyncLoading()) {
                displayBitmapTask.run();
            } else {
                this.handler.post(displayBitmapTask);
            }
        } catch (java.lang.Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    private boolean waitIfPaused() {
        java.util.concurrent.atomic.AtomicBoolean pause = this.engine.getPause();
        synchronized (pause) {
            if (pause.get()) {
                log(LOG_WAITING_FOR_RESUME);
                try {
                    pause.wait();
                    log(LOG_RESUME_AFTER_PAUSE);
                } catch (java.lang.InterruptedException unused) {
                    com.nostra13.dcloudimageloader.utils.L.e(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
                    return true;
                }
            }
        }
        return checkTaskIsNotActual();
    }

    private boolean delayIfNeed() {
        if (!this.options.shouldDelayBeforeLoading()) {
            return false;
        }
        log(LOG_DELAY_BEFORE_LOADING, java.lang.Integer.valueOf(this.options.getDelayBeforeLoading()), this.memoryCacheKey);
        try {
            java.lang.Thread.sleep(this.options.getDelayBeforeLoading());
            return checkTaskIsNotActual();
        } catch (java.lang.InterruptedException unused) {
            com.nostra13.dcloudimageloader.utils.L.e(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
            return true;
        }
    }

    private boolean checkTaskIsNotActual() {
        return checkViewCollected() || checkViewReused();
    }

    private boolean checkViewCollected() {
        if (!this.imageAware.isCollected()) {
            return false;
        }
        this.imageAwareCollected = true;
        log(LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED);
        fireCancelEvent();
        return true;
    }

    private boolean checkViewReused() {
        boolean zEquals = this.memoryCacheKey.equals(this.engine.getLoadingUriForView(this.imageAware));
        boolean z = !zEquals;
        if (!zEquals) {
            log(LOG_TASK_CANCELLED_IMAGEAWARE_REUSED);
            fireCancelEvent();
        }
        return z;
    }

    private boolean checkTaskIsInterrupted() {
        boolean zInterrupted = java.lang.Thread.interrupted();
        if (zInterrupted) {
            log(LOG_TASK_INTERRUPTED);
        }
        return zInterrupted;
    }

    private android.graphics.Bitmap tryLoadBitmap() {
        android.graphics.Bitmap bitmapDecodeImage;
        java.io.IOException e;
        java.io.File imageFileInDiscCache = getImageFileInDiscCache();
        android.graphics.Bitmap bitmap = null;
        try {
            if (imageFileInDiscCache.exists()) {
                log(LOG_LOAD_IMAGE_FROM_DISC_CACHE);
                this.loadedFrom = com.nostra13.dcloudimageloader.core.assist.LoadedFrom.DISC_CACHE;
                bitmapDecodeImage = decodeImage(com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.FILE.wrap(imageFileInDiscCache.getAbsolutePath()));
                try {
                    if (this.imageAwareCollected) {
                        return null;
                    }
                } catch (java.io.IOException e2) {
                    e = e2;
                    com.nostra13.dcloudimageloader.utils.L.e(e);
                    fireFailEvent(com.nostra13.dcloudimageloader.core.assist.FailReason.FailType.IO_ERROR, e);
                    if (imageFileInDiscCache.exists()) {
                        imageFileInDiscCache.delete();
                    }
                    return bitmapDecodeImage;
                } catch (java.lang.IllegalStateException unused) {
                    fireFailEvent(com.nostra13.dcloudimageloader.core.assist.FailReason.FailType.NETWORK_DENIED, null);
                    return bitmapDecodeImage;
                } catch (java.lang.OutOfMemoryError e3) {
                    e = e3;
                    bitmap = bitmapDecodeImage;
                    com.nostra13.dcloudimageloader.utils.L.e(e);
                    fireFailEvent(com.nostra13.dcloudimageloader.core.assist.FailReason.FailType.OUT_OF_MEMORY, e);
                    return bitmap;
                } catch (java.lang.Throwable th) {
                    th = th;
                    bitmap = bitmapDecodeImage;
                    com.nostra13.dcloudimageloader.utils.L.e(th);
                    fireFailEvent(com.nostra13.dcloudimageloader.core.assist.FailReason.FailType.UNKNOWN, th);
                    return bitmap;
                }
            } else {
                bitmapDecodeImage = null;
            }
            if (bitmapDecodeImage == null || bitmapDecodeImage.getWidth() <= 0 || bitmapDecodeImage.getHeight() <= 0) {
                log(LOG_LOAD_IMAGE_FROM_NETWORK);
                this.loadedFrom = com.nostra13.dcloudimageloader.core.assist.LoadedFrom.NETWORK;
                java.lang.String strTryCacheImageOnDisc = this.options.isCacheOnDisc() ? tryCacheImageOnDisc(imageFileInDiscCache) : this.uri;
                if (!checkTaskIsNotActual()) {
                    bitmapDecodeImage = decodeImage(strTryCacheImageOnDisc);
                    if (this.imageAwareCollected) {
                        return null;
                    }
                    if (bitmapDecodeImage != null && bitmapDecodeImage.getWidth() > 0 && bitmapDecodeImage.getHeight() > 0) {
                        return bitmapDecodeImage;
                    }
                    fireFailEvent(com.nostra13.dcloudimageloader.core.assist.FailReason.FailType.DECODING_ERROR, null);
                }
            }
            return bitmapDecodeImage;
        } catch (java.io.IOException e4) {
            bitmapDecodeImage = null;
            e = e4;
        } catch (java.lang.IllegalStateException unused2) {
            bitmapDecodeImage = null;
        } catch (java.lang.OutOfMemoryError e5) {
            e = e5;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private java.io.File getImageFileInDiscCache() {
        java.io.File file = this.configuration.discCache.get(this.uri);
        java.io.File parentFile = file.getParentFile();
        if (parentFile != null && (parentFile.exists() || parentFile.mkdirs())) {
            return file;
        }
        java.io.File file2 = this.configuration.reserveDiscCache.get(this.uri);
        java.io.File parentFile2 = file2.getParentFile();
        if (parentFile2 != null && !parentFile2.exists()) {
            parentFile2.mkdirs();
        }
        return file2;
    }

    private android.graphics.Bitmap decodeImage(java.lang.String str) throws java.io.IOException {
        com.nostra13.dcloudimageloader.core.assist.ViewScaleType scaleType;
        if (checkViewCollected() || (scaleType = this.imageAware.getScaleType()) == null) {
            return null;
        }
        return this.decoder.decode(new com.nostra13.dcloudimageloader.core.decode.ImageDecodingInfo(this.memoryCacheKey, str, this.targetSize, scaleType, getDownloader(), this.options));
    }

    private java.lang.String tryCacheImageOnDisc(java.io.File file) {
        log(LOG_CACHE_IMAGE_ON_DISC);
        try {
            int i = this.configuration.maxImageWidthForDiscCache;
            int i2 = this.configuration.maxImageHeightForDiscCache;
            if (!((i > 0 || i2 > 0) ? downloadSizedImage(file, i, i2) : false)) {
                downloadImage(file);
            }
            this.configuration.discCache.put(this.uri, file);
            return com.nostra13.dcloudimageloader.core.download.ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath());
        } catch (java.io.IOException e) {
            com.nostra13.dcloudimageloader.utils.L.e(e);
            if (file.exists()) {
                file.delete();
            }
            return this.uri;
        }
    }

    private boolean downloadSizedImage(java.io.File file, int i, int i2) throws java.io.IOException {
        android.graphics.Bitmap bitmapDecode = this.decoder.decode(new com.nostra13.dcloudimageloader.core.decode.ImageDecodingInfo(this.memoryCacheKey, this.uri, new com.nostra13.dcloudimageloader.core.assist.ImageSize(i, i2), com.nostra13.dcloudimageloader.core.assist.ViewScaleType.FIT_INSIDE, getDownloader(), new com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder().cloneFrom(this.options).imageScaleType(com.nostra13.dcloudimageloader.core.assist.ImageScaleType.IN_SAMPLE_INT).build()));
        if (bitmapDecode == null) {
            return false;
        }
        if (this.configuration.processorForDiscCache != null) {
            log(LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISC);
            bitmapDecode = this.configuration.processorForDiscCache.process(bitmapDecode);
            if (bitmapDecode == null) {
                com.nostra13.dcloudimageloader.utils.L.e(ERROR_PROCESSOR_FOR_DISC_CACHE_NULL, this.memoryCacheKey);
                return false;
            }
        }
        java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file), 1195);
        try {
            boolean zCompress = bitmapDecode.compress(this.configuration.imageCompressFormatForDiscCache, this.configuration.imageQualityForDiscCache, bufferedOutputStream);
            com.nostra13.dcloudimageloader.utils.IoUtils.closeSilently(bufferedOutputStream);
            bitmapDecode.recycle();
            return zCompress;
        } catch (java.lang.Throwable th) {
            com.nostra13.dcloudimageloader.utils.IoUtils.closeSilently(bufferedOutputStream);
            throw th;
        }
    }

    private void downloadImage(java.io.File file) throws java.io.IOException {
        java.io.InputStream stream = getDownloader().getStream(this.uri, this.options.getExtraForDownloader());
        try {
            java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file), 1195);
            try {
                com.nostra13.dcloudimageloader.utils.IoUtils.copyStream(stream, bufferedOutputStream);
                com.nostra13.dcloudimageloader.utils.IoUtils.closeSilently(bufferedOutputStream);
                com.nostra13.dcloudimageloader.utils.IoUtils.closeSilently(stream);
            } catch (java.lang.Throwable th) {
                com.nostra13.dcloudimageloader.utils.IoUtils.closeSilently(bufferedOutputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            com.nostra13.dcloudimageloader.utils.IoUtils.closeSilently(stream);
            throw th2;
        }
    }

    private void fireFailEvent(final com.nostra13.dcloudimageloader.core.assist.FailReason.FailType failType, final java.lang.Throwable th) {
        if (java.lang.Thread.interrupted()) {
            return;
        }
        if (this.options.isSyncLoading()) {
            this.listener.onLoadingFailed(this.uri, this.imageAware.getWrappedView(), new com.nostra13.dcloudimageloader.core.assist.FailReason(failType, th));
        } else {
            this.handler.post(new java.lang.Runnable() { // from class: com.nostra13.dcloudimageloader.core.LoadAndDisplayImageTask.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.nostra13.dcloudimageloader.core.LoadAndDisplayImageTask.this.options.shouldShowImageOnFail()) {
                        com.nostra13.dcloudimageloader.core.LoadAndDisplayImageTask.this.imageAware.setImageDrawable(com.nostra13.dcloudimageloader.core.LoadAndDisplayImageTask.this.options.getImageOnFail(com.nostra13.dcloudimageloader.core.LoadAndDisplayImageTask.this.configuration.resources));
                    }
                    com.nostra13.dcloudimageloader.core.LoadAndDisplayImageTask.this.listener.onLoadingFailed(com.nostra13.dcloudimageloader.core.LoadAndDisplayImageTask.this.uri, com.nostra13.dcloudimageloader.core.LoadAndDisplayImageTask.this.imageAware.getWrappedView(), new com.nostra13.dcloudimageloader.core.assist.FailReason(failType, th));
                }
            });
        }
    }

    private void fireCancelEvent() {
        if (java.lang.Thread.interrupted()) {
            return;
        }
        if (this.options.isSyncLoading()) {
            this.listener.onLoadingCancelled(this.uri, this.imageAware.getWrappedView());
        } else {
            this.handler.post(new java.lang.Runnable() { // from class: com.nostra13.dcloudimageloader.core.LoadAndDisplayImageTask.2
                @Override // java.lang.Runnable
                public void run() {
                    com.nostra13.dcloudimageloader.core.LoadAndDisplayImageTask.this.listener.onLoadingCancelled(com.nostra13.dcloudimageloader.core.LoadAndDisplayImageTask.this.uri, com.nostra13.dcloudimageloader.core.LoadAndDisplayImageTask.this.imageAware.getWrappedView());
                }
            });
        }
    }

    private com.nostra13.dcloudimageloader.core.download.ImageDownloader getDownloader() {
        if (this.engine.isNetworkDenied()) {
            return this.networkDeniedDownloader;
        }
        if (this.engine.isSlowNetwork()) {
            return this.slowNetworkDownloader;
        }
        return this.downloader;
    }

    java.lang.String getLoadingUri() {
        return this.uri;
    }

    private void log(java.lang.String str) {
        if (this.writeLogs) {
            com.nostra13.dcloudimageloader.utils.L.d(str, this.memoryCacheKey);
        }
    }

    private void log(java.lang.String str, java.lang.Object... objArr) {
        if (this.writeLogs) {
            com.nostra13.dcloudimageloader.utils.L.d(str, objArr);
        }
    }
}
