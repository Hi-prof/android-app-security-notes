package com.facebook.fresco.animation.drawable;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedDrawable2 extends android.graphics.drawable.Drawable implements android.graphics.drawable.Animatable, com.facebook.drawable.base.DrawableWithCaches {
    private static final int DEFAULT_FRAME_SCHEDULING_DELAY_MS = 8;
    private static final int DEFAULT_FRAME_SCHEDULING_OFFSET_MS = 0;
    private final com.facebook.fresco.animation.backend.AnimationBackend.Listener animationBackendListener;

    @javax.annotation.Nullable
    private com.facebook.fresco.animation.backend.AnimationBackend mAnimationBackend;
    private volatile com.facebook.fresco.animation.drawable.AnimationListener mAnimationListener;

    @javax.annotation.Nullable
    private volatile com.facebook.fresco.animation.drawable.AnimatedDrawable2.DrawListener mDrawListener;

    @javax.annotation.Nullable
    private com.facebook.drawee.drawable.DrawableProperties mDrawableProperties;
    private int mDroppedFrames;
    private long mExpectedRenderTimeMs;

    @javax.annotation.Nullable
    private com.facebook.fresco.animation.frame.FrameScheduler mFrameScheduler;
    private long mFrameSchedulingDelayMs;
    private long mFrameSchedulingOffsetMs;
    private final java.lang.Runnable mInvalidateRunnable;
    private volatile boolean mIsRunning;
    private int mLastDrawnFrameNumber;
    private long mLastFrameAnimationTimeMs;
    private int mPausedLastDrawnFrameNumber;
    private long mPausedLastFrameAnimationTimeMsDifference;
    private long mPausedStartTimeMsDifference;
    private long mStartTimeMs;
    private static final java.lang.Class<?> TAG = com.facebook.fresco.animation.drawable.AnimatedDrawable2.class;
    private static final com.facebook.fresco.animation.drawable.AnimationListener NO_OP_LISTENER = new com.facebook.fresco.animation.drawable.BaseAnimationListener();

    public interface DrawListener {
        void onDraw(com.facebook.fresco.animation.drawable.AnimatedDrawable2 animatedDrawable2, com.facebook.fresco.animation.frame.FrameScheduler frameScheduler, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: renamed from: lambda$new$0$com-facebook-fresco-animation-drawable-AnimatedDrawable2, reason: not valid java name */
    /* synthetic */ void m282xd493c28c() {
        this.mAnimationListener.onAnimationLoaded();
    }

    public AnimatedDrawable2() {
        this(null);
    }

    public AnimatedDrawable2(@javax.annotation.Nullable com.facebook.fresco.animation.backend.AnimationBackend animationBackend) {
        this.mFrameSchedulingDelayMs = 8L;
        this.mFrameSchedulingOffsetMs = 0L;
        this.mAnimationListener = NO_OP_LISTENER;
        this.mDrawListener = null;
        com.facebook.fresco.animation.backend.AnimationBackend.Listener listener = new com.facebook.fresco.animation.backend.AnimationBackend.Listener() { // from class: com.facebook.fresco.animation.drawable.AnimatedDrawable2$$ExternalSyntheticLambda0
            @Override // com.facebook.fresco.animation.backend.AnimationBackend.Listener
            public final void onAnimationLoaded() {
                this.f$0.m282xd493c28c();
            }
        };
        this.animationBackendListener = listener;
        this.mInvalidateRunnable = new java.lang.Runnable() { // from class: com.facebook.fresco.animation.drawable.AnimatedDrawable2.1
            @Override // java.lang.Runnable
            public void run() {
                com.facebook.fresco.animation.drawable.AnimatedDrawable2 animatedDrawable2 = com.facebook.fresco.animation.drawable.AnimatedDrawable2.this;
                animatedDrawable2.unscheduleSelf(animatedDrawable2.mInvalidateRunnable);
                com.facebook.fresco.animation.drawable.AnimatedDrawable2.this.invalidateSelf();
            }
        };
        this.mAnimationBackend = animationBackend;
        this.mFrameScheduler = createSchedulerForBackendAndDelayMethod(animationBackend);
        if (animationBackend != null) {
            animationBackend.setAnimationListener(listener);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        com.facebook.fresco.animation.backend.AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend == null) {
            return super.getIntrinsicWidth();
        }
        return animationBackend.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        com.facebook.fresco.animation.backend.AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend == null) {
            return super.getIntrinsicHeight();
        }
        return animationBackend.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        com.facebook.fresco.animation.backend.AnimationBackend animationBackend;
        if (this.mIsRunning || (animationBackend = this.mAnimationBackend) == null || animationBackend.getFrameCount() <= 1) {
            return;
        }
        this.mIsRunning = true;
        long jNow = now();
        long j = jNow - this.mPausedStartTimeMsDifference;
        this.mStartTimeMs = j;
        this.mExpectedRenderTimeMs = j;
        this.mLastFrameAnimationTimeMs = jNow - this.mPausedLastFrameAnimationTimeMsDifference;
        this.mLastDrawnFrameNumber = this.mPausedLastDrawnFrameNumber;
        invalidateSelf();
        this.mAnimationListener.onAnimationStart(this);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.mIsRunning) {
            long jNow = now();
            this.mPausedStartTimeMsDifference = jNow - this.mStartTimeMs;
            this.mPausedLastFrameAnimationTimeMsDifference = jNow - this.mLastFrameAnimationTimeMs;
            this.mPausedLastDrawnFrameNumber = this.mLastDrawnFrameNumber;
            this.mIsRunning = false;
            this.mStartTimeMs = 0L;
            this.mExpectedRenderTimeMs = 0L;
            this.mLastFrameAnimationTimeMs = -1L;
            this.mLastDrawnFrameNumber = -1;
            unscheduleSelf(this.mInvalidateRunnable);
            this.mAnimationListener.onAnimationStop(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        super.onBoundsChange(rect);
        com.facebook.fresco.animation.backend.AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        long jMax;
        long j;
        long j2;
        if (this.mAnimationBackend == null || this.mFrameScheduler == null) {
            return;
        }
        long jNow = now();
        if (this.mIsRunning) {
            jMax = (jNow - this.mStartTimeMs) + this.mFrameSchedulingOffsetMs;
        } else {
            jMax = java.lang.Math.max(this.mLastFrameAnimationTimeMs, 0L);
        }
        long j3 = jMax;
        int frameNumberToRender = this.mFrameScheduler.getFrameNumberToRender(j3, this.mLastFrameAnimationTimeMs);
        if (frameNumberToRender == -1) {
            frameNumberToRender = this.mAnimationBackend.getFrameCount() - 1;
            this.mAnimationListener.onAnimationStop(this);
            this.mIsRunning = false;
        } else if (frameNumberToRender == 0 && this.mLastDrawnFrameNumber != -1 && jNow >= this.mExpectedRenderTimeMs) {
            this.mAnimationListener.onAnimationRepeat(this);
        }
        int i = frameNumberToRender;
        boolean zDrawFrame = this.mAnimationBackend.drawFrame(this, canvas, i);
        if (zDrawFrame) {
            this.mAnimationListener.onAnimationFrame(this, i);
            this.mLastDrawnFrameNumber = i;
        }
        if (!zDrawFrame) {
            onFrameDropped();
        }
        long jNow2 = now();
        long j4 = -1;
        if (this.mIsRunning) {
            long targetRenderTimeForNextFrameMs = this.mFrameScheduler.getTargetRenderTimeForNextFrameMs(jNow2 - this.mStartTimeMs);
            if (targetRenderTimeForNextFrameMs != -1) {
                j4 = this.mFrameSchedulingDelayMs + targetRenderTimeForNextFrameMs;
                scheduleNextFrame(j4);
            } else {
                this.mAnimationListener.onAnimationStop(this);
                this.mIsRunning = false;
            }
            j2 = j4;
            j = targetRenderTimeForNextFrameMs;
        } else {
            j = -1;
            j2 = -1;
        }
        com.facebook.fresco.animation.drawable.AnimatedDrawable2.DrawListener drawListener = this.mDrawListener;
        if (drawListener != null) {
            drawListener.onDraw(this, this.mFrameScheduler, i, zDrawFrame, this.mIsRunning, this.mStartTimeMs, j3, this.mLastFrameAnimationTimeMs, jNow, jNow2, j, j2);
        }
        this.mLastFrameAnimationTimeMs = j3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new com.facebook.drawee.drawable.DrawableProperties();
        }
        this.mDrawableProperties.setAlpha(i);
        com.facebook.fresco.animation.backend.AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@javax.annotation.Nullable android.graphics.ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new com.facebook.drawee.drawable.DrawableProperties();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        com.facebook.fresco.animation.backend.AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.setColorFilter(colorFilter);
        }
    }

    public void preloadAnimation() {
        com.facebook.fresco.animation.backend.AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.preloadAnimation();
        }
    }

    public void setAnimationBackend(@javax.annotation.Nullable com.facebook.fresco.animation.backend.AnimationBackend animationBackend) {
        com.facebook.fresco.animation.backend.AnimationBackend animationBackend2 = this.mAnimationBackend;
        if (animationBackend2 != null) {
            animationBackend2.setAnimationListener(null);
        }
        this.mAnimationBackend = animationBackend;
        if (animationBackend != null) {
            this.mFrameScheduler = new com.facebook.fresco.animation.frame.DropFramesFrameScheduler(this.mAnimationBackend);
            this.mAnimationBackend.setAnimationListener(this.animationBackendListener);
            this.mAnimationBackend.setBounds(getBounds());
            com.facebook.drawee.drawable.DrawableProperties drawableProperties = this.mDrawableProperties;
            if (drawableProperties != null) {
                drawableProperties.applyTo(this);
            }
        }
        this.mFrameScheduler = createSchedulerForBackendAndDelayMethod(this.mAnimationBackend);
        stop();
    }

    @javax.annotation.Nullable
    public com.facebook.fresco.animation.backend.AnimationBackend getAnimationBackend() {
        return this.mAnimationBackend;
    }

    public long getDroppedFrames() {
        return this.mDroppedFrames;
    }

    public long getStartTimeMs() {
        return this.mStartTimeMs;
    }

    public boolean isInfiniteAnimation() {
        com.facebook.fresco.animation.frame.FrameScheduler frameScheduler = this.mFrameScheduler;
        return frameScheduler != null && frameScheduler.isInfiniteAnimation();
    }

    public void jumpToFrame(int i) {
        com.facebook.fresco.animation.frame.FrameScheduler frameScheduler;
        if (this.mAnimationBackend == null || (frameScheduler = this.mFrameScheduler) == null) {
            return;
        }
        this.mLastFrameAnimationTimeMs = frameScheduler.getTargetRenderTimeMs(i);
        this.mPausedLastDrawnFrameNumber = i;
        this.mPausedStartTimeMsDifference = 0L;
        this.mPausedLastFrameAnimationTimeMsDifference = 0L;
        long jNow = now() - this.mLastFrameAnimationTimeMs;
        this.mStartTimeMs = jNow;
        this.mExpectedRenderTimeMs = jNow;
        invalidateSelf();
    }

    public long getLoopDurationMs() {
        if (this.mAnimationBackend == null) {
            return 0L;
        }
        com.facebook.fresco.animation.frame.FrameScheduler frameScheduler = this.mFrameScheduler;
        if (frameScheduler != null) {
            return frameScheduler.getLoopDurationMs();
        }
        int frameDurationMs = 0;
        for (int i = 0; i < this.mAnimationBackend.getFrameCount(); i++) {
            frameDurationMs += this.mAnimationBackend.getFrameDurationMs(i);
        }
        return frameDurationMs;
    }

    public int getFrameCount() {
        com.facebook.fresco.animation.backend.AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend == null) {
            return 0;
        }
        return animationBackend.getFrameCount();
    }

    public int getFrameDurationMs(int i) {
        com.facebook.fresco.animation.backend.AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend == null) {
            return 0;
        }
        return animationBackend.getFrameDurationMs(i);
    }

    public int getLoopCount() {
        com.facebook.fresco.animation.backend.AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend == null) {
            return 0;
        }
        return animationBackend.getLoopCount();
    }

    public void setFrameSchedulingDelayMs(long j) {
        this.mFrameSchedulingDelayMs = j;
    }

    public void setFrameSchedulingOffsetMs(long j) {
        this.mFrameSchedulingOffsetMs = j;
    }

    public void setAnimationListener(@javax.annotation.Nullable com.facebook.fresco.animation.drawable.AnimationListener animationListener) {
        if (animationListener == null) {
            animationListener = NO_OP_LISTENER;
        }
        this.mAnimationListener = animationListener;
    }

    public void setDrawListener(@javax.annotation.Nullable com.facebook.fresco.animation.drawable.AnimatedDrawable2.DrawListener drawListener) {
        this.mDrawListener = drawListener;
    }

    private void scheduleNextFrame(long j) {
        long j2 = this.mStartTimeMs + j;
        this.mExpectedRenderTimeMs = j2;
        scheduleSelf(this.mInvalidateRunnable, j2);
    }

    private void onFrameDropped() {
        this.mDroppedFrames++;
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            com.facebook.common.logging.FLog.v(TAG, "Dropped a frame. Count: %s", java.lang.Integer.valueOf(this.mDroppedFrames));
        }
    }

    private long now() {
        return android.os.SystemClock.uptimeMillis();
    }

    @javax.annotation.Nullable
    private static com.facebook.fresco.animation.frame.FrameScheduler createSchedulerForBackendAndDelayMethod(@javax.annotation.Nullable com.facebook.fresco.animation.backend.AnimationBackend animationBackend) {
        if (animationBackend == null) {
            return null;
        }
        return new com.facebook.fresco.animation.frame.DropFramesFrameScheduler(animationBackend);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        if (this.mIsRunning) {
            return false;
        }
        long j = i;
        if (this.mLastFrameAnimationTimeMs == j) {
            return false;
        }
        this.mLastFrameAnimationTimeMs = j;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.drawable.base.DrawableWithCaches
    public void dropCaches() {
        com.facebook.fresco.animation.backend.AnimationBackend animationBackend = this.mAnimationBackend;
        if (animationBackend != null) {
            animationBackend.clear();
        }
    }
}
