package com.facebook.fresco.animation.drawable;

/* JADX INFO: compiled from: AnimationListener.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"Lcom/facebook/fresco/animation/drawable/AnimationListener;", "", "onAnimationStart", "", "drawable", "Landroid/graphics/drawable/Drawable;", "onAnimationStop", "onAnimationReset", "onAnimationRepeat", "onAnimationFrame", "frameNumber", "", "onAnimationLoaded", "animated-drawable_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AnimationListener {

    /* JADX INFO: compiled from: AnimationListener.kt */
    @kotlin.Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onAnimationLoaded(com.facebook.fresco.animation.drawable.AnimationListener animationListener) {
        }
    }

    void onAnimationFrame(android.graphics.drawable.Drawable drawable, int frameNumber);

    void onAnimationLoaded();

    void onAnimationRepeat(android.graphics.drawable.Drawable drawable);

    void onAnimationReset(android.graphics.drawable.Drawable drawable);

    void onAnimationStart(android.graphics.drawable.Drawable drawable);

    void onAnimationStop(android.graphics.drawable.Drawable drawable);
}
