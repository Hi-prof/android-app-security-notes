package com.facebook.fresco.animation.drawable.animator;

/* JADX INFO: compiled from: AnimatedDrawableValueAnimatorHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\f"}, d2 = {"Lcom/facebook/fresco/animation/drawable/animator/AnimatedDrawableValueAnimatorHelper;", "", "<init>", "()V", "createValueAnimator", "Landroid/animation/ValueAnimator;", "drawable", "Landroid/graphics/drawable/Drawable;", "maxDurationMs", "", "createAnimatorUpdateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "animated-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnimatedDrawableValueAnimatorHelper {
    public static final com.facebook.fresco.animation.drawable.animator.AnimatedDrawableValueAnimatorHelper INSTANCE = new com.facebook.fresco.animation.drawable.animator.AnimatedDrawableValueAnimatorHelper();

    private AnimatedDrawableValueAnimatorHelper() {
    }

    @kotlin.jvm.JvmStatic
    public static final android.animation.ValueAnimator createValueAnimator(android.graphics.drawable.Drawable drawable, int maxDurationMs) {
        if (drawable instanceof com.facebook.fresco.animation.drawable.AnimatedDrawable2) {
            return com.facebook.fresco.animation.drawable.animator.AnimatedDrawable2ValueAnimatorHelper.createValueAnimator((com.facebook.fresco.animation.drawable.AnimatedDrawable2) drawable, maxDurationMs);
        }
        return null;
    }

    @kotlin.jvm.JvmStatic
    public static final android.animation.ValueAnimator createValueAnimator(android.graphics.drawable.Drawable drawable) {
        if (!(drawable instanceof com.facebook.fresco.animation.drawable.AnimatedDrawable2)) {
            return null;
        }
        com.facebook.fresco.animation.drawable.AnimatedDrawable2 animatedDrawable2 = (com.facebook.fresco.animation.drawable.AnimatedDrawable2) drawable;
        return com.facebook.fresco.animation.drawable.animator.AnimatedDrawable2ValueAnimatorHelper.createValueAnimator(drawable, animatedDrawable2.getLoopCount(), animatedDrawable2.getLoopDurationMs());
    }

    @kotlin.jvm.JvmStatic
    public static final android.animation.ValueAnimator.AnimatorUpdateListener createAnimatorUpdateListener(android.graphics.drawable.Drawable drawable) {
        if (drawable instanceof com.facebook.fresco.animation.drawable.AnimatedDrawable2) {
            return com.facebook.fresco.animation.drawable.animator.AnimatedDrawable2ValueAnimatorHelper.createAnimatorUpdateListener((com.facebook.fresco.animation.drawable.AnimatedDrawable2) drawable);
        }
        return null;
    }
}
