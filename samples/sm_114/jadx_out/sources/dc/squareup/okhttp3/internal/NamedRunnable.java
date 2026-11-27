package dc.squareup.okhttp3.internal;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class NamedRunnable implements java.lang.Runnable {
    protected final java.lang.String name;

    public NamedRunnable(java.lang.String str, java.lang.Object... objArr) {
        this.name = dc.squareup.okhttp3.internal.Util.format(str, objArr);
    }

    protected abstract void execute();

    @Override // java.lang.Runnable
    public final void run() {
        java.lang.String name = java.lang.Thread.currentThread().getName();
        java.lang.Thread.currentThread().setName(this.name);
        try {
            execute();
        } finally {
            java.lang.Thread.currentThread().setName(name);
        }
    }
}
