package com.facebook.datasource;

/* JADX INFO: loaded from: classes.dex */
public interface DataSubscriber<T> {
    void onCancellation(@javax.annotation.Nonnull com.facebook.datasource.DataSource<T> dataSource);

    void onFailure(@javax.annotation.Nonnull com.facebook.datasource.DataSource<T> dataSource);

    void onNewResult(@javax.annotation.Nonnull com.facebook.datasource.DataSource<T> dataSource);

    void onProgressUpdate(@javax.annotation.Nonnull com.facebook.datasource.DataSource<T> dataSource);
}
