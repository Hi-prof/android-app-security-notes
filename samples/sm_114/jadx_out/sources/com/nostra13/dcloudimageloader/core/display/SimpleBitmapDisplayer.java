package com.nostra13.dcloudimageloader.core.display;

/* JADX INFO: loaded from: classes.dex */
public final class SimpleBitmapDisplayer implements com.nostra13.dcloudimageloader.core.display.BitmapDisplayer {
    @Override // com.nostra13.dcloudimageloader.core.display.BitmapDisplayer
    public android.graphics.Bitmap display(android.graphics.Bitmap bitmap, com.nostra13.dcloudimageloader.core.imageaware.ImageAware imageAware, com.nostra13.dcloudimageloader.core.assist.LoadedFrom loadedFrom) {
        imageAware.setImageBitmap(bitmap);
        return bitmap;
    }
}
