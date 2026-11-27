package com.nostra13.dcloudimageloader.core.imageaware;

/* JADX INFO: loaded from: classes.dex */
public class ImageNonViewAware implements com.nostra13.dcloudimageloader.core.imageaware.ImageAware {
    protected final com.nostra13.dcloudimageloader.core.assist.ImageSize imageSize;
    protected final com.nostra13.dcloudimageloader.core.assist.ViewScaleType scaleType;

    @Override // com.nostra13.dcloudimageloader.core.imageaware.ImageAware
    public android.view.View getWrappedView() {
        return null;
    }

    @Override // com.nostra13.dcloudimageloader.core.imageaware.ImageAware
    public boolean isCollected() {
        return false;
    }

    @Override // com.nostra13.dcloudimageloader.core.imageaware.ImageAware
    public boolean setImageBitmap(android.graphics.Bitmap bitmap) {
        return true;
    }

    @Override // com.nostra13.dcloudimageloader.core.imageaware.ImageAware
    public boolean setImageDrawable(android.graphics.drawable.Drawable drawable) {
        return true;
    }

    public ImageNonViewAware(com.nostra13.dcloudimageloader.core.assist.ImageSize imageSize, com.nostra13.dcloudimageloader.core.assist.ViewScaleType viewScaleType) {
        this.imageSize = imageSize;
        this.scaleType = viewScaleType;
    }

    @Override // com.nostra13.dcloudimageloader.core.imageaware.ImageAware
    public int getWidth() {
        return this.imageSize.getWidth();
    }

    @Override // com.nostra13.dcloudimageloader.core.imageaware.ImageAware
    public int getHeight() {
        return this.imageSize.getHeight();
    }

    @Override // com.nostra13.dcloudimageloader.core.imageaware.ImageAware
    public com.nostra13.dcloudimageloader.core.assist.ViewScaleType getScaleType() {
        return this.scaleType;
    }

    @Override // com.nostra13.dcloudimageloader.core.imageaware.ImageAware
    public int getId() {
        return super.hashCode();
    }
}
