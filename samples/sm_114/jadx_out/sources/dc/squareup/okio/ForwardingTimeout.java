package dc.squareup.okio;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class ForwardingTimeout extends dc.squareup.okio.Timeout {
    private dc.squareup.okio.Timeout delegate;

    public ForwardingTimeout(dc.squareup.okio.Timeout timeout) {
        if (timeout == null) {
            throw new java.lang.IllegalArgumentException("delegate == null");
        }
        this.delegate = timeout;
    }

    @Override // dc.squareup.okio.Timeout
    public dc.squareup.okio.Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @Override // dc.squareup.okio.Timeout
    public dc.squareup.okio.Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    @Override // dc.squareup.okio.Timeout
    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    public final dc.squareup.okio.Timeout delegate() {
        return this.delegate;
    }

    @Override // dc.squareup.okio.Timeout
    public boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }

    public final dc.squareup.okio.ForwardingTimeout setDelegate(dc.squareup.okio.Timeout timeout) {
        if (timeout == null) {
            throw new java.lang.IllegalArgumentException("delegate == null");
        }
        this.delegate = timeout;
        return this;
    }

    @Override // dc.squareup.okio.Timeout
    public void throwIfReached() throws java.io.IOException {
        this.delegate.throwIfReached();
    }

    @Override // dc.squareup.okio.Timeout
    public dc.squareup.okio.Timeout timeout(long j, java.util.concurrent.TimeUnit timeUnit) {
        return this.delegate.timeout(j, timeUnit);
    }

    @Override // dc.squareup.okio.Timeout
    public long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }

    @Override // dc.squareup.okio.Timeout
    public dc.squareup.okio.Timeout deadlineNanoTime(long j) {
        return this.delegate.deadlineNanoTime(j);
    }
}
