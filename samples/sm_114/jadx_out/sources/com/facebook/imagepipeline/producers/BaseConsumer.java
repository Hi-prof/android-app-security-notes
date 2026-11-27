package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseConsumer<T> implements com.facebook.imagepipeline.producers.Consumer<T> {
    private boolean mIsFinished = false;

    public static boolean isLast(int i) {
        return (i & 1) == 1;
    }

    public static int simpleStatusForIsLast(boolean z) {
        return z ? 1 : 0;
    }

    public static boolean statusHasAnyFlag(int i, int i2) {
        return (i & i2) != 0;
    }

    public static boolean statusHasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    public static int turnOffStatusFlag(int i, int i2) {
        return i & (~i2);
    }

    public static int turnOnStatusFlag(int i, int i2) {
        return i | i2;
    }

    protected abstract void onCancellationImpl();

    protected abstract void onFailureImpl(java.lang.Throwable th);

    protected abstract void onNewResultImpl(@javax.annotation.Nullable T t, int i);

    protected void onProgressUpdateImpl(float f) {
    }

    public static boolean isNotLast(int i) {
        return !isLast(i);
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onNewResult(@javax.annotation.Nullable T t, int i) {
        if (this.mIsFinished) {
            return;
        }
        this.mIsFinished = isLast(i);
        try {
            onNewResultImpl(t, i);
        } catch (java.lang.Exception e) {
            onUnhandledException(e);
        }
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onFailure(java.lang.Throwable th) {
        if (this.mIsFinished) {
            return;
        }
        this.mIsFinished = true;
        try {
            onFailureImpl(th);
        } catch (java.lang.Exception e) {
            onUnhandledException(e);
        }
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onCancellation() {
        if (this.mIsFinished) {
            return;
        }
        this.mIsFinished = true;
        try {
            onCancellationImpl();
        } catch (java.lang.Exception e) {
            onUnhandledException(e);
        }
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onProgressUpdate(float f) {
        if (this.mIsFinished) {
            return;
        }
        try {
            onProgressUpdateImpl(f);
        } catch (java.lang.Exception e) {
            onUnhandledException(e);
        }
    }

    protected void onUnhandledException(java.lang.Exception exc) {
        com.facebook.common.logging.FLog.wtf(getClass(), "unhandled exception", exc);
    }
}
