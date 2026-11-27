package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class Timeout {
    public static final dc.squareup.okio.Timeout NONE = new dc.squareup.okio.Timeout() { // from class: dc.squareup.okio.Timeout.1
        @Override // dc.squareup.okio.Timeout
        public dc.squareup.okio.Timeout deadlineNanoTime(long j) {
            return this;
        }

        @Override // dc.squareup.okio.Timeout
        public void throwIfReached() throws java.io.IOException {
        }

        @Override // dc.squareup.okio.Timeout
        public dc.squareup.okio.Timeout timeout(long j, java.util.concurrent.TimeUnit timeUnit) {
            return this;
        }
    };
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    static long minTimeout(long j, long j2) {
        return (j != 0 && (j2 == 0 || j < j2)) ? j : j2;
    }

    public dc.squareup.okio.Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public dc.squareup.okio.Timeout clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final dc.squareup.okio.Timeout deadline(long j, java.util.concurrent.TimeUnit timeUnit) {
        if (j > 0) {
            if (timeUnit != null) {
                return deadlineNanoTime(java.lang.System.nanoTime() + timeUnit.toNanos(j));
            }
            throw new java.lang.IllegalArgumentException("unit == null");
        }
        throw new java.lang.IllegalArgumentException("duration <= 0: " + j);
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new java.lang.IllegalStateException("No deadline");
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public void throwIfReached() throws java.io.IOException {
        if (java.lang.Thread.interrupted()) {
            java.lang.Thread.currentThread().interrupt();
            throw new java.io.InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - java.lang.System.nanoTime() <= 0) {
            throw new java.io.InterruptedIOException("deadline reached");
        }
    }

    public dc.squareup.okio.Timeout timeout(long j, java.util.concurrent.TimeUnit timeUnit) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("timeout < 0: " + j);
        }
        if (timeUnit == null) {
            throw new java.lang.IllegalArgumentException("unit == null");
        }
        this.timeoutNanos = timeUnit.toNanos(j);
        return this;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(java.lang.Object obj) throws java.io.InterruptedIOException {
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            long jNanoTime = 0;
            if (!zHasDeadline && jTimeoutNanos == 0) {
                obj.wait();
                return;
            }
            long jNanoTime2 = java.lang.System.nanoTime();
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = java.lang.Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime2);
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - jNanoTime2;
            }
            if (jTimeoutNanos > 0) {
                long j = jTimeoutNanos / 1000000;
                java.lang.Long.signum(j);
                obj.wait(j, (int) (jTimeoutNanos - (1000000 * j)));
                jNanoTime = java.lang.System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jTimeoutNanos) {
                throw new java.io.InterruptedIOException("timeout");
            }
        } catch (java.lang.InterruptedException unused) {
            java.lang.Thread.currentThread().interrupt();
            throw new java.io.InterruptedIOException("interrupted");
        }
    }

    public dc.squareup.okio.Timeout deadlineNanoTime(long j) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j;
        return this;
    }
}
