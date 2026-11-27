package com.nostra13.dcloudimageloader.core.assist;

/* JADX INFO: loaded from: classes.dex */
public class SyncImageLoadingListener extends com.nostra13.dcloudimageloader.core.assist.SimpleImageLoadingListener {
    private android.graphics.Bitmap loadedImage;

    @Override // com.nostra13.dcloudimageloader.core.assist.SimpleImageLoadingListener, com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
    public void onLoadingComplete(java.lang.String str, android.view.View view, android.graphics.Bitmap bitmap) {
        this.loadedImage = bitmap;
    }

    public android.graphics.Bitmap getLoadedBitmap() {
        return this.loadedImage;
    }
}
