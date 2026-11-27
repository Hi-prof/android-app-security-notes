package io.dcloud.nineoldandroids.animation;

/* JADX INFO: loaded from: classes2.dex */
public class ValueAnimator extends io.dcloud.nineoldandroids.animation.Animator {
    static final int ANIMATION_FRAME = 1;
    static final int ANIMATION_START = 0;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    static final int RUNNING = 1;
    static final int SEEKED = 2;
    static final int STOPPED = 0;
    private long mDelayStartTime;
    long mStartTime;
    io.dcloud.nineoldandroids.animation.PropertyValuesHolder[] mValues;
    java.util.HashMap<java.lang.String, io.dcloud.nineoldandroids.animation.PropertyValuesHolder> mValuesMap;
    private static java.lang.ThreadLocal<io.dcloud.nineoldandroids.animation.ValueAnimator.AnimationHandler> sAnimationHandler = new java.lang.ThreadLocal<>();
    private static final java.lang.ThreadLocal<java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator>> sAnimations = new java.lang.ThreadLocal<java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator>>() { // from class: io.dcloud.nineoldandroids.animation.ValueAnimator.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator> initialValue() {
            return new java.util.ArrayList<>();
        }
    };
    private static final java.lang.ThreadLocal<java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator>> sPendingAnimations = new java.lang.ThreadLocal<java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator>>() { // from class: io.dcloud.nineoldandroids.animation.ValueAnimator.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator> initialValue() {
            return new java.util.ArrayList<>();
        }
    };
    private static final java.lang.ThreadLocal<java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator>> sDelayedAnims = new java.lang.ThreadLocal<java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator>>() { // from class: io.dcloud.nineoldandroids.animation.ValueAnimator.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator> initialValue() {
            return new java.util.ArrayList<>();
        }
    };
    private static final java.lang.ThreadLocal<java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator>> sEndingAnims = new java.lang.ThreadLocal<java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator>>() { // from class: io.dcloud.nineoldandroids.animation.ValueAnimator.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator> initialValue() {
            return new java.util.ArrayList<>();
        }
    };
    private static final java.lang.ThreadLocal<java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator>> sReadyAnims = new java.lang.ThreadLocal<java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator>>() { // from class: io.dcloud.nineoldandroids.animation.ValueAnimator.5
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator> initialValue() {
            return new java.util.ArrayList<>();
        }
    };
    private static final android.view.animation.Interpolator sDefaultInterpolator = new android.view.animation.AccelerateDecelerateInterpolator();
    private static final io.dcloud.nineoldandroids.animation.TypeEvaluator sIntEvaluator = new io.dcloud.nineoldandroids.animation.IntEvaluator();
    private static final io.dcloud.nineoldandroids.animation.TypeEvaluator sFloatEvaluator = new io.dcloud.nineoldandroids.animation.FloatEvaluator();
    private static final long DEFAULT_FRAME_DELAY = 10;
    private static long sFrameDelay = DEFAULT_FRAME_DELAY;
    long mSeekTime = -1;
    private boolean mPlayingBackwards = false;
    private int mCurrentIteration = 0;
    private float mCurrentFraction = 0.0f;
    private boolean mStartedDelay = false;
    int mPlayingState = 0;
    private boolean mRunning = false;
    private boolean mStarted = false;
    boolean mInitialized = false;
    private long mDuration = 300;
    private long mStartDelay = 0;
    private int mRepeatCount = 0;
    private int mRepeatMode = 1;
    private android.view.animation.Interpolator mInterpolator = sDefaultInterpolator;
    private java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener> mUpdateListeners = null;

    public interface AnimatorUpdateListener {
        void onAnimationUpdate(io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimator);
    }

    public static io.dcloud.nineoldandroids.animation.ValueAnimator ofInt(int... iArr) {
        io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimator = new io.dcloud.nineoldandroids.animation.ValueAnimator();
        valueAnimator.setIntValues(iArr);
        return valueAnimator;
    }

    public static io.dcloud.nineoldandroids.animation.ValueAnimator ofFloat(float... fArr) {
        io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimator = new io.dcloud.nineoldandroids.animation.ValueAnimator();
        valueAnimator.setFloatValues(fArr);
        return valueAnimator;
    }

    public static io.dcloud.nineoldandroids.animation.ValueAnimator ofPropertyValuesHolder(io.dcloud.nineoldandroids.animation.PropertyValuesHolder... propertyValuesHolderArr) {
        io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimator = new io.dcloud.nineoldandroids.animation.ValueAnimator();
        valueAnimator.setValues(propertyValuesHolderArr);
        return valueAnimator;
    }

    public static io.dcloud.nineoldandroids.animation.ValueAnimator ofObject(io.dcloud.nineoldandroids.animation.TypeEvaluator typeEvaluator, java.lang.Object... objArr) {
        io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimator = new io.dcloud.nineoldandroids.animation.ValueAnimator();
        valueAnimator.setObjectValues(objArr);
        valueAnimator.setEvaluator(typeEvaluator);
        return valueAnimator;
    }

    public void setIntValues(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        io.dcloud.nineoldandroids.animation.PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
        if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
            setValues(io.dcloud.nineoldandroids.animation.PropertyValuesHolder.ofInt("", iArr));
        } else {
            propertyValuesHolderArr[0].setIntValues(iArr);
        }
        this.mInitialized = false;
    }

    public void setFloatValues(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            return;
        }
        io.dcloud.nineoldandroids.animation.PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
        if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
            setValues(io.dcloud.nineoldandroids.animation.PropertyValuesHolder.ofFloat("", fArr));
        } else {
            propertyValuesHolderArr[0].setFloatValues(fArr);
        }
        this.mInitialized = false;
    }

    public void setObjectValues(java.lang.Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        io.dcloud.nineoldandroids.animation.PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
        if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
            setValues(io.dcloud.nineoldandroids.animation.PropertyValuesHolder.ofObject("", (io.dcloud.nineoldandroids.animation.TypeEvaluator) null, objArr));
        } else {
            propertyValuesHolderArr[0].setObjectValues(objArr);
        }
        this.mInitialized = false;
    }

    public void setValues(io.dcloud.nineoldandroids.animation.PropertyValuesHolder... propertyValuesHolderArr) {
        int length = propertyValuesHolderArr.length;
        this.mValues = propertyValuesHolderArr;
        this.mValuesMap = new java.util.HashMap<>(length);
        for (io.dcloud.nineoldandroids.animation.PropertyValuesHolder propertyValuesHolder : propertyValuesHolderArr) {
            this.mValuesMap.put(propertyValuesHolder.getPropertyName(), propertyValuesHolder);
        }
        this.mInitialized = false;
    }

    public io.dcloud.nineoldandroids.animation.PropertyValuesHolder[] getValues() {
        return this.mValues;
    }

    void initAnimation() {
        if (this.mInitialized) {
            return;
        }
        int length = this.mValues.length;
        for (int i = 0; i < length; i++) {
            this.mValues[i].init();
        }
        this.mInitialized = true;
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public io.dcloud.nineoldandroids.animation.ValueAnimator setDuration(long j) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.mDuration = j;
        return this;
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public long getDuration() {
        return this.mDuration;
    }

    public void setCurrentPlayTime(long j) {
        initAnimation();
        long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
        if (this.mPlayingState != 1) {
            this.mSeekTime = j;
            this.mPlayingState = 2;
        }
        this.mStartTime = jCurrentAnimationTimeMillis - j;
        animationFrame(jCurrentAnimationTimeMillis);
    }

    public long getCurrentPlayTime() {
        if (!this.mInitialized || this.mPlayingState == 0) {
            return 0L;
        }
        return android.view.animation.AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
    }

    private static class AnimationHandler extends android.os.Handler {
        private AnimationHandler() {
        }

        /* synthetic */ AnimationHandler(io.dcloud.nineoldandroids.animation.ValueAnimator.AnimationHandler animationHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            boolean z;
            java.util.ArrayList arrayList = (java.util.ArrayList) io.dcloud.nineoldandroids.animation.ValueAnimator.sAnimations.get();
            java.util.ArrayList arrayList2 = (java.util.ArrayList) io.dcloud.nineoldandroids.animation.ValueAnimator.sDelayedAnims.get();
            int i = message.what;
            if (i == 0) {
                java.util.ArrayList arrayList3 = (java.util.ArrayList) io.dcloud.nineoldandroids.animation.ValueAnimator.sPendingAnimations.get();
                boolean z2 = arrayList.size() <= 0 && arrayList2.size() <= 0;
                while (arrayList3.size() > 0) {
                    java.util.ArrayList arrayList4 = (java.util.ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimator = (io.dcloud.nineoldandroids.animation.ValueAnimator) arrayList4.get(i2);
                        if (valueAnimator.mStartDelay != 0) {
                            arrayList2.add(valueAnimator);
                        } else {
                            valueAnimator.startAnimation();
                        }
                    }
                }
                z = z2;
            } else if (i != 1) {
                return;
            } else {
                z = true;
            }
            long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            java.util.ArrayList arrayList5 = (java.util.ArrayList) io.dcloud.nineoldandroids.animation.ValueAnimator.sReadyAnims.get();
            java.util.ArrayList arrayList6 = (java.util.ArrayList) io.dcloud.nineoldandroids.animation.ValueAnimator.sEndingAnims.get();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimator2 = (io.dcloud.nineoldandroids.animation.ValueAnimator) arrayList2.get(i3);
                if (valueAnimator2.delayedAnimationFrame(jCurrentAnimationTimeMillis)) {
                    arrayList5.add(valueAnimator2);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i4 = 0; i4 < size3; i4++) {
                    io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimator3 = (io.dcloud.nineoldandroids.animation.ValueAnimator) arrayList5.get(i4);
                    valueAnimator3.startAnimation();
                    valueAnimator3.mRunning = true;
                    arrayList2.remove(valueAnimator3);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i5 = 0;
            while (i5 < size4) {
                io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimator4 = (io.dcloud.nineoldandroids.animation.ValueAnimator) arrayList.get(i5);
                if (valueAnimator4.animationFrame(jCurrentAnimationTimeMillis)) {
                    arrayList6.add(valueAnimator4);
                }
                if (arrayList.size() == size4) {
                    i5++;
                } else {
                    size4--;
                    arrayList6.remove(valueAnimator4);
                }
            }
            if (arrayList6.size() > 0) {
                for (int i6 = 0; i6 < arrayList6.size(); i6++) {
                    ((io.dcloud.nineoldandroids.animation.ValueAnimator) arrayList6.get(i6)).endAnimation();
                }
                arrayList6.clear();
            }
            if (z) {
                if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                    return;
                }
                sendEmptyMessageDelayed(1, java.lang.Math.max(0L, io.dcloud.nineoldandroids.animation.ValueAnimator.sFrameDelay - (android.view.animation.AnimationUtils.currentAnimationTimeMillis() - jCurrentAnimationTimeMillis)));
            }
        }
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public long getStartDelay() {
        return this.mStartDelay;
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public void setStartDelay(long j) {
        this.mStartDelay = j;
    }

    public static long getFrameDelay() {
        return sFrameDelay;
    }

    public static void setFrameDelay(long j) {
        sFrameDelay = j;
    }

    public java.lang.Object getAnimatedValue() {
        io.dcloud.nineoldandroids.animation.PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
        if (propertyValuesHolderArr == null || propertyValuesHolderArr.length <= 0) {
            return null;
        }
        return propertyValuesHolderArr[0].getAnimatedValue();
    }

    public java.lang.Object getAnimatedValue(java.lang.String str) {
        io.dcloud.nineoldandroids.animation.PropertyValuesHolder propertyValuesHolder = this.mValuesMap.get(str);
        if (propertyValuesHolder != null) {
            return propertyValuesHolder.getAnimatedValue();
        }
        return null;
    }

    public void setRepeatCount(int i) {
        this.mRepeatCount = i;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public void addUpdateListener(io.dcloud.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        if (this.mUpdateListeners == null) {
            this.mUpdateListeners = new java.util.ArrayList<>();
        }
        this.mUpdateListeners.add(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
        this.mUpdateListeners = null;
    }

    public void removeUpdateListener(io.dcloud.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorUpdateListener);
        if (this.mUpdateListeners.size() == 0) {
            this.mUpdateListeners = null;
        }
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public void setInterpolator(android.view.animation.Interpolator interpolator) {
        if (interpolator != null) {
            this.mInterpolator = interpolator;
        } else {
            this.mInterpolator = new android.view.animation.LinearInterpolator();
        }
    }

    public android.view.animation.Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public void setEvaluator(io.dcloud.nineoldandroids.animation.TypeEvaluator typeEvaluator) {
        io.dcloud.nineoldandroids.animation.PropertyValuesHolder[] propertyValuesHolderArr;
        if (typeEvaluator == null || (propertyValuesHolderArr = this.mValues) == null || propertyValuesHolderArr.length <= 0) {
            return;
        }
        propertyValuesHolderArr[0].setEvaluator(typeEvaluator);
    }

    private void start(boolean z) {
        if (android.os.Looper.myLooper() == null) {
            throw new android.util.AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.mPlayingBackwards = z;
        this.mCurrentIteration = 0;
        this.mPlayingState = 0;
        this.mStarted = true;
        this.mStartedDelay = false;
        sPendingAnimations.get().add(this);
        if (this.mStartDelay == 0) {
            setCurrentPlayTime(getCurrentPlayTime());
            this.mPlayingState = 0;
            this.mRunning = true;
            if (this.mListeners != null) {
                java.util.ArrayList arrayList = (java.util.ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((io.dcloud.nineoldandroids.animation.Animator.AnimatorListener) arrayList.get(i)).onAnimationStart(this);
                }
            }
        }
        io.dcloud.nineoldandroids.animation.ValueAnimator.AnimationHandler animationHandler = sAnimationHandler.get();
        if (animationHandler == null) {
            animationHandler = new io.dcloud.nineoldandroids.animation.ValueAnimator.AnimationHandler(null);
            sAnimationHandler.set(animationHandler);
        }
        animationHandler.sendEmptyMessage(0);
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public void start() {
        start(false);
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public void cancel() {
        if (this.mPlayingState != 0 || sPendingAnimations.get().contains(this) || sDelayedAnims.get().contains(this)) {
            if (this.mRunning && this.mListeners != null) {
                java.util.Iterator it = ((java.util.ArrayList) this.mListeners.clone()).iterator();
                while (it.hasNext()) {
                    ((io.dcloud.nineoldandroids.animation.Animator.AnimatorListener) it.next()).onAnimationCancel(this);
                }
            }
            endAnimation();
        }
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public void end() {
        if (!sAnimations.get().contains(this) && !sPendingAnimations.get().contains(this)) {
            this.mStartedDelay = false;
            startAnimation();
        } else if (!this.mInitialized) {
            initAnimation();
        }
        int i = this.mRepeatCount;
        if (i > 0 && (i & 1) == 1) {
            animateValue(0.0f);
        } else {
            animateValue(1.0f);
        }
        endAnimation();
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public boolean isRunning() {
        return this.mPlayingState == 1 || this.mRunning;
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public boolean isStarted() {
        return this.mStarted;
    }

    public void reverse() {
        this.mPlayingBackwards = !this.mPlayingBackwards;
        if (this.mPlayingState == 1) {
            long jCurrentAnimationTimeMillis = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
            this.mStartTime = jCurrentAnimationTimeMillis - (this.mDuration - (jCurrentAnimationTimeMillis - this.mStartTime));
            return;
        }
        start(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endAnimation() {
        sAnimations.get().remove(this);
        sPendingAnimations.get().remove(this);
        sDelayedAnims.get().remove(this);
        this.mPlayingState = 0;
        if (this.mRunning && this.mListeners != null) {
            java.util.ArrayList arrayList = (java.util.ArrayList) this.mListeners.clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((io.dcloud.nineoldandroids.animation.Animator.AnimatorListener) arrayList.get(i)).onAnimationEnd(this);
            }
        }
        this.mRunning = false;
        this.mStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnimation() {
        initAnimation();
        sAnimations.get().add(this);
        if (this.mStartDelay <= 0 || this.mListeners == null) {
            return;
        }
        java.util.ArrayList arrayList = (java.util.ArrayList) this.mListeners.clone();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((io.dcloud.nineoldandroids.animation.Animator.AnimatorListener) arrayList.get(i)).onAnimationStart(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean delayedAnimationFrame(long j) {
        if (!this.mStartedDelay) {
            this.mStartedDelay = true;
            this.mDelayStartTime = j;
            return false;
        }
        long j2 = j - this.mDelayStartTime;
        long j3 = this.mStartDelay;
        if (j2 <= j3) {
            return false;
        }
        this.mStartTime = j - (j2 - j3);
        this.mPlayingState = 1;
        return true;
    }

    boolean animationFrame(long j) {
        boolean z = true;
        if (this.mPlayingState == 0) {
            this.mPlayingState = 1;
            long j2 = this.mSeekTime;
            if (j2 < 0) {
                this.mStartTime = j;
            } else {
                this.mStartTime = j - j2;
                this.mSeekTime = -1L;
            }
        }
        int i = this.mPlayingState;
        if (i != 1 && i != 2) {
            return false;
        }
        long j3 = this.mDuration;
        float fMin = j3 > 0 ? (j - this.mStartTime) / j3 : 1.0f;
        if (fMin >= 1.0f) {
            int i2 = this.mCurrentIteration;
            int i3 = this.mRepeatCount;
            if (i2 < i3 || i3 == -1) {
                if (this.mListeners != null) {
                    int size = this.mListeners.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        this.mListeners.get(i4).onAnimationRepeat(this);
                    }
                }
                if (this.mRepeatMode == 2) {
                    this.mPlayingBackwards = !this.mPlayingBackwards;
                }
                this.mCurrentIteration += (int) fMin;
                fMin %= 1.0f;
                this.mStartTime += this.mDuration;
                z = false;
            } else {
                fMin = java.lang.Math.min(fMin, 1.0f);
            }
        } else {
            z = false;
        }
        if (this.mPlayingBackwards) {
            fMin = 1.0f - fMin;
        }
        animateValue(fMin);
        return z;
    }

    public float getAnimatedFraction() {
        return this.mCurrentFraction;
    }

    void animateValue(float f) {
        float interpolation = this.mInterpolator.getInterpolation(f);
        this.mCurrentFraction = interpolation;
        int length = this.mValues.length;
        for (int i = 0; i < length; i++) {
            this.mValues[i].calculateValue(interpolation);
        }
        java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mUpdateListeners.get(i2).onAnimationUpdate(this);
            }
        }
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    /* JADX INFO: renamed from: clone */
    public io.dcloud.nineoldandroids.animation.ValueAnimator m435clone() {
        io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimator = (io.dcloud.nineoldandroids.animation.ValueAnimator) super.m435clone();
        java.util.ArrayList<io.dcloud.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList != null) {
            valueAnimator.mUpdateListeners = new java.util.ArrayList<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                valueAnimator.mUpdateListeners.add(arrayList.get(i));
            }
        }
        valueAnimator.mSeekTime = -1L;
        valueAnimator.mPlayingBackwards = false;
        valueAnimator.mCurrentIteration = 0;
        valueAnimator.mInitialized = false;
        valueAnimator.mPlayingState = 0;
        valueAnimator.mStartedDelay = false;
        io.dcloud.nineoldandroids.animation.PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
        if (propertyValuesHolderArr != null) {
            int length = propertyValuesHolderArr.length;
            valueAnimator.mValues = new io.dcloud.nineoldandroids.animation.PropertyValuesHolder[length];
            valueAnimator.mValuesMap = new java.util.HashMap<>(length);
            for (int i2 = 0; i2 < length; i2++) {
                io.dcloud.nineoldandroids.animation.PropertyValuesHolder propertyValuesHolderM439clone = propertyValuesHolderArr[i2].m439clone();
                valueAnimator.mValues[i2] = propertyValuesHolderM439clone;
                valueAnimator.mValuesMap.put(propertyValuesHolderM439clone.getPropertyName(), propertyValuesHolderM439clone);
            }
        }
        return valueAnimator;
    }

    public static int getCurrentAnimationsCount() {
        return sAnimations.get().size();
    }

    public static void clearAllAnimations() {
        sAnimations.get().clear();
        sPendingAnimations.get().clear();
        sDelayedAnims.get().clear();
    }

    public java.lang.String toString() {
        java.lang.String str = "ValueAnimator@" + java.lang.Integer.toHexString(hashCode());
        if (this.mValues == null) {
            return str;
        }
        for (int i = 0; i < this.mValues.length; i++) {
            str = java.lang.String.valueOf(str) + "\n    " + this.mValues[i].toString();
        }
        return str;
    }
}
