package com.nostra13.dcloudimageloader.core.imageaware;

/* JADX INFO: loaded from: classes.dex */
public class ImageViewAware implements com.nostra13.dcloudimageloader.core.imageaware.ImageAware {
    protected boolean checkActualViewSize;
    protected java.lang.ref.Reference<android.widget.ImageView> imageViewRef;

    public ImageViewAware(android.widget.ImageView imageView) {
        this(imageView, true);
    }

    public ImageViewAware(android.widget.ImageView imageView, boolean z) {
        this.imageViewRef = new java.lang.ref.WeakReference(imageView);
        this.checkActualViewSize = z;
    }

    @Override // com.nostra13.dcloudimageloader.core.imageaware.ImageAware
    public int getWidth() {
        android.widget.ImageView imageView = this.imageViewRef.get();
        if (imageView == null) {
            return 0;
        }
        android.view.ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int width = (!this.checkActualViewSize || layoutParams == null || layoutParams.width == -2) ? 0 : imageView.getWidth();
        if (width <= 0 && layoutParams != null) {
            width = layoutParams.width;
        }
        if (width <= 0) {
            width = imageView.getMaxWidth();
        }
        com.nostra13.dcloudimageloader.utils.L.w("width = " + width, new java.lang.Object[0]);
        return width;
    }

    @Override // com.nostra13.dcloudimageloader.core.imageaware.ImageAware
    public int getHeight() {
        android.widget.ImageView imageView = this.imageViewRef.get();
        if (imageView == null) {
            return 0;
        }
        android.view.ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int height = (!this.checkActualViewSize || layoutParams == null || layoutParams.height == -2) ? 0 : imageView.getHeight();
        if (height <= 0 && layoutParams != null) {
            height = layoutParams.height;
        }
        if (height <= 0) {
            height = imageView.getMaxHeight();
        }
        com.nostra13.dcloudimageloader.utils.L.w("height = " + height, new java.lang.Object[0]);
        return height;
    }

    @Override // com.nostra13.dcloudimageloader.core.imageaware.ImageAware
    public com.nostra13.dcloudimageloader.core.assist.ViewScaleType getScaleType() {
        android.widget.ImageView imageView = this.imageViewRef.get();
        if (imageView != null) {
            return com.nostra13.dcloudimageloader.core.assist.ViewScaleType.fromImageView(imageView);
        }
        return null;
    }

    @Override // com.nostra13.dcloudimageloader.core.imageaware.ImageAware
    public android.widget.ImageView getWrappedView() {
        return this.imageViewRef.get();
    }

    @Override // com.nostra13.dcloudimageloader.core.imageaware.ImageAware
    public boolean isCollected() {
        return this.imageViewRef.get() == null;
    }

    @Override // com.nostra13.dcloudimageloader.core.imageaware.ImageAware
    public int getId() {
        android.widget.ImageView imageView = this.imageViewRef.get();
        return imageView == null ? super.hashCode() : imageView.hashCode();
    }

    @Override // com.nostra13.dcloudimageloader.core.imageaware.ImageAware
    public boolean setImageDrawable(android.graphics.drawable.Drawable drawable) {
        android.widget.ImageView imageView = this.imageViewRef.get();
        if (imageView == null) {
            return false;
        }
        imageView.setImageDrawable(drawable);
        return true;
    }

    @Override // com.nostra13.dcloudimageloader.core.imageaware.ImageAware
    public boolean setImageBitmap(android.graphics.Bitmap bitmap) {
        android.widget.ImageView imageView = this.imageViewRef.get();
        if (imageView == null) {
            return false;
        }
        imageView.setImageBitmap(bitmap);
        return true;
    }
}
