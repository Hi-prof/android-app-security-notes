package com.facebook.fresco.animation.backend;

/* JADX INFO: loaded from: classes.dex */
public class AnimationBackendDelegateWithInactivityCheck<T extends com.facebook.fresco.animation.backend.AnimationBackend> extends com.facebook.fresco.animation.backend.AnimationBackendDelegate<T> {
    static final long INACTIVITY_CHECK_POLLING_TIME_MS = 1000;
    static final long INACTIVITY_THRESHOLD_MS = 2000;
    private long mInactivityCheckPollingTimeMs;
    private boolean mInactivityCheckScheduled;

    @javax.annotation.Nullable
    private com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.InactivityListener mInactivityListener;
    private long mInactivityThresholdMs;
    private final java.lang.Runnable mIsInactiveCheck;
    private long mLastDrawnTimeMs;
    private final com.facebook.common.time.MonotonicClock mMonotonicClock;
    private final java.util.concurrent.ScheduledExecutorService mScheduledExecutorServiceForUiThread;

    public interface InactivityListener {
        void onInactive();
    }

    public static <T extends com.facebook.fresco.animation.backend.AnimationBackend & com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.InactivityListener> com.facebook.fresco.animation.backend.AnimationBackendDelegate<T> createForBackend(T t, com.facebook.common.time.MonotonicClock monotonicClock, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        return createForBackend(t, (com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.InactivityListener) t, monotonicClock, scheduledExecutorService);
    }

    public static <T extends com.facebook.fresco.animation.backend.AnimationBackend> com.facebook.fresco.animation.backend.AnimationBackendDelegate<T> createForBackend(T t, com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.InactivityListener inactivityListener, com.facebook.common.time.MonotonicClock monotonicClock, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        return new com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck(t, inactivityListener, monotonicClock, scheduledExecutorService);
    }

    private AnimationBackendDelegateWithInactivityCheck(@javax.annotation.Nullable T t, @javax.annotation.Nullable com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.InactivityListener inactivityListener, com.facebook.common.time.MonotonicClock monotonicClock, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        super(t);
        this.mInactivityCheckScheduled = false;
        this.mInactivityThresholdMs = INACTIVITY_THRESHOLD_MS;
        this.mInactivityCheckPollingTimeMs = 1000L;
        this.mIsInactiveCheck = new java.lang.Runnable() { // from class: com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.this) {
                    com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.this.mInactivityCheckScheduled = false;
                    if (com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.this.isInactive()) {
                        if (com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.this.mInactivityListener != null) {
                            com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.this.mInactivityListener.onInactive();
                        }
                    } else {
                        com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.this.maybeScheduleInactivityCheck();
                    }
                }
            }
        };
        this.mInactivityListener = inactivityListener;
        this.mMonotonicClock = monotonicClock;
        this.mScheduledExecutorServiceForUiThread = scheduledExecutorService;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegate, com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(android.graphics.drawable.Drawable drawable, android.graphics.Canvas canvas, int i) {
        this.mLastDrawnTimeMs = this.mMonotonicClock.now();
        boolean zDrawFrame = super.drawFrame(drawable, canvas, i);
        maybeScheduleInactivityCheck();
        return zDrawFrame;
    }

    public void setInactivityListener(@javax.annotation.Nullable com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.InactivityListener inactivityListener) {
        this.mInactivityListener = inactivityListener;
    }

    public long getInactivityCheckPollingTimeMs() {
        return this.mInactivityCheckPollingTimeMs;
    }

    public void setInactivityCheckPollingTimeMs(long j) {
        this.mInactivityCheckPollingTimeMs = j;
    }

    public long getInactivityThresholdMs() {
        return this.mInactivityThresholdMs;
    }

    public void setInactivityThresholdMs(long j) {
        this.mInactivityThresholdMs = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInactive() {
        return this.mMonotonicClock.now() - this.mLastDrawnTimeMs > this.mInactivityThresholdMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void maybeScheduleInactivityCheck() {
        if (!this.mInactivityCheckScheduled) {
            this.mInactivityCheckScheduled = true;
            this.mScheduledExecutorServiceForUiThread.schedule(this.mIsInactiveCheck, this.mInactivityCheckPollingTimeMs, java.util.concurrent.TimeUnit.MILLISECONDS);
        }
    }
}
