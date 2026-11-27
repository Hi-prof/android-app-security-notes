package com.dcloud.android.widget;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DCWebViewProgressBar extends android.widget.ProgressBar {
    int alpha;
    public boolean isFinish;
    io.dcloud.nineoldandroids.animation.ObjectAnimator mCurrentAnmiator;

    public DCWebViewProgressBar(android.content.Context context) {
        super(context, null, android.R.attr.progressBarStyleHorizontal);
        this.isFinish = false;
        this.alpha = 255;
        setMax(io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.dcloud.nineoldandroids.animation.ObjectAnimator getProgressAnimation(int i, int i2, android.view.animation.Interpolator interpolator, io.dcloud.nineoldandroids.animation.AnimatorListenerAdapter animatorListenerAdapter) {
        io.dcloud.nineoldandroids.animation.ObjectAnimator objectAnimatorOfInt = io.dcloud.nineoldandroids.animation.ObjectAnimator.ofInt(this, "progress", getProgress(), i * 100);
        objectAnimatorOfInt.setDuration(i2);
        objectAnimatorOfInt.setInterpolator(interpolator);
        if (animatorListenerAdapter != null) {
            objectAnimatorOfInt.addListener(animatorListenerAdapter);
        }
        return objectAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDismissAnimation() {
        io.dcloud.nineoldandroids.animation.ObjectAnimator objectAnimatorOfFloat = io.dcloud.nineoldandroids.animation.ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setInterpolator(new android.view.animation.DecelerateInterpolator());
        objectAnimatorOfFloat.addListener(new io.dcloud.nineoldandroids.animation.AnimatorListenerAdapter() { // from class: com.dcloud.android.widget.DCWebViewProgressBar.3
            @Override // io.dcloud.nineoldandroids.animation.AnimatorListenerAdapter, io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
            public void onAnimationEnd(io.dcloud.nineoldandroids.animation.Animator animator) {
                com.dcloud.android.widget.DCWebViewProgressBar.this.setProgress(0);
            }
        });
        objectAnimatorOfFloat.start();
    }

    public void finishProgress() {
        if (this.isFinish) {
            return;
        }
        this.isFinish = true;
        io.dcloud.nineoldandroids.animation.ObjectAnimator objectAnimator = this.mCurrentAnmiator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        io.dcloud.nineoldandroids.animation.ObjectAnimator progressAnimation = getProgressAnimation(100, com.facebook.common.statfs.StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB, new android.view.animation.AccelerateInterpolator(), new io.dcloud.nineoldandroids.animation.AnimatorListenerAdapter() { // from class: com.dcloud.android.widget.DCWebViewProgressBar.2
            @Override // io.dcloud.nineoldandroids.animation.AnimatorListenerAdapter, io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
            public void onAnimationEnd(io.dcloud.nineoldandroids.animation.Animator animator) {
                super.onAnimationEnd(animator);
                com.dcloud.android.widget.DCWebViewProgressBar dCWebViewProgressBar = com.dcloud.android.widget.DCWebViewProgressBar.this;
                if (dCWebViewProgressBar.isFinish) {
                    dCWebViewProgressBar.startDismissAnimation();
                }
            }
        });
        this.mCurrentAnmiator = progressAnimation;
        progressAnimation.start();
    }

    public void setAlphaInt(int i) {
        this.alpha = i;
    }

    public void setColorInt(int i) {
        int iArgb = android.graphics.Color.argb(this.alpha, android.graphics.Color.red(i), android.graphics.Color.green(i), android.graphics.Color.blue(i));
        android.graphics.drawable.ClipDrawable clipDrawable = new android.graphics.drawable.ClipDrawable(new android.graphics.drawable.ColorDrawable(0), 3, 1);
        clipDrawable.setLevel(io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH);
        android.graphics.drawable.ClipDrawable clipDrawable2 = new android.graphics.drawable.ClipDrawable(new android.graphics.drawable.ColorDrawable(iArgb), 3, 1);
        android.graphics.drawable.LayerDrawable layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{clipDrawable, clipDrawable2, clipDrawable2});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        setProgressDrawable(layerDrawable);
    }

    public void startProgress() {
        setProgress(0);
        setAlpha(1.0f);
        this.isFinish = false;
        final android.view.animation.DecelerateInterpolator decelerateInterpolator = new android.view.animation.DecelerateInterpolator();
        io.dcloud.nineoldandroids.animation.ObjectAnimator progressAnimation = getProgressAnimation(30, 2000, decelerateInterpolator, new io.dcloud.nineoldandroids.animation.AnimatorListenerAdapter() { // from class: com.dcloud.android.widget.DCWebViewProgressBar.1
            @Override // io.dcloud.nineoldandroids.animation.AnimatorListenerAdapter, io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
            public void onAnimationEnd(io.dcloud.nineoldandroids.animation.Animator animator) {
                super.onAnimationEnd(animator);
                com.dcloud.android.widget.DCWebViewProgressBar dCWebViewProgressBar = com.dcloud.android.widget.DCWebViewProgressBar.this;
                if (dCWebViewProgressBar.isFinish) {
                    return;
                }
                dCWebViewProgressBar.mCurrentAnmiator = dCWebViewProgressBar.getProgressAnimation(70, 2000, decelerateInterpolator, new io.dcloud.nineoldandroids.animation.AnimatorListenerAdapter() { // from class: com.dcloud.android.widget.DCWebViewProgressBar.1.1
                    @Override // io.dcloud.nineoldandroids.animation.AnimatorListenerAdapter, io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
                    public void onAnimationEnd(io.dcloud.nineoldandroids.animation.Animator animator2) {
                        super.onAnimationEnd(animator2);
                        com.dcloud.android.widget.DCWebViewProgressBar.AnonymousClass1 anonymousClass1 = com.dcloud.android.widget.DCWebViewProgressBar.AnonymousClass1.this;
                        com.dcloud.android.widget.DCWebViewProgressBar dCWebViewProgressBar2 = com.dcloud.android.widget.DCWebViewProgressBar.this;
                        if (dCWebViewProgressBar2.isFinish) {
                            return;
                        }
                        dCWebViewProgressBar2.mCurrentAnmiator = dCWebViewProgressBar2.getProgressAnimation(95, 50000, decelerateInterpolator, null);
                        com.dcloud.android.widget.DCWebViewProgressBar.this.mCurrentAnmiator.start();
                    }
                });
                com.dcloud.android.widget.DCWebViewProgressBar.this.mCurrentAnmiator.start();
            }
        });
        this.mCurrentAnmiator = progressAnimation;
        progressAnimation.start();
    }
}
