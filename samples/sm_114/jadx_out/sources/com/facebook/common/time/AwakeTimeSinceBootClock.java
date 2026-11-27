package com.facebook.common.time;

/* JADX INFO: loaded from: classes.dex */
public class AwakeTimeSinceBootClock implements com.facebook.common.time.MonotonicNanoClock {
    private static final com.facebook.common.time.AwakeTimeSinceBootClock INSTANCE = new com.facebook.common.time.AwakeTimeSinceBootClock();

    @Override // com.facebook.common.time.MonotonicClock
    public /* synthetic */ long now() {
        return java.util.concurrent.TimeUnit.NANOSECONDS.toMillis(nowNanos());
    }

    private AwakeTimeSinceBootClock() {
    }

    public static com.facebook.common.time.AwakeTimeSinceBootClock get() {
        return INSTANCE;
    }

    @Override // com.facebook.common.time.MonotonicClock
    public long nowNanos() {
        return java.lang.System.nanoTime();
    }
}
