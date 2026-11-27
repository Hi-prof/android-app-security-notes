package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class ViewPropertyAnimatorCompatICS {
    ViewPropertyAnimatorCompatICS() {
    }

    public static void alpha(android.view.View view, float f) {
        view.animate().alpha(f);
    }

    public static void alphaBy(android.view.View view, float f) {
        view.animate().alphaBy(f);
    }

    public static void cancel(android.view.View view) {
        view.animate().cancel();
    }

    public static long getDuration(android.view.View view) {
        return view.animate().getDuration();
    }

    public static long getStartDelay(android.view.View view) {
        return view.animate().getStartDelay();
    }

    public static void rotation(android.view.View view, float f) {
        view.animate().rotation(f);
    }

    public static void rotationBy(android.view.View view, float f) {
        view.animate().rotationBy(f);
    }

    public static void rotationX(android.view.View view, float f) {
        view.animate().rotationX(f);
    }

    public static void rotationXBy(android.view.View view, float f) {
        view.animate().rotationXBy(f);
    }

    public static void rotationY(android.view.View view, float f) {
        view.animate().rotationY(f);
    }

    public static void rotationYBy(android.view.View view, float f) {
        view.animate().rotationYBy(f);
    }

    public static void scaleX(android.view.View view, float f) {
        view.animate().scaleX(f);
    }

    public static void scaleXBy(android.view.View view, float f) {
        view.animate().scaleXBy(f);
    }

    public static void scaleY(android.view.View view, float f) {
        view.animate().scaleY(f);
    }

    public static void scaleYBy(android.view.View view, float f) {
        view.animate().scaleYBy(f);
    }

    public static void setDuration(android.view.View view, long j) {
        view.animate().setDuration(j);
    }

    public static void setInterpolator(android.view.View view, android.view.animation.Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public static void setListener(final android.view.View view, final com.dcloud.android.v4.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new android.animation.AnimatorListenerAdapter() { // from class: com.dcloud.android.v4.view.ViewPropertyAnimatorCompatICS.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    viewPropertyAnimatorListener.onAnimationEnd(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    viewPropertyAnimatorListener.onAnimationStart(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public static void setStartDelay(android.view.View view, long j) {
        view.animate().setStartDelay(j);
    }

    public static void start(android.view.View view) {
        view.animate().start();
    }

    public static void translationX(android.view.View view, float f) {
        view.animate().translationX(f);
    }

    public static void translationXBy(android.view.View view, float f) {
        view.animate().translationXBy(f);
    }

    public static void translationY(android.view.View view, float f) {
        view.animate().translationY(f);
    }

    public static void translationYBy(android.view.View view, float f) {
        view.animate().translationYBy(f);
    }

    public static void x(android.view.View view, float f) {
        view.animate().x(f);
    }

    public static void xBy(android.view.View view, float f) {
        view.animate().xBy(f);
    }

    public static void y(android.view.View view, float f) {
        view.animate().y(f);
    }

    public static void yBy(android.view.View view, float f) {
        view.animate().yBy(f);
    }
}
