package com.facebook.datasource;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDataSource<T> implements com.facebook.datasource.DataSource<T> {

    @javax.annotation.Nullable
    private static volatile com.facebook.datasource.AbstractDataSource.DataSourceInstrumenter sDataSourceInstrumenter;

    @javax.annotation.Nullable
    private java.util.Map<java.lang.String, java.lang.Object> mExtras;

    @javax.annotation.Nullable
    private T mResult = null;

    @javax.annotation.Nullable
    private java.lang.Throwable mFailureThrowable = null;
    private float mProgress = 0.0f;
    private boolean mIsClosed = false;
    private com.facebook.datasource.AbstractDataSource.DataSourceStatus mDataSourceStatus = com.facebook.datasource.AbstractDataSource.DataSourceStatus.IN_PROGRESS;
    private final java.util.concurrent.ConcurrentLinkedQueue<android.util.Pair<com.facebook.datasource.DataSubscriber<T>, java.util.concurrent.Executor>> mSubscribers = new java.util.concurrent.ConcurrentLinkedQueue<>();

    public interface DataSourceInstrumenter {
        java.lang.Runnable decorateRunnable(java.lang.Runnable runnable, java.lang.String str);
    }

    private enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    protected void closeResult(@javax.annotation.Nullable T t) {
    }

    @Override // com.facebook.datasource.DataSource
    public boolean hasMultipleResults() {
        return false;
    }

    public static void provideInstrumenter(@javax.annotation.Nullable com.facebook.datasource.AbstractDataSource.DataSourceInstrumenter dataSourceInstrumenter) {
        sDataSourceInstrumenter = dataSourceInstrumenter;
    }

    protected AbstractDataSource() {
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean isClosed() {
        return this.mIsClosed;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean isFinished() {
        return this.mDataSourceStatus != com.facebook.datasource.AbstractDataSource.DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean hasResult() {
        return this.mResult != null;
    }

    @Override // com.facebook.datasource.DataSource
    @javax.annotation.Nullable
    public synchronized T getResult() {
        return this.mResult;
    }

    @Override // com.facebook.datasource.DataSource
    @javax.annotation.Nullable
    public java.util.Map<java.lang.String, java.lang.Object> getExtras() {
        return this.mExtras;
    }

    protected void setExtras(@javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.Object> map) {
        this.mExtras = map;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean hasFailed() {
        return this.mDataSourceStatus == com.facebook.datasource.AbstractDataSource.DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.DataSource
    @javax.annotation.Nullable
    public synchronized java.lang.Throwable getFailureCause() {
        return this.mFailureThrowable;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean close() {
        synchronized (this) {
            if (this.mIsClosed) {
                return false;
            }
            this.mIsClosed = true;
            T t = this.mResult;
            this.mResult = null;
            if (t != null) {
                closeResult(t);
            }
            if (!isFinished()) {
                notifyDataSubscribers();
            }
            synchronized (this) {
                this.mSubscribers.clear();
            }
            return true;
        }
    }

    @Override // com.facebook.datasource.DataSource
    public void subscribe(com.facebook.datasource.DataSubscriber<T> dataSubscriber, java.util.concurrent.Executor executor) {
        com.facebook.common.internal.Preconditions.checkNotNull(dataSubscriber);
        com.facebook.common.internal.Preconditions.checkNotNull(executor);
        synchronized (this) {
            if (this.mIsClosed) {
                return;
            }
            if (this.mDataSourceStatus == com.facebook.datasource.AbstractDataSource.DataSourceStatus.IN_PROGRESS) {
                this.mSubscribers.add(android.util.Pair.create(dataSubscriber, executor));
            }
            boolean z = hasResult() || isFinished() || wasCancelled();
            if (z) {
                notifyDataSubscriber(dataSubscriber, executor, hasFailed(), wasCancelled());
            }
        }
    }

    private void notifyDataSubscribers() {
        boolean zHasFailed = hasFailed();
        boolean zWasCancelled = wasCancelled();
        for (android.util.Pair<com.facebook.datasource.DataSubscriber<T>, java.util.concurrent.Executor> pair : this.mSubscribers) {
            notifyDataSubscriber((com.facebook.datasource.DataSubscriber) pair.first, (java.util.concurrent.Executor) pair.second, zHasFailed, zWasCancelled);
        }
    }

    protected void notifyDataSubscriber(final com.facebook.datasource.DataSubscriber<T> dataSubscriber, java.util.concurrent.Executor executor, final boolean z, final boolean z2) {
        java.lang.Runnable runnableDecorateRunnable = new java.lang.Runnable() { // from class: com.facebook.datasource.AbstractDataSource.1
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    dataSubscriber.onFailure(com.facebook.datasource.AbstractDataSource.this);
                } else if (z2) {
                    dataSubscriber.onCancellation(com.facebook.datasource.AbstractDataSource.this);
                } else {
                    dataSubscriber.onNewResult(com.facebook.datasource.AbstractDataSource.this);
                }
            }
        };
        com.facebook.datasource.AbstractDataSource.DataSourceInstrumenter dataSourceInstrumenter = getDataSourceInstrumenter();
        if (dataSourceInstrumenter != null) {
            runnableDecorateRunnable = dataSourceInstrumenter.decorateRunnable(runnableDecorateRunnable, "AbstractDataSource_notifyDataSubscriber");
        }
        executor.execute(runnableDecorateRunnable);
    }

    private synchronized boolean wasCancelled() {
        return isClosed() && !isFinished();
    }

    protected boolean setResult(@javax.annotation.Nullable T t, boolean z, @javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.Object> map) {
        setExtras(map);
        boolean resultInternal = setResultInternal(t, z);
        if (resultInternal) {
            notifyDataSubscribers();
        }
        return resultInternal;
    }

    public boolean setResult(@javax.annotation.Nullable T t, boolean z) {
        return setResult(t, z, null);
    }

    protected boolean setFailure(java.lang.Throwable th) {
        return setFailure(th, null);
    }

    protected boolean setFailure(@javax.annotation.Nullable java.lang.Throwable th, @javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.Object> map) {
        boolean failureInternal = setFailureInternal(th, map);
        if (failureInternal) {
            notifyDataSubscribers();
        }
        return failureInternal;
    }

    protected boolean setProgress(float f) {
        boolean progressInternal = setProgressInternal(f);
        if (progressInternal) {
            notifyProgressUpdate();
        }
        return progressInternal;
    }

    private boolean setResultInternal(@javax.annotation.Nullable T t, boolean z) {
        T t2;
        T t3 = null;
        try {
            synchronized (this) {
                try {
                    try {
                        if (!this.mIsClosed && this.mDataSourceStatus == com.facebook.datasource.AbstractDataSource.DataSourceStatus.IN_PROGRESS) {
                            if (z) {
                                this.mDataSourceStatus = com.facebook.datasource.AbstractDataSource.DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            T t4 = this.mResult;
                            if (t4 != t) {
                                try {
                                    this.mResult = t;
                                    t2 = t4;
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    t3 = t4;
                                    throw th;
                                }
                            } else {
                                t2 = null;
                            }
                            if (t2 != null) {
                                closeResult(t2);
                            }
                            return true;
                        }
                        if (t != null) {
                            closeResult(t);
                        }
                        return false;
                    } catch (java.lang.Throwable th2) {
                        t3 = t;
                        th = th2;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
            }
        } catch (java.lang.Throwable th4) {
            if (t3 != null) {
                closeResult(t3);
            }
            throw th4;
        }
    }

    private synchronized boolean setFailureInternal(@javax.annotation.Nullable java.lang.Throwable th, @javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.Object> map) {
        if (!this.mIsClosed && this.mDataSourceStatus == com.facebook.datasource.AbstractDataSource.DataSourceStatus.IN_PROGRESS) {
            this.mDataSourceStatus = com.facebook.datasource.AbstractDataSource.DataSourceStatus.FAILURE;
            this.mFailureThrowable = th;
            this.mExtras = map;
            return true;
        }
        return false;
    }

    private synchronized boolean setProgressInternal(float f) {
        if (!this.mIsClosed && this.mDataSourceStatus == com.facebook.datasource.AbstractDataSource.DataSourceStatus.IN_PROGRESS) {
            if (f < this.mProgress) {
                return false;
            }
            this.mProgress = f;
            return true;
        }
        return false;
    }

    protected void notifyProgressUpdate() {
        for (android.util.Pair<com.facebook.datasource.DataSubscriber<T>, java.util.concurrent.Executor> pair : this.mSubscribers) {
            final com.facebook.datasource.DataSubscriber dataSubscriber = (com.facebook.datasource.DataSubscriber) pair.first;
            ((java.util.concurrent.Executor) pair.second).execute(new java.lang.Runnable() { // from class: com.facebook.datasource.AbstractDataSource.2
                @Override // java.lang.Runnable
                public void run() {
                    dataSubscriber.onProgressUpdate(com.facebook.datasource.AbstractDataSource.this);
                }
            });
        }
    }

    @javax.annotation.Nullable
    public static com.facebook.datasource.AbstractDataSource.DataSourceInstrumenter getDataSourceInstrumenter() {
        return sDataSourceInstrumenter;
    }
}
