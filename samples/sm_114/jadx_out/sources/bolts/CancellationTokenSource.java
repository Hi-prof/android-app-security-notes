package bolts;

/* JADX INFO: loaded from: classes.dex */
public class CancellationTokenSource implements java.io.Closeable {
    private boolean cancellationRequested;
    private boolean closed;
    private java.util.concurrent.ScheduledFuture<?> scheduledCancellation;
    private final java.lang.Object lock = new java.lang.Object();
    private final java.util.List<bolts.CancellationTokenRegistration> registrations = new java.util.ArrayList();
    private final java.util.concurrent.ScheduledExecutorService executor = bolts.BoltsExecutors.scheduled();

    public boolean isCancellationRequested() {
        boolean z;
        synchronized (this.lock) {
            throwIfClosed();
            z = this.cancellationRequested;
        }
        return z;
    }

    public bolts.CancellationToken getToken() {
        bolts.CancellationToken cancellationToken;
        synchronized (this.lock) {
            throwIfClosed();
            cancellationToken = new bolts.CancellationToken(this);
        }
        return cancellationToken;
    }

    public void cancel() {
        synchronized (this.lock) {
            throwIfClosed();
            if (this.cancellationRequested) {
                return;
            }
            cancelScheduledCancellation();
            this.cancellationRequested = true;
            notifyListeners(new java.util.ArrayList(this.registrations));
        }
    }

    public void cancelAfter(long j) {
        cancelAfter(j, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    private void cancelAfter(long j, java.util.concurrent.TimeUnit timeUnit) {
        if (j < -1) {
            throw new java.lang.IllegalArgumentException("Delay must be >= -1");
        }
        if (j == 0) {
            cancel();
            return;
        }
        synchronized (this.lock) {
            if (this.cancellationRequested) {
                return;
            }
            cancelScheduledCancellation();
            if (j != -1) {
                this.scheduledCancellation = this.executor.schedule(new java.lang.Runnable() { // from class: bolts.CancellationTokenSource.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (bolts.CancellationTokenSource.this.lock) {
                            bolts.CancellationTokenSource.this.scheduledCancellation = null;
                        }
                        bolts.CancellationTokenSource.this.cancel();
                    }
                }, j, timeUnit);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            cancelScheduledCancellation();
            java.util.Iterator<bolts.CancellationTokenRegistration> it = this.registrations.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            this.registrations.clear();
            this.closed = true;
        }
    }

    bolts.CancellationTokenRegistration register(java.lang.Runnable runnable) {
        bolts.CancellationTokenRegistration cancellationTokenRegistration;
        synchronized (this.lock) {
            throwIfClosed();
            cancellationTokenRegistration = new bolts.CancellationTokenRegistration(this, runnable);
            if (this.cancellationRequested) {
                cancellationTokenRegistration.runAction();
            } else {
                this.registrations.add(cancellationTokenRegistration);
            }
        }
        return cancellationTokenRegistration;
    }

    void throwIfCancellationRequested() throws java.util.concurrent.CancellationException {
        synchronized (this.lock) {
            throwIfClosed();
            if (this.cancellationRequested) {
                throw new java.util.concurrent.CancellationException();
            }
        }
    }

    void unregister(bolts.CancellationTokenRegistration cancellationTokenRegistration) {
        synchronized (this.lock) {
            throwIfClosed();
            this.registrations.remove(cancellationTokenRegistration);
        }
    }

    private void notifyListeners(java.util.List<bolts.CancellationTokenRegistration> list) {
        java.util.Iterator<bolts.CancellationTokenRegistration> it = list.iterator();
        while (it.hasNext()) {
            it.next().runAction();
        }
    }

    public java.lang.String toString() {
        return java.lang.String.format(java.util.Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), java.lang.Integer.toHexString(hashCode()), java.lang.Boolean.toString(isCancellationRequested()));
    }

    private void throwIfClosed() {
        if (this.closed) {
            throw new java.lang.IllegalStateException("Object already closed");
        }
    }

    private void cancelScheduledCancellation() {
        java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.scheduledCancellation;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.scheduledCancellation = null;
        }
    }
}
