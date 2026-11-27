package com.facebook.common.executors;

/* JADX INFO: loaded from: classes.dex */
public class HandlerExecutorServiceImpl extends java.util.concurrent.AbstractExecutorService implements com.facebook.common.executors.HandlerExecutorService, java.lang.AutoCloseable {
    private final android.os.Handler mHandler;

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        kotlin.UByte$$ExternalSyntheticBackport0.m((java.util.concurrent.ExecutorService) this);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    public HandlerExecutorServiceImpl(android.os.Handler handler) {
        this.mHandler = handler;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public java.util.List<java.lang.Runnable> shutdownNow() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Executor
    public void execute(java.lang.Runnable runnable) {
        this.mHandler.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.util.concurrent.AbstractExecutorService
    public <T> com.facebook.common.executors.ScheduledFutureImpl<T> newTaskFor(java.lang.Runnable runnable, @javax.annotation.Nullable T t) {
        return new com.facebook.common.executors.ScheduledFutureImpl<>(this.mHandler, runnable, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.util.concurrent.AbstractExecutorService
    public <T> com.facebook.common.executors.ScheduledFutureImpl<T> newTaskFor(java.util.concurrent.Callable<T> callable) {
        return new com.facebook.common.executors.ScheduledFutureImpl<>(this.mHandler, callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public java.util.concurrent.ScheduledFuture<?> submit(java.lang.Runnable runnable) {
        return submit(runnable, (java.lang.Object) null);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> java.util.concurrent.ScheduledFuture<T> submit(java.lang.Runnable runnable, @javax.annotation.Nullable T t) {
        runnable.getClass();
        com.facebook.common.executors.ScheduledFutureImpl<T> scheduledFutureImplNewTaskFor = newTaskFor(runnable, (java.lang.Object) t);
        execute(scheduledFutureImplNewTaskFor);
        return scheduledFutureImplNewTaskFor;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> java.util.concurrent.ScheduledFuture<T> submit(java.util.concurrent.Callable<T> callable) {
        callable.getClass();
        com.facebook.common.executors.ScheduledFutureImpl<T> scheduledFutureImplNewTaskFor = newTaskFor((java.util.concurrent.Callable) callable);
        execute(scheduledFutureImplNewTaskFor);
        return scheduledFutureImplNewTaskFor;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public java.util.concurrent.ScheduledFuture<?> schedule(java.lang.Runnable runnable, long j, java.util.concurrent.TimeUnit timeUnit) {
        com.facebook.common.executors.ScheduledFutureImpl scheduledFutureImplNewTaskFor = newTaskFor(runnable, (java.lang.Object) null);
        this.mHandler.postDelayed(scheduledFutureImplNewTaskFor, timeUnit.toMillis(j));
        return scheduledFutureImplNewTaskFor;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> java.util.concurrent.ScheduledFuture<V> schedule(java.util.concurrent.Callable<V> callable, long j, java.util.concurrent.TimeUnit timeUnit) {
        com.facebook.common.executors.ScheduledFutureImpl scheduledFutureImplNewTaskFor = newTaskFor((java.util.concurrent.Callable) callable);
        this.mHandler.postDelayed(scheduledFutureImplNewTaskFor, timeUnit.toMillis(j));
        return scheduledFutureImplNewTaskFor;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public java.util.concurrent.ScheduledFuture<?> scheduleAtFixedRate(java.lang.Runnable runnable, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public java.util.concurrent.ScheduledFuture<?> scheduleWithFixedDelay(java.lang.Runnable runnable, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.facebook.common.executors.HandlerExecutorService
    public void quit() {
        this.mHandler.getLooper().quit();
    }

    @Override // com.facebook.common.executors.HandlerExecutorService
    public boolean isHandlerThread() {
        return java.lang.Thread.currentThread() == this.mHandler.getLooper().getThread();
    }
}
