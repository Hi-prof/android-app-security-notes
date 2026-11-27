package com.facebook.datasource;

/* JADX INFO: loaded from: classes.dex */
public class DataSources {
    private DataSources() {
    }

    public static <T> com.facebook.datasource.DataSource<T> immediateFailedDataSource(java.lang.Throwable th) {
        com.facebook.datasource.SimpleDataSource simpleDataSourceCreate = com.facebook.datasource.SimpleDataSource.create();
        simpleDataSourceCreate.setFailure(th);
        return simpleDataSourceCreate;
    }

    public static <T> com.facebook.datasource.DataSource<T> immediateDataSource(T t) {
        com.facebook.datasource.SimpleDataSource simpleDataSourceCreate = com.facebook.datasource.SimpleDataSource.create();
        simpleDataSourceCreate.setResult(t);
        return simpleDataSourceCreate;
    }

    public static com.facebook.datasource.DataSource<java.lang.Void> immediateSuccessfulDataSource() {
        return com.facebook.datasource.SuccessfulVoidDataSource.INSTANCE;
    }

    public static <T> com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<T>> getFailedDataSourceSupplier(final java.lang.Throwable th) {
        return new com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<T>>() { // from class: com.facebook.datasource.DataSources.1
            @Override // com.facebook.common.internal.Supplier
            public com.facebook.datasource.DataSource<T> get() {
                return com.facebook.datasource.DataSources.immediateFailedDataSource(th);
            }
        };
    }

    @javax.annotation.Nullable
    public static <T> T waitForFinalResult(com.facebook.datasource.DataSource<T> dataSource) throws java.lang.Throwable {
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        final com.facebook.datasource.DataSources.ValueHolder valueHolder = new com.facebook.datasource.DataSources.ValueHolder();
        final com.facebook.datasource.DataSources.ValueHolder valueHolder2 = new com.facebook.datasource.DataSources.ValueHolder();
        dataSource.subscribe(new com.facebook.datasource.DataSubscriber<T>() { // from class: com.facebook.datasource.DataSources.2
            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(com.facebook.datasource.DataSource<T> dataSource2) {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onNewResult(com.facebook.datasource.DataSource<T> dataSource2) {
                if (dataSource2.isFinished()) {
                    try {
                        valueHolder.value = dataSource2.getResult();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(com.facebook.datasource.DataSource<T> dataSource2) {
                try {
                    valueHolder2.value = (T) dataSource2.getFailureCause();
                } finally {
                    countDownLatch.countDown();
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(com.facebook.datasource.DataSource<T> dataSource2) {
                countDownLatch.countDown();
            }
        }, new java.util.concurrent.Executor() { // from class: com.facebook.datasource.DataSources.3
            @Override // java.util.concurrent.Executor
            public void execute(java.lang.Runnable runnable) {
                runnable.run();
            }
        });
        countDownLatch.await();
        if (valueHolder2.value != null) {
            throw ((java.lang.Throwable) valueHolder2.value);
        }
        return valueHolder.value;
    }

    private static class ValueHolder<T> {

        @javax.annotation.Nullable
        public T value;

        private ValueHolder() {
            this.value = null;
        }
    }
}
