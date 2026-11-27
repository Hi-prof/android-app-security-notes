package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
class ConditionVariable {
    private volatile boolean mCondition;

    ConditionVariable() {
    }

    synchronized void set(boolean z) {
        try {
            if (z) {
                open();
            } else {
                close();
            }
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    synchronized void open() {
        boolean z = this.mCondition;
        this.mCondition = true;
        if (!z) {
            notify();
        }
    }

    synchronized void close() {
        this.mCondition = false;
    }

    synchronized void block() throws java.lang.InterruptedException {
        while (!this.mCondition) {
            wait();
        }
    }
}
