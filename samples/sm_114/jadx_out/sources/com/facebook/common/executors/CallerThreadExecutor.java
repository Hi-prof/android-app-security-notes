package com.facebook.common.executors;

/* JADX INFO: loaded from: classes.dex */
public class CallerThreadExecutor extends java.util.concurrent.AbstractExecutorService implements java.lang.AutoCloseable {
    private static final com.facebook.common.executors.CallerThreadExecutor sInstance = new com.facebook.common.executors.CallerThreadExecutor();

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        return true;
    }

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

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
    }

    public static com.facebook.common.executors.CallerThreadExecutor getInstance() {
        return sInstance;
    }

    private CallerThreadExecutor() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(java.lang.Runnable runnable) {
        runnable.run();
    }

    @Override // java.util.concurrent.ExecutorService
    public java.util.List<java.lang.Runnable> shutdownNow() {
        shutdown();
        return java.util.Collections.EMPTY_LIST;
    }
}
