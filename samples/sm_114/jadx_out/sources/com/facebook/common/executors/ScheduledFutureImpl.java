package com.facebook.common.executors;

/* JADX INFO: loaded from: classes.dex */
public class ScheduledFutureImpl<V> implements java.util.concurrent.RunnableFuture<V>, java.util.concurrent.ScheduledFuture<V> {
    private final android.os.Handler mHandler;
    private final java.util.concurrent.FutureTask<V> mListenableFuture;

    public ScheduledFutureImpl(android.os.Handler handler, java.util.concurrent.Callable<V> callable) {
        this.mHandler = handler;
        this.mListenableFuture = new java.util.concurrent.FutureTask<>(callable);
    }

    public ScheduledFutureImpl(android.os.Handler handler, java.lang.Runnable runnable, @javax.annotation.Nullable V v) {
        this.mHandler = handler;
        this.mListenableFuture = new java.util.concurrent.FutureTask<>(runnable, v);
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(java.util.concurrent.TimeUnit timeUnit) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.lang.Comparable
    public int compareTo(java.util.concurrent.Delayed delayed) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        this.mListenableFuture.run();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.mListenableFuture.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.mListenableFuture.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mListenableFuture.isDone();
    }

    @Override // java.util.concurrent.Future
    public V get() throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        return this.mListenableFuture.get();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, java.util.concurrent.TimeUnit timeUnit) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        return this.mListenableFuture.get(j, timeUnit);
    }
}
