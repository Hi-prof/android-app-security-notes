package io.dcloud.nineoldandroids.view;

/* JADX INFO: loaded from: classes2.dex */
class ViewPropertyAnimatorICS extends io.dcloud.nineoldandroids.view.ViewPropertyAnimator {
    private static final long RETURN_WHEN_NULL = -1;
    private final java.lang.ref.WeakReference<android.view.ViewPropertyAnimator> mNative;

    ViewPropertyAnimatorICS(android.view.View view) {
        this.mNative = new java.lang.ref.WeakReference<>(view.animate());
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator setDuration(long j) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setDuration(j);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public long getDuration() {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getDuration();
        }
        return -1L;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator setStartDelay(long j) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setStartDelay(j);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public long getStartDelay() {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getStartDelay();
        }
        return -1L;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator setInterpolator(android.view.animation.Interpolator interpolator) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setInterpolator(interpolator);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator setListener(final io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            if (animatorListener == null) {
                viewPropertyAnimator.setListener(null);
                return this;
            }
            viewPropertyAnimator.setListener(new android.animation.Animator.AnimatorListener() { // from class: io.dcloud.nineoldandroids.view.ViewPropertyAnimatorICS.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                    animatorListener.onAnimationStart(null);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(android.animation.Animator animator) {
                    animatorListener.onAnimationRepeat(null);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    animatorListener.onAnimationEnd(null);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    animatorListener.onAnimationCancel(null);
                }
            });
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public void start() {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.start();
        }
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public void cancel() {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator x(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.x(f);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator xBy(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.xBy(f);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator y(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.y(f);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator yBy(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.yBy(f);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator rotation(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotation(f);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator rotationBy(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationBy(f);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator rotationX(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationX(f);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator rotationXBy(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationXBy(f);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator rotationY(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationY(f);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator rotationYBy(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationYBy(f);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator translationX(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationX(f);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator translationXBy(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationXBy(f);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator translationY(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationY(f);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator translationYBy(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationYBy(f);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator scaleX(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleX(f);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator scaleXBy(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleXBy(f);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator scaleY(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleY(f);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator scaleYBy(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleYBy(f);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator alpha(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alpha(f);
        }
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator alphaBy(float f) {
        android.view.ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alphaBy(f);
        }
        return this;
    }
}
