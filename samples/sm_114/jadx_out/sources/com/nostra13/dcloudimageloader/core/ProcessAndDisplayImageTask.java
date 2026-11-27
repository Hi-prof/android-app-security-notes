package com.nostra13.dcloudimageloader.core;

/* JADX INFO: loaded from: classes.dex */
class ProcessAndDisplayImageTask implements java.lang.Runnable {
    private static final java.lang.String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    private final android.graphics.Bitmap bitmap;
    private final com.nostra13.dcloudimageloader.core.ImageLoaderEngine engine;
    private final android.os.Handler handler;
    private final com.nostra13.dcloudimageloader.core.ImageLoadingInfo imageLoadingInfo;

    public ProcessAndDisplayImageTask(com.nostra13.dcloudimageloader.core.ImageLoaderEngine imageLoaderEngine, android.graphics.Bitmap bitmap, com.nostra13.dcloudimageloader.core.ImageLoadingInfo imageLoadingInfo, android.os.Handler handler) {
        this.engine = imageLoaderEngine;
        this.bitmap = bitmap;
        this.imageLoadingInfo = imageLoadingInfo;
        this.handler = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.engine.configuration.writeLogs) {
            com.nostra13.dcloudimageloader.utils.L.d(LOG_POSTPROCESS_IMAGE, this.imageLoadingInfo.memoryCacheKey);
        }
        com.nostra13.dcloudimageloader.core.DisplayBitmapTask displayBitmapTask = new com.nostra13.dcloudimageloader.core.DisplayBitmapTask(this.imageLoadingInfo.options.getPostProcessor().process(this.bitmap), this.imageLoadingInfo, this.engine, com.nostra13.dcloudimageloader.core.assist.LoadedFrom.MEMORY_CACHE);
        displayBitmapTask.setLoggingEnabled(this.engine.configuration.writeLogs);
        if (this.imageLoadingInfo.options.isSyncLoading()) {
            displayBitmapTask.run();
        } else {
            this.handler.post(displayBitmapTask);
        }
    }
}
