package bolts;

/* JADX INFO: loaded from: classes.dex */
public class CancellationTokenRegistration implements java.io.Closeable {
    private java.lang.Runnable action;
    private boolean closed;
    private final java.lang.Object lock = new java.lang.Object();
    private bolts.CancellationTokenSource tokenSource;

    CancellationTokenRegistration(bolts.CancellationTokenSource cancellationTokenSource, java.lang.Runnable runnable) {
        this.tokenSource = cancellationTokenSource;
        this.action = runnable;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.tokenSource.unregister(this);
            this.tokenSource = null;
            this.action = null;
        }
    }

    void runAction() {
        synchronized (this.lock) {
            throwIfClosed();
            this.action.run();
            close();
        }
    }

    private void throwIfClosed() {
        if (this.closed) {
            throw new java.lang.IllegalStateException("Object already closed");
        }
    }
}
