package com.nostra13.dcloudimageloader.core;

/* JADX INFO: loaded from: classes.dex */
final class DisplayBitmapTask implements java.lang.Runnable {
    private static final java.lang.String LOG_DISPLAY_IMAGE_IN_IMAGEAWARE = "Display image in ImageAware (loaded from %1$s) [%2$s]";
    private static final java.lang.String LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED = "ImageAware was collected by GC. Task is cancelled. [%s]";
    private static final java.lang.String LOG_TASK_CANCELLED_IMAGEAWARE_REUSED = "ImageAware is reused for another image. Task is cancelled. [%s]";
    private final android.graphics.Bitmap bitmap;
    private final com.nostra13.dcloudimageloader.core.display.BitmapDisplayer displayer;
    private final com.nostra13.dcloudimageloader.core.ImageLoaderEngine engine;
    private final com.nostra13.dcloudimageloader.core.imageaware.ImageAware imageAware;
    private final java.lang.String imageUri;
    private final com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener listener;
    private final com.nostra13.dcloudimageloader.core.assist.LoadedFrom loadedFrom;
    private boolean loggingEnabled;
    private final java.lang.String memoryCacheKey;

    public DisplayBitmapTask(android.graphics.Bitmap bitmap, com.nostra13.dcloudimageloader.core.ImageLoadingInfo imageLoadingInfo, com.nostra13.dcloudimageloader.core.ImageLoaderEngine imageLoaderEngine, com.nostra13.dcloudimageloader.core.assist.LoadedFrom loadedFrom) {
        this.bitmap = bitmap;
        this.imageUri = imageLoadingInfo.uri;
        this.imageAware = imageLoadingInfo.imageAware;
        this.memoryCacheKey = imageLoadingInfo.memoryCacheKey;
        this.displayer = imageLoadingInfo.options.getDisplayer();
        this.listener = imageLoadingInfo.listener;
        this.engine = imageLoaderEngine;
        this.loadedFrom = loadedFrom;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.imageAware.isCollected()) {
            if (this.loggingEnabled) {
                com.nostra13.dcloudimageloader.utils.L.d(LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED, this.memoryCacheKey);
            }
            this.listener.onLoadingCancelled(this.imageUri, this.imageAware.getWrappedView());
        } else if (isViewWasReused()) {
            if (this.loggingEnabled) {
                com.nostra13.dcloudimageloader.utils.L.d(LOG_TASK_CANCELLED_IMAGEAWARE_REUSED, this.memoryCacheKey);
            }
            this.listener.onLoadingCancelled(this.imageUri, this.imageAware.getWrappedView());
        } else {
            if (this.loggingEnabled) {
                com.nostra13.dcloudimageloader.utils.L.d(LOG_DISPLAY_IMAGE_IN_IMAGEAWARE, this.loadedFrom, this.memoryCacheKey);
            }
            this.listener.onLoadingComplete(this.imageUri, this.imageAware.getWrappedView(), this.displayer.display(this.bitmap, this.imageAware, this.loadedFrom));
            this.engine.cancelDisplayTaskFor(this.imageAware);
        }
    }

    private boolean isViewWasReused() {
        return !this.memoryCacheKey.equals(this.engine.getLoadingUriForView(this.imageAware));
    }

    void setLoggingEnabled(boolean z) {
        this.loggingEnabled = z;
    }
}
