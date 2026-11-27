package io.dcloud.nineoldandroids.view;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ViewPropertyAnimator {
    private static final java.util.WeakHashMap<android.view.View, io.dcloud.nineoldandroids.view.ViewPropertyAnimator> ANIMATORS = new java.util.WeakHashMap<>(0);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator alpha(float f);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator alphaBy(float f);

    public abstract void cancel();

    public abstract long getDuration();

    public abstract long getStartDelay();

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator rotation(float f);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator rotationBy(float f);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator rotationX(float f);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator rotationXBy(float f);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator rotationY(float f);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator rotationYBy(float f);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator scaleX(float f);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator scaleXBy(float f);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator scaleY(float f);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator scaleYBy(float f);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator setDuration(long j);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator setInterpolator(android.view.animation.Interpolator interpolator);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator setListener(io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator setStartDelay(long j);

    public abstract void start();

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator translationX(float f);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator translationXBy(float f);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator translationY(float f);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator translationYBy(float f);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator x(float f);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator xBy(float f);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator y(float f);

    public abstract io.dcloud.nineoldandroids.view.ViewPropertyAnimator yBy(float f);

    public static io.dcloud.nineoldandroids.view.ViewPropertyAnimator animate(android.view.View view) {
        java.util.WeakHashMap<android.view.View, io.dcloud.nineoldandroids.view.ViewPropertyAnimator> weakHashMap = ANIMATORS;
        io.dcloud.nineoldandroids.view.ViewPropertyAnimator viewPropertyAnimatorPreHC = weakHashMap.get(view);
        if (viewPropertyAnimatorPreHC == null) {
            int iIntValue = java.lang.Integer.valueOf(android.os.Build.VERSION.SDK).intValue();
            if (iIntValue >= 14) {
                viewPropertyAnimatorPreHC = new io.dcloud.nineoldandroids.view.ViewPropertyAnimatorICS(view);
            } else if (iIntValue >= 11) {
                viewPropertyAnimatorPreHC = new io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC(view);
            } else {
                viewPropertyAnimatorPreHC = new io.dcloud.nineoldandroids.view.ViewPropertyAnimatorPreHC(view);
            }
            weakHashMap.put(view, viewPropertyAnimatorPreHC);
        }
        return viewPropertyAnimatorPreHC;
    }
}
