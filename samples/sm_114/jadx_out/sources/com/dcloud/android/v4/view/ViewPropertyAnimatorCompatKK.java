package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class ViewPropertyAnimatorCompatKK {
    ViewPropertyAnimatorCompatKK() {
    }

    public static void setUpdateListener(final android.view.View view, final com.dcloud.android.v4.view.ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        view.animate().setUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.dcloud.android.v4.view.ViewPropertyAnimatorCompatKK.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                viewPropertyAnimatorUpdateListener.onAnimationUpdate(view);
            }
        });
    }
}
