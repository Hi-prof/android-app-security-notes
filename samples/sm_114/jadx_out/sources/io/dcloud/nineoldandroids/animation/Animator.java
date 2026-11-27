package io.dcloud.nineoldandroids.animation;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Animator implements java.lang.Cloneable {
    java.util.ArrayList<io.dcloud.nineoldandroids.animation.Animator.AnimatorListener> mListeners = null;

    public interface AnimatorListener {
        void onAnimationCancel(io.dcloud.nineoldandroids.animation.Animator animator);

        void onAnimationEnd(io.dcloud.nineoldandroids.animation.Animator animator);

        void onAnimationRepeat(io.dcloud.nineoldandroids.animation.Animator animator);

        void onAnimationStart(io.dcloud.nineoldandroids.animation.Animator animator);
    }

    public void cancel() {
    }

    public void end() {
    }

    public abstract long getDuration();

    public abstract long getStartDelay();

    public abstract boolean isRunning();

    public abstract io.dcloud.nineoldandroids.animation.Animator setDuration(long j);

    public abstract void setInterpolator(android.view.animation.Interpolator interpolator);

    public abstract void setStartDelay(long j);

    public void setTarget(java.lang.Object obj) {
    }

    public void setupEndValues() {
    }

    public void setupStartValues() {
    }

    public void start() {
    }

    public boolean isStarted() {
        return isRunning();
    }

    public void addListener(io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener) {
        if (this.mListeners == null) {
            this.mListeners = new java.util.ArrayList<>();
        }
        this.mListeners.add(animatorListener);
    }

    public void removeListener(io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener) {
        java.util.ArrayList<io.dcloud.nineoldandroids.animation.Animator.AnimatorListener> arrayList = this.mListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
    }

    public java.util.ArrayList<io.dcloud.nineoldandroids.animation.Animator.AnimatorListener> getListeners() {
        return this.mListeners;
    }

    public void removeAllListeners() {
        java.util.ArrayList<io.dcloud.nineoldandroids.animation.Animator.AnimatorListener> arrayList = this.mListeners;
        if (arrayList != null) {
            arrayList.clear();
            this.mListeners = null;
        }
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public io.dcloud.nineoldandroids.animation.Animator m435clone() {
        try {
            io.dcloud.nineoldandroids.animation.Animator animator = (io.dcloud.nineoldandroids.animation.Animator) super.clone();
            java.util.ArrayList<io.dcloud.nineoldandroids.animation.Animator.AnimatorListener> arrayList = this.mListeners;
            if (arrayList != null) {
                animator.mListeners = new java.util.ArrayList<>();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    animator.mListeners.add(arrayList.get(i));
                }
            }
            return animator;
        } catch (java.lang.CloneNotSupportedException unused) {
            throw new java.lang.AssertionError();
        }
    }
}
