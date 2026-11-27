package com.bumptech.glide.request.transition;

/* JADX INFO: loaded from: classes.dex */
public class BitmapTransitionFactory extends com.bumptech.glide.request.transition.BitmapContainerTransitionFactory<android.graphics.Bitmap> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.transition.BitmapContainerTransitionFactory
    public android.graphics.Bitmap getBitmap(android.graphics.Bitmap bitmap) {
        return bitmap;
    }

    public BitmapTransitionFactory(com.bumptech.glide.request.transition.TransitionFactory<android.graphics.drawable.Drawable> transitionFactory) {
        super(transitionFactory);
    }
}
