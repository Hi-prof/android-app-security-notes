package com.facebook.common.time;

/* JADX INFO: loaded from: classes.dex */
public interface MonotonicClock {
    long now();

    long nowNanos();

    /* JADX INFO: renamed from: com.facebook.common.time.MonotonicClock$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static com.facebook.common.time.MonotonicClock of(com.facebook.common.time.Clock clock) {
            return new com.facebook.common.time.MonotonicClock.MonotonicClockWrapper(clock);
        }
    }

    public static final class MonotonicClockWrapper implements com.facebook.common.time.MonotonicClock {
        private long mLast;
        private final com.facebook.common.time.Clock provider;

        private MonotonicClockWrapper(com.facebook.common.time.Clock clock) {
            this.provider = clock;
            this.mLast = clock.now();
        }

        @Override // com.facebook.common.time.MonotonicClock
        public long nowNanos() {
            return java.util.concurrent.TimeUnit.MILLISECONDS.toNanos(now());
        }

        @Override // com.facebook.common.time.MonotonicClock
        public long now() {
            long jMax = java.lang.Math.max(this.mLast, this.provider.now());
            this.mLast = jMax;
            return jMax;
        }
    }
}
