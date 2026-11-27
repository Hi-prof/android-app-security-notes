package com.nostra13.dcloudimageloader.core.decode;

/* JADX INFO: loaded from: classes.dex */
public class ImageDecodingInfo {
    private final boolean considerExifParams;
    private final android.graphics.BitmapFactory.Options decodingOptions;
    private final com.nostra13.dcloudimageloader.core.download.ImageDownloader downloader;
    private final java.lang.Object extraForDownloader;
    private final java.lang.String imageKey;
    private final com.nostra13.dcloudimageloader.core.assist.ImageScaleType imageScaleType;
    private final java.lang.String imageUri;
    private final com.nostra13.dcloudimageloader.core.assist.ImageSize targetSize;
    private final com.nostra13.dcloudimageloader.core.assist.ViewScaleType viewScaleType;

    public ImageDecodingInfo(java.lang.String str, java.lang.String str2, com.nostra13.dcloudimageloader.core.assist.ImageSize imageSize, com.nostra13.dcloudimageloader.core.assist.ViewScaleType viewScaleType, com.nostra13.dcloudimageloader.core.download.ImageDownloader imageDownloader, com.nostra13.dcloudimageloader.core.DisplayImageOptions displayImageOptions) {
        this.imageKey = str;
        this.imageUri = str2;
        this.targetSize = imageSize;
        this.imageScaleType = displayImageOptions.getImageScaleType();
        this.viewScaleType = viewScaleType;
        this.downloader = imageDownloader;
        this.extraForDownloader = displayImageOptions.getExtraForDownloader();
        this.considerExifParams = displayImageOptions.isConsiderExifParams();
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        this.decodingOptions = options;
        copyOptions(displayImageOptions.getDecodingOptions(), options);
    }

    private void copyOptions(android.graphics.BitmapFactory.Options options, android.graphics.BitmapFactory.Options options2) {
        options2.inDensity = options.inDensity;
        options2.inDither = options.inDither;
        options2.inInputShareable = options.inInputShareable;
        options2.inJustDecodeBounds = options.inJustDecodeBounds;
        options2.inPreferredConfig = options.inPreferredConfig;
        options2.inPurgeable = options.inPurgeable;
        options2.inSampleSize = options.inSampleSize;
        options2.inScaled = options.inScaled;
        options2.inScreenDensity = options.inScreenDensity;
        options2.inTargetDensity = options.inTargetDensity;
        options2.inTempStorage = options.inTempStorage;
        copyOptions10(options, options2);
        copyOptions11(options, options2);
    }

    private void copyOptions10(android.graphics.BitmapFactory.Options options, android.graphics.BitmapFactory.Options options2) {
        options2.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
    }

    private void copyOptions11(android.graphics.BitmapFactory.Options options, android.graphics.BitmapFactory.Options options2) {
        options2.inBitmap = options.inBitmap;
        options2.inMutable = options.inMutable;
    }

    public java.lang.String getImageKey() {
        return this.imageKey;
    }

    public java.lang.String getImageUri() {
        return this.imageUri;
    }

    public com.nostra13.dcloudimageloader.core.assist.ImageSize getTargetSize() {
        return this.targetSize;
    }

    public com.nostra13.dcloudimageloader.core.assist.ImageScaleType getImageScaleType() {
        return this.imageScaleType;
    }

    public com.nostra13.dcloudimageloader.core.assist.ViewScaleType getViewScaleType() {
        return this.viewScaleType;
    }

    public com.nostra13.dcloudimageloader.core.download.ImageDownloader getDownloader() {
        return this.downloader;
    }

    public java.lang.Object getExtraForDownloader() {
        return this.extraForDownloader;
    }

    public boolean shouldConsiderExifParams() {
        return this.considerExifParams;
    }

    public android.graphics.BitmapFactory.Options getDecodingOptions() {
        return this.decodingOptions;
    }
}
