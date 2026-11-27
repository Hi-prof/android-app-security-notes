package com.facebook.common.executors;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSerialExecutorService extends com.facebook.common.executors.ConstrainedExecutorService implements com.facebook.common.executors.SerialExecutorService, java.lang.AutoCloseable {
    @Override // com.facebook.common.executors.ConstrainedExecutorService, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        kotlin.UByte$$ExternalSyntheticBackport0.m((java.util.concurrent.ExecutorService) this);
    }

    public DefaultSerialExecutorService(java.util.concurrent.Executor executor) {
        super("SerialExecutor", 1, executor, new java.util.concurrent.LinkedBlockingQueue());
    }

    @Override // com.facebook.common.executors.ConstrainedExecutorService, java.util.concurrent.Executor
    public synchronized void execute(java.lang.Runnable runnable) {
        super.execute(runnable);
    }
}
