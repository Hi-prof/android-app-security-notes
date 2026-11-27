package io.dcloud.nineoldandroids.view;

/* JADX INFO: loaded from: classes2.dex */
class ViewPropertyAnimatorHC extends io.dcloud.nineoldandroids.view.ViewPropertyAnimator {
    private static final int ALPHA = 512;
    private static final int NONE = 0;
    private static final int ROTATION = 16;
    private static final int ROTATION_X = 32;
    private static final int ROTATION_Y = 64;
    private static final int SCALE_X = 4;
    private static final int SCALE_Y = 8;
    private static final int TRANSFORM_MASK = 511;
    private static final int TRANSLATION_X = 1;
    private static final int TRANSLATION_Y = 2;
    private static final int X = 128;
    private static final int Y = 256;
    private long mDuration;
    private android.view.animation.Interpolator mInterpolator;
    private final java.lang.ref.WeakReference<android.view.View> mView;
    private boolean mDurationSet = false;
    private long mStartDelay = 0;
    private boolean mStartDelaySet = false;
    private boolean mInterpolatorSet = false;
    private io.dcloud.nineoldandroids.animation.Animator.AnimatorListener mListener = null;
    private io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.AnimatorEventListener mAnimatorEventListener = new io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.AnimatorEventListener(this, null);
    java.util.ArrayList<io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.NameValuesHolder> mPendingAnimations = new java.util.ArrayList<>();
    private java.lang.Runnable mAnimationStarter = new java.lang.Runnable() { // from class: io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.1
        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.this.startAnimation();
        }
    };
    private java.util.HashMap<io.dcloud.nineoldandroids.animation.Animator, io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.PropertyBundle> mAnimatorMap = new java.util.HashMap<>();

    private static class PropertyBundle {
        java.util.ArrayList<io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.NameValuesHolder> mNameValuesHolder;
        int mPropertyMask;

        PropertyBundle(int i, java.util.ArrayList<io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.NameValuesHolder> arrayList) {
            this.mPropertyMask = i;
            this.mNameValuesHolder = arrayList;
        }

        boolean cancel(int i) {
            java.util.ArrayList<io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.NameValuesHolder> arrayList;
            if ((this.mPropertyMask & i) != 0 && (arrayList = this.mNameValuesHolder) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.mNameValuesHolder.get(i2).mNameConstant == i) {
                        this.mNameValuesHolder.remove(i2);
                        this.mPropertyMask = (~i) & this.mPropertyMask;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private static class NameValuesHolder {
        float mDeltaValue;
        float mFromValue;
        int mNameConstant;

        NameValuesHolder(int i, float f, float f2) {
            this.mNameConstant = i;
            this.mFromValue = f;
            this.mDeltaValue = f2;
        }
    }

    ViewPropertyAnimatorHC(android.view.View view) {
        this.mView = new java.lang.ref.WeakReference<>(view);
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator setDuration(long j) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.mDurationSet = true;
        this.mDuration = j;
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public long getDuration() {
        if (this.mDurationSet) {
            return this.mDuration;
        }
        return new io.dcloud.nineoldandroids.animation.ValueAnimator().getDuration();
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public long getStartDelay() {
        if (this.mStartDelaySet) {
            return this.mStartDelay;
        }
        return 0L;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator setStartDelay(long j) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.mStartDelaySet = true;
        this.mStartDelay = j;
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator setInterpolator(android.view.animation.Interpolator interpolator) {
        this.mInterpolatorSet = true;
        this.mInterpolator = interpolator;
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator setListener(io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener) {
        this.mListener = animatorListener;
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public void start() {
        startAnimation();
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public void cancel() {
        if (this.mAnimatorMap.size() > 0) {
            java.util.Iterator it = ((java.util.HashMap) this.mAnimatorMap.clone()).keySet().iterator();
            while (it.hasNext()) {
                ((io.dcloud.nineoldandroids.animation.Animator) it.next()).cancel();
            }
        }
        this.mPendingAnimations.clear();
        android.view.View view = this.mView.get();
        if (view != null) {
            view.removeCallbacks(this.mAnimationStarter);
        }
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator x(float f) {
        animateProperty(128, f);
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator xBy(float f) {
        animatePropertyBy(128, f);
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator y(float f) {
        animateProperty(256, f);
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator yBy(float f) {
        animatePropertyBy(256, f);
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator rotation(float f) {
        animateProperty(16, f);
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator rotationBy(float f) {
        animatePropertyBy(16, f);
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator rotationX(float f) {
        animateProperty(32, f);
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator rotationXBy(float f) {
        animatePropertyBy(32, f);
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator rotationY(float f) {
        animateProperty(64, f);
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator rotationYBy(float f) {
        animatePropertyBy(64, f);
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator translationX(float f) {
        animateProperty(1, f);
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator translationXBy(float f) {
        animatePropertyBy(1, f);
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator translationY(float f) {
        animateProperty(2, f);
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator translationYBy(float f) {
        animatePropertyBy(2, f);
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator scaleX(float f) {
        animateProperty(4, f);
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator scaleXBy(float f) {
        animatePropertyBy(4, f);
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator scaleY(float f) {
        animateProperty(8, f);
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator scaleYBy(float f) {
        animatePropertyBy(8, f);
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator alpha(float f) {
        animateProperty(512, f);
        return this;
    }

    @Override // io.dcloud.nineoldandroids.view.ViewPropertyAnimator
    public io.dcloud.nineoldandroids.view.ViewPropertyAnimator alphaBy(float f) {
        animatePropertyBy(512, f);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnimation() {
        io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimatorOfFloat = io.dcloud.nineoldandroids.animation.ValueAnimator.ofFloat(1.0f);
        java.util.ArrayList arrayList = (java.util.ArrayList) this.mPendingAnimations.clone();
        this.mPendingAnimations.clear();
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i |= ((io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.NameValuesHolder) arrayList.get(i2)).mNameConstant;
        }
        this.mAnimatorMap.put(valueAnimatorOfFloat, new io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.PropertyBundle(i, arrayList));
        valueAnimatorOfFloat.addUpdateListener(this.mAnimatorEventListener);
        valueAnimatorOfFloat.addListener(this.mAnimatorEventListener);
        if (this.mStartDelaySet) {
            valueAnimatorOfFloat.setStartDelay(this.mStartDelay);
        }
        if (this.mDurationSet) {
            valueAnimatorOfFloat.setDuration(this.mDuration);
        }
        if (this.mInterpolatorSet) {
            valueAnimatorOfFloat.setInterpolator(this.mInterpolator);
        }
        valueAnimatorOfFloat.start();
    }

    private void animateProperty(int i, float f) {
        float value = getValue(i);
        animatePropertyBy(i, value, f - value);
    }

    private void animatePropertyBy(int i, float f) {
        animatePropertyBy(i, getValue(i), f);
    }

    private void animatePropertyBy(int i, float f, float f2) {
        io.dcloud.nineoldandroids.animation.Animator animator;
        if (this.mAnimatorMap.size() > 0) {
            java.util.Iterator<io.dcloud.nineoldandroids.animation.Animator> it = this.mAnimatorMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    animator = null;
                    break;
                }
                io.dcloud.nineoldandroids.animation.Animator next = it.next();
                io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.PropertyBundle propertyBundle = this.mAnimatorMap.get(next);
                if (propertyBundle.cancel(i) && propertyBundle.mPropertyMask == 0) {
                    animator = next;
                    break;
                }
            }
            if (animator != null) {
                animator.cancel();
            }
        }
        this.mPendingAnimations.add(new io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.NameValuesHolder(i, f, f2));
        android.view.View view = this.mView.get();
        if (view != null) {
            view.removeCallbacks(this.mAnimationStarter);
            view.post(this.mAnimationStarter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(int i, float f) {
        android.view.View view = this.mView.get();
        if (view != null) {
            if (i == 1) {
                view.setTranslationX(f);
                return;
            }
            if (i == 2) {
                view.setTranslationY(f);
                return;
            }
            if (i == 4) {
                view.setScaleX(f);
                return;
            }
            if (i == 8) {
                view.setScaleY(f);
                return;
            }
            if (i == 16) {
                view.setRotation(f);
                return;
            }
            if (i == 32) {
                view.setRotationX(f);
                return;
            }
            if (i == 64) {
                view.setRotationY(f);
                return;
            }
            if (i == 128) {
                view.setX(f);
            } else if (i == 256) {
                view.setY(f);
            } else {
                if (i != 512) {
                    return;
                }
                view.setAlpha(f);
            }
        }
    }

    private float getValue(int i) {
        android.view.View view = this.mView.get();
        if (view == null) {
            return 0.0f;
        }
        if (i == 1) {
            return view.getTranslationX();
        }
        if (i == 2) {
            return view.getTranslationY();
        }
        if (i == 4) {
            return view.getScaleX();
        }
        if (i == 8) {
            return view.getScaleY();
        }
        if (i == 16) {
            return view.getRotation();
        }
        if (i == 32) {
            return view.getRotationX();
        }
        if (i == 64) {
            return view.getRotationY();
        }
        if (i == 128) {
            return view.getX();
        }
        if (i == 256) {
            return view.getY();
        }
        if (i != 512) {
            return 0.0f;
        }
        return view.getAlpha();
    }

    private class AnimatorEventListener implements io.dcloud.nineoldandroids.animation.Animator.AnimatorListener, io.dcloud.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener {
        private AnimatorEventListener() {
        }

        /* synthetic */ AnimatorEventListener(io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC viewPropertyAnimatorHC, io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.AnimatorEventListener animatorEventListener) {
            this();
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationStart(io.dcloud.nineoldandroids.animation.Animator animator) {
            if (io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.this.mListener != null) {
                io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.this.mListener.onAnimationStart(animator);
            }
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(io.dcloud.nineoldandroids.animation.Animator animator) {
            if (io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.this.mListener != null) {
                io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.this.mListener.onAnimationCancel(animator);
            }
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationRepeat(io.dcloud.nineoldandroids.animation.Animator animator) {
            if (io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.this.mListener != null) {
                io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.this.mListener.onAnimationRepeat(animator);
            }
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(io.dcloud.nineoldandroids.animation.Animator animator) {
            if (io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.this.mListener != null) {
                io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.this.mListener.onAnimationEnd(animator);
            }
            io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.this.mAnimatorMap.remove(animator);
            if (io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.this.mAnimatorMap.isEmpty()) {
                io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.this.mListener = null;
            }
        }

        @Override // io.dcloud.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimator) {
            android.view.View view;
            float animatedFraction = valueAnimator.getAnimatedFraction();
            io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.PropertyBundle propertyBundle = (io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.PropertyBundle) io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.this.mAnimatorMap.get(valueAnimator);
            if ((propertyBundle.mPropertyMask & 511) != 0 && (view = (android.view.View) io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.this.mView.get()) != null) {
                view.invalidate();
            }
            java.util.ArrayList<io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.NameValuesHolder> arrayList = propertyBundle.mNameValuesHolder;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.NameValuesHolder nameValuesHolder = arrayList.get(i);
                    io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.this.setValue(nameValuesHolder.mNameConstant, nameValuesHolder.mFromValue + (nameValuesHolder.mDeltaValue * animatedFraction));
                }
            }
            android.view.View view2 = (android.view.View) io.dcloud.nineoldandroids.view.ViewPropertyAnimatorHC.this.mView.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }
    }
}
