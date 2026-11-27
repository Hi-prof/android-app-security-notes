package com.facebook.datasource;

/* JADX INFO: loaded from: classes.dex */
public class FirstAvailableDataSourceSupplier<T> implements com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<T>> {
    private final java.util.List<com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<T>>> mDataSourceSuppliers;

    private FirstAvailableDataSourceSupplier(java.util.List<com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<T>>> list) {
        com.facebook.common.internal.Preconditions.checkArgument(!list.isEmpty(), "List of suppliers is empty!");
        this.mDataSourceSuppliers = list;
    }

    public static <T> com.facebook.datasource.FirstAvailableDataSourceSupplier<T> create(java.util.List<com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<T>>> list) {
        return new com.facebook.datasource.FirstAvailableDataSourceSupplier<>(list);
    }

    @Override // com.facebook.common.internal.Supplier
    public com.facebook.datasource.DataSource<T> get() {
        return new com.facebook.datasource.FirstAvailableDataSourceSupplier.FirstAvailableDataSource();
    }

    public int hashCode() {
        return this.mDataSourceSuppliers.hashCode();
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof com.facebook.datasource.FirstAvailableDataSourceSupplier) {
            return com.facebook.common.internal.Objects.equal(this.mDataSourceSuppliers, ((com.facebook.datasource.FirstAvailableDataSourceSupplier) obj).mDataSourceSuppliers);
        }
        return false;
    }

    public java.lang.String toString() {
        return com.facebook.common.internal.Objects.toStringHelper(this).add(com.taobao.weex.ui.component.WXBasicComponentType.LIST, this.mDataSourceSuppliers).toString();
    }

    private class FirstAvailableDataSource extends com.facebook.datasource.AbstractDataSource<T> {
        private int mIndex = 0;

        @javax.annotation.Nullable
        private com.facebook.datasource.DataSource<T> mCurrentDataSource = null;

        @javax.annotation.Nullable
        private com.facebook.datasource.DataSource<T> mDataSourceWithResult = null;

        public FirstAvailableDataSource() {
            if (startNextDataSource()) {
                return;
            }
            setFailure(new java.lang.RuntimeException("No data source supplier or supplier returned null."));
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        @javax.annotation.Nullable
        public synchronized T getResult() {
            com.facebook.datasource.DataSource<T> dataSourceWithResult;
            dataSourceWithResult = getDataSourceWithResult();
            return dataSourceWithResult != null ? dataSourceWithResult.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public synchronized boolean hasResult() {
            com.facebook.datasource.DataSource<T> dataSourceWithResult;
            dataSourceWithResult = getDataSourceWithResult();
            return dataSourceWithResult != null && dataSourceWithResult.hasResult();
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean close() {
            synchronized (this) {
                if (!super.close()) {
                    return false;
                }
                com.facebook.datasource.DataSource<T> dataSource = this.mCurrentDataSource;
                this.mCurrentDataSource = null;
                com.facebook.datasource.DataSource<T> dataSource2 = this.mDataSourceWithResult;
                this.mDataSourceWithResult = null;
                closeSafely(dataSource2);
                closeSafely(dataSource);
                return true;
            }
        }

        private boolean startNextDataSource() {
            com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<T>> nextSupplier = getNextSupplier();
            com.facebook.datasource.DataSource<T> dataSource = nextSupplier != null ? nextSupplier.get() : null;
            if (setCurrentDataSource(dataSource) && dataSource != null) {
                dataSource.subscribe(new com.facebook.datasource.FirstAvailableDataSourceSupplier.FirstAvailableDataSource.InternalDataSubscriber(), com.facebook.common.executors.CallerThreadExecutor.getInstance());
                return true;
            }
            closeSafely(dataSource);
            return false;
        }

        @javax.annotation.Nullable
        private synchronized com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<T>> getNextSupplier() {
            if (isClosed() || this.mIndex >= com.facebook.datasource.FirstAvailableDataSourceSupplier.this.mDataSourceSuppliers.size()) {
                return null;
            }
            java.util.List list = com.facebook.datasource.FirstAvailableDataSourceSupplier.this.mDataSourceSuppliers;
            int i = this.mIndex;
            this.mIndex = i + 1;
            return (com.facebook.common.internal.Supplier) list.get(i);
        }

        private synchronized boolean setCurrentDataSource(com.facebook.datasource.DataSource<T> dataSource) {
            if (isClosed()) {
                return false;
            }
            this.mCurrentDataSource = dataSource;
            return true;
        }

        private synchronized boolean clearCurrentDataSource(com.facebook.datasource.DataSource<T> dataSource) {
            if (!isClosed() && dataSource == this.mCurrentDataSource) {
                this.mCurrentDataSource = null;
                return true;
            }
            return false;
        }

        @javax.annotation.Nullable
        private synchronized com.facebook.datasource.DataSource<T> getDataSourceWithResult() {
            return this.mDataSourceWithResult;
        }

        private void maybeSetDataSourceWithResult(com.facebook.datasource.DataSource<T> dataSource, boolean z) {
            com.facebook.datasource.DataSource<T> dataSource2;
            synchronized (this) {
                if (dataSource == this.mCurrentDataSource && dataSource != (dataSource2 = this.mDataSourceWithResult)) {
                    if (dataSource2 == null || z) {
                        this.mDataSourceWithResult = dataSource;
                    } else {
                        dataSource2 = null;
                    }
                    closeSafely(dataSource2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDataSourceFailed(com.facebook.datasource.DataSource<T> dataSource) {
            if (clearCurrentDataSource(dataSource)) {
                if (dataSource != getDataSourceWithResult()) {
                    closeSafely(dataSource);
                }
                if (startNextDataSource()) {
                    return;
                }
                setFailure(dataSource.getFailureCause(), dataSource.getExtras());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDataSourceNewResult(com.facebook.datasource.DataSource<T> dataSource) {
            maybeSetDataSourceWithResult(dataSource, dataSource.isFinished());
            if (dataSource == getDataSourceWithResult()) {
                setResult(null, dataSource.isFinished(), dataSource.getExtras());
            }
        }

        private void closeSafely(@javax.annotation.Nullable com.facebook.datasource.DataSource<T> dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
        }

        private class InternalDataSubscriber implements com.facebook.datasource.DataSubscriber<T> {
            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(com.facebook.datasource.DataSource<T> dataSource) {
            }

            private InternalDataSubscriber() {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(com.facebook.datasource.DataSource<T> dataSource) {
                com.facebook.datasource.FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.onDataSourceFailed(dataSource);
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onNewResult(com.facebook.datasource.DataSource<T> dataSource) {
                if (dataSource.hasResult()) {
                    com.facebook.datasource.FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.onDataSourceNewResult(dataSource);
                } else if (dataSource.isFinished()) {
                    com.facebook.datasource.FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.onDataSourceFailed(dataSource);
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(com.facebook.datasource.DataSource<T> dataSource) {
                com.facebook.datasource.FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.setProgress(java.lang.Math.max(com.facebook.datasource.FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.getProgress(), dataSource.getProgress()));
            }
        }
    }
}
