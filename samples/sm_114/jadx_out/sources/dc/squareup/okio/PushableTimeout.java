package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class PushableTimeout extends dc.squareup.okio.Timeout {
    private long originalDeadlineNanoTime;
    private boolean originalHasDeadline;
    private long originalTimeoutNanos;
    private dc.squareup.okio.Timeout pushed;

    PushableTimeout() {
    }

    void pop() {
        this.pushed.timeout(this.originalTimeoutNanos, java.util.concurrent.TimeUnit.NANOSECONDS);
        if (this.originalHasDeadline) {
            this.pushed.deadlineNanoTime(this.originalDeadlineNanoTime);
        } else {
            this.pushed.clearDeadline();
        }
    }

    void push(dc.squareup.okio.Timeout timeout) {
        this.pushed = timeout;
        boolean zHasDeadline = timeout.hasDeadline();
        this.originalHasDeadline = zHasDeadline;
        this.originalDeadlineNanoTime = zHasDeadline ? timeout.deadlineNanoTime() : -1L;
        long jTimeoutNanos = timeout.timeoutNanos();
        this.originalTimeoutNanos = jTimeoutNanos;
        timeout.timeout(dc.squareup.okio.Timeout.minTimeout(jTimeoutNanos, timeoutNanos()), java.util.concurrent.TimeUnit.NANOSECONDS);
        if (this.originalHasDeadline && hasDeadline()) {
            timeout.deadlineNanoTime(java.lang.Math.min(deadlineNanoTime(), this.originalDeadlineNanoTime));
        } else if (hasDeadline()) {
            timeout.deadlineNanoTime(deadlineNanoTime());
        }
    }
}
