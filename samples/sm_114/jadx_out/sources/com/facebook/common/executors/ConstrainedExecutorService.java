package com.facebook.common.executors;

/* JADX INFO: loaded from: classes.dex */
public class ConstrainedExecutorService extends java.util.concurrent.AbstractExecutorService implements java.lang.AutoCloseable {
    private static final java.lang.Class<?> TAG = com.facebook.common.executors.ConstrainedExecutorService.class;
    private final java.util.concurrent.Executor mExecutor;
    private volatile int mMaxConcurrency;
    private final java.util.concurrent.atomic.AtomicInteger mMaxQueueSize;
    private final java.lang.String mName;
    private final java.util.concurrent.atomic.AtomicInteger mPendingWorkers;
    private final com.facebook.common.executors.ConstrainedExecutorService.Worker mTaskRunner;
    private final java.util.concurrent.BlockingQueue<java.lang.Runnable> mWorkQueue;

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

    public ConstrainedExecutorService(java.lang.String str, int i, java.util.concurrent.Executor executor, java.util.concurrent.BlockingQueue<java.lang.Runnable> blockingQueue) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.mMaxConcurrency = i;
        this.mWorkQueue = blockingQueue;
        this.mTaskRunner = new com.facebook.common.executors.ConstrainedExecutorService.Worker();
        this.mPendingWorkers = new java.util.concurrent.atomic.AtomicInteger(0);
        this.mMaxQueueSize = new java.util.concurrent.atomic.AtomicInteger(0);
    }

    public static com.facebook.common.executors.ConstrainedExecutorService newConstrainedExecutor(java.lang.String str, int i, int i2, java.util.concurrent.Executor executor) {
        return new com.facebook.common.executors.ConstrainedExecutorService(str, i, executor, new java.util.concurrent.LinkedBlockingQueue(i2));
    }

    public boolean isIdle() {
        return this.mWorkQueue.isEmpty() && this.mPendingWorkers.get() == 0;
    }

    @Override // java.util.concurrent.Executor
    public void execute(java.lang.Runnable runnable) {
        if (runnable == null) {
            throw new java.lang.NullPointerException("runnable parameter is null");
        }
        if (!this.mWorkQueue.offer(runnable)) {
            throw new java.util.concurrent.RejectedExecutionException(this.mName + " queue is full, size=" + this.mWorkQueue.size());
        }
        int size = this.mWorkQueue.size();
        int i = this.mMaxQueueSize.get();
        if (size > i && this.mMaxQueueSize.compareAndSet(i, size)) {
            com.facebook.common.logging.FLog.v(TAG, "%s: max pending work in queue = %d", this.mName, java.lang.Integer.valueOf(size));
        }
        startWorkerIfNeeded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startWorkerIfNeeded() {
        int i = this.mPendingWorkers.get();
        while (i < this.mMaxConcurrency) {
            int i2 = i + 1;
            if (this.mPendingWorkers.compareAndSet(i, i2)) {
                com.facebook.common.logging.FLog.v(TAG, "%s: starting worker %d of %d", this.mName, java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(this.mMaxConcurrency));
                this.mExecutor.execute(this.mTaskRunner);
                return;
            } else {
                com.facebook.common.logging.FLog.v(TAG, "%s: race in startWorkerIfNeeded; retrying", this.mName);
                i = this.mPendingWorkers.get();
            }
        }
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

    private class Worker implements java.lang.Runnable {
        private Worker() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.lang.Runnable runnable = (java.lang.Runnable) com.facebook.common.executors.ConstrainedExecutorService.this.mWorkQueue.poll();
                if (runnable != null) {
                    runnable.run();
                } else {
                    com.facebook.common.logging.FLog.v((java.lang.Class<?>) com.facebook.common.executors.ConstrainedExecutorService.TAG, "%s: Worker has nothing to run", com.facebook.common.executors.ConstrainedExecutorService.this.mName);
                }
            } finally {
                int iDecrementAndGet = com.facebook.common.executors.ConstrainedExecutorService.this.mPendingWorkers.decrementAndGet();
                if (com.facebook.common.executors.ConstrainedExecutorService.this.mWorkQueue.isEmpty()) {
                    com.facebook.common.logging.FLog.v((java.lang.Class<?>) com.facebook.common.executors.ConstrainedExecutorService.TAG, "%s: worker finished; %d workers left", com.facebook.common.executors.ConstrainedExecutorService.this.mName, java.lang.Integer.valueOf(iDecrementAndGet));
                } else {
                    com.facebook.common.executors.ConstrainedExecutorService.this.startWorkerIfNeeded();
                }
            }
        }
    }
}
