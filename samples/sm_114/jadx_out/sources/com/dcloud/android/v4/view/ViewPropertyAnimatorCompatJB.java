package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class ViewPropertyAnimatorCompatJB {
    ViewPropertyAnimatorCompatJB() {
    }

    public static void setListener(final android.view.View view, final com.dcloud.android.v4.view.ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new android.animation.AnimatorListenerAdapter() { // from class: com.dcloud.android.v4.view.ViewPropertyAnimatorCompatJB.1
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

    public static void withEndAction(android.view.View view, java.lang.Runnable runnable) {
        view.animate().withEndAction(runnable);
    }

    public static void withLayer(android.view.View view) {
        view.animate().withLayer();
    }

    public static void withStartAction(android.view.View view, java.lang.Runnable runnable) {
        view.animate().withStartAction(runnable);
    }
}
