package com.facebook.imagepipeline.datasource;

/* JADX INFO: loaded from: classes.dex */
public class ListDataSource<T> extends com.facebook.datasource.AbstractDataSource<java.util.List<com.facebook.common.references.CloseableReference<T>>> {
    private final com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>>[] mDataSources;
    private int mFinishedDataSources = 0;

    protected ListDataSource(com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>>[] dataSourceArr) {
        this.mDataSources = dataSourceArr;
    }

    public static <T> com.facebook.imagepipeline.datasource.ListDataSource<T> create(com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>>... dataSourceArr) {
        com.facebook.common.internal.Preconditions.checkNotNull(dataSourceArr);
        com.facebook.common.internal.Preconditions.checkState(dataSourceArr.length > 0);
        com.facebook.imagepipeline.datasource.ListDataSource<T> listDataSource = new com.facebook.imagepipeline.datasource.ListDataSource<>(dataSourceArr);
        for (com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>> dataSource : dataSourceArr) {
            if (dataSource != null) {
                dataSource.subscribe(new com.facebook.imagepipeline.datasource.ListDataSource.InternalDataSubscriber(), com.facebook.common.executors.CallerThreadExecutor.getInstance());
            }
        }
        return listDataSource;
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    @javax.annotation.Nullable
    public synchronized java.util.List<com.facebook.common.references.CloseableReference<T>> getResult() {
        if (!hasResult()) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(this.mDataSources.length);
        for (com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>> dataSource : this.mDataSources) {
            arrayList.add(dataSource.getResult());
        }
        return arrayList;
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public synchronized boolean hasResult() {
        return !isClosed() && this.mFinishedDataSources == this.mDataSources.length;
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public boolean close() {
        if (!super.close()) {
            return false;
        }
        for (com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>> dataSource : this.mDataSources) {
            dataSource.close();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataSourceFinished() {
        if (increaseAndCheckIfLast()) {
            setResult(null, true, null);
        }
    }

    private synchronized boolean increaseAndCheckIfLast() {
        int i;
        i = this.mFinishedDataSources + 1;
        this.mFinishedDataSources = i;
        return i == this.mDataSources.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataSourceFailed(com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>> dataSource) {
        java.lang.Throwable failureCause = dataSource.getFailureCause();
        if (failureCause == null) {
            failureCause = new java.lang.Throwable("Unknown failure cause");
        }
        setFailure(failureCause);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataSourceCancelled() {
        setFailure(new java.util.concurrent.CancellationException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataSourceProgress() {
        float progress = 0.0f;
        for (com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>> dataSource : this.mDataSources) {
            progress += dataSource.getProgress();
        }
        setProgress(progress / this.mDataSources.length);
    }

    private class InternalDataSubscriber implements com.facebook.datasource.DataSubscriber<com.facebook.common.references.CloseableReference<T>> {
        boolean mFinished;

        private InternalDataSubscriber() {
            this.mFinished = false;
        }

        private synchronized boolean tryFinish() {
            if (this.mFinished) {
                return false;
            }
            this.mFinished = true;
            return true;
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onFailure(com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>> dataSource) {
            com.facebook.imagepipeline.datasource.ListDataSource.this.onDataSourceFailed(dataSource);
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onCancellation(com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>> dataSource) {
            com.facebook.imagepipeline.datasource.ListDataSource.this.onDataSourceCancelled();
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onNewResult(com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>> dataSource) {
            if (dataSource.isFinished() && tryFinish()) {
                com.facebook.imagepipeline.datasource.ListDataSource.this.onDataSourceFinished();
            }
        }

        @Override // com.facebook.datasource.DataSubscriber
        public void onProgressUpdate(com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>> dataSource) {
            com.facebook.imagepipeline.datasource.ListDataSource.this.onDataSourceProgress();
        }
    }
}
