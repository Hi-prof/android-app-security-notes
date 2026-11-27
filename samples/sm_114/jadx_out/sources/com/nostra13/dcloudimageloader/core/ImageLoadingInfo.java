package com.nostra13.dcloudimageloader.core;

/* JADX INFO: loaded from: classes.dex */
final class ImageLoadingInfo {
    final com.nostra13.dcloudimageloader.core.imageaware.ImageAware imageAware;
    final com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener listener;
    final java.util.concurrent.locks.ReentrantLock loadFromUriLock;
    final java.lang.String memoryCacheKey;
    final com.nostra13.dcloudimageloader.core.DisplayImageOptions options;
    final com.nostra13.dcloudimageloader.core.assist.ImageSize targetSize;
    final java.lang.String uri;

    public ImageLoadingInfo(java.lang.String str, com.nostra13.dcloudimageloader.core.imageaware.ImageAware imageAware, com.nostra13.dcloudimageloader.core.assist.ImageSize imageSize, java.lang.String str2, com.nostra13.dcloudimageloader.core.DisplayImageOptions displayImageOptions, com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener imageLoadingListener, java.util.concurrent.locks.ReentrantLock reentrantLock) {
        this.uri = str;
        this.imageAware = imageAware;
        this.targetSize = imageSize;
        this.options = displayImageOptions;
        this.listener = imageLoadingListener;
        this.loadFromUriLock = reentrantLock;
        this.memoryCacheKey = str2;
    }
}
