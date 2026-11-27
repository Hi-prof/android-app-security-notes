package bolts;

/* JADX INFO: loaded from: classes.dex */
public class CancellationToken {
    private final bolts.CancellationTokenSource tokenSource;

    CancellationToken(bolts.CancellationTokenSource cancellationTokenSource) {
        this.tokenSource = cancellationTokenSource;
    }

    public boolean isCancellationRequested() {
        return this.tokenSource.isCancellationRequested();
    }

    public bolts.CancellationTokenRegistration register(java.lang.Runnable runnable) {
        return this.tokenSource.register(runnable);
    }

    public void throwIfCancellationRequested() throws java.util.concurrent.CancellationException {
        this.tokenSource.throwIfCancellationRequested();
    }

    public java.lang.String toString() {
        return java.lang.String.format(java.util.Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), java.lang.Integer.toHexString(hashCode()), java.lang.Boolean.toString(this.tokenSource.isCancellationRequested()));
    }
}
