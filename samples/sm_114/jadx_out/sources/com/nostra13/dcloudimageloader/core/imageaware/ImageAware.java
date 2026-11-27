package com.nostra13.dcloudimageloader.core.imageaware;

/* JADX INFO: loaded from: classes.dex */
public interface ImageAware {
    int getHeight();

    int getId();

    com.nostra13.dcloudimageloader.core.assist.ViewScaleType getScaleType();

    int getWidth();

    android.view.View getWrappedView();

    boolean isCollected();

    boolean setImageBitmap(android.graphics.Bitmap bitmap);

    boolean setImageDrawable(android.graphics.drawable.Drawable drawable);
}
