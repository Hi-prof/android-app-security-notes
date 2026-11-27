package com.facebook.datasource;

/* JADX INFO: loaded from: classes.dex */
public class RetainingDataSourceSupplier<T> implements com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<T>> {
    private final java.util.Set<com.facebook.datasource.RetainingDataSourceSupplier.RetainingDataSource> mDataSources = java.util.Collections.newSetFromMap(new java.util.WeakHashMap());

    @javax.annotation.Nullable
    private com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<T>> mCurrentDataSourceSupplier = null;

    @Override // com.facebook.common.internal.Supplier
    public com.facebook.datasource.DataSource<T> get() {
        com.facebook.datasource.RetainingDataSourceSupplier.RetainingDataSource retainingDataSource = new com.facebook.datasource.RetainingDataSourceSupplier.RetainingDataSource();
        retainingDataSource.setSupplier(this.mCurrentDataSourceSupplier);
        this.mDataSources.add(retainingDataSource);
        return retainingDataSource;
    }

    public void replaceSupplier(com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<T>> supplier) {
        this.mCurrentDataSourceSupplier = supplier;
        for (com.facebook.datasource.RetainingDataSourceSupplier.RetainingDataSource retainingDataSource : this.mDataSources) {
            if (!retainingDataSource.isClosed()) {
                retainingDataSource.setSupplier(supplier);
            }
        }
    }

    private static class RetainingDataSource<T> extends com.facebook.datasource.AbstractDataSource<T> {

        @javax.annotation.Nullable
        private com.facebook.datasource.DataSource<T> mDataSource;

        /* JADX INFO: Access modifiers changed from: private */
        public void onDataSourceFailed() {
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean hasMultipleResults() {
            return true;
        }

        private RetainingDataSource() {
            this.mDataSource = null;
        }

        public void setSupplier(@javax.annotation.Nullable com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<T>> supplier) {
            if (isClosed()) {
                return;
            }
            com.facebook.datasource.DataSource<T> dataSource = supplier != null ? supplier.get() : null;
            synchronized (this) {
                if (isClosed()) {
                    closeSafely(dataSource);
                    return;
                }
                com.facebook.datasource.DataSource<T> dataSource2 = this.mDataSource;
                this.mDataSource = dataSource;
                if (dataSource != null) {
                    dataSource.subscribe(new com.facebook.datasource.RetainingDataSourceSupplier.RetainingDataSource.InternalDataSubscriber(), com.facebook.common.executors.CallerThreadExecutor.getInstance());
                }
                closeSafely(dataSource2);
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        @javax.annotation.Nullable
        public synchronized T getResult() {
            com.facebook.datasource.DataSource<T> dataSource;
            dataSource = this.mDataSource;
            return dataSource != null ? dataSource.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public synchronized boolean hasResult() {
            com.facebook.datasource.DataSource<T> dataSource;
            dataSource = this.mDataSource;
            return dataSource != null && dataSource.hasResult();
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean close() {
            synchronized (this) {
                if (!super.close()) {
                    return false;
                }
                com.facebook.datasource.DataSource<T> dataSource = this.mDataSource;
                this.mDataSource = null;
                closeSafely(dataSource);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDataSourceNewResult(com.facebook.datasource.DataSource<T> dataSource) {
            if (dataSource == this.mDataSource) {
                setResult(null, false, dataSource.getExtras());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDatasourceProgress(com.facebook.datasource.DataSource<T> dataSource) {
            if (dataSource == this.mDataSource) {
                setProgress(dataSource.getProgress());
            }
        }

        private static <T> void closeSafely(com.facebook.datasource.DataSource<T> dataSource) {
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
            public void onNewResult(com.facebook.datasource.DataSource<T> dataSource) {
                if (dataSource.hasResult()) {
                    com.facebook.datasource.RetainingDataSourceSupplier.RetainingDataSource.this.onDataSourceNewResult(dataSource);
                } else if (dataSource.isFinished()) {
                    com.facebook.datasource.RetainingDataSourceSupplier.RetainingDataSource.this.onDataSourceFailed();
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(com.facebook.datasource.DataSource<T> dataSource) {
                com.facebook.datasource.RetainingDataSourceSupplier.RetainingDataSource.this.onDataSourceFailed();
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(com.facebook.datasource.DataSource<T> dataSource) {
                com.facebook.datasource.RetainingDataSourceSupplier.RetainingDataSource.this.onDatasourceProgress(dataSource);
            }
        }
    }
}
