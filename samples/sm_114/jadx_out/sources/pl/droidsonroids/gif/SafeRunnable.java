package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
abstract class SafeRunnable implements java.lang.Runnable {
    final pl.droidsonroids.gif.GifDrawable mGifDrawable;

    abstract void doWork();

    SafeRunnable(pl.droidsonroids.gif.GifDrawable gifDrawable) {
        this.mGifDrawable = gifDrawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.mGifDrawable.isRecycled()) {
                return;
            }
            doWork();
        } catch (java.lang.Throwable th) {
            java.lang.Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = java.lang.Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(java.lang.Thread.currentThread(), th);
            }
            throw th;
        }
    }
}
