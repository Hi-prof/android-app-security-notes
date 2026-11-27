package com.facebook.datasource;

/* JADX INFO: loaded from: classes.dex */
public class IncreasingQualityDataSourceSupplier<T> implements com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<T>> {
    private final boolean mDataSourceLazy;
    private final java.util.List<com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<T>>> mDataSourceSuppliers;

    private IncreasingQualityDataSourceSupplier(java.util.List<com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<T>>> list, boolean z) {
        com.facebook.common.internal.Preconditions.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.mDataSourceSuppliers = list;
        this.mDataSourceLazy = z;
    }

    public static <T> com.facebook.datasource.IncreasingQualityDataSourceSupplier<T> create(java.util.List<com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<T>>> list) {
        return create(list, false);
    }

    public static <T> com.facebook.datasource.IncreasingQualityDataSourceSupplier<T> create(java.util.List<com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<T>>> list, boolean z) {
        return new com.facebook.datasource.IncreasingQualityDataSourceSupplier<>(list, z);
    }

    @Override // com.facebook.common.internal.Supplier
    public com.facebook.datasource.DataSource<T> get() {
        return new com.facebook.datasource.IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource();
    }

    public int hashCode() {
        return this.mDataSourceSuppliers.hashCode();
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof com.facebook.datasource.IncreasingQualityDataSourceSupplier) {
            return com.facebook.common.internal.Objects.equal(this.mDataSourceSuppliers, ((com.facebook.datasource.IncreasingQualityDataSourceSupplier) obj).mDataSourceSuppliers);
        }
        return false;
    }

    public java.lang.String toString() {
        return com.facebook.common.internal.Objects.toStringHelper(this).add(com.taobao.weex.ui.component.WXBasicComponentType.LIST, this.mDataSourceSuppliers).toString();
    }

    private class IncreasingQualityDataSource extends com.facebook.datasource.AbstractDataSource<T> {

        @javax.annotation.Nullable
        private java.util.ArrayList<com.facebook.datasource.DataSource<T>> mDataSources;

        @javax.annotation.Nullable
        private java.lang.Throwable mDelayedError;

        @javax.annotation.Nullable
        private java.util.Map<java.lang.String, java.lang.Object> mDelayedExtras;
        private java.util.concurrent.atomic.AtomicInteger mFinishedDataSources;
        private int mIndexOfDataSourceWithResult;
        private int mNumberOfDataSources;

        public IncreasingQualityDataSource() {
            if (com.facebook.datasource.IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                return;
            }
            ensureDataSourceInitialized();
        }

        private void ensureDataSourceInitialized() {
            if (this.mFinishedDataSources != null) {
                return;
            }
            synchronized (this) {
                if (this.mFinishedDataSources == null) {
                    this.mFinishedDataSources = new java.util.concurrent.atomic.AtomicInteger(0);
                    int size = com.facebook.datasource.IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.size();
                    this.mNumberOfDataSources = size;
                    this.mIndexOfDataSourceWithResult = size;
                    this.mDataSources = new java.util.ArrayList<>(size);
                    for (int i = 0; i < size; i++) {
                        com.facebook.datasource.DataSource<T> dataSource = (com.facebook.datasource.DataSource) ((com.facebook.common.internal.Supplier) com.facebook.datasource.IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.get(i)).get();
                        this.mDataSources.add(dataSource);
                        dataSource.subscribe(new com.facebook.datasource.IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.InternalDataSubscriber(i), com.facebook.common.executors.CallerThreadExecutor.getInstance());
                        if (dataSource.hasResult()) {
                            break;
                        }
                    }
                }
            }
        }

        @javax.annotation.Nullable
        private synchronized com.facebook.datasource.DataSource<T> getDataSource(int i) {
            java.util.ArrayList<com.facebook.datasource.DataSource<T>> arrayList;
            arrayList = this.mDataSources;
            return (arrayList == null || i >= arrayList.size()) ? null : this.mDataSources.get(i);
        }

        @javax.annotation.Nullable
        private synchronized com.facebook.datasource.DataSource<T> getAndClearDataSource(int i) {
            com.facebook.datasource.DataSource<T> dataSource;
            java.util.ArrayList<com.facebook.datasource.DataSource<T>> arrayList = this.mDataSources;
            dataSource = null;
            if (arrayList != null && i < arrayList.size()) {
                dataSource = this.mDataSources.set(i, null);
            }
            return dataSource;
        }

        @javax.annotation.Nullable
        private synchronized com.facebook.datasource.DataSource<T> getDataSourceWithResult() {
            return getDataSource(this.mIndexOfDataSourceWithResult);
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        @javax.annotation.Nullable
        public synchronized T getResult() {
            com.facebook.datasource.DataSource<T> dataSourceWithResult;
            if (com.facebook.datasource.IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                ensureDataSourceInitialized();
            }
            dataSourceWithResult = getDataSourceWithResult();
            return dataSourceWithResult != null ? dataSourceWithResult.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public synchronized boolean hasResult() {
            com.facebook.datasource.DataSource<T> dataSourceWithResult;
            if (com.facebook.datasource.IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                ensureDataSourceInitialized();
            }
            dataSourceWithResult = getDataSourceWithResult();
            return dataSourceWithResult != null && dataSourceWithResult.hasResult();
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean close() {
            if (com.facebook.datasource.IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                ensureDataSourceInitialized();
            }
            synchronized (this) {
                if (!super.close()) {
                    return false;
                }
                java.util.ArrayList<com.facebook.datasource.DataSource<T>> arrayList = this.mDataSources;
                this.mDataSources = null;
                if (arrayList == null) {
                    return true;
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    closeSafely(arrayList.get(i));
                }
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDataSourceNewResult(int i, com.facebook.datasource.DataSource<T> dataSource) {
            maybeSetIndexOfDataSourceWithResult(i, dataSource, dataSource.isFinished());
            if (dataSource == getDataSourceWithResult()) {
                setResult(null, i == 0 && dataSource.isFinished(), dataSource.getExtras());
            }
            maybeSetFailure();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDataSourceFailed(int i, com.facebook.datasource.DataSource<T> dataSource) {
            closeSafely(tryGetAndClearDataSource(i, dataSource));
            if (i == 0) {
                this.mDelayedError = dataSource.getFailureCause();
                this.mDelayedExtras = dataSource.getExtras();
            }
            maybeSetFailure();
        }

        private void maybeSetFailure() {
            java.lang.Throwable th;
            if (this.mFinishedDataSources.incrementAndGet() != this.mNumberOfDataSources || (th = this.mDelayedError) == null) {
                return;
            }
            setFailure(th, this.mDelayedExtras);
        }

        private void maybeSetIndexOfDataSourceWithResult(int i, com.facebook.datasource.DataSource<T> dataSource, boolean z) {
            synchronized (this) {
                int i2 = this.mIndexOfDataSourceWithResult;
                if (dataSource == getDataSource(i) && i != this.mIndexOfDataSourceWithResult) {
                    if (getDataSourceWithResult() == null || (z && i < this.mIndexOfDataSourceWithResult)) {
                        this.mIndexOfDataSourceWithResult = i;
                    } else {
                        i = i2;
                    }
                    while (i2 > i) {
                        closeSafely(getAndClearDataSource(i2));
                        i2--;
                    }
                }
            }
        }

        @javax.annotation.Nullable
        private synchronized com.facebook.datasource.DataSource<T> tryGetAndClearDataSource(int i, com.facebook.datasource.DataSource<T> dataSource) {
            if (dataSource == getDataSourceWithResult()) {
                return null;
            }
            if (dataSource != getDataSource(i)) {
                return dataSource;
            }
            return getAndClearDataSource(i);
        }

        private void closeSafely(com.facebook.datasource.DataSource<T> dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
        }

        private class InternalDataSubscriber implements com.facebook.datasource.DataSubscriber<T> {
            private int mIndex;

            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(com.facebook.datasource.DataSource<T> dataSource) {
            }

            public InternalDataSubscriber(int i) {
                this.mIndex = i;
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onNewResult(com.facebook.datasource.DataSource<T> dataSource) {
                if (dataSource.hasResult()) {
                    com.facebook.datasource.IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.onDataSourceNewResult(this.mIndex, dataSource);
                } else if (dataSource.isFinished()) {
                    com.facebook.datasource.IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.onDataSourceFailed(this.mIndex, dataSource);
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(com.facebook.datasource.DataSource<T> dataSource) {
                com.facebook.datasource.IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.onDataSourceFailed(this.mIndex, dataSource);
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(com.facebook.datasource.DataSource<T> dataSource) {
                if (this.mIndex == 0) {
                    com.facebook.datasource.IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.setProgress(dataSource.getProgress());
                }
            }
        }
    }
}
