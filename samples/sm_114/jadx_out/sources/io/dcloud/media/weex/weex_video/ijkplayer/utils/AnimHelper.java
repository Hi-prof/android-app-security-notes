package io.dcloud.media.weex.weex_video.ijkplayer.utils;

/* JADX INFO: loaded from: classes2.dex */
public final class AnimHelper {
    private AnimHelper() {
        throw new java.lang.AssertionError();
    }

    public static void doSlideRightIn(android.view.View view, int i, int i2, int i3) {
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(view, "translationX", i, i2);
        android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.setDuration(i3);
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.start();
    }

    public static void doClipViewWidth(final android.view.View view, int i, int i2, int i3) {
        android.animation.ValueAnimator duration = android.animation.ValueAnimator.ofInt(i, i2).setDuration(i3);
        duration.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: io.dcloud.media.weex.weex_video.ijkplayer.utils.AnimHelper.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                int iIntValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = iIntValue;
                view.setLayoutParams(layoutParams);
            }
        });
        duration.setInterpolator(new android.view.animation.AccelerateInterpolator());
        duration.start();
    }

    public static void doClipViewHeight(final android.view.View view, int i, int i2, int i3) {
        android.animation.ValueAnimator duration = android.animation.ValueAnimator.ofInt(i, i2).setDuration(i3);
        duration.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: io.dcloud.media.weex.weex_video.ijkplayer.utils.AnimHelper.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                int iIntValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
                android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = iIntValue;
                view.setLayoutParams(layoutParams);
            }
        });
        duration.setInterpolator(new android.view.animation.AccelerateInterpolator());
        duration.start();
    }
}
