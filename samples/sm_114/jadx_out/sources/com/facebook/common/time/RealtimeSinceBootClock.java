package com.facebook.common.time;

/* JADX INFO: loaded from: classes.dex */
public class RealtimeSinceBootClock implements com.facebook.common.time.MonotonicClock {
    private static final com.facebook.common.time.RealtimeSinceBootClock INSTANCE = new com.facebook.common.time.RealtimeSinceBootClock();

    private RealtimeSinceBootClock() {
    }

    public static com.facebook.common.time.RealtimeSinceBootClock get() {
        return INSTANCE;
    }

    @Override // com.facebook.common.time.MonotonicClock
    public long now() {
        return android.os.SystemClock.elapsedRealtime();
    }

    @Override // com.facebook.common.time.MonotonicClock
    public long nowNanos() {
        return java.util.concurrent.TimeUnit.MILLISECONDS.toNanos(now());
    }
}
