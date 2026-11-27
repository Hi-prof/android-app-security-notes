package com.facebook.datasource;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseDataSubscriber<T> implements com.facebook.datasource.DataSubscriber<T> {
    @Override // com.facebook.datasource.DataSubscriber
    public void onCancellation(@javax.annotation.Nonnull com.facebook.datasource.DataSource<T> dataSource) {
    }

    protected abstract void onFailureImpl(@javax.annotation.Nonnull com.facebook.datasource.DataSource<T> dataSource);

    protected abstract void onNewResultImpl(@javax.annotation.Nonnull com.facebook.datasource.DataSource<T> dataSource);

    @Override // com.facebook.datasource.DataSubscriber
    public void onProgressUpdate(@javax.annotation.Nonnull com.facebook.datasource.DataSource<T> dataSource) {
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onNewResult(@javax.annotation.Nonnull com.facebook.datasource.DataSource<T> dataSource) {
        boolean zIsFinished = dataSource.isFinished();
        try {
            onNewResultImpl(dataSource);
        } finally {
            if (zIsFinished) {
                dataSource.close();
            }
        }
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onFailure(@javax.annotation.Nonnull com.facebook.datasource.DataSource<T> dataSource) {
        try {
            onFailureImpl(dataSource);
        } finally {
            dataSource.close();
        }
    }
}
