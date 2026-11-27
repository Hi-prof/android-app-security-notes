package com.nostra13.dcloudimageloader.core.display;

/* JADX INFO: loaded from: classes.dex */
public class FadeInBitmapDisplayer implements com.nostra13.dcloudimageloader.core.display.BitmapDisplayer {
    private final boolean animateFromDisc;
    private final boolean animateFromMemory;
    private final boolean animateFromNetwork;
    private final int durationMillis;

    public FadeInBitmapDisplayer(int i) {
        this(i, true, true, true);
    }

    public FadeInBitmapDisplayer(int i, boolean z, boolean z2, boolean z3) {
        this.durationMillis = i;
        this.animateFromNetwork = z;
        this.animateFromDisc = z2;
        this.animateFromMemory = z3;
    }

    @Override // com.nostra13.dcloudimageloader.core.display.BitmapDisplayer
    public android.graphics.Bitmap display(android.graphics.Bitmap bitmap, com.nostra13.dcloudimageloader.core.imageaware.ImageAware imageAware, com.nostra13.dcloudimageloader.core.assist.LoadedFrom loadedFrom) {
        imageAware.setImageBitmap(bitmap);
        if ((this.animateFromNetwork && loadedFrom == com.nostra13.dcloudimageloader.core.assist.LoadedFrom.NETWORK) || ((this.animateFromDisc && loadedFrom == com.nostra13.dcloudimageloader.core.assist.LoadedFrom.DISC_CACHE) || (this.animateFromMemory && loadedFrom == com.nostra13.dcloudimageloader.core.assist.LoadedFrom.MEMORY_CACHE))) {
            animate(imageAware.getWrappedView(), this.durationMillis);
        }
        return bitmap;
    }

    public static void animate(android.view.View view, int i) {
        if (view != null) {
            android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(i);
            alphaAnimation.setInterpolator(new android.view.animation.DecelerateInterpolator());
            view.startAnimation(alphaAnimation);
        }
    }
}
